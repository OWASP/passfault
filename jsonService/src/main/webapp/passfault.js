var cracker = new Object(); //milliseconds with one graphics card based on oclhashcat 
cracker.BCRYPT = 259.000;   
cracker.MD4    = 1/3224000;
cracker.MD5    = 1/2414000;
cracker.SHA1   = 1/2510000;
cracker.SHA512 = 1/114000;
cracker.SHA3   = 1/175000;
cracker.NTLM   = 1/20109000;
cracker.LM     = 1/1285000;
cracker.NetNTLMv2 = 1/555000;

var threshold = 31*24*60*60;  //31 days in milliseconds;
var protection = {
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

function loadSelectProtection(select){
  var htmlToInsert;
  for(var type in protection){
      htmlToInsert += '<option value="'+type+'" >'+ protection[type].display + '</option>';
  }
  select.html(htmlToInsert);
}

var attacker = {
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

function loadSelectCracker(select){
  var htmlToInsert;
  for(var cracker in attacker){
    htmlToInsert += '<option value="' + cracker + '" >' + attacker[cracker].display + '</option>';
  }
  select.html(htmlToInsert);
}

var patternImages = new Object();
patternImages.LEET       = "leet.gif";
patternImages.SUBSTITUTE = "subs.gif";
patternImages.MISSPELL   = "miss.gif";
patternImages.WORD       = "word.gif";
patternImages.INSERTION  = "ins.gif";
patternImages.DUPLICATE  = "dup.gif";
patternImages.DIAGONAL   = "diag.gif";
patternImages.HORIZONTAL = "horiz.gif";
patternImages.REPEATED   = "repeat.gif";
patternImages.RANDOM     = "random.gif";

var patternDescription = new Object();
patternDescription.LEET       = "A word was found with some 'leet substituted characters.  Leet is short for \"elite\".  It is a way of encoding characters with numbers and special characters. Such as 1 for the letter 'l', for example, leet is spelled 133+.";
patternDescription.SUBSTITUTE = "A word was found with some characters substituted by special characters or numbers";
patternDescription.MISSPELL   = "A misspelled word was found";
patternDescription.WORD       = "A word was found.  To add more complexity, consider misspelling a word or inserting characters into a word";
patternDescription.INSERTION  = "A word was found with some extra characters inserted.";
patternDescription.DUPLICATE  = "The same pattern was found previously.";
patternDescription.DIAGONAL   = "A diagonal sequence of keys was identified.  This is the weakest type of password pattern.";
patternDescription.HORIZONTAL = "A horizontal sequence of keys was identified.  This is the weakest type of password pattern. ";
patternDescription.REPEATED   = "Repeat characters were found.  This is an extremly weak type of password pattern.  ";
patternDescription.RANDOM     = "No pattern was found.  This part of the pattern increases in strength by using many different types of characters, such as upper-case, lower-case, latin, cyrillic, numbers, or other special characers.";

String.prototype.supplant = function (o) { 
    return this.replace(/{([^{}]*)}/g, 
        function (a, b) {
            var r = o[b]+"";
            return typeof r === 'string' ? 
                r : a; 
        }
    ); 
};

function showDetail(id){
	$("div.patternDetail").hide();
	$("#"+id).show();
}

function hideDetail(id){
	$("#"+id).hide();
}

var passwordPatternTemplate = 
'<div class="sign white pattern" onmouseout="hideDetail(\'{id}\')" onmouseover="showDetail(\'{id}\')">'+
	'<div class="normal"><label title="Found Pattern"/>{name}</div>' +
	'<div class="small"><label title="Pattern Classification"/>{classification}</div>' +
	'<div class="xxlarge">{percent}%</div>' +
	'<div class="xsmall">of total strength</div>' +
'</div>';

var patternDetailTemplate = 
'<div class="sign blue center patternDetail" id={id}>'+
	'<div class="normal"><label>Found Pattern: </label>{name}</div>' +
	'<div class="small"><label>Description: </label>{description} <br/>{detail}</div>' +
	'<div class="normal"><label>Number of passwords in pattern: </label></div>'+
	'<div class="large">{patternSizeRounded}</div>' +
	'<div class="small"><label>Pattern Classification: </label>{classification}</div>' +
	'<div class="normal"><label>Matches </label>\'{matchString}\'</div>' +
'</div>';

var patternSummaryTemplate = 
'<div class="sign {color} passSummary">'+
	'<div class="large">{allowedString}</div>'+
	'<div class="normal"><label>Time To Crack:</label></div><div id="timeToCrack" class="xxlarge">{timeToCrack}</div>'+
	'<div class="normal"><label>Total Passwords in Pattern: </label><div class="large">{totalCostRounded}</div></div>';
	
function calculateTotal(analysis){
	var total = 0;
	for(pIndex in analysis.patterns){
		var pattern = analysis.patterns[pIndex];
		total += pattern.patternSize;
	}
	return total;
}

function applyTemplate(div, analysis, passlength){
	analysis.totalCostRounded = getRoundedSizeString(analysis.cost);
	analysis.timeToCrack = time2Crack(analysis.cost, $('#attacker').val(), $('#hasher').val());
	var timeToCrackMilli = timeToCrackMilliSeconds(analysis.cost, $('#attacker').val(), $('#hasher').val());
	
	if(timeToCrackMilli > threshold){
		analysis.color = "green";
		analysis.allowedString = "";
	} else {
		analysis.color = "orange";
		analysis.allowedString = "This password needs more strength";
	}
	
	
	var analysisHtml = patternSummaryTemplate.supplant(analysis);
	var pattern;
	for(var pIndex=0,len=analysis.patterns.length ; pIndex<len; pIndex++){
		pattern = analysis.patterns[pIndex];
		if (pattern.classification == "null")
			pattern.classification = "&emsp;";
		pattern.name = pattern.name.replace("_", " ");
		pattern.percent = Math.round(pattern.patternSize / calculateTotal(analysis) * 100);
		pattern.id="pattern"+pIndex;
		analysisHtml += passwordPatternTemplate.supplant(pattern);
	}
	for(pIndex=0,len=analysis.patterns.length ; pIndex<len; pIndex++){
		pattern = analysis.patterns[pIndex];
		pattern.patternSizeRounded = getRoundedSizeString(pattern.patternSize);
		pattern.detail = patternDescription[pattern.name];
		analysisHtml += patternDetailTemplate.supplant(pattern);
	}
	analysisHtml +='</div>';
	div.innerHTML = analysisHtml;
	
	var summaryWidth = $("div.passSummary").width();
	$("div.patternDetail").width(summaryWidth-25);
}

function getRoundedSizeString(size) {
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

function time2Crack(words, attacker_type, protection_type){
	return timeToCrack(words, 
			cracker[protection[protection_type].cracker], 
			attacker[attacker_type].multiplier,
			protection[protection_type].iterations);
}

function timeToCrackMilliSeconds(words, attacker_type, protection_type){
	
	timePerPass = cracker[protection[protection_type].cracker];
	numProcs = attacker[attacker_type].multiplier;
	iterations = protection[protection_type].iterations;
	
	var millis = timePerPass * iterations / numProcs; 
	return milliseconds = words * millis;
}

function timeToCrack(words, timePerPass, numProcs, iterations){
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

function submitPassword(){ //submit to applet or service
	var applet = false;
	
	var password = document.getElementById("password").value;
	if (applet){
		var results = $("#passfaultlet")[0].analyze(password);
		var analysis = JSON.parse(results);
	  	applyTemplate(document.getElementById("patterns"),analysis);
	  	$("div.goneOnAnalyze").hide();
	} else {
		$.ajax({
			  type: 'POST',
			  url: 'analysis',
			  data: password,
			  contentType: 'text',
			  success: function(results) {
					$("div.goneOnAnalyze").hide();
				  	applyTemplate(document.getElementById("patterns"), results);
			  },
			  error: function(jqXHR, textStatus, errorThrown) {
				  alert('An error ocurred analyzing: '+errorThrown);
			  },
			  dataType: 'json'
			});
//		$.post("analysis", password, function(results) {
//			$("div.goneOnAnalyze").hide();
//		  	applyTemplate(document.getElementById("patterns"), results);
//		}, "json");
	}
}
