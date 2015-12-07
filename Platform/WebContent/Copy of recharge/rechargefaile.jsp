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
<title>充值失败</title>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/template.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath() %>/js/jquery.validationEngine.js"
	type="text/javascript"></script>
	<script type="text/javascript">
	function showvmrecord(id)
	{
	   window.location.href="vmoneyrecord.action?s_agentid="+id;
	}
	</script>
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;充值结果</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="88%" style="padding-top: 10px;">
				<table width="88%" cellpadding="0" cellspacing="0" border="1"
					bordercolor="#a0cfee"
					style="margin: 0 auto; border-collapse: collapse;">

					<tr>
						<td colspan="4">
						<div style="padding-left: 20px;"><img src="images/fenge.gif"
							align="absmiddle">充值失败</div>
						</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;width:150px">
						<div class="td_color"><span>充值失败！原因：</span></div>
						</td>
						<td class="table_color_l" style="color: red;font-weight:bold">
						<ww:property value="#request.message"/>
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    </td>
						
					</tr>
					
				</table>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>


