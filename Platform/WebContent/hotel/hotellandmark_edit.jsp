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
			 *
			 */

		%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="hotellandmark.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店地标</title>

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
	action="hotellandmark!<ww:if test="hotellandmark.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="landmarkform" method="POST"
	onSubmit="return checkall();"><input type="hidden"
	name="hotelId" value='<ww:property value="hotelId"/>'>

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg" ><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="hotellandmark.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店地标</span>
			<span style="display: block; background: url('../images/bj_yy.gif'); width:356px; float: right;">
       </span>
			</td>
	</tr>
	<tr>
		<td height="100%">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td width="196" height="18">&nbsp;</td>
				<td width="569">&nbsp;</td>
			</tr>


			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">酒店：</span></td>
				<td><ww:property value="hotelName" /></td>
			</tr>


			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">地标：</span></td>
				<td><!--  
	 <input type="text" require="true" dataType="Require"   msg="地标ID不能为空" name="landmarkid" value='<ww:property value="hotellandmark.landmarkid"/>'" style="width:350px" />
	  --> <SELECT ID="landmarkid" NAME="landmarkid" style="width:150px" onblur="checkmarkname()">
					<option value="">--请选择地标--</option>
					<ww:if test="hotellandmark.id>0">
						<OPTION VALUE='<ww:property value="landmark.id"/>'
							SELECTED="SELECTED" ><ww:property value="landmark.name" /> </OPTION>
					</ww:if>
					<ww:iterator value="listLandmark">
						<ww:if test="landmark.id!=id">
							<OPTION VALUE='<ww:property value="id"/>'><ww:property
								value="name" /></OPTION>
						</ww:if>
					</ww:iterator>
				</SELECT><span id="namespan" name="namespan" style="color:#ff8080"></span></td>
			</tr>


			<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">距离：</span></td>
				<td ><input type="text"  name="description" id="range"
					value='<ww:property value="hotellandmark.description"/>'
					style="width:143px" />公里<span name="rspan" id="rspan" style="color:#ff8080"></span></td>
			</tr>






			<!--<tr class="font-blue-xi">
				<td height="28" align="right"><span class="STYLE2">信息描述：</span></td>
				<td><textarea name="range" cols="50" rows="5"><ww:property
					value="hotellandmark.range" /></textarea></td>
			</tr>
			--><tr class="font-blue-xi">
				<td height="54" rowspan="2"></td>
				<td height="46" scrolling="no"><input type="submit" class="button_d font-white"
					value="提交" /> <input type="button" class="button_d font-white"
					onclick="window.location.href='hotellandmark!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=cancelhotellankmark&<ww:property value="url"/>';"
					name="Submit2" value=" 取消返回 " /></td>
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
<script type="text/javascript">

var markFlag=true;
var numFlag=false;

		function checkall(){
			checkRange();
			checkmarkname();
			if( !markFlag || !numFlag){
			return false;
			}else{
			return true;
				}
		}

		function checkmarkname(){
		
			var markid=$("#landmarkid").val();
			var h_id = '<ww:property value="hotelId"/>';
			if(markid == ''){
				$("#namespan").html("不能为空!");
				numFlag = false;
			}
			$.post(
				"hotellandmark!IsExistLandMark.action",{landmarkid:markid,hotelid:h_id},
				function(str1){
					if(str1=="f"){
					$('#namespan').html("该地标可以添加");
					markFlag=true;
					}else if (str1=="t"){
						$('#namespan').html("该地标已存在!!!");
							markFlag=false;
					}
				});
	  }
	  
	  function checkRange(){
	  
	  	var markRange = $('#range').val();
	  	if(markRange == ''){
	  		$('#rspan').html('不能为空');
	  		numFlag=false;
	  	}else{
	  		if(isNaN(markRange)){
	  			$('#rspan').html('必须为数字');
	  			 document.getElementById("range").value='';
	  				numFlag=false;
	  		}else{
	  		$('#rspan').html('');
	  		numFlag=true;
	  		}
	  	}
	  	
	  }
	  
	  
</script>
</html>


