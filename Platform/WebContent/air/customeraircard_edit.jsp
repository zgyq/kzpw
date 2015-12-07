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
<title><ww:if test="customeraircard.id>0">编辑</ww:if><ww:else>新增</ww:else>里程卡</title>

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
		
		aircardnumber = document.getElementById('aircardnumber');
		if(aircardnumber.value == '') {
			document.getElementById("aircardnumberSp").innerHTML="*卡号不能为空";
			validate = false ;
			aircardnumber.focus();
		}else {
			document.getElementById("aircardnumberSp").innerHTML="*";
		}
		
		aircardtype = document.getElementById('aircardtype');
		if(aircardtype.value == '') {
			document.getElementById("aircardtypeSp").innerHTML="*卡类型不能为空";
			validate = false ;
			aircardtype.focus();
		}else {
			document.getElementById("aircardtypeSp").innerHTML="*";
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
			test="customeraircard.id>0">编辑</ww:if><ww:else>新增</ww:else>里程卡</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customeraircard!<ww:if test="customeraircard.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return form_validate()"><input
			type="hidden" name="refid"
			value='<ww:property value="customeraircard.refid"/>'
			style="width: 350px" />
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					style="border-collapse: collapse;">
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right" width="10%"
							class="table_color_r colortrin"><span>卡类型：</span></td>
						<td class="table_color_l" width="40%"><input type="text"
							name="aircardtype" id="aircardtype"
							value='<ww:property value="customeraircard.aircardtype"/>'
							style="width: 150px;margin-right: 5px;" /><span id="aircardtypeSp" class="font-red">*</span></td>
						<td height="28" align="right" width="10%"
							class="table_color_r colortrin"><span>卡号：</span></td>
						<td class="table_color_l"><input type="text"
							name="aircardnumber" id="aircardnumber"
							value='<ww:property value="customeraircard.aircardnumber"/>'
							style="width: 150px;margin-right: 5px;" /><span id="aircardnumberSp" class="font-red">*</span></td>
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


