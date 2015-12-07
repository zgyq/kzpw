<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>告知单</title>
  <OBJECT ID="jatoolsPrinter" CLASSID="CLSID:B43D3361-D975-4BE2-87FE-057188254255" codebase="jatoolsP.cab#version=1,2,0,2"></OBJECT> 
   <link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
    <style type="text/css">
        .tr
        {
            text-align: left;
        }
        .td2
        {
            width: 107px;
        }
        .textbox2
        {
            width: 80px;
            border: 1px solid #CCCCCC;
        }
        .table
        {
            margin: 0px;
            padding: 0px;
            text-align: center;
            border: 0px;
        }
        
    </style>
 
    <script type="text/javascript" language="javascript">
    
       function getSystemFonts(){
            var a=dlgHelper.fonts.count;
            var fArray = new Array();
	        var fonts=false;
            for (i = 1;i < dlgHelper.fonts.count;i++)
	        { 
                fArray[i] = dlgHelper.fonts(i);
		        if(fArray[i]=="TEE" || fArray[i]=="TEC" )
		        {
			        fonts=true;
			        break;
		        }
            } 
	        if (fonts==false)
	        {
		        if(confirm("系统中没有打印所需安体，您现在确认下载相关字体吗？\n下载字体请点击确认，否则请取消！" ))
		        {
			        window.open("fonts.rar");
		        }
	        }
        }
        
    
    
function ClearAllTextBox()   
{   
var obj=window.document.forms[0];   
for(i=0;i<obj.elements.length; i++)   
{   
var elem=obj.elements[i];    
if(elem.type=="text"&& elem.id!="tbpnr")   
{   
elem.value="";   
}   
}   
return false;
} 

        

    </script>
 
</head>
<body id="WebBrowser">

    <form name="form1" method="post" action="PrintJourney.aspx" id="form1">
<div>
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUJMjcyNTM5OTk1D2QWAgIDD2QWAgIFD2QWAgIBD2QWAgIBDxBkZBYAZGT7Y2qCisJSPucTY2TDwRNvgJ42Ow==" />
</div>
 
<link rel="Stylesheet" type="text/css" href="/css/css.css" /><script type="text/javascript" language="javascript">if (window == top) top.location.href = "Exit.aspx";</script>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;机票告知单打印</span></b><input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWQALO5qCfAQKu1tPNBALH2uzpCwKm+4KcDgLBwIuTAgKQ7N7pCgKZvIvlBAKvzsotAprswMYFAs3C0O4MAsfD8qcFAsSEqIMOAryEzIYGAqi9lcsMAuK6/+QGAq/jx60CAuP7+uQKAoX7urILAouUhMcOAs3CjO4MAsTUqt8IAsSE/JACAryEoK8DAqi92cwMAry907EHAonmm+oDAuCMs58OAoX7vrILArrYqgcCzcKY7gwCw9Sq3wgCxITA/wcCvITknQkCqL3NzAwCv73TsQcCjOab6gMC34yznw4ChfuysgsC1cHInAoCzcKU7gwCwtSq3wgCxITUWgK8hPj4AQKovdHMDAK+vdOxBwKL5pvqAwLejLOfDgLEhIiDDwKJyIK/DALrsp/vBALzrOrsCwKuqY+/BwLry9XOCQKh+87aCAK6+sL+AgLhsuYaAv+C0o0IApT60b8KAtr1yPYDAv+CjowIAsHix7MMAoCagJIIAqKf8KIJAqnJ09INC06Sv/qUs8j0qM3EQRDDXr0xUsY=" /></td>
	</tr>
	<tr>
		<td valign="top">
<table id="tbOrders" style="margin: 0px; padding: 0px; text-align: center; " cellpadding="0" cellspacing="0"  >
	<tr class="tr">
		<td>
                    <table class="table" bordercolor="#a0cfee" border="1" cellpadding="0" cellspacing="0" width="96%;" style="border-collapse:collapse; margin: 0 auto; margin-top:10px;" >
                        <tr>
                            <td width="120" class="tbody_color">
                                <span id="Label1">编号PNR:</span>
                            </td>
                            <td class="table_color_ll" align="left">
                                <input name="txtPNR" type="text" id="txtPNR" class="textbox2" />
                            </td>
                        </tr>
                    </table>
                </td>
	</tr>
	<tr class="tr">
		<td>
                    <table class="table" bordercolor="#a0cfee" border="1" cellpadding="0" cellspacing="0" width="96%;" style="border-collapse:collapse; margin: 0 auto; margin-top:5px;">
                        <tr>
                            <td width="120" class="tbody_color">
                                <span id="Label2">旅客姓名:</span>
                            </td>
                            <td  >
                                <input name="txtPassenger_Name" type="text" id="txtPassenger_Name" class="textbox2" />
                            </td>
                            <td  width="140" class="tbody_color">
                                <span id="Label3">有效身份证件号码:</span>
                            </td>
                            <td  >
                                <input name="txtID_No" type="text" id="txtID_No" class="textbox2" style="width:150px;" />
                            </td>
                            <td width="120" class="tbody_color">
                                <span id="Label4">签  注:</span>
                            </td>
                            <td >
                                <input name="txtRemark" type="text" id="txtRemark" class="textbox2" />
                            </td>
                        </tr>
                    </table>
                </td>
	</tr>
	<tr class="tr">
		<td>
                    <table class="table" bordercolor="#a0cfee" border="1" cellpadding="0" cellspacing="0" width="96%;" style="border-collapse:collapse; margin: 0 auto;margin-top:5px;">
                        <tr>
                            <td class="td2">
                                <span id="Label5"></span>
                            </td>
                            <td class="tbody_color">
                                <span id="Label6">航程</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label7">承运人</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label8">航班号</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label9">舱位</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label10">日期</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label11">时间</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label12">客票级别</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label13">生效日期</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label14">截止日期</span>
                            </td>
                            <td  class="tbody_color">
                                <span id="Label15">免费行李</span>
                            </td>
                        </tr>
                        <tr>
                            <td  class="tbody_color">
                                <span id="Label16" style="display:inline-block;width:80px;">自 FROM:</span>
                            </td>
                            <td class="td2">
                                <input name="txtFrom" type="text" id="txtFrom" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtCarrier" type="text" id="txtCarrier" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtFlight" type="text" id="txtFlight" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtClass" type="text" id="txtClass" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtDate" type="text" id="txtDate" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtTime" type="text" id="txtTime" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtFare_Basis" type="text" id="txtFare_Basis" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtNotValdBefore" type="text" id="txtNotValdBefore" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtNotValidAfter" type="text" id="txtNotValidAfter" class="textbox2" />
                            </td>
                            <td class="td2">
                                <input name="txtAllow" type="text" id="txtAllow" class="textbox2" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tbody_color">
                                <span id="Label17">至 TO:</span>
                            </td>
                            <td>
                                <input name="txtTo0" type="text" id="txtTo0" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtCarrier1" type="text" id="txtCarrier1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtFlight1" type="text" id="txtFlight1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtClass1" type="text" id="txtClass1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtDate1" type="text" id="txtDate1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtTime1" type="text" id="txtTime1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtFare_Basis1" type="text" id="txtFare_Basis1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtNotValdBefore1" type="text" id="txtNotValdBefore1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtNotValidAfter1" type="text" id="txtNotValidAfter1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtAllow1" type="text" id="txtAllow1" class="textbox2" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tbody_color">
                                <span id="Label18">至 TO:</span>
                            </td>
                            <td>
                                <input name="txtTo1" type="text" id="txtTo1" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtCarrier2" type="text" id="txtCarrier2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtFlight2" type="text" id="txtFlight2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtClass2" type="text" id="txtClass2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtDate2" type="text" id="txtDate2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtTime2" type="text" id="txtTime2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtFare_Basis2" type="text" id="txtFare_Basis2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtNotValdBefore2" type="text" id="txtNotValdBefore2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtNotValidAfter2" type="text" id="txtNotValidAfter2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtAllow2" type="text" id="txtAllow2" class="textbox2" />
                            </td>
                        </tr>
                        <tr>
                            <td class="tbody_color">
                                <span id="Label19">至 TO:</span>
                            </td>
                            <td>
                                <input name="txtTo2" type="text" id="txtTo2" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtCarrier3" type="text" id="txtCarrier3" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtFlight3" type="text" id="txtFlight3" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtClass3" type="text" id="txtClass3" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtDate3" type="text" id="txtDate3" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtTime3" type="text" id="txtTime3" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtFare_Basis3" type="text" id="txtFare_Basis3" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtNotValdBefore3" type="text" id="txtNotValdBefore3" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtNotValidAfter3" type="text" id="txtNotValidAfter3" class="textbox2" />
                            </td>
                            <td>
                                <input name="txtAllow3" type="text" id="txtAllow3" class="textbox2" />
                            </td>
                        </tr>
                    </table>
                </td>
	</tr>
	<tr class="tr">
		<td>
                    <table class="table" bordercolor="#a0cfee" border="1" cellpadding="0" cellspacing="0" width="96%;" style="border-collapse:collapse; margin: 0 auto;margin-top:5px;">
                        <tr>
                            <td width="120"  class="tbody_color">
                                <span id="Label20">票价:</span>
                            </td>
                            <td  class="td2">
                                <input name="txtFare" type="text" id="txtFare" class="textbox2" />
                            </td>
                            <td  width="120"  class="tbody_color">
                                <span id="Label21">机场建设费:</span>
                            </td>
                            <td  class="td2">
                                <input name="txtAirport_Tax" type="text" id="txtAirport_Tax" class="textbox2" />
                            </td>
                            <td width="120"  class="tbody_color">
                                <span id="Label22">附加燃油费:</span>
                            </td>
                            <td  class="td2">
                                <input name="txtFuel_surcharge" type="text" id="txtFuel_surcharge" class="textbox2" />
                            </td>
                            <td  width="120"  class="tbody_color">
                                <span id="Label23">其他税费:</span>
                            </td>
                            <td  class="td2">
                                <input name="txtOther_Taxes" type="text" id="txtOther_Taxes" class="textbox2" />
                            </td>
                            <td width="120"  class="tbody_color">
                                <span id="Label24">合计:</span>
                            </td>
                            <td class="td2">
                                <input name="txtTotal" type="text" id="txtTotal" class="textbox2" />
                            </td>
                        </tr>
                    </table>
                </td>
	</tr>
	<tr class="tr">
		<td>
                    <table class="table" bordercolor="#a0cfee" border="1" cellpadding="0" cellspacing="0" width="96%;" style="border-collapse:collapse; margin: 0 auto;margin-top:5px;">
                        <tr>
                            <td width="120"  class="tbody_color">
                                <span id="Label25">电子客票号码:</span>
                            </td>
                            <td class="td2">
                                <input name="txteTicketNo" type="text" id="txteTicketNo" class="textbox2" />
                            </td>
                            <td width="120"  class="tbody_color">
                                <span id="Label26">验证码:</span>
                            </td>
                            <td class="td2">
                                <input name="txtCK" type="text" id="txtCK" class="textbox2" />
                            </td>
                            <td width="120"  class="tbody_color">
                                <span id="Label27">连续客票:</span>
                            </td>
                            <td class="td2">
                                <input name="txtConuntion_Tkt" type="text" id="txtConuntion_Tkt" class="textbox2" />
                            </td>
                            <td width="120"  class="tbody_color">
                                <span id="Label28">保险费:</span>
                            </td>
                            <td class="td2">
                                <input name="txtInsurance" type="text" id="txtInsurance" class="textbox2" />
                            </td>
                        </tr>
                    </table>
                </td>
	</tr>
	<tr class="tr">
		<td>
                    <table class="table" bordercolor="#a0cfee" border="1" cellpadding="0" cellspacing="0" width="96%;" style="border-collapse:collapse; margin: 0 auto;margin-top:5px;">
                        <tr>
                            <td width="120"  class="tbody_color">
                                <span id="Label29">销售单位代码:</span>
                            </td>
                            <td class="td2">
                                <input name="txtAgent_Code" type="text" id="txtAgent_Code" class="textbox2" />
                            </td>
                            <td width="120"  class="tbody_color">
                                <span id="Label30">填开单位:</span>
                            </td>
                            <td class="td2">
                                <input name="txtIssued_By" type="text" id="txtIssued_By" class="textbox2" />
                            </td>
                            <td width="120"  class="tbody_color">
                                <span id="Label31">填开日期:</span>
                            </td>
                            <td class="td2">
                                <input name="txtIssued_Date" type="text" id="txtIssued_Date" class="textbox2" />
                            </td>
                        </tr>
                    </table>
                </td>
	</tr>

</table>
 
    

    <table width="100%" style="margin-top: 15px;">
        <tr>
            <td align="center">
            <OBJECT  classid = " CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 " height = 0   id = wb  name = wb  width = 3></OBJECT >  
            <!--
                &nbsp;&nbsp;
                <input type="submit" name="bt_Previous" value="上一位" id="bt_Previous" disabled="disabled" style="background-color:Wheat;border-style:Outset;font-weight:bold;width:90px;height: 24px" />
                &nbsp;&nbsp;
                <input type="submit" name="bt_Next" value="下一位" id="bt_Next" disabled="disabled" style="background-color:Wheat;border-style:Outset;font-weight:bold;width:90px;height: 24px" />
                &nbsp;&nbsp;
                -->
                <input type="reset" name="bt_Clear" value="清 空"  id="" class="button_d font-white" />
                &nbsp;&nbsp;
                <input id="btnPrint" type="button" value="打印预览" onclick="javascript:window.print();" class="button_d font-white"/>
                <!--<input type="button" name="bt_Print" value="我要打印"   onclick="dayin();"  id="bt_Print" style="background-color:Wheat;border-style:Outset;font-weight:bold;width:90px;height: 24px" />
            --></td>
        </tr>
    </table>		
		
		</td>
    </tr>
    </table>

    <!--<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolorlight="#cdcdcd"
        bordercolordark="#ffffff">
        <tr>
            <td valign="middle" align="right" style="width: 120px; height: 28px; background-color: #EDFFED;">
                &nbsp;PNR记录编码：
            </td>
            <td style="width: 320px; vertical-align: text-bottom;" align="left" valign="bottom">
                &nbsp;<input name="tbpnr" type="text" maxlength="20" id="tbpnr" style="width:156px;" />
                &nbsp;&nbsp;&nbsp;
                <input type="submit" name="btQuery" value="提 交" id="btQuery" style="background-color:Wheat;border-style:Outset;font-weight:bold;height:24px;width:70px;" />
            </td>
        </tr>
        
    </table>
    -->
    
    
</body>
 

</html>

