<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="../css/left.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="../js/left.js"></script>

<title>Left</title>

</head>
<body leftmargin="0" topmargin="0">
<div
	style="margin-left: 10px; FONT: 9pt 宋体; border: 1px solid #99CBED; width: 186px; height: 99%;">
<!-- 1 -->
<table width="185" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" height="29" background="../images/jb.gif"
			style="border-bottom: 1px solid #99CBED"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;<strong
			style="color: #194B66">酒店管理</strong></span></td>
	</tr>
</table>
<ww:if test="hasACL('hotelinfo!action')==true">
	<TABLE cellSpacing=0 cellPadding=0 width=184 align=center>
		<TBODY>
			<TR style="CURSOR: hand">
				<TD class="menu_title" id="menuTitle101"
					onMouseOver="this.className='menu_title2';"
					onClick="menuChange(menu101,60,menuTitle101);"
					onMouseOut="this.className='menu_title';"
					background="../images/bj_jb1.gif" height=30><SPAN>
				<table cellspacing="0" cellpadding="0" height="30">
					<tr>
						<td></td>
						<td>&nbsp;<strong style="color: #194B66">酒店管理</strong></td>
					</tr>
				</table>
				</SPAN></TD>
			</TR>
			<TR>
				<TD>
				<DIV class=sec_menu id="menu101"
					style="DISPLAY: none; FILTER: alpha(Opacity = 100); WIDTH: 184px; HEIGHT: 0px">
				<TABLE style="POSITION: relative; TOP: 10px;" cellSpacing=0
					cellPadding=0 width=120 align=center style=" color:#666666">
					<TBODY>
						<tr>
						<tr>
							<td height=20><a
								href="hotel.action?h_provinceId=-1&h_cityId=-1" target="main">酒店列表</a></td>
						</tr>
						<tr>
							<td height=20><a
								href="hotelprice.action?h_provinceId=-1&h_cityId=-1"
								target="main">价格维护</a></td>
						</tr>
						<tr>
							<td height=20><a
								href="hotel!toReaderExcel.action?h_provinceId=-1&h_cityId=-1"
								target="main">酒店导入</a></td>
						</tr>
					</TBODY>
				</TABLE>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</ww:if> <ww:if test="hasACL('privece!action')==true">
	<TABLE cellSpacing=0 cellPadding=0 width=184 align=center>
		<TBODY>
			<TR style="CURSOR: hand">
				<TD class="menu_title" id="menuTitle102"
					onMouseOver="this.className='menu_title2';"
					onClick="menuChange(menu102,100,menuTitle102);"
					onMouseOut="this.className='menu_title';"
					background="../images/bj_jb1.gif" height=30><SPAN>
				<table cellspacing="0" cellpadding="0" height="30">
					<tr>
						<td></td>
						<td>&nbsp;<strong style="color: #194B66">区域管理</strong></td>
					</tr>
				</table>
				</SPAN></TD>
			</TR>
			<TR>
				<TD>
				<DIV class=sec_menu id="menu102"
					style="DISPLAY: none; FILTER: alpha(Opacity = 100); WIDTH: 184px; HEIGHT: 0px">
				<TABLE style="POSITION: relative; TOP: 10px;" cellSpacing=0
					cellPadding=0 width=120 align=center style=" color:#666666">
					<TBODY>
						<tr>
							<td height="20"><a href="province.action" target="main">省份列表</a></td>
						</tr>
						<tr>
							<td height="20"><a href="city.action" target="main">城市列表</a></td>
						</tr>
						<tr>
							<td height="20"><a href="landmark.action" target="main">地标列表</a></td>
						</tr>
						<tr>
							<td height="20"><a href="region.action" target="main">酒店区域维护</a></td>
						</tr>
					</TBODY>
				</TABLE>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</ww:if> <ww:if test="hasACL('hotelorder!action')==true">

	<TABLE cellSpacing=0 cellPadding=0 width=184 align=center>
		<TBODY>
			<TR style="CURSOR: hand">
				<TD class="menu_title" id="menuTitle103"
					onMouseOver="this.className='menu_title2';"
					onClick="menuChange(menu103,60,menuTitle103);"
					onMouseOut="this.className='menu_title';"
					background="../images/bj_jb1.gif" height=30><SPAN>
				<table cellspacing="0" cellpadding="0" height="30">
					<tr>
						<td></td>
						<td>&nbsp;<strong style="color: #194B66">订单管理</strong></td>
					</tr>
				</table>
				</SPAN></TD>
			</TR>
			<TR>
				<TD>
				<DIV class=sec_menu id="menu103"
					style="DISPLAY: none; FILTER: alpha(Opacity = 100); WIDTH: 184px; HEIGHT: 0px">
				<TABLE style="POSITION: relative; TOP: 10px;" cellSpacing=0
					cellPadding=0 width=120 align=center style=" color:#666666">
					<TBODY>
						<tr>
							<td height="20"><a href="top_main.jsp" target="main">订单中心</a></td>
						</tr>

					</TBODY>
				</TABLE>
				</DIV>
				</TD>
			</TR>
		</TBODY>
	</TABLE>

</ww:if>


<TABLE cellSpacing=0 cellPadding=0 width=184 align=center>
	<TBODY>
		<TR style="CURSOR: hand">
			<TD class="menu_title" id="menuTitle104"
				onMouseOver="this.className='menu_title2';"
				onClick="menuChange(menu104,100,menuTitle104);"
				onMouseOut="this.className='menu_title';"
				background="../images/bj_jb1.gif" height=30><SPAN>
			<table cellspacing="0" cellpadding="0" height="30">
				<tr>
					<td></td>
					<td>&nbsp;<strong style="color: #194B66">酒店预订</strong></td>
				</tr>
			</table>
			</SPAN></TD>
		</TR>
		<TR>
			<TD>
			<DIV class=sec_menu id="menu104"
				style="DISPLAY: none; FILTER: alpha(Opacity = 100); WIDTH: 184px; HEIGHT: 0px">
			<TABLE style="POSITION: relative; TOP: 10px;" cellSpacing=0
				cellPadding=0 width=120 align=center style=" color:#666666">
				<TBODY>
					<tr>
						<td height="20"><a href="hotelsubscribe.action" target="main">酒店查询</a></td>
					</tr>
					<tr>
						<td height="20"><a href="hotelordersearch.action"
							target="main">订单查询</a></td>
					</tr>
				</TBODY>
			</TABLE>
			</DIV>
			</TD>
		</TR>


	</TBODY>
</TABLE>





</div>
</body>
</html>




