<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="js/jquery1.3.2.js" type=text/javascript></script>
</head>
<body>
	
		<table>
		
			<tr><td>所有业务</td></tr>
			<ww:iterator value="listbussiness">
				<tr><td><input type="radio"  name="red" value="<ww:property value="id"/>" name="jiamengshang" /><ww:property value="name"/></td></tr>
			</ww:iterator>
			<tr><td><input type="button" value="留点设置" onclick="checkLiuDian();"/></td></tr>
		</table>
	
</body>
</html>
<script type="text/javascript">
function checkLiuDian(){
//1,国内机票 2,国际机票 3,国内酒店 4,国际酒店 5,充值  7,租车 8,旅游
$("input:radio").each(function(){
  if(this.checked){
 
 var ty=this.value;
 if(ty=='1'){
 window.location.href="liudianinfo!toadd.action?lagentid=<ww:property value="lagentid"/>";
 }
 if(ty=='3'){
 window.location.href="starsettlementtype!toAgentType.action?lagentid=<ww:property value="lagentid"/>";
 } 
  
  }
  
}); 

}

</script>