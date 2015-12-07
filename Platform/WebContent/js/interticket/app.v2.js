function getByCode(code, items){
	for(var i = 0; i < items.length; i++){
		if(code == items[i][0]){
			return items[i][1];
		}
	}
	return code;
}
function getAircoList(){
	return _airco;
}
function getAircoName(code){
	if(code == 'LC') return '廉价航空';
	return getByCode(code, _airco);
}
function getAirportName(code){
	var ret = getByCode(code, _airport);
	if(ret == code){
		ret = getCityName(code);
	}
	if(ret.indexOf('机场') == -1){
		ret +=  '机场';
	}
	return ret;
}
function getCityName(code){
	return getByCode(code, _city);
}
function getPassengerTypeName(code){
	return getByCode(code, _passengerType);
}
function getCertificateTypeName(code){
	return getByCode(code, _certificateType);
}
function getSexName(code){
	return getByCode(code, _sex);
}
function formatTime(s){
	return s.substring(0, 2) + ':' + s.substring(2, 4);
}
function _changeTripType(val){
	val == 0 ? $('#returnDateWrapper').addClass('hidden') : $('#returnDateWrapper').removeClass('hidden');
}
function loadAircoSelect(){
	var el = $('#airCo');
	var data = getAircoList();
	$(data).each(function(inx, item){
		el.append('<option value="' + item[0] + '">' + item[0] + '(' + item[1] + ')</option>');
	});
}
function initCalendar(){
	window.calendar = new jsCalendar($('#calendar_canvas'), _dateHint);
	calendar.addInput($('#fromDate'));
	calendar.addInput($('#returnDate'));
}
function inputLimit(){
	app.dateInput($('#fromDate'));
	app.dateInput($('#returnDate'));
	app.intInput($('#adultCount'));
}
function initSuggest(){
	window.fromCitySuggest = new Suggest($('#city_suggest'), 'http://www.lcair.com/service/fromCitySuggest.php', _cityHint, _fromCity);
	fromCitySuggest.addInput($('#fromCity'));
	window.toCitySuggest = new Suggest($('#city_suggest'), 'http://www.lcair.com/service/toCitySuggest.php', _cityHint, _toCity);
	toCitySuggest.addInput($('#toCity'));
	window.citySuggest = new Suggest($('#city_suggest'), 'http://www.lcair.com/service/citySuggest.php', _cityHint, _toCity);
}
function showWaiting(s, x, y){
	$('#waiting').html(s).css('left', x).css('top', y).show();
}
function hideWaiting(){
	$('#waiting').hide();
}
function isFromGDS(src){
	return src == 14 || src == 15;
}