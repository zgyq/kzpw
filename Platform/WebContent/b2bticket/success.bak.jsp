<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/hotel.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
<script language="javascript"> 
function copyToClipboard(theField,isalert)
{
  if(theField!="")
  {
    var clipBoardContent=theField;
    //obj.select();
    window.clipboardData.setData("Text",clipBoardContent); 
    if(isalert!=false)
      alert("复制成功。现在您可以粘贴（Ctrl+v）到其他地方了。");
  }
  else
  {
     alert("Error!");
  }
}
</script>
</head>
<body>
<div>


<div>

<div>

<div class="box" style="text-align: center; line-height: 22px;">
<ul>
	<li><img src="images/dui.gif" width="51" height="43" /><b>您的预订已成功!</b><br />
	请您及时付款，以免耽误您的行程!</li>
</ul>

</div>
<div class="huang">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:15px;color:#fff">◆</span><b class="bai_c">订单信息-订单号：<ww:property
	value="getorderbyid(idtemp).ordernumber" />&nbsp;&nbsp;<ww:if
	test="orderinfo.id!=idtemp">
	<ww:property value="orderinfo.ordernumber" />
</ww:if></b></div>

<div class="box" style="padding-top: 10px;">
<ww:if test="orderinfo.id!=idtemp">
<div style=" border: 1px solid #000;width:90%; margin: 0 auto; ">
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>
			<td width="100">航班号</td>
			<td>航空公司</td>
			<td>起飞机场</td>
			<td>到达机场</td>
			<td>起飞时间</td>
			<td>到达时间</td>
		</tr>
	</tbody>
	<ww:iterator value="listSegment2" status="t">
		<tr>
			<td><ww:property value="flightnumber" /></td>
			<td><ww:property value="getAircomapnycodeByEZM(aircomapnycode)" /></td>
			<td><ww:property value="getAirportbySZM(startairport)" /></td>
			<td><ww:property value="getAirportbySZM(endairport)" /></td>
			<td><ww:property value="formatTimestamp(departtime)" /></td>
			<td><ww:property value="formatTimestamp(arrivaltime)" /></td>
		</tr>
	</ww:iterator>
</table>
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>
			<td width="100">订单号</td>
			<td>PNR</td>
			<td>大PNR</td>

			<td width="90">总票面结算价</td>
			<td width="60">总燃油费</td>
			<td width="60">总机建费</td>
			<!-- <td width="60">总保险费</td>-->
			<td width="100">订单总额</td>
		</tr>
	</tbody>
	<tr>
		<td><ww:property value="orderinfo2.ordernumber" /></td>
		<td><a href="#"
			onclick="javascript:copyToClipboard('<ww:property value="orderinfo2.pnr"/>',true);"><ww:property
			value="orderinfo2.pnr" /></a></td>
		<td><a href="#"
			onclick="javascript:copyToClipboard('<ww:property value="orderinfo2.bigpnr"/>',true);"><ww:property
			value="orderinfo2.bigpnr" /></a></td>
		
		<td><ww:property value="formatMoney(orderinfo2.totalticketprice)" /></td>
		<td><ww:property value="orderinfo2.totalfuelfee" /></td>
		<td><ww:property value="orderinfo2.totalairportfee" /></td>
		<!-- <td><ww:property value="getsuminsurance(orderinfo2.insurance)" /></td>-->
		<td style="color:red;font-weight:bold">￥<ww:property
			value="formatMoney(orderinfo2.orderprice)" /></td>
	</tr>
</table>
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
			bordercolor="#86B2D1"
			style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
			<tbody bgcolor="#DDECF3" style="color: #999;">
				<tr>
					<td width="100">姓名</td>
					<td>乘机人类型</td>
					<td>证件号/出生日期</td>
					<td width="90">票面结算价</td>
					
					<td width="60">燃油费</td>
					<td width="60">机建费</td>
					
					<td width="60">保险费</td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</tbody>
			<ww:iterator value="listPassenger2" status="t">
				<tr>
					<td><ww:property value="name" /></td>
					<td><ww:if test="ptype==1">成人</ww:if> <ww:if test="ptype==2">儿童</ww:if>
					<ww:if test="ptype==3">婴儿</ww:if></td>
					<td><ww:property value="idnumber" /></td>
					<td><ww:property value="formatMoney(converNull(price,0))" /></td>
					<td><ww:property value="formatMoney(converNull(fuelprice,0))" /></td>
					<td><ww:property value="formatMoney(converNull(airportfee,0))" /></td>
					
					<td><ww:property
						value="formatMoney_string(converNull(getsuminsurance(insurance),0))" /></td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</ww:iterator>
		</table>
</div>
</ww:if>
<div style="height: 10px;"></div>


	<div style=" border: 1px solid #000;width:90%; margin: 0 auto; ">
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>
			<td width="100">航班号</td>
			<td>航空公司</td>
			<td>起飞机场</td>
			<td>到达机场</td>
			<td>起飞时间</td>
			<td>到达时间</td>
		</tr>
	</tbody>
	<ww:iterator value="listSegment" status="t">
		<tr>
			<td><ww:property value="flightnumber" /></td>
			<td><ww:property value="getAircomapnycodeByEZM(aircomapnycode)" /></td>
			<td><ww:property value="getAirportbySZM(startairport)" /></td>
			<td><ww:property value="getAirportbySZM(endairport)" /></td>
			<td><ww:property value="formatTimestamp(departtime)" /></td>
			<td><ww:property value="formatTimestamp(arrivaltime)" /></td>
		</tr>
	</ww:iterator>
</table>
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>

			<td width="100">订单号</td>
			<td>PNR</td>
			<td>大PNR</td>
			<td width="90">总票面结算价</td>
			<td width="60">总燃油费</td>
			<td width="60">总机建费</td>
			<td width="60">总保险费</td>
			<td width="60">总平台费</td>
			<td width="100">订单总额</td>
		</tr>
	</tbody>
	<tr>
		<td><ww:property value="orderinfo.ordernumber" /></td>
		<td><a href="#"
			onclick="javascript:copyToClipboard('<ww:property value="orderinfo.pnr"/>',true);"><ww:property
			value="orderinfo.pnr" /></a></td>
		<td><a href="#"
			onclick="javascript:copyToClipboard('<ww:property value="orderinfo.bigpnr"/>',true);"><ww:property
			value="orderinfo.bigpnr" /></a></td>
		<td><ww:property value="formatMoney(orderinfo.totalticketprice)" /></td>
		<td><ww:property value="formatMoney(orderinfo.totalfuelfee)" /></td>
		<td><ww:property value="formatMoney(orderinfo.totalairportfee)" /></td>
		<td><ww:property value="formatMoney(orderSafePrice)" /></td><!-- formatMoney(converNull(getIssurByOrderid(orderinfo.id))) -->
		<td><ww:property value="formatMoney(orderAllPlat)" /></td>
		<td style="color:red;font-weight:bold">￥<ww:property
			value="formatMoney(orderinfo.orderprice)" /></td>
	</tr>
</table>
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
			bordercolor="#86B2D1"
			style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
			<tbody bgcolor="#DDECF3" style="color: #999;">
				<tr>
					<td width="100">姓名</td>
					<td>乘机人类型</td>
					<td>证件号/出生日期</td>
					<td width="90">票面结算价</td>
					<td width="60">燃油费</td>
					<td width="60">机建费</td>
<<<<<<< success.jsp
					<td width="60">保险费</td>
					<td width="60">平台费</td>
=======
					<!-- <td width="60">保险费</td> -->
					<!--<td style=" border-top: no
>>>>>>> 1.6
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</tbody>
			<ww:iterator value="listPassenger" status="t">
				<tr>
					<td><ww:property value="name" /></td>
					<td><ww:if test="ptype==1">成人</ww:if> <ww:if test="ptype==2">儿童</ww:if>
					<ww:if test="ptype==3">婴儿</ww:if></td>
					<td><ww:property value="idnumber" /></td>
					<td><ww:property value="formatMoney(converNull(price,0))" /></td>
					<td><ww:property value="formatMoney(converNull(fuelprice,0))" /></td>
					<td><ww:property value="formatMoney(converNull(airportfee,0))" /></td>
					<td><ww:property value="formatMoney(converNull(getInsurancPrice(insurance),0))" /></td>
					<td><ww:property value="formatMoney(orderPlat)" /></td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</ww:iterator>
		</table>
</div>

<table width="90%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#b3b3b3"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 10px; text-align: center;">
	<tbody bgcolor="#f0f0f0" class="hong_c">
	<tr>
		<td style="font-size: 18px;color:red;  font-weight:bold" align="right">应付金额：
		<ww:property value="formatMoney(#request.ordermap.orderprice)"/>
		
		元&nbsp;&nbsp;</td>
	</tr>
	</tbody>
</table>

<!-- 苍南用支付 -->

<!--
<ww:if test="orderinfo.paymethod==1||orderinfo.paymethod==4">

	<ww:if test="!orderinfo.pnr.equals(\"NOPNR\")">
	  <div><jsp:include page="../pay.jsp"></jsp:include></div>		
	
	</ww:if>
</ww:if>
-->

<!-- 分销商支付 -->
<ww:if test="orderinfo.paymethod==1||orderinfo.paymethod==4">

<div style="width:95%;  margin-top:10px; text-align:right;height:50px" >
<a target="_blank" href='http://<%=request.getServerName() %>:<%=request.getServerPort() %>/interface/Alipay?helpername=Airpayhelper&orderid=<ww:property value="orderinfo.id"/>'><img src="images/anniu_msfk.gif"/></a>
</div>
</ww:if>

</body>
</html>
<script>
function golink(i)
{
	window.location=i;
}
</script>