<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0081)http://cx.soku5.net:8085/vmoney/vmoney_recharge.aspx?aid=1001&url=../welcome.aspx -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>充值</title>
<meta name="keywords">
<meta name="description">
<meta name="viewport" content="width=device-width">
<link href="main_cx/css/global.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/validate.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/pagination.css" rel="stylesheet" type="text/css">
<script src="main_cx/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="main_cx/js/Validform_v5.3.2_min.js" type="text/javascript"></script>
<script src="main_cx/js/common.js" type="text/javascript"></script>
<script src="main_cx/js/Validform_v5.3.2_min.js" type="text/javascript"></script>
<script src="main_cx/js/lhgdialog(1).js" type="text/javascript"></script>
<script src="main_cx/js/WdatePicker.js" type="text/javascript"></script>
<link href="main_cx/css/WdatePicker.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
        $(function () {
            $("#form1").initValidform();
        });
        function onsubcheck() {
        //alert("?");
            var rtn = true;
            var price=$("#txtVMoney").val();
            if(price==''){
            //alert(price);
              // $.dialog.alert('充值金额不能为空！');
            }
            var money = parseFloat($("#txtVMoney").val());
            if (money <= 0) {
                //$.dialog.alert('充值金额过应大于0，请重新输入！');
                return false;
            }
            expexcel();
            return rtn;
        }
        
        
        function expexcel() {
    var win = new Ext.Window({
        height      : 150,
        width       : 400,
        modal       : true,
        title       : '提醒',
        html        : '<br>请到打开的新窗口进行银行卡支付，付款未完成前请不要关闭本页面。<br/>支付完成后请点击关闭',
        plain       : true,
        border      : true,
        resizable   : false,
        draggable   : false,
        closable    : false,
        buttonAlign : 'center',
        buttons     : [
            {
                text    : '关闭',
                handler : function() {
                  // window.location.href="train!ordersuccess.action";
                }
            }
        ]
    })
    win.show();
}

function vadateSmsNumber(va){
//alert(va);
var reg = new RegExp("^[0-9]*$");  
      
    if(!reg.test(va)){  
        alert("请输入数字!");  
       // btnSave
       $("#btnSave").attr("disabled","disabled"); 
       
       
    }else{
     $("#btnSave").removeAttr("disabled"); 
    }  
   
var smsnum=parseInt(va)*100/8
	smsnum= Math.floor(smsnum);
 $("#duanxinnum").html(smsnum);
 
 
}

    </script>
</head>
<body style="">
<form name="form1" method="post" target="_blank"
	action="ymuser!tocreatePay.action"
	id="form1">
<div><input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE"
	value="/wEPDwUINDg2NDEwMTAPZBYCAgMPZBYEAgcPDxYCHgRUZXh0BQ/mmajovanllYbml4XnvZFkZAIJDw8WAh8ABQgxMDAwMC4zNWRkZPaiYYs4a6pzIizQXd4NGMXw+cc5zAXwEd30ORbRB50o"></div>

<div><input type="hidden" name="__EVENTVALIDATION"
	id="__EVENTVALIDATION"
	value="/wEWCAL/2tDpAQL/qujSBwKo5/nhBQKB/p+OBwKOq83WDwKOq4XWDwLChKCECwKct7iSDK3xNjdM2scu7ynSrxVL9+hTmun2OAaLIvgJdkHg4VYz"></div>
<input type="hidden" name="hfAid" id="hfAid" value="1001"><input
	type="hidden" name="hfAguid" id="hfAguid"
	value="00000000-0000-0000-0000-000000000000"><input
	type="hidden" name="hfAname" id="hfAname" value="晨轩商旅网">
<div class="g-mn">
<div class="xc-nav">
<h3>账号充值</h3>
</div>
<div class="div-sep"></div>
<!--提示信息-->
<div class="warnning padding10" style="margin-top: 5px">
<ul>
	<li class="f-left">温馨提示：此页面提供充值操作</li>
	<li class="f-left"><font color="red">*</font>为必填项。</li>
</ul>
</div>
<div class="div-sep"></div>
<div>
<table width="500" cellspacing="0" cellpadding="0" border="0">
	<tbody>
		<tr>
			<td class="padding10 tr" width="100">短信数量：</td>
			<td><span id="lbAgentCompanySName">0</span>条</td>
		</tr>
		
		<tr>
			<td class="padding10 tr"><font color="red">*</font>充值金额：</td>
			<td><input name="txtVMoney" type="text" maxlength="20"
				id="txtVMoney" class="text" nullmsg="请填写充值金额" onchange="vadateSmsNumber(this.value)"
				datatype="/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/" sucmsg=" "><span
				class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td class="padding10 tr"><font color="red">*</font>确认充值金额：</td>
			<td><input name="txtVMoney2" type="text" maxlength="20" 
				id="txtVMoney2" class="text" recheck="txtVMoney" nullmsg="请填写确认充值金额"
				datatype="/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/" sucmsg=" "><span
				class="Validform_checktip"></span></td>
		</tr>
		<tr>
			<td class="padding10 tr">充值数量：</td>
			<td><span
				class="Validform_checktip" id="duanxinnum">0</span>条</td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" name="btnSave" value="充值" disabled="disabled"
				onclick="return onsubcheck();" id="btnSave" class="btncss">&nbsp;&nbsp;&nbsp;</td>
		</tr>
	</tbody>
</table>
</div>
</div>


</form>


</body>
</html>