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
<title><ww:if test="customercredit.id>0">编辑</ww:if><ww:else>新增</ww:else>证件</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript">
	function form_validate() {
		var validate = true ;
		
		creditnumber = document.getElementById('creditnumber');
		if(creditnumber.value == '') {
			document.getElementById("creditnumberSp").innerHTML="*证件号不能为空";
			validate = false ;
			creditnumber.focus();
		}else {
			document.getElementById("creditnumberSp").innerHTML="*";
		}
		
		type = document.getElementById('type');
		if(type.value == '' || type.value < 0) {
			document.getElementById("typeSp").innerHTML="*请选择类别";
			validate = false ;
		}else {
			document.getElementById("typeSp").innerHTML="*";
		}
		
		credittypeid = document.getElementById('credittypeid');
		if(credittypeid.value == '' || credittypeid.value < 0) {
			document.getElementById("credittypeidSp").innerHTML="*请选择证件类型";
			validate = false ;
		}else {
			document.getElementById("credittypeidSp").innerHTML="*";
		}
		return validate;
	}
	
</script>
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="customercredit.id>0">编辑</ww:if><ww:else>新增</ww:else>证件</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customercredit!<ww:if test="customercredit.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="post" onsubmit="return form_validate()"><input
			type="hidden" name="refid"
			value='<ww:property value="customercredit.refid"/>' />
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					style="border-collapse: collapse;">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right" width="10%"
							class="table_color_r colortrin"><span>证件类型：</span></td>
						<td class="table_color_l" width="40%"><select
							name="credittypeid" id="credittypeid" style="margin-right: 5px;">
							<option>--请选择--</option>
							<option value="1"
								<ww:if test="customercredit.credittypeid==1">selected="selected"</ww:if>>身份证</option>
							<option value="2"
								<ww:if test="customercredit.credittypeid==2">selected="selected"</ww:if>>驾驶证</option>
							<option value="3"
								<ww:if test="customercredit.credittypeid==3">selected="selected"</ww:if>>护照</option>
							<option value="4"
								<ww:if test="customercredit.credittypeid==4">selected="selected"</ww:if>>港澳通行证</option>
							<option value="5"
								<ww:if test="customercredit.credittypeid==5">selected="selected"</ww:if>>台湾通行证</option>
						    <option value="6"
								<ww:if test="customercredit.credittypeid==6">selected="selected"</ww:if>>台胞证</option>
						    <option value="7"
								<ww:if test="customercredit.credittypeid==7">selected="selected"</ww:if>>回乡证</option>
						    <option value="8"
								<ww:if test="customercredit.credittypeid==8">selected="selected"</ww:if>>其它</option>
						</select><span id="credittypeidSp" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color_r colortrin"><span>类别：</span></td>
						<td class="table_color_l"><select name="type" id="type"
							style="margin-right: 5px;">
							<option>--请选择--</option>
							<option value="0"
								<ww:if test="customercredit.type==0">selected="selected"</ww:if>>会员</option>
							<option value="1"
								<ww:if test="customercredit.type==1">selected="selected"</ww:if>>常用旅客</option>
						</select><span id="typeSp" class="font-red">*</span></td>

					</tr>
					<tr>
						<td height="28" align="right" class="table_color_r colortrin"><span>证件号：</span></td>
						<td class="table_color_l" colspan="3"><input type="text"
							name="creditnumber" id="creditnumber"
							value='<ww:property value="customercredit.creditnumber"/>'
							style="width: 150px; margin-right: 5px;" /><span
							id="creditnumberSp" class="font-red">*</span></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center"><input
							type="submit" class="button_d font-bai" value="提交" /> <input
							type="button" class="button_d font-bai" onclick="history.back()"
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


