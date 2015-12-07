<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page import="java.util.*;"%>
<%
	String abspath="http://"+request.getServerName() +":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}票务商旅系统-加盟商申请</title>
<style type="text/css">
.val{
color: red;
}
</style>
<link href="css/css.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery1.3.2.js"></script>

<script language="javascript" for="document"  event="onkeydown">
     $(document).ready(function()
     {
          if(event.keyCode==13)     //判断回车按钮事件
          {   
             $("#btnlogin").click();
          }
          
     });

</script>
<script language="javascript">
 function submitForm(){
 	var una = document.getElementById("uname").value;
 	var upa = document.getElementById("upass").value;
 	var uvi = document.getElementById("validateImg").value;
 	var flag=true;
 	if(una == ""){
 		$("#validateImg1").html("用户名不能为空");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		 flag=false;
 	}
 	
 	
 	if(upa == ""){
 		$("#validateImg3").html("密码不能为空");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		flag=false;
 	}
 	if(uvi == ""){
 		$("#validateImg2").html("请输入验证码");
 		document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
 		flag=false;
 	}
 	if(flag)
 	{
 	  document.form1.submit();
 	}
 	return flag;
 }
 
 
 document.onkeypress=function(e) 
    {
        var code;  
        if  (!e)  
        {  
            var e=window.event;  
        }  
        if(e.keyCode)  
        {    
            code=e.keyCode;  
        }  
        else if(e.which)  
        {  
            code   =   e.which;  
        }
        if(code==13)
        {
        submitForm();
        }
    }
</script>
<script language="javascript">
    var openerIsIndex=false;
	try{
		openerIsIndex=opener.isIndex();
	}catch(e){}
	if(opener!=null && !openerIsIndex){
		opener.top.location="<%=abspath+"index.jsp"%>";
		window.close();
	}else if(top!=self){
		top.location="<%=abspath+"index.jsp"%>";
	}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validator.js"></script>
</head>

<body>
<div id="other">
  <div class="top" ><img src="newimages/jms_top.gif" width="1002" height="99" border="0" usemap="#Map" />
    <map name="Map" id="Map">
      <area shape="rect" coords="276,36,370,63" href="index.jsp" />
      <area shape="rect" coords="661,43,729,58" href="jiamengshang.jsp" />
      <area shape="rect" coords="773,43,843,57" href="gygl.jsp" />
      <area shape="rect" coords="882,42,940,57" href="ptys.jsp" />
      <area shape="rect" coords="824,11,880,26" href="#" />
      <area shape="rect" coords="914,12,972,26" href="fwxy.jsp" />
    </map>
    <div class="logo"><img src="images/${dns.logologinsrc}" width="110" height="97" /> </div>
  </div>
  <div>
     <div class="left f">
     <form action="<%=request.getContextPath()%>/login!login.action" name="form1" method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="line-height: 30px;">
          <tr>
            <th scope="col" width="55" align="right" style="font-weight: 100; color:#fff">用户名：</th>
            <th scope="col" align="left"> <input type="text" class="textd" id="uname" name="loginname" value="<ww:property value="user.loginname"/>" /></th>
          </tr>
          <tr>   
            <td  height="30" align="right" style="font-weight: 100; color:#fff">密码：</td>
            <td><input type="password" id="upass" class="textd" name="logpassword" require="true" value="<ww:property value="user.logpassword"/>" /></td>
          </tr>
          <tr>
            <td  align="right" style="font-weight: 100; color:#fff">验证码：</td>
            <td><input id="validateImg" name="validateImg" class="textd" type="text" size="6" style=" margin-right:0px; width: 40px;" align="absmiddle" /> 
            <img vertical-align="middle" src="validate" width="55" height="20"  style="margin-left: 0px; position: absolute;"  alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" />
            </td>
          </tr>
          <tr>
            <td align="center"  colspan="2" style="line-height:20px;" height="20"  style="color:#f00">
            <span id="validateImg3"><ww:property value="fieldErrors.password"/></span> <span id="validateImg2" style="color:red;font-size:12px;line-height:26px;"><ww:property value="fieldErrors.validate"/></span>
            </td>
          </tr>
          <tr>
            <td colspan="2"  align="center"><input type="button" class="button" value="" onclick="return submitForm()" /></td>
          </tr>
        </table>
       </form>
     </div>
     <div class="r right_n">
     <form action="customeragent!agentrequest.action" method="post" onsubmit="return valrequest()">
           <h1 class="h1">${dns.companyname}直销平台加盟商申请表</h1>
           <div class="biaoti">账号信息</div>
           <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
              <tr>
                <td align="right"   width="85">加盟商类型：</td>
                <td width="200">
                <select name="agenttype" class="text" style="width: 184px">
                <option value=2>供应商</option>
                <option value=3>采购商</option>
                </select>
                </td>
                <td><font class="hongxing">&lowast;</font>请选择您要申请的加盟商类型。</td>
              </tr>
              <tr>
                <td align="right">公司名称：</td>
                <td><input type="text" id='agentname' onblur="valagentname()" name="customeragent.agentcompanyname" class="text"  /></td>
                <td><font class="hongxing">&lowast;</font><font id='vagentname'>必须为汉字、英文字母、数字，不能包含非法字符！</font></td>
              </tr>
              <tr>
                <td align="right">公司位置：</td>
                <td><input type="text" class="text" id='address' onblur="valaddress()"  name='customeragent.agentaddress'  /></td>
                <td><font class="hongxing">&lowast;</font><font id='vaddress'>填写公司所在位置的城市！</font></td>
              </tr>
              <tr>
                <td align="right">公司电话：</td>
                <td><input type="text" class="text" id='agenttel' onblur="valagenttel()"  name='customeragent.agenttel'  /></td>
                <td><font class="hongxing">&lowast;</font><font id='vagenttel'>格式：区号加"-"加电话号码，如 021-62774989</font></td>
              </tr>
              <tr>
                <td align="right">公司网址：</td>
                <td><input type="text" id='webaddress' name='customeragent.website' value='http://' class="text"  /></td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td align="right">邮编：</td>
                <td><input type="text" name='customeragent.agentpostcode' class="text"  /></td>
                <td><font class="hongxing">&nbsp;&nbsp;</font>填写邮政编码</td>
              </tr>
            </table>
            <div class="biaoti">联系人信息</div>
           <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
              <tr>
                <td align="right"   width="85">业务联系人：</td>
                <td width="200"><input type="text" id='contactname' onblur="valcontactname()" name='customeragent.agentcontactname' class="text"  /></td>
                <td><font class="hongxing">&lowast;</font><font id='vcontactname'>填写负责人真实姓名。</font></td>
              </tr>
              <tr>
                <td align="right">工作电话：</td>
                <td><input type="text" class="text" id='agentphone' onblur="valagentphone()" name='customeragent.agentphone'  /></td>
                <td><font class="hongxing">&lowast;</font><font id='vagentphone'>填写用于联系的电话。</font></td>
              </tr>
              <tr>
                <td align="right">个人移动电话：</td>
                <td><input type="text" class="text" name='customeragent.agentmobile'  /></td>
                <td><font class="hongxing">&nbsp;&nbsp;</font>填写用于联系的电话号码。</td>
              </tr>
              <tr>
                <td align="right">传真：</td>
                <td><input type="text" name='customeragent.agenrfax' class="text"  /></td>
                <td><font class="hongxing">&nbsp;&nbsp;</font>格式：区号加"-"加电话号码，如 021-62988962</td>
              </tr>
              <tr>
                <td align="right">电子邮件：</td>
                <td><input type="text" name='customeragent.agentemail' class="text"  /></td>
                <td><font class="hongxing">&nbsp;&nbsp;</font>填写您常用的电子邮箱地址！</td>
              </tr>
              <tr>
                <td align="right">MSN或QQ：</td>
                <td><input type="text" name='customeragent.msnqq' class="text"  /></td>
                <td><font class="hongxing">&nbsp;&nbsp;</font></td>
              </tr>
              <tr>
                <td align="right" height="100" valign="top">注册条款提醒：</td>
                <td colspan="2"  >
                <div class="btext">1.请妥善保管好账号，如发生纠纷后果自负。 2.特殊政策以备注为准，请仔细阅读提示。<br/> 
3.退废票以航空公司为准。 4.以上信息必须真实，以避免给您造成不必要的麻烦。<br/> 
       <input type="radio" id='aggree' name='RadioGroup1' checked="checked"/>
       同意
       <input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" />
       不同意 </div> 
                </td>
              </tr>
            </table>  
            <div class="tishi"><img src="newimages/gif-0086.gif" width="15" height="15" align="absmiddle" />&nbsp;&nbsp;提示：采购商跟代理商需线下签订协议。</div>
            <div class="butt"><input type="submit" value="立即提交"  class="but" />
            <input type="button" value="重新填写" onclick="rest()"  class="but" /> </div>
            </form>
     </div>
     
     <div class="c"></div>
  </div>  
  <div class="botm">
    <ww:include page="loginbottom.jsp"/>
  </div>
</div>
</body>
<script>
//验证公司名称
function valagentname(){
  var vrst=twoval("agentname",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'公司名称不可包含非法字符',false]}));
  return vrst;
}
//验证公司地址
function valaddress(){
var vrst=twoval("address",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'公司地址不可包含非法字符',false]}));
  return vrst;
}
//验证固话
function valagenttel(){
var reg=new RegExp(/\d{3}-\d{8}|\d{4}-\d{7}/);
var vrst=twoval("agenttel",new Array({'data':['required','','不可为空']},{'data':['regexp',reg,'您输入的电话有误 例：021-62774989',true]}));
  return vrst;
}
//验证业务联系人
function valcontactname(){
var vrst=twoval("contactname",new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'姓名不可包含非法字符',false]}));
  return vrst;
}
//验证联系电话
function valagentphone(){
 var reg=new RegExp(/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/);
var vrst=twoval("agentphone",new Array({'data':['required','','不可为空']},{'data':['regexp',reg,'您输入的号码有误（例021-62774989或移动电话）',true]}));
  return vrst;
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
