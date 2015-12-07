<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2009
	 *
	 *
	 *  HISTORY
	 *  
	 *  2009/08/14 创建
	 *
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="province.id>0">编辑</ww:if><ww:else>新增</ww:else>省份</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script type="text/javascript" src="../js/validator.js"></script>
<script type='text/javascript'
	src='../dwr/interface/dwrservice.js'></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<link rel="stylesheet" type="text/css"
	href="../js/resources/css/ext-all.css" />
<script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../js/ext-all.js"></script>
<link href="../css/base.css" rel="stylesheet" />

</head>

<body>
<form
	action="province!<ww:if test="province.id>0">edit.action?id=<ww:property value="province.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<!--<td width="100%" height="29"  background="../images/jb.gif" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="province.id>0">编辑</ww:if><ww:else>新增</ww:else>省份</span></td>
      -->
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="display: block; float: left;">&nbsp;&nbsp;&nbsp;<ww:if
			test="province.id>0">编辑</ww:if><ww:else>新增</ww:else>省份</span> <span
			style="display: block; width: 356px; float: right;">
		
		</span></td>
	</tr>
	<tr>
		<td height="100%">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td width="196" height="18">&nbsp;</td>
				<td width="569">&nbsp;</td>
			</tr>





			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">名称：</span></td>
				<td><input type="text" require="true" dataType="Require"
					msg="名称不能为空" name="name"
					value='<ww:property value="province.name"/>' " style="width: 350px"
					<ww:if test="province.id>0"></ww:if>
					<ww:else>onblur="checkProName(this.value);" onfocus="document.getElementById('pronamespan').innerHTML = '';"</ww:else> /><span
					id="pronamespan"></span></td>
			</tr>



			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">英文全拼：</span></td>
				<td><input type="text" require="true" dataType="Require"
					msg="英文全拼不能为空" name="enname"
					value='<ww:property value="province.enname"/>'
					" style="width: 350px" /></td>
			</tr>



			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">英文简拼：</span></td>
				<td><input type="text" require="true" dataType="Require"
					msg="省份代码不能为空" name="code"
					value='<ww:property value="province.code"/>' " style="width: 350px" /></td>
			</tr>
			
			

			<tr class="font-blue-xi">
				<td height="54" rowspan="2"></td>
				
				<td height="46" scrolling="no">
				<div style=" position: relative;">
				<input type="submit"
					class="button_h font-red" value="提交" /> <input type="button"
					class="button_h font-red"
					onclick="window.location.href='province.action?<ww:property value="url"/>';"
					name="Submit2" value=" 取消返回 " />
					
						
				</div>	
					</td>
			</tr>
			<tr>
				<td height="17">&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>





</form>
</body>
</html>
<script type="text/javascript">
	function checkProName(name)
	{
		dwrservice.equelsProName(name,citycallback);
	}
	function citycallback(data)
	{
		if(data.length>0){
			document.getElementById('pronamespan').innerHTML = '*该省份名称已经存在';
		}
	}
</script>

