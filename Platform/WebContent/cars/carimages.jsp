<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@page import="com.yf.system.back.server.Server"%>
<%@page import="java.util.*" %>
<%@page import="com.yf.system.base.sysconfig.Sysconfig"%>
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
<title>汽车图片列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<!--<script>
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
				<ww:if test='cid>0'>
				window.location.href="carimages!toadd.action?<ww:property value="url"/>&carid=<ww:property value="carid"/>";
				</ww:if><ww:else>
					window.location.href="carimages!toadd.action?<ww:property value="url"/>";
					</ww:else>
				}
            }
			//,{  
			//	id:"edit",
			//	text:"修改",
			//	icon:"images/menu/edit.gif",
			//	handler : function(item){
			//			document.form1.action="carimages!toedit.action?id="+selectId;
			//			document.form1.submit();
			//	}
            // }
            ,
			{
                id:"delete",
				text:"删除",
				icon:"images/menu/delete.gif",
				handler : function(item){
					Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						document.form1.action="carimages!delete.action?id="+selectId;
						document.form1.submit();
					
						}
					}});
					
				}
            },
			'-',
			{
                id:"check",
				text:"审核",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="carimages!tocheck.action?id="+selectId;
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
--></head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if test="cid>0"><span style="color: red;">(<ww:property value="getcarnameBYid(cid)"/>)</span></ww:if>&nbsp;&nbsp;汽车图片列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="carimages.action">

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
           <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="120" height="20" align="right">汽车名称：</td>    <td><span style="HEIGHT: 71px">
                  <input id="startnum2" name="s_name" value="<ww:property value="s_name"/>"  style="WIDTH: 181px" name="startnum2" />
                </span></td>
                
                <td width="30%" rowspan="3"><div align="left">
                  <input type="submit" class="button_d font-bai" value="查询"/>
                </div></td>
              </tr>
              
             </table>
        </td>
							</tr>
							<!--<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="27" align="center">
										<div align="right"><a href="#" onclick="toadd()"><input
											type="button" value="新增" class="button_h font-red"></a>
											

										&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input
											type="button" value="审核" class="button_h font-red"></a></div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
						--></table>
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
												type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>

											<th class="table_color">ID</th>
											<!--<th class="table_color">图片名称</th>
											--><th class="table_color">图片路径</th>
											<th class="table_color">图片</th>
											<th class="table_color">汽车概述</th>
											<!--<th class="table_color">创建者</th>
											<th class="table_color">创建时间</th>


										--></tr>

										<ww:iterator value="listCarimages" status="ind">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';inimage('<ww:property value="ind.index" />');"
												onmouseout="this.className='colortrout',this.style.fontWeight='';outimage('<ww:property value="ind.index" />');">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<td class="table_color"><ww:property value="id" /></td>
												<!--<td class="table_color"><ww:property value="name" /></td>
												--><td class="table_color" ><ww:property value="carurl" />
												
												</td>
												<td class="table_color"><img src="<%=((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppathtocar'","",-1,0).get(0)).getValue() %><ww:property value="getImage(id)"/>" /></td>
												<td class="table_color"><ww:property value="getcarnameBYid(carid)" /></td>
												<!--<td class="table_color"><ww:property value="createuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
													
												
													
											--></tr>
											<tr id="hid<ww:property value="ind.index" />" style="display: none;" ><td colspan="8"><div class="box"  >
												<img src="<%=((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppath'","",-1,0).get(0)).getValue() %><ww:property value="carurl" />" style=" width:250px; height:250px;"  />	
												</div></td></tr>
											<!--<img src="<%=((Sysconfig)Server.getInstance().getSystemService().findAllSysconfig("where C_NAME='weppath'","",-1,0).get(0)).getValue() %><ww:property value="carurl" />" style=" width:250px; height:250px;"  />	
									
									
											-->
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
	<ww:if test='cid>0'>
	window.location="carimages!toadd.action?<ww:property value="url"/>&cid=<ww:property value="cid"/>";
	</ww:if><ww:else>
		window.location="carimages!toadd.action?<ww:property value="url"/>";
		</ww:else>
	}
	function outimage(ind){
	//alert("chuqu");
//document.getElementById("hid"+ind).style.display="none";
	}
	function inimage(ind){
	//alert("jinlai");
//document.getElementById("hid"+ind).style.display="block";
	}
	
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="carimages!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="carimages!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="carimages!batch.action?opt=1";
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
						
						document.form1.action="carimages!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="carimages!toedit.action?id="+uvalue;
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
						
						document.form1.action="carimages!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="carimages!tocheck.action?id="+uvalue;
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





