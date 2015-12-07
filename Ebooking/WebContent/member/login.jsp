<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}会员登陆</title>


<ww:head name="login" jsURL="member" />

<script type="text/javascript" src="js/jquery1.3.2.js"></script>
</head>
<script language="javascript" for="document"  event="onkeydown">
     $(document).ready(function(){
    
          if(event.keyCode==13)     //判断回车按钮事件
          {   
             $("#btnlogin").click();
          }
          
     });
 document.onkeypress=function(e){

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
        if(code=='13')
        {
        sub();
        }
        
    }
</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
		
	</div>
</div>
<!----------header over---------->
<div id="login">
    <div id="left" class="r mt10">
        <div class="titlelogin"><font class="black">会员登录</font></div>
        <form action="login!Login.jspx" name="form1" method="post" id="form1">
        <div class="box_sea loginer" style=" border-top:none;">
           <ul>
            <li class="nohave">&nbsp;</li>
          
            <li>用户名：<input type="text" class="text_search" id="uname" title="用户名不能为空!" name="loginname" value="<ww:property value="customeruser.loginname"/>"  /></li>
            <li><span class="f f00"><ww:property value="fieldErrors.username"/></span><a href="login!toRegsit.jspx" class="fontun06c r" >立即注册</a><div class="c"></div></li>
            <li>密&nbsp;码：<input type="password" title="密码不能为空!" class="text_search" id="logpassword" name="logpassword" value="<ww:property value="customeruser.logpassword"/>"  /></li>
            <li><span class="f f00"><ww:property value="fieldErrors.password"/></span><a href="login!toForget.jspx" class="fontun06c r" >忘记密码</a><div class="c"></div></li>
            <li>验证码：<input type="text" title="验证码不能为空!" class="text_searchwf" id="validateImg" name="validateImg"  /><img vertical-align="middle" src="validate" width="70" height="22"  style="padding-top: 5px;" alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" /></li>
            <li><span class="f00"><ww:property value="fieldErrors.validate"/></span>&nbsp;</li>
            <li class="bnt" style=" height:40px; padding:5px 0 8px 0; text-align:center;">
           <!-- <span class="f">搜索最低的机票，<br/> 上${compname}。</span> -->
           <span><input type="button" id="btnlogin" class="button_login mt3"  value="立即登录" onclick="return sub();"  /></span>
           <div class="c"></div>
          </li>
           </ul>
        </div>
        </form>
        <!-- <div class="loginbot"></div> -->
        <!--
        <div class="ad mt7"><img src="images/ad_sea.jpg" width="260" height="100" /></div>
        <div class="ad mt7"><img src="images/ad_sea.jpg" width="260" height="100" /></div>
    	-->
    </div>
    <div id="right" class="f mt10">
       <div><img src="images/air/air04.jpg" width="732" height="272" /></div>
       <div class="guild mt10">
          <ul>
           <li class="left_login f">&nbsp;</li>
           <li class="center_login f">
             <dt class="guildone"><font class="black">快捷注册！</font>  <br/>为您提供机票、酒店在线预订服务，更优惠，安全有保障！</dt>
             <dt class="guildtwo"><font class="black">优质服务！</font><br/>管理个人信息,订单信息。24小时客服服务!</dt>
           </li>
           <li class="r right_login">&nbsp;</li>
          </ul> 
       </div>
    </div>
    <div class="c"></div>
</div>

<ww:include page="../footer.jsp"/> 
</body>
</html>
<script>
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
			
			
			
	 // $('#uname').poshytip({
	//			content: "此乘机人已经存在，请重新选择!",
	//			showOn: 'focus',
	//			alignTo: 'target',
	//			alignX: 'right',
	//			alignY: 'center',
	//			offsetX: 5
	//		    });
			    
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

</script>