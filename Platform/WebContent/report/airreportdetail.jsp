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
<title>机票数据报表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
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
Ext.onReady(function(){
 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,  
       
       mode: 'local',  
       triggerAction:'all',
       maxHeight: 240, 
       width:165,
	   tpl: "<tpl for='.'><div style='height:240px ; width:165px'><div id='tree'></div></div></tpl>",  
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
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0" align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;机票明细报表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id="form1" method="post"
			action="airreport!airreportdetail.action">
			<input type="hidden" name="is_first"/>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
								<table width="90%" border="0" align="center" cellpadding="0"
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
										<td align="right">支付方式：</td>
										<td>
										<select name="s_paymethod" style="width: 120px">
										<option value="-1" <ww:if test="s_paymethod==-1">selected="selected"</ww:if>></option>
										<ww:iterator value="getPaymethodMap()" >
							             <option value="<ww:property value="key"/>" <ww:if test="s_paymethod==key">selected="selected"</ww:if> ><ww:property value="value"/></option>
							             </ww:iterator>
										</select>
										</td>
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
										<td>
										<input name="s_cabin" style="WIDTH: 120px" value="<ww:property value="s_cabin"/>"/>
										</td>
									</tr>
									<tr>
										<td align="right" >机票类型：</td>
										<td><select name="tickettype" style="width: 120px">
											<option value="0"></option>
											<ww:iterator value="listtickettype">
												<option <ww:if test="tickettype==id">selected="selected"</ww:if> value="<ww:property value="id"/>"><ww:property
													value="typename" /></option>
											</ww:iterator>
										</select></td>

										<td align="right" >付款方式：</td>
										<td>
										<select name="fkmethod" style="width: 120px">
										<option value='-1' <ww:if test="fkmethod==-1">selected="selected"</ww:if>></option>
										<ww:iterator value="getFkmethodMaP()">
													<option value='<ww:property value="key"/>'
												<ww:if test="fkmethod==key">selected="selected"</ww:if>><ww:property value="value"/></option>
												</ww:iterator>
										</select>
										</td>
										<td width="120" height="20" align="right">&nbsp;类&nbsp;型：</td>
										<td>										
										<select name="s_internal" style="width:120px">
										<option value="-1" <ww:if test="s_internal==-1">selected=selected</ww:if>></option>
										<option value="0" <ww:if test="s_internal==0">selected=selected</ww:if> >国内票</option>
										<option value="1" <ww:if test="s_internal==1">selected=selected</ww:if>>国际票</option>
										</select>
										</td>
									</tr>
									<tr>
										<td  align="right">部&nbsp;&nbsp;&nbsp;&nbsp;门：</td>
										<td>
										<div id='comboxWithTree'></div>
										<input type="hidden" id="parentid" name="s_department"
											value='<ww:property value="s_department"/>' /></td>
									   <td align="right">
										客户类型:
										</td>
										<td>
										<select name="custype" style="width: 120px">
										<option value="0" <ww:if test="custype==0">selected="selected"</ww:if>>所有</option>
										<option value="1" <ww:if test="custype==1">selected="selected"</ww:if>>大客户</option>
										<option value="2" <ww:if test="custype==2">selected="selected"</ww:if>>所有散客</option>
										<option value="3" <ww:if test="custype==3">selected="selected"</ww:if>>当月散客</option>
										<option value="4" <ww:if test="custype==4">selected="selected"</ww:if>>非当月散客</option>
										<option value="5" <ww:if test="custype==5">selected="selected"</ww:if>>所有分销商</option>
										</select>
										</td>
										<td  align="right">出票时间：</td>
										<td><span style="HEIGHT: 70px"> <input
											id="cptime" style="WIDTH: 135px" name="s_begintime"
											value="<ww:property value="s_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cpendtime\',{d:-0});}',minDate:'#F{$dp.$D(\'cpendtime\',{d:-31});}'})" class="Wdate" />- <input
											id="cpendtime" style="WIDTH: 135px" name="s_endtime"
											value="<ww:property value="s_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'cptime\',{d:+31});}',minDate:'#F{$dp.$D(\'cptime\',{d:+0});}'})" class="Wdate" /></span></td>
										
									</tr>
									<!--
								<tr>
								
								<td  align="right">出票时间：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 80px" name="s_begintime"
											value="<ww:property value="s_begintime"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" />
										-
										<input
											id="startnum2" style="WIDTH: 80px" name="s_endtime"
											value="<ww:property value="s_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" /></span></td>
										<td width="184"  align="right">出票时间：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 160px" name="s_name"
											value="<ww:property value="s_name"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate"/></span></td>
										<td width="129"  align="right">出票员：</td>
										<td width="181"><span style="HEIGHT: 71px"><input
											id="startnum2" style="WIDTH: 160px" name="s_shenfz"
											value="<ww:property value="s_shenfz"/>" /></span></td>
									</tr>

									-->
									<tr class="font-blue-xi">
										<td height="10" colspan="10" align="right"></td>
									</tr>									
							<tr>
								<td align="center" height="58" colspan="6"><input type="button"
									class="button_d font-bai"
									onclick="document.form1.action='airreport!airreportdetail.action';dispose('系统正在为您查询');document.form1.submit();"
									value="查询" />&nbsp;&nbsp;&nbsp;<input type="button"
									class="button_d font-bai"
									onclick="document.form1.action='airreport!expDetailExcel.action';expexcel();document.form1.submit();"
									value="导出" /></td>

							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">										
											<th class="table_color">订单编号</th>
											<th class="table_color">起始票号</th>
											<th class="table_color">终止票号</th>											
											<th class="table_color">PNR</th>
											<th class="table_color">乘机人</th>
											<!-- <th class="table_color">乘机人类型</th>-->
											
											<th class="table_color">航程</th>
											<th class="table_color">舱位</th>
											<th class="table_color">机票金额</th>
											<th class="table_color">税</th>
											<th class="table_color">折让</th>
											<th class="table_color">实收金额</th>
											<th class="table_color">支付方式</th>
											<th class="table_color">付款方式</th>
											<th class="table_color">出票时间</th>
											<th class="table_color">出票人</th>
										</tr>
										<ww:set name="tprice"  value="0"/>
										<ww:set name="duty"  value="0"/>
										<ww:set name="realprice"  value="0"/>
										<ww:set name="discount"  value="0"/>						
										<ww:iterator value="listorderinfos">
											<tr>
												<td class="table_color"><ww:property value="ordernumber" /></td>
												<td class="table_color"><ww:property value="getSEticketnum(id,1)" /></td>
												<td class="table_color"><ww:property value="getSEticketnum(id,2)" /></td>
												<td class="table_color"><ww:property value="getpnr(id)" /></td>
											 <td class="table_color">
												<ww:property value="getPassengername(id)" /></td>
												<!--	<td class="table_color"><ww:if test="ptype==1">成人</ww:if> <ww:else>儿童</ww:else></td>-->
												<td class="table_color"><ww:property value="getSegmentInfo(id,1)" /></td>
												<td class="table_color"><ww:property value="getSegmentInfo(id,4)" /></td>
													<!-- jipao金额 -->
												<td class="table_color"><ww:property value="totalticketprice" /></td>
												<ww:set name="tprice"  value="#tprice+converNull(totalticketprice,0f)"/>
											
												<!-- 税 --><td class="table_color"><ww:property value="converNull(totalfuelfee,0f)+converNull(totalairportfee,0f)+converNull(anjianfee,0f)+converNull(otherfee,0f)" /></td>
												<ww:set name="duty"  value="#duty+converNull(totalfuelfee,0f)+converNull(totalairportfee,0f)"/>
												<!-- 折让 --><td class="table_color"><ww:property value="getPreferential(id)" /></td>
												<!-- 实收金额 --><td class="table_color"><ww:property value="getRealPrice(id)" /></td>
													<ww:set name="discount"  value="#discount+getPreferential(id)"/>
													<ww:set name="realprice"  value="#realprice+getRealPrice(id)"/>
												<!-- 支付方式 --><td class="table_color"><ww:property value="getPayMethodStr(converNull(paymethod,0))"/></td>
												<!-- 付款方式 --><td class="table_color"><ww:property value="getFkmethodstr(converNull(fkmethod,0))"/></td>
												<!-- 代收金额 <td class="table_color"><ww:property value="0" /></td>-->
												<!-- 出票时间 -->
												<td class="table_color"><ww:property value="printtime" /></td>
												<td class="table_color"><ww:property value="getInsurName(id)" />
												</td>
											</tr>
										</ww:iterator>
											<ww:if test="listorderinfos.size>0">
										<tr>
											
												<td class="table_color">小计:</td>
												
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"><ww:property value="formatMoney(#tprice)"/></td>
												<td class="table_color"><ww:property value="formatMoney(#duty)"/></td>
												<td class="table_color"><ww:property value="formatMoney(#discount)"/></td>
												<td class="table_color"><ww:property value="formatMoney(#realprice)"/></td>
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
			  <ww:property value='getPagetwo(pageinfo,"pageinfo","airreport!airreportdetail.action","form1")' />
		   </div>
		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>




