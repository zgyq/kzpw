<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有，thunder
	 * Author: thunder
	 * copyright: 2011
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><ww:if test="systemrole.id>0">编辑</ww:if><ww:else>新增</ww:else>角色</title>
<link href="css/default.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script language="javascript" type="text/javascript"
	src="js2/My97DatePicker/WdatePicker.js"></script>
<script src="js2/validate/jquery-1.4.min.js" type="text/javascript"></script>
<script src="js2/validate/jquery.validationEngine-cn.js"
	type="text/javascript"></script>
<script src="js2/validate/jquery.validationEngine.js"
	type="text/javascript"></script>


<script>	
		$(document).ready(function() {
			
			$("#form1").validationEngine()
		
		});
	</script>



</head>


<body>

<form
	action="systemrole!<ww:if test="systemrole.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="top" background="images/titleL3_bg.gif">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><img src="images/titleL3_point.gif" width="33" height="19"><span
					class="txt_title3"> <ww:if test="systemrole.id>0">编辑</ww:if><ww:else>新增</ww:else>角色</span>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td valign="bottom">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width=42 nowrap>&nbsp;</td>
								<td nowrap>&nbsp;</td>
							</tr>
						</table>

						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<table border="0" width="100%" align="center">












	<tr class="tr2" align="center">
		<td align="right">操作名称：</td>
		<td><input type="text" id="name" class="validate[required]"
			name="name" value='<ww:property value="systemrole.name"/>' /></td>
	</tr>



	<tr class="tr1" align="center">
		<td align="right">类型：</td>
		<td><select name="bussinessid" style="width: 155px">
						<option value='0'></option>
						<ww:iterator value="getLoginsessionagent().bussinesslist">
						<option  <ww:if test="systemrole.bussinessid==id">selected="selected"</ww:if>  value='<ww:property value="id"/>'>
						<ww:property value="name"/>
						</option>
						</ww:iterator>
						</select>
		</td>
	</tr>



	<tr class="tr1" align="center">
		<td align="right">角色类型：</td>
		<td><select name="type" id="type" style="width:155px">
							<option value="1" <ww:if test="systemrole.type==1">selected</ww:if> >运营商</option>
							<option value="2" <ww:if test="systemrole.type==2">selected</ww:if>>供应商</option>
							<option value="3" <ww:if test="systemrole.type==3">selected</ww:if>>分销商</option>
							<option value="4" <ww:if test="systemrole.type==4">selected</ww:if>>大客户</option>
							
							</select></td>
	</tr>








	<tr class="tr0" >
	<td></td>
		<td height="30" align="left"  ><input class="a"
			type="submit" value=" 提 交 " /> <input type="button"
			onclick="reset();" name="Submit2" value=" 重 置 " /></td>
	</tr>

</table>



</form>
</body>
</html>



