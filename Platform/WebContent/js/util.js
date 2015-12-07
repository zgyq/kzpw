function getDate(num){
	num = (typeof(num)=='undefined')?0:num;
    var now = new Date(); 
    now.setDate(now.getDate()-num); 
    var yy = now.getFullYear(); 
    var mm = now.getMonth() + 1;
    var dd = now.getDate();
    return yy + "-" + getmyselfDate(mm) + "-" + getmyselfDate(dd);
}

function getmyselfDate(a){
    if (a < 10) {
        return "0" + a;
    }
    return a;
}

function compareDate(startDate, endDate){
    var today = getDate();
	startDate = startDate.substring(0, 4)+startDate.substring(5, 7) +startDate.substring(8, 10);
    endDate = endDate.substring(0, 4)+endDate.substring(5, 7) +endDate.substring(8, 10);
    today = today.substring(0, 4)+today.substring(5, 7) +today.substring(8, 10);
    if (parseInt(startDate) > parseInt(endDate) || parseInt(endDate) > parseInt(today)) {
        return false;
    }
   return true;
}

function dateInterval(startDate, endDate, interval){
    var date1 = new Date(eval(startDate.substring(0, 4)), eval(startDate.substring(5, 7)) - 1, eval(startDate.substring(8, 10)));
    var date2 = new Date(eval(endDate.substring(0, 4)), eval(endDate.substring(5, 7)) - 1, eval(endDate.substring(8, 10)));
    if ((date2 - date1) / 86400000 > eval(interval) - 1) 
        return false;
    return true;
}

function getDateDiff(date, num){
	var d1 = new Date(eval(date.substring(0, 4)), eval(date.substring(5, 7)) - 1, eval(date.substring(8, 10)));
	num = (typeof(num)=='undefined')?0:num;
	var d2 = new Date(d1.valueOf() + (num*86400000));
    var yy = d2.getFullYear(); 
    var mm = d2.getMonth() + 1; 
    var dd = d2.getDate(); 
    return yy + "-" + getmyselfDate(mm) + "-" + getmyselfDate(dd);
}