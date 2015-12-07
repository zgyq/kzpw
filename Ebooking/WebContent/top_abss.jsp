<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!-- 头部开始-->
<style>
body {
    color: #2B2B2B;
    font: 12px/1.5 Arial,"宋体";
	margin: 0;
    padding: 0;
}

html, body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, input, textarea, p, label, blockquote, th, td, button, span {
    margin: 0;
    padding: 0;
}


.layout {
    margin: 0 auto;
	position: relative;
    text-align: center;
    width: 1204px;
}



.layout .logo {
    background: url("top_abss/images/top_logo.png") no-repeat scroll 0 0 rgba(0, 0, 0, 0);
    display: block;
    float: left;
    height: 65px;
    outline: medium none;
    text-align: center;
    text-indent: -9999px;
    width: 220px;
}

ol, ul {
    list-style: none outside none;
}


.nav_abss {
    background: none repeat scroll 0 0 #B91313;
    clear: both;
    height: 40px;
    position: relative;
    text-align: center;
    z-index: 100;
}

.nav_abss li {
    float: left;
    height: 28px;
    padding-top: 12px;
    position: relative;
}

.nav_abss .layout li a {
    border-left: 1px solid #B91313;
    border-right: 1px solid #CD5A5A;
    color: #FFFFFF;
    font-size: 12px;
    font-weight: bold;
    height: 16px;
    line-height: 16px;
    padding: 0 22px;
	text-decoration: none;
}

#mainNav {
    position: relative;
    z-index: 3;
}


</style>

<div class="" align="left">
  <img src="top_abss/images/top_logo_abss.png"  />
  
  <!--
  <a href="http://www.abss.com.cn/" class="logo">爱不释手</a>
   <img src="top_abss/images/top_logo.png" class="logo" />
	-->
</div>
<div class="nav_abss" id="nav">
  <!-- 主导航开始 -->
  <div class="layout">
    <ul id="mainNav">
    
      <li class='noMore'><a href="http://abss.com.cn/">首页</a></li>
	  
	  <li class="noMore"><a href="<%=request.getContextPath()%>/ticticket!toTicket.jspx">国内机票</a></li>      
      
      <li class="noMore"><a href="<%=request.getContextPath()%>/international!toInterNational.jspx">国际机票</a></li>
      
      <li class="noMore"><a href="<%=request.getContextPath()%>/hotel!toindex.jspx">国内酒店</a></li>
      
      <li class="noMore"><a href="http://abss.com.cn/a/lunwen/">论文发表</a></li>
      
      <li class="noMore"><a href="http://abss.com.cn/a/xiezuo/">写作指导</a></li>
      
      <li class="noMore"><a href="http://abss.com.cn/a/yushou/">预售图书</a></li>
      
      <li class="noMore"><a href="http://abss.com.cn/a/yuancheng/">远程教育</a></li>

      <li class="noMore"><a href="http://abss.com.cn/a/kaoyan/">文都考研</a></li>
       
      <li class="noMore"><a href="http://abss.com.cn/a/xinshu/">新书推荐</a></li>
        
      <li class="noMore">
      <a href="http://abss.com.cn/a/lianxi/">联系我们</a> 
      </li>
    </ul>
  </div>
  <!--主导航结束-->
</div>
<!--头部结束-->
