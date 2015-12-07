<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-常用配送地址</title>

<ww:head name="login" jsURL="citycontrol" />

<script language="javascript" type="text/javascript"
	src="js/provinceandcity/provinceandcity.js"></script>
</head>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->


<div id="member"><jsp:include flush="true"
	page="../member/left.jsp?ty=member"></jsp:include>
<div class="right mt10 r">
	<!-- <div>
	<ul>
		<li class="mation fff">会员信息</li>
		<li class="mation_info"><font class="mation_left f"><b>注册时间</b></font><span
			class="f mr25">会员注册时间为：<ww:property value="formatDate(#session.loginuser.createtime)" /></span> <font class="f90 f">普通会员</font>
		<span class="r mation_right">&nbsp;</span></li>
	</ul>
	</div> -->

<!--会员基本信息over-->
<form action="<%=request.getContextPath()%>/login!AddAddress.jspx"
	name="form1" method="post" id="form1">

<div class="box">
<div class="tit"><font class="black low2 f mr15">常用配送地址</font>

 <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
<div class="c"></div>
</div>
<div class="data">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="right" width="25%"><font class="fontxing mlr">*</font>收货人姓名：</td>
		<td><input type="text" id="membername" class="text_regsit"
			name="col_name" value="<ww:property value="useraddress.name"/>" /></td>
	</tr>
	<tr>
		<td align="right"><font class="fontxing mlr">*</font>省份：</td>
		<td valign="bottom"><!-- <input class="text_regsitlatt" type="text" value="" id="selProvince"/><input class="text_regsitlatt" value="" type="text" id="selCity"/> -->
		<select name="col_province" style="vertical-align: middle;"
			id="selProvince" 
			onchange="getCity(this.options[this.selectedIndex].value)">
			<ww:if test="useraddress.id>0">
			<option value="<ww:property value="useraddress.province" />"><ww:property
					value="useraddress.province" /></option>
					</ww:if>
			<ww:if test="sheng!=null&&sheng!=''">
				<option value="<ww:property value="sheng" />"><ww:property
					value="sheng" /></option>
			</ww:if>
		</select> <select id="selCity" name="col_city" style="vertical-align: middle;">
			<option value="<ww:property value="useraddress.city" />"><ww:property
					value="useraddress.city" /></option>
			<ww:if test="shi!=null&&shi!=''">
				<option value="<ww:property value="shi" />"><ww:property
					value="shi" /></option>
			</ww:if>
		</select> <input class="text_regsit" type="text"
			value="<ww:property value="useraddress.area"/>" id="area"
			name="col_area" onblur="getAddress()" /></td>
	</tr>
	<input type="hidden" name="AddressID"
		value="<ww:property value="useraddress.id" />" />
	<tr>
		<td align="right">地址：</td>
		<td><input type="text" class="text_regsit"
			value="<ww:property value="useraddress.address"/>"  id="address"
			name="col_address" readonly=" readonly" /></td>
	</tr>
	<tr>
		<td align="right">联系电话：</td>
		<td><input type="text" class="text_regsitd"
			value="<ww:property value="useraddress.areacode"/>" id="areacode"
			name="col_areacode" />—&nbsp;<input type="text"
			class="text_regsitlatter"
			value="<ww:property value="useraddress.tel"/>" id="tel"
			name="col_tel" />例：010-00000000</td>
	</tr>
	<tr>
		<td align="right">手机号：</td>
		<td><input type="text" class="text_regsit"
			value="<ww:property value="useraddress.mobile"/>" id="telephone"
			name="col_mobile" /></td>
	</tr>
	<tr>
		<td align="right">电子邮件：</td>
		<td><input type="text" class="text_regsit" name="col_mail"
			id="mail" value="<ww:property value="useraddress.mail"/>" /></td>
	</tr>
	<tr>
		<td align="right">邮政编码：</td>
		<td><input type="text" class="text_regsitlatt" id="postalcode"
			name="col_postalcode"
			value="<ww:property value="useraddress.postalcode"/>" /></td>
	</tr>
	<tr>
		<td colspan="2" class="save"><input type="button" value="保存信息"
			class="bst" onclick="qwqwqwq();" /></td>
	</tr>
</table>

</div>
</div>
</form>
</div>

</div>

<ww:include page="../footer.jsp" />
</body>
</html>
<script>
function qwqwqwq(){

 if($("#membername").val()==""){

	       	$("#membername").poshytip({
				content: "姓名不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#membername").focus();
			     return false;
	}

if($("#selProvince").val()==""){
	       	$("#selProvince").poshytip({
				content: "省份不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'top',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#selProvince").focus();
			     return false;
}

 if($("#selCity").val()==""){
	       	$("#selCity").poshytip({
				content: "所在市不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#selCity").focus();
			     return false;
}
if($("#area").val()==""){
	       	$("#area").poshytip({
				content: "区域不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#area").focus();
			     return false;
}else if($("#area").val().length>20){
		$("#area").poshytip({
				content: "区域区域长度不能大于20!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#area").focus();
			     return false;
}
if($("#address").val()==""){
	       	$("#address").poshytip({
				content: "地址不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#address").focus();
			     return false;
}	
if($("#areacode").val()==""){
	       	$("#areacode").poshytip({
				content: "区号不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}
 if(!IsNumber($("#areacode").val())){
	       	$("#areacode").poshytip({
				content: "区号只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}

if($("#areacode").val().length<3||$("#areacode").val().length>4){
	       	$("#areacode").poshytip({
				content: "区号格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}
if($("#tel").val()==""){
	       	$("#tel").poshytip({
				content: "号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#tel").focus();
			     return false;
}else{
 if(!IsTelephone($("#tel").val())){
	       	$("#tel").poshytip({
				content: "号码格式错误",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#tel").focus();
			     return false;
	}
}	

if($("#telephone").val()==""){
	       	$("#telephone").poshytip({
				content: "手机号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#telephone").focus();
			     return false;
}else{
 if(!IsMobile($("#telephone").val())){
	       	$("#telephone").poshytip({
				content: "号码格式错误",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#telephone").focus();
			     return false;
	}
}	
 if($("#mail").val()==""){
	       	$("#mail").poshytip({
				content: "邮箱不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			  $("#mail").focus();
			     return false;
}
 if(!IsEMail($("#mail").val())){
	       	$("#mail").poshytip({
				content: "邮箱格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			   $("#mail").focus();
			     return false;
}
if($("#postalcode").val()==""){
	       	$("#postalcode").poshytip({
				content: "邮编不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#postalcode").focus();
			     return false;
}	
if($("#postalcode").val()!=''){
 if(!IsPostalCode($("#postalcode").val())){
	       	$("#postalcode").poshytip({
				content: "邮编格式错误",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#postalcode").focus();
			     return false;
}
}

 document.form1.submit();	
}
function getAddress(){
		var sheng=$("#selProvince").val();
		var shi=document.getElementById("selCity").value;
		var quyu=document.getElementById("area").value;
		document.getElementById("address").value=sheng+"-"+shi+"-"+quyu;
	}

getSheng();
<ww:if test="sheng==null||sheng==''">

getCity();
</ww:if>
</script>