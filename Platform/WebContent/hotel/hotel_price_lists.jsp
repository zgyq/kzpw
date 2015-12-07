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
<title>酒店列表</title>
<link href="../css/base.css" rel="stylesheet" />
</head>
<body>

<form name="form1" method="post" action="hotelcontract.action">

<input type="hidden" id="hotelprice.hotelid" name="hotelprice.hotelid" value="<ww:property value="hotelprice.hotelid"/>" />

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;价格列表 </span></td>
	</tr>
	<tr>
		<td height="455" valign="top">
		<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						
						<!--    
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
        <td>
       
        </td>
					</tr>
					<tr>
					<td>&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="306" valign="top">
				<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="99%">
						<table width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
							<tbody>
								<tr bgcolor="#d7e9fc">
									<th>酒店名称:</th>
									<th>酒店房型</th>
									<th>价格日期</th>
									<th>查看明细</th>
								</tr>

								<ww:iterator value="listHotelprice">
									<tr align="center"
										onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
										onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

										<!--  <td><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>-->
										
										<td><ww:property value="hotelName" /></td>
										<td><ww:property value="getroomnamebyroomid(roomid)" /></td>
										<td><ww:property value="datenumber"/></td>
										<td><a href="javascript:toPricequeryandview(<ww:property value="roomid"/>,<ww:property value="id"/>,<ww:property value="hotelid"/>)">查看明细</a></td>
										<input type="hidden" id="hotelprice.datenumber<ww:property value="id"/>" name="hotelprice.datenumber<ww:property value="id"/>" value="<ww:property value="datenumber"/>"/>
										<!-- <td><ww:property value="filepath" /></td> -->
									</tr>
								</ww:iterator>
									<input type="hidden" id="hotelName" name="hotelName" value="<ww:property value="hotelName"/>"/>
								
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td height="43" align="center"> <ww:property value="getPagination('\"hotelprice!getAllpricebyid.action?pageinfo.pagenum=\"+pageno')"/>  </td>
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
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.all.form1.action="hotelcontract!delete.action?id="+document.form1.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
							document.all.form1.submit();
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
								document.all.form1.action="hotelcontract!delete.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.all.form1.action="hotelcontract!batch.action?opt=1&hotelId=<ww:property value="hotelId"/>";
								document.all.form1.submit();
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
						
						document.all.form1.action="hotelcontract!toedit.action?id="+document.form1.selectid.value + "&hotelId=<ww:property value="hotelId"/>";
						document.all.form1.submit();
						
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
					      		document.all.form1.action="hotelcontract!toedit.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.form1.submit();
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
						
						document.all.form1.action="hotelcontract!tocheck.action?id="+document.form1.selectid.value+"&hotelId=<ww:property value="hotelId"/>";
						document.all.form1.submit();
						
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
					      		document.all.form1.action="hotelcontract!tocheck.action?id="+uvalue+"&hotelId=<ww:property value="hotelId"/>";
								document.all.form1.submit();
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
	      document.form1.all.checked=document.form1.all1.checked;
       }
    }
}
function toPricequeryandview(id,date,hotelid){

	var hotelName = document.getElementById("hotelName").value;
	var priceDate = document.getElementById("hotelprice.datenumber"+date).value;

	window.location.href="hotelprice!toPricequeryandview.action?hotelName="+hotelName+"&hotelprice.roomid="+id+"&hotelprice.hotelid="+hotelid+"&hotelprice.datenumber="+priceDate;

}

</script>





