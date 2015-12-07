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
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>机票业务：打印行程单</title>
  <link types="text/css" rel="stylesheet" href="style/base100108.css">
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>

</head>

<style type="text/css">
.tr {
	text-align: left;
}

.td2 {
	width: 107px;
}

.textbox2 {
	width: 80px;
	border: 1px solid #666666;
}

.table {
	margin: 0px;
	padding: 0px;
	text-align: center;
	border: 0px;
}
</style>



</head>
<body>
<form name="form1" method="post" action="passenger!topassenger.action" id="form1">
	
				<table border="0" cellpadding="0" cellspacing="0" class="main_lanpan" width="99%">
                      <tr>
                        <td class="main_lanpanhead">乘机人选择 </td>
                      </tr>
                      <tr>
                        <td align="left"><table border="0" cellpadding="0" cellspacing="0" style="width: 100%">
                            <tr>
                              <td height="35" colspan="4" align="center"> 
                              <ww:iterator value="listpass">
                              <td align="left">
                              <input name="ticketPerson" type="radio" onclick="setid(<ww:property value="id" />)" value="<ww:property value="id" />" /><ww:property value="name" /></td>
                               </ww:iterator>
                              
                                  
                                  </td>
                            </tr>
                       
                           
                        </table>
                         <input name="passid" type="hidden" id="hid" value="0"   />  
                         
                       <input name=""  id="sub" type="button" value="去购买保险"  onclick="tobaoxian();" />  
                        
</td></tr></table></form>

</body>
</html>
<SCRIPT LANGUAGE="javascript"> 



function setid(id){
//alert(id);
document.getElementById("hid").value=id;

}
function tobaoxian(){

var pid=document.getElementById("hid").value;

window.location.href="insurance!toservice.action?passid="+pid;

}

</SCRIPT> 
