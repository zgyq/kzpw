<%@ page contentType="text/html; charset=utf-8"%>
<%
String outurl="";
outurl = request.getParameter("outurl");
outurl="http://www.12306.cn/mormhweb/kyfw/lcskbcx/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title></title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/index.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
</head>

<body>
<iframe src="<%= outurl%>"   id="iframepage" name="iframepage" frameBorder=0 scrolling=no width="100%" height="9000px;"  ></iframe>
</body>
</html>
