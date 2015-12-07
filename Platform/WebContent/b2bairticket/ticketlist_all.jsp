<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>航班列表-国内</title>
<link href="b2bairticket/css/left.css" type="text/css" rel="stylesheet">
<link href="b2bairticket/css/public(2).css" type="text/css" rel="stylesheet">
<link href="b2bairticket/css/main.css" type="text/css" rel="stylesheet">

<script src="js/jquery-1.4.2.min.js" type=text/javascript></script>
<script type=text/javascript src="b2bairticket/js/ticket/list.js"></script>


<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type=text/javascript src="b2bairticket/js/ticket/list.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<!-- cityjs -->
<script type="text/javascript" src="main_cx/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="main_cx/js/lhgdialog.js"></script>
<script type="text/javascript" src="main_cx/js/layout.js"></script>
<script type="text/javascript" src="main_cx/js/city.js"></script>
<script type="text/javascript" src="main_cx/js/popdg_div.js"></script>
<script type="text/javascript" language="javascript" src="main_cx/js/jquery.blockUI.js"></script>
<script type="text/javascript" language="javascript" src="main_cx/js/publicjs.js"></script>
<link href="main_cx/css/autocomplete.css" rel="stylesheet" type="text/css">



<style type="text/css">
.none {
	display: none
}

.pointer {
	cursor: pointer
}

.wenzi {
	background: #f0f0f0;
	height: 28px;
	margin: 1px 0 0 1px;
	width: 100%;
}

.ranyou {
	background: #f1f1f1;
	line-height: 24px;
	height: 24px;
	color: #666;
}
</style>
<link href="b2bairticket/css/public.css" rel="stylesheet">
<link href="b2bairticket/css/pub.css" rel="stylesheet">
<link href="b2bairticket/css/WdatePicker.css" rel="stylesheet"
	type="text/css">
	
	
	

<link rel="stylesheet" rev="stylesheet" href="b2bairticket/listcss/cn_list201312.css" type="text/css"
	media="all" />
<script type="text/javascript" src="b2bairticket/listcss/oneway.js?t=201403251354"></script>
</head>
<body id="mainbody">

<div id="right"
	style="margin-right: 12px; font-family: &amp; #39; 微软雅黑 &amp;#39 height : 100%; position: relative; width: 100%">
<div class="list_top"
	style="height: 36px; line-height: 36px; font-size: 14px; color: #000; background: #ecf0f1; border-top: 1px solid #dddddd; margin: 0 1px 0 1px; background-position: 0 0; padding: 0 15px 0 15px;">
<ul>
	<li style="float: left;">航班列表</li>
	<li style="float: right" class="mr11">友情提示：由于航空公司折扣及价格经常变动，预订价格按照PAT为准</li>
</ul>
</div>
<div class="c"></div>
<div
	style="background: #fff; padding-left: 15px; padding-top: 10px; padding-right: 15px;">
<div class="information">
<form action="b2bairticket!toTicketList.action" name="form3" id="form3"
	method="POST" onsubmit="return CheckData()"><input type="hidden"
	name="ordermodel" value="1"> <input type="hidden" name="pid"
	value="0"> <input type="hidden" name="ordercomid" value="0">
	
	<input type="hidden" name="s_seachtype" value="<ww:property value="s_seachtype" />">
	
<table width="100%" border="1" cellspacing="0" cellpadding="0">
	<tbody>
		<tr class="font-blue-xi" style="display: none;" id="tr_diyicheng">
			<td colspan="4"><b>请选择第一程</b></td>
		</tr>
		<tr class="font-blue-xi">
			<td width="120" height="28" align="right" style="padding: 0">
			<div class="wenzi"><label for="arrcity"> 出发城市：</label></div>
			</td>
			<td width="260" align="left"><input id="arrcity" type="text"
				title="请输入出发城市" autocomplete="off" value="<ww:property value="s_depcityname" />"
				onkeydown="popup_hide();suggest.display(&#39;arrcity&#39;,&#39;city_from_hide&#39;,event);"
				onblur="showSearch(&#39;arrcity&#39;,&#39;city_from_hide&#39;);"
				onfocus="popUp(&#39;arrcity&#39;,&#39;city_from_hide&#39;)"
				onclick="popUp(&#39;arrcity&#39;,&#39;city_from_hide&#39;)"
				name="s_depcityname"
				style="border: 1px solid #999999; height: 20px; line-height: 20px; color: #c">&nbsp;<span
				style="color: red">*</span>
			<div id="suggest" class="ac_results"></div>
			<input type="hidden" id="city_from_hide" value="<ww:property value="s_depcitycode" />"
				name="s_depcitycode"></td>
			<td width="120" height="28" align="right" style="padding: 0">
			<div class="wenzi"><label for="city2"> 目的城市：</label></div>
			</td>
			<td width="260" align="left"><input id="tocity" type="text"
				title="请输入目的城市" autocomplete="off" value="<ww:property value="s_arrcityname" />"
				onkeydown="popup_hide();suggest.display(&#39;tocity&#39;,&#39;city_to_hide&#39;,event);"
				onblur="showSearch(&#39;tocity&#39;,&#39;city_to_hide&#39;);"
				onfocus="popUp(&#39;tocity&#39;,&#39;city_to_hide&#39;)"
				onclick="popUp(&#39;tocity&#39;,&#39;city_to_hide&#39;)"
				style="COLOR: #c1c1c1" name="s_arrcityname">&nbsp;<span
				style="color: red">*</span>
			<div id="suggest2" class="ac_results"></div>
			<input type="hidden" id="city_to_hide" value="<ww:property value="s_arrcitycode" />"
				name="s_arrcitycode"></td>
			<td width="120" align="left"><input type="button" onclick="seachAir();"
				class="button_sea f" value="立即查询"></td>
		</tr>
		<tr class="font-blue-xi">
			<td height="28" align="right" style="padding: 0">
			<div class="wenzi">出发日期：</div>
			</td>
			<td align="left"><input id="txtStartDate" style="width: 150px"
				title="请输入出发日期" name="s_startdate" value="<ww:property value="s_startdate" />"
				onfocus="WdatePicker({doubleCalendar:true,isShowClear:false,readOnly:true,minDate:&#39;%y-%M-%d&#39;,maxDate:&#39;#F{$dp.$D(\&#39;txtBackDate\&#39;,{d:0})}&#39;,dateFmt:&#39;yyyy-MM-dd&#39;})"
				class="Wdate">&nbsp;<span style="color: red">*</span></td>
			<td height="28" align="right" style="padding: 0">
			<div class="wenzi"><span style="display: none;"
				id="lblBackDate">返程日期：</span></div>
			</td>
			<td align="left" colspan="2">
			<div id="divBackDate" style="display: none;"><input
				title="请输入返程日期" id="txtBackDate" style="width: 150px"
				name="s_backdate" value="<ww:property value="s_backdate" />"
				onfocus="WdatePicker({doubleCalendar:true,isShowClear:false,readOnly:true,minDate:&#39;%y-%M-%d&#39;,minDate:&#39;#F{$dp.$D(\&#39;txtStartDate\&#39;,{d:0})}&#39;,dateFmt:&#39;yyyy-MM-dd&#39;})"
				class="Wdate">&nbsp;<span style="color: red">*</span></div>
			</td>
		</tr>
		<tr class="font-blue-xi" style="display: none;" id="tr_diercheng">
			<td colspan="4"><b>请选择第二程</b></td>
		</tr>
		<tr class="font-blue-xi" style="display: none;" id="tr_dierchenginfo">
			<td width="120" height="28" align="right" style="padding: 0">
			<div class="wenzi"><label for="arrcity-lc"> 出发城市：</label></div>
			</td>
			<td width="260" align="left"><input id="arrcity-lc" type="text"
				value="北京" name="s_depcityname_lc" title="请输入第二程出发城市"
				style="border: 1px solid #999999; height: 20px; line-height: 20px;"
				onkeydown="popup_hide();suggest.display(&#39;arrcity-lc&#39;,&#39;city_from_hide_lc&#39;,event);"
				onblur="showSearch(id,1); if(this.value==&#39;&#39;) {this.value=&#39;北京&#39;;};"
				onfocus="if(this.value=&#39;北京&#39;){this.value=&#39;&#39;;}popUp(&#39;arrcity-lc&#39;,&#39;city_from_hide_lc&#39;)"
				onclick="popUp(&#39;arrcity-lc&#39;,&#39;city_from_hide_lc&#39;)">&nbsp;<span
				style="color: red">*</span>
			<div id="suggest-lc" class="ac_results"></div>
			<input type="hidden" id="city_from_hide_lc" value="PEK"
				name="s_depcitycode_lc"></td>
			<td width="120" height="28" align="right" style="padding: 0">
			<div class="wenzi"><label for="city2-lc"> 目的城市：</label></div>
			</td>
			<td align="left" colspan="2"><input id="tocity-lc"
				title="请输入第二程目的城市" type="text" value=""
				onkeydown="popup_hide();suggest.display(&#39;tocity-lc&#39;,&#39;city_to_hide_lc&#39;,event);"
				onblur="showSearch(id,1); if(this.value==&#39;&#39;) {this.value=&#39;北京&#39;;};"
				onfocus="if(this.value=&#39;北京&#39;){this.value=&#39;&#39;;}popUp(&#39;tocity-lc&#39;,&#39;city_to_hide_lc&#39;)"
				onclick="popUp(&#39;tocity-lc&#39;,&#39;city_to_hide_lc&#39;)"
				style="COLOR: #c1c1c1; border: 1px solid #999999; height: 20px; line-height: 20px;"
				name="s_arrcityname_lc">&nbsp;<span style="color: red">*</span>
			<div id="suggest2-lc" class="ac_results"></div>
			<input type="hidden" id="city_to_hide_lc" value=""
				name="s_arrcitycode_lc"></td>
		</tr>
		<tr class="font-blue-xi" style="display: none;"
			id="tr_dierchenginfo_date">
			<td height="28" align="right" style="padding: 0">
			<div class="wenzi">出发日期：</div>
			</td>
			<td align="left"><input id="txtStartDate-lc" value=""
				style="width: 150px" title="请输入第二程出发日期" name="s_startdate_lc"
				onfocus="WdatePicker({doubleCalendar:true,isShowClear:false,readOnly:true,minDate:&#39;%y-%M-%d&#39;,minDate:&#39;#F{$dp.$D(\&#39;txtStartDate\&#39;,{d:0})}&#39;,dateFmt:&#39;yyyy-MM-dd&#39;})"
				class="Wdate">&nbsp;<span style="color: red">*</span></td>
			<td height="28" align="right" style="padding: 0" colspan="3"></td>
		</tr>
		<tr class="font-blue-xi" style="display: none;"
			id="tr_diercheng_kongbaihang">
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr class="font-blue-xi">
			<td height="28" align="right" style="padding: 0">
			<div class="wenzi">航空公司：</div>
			</td>
			<td><select id="ddlAirCom" name="s_aircompanycode"
				style="width: 154px; border: 1px solid #999999">
				<option value="">---所有航空公司---</option>
				<option value="3U">3U 四川航空公司</option>
				<option value="CA">CA 中国国际航空公司</option>
				<option value="CZ">CZ 中国南方航空公司</option>
				<option value="MU">MU 中国东方航空公司</option>
				<option value="FM">FM 上海航空公司</option>
				<option value="HU">HU 海南航空股份有限公司</option>
				<option value="MF">MF 厦门航空公司</option>
				<option value="SC">SC 山东航空公司</option>
				<option value="ZH">ZH 深圳航空公司</option>
				<option value="GS">GS 天津航空公司</option>
				<option value="HO">HO 上海吉祥航空公司</option>
				<option value="KN">KN 中国联合航空公司</option>
				<option value="BK">BK 奥凯航空公司</option>
				<option value="EU">EU 成都航空公司</option>
				<option value="JD">JD 中国海航金鹿航空公司</option>
				<option value="JR">JR 幸福航空公司</option>
				<option value="8C">8C 武汉东星航空公司</option>
				<option value="G5">G5 中国华夏航空公司</option>
				<option value="CN">CN 中国海航大新华航空公司</option>
				<option value="NS">NS 河北航空公司</option>
				<option value="VD">VD 中国深航鲲鹏航空公司</option>
				<option value="8L">8L 祥鹏航空</option>
				<option value="KY">KY 昆明航空公司</option>
				<option value="TV">TV 西藏航空有限公司</option>
				<option value="9C">9C 春秋航空</option>
				<option value="OQ">OQ 重庆航空</option>
				<option value="PN">PN 西部航空</option>
			</select></td>
			<td height="28" align="right" style="padding: 0">
			<div class="wenzi">航程类型：</div>
			</td>
			<td align="left" colspan="2"><input <ww:if test="s_traveltype==1">checked</ww:if>
				id="rdoSingle" name="s_traveltype" type="radio" value="1"
				onclick="showBackDate();">单程&nbsp; <input id="rdoBack" <ww:if test="s_traveltype==2">checked</ww:if>
				name="s_traveltype" type="radio" value="2" disabled="disabled" onclick="showBackDate();">
			往返 </td>
		</tr>
	</tbody>
</table>
</form>
</div>
<div class="numer" >
<table width="160%" border="1" cellspacing="0" cellpadding="0">
	<tbody>
		<tr id="quickSelectDate" >

			<td class="numertd" width="34"><a><img
				src="b2bairticket/img/jtkd_l.gif" width="34" height="48"></a></td>
				
				<ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
						<ww:param name="'first'" value="1" />
						<ww:param name="'last'" value="7" />
						</ww:bean> 
			<ww:iterator value="#counter" status="state">	
				<!-- numertdon numertd-->
			<td <ww:if test="s_startdate==GetDate(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)))">class="numertdon"</ww:if><ww:else>class="numertd"</ww:else>><a src="javascript:void(0)"
				onclick="SearchOtherDay_('<ww:property value="GetDate(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)))" />');"
				style="text-decoration: none">
			<dd><b> <ww:property value="GetDate(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)))" />&nbsp; <ww:property value="getWeekStr(GetDate(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate))))" /></b></dd>
			<dl class="none">
				￥0
			</dl>
			</a></td>
			</ww:iterator>
			
		
			<td class="numertd" width="34"><a><img
				src="b2bairticket/img/jtkd_r.gif" width="34" height="48"></a></td>



		</tr>
	</tbody>
</table>

</div>
<!-- 已选择航班 -->
<ww:iterator value="listsegmentinfo" status="index">
<div style="border: 3px solid #89b2eb; margin-top: 15px; color: #000000; width: 100%;" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height: 18px; margin: 10px 0 10px 0">
						<tbody><tr>
							<td><font class="f48000"><ww:property value="formatTimestampHHmm(departtime)" /></font>&nbsp;<font class="font666"><ww:property value="getAirCityNamebySZM(startairport)" /><ww:property value="borderpointat" /></font></td>
							<td><img src="images/airComlogo/<ww:property value="aircomapnycode" />.gif" width="18" height="18"> <ww:property value="airname" /> <ww:property value="flightnumber" /></td>
							<td><ww:property value="GetCabinType(discount,true,cabincode)" />[<ww:property value="cabincode" />/ <ww:property value="discount/10" />折]
							</td>
							<td rowspan="2"><font class="ff0000">¥<ww:property value="formatMoneyToInt(parvalue)" /></font>元</td>
							<td rowspan="2" width="52">&nbsp;</td>
							<td rowspan="2"><font class="f48000">5.3%</font>（30.0元）</td>
							<td rowspan="2"><font class="ff0000">¥<ww:property value="formatMoneyToInt(airportfee+fuelfee+parvalue)" /></font>元</td>
							<td rowspan="2" width="120"><a href="b2bairticket!toTicket.action" target="member"><img src="b2bairticket/img/chongxuan.gif" width="55" height="27" style="margin-left: 30px;"></a>
								<dl>
									<img src="b2bairticket/img/quico.gif" width="15" height="18" align="absmiddle"> &nbsp;&nbsp;
									<font color="#ff6600">去程航班已选择</font>
								</dl></td>
						</tr>
						<tr>
							<td><font class="f48000"><ww:property value="formatTimestampHHmm(arrivaltime)" /></font>&nbsp;<font class="font666"><ww:property value="getAirCityNamebySZM(endairport)" /> <ww:property value="offpointat" /></font></td>
							<td style="padding-left: 23px;"><font class="font666">机型:<ww:property value="flightmodel" /></font></td>
							<td></td>

						</tr>
					</tbody></table>
</div>
</ww:iterator>

<!-- 已选择航班 -->
<form name="form2" id="form2" method="post">
<div class="muese" >
<ul>
	<li><ww:if test="s_traveltype==1">单程</ww:if><ww:else>往返</ww:else></li>
	<li><ww:property value="s_depcityname" />→<ww:property value="s_arrcityname" /> &nbsp;</li>
	<li>出发时间：<span id="startdate"><ww:property value="s_startdate" /></span>&nbsp;&nbsp;
	&nbsp;&nbsp;</li>
	<li class="xf48000">（共<ww:property value="listFlightInfoAll.size()" />个航班）</li>
	<li class="times pointer" onclick="sortflightlist('timedesc');">时间</li>
	<li class="timesg pointer" onclick="sortflightlist('pricedesc');">价格</li>
	<li class="xianshi pointer"
		onclick="toggle_show('lishowZrateSelect')">显示设置</li>
	<li style="position: relative" id="lishowZrateSelect" class="none">
	<div class="xianshinr" style="left: -103px; top: 24px;">
	<dl>
		<a href="javascript:void(0)" onclick="showzrate1(0,'lishowZrateSelect')">显示</a>
	</dl>
	<dl>
		<a href="javascript:void(0)" onclick="showzrate1(1,'lishowZrateSelect')">不显示</a>
	</dl>
	</div>
	</li>
	
</ul>
</div>
<div class="muese" style="display: none;">
<div id="fsortbox" method="OrderField">
<div class="clx">
<dl class="clx">
	<dt>起飞时间：</dt>
	<dd class="all on" method="allTime">不限</dd>
	<dd><input method="time" type="checkbox" id="time1" value="1"><label
		for="time1">上午(6-12点)</label></dd>
	<dd><input method="time" type="checkbox" id="time2" value="2"><label
		for="time2">下午(12-18点)</label></dd>
	<dd><input method="time" type="checkbox" id="time3" value="3"><label
		for="time3">晚上(18-24点)</label></dd>
</dl>
</div>
<div class="clx">
<dl class="clx airlines">
	<dt>航空公司：</dt>
	<dd class="all on" id="allAircorp" method="allAircorp">不限</dd>
	<ww:iterator value="listAirCompany">
		<dd><input type="checkbox" method="aircorp"
			id="corp<ww:property value='aircomcode' />"
			value="<ww:property value='aircomcode' />"><label
			for="corp<ww:property value="aircomcode" />"><ww:property
			value="aircomjname" /></label></dd>
	</ww:iterator>
	
</dl>
</div>
</div>

</div>
<div class="c"></div>
<div style="width: 100%; border: 1px solid #ccc; margin-top: 10px; color: #000" id="flightlist">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="line-height: 18px;">

</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="line-height: 18px;" id="div_flightlist">
	<tbody>
		<tr class="bagrd">
			<td width="16%" height="30">出发/到达</td>
			<td width="10%">航空公司/机型</td>
			<td width="10%">舱位/折扣</td>
			<td width="8%">票面价<img
				onclick="sortflightlist(&#39;pricedesc&#39;)"
				src="b2bairticket/img/shangxia.gif"><span id="sortprice"
				class="none">0</span></td>
			<td width="8%">总票价<img
				onclick="sortflightlist(&#39;pricedesc&#39;)"
				src="b2bairticket/img/shangxia.gif"><span id="sortprice"
				class="none">0</span></td>
			<td width="4%">&nbsp;</td>
			<td width="10%" class="zratecss">返点<img
				onclick="sortflightlist(&#39;zratedesc&#39;)"
				src="b2bairticket/img/shangxia.gif"><span id="sortzrate"
				class="none">0</span></td>
			<td width="10%" class="zratecss">结算价</td>
			<td width="8%">&nbsp;</td>
		</tr>


	</tbody>
	<ww:iterator value="listFlightInfoAll" status="state">
	<div class="" id="ALLCabin_LowCabin_<ww:property value="#state.index" />"
			price="<ww:property value="LowCarbin.price" />"
			flighttime="635325609000000000"
			flightno="<ww:property value="Airline" />" method="divBox" itemid="1"
			aircorp="<ww:property value="AirCompany" />"
			depart="<ww:property value="StartAirport" />"
			arrive="<ww:property value="EndAirport" />"
			time="<ww:if test="formatTimestampHH(DepartTime)>=06&&formatTimestampHH(DepartTime)<12">1</ww:if><ww:if test="formatTimestampHH(DepartTime)>=12&&formatTimestampHH(DepartTime)<18">2</ww:if><ww:if test="formatTimestampHH(DepartTime)>=18&&formatTimestampHH(DepartTime)<24">3</ww:if>">
	
	<!-- 隐藏域 -->
		<input type="hidden"
			id='hid_lowprice_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.price" />' />
			
		<input type="hidden"
			id='hid_lowfandian_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.ratevalue" />' />
			
			
		<input type="hidden"
			id='hid_lowdiscount_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.Discount" />' />
		<input type="hidden"
			id='hid_lowyprice_<ww:property value="#state.index" />'
			value='<ww:property value="YPrice" />' />
		<input type="hidden"
			id='hid_lowseatnum_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.SeatNum" />' />
		<input type="hidden"
			id='hid_lowcabincode_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.Cabin" />' />
		<input type="hidden"
			id='hid_lowdeparttime_<ww:property value="#state.index" />'
			value='<ww:property value="formatTimestamp(DepartTime)" />' />
		<input type="hidden"
			id='hid_lowstartairportname_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirportName" />' />
		<input type="hidden"
			id='hid_lowstartairport_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirport" />' />
		<input type="hidden"
			id='hid_lowarrivetime_<ww:property value="#state.index" />'
			value='<ww:property value="formatTimestamp(ArriveTime)" />' />
		<input type="hidden"
			id='hid_lowendairportname_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirportName" />' />
		<input type="hidden"
			id='hid_lowendairport_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirport" />' />
		<input type="hidden"
			id='hid_lowflightnumber_<ww:property value="#state.index" />'
			value='<ww:property value="Airline" />' />
		<input type="hidden"
			id='hid_lowaircompany_<ww:property value="#state.index" />'
			value='<ww:property value="AirCompany" />' />
		<input type="hidden"
			id='hid_lowaircompanyname_<ww:property value="#state.index" />'
			value='<ww:property value="getAirCompanyNameByCode(AirCompanyName)" />' />
		<input type="hidden"
			id='hid_lowflighttype_<ww:property value="#state.index" />'
			value='<ww:property value="AirplaneType" />' />
		<input type="hidden"
			id='hid_lowflightdesc_<ww:property value="#state.index" />'
			value='<ww:property value="AirplaneTypeDesc" />' />
		<input type="hidden"
			id='hid_lowairportfee_<ww:property value="#state.index" />'
			value='<ww:property value="AirportFee" />' />
		<input type="hidden"
			id='hid_lowfuelfee_<ww:property value="#state.index" />'
			value='<ww:property value="FuelFee" />' />
		<input type="hidden"
			id='hid_lowrules_<ww:property value="#state.index" />'
			value='<ww:property value="rules" />' />

		<!-- 新增加航站楼 -->
		<input type="hidden"
			id='hid_borderpointat_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirportHZL"/>' />
		<input type="hidden"
			id='hid_offpointat_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirportHZL"/>' />
		<!-- 新增加政策信息 -->
		<input type="hidden"
			id='hid_zrateid_<ww:property value="#state.index" />' value='0' />
		<input type="hidden"
			id='hid_zratevalue_<ww:property value="#state.index" />' value='<ww:property value="LowCarbin.ratevalue"/>' />

		<!-- 新增加强制保险信息 -->
		<input type="hidden"
				id='hid_qiangzhibaoxian_<ww:property value="#state.index" />'
				value='0' />
				
		
		
			<tr>
				<td colspan="10" style="height: 8px; line-height: 8px;">&nbsp;</td>
			</tr>
			<tr>
				<td><font class="timeOfColnum f48000"><ww:property value="formatTimestampHHmm(DepartTime)" /></font> 
				<span class="none" id="hid_departTime_<ww:property value="#state.index" />"><ww:property value="DepartTime" /></span>&nbsp;
				 <font class="font666"> <span id="startairportname_<ww:property value="#state.index" />" ><ww:property value="StartAirportName" /></span>
				  <span class="none" id="hiddepcitycode_<ww:property value="#state.index" />"><ww:property value="StartAirport" /></span>
				(<span id="hid_offpointat_<ww:property value="#state.index" />"><ww:property
					value="StartAirportHZL" /></span>) </font></td>
				<td><img
					src="images/airComlogo/<ww:property value="AirCompany" />.gif"
					width="18" height="18"> <span id="airCompanyName_111"><ww:property value="getAirCompanyNameByCode(AirCompany)" /></span>
				<span class="none" id="hid_lowaircompany_111"><ww:property value="AirCompany" /></span> <span
					id="hid_lowflightnumber_111"><ww:property value="Airline" /></span> <input type="hidden"
					id="hid_YPrice_111" value="1810.0"> <input type="hidden"
					id="hid_lowflightdesc_111" value="空中客车A330-300载客256-412人左右#333.jpg">
				<input type="hidden"
					id="hid_lowflighttype_<ww:property value="#state.index" />"
					value="333"></td>
				<td><span id="hid_cabintypename_111">
				<ww:if test="AirCompany=='9C'">
				经济舱
				</ww:if><ww:else>
				<ww:property value="GetCabinType(LowCarbin.Discount,LowCarbin.Special,LowCarbin.cabin)" />
				</ww:else>
				
				</span>[<span
					><ww:property value="LowCarbin.cabin" /></span>/<span id="hid_discount_111"><ww:property value="LowCarbin.Discount/10" /></span>折]</td>
				<td rowspan="2"><font class="ff0000">¥<span
					class="priceOfColnum" id="hid_lowparvalue_<ww:property value="#state.index" />"><ww:property value="LowCarbin.price" /></span></font>元</td><!-- 总票面价 -->
				<td rowspan="2"><font class="ff0000">¥<span
					class="priceOfColnum" id="hid_lowparvalue_111"><ww:property value="LowCarbin.price+AirportFee+FuelFee" /></span></font>元</td><!-- 总票结算面价 -->
				<td rowspan="2" class="zratecss" width="52" ><img id="td_isspecial_<ww:property value="#state.index"/>" style="display: none;"
					src="b2bairticket/img/teshu.gif" width="52" height="21"><input
					type="hidden" id="hid_lowisspecial_111" value="2"></td>
				<td rowspan="2" class="zratecss"><font class="f48000"><span
					class="zrateOfColnum" id="low_fandian_<ww:property value="#state.index"/>">0</span>%</font>(<font
					class="f48000" id="low_youhui_<ww:property value="#state.index"/>">0</font>元)</td>
				<td rowspan="2" class="zratecss"><font class="ff0000">¥<span
					id="low_zrateprice_<ww:property value="#state.index"/>"><ww:property value="LowCarbin.price+AirportFee+FuelFee" /></span></font>元</td>
				<td rowspan="2" width="120">
				
				
				<ww:if test="AirCompany=='9C'">
				
				<img
					onclick="tocreatorder9c(<ww:property value="#state.index" />,<ww:property value="s_traveltype" />);return false;"
					src="b2bairticket/img/input_yds.gif" width="55" height="20"
					id="bookimage_<ww:property value="#state.index" />" style="margin-left: 30px; display: inline;"
					class="pointer none">
				</ww:if><ww:else>
				<img
					onclick="tocreatorder(<ww:property value="#state.index" />,<ww:property value="s_traveltype" />);return false;"
					src="b2bairticket/img/input_yds.gif" width="55" height="20"
					id="bookimage_<ww:property value="#state.index" />" style="margin-left: 30px; display: inline;"
					class="pointer none">
				</ww:else>	
					
					
				<dl style="margin-left: 32px;">
					<a id="linkshowcabin_<ww:property value="#state.index" />"
						onclick="showallcabin(<ww:property value="#state.index" />);return false;"
						href="javascript:void(0)">所有舱位▼</a>
				</dl>
				</td>
			</tr>

			<tr>
				<td><font class="f48000"><ww:property
					value="formatTimestampHHmm(ArriveTime)" /></font> <span class="none"
					id="hid_arrivalTime_111"><ww:property value="ArriveTime" /></span>&nbsp; <font
					class="font666"> <span id="endairportname_111"><ww:property
					value="EndAirportName" /></span> <span class="none" id="hidarrcitycode_0"><ww:property value="EndAirport" /></span>
				(<span id="hid_borderpointat_"><ww:property
					value="EndAirportHZL" /></span>) </font></td>
				<td style="padding-left: 23px;"><font class="font666">机型:<ww:property value="AirplaneType" /></font>
				<ww:if test='!isStopInfo.equals("0")'>
				<font onmouseout="hidestopinfo('stopinfodiv_<ww:property value="#state.index" />');" ><a style="color: #008e35; margin-left: 10px; text-decoration: underline" href="javascript:void(0)"  onclick="showstopinfo('<ww:property value="Airline" />','<ww:property value="formatTimestampyyyyMMddHHmm(DepartTime)" />','<ww:property value="isStopInfo" />','<ww:property value="#state.index" />');">[经停]</a>
				
											<div id="stopinfodiv_<ww:property value="#state.index" />" class="box none" style="position: absolute; display: none;">
											<table width="180" border="0" cellspacing="0" cellpadding="0" style="border-collapse: collapse; background: #fff; border: 2px solid #f0f0f0; line-height: 22px; text-align: center">
												<tbody><tr>
													<th scope="col" style="border: 1px solid #f0f0f0">经停地</th>
													<th scope="col" style="border: 1px solid #f0f0f0">停留时间</th>
												</tr>
												<tr>
													<td style="border: 1px solid #f0f0f0" id="stopinfodiv1_<ww:property value="#state.index" />"></td>
													<td style="border: 1px solid #f0f0f0" id="stopinfodiv2_<ww:property value="#state.index" />"></td>
												</tr>
											</tbody></table>
										</div></font></ww:if>
										
				</td>
				<td><font style="width: 68px; display: block; float: left;">余票：<ww:if test="LowCarbin.SeatNum.equals(\"9\")">≥9</ww:if><ww:else>
											<ww:property value="LowCarbin.SeatNum" />
										</ww:else></font>
				
					
				<ww:if test="LowCarbin.level==-1">
				<a id="a_rules_0" class="font3797f1" href="javascript:void(0)"
					onmouseout="hiderules(&#39;0&#39;);"
					onclick="alert('含农夫山泉矿泉水一瓶+航空意外险');">套餐价</a></ww:if><ww:else>
				<a id="a_rules_0" class="font3797f1" href="javascript:void(0)"
					onmouseout="hiderules(&#39;0&#39;);"
					onclick="showrules(&#39;MU&#39;,&#39;F&#39;,&#39;0&#39;,&#39;&#39;,&#39;&#39;,&#39;&#39;);">退改签</a>
				</ww:else>	
					</td>
			</tr>
			<tr>
				<td colspan="10" style="height: 8px; line-height: 8px;">&nbsp;</td>
			</tr>
		<tbody id='divallcabininfo_<ww:property value="#state.index" />'
			style="display: none;">

			<ww:iterator value="Carbins" status="cabState">
					<span id="divallcabin_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"></span>
				<tr
					id="divallcabin_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">
					<td width="16%">&nbsp;</td>
					<td width="10%">&nbsp;</td>

					<td><span
						id="hid_cabintypename111_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">
				<ww:if test="AirCompany=='9C'">
				经济舱
				</ww:if><ww:else>
						<ww:property value="GetCabinType(Discount,Special,cabin)" /></ww:else>
						
						</span> [<span
						id="hid_lowcabincode111_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"><ww:property
						value="cabin" /></span>/<span
						id="hid_discount111_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"><ww:property
						value="Discount/10" /></span>折]</td>
					<td rowspan="2"><font class="ff0000">¥<span
						id="hid_lowparvalue111_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"><ww:property value="formatMoneyToInt(price)" /></span></font>元</td>
					<td rowspan="2"><font class="ff0000">¥<span
						id="hid_lowparvalue222_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"><ww:property value="formatMoneyToInt(price+AirportFee+FuelFee)" /></span></font>元</td>
					<td rowspan="2" class="zratecss" width="52" ><img id="td_isspecial_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>" style="display: none;"
					src="b2bairticket/img/teshu.gif" width="52" height="21"><input type="hidden" id="hid_lowisspecial_111" value="2"></td>
					
					<td rowspan="2" class="zratecss"><font class="f48000"><span
						id="ALLCabinfandian_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">0</span>%</font>(<font
						class="f48000"
						id="ALLCabinyouhui_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">0</font>元)</td>
					<td rowspan="2" class="zratecss"><font class="ff0000">¥<span
						id="ALLCabinPrice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"><ww:property value="formatMoneyToInt(price+AirportFee+FuelFee)" /></span></font>元</td>
					<td rowspan="2" width="120">
					
					<ww:if test="AirCompany=='9C'">
					<img id="book_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"
						onclick="tocreatorder9c('<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>',<ww:property value="s_traveltype" />);return false;"
						src="b2bairticket/img/input_yds.gif" width="55" height="20"
						id="tocreateorder_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"
						style="margin-left: 30px;" class="pointer back">
					</ww:if><ww:else>
					<img id="book_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"
						onclick="tocreatorder('<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>',<ww:property value="s_traveltype" />);return false;"
						src="b2bairticket/img/input_yds.gif" width="55" height="20"
						id="tocreateorder_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"
						style="margin-left: 30px;" class="pointer back">
					</ww:else>
					
					
					
					
						
							
						</td>
				</tr>
				<tr
					id="divallcabin_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">
					<td>&nbsp;</td>
					<td style="padding-left: 23px;">&nbsp;</td>
					<td><font style="width: 68px; display: block; float: left;">余票：<ww:if test="SeatNum.equals(\"9\")">≥9</ww:if><ww:else>
											<ww:property value="SeatNum" />
										</ww:else></font> <a id="a_rules_1_1" class="font3797f1"
						href="javascript:void(0)" onmouseout="hiderules(&#39;1_1&#39;);"
						onclick="showrules(&#39;CA&#39;,&#39;F&#39;,&#39;1_1&#39;,&#39;&#39;,&#39;&#39;,&#39;&#39;);">退改签</a></td>
				</tr>
				<tr
					id="divallcabin_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">
					<td colspan="10" style="height: 8px; line-height: 8px;">&nbsp;</td>
				</tr>
				<!-- 隐藏域 -->
					<input type="hidden"
					id='hid_lowprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="price" />' /> 
					
					<input type="hidden"
					id='hid_lowfandian_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="ratevalue"/>' /> 
					
					
					<input type="hidden"
					id='hid_lowdiscount_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Discount" />' /> <input type="hidden"
					id='hid_lowyprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="YPrice" />' /> <input type="hidden"
					id='hid_lowseatnum_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="SeatNum" />' /> <input type="hidden"
					id='hid_lowcabincode_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="cabin" />' /> <input type="hidden"
					id='hid_lowdeparttime_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="formatTimestamp(DepartTime)" />' /> <input
					type="hidden"
					id='hid_lowstartairportname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="StartAirportName" />' /> <input
					type="hidden"
					id='hid_lowstartairport_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="StartAirport" />' /> <input
					type="hidden"
					id='hid_lowarrivetime_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="formatTimestamp(ArriveTime)" />' /> <input
					type="hidden"
					id='hid_lowendairportname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="EndAirportName" />' /> <input
					type="hidden"
					id='hid_lowendairport_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="EndAirport" />' /> <input type="hidden"
					id='hid_lowflightnumber_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Airline" />' /> <input type="hidden"
					id='hid_lowaircompany_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirCompany" />' /> <input type="hidden"
					id='hid_lowaircompanyname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="getAirCompanyNameByCode(AirCompanyName)" />' />
				<input type="hidden"
					id='hid_lowflighttype_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirplaneType" />' /> <input
					type="hidden"
					id='hid_lowflightdesc_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirplaneTypeDesc" />' /> <input
					type="hidden"
					id='hid_lowairportfee_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirportFee" />' /> <input type="hidden"
					id='hid_lowfuelfee_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="FuelFee" />' /> <input type="hidden"
					id='hid_lowrules_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="rules" />' />
					<!-- 新增加航站楼 -->
				<input type="hidden"
				id='hid_borderpointat_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='<ww:property value="StartAirportHZL"/>' />
				<input type="hidden"
				id='hid_offpointat_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='<ww:property value="EndAirportHZL"/>' />
					<!-- 新增加政策信息 -->
				<input type="hidden"
				id='hid_zrateid_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
				<input type="hidden"
				id='hid_zratevalue_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='<ww:property value="ratevalue"/>' />
					<!-- 新增加强制保险信息 -->
				<input type="hidden"
				id='hid_qiangzhibaoxian_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
				
				<tr>
								<td colspan="10">
								<hr
									style="border-bottom: 1px dashed #909090; border-top: none; border-left: none; border-right: none; height: 1px;" />
								</td>
							</tr>
			</ww:iterator>
		</tbody>

		<tr style="font-size: 12px;">
			<td colspan="10" class="ranyou">
			<div class="">
			<ul>
				<li class="f" style="width: 145px;">机建+燃油：￥<span
					id="" style="display: inline-block;"><ww:property value="AirportFee" /></span>+￥<span
					id="" style="display: inline-block;"><ww:property value="FuelFee" /></span></li>
				<li class="f" style="width: 110px;"></li>
				<li class="f" style="width: 160px;">飞行时间：<ww:property value="GetFeiXingTime(formatTimestampyyyyMMddHHmm(DepartTime),formatTimestampyyyyMMddHHmm(ArriveTime))" /></li>
			</ul>
			</div>
			<div class="c"></div>
			</td>
		</tr>
		<tr>
			<td colspan="10" class="line_over">&nbsp;</td>
		</tr>
		
		</div>
		
	</ww:iterator>



	


<!-- 隐藏域 --> 
 <input type="hidden" id="hidsegmentinfo" value='<ww:property value="s_jasonsegmentinfo" />' name="s_jasonsegmentinfo" />
  
 <input type="hidden" name="s_traveltype" value="<ww:property value="s_traveltype" />" />
 <input type="hidden" name="s_depcityname" value="<ww:property value="s_depcityname" />" />
 <input type="hidden" name="s_depcitycode" value="<ww:property value="s_depcitycode" />" />
 <input type="hidden" name="s_arrcityname" value="<ww:property value="s_arrcityname" />" />
 <input type="hidden" name="s_arrcitycode" value="<ww:property value="s_arrcitycode" />" />
 <input type="hidden" name="s_startdate" value="<ww:property value="s_startdate" />" /> 
 <input type="hidden" name="s_backdate" value="<ww:property value="s_backdate" />" /> 
 <input type="hidden" name="s_aircompanycode" value="<ww:property value="s_aircompanycode" />" /> 
 <input type="hidden" id="hidtravelflag" name="s_travelflag" value="<ww:property value="s_travelflag"/>" /> 
 <input type="hidden" id="hidtraveltype" value='<ww:property value="s_traveltype" />' /> 
 

  <!-- 隐藏域 -->

</table>
</div>
</form>
</div>
</div>
<div class="back">


 




</div>

<!--
<script type="text/javascript" src="jquery-1.6.min.js"></script>
<script type="text/javascript" src="jquery.blockUI.js"></script>
<script type="text/javascript" src="jquery.poshytip.js"></script>
<script type="text/javascript" src="jquery.elementsorter.js"></script>
<script type="text/javascript" src="json2.js"></script>
<script type="text/javascript" src="PublicJs.js"></script>
<script type="text/javascript" src="WdatePicker.js"></script>
<script type="text/javascript" src="popdg_div.js"></script>
<script type="text/javascript" src="city.js"></script>
<link href="b2bairticket/css/tip.css" rel="stylesheet" type="text/css">
<link href="http://www.cxslw.cn/js/city-control/citycontrol.css" rel="stylesheet">
<link href="http://www.cxslw.cn/style/city.css" rel="stylesheet">
<script type=text/javascript src="b2bair/js/ticket/list.js"></script>
<script type="text/javascript" src="ticket.js"></script>
-->
<script type="text/javascript" language="javascript">
var s_isshowzrate=0; 
$(document).ready(function(){
	//if(s_isshowzrate==1){
   //		showzrate1(1);
   //	}
	//selectAircompany('ddlAirCom','');
   //	showLowFlightZrateList();
   <ww:if test="s_traveltype==2">
   	showBackDate();
   </ww:if>
   lodlowZrate();
  //lodlowZrate2();
   	//loadPriceweek();//每周最低价
});

function showBackDate(){
$("#lblBackDate").show();
$("#divBackDate").show();
}

function lodlowZrate2(){

      var strid="span[id*='low_fandian_']";
      
     $(strid).each(function(i){
     //$("#low_youhui_"+i).html("<img src='images/loadding.gif' />");
     var piaomianjia=$("#hid_lowprice_"+i).val();
     var fandian=$("#hid_lowfandian_"+i).val();//原始返点
     $.ajax({
	         type:"POST",
	         url:"b2bairticket!GetNewvalue.action",
	         data:{z_fandian:fandian,z_price:piaomianjia},
	         beforeSend:function(){$("#low_fandian_"+i).html("<img src='images/loadding.gif' />")},         
	         success:function(data){
	         
	         			 if(data!=null&&data!=''&&data.split('@').length>0){
	         			 
			       	    fandian=data;
			       	    
			       	       var youhui=parseFloat(piaomianjia)*parseFloat(fandian)/100;
					     var jiesuanjia=parseFloat(piaomianjia)-parseFloat(youhui);
					  	 jiesuanjia= Math.ceil(jiesuanjia);
					     $("#low_youhui_"+i).html(parseInt(piaomianjia)-parseInt(jiesuanjia))
					     $("#low_zrateprice_"+i).html(parseInt(jiesuanjia))
     					$("#hid_lowfandian_"+i).val(fandian);//隐藏域赋值返点
			       	   	   $("#low_fandian_"+i).html(fandian);//显示返点
			       	 }
	         
	         }            
	         });
	         
	         
     
  
    		
       });

}
function SearchOtherDay_(da){

$("#txtStartDate").val(da);
//<br/><span style=''>正在为您查询航班信息，请等待...</span>
loadingoverlay("<img src='main_cx/img/loading2.gif' />");
document.form3.submit();

}
function seachAir(){

loadingoverlay("<img src='main_cx/img/loading2.gif' />");
document.form3.submit();

}


function lodlowZrate(){
 	$("img[id*='bookimage_']").each(function(i)
     {
          $("#bookimage_"+i).hide();
     });
      // alert("0");
      var strid="span[id*='low_fandian_']";
     
      
     $(strid).each(function(i){
    // alert("1");
    
     
     
      
        $.ajax({
	         type:"POST",
	         url:"b2bairticket!findcabinlowBY.action",
	         data:{s_depcitycode:$("#hid_lowstartairport_"+i).val(),s_arrcitycode:$("#hid_lowendairport_"+i).val(),s_startdate:$("#hid_lowdeparttime_"+i).val(),s_aircompanycode:$("#hid_lowaircompany_"+i).val(),s_flightnumber:$("#hid_lowflightnumber_"+i).val(),s_cabincode:$("#hid_lowcabincode_"+i).val(),z_price:$("#hid_lowprice_"+i).val()},
	        beforeSend:function(){$("#low_fandian_"+i).html("<img src='images/loadding.gif' />")},         
	         success:function(data){
	          var jijian=$("#hid_lowairportfee_"+i).val();//基建
     		 var ryou=$("#hid_lowfuelfee_"+i).val();//燃油
      
      
	         			 if(data!=null&&data!=''&&data.split('@').length>0){
				        var datas=data.split('@');
				        if(datas[1]=='0'){
				        //用51
				        //alert("用51的了");
				           var piaomianjia=$("#hid_lowprice_"+i).val();
					       var fandian=$("#hid_lowfandian_"+i).val();//原始返点
					      $.ajax({
						         type:"POST",
						         url:"b2bairticket!GetNewvalue.action",
						         data:{z_fandian:fandian,z_price:piaomianjia},
						         beforeSend:function(){$("#low_fandian_"+i).html("<img src='images/loadding.gif' />")},         
						         success:function(data){
						         
						         			 if(data!=null&&data!=''&&data.split('@').length>0){
						         			 
								       	    fandian=data;
								       	    
								       	       var youhui=parseFloat(piaomianjia)*parseFloat(fandian)/100;
										     var jiesuanjia=parseFloat(piaomianjia)-parseFloat(youhui);
										  	 jiesuanjia= Math.ceil(jiesuanjia);
										     $("#low_youhui_"+i).html(parseInt(piaomianjia)-parseInt(jiesuanjia))
										     $("#low_zrateprice_"+i).html(parseInt(jiesuanjia)+parseInt(jijian)+parseInt(ryou))
					     					$("#hid_lowfandian_"+i).val(fandian);//隐藏域赋值返点
								       	   	   $("#low_fandian_"+i).html(fandian);//显示返点
								       	 }
						         
						         }            
						         });
				        
				        $("#bookimage_"+i).show();
				        
				        }else{
				        
				        //alert(data);
				        $("#low_youhui_"+i).html(datas[1])
				       	$("#low_zrateprice_"+i).html(parseInt(datas[2])+parseInt(jijian)+parseInt(ryou))
			       	   	$("#bookimage_"+i).show();
			       	   //	$("#hid_zrateid_"+i).val(datas[4])
			       	   // $("#hid_zratevalue_"+i).val(datas[3])
			       	    
			       	    if(datas[6]=='1'){//普通
			       	     $("#low_fandian_"+i).html(datas[3])
			       	    $("#td_isspecial_"+i).hide();
			       	    
			       	    }else{//特殊
			       	     $("#low_fandian_"+i).html(datas[3])
			       	    $("#td_isspecial_"+i).show();
			       	    }
			       	    
			       	   
			       	    
			       	   	//$("#low_youhui_"+i).html(datas[1]+"元")
			       	   	//$("#hid_qiangzhibaoxian_"+i).val(datas[5])
			       	   	}
			       	 }else{
			       	 
			       	  //用51
				        //alert("用51的了");
				           var piaomianjia=$("#hid_lowprice_"+i).val();
					       var fandian=$("#hid_lowfandian_"+i).val();//原始返点
					      $.ajax({
						         type:"POST",
						         url:"b2bairticket!GetNewvalue.action",
						         data:{z_fandian:fandian,z_price:piaomianjia},
						         beforeSend:function(){$("#low_fandian_"+i).html("<img src='images/loadding.gif' />")},         
						         success:function(data){
						         
						         			 if(data!=null&&data!=''&&data.split('@').length>0){
						         			 
								       	    fandian=data;
								       	    
								       	       var youhui=parseFloat(piaomianjia)*parseFloat(fandian)/100;
										     var jiesuanjia=parseFloat(piaomianjia)-parseFloat(youhui);
										  	 jiesuanjia= Math.ceil(jiesuanjia);
										     $("#low_youhui_"+i).html(parseInt(piaomianjia)-parseInt(jiesuanjia))
										     $("#low_zrateprice_"+i).html(parseInt(jiesuanjia)+parseInt(jijian)+parseInt(ryou))
					     					$("#hid_lowfandian_"+i).val(fandian);//隐藏域赋值返点
								       	   	   $("#low_fandian_"+i).html(fandian);//显示返点
								       	 }
						         
						         }            
						         });
				        
				        $("#bookimage_"+i).show()
				        
				        
			       	 }
	         
	         }            
	         });
       });

}
function getOtherZrate(ind){

 //alert(ind);
 			 var jijian=$("#hid_lowairportfee_"+ind).val();//基建
     		 var ryou=$("#hid_lowfuelfee_"+ind).val();//燃油
     		 
 		var index=ind;
	 
   		var strid="span[id*='divallcabin_"+index+"_']";
		   	$(strid).each(function(i){
		   			$("#book_"+index+"_"+i).hide()
		   			
			        $.ajax({
				         type:"POST",
				         url:"b2bairticket!findcabinlowBY.action",
				         data:{s_istieshu:0,s_depcitycode:$("#hid_lowstartairport_"+index).val(),s_arrcitycode:$("#hid_lowendairport_"+index).val(),s_startdate:$("#hid_lowdeparttime_"+index).val(),s_aircompanycode:$("#hid_lowaircompany_"+index).val(),s_flightnumber:$("#hid_lowflightnumber_"+index).val(),s_cabincode:$("#hid_lowcabincode_"+index+"_"+i).val(),z_price:$("#hid_lowprice_"+index+"_"+i).val()},
				          beforeSend:function(){$("#ALLCabinfandian_"+index+"_"+i).html("<img src='images/loadding.gif' />")},               
				         success:function(data){
				        
				         // alert(data);
				        if(data!=null&&data!=''&&data.split('@').length>0){
				        	var datas=data.split('@');
				        
				         	$("#ALLCabinyouhui_"+index+"_"+i).html(datas[1])
				       		$("#ALLCabinPrice_"+index+"_"+i).html(parseInt(datas[2])+parseInt(jijian)+parseInt(ryou))//结算价
				       		$("#book_"+index+"_"+i).show()
				       		
				       	   	 if(datas[6]=='1'){//普通
				       	     $("#ALLCabinfandian_"+index+"_"+i).html(datas[3])
				       	    $("#td_isspecial_"+index+"_"+i).hide();
				       	    
				       	    }else{//特殊
				       	     $("#ALLCabinfandian_"+index+"_"+i).html(datas[3])
				       	    $("#td_isspecial_"+index+"_"+i).show();
				       	    }
			       	     $("#book_"+index+"_"+i).show();
				       	 }else{
				       	 
				       	 
				       	 
				       	// alert("用51");
				       	 var piaomianjia=$("#hid_lowprice_"+index+"_"+i).val();
					     var fandian=$("#hid_lowfandian_"+index+"_"+i).val();
					     
					      $.ajax({
						         type:"POST",
						         url:"b2bairticket!GetNewvalue.action",
						         data:{z_fandian:fandian,z_price:piaomianjia},
						         beforeSend:function(){$("#low_fandian_"+index+"_"+i).html("<img src='images/loadding.gif' />")},         
						         success:function(data){
						         
						         			 if(data!=null&&data!=''&&data.split('@').length>0){
						         			 
								       	    	fandian=data;
								       	    
								       	        var youhui=parseFloat(piaomianjia)*parseFloat(fandian)/100;
											     var jiesuanjia=parseFloat(piaomianjia)-parseFloat(youhui);
											  	 jiesuanjia= Math.ceil(jiesuanjia);
					  							 //jiesuanjia= Math.ceil(jiesuanjia);
										     	 $("#ALLCabinyouhui_"+index+"_"+i).html(parseInt(piaomianjia)-parseInt(jiesuanjia))
												 $("#ALLCabinPrice_"+index+"_"+i).html(parseInt(jiesuanjia)+parseInt(jijian)+parseInt(ryou))//结算价
										     
										     
										     
					     					  $("#hid_lowfandian_"+index+"_"+i).val(fandian);//隐藏域赋值返点
								       	   	  $("#ALLCabinfandian_"+index+"_"+i).html(fandian);//显示返点
								       	   	  
								       	   	  $("#book_"+index+"_"+i).show();
								       	 }
						         
						         }            
						         });
				       	 
				       	 }
				         
				         }})
			         
			         
 	  })
 	  }
 	  
function getOtherZrate2(ind){
 		var index=ind;
	 
   		var strid="span[id*='divallcabin_"+index+"_']";
			$(strid).each(function(i){
			$("#ALLCabinyouhui_"+index+"_"+i).html("<img src='images/loadding.gif' />");
			
	 var piaomianjia=$("#hid_lowprice_"+index+"_"+i).val();
     var fandian=$("#hid_lowfandian_"+index+"_"+i).val();
     
      $.ajax({
	         type:"POST",
	         url:"b2bairticket!GetNewvalue.action",
	         data:{z_fandian:fandian,z_price:piaomianjia},
	         beforeSend:function(){$("#low_fandian_"+index+"_"+i).html("<img src='images/loadding.gif' />")},         
	         success:function(data){
	         
	         			 if(data!=null&&data!=''&&data.split('@').length>0){
	         			 
			       	    	fandian=data;
			       	    
			       	        var youhui=parseFloat(piaomianjia)*parseFloat(fandian)/100;
						     var jiesuanjia=parseFloat(piaomianjia)-parseFloat(youhui);
						  	 jiesuanjia= Math.ceil(jiesuanjia);
  							 //jiesuanjia= Math.ceil(jiesuanjia);
					     	 $("#ALLCabinyouhui_"+index+"_"+i).html(parseInt(piaomianjia)-parseInt(jiesuanjia))
							 $("#ALLCabinPrice_"+index+"_"+i).html(parseInt(jiesuanjia))//结算价
					     
					     
					     
     					  $("#hid_lowfandian_"+index+"_"+i).val(fandian);//隐藏域赋值返点
			       	   	  $("#ALLCabinfandian_"+index+"_"+i).html(fandian);//显示返点
			       	 }
	         
	         }            
	         });
     
     
     
     
     
     
   
     
			         
 	  })
 	  }  
 function toggle_show(id){
 
  $("#"+id).show();
 }
 function showzrate1(selectValue,id)
{
   // var selectIndex = document.getElementById("ddlzrate").options.selectedIndex;
   // var selectValue = document.getElementById("ddlzrate").options[selectIndex].value;
    if(selectValue=="0")
    {
      $(".zratecss").show();
       $("#"+id).hide();
    }
    else if(selectValue=="1")
    {
       $(".zratecss").hide();
        $("#"+id).hide();
    }
}  
function hidestopinfo(id){
 $("#"+id).hide();

}
function showstopinfo(flightnumber,fromdate,stopnum,index){
  $.ajax({
	     type:"POST",
	     url:"b2bairticket!getFlightStopinfo.action",
	     data:{FF_FlightNumber:flightnumber,FF_date:fromdate,FF_StopNum:stopnum},
	     beforeSend:function(){$("#stopinfodiv_"+index).show();},             
	     success:function(data){
	     if(data.indexOf("@")!=-1){
	     
	     $("#stopinfodiv1_"+index).html(data.split('@')[0]);
	     $("#stopinfodiv2_"+index).html(data.split('@')[1]);
	     }
	  	//stopinfodiv1
	     //$("#divstopinfo").html(data);           
	     }            
	     });

}
  <ww:if test="s_seachtype==0">
	   $(".zratecss").show();
	  </ww:if>
	  <ww:if test="s_seachtype==1">
	  $(".zratecss").hide();
	  </ww:if>
	
	//根据排序条件进行排序
function sortflightlist(value) {

	alert(value);
	if(value=="pricedesc"){
		if($("#sortprice").html()=="0"){
			$("#sortprice").html("1");
		}else{
			$("#sortprice").html("0");
			value="priceasc";
		}
	}
	if(value=="timedesc"){
		if($("#sorttime").html()=="0"){
			$("#sorttime").html("1");
		}else{
			$("#sorttime").html("0");
			value="timeasc";
		}
	}
	value="timedesc";
	switch (value) {
	case "timeasc":
		sort('.timeOfColnum', 'asc', 'string');
		break;
	case "timedesc":
		sort('.timeOfColnum', 'desc', 'string');
		break;
	case "priceasc":
		sort('.priceOfColnum', 'asc', 'number');
		break;
	case "pricedesc":
		sort('.priceOfColnum', 'desc', 'number');
		break;
	case "zrateasc":
		sort('.zrateOfColnum', 'asc', 'number');
		break;
	case "zratedesc":
		sort('.zrateOfColnum', 'desc', 'number');
		break;
	default:
		sort('.timeOfColnum', 'asc', 'string');
	}
}
	
//时间，价格排序
function sort(classname, direction, datatype) {
alert(classname+","+direction+","+datatype);

	var sortParams = {
		sortOn : classname,
		direction : direction,
		sortType : datatype
	}
	
	
	$('#flightlist').sort(sortParams,$("div[id*='ALLCabin_LowCabin_']"));
}  

 //跳转到下单页面或者查询第二程航班信息
	  function tocreatorder9c(index,traveltype)
	  {


	     //dispose("系统正在为您预定"); 
	     
	     //loadingoverlay("<img src='main_cx/img/loading2.gif' /><br/><span style=''>正在为您查询航班信息，请等待...</span>");
	   
	     var travelflag=$("#hidtravelflag").val();
	       //alert(index+","+traveltype+","+travelflag);
	       
	     //单程预订，跳转到下单页面
	     if(traveltype==1)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo9c(index);
	        //return;
	        //提交表单
	        postdata("b2b9cairticket!toCreateOrder.action");
	     }
	     //往返或者联程,对选中的第一程航班信息进行赋值，并查询第二程航班
	     else if(traveltype==2 && travelflag==1)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo9c(index);
	        $("#hidtravelflag").val("2");
	        //提交表单
	        postdata("b2b9cairticket!toTicketList.action");
	        
	     }
	     else if(traveltype==2 && travelflag==2)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo9c(index);
	        //提交表单
	        //return;
	        postdata("b2b9cairticket!toCreateOrder.action");
	     }
	  }
	  
	   	 //根据选中的航班信息对segmentinfojason对象进行赋值
	  function bindsegmentinfo9c(index)
	  {
	 // alert(index);
	    var JasonString = {"segmentinfos": [    
            {
              "flightnumber": $("#hid_lowflightnumber_"+index).val(),
              "aircomapnycode": $("#hid_lowaircompany_"+index).val(),
              "airname": $("#hid_lowaircompanyname_"+index).val(),
              "airportfee":$("#hid_lowairportfee_"+index).val(),
              "fuelfee":$("#hid_lowfuelfee_"+index).val(),
              "departtime":$("#hid_lowdeparttime_"+index).val(),
              "arrivaltime":$("#hid_lowarrivetime_"+index).val(),
              "cabincode":$("#hid_lowcabincode_"+index).val(),
              "price":$("#hid_lowprice_"+index).val(),
              "discount":$("#hid_lowdiscount_"+index).val(),
              "yprice":$("#hid_lowyprice_"+index).val(),
              "traveltype":$("#hidtraveltype").val(),
              "isspecial":"",
              "startairport":$("#hid_lowstartairport_"+index).val(),
              "startairportname":$("#hid_lowstartairportname_"+index).val(),
              "endairport":$("#hid_lowendairport_"+index).val(),
              "endairportname":$("#hid_lowendairportname_"+index).val(),
              "rules":$("#hid_lowrules_"+index).val(),
              "ratevalue":"",
              "borderpointat":$("#hid_borderpointat_"+index).val(),
              "offpointat":$("#hid_offpointat_"+index).val(),
              "parvalue":$("#hid_zratevalue_"+index).val(),
              "agentid":"",
              "zrateid":$("#hid_zrateid_"+index).val(),
              "flightdesc":$("#hid_lowflightdesc_"+index).val(),
              "flightmodel":$("#hid_lowflighttype_"+index).val(),
              "qiangzhibaoxian":$("#hid_qiangzhibaoxian_"+index).val()
              }  
            ]};
            
            
            
            //alert(JasonString);
            if($("#hidsegmentinfo").val()!="" && $("#hidsegmentinfo").val().indexOf('@')<0 && $("#hidtravelflag").val()=="2")
            {
              $("#hidsegmentinfo").val($("#hidsegmentinfo").val()+"@"+JSON.stringify(JasonString));
            }
            else
            {
               $("#hidsegmentinfo").val(JSON.stringify(JasonString));
            }
            

	  } 
</script>
</body>
</html>
<script type="text/javascript" src="b2bairticket/listcss/jquery.elementsorter.js"></script>