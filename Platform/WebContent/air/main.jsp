<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎页面</title>
</head>

<frameset rows="*" cols="198,15,*" framespacing="0" frameborder="0" border="false" id="frame" scrolling="no">
  <frame name="left" scrolling="no" marginwidth="0" marginheight="0" src="../left_air.jsp" style="margin-left:10px;" />
    <frame name="middle" scrolling="no" noresize="noresize" src="../middle.jsp" />
  <frame name="main" scrolling="yes" noresize="noresize" src="<%=request.getContextPath() %>/login!towelcome.action" />
</frameset>
<noframes><body>
</body>
</noframes></html>