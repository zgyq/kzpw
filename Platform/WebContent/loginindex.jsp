<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page import="java.util.*;"%>
<%
	String abspath="http://"+request.getServerName() +":"+request.getServerPort() +request.getContextPath()+"/";
	if(session.getAttribute("dns")==null){
		response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}票务商旅系统</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery1.3.2.js"></script>
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

function SetHome(obj){
	try{
		obj.style.behavior='url(#default#homepage)';
		obj.setHomePage('http://<%=request.getServerName()%>:<%=request.getServerPort()%>/cn_home/');
	}catch(e){
		if(window.netscape){
			try{
				netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
			}catch(e){
				alert("抱歉，此操作被浏览器拒绝！\n\n请在浏览器地址栏输入“about:config”并回车然后将[signed.applets.codebase_principal_support]设置为'true'");
			};
		}else{
			alert("抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将http://<%=request.getServerName()%>:<%=request.getServerPort()%>/cn_home/设置为首页。");
		};
	};
};
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validator.js"></script>

</head>

<body>

<div id="index">
  <div class="top"><img src="newimages/newtop.gif" width="1002" height="99" border="0" usemap="#Map" />
    <map name="Map" id="Map">
      <area shape="rect" coords="276,36,370,63" href="index.jsp" />
      <area shape="rect" coords="661,43,729,58" href="jiamengshang.jsp" />
      <area shape="rect" coords="773,43,843,57" href="gygl.jsp" />
      <area shape="rect" coords="882,42,940,57" href="ptys.jsp" />
      <area shape="rect" coords="824,11,880,26" id="setHomePage" onclick="SetHome(this)" />
      <area shape="rect" coords="914,12,972,26" href="fwxy.jsp" />
    </map>
    <div class="logo"><img src="images/${dns.logologinsrc}" width="110" height="97" /> </div>
  </div>
  <div>
     <div class="left f">
     <ww:include page="login.jsp"></ww:include>
     </div>
     <div class="r">
        <div class="f hdp">
<iframe src="advindex/index.html" scrolling="no" hspace="0" frameborder="0" width="561" height="304"></iframe>
        </div>
        <div class="r right_n">
            <ul>
            <li>1.交易成本业内最低</li>
            <li>2.技术最领先</li>
            <li>3.实现效益最大化</li>
            <li>4.客户利益保障</li>
            <li>5.交易费定价合理</li>
            <li>6.专业客户服务团队</li>
            <li style="color:#f48000">欢迎加入遨旅航空</li>
            </ul>
        </div>
        <div class="c"></div>
     </div>
     <div class="c"></div>
  </div> 
  <div><img src="newimages/ad_new1.gif" width="1002" height="100" /></div>  
  <div class="botm">
  <ww:include page="loginbottom.jsp"/>
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
