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
<title>登录--${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link href="agent_resource/zs/zs.css" type="text/css" rel="stylesheet" />

<style>

img {behavior:	url("agent_resource/zs/home_images/pngbehavior.htc");
}
</style>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>

<script language="javascript" for="document"  event="onkeydown">
     $(document).ready(function()
     {
	     //判断是否是IE6内核浏览器，暂不支持IE6
	    if(window.XMLHttpRequest)//判断浏览器是否属于Mozilla,Sofari
	    {
	        
	    }
	    else if(window.ActiveXObject)//判断浏览器是否属于IE
	    {
	        var browser=navigator.appName 
	        var b_version=navigator.appVersion 
	        var version=b_version.split(";"); 
	        var trim_Version=version[1].replace(/[ ]/g,""); 
	       
	        if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE6.0") 
	        { 
	           alert("目前本系统不支持IE6浏览器，请使用IE 7.0及以上版本浏览器访问！");
	           $("#uname").attr("disabled","disabled");
	           $("#upass").attr("disabled","disabled");
	           $("#validateImg").attr("disabled","disabled");
	           $("#imgbtn").attr("disabled","disabled");
	           
	        } 
	    }
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

<body >

<div id="content">  

  <div>

      <div class="logo f" ><img src="images/${dns.logosrc}" width="302" height="78" /> </div>

      <div class="r cooperation"><a href="#" target="_blank">诚征供应商</a> | <a href="#" target="_blank">合作伙伴</a> |<a href="#" target="_blank"> 分销商加盟</a> |<a href="#" target="_blank"> 返回首页</a> | <a href="#" target="_blank">易宝注册</a></div>
      <div class="c"></div>
  </div>
  <div>
<div class="f left">
       <div class="word">&nbsp;</div>
       <div class="ad"><img src="agent_resource/zs/home_images/ad.jpg" width="585" height="227" /></div>
      <div class="partner">
        <ul>
         <li><img src="agent_resource/zs/home_images/partner.gif" width="104" height="44" /></li>
         <li><img src="agent_resource/zs/home_images/evaair.gif" width="104"  height="44" /></li>
         <li><img src="agent_resource/zs/home_images/france.gif" width="104"  height="44" /></li>
         <li><img src="agent_resource/zs/home_images/ctv.gif" width="104"  height="44" /></li>
         <li><img src="agent_resource/zs/home_images/lufthansa.gif" width="104"  height="44" /></li>
        </ul>
       </div>
      <div class="partner" style="margin-left:20px;">
        <ul>
         <li><img src="agent_resource/zs/home_images/iata.gif" width="102" height="42" /></li>
         <li><img src="agent_resource/zs/home_images/ma.gif" width="70" height="42" /></li>
         <li><img src="agent_resource/zs/home_images/minhang.gif" width="98" height="42" /></li>
         <li><img src="agent_resource/zs/home_images/hu.gif" width="65" height="42" /></li>
         <li><img src="agent_resource/zs/home_images/pata.gif" width="87" height="42" /></li>
         <li><img src="agent_resource/zs/home_images/huoche.gif" width="65" height="42" /></li>
        </ul>
       </div>
      <div class="daili"><b class="font-red">代理商：</b>北京 福建 江苏 辽宁 浙江 四川 河北 深圳</div>
     </div>
     
<div class="r right">

       <div class="member f">
       <form action="<%=request.getContextPath()%>/login!login.action" name="form1" method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <th scope="col" width="95" height="48">&nbsp;</th>
            <th scope="col" align="left"> <input type="text" class="input" id="uname" name="loginname" value="<ww:property value="user.loginname"/>" /></th>
          </tr>
          <tr>
            <td width="60" height="48">&nbsp;</td>
            <td><input type="password" id="upass" class="input" name="logpassword" require="true" value="<ww:property value="user.logpassword"/>" /></td>
          </tr>
          <tr>
            <td width="60" height="48">&nbsp;</td>
            <td><input id="validateImg" name="validateImg" class="input_d" type="text" size="6" style=" margin-right:0px;" align="absmiddle" /> 
    <img vertical-align="middle" src="validate" width="60" height="26"  style="margin-left: -20px; margin-top:7px;"  alt="" id="checkvalidate1" onclick="javascript:freshvalidate();return false;" /></td>
          </tr>
          <tr>
            <td align="center"  colspan="2" style="line-height:30px;" height="30" class="font-red">
            <span id="validateImg3"><ww:property value="fieldErrors.password"/></span> <span id="validateImg2" style="color:red;font-size:12px;line-height:26px;"><ww:property value="fieldErrors.username"/></span>
            </td>
          </tr>
          <tr>
            <td colspan="2"  align="center"><input type="submit" class="button" value="立即登录"  /><input type="button" class="button" value="采购注册" /></td>
          </tr>
        </table>
       </form>
       </div>
       <div class="r ad_r"><img src="agent_resource/zs/home_images/ad_1.jpg" width="114" height="237" /></div>
       <div class="c"></div>

       <div class="ann">
        <div class="f annimg">&nbsp;</div>
       
        <p class="f">平台出票支付设定<br/>  国内各机场电话南航，<br/> 川航销售的BS南航航销售的BS...<br/> 各航空公司登机航南航，  </p>
        <span class="c"></span>
       </div>
     </div>
    <div class="c"></div>
  </div>
  <div class="mt8"><img src="agent_resource/zs/home_images/tool.png" width="958" height="32" border="0" usemap="#Map"  />
    <map name="Map" id="Map">
      <area shape="rect" coords="199,8,248,22" target="_blank" href="http://map.sogou.com/home" />
      <area shape="rect" coords="295,8,344,23" target="_blank" href="http://www.weather.com.cn/forecast/index.shtml" />
      <area shape="rect" coords="404,8,454,23" target="_blank" href="http://www.shenzhenpost.com.cn/services/postcode/civilcode.asp" />
      <area shape="rect" coords="506,8,554,23" target="_blank" href="http://58.240.97.20/BusSchedule" />
      <area shape="rect" coords="613,9,663,22" target="_blank" href="http://www.8684.cn" />
      <area shape="rect" coords="714,9,765,24" target="_blank" href="http://www.ctvits.com" />
      <area shape="rect" coords="818,8,867,24" target="_blank" href="http://travel.163.com/special/s/sight.html" />
    </map>
  </div>
  <div>
           <div class="f bottom">
           ${dns.shortname}客服中心：${dns.serviceline } ${dns.shortname}技术中心：010-57112277 ${dns.shortname}商旅中心：010-57112266 <br/>
           客服中心地址：${dns.address }<br />
           ${dns.shortname}商旅中心&nbsp;<font class="font-f60">京ICP备11014516</font>&nbsp;监督电话：4000-152-325&nbsp;
           </div>
           <div class="r" style="padding-right:20px;">
           <img src="agent_resource/zs/home_images/b_a.gif" class="mt18 mr4" width="120" height="50" />
           <img src="agent_resource/zs/home_images/b_c.gif" class="mt18 mr4"  width="120" height="50" />
           <img src="agent_resource/zs/home_images/137.gif" class="mt18 mr4"  width="137" height="47" /></div>
           <div class="c"></div>
  </div>
</div>
</body>
</html>


<script type="text/javascript">
function freshvalidate()
{
	document.getElementById('checkvalidate1').src="validate?timetramp="+new Date().getTime();
}
</script>

