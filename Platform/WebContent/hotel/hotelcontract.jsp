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
<title>酒店合同列表</title>
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
					window.location.href="hotelcontract!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addcontract&<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"../images/menu/edit.gif",
				handler : function(item){
						document.hetongform.action="hotelcontract!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=editcontract&id="+selectId;
						document.hetongform.submit();
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
						document.hetongform.action="hotelcontract!delete.action?hotelId=<ww:property value="hotelId"/>&id="+selectId; 
						document.hetongform.submit();
					
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

<form name="hetongform" method="post" action="hotelcontract.action"><input type="hidden" name="hotelid" value="<ww:property value="hotelId"/>" />
<input type="hidden" name="hotelName" value="<ww:property value="hotelName"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店合同列表</span></td>
  </tr>
  <tr>
	<td height="455" valign="top">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>&nbsp;</td>
						</tr>
							       <!--   <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
								              <tr>
								                <td width="120" height="20" align="right">名称：</td>   
								                <td><span style="HEIGHT: 71px"> <input id="startnum2"   style="WIDTH: 181px" name="startnum2" /></span></td>
								                <td width="30%" rowspan="3"><div align="left"> <input type="button" class="button" value="查询"/></div></td>
								              </tr>
							              </table>
										<td><ww:property value="hotelName" /></td>
										<table width="99%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td height="27" align="center">
												<div align="right"><a href="hotelcontract!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addcontract&<ww:property value="url"/>">新增</a>
												 &nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><strong class="font-red">修改</strong></a> 
												 &nbsp;&nbsp;&nbsp;<a href="hotelcontract!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=logcontract&<ww:property value="url"/>">历史记录</a>
												 &nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><strong class="font-red">删除</strong></a>    
												 &nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><strong class="font-red">审核</strong></div>
												</td>
											</tr>
										</table>-->
							<tr>
							<td>										
											<table width="100%" height="40" border="0" cellspacing="0" cellpadding="0" class="lj" style="font-size:12px; font-weight:bold; line-height:25px;">
									           <tr>
									        
									               <td width="75%" align="right"><a href="hotelcontract!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addcontract&<ww:property value="url"/>"><div class="button_h font-red">新增</div></a></td>
									               <td width="7%" align="center"><a href="#" onclick="updateItem()"><div class="button_h font-red" >修改</div></a></td>
									               <td width="7%" align="center"><a href="hotelcontract!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=logcontract&<ww:property value="url"/>"><div class="button_h font-red">历史记录</div></a></td>  
									               <td width="7%" align="center"><a href="#" onclick="deleteItem()"><div  class="button_h font-red">删除</div></a></td>
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
									<th width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
									<!--  	<th>酒店名称:</th> -->
									<th>合同编号</th>
									<th>签约日期</th>
									<th>终止日期</th>
									<th>酒店签约人</th>
									<th>公司签约人</th>
									<th>合同内容</th>
									<th>合同文件路径</th>
								</tr>

								<ww:iterator value="listHotelcontract">
									<tr id="<ww:property value="id"/>" align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										<td><input type="checkbox" name="selectid"
											value="<ww:property value="id"/>" /></td>

										<td><ww:property value="code" /></td>
										<td><ww:property value="formatDate(signdate)" /></td>
										<td><ww:property value="formatDate(enddate)" /></td>
										<td><ww:property value="hotelsigner" /></td>
										<td><ww:property value="compsigner" /></td>
										<td><ww:property value="content" /></td>
										<td><a href="<ww:property value="getHeTongPath(filepath)"/>">下载</a></td>
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
			var length=document.hetongform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hetongform.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.hetongform.action="hotelcontract!delete.action?id="+document.hetongform.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
							document.hetongform.submit();
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
					         
					         if( document.hetongform.selectid[i].checked ==true){
								uvalue=document.hetongform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.hetongform.action="hotelcontract!delete.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.hetongform.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.hetongform.action="hotelcontract!batch.action?opt=1&hotelId=<ww:property value="hotelId"/>";
								document.hetongform.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.hetongform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hetongform.selectid.checked ==true)
				{
						
						document.hetongform.action="hotelcontract!tabs.action?id="+document.hetongform.selectid.value +"&tabtype=editcontract" + "&hotelId=<ww:property value="hotelId"/>";
						document.hetongform.submit();
						
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
					         
					         if( document.hetongform.selectid[i].checked ==true){
								uvalue=document.hetongform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.hetongform.action="hotelcontract!tabs.action?id="+uvalue+"&tabtype=editcontract"+"&hotelId=<ww:property value="hotelId"/>";
								document.hetongform.submit();
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
			var length=document.hetongform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hetongform.selectid.checked ==true)
				{
						
						document.all.hetongform.action="hotelcontract!tocheck.action?id="+document.hetongform.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
						document.all.hetongform.submit();
						
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
					         
					         if( document.hetongform.selectid[i].checked ==true){
								uvalue=document.hetongform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.hetongform.action="hotelcontract!tocheck.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.hetongform.submit();
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
    if(document.hetongform.all.checked){
	document.hetongform.all.checked = document.hetongform.all.checked&0;
    }
}

function selectall1()
{
    var length=document.hetongform.selectid.length;
    document.hetongform.all1.checked = document.hetongform.all1.checked|0;
  

   if ( length ==undefined &&  document.hetongform.selectid!=null ){
    	  document.hetongform.selectid.checked=document.hetongform.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.hetongform.selectid[i].checked = document.hetongform.all1.checked;
	      document.hetongform.all.checked=document.hetongform.all1.checked;
       }
    }
}


</script>





