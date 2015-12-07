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
<title><ww:if test="triplinesource.id>0">编辑</ww:if><ww:else>新增</ww:else>旅游线路来源</title>
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
<script type="text/javascript">
function form_validate()
{
    if($("#txtname").val()=="")
    {
        alert("旅游线路来源名称不能为空，请重新填写！");
        return false;
    }
}
</script>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="triplinesource.id>0">编辑</ww:if><ww:else>新增</ww:else>旅游线路来源</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="triplinesource!<ww:if test="triplinesource.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST" onsubmit="return form_validate()">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>旅游线路来源名称：</span></td>
						<td><input type="text" require="true" dataType="Require"
							id="txtname" msg="旅游线路来源名称不能为空" name="name"
							value='<ww:property value="triplinesource.name"/>'
							" style="width: 300px" />&nbsp;<span style="color:red">*</span></td>
					</tr>
					<tr style="display: none">
						<td height="28" align="right" style="display: none"><span>UCODE：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="UCODE不能为空" name="ucode"
							value='<ww:property value="triplinesource.ucode"/>'
							" style="width: 350px" /></td>
					</tr>
					<tr style="display: none">
						<td height="28" align="right" style="display: none"><span>语种：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="语种不能为空" name="language" value='0' " style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="10"></td><td></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='triplinesource.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td><td></td>
					</tr>
					<tr class="font-blue-xi">
						<td align="right" valign="top">注意事项：</td><td>1.*为必填项<br />2.此处应该填写旅行社或代理商名称</td>
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


