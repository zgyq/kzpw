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
<title>东航EXCEL数据比对</title>
<link type="text/css" rel="stylesheet" href="style/base100108.css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/bass.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<style type="text/css"> 
<!--
*{padding:0;margin:0}   
--> 
</style> 
<script language="javascript"> 

  function getDataCompar()
  { 
      
	  var table1=document.getElementById("tbtsl");
	  var table2=document.getElementById("tbxitong");
	  var samerows=0;
	  var totalrows1=parseInt(table1.rows.length)-2;
	  var totalrows2=parseInt(table2.rows.length)-2;
	  $("#span_tb1").html(totalrows1);
	  $("#span_tb2").html(totalrows2);
	  show('pop1','1');
	  for(var i=2;i<table1.rows.length;i++)
	   {  
	     //票号
	     var ticketnumber1=table1.rows[i].cells[0].innerText;
	     for(var j=2;j<table2.rows.length;j++)
	     {
	         var ticketnumber2=table2.rows[j].cells[0].innerText;
	         if(ticketnumber1==ticketnumber2)
	         {
	             table1.rows[i].style.backgroundColor='#ffff99'; 
	             table2.rows[j].style.backgroundColor='#ffff99'; 
	             samerows++;
	         }
	     }
	   } 
	   show('pop1','0');
	   $("#tbresult").show();
	   $("#span_same").html(samerows);
  } 
  
  function show(o1,flag){ 
   var o1 = document.getElementById(o1); 
   o1.style.width = document.documentElement.scrollWidth; 
   o1.style.height = document.documentElement.scrollHeight;
   if(flag==1)
   {
      o1.style.display = "block"; 
   }
   else
   {
      o1.style.display = "none"; 
   }
   } 
   
   var idTmr ;


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
		var fname = oXL.Application.GetSaveAsFilename("东航EXCEL数据比对.xls", "Excel Spreadsheets (*.xls), *.xls");
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


</head>
<body>
<div id="pop1" style="z-index:1;background-color:#CCCCCC;filter: alpha(opacity=80);width:100%;height:100%;position:absolute;left:0px;top:0px;display:none"> 
</div> 
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;东航EXCEL数据比对</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="importmureport.action">

		<table width="100%" border="0" cellpadding="0" cellspacing="0" 
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="760" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">
									<tr>
										<td width="197" height="40" align="right">票号范围：</td>
										<td width="262"><span style="HEIGHT: 71px">
									  <input
											id="piaohao" style="WIDTH: 100px" name="s_ticketnumber1"
											value="<ww:property value="s_ticketnumber1"/>" />-<input
											id="piaohao" style="WIDTH: 100px" name="s_ticketnumber2"
											value="<ww:property value="s_ticketnumber2"/>" /></span></td>
									    <td width="64" height="40" align="right">工作号：</td>
									    <td width="237"><span style="HEIGHT: 71px">
								      <input
											id="s_userid" style="WIDTH: 100px" name="s_userid"
											value="<ww:property value="s_userid"/>" /></span></td>
  </tr>

									<tr>
										<td width="197" height="30" align="right">统计日期：</td>
										<td width="262"><span style="HEIGHT: 71px"> 
			    <input
											id="startnum2" style="WIDTH: 100px" name="s_begindate"
											value="<ww:property value="s_begindate"/>"
											onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" />-<input
											id="startnum2" style="WIDTH: 100px" name="s_enddate"
											value="<ww:property value="s_enddate"/>"
									  onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" /></span></td>
										<td width="64" height="40" align="right">查询条件：</td>
								      <td><span style="HEIGHT: 71px">
								          <select name="s_tickettype">
								          <option value="-1" <ww:if test="s_tickettype.equals(\"-1\")">selected="selected"</ww:if> >显示所有票情况</option>
								          <option value="1" <ww:if test="s_tickettype.equals(\"1\")">selected="selected"</ww:if> >只显示出票情况</option>
								          <option value="2" <ww:if test="s_tickettype.equals(\"2\")">selected="selected"</ww:if> >按客规自愿退票</option>
								          <option value="3" <ww:if test="s_tickettype.equals(\"3\")">selected="selected"</ww:if> >非自愿及特殊退票</option>
								          <option value="4" <ww:if test="s_tickettype.equals(\"4\")">selected="selected"</ww:if> >当日作废</option>
								          </select>
								      </span></td>
									</tr>
									<tr><td width="197" height="30" align="right"></td><td colspan="3" style="color:red">提示：1.按票号范围查询，请输入票号后10位数字</td></tr>
									<tr class="font-blue-xi">
										<td height="58" colspan="5" align="center"><input
											type="submit" class="button_d font-white"
											value="查&nbsp;&nbsp;询"  /> <input
											type="button" class="button_d font-white" value="导出excel"
											onclick="importExcel('tball')" />
											<input
											type="button" class="button_d font-white" value="比对结果"
											onclick="getDataCompar();" />
											</td>
									</tr>
								</table></td>
							</tr>
							<tr>
								<td></td>
							</tr>

						</table>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<div style="height: 400px; width: 96%; margin: 0 auto; overflow: auto;">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0" id="tball">
							<tr>
								<td width="50%" align="center" valign="top">
								<!-- 航信报表数据 -->
								<table id="tbtsl" width="94%" border="1" align="center"
									class="table_color">
									<tbody>
									    <tr class="tbody_color"><th colspan="7" class="table_color"><span style="font-size:15px;font-weight:bold;">东航EXCEL数据</span></tr>
										<tr class="tbody_color">
											<th class="table_color">票号</th>
											<th class="table_color">城市对</th>
											<th class="table_color">票价</th>
											<th class="table_color">税费</th>
											<th class="table_color">订座记录编号</th>
											<th class="table_color">营业员工作号</th>
										</tr>

										<ww:iterator value="listmus">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><ww:property value="ticketnumber" /></td>
												<td class="table_color"><ww:property value="voyage" /></td>
												<td class="table_color"><ww:property
													value="ticketprice" /></td>
												<td class="table_color"><ww:property value="fee" /></td>
												<td class="table_color"><ww:property value="pnr" /></td>
												<td class="table_color"><ww:property value="chupiaoid" /></td>
											</tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
								<!-- 航信报表数据 -->
								<!-- 大客户报表数据 -->
								<td width="50%" align="center" valign="top">
								<table id="tbxitong" width="96%" border="1" align="center"
									class="table_color">
									<tbody>
									    <tr class="tbody_color"><th colspan="7" class="table_color"><span style="font-size:15px;font-weight:bold;">业务系统报表数据</span></tr>
										<tr class="tbody_color">
											<th class="table_color">票号</th>
											<th class="table_color">城市对</th>
											<th class="table_color">票价</th>
											<th class="table_color">税费</th>
											<th class="table_color">订座记录编号</th>
											<th class="table_color">营业员工作号</th>
										</tr>

										<ww:iterator value="listpasss">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><ww:if test="ticketnum!=null && ticketnum.lenght>0"></ww:if><ww:property value="ticketnum.replace(\"-\",\"\")" /><ww:else>未录入</ww:else></td>
												<td class="table_color"><ww:property value="getcitypairbyID(orderid)" /></td>
												<td class="table_color"><ww:property
													value="price" /></td>
												<td class="table_color"><ww:property value="fuelprice+airportfee" /></td>
												<td class="table_color"><ww:property value="getpnrbyID(orderid)" /></td>
												<td class="table_color">无</td>
											</tr>
								
										</ww:iterator>
									</tbody>
								</table>
								</td>
								<!-- 大客户报表数据 -->
							</tr>
						</table>
						</div>
						</td>
					</tr>
					<tr><td colspan="2" height="15px"></td></tr>
					<tr><td colspan="2" align="center">

				<table class="book_pgcontent" id="tbresult" style="display:none" width="96%" border="0" cellpadding="0"
					cellspacing="0">
					<tr class="tbody_color">
						<td class="table_color_l" width="10%"><b>比对结果统计信息</b>
						</td>
					</tr>
					<tr>
						<td class="table_color_l" style="font-weight: bold; color: red">
						东航EXCEL总票号数量：
						<span id="span_tb1"></span>个 系统报表票号数量：
						<span id="span_tb2"></span>个 相同票号数量：
						<span id="span_same"></span>个
					    </td>
					</tr>

				</table>
				<br />
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






