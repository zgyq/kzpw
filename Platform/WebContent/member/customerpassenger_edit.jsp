<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="customerpassenger.id>0">编辑</ww:if><ww:else>新增</ww:else>常用旅客</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>

</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script>
function form_validate() {

		var validate = true ;
		
	username = document.getElementById('username');
		if(username.value=="") {
			document.getElementById("username2").innerHTML="*旅客姓名不能为空";
			username.focus();
			validate = false ;
		} else {
			document.getElementById("username2").innerHTML="*";
		}
		
		
		
		memberemail = document.getElementById('memberemail');
		if(memberemail.value=="") {
			document.getElementById("memberemail2").innerHTML="*电子邮箱不能为空";
			memberemail.focus();
			validate = false ;
		} else {
			document.getElementById("memberemail2").innerHTML="*";
		}	
		
		
		mobile = document.getElementById('mobile');
		if(mobile.value=="") {
			document.getElementById("mobile2").innerHTML="*手机不能为空";
			mobile.focus();
			validate = false ;
		} else {
			document.getElementById("mobile2").innerHTML="*";
		}	
		
		
		creditnumber = document.getElementById('creditnumber');
		if(creditnumber.value=="") {
			document.getElementById("creditnumber2").innerHTML="*证件号码不能为空";
			creditnumber.focus();
			validate = false ;
		} else {
			document.getElementById("creditnumber2").innerHTML="*";
		}	
		
		
		address = document.getElementById('address');
		if(address.value=="") {
			document.getElementById("address2").innerHTML="*地址不能为空";
			address.focus();
			validate = false ;
		} else {
			document.getElementById("address2").innerHTML="*";
		}		
		

		return validate;
}
$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});

</script>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="border-collapse: collapse;" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="customerpassenger.id>0">编辑</ww:if><ww:else>新增</ww:else>常用旅客</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customerpassenger!<ww:if test="customerpassenger.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			id="form1" name="form1" method="POST">



	<table width="99%" border="0" cellpadding="0" cellspacing="0" style="margin: 0 auto">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="10%" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
						<td width="10%" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>





					<tr>
						<td height="28" class="table_color_r colortrin"><span>旅客姓名：</span></td>
						<td class="table_color_l"><input type="text" desc="旅客姓名" class="validate[required]"  name="username" id="username"
							value='<ww:property value="customerpassenger.username"/>'
							" style="width: 150px" /><span id="username2" class="font-red">*</span></td>
						<td height="28" class="table_color_r colortrin"><span>电子邮箱：</span></td>
						<td class="table_color_l"><input type="text"  name="memberemail" id="memberemail"
							value='<ww:property value="customerpassenger.memberemail"/>'
							" style="width: 150px" />
							<!-- ><span id="memberemail2" class="font-red">*</span>--></td>
					</tr>



					<tr>
						<td height="28" class="table_color_r colortrin"><span>手机号：</span></td>
						<td class="table_color_l"><input type="text" class="validate[required]" desc="手机号" name="mobile" id="mobile"
							value='<ww:property value="customerpassenger.mobile"/>'
							" style="width: 150px" /><span id="mobile2" class="font-red">*</span></td>
						<td height="28" class="table_color_r colortrin"><span>排列顺序：</span></td>
						<td class="table_color_l"><input type="text" require="true"
							dataType="Require" msg="排列顺序不能为空" name="sortid"
							value='<ww:property value="customerpassenger.sortid"/>'
							" style="width: 150px" /></td>

					</tr>

					<tr>
					<td height="28" class="table_color_r colortrin"><span>证件类型①：</span></td>
						<td class="table_color_l"><select name="credittype">
							<option value="1"
								<ww:if test="listCustomercredit.get(0).credittypeid==1">selected</ww:if>>身份证</option>
							<option value="2"
								<ww:if test="listCustomercredit.get(0).credittypeid==2">selected</ww:if>>驾驶证</option>
							<option value="3"
								<ww:if test="listCustomercredit.get(0).credittypeid==3">selected</ww:if>>护照</option>
							<option value="4"
								<ww:if test="listCustomercredit.get(0).credittypeid==4">selected</ww:if>>港澳通行证</option>
								<option value="5"
								<ww:if test="listCustomercredit.get(0).credittypeid==5">selected</ww:if>>台湾通行证</option>
								<option value="6"
								<ww:if test="listCustomercredit.get(0).credittypeid==6">selected</ww:if>>台胞证</option>
								<option value="7"
								<ww:if test="listCustomercredit.get(0).credittypeid==7">selected</ww:if>>回乡证</option>
								
						</select></td>
						<td height="28" class="table_color_r colortrin"><span>证件号码①：</span></td>
						<td class="table_color_l"><input type="text" require="true"
							dataType="Require" msg="手机号不能为空" name="creditnumber" id="creditnumber"
							value='<ww:property value="listCustomercredit[0].creditnumber"/>'
							" style="width: 150px" /><span id="creditnumber2" class="font-red">*</span></td>
						
					</tr>
			



					<tr>
						<td height="28" class="table_color_r colortrin"><span>地址：</span>
						<input type="hidden" name="c_id" value="<ww:property value="c_id"/>"/>
						</td>
						<td class="table_color_l" colspan="3"><input type="text"  name="address" id="address"
							value='<ww:property value="customerpassenger.address"/>'
							" style="width:300px" />
							<!-- <span id="address2" class="font-red">*</span>-->
							<input type="hidden" name="customeruserid" value="<ww:property value="customeruserid"/>"/>
							</td>
						 
					</tr>





					<tr class="font-blue-xi">
						<td height="46" scrolling="no" colspan="4" class="table_color" ><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='customerpassenger.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


