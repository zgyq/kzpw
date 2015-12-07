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
<title>乘机人表列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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


	var root = new Ext.tree.TreeNode({text:"节点",id:'-1'}) ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
          rootVisible:false
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(departmentid)"/>");

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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;选择杂项费用还款列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>
								<form name="form1" action="biguserprice!tozafei.action" method="post" >
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="80" height="20" align="right">姓名：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="username" style="WIDTH: 100px" name="username"  value="<ww:property value="username"/>"/> </span></td>

										<td width="80" height="20" align="right">时间范围：</td>
										<td>
										<input type="text" name="s_begintime" onfocus="WdatePicker()" style="width:70px" value="<ww:property value="s_begintime"/>" />-
										<input type="text" name="s_endtime" onfocus="WdatePicker()" style="width:70px" value="<ww:property value="s_endtime"/>" />
										</td>
									
										<td width="80" height="20" align="right">选择部门：</td>
										<td><span style="HEIGHT: 71px" style="WIDTH: 100px"> 
										<div id='comboxWithTree'></div>
					    <input type="hidden" id="parentid" name="departmentid" value="0" />
					      <input type="hidden" id="agentid" name="agentid" value='<ww:property value="agentid"/>' />
										 </span></td>
										
										

									
										<td  align="left" ><input
											type="submit" class="button_d font-bai" value="查询"
											 /></td>
									</tr>

								</table>
								</form>
								</td>
							</tr>
						</table>

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
								<td>
								</td>
							</tr>
							<tr>
								<td style="height: 5px;">&nbsp;</td>
							</tr>

							<form action="biguserprice!zafeihaikuan.action" name="form2"
								id="form2" method="POST">
							<tr>
								<td height="40">
								<table width="90%" border="1" bordercolor="#a0cfee"
									cellspacing="0" cellpadding="0"
									style="margin: 0 auto; border-collapse: collapse">
									<tr>
										<td height="28" align="right">
										<div class="td_color"><span>大客户：</span></div>
										</td>
										<td style="padding-left: 5px;"><input type="text"
											require="true" dataType="Require" disabled="disabled"
											msg="大客户ID不能为空" name=""
											value='<ww:property value="getangentname(agentid)"/>'
											" style="width: 150px" /></td>
											<td height="28" align="right">
										<div class="td_color"><span>备注：</span></div>
										</td>
										<td style="padding-left: 5px;"><input type="text"
											require="true" dataType="Require" msg="备注不能为空" name="comment"
											value='<ww:property value="biguserprice.comment"/>'
											" style="width: 150px" /></td>
									</tr>

									<tr>
										<td height="28" align="right">
										<div class="td_color"><span>还款总金额：</span></div>
										</td>
										<td style="padding-left: 5px;"><input type="text"
											require="true" dataType="Require" msg="还款总金额不能为空"
											name="" id="zong" onblur="che();"
											value='<ww:property value="biguserprice.hkuanprice"/>'
											" style="width: 150px" />
											
										<input type="hidden"
											require="true" dataType="Require" 
											name="hkuanprice" id="hzong" 
										style="width: 350px" />	
											
											</td>
												<td height="28" align="right">
										<div class="td_color"><span>付款方式：</span></div>
										</td>
										<td style="padding-left: 5px;"><select name="ptype"><option value='1'>现金</option><option value='2'>支票</option><option value='3'>银行汇款</option></select></td>
									
									</tr>
									<tr>
										<td align="right">
										<div class="td_color">还款余额：</div>
										</td>
										<td  style="padding-left: 5px;">
										<input type="text"
											require="true" dataType="Require" disabled="disabled" id="yu"
											name="" value="<ww:property value="formatPaymoney(yue)"/>"
											style="width: 100px; " /> 
											<input type="hidden" require="true"
											dataType="Require" id="hyu" name="yu" value=""
											style="width: 50px" /> 
											<input type="hidden" require="true"
											dataType="Require" id="yue" name="yue"
											value="<ww:property value="formatPaymoney(yue)"/>"
											style="width: 50px" /> </td>
											
											<td align="right">
										<div class="td_color">已还：</div>
										</td><td  style="padding-left: 5px;"><input type="text" require="true"
											dataType="Require" disabled="disabled" id="hai" name=""
											value="" style="width: 100px" /> <input type="hidden"
											require="true" dataType="Require" id="hhai" name="hai"
											value="" style="width: 50px" /></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>

<input type="hidden" require="true" dataType="Require" id="bufenid" name="bufenid" value="" style="width: 50px" />

					<tr>
						<td valign="top" style="padding-top: 15px;">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">

											<th class="table_color" width="54" height="25">还款</th>


											<th class="table_color">部门</th>
											<th class="table_color">姓名</th>
											<th class="table_color">费用</th>
											<th class="table_color">消费时间</th>
											<th class="table_color" width="10" height="25"></th>


											<th class="table_color" width="54" height="25">还款</th>
											<th class="table_color">部门</th>
											<th class="table_color">姓名</th>
											<th class="table_color">费用</th>
											<th class="table_color">消费时间</th>

										</tr>


										<ww:iterator value="listMiscellaneous" status="state">
											<ww:if test="#state.index%2==0">
												<tr id="t<ww:property value="id"/>" align="center"
													onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
													onmouseout="this.className='colortrout',this.style.fontWeight='';">

													<td>
												<input type="checkbox" id="<ww:property value="id"/>" <ww:if test="price==null">disabled</ww:if> 
															name="orderid" value="<ww:property value="id"/>"
															onclick="checkprice('<ww:property value="price" />','<ww:property value="id"/>',this);" />
												</td>
													<td class="table_color"><ww:property
														value="getDeptNameByID(department)" /></td>
													<td class="table_color"><ww:property value="name" /></td>
													<td class="table_color"><ww:property value="price" /></td>
													<td class="table_color"><ww:property value="spenddate"/>
													</td>
											</ww:if>
											<ww:else>
												<td></td>
												<td class="table_color">
													<input type="checkbox" <ww:if test="price==null">disabled</ww:if>  id="<ww:property value="id"/>"
														name="orderid" value="<ww:property value="id"/>"
														onclick="checkprice('<ww:property value="price" />','<ww:property value="id"/>',this);" />
												</td>
												<td class="table_color"><ww:property
													value="getDeptNameByID(department)" /></td>
												<td class="table_color"><ww:property value="name" /></td>
												<td class="table_color"><ww:property value="price" /></td>
												<td class="table_color"><ww:property value="spenddate"/>
												</td>



												</tr>
											</ww:else>
										</ww:iterator>

									</tbody>
									<input type="hidden" require="true" dataType="Require"
										msg="大客户ID不能为空" name="agentid"
										value='<ww:property value="agentid"/>' " style="width: 350px" />
								</table>
								<div
									style="text-align: center; width: 100%; height: 45px; padding-top: 10px;">
								<ww:if test="listMiscellaneous.size()>0">
								<input type="button" class="button_d font-bai" value="提交"
									onclick="sub();" />
								</ww:if>
								 <input type="button"
									class="button_d font-bai" onclick="javascript:history.go(-1);"
									name="Submit2" value=" 返回 " /></div>
								</td>


							</tr>

						</table>
						</form>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		
		</td>
	</tr>
</table>
</div>
</body>
</html>


<script language="JavaScript">
function che(){

		var zong =document.getElementById("zong").value;
		var yue =document.getElementById("yue").value;
			if(yue==''){
			yue=0.00;
			
			}
	if(document.getElementById("zong").value!=''){
		document.getElementById("yu").value=parseInt(zong)+parseInt(yue);
		document.getElementById("hyu").value=document.getElementById("zong").value;
		
		document.getElementById("hzong").value=document.getElementById("zong").value;
document.getElementById("zong").disabled="disabled";
		
		}else{
		alert("请输入还款数");
		}
	}
	
function checkprice(price,id,obj){
//alert(price+"---"+id+"---"+state+"---"+obj);
		var zong = document.getElementById("zong").value;
		var yu = document.getElementById("yu").value;
		var hai = document.getElementById("hai").value;
	//	下面判断哪个id为还款部分
//alert("price=="+price);
//alert("yu=="+yu);

if(document.all(id).checked==true){

if(parseInt(price)>parseInt(yu)){
alert("余额不足");
document.getElementById(id).checked=!document.getElementById(id).checked;
return;
}
}else{

					//	document.getElementById("yu").value=parseInt(yu)+parseInt(price);//取消时,余额增加
					//	document.getElementById("hyu").value=parseInt(yu)+parseInt(price);
}

	if(document.getElementById("bufenid").value==id){//取消了还款部分的ID
			document.getElementById("bufenid").value="";
		}else{
			if(parseInt(yu)>parseInt(price)){
				document.getElementById("bufenid").value="";
				}else{
						if(parseInt(yu)>0){
						document.getElementById("bufenid").value=id;
						}
					
					
				}
		}
		
		if(parseInt(document.getElementById("yu").value)>0){//余额不是负数
		//	alert("余额不是负数..第一次进入");
				//if(document.getElementById(id).checked==true){//判断选中还是取消
				//if($("input[id='"+obj+"']:checked").length == 0) {
				if(document.all(id).checked==true){
				
			//		alert("选中");
				
						if(hai==''){
				//		alert("第一次进入,已还为空");
						document.getElementById("hai").value=parseInt(price);
						document.getElementById("hhai").value=parseInt(price);
						document.getElementById("yu").value=parseInt(yu)-parseInt(price);
						document.getElementById("hyu").value=parseInt(yu)-parseInt(price);
						}else{
					//	alert("不是第一次.已还不为空");
						document.getElementById("hai").value=parseInt(hai)+parseInt(price);
						document.getElementById("hhai").value=parseInt(hai)+parseInt(price);
						document.getElementById("yu").value=parseInt(yu)-parseInt(price);
						document.getElementById("hyu").value=parseInt(yu)-parseInt(price);
						}
				
				
				}else{
			//	alert("取消");
						document.getElementById("yu").value=parseInt(yu)+parseInt(price);//取消时,余额增加
						document.getElementById("hyu").value=parseInt(yu)+parseInt(price);
							if(document.getElementById("hai").value==''){
							document.getElementById("hai").value=parseInt(price);
							document.getElementById("hhai").value=parseInt(price);
							}else{
							document.getElementById("hai").value=parseInt(hai)-parseInt(price);
							document.getElementById("hhai").value=parseInt(hai)-parseInt(price);
							}
				
				}
		
		
		
	}else{//是负数.
	
		
	
		//if(document.getElementById(id).checked==true){
		if(document.all(id).checked==true){
		alert("余额不足");
		document.getElementById(id).checked=!document.getElementById(id).checked;
		}else{
		//alert("余额不足");
		document.getElementById(id).checked=!document.getElementById(id).checked;
		document.getElementById("yu").value=parseInt(yu)+parseInt(price);
		document.getElementById("hyu").value=parseInt(yu)+parseInt(price);
		document.getElementById("hai").value=parseInt(hai)-parseInt(price);
		document.getElementById("hhai").value=parseInt(hai)-parseInt(price);
		document.getElementById(id).checked=!document.getElementById(id).checked;
		}
	
	
	}
}
	
	
	function toadd(){
		window.location="passenger!toadd.action?<ww:property value="url"/>";
	}
	function seh(){
		document.form1.submit();
		
	}
	function chkCheckBoxChs(objNam){ 
	var obj = document.getElementsByName(objNam); 
	var objLen= obj.length; 
	var objYN; 
	var i;
	objYN=false;
	for (i = 0;i< objLen;i++){
	if (obj [i].checked==true) {
	objYN= true;
	break;
	}
	}
	return objYN;
	
	}

	
	
	function sub(){
	//var obj = document.getElementsByName("orderid");
	
	if(document.getElementById("zong").value==''){
	alert("请输入还款数目!");
	return;
	}
	 if(chkCheckBoxChs("orderid")== false){
	alert("请至少选择一项");
	return;
	}

				  
	
		document.form2.submit();
		
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="passenger!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="passenger!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="passenger!batch.action?opt=1";
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
						
						document.form1.action="passenger!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="passenger!toedit.action?id="+uvalue;
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
						
						document.form1.action="passenger!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="passenger!tocheck.action?id="+uvalue;
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





