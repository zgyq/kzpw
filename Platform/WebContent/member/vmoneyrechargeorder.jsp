<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>虚拟账户充值</title>
</head>
<body style="padding-top: 20px">
<table style="padding-top: 10px;" width="90%" align="center" >
<tr><td colspan="6"><b>账户直充</b>&nbsp;&nbsp;货币单位：元&nbsp;&nbsp;&nbsp;</td></tr>
<tr>
<td colspan="6">
<hr color="#2196D2">
</td></tr>
<tr>
<td align="center"><b>交易号</b></td>
<td align="center"><b>商品名称</b></td>
<td align="center"><b>充值金额</b></td>
<td align="center"><b>应付金额</b></td>
</tr>
<tr>
<td align="center"><ww:property value="rebaterecord.id"/></td>
<td align="center">虚拟货币</td>
<td align="center"><ww:property value="rebaterecord.rebatemoney"/></td>
<td align="center"><ww:property value="rebaterecord.rebatemoney"/></td>
</tr>

</table>
<ww:include page="../newpay.jsp"/>
</body>
</html>