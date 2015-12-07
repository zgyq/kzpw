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
<title><ww:if test="infocontent.id>0">编辑</ww:if><ww:else>新增</ww:else>信息</title>

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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;查看帮助信息</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="infocontent!<ww:if test="infocontent.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return Validator.Validate(this,3)">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <!--  
					<tr>
						<td width="10%">&nbsp;</td>
						<td width="80%">&nbsp;</td>
						<td width="10%">&nbsp;</td>
					</tr>
			        -->
					<tr>
						<td align="right" class="tbody_color" width="10%">
						<h3>标题名称：</h3>
						</td>
						<td width="80%"><b><ww:property value="infocontent.title" />(所属帮助类型：<ww:property value="getHTypeName(infocontent.typeid)"/>)</b></td>
						<td width="10%"></td>
					</tr>
					<tr>
						<td align="right" class="tbody_color">
						<h3>帮助内容：</h3>
						</td>
						<td><ww:property value="infocontent.content" /></td>
						<td></td>
					</tr>
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="button"
							class="button_d font-bai"
							onclick="window.location.href='infocontent!searchhelpcenter.action';"
							name="Submit2" value=" 返回 " /></td>
						<td></td>
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


