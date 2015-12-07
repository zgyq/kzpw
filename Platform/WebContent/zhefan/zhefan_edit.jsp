<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: B2B2C 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="zhefan.id>0">编辑</ww:if><ww:else>新增</ww:else>折返
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<form action="zhefan!<ww:if test="isadd>0">edit.action?id=<ww:property value="zhefan2.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="zhefan
		.id>0">编辑</ww:if><ww:else>新增</ww:else>折返 </span></b></td>
	</tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">




				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">折扣始<ww:property value="zhe_fan.id" /> :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="szhe
						"
						value='<ww:property value="zhefan2.szhe"/>' " style="width: 300px" />折 &nbsp;(大于)
					</td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">折扣终 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="endzhe
						"
						value='<ww:property value="zhefan2.endzhe
						"/>'
						" style="width: 300px" />折 &nbsp;(小于或等于)</td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">折返 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="zhefan
						"
						value='<ww:property value="zhefan2.zhefan"/>'
						" style="width: 300px" />元</td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">描述 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="miaoshu
						"
						value='<ww:property value="zhefan2.miaoshu
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<!--<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">创建人 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="userid
						"
						value='<ww:property value="zhefan.userid"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段1 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="param1
						"
						value='<ww:property value="zhefan.param1
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段2 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="param2
						"
						value='<ww:property value="zhefan.param2"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段3 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="param3
						"
						value='<ww:property value="zhefan.param3
						"/>'
						" style="width: 300px" /></td>
				</tr>


				<td width="5%" height="30" style="text-align: right;"
					class="table_color colortrin">状态 :<span style="color: red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				<input type="text" name="state
						"
					value='<ww:property value="zhefan.state
						"/>'
					" style="width: 300px" /></td>
				</tr>



				--><tr>
					<td align="center" colspan="4" height="40" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='zhefan.action?<ww:property value="url"/>';"
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


