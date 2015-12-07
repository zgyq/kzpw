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
<title><ww:if test="hotel.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店</title>
<style type="text/css">
</style>

<link href="../css/base.css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script src="../js/autocomplete/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
<script src="../js/money.js" type="text/javascript"></script>
<!-- 支持多语言开始 替换对应的类名 添加Action toeditlanguage方法 方法内容参考toadd 和toedit-->
<script type="text/javascript">
function addlanguage(ucode,language)
{
	document.getElementById("language").value=language;
	document.form1.action="hotel!toeditlanguage.action";
	document.form1.submit();
}
</script>
<!-- 支持多语言结束 -->
<style>
.spanwrong {
  height:23px; width:110px; border:#ffc4b3 1px solid; background:url(../images/wrorgt_icon.gif) #feebe6 4px -36px no-repeat; display:inline-block; line-height:23px; padding:0 5px 0 25px; overflow:hidden; color:#f00;
}
.spanright {
  height:25px; width:16px; border:#ccc 0px solid; background:url(../images/wrorgt_icon.gif) 0 2px no-repeat; display:inline-block; line-height:23px; padding:0 5px 0 25px; overflow:hidden;
}
</style>
</head>
<body>
<form
	action="hotel!<ww:if test="hotel.id>0">edit.action?id=<ww:property value="hotel.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="post">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<!-- 支持多语言开始 替换对应的类名 注意替换地级市等的名称-->
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;<ww:if test="hotel.id>0">编辑</ww:if><ww:else>新增</ww:else>酒店基本信息</span>
		<span
			style="display: block; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 396px;">
			<!--<tr>
				<ww:if test="hotel.id>0||hotel.language>0">
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
				</ww:if>
				<ww:else>
				<td width="100%" align="right"><a href="#" class="add"><img
					src="../images/jian.gif" width="27px" height="26px;"
					align="absmiddle" style="margin-right: 15px;">简体</a>&nbsp;&nbsp;&nbsp;</td>
				</ww:else>
			</tr>
		--></table>
		
		</span></td>
	</tr>
	<!-- 支持多语言结束 -->
	<tr>
		<td height="100%">
		<table width="100%" cellpadding="0" cellspacing="0">
			
			<tr>
				<td align="left">
				<table width="98%" border=0 cellpadding=0 cellspacing=0
					bgcolor="#000000">
					<tbody>
						<tr>
							<td align="center" bgcolor="#FFFFFF"><b>酒店基本信息</b></td>
						</tr>
					</tbody>
				</table>
				<table cellspacing=0 cellpadding=0 width="86%" border=0>
					<tbody>
						<tr>
							<td class=main_lbg height=16>&nbsp;</td>
							<td align=middle colspan=4>
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
													<td id=Td1 align=middle>
													<table class=main_lanpan cellspacing=0 cellpadding=0
														width="99%" border=0>
														<tbody>
															<tr>
																<td>
																<div style="text-align: center">
																<table width="99%" border=0 cellpadding=0 cellspacing=0
																	style="width: 100%">
																	<tbody>
																		<tr>
																			<td style="height: 20px" valign=center align=right
																				colspan=6>&nbsp;</td>
																		</tr>
																		<tr>
																			<td width="9%" align=center valign="middle"
																				style="height: 30px; text-align: right">中文名称：<span
																				id=Label2 style="color: #ff8080">*</span></td>


																			<td id="nametd" width="15%" align=left><input
																				id="name" name="name" require="true"
																				style="width: 120px"
																				value='<ww:property value="hotel.name"/>'" /><span id="LabePP" style="color: #ff8080"></span></td>

																			<td width="8%" align=left style="text-align: right">英文名称：</td>
																		  <td width="15%" align=left><input id="enname"
																				style="width: 120px" name="enname"
																				value='<ww:property value="hotel.enname"/>'
																				 /> <span id="eme"
																				style="color: #ff8080"></span></td>

																			<td width="9%" align=left style="text-align: right">酒店简拼：<span
																				id=Label7 style="color: #ff8080">*</span></td>
																	      <td width="14%" align=left><input id=jpname type="text"
																				style="width: 120px" require="true"
																				dataType="Require" msg="简拼不能为空" name="jpname"
																				 /><span id="jp" style="color: #ff8080"></span></td>
																      </tr>
																		<tr><td height="5"></td></tr>
																		<tr>
																			<td align=center valign="middle"
																				style="height: 30px; text-align: right">酒店星级：<span
																				id=Label2 style="color: #ff8080">*</span></td>
																			<td align=left><select id="ddlStars" style="width:125px" name="star" onblur="starIsNull()">
																				<option value="" selected="selected">--未选择--</option>
																				<option value="1">经济型</option> 
																				<option value="2">准二星</option>
																				<option value="3">二星级</option>
																				<option value="4">准三星</option>
																				<option value="5">三星级</option>
																				<option value="6">准四星</option>
																				<option value="7">四星级</option>
																				<option value="8">准五星</option>
																				<option value="9">五星级</option>
																			</select><span id="starspan" style="color: #ff8080"></span></td>

																			<td style="text-align: right" align=left>推荐级别：</td>
																			<td align=left><select id=ddlLevel
																				style="width: 125px" name="hot">
																				<option value="" selected="selected">--未选择--</option>
																				<option value="1">特级主推</option>
																				<option value="2">金牌主推</option>
																				<option value="3">暂时主推</option>
																				<option value="4">一级主推</option>
																				<option value="5">零级主推</option>
																				<option value="6">问题酒店</option>

																			</select></td>

																			<td style="text-align: right" align=left>酒店起价:<span
																				id="qijia" style="color: #ff8080">*</span></td>
																			<td align=left><input id="startprice"
																				style="width: 120px" require="true"
																				dataType="Require" msg="酒店起价不能为空" name="startprice"
																				 />元<span id="prc" style="color: #ff8080"></span>																			</td>
																	    </tr>
																		<tr><td height="5"></td></tr>
																		<tr>
																			<td align=center valign="middle"
																				style="height: 30px; text-align: right">酒店类型：</td>
																			<td style="height: 30px" align=left><select
																				id=ddlType style="width: 125px" name="type">
																				<option value="">--未选择--</option>
																				<option value="1">公寓式</option>
																				<option value="2">会议型</option>
																				<option value="3">度假型</option>
																				<option value="4">观光型</option>
																				<option value="5">综合型</option>
																				<option value="6">机场型</option>
																				<option value="7">别墅型</option>
																				<option value="8">商务型</option>
																			</select></td>
																			<td style="height: 30px; text-align: right"
																				align=left>房间总数：</td>
																			<td style="height: 30px" align=left><input id=RoomNum
																				style="width: 120px" name="rooms"/></td>
																			<td style="height: 30px; text-align: right"
																				align=left>装修级别：</td>
																			<td style="height: 30px" align=left><select
																				id=ddlRepair style="width: 125px" name=repair>
																				<option value="" selected="selected">--未选择--</option>
																				<option value="1">豪华</option>
																				<option value="2">高档</option>
																				<option value="3">舒适</option>
																				<option value="4">经济</option>

																			</select></td>
																	    </tr>
																		<tr><td height="5"></td></tr>
																		<tr>
																			<td align=center valign="middle"
																				style="height: 30px; text-align: right">开业时间：<span
																				id=Label6 style="color: #ff8080">*</span></td>
																			<td align=left><input id="Open" style="width: 120px" value="2010-08-08"
																				name="opendateStr" require="true" dataType="Require"
																				onfocus="WdatePicker({skin:'whyGreen'})" /><span id="opentime"
																				style="color: #ff8080"></span></td>
																			<td style="text-align: right" align=left>装修时间：<span
																				id=Label7 style="color: #ff8080">*</span></td>
																			<td align=left><input id="Repair"
																				style="width: 120px" name="repaildate"
																				onfocus="WdatePicker({skin:'whyGreen'})"
																				require="true"
																				dataType="Require" /><span id="retime"
																				style="color: #ff8080"></span></td>
																			<td style="text-align: right" align=left>日审类型：</td>
																			<td align=left><input id=IsNet type=radio value="1"
																				name="checktype" checked="checked" />日审<input
																				id=NoNet type=radio value="2" name="checktype" />夜审</td>
																	    </tr>
																		<tr><td height="5"></td></tr>

																		<tr>
																			<td align=center valign="middle"
																				style="height: 30px; text-align: right">主楼层数：<span
																				id=Label7 style="color: #ff8080">*</span></td>
																			<td align=left><input id=Main style="width: 120px"
																				name=mainlevel />层&nbsp;<span
																				id="mai" style="color: #ff8080"></span></td>
																			<td style="text-align: right" align=left>附楼层数：</td>
																			<td align=left><input id=NoMain style="width: 120px"
																				name=appendlever />层</td>
																			<td style="text-align: right" align=left>支付类型：</td>
																			<td align=left>
																			<input id=IsNet type=radio value="1" name="paytype" checked="checked" /> 现付
																			<input id=NoNet type=radio value="2" name="paytype" />预付</td>
																			<td style="text-align: right" align=left></td>
																			<td align=left></td>
																	    </tr>
																	    <tr>
																		
																		<td style="TEXT-ALIGN: right" align=left>返现方式：<SPAN
																			id=Label2 style="COLOR: #ff8080"></SPAN></td>
																		<td align=left>
																		<input type="radio" value="1"  name="meneyback" disabled="disabled"/>现返
																		<input type="radio" value="2"  name="meneyback" checked="checked" />后返
																		</td>
																		<td style="TEXT-ALIGN: right" align=left>返点方式：</td>
																		<td align=left>
																		<input type="radio" value="1" onclick="javascript:document.getElementById('rulesback').innerHTML='元';" disabled="disabled" name="rebateway"/>金额
																		<input type="radio" value="2" onclick="javascript:document.getElementById('rulesback').innerHTML='%';" checked="checked" name="rebateway"/>百分比
																		</td>
																		<td style="text-align: right" align=left>返点值：</td>
																			<td align=left><input style="WIDTH: 120px" id="rulesback" name="rulesback" />&nbsp;<span
																				id="rulesback">%</span></td>
																			<td align=center valign="middle"
																			style="HEIGHT: 30px; TEXT-ALIGN: right"></td>
																		<td align=left></td>
																	</tr>
																		<tr><td height="5"></td></tr>
																		<tr>
																			<td style="text-align: right" align=left>酒店介绍：</td>
																			<td align=left colspan=5><textarea id=txtdesc
																				style="width: 600px; height: 75px"
																				name="description"><ww:property
																				value="hotel.description" /></textarea></td>
																		</tr>
																		<tr><td height="5"></td></tr>
																		<tr>
																			<td style="text-align: right" align=left>预订要求：</td>
																			<td align=left colspan=5><textarea id=txtBRequire
																				style="width: 600px; height: 75px" name=prespec></textarea></td>
																		</tr>
																		<tr><td height="5"></td></tr>
																		<tr>
																			<td style="text-align: right" align=left>酒店卖点：</td>
																			<td align=left colspan=5><textarea id=txtSellPoint
																				style="width: 600px; height: 75px" name=sellpoint><ww:property
																				value="hotel.sellpoint" /></textarea></td>
																		</tr>
																		<tr><td height="5"></td></tr>
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



										<table class=mk cellspacing=2 cellpadding=0 width="100%"
											border=0>
											<tbody>
												<tr>
													<td width="927" align=left bgcolor="#a0cfee" class=rbgt
														style="width: 916px">&nbsp;&nbsp;<b>开户帐号</b></td>
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
																				style="width: 105px; height: 30px; text-align: right">公司全称：</td>
																			<td width="917" colspan=5 align=left
																				style="height: 30px"><input id="txtFullName"
																				style="width: 237px" name="fullname" /></td>
																		</tr>
																		<tr>

																			<td
																				style="width: 105px; height: 30px; text-align: right"
																				align=left>开户银行：</td>
																			<td align=left colspan=5><input id="acc"
																				style="width: 237px" name="openbank"
																				value="<ww:property value="hotel.openbank"/>" /></td>
																		</tr>
																		<tr>
																			<td style="width: 105px; text-align: right"
																				align=left>银行帐号：</td>
																			<td align=left colspan=5><input id="acc"
																				style="width: 237px" name="bankaccount"
																				 /><span id="ban"
																				style="color: #ff8080"></span></td>
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
								
								
								
										<table class=mk cellspacing=2 cellpadding=0 width="86%"
											border=0>
											<tbody>
												<tr>
													<td width="1041" align=left bgcolor="#a0cfee" class=rbgt
														style="width: 916px">
													<p>&nbsp;&nbsp;<b>地理位置信息</b></p>
													</td>
												</tr>
												<tr>
													<td align=left bgcolor="#FFFFFF" class=rbgt
														style="width: 927px">
													<table width="927" height="219" border="0">
														<tr><!-- 
				<input type="radio" name="checkrad" value="1"  checked="checked" <ww:if test="checkrad==1">checked</ww:if> onclick="checkcity(1)"/>国内
				<input type="radio" name="checkrad" value="2" <ww:if test="checkrad==2">checked</ww:if> onclick="checkcity(2)"/>国际 -->
			
															<td width="141" height="29" align="right" nowrap="nowrap"><span
																style="height: 30px; text-align: right">酒店邮编：<span
																id="Label8" style="color: #ff8080"></span></span></td>
															<td width="157"><span style="height: 30px"> <input
																id="txtPostCode" style="width: 120px" name="postcode"
																require="true" datatype="Require" 
																 /> <span id="pos"
																style="color: #ff8080"></span></td>
																
												
															<td width="90" align="right" id="chengshi1" style="display: block;"><span
																style="height: 30px; text-align: right">省（区）：</span><span
																id="provinces" style="color: #ff8080">*</span></td>
															<td width="160" id="chengshi11" style="display: block;"><span style="height: 30px"><select
																id="ddlProvince" style="width: 120px"
																onchange="hotel_find_cities(this.value)"
																 name="provinceid">
																<option value="0" selected="selected">--请选择省份--</option>
																<ww:iterator value="listProvinces">
																	<option value='<ww:property value="id"/>'><ww:property
																		value="name" /></option>
																</ww:iterator>
															</select> </span><span id="pro" style="color: #ff8080"></span></td>
															<td width="115" align="right" id="chengshi111" style="display: block;"><span
																style="width: 89px; height: 30px; text-align: right">城市：</span>
																<span id="provinces" style="color: #ff8080">*</span></td>
															<td width="238" id="chengshi1111" style="display: block;"><span style="height: 30px"> <select
																id="ddlCity" style="width: 120px" name="cityid"
																require="true" onchange="getcitiesInfo()">
																<option value="-1">--请选择城市--</option>
															</select> </span></td>
															
															
										
											
													<td width="115" align="right" id="chengshi2" style="display: none;"><span
																style="width: 89px; height: 30px; text-align: right">国际城市：</span>
																<span id="provinces" style="color: #ff8080">*</span></td>
															<td width="238" id="chengshi22" style="display: none;"><span style="height: 30px"> 
															<select
																id="ddlCity2" style="width: 120px" name="cityid2"
																require="true" >
																<ww:iterator value="listinCities">
																<option value="<ww:property value="id" />"><ww:property value="name" /></option>
																</ww:iterator>
															</select> </span></td>
											
											
											
											
														</tr>
														<tr>
															<td height="29" align="right" nowrap="nowrap"><span
																style="height: 30px; text-align: right">行政区：</span></td>
															<td><select id="ddlArea" style="width: 120px"
																name="ddlArea">
																<option value="">--请选择区域--</option>
															</select></td>
															<td align="right"><span style="text-align: right">商业区：</span></td>
															<td><select id="ddlBuss" style="width: 120px"
																name="ddlBuss">
																<option value="">--请选择区域--</option>
															</select></td>
															<td align="right">景区：</td>
															<td><select id="select" style="width: 120px"
																name="select">
																<option>--请选择区域--</option>
															</select></td>
														</tr>
														<tr>
															<td height="26" align="right" nowrap="nowrap"><span
																style="height: 30px; text-align: right">销售电话：</span></td>
															<td><input id="txtSellPhone" style="width: 120px"
																name="markettell" align="right" /></td>
															<td align="right"><span style="text-align: right">传 真：<span
																id="Label4" style="color: #ff8080">*</span></span></td>
															<td align="left">
															<input id="faxCode" type="text" style="width: 30px"/> -
															<input id="fax1" style="width: 80px"name="fax1" require="true" datatype="Require" msg="传真不能为空"  />
															<span id="fax" style="color: #ff8080"></span></td>

															<td align="right"><span
																style="width: 89px; text-align: right">总机电话：<span
																id="Label5" style="color: #ff8080">*</span></span></td>
															<td>
															<input id="tellCode" name="areaCode" type="text" style="width: 30px"/> -
															<input id="txtTel" style="width: 80px"
																name="tortell" require="true" datatype="Require"
																msg="总机不能为空" /><span id="tor"
																style="color: #ff8080"></span></td>

														</tr>
														<tr>
															<td height="26" align="right" nowrap="nowrap"><span
																style="height: 30px; text-align: right">传真说明：</span></td>
															<td colspan="5"><span style="height: 30px"> <input
																id="faxdesc" style="width: 600px" name="faxdesc" /> </span></td>
														</tr>
														<tr>
															<td height="26" align="right" nowrap="nowrap"><span
																style="height: 30px; text-align: right">详细地址：<span
																id="Label1" style="color: #ff8080">*</span></span></td>
															<td colspan="5"><input id="txtAddr" style="width: 600px"
																name="address" require="true" datatype="Require"
																msg="详细地址不能为空"  /><span id="add"
																style="color: #ff8080"></span></td>
														</tr>
														<!-- added by sunb 2010-01-06 start 酒店经纬度-->
														<tr>
															<td height="26" align="right" nowrap="nowrap">酒店经度：</td>
															<td><input
																id="txtlng" style="width: 150px" name="lng" /></td>
														    <td align="right">酒店纬度：</td>
															<td align="left"><input
																id="txtlat" style="width: 150px" name="lat" /></td>

															<td colspan="2" align="left"><a href="#" onclick="javascript:window.open('http://www.playgoogle.com/googlemap/tool1.html')">点击查看经纬度查询网址</a></td>
														  <td></td>
														</tr>
													    <!-- added by sunbin 2010-01-06 start 酒店经纬度-->
														<tr>
															<td height="50" align="right" nowrap="nowrap">周边酒店：</td>
															<td colspan="5"><textarea id="txtNearHotel"
																style="width: 600px; height: 50px" name="nearhotel">
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
													<td align=left bgcolor="#a0cfee" class=rbgt
														style="width: 916px">&nbsp;&nbsp;<b>酒店附带设施</b></td>
												</tr>
												<tr>
													<td align=middle>
													<table class=main_lanpan cellspacing=0 cellpadding=0
														width="99%" border=0>
														<tbody>
															<tr>
																<td>
																<div style="text-align: center">
																<table class=main_lanpan cellspacing=0 cellpadding=0
																	width="99%" border=0>
																	<tbody>
																		<tr>
																			<td>

																			<div style="text-align: center">
																			<table width="89%" height="278" border=0
																				cellpadding=0 cellspacing=5 style="width: 100%">
																				<tbody>
																					<tr>
																						<td style="text-align: right" valign=center
																							align=left>可接受卡类型：</td>
																						<td align=left valign=center>
																						<table width="788" border=0 id=Card>
																							<tbody>
																								<tr>
																									<td width="101"><input type=checkbox checked="checked"
																										name="cardType" value="万事达Maste" /> 万事达Maste</td>
																									<td width="93"><input type=checkbox checked="checked"
																										name="cardType" value="威士VISA" />威士VISA</td>
																									<td width="97"><input type=checkbox checked="checked"
																										name="cardType" value="运通AMEX" />运通AMEX</td>
																									<td width="126"><input type=checkbox checked="checked"
																										name="cardType" value="大来DinersClub" />大来DinersClub</td>
																									<td width="53"><input type=checkbox checked="checked"
																										name="cardType" value="JCB" />JCB</td>
																									<td width="70"><input type=checkbox checked="checked"
																										name="cardType" value="银联卡" />银联卡</td>
																								  <td width="218">其他:<input
																										name="otherCard" type=text value="" size="22" /></td>
																										
																								</tr>
																							</tbody>
																						</table>
																						</td>
																					</tr>
																					<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																					<tr>
																						<td style="text-align: right" valign=center
																							align=left>宾馆服务项目：</td>
																						<td align=left valign=center>
																						<table id=ServerItem border=0>
																							<tbody>
																							<tr>
																							<td>
																							<textarea name="serviceitem" rows="3" style="width: 600px;"></textarea>
																							</td>
																							</tr>
																								<!--<tr>
																									<td><input type=checkbox name="serviceItem" checked="checked"
																										value="会议厅" />会议厅</td>
																									<td><input type=checkbox name="serviceItem" checked="checked"
																										value="商务中心" />商务中心</td>
																									<td><input type=checkbox name="serviceItem" checked="checked"
																										value="停车场" />停车场</td>
																									<td><input type=checkbox name="serviceItem" checked="checked"
																										value="外币兑换服务" />外币兑换服务</td>
																									<td><input type=checkbox name="serviceItem" checked="checked"
																										value="票务服务" />票务服务</td>
																									<td><input type=checkbox name="serviceItem"
																										value="DDD电话" />DDD电话</td>
																									<td><input type=checkbox name="serviceItem"
																										value="IDD电话" />IDD电话</td>
																								</tr>
																								<tr>
																									<td><input type=checkbox name="serviceItem"
																										value="洗衣服务" />洗衣服务</td>
																									<td><input type=checkbox name="serviceItem"
																										value="商场" />商场</td>
																									<td><input type=checkbox name="serviceItem"
																										value="鲜花店" />鲜花店</td>
																									<td><input type=checkbox name="serviceItem"
																										value="医务室" />医务室</td>
																									<td><input type=checkbox name="serviceItem"
																										value="理发美容室" />理发美容室</td>
																									<td><input type=checkbox name="serviceItem"
																										value="出租车" />出租车</td>
																									<td><input type=checkbox name="serviceItem"
																										value="SPA" />SPA</td>
																								</tr>
																							-->
																							</tbody>
																						</table>
																						</td>
																					</tr>
																					<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																					<tr>
																						<td style="text-align: right" valign=center
																							align=left>餐饮设施：</td>
																						<td align=left valign=center>
																						<table id=cblFootSet border=0>
																							<tbody>
																								<!--<tr>
																									<td><input type=checkbox name="eatery" checked="checked"
																										value="中餐厅" />中餐厅</td>
																									<td><input type=checkbox name="eatery" checked="checked"
																										value="西餐厅" />西餐厅</td>
																									<td><input type=checkbox name="eatery" checked="checked"
																										value="咖啡厅" />咖啡厅</td>
																									<td><input type=checkbox name="eatery" checked="checked"
																										value="酒吧" />酒吧</td>
																									<td><input type=checkbox name="eatery" checked="checked"
																										value="限时送餐服务" />限时送餐服务</td>
																									<td><input type=checkbox name="eatery"
																										value="日餐厅" />日餐厅</td>
																								</tr>
																							-->
																							<tr>
																							<td>
																							<textarea name="footitem" rows="3" style="width: 600px;"></textarea>
																							</td>
																							</tr>
																							
																							</tbody>
																						</table>
																						</td>
																					</tr>
																					<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																					<tr>
																						<td style="text-align: right" valign=center
																							align=left>娱乐健身设施：</td>
																						<td align=left valign=center>
																						<table id=cblPlay border=0>
																							<tbody>
																								<!--<tr>
																									<td><input type=checkbox name="playItem" checked="checked"
																										value="迪斯科舞厅" />迪斯科舞厅</td>
																									<td><input type=checkbox name="playItem" checked="checked"
																										value="卡拉OK厅" />卡拉OK厅</td>
																									<td><input type=checkbox name="playItem" checked="checked"
																										value="棋牌室" />棋牌室</td>
																									<td><input type=checkbox name="playItem" checked="checked"
																										value="乒乓球室" />乒乓球室</td>
																									<td><input type=checkbox name="playItem" checked="checked"
																										value="室外游泳池" />室外游泳池</td>
																									<td><input type=checkbox name="playItem"
																										value="室内游泳池" />室内游泳池</td>
																									<td><input type=checkbox name="playItem"
																										value="健身室" />健身室</td>
																								</tr>
																								<tr>
																									<td><input type=checkbox name="playItem"
																										value="桑拿浴室" />桑拿浴室</td>
																									<td><input type=checkbox name="playItem"
																										value="桌球室" />桌球室</td>
																									<td><input type=checkbox name="playItem"
																										value="按摩室" />按摩室</td>
																									<td><input type=checkbox name="playItem"
																										value="网球场" />网球场</td>
																								</tr>
																							-->
																							<tr>
																							<td>
																							<textarea name="playitem" rows="3" style="width: 600px;"></textarea>
																							</td>
																							</tr>
																							</tbody>
																						</table>
																						</td>
																					</tr>
																					<tr height="1px"><td></td><td><hr style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden;" /></td></tr>
																					<tr>
																						<td style="text-align: right" valign=center
																							align=left>会议及其他设施：</td>
																						<td align=left valign=center><textarea
																							id=txtMeetting style="width: 500px; height: 65px"
																							name="meetingitem"> <ww:property
																							value="hotel.meetingitem" /></textarea></td>
																					</tr>
																					
																					
			<!-- 支持多语言开始 替换对应的类名-->
			<ww:if test="lan>0">
			<input id="language" type="hidden" name="language" value="<ww:property value="lan"/>"/>
			</ww:if>
			<ww:else>
			<input id="language" type="hidden" name="language" value="0"/>
			</ww:else>
			<input id="ucode"  type="hidden" name="ucode" value="<ww:property value="uco"/>"/>
			<!-- 支持多语言结束 -->
																					

																					<tr class="font-blue-xi">
																						<td height="54" rowspan="2"></td>
																						<td height="46" scrolling="no">
																						
					<div style=" position: relative;">	
																						
																						<input
																							type="button" class="button_d font-white" value="提交"
																							onclick="checkall()" /> <input type="button"
																							class="button_d font-white"
																							onclick="window.location.href='hotel.action?<ww:property value="url"/>';"
																							name="Submit2" value=" 取消返回 " />
					<!--<ww:iterator value="actionMessages">
					<div id="tishi" style=" position: absolute; top:-55px; left:0px; "><img src="../images/gg.png" width="149" height="60" /></div>
					<script type="text/javascript">
						setTimeout("showclose()",2000); 
						function showclose()
						{
							document.getElementById("tishi").style.display="none";
						}
					</script>
					</ww:iterator>
				--></div>	
																							
																							
																							</td>
																					</tr>
																					<tr>
																						<td height="17">&nbsp;</td>
																					</tr>
																				</tbody>
																			</table>
																			</div>

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
										</td>
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
<script type="text/javascript">

	function checkall(){
	//document.form1.submit();
	//return;
	checkjp();
	checkhotelname();
	
	checkRulesback();
	
	
	starIsNull();
	startMoney();
	checkmai();
	opendate();
	repairtime();
	
	proIsNull();
	checkfax();
	checkaddress();
	checktortell();
	if(document.form1.name.value=='' || document.form1.jpname.value=='' || document.form1.startprice.value=='' || document.form1.opendateStr.value==''  || document.form1.fax1.value=='' ||
	document.form1.tortell.value=='' || document.form1.address.value==''|| document.form1.star.value=='' || document.form1.rulesback.value==''){
		return;
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
		
		
		$.post("hotel!findByHotelName.action?name="+encodeURIComponent(hotelName),function(responseMessage){
				if(responseMessage=="false"){
					$("#LabePP").html("<span class='spanright'></span>");
				}else if (responseMessage=="true"){
						$("#LabePP").html("<span class='spanwrong'>酒店名称已经存在！</span>");
						$("#name").val("");
						$("#name").focus();
						$("#name").select();
				 }else if(responseMessage=="blank"){
					$("#LabePP").html("<span class='spanwrong'>酒店名称不能为空!</span>");
					return false;
				 }else{
				 	$("#LabePP").html("<span class='spanright'></span>");
				 }
				});
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


function checkEnterForFindListing(e){
    var characterCode;
   
    if(e && e.which){
        e = e;
        characterCode = e.which ;
    }
    else{
        e = event;
        characterCode = e.keyCode;
    }
   
    if(characterCode == 22){     
        document.forms[getNetuiTagName("findListingForm")].submit();
        return false;
    }
    else{
        return true ;
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
	//alert("cities=="+cities);	
	function hotel_find_cities(provinceId) {
	//	alert(provinceId);
		var ddlCity = document.getElementById('ddlCity');
		ddlCity.innerHTML = "";
	//	alert("var cityIndex in cities=="+cityIndex in cities);
		
		for(var cityIndex in cities) {
			var city = cities[cityIndex] ;
			//alert(city);
			if(city.provinceId == provinceId) {
				var oOption = document.createElement("option");
				oOption.innerHTML = city.name;
				oOption.value = city.id ;
				ddlCity.appendChild(oOption);
			}
		}
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
		ajax("hotel!getTellCode.action","h_cityId="+id,tellcallback,true);
		function tellcallback(data)
		{
			document.getElementById('tellCode').value=data;
			document.getElementById('faxCode').value=data;
		}
		ajax("hotel!getCitiesInfo.action","h_cityId="+id,callback,true);
		function callback(data){
			if(data!=null){
				var listAdmin = data.getValue("listAdmin");
				var listBiz =  data.getValue("listBiz");
				var listView =  data.getValue("listView");
				$("#ddlArea").html('');
				$("#ddlBuss").html('');
				$("#select").html('');
				if(listAdmin != null && $.isFunction(listAdmin.size) && listAdmin.size()>0){
				//alert(listAdmin);
					$("#ddlArea").append("<option value=-1>--请选择区域--</option>");
					for(var i=0;i<listAdmin.size();i++){
						var region = listAdmin.get(i);
						if(id == $.trim(region.getValue("cityid"))){
							$("#ddlArea").append("<option value="+region.getValue('id')+">"+region.getValue('name')+"</option>")
						}
					}
				}else{
							$("#ddlArea").append("<option value=-1>--请选择区域--</option>");
				}
				
				if(listBiz !== null && $.isFunction(listBiz.size) && listBiz.size()>0){
					$("#ddlBuss").append("<option value=-1>--请选择区域--</option>")
					for(var i=0;i<listBiz.size();i++){
						var region = listBiz.get(i)
						if(id == $.trim(region.getValue("cityid"))){
							$("#ddlBuss").append("<option value="+region.getValue('id')+">"+region.getValue('name')+"</option>")
						}
					}
				}
				else{
							$("#ddlBuss").append("<option value=-1>--请选择区域--</option>")
				}
				if(listView != null && $.isFunction(listView.size) && listView.size()>0){
					$("#select").append("<option value='-1'>--请选择区域--</option>")
					for(var i=0;i<listView.size();i++){
						var region = listView.get(i)
						if(id == $.trim(region.getValue("cityid"))){
							$("#select").append("<option value="+region.getValue('id')+">"+region.getValue('name')+"</option>")
						}
					}
				}
				
				else{
					$("#select").append("<option value='-1'>--请选择区域--</option>")
				}
			}
		}
	}
	$().ready(function() {	
		$("#ddlProvince [value=<ww:property value='hotel.getProvinceid()'/>]").attr("selected","selected");
		hotel_find_cities("<ww:property value='hotel.getProvinceid()'/>");
	});
	
	function checkcity(a){
	    	if(a==1){
	document.getElementById("chengshi1").style.display="block";
	document.getElementById("chengshi11").style.display="block";
	document.getElementById("chengshi111").style.display="block";
	document.getElementById("chengshi1111").style.display="block";
   document.getElementById("chengshi2").style.display="none";
   document.getElementById("chengshi22").style.display="none";
	    	}
		if(a==2){
document.getElementById("ddlProvince").value="";
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

