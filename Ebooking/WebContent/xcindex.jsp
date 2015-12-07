<%@ page contentType="text/html; charset=gb2312"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%!
int index =0;
%>
<%!int subindex=0; %>
<%
try{
	 index = Integer.parseInt(request.getParameter("index"));
	 subindex =  Integer.parseInt(request.getParameter("subindex"));
	
}catch(Exception e){
}	
%>



<%!public String setIndex(int aindex){
	String ret = "";
	if(index == aindex){
		ret =" class=\"cui_nav_current\" ";
	}
	return ret;
}
%>
<%!public String setSubIndex(int aindex, int asubindex) {
		String ret = "";
		if (index == aindex && subindex == asubindex) {
			ret = " style=\"color: blue;\" ";
		}

		return ret;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">   
<!-- <script src="js/jquery/jquery-1.4.2.min.js" type=text/javascript></script>  -->
<script src="js/jquery-1.3.2.min.js" type=text/javascript></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<meta property="qc:admins" content="14674104326342106375" />
<title>旅行网官网:酒店预订,机票预订查询,旅游度假,商旅管理</title>

<!-- InstanceBegin name="position" -->
<link href="css/private_index_v3_20130322.css?ws_www20130827.css"
	rel="stylesheet" type="text/css" media="all" />
	

<!--幻灯片css-->
<link rel="stylesheet" type="text/css" href="css/slide.css">
<style id="headStyleId" type="text/css" media="all">
.cui_nav li[id]:hover .cui_subnav_wrap {
	display: block;
}

.cui_nav li[id]:hover .cui_subnav_wrap {
	z-index: 10;
}
</style>
<!--新增css-->
<style type="text/css">
	#searchBox{
		margin-top: 5px;
		margin-left: 122px;
		height: 270px;
	}
	#Div_Tab_1{
		height: 244px;
	}
	#searchBoxUl{
		height: 269px;
	}
	#ad_onsaleId a{
		height: 68px;
	}
	#ad_onsaleId a img{
		height: 68px;
	}
	.toolbox{
		width: 300px;
	}
	.journal-item{
		clear:both;
		padding-bottom: 5px;
		height: 70px
;	}
	.journal-item .item-photo{
		margin: 0px;
		padding: 0px;
		width: 100px;
		height: 68px;
	}
	.journal-item .item-link{
		float: left;
		width: 188px;
		padding-left: 10px;
	}
	.journal-item .item-info{
		float: left;
		width: 188px;
		padding-left: 10px;
		color: #666666;
	}
</style>

<!--[if lt IE 9]>
        <script type="text/javascript">
			    if(screen.width <= 1200) {
					    var link = document.createElement('link');
					    link.rel = "stylesheet";
					    link.type="text/css";
					    link.href="css/private_index_1000.css";
					    document.getElementsByTagName('head')[0].appendChild(link);
                 }
        </script>
        <![endif]-->
</head>
<body>



<div class="pop_attention" id="qqcaibei" style="display: none"></div>
<div class="pop_attention" id="popup" style="display: none"></div>
<div class="pop_attention" id="bindemail" style="display: none"></div>
<!-- header start-->
<!--head-->

<!--nav-->
<!-- 头部开始 -->
<div class="cui_hd_cont">
    	<div class="cui_hd" id="cui_hd">
		<!--logo-->
		<h1 class="">
		
		
		</h1>
		<!--help center & weibo & multi lang-->
		<div class="cui_toolkit">
		
			
			
		</div>
		<!--telphone & mobile-->
		<div class="cui_tel" onmouseover="this.className='cui_tel cui_tel_hover'" onmouseout="this.className='cui_tel'" onclick="this.className='cui_tel cui_tel_hover'">
			<b></b>
			<span class="cui_tel_in" title="免境内长话费">客服：<i>${tel}</i></span>
			<div class="cui_tel_more">
				<span class="cui_tel_in" title="座机拨打">客服：<i>${tel}</i></span>
				<span class="cui_tel_in">客服：<i>${tel}</i></span>
				<span class="cui_tel_in">客服：<i>${tel}</i></span>
			</div>
		</div>
		<!--wireless-->
		<div class="cui_wireless">|<a href="#" rel="nofollow">捷翔无线</a>
		</div>
	</div>
  </div>
  
  
	    <!--nav-->
        <!-- 头部开始 -->       
	    <div id="cui_nav" class="cui_nav_single">
		<div class="base_nav">
			<ul class="cui_nav">
				<li id="cui_nav_home" <%= setIndex(0)%> >
					<a href="" class="cui_nav_non"  title="首页"><span>首页</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_flight" <%= setIndex(1)%>>
					<a href="ticticket!toTicket.jspx" class="cui_nav_flight cui_nav_has" title="机票"><span>机票</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="ticticket!toTicket.jspx" <%= setSubIndex(1,1)%>  title="国内机票">国内机票</a>|<a href="international!toInterNational.jspx" <%= setSubIndex(1,2)%> title="国际机票">国际机票</a></div></div>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_hotel" <%= setIndex(2)%>>
					<a href="hotel!toindex.jspx" class="cui_nav_hotel cui_nav_has" title="酒店"><span>酒店</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="hotel!toindex.jspx" <%= setSubIndex(2,1)%> title="国内酒店">国内酒店</a></div></div>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_vac" <%= setIndex(3)%>>
					<a href="spotticket.jspx" class="cui_nav_vac cui_nav_has" title="旅游"><span>旅游</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="spotline.jspx" title="旅游首页">旅游首页</a>|<a href="spotline.jspx" title="国内线路">国内线路</a>|<a href="spotticket.jspx" title="门票">门票</a>|<a href="buying.jspx" title="团购">团购</a>|<a href="#" title="签证">签证</a></div></div>
				</li>
				
				<li class="sep"></li>
				<li id="cui_nav_trains">
					<a href="#" class="cui_nav_non" title="火车票"><span>火车票</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_destination" <%= setIndex(5)%>>
					<a href="index!toinformation.jspx" class="cui_nav_non" title="资讯中心"><span>资讯中心</span></a>
				</li>
				<li class="sep"></li>
				<li id="cui_nav_lpk" <%= setIndex(6)%>>
					<a href="index!tohelp.jspx" title="帮助中心" class="cui_nav_non"><span>帮助中心</span></a>
				</li>
				
				<li class="sep"></li>
				<li id="cui_nav_more">
					<a href="#" class="cui_nav_more cui_nav_has" title="更多" rel="nofollow"><span>更多</span><i class="cui_ico_triangle"></i></a>
					<div class="cui_subnav_wrap"><div class="cui_sub_nav"><a href="#" title="积分奖励" rel="nofollow">积分奖励</a>|<a href="#" title="特卖汇" rel="nofollow">特卖汇</a>|<a href="#" title="合作卡" rel="nofollow">合作卡</a>|<a href="#" title="订餐" rel="nofollow">订餐</a></div></div>
				</li>
				<ww:if test="#session.loginuser!=null">
				<li class="sep"></li>
				<li id="cui_nav_sl" <%= setIndex(-1)%>>
					<a href="login!toMyCenter.jspx" title="个人中心" class="cui_nav_non"><span>个人中心</span></a>
				</li>
				</ww:if>
				<li class="sep"></li>
				<li id="cui_nav_sl">
					<a  href="http://114.112.39.149:8088/Platform" title="代理登陆" class="cui_nav_non"><span>代理登录</span></a>
				</li>
                <li id="loginDivLi" class="cui_myctrip">
              
					<div class="cui_myctrip_lr">
					<ww:if test="#session.loginuser==null">
						<a id="loginBtn1" href="login!toMyCenter.jspx" class="cui_links_login" rel="nofollow">登录</a>|<a href="login!toRegsit.jspx" class="cui_links_reg" rel="nofollow">注册</a>
					</ww:if><ww:else>
						<a href="login!loginout.jspx" class="cui_links_login">退出</a>
					</ww:else>	
					</div>
					<!--登录后-->
				</li>
				
			</ul>
		</div>
	</div>
       
       
       
        <script type="text/javascript">
            ; (function () { var D = document, $ = function (id) { return D.getElementById(id) }, st = null, st2 = null, lazyTime = 0, lis = [$('cui_nav_hotel'), $('cui_nav_vac'), $('cui_nav_flight'), $('cui_nav_more')], E = { 'onmouseenter': function (o, f) { if (D.all) { o.onmouseenter = f } else { o.onmouseover = function (e) { e.relatedTarget == null ? f() : (!(this === e.relatedTarget || this.compareDocumentPosition(e.relatedTarget) == 20) && f()) } } }, 'onmouseout': function (o, f) { if (D.all) { o.onmouseleave = f } else { o.onmouseout = function (e) { e.relatedTarget == null ? f() : (!(this === e.relatedTarget || this.compareDocumentPosition(e.relatedTarget) == 20) && f()) } } }, 'addEvent': function (el, type, handler) { if (el.addEventListener) { el.addEventListener(type, handler, false) } else if (el.attachEvent) { el.attachEvent("on" + type, handler) } else { el["on" + type] = handler } } }, F = { 'setTime': function () { E.onmouseenter($('cui_nav'), function () { setTimeout(function () { lazyTime = 150 }, 30) }); E.onmouseout($('cui_nav'), function () { lazyTime = 0 }) }, 'initEvent': function () { for (var i = 0, len = lis.length; i < len; i++) { (function () { var j = i; E.onmouseenter(lis[j], function () { F.interFn(lis[j]) }); E.onmouseout(lis[j], function () { F.outerFn(lis[j]) }) })(i) } }, 'reset': function () { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].className.indexOf('cui_nav_current') > -1) { lis[i].className = 'cui_nav_current' } else { lis[i].className = '' } } }, 'padReset': function (j) { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].className.indexOf('cui_nav_current') > -1) { lis[i].className = 'cui_nav_current' } else { if (i !== j) { lis[i].className = '' } } } }, 'interFn': function (obj) { if (st2 != null) { clearTimeout(st2); st2 = null } st = setTimeout(function () { F.reset(); if (obj.className.indexOf('cui_nav_current') > -1) { } else { obj.className = 'cui_nav_o' } }, lazyTime) }, 'outerFn': function (obj) { if (st != null) { clearTimeout(st); st = null } st2 = setTimeout(function () { F.reset(); if (obj.className.indexOf('cui_nav_current') > -1) { obj.className = 'cui_nav_current' } else { obj.className = '' } }, 250) }, 'initMobile': function () { for (var i = 0, len = lis.length; i < len; i++) { (function () { var j = i; var oneLevel = lis[j].getElementsByTagName('A')[0]; oneLevel.href = '###'; oneLevel.onmousedown = function () { F.padReset(j); if (lis[j].className.indexOf('cui_nav_current') === -1) { if (lis[j].className.indexOf('cui_nav_o') > -1) { lis[j].className = ''; oneLevel.style.visibility = 'hidden'; setTimeout(function () { oneLevel.style.visibility = 'visible' }, 10) } else { lis[j].className = 'cui_nav_o' } } } })(i) } }, 'contains': function (target) { for (var i = 0, len = lis.length; i < len; i++) { if (lis[i].compareDocumentPosition(target) - 19 > 0) { return true } } return false } }; if ($('headStyleId')) { $('headStyleId').parentNode.removeChild($('headStyleId')) } if (/ip(hone|od)|ipad/i.test(navigator.userAgent)) { F.initMobile(); E.addEvent(D.body, 'click', function (e) { var target = e.target || e.srcElement; if (!F.contains(target)) { F.reset() } }) } else { F.setTime(); F.initEvent() } })();
        </script>
<!-- header end-->
<!-- 头部开结束 -->
<!--body start-->
<div class="bd_row"><!-- tab搜索 start -->
<div id="searchBox" class="searchbox">
<ul id="searchBoxUl" class="s_tab">
	<li styleTag="hotel" id="Tab_1" onclick="CheckTab('hotel');"  class="s_tab_current">酒店</li>
	<li styleTag="flight" id="Tab_2" onclick="CheckTab('flight');" class="s_tab_nocurrent">机票</li>
	<li styleTag="vacation" id="Tab_3" onclick="CheckTab('vacation');" class="s_tab_nocurrent">旅游</li>
	<li styleTag="train"  id="Tab_4" onclick="CheckTab('train');" class="s_tab_nocurrent">火车票</li>
	<li styleTag="ticket" id="Tab_5" onclick="CheckTab('ticket');" class="s_tab_nocurrent">门票</li>
	<li styleTag="mobilePhone" id="Tab_6" onclick="CheckTab('mobilePhone');" class="s_tab_nocurrent">手机版</li>
	
</ul>
<!-- 搜索框产品内容开始 --> 
<script type="text/javascript">
var  searchFile = { chinaHotel: "js/HD.js", 
inteHotel: "js/HI.js", 
chinaFlight: "js/ctrip/FD.js", 
inteFlight: "js/FI.js", 
vacation: "js/VD.js", 
ticket: "js/ctrip/MP.js", 
mobilePhone: "js/ctrip/MB.js", 
train: "js/ctrip/HC.js"};</script>
<!-- 酒店搜索开始 -->
<div styletag="hotel" id="Div_Tab_1" class="s_content">
<p class="s_subtab_a" id="hotelSwitch"><a href="javascript:void(0);"
	class="current" data-index="0">国内酒店</a> <a href="javascript:void(0);"
	data-index="1" class="">海外酒店</a></p>
<!-- 国内酒店 -->
<form id="chinaHotelForm" method="post" name="chinaHotelForm"
	action="hotel!Seach.jspx">
<div class="s_item_cont">
<div class="s_item w100">入住城市<input type="text" value="中文/拼音"
	class="w01" name="CityName" id="HD_CityName" autocomplete="off" /> <input
	type="hidden" id="HD_CityId" name="cityId" /> <input type="hidden"
	id="HD_CityPy" name="cityPY" /></div>
<div class="s_item_hotel" id="HD_SearchHistory" style="display: none">
<a class="s_history_btn" href="javascript:;"><i></i>搜索历史</a>
<div class="history_list"></div>
</div>
</div>
<div class="s_item_cont">
<div class="s_item">入住日期<input type="text" value="yyyy-mm-dd"
	name="checkIn" id="HD_CheckIn" autocomplete="off" /></div>
<div class="s_item2">退房日期<input type="text" value="yyyy-mm-dd"
	name="checkOut" id="HD_CheckOut" autocomplete="off" /></div>
</div>
<div class="s_item_cont">
<div class="s_item">酒店级别<select id="searchHotelLevelSelect"
	name="Star">
	<option selected="selected" value="0">不限</option>
	<option value="5">五星级/豪华</option>
	<option value="4">四星级/高档</option>
	<option value="3">三星级/舒适</option>
	<option value="2">二星级以下/经济</option>
</select></div>
</div>
<div class="s_item_cont">
<div id="hotelAddressDiv" class="s_item w100">关键词 <input
	type="text" _cqnotice="（选填）酒店名/地标/商圈" id="HD_TxtKeyword"
	name="keywordNew" class="w01 inputSel" autocomplete="on" maxlength="50"
	style=""> <input type="hidden" id="hotelAreaName"
	name="keyword" /> <input type="hidden" id="positionArea"
	name="positionArea" /> <input type="hidden" id="positionId"
	name="positionId" /> <input type="hidden" id="zoneId" name="zoneId" />
<input type="hidden" id="locationId" name="locationId" /> <input
	type="hidden" id="metroId" name="metroId" /> <input type="hidden"
	id="landMarkId" name="landMarkId" /> <input type="hidden" id="forTW"
	name="city" /> <input type="hidden" id="district_city"
	name="district_city" /></div>
</div>
<div class="s_button_area"><input type="button" value="地图搜索" style="display: none"
	class="cui_btn_map" title="地图搜索" id="HD_MapBtn" /> <input
	type="submit" value="搜索" class="s_btn" title="搜索" id="sub" /></div>
</form>
<!-- 海外酒店 -->
<form id="inteHotelForm" action="#" method="POST"
	name="inteHotelForm" 
	style="display: none;">

<div class="s_item_cont">
<div class="s_item w100">入住城市<input type="text" value="中文/英文/拼音"
	id="inteCityName" class="w01" name="cityname" autocomplete="off" /> <input
	type="hidden" id="inteCityId" name="city" /> <input type="hidden"
	id="inteCityPy" /></div>
</div>
<div class="s_item_cont">
<div class="s_item">入住日期<input type="text" value="yyyy-mm-dd"
	id="inteCheckIn" name="checkIn" autocomplete="off" /></div>
<div class="s_item2">退房日期<input type="text" value="yyyy-mm-dd"
	id="inteCheckOut" name="checkOut" autocomplete="off" /></div>
</div>
<div class="s_item_cont">
<div class="s_item">预订间数<select id="" name="rooms">
	<option value="0" selected="selected">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
</select></div>
</div>
<div class="s_item_cont">
<div class="s_item w100">酒店名称<input type="text" id="inteHotelName"
	class="w01" autocomplete="off" name="hotelName" _cqnotice="选填(中文/拼音)" /></div>
</div>
<div class="s_button_area"><input type="button" value="搜索"
	class="s_btn" title="搜索" id="HI_Btn1" onclick="alert('国际酒店升级维护中!!!');" /></div>

</form>
</div>
<!-- 酒店搜索结束 --> <!--机票搜索开始-->
<div styletag="flight" id="Div_Tab_2" class="s_content" style="display: none;"
	flight="true">
<p class="s_subtab_a" id="flightSwitch"><a
	href="javascript:void(0);" data-index="0" class="current"
	tag="fltDomestic" faction="#">国内机票</a>
<a href="javascript:void(0);" data-index="1" tag="fltInternational"
	faction="#"
	class="">国际机票</a></p>
<!---国内机票HTML结构开始--->
<form id="FD_ChinaFlightForm" name="FD_ChinaFlightForm" action="ticticket!toTicketList.jspx" method="POST">
<input
	type="hidden" name="FlightSearchType" value="S" /> <input
	type="hidden" name="IsSingleSearchPost" value="T" /> <input
	type="hidden" name="PassengerType" value="ADU" />
<p class="s_type" id="FD_flightSubSwitch">航程类型<label
	class="index_label"><input name="s_traveltype" tabindex="161"
	autocomplete="off" type="radio" MM="S" value="S" checked="checked" />单程</label>&nbsp;
<!--  
<label class="index_label"><input name="s_traveltype"
	tabindex="162" autocomplete="off" type="radio" MM="D" value="D" />往返</label>&nbsp;
<label class="index_label"><input name="s_traveltype"
	tabindex="163" autocomplete="off" type="radio" MM="M" value="M" />联程</label>
	-->
	
	</p>
<div class="s_item_cont s_item_cont_ex">
<div class="s_exchange"><a href="#">换</a></div>
<!-- 联程时不显示 -->
<div class="s_item">出发城市<input type="text" tabindex="164"
	name="DCityName1" id="FD_StartCity" data-target="DCity1" /><input
	type="hidden" id="FD_DCity1" name="s_depcitycode"></div>
<div class="s_item2"><span id="FD_StartDateSpan">出发日期</span><input
	type="text" id="FD_StartDate" name="s_startdate" tabindex="168"
	autocomplete="off" /></div>
<!-- 联程时将"出发日期"改为"第1程日期" --></div>
<div class="s_item_cont" id="FD_TranCityDiv" style="display: none;"><!-- 联程时将此处显示出来 -->
<div class="s_item">中转城市<input type="text" id="FD_TranCity"
	tabindex="166" data-target="TransitCity" /><input type="hidden"
	id="FD_TransitCity" name="TransitCity"></div>
<div class="s_item2">第2程日期<input type="text" id="FD_TranDate"
	tabindex="167" /></div>
</div>
<div class="s_item_cont"><!-- 联程时将返回日期隐藏起来 -->
<div class="s_item">到达城市<input type="text" tabindex="165"
	name="ACityName1" id="FD_DestCity" data-target="ACity1" /><input
	type="hidden" id="FD_ACity1" name="s_arrcitycode"></div>
<div class="s_item2 s_disable" style="display: none" id="FD_ReturnDateDiv">返回日期<input
	type="text" id="FD_ReturnDate" tabindex="169" name="s_backdate" /></div>
</div>
<div class="s_options" id="FD_AdvOptions">
<div class="s_item_cont">
<div class="s_item">出行人数<select tabindex="170"
	name="PassengerQuantity" id="FD_PassengerQuantitySelect">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">大于9</option>
</select></div>
<div class="s_item2">航空公司<select name="s_aircompanycode"
	id="FD_AirlineSelect" tabindex="171">
	<option value="">不限</option>
	<option value="CA">中国国航-CA</option>
	<option value="CZ">南方航空-CZ</option>
	<option value="MU">东方航空-MU</option>
	<option value="">---------------------------</option>
	<option value="BK">A-奥凯航空公司-BK</option>
	<option value="JD">B-北京首都航空有限公司-JD</option>
	<option value="EU">C-成都航空有限公司-EU</option>
	<option value="CN">D-大新华航空公司-CN</option>
	<option value="NS">H-河北航空公司-NS</option>
	<option value="HU">H-海南航空公司-HU</option>
	<option value="VD">H-河南航空有限公司-VD</option>
	<option value="G5">H-华夏航空公司-G5</option>
	<option value="HO">J-吉祥航空公司-HO</option>
	<option value="KY">K-昆明航空有限公司-KY</option>
	<option value="3U">S-四川航空公司-3U</option>
	<option value="SC">S-山东航空公司-SC</option>
	<option value="ZH">S-深圳航空公司-ZH</option>
	<option value="FM">S-上海航空公司-FM</option>
	<option value="GS">T-天津航空有限责任公司-GS</option>
	<option value="PN">X-西部航空公司-PN</option>
	<option value="JR">X-幸福航空有限责任公司-JR</option>
	<option value="MF">X-厦门航空有限公司-MF</option>
	<option value="8L">X-祥鹏航空公司-8L</option>
	<option value="KN">Z-中国联合航空公司-KN</option>
</select></div>
</div>
<div class="s_item_cont">
<div class="s_item">送票城市<input type="text" id="FD_SendTicketCity"
	tips="（选填）中文/拼音" name="SendTicketCity" tabindex="172" /></div>
<div class="s_item2">舱位等级<select name="ClassType" tabindex="173"
	id="FD_ClassLevel">
	<option value="">经济舱</option>
	<option value="CF">公务/头等舱</option>
</select></div>
</div>
</div>
<div class="s_item_cont"><a href="#" id="FD_AdvOptionsBtn"
	class="s_high_level"><i></i>高级搜索</a></div>
<div class="s_button_area">
<!--<input type="button" tabindex="175"
	value="搜索机+酒" class="cui_btn_pkg" title="搜索机+酒"
	id="FD_StartSearchFltHotel" />
	--><!-- 联程时隐藏该按钮 onclick="SeachTicket();" -->
	 <input type="button"
	tabindex="174" value="搜索" class="s_btn" onclick="SeachTicket();" title="搜索" id="" />
</div>
</form>
<form id="FD_ChinaFlightHotelForm" action="" target="_blank"
	method="POST"><input type="hidden" name="Adults" value="2" /> <input
	type="hidden" name="Children" value="0" /> <input type="hidden"
	name="Rooms" value="1" /> <input type="hidden" name="Night" value="" />
<input type="hidden" name="DDate" value="" /> <input type="hidden"
	name="RDate" value="" /> <input type="hidden" name="DCitySZM" value="" />
<input type="hidden" name="DCityName" value="" /> <input type="hidden"
	name="ACitySZM" value="" /> <input type="hidden" name="ACityName"
	value="" /></form>
<script type="text/json" id="FD_ChinaFlightConfig">
							{
								today: config.today,
								tomorrow: config.tomorrow,
								oneyear_today: config.oneyear_today,
								charset: cQuery.config('charset'),
								tip: {
									chinaFlight: [
										'出发日期格式不正确',
										'返回日期格式不正确',
										'请选择出发城市',
										'请选择到达城市',
										'出发城市不能和到达城市相同',
										'请选择您的出发日期',
										'请选择您的返回日期',
										'出发日期不能早于{$today}',
										'返回日期不能早于出发日期{$startDate}',
										'只能查询一年内航班',
										'请选择中转城市',
										'请选择您的第2程日期',
										'第2程日期格式不正确',
										'中转城市不能和出发城市相同',
										'到达城市不能和中转城市相同',
										'第2程出发日期不能早于第1程出发日期',
										'第1程日期格式不正确',
										'请选择您的第1程日期'
									]
								},
								notice: [
									'中文/拼音'
								],
								msg: {
									"suggestion": "（热门城市）可直接输入城市或拼音",
									'startDate': '出发日期',
									'firstDate': '第1程日期'
								}
							}
						</script> <!-- 国内机票HTML结束 --> 
<!-- 国际机票 -->
<form id="fl_box_search" action="" method="post" style="display: ">
<p class="s_type" id="fl_search_type">航程类型<label class="index_label"
	data-index="0"><input id="fl_flight_way_s" name="FlightWay"
	type="radio" value="S" />单程</label>&nbsp; <label class="index_label"
	data-index="1"><input id="fl_flight_way_d" name="FlightWay"
	type="radio" value="D" checked="checked" />往返</label>&nbsp; <label
	class="index_label" data-index="1"><input id="fl_flight_way_o"
	name="FlightWay" type="radio" value="M" />多程（含缺口程）</label> <span
	class="s_voyage_tip" data-role="jmp"
	data-params="{options:{boundaryShow:false,css:{maxWidth:320,minWidth:300},type:'jmp_title',position:'bottomLeft-topLeft',classNames:{boxType:'jmp_title'},template:'#fl_jmp_title',content:{'txt0':'多程（含缺口）', 'txt1':'<strong>多程：</strong>始发地到最终目的地之间，可经过多个机场中转或停留的航程。<br /><strong>缺口程：</strong>三地或四地之间的航程，缺口形式例如A-B，C-D，AD和BC可分别为同一区域的不同城市。'}}}"></span>
</p>
<div class="online_single" id="fl_online_single" style="display: ">
<div class="s_item_cont s_item_cont_ex">
<div class="s_exchange"><a href="javascript:;"
	id="fl_exchangeCity">换</a></div>
<div class="s_item online_label">出发城市<input tabindex="200"
	name="homecity_name" type="text" id="fl_txtDCity" autocomplete="off"
	mod_address_source="flightintl_start"
	mod_address_focusnext="fl_dest_city_1" mod_notice_tip="中文/拼音/英文"
	mod_save_id="flightintl_startcity_single" mod_save_value="true"
	mod_address_reference="fl_HomeCityID" mod="address|notice"
	mod_address_tpl="address" /> <input type="hidden" id="fl_HomeCityID"
	name="HomeCityID" /></div>
<div class="s_item2 online_label">出发日期<input tabindex="202"
	name="DDatePeriod1" type="text" id="fl_txtDDatePeriod1"
	mod="notice|calendar"
	mod_calendar_focusnext="fl_txtADatePeriod1~fl_txtADatePeriod1"
	mod_save_value="true" mod_save_id="flightintl_startdate_single"
	mod_notice_tip="yyyy-mm-dd" autocomplete="off" /></div>
</div>
<div class="s_item_cont">
<div class="s_item online_label">到达城市<input tabindex="201"
	name="destcity1_name" type="text" id="fl_dest_city_1"
	autocomplete="off" mod_address_source="flightintl_dest"
	mod_save_id="flightintl_arrivalcity_single" mod_notice_tip="中文/拼音/英文"
	mod_save_value="true" mod_address_reference="fl_destcityID"
	mod="address|notice" mod_address_tpl="address"
	mod_address_focusnext="fl_txtDDatePeriod1" /> <input type="hidden"
	id="fl_destcityID" name="destcityID" /></div>
<div class="s_item2 online_label" id="fl_return_li">返回日期<input
	tabindex="203" name="ADatePeriod1" type="text" id="fl_txtADatePeriod1"
	mod="notice|calendar" mod_calendar_reference="fl_txtDDatePeriod1"
	mod_notice_tip="yyyy-mm-dd" mod_save_value="true"
	mod_save_id="flightintl_backdate_single" autocomplete="off" /></div>
</div>
<div class="s_item_cont" id="fl_label_flight">
<div class="s_item">
<div class="s_item_direct"><label class="index_label"><input
	tabindex="204" type="checkbox" id="fl_flight_direct"
	name="flight_direct" value="T" />仅查看直飞</label></div>
</div>
</div>
</div>
<div class="online_more" id="fl_online_more" style="display: none">
<div id="fl_flight_multiple"></div>
<!-- hover时，请class追加s_add_voyage_hover，移出时隐藏 -->
<div class="s_add_voyage" id="fl_add_new_line"><i></i><a
	href="javascript:;">添加航程</a></div>
</div>

<div id="fl_options_flt_in" class="s_options" style="display: none">
<div class="s_item_cont" style="height: auto">
<div class="s_item">出行人数 <select name="Quantity"
	id="fl_drpQuantity" tabindex="205">
	<option selected="selected" value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
</select></div>
<div class="s_item2" id="fl_airline">航空公司 <input type="text"
	class="input_text" id="fl_txtAirline" name="txtAirline"
	mod_address_reference="fl_Airline" mod_address_source="airline"
	mod_notice_tip="（选填）中英文/代码" mod_address_tpl="airline"
	autocomplete="off" mod="address|notice" tabindex="206" /> <input
	type="hidden" id="fl_Airline" name="Airline" /></div>
<div class="s_item2" id="fl_isType">乘客类型<select name="childtype"
	id="fl_selUserType" tabindex="207">
	<option selected="selected" value="ADT">成人</option>
	<option value="CHD">儿童（2-12岁）</option>
</select></div>
<div class="s_item2">舱位等级<select name="drpSubClass"
	id="fl_drpSubClass" tabindex="208">
	<option selected="selected" value="Y">经济舱</option>
	<option value="S">超级经济舱</option>
	<option value="C">公务舱</option>
	<option value="F">头等舱</option>
</select></div>
</div>
<div class="s_flt_child_tip" id="fl_childTips" style="display: none">无成人陪伴的儿童请直接向航空公司预订</div>
</div>
<div style="display: none" id="fl_jmp_title">
<div class="jmp_hd">
<h3>${txt0}</h3>
</div>
<div class="jmp_bd" style="width: 260px">${txt1}</div>
</div>
<input type="hidden" name="hdn_enableCitySelectAjaxCall"
	id="hdn_enableCitySelectAjaxCall" value="1" />
<div class="s_item_cont"><!-- 单击后请给searchbox添加改变高度的class(视不同tab添加的class不同)，自身追加s_high_level_hover -->
<a href="javascript:;" id="fl_advancedSearch" class="s_high_level"><i></i>高级搜索</a>
</div>
<!-- hideFromCityCode -->
<div class="s_button_area"><input type="button" tabindex="209"
	value="搜索" class="s_btn" title="搜索" onclick="alert('国际机票模块正在升级维护中!');"
	id="" /></div>
<script type="text/json" id="fl_intlMessage">
							  {
								   ERROR_FLIGHT: [
										'请选择第{number}程的出发城市', 
										'请选择第{number}程的到达城市', 
										'您选择的第{number}程的到达城市和出发城市相同，请重新选择',
										'请选择第{number}程的出发日期',
										'日期格式有误，请检查',
										'对不起，第{number}程的出发日期不能在今天之前', 
										'对不起，只能查询一年内航班', 
										'对不起，第{number}程日期不能早于第{second}程日期', 
										'航程中必须有一程为国际航程，请检查您的出发到达城市', 
										'请选择出发城市', 
										'请选择出发日期', 
										'请选择目的城市', 
										'您选择的目的城市和出发城市相同，请重新选择', 
										'对不起，返回日期不能早于出发日期', 
										'当前日期不能小于今天'
									],
									TIPS_MESSAGER: '系统过于繁忙,请您耐心等待片刻之后再查询,谢谢!',
									numberList: ['一', '二', '三', '四', '五', '六', '七'],
									ZHUANG:'转',
									ADDRESS_SEARCHTIPS:'输入中英文|代码搜索或↑↓选择.',
									NO_FILTER_RESULT:' 对不起，无匹配，请重新输入。 ',
									FILTER_RESULT:'${val}，按字符顺序排序',
									GJM:"\"${val}\" 国家名，相关城市",
									MULTIPASS:{
										'big5':{
											startCity:'出发城市',
											endCity:'到达城市',
											startDate:'出发日期',
											notice:'中文/英文/拼音'
										},
										'gb2312':{
											startCity:'出发城市',
											endCity:'到达城市',
											startDate:'出发日期',
											notice:'中文/英文/拼音'
										}
									}
								}
							</script></form>
</div>
<!--机票搜索结束--> <!--旅游搜索开始-->
<div styletag="vacation" id="Div_Tab_3" class="s_content" style="display: none;">
<form id="vacationTab" name="vacationTab" action="spotline!SeachSpotline.jspx" method="post">
<div class="s_links">
<p><span>主题：</span><a
	href="#">摄影</a><a
	href="#">山水</a><a
	href="#">购物</a><a
	href="#">海岛</a><a
	href="#">自驾游</a><a
	href="#">登山</a><a
	href="#">古镇</a><a
	href="#">乐园</a><a
	href="#">蜜月</a><a
	href="#">都市</a></p>
<p><span>国内：</span><a
	href="#"
	rel="nofollow">海南</a><a
	href="#"
	rel="nofollow">福建</a><a
	href="#"
	rel="nofollow">云南</a><a
	href="#"
	rel="nofollow">广西贵州</a><a
	href="#"
	rel="nofollow">四川</a><a
	href="#">北京</a><a
	href="#"
	rel="nofollow">青岛</a><a
	href="#"
	rel="nofollow">大连</a><a
	href="#"
	rel="nofollow">张家界</a><a
	href="#"
	rel="nofollow">宜昌</a><a
	href="#"
	rel="nofollow">西安</a></p>
<p><span>出境：</span><a
	href="#"
	rel="nofollow">港澳台</a><a
	href="#"
	rel="nofollow">泰国</a><a
	href="#"
	rel="nofollow">日本</a><a
	href="#"
	rel="nofollow">韩国</a><a
	href="#"
	rel="nofollow">美国</a><a
	href="#"
	rel="nofollow">东南亚</a><a
	href="#"
	rel="nofollow">大洋洲</a><a
	href="#"
	rel="nofollow">美洲</a><a
	href="#"
	rel="nofollow">中东非洲</a><a
	href="#"
	rel="nofollow">欧洲</a></p>
<p><span>特色：</span><a href="#"
	rel="nofollow">签证</a><a
	href="#"
	rel="nofollow">租车服务</a><a href="#"
	rel="nofollow">当地游</a><a href="#"
	rel="nofollow">邮轮</a><a
	href="#"
	rel="nofollow">火车游</a><a
	href="#">自驾游</a><a
	href="#">自驾租车</a><a
	href="#" target="_blank" rel="nofollow">度假公寓</a></p>
</div>
<div class="s_item_cont">
<div class="s_item">出发地<input id="txtspotlinecity" onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); "
	type="text" value=""  class="s_vca_dest" />
	<div id="suggest" class="ac_results"></div>
    <input type="text" id="city_spotline_hide" name="CityID"   />
					
	
	</div>
<div class="s_item2">目的地<input id="txtspotlinecity2" onclick="this.value='';GetCityList2(this); " onkeyup="GetCityList2(this); "
	type="text"  class="inputSel"
	style="" />
	<div id="suggest2" class="ac_results"></div>
    <input type="text" id="city_spotline_hide2" name="EndCityID"   />
					
	
	
	</div>
</div>
<div class="s_button_area"><input id=""
	type="button" value="搜索" class="s_btn" title="搜索"  onclick="SeachSpotline()"/></div>
</form>
</div>
<!--旅游搜索结束--> <!--火车票开始 -->
<div styletag="train" id="Div_Tab_4" class="s_content" style="display: none;">
<p id="trainSubSwitch" class="s_type">行程类型 <label
	class="index_label" data-index="0"><input type="radio"
	checked="checked" id="singleTrip" value="Single" name="traintype"
	onclick="SelectTrip()">单程</label> <label class="index_label"
	data-index="1"><input type="radio" id="roundTrip"
	name="traintype" value="Double" onclick="SelectTrip()">往返</label></p>
<div class="s_item_cont s_item_cont_ex">
<div class="s_exchange"><a href="javascript:;"
	onclick="searchReturn();">换</a></div>
<div class="s_item">出发城市<input type="text" autocomplete="off"
	id="notice01" tabindex="1" onfocus="changeColor('#notice01')"
	onblur="changeColorLeave('#notice01')" style="color: gray;"><input
	type="hidden" value="" id="from" name="from" /></div>
<div class="s_item2">出发日期<input type="text" autocomplete="off"
	tabindex="3" onfocus="changeColor('#DdateObj')"
	onblur="changeColorLeave('#DdateObj')" id="DdateObj" name="DdateObj"
	style="color: gray;" onchange="ChangeDate(1)"></div>
</div>
<div class="s_item_cont">
<div class="s_item">到达城市<input type="text" autocomplete="off"
	id="notice02" tabindex="2" onfocus="changeColor('#notice02')"
	onblur="changeColorLeave('#notice02')" style="color: gray;"> <input
	type="hidden" value="" id="to" name="to" /></div>
<div id="ArraveDate" class="s_item2 s_disable">返回日期<input
	type="text" autocomplete="off" tabindex="3"
	onfocus="changeColor('#AdateObj')"
	onblur="changeColorLeave('#AdateObj')" id="AdateObj" name="AdateObj"
	style="color: gray;" onchange="ChangeDate(2)"></div>
</div>
<div class="s_button_area"><input type="button" id=""
	name="" title="搜索" class="s_btn" value="搜索" onclick="alert('火车票模块正在升级维护中');" /></div>
</div>
<!--火车票结束 --> <!--门票搜索开始-->
<div styletag="ticket" id="Div_Tab_5" class="s_content" style="display: none;">
<form id="ticketTab" name="ticketTab" action="spotticket!SeachSpot.jspx" method="post">
<div class="s_links">
<p><span>时令主题：</span><a
	href="#">嬉水漂流</a><a
	href="#">赏花</a><a
	href="#">乐园</a><a
	href="#">古镇</a></p>
<p><span>精选城市：</span><a
	href="#"
	rel="nofollow">上海</a><a
	href="#"
	rel="nofollow">广州</a><a
	href="#"
	rel="nofollow">深圳</a><a
	href="#"
	rel="nofollow">北京</a><a
	href="#"
	rel="nofollow">成都</a><a
	href="#"
	rel="nofollow">杭州</a><a
	href="#"
	rel="nofollow">苏州</a><a
	href="#"
	rel="nofollow">青岛</a><a
	href="#"
	rel="nofollow">厦门</a><a
	href="#"
	rel="nofollow">三亚</a></p>
<p><span>热门推荐：</span><a
	href="#">特权日</a><a
	href="#">东方明珠</a><a
	href="#">常州恐龙园</a><a
	href="#">广州长隆</a><a
	href="#">千岛湖</a><a
	href="#">东部华侨城</a></p>
</div>
<div class="s_item_cont">
<div class="s_item w100">目的地<input type="text" value="城市名" onclick="this.value='';GetCityList_spot(this); " onkeyup="GetCityList_spot(this); "
	id="txthotelcity" data-default="城市名" class="w03 inputSel"  />
	
	 <div id="suggest" class="ac_results"></div>
     <input type="hidden" id="city_hotel_hide" name="CityID" value=""  />
     
	</div>
<div class="s_item w100">关键字
<input type="text" value=""  id="SeachName" name="SeachName"  class="w03"  />
</div>
</div>
<div class="s_button_area"><input type="button" value="搜索" onclick="SeachSpotticket()"
	class="s_btn" title="搜索" id="" /></div>
</form>
</div>
<!--门票搜索结束--> <!--手机版开始 -->
<div styletag="mobilePhone" id="Div_Tab_6" class="s_content" style="display: none;">
<form action="" id="wirelessForm">
<div class="s_wireless_l">
<div align="center" style="color: red"><b><big>环球票务，赢定天下</big></b></div>
<a href="#" target="_blank" class="s_wireless_link"
	rel="nofollow">捷翔无线</a></div>
<div class="s_wireless_r">
<p class="s_wireless_title">直接下载</p>
<div class="s_wireless_download"><a
	href="#" target="_blank" class="iphone"
	title="iPhone" rel="nofollow"><span></span>iPhone</a> <a
	href="#" target="_blank" class="ipad"
	title="iPad" rel="nofollow"><span></span>iPad</a> <a
	href="#" target="_blank"
	class="android" title="Android" rel="nofollow"><span></span>Android</a>
</div>
<div class="s_item_cont">
<div class="s_item w100">手机号码<input id="mobilePhoneId" class="w04"
	type="text" value="" autocomplete="off" /></div>
</div>
<a id="mobileSmt" href="javascript:;" class="s_wireless_send"
	rel="nofollow">发送下载地址到手机</a>
<div id="wirelessTip" class="s_wireless_suc" style="visibility: hidden;">
<b></b> 短信发送成功，请稍后查看。</div>
</div>
</form>
</div>
<!--手机版结束 --> <!--env:4,update:2013-9-3 14:05:28--> <!-- 搜索框产品内容结束 --></div>
<!-- tab搜索 end -->
	<!--幻灯片-->
	<!--<div class="pic_banner">
	<div class="pic_banner_t " id="allyesId11">
	<img src="images/20130929171419.jpg" />
	</div>
	<div class="pic_banner_b " id="allyesId211">
	<img src="images/20130929171419.jpg" />
	</div>
	</div>-->
	<div id="focus_box">
	    <ul id="focus_pic">
	        <li><a><img src="http://gtms01.alicdn.com/tps/i1/T1TZzTFnJeXXbOUvrA-1920-295.jpg"></a></li>
	        <li><a><img src="http://img01.taobaocdn.com/tps/i1/T1Ev2JFklcXXbOUvrA-1920-295.jpg"></a></li>
	        <li><a><img src="http://gtms04.alicdn.com/tps/i4/T1OiTgFb0bXXbOUvrA-1920-295.jpg"></a></li>
	        <li><a><img src="http://gtms01.alicdn.com/tps/i1/T1eeN_XxJXXXaqWvrA-1920-295.png)"></a></li>
	        <li><a><img src="http://gtms01.alicdn.com/tps/i1/T1K5HVFaBcXXXlDLTM-1925-295.jpg"></a></li>
	    </ul>
	</div>
</div>
<div id="cui_bd" class="cui_bd">
<!--left start-->
<div class="bd_left"><!--猜你喜欢start-->
<div id="customerGuess" class="c_customer" style="display: none;">
<dl class="c_history" id="guessLeft">
</dl>
<div class="c_likes">
<h2>猜您喜欢</h2>
<div class="c_likes_in">
<div class="c_likes_list" id="guessItems"></div>
</div>
<a title="关闭并清除浏览历史" href="javascript:;" class="c_customer_close"
	id="guessClose"
	onclick="this.parentNode.parentNode.style.display='none';"></a> <a
	href="javascript:;" class="c_customer_next" id="guessNext"></a> <a
	href="javascript:;" class="c_customer_prev_un" id="guessPrev"></a></div>
</div>
<!--猜你喜欢end--> <!--度假 start -->
<h2 id="vacation_tab" class="h2_tabtitle">
<span id="tab_1" onclick="ChangType(1);" class="current">门票</span>
<span id="tab_2" onclick="ChangType(2);" >周边旅游</span>
<span id="tab_3" onclick="ChangType(3);">国内旅游</span>
<span id="tab_4" onclick="ChangType(4);">出境旅游</span>
<span id="tab_5" onclick="ChangType(5);">邮轮</span>
</h2>

<div class="citys" style="display: none">
<a class="startcity" href="javascript:void(0);"
	id="v_departure"><span cityId=2>上海</span>出发</a>
<div class="departures" id="v_departure_city" style="display: none;">
<h5>热门出发城市</h5>
<a title="BeiJing" data-id="1" href="javascript:void(0);">北京</a><a
	title="ShangHai" data-id="2" href="javascript:void(0);">上海</a><a
	title="TianJin" data-id="3" href="javascript:void(0);">天津</a><a
	title="QingDao" data-id="7" href="javascript:void(0);">青岛</a><a
	title="NanJing" data-id="12" href="javascript:void(0);">南京</a><a
	title="HangZhou" data-id="17" href="javascript:void(0);">杭州</a><a
	title="XiaMen" data-id="25" href="javascript:void(0);">厦门</a><a
	title="ChengDu" data-id="28" href="javascript:void(0);">成都</a><a
	title="ShenZhen" data-id="30" href="javascript:void(0);">深圳</a><a
	title="GuangZhou" data-id="32" href="javascript:void(0);">广州</a><a
	title="ShenYang" data-id="451" href="javascript:void(0);">沈阳</a><a
	title="WuHan" data-id="477" href="javascript:void(0);">武汉</a>
<ul class="departures_sequence">
	<li><span>B</span><a title="BeiJing" href="javascript:void(0);"
		data-id="1">北京</a><a title="BaoTou" href="javascript:void(0);"
		data-id="141">包头</a></li>
	<li><span>M</span><a title="MianYang" href="javascript:void(0);"
		data-id="370">绵阳</a></li>
	<li><span>C</span><a title="ZhongQing" href="javascript:void(0);"
		data-id="4">重庆</a><a title="ChengDu" href="javascript:void(0);"
		data-id="28">成都</a><a title="ChangChun" href="javascript:void(0);"
		data-id="158">长春</a><a title="ChangSha" href="javascript:void(0);"
		data-id="206">长沙</a><a title="ChangZhou" href="javascript:void(0);"
		data-id="213">常州</a></li>
	<li><span>N</span><a title="NanJing" href="javascript:void(0);"
		data-id="12">南京</a><a title="NingBo" href="javascript:void(0);"
		data-id="375">宁波</a><a title="NanChang" href="javascript:void(0);"
		data-id="376">南昌</a><a title="NanNing" href="javascript:void(0);"
		data-id="380">南宁</a></li>
	<li><span>D</span><a title="DaLian" href="javascript:void(0);"
		data-id="6">大连</a><a title="DongZuo" href="javascript:void(0);"
		data-id="223">东莞</a></li>
	<li><span>Q</span><a title="QingDao" href="javascript:void(0);"
		data-id="7">青岛</a><a title="QuanZhou" href="javascript:void(0);"
		data-id="406">泉州</a></li>
	<li><span>F</span><a title="FoShan" href="javascript:void(0);"
		data-id="251">佛山</a><a title="FuZhou" href="javascript:void(0);"
		data-id="258">福州</a></li>
	<li><span>S</span><a title="ShangHai" href="javascript:void(0);"
		data-id="2">上海</a><a title="SuZhou" href="javascript:void(0);"
		data-id="14">苏州</a><a title="ShenZhen" href="javascript:void(0);"
		data-id="30">深圳</a><a title="SanYa" href="javascript:void(0);"
		data-id="43">三亚</a><a title="ShiJiaZhuang" href="javascript:void(0);"
		data-id="428">石家庄</a><a title="ShanTou" href="javascript:void(0);"
		data-id="447">汕头</a><a title="ShenYang" href="javascript:void(0);"
		data-id="451">沈阳</a></li>
	<li><span>G</span><a title="GuangZhou" href="javascript:void(0);"
		data-id="32">广州</a><a title="GuiYang" href="javascript:void(0);"
		data-id="38">贵阳</a></li>
	<li><span>T</span><a title="TianJin" href="javascript:void(0);"
		data-id="3">天津</a><a title="TaiYuan" href="javascript:void(0);"
		data-id="105">太原</a><a title="TaiZhou" href="javascript:void(0);"
		data-id="578">台州</a></li>
	<li><span>H</span><a title="HaErBin" href="javascript:void(0);"
		data-id="5">哈尔滨</a><a title="HangZhou" href="javascript:void(0);"
		data-id="17">杭州</a><a title="HaiKou" href="javascript:void(0);"
		data-id="42">海口</a><a title="HuHeHaoTe" href="javascript:void(0);"
		data-id="103">呼和浩特</a><a title="HaiLaEr" href="javascript:void(0);"
		data-id="142">海拉尔</a><a title="HeFei" href="javascript:void(0);"
		data-id="278">合肥</a></li>
	<li><span>W</span><a title="WuXi" href="javascript:void(0);"
		data-id="13">无锡</a><a title="WuLuMuQi" href="javascript:void(0);"
		data-id="39">乌鲁木齐</a><a title="WuHan" href="javascript:void(0);"
		data-id="477">武汉</a><a title="WeiHai" href="javascript:void(0);"
		data-id="479">威海</a><a title="WenZhou" href="javascript:void(0);"
		data-id="491">温州</a></li>
	<li><span>J</span><a title="JiNan" href="javascript:void(0);"
		data-id="144">济南</a><a title="JiangMen" href="javascript:void(0);"
		data-id="316">江门</a></li>
	<li><span>X</span><a title="XiAn" href="javascript:void(0);"
		data-id="10">西安</a><a title="XiaMen" href="javascript:void(0);"
		data-id="25">厦门</a><a title="XiNing" href="javascript:void(0);"
		data-id="124">西宁</a><a title="XiChang" href="javascript:void(0);"
		data-id="494">西昌</a><a title="XuZhou" href="javascript:void(0);"
		data-id="512">徐州</a></li>
	<li><span>K</span><a title="KunMing" href="javascript:void(0);"
		data-id="34">昆明</a><a title="KaShiShi" href="javascript:void(0);"
		data-id="109">喀什市</a></li>
	<li><span>Y</span><a title="YinChuan" href="javascript:void(0);"
		data-id="99">银川</a><a title="YunCheng" href="javascript:void(0);"
		data-id="140">运城</a><a title="YanJi" href="javascript:void(0);"
		data-id="523">延吉</a><a title="YuLin" href="javascript:void(0);"
		data-id="527">榆林</a><a title="YanTai" href="javascript:void(0);"
		data-id="533">烟台</a><a title="YiWu" href="javascript:void(0);"
		data-id="536">义乌</a></li>
	<li><span>L</span><a title="LaSa" href="javascript:void(0);"
		data-id="41">拉萨</a><a title="LanZhou" href="javascript:void(0);"
		data-id="100">兰州</a></li>
	<li><span>Z</span><a title="ZhuHai" href="javascript:void(0);"
		data-id="31">珠海</a><a title="ZhongShan" href="javascript:void(0);"
		data-id="553">中山</a><a title="ZhengZhou" href="javascript:void(0);"
		data-id="559">郑州</a></li>
</ul>
</div>
</div>
<div id="vacation_tab_1" class="citytabs">
<a class="current"
	pinyin="HangZhou" id="spot_a_1" title="杭州" href="javascript:void(0);" onclick="selectspotticket(1,383)">杭州</a><a
	pinyin="ShangHai" id="spot_a_2" title="上海" href="javascript:void(0);" onclick="selectspotticket(2,321)">上海</a><a
	pinyin="JiangSu"  id="spot_a_3" title="南京" href="javascript:void(0);" onclick="selectspotticket(3,220)">南京</a><a
	pinyin="ZheJiang" id="spot_a_4" title="九江" href="javascript:void(0);" onclick="selectspotticket(4,238)">九江</a><a
	pinyin="AnHui"    id="spot_a_5" title="黄山" href="javascript:void(0);" onclick="selectspotticket(5,44)">黄山</a><a
	pinyin="BeiJing"  id="spot_a_6" title="北京" href="javascript:void(0);" onclick="selectspotticket(6,52)">北京</a><a
	pinyin="ShanDong" id="spot_a_7" title="青岛" href="javascript:void(0);" onclick="selectspotticket(7,284)">青岛</a>
<div id="vacationsCityPop_1" class="city_pop" style="display: none"><a class="more"
	href="javascript:void(0);">更多</a>
<div id="vacationsMoreCity_1" class="morecity"
	style="display: none; width: 82px;"><a pinyin="GuangDong"
	title="广东" href="javascript:void(0);">广东</a><a pinyin="GangAoTai"
	title="港澳台" href="javascript:void(0);">港澳台</a><a pinyin="RiHan"
	title="日韩" href="javascript:void(0);">日韩</a><a pinyin="DongNanYa"
	title="东南亚" href="javascript:void(0);">东南亚</a></div>
</div>
</div>
<div id="vacation_tab_2" class="citytabs" style="display: none;">
<a class="current"
	pinyin="JingXuan" title="精选" href="javascript:void(0);">精选</a><a
	pinyin="ShangHai" title="上海" href="javascript:void(0);">上海</a><a
	pinyin="JiangSu" title="江苏" href="javascript:void(0);">江苏</a><a
	pinyin="ZheJiang" title="浙江" href="javascript:void(0);">浙江</a><a
	pinyin="AnHui" title="安徽" href="javascript:void(0);">安徽</a><a
	pinyin="BeiJing" title="北京" href="javascript:void(0);">北京</a><a
	pinyin="ShanDong" title="山东" href="javascript:void(0);">山东</a>


</div>
<div id="vacation_tab_3" class="citytabs" style="display: none;">
<a class="current"
	pinyin="JingXuan" title="精选" href="javascript:void(0);">精选</a><a
	pinyin="ShangHai" title="上海" href="javascript:void(0);">上海</a><a
	pinyin="JiangSu" title="乌镇" href="javascript:void(0);">乌镇</a><a
	pinyin="ZheJiang" title="杭州" href="javascript:void(0);">杭州</a><a
	pinyin="AnHui" title="黄山" href="javascript:void(0);">黄山</a><a
	pinyin="BeiJing" title="北京" href="javascript:void(0);">北京</a><a
	pinyin="ShanDong" title="青岛" href="javascript:void(0);">青岛</a>

</div>
<div id="vacation_tab_4" class="citytabs" style="display: none;">
<a class="current"
	pinyin="JingXuan" title="精选" href="javascript:void(0);">精选</a><a
	pinyin="ShangHai" title="上海" href="javascript:void(0);">上海</a><a
	pinyin="JiangSu" title="江苏" href="javascript:void(0);">江苏</a><a
	pinyin="ZheJiang" title="浙江" href="javascript:void(0);">浙江</a><a
	pinyin="AnHui" title="安徽" href="javascript:void(0);">安徽</a><a
	pinyin="BeiJing" title="北京" href="javascript:void(0);">北京</a><a
	pinyin="ShanDong" title="山东" href="javascript:void(0);">山东</a>

</div>
<div id="vacation_tab_5" class="citytabs" style="display: none;">
<a class="current"
	pinyin="JingXuan" title="精选" href="javascript:void(0);">精选</a><a
	pinyin="ShangHai" title="上海" href="javascript:void(0);">上海</a><a
	pinyin="JiangSu" title="江苏" href="javascript:void(0);">江苏</a><a
	pinyin="ZheJiang" title="浙江" href="javascript:void(0);">浙江</a><a
	pinyin="AnHui" title="安徽" href="javascript:void(0);">安徽</a><a
	pinyin="BeiJing" title="北京" href="javascript:void(0);">北京</a><a
	pinyin="ShanDong" title="山东" href="javascript:void(0);">山东</a>

</div>
<div id="divSpotticketHtml" class="vac_list">

<!--update:2013-9-24 13:51:27-->
</div>
<!--度假 end --> 


<!--酒店 start -->

<h2 class="h2_tabtitle"><span class="current">精选酒店</span></h2>
<div class="citytabs" id="hotelCityTab">
	<a class="current" title="北京酒店" id="hotel_a_1" href="#" onclick="selecthotel(1,607);return false;">北京</a>
	<a  title="上海酒店" id="hotel_a_2" href="#" onclick="selecthotel(2,321);return false;">上海</a>
	<a  title="广州酒店" id="hotel_a_3" href="#" onclick="selecthotel(3,80);return false;">广州</a>
	<a  title="成都酒店" id="hotel_a_4" href="#" onclick="selecthotel(4,324);return false;">成都</a>
	<a  title="深圳酒店" id="hotel_a_5" href="#" onclick="selecthotel(5,91);return false;">深圳</a>
	<a  title="杭州酒店" id="hotel_a_6" href="#" onclick="selecthotel(6,383);return false;">杭州</a>
	<a  title="南京酒店" id="hotel_a_7" href="#" onclick="selecthotel(7,224);return false;">南京</a>
	<a  title="千岛湖酒店" id="hotel_a_8" href="#" onclick="selecthotel(8,15469);return false;">千岛湖</a>
	<a  title="天津酒店" id="hotel_a_9" href="#" onclick="selecthotel(9,343);return false;">天津</a>
	<a  title="首尔酒店" id="hotel_a_10" href="#" onclick="selecthotel(10,607);return false;">首尔</a>
	<a  title="台北酒店" id="hotel_a_11" href="#" onclick="selecthotel(11,607);return false;">台北</a>
	<a  title="东京酒店" id="hotel_a_12" href="#" onclick="selecthotel(12,607);return false;">东京</a>
<div id="hotelCityPop" class="city_pop" style="display: none"><a class="more"
	href="javascript:void(0);">更多</a>
<div id="hotelMoreCity" class="morecity morecity_limit"><a
	data-id="7" data-type="1" href="javascript:void(0);">青岛</a><a
	data-id="25" data-type="1" href="javascript:void(0);">厦门</a><a
	data-id="10" data-type="1" href="javascript:void(0);">西安</a><a
	data-id="477" data-type="1" href="javascript:void(0);">武汉</a><a
	data-id="43" data-type="1" href="javascript:void(0);">三亚</a><a
	data-id="4" data-type="1" href="javascript:void(0);">重庆</a><a
	data-id="6" data-type="1" href="javascript:void(0);">大连</a><a
	data-id="451" data-type="1" href="javascript:void(0);">沈阳</a><a
	data-id="58" data-type="1" href="javascript:void(0);">香港</a><a
	data-id="144" data-type="1" href="javascript:void(0);">济南</a><a
	data-id="34" data-type="1" href="javascript:void(0);">昆明</a><a
	data-id="206" data-type="1" href="javascript:void(0);">长沙</a><a
	data-id="559" data-type="1" href="javascript:void(0);">郑州</a><a
	data-id="38" data-type="1" href="javascript:void(0);">贵阳</a><a
	data-id="14" data-type="1" href="javascript:void(0);">苏州</a><a
	data-id="13" data-type="1" href="javascript:void(0);">无锡</a><a
	data-id="278" data-type="1" href="javascript:void(0);">合肥</a><a
	data-id="39" data-type="1" href="javascript:void(0);">乌鲁木齐</a><a
	data-id="23" data-type="1" href="javascript:void(0);">黄山</a><a
	data-id="37" data-type="1" href="javascript:void(0);">丽江</a><a
	data-id="33" data-type="1" href="javascript:void(0);">桂林</a><a
	data-id="871" data-type="1" href="javascript:void(0);">阳朔</a>
<div id="hotelMoreLine"></div>
<a data-id="725" data-type="2" href="javascript:void(0);">普吉岛</a><a
	data-id="315" data-type="2" href="javascript:void(0);">吉隆坡</a><a
	data-id="723" data-type="2" href="javascript:void(0);">巴厘岛</a><a
	data-id="501" data-type="2" href="javascript:void(0);">悉尼</a><a
	data-id="219" data-type="2" href="javascript:void(0);">大阪</a><a
	data-id="1225" data-type="2" href="javascript:void(0);">兰卡威</a><a
	data-id="1369" data-type="2" href="javascript:void(0);">暹粒</a><a
	data-id="737" data-type="2" href="javascript:void(0);">济州岛</a><a
	data-id="1229" data-type="2" href="javascript:void(0);">苏梅岛</a><a
	data-id="623" data-type="2" href="javascript:void(0);">清迈</a><a
	data-id="192" data-type="2" href="javascript:void(0);">巴黎</a><a
	data-id="220" data-type="2" href="javascript:void(0);">迪拜</a><a
	data-id="301" data-type="2" href="javascript:void(0);">胡志明市</a><a
	data-id="633" data-type="2" href="javascript:void(0);">纽约</a><a
	data-id="338" data-type="2" href="javascript:void(0);">伦敦</a></div>
</div>
</div>
<div class="hotel_list" id="divHotelHtml">

</div>
<!--酒店 end --> 

<!--机票 start -->

<!--机票 end -->
</div>
<!--left end--> <!--right start-->
<div class="bd_right"><!-- 促销特惠 start -->
<h2 class="h2_title">促销特惠</h2>

<div class="ad_onsale" id="ad_onsaleId"><a rel="nofollow"
	href="#"
	title="订酒店 返现金，最高达201元/间夜" target="_blank"><img
	src="http://pic.c-ctrip.com/index/pic_onsale07_s.png?20130427.png"
	alt="订酒店 返现金，最高达201元/间夜" /></a> <a rel="nofollow"
	href="#"
	title="订机票 返现金，最高达715元/票" target="_blank"><img
	src="http://pic.c-ctrip.com/index/pic_onsale08_s.png?20130624.png"
	alt="订机票 返现金，最高达715元/票" /></a> <a rel="nofollow"
	href="#"
	title="门票千万返现?第三弹，人气产品直减90% 每周三1元秒杀" target="_blank"><img
	src="http://pic.c-ctrip.com/index/pic_onsale12_s.png"
	alt="门票千万返现?第三弹，人气产品直减90% 每周三1元秒杀" /></a> <a rel="nofollow"
	href="#"
	title="捷翔礼品卡，福利、送礼、奖品最佳选择" target="_blank"><img
	src="http://pic.c-ctrip.com/index/pic_onsale05_s.png?20130427.png"
	alt="捷翔礼品卡，福利、送礼、奖品最佳选择" /></a> <a rel="nofollow"
	href="#" target="_blank"
	title="HHtravel 鸿鹄逸游, 实现13个梦想！四季环球游"><img
	src="http://pic.c-ctrip.com/index/pic_onsale13.png"
	alt="HHtravel 鸿鹄逸游, 实现13个梦想！四季环球游" /></a> 
	<!--<a rel="nofollow"
	href="#"
	target="_blank" title="途家网 高品质服务公寓,花多少 返多少！0元入住"><img
	src="http://pic.c-ctrip.com/index/pic_onsale14.png"
	alt="途家网 高品质服务公寓,花多少 返多少！0元入住" /></a>-->
</div>

<!-- 促销特惠 end --> 
<!-- 订阅信息 start -->

<!--<div class="mail_book"><span class="bold">&nbsp;</span></div>-->
<div id="mail_state_sucess" class="mail_book_success"
	style="display: none;"><i></i>订阅成功&nbsp;&nbsp;&nbsp;&nbsp;<a
	href="javascript:void(0);">返回</a></div>
<!-- 订阅信息 end--> 

<!-- 特色服务&工具箱开始 -->

<div class="toolbox">

	<div class="journal-item">
		<a class="item-photo" rel="nofollow" target="_blank" href="/travels/yanqing770/1545341.html">
		<img width="180" style="display: block;" src="http://dimg01.c-ctrip.com/images/tg/331/598/615/89a756bec55749fe992675ef43c08f9e_R_240_240.jpg">
		</a>
		<div><a class="item-link" target="_blank" href="/travels/yanqing770/1545341.html">『携程微游记新手指南』+北京文艺之旅（用胶片记录行走时光）</a></div>
		<div class="item-info">这是说明哦，哈哈哈哈</div>
    </div>
    <div class="journal-item">
		<a class="item-photo" rel="nofollow" target="_blank" href="/travels/yanqing770/1545341.html">
		<img width="180" style="display: block;" src="http://dimg01.c-ctrip.com/images/tg/331/598/615/89a756bec55749fe992675ef43c08f9e_R_240_240.jpg">
		</a>
		<div><a class="item-link" target="_blank" href="/travels/yanqing770/1545341.html">『携程微游记新手指南』+北京文艺之旅（用胶片记录行走时光）</a></div>
		<div class="item-info">这是说明哦，哈哈哈哈</div>
    </div>
    <div class="journal-item">
		<a class="item-photo" rel="nofollow" target="_blank" href="/travels/yanqing770/1545341.html">
		<img width="180" style="display: block;" src="http://dimg01.c-ctrip.com/images/tg/331/598/615/89a756bec55749fe992675ef43c08f9e_R_240_240.jpg">
		</a>
		<div><a class="item-link" target="_blank" href="/travels/yanqing770/1545341.html">『携程微游记新手指南』+北京文艺之旅（用胶片记录行走时光）</a></div>
		<div class="item-info">这是说明哦，哈哈哈哈</div>
    </div>
</div>
<!-- 特色服务&工具箱结束 --> 

<!--right end-->
</div>
<!--body end-->




<!--seo start-->

<!--seo end-->
<!-- InstanceEnd name="position" -->
<!--页脚 start-->
<div id="footer" class="footer">
<p><a rel="nofollow" title="免费注册"
	href="#">免费注册</a> | <a
	title="网站导航" href="#">网站导航</a>
| <a title="宾馆索引"
	href="#">宾馆索引</a> | <a
	title="机票索引"
	href="#">机票索引</a>
| <a rel="nofollow" title="服务说明"
	href="#">服务说明</a> | <a
	rel="nofollow" title="关于捷翔"
	href="#">关于捷翔</a> | <a
	rel="nofollow"
	href="#"
	title="企业公民">企业公民</a> | <a rel="nofollow"
	href="#"
	title="旅游度假资质">旅游度假资质</a> | <a rel="nofollow" title="诚聘英才"
	href="#">诚聘英才</a> | <a rel="nofollow" title="分销联盟"
	href="#">分销联盟</a> | <a rel="nofollow" title="企业礼品卡采购"
	href="#">企业礼品卡采购</a>
| <a rel="nofollow" title="代理合作"
	href="#">代理合作</a> | <a
	rel="nofollow" title="广告业务"
	href="#">广告业务</a> | <a
	rel="nofollow" title="联系我们"
	href="#">联系我们</a> | <a
	class="suggestions" rel="nofollow" target="_blank" title="我要提建议"
	href="#">我要提建议</a></p>
<p><a rel="nofollow" target="_blank"
	href="#">营业执照</a> | <a
	rel="nofollow" target="_blank"
	href="#">保险代理</a> | <a
	target="_blank"
	href="#">友情链接</a> | <a
	rel="nofollow" href="#">Copyright&copy;</a>
1999-2023, <a href="#"> www.191121266.com</a>. All rights. | <a rel="nofollow" target="_blank"
	href="http://www.miibeian.gov.cn/">ICP证：沪B2-20050130</a></p>

<div class="policewrap layoutfix"><a
	class="police_g" title="工商亮照标识" target="blank" rel="nofollow"
	href="#"></a>
<a class="police_c"
	href="#"
	target="_blank" rel="nofollow" title="诚信认证示范企业"></a> <a
	class="police_x" href="#" rel="nofollow"
	target="_blank" title="征信网"></a> <a class="police_j" href="javascript:"
	rel="nofollow" title="互联网违法与违规信息举报中心"></a> <a title="可信网站"
	target="_blank"
	href="#"
	rel="nofollow" class="police_k"></a></div>
</div>
<!--页脚 end-->
<input type="hidden" id="page_id" value="100101991" />
<input type="hidden" id="_releaseNo_" value="201300816.js" />
<input type="hidden" id="uid" value="" />
<input type="hidden" id="hongkongMask" value="" />
<input type="hidden" id="solution" value="PRO|GB" />
<div class="departures" id="pkgStartCityDiv" style="display: none;">
<h5>热门出发城市</h5>
<a title="BeiJing" data-id="1" href="javascript:void(0);">北京</a><a
	title="ShangHai" data-id="2" href="javascript:void(0);">上海</a><a
	title="TianJin" data-id="3" href="javascript:void(0);">天津</a><a
	title="QingDao" data-id="7" href="javascript:void(0);">青岛</a><a
	title="NanJing" data-id="12" href="javascript:void(0);">南京</a><a
	title="HangZhou" data-id="17" href="javascript:void(0);">杭州</a><a
	title="XiaMen" data-id="25" href="javascript:void(0);">厦门</a><a
	title="ChengDu" data-id="28" href="javascript:void(0);">成都</a><a
	title="ShenZhen" data-id="30" href="javascript:void(0);">深圳</a><a
	title="GuangZhou" data-id="32" href="javascript:void(0);">广州</a><a
	title="ShenYang" data-id="451" href="javascript:void(0);">沈阳</a><a
	title="WuHan" data-id="477" href="javascript:void(0);">武汉</a>
<ul class="departures_sequence">
	<li><span>B</span><a title="BeiJing" href="javascript:void(0);"
		data-id="1">北京</a><a title="BaoTou" href="javascript:void(0);"
		data-id="141">包头</a></li>
	<li><span>M</span><a title="MianYang" href="javascript:void(0);"
		data-id="370">绵阳</a></li>
	<li><span>C</span><a title="ZhongQing" href="javascript:void(0);"
		data-id="4">重庆</a><a title="ChengDu" href="javascript:void(0);"
		data-id="28">成都</a><a title="ChangChun" href="javascript:void(0);"
		data-id="158">长春</a><a title="ChangSha" href="javascript:void(0);"
		data-id="206">长沙</a><a title="ChangZhou" href="javascript:void(0);"
		data-id="213">常州</a></li>
	<li><span>N</span><a title="NanJing" href="javascript:void(0);"
		data-id="12">南京</a><a title="NingBo" href="javascript:void(0);"
		data-id="375">宁波</a><a title="NanChang" href="javascript:void(0);"
		data-id="376">南昌</a><a title="NanNing" href="javascript:void(0);"
		data-id="380">南宁</a></li>
	<li><span>D</span><a title="DaLian" href="javascript:void(0);"
		data-id="6">大连</a><a title="DongZuo" href="javascript:void(0);"
		data-id="223">东莞</a></li>
	<li><span>Q</span><a title="QingDao" href="javascript:void(0);"
		data-id="7">青岛</a><a title="QuanZhou" href="javascript:void(0);"
		data-id="406">泉州</a></li>
	<li><span>F</span><a title="FoShan" href="javascript:void(0);"
		data-id="251">佛山</a><a title="FuZhou" href="javascript:void(0);"
		data-id="258">福州</a></li>
	<li><span>S</span><a title="ShangHai" href="javascript:void(0);"
		data-id="2">上海</a><a title="SuZhou" href="javascript:void(0);"
		data-id="14">苏州</a><a title="ShenZhen" href="javascript:void(0);"
		data-id="30">深圳</a><a title="SanYa" href="javascript:void(0);"
		data-id="43">三亚</a><a title="ShiJiaZhuang" href="javascript:void(0);"
		data-id="428">石家庄</a><a title="ShanTou" href="javascript:void(0);"
		data-id="447">汕头</a><a title="ShenYang" href="javascript:void(0);"
		data-id="451">沈阳</a></li>
	<li><span>G</span><a title="GuangZhou" href="javascript:void(0);"
		data-id="32">广州</a><a title="GuiYang" href="javascript:void(0);"
		data-id="38">贵阳</a></li>
	<li><span>T</span><a title="TianJin" href="javascript:void(0);"
		data-id="3">天津</a><a title="TaiYuan" href="javascript:void(0);"
		data-id="105">太原</a><a title="TaiZhou" href="javascript:void(0);"
		data-id="578">台州</a></li>
	<li><span>H</span><a title="HaErBin" href="javascript:void(0);"
		data-id="5">哈尔滨</a><a title="HangZhou" href="javascript:void(0);"
		data-id="17">杭州</a><a title="HaiKou" href="javascript:void(0);"
		data-id="42">海口</a><a title="HuHeHaoTe" href="javascript:void(0);"
		data-id="103">呼和浩特</a><a title="HaiLaEr" href="javascript:void(0);"
		data-id="142">海拉尔</a><a title="HeFei" href="javascript:void(0);"
		data-id="278">合肥</a></li>
	<li><span>W</span><a title="WuXi" href="javascript:void(0);"
		data-id="13">无锡</a><a title="WuLuMuQi" href="javascript:void(0);"
		data-id="39">乌鲁木齐</a><a title="WuHan" href="javascript:void(0);"
		data-id="477">武汉</a><a title="WeiHai" href="javascript:void(0);"
		data-id="479">威海</a><a title="WenZhou" href="javascript:void(0);"
		data-id="491">温州</a></li>
	<li><span>J</span><a title="JiNan" href="javascript:void(0);"
		data-id="144">济南</a><a title="JiangMen" href="javascript:void(0);"
		data-id="316">江门</a></li>
	<li><span>X</span><a title="XiAn" href="javascript:void(0);"
		data-id="10">西安</a><a title="XiaMen" href="javascript:void(0);"
		data-id="25">厦门</a><a title="XiNing" href="javascript:void(0);"
		data-id="124">西宁</a><a title="XiChang" href="javascript:void(0);"
		data-id="494">西昌</a><a title="XuZhou" href="javascript:void(0);"
		data-id="512">徐州</a></li>
	<li><span>K</span><a title="KunMing" href="javascript:void(0);"
		data-id="34">昆明</a><a title="KaShiShi" href="javascript:void(0);"
		data-id="109">喀什市</a></li>
	<li><span>Y</span><a title="YinChuan" href="javascript:void(0);"
		data-id="99">银川</a><a title="YunCheng" href="javascript:void(0);"
		data-id="140">运城</a><a title="YanJi" href="javascript:void(0);"
		data-id="523">延吉</a><a title="YuLin" href="javascript:void(0);"
		data-id="527">榆林</a><a title="YanTai" href="javascript:void(0);"
		data-id="533">烟台</a><a title="YiWu" href="javascript:void(0);"
		data-id="536">义乌</a></li>
	<li><span>L</span><a title="LaSa" href="javascript:void(0);"
		data-id="41">拉萨</a><a title="LanZhou" href="javascript:void(0);"
		data-id="100">兰州</a></li>
	<li><span>Z</span><a title="ZhuHai" href="javascript:void(0);"
		data-id="31">珠海</a><a title="ZhongShan" href="javascript:void(0);"
		data-id="553">中山</a><a title="ZhengZhou" href="javascript:void(0);"
		data-id="559">郑州</a></li>
</ul>
</div>


<div class="departures" id="divVacationStartCity"
	style="position: absolute; display: none;">
<h5>热门出发城市</h5>
<a title="Beijing" href="javascript:void(0);" data-id="1">北京</a><a
	title="Shanghai" href="javascript:void(0);" data-id="2">上海</a><a
	title="Tianjin" href="javascript:void(0);" data-id="3">天津</a><a
	title="Chongqing" href="javascript:void(0);" data-id="4">重庆</a><a
	title="Haerbin" href="javascript:void(0);" data-id="5">哈尔滨</a><a
	title="Dalian" href="javascript:void(0);" data-id="6">大连</a><a
	title="Qingdao" href="javascript:void(0);" data-id="7">青岛</a><a
	title="Xi'an" href="javascript:void(0);" data-id="10">西安</a><a
	title="Dunhuang" href="javascript:void(0);" data-id="11">敦煌</a><a
	title="Nanjing" href="javascript:void(0);" data-id="12">南京</a>
<ul class="departures_sequence">
	<li><span>B</span><a title="Beijing" href="javascript:void(0);"
		data-id="1">北京</a><a title="Baotou" href="javascript:void(0);"
		data-id="141">包头</a></li>
	<li><span>M</span><a title="Mianyang" href="javascript:void(0);"
		data-id="370">绵阳</a></li>
	<li><span>C</span><a title="Chongqing" href="javascript:void(0);"
		data-id="4">重庆</a><a title="Chengdu" href="javascript:void(0);"
		data-id="28">成都</a><a title="Changchun" href="javascript:void(0);"
		data-id="158">长春</a><a title="Changsha" href="javascript:void(0);"
		data-id="206">长沙</a><a title="Changzhou" href="javascript:void(0);"
		data-id="213">常州</a></li>
	<li><span>N</span><a title="Nanjing" href="javascript:void(0);"
		data-id="12">南京</a><a title="Nantong" href="javascript:void(0);"
		data-id="82">南通</a><a title="Ningbo" href="javascript:void(0);"
		data-id="375">宁波</a><a title="Nanchang" href="javascript:void(0);"
		data-id="376">南昌</a><a title="Nanning" href="javascript:void(0);"
		data-id="380">南宁</a></li>
	<li><span>D</span><a title="Dalian" href="javascript:void(0);"
		data-id="6">大连</a><a title="Dongguan" href="javascript:void(0);"
		data-id="223">东莞</a></li>
	<li><span>Q</span><a title="Qingdao" href="javascript:void(0);"
		data-id="7">青岛</a><a title="Quanzhou" href="javascript:void(0);"
		data-id="406">泉州</a></li>
	<li><span>F</span><a title="Foshan" href="javascript:void(0);"
		data-id="251">佛山</a><a title="Fuzhou" href="javascript:void(0);"
		data-id="258">福州</a></li>
	<li><span>S</span><a title="Shanghai" href="javascript:void(0);"
		data-id="2">上海</a><a title="Suzhou" href="javascript:void(0);"
		data-id="14">苏州</a><a title="Shenzhen" href="javascript:void(0);"
		data-id="30">深圳</a><a title="Sanya" href="javascript:void(0);"
		data-id="43">三亚</a><a title="Shijiazhuang" href="javascript:void(0);"
		data-id="428">石家庄</a><a title="Shantou" href="javascript:void(0);"
		data-id="447">汕头</a><a title="Shenyang" href="javascript:void(0);"
		data-id="451">沈阳</a></li>
	<li><span>G</span><a title="Guangzhou" href="javascript:void(0);"
		data-id="32">广州</a><a title="Guiyang" href="javascript:void(0);"
		data-id="38">贵阳</a></li>
	<li><span>T</span><a title="Tianjin" href="javascript:void(0);"
		data-id="3">天津</a><a title="Taiyuan" href="javascript:void(0);"
		data-id="105">太原</a><a title="Taizhou" href="javascript:void(0);"
		data-id="578">台州</a></li>
	<li><span>H</span><a title="Haerbin" href="javascript:void(0);"
		data-id="5">哈尔滨</a><a title="Hangzhou" href="javascript:void(0);"
		data-id="17">杭州</a><a title="Haikou" href="javascript:void(0);"
		data-id="42">海口</a><a title="Huhehaote" href="javascript:void(0);"
		data-id="103">呼和浩特</a><a title="Hailaer" href="javascript:void(0);"
		data-id="142">海拉尔</a><a title="Hefei" href="javascript:void(0);"
		data-id="278">合肥</a></li>
	<li><span>W</span><a title="Wuxi" href="javascript:void(0);"
		data-id="13">无锡</a><a title="Wulumuqi" href="javascript:void(0);"
		data-id="39">乌鲁木齐</a><a title="Wuhan" href="javascript:void(0);"
		data-id="477">武汉</a><a title="Weihai" href="javascript:void(0);"
		data-id="479">威海</a><a title="Wenzhou" href="javascript:void(0);"
		data-id="491">温州</a></li>
	<li><span>J</span><a title="Jinan" href="javascript:void(0);"
		data-id="144">济南</a><a title="Jiangmen" href="javascript:void(0);"
		data-id="316">江门</a></li>
	<li><span>X</span><a title="Xi'an" href="javascript:void(0);"
		data-id="10">西安</a><a title="Xiamen" href="javascript:void(0);"
		data-id="25">厦门</a><a title="Xining" href="javascript:void(0);"
		data-id="124">西宁</a><a title="Xichang" href="javascript:void(0);"
		data-id="494">西昌</a><a title="Xuzhou" href="javascript:void(0);"
		data-id="512">徐州</a></li>
	<li><span>K</span><a title="Kunming" href="javascript:void(0);"
		data-id="34">昆明</a><a title="Kashi" href="javascript:void(0);"
		data-id="109">喀什市</a></li>
	<li><span>Y</span><a title="Yinchuan" href="javascript:void(0);"
		data-id="99">银川</a><a title="Yuncheng" href="javascript:void(0);"
		data-id="140">运城</a><a title="Yanji" href="javascript:void(0);"
		data-id="523">延吉</a><a title="Yulin" href="javascript:void(0);"
		data-id="527">榆林</a><a title="Yantai" href="javascript:void(0);"
		data-id="533">烟台</a><a title="Yiwu" href="javascript:void(0);"
		data-id="536">义乌</a></li>
	<li><span>L</span><a title="Lijiang" href="javascript:void(0);"
		data-id="37">丽江</a><a title="Lasa" href="javascript:void(0);"
		data-id="41">拉萨</a><a title="Lanzhou" href="javascript:void(0);"
		data-id="100">兰州</a></li>
	<li><span>Z</span><a title="Zhuhai" href="javascript:void(0);"
		data-id="31">珠海</a><a title="Zhongshan" href="javascript:void(0);"
		data-id="553">中山</a><a title="Zhengzhou" href="javascript:void(0);"
		data-id="559">郑州</a></li>
</ul>
</div>
<div id="hotelNameChoice" class="choice" style="display: none;"></div>
<script src="js/LAB.js?20130116.js" charset="utf-8"
	type="text/javascript"></script>
<script type="text/javascript">
    //配置AddCookie域名
    var adCookieDomain = 'localhost';
</script>

<script type="text/javascript">
    var pkgStartCityHash = { "珠海": 31, "拉萨": 41, "海口": 42, "银川": 99, "喀什": 109, "西宁": 124, "运城": 140, "包头": 141, "海拉尔": 142, "常州": 213, "绵阳": 370, "泉州": 406, "三亚": 43, "石家庄": 428, "汕头": 447, "威海": 479, "西昌": 494, "徐州": 512, "延吉": 523, "榆林": 527, "烟台": 533, "义乌": 536, "台州": 578, "北京": 1, "上海": 2, "广州": 32, "深圳": 30, "杭州": 17, "成都": 28, "南京": 12, "青岛": 7, "厦门": 25, "武汉": 477, "沈阳": 451, "济南": 144, "宁波": 375, "无锡": 13, "温州": 491, "天津": 3, "重庆": 4, "西安": 10, "郑州": 559, "福州": 258, "昆明": 34, "长沙": 206, "大连": 6, "贵阳": 38, "乌鲁木齐": 39, "兰州": 100, "呼和浩特": 103, "太原": 105, "长春": 158, "合肥": 278, "南昌": 376, "南宁": 380, "哈尔滨": 5, 1: "北京", 2: "上海", 32: "广州", 30: "深圳", 17: "杭州", 28: "成都", 12: "南京", 7: "青岛", 25: "厦门", 477: "武汉", 451: "沈阳", 144: "济南", 375: "宁波", 13: "无锡", 491: "温州", 3: "天津", 4: "重庆", 10: "西安", 559: "郑州", 258: "福州", 34: "昆明", 206: "长沙", 6: "大连", 38: "贵阳", 39: "乌鲁木齐", 100: "兰州", 103: "呼和浩特", 105: "太原", 158: "长春", 278: "合肥", 376: "南昌", 380: "南宁", 5: "哈尔滨", 31: "珠海", 41: "拉萨", 42: "海口", 99: "银川", 109: "喀什", 124: "西宁", 140: "运城", 141: "包头", 142: "海拉尔", 213: "常州", 370: "绵阳", 406: "泉州", 43: "三亚", 428: "石家庄", 447: "汕头", 479: "威海", 494: "西昌", 512: "徐州", 523: "延吉", 527: "榆林", 533: "烟台", 536: "义乌", 578: "台州" };

    var g_adsconfig = "http://webresource.c-ctrip.com/ResCRMOnline/ahomepage/ahomectrip.js";

    var config = {
        today: '2013-09-24',
        tomorrow: '2013-09-25',
        oneyear_today: '2014-09-24',
        url: {
            hotelFlightAction: 'http://package.ctrip.com/',
            loginAjax: 'js/AjaxGetLoginCookie.ashx',
            vacationAjax: 'js/AjaxGetVacationsTabJSON.ashx',
            hotelAjax: 'js/AjaxGetHotelTabJSON.ashx',
            flightAjax: '/Tool/AjaxGetFlightTabJSON.ashx',
            popAjax: '/Tool/AjaxQuery.ashx',
            hotelAddressJsonp: '/Tool/AjaxSearchLandMark.ashx',
            hotelAddresSmt: 'http://hotels.ctrip.com',
            hotelNameJsonp: '/Tool/AjaxSearchHotelName.ashx?cityId={cityId}&keyword=${key}',
            citynameInterJsonp: '/Tool/HotelAjaxIndexCity.ashx?keyword=${key}',
            trainURL: 'vacations.ctrip.com',
            SMSUrl: '/Tool/AjaxSendSMS.ashx',
            ticketAction: 'http://vacations.ctrip.com/',
            inteHotelAction: 'http://hotels.ctrip.com',
            guessAjaxGet: 'js/AjaxGetUlike.ashx',
            guessAjaxDel: 'js/AjaxDelUlike.ashx'
        },
        tip: {
            chinaHotel: [
				'请选择酒店所在城市',
				'请输入入住时间',
				'退房日期需要大于入住日期',
				'入住时间不能早于{$today}',
				'请输入离店时间',
				'入住日期格式不正确',
				'退房日期格式不正确',
				'您入住酒店时间超过28天，请分订单提交预订'
			],
            inteHotel: [
				'入住日期格式不正确',
				'退房日期格式不正确',
				'请选择酒店所在城市',
				'请输入入住时间',
				'入住时间不能早于{$today}',
				'请输入离店时间',
				'退房日期需要大于入住日期',
				'您入住酒店时间超过28天，请分订单提交预订'
			],
            chinaFlight: [
				'出发日期格式不正确',
				'返回日期格式不正确',
				'请选择出发城市',
				'请选择到达城市',
				'出发城市不能和到达城市相同',
				'请选择您的出发日期',
				'请选择您的返回日期',
				'出发日期不能早于{$today}',
				'返回日期不能早于出发日期{$startDate}',
				'只能查询一年内航班'
			],
            inteFlight: [
				'出发日期格式不正确',
				'返回日期格式不正确',
				'请选择出发城市',
				'请选择目的城市',
				'你选择的出发城市没有前往$1的航班，请重新选择',
				'你选择的出发城市没有前往该目的城市的航班，请重新选择',
				'您选择的出发地点与目的地相同,请重新选择',
				'请选择您的出发日期',
				'请选择您的返回日期',
				'出发日期不能早于{$today}',
				'返回日期不能早于出发日期{$startDate}',
				'只能查询一年内航班'
			],
            vacation: [
				'请选择您的出发地',
				'请选择您的目的地'
			],
            flightHotel: [
				'出发日期格式不正确',
				'返回日期格式不正确',
				'只能预定一天以后的酒店和机票',
				'请填写出发城市',
				'请填写到达城市',
				'出发日期不能早于{$today}',
				'只能搜索一年内机票和酒店',
				'出发城市和目的城市不能相同',
				'请选择出发日期',
				'请选择返回日期',
				'返回日期必须晚于出发日期',
				'每间房最多可预订28晚，请填写1-28的数字',
				'一位成人最多可携带两名儿童乘机。请修改出行人数'
			],
            telphone: [
                 '手机号码不能为空',
                    '手机号码格式不正确'
            ],
            email: [
				'请输入Email地址',
				'请输入正确的Email地址',
				'不能重复订阅',
				'输入Email(如：a@b.c)'
			]
        },
        notice: [
			'中文/拼音',
			'中文/拼音',
			'中文/英文',
			'输入中文/拼音',
			'选填（位置关键字）',
            '中文/英文/拼音',
            '选填（中文/拼音）'
		],
        msg: {
            "hotelStartCity": "<strong>热门城市</strong>（可直接选择城市或输入城市全拼/简拼）",
            "addressTab": "省市",
            "hotelAddress": "可直接选择地理位置或输入位置关键词",
            "aMapTitle": "查看商业区地图",
            "subCity": "下辖市/县：",
            "all": "全部",
            "suggestion": "（热门城市）可直接输入城市或拼音",
            "pkgDestCity": "输入中文/拼音或在下列关键字中选择"
        },
        data: [
			["上海(虹桥)", "上海(浦东)", "北京(首都)", "北京(南苑)"]
		],
        posTitle: {
            "zone": "商业区",
            "location": "行政区",
            "metro": "地铁线"
        },
        TW: ["台北", "高雄", "垦丁", "台北县", "桃园县"]
    };


    $globalPad = true;
    $LAB
    
    .script({ src: "js/cQuery_110421.js", charset: "utf-8" }).wait(function () {
        //cQuery.config("modPath", "http://webresource.c-ctrip.com/ResCRMOnline/r3/js/index/");
        $.mod.load('sideBar', '2.0', function () {
            var sidebar = $(document).regMod('sideBar', '2.0', {
                url: {
                 //   feedBackURL: 'http://www.ctrip.com/QSYS/Online/OnlineQsysQurveyLogin.asp?SurveyID=519bcdac-927a-44d9-a7b8-7b1097ca5e00&Review=',
                   // liveChatURL: 'http://livechat.ctrip.com/livechat/Login3.aspx?GroupCode=CustomerService&AsFrom=1|CustomerService'
                },
                title: {
                    backTop: '回到顶端',
                    feedBack: '问卷调查',
                    liveChat: '在线客服'
                }
            });
        });
    })
    
    .padScript({ src: "js/pad.js", charset: "utf-8" }).wait()
    .script({ src: "js/index.min.js?ws_www20130805.js", charset: "utf-8" }).wait(logTimer)
    .script({ src: "js/adCookie.min.js?ws_www20130805.js", charset: "utf-8" }); 
	
</script>



<script type="text/javascript">
    var HD_HOTEL_CONFIG = {
        addressMessageConfig: {
            cityname: {
                suggestionB: '支持中文/拼音/简拼输入',
                suggestion: "<strong>热门城市</strong>（可直接选择城市或输入城市全拼/简拼）"
            },
            searchHistory: '搜索历史',
            addressTab: "省市",
            hotelPos: {
                suggestion: "可直接选择地理位置或输入位置关键词",
                titles: {
                    "zone": "商业区",
                    "location": "行政区",
                    "metro": "地铁线"
                },
                showAMap: false,
                AMapTitle: '查看商业区地图',
                all: '全部',
                subCity: '下辖市/县：'
            },
            suggestTitle: ["名称", "机场火车站", "位置"],
            defaultValue: ['上海', '2', 'shanghai']
        },
        validateMessageConfig: {
            hotel: {
                city: '请选择酒店所在城市',
                checkIn: '请选择入住日期',
                checkOut: '请选择离店日期',
                dateErr: '日期格式为yyyy-mm-dd',
                too_early_in: '入住日期不能早于今天',
                too_early_out: '您选择的离店日期早于/等于入住日期，请重新选择',
                too_long: '您入住酒店时间超过28天，请分订单提交预订',
                no_room: '您选择的日期没有房间可供预订!',
                room_num: '请选择预订房间数'
            }
        },
        noticeMessageConfig: ['中文/拼音']
    };



</script>
 
<script type="text/javascript">
    //广告加载
    (function () {
        var ads = document.createElement('script'); ads.type = 'text/javascript'; ads.async = true;
        ads.src = "js/AdCallProxy.aspx?re=ads&adlist=[{\"adIDs\":\"27-28-29-30-31-32\",\"domID\":\"allyesId\"},{\"adIDs\":\"33\",\"domID\":\"allyesId2\"},{\"adIDs\":\"34\",\"domID\":\"gg_pic1\"},{\"adIDs\":\"40\",\"domID\":\"gg_pic2\"},{\"adIDs\":\"41\",\"domID\":\"gg_pic3\"},{\"adIDs\":\"42\",\"domID\":\"gg_pic4\"},{\"adIDs\":\"43\",\"domID\":\"gg_pic5\"},{\"adIDs\":\"44\",\"domID\":\"gg_pic6\"}]&r=ws_www";
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ads, s);
    })();

    

    (function () {
      
        var nts = document.createElement('script'); nts.type = 'text/javascript'; nts.async = true;
        nts.src = "js/__nts.js?ws_www_20130808";
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(nts, s);
    })();

    (function (d) {
        window.bd_cpro_rtid = "PWTzPjD";
        var s = d.createElement("script"); s.type = "text/javascript"; s.async = true; s.src =  "js/rt.js";
        var s0 = d.getElementsByTagName("script")[0]; s0.parentNode.insertBefore(s, s0);
    })(document);
    
    

    
</script>
<script>
   function SeachTicket(){
  
   if(document.getElementById("FD_DCity1").value==""){//出发城市
     alert("出发城市不能为空");
    //$("#FD_StartCity").focus();
     document.getElementById("FD_StartCity").focus();
    return;
   }
   if(document.getElementById("FD_ACity1").value==""){//到达城市
   alert("到达城市不能为空");
    //$("#FD_DestCity").focus();
     document.getElementById("FD_DestCity").focus();
     return;
   }
   if(document.getElementById("FD_DCity1").value==document.getElementById("FD_ACity1").value){
   alert("出发城市不能和到达城市一样");
     //$("#FD_DestCity").focus();
     document.getElementById("FD_DestCity").focus();
     return;
   }
   //alert(document.getElementById("FD_StartDate").value);
   if(document.getElementById("FD_StartDate").value==""||document.getElementById("FD_StartDate").value=="yyyy-mm-dd"){//出发日期
    //$("#FD_StartDate").focus();
    alert("出发日期不能为空");
     document.getElementById("FD_StartDate").focus();
     return;
   }
   document.FD_ChinaFlightForm.action="ticticket!toTicketList.jspx";
   document.FD_ChinaFlightForm.method="POST";
   document.FD_ChinaFlightForm.submit();
   
   }
   
   function SeachInterTicket(){
  
   if(document.getElementById("FD_DCity1").value==""){//出发城市
     alert("出发城市不能为空");
    //$("#FD_StartCity").focus();
     document.getElementById("FD_StartCity").focus();
    return;
   }
   if(document.getElementById("FD_ACity1").value==""){//到达城市
   alert("到达城市不能为空");
    //$("#FD_DestCity").focus();
     document.getElementById("FD_DestCity").focus();
     return;
   }
   if(document.getElementById("FD_DCity1").value==document.getElementById("FD_ACity1").value){
   alert("出发城市不能和到达城市一样");
     //$("#FD_DestCity").focus();
     document.getElementById("FD_DestCity").focus();
     return;
   }
   //alert(document.getElementById("FD_StartDate").value);
   if(document.getElementById("FD_StartDate").value==""||document.getElementById("FD_StartDate").value=="yyyy-mm-dd"){//出发日期
    //$("#FD_StartDate").focus();
    alert("出发日期不能为空");
     document.getElementById("FD_StartDate").focus();
     return;
   }
   document.FD_ChinaFlightForm.action="international!toInterNationalList.jspx";
   document.FD_ChinaFlightForm.method="POST";
   document.FD_ChinaFlightForm.submit();
   
   }
   
  function SeachSpotticket(){
  if(document.getElementById("city_hotel_hide").value==""){//到达城市
   alert("目的城市不能为空");
    //$("#FD_DestCity").focus();
     document.getElementById("txthotelcity").focus();
     return;
   }
   
   document.ticketTab.action="spotticket!SeachSpotbyIndex.jspx";
   document.ticketTab.method="POST";
   document.charset = 'UTF-8';
   document.ticketTab.submit();
  
  }
  function SeachSpotline(){
  alert("SeachSpotline");
  if(document.getElementById("city_spotline_hide").value==""){//出发城市
   alert("出发城市不能为空");
  
     document.getElementById("txtspotlinecity").focus();
     return;
   }
 //  if(document.getElementById("city_spotline_hide2").value!=""&&document.getElementById("city_spotline_hide").value==document.getElementById("city_spotline_hide2").value){
  // alert("出发城市和到达城市不能一样");
  // }
   
   document.vacationTab.action="spotline!SeachSpotline.jspx";
   document.vacationTab.method="POST";
   document.charset = 'UTF-8';
   document.vacationTab.submit();
  
  }
  
   
</script>
<!-- 门票用 -->
 
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2_index.js"></script>
<!-- 旅游用 -->
<script language="javascript" type="text/javascript" src="js/spotline/city_date2.js"></script>

<script type="text/javascript">
var varAddress="";
$(document).ready(function(){
   loadCityData();
   loadCityData2();
   selecthotel(1,607);
   selectspotticket(1,383);
});

function loadCityData()
{

 $.ajax({
       type:"POST",
       url:"spotticket!GetSpotCity.jspx",
       async:false,     
       success:function(data)
       {    
         varAddress=data;
       }            
  });
 // alert(varAddress);
}
</script>

<script type="text/javascript">
var varAddress2="";
function loadCityData2()
{

 jQuery.ajax({
       type:"POST",
       url:"spotticket!GetSpotCity.jspx",
       async:false,     
       success:function(data)
       {    
         varAddress2=data;
       }            
  });
 // alert(varAddress);
}
//酒店用
function selecthotel(index,cityid){
for(i=1;i<=12;i++){
document.getElementById("hotel_a_"+i).className=""; 
}
 document.getElementById("hotel_a_"+index).className="current"; 


  jQuery.post("index!GetIndexHotelByIndex.jspx",{strHotelIndex:index,strCityID:cityid,para:Math.floor(Math.random()*100)},
  function(data){$("#divHotelHtml").html(data);}); 
  
  
  	//$.ajax({
    //  type:"POST",
   //   async : false,
   //   cache:false,
   //    url:"index!GetIndexHotelByIndex.jspx",
   //   data:{strHotelIndex:index,strCityID:cityid,parastr:Math.floor(Math.random()*100)},
   //   beforeSend:function(){$("#divHotelHtml").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐酒店信息...");},             
   //   success:function(data){
    //  $("#divHotelHtml").html(data);           
   //   }}); 
}
//门票用
function  selectspotticket(index,cityid){

for(i=1;i<=7;i++){
	 document.getElementById("spot_a_"+i).className=""; 
}
  document.getElementById("spot_a_"+index).className="current"; 
   jQuery.post("index!GetSpotTicketByIndex.jspx",{strHotelIndex:index,strCityID:cityid,para:Math.floor(Math.random()*100)},
   function(data){
  
 $("#divSpotticketHtml").html(data);  
  });     
 //return;
	
 	// $.ajax({
     //  type:"GET",
      // cache:false,
      // url:"index!GetSpotTicketByIndex.jspx",
      //data:{strHotelIndex:index,strCityID:cityid,para:Math.floor(Math.random()*100)},
     // beforeSend:function(){$("#divSpotticketHtml").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐门票信息...");},             
     // success:function(data){
     // $("#divSpotticketHtml").html(data);           
    //  }            
      //}); 
}

function ChangType(ind){
for(i=1;i<=5;i++){
	 document.getElementById("tab_"+i).className=""; 
}
  document.getElementById("tab_"+ind).className="current"; 
}
function ChangGongYue(ind){

for(i=1;i<=3;i++){
	  $("#gongyue"+i).hide();  
}
   $("#gongyue"+ind).show();  
}

function CheckTab(index,str){
for(i=1;i<=6;i++){
	 document.getElementById("Tab_"+i).className="s_tab_nocurrent"; 
	  $("#Div_Tab_"+i).hide();  
}
    document.getElementById("Tab_"+index).className="s_tab_current"; 
      $("#Div_Tab_"+index).show();  
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
</body>
</html>
