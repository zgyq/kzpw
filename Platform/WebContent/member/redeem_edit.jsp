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
<title><ww:if test="redeem
		.id>0">编辑</ww:if><ww:else>新增</ww:else>积分兑换
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<form action="redeem
		!<ww:if test="redeem
		.id>0">edit.action?id=<ww:property value="redeem
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="redeem
		.id>0">编辑</ww:if><ww:else>新增</ww:else>积分兑换
		</span></b></td>
	</tr>
		<td align="center">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="font-blue-xi" style=" border-collapse:collapse; ">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
			 
		

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					礼品名称
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="giftname
						" value='<ww:property value="redeem.giftname"/>'" style="width: 300px" />
				</td>
				
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					消费积分
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="integral
						" value='<ww:property value="redeem.integral"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					联系人姓名
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="name
						" value='<ww:property value="redeem.name
						"/>'" style="width: 300px" />
				</td>
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					地址
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="address
						" value='<ww:property value="redeem.address
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					邮编
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="postcode
						" value='<ww:property value="redeem.postcode"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					手机
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="mobile
						" value='<ww:property value="redeem.mobile
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr> 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					状态
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<select name="state" style="width: 300px;">
					<option <ww:if test="redeem.state==1">selected="selected"</ww:if> value="1">待审核</option>
					<option <ww:if test="redeem.state==2">selected="selected"</ww:if> value="2">已审核</option>
					<option <ww:if test="redeem.state==3">selected="selected"</ww:if> value="3">待发货</option>
					<option <ww:if test="redeem.state==4">selected="selected"</ww:if> value="4">发货中</option>
					<option <ww:if test="redeem.state==5">selected="selected"</ww:if> value="5">已收货</option>
					</select>
				</td>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
				</td>
		
	
						
		</tr>
	

		    
			<tr>
				<td colspan="4" height="40" bgcolor="ffffff">
				<input type="submit"
							class="button_d font-bai" value="提交"
							/ style="margin-right: 55px;"> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='redeem.action?<ww:property value="url"/>';"
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


	