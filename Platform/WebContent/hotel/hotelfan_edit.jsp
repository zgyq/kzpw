
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
<title><ww:if test="hotelfan
		.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店设置返点表
</title>
<link href="../style/base.css" rel="stylesheet" />
<link href="../style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="../js/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>


</head>
<script>

$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});
</script>
<body>
<div id="member">
<form action="hotelfan!add.action?<ww:property value="url"/>" id="form1" name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="hotelfan
		.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店设置返点表 </span></b></td>
	</tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">

				

				<td width="5%" height="30" style="text-align: right;"
					class="table_color colortrin">开始时间 :<span style="color: red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				<input type="text" id="s_starttime" name="s_starttime" value='<ww:property value="hotelfan.starttime"/>'" style="width: 160px"  onfocus="WdatePicker()"   desc="开始时间" class="validate[required] Wdate"/></td>
				
				<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">结束时间 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" id="s_endtime" name="s_endtime" value='<ww:property value="hotelfan.endtime"/>'" style="width: 160px"  onfocus="WdatePicker()"  desc="结束时间" class="validate[required] Wdate" /></td>

				
				
				</tr>



				<tr>
				<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">价格范围 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" id="s_startprice" name="s_startprice" value='<ww:property value="hotelfan.startprice"/>'" style="width: 80px" desc="范围" class="validate[required,custom[onlyNumber]]" />---
					<input type="text"  id="s_endprice" name="s_endprice" value='<ww:property value="hotelfan.endprice"/>'" style="width: 80px" desc="范围" class="validate[required,custom[onlyNumber]]" /></td>
			
			
					
						<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">是否可以使用优惠券 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<select name="s_ifvoucher">
					<option value="1">可以</option>
					<option value="2">不可以</option>
					</select></td>
					
					

						</tr>



				<tr>
					

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">返点值 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" id="s_fan" name="s_fan" value='<ww:property value="hotelfan.fan"/>'" style="width: 160px"  desc="返点值" class="validate[required,custom[onlyNumber]]" />%</td>
				
			
				
				</tr>



				
<input type="hidden" name="s_hotelid" value='<ww:property value="selectid"/>'" style="width: 300px" />
				


				<!--<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">创建人id :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="memberid" value='<ww:property value="hotelfan.memberid"/>'" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">状态 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="status" value='<ww:property value="hotelfan.status"/>'" style="width: 300px" /></td>
				</tr>



				--><tr>
					<td colspan="4" height="40" bgcolor="ffffff">
					<input type="submit" id="submitreg" class="button_d font-bai" value="提交" style="margin-right: 55px;" /> 
					<input type="button" class="button_d font-bai" onclick="window.location.href='hotelfan.action?<ww:property value="url"/>';"
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


