<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>
<script>
//展开第一项
$(document).ready(function (){
		$("#help1").addClass('open');
 		$("#nhelp1").show();
});
var size=<ww:property value="ListHelpcenter.size"/>

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
<%
String ty = request.getParameter("ty");
%>

  <div class="helptitle">
      <span class="why f"></span><font class="fff14">帮助中心</font>
     </div>
     <div class="box">
  
        <ul>
       
       
         
         
         <%int j = 1; int i = 1;%>
        <ww:iterator value="ListHelpcenter">
        <li class="close" id='help<%=i%>'
        onclick="check(<%=i%>)"><ww:property value="name"/></li>
       
        	<ww:if test="GetHelpLastById(id).size>0">
		        <li class="box_over" id="nhelp<%=i%>" onclick="onloadcss(<%=i%>)" style="display: none;">
		        <dl class="openlist">
			        <ww:iterator value="GetHelpLastById(id)">
			       <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="id"/>"><dt class="list"><ww:property value="name"/></dt></a>
			        </ww:iterator>
		        </dl>
		        </li>
	        </ww:if>
	        <%i++;%>
        </ww:iterator>
       
        
        </ul>
     </div>