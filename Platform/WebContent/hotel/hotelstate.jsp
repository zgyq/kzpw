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
<title>酒店状态</title>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>
<form name="hotelstate" method="post" action="hotelstate.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg" ><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店状态</span></td>
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
        <ww:property value="hotel.name"/>
        </td>
					</tr>
					<tr>
						<td>
						<!--<table width="99%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="27" align="center">
								<div align="right"><a href="hotelstate!tabs.action?tabtype=edithotelstate&hotelId=<ww:property value="hotelId"/>&<ww:property value="url"/>">修改</a>
								  &nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><strong class="font-red">审核</strong> </div>
								</td>
							</tr>
						</table>
						-->
						
				<table width="100%" height="40" border="0" cellspacing="0" cellpadding="0" class="lj" style="font-size:12px; font-weight:bold; line-height:25px;">
		           <tr>
		               <td width="75%" align="right"><a href="hotelstate!tabs.action?tabtype=edithotelstate&hotelId=<ww:property value="hotelId"/>&<ww:property value="url"/>"><div class="xiugai" >修改</div></a></td>
		          </tr>
		        </table> 
						
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td height="306" valign="top">
				<table width="100%" border="1" align="center" bordercolor="#a0cfee"
					style="border-collapse:collapse">
					<tbody>
						<tr bgcolor="#d7e9fc">
							<th height="28" colspan="6" align="left" bgcolor="#d7e9fc"><span
								class="font-blue-cu">状态信息</span></th>
						</tr>

						<tr align="center"
							onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
							onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
							<td width="97"><span
								style="WIDTH: 150px; HEIGHT: 30px; TEXT-ALIGN: right">状态</span>:</td>
							<td colspan="5" align="left">
							<ww:if test="hotel.state==3">上网</ww:if>
							<ww:if test="hotel.state==4">下网</ww:if>
							<ww:if test="hotel.state==0">待审核</ww:if>
							</td>
						</tr>
						<tr align="center"
							onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
							onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
							<td><span style="WIDTH: 150px; HEIGHT: 30px; TEXT-ALIGN: right">备注：</span></td>
							<td colspan="5" align="left"><ww:property value="des"/></td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
			<tr>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>


<script language="JavaScript">
	
	
 function checkItem(){
			var length=document.hotelstate.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.hotelstate.selectid.checked ==true)
				{
						
						document.all.hotelstate.action="hotelimage!tocheck.action?id="+document.hotelstate.selectid.value;
						document.all.hotelstate.submit();
						
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
					         
					         if( document.hotelstate.selectid[i].checked ==true){
								uvalue=document.hotelstate.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.all.hotelstate.action="hotelimage!tocheck.action?id="+uvalue;
								document.all.hotelstate.submit();
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
    if(document.hotelstate.all.checked){
	document.hotelstate.all.checked = document.hotelstate.all.checked&0;
    }
}

function selectall1()
{
    var length=document.hotelstate.selectid.length;
    document.hotelstate.all1.checked = document.hotelstate.all1.checked|0;
  

   if ( length ==undefined &&  document.hotelstate.selectid!=null ){
    	  document.hotelstate.selectid.checked=document.hotelstate.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.hotelstate.selectid[i].checked = document.hotelstate.all1.checked;
	      document.hotelstate.all.checked=document.hotelstate.all1.checked;
       }
    }
}


</script>





