<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.yf.system.base.sysmessage.Sysmessage"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统首页</title>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<link href="images/css.css" rel="stylesheet" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript">
$(document).ready(function(){
$(".msg").hide();
$("#table1").show();
});

function changeMsg(id){
$(".msg").hide();
$(".tdclass").attr("style","background: url(images/newmainimg/ggg2.jpg) no-repeat; cursor: pointer");
$("#td"+id).removeAttr("style");
$("#td"+id).attr("style","background: url(images/newmainimg/gg2.gif) no-repeat; cursor: pointer");
$("#table"+id).show();
}
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box" height="100%">
	<tr>

		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;</span></b></td>

	</tr>
	<tr>
		<td valign="top">

<form action="attendrecord!addReasonInfo.action" name="form2">
<div >


<table style="width:100%; background: url('images/bj_wel.gif');" border=0 cellspacing=0 cellpadding=0>

	<tbody>
		
		<tr>
		    <Td width="73" > <img src="images/bj_left_w.gif" width="73" height="350"></Td>
			<td valign=top align=left width="70%" style="background:url('images/bj_neird.gif'); background-position: 0px -1px;"  >
			<table border=0 cellspacing=0 cellpadding=0 width=100% >
				<tbody>
					<tr>
						<td height=35 valign=bottom align=middle>
						<table border=0 cellspacing=0 cellpadding=0 width=100% >
							<tbody>
								<tr>
									<td width=22>&nbsp;</td>
									<td valign=bottom width=72>
									<table border=0 cellspacing=0 cellpadding=0 width=72 >
										<tbody>
											<tr>
												<td 
													style="background: url(images/newmainimg/gg2.gif) no-repeat; cursor: pointer"
													id="td1" class="a01 tdclass" height=29 align=middle onclick="changeMsg('1')"><span
													id=lbtype0>东航通知</span></td>
											</tr>
										</tbody>
									</table>
									</td>
									<td >&nbsp;</td>
									<td 
										style="background: url(images/newmainimg/ggg2.jpg) no-repeat; cursor: pointer"
										id="td2" class="style1 tdclass" width=73 align=middle onclick="changeMsg('2')"><span
										id=lbtype1>国航公告</span></td>
									<td >&nbsp;</td>
									<td  
										style="background: url(images/newmainimg/ggg2.jpg) no-repeat; cursor: pointer"
										id="td3" class="style1 tdclass" width=73 align=middle onclick="changeMsg('3')"><span
										id=lbtype2>南航公告</span></td>
									<td>&nbsp;</td>
									<td 
										style="background: url(images/newmainimg/ggg2.jpg) no-repeat; cursor: pointer"
										id="td4" class="style1 tdclass" width=72 align=middle onclick="changeMsg('4')"><span
										id=lbtype3>海航公告</span></td>
									<td >&nbsp;</td>
									<td 
										style="background: url(images/newmainimg/ggg2.jpg) no-repeat; cursor: pointer"
										id="td5" class="style1 tdclass" width=72 align=middle onclick="changeMsg('5')">其他公告</td>
									<td >&nbsp;</td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td  style="background: url('images/bj_neir.gif') no-repeat;" id=td
							height=222 align=right>
						<table border=0 cellspacing=0 cellpadding=0 width=100%>
							<tbody>
								<tr>
									<td rowspan=2 width=100% align=left>
									<%Map<String,Sysmessage> messageMap=(Map<String,Sysmessage>)session.getAttribute("messageMap");
									for(int i=0;i<=messageMap.size();i++){
										String type=String.valueOf(i+1);
										Sysmessage message=messageMap.get(type);
										if(message==null){
											continue;
										}
								%>
									
									<div  class="msg" style=" padding:20px; height:275px; overflow: hidden"
										id="table<%=type%>" align=center>
									<table border=0 cellspacing=0 cellpadding=0 width=100%>
										<tbody>
											<tr>
												<td class=xian8 height=22 align=middle>
												<table border=0 cellspacing=0 cellpadding=0 width="95%">
													<tbody>
														<tr>
															<td class=hong height=19 valign=bottom align=left><span
																id=lbtitle0><%=message.getTitle() %></span></td>
															<td class=hui valign=bottom align=right>发布日期：<span
																id=lbtime0><%=(message.getCreatetime()).toString().substring(0,10)%></span></td>
														</tr>
													</tbody>
												</table>
												</td>
											</tr>
											<tr>
												<td class=wen1 height=150 align=left>
												<table>
													<tbody>
														<tr>
															<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
																id=lbcontent0>
																<%=message.getContent() %>
																</span>
															</td>
														</tr>
													</tbody>
												</table>
											  </td>
											</tr>
										</tbody>
									</table>
									</div>
							
										<%}
									
									%>
									
									</td>
									<td height=76 valign=top width=1 align=middle></td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
				</tbody>
			</table>
			</td>
			<td style="background: url('images/bj_rig.gif') no-repeat;">&nbsp;</td>
			</tr>
		<tr>
		    
			<td id=showleft  valign=top align=middle colspan="3">
			<table style="width:94%;" border=0 cellspacing=0
				cellpadding=0 >
				<tbody>
				<tr>
				<td width="73">&nbsp;</td>
				<td >
										<span id=span1>
							<ww:if test="#session.ListAgid.indexOf('10037')>=0">
								<a href="login!remaveorderuser.action?urlaction=airsearch.action&&">
								<img src="images/changwei.gif" border="none" width="81" height="89" />
								</a>
							</ww:if>
							<ww:else>
							   <a href="b2bairsearch.action">
								<img src="images/changwei.gif" width="81" height="89" />
								</a>
							</ww:else>
							</span>
				</td>
				<td>
				<span id=span2><a href="orderinfo!topnrnav.action"><img src="images/chuangjian.gif" width="81"  border="none"  height="89" /></a></span>
				</td>
				
				<ww:if test="#session.ListAgid.indexOf('10037')>=0">
				<td>
				<!--<span id=span3><a href="teamapply.action"><img src="images/tuandui.gif" width="81"  border="none"  height="89" /></a></span>
				 -->
				</td>
				<td><!-- <span id=span4><a href="/pay/alipay.jsp"><img src="images/zhuanzhang.gif" width="81"  border="none"  height="89" /></a></span>
				 --></td>
				</ww:if>
				<td><span id=span5><a href="insuranceinfo.action"><img src="images/baoxian.gif" width="81"  border="none"  height="89" /></a></span>
				</td>
				<td width="22%">&nbsp;</td>
				</tr>
				</tbody>
			</table>
			</td>
			
		</tr>
		
		<tr>
			<td align=middle colspan="3"><input id=hddnusername value=shangjinshangwu
				type=hidden></td>
		</tr>
	</tbody>
</table>


</div>
</form>
</td></tr></table></div>
</body>
</html>
