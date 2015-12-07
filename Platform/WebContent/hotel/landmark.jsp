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
<title>地标列表</title>
	<link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
	<script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="../js/ext-all.js"></script>
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
					window.location.href="landmark!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"../images/menu/edit.gif",
				handler : function(item){
						document.form1.action="landmark!toedit.action?id="+selectId;
						document.form1.submit();
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
						document.form1.action="landmark!delete.action?id="+selectId;
						document.form1.submit();
					
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

<form name="form1" method="post" action="landmark.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;地标列表</span></td>
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
            
          
           <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60" height="20" align="right"></td>    <td><span style="HEIGHT: 71px">
                 <select id="s_landterm" name="s_landterm1" onchange="checkterm(this.value);">
                            <option value="1" <ww:if test="s_landterm1==1">selected</ww:if> >--根据地标名称查询--</option>
                			<option value="2" <ww:if test="s_landterm1==2">selected</ww:if> >--根据城市名称查询--</option>
                			<option value="3" <ww:if test="s_landterm1==3">selected</ww:if> >--根据区域名称查询--</option>
      			</select>
                  <input id="s_landmark"   style="WIDTH: 150px" name="s_landmark" value="<ww:property value="s_landmark"/>" onfocus="cheanterm();"/>
                </span>

                </td>
                <td width="30%" rowspan="3"><div align="left">
                  <input type="button" class="button_d font-white" value="查询" onclick="searchLandmark()"/>
                </div></td>
              </tr>
              
             </table>
            



		</td>
          </tr>
          <tr>
            <td>
           	<table width="100%" height="40" border="0" cellspacing="0" cellpadding="0" class="lj" style="font-size:12px; font-weight:bold; line-height:25px;">
	           <tr >
	               <td width="75%" align="right"><a href="landmark!toadd.action?<ww:property value="url"/>"><div class="button_h font-red"  >新增</div></a></td>
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
            <td width="99%"><table id="menutable" width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc">
                  
                  <th width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
               	  <!--    
                  <th>
                  	ID</th> -->
                  <th>
                  	名称</th>
                  <th>
                  	城市</th>
                  <th>
                  	区域</th>
                  <th>
                  	所属区域类型</th>
                
        
			</tr>

		<ww:iterator value="listLandmark">
	      <tr id="<ww:property value="id"/>" align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
	
		   <td><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>
		
	
<!-- <td><ww:property value="id"/></td> --><td><ww:property value="name"/></td><td><ww:property value="getCityIdByName(cityid)"/></td>
<td><ww:property value="getRegionIdByName(regionid)"/></td> <td><ww:property value="getRegionIdByType(regionid)"/></td>

		
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
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="landmark!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="landmark!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="landmark!batch.action?opt=1";
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
						
						document.form1.action="landmark!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="landmark!toedit.action?id="+uvalue;
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
						
						document.form1.action="landmark!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="landmark!tocheck.action?id="+uvalue;
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
function searchLandmark()
{
	document.form1.submit();
}
function checkterm(id)
{
	if(id=='1')
	{
		document.getElementById('s_landmark').value = "请输入地标名称";
	}
	if(id=='2')
	{
		document.getElementById('s_landmark').value = "请输入城市名称";
	}
	if(id=='3')
	{
		document.getElementById('s_landmark').value = "请输入区域名称";
	}
}
function cheanterm()
{
	document.getElementById('s_landmark').value = "";
}
</script>





