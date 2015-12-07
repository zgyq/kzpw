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
<title><ww:if test="eaccount
		.id>0">编辑</ww:if><ww:else>新增</ww:else>外部账号
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<form action="eaccount
		!<ww:if test="eaccount
		.id>0">edit.action?id=<ww:property value="eaccount
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="eaccount
		.id>0">编辑</ww:if><ww:else>新增</ww:else>外部账号
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
					名称(填写后不可修改)
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
				<ww:if test="eaccount.id>0">
				<input type="text"  name="name
						" value='<ww:property value="eaccount.name"/>'" style="width: 300px" readonly="readonly" />
				</ww:if><ww:else>
				<input type="text"  name="name
						" value='<ww:property value="eaccount.name"/>'" style="width: 300px" />
				</ww:else>
				
					
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					简介
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="edesc
						" value='<ww:property value="eaccount.edesc
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					链接地址
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="url
						" value='<ww:property value="eaccount.url"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					账号
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="username
						" value='<ww:property value="eaccount.username
						"/>'" style="width: 300px" />
				</td>
		</tr>
	
	<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					支付后返回地址
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="payurl
						" value='<ww:property value="eaccount.payurl"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					自动代扣(51book下单用,必须在51绑定支付账号才能使用)
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				
				<ww:if test="eaccount.id>0">
				<input type="radio" name="ispay" value="1" <ww:if test="eaccount.ispay.equals(\"1\")">checked</ww:if> />启用
				<input type="radio" name="ispay" value="0" <ww:if test="eaccount.ispay.equals(\"0\")">checked</ww:if> />禁用
				</ww:if><ww:else>
				<input type="radio" name="ispay" value="1" checked />启用
				<input type="radio" name="ispay" value="0" />禁用
				</ww:else>
				
				
					
				</td>
		</tr>
		
		

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					下级账号(今日)
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="xiausername
						" value='<ww:property value="eaccount.xiausername"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					密钥(今日)
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="key
						" value='<ww:property value="eaccount.key
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					密码
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="password
						" value='<ww:property value="eaccount.password"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					安全码
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="pwd
						" value='<ww:property value="eaccount.pwd
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
		 
		 <td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					通知地址
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="nourl
						" value='<ww:property value="eaccount.nourl
						"/>'" style="width: 300px" />
				</td>
				
				
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					状态
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
				<ww:if test="eaccount.id>0">
				<input type="radio" name="state" value="1" <ww:if test="eaccount.state.equals(\"1\")">checked</ww:if> />启用
				<input type="radio" name="state" value="0" <ww:if test="eaccount.state.equals(\"0\")">checked</ww:if> />禁用
				</ww:if><ww:else>
				<input type="radio" name="state" value="1" checked />启用
				<input type="radio" name="state" value="0" />禁用
				</ww:else>
			
					
				</td>
		
	

		    
			<tr>
				<td colspan="4" height="40" bgcolor="ffffff">
				<input type="submit"
							class="button_d font-bai" value="提交"
							/ style="margin-right: 55px;"> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='eaccount.action?<ww:property value="url"/>';"
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


	