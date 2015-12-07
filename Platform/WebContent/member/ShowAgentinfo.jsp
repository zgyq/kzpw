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
<title>公司信息</title>
<link href="public/css/left.css" type="text/css" rel="stylesheet" />
<link href="public/css/public.css" type="text/css" rel="stylesheet" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="public/css/main.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<style type="text/css"> 
.val{
color: red;
}
</style>
<script type="text/javascript"> 

function windowSeach(){
//$("#form2").submit();
var ailpaynum=$("#ailpaynum").val();
//alert(ailpaynum);
if(ailpaynum==''){
alert("支付宝账号不能为空!!!");
return;
}

$("#alipayusername").val(ailpaynum);
$("#form2").submit();
}
function showwindowSeach(){

$("#divpay").dialog({
            title:'查询签约信息',
            show: null,
            bgiframe: false,
            autoOpen: false,
            draggable: true,                
            resizable: true,
            modal: true,
            width: 500,
            height: 250
           });
       $("#divpay").dialog("open");
       var htmstr="<table width='100%'><tr><td align='center'><table><tr><td><p>请输入支付宝账号:<input type='text' id='ailpaynum' name='' value=''/></p></td>";
       htmstr+="<tr><td colspan='6' height='80px'>";
       htmstr+="<input onclick='windowSeach()' class='bnt_tips' type=button value='签约查询'/></td></tr></table></td></tr></table>";
        $("#divpay").html(htmstr);           
		           
}
function showwindow(){
$("#form1").submit();
$("#divpay").dialog({
            title:'提示',
            show: null,
            bgiframe: false,
            autoOpen: false,
            draggable: true,                
            resizable: true,
            modal: true,
            width: 500,
            height: 250
           });
       $("#divpay").dialog("open");
       var htmstr="<table width='100%'><tr><td align='center'><table><tr><td><img src='images/icon64_info.png' /></td><td><b> 请到打开的新窗口进行签约。</b><p>签约未完成前请不要关闭本页面，签约完毕后点击下面按钮。</p></td>";
       htmstr+="<tr><td colspan='6' height='80px'>";
       htmstr+="<input onclick='goNext()' class='bnt_tips' type=button value='签约完毕'/></td></tr></table></td></tr></table>";
        $("#divpay").html(htmstr);           
		           
}
//支付成功跳转
function goNext(){
   $.ajax({
     type:"POST",
      url:"customeragent!ajaxcheckprotocol.action",
    async:false,         
    success:function(data){
     if(data=='true'){
      // alert("签约成功");
     }else{
      //  alert("签约失败");
     }
     $("#divpay").dialog("close");
    }            
   
   });
}
function toeditagent(){
window.location.href='customeragent!toeidt.action?id=46';
}
</script>
</head>
<body >
<div id="divpay"></div>

<form id="form2" target="_blank" name="form1" action="../interface/AlipaySeach" type="post">
<input type="hidden" name="alipayusername" id="alipayusername" value='' />
</form>
<div  id="right" >
    <div class="lit">
      <ul>
       <li class="offwu">公司信息</li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
   <form id="form1" target="_blank" name="form1" action="../interface/Alipayqian" type="post">
   <input type="hidden" name="parentid" value='' />
      <div>
<h2>公司信息</h2>
<div class="biaoti">公司基本信息</div>
	<table border="0" cellspacing="0" cellpadding="0" width="100%"  style="margin-top:15px;">
  <tr>
    <td width="20%" align="right" class="hei_cu" height="30">公司编码：</td>
    <td width="20%" style="color: black" ><ww:property value="customeragent.code"/></td>
    <td class="hui_xi"></td>
    <td></td>
  </tr>
  <tr>
    <td width="20%" align="right" class="hei_cu" height="30">公司名称：</td>
    <td width="20%" style="color: black" ><ww:property value="customeragent.agentcompanyname"/></td>
    <td class="hui_xi"></td>
    <td></td>
  </tr>
  
  <tr>
    <td align="right" class="hei_cu" height="30" >公司简称：</td>
    <td style="color: black"><ww:property value="customeragent.agentshortname"/></td>
    <td colspan="2" class="hui_xi"></td>
  </tr>
   <tr>
    <td align="right" class="hei_cu" height="30">公司电话：</td>
     <td style="color: black"></td>
    <td colspan="2" class="hui_xi"></td>
  </tr>
  
  <tr>
    <td align="right" class="hei_cu" height="30">通讯地址：</td>
     <td style="color: black"></td>
    <td colspan="2" class="hui_xi">&nbsp;</td>
  </tr>
   <tr>
    <td align="right" class="hei_cu" height="30">B2B自动支付查询：</td>
    
     <td><a href="javascript:void(0)" onclick="showwindowSeach();">
												<span style="color: red">在线查询</span></a></td>
    <td colspan="2" class="hui_xi"></td>
  </tr> 
  <tr>
    <td align="right" class="hei_cu" height="30">B2B自动支付设置：</td>
    
     <td><a href="javascript:void(0)" onclick="showwindow();">
	<span style="color: red">在线签约</span></a></td>
    <td colspan="2" class="hui_xi"></td>
    
  </tr> 
  
  <tr style="display: none">
    <td align="right" class="hei_cu" height="30"></td>
     <td style="color: red" colspan="3">登录风格及域名备案信息修改请<a href="dnsmaintenance!toedit.action">点击这里</a></td>
  </tr> 
  
</table>
 
 
 	<div class="biaoti">机构信息</div>
	<table border="0" cellspacing="0" cellpadding="0" width="100%" style="margin-top:15px;" >
	 <tr>
    <td align="right" class="hei_cu" height="30">所属地域：</td>
    <td style="color: black">PEK</td>
    <td colspan="2" class="hui_xi">&nbsp;</td>
  </tr>
   <tr>
    <td align="right" width="20%" height="30" class="hei_cu">合同期限：</td>
     <td class="table_color_l" style="color: black" colspan="3">
     
       永久
     
     
	</td>
   </tr>
</table>
 
 
<div class="biaoti">联系人信息</div>
	<table border="0" cellspacing="0" cellpadding="0" width="100%" style="margin-top:15px;" >
  <tr>
    <td width="20%" align="right" class="hei_cu" height="30">联系人：</td>
    <td width="30%" style="color: black" ></td>
    <td  class="hui_xi"></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">联系人电话：</td>
    <td style="color: black"><ww:property value="customeragent.agentmobile"/></td>
    <td class="hui_xi"></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">联系邮箱：</td>
    <td style="color: black"></td>
    <td class="hui_xi"></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">MSN/QQ：</td>
    <td style="color: black"></td>
    <td class="hui_xi"></td>
  </tr>
 
</table>
<div class="biaoti">账户信息</div>
	<table border="0" cellspacing="0" cellpadding="0" width="100%" style="margin-top:15px;" >
  <tr>
    <td width="20%" align="right" class="hei_cu" height="30">支付宝账号：</td>
    <td width="30%" style="color: black" ><ww:property value="customeragent.alipayaccount"/></td>
    <td  class="hui_xi"></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">汇付天下账号：</td>
    <td style="color: black"></td>
    <td class="hui_xi"></td>
  </tr>
  <tr>
    <td align="right" class="hei_cu" height="30">快钱帐号：</td>
    <td style="color: black"></td>
    <td class="hui_xi"></td>
  </tr>
  
  <tr>
  <td colspan="3" align="center" height="50px" style="display: none" >
     <input  type="button" class="but" onclick="toeditagent();"  value="修改"   />
  </td>
  </tr> 
 
</table>
 
 
 
</div>
</form>
    </div>
</div>
<div id="dialogdiv"></div>
</body>
</html>

