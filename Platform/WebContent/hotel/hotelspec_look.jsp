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
<title>酒店注意事项列表</title>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>

<form name="hotelspecform" method="post" action="hotelspec.action"><input
	type="hidden" name="hotelid" value="<ww:property value="hotelId"/>" />

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg" ><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店注意事项列表</span></td>
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
		<!-- 
          <tr>
            <td><table width="99%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="27" align="center"><div align="right">
                <a href="hotelspec!tabs.action?hotelId=<ww:property value="hotelId"/>&tabtype=addhotelspec&<ww:property value="url"/>">新增</a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><strong class="font-red">修改</strong></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><strong class="font-red">删除</strong></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><strong class="font-red">审核</strong></div></td>
              </tr>
            </table></td>
          </tr>
           -->
				</table>
				</td>
			</tr>
			<tr>
				<td height="306" valign="top">
				<table width="99%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td width="100%">
						<table width="100%" border="1" align="center"
							bordercolor="#a0cfee" style="border-collapse:collapse">
							<tbody>
								<tr bgcolor="#d7e9fc">

									<!-- <th width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>  
               	     
                  <th>
                  	ID</th>
                  	<th>状态</th>
                  	-->
									<th>起始日期</th>
									<th>终止日期</th>
									
									<th>酒店ID</th>
									<th>描述</th>
									<th>创建者</th>
									<th>创建时间</th>
									<th>修改者</th>
									<th>修改时间</th>



								</tr>

								<ww:iterator value="listHotelspec">
									<tr align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										<!--   <td><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>
										<td><ww:property value="id"/></td>-->
										<td><ww:property value="formatTimestamp(startdate)" /></td>
										<td><ww:property value="formatTimestamp(enddate)" /></td>
										<!-- <td><ww:property value="state" /></td> -->
										<td><ww:property value="hotelid" /></td>
										<td><ww:property value="description" /></td>
										<td><ww:property value="createuser" /></td>
										<td><ww:property value="formatTimestamp(createtime)" /></td>
										<td><ww:property value="modifyuser" /></td>
										<td><ww:property value="formatTimestamp(modifytime)" /></td>


									</tr>
								</ww:iterator>

							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td height="43" align="center"><ww:property value="pagination" />
						</td>
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
			var length=document.hotelspecform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelspecform.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.all.hotelspecform.action="hotelspec!delete.action?id="+document.hotelspecform.selectid.value +"&hotelId=<ww:property value="hotelId"/>";
							document.all.hotelspecform.submit();
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
					         
					         if( document.hotelspecform.selectid[i].checked ==true){
								uvalue=document.hotelspecform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.all.hotelspecform.action="hotelspec!delete.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.hotelspecform.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.all.hotelspecform.action="hotelspec!batch.action?opt=1&hotelId=<ww:property value="hotelId"/>";
								document.all.hotelspecform.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.hotelspecform.selectid.length;
			//唯一项
			if(length== undefined){
			
				if(document.hotelspecform.selectid.checked ==true)
				{
						
						document.all.hotelspecform.action="hotelspec!toedit.action?id="+ document.hotelspecform.selectid.value+ "&hotelId=<ww:property value="hotelId"/>";
						document.all.hotelspecform.submit();
						
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
					         
					         if( document.hotelspecform.selectid[i].checked ==true){
								uvalue=document.hotelspecform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.hotelspecform.action="hotelspec!toedit.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.hotelspecform.submit();
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
			var length=document.hotelspecform.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelspecform.selectid.checked ==true)
				{
						
						document.all.hotelspecform.action="hotelspec!tocheck.action?id="+document.hotelspecform.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
						document.all.hotelspecform.submit();
						
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
					         
					         if( document.hotelspecform.selectid[i].checked ==true){
								uvalue=document.hotelspecform.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.hotelspecform.action="hotelspec!tocheck.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.hotelspecform.submit();
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
    if(document.hotelspecform.all.checked){
	document.hotelspecform.all.checked = document.hotelspecform.all.checked&0;
    }
}

function selectall1()
{
    var length=document.hotelspecform.selectid.length;
    document.hotelspecform.all1.checked = document.hotelspecform.all1.checked|0;
  

   if ( length ==undefined &&  document.hotelspecform.selectid!=null ){
    	  document.hotelspecform.selectid.checked=document.hotelspecform.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.hotelspecform.selectid[i].checked = document.hotelspecform.all1.checked;
	      document.hotelspecform.all.checked=document.hotelspecform.all1.checked;
       }
    }
}


</script>





