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
<title></title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/bass.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="style/base100108.css" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<style>
fieldset {
    padding:10px;
    margin:5px;
    width:96%;
    color:#333; 
    border:#ccc dashed 1px;
} 
legend {
    color:#114F82;
    font-weight:800; 
    background:#fff;
} 
ul {
    list-style-type: none;
    margin:8px 0 4px 0;
} 
li {
    margin-top:4px;
}
</style>
<script>
  function unlockorder(id)
  {
     $.ajax({
            type:"POST",
            url:"orderinfo!unlockorder.action",
            data:{oid:id},           
            success:function(data){
            alert(data);         
            }            
            });
     window.location.href=window.location.href;
  }
  function copyToClipboard(theField,isalert,id)
{
  var obj=document.getElementById(theField);
  if(obj!=null)
  {
    var clipBoardContent=obj.value;
    obj.select();
    window.clipboardData.setData("Text",clipBoardContent); 
    if(isalert!=false)
      alert("复制成功。现在您可以粘贴（Ctrl+v）到其他地方了。");
  }
  else
  {
     alert("Error!");
  }
}
</script>
</head>
<body>

<form name="form1" method="post" action="orderinfo!tolockorderinfo.action">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;待解锁订单查询</span></b></td>
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
											class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;订单管理-待解锁订单查询</span></td>
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
											<option value="16"
												<ww:if test="s_orderstatus==16">selected="selected"</ww:if>>暂不能出票</option>
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
											class="button_d font-white" id="btnsearch"
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
										  <ww:if test="checkright('b2corderedit')">
										<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
											</ww:if>
											
										&nbsp;&nbsp;&nbsp;
										
										<a href="#" onclick="showItem()"><input
											type="button" value="查看" class="button_h font-red" /></a>
											
											
											</div>
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
											<th class="table_color">乘机人</th>
											<th class="table_color">行程</th>
											<th class="table_color">航班号</th>
											<th class="table_color">PNR</th>
											<th class="table_color">起飞时间/预订时间</th>
											<!--
											<th class="table_color">联系人姓名</th>
											<th class="table_color">PNR</th>
											
											
										
											<th class="table_color">总价</th>
											
											<th class="table_color">票号</th>
											<th class="table_color">订单类型</th>-->
											<th class="table_color">支付方式</th>
											<th class="table_color">订单状态</th>
											<th class="table_color">支付状态</th>
												<th class="table_color">处理人</th>
											<th class="table_color">操作</th>
											
										</tr>
										<ww:iterator value="listOrderinfo">
											<ww:set name="segmentinfoss" scope="webwork"
												value="getSegmentinfo(id)" />
											<tr   id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color color_b3" ><input type="checkbox" 
													name="selectid" value="<ww:property value="id"/>" /></td>
												<td class="table_color color_b3">
												
												<ww:if test="#session.ListAgid.indexOf('10042')>=0">
												<a href="orderinfo!toshowb2c.action?id=<ww:property value="id"/>"><ww:property
													value="ordernumber" /></a>
												</ww:if><ww:else>
												<a href="javascript: goEdit('orderinfo!toshowb2c.action?id=<ww:property value="id"/>','<ww:property value="id"/>');"><ww:property
													value="ordernumber" /></a>
												</ww:else>
												
												</td>
													
												<td class="table_color color_b3"><ww:property
													value="getPassengerNamehtml(id)" /></td>
													
												<td class="table_color color_b3"><ww:property
													value="getCitynameByAirport(getSegmentinfo(id).startairport)" />
												- <ww:property
													value="getCitynameByAirport(getSegmentinfo(id).endairport)" />
												</td>
												
												<td class="table_color color_b3"><ww:property value="#segmentinfoss.flightnumber"/></td>
												<td class="table_color color_b3"><a href="#" onclick="copyToClipboard('txtpnr_<ww:property value="id"/>',true,'<ww:property value="id"/>');return false;"><ww:property value="pnr"/></a><input id='txtpnr_<ww:property value="id"/>' style="display:none" type="text" value="<ww:property value="pnr"/>" />(小)<br /><ww:if test="bigpnr!=null"><a href="#" onclick="copyToClipboard('txtbigpnr_<ww:property value="id"/>',true,'<ww:property value="id"/>');return false;"><ww:property value="bigpnr"/></a><input id='txtbigpnr_<ww:property value="id"/>' style="display:none" type="text" value="<ww:property value="bigpnr"/>" />(大)</ww:if></td>
												<td class="table_color color_b3">
												<ww:property value="formatTimestamp(#segmentinfoss.departtime)"/><br /><ww:property
													value="formatTimestamp(createtime)" /></td>
												<!--<td class="table_color color_b3"><ww:property
													value="contactname" /></td>
												<td class="table_color color_b3"><ww:property value="pnr" /></td>
												
												
												
											<td class="table_color color_b3"><ww:property value="formatMoney(totalticketprice)"/></td>
												<td class="table_color color_b3"><ww:property value="formatMoney(getorderpricesum(id))"/></td>
												
												
												
												<td class="table_color color_b3"><ww:property
													value="getPassengerFEThtml(id)" /></td>
												<td class="table_color color_b3">
												<ww:if test="ordertype==1">网站预订</ww:if>
												<ww:if test="ordertype==2">后台预订</ww:if>
												<ww:if test="ordertype==3">同行预订</ww:if>
												<ww:if test="ordertype==4">团队订单</ww:if>
												<ww:if test="ordertype==5">K位订单</ww:if>
												<ww:if test="ordertype==6">呼叫中心</ww:if>
												</td>-->
												<td class="table_color color_b3">
												<ww:if test="paymethod==4">无卡支付</ww:if>
												<ww:if test="paymethod==5">客户挂账</ww:if>
												<ww:if test="paymethod==1">在线支付</ww:if>
												<ww:if test="paymethod==2">门市付款</ww:if>
												<ww:if test="paymethod==3">票到付款</ww:if>
												<ww:if test="paymethod==6">柜台支付</ww:if>
												</td>
												<td class="table_color color_b3"><ww:property
													value="getStateToString(orderstatus)" /></td>
												<td class="table_color color_b3"><ww:property value="getPayMethod(paystatus)" /></td>
												<td class="table_color color_b3">
												
												<ww:if test="operatingstate==1">
														<ww:if test="seachfxs(id)==1">
															<img src="images/Unlocked.png" border="0" />
														</ww:if><ww:else>
														<img src="images/Lock.png" border="0" /><br /><ww:property value="getusername(userid)"/><input type="hidden" id='hidname_<ww:property value="id" />' value='<ww:property value="getusername(userid)"/>' />
														</ww:else>
												</ww:if><ww:else>
												<img src="images/Unlocked.png" border="0" />
												</ww:else>
													</td>
												<td class="table_color color_b3">
												<!-- 订单操作开始 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭11.已经废票12.已经退票13.申请改签14.已经改签 -->
												<input type="button" class="button108" id="btnUnlock" value="解锁"  onclick="unlockorder(<ww:property value="id" />);" /><br/>
											
												</td>
												
											</tr>
											
										</ww:iterator>
									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center">
							<ww:property value="getPagination('\"orderinfo!tob2c.action?pageinfo.pagenum=\"+pageno')"/>
										<input type="hidden" name="" id="hur"  style="width: 150px" />				
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
<table>
	<tr>
		<td><strong><span style="color: Red">注意事项:</span></strong></td>
	</tr>
	<tr>
		<td>
		<ul>

            <li style="color: Red;">提示信息：点击PNR编码即可复制PNR编码到剪贴板</li>
			<li style="color: Red;">票号和EI项可以在订单详情页面添加</li>
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
<div style="width: 100%; background-color:Gray; display:none; height: 100%; position:absolute; left: 0; top: 0;" id="xie">
<div style="width: 260px; background-color:Gray; display:none; height: 113px; position:absolute; left: 244px; top: 137px;" id="content1"></div>

</div>
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
						
						document.form1.action="orderinfo!toeditb2c.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="orderinfo!toeditb2c.action?id="+uvalue;
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
						
						document.form1.action="orderinfo!toshowb2c.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="orderinfo!toshowb2c.action?id="+uvalue;
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








