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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title><ww:if test="hotellinkman.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店联系人</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />

<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});
</script>
<body>

<form action="hotellinkman!<ww:if test="hotellinkman.id>0">edit.action?id=<ww:property value="hotellinkman.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" id="form1" method="POST" >

<input type="hidden" name="hotelid" value="<ww:property value="hotelId"/>"> 
<input type="hidden" name="hotelName" value="<ww:property value="hotelName"/>">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	
	<td width="100%" height="29"  class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="hotellinkman.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店联系人</span></td>

 
  <tr>
    <td height="100%"><table width="100%" cellpadding="0" cellspacing="0">
      <tr>
        <td width="196" height="18">&nbsp;</td>
        <td width="569">&nbsp;</td>
      </tr>
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">姓名：</span></td><td><input type="text" require="true" dataType="Require"   msg="姓名不能为空" name="name" value='<ww:property value="hotellinkman.name"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right">
	 			<span class="STYLE2">性别：</span></td>
			<td><input id="sex1" type="radio"  value="1" name="sex" <ww:if test="hotellinkman.sex==1 || hotellinkman.sex==null">checked="checked"</ww:if>/>男
 				    <input id="sex2" type="radio" value="2" name="sex" <ww:if test="hotellinkman.sex==2">checked="checked"</ww:if>/>
 				    女</td>
			<td>&nbsp;</td>
	 </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">职务：</span></td><td><input type="text" require="true" dataType="Require"   msg="职务不能为空" name="duty" value='<ww:property value="hotellinkman.duty"/>'" style="width:350px" /></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">座机：</span></td><td id="tel"><input type="text" id="we" require="true" dataType="Require"   msg="座机不能为空" name="tell" value='<ww:property value="hotellinkman.tell"/>'" style="width:350px"  desc="座机" class="validate[required,custom[telephone]]"/></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">手机：</span></td><td id="mob"><input type="text" id="wa"  require="true" dataType="Require"   msg="手机不能为空" name="mobil" value='<ww:property value="hotellinkman.mobil"/>'" style="width:350px" desc="手机号码" class="validate[required,custom[mobile]]"/></td>  </tr>
	
				 
 
	 <tr class="font-blue-xi"><td height="28" align="right"><span class="STYLE2">传真：</span></td><td id="f"><input type="text" id="se"  require="true" dataType="Require"   msg="传真不能为空" name="fax" value='<ww:property value="hotellinkman.fax"/>'" style="width:350px" desc="传真" class="validate[required,custom[telephone]]" /></td>  </tr>
	  
   	    
      <tr class="font-blue-xi">
        <td height="54" rowspan="2"> </td>
        <td height="46" scrolling="no"><div style=" position: relative;">
        <input type="submit" id="submitreg" class="button_d font-white" value="提交"/> <input type="button" class="button_d font-white" onclick="window.location.href='hotellinkman!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=cancellinkman&<ww:property value="url"/>';"  name="Submit2" value=" 取消返回 " />
       
				</div>	
         </td>
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

$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});
//--------------------验证座机电话------------------------


function checktel(){
var txt = document.form1.tell.value;
var pattern= /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/ ;
if(form1.tell.value==''){
		//alert("不能为空");
		return false;
 }else{
		
		if(!pattern.exec(txt))
		{
		//alert("只能输入非0正整数！");
			document.form1.tell.value="";
			$('#tel>span').remove();
			$('#tel').append('<span style="color:#ff8080">正确号码格式:区号(2到3位)-电话号码(7到8位)-分机号(3位)!!</span>'); 
				return false;
		}else{
  			$('#tel>span').remove();
  		}	
	}
}
//--------------------验证移动电话------------------------

function checkmob(){
var txt = document.form1.mobil.value;
var pattern= /^1(3|5|8)\d{9}$/ ;
if(form1.mobil.value==''){
		//alert("不能为空");
		return false;
 	}else{
		if(!pattern.exec(txt))
		{
		//alert("只能输入非0正整数！");
			document.form1.mobil.value="";
			$('#mob>span').remove();
			$('#mob').append('<span style="color:#ff8080">请填写正确的移动电话号码!!</span>'); 
				return false;
		}else{
  			$('#mob>span').remove();
  		}
  }
}	
//--------------------验证传真------------------------

function checkfax(){

var txt = document.form1.fax.value;
	
var pattern= /^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/ ;
if(form1.fax.value==''){
		//alert("不能为空");
		return false;
 }else{
		if(!pattern.exec(txt))
		{
		//alert("只能输入非0正整数！");
			document.form1.fax.value="";
			$('#f>span').remove();
			$('#f').append('<span style="color:#ff8080">请填写正确的传真号码!!</span>'); 
				return false;
		}else{
  			$('#f>span').remove();
  		}
  }
}


</script>
</html>


