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
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			});
			
});
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;积分设置</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id="form1" method="post" action="integral!edit.action">

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
					<tr><td align="right" width="120px"><b>注册赠送积分：</b></td>
					<td align="left" style="padding-left: 5px">
					<input desc="注册赠送积分" id='register0' class="validate[required,custom[onlyNumber]]" name="register<ww:property value="integral.agenttype"/>" value="<ww:property value="integral.registerscore"/>" ></td></tr>
					<tr><td align="right"><b>会员违约处罚积分：</b></td>
					<td align="left" style="padding-left: 5px">
					<input desc="会员违约处罚积分" id='validate0't class="validate[required,custom[onlyNumber]]" name="punish<ww:property value="integral.agenttype"/>" value="<ww:property value="integral.punishscore"/>" ></td></tr>
					<tr><td align="right"><b>会员后台预订：</b></td>
					<td align="left" style="padding-left: 5px">
					<input desc="会员后台预订" id='backorder0't class="validate[required,custom[onlyNumber]]" name="backorder<ww:property value="integral.agenttype"/>" value="<ww:property value="integral.backorderscore"/>" ></td></tr>
					<tr><td align="right"><b>会员网站预订：</b></td>
					<td align="left" style="padding-left: 5px">
					<input desc="会员网站预订" id='weborder0't class="validate[required,custom[onlyNumber]]" name="weborder<ww:property value="integral.agenttype"/>" value="<ww:property value="integral.weborderscore"/>" ></td></tr>
					</table>
					</td>
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
										<td  width="10%" align="center"><b>类别<b></td>
										<td  width="10%" align="center"><b>机票业务</b></td>
										<!-- 
										<td  width="10%" align="center"><b>酒店业务</b></td>
										<td  width="10%" align="center"><b>旅游业务</b></td>
										<td  width="10%" align="center"><b>租车业务</b></td>
										<td  width="10%" align="center"><b>充值业务</b></td>
										 -->
									</tr>
									<ww:iterator value="listIntegral">
									<tr id="tr_agenttypeid_4">
										<td align="left" style="padding-left: 40px">
										<b><ww:property value="getAgenttype(agenttype)"/></b>
										</td>
										<td  align="center">
										<input desc="" id='aircoeft<ww:property value="agenttype"/>' class="validate[required,custom[onlyDouble]]" type="text" style="width:40px" id="txtrebate_4_1" name='aircoeft<ww:property value="agenttype"/>' value='<ww:property value="aircoeft" />' /></td>
										<!-- 
										<td  align="center">
										<input  desc="" id='hotelcoeft<ww:property value="agenttype"/>' class="validate[required,custom[onlyDouble]]" type="text" style="width:40px" id="txtrebate_4_2" name='hotelcoeft<ww:property value="agenttype"/>' value='<ww:property value="hotelcoeft" />' /></td>
										<td  align="center">
										<input  desc="" id='travelcoeft<ww:property value="agenttype"/>' class="validate[required,custom[onlyDouble]]" type="text" style="width:40px" id="txtrebate_4_3" name='travelcoeft<ww:property value="agenttype"/>'  value='<ww:property value="travelcoeft" />' /></td>
										<td  align="center">
										<input  desc="" id='carrental<ww:property value="agenttype"/>' class="validate[required,custom[onlyDouble]]" type="text" style="width:40px" id="txtrebate_4_4" name='carrentalcoeft<ww:property value="agenttype"/>' value='<ww:property value="carrentalcoeft" />' /></td>
										<td  align="center">
										<input  desc="" id='recharge<ww:property value="agenttype"/>' class="validate[required,custom[onlyDouble]]" type="text" style="width:40px" id="txtrebate_4_5" name='rechargecoeft<ww:property value="agenttype"/>' value='<ww:property value="rechargecoeft" />' /></td>
										 -->
									</tr>
									</ww:iterator>
									
									
								</table>
								</td>
							</tr>
							<tr>
								<td align="center" height="20px"></td>
							</tr>
							<tr>
								<td align="center"><input type="submit" id="submitreg"
									class="button_d font-bai" value="修改" /></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%"> </td>
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


