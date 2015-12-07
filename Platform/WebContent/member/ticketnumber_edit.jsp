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
<title><ww:if test="ticketnumber.id>0">编辑</ww:if><ww:else>新增</ww:else>机票票号</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" href="style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script>	
		$(document).ready(function() {
			
			$("#form1").validationEngine();
		
		});
	</script>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="ticketnumber.id>0">编辑</ww:if><ww:else>新增</ww:else>机票票号</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form id="form1"
			action="ticketnumber!<ww:if test="ticketnumber.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return Validator.Validate(this,3)">



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td width="196" height="18">&nbsp;</td>
						<td width="569">&nbsp;</td>
					</tr>





					<tr>
						<td height="28" align="right"><span>机票类型：</span></td>
						<td>
						<select name="tickettypeid" style="width: 350px" >
						<ww:iterator value="listTickettype">
						<option value="<ww:property value="id"/>" <ww:if test="id==ticketnumber.tickettypeid">selected="selected"</ww:if>><ww:property value="typename"/></option>
						</ww:iterator>
						</select>
						</td>
					</tr>



					<tr>
						<td height="28" align="right"><span>开始票号：</span></td>
						<td><input type="text" id="beginnumber" desc="开始票号" class="validate[required,ajax[ajaxticketnumber]]"  name="beginnumber"
							value='<ww:property value="ticketnumber.beginnumber"/>'
							" style="width: 350px" /></td>
					</tr>



					<tr>
						<td height="28" align="right"><span>结束票号：</span></td>
						<td><input type="text" id="endnumber" desc="结束票号" class="validate[required,ajax[ajaxticketnumber]]" name="endnumber"
							value='<ww:property value="ticketnumber.endnumber"/>'
							" style="width: 350px" /></td>
					</tr>





					<tr>
						<td height="28" align="right"><span>票号备注：</span></td>
						<td><textarea name="description" cols="50" rows="5"><ww:property
							value="ticketnumber.description" /></textarea></td>
					</tr>







					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="submit"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="window.location.href='ticketnumber.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>





		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


