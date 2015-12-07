<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left</title>
<script type="text/javascript" src="../js/jquery1.3.2.js"></script>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/left_n.css" type="text/css" rel="stylesheet" />
</head>
<body>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left</title>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/left_n.css" type="text/css" rel="stylesheet" />
<script src="../js/js_new/left.js" type="text/javascript"></script>
<script> 
//展开第一项
$(document).ready(function (){
var obj=document.getElementById('menu101');
 
	if(typeof(obj)!='undefined'){	
	   menuChange('menu101',$("#hidheight_1").val(),'menutitle101');
	}
});
 function tobase(ba){
//alert(ba);
//var nobsae=atob(ba);
//alert(nobsae);
 parent.member.location.href="../"+ba;
}
 
</script>
<style> 
.button_d{background:url(images/61.gif); width:62px; border:none; line-height:23px; height:23px;color:#fff;  text-align:center;cursor:pointer; margin-top: 10px;}
 
</style>
 
</head>
 
<body style="height: 100%; margin: 0; padding: 0">
<div id="left">
<div class="box frame" lang="th" >
  <div class="telo"><ww:if test="rightid==null">    
    <ww:property value="#session.mununame"/>
	</ww:if>
	<img src="imagess/ico_platforms.gif" width="28" height="30" /><input name="wqqw" id="rightid" type="hidden" value="<ww:property value="#session.munuid"/>" />
    <ww:property  value="getsysrightname(rightid)"/>
   </div>
   <%int j = 1; int i = 1;%>
<ww:iterator value="listRoot" status="kk">
  <div class="tela_less"   id='menutitle10<%=i%>'
   onclick="menuChange('menu10<%=i%>',<ww:property value="getListSub(id).size*26"/>,'menutitle10<%=i%>');">
				<span><ww:property   value="name"/></span>
     <input type="hidden" value='<ww:property value="getListSub(id).size*26"/>' id='hidheight_<%=i%>'>
  </div>
  
  <div class="list" id='menu10<%=i%>'
			style='DISPLAY: none; FILTER: alpha(Opacity = 100); WIDTH: 194px; HEIGHT: 0px'>
   <ul>
   		<ww:iterator value="getListSub(id)" id="listServiceItems">
		<li><a href="#"
			 id="ddd<%=j%>" class="lib" onclick="tobase('<ww:property value="code.trim()"/>');onloadcss(<%=j%>);">
			<span>
			<ww:property value="name" />
			<ww:if	test="id==10348 || id==10350 ||id==10377">
			<span id="span_count_<ww:property value="id" />" style="color:red"></span>
			</ww:if>
			</span>
			</a>
		</li>
		<%j++;%>
		</ww:iterator>
   </ul>
  </div>
<%i++;%>
</ww:iterator>
<ul style="display: none">
<li style="text-align: center; padding-top: 5px">
<a href="https://lab.alipay.com/user/reg/index.htm" target="_blank"><img src="images/alipayregist.gif" /></a>
</li>
</ul>
</div>
</div>
</body>
</html>
</body>
</html>
