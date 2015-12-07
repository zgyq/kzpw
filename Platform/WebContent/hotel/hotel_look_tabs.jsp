<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%/**
			 * 版权所有, 允风文化
			 * Author: 允风文化 项目开发组
			 * copyright: 2009
			 *
			 *
			 *  HISTORY
			 *  
			 *  2009/08/14 创建
			 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店信息查看</title>
<link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
<script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="../js/ext-all.js"></script>
<link href="../css/base.css" rel="stylesheet" />
<link rel="stylesheet" href="../js/tabs/jquery.tabs.css" type="text/css" />
<script src="../js/tabs/jquery-1.1.3.1.pack.js" type="text/javascript"></script>
<script src="../js/tabs/jquery.history_remote.pack.js" type="text/javascript"></script>
<script src="../js/tabs/jquery.tabs.pack.js" type="text/javascript"></script>

<script type="text/javascript">
      <%

					String remotetabs = request.getParameter("remotetabs");
					String tabtype = request.getParameter("tabtype");
					if(remotetabs == null || remotetabs.trim().length() == 0) {
						remotetabs = "1" ;
					}
					if("pricelist".equals(tabtype)) {
						remotetabs = "10" ;
					}

					request.setAttribute("remotetabs", remotetabs) ;
%>
 			 $(function() {
            	$('#container-1').tabs(${requestScope.remotetabs},{ remote:true, bookmarkable:false});
            }) ;
            
  </script>

</head>

<body>
<div id="container-1">
<ul>
	<li><a
		href="hotelbasicinfo!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>基本信息查看</span></a></li>
	<li><a
		href="hotelcontract!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>合同查看</span></a></li>
	<li><a
		href="roomtype!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房型查看</span></a></li>
	<li><a
		href="roomstate!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房态查看</span></a></li>
	<li><a
		href="hotelspec!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>注意事项查看</span></a></li>
	<li><a
		href="hotellandmark!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>地标查看</span></a></li>
	<li><a
		href="hotellinkman!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>联系人查看</span></a></li>
	<li><a
		href="hotelimage!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>图片查看</span></a></li>
	<li><a
		href="hotelstate!tolook.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>状态查看</span></a></li>
		<%
			if("to_shows".equals(tabtype)){
		%>
			<li><a
	 	 		href="hotel!toShow.action?hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/>&flag=look&hotel.name=<ww:property value="hotel.name"/>&hotelprice.roomid=<ww:property value="hotelprice.roomid"/>&hotelprice.datenumber=<ww:property value="hotelprice.datenumber"/>&hotelId=<ww:property value="hotelprice.hotelid"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>价格查看</span></a></li>
		<%		
			}else{
		%>
			<li><a
	 	 		href="hotel!getAllpricebyid.action?hotelprice.hotelid=<ww:property value="hotelId"/>&hotel.name=<ww:property value="hotel.name"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>价格查看</span></a></li>
			
		<%
			}
		%>	

</ul>
</div>
<div align=center>
<table>
	<tr class="font-blue-xi">
		<td height="54" rowspan="2"></td>
		<td height="46" scrolling="no"><input type="button" class="button_d font-white"
			onclick="window.location.href='hotel.action?<ww:property value="url"/>';" name="Submit2" value=" 取消返回 " /></td>
	</tr>
	<tr>
		<td height="17">&nbsp;</td>
	</tr>
</table>
</div>
</body>
</html>