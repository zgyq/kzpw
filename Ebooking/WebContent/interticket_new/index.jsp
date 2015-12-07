<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-国际机票查询</title>
<link type="text/css" rel="stylesheet" href="interticket_new/css/styleAir.css">

<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
	
	
<script src="interjs/interaircity2.js" type=text/javascript></script>
<script src="interjs/popdg_div.js" type=text/javascript></script>
<script src="interjs/popdg_div_gj.js" type=text/javascript></script>
<script src="interjs/city.js" type=text/javascript></script>
<link rel=stylesheet type=text/css href="interjs/city.css" />	
<link rel=stylesheet type=text/css href="interjs/citycontrol.css" />		
<link rel=stylesheet type=text/css href="interjs/base.css" />	
<script>

$(document).ready(function(){
  //默认加载当日日期
   $("#txtStartDate").val(getDateyyyyMMdd(3));
	  
});

function huhuanguonei(){

var fromCity=$("#fromCity").val();
var hideFromCityCode=$("#hideFromCityCode").val();
var arrCity=$("#arrCity").val();
var hideArrCityCode=$("#hideArrCityCode").val();

$("#fromCity").val(arrCity);
$("#hideFromCityCode").val(hideArrCityCode);
$("#arrCity").val(fromCity);
$("#hideArrCityCode").val(hideFromCityCode);


}

 function getDateyyyyMMdd(num) {
    var d = new Date();
    d.setDate(d.getDate() + num);
    var y = d.getFullYear();
    var m = d.getMonth() + 1;
    if (m < 10) {
        m = '0' + m;
    }
    var d = d.getDate();
    if (d < 10) {
        d = '0' + d;
    }
    var str = y + '-' + m + '-' + d;
    return str;
}
	
//一下2个位日期控件用
function getDateDiff(date, num){
	var d1 = new Date(eval(date.substring(0, 4)), eval(date.substring(5, 7)) - 1, eval(date.substring(8, 10)));
	num = (typeof(num)=='undefined')?0:num;
	var d2 = new Date(d1.valueOf() + (num*86400000));
    var yy = d2.getFullYear(); 
    var mm = d2.getMonth() + 1; 
    var dd = d2.getDate(); 
    return yy + "-" + getmyselfDate(mm) + "-" + getmyselfDate(dd);
}
function getmyselfDate(a){
    if (a < 10) {
        return "0" + a;
    }
    return a;
}

function sub_form(){
if($('#s_cityandhotelname').val()==''||$('#s_cityandhotelname').val()=='请输入城市名或酒店名'){
alert("请输入城市名或酒店名!!!");
return;
}
}
function  subseach_air(){
 if($("#txtStartDate").val()=="")
        {
           alert("出发日期为必填项,请检查后重新填写！");
           $("#txtStartDate").focus();
           return ;
        }
   
         document.form1.submit();

}
 	//单程往返类型
	 function bindFlightType(index)
	 {
	    if(index==1)
	    {
	       $("#txtBackDate").attr("disabled","disabled");
	       //$("#txtBackDate").val("返");
	    }
	    else if(index==2)
	    {
	       $("#txtBackDate").removeAttr("disabled");
	    }
	 }
</script>
</head>
<body id="mainbody">
<div class="cen" style="position: relative;">
	<ww:include page="../top.jsp?index=1&subindex=2" />
	</div>
<form action="interticket!search.jspx" name="form1" id="form1" method="POST">
<div class="navAir">
    <div class="searchBox">
        <div class="airTab">
            <span><input name="intTravelType" id="tripTyperound" disabled="disabled" type="radio" value="2" onclick="bindFlightType(2)" />往返</span>
            <span><input name="intTravelType" id="tripTypesingle" type="radio" value="1" onclick="bindFlightType(1)" checked="checked"/>单程</span>
        </div>
        <div class="goto">
            <div class="gotoBox">
                <p>出发</p>
                <input type="text" name="fromCity" 
								id="fromCity"
								onkeydown="popup_hidegj();suggestgj.display('fromCity','hideFromCityCode',event);"
								onblur="showSearch(id,1);"
								onfocus="popUpgj('fromCity','hideFromCityCode')"
								onclick="popUpgj('fromCity','hideFromCityCode')"
								style="border: 1px solid #999999; height: 20px; line-height: 20px;"
								autocomplete="off" value="北京" />
					<input type="hidden" id="hideFromCityCode" value="BJS" name="StartAirportCode" />
            </div>
            <div class="changeBox" onclick="huhuanguonei();return false;"></div>
            <div class="gotoBox">
                <p>到达</p>
                <input type="text" name="toCity" value="香港"
								id="arrCity"
								onkeydown="popup_hidegj();suggestgj.display('arrCity','hideArrCityCode',event);"
								onblur="showSearch(id,1);"
								onfocus="popUpgj('arrCity','hideArrCityCode')"
								onclick="popUpgj('arrCity','hideArrCityCode')" />
            <input type="hidden" id="hideArrCityCode" name="EndAirportCode" value="HKG" />
            </div>
        </div>
        <div class="gotoDate">
            <div class="date">
                <p>去程日期</p>
                <input type="text" id="txtStartDate"
								name="fromDate"
								onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
								class="Wdate" />
            </div>
            <div class="date">
                <p>返程日期</p>
                <input type="text" id="txtBackDate" name="returnDate" disabled="disabled"
								onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
								class="Wdate" />
            </div>
            <div class="passengerBox">
                <div class="passenger">
                    <p>成人</p>
                    <select>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                    </select>
                </div>
                <div class="passenger">
                    <p>儿童</p>
                    <select>
                     	<option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                    </select>
                </div>
                <div class="passenger">
                    <p>婴儿</p>
                    <select>
                   		<option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                    </select>
                </div>
                <div class="passenger1">
                    <p>仓位</p>
                    <select name="seatType">
                        <option value="Y">经济舱</option>
                        <option value="C">商务舱</option>
						<option value="F">头等舱</option>
                    </select>
                </div>
            </div>
        </div>
        <a href="#" class="btnSearch"  onclick="subseach_air();"></a>
    </div>
</div>
</form>

<div class="airMid">
    <div class="hotLine">
        <ul>
            <li>
                <img src="interticket_new/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li>
                <img src="interticket_new/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li>
                <img src="interticket_new/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li class="last">
                <img src="interticket_new/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
        </ul>
    </div>
    <div class="hotLine">
        <ul>
            <li>
                <img src="interticket_new/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li>
                <img src="interticket_new/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li>
                <img src="interticket_new/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li class="last">
                <img src="interticket_new/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
        </ul>
    </div>
    <div class="supTxt">
        <ul>
            <li class="td1">
                <h2>即时价格查询</h2>
                <p>
                    我们与天巡（Skyscanner 中国）合作，为你提供机票即时在线价格查询。由于机票价格和航线变动频繁，不同时间搜索票价和航班都会有变化，
                    这一刻搜索到的机票，也许下一秒就已全部售出。所以，该出手时就出手吧！
                </p>
            </li>
            <li class="td2">
                <h2>没有中间商</h2>
                <p>
                    我们帮你大海捞针找到你最想要的航班，之后你可以点击链接直接到航空公司或授权的代理机构进行预订并完成交易。
                    整个预订过程中没有中间商，你不是通过穷游进行预订，穷游也不收取任何费用。
                </p>
            </li>
            <li class="td3">
                <h2>即时价格查询</h2>
                <p>
                    我们与天巡（Skyscanner 中国）合作，为你提供机票即时在线价格查询。由于机票价格和航线变动频繁，不同时间搜索票价和航班都会有变化，
                    这一刻搜索到的机票，也许下一秒就已全部售出。所以，该出手时就出手吧！
                </p>
            </li>
        </ul>
    </div>
</div>
</body>
<div style="display: block;"><jsp:include page="../footer.jsp"></jsp:include></div>
</html>