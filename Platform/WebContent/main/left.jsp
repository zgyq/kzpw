<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—商旅平台</title>
<link href="images/css1/left_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
</head>
<SCRIPT language=JavaScript>

$(document).ready(function (){
	  $("TABLE[id*='submenu']").each(function(i){
	 // alert(i);
	  	eval("submenu" + (i+1) + ".style.display=\"none\";");
	  });
	  
	  eval("submenu1.style.display=\"\";");
});



function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
function tobase(ba){
//alert(ba);
//var nobsae=atob(ba);
//alert(nobsae);
 parent.member.location.href=ba;
}
</SCRIPT>
<body bgcolor="16ACFF">
<table width="98%" border="0" cellpadding="0" cellspacing="0"
	background="images/tablemde.jpg">
	<tr>
		<td height="5" background="images/tableline_top.jpg" bgcolor="#16ACFF"></td>
	</tr>
	
	<ww:iterator value="listRoot" status="kk">
	<tr>
		<td>
		<TABLE width="97%" border=0 align=right cellPadding=0 cellSpacing=0
			class=leftframetable>
			<TBODY>
				<ww:if test="#kk.index==0">
				<TR>
					<TD height="25"
						style="background: url(images/left_tt.gif) no-repeat">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<TD width="20"></TD>
							<TD class=STYLE1 style="CURSOR: hand;color: red;" height=25><b><ww:property  value="getsysrightname(rightid)"/></b></TD>
						</tr>
					</table>
					</TD>
				</TR>
				</ww:if>
				
				<TR>
					<TD height="25"
						style="background: url(images/left_tt.gif) no-repeat">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<TD width="20"></TD>
							<TD class=STYLE1 style="CURSOR: hand" onclick=showsubmenu('<ww:property value="(#kk.index)+1"/>');
								height=25><ww:property   value="name"/></TD>
						</tr>
					</table>
					</TD>
				</TR>
				<TR>
					<TD>
					<TABLE id="submenu<ww:property value="(#kk.index)+1"/>" cellSpacing=0 cellPadding=0 width="100%"
						border=0>
						<TBODY>
						<ww:iterator value="getListSub(id)" id="listServiceItems">
							
							
								<!--<TR id="<ww:property value="id"/>">
									<TD width="2%"><IMG src="images/closed.gif"></TD>
									<TD height=23>
									<ww:if test="id==10764">
									<a href="<ww:property value="code.trim()"/>" target="member"  class="lib">
									<ww:property value="name" /></a>
									</ww:if><ww:elseif test="id==10652||id==10781||id==10762">
									<a href="<ww:property value="code.trim()"/>" target="member"  class="lib">
									<ww:property value="name" /></a>
									</ww:elseif><ww:else>
									<a href="#"   class="lib" onclick="tobase('../<ww:property value="code.trim()"/>');">
									<ww:property value="name" /></a>
									</ww:else>
									</TD>
								</TR>
						-->
						<TR id="<ww:property value="id"/>">
									<TD width="2%"><IMG src="images/closed.gif"></TD>
									<TD height=23>
									<ww:if test="code.indexOf('http:')!=-1">
									<a href="<ww:property value="code.trim()"/>" target="member"  class="lib">
									<ww:property value="name" /></a>
									</ww:if><ww:else>
									<a href="#"   class="lib" onclick="tobase('../<ww:property value="code.trim()"/>');">
									<ww:property value="name" /></a>
									</ww:else>
									</TD>
								</TR>
						</ww:iterator>
							
						</TBODY>
					</TABLE>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		</td>
	</tr>
	</ww:iterator>
	<tr>
		<td height="5" background="images/tableline_top.jpg" bgcolor="#9BC2ED"></td>
	</tr>
	<tr>
		<td height="8">

		<TABLE class=leftframetable cellSpacing=1 cellPadding=1 width="97%"
			align=right border=0>
			<TBODY>
				<TR>
					<TD height="25"
						style="background: url(images/left_tt.gif) no-repeat">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<TD width="20"></TD>
							<TD class=STYLE1 height=25>支付宝信息</TD>
						</tr>
					</table>
					</TD>
				</TR>
				<TR>
				
					<TD height=75><span class="STYLE2">
					<!--
					<a href="https://www.99bill.com/" target="_blank"  style="border:0px solid #000"><img style="border:0px solid #000" src="../images/kuaiqianlogo.jpg" width="140px;" height="40px;" /></a>
					-->
					<a href="https://www.tenpay.com/v2/" target="_blank"  style="border:0px solid #000"><img style="border:0px solid #000" src="../images/cft.jpg" width="140px;" height="40px;" /></a>
					</br>
					<a href="https://lab.alipay.com/user/reg/index.htm" target="_blank"  style="border:0px solid #000"><img style="border:0px solid #000" src="../images/alipayregist.gif" width="140px;" height="40px;" /></a>
					</br>
					<a href="http://www.chinapnr.com/" target="_blank"  style="border:0px solid #000"><img style="border:0px solid #000" src="../images/huifutianxia.jpg" width="140px;" height="40px;" /></a>
					</br>
					<a href="http://pos.hzht888.com:880/pos/index.aspx" target="_blank"  style="border:0px solid #000"><img style="border:0px solid #000" src="../images/pos.jpg" width="140px;" height="40px;" /></a>
					</br>
					<a href="../customeragent!ShowAgentinfo.action" target="member">B2B支付商圈签约</a>
					</span></TD>
				</TR>
			</TBODY>
		</TABLE>
		</td>
	</tr>
	
	
		<tr>
		<td height="5" background="images/tableline_top.jpg" bgcolor="#9BC2ED"></td>
	</tr>
	<ww:if test="getLoginsessionagent().agenttype==1">
	<tr>
		<td height="8">

		<TABLE class=leftframetable cellSpacing=1 cellPadding=1 width="97%"
			align=right border=0>
			<TBODY>
				<TR>
					<TD height="25"
						style="background: url(images/left_tt.gif) no-repeat">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<TD width="20"></TD>
							<TD class=STYLE1 height=25>航空公司信息</TD>
						</tr>
					</table>
					</TD>
				</TR>
				<TR>
					<TD height=105><span class="STYLE2">
					<IMG src="../images/airComlogo/CA.gif"><a target="_blank" href="http://www.airchina.com.cn/cn/contact_us/hotline.shtml">中国国际航空</a><br>
					<IMG src="../images/airComlogo/CZ.gif"><a target="_blank" href="http://www.csair.com/cn/contact/static/service.shtml">中国南方航空</a><br>
					<IMG src="../images/airComlogo/MU.gif"><a target="_blank" href="http://www.ceair.com/mu/main/qtxx/cjwt/index.html">中国东方航空</a><br>
					<IMG src="../images/airComlogo/KN.gif"><a target="_blank" href="http://www.ceair.com/mu/main/lh/index.html">联合航空</a><br>
					<IMG src="../images/airComlogo/HU.gif"><a target="_blank" href="http://www.hnair.com/gyhh/lxhh/index.html">海南航空</a><br>
					<IMG src="../images/airComlogo/MF.gif"><a target="_blank" href="http://www.xiamenair.com/cn/cn/info/contactus.shtml">厦门航空</a><br>
					<IMG src="../images/airComlogo/ZH.gif"><a target="_blank" href="http://www.shenzhenair.com/module/about/about_9.jsp">深圳航空</a>
					</span></TD>
				</TR>
			</TBODY>
		</TABLE>
		</td>
	</tr>
	</ww:if>
	<tr style="display: none">
		<td height="8">

		<TABLE class=leftframetable cellSpacing=1 cellPadding=1 width="97%"
			align=right border=0>
			<TBODY>
				<TR>
					<TD height="25"
						style="background: url(images/left_tt.gif) no-repeat">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<TD width="20"></TD>
							<TD class=STYLE1 height=25>系统信息</TD>
						</tr>
					</table>
					</TD>
				</TR>
				<TR>
					<TD height=105><span class="STYLE2"><IMG
						src="images/closed.gif">版权所有：北京允风文化<br>
					<IMG src="images/closed.gif">设计制作：北京允风文化<br>
					<IMG src="images/closed.gif">技术支持：<a
						href="#" target="_blank">北京允风文化</a><br>
					<IMG src="images/closed.gif">帮助中心：<a
						href="#" target="_blank">北京允风文化</a><br>
					<IMG src="images/closed.gif">系统版本：1.0</span></TD>
				</TR>
			</TBODY>
		</TABLE>
		</td>
	</tr>
	
	
	<tr>
		<td height="5" background="images/tableline_bottom.jpg"></td>
	</tr>
	<tr align="center">
		<td height="5" align="center"><IMG src="images/hangxin.gif"></td>
	</tr>
</table>
</body>
</html>
