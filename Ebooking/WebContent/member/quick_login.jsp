<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-登录</title>
<ww:head name="login" jsURL="citycontrol" />
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>   
<!----------header over---------->
<div id="login">
    <div id="left" class="f mt10 mf45">
        <div class="titlelogin"><font class="black">会员登录</font></div>
        <form action="login!Login.jspx" name="form1" method="post" id="form1">
	        <div class="box_sea loginer" style=" border-top:none;">
	           <ul>
	            <li class="nohave">&nbsp;</li>
	            <li>用户名：<input type="text" title="用户名不能为空!" id="uname" name="loginname" value="<ww:property value="customeruser.loginname"/>" class="text_search"  /></li>
	            <li><span class="f f00"><ww:property value="fieldErrors.username"/></span><a href="login!toRegsit.jspx" class="fontun06c r" >立即注册</a><div class="c"></div></li>
	            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" title="密码不能为空!" class="text_search" id="logpassword" name="logpassword" value="<ww:property value="customeruser.logpassword"/>"  /></li>
	            <li><span class="f f00"><ww:property value="fieldErrors.password"/></span><a href="login!toForget.jspx" class="fontun06c r" >忘记密码</a><div class="c"></div></li>
	            <li>验证码：<input type="text" class="text_searchwf" title="验证码不能为空!" id="validateImg" name="validateImg"  /><img vertical-align="middle" src="validate" width="70" height="22"  style="padding-top: 5px;" alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" /></li>
	            <li><span class="f00"><ww:property value="fieldErrors.validate"/></span>&nbsp;</li>
	            <li class="bnt" style=" height:40px; padding:12px 0 16px 0; text-align:center;">
	           <!-- <span class="f">搜索最优的机票，<br/> 上${compname}。</span> -->
	           <span><input type="submit"  class="button_login"  value="立即登录" onclick="return sub();"  /></span>
	           <div class="c"></div>
	          </li>
	           </ul>
	        </div>
        </form>
        <!-- <div class="loginbot"></div> -->
    </div>
   <form action="login!LoginByMobile.jspx" name="form2" method="post" id="form2">
    <div class="f mf10 mt10">
       <div class="box login_right">
        <div class="tit">
               <font class="black low2 f mr15">手机直接预订</font>
        </div>
        <div class="gobooking">
          <ul>
           <li class="gobookingone">直接输入联系手机号码进行预订</li>
           <li class="gobookingtwo">手机号码：<input type="text" class="text_search" id="login_mobile" title="手机号不能为空!" name="login_mobile" value="<ww:property value="login_mobile"/>"  /></li>
           <li class="gobookingbnt"><input type="button" value="直接预订" onclick="return submobile();" class="button_first fff" /> </li>
           <li class="gobooktips f00"><ww:property value="fieldErrors.validatemobile"/></li>
          </ul> 
         </div>
       </div> 

    </div>
    </form>
    <div class="f mf10 mt10">
       <div class="box login_right">
        <div class="tit">
               <font class="black low2 f mr15">马上注册成会员</font>
        </div>
        <div class="gobooking">
          <ul>
           <li class="regsiterone" style="padding:30px 0 0 30px">注册${compname}会员即能享受：</li>
           <li class="pf50">1.免费注册，不收取会员费！</li>
           <li class="pf50">2.预订产品得积分，兑换超值礼品！</li>
           <li class="pf50">3.享受更加体贴的个性化服务！</li>
           <li class="regsiterbnt"><input type="button" value="立即注册" class="button_second fff" onclick="toRegist();" /> </li>
          </ul> 
         </div>
       </div> 
    </div>
</div>
<ww:include page="../footer.jsp"/>  
</body>
</html>
<script>

function toRegist(){
window.location.href="login!toRegsit.jspx";
}


  function freshvalidate()
{

	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
		
}
function sub(){
 if($("#uname").val()==""){  
	 //验证提示
	 $('#uname').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});

			    
	$("#uname").focus();
	 return false; 
	 }
	 
	 
			    
			    
	 
	 
 if($("#logpassword").val()==""){  
	 //验证提示
	 $('#logpassword').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#logpassword").focus();
	 return false; 
	 }
	 
	  if($("#validateImg").val()==""){  
	 //验证提示
	 $('#validateImg').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			});
	$("#validateImg").focus();
	 return false; 
	 }
	 
	  document.form1.submit();
}
function submobile(){

 if($("#login_mobile").val()==""){  
	 //验证提示
	 $('#login_mobile').poshytip({
				content: "手机号不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});

			    
	$("#login_mobile").focus();
	 return false; 
	 }
		if(!IsMobile($("#login_mobile").val())){
	 		 $("#login_mobile").poshytip({
				content: "手机号格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#login_mobile").focus();
 		return false;
}

 document.form2.submit();
}
</script>