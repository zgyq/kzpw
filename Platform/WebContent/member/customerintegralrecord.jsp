<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>积分设置</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;会员积分记录查看</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id="form1" method="post" action="customerintegralrecord.action">

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr><td height="10px">&nbsp;</td></tr>
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
					<td valign="top" align="center" >
					<table width="95%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					<td align="right">会员姓名：</td>
					<td align="left" width="100px">
					<ww:property value="customername"/>
					<input type="hidden" name="customername" value='<ww:property value="customername"/>' />
					<input type="hidden" name="refuid" value='<ww:property value="customerintegralrecord.refuid"/>' />
					</td>
					<td align="right">订单号：</td>
					<td align="left"><input type="text" name="refordernumber" value='<ww:property value="customerintegralrecord.refordernumber"/>'/></td>
					<td align="right">获取时间：</td>
					<td align="left">
					<span style="HEIGHT: 71px"> 
					<input id="sqtime" style="WIDTH: 80px" name="s_begincreatetime"
											value="<ww:property value="s_begincreatetime"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" />- <input
											id="sqendtime" style="WIDTH: 80px" name="s_endcreatetime"
											value="<ww:property value="s_endcreatetime"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" /></span></td>
					</tr>
					</table>
					</td>
					</tr>
					<tr><td height="5px">&nbsp;</td></tr>
					<tr>
					<td align="center"><input type="submit" id="submitreg"
						class="button_d font-bai" value="查&nbsp;询" /></td>
					</tr>
					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="center">
								<table width="95%" cellspacing="0" cellpadding="0" border="1" style="border-right: 1px solid #fff;border-left: 1px solid #fff;border-top: 1px solid #fff; border-collapse:collapse " >
									
									<tr>
										<td  width="2%" align="center"><b>序号<b></td>
										<td  width="10%" align="center"><b>积分来源</b></td>
										<td  width="10%" align="center"><b>关联订单</b></td>
										<td  width="10%" align="center"><b>积分值</b></td>
										<td  width="10%" align="center"><b>获取时间</b></td>
										<td  width="20%" align="center"><b>积分说明</b></td>
									</tr>
									<ww:iterator value="listCustomerintegralrecord" status="state">
									<tr id="tr_agenttypeid_4">
										<td align="center">
										<ww:property value="#state.count"/>
										</td>
										<td  align="center">
										<ww:property value="scoresource"/>
										</td>
										<td  align="center">
										<ww:property value="refordernumber"/>
										</td>
										<td  align="center">
										<ww:property value="score"/>
										</td>
										<td  align="center">
										<ww:property value="createtime"/>
										</td>
										<td  align="left" style="padding-left: 5px" >
										<ww:property value="scorememo"/>
										</td>
									</tr>
									</ww:iterator>
									
									
								</table>
								</td>
							</tr>
							<tr>
								<td align="center" height="20px"></td>
							</tr>
							
						</table>
						
						</td>
					</tr>
					
				</table>
				</td>
			</tr>
		</table>
		<div style="text-align: center; width: 100%; padding-top: 10px;">
			  <ww:property value='getPagetwo(pageinfo,"pageinfo","customerintegralrecord.action","form1")' />
		   </div>
		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


