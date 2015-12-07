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
<title><ww:if test="triprangescenicspot.id>0">编辑</ww:if><ww:else>新增</ww:else>行程景点关联</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="triprangescenicspot!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="triprangescenicspot.id>0">编辑</ww:if><ww:else>新增</ww:else>行程景点关联</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="triprangescenicspot.id>0||triprangescenicspot.language>0">
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="triprangescenicspot.ucode"/>,0)" <ww:if test="triprangescenicspot.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="triprangescenicspot.ucode"/>,1)" <ww:if test="triprangescenicspot.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="triprangescenicspot.ucode"/>,2)" <ww:if test="triprangescenicspot.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="triprangescenicspot.ucode"/>,3)" <ww:if test="triprangescenicspot.language==3">class="add"</ww:if>><img src="images/yin.gif" width="27px"
					height="26px;" align="absmiddle" style="margin-right: 15px;">英语</a>&nbsp;&nbsp;</td>
				</ww:if>
				<ww:else>
				<td width="100%" align="right"><a href="#" class="add"><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		</table>
		
		</span></td>
	</tr>
	<!-- 支持多语言结束 -->
	<tr>
		<td valign="top">
		<form
			action="triprangescenicspot!<ww:if test="triprangescenicspot.id>0">edit.action?triprangescenicspot.id=<ww:property value="triprangescenicspot.id"/>&<ww:property value="triprangescenicspot.url"/></ww:if><ww:else>add.action?<ww:property value="triprangescenicspot.url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return Validator.Validate(this,3)">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>
					<tr>
						<td height="28" align="right"><span>行程ID：</span></td>
						<td><input type="text" name="triprangeid"
							value='<ww:property value="triprangescenicspot.triprangeid"/>'
							style="width: 350px" /></td>
					</tr>
					<tr>
						<td height="28" align="right"><span>景点ID：</span></td>
						<td><input type="text" name="scenicspotid"
							value='<ww:property value="triprangescenicspot.scenicspotid"/>'
							style="width: 350px" /></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='triprangescenicspot.action?<ww:property value="url"/>';"
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


