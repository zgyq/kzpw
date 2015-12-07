$.ready(function () {
document.getElementById("singleTrip").checked=true;
$("#ArraveDate").css("color","gray");
//$.config('MinBookingDays', '0');
//$.config('MaxBookingDays', '20');
var langObj = {
'PRO': {
'GB': 'http://trains.ctrip.com/',
'HK': 'http://trains.big5.ctrip.com/',
'BIG5': 'http://trains.big5.ctrip.com/'
},
'UAT': {
'GB': 'http://trains.uat.sh.ctriptravel.com/',
'HK': 'http://trains.big5.uat.sh.ctriptravel.com/',
'BIG5': 'http://trains.big5.uat.sh.ctriptravel.com/'
},
'TEST': {
'GB': 'http://trains.testu.sh.ctriptravel.com/',
'HK': 'http://trains.big5.testu.sh.ctriptravel.com/',
'BIG5': 'http://trains.big5.testu.sh.ctriptravel.com/'
}
};
var baseUrl = 'http://trains.ctrip.com/';
var lang='GB';
var solution = document.getElementById('solution');
var langArr = solution && solution.value && solution.value.toUpperCase().split('|');
if (langArr && langArr.length) {
	lang=langArr[1];
	baseUrl = langObj[langArr[0]][langArr[1]];
}
    var sel = {
        //国内
        from: $('#from'),
        to: $('#to'),
        fromCn: $('#notice01'),
        toCn: $('#notice02'),
        departureDate: $('#DdateObj'),
		arriveDate: $('#AdateObj'),
        gosearchCountry: $('#searchTicket')
    };
	
var mindays=new Date().addDays(0).toFormatString('yyyy-MM-dd');
var maxdays=new Date().addDays(19).toFormatString('yyyy-MM-dd');

var getCookie=function () {
    var m = cQuery.cookie.get('TrainLastSearch');
    m = (m ? m : "").split("|");
    if(m[0]!=""&&m[0]!=undefined)
    {
        sel.fromCn[0].value=unescape(m[0]);
        changeColor("#notice01");
        sel.from[0].value=unescape(m[1]);
    }
    if(m[2]!=""&&m[2]!=undefined)
    {
        sel.toCn[0].value=unescape(m[2]);
        changeColor("#notice02");
        sel.to[0].value=unescape(m[3]);
    }
    if(m[4]!=""&&m[4]!=undefined)
    { 
		//如果缓存日期小于当前预定最小日期，则取当前最小日期
		if(unescape(m[4])<mindays)
		{
			sel.departureDate[0].value=mindays;    
		}
		else
		{
			sel.departureDate[0].value=unescape(m[4]); 
		}		
        changeColor("#DdateObj");
    }
	
	if(m[5]!=""&&m[5]!=undefined)
    {	
		document.getElementById("roundTrip").checked=true;
		SelectTrip();
		if(unescape(m[5])<unescape(m[4]))
		{
			sel.arriveDate[0].value=new Date(unescape(m[4]).replace(/\-/g, '/')).addDays(2).toFormatString('yyyy-MM-dd');
		}
		else
		{
			sel.arriveDate[0].value=unescape(m[5]);
		}
        changeColor("#AdateObj");
    }	
}
getCookie();

 var setCookie= function () {
	var arrDate="";
	if(document.getElementById("roundTrip").checked)
	{
		arrDate=sel.arriveDate[0].value.trim();
	}
    var cookiedomain = window.location.host.replace(/www\.|big5\./, '');
    cQuery.cookie.set('TrainLastSearch', null, sel.fromCn[0].value.trim() + '|' + sel.from[0].value.trim() + '|' + sel.toCn[0].value.trim() + '|' + sel.to[0].value.trim() + '|' + sel.departureDate[0].value.trim() + '|' + arrDate, {expires: 30,domain: cookiedomain,path: '/'});
}
    //城市选择框（语言判断）
    $.mod.load('address', '1.0', function () {
        var big5Str = "";
        if (lang!= "GB") {
            big5Str = ".big5";
        } else {
            big5Str = "";
        }
        cityCommCountry(sel.fromCn, '#from', big5Str);
        cityCommCountry(sel.toCn, '#to', big5Str);
    });
    //日期选择框
    $.mod.load('calendar', '3.1', function () {
        calendarCommContry(sel.departureDate, mindays, maxdays); //开始、结束日期
    });
	$.mod.load('calendar', '3.1', function () {
		if(sel.departureDate[0].value.trim()!="yyyy-mm-dd")
		{
			var departdays=new Date(sel.departureDate[0].value.trim().replace(/\-/g,'/')).toFormatString('yyyy-MM-dd');
			calendarCommContry(sel.arriveDate, departdays, maxdays); //开始、结束日期
		}
		else
		{
			calendarCommContry(sel.arriveDate, mindays, maxdays); //开始、结束日期
		}
    });
    //提示文字
    $.mod.load('notice', '1.0', function () {
        tipComm(sel.fromCn, "中文/拼音/首字母");
        tipComm(sel.toCn, "中文/拼音/首字母");
        tipComm(sel.departureDate, "yyyy-mm-dd");
		tipComm(sel.arriveDate, "yyyy-mm-dd");
    });
    //验证火车票输入的信息
    $.mod.load('validate', '1.1', function () {
        var valid = $(document).regMod("validate", "1.1");
        var validateShow = function (obj, message) {
            valid.method("show", { $obj: obj, data: message, removeErrorClass: true, hideEvent: "blur", isFocus: true });
        };
        //触发火车票搜索按钮
        sel.gosearchCountry.bind('click', function (e) {
            if (sel.fromCn[0].value.trim() == "中文/拼音/首字母") {
                validateShow(sel.fromCn, "请输入出发城市名称");
                return false;
            }
            if (sel.toCn[0].value.trim() == "中文/拼音/首字母") {
                validateShow(sel.toCn, "请输入到达城市名称");
                return false;
            }
			//出发日期判断
            if (sel.departureDate[0].value.replace(/\//g, '-').trim() == "yyyy-mm-dd") {
                validateShow(sel.departureDate, "请选择出发日期");
                return false;
            }
			if (!sel.departureDate[0].value.replace(/\//g, '-').trim().isDate()) {
                validateShow(sel.departureDate, "出发日期格式不正确");
                return false;
            }
			if (new Date(sel.departureDate[0].value.trim().replace(/\-/g, '/')).getTime()<new Date(mindays.replace(/\-/g, '/')).getTime()) {
                validateShow(sel.departureDate, "出发日期不能小于"+mindays);
                return false;
            }
			if (new Date(sel.departureDate[0].value.trim().replace(/\-/g, '/')).getTime()>new Date(maxdays.replace(/\-/g, '/')).getTime()) {
                validateShow(sel.departureDate, "出发日期不能大于"+maxdays);
                return false;
            }
			
			var d2 ="";
			if(document.getElementById("roundTrip").checked)
            {
				//返回日期判断
				if (sel.arriveDate[0].value.replace(/\//g, '-').trim() == "yyyy-mm-dd") {
					validateShow(sel.arriveDate, "请选择返回日期");
					return false;
				}
				if (!sel.arriveDate[0].value.replace(/\//g, '-').trim().isDate()) {
					validateShow(sel.arriveDate, "返回日期格式不正确");
					return false;
				}
				if (new Date(sel.arriveDate[0].value.trim().replace(/\-/g, '/')).getTime()<new Date(sel.departureDate[0].value.trim().replace(/\-/g, '/')).getTime()) {
					validateShow(sel.arriveDate, "返回日期不能小于"+sel.departureDate[0].value.trim().replace(/\//g, '-'));
					return false;
				}
				if (new Date(sel.arriveDate[0].value.trim().replace(/\-/g, '/')).getTime()>new Date(maxdays.replace(/\-/g, '/')).getTime()) {
					validateShow(sel.arriveDate, "返回日期不能大于"+maxdays);
					return false;
				}
				arriveDate=sel.arriveDate[0].value.trim().replace(/\-/g, '/');
				d2 = Math.ceil((new Date(arriveDate) - new Date()) / (60 * 60 * 24 * 1000)) + 1;
			}
            departureDate = sel.departureDate[0].value.trim().replace(/\-/g, '/');
            var d = Math.ceil((new Date(departureDate) - new Date()) / (60 * 60 * 24 * 1000)) + 1;
            var day = "";
            if (d > 1)//过滤
            {
                day = "-d" + d;
            }
            setCookie();
			var url = baseUrl + "TrainBooking/" + sel.from[0].value.trim() + "-" + sel.to[0].value.trim() + day;
			if(document.getElementById("singleTrip").checked)
            {
				url = baseUrl + "TrainBooking/Search.aspx?from=" + sel.from[0].value.trim() + "&to=" + sel.to[0].value.trim()+ "&day=" + d + "&fromCn=" + sel.fromCn[0].value.trim() + "&toCn=" + sel.toCn[0].value.trim();
			}
			else
			{
				 url = baseUrl + "TrainBooking/RoundTrip.aspx?from="+sel.from[0].value.trim()+"&to="+sel.to[0].value.trim()+"&dayreturn="+d2+"&day="+d+"&fromCn="+sel.fromCn[0].value.trim()+"&toCn="+sel.toCn[0].value.trim();
			}
            if (typeof window.$location == "undefined") window.$location = function (url) { if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)) { var referLink = document.createElement("a"); referLink.href = url; document.body.appendChild(referLink); referLink.click() } else location.href = url };
            $location(url);
            e.preventDefault();
        });
    });
});
//根据出发日期自动选择返回日期（返回日期=出发日期+2）
var ChangeDate=function(id){
	if(id=="1")
	{
		var chufaDate=$("#DdateObj")[0].value.trim();
		var fanhuiDate=$("#AdateObj")[0].value.trim();
	
		var nextD =new Date().addDays(0).toFormatString("yyyy-MM-dd");
		if(chufaDate!="yyyy-mm-dd"&&chufaDate!="")
		{
			 nextD = new Date(chufaDate.replace(/\-/g,'/')).toFormatString('yyyy-MM-dd')
		}
		$("#AdateObj").data('minDate', nextD); 
		//如果是往返类型
		if(document.getElementById("roundTrip").checked)
		{
			//出发日期不为空
			if(chufaDate!="yyyy-mm-dd"&&chufaDate!="")
			{	
				if(fanhuiDate!="yyyy-mm-dd"&&chufaDate!="")
				{
					if(fanhuiDate!="yyyy-mm-dd"&&new Date(chufaDate.replace(/\-/g,'/')).getTime()>new Date(fanhuiDate.replace(/\-/g,'/')).getTime())
					{
						//如果返回日期加2天大于最大可预定日期，则取最大可预定日期
						if(new Date(chufaDate.replace(/\-/g,'/')).addDays(2).getTime()>new Date().addDays(19).getTime())
						{
							$("#AdateObj")[0].value=new Date().addDays(19).toFormatString('yyyy-MM-dd');
						}
						else
						{
							$("#AdateObj")[0].value=new Date(chufaDate.replace(/\-/g,'/')).addDays(2).toFormatString('yyyy-MM-dd');
						}
					}
					else if(fanhuiDate=="yyyy-mm-dd")
					{
						//如果返回日期加2天大于最大可预定日期，则取最大可预定日期
						if(new Date(chufaDate.replace(/\-/g,'/')).addDays(2).getTime()>new Date().addDays(19).getTime())
						{
							$("#AdateObj")[0].value=new Date().addDays(19).toFormatString('yyyy-MM-dd');
						}
						else
						{
							$("#AdateObj")[0].value=new Date(chufaDate.replace(/\-/g,'/')).addDays(2).toFormatString('yyyy-MM-dd');
						}
					}
				}
			}
		}
	}
	else
	{
		if($("#AdateObj")[0].value.trim()!="yyyy-mm-dd")
		{
			document.getElementById("roundTrip").checked=true;
			SelectTrip();
		}
	}
}
var searchReturn = function () {
    var temp = document.getElementById("notice01").value.trim();
    document.getElementById("notice01").value = document.getElementById("notice02").value.trim();
    document.getElementById("notice02").value = temp;
	
	var color=$("#notice01").css("color");
	$("#notice01").css("color",$("#notice02").css("color"));
	$("#notice02").css("color",color);
	
    var temp2 = document.getElementById("from").value.trim();
    document.getElementById("from").value = document.getElementById("to").value.trim();
    document.getElementById("to").value = temp2;

}
//提示文字
var tipComm = function (nameStr, tipInfo) {
    nameStr.regMod("notice", "1.0", {
        name: nameStr,
        tips: tipInfo
    }, true);
}
//国内日期选择框
var calendarCommContry = function (dateStr, startDate, endDate) {
    dateStr.regMod('calendar', '3.1', {
        options: {
            minDate: startDate,//.replace(/\//g, '-'),
            maxDate: endDate,
            autoShow: true,
            showWeek: false
        },
        listeners: {
            onChange: function (input, value) {
                //checkOutDate.trigger('focus');
                //alert(value);
            }
        }
    });
}
//国内城市选择框
var cityCommCountry = function (cityName, param, big5Str) {
    var url = "http://webresource.ctrip.com/code/cquery/resource/address/train/station_gb2312.js";
    if (big5Str != "") {
        url = "http://webresource.ctrip.com/code/cquery/resource/address/train/station_big5.js";
    }
    var addressMod = cityName.regMod('address', '1.0', {
        name: 'barSearch_CityName',
        jsonpSource: url,
        relate: {
            'name_py1': param
        },
        isFocusNext: true,
		isAutoCorrect: true
    });
}
 function changeColor(nameStr){
    $(nameStr).css("color","black");
 }
 function changeColorLeave(nameStr){
    if($(nameStr)[0].value.toString().trim()=="")
    {
        $(nameStr).css("color","gray");
    }
 }
function SelectTrip()
{
	if(document.getElementById("singleTrip").checked)
	{
		$("#ArraveDate").addClass("s_disable");
		$("#ArraveDate").css("color","gray");
		$("#AdateObj").css("color","gray");
	} 
	else
	{
		$("#ArraveDate").removeClass("s_disable");
		$("#ArraveDate").css("color","black");
		if($("#AdateObj")[0].value.toString().trim()=="yyyy-mm-dd")
		{
			if($("#DdateObj")[0].value.trim()!="yyyy-mm-dd")
			{
						if(new Date($("#DdateObj")[0].value.trim().replace(/\-/g,'/')).addDays(2).getTime()>new Date().addDays(19).getTime())
						{
							$("#AdateObj")[0].value=new Date().addDays(19).toFormatString('yyyy-MM-dd');
						}
						else
						{
							$("#AdateObj")[0].value=new Date($("#DdateObj")[0].value.trim().replace(/\-/g,'/')).addDays(2).toFormatString('yyyy-MM-dd');
						}
						$("#AdateObj").css("color","black");
			}
		}
		else
		{
			$("#AdateObj").css("color","black");
		}
		
	}
}/*****env:4,update:2013-9-3 14:06:02*****/