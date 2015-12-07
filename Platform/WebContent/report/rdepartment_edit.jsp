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
<title><ww:if test="rdepartment.id>0">编辑</ww:if><ww:else>新增</ww:else>部门销售汇总表</title>

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
<script language="JavaScript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>


<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="rdepartment.id>0">编辑</ww:if><ww:else>新增</ww:else>部门销售汇总表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="rdepartment!<ww:if test="rdepartment.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
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
						<td height="28" align="right"><span>张数：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="张数不能为空" name="ticketnumber"
							value='<ww:property value="rdepartment.ticketnumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>销售额：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="销售额不能为空" name="ticketmoney"
							value='<ww:property value="rdepartment.ticketmoney"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>利润：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="利润不能为空" name="profitmoney"
							value='<ww:property value="rdepartment.profitmoney"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>采购数量：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="采购数量不能为空" name="purchase"
							value='<ww:property value="rdepartment.purchase"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>供应数量：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="供应数量不能为空" name="supply"
							value='<ww:property value="rdepartment.supply"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>部门：</span></td>
						<td><select name="department">
							<option value="1"
								<ww:if test="rdepartment.department==1"> selected="selected"</ww:if>>出票组</option>
							<option value="2"
								<ww:if test="rdepartment.department==2"> selected="selected"</ww:if>>洪武路国内</option>
							<option value="3"
								<ww:if test="rdepartment.department==3"> selected="selected"</ww:if>>洪武路国际</option>
							<option value="4"
								<ww:if test="rdepartment.department==4"> selected="selected"</ww:if>>虹桥国内</option>
							<option value="5"
								<ww:if test="rdepartment.department==5"> selected="selected"</ww:if>>虹桥国际</option>
							<option value="6"
								<ww:if test="rdepartment.department==6"> selected="selected"</ww:if>>机场国内</option>
							<option value="7"
								<ww:if test="rdepartment.department==7"> selected="selected"</ww:if>>机场国际</option>
							<option value="8"
								<ww:if test="rdepartment.department==8"> selected="selected"</ww:if>>无锡</option>
						</select></td>
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
							onclick="window.location.href='rdepartment.action?<ww:property value="url"/>';"
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


