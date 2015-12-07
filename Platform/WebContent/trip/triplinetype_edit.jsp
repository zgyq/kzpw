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
<title><ww:if test="triplinetype.id>0">编辑</ww:if><ww:else>新增</ww:else>旅游线路类型表</title>
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
<script type="text/javascript">
function form_validate()
{
    if($("#txtname").val()=="")
    {
        alert("旅行线路类型名称不能为空，请重新填写！");
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
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="triplinetype!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="tripnode.id>0">编辑</ww:if><ww:else>新增</ww:else>注意事项</span>
		<span
			style="display: block;width: 356px; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 356px;">
			<tr>
				<ww:if test="triplinetype.id>0||triplinetype.language>0">
				<td width="22%"><a href="#" onclick="addlanguage(<ww:property value="triplinetype.ucode"/>,0)" <ww:if test="triplinetype.language==0">class="add"</ww:if>><img
					src="images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="22%"><a href="#" onclick="addlanguage(<ww:property value="triplinetype.ucode"/>,1)" <ww:if test="triplinetype.language==1">class="add"</ww:if>><img src="images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="22%"><a href="#" onclick="addlanguage(<ww:property value="triplinetype.ucode"/>,2)" <ww:if test="triplinetype.language==2">class="add"</ww:if>><img src="images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="triplinetype.ucode"/>,3)" <ww:if test="triplinetype.language==3">class="add"</ww:if>><img src="images/yin.gif" width="27px"
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
			action="triplinetype!<ww:if test="triplinetype.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
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
						<td height="28" align="right"><span>旅行线路类型名称：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="旅游线路类型名称不能为空" name="name" id="txtname"
							value='<ww:property value="triplinetype.name"/>'
							" style="width: 300px" />&nbsp;<span style="color:red">*</span></td>
					</tr>
					
					
					<!-- 支持多语言开始 替换对应的类名-->
					<ww:if test="triplinetype.language>0">
					<input id="language" type="hidden" name="triplinetype.language" value="<ww:property value="triplinetype.language"/>"/>
					</ww:if>
					<ww:else>
					<input id="language" type="hidden" name="triplinetype.language" value="0"/>
					</ww:else>
					<input id="ucode"  type="hidden" name="triplinetype.ucode" value="<ww:property value="triplinetype.ucode"/>"/>
			<!-- 支持多语言结束 -->
					<tr>
						<td height="10"></td><td></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='triplinetype.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td><td></td>
					</tr>
					<tr class="font-blue-xi">
						<td align="right" valign="top">注意事项：</td><td>1.*为必填项<br />2.此处填写旅行线路类型，如“自由行”</td>
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


