<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-资讯中心</title>
<!--<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/help.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
-->
<ww:head name="help"/>
</head>
<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>
<script>
//展开第一项
var index=<ww:property value="Informationid"/>;
$(document).ready(function (){
	if(index=='0'){
	//alert("..");
	//	$("#help1").addClass('open');
 	//	$("#nhelp1").show();
	}
		
});
var size=<ww:property value="ListInformation.size"/>

function check(index){

	for(i=1;i<=size;i++){
		//控制关和
		 $("#help"+i).removeClass('open');
		 $("#help"+i).removeClass('close');
		 $("#help"+i).addClass('close');
		 
		 //控制下级显示
		  $("#nhelp"+i).hide();
		 
		 
		 
		 
		 
		 
	}
 		$("#help"+index).addClass('open');
 		$("#nhelp"+index).show();
}

</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=5" />
		
	</div>
	<!--top over-->
<div id="help">
   <div id="help_left" class="f mt10">
   
     <div class="helptitle">
      <span class="why f" style=" padding-left:15px;"></span><font class="fff14" style=" color:#000">资讯中心</font>
     </div>
     <div class="box" style=" border-top:none; border-color:#ccc;">
        <ul>
         <%int j = 1; int i = 1;%>
        <ww:iterator value="ListInformation" status="t">
      <!-- index!toInformationType.jspx?HelpcenterID=<ww:property value="id"/> -->
        <li   <ww:if test="Informationid==id">class="open"</ww:if><ww:else>class="close"</ww:else>  id='help<%=i%>'
        onclick="check(<%=i%>)">  <a href="#"><ww:property value="name"/></a></li>
         <!-- onclick="onloadcss(<%=i%>)" -->
       <ww:if test="getInformationLastById(id).size>0">
		        <li class="box_over" id="nhelp<%=i%>"  <ww:if test="Informationid==id">style='display: block;'</ww:if><ww:else>style='display: none;'</ww:else> >
		        <dl class="openlist">
			        <ww:iterator value="getInformationLastById(id)">
			       <a href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="id"/>"><dt class="list"><ww:property value="name"/></dt></a>
			        </ww:iterator>
		        </dl>
		        </li>
	        </ww:if>
	        <%i++;%>
        </ww:iterator>
       
        </ul>
     </div>
   
   </div>
   
   
	<div id="help_right" class="r mt7">
   	<!--
		<form action="index!toInformationinfo.jspx" method="post">
			<div class="searh">
			<ul>
			<li>
			 <input name="s_name" type="text" class="searh_text mr25" value="<ww:property value="s_name"/>" />
			 <input type="submit" class="searh_bnt fff14" value="立即搜索"  />
			</li>
			<li class="dd2626 searhtips"><span class="wenhao f">&nbsp;</span><font class="f pt5" >热门问题：如何注册，如何买票，签证常识...</font></li>
			</ul>
      </div>
      <input name="HelpcenterID" type="hidden" class="searh_text mr25"   value="<ww:property value="HelpcenterID"/>" />
      
     </form>
      -->
      <ww:if test="isindex==1">
      	
	       <div class="msg helpmap mt3">
	        <ul>
	          <li><font class="mlr10 f90c">如何注册</font><img src="images/helpmapone.jpg" width="652" height="42" /></li>
	          <li class="mt10"><font class="mlr10 c09f">如何买票</font><img src="images/helpmaptwo.jpg" width="652" height="42" /></li>
	        </ul>
	      </div>
	      <div class="msg helpmain mt10" style=" border:1px solid #ccc;">
	        <div class="msgul">
	                <ul class="f helpmainleft">
	                <li class="msgul box_over pf5 f00"><ww:property value="ListHelpcenterIndex.get(0).name"/></li>
	                <ww:iterator value="GetInformInfoById(ListHelpcenterIndex.get(0).id,4)">
	                <a href="index!toinformationinfoByInfoId.jspx?HelpcenterinfoID=<ww:property value="id"/>">
	                <li title="<ww:property value="name"/>"><span class="ico_bollow mlr10"></span>
	                <ww:if test="name.length()>20"><ww:property value="SubString(name,18)"/>...</ww:if><ww:else><ww:property value="name"/></ww:else></li></a> 
	                </ww:iterator> 
	                </ul>
	                <ul class="r helpmainright">
	                <li class="msgul box_over pf5 f00"><ww:property value="ListHelpcenterIndex.get(1).name"/></li>
	                <ww:iterator value="GetInformInfoById(ListHelpcenterIndex.get(1).id,4)">
	                <a href="index!toinformationinfoByInfoId.jspx?HelpcenterinfoID=<ww:property value="id"/>">
	                <li title="<ww:property value="name"/>"><span class="ico_green mlr10"></span><ww:if test="name.length()>20"><ww:property value="SubString(name,18)"/>...</ww:if><ww:else><ww:property value="name"/></ww:else></li>
	                </a>
	                </ww:iterator>
	                </ul>
	            <div class="c"></div>
	         </div>  
	      </div>
	      <div class="box helpmain mt10">
	         <ul class="helptips">
	          <li class="box_over pf5"><font class="l06c mr15"><ww:property value="ListHelpcenterIndex.get(2).name"/></font><span class="ico"></span></li>
	          <li>
	            <ul class="f ">
	             <ww:iterator value="GetInformInfoById(ListHelpcenterIndex.get(2).id,8)" status="ind">
	                 <a href="index!toinformationinfoByInfoId.jspx?HelpcenterinfoID=<ww:property value="id"/>">
	                <li title="<ww:property value="name"/>"><span class="ico_bollow mlr10"></span><ww:if test="name.length()>20"><ww:property value="SubString(name,18)"/>...</ww:if><ww:else><ww:property value="name"/></ww:else></li></a> 
	                <ww:if test="#ind.index==3">
	                </ul>
	                <ul class="r helpmainright">
	                </ww:if>
	               
	             </ww:iterator>   
	                </ul>
	            <div class="c"></div>
	            </li>
	         </ul> 
	      </div>
	      
      </ww:if><ww:else>
      
   
      <div class="msg helpmain mt10">
        <ul class="msgul">
              <li class="box_over pf5 helptips">
              <font class="l06c"><ww:property value="onename"/></font><font class="mlr">></font>
              <font class="l06c"><ww:property value="twoname"/></font><font class="mlr">></font>
              <font class="un000"><ww:property value="threename"/></font>
              </li>
              <li class="helptips">
                 <ol class="mainol">
                  <ww:iterator value="ListInformationinfo" status="ind">
                  <li><a href="javascript:change(<ww:property value="#ind.index+1"/>);"><ww:property value="name"/></a>
                   <dt class="msg" style="display: none;" id="msg<ww:property value="#ind.index+1"/>"><ww:property value="info"/></dt>
                  </li>
                  </ww:iterator>
              
                 </ol> 
              </li>
         </ul>  
      </div>
      </ww:else>
   </div>
   <div class="nohave"></div>
</div>
<ww:include page="../footer.jsp"/> 
</body>
</html>
<script>
<ww:if test="type==0">
function change(index){
var siz=0;
siz=<ww:property value="ListInformationinfo.size"/>;
for(i=1;i<=siz;i++){
$("#msg"+i).hide();
}
$("#msg"+index).show();
}
<ww:if test="number>0">
change(<ww:property value="number"/>);
</ww:if>
</ww:if>
</script>