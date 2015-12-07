<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="css/left.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="main_xc2/js/common.js"></script>
<script type="text/javascript" src="main_xc2/js/easySlider1.5.js"></script>
<script type="text/javascript" src="main_xc2/js/accordian.pack.js"></script>
</head>
<SCRIPT language=JavaScript>

$(document).ready(function (){
	  $("ul[id*='submenu']").each(function(i){
	 // alert(i);
	  	eval("submenu" + (i+1) + ".style.display=\"none\";");
	  });
	  
	  eval("submenu1.style.display=\"\";");
});



function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
document.getElementById("span_"+sid).className = "opens";
 //$("span_"+sid).className = "closes";
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
 //$("span_"+sid).className = "opens";
 document.getElementById("span_"+sid).className = "closes";
}
}
function tobase(ba){
//alert(ba);
//var nobsae=atob(ba);
//alert(nobsae);

//closes

 parent.member.location.href=ba;
}
</SCRIPT>
<body>
<div id="wrap">
<div class="left" >
<ul>

 <ww:iterator value="listRoot" status="kk">
	<li style="text-align: left;">
	<a href="#" onclick="showsubmenu('<ww:property value="(#kk.index)+1"/>');" class="btn">
	<span class="s-icon"></span><ww:property value="name"/><span id="span_<ww:property value="(#kk.index)+1"/>"  <ww:if test="#kk.index==0">class="opens"</ww:if><ww:else>class="closes"</ww:else>></span>
	</a>
	<ul id="submenu<ww:property value="(#kk.index)+1"/>">
	 <ww:iterator value="getListSub(id)" id="listServiceItems">
	<li id="<ww:property value="id"/>"><ww:if test="code.indexOf('http:')!=-1">
									<a href="<ww:property value="code.trim()"/>" target="member" >
									<ww:property value="name" /></a>
									</ww:if><ww:else>
									<a href="#"  onclick="tobase('../<ww:property value="code.trim()"/>');">
									<ww:property value="name" /></a>
									</ww:else></li>
	</ww:iterator>
	
	</ul>
	</li>
</ww:iterator>	

	

	

	



</ul>


</div>

</div>

</body>
</html>
