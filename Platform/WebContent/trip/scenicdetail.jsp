<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	/**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天河联盟商旅网</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/webcss/bass.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/Travel.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/font.css" type="text/css" rel="stylesheet" />
<script language="javascript">
  function triptab(a)
   {
	 for(var i=1;i<=3;i++)
	 {
	 	document.getElementById("trip_tui"+i).style.background="url(images/nav_city_b.gif)";
	 	document.getElementById("trip_tuia"+i).style.color="";
	 	document.getElementById("divtab_"+i).style.display="none";
	 	
	 }
	 document.getElementById("trip_tui"+a).style.background="url(images/nav_city_l.gif)";
	 document.getElementById("trip_tuia"+a).style.color="#FFFFFF";
	 document.getElementById("divtab_"+a).style.display="block";
    }
</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;景区详细信息</span></td>
		</tr>
	<tr>
	<td>
<div id="container">
 <div class="f left">
    <h3 class="lan14_cu" style="line-height:34px;"> 
   <span class="hui14"><ww:property value="scenicspot.name"/></span> </h3>
	<div style="padding:15px;"><img src="<ww:property value="getimgPath()+scenicspot.image" />" width="480" height="321" /></div>
	<div style="padding:15px; text-indent:20px;">
	<ww:property value="scenicspot.description"/>
</div>
<div class="c" style="height: 10px"></div>
<!---------------------main_2 over-------------------->

</div>
</div>
</td>
</tr>
</table>
</body>
</html>
