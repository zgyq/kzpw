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
<title><ww:if test="perworkload.id>0">编辑</ww:if><ww:else>新增</ww:else>人均工作量统计</title>

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
			test="perworkload.id>0">编辑</ww:if><ww:else>新增</ww:else>人均工作量统计</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="perworkload!<ww:if test="perworkload.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
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
						<td height="28" align="right"><span>员工号：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="员工号不能为空" name="usernumber"
							value='<ww:property value="perworkload.usernumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>姓名：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="姓名不能为空" name="name"
							value='<ww:property value="perworkload.name"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>张数：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="张数不能为空" name="ticketnumber"
							value='<ww:property value="perworkload.ticketnumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>金额：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="金额不能为空" name="ticketmoney"
							value='<ww:property value="perworkload.ticketmoney"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>废票张数：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="废票张数不能为空" name="tuinumber"
							value='<ww:property value="perworkload.tuinumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>废票金额：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="废票金额不能为空" name="tuimoney"
							value='<ww:property value="perworkload.tuimoney"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>部门：</span></td>
						<td>
							<select name="department">
							<ww:iterator value="listDepartment">
							<option value="<ww:property value="id"/>"
								<ww:if test="perworkload.department==id"> selected="selected"</ww:if>><ww:property value="name"/></option>
							</ww:iterator>
						</select></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>时间：</span></td>
						<td><input type="text" name="i_date"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"
							value='<ww:property value="i_date"/>' " style="width: 350px" />
						</td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='perworkload.action?<ww:property value="url"/>';"
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


