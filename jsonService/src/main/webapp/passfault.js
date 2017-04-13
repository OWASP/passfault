var passfault = new Object();

//initializes the default policy, found in policy.json.
passfault.init = function (selectCracker, selectProtection) {
   $.getJSON("policy.json").done(function (data){
  	 passfault.policy = data;
  	 passfault.time2crackMinDays = data.time2crackMinDays;
     if (selectCracker != null) passfault.loadSelectCracker(selectCracker);
     if (selectProtection != null) passfault.loadSelectProtection(selectProtection);
   });
 }

passfault.cracker = {
  //data gathered from oclhashcat: http://hashcat.net/oclhashcat/#performance
  //number of hashes per second
  "BCRYPT": 259.000,
  "MD4": 1/3224000,
  "MD5": 1/2414000,
  "SHA1": 1/2510000,
  "SHA512": 1/114000,
  "SHA3": 1/175000,
  "NTLM": 1/20109000,
  "LM": 1/1285000,
  "NetNTLMv2": 1/555000
};

passfault.protection = {
	"WINDOWS_NTLM": {
	  "display": "Microsoft Windows NT Lan Manager",
		"cracker": "NTLM",
		"iterations": 1
	},
	"WINDOWS_LM": {
	  "display": "Microsoft Windows Lan Manager (Old)",
		"cracker": "LM",
		"iterations": 1
	},
	"WINDOWS_NetNTLMv2": {
	  "display": "Microsoft Windows NTLM 2",
		"cracker": "NetNTLMv2",
		"iterations": 1
	},
	"SHA1": {
	  "display": "SHA1 (Old school)",
		"cracker": "SHA1",
		"iterations": 1
	},
	"SHA512x1": {
	  "display": "SHA512 (Old School)",
		"cracker": "SHA512",
		"iterations": 1
	},
	"SHA512x100k": {
	  "display": "SHA512 hashed 100k times",
		"cracker": "SHA512",
		"iterations": 100000
	},
	"UNIX_BCRYPT": {
	  "display": "Unix BCrypt Hash",
		"cracker": "BCRYPT",
		"iterations": 1
	},
	"WPA": {
	  "display": "WPA Password Hashing",
		"cracker": "SHA1",
		"iterations": 4096
	}
};

passfault.loadSelectProtection = function (select){
  var htmlToInsert;
  for(var type in this.protection){
		if (this.policy.algorithm && this.policy.algorithm == type) {
			htmlToInsert += '<option value="'+type+'" selected>'+ passfault.protection[type].display + '</option>';
		} else {
      htmlToInsert += '<option value="'+type+'" >'+ passfault.protection[type].display + '</option>';
		}
  }
  select.html(htmlToInsert);
}

passfault.attacker = {
	"EVERYDAY":{
		"display": "Everyday Computer",
		"multiplier": 1
	},"5K": {
		"display": "Dedicated Cracker ($5,000 machine)",
		"multiplier": 10  //assuming 10 GPU cards
	},"50K": {
		"display": "Organized Crime Cracker ($50,000 machine)",
		"multiplier": 100 //assuming 100 GPU cards
	},"500K":{
		"display": "Government cracker ($500,000 machine)",
		"multiplier": 1000
	}
};

passfault.loadSelectCracker = function (select){
  var htmlToInsert;
  for(var cracker in this.attacker){
		if (this.policy.cracker && this.policy.cracker == cracker) {
    	htmlToInsert += '<option value="' + cracker + '" selected>' + this.attacker[cracker].display + '</option>';
		} else {
			htmlToInsert += '<option value="' + cracker + '" >' + this.attacker[cracker].display + '</option>';
		}
  }
  select.html(htmlToInsert);
}


passfault.patternImages = {
  "LEET": "leet.gif",
  "SUBSTITUTE": "subs.gif",
  "MISSPELL": "miss.gif",
  "WORD": "word.gif",
  "INSERTION": "ins.gif",
  "DUPLICATE": "dup.gif",
  "DIAGONAL": "diag.gif",
  "HORIZONTAL": "horiz.gif",
  "REPEATED": "repeat.gif",
  "RANDOM": "random.gif"
};

passfault.patternDescription = {
  "LEET": "A word was found with some 'leet substituted characters.  Leet is short for \"elite\".  It is a way of encoding characters with numbers and special characters. Such as 1 for the letter 'l', for example, leet is spelled 133+.",
  "SUBSTITUTE": "A word was found with some characters substituted by special characters or numbers",
  "MISSPELL": "A misspelled word was found",
  "WORD": "A word was found.  To add more complexity, consider misspelling a word or inserting characters into a word",
  "INSERTION": "A word was found with some extra characters inserted.",
  "DUPLICATE": "The same pattern was found previously.",
  "DIAGONAL": "A diagonal sequence of keys was identified.  This is the weakest type of password pattern.",
  "HORIZONTAL": "A horizontal sequence of keys was identified.  This is the weakest type of password pattern. ",
  "REPEATED": "Repeat characters were found.  This is an extremly weak type of password pattern.  ",
  "RANDOM": "No pattern was found.  This part of the pattern increases in strength by using many different types of characters, such as upper-case, lower-case, latin, cyrillic, numbers, or other special characers."
};

String.prototype.supplant = function (o) {
    return this.replace(/{([^{}]*)}/g,
        function (a, b) {
            var r = o[b]+"";
            return typeof r === 'string' ?
                r : a;
        }
    );
};

passfault.toggleDetailVisible = function (id){
	if( $("#"+id).is(':visible') ) {
		$("#"+id).hide();
	} else {
		$("div.patternDetail").hide();
		$("#"+id).show();
		window.scrollTo(0,document.body.scrollHeight);
	}
}

passfault.passwordPatternTemplate =
'<div class="sign white pattern clickable" onClick="passfault.toggleDetailVisible(\'{id}\')" >'+
	'<div class="normal"><label title="Found Pattern"/>{name}</div>' +
	'<div class="small"><label title="Pattern Classification"/>{classification}</div>' +
	'<div class="xxlarge">{percent}%</div>' +
	'<div class="xsmall">of total strength</div>' +
'</div>';

passfault.patternDetailTemplate =
'<div class="sign blue center patternDetail" id={id}>'+
	'<div class="normal"><label>Found Pattern: </label>{name}</div>' +
	'<div class="small"><label>Description: </label>{description} <br/>{detail}</div>' +
	'<div class="normal"><label>Number of passwords in pattern: </label></div>'+
	'<div class="large">{patternSizeRounded}</div>' +
	'<div class="small"><label>Pattern Classification: </label>{classification}</div>' +
	'<div class="normal"><label>Matches </label>\'{matchString}\'</div>' +
'</div>';

passfault.patternSummaryTemplate =
'<div class="sign {color} passSummary">'+
	'<div class="large">{allowedString}</div>'+
	'<div class="normal"><label>Time To Crack:</label></div><div id="timeToCrack" class="xxlarge">{timeToCrack}</div>'+
	'<div class="normal"><label>Total Passwords in Pattern: </label><div class="large">{totalCostRounded}</div></div>';

passfault.calculateTotal = function (analysis){
	var total = 0;
	for(pIndex in analysis.patterns){
		var pattern = analysis.patterns[pIndex];
		total += pattern.patternSize;
	}
	return total;
}

passfault.applyTemplate = function (div, analysis, passlength){
	analysis.totalCostRounded = this.getRoundedSizeString(analysis.cost);
	analysis.timeToCrack = this.time2Crack(analysis.cost, $('#attacker').val(), $('#hasher').val());
	var timeToCrackMilliseconds = this.timeToCrackMilliseconds(analysis.cost, $('#attacker').val(), $('#hasher').val());
  var timeToCrackDays = timeToCrackMilliseconds / 1000 / 60 / 60 / 24;
	if(timeToCrackDays > this.time2crackMinDays){
		analysis.color = "green";
		analysis.allowedString = "";
	} else {
		analysis.color = "orange";
		analysis.allowedString = "This password needs more strength";
	}

	var analysisHtml = this.patternSummaryTemplate.supplant(analysis);
	var pattern;
	for(var pIndex=0,len=analysis.patterns.length ; pIndex<len; pIndex++){
		pattern = analysis.patterns[pIndex];
		if (pattern.classification == "null")
			pattern.classification = "&emsp;";
		pattern.name = pattern.name.replace("_", " ");
		pattern.percent = Math.round(pattern.patternSize / this.calculateTotal(analysis) * 100);
		pattern.id="pattern"+pIndex;
		analysisHtml += this.passwordPatternTemplate.supplant(pattern);
	}
	for(pIndex=0,len=analysis.patterns.length ; pIndex<len; pIndex++){
		pattern = analysis.patterns[pIndex];
		pattern.patternSizeRounded = this.getRoundedSizeString(pattern.patternSize);
		pattern.detail = this.patternDescription[pattern.name];
		analysisHtml += this.patternDetailTemplate.supplant(pattern);
	}
	analysisHtml +='</div>';
	div.innerHTML = analysisHtml;

	var summaryWidth = $("div.passSummary").width();
	$("div.patternDetail").width(summaryWidth-25);
}

passfault.getRoundedSizeString = function (size) {
    var rounded = size;
    var rounds = 0;
    for (rounds = 0; rounded >= 1000; rounds++) {
      rounded = rounded / 1000;
    }
    rounded = Math.round(rounded);
    var sizeString = ""+rounded;
    var types = [
      "", "Thousand", "Million", "Billion", "Trillion", "Quadrillion", "Quintillion",
      "Sextillion", "Septillion", "Octillion", "Nonillion", "Decillion"];

    if (rounds + 1 > types.length) {
      for (var i = types.length; i <= rounds; i++) {
        sizeString+=",000";
      }
      sizeString+=' ';
      sizeString+=types[types.length - 1];
    } else {
      sizeString+=' ';
      sizeString+=types[rounds];
    }
    return sizeString;
  }

passfault.time2Crack = function (words, attacker_type, protection_type){
	return this.timeToCrack(words,
			this.cracker[this.protection[protection_type].cracker],
			this.attacker[attacker_type].multiplier,
			this.protection[protection_type].iterations);
}

passfault.timeToCrackMilliseconds = function (words, attacker_type, protection_type){

	timePerPass = this.cracker[this.protection[protection_type].cracker];
	numProcs = this.attacker[attacker_type].multiplier;
	iterations = this.protection[protection_type].iterations;

	var millis = timePerPass * iterations / numProcs;
	return days = words * millis;
}

passfault.timeToCrack = function (words, timePerPass, numProcs, iterations){
	var millis = timePerPass * iterations / numProcs;
	var milliseconds = words * millis;

	var days = Math.round(milliseconds / 1000 / 60 / 60 / 24);
    var months = Math.round(milliseconds / 1000 / 60 / 60 / 24 / 30);
    var years = Math.round(milliseconds / 1000 / 60 / 60 / 24 / 365);
    var decades = Math.round(years / 10);
    var centuries = Math.round(years / 100);
    var remainderMonths = months % 12;
    var remainderDays = days % 30;
    var remainderYears = years % 10;
    var remainderDecades = decades % 10;

    var buf = "";

    if (centuries > 0) {
      remainderYears = 0;  //don't show years if centuries are shown
      buf+=centuries;
      if (centuries == 1) {
        buf+=" century";
      } else {
        buf+=" centuries";
      }
      if (remainderDecades > 0 && centuries < 10) {
        buf+=", ";
      }
    }
    if (remainderDecades > 0 && centuries < 10) {
      remainderMonths = 0; //don't show months if decades are shown
      buf+=remainderDecades;
      buf+=" decade";
      if (remainderDecades > 1) {
        buf+='s';
      }
      if (remainderYears > 0 && decades < 10) {
        buf+=", ";
      }
    }
    if (remainderYears > 0 && decades < 10) {
      remainderDays = 0; //don't show days if years are shown
      buf+=remainderYears;
      buf+=" year";
      if (remainderYears > 1) {
        buf+='s';
      }
      if (remainderMonths > 0 && years < 10) {
        buf+=", ";
      }
    }
    if (remainderMonths > 0 && years < 10) {
      buf+=remainderMonths;
      buf+=" month";
      if (remainderMonths > 1) {
        buf+='s';
      }
      if (remainderDays > 0 && years == 0) {
        buf+=", ";
      }
    }
    if (remainderDays > 0 && years < 1) {
      buf+=remainderDays;
      buf+=" day";
      if (remainderDays > 1) {
        buf+='s';
      }
    }
    if (remainderDays == 0 && remainderMonths == 0 && years == 0) {
      buf+="less than 1 day";
    }
    return buf;
  }

passfault.submitPassword = function (){ //submit to applet or service
	var applet = false;

	var password = document.getElementById("password").value;
	$.ajax({
			  type: 'POST',
			  url: 'analysis',
			  data: password,
			  contentType: 'text',
			  success: function(results) {
					$("div.goneOnAnalyze").hide();
				  	passfault.applyTemplate(document.getElementById("patterns"), results);
			  },
			  error: function(jqXHR, textStatus, errorThrown) {
				  alert('An error ocurred analyzing: '+errorThrown);
			  },
			  dataType: 'json'
   });

}
