<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%/**
			 * 版权所有, 允风文化
			 * Author: B2BJOY 项目开发组
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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title><ww:if test="hotelspec.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店注意事项</title>
<link href="../css/base.css" rel="stylesheet" />
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>

<body>
<form
	action="hotelspec!<ww:if test="hotelspec.id>0">edit.action?id=<ww:property value="hotelspec.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">

<input type="hidden" name="hotelId" value="<ww:property value="hotelId"/>" />

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	
		<td width="100%" height="29" class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="hotelspec.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店注意事项</span></td>
	
	
	<tr>
		<td height="100%">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td width="196" height="18">&nbsp;</td>
				<td width="569"></td>
			</tr>


			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">酒店名称：</span></td>
				<td><ww:property value="hotelName" /></td>
			</tr>


			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">起始日期：</span></td>
				<td><input type="text" require="true" dataType="Require" msg="起始日期不能为空" name="starttimeStr"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value='<ww:property value="formatDate(hotelspec.startdate)"/>'
					" style="width:350px" /></td>
			</tr>



			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">终止日期：</span></td>
				<td><input type="text" require="true" dataType="Require" msg="终止日期不能为空" name="endtimeStr"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value='<ww:property value="formatDate(hotelspec.enddate)"/>'
					" style="width:350px" /></td>
			</tr>

<!--  

			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">状态：</span></td>
				<td><input type="text" require="true" dataType="Require" msg="状态不能为空" name="state"
					value='<ww:property value="hotelspec.state"/>' " style="width:350px" /></td>
			</tr>


-->




			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">描述：</span></td>
				<td><textarea name="description" cols="50" rows="5"><ww:property value="hotelspec.description" /></textarea></td>
			</tr>






			<tr class="font-blue-xi">
				<td height="54" rowspan="2"></td>
				<td height="46" scrolling="no"><div style=" position: relative;"><input type="submit" class="button_d font-white" value="提交" /> <input type="button"
					class="button_d font-white"
					onclick="window.location.href='hotelspec!tabs.action?&hotelId=<ww:property value="hotelId"/>&tabtype=cancelhotelspec&<ww:property value="url"/>';"
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


