<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>江苏东方航空旅行社</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/ticket.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />

<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
     function showDiag(diag,flag)
		{
			document.getElementById(diag).style.display=flag;
		}
</script>
<link href="style/autocomplete.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script language="javascript">
	   //按票价排序（升序/降序）
function orderbyprice(){
	arr = new Array();
	var rowscount = $("tr[id*='order_']").length;
	for(i=0;i<rowscount;i++){
		var s = $("tr[id*='order_" + i + "']").html();
		var re = /￥\d{1,5}/i;
		var rs = "" + s.match(re);
		arr[i] = rs.substr(1);
	}
	var orderBy=document.getElementById("hfOrderBy").value;
	if(orderBy=="or1"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 > arr[j] * 2){
				  	var temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    } 
		    }
	    }
	    document.getElementById("hfOrderBy").value="or2";
	    document.getElementById("price_ico").src="images/price_down.gif";
	}else if(orderBy=="or2"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 < arr[j] * 2){
				  	var temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    } 
		    }
	    }
	    document.getElementById("hfOrderBy").value="or1";
	    document.getElementById("price_ico").src="images/price_up.gif";;
	}
	pre = 0;
	var isd=0;
	for(i=0;i<rowscount;i++){
		if(arr[i] == pre) continue;
		pre = arr[i];
		$("tr[id*='order_']:contains('￥" + arr[i] + "')").each(function(){
            aaa = $(this);
            aaa.appendTo($("#ordert"));
		});
		
		
	}
}
function orderbydate(){
	arr = new Array();
	var rowscount = $("tr[id*='order_']").length;
	for(i=0;i<rowscount;i++){
		var s = $("tr[id*='order_" + i + "']").html();
		var re = document.getElementById("pricedate_"+i).value;
		var rs = "" + s.match(re);
		arr[i] = rs;
		
	}
	var orderBy=document.getElementById("hfOrderBydate").value;
	if(orderBy=="or1"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 > arr[j] * 2){
				  	var temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    } 
		    }
	    }
	    document.getElementById("hfOrderBydate").value="or2";
	    document.getElementById("price_icodate").src="images/price_down.gif";
	}else if(orderBy=="or2"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 < arr[j] * 2){
				  	var temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    } 
		    }
	    }
	    document.getElementById("hfOrderBydate").value="or1";
	    document.getElementById("price_icodate").src="images/price_up.gif";
	}
	pre = 0;
	var isd=0;
	for(i=0;i<rowscount;i++){
		if(arr[i] == pre) continue;
		pre = arr[i];
		for(j=0;j<rowscount;j++){
		 if(arr[i]==document.getElementById("pricedate_"+j).value)
		 {
	         aaa = $("#order_"+j);
	         aaa.appendTo($("#ordert"));
         }
        }
		
		
		
	}
}
</script>
</head>

<body>
<form id="form1" name="form1">
<input type="hidden" id="hfOrderBy" value="or1"/>
<input type="hidden" id="hfOrderBydate" value="or1"/>
<div >

<div >


<div   > 

<div class="box">
<div class="quan"><font class="lan14_cu"><ww:property
	value="getCitynameByAirport(flightSearch.StartAirportCode)" />-<ww:property
	value="getCitynameByAirport(flightSearch.EndAirportCode)" />的机票列表</font></div>
<div>
	<jsp:include page="../orderuserinfo.jsp"></jsp:include>
</div>
<div class="xingq" style="height: 70px;width:800px; margin: 0 auto;" ><ww:bean
	name="'com.opensymphony.webwork.util.Counter'" id="counter">
	<ww:param name="'first'" value="1" />
	<ww:param name="'last'" value="7" />
</ww:bean> <ww:iterator value="#counter" status="state">
	<a style="cursor: pointer;" href="airsearch!<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>0">tobookback</ww:if><ww:else>tSearch</ww:else>.action?StartAirportCode=<ww:property value="flightSearch.StartAirportCode"/>&EndAirportCode=<ww:property value="flightSearch.EndAirportCode"/>&FromDate=<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>0"><ww:property value="flightSearch.FromDate" /></ww:if><ww:else><ww:property value="GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate)))"/></ww:else><ww:if test="flightSearch.TravelType.equals(\"2\")">&BackDate=<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>1"><ww:property value="GetDate(flightSearch.BackDate,#state.index-(Calculate(flightSearch.BackDate)>3?3:Calculate(flightSearch.BackDate)))"/></ww:if><ww:else><ww:property value="flightSearch.BackDate" /></ww:else></ww:if>&TravelType=<ww:property value="flightSearch.TravelType" /><ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>0">&HfFligIndex2=<ww:property value="HfFligIndex2" />&issession=-1&HfCabinid=<ww:property value="HfCabinid" /></ww:if>"> <ww:if test="#state.index==(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate))">
		<span
			style="height: 58px; background: #FFF; border-top: 4px solid #36A1EA; border-left: 1px solid #36A1EA; border-right: 1px solid #36A1EA;color: #f48000;">
	</ww:if> <ww:else>
		<span
			style="height: 58px; margin-left: 15px; font-family: 'Lucida Sans Unicode', 'Lucida Grande', sans-serif">
	</ww:else>

	<ul>
		<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>1">
		<li>
		<ww:property
			value="GetDate(flightSearch.BackDate,#state.index-(Calculate(flightSearch.BackDate)>3?3:Calculate(flightSearch.BackDate)))" /></li>
		<li><ww:property
			value="getWeekStr(GetDate(flightSearch.BackDate,#state.index-(Calculate(flightSearch.BackDate)>3?3:Calculate(flightSearch.BackDate))))" /></li>
		</ww:if>
		<ww:else>
		<li>
		<ww:property
			value="GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate)))" /></li>
		<li><ww:property
			value="getWeekStr(GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate))))" /></li>
		</ww:else>
	</ul>
	</span> </a>
</ww:iterator></div>
<div style="padding-left: 30px; padding-top: 5px; line-height: 25px;">
<img src="images/i.gif" align="absmiddle" style="margin-right: 10px;" /><b>航程信息：出发城市：<ww:property
	value="getCitynameByAirport(flightSearch.StartAirportCode)" />&nbsp;到达城市：<ww:property
	value="getCitynameByAirport(flightSearch.EndAirportCode)" />&nbsp;出发日期：<ww:property
	value="flightSearch.FromDate" />&nbsp;<ww:if test="flightSearch.TravelType.equals(\"2\")">返程日期：<ww:property value="flightSearch.BackDate"/></ww:if></b>&nbsp;&nbsp;&nbsp;<font
	class="huang12_c"><a href="#" onclick="orderbyprice()"><img
	id="price_ico" src="images/price_up.gif" />价格排序</a>&nbsp;&nbsp;<a href="#"
	onclick="orderbydate();return false;"><span><img
	id="price_icodate" src="images/price_up.gif" />时间排序</span></a></font></div>
<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>0">
	<div style="margin-top: 10px;"><span style="padding-left: 15px;"><b class="lan_xia">您选择的去程信息是：</b></span></div>
	<div class="hangb " style="margin-top: 10px; background: #DDECF3; border: 2px dashed #f48000; ">
	<ul class="huang12_c" style=" height: 30px; text-align: center; ">
		<li style="width: 20%"><b>航班信息</b></li>
		<li style="width: 27%"><b>抵达时间／机场 </b></li>
		
		<li style="width: 10%"><b>机型</b></li>
		<li style="width: 10%"><b>所选舱位</b></li>
		<li style="width: 30%"><b>价格</b></li>
	</ul>
	<ul style="height: 50px; line-height: 25px; text-align: center;">
		<li style="width: 20%">
		
		<dl
			style="float: left; height: 40px; padding-top: 5px; padding-left: 20px;">
			<img
				src="images/airComlogo/<ww:property value="segmentOne.aircomapnycode" />.gif" />
		</dl>
		<dl>
			<ww:property value="segmentOne.flightnumber" />
		</dl>
		<dl>
			<ww:property value="segmentOne.aircompanyname" />
		</dl>
		</li>
		<li style="width: 27%; text-align: left;"><img src="images/plane1.gif" width="25" height="25" /><span><font
			style="margin: 0 15px 0 20px;"><ww:property
			value="formatTimestampHHmm(segmentOne.departtime)" /></font><ww:property
			value="flightOne.StartAirportName" /></span><br/>
			<img src="images/plane2.gif" width="25" height="25" />
		<span><font style="margin: 0 15px 0 20px;"><ww:property
			value="formatTimestampHHmm(segmentOne.arrivaltime)" /></font><ww:property
			value="flightOne.EndAirportName" /></span></li>
		<li style="width: 10%;">
		<div class="f" style="position: relative; cursor: pointer; margin-left: 20px;"
			onmouseover="showDiag('diag11','block')"
			onmouseout="showDiag('diag11','none')"><font
			style="color: #06F; font-weight: bold; font-size: 14px; border-bottom: 1px dashed #06f; line-height: 40px; z-index: 99"><ww:property
			value="segmentOne.flightmodelnum" /></font>

		<div id="diag11"
			style="display: none; position: absolute; z-index: 99; left: -95px; width: 225px; background: #fff; text-align: left; line-height: 20px;"
			class="box">
		<div
			style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>机型信息</b></div>
		<div style="padding-left: 5px;"><ww:property
			value="subfightimg(getflightmodeldes(segmentOne.flightmodelnum))" /></div>
		</div>
		</div>
		</li>
		<li style="width: 10%; font-size: 14px; line-height: 40px;"><ww:if test="segmentOne.Discount>=150.0">头等舱</ww:if>
			<ww:elseif test="segmentOne.Discount>=130.0">商务舱</ww:elseif>
			<ww:else>经济舱</ww:else></li>
		<li style="width: 30%"><span><b class="huang14_c">￥<ww:property
			value="formatMoney(segmentOne.Price+segmentOne.airportfee+segmentOne.fuelfee)" /></b>（<ww:if test="segmentOne.Discount>=150.0">头等舱</ww:if>
			<ww:elseif test="segmentOne.Discount>=130.0">商务舱</ww:elseif>
			<ww:elseif test="segmentOne.Discount>=100.0">全价</ww:elseif>
			<ww:else><ww:property value="segmentOne.Discount/10" />折</ww:else>）</span>
		<div style=" margin-left: 100px;">
		<div class="f" style="position: relative; cursor: pointer;"
			onmouseover="showDiag('diag10','block')"
			onmouseout="showDiag('diag10','none')"><font
			style="color: #06F; font-weight: bold; font-size: 14px; border-bottom: 1px dashed #06f; line-height: 40px;">退改签</font>

		<div id="diag10"
			style="display: none; position: absolute; z-index: 99; left: -95px; width: 225px; background: #fff; text-align: left; line-height: 20px;"
			class="box">
		<div
			style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签</b></div>
		<div style="padding-left: 5px;"><ww:property
			value="segmentOne.rules" /></div>
		</div>
		</div>

		<input type='hidden' id='hidPriceSin'
			value='<ww:property value="segmentOne.Price" />' /> <input
			type='hidden' id='hidYPriceSin'
			value='<ww:property value="segmentOne.yprice"/>' /> <input
			type='hidden' id='hidairportFeeSin'
			value='<ww:property value="segmentOne.airportfee"/>' /> <input
			type='hidden' id='hidfuelFeeSin'
			value='<ww:property value="segmentOne.fuelfee"/>' /> <input
			type='hidden' id='hidtotalSin'
			value='<ww:property
					value="formatMoney(segmentOne.Price+segmentOne.airportfee+segmentOne.fuelfee)" />' /></div>
		</li>
	</ul>
	</div>
	<div class="c"></div>
	<div><span style="padding-left: 15px;"><b>请您选择返程信息：</b></span></div>
</ww:if> <!--复选项结束-->
<div class="hangb">
<table id="ordert" width="100%">
<thead>
<tr>
<td>
<ul class="huang12_c"
	style="background: #DDECF3; height: 30px; text-align: center;">
	<li style="width: 20%">航班信息</li>
	<li style="width: 27%">抵达时间／机场</li>
	<li style="width: 10%">机型</li>
	<li style="width: 10%">机建/燃油</li>
	<li style="width: 15%">价格</li>
	<li style="width: 5%">余票</li>
	<li style="width: 13%">操作</li>
</ul>
<td>
</tr>
</thead>
<tbody>

<ww:iterator value="listFlightInfoAll" status="state">
<tr id="order_<ww:property value="#state.index"/>">
<td>
	<ul
		style="height: 54px; line-height: 24px; border-top: 1px dashed #999;">
		<li style="width: 20%">
		<dl
			style="float: left; height: 40px; padding-top: 5px; padding-left: 20px;">
			<img src="images/airComlogo/<ww:property value="AirCompany" />.gif" />
		</dl>
		<dl>
			<ww:property value="Airline" />
		</dl>
		<dl>
			<ww:property value="AirCompanyName" />
		</dl>
		</li>
		<input type="hidden" id="pricedate_<ww:property value="#state.index"/>" value="<ww:property value="formatTimestamporderbydate(DepartTime)" />"/>
		<li style="width: 27%; text-align: left;"><img src="images/plane1.gif" width="25" height="25" /><span><font
			style="margin: 0 15px 0 20px;"><ww:property
			value="formatTimestampHHmm(DepartTime)" /></font><ww:property
			value="StartAirportName" /></span><br/> <img src="images/plane2.gif" width="25" height="25" /><span><font
			style="margin: 0 15px 0 20px;"><ww:property
			value="formatTimestampHHmm(ArriveTime)" /></font><ww:property
			value="EndAirportName" /></span></li>
		<li style="width: 10%; text-align: center;">
		<div    style=" cursor: pointer;"
			onmouseover="showDiag('diag<ww:property value="#state.index"/>','block')"
			onmouseout="showDiag('diag<ww:property value="#state.index"/>','none')"><font
			style="color: #06F; font-weight: bold; font-size: 14px; border-bottom: 1px dashed #06f; line-height: 40px;"><ww:property
			value="AirplaneType" /></font>
			<div style="position: relative;z-index: 9999999999999;">

		<div id="diag<ww:property value="#state.index"/>"
			style="display: none; position: absolute; z-index: 9999999999999999999; left: 0px; width: 225px; background: #fff; text-align:center; line-height: 20px;"
			class="box">
		<div
			style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>机型信息</b></div>
		<div style="padding: 5px; height:64px; text-align: left; "><ww:property
			value="subfightimg(AirplaneTypeDesc)" /> 
			
			</div>
			
		</div>
		</div>
		</div>

		</li>
		<li style="width: 10%; font-size: 14px; line-height: 40px; text-align: center;"><ww:property
			value="AirportFee" />/<ww:property value="FuelFee" /></li>
		<li style="width: 15%; text-align: center;"><span><b class="huang14_c">￥<ww:property
			value="LowCarbin.price" /></b>(
			
			<ww:if test="LowCarbin.Discount>=100.0">全价</ww:if>
			<ww:else><ww:property value="LowCarbin.Discount/10" />折</ww:else>)</span>
		<span>
		<div class="f" style=" cursor: pointer;z-index: 11;"
			onmouseover="showDiag('diag2<ww:property value="#state.index"/>','block')"
			onmouseout="showDiag('diag2<ww:property value="#state.index"/>','none')"><font
			style="color: #06F; border-bottom: 1px dashed #06f;">退改签</font>
			<div  style="position: relative;">

		<div  id="diag2<ww:property value="#state.index"/>"
			style="display: none; position: absolute; z-index: 99; left: -95px; width: 225px; background: #fff; left: 0px; text-align: left; line-height: 20px;"
			class="box">
		<div
			style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7;z-index: 99; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签规定</b></div>
		<div style="padding-left: 5px;"><ww:property value="LowCarbin.CabinRules" /></div>
			
		</div>
		</div>
		</div>
		<div class="r" style="padding-right: 40px;">&nbsp;<a href="#"
			style="color: #06F; border-bottom: 1px dashed #06f;"
			onclick="showCabins(<ww:property value="#state.index"/>);return false;">其他仓位</a>
		</div>
		<div class="c"></div>
		</span></li>
		<li style="width: 5%;text-align: center; line-height:40px;"><ww:if test="LowCarbin.SeatNum.equals(\"9\")">≥9
								</ww:if>
								<ww:else>
								<ww:property value="LowCarbin.SeatNum"/>
								</ww:else></li>
		<li style="width: 13%; padding-top: 10px; text-align: center;"><ww:if
			test="isBackOrTo==1">
			<a
				href="javascript:gotoBookto(1,<ww:property value="#state.index"/>,-1)">
			<img src="images/gouml.gif" border="none" /> </a>
		</ww:if> <ww:else>
			<a
				href="javascript:gotoBookback(1,<ww:property value="#state.index"/>,-1)">
			<img src="images/gouml.gif" border="none" /> </a>
		</ww:else></li>

	</ul>
	<div id="air_<ww:property value="#state.index"/>"
		style="display: none;">
	<div><img src="images/jipiao_sanjiao1.gif"
		style="margin-left: 520px;" /></div>
	<div
		style="border: 1px solid #909090; float: right; margin-top: -7px; width: 626px;">
	<div style="border: 3px solid #F2F2F2; float: right; width: 620px;">
	<div style="float: right;"><img style="cursor: pointer"
		onclick="showCabins(<ww:property value="#state.index"/>)"
		src="images/xx.gif" /></div>
	<div class="c"></div>
	<table width="620" border="0">
		<thead>
			<tr>
				<th width="20%">舱位名称</th>
				<th width="20%">舱位折扣</th>
				<th width="10%">余票</th>
				<th width="30%">价格</th>
				<th width="15%">操作</th>
			</tr>
		</thead>
		<tr>
			<td colspan="5">
			<hr
				style="border-bottom: 1px solid #909090; height: 1px; border-top: none; border-left: none; border-right: none" />
			</td>
		</tr>
		<tbody align="center">
			<ww:iterator value="Carbins" status="cabState">
				<tr>
					<td><ww:if test="Discount>=150.0">头等舱</ww:if>
			<ww:elseif test="Discount>=130.0">商务舱</ww:elseif>
			<ww:else>经济舱</ww:else>
			</td>
					<td>
			<ww:if test="Discount>=100.0">全价</ww:if>
			<ww:else><ww:property value="Discount/10" />折</ww:else>/<ww:property value="cabin" /></td>
					<td style="line-height: 14px;" align="center"><ww:if test="SeatNum.equals(\"9\")">
									≥9
								</ww:if>
								<ww:else>
								<ww:property value="SeatNum"/>
								</ww:else></td>
					<td><ww:property value="Price" /></td>
					<td><ww:if test="isBackOrTo==1">
						<a
							href="javascript:gotoBookto(2,<ww:property value="#state.index"/>,<ww:property value="#cabState.index"/>)">
						<img src="images/gouml.gif" border="none" /> </a>
					</ww:if> <ww:else>
						<a
							href="javascript:gotoBookback(2,<ww:property value="#state.index"/>,<ww:property value="#cabState.index"/>)">
						<img src="images/gouml.gif" border="none" /> </a>
					</ww:else></td>
				</tr>
				<tr>
					<td colspan="5" style="height: 8px;">
					<hr
						style="border-bottom: 1px dashed #909090; border-top: none; border-left: none; border-right: none; height: 1px;" />
					</td>
				</tr>
			</ww:iterator>
		</tbody>
	</table>
	</div>
	</div>
	<div class="c" style="height: 10px; line-height: 10px;">&nbsp;</div>
	</div>
	</td>
</tr>
</ww:iterator>
</tbody>
</table>
</div>
<!--航班信息结束--></div>

</div>

</div>
<input type="hidden" id="HfFligIndex" name="s_HfFligIndex"
	value="<ww:property value="s_HfFligIndex"/>" /> <input type="hidden"
	id="HfFligIndex2" name="HfFligIndex2"
	value="<ww:property value="HfFligIndex2"/>" /> <input type="hidden"
	id="HfFligID" value="<ww:property value="HfFligID"/>" /> <input
	type="hidden" id="HfCabinid" name="HfCabinid"
	value="<ww:property value="HfCabinid"/>" /> <input type="hidden"
	id="HfCabinid2" name="HfCabinid2"
	value="<ww:property value="HfCabinid2"/>" /> <input type="hidden"
	id="HfCustomerID" /> <input type="hidden" id="hfOrderBy" />


</div>
</form>
<jsp:include page="search.jsp"></jsp:include>
</body>
</html>
<script type="text/javascript">    
//单程预订按钮点击
     //返程预订按钮点击
     function gotoBookback(obj,index,cabinid)
     {
          var HfFligIndex=document.getElementById("HfFligIndex2");
	     var HfCabinid=document.getElementById("HfCabinid2");
	     var HfFligID=document.getElementById("HfFligID");
	     
	     if(obj=="1")
	      {
	         HfFligIndex.value="order_"+index;

	      }
	      else if(obj=="2")
	      {
	        HfFligIndex.value="cabin_"+index;
	        HfCabinid.value=cabinid;
	      }
	      document.form1.action="airsearch!tobookback.action";
     	  document.form1.submit();
     }
     //单程预订按钮点击
     function gotoBookto(obj,index,cabinid)
     { 
        var HfFligIndex=document.getElementById("HfFligIndex");
	     var HfCabinid=document.getElementById("HfCabinid");
	     var HfFligID=document.getElementById("HfFligID");
	     
	     
	     if(obj=="1")
	      {
	         HfFligIndex.value="order_"+index;

	      }
	      else if(obj=="2")
	      {
	        HfFligIndex.value="cabin_"+index;
	        HfCabinid.value=cabinid;
	      }
	      
	      document.form1.action="airsearch!tocreateorder.action";
     	  document.form1.submit();
      }
    
 function showCabins(flightid) {
      	var cabtr = document.getElementById("air_" + flightid);
      	if (cabtr.style.display == "block") {
      		cabtr.style.display="none";
      	} else {
      		cabtr.style.display="block";
      		
      	}
    }    
</script>
