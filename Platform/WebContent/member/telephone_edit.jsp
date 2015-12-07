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
<title><ww:if test="telephone.id>0">编辑</ww:if><ww:else>新增</ww:else>其他电话</title>

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
		
		telnumber = document.getElementById('telnumber');
		if(telnumber.value == '') {
			document.getElementById("telnumberSp").innerHTML="*电话号码不能为空";
			validate = false ;
			telnumber.focus();
		}else {
			document.getElementById("telnumberSp").innerHTML="*";
		}
		
		teltype = document.getElementById('teltype');
		if(teltype.value == '') {
			document.getElementById("teltypeSp").innerHTML="*类型不能为空";
			validate = false ;
		}else {
			document.getElementById("teltypeSp").innerHTML="*";
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
			test="telephone.id>0">编辑</ww:if><ww:else>新增</ww:else>其他电话</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="telephone!<ww:if test="telephone.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="post"
			onSubmit="return form_validate()"><input
			type="hidden" name="customeruserid"
			value='<ww:property value="telephone.customeruserid"/>' />
		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					style="border-collapse: collapse;">
					<tr>
						<td width="10%" height="18">&nbsp;</td>
						<td>&nbsp;</td>
						<td width="10%" height="18">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right" width="10%"
							class="table_color_r colortrin"><span>电话号码：</span></td>
						<td class="table_color_l" width="40%"><input type="text"
							name="telnumber" id="telnumber"
							value='<ww:property value="telephone.telnumber"/>'
							style="width: 150px;margin-right: 5px;" /><span id="telnumberSp" class="font-red">*</span></td>
						<td height="28" class="table_color_r colortrin" width="10%"><span>类型：</span></td>
						<td class="table_color_l"><input type="text" name="teltype" id="teltype"
							value='<ww:property value="telephone.teltype"/>'
							style="width: 150px;margin-right: 5px;" /><span id="teltypeSp" class="font-red">*</span></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center"><input
							type="submit" class="button_d font-bai" value="提交" /> <input
							type="button" class="button_d font-bai" onclick="history.back()"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17" colspan="4">&nbsp;</td>
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


