<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>非当日作废报表</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
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


	var root = new Ext.tree.TreeNode({text:"---所有---",id:'-1'}) ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
          rootVisible:true
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(s_department)"/>");

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
			class="anse">&nbsp;&nbsp;&nbsp;非当日作废报表</b></td>
	</tr>
	<tr>
		<td valign="top">




		<form name="form1" method="post" action="airreport!nodatefei.action">

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






								<table width="760" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">

									<tr>
										<td width="129" height="40" align="right">票号：</td>
										<td width="181"><span style="HEIGHT: 71px"><input
											id="piaohao" style="WIDTH: 160px" name="piaohao"
											value="<ww:property value="piaohao"/>" /></span></td>
											<td width="184" height="30" align="right">航班：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="piaohao" style="WIDTH: 160px" name="s_airline"
											value="<ww:property value="s_airline"/>"</span></td>
									</tr>
									<tr>
										<td width="129" height="40" align="right">退票类型：</td>
										<td width="181"><span style="HEIGHT: 71px"><input
											id="piaohao" style="WIDTH: 160px" name="s_tuitype"
											value="<ww:property value="s_tuitype"/>" /></span></td>
											<td width="184" height="30" align="right">乘客姓名：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="piaohao" style="WIDTH: 160px" name="s_ticketname"
											value="<ww:property value="s_ticketname"/>"</span></td>
									</tr>
									<tr>
										<td width="184" height="30" align="right">退票时间开始：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 160px" name="s_tuibegindate"
											value="<ww:property value="s_tuibegindate"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /></span></td>
										<td width="184" height="30" align="right">退票时间结束：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 160px" name="s_tuienddate"
											value="<ww:property value="s_tuienddate"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /></span></td>
									</tr>
									<tr>
										<td width="184" height="30" align="right">出票时间开始：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 160px" name="s_begintime"
											value="<ww:property value="s_begintime"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /></span></td>
										<td width="184" height="30" align="right">出票时间结束：</td>
										<td width="198"><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 160px" name="s_endtime"
											value="<ww:property value="s_endtime"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /></span></td>
									</tr>
									<tr>
										<td height="28" align="right"><span>集团客户部门：</span></td>
										<td>
										<div id='comboxWithTree'></div>
									    <input type="hidden" id="parentid" name="s_department" value='<ww:property value="s_department"/>'"/>
									    </td>
									</tr>

									<tr class="font-blue-xi">
										<td height="10" colspan="5" align="right"></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="58" colspan="5" align="center"><input
											type="submit" class="button_d font-white"
											value="查&nbsp;&nbsp;询"  />
											<input
											type="button" class="button_d font-white"
											value="导出excel"  onclick="importExcel('tbdeptsale')"/>
											
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
						<table width="100%" border="0" align="center" cellpadding="0" id="tbdeptsale"
							cellspacing="0">
							<tr>
								<td width="100%">


								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
										<th class="table_color">交易代码</th>
									    <th class="table_color">订单日期</th>
									    <th class="table_color">订单号</th>
									    <th class="table_color">支付银行</th>
									    <th class="table_color">票号</th>
									    <th class="table_color">旅客姓名</th>
									    <th class="table_color">航班</th>
									    <th class="table_color">票面金额</th>
									    <th class="table_color" style="width: 20px;">税</th>
									    <th class="table_color" style="width: 50px;">实际支付金额</th>
									    <th class="table_color" style="width: 50px;">退票手续费率</th>
									    <th class="table_color" style="width: 50px;">东航实际退票金额</th>
									    <th class="table_color" style="width: 50px;">客户实际退票金额</th>
									    <th class="table_color">退票状态</th>
									    <th class="table_color">PNR</th>
									    <th class="table_color">退票类型</th>
									    <th class="table_color">退票日期</th>
									    <th class="table_color">出票人</th>
										</tr>

										<ww:iterator value="listPassenger">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
												onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
												<td class="table_color"><ww:property value="getjiaoyicode(getcode(orderid))"/></td>
												<td class="table_color"><ww:property value="formatDate(gettime(orderid))"/></td>
												<td class="table_color"><ww:property value="getcode(orderid)"/></td>
												<td class="table_color"><ww:property value="getyinghang(getcode(orderid))"/></td>
												<td class="table_color"><ww:property value="ticketnum"/></td>
   												<td class="table_color"><ww:property value="name"/></td>
												<td class="table_color"><ww:property value="gethangbanhao(orderid)"/></td>
												<td class="table_color"><ww:property value="price"/></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"><ww:property value="price"/></td>
												<td class="table_color"><ww:property value="tuipiaoshouxufee"/></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"><ww:property value="getpnr(orderid)"/></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"><ww:property value="tuitime"/></td>
												<td class="table_color"><ww:property value="getchupiaoren(orderid)"/></td>
											</tr>
										</ww:iterator>
<ww:iterator value="listpass" status="pa">
									<tr>
												<td class="table_color">总计:<ww:property value="r_sum"/></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
												<td class="table_color"></td>
   												<td class="table_color">&nbsp;</td>
												<td class="table_color"></td>
												<td class="table_color"><ww:property value="r_price"/></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"><ww:property value="r_price"/></td>
												<td class="table_color"></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"></td>
												<td class="table_color">&nbsp;</td>
												<td class="table_color"></td>
												<td class="table_color">&nbsp;</td>
											
											</tr>

</ww:iterator>

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


<script language="JavaScript">
	function toadd(){
	
		window.location="customeruser!toadd.action";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="customeruser!delete.action?id="+document.form1.selectid.value;
							document.form1.submit();
						}
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.form1.action="customeruser!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="customeruser!batch.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!toedit.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="customeruser!toedit.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  function chakanCredit(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!toCustomercreditList.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="customeruser!toCustomercreditList.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  
  function chakanAirCard(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!toCustomeraircardList.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="customeruser!toCustomeraircardList.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  
  function chakanTel(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!toTelephoneList.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="customeruser!toTelephoneList.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  
  function chakanItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!tochakan.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="customeruser!tochakan.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
	
 function checkItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!tocheck.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="customeruser!tocheck.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
 function fenpei(){

			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!tofenpei.action?memberid="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}else{
				 	alert("你未选择任何内容");
					return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      
					      		document.form1.action="customeruser!tofenpei.action?memberid="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
			
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








