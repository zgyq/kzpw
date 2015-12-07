<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

</head>

<frameset rows="*" cols="202,6,*" framespacing="0" frameborder="0" border="false" id="frame" scrolling="no">

  <frame name="left" scrolling="no" marginwidth="0" frameborder="0" marginheight="0" src="customeruser!leftmenu.action?rightid=<ww:property value="rightid"/>&forward=left.jsp "  style="margin-left:10px;" />
    <frame name="middle" scrolling="no" frameborder="0" noresize="noresize" src="middle.jsp" />
  <frame name="member" scrolling="auto" frameborder="0" noresize="noresize" src="<%=request.getContextPath()%>/<ww:if test='#session.ListAgid!=10033 && #session.ListAgid!=10032'>login!towelcome.action</ww:if><ww:else>attendrecord.action</ww:else>" />
</frameset>
<noframes><body>
</body>
</noframes></html>

<!--<%=request.getContextPath()%>/<ww:if test='#session.ListAgid!=10033 && #session.ListAgid!=10032'>login!towelcome.action</ww:if><ww:else>attendrecord.action</ww:else>-->