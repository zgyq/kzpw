<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理系统</title>

<%
	String abspath="http://"+request.getServerName() +":"+request.getServerPort() +request.getContextPath()+"/";
%>
<style type="text/css">
<!--
body {
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	margin-left: 0px;
	background-image: url(images/titleL3_bg.gif);
}
-->

</style>


		<link href="css/default.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
			<script src="<%=request.getContextPath()%>/js/validate/jquery-1.4.min.js" type="text/javascript"></script>
			<script src="<%=request.getContextPath()%>/js/validate/jquery.validationEngine-cn.js" type="text/javascript"></script>
			<script src="<%=request.getContextPath()%>/js/validate/jquery.validationEngine.js" type="text/javascript"></script>


    <link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
    <script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="js/ext-all.js"></script>
    <script type="text/javascript" src="login.js"></script>
    
    

  

<script language="javascript">
    var openerIsIndex=false;
	try{
		openerIsIndex=opener.isIndex();
	}catch(e){}
	if(opener!=null && !openerIsIndex){
		opener.top.location= "<%=abspath+"login.jsp"%>";
		window.close();
	}else if(top!=self){
		top.location="<%=abspath+"login.jsp"%>";
	}
</script>
    
</head>

<body  style="scroll:no;">

<div style="background-image:url(images/top_bg01.jpg);width:100%;height:48px">
	<img src="images/logo_login_hz.gif"  height="48" >
</div>

<div style="border:#4F81BD solid 2px;width:614px; height:200px;margin:0 auto; position:relative;top:100px;" align="center">

<div align="left" style="position:relative;left:10px;top:10px;margin-bottom:20px; ">
   请登录  <FONT color="RED"><ww:iterator value="actionMessages"><ww:property/></ww:iterator></FONT>
</div>


<form action="<%=request.getContextPath()%>/login!login.action" id="form1" name="form1" method="POST" >


<table width="614" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFF33">


<tr  valign="middle">
	<td width="341" height="32">
		<div align="right">用户名：</div>
	</td>
	
	<td width="243" align="left">
		<input type="text" id="loginname" name="loginname" value="<ww:property value="user.loginname"/>" class="validate[required,custom[onlyLetter],length[5,50]]" > 
	</td>
	
</tr>

<tr  valign="middle">
  <td height="49" >
	<div align="right">密&nbsp;&nbsp;码：</div></td><td align="left">
 	<input type="logpassword" id="logpassword" name="logpassword"  value="<ww:property value="user.logpassword"/>"  class="validate[required]"> 
  </td>
</tr>

<tr valign="middle">
  <td height="39">
	<div align="right">验证码：</div></td>
	<td align="left">	
	<input type="text" id="validate" name="validate" class="validate[required]"> 

	</td>
	<td>
	<div align="left"><img height="29" width="92" src="<%=abspath%>validate" border="0"></div>
		</td>

</tr>
</table>







 <div align="center">
  
 	<input type="submit"  value="登录"  />
  	<button  onclick="form1.reset()"> 重 置 </button>
 </div>
 </form>
</div>


</body>
</html>
