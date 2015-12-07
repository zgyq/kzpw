
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="limitcabin
		.id>0">编辑</ww:if><ww:else>新增</ww:else>限制仓位
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<div id="member">
<form
	action="limitcabin
		!<ww:if test="limitcabin
		.id>0">edit.action?id=<ww:property value="limitcabin
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="limitcabin
		.id>0">编辑</ww:if><ww:else>新增</ww:else>限制仓位 </span></b></td>
	</tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">




				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">航空公司 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="name
						"
						value='<ww:property value="limitcabin.name"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">仓位 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="cabin
						"
						value='<ww:property value="limitcabin.cabin
						"/>'
						" style="width: 300px" /></td>
				</tr>
				<tr>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">开始时间 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="s_stime"
						value='<ww:property value="formatTimestamp2(limitcabin.stime)
						"/>'
						" style="width: 300px" onfocus="WdatePicker({skin:'whyGreen'})" /></td>


					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">结束时间 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="s_endtime"
						value='<ww:property value="formatTimestamp2(limitcabin.endtime)"/>'
						" style="width: 300px" onfocus="WdatePicker({skin:'whyGreen'})" /></td>


				</tr>



				<tr>




					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">状态 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<select name="state">
					
					<option value="1" <ww:if test="state==1">selected</ww:if>  >启用</option>
					<option value="2" <ww:if test="state==2">selected</ww:if>  >禁用</option>
					</select>
					</td>
				</tr>



				<tr>
					<td colspan="4" height="40" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='limitcabin.action?<ww:property value="url"/>';"
						name="Submit2" value=" 返回 " /></td>
				</tr>
			</table>
			</td>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>


