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
<title><ww:if test="qqtype.id>0">编辑</ww:if><ww:else>新增</ww:else>QQ类型</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script type="text/javascript">
  function digitalVal(){
  if ((event.keyCode <48 || event.keyCode>57)) 
     event.returnValue=false
  
  }
  
  function validate(){
  var reg=/^[1-9][0-9]*$/;
  var boolIndex=true;
  var boolName=true;
  var typeNmae=$("#typeName").val();
  var typeIndex=$("#typeIndex").val();
   $("#valTypeName").html("");
    $("#valTypeIndex").html("");
  if(typeNmae==""){ 
  $("#valTypeName").html("请输入类型名称");
  boolName=false;
  }
  if(typeIndex==""){
  $("#valTypeIndex").html("请输入类型排序");
  boolIndex=false;
  }else{
   if(!reg.exec(typeIndex)){
   $("#valTypeIndex").html("类型排序只能为数字");
    boolIndex=false;
   }
  }
  if(boolIndex&&boolName){
  document.qqtypeform.submit();
  }
  }
</script>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="qqtype.id>0">编辑</ww:if><ww:else>新增</ww:else>QQ类型</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form name="qqtypeform" action="qqtype!<ww:if test="qqtype.id>0">edit.action?id=<ww:property value="id" />&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>类型名称：</span></td>
	     <td>
	     <input type="text" id="typeName" require="true" dataType="Require"   msg="类型名称不能为空" name="typename" value='<ww:property value="qqtype.typename"/>'" style="width:210px" />
	     <span id="valTypeName" style="color:red"></span>
	     </td>  
	 </tr>				 
 
	 <tr><td height="28" align="right"><span>类型排序：</span></td>
	     <td><input type="text"  id="typeIndex"  onkeypress="digitalVal()" require="true" dataType="Require"   msg="类型排序不能为空" name="index" value='<ww:property value="qqtype.index"/>'" style="width:210px" />
	     <span id="valTypeIndex" style="color:red"></span>
	     
	     </td> 
	 </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="button" onclick="validate()" class="button_d font-bai" value="提交"/> 
        <input type="button"  class="button_d font-bai" onclick='window.location.href="qqtype.action?<ww:property value="url"/>"' name="Submit2" value=" 返回 " /> </td>
      </tr>
      <tr>
        <td height="17">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>



	

</form>
</td>
   </tr>
   </table>
</div>
</body>

</html>


