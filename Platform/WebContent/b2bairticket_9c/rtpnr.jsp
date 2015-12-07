<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>PNR导入</title>
<link href="main_cx/css/global.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/ticketlist.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/validate.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/airlines.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/autocomplete.css" rel="stylesheet" type="text/css">
<link href="main_cx/js/jqueryUI/jquery-ui-1.8.2.custom.css"
	rel="stylesheet" type="text/css">
<link href="main_cx/css/airlines.css" rel="stylesheet" type="text/css">
<link href="main_cx/css/tip.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="main_cx/js/jquery-1.4.1.min.js"></script>
<script language="javascript" type="text/javascript"
	src="main_cx/js/My97DatePicker/WdatePicker.js"></script>
<link href="main_cx/js/My97DatePicker/skin/WdatePicker.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="main_cx/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript"
	src="main_cx/js/lhgdialog.js?skin=idialog"></script>
<script src="main_cx/js/jquery.tmpl.js" type="text/javascript"></script>
<script src="main_cx/js/jquery.bgiframe.min.js" type="text/javascript"></script>
<script src="main_cx/js/jqueryUI/jquery-ui.min.js"
	type="text/javascript"></script>
<script src="main_cx/js/jquery.poshytip.js" type="text/javascript"></script>
<script src="main_cx/js/publicjs.js" type="text/javascript"></script>
<script src="main_cx/js/ticket/createorder.js" type="text/javascript"></script>
<script type="text/javascript" src="main_cx/js/layout.js"></script>
<script type="text/javascript">
        //成人含税费总票价
        var adultpricefee = 0;
        var adultpassengerprice = 0;
        var adultpassengerairport = 0;
        var adultpassengerfuel = 0;
        var Aircomapnycode = "";
        var cabincode = "";
        //儿童含税费总票价
        var chilidpricefee = 0;
        //婴儿含税费总票价
        var babypricefee = 0;
        //儿童票面价
        var childticketprice = 0;
        //无返佣儿童票价
        var childticketpricenorebate = 0;
        var chlidfuelfee = 0;
        //婴儿票面价
        var babyticketprice = 0;
        //总乘机人数
        var passengercount = 0;
        //全价价格
        var yprice = 0;
        //一份保险的价格
        var insuranceprice = 20;
        var segstr = "";

        $(function () {
           // $("#txtPNRInfo").val("温馨提示：\r\n1、请使用您的Eterm系统提取PNR内容，在执行PAT:A指令。\r\n2、将全部内容复制，并粘贴到该输入框内。 \r\n3、注意事项：复制的内容需要从RT编码开始到PAT:A结果的全部内容。 \r\n4、团队从RT：N/编码开始复制到PAT:A结果的所有内容。\r\n5、根据航空公司出票要求，PNR内容中必须备注手机号码。");
            //获取普通政策
            if ($("#hidsegmentinfos").val() == "1") {
                getpolicydata(0);
                segstr = $("#hidsegmentinfo").val();
                adultpassengerairport = parseInt($("#hidranyou").val());
                adultpassengerfuel = parseInt($("#hidjijian").val());
            }
            if ($("#hidpassengers").val() != "") {
                var passengers = eval($("#hidpassengers").val());
                $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers');
                accountprice();
                //绑定证件类型
                $("input[id*='txt_idcardtype_']").each(function (i) {
                    var strid = $(this).attr("id");
                    id = strid.replace("txt_idcardtype_", "");
                    $("#ddlidcardtype_" + id).val($(this).val());
                });
            }
        });
        function cleartext() {
            $("#txtPNRInfo").val("");
        }
        function addtext() {
            if ($("#txtPNRInfo").val() == "") {
                $("#txtPNRInfo").val("温馨提示：\r\n1、请使用您的Eterm系统提取PNR内容，在执行PAT:A指令。\r\n2、将全部内容复制，并粘贴到该输入框内。 \r\n3、注意事项：复制的内容需要从RT编码开始到PAT:A结果的全部内容。 \r\n4、团队从RT：N/编码开始复制到PAT:A结果的所有内容。\r\n5、根据航空公司出票要求，PNR内容中必须备注手机号码。");
            }
        }
        function checkdatapnr() {
            if ($("#strPNRTXT").val() == "") {
               // jsalert("请填写PNR内容及PAT信息!", "Error");
               alert("请填写PNR内容及PAT信息!");
                $("#strPNRTXT").focus();
                return false;
            }
            if ($("#strPATTXT").val() == "") {
               // jsalert("请填写PNR内容及PAT信息!", "Error");
              // alert("请填写PAT信息!");
             //   $("#strPATTXT").focus();
             //   return false;
            }
             if ($("#strPNR").val() == "") {
               // jsalert("请填写PNR内容及PAT信息!", "Error");
              // alert("请填写PNR信息!");
              //  $("#strPNR").focus();
              //  return false;
            }
           // else {
               // if ($("#txtPNRInfo").val().indexOf("RT")<0) {
                  //  jsalert("请填写RTPNR信息!", "Error");
               //     $("#txtPNRInfo").focus();
                //    return false;
               // }
              //  else if ($("#txtPNRInfo").val().indexOf("温馨提示")>=0)
             //   {
                   // jsalert("请填写PNR内容及PAT信息!", "Error");
             //       alert("请填写PNR内容及PAT信息!");
            //        $("#txtPNRInfo").focus();
             //       return false;
             //   }
          //  }
            
        }
        
         function checkdatapnr2() {
            if ($("#strPNRTXT2").val() == "") {
               // jsalert("请填写PNR内容及PAT信息!", "Error");
               alert("请填写PNR内容!");
                $("#strPNRTXT2").focus();
                return false;
            }
            
            }
    </script>
</head>
<body style="overflow-x:hidden;overflow-y:auto;">
<form name="form2" method="post" action="orderinfo!toCreateOrderByPnr.action" id="form1">
<input type="hidden" name="importtype" value="1" />
<div id="divpnrinfo" class="g-mn" style="float: none; height:220px; overflow:hidden;border-bottom:1px solid #dfdfdf;margin-bottom:20px;">
<h1 class="title">PNR导入</h1>
<div class="m-sch">
<div id="check-city"></div>
<div class="info">
<div class="f-cb">
<table width="90%" cellspacing="0" cellpadding="0" border="0">
	<tbody>
		<tr>
			<td align="right" style="width: 8%">PNR信息：</td>
			<td align="left"><input name="strPNR" id="strPNRTXT2" width="100px;" type="text" /></td>
			<td align="left" rowspan="2"><input type="submit"
				name="btnImport" value="导入PNR编码信息" onclick="return checkdatapnr2();"
				id="btnImport" class="btncss" style="height: 40px; width: 146px;"></td>
			<td align="left" rowspan="2">&nbsp;</td>
			<td align="left" rowspan="2"><b>PNR导入注意事项：</b>必须对我公司OFFICE(BJS182)授权!
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
			</td>
		</tr>
	</tbody>
</table>
</div>
</div>
</div>
</div>
</form>

<form name="form1" method="post" action="orderinfo!toCreateOrderByPnr.action" id="form1">
<input type="hidden" name="importtype" value="2" />

<div id="divpnrinfo" class="g-mn" style="float: none; height:510px; overflow:hidden;border-bottom:1px solid #dfdfdf;margin-bottom:20px;">
<h1 class="title">PNR导入-复制RT和PAT:A结果快速创建订单（请按照示例格式输入内容！）</h1>
<div class="m-sch">
<div id="check-city"></div>
<div class="info">
<div class="f-cb">
<table width="90%" cellspacing="0" cellpadding="0" border="0">
	<tbody>
		<tr>
			<td align="left" style="width: 8%">RT信息：</td>
			<td align="left"><textarea name="PnrTxtPat" rows="2" cols="20"
				id="strPNRTXT" 
				style="height: 380px; width: 450px; font-size: 12px; border: 0px; line-height: 18px; background: #000; color: #00ff00; padding-left: 10px; padding-top: 8px; float: left;"></textarea></td>
			
			<td align="left" rowspan="2" style="width: 5%">&nbsp;</td>
			<td align="left" rowspan="2">&nbsp;</td>
			<td align="left" rowspan="2"><b>PNR信息示例：</b>(<span
				style="color: red"><b>用PNR信息导入请一定要复制RT+编码</b></span>)<br>
			<br>
			RTJGGMJG<br>
			1.王鹏 JGGMJG<br>
			2.JD5520 X TH30JUN KWLHAK HK1 1725 1840 E<br>
			3.HAK/T HAK/T 010-66661111/HAK QIONG XING TOU ZI SERVICE LTD.,CO/WANG
			ZHI YI ABCDEFG<br>
			4.68591262 KGLTAG QX09 2011-06-19<br>
			5.T/TL/1700/25JUN/HAK120<br>
			6.SSR FOID<br>
			7.SSR ADTK 1E BY HAK25JUN11/1111 OR CXL JD5520 X30JUN<br>
			8.OSI JD CTCT 13011111111<br>
			9.RMK CA/ND5NCK<br>
			10.HAK120<br>
			&gt;PAT:A<br>
			01 X FARE:CNY390.00 TAX:CNY50.00 YQ:CNY80.00 TOTAL:520.00<br>
			SFC:01<br>
			</td>
		
		
		
		
		</tr>
		<!--<tr>
			<td>&nbsp;</td>
		
		</tr>
		<tr>
			<td align="left" style="width: 8%">PAT信息：</td>
			<td align="left"><textarea name="strPATTXT" rows="2" cols="20"
				id="strPATTXT" 
				style="height: 80px; width: 450px; font-size: 12px; border: 0px; line-height: 18px; background: #000; color: #00ff00; padding-left: 10px; padding-top: 8px; float: left;"></textarea></td>
			
			<td align="left" rowspan="2" style="width: 5%">&nbsp;</td>
			<td align="left" rowspan="2">&nbsp;</td>
		
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		
		
		<tr>
			<td align="left" style="width: 8%">PNR：</td>
			<td align="left"><textarea name="strPNR" rows="1" 
				id="strPNR" 
				style="height: 25px; width: 150px; font-size: 12px; border: 0px; line-height: 18px; background: #000; color: #00ff00; padding-left: 10px; padding-top: 8px; float: left;"></textarea></td>
			
			<td align="left" rowspan="2" style="width: 5%">&nbsp;</td>
			<td align="left" rowspan="2">&nbsp;</td>
			
		
		</tr>
		
		--><tr>
			<td align="center" colspan="2"><input type="submit"
				name="btnImport" value="导入PNR编码信息" onclick="return checkdatapnr();"
				id="btnImport" class="btncss" style="height: 40px; width: 146px;">
			</td>
		</tr>
	</tbody>
</table>
</div>
</div>
</div>
</div>

<input name="hidsegmentinfos" type="text" id="hidsegmentinfos"
	style="display: none" value="0"> <input name="hidpassengers"
	type="text" id="hidpassengers" style="display: none"> <input
	name="hidadultprice" type="text" id="hidadultprice"
	style="display: none" value="1070.00"> <input name="hidranyou"
	type="text" id="hidranyou" style="display: none" value="0"> <input
	name="hidjijian" type="text" id="hidjijian" style="display: none"
	value="0">
	
	
	</form>
	
	<!--  -->

</body>

</html>