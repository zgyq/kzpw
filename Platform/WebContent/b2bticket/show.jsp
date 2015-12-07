<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>公告页面</title>
<script type="text/javascript">
function showDetailspnr(liid,id)
{
document.getElementById("jpcx").style.display="none";
document.getElementById("pndr").style.display="none";
document.getElementById("pndrwz").style.display="none";
document.getElementById("kfzx").style.display="none";
document.getElementById(id).style.display="";
document.getElementById("lib3").style.backgroundImage="url('images/xlw2.gif')";
document.getElementById("lib32").style.backgroundImage="url('images/xlw2.gif')";
document.getElementById("lib33").style.backgroundImage="url('images/xlw2.gif')";
document.getElementById("lib34").style.backgroundImage="url('images/xlw2.gif')";
document.getElementById(liid).style.backgroundImage="url('images/xlw1.gif')";
}
</script>
<link href="b2bticket/css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="div_pt"></div>
<div id="div_notice" class="div_notice">
<div class="dbiaoti"><ww:property value="sysmessage.title" /></div>
<div class="d_neir">
<ww:property value="sysmessage.content" />
</div>
<div class="d_riq"><ww:property value="formatTimestampyyyyMMdd(sysmessage.modifytime)" /></div>
</div>
<div class="div_ptd"></div>
</body>
</html>