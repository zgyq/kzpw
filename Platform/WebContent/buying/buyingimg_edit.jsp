
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
<title><ww:if test="spotlineimg
		.id>0">编辑</ww:if><ww:else>新增</ww:else>团购线路图片信息
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<form enctype="multipart/form-data"
	action="buyingimg
		!<ww:if test="buyingimg
		.id>0">edit.action?id=<ww:property value="buyingimg
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="buyingimg
		.id>0">编辑</ww:if><ww:else>新增</ww:else>团购图片信息 </span></b></td>
	</tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">




				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">团购名称 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<ww:if test="buyingimg.id>0">
					<ww:property value="GetBuyingnameByid(buyingimg.buyingid)"/>
					<input type="hidden" name="s_buyingid" value='<ww:property value="buyingimg.buyingid"/>' style="width: 300px" />
					</ww:if><ww:else>
					<ww:property value="GetBuyingnameByid(s_buyingid)"/>
					<input type="hidden" name="s_buyingid" value='<ww:property value="s_buyingid"/>' style="width: 300px" />
					</ww:else>
					
					</td>

				</tr>


				<tr>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">图片说明 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<input type="text" name="name
						"
						value='<ww:property value="buyingimg.name"/>'
						" style="width: 300px" /></td>


				</tr>


				<tr>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">图片路径 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="file" name="files"
						value='<ww:property value="buyingimg.imgurl"/>'
						style="width: 300px" /></td>
				</tr>


				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备注 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					
					<textarea rows="5" cols="130" name="beizhu"><ww:property value="buyingimg.beizhu"/></textarea>
					</td>
				</tr>



				<!--<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					备用字段1
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="param1
						" value='<ww:property value="buyingimg.param1"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					备用字段2
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="param2
						" value='<ww:property value="buyingimg.param2
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					备用字段3
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text"  name="param3
						" value='<ww:property value="buyingimg.param3"/>'" style="width: 300px" />
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					状态
						:<span style="color:red;">*</span>
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text"  name="state
						" value='<ww:property value="buyingimg.state
						"/>'" style="width: 300px" />
				</td>
		</tr>
	

		    
			-->
				<tr>
					<td colspan="4" height="40" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='buyingimg.action?<ww:property value="url"/>';"
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


