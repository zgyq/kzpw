<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<title>亿票联盟商旅系统</title>
		<meta name="keywords" content="亿票联盟商旅系统">
		<meta name="description" content="亿票联盟商旅系统">
		<link href="wel_yplm/css/b2b_guanlizhongxin.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript" src="js/aircity/js/jquery-1.4.2.min.js"></script>
	</head>
	<body>
		<div style="width:100%;height:20px;">
		</div>
		<div class="b2b_guanlizhongxin">
			<div class="b2b_guanlizhongxin_body">
				<h2>
					公司基本信息
				</h2>
				<ul>
					<li>
						公司编码：<ww:property value="agent.code"/><!--不允许修改 -->	
					</li>
					<li>
						公司名称：<ww:property value="agent.agentcompanyname"/><!--不允许修改 -->
					</li>
					<li>
						公司简称：<ww:property value="agent.agentshortname"/><!--不允许修改 -->
					</li>
					
					
					<div id="agentedit">
					<li id="gsdh_1">
						公司电话：
						<ww:property value="agent.agenttel"/>
						<a href="#"  onclick="showdiv('agentshow','agentedit');">点此修改</a><!--弹窗修改就可以 或者其他形式的都可以-->
					</li>
					
					<li id="gsdz_1">
						通信地址：<ww:property value="agent.agentaddress"/><a href="#" onclick="showdiv('agentshow','agentedit');">点此修改</a>
					</li>
					<li>
					<a href="#" class="b2b_body_left_xiugaigerenxinxi" style="color: red" onclick="showdiv('agentshow','agentedit');">点击修改信息</a>
				    </li>
					</div>
					
					<div id="agentshow" style="display: none">
					<li id="gsdh_2" >
						公司电话：<input id="agenttel" name="agenttel" value="<ww:property value="agent.agenttel"/>" />
					</li>
					<li id="gsdz_2">
						通信地址：<input id="agentaddress" name="agentaddress" value="<ww:property value="agent.agentaddress"/>" />
					</li>
					<li>
					<a href="#" class="b2b_body_left_xiugaigerenxinxi" style="color: red" onclick="SeveUpdate_comp();">点击保存信息</a>
				    </li>
					</div>
					
					
				</ul>
				<div class="clear">
				</div>
				<h2>
					机构信息
				</h2>
				<ul>
					<li>
						所在区域：<ww:property value="getcityNamebyId(agent.cityid)"/><!--不允许修改 -->
					</li>
					<li>
						合同期限：<ww:property value="agent.agentvedate"/><!--不允许修改 -->
					</li>
				</ul>
				<div class="clear">
				</div>
				<h2>
					联系人信息
				</h2>
				<ul>
					<div id="agentedit1">
					<li>
						联系人：<ww:property value="agent.agentcontactname"/><a href="#" onclick="showdiv('agentshow1','agentedit1');">点此修改</a>
					</li>
					<li>
						联系电话：<ww:property value="agent.agentphone"/><a href="#" onclick="showdiv('agentshow1','agentedit1');">点此修改</a>
					</li>
					<li>
						联系邮箱：<ww:property value="agent.agentemail"/><a href="#" onclick="showdiv('agentshow1','agentedit1');">点此修改</a>
					</li>
					<li>
						联系QQ：<ww:property value="agent.msnqq"/><a href="#" onclick="showdiv('agentshow1','agentedit1');">点此修改</a><!--弹窗修改就可以-->
					</li>
					<li>
					<a href="#" class="b2b_body_left_xiugaigerenxinxi" style="color: red" onclick="showdiv('agentshow1','agentedit1');">点击修改信息</a>
				    </li>
				    
					</div>
					<div id="agentshow1" style="display: none">
					<li>
						联系人：<input id="agentcontactname" name="agentcontactname" value="<ww:property value="agent.agentcontactname"/>" />
					</li>
					<li>
						联系电话：<input id="agentphone" name="agentphone" value="<ww:property value="agent.agentphone"/>" />
					</li>
					<li>
						联系邮箱：<input id="agentemail" name="agentemail" value="<ww:property value="agent.agentemail"/>" />
					</li>
					<li>
						联系QQ：<input id="msnqq" name="msnqq" value="<ww:property value="agent.msnqq"/>" />
					</li>
					<li>
					<a href="#" class="b2b_body_left_xiugaigerenxinxi" style="color: red" onclick="SeveUpdate_link();">点击保存信息</a>
				    </li>
				    
					</div>
					
				</ul>
				<div class="clear">
				</div>
				<h2>
					账户信息
				</h2>
				<ul>
					<li>
						账户名称：<ww:property value="#session.loginuser.loginname" /><!--不允许修改 -->
					</li>
					<div id="agentedit2">
					<li>
						密码：******<a href="#" onclick="showdiv('agentshow2','agentedit2');">点此修改</a>
					</li>
					</div>
					<div id="agentshow2" style="display: none;">
					<li>
						输入密码：<input type="password" id="pwd" name="pwd" value="" maxlength="12" />
					</li>
					<li>
						确认密码：<input type="password" id="pwd2" name="pwd" value="" maxlength="12" />
					</li>
					<li>
					<a href="#" class="b2b_body_left_xiugaigerenxinxi" style="color: red" onclick="SeveUpdate_pwd();">点击保存密码</a>
				    </li>
					</div>
					
					<li>
						代理级别：<span><ww:if test="allowlevelcount==2">省代理</ww:if>
							<ww:elseif test="allowlevelcount==1">市代理</ww:elseif>
							<ww:elseif test="allowlevelcount==0">区代理</ww:elseif>
							<ww:else>省代理</ww:else><span><!--不允许修改 -->
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>

<script type="text/javascript">

function ShowDivH(id) {

 $("#"+id+"_1").hide();
 $("#"+id+"_2").show();

}
 function  showdiv(id,id2){
 $("#"+id2).hide();
   $("#"+id).show();
   }
   
function SeveUpdate_link(id) {
var agentcontactname=$("#agentcontactname").val();
var agentphone=$("#agentphone").val();
var agentemail=$("#agentemail").val();
var msnqq=$("#msnqq").val();

$.ajax({
       url:"login!ajaxEditAgent3.action",
      type:"POST",
      data:{msnqq:msnqq,agentemail:agentemail,agentphone:agentphone,agentcontactname:agentcontactname,para:Math.floor(Math.random()*100)},
      //beforeSend:function(){$("#a_edit").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");},             
      success:function(data){
        if(data=='1'){
        alert("修改成功!");
        window.location.href="login!toagentshow.action";
        
        }else{
         alert("修改失败!请从新尝试!");
        }
   	 }
    
    });
 

}
function SeveUpdate_comp(id) {
var agenttel=$("#agenttel").val();
var agentaddress=$("#agentaddress").val();

$.ajax({
       url:"login!ajaxEditAgent2.action",
      type:"POST",
      data:{agentaddress:agentaddress,agenttel:agenttel,para:Math.floor(Math.random()*100)},
      //beforeSend:function(){$("#a_edit").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");},             
      success:function(data){
        if(data=='1'){
        alert("修改成功!");
        window.location.href="login!toagentshow.action";
        
        }else{
         alert("修改失败!请从新尝试!");
        }
   	 }
    
    });
 

}
function SeveUpdate_pwd(id) {
var pwd=$("#pwd").val();
var pwd2=$("#pwd2").val();
if(pwd==''){
alert("密码不能为空!!!");
$("#pwd").focus();
return;
}
if(pwd.length<6){
alert("密码长度应该大于6位数!!!");
$("#pwd").focus();
return;
}

if(pwd2==''){
alert("请再次输入确认密码!!!");
$("#pwd2").focus();
return;
}
if(pwd2!=pwd){
alert("2次密码不一致!!!");
$("#pwd2").focus();
return;
}

$.ajax({
       url:"login!ajaxUpdatePwd.action",
      type:"POST",
      data:{pwd:pwd,para:Math.floor(Math.random()*100)},
      //beforeSend:function(){$("#a_edit").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");},             
      success:function(data){
        if(data=='1'){
        alert("修改成功!请从新登陆!!!");
        window.location.href="login!logout.action";
        
        }else{
         alert("修改失败!请从新尝试!");
        }
   	 }
    
    });
 

}


</script>