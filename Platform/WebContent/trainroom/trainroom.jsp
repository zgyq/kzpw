<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<LINK rel=stylesheet type=text/css href="style/text.css">  
  
<LINK rel=stylesheet type=text/css href="css/train.css">  

<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>

<style>
.button1{background:url(images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-weight:bold;cursor:pointer;}

</style>

</head>
<body>
<div id="member" style="width: 100%">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;售票点维护</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			action="trainroom!addtrainroom.action"><input type="hidden"
			name="is_first" />

				<table width="80%" border="1" bordercolor="#86B2D1" cellspacing="0"
					cellpadding="0"
					style="line-height: 28px; padding-top: 10px; text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px;">

					<tr>
						<td  style="background: #daf0fc" align="right">代售点名称：</td>
						<td><input name="name" /></td>
						
						
					</tr>
					<tr>
					<td align="right" style="background: #daf0fc">联系电话：</td>
						<td><input name="tel"/></td>
					</tr>
					<tr>
						<td align="right" style="background: #daf0fc">服务时间：</td>
						<td>
						<input size='10' name="opentime" value='08:00'  onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm'})" />
						-
						<input size='10' name="closetime" value='18:00' onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm'})" /></td>
						
						
					</tr>	
					<tr>
					<td align="right" height="50" style="background: #daf0fc">地点：</td>
						<td>
						<textarea name="address" rows="2" cols="30"></textarea>
						</td>
					</tr>	
					<tr>
					<td colspan="2" height="50px;" style="padding-left: 140px;">
					    <input type="submit" class="button1" value="提交" />
					    </td>
					</tr>		
				</table>
		</form>
		

		</td>
	</tr>
	<tr>
	<td>

	<table border='1' width="80%" style="text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px; line-height:28px;" cellpadding="0" cellspacing="0">
	<thead style="background: #f0f0f0">
	<th>名称</th>
	<th>电话</th>
	<th>营业时间</th>
	<th>地点</th>
	<th>操作</th>
	</thead>
	<tbody>
	<ww:iterator value="trainroomlist">
	<tr>
	<td><ww:property value="name"/></td>
	<td><ww:property value="tel"/></td>
	<td><ww:property value="opentime"/>-<ww:property value="closetime"/></td>
	<td><ww:property value="address"/></td>
	<td valign="middle">
	<a onclick="onclick=updRoom(<ww:property value="id"/>)" href="javascript:void(0)"><img src="images/wrench.png" style="cursor: pointer;"   title="修改"  align="absmiddle" />修改</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick="onclick=delRoom(<ww:property value="id"/>)" href="javascript:void(0)"><img src="images/xxh.gif" style="cursor: pointer;"  title="删除"  />删除</a>
	</td>
	</tr>
	</ww:iterator>
	</tbody>
	</table>
	</td>
	</tr>
</table>
</body>
<script>
function updRoom(rid){
 window.location.href='trainroom!toeditroom.action?id='+rid;
}
function delRoom(rid){
 Ext.MessageBox.confirm("提示","确定删除本条记录？",function(obj){
 if(obj=='yes'){
 window.location.href='trainroom!delroom.action?id='+rid; 
 } 
 });
}
</script>
</html>






