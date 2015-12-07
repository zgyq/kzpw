<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<LINK rel=stylesheet type=text/css href="style/text.css">  
<LINK rel=stylesheet type=text/css href="css/train.css">  

 
<style>
.button1{background:url(images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-weight:bold;cursor:pointer;}

</style>

<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"
href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>



</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;售票点维护</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			action="trainroom!editroom.action"><input type="hidden"
			name="is_first" />
			<input type='hidden' name='id' value='<ww:property value="trainroom.id"/>' />
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">

			<tr>
				<td valign="top">

				<table width="80%" border="1" bordercolor="#86B2D1" cellspacing="0"
					cellpadding="0"
					style="line-height: 28px; padding-top: 10px; text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px;">

					<tr>
						<td align="right" style="background: #daf0fc">代售点名称：</td>
						<td><input name="name" value='<ww:property value="trainroom.name"/>' /></td>
						
					</tr>
					<tr>
						<td align="right" style="background: #daf0fc">服务时间：</td>
						<td>
						<input name="opentime" size='10' onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm'})" value='<ww:property value="trainroom.opentime"/>'/>-
						<input name="closetime" size='10' onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm'})" value='<ww:property value="trainroom.closetime"/>'/>
						</td>
					</tr>
					<tr>	
						<td align="right" style="background: #daf0fc">联系电话：</td>
						<td><input name="tel" value='<ww:property value="trainroom.tel"/>'/></td>
					</tr>	
					<tr>
					<td align="right" height="50" style="background: #daf0fc">地点：</td>
						<td>
						<textarea name="address"  rows="2" cols="30"><ww:property value="trainroom.address"/></textarea>
						</td>
					</tr>
					<tr>
					<td colspan="2" height="50" style="padding-left: 140px">
					<input type="submit" class="button1" value="提交" />
					</td></tr>			
				</table>
				</td>
			</tr>

		</table>
		<table></table>
		</form>
		

		</td>
	</tr>
</table>
</body>
<script>
</script>
</html>






