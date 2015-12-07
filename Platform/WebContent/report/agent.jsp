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

<script>
Ext.onReady(function(){
 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,  
       
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:370,
	   tpl: "<tpl for='.'><div style='height:240px ; width:370px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  


	var root = new Ext.tree.TreeNode({text:"B2b2C Web 站点",id:'-1'}) ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
          rootVisible:false
       });  

	
		comboxWithTree.setValue("<ww:property value="getAgentNameBYid(parentid)"/>");

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
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;下级代理出票报表</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			action="airreport!toagent.action">
			
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
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">
						
									
									
									<tr>
									
										<td align="right">采购商：</td>
										<td><span> <input id="startnum2"
											style="WIDTH: 100px" name="username"
											value="<ww:property value="username"/>" /></span></td>
									
									</tr>
									
									<td align="right">客户名称：</td>
										<td><span style="HEIGHT: 71px">
										<table border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
												<div id='comboxWithTree' style=""></div>
												</td>
												<td><input type="hidden" id="agentname" 
													name="agentname"
													value="<ww:property value="agentname"/>" />
	                                              <input type="hidden" id="parentid" name="parentid" value='<ww:property value="parentid"/>'/>
											</td>
												<td><span class="font-red">&nbsp;&nbsp;&nbsp;</span></td>
											</tr>
										</table></td>
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
											onclick="document.form1.action='airreport!toagent.action';document.form1.submit();" />
										</td>
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
											<th class="table_color" style="width: 60%">采购商</th>
											<th class="table_color">订单数</th>
											
											<th class="table_color">总结算价</th>
											
											
											
											
										</tr>
										<ww:iterator value="ListCustomeragent">
											<tr id='<ww:property value="id"/>' align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
												onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
												
												
												<ww:set name="infos" value="getOrderhtmlByAgent(id)"/>
												
												
												<td class="table_color"><ww:property value="agentcompanyname" /></td>
												<td class="table_color"><ww:property value="#infos.get(0)" /></td>
											
												<td class="table_color"><ww:property value="#infos.get(2)" /></td>
												

											</tr>
										</ww:iterator>
										<ww:if test="listorderinfo.size>20">
											<tr><td style="text-align: left;" class="table_color" colspan="17">订单数：<ww:property value="listorderinfo.size" />&nbsp;</td></tr>
											<tr><td style="text-align: left;" class="table_color" colspan="17">总票面价:<ww:property value="formatMoney(#request.gather.PARPRICE)" /></td></tr>
											<tr><td style="text-align: left;" class="table_color" colspan="17">总税费：<ww:property value="formatMoney(#request.gather.DUTYPRICE)" /></td></tr>
											<tr><td style="text-align: left;" class="table_color" colspan="17">总保险：<ww:property value="formatMoney(#request.gather.INSURALLPRICE)" /></td></tr>
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
			value='getPagetwo(pageinfo,"pageinfo","airreport!toagent.action","form1")' />
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




