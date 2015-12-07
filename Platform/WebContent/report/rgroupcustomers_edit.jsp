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
<title><ww:if test="rgroupcustomers.id>0">编辑</ww:if><ww:else>新增</ww:else>集团客户环比统计表</title>

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
<script language="JavaScript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="rgroupcustomers.id>0">编辑</ww:if><ww:else>新增</ww:else>集团客户环比统计表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="rgroupcustomers!<ww:if test="rgroupcustomers.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
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
						<td height="28" align="right"><span>集团客户ID：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="集团客户ID不能为空" name="groupcusid"
							value='<ww:property value="rgroupcustomers.groupcusid"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>集团客户名称：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="集团客户名称不能为空" name="groupname"
							value='<ww:property value="rgroupcustomers.groupname"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>金额：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="金额不能为空" name="money"
							value='<ww:property value="rgroupcustomers.money"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>时间：</span></td>
						<td><input type="text" name="i_date"
							value='<ww:property value="i_date"/>' 
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" style="width: 350px" /></td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='rgroupcustomers.action?<ww:property value="url"/>';"
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


