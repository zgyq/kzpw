<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page import="java.util.*;"%>
<%
	String abspath="http://"+request.getServerName() +":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link type="text/css" href="css/index.css"  rel="stylesheet"/>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script>
$(document).ready(function()
{
$("#uname").focus();


});
</script>
</head>
<script language="javascript" for="document"  event="onkeydown">
     $(document).ready(function()
     {
          if(event.keyCode==13)     //判断回车按钮事件
          {   
             $("#btnlogin").click();
          }
     });

</script>
<script language="javascript">
 function submitForm(){
 	var una = document.getElementById("uname").value;
 	var upa = document.getElementById("upass").value;
 	var uvi = document.getElementById("validateImg").value;
 	var flag=true;
 		if(uvi == ""){
 		$("#validateImg2").html("请输入验证码");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		flag=false;
 		return;
 	}else{
 		$("#validateImg2").html("");
 	}
 	
 	if(una == ""){
 		$("#validateImg2").html("用户名不能为空");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		 flag=false;
 		 return;
 	}
 	
 	
 	if(upa == ""){
 		$("#validateImg2").html("密码不能为空");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		flag=false;
 		return;
 	}
 
 	if(flag)
 	{
 	  document.form1.submit();
 	}
 	return flag;
 }
 
 
 document.onkeypress=function(e) 
    {
        var code;  
        if  (!e)  
        {  
            var e=window.event;  
        }  
        if(e.keyCode)  
        {    
            code=e.keyCode;  
        }  
        else if(e.which)  
        {  
            code   =   e.which;  
        }
        if(code==13)
        {
        submitForm();
        }
    }
</script>

<script language="javascript">

    var openerIsIndex=false;
	try{
		openerIsIndex=opener.isIndex();
	}catch(e){}
	if(opener!=null && !openerIsIndex){
		opener.top.location= "<%=abspath+"index.jsp"%>";
		window.close();
	}else if(top!=self){
		top.location="<%=abspath+"index.jsp"%>";
	}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validator.js"></script>

<body>
<form action="<%=request.getContextPath()%>/login!login.action" name="form1" method="post">
<div id="main">
<div class="logo"><img src="images/${dns.logologinsrc}" width="228" height="106" /></div>
<div>
<div class="left"><iframe src="adv7777/index.html" width="541" height="206" hspace="0" frameborder="0" scrolling="no" ></iframe></div>
<div class="right">
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
  <td colspan="2" height="65p">&nbsp;</td>
  </tr>
  <tr>
    <td width="260" align="right" height="48" valign="top"> <input type="text" class="input" id="uname" name="loginname" value="<ww:property value="user.loginname"/>"> </td>
    <td valign="top" ><img id="imgbtn" src="images/ann.gif" width="98" height="31" style="margin-left:15px;cursor:pointer;" onclick="return submitForm()" /></td>
  </tr>
  <tr>
    <td align="right" height="48" valign="top"><input type="password" id="upass" class="input" name="logpassword" require="true" value="<ww:property value="user.logpassword"/>"> </td>
    <td valign="top"><font style="margin-left:30px; line-height:33px; color:#03C; font-weight:bold">忘记密码？</font></td>
  </tr>
  <tr>
    <td align="right" height="40" valign="top"><input id="validateImg" name="validateImg" class="input" type="text" size="6" align="bottom" /> </td>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img vertical-align="middle" src="validate" width="70" height="30"  style="padding-top: 5px;" alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" /></td>
  </tr>
  <tr>
    <td  align="right"><span id="validateImg3" style="color:red"><ww:property value="fieldErrors.password"/><ww:property value="fieldErrors.username"/></span> <span id="validateImg2" style="color:red"><ww:property value="fieldErrors.validate"/></span></td>
    <td></td>
  </tr>
</table>

</div>
<div  class="c" ></div>
</div>

<div style="text-align:center; line-height:40px; font-size:12px; padding-top:40px; clear:both; color:#666">
<!--  北京市丰台区丽泽桥丽泽雅园6号楼1004室  -->
公司地址：${dns.address }
<br/>
客服电话：${dns.serviceline }
<br/>
${dns.companyname} Copyinght 2010-2090 .All rights reserved 

</div>
</div>
</form>  
</body>
</html>
<script type="text/javascript">
function freshvalidate()
{
	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
}
</script>
