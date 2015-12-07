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
<script type="text/javascript"
	src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="js/ext-all.js"></script>

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
			class="anse">&nbsp;&nbsp;&nbsp;加盟商欠款汇总报表</b></td>
	</tr>
	<tr>
		<td valign="top">




		<form name="form1" method="post" action="airreport!todakehu.action">
		<input type="hidden" name="is_first"/>
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
								<table width="800" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">								
									<tr>
										<td height="30" align="right">加盟商名称：</td>
										<td>
										<div id='comboxWithTree'></div>
										<input type="hidden" id="parentid" name="s_department"
											value='<ww:property value="s_department"/>' /></td>
										<td height="30" align="right">截止日期：</td>
										<td><span style="HEIGHT: 71px"><input
											id="startnum2" style="WIDTH: 150px" name="s_endtime"
											value="<ww:property value="s_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" /></span></td>
										<td align="right">客户经理：</td>
										<td><input name="clientmanger" value="<ww:property value="clientmanger"/>"/></td>
										
									</tr>
									
									<tr class="font-blue-xi">
										<td height="10" colspan="10" align="right"></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="58" colspan="10" align="center">
										<input
											type="submit" class="button_d font-white"
											onclick="document.form1.action='airreport!toBiguserGatherReport.action';document.form1.submit();"
											value="查&nbsp;&nbsp;询"/>
										<input type="submit" class="button_d font-white"
											value="导出Excel"
											 onclick="document.form1.action='airreport!expBiguserGatherExcel.action';checkdata();" /></td>
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
									<!-- 	序号、大客户、截止日期、欠款余额、客户经理-->
											<th class="table_color">序号</th>
											<th class="table_color">大客户</th>
											<th class="table_color">截止日期</th>
											<th class="table_color">欠款余额</th>
											<th class="table_color">客户经理</th>
										</tr>
										<ww:set name="allprice"  value="0"/><!-- 总 -->
										<!-- <ww:set name="realprice"  value="0"/>实收 -->
										<ww:iterator value="biguserqkmaplist"  status="statu">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
												onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
											
												<td class="table_color"><ww:property value="#statu.count" /></td><!-- 机建 --><ww:set name="airprice" value="#airprice+converNull(C_AIRPORTFEE,0)"/>
												<td class="table_color"><ww:property value="agentname" /></td><ww:set name="fuelprice" value="#fuelprice+converNull(C_FUELPRICE,0)"/>
												<td class="table_color"><ww:property value="endtime" /></td>
												<ww:set name="allprice" value="#allprice+converNull(agentdebt,0)"/>
												<td class="table_color"><ww:property value="agentdebt"/></td><!-- 总价 -->
												<td class="table_color"><ww:property value="username" /></td>
											</tr>

										</ww:iterator>
										<ww:if test="biguserqkmaplist.size>0">
											<tr>
												<td class="table_color">费用小计:</td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"><ww:property value="formatMoney(#allprice)"/></td>
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
		</form>


		</td>
	</tr>
</table>
</div>
</body>
</html>




