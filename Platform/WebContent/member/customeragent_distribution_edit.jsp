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
<title><ww:if test="customeragent.id>0">编辑</ww:if><ww:else>新增</ww:else>分销信息表</title>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<script>
function form_validate() {

		var validate = true ;
		
		code = document.getElementById('code');
		if(code.value=="") {
			document.getElementById("code2").innerHTML="*单位代码不能为空";
			code.focus();
			validate = false ;
		} else {
			document.getElementById("code2").innerHTML="*";
		}
		agentcompanyname = document.getElementById('agentcompanyname');
		if(agentcompanyname.value=="") {
			document.getElementById("agentcompanyname2").innerHTML="*单位名称不能为空";
			agentcompanyname.focus();
			validate = false ;
		} else {
			document.getElementById("agentcompanyname2").innerHTML="*";
		}
		
	agentshortname = document.getElementById('agentshortname');
		if(agentshortname.value=="") {
			document.getElementById("agentshortname2").innerHTML="*单位简称不能为空";
			agentshortname.focus();
			validate = false ;
		} else {
			document.getElementById("agentshortname2").innerHTML="*";
		}
	c_agentvedate = document.getElementById('c_agentvsdate1');
	c_agentvedat = document.getElementById('c_agentvedate2');
	
		if(c_agentvedate.value=="" || c_agentvedat.value=="") {
			document.getElementById("c_agentvedate3").innerHTML="*有效时间不能为空";
			c_agentvedate.focus();
			c_agentvedat.focus();
			validate = false ;
		} else {
			document.getElementById("c_agentvedate3").innerHTML="*";
		}
	agentpostcode = document.getElementById('agentpostcode');
		if(agentpostcode.value=="") {
			document.getElementById("agentpostcode2").innerHTML="*邮政编码不能为空";
			agentpostcode.focus();
			validate = false ;
		} else {
			document.getElementById("agentpostcode2").innerHTML="*";
		}
	agentcontactname = document.getElementById('agentcontactname');
		if(agentcontactname.value=="") {
			document.getElementById("agentcontactname2").innerHTML="*联系人姓名不能为空";
			agentcontactname.focus();
			validate = false ;
		} else {
			document.getElementById("agentcontactname2").innerHTML="*";
		}
		
		agentemail = document.getElementById('agentemail');
		if(agentemail.value=="") {
			document.getElementById("agentemail2").innerHTML="*电子邮件不能为空";
			agentemail.focus();
			validate = false ;
		} else {
			document.getElementById("agentemail2").innerHTML="*";
		}	
		agenttel = document.getElementById('agenttel');
		if(agenttel.value=="") {
			document.getElementById("agenttel2").innerHTML="*单位联系电话不能为空";
			agenttel.focus();
			validate = false ;
		} else {
			document.getElementById("agenttel2").innerHTML="*";
		}	
		agentcityid = document.getElementById('agentcityid');
		if(agentcityid.value=="") {
			document.getElementById("agentcityid2").innerHTML="*单位所在地不能为空";
			agentcityid.focus();
			validate = false ;
		} else {
			document.getElementById("agentcityid2").innerHTML="*";
		}	
		agentaddress = document.getElementById('agentaddress');
		if(agentaddress.value=="") {
			document.getElementById("agentaddress2").innerHTML="*通信地址不能为空";
			agentaddress.focus();
			validate = false ;
		} else {
			document.getElementById("agentaddress2").innerHTML="*";
		}			
		return validate;
}
</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="customeragent.id>0">编辑</ww:if><ww:else>新增</ww:else>分销商信息表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customeragent!<ww:if test="customeragent.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return form_validate()" >
			<input
			type="hidden" name="agenttype" value="3" />

		<div>


		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="border-collapse: collapse; margin: 0 auto;">
			<!--DWLayoutTable-->
			<tr>
				<td width="10%" height="40" align="right">&nbsp;</td>
				<td></td>
				<td width="10%" height="40" align="right">&nbsp;</td>
				<td></td>

			</tr>
			<tr>
				<td width="15%" align="right" class="table_color_r colortrin">
				单位类型</td>
				<td width="35%" class="table_color_l" " style="text-align: left;">
				<span id="lblType" class="font-red">分销商</span></td>
				<td width="15%" align="right" class="table_color_r colortrin">单位代码</td>
				<td width="35%" class="table_color_l" style="text-align: left;">
				<input name="code" type="text" id="code" size="14" /> 1-20个数字、字母<span id="code2" class="font-red">*</span></td>
				
			</tr>
			<tr>
				<td width="1%" align="right" class="table_color_r colortrin">单位名称</td>
				<td class="table_color_l"><input
					name="agentcompanyname" type="text" id="agentcompanyname" size="14" /><span id="agentcompanyname2" class="font-red">*</span>
				</td>
				<td width="1%" align="right" class="table_color_r colortrin">单位简称</td>
				<td class="table_color_l"><input
					name="agentshortname" type="text" id="agentshortname" size="14" /><span id="agentshortname2" class="font-red">*</span>
				</td>
			</tr>

			<tr>

				<td align="right" class="table_color_r colortrin">使用期限</td>
				<td class="table_color_l"><input
					name="c_agentvsdate" type="text" id="c_agentvsdate1" size="14"
					onfocus="WdatePicker()" readonly="readonly"
					value="<ww:property value="formatDate(customeragent.agentvsdate)"/>" />
				&nbsp;到 <input name="c_agentvedate" type="text" id="c_agentvedate2"
					size="14" onfocus="WdatePicker()" readonly="readonly"
					value="<ww:property value="formatDate(customeragent.agentvedate)"/>" /><span id="c_agentvedate3" class="font-red">*</span>
				</td>


				<td align="right" class="table_color_r colortrin">邮政编码</td>
				<td  valign="top" class="table_color_l"
					style="text-align: left;"><input name="agentpostcode"
					type="text" id="agentpostcode" size="14" /><span id="agentpostcode2" class="font-red">*</span></td>

			</tr>

			<tr>
				<td width="15%" class="table_color_r colortrin">
				联系人姓名</td>
				<td class="table_color_l"><input
					name="agentcontactname" type="text" id="agentcontactname" size="14" /><span id="agentcontactname2" class="font-red">*</span>
				</td>
				<td align="right" class="table_color_r colortrin">联系人电子邮件</td>
				<td class="table_color_l"><input
					name="agentemail" type="text" id="agentemail" size="34" /><span id="agentemail2" class="font-red">*</span></td>
			</tr>
			<tr id="tr_UserCountAndOfficeCode">
				<td width="15%" align="right" class="table_color_r colortrin">单位联系电话</td>
				<td valign="top" class="table_color_l "
					><input name="agenttel" type="text"
					id="agenttel" size="14" /><span id="agenttel2" class="font-red">*</span></td>
					<td width="15%" height="30" class="table_color_r colortrin">是否启用</td>

				<td class="table_color_l "><select
					name="agentisenable">
					<option value="1">是</option>
					<option value="0">不是</option>
				</select></Td>


			</tr>

			<tr>
				<td width="15%" align="right" class="table_color_r colortrin">
				单位所在地</td>
				<td colspan="3" class="table_color_l"><input
					name="agentcityid" type="text" id="agentcityid" size="80" /><span id="agentcityid2" class="font-red">*</span></td>

			</tr>
			<tr>
				<td align="right" class="table_color_r colortrin">通信地址</td>
				<td colspan="3" class="table_color_l " style="text-align: left;"><input
					name="agentaddress" type="text" id="agentaddress" size="80" /><span id="agentaddress2" class="font-red">*</span></td>
			</tr>
		</table>

		<div align="center" style="margin-top: 10px; height: 40px;"><input
			type="submit" class="button_d font-white" value="确 认" /> <input
			type="button" class="button_d font-white" value="返 回"
			onclick="javascript:window.history.go(-1)" /> <input
			name="txtdeptId" type="hidden" id="txtdeptId" /> <input
			name="HidCity" type="hidden" id="HidCity" /></div>
		</td>
	</tr>
</table>
</div>
<div></div>
<div><strong><span class="font-red">注意事项:</span></strong> <br />
<ul style="padding-left: 30px;">
	<li>默认为全部选择 即该帐户拥有所有权限</li>
	<li>点击模块选择框 该下属选择框 默认为相同状态</li>
	<li>没有选择的功能 将被视为该帐户禁止使用的功能</li>
</ul>
</div>
</body>
</html>



