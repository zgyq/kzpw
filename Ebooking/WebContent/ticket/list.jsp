<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />

<title>${compname}-机票列表页面</title>
<ww:head name="air" jsURL="ticketlist" />

<script>

 //页面加载
    $(document).ready(function()
	   {
	    //返程日期隐藏
	    <ww:if test="s_traveltype==1">
	    $("#txtbackdate").attr("disabled","disabled");
	    </ww:if>
	    <ww:else>
	    $("#txtbackdate").removeAttr("disabled");
	    </ww:else>
	    //加载城市控件数据
	    $("#txtDepCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    //时间排序
	    //sort('.airport','asc');
	    //日期选项卡
	    //ajaxsearchyp();
		
		
		//加载政策
		 //alert("??");
		getLowZrate();
	 });
	 

	   function getLowZrate(){
	  // alert("?");
   		var strid="span[id*='low_zrateprice_']";
		   	$(strid).each(function(i){
		   	$("#book_"+i).hide()
		        $.ajax({
			         type:"POST",
			         url:"ticticket!findcabinlowBY.jspx",
			         data:{s_depcitycode:$("#hid_lowstartairport_"+i).val(),s_arrcitycode:$("#hid_lowendairport_"+i).val(),s_startdate:$("#hid_lowdeparttime_"+i).val(),s_aircompanycode:$("#hid_lowaircompany_"+i).val(),s_flightnumber:$("#hid_lowflightnumber_"+i).val(),s_cabincode:$("#hid_lowcabincode_"+i).val(),z_price:$("#hid_lowprice_"+i).val()},
			        beforeSend:function(){$("#low_zrateprice_"+i).html("<img src='images/loadding.gif' />")},               
			         success:function(data){
			        //alert(data);
			        if(data!=null&&data!=''&&data.split('@').length>0){
			        var datas=data.split('@');
			       	$("#low_zrateprice_"+i).html(datas[2])
			       	   	$("#book_"+i).show()
			       	   	$("#hid_zrateid_"+i).val(datas[4])
			       	   	$("#hid_zratevalue_"+i).val(datas[3])
			       	 }
			         
			         }})
 	  })
 	  }
 	  
//查询航班序号=ind， flag=是否查询特价政策 1=查，0不查
 function getOtherZrate(ind){
 //alert(ind);
 var index=ind;
	 
   		var strid="span[id*='ALLCabin_"+index+"_']";
		   	$(strid).each(function(i){
		   			$("#book_"+index+"_"+i).hide()
		        $.ajax({
			         type:"POST",
			         url:"ticticket!findcabinlowBY.jspx",
			         data:{s_depcitycode:$("#hid_lowstartairport_"+index).val(),s_arrcitycode:$("#hid_lowendairport_"+index).val(),s_startdate:$("#hid_lowdeparttime_"+index).val(),s_aircompanycode:$("#hid_lowaircompany_"+index).val(),s_flightnumber:$("#hid_lowflightnumber_"+index).val(),s_cabincode:$("#hid_lowcabincode_"+index+"_"+i).val(),z_price:$("#hid_lowprice_"+index+"_"+i).val()},
			        beforeSend:function(){$("#ALLCabinPrice_"+index+"_"+i).html("<img src='images/loadding.gif' />")},               
			         success:function(data){
			        //alert(data);
			        if(data!=null&&data!=''&&data.split('@').length>0){
			        var datas=data.split('@');
			       	$("#ALLCabinPrice_"+index+"_"+i).html(datas[2])
			       		$("#book_"+index+"_"+i).show()
			       		$("#hid_zrateid_"+index+"_"+i).val(datas[4])
			       	   	$("#hid_zratevalue_"+index+"_"+i).val(datas[3])
			       	 }
			         
			         }})
 	  })
 	  }
</script>
<script>
	function lodMap(address){
	return;
	document.getElementById("hidaddress").value=address;
	document.form4.submit();
	}
</script>
</head>
<body>
<ww:i18n name="'language'">
	
		<ww:include page="../top.jsp?index=1&subindex=1" />
	
	<!--top over-->
	<div id="main">
	<div id="left" class="f">
	<form name="form1" id="form1" method="post">
	<div class="search"><font class="black">国内机票搜索</font></div>
	<div class="box_sea searchlist">
	<ul>
		<li class="choose"><input name="s_traveltype" id="rdoOneWay"
			type="radio" value="1"
			<ww:if test="s_traveltype==1">checked="checked"</ww:if>
			onclick="bindFlightType(1);" /> <span class="mr15"> <ww:text
			name="'OneWay'" /></span> <input name="s_traveltype" id="rdoRoundWay"
			type="radio" value="2"
			<ww:if test="s_traveltype==2">checked="checked"</ww:if>
			onclick="bindFlightType(2);" /> <ww:text name="'Return'" /></li>
		<li class="searchall"><ww:text name="'DepartureCity'" />：<input
			type="text" id="txtDepCity" name="s_depcityname" class="text_search" value='<ww:if test="s_depcityname!=null"><ww:property value="s_depcityname" /></ww:if><ww:else><ww:property value="getAirCityNamebySZM(s_depcitycode)" /></ww:else>' title="请输入出发城市" />
		<div id='suggest' class="ac_results"></div>
		<input type="hidden" id="hidDepCity" name="s_depcitycode"
			value="<ww:property value='s_depcitycode'/>" /></li>
		<li class="searchall"><ww:text name="'ArrivalCity'" />：<input type="text" id="txtArrCity" name="s_arrcityname" class="text_search" value='<ww:if test="s_arrcityname!=null"><ww:property value="s_arrcityname" /></ww:if><ww:else><ww:property value="getAirCityNamebySZM(s_arrcitycode)" /></ww:else>' title="请输入到达城市" />
		<div id='suggest2' class="ac_results"></div>
		<input type="hidden" id="hidArrCity" name="s_arrcitycode"
			value="<ww:property value='s_arrcitycode' />" /></li>
		<li class="searchall"><ww:text name="'DepartureTime'" />：<input
			type="text" id="txtstartdate" name="s_startdate"
			onfocus="clearText('txtstartdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="text_searchwf"
			value='<ww:if test='s_startdate!=null && !s_startdate.equals("")'><ww:property value="s_startdate" /></ww:if><ww:else>往</ww:else>'
			title="请输入出发时间" /> <input type="text" name="s_backdate"
			id="txtbackdate"
			onfocus="clearText('txtbackdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="text_searchwf"
			value='<ww:if test='s_backdate!=null && !s_backdate.equals("")'><ww:property value="s_backdate" /></ww:if><ww:else>返</ww:else>' />
		</li>
		<li class="searchall">航空公司：
			<select name="s_aircompanycode" class="sel_search">
				<option value="">---所有航空公司---</option>
				<ww:iterator value="listAirCompany">
					<option value="<ww:property value='aircomcode' />"><ww:property
						value="aircomcode" /><ww:property value="aircomcnname" /></option>
				</ww:iterator>
			</select>
		</li>
		<li class="but" style=" height:40px; padding:5px 0; text-align:center;">
			<!-- <span class="f">搜索最优的机票，<br />就上${compname}。</span> -->
			<span><input type="button" class="bst" value="立即搜索" id="btnsearch" onclick="search();" /></span>
			<div class="c"></div>
		</li>
	</ul>
	</div>

	</form>
	<!-- <div class="searchbot"></div> -->
	<div class="tit mt7" style=" border:1px solid #E3E3E3; border-bottom:none;">
		<font class="black" style=" padding-left:10px;"><ww:property value="GetInfoTypeNameById(typeid)" /></font>
	</div>
	<div class="box content" style=" border-top:none;">
		<ul>
			<ww:iterator value="Listhelpcenterinfo">
				<li title="<ww:property value="name" />">
					<a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>">
					<ww:if test="name.length()>16">
					<ww:property value="SubString(name,14)"/>...
					</ww:if>
					<ww:else><ww:property value="name" /></ww:else>
					</a>
				</li>
			</ww:iterator>
		</ul>
	</div>
	<!--
	<div class="ad mt7"><img src="images/ad_ticket_01.jpg" width="260" height="100" /></div>
	<div class="ad mt7"><img src="images/ad_ticket_01.jpg" width="260" height="100" /></div>
	-->
	</div>
	<!--left over-->
	<div id="list" class="r">
	<div class="guild">
	<ul>
		<li class="current f"></li>
		<li class="f font20"><ww:if test="s_traveltype==1">
			<ww:if test="s_depcityname==null"><ww:property
					value="getAirCityNamebySZM(s_depcitycode)" /></ww:if>
		    <ww:else><ww:property value="s_depcityname" /></ww:else>→
		    <ww:if test="s_arrcityname==null"><ww:property
					value="getAirCityNamebySZM(s_arrcitycode)" /></ww:if>
			<ww:else>
		    <ww:property
				value="s_arrcityname" /></ww:else>（单程）
            </ww:if> <ww:elseif test="s_traveltype==2">
			<ww:if test="s_depcityname==null"><ww:property
					value="getAirCityNamebySZM(s_depcitycode)" /></ww:if>
		    <ww:else><ww:property value="s_depcityname" /></ww:else>←→<ww:if test="s_arrcityname==null"><ww:property
					value="getAirCityNamebySZM(s_arrcitycode)" /></ww:if>
			<ww:else>
		    <ww:property
				value="s_arrcityname" /></ww:else>（往返）
            </ww:elseif></li>
		<li class="r status">&nbsp;</li>
		<li class="c"></li>
	</ul>
	</div>
	
	<form id="form3" name="form3">
	<div class="week mt7">
	<ul id='uldate'>
		<ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
			<ww:param name="'first'" value="1" />
			<ww:param name="'last'" value="7" />
		</ww:bean>
		<ww:iterator value="#counter" status="state">
		    <ww:if test="s_travelflag==1">
			<li
				<ww:if test='compareandselectTab(s_startdate,GetDate(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate))))'>class="weektabon f  "</ww:if>
				<ww:else>class="weektab f fff"</ww:else> onclick=""><span
				style="cursor: pointer"
				onclick="loading('航班信息');searchotherday('<ww:property value="GetDate(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)))" />');">
			<dt><ww:property
				value="GetDateMMdd(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)),0)" />
			</dt>
			<dt class="fff"><ww:property value="GetDateMMdd(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)),1)" /></dt>
			</span></li>
			</ww:if>
			<ww:elseif test="s_travelflag==2">
			
			<li
				<ww:if test='compareandselectTab(s_backdate,GetDate(s_backdate,#state.index-(Calculate(s_backdate)>3?3:Calculate(s_backdate))))'>class="weektabon f  "</ww:if>
				<ww:else>class="weektab f fff"</ww:else> onclick=""><span
				style="cursor: pointer"
				onclick="loading('航班信息');searchotherday('<ww:property value="GetDate(s_backdate,#state.index-(Calculate(s_backdate)>3?3:Calculate(s_backdate)))" />');">
			<dt><ww:property
				value="GetDateMMdd(s_backdate,#state.index-(Calculate(s_backdate)>3?3:Calculate(s_backdate)),0)" />
			</dt>
			<dt class="dcff58">&yen;<ww:property value="GetDateMMdd(s_backdate,#state.index-(Calculate(s_backdate)>3?3:Calculate(s_backdate)),1)" /></dt>
			</span></li>
			</if>
			</ww:elseif>
		</ww:iterator>


	</ul>
	<div class="c"></div>
	</div>
	<!--星期查询 over-->

	<div class="msg mt7"
		<ww:if test="listsegmentinfo.size()==0" >style='display:none'</ww:if>>
	<ww:iterator value="listsegmentinfo">
		<ul class="msgul">
			<li class="over box_over"><b>已选择的<ww:if
				test="s_traveltype==2">去程</ww:if><ww:elseif test="s_traveltype==3">第一程</ww:elseif>航班</b>
			<span class="mlr15"><ww:property value="s_depcityname" />→ <ww:property
				value="s_arrcityname" /></span>出发日期：<ww:property value="s_startdate" /></li>
			<li>
			<ul class="range">
				<li class="overmorny f"><font class="font18f60">&yen;<ww:property
					value="formatMoneyToInt(price)" /></font><span class="mlr"> <ww:if
					test="discount>=150.0">头等舱</ww:if> <ww:elseif
					test="discount>=130.0">商务舱</ww:elseif> <ww:elseif test="isspecial">特价经济舱</ww:elseif>
				<ww:else>经济舱</ww:else> </span></li>
				<li class="f airportover">
				<dt><ww:property value="formatTimestampHHmm(departtime)" /> <ww:property
					value="startairportname" /></dt>
				<dt><ww:property value="formatTimestampHHmm(arrivaltime)" /> <ww:property
					value="endairportname" /></dt>
				</li>
				<li class="f airlines airlines_mu"></li>
				<li class="f model">
				<dt><ww:property value="airname" /><ww:property
					value="flightnumber" /></dt>
				<dt>空客<a id="a_flightdesc_selected" href="javascript:void(0);"
					class="fontun06c" onmouseout="hideflightdesc('selected');"
					; onmouseover="showflightdesc('selected');" class="fontun06c"><ww:property
					value="flightmodel" /></a><ww:property
					value="getFlightModel(flightmodel)" /></dt>
				</li>
				<li class="f fuel"><ww:property
					value="formatMoneyToInt(airportfee)" />/<ww:property
					value="formatMoneyToInt(fuelfee)" /></li>
				<li class="f meal"><a id="a_rules_selected"
					href="javascript:void(0);" class="fontun06c"
					onmouseout="hiderules('selected');"
					; onmouseover="showrules('selected','<ww:property value="rules" />');"
					class="fontun06c">退改签规则</a>
				<div class="float msg_l" style="display: none">
				<ul class="msgul_l">
					<li class="over box_over_l">退改签规则</li>
					<li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
					<li class="pf5"><b>退票条件：</b></li>
					<li class="pf5"><b>签转条件：</b></li>
				</ul>
				</div>
				</li>
				<li class="f btn"><input type="button" class="bnt_modify fff"
					value="修&nbsp;改" /></li>
			</ul>

			</li>
		</ul>
	</ww:iterator></div>
	<!--往返订单第一程信息-->
	<div class="tips2 mt7 box">
	<div class="f"><span class="shop mlr">选择<ww:if
		test="s_traveltype==2 && #index.index==0">去程</ww:if><ww:elseif
		test="s_traveltype==2 && #index.index==1">返程</ww:elseif><ww:elseif
		test="s_traveltype==3 && #index.index==0">第一程</ww:elseif><ww:elseif
		test="s_traveltype==3 && #index.index==1">第二程</ww:elseif>航班</span>&nbsp;共 <font	class="ff7f05"><ww:property value="listFlightInfoAll.size()" />个</font>航班
	<font class="mlr l06c" style=" color:#555454">(&nbsp;<ww:if test="s_traveltype==1">单程</ww:if><ww:elseif
		test="s_traveltype==2">往返</ww:elseif><ww:elseif test="s_traveltype==2">联程</ww:elseif>&nbsp;|&nbsp;<ww:property
		value="s_startdate" />&nbsp;出发&nbsp;)</font></div>

	<div class="r thedates"><span>【<ww:property
		value="s_prevshortdate" />】<a href="#"
		onclick="loading('航班信息');searchotherday('<ww:property value="s_prevdate" />');"
		class="l06c"><font class="yesterday">前一天</font></a></span> <span><a
		href="#" class="l06c"
		onclick="loading('航班信息');searchotherday('<ww:property value="s_nextdate" />');"><font
		class="tomorrow">后一天</font></a>【<ww:property value="s_nextshortdate" />】</span></div>
	<div class="c"></div>
	<input type="hidden" value="<ww:property value="s_depcitycode" />"
		name="s_depcitycode" /> <input type="hidden"
		value="<ww:property value="s_arrcitycode" />" name="s_arrcitycode" />
	<input type="hidden" value="<ww:property value="s_depcityname" />"
		name="s_depcityname" /> <input type="hidden"
		value="<ww:property value="s_arrcityname" />" name="s_arrcityname" />
	<input type="hidden" value="<ww:property value="s_startdate" />"
		id="hidotherday" name="s_startdate" /> <input type="hidden"
		value="<ww:property value="s_backdate" />" name="s_backdate" /> <input
		type="hidden" value="<ww:property value="s_traveltype" />"
		name="s_traveltype" /> <input type="hidden"
		value="<ww:property value="s_aircompanycode" />"
		name="s_aircompanycode" />
		<input type="hidden"
		value="<ww:property value="s_travelflag" />"
		name="s_travelflag" />

	</div>
	</form>
	<!--提示信息-->
	<div class="mt7 box">
	<div class="tit"><font class="black low2 f mr15">国内超低折扣机票</font>
	<font class="f ff7f05"> </font> <span class="r" style=" margin-right:10px;">排序：

	<select id="ddlsort" onchange="sortflightlist();">
		<option value="timeasc">出发时间从早到晚</option>
		<option value="timedesc">出发时间从晚到早</option>
		<option value="priceasc">价格从低到高</option>
		<option value="pricedesc">价格从高到低</option>
	</select> </span>
	<div class="c"></div>
	</div>
	<div>
	<ul class="subnav">
		<li class="f subnavone">价格/舱位/余票</li>
		<li class="f subnavtwo">出发/到达</li>
		<li class="f subnavthree">航空公司/机型</li>
		<li class="f subnavfour">机建/燃油</li>
		<!--
		<li class="f subnavfive">退改签</li>
		-->
		<li class="f subnavfive">结算价</li>
		<li class="f subnavsex">操作</li>
		<div class="c"></div>
	</ul>
	</div>
	<form name="form2" id="form2">
	<div id="div_flightlist"><!-- 航班信息列表 start--> 
	 <ww:if test="listFlightInfoAll.size()>0">
	 <ww:iterator value="listFlightInfoAll" status="state">
		<div><span style="display: none" class="priceOfColnum"><ww:property
			value="formatMoneyToInt(LowCarbin.price)" /></span> <span
			style="display: none" class="timeOfColnum"><ww:property
			value="formatTimestampHHmm(DepartTime)" /></span>
		<ul <ww:if test="#state.index%2==1">class="listrange box_botm"</ww:if>
			<ww:else>class="range box_botm"</ww:else>>
			<li class="morny">
			<dt><font class="font18f60">&yen;<ww:property
				value="formatMoneyToInt(LowCarbin.price)" /></font> <span class="mlr">
			<ww:if test="LowCarbin.Discount>=150.0">头等舱</ww:if> <ww:elseif
				test="LowCarbin.Discount>=130.0">商务舱</ww:elseif> <ww:elseif
				test="LowCarbin.Special">特价经济舱</ww:elseif> <ww:else>经济舱</ww:else></span></dt>

			<dt><a id="linkshowcabin_<ww:property value="#state.index" />"
				href="javascript:void(0);" class="fontun06c"
				onclick='showallcabin(<ww:property value="#state.index" />);'>
			所有舱位↓ </a> <span class="mlr"> <ww:if
				test="LowCarbin.Discount>=100.0">全价</ww:if> <ww:else>
				<ww:property value="LowCarbin.Discount/10" />折</ww:else> </span> <b class="ff7f05">
			<ww:if test="LowCarbin.SeatNum.equals(\"9\")">≥9</ww:if> <ww:else>
		 =<ww:property value="LowCarbin.SeatNum" />
			</ww:else> </b></dt>
			</li>
			<li class="airport">
			<dt><ww:property value="formatTimestampHHmm(DepartTime)" /><a href="javascript:lodMap('<ww:property value="StartAirportName" />');"><ww:property value="StartAirportName" /></a><span style="color: red">(<ww:property value="StartAirportHZL"/>)</span></dt>
			<dt><ww:property value="formatTimestampHHmm(ArriveTime)" /><a href="javascript:lodMap('<ww:property value="EndAirportName" />');" ><ww:property value="EndAirportName" /></a><span style="color: red">(<ww:property value="EndAirportHZL"/>)</span></dt>
			</li>
			<li class="f airco_<ww:property value="AirCompany" /> airico"></li>
			<li class="f model">
			<dt><ww:property value="getAirCompanyNameByCode(AirCompanyName)" /><ww:property
				value="Airline" /></dt>
			<dt>空客<a id="a_flightdesc_<ww:property value="#state.index" />"
				href="javascript:void(0);" class="fontun06c"
				onmouseout="hideflightdesc('<ww:property value="#state.index" />');"
				; onmouseover="showflightdesc('<ww:property value="#state.index" />');"
				class="fontun06c"><ww:property value="AirplaneType" /></a><ww:property
				value="getFlightModel(AirplaneType)" /></dt>
			</li>
			<li class="f" style="width:78px;">
			<dt><ww:property value="AirportFee" />/<ww:property
				value="FuelFee" /></dt>
			<dt><a
				id="a_rules_<ww:property value="#state.index" />"
				href="javascript:void(0);" class="fontun06c"
				onmouseout="hiderules('<ww:property value="#state.index" />');"
				; onmouseover="showrules('<ww:property value="#state.index" />','<ww:property value="rules" />');">退改签</a></dt>
				
				<div class="float msg_l" style="display: none">
			<ul class="msgul_l">
				<li class="over box_over_l">退改签规则</li>
				<li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
				<li class="pf5"><b>退票条件：</b></li>
				<li class="pf5"><b>签转条件：</b></li>
			</ul>
			</div>
				</li>
			<!--<li class="f meal">
			<a
				id="a_rules_<ww:property value="#state.index" />"
				href="javascript:void(0);" class="fontun06c"
				onmouseout="hiderules('<ww:property value="#state.index" />');"
				; onmouseover="showrules('<ww:property value="#state.index" />','<ww:property value="rules" />');">退改签规则</a>
			<div class="float msg_l" style="display: none">
			<ul class="msgul_l">
				<li class="over box_over_l">退改签规则</li>
				<li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
				<li class="pf5"><b>退票条件：</b></li>
				<li class="pf5"><b>签转条件：</b></li>
			</ul>
			</div>
			
			</li>
			-->
			<li class="f meal">
			<font class="font18f60">&yen;
			<span id="low_zrateprice_<ww:property value="#state.index" />">
			<ww:property
				value="formatMoneyToInt(LowCarbin.price)" />
				</span>
				</font>
			
			</li>
			
			<input type="hidden"
				id='hid_lowprice_<ww:property value="#state.index" />'
				value='<ww:property value="LowCarbin.price" />' /> <input
				type="hidden"
				id='hid_lowdiscount_<ww:property value="#state.index" />'
				value='<ww:property value="LowCarbin.Discount" />' /> <input
				type="hidden"
				id='hid_lowyprice_<ww:property value="#state.index" />'
				value='<ww:property value="YPrice" />' /> <input
				type="hidden"
				id='hid_lowseatnum_<ww:property value="#state.index" />'
				value='<ww:property value="LowCarbin.SeatNum" />' /> <input
				type="hidden"
				id='hid_lowcabincode_<ww:property value="#state.index" />'
				value='<ww:property value="LowCarbin.Cabin" />' /> <input
				type="hidden"
				id='hid_lowdeparttime_<ww:property value="#state.index" />'
				value='<ww:property value="formatTimestamp(DepartTime)" />' /> <input
				type="hidden"
				id='hid_lowstartairportname_<ww:property value="#state.index" />'
				value='<ww:property value="StartAirportName" />' /> <input
				type="hidden"
				id='hid_lowstartairport_<ww:property value="#state.index" />'
				value='<ww:property value="StartAirport" />' /> <input
				type="hidden"
				id='hid_lowarrivetime_<ww:property value="#state.index" />'
				value='<ww:property value="formatTimestamp(ArriveTime)" />' /> <input
				type="hidden"
				id='hid_lowendairportname_<ww:property value="#state.index" />'
				value='<ww:property value="EndAirportName" />' /> <input
				type="hidden"
				id='hid_lowendairport_<ww:property value="#state.index" />'
				value='<ww:property value="EndAirport" />' /> <input type="hidden"
				id='hid_lowflightnumber_<ww:property value="#state.index" />'
				value='<ww:property value="Airline" />' /> <input type="hidden"
				id='hid_lowaircompany_<ww:property value="#state.index" />'
				value='<ww:property value="AirCompany" />' /> <input type="hidden"
				id='hid_lowaircompanyname_<ww:property value="#state.index" />'
				value='<ww:property value="getAirCompanyNameByCode(AirCompanyName)" />' />
			<input type="hidden"
				id='hid_lowflighttype_<ww:property value="#state.index" />'
				value='<ww:property value="AirplaneType" />' /> <input
				type="hidden"
				id='hid_lowflightdesc_<ww:property value="#state.index" />'
				value='<ww:property value="AirplaneTypeDesc" />' /> <input
				type="hidden"
				id='hid_lowairportfee_<ww:property value="#state.index" />'
				value='<ww:property value="AirportFee" />' /> <input type="hidden"
				id='hid_lowfuelfee_<ww:property value="#state.index" />'
				value='<ww:property value="FuelFee" />' /> <input type="hidden"
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
				id='hid_zrateid_<ww:property value="#state.index" />'
				value='0' />
				<input type="hidden"
				id='hid_zratevalue_<ww:property value="#state.index" />'
				value='0' />
				
				
			<li class="f btn" style=" padding:0; padding-top:7px;"><input type="button" class="bnt_book fff"
				value="预&nbsp;订" id="book_<ww:property value="#state.index" />"
				onclick='tocreatorder(<ww:property value="#state.index" />,<ww:property value="s_traveltype" />);' /></li>
		</ul>
		<!--所有舱位打开-->
		<div style="display: none"
			id='divallcabin_<ww:property value="#state.index" />'>
			<ww:iterator
			value="Carbins" status="cabState">
			
				<span id="ALLCabin_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">
			
			
			<ul class="rangeall box_botm_xu">
				<li class="mornyall f"><font class="font18f60">&yen;<ww:property
					value="formatMoneyToInt(price)" /></font> <span class="mlr"> <ww:if
					test="Discount>=150.0">头等舱</ww:if> <ww:elseif
					test="Discount>=130.0">商务舱</ww:elseif> <ww:elseif test="Special">特价经济舱</ww:elseif>
				<ww:else>
			经济舱
			</ww:else>(<ww:property value="Cabin" />) </span> <span class="mlr"> <ww:if test="Discount>=100.0">全价</ww:if>
				<ww:else>
					<span
						id="zhe_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>">
					<ww:property value="Discount/10" /> </span>折</ww:else> </span> <b class="ff7f05"> <ww:if
					test="SeatNum.equals(\"9\")">≥9</ww:if> <ww:else>
			 =<ww:property value="SeatNum" />
				</ww:else> </b></li>
				<li class="f" style="width:78px;">
			<dt><ww:property value="AirportFee" />/<ww:property
				value="FuelFee" /></dt>
			<dt><a
					id="a_rules_<ww:property value="#state.index" />_<ww:property value="#cabState.index" />"
					href="javascript:void(0);" class="fontun06c"
					onmouseout="hiderules('<ww:property value="#state.index" />_<ww:property value="#cabState.index" />');"
					; onmouseover="showrules('<ww:property value="#state.index" />_<ww:property value="#cabState.index" />','<ww:property value="rules" />');"
					class="fontun06c">退改签</a>
				<div class="float msg_l" style="display: none">
				<ul class="msgul_l">
					<li class="over box_over_l">退改签规则</li>
					<li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
					<li class="pf5"><b>退票条件：</b></li>
					<li class="pf5"><b>签转条件：</b></li>
				</ul>
				</div></dt>
				</li>
				
				
				<li class="f meal">
				<font class="font18f60">&yen;
				<span id="ALLCabinPrice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>">
				<ww:property
					value="formatMoneyToInt(price)" />
				</span>	
					</font>
				
				</li>
			
				<!--<li class="f meal"><a
					id="a_rules_<ww:property value="#state.index" />_<ww:property value="#cabState.index" />"
					href="javascript:void(0);" class="fontun06c"
					onmouseout="hiderules('<ww:property value="#state.index" />_<ww:property value="#cabState.index" />');"
					; onmouseover="showrules('<ww:property value="#state.index" />_<ww:property value="#cabState.index" />','<ww:property value="rules" />');"
					class="fontun06c">退改签规则</a>
				<div class="float msg_l" style="display: none">
				<ul class="msgul_l">
					<li class="over box_over_l">退改签规则</li>
					<li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
					<li class="pf5"><b>退票条件：</b></li>
					<li class="pf5"><b>签转条件：</b></li>
				</ul>
				</div>
				</li>
				-->
				<li class="f btn"><input type="button" class="bnt_book fff" id="book_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>"
					value="预&nbsp;订"
					onclick="tocreatorder('<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>',<ww:property value="s_traveltype" />);" />
				<input type="hidden"
					id='hid_lowprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="price" />' /> <input type="hidden"
					id='hid_lowdiscount_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Discount" />' /> <input type="hidden"
					id='hid_lowyprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="YPrice" />' /> <input type="hidden"
					id='hid_lowseatnum_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="SeatNum" />' /> <input type="hidden"
					id='hid_lowcabincode_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Cabin" />' /> <input type="hidden"
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
					
					<!-- 新增加政策信息 -->
				<input type="hidden"
				id='hid_zrateid_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
				<input type="hidden"
				id='hid_zratevalue_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
					
					</li>
			</ul>
		</ww:iterator>
		
		</div>
		<!--所有舱位--></div>
	</ww:iterator> 
	</ww:if>
	<ww:else>
	      <ul class="msgul">
	        <li class="over box_over">
		    <font class="f ff7f05">非常抱歉，没有查询到您所查询的航班信息！</font>
		    </li>
		    </ul>
	</ww:else>
	<!-- 航班信息列表 end --> <!-- 隐藏域 --> <input type="hidden"
		name="s_traveltype" value="<ww:property value="s_traveltype" />" /> <input
		type="hidden" name="s_depcityname"
		value="<ww:property value="s_depcityname" />" /> <input type="hidden"
		name="s_depcitycode" value="<ww:property value="s_depcitycode" />" />
	<input type="hidden" name="s_arrcityname"
		value="<ww:property value="s_arrcityname" />" /> <input type="hidden"
		name="s_arrcitycode" value="<ww:property value="s_arrcitycode" />" />
	<input type="hidden" name="s_startdate"
		value="<ww:property value="s_startdate" />" /> <input type="hidden"
		name="s_backdate" value="<ww:property value="s_backdate" />" /> <input
		type="hidden" name="s_aircompanycode"
		value="<ww:property value="s_aircompanycode" />" /> <input
		type="hidden" id="hidtravelflag" name="s_travelflag"
		value="<ww:property value="s_travelflag"/>" /> <input type="hidden"
		id="hidtraveltype" value='<ww:property value="s_traveltype" />' /> <input
		type="hidden" id="hidsegmentinfo"
		value='<ww:property value="s_jasonsegmentinfo" />'
		name="s_jasonsegmentinfo" /> <!-- 隐藏域 -->

	<div class="nohave">&nbsp;</div>
	</div>
	</form>
	<!-- 地图 -->
	<form action="index!ToMap.jspx" name="form4" id="form4"  method="post" target="_blank">
	<input name="s_remarks" value="" id="hidaddress" type="hidden" />
	</form>
	</div>
	<!--列表--></div>
	<!--right over-->
	<div class="c"></div>
	</div>
	<!--container over-->

	<ww:include page="../footer.jsp" />

</ww:i18n>
</body>

</html>
