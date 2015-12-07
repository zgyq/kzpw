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
<title>航空公司基础信息表列表</title>

<link href="style/text.css" rel="stylesheet" type="text/css" />
<link href="style/base.css" rel="stylesheet"  type="text/css"/>
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
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
					window.location.href="aircompany!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="aircompany!toedit.action?id="+selectId;
						document.form1.submit();
				}
            },{
                id:"delete",
				text:"删除",
				icon:"images/menu/delete.gif",
				handler : function(item){
					Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						document.form1.action="aircompany!delete.action?id="+selectId;
						document.form1.submit();
					
						}
					}});
					
				}
            },
			'-',
			{
                id:"check",
				text:"启用/禁用",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="aircompany!docheck.action?id="+selectId;
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

<body style="height:100%; margin: 0; padding: 0;"> 
<div id="member"  >
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box" style="height:100%;position:absolute;float:left; width: 99%; border-bottom:none;"  >
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;航空公司基础信息表列表</span> </b></td>
	</tr>
	<tr>
		<td valign="top">
		
		<form name="form1" method="post" action="aircompany.action">
			<input type="hidden" value="<ww:property value="pageinfo.pagenum" />" name="pageinfo.pagenum"/>
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
									cellspacing="0" style="font-size: 12px;">
									<tr>
										<td width="184" height="30" align="right">中文名称：</td>
										<td width="198"><span style="height: 71px"> <input
											id="Text2" style="width: 160px" name="aircomcnname"
											value="<ww:property value="aircomcnname"/>" /></span></td>
										<td width="129" height="40" align="right">英文名称：</td>
										<td width="181"><span style="height: 71px"> <input
											id="Text3" style="width: 160px" name="aircomenname"
											value="<ww:property value="aircomenname"/>" /></span></td>
										<td width="134" rowspan="2" align="center"><!--
                                                 <input type="button" style="background: url(images/hout3.gif); width: 98px; height: 31px;
                                                     border: none; color: #FFF; font-weight: bold;" value="查&nbsp;&nbsp;询" onclick="searchOne()" />
                                             --></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="28" align="right"><span class="STYLE2">航司简称：</span></td>
										<td><input id="Text4" style="width: 160px"
											name="aircomjname" value="<ww:property value="aircomjname"/>" />
										</td>
										<td height="28" align="right"><span class="STYLE2">航司代码：</span></td>
										<td width="181"><input id="Text5" style="width: 160px"
											name="aircomcode" value="<ww:property value="aircomcode"/>" />
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td align="center"><input type="button"
									class="button_d font-bai" onclick="document.form1.submit();"
									value="查询" /></td>
							</tr>
							<tr>
								<td height="40">
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="27" align="center">
										<div align="right"><a href="#" onclick="toadd()"><input
											type="button" value="新增" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input
											type="button" value="启用/禁用" class="button_h font-red" /></a></div>
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
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color"  cellpadding="0" cellspacing="0">
									<tbody>
										<tr class="tbody_color">

											<th class="table_color" width="54" height="25"><input
												type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>

											<th class="table_color">序号</th>
											<th class="table_color">航空公司两字代码</th>
											<th class="table_color">航空公司中文名称</th>
											<th class="table_color">航空公司简称</th>
											<th class="table_color">航空公司英文名称</th>
											<th class="table_color">航空公司logo</th>
											<th class="table_color">有无包机</th>
											<!-- 
											<th class="table_color">创建者</th>
											<th class="table_color">创建时间</th>
											<th class="table_color">修改者</th>
											<th class="table_color">修改时间</th>
											 -->
											<th class="table_color">&nbsp;状态&nbsp;</th>
											<th class="table_color">&nbsp;操作&nbsp;</th>

										</tr>

										<ww:iterator value="listAircompany">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>
												<td class="table_color"><ww:property value="id" /></td>
												<td class="table_color"><ww:property value="aircomcode" /></td>
												<td class="table_color"><ww:property
													value="aircomcnname" /></td>
												<td class="table_color"><ww:property
													value="aircomjname" /></td>
												<td class="table_color"><ww:property
													value="aircomenname" /></td>
												<td class="table_color"><img
													src='images/<ww:property value="aircomlogo" />' width="28"
													height="30" /></td>
											 <td class="table_color" style="color: red"><ww:if test="isair==1">有包机</ww:if><ww:else>无包机</ww:else></td>
												<!-- 
												<td class="table_color"><ww:property value="createuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<td class="table_color"><ww:property value="modifyuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(modifytime)" /></td>
												-->
												<td class="table_color"><ww:if test="isenable==0">禁用</ww:if>
												<ww:elseif test="isenable==1">启用</ww:elseif></td>
												
												
												<td class="table_color" style="color: red"><ww:if test="isair==1">
												<a href="aircompany!CancelService.action?id=<ww:property value="id"/>&s_type=2">取消包机</a>
												</ww:if><ww:else>
												<a href="aircompany!CancelService.action?id=<ww:property value="id"/>&s_type=1">设为包机</a>
												</ww:else></td>

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
		window.location="aircompany!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="aircompany!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="aircompany!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="aircompany!batch.action?opt=1";
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
						
						document.form1.action="aircompany!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="aircompany!toedit.action?id="+uvalue;
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
						
						document.form1.action="aircompany!docheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="aircompany!docheck.action?id="+uvalue;
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





