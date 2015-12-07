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
<title>查看消息公告</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;查看消息公告</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="70%" cellpadding="0" cellspacing="10" border="0" align="center">
					<tr>
						<td width="569">&nbsp;</td>
					</tr>
					<!--
					<tr>
						<td height="28" align="right"><span>创建者ID：</span></td>
						<td><input type="text" name="customeruserid"
							value='<ww:property value="sysmessage.customeruserid"/>'
							style="width: 350px" /></td>
					</tr>
					-->
				
					<tr>
						<td align="center">
							<font style="font-size:36px; font-weight: bold; line-height: 36px;"><ww:property value="sysmessage.title"/></font>
						</td>
					</tr>
						<tr>
						<td align="center">
							类型：
							<ww:if test="sysmessage.type==0">
							系统公告
							</ww:if>
							<ww:elseif test="sysmessage.type==1">
							机票公告
							</ww:elseif>
							<ww:elseif test="sysmessage.type==2">
							站内消息
							</ww:elseif>
							&nbsp;&nbsp;&nbsp;
							最后修改时间：
							<ww:property value="formatTimestamp(sysmessage.modifytime)"/>
							&nbsp;&nbsp;&nbsp;
							发布人：<ww:property value="sysmessage.createuser" />
						</td>
					</tr>
					<!--<tr>
						<td height="28" align="right"><span>截止时间：</span></td>
						<td><input type="text" name="s_endtime"
							value='<ww:property value="formatDate(sysmessage.endtime)"/>'
							style="width: 350px" onfocus="WdatePicker()" class="Wdate" /></td>
					</tr>
					<tr>
						<td>
							<ww:if test="sysmessage.state==0">
								禁用
							</ww:if> 
							<ww:else>
								启用&nbsp;
							</ww:else>
						</td>						
					</tr>-->	
					<tr>
						<td>
							<table width="70%" cellpadding="0" cellspacing="0" border="0" align="center">
								<tr>
									<td>
										<ww:property value="sysmessage.content"/>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="46" align="center"> 
							 <input type="button"
							class="button_d font-bai"
							onclick="testclose()"
							name="Submit2" value=" 关闭 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>
<script type="text/javascript">

function testclose(){

parent.closetab();
}
</script>
