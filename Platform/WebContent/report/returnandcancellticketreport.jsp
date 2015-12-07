<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>退废票报表</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
	<script src="js/jquery1.3.2.js"></script>
	<script src="js/PublicJs.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>

<script>

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
function expajax(){
setTimeout('expExcelDengdai()',3000)
}
function expExcelDengdai(){
colsedispose();
}
</script>
<script language=javascript>
function Cleanup() {
    window.clearInterval(idTmr);

    CollectGarbage();
  }
 
 function clearInsurTime(){
  var val=Ext.getDom("ticketstate").value;
  if(val==2){
   Ext.get('insurtime').set({value:""});
   Ext.get("insurtimeend").set({value:""});
   }
 }
 

function expexcel() {
    var win = new Ext.Window({
        height      : 100,
        width       : 350,
        modal       : true,
        title       : '提醒',
        html        : '<br>系统正在生成Excel,未导出之前请勿关闭.....</br>',
        plain       : true,
        border      : true,
        resizable   : false,
        draggable   : false,
        closable    : false,
        buttonAlign : 'center',
        buttons     : [
            {
                text    : 'CLOSE',
                handler : function() {
                    win.close();
                }
            }
        ]
    })
    win.show();
}
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;<ww:if test="18">退票报表</ww:if><ww:else>废票报表</ww:else></b></td>
	</tr>
	<tr>
		<td valign="top">




		<form name="form1" id="form1" method="post" action="airreport!chupiao.action">
		<input type="hidden" name="is_first" />
		<input type="hidden" name="tftype" value='<ww:property value="tftype"/>' />
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center"margin-bottom:4px;">

			<tr>
				<td valign="top">
				
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">
						
									<tr>
									<ww:if test="getLoginsessionagent().agenttype==2">
									<td align="right">出票人：</td>
										<td width=""><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 100px" name="s_chuname"
											value="<ww:property value="s_chuname"/>" /></span></td>
									</ww:if>
									<ww:else>
										<td align="right">预订人：</td>
										<td><input name="s_ordername"
											value="<ww:property value="s_ordername"/>"
											style="width: 100px" /></td>
									</ww:else>
										<td align="right">乘机人：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_ticketname"
											value="<ww:property value="s_ticketname"/>" /></span></td>
										<td align="right">申请人：</td>
										<td><input style="WIDTH: 100px" name="sqname" value="<ww:property value="sqname"/>" /></td>
										<td height="30" align="right">申请日期：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="sqtime" style="WIDTH: 80px" name="sq_begintime"
											value="<ww:property value="sq_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'sqendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'sqendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="sqendtime" style="WIDTH: 80px" name="sq_endtime"
											value="<ww:property value="sq_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'sqtime\',{d:+31});}',minDate:'#F{$dp.$D(\'sqtime\',{d:+0});}'})" class="Wdate" /></span></td>
									</tr>
									<tr>										
										
										<td align="right">航空公司：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_airname"
											value="<ww:property value="s_airname"/>" /></span></td>
										<td align="right">舱位：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_cabin"
											value="<ww:property value="s_cabin"/>" /></span></td>
										<td align="right">审核人：</td>	
											<td><input name="shname" value="<ww:property value="shname"/>" style="WIDTH: 100px" /></td>
										<td height="30" align="right">审核日期：</td>
										<td ><span style="HEIGHT: 71px"> <input
											id="shtime" style="WIDTH: 80px" name="sh_begintime"
											value="<ww:property value="sh_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'shendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'shendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="shendtime" style="WIDTH: 80px" name="sh_endtime"
											value="<ww:property value="sh_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'shtime\',{d:+31});}',minDate:'#F{$dp.$D(\'shtime\',{d:+0});}'})" class="Wdate" /></span></td>
										
									</tr>
									<tr>
										<td align="right">票号：</td>
										<td><span><input id="piaohao"
											style="WIDTH: 100px" name="piaohao"
											value="<ww:property value="piaohao"/>" /></span></td>
										<td align="right">退款人：</td>
										<td><input style="WIDTH: 100px" name="tkname" value="<ww:property value="tkname"/>" /></td>
										<td height="30" align="right">退款日期：</td>
										<td colspan="4"><span style="HEIGHT: 71px"> <input
											id="tktime" style="WIDTH: 80px" name="tk_begintime"
											value="<ww:property value="tk_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'tkendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'tkendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="tkendtime" style="WIDTH: 80px" name="tk_endtime"
											value="<ww:property value="tk_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'tktime\',{d:+31});}',minDate:'#F{$dp.$D(\'tktime\',{d:+0});}'})" class="Wdate" /></span></td>
										

											</tr>
									<tr class="font-blue-xi">
										<td height="10" colspan="10" align="right"></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="58" colspan="10" align="center"><input
											type="button" class="button_d font-white"
											value="查&nbsp;&nbsp;询"
											onclick="document.form1.action='airreport!chupiao.action';dispose('系统正在为您查询');document.form1.submit();" />
										<input type="button" class="button_d font-white"
											value="导出excel"
											onclick="document.form1.action='airreport!expTFpiaoExcel.action';expexcel();document.form1.submit();" /></td>
									</tr>
								</table>
								</td>
							</tr>

						</table>
						</td>
					</tr>
					<tr>
						<td valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							id="tbdeptsale" cellspacing="0">
							<tr>
								<td width="100%">


								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<!--
											订单编号、票号、PNR、乘机人、航空公司、航班号、航班日期、出发城市、目的城市、舱位、单张票价、单张税费、支付方式、付款方式
											 <th class="table_color">机票状态</th>
										    -->

											<th class="table_color">订单号</th>
											<th class="table_color">采购</th>
											<th class="table_color">PNR</th>
											<th class="table_color">乘机人</th>
											<th class="table_color">票号</th>
											<th class="table_color">航班号</th>
											<th class="table_color">航班日期</th>
											<th class="table_color">航程</th>
											<th class="table_color">舱位</th>
											<!-- <th class="table_color">票价</th>
											<th class="table_color">税费</th> -->
											<th class="table_color">实付款</th>
											<th class="table_color">手续费</th>
											<th class="table_color">退款金额</th>
											<th class="table_color">机票状态</th>



										</tr>
										<ww:iterator value="listPassenger">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
												onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
												<td class="table_color"><ww:property
													value="C_ORDERNUMBER" /></td>
								
												<td class="table_color"><ww:property value="C_AGENTCOMPANYNAME" /></td>
												<td class="table_color"><ww:property
													value="getpnr(C_PNR,C_BIGPNR)" /></td>
												<td class="table_color"><ww:property value="PASSENGERS" /></td>
												<td class="table_color"><ww:property value="TICKETNUMBERS" /></td>
											
											
												<td class="table_color"><ww:property
													value="C_FLIGHTNUMBER" /></td>
												<td class="table_color"><ww:property
													value="C_DEPARTTIME" /></td>
												<td class="table_color"><ww:property
													value="AIRFLIGHT" /></td>
												<td class="table_color"><ww:property
													value="C_CABINCODE" /></td>
											<!--  	<td class="table_color"><ww:property value="C_PARVALUE" /></td>
												 单张票价 
												<td class="table_color"><ww:property value="DUTY" /></td>-->
												<td class="table_color"><ww:property value="C_TOTALTICKETPRICE+DUTY+converNull(INSURANCEPRICE,0)" /></td>

												<td class="table_color"><ww:property
													value="SHOUXUFEI" /></td><!-- 手续费 -->
												<td class="table_color"><ww:property
													value="C_RETURNPRICE" /></td>

												<td class="table_color"><ww:property
													value="getOrderStatestr(C_ORDERSTATUS)" /></td>
											</tr>
										</ww:iterator>
										<ww:if test="0>1">
											<tr>
												<td class="table_color" colspan="2" style="text-align: left;">
												<b>小计:</b> 订单数：<ww:property value="ordercount"/>.&nbsp;总票数：<ww:property value="ticketcount"/></td>
											
												<td class="table_color"></td>

												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"><ww:property
													value="formatMoney(pricegather)" /></td>
												<td class="table_color"><ww:property value="formatMoney(dutygather)" /></td>
												<td class="table_color"><ww:property value="formatMoney(tuifeegather)" /></td>
												<td class="table_color"><ww:property value="formatMoney(pricegather+dutygather-tuifeegather)" /></td>
												<td class="table_color"></td>
											</tr>
										</ww:if>


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
		<div style="text-align: center; width: 100%; padding-top: 10px;">
			  <ww:property value='getPagetwo(pageinfo,"pageinfo","airreport!chupiao.action","form1")' />
		   </div>
		</form>


		</td>
	</tr>
</table>
</div>
</body>
</html>	

<script language=javascript>
	function importExcel22() { 
	window.clipboardData.setData("Text",document.all('tbdeptsale').outerHTML);
	try
	{
	var ExApp = new ActiveXObject("Excel.Application")
	var ExWBk = ExApp.workbooks.add()
	var ExWSh = ExWBk.worksheets(1)
	ExApp.DisplayAlerts = false
	ExApp.visible = true
	}  
	catch(e)
	{
	alert(e);
	alert("您的电脑没有安装Microsoft Excel软件！")
	return false
	} 
	 ExWBk.worksheets(1).Paste;	
	 }
function importExcel(tableid) {//整个表格拷贝到EXCEL中 

    var curTbl = document.getElementById(tableid); 
    var oXL = new ActiveXObject("Excel.Application"); 
    //创建AX对象excel 
    var oWB = oXL.Workbooks.Add(); 
    //获取workbook对象 
    var xlsheet = oWB.Worksheets(1);
    //激活当前sheet 
    var sel = document.body.createTextRange(); 
    sel.moveToElementText(curTbl); 
    //把表格中的内容移到TextRange中 
    sel.select(); 
    //全选TextRange中内容 
    sel.execCommand("Copy"); 
    //复制TextRange中内容  
    xlsheet.Paste(); 
    //粘贴到活动的EXCEL中       
    oXL.Visible = false
    //设置excel可见属性 
	try{
		var fname = oXL.Application.GetSaveAsFilename("出票报表.xls", "Excel Spreadsheets (*.xls), *.xls");
		if(fname){
			oWB.SaveAs(fname);
		}
	}catch(e){
		print("Nested catch caught " + e);
	}finally{
		
		oWB.Close(savechanges=false);
		oXL.Quit();
		oXL=null;
		 //结束excel进程，退出完成
		idTmr = window.setInterval("Cleanup();",1);


	}
} 
function Cleanup() {
    window.clearInterval(idTmr);

    CollectGarbage();
  }
</script>




