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
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>

<form name="hetongform" method="post" action="hotelcontract.action">

<input type="hidden" name="hotelid" value="<ww:property value="hotelId"/>" />
<input type="hidden" name="hotelName" value="<ww:property value="hotelName"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店合同列表</span></td>
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

								<!--  <th width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>-->	


									<th>酒店名称:</th>
									<th>合同编号</th>
									<th>签约日期</th>
									<th>终止日期</th>
									<th>酒店签约人</th>
									<th>公司签约人</th>
									<th>合同内容</th>
									<th>合同文件路径</th>



								</tr>

								<ww:iterator value="listHotelcontract">
									<tr align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										<!--  <td><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>-->
										<td><ww:property value="hotelName" /></td>
										<td><ww:property value="code" /></td>
										<td><ww:property value="formatDate(signdate)" /></td>
										<td><ww:property value="formatDate(enddate)" /></td>
										<td><ww:property value="hotelsigner" /></td>
										<td><ww:property value="compsigner" /></td>
										<td><ww:property value="content" /></td>
										<td><a href="<ww:property value="getHeTongPath(filepath)"/>">下载</a></td>
										<!-- <td><ww:property value="filepath" /></td> -->


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
						
							document.all.hetongform.action="hotelcontract!delete.action?id="+document.hetongform.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
							document.all.hetongform.submit();
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
								document.all.hetongform.action="hotelcontract!delete.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.hetongform.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.all.hetongform.action="hotelcontract!batch.action?opt=1&hotelId=<ww:property value="hotelId"/>";
								document.all.hetongform.submit();
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
						
						document.all.hetongform.action="hotelcontract!toedit.action?id="+document.hetongform.selectid.value + "&hotelId=<ww:property value="hotelId"/>";
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
					      		document.all.hetongform.action="hotelcontract!toedit.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
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





