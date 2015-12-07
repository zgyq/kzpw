<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%/**
			 * 版权所有, 允风文化
			 * Author: 允风文化 项目开发组
			 * copyright: 2009
			 *  HISTORY
			 *  2009/08/14 创建
			 *
			 */
		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="hotel.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店</title>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
.spanwrong {
  height:23px; width:110px; border:#ffc4b3 1px solid; background:url(../images/wrorgt_icon.gif) #feebe6 4px -36px no-repeat; display:inline-block; line-height:23px; padding:0 5px 0 25px; overflow:hidden; color:#f00;
}
.spanright {
  height:25px; width:16px; border:#ccc 0px solid; background:url(../images/wrorgt_icon.gif) 0 2px no-repeat; display:inline-block; line-height:23px; padding:0 5px 0 25px; overflow:hidden;
}
</style>
 <link href="../css/base.css" rel="stylesheet"/>
<script src="../js/money.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
<script type="text/javascript" src="../js/jquery1.3.2.js"></script>
</head>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="hotelbasicinfo!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
	<ww:if test="hotel.contryid==168 || hotel.countryid==168">
	<body onload="checkcity(1)">
	</ww:if>
	<ww:else>
	<body  onload="checkcity(2)">	
	</ww:else>	
<form
	action="hotelbasicinfo!edit.action?id=<ww:property value="hotel.id"/>"
	name="form1" method="post">
<input type="hidden" name="hotelId"
	value="<ww:property value="hotel.id"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="left" style="border:1px solid #99CBED; margin-bottom:4px;">
	<!--<tr>
			 <td width="100%" height="29" class="box-bottom bg" ><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="hotel.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店00<ww:property value='hotel.getProvinceid()'/></span></td>
	</tr>
	-->
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="hotel.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店基本信息</span>
		<span
			style="display: block; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 396px;">
			<tr style="display:none">
				<ww:if test="hotel.id>0||hotel.language>0">
				<!--  
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="hotel.ucode"/>,0)" <ww:if test="hotel.language==0">class="add"</ww:if>><img
					src="../images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a></td>
				<td width="20%"><a href="#" onclick="addlanguage(<ww:property value="hotel.ucode"/>,1)" <ww:if test="hotel.language==1">class="add"</ww:if>><img src="../images/fan.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">繁体</a></td>
				<td width="25%"><a href="#" onclick="addlanguage(<ww:property value="hotel.ucode"/>,2)" <ww:if test="hotel.language==2">class="add"</ww:if>><img src="../images/ri.gif"
					width="27px" height="26px;" align="absmiddle"
					style="margin-right: 15px;">日语</a></td>
				<td><a href="#" onclick="addlanguage(<ww:property value="hotel.ucode"/>,3)" <ww:if test="hotel.language==3">class="add"</ww:if>><img src="../images/yin.gif" width="27px"
					height="26px;" align="absmiddle" style="margin-right: 15px;">EINGLISH</a>&nbsp;&nbsp;</td>
				-->
				</ww:if>
				<ww:else>
				<td width="100%" align="right"><a href="#" class="add"><img
					src="../images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		</table>
		
		</span></td>
	</tr>
	<!-- 支持多语言结束 -->
	
	
	<tr>
		<td height="100%">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
			<td align=left>
			<table width="98%" border=0 cellPadding=0 cellSpacing=0 bgcolor="#000000">
				<tbody>
					<tr>
						<td align="center" bgcolor="#FFFFFF"><b>酒店基本信息</b></td>
					</tr>
				</tbody>
			</table>
			<table cellspacing=0 cellpadding=0 width="100%" border=0>
				<tbody>
					<tr>
						<td class=main_lbg height=16>&nbsp;</td>
						<td align="left" colspan=4>
						<table id=right_main cellspacing=0 cellpadding=0 width="87%"
							border=0>
							<tbody>
								<tr>
									<td>
									<table class=mk cellspacing=2 cellpadding=0 width="100%"
										border=0>
										<tbody>
											<tr>
												<td align=left bgcolor="#a0cfee" class=rbgt>&nbsp;&nbsp;<b>酒店信息</b></td>
											</tr>
											<tr>
												<td id=Td1 align="left">
												<table class=main_lanpan cellspacing=0 cellpadding=0
													width="99%" border=0>
													<tbody>
														<tr>
															<td>
															<DIV style="TEXT-ALIGN: center">
															<table width="91%" border=0 cellpadding=0 cellspacing=0
																style="WIDTH: 100%">
																<tbody>
																	<tr>
																		<td style="HEIGHT: 20px" valign=center align=right
																			colspan=6>&nbsp;</td>
																	</tr>
																	<TR>
																		<TD width="11%" align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right">中文名称：<SPAN
																			id=Label2 style="COLOR: #ff8080">*</SPAN></TD>
																		<TD id="nametd" width="14%" align=left><INPUT
																			id="name" name="name" require="true"
																			dataType="Require" msg="洒店名称不能为空"
																			style="WIDTH: 120px"
																			value='<ww:property value="hotel.name"/>'/><span id="LabePP" style="color: #ff8080"></span></TD>
																		<TD width="11%" align=left style="TEXT-ALIGN: right">英文名称：</TD>
																		<TD width="19%" align=left><input id="enname"
																			style="WIDTH: 120px" name="enname"
																			value='<ww:property value="hotel.enname"/>'/></TD>
																		<TD width="9%" align=left style="TEXT-ALIGN: right">酒店简拼：<SPAN
																			id=Label7 style="COLOR: #ff8080">*</SPAN></TD>
																		<TD width="36%" align=left><INPUT id=jpname
																			style="WIDTH: 120px" require="true"
																			dataType="Require" msg="简拼不能为空" name="jpname"
																			value='<ww:property value="hotel.jpname"/>'><span id="jp" style="color: #ff8080"></span></TD>
																	</TR>
																	<tr><td height="5px"></td></tr>
																	<tr>
																		<TD align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right">酒店星级：<SPAN id=Label3 style="COLOR: #ff8080">*</SPAN></TD>
																		<TD align=left><SELECT id="ddlStars" style="WIDTH: 125px" name="star">
																			<option value="" <ww:if test="hotel.star==''">selected="selected"</ww:if>>--未选择--</option>
																			<OPTION value="1" <ww:if test="hotel.star==1">selected="selected"</ww:if>>经济型</OPTION>
																			<OPTION value="2" <ww:if test="hotel.star==2">selected="selected"</ww:if>>准二星</OPTION>
																			<OPTION value="3" <ww:if test="hotel.star==3">selected="selected"</ww:if>>二星级</OPTION>
																			<OPTION value="4" <ww:if test="hotel.star==4">selected="selected"</ww:if>>准三星</OPTION>
																			<OPTION value="5" <ww:if test="hotel.star==5">selected="selected"</ww:if>>三星级</OPTION>
																			<OPTION value="6" <ww:if test="hotel.star==6">selected="selected"</ww:if>>准四星</OPTION>
																			<OPTION value="7" <ww:if test="hotel.star==7">selected="selected"</ww:if>>四星级</OPTION>
																			<OPTION value="8" <ww:if test="hotel.star==8">selected="selected"</ww:if>>准五星</OPTION>
																			<OPTION value="9" <ww:if test="hotel.star==9">selected="selected"</ww:if>>五星级</OPTION>

																		</SELECT><span id="starspan" style="color: #ff8080"></span></TD>

																		<td style="TEXT-ALIGN: right" align=left>推荐级别：</td>
																		<td align=left><SELECT id=ddlLevel
																			style="WIDTH: 125px" name="hot"
																			value="<ww:property value="hotel.hot"/>">
																			<OPTION value=""
																				<ww:if test="hotel.hot==''">selected="selected"</ww:if>>--未选择--</OPTION>
																			<OPTION value="1"
																				<ww:if test="hotel.hot==1">selected="selected"</ww:if>>特级主推</OPTION>
																			<OPTION value="2"
																				<ww:if test="hotel.hot==2">selected="selected"</ww:if>>金牌主推</OPTION>
																			<OPTION value="3"
																				<ww:if test="hotel.hot==3">selected="selected"</ww:if>>暂时主推</OPTION>
																			<OPTION value="4"
																				<ww:if test="hotel.hot==4">selected="selected"</ww:if>>一级主推</OPTION>
																			<OPTION value="5"
																				<ww:if test="hotel.hot==5">selected="selected"</ww:if>>零级主推</OPTION>
																			<OPTION value="6"
																				<ww:if test="hotel.hot==6">selected="selected"</ww:if>>问题酒店</OPTION>
																		</SELECT></td>

																		<td style="TEXT-ALIGN: right" align=left>酒店起价:<SPAN
																			id=Label2 style="color: #ff8080">*</SPAN></td>
																		<td align=left><input id="startprice"
																			style="WIDTH: 120px" name="startprice"
																			value='<ww:property value="hotel.startprice"/>'
																			" msg="酒店起价不能为空"><span id="prc" style="color: #ff8080"></span></td>
																	</tr>
																	<tr><td height="5px"></td></tr>
																	<tr>
																		<td align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right">酒店类型：</td>
																		<td style="HEIGHT: 30px" align=left><SELECT id=ddlType
																			style="WIDTH: 125px" name="type"
																			value="<ww:property value="hotel.type"/>">
																			<!-- 	<option value="" selected="selected">--未选择--</option>  -->

																			<!--<OPTION  selected="selected"><ww:property value="hotel.typeStr"/></OPTION>
																			-->
																			<OPTION value=""
																				<ww:if test="hotel.type==''">selected="selected"</ww:if>>--未选择--</OPTION>
																			<OPTION value="1"
																				<ww:if test="hotel.type==1">selected="selected"</ww:if>>公寓式</OPTION>
																			<OPTION value="2"
																				<ww:if test="hotel.type==2">selected="selected"</ww:if>>会议型</OPTION>
																			<OPTION value="3"
																				<ww:if test="hotel.type==3">selected="selected"</ww:if>>度假型</OPTION>
																			<OPTION value="4"
																				<ww:if test="hotel.type==4">selected="selected"</ww:if>>观光型</OPTION>
																			<OPTION value="5"
																				<ww:if test="hotel.type==5">selected="selected"</ww:if>>综合型</OPTION>
																			<OPTION value="6"
																				<ww:if test="hotel.type==6">selected="selected"</ww:if>>机场型</OPTION>
																			<OPTION value="7"
																				<ww:if test="hotel.type==7">selected="selected"</ww:if>>别墅型</OPTION>
																			<OPTION value="8"
																				<ww:if test="hotel.type==8">selected="selected"</ww:if>>商务型</OPTION>
																		</SELECT></td>
																		<td style="HEIGHT: 30px; TEXT-ALIGN: right" align=left>房间总数：</td>
																		<td style="HEIGHT: 30px" align=left><input
																			id=txtRoomNum style="WIDTH: 120px" name=rooms
																			value="<ww:property value="hotel.rooms"/>"
																			require="true" dataType="Require" msg="房间不能为空"></td>
																		<td style="HEIGHT: 30px; TEXT-ALIGN: right" align=left>装修级别：</td>
																		<td style="HEIGHT: 30px" align=left><SELECT
																			id=ddlRepair style="WIDTH: 125px" name="repair"
																			value="<ww:property value="hotel.repair"/>">

																			<OPTION value=""
																				<ww:if test="hotel.repair==''">selected="selected"</ww:if>>--未选择--</OPTION>
																			<OPTION value="1"
																				<ww:if test="hotel.repair==1">selected="selected"</ww:if>>豪华</OPTION>
																			<OPTION value="2"
																				<ww:if test="hotel.repair==2">selected="selected"</ww:if>>高档</OPTION>
																			<OPTION value="3"
																				<ww:if test="hotel.repair==3">selected="selected"</ww:if>>舒适</OPTION>
																			<OPTION value="4"
																				<ww:if test="hotel.repair==4">selected="selected"</ww:if>>经济</OPTION>
																		</SELECT></td>
																	</tr>
																	<tr><td height="5px"></td></tr>
																	<tr>
																		<td align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right">开业时间：<SPAN
																			id=Label6 style="COLOR: #ff8080">*</SPAN></td>
																		<td align=left><input id="Open" style="WIDTH: 120px"
																			name="opendateStr" require="true" dataType="Require"
																			msg="洒店开业时间不能为空"
																			value="<ww:property value="opendateStr"/>"
																			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /><span id="opentime"
																				style="color: #ff8080"></span></td>
																		<td style="TEXT-ALIGN: right" align=left>装修时间：<SPAN
																			id=Label2 style="COLOR: #ff8080">*</SPAN></td>
																		<td align=left><input id="Repair" style="WIDTH: 120px"
																			name="repaildate"
																			value="<ww:property value="hotel.repaildate"/>"
																			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /><span id="retime"
																				style="color: #ff8080"></span></td>
																		<td style="TEXT-ALIGN: right" align=left>日审类型：</td>
																		<td align=left><input type="radio" value="1"
																			name="websign"
																			<ww:if test="hotel.checktype==1||hotel.paytype==null">checked="checked"</ww:if> />日审<input
																			type="radio" value="2" name="websign"
																			<ww:if test="hotel.checktype==2">checked="checked"</ww:if> />夜审</td>
																	</tr>
																	<tr><td height="5px"></td></tr>
																	<tr>
																		
																		<td style="TEXT-ALIGN: right" align=left>主楼层数：<SPAN
																			id=Label2 style="COLOR: #ff8080">*</SPAN></td>
																		<td align=left><input id=txtMain style="WIDTH: 120px"
																			name=mainlevel
																			value="<ww:property value="hotel.mainlevel"/>" />层&nbsp;<span
																				id="mai" style="color: #ff8080"></span></td>
																		<td style="TEXT-ALIGN: right" align=left>附楼层数：</td>
																		<td align=left><input id=txtNoMain
																			style="WIDTH: 120px" name=appendlever
																			value="<ww:property value="hotel.appendlever"/>" />层</td>
																			
																		<td style="text-align: right" align=left>支付类型：</td>
																			<td align=left>
																			<input id=IsNet type=radio <ww:if test="hotel.paytype==1||hotel.paytype==null">checked="checked"</ww:if> value="1" name="paytype"  /> 现付
																			<input id=NoNet type=radio <ww:if test="hotel.paytype==2">checked="checked"</ww:if> value="2" name="paytype" />预付</td>
																			<td align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right"></td>
																		<td align=left></td>
																	</tr>
																	<tr>
																		
																		<td style="TEXT-ALIGN: right" align=left>返现方式：<SPAN
																			id=Label2 style="COLOR: #ff8080"></SPAN></td>
																		<td align=left>
																		<input type="radio" value="1" disabled="disabled"  name="meneyback"/>现返
																		<input type="radio" value="2" checked="checked"  name="meneyback"/>后返
																		</td>
																		<td style="TEXT-ALIGN: right" align=left>返点方式：</td>
																		<td align=left>
																		<input type="radio" value="1" onclick="javascript:document.getElementById('rulesback').innerHTML='元';" disabled="disabled"   name="rebateway"/>金额
																		<input type="radio" value="2" onclick="javascript:document.getElementById('rulesback').innerHTML='%';" checked="checked"  name="rebateway"/>百分比
																		</td>
																		<td style="text-align: right" align=left>返点值：</td>
																			<td align=left><input style="WIDTH: 120px" id="rulesback" name=rulesback value="<ww:property value="hotel.rulesback"/>" /><span
																				>&nbsp;%</span></td>
																			<td align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right"></td>
																		<td align=left></td>
																	</tr>
																	<tr>
																		<td style="TEXT-ALIGN: right" align=left>酒店介绍：</td>
																		<td align=left colSpan=5><textarea id=txtDesc
																			style="WIDTH: 600px; HEIGHT: 75px" name=description><ww:property
																			value="hotel.description" /></textarea></td>
																	</tr>
																	<tr>
																		<td style="TEXT-ALIGN: right" align=left>预订要求：</td>
																		<td align=left colSpan=5><textarea id=txtBRequire
																			style="WIDTH: 600px; HEIGHT: 75px" name=prespec><ww:property
																			value="hotel.prespec" /></textarea></td>
																	</tr>
																	<tr>
																		<td style="TEXT-ALIGN: right" align=left>酒店卖点：</td>
																		<td align=left colSpan=5><textarea id=txtSellPoint
																			style="WIDTH: 600px; HEIGHT: 75px" name=sellpoint><ww:property
																			value="hotel.sellpoint" /></textarea></td>
																	</tr>

																</tbody>
															</table>
															</DIV>
															</td>
														</tr>
													</tbody>
												</table>
												</td>
											</tr>
										</tbody>
									</table>
									<BR>
									<table class=mk cellSpacing=2 cellPadding=0 width="100%"
										border=0>
										<tbody>
											<tr>
												<td width="927" align=left bgcolor="#a0cfee" class=rbgt
													style="WIDTH: 916px">&nbsp;&nbsp;<b>开户帐号</b></td>
											</tr>
											<tr>
												<td align=middle>
												<table class=main_lanpan cellSpacing=0 cellPadding=0
													width="99%" border=0>
													<tbody>
														<tr>
															<td>
															<DIV style="TEXT-ALIGN: center">
															<table style="WIDTH: 100%" cellSpacing=0 cellPadding=0
																border=0>
																<tbody>
																	<tr>
																		<td width="130" align=left
																			style="WIDTH: 105px; HEIGHT: 30px; TEXT-ALIGN: right">公司全称：</td>
																		<td width="917" colSpan=5 align=left
																			style="HEIGHT: 30px"><input id=txtFullName
																			" style="WIDTH: 237px" name=fullname
																			value="<ww:property value="hotel.fullname"/>"></td>
																	</tr>
																	<tr>
																		<td
																			style="WIDTH: 105px; HEIGHT: 30px; TEXT-ALIGN: right"
																			align=left>开户银行：</td>
																		<td align=left colSpan=5><input id="Kaccount"
																			style="WIDTH: 237px" name="openbank"
																			value="<ww:property value="hotel.openbank"/>" /></td>
																	</tr>
																	<tr>
																		<td style="WIDTH: 105px; TEXT-ALIGN: right" align=left>银行帐号：</td>
																		<td align=left colSpan=5><input id=ZhAccount
																			style="WIDTH: 237px" name="bankaccount"
																			value="<ww:property value="hotel.bankaccount"/>" /></td>
																	</tr>
																</tbody>
															</table>
															</DIV>
															</td>
														</tr>
													</tbody>
												</table>
												</td>
											</tr>
										</tbody>
									</table>
									<BR>
									<ww:if test="hotel.sourcetype==2">
									<table class=mk cellspacing=2 cellpadding=0 width="100%"
											border=0>
											<tbody>
												<tr>
													<td width="927" align=left bgcolor="#a0cfee" class=rbgt
														style="width: 916px">&nbsp;&nbsp;<b>签约经纪人</b></td>
												</tr>
												<tr>
													<td align=middle>
													<table class=main_lanpan cellspacing=0 cellpadding=0
														width="99%" border=0>
														<tbody>
															<tr>
																<td>
																<div style="text-align: center">
																<table style="width: 100%" cellspacing=0 cellpadding=0
																	border=0>
																	<tbody>
																		<tr>
																			<td width="130" align=left
																				style="width: 105px; height: 30px; text-align: right">经纪人：</td>
																			<td width="917" colspan=5 align=left
																				style="height: 30px">
																				<select id="h_ho" name="companyid">
								
																					
																					<ww:iterator value="listCustomeragent">
																					<option value="<ww:property value="id" />" <ww:if test="hotel.companyid==id">selected</ww:if> ><ww:property value="agentcompanyname" /></option>
																					 </ww:iterator>
												
																				</select>
																			</td>
																		</tr>
																		
																	</tbody>
																</table>
																</div>
																</td>
															</tr>
														</tbody>
													</table>
													</td>
												</tr>
											</tbody>
										</table>
								<br />
								</ww:if>
									<table class=mk cellSpacing=2 cellPadding=0 width="94%"
										border=0>
										<tbody>
											<tr>
												<td width="1041" align=left bgcolor="#a0cfee" class=rbgt
													style="WIDTH: 916px">
												<p>&nbsp;&nbsp;<b>地理位置信息</b></p>
												</td>
											</tr>
											<tr>
												<td align=left bgcolor="#FFFFFF" class=rbgt
													style="WIDTH: 967px">
												<table class=main_lanpan cellspacing=0 cellpadding=0 border="0">
													<tr><!--  
		<input type="radio" name="contryid" value="168"  checked="checked" <ww:if test="hotel.contryid==168 || hotel.countryid==168">checked</ww:if> onclick="checkcity(1)"/>国内
				<input type="radio" name="contryid" value="2" <ww:if test="hotel.contryid!=168 && hotel.countryid!=168">checked</ww:if> onclick="checkcity(2)"/>国际-->
															
														<td width="130" align=left
															style="WIDTH: 105px; HEIGHT: 30px; TEXT-ALIGN: right">酒店邮编：<span
															id="Label8" style="COLOR: #ff8080">*</span></td>
														<td width="189"><span style="HEIGHT: 30px"> <input
															id="txtPostCode" style="WIDTH: 120px" name="postcode"
															 datatype="Require" 
															value="<ww:property value="hotel.postcode"/>" /> </span><span id="pos"
																style="color: #ff8080"></span></td>
																
															
														<td width="133" align="right" id="chengshi1"><span
															style="HEIGHT: 30px; TEXT-ALIGN: right">省（区）：<ww:property value="hotel.provinceid"/></span><SPAN style="COLOR: #ff8080">*</SPAN></td>
														<td width="159" id="chengshi11"><span style="HEIGHT: 30px">
														 <select
															id="ddlProvince" style="WIDTH: 120px"
															onchange="hotel_find_cities(this.value)"
															name="provinceid">
															<option value="0" selected="selected">--未选择--</option>
															<ww:iterator value="listProvinces">
																	<option value='<ww:property value="id"/>' <ww:if test="hotel.provinceid==id"> selected="selected"</ww:if>><ww:property
																	value="name" /></option>
															</ww:iterator>
														</select> </span><span id="pro" style="color: #ff8080"></span></td>
														<td width="86" align="right" id="chengshi111"><span
															style="WIDTH: 89px; HEIGHT: 30px; TEXT-ALIGN: right">城 市：</span><SPAN
																			id=Label3 style="COLOR: #ff8080">*</SPAN></td>
														<td width="193" id="chengshi1111"><span style="HEIGHT: 30px"> <select
															id="ddlCity" style="WIDTH: 120px" name="cityid"
															onchange="getcitiesInfo()">
															<option value="<ww:property value="cityid"/>"><ww:property value="getcityNamebyId(hotel.cityid)"/></option>
														</select> </span></td>
														
														<!-- 	
													<td width="115" align="right" id="chengshi2" style="display: none;"><span
																style="width: 89px; height: 30px; text-align: right">国际城市：</span>
																<span id="provinces" style="color: #ff8080">*</span></td>
															<td width="238" id="chengshi22" style="display: none;"><span style="height: 30px"> 
															<select
																id="ddlCity2" style="width: 120px" name="cityid2"
																require="true" >
																<ww:iterator value="listinCities">
																<option value="<ww:property value="id" />" <ww:if test="hotel.cityid==id">selected="selected"</ww:if>><ww:property value="name" /></option>
																</ww:iterator>
															</select> </span></td> -->	
															
														
														
													</tr>
													<tr>
														<td height="29" align="right" nowrap="nowrap"><span
															style="HEIGHT: 30px; TEXT-ALIGN: right">行政区：</span></td>
														<td><select id="regionid1" style="WIDTH: 120px"
															name="regionid1">
															<option value="">--未选择--</option>
														</select></td>
														<td align="right"><span style="TEXT-ALIGN: right">商业区：</span></td>
														<td><select id="regionid2" style="WIDTH: 120px"
															name="regionid2">
															<option value="">--未选择--</option>
														</select></td>

														<td align="right">景区：</td>
														<td><select id="regionid3" style="WIDTH: 120px" name="regionid3">
															<option>-未选择--</option>
														</select></td>
													</tr>
													<tr>
														<td height="26" align="right" nowrap="nowrap"><span
															style="HEIGHT: 30px; TEXT-ALIGN: right">销售电话：</span></td>
														<td><input id="txtSellPhone" style="WIDTH: 120px"
															name="markettell"
															value="<ww:property value="hotel.markettell"/>"
															right="right"></td>
														<td align="right"><span style="TEXT-ALIGN: right">传 真：<span
															id="Label4" style="COLOR: #ff8080">*</span></span></td>
														<td align="left"><input id="txtFax2" style="WIDTH: 120px"
															name="fax1" value="<ww:property value="hotel.fax1"/>" /><span id="fax" style="color: #ff8080"></span></td>
														<td align="right"><span
															style="WIDTH: 89px; TEXT-ALIGN: right">总机电话：<span
															id="Label5" style="COLOR: #ff8080">*</span></span></td>
														<td><input id="txtTel" style="WIDTH: 120px" name="tortell"
															value="<ww:property value="hotel.tortell"/>"
															require="true" datatype="Require" msg="总机不能为空" /><span id="tor"
																style="color: #ff8080"></span></td>
													</tr>
													<tr>
														<td height="26" align="right" nowrap="nowrap"><span
															style="HEIGHT: 30px; TEXT-ALIGN: right">传真说明：</span></td>
														<td colspan="5"><span style="HEIGHT: 30px"> <input
															id="faxdesc" style="WIDTH: 600px" name="faxdesc"
															value="<ww:property value="hotel.faxdesc"/>" /> </span></td>
													</tr>
													<tr>
														<td height="26" align="right" nowrap="nowrap"><span
															style="HEIGHT: 30px; TEXT-ALIGN: right">详细地址：<span
															id="Label1" style="COLOR: #ff8080">*</span></span></td>
														<td colspan="5"><input id="txtAddr" style="WIDTH: 600px"
															name="address"
															value="<ww:property value="hotel.address"/>" /><span id="add"
																style="color: #ff8080"></span></td>
													</tr>
													<!-- added by sunb 2010-01-06 start 酒店经纬度-->
													<tr>
															<td height="26" align="right" nowrap="nowrap">酒店经度：</td>
															<td><input id="txtlng" style="width: 150px" name="lng" value="<ww:property value="hotel.lng"/>"/></td>
														    <td align="right">酒店纬度：</td>
															<td align="left"><input
																id="txtlat" style="width: 150px" name="lat" value="<ww:property value="hotel.lat"/>"/></td>

															<td colspan="2" align="left"><a href="#" onclick="javascript:window.open('http://www.playgoogle.com/googlemap/tool1.html')">点击查看经纬度查询网址</a></td>
														  <td></td>
													</tr>
													<!-- added by sunb 2010-01-06 end 酒店经纬度-->
													<tr>
														<td height="50" align="right" nowrap="nowrap">周边酒店：</td>
														<td colspan="5"><textarea id="txtNearHotel"
															style="WIDTH: 600px; HEIGHT: 40px" name="nearhotel"><ww:property
															value="hotel.nearhotel" />
                                                  </textarea></td>
													</tr>
													<tr>
														<td height="17" colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="COLOR: red">注：添加周边酒店时酒店名称间请用&quot;/&quot;隔开，如：酒店1/酒店2
														</span></td>
													</tr>
												</table>
												</td>
											</tr>
											<tr>
												<td  align=left bgcolor="#a0cfee" class=rbgt>&nbsp;&nbsp;<b>酒店附带设施</b></td>
											</tr>
											<tr>
												<td align=left bgcolor="#FFFFFF" class=rbgt style="WIDTH: 100%">
											
																		<table width="100%" class=main_lanpan cellspacing=0 cellpadding=0 border="0">
																			<tbody>
																				<tr>
																					<td width="15%" align=left
															style="HEIGHT: 30px; TEXT-ALIGN: right">可接受卡类型：</td>
																					<td width="85%" align=left vAlign=center>
																					<table  id=Card border=0>
																						<tbody>
																							<tr>
																								<ww:property value="getCardTypeHTML(hotel.carttype)" />
																							</tr>
																						</tbody>
																					</table>
																					</td>
																				</tr>
																				<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																				<tr>
																					<td style="TEXT-ALIGN: right" vAlign=center
																						align=left>宾馆服务项目：</td>
																					<!--<td align=left vAlign=center>
																					<table id=Item border=0>
																						<tbody>
																							<tr>
																							 <ww:property value="getServicItemHTML(hotel.serviceitem)" /> 
																							
																							</tr>
																						</tbody>
																					</table>
																					</td>
																				-->
																					<td align=left colSpan=5><textarea id=Item
																						style="WIDTH: 600px; HEIGHT: 65px"
																						name="serviceitem"><ww:property
																						value="hotel.serviceitem" /></textarea></td>
																				</tr>
																				<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																				<tr>
																					<td style="TEXT-ALIGN: right" vAlign=center
																						align=left>餐饮设施：</td>
																					<!--<td align=left vAlign=center>
																					<table id=cblFootSet border=0>
																						<tbody>
																							<tr>
																								<ww:property value="getEateryHTML(hotel.footitem)" />
																							
																							
																							</tr>
																						</tbody>
																					</table>
																					</td>
																				-->
																				<td align=left colSpan=5><textarea id=cblFootSet
																						style="WIDTH: 600px; HEIGHT: 65px"
																						name="footitem"><ww:property
																						value="hotel.footitem" /></textarea></td>
																				</tr>
																				<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																				<tr>
																					<td style="TEXT-ALIGN: right" vAlign=center
																						align=left>娱乐健身设施：</td>
																					<!--<td align=left vAlign=center>
																					<table id=cblPlay border=0 width="100%">
																						<tbody>
																							<tr>
																								<ww:property value="getPlayItemHTML(hotel.playitem)" />
																							
																							
																							</tr>
																						</tbody>
																					</table>
																					</td>
																				-->
																				<td align=left colSpan=5><textarea id=cblPlay
																						style="WIDTH: 600px; HEIGHT: 65px"
																						name="playitem"><ww:property
																						value="hotel.playitem" /></textarea></td>
																				</tr>
																				<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																				<tr>
																					<td style="TEXT-ALIGN: right" align=left>会议及其他设施：</td>
																					<td align=left colSpan=5><textarea id=txtSellPoint
																						style="WIDTH: 600px; HEIGHT: 65px"
																						name="meetingitem"><ww:property
																						value="hotel.meetingitem" /></textarea></td>
																				</tr>
						<!-- 支持多语言开始 替换对应的类名-->
			<ww:if test="hotel.language>0">
			<input id="language" type="hidden" name="language" value="<ww:property value="hotel.language"/>"/>
			</ww:if>
			<ww:else>
			<input id="language" type="hidden" name="language" value="0"/>
			</ww:else>
			<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="hotel.ucode"/>"/>
			<!-- 支持多语言结束 -->													
																				<tr class="font-blue-xi" >
																					<td height="54" rowspan="2" ></td>
																					<td height="46" scrolling="no" style="TEXT-ALIGN: center">
			<div style=" position: relative;">																		
																					<input type="submit"
																						class="button_d font-white" name="Submit1" onclick="return checkall()" value="提交" /> <input
																						type="button" class="button_d font-white"
																						onclick="window.location.href='hotel.action?<ww:property value="url"/>';"
																						name="Submit2" value=" 取消返回 " />
			<ww:iterator value="actionMessages">
					<div id="tishi" style=" position: absolute; top:-55px; left:0px; "><img src="../images/gg.png" width="149" height="60" /></div>
					<script type="text/javascript">
						setTimeout("showclose()",2000); 
						function showclose()
						{
							document.getElementById("tishi").style.display="none";
						}
					</script>
					</ww:iterator>
				</div>																	
																						
																						</td>
																				</tr>
																				
																				<tr>
																					<td height="17">&nbsp;</td>
																				</tr>
																			</tbody>
																		</table>
																	
												</td>
											</tr>
										</tbody>
									</table>
									</TD>
									</tr>
							</tbody>
						</table>
						</td>
					</tr>
				</tbody>
			</table>
			</td>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
<script language="javascript">
//checkcity(1);
	$().ready(function() {	
	//alert(<ww:property value='hotel.getProvinceid()'/>);
		$("#ddlProvince [value=<ww:property value='hotel.getProvinceid()'/>]").attr("selected","selected");
		
		//alert("#ddlProvince [value=<ww:property value='hotel.getProvinceid()'/>]");
		hotel_find_cities("<ww:property value='hotel.getProvinceid()'/>");
	});
	
	function checkall(){
	//document.form1.submit();
	//return;
	
	checkRulesback();
	
	
	checkjp();
	checkhotelname();
	starIsNull();
	startMoney();
	checkmai();
	opendate();
	repairtime();
	
	proIsNull();
	//checkfax();
	checkaddress();
	//checktortell();
	if(document.form1.name.value=='' || document.form1.jpname.value=='' || document.form1.startprice.value=='' || document.form1.opendateStr.value==''  || document.form1.fax1.value=='' ||
	document.form1.tortell.value=='' || document.form1.address.value==''|| document.form1.star.value=='' || document.form1.rulesback.value==''){
		return false;
	}else {
		
		document.form1.submit();
	}
	
}
////////////-----------验证返点值------------------------------------------------------

function checkRulesback(){

var txt = document.getElementById("rulesback").value;
var pattern=/^\+?[1-9][0-9]*$/; //只能输入数字
		if(txt==''){
		
			alert("返点值不能为空!!!");
			document.form1.rulesback.value="";
			
			return false;
			}else{
			
				if(!pattern.exec(txt))
				{
				//alert("只能输入非0正整数！");
				alert("返点值,请输入非0正整数!");
				document.form1.rulesback.value="";
				return false;
				}else{
		 			if(parseInt(txt)>=100){
			 			alert("返点值,请输入小于100的正整数!!");
			 			document.form1.rulesback.value="";
			 			return false;
		 			}
		 		
		 	}
	 	}
}
////-------------------------------------验证酒店名称是否重复--------------------------------------------------
	function checkhotelname(){
		var hotelName=document.getElementById("name").value;
		//var pattern=/^[\u4e00-\u9fa5]{0,}$/;//只能输入汉字
		if(hotelName.length==0){
		    document.getElementById("LabePP").innerHTML="<span class='spanwrong'>请输入酒店名称！</span>";
			$("#name").focus();
			return false;
		}
		else
		{
		   document.getElementById("LabePP").innerHTML="<span class='spanright'></span>";
		}
		
	}

////-------------------------------------验证酒店英文名称--------------------------------------------------	
	
	function checkenname() {
		var txt = document.form1.enname.value;
		var pattern=/^[a-z]+$/;		
		if(document.form1.enname.value==''){
		}else if(!pattern.exec(txt))
		{
		document.form1.enname.value="";
		document.getElementById("eme").innerHTML="<span class='spanwrong'>请输入字母！</span>";
		return false;
		}else{
        document.getElementById("eme").innerHTML="<span class='spanright'></span>";
 }

		
		}
		
		
////-------------------------------------验证酒店详细地址不能为空--------------------------------------------------		

function checkaddress(){
		if(document.form1.address.value==''){
		document.getElementById("add").innerHTML="<span class='spanwrong'>请输入详细地址！</span>";
		return false;
		}else{
  		document.getElementById("add").innerHTML="<span class='spanright'></span>";
 		 }
}
////-------------------------------------验证酒店起价不能为空--------------------------------------------------	
function startMoney(){
	if(document.form1.startprice.value==''){
		document.getElementById("prc").innerHTML="<span class='spanwrong'>请输入酒店起价！</span>";
	return false;
	}else{
		document.getElementById("prc").innerHTML="<span class='spanright'></span>";
	}

}			
		

////-------------------------------------验证酒店邮编--------------------------------------------------	

function checkpostcode(){

var txt = document.form1.postcode.value;
var pattern=/^[0-9]{6}$/;
if(document.form1.postcode.value==''){
		document.getElementById("pos").innerHTML="<span class='spanwrong'>请输入酒店邮编!</span>";
		return false;
		}else
		
		if(!pattern.exec(txt))
		{
		//alert("只能输入非0正整数！");
		document.form1.postcode.value="";
		document.getElementById("pos").innerHTML="<span class='spanwrong'>请输入正确的邮编！</span";
		return false;
		}else{
 
  document.getElementById("pos").innerHTML="<span class='spanright'></span>";
 }
}		
////-------------------------------------验证酒店主楼高度--------------------------------------------------

function checkmai(){

var txt = document.form1.mainlevel.value;
var pattern=/^\+?[1-9][0-9]*$/;//只能输入数字
if(document.form1.mainlevel.value==''){
	document.getElementById("mai").innerHTML="<span class='spanwrong'>请输入主楼层数！</span>";
		return false;
		}else
		
		if(!pattern.exec(txt))
		{
		//alert("只能输入非0正整数！");
		document.form1.mainlevel.value="";
		document.getElementById("mai").innerHTML="<span class='spanwrong'>请输入非0正整数!</span>";
		return false;
		}else{
 
  document.getElementById("mai").innerHTML="<span class='spanright'></span>";
 }
}	

////-------------------------------------验证酒店附楼高度--------------------------------------------------

function checkapp(){

var txt = document.form1.appendlever.value;
var pattern=/^\+?[1-9][0-9]*$/; //只能输入数字
if(document.form1.appendlever.value==''){
	
		//document.getElementById("app").innerHTML="不能为空!";
		
		}else
		
		if(!pattern.exec(txt))
		{
		//alert("只能输入非0正整数！");
		document.form1.appendlever.value="";
		document.getElementById("app").innerHTML="<span class='spanwrong'>请输入非0正整数!</span>";
		return false;
		}else{
 
  document.getElementById("app").innerHTML="<span class='spanright'></span>";
 }
}	

////-------------------------------------验证银行帐号--------------------------------------------------

function checkban(){

var txt = document.form1.bankaccount.value;
var pattern=/^\+?[1-9][0-9]*$/;//只能输入数字
if(document.form1.bankaccount.value==''){
		//alert("不能为空");
		}else
		
		if(!pattern.exec(txt))
		{
		//alert("只能输入非0正整数！");
		document.form1.bankaccount.value="";
		document.getElementById("ban").innerHTML="<span class='spanwrong'>请输入数字!</span>";
		return false;
		}else{
 
  document.getElementById("ban").innerHTML="<span class='spanright'></span>";
 }
}	

////-------------------------------------验证简拼--------------------------------------------------
function checkjp(){
var txt = document.form1.jpname.value;
var pattern=/^[a-z]+$/;
if(document.form1.jpname.value==''){
	document.getElementById("jp").innerHTML="<span class='spanwrong'>请输入酒店简拼！</span>";
	return false;
		}else
		
		if(!pattern.exec(txt))
		{
		
		document.form1.jpname.value="";
		document.getElementById("jp").innerHTML="只能输入对应字母！";
		return false;
		}else{
 
        document.getElementById("jp").innerHTML="<span class='spanright'></span>";
 	}
}	
////-------------------------------------限制字数--------------------------------------------------
 maxLength = 200; 
function MaxInput() {
if (document.form1.description.value.length > maxLength) 
document.form1.description.value = document.form1.description.value.substring(0, maxLength);
else document.form1.TLength.value = maxLength - document.form1.description.value.length;
}

////-------------------------------------验证时间是否为空--------------------------------------------------


function opendate(){
	if(document.form1.opendateStr.value==''){
		document.getElementById("opentime").innerHTML="<span class='spanwrong'>请输入开业时间！</span>";
		return false;
	}else{
		document.getElementById("opentime").innerHTML="<span class='spanright'></span>";
	}

}

function repairtime(){
	if(document.form1.repaildate.value==''){
		document.getElementById("retime").innerHTML="<span class='spanwrong'>请输入装修时间！</span>";
		return false;
	}else{
		document.getElementById("retime").innerHTML="<span class='spanright'></span>";
	}

}
////-------------------------------------验证省不能为空--------------------------------------------------
function proIsNull(){
	if(document.getElementById("ddlProvince").value<1){
		document.getElementById("pro").innerHTML="<span class='spanwrong'>请选择省份信息！</span>";
		return false;
		
	}else{
		document.getElementById("pro").innerHTML="<span class='spanright'></span>";
	}

}
////-------------------------------------验证星级不能为空--------------------------------------------------
function starIsNull(){
	if(document.getElementById("ddlStars").value<1){
		document.getElementById("starspan").innerHTML="<span class='spanwrong'>请选择酒店星级！</span>";
		return false;	
	}else{
		document.getElementById("starspan").innerHTML="<span class='spanright'></span>";
	}

}


////-------------------------------------验证传真--------------------------------------------------
	function checkfax(){
		
	   var txt = document.form1.fax1.value;
	   var pattern=/^[0-9]{7,8}$/;
	   
	 	if(document.form1.fax1.value==''){
			document.getElementById("fax").innerHTML="<span class='spanwrong'>请输入酒店传真！</span>";
			return false;
		}else{
			
			if(!pattern.exec(txt))
			{ 
			document.getElementById("fax").innerHTML="<span class='spanwrong'></span>请输入正确的号码！</span>";
			return false;
			}else{
	  			 document.getElementById("fax").innerHTML="<span class='spanright'></span>";
			}
		 }
	}

////-------------------------------------验证总机电话--------------------------------------------------	
   function checktortell(){

		var txt = document.form1.tortell.value;
		var pattern=/^[0-9]{7,8}$/;
		
		 if(document.form1.tortell.value==''){
			document.getElementById("tor").innerHTML="<span class='spanwrong'>请输入酒店总机！</span>";
		 	return false;
		 }else{
			if(!pattern.exec(txt))
			{
				document.getElementById("tor").innerHTML="<span class='spanwrong'>请输入正确的号码！</span>";
				return false;
			}else{
	 			document.getElementById("tor").innerHTML="<span class='spanright'></span>";
	 		 }
		}
   }

	var cities = new Array(); 
		<ww:iterator value="listCities">
			cities.push({id:<ww:property value="id"/>, name:'<ww:property value="name"/>', provinceId:<ww:property value="provinceid"/>}) ;
		</ww:iterator>
		
	function hotel_find_cities(provinceId) {
//alert("provinceId===="+provinceId);
		var ddlCity = document.getElementById('ddlCity');
//		alert("ddlCity=="+ddlCity);
		ddlCity.innerHTML = "";
		for(var cityIndex in cities) {
			var city = cities[cityIndex] ;
			if(city.provinceId == provinceId) {
				var oOption = document.createElement("OPTION");
				oOption.innerHTML = city.name;
				oOption.value = city.id ;
				ddlCity.appendChild(oOption) ;
			}
		}
		$("#ddlCity [value=<ww:property value='hotel.getCityid()'/>]").attr("selected",true);
				if(ddlCity.length==0)
		{
			var oOption = document.createElement("option");
			oOption.innerHTML = "--请选择城市--";
			oOption.value = -1 ;
			ddlCity.appendChild(oOption);
		}
		getcitiesInfo();
	}
	
	function getcitiesInfo(){
		var id= $("#ddlCity option:selected").val();
		//alert("id=="+id);
		ajax("hotelbasicinfo!getCitiesInfo.action","cityId="+id,callback,true);
		function callback(data){
			if(data!=null){
				var listAdmin = data.getValue("listAdmin");
				var listBiz =  data.getValue("listBiz");
				var listView =  data.getValue("listView");
				
				$("#regionid1").html('');
				$("#regionid2").html('');
				$("#regionid3").html('');
				if(listAdmin != null && $.isFunction(listAdmin.size) && listAdmin.size()>0){
				//alert(listAdmin);
					$("#regionid1").append("<option value=-1>--请选择区域--</option>")
					for(var i=0;i<listAdmin.size();i++){
						var region = listAdmin.get(i);
						if(id == $.trim(region.getValue("cityid"))){
							$("#regionid1").append("<option value="+region.getValue('id')+">"+region.getValue('name')+"</option>")
						}
					}
				}
				else{
						$("#regionid1").append("<option value=-1>--请选择区域--</option>")
				}
				if(listBiz != null && $.isFunction(listBiz.size) && listBiz.size()>0){
					$("#regionid2").append("<option value=-1>--请选择区域--</option>")
					for(var i=0;i<listBiz.size();i++){
						var region = listBiz.get(i)
						if(id == $.trim(region.getValue("cityid"))){
							$("#regionid2").append("<option value="+region.getValue('id')+">"+region.getValue('name')+"</option>")
						}
					}
				}
				else{
					$("#regionid2").append("<option value=-1>--请选择区域--</option>")
				}
				
				if(listView != null && $.isFunction(listView.size) && listView.size()>0){
					$("#regionid3").append("<option value=-1>--请选择区域--</option>")
					for(var i=0;i<listView.size();i++){
						var region = listView.get(i)
						if(id == $.trim(region.getValue("cityid"))){
							$("#regionid3").append("<option value="+region.getValue('id')+">"+region.getValue('name')+"</option>")
						}
					}
				}
				else{
					$("#regionid3").append("<option value=-1>--请选择区域--</option>")
				}
			}
			
			var arr = document.getElementById("regionid1").options;
			for(var i=0;i<arr.length;i++){
				if(arr[i].value == "<ww:property value='hotel.getRegionid1()'/>"){
					arr[i].setAttribute("selected","selected");
				}
			}
			
			var arr = document.getElementById("regionid2").options;
			for(var i=0;i<arr.length;i++){
				if(arr[i].value == "<ww:property value='hotel.getRegionid2()'/>"){
					arr[i].setAttribute("selected","selected");
				}
			}
			
			var arr = document.getElementById("regionid3").options;
			for(var i=0;i<arr.length;i++){
				if(arr[i].value == "<ww:property value='hotel.getRegionid3()'/>"){
					arr[i].setAttribute("selected","selected");
				}
			}
			
			
		}

	}


	
	function checkcity(a){
	//alert(a);
	    	if(a==1){
	document.getElementById("chengshi1").style.display="block";
	document.getElementById("chengshi11").style.display="block";
	document.getElementById("chengshi111").style.display="block";
	document.getElementById("chengshi1111").style.display="block";
   document.getElementById("chengshi2").style.display="none";
   document.getElementById("chengshi22").style.display="none";
	    	}
		if(a==2){
		
document.getElementById("chengshi1").style.display="none";
document.getElementById("chengshi11").style.display="none";
document.getElementById("chengshi111").style.display="none";
document.getElementById("chengshi1111").style.display="none";
   document.getElementById("chengshi2").style.display="block";
   document.getElementById("chengshi22").style.display="block";
	    	}
	    	
	    	}	
</script>
</html>

