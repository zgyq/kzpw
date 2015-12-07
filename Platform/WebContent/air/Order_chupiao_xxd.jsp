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
    <title>机票业务：打印信息单</title>
  <link types="text/css" rel="stylesheet" href="style/base100108.css">
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>

</head>
<!--<body onbeforeunload="checkLeave()" onLoad="getSystemFonts()"><OBJECT ID="dlgHelper" CLASSID="clsid:3050f819-98b5-11cf-bb82-00aa00bdce0b" WIDTH="0px" HEIGHT="0px"></OBJECT>

    <form id="form1" runat="server">
    <input type="button" runat="server" id="btnclosed" style="display:none;width:0px;height:0px" />
    行程单列表
    <div>
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
                                    </tr>
            <tr>
                
              <td class="main_maintdbg" colspan="4">
                    <table border="0" cellpadding="0" cellspacing="0" class="main_lanpan" width="99%">
                        <tr>
                            <td class="main_lanpanhead" style="width: 963px">行程单样图</td>

                        </tr>
                        <tr>
                          <td style="width: 963px">
                                                       
                        <table border="0" cellpadding="0" cellspacing="0" style="width: 100%">
                                    <tr>
                                        <td colspan="4" align="center"><img src="images/piaobig.jpg" width="783" height="380" align="absmiddle" />&nbsp;
                                        
                                            <asp:TextBox ID="SerialNumSec" runat="server" CssClass="headtextbox" Width="89px" text="请填写一位尾号" style="left: 863px; position: absolute; top: 86px; background-color: transparent" onfocus=onitw() onblur=overw() Visible="False"></asp:TextBox>
                                                    <asp:TextBox ID="txtZhekou" runat="server" Visible="false" text="请填写折扣(如0.4)" onfocus="onit();" onpropertychange="initHiden();" style="left: 553px; position: absolute;width:120px; top: 186px;"></asp:TextBox>
                                                    <asp:TextBox ID="txtZhekou1" runat="server" Visible="false" text="请填写折扣(如0.4)" onfocus="onit1();" onpropertychange="initHiden();" style="left: 553px; position: absolute;width:120px; top: 210px;"></asp:TextBox>
                                            <asp:TextBox ID="ComCode" runat="server" CssClass="headtextbox" Text="BJS887" Width="58px" style="left: 195px; position: absolute; top: 376px; background-color: transparent; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;"></asp:TextBox>
                                            <asp:TextBox ID="AgentCode" runat="server" CssClass="headtextbox" Text="08049086" Width="58px" style="left: 195px; position: absolute; top: 393px; background-color: transparent; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;"></asp:TextBox>
                                            <asp:TextBox ID="Company" runat="server" CssClass="headtextbox" Text="杭州佳辉" Width="196px" style="left: 384px; position: absolute; top: 380px; background-color: transparent; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;"></asp:TextBox></td>
                                    
                                    </tr>
                            <tr>
                                <td align="center" colspan="4">
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                </td>
                            </tr>
                            </table>
                          </td>
                        </tr>
                    </table>
                    <table border="0" cellpadding="0" cellspacing="0" class="main_lanpan" width="99%">
                      <tr>
                        <td class="main_lanpanhead">乘机人选择 </td>
                      </tr>
                      <tr>
                        <td align="left"><table border="0" cellpadding="0" cellspacing="0" style="width: 100%">
                            <tr>
                              <td height="35" colspan="4" align="left"> 
                              <ww:iterator value="listPassenger">
                              <td align="left"><input name="ticketPerson" type="radio" value="<ww:property value="id" />" /><ww:property value="name" /></td>
                               </ww:iterator>
                              
                                  
                                  </td>
                            </tr>
                            <tr>
                              <td height="30" colspan="4" align="left">&nbsp; <input style="dispaly:none" type="button" value="页面预览(STAR专用打印)"  id="PrintGo" onclick="goPrintPage()" /> 
                                  &nbsp;&nbsp;
                                  <input type="button" value="页面预览(普通打印机)"  id="Button1" onclick="goPrintPage1()" />&nbsp;
                                  <asp:HiddenField ID="orderid" runat="server" />
                                  <asp:HiddenField ID="Hfzhekou" runat="server" />
                                  <asp:HiddenField ID="HfVersion" runat="server" />
                                  <asp:HiddenField ID="Hfzhekou1" runat="server" />
                                  <asp:HiddenField ID="HfFlag" runat="server" />
                              </td>
                            </tr>
                        </table></td>
                      </tr>
                    </table></td>
                
            </tr>
            <tr>
                
                
            </tr>
        </table>
    
    </div>
    </form>
</body>
-->
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
                              <ww:iterator value="listPassenger">
                              <td align="left">
                              <input name="ticketPerson" type="radio" onclick="setid(<ww:property value="id" />)" value="<ww:property value="id" />" /><ww:property value="name" /></td>
                               </ww:iterator>
                              
                                  
                                  </td>
                            </tr>
                         验证码:  <input name="yanzma" type="text" id="hidyzm" value=""  />(此地方为行程单上编号,请勿乱写.谢谢合作)
                           
                        </table>
                         <input name="passid" type="hidden" id="hid" value="0"   />  
                         
                       <input name=""  id="sub" type="button" value="打印预览"  onclick="popup('passenger!topassenger_xxd.action');" />  
                        
</td></tr></table></form>

</body>
</html>
<SCRIPT LANGUAGE="javascript"> 

function valadateaXCD(xcdno){


				$.ajax({
			      type:"POST",
			      async:false,
			      url:"xcdno!valadateaNumInfo.action",
			      data:{s_numinfo:xcdno},
			      success:function(data){
			    // alert(data);
			      	if(data=='-1'){
			      		alert("无可用行程单号");
			      		document.getElementById("sub").disabled='disabled';
			      			return;
			      		//
			      	}
			      	if(data=='1'){
			      		alert("可用的行程单号");
			      		document.getElementById("sub").disabled=false;
			      			return;
			      		
			      	}
			      	if(data=='2'){
			      		alert("行程单号已经使用过");
			      		document.getElementById("sub").disabled='disabled';
			      			return;
			      		
			      	}
			      }            
			      });
			      

}


function setid(id){
//alert(id);
document.getElementById("hid").value=id;

}

function popup(url){

if(document.getElementById("hid").value==0){
	alert("请选择一个乘机人!!!");
	return;
}
if(document.getElementById("hidyzm").value==''){
	alert("请输入行程单号后4位");
	return;
}	
	
url=url+"?pid="+document.getElementById("hid").value+"&username="+document.getElementById("hidyzm").value;
window.open(url, 'newwindow', 'height=800, width=1200, top=50, left=100, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=no'); 
}

</SCRIPT> 
