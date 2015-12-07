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

<form name="priceform" method="post">

<input type="hidden" name="hotelid" value="<ww:property value="hotelId"/>" />
<input type="hidden" name="hotel.name" value="<ww:property value="hotel.name"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
	<tr>
		<td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:property value="hotelName" />&nbsp;&nbsp;酒店价格列表</span></td>
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
						<td width="100%">
						<table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
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
										
										<td><ww:property value="hotel.name" /></td>
										<td><ww:property value="getroomnamebyroomid(roomid)" /></td>
										<td><ww:property value="datenumber"/></td>
										<td><a href="javascript:toPricequeryandview(<ww:property value="roomid"/>,<ww:property value="id"/>,<ww:property value="hotelid"/>)">查看明细</a></td>
										<input type="hidden" id="hotelprice.datenumber<ww:property value="id"/>" name="hotelprice.datenumber<ww:property value="id"/>" value="<ww:property value="datenumber"/>"/>
										<!-- <td><ww:property value="filepath" /></td> -->
									</tr>
								</ww:iterator>
									<input type="hidden" id="hotelName" name="hotel.name" value="<ww:property value="hotel.name"/>"/>
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
function toPricequeryandview(id,date,hotelid){
	var hotelName = document.getElementById("hotelName").value;
	var priceDate = document.getElementById("hotelprice.datenumber"+date).value;

	window.location.href="hotel!toPricequeryview.action?hotel.name="+hotelName+"&hotelprice.roomid="+id+"&hotelprice.hotelid="+hotelid+"&hotelprice.datenumber="+priceDate+"&tabtype=to_shows"+"&hotelId="+hotelid;
}

</script>





