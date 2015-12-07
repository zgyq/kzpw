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
<title>旅游订单业务报表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT LANGUAGE="javascript"> 
var idTmr ;
function method1(tableid) {//整个表格拷贝到EXCEL中 

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
    oXL.Visible = true; 
    //设置excel可见属性 

    try{
        var fname = oXL.Application.GetSaveAsFilename("旅游线路统计报表.xls", "Excel Spreadsheets (*.xls), *.xls");
    }catch(e){
        print("Nested catch caught " + e);
    }finally{
        oWB.SaveAs(fname);

        oWB.Close(savechanges=false);
         //xls.visible = false;
        oXL.Quit();
        oXL=null;
         //结束excel进程，退出完成
         //window.setInterval("Cleanup();",1);
        idTmr = window.setInterval("Cleanup();",1);

    }
} 
function Cleanup() {
    window.clearInterval(idTmr);
    CollectGarbage();
  }
</SCRIPT> 
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;旅游订单业务报表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post"
			action="triporder!toreportdetail.action">

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
								<td>&nbsp;</td>
							</tr>
							
							<tr>
								<td>
								<table width="760" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="120" height="20" align="right">订单号：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 181px" name="s_ordernum"
											value="<ww:property value="s_ordernum"/>" /> </span></td>
										<td>客人姓名：</td>
										<td><input id="startnum2" style="WIDTH: 181px"
											name="s_contactmingzi"
											value="<ww:property value="s_contactmingzi"/>" /></td>
									</tr>
									<tr>
										<td width="120" height="20" align="right">出发日期：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 85px" onfocus="WdatePicker()"
											name="s_startdate" value="<ww:property value="s_startdate"/>" />
											-<input
											id="startnum2" style="WIDTH: 85px" onfocus="WdatePicker()"
											name="s_enddate" value="<ww:property value="s_enddate"/>" />
										</span></td>
										<td>预定日期：</td>
										<td><input id="startnum2" onfocus="WdatePicker()"
											style="WIDTH: 85px" name="s_bookdate"
											value="<ww:property value="s_bookdate"/>" />-
											<input id="startnum2" onfocus="WdatePicker()"
											style="WIDTH: 85px" name="s_bookenddate"
											value="<ww:property value="s_bookenddate"/>" /></td>
									</tr>
									<tr height="10px">
										<td></td><td></td><td></td><td></td>
									</tr>
									<tr>
										<td colspan="4" align="center"><input type="submit" class="button_d font-white" value="查询" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="button_d font-white" value="导出Excel" onclick="javascript:method1('menutable');"></input></td>
									</tr>

								</table>
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr height="10px">
								<td></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td align="right"></td>
							</tr>
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th class="table_color">预订日期</th>
											<th class="table_color">单号</th>
											<th class="table_color">线路名称</th>
											<th class="table_color">出发日期</th>
											<th class="table_color">客人姓名</th>
											<th class="table_color">手机号码</th>
											<th class="table_color">人数</th>
											<th class="table_color">总价</th>
											<!--<th class="table_color">备注</th>-->
											<th class="table_color">订单状态</th>
										</tr>
										<ww:iterator value="listTriporder">
											<tr id="<ww:property value="id"/>" align="center">
												<td class="table_color"><ww:property
													value="formatTimestampyyyyMMdd(createtime)" /></td>
												<td class="table_color"><ww:property value="code" /><!--<ww:property value="code" />--></td>
												<td class="table_color"><ww:property
													value="SubString(getTriplineName(triplineid),5)" /></td>
												<td class="table_color"><ww:property
													value="formatTimestampyyyyMMdd(statetime)" /></td>
												<td class="table_color"><ww:property value="linkname" /></td>
												<td class="table_color"><ww:property value="linkmobile" /></td>
												<td class="table_color"><ww:property value="pnum" /></td>
												<td class="table_color"><ww:property value="sump" /></td>
												<!-- <td class="table_color"><ww:property
													value="SubString(specreq,15)" /></td> -->
												<td class="table_color"><ww:if test="state==2">完成</ww:if><ww:elseif
													test="state==3">取消</ww:elseif><ww:else>待审核</ww:else></td>
											</tr>
										</ww:iterator>
										<tr>
										<td ></td>
										<td ></td>
										<td></td>
										<td ></td>
										<td></td>
										<td align="center"><b><font color="red">订单数：<ww:property value="s_ordercount"/></font></b></td>
										<td align="right" ><b><font color="red">总金额：</font></b></td>
										<td align="center"><b><font color="red"><ww:property value="s_totalamount"/>￥</font></b></td>
										<td></td>
								
										</tr>
									</tbody>
								</table>
								
								</td>
							</tr>
							<tr>
								<td align="right"></td>
							</tr>
							<tr height="20px"><td></td></tr>
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

