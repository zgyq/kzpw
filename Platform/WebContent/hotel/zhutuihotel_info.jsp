<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%/**
			 * 版权所有, 允风文化
			 * Author: 允风文化 项目开发组
			 * copyright: 2009
			 *  HISTORY
			 *  2009/08/14 创建
			 *
			 */
		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店</title>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
.spanwrong {
  height:23px; width:110px; border:#ffc4b3 1px solid; background:url(../images/wrorgt_icon.gif) #feebe6 4px -36px no-repeat; display:inline-block; line-height:23px; padding:0 5px 0 25px; overflow:hidden; color:#f00;
}
.spanright {
  height:25px; width:16px; border:#ccc 0px solid; background:url(../images/wrorgt_icon.gif) 0 2px no-repeat; display:inline-block; line-height:23px; padding:0 5px 0 25px; overflow:hidden;
}
</style>
 <link href="../css/base.css" rel="stylesheet"/>
<script src="../js/money.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
<script type="text/javascript" src="../js/jquery1.3.2.js"></script>
<script>
   function load()
   {}
</script>
</head>


	<body>

<form action="hotel!editzhutui.action?hid=<ww:property value="hotel.id"/>" name="form1" id="form1" method="post">
<input type="hidden" name="hotelId"
	value="<ww:property value="hotel.id"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="left" style="border:1px solid #99CBED; margin-bottom:4px;">

	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;设置酒店主推信息</span>
		</td>
	</tr>
	<tr>
	<td>
	  <table border="1" cellpadding="0" cellspacing="0" width="98%" border-color="#99CBED" style="margin: 0 auto; border-collapse: collapse">
	   <tr><td align="right">酒店名称:</td><td><ww:property value="hotel.name"/></td></tr>
	   <tr>	
	   <td style="TEXT-ALIGN: right" align=left>酒店卖点：</td>
		<td ><textarea id="sell" style="WIDTH: 600px; HEIGHT: 75px" name="sell"><ww:property value="hotel.sellpoint" /></textarea>
		</td>
		</tr>
		<tr>
		<td style="TEXT-ALIGN: right" align=left>排序：</td>
<td align=left><input id="pai"  name="pai" value="<ww:property value="hotel.sort" />" />
</td>
		</tr>
		<tr>
		<td colspan="2" style="text-align: center;"><input type="button" class="button_d font-white" onclick="checkban();"  value="改为主推酒店" /></td>
		</tr>
	  </table>
	

		
</td>
</tr>		
	
</table>
</form>
</body>

</html>
<script language="javascript">
function checkban(){

var txt = document.getElementById("pai").value;

var pattern=/^\+?[1-9][0-9]*$/;//只能输入数字
var sel = document.getElementById("sell").value;

		if(sel==''){
		alert("酒店卖点不能为空");
		return;
		}
		if(txt==''){
			alert("排序不能为空");
			return;
			}
		if(!pattern.exec(txt))
		{
		alert("只能输入正整数！");
		return;
		}
 
		document.form1.submit();
		
}
</script>
