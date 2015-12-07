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
<title><ww:if test="chaininfo.id>0">编辑</ww:if><ww:else>新增</ww:else>连锁酒店类型</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<script type="text/javascript">
	function selectall1(){
	    var length=document.form1.cityidstr.length;
	    document.form1.allselect.checked = document.form1.allselect.checked|0;
	  
	
	   if ( length ==undefined &&  document.form1.cityidstr!=null ){
	    	  document.form1.cityidstr.checked=document.form1.allselect.checked ;
	          return;
	    }
	
	
	    if (length>1)
	    {
	      for (var i = 0; i < length; i++)
	       {
	          document.form1.cityidstr[i].checked = document.form1.allselect.checked;
		      document.form1.getElementsByTagName("*").checked=document.form1.allselect.checked;
	       }
	    }
	}
</script>

</head>

<body>
<div id="member">
<form action="chaininfo
		!<ww:if test="chaininfo
		.id>0">edit.action?id=<ww:property value="chaininfo
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" enctype="multipart/form-data">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="chaininfo.id>0">编辑</ww:if><ww:else>新增</ww:else>连锁酒店类型
		</span></b></td>
	</tr>
		<td align="center">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="font-blue-xi" style=" border-collapse:collapse; ">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">			 
		 	<tr>
			<td width="10%" height="30" style="text-align: right;" class="table_color colortrin">
				名称:<span style="color:red;">*</span>
			</td>
			<td width="40%" height="30" align="left" class="table_color_l">
				<input type="text"  name="name" value='<ww:property value="chaininfo.name"/>'" style="width: 300px" />
			</td>
			<td width="10%" height="30" style="text-align: right;" class="table_color colortrin">
				图片地址1:<span style="color:red;">*</span>
			</td>
			<td width="40%" height="30" align="left" class="table_color_l">
				<input type="file"  name="files" id="files" value='<ww:property value="chaininfo.imagepic"/>'" style="width: 300px" />
				<ww:if test='chaininfo.imagepic != null '>
					<img src="<ww:property value="chaininfo.imagepic"/>" width="50"/>
				</ww:if>
			</td>
		</tr>
		<tr>
		 	<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
			描述:<span style="color:red;">*</span>
			</td>
			<td width="20%" height="50" class="table_color_l" align="left">
				<input type="text"  name="description" value='<ww:property value="chaininfo.description"/>'" style="width: 300px" size="50"/>
			</td>
			<td width="10%" height="30" style="text-align: right;" class="table_color colortrin">
				图片地址2:<span style="color:red;">*</span>
			</td>
			<td width="40%" height="30" align="left" class="table_color_l">
				<input type="file"  name="images" id="images" value='<ww:property value="chaininfo.imagepic2"/>'" style="width: 300px" />
				<ww:if test='chaininfo.imagepic2 != null '>
					<img src="<ww:property value="chaininfo.imagepic2"/>" width="50"/>
				</ww:if>
			</td>
		</tr>
		<tr>
			<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
				总数:<span style="color:red;">*</span>
			</td>
			<td width="10%" height="30" class="table_color_l" align="left">
				<input type="text"  name="total" value='<ww:property value="chaininfo.total"/>'" style="width: 300px" />
			</td>
			<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
				排序:<span style="color:red;">*</span>
			</td>
			<td width="10%" height="30" align="left" class="table_color_l">
				<input type="text"  name="sort" value='<ww:property value="chaininfo.sort"/>'" style="width: 300px" />
			</td>
		</tr>
		<tr>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
			<tr>
			<td width="9%" height="30" style="text-align: right;" class="table_color colortrin">
			选择城市:<br>
			<input type="checkbox" name="allselect" onclick="selectall1()">全选
			</td>
			<td width="80%" height="50" class="table_color_l" align="left">
				<ww:iterator value="listCity"  status="city">
				<input type="checkbox" name="cityidstr" <ww:if test="id == lountryid">  checked="checked" </ww:if> value="<ww:property value="id"/>"/><ww:property value="name"/>
				<ww:if test="#city.index>0 && #city.index % 15 == 0"><br/></ww:if>
				</ww:iterator>
			</td>
			</tr>
			</table>
		</tr>
		<tr>
			<td colspan="4" height="40" bgcolor="ffffff">
			<input type="submit" class="button_d font-bai" value="提交" style="margin-right: 55px;"> 
			<input type="button" class="button_d font-bai" onclick="window.location.href='systemright.action?<ww:property value="url"/>';" name="Submit2" value=" 返回 " /></td>
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


	