<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/hotel.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
<script src="js/jquery1.3.2.js" type=text/javascript></script>
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
<div class="huang"><b class="bai_c">订单信息-订单号：<ww:property value="orderinfo.ordernumber" /></b></div>
</div>

<div class="box" style="padding-top: 10px;">
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
    <ww:iterator value="listsegment">
	    <tr>
			<td width="100"><ww:property value="flightnumber" /></td>
			<td><ww:property value="getAirCompanyNamebyCode(aircomapnycode)" /></td>
			<td><ww:property value="getAirPortNamebyCode(startairport)" /></td>
			<td><ww:property value="getAirPortNamebyCode(endairport)" /></td>
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

			<td width="60">总销售票价</td>
			<td width="60">总税费</td>
			<td width="60">总保险费</td>
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
		<td><ww:property value="orderinfo.totalfuelfee" /></td>
		<td><ww:property value="getsuminsurance(orderinfo.insurance)" /></td>
		<td>￥<ww:property
			value="formatMoney(orderinfo.totalticketprice+orderinfo.totalfuelfee+orderinfo.totalairportfee+getsuminsurance(orderinfo.insurance))" /></td>
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
					<td width="60">销售票价</td>
					
					<td width="60">税费</td>
					
					<td width="60">保险费</td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</tbody>
			<ww:iterator value="listpassenger" status="t">
				<tr>
					<td><ww:property value="name" /></td>
					<td><ww:if test="ptype==1">成人</ww:if> <ww:if test="ptype==2">儿童</ww:if>
					<ww:if test="ptype==3">婴儿</ww:if></td>
					<td><ww:property value="idnumber" /></td>
					<td><ww:property value="formatMoney(price)" /></td>
					<td><ww:property value="formatMoney(fuelprice)" /></td>
					
					<td><ww:property
						value="formatMoney_string(getsuminsurance(insurance))" /></td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</ww:iterator>
			
		</table>
</div>
<div style="height: 10px;"></div>


<table width="90%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#b3b3b3"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 10px; text-align: center;">
	<tbody bgcolor="#f0f0f0" class="hong_c">
	<tr>
		<td style="font-size: 18px;" align="right">应付金额：<ww:property value="formatMoney(orderinfo.totalticketprice+orderinfo.totalfuelfee)"/>元&nbsp;&nbsp;</td>
	</tr>
	</tbody>
</table>
</body>
</html>