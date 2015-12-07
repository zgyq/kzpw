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
			 *
			 */

		%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>酒店基本信息</title>
<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>
<body>
<form
	action="hotelbasicinfo!edit.action?id=<ww:property value="hotel.id"/>"
	name="form1" method="post" onSubmit="return Validator.Validate(this,3)">
<input type="hidden" name="hotelId"
	value="<ww:property value="hotel.id"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  background="../images/jb.gif" ><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店基本信息</span></td>
	</tr>
	<tr>
		<td height="100%">
		<table width="100%" cellpadding="0" cellspacing="0">
			<tr>
			<td align=left>
			<table width="98%" border=0 cellPadding=0 cellSpacing=0
				bgcolor="#000000">
				<tbody>
					<tr>
						<td align="center" bgcolor="#FFFFFF"><strong>基本信息</strong></td>
					</tr>
				</tbody>
			</table>
			<table cellspacing=0 cellpadding=0 width="100%" border=0>
				<tbody>
					<tr>
						<TD class=main_lbg height=16>&nbsp;</TD>
						<TD align=left colspan=4>
						<table id=right_main cellspacing=0 cellpadding=0 width="87%"
							border=0>
							<tbody>
								<tr>
									<TD>
									<table class=mk cellspacing=2 cellpadding=0 width="100%"
										border=0>
										<tbody>
											<tr>
												<TD align=left bgcolor="#a0cfee" class=rbgt>酒店信息</TD>
											</tr>
											<tr>
												<td id=Td1 align=left>
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
																			value='<ww:property value="hotel.name"/>'/></TD>
																		<TD width="11%" align=left style="TEXT-ALIGN: right">英文名称：</TD>
																		<TD width="19%" align=left><input id="enname"
																			style="WIDTH: 120px" name="enname"
																			value='<ww:property value="hotel.enname"/>'/></TD>
																		<TD width="9%" align=left style="TEXT-ALIGN: right">酒店简拼：<SPAN
																			id=Label7 style="COLOR: #ff8080">*</SPAN></TD>
																		<TD width="36%" align=left><INPUT id=jpname
																			style="WIDTH: 120px" require="true"
																			dataType="Require" msg="简拼不能为空" name="jpname"
																			value='<ww:property value="hotel.jpname"/>'></TD>
																	</TR>
																	<tr><td height="5px"></td></tr>
																	<tr>
																		<TD align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right">酒店星级：</TD>
																		<TD align=left><SELECT id=ddlStars
																			style="WIDTH: 125px" name="star">
																			<option value=""
																				<ww:if test="hotel.star==''">selected="selected"</ww:if>>--未选择--</option>
																			<OPTION value="1"
																				<ww:if test="hotel.star==1">selected="selected"</ww:if>>经济型</OPTION>
																			<OPTION value="2"
																				<ww:if test="hotel.star==2">selected="selected"</ww:if>>准二星</OPTION>
																			<OPTION value="3"
																				<ww:if test="hotel.star==3">selected="selected"</ww:if>>二星级</OPTION>
																			<OPTION value="4"
																				<ww:if test="hotel.star==4">selected="selected"</ww:if>>准三星</OPTION>
																			<OPTION value="5"
																				<ww:if test="hotel.star==5">selected="selected"</ww:if>>三星级</OPTION>
																			<OPTION value="6"
																				<ww:if test="hotel.star==6">selected="selected"</ww:if>>准四星</OPTION>
																			<OPTION value="7"
																				<ww:if test="hotel.star==7">selected="selected"</ww:if>>四星级</OPTION>
																			<OPTION value="8"
																				<ww:if test="hotel.star==8">selected="selected"</ww:if>>准五星</OPTION>
																			<OPTION value="9"
																				<ww:if test="hotel.star==9">selected="selected"</ww:if>>五星级</OPTION>

																		</SELECT></TD>

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
																			" msg="酒店起价不能为空"></td>
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
																				<ww:if test="hotel.type==7">selected="selected"</ww:if>>商务型</OPTION>
																		</SELECT></td>
																		<td style="HEIGHT: 30px; TEXT-ALIGN: right" align=left>房间总数：<SPAN
																			id=Label3 style="COLOR: #ff8080">*</SPAN></td>
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
																			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
																		<td style="TEXT-ALIGN: right" align=left>装修时间：</td>
																		<td align=left><input id="Repair" style="WIDTH: 120px"
																			name="repaildate"
																			value="<ww:property value="hotel.repaildate"/>"
																			onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
																	<td style="TEXT-ALIGN: right" align=left>日审类型：</td>
																		<td align=left><input type="radio" value="1"
																			name="websign"
																			<ww:if test="hotel.checktype==1">checked="checked"</ww:if> />日审<input
																			type="radio" value="2" name="websign"
																			<ww:if test="hotel.checktype==2">checked="checked"</ww:if> />夜审</td>
																	</tr>
																	<tr><td height="5px"></td></tr>
																	<tr>
																		
																		<td style="TEXT-ALIGN: right" align=left>主楼层数：</td>
																		<td align=left><input id=txtMain style="WIDTH: 120px"
																			name=mainlevel
																			value="<ww:property value="hotel.mainlevel"/>" />层</td>
																		<td style="TEXT-ALIGN: right" align=left>附楼层数：</td>
																		<td align=left><input id=txtNoMain
																			style="WIDTH: 120px" name=appendlever
																			value="<ww:property value="hotel.appendlever"/>" />层</td>
																	<td style="text-align: right" align=left>支付类型：</td>
																			<td align=left>
																			<input id=IsNet type=radio <ww:if test="hotel.paytype==1">checked="checked"</ww:if> value="1" name="paytype"  /> 现付
																			<input id=NoNet type=radio <ww:if test="hotel.paytype==2">checked="checked"</ww:if> value="2" name="paytype" />预付</td>
																			<td align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right"></td>
																		<td align=left></td>
																	</tr>
																	<tr><td height="5px"></td></tr>
																	<tr>
																		<td style="TEXT-ALIGN: right" align=left>酒店介绍：</td>
																		<td align=left colSpan=5><textarea id=txtDesc
																			style="WIDTH: 600px; HEIGHT: 64px" name=description><ww:property
																			value="hotel.description" /></textarea></td>
																	</tr>
																	<tr>
																		<td style="TEXT-ALIGN: right" align=left>预订要求：</td>
																		<td align=left colSpan=5><textarea id=txtBRequire
																			style="WIDTH: 600px; HEIGHT: 65px" name=prespec><ww:property
																			value="hotel.prespec" /></textarea></td>
																	</tr>
																	<tr><td height="5px"></td></tr>
																	<tr>
																		<td style="TEXT-ALIGN: right" align=left>酒店卖点：</td>
																		<td align=left colSpan=5><textarea id=txtSellPoint
																			style="WIDTH: 600px; HEIGHT: 65px" name=sellpoint><ww:property
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
													style="WIDTH: 916px">开户帐号</td>
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
									<table class=mk cellSpacing=2 cellPadding=0 width="94%"
										border=0>
										<tbody>
											<tr>
												<td width="1041" align=left bgcolor="#a0cfee" class=rbgt
													>
												<p>地理位置信息</p>
												</td>
											</tr>
											<tr>
												<td align=left bgcolor="#FFFFFF" class=rbgt
													>
												<table class=main_lanpan cellspacing=0 cellpadding=0 border="0" width="100%">
													<tr>
														<td width="130" align=left
															style="WIDTH: 105px; HEIGHT: 30px; TEXT-ALIGN: right">酒店邮编：<span
															id="Label8" style="COLOR: #ff8080">*</span></td>
														<td width="189"><span style="HEIGHT: 30px"> <input
															id="txtPostCode" style="WIDTH: 120px" name="postcode"
															require="true" datatype="Require" msg="洒店邮编不能为空"
															value="<ww:property value="hotel.postcode"/>" /> </span></td>
														<td width="133" align="right"><span
															style="HEIGHT: 30px; TEXT-ALIGN: right">省（区）：</span></td>
														<td width="159"><span style="HEIGHT: 30px"> <select
															id="ddlProvince" style="WIDTH: 120px">
															<option value="-2" selected="selected"><ww:property value="getProvinceNameById(hotel.provinceid)"/></option>
														</select> </span></td>
														<td width="86" align="right"><span
															style="WIDTH: 89px; HEIGHT: 30px; TEXT-ALIGN: right">城 市：</span></td>
														<td width="193"><span style="HEIGHT: 30px"> <select
															id="ddlCity" style="WIDTH: 120px" name="cityid">
															<option value="-2"><ww:property value="getCityNameById(hotel.cityid)"/></option>
														</select> </span></td>
													</tr>
													<tr><td height="5px"></td></tr>
													<tr>
														<td height="29" align="right" nowrap="nowrap"><span
															style="HEIGHT: 30px; TEXT-ALIGN: right">行政区：</span></td>
														<td><select id="ddlArea" style="WIDTH: 120px"
															name="ddlArea"><ww:if test="hotel.regionid1<1"></ww:if>
															<ww:if test="hotel.regionid1>0">
																<option value="-2">
																	<ww:property value="getRegionNameById(hotel.regionid1,1)"/>
																</option>
															</ww:if>
															 <ww:if test="hotel.regionid1<1">
																<option value="-3">未添行政区</option>
															</ww:if> 
														</select></td>
														<td align="right"><span style="TEXT-ALIGN: right">商业区：</span></td>
														<td><select id="ddlBuss" style="WIDTH: 120px"
															name="ddlBuss">
															<ww:if test="hotel.regionid2>0">
																<option value="-2">
																	<ww:property value="getRegionNameById(hotel.regionid2,2)"/>
																</option>
															</ww:if> 
															 <ww:if test="hotel.regionid2<1">
																<option value="-3">未添商业区</option>
															</ww:if> 
														</select></td>

														<td align="right">景区：</td>
														<td><select id="select" style="WIDTH: 120px" name="select">
															<ww:if test="hotel.regionid3>0">
																<option value="-2">
																	<ww:property value="getRegionNameById(hotel.regionid3,3)"/>
																</option>
															</ww:if>
															<ww:if test="hotel.regionid3<1"> 
																<option value="-3">未添景区</option>
															</ww:if>
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
															name="fax1" value="<ww:property value="hotel.fax1"/>" /></td>
														<td align="right"><span
															style="WIDTH: 89px; TEXT-ALIGN: right">总机电话：<span
															id="Label5" style="COLOR: #ff8080">*</span></span></td>
														<td><input id="txtTel" style="WIDTH: 120px" name="tortell"
															value="<ww:property value="hotel.tortell"/>"
															require="true" datatype="Require" msg="总机不能为空" /></td>
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
															value="<ww:property value="hotel.address"/>" /></td>
													</tr>
													<!-- added by sunb 2010-01-06 start 酒店经纬度-->
													<tr>
															<td height="26" align="right" nowrap="nowrap">酒店纬度：</td>
															<td><input id="txtlng" style="width: 150px" name="lng" value="<ww:property value="hotel.lng"/>"/></td>
														    <td align="right">酒店经度：</td>
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
												<td width="1041" align=left bgcolor="#a0cfee" class=rbgt
													style="WIDTH: 916px">酒店服务，设施，可接受信信用卡</td>
											</tr>
											<tr>
												<td align=left bgcolor="#FFFFFF" class=rbgt
													style="WIDTH: 927px">
											
																		<table class=main_lanpan cellspacing=0 cellpadding=0 border="0">
																			<tbody>
																				<tr>
																					<td width="130" align=left
															style="WIDTH: 105px; HEIGHT: 30px; TEXT-ALIGN: right">可接受卡类型：</td>
																					<td align=left vAlign=center>
																					<table  id=Card border=0>
																						<tbody>
																							<tr>
																								<ww:property
																									value="getCardTypeHTML(hotel.carttype)" />
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
																								<ww:property
																									value="getServicItemHTML(hotel.serviceitem)" />
																							
																							
																							</tr>
																						</tbody>
																					</table>
																					</td>
																				-->
																				<td align=left colSpan=5><textarea id=Item
																						style="WIDTH: 600px; HEIGHT: 65px"
																						name=serviceitem><ww:property
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
																							
																								<ww:property
																									value="getEateryHTML(hotel.footitem)" />
																							</tr>
																						</tbody>
																					</table>
																					</td>
																				-->
																				<td align=left colSpan=5><textarea id=cblFootSet
																						style="WIDTH: 600px; HEIGHT: 65px"
																						name=footitem><ww:property
																						value="hotel.footitem" /></textarea></td>
																				
																				</tr>
                                                                                <tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																				<tr>
																					<td style="TEXT-ALIGN: right" vAlign=center
																						align=left>娱乐健身设施：</td>
																					<!--<td align=left vAlign=center>
																					<table id=cblPlay border=0>
																						<tbody>
																							<tr>
																							
																								<ww:property
																									value="getPlayItemHTML(hotel.playitem)" />
																							</tr>
																						</tbody>
																					</table>
																					</td>
																				-->
																				<td align=left colSpan=5><textarea id=cblPlay
																						style="WIDTH: 600px; HEIGHT: 65px"
																						name=playitem><ww:property
																						value="hotel.playitem" /></textarea></td>
																						
																						
																				</tr>
																				<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																				<tr>
																					<td style="TEXT-ALIGN: right" align=left>会议及其他设施：</td>
																					<td align=left colSpan=5><textarea id=txtSellPoint
																						style="WIDTH: 600px; HEIGHT: 65px"
																						name=meetingitem><ww:property
																						value="hotel.meetingitem" /></textarea></td>
																				</tr>


																			<!--  	<tr class="font-blue-xi">
																					<td height="54" rowspan="2"></td>
																					<td height="46" scrolling="no"><input type="submit"
																						class="button" name="Submit1" value="提交" /> <input
																						type="button" class="button"
																						onclick="window.location.href='hotel.action?<ww:property value="url"/>';"
																						name="Submit2" value=" 取消返回 " /></td>
																				</tr>
																				<tr>
																					<td height="17">&nbsp;</td>
																				</tr>
																				-->
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
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
<script language="javascript">
	var cities = new Array(); 
		<ww:iterator value="listCities">
			cities.push({id:<ww:property value="id"/>, name:'<ww:property value="name"/>', provinceId:<ww:property value="provinceid"/>}) ;
		</ww:iterator>
	function hotel_find_cities(provinceId) {
		var ddlCity = document.getElementById('ddlCity');
		for(var op in ddlCity.options) {
			ddlCity.remove(op);
		}
		for(var cityIndex in cities) {
			var city = cities[cityIndex] ;
			if(city.provinceId == provinceId) {
				var oOption = document.createElement("OPTION");
				oOption.text = city.name;
				oOption.value = city.id ;
				ddlCity.add(oOption) ;
			}
		}
	}
	
	

</script>
</html>

