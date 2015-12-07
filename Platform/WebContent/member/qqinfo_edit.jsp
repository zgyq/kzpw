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
<title><ww:if test="qqinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>QQ信息表</title>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="qqinfo.id>0">编辑</ww:if><ww:else>新增</ww:else>QQ信息表</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
<form name="qqinfoform" action="qqinfo!<ww:if test="qqinfo.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" method="POST" onSubmit="return Validator.Validate(this,3)">



<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
        
      
	

 
	 <tr><td height="28" align="right"><span>QQ类型：</span></td>
	 <td>
	 <select name="qqtype" style="width:200px" id="qqType" >
	 <option value="-1">--请选择QQ类型--</option>
	 <ww:iterator value="listQqtype">
	 <ww:property value="listQqtype.size"/>
	 <option value="<ww:property value="id"/>" <ww:if test="id==qqinfo.qqtype">selected="selected"</ww:if> >

	 <ww:property value="typename"/>
	 </option>
	 </ww:iterator>
	 </select>
	 <span style="color:red" id="vqqType"></span>
	 </td> 
   </tr>
	 
   <tr>
    <td height="28" align="right"><span>QQ号：</span></td>
    <td>
    <input type="text"  id="qqNo" onkeypress="digitalVal()" require="true" dataType="Require"   msg="QQ号不能为空" name="qqnumber" value='<ww:property value="qqinfo.qqnumber"/>'" style="width:200px" />
    <span style="color:red" id="vqqNo"></span>
    </td>
  </tr>
	 
	
	 <tr><td height="28" align="right"><span>QQ排序：</span></td>
	   <td>
	   <input type="text" id="qqTypeIndex" onkeypress="digitalVal()" require="true" dataType="Require"   msg="QQ排序不能为空" name="qqnumberindex" value='<ww:property value="qqinfo.qqnumberindex"/>'" style="width:200px" />
	   <span style="color:red" id="vqqTypeIndex"></span>
	   </td>  
	 </tr>
	
				 
      
   	    
      
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><input type="button" onclick="validate()" class="button_d font-bai" value="提交"/> <input type="button" class="button_d font-bai" onclick="window.location.href='qqinfo.action?<ww:property value="url"/>';"  name="Submit2" value=" 返回 " /> </td>
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
<script type="text/javascript">
 function digitalVal(){
  if ((event.keyCode <48 || event.keyCode>57)) 
     event.returnValue=false
  
  }
  
  function validate(){
  var reg=/^[1-9][0-9]*$/;
  var boolType=true;
  var boolNo=true;
  var boolIndex=true;
  var qqType=$("#qqType").val();
  var qqNo=$("#qqNo").val();
  var qqIndex=$("#qqTypeIndex").val();
   $("#vqqType").html("");
   $("#vqqNo").html("");
   $("#vqqTypeIndex").html("");
  if(qqType<0){ 
  $("#vqqType").html("请选择QQ类型");
  boolType=false;
  }
  if(qqNo==""){
  $("#vqqNo").html("请输入QQ号码");
  boolNo=false;
  }else{
   if(!reg.exec(qqNo)){
   $("#vqqNo").html("QQ号码输入有误");
    boolNo=false;
   }
  }
  if(qqIndex==""){
  $("#vqqTypeIndex").html("请输入QQ排序");
  boolIndex=false;
  }else{
   if(!reg.exec(qqIndex)){
   $("#vqqTypeIndex").html("QQ排序只能为数字");
    boolIndex=false;
   }
  }
  if(boolType&&boolNo&&boolIndex){
  document.qqinfoform.submit();
  }
  }
</script>
</html>


