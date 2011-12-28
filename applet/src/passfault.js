String.prototype.supplant = function (o) { 
    return this.replace(/{([^{}]*)}/g, 
        function (a, b) {  
            var r = o[b]+"";
            return typeof r === 'string' ? 
                r : a; 
        }
    ); 
};

var passwordPatternTemplate = '<div class="pattern">'+
	'<div class="pattern.name"><label>Found Pattern: </label>{name}</div>' +
	'<div class="pattern.description"><label>Description: </label>{description}</div>' +
	'<div class="pattern.patternSize"><label>Number of passwords in pattern: </label>{patternSize}</div>' +
	'<div class="pattern.classification"><label>Pattern Classification: </label>{classification}</div>' +
	'<div class="pattern.matchString"><label>Match String: </label>{matchString}</div>' +
	'<div class="pattern.startIndex"><label>Start index: </label>{startIndex}</div>' +
	'<div class="pattern.length"><label>Length: </label>{length}</div>' +
'</div>';

function applyTemplate(div, analysis){
	div.innerHTML = "";
	for(pIndex in analysis.patterns){
		div.innerHTML += passwordPatternTemplate.supplant(analysis.patterns[pIndex]);
	}
}

function submitPassword(){ //submit to applet
	var password = document.getElementById("password").value;
	
	var response = req.responseText; 
	var analysis = JSON.parse(response);
	
	document.getElementById("cost").value = analysis.cost;
	applyTemplate(document.getElementById("patterns"), analysis);
}
