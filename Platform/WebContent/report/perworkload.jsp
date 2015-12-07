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
<title>人均工作量统计报表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery1.3.2.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script language=javascript>
	var idTmr ;
function _w_table_rowspan(_w_table_id,_w_table_colnum){ 
    _w_table_firsttd = "";   
    _w_table_currenttd = "";  
    _w_table_SpanNum = 0;  
    _w_table_Obj = $(_w_table_id + " tr td:nth-child(" + _w_table_colnum + ")");  
    _w_table_Obj.each(function(i){  
    if(i==0){   
       _w_table_firsttd = $(this);  
       _w_table_SpanNum = 1;  
     }else{   
     _w_table_currenttd = $(this);    
    if(_w_table_firsttd.text()==_w_table_currenttd.text()){  
    _w_table_SpanNum++;         
    _w_table_currenttd.hide(); //remove();           
    _w_table_firsttd.attr("rowSpan",_w_table_SpanNum);   
    }else{    
    _w_table_firsttd = $(this);          
    _w_table_SpanNum = 1;               
   }    
   }   
  }); 
  }  
$(document).ready(function(){              
      _w_table_rowspan("#tbdeptsale",1);     
});  

function method2(tableid) //读取表格中每个单元到EXCEL中 
{  

    var curTbl = document.getElementById(tableid); 
    
      try { 
            var oXL = new ActiveXObject("Excel.Application"); 
      } 
      catch(e) 
      { 
        alert( "您必须安装Excel2000或以上，同时浏览器须使用“ActiveX 控件”，您的浏览器须允许执行控件。请选择Internet设置--安全选项--本地Intranet--改区域的安全级别设置为低，才能导出到Excel！"); 
        
        window.location.reload(); 
        return ""; 
      } 
    
    //创建AX对象excel 
    var oWB = oXL.Workbooks.Add(); 
    //获取workbook对象 
    var oSheet = oWB.ActiveSheet; 
    //激活当前sheet 
    var Lenr = curTbl.rows.length; 
    //取得表格行数 
    for (i = 0; i < Lenr; i++) 
    { 
        var Lenc = curTbl.rows(i).cells.length; 
        

        //<!--设置显示字符而不是数字--> 
          
        oSheet.Columns(6).NumberFormatLocal="@" 
        oSheet.Columns(5).NumberFormatLocal="@"; 
        oSheet.Columns(8).NumberFormatLocal="@"; 
        //取得每行的列数 
        for (j = 0; j < Lenc; j++) 
        { 
            oSheet.Cells(i + 1, j + 1).value = curTbl.rows(i).cells(j).innerText; 
            //赋值 
        } 
    } 
    oXL.Selection.HorizontalAlignment = -4108;        //'xlHAlignCenter  横向居中 
    oXL.Range("a1:b1:c1:d1:f1:g1:h1:i1:j1:k1").MergeCells = true;//合并 
    //oXL.Range("a1:b1").select;//选中 
    //oXL.Selection.VerticalAlignment = -4108;          //'xlVAlignCenter  竖向居中 
    oSheet.Columns.AutoFit; //自动适应大小 
    //设置excel可见属性 
    oXL.Visible = true; 
    oXL.UserControl = true;  //excel交由用户控制 

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
		var fname = oXL.Application.GetSaveAsFilename("人均工作量统计.xls", "Excel Spreadsheets (*.xls), *.xls");
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
  
  Ext.onReady(function(){
 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,  
       
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:164,
	   tpl: "<tpl for='.'><div style='height:240px ; width:164px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  


	var root = new Ext.tree.TreeNode({text:"B2b2C Web 站点",id:'-1'}) ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
          rootVisible:false
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(department.parentid)"/>");

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
</script>
</head>
<body>
<div id="member">
<table width="100%" height="100%" border="0" cellpadding="0"
	cellspacing="0" align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;人均工作量统计</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post"
			action="perworkload.action">

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
										<td width="184" height="30" align="right">起始时间：&nbsp;</td>
										<td width="160"><span style="height: 71px"> <input
											id="Text2" style="width: 160px" name="s_starttime"
											value="<ww:property value="s_starttime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"  class="Wdate" /></span></td>
											<td width="184" height="30" align="right">结束时间：&nbsp;</td>
										<td width="160"><span style="height: 71px"> <input
											id="Text2" style="width: 160px" name="s_endtime"
											value="<ww:property value="s_endtime"/>"
											onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})"  class="Wdate" /></span></td>
										
										<td width="134" rowspan="2" align="center"></td>
									</tr>
									<tr>
									<td width="60" height="40" align="right">所属部门：&nbsp;</td>
										<td width="51">
										<div id='comboxWithTree'></div>
                                        <input type="hidden" id="parentid" name="s_deptid" value='<ww:property value="s_deptid"/>' " style="width: 80px" />
										</td>
										<td width="184" height="30" align="right">员工姓名：&nbsp;</td>
										<td width="160"><span style="height: 71px"> <input
											id="Text2" style="width: 160px" name="s_employeename"
											value="<ww:property value="s_employeename"/>"/></span></td>
										
										<td width="134" rowspan="2" align="center"></td>
									</tr>
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
						<td valign="top" align='center'>
						<div id="divreport" width='98%' style="align: center"><ww:property
							value="strRenJunHtml" /></div>
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




