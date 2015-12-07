 <%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>信息单打印</title>
    <meta content="text/html; charset=gb2312" http-equiv="Content-Type">
    <style type="text/css">
        html,body,form,p,center{margin:0px;}
        .btn
        {
            border-bottom: #7b9ebd 1px solid;
            filter: progid:dximagetransform.microsoft.gradient(gradienttype=0,   startcolorstr=#ffffff,   endcolorstr=#cecfde);
            border-left: #7b9ebd 1px solid;
            padding-left: 2px;
            padding-right: 2px;
            color: black;
            font-size: 12px;
            border-top: #7b9ebd 1px solid;
            cursor: hand;
            border-right: #7b9ebd 1px solid;
            padding-top: 2px;
        }
        .back_southidc
        {
            background-image: url(images/titlebg.gif);
            color: #000000;
        }
        .table_southidc
        {
            background-color: #a4b6d7;
        }
        .td_southidc
        {
            background-color: #f2f8ff;
        }
        .tr_southidc
        {
            background-color: #ecf5ff;
        }
        .t1
        {
            font: 12px 宋体;
            color: #000000;
        }
        .t2
        {
            font: 12px 宋体;
            color: #ffffff;
        }
        .t3
        {
            font: 12px 宋体;
            color: #ffff00;
        }
        .t4
        {
            font: 12px 宋体;
            color: #800000;
        }
        .t5
        {
            font: 12px 宋体;
            color: #191970;
        }
        .weiqun:hover
        {
            background-color: #cccccc;
            font-family: "宋体";
            color: #ffffff;
            text-decoration: underline;
            font-unline: yes;
        }
        TD
        {
            font-size: 12px;
        }
        A:link
        {
            color: #000000;
            text-decoration: none;
        }
        A:active
        {
            color: #000000;
            text-decoration: none;
        }
        A:visited
        {
            color: #000000;
            text-decoration: none;
        }
        .xcd
        {
            width:920px; margin:auto; height: 310px;padding-top:10px;background:#f1fbff;border:1px solid #bde0f4
        }
        #tj_bnt
        {
            margin-top: 40px;
            margin-left: 450px;
        }
        .STYLE1
        {
            color: #ff0000;
        }
        .heaspand
        {
            font-size: 14px;
            font-weight: bold;
        }
        BODY
        {
            padding-bottom: 0px;
            margin: 0px;
            padding-left: 0px;
            padding-right: 0px;
            padding-top: 0px;
        }
        INPUT
        {
            border-bottom: #ccc 1px solid;
            border-left: #ccc 1px solid;
            background: none transparent scroll repeat 0% 0%;
            border-top: #ccc 1px solid;
            border-right: #ccc 1px solid;
            font-size: 18px;
        }
        #dplist_flypep
        {
            width: 142px;
        }
        .style15
        {
            width: 163px;
        }
        .gsels{position:absolute;left:0px;top:20px;background-color: white;border:1px solid #DDD;}
        .gsels a{cursor:pointer;display:block;padding:5px;}
        .gsels a:hover{background:#F3F3F3}
    </style>
    <meta name="GENERATOR" content="MSHTML 8.00.6001.19258">
</head>
<body style="margin-left: auto; margin-right: auto">
    <!--<form id="whereform" action="print.aspx?" method="get" name="whereform">
        <table style="height: 50px;" align="center">
            <tr>
                <td align="right">
                    PNR编码/票号/订单号：
                </td>
                <td align="right">
                    <select name="type">
                        <option value="pnr" >PNR编码</option>
                        <option value="ph" >票号</option>
                        <option value="order"  selected>订单号</option>
                    </select>
                </td>
                <td align="left" class="style15">
                    <input name="value" style="" value="">
                </td>
                <td>
                    <input src="images/daoru.gif" type="image" style="border:0px;">
                </td>
                <td align="left" colspan="2">
                    <span class="STYLE1">*PNR、票号、订单号必须在平台内</span></td>
            </tr>        
        </table>
        
    </form>
    -->
    <form >
    <div style="padding:10px;text-align:center">
        <span class="heaspand">航空运输电子客票信息单</span><br />
        <img alt="" src="xxd2/images/xcd_line_03.gif">
    </div>
    <center>
    <!--startprint-->	
        <div class="xcd">
            <table style="height: 234px; width: 1167px;" border="0" cellspacing="0" cellpadding="0"
                align="center">
                <tbody>
                    <tr style="margin-right: -20px;">
                        <td >
                            <table border="0" cellspacing="0" cellpadding="0" width="100%" style="height: 65px" >
                                <tr>
                                    <td align="right">
                                        旅客：
                                    </td>
                                    <td align="left">
                                        <input style="width: 85px" class="input2" value="<ww:property value="passenger.name" />" name="p_name" />
                                    </td>
                                    <td align="right">
                                        有效证件
                                    </td>
                                    <td align="left">
                                        <input style="width: 200px" id="tboxpno" value="<ww:property value="passenger.idnumber" />" name="p_card" />
                                    </td>
                                    <td align="right">
                                        签注
                                    </td>
                                    <td align="left">
                                        <div style="position:relative;" onmousemove="olist.style.display=''" onmouseout="olist.style.display='none'" >
                                            <input style="width: 200px" id="drop_tgq" name="drop_tgq" value="不得签转" />
                                            <div class="gsels" id="olist">
                                                <a hidefocus href='#' onclick="drop_tgq.value='不得签转'" >不得签转</a>
                                                <a hidefocus href='#' onclick="drop_tgq.value='不得签转不得退票'" >不得签转不得退票</a>
                                                <a hidefocus href='#' onclick="drop_tgq.value='不得变更不得签转'">不得变更不得签转</a>
                                                <a hidefocus href='#' onclick="drop_tgq.value='不得签转变更退票'">不得签转变更退票</a>
                                                <a hidefocus href='#' onclick="drop_tgq.value='不得更改不得签转不得退票'">不得更改不得签转不得退票</a>
                                                <a hidefocus href='#' onclick="drop_tgq.value='签转手续费原出票地退票'">签转手续费原出票地退票</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">PNR：</td>
                                    <td colspan="5">
                                        <input style="width: 79px; " id="txt_pnr" value="<ww:property value="orderinfo.pnr" />" name="p_PNR">
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td style="height: 140px" >
                            <table border="0" cellspacing="0" cellpadding="0" align="left">
                                <tbody>
                                    <tr>
                                        <td style=""align="left">
                                        </td>
                                        <td style="" align="left">
                                            航站楼/航段
                                        </td>
                                        <td style=";"align="left">
                                            承运人
                                        </td>
                                        <td style=";"align="left">
                                            航班号
                                        </td>
                                        <td style=";">
                                            舱位
                                        </td>
                                        <td style="width: 100px;">
                                            日期
                                        </td>
                                        <td style="width: 60px;">
                                            时间
                                        </td>
                                        <td style="width: 65px;">
                                            客票级别
                                        </td>
                                        <td style="width: 65px;">
                                            生效日期
                                        </td>
                                        <td style="width: 65px;">
                                            截至日期
                                        </td>
                                        <td style="width: 65px;">
                                            免费行李
                                        </td>
                                    </tr>
                                    <tr>
                                        <td valign="top" style="line-height:22px;">
                                            自 FROM<br />
                                            至 TO<br />
                                            至 TO<br />
                                            至 TO<br />
                                            至 TO
                                        </td>
                                        <td valign="top">
                                            <input style="width: 20px" name="fp" class="input2" value="" title="填写起飞航站楼"><input style="width: 70px" name="city" class="input2" value="<ww:property value="segmentinfo.startairport" />" title="填写机场三字码"><input style="width: 20px" name="dp" class="input2" value="" title="填写到达航站楼"><br />
                                            <input style="width: 20px" name="fp" class="input2" value="" title="填写起飞航站楼"><input style="width: 70px" name="city" class="input2" value="" title="填写机场三字码"><input style="width: 20px" name="dp" class="input2" value="" title="填写到达航站楼"><br />
                                            
                                            <input style="width: 20px" name="fp" class="input2" value="" title="填写起飞航站楼"><input style="width: 70px" name="city" class="input2" value="" ><input style="width: 20px" name="city" class="input2" value="" title="填写到达航站楼"><br />
                                            
                                            <input style="width: 20px" name="fp" class="input2" value="" title="填写起飞航站楼"><input style="width: 70px" name="city" class="input2" value="VOID" ><input style="width: 20px" name="dp" class="input2" value="" title="填写到达航站楼"><br />
                                        </td>
                                        <td valign="top">
                                            <input style="width: 40px" name="airco" class="input2" value="<ww:property value="segmentinfo.aircomapnycode" />" title="填写航空公司二字码"><br />
                                            
                                            <input style="width: 40px" name="airco" class="input2" value="" title="填写航空公司二字码"><br />
                                            
                                        </td>
                                        <td valign="top"><!-- 航班号 -->
                                            <input style="width: 60px" name="airno" class="input2" value="<ww:property value="segmentinfo.flightnumber" />"><br />
                                            
                                            <input style="width: 60px" name="airno" class="input2" value=""><br />
                                            
                                            <input style="width: 60px" name="airno" class="input2" value="VOID"><br />
                                        </td>
                                        <td valign="top" ><!-- 仓位 -->
                                            <input style="width: 20px" name="seat" class="input2" value="<ww:property value="segmentinfo.cabincode" />"><br />
                                            
                                            <input style="width: 20px" name="seat" class="input2" value=""><br />
                                            
                                        </td>
                                        <td valign="top" ><!-- 日期 -->
                                            <input style="width: 85px" name="date" class="input2" value="<ww:property value="formatDate(segmentinfo.departtime)" />" title="日期格式 2012-01-01"><br />
                                            
                                            <input style="width: 85px" name="date" class="input2" value="" title="日期格式 2012-01-01"><br />
                                            
                                        </td>
                                        <td valign="top" ><!-- 时间 -->
                                            <input style="width: 40px" name="time" class="input2" value="<ww:property value="formatTimestampHHmm_B2B(segmentinfo.departtime)" />"><br />
                                            
                                            <input style="width: 40px" name="time" class="input2" value=""><br />
                                            
                                        </td>
                                        <td valign="top" ><!-- 等级 -->
                                            <input style="width: 50px" name="level" class="input2" value="<ww:property value="segmentinfo.cabincode" />"><br />
                                            
                                            <input style="width: 50px" name="level" class="input2" value=""><br />
                                            
                                        </td>
                                        <td valign="top" ><!-- 生效日期 -->
                                            <input style="width: 50px" name="sdate" class="input2" ><br>
                                            
                                            <input style="width: 50px" name="sdate" class="input2"><br />
                                            
                                        </td>
                                        <td valign="top" ><!-- 截止日期 -->
                                            <input style="width: 50px" name="edate" class="input2" ><br>
                                            
                                            <input style="width: 50px" name="edate" class="input2"><br />
                                            
                                        </td>
                                        <td valign="top" >
                                            <input style="width: 40px" name="xl" class="input2" value="20KG" ><br>
                                            
                                            <input style="width: 40px" name="xl" class="input2" value="" ><br />
                                            
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="10">
                                            <table border="0" cellspacing="0" cellpadding="0" >
                                                <tr>
                                                    <td width="140"></td>
                                                    <td style="text-align: right; width: 115px; height: 30px">
                                                        票价
                                                    </td>
                                                    <td style="width: 90px; height: 30px">
                                                        <input style="text-align: right; width: 54px;" id="txt_PJ" class="input2" 
                                                            maxlength="7" size="7" value="CNY <ww:if test="passenger.ptype==1"><ww:property value="segmentinfo.parvalue" /></ww:if><ww:else><ww:property value="passenger.price" /></ww:else>"
                                                            name="piaojia">
                                                    </td>
                                                    <td style="text-align: right; width: 55px; height: 30px">
                                                        机建
                                                    </td>
                                                    <td style="width: 90px; height: 30px">
                                                        <input style="text-align: right; width: 71px;" id="txt_JJ" class="input2" 
                                                            maxlength="6" size="6" value="CN <ww:property value="passenger.airportfee" />"
                                                            name="jijian">
                                                    </td>
                                                    <td style="text-align: right; width: 65px; height: 30px">
                                                        燃油费
                                                    </td>
                                                    <td style="width: 90px; height: 30px">
                                                        <input style="text-align: right; width: 72px;" id="txt_RY" class="input2" 
                                                            maxlength="6" size="6"  value="YQ <ww:property value="passenger.fuelprice" />"
                                                            name="ranyou">
                                                    </td>
                                                    <td style="width: 30px; height: 30px">
                                                    </td>
                                                    <td style="text-align: right; width: 55px; height: 30px">
                                                        合计
                                                    </td>
                                                    <td style="width: 90px; height: 30px">
                                                        <input style="text-align: right; width: 63px;" id="txt_HJ" class="input2" 
                                                            maxlength="7" size="7"  value="CNY <ww:if test="passenger.ptype==1"><ww:property value="formatMoney(passenger.fuelprice+passenger.airportfee+segmentinfo.parvalue+converNull(passenger.insurprice,0))" /></ww:if><ww:else><ww:property value="formatMoney(passenger.fuelprice+passenger.airportfee+passenger.price+converNull(passenger.insurprice,0))" /></ww:else>"
                                                            name="heji">
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr style="height:40px">
                                    <td width="80">
                                        电子客票号码
                                    </td>
                                    <td width="220">
                                        <input style="width: 140px;" name="et_no" class="input2" value="<ww:property value="passenger.ticketnum" />">
                                    </td>
                                    <td width="160" >
                                        验证码
                                        <input style="width: 78px" name="yzma" class="input2" value="<ww:property value="username.substring(username.length()-4, username.length())" />">
                                    </td>
                                    <td width="300" >
                                        提示信息
                                        <input style="width: 189px" class="input2" name="tishi" 
                                            value="">
                                    </td>
                                    <td>
                                        保险
                                        <ww:if test="passenger.insurprice!=null&&passenger.insurprice>0"><input style="width: 40px" class="input2" value="20" name="bx"></ww:if><ww:else><input style="width: 40px" class="input2" value="20" name="bx"></ww:else>
                                    </td>
                                </tr>
                            </table>
                            <table border="0" cellspacing="0" cellpadding="0">
                                <tr style="height:40px">
                                    <td width="80">
                                        销售单位代号<br />&nbsp;
                                    </td>
                                    <td width="220">
                                        <input style="width: 100px" class="input2" name="xiaoshou_no" value="BJS182"><br />
                                        <input style="width: 100px" class="input2" name="xiaoshou_no_" value="400-648-6998">
                                    </td>
                                    <td width="400">
                                        填开单位
                                        <input style="width: 234px" class="input2" name="tiankai_dw" value="北京华展宏图航空服务有限公司">
                                    </td>
                                    <td>
                                        填开日期
                                        <input style="width: 90px" onfocus="calendar()" name="tiankai_rq" value="<ww:property value=" startDate" />">
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!--endprint-->
        <div style="padding:10px;">
            <input style="border-right: 0px; " src="xxd2/images/buttonyl.gif" type="image" onClick="HentPrint('<ww:property value="pid" />','<ww:property value="username" />');" >
            
        </div>
    </center>
    <div id="div_piaohao">
        <input id="txt_piaohao" type="hidden" name="txt_piaohao">
        <input id="txt_sfz" type="hidden" name="txt_sfz">
        <input id="hid_dingdanhao" type="hidden" name="hid_dingdanhao">
    </div>
    <input id="hid_OfficeNO" type="hidden" name="hid_OfficeNO">
    <input id="hid_isdancheng" value="0" type="hidden" name="hid_isdancheng">
    <input id="hid_orderid" type="hidden" name="hid_orderid">
    <input id="hid_pnr" type="hidden" name="hid_pnr">
    </form>
</body>
</html>
<script src="js/jquery1.3.2.js"></script>
<script language="javascript">

function HentPrint(pid,username)
{ 


bdhtml=window.document.body.innerHTML; 
sprnstr="<!--startprint-->"; 
eprnstr="<!--endprint-->"; 
prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
window.document.body.innerHTML=prnhtml; /* 可以prnhtml前加上 <style><!-- p{font-size:12px;} --></style> */
window.print(); 
}




</script>

