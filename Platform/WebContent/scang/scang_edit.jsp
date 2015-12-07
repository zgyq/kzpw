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
<title><ww:if test="scang.id>0">编辑</ww:if><ww:else>新增</ww:else>订单升舱表</title>

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
			test="scang.id>0">编辑</ww:if><ww:else>新增</ww:else>订单升舱表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="scang!<ww:if test="scang.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			>



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>

					
					


					<tr>
					
						<td height="28" align="right"><span>订单号：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="订单号不能为空" name="ordercode" readonly="readonly"
							value='<ww:property value="orderinfo.ordernumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>订单ID：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="订单ID不能为空" name="orderid" readonly="readonly"
							value='<ww:property value="orderinfo.id"/>'
							" style="width: 350px" /></td>
					</tr>



					


					<tr>
						<td height="28" align="right"><span>升舱编码/PNR：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="升舱编码/PNR不能为空" name="pnr"
							value='<ww:property value="orderinfo.pnr"/>' " style="width: 350px" /></td>
					</tr>
					<!--



					<tr>
						<td height="28" align="right"><span>办理时间：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="办理时间不能为空" name="transacttime"
							value='<ww:property value="scang.transacttime"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>升舱效率：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="升舱效率不能为空" name="xiaolv"
							value='<ww:property value="scang.xiaolv"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>升舱状态：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="升舱状态不能为空" name="states"
							value='<ww:property value="scang.states"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>状态：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="状态不能为空" name="status"
							value='<ww:property value="scang.status"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>申请人：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="申请人不能为空" name="applyid"
							value='<ww:property value="scang.applyid"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>处理人：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="处理人不能为空" name="updateid"
							value='<ww:property value="scang.updateid"/>'
							" style="width: 350px" /></td>
					</tr>



					-->
					<tr>
						<td height="28" align="right"><span>差价：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="差价不能为空" name="price"
							value='<ww:property value="scang.price"/>'
							" style="width: 350px" /></td>
					</tr>
					
					<tr>
						<td height="28" align="right"><span>备注：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="备注不能为空" name="comment"
							value='<ww:property value="scang.comment"/>'
							" style="width: 350px" /></td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="javascript:history.go(-1);"
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


