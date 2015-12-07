<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="js/city-control/citycontrol.css" rel="stylesheet" />
<link href="js/city-control/base.css" rel="stylesheet" />
<body>
						<div id="city">
									<div class="city-top" ><font class="fff">热门城市</font></div>
									<div class="city-box"> 
									<ul id="mt5" class="">
								    <li class="f city-navon"><a href="#">热门</a></li>
								    <li class="f city-nav"><a href="#" onclick="sub('A-F');">A-F</a></li>
								   	<li class="f city-nav"><a href="#" onclick="sub('G-J');">G-J</a></li>
								   	<li class="f city-nav"><a href="#" onclick="sub('K-N');">K-N</a></li>
								    <li class="f city-nav"><a href="#" onclick="sub('P-W');">P-W</a></li>
								    <li class="f city-nav"><a href="#" onclick="sub('X-Z');">X-Z</a></li>
								  	<li class="f city-nav-right"><a href="javascript:void(0);">&nbsp;</a></li>
								    <div class="c"></div></ul>
								    
								    <div class="mt5 c" >
								    <ul class="mt5">
								    <ww:iterator value="listCityairport">
								     <li class="f cityon" rel="1"><a href="#" onclick="lodvalue('<ww:property value="cityname"/>','<ww:property value="airportcode"/>');"><ww:property value="cityname"/></a></li>
								    </ww:iterator>
								   
								         
								    <li class="c nohave">&nbsp;</li>
								  
								    </ul>
								    </div>
								    </div>
								   </div>
</body>
</html>

<script type="text/javascript" language="javascript">
  function sub(ty){
 //  alert(ty);     
         
	 }

</script>