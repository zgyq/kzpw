<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/left_n.css" type="text/css" rel="stylesheet" />
<link href="css/public.css" type="text/css" rel="stylesheet" />
</head>

<body > 
<div id="right">
<div  class="lit">
  <ul>
   <li class="on"><a href="right.jsp">欢迎到来</a></li>
   <li class="off"><a href="<%=request.getContextPath()%>/<ww:if test='#session.ListAgid!=10033 && #session.ListAgid!=10032'>login!towelcome.action</ww:if><ww:else>attendrecord.action</ww:else>">快速导航</a></li>
   <!-- -->
   <li class="offd"><a href="welcome_f.jsp"> 查看返利</a></li>
   <li><img src="imagess/jiao.gif" width="8" height="28" /></li>
   <li style="float:right" class="mr11"><img src="imagess/houtui.gif" width="59" height="23" class="mr8" /><input type=button value="" class="button_shuaxin" onclick="window.parent['mainFrame'].location.reload()"></li>
  </ul>
</div>
<div lang="ca" class="kuang box"><img src="imagess/ad.gif" width="804" height="443" /></div>
</div>
</body>
</html>
