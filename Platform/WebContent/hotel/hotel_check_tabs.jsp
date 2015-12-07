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
<title>酒店审核</title>
<link href="../css/base.css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
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
		href="hotelbasicinfo!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>基本信息审核</span></a></li>
	<li><a
		href="hotelcontract!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>合同审核</span></a></li>
	<li><a
		href="roomtype!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房型审核</span></a></li>
	<li><a
		href="roomstate!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房态审核</span></a></li>
	<li><a
		href="hotelspec!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>注意事项审核</span></a></li>
	<li><a
		href="hotellandmark!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>地标审核</span></a></li>
	<li><a
		href="hotellinkman!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>联系人审核</span></a></li>
	<li><a
		href="hotelimage!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>图片审核</span></a></li>
	
	<li><a
		href="hotelstate!tocheck.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>状态审核</span></a></li>
		<%
			if("to_shows".equals(tabtype)){
		%>
			<li><a
	 	 		href="hotel!toCheckShow.action?hotelprice.hotelid=<ww:property value="hotelprice.hotelid"/>&hotel.name=<ww:property value="hotel.name"/>&hotelprice.roomid=<ww:property value="hotelprice.roomid"/>&hotelprice.datenumber=<ww:property value="hotelprice.datenumber"/>&hotelId=<ww:property value="hotelprice.hotelid"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>价格审核</span></a></li>
		<%		
			}else{
		%>
			<li><a
	 	 		href="hotel!getAllpricebyidCheck.action?hotelprice.hotelid=<ww:property value="hotelId"/>&hotel.name=<ww:property value="hotel.name"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>价格审核</span></a></li>
			
		<%
			}
		%>		
			
	 	
</ul>
</div>
 
<div align=center>
<form method="post" name="form1" action="hotel!hotelCheck.action">
<table>
	 			<tr  class="font-blue-xi">
					<td height="28" align="right"><span class="STYLE2">审核意见：</span></td>
					<td>
						<textarea name="checkdesc" cols="50" rows="5"><ww:property value="hotel.checkdesc" /></textarea>
						<input type="hidden" value="<ww:property value="hotel.id"/>" name="id"/>
						<input type="hidden" value="0" name="state" id="state"/>
					</td>
				</tr>
				
				<tr class="font-blue-xi">
					<td height="46" align="center" colspan="2">
						<input type="submit" class="button_d font-white"	 value=" 审核通过 " onclick="document.getElementById('state').value='3'" />
						<input type="submit" class="button_d font-white"  value=" 审核驳回 " onclick="document.getElementById('state').value='0'"  />
					</td>
				</tr>
</table>
</form>
</div>
</body>
</html>