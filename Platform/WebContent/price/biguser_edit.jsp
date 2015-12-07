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
<title><ww:if test="biguser.id>0">编辑</ww:if><ww:else>新增</ww:else>大客户关联金额表</title>

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
			test="biguser.id>0">编辑</ww:if><ww:else>新增</ww:else>大客户关联金额表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		
<ww:if
test="biguser.id>0"><form action="biguser!edit.action?id=<ww:property value="biguser.id"/>" name="form1" method="POST" ></ww:if><ww:else>
<form action="biguser!add.action" name="form1" method="POST" >
</ww:else>


		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>





					<tr>
						<td height="28" align="right"><span>大客户：</span></td>
						<td><input type="text" require="true" dataType="Require" disabled="disabled"
							msg="大客户ID不能为空" 
							value='<ww:property value="getangentname(customeragent.id)"/>'
							" style="width: 350px" /></td>
					</tr>
				<input type="hidden" name="agentid" value='<ww:property value="customeragent.id"/>' />


					<tr>
						<td height="28" align="right"><span>信用额度：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="信用额度不能为空" name="creditprice"
							value='<ww:property value="biguser.creditprice"/>'
							" style="width: 350px" /></td>
					</tr>
					<!--



					<tr>
						<td height="28" align="right"><span>已用额度：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="已用额度不能为空" name="yyongprice"
							value='<ww:property value="biguser.yyongprice"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>可用额度：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="可用额度不能为空" name="kyongprice"
							value='<ww:property value="biguser.kyongprice"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>创建人：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="创建人不能为空" name="createuserid"
							value='<ww:property value="biguser.createuserid"/>'
							" style="width: 350px" /></td>
					</tr>



					-->
					<tr>
						<td height="28" align="right"><span>备注：</span></td>
						<td><input type="text" require="true" dataType="Require"
							msg="备注不能为空" name="comment"
							value='<ww:property value="biguser.comment"/>'
							" style="width: 350px" /></td>
					</tr>





					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='customeragent!tobiguser.action';"
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


