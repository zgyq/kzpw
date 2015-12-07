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
</head>
<body >
<div>


<div>

<div>

<div class="box" style="text-align: center; line-height: 22px;">
<ul>
	<li>
	<ww:if test="#request.paystate==1">
	<img src="images/dui.gif" width="51" height="43" />&nbsp;&nbsp;<b>您的支付已成功!</b>
	<br />&nbsp;
	<br />
	</ww:if>
	<ww:else>
	<img src="images/png-0495.png" width="51" height="43" /><b>支付失败!原因：<ww:property value="#request.message"/></b>
	</ww:else>
	</li>
</ul>

</div>

</body>
</html>
<script>
</script>