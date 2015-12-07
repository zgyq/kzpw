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
<title>乘机人表列表</title>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
 <style type="text/css">
  #bg{ display: none;  position: absolute;  top: 0%;  left: 0%;  width: 100%;  height: 200%;  background-color: #fff;  z-index:1001;  -moz-opacity: 0.7;  opacity:.70;  filter: alpha(opacity=40);}
</style>
<script>
Ext.onReady(function(){
 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,  
       
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:170,
	   tpl: "<tpl for='.'><div style='height:240px ; width:170px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  

	<ww:property value="deptstr"/>
	
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       });  	
		comboxWithTree.setValue("<ww:property value="departname"/>");
       tree.on('click',function(node){    
            comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            Ext.get('thedeptid').set({value:node.id});
            comboxWithTree.collapse();              
       }); 	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().collapseChildNodes();			
		});

	
    comboxWithTree.render('comboxWithTree');  
});
</script>
<script>

function feiyong(id){
 if(id==1){
  $("#id1").show();
  $("#id2").hide();
  $("#id3").hide();
 }
 if(id==2){
  $("#id2").show();
  $("#id1").hide();
  $("#id3").hide();
 
 }
 if(id==3){
  $("#id3").show();
  $("#id1").hide();
  $("#id2").hide();
 
 }
}


function dispose(message) {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
function colsedispose(){
 Ext.MessageBox.hide();
}

</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;选择还款订单列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>
				<form name="form1" action="biguserprice!repay.action"
					method="post">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="20px">&nbsp;</td>
						
						<td height="20" align="right">部&nbsp;&nbsp;门：</td>
						<td width="280px">
						<table><tr><td>
						<span style="HEIGHT: 71px" style="WIDTH: 100px">
						<div id='comboxWithTree'></div>
						<input type="hidden" id="parentid" name="s_department" value="<ww:property value="s_department"/>" />
						<input type="hidden" id="agentid" name="agentid"
							value='<ww:property value="agentid"/>' /> 
							</span></td><td><input type="radio" name="contains" <ww:if test="contains==0">checked="checked"</ww:if> value="0"/>不包含<input type="radio" <ww:if test="contains==1">checked="checked"</ww:if> name="contains" value="1"/>包含</td></tr></table>
						</td>
						
							<td width="60" height="20" align="right">预订人：</td>
						<td>
						<span style="HEIGHT: 71px" style="WIDTH: 100px">
						<input id="s_ordername" style="WIDTH: 100px" name="s_ordername"
							value="<ww:property value="s_ordername"/>" /> 
						 </span>
						</td>				
						
						<td width="80" height="20" align="right">&nbsp;联系人：</td>
						<td><span style="HEIGHT: 71px"> <input id="username"
							style="WIDTH: 100px" name="username"
							value="<ww:property value="username"/>" /> </span></td>
						<td width="80" height="20" align="right">出票日期：</td>
						<td><input type="text" name="s_begintime"
							onfocus="WdatePicker(WdatePicker({skin:'whyGreen'}))" 
							style="width: 70px" value="<ww:property value="s_begintime"/>" />-
						<input type="text" name="s_endtime"
							onfocus="WdatePicker(WdatePicker({skin:'whyGreen'}))" 
							style="width: 70px" value="<ww:property value="s_endtime"/>" />
						</td>						
					</tr>
					<tr>
					 <td width="20px">&nbsp;</td>
					 <td colspan="2">
					 <table>
					 <tr>
					 <td align="right">订单号:</td>
					 <td><span style="HEIGHT: 71px"> <input
							style="WIDTH: 100px" name="s_ordernum"
							value="<ww:property value="s_ordernum"/>" /> </span></td>
					 <td width="50px" align="right">票号:</td>
					 <td><span style="HEIGHT: 71px"> <input style="WIDTH: 100px" name="s_ticketnum"
							value="<ww:property value="s_ticketnum"/>" /> </span></td>
					 </tr>
					 </table>
					 </td>						
							<td height="20" align="right">&nbsp;类&nbsp;型：</td>
										<td>
										
										<select name="s_internal" style="width:100px">
										<option value="-1" <ww:if test="s_internal==-1">selected=selected</ww:if>></option>
										<option value="0" <ww:if test="s_internal==0">selected=selected</ww:if> >国内票</option>
										<option value="1" <ww:if test="s_internal==1">selected=selected</ww:if>>国际票</option>
										</select>
										</td>
						<td width="80" height="20" align="right">&nbsp;乘机人：</td>
						<td><span style="HEIGHT: 71px"> 
							<input id="username" style="WIDTH: 100px" name="s_passengername"
							value="<ww:property value="s_passengername"/>" /> </span></td>
						<td width="80" height="20" align="right">航班日期：</td>
						<td colspan="2"><input type="text" name="flight_begintime"
							onfocus="WdatePicker(WdatePicker({skin:'whyGreen'}))" 
							style="width: 70px" value="<ww:property value="flight_begintime"/>" />-
						<input type="text" name="flight_endtime"
							onfocus="WdatePicker(WdatePicker({skin:'whyGreen'}))" 
							style="width: 70px" value="<ww:property value="flight_endtime"/>" />
						</td>						
					</tr>
					<tr>
						<td align="center" colspan="12" >
						<input type="submit" class="button_d font-bai" value="查询" /></td>
					</tr>
					<tr>
						<td align="center" colspan="20" height="5px" >
						</td>
					</tr>
				</table>
				</form>
				</td>
			</tr>
		</table>
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
								<td height="20">
								<table width="95%" border="1" bordercolor="#a0cfee"
									cellspacing="0" cellpadding="0"
									style="margin: 0 auto; border-collapse: collapse">
									<tr>
										<td height="28" align="right">
										<div class="td_color"><span>单位/部门：</span></div>
										</td>
										<td style="padding-left: 5px;"><input type="text"
											require="true" dataType="Require" readonly="readonly"
											msg="大客户ID不能为空" name=""
											value='<ww:property value="departname"/>'
											style="width:100%; border: 0px" /></td>
										
										<td  height="28" align="right">
										<div class="td_color">欠款总金额：</div>
										</td>
										<td><ww:property value="formatMoney(arrearage)" /></td>
										
									</tr>
									<tr>
										<td height="28" align="right">
										<div class="td_color"><span>还款总金额：</span></div>
										</td>
										<td style="padding-left: 5px;"><input type="text"
											onblur="che()" id="zong"
											value='<ww:property value="hkallprice"/>'
											 style="width: 80px" /> <input type="hidden"
											name="hkuanprice" id="hzong" style="width: 350px" /></td>
										<td height="28" align="right">
										<div class="td_color"><span>付款方式：</span></div>
										</td>
										<td style="padding-left: 5px;"><select id="ptype">
											<ww:iterator value="getHkmethodMap()">
											<option value="<ww:property value="key"/>"><ww:property value="value"/></option>
											</ww:iterator>
										</select></td>
									</tr>
									<tr>
										<td align="right">
										<div class="td_color">还款余额：</div>
										</td>
										<td style="padding-left: 5px;"><input type="text" id="yu" readonly="readonly"
											value="<ww:property value="formatPaymoney(blanceyue)"/>"
											style="border: 0px" /> <input type="hidden" require="true"
											dataType="Require" id="hyu" name="yu" value=""
											style="width: 50px" /> <input type="hidden" require="true"
											dataType="Require" id="yue"
											value="<ww:property value="formatPaymoney(blanceyue)"/>"
											style="width: 50px" /></td>

										<td align="right">
										<div class="td_color">已还：</div>
										</td>
										<td style="padding-left: 5px;"><input type="text"
											require="true" dataType="Require" readonly="readonly"
											id="hai" name="" value='<ww:property value="haveprofit"/>'
											style="border: 0px" /> <input type="hidden" require="true"
											dataType="Require" id="hhai" name="hai" value=""
											style="width: 50px" /></td>
									</tr>
									<tr>
										<td height="28" align="right">
										<div class="td_color"><span>备注：</span></div>
										</td>
										<td style="padding-left: 5px;" colspan="3"><input type="text"
											require="true" dataType="Require" msg="备注不能为空" name="comment"
											value='<ww:property value="biguserprice.comment"/>' style="width: 300px" /></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<!-- 按钮    88888****************************************                                           -->
					<input type="hidden" require="true" dataType="Require" id="bufenid"
						name="bufenid" value="" style="width: 50px" />
					<tr>
						<td valign="top" style="padding-top: 5px; padding-left: 45px">
						<input type="button" class="button_d font-bai"
							onclick="feiyong(1)" value="机票费用" /> <input type="button"
							class="button_d font-bai" onclick="feiyong(2)" value="退废改签" /> <input
							type="button" class="button_d font-bai" onclick="feiyong(3)"
							value="杂项费用" /></td>
					</tr>
					<tr>
						<form action="" name="formticket" id="form2" method="post">
						<td valign="top" style="padding-top: 15px;">
						<div id="id1">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" id="hktable"  width="98%" border="1" align="center"
									class="table_color">
									<tbody>
										
										<tr class="tbody_color">
										<th class="table_color" width="54" height="25">还款</th>
										
										    <th class="table_color">订单编号</th>
											<th class="table_color">票号</th>
											<th class="table_color">联系人</th>
											<th class="table_color">预订人</th>
											<th class="table_color">乘机人</th>
										<!-- 航班号、航程 起飞日期、起飞时刻、机票价格、机建费、燃油费、总计、还款状态-->											
											<th class="table_color">航班号</th>											
											<th class="table_color">航程</th>
											<th class="table_color">航班时间</th>
											<th class="table_color">机票价格</th>
											<th class="table_color">税</th>
											<th class="table_color">保险</th>
											<th class="table_color">欠款总计</th>		
											<th class="table_color">机票状态</th>									
											<th class="table_color">还款状态</th>
										
										   <!-- <th class="table_color">订单编号</th>
											<th class="table_color">票号</th>
											<th class="table_color">联系人</th>
											<th class="table_color">预订人</th>
											<th class="table_color">乘机人</th>
											<th class="table_color">证件号</th>
											<th class="table_color">航程</th>
											<th class="table_color">航班时间</th>
											<th class="table_color">票价</th>											
											<th class="table_color">机票状态</th>
											<th class="table_color">还款状态</th>-->
										</tr>
										<ww:iterator value="listPassenger" status="state">
											<tr id="t<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color">
													<input type="checkbox"  <ww:if test='havechecked(id)'>checked="checked"</ww:if>
														<ww:if test="hkstate==2"> disabled="disabled"</ww:if>
														id="<ww:property value="id"/>" name="orderid"
														value="<ww:property value="id"/>"
														onclick="checkprice('<ww:property value="haiqian" />','<ww:property value="id"/>','<ww:property value="state"/>',this);" />
											    </td>
												<td class="table_color">
								             	<a target="_blank" href='orderinfo!toshowb2c.action?id=<ww:property value="orderid"/>'
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==2">style="color:#0356A6"</ww:if> >
													<ww:property value="getordercode(orderid)" /></a>
													</td>
												<td class="table_color"
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="ticketnum" /></td>
													
											   <td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="getlinkManName(orderid)" /></td>
													
													
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="getOrderName(orderid)" /></td>
													
													
													<td class="table_color"
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="name" /></td>
													
											
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value='getSegmentInfo(orderid,"getFlightnumber")' /></td>
												
													
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="getFlight(orderid)" /></td>
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="getFlighttime(orderid)" /></td>
													
													<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="price" /></td>
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>												
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="converNull(airportfee,0f)+converNull(fuelprice,0f)+converNull(anjianfee,0f)+converNull(Otherfee,0f)" /></td><!-- 税 -->
													<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="getInsurancPrice(converNull(insurance,0l))" /></td>
													<!-- 总计 -->
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="haiqian" /></td>
													
											<!-- 	<td class="table_color"
													style="text-align: left; padding-left: 5px"
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>>
												<ww:if test="hkstate==3">
                                                              总：<ww:property
														value="price" />，待还：<ww:property value="haiqian" />
												</ww:if> <ww:else>总：<ww:property value="price" />
												</ww:else></td>-->

												<td class="table_color"
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>>
												<ww:property value="getpassstate(state)" /></td>
												<td class="table_color"
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:if
													test="hkstate==1 || hkstate==null">未还款</ww:if> <ww:if
													test="hkstate==2">已还款</ww:if> <ww:if test="hkstate==3">还款部分</ww:if>
												</td>
										</ww:iterator>

									</tbody>
									<!-- 记录查询条件 -->
									<input type="hidden" name="agentid" value='<ww:property value="agentid"/>' />
									<input type="hidden" name="s_department" value="<ww:property value="s_department"/>" />
									<input type="hidden" name="username" value="<ww:property value="username"/>" />
									<input type="hidden" name="s_begintime" value="<ww:property value="s_begintime"/>" />
						            <input type="hidden" name="s_endtime"   value="<ww:property value="s_endtime"/>" />
									<input type="hidden" name="flight_begintime" value="<ww:property value="flight_begintime"/>" />
						            <input type="hidden" name="flight_endtime"   value="<ww:property value="flight_endtime"/>" />
						            <input type="hidden" name="s_ordername"   value="<ww:property value="s_ordername"/>" />
						            <input type="hidden" name="s_passengername"   value="<ww:property value="s_passengername"/>" />
						            <input type="hidden" name="s_internal" value="<ww:property value="s_internal"/>"/>
						            <input type="hidden" name="contains" value="<ww:property value="contains"/>"/>
						            <input type="hidden" name="s_ticketnum" value="<ww:property value="s_ticketnum"/>"/>
						            <input type="hidden" name="s_ordernum" value="<ww:property value="s_ordernum"/>"/>
									
								</table>
								<!-- 分页 -->
								<div style="text-align: center; width: 100%; padding-top: 10px;">
								<ww:property
									value='getPagetwo(pageinfo,"pageinfo","biguserprice!repayment.action","formticket")' /></div>
								</td>
							</tr>
						</table>
						</div>
						<!-- 记录其他分页 --> 
						<input type="hidden" name="pageother.pagenum" value="<ww:property value="pageother.pagenum"/>" /><!-- 记录退改签页码 -->
						<input type="hidden" name="pagezafei.pagenum"
							value="<ww:property value="pagezafei.pagenum"/>" /><!-- 记录杂费页码 -->
						<input class="hkallprice" type="hidden" name="hkallprice"
							value="<ww:property value="hkallprice"/>" /><!-- 记录所填总金额 -->
							 <input type="hidden" class="blanceyue" name="blanceyue" id="yu"
							value="<ww:property value="formatPaymoney(blanceyue)"/>" /><!-- 记录所剩金额 -->
						<input type="hidden" class="haveprofit" name="haveprofit"
							value="<ww:property value="haveprofit"/>" /><!-- 记录已还金额 -->
							 <input type="hidden" name="repayname" value="" />
						</td>
						</form>
					</tr>
					<!-- 退废改签 -->
					<tr>
						<td>
						<div id="id2" style="display: none">
						<form action="" name="formother" method="post">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" name="hktable" width="98%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th class="table_color" width="54" height="25">还款</th>
											
											<th class="table_color">订单编号</th>
											<th class="table_color">票号</th>
											<th class="table_color">联系人</th>
											<th class="table_color">预订人</th>
											<th class="table_color">乘机人</th>
										<!-- 航班号、航程 起飞日期、起飞时刻、机票价格、机建费、燃油费、总计、还款状态-->											
											<th class="table_color">航班号</th>											
											<th class="table_color">航程</th>
											<th class="table_color">航班时间</th>
											<th class="table_color">机票价格</th>
											<th class="table_color">税</th>
											<th class="table_color">退废改签费</th>
											<th class="table_color">保险</th>
											
											<th class="table_color">欠款总计</th>
											<th class="table_color">还款状态</th>
											<th class="table_color">机票状态</th>											
											
										<!-- 	<th class="table_color">订单编号</th>
											<th class="table_color">票号</th>
											<th class="table_color">联系人</th>
											<th class="table_color">预订人</th>
											<th class="table_color">乘机人姓名</th>
											<th class="table_color">证件号</th>
											<th class="table_color">航程</th>
											<th class="table_color">航班时间</th>
											<th class="table_color">手续费</th>
											<th class="table_color">需交费用</th>
											<th class="table_color">缴费状态</th>
											<th class="table_color">机票状态</th>-->
										</tr>
										<ww:iterator value="otherlistPassenger" status="state">

											<tr id="t<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color">
												<input type="checkbox" <ww:if test='havechecked(id)'>checked="checked"</ww:if>
													<ww:if test="hkstate==2"> disabled="disabled"</ww:if>
													id="<ww:property value="id"/>" name="orderid"
													value="<ww:property value="id"/>"
													onclick="checkprice('<ww:property value="haiqian" />','<ww:property value="id"/>','<ww:property value="state"/>',this);" />
												</td>
												<td class="table_color">
								             	<a target="_blank" href='orderinfo!toshowb2c.action?id=<ww:property value="orderid"/>'
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==2">style="color:#0356A6"</ww:if> >
													<ww:property value="getordercode(orderid)" /></a>
													</td>
												<td class="table_color"
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="ticketnum" /></td>
													
												  <td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="getlinkManName(orderid)" /></td>
													
													
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="getOrderName(orderid)" /></td>
													
													
													<td class="table_color"
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="name" /></td>
													
											
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value='getSegmentInfo(orderid,"getFlightnumber")' /></td>
												
													
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="getFlight(orderid)" /></td>
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="getFlighttime(orderid)" /></td>
														<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="price" /></td>
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>												
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="converNull(airportfee,0f)+converNull(fuelprice,0f)+converNull(anjianfee,0f)+converNull(Otherfee,0f)" /></td><!-- 税 -->
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property
													value="tuifee" /></td>
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="getInsuranceFeeById(converNull(insurance,0l))" /></td>
													<!-- 总计 -->
												<td class="table_color" <ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:property value="haiqian" /></td>
												<!-- 
												<td class="table_color"
													style="text-align: left; padding-left: 20px;
													<ww:if test="hkstate==1 || hkstate==null">color:#990000</ww:if>
													<ww:if test="hkstate==3">color:#999999</ww:if>"><ww:if
													test="hkstate==3">
														总：<ww:property value="haiqian+yihai" />，待还：<ww:property
														value="haiqian" />
												</ww:if><ww:else>
														总：<ww:property value="haiqian" />
												</ww:else></td>-->
												<td class="table_color"
													<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>><ww:if
													test="hkstate==1 || hkstate==null">未还款</ww:if> <ww:if
													test="hkstate==2">已还款</ww:if> <ww:if test="hkstate==3">还款部分</ww:if>
												</td>
												<td class="table_color"
												<ww:if test="hkstate==1 || hkstate==null">style="color:#990000"</ww:if>
													<ww:if test="hkstate==3">style="color:#999999"</ww:if>>
													<ww:property value="getpassstate(state)" /></td>
										</ww:iterator>

									</tbody>
										<!-- 记录查询条件 -->
									<input type="hidden" name="agentid" value='<ww:property value="agentid"/>' />
									<input type="hidden" name="s_department" value="<ww:property value="s_department"/>" />
									<input type="hidden" name="username" value="<ww:property value="username"/>" />
									<input type="hidden" name="s_begintime" value="<ww:property value="s_begintime"/>" />
						            <input type="hidden" name="s_endtime"   value="<ww:property value="s_endtime"/>" />
						            <input type="hidden" name="flight_begintime" value="<ww:property value="flight_begintime"/>" />
						            <input type="hidden" name="flight_endtime"   value="<ww:property value="flight_endtime"/>" />
						            <input type="hidden" name="s_ordername"   value="<ww:property value="s_ordername"/>" />
						            <input type="hidden" name="s_passengername"   value="<ww:property value="s_passengername"/>" />
						            <input type="hidden" name="s_internal" value="<ww:property value="s_internal"/>"/>
						            <input type="hidden" name="contains" value="<ww:property value="contains"/>"/>
						             <input type="hidden" name="s_ticketnum" value="<ww:property value="s_ticketnum"/>"/>
						            <input type="hidden" name="s_ordernum" value="<ww:property value="s_ordernum"/>"/>
									
								</table>
								<!-- 分页 -->
								<div style="text-align: center; width: 100%; padding-top: 10px;">
								<ww:property
									value='getPagetwo(pageother,"pageother","biguserprice!repayment.action","formother")' /></div>
								</td>
							</tr>
						</table>
						<input type="hidden" name="pageinfo.pagenum"
							value="<ww:property value="pageinfo.pagenum"/>" /> <input
							type="hidden" name="pagezafei.pagenum"
							value="<ww:property value="pagezafei.pagenum"/>" />
							 <input type="hidden" name="repayname" value="other" /> <input
							type="hidden" class="blanceyue" name="blanceyue"
							vaule="<ww:property value="formatPaymoney(blanceyue)"/><!-- 记录所余额 -->
						<input class="hkallprice" type="hidden" name="hkallprice" value="<ww:property value="hkallprice"/>" /><!-- 记录所填总金额 -->
						<input type="hidden" class="haveprofit" name="haveprofit"  value="<ww:property value="haveprofit"/>"/><!-- 记录已还金额 -->
						</form>
						
					</div>
						</td>
					</tr>
					<!--  -->
					<!-- 杂项费用 -->
					<tr>
						<td>
					<div id="id3" style=" display: none">
						<form action="" name="formzaxiang" method="post" >
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" name="hktable" width="98%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th class="table_color" width="54" height="25">还款</th>
											<th class="table_color">部门</th>
											<th class="table_color">联系人</th>
											<th class="table_color">旅客姓名</th>
											<th class="table_color" style=" width: 180px">费用</th>
											<th class="table_color">消费时间</th>
											<th class="table_color">备注</th>
											<th class="table_color">还款状态</th>

										</tr>
										<ww:iterator value="listMiscellaneous" status="state">
											<tr id="t<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td><input type="checkbox" <ww:if test='havechecked(id)'>checked="checked"</ww:if> <ww:if test="state==2"> disabled="disabled"</ww:if>
													id="z<ww:property value="id"/>"
													<ww:if test="price==null">disabled</ww:if> name="orderid"
													value="z<ww:property value="id"/>"
													onclick="checkprice('<ww:property value="haiqian" />','z<ww:property value="id"/>','<ww:property value="state"/>',this);" />
												</td>
												<td class="table_color"
												<ww:if test="state==1 || state==null">style="color:#990000"</ww:if>
													<ww:if test="state==3">style="color:#999999"</ww:if>><ww:property
													value="getDeptNameByID(department)"/></td>
												<td class="table_color"
												<ww:if test="state==1 || state==null">style="color:#990000"</ww:if>
													<ww:if test="state==3">style="color:#999999"</ww:if>><ww:property value="getusername(customerid)" /></td>
												<td class="table_color"
												<ww:if test="state==1 || state==null">style="color:#990000"</ww:if>
													<ww:if test="state==3">style="color:#999999"</ww:if>>
													<ww:property value="name" /></td>
												<td class="table_color" style="text-align: left; padding-left: 20px
												<ww:if test="state==1 || state==null">;color:#990000</ww:if>
													<ww:if test="state==3">;color:#999999</ww:if>">
													<ww:if test="state==3">
                                                              总：<ww:property value="price" />，待还：<ww:property value="haiqian" />
												</ww:if>
												<ww:else>总：<ww:property value="price" /></ww:else>
													</td>
												<td class="table_color"
												<ww:if test="state==1 || state==null">style="color:#990000"</ww:if>
													<ww:if test="state==3">style="color:#999999"</ww:if>><ww:property value="spenddate" /></td>
												<td class="table_color" style="text-align: left; padding-left: 20px
												    <ww:if test="state==1 || state==null">;color:#990000</ww:if>
													<ww:if test="state==3">;color:#999999</ww:if>"><ww:property value="description" /></td>
												<td class="table_color"
													<ww:if test="state==1 || state==null">style="color:#990000"</ww:if>
													<ww:if test="state==3">style="color:#999999"</ww:if>><ww:if
													test="state==1 ||state==null">未还款</ww:if> <ww:if
													test="state==2">已还款</ww:if> <ww:if test="state==3">还款部分</ww:if>
												</td>
											</tr>
										</ww:iterator>
											<!-- 记录查询条件 -->
									<input type="hidden" name="agentid" value='<ww:property value="agentid"/>' />
									<input type="hidden" name="s_department" value="<ww:property value="s_department"/>" />
									<input type="hidden" name="username" value="<ww:property value="username"/>" />
									<input type="hidden" name="s_begintime" value="<ww:property value="s_begintime"/>" />
						            <input type="hidden" name="s_endtime"   value="<ww:property value="s_endtime"/>" />
						            <input type="hidden" name="flight_begintime" value="<ww:property value="flight_begintime"/>" />
						            <input type="hidden" name="flight_endtime"   value="<ww:property value="flight_endtime"/>" />
						            <input type="hidden" name="s_ordername"   value="<ww:property value="s_ordername"/>" />
						            <input type="hidden" name="s_passengername"   value="<ww:property value="s_passengername"/>" />
						            <input type="hidden" name="s_internal" value="<ww:property value="s_internal"/>"/>
						            <input type="hidden" name="contains" value="<ww:property value="contains"/>"/>
						             <input type="hidden" name="s_ticketnum" value="<ww:property value="s_ticketnum"/>"/>
						            <input type="hidden" name="s_ordernum" value="<ww:property value="s_ordernum"/>"/>
									
									</tbody>
								</table>
								<!-- 分页 -->
								<div style="text-align: center; width: 100%; padding-top: 10px;">
								<ww:property value='getPagetwo(pagezafei,"pagezafei","biguserprice!repayment.action","formzaxiang")' /></div>
								</td>
							</tr>
						</table>
						<input  type="hidden" name="pageinfo.pagenum" value="<ww:property value="pageinfo.pagenum"/>" />
						<input  type="hidden" name="pageother.pagenum" value="<ww:property value="pageother.pagenum"/>" />
						<input  type="hidden" name="repayname" value="zafei"/>
						<input class="hkallprice" type="hidden" name="hkallprice" value="<ww:property value="hkallprice"/>" />
						<input type="hidden" class="blanceyue" name="blanceyue" vaule="<ww:property value="blanceyue"/>"/>
						<input type="hidden" class="haveprofit" name="haveprofit"  value="<ww:property value="haveprofit"/>"/><!-- 记录已还金额 -->
						</form>
					</div>
						</td>
					</tr>
					<!--  -->
				</table>
				</td>
			</tr>
			<tr>
				<td>
				<div
					style="text-align: center; width: 100%; height: 45px; padding-top: 10px;">

				<ww:if test="listPassenger.size()>0||otherlistPassenger.size()>0||listMiscellaneous.size()>0">
					<input type="button"  class="button_d font-bai" value="提交"
						onclick="sub();" />
				</ww:if> <input type="button" class="button_d font-bai"
					onclick="javascript:history.go(-1);" name="Submit2" value=" 返回 " /></div>
				</td>
			</tr>
		</table>

		</td>
	</tr>
</table>
</div>
<!--  -->

<div>
<form id="tw" name="tw" action="biguserprice!haikuan.action" method="post">
<input type="hidden" id="hk" name="hkuanprice" value=""/>
<input type="hidden" id='balance' name="balance"/> <!-- 余额 -->

<input type="hidden" id="thedeptid" name="s_department" value="<ww:property value="s_department"/>" />
<input type="hidden" id='balance' name="agentid" value="<ww:property value="agentid"/>"/> <!-- 大客户id -->
<input type="hidden" name="allhqprice" value="<ww:property value="arrearage"/>"/> <!--  欠款总金额-->
<input type="hidden" name="ptype" id="twptype"/><!-- 支付方式 -->
<input type="hidden" name="allprice" id="allprice"/><!-- 本次还款 -->
<input type="hidden" id="checkprice" value="<ww:property value="#session.repayprice"/>"/><!-- 记录每次点击订单所交费用 -->
<input type="hidden" id="checkid" value="<ww:property value="#session.pid"/>"/><!-- 记录每次点击订的id-->
<input type="hidden" id="bufenid" value="<ww:property value="#session.pid"/>"/><!-- 记录经处理的id -->

</form>
</div>
<div id="bg"><table border="0" width="100%" height="100%"><tr><td align="center" valign="middle"><img src="images/loadding.gif" /></td></tr></table></div>
</body>
<%=request.getAttribute("repayjs") %>
</html>
<script  type="text/javascript">
Ext.onReady(function(){
if(Ext.getDom("zong").value>0){
document.getElementById("zong").disabled="disabled";
 } 
}); 
</script> 
<script type="text/javascript">
function che(){
        $(".hkallprice").val($("#zong").val());	     
		var zong =document.getElementById("zong").value;
		$("#hk").val(zong);
		var yue =document.getElementById("yue").value;
			if(yue==''){
			yue=0.00;			
			}
	if(document.getElementById("zong").value!=''){
		document.getElementById("yu").value=parseInt(zong)+parseInt(yue);
		document.getElementById("hyu").value=document.getElementById("zong").value;		
		document.getElementById("hzong").value=document.getElementById("zong").value;

		
		}
		   $(".blanceyue").val($("#yu").val());	
	}

function checkprice(price,id,state,obj){
$("#bg").show();
if($("#zong").val().length>0)
  document.getElementById("zong").disabled="disabled";
  var bufen=false;
		var zong = document.getElementById("zong").value;//还金额
		var yu = document.getElementById("yu").value;//剩余
		var hai = document.getElementById("hai").value;//已还
		var yuvalue=parseInt(document.getElementById("yu").value);
		if(yuvalue>=0){//余额不是负数	
		if(document.all(id).checked==true){
		if(yuvalue==0){
		alert("所剩余额为0！");
		document.getElementById(id).checked=false;
		}else{
			if(parseInt(price)-parseInt(yu)>0&&yu>0&&state!=2){
	         	price=yu;
		        $("#hk").val(zong-price);
	         	bufen=true;
		        alert("所剩余额已不足，此订单将进行部分还款！");
		      }else if(parseInt(price)-parseInt(yu)>0&&yu>0&&state==2){
		      document.getElementById(id).checked=false;
		      alert("所剩余额已不足！");
		      return ;
		      }
		        $("#checkprice").val(price);
		        $("#checkid").val(id);
				var cid=id+"@"+price;
				if(bufen){
				  cid="b"+id+"@"+price;
				}				
				 $("#bufenid").val(id);
				jQuery.post("biguserprice!ajaxSaveCheckedPassenger.action",{passengerid:cid,isSave:"true"});							
					if(hai==''){
						document.getElementById("hai").value=parseInt(price);
						document.getElementById("hhai").value=parseInt(price);
						document.getElementById("yu").value=parseInt(yu)-parseInt(price);
						document.getElementById("hyu").value=parseInt(yu)-parseInt(price);
						}else{
						//alert("不是第一次.已还不为空");
						document.getElementById("hai").value=parseInt(hai)+parseInt(price);
						document.getElementById("hhai").value=parseInt(hai)+parseInt(price);
						document.getElementById("yu").value=parseInt(yu)-parseInt(price);
						document.getElementById("hyu").value=parseInt(yu)-parseInt(price);
						}	
					}			
				
				}else{
				 if(id==$("#checkid").val()){
				 price=$("#checkprice").val();
				 }
				 var cid=id+"@"+price;
				 if(id==$("#bufenid").val()){
				   cid="b"+id+"@"+price;
				 }
				 	jQuery.post("biguserprice!ajaxSaveCheckedPassenger.action",{passengerid:cid});	
						document.getElementById("yu").value=parseInt(yu)+parseInt(price);//取消时,余额增加
						document.getElementById("hyu").value=parseInt(yu)+parseInt(price);
							if(document.getElementById("hai").value==''){
							document.getElementById("hai").value=parseInt(price);
							document.getElementById("hhai").value=parseInt(price);
							}else{
							document.getElementById("hai").value=parseInt(hai)-parseInt(price);
							document.getElementById("hhai").value=parseInt(hai)-parseInt(price);
							}				
				}	
		
	}
	 $(".blanceyue").val($("#yu").val());//保存所剩余额
	 $(".hkallprice").val($("#zong").val());	//保存总费用
	 $(".haveprofit").val($("#hai").val());
	 $("#bg").hide();
		
}
	
	
	function toadd(){
		window.location="passenger!toadd.action?<ww:property value="url"/>";
	}
	function seh(){
		document.form1.submit();
		
	}
	function chkCheckBoxChs(objNam){ 
	var obj = document.getElementsByName(objNam); 
	var objLen= obj.length; 
	var objYN; 
	var i;
	objYN=false;
	for (i = 0;i< objLen;i++){
	if (obj [i].checked==true) {
	objYN= true;
	break;
	}
	}
	return objYN;	
	}

	
	
function sub(){
	//var obj = document.getElementsByName("orderid");
	if(document.getElementById("zong").value==''){
	alert("请输入还款数目!");
	return;
	}
	 if(chkCheckBoxChs("orderid")== false){
	alert("请至少选择一项");
	return;
	}
	$("#balance").val($("#yu").val());
	$("#twptype").val($("#ptype").val());
	$("#allprice").val($("#hai").val());
	dispose('系统正在处理您的操作');
	document.tw.submit();
		
	}
	
	
function load() {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
function colsedispose(){
 Ext.MessageBox.hide();
}
</script>