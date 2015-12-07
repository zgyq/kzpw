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
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;批量修改酒店基本信息</span>
		<span
			style="display: block; float: right;">
		<table border="0" cellpadding="0" cellspacing="0"
			style="text-align: center; width: 396px;">
			</table>
		
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
																		
																		<tr><td height="5"></td></tr>
																		<tr>
																			
																			<td style="text-align: right" align=left>日审类型：</td>
																			<td align=left><input id=IsNet type=radio value="1"
																				name="checktype" checked="checked" />日审<input
																				id=NoNet type=radio value="2" name="checktype" />夜审</td>
																	    </tr>
																		<tr><td height="5"></td></tr>

																		<tr>
																			
																			<td style="text-align: right" align=left>支付类型：</td>
																			<td align=left>
																			<input id=IsNet type=radio value="1" name="paytype" checked="checked" /> 现付
																			<input id=NoNet type=radio value="2" name="paytype" />预付</td>
																			<td style="text-align: right" align=left></td>
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
														
														
										<input id="hoteiid" style="width: 237px" name="hotelid" value="<ww:property value="hotelid"/>" />				
														
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

</html>

