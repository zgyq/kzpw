<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname} 火车票查询</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>



</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;订单详细信息</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			action="ofcard!toRechargeOrder.action"><input type="hidden"
			name="is_first" />
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">

			<tr>
				<td valign="top">

				<table width="99%" border="1" bordercolor="#86B2D1" cellspacing="0"
					cellpadding="0"
					style="line-height: 28px; padding-top: 10px; text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px;">

					<tr>
						<td class="table_color_r colortrin" align="right">车次：</td>
						<td><ww:property value="train.traincode" /></td>
						<td class="table_color_r colortrin" align="right">行程：</td>
						<td><ww:property value="train.startcity" />&nbsp;--&nbsp;<ww:property value="train.endcity" /></td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" align="right">坐席类型：</td>
						<td><ww:property value="train.seattypeval" /></td>
						<td class="table_color_r colortrin" align="right">购买数量：</td>
						<td><ww:property value="train.count" /></td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" align="right">出发日期：</td>
						<td><ww:property value="train.startdate" /></td>
						<td class="table_color_r colortrin" align="right">出发时间：</td>
						<td><ww:property value="train.starttime" /></td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" align="right">联系人：</td>
						<td><ww:property value="train.contactname" /></td>
						<td class="table_color_r colortrin" align="right">联系电话：</td>
						<td><ww:property value="train.contactmobile" /></td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" align="right">邮编：</td>
						<td><ww:property value="train.post" /></td>
						<td class="table_color_r colortrin" align="right">地址：</td>
						<td><textarea rows="2" cols="40" readonly="readonly"><ww:property
							value="train.deliveryadd" /></textarea></td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" align="right">订单状态：</td>
						<td><ww:property value="train.orderstatusval" /></td>
						<td class="table_color_r colortrin" align="right">支付状态：</td>
						<td><ww:property value="train.paystatusval" /></td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" align="right">订单总额：</td>
						<td><ww:property value="train.totalprice" /></td>
						<td class="table_color_r colortrin" align="right">可接受坐席：</td>
						<td><ww:property value="train.acceptseatval" /></td>
					</tr>
					<tr>
						<td class="table_color_r colortrin" align="right">预订人：</td>
						<td>
						<ww:property value="train.createuid" />|<ww:property value="train.memberid" />
						</td>
						<td class="table_color_r colortrin" align="right">预定日期：</td>
						<td><ww:property value="formatTimestamp(train.createtime)" /></td>
					</tr>
					<tr>
					  <td class="table_color_r colortrin" align="right">配送类型：</td>
					  <td>
					  <ww:property value="train.deliverytypeval"/>
					  </td>
					  <td class="table_color_r colortrin" align="right">其它要求：</td>
					  <td>
					  <ww:property value="train.memo"/>
					  </td>
					</tr>
					
					<ww:if test="trainpassengerlist.size>0">
						<tr>
							<td colspan="4">乘客信息：</td>
						</tr>
						<tr>
							<td colspan="4">
							<table width="90%" border="1" bordercolor="#86B2D1"
								cellspacing="0" cellpadding="0"
								style="line-height: 28px; padding-top: 10px; text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px;">
								<thead>
									<th>乘客姓名</th>
									<th>证件类型</th>
									<th>证件号码</th>
								</thead>
								<tbody>
									<ww:iterator value="trainpassengerlist">
										<tr>
											<td><ww:property value="name" /></td>
											<td><ww:property value="idtypeval" /></td>
											<td><ww:property value="idnumber" /></td>
										</tr>
									</ww:iterator>
								</tbody>
							</table>
							</td>
						</tr>
					</ww:if>
				</table>
				</td>
			</tr>

		</table>
		</form>


		</td>
	</tr>
</table>
</body>
</html>






