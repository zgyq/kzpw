<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ taglib uri="b2b2c" prefix="bb"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">  
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title></title>

<%

String s_city = request.getParameter("s_city") ;
if(s_city != null) {
	s_city = new String(s_city.getBytes("8859_1"), "GB2312") ;
} else { 
	s_city = "" ;
}

String hotelname = request.getParameter("hotelname") ;
//out.print("hotelname=="+hotelname);
if(hotelname != null) {
	hotelname = new String(hotelname.getBytes("8859_1"), "UTF-8") ;
} else {
	hotelname = "" ;
}

String hoteltell = request.getParameter("hoteltell") ;
if(hoteltell != null) {
	hoteltell = new String(hoteltell.getBytes("8859_1"), "UTF-8") ;
} else {
	hoteltell = "" ;
}

String hotelfax = request.getParameter("hotelfax") ;
if(hotelfax != null) {
	hotelfax = new String(hotelfax.getBytes("8859_1"), "UTF-8") ;
} else {
	hotelfax = "" ;
}

String re = request.getParameter("re") ;
if(re != null) {
	re = new String(re.getBytes("8859_1"), "UTF-8") ;
} else {
	re = "" ;
}

%>



<script type="text/javascript"
	src="http://www.google.com/jsapi?key=ABQIAAAA-hlIK-xFOiG9gdHAQlM94xS8b-Hjy0iGLrGYzal8Thsbw_smgBQGpkLVND_GbHkq8xYmj1av0Jqaqg"></script>

<script type="text/javascript">  

 	var lat = 0;
	var lng = 0;
	var hotelname = '<%=hotelname%>';
 	 
	var re='<%=re%>';
	var rs = re.split(',');

	lat =rs[0];
	lng=rs[1];
	
	google.load("maps", "2.x");     // Call this function when the page has been loaded 
	

	function initialize() {   
		



		var map = new google.maps.Map2(document.getElementById("map"));  
		map.setCenter(new google.maps.LatLng(lat,lng), 13); 

		    function createMarker(point, number) { 
          var marker = new GMarker(point); 
          marker.value = number; 
          GEvent.addListener(marker, "click", function() {
          //需要弹出的消息
   		 var myHtml =hotelname+'<br/>电话:<%=hoteltell%><br/>传真:<%=hotelfax%>'; 
            map.openInfoWindowHtml(point, myHtml); 
          }); 
          return marker; 
        }
        var bounds = map.getBounds(); 
        var southWest = bounds.getSouthWest(); 
        var northEast = bounds.getNorthEast(); 
        var lngSpan = northEast.lng() - southWest.lng(); 
        var latSpan = northEast.lat() - southWest.lat(); 
        var point=new GLatLng(lat,lng);
        map.addOverlay(createMarker(point,1));
       
		map.addControl(new GLargeMapControl());
      
        //为地图添加控件，如缩放，卫星地图转换
        map.addControl(new GLargeMapControl());
        var mapControl = new GMapTypeControl(); 
        map.addControl(mapControl); 

	} 
	google.setOnLoadCallback(initialize);

		

	</script>
</head>
<body onunload="GUnload()">

<div id="map" style="width: 500px; height: 300px"></div> 

</body>
</html>
