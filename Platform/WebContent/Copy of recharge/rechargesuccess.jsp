<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div>

<div>
<div>
&nbsp;&nbsp;&nbsp;&nbsp;
提示：请到充值订单列表页面查看充值状态！
<div class="box" style="text-align: center; line-height: 22px;">

</div>
<ww:if test="#request.successtype==1">
<div class="huang">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:15px;color:#fff">◆</span><b class="bai_c">订单信息-订单号：<ww:property
	value="recharge.ordernumber" />
</b></div>

<div class="box" style="padding-top: 10px;">
<div style=" border: 1px solid #000;width:90%; margin: 0 auto; ">
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>
			<td width="100"><b>订单号</b></td>
			<td><ww:property value="mobilerecharge.ordernumber"/></td>
			<td><b>充值号码</b></td>
			<td><ww:property value="mobilerecharge.phonenumber"/></td>
			<td><b>充值金额</b></td>
			<td><ww:property value="mobilerecharge.rechmoney"/></td>
		</tr>
		<tr>
			<td width="100"><b>充值时间</b></td>
			<td colspan="3"><ww:property value="formatTimestamptoMinute(mobilerecharge.rechtime)"/></td>
			<td>状态</td>
			<td>
			<ww:property value="mobilerecharge.statestr"/>
			</td>
		</tr>
	</tbody>
</table>
</ww:if>
<ww:else>
<div class="huang">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:15px;color:#fff">◆</span><b class="bai_c">订单信息-订单号：<ww:property
	value="recharge.ordernumber" />
</b></div>

<div class="box" style="padding-top: 10px;">
<div style=" border: 1px solid #000;width:90%; margin: 0 auto; ">
<table width="100%" border="1" cellpadding="0 " ccellspacing="0"
	bordercolor="#86B2D1"
	style="margin: 0 auto; line-height: 26px; border-collapse: collapse; margin-top: 0px; text-align: center;">
	<tbody bgcolor="#DDECF3" class="huang12_c">
		<tr>
			<td width="100"><b>订单号</b></td>
			<td><ww:property value="qmoneyrecharge.ordernumber"/></td>
			<td><b>充值号码</b></td>
			<td><ww:property value="qmoneyrecharge.qqnumber"/></td>
			<td><b>充值金额</b></td>
			<td><ww:property value="qmoneyrecharge.rechmoney"/></td>
		</tr>
		<tr>
			<td width="100"><b>充值时间</b></td>
			<td colspan="3"><ww:property value="formatTimestamptoMinute(qmoneyrecharge.rechtime)"/></td>
			<td><b>状态</b></td>
			<td>
			<ww:property value="qmoneyrecharge.statestr"/>
			</td>
		</tr>
	</tbody>
</table>
</div></div>
</ww:else>
</body>
</html>
<script>
function golink(i)
{
	window.location=i;
}
</script>