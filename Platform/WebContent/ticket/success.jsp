<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>江苏东方航空旅行社</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/base.css" type="text/css" rel="stylesheet" />
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
<div  class="huang"><b class="bai_c">订单信息-订单号：<ww:property
	value="getorderbyid(idtemp).ordernumber" />&nbsp;&nbsp;<ww:if
	test="orderinfo.id!=idtemp">
	<ww:property value="orderinfo.ordernumber" />
</ww:if></b></div>
</div>

<div  class="box" style="padding-top: 10px;">
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
			<td width="60">邮寄费费</td>
			<td width="60">总票面价</td>
			<td width="60">总燃油费</td>
			<td width="60">总机建费</td>
			<td width="60">总保险费</td>
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
		<td><ww:property value="orderinfo2.postmoney" /></td>
		<td><ww:property value="formatMoney(orderinfo2.totalticketprice)" /></td>
		<td><ww:property value="orderinfo2.totalfuelfee" /></td>
		<td><ww:property value="orderinfo2.totalairportfee" /></td>
		<td><ww:property value="getsuminsurance(orderinfo2.insurance)" /></td>
		<td>￥<ww:property
			value="formatMoney(orderinfo2.totalticketprice+orderinfo2.totalfuelfee+orderinfo2.totalairportfee)" /></td>
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
					<td width="60">票面价</td>
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
					<td><ww:property value="formatMoney_string(price)" /></td>
					<td><ww:property value="formatMoney_string(fuelprice)" /></td>
					<td><ww:property value="formatMoney_string(airportfee)" /></td>
					<td><ww:property
						value="formatMoney_string(getsuminsurance(insurance))" /></td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</ww:iterator>
		</table>
</div>
<div style="height: 10px;"></div>

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
			<td width="60">邮寄费费</td>
			<td width="60">总票面价</td>
			<td width="60">总燃油费</td>
			<td width="60">总机建费</td>
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
		<td><ww:property value="orderinfo.postmoney" /></td>
		<td><ww:property value="formatMoney(orderinfo.totalticketprice)" /></td>
		<td><ww:property value="orderinfo.totalfuelfee" /></td>
		<td><ww:property value="orderinfo.totalairportfee" /></td>
		<td><ww:property value="getsuminsurance(orderinfo.insurance)" /></td>
		<td>￥<ww:property
			value="formatMoney(orderinfo.totalticketprice+orderinfo.totalfuelfee+orderinfo.totalairportfee)" /></td>
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
					<td width="60">票面价</td>
					<td width="60">燃油费</td>
					<td width="60">机建费</td>
					<td width="60">保险费</td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</tbody>
			<ww:iterator value="listPassenger" status="t">
				<tr>
					<td><ww:property value="name" /></td>
					<td><ww:if test="ptype==1">成人</ww:if> <ww:if test="ptype==2">儿童</ww:if>
					<ww:if test="ptype==3">婴儿</ww:if></td>
					<td><ww:property value="idnumber" /></td>
					<td><ww:property value="formatMoney_string(price)" /></td>
					<td><ww:property value="formatMoney_string(fuelprice)" /></td>
					<td><ww:property value="formatMoney_string(airportfee)" /></td>
					<td><ww:property
						value="formatMoney_string(getsuminsurance(insurance))" /></td>
					<td style=" border-top: none; border-bottom:none; background: #fff" width="100">&nbsp;</td>
				</tr>
			</ww:iterator>
		</table>
</div>
</ww:if>
<div style="width:90%; margin: 0 auto; ">
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#b3b3b3"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 10px; text-align: center;">
	<tbody bgcolor="#f0f0f0" class="hong_c">
	<tr>
		<td style="font-size: 18px;" align="right">应付金额：<ww:property value="formatMoney_string(getorderpricesum(orderinfo.id))"/>元&nbsp;&nbsp;</td>
	</tr>
	</tbody>
</table>
<div style="width: 90%; margin: 0 auto; margin-top: 10px;">
<div style="background: url('images/kuaiqiand.gif'); width: 110px; height: 26px; line-height: 26px;text-align: center;"><b>信用卡在线支付</b></div>
<div style="border: 1px solid #B3B3B3;" >
<div style="background: #f0f0f0;  padding-left: 20px;">快钱支持的国内信用卡银行</div>
<table width="100%" style="text-align: center;">
<tr><td height="30"><img src="images/bank_boc.gif" /></td><td><img src="images/bank_ccb.gif" /></td><td><img src="images/bank_icbc.gif" /></td><td><img src="images/bank_cib.gif" /></td><td><img src="images/bank_cmbc.gif" /></td></tr>
<tr><td height="30"><img src="images/bank_gdb.gif" /></td><td><img src="images/bank_hxb.gif" /></td><td><img src="images/bank_bosh.gif" /></td><td><img src="images/bank_abc.gif" /></td><td>&nbsp;</td></tr>

</table>
</div>
<b style="color:#ff0000">&nbsp;&nbsp;&nbsp;注意：民生、华夏、广发、上海银行信用卡用户，如果您的信用卡有密码，请联系发卡行取消密码再进行支付。</b>

<table width="100%" cellpadding="0" cellspacing="0" border="1" bordercolor="#b3b3b3" style="border-collapse: collapse;">

<tr>
<td  width="120" style="padding: 0"><div class="tdh_color" >真实姓名：</div></td><td><input type="text" /></td><td>请填写您的真实姓名。</td>
</tr>
<tr>
<td  width="120" style="padding: 0"><div class="tdh_color" >证件号码：</div></td><td><input type="text" /></td><td>请填写您申请信用卡时，提交给银行的相关证件号码，如身份证、护照、军官证等。</td>
</tr>
<tr>
<td  width="120" style="padding: 0"><div class="tdh_color" >信用卡卡号：</div></td><td><input type="text" /></td><td></td>
</tr>
<tr>
<td  width="120" style="padding: 0"><div class="tdh_color" >信用卡有效期：</div></td><td><input type="text" /></td><td>月份 / 年份</td>
</tr>
<tr>
<td  width="120" style="padding: 0"><div class="tdh_color" >信用卡验证码：</div></td><td><input type="text" /></td><td>信用卡背面签名条处的末三位数字</td>
</tr>
<tr>
<td height="35" colspan="2" style="padding: 0; text-align: center;"><input type="button" name="支付" value="支付" class="button108"/></td><td>&nbsp;</td>
</tr>
</table>

</div>
</div>

<div style="height: 20px;"></div>
</body>
</html>
<script>
function golink(i)
{
	window.location=i;
}
</script>
