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
<title><ww:if test="aircompany.id>0">编辑</ww:if><ww:else>新增</ww:else>航空公司基础信息表</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link href="../style/base.css" rel="stylesheet" />
<link href="../style/text.css" rel="stylesheet" />
</head>

<body style="height:100%; margin: 0; padding: 0;"> 
<div id="member" class="box" style="height:99%;position:absolute;float:left; width: 99%;">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" >
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;自由转账</span>
		</td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="../../lthk_interface/Alipayfen" name="form1" method="post">

		<table width="99%" border="0" cellpadding="0" cellspacing="0"
			style="margin: 0 auto;">
			<tr>
				<td height="100%">
				<table border="0" cellpadding="0" cellspacing="0" width="100%"
					style="border-collapse: collapse;">
					<tr>
						<td colspan="4">&nbsp;
						<% 
							com.alipay.util.UtilDate date = new com.alipay.util.UtilDate(); //调取支付宝工具类生成订单号
							String get_order = date.getOrderNum();
							
						%>
						<input type="hidden" name="get_order" value="<%=get_order%>"/>
						<input type="hidden" name="subject" value="东方航空自由转账<%=get_order%>"/>
						<input type="hidden" name="body" value="自由转账服务"/>
						<input type="hidden" name="total_fee1" value="0.01"/>
						</td>
					</tr>
					<tr>
						<td height="28" align="right" width="10%" class="table_color_r colortrin"><span>收款账户：</span></td>
						<td class="table_color_l" width="40%"><input type="text" name="royalty_parameters_id" value="420189155@qq.com"/>
						</td>
						<td height="28" align="right" width="10%"  class="table_color_r colortrin"><span>收款金额：</span></td>
						<td class="table_color_l"><input type="text" name="royalty_parameters_money" value="0.01"/>
						</td>
					</tr>
					<tr>
						<td height="28" align="right" width="10%" class="table_color_r colortrin"><span>付款描述：</span></td>
						<td class="table_color_l" width="40%"><input type="text" name="royalty_parameters_desc" value="分润描述"/>
						</td>
						<td height="28" align="right" width="10%"  class="table_color_r colortrin"><span>付款账号：</span></td>
						<td class="table_color_l"><input type="text" name="buyer_email" value="420189155@qq.com"/>
						</td>
					</tr>
					<tr>
						<td colspan="4">
						<span style="font-weight: bold; font-size: 13px;">备注:</span><br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.安全(付款用户必须安装数字证书)<br />
					&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;2.无论转账多少,只收取0.5元/笔<br />
					&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;3.自由转账,及时到收款方账户
						</td>
					</tr>
					<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center">
						<div style=" position: relative; width: 220px;">
						<input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='aircompany.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " />
					</td>
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


