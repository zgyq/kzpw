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
<title>温州苍南遨旅票务商旅系统</title>

<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>

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
 	if(una == ""){
 		$("#valfile").html("用户名不能为空");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		 flag=false;
 	}
 	
 	
 	if(upa == ""){
 		$("#valfile").html("密码不能为空");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		flag=false;
 	}
 	if(uvi == ""){
 		$("#valfile").html("请输入验证码");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		flag=false;
 	}
 	if(flag)
 	{
 	  //dispose("欢迎您进入遨旅航空机票直销平台！");
 	  document.form1.submit();
 	}
 	return flag;
 }
 
 function dispose(message) {
   Ext.MessageBox.show({
           msg: message,
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
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

<script type="text/javascript" src="<%=request.getContextPath()%>/js/validator.js"></script>
</head>
<body>
        <form action="<%=request.getContextPath()%>/login!login.action" name="form1" method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height: 30px;">
          <tr>
            <td  width="55" align="right" style="font-weight: 100; color:#fff">用户名：</td>
            <td  align="left"> <input type="text" class="textd" id="uname" name="loginname" value='<ww:property value="user.loginname"/>' /></td>
          </tr>
          <tr>   
            <td  height="30" align="right"><Font style="font-weight: 100; color:#fff;">密&nbsp;&nbsp;&nbsp;&nbsp;码：</Font></td>
            <td><input type="password" id="upass" class="textd" name="logpassword" require="true" value='<ww:property value="user.logpassword"/>' /></td>
          </tr>
          <tr>  
            <td  align="right" style="font-weight: 100; color:#fff">验证码：</td>
            <td><input id="validateImg" name="validateImg" class="textd" type="text" size="6" style=" margin-right:0px; width: 40px;" align="absmiddle" /> 
            <img vertical-align="middle" src="validate" width="55" height="20"  style="margin-left: 0px; position: absolute;"  alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" />
            </td>
          </tr>
          <tr>
            <td align="center"  colspan="2" style="line-height:20px;" height="20"  style="color:#f00">
            <span><font style="color: red" id='valfile'><ww:property value="fieldErrors.erromessage"/></font> </span>
            </td>
          </tr>
          <tr>
            <td colspan="2"  align="center"><input type="button" class="button" value="" onclick="return submitForm()" /></td>
          </tr>
        </table>
       </form>    
</body>
</html>

