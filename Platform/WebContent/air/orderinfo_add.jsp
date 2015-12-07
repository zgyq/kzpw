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
<title><ww:if test="teamapply.id>0">编辑</ww:if><ww:else>新增</ww:else>团队订单</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
</head>
	
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/autocomplete.css" rel="stylesheet" />

<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<script>
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
<div id="member">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;新增团队订单</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="teamapply!addorder.action" id="form1"
			name="form1" method="POST"
			>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="text-align: left; line-height: 36px;">
<ww:bean
	name="'com.opensymphony.webwork.util.Counter'" id="counter">
	<ww:param name="'first'" value="1" />
	<ww:param name="'last'" value="chen" />
	
</ww:bean>
	
	<ww:iterator value="#counter" status="state">
	<tr><td colspan="4" style="width: 98%; text-align: left; background: #DDECF3; height: 30px; margin-bottom: 10px; margin: 0 auto;"><font class="huang12_c f" style="text-indent: 20px;">登机人</font> <span class="r"
			style="margin-right: 20px;"></span>
	</td></tr>
	<tr>
	<td style="text-indent: 25px; height: 36px;">姓名： <input name="h_name" size="10" desc="姓名" class="validate[required]"
			  id="a<ww:property value="#state.index"/>"
			type="text" />
	</td>
	<td>登机人类型： 
		<select name="h_ptype" style="width: 60px"  id="b<ww:property value="#state.index"/>">
		<option value="1" id="p1<ww:property value="#state.index"/>" >成人</option>
		<option value="2" id="p2<ww:property value="#state.index"/>">儿童</option>
		<option value="3" id="p3<ww:property value="#state.index"/>">婴儿</option>
		</select>
	</td>
	
	<td >
	<span id="zjlx<ww:property value="#state.index"/>">
		证件类型：
		<select name="h_idtype" style="width: 70px"  id="c<ww:property value="#state.index"/>">
		<option value="1">身份证</option>
		<option value="2">驾驶证</option>
		<option value="3">护照</option>
		<option value="4">港澳通行证</option>
		<option value="5">台湾通行证</option>
		<option value="6">台胞证</option>
		<option value="7">回乡证</option>
		<option value="8">其他</option>
		</select>
	</span>
		
		
	<span id="">证件号码：</span> <input  size="30"
			name="h_idnumber"
			id="d<ww:property value="#state.index"/>"  desc="证件号码/出生年月" class="validate[required]" type="text" /><span id="showtishi<ww:property value="#state.index"/>">如果是婴儿或儿童,可以填写出生日期!</span>
	</td>
	<td></td>
	</tr>
	<tr><td style="text-indent: 25px;" colspan="4">购买保险分数：<select id="h_insurance<ww:property value="#state.index"/>" name="baoxian"  style="width: 50px">
       <option value="0">0</option>
       <option value="1" selected="selected">1</option>
       <option value="2">2</option>
       <option value="3">3</option>
       <option value="4">4</option>
       <option value="5">5</option>
       </select><font class="hui_xi" style="margin-left: 47px;"></font>
       </td>
       </tr>
      <tr>
</ww:iterator>
	
      <td>&nbsp;</td><td>&nbsp;</td>
      </tr>
       
       
      <tr><td style="text-indent: 25px;" colspan="4">联系人姓名：
     <input type="text" name="lianxiren"  id="lianxiren" desc="联系人姓名" class="validate[required]"  />
       </td>
       </tr>
      <tr><td style="text-indent: 25px;" colspan="4">联系人手机：
     <input type="text" name="shouji" id="shouji"  desc="手机号码" class="validate[required,custom[mobile]]" />
       </td>
       </tr>
      <tr><td style="text-indent: 25px;" colspan="4">联系人邮箱：
     <input type="text" name="youxiang"  id="youxiang"  desc="电子邮箱" class="validate[required,custom[email]]" />
       </td>
       </tr>
	</table>	
	<input type="hidden" name="teamapplyid" value="<ww:property value="teamapplyid"/>" />
	<input type="hidden" name="supteamid" value="<ww:property value="supteamid"/>" />
<span style="margin-left: 500px">
						<input type="submit" id="submitreg"
							class="button_d font-bai" value="提交" />
							 <input type="button"
							class="button_d font-bai"
							onclick="javascript:history.back(-1)"
							name="Submit2" value=" 返回 " />
							</span>
		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>
<script>

var chengren = '<ww:property value="teamapply.chengren"/>';

var ertong = '<ww:property value="teamapply.ertong"/>';
var yinger = '<ww:property value="teamapply.yinger"/>';

if(chengren!=0){

	for(i=0;i<chengren;i++){
	
		document.getElementById("p1"+i).selected="selected";
		//document.getElementById("b"+i).disabled="disabled";
		}
}
if(ertong!=0){

  
          

var aa = parseInt(ertong) +parseInt(chengren);

	for(i=chengren;i<aa;i++){
	
		document.getElementById("p2"+i).selected="selected";
		//document.getElementById("b"+i).disabled="disabled";
		}
}

if(yinger!=0){

  
          

var bb = parseInt(ertong) +parseInt(chengren);
var zong = parseInt(ertong) +parseInt(chengren)+parseInt(yinger);

	for(i=bb;i<zong;i++){
	
		document.getElementById("p3"+i).selected="selected";
		//document.getElementById("b"+i).disabled="disabled";
		}
}
</script>


