<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="ww" uri="webwork"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>保险创建</title>
<link href="js/city-control/base.css" rel="stylesheet" />
<link href="skin/blue/css/left.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/public.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/main.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/style/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.tmpl.js"
	type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/json2.js"
	type="text/javascript"></script>
<script type="<%=request.getContextPath() %>/js/query.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript">
    function sub(id){
       var fname=document.getElementById("myname_"+id).value;
       var card=document.getElementById("cardnumber_"+id).value;
       var mobile1=$("#mobile1_"+id).val();
       var birthday=$("#birthday_"+id).val();
       var myemail=$("#email_"+id).val();
       var flyno=$("#flyno_"+id).val(); 
       var codetype=$("#cardtype_"+id).val(); 
           
       if(fname==""){
          alert("请填写被保人姓名！");
          return document.getElementById("myname_"+id).focus();
          return false;
       }
       //获得选择的证件类型
       else if(card==""){
          alert("请填写被保人证件号！");
          return $("#cardnumber_"+id).focus();
          return false;
       }
       else if(mobile1==""||!reg.exec(mobile1)){
          alert("请正确填写被保人手机号码！");
          return $("#mobile1_"+id).focus();   
            return false;
       }
       else if(birthday==""||!reg1.test(birthday)){
          alert("请正确填写被保人出生日期！");
          return $("#birthday_"+id).focus();
            return false;
       }
       else if(myemail==""||!reg2.exec(myemail)){
          alert("请正确填写被保人电子邮箱！");
          return $("#email_"+id).focus();
          return false;
       }
       else if(flyno==""){
          alert("请正确填写被保人航班号！");
          return $("#flyno_"+id).focus();
          return false;
       }else{
         return true;
       }
    }
    
  
  //loading("<font size='5px'>正在提交订单</font>");
  function loadingtext(context)
	 {
	   //遮罩效果  
        $.blockUI({ message: '<img src="images/loadding.gif" />' });
	 }
	 
	function  mysubmit(){
	
	document.form1.submit();
	
	}
</script>

</head>
<body>
<div id="right">
<div class="lit">
<ul>
	<li class="offwu">购买电子保险</li>
</ul>
</div>
<div id="main" lang="ca" class="kuang box">
<div class="sea box_hui">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="taitou">
	<tr>
		<td width="20"><img src="skin/blue/images/ico_peoplecjr.gif"
			width="16" height="19" /></td>
		<td align="left"><font class="font16-f90">被保人信息</font>&nbsp;&nbsp;<font
			class="font-666">当前被保人数<span id="span_count"></span></font><font
			class="font-666">最多能投保9人</font></td>
		<td>&nbsp;</td>
	</tr>
</table>
<form action="insurance!OrderApply.action" name="form1" id="form1" method="post">

<table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0"
	cellpadding="0" class="biao center" id="rows">
	<input type="hidden" name="passid" value="<ww:property value="passenger.id"/>" />
	

	<tr id="tr_">
		<td colspan="10">
		<table width="98%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td class="table_yin" width="8%">姓名：</td>
				<td width="7%"><input type="hidden" value="" id="tid"><input
					type="text" desc="姓名" class="validate[required]" value="<ww:property value="passenger.name"/>"  style="size: 9"
					name="membername" id="myname_" /></td>
				<td class="table_yin" width="11%">证件类型：</td>
				<td width="10%"><select name="cardtype" id="cardtype_" value="">
					<option value="1" <ww:if test="passenger.idtype==1">selected</ww:if> >身份证</option>
					<option value="3" <ww:if test="passenger.idtype==3">selected</ww:if> >护照</option>
					<option value="8" <ww:if test="passenger.idtype==8">selected</ww:if>>军官证</option>
					<option value="9">其他</option>
				</select></td>
				<td class="table_yin" width="11%">证件号:</td>
				<td><input width="10%" type="text" size="18" name="cardnunber"
					desc="证件号" calss="validate[required]" id="cardnumber_" value="<ww:property value="passenger.idnumber"/>" />
				</td>
				

				
			</tr>
			<tr>
				<td class="table_yin" width="11%">性别<ww:property value="passenger.state"/>：</td>
				<td width="10%"><select name="membersex" id="select" value="">
					<option  value="1" <ww:if test="passenger.state%2!=0">selected</ww:if>  >男</option>
					<option value="2" <ww:if test="passenger.state%2==0">selected</ww:if>>女</option>
					
					
				</select></td>
				
				<!--<td class="table_yin">手机号码:</td>
				<td><input type="text" size="10" name="mobile" desc="手机号码"
					class="validate[required,ajax[ajaxMobile]]" id="mobile1_" value="" />
				</td>
				--><td class="table_yin" width="">出生日期：</td>
				<td><input type="text" size="10" name="birthday" desc="出生日期"
					class="validate[required]"
					onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" value="<ww:property value="passenger.birthday"/>"
					id="birthday_" /></td>
				<td class="table_yin" width="">电子邮箱：</td>
				<td><input type="text" size="10" name="memberemail" desc="电子邮箱"
					class="validate[required]" id="email_" /></td>
				
			</tr>
			<tr>
				<td class="table_yin" width="">航班号：</td>
				<td><input type="text" size="10" name="flyno" desc="航班号"
					class="validate[required]" id="flyno_" value="<ww:property value="segmentinfo.flightnumber"/>" /></td>
				<td class="table_yin" width="">起飞日期：</td>
				<td><input type="text" size="10" name="flytime"
					onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M+1-%d+1'})"
					id="time1_" value="<ww:property value="formatDate(segmentinfo.departtime)"/>" /></td>
				<td class="table_yin" width="">起保时间</td>
				<td><input type="text" size="10" name="begintime"
					onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M+1-%d+1'})"
					id="begintime" value="<ww:property value="formatDate(segmentinfo.departtime)"/>" /></td>
				<td></td>
			</tr>
		</table>
		</td>
	</tr>

</table>
</form>
<div class="h8">&nbsp;</div>
</div>
<div class="sea box_hui">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="taitou">
	<tr>
		<td width="20"><img src="skin/blue/images/ico_piaopkuan.gif"
			width="20" height="20" /></td>
		<td align="left"><font class="font16-f90">温馨提示</font>&nbsp;&nbsp;<font
			class="font-666"></font></td>
		<td>&nbsp;</td>
	</tr>
</table>

<table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0"
	cellpadding="0" class="biao center">

	<tr>
		<td align="left">注：请仔细核对所填写信息并保证信息真实有效 <span style="color: red">(以上内容都为必填项)</span></td>
	</tr>
	<tr>
		<td align="left">注：被保人年龄是在18-70周岁</td>
	</tr>
	<tr>
		<td align="left">注：出生日期格式：2008-08-08</td>
	</tr>
</table>
<div class="h8">&nbsp;</div>
<center><input type="button" class="button_sea mr18" value="提交"
	onclick="mysubmit()" /> <input type="button" class="button_sea mr18"
	value="关闭" onclick="parent.grefresh();" /></center>
</div>
</div>
</body>
</html>
