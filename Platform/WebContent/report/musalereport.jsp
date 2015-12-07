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
<title>东航直销汇总表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery1.3.2.js"></script>
<script language=javascript>
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
		var fname = oXL.Application.GetSaveAsFilename("东航直销汇总表.xls", "Excel Spreadsheets (*.xls), *.xls");
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
<div id="member">
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0" align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;部门销售汇总表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post"
			action="airreport!getMUSaleReport.action">

		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" align="center">
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
										<td width="184" height="30" align="right">起始日期：&nbsp;<input type="hidden" name="is_first" value="" /></td>
										<td width="160"><span style="height: 71px"> <input
											id="Text2" style="width: 160px" name="strStartDate"
											value="<ww:property value="strStartDate"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"  class="Wdate" /></span></td>
										<td width="80" height="40" align="right">结束日期：&nbsp;</td>
										<td width="181">
										<input
											id="Text2" style="width: 160px" name="strEndDate"
											value="<ww:property value="strEndDate"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"  class="Wdate" />
										</td>
										<td width="134" rowspan="2" align="center"></td>
									</tr>
									<tr>
									<td width="184" height="30" align="right" >部门：&nbsp;</td>
									<td colspan="4">
									<select id="ddldept" name="ddldept">
										<option value="0">---请选择部门---</option>
										<ww:iterator value="deptlist">
										<option value='<ww:property value="id" />'><ww:property value="name" /></option>
										</ww:iterator>
										</select></td></tr>
								</table>
								</td>
							</tr>
							<tr>
								<td align="center" height="58"><input type="button"
									class="button_d font-bai" onclick="document.form1.submit();"
									value="查询" />&nbsp;&nbsp;&nbsp;<input type="button"
									class="button_d font-bai" onclick="importExcel('tbdeptsale');"
									value="导出" /></td>

							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td valign="top">
						<div id="divreport" style="align: center"><ww:property
							value="strMUSaleHtml" /></div>
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




