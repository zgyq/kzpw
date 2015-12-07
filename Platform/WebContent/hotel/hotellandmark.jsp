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
<title>酒店地标列表</title>
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
					window.location.href="hotellandmark!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addhotellandmark&<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"../images/menu/edit.gif",
				handler : function(item){
						document.landmarkform.action="hotellandmark!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=edithotellankmark&id="+selectId;
						document.landmarkform.submit();
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
						document.landmarkform.action="hotellandmark!delete.action?hotelId=<ww:property value="hotelId"/>&id="+selectId; 
						document.landmarkform.submit();
					
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

<form name="landmarkform" method="post" action="hotellandmark.action">

<input type="hidden" name="hotelid" value="<ww:property value="hotelId"/>"/> 

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店地标列表</span></td>
  </tr>
  <tr>
    <td height="455" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>
            
      		<!-- 
           <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="120" height="20" align="right">名称：</td>    <td><span style="HEIGHT: 71px">
       				<input id="s_hotellandmark"   style="WIDTH: 181px" name="s_hotellandmark" value="<ww:property value="s_hotellandmark"/>"/>
                </span></td>
                
                <td width="30%" rowspan="3"><div align="left">
                  <input type="button" class="button" value="查询" onclick="searchhotelLandmark()"/>
                </div></td>
              </tr>
              
             </table>
           
 -->


		</td>
          </tr>
          <tr>
            <td>
            <!--<table width="99%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="27" align="center"><div align="right">
                <a href="hotellandmark!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addhotellandmark&<ww:property value="url"/>">新增</a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><strong class="font-red">修改</strong></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><strong class="font-red">删除</strong></a>
                &nbsp;&nbsp;&nbsp; <a href="#" onclick="checkItem()"><strong class="font-red">审核</strong> </div></td>
              </tr>
            </table>
            -->
            
            <table width="100%" height="40" border="0" cellspacing="0" cellpadding="0" class="lj" style="font-size:12px; font-weight:bold; line-height:25px;">
		           <tr>
		        
		               <td width="75%" align="right"><a href="hotellandmark!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addhotellandmark&<ww:property value="url"/>"><div class="button_h font-red">新增</div></a></td>
		               <td width="7%" align="center"><a href="#" onclick="updateItem()"><div class="button_h font-red" >修改</div></a></td>
		               <td width="7%" align="center"><a href="#" onclick="deleteItem()"><div  class="button_h font-red" >删除</div></a></td>
		          </tr>
		        </table> 
            
            
            </td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="99%" >
						<table width="99%" id="menutable"  border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc">
                  
                  <th width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
               	   <!--  
                  <th>
                  	ID</th> -->
                  <th>
                  	地标</th>
                  <th>
                  	酒店</th>
                  	<th>
                  	距离</th>
                  	<!--
                  <th>
                  	信息描述</th>
                  
			-->
			</tr>

		<ww:iterator value="listHotellandmark">
	      <tr id='<ww:property value="id"/>' align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
	
		   <td><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>
		
			<!-- 
			<td><ww:property value="id"/></td> -->
			<td><ww:property value="getHotelLandNameById(id)"/></td>
			<td><ww:property value="gethotelNamebyId(hotelid)"/></td>
			<td><ww:property value="description"/>公里</td>
			<!--<td><ww:property value="range"/></td>
	-->
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
<script language="JavaScript">
	
	
	function deleteItem(){
			var length=document.landmarkform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.landmarkform.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.landmarkform.action="hotellandmark!delete.action?id="+document.landmarkform.selectid.value + "&hotelId=<ww:property value="hotelId"/>";
							document.landmarkform.submit();
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
					         
					         if( document.landmarkform.selectid[i].checked ==true){
								uvalue=document.landmarkform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.landmarkform.action="hotellandmark!delete.action?id="+uvalue + "&hotelId=<ww:property value="hotelId"/>";
								document.landmarkform.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.landmarkform.action="hotellandmark!batch.action?opt=1&hotelId=<ww:property value="hotelId"/>";
								document.landmarkform.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.landmarkform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.landmarkform.selectid.checked ==true)
				{
						
						document.landmarkform.action="hotellandmark!tabs.action?id="+ document.landmarkform.selectid.value + "&hotelId=<ww:property value="hotelId"/>" + "&tabtype=edithotellankmark";
						document.landmarkform.submit();
						
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
					         
					         if( document.landmarkform.selectid[i].checked ==true){
								uvalue=document.landmarkform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.landmarkform.action="hotellandmark!tabs.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>"+"&tabtype=edithotellankmark";
								document.landmarkform.submit();
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
			var length=document.landmarkform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.landmarkform.selectid.checked ==true)
				{
						
						document.all.landmarkform.action="hotellandmark!tocheck.action?id="+document.landmarkform.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
						document.all.landmarkform.submit();
						
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
					         
					         if( document.landmarkform.selectid[i].checked ==true){
								uvalue=document.landmarkform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.landmarkform.action="hotellandmark!tocheck.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.landmarkform.submit();
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
    if(document.landmarkform.all.checked){
	document.landmarkform.all.checked = document.landmarkform.all.checked&0;
    }
}

function selectall1()
{
    var length=document.landmarkform.selectid.length;
    document.landmarkform.all1.checked = document.landmarkform.all1.checked|0;
  

   if ( length ==undefined &&  document.landmarkform.selectid!=null ){
    	  document.landmarkform.selectid.checked=document.landmarkform.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.landmarkform.selectid[i].checked = document.landmarkform.all1.checked;
	      document.landmarkform.all.checked=document.landmarkform.all1.checked;
       }
    }
}
function searchhotelLandmark()
{
	document.landmarkform.submit();
}

</script>
</html>








