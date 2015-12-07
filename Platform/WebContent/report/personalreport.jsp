<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出票报表</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
		<script src="js/jquery1.3.2.js"></script>
	<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>

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
          rootVisible:true
       });  

	
		comboxWithTree.setValue("<ww:property value="departname"/>");

       tree.on('click',function(node){  
           
           
             comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            comboxWithTree.collapse();  
            
       });  
    
	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			//tree.getRootNode().expand();  
			tree.getRootNode().collapseChildNodes();
			
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
function expajax(){
setTimeout('expExcelDengdai()',3000)
}
function expexcel() {
    var win = new Ext.Window({
        height      : 100,
        width       : 350,
        modal       : true,
        title       : '提醒',
        html        : '<br>    系统正在生成Excel,请勿反复点击.....</br>',
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
			class="anse">&nbsp;&nbsp;&nbsp;个人挂账还款报表</b></td>
	</tr>
	<tr>
		<td valign="top">




		<form name="form1" method="post" action="airreport!toPersonalAccountReport.action">
		<input type="hidden" name="is_first" />
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
								<table width="93%" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">
									<tr>
										<td align="right">出票人：</td>
										<td width=""><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_chuname"
											value="<ww:property value="s_chuname"/>" /></span></td>
										<td width="" align="right">联系人：</td>
										<td width=""><span><input id="s_linkname"
											style="WIDTH: 100px" name="s_linkname"
											value="<ww:property value="s_linkname"/>" /></span></td>
										<td align="right">预订人：</td>
										<td><input name="s_ordername"
											value="<ww:property value="s_ordername"/>"
											style="width: 100px" /></td>
										<td height="30" align="right">还款日期：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="hktime" style="WIDTH: 80px" name="h_begintime"
											value="<ww:property value="h_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'hkendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'hkendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="hkendtime" style="WIDTH: 80px" name="h_endtime"
											value="<ww:property value="h_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'hktime\',{d:+31});}',minDate:'#F{$dp.$D(\'hktime\',{d:+0});}'})" class="Wdate" /></span></td>
									
									</tr>
									<tr>
										<td align="right">挂账人：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_gzname"
											value="<ww:property value="s_gzname"/>" /></span></td>
										<td align="right">乘机人：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_ticketname"
											value="<ww:property value="s_ticketname"/>" /></span></td>
										<td align="right">票号：</td>
										<td><span><input id="piaohao" style="WIDTH: 100px"
											name="piaohao" value="<ww:property value="piaohao"/>" /></span></td>
										<!-- <td align="right">支付方式：</td>
										<td><select name="s_paymethod">
											<option value="-1"
												<ww:if test="s_paymethod==-1">selected="selected"</ww:if>></option>
											<option value="4"
												<ww:if test="s_paymethod==4">selected="selected"</ww:if>>无卡支付</option>
											<option value="5"
												<ww:if test="s_paymethod==5">selected="selected"</ww:if>>客户挂账</option>
											<option value="1"
												<ww:if test="s_paymethod==1">selected="selected"</ww:if>>在线支付</option>
											<option value="2"
												<ww:if test="s_paymethod==2">selected="selected"</ww:if>>门市付款</option>
											<option value="3"
												<ww:if test="s_paymethod==3">selected="selected"</ww:if>>票到付款</option>
											<option value="6"
												<ww:if test="s_paymethod==6">selected="selected"</ww:if>>柜台支付</option>
										</select></td>-->
										<td align="right">出票时间：</td>
										<td><span> <input id="cptime"
											style="WIDTH: 130px" name="s_begintime"
											value="<ww:property value="s_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'cpendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="cpendtime" style="WIDTH: 130px" name="s_endtime"
											value="<ww:property value="s_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cptime\',{d:+31});}',minDate:'#F{$dp.$D(\'cptime\',{d:+0});}'})" class="Wdate" /></span></td>
									</tr>
									<tr>
										<td align="right">退废票人：</td>
										<td><input name="s_tfname"
											value="<ww:property value="s_tfname"/>" style="width: 100px" /></td>
											<td align="right">订单编号：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="ordernum"
											value="<ww:property value="ordernum"/>" /></span></td>
										<!-- <td align="right">机票状态：</td>
										<td><select name="insurtype" style="width: 105px">

											<option value="-1"
												<ww:if test="insurtype==0">selected="selected"</ww:if>>所有</option>
											<option value="0"
												<ww:if test="insurtype==0">selected="selected"</ww:if>>未出票</option>
											<option value="1"
												<ww:if test="insurtype==1">selected="selected"</ww:if>>已出票</option>
											<option value="2"
												<ww:if test="insurtype==2">selected="selected"</ww:if>>已废票</option>
											<option value="3"
												<ww:if test="insurtype==3">selected="selected"</ww:if>>已退票</option>
											<option value="9"
												<ww:if test="insurtype==9">selected="selected"</ww:if>>已改签</option>
										</select></td>-->
										<!-- 	// 乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票 4=申请退票 5=申请废票 6=申请改签 7=退票失败 8=废票失败
		// 9=改签成功 10=改签失败 11已取消 12,13,14 -->
										<!-- <td align="right">机票类型：</td>
										<td><select name="tickettype">
											<option value="0"></option>
											<ww:iterator value="listtickettype">
												<option
													<ww:if test="tickettype==id">selected="selected"</ww:if>
													value="<ww:property value="id"/>"><ww:property
													value="typename" /></option>
											</ww:iterator>
										</select></td>-->
										
										<td height="30" align="right">是否付款：</td>
										<td>
										<select name="fkstate" style="width: 105px">
										<option value='0'
												<ww:if test="fkstate==0">selected="selected"</ww:if>></option>
										<option value='1'
												<ww:if test="fkstate==1">selected="selected"</ww:if>>未付款</option>
										<option value='2'
												<ww:if test="fkstate==2">selected="selected"</ww:if>>已付款</option>
										<option value='3'
												<ww:if test="fkstate==3">selected="selected"</ww:if>>部分付款</option>
										
										</select>
										</td>

										<!-- <td align="right">还款方式：</td>
										<td><select name="fkmethod">
											<option value='-1'
												<ww:if test="fkmethod==1">selected="selected"</ww:if>></option>
											<option value='1'
												<ww:if test="fkmethod==1">selected="selected"</ww:if>>现金</option>
											<option value='2'
												<ww:if test="fkmethod==2">selected="selected"</ww:if>>支票</option>
											<option value='3'
												<ww:if test="fkmethod==3">selected="selected"</ww:if>>建行POS</option>
											<option value='4'
												<ww:if test="fkmethod==4">selected="selected"</ww:if>>银联POS</option>
											<option value='5'
												<ww:if test="fkmethod==5">selected="selected"</ww:if>>免优票</option>
											<option value='6'
												<ww:if test="fkmethod==6">selected="selected"</ww:if>>里程券</option>
											<option value='7'
												<ww:if test="fkmethod==7">selected="selected"</ww:if>>个人挂账</option>
											<option value='8'
												<ww:if test="fkmethod==8">selected="selected"</ww:if>>月结挂账</option>
											<option value='9'
												<ww:if test="fkmethod==9">selected="selected"</ww:if>>网上支付</option>
											<option value='10'
												<ww:if test="fkmethod==10">selected="selected"</ww:if>>银行汇款</option>
										</select></td>-->
										<td align="right">退票日期：</td>
										<td><span> <input id="tptime"
											style="WIDTH: 80px" name="t_begintime"
											value="<ww:property value="t_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'tpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'tpendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="tpendtime" style="WIDTH: 80px" name="t_endtime"
											value="<ww:property value="t_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'tptime\',{d:+31});}',minDate:'#F{$dp.$D(\'tptime\',{d:+0});}'})" class="Wdate" /></span></td>
									</tr>
									<tr>
										<!-- <td align="right">订单编号：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="ordernum"
											value="<ww:property value="ordernum"/>" /></span></td>-->
										<td align="right">航班：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_flight"
											value="<ww:property value="s_flight"/>" /></span></td>
										<td align="right">舱位：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="s_cabin"
											value="<ww:property value="s_cabin"/>" /></span></td>
										<td width="120" height="20" align="right">&nbsp;类&nbsp;型：</td>
										<td>										
										<select name="s_internal" style="width:105px">
										<option value="-1" <ww:if test="s_internal==-1">selected=selected</ww:if>></option>
										<option value="0" <ww:if test="s_internal==0">selected=selected</ww:if> >国内票</option>
										<option value="1" <ww:if test="s_internal==1">selected=selected</ww:if>>国际票</option>
										</select>
										</td>
										<td height="30" align="right">废票日期：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="fptime" style="WIDTH: 80px" name="f_begintime"
											value="<ww:property value="f_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'fpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'fpendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="fpendtime" style="WIDTH: 80px" name="f_endtime"
											value="<ww:property value="f_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',maxDate:'#F{$dp.$D(\'fptime\',{d:+31});}',minDate:'#F{$dp.$D(\'fptime\',{d:+0});}'})" class="Wdate" /></span></td>
									</tr>
									<tr>
										<td align="right">部门：</td>
										<td>
										<div id='comboxWithTree'></div>
										<input type="hidden" id="parentid" name="s_department"
											value='<ww:property value="s_department"/>' /></td>
										

									</tr>
									<!--
								<tr>
								
								<td height="30" align="right">出票时间：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 80px" name="s_begintime"
											value="<ww:property value="s_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" />
										-
										<input
											id="startnum2" style="WIDTH: 80px" name="s_endtime"
											value="<ww:property value="s_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" /></span></td>
										<td width="184" height="30" align="right">出票时间：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 160px" name="s_name"
											value="<ww:property value="s_name"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate"/></span></td>
										<td width="129" height="40" align="right">出票员：</td>
										<td width="181"><span style="HEIGHT: 71px"><input
											id="startnum2" style="WIDTH: 160px" name="s_shenfz"
											value="<ww:property value="s_shenfz"/>" /></span></td>
									</tr>

									-->
									<tr class="font-blue-xi">
										<td height="10" colspan="10" align="right"></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="58" colspan="10" align="center"><input
											type="button" class="button_d font-white"
											onclick="document.form1.action='airreport!toPersonalAccountReport.action';dispose('系统正在为您查询');document.form1.submit();"
											value="查&nbsp;&nbsp;询" /> <input type="button"
											class="button_d font-white" value="导出Excel"
											onclick="document.form1.action='airreport!expPersonalAccountReportExcel.action';expexcel();document.form1.submit();" /></td>
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
											<!-- 	部门、票号、乘客姓名、航空公司、航班号、出发城市、目的城市、起飞日期、起飞时刻、机票价格、机建费、燃油费、退票费、总价、出票日期、机票状态、是否付款-->
											<th class="table_color">部门</th>
											<!-- <th class="table_color">订单号</th>-->
											<th class="table_color">票号</th>
											<th class="table_color">乘客姓名</th>
											<th class="table_color">航空公司</th>
											<th class="table_color">航班号</th>
											<th class="table_color">航程</th>
										
											<th class="table_color">起飞日期</th>
											<th class="table_color">机票价格</th>
											<th class="table_color">税</th>											
											<th class="table_color">保险</th> 
											<th class="table_color">总价</th>
											<th class="table_color">出票日期</th>
											<th class="table_color">机票状态</th>
											<th class="table_color">挂账人</th>
											<!-- <th class="table_color">实际结帐</th>-->
											<th class="table_color">是否付款</th>
										</tr>
										<ww:iterator value="listbigreport" status="pa">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
												onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
												<td class="table_color"><ww:property
													value="AGENTNAME" /></td>
											
												<td class="table_color"><ww:property
													value="C_TICKETNUM" /></td>
												<td class="table_color"><ww:property value="C_NAME" /></td>
												<td class="table_color"><ww:property
													value="hangkonggongsi" /></td>
												<td class="table_color"><ww:property
													value="hangbanhao" /></td>
												<td class="table_color"><ww:property
													value="citypair" /></td>

						
												<td class="table_color"><ww:property
													value="chufashijian" /></td>
												<td class="table_color"><ww:property value="C_PRICE" /></td>
											
												<td class="table_color"><ww:property
													value="DUTY" /></td>
												<td class="table_color"><ww:property
													value='INSURFEE' /></td><!-- 保险 -->
												<td class="table_color"><ww:property
													value="converNull(C_PRICE,0)+DUTY" /></td>
												<!-- 总价 -->
												<!-- <td class="table_color"><ww:property value="0" /></td>-->
												<!-- <td class="table_color">
											
												<ww:property value="converNull(C_YIHAI,0.0)" />
												<ww:set name="realprice" value="#realprice+converNull(C_YIHAI,0)"/>
												</td>-->
												<td class="table_color"><ww:property
													value="C_PRINTTIME" /></td>
												<td class="table_color"><ww:property
													value="getpassstate(C_STATE)" /></td>
												<td class="table_color"><ww:property
													value="getusername(C_GUAZHANGRENID)" /></td>

												<td class="table_color"><ww:if test="C_HKSTATE==2">已付款</ww:if>
												<ww:if test="C_HKSTATE==3">部分付款</ww:if> <ww:if
													test="C_HKSTATE==1">未付款</ww:if></td>


											</tr>

										</ww:iterator>
										<ww:if test="listbigreport.size>0">
											<tr>
												<td class="table_color">费用小计:</td>
											
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"><ww:property value="pricegather" /></td>
												<td class="table_color"><ww:property value="dutygather" /></td>
												<td class="table_color"><ww:property value="insurfeegather" /></td>
												<td class="table_color"><ww:property value="pricegather+dutygather" /></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
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
			  <ww:property value='getPagetwo(pageinfo,"pageinfo","airreport!toPersonalAccountReport.action","form1")' />
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
		var fname = oXL.Application.GetSaveAsFilename("大客户.xls", "Excel Spreadsheets (*.xls), *.xls");
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
function daochu() {
document.form1.action="airreport!dakehu.action";
document.form1.submit();
  }	
</script>




