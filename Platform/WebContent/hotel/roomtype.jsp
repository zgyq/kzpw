<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
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
<title>酒店房型列表</title> 
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
					window.location.href="roomtype!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addroomtype&<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"../images/menu/edit.gif",
				handler : function(item){
						document.hotelroomtype.action="roomtype!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=editroomtype&id="+selectId;
						document.hotelroomtype.submit();
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
						document.hotelroomtype.action="roomtype!delete.action?hotelId=<ww:property value="hotelId"/>&id="+selectId; 
						document.hotelroomtype.submit();
					
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
<form name="hotelroomtype" method="post" action="roomtype.action">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
	<td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店房型列表</span></td>
  </tr>
  <tr>
    <td height="455" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
       <!--   
        <ww:property value="hotel.name"/> 
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
        -->     
          <tr>
            <td>
            <table width="100%" height="40" border="0" cellspacing="0" cellpadding="0" class="lj" style="font-size:12px; font-weight:bold; line-height:25px;">
           <tr>
        
               <td width="75%" align="right"><a href="roomtype!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addroomtype&<ww:property value="url"/>"><div class="button_h font-red"  >新增</div></a></td>
               <td width="7%" align="center"><a href="#" onclick="updateItem()"><div class="button_h font-red" >修改</div></a></td>
               <td width="7%" align="center"><a href="#" onclick="deleteItem()"><div  class="button_h font-red" >删除</div></a></td>
           </tr>
           </table>
            
            </td>
          </tr>
        </table></td>
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
				 <th>
                  	房型名称</th>
                 <th>
                  	楼层</th>
                  <th>
                  	面积</th>
                  <th>
                  	描述</th>
                  <th>
                  	床型</th>
                  <th>
                  	早餐</th>
                  <th>
                  	宽带</th>
                  <th>
                  	房间设施</th>
                  <th>
                  	状态</th>              
                  	
                  <th>
                  	操作</th>              

        
                <!-- 
                  <th>
                  	房型状态</th>
                  <th>
                  	酒店ID</th>
                 -->  
                
        
			</tr>

		<ww:iterator value="listRoomtype">
	      <tr id="<ww:property value="id"/>" align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
	
		   <td style="width: 3%"><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>
		   <td style="width: 8%"><ww:property value="name"/></td>
		   <td style="width: 5%"><ww:property value="layer"/></td>
		   <td style="width: 5%"><ww:property value="areadesc"/></td>
		   <td style="width: 21%"><ww:property value="roomdesc"/></td>
		   <td style="width: 5%">		  
		   <ww:if test="bed==1">单人床</ww:if>
		   <ww:if test="bed==2">大床</ww:if>
		   <ww:if test="bed==3">双床</ww:if>
		   <ww:if test="bed==4">大或双</ww:if>
		   <ww:if test="bed==5">其他</ww:if>
		  </td>
		  <td  style="width: 5%">		  
		   <ww:if test="breakfast==1">无早</ww:if>
		   <ww:if test="breakfast==2">单早</ww:if>
		   <ww:if test="breakfast==3">双早</ww:if>
		  </td>
		  <td style="width: 5%">		  
		   <ww:if test="wideband==0">无</ww:if>
		   <ww:if test="wideband==1">免费</ww:if>
		   <ww:if test="wideband==2">收费</ww:if>
		  </td>	
		  		   
		   <td style="width: 21%">
		   <ww:property value="roomset"/></td>	
		   <td style="width: 5%">
		  	<ww:if test="state==0">禁用</ww:if>
		  	<ww:else>正常</ww:else>
		  </td>
		   <td style="width: 5%"><ww:if test="state==1"><a href="roomtype!jinyong.action?hotelId=<ww:property value="hotelId"/>&id=<ww:property value="id"/>">禁用</a></ww:if>
		   <ww:else><a href="roomtype!qiyong.action?hotelId=<ww:property value="hotelId"/>&id=<ww:property value="id"/>"><font color="#ff0000">启用</font></a></ww:else></td>
		</tr>
	</ww:iterator>

           </tbody>
            </table></td>
          </tr>
          <tr>
            <td height="43" align="center"> <ww:property value="pagination" /> </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>


<script language="JavaScript">
	function deleteItem(){
			var length=document.hotelroomtype.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelroomtype.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.hotelroomtype.action="roomtype!delete.action?id="+document.hotelroomtype.selectid.value +"&hotelId=<ww:property value="hotelId"/>";
			
							document.hotelroomtype.submit();
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
					         
					         if( document.hotelroomtype.selectid[i].checked ==true){
								uvalue=document.hotelroomtype.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.hotelroomtype.action="roomtype!delete.action?id="+uvalue + "&hotelId=<ww:property value="hotelId"/>";
								document.hotelroomtype.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.hotelroomtype.action="roomtype!batch.action?opt=1&hotelId=<ww:property value="hotelId"/>";
								document.hotelroomtype.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.hotelroomtype.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelroomtype.selectid.checked == true)
				{
						
						document.hotelroomtype.action="roomtype!tabs.action?id="+document.hotelroomtype.selectid.value + "&tabtype=editroomtype" + "&hotelId=<ww:property value="hotelId"/>" ;
						document.hotelroomtype.submit();
						
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
					         
					         if( document.hotelroomtype.selectid[i].checked ==true){
								uvalue=document.hotelroomtype.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.hotelroomtype.action="roomtype!tabs.action?id="+uvalue + "&tabtype=editroomtype" + "&hotelId=<ww:property value="hotelId"/>";
								document.hotelroomtype.submit();
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
			var length=document.hotelroomtype.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelroomtype.selectid.checked ==true)
				{
						
						document.all.hotelroomtype.action="roomtype!tocheck.action?id="+document.hotelroomtype.selectid.value;
						document.all.hotelroomtype.submit();
						
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
					         
					         if( document.hotelroomtype.selectid[i].checked ==true){
								uvalue=document.hotelroomtype.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.hotelroomtype.action="roomtype!tocheck.action?id="+uvalue;
								document.all.hotelroomtype.submit();
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
    if(document.hotelroomtype.all.checked){
	document.hotelroomtype.all.checked = document.hotelroomtype.all.checked&0;
    }
}

function selectall1()
{
    var length=document.hotelroomtype.selectid.length;
    document.hotelroomtype.all1.checked = document.hotelroomtype.all1.checked|0;
  

   if ( length ==undefined &&  document.hotelroomtype.selectid!=null ){
    	  document.hotelroomtype.selectid.checked=document.hotelroomtype.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.hotelroomtype.selectid[i].checked = document.hotelroomtype.all1.checked;
	      document.hotelroomtype.all.checked=document.hotelroomtype.all1.checked;
       }
    }
}


</script>





