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
<title>系统角色列表</title>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/dtree/dtree.js"></script>
<link href="js/dtree/dtree.css" rel="stylesheet" type="text/css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script>

$(document).ready(function(){
<ww:iterator value="#request.userroles">
$('#selectid<ww:property value="roleid"/>').attr("checked","checked");
</ww:iterator>
});
function checkRole(){
var l=$("input[name='userrole']:checked").length;
if(l>0){
return true;
}else{
  alert("请至少选择一种角色！");
  return false;
 }
}
</script>


 
</head>
<body>
<div id="member">
<form action="customeruser!grantUserRole.action" onsubmit="return checkRole();" name="form1" method="post">
<input type='hidden' name='id' value='<ww:property value="customeruser.id"/>' />
<input type='hidden' name='agentid' value='<ww:property value="customeruser.agentid"/>' />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;给:<strong style="color: red"><ww:property value="customeruser.membername"/></strong>分配角色</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
   
    <table>
     <tr>
        <td height="306" valign="top">
        <table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%">
            <table width="85%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse;padding-top: 10px">
              <tbody>
                <tr bgcolor="#d7e9fc">
                  
                  <th width="80" height="25">分配角色</th>               	     
           		 <th width="54">
                  	ID</th>
                  <th width="400">角色名称</th>
                  <th width="400">角色代码</th>       
                  <th width="400">所属类型</th>       
			</tr>
	<ww:iterator value="listSystemrole" id="listSysright">
	
		
	      	<tr align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
		   <td>
		   <input type="checkbox" id='selectid<ww:property value="id"/>'
		    name="userrole" value='<ww:property value="id"/>' />
		   </td>
				<td align="left" style="padding-left: 5px"><ww:property value="id"/></td>
				<td align="left" style="padding-left: 5px"><strong><ww:property value="name"/></strong></td>
				<td align="left" style="padding-left: 5px"><ww:property value="code"/></td>
				<td align="left" style="padding-left: 5px"><ww:property value="type==1?'平台':type==2?'供应':'采购'"/></td>
			</tr>
	
					
	</ww:iterator>
			
  <input type="hidden" name="memberid" value="<ww:property value="memberid"/>"  />
  
   
   
           </tbody>
            </table></td>
          </tr>
          <tr><td height="10px"></td></tr><!-- onclick="javascript:window.location.href='${befRoleURL}'" -->
          <tr><td align="center">
          <input type="submit"  class="button_d font-white" value="提&nbsp;&nbsp;交"/>
          <input type="button" onclick="javascript:window.history.go(-1)" class="button_d font-white" value="返&nbsp;&nbsp;回"/>
			</td></tr>
          
        </table>
    



</td>
   </tr>
   </table>
</td>
</tr>
</table>
</form>
</div>
<!--<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;给:<strong><ww:property value="getmembername(memberid)"/></strong>分配角色</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
    
  
   
    <table>
     <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc">
                  
                  <th width="54" height="25">分配角色</th>
               	     
           		 <th width="54">
                  	ID</th>
                  <th width="400">
                  	角色名称</th>
                  <th width="400">
                  	角色代码</th>
                  
                  
                
        
			</tr>
	<ww:iterator value="listSystemrole" id="listSysright">
	      <tr align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
		   <td>
		   <input type="checkbox" id="selectid" onclick="allocat(this,<ww:property value="memberid"/>);" name="selectid" value="<ww:property value="id"/>" 
		   <ww:if test="hasRole(memberid,id)">checked</ww:if>/>
		   </td>
				<td align="left"><ww:property value="id"/></td>
				<td align="left"><strong><ww:property value="name"/></strong></td>
				<td align="left"><ww:property value="code"/></td>
			</tr>
			
					
	</ww:iterator>
			

           </tbody>
            </table></td>
          </tr>
          <tr><td height="10px"></td></tr> onclick="javascript:window.location.href='${befRoleURL}'" 
          <tr><td align="center"><input type="button" onclick="window.location.href='customeruser!touser.action?<ww:property value="url"/>';" class="button_d font-white" value="返&nbsp;&nbsp;回"/> </td></tr>
          
        </table>
    



</td>
   </tr>
   </table>
</td>
</tr>
</table>
</div>
-->
</body>
</html>


<script language="JavaScript">
function fanhui(){
window.location.href="customeruser!toSupplyUsersList.action";
}
function allocat(select,memid)
	{	

	//alert(roid);
	//alert(memid+"00"+select);
	
	
		if(select.checked==true)
		{
			window.location.href='customeruser!enable.action?roid='+select.value+'&memberid=<ww:property value="memberid"/>';
		
		}else{
		
			window.location.href='customeruser!unable.action?roid='+select.value+'&memberid=<ww:property value="memberid"/>';
		
		}
	
	}

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
						
							document.form1.action="systemrole!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="systemrole!delete.action?id="+uvalue;
								document.form1.submit();
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





