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
<title>酒店房态列表</title>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>
<form name="roomstateform" method="post" action="roomstate.action">
<input type="hidden" name="hotelid" value="<ww:property value="hotelid"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店房态列表</span></td>
	</tr>
	<tr>
		<td height="455" valign="top">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top">&nbsp;</td>
			</tr>
			<tr>
				<td height="306" valign="top">
				<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100%">
						<table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
							<tbody>
								<tr bgcolor="#d7e9fc">

								<!--  	<th width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>-->

									<th>房型ID</th>
									<th>起始日期</th>
									<th>终止日期</th>
									<th>状态</th>
									<th>是否确认</th>
									<th>计算类别</th>
									<th>数量</th>
									<th>创建者</th>
									<th>创建时间</th>
								<!-- 	<th>操作</th> -->



								</tr>

								<ww:iterator value="listRoomstate">
									<tr align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										<!--  <td><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>-->
										<td><ww:property value="getNameById(roomtypeid)" /></td>
										<td><ww:property value="formatDate(startdate)" /></td>
										<td><ww:property value="formatDate(enddate)" /></td>
										<td><ww:property value="getStateByID(state)" /></td>
										<td><ww:property value="getConfirmById(confirmmethod)"/></td>
										<td><ww:property value="getAccById(type)" /></td>
										<td><ww:property value="num" /></td>
										<td><ww:property value="createuser" /></td>
										<td><ww:property value="formatTimestamp(createtime)" /></td>
										<!-- <td><ww:if test="state==0"><a href="roomstate!cancel.action?hotelId=<ww:property value="hotelId"/>&id=<ww:property value="id"/>">取消满房</a></ww:if> 
										</td>
										-->
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
			var length=document.roomstateform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.roomstateform.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.all.roomstateform.action="roomstate!delete.action?id="+document.roomstateform.selectid.value +"&hotelId=<ww:property value="hotelId"/>";
							document.all.roomstateform.submit();
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
					         
					         if( document.roomstateform.selectid[i].checked ==true){
								uvalue=document.roomstateform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.all.roomstateform.action="roomstate!delete.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.roomstateform.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.all.roomstateform.action="roomstate!batch.action?opt=1&hotelid=<ww:property value="hotelId"/>";
								document.all.roomstateform.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.roomstateform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.roomstateform.selectid.checked ==true)
				{
						
						document.all.roomstateform.action="roomstate!toedit.action?id="+ document.roomstateform.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
						document.all.roomstateform.submit();
						
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
					         
					         if( document.roomstateform.selectid[i].checked ==true){
								uvalue=document.roomstateform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.roomstateform.action="roomstate!toedit.action?id="+uvalue+ "&hotelId=<ww:property value="hotelId"/>";
								document.all.roomstateform.submit();
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
			var length=document.roomstateform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.roomstateform.selectid.checked ==true)
				{
						
						document.all.roomstateform.action="roomstate!tocheck.action?id="+document.roomstateform.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
						document.all.roomstateform.submit();
						
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
					         
					         if( document.roomstateform.selectid[i].checked ==true){
								uvalue=document.roomstateform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.roomstateform.action="roomstate!tocheck.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.roomstateform.submit();
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
    if(document.roomstateform.all.checked){
	document.roomstateform.all.checked = document.roomstateform.all.checked&0;
    }
}

function selectall1()
{
    var length=document.roomstateform.selectid.length;
    document.roomstateform.all1.checked = document.roomstateform.all1.checked|0;
  

   if ( length ==undefined &&  document.roomstateform.selectid!=null ){
    	  document.roomstateform.selectid.checked=document.roomstateform.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.roomstateform.selectid[i].checked = document.roomstateform.all1.checked;
	      document.roomstateform.all.checked=document.roomstateform.all1.checked;
       }
    }
}


</script>





