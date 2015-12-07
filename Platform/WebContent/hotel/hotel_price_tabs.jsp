<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page isELIgnored="false" %>
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
<title>酒店价格维护</title>
  <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
 <link href="../css/base.css" rel="stylesheet"/>
 <link rel="stylesheet" href="../js/tabs/jquery.tabs.css" type="text/css" />
 <script src="../js/tabs/jquery-1.1.3.1.pack.js" type="text/javascript"></script>
 <script src="../js/tabs/jquery.history_remote.pack.js" type="text/javascript"></script>
 <script src="../js/tabs/jquery.tabs.pack.js" type="text/javascript"></script>

<script type="text/javascript">
			<%
				String selectFlag =request.getParameter("flag");
			%>
            $(
            function(){
            	$('#container-1').tabs(${param.remotetabs},{remote:true,bookmarkable:false});
            }) ;
            
  </script>

</head>

<body>
<div id="container-1">
<ul>
	<li><a
		href="hotelprice!getAllpricebyid.action?hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/>&hotelprice.roomid=<ww:property value="hotelprice.roomid"/>&hotelName=<ww:property value="hotelName"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格列表</span></a></li>
	<li><a
		href="hotelprice!toadd.action?hotelName=<ww:property value="hotelName"/>& hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/> & hotelprice.roomid=<ww:property value="hotelprice.roomid"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格录入</span></a></li>
	<%
			if("toedit".equals(selectFlag)){
	%>
				<li><a
					href="hotelprice!query.action?hotelName=<ww:property value="hotelName"/>& hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/> & hotelprice.roomid=<ww:property value="hotelprice.roomid"/>& hotelprice.datenumber=<ww:property value="hotelprice.datenumber"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格修改</span></a></li>
	<%
			}else{
	%>
			<li><a
				href="hotelprice!edit.action?hotelName=<ww:property value="hotelName"/>& hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/> & hotelprice.roomid=<ww:property value="hotelprice.roomid"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格修改</span></a></li>	
	<%		
		}	
	%>
	<li><a
		href="hotelprice!tobatchlock.action?hotelName=<ww:property value="hotelName"/>& hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/> & hotelprice.roomid=<ww:property value="hotelprice.roomid"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格禁用</span></a></li>
	<li><a
		href="hotelprice!toqiyong.action?hotelName=<ww:property value="hotelName"/>& hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/> & hotelprice.roomid=<ww:property value="hotelprice.roomid"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格启用</span></a></li>
	<li><a
		href="hotelprice!toyanqi.action?hotelName=<ww:property value="hotelName"/>& hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/> & hotelprice.roomid=<ww:property value="hotelprice.roomid"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格延期</span></a></li>
	<%
			if("backShow".equals(selectFlag)){
	%>
				<li><a
					href="hotelprice!priceQuery.action?hotelName=<ww:property value="hotelName"/>& hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/> & hotelprice.roomid=<ww:property value="hotelprice.roomid"/>& hotelprice.datenumber=<ww:property value="hotelprice.datenumber"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格查询</span></a></li>
	<%			
			}else{
	%>
				<li><a
					href="hotelprice!toShow.action?hotelName=<ww:property value="hotelName"/>& hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/> & hotelprice.roomid=<ww:property value="hotelprice.roomid"/>& hotelprice.datenumber=<ww:property value="hotelprice.datenumber"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>酒店价格查询</span></a></li>
	<%
		}
	%>	
</ul>
</div>
<div align=center>
</div>
</body>
</html>