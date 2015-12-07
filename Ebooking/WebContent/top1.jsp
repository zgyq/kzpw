<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
String type = request.getParameter("type");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="tttCssJs/base.css">
<link type="text/css" rel="stylesheet" href="tttCssJs/index.css">
<style type="">
#product {  
    width:720px;  
    height:200px;  
    border:1px solid #ccc;  
    margin:0 5px 5px 0;  
    float:left;  
}  
#product div#content {  
    position:relative;  
    width:690px;  
    height:160px;  
    display:inline-block;  
    overflow:hidden;  
    float:left;  
}  
#product div#content_list {  
    position:absolute;  
    width:4000px;  
}  
#product dl{  
    width:160px;  
    height:150px;  
    float:left;  
    margin:10px 4px;  
    padding:2px 2px;  
}  
#product dl:hover {  
    border:1px solid #333;  
    background:#ccc;  
}  
#product dl dt {  
      
}  
#product dl dt img {  
    width:160px;  
    height:120px;  
    border:none;  
}  
#product dl dd {  
    text-align:center;  
}  
#product span.prev{  
    cursor:pointer;  
    display:inline-block;  
    width:15px;  
    height:150px;  
    background:url(../images/arrow_l.gif) no-repeat left center;  
    float:left;  
}  
#product span.next{  
    cursor:pointer;  
    display:inline-block;  
    width:15px;  
    height:150px;  
    background:url(../images/arrow_r.gif) no-repeat left center;  
    float:right;  
} 

</style>
</head>

<body  style="margin: 0px;">



<div style="width:80%;height=90%;position:absolute;z-index:9999;padding-left:100px;">
		<img src="images/gd_logo.png"   height="74" width="140" border=0>
</div>
<div style="width:80%;height=80%;position:absolute;z-index:9999;padding-left:350px;">
	<span style="color: red"><h3>&nbsp;</h3></span>
</div>



<div class="toper" style="padding-left:250px;">
    <ul>
    <li class="f nav_toper">
    	<a href="ticticket!toTicket.jspx">
    		<img src="tttimages/nav_index.png" height="24" >
    	</a>
    </li>
    <li class="f nav_shu">
    	<img src="tttimages/nav_shu.png" height="24" width="2">
    </li>
    
    <!-- 国内 -->
    <li class="f nav_toper">
    	<a href="ticticket!toTicket.jspx">
    		<img src="tttimages/nav_air.png" height="24" >
    	</a>
    </li>
    
    <li class="f nav_shu">
    	<img src="tttimages/nav_shu.png" height="24" width="2">
    </li>
    
    <!-- 国际 -->
    <li class="f nav_toper">
	    <a href="international!toInterNational.jspx">
	    	<img src="tttimages/nav_interair.png" height="24" >
	    </a>
    </li>
    <li class="f nav_shu">
    	<img src="tttimages/nav_shu.png" height="24" width="2">
    </li>
    
    <!-- 酒店 hotel!toindex.jspx -->
    <li class="f nav_toper">
	    <a href="hotel!toindex.jspx">
	    	<img src="tttimages/nav_hotel.png" height="24" >
	   	</a>
    </li>
    <li class="f nav_shu">
    	<img src="tttimages/nav_shu.png" height="24" width="2">
    </li>
    
    <!-- 帮主中心 -->
    <!--<li class="f nav_toper">
	    <a href="index!tohelp.jspx">
	    	<img src="tttimages/nav_news.png" height="24" >
	    </a>
    </li>
    
    <li class="f nav_shu">
    	<img src="tttimages/nav_shu.png" height="24" width="2">
    </li>
    --><li class="f nav_toper">
	    <a href="index!toabout.jspx">
	    	<img src="tttimages/nav_about.png" height="24" >
	    </a>
    </li>
     <li class="f nav_shu">
    	<img src="tttimages/nav_shu.png" height="24" width="2">
    </li>
    
    <li class="f nav_toper">
    	<a href="login!toMyCenter.jspx">
    		<img src="tttimages/nav_my.png" height="24" >
    	</a>
    </li>
    </ul>
</div>
<!--<ww:include page="qq.html" />
--></body>
</html>
