<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="kfqq/js/jquery.min.js"></script>

<meta name="author" content="${compname}" />
<title>${compname}—酒店预订，特价机票，景点门票，旅游度假，租车服务</title>

<style type="text/css">
body{margin:0;padding:0;font-family:"宋体";font-size:13px;}

 h1{margin:0;padding:20px 0;font-size:16px;}
 ol{padding-left:20px;line-height:130%;}
 #box{width:600px;text-align:left;margin:0 auto;padding-top:80px;}
 #suggest_form,#suggest_to{width:200px;}
 .gray{color:gray;}
 .ac_results_air {background:#fff;border:1px solid #7f9db9;position: absolute;z-index: 99999999;display: none;}
 .ac_results_air ul{margin:0;padding:0;list-style:none;}
 .ac_results_air li a{white-space: nowrap;text-decoration:none;display:block;color:#05a;padding:1px 3px;}
.ac_results_air li{border:1px solid #fff;}
.ac_over,.ac_results_air li a:hover {background:#c8e3fc;}
.ac_results_air li a span{float:right;}
.ac_result_tip{border-bottom:1px dashed #666;padding:3px;}















</style>
</head>
<body id="mainbody">

<jsp:include page="top.jsp?index=0&subindex=1"></jsp:include>
<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>  
<script src="script/searchFlight.0.0.5.js" type=text/javascript></script>  

<link rel="stylesheet" type="text/css" href="css/slide.css">


<!-- hotel城市js -->
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_data_pp.js"></script>

<!-- air -->
<!--
<link rel="stylesheet" type="text/css" href="js/aircity/css/jquery.suggest_index.css">
 -->
	 <!-- 
	 <script type="text/javascript" src="js/aircity/js/j.dimensions.js"></script>
	 <script type="text/javascript" src="js/aircity/js/aircity.js"></script>
	 <script type="text/javascript" src="js/aircity/js/j.suggest.js"></script>
	  -->
<!-- airjs -->
<script type="text/javascript" src="main_cx/js/city.js"></script>
<script type="text/javascript" src="main_cx/js/popdg_div.js"></script>
<link href="main_cx/css/autocomplete.css" rel="stylesheet" type="text/css">
 
 <!-- 国际js -->





<script type="text/javascript">

$(document).ready(function(){
//hotel
  loadCityData();
$("#txtcheckindate").val(getDateyyyyMMdd(0));
$("#txtcheckoutdate").val(getDateyyyyMMdd(1));

//air
 // $("#city_from_hide_lc").val($("#txtsairport").val());
// $("#arrcity-lc").val($("#txtsairportname").val());


//$("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest_form'});//
//$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',onSelect:function(){bindroundfromcity();},attachObject:"#suggest_to"});




//加载联程城市信息
//$("#arrcity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide_lc',onSelect:function(){$("#tocity-lc").click();}, attachObject:'#suggest-lc'});//
//$("#tocity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide_lc',attachObject:"#suggest2-lc"});
$("#txtStartDate").val(getDateyyyyMMdd(3));
	    	

});

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



function huhuanguonei(){

var txtStartCity=$("#txtStartCity").val();
var hidStarCityCode=$("#hidStarCityCode").val();
var txtEndCity=$("#txtEndCity").val();
var hidEndCityCode=$("#hidEndCityCode").val();

$("#txtStartCity").val(txtEndCity);
$("#hidStarCityCode").val(hidEndCityCode);
$("#txtEndCity").val(txtStartCity);
$("#hidEndCityCode").val(hidStarCityCode);


}


</script>
<!--
<div id="focus_box" style="z-index: -100;width: 100%;height: 495px;">
	    <ul id="focus_pic" style="height: 495px;">
	       <li  style="height: 375px;"><a><img height="395" width="2000" src="images/index/lun/01.jpg"></a></li>
	        <li  style="height: 375px;"><a><img height="395" width="2000" src="images/index/lun/02.jpg"></a></li>
	        <li  style="height: 375px;"><a><img height="395" width="2000" src="images/index/lun/03.jpg"></a></li>
	        <li  style="height: 375px;"><a><img height="395" width="2000" src="images/index/lun/04.jpg"></a></li>
	        <li  style="height: 375px;"><a><img height="395" width="2000" src="images/index/lun/05.jpg"></a></li>
	    </ul>
</div>

-->
<!-- 主体内容 -->
<div id="content" class="content"  >

	
	
<div class="topMain">




<!--搜索框开始-->
<div id="soso_17u" class="search_box">
<div id="portal-block-245245043063" class="udiyblock"
	type="SearchSource"><!--左边的tab切换-->
	
<div class="search_main">
<div id="soso_top_title_1" class="search_left">


<a class="hotel_at crt" id="top_hotel"><span class="left_sp"></span>酒店</a>
<a class="nor" id="top_airplane"><div class="top_hr"></div><span class="left_sp"></span>机票</a>
<a class="nor" id="top_scenic"><div class="top_hr"></div><span class="left_sp"></span>景点门票</a>
<a class="nor" id="top_selftrip"><div class="top_hr"></div><span class="left_sp"></span>自助游</a>
<a class="nor" id="top_abroad"><div class="top_hr"></div><span class="left_sp"></span>出境游</a>
<a class="nor" id="top_phone"><div class="top_hr"></div><span class="left_sp"></span>手机版</a>


</div>
<span class="sp"></span>
</div>

<!--end 左边的tab切换--> 
<!--tab内容-->
<div id="soso_tab_content" class="search_right"><!--酒店tab内容开始-->
<form id="form1" action="hotel!Seach.jspx" method="POST" name="form1" >
<div class="tray hotel_tabdiv">
<div id="tab_top_hotel" class="tab_hotel_con">
<div class="hotel_tab"><span class="hotelIn" title="国内酒店"
	href="javascript:void(0);">国内酒店<b class="hotel_sp"></b></span> <!--  
<span class="nor" href="javascript:void(0);" title="港澳酒店">港澳酒店<b class="hotel_sp"></b></span> 

	<label class="hotel_div"> <b
	class="hotelMap_img"></b> <a title="地图找酒店" class="search_hotel"
	rel="nofollow" href="javascript:void(0)">地图找酒店</a> </label>
--></div>
<dl class="list">
	<dt class="list_tit">入住城市</dt>
	<dd class="list_con">
	<div class="otcitylist"><input type="text" maxlength="15" style="width: 180px;"
		autocomplete="off" value="北京" class="input02" name="txtHotelCity1" id="txthotelcity"
		cityid="0" labelid="0" onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); " onblur="if(this.value=='') {this.value='北京';}" />
		
	 <div id="suggest" class="ac_results"></div>
	  <input type="hidden" id="city_hotel_hide" name="cityId" value="607"  />
	  
	</div>
	<div id="otherCtyList" class="otcitylist none"><label
		for="hotelRadio1"> <input type="radio" name="hotelSearchType" style="width: 180px;"
		id="hotelRadio1" class="input04" checked="checked" cid="395" ctype="0">
	<span class="sp_input04">香港</span> </label> <label for="hotelRadio2"> <input
		type="radio" name="hotelSearchType" id="hotelRadio2" class="input04"
		cid="396" ctype="0"> <span class="sp_input04">澳门</span> </label></div>
	</dd>
</dl>
<dl class="list">
	<dt class="list_tit">入住日期</dt>
	<dd class="list_con"><input type="text" value="时间/日期"   onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})"
		class="input02" name="txtHotelTime1" id="txtcheckindate" style="width: 180px;"
		style="ime-mode: disabled;">
		<!--
		<span id="comHotelWeek"
		class="dateSp">明天</span>
		-->
		</dd>
</dl>
<dl class="list">
	<dt class="list_tit">离店日期</dt>
	<dd class="list_con"><input type="text" value="时间/日期" onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})"
		class="input02" name="txtHotelTime2" id="txtcheckoutdate" style="width: 180px;"
		style="ime-mode: disabled;">
		<!--<span id="lvHotelWeek"
		class="dateSp">后天</span>
	-->
	<div id="hotelTimeErr" class="errMasBorder"><span class="lefSpan"></span><span
		class="rgtSpan">如果您需要在酒店入住20天以上，请致电4007-777-777转1，我们会竭诚为您服务。</span></div>

	</dd>
</dl>
<dl class="list">
	<dt class="list_tit">酒店位置</dt>
	<dd class="list_con"><input type="text" id="txtHotelInfo"  style="width: 180px;"
		name="txtHotelInfo" class="input02" value="商圈/行政区/地标"
		autocomplete="off"></dd>
</dl>
<dl class="list">
	<dt class="list_tit">酒店名称</dt>
	<dd class="list_con"><input type="text" id="txtHotelName"  style="width: 180px;"
		name="txtHotelName" class="input02" value="酒店名称/品牌" autocomplete="off">
	</dd>
</dl>
<dl class="list_btn_search" >
	<dt class="list_tit"></dt>
	<dd class="list_con"><input id="hotelSubmit" type="submit" style="margin-top: -15px;"
		value="搜索" href="javascript:void(0);" class="search_btn" />
	<div id="hotelInfo_list">
	<div id="hotelInfo" class="hotel_sou_xinxi" style="display: none;"></div>
	</div>
	<input type="hidden" value="1" runat="server" id="hotelType"> <input
		type="hidden" value="1" runat="server" id="hotelLableId"></dd>
</dl>
<div class="hotel_list01 clearfix"><a
	href="#" target="_blank" title="国际酒店"
	class="hkAHotelA"><span class="hkAHotelWord">国际酒店</span></a> <a
	href="#" target="_blank" title="团购酒店"
	class="hkAHotelA tgHotelA"><span class="hkAHotelWord">团购酒店</span></a></div>
</div>
</div>
</form>
<!--end 酒店tab内容--> <!--机票tab内容开始-->
<div class="tray ariplane_div none">
<div id="tab_top_airplane" class="tab_airplane_con"
	data-submit-url="data/FlightBookAjax.jsp?type=FlySearchNew"
	data-citydata-url="data/FlightBookAjax.jsp?Type=GetAllCity">
<div class="airplaneDiv">
<div class="airplane_tab" id="airplane_tab"><a class="airpInter"
	title="国内机票" href="javascript:void(0);" id="flightA">国内机票<span
	class="airplane_sp"></span></a> <a id="isearchIfligt" class="nor"
	href="interticket.jspx" title="国际机票">国际机票<span
	class="airplane_sp"></span></a></div>
<form name="form2" id="form2" method="post" action="ticticket!toTicketList.jspx">
<input type="hidden" id="airCompanyCode" name="airCompanyCode" value="" />
<div class="trayAir">
<ul class="airplane_rad hotel_rad clearfix">
	<li><label for="airplaneRadio1"> <input type="radio"
		class="input04" checked="checked" id="airplaneRadio1"
		value="1" name="s_traveltype" /> <span class="sp_input04">单程</span>
	</label></li>
	<li><label for="airplaneRadio2"> <input type="radio"
		class="input04" id="airplaneRadio2" value="2"
		name="s_traveltype" /> <span class="sp_input04">往返</span> </label></li>
	<!--
	<li><label for="airplaneRadio3"> <input type="radio"
		class="input04" id="airplaneRadio3" value="flysearchtoghther"
		name="SearchType" /> <span class="sp_input04">联程</span> </label></li>
	-->
</ul>

<dl class="list" id="leaveCityDiv" style="z-index: 99999">
	<dt class="list_tit">出发城市</dt>
	<dd class="list_con"><input type="text" maxlength="20"  style="width: 180px;"
		 name="OrgPort" class="input02"  id="txtStartCity" value="北京"  onfocus="popUp('txtStartCity','hidStarCityCode')"
	onclick="popUp('txtStartCity','hidStarCityCode')"
	onblur="showSearch('txtStartCity',1)" autocomplete="off"
	onkeyup="popup_hide();suggest.display('txtStartCity','hidStarCityCode',event);"
		nulltips="请输入出发城市名称"  />
		
		</dd>
		<div id='suggest_form' class="ac_results_air" style="position:fixed"></div>
	    <input type="hidden" id="hidStarCityCode" value="PEK" name="s_depcitycode" />
	    
	    <div class="change_city"  id="guoneihuhuan" onclick="huhuanguonei();"
		style="display: block;margin-left: -50px;"></div>
	
</dl>

		
<dl class="list" id="transitCityDiv" style="display: none;">
	<dt class="list_tit">中转城市</dt>
	<dd class="list_con"><input type="text" id="txtAirplaneCity3"  style="width: 180px;"
		name="ZzPort" class="input02" holder="城市名" nulltips="请输入中转城市名称"
		value="城市名" /></dd>
</dl>


<dl class="list" id="arriveCityDiv">
	<dt class="list_tit">到达城市</dt>
	<dd class="list_con"><input type="text" maxlength="20"  style="width: 180px;"
		id="txtEndCity" name="ArvPort" class="input02" onfocus="popUp('txtEndCity','hidEndCityCode')"
	onclick="popUp('txtEndCity','hidEndCityCode')"
	onblur="showSearch('txtEndCity',1)" autocomplete="off" value="上海"
	onkeyup="popup_hide();suggest.display('txtEndCity','hidEndCityCode',event);"
		nulltips="请输入到达城市名称" holder="城市名" value="上海" />
		</dd>
	<div id='suggest_to' class="ac_results_air" ></div>
		<input type="hidden" id="hidEndCityCode" name="s_arrcitycode" value="SHA" />

</dl>
<dl class="list" id="">
	<dt class="list_tit">出发日期</dt>
	<dd class="list_con">
	<input type="text" id="txtStartDate"  style="width: 180px;"
		name="s_startdate" class="input02" holder="时间/日期" nulltips="请选择出发日期" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){dtBackDate.focus();}})"
		value="时间/日期" style="ime-mode: disabled;" /></dd>
</dl>
<dl class="list" id="backTimeDiv" style="display: none;">
	<dt class="list_tit">返回日期</dt>
	<dd class="list_con"><input type="text" id="txtbackdate"  style="width: 180px;"
		name="s_backdate" class="input02" holder="时间/日期" nulltips="请选择返回日期" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){dtBackDate.focus();}})"
		 style="ime-mode: disabled;" /></dd>
</dl>
<dl class="list" id="transitTimeDiv" style="display: none;">
	<dt class="list_tit">中转日期</dt>
	<dd class="list_con"><input type="text" id="txtAirplaneTime3"  style="width: 180px;"
		name="dtZzDate" class="input02" holder="时间/日期" nulltips="请选择中转日期"
		value="时间/日期" style="ime-mode: disabled;" /> <span id="airTransWeek"
		class="dateSp">星期五</span></dd>
</dl>
<dl class="list btn_flight list_btn_search">
	<dt class="list_tit"></dt>
	<dd class="list_con">
	
	<input type="submit" value="会员专属" style="width: 120px;"
		id="searchExclusive" title="搜索会员特权专属产品，需登录会员账户" class="search_special">
		
	<input class="search_submit" type="submit" id="airplaneSubmit" style="width: 80px;"
		value="搜 索" /></dd>
</dl>
<div historynum="2" class="historyBox none"></div>
</div>
</form>


<div class="trayAir iFlightDiv none">
<ul class="airplane_rad hotel_rad clearfix">
	<li><label for="airplaneInternatRadio1"> <input
		type="radio" class="input04" id="airplaneInternatRadio1" value="1"
		name="airplaneInternatType" /> <span class="sp_input04">单程</span> </label></li>
	<li><label for="airplaneInternatRadio2"> <input
		type="radio" class="input04" checked="checked"
		id="airplaneInternatRadio2" value="2" name="airplaneInternatType" />
	<span class="sp_input04">往返</span> </label></li>
	
	<!--
	<li><label for="airplaneInternatRadio3"> <input
		type="radio" class="input04" id="airplaneInternatRadio3" value="3"
		name="airplaneInternatType" /> <span class="sp_input04">多程</span> </label></li>
	-->
</ul>
<div class="onepass">

<dl class="list" id="ileaveCityDiv">
	<dt class="list_tit">出发城市</dt>
	<dd class="list_con"><input type="text" maxlength="20" style="width: 180px;"
		 class="input02" holder="城市名" nulltips="请输入出发城市名称" value="北京"
								name="fromCity" 
								id="fromCity"
								onkeydown="popup_hidegj();suggestgj.display('fromCity','hideFromCityCode',event);"
								onblur="showSearch(id,1);"
								onfocus="popUpgj('fromCity','hideFromCityCode')"
								onclick="popUpgj('fromCity','hideFromCityCode')" /></dd>
		<input type="hidden" id="hideFromCityCode" value="BJS" name="StartAirportCode" />
		
	<div class="change_city" id="changeiFlightSearchCity"
		style="display: block;margin-left: -50px;"></div>
</dl>
<dl class="list" id="iarriveCityDiv">
	<dt class="list_tit">到达城市</dt>
	<dd class="list_con"><input type="text"  style="width: 180px;"
		class="input02" name="toCity" value="香港"
								id="arrCity"
								onkeydown="popup_hidegj();suggestgj.display('arrCity','hideArrCityCode',event);"
								onblur="showSearch(id,1);"
								onfocus="popUpgj('arrCity','hideArrCityCode')"
								onclick="popUpgj('arrCity','hideArrCityCode')"  /></dd>
		<input type="hidden" id="hideArrCityCode" name="EndAirportCode" value="HKG" />
		
</dl>
<dl class="list" id="ileaveTimeDiv">
	<dt class="list_tit">出发日期</dt>
	<dd class="list_con"><input type="text" name="idtGoDate" style="width: 180px;"
		class="input02" holder="时间/日期" nulltips="请选择出发日期" value="时间/日期"
		style="ime-mode: disabled;" /></dd>
</dl>
<dl class="list" id="ibackTimeDiv" style="display: block;">
	<dt class="list_tit">返回日期</dt>
	<dd class="list_con"><input type="text" name="idtBackDate" style="width: 180px;"
		class="input02" holder="时间/日期" nulltips="请选择返回日期" value="时间/日期"
		style="ime-mode: disabled;" /></dd>
</dl>

<!--
<div class="high_search">
<dl class="miniRol list none" id="airIntSele1">
	<dt class="list_tit">舱位等级</dt>
	<dd class="list_con"><select id="sel_inCabinType"
		name="sel_inCabinType" class="select02">
		<option selected="selected" value="Y">经济舱</option>
		<option value="C">公务舱</option>
		<option value="F">头等舱</option>
	</select></dd>
</dl>
<dl class="miniRol list none" id="airIntSele2">
	<dt class="list_tit">乘客类型</dt>
	<dd class="list_con"><select id="sel_inPassengersType"
		name="sel_inPassengersType" class="select02">
		<option selected="selected" value="1">普通成人</option>
		<option value="2">学生</option>
		<option value="3">劳工</option>
		<option value="4">新移民</option>
		<option value="5">海员</option>
	</select></dd>
</dl>
<dl class="miniRol list none" id="airIntSele3">
	<dt class="list_tit">成人人数</dt>
	<dd class="list_con"><select id="sel_inAdult" name="sel_inAdult"
		class="select02">
		<option selected="selected" value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
	</select></dd>
</dl>
<dl class="miniRol list none" id="airIntSele4">
	<dt class="list_tit">儿童人数</dt>
	<dd class="list_con"><select id="sel_inChild" name="sel_inChild"
		class="select02">
		<option selected="selected" value="0">0</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
	</select></dd>
</dl>
<a title="" href="javascript:void(0);"
	class="high_search_a high_search_show"><span class="s_icon"></span>高级搜索</a>
</div>
-->
</div>
<!-- 多程 -->
<!--
<div class="multipass none"><iframe frameborder="no"
	style="display: none"></iframe>
<ul id="iflight_mult" class="iflight_mult">
	<li class="flightLine"><span class="line_num">第<em>1</em>程
	</span> <label class="iflight_item list_con leavePort"> &nbsp;出发城市 <input
		name="iOrgPortMult" class="input02" maxlength="20" type="text"
		holder="城市名" nulltips="请输入出发城市名称" value="城市名" /> </label> <label
		class="iflight_item list_con arrivePort"> &nbsp;到达城市 <input
		name="iArvPortMult" class="input02" maxlength="20" type="text"
		nulltips="请输入到达城市名称" holder="城市名" value="城市名" /> </label> <label
		class="iflight_item list_con leaveTime"> &nbsp;出发日期 <input
		name="idtGoDateMult" class="input02" maxlength="20" type="text"
		holder="时间/日期" nulltips="请选择出发日期" value="时间/日期" /> </label></li>
	<li class="flightLine"><span class="line_num">第<em>2</em>程
	</span> <label class="iflight_item list_con leavePort"> &nbsp;出发城市 <input
		name="iOrgPortMult" class="input02" maxlength="20" type="text"
		holder="城市名" nulltips="请输入出发城市名称" value="城市名" /> </label> <label
		class="iflight_item list_con arrivePort"> &nbsp;到达城市 <input
		name="iArvPortMult" class="input02" maxlength="20" type="text"
		nulltips="请输入到达城市名称" holder="城市名" value="城市名" /> </label> <label
		class="iflight_item list_con leaveTime"> &nbsp;出发日期 <input
		name="idtGoDateMult" class="input02" maxlength="20" type="text"
		holder="时间/日期" nulltips="请选择出发日期" value="时间/日期" /> </label></li>
	<li class="flightLine"><span class="line_num">第<em>3</em>程
	</span> <label class="iflight_item list_con leavePort"> &nbsp;出发城市 <input
		name="iOrgPortMult" class="input02" maxlength="20" type="text"
		holder="城市名" nulltips="请输入出发城市名称" value="城市名" /> </label> <label
		class="iflight_item list_con arrivePort"> &nbsp;到达城市 <input
		name="iArvPortMult" class="input02" maxlength="20" type="text"
		nulltips="请输入到达城市名称" holder="城市名" value="城市名" /> </label> <label
		class="iflight_item list_con leaveTime"> &nbsp;出发日期 <input
		name="idtGoDateMult" class="input02" maxlength="20" type="text"
		holder="时间/日期" nulltips="请选择出发日期" value="时间/日期" /> </label> <a
		href="javascript:;" class="dele_btn">删除</a></li>
	<li style="display: none;" class="flightLine"><span
		class="line_num">第<em>4</em>程 </span> <label
		class="iflight_item list_con leavePort"> &nbsp;出发城市 <input
		type="text" class="input02" style="color: #999" value="城市名"
		nulltips="请输入出发城市名称" holder="城市名" maxlength="20" name="iOrgPortMult" />
	</label> <label class="iflight_item list_con arrivePort"> &nbsp;到达城市 <input
		type="text" class="input02" style="color: #999" value="城市名"
		holder="城市名" nulltips="请输入到达城市名称" maxlength="20" name="iArvPortMult" />
	</label> <label class="iflight_item list_con leaveTime"> &nbsp;出发日期 <input
		type="text" class="input02" style="color: #999" value="时间/日期"
		nulltips="请选择出发日期" holder="时间/日期" maxlength="20" name="idtGoDateMult" />
	</label> <a class="dele_btn" href="javascript:;">删除</a></li>
	<li style="display: none;" class="flightLine"><span
		class="line_num">第<em>5</em>程 </span> <label
		class="iflight_item list_con leavePort"> &nbsp;出发城市 <input
		type="text" class="input02" style="color: #999" value="城市名"
		nulltips="请输入出发城市名称" holder="城市名" maxlength="20" name="iOrgPortMult" />
	</label> <label class="iflight_item list_con arrivePort"> &nbsp;到达城市 <input
		type="text" class="input02" style="color: #999" value="城市名"
		holder="城市名" nulltips="请输入到达城市名称" maxlength="20" name="iArvPortMult"
		class=""> </label> <label class="iflight_item list_con leaveTime">
	&nbsp;出发日期 <input type="text" class="input02" style="color: #999"
		value="时间/日期" nulltips="请选择出发日期" holder="时间/日期" maxlength="20"
		name="idtGoDateMult" /> </label> <a class="dele_btn" href="javascript:;">删除</a>
	</li>
	<li style="display: none;" class="flightLine"><span
		class="line_num">第<em>6</em>程 </span> <label
		class="iflight_item list_con leavePort"> &nbsp;出发城市 <input
		type="text" class="input02" style="color: #999" value="城市名"
		nulltips="请输入出发城市名称" holder="城市名" maxlength="20" name="iOrgPortMult" />
	</label> <label class="iflight_item list_con arrivePort"> &nbsp;到达城市 <input
		type="text" class="input02" style="color: #999" value="城市名"
		holder="城市名" nulltips="请输入到达城市名称" maxlength="20" name="iArvPortMult" />
	</label> <label class="iflight_item list_con leaveTime"> &nbsp;出发日期 <input
		type="text" class="input02" style="color: #999" value="时间/日期"
		nulltips="请选择出发日期" holder="时间/日期" maxlength="20" name="idtGoDateMult" />
	</label> <a class="dele_btn" href="javascript:;">删除</a></li>
	<li class="addLine"><a href="javascript:;" class="add_btn">添加航程</a></li>
</ul>
</div>
-->

<div class="need_btn_search"><input href="javascript:void(0);"
	class="search_btn submitSearch" type="button" id="iflightSubmit"
	data-submit-url="data/flightinterajax.jsp?action=SEARCHURL"
	data-citydata-url="data/flightinterajax.jsp?action=SEARCHSOURCE"
	value="搜 索" /></div>
<!--
<div class="need_a">
<p style="display: none">更多需求请填<a target="_blank"
	href="#" title="国际及港澳台机票需求单">国际及港澳台机票需求单</a></p>
<p>10人以上团队请填<a target="_blank"
	href="#"
	title="团队需求单">团队需求单</a></p>
</div>
-->
</div>
</div>
</div>
</div>
<!--end 机票tab内容--> <!--景点门票tab内容开始-->



<div class="tray none">
<div id="tab_top_scenic" class="tab_scenic_con">
<table>
	<tbody>
		<tr>
			<td class="scenicTitle">20000种景点门票免费预订</td>
			<td class="scenicMap"><span class="scenicMap_img"></span> <a
				title="地图找景点" class="searchSenic" target="_blank" rel="nofollow"
				href="#">地图找景点</a></td>
		</tr>
		<tr>
			<td class="scenicInput" colspan="2"><input type="text"
				value="景点名或城市名" name="SeachName" maxlength="20" onclick="if($('#SeachName_spot').val()=='景点名或城市名'){$('#SeachName_spot').val('')}"
				id="SeachName_spot" class="input02" />
			<!--<div id="hotCitys" class="cityout"></div>
			<div id="scenlInfo_list"></div>
			<div style="margin-left: 162px; display: none;" id="scenicMasErr1"
				class="errMasBorder"><span class="lefSpan"></span> <span
				class="rgtSpan">请输入景点名或城市名</span></div>
			--></td>
		</tr>
		<tr class="scenicBtn_tr">
			<td class="scenicBtn" colspan="2"><input id="scenicSubmit_XXX"
				type="button" class="search_btn" onclick="subspot();"
				value="搜 索" /></td>
		</tr>
		<tr>
			<td colspan="2">
			<dl class="recom_list">
				<dt class="recom_dt">精选主题：</dt>
				<dd class="recom_dd"><a class="recom_a" target="_blank"
					href=#>主题乐园</a>
				<a class="recom_a" target="_blank"
					href="#">热卖温泉</a>
				<a class="recom_a" target="_blank"
					href="#">刺激滑雪</a>
				<a class="recom_a" target="_blank"
					href="#">古镇山水</a>
				</dd>
			</dl>
			
			<!--
			<div class="scenic_list01">热搜城市：</div>
			<ul id="seSceDes" class="scenic_list01 clearfix">
				<div class="udiy" id="searchbox-scenery-destination"></div>
			</ul>
			<div class="scenery_search_city_more" id="searchCityMore"><span
				class="oteCitySpan"> <a href="javascript:;" class="oteCity">
			更多</a> <b></b> </span>
			<div class="box" id="searchCityBox" style="display: none;"></div>
			</div>
			
			<div class="scenic_list03">热搜景点：</div>
			<ul id="seSceTj" class="scenic_list02">
				<div class="udiy" id="searchbox-scenery-tj"></div>
			</ul>
			-->
			</td>
		</tr>
	</tbody>
</table>

</div>
</div>


<!--end 景点门票tab内容--> <!--自助游tab内容开始-->
 <form id="form4" name="form4"  action="spotline!SeachSpotline.jspx" method="post">
<div class="tray none">
<div class="tab_self_con">
<table>
	<tbody>
		<tr>
			<td class="selfTitle"><b class="hotel_ticket">景点+酒店——自由，纯玩，实惠</b></td>
		</tr>
		<tr>
			<td class="selfTitle">行程轻松，预订便捷，套餐价更低！</td>
		</tr>
		<td class="selfInput" colspan="2">
		<!--<input type="text" value="请输入景点名或城市名" class="input02"/>-->
		<div class="selfRelDiv"><input type="text" value="天目湖御水温泉" onclick="if($('#SeachName_line').val()=='天目湖御水温泉'){$('#SeachName_line').val('')}"
			id="SeachName_line" name="SeachName" maxlength="25" class="input02"
			style="color: rgb(153, 153, 153);">
		<div id="selfInfo_list" class="selfInfo_list"></div>
		<div class="errMasBorder" id="zzyMasErr" style="display: none;">
		<span class="lefSpan"></span> <span class="rgtSpan">天目湖御水温泉</span></div>
		</div>
		<div class="udiy" id="selftj"></div>
		</td>
		<tr class="selfBtn_tr">
			<td class="selfBtn" colspan="2"><input id="sous_btun_xxx"
				type="submit" href="javascript:void(0);" class="search_btn"
				value="搜索" /></td>
		</tr>
	</tbody>
</table>
<div class="udiy" id="searchbox-self-hotsearchnew"></div>
</div>
</div>
</form>
<!--end 自助游tab内容--> <!--出境游tab内容开始-->
<div class="tray none">
<div id="tab_top_holiday" class="tab_abroad_con">


<table>
	<tbody>
		<tr>
			<td class="abroadTitle" colspan="2">便捷 放心 360度服务</td>
		</tr>
		<tr>
			<td class="abroadTd">出发地：</td>
			<td class="abroadInput"><select id="sel_abroad"
				name="sel_abroad" class="select02">

			</select></td>
		</tr>
		<tr>
			<td class="abroadTd">目的地：</td>
			<td class="abroadInput"><input id="txtDestinationCity"
				name="txtDestinationCity" type="text" value="韩国" class="input02" />
			<div style="display: none;" id="abroadMasErr1" class="errMasBorder">
			<span class="lefSpan"></span> <span class="rgtSpan">请输入景点名或城市名</span>
			</div>
			</td>
		</tr>
		<tr class="abroadBtn_tr">
			<td class="abroadBtn" colspan="2"><input id="abroadSearch_xxx"
				type="button" href="javascript:void(0);" class="search_btn"
				value="搜索" /></td>
		</tr>
	</tbody>
</table>
<dl class="recom_list">
	<dt class="recom_dt">精选主题：</dt>
	<dd class="recom_dd"><a class="recom_a" target="_blank"
		href="#">易恒天下程包船</a> <a class="recom_a"
		target="_blank" href=#">春节豪礼</a> <a
		class="recom_a" target="_blank"
		href="#">蜜月旅游</a> <a class="recom_a"
		target="_blank" href="#">丽星邮轮</a>
	</dd>
	<dt class="recom_dt">热搜出境：</dt>
	<dd class="recom_dd"><a class="recom_a" target="_blank"
		href="#">韩国</a>
	<a class="recom_a" target="_blank"
		href="#">泰国</a>
	<a class="recom_a" target="_blank"
		href="#">欧洲</a>
	<a class="recom_a" target="_blank"
		href="#">长滩岛</a>
	<a class="recom_a" target="_blank"
		href="#">普吉岛</a>
	<a class="recom_a" target="_blank"
		href="#">马尔代夫</a>
	</dd>
	<dt class="recom_dt">签证办理：</dt>
	<dd class="recom_dd"><a class="recom_a" target="_blank"
		href="#">韩国</a> <a
		class="recom_a" target="_blank"
		href="#">美国</a> <a
		class="recom_a" target="_blank"
		href="#">泰国</a> <a
		class="recom_a" target="_blank"
		href="#">欧洲法国</a></dd>
</dl>
<div class="scenery_search_city_more" id="abroadSearchCityMore"><span
	class="oteCitySpan"> <a href="javascript:;" class="oteCity">
更多</a> <b></b> </span>
<div class="box" id="abroadSearchCityBox" style="display: none;"></div>
</div>


</div>
</div>
<!--end 出境游tab内容-->
<div class="tray none"><!--手机版tab内容开始-->
<div class="tab_phone_con">
<!--
<div class="wireless_div clearfix"><span class="wireless_title"></span><span
	class="wireless_begin"></span></div>
-->
<dl class="list clearfix">
	<dt class="list_tit">手机号码</dt>
	<dd class="list_con listPhone"><input id="searchPhoneNum" style="width: 180px;"
		type="text" class="input02" maxlength="11" value="请输入您的手机号码" /> <label
		id="inPhoneErr" for="searchPhoneNum" class="phoneErrSp none">
	<span class="phoneErr">请输入正确的手机号码</span> <label class="phoneLbl"></label>
	</label></dd>
</dl>
<dl class="list clearfix">
	<dt class="list_tit">验证码</dt>
	<dd class="list_con listYzm"><input id="scheckNum" type="text"
		class="input02 inputShort" /> <img id="showCodeImg"
		class="checkCodeImg" title="点击刷新验证码"> <span id="CodeImgErr"
		class="yzmErr none">验证码错误</span></dd>
</dl>
<dl class="list_btn_search clearfix">
	<dt class="list_tit"></dt>
	<dd class="list_con"><input id="searchClint" type="button"
		href="javascript:void(0);" class="search_btn" value="免费发送下载地址到手机" /></dd>
</dl>
<dl class="list download_list01 clearfix">
	<dt class="list_tit">直接下载</dt>
	<dd class="list_con"><span class="iphone"></span><a
		class="iph_word" href="#">iPhone</a>
	<span class="android"></span><a class="and_word"
		href="#">Android</a></dd>
</dl>
<!--
<div class="phone_pic clearfix"><img class="phone_img"
	src="http://img1.40017.cn/cn/c/home/2013/p/201306/phone.jpg"
	alt="手机点评……"> <span class="phone_weixin"></span></div>
-->
<!--end 手机版tab内容-->
</div>
</div>
<!--end tab内容--> <!--end 搜索框--></div>






</div>
</div>
<!--end 搜索框-->

	

 <!--幻灯开始-->
<div class="sliderMain" id="sliderMainId">
<div id="portal-block-622772880883" class="udiyblock" type="AdModel">
<ul id="sliderTab" class="sliderTab clearfix">
	<li><a href="javascript:void(0);" title="感恩回馈" class="tabA"
		nIndex="1">感恩回馈</a>
	<div class="sliderSp none"><span></span></div>
	</li>
	<li><a href="javascript:void(0);" title="超值酒店" class="tabA"
		nIndex="2">超值酒店</a>
	<div class="sliderSp none"><span></span></div>
	</li>
	<li><a href="javascript:void(0);" title="景点放价" class="tabA"
		nIndex="3">景点放价</a>
	<div class="sliderSp none"><span></span></div>
	</li>
	<li><a href="javascript:void(0);" title="自驾租车" class="tabA"
		nIndex="4">自驾租车</a>
	<div class="sliderSp none"><span></span></div>
	</li>
	<li><a href="javascript:void(0);" title="特价机票" class="tabA"
		nIndex="5">特价机票</a>
	<div class="sliderSp none"><span></span></div>
	</li>
	<li><a href="javascript:void(0);" title="节日特惠" class="tabA"
		nIndex="6">节日特惠</a>
	<div class="sliderSp none"><span></span></div>
	</li>
</ul>
</div>
<div id="portal-block-601688869836" class="udiyblock" type="AdModel">
<div style="position: relative; overflow: hidden;" class="sliderDiv"
	id="sliderDiv">
<ul class="sliderCon clearfix"
	style="position: relative; width: 2000px;" id="sliderUlId">
	<li>
	<div class="sliderLeftDiv"><img src="images/hotel/ttjx.jpg" /></div>
	<div class="sliderRightDiv"><a class="sliderConA sliderConTop"
		href="#" target="_blank"> <span class="sliderConSp">臻享易恒天下</span> <span
		class="sliderConSp">天天惊喜拿不停</span> </a> <a class="sliderConA sliderConBottom"
		href="#" target="_blank"> <span class="sliderConSp">会员免费抽奖</span>
	<span class="sliderConSp">免费体验自驾游</span> </a></div>
	</li>
	<li style="display: none;">
	<div class="sliderLeftDiv"><img
		src="images/hotel/chaojihotel.jpg" /></div>
	<div class="sliderRightDiv"><a
		class="sliderConA sliderConTop sliderConPink" href="#" target="_blank">
	<span class="sliderConSp">易恒天下酒店</span> <span class="sliderConSp">低价高品质享受</span>
	</a> <a class="sliderConA sliderConBottom sliderConBlue" href="#"
		target="_blank"> <span class="sliderConSp">星级酒店</span> <span
		class="sliderConSp">低至368元</span> </a></div>
	</li>
	<li style="display: none;">
	<div class="sliderLeftDiv"><img src="images/hotel/youwan.jpg" />
	</div>
	<div class="sliderRightDiv"><a
		class="sliderConA sliderConTop sliderConGreen" href="#"
		target="_blank"> <span class="sliderConSp">杭州西湖游</span> <span
		class="sliderConSp">三日超值体验</span> </a> <a
		class="sliderConA sliderConBottom sliderConOrange" href="#"
		target="_blank"> <span class="sliderConSp">梦幻紫禁城</span> <span
		class="sliderConSp">玩转京都</span> </a></div>
	</li>
	<li style="display: none;">
	<div class="sliderLeftDiv"><img src="images/hotel/zijia.jpg" />
	</div>
	<div class="sliderRightDiv"><a
		class="sliderConA sliderConTop sliderConLigGreen" href="#"
		target="_blank"> <span class="sliderConSp">假日预售</span> <span
		class="sliderConSp">自驾游开启</span> </a> <a
		class="sliderConA sliderConBottom sliderConCyan" href="#"
		target="_blank"> <span class="sliderConSp">易恒天下</span> <span
		class="sliderConSp">爱她就给她享受</span> </a>
	</li>
	<li style="display: none;">
	<div class="sliderLeftDiv"><img src="images/hotel/tjjp.jpg" /></div>
	<div class="sliderRightDiv"><a
		class="sliderConA sliderConTop sliderConLigGreen" href="#"
		target="_blank"> <span class="sliderConSp">订机票</span> <span
		class="sliderConSp">返奖金</span> </a> <a
		class="sliderConA sliderConBottom sliderConCyan" href="#"
		target="_blank"> <span class="sliderConSp">往返至极</span> <span
		class="sliderConSp">更优惠</span> </a></div>
	</li>
	<li style="display: none;">
	<div class="sliderLeftDiv"><img src="images/hotel/chunjie.jpg" />
	</div>
	<div class="sliderRightDiv"><a
		class="sliderConA sliderConTop sliderConYellow" href="#"
		target="_blank"> <span class="sliderConSp">玩转歌诗达</span> <span
		class="sliderConSp">易恒天下</span> </a> <a
		class="sliderConA sliderConBottom sliderConLigGreen" href="#"
		target="_blank"> <span class="sliderConSp">情定海岛</span> <span
		class="sliderConSp">蜜月首选</span> </a></div>
	</li>
</ul>
</div>
</div>
<!--蒙版-->
<div class="sliderMeng meng1 none" id="sliderMengTop"></div>
<div class="sliderMeng meng2 none" id="sliderMengBottom"></div>
<!--end 蒙版-->
</div>


<!--end 幻灯--></div>
<div class="contentMain clearfix">
<div class="leftMain"><!--景点部分-->
<div class="BoxDiv scenicBox clearfix">
<div class="leftImgBox senicLeftImgBox">
<div id="portal-block-306767044042" class="udiyblock" type="AdModel">
<a class="imgTop img1" title="十万张门票免费送！" href="#" target="_blank"> <img
	src="images/index/index_spot.jpg" alt=""></a> <a class="imgTop img2"
	title="会员日" href="#" target="_blank"><img
	src="images/spotticket/ad_spotticket_01.jpg" alt=""></a> <a
	class="imgTop img3" title="东部华侨城" href="#" target="_blank"><img
	class="imgTop img3" src="images/spotticket/ad_spotticket_02.jpg" alt=""></a></div>
</div>
<div id="scenicListBox" class="rightListBox scenicListBox">
<div class="ListBoxTabDiv scenicBoxTab clearfix">
<div id="portal-block-826619946112" class="udiyblock"
	type="CommonSource"><span class="iThinkSp scenicThinkSp">易恒推荐
特</span> <span class="playSp scenicPlaySp">优</span> <span
	class="iThinkSp scenicThinkSp pThink">专场</span>
<div class="listBoxTabDv1 clearfix">
<ul class="ListBoxTabUl" id="ListBoxTabUlSenic">
<!-- 本地 -->
<!--
	<li class="listBoxTabLi"><a title="北京" href="javascript:void(0);" onclick="selectspotticket(0,52);"
		pid="3" id="index_spotticket_0" class="city cityMiddle  CityA senicCityA2"> <span
		class="citySp">北京</span> </a></li>
	<li class="listBoxTabLi"><a title="苏州" href="javascript:void(0);" onclick="selectspotticket(1,221);"
		pid="16" id="index_spotticket_1" class="city cityMiddle "> <span class="citySp">苏州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="九江" href="javascript:void(0);" onclick="selectspotticket(2,238);"
		pid="16" id="index_spotticket_2" class="city cityMiddle "> <span class="citySp">九江</span>
	</a></li>
	<li class="listBoxTabLi"><a title="杭州" href="javascript:void(0);" onclick="selectspotticket(3,383);"
		pid="31" id="index_spotticket_3" class="city cityMiddle "> <span class="citySp">杭州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="湖州" href="javascript:void(0);" onclick="selectspotticket(4,384);"
		pid="25" id="index_spotticket_4" class="city cityMiddle "> <span class="citySp">湖州</span>
	</a></li>
-->
<!-- 服务器 -->
<li class="listBoxTabLi"><a title="北京" href="javascript:void(0);" onclick="selectspotticket(0,53);"
		pid="3" id="index_spotticket_0" class="city cityMiddle  CityA senicCityA2"> <span
		class="citySp">北京</span> </a></li>
	<li class="listBoxTabLi"><a title="苏州" href="javascript:void(0);" onclick="selectspotticket(1,226);"
		pid="16" id="index_spotticket_1" class="city cityMiddle "> <span class="citySp">苏州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="九江" href="javascript:void(0);" onclick="selectspotticket(2,238);"
		pid="16" id="index_spotticket_2" class="city cityMiddle "> <span class="citySp">九江</span>
	</a></li>
	<li class="listBoxTabLi"><a title="杭州" href="javascript:void(0);" onclick="selectspotticket(3,383);"
		pid="31" id="index_spotticket_3" class="city cityMiddle "> <span class="citySp">杭州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="湖州" href="javascript:void(0);" onclick="selectspotticket(4,384);"
		pid="25" id="index_spotticket_4" class="city cityMiddle "> <span class="citySp">湖州</span>
	</a></li>
</ul>
<a class="moreViewBtn" href="spotticket.jspx" title="更多美景">更多美景&gt;&gt;</a>
</div>
<a class="moreCityBtn" target="_blank"
	href="spotticket.jspx"
	title="更多景点信息">更多景点信息&gt;&gt;</a></div>
</div>
<ul class="listBoxViewUl clearfix" id="senicListBoxViewUl">
	<div id="index_divSpotticketHtml" class="udiyblock"
		type="CommonSource">
	<!--
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="石景山游乐园"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3297.html"
			target="_blank" class="listViewimg"> <img
			src="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/11/08/2/201311081043377964216.jpg"
			alt="石景山游乐园"> </a> <label class="topNum">Top 1</label></dd>
		<dd class="listViewInf"><a class="senicName" title="石景山游乐园"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3297.html"
			target="_blank">石景山游乐园</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">111</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="十三陵"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3150.html"
			target="_blank" class="listViewimg"> <img
			src="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/03/06/2/2013030616401979386.jpg"
			alt="十三陵"> </a> <label class="topNum">Top 2</label></dd>
		<dd class="listViewInf"><a class="senicName" title="十三陵"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3150.html"
			target="_blank">十三陵</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">31</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="北京蓝天城"
			href="http://www.17u.cn/scenery/BookSceneryTicket_27591.html"
			target="_blank" class="listViewimg"> <img
			src="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/05/22/2/2013052210433774600.jpg"
			alt="北京蓝天城"> </a> <label class="topNum">Top 3</label></dd>
		<dd class="listViewInf"><a class="senicName" title="北京蓝天城"
			href="http://www.17u.cn/scenery/BookSceneryTicket_27591.html"
			target="_blank">北京蓝天城</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">80</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="南山滑雪场"
			href="http://www.17u.cn/scenery/BookSceneryTicket_4757.html"
			target="_blank" class="listViewimg"> <img
			src="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/03/18/2/2013031815150223186.jpg"
			alt="南山滑雪场"> </a> <label class="topNum">Top 4</label></dd>
		<dd class="listViewInf"><a class="senicName" title="南山滑雪场"
			href="http://www.17u.cn/scenery/BookSceneryTicket_4757.html"
			target="_blank">南山滑雪场</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">155</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="运河苑温泉度假村"
			href="http://www.17u.cn/scenery/BookSceneryTicket_23857.html"
			target="_blank" class="listViewimg"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/09/26/2/201309261714401084628.jpg"
			nalt="运河苑温泉度假村"> </a> <label class="topNum">Top 5</label></dd>
		<dd class="listViewInf"><a class="senicName" title="运河苑温泉度假村"
			href="http://www.17u.cn/scenery/BookSceneryTicket_23857.html"
			target="_blank">运河苑温泉度假村</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">135</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="军都山滑雪场"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3685.html"
			target="_blank" class="listViewimg"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2011/11/24/2/2011112416150881307.jpg"
			nalt="军都山滑雪场"> </a> <label class="topNum">Top 6</label></dd>
		<dd class="listViewInf"><a class="senicName" title="军都山滑雪场"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3685.html"
			target="_blank">军都山滑雪场</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">150</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="北京比如世界"
			href="http://www.17u.cn/scenery/BookSceneryTicket_26596.html"
			target="_blank" class="listViewimg"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/07/25/2/2013072515201397805.jpg"
			nalt="北京比如世界"> </a> <label class="topNum">Top 7</label></dd>
		<dd class="listViewInf"><a class="senicName" title="北京比如世界"
			href="http://www.17u.cn/scenery/BookSceneryTicket_26596.html"
			target="_blank">北京比如世界</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">266</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="八达岭野生动物园"
			href="http://www.17u.cn/scenery/BookSceneryTicket_4709.html"
			target="_blank" class="listViewimg"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2011/08/23/2/2011082317163159333.jpg"
			nalt="八达岭野生动物园"> </a> <label class="topNum">Top 8</label></dd>
		<dd class="listViewInf"><a class="senicName" title="八达岭野生动物园"
			href="http://www.17u.cn/scenery/BookSceneryTicket_4709.html"
			target="_blank">八达岭野生动物园</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">70</span></dd>
	</dl>
	</li>
	-->
	</div>
</ul>
</div>
</div>

<!-- 酒店开始 -->
<div class="BoxDiv scenicBox clearfix">
<div class="leftImgBox senicLeftImgBox">
<div id="portal-block-306767044042" class="udiyblock" type="AdModel">
<a class="imgTop img1"  href="#" target="_blank"> <img
	src="images/index/hotelindex.jpg" alt=""></a> <a class="imgTop img2"
	title="" href="#" target="_blank"><img
	src="images/index/ad_hotel_01.jpg" alt=""></a> <a
	class="imgTop img3" title="东部华侨城" href="#" target="_blank"><img
	class="imgTop img3" src="images/index/ad_hotel_02.jpg" alt=""></a></div>
</div>
<div id="scenicListBox" class="rightListBox scenicListBox">
<div class="ListBoxTabDiv scenicBoxTab clearfix">
<div id="portal-block-826619946112" class="udiyblock"
	type="CommonSource"><span class="iThinkSp scenicThinkSp">易恒推荐
特</span> <span class="playSp scenicPlaySp">惠</span> <span
	class="iThinkSp scenicThinkSp pThink">酒店</span>
<div class="listBoxTabDv1 clearfix">
<ul class="ListBoxTabUl" id="ListBoxTabUlSenic">
<!-- 本地 -->
	<!--
	<li class="listBoxTabLi"><a title="北京" href="javascript:void(0);" onclick="selecthotel(0,607);"
		pid="3" id="index_hotel_0" class="city cityMiddle  CityA senicCityA2"> <span
		class="citySp">北京</span> </a></li>
	<li class="listBoxTabLi"><a title="苏州" href="javascript:void(0);" onclick="selecthotel(1,226);"
		pid="16" id="index_hotel_1" class="city cityMiddle CityA senicCityA2" > <span class="citySp">苏州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="常州" href="javascript:void(0);" onclick="selecthotel(2,221);"
		pid="16" id="index_hotel_2" class="city cityMiddle "> <span class="citySp">常州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="杭州" href="javascript:void(0);" onclick="selecthotel(3,383);"
		pid="31" id="index_hotel_3" class="city cityMiddle "> <span class="citySp">杭州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="上海" href="javascript:void(0);" onclick="selecthotel(4,321);"
		pid="25" id="index_hotel_4" class="city cityMiddle "> <span class="citySp">上海</span>
	</a></li>
	-->
	<!-- 服务器 -->
	<li class="listBoxTabLi"><a title="北京" href="javascript:void(0);" onclick="selecthotel(0,15495);"
		pid="3" id="index_hotel_0" class="city cityMiddle  CityA senicCityA2"> <span
		class="citySp">北京</span> </a></li>
	<li class="listBoxTabLi"><a title="苏州" href="javascript:void(0);" onclick="selecthotel(1,15769);"
		pid="16" id="index_hotel_1" class="city cityMiddle CityA senicCityA2" > <span class="citySp">苏州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="常州" href="javascript:void(0);" onclick="selecthotel(2,15770);"
		pid="16" id="index_hotel_2" class="city cityMiddle "> <span class="citySp">常州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="杭州" href="javascript:void(0);" onclick="selecthotel(3,15836);"
		pid="31" id="index_hotel_3" class="city cityMiddle "> <span class="citySp">杭州</span>
	</a></li>
	<li class="listBoxTabLi"><a title="上海" href="javascript:void(0);" onclick="selecthotel(4,15496);"
		pid="25" id="index_hotel_4" class="city cityMiddle "> <span class="citySp">上海</span>
	</a></li>
</ul>
<!-- <a class="moreViewBtn" href="#" title="更多美景">更多美景&gt;&gt;</a> -->

</div>
<a class="moreCityBtn" target="_blank"
	href="hotel!toindex.jspx"
	title="更多酒店信息">更多酒店信息&gt;&gt;</a></div>
</div>
<ul class="listBoxViewUl clearfix" id="senicListBoxViewUl">
	<div id="index_hotel_div" class="udiyblock"
		type="CommonSource">
	<!--
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="石景山游乐园"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3297.html"
			target="_blank" class="listViewimg"> <img
			src="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/11/08/2/201311081043377964216.jpg"
			alt="石景山游乐园"> </a> <label class="topNum">Top 1</label></dd>
		<dd class="listViewInf"><a class="senicName" title="石景山游乐园"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3297.html"
			target="_blank">石景山游乐园</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">111</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="十三陵"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3150.html"
			target="_blank" class="listViewimg"> <img
			src="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/03/06/2/2013030616401979386.jpg"
			alt="十三陵"> </a> <label class="topNum">Top 2</label></dd>
		<dd class="listViewInf"><a class="senicName" title="十三陵"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3150.html"
			target="_blank">十三陵</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">31</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="北京蓝天城"
			href="http://www.17u.cn/scenery/BookSceneryTicket_27591.html"
			target="_blank" class="listViewimg"> <img
			src="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/05/22/2/2013052210433774600.jpg"
			alt="北京蓝天城"> </a> <label class="topNum">Top 3</label></dd>
		<dd class="listViewInf"><a class="senicName" title="北京蓝天城"
			href="http://www.17u.cn/scenery/BookSceneryTicket_27591.html"
			target="_blank">北京蓝天城</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">80</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="南山滑雪场"
			href="http://www.17u.cn/scenery/BookSceneryTicket_4757.html"
			target="_blank" class="listViewimg"> <img
			src="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/03/18/2/2013031815150223186.jpg"
			alt="南山滑雪场"> </a> <label class="topNum">Top 4</label></dd>
		<dd class="listViewInf"><a class="senicName" title="南山滑雪场"
			href="http://www.17u.cn/scenery/BookSceneryTicket_4757.html"
			target="_blank">南山滑雪场</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">155</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="运河苑温泉度假村"
			href="http://www.17u.cn/scenery/BookSceneryTicket_23857.html"
			target="_blank" class="listViewimg"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/09/26/2/201309261714401084628.jpg"
			nalt="运河苑温泉度假村"> </a> <label class="topNum">Top 5</label></dd>
		<dd class="listViewInf"><a class="senicName" title="运河苑温泉度假村"
			href="http://www.17u.cn/scenery/BookSceneryTicket_23857.html"
			target="_blank">运河苑温泉度假村</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">135</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="军都山滑雪场"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3685.html"
			target="_blank" class="listViewimg"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2011/11/24/2/2011112416150881307.jpg"
			nalt="军都山滑雪场"> </a> <label class="topNum">Top 6</label></dd>
		<dd class="listViewInf"><a class="senicName" title="军都山滑雪场"
			href="http://www.17u.cn/scenery/BookSceneryTicket_3685.html"
			target="_blank">军都山滑雪场</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">150</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="北京比如世界"
			href="http://www.17u.cn/scenery/BookSceneryTicket_26596.html"
			target="_blank" class="listViewimg"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2013/07/25/2/2013072515201397805.jpg"
			nalt="北京比如世界"> </a> <label class="topNum">Top 7</label></dd>
		<dd class="listViewInf"><a class="senicName" title="北京比如世界"
			href="http://www.17u.cn/scenery/BookSceneryTicket_26596.html"
			target="_blank">北京比如世界</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">266</span></dd>
	</dl>
	</li>
	<li class="listBoxViewLi">
	<dl class="listViewDl">
		<dd class="listViewDd"><a title="八达岭野生动物园"
			href="http://www.17u.cn/scenery/BookSceneryTicket_4709.html"
			target="_blank" class="listViewimg"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_common/160_120/2011/08/23/2/2011082317163159333.jpg"
			nalt="八达岭野生动物园"> </a> <label class="topNum">Top 8</label></dd>
		<dd class="listViewInf"><a class="senicName" title="八达岭野生动物园"
			href="http://www.17u.cn/scenery/BookSceneryTicket_4709.html"
			target="_blank">八达岭野生动物园</a></dd>
		<dd class="listViewInf listViewBotm">易恒天下价：<span class="dollar">¥</span><span
			class="price">70</span></dd>
	</dl>
	</li>
	-->
	</div>
</ul>
</div>
</div>

<!--自助游部分-->
<div class="BoxDiv selfBox clearfix">
<div class="leftImgBox selfLeftImgBox">
<div id="portal-block-739233299042" class="udiyblock" type="AdModel">
<a class="imgTop img1"
	href="#" target="_blank">
<img
	src="images/index/index_spotline.jpg"
	alt="" border="0" usemap="#Map" class="imgTop img1"> <label
	class="lbl_self"></label> </a> <a class="imgTop img2"
	href="#"
	target="_blank"> <img class="imgTop img2"
	src="images/index/ad_spotline_01.jpg"
	alt="" /> </a> <a class="imgTop img3"
	href="#"
	target="_blank"><img class="imgTop img3"
	src="images/index/ad_spotline_02.jpg"
	alt="" /></a></div>
</div>
<div id="selfListBox" class="rightListBox selfListBox">
<div class="ListBoxTabDiv selfBoxTab clearfix">
<div id="portal-block-585831925292" class="udiyblock"
	type="CommonSource"><span class="iThinkSp selfThinkSp">旅游套餐
超</span> <span class="playSp selfPlaySp">值</span> <span
	class="iThinkSp selfThinkSp pThink">低价</span>
<div class="listBoxTabDv1 clearfix">
<ul class="ListBoxTabUl" id="ListBoxTabUlSelf">
	<li class="listBoxTabLi"><a title="北京" href="javascript:void(0);" onclick="selectspotline(1,15495);"
		cname="北京" id="index_spotline_1" pyname="beijing" type="self"
		class="city cityMiddle CityA selfCityA2"> <span class="citySp">北京</span></a>
	</li>
	<li class="listBoxTabLi"><a title="天津" href="javascript:void(0);" onclick="selectspotline(2,343);"
		cname="天津" id="index_spotline_2" pyname="wuxi" type="self"
		class="city cityMiddle "> <span class="citySp">天津</span></a></li>
		
	<li class="listBoxTabLi"><a title="合肥" href="javascript:void(0);" onclick="selectspotline(3,3401);"
		cname="合肥" id="index_spotline_3" pyname="qingdao" type="self"
		class="city cityMiddle "> <span class="citySp">合肥</span></a></li>
		
	<li class="listBoxTabLi"><a title="三亚" href="javascript:void(0);" onclick="selectspotline(4,121);"
		cname="三亚" id="index_spotline_4" pyname="chengdu" type="self"
		class="city cityMiddle "> <span class="citySp">三亚</span></a></li>
</ul>
<a class="moreViewBtn" href="#" title="更多地方">更多地方&gt;&gt;</a>
</div>
<a class="moreCityBtn" href="#"
	title="更多北京自助游" target="_blank">更多北京自助游&gt;&gt;</a></div>
</div>
<ul class="listBoxViewUl selfViewUl" id="selfListBoxViewUl">
	<div id="index_spotline" class="udiyblock"
		type="CommonSource">
	<!--
	<li class="selfBoxViewLi selfBoxFirstLi c_selfBoxViewLi2 clearfix">
	<label class="lbl_lst c_lbl_lst2">1314<span>狂欢节</span></label> <a
		class="selfBoxViewA"
		title="【0利大促】【精品温泉】【温都水城+湖湾酒店】假日休闲畅游温都水城，自选水空间、养生馆通票，自助餐，滑雪，住温都水城度假村湖湾酒店+双份精美早餐+免费停车、宽带"
		href="http://www.17u.cn/zizhuyou/beijing53/33438-xianlu/"
		target="_blank"
		nsrc="http://img.17u.cn/ly/cn/img/zizhuyou/lineimage/100_75/2013/11/21/201311211108583403.jpg"
		nalt=""> </a>
	<div class="selfBoxNoteDiv">
	<dl class="selfBoxNoteDl">
		<dd class="selfBoxNote"><a
			href="http://www.17u.cn/zizhuyou/beijing53/33438-xianlu/"
			target="_blank"
			title="【0利大促】【精品温泉】【温都水城+湖湾酒店】假日休闲畅游温都水城，自选水空间、养生馆通票，自助餐，滑雪，住温都水城度假村湖湾酒店+双份精美早餐+免费停车、宽带"
			class="selfBoxNoteA1">【0利大促】【精品温泉】【温都水城+湖湾酒店】假日休闲畅</a></dd>
		<dd class="selfBoxNote"><a
			href="http://www.17u.cn/zizhuyou/beijing53/33438-xianlu/"
			target="_blank"
			title="【双蛋特价预售，最后5套】【北京】【自选】北京温都水城HI-水空间、养生馆通票2张或自助餐券票2张+北京温都水城湖湾酒店客房1晚（含双早）"
			class="selfBoxNoteA2">【双蛋特价预售，最后5套】【北京】【自选】北京温都水城H</a></dd>
		<dd class="selfBoxNote"><span class="c_selfBoxCommWidth">
		<span class="selfBoxCommSp selfBoxCommImg1"></span> <a class="fontSp"
			title="评论" href="http://www.17u.cn/zizhuyou/beijing53/33438-xianlu/"
			target="_blank">1</a>条评论 </span> <span class="selfBoxCommSp selfBoxCommImg2"></span>
		<span class="fontSp personSp">24</span>人购买</dd>
	</dl>
	<dl class="selfPriceDl">
		<dd class="selfPriceDd1"><a class="selfPriceSp" title="价格"
			href="http://www.17u.cn/zizhuyou/beijing53/33438-xianlu/"
			target="_blank"><span class="dollar">¥</span>323</a>起/人</dd>

	</dl>
	</div>
	</li>
	<li class="selfBoxViewLi  clearfix"><label class="lbl_lst">1314<span>狂欢节</span></label>
	<a class="selfBoxViewA"
		title="【精品温泉】【温都水城+水城国际酒店】假日休闲，畅游温都水城，自选水空间、养生馆通票，自助餐，滑雪，住温都水城国际酒店+双份精美早餐+免费停车+免费宽带"
		href="http://www.17u.cn/zizhuyou/beijing53/33436-xianlu/"
		target="_blank"
		nsrc="http://img.17u.cn/ly/cn/img/zizhuyou/rimage/100_75/2013/10/15/201310150436031173.jpg"
		nalt=""> </a>
	<div class="selfBoxNoteDiv">
	<dl class="selfBoxNoteDl">
		<dd class="selfBoxNote"><a
			href="http://www.17u.cn/zizhuyou/beijing53/33436-xianlu/"
			target="_blank"
			title="【精品温泉】【温都水城+水城国际酒店】假日休闲，畅游温都水城，自选水空间、养生馆通票，自助餐，滑雪，住温都水城国际酒店+双份精美早餐+免费停车+免费宽带"
			class="selfBoxNoteA1">【精品温泉】【温都水城+水城国际酒店】假日休闲，畅游温都</a></dd>
		<dd class="selfBoxNote"><a
			href="http://www.17u.cn/zizhuyou/beijing53/33436-xianlu/"
			target="_blank"
			title="【北京】【自选】北京温都水城HI-水空间、养生馆通票2张或自助餐券票2张+北京温都水城国际酒店客房1晚（含双早）"
			class="selfBoxNoteA2">【北京】【自选】北京温都水城HI-水空间、养生馆通票2张</a></dd>
		<dd class="selfBoxNote"><span class="c_selfBoxCommWidth">
		<span class="selfBoxCommSp selfBoxCommImg1"></span> <a class="fontSp"
			title="评论" href="http://www.17u.cn/zizhuyou/beijing53/33436-xianlu/"
			target="_blank">1</a>条评论 </span> <span class="selfBoxCommSp selfBoxCommImg2"></span>
		<span class="fontSp personSp">25</span>人购买</dd>
	</dl>
	<dl class="selfPriceDl">
		<dd class="selfPriceDd1"><a class="selfPriceSp" title="价格"
			href="http://www.17u.cn/zizhuyou/beijing53/33436-xianlu/"
			target="_blank"><span class="dollar">¥</span>218</a>起/人</dd>

	</dl>
	</div>
	</li>
	<li class="selfBoxViewLi  clearfix"><label class="lbl_lst">1314<span>狂欢节</span></label>
	<a class="selfBoxViewA"
		title="【精品温泉】【温都水城+宏福大厦】假日休闲，畅游温都水城温泉，自选水空间、养生馆通票，自助餐，滑雪，住温都水城宏福大厦+双份精美早餐+免费停车+免费宽带"
		href="http://www.17u.cn/zizhuyou/beijing53/33433-xianlu/"
		target="_blank"
		nsrc="http://img.17u.cn/ly/cn/img/zizhuyou/rimage/100_75/2013/10/15/201310150433497464.jpg"
		nalt=""> </a>
	<div class="selfBoxNoteDiv">
	<dl class="selfBoxNoteDl">
		<dd class="selfBoxNote"><a
			href="http://www.17u.cn/zizhuyou/beijing53/33433-xianlu/"
			target="_blank"
			title="【精品温泉】【温都水城+宏福大厦】假日休闲，畅游温都水城温泉，自选水空间、养生馆通票，自助餐，滑雪，住温都水城宏福大厦+双份精美早餐+免费停车+免费宽带"
			class="selfBoxNoteA1">【精品温泉】【温都水城+宏福大厦】假日休闲，畅游温都水城</a></dd>
		<dd class="selfBoxNote"><a
			href="http://www.17u.cn/zizhuyou/beijing53/33433-xianlu/"
			target="_blank"
			title="【北京】【自选】北京温都水城HI-水空间、养生馆通票2张或自助餐券票2张+北京温都水城宏福大厦客房1晚（含双早）"
			class="selfBoxNoteA2">【北京】【自选】北京温都水城HI-水空间、养生馆通票2张</a></dd>
		<dd class="selfBoxNote"><span class="c_selfBoxCommWidth">
		<span class="selfBoxCommSp selfBoxCommImg1"></span> <a class="fontSp"
			title="评论" href="http://www.17u.cn/zizhuyou/beijing53/33433-xianlu/"
			target="_blank">1</a>条评论 </span> <span class="selfBoxCommSp selfBoxCommImg2"></span>
		<span class="fontSp personSp">5</span>人购买</dd>
	</dl>
	<dl class="selfPriceDl">
		<dd class="selfPriceDd1"><a class="selfPriceSp" title="价格"
			href="http://www.17u.cn/zizhuyou/beijing53/33433-xianlu/"
			target="_blank"><span class="dollar">¥</span>358</a>起/人</dd>

	</dl>
	</div>
	</li>
	<li class="selfBoxViewLi nonBorderLi clearfix"><label
		class="lbl_lst">1314<span>狂欢节</span></label> <a class="selfBoxViewA"
		title="【圣诞&元旦特价预售，最后5套】【北京南山滑雪场】北京顶端优质滑雪场，冬季激情滑雪尽在南山滑雪场！入住精选北京世纪阳光假日酒店"
		href="http://www.17u.cn/zizhuyou/beijing53/46150-xianlu/"
		target="_blank"
		nsrc="http://img.17u.cn/ly/cn/img/zizhuyou/rimage/100_75/2013/11/14/201311140627278491.jpg"
		nalt=""> </a>
	<div class="selfBoxNoteDiv">
	<dl class="selfBoxNoteDl">
		<dd class="selfBoxNote"><a
			href="http://www.17u.cn/zizhuyou/beijing53/46150-xianlu/"
			target="_blank"
			title="【圣诞&元旦特价预售，最后5套】【北京南山滑雪场】北京顶端优质滑雪场，冬季激情滑雪尽在南山滑雪场！入住精选北京世纪阳光假日酒店"
			class="selfBoxNoteA1">【圣诞&元旦特价预售，最后5套】【北京南山滑雪场】北京顶</a></dd>
		<dd class="selfBoxNote"><a
			href="http://www.17u.cn/zizhuyou/beijing53/46150-xianlu/"
			target="_blank" title="北京南山滑雪场门票2张+北京世纪阳光假日酒店1晚"
			class="selfBoxNoteA2">北京南山滑雪场门票2张+北京世纪阳光假日酒店1晚</a></dd>
		<dd class="selfBoxNote"><span class="c_selfBoxCommWidth">
		<span class="selfBoxCommSp selfBoxCommImg1"></span> <a class="fontSp"
			title="评论" href="http://www.17u.cn/zizhuyou/beijing53/46150-xianlu/"
			target="_blank">2</a>条评论 </span> <span class="selfBoxCommSp selfBoxCommImg2"></span>
		<span class="fontSp personSp">30</span>人购买</dd>
	</dl>
	<dl class="selfPriceDl">
		<dd class="selfPriceDd1"><a class="selfPriceSp" title="价格"
			href="http://www.17u.cn/zizhuyou/beijing53/46150-xianlu/"
			target="_blank"><span class="dollar">¥</span>237</a>起/人</dd>

	</dl>
	</div>
	</li>
	-->
	</div>
</ul>
</div>
</div>
<!--出境游部分-->
<div class="BoxDiv abroadBox clearfix">
<div class="leftImgBox abroadLeftImgBox">
<div id="portal-block-37337000845" class="udiyblock" type="AdModel">
<a class="imgTop img1" title="出境游" href="#"
	target="_blank"> <img class="imgTop img1"
	src="images/index/pAbroad.jpg" alt="">
</a><a class="imgTop img2" title="香港旅游"
	href="#" target="_blank"> <img
	class="imgTop img2" alt=""
	src="images/index/22007_1.jpg">
</a></div>
</div>
<div id="abroadListBox" class="rightListBox abroadListBox">
<div class="ListBoxTabDiv abroadBoxTab clearfix"><span
	class="iThinkSp abroadThinkSp">易恒首发 限量</span> <span
	class="playSp abroadPlaySp">抢</span> <span
	class="iThinkSp abroadThinkSp pThink">购</span> <span
	class="changeImgSp"></span> <a style="display: none;" id="prevTap"></a>
<a class="changeWordSp" id="nextTap" href="javascript:void(0);">换一批</a>
<ul class="abroadViewUl" id="abroadViewUl">
	<li class="abroadViewLi"><a class="abroadViewA"
		href="#"
		target="_blank">泰国</a></li>
	<li class="abroadViewLi"><a class="abroadViewA"
		href="#" target="_blank">韩国</a></li>
	<li class="abroadViewLi"><a class="abroadViewA"
		href="#" target="_blank">海岛</a></li>
	<li class="abroadViewLi"><a class="abroadViewA"
		href="#"
		target="_blank">欧洲</a></li>
	<li class="abroadViewLi nonBorderLi"><a class="abroadViewA"
		href="#" target="_blank">邮轮</a></li>
</ul>
</div>
<div class="abroadListDiv">
<div id="portal-block-647234848612" class="udiyblock" type="AdModel">
<ul class="listBoxViewUl clearfix" id="abroadListBoxViewUl"
	style="position: relative; overflow: hidden; width: 2768px;">
	<li class="abroadListLi">
	<a title="葡萄牙+西班牙11日团队游(4钻)·AVE高铁 体验当地美食" href="spotline!toSpotLineInfo.jspx?SpotLineID=28" nalt="葡萄牙+西班牙11日团队游(4钻)·AVE高铁 体验当地美食" class="listAbroadImg" target="_blank"><img src="images/index/zizhu01.jpg" /> </a> 
	<a title="迪拜+阿布扎比+沙迦5日团队游(4钻)·特价旅游 EK" href="spotline!toSpotLineInfo.jspx?SpotLineID=26" nalt="迪拜+阿布扎比+沙迦5日团队游(4钻)·特价旅游 EK" class="listAbroadImg" target="_blank"><img src="images/index/zizhu02.jpg" /> </a> 
	<a title="台湾4-15日自由行·亿元返券 直飞台北" href="spotline!toSpotLineInfo.jspx?SpotLineID=24" nalt="台湾4-15日自由行·亿元返券 直飞台北" class="listAbroadImg" target="_blank"><img src="images/index/zizhu03.jpg" /></a> 
	<a title="香港+澳门5日自由行·先住澳门后住香港澳进港出" href="spotline!toSpotLineInfo.jspx?SpotLineID=25" nalt="香港+澳门5日自由行·先住澳门后住香港澳进港出" class="listAbroadImg" target="_blank"><img src="images/index/zizhu04.jpg" /></a>
	</li>
		
	
</ul>
</div>
</div>
</div>
</div>
</div>
<div class="rightMain"><!--易恒天下热点 -->
<div class="issueBox">
<div id="portal-block-146032015829" class="udiyblock" type="NewsModel">
<div class="cBoxTitle c_cBoxTitle2">
<h3 class="boxH3">易恒天下热点</h3>
<a class="btnMore" title="更多" target="_blank" href="#">更多&gt;&gt;</a></div>
<div class="issueCon">
<dl class="issueDl">
	<div id="portal-block-551490588959" class="udiyblock" type="NewsModel">
	<dl class="issueDl">
	
	 		<ww:iterator value="listCJWT">
			<dd class="issueDd"><span class="issueIcon"></span> <a
			style="color: #ff6600" href="index!tohelp.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>" title="<ww:property value="name"/>" target="_blank">
			<ww:if test="name.length()>23">
			<ww:property value="SubString(name,20)"/>...
			</ww:if><ww:else><ww:property value="name"/></ww:else></a>
			</dd>
			</ww:iterator>
			<!--
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="开心旅游经验---“精打细算”" target="_blank">开心旅游经验---“精打细算”</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="旅游防“宰”术" target="_blank">旅游防“宰”术</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="旅途购物学问多" target="_blank">旅途购物学问多</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="外出旅游牢记八大要素" target="_blank">外出旅游牢记八大要素</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="旅游中常被忽视的十大忌问题" target="_blank">旅游中常被忽视的十大忌问题</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="乘坐红眼航班的注意事项" target="_blank">乘坐红眼航班的注意事项</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="夏日旅游的保健之道" target="_blank">夏日旅游的保健之道</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="旅游中的美容知识" target="_blank">旅游中的美容知识</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="如何选择旅游方式" target="_blank">如何选择旅游方式</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="旅游投诉小常识" target="_blank">旅游投诉小常识</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="离家旅游前的准备工作" target="_blank">离家旅游前的准备工作</a></dd>
		<dd class="issueDd"><span class="issueIcon"></span> <a href="#"
			title="旅游中的摄影装备指南" target="_blank">旅游中的摄影装备指南</a></dd>
	-->
	</dl>
	</div>
</dl>
</div>

<div class="reportCon">
<img src="images/index/redian1.jpg" height="100px;" width="240px;"> 
<img src="images/index/redian2.jpg" height="100px;" width="240px;"> 
<!--
<img src="images/youshi.jpg"
	height="210px;" width="240px;"> 
	-->
	<!--<div id="portal-block-342250376768" class="udiyblock" type="AdModel">
<a href="http://www.17u.cn/zhuanti/xianjinquan/" target="_blank"
	title="" class="reportConA"><img
	src="http://img1.40017.cn/cn/comm/images/product/20130522/tcb4.jpg"
	alt="" class="reportConImg"></a> <a
	href="http://www.17u.cn/news/detail-34180.html" target="_blank"
	title="" class="reportConA rightReportA"><img
	src="http://img1.40017.cn/cn/comm/images/product/20131218/weixin.jpg"
	alt="" class="reportConImg"></a> <a
	href="http://www.17u.cn/zhuanti/lianmingka/" target="_blank" title=""
	class="reportConA"><img
	src="http://img1.40017.cn/cn/comm/images/product/20130522/tcb3.jpg"
	alt="" class="reportConImg"></a> <a href="http://www.17u.cn/zhuanti/"
	target="_blank" title="" class="reportConA rightReportA"><img
	src="http://img1.40017.cn/cn/comm/images/product/20130522/tcb1.jpg"
	alt="" class="reportConImg"></a></div>
--></div>

</div>

</div>
<!--end易恒天下热点 --> <!--今日团购 -->
<div class="tuangouBox">
<div class="cBoxTitle tuangouTitle clearfix c_cBoxTitle2">
<h3 class="boxH3">特价专区</h3>
<a class="btnMore" title="更多今日特价" href="#">更多&gt;&gt;</a>
</div>
<div class="tuangouCon">
<ul class="tuangouConUl">
	<li class="senicConLi">
	<div id="portal-block-72129175852" class="udiyblock"
		type="CommonSource">
	<div class="tuanConTitle clearfix"><span
		class="tuanConImg hotelConImg"></span> <a
		href="#" class="tuanConWord" title="特价景点">特价景点</a>
	<!--左右切换效果
	<div class="btnDiv"><a href="javascript:void(0);"
		class="btn01 tuanConGrayPrevBtn" id="btnSenicPrev"></a> <a
		href="javascript:void(0);" class="btn01 tuanConGrayLastBtn"
		id="btnSenicLast"></a></div>
	-->
	</div>
	<div class="tuanConSliderDiv"
		style="position: relative; overflow: hidden;" id="senicConSliderDiv">
	<div class="tuanConDiv clearfix"
		style="position: relative; overflow: hidden; width: 956px;"
		id="senicConDiv">
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg">
		<a href="#" href="#" nalt="石景山游乐园  石景山游乐园冬季特惠  石景山游乐园团购" title="石景山游乐园  石景山游乐园冬季特惠  石景山游乐园团购" class="hotelA">
		 <img src="images/index/201311091348452187550.jpg" alt="石景山游乐园  石景山游乐园冬季特惠  石景山游乐园团购" /> </a></dd>
		<dd class="tuanConShowName"><a href="#" title="石景山游乐园  石景山游乐园冬季特惠  石景山游乐园团购">石景山游乐园 石景山游乐园</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">7</span>折</span> 原价：<span class="discountPrice">¥150</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">111</span>
		</dd>
	</dl>
	</div>
	<!--
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/scenery/detail-77209.html"
			href="http://tuan.17u.cn/scenery/detail-77209.html"
			nsrc="http://img.17u.com/jqadminpic/uploadpic/old/2013/8/15/2013081517053541049.jpg"
			nalt="八达岭野生动物园亲子（1+1）团购" title="八达岭野生动物园亲子（1+1）团购" class="hotelA">
		</a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/scenery/detail-77209.html"
			title="八达岭野生动物园亲子（1+1）团购">八达岭野生动物园亲子（1+1</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">7</span>折</span> 原价：<span class="discountPrice">¥135</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">100</span>
		</dd>
	</dl>
	</div>
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/scenery/detail-55881.html"
			href="http://tuan.17u.cn/scenery/detail-55881.html"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_17u/740_350/2013/03/18/2/2013031815125733509.jpg"
			nalt="七彩蝶园（北京蝴蝶生态观赏园）" title="七彩蝶园（北京蝴蝶生态观赏园）" class="hotelA"> </a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/scenery/detail-55881.html"
			title="七彩蝶园（北京蝴蝶生态观赏园）">七彩蝶园（北京蝴蝶生态观赏园</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">7</span>折</span> 原价：<span class="discountPrice">¥148</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">110</span>
		</dd>
	</dl>
	</div>
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/scenery/detail-108923.html"
			href="http://tuan.17u.cn/scenery/detail-108923.html"
			nsrc="http://upload.17u.com/uploadfile/2013/10/25/2/201310251829353577118.jpg"
			nalt="运河苑温泉度假村御水世界平日票团购" title="运河苑温泉度假村御水世界平日票团购" class="hotelA">
		</a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/scenery/detail-108923.html"
			title="运河苑温泉度假村御水世界平日票团购">运河苑温泉度假村御水世界平日</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">7</span>折</span> 原价：<span class="discountPrice">¥198</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">135</span>
		</dd>
	</dl>
	</div>
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/scenery/detail-69750.html"
			href="http://tuan.17u.cn/scenery/detail-69750.html"
			nsrc="http://img.17u.com/jqadminpic/uploadpic/old/2013/8/15/2013081517021300789.jpg"
			nalt="富国海底世界" title="富国海底世界" class="hotelA"> </a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/scenery/detail-69750.html" title="富国海底世界">富国海底世界</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">6</span>折</span> 原价：<span class="discountPrice">¥110</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">60</span>
		</dd>
	</dl>
	</div>
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/scenery/detail-157553.html"
			href="http://tuan.17u.cn/scenery/detail-157553.html"
			nsrc="http://upload.17u.com/uploadfile/scenerypic_17u/740_350/2011/11/14/2/2011111417582633480.jpg"
			nalt="怀北国际滑雪场 怀北国际滑雪场团购   滑雪场团购" title="怀北国际滑雪场 怀北国际滑雪场团购   滑雪场团购"
			class="hotelA"> </a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/scenery/detail-157553.html"
			title="怀北国际滑雪场 怀北国际滑雪场团购   滑雪场团购">怀北国际滑雪场 怀北国际滑雪</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">5</span>折</span> 原价：<span class="discountPrice">¥240</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">130</span>
		</dd>
	</dl>
	</div>
	-->
	</div>
	</div>
	</div>
	</li>
	<li class="tuangouConLi hotelTuangou">
	<div id="portal-block-866710187176" class="udiyblock"
		type="CommonSource">
	<div class="tuanConTitle clearfix"><span
		class="tuanConImg scenicConImg"></span> <a
		href="#" class="tuanConWord" title="特价酒店">特价酒店</a>
	<!-- 左右切换效果
	<div class="btnDiv"><a href="javascript:void(0);"
		class="btn01 tuanConGrayPrevBtn" id="btnHotelPrev"></a> <a
		href="javascript:void(0);" class="btn01 tuanConGrayLastBtn"
		id="btnHotelLast"></a></div>
	-->
	</div>
	<div class="tuanConSliderDiv"
		style="position: relative; overflow: hidden;" id="hotelConSliderDiv">
	<div class="tuanConDiv clearfix"
		style="position: relative; overflow: hidden; width: 956px;"
		id="hotelConDiv">
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="hotel!toHotelInfo.jspx?HotelId=266570"
			nalt="北京赵家楼饭店" title="北京赵家楼饭店" class="hotelA"><img
			src="images/index/7a5f8e429c9a40c1972ab6b937e538e3.jpg"
			alt="北京赵家楼饭店" /></a></dd>
		<dd class="tuanConShowName"><a
			href="hotel!toHotelInfo.jspx?HotelId=266570" title="北京赵家楼饭店">北京赵家楼饭店</a>
		</dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">5</span>折</span> 原价：<span class="discountPrice">¥568</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">298</span>
		</dd>
	</dl>
	</div>
	<!--
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-138768.html"
			href="http://tuan.17u.cn/hotel/detail-138768.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/10/11/8cc3dde7e5a6496aac99666a3394ab76.jpg"
			nalt="北京檀驿站精品酒店" title="北京檀驿站精品酒店" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-138768.html" title="北京檀驿站精品酒店">北京檀驿站精品酒店</a>
		</dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">3</span>折</span> 原价：<span class="discountPrice">¥1228</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">352</span>
		</dd>
	</dl>
	</div>
	
	
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-138766.html"
			href="http://tuan.17u.cn/hotel/detail-138766.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/10/11/2032021fb63e4675b3f74bb99481bbf7.jpg"
			nalt="北京檀驿站精品酒店" title="北京檀驿站精品酒店" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-138766.html" title="北京檀驿站精品酒店">北京檀驿站精品酒店</a>
		</dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">3</span>折</span> 原价：<span class="discountPrice">¥1028</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">334</span>
		</dd>
	</dl>
	</div>
	
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-126515.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/6/4/f868944382f740a5899415517608153b.jpg"
			nalt="北京速8酒店（聚丰店）" title="北京速8酒店（聚丰店）" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-126515.html"
			title="北京速8酒店（聚丰店）">北京速8酒店（聚丰店）</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">6</span>折</span> 原价：<span class="discountPrice">¥298</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">168</span>
		</dd>
	</dl>
	</div>

	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-127047.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/7/22/b2bea2789fcf4e5b90a6c5886d5865fe.jpg"
			nalt="北京和家宾馆安外店钟点房" title="北京和家宾馆安外店钟点房" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-127047.html"
			title="北京和家宾馆安外店钟点房">北京和家宾馆安外店钟点房</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">7</span>折</span> 原价：<span class="discountPrice">¥100</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">68</span>
		</dd>
	</dl>
	</div>
	
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-126976.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/7/25/e077d531ba054e68aec46945d5d5d4ae.jpg"
			nalt="北京玉蜓桥酒店" title="北京玉蜓桥酒店" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-126976.html" title="北京玉蜓桥酒店">北京玉蜓桥酒店</a>
		</dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">8</span>折</span> 原价：<span class="discountPrice">¥248</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">188</span>
		</dd>
	</dl>
	</div>
	-->
	
	
	
	
	
	</div>
	
	
	
	
	
	</div>
	</div>
	</li>
<li class="tuangouConLi hotelTuangou">
	<div id="portal-block-866710187188" class="udiyblock"
		type="CommonSource">
	<div class="tuanConTitle clearfix"><span
		class="tuanConImg scenicConImg"></span> <a
		href="#" class="tuanConWord" title="特价线路">特价线路</a>
	<!-- 左右切换效果
	<div class="btnDiv"><a href="javascript:void(0);"
		class="btn01 tuanConGrayPrevBtn" id="btnHotelPrev"></a> <a
		href="javascript:void(0);" class="btn01 tuanConGrayLastBtn"
		id="btnHotelLast"></a></div>
	-->
	</div>
	<div class="tuanConSliderDiv"
		style="position: relative; overflow: hidden;" id="hotelConSliderDiv222">
	<div class="tuanConDiv clearfix"
		style="position: relative; overflow: hidden; width: 956px;"
		id="hotelConDiv">
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="#"
			href="#"
			nalt="昆明大理丽江双飞6日游" title="昆明大理丽江双飞6日游" class="hotelA"><img
			src="images/index/heilongtan.jpg"
			alt="昆明大理丽江双飞6日游" /></a></dd>
		<dd class="tuanConShowName"><a
			href="#" title="昆明大理丽江双飞6日游">昆明大理丽江双飞6日游</a>
		</dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">5</span>折</span> 原价：<span class="discountPrice">¥2340</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">1200</span>
		</dd>
	</dl>
	</div>
	<!--
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-138768.html"
			href="http://tuan.17u.cn/hotel/detail-138768.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/10/11/8cc3dde7e5a6496aac99666a3394ab76.jpg"
			nalt="北京檀驿站精品酒店" title="北京檀驿站精品酒店" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-138768.html" title="北京檀驿站精品酒店">北京檀驿站精品酒店</a>
		</dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">3</span>折</span> 原价：<span class="discountPrice">¥1228</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">352</span>
		</dd>
	</dl>
	</div>
	
	
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-138766.html"
			href="http://tuan.17u.cn/hotel/detail-138766.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/10/11/2032021fb63e4675b3f74bb99481bbf7.jpg"
			nalt="北京檀驿站精品酒店" title="北京檀驿站精品酒店" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-138766.html" title="北京檀驿站精品酒店">北京檀驿站精品酒店</a>
		</dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">3</span>折</span> 原价：<span class="discountPrice">¥1028</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">334</span>
		</dd>
	</dl>
	</div>
	
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-126515.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/6/4/f868944382f740a5899415517608153b.jpg"
			nalt="北京速8酒店（聚丰店）" title="北京速8酒店（聚丰店）" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-126515.html"
			title="北京速8酒店（聚丰店）">北京速8酒店（聚丰店）</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">6</span>折</span> 原价：<span class="discountPrice">¥298</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">168</span>
		</dd>
	</dl>
	</div>

	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-127047.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/7/22/b2bea2789fcf4e5b90a6c5886d5865fe.jpg"
			nalt="北京和家宾馆安外店钟点房" title="北京和家宾馆安外店钟点房" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-127047.html"
			title="北京和家宾馆安外店钟点房">北京和家宾馆安外店钟点房</a></dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">7</span>折</span> 原价：<span class="discountPrice">¥100</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">68</span>
		</dd>
	</dl>
	</div>
	
	<div class="tuanConCon">
	<dl class="tuanConShowInf">
		<dd class="tuanConShowImg"><a
			href="http://tuan.17u.cn/hotel/detail-126976.html"
			nsrc="http://upload.17u.cn/hotel/origin/2013/7/25/e077d531ba054e68aec46945d5d5d4ae.jpg"
			nalt="北京玉蜓桥酒店" title="北京玉蜓桥酒店" class="hotelA"></a></dd>
		<dd class="tuanConShowName"><a
			href="http://tuan.17u.cn/hotel/detail-126976.html" title="北京玉蜓桥酒店">北京玉蜓桥酒店</a>
		</dd>
		<dd class="tuanConShowPrice"><span class="discount"><span
			class="disCoMum">8</span>折</span> 原价：<span class="discountPrice">¥248</span>
		<span class="afterDiscount">¥</span><span class="afterPrice">188</span>
		</dd>
	</dl>
	</div>
	-->
	
	
	
	
	
	</div>
	
	
	
	
	
	</div>
	</div>
	</li>
</ul>
</div>
</div>
<!--end今日团购 --> <!--旅游工具箱 -->
<div class="tripToolBox">
<div class="cBoxTitle tripToolTitle">
<h3 class="boxH3">旅游工具箱</h3>
<div class="btnDiv"><a href="javascript:void(0);"
	class="btn01 tuanConGrayPrevBtn" id="btnPrev"></a> <a
	href="javascript:void(0);" class="btn01 tuanConGrayLastBtn"
	id="btnLast"></a></div>
</div>
<div style="position: relative; overflow: hidden;" class="tripToolDiv"
	id="tripToolId">
<ul class="tripToolCon clearfix"
	style="position: relative; width: 1000px;" id="tripToolConId">
	<li class="toolNavMainLi">
	<ul>
		<li class="toolNavWrap flightTicIcon"><a
			href="http://kongtie.net/Ebooking/ticticket!toTicket.jspx"
			target="_blank" class="toolA"> <span class="toolSp flightSp"></span>
		<span class="icon">机票预约</span> </a></li>
		<li class="toolNavWrap mapIcon"><a
			href="http://kongtie.net/Ebooking/index!tolianxi.jspx"
			target="_blank" class="toolA"> <span class="toolSp mapSp"></span>
		<span class="icon">电子地图</span> </a></li>
		<li class="toolNavWrap weatherIcon"><a
			href="http://www.weather.com.cn" target="_blank" class="toolA"> <span
			class="toolSp weatherSp"></span> <span class="icon">天气预报</span> </a></li>
		<li class="toolNavWrap carIcon"><a
			href="http://www.trip8080.com/" target="_blank" class="toolA"> <span
			class="toolSp carSp"></span> <span class="icon">公交查询</span> </a></li>
	</ul>
	</li>
	<li class="toolNavMainLi">
	<ul>
		<li class="toolNavWrap trainIcon"><a
			href="http://www.17u.cn/train/" target="_blank" class="toolA"> <span
			class="toolSp trainSp"></span> <span class="icon">火车时刻</span> </a></li>
		<li class="toolNavWrap interIcon"><a
			href="http://www.17u.cn/lvyouchangshi.html" target="_blank"
			class="toolA"> <span class="toolSp interSp"></span> <span
			class="icon">旅游常识</span> </a></li>
		<li class="toolNavWrap tripIcon"><a
			href="http://www.17u.cn/gotocom.aspx?pageurl=http%3a%2f%2fwww.17u.com%2fblog%2f/"
			target="_blank" class="toolA"> <span class="toolSp tripSp"></span>
		<span class="icon">旅游攻略</span> </a></li>
		<li class="toolNavWrap scenicIcon"><a
			href="http://www.baike.com/" target="_blank" class="toolA"> <span
			class="toolSp senicSp"></span> <span class="icon">百科查询</span> </a></li>
	</ul>
	</li>
</ul>
</div>
</div>
<div class="subsInfBox"><span class="subsImg"></span> <a
	class="subsWord" id="subsWord" href="javascript:void(0);">免费订阅促销信息</a>
</div>
<div class="" style="height: 185px">
<ul>
<li>
<a href="http://net.china.com.cn/index.htm" target="_blank">
<img src="images/index/rz/rz1.jpg" /></a>
<a href="http://www.cyberpolice.cn" target="_blank">
<img src="images/index/rz/rz2.jpg" /></a>
</li>

<li>
<a href="http://Cs.travelsky.com" target="_blank">
<img src="images/index/rz/rz3.jpg" />
</a>
<a href="http://www.hd315.gov.cn/ " target="_blank">
<img src="images/index/rz/rz4.jpg" />
</a>
</li>
<li>
<a href="http://www.miibeian.gov.cn" target="_blank">
<img src="images/index/rz/rz5.jpg" />
</a>
<a href="https://www.alipay.com/ " target="_blank">
<img src="images/index/rz/rz6.jpg" />
</a>
</li>
</ul>
<!--<ul>

<li>
<img src="images/index/rz/rz3.jpg" />
<img src="images/index/rz/rz4.jpg" />
<img src="images/index/rz/rz5.jpg" />
<img src="images/index/rz/rz6.jpg" /></li>
</ul>


--></div>
<!--end旅游工具箱 --></div>
</div>
</div>
<div class="tcQualityInf">
<div align="center"><img src="images/index/dibu.jpg" /></div>
</div>
<!-- end 主体内容 -->
<div class="clear_float"></div>
<div id="portal-block-992023332032" class="udiyblock" type="AdModel">
<input id="showHotCitysValue" type="hidden"
	value="[{'title':'热门城市','content':['北京','天津','石家庄','保定','秦皇岛','邢台','承德','邯郸','晋中','晋城','运城','长治']},{'title':'热门景点','content':['北京欢乐谷门票','北京蓝天城','十三陵','八达岭野生动物园','七彩蝶园','太平洋海底世界','富国海底世界','蟹岛嘉年华游乐园','中央电视塔','摩锐水世界','北京野生动物园','运河苑温泉度假村','南宫温泉','世界花卉大观园','水立方嬉水乐园']}]" /></div>
<div id="portal-block-458662335991" class="udiyblock"
	type="CommonSource">
<div id="cjselect" style="display: none;">
北京,上海,苏州,杭州,南京,常州,温州,宁波,无锡,扬州,泰州,南通,盐城,镇江,嘉兴,绍兴,金华,舟山,湖州,台州</div>
</div>
<div id="portal-block-42971991029" class="udiyblock" type="FootSource">
<div style="display: block;"><jsp:include page="footer.jsp"></jsp:include></div></div>

<script src="script/searchNew.0.1.0.js"></script> <script
	src="script/index.0.1.4.js?v=2013102419"></script>


<!--  -->

	
</body>
</html>
<script type="text/javascript">
//酒店用
function selecthotel(index,cityid){
for(i=0;i<=4;i++){
document.getElementById("index_hotel_"+i).className="city cityMiddle"; 
}
document.getElementById("index_hotel_"+index).className="city cityMiddle  CityA senicCityA2"; 


  jQuery.post("index!GetIndexHotelByIndex_tc.jspx",{strHotelIndex:index,strCityID:cityid,para:Math.floor(Math.random()*100)},
  function(data){
  $("#index_hotel_div").html(data);
  }); 
}
selecthotel(0,15495);
//门票用
function  selectspotticket(index,cityid){

for(i=0;i<=4;i++){
document.getElementById("index_spotticket_"+i).className="city cityMiddle"; 
}
document.getElementById("index_spotticket_"+index).className="city cityMiddle  CityA senicCityA2"; 


   jQuery.post("index!GetSpotTicketByIndex_tc.jspx",{strHotelIndex:index,strCityID:cityid,para:Math.floor(Math.random()*100)},
   function(data){
  
 $("#index_divSpotticketHtml").html(data);  
  });     
}
selectspotticket(3,383);

//线路用
function  selectspotline(index,cityid){

for(i=1;i<=4;i++){
document.getElementById("index_spotline_"+i).className="city cityMiddle"; 
}
document.getElementById("index_spotline_"+index).className="city cityMiddle  CityA senicCityA2"; 


   jQuery.post("index!GetSpotLineByIndex_tc.jspx",{strHotelIndex:index,strCityID:cityid,para:Math.floor(Math.random()*100)},
   function(data){
  
 $("#index_spotline").html(data);  
  });     
}
selectspotline(1,52);


function subspot(){

var SeachName_spot=$("#SeachName_spot").val();
$("#SeachName_line").val(SeachName_spot);
document.form4.action="spotticket!SeachSpot.jspx";
document.form4.submit();
}

</script>
<!--幻灯片的js-->
<script type="text/javascript">
    (function () {
        //先设置两个简洁函数获取ID，设置透明度
        var $ = function () {
            var elements = new Array();
            for (var i = 0; i < arguments.length; i++) {
                var element = arguments[i];
                if (typeof element == 'string')
                    element = document.getElementById(element);
                if (!element) continue;
                if (arguments.length == 1) return element;
                elements.push(element);
            }
            return elements;
        };
        var setOpacity = function (node, level) {
            node = $(node);
            if (document.all) {
                node.style.filter = 'alpha(opacity=' + level + ')';
            } else {
                node.style.opacity = level / 100;
            }
        };
        var getTag = function (child, parent) {
            return parent.getElementsByTagName(child);
        };
        var bindEvent = function (element, type, func) {
            if (element.addEventListener) {
                element.addEventListener(type, func, false); //false 表示冒泡
            } else if (element.attachEvent) {
                element.attachEvent('on' + type, func);
            } else {
                element['on' + type] = func;
            }
        };
        function Slider(options) {
            var id = options.id;
            var warper = this.warper = $(id);//获取包裹图片DOM(第一个UL的ID)
            var warpLis = this.warpLis = getTag("li", warper);//获取包裹下的LI子元素
            this.no = warpLis.length;//获取包裹LI元素的个数
            this.step = options.step || 2;
            this.autoTime = options.autoTime || 1000;   //自动播放间隔时间
            this.btnId = options.btnId || "focus_btn"; //图片上面的数字按钮的ID
            this.index = 1; //  开始变幻时的下一个INDEX
            this.preIndex = 0;
            this.init();
        }
        Slider.prototype = {
            init:function () {
                this.makeBtn(this.no, this.btnId);
                this.autoPlay();
            },
            makeBtn:function (no, c) {//生成按钮 no表示个数 C表示UL的ID
                var btnUl = this.btnUl = document.createElement("ul");
                btnUl.id = c;
                for (var i = 0; i < no; i++) {
                    var li = document.createElement('li');
                    if (i == 0) li.className = 'on';
                    var text = document.createTextNode(i + 1);
                    //li.appendChild(text);
                    setOpacity(li, 80);
                    // 绑定鼠标事件，传递当前的INDEX和preIndex
                    bindEvent(li, 'mouseover', function (obj, t) {
                        return function () {
                            obj.mouseOn.call(obj, t);
                        }
                    }(this, i));
                    btnUl.appendChild(li);
                }
                this.warper.parentNode.appendChild(btnUl);//添加到父div下
            },
            autoPlay:function(){
                var that = this;
                // 执行播放
                clearTimeout(this.T1);
                this.T1 = setTimeout(function(){that.fadeIn(that.index)},that.autoTime);
            },
            fadeIn:function(index){
                var thisObj = this.warpLis[index];
                var thisOpacity = 0; //当前透明度从0渐入
                var that = this;
                // 底部按钮的同步,与当前的图层Z-index始终在上面
                var btnLi = getTag('li', this.btnUl);
                for (var i = 0, n = btnLi.length; i < n; i++) {
                    btnLi[i].className = '';
                    // 移除所有的Zindex
                    this.warpLis[i].style.zIndex = '';
                }
                //在改变INDEX之前先设置透明度为0
                setOpacity(this.warpLis[index],0);
                // 设置前一个图片的Zindex
                this.warpLis[that.preIndex].style.zIndex = 1;
                // 设置当前图片的Zindex
                this.warpLis[index].style.zIndex = 2;
                btnLi[index].className = 'on';
                //淡入动画
                if(that.T2)clearInterval(that.T2);
                this.T2 = setInterval(function(){
                    setOpacity(thisObj,thisOpacity++);  // 设置透明度渐入
                    if(thisOpacity == 100){
                        thisOpacity = 0;
                        clearInterval(that.T2);
                        that.T2 = null;
                        that.preIndex = that.index ++;
                        if(that.index == that.no)that.index = 0;
                        that.autoPlay();
                    }
                },10);
            },
            mouseOn:function(index){
                this.index = index;
                this.fadeIn(index);
            }
        };
        
        var slider1 = new Slider({
            id:'focus_pic', /**包裹图片的UL的ID**/
            btnId:"focus_btn", //幻灯片按钮的ID,可以用来控制CSS显示
            //step:5, //透明度变化步长，默认为2
            autoTime:2000//自动播放间隔时间
        });
    })();
    
</script>