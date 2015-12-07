<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-会员注册</title>
<ww:head name="login"  />
<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>
</head>
<!-- 
<ww:head name="login"  jsURL="citycontrol" />
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

 -->
 
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

  function freshvalidate()
{
	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
}

function sub(){


}
function ajax_loginname(){
 if($("#loginusername").val()==""){
	       	$("#loginusername").poshytip({
				content: "用户名不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#loginusername").focus();
			     return false;
}
 if($("#loginusername").val().length<6||$("#loginusername").val().length>16){
	       	$("#loginusername").poshytip({
				content: "用户名格式错误6到16位数字或者字母的组合!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#loginusername").focus();
			     return false;
}

 $.ajax({
       type:"POST",
       url:"vaidate!validateloginname.jspx?validateValue="+$("#loginusername").val(),
       async:false,     
       success:function(data)
       {    
       
      // alert(data);
        if(data=='false'){
        		$("#loginusername").poshytip({
				content: "用户名已经被注册!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#loginusername").focus();
			     return false;
        }else{
        
        	$("#loginusername").poshytip({
				content: "用户名可以注册!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
        }
       }            
  });

}
function ajax_loginemail(){
 if($("#memberemail").val()==""){
	       	$("#memberemail").poshytip({
				content: "邮箱不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			 //   $("#memberemail").focus();
			     return false;
}
 if(!IsEMail($("#memberemail").val())){
	       	$("#memberemail").poshytip({
				content: "邮箱格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			  //  $("#memberemail").focus();
			     return false;
}

 $.ajax({
       type:"POST",
       url:"vaidate!validateloginemail.jspx?validateValue="+$("#memberemail").val(),
       async:false,     
       success:function(data)
       {    
        if(data=='false'){
        		$("#memberemail").poshytip({
				content: "邮箱已经被注册!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#memberemail").focus();
			     return false;
        }
       }            
  });

}
function ajax_loginmobile(){
 if($("#mobile").val()==""){
	       	$("#mobile").poshytip({
				content: "手机号不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			//    $("#mobile").focus();
			     return false;
}
 if(!IsMobile($("#mobile").val())){
	       	$("#mobile").poshytip({
				content: "手机号格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			  //  $("#mobile").focus();
			     return false;
}

 $.ajax({
       type:"POST",
       url:"vaidate!validateloginmobile.jspx?validateValue="+$("#mobile").val(),
       async:false,     
       success:function(data)
       {    
        if(data=='false'){
        		$("#mobile").poshytip({
				content: "手机号已经被注册!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#mobile").focus();
			     return false;
        }
       }            
  });

}
</script>


<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="regsiter">
<form action="<%=request.getContextPath()%>/login!Regsit.jspx" name="form1" method="post" id="form1" >
    <div class="mt7 box">
        <div class="tit">
        
               <font class="black low2 f mr15">会员注册</font>
               <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="regsit">
            <ul>
             <li>
                 <span>用&nbsp;&nbsp;户&nbsp;名</span>：
                 
                 <input type="text" desc="用户名" class=" mlr15 text_regsit validate[length[6,16],ajax[ajaxUsername]]" id="loginusername" name="customeruser.loginname" value="<ww:property value="customeruser.loginname"/>"  />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">(由英文字母或者数字组成，6至16位字符。)</font>
             </li>
             <li>
                 <span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span>：
                 <input type="password" desc="密码" id="password" class=" mlr15 text_regsit validate[required,length[6,16]]" name="customeruser.logpassword" value="" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">(6-16个字符，字母、数字和符合。)</font>
             </li>
             <li>确认密码：
                 <input type="password" id="password1" desc="确认密码" class=" mlr15 text_regsit validate[required,confirm[password]]" />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">(请再次输入您的密码。)</font>
             </li>
             <li>
                 <span>手&nbsp;&nbsp;机&nbsp;号</span>：
                 <input type="text" id="mobile" desc="手机" class=" mlr15 text_regsit validate[required,custom[mobile],ajax[ajaxMobile]" name="customeruser.mobile" value="<ww:property value="customeruser.mobile"/>"  />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">(请填写您的联系手机号。)</font>
             </li>
             <li>
                 <span>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</span>：
                 <input type="text" id="memberemail" desc="邮箱" class=" mlr15 text_regsit validate[required,custom[email],ajax[ajaxEmail]]" name="customeruser.memberemail" value="<ww:property value="customeruser.memberemail"/>"  />
                 <font class="fontxing">*</font>&nbsp;<font class="c999">(请填写你常用的邮箱。)</font>
             </li>
             <li>
                 <span>验&nbsp;&nbsp;证&nbsp;码</span>：
                 <input type="text" class=" mlr15 text_regsit validate[required,custom[onlyNumber]" style="width:70px;" name="validateImg"  id="validateImg" desc="验证码" />
                 <img vertical-align="middle" src="validate" width="70" height="22"  style="padding-top: 5px;" alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" />
                 &nbsp;&nbsp;<font class="c999">如看不清图片，请点击图片刷新验证码。</font>
             </li>
             <li class="bnt" style="height:120px;">
            <span class="f"> 注册条款：<input name="" onclick="checkRadio();" id="chbrules" type="checkbox" checked="checked" value="1"  />我已看过并同意<a target="_blank" href="#" class="fontun06c">《${compname}服务协议》</a><br/>
            
             <input type="submit" class="button_login mt10" id="submitreg" value="立即注册"  />
            
             <font class="f00"><ww:property value="fieldErrors.validate"/></font></span>
             <span class="r msger">&nbsp;</span>
             </li>
             
            </ul>                                                   
        </div>
     </div>
   </form>
</div>
<ww:include page="../footer.jsp"/>
</body>
</html>
<script type="text/javascript">

function checkRadio(){

var xieyi = document.getElementById("chbrules").checked;

if(xieyi==false){
  document.getElementById("submitreg").disabled=true;
}else{
  document.getElementById("submitreg").disabled=false;
}

}
</script>