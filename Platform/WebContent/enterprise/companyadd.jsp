<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业添加</title>
<link href="public/css/left.css" type="text/css" rel="stylesheet" />
<link href="public/css/public.css" type="text/css" rel="stylesheet" />
<link href="public/css/main.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>

</head>
<body >
<div  id="right" >
    <div class="lit">
      <ul>
       <li class="offwu"><a href="ddlist.html" target="mainFrame">添加企业</a></li>
       <li><img src="../images/jiao.gif" width="8" height="28" /></li>
       <li style="float:right" class="mr11"><img src="../images/houtui.gif" width="59" height="23" class="mr8" /><input type=button value="" class="button_shuaxin" onclick="window.parent['mainFrame'].location.reload()"></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
   <form action="company!add.action" method="post">
      <div>
<h2>添加企业信息</h2>
<div class="biaoti">企业信息</div>
	<table border="0" cellspacing="0" cellpadding="0" width="100%"  style="margin-top:15px;">
  <tr>
    <td width="20%" align="right" class="hei_cu" height="30">企业名称：</td>
    <td width="20%" ><input name="company.cnamecn" type="text" class="text_150er text_360" onblur="valagentname()" id="agentname"/></td>
    <td class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="vagentname">必须为汉字、英文字母、数字，不能包含非法字符！</font></td>
    <td></td>
  </tr>
  
  <tr>
    <td align="right" class="hei_cu" height="30" >企业简称：</td>
    <td><input name="company.simnamecn" type="text" class="text_150er text_360" onblur="valsimpname()" id="simpname"/></td>
    <td colspan="2" class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="vsimpname">填写公司常用简称。</font></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30" >英问简称：</td>
    <td><input name="company.simnameen" type="text" class="text_150er text_360" onblur="valsimpname()" id="simpname"/></td>
    <td colspan="2" class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="vsimpname">填写公司英文简称。</font></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">通讯地址：</td>
    <td><input name="company.comaddr" type="text" class="text_150er text_360" onblur="valaddress()" id="address"/></td>
    <td colspan="2" class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="vaddress">填写公司所在位置的详细地址！</font></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">邮政编码：</td>
    <td><input name="company.postid" type="text" class="text_150er text_360" onblur="valcode()" id="code"/></td>
    <td colspan="2" class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="vcode">填写公司所在地邮编。</font></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">公司传真：</td>
    <td><input name="company.comfax" type="text" class="text_150er text_360" onblur="valcode()" id="code"/></td>
    <td colspan="2" class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="vcode">填写公司所在地邮编。</font></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">公司电话：</td>
    <td><input name="company.comtel" type="text" class="text_150er text_360" value="" onblur="" id=""/></td>
    <td colspan="2" class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="">填写企业联系电话</font></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">所属地域：</td>
    <td><input name="company.area" type="text" class="text_150er text_360" value="" onblur="" id=""/></td>
    <td colspan="2" class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="">填写企业所有地域</font></td>
  </tr>
</table>
<!---------------------------酒店预定 OVER------------------------------>

 	<div class="biaoti">机构信息</div>
	<table border="0" cellspacing="0" cellpadding="0" width="100%" style="margin-top:15px;" >
	
  <tr>
    <td width="20%" align="right" class="hei_cu" height="30">公司类型：</td>
    <td width="30%" >
    <select name="company.calling" class="width_sel">
    <option value="软件/硬件研发">软件/硬件研发</option>
    <option value="医疗/医药研发">医疗/医药研发</option>
    <option value="航空旅游">航空旅游</option>
    <option value="电子商务">电子商务</option>
    </select></td>
    <td class="hui_xi"><font class="hong_xi"></font>&nbsp;请选择企业经营类型。</td>
	<!-- 
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">组织机构类型：</td>
    <td><select name="" class="width_sel">
      <option>没有分公司</option>
      <option>包含分公司</option>
    </select></td>
    <td class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;如企业包含分公司请选择"包含分公司"。</td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">证件号码：</td>
    <td><input name="" type="text" class="text_150er text_360" /></td>
    <td class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;请填写上传证件号码。</td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">法人姓名：</td>
    <td><input name="" type="text" class="text_150er text_360" /></td>
    <td class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;请填写真实企业法人姓名。</td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">注册资本：</td>
    <td><input name="" type="text" class="text_150er text_360" /></td>
    <td class="hui_xi">&nbsp;万 </td>
  </tr>
  
  <tr>
    <td width="20%" align="right" class="hei_cu" height="30">公司类型：</td>
    <td><select name="" class="width_sel" width="30%"></select></td>
    <td class="hui_xi">请选择企业经营类型。<td>
  </tr>
   -->
  <tr>
    <td align="right" class="hei_cu" height="30">公司规模：</td>
    <td> 
    <select name="company.number" class="width_sel">
    <option value="50人以下">50人以下</option>
    <option value="50-100">50-100</option>
    <option value="100-200">100-200</option>
    <option value="200-500">200-500</option>
    <option value="500-100">500-1000</option>
    <option value="1000人以上">1000人以上</option>
    </select></td>
    <td class="hui_xi">&nbsp;&nbsp;请选择公司规模。</td>
  </tr>
</table>
<!---------------------------机票预定 OVER------------------------------> 
<div class="biaoti">联系人信息</div>
	<table border="0" cellspacing="0" cellpadding="0" width="100%" style="margin-top:15px;" >
  <tr>
    <td width="20%" align="right" class="hei_cu" height="30">联系人：</td>
    <td width="30%" ><input name="company.contactname" type="text" class="text_150er text_360" onblur="valcontactname()" id="contactname"/></td>
    <td  class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="vcontactname">请填写企业联系人姓名。</font></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">移动电话：</td>
    <td><input name="company.contacttel" type="text" class="text_150er text_360" onblur="valagentphone()" id="agentphone"/></td>
    <td class="hui_xi"><font class="hong_xi">&lowast;</font>&nbsp;<font id="vagentphone">请填写企业联系人手机号。</font></td>
  </tr>
 
</table>
<!---------------------------企业采购 OVER------------------------------>  


 <table width="65%" border="0" cellspacing="0" cellpadding="0" class="xuxian_2">
  <tr>
  <td width="100%" align="center" height="60">
<input type="button"   name="" value="下一步" class="but" />
<input type="button" name="" value="重新填写" class="but" />
</td>
  </tr>
</table>


<!----------------------------注册第一步------------------------->
<div>
 <h2>填写服务合约及管理员</h2>
 <div class="biaoti">服务合约</div>
	<table width="98%" border="0" cellspacing="0" cellpadding="0" class="xuxian_3" style="line-height:24px;">
    <tr>
     <td align="right" width="20%" height="30" class="hei_cu">签约人：</td>
    <td width="30%" >
    <input name="company.ispactpersonname" type="text" class="text_150er text_360"/>
	</td>
	</tr>
    <tr>
     <td align="right" width="20%" height="30" class="hei_cu">联系电话：</td>
    <td width="30%" >
    <input name="company.ispactpersontel" type="text" class="text_150er text_360"/>
	</td>
	</tr>
	<tr>
    <td align="right" width="20%" height="30" class="hei_cu">合同期限：</td>
     <td class="table_color_l" colspan="3">
     <input name="sipactbgtime" />-<input name="sipactendtime" />
	</td>
    <!-- 
    <td width="40%" ><input name="" type="checkbox" value="" style="margin-right:3px;" />酒店预定
	    <input name="" type="checkbox" value=""  style="margin-right:3px;" />机票预定
		<input name="" type="checkbox" value=""  style="margin-right:3px;" />旅游预订
		<input name="" type="checkbox" value=""  style="margin-right:3px;" />火车票预订
		<input name="" type="checkbox" value=""  style="margin-right:3px;" />租车预订
	</td>
	 -->
  </tr>
  <tr>
    <td height="30" align="right" class="hei_cu">结算方式：</td>
    <td>  <input type="radio" name="paywayment" id="paywayment1" checked="checked" value="1"/><label for="paywayment1">现金</label>
<input type="radio" name="paywayment" id="paywayment2" value="2"/><label for="paywayment2">月结</label>
<input type="radio" name="paywayment" id="paywayment3" value="3"/><label for="paywayment3">预付款</label>

    <td></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="30" align="right" class="hei_cu">合约信息：</td>
    <td ><input name="11" type="radio" value=""   style="margin-right:3px;" />签署&nbsp;&nbsp;&nbsp;<input name="11" type="radio" style="margin-right:3px;" value="" />未签署</td>
    <td></td>
    <td>&nbsp;</td>
  </tr>
</table>
<div class="biaoti">管理员信息</div>
<table width="98%" border="0" cellspacing="0" cellpadding="0" class="xuxian_3" style="line-height:24px;">
  <tr>
    <td align="right" width="20%" height="30" class="hei_cu">管理员账号：</td>
    <td width="30%" >
    <input name="employee.loginname" type="text" class="text_150er text_360" onblur="valUname()" id="uname"/>
	</td>
    <td><font class="hong_xi">&lowast;</font>&nbsp;<font id="vuname">必须为英文字母、数字，不能包含非法字符！</font></td>
  </tr>
  <tr>
    <td height="30" align="right" class="hei_cu">管理员密码：</td>
    <td>
    <input name="employee.password" type="password" class="text_150er text_360" onblur="valPwd()" id="password"/></td>
    <td><font class="hong_xi">&lowast;</font>&nbsp;<font id="vpassword">请填写管理员密码。</font></td>
  </tr>
  <tr>
    <td height="30" align="right" class="hei_cu">确认密码：</td>
    <td ><input name="customeragent." type="password" class="text_150er text_360" onblur="" id="password"/></td>
    <td><font class="hong_xi">&lowast;</font>&nbsp;<font id="vpassword">请确认管理员密码。</font></td>
  </tr>
    <tr>
    <td height="30" align="right" class="hei_cu">管理员姓名：</td>
    <td ><input name="employee.username" type="text" class="text_150er text_360" onblur="" id=""/></td>
    <td><font class="hong_xi">&lowast;</font>&nbsp;<font id="">请填写管理员姓名。</font></td>
  </tr>
    <tr>
    <td height="30" align="right" class="hei_cu">管理员电话：</td>
    <td ><input name="employee.connecttel" type="text" class="text_150er text_360" onblur="" id=""/></td>
    <td><font class="hong_xi">&lowast;</font>&nbsp;<font id="">请填写管理员联系电话。</font></td>
  </tr>
</table>
 <table width="65%" border="0" cellspacing="0" cellpadding="0" class="xuxian_2">
  <tr>
  <td width="100%" align="center" height="60">
<input type="submit"   name="" value="完成" class="but" />
<input type="button" name="" value="重新填写" class="but" />
</td>
  </tr>
</table>
</div>
 
</div>
</form>
    </div>
</div>
</body>
<script>
//验证公司名称
function valagentname(){
  var vrst=twoval("agentname",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'企业名称不可包含非法字符',false]}));
  return vrst;
}
//验证企业简称
function valsimpname(){
  var vrst=twoval("simpname",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'企业简称不可包含非法字符',false]}));
  return vrst;
}
//验证通讯地址
function valaddress(){
var vrst=twoval("address",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'通讯地址不可包含非法字符',false]}));
  return vrst;
}
//验证邮政编码
function valcode(){
var vrst=twoval("code",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[1-9]d{5}(?!d)]'),'邮政编码编写有误！',false]}));
  return vrst;
}
//验证业务联系人
function valcontactname(){
var vrst=twoval("contactname",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'姓名不可包含非法字符',false]}));
  return vrst;
}
//验证电子邮箱
function valemail(){
var vrst=twoval("email",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('/^[a-zA-Z]([a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)+@([\w-]+\.)+[a-zA-Z]{2,}$/'),'姓名不可包含非法字符',false]}));
  return vrst;
}
//验证经营的期限

function valtime(){
var vrst=twoval("time",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('^-?\d+$'),'营业期限不合法必须为数字',false]}));
  return vrst;
}
//验证联系电话
function valagentphone(){
 var reg=new RegExp(/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/);
var vrst=twoval("agentphone",new Array({'data':['required','','不可为空']},{'data':['regexp',reg,'您输入的号码有误（例021-62774989或移动电话）',true]}));
  return vrst;
}

//验证管理员账号
function valUname(){
var uname=true;
uname=twoval("uname",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_]'),'用户名不可包含汉字和非法字符',false]},{'data':['length','','长度必须在6-16位之间']}));
return uname;
}
//验证管理员密码
function valPwd(){
var pwd=true;
pwd=twoval("password",new Array({'data':['required','','不可为空']}));
return pwd;
}
function valrequest(){
var aggree=document.getElementById("aggree").checked;
 if(aggree){
  var agentname=valagentname();
  var address=valaddress();
  var agenttel=valagenttel();
  var cname=valcontactname();
  var phone=valagentphone();
  if(agentname&&address&&agenttel&&cname&&phone){
    return true;  
  }
 
 }else{
  alert('必须同意注册条款规定！');
 }
return false;
}
function rest(){
$(".text").val("");
$("#webaddress").val("http://");
}
function twoval(id,varray){
 $("#v"+id).addClass("val");
  var ret=true;
  var idval=$("#"+id).val();  
  for(i=0;i<varray.length;i++){
   var obj=varray[i];
   var name=obj.data[0];
   var url=obj.data[1];
   var mesg=obj.data[2];
   if(name=="required"){
    if(idval==""){
    $("#v"+id).html(mesg);
    ret= false;
    return false;
  }else{
   $("#v"+id).html("");
   ret= true;
  }
  }
  if(name=='regexp'){
    var regyn=obj.data[3];
    if(regyn){
     if(!url.test(idval)){ 
      $("#v"+id).html(mesg);
      ret= false;
       return false;
     }else{
      ret= true;
     }   
    }else{
   if(url.test(idval)){ 
      $("#v"+id).html(mesg);
      ret= false;
       return false;
     }else{
      ret= true;
     }   
  }  
 }  
  if(name=="length"){
    var len=idval.length;
    if(len>=6&&len<=16){
    $("#v"+id).html("");
      ret=true;
    }else{
    $("#v"+id).html(mesg);
      ret=false;      
      return false;
    }
  }
  if(name=="ajax"){
     $.ajax({
       type:"post",
       url:url,
       async:false,
       data:{validateId:id,validateValue:idval},
       success:function(dat){
        dat = eval( "("+dat+")");
	    var ajaxisError = dat.jsonValidateReturn[2]; 
	    if(ajaxisError=="false"){
	      $("#v"+id).html(mesg);
	       ret=false;
	       return false;
	    }else{
	     $("#v"+id).html("");
	      ret=true;
	    }
       }
     
     });  
   }   
 }
 if(ret){
 $("#v"+id).html("<img src='images/valok.gif'/>");
 }
  return ret;
}
<ww:if test="#request.message!=null">
$(document).ready(function(){
 alert('<ww:property value="#request.message"/>');
});
</ww:if>
</script>
</html>
