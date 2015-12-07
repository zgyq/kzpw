<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机票订单报表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="	js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>	
</head>
<body>

<form name="form1" method="post" action="orderinfo!report.action">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<div id="report1">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;国内	机票订单报表</span></b></td>
	</tr>
	</div>
	<tr>
		<td valign="top">


		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">	
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<div id="report3">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>

								<table class="table2" width="100%">
									<tr>
										<td width="100%" height="29" colspan="8"
											background="images/jb.gif"
											style="border-bottom: 1px solid #99CBED"><span
											class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;报表系统-国内机票报表</span></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">PNR编号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_pnr" type="text" id="s_pnr" style="width: 90%;"
											value="<ww:property value="s_pnr"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">订单编号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_ordernumber" type="text" id="s_ordernumber"
											value="<ww:property value="s_ordernumber"/>"
											style="width: 90%;" /></td>
										<td align="right" style="width: 9%; height: 26px;"
											nowrap="nowrap">预订时间&nbsp;</td>
										<td align="right" style="width: 16%; height: 26px;"><input
											name="s_bengincreatetime" type="text"
											value="<ww:property value="s_bengincreatetime"/>"
											id="s_bengincreatetime" onfocus="WdatePicker()"
											style="width: 90%;" /></td>
										<td align="right" style="width: 10%; height: 26px;">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_endcreatetime" type="text"
											value="<ww:property value="s_endcreatetime"/>"
											id="s_endcreatetime" onfocus="WdatePicker()"
											style="width: 90%;" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%" nowrap="nowrap">乘机日期
										</td>
										<td align="right" style="width: 15%"><input
											name="s_beginchengji" type="text" id="s_beginchengji"
											onfocus="WdatePicker()" style="width: 90%;"
											value="<ww:property value="s_beginchengji"/>" /></td>
										<td style="width: 6%" align="center">至</td>
										<td align="right" style="width: 15%"><input
											name="s_endchengji" type="text" id="s_endchengji"
											onfocus="WdatePicker()" style="width: 90%;"
											value="<ww:property value="s_endchengji"/>" /></td>
										<td align="right" style="width: 9%" nowrap="nowrap">
										出票时间&nbsp;</td>
										<td align="right" style="width: 16%"><input
											name="s_beginprinttime" type="text" id="s_beginprinttime"
											onfocus="WdatePicker()" style="width: 90%;"
											value="<ww:property value="s_beginprinttime"/>" /></td>
										<td align="right" style="width: 10%">至</td>
										<td align="right" style="width: 15%"><input
											name="s_endprinttime" type="text" id="s_endprinttime"
											value="<ww:property value="s_endprinttime"/>"
											onfocus="WdatePicker()" style="width: 90%;" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%" nowrap="nowrap">出发城市
										</td>
										<td align="right" style="width: 15%"><select
											name="s_begincity" style="width: 170px;">
											<option value=""
												<ww:if test="s_begincity==null">selected="selected"</ww:if>>所有城市</option>
											<ww:iterator value="listCityairport">
												<option value="<ww:property value="airportcode"/>"
													<ww:if test="s_begincity==airportcode">selected="selected"</ww:if>><ww:property
													value="cityname" />(<ww:property value="airportcode" />)</option>
											</ww:iterator>
										</select></td>
										<td align="right" style="width: 6%" nowrap="nowrap">到达城市
										</td>
										<td align="right" style="width: 15%"><select
											name="s_endcity" style="width: 177px;">
												<option value=""
												<ww:if test="s_endcity==null">selected="selected"</ww:if>>所有城市</option>
											<ww:iterator value="listCityairport">
												<option value="<ww:property value="airportcode"/>"
													<ww:if test="s_endcity==airportcode">selected="selected"</ww:if>><ww:property
													value="cityname" />(<ww:property value="airportcode" />)</option>
											</ww:iterator>
										</select></td>
										<td align="right" style="width: 10%; height: 26px;">乘机人</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_passengername" type="text" id="s_passengername"
											style="width: 90%;"
											value="<ww:property value="s_passengername"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;">票号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_passengerfet" type="text" id="s_passengerfet"
											style="width: 90%;"
											value="<ww:property value="s_passengerfet"/>" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%; height: 26px;">航班号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_flightnumber" type="text" id="s_flightnumber"
											style="width: 90%;"
											value="<ww:property value="s_flightnumber"/>" /></td>

										<td align="right" style="width: 9%; height: 26px;"
											nowrap="nowrap">订单状态</td>
										<td align="right" style="width: 16%; height: 26px;"><select
											name="s_orderstatus" id="s_orderstatus" style="width: 177px;">
											<option
												<ww:if test="s_orderstatus==null">selected="selected"</ww:if>>所有状态</option>
											<option value="0"
												<ww:if test="s_orderstatus==0">selected="selected"</ww:if>>新订单等待支付</option>
											<option value="1"
												<ww:if test="s_orderstatus==1">selected="selected"</ww:if>>采购商取消交易，交易结束</option>
											<option value="2"
												<ww:if test="s_orderstatus==2">selected="selected"</ww:if>>已经付款，等待出票</option>
											<option value="3"
												<ww:if test="s_orderstatus==3">selected="selected"</ww:if>>已经出票，交易结束</option>
											<option value="4"
												<ww:if test="s_orderstatus==4">selected="selected"</ww:if>>取消出票，等待退款</option>
											<option value="5"
												<ww:if test="s_orderstatus==5">selected="selected"</ww:if>>改签订单，等待审核</option>
											<option value="6"
												<ww:if test="s_orderstatus==6">selected="selected"</ww:if>>改签审核通过，机票被挂起，等待支付</option>
											<option value="7"
												<ww:if test="s_orderstatus==7">selected="selected"</ww:if>>已经付款，等待解挂</option>
											<option value="8"
												<ww:if test="s_orderstatus==8">selected="selected"</ww:if>>已经解挂，交易结束</option>
											<option value="9"
												<ww:if test="s_orderstatus==9">selected="selected"</ww:if>>改签订单审核不通过，交易结束</option>
											<option value="10"
												<ww:if test="s_orderstatus==10">selected="selected"</ww:if>>退票订单，等待审核</option>
											<option value="11"
												<ww:if test="s_orderstatus==11">selected="selected"</ww:if>>已经退款，交易结束</option>
											<option value="12"
												<ww:if test="s_orderstatus==12">selected="selected"</ww:if>>退票订单审核不通过，交易结束</option>
											<option value="13"
												<ww:if test="s_orderstatus==13">selected="selected"</ww:if>>废票订单，等待审核</option>
											<option value="14"
												<ww:if test="s_orderstatus==14">selected="selected"</ww:if>>审核通过，等待退款</option>
											<option value="15"
												<ww:if test="s_orderstatus==15">selected="selected"</ww:if>>废退票订单审核不通过，交易结束</option>
											<option value="16"
												<ww:if test="s_orderstatus==16">selected="selected"</ww:if>>退款订单，延迟处理</option>
											<option value="17"
												<ww:if test="s_orderstatus==17">selected="selected"</ww:if>>线下订单待确认</option>
											<option value="18"
												<ww:if test="s_orderstatus==18">selected="selected"</ww:if>>线下订单审核不通过，交易结束</option>
											<option value="19"
												<ww:if test="s_orderstatus==19">selected="selected"</ww:if>>暂不能出票，等待处理</option>
										</select></td>




										<td id="td1" colspan="2"></td>
									</tr>
									<tr>

										<td colspan="10" align="center"><input id="searchbtn" type="submit"
											class="button_d font-white"
											value="查询订单" />
											<input type="button" id="reportbtn"
											class="button_d font-white"
											value="导出报表" onclick="ExportToExcel()"/>
											
											<!--  <input type="button"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="订单的解锁" onclick="searchOne()" /> <input type="button"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="进行中的退款订单" onclick="searchOne()" /> <input
											type="button"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="进行中的买入订单" onclick="searchOne()" /> <input
											type="button"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="进行中的卖出订单" onclick="searchOne()" /> <input
											type="button"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="取消出票订单" onclick="searchOne()" /> <input type="reset"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="清除条件" /> <input type="button"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="按编码出票订单" onclick="searchOne()" />--></td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<!--<td height="27" align="center">
										<div align="right">
										<a href="#" onclick="updateItem()">
										<a href="#" onclick="toadd()"><input
											type="button" value="新增" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp; 
										<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red" /></a> 
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input
											type="button" value="审核" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="showItem()"><input
											type="button" value="查看" class="button_h font-red" /></a></div>
										</td>
									--></tr>
								</table>
								</td>
							</tr>
						</table>
						</div>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								</div>
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">

											<th class="table_color" width="54" height="25">订单编号</th>
											<th class="table_color">创建时间</th>
											<th class="table_color">联系人姓名</th>
											<th class="table_color">PNR</th>
											<th class="table_color">航班号</th>
											<th class="table_color">起飞时间</th>
											<th class="table_color">行程</th>
											<th class="table_color">总价</th>
											<th class="table_color">乘机人</th>
											<th class="table_color">票号</th>
											<th class="table_color">订单状态</th>
											<th class="table_color">支付状态</th>
											<!--
							                  <th class="table_color">订单ID</th>
							                  <th class="table_color">订单号</th>
							                  <th class="table_color">分销商ID</th>
							                  <th class="table_color">政策ID</th>
							                  
							                  <th class="table_color">联系人手机</th>
							                  <th class="table_color">备注信息</th>
							                  <th class="table_color">送票方式</th>
							                  <th class="table_color">送票地址</th>
							                  <th class="table_color">订单状态</th>
							                  <th class="table_color">总燃油费</th>
							                  <th class="table_color">总机建费</th>
							                  <th class="table_color">总票面价</th>
							                  
							                  <th class="table_color">关联订单号</th>
							                  <th class="table_color">退改签状态</th>
							                  <th class="table_color">联系电话</th>
							                  
							                  <th class="table_color">支付状态</th>
							                  <th class="table_color">支付方式</th>
							                  <th class="table_color">出票商</th>
							                  <th class="table_color">会员ID</th>
							                  <th class="table_color">通知方式</th>
											-->
										</tr>
										<ww:iterator value="listOrderinfo">
											<ww:set name="segmentinfoss" scope="page"
												value="getSegmentinfo(id)" />
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
												<td class="table_color"><ww:property
													value="ordernumber" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>

												<td class="table_color"><ww:property
													value="contactname" />'</td>
												<td class="table_color"><ww:property value="pnr" /></td>
												<td class="table_color">${segmentinfoss.flightnumber}</td>
												<td class="table_color">${segmentinfoss.departtime}</td>
												<td class="table_color"><ww:property
													value="getCitynameByAirport(getSegmentinfo(id).startairport)" />
												- <ww:property
													value="getCitynameByAirport(getSegmentinfo(id).endairport)" />
												</td>
												<td class="table_color">${segmentinfoss.yprice}</td>
												<td class="table_color"><ww:property
													value="getPassengerNamehtml(id)" /></td>
												<td class="table_color"><ww:property
													value="getPassengerFEThtml(id)" /></td>
												<td class="table_color"><ww:property
													value="getStateToString(orderstatus)" /></td>
												<td class="table_color"><ww:property value="getPayMethod(paystatus)" /></td>
												<!--<td  class="table_color"><ww:property value="id"/></td>
													<td  class="table_color"><ww:property value="ordernumber"/></td>
													<td  class="table_color"><ww:property value="buyagentid"/></td>
													<td  class="table_color"><ww:property value="policyid"/></td>
													
													<td  class="table_color"><ww:property value="contactmobile"/></td>
													<td  class="table_color"><ww:property value="memo"/></td>
													<td  class="table_color"><ww:property value="receipt"/></td>
													<td  class="table_color"><ww:property value="addresa"/></td>
													<td  class="table_color"><ww:property value="orderstatus"/></td>
													<td  class="table_color"><ww:property value="totalfuelfee"/></td>
													<td  class="table_color"><ww:property value="totalairportfee"/></td>
													<td  class="table_color"><ww:property value="totalticketprice"/></td>
													
													<td  class="table_color"><ww:property value="relationorderid"/></td>
													<td  class="table_color"><ww:property value="tuistatus"/></td>
													<td  class="table_color"><ww:property value="contacttel"/></td>
													
													<td  class="table_color"><ww:property value="paystatus"/></td>
													<td  class="table_color"><ww:property value="paymethod"/></td>
													<td  class="table_color"><ww:property value="saleagentid"/></td>
													<td  class="table_color"><ww:property value="customeruserid"/></td>
													<td  class="table_color"><ww:property value="notetype"/></td>
											-->
											</tr>
										</ww:iterator>
									</tbody>
								</table>
								
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
<div id="report2">
<table>
	<tr>
		<td><strong><span style="color: Red">注意事项:</span></strong></td>
	</tr>
	<tr>
		<td>
		<ul>
			<li style="color: Red;">订单报表</li>
		</ul>
		</td>
	</tr>
</table>
</div>
</form>
</body>
</html>
<script type="text/javascript" language="javascript">
	function ExportToExcel()
	{
		try
		{
			var xlApp = new ActiveXObject("Excel.Application");       
		}
		catch(e)
		{
			alert("浏览器的当前安全属性不允许创建Excel对象，请在Internet选项卡-安全选项卡启动ActiveX插件"+e);
			return null;
		}
	    
		try
		{            
			xlApp.Visible=true;
			xlApp.Workbooks.Add();
			var report1=document.all("report1").innerHTML;
			var report2=document.all("report2").innerHTML;
			var report3=document.all("report3").innerHTML;
			document.all("report1").innerHTML=""
			document.all("report2").innerHTML=""
			document.all("report3").innerHTML=""
			document.execCommand("SelectAll");
			document.execCommand("Copy");
			xlApp.ActiveSheet.Paste();
			document.execCommand("Unselect");
			document.all("report1").innerHTML=report1
			document.all("report2").innerHTML=report2
			document.all("report3").innerHTML=report3
		}
		catch(e)
		{
			xlApp.Quit();
			xlApp=null;
			alert("打开文件错误，请确认文件名是否正确！"+e);
			return null;
		}
	}
</script>






