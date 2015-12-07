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
<title><ww:if test="city.id>0">编辑</ww:if><ww:else>新增</ww:else>地级市</title>

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
	action="city!<ww:if test="city.id>0">edit.action?id=<ww:property value="city.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	
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
					msg="名称不能为空" name="name" value='<ww:property value="city.name"/>'
					" style="width: 350px" <ww:if test="city.id>0"></ww:if>
					<ww:else>onblur="checkCityName(this.value);" onfocus="document.getElementById('citynamespan').innerHTML = '';"</ww:else> /><span
					id="citynamespan"></span></td>
			</tr>



			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">英文全拼：</span></td>
				<td><input type="text" require="true" dataType="Require"
					msg="英文全拼不能为空" name="enname"
					value='<ww:property value="city.enname"/>' " style="width: 350px" /></td>
			</tr>



			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">英文简称：</span></td>
				<td><input type="text" require="true" dataType="Require"
					msg="英文简称不能为空" name="sname"
					value='<ww:property value="city.sname"/>' " style="width: 350px" /></td>
			</tr>


			<!--  
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">优先级：</span></td><td>
	 -->
			<input type="hidden" require="false" dataType="Require" msg="优先级不能为空"
				name="sort" value='<ww:property value="city.sort"/>'
				" style="width: 350px" />

			<!-- 
	 </td>  </tr>
	  <input type="text" require="true" dataType="Require"   msg="省份id不能为空" name="provinceid" value='<ww:property value="city.province.name"/>'" style="width:350px" />
	 -->
			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">省份：</span></td>
				<td><SELECT ID="provinceid" NAME="provinceid"
					style="width: 350px">
					<ww:if test="city.id>0">
						<OPTION VALUE="<ww:property value="province.id"/>" SELECTED><ww:property
							value="province.name" />
					</ww:if>
					<ww:iterator value="listProvince">
						<ww:if test="province.id!=id">
							<OPTION VALUE="<ww:property value="id"/>"><ww:property
								value="name" />
						</ww:if>
					</ww:iterator>
				</SELECT></td>
			</tr>



			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">区号：</span></td>
				<td><input type="text" require="true" dataType="Require"
					msg="区号不能为空" name="areacode"
					value='<ww:property value="city.areacode"/>' " style="width: 350px" /></td>
			</tr>



			

			<tr class="font-blue-xi">
				<td height="54" rowspan="2"></td>
				<td height="46" scrolling="no">
				<div style=" position: relative;">
				<input type="submit"
					class="button_h font-red" value="提交" /> <input type="button"
					class="button_h font-red"
					onclick="window.location.href='city.action?<ww:property value="url"/>';"
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
	function checkCityName(name)
	{
		dwrservice.equelsCityName(name,citycallback);
	}
	function citycallback(data)
	{
		if(data.length>0){
			document.getElementById('citynamespan').innerHTML = '*该城市名称已经存在';
		}
	}
</script>

