<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有，thunder
	 * Author: thunder
	 * copyright: 2011
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>修改密码</title>
<link href="css/default.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script language="javascript" type="text/javascript"
	src="js2/My97DatePicker/WdatePicker.js"></script>
<script src="js2/validate/jquery-1.4.min.js" type="text/javascript"></script>
<script src="js2/validate/jquery.validationEngine-cn.js"
	type="text/javascript"></script>
<script src="js2/validate/jquery.validationEngine.js"
	type="text/javascript"></script>


<script>	
		$(document).ready(function() {
			
			$("#form1").validationEngine()
		
		});
		
function vpass(id){		
var strval=$("#pass"+id).val();
      if(strval==""){
      if(id==1)
      $("#vpass1").html("请输入原始密码！");
      if(id==2)
       $("#vpass2").html("请输入新密码！");
      if(id==3){
       if($("#pass2").val()!="")
       $("#vpass3").html("请再次输入新密码！");
       }     
      return false;
      }else {
      $("#vpass"+id).html("");
      if(id==1){
         jQuery.post("customeruser!ajaxIsRrigthPassword.action",{clientpwd:strval},function(data){
            if(data!="true"){
             $("#vpass1").html("原始密码输入不正确！");
             return false;
            }
         });      
       }
      if(id==2){
        if(strval.length<6){
         $("#vpass2").html("密码长度不能低于6位！");
         return false;
        }      
      }
      if(id==3){
        if($("#pass2").val()!=strval){
         $("#vpass3").html("两次密码输入不一致！");
         return false;
        }
       }
     }
     return true;
}
function passclose(){
$("#divPass").dialog("close");
}
function vupdatePass(){
vpass(1);vpass(2);vpass(3);
  if(vpass(1)&&vpass(2)&&vpass(3)){
  var strval=$("#pass2").val();
    jQuery.post("customeruser!ajaxUpdatepassword.action",{newpassword:strval},function(){
             alert("密码修改成功！");   
            // $("#divPass").dialog("close");
             parent.closetab();        
         });      
  }
 
}
	</script>



</head>


<body>

<formaction="systemrole!<ww:if test="systemrole.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="top" background="images/titleL3_bg.gif">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><img src="images/titleL3_point.gif" width="33" height="19"><span
					class="txt_title3">修改密码</span>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td valign="bottom">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width=42 nowrap>&nbsp;</td>
								<td nowrap>&nbsp;</td>
							</tr>
						</table>

						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<table border="0" width="100%" align="center">

	<tr class="tr2" align="center">
		<td align="right">旧密码：</td>
		<td><input type="password" id="pass1" class="validate[required]"
			name="name" value='<ww:property value="systemrole.name"/>' onblur="vpass(1)" />&nbsp;<span id="vpass1" style="color:red"></span></td>
	</tr>

	<tr class="tr2" align="center">
		<td align="right">新密码：</td>
		<td><input type="password" id="pass2" class="validate[required]"
			name="name" value='<ww:property value="systemrole.name"/>' onblur="vpass(2)" />&nbsp;<span id="vpass2" style="color:red"></span></td>
	</tr>
	
	<tr class="tr2" align="center">
		<td align="right">重复新密码：</td>
		<td><input type="password" id="pass3" class="validate[required]"
			name="name" value='<ww:property value="systemrole.name"/>' onblur="vpass(3)" />&nbsp;<span id="vpass3" style="color:red"></span></td>
	</tr>

	


	








	<tr class="tr0" >
	<td></td>
		<td height="30" align="left"  ><input class="a"
			type="button" value=" 提 交 " onclick="javascript:vupdatePass()" /> <input type="button"
			onclick="passclose()" name="Submit2" value=" 关 闭  " /></td>
	</tr>

</table>



</form>
</body>
</html>



