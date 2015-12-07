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
<title>航班列表</title>
<link href="skin/blue/css/b2blist.css" rel="stylesheet" />
<link href="skin/blue/css/tip.css" rel="stylesheet" type="text/css" />
<link href="style/airco.css" rel="stylesheet" type="text/css" />
<link href="js/city-control/base.css" rel="stylesheet" />
<script type="text/javascript" src="js/city-control/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/city-control/jquery.poshytip.js"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/city-control/list.js"></script>
<script src="js/city-control/jquery.elementsorter.js" type="text/javascript"></script>
<script src="js/jason/json2.js" type="text/javascript"></script>
<link href="skin/blue/css/public.css" rel="stylesheet" />

<script type="text/javascript" language="javascript">
   //加载最低价格航线政策信息
   $(document).ready(function()
   {
      $("span[id*='low_zratevalue_']").each(function(i){
     
        $.ajax({
	         type:"POST",
	         url:"demosticticket!getFlightZrate.action",
	         data:{s_depcitycode:$("#hiddepcitycode").val(),s_arrcitycode:$("#hidarrcitycode").val(),s_startdate:$("#hidotherday").val(),s_aircompanycode:$("#hid_lowaircompany_"+i).val(),s_flightnumber:$("#hid_lowflightnumber_"+i).val(),s_cabincode:$("#hid_lowcabincode_"+i).val(),z_price:$("#hid_lowparvalue_"+i).val()},
	         beforeSend:function(){$("#low_zratevalue_"+i).html("<img src='images/loadding.gif' />")},             
	         success:function(data){
	         	var price=$("#hidz_price_"+i).val();
	            if(data.split('|').length>0)
	            {
	              $("#low_zratevalue_"+i).html(data.split('|')[0]);
	              $("#low_zrateprice_"+i).html(data.split('|')[2]);
	              $("#hid_lowprice_"+i).val(data.split('|')[1]);
	              $("#hid_lowratevalue_"+i).val(data.split('|')[3]);
	              $("#hid_lowzrateid_"+i).val(data.split('|')[4]);
	              $("#hid_lowisspecial_"+i).val(data.split('|')[5]);
	              $("#low_totalpayprice_"+i).html(parseFloat(data.split('|')[1])+parseFloat($("#hid_lowairportfee_"+i).val())+parseFloat($("#hid_lowfuelfee_"+i).val()));
	            }
	         }            
	         });
       });
   });
   
   //加载其他舱位的政策信息
   //查询航班序号=index， flag=是否查询特价政策 1=查，0不查
   function getOtherZrate(index,flag)
   {
       //加载其他舱位政策
       var name="othercabin_zrateprice_"+index+"_";
       $("span[id*='"+name+"']").each(function(i){
	       if(flag==1)
	       {
		       if($("#hid_lowprice_"+index+"_"+i).val()!="0.0")
		       {
		         $.ajax({
		         type:"POST",
		         url:"demosticticket!getFlightZrate.action",
		         data:{s_depcitycode:$("#hiddepcitycode").val(),s_arrcitycode:$("#hidarrcitycode").val(),s_startdate:$("#hidotherday").val(),s_aircompanycode:$("#hid_lowaircompany_"+index+"_"+i).val(),s_flightnumber:$("#hid_lowflightnumber_"+index+"_"+i).val(),s_cabincode:$("#hid_lowcabincode_"+index+"_"+i).val(),z_price:$("#hid_lowparvalue_"+index+"_"+i).val()},
		         beforeSend:function(){$("#othercabin_zrateprice_"+index+"_"+i).html("<img src='images/loadding.gif' />")},             
		         success:function(data){
		            if(data.split('|').length>0)
		            {
		              $("#othercabin_zratevalue_"+index+"_"+i).html(data.split('|')[0]);
		              $("#othercabin_zrateprice_"+index+"_"+i).html(data.split('|')[2]);
		              $("#otherpayprice_"+index+"_"+i).html(data.split('|')[1]);
		              $("#hid_lowprice_"+index+"_"+i).val(data.split('|')[1]);
		              $("#hid_lowprice_"+index+"_"+i).val(data.split('|')[1]);
	                  $("#hid_lowratevalue_"+index+"_"+i).val(data.split('|')[3]);
	                  $("#hid_lowzrateid_"+index+"_"+i).val(data.split('|')[4]);
	                  $("#hid_lowisspecial_"+index+"_"+i).val(data.split('|')[5]);
		      
		           }
		         }            
	              });
			   }
	        }
	        else if(flag==0)
	        {
	           if($("#hid_lowprice_"+index+"_"+i).val()!="0.0")
		       {
		        $.ajax({
                type:"POST",
                url:"demosticticket!getFlightZrate.action",
                data:{s_depcitycode:$("#hiddepcitycode").val(),s_arrcitycode:$("#hidarrcitycode").val(),s_startdate:$("#hidotherday").val(),s_aircompanycode:$("#hid_lowaircompany_"+index+"_"+i).val(),s_flightnumber:$("#hid_lowflightnumber_"+index+"_"+i).val(),s_cabincode:$("#hid_lowcabincode_"+index+"_"+i).val(),z_price:$("#hid_lowparvalue_"+index+"_"+i).val()},
                beforeSend:function(){$("#othercabin_zratevalue_"+index+"_"+i).html("<img src='images/loadding.gif' />")},             
                success:function(data){
                if(data.split('|').length>0)
                {
	              $("#othercabin_zratevalue_"+index+"_"+i).html(data.split('|')[0]);
	              $("#othercabin_zrateprice_"+index+"_"+i).html(data.split('|')[2]);
	              //$("#price_"+index+"_"+i).html(data.split('|')[1]);
	              $("#hid_lowprice_"+index+"_"+i).val(data.split('|')[1]);
	              $("#hid_lowprice_"+index+"_"+i).val(data.split('|')[1]);
                  $("#hid_lowratevalue_"+index+"_"+i).val(data.split('|')[3]);
                  $("#hid_lowzrateid_"+index+"_"+i).val(data.split('|')[4]);
                  $("#hid_lowisspecial_"+index+"_"+i).val(data.split('|')[5]);
	              $("#otherpayprice_"+index+"_"+i).html(parseFloat(data.split('|')[1])+parseFloat($("#hid_lowairportfee_"+index).val())+parseFloat($("#hid_lowfuelfee_"+index).val()));
               }
               }            
               });
		       }
	        }
	       });  
   }
</script>
</head>

<body>
<div id="list">
<div class="list_box">

<div class="list_top font-fff"><font class="f"><ww:property
	value="s_depcityname" />到<ww:property value="s_arrcityname" />的航班</font> <span
	class="r"><span class="tips">&nbsp;</span>
友情提示：由于航空公司折扣及价格经常变动，预订价格按照PAT为准。</span></div>

<div class="week">
<form action="demosticticket!toTicketList.action" name="form3" id="form3" method="POST">
<ul id='uldate'>
	<ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
		<ww:param name="'first'" value="1" />
		<ww:param name="'last'" value="7" />
	</ww:bean>
	<ww:iterator value="#counter" status="state">
		<ww:if test="s_travelflag==1">
			<li
				<ww:if test='compareandselectTab(s_startdate,GetDate(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate))))'>class="f weekon"</ww:if>
				<ww:else>class="f weekout"</ww:else> onclick=""><span
				style="cursor: hand"
				onclick="loading('正在查询航班信息');searchotherday('<ww:property value="GetDate(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)))" />');">
			<dt><ww:property
				value="GetDateMMdd(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)),0)" />
			</dt>
			<dt class="fff"><ww:property
				value="GetDateMMdd(s_startdate,#state.index-(Calculate(s_startdate)>3?3:Calculate(s_startdate)),1)" /></dt>
			</span></li>
		</ww:if>
		<ww:elseif test="s_travelflag==2">

			<li
				<ww:if test='compareandselectTab(s_backdate,GetDate(s_backdate,#state.index-(Calculate(s_backdate)>3?3:Calculate(s_backdate))))'>class="weektabon f  "</ww:if>
				<ww:else>class="f weekout"</ww:else> onclick=""><span
				style="cursor: hand"
				onclick="loading('正在查询航班信息');searchotherday('<ww:property value="GetDate(s_backdate,#state.index-(Calculate(s_backdate)>3?3:Calculate(s_backdate)))" />');">
			<dt><ww:property
				value="GetDateMMdd(s_backdate,#state.index-(Calculate(s_backdate)>3?3:Calculate(s_backdate)),0)" />
			</dt>
			<dt class="dcff58">&yen;<ww:property
				value="GetDateMMdd(s_backdate,#state.index-(Calculate(s_backdate)>3?3:Calculate(s_backdate)),1)" /></dt>
			</span></li>
			</if>
		</ww:elseif>
	</ww:iterator>
	<li class="c"></li>
</ul>
<input type="hidden" value="<ww:property value="s_depcitycode" />" id="hiddepcitycode"
		name="s_depcitycode" /> <input type="hidden" id="hidarrcitycode"
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
</form>
</div>



<div class="fligt font-000" ><!--往返订单第一程信息-->

<div class="nohave"></div>

<div class="msg" <ww:if test="listsegmentinfo.size()==0" >style='display:none'</ww:if>>
<ww:iterator value="listsegmentinfo">
<ul class="msgul">

	<li class="over box_over">
	<b>已选择的<ww:if
				test="s_traveltype==2">去程</ww:if><ww:elseif test="s_traveltype==3">第一程</ww:elseif>航班</b>
			<span class="mlr15"><ww:property value="s_depcityname" />→ <ww:property
				value="s_arrcityname" /></span>出发日期：<ww:property value="s_startdate" />
	</li>

	<li>

	<ul class="range">

		<li class="overmorny f"><font class="font-bdb0000"><ww:property
					value="formatMoneyToInt(price)" /></font>元<span
			class="mfr5"><ww:if
					test="discount>=150.0">头等舱</ww:if> <ww:elseif
					test="discount>=130.0">商务舱</ww:elseif> <ww:elseif test="isspecial">特价经济舱</ww:elseif>
				<ww:else>经济舱</ww:else></span></li>

		<li class="f airport">

		<dt><ww:property value="formatTimestampHHmm(departtime)" /> <ww:property
					value="startairportname" /></dt>

		<dt><ww:property value="formatTimestampHHmm(arrivaltime)" /> <ww:property
					value="endairportname" /></dt>

		</li>

		<li ></li>

		<li class="f model">
		<dt><span class='airco_<ww:property value="aircomapnycode" />'></span><ww:property value="airname" /><ww:property
					value="flightnumber" /></dt>

		<dt>机型<a id="a_flightdesc_selected" href="javascript:void(0);"
					class="font-3797f1" class="fontun06c"><ww:property
					value="flightmodel" /></a><ww:property
					value="getFlightModel(flightmodel)" /></dt>

		</li>

		<li class="f fuel"><ww:property
					value="formatMoneyToInt(airportfee)" />/<ww:property
					value="formatMoneyToInt(fuelfee)" /></li>

		<li class="f meal"><a id="a_rules_selected"
					href="javascript:void(0);" class="font-3797f1"
					onmouseout="hiderules('selected');"
					; onmouseover="showrules('selected','<ww:property value="rules" />');"
					class="fontun06c">退改签规则</a>
		</li>

		<li class="f mealer"><font class="font-db0000 mf20"><ww:property
					value="formatMoneyToInt(price+airportfee+fuelfee)" /></font>元(含税费)</li>

		<li class="f btn"><input type="button" class="bnt_refrec mt7"
			value="重新预订" /></li>

	</ul>

	</li>

</ul>
</ww:iterator>
</div>

<!--往返订单第一程信息-->

<div class="pf15">
<ww:if
		test="s_traveltype==1">单程</ww:if><ww:elseif
		test="s_traveltype==2">往返</ww:elseif><ww:elseif
		test="s_traveltype==3">联程</ww:elseif>
    <font class="mfr5">|</font>出发：<ww:property
	value="s_depcityname" /><font
	class="mfr5">|</font>到达：<ww:property value="s_arrcityname" /><font class="mfr5">|</font>出发时间：<ww:property value="s_startdate" /><font
	class="mfr5">|</font><font class="font-f60">(共<ww:property value="listFlightInfoAll.size()" />个航班)</font><font
	class="mfr5">|</font>
	<select id="ddlsort" onchange="sortflightlist();">
		<option value="timeasc">出发时间从早到晚</option>
		<option value="timedesc">出发时间从晚到早</option>
		<option value="priceasc">价格从低到高</option>
		<option value="pricedesc">价格从高到低</option>
	</select>
	</div>

</div>

<form name="form2" id="form2">

<div class="nav_list font-fff">
<ul>
	<li class="f" style="width: 12%; text-align: right;">航空公司/机型</li>

	<li class="f" style="width: 20%">出发/到达</li>

	<li class="f" style="width: 20px;">&nbsp;</li>

	<li class="f" style="width: 10%">票面价</li>

	<li class="f" style="width: 11%">总票价（机建/燃油）</li>

	<li class="f" style="width: 11%">返点&nbsp;&nbsp;&nbsp;</li>

	<li class="f" style="width: 13%">总结算价（含机建燃油）</li>
	
	<li class="f" style="width: 10%">退改签</li>

	<li class="f pf15">操作</li>

</ul>
</div>
<div class="nohave5"></div>
<div id="div_flightlist">
<ww:if test="listFlightInfoAll.size()>0">
	<ww:iterator value="listFlightInfoAll" status="state">
		<div class="list_table" id="divlowprice_<ww:property value="#state.index" />">
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="list_table">
			<tr>
				<td width="13%" align="right"><span
					class='airco_<ww:property value="AirCompanyName" />'
					></span> <font class="font-18"><ww:property
					value="getAirCompanyNameByCode(AirCompanyName)" /><ww:property
					value="Airline" /></font>
				<span
			style="display: none" class="timeOfColnum"><ww:property
			value="formatTimestampHHmm(DepartTime)" /></span>
			<span style="display: none" class="priceOfColnum"><ww:property
			value="formatMoneyToInt(LowCarbin.price)" /></span>	
				</td>
				<td width="20">&nbsp;</td>
				<td width="20%"><ww:property
					value="formatTimestampHHmm(DepartTime)" /> <ww:property
					value="StartAirportName" /></td>
				<td width="11%"><font class="font-bdb0000">&yen;<ww:property
					value="formatMoneyToInt(LowCarbin.price)" /></font>元</td>
				<td width="10%"><font class="font-bdb0000">&yen;<ww:property
					value="formatMoneyToInt(LowCarbin.price+AirportFee+FuelFee)" /></font></td>
				<!-- 政策返点 -->
				<td width="10%" class="pt19" rowspan="2"><font
					class="font-ff893b"><span id="low_zratevalue_<ww:property value="#state.index" />">0</span></font>
				</td>
				<!-- 政策返点 -->
				<!-- 总结算价 -->
				<td width="13%" rowspan="2" class="pt19"><font
					class="font-db0000 mf20"><span id="low_totalpayprice_<ww:property value="#state.index" />"><ww:property
					value="formatMoneyToInt(LowCarbin.price+AirportFee+FuelFee)" /></span></font>元</td>
				<!-- 总结算价 -->
				<td width="10%" rowspan="2" class="pt19"><a class="font-3797f1"
					id="a_rules_<ww:property value="#state.index" />"
					href="javascript:void(0);"
					onmouseout="hiderules('<ww:property value="#state.index" />');"
					; onmouseover="showrules('<ww:property value="#state.index" />','<ww:property value="rules" />');">退改签规定</a>

				    <input
					type="hidden"
					id='hid_lowdiscount_<ww:property value="#state.index" />'
					value='<ww:property value="LowCarbin.Discount" />' /> <input
					type="hidden"
					id='hid_lowyprice_<ww:property value="#state.index" />'
					value='<ww:property value="YPrice" />' /> <input type="hidden"
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
				  <!-- 政策 -->
				  <!-- 票面价 -->
				  <input type="hidden"
					id='hid_lowparvalue_<ww:property value="#state.index" />'
					value='<ww:property value="LowCarbin.price" />' />
				  <!-- 返点 -->
				  <input type="hidden"
					id='hid_lowratevalue_<ww:property value="#state.index" />'
					value='0' />
				<input type="hidden"
					id='hid_lowisspecial_<ww:property value="#state.index" />'
					value='1' />
				  <!-- 政策id -->
				  <input type="hidden"
					id='hid_lowzrateid_<ww:property value="#state.index" />'
					value='' /> 
				  <!-- 结算价 -->
				  <input type="hidden"
					id='hid_lowprice_<ww:property value="#state.index" />'
					value='<ww:property value="LowCarbin.price" />' />
				  <!-- 政策 -->
				</td>
				
				<td>
				<input type="button" class="bnt_booking"
				value=""
				onclick='tocreatorder(<ww:property value="#state.index" />,<ww:property value="s_traveltype" />);' />
				</td>
			</tr>
			<tr>
				<td align="right">机型：<a
					id="a_flightdesc_<ww:property value="#state.index" />"
					href="javascript:void(0);" class="font-un06c"
					onmouseout="hideflightdesc('<ww:property value="#state.index" />');"
					; onmouseover="showflightdesc('<ww:property value="#state.index" />');"
					class="fontun06c"><ww:property value="AirplaneType" /></a><ww:property
					value="getFlightModel(AirplaneType)" /></td>

				<td width="20">&nbsp;</td>

				<td><ww:property value="formatTimestampHHmm(ArriveTime)" /> <ww:property
					value="EndAirportName" /></td>

				<td></td>

				<td>(<ww:property value="AirportFee" />/<ww:property value="FuelFee" />)</td>

				<td><a id="linkshowcabin_<ww:property value="#state.index" />"
					href="javascript:void(0);"
					onclick='showallcabin(<ww:property value="#state.index" />);'
					class="font-3797f1">所有舱位↑</a></td>

			</tr>

			<tr>

				<td align="right" class="font-f00"><ww:if
					test="LowCarbin.Discount>=150.0">头等舱</ww:if> <ww:elseif
					test="LowCarbin.Discount>=130.0">商务舱</ww:elseif> <ww:elseif
					test="LowCarbin.Special">特价经济舱</ww:elseif> <ww:else>经济舱</ww:else>[<ww:property
					value="LowCarbin.Cabin" />]&nbsp;</td>

				<td width="20">&nbsp;</td>

				<td>剩余票数：<ww:if test="LowCarbin.SeatNum.equals(\"9\")">≥9</ww:if>
				<ww:else>=<ww:property value="LowCarbin.SeatNum" />
				</ww:else></td>

				<td></td>

				<td>&nbsp;</td>
                <!-- 政策利润 -->
				<td>利润：<font class="font-ff8"><span id="low_zrateprice_<ww:property value="#state.index" />">0</span>元</font></td>
                <!-- 政策利润 -->
				<td>&nbsp;</td>

				<td></td>

				<td>&nbsp;</td>

			</tr>

		</table>


		<div class="nohave5"></div>
		
		<div class="box_top" style="display: none"
			id='divallcabin_<ww:property value="#state.index" />'>

		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="orter">

			<tr>

				<th width="20">&nbsp;</th>

				<th width="10%">舱位</th>

				<th width="6%">折扣</th>

				<th width="6%">余票</th>

				<th width="9%">票面价</th>

				<th width="12%">总票价(机建/燃油)</th>

				<th width="13%">返点</th>

				<th width="9%">利润</th>

				<th width="11%">结算价</th>

				<th width="8%">退改签规定</th>

				<th>预订</th>

			</tr>
			<ww:iterator value="Carbins" status="cabState">
				<tr>
					<td>&nbsp;</td>

					<td><span class="mlr"> <ww:if test="Discount>=150.0">头等舱</ww:if>
					<ww:elseif test="Discount>=130.0">商务舱</ww:elseif> <ww:elseif
						test="Special">特价经济舱</ww:elseif> <ww:else>
			经济舱
			</ww:else>[<ww:property value="Cabin" />]</font></td>
					<td><ww:if test="Discount>=100.0">全价</ww:if> <ww:else>
						<span
							id="zhe_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>">
						<ww:property value="Discount/10" /> </span>折</ww:else> </span></td>


					<td><ww:if test="SeatNum.equals(\"9\")">≥9</ww:if> <ww:else>
			 =<ww:property value="SeatNum" />
					</ww:else></td>

					<td><font class="font-bdb0000">&yen;<ww:property
						value="formatMoneyToInt(price)" /></font>元</td>

					<td><font class="font-ff8"><ww:property
						value="formatMoneyToInt(price+AirportFee+FuelFee)" /></font>元(<ww:property
						value="AirportFee" />/<ww:property value="FuelFee" />)</td>
                    <!-- 所有舱位返点值 -->
					<td align="center"><font class="font-ff893b"><span id="othercabin_zratevalue_<ww:property value="#state.index" />_<ww:property value="#cabState.index" />">0</span></font></td>
                    <!-- 所有舱位返点值 -->
                    <!-- 所有舱位利润 -->
					<td><font class="font-db0000"><span id="othercabin_zrateprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index" />">0</span></font>元</td>
                    <!-- 所有舱位利润 -->
					<td><font class="font-db0000">&yen;<span id="otherpayprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index" />"><ww:property
						value="formatMoneyToInt(price+AirportFee+FuelFee)" /></span></font>元</td>

					<td><a class="font-3797f1"
						id="a_rules_<ww:property value="#state.index" />_<ww:property value="#cabState.index" />"
						href="javascript:void(0);" class="fontun06c"
						onmouseout="hiderules('<ww:property value="#state.index" />_<ww:property value="#cabState.index" />');"
						; onmouseover="showrules('<ww:property value="#state.index" />_<ww:property value="#cabState.index" />','<ww:property value="rules" />');"
						class="fontun06c">退改签规定</a></td>

					<td><input type="button" class="bnt_booking"  onclick="tocreatorder('<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>',<ww:property value="s_traveltype" />);" />
					<input type="hidden"
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
					<!-- 政策 -->
				  <!-- 票面价 -->
				  <input type="hidden"
					id='hid_lowparvalue_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="LowCarbin.price" />' />
				  <!-- 返点 -->
				  <input type="hidden"
					id='hid_lowratevalue_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='0' />
				<input type="hidden"
					id='hid_lowisspecial_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='1' />
				  <!-- 政策id -->
				  <input type="hidden"
					id='hid_lowzrateid_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='' /> 
				  <!-- 结算价 -->
				  <input type="hidden"
					id='hid_lowprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="price" />' />
				  <!-- 政策 -->
					</td>

				</tr>
			</ww:iterator>
		</table>

		</div>

		<div class="nohave5 box_top"></div>
		</div>
	</ww:iterator>
	
</ww:if>
<ww:else>
	<div class="list_table">
	<div class="nohave5"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="list_table">
	  <tr><td align="center"><b><font class="font-ff8">非常抱歉，没有查询到您所查询的航班信息！</font></b></td></tr>
	</table>
	</div>
</ww:else>
<input type="hidden"
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
		name="s_jasonsegmentinfo" />
</div>

</form>

</div>
</div>
</body>
</html>


