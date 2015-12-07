<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出票报表</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<ww:if test="getLoginsessionagent().agenttype==1">
<script>
Ext.onReady(function(){ 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,         
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:140,
	   tpl: "<tpl for='.'><div style='height:240px ; width:140px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  
	<ww:property value="#request.agentroot"/>	
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue('<ww:property value="customeragent.agentcompanyname"/>');
       tree.on('click',function(node){   
           
             comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            Ext.get('agentnameid').set({value:node.text});
            comboxWithTree.collapse();              
       });     	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().collapseChildNodes();//是否展开子菜单			
		});
	
    comboxWithTree.render('comboxWithTree'); 
});
</script>
</ww:if>
<script>
function expexcel() {
    var win = new Ext.Window({
        height      : 100,
        width       : 350,
        modal       : true,
        title       : '提醒',
        html        : '<br>    系统正在生成Excel,未导出之前请勿关闭.....</br>',
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
<script language=javascript>
	var idTmr ; 
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
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;出票报表</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			action="airreport!chupiao.action"><input type="hidden"
			name="is_first" />
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center"margin-bottom:4px;">

			<tr>
				<td valign="top">

				<table width="1400px" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="1400px" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
								<table width="1300px" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">
						
									<tr>
									<td width="" align="right">订单号：</td>
										<td width=""><span><input id="s_ordernum"
											style="WIDTH: 100px" name="s_ordernum"
											value="<ww:property value="s_ordernum"/>" /></span></td>
										<td align="right">PNR：</td>
										<td><span> <input
											style="WIDTH: 100px" name="s_pnr"
											value="<ww:property value="s_pnr"/>" /></span></td>
										
										<td align="right">出票人：</td>
										<td width=""><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 100px" name="s_chuname"
											value="<ww:property value="s_chuname"/>" /></span></td>
										<td height="30" align="right">出票时间：</td>
										<td ><span style="HEIGHT: 71px"> <input
											id="cptime" style="WIDTH: 135px" name="s_begintime"
											value="<ww:property value="s_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'cpendtime\',{d:-31});}'})"
											class="Wdate" />- <input id="cpendtime" style="WIDTH: 135px"
											name="s_endtime" value="<ww:property value="s_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cptime\',{d:+31});}',minDate:'#F{$dp.$D(\'cptime\',{d:+0});}'})"
											class="Wdate" /></span></td>
										
									
									<!-- 
										<td align="right">预订人：</td>
										<td><input name="s_ordername"
											value="<ww:property value="s_ordername"/>"
											style="width: 100px" /></td>
										<td height="30" align="right">预订时间：</td>
										<td colspan="3"><span style="HEIGHT: 71px"> <input
											id="cptime" style="WIDTH: 135px" name="orderstime"
											value='<ww:property value="orderstime"/>'
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'cpendtime\',{d:-31});}'})"
											class="Wdate" />- <input id="cpendtime" style="WIDTH: 135px"
											name="orderetime" value='<ww:property value="orderetime"/>'
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cptime\',{d:+31});}',minDate:'#F{$dp.$D(\'cptime\',{d:+0});}'})"
											class="Wdate" /></span></td>
									 -->
										
									</tr>
									<tr>
										<td align="right">票号：</td>
										<td><span><input id="piaohao" style="WIDTH: 100px"
											name="piaohao" value="<ww:property value="piaohao"/>" /></span></td>
										<!-- 	// 乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票 4=申请退票 5=申请废票 6=申请改签 7=退票失败 8=废票失败
		// 9=改签成功 10=改签失败 11已取消 12,13,14 -->
										<td align="right">航空公司：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_airname"
											value="<ww:property value="s_airname"/>" /></span></td>
										<td align="right">舱位：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_cabin"
											value="<ww:property value="s_cabin"/>" /></span></td>
										


									</tr>

									<tr>
									
										<td align="right">乘机人：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_ticketname"
											value="<ww:property value="s_ticketname"/>" /></span></td>
									<ww:if test="getLoginsessionagent().agenttype==1">
										<td align="right">客户名称：</td>
										<td><span style="HEIGHT: 71px">
										<table border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
												<div id='comboxWithTree' style=""></div>
												</td>
												<td><input type="hidden" id="agentnameid" 
													name="customeragent.agentcompanyname"
													value="<ww:property value="customeragent.agentcompanyname"/>" />
	                                              <input type="hidden" id="parentid" name="customeragent.id" value='<ww:property value="customeragent.id"/>'/>
											</td>
												<td><span class="font-red">&nbsp;&nbsp;&nbsp;</span></td>
											</tr>
										</table></td>
									</ww:if>
									<ww:else>
									<input type="hidden" name="customeragent.id" value='<ww:property value="getLoginsessionagent().id"/>'/>
									</ww:else>
									
									<td height="30" align="right">航班日期：</td>
										<td ><span style="HEIGHT: 71px"> <input
											id="flighttime" style="WIDTH: 80px" name="flight_begintime"
											value="<ww:property value="flight_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'flightendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'flightendtime\',{d:-31});}'})"
											class="Wdate" />- <input id="flightendtime"
											style="WIDTH: 80px" name="flight_endtime"
											value="<ww:property value="flight_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'flighttime\',{d:+31});}',minDate:'#F{$dp.$D(\'flighttime\',{d:+0});}'})"
											class="Wdate" /></span></td>
									</tr>
									<tr>
										<td colspan="10">
										<table border="0">
											<tr>


											</tr>
										</table>
										</td>
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
											onclick="document.form1.action='airreport!expChupiaoExcel.action';expexcel();document.form1.submit();" /></td>
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
											<th class="table_color" style="width: 100px">采购</th>
											<th class="table_color">PNR</th>
											<th class="table_color">乘机人</th>
											<th class="table_color">票号</th>
											<th class="table_color">航班号</th>
											<th class="table_color">航班日期</th>
											<th class="table_color">航程</th>											
											<th class="table_color">出票时间</th>
											<th class="table_color">票面价</th>
											<ww:if test="getLoginsessionagent().agenttype==1">
											<th class="table_color">返点</th>
											</ww:if>
									
										   <ww:if test="getLoginsessionagent().agenttype==1">
											 <th class="table_color">返利</th>
											</ww:if>
											<ww:else>
											 <th class="table_color">获利</th>
											</ww:else>
											<th class="table_color">税费</th>
											<th class="table_color">保险</th>
											<th class="table_color">采购支付</th>
											<ww:if test="getLoginsessionagent().agenttype==1">
											<th class="table_color">支付供应</th>
											</ww:if>
											
											<th class="table_color">机票状态</th>
										</tr>
										<ww:iterator value="listPassenger">
											<tr id='<ww:property value="id"/>' align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
												onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
												<td class="table_color"><ww:property
													value="C_ORDERNUMBER" /></td>
												<td class="table_color"><ww:property
													value="C_AGENTCOMPANYNAME" /></td>
												<td class="table_color"><ww:property
													value="C_PNR" /></td>

												<td class="table_color"><ww:property
													value="PASSENGERS" /></td>
												<td class="table_color"><ww:property value="TICKETNUMBERS" /></td>
					
												<!-- 航空公司 -->
												<td class="table_color"><ww:property value="C_FLIGHTNUMBER" /></td>
												<td class="table_color"><ww:property
													value="C_DEPARTTIME" /></td>
												<td class="table_color"><ww:property value="AIRFLIGHT" /></td>
												<td class="table_color"><ww:property value="C_PRINTTIME" /></td>
												
												<!-- 票面价 -->
												<td class="table_color"><ww:property value="C_PARVALUE" /></td>
												<!-- 返点 -->
												<ww:if test="getLoginsessionagent().agenttype==1">
												<td class="table_color"><ww:property value="C_RATEVALUE" /></td>
											    </ww:if>
												
												<td class="table_color">
												<ww:property value="getOrderRebateMoney(C_ORDERSTATUS)" />
												<!--
												<ww:property value="REBATEMONEY" />
												-->
												</td>
												<td class="table_color"><ww:property value="DUTY" /></td>
												<td class="table_color"><ww:property value="INSURANCEPRICE" /></td>

												<td class="table_color"><ww:property
													value="C_TOTALTICKETPRICE+DUTY+converNull(INSURANCEPRICE,0)" /></td>
										       <ww:if test="getLoginsessionagent().agenttype==1">
											  	<td class="table_color"><ww:property value="C_EXTORDERPRICE" /></td>
											   </ww:if>
												<td class="table_color"><ww:property
													value="getOrderStatestr(C_ORDERSTATUS)" /></td>

											</tr>
										</ww:iterator>
										<ww:if test="listPassenger.size>0">
											<tr>
												<td class="table_color" colspan="3"
													style="text-align: left;"><b>小计:</b> 
													订单数：<ww:property value="#request.gather.ORDERCOUNT" />&nbsp;

												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												
												<td class="table_color">
												<ww:property value="formatMoney(#request.gather.PARPRICE)" />
												</td>
										      <ww:if test="getLoginsessionagent().agenttype==1">
												<td class="table_color"></td>
												</ww:if>
												<td class="table_color"></td>
												<td class="table_color"><ww:property value="formatMoney(#request.gather.DUTYPRICE)" /></td>
												<td class="table_color"><ww:property value="formatMoney(#request.gather.INSURALLPRICE)" /></td>
												
	                                          <ww:if test="getLoginsessionagent().agenttype==1">
												<td class="table_color"></td>
										      </ww:if>
												<td class="table_color"></td>
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
		<ww:property
			value='getPagetwo(pageinfo,"pageinfo","airreport!chupiao.action","form1")' />
		</div>
		</form>


		</td>
	</tr>
</table>
</div>
</body>
</html>


<script language="JavaScript">
			
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




