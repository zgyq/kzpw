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
<title><ww:if test="changPass
		.id>0">编辑</ww:if><ww:else>新增</ww:else>变更记录
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
</head>

<body>
<div id="member">
<form action="changpass!add.action" name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="changPass
		.id>0">编辑</ww:if><ww:else>新增</ww:else>变更记录
		</span></b></td>
	</tr>
		<td align="center">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="font-blue-xi" style=" border-collapse:collapse; ">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
			 
		<tr>
		<td colspan="6" style="color: red">此功能只能申请变更乘机人证件号码,请谨慎操作!如需更改,请在备注里面描述清楚,那个乘机人对应的票号,已经更改后的号码!</td>
		</tr>
		

		<ww:iterator value="listPassenger">			 
		 <tr>
				<td style="text-align: right;" class="table_color colortrin">
					姓名
						:<span style="color:red;">*</span>
				</td>
				<td  align="left" class="table_color_l">
					<input type="text" readonly="readonly" disabled="disabled"  value='<ww:property value="name"/>'  />
				</td>
				<td style="text-align: right;" class="table_color colortrin">
					票号
						:<span style="color:red;">*</span>
				</td>
				<td   align="left" class="table_color_l">
					<input type="text" readonly="readonly" disabled="disabled"  value='<ww:property value="ticketnum"/>'  />
				</td>
			
						 
				<td   style="text-align: right;" class="table_color colortrin">
					号码:<span style="color:red;">*</span>
				</td>
				<td  class="table_color_l" align="left">
					<input type="text"  disabled="disabled" value='<ww:property value="idnumber"/>'  />
				</td>
		</tr>
	
	</ww:iterator>	
		
		<input type="text" id="orderid" name="orderid" value='<ww:property value="orderinfo.id"/>'  />
		
		<!-- 隐藏于 -->
		
		    <tr>
				<td  width="100%" class="table_color colortrin" colspan="6">
					备注:<textarea rows="10" cols="80"  id="descinfo" name="descinfo"><ww:property value="listChangpass.get(0).descinfo"/></textarea>
				</td>
				
			</tr>
			<tr>
				<td colspan="4" height="40" bgcolor="ffffff">
				<ww:if test="listChangpass.size()==0">
				<input type="button" onclick="sub();"
							class="button_d font-bai" value="提交"
							/ style="margin-right: 55px;">
				</ww:if>			
							
							 <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='changPass.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
			</tr>
		</table>
		</td>
		<tr>
		<td>
			&nbsp;
		</td>
		</tr>
</table>
</form>
</div>
</body>
</html>

<script>	
 

 function sub()
 {
  	if(confirm("是否确定对当前订单变更操作？")){
    document.form1.submit();
 }
 
 
 
 


 }
</script>	