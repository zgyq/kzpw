<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page import="java.util.*;"%>
<%
	String abspath="http://"+request.getServerName() +":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>珠海科宇科技</title>
		<link rel="stylesheet" href="login/zhuhai/css/login.css" />
	</head>
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
 		alert("用户名不能为空");
 		document.getElementById('validate_img').src="validate?timetramp="+new Date().getTime();
 		 flag=false;
 		 return;
 	}
 	
 	
 	if(upa == ""){
 		alert("密码不能为空");
 		document.getElementById('validate_img').src="validate?timetramp="+new Date().getTime();
 		flag=false;
 		return;
 	}
 	if(uvi == ""){
 		alert("请输入验证码");
 		document.getElementById('validate_img').src="validate?timetramp="+new Date().getTime();
 		flag=false;
 		return;
 	}
 	
 	
 	  document.form1.submit();
 	
 	
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
		opener.top.location= "<%=abspath+"index.jsp"%>";
		window.close();
	}else if(top!=self){
		top.location="<%=abspath+"index.jsp"%>";
	}
</script>
	<body>
		<div class="top">
			<div class="w1100">
				<a class="logo" href="#">
					<img src="login/zhuhai/img/logo.png"/>
				</a>
				<img src="login/zhuhai/img/11-1.png" class="login-word"/>
				
				<div class="phone-num">服务热线：400-6726-189</div>
			</div>
		</div>
		<!--top over-->
		<div class="img-slider">
			<div class="slider-box">
				<div class="slider">
					<div class="flexslider">
						<ul class="slides">
							<li>
								<div class="img1"><!--<img src="img/img.jpg"  alt="" />--></div>
							</li>
							<li>
								<div class="img2"><!--<img src="img/img1.jpg"  alt="" />--></div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<form action="<%=request.getContextPath()%>/login!login.action" name="form1" method="post">
			<div class="w1100">
				<div class="login-box">
					<h1 class="title">登&nbsp;&nbsp;录</h1>
					<div class="login-input">
						<input type="text" id="uname" name="loginname" class="username" placeholder="username" maxlength="20" value="<ww:property value="user.loginname"/>" />
						<input type="password" class="password" placeholder="password" id="upass" name="logpassword" maxlength="20" value="<ww:property value="user.logpassword"/>">
					
					</div>
					<div class="code">
						<label for="">验证码：</label><input type="text" id="validateImg" name="validateImg"  maxlength="4" /><img src="validate" id="validate_img" onclick="javascript:freshvalidateimg();return false;" width="54" height="20" /><a href="#" onclick="javascript:freshvalidateimg();return false;">换一张</a>
					</div>
					<div class="input-btn">
						<span class="input-check"><a class="icon-login check" href="#"></a>记住密码</span>
						<a href="javascript:submitForm();" id="btnlogin"  class="input-btn-login">登录</a>
					</div>
					<div class="input-link" style="display: none;">
						<a href="#" class="reg">注册</a>
						<a href="#" class="forg">忘记密码</a>
					</div>
				</div>
			</div>
			</form>
		</div>
		<!--img-slider over-->
		<div class="six-points w1100">
			<div class="points">
				<em class="plane-book"></em>
				<p class="title">机票预订</p>
				<p>返点全返</p>
				<p>保障利润最大化</p>
			</div>
			<div class="points">
				<em class="ticket-qurey"></em>
				<p class="title">火车票查询</p>
				<p>网络订票</p>
				<p>实时查询，实时预订</p>
			</div>
			<div class="points">
				<em class="hotel-order"></em>
				<p class="title">酒店预订</p>
				<p>全国酒店任由定</p>
				<p>利润全返</p>
			</div>
			<div class="points">
				<em class="travel-zr"></em>
				<p class="title">旅游签证</p>
				<p>快捷，方便</p>
				<p>利润高</p>
			</div>
			<div class="points">
				<em class="phone-zc"></em>
				<p class="title">手机充值</p>
				<p>移动，联通，电信</p>
				<p>全都行</p>
			</div>
			<div class="points">
				<em class="pos"></em>
				<p class="title">支付选择</p>
				<p>快捷，方便</p>
				<p>税率低</p>
			</div>
		</div>
		<!--six-points over-->
		<div class="bottom">
			<p class="a-link"><a href="#">回到首页</a>|<a href="#">联系我们</a>|<a href="#">关于我们</a>|<a href="#">合作伙伴</a></p>
			<p class="copy-right">Copyright©2013-2020 珠海科宇科技有限公司版权所有 粤ICP备15018989号-3 联系电话：400-6726-189 </p>
		</div>
		
		<script type="text/javascript" src="login/zhuhai/js/jquery-1.8.2.min.js" ></script>
		<script type="text/javascript" src="login/zhuhai/js/jquery-imgSlider-ByLisa-1.0.0.js" ></script>
		<script type="text/javascript">
		    $(function(){
		      $('.flexslider').flexslider({
		        animation: "slide",
		        start: function(slider){
		          $('body').removeClass('loading');
		        }
		      });
		    });
		  </script>
	</body>
</html>
<script type="text/javascript">
function freshvalidateimg()
{
	document.getElementById('validate_img').src="validate?timetramp="+new Date().getTime();
}
<ww:if test="fieldErrors.erromessage!=null">
alert('<ww:property value="fieldErrors.erromessage"/>');
</ww:if>
</script>