<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有，thunder
	 * Author: thunder
	 * copyright: 2011
	 */
%>
<html>
<head>
<title>角色列表</title>
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />

<link href="css/default.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<link href="style/base.css" rel="stylesheet" />


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
				icon:"images/menu/new.gif",
				handler : function(item){
					window.location.href="systemrole!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="systemrole!toedit.action?id="+selectId;
						document.form1.submit();
				}
            },
			{
                id:"delete",
				text:"删除",
				icon:"images/menu/delete.gif",
				handler : function(item){
					Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						document.form1.action="systemrole!delete.action?id="+selectId;
						document.form1.submit();
					
						}
					}});
					
				}
            },
			{
                id:"fuquan",
				text:"赋权",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="systemright!buildTree2.action?rd="+selectId;
						document.form1.submit();
					
				}
            }
			
			
		]

		});



	Ext.get('menutable').on('contextmenu',function(e){
		
		if(e.target.parentNode.id)
		{
			e.preventDefault();
			selectId = e.target.parentNode.id;
			menu.showAt(e.getPoint());
		}
	});

});
</script>
</head>
<body>


<div id="mainform">


<form name="form1" method="post" action="systemrole.action">




<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td valign="top" background="images/titleL3_bg.gif">
	
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			
			
			<tr>
				<td><img src="images/titleL3_point.gif" width="33" height="19"><span
					class="txt_title3">角色列表</span>
				
				
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td valign="bottom">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width=42 nowrap>&nbsp;</td>
								<td nowrap class="txt_search">名称: <input type="text"
									id="s_name" name="s_rolename"
									value="<ww:property value="s_rolename"/>" class="Form_date" />
								<input type="submit" value="搜索" class="Form_date"></td>
							</tr>
						</table>

						</td>
					</tr>


					<tr>
						<td height="40">
						<table width="99%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="27" align="center">
								<div align="right"><a href="#" onclick="toadd()"><input
									type="button" value="新增" class="button_h font-red"></a>
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
									type="button" value="修改" class="button_h font-red"></a>
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
									type="button" value="删除" class="button_h font-red"></a><!--
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input type="button" value="审核" class="button_h font-red"></a>
                 -->&nbsp;&nbsp;&nbsp;<a href="#" onclick="fuquanItem()"><input
									type="button" value="赋权" class="button_h font-red"></a></div>
								</td>
							</tr>
						</table>
						</td>
					</tr>



					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">

											<th class="table_color" width="54" height="25"><input
												type="checkbox" name="all1" value="1"
												style="vertical-align: middle;" onclick="selectall1()" />全选</th>
											<!--
               	     
                  <th class="table_color">ID</th>
                  -->
											<th class="table_color">名称</th>
											<th class="table_color">创建者</th>
											<th class="table_color">创建时间</th>
											<!--<th class="table_color">修改者</th>
											<th class="table_color">修改时间</th>
											--><!--<th class="table_color">加盟商ID</th>
                  -->
											<!--<th class="table_color">角色类型</th>
                  -->
											<!--
											<th class="table_color">角色代码</th>
											-->
										</tr>

										<ww:iterator value="listSystemrole">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<!--<td  class="table_color"><ww:property value="id"/></td>
-->
												<td class="table_color"><ww:property value="name" /></td>
												<td class="table_color"><ww:property value="createuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<!--<td class="table_color"><ww:property value="modifyuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(modifytime)" /></td>
												--><!--<td  class="table_color"><ww:property value="customeragentid"/></td>
-->
												<!--<td  class="table_color"><ww:property value="type"/></td>
-->										<!--
												<td class="table_color"><ww:property value="code" /></td>


											-->
											</tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center"><ww:property
									value="pagination" /></td>
							</tr>
						</table>
						</td>
					</tr>


					<tr style="display: none">
						<td></td>

						<td align="center" width="80">
						<div id="b_new"></div>
						</td>

						<td align="center" width="80">
						<div id="b_delete"></div>
						</td>

					</tr>
					<tr>
						<td height="5"></td>
					</tr>
				</table>
				</td>
			</tr>

		</table>
		</td>
	</tr>
</table>
</form>
</div>

<div id="topic-grid"></div>

</body>
</html>

<script language="JavaScript">
	function toadd(){
		window.location="systemrole!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						    if(document.form1.selectid.value=="1" || document.form1.selectid.value=="10035" || document.form1.selectid.value=="10036" || document.form1.selectid.value=="10062" || document.form1.selectid.value=="10063")
							{
							    alert("此角色不能删除!!");
							    return;
							}
							else
							{
							   document.form1.action="systemrole!delete.action?id="+document.form1.selectid.value;
							   document.form1.submit();
							}
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
							if(uvalue=="1" || uvalue=="10035" || uvalue=="10036" || uvalue=="10062" || uvalue=="10063")
							{
							    alert("此角色不能删除!!");
							    return;
							}
							else
							{
								document.form1.action="systemrole!delete.action?id="+uvalue;
								document.form1.submit();
								}
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      	
					      		document.form1.action="systemrole!batch.action?opt=1";
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
						
						document.form1.action="systemrole!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="systemrole!toedit.action?id="+uvalue;
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
						
						document.form1.action="systemrole!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="systemrole!tocheck.action?id="+uvalue;
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
 function fuquanItem(){

			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="systemright!buildTree2.action?rd="+document.form1.selectid.value;
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
					      
					      		document.form1.action="systemright!buildTree2.action?rd="+uvalue;
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

