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
<title><ww:if test="roomstate.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店房态</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>
<body>
<form
	action="roomstate!<ww:if test="roomstate.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">
<input type="hidden" name="hotelId" value='<ww:property value="hotelId"/>' />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td colspan="3" width="100%" height="29"
			background="../images/jb.gif"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="roomstate.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店房态</span></td>
	</tr>
	<tr>
		<td width="11%" rowspan="4" align="right">
			<div style="display: none"><ul>
			<li>已经存在时间:</li>
		
			</ul></div>
		</td>
		<td width="12%" align="right"><span style="WIDTH: 89px">房型名称：</span></td>
		<ww:if test="roomstate.id>0">
			<td width="77%"><input type="hidden" name="roomtypeid"
				id="roomtypeid" value='<ww:property value="roomstate.roomtypeid"/>' /><FONT
				color="blue"><ww:property value="getNameById(roomstate.roomtypeid)" /></FONT></td>
		</ww:if>
		<ww:else>
			<td width="77%"><select name="roomtypeid" id="roomtypeid"
				value="<ww:property value="roomtypeid"/>">
				<ww:iterator value="listroomtypes">
					<option value="<ww:property value="id"/>"
						<ww:if test="id==roomtypeid">selected="selected"</ww:if>><ww:property
						value="name" /></option>
				</ww:iterator>
			</select></td>
		</ww:else>
	</tr>
	<tr>
        
		<td align="right"><span style="WIDTH: 120px">使用日期：</span></td>
		<td><input name="begintimeStr"
			value="<ww:property value="begintimeStr"/>" id="begintimeStr"
			type="text" class="Wdate" readonly="readonly"
			onblur="btime=this.value"
			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#{%y+1}-%M-%d', onpicked:function(){endtimeStr.focus();}})" />
		- <input id="endtimeStr" class="Wdate"
			onfocus="this.value=getDateDiff($('#begintimeStr').val(),1);WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'begintimeStr\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'#{%y+1}-%M-%d'})"
			name="endtimeStr" value="<ww:property value="endtimeStr"/>"
			onblur="checktime(this.value)" />
		<div id="show"></div>		</td>
	</tr>
	<tr>
		<td align="right">房态:</td>
		<td><ww:if test="roomstate.state==2">
			<input id="yuliu" type="radio" value="1" name="state"
				onClick="mf_div.style.display='block'" />预留房
		<input id="man" type="radio" value="2" checked="checked" name="state"
				onClick="mf_div.style.display='none'" />满房
		</ww:if> <ww:else>
			<input id="yuliu" type="radio" value="1" checked="checked"
				name="state" onClick="mf_div.style.display='block'" />预留房
		<input id="man" type="radio" value="2" name="state" style="mf_di"
				onClick="mf_div.style.display='none'" />满房
	</ww:else>	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>

		<div id="mf_div"
			<ww:if test="roomstate.state==1 || roomstate.state==3 || roomstate.id==0" >style="display:block"</ww:if>
			<ww:else>style="display:none"</ww:else>>
		<table width="100%">

			<tr>
				<td><span style="WIDTH: 120px">确认类型：</span></td>
				<td><input id="noConfirm" type="radio" value="0" name="confirmmethod" 
					<ww:if test="roomstate.confirmmethod==0 || roomstate.state == 3 || roomstate.id==0">checked="checked"</ww:if> />不需确认
				<input id="Confirm" type="radio" value="1" name="confirmmethod"
					<ww:if test="roomstate.confirmmethod==1 ">checked="checked"</ww:if> />需要确认</td>
			</tr>
			<tr>
				<td width="12%">计算类别：</td>
				<td width="88%"><input id="ComeType" type="radio" value="1"
					name="type"
					<ww:if test="roomstate.type==1 ||  roomstate.id==0 || roomstate.state == 3">checked="checked"</ww:if> />累计
				<input id="ComeType" type="radio" value="2" name="type"
					<ww:if test="roomstate.type==2">checked="checked"</ww:if> />新增</td>
			</tr>
			<tr>
				<td>数量：</td>
				<td><input id="txtNum" style="WIDTH: 100px" name="num"
					value="<ww:property value="roomstate.num"/>" /></td>
			</tr>
		</table>
		</div>		</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><input type="submit" class="button_d font-white"
			value="提交" /><input type="button" class="button_d font-white"
			onclick="window.location.href='roomstate!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=cancelroomstate&<ww:property value="url"/>';"
			name="Submit2" value=" 取消返回 " /></td>
	</tr>
</table>

</form>
</body>
</html>
<script type="text/javascript">

//检查时间是否合法
function checktime(etime)
{
	var rid ='<ww:property value="roomstate.id"/>';
	var type = document.getElementById("roomtypeid").value;
	var btime = document.getElementById("begintimeStr").value;

	$.post("roomstate!checkTime.action?begintimeStr="+btime+"&endtimeStr="+etime,{id:rid,roomtypeid:type},function(response){
        //document.getElementById("show").innerHTML=response;
	 
	  if("f"==response){
	   alert("该时间段已经存在!");
	 	// document.getELementById("begintimeStr").value="";
	 $("#begintimeStr").focus();
	  	//alert($("#begintimeStr"));
	  	
	  	
	 	 }
	   }
	); 
}
</script>

