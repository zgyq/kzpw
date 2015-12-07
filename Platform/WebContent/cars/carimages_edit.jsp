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
<title><ww:if test="carimages
		.id>0">编辑</ww:if><ww:else>新增</ww:else>汽车图片
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<form enctype="multipart/form-data" action="carimages
		!<ww:if test="carimages
		.id>0">edit.action?id=<ww:property value="carimages
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="carimages
		.id>0">编辑</ww:if><ww:else>新增</ww:else>汽车图片
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
					图片名称1
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
<input type="text"  name="c_name0" value='<ww:property value="carimages.name"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片路径1
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
<input type="file"  name="c_image0" value='<ww:property value="carimages.carurl"/>' style="width: 300px" />
				</td>
		</tr>
	
<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片名称2
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
<input type="text"  name="c_name1" value='<ww:property value="carimages.name"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片路径2
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
<input type="file"  name="c_image1" value='<ww:property value="carimages.carurl"/>' style="width: 300px" />
				</td>
		</tr>
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片名称3
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
<input type="text"  name="c_name2" value='<ww:property value="carimages.name"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片路径3
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
<input type="file"  name="c_image2" value='<ww:property value="carimages.carurl"/>' style="width: 300px" />
				</td>
		</tr>
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片名称4
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
<input type="text"  name="c_name3" value='<ww:property value="carimages.name"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片路径4
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
<input type="file"  name="c_image3" value='<ww:property value="carimages.carurl"/>' style="width: 300px" />
				</td>
		</tr>
		
		<!--<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片名称5
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
<input type="text"  name="c_name4" value='<ww:property value="carimages.name"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片路径5
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
<input type="file"  name="c_image4" value='<ww:property value="carimages.carurl"/>' style="width: 300px" />
				</td>
		</tr>
						 
		 --><tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					图片概述
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="cardesc" value='<ww:property value="carimages.cardesc"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					汽车ID
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				
				<ww:if test="cid==0">
				
					<select name="carid">
					<ww:iterator value="listCars">
					<option value="<ww:property value="id"/>"><ww:property value="name"/></option>
					</ww:iterator>
					</select>
				</ww:if><ww:else>
					<input type="text"  name="" value='<ww:property value="getcarnameBYid(cid)"/>'" disabled="disabled" style="width: 300px" />
					<input type="hidden"  name="carid" value='<ww:property value="cid"/>'" style="width: 300px" />
					</ww:else>
				</td>
		</tr>
	

		    
			<tr>
				<td colspan="4" height="40" bgcolor="ffffff">
				<input type="submit"
							class="button_d font-bai" value="提交"
							/ style="margin-right: 55px;"> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='carimages.action?<ww:property value="url"/>';"
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


	