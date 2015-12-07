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
<title>机票数据报表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<div id="member">
<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;机票销售量报表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="airreport!airreportsum.action">

		<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>    
						           <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
						           		<tr>
							             	<td width="184" height="30" align="right">时间：从&nbsp;</td>
											<td width="160"><span style="height: 71px"> <input
												id="Text2" style="width: 160px" name="s_begintime"
												value="<ww:property value="s_begintime"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /></span></td>
											<td width="29" height="40" align="right">到&nbsp;</td>
											<td width="181"><span style="height: 71px"> <input
												 style="width: 160px" name="s_endtime"
												value="<ww:property value="s_endtime"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /></span></td>
											<td width="134" rowspan="2" align="center">
		                                    </td>
										</tr>
						             </table>
        						</td>
							</tr>
							<tr>
								<td align="center"  height="58"><input type="button"
									class="button_d font-bai" onclick="document.form1.submit();"
									value="查询" />&nbsp;&nbsp;&nbsp;<input type="button"
									class="button_d font-bai" onclick="document.form1.action='airreport!airreportsumdown.action';document.form1.submit();"
									value="导出" /></td>
									
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td  valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th class="table_color">时间</th>
											<th class="table_color">航空公司</th>
											<th class="table_color">数量</th>
											<th class="table_color">金额</th>
										</tr>

										<ww:iterator value="list">
										<tr>
												<td class="table_color"><ww:property
													value="r_time" /></td>
												<td class="table_color"><ww:property
													value="r_aircomapnycode" /></td>
												<td class="table_color"><ww:property
													value="r_sum" /></td>
												<td class="table_color"><ww:property
													value="r_totalticketprice" /></td>
											</tr>
										</ww:iterator>
										<tr>
											<td colspan="4"></td>
										</tr>
									</tbody>
								</table>
								</td>
							</tr>
						</table>
						</td>
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




