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
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单信息表列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/bass.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script>
function goEdit(ur,id)
{
document.getElementById("hur").value=ur;
//alert(id+"..."+ur);
		var url="orderinfo!fenxiaoseachstate.action?oid="+id;
		var params = {s_status:2};
		jQuery.post(url,params, function(data) {
		
			if (data != '') {
				
				var s, ss;
				
				ss = data.substr(0, 2); 	
				//alert(ss);
				if(ss == 'su'){
				alert("该订单已经锁定");
				}
				if(ss == 'my'){
				//alert("这订单我的"+ur);
				window.location.href=document.getElementById("hur").value;
				}
				if(ss == 'sh'){
				var sheid = data.split(",");	
				
				
				var uid = sheid[1];
				//alert(uid);
				alert("该订单不是你处理的");
				
				
				}
				if(ss == 'ko'){
				//alert("这订单没人处理");
				window.location.href=ur;
				}
				
			}
		});
		
		

  // 
}

Ext.onReady(function(){

	 var selectId ="";

	 var menu = new Ext.menu.Menu({
        id: 'mainMenu',
		width:'160px',
        style: {
            overflow: 'visible'     // For the Combo popup
        },
        items: [
		     
		    {
                id:"new",
				text: '查看',
				icon:"images/menu/view.gif",
				handler : function(item){
					document.form1.action="orderinfo!toshow.action?id="+selectId;
					document.form1.submit();
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="orderinfo!toedit.action?id="+selectId;
						document.form1.submit();
				}
            }
			
			
		]

		});



	Ext.get('menutable').on('contextmenu',function(e){
		
		if(e.target.parentNode.id)
		{
			e.preventDefault();
			selectId = e.target.parentNode.id;
			menu.showAt(e.getPoint());
		}
	});

});
</script>
</head>
<body>
<ww:if test="type==8"><form name="form1" method="post" action="orderinfo!tokwei.action"></ww:if>
<ww:if test="type==9"><form name="form1" method="post" action="orderinfo!totuandui.action"></ww:if>

<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;我的<ww:if test="type==8">K位</ww:if>
			<ww:if test="type==9">团队</ww:if>
			订单信息列表</span></b></td>
			
	</tr>
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
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>

								<table class="table2" width="100%">
									<tr>
										<td width="100%" height="29" colspan="8"
											background="images/jb.gif"
											style="border-bottom: 1px solid #99CBED"><span
											class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;订单管理-订单查询</span></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">PNR编号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_pnr" type="text" id="s_pnr" style="width: 138px;"
											value="<ww:property value="s_pnr"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">订单编号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_ordernumber" type="text" id="s_ordernumber"
											value="<ww:property value="s_ordernumber"/>"
											style="width: 138px;" /></td>
										<td align="right" style="width: 9%; height: 26px;"
											nowrap="nowrap">预订时间&nbsp;</td>
										<td align="right" style="width: 16%; height: 26px;"><input
											name="s_bengincreatetime" type="text"
											value="<ww:property value="s_bengincreatetime"/>"
											id="s_bengincreatetime" onfocus="WdatePicker()"
											style="width: 138px;" /></td>
										<td align="right" style="width: 10%; height: 26px;">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_endcreatetime" type="text"
											value="<ww:property value="s_endcreatetime"/>"
											id="s_endcreatetime" onfocus="WdatePicker()"
											style="width: 138px;" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%" nowrap="nowrap">乘机日期
										</td>
										<td align="right" style="width: 15%"><input
											name="s_beginchengji" type="text" id="s_beginchengji"
											onfocus="WdatePicker()" style="width: 138px;"
											value="<ww:property value="s_beginchengji"/>" /></td>
										<td style="width: 6%" align="center">至</td>
										<td align="right" style="width: 15%"><input
											name="s_endchengji" type="text" id="s_endchengji"
											onfocus="WdatePicker()" style="width: 138px;"
											value="<ww:property value="s_endchengji"/>" /></td>
										<td align="right" style="width: 9%" nowrap="nowrap">
										出票时间&nbsp;</td>
										<td align="right" style="width: 16%"><input
											name="s_beginprinttime" type="text" id="s_beginprinttime"
											onfocus="WdatePicker()" style="width: 138px;"
											value="<ww:property value="s_beginprinttime"/>" /></td>
										<td align="right" style="width: 10%">至</td>
										<td align="right" style="width: 15%"><input
											name="s_endprinttime" type="text" id="s_endprinttime"
											value="<ww:property value="s_endprinttime"/>"
											onfocus="WdatePicker()" style="width: 138px;" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%" nowrap="nowrap">出发城市
										</td>
										<td align="right" style="width: 15%"><select
											name="s_begincity" style="width: 142px;">
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
											name="s_endcity" style="width: 142px;">
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
											style="width: 138px;"
											value="<ww:property value="s_passengername"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;">票号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_passengerfet" type="text" id="s_passengerfet"
											style="width: 138px;"
											value="<ww:property value="s_passengerfet"/>" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%; height: 26px;">航班号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_flightnumber" type="text" id="s_flightnumber"
											style="width: 138px;"
											value="<ww:property value="s_flightnumber"/>" /></td>

										<td align="right" style="width: 9%; height: 26px;"
											nowrap="nowrap">订单状态</td>
										<td align="right" style="width: 16%; height: 26px;"><select
											name="s_orderstatus" id="s_orderstatus" style="width: 142px;">
											<option
												<ww:if test="s_orderstatus==null">selected="selected"</ww:if>>所有状态</option>
											
											<option value="1"
												<ww:if test="s_orderstatus==1">selected="selected"</ww:if>>等待支付</option>
											<option value="2"
												<ww:if test="s_orderstatus==2">selected="selected"</ww:if>>支付成功</option>
											<option value="3"
												<ww:if test="s_orderstatus==3">selected="selected"</ww:if>>出票完成</option>
											<option value="4"
												<ww:if test="s_orderstatus==4">selected="selected"</ww:if>>申请退票</option>
											
											<option value="5"
												<ww:if test="s_orderstatus==5">selected="selected"</ww:if>>申请废票</option>
											<option value="6"
												<ww:if test="s_orderstatus==6">selected="selected"</ww:if>>取消订单</option>
											<option value="7"
												<ww:if test="s_orderstatus==7">selected="selected"</ww:if>>废票不成功</option>
											<option value="8"
												<ww:if test="s_orderstatus==8">selected="selected"</ww:if>>审核失败</option>
											<option value="9"
												<ww:if test="s_orderstatus==9">selected="selected"</ww:if>>废票退款成功</option>
											<option value="10"
												<ww:if test="s_orderstatus==10">selected="selected"</ww:if>>订单关闭</option>
											<option value="11"
												<ww:if test="s_orderstatus==11">selected="selected"</ww:if>>已经废票</option>
											<option value="12"
												<ww:if test="s_orderstatus==12">selected="selected"</ww:if>>已经退票</option>
											<option value="13"
												<ww:if test="s_orderstatus==13">selected="selected"</ww:if>>申请改签</option>
											<option value="14"
												<ww:if test="s_orderstatus==14">selected="selected"</ww:if>>已经改签</option>
											<option value="15"
												<ww:if test="s_orderstatus==15">selected="selected"</ww:if>>改签失败</option>
											<option value="17"
												<ww:if test="s_orderstatus==17">selected="selected"</ww:if>>退票不成功</option>
											<option value="18"
												<ww:if test="s_orderstatus==18">selected="selected"</ww:if>>退票退款成功</option>
										</select></td>




										
										<td align="right" style="width: 9%; height: 26px;"></td>
										<td align="right" style="width: 9%; height: 26px;"></td>
									</tr>
									<tr>

										<td colspan="10" align="center"><input type="submit"
											class="button_d font-white"
											value="查询订单" />
											</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="40" align="center">
										<div align="right">
										<a href="#" onclick="updateItem()">
										<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="showItem()"><input
											type="button" value="查看" class="button_h font-red" /></a></div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">

											<th class="table_color" width="54" height="25"><input
												type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>

											<th class="table_color">订单编号</th>
											<th class="table_color">人数</th>
											<th class="table_color">行程</th>
											<th class="table_color">航班号</th>
											<th class="table_color">起飞时间</th>
											<th class="table_color">预订时间</th><!--
											<th class="table_color">联系人姓名</th>
											--><th class="table_color">PNR</th>
											
											
										
											<th class="table_color">总价</th>
											
											<!--<th class="table_color">票号</th>
											<th class="table_color">订单类型</th>
											-->
											<th class="table_color">支付方式</th>
											<th class="table_color">订单状态</th>
											<th class="table_color">支付状态</th>
											<th class="table_color">处理人</th>
											<th class="table_color">操作</th>
											
										</tr>
										<ww:iterator value="listOrderinfo">
											<ww:set name="segmentinfoss" scope="webwork"
												value="getSegmentinfo(id)" />
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color color_b3"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>
												<td class="table_color color_b3">
												<a href="javascript: goEdit('orderinfo!toshow.action?id=<ww:property value="id"/>','<ww:property value="id"/>');">
												<ww:property
													value="ordernumber" /></a></td>
													
												<td class="table_color color_b3">
												<!--<ww:property value="getPassengerNamehtml(id)" />
													-->
													<ww:property value="getPassengersizi(id)" />
													</td>
													
												<td class="table_color color_b3"><ww:property
													value="getCitynameByAirport(getSegmentinfo(id).startairport)" />
												- <ww:property
													value="getCitynameByAirport(getSegmentinfo(id).endairport)" />
												</td>
												

												<td class="table_color color_b3"><ww:property value="#segmentinfoss.flightnumber"/></td>
												<td class="table_color color_b3">
												<ww:property value="formatTimestamp(#segmentinfoss.departtime)"/></td>

												
												<td class="table_color color_b3"><ww:property
													value="formatTimestamp2(createtime)" /></td>

												<!--<td class="table_color color_b3"><ww:property
													value="contactname" /></td>
												--><td class="table_color color_b3"><ww:property value="pnr" /></td>
												
												
												
											<td class="table_color color_b3"><ww:property value="formatMoney(totalticketprice)"/></td>
												<!--<td class="table_color color_b3"><ww:property value="formatMoney(getorderpricesum(id))"/></td>
												
												
												<td class="table_color color_b3"><ww:property
													value="getPassengerFEThtml(id)" /></td>
												<td class="table_color color_b3">
												<ww:if test="ordertype==1">网站预订</ww:if>
												<ww:if test="ordertype==2">后台预订</ww:if>
												<ww:if test="ordertype==3">同行预订</ww:if>
												<ww:if test="ordertype==4">团队订单</ww:if>
												<ww:if test="ordertype==5">K位订单</ww:if>
												<ww:if test="ordertype==6">其他</ww:if>
												</td>-->
												<td class="table_color color_b3">
												<ww:if test="paymethod==1">网上付款</ww:if>
												<ww:if test="paymethod==2">门市付款</ww:if>
												<ww:if test="paymethod==3">票到付款</ww:if>
												</td>
												<td class="table_color color_b3"><ww:property
													value="getStateToString(orderstatus)" /></td>
												<td class="table_color color_b3"><ww:property value="getPayMethod(paystatus)" /></td>
												<td class="table_color color_b3">
												<ww:if test="fenxiaooperstate==1">
												<img src="images/Lock.png" border="0" /><ww:property value="getusername(fenxiaouserid)"/>
												</ww:if><ww:else>
												<img src="images/Unlocked.png" border="0" />
												</ww:else>
													</td>
												<td class="table_color color_b3">

												<!-- 订单操作开始 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭11.已经废票12.已经退票13.申请改签14.已经改签 -->
												<ww:if test="orderstatus==1">
												<input type="button" class="button108" id="btnCancel" value="立即支付"  onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=2','<ww:property value="id" />')" /><br/>

												</ww:if>
												<!--<ww:elseif test="orderstatus==2">
												<input type="button" class="button108" id="btnRRTicket" value="立即出票"   onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=3','<ww:property value="id" />')" /><br/>
												<input type="button" class="button108" id="btnRRTicket" value="暂不能出票"  onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=19','<ww:property value="id" />')" /><br/>
												</ww:elseif>
												--><ww:elseif test="orderstatus==3">
												<input type="button" class="button108" id="btnRRTicket" value="申请废票"   onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=5','<ww:property value="id" />')" /><br/>
												<input type="button" class="button108" id="btnRRTicket" value="申请退票"   onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=4','<ww:property value="id" />')" /><br/>
												
												<input type="button" class="button108" id="btnRRTicket" value="申请改签"  onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=13','<ww:property value="id" />')" /><br/>
												</ww:elseif>
												<input type="button" class="button108" id="btnRRTicket" value="取消订单"  onclick="goEdit('orderinfo!orderstatusedit.action?id=<ww:property value="id" />&orderstatus=6','<ww:property value="id" />')" /><br/>
												<!--<ww:if test="operatingstate==1">
												<a href="orderinfo!jiesuo.action?id=<ww:property value="id" />"> 解锁订单</a> 
												</ww:if>
												--></td>
												
											</tr>
										</ww:iterator>
									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center">
								<ww:if test="type==9">
								<ww:property value="getPagination('\"orderinfo!totuandui.action?pageinfo.pagenum=\"+pageno')"/>
								</ww:if>
							<ww:if test="type==8">
								<ww:property value="getPagination('\"orderinfo!tokwei.action?pageinfo.pagenum=\"+pageno')"/>
								</ww:if>
								</td>
							</tr>
	<input type="hidden" name="" id="hur"  style="width: 150px" />	
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
<table>
	<tr>
		<td><strong><span style="color: Red">注意事项:</span></strong></td>
	</tr>
	<tr>
		<td>
		<ul>

			<li style="color: Red;">PNR为“00000”的散冲团编码</li>
			<li id="li1"><span id="Label1">解锁功能只有本单位的管理员才具有</span></li>
			<li>点击"创建时间"即可查看订单详细</li>
			<li>查询范围为 本登录帐户所在部门的所有订单 可以根据订单状态来跟踪 订单动向</li>
			<li>点击"进行中的买入订单"按钮可查看"已经完成支付，但是没有结束的采购交易"的订单</li>
			<li id="liRemark">点击"进行中的卖出订单"按钮可查看"买家已经完成支付，但是没有结束的卖出交易"的订单</li>
			<li>点击"进行中的退款订单"按钮可查看"进行中的退款订单"的订单</li>
			<li>过滤真实废票订单选项,只在查询'废票订单，等待审核'状态的订单或选择'进行中的退款订单'时起效</li>
		</ul>
		</td>
	</tr>
</table>
</form>
</body>
</html>


<script language="JavaScript">
	function toadd(){
		window.location="orderinfo!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="orderinfo!delete.action?id="+document.form1.selectid.value;
							document.form1.submit();
						}
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.form1.action="orderinfo!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="orderinfo!batch.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="orderinfo!toedit.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="orderinfo!toedit.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
	
 function checkItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="orderinfo!tocheck.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="orderinfo!tocheck.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  // 详细信息展示
  function showItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="orderinfo!toshow.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="orderinfo!toshow.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
			
function unselectall()
{
    if(document.form1.all.checked){
	document.form1.all.checked = document.form1.all.checked&0;
    }
}

function selectall1()
{
    var length=document.form1.selectid.length;
    document.form1.all1.checked = document.form1.all1.checked|0;
  

   if ( length ==undefined &&  document.form1.selectid!=null ){
    	  document.form1.selectid.checked=document.form1.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.form1.selectid[i].checked = document.form1.all1.checked;
	      document.form1.getElementsByTagName("*").checked=document.form1.all1.checked;
       }
    }
}


</script>





