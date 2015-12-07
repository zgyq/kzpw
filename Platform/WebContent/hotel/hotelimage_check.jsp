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
<title>酒店图片列表</title>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>
<form name="hotelimageform" method="post" action="hotelimage.action">

<input type="hidden" name="hotelid" value="<ww:property value="hotelId"/>" /> 
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店图片列表</span></td>
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
					<!-- 
					<tr>
						<td>
						<table width="99%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="27" align="center">
								<div align="right">
								<a href="hotelimage!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addhotelimag&<ww:property value="url"/>">新增</a>
								&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><strong class="font-red">修改</strong></a> &nbsp;&nbsp;&nbsp;<a
									href="#" onclick="deleteItem()"><strong class="font-red">删除</strong></a> &nbsp;&nbsp;&nbsp;<a href="#"
									onclick="checkItem()"><strong class="font-red">审核</strong></div>
								</td>
							</tr>
							<tr align="left">
									
										<ww:property value="hotelName"/>
									
								</tr>
						</table>
						</td>
					</tr>
					 -->
				</table>
				</td>
			</tr>
			<tr>
				<td height="306" valign="top">
				<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100%">
						<table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
							<tbody>
								<tr bgcolor="#d7e9fc">

									
								<!-- 	<th>ID</th> -->
									<th>类型</th>
									<th>图片</th>
									<th>描述</th>
								
								</tr>

								<ww:iterator value="listHotelimage">
									<tr align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										
										<!--  <td><ww:property value="id" /></td>-->
										<td width="150"><ww:if test="type==1">小图标</ww:if><ww:if test="type==2">图片集</ww:if><ww:if test="type==3">推荐图片</ww:if></td>
										<td width="150"><img src="<ww:property value="getImgPath(path)" />" alt=""  width=80px  height=70px/></td>
										
										<td><ww:property value="description" /></td>
										
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
			var length=document.hotelimageform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelimageform.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.all.hotelimageform.action="hotelimage!delete.action?id="+document.hotelimageform.selectid.value + "&hotelId=<ww:property value="hotelId"/>";
							document.all.hotelimageform.submit();
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
					         
					         if( document.hotelimageform.selectid[i].checked ==true){
								uvalue=document.hotelimageform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.all.hotelimageform.action="hotelimage!delete.action?id="+uvalue + "&hotelId=<ww:property value="hotelId"/>";
								document.all.hotelimageform.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.all.hotelimageform.action="hotelimage!batch.action?opt=1&hotelId=<ww:property value="hotelId"/>";
								document.all.hotelimageform.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.hotelimageform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelimageform.selectid.checked ==true)
				{
						
						document.all.hotelimageform.action="hotelimage!toedit.action?id=" + document.hotelimageform.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
						document.all.hotelimageform.submit();
						
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
					         
					         if( document.hotelimageform.selectid[i].checked ==true){
								uvalue=document.hotelimageform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.hotelimageform.action="hotelimage!toedit.action?id="+uvalue +"&hotelId=<ww:property value="hotelId"/>";
								document.all.hotelimageform.submit();
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
			var length=document.hotelimageform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelimageform.selectid.checked ==true)
				{
						
						document.all.hotelimageform.action="hotelimage!tocheck.action?id="+document.hotelimageform.selectid.value;
						document.all.hotelimageform.submit();
						
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
					         
					         if( document.hotelimageform.selectid[i].checked ==true){
								uvalue=document.hotelimageform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.hotelimageform.action="hotelimage!tocheck.action?id="+uvalue;
								document.all.hotelimageform.submit();
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
    if(document.hotelimageform.all.checked){
	document.hotelimageform.all.checked = document.hotelimageform.all.checked&0;
    }
}

function selectall1()
{
    var length=document.hotelimageform.selectid.length;
    document.hotelimageform.all1.checked = document.hotelimageform.all1.checked|0;
  

   if ( length ==undefined &&  document.hotelimageform.selectid!=null ){
    	  document.hotelimageform.selectid.checked=document.hotelimageform.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.hotelimageform.selectid[i].checked = document.hotelimageform.all1.checked;
	      document.hotelimageform.all.checked=document.hotelimageform.all1.checked;
       }
    }
}


</script>





