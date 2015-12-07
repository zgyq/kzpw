<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%/**
			 * 版权所有, 允风文化
			 * Author: 允风文化 项目开发组
			 * copyright: 2009
			 *
			 *
			 *  HISTORY
			 *  
			 *  2009/08/14 创建
			 *
			 */

		%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店联系人列表</title>
<link href="../css/base.css" rel="stylesheet" />
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
					window.location.href="hotellinkman!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addlinkman&<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"../images/menu/edit.gif",
				handler : function(item){
						document.hotellinkmanform.action="hotellinkman!tabs.action?hotelid=<ww:property value="hotelId"/>&tabtype=editlinkman&id="+selectId;
						document.hotellinkmanform.submit();
				}
            },
			
			{
                id:"delete",
				text:"删除",
				icon:"../images/menu/delete.gif",
				handler : function(item){
					Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						document.hotellinkmanform.action="hotellinkman!delete.action?hotelid=<ww:property value="hotelId"/>&id="+selectId; 
						document.hotellinkmanform.submit();
					
						}
					}});
					
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

<form name="hotellinkmanform" method="post" action="hotellinkman.action">
<input type="hidden" name="hotelId"
	value="<ww:property value="hotelId"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店联系人列表</span></td>
	</tr>
	<tr>
		<td height="455" valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><!--         
         
           <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="120" height="20" align="right">名称：</td>    <td><span style="HEIGHT: 71px">
                  <input id="startnum2"   style="WIDTH: 181px" name="startnum2" />
                </span></td>
                
                <td width="30%" rowspan="3"><div align="left">
                  <input type="button" class="button" value="查询"/>
                </div></td>
              </tr>
              
             </table>
         
--></td>
					</tr>
					<tr>
						<td>
						<!--<table width="99%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="27" align="center">
								<div align="right"><a
									href="hotellinkman!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addlinkman&<ww:property value="url"/>">新增</a>
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><strong
									class="font-red">修改</strong></a> &nbsp;&nbsp;&nbsp;<a href="#"
									onclick="deleteItem()"><strong class="font-red">删除</strong></a>
							 	&nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><strong
									class="font-red">审核</strong> </div>
								</td>
							</tr>
						</table>
						-->
						
						<table width="100%" height="40" border="0" cellspacing="0" cellpadding="0" class="lj" style="font-size:12px; font-weight:bold; line-height:25px;">
		           <tr>
		        
		               <td width="75%" align="right"><a href="hotellinkman!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addlinkman&<ww:property value="url"/>"><div class="button_h font-red"  >新增</div></a></td>
		               <td width="7%" align="center"><a href="#" onclick="updateItem()"><div class="button_h font-red" >修改</div></a></td>
		               <td width="7%" align="center"><a href="#" onclick="deleteItem()"><div  class="button_h font-red" >删除</div></a></td>
		          </tr>
		        </table> 
						
						
						
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
						<td width="99%" >
						<table width="99%" id="menutable"  border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
							<tbody>
								<tr bgcolor="#d7e9fc">

									<th width="54" height="25"><input type="checkbox" name="all1"
										value="1" onclick="selectall1()" />全选</th>


									<th>姓名</th>
									<th>性别</th>
									<th>职务</th>
									<th>座机</th>
									<th>手机</th>
									<th>传真</th>
									<th>酒店名称</th>
									<th>创建时间</th>
									<th>创建者</th>
									<th>修改者</th>
									<th>修改时间</th>
							<!-- 		<th>状态</th> -->



								</tr>

								<ww:iterator value="listHotellinkman">
									<tr id="<ww:property value="id"/>" align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										<td><input type="checkbox" name="selectid"
											value="<ww:property value="id"/>" /></td>


										<!--  <td><ww:property value="id" /></td>-->
										<td><ww:property value="name" /></td>
										<td><ww:if test="sex==1">男</ww:if><ww:if test="sex==2">女</ww:if></td>
										<td><ww:property value="duty" /></td>
										<td><ww:property value="tell" /></td>
										<td><ww:property value="mobil" /></td>
										<td><ww:property value="fax" /></td>
										<td><ww:property value="getHotelNameById(hotelid)" /></td>
										<td><ww:property value="formatTimestamp(createtime)" /></td>
										<td><ww:property value="createuser" /></td>
										<td><ww:property value="modifyuser" /></td>
										<td><ww:property value="formatTimestamp(modifytime)" /></td>
										<!-- <td><ww:property value="state" /></td> -->


									</tr>
								</ww:iterator>

							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td height="43" align="center"><ww:property value="pagination" /></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>


<script language="JavaScript">
	
	
	function deleteItem(){
			var length=document.hotellinkmanform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotellinkmanform.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.hotellinkmanform.action="hotellinkman!delete.action?id="+document.hotellinkmanform.selectid.value + "&hotelid=<ww:property value="hotelId"/>";
							document.hotellinkmanform.submit();
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
					         
					         if( document.hotellinkmanform.selectid[i].checked ==true){
								uvalue=document.hotellinkmanform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.hotellinkmanform.action="hotellinkman!delete.action?id="+uvalue + "&hotelid=<ww:property value="hotelId"/>";
								document.hotellinkmanform.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.hotellinkmanform.action="hotellinkman!batch.action?opt=1&hotelid=<ww:property value="hotelId"/>";
								document.hotellinkmanform.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
 			
			var length=document.hotellinkmanform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotellinkmanform.selectid.checked ==true)
				{
						
						document.hotellinkmanform.action="hotellinkman!tabs.action?id="+document.hotellinkmanform.selectid.value+"&tabtype=editlinkman";
						document.hotellinkmanform.submit();
						
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
					         
					         if( document.hotellinkmanform.selectid[i].checked ==true){
								uvalue=document.hotellinkmanform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.hotellinkmanform.action="hotellinkman!tabs.action?id="+uvalue+"&tabtype=editlinkman";
								document.hotellinkmanform.submit();
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
			var length=document.hotellinkmanform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotellinkmanform.selectid.checked ==true)
				{
						
						document.all.hotellinkmanform.action="hotellinkman!tocheck.action?id="+document.hotellinkmanform.selectid.value + "&hotelId=<ww:property value="hotelId"/>";
						document.all.hotellinkmanform.submit();
						
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
					         
					         if( document.hotellinkmanform.selectid[i].checked ==true){
								uvalue=document.hotellinkmanform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.hotellinkmanform.action="hotellinkman!tocheck.action?id="+uvalue +"&hotelId=<ww:property value="hotelId"/>";
								document.all.hotellinkmanform.submit();
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
    if(document.hotellinkmanform.all.checked){
	document.hotellinkmanform.all.checked = document.hotellinkmanform.all.checked&0;
    }
}

function selectall1()
{
    var length=document.hotellinkmanform.selectid.length;
    document.hotellinkmanform.all1.checked = document.hotellinkmanform.all1.checked|0;
  

   if ( length ==undefined &&  document.hotellinkmanform.selectid!=null ){
    	  document.hotellinkmanform.selectid.checked=document.hotellinkmanform.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.hotellinkmanform.selectid[i].checked = document.hotellinkmanform.all1.checked;
	      document.hotellinkmanform.all.checked=document.hotellinkmanform.all1.checked;
       }
    }
   
}


</script>





