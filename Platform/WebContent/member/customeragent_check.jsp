<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>航空公司列表</title>
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script>
Ext.onReady(function(){
     var selectId ="";

	 var menu = new Ext.menu.Menu({
        id: 'mainMenu',
		width:'160px',
        style: {
            overflow: 'visible'     // For the Combo popup
        },
        items: [
		     
		    {
                id:"new",
				text: '新建',
				icon:"../images/menu/new.gif",
				handler : function(item){
					Ext.MessageBox.show({title:""+selectId,width:300, msg:'Changes saved successfully.',buttons: Ext.MessageBox.OK,fn:showResult});
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"../images/menu/edit.gif",
				handler : function(item){
					window.location.href="main.html";
					
				}
            },
			{
                id:"delete",
				text:"删除",
				icon:"../images/menu/delete.gif",
				handler : function(item){
					window.location.href="http://www.sina.com.cn";
					
				}
            },
			{
                id:"view",
				text:"查看详细信息",
				icon:"../images/menu/view.gif",
				handler : function(item){
					window.location.href="http://www.sina.com.cn";
					
				}
            },
			
			
			'-'
			
			,{
                  id:"up",
				text:"上移",
				icon:"../images/menu/up.gif",
				handler : function(item){
					window.location.href="http://www.sina.com.cn";
					
				}
            }
			,{
                 id:"down",
				text:"下移",
				icon:"../images/menu/down.gif",
				handler : function(item){
					window.location.href="http://www.sina.com.cn";
					
				}
            }
		]

		});




});
function doCustCheck(cid,status) {
	window.location.href="customeragent!check.action?id=" + cid + "&agentcheckstatus=" + status;
}
function doCustCheckbyfenxiaoshang(cid,status) {
	window.location.href="customeragent!checkbyfenxiaoshang.action?id=" + cid + "&agentcheckstatus=" + status;
}
</script>
</head>

<body>

<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;加盟商列表</b></td>
	</tr>
	<tr>
		<td valign="top">


		<form name="form1" method="post" action="customeragent!tocheck.action">
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
								<table width="760" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">
									<tr>
										<td width="184" height="30" align="right">用户名：</td>
										<td width="198"><span style="height: 71px"> <input
											id="Text2" style="width: 160px" name="s_company1" value="" /></span></td>
										<td width="129" height="40" align="right">公司名称：</td>
										<td width="181"><span style="height: 71px"> <input
											id="Text3" style="width: 160px" name="agentcompanyname" value="<ww:property value="customeragent.agentcompanyname" />" /></span></td>
										<td width="134" rowspan="2" align="center"></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="28" align="right">联系人：</td>
										<td><input id="Text2" style="width: 160px"
											name="agentcontactname" value="<ww:property value="customeragent.agentcontactname" />" /></td>
										<td height="28" align="right">联系电话：</td>
										<td><input id="Text2" style="width: 160px"
											name="agenttel" value="<ww:property value="customeragent.agenttel" />" /></td>
										<td align="center">&nbsp;</td>
									</tr>
									<tr class="font-blue-xi">
										<td height="28" align="right"><span class="STYLE2">状态：</span></td>
										<td>
											<select name="agentcheckstatus">
												<option value="">请选择</option>
												<option value="0" <ww:if test="customeragent.agentcheckstatus==0">selected='selected'</ww:if> >未审核</option>
												<option value="1"<ww:if test="customeragent.agentcheckstatus==1">selected='selected'</ww:if>>审核通过</option>
												<option value="2"<ww:if test="customeragent.agentcheckstatus==2">selected='selected'</ww:if>>拒绝审核</option>
											</select></td>
										
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td height="10px"></td>
							</tr>
							 <tr class="font-blue-xi">
    <td height="28" colspan="5" align="center"><input type="submit" class="button_d font-white"  value="查&nbsp;&nbsp;询" onclick="searchOne()"/></td>
    </tr>
							<tr>
								<td height="10px"></td>
							</tr>
							<tr>
								<td>
								<!--
								<table width="100%" height="40" border="0" cellspacing="0"
									cellpadding="0" class="lj"
									style="font-size: 12px; font-weight: bold; line-height: 25px;">
									<tr>
										<td width="51%" align="center"></td>
										<td width="9%"></td>
										<td width="8%"></td>
										<td width="7%">
											<a href="javascript:window.location.href='customeragent!toadd.action'"><input type="button" value="新增" class="button_h font-red" /></a>
										</td>
										<td width="7%">
											<a href="#">  onclick="chakanItem()"> <input type="button" value="详细信息" class="button_h font-red" /></a>
										</td>
										<td width="7%">
											<a href="javascript:updateItem()"><input type="button" value="修改" class="button_h font-red" /></a>
										</td>
										<td width="7%">
											<a href="#" onclick="deleteItem()"><input type="button" value="删除" class="button_h font-red" /></a>
										</td>
									</tr>
								</table>-->
								</td>
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
								<table width="99%" id="menutable" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th width="54" height="25" class="table_color"><input
												type="checkbox" name="all1" style="vertical-align: middle;"
												value="1" onclick="selectall1()" />全选</th>
											<th class="table_color">公司名称</th>
											<th class="table_color">联系人</th>
											<th class="table_color">联系电话</th>
											<th class="table_color">地区</th>
											<th class="table_color">加盟类型</th>
											<th class="table_color">注册时间</th>
											<th class="table_color">状态</th>
											<th>操作</th>
										</tr>
										<ww:iterator value="listCustomeragent">
										<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
											<td class="table_color"><input type="checkbox" name="selectid" id="cck<ww:property value="id"/>" value="<ww:property value="id"/>" /></td>
											<td class="table_color"><ww:property
													value="agentcompanyname" /></td>
											<td class="table_color">
												<ww:property value="agentcontactname" />
											</td>
											<td class="table_color">
												<ww:property value="agenttel" />
											</td>
											<td class="table_color">
												<ww:property value="agentcityid" />
											</td>
											<td class="table_color">
												<ww:if test="agenttype==1">运营商</ww:if>
												<ww:elseif test="agenttype==2">供应商</ww:elseif>
												<ww:elseif test="agenttype==3">分销商</ww:elseif>
											</td>
											<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
											<td class="table_color">
												<ww:if test="agentcheckstatus==0"><img src="images/on.gif" />未审核</ww:if>
												<ww:elseif test="agentcheckstatus==1"><img src="images/ok.gif" />审核通过</ww:elseif>
												<ww:elseif test="agentcheckstatus==2"><img src="images/on.gif" />拒绝审核</ww:elseif>
											</td>
											<td class="table_color">
											<ww:if test="agentcheckstatus==0">
											<ww:if test="type==1">
												<a href="javascript:doCustCheckbyfenxiaoshang(<ww:property value="id" />,1)">通过审核</a>
												&nbsp;&nbsp;<a href="javascript:doCustCheckbyfenxiaoshang(<ww:property value="id" />,2)">拒绝审核</a>
											</ww:if><ww:else>
												<a href="javascript:doCustCheck(<ww:property value="id" />,1)">通过审核</a>
												&nbsp;&nbsp;<a href="javascript:doCustCheck(<ww:property value="id" />,2)">拒绝审核</a>
											</ww:else>
												
											</ww:if>
											<ww:elseif test="agentcheckstatus==1">
											 <span style="color:red">已经审核通过</span>
											</ww:elseif>
											<ww:elseif test="agentcheckstatus==2">
											<span style="color:red">拒绝审核</span>
											<a href="javascript:doCustCheck(<ww:property value="id" />,1)">通过审核</a>
											</ww:elseif>
											</td>
										</tr>
										</ww:iterator>
									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center"><ww:property value="getPagination('\"customeragent!tocheck.action?pageinfo.pagenum=\"+pageno')"/>	</td>
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
	
	
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="customeragent!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="customeragent!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="customeragent!batch.action?opt=1";
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
						document.form1.action="customeragent!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customeragent!toedit.action?id="+uvalue;
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
						document.form1.action="memservitem!toadd.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="memservitem!toadd.action?memberid="+uvalue;
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
						
						document.form1.action="member!tochakan.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="member!tochakan.action?id="+uvalue;
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
						
						document.form1.action="member!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="member!tocheck.action?id="+uvalue;
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
function 	searchOne(){
	
	
	
	
		document.form1.submit();
	
	
	}

</script>

