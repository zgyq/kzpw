<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%/**
			 * 版权所有, 允风文化
			 * Author: 允风文化 项目开发组
			 * copyright: 2009
			 *
			 *
			 *  HISTORY
			 *  
			 *  2009/08/14 创建
			 */

		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="../js/resources/css/ext-all.css" />
<script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../js/ext-all.js"></script>
<link href="../style/base.css" rel="stylesheet" />
<link href="../style/text.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>
<script language="javascript" type="text/javascript"
	src="../My97DatePicker/WdatePicker.js"></script>
<link href="js/autocomplete/jquery.autocomplete.css" rel="stylesheet" />
<script type="text/javascript" src="../js/autocomplete/jquery.js"></script>
<script type="text/javascript"
	src="../js/autocomplete/jquery.autocomplete.js"></script>
<title>酒店列表</title>

</head>

<body>
<div id="cx">


<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;选择类型批量下网</span></td>
	</tr>
	<tr>
		<td height="455" valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>
						<form name="form1" id="form1" method="post" action="hotel!editsta.action">
						<table width="100%" height="120" border="0" align="center">
							
							
							<tr>
								
								<td align="right">酒店来源：</td>
								<td><select name="h_laiyuan" id="laiyuan" style="WIDTH: 120px"
									id="h_laiyuan">
									<option value="0">---请选择---</option>
									<option value="1" >7天</option>
									<option value="2" >中国订房网</option>
									
								</select></td>
								<input type="hidden" id="h_state" value="" name="h_state" />
								<td>
								<input type="button" value="批量下网" class="button_d font-white" onclick="sub(4);" />
								<input type="button" value="批量上网" class="button_d font-white" onclick="sub(3);" />
								
								</td>
							</tr>
							
						</table>
						</form>

						</td>
					</tr>
					
					<tr>
						<td>
											
						

						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="306" valign="top">
				
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>

</body>
</html>

<script type="text/javascript">

function sub(sta)
{
//alert(document.getElementById("laiyuan").value);
if(document.getElementById("laiyuan").value==0){
alert("请选择酒店来源后进行操作!");
return;
}
document.getElementById("h_state").value=sta;
document.form1.submit();

   
}



</script>
