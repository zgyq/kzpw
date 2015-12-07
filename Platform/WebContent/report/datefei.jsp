<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>当日作废报表</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
		<script src="js/jquery1.3.2.js"></script>
	<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

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
            comboxWithTree.collapse();  
            
       });  
    
	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().expandChildNodes();
			
		});

	
    comboxWithTree.render('comboxWithTree');  
	


});
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
                text    : 'OK',
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
			class="anse">&nbsp;&nbsp;&nbsp;当日作废报表</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id="form1" method="post"
			action="airreport!datefei.action">
			<input type="hidden" name="is_first" />
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center"margin-bottom:4px;">
			<tr>
				<td valign="top"><input type="hidden" name="notoday"
					value="<ww:property value="notoday"/>" />
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">
									<tr>
										<td  align="right">出票人：</td>
										<td width=""><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 120px" name="s_chuname"
											value="<ww:property value="s_chuname"/>" /></span></td>
										<td width=""  align="right">联系人：</td>
										<td width=""><span style="HEIGHT: 71px"><input
											id="s_linkname" style="WIDTH: 120px" name="s_linkname"
											value="<ww:property value="s_linkname"/>" /></span></td>
										<td align="right">预订人：</td>
										<td><input name="s_ordername"
											value="<ww:property value="s_ordername"/>"
											style="width: 120px" /></td>
										<td align="right">退废票人：</td>
										<td><input name="s_tfname"
											value="<ww:property value="s_tfname"/>"></input>
									</tr>
									<tr>
										<td  align="right">乘机人：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 120px" name="s_ticketname"
											value="<ww:property value="s_ticketname"/>" /></span></td>
										<td  align="right">票号：</td>
										<td><span style="HEIGHT: 71px"><input id="piaohao"
											style="WIDTH: 120px" name="piaohao"
											value="<ww:property value="piaohao"/>" /></span></td>
										<td align="right">机票类型：</td>
										<td><select name="tickettype" style="width:120px">
											<option value="0"></option>
											<ww:iterator value="listtickettype">
												<option value="<ww:property value="id"/>"
													<ww:if test="tickettype==id">selected="selected"</ww:if>><ww:property
													value="typename" /></option>
											</ww:iterator>
										</select></td>

										<td  align="right">出票日期：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="cptime" style="WIDTH: 130px" name="s_begintime"
											value="<ww:property value="s_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'cpendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="cpendtime" style="WIDTH: 130px" name="s_endtime"
											value="<ww:property value="s_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cptime\',{d:+31});}',minDate:'#F{$dp.$D(\'cptime\',{d:+0});}'})" class="Wdate" /></span></td>

									</tr>
									<tr>
										<td  align="right">订单编号：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 120px" name="s_ordernum"
											value="<ww:property value="s_ordernum"/>" /></span></td>
										<td  align="right">航班：</td>
										<td><span style="HEIGHT: 71px"><input id="piaohao"
											style="WIDTH: 120px" name="s_flight"
											value="<ww:property value="s_flight"/>" /></span></td>
										<td align="right">舱位：</td>
										<td><input name="s_cabin" style="WIDTH: 120px"
											value="<ww:property value="s_cabin"/>" /></td>
										<td  align="right">退票日期：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="tptime" style="WIDTH: 80px" name="t_begintime"
											value="<ww:property value="t_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'tpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'tpendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="tpendtime" style="WIDTH: 80px" name="t_endtime"
											value="<ww:property value="t_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'tptime\',{d:+31});}',minDate:'#F{$dp.$D(\'tptime\',{d:+0});}'})" class="Wdate" /></span></td>
									</tr>
									<tr>

										<td align="right">支付方式：</td>
										<td><select name="s_paymethod" style="width: 120px">
											<option value="-1"
												<ww:if test="s_paymethod==-1">selected="selected"</ww:if>></option>
										<ww:iterator value="getPaymethodMap()" >
							             <option value="<ww:property value="key"/>" <ww:if test="s_paymethod==key">selected="selected"</ww:if> ><ww:property value="value"/></option>
							             </ww:iterator>
										</select></td>

										<td align="right">付款方式：</td>
										<td><select name="fkmethod" style="width: 120px">
											<option value='-1'
												<ww:if test="fkmethod==1">selected="selected"</ww:if>></option>
											<ww:iterator value="getFkmethodMaP()">
													<option value='<ww:property value="key"/>'
												<ww:if test="fkmethod==key">selected="selected"</ww:if>><ww:property value="value"/></option>
												</ww:iterator>
										</select></td>
										<td align="right">客户类型：</td>
										<td><select name="custype" style="width: 120px">
											<option value="0"
												<ww:if test="custype==0">selected="selected"</ww:if>>所有</option>
											<option value="1"
												<ww:if test="custype==1">selected="selected"</ww:if>>大客户</option>
											<option value="2"
												<ww:if test="custype==2">selected="selected"</ww:if>>所有散客</option>
											<option value="3"
												<ww:if test="custype==3">selected="selected"</ww:if>>当月散客</option>
											<option value="4"
												<ww:if test="custype==4">selected="selected"</ww:if>>非当月散客</option>
											<option value="5"
												<ww:if test="custype==5">selected="selected"</ww:if>>所有分销商</option>
										</select></td>
										<td  align="right">废票日期：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="fptime" style="WIDTH: 80px" name="f_begintime"
											value="<ww:property value="f_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'fpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'fpendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="tpendtime" style="WIDTH: 80px" name="f_endtime"
											value="<ww:property value="f_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'fptime\',{d:+31});}',minDate:'#F{$dp.$D(\'fptime\',{d:+0});}'})" class="Wdate" /></span></td>
									</tr>
									<tr>
									<td align="right">退废票状态：</td>
										<td><select name="tfstate" style="width: 120px">
											<option value="0"
												<ww:if test="tfstate==0">selected="selected"</ww:if>></option>
											<option value="3"
												<ww:if test="tfstate==3">selected="selected"</ww:if>>已退票未退款</option>
											<option value="2"
												<ww:if test="tfstate==2">selected="selected"</ww:if>>已废票未退款</option>
											<option value="3"
												<ww:if test="tfstate==17">selected="selected"</ww:if>>已退票退款</option>
											<option value="2"
												<ww:if test="tfstate==16">selected="selected"</ww:if>>已废票退款</option>
										</select></td>
									<td align="right">退废票类型：</td>
										<td><select name="tftype" style="width: 120px">
											<option value="0"
												<ww:if test="tftype==0">selected="selected"</ww:if>></option>
											<option value="1"
												<ww:if test="tftype==1">selected="selected"</ww:if>>自愿</option>
											<option value="2"
												<ww:if test="tftype==2">selected="selected"</ww:if>>非自愿</option>
										</select></td>
									<td width="120" height="20" align="right">&nbsp;类&nbsp;型：</td>
										<td>										
										<select name="s_internal" style="width:120px">
										<option value="-1" <ww:if test="s_internal==-1">selected=selected</ww:if>></option>
										<option value="0" <ww:if test="s_internal==0">selected=selected</ww:if> >国内票</option>
										<option value="1" <ww:if test="s_internal==1">selected=selected</ww:if>>国际票</option>
										</select>
										</td>
										<td  align="right">部&nbsp;&nbsp;&nbsp;&nbsp;门：</td>
										<td colspan="7">
										<div id='comboxWithTree'></div>
										<input type="hidden" id="parentid" name="s_department"
											value='<ww:property value="s_department"/>' /></td>

									</tr>
									<tr class="font-blue-xi">
										<td height="10" colspan="10" align="right"></td>
									</tr>
									<tr>
										<td align="center" height="58" colspan="10"><input
											type="button"
											onclick="document.form1.action='airreport!datefei.action';dispose('系统正在为您查询');document.form1.submit();"
											class="button_d font-bai" value="查询" />&nbsp;&nbsp;&nbsp; <input
											type="button"
											onclick="document.form1.action='airreport!expDateFeiExcel.action';expexcel();document.form1.submit();"
											class="button_d font-bai" value="导出" /></td>

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


								<table id="menutable" width="99%" border="0" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th class="table_color">订单号</th>
											<th class="table_color">票号</th>
											<th class="table_color">PNR</th>
											<th class="table_color">乘机人</th>											
											<th class="table_color">航班</th>
											<th class="table_color">支付方式</th>
											<th class="table_color">付款方式</th>
											<th class="table_color">票面金额</th>
											<th class="table_color" style="width: 20px;">税</th>
											<th class="table_color" style="width: 50px;">实际支付金额</th>
											<th class="table_color" style="width: 50px;">退票手续费</th>
											<th class="table_color" style="width: 50px;">东航实际退票金额</th>
											<th class="table_color" style="width: 50px;">客户实际退票金额</th>
											<th class="table_color">退票状态</th>
											<th class="table_color">退票类型</th>
											<th class="table_color">退款状态</th>
											<th class="table_color">退费审核人</th>
											<th class="table_color">出票日期</th>
											<th class="table_color">出票人</th>
										</tr>
										<ww:set name="realprice" value="0" />
										<ww:iterator value="datefeilist">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
												onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
												<!-- <td class="table_color"><ww:property value="getjiaoyicode(getcode(orderid))"/></td>-->
												<td class="table_color"><ww:property
													value="C_ORDERNUMBER" /></td>
												<!-- 订单号 -->
												<td class="table_color"><ww:property
													value="C_TICKETNUM" /></td>
												<td class="table_color"><ww:property
													value="getpnr(C_PNR,C_BIGPNR)" /></td>
												<td class="table_color"><ww:property value="C_NAME" /></td>
												<td class="table_color"><ww:property
													value="hangbanhao" /></td>
												<td class="table_color"><ww:property
													value="getPayMethodStr(C_PAYMETHOD)" /></td>
												<!-- 支付方式 -->
												<td class="table_color"><ww:property
													value="getFkmethodstr(converNull(C_FKMETHOD,0))" /></td>
												<!-- 付款方式 -->
												<td class="table_color"><ww:property value="C_PRICE" /></td>
												<!-- 票面金额 -->
												<td class="table_color"><ww:property value="DUTY" /></td>
												<!-- 税 -->
												<td class="table_color"><ww:property
													value="converNull(C_YIHAI,0)" /></td>
												<ww:set name="realprice"
													value="#realprice+converNull(C_YIHAI,0)" />
												<ww:set name="tfprice"
													value="#tfprice+converNull(C_TUIFEE,0)" />

												<!-- 实际支付 -->
												<td class="table_color"><ww:property
													value="converNull(C_TUIFEE,0)" /></td>
												<td class="table_color">&nbsp;</td>
												<!-- 东航实际退票金额-->
												<td class="table_color">&nbsp;</td>
												<!-- 客户实际退票金额-->
												<td class="table_color"><ww:property
													value="getpassstate(C_STATE)" /></td>
												<!-- 退票状态-->
												<td class="table_color"><ww:if test="C_TUIFEIYUANYI==1">自愿</ww:if>
												<ww:if test="C_TUIFEIYUANYI==2">非自愿</ww:if> <!-- 退票类型-->
												<td class="table_color"><ww:property
													value="getTuiKuanState(C_ORDERID)" /></td>
												<!-- 退款状态 -->


												<td class="table_color"><ww:property
													value="getTuiFeiName(C_ORDERID)" /></td><!--退票人  -->
												<td class="table_color"><ww:property
													value="C_PRINTTIME" /></td>
												<td class="table_color"><ww:property
													value="getInsurName(C_ORDERID,3)" /></td>
											</tr>
										</ww:iterator>
										<ww:if test="datefeilist.size>0">
											<tr>
												<td class="table_color">小计:</td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"><ww:property
													value="formatMoney(pricegather)" /></td>
												<td class="table_color"><ww:property
													value="formatMoney(dutygather)" /></td>
												<td class="table_color"></td>
												<td class="table_color"><ww:property
													value="formatMoney(tuifeegather)" /></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color">&nbsp;</td>

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
			  <ww:property value='getPagetwo(pageinfo,"pageinfo","airreport!datefei.action","form1")' />
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
		var fname = oXL.Application.GetSaveAsFilename("非当日作废.xls", "Excel Spreadsheets (*.xls), *.xls");
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





