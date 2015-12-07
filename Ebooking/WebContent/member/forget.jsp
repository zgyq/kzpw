<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-找回密码</title>
<ww:head name="login" jsURL="member" />
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="regsiter">
    <div class="mt7 box">
        <div class="tit">
               <font class="black low2 f mr15">找回密码</font>
               <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
               
               <div class="c"></div>
        </div>
        <div class="regsit">
             <div class="cn_center">
             <form action="<%=request.getContextPath()%>/login!getmobile.jspx" name="form1" id="form1" method="post">
              <div class="f first">
                 <div class="f firster">&nbsp;</div><font class="bigfff">第一步:验证账号</font>
                 <div class="c"></div>
                 <ul>
                 <li><font class="b000">用户名：</font><input type="text" id="username" name="username" class="text_regsitlang"  /></li>
                 <li><font class="b000">验证码：</font><input type="text" id="validateImg" name="validateImg" class="text_regsitlatt"  /><img vertical-align="middle" src="validate" width="70" height="22"  style="padding-top: 5px;" alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" /></li>
                 <li><input type="button" class="button_first fff mr15" id="butvaluadata"  value="验证账号" onclick="SeachUser();" /><font class="f00" ><span id="meassg">请验证您找回密码的账户！</span></font></li>
                 </ul>
               </div>
               </form>
              <div class="f centerline">&nbsp;</div>
              <div class="f second">
                 <div><div class="f seconder">&nbsp;</div><font class="bigfff">第二步：找回密码</font><div class="c"></div></div>
                 <ul>
                 <li class="phone" style="line-height:26px;">
                   <div class="f">
                    <dt class="b000">系统将把密码以短信发送到您注册的手机上。 </dt>
                    <dt class="font-1da7d9">（如果忘记注册手机或已丢失请联系客服。）</dt>
                   </div>
                   <div class="f"><input type="button" id="butmobile" class="button_second fff" disabled="disabled" value="找回密码" onclick="SeachByMobile();" /></div>
                   <div class="c"></div> 
                 </li>
                 <li class="email" style="line-height:26px;">
                    <div class="f">
                    <dt class="b000">系统将把密码以邮件发送到您注册的邮箱内。 </dt>
                    <dt class="font-1da7d9">（如果忘记注册邮箱或已丢失请联系客服。）</dt>
                    </div>
                    <div class="f"><input type="button" id="butmail"  class="button_second fff" disabled="disabled"  value="找回密码" onclick="SeachByMail();" /></div>
                   <div class="c"></div> 
                 </li>
                 </ul>
              </div>       
              <div class="c nohave"></div>
              <div class="c nohave"></div>
              </div>                                            
        </div>
     </div>
       <div class="floatall center" id="hiddiv" style="display: none">
        <div class="floatbox">
          <div class="floatboxin">
            <ul>
              <li style="height:35px;">
              <span class="tipseds f">&nbsp;</span><font class="c00016 f">温馨提示</font><span class="r close" onclick="colsediv();"></span>
               <div class="c"></div>
              </li>
              <li>
              <div class="nohave box_top_xu">&nbsp;</div>
              <p  class="pl10">
              您的密码已经成功发送到您的手机上。<br/> 请您及时确认，并登录系统进行修改。<br/> 如有疑问请咨询客服电话：${tel}</p>
              <div class="nohave">&nbsp;</div>
              </li>
            </ul>
          </div>
         </div>
       </div>
</div>
<ww:include page="../footer.jsp"/>  
</body>
</html>
<script>
  function freshvalidate()
{

	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
		
}

function SeachUser(){
var username=$("#username").val();
var validateImg=$("#validateImg").val();

 if(username==""){  
	 //验证提示
	 $('#username').poshytip({
				content: "用户名不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#username").focus();
	 return false; 
	 }
if(IsCharacter(username)){  
	 //验证提示
	 $('#username').poshytip({
				content: "用户名不能为中文!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#username").focus();
	 return false; 
	 }
 if(validateImg==""){  
	 //验证提示
	 $('#validateImg').poshytip({
				content: "验证码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			});
	$("#validateImg").focus();
	 return false; 
	 }	 
 if(!IsNumber($("#validateImg").val())){
	       	$("#validateImg").poshytip({
				content: "验证码输入错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#validateImg").focus();
			     return false;
}

  $.ajax({
	    type:"POST",
	    url:"login!AjaxValadateUsername.jspx",
	    data:{ajax_username:username,ajax_img:validateImg},
	    async:false,         
	    success:function(data){
	   	//alert(data);
	   	if(data=='-1'){//验证码错误
	   	 		$("#validateImg").poshytip('hide');
	   	 		$("#validateImg").poshytip({
				content: "验证码输入错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#validateImg").focus();
			    $("#validateImg").val("");
			     return false;
	   	}
	   	if(data=='1'){//用户名错误
	   		 $('#username').poshytip({
	   			className: 'tip-yellowsimple',
				content: "用户名错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
			$("#username").focus();
			 return false; 
	   	}
	   	if(data=='0'){//验证通过
	   	
	   document.getElementById("butvaluadata").disabled = true;
	   document.getElementById("butmobile").disabled =false;
	   document.getElementById("butmail").disabled =false;
	   $("#meassg").html("用户名验证通过!");
	 
			
			
	   	}
	   
	   	
	   	
	   	
	     // $("#divliudianinfo").html(data);	
	     // document.getElementById("submit").disabled="";
	    }            
	    });	 

}
function SeachByMobile(){
var username=$("#username").val();

$.ajax({
	    type:"POST",
	    url:"login!AjaxSend.jspx",
	    data:{ajax_username:username},
	    async:false,         
	    success:function(data){
	    if(data=='1'){//发送失败
	   	
	   	}
	   	if(data=='0'){//发送成功
	   document.getElementById("butvaluadata").disabled = true;
	   document.getElementById("butmobile").disabled =true;
	   document.getElementById("butmail").disabled =true;
	   	 $("#hiddiv").show();
	   	}
	   	
	  
	    }            
	    });	

}
function SeachByMail(){
alert("邮箱找回密码暂未开放,敬请期待~!请先用手机找回~!");
}
function colsediv(){

 $("#hiddiv").hide();
}
</script>