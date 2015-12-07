<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录--${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全-V2.0</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/autocomplete.css" rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/validationEngine.jquery.css"
	type="text/css" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine.js"
	type="text/javascript"></script>
<style>
td {
	padding-left: 3px;
}

.red {
	color: red
}

body {
	font-size: 12px;
	margin: 0 auto;
	color: #666;
	height: 100%;
	width: 100%;
	background-color: #226DC8
}

img input {
	vertical-align: middle
}
</style>
</head>


<body style="background: #fff">



<form>
<div
	style="height: 83px; background: url(images/bj_login.gif); width: 100%">
<div style="width: 950px; margin: 0 auto;"><img
	src="images/logo_login.gif" width="335" height="83" /></div>
</div>
<table style="height: 500px;width: 100%">
<td width="100%" align="center">申请成功！我们将尽快和您联系！</td>
<td style="height: 450px"></td>
</table>

<div
	style="background: url('images/bottom1.gif'); width: 950px; height: 47px; line-height: 47px; text-align: center;">
&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: #999999;">版权所有：允风文化科技有限公司</font>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<font
	style="color: #999999;">技术支持：允风文化科技有限公司</font>&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>
</form>
</body>
</html>
<script type="text/javascript">
function freshvalidate()
{
	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
}

function subdis(){
$("#subbut").attr("disabled","disabled");
}

function agreen(){
$("#subbut").attr("disabled",false);
}
</script>
