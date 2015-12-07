<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
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
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title><ww:if test="roomtype.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店房型</title>

<style type="text/css">

<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>

<body onload="checktypename()">
<form action="roomtype!<ww:if test="roomtype.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" >


<input type="hidden" id="hotelid" name="hotelid" value="<ww:property value="hotelId"/>"> 

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="roomtype.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店房型</span></td>
  </tr>
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
 
	 <tr class="font-blue-xi">
	 	<td height="28" align="right"><span class="STYLE2">房型名称：</span></td>
	 	<td id="nametd"><input type="text" require="true" dataType="Require"  msg="房型名称不能为空" id="name" name="name" value='<ww:property value="roomtype.name"/>' style="width:350px" onblur="checktypename(this.value)"/>
	 	
	 	</td>  
	 </tr>
	 <tr class="font-blue-xi">
	 	<td height="28" align="right"><span class="STYLE2">楼层：</span></td>
	 	<td id="roomnum"><input type="text" require="true" dataType="Require"   msg="楼层不能为空" name="layer" value='<ww:property value="roomtype.layer"/>'" style="width:350px" onblur="checkrooms()" /></td>  
	 </tr>
	<tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">床型：</span></td><td>
	  <!--<input type="text" require="true" dataType="Require"   msg="床型不能为空" name="bed" value='<ww:property value="roomtype.bed"/>'" style="width:350px" />  -->
	  <SELECT id=ddlBed style="WIDTH: 120px"  name="bed"> 
	  		<OPTION value="1" <ww:if test="roomtype.bed==1">selected="selected"</ww:if>>单人床</OPTION> 
            <OPTION value="2" <ww:if test="roomtype.bed==2">selected="selected"</ww:if>>大床</OPTION> 
            <OPTION value="3" <ww:if test="roomtype.bed==3">selected="selected"</ww:if>>双床</OPTION> 
            <OPTION value="4" <ww:if test="roomtype.bed==4">selected="selected"</ww:if>>大/双</OPTION>
			<OPTION value="5" <ww:if test="roomtype.bed==5">selected="selected"</ww:if>>其它</OPTION></SELECT>
	 </td>  
	</tr>	
	
	<tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">早餐：</span></td><td>
	  <!--<input type="text" require="true" dataType="Require"   msg="床型不能为空" name="bed" value='<ww:property value="roomtype.bed"/>'" style="width:350px" />  -->
	  <SELECT id="breakfast" style="WIDTH: 120px"  name="breakfast"> 
	  		<OPTION value="1" <ww:if test="roomtype.breakfast==1">selected="selected"</ww:if>>无早</OPTION> 
            <OPTION value="2" <ww:if test="roomtype.breakfast==2">selected="selected"</ww:if>>单早</OPTION> 
            <OPTION value="3" <ww:if test="roomtype.breakfast==3">selected="selected"</ww:if>>双早</OPTION> 
	 </td>  
	</tr>	
	
	<tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">宽带：</span></td><td>
	  <!--<input type="text" require="true" dataType="Require"   msg="床型不能为空" name="bed" value='<ww:property value="roomtype.bed"/>'" style="width:350px" />  -->
	  <SELECT id="wideband" style="WIDTH: 120px"  name="wideband"> 
	  		<OPTION value="0" <ww:if test="roomtype.wideband==0">selected="selected"</ww:if>>无</OPTION> 
            <OPTION value="1" <ww:if test="roomtype.wideband==1">selected="selected"</ww:if>>免费</OPTION> 
            <OPTION value="2" <ww:if test="roomtype.wideband==2">selected="selected"</ww:if>>收费</OPTION> 
	 </td>  
	</tr>
	
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">面积描述：</span></td>
	 <td><textarea name="areadesc" cols="48"><ww:property value="roomtype.areadesc"/></textarea>
	 <!--<input type="text" require="true" dataType="Require"   msg="面积描述不能为空" name="areadesc" value='<ww:property value="roomtype.areadesc"/>'" style="width:350px" />--></td>  
	 </tr>
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">房型描述：</span></td>
	 <td><textarea  name="roomdesc" cols="48"><ww:property value="roomtype.roomdesc"/></textarea>
	 <!--<input type="text" require="true" dataType="Require"   msg="房型描述不能为空" name="roomdesc" value='<ww:property value="roomtype.roomdesc"/>'" style="width:350px" />--></td>
	 </tr>
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">房间设施：</span></td>
	 <td><textarea name="roomset"  cols="48"><ww:property value="roomtype.roomset"/></textarea>
	  <!--<input type="text" require="true" dataType="Require"   msg="房间设施不能为空" name="roomset" value='<ww:property value="roomtype.roomset"/>'" style="width:350px" />--></td>  
	 </tr>
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="submit" class="button_d font-white" value="提交"/> <input type="button" class="button_d font-white" onclick="window.location.href='roomtype!goback.action?hotelId=<ww:property value="hotelId"/>>&tabtype=cannelroomtype&<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " /> </td>
      </tr>
      <tr>
        <td height="17">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>



	

</form>
</body>

 <script type="text/javascript">
 
			 String.prototype.trim = function()
			{
			    // 用正则表达式将前后空格
			    // 用空字符串替代。
			    return this.replace(/(^\s*)|(\s*$)/g, "");
			}
 
			function checktypename(){
			var userstr=$("#name").val().trim()+"A";
			var h_id = $("#hotelid").val();
			//if(userstr=="A"){
			//		$('#nametd>span').remove();
			//		$('#nametd').append('<span style="color:#ff8080">房型不能为空</span>');
			//		$("form").submit( function () {
			//		  return false;
			//		} ); 
			//		return false;
			//}else{
			//	$("form").submit(
			//	function(){
			//		  return true;
			//	});
				
			//	return true;
			//}
			 if($("#name").val().trim().length ==0 ) {
			 	return false ;
			 }
			$.post(
				"roomtype!findByTypeName.action",{name:userstr,hotelid:h_id},
				function(str1)
				{
					if(str1=="false"){
					$('#nametd>span').remove();
					$('#nametd').append('<span style="color:#ff8080">该房型可以注册</span>');
					}else if (str1=="true"){
						$('#nametd>span').remove();
						$('#nametd').append('<span style="color:#ff8080">该房型已存在!!</span>');
						$("#name").focus();
						$("#name").select();
					}
				}
				);
			}
			
			function checkrooms(){
			var txt = document.form1.layer.value;
			var pattern=/^\+?[1-9][0-9]*$/;//只能输入数字 
			
				if(document.form1.layer.value != ''){
					if(!pattern.exec(txt)) {
						document.form1.layer.value="";
						$('#roomnum>span').remove();
						$('#roomnum').append('<span style="color:#ff8080">只能输入非0正整数！</span>');
							return false;
					}else{
			  			$('#roomnum>span').remove();
			 		}
				}	
			} 
</script>
</html>


