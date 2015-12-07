<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="../style/base.css" rel="stylesheet" type="text/css" />
<link href="../style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;添加分销商</b></td>
  </tr>
  <tr>
    <td valign="top"><!--



 <div class="info_01">
        <div style="width: 100%; float: left; border-bottom-style: solid; border-bottom-width: 1px;
            border-bottom-color: #CCCCCC; margin-bottom: 10px">
          <table border="0" width="100%" cellpadding="0" cellspacing="0">
           <tr>
                <td width="100%" height="29" background="../images/jb.gif" style="border-bottom: 1px solid #99CBED">
                    <span class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;&nbsp;添加分销商</span></td>
            </tr>
          </table>
        </div>
    </div>
    --><div>
        <div class="mnue">
            &nbsp;&nbsp;账号信息</div>
        <div class="mnue_nr">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <!--DWLayoutTable-->
                <tr>
                    <td width="15%" align="right">
                        帐户类型：
                    </td>
                    <td width="35%">
                        <span id="lblType" class="font-red">分销商</span>
                    </td>
                    <td width="15%" align="right">
                        <span class="font-red">*</span>帐号
                    </td>
                    <td width="35%">
                        <input name="txtStaffID" type="text" id="txtStaffID" size="14" />
                        1-20个数字、字母
                    </td>
                </tr>
                <tr>
                    <td width="15%" align="right">
                        <span  class="font-red">*</span>姓名
                    </td>
                    <td>
                        <input name="txtStaffName" type="text" id="txtStaffName" size="14" onkeyup="StaffNameAndLinkName();" onbeforepaste="StaffNameAndLinkName();" />
                    </td>
                    <td align="right">
                        <span class="font-red">*</span>使用期限
                    </td>
                    <td>
                        <input name="txtStartDate" type="text" id="txtStartDate" size="14" readonly="readonly" value="2010-1-13" />
                        &nbsp;到
                        <input name="txtEndDate" type="text" id="txtEndDate" size="14" readonly="readonly" value="2050-1-1" />
                    </td>
                </tr>
                <tr>
                    <td width="15%" align="right">
                        移动电话
                    </td>
                    <td>
                        <input name="txtMobile" type="text" id="txtMobile" size="14" onkeyup="MobileAndLinkPhone();" onbeforepaste="MobileAndLinkPhone();" />
                    </td>
                    <td align="right">
                        电子邮件
                    </td>
                    <td>
                        <input name="txtEmail" type="text" id="txtEmail" size="34" onkeyup="EmailAndLinkMail();" onbeforepaste="EmailAndLinkMail();" />
                    </td>
                </tr>
                <tr id="tr_UserCountAndOfficeCode">
	<td width="15%" align="right">
                        <span  class="font-red">*</span>下属帐号个数
                    </td>
	<td colspan="3" valign="top">
                        <input name="txtUserCount" type="text" id="txtUserCount" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''));" onkeyup="value=value.replace(/[^\d]/g,'');" size="14" />
                        <span id="lbUserCount"  class="font-red-xi">可使用帐号数：20</span>
                        
                        <input name="Hid_Count" type="hidden" id="Hid_Count" style="width: 16px" value="20" />
                        <input name="Hid_Count2" type="hidden" id="Hid_Count2" style="width: 16px" value="0" />
                    </td>
</tr>

                <tr>
                    <td width="15%" align="right">
                        默认起飞城市
                    </td>
                    <td>
                        
<table border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td>
<input name="CityFrom$txtCity" type="text" id="CityFrom_txtCity" onkeyup="JavaScript:Select_ToSZM(this,'CityFrom_dropCity');" style="width:32px;" /></td>
        <td>
&nbsp;<select name="CityFrom$dropCity" id="CityFrom_dropCity" onchange="JavaScript:document.all.CityFrom_txtCity.value=this.value" style="width:119px;">
	<option selected="selected" value=""></option>
	<option value="ALA">AEMT-阿尔玛塔-ALA</option>
	<option value="AKU">AKS-阿克苏-SKU</option>
	<option value="AKA">AK-安康-AKA</option>
	<option value="AAT">ALT-阿勒泰-AAT</option>
	<option value="MFM">AM-澳门-MFM</option>
	<option value="AQG">AQ-安庆-AQG</option>
	<option value="AVA">AS-安顺-AVA</option>
	<option value="AOG">AS-鞍山-AOG</option>
	<option value="AYN">AY-安阳-AYN</option>
	<option value="BFU">BB-蚌埠-BFU</option>
	<option value="BHY">BH-北海-BHY</option>
	<option value="NAY">BJ-北京-NAY</option>
	<option value="PEK">BJ-北京-PEK</option>
	<option value="AEB">BSTY-百色田阳-AEB</option>
	<option value="BSD">BS-保山-BSD</option>
	<option value="BAV">BT-包头-BAV</option>
	<option value="NBS">CBS-长白山-NBS</option>
	<option value="CGQ">CC-长春-CGQ</option>
	<option value="BPX">CD-昌都-BPX</option>
	<option value="CGD">CD-常德-CGD</option>
	<option value="CTU">CD-成都-CTU</option>
	<option value="CIF">CF-赤峰-CIF</option>
	<option value="CNI">CH-长海-CNI</option>
	<option value="CKG">CQ-重庆-CKG</option>
	<option value="CSX">CS-长沙-CSX</option>
	<option value="CHG">CY-朝阳-CHG</option>
	<option value="CIH">CZ-长治-CIH</option>
	<option value="CZX">CZ-常州-CZX</option>
	<option value="CCC">CZ-潮州-CCC</option>
	<option value="DDG">DD-丹东-DDG</option>
	<option value="DNH">DH-敦煌-DNH</option>
	<option value="DLU">DL-大理-DLU</option>
	<option value="DLC">DL-大连-DLC</option>
	<option value="DQA">DQ-大庆-DQA</option>
	<option value="DAT">DT-大同-DAT</option>
	<option value="DOY">DY-东营-DOY</option>
	<option value="DAX">DZ-达州-DAX</option>
	<option value="DZU">DZ-大足-DZU</option>
	<option value="DSN">EEDS-鄂尔多斯-DSN</option>
	<option value="ENH">ES-恩施-ENH</option>
	<option value="FUO">FS-佛山-FUO</option>
	<option value="FUG">FY-阜阳-FUG</option>
	<option value="FYN">FY-富蕴-FYN</option>
	<option value="FOC">FZ-福州-FOC</option>
	<option value="GOQ">GEM-格尔木-GOQ</option>
	<option value="GHN">GH-广汉-GHN</option>
	<option value="KWL">GL-桂林-KWL</option>
	<option value="KHH">GX-高雄-KHH</option>
	<option value="GYS">GY-广元-GYS</option>
	<option value="KWE">GY-贵阳-KWE</option>
	<option value="KOW">GZ-赣州-KOW</option>
	<option value="CAN">GZ-广州-CAN</option>
	<option value="HDG">HD-邯郸-HDG</option>
	<option value="HRB">HEB-哈尔滨-HRB</option>
	<option value="HFE">HF-合肥-HFE</option>
	<option value="HET">HHHT-呼和浩特-HET</option>
	<option value="HEK">HH-黑河-HEK</option>
	<option value="HJJ">HH-怀化-HJJ</option>
	<option value="HAK">HK-海口-HAK</option>
	<option value="HLD">HLE-海拉尔-HLD</option>
	<option value="HUN">HL-花莲-HUN</option>
	<option value="HMI">HM-哈密-HMI</option>
	<option value="TXN">HS-黄山-TXN</option>
	<option value="HTN">HT-和田-HTN</option>
	<option value="HNY">HY-衡阳-HNY</option>
	<option value="HYN">HY-黄岩-HYN</option>
	<option value="HZG">HZ-汉中-HZG</option>
	<option value="HGH">HZ-杭州-HGH</option>
	<option value="HUZ">HZ-徽州-HUZ</option>
	<option value="KNC">JA-吉安-KNC</option>
	<option value="JDZ">JDZ-景德镇-JDZ</option>
	<option value="JGS">JGS-井冈山-JGS</option>
	<option value="JHG">JH-景洪-JHG</option>
	<option value="JJN">JJ-晋江-JJN</option>
	<option value="JIU">JJ-九江-JIU</option>
	<option value="JIL">JL-吉林-JIL</option>
	<option value="JMU">JMS-佳木斯-JMU</option>
	<option value="KNH">JM-金门-KNH</option>
	<option value="TNA">JN-济南-TNA</option>
	<option value="JNG">JN-济宁-JNG</option>
	<option value="CHW">JQ-酒泉-CHW</option>
	<option value="JXA">JX-鸡西-JXA</option>
	<option value="JGN">JYG-嘉峪关-JGN</option>
	<option value="CYI">JY-嘉义-CYI</option>
	<option value="JZH">JZG-九寨沟-JZH</option>
	<option value="CJU">JZ-济州-CJU</option>
	<option value="JNZ">JZ-锦州-JNZ</option>
	<option value="SHS">JZ-荆州-SHS</option>
	<option value="KCA">KC-库车-KCA</option>
	<option value="KGT">KD-康定-KGT</option>
	<option value="KRL">KEL-库尔勒-KRL</option>
	<option value="KRY">KLMY-克拉玛依-KRY</option>
	<option value="KMG">KM-昆明-KMG</option>
	<option value="KHG">KS-喀什-KHG</option>
	<option value="LLB">LB-荔波-LLB</option>
	<option value="LCX">LC-连城-LCX</option>
	<option value="LNJ">LC-临沧-LNJ</option>
	<option value="LJG">LJ-丽江-LJG</option>
	<option value="HZH">LP-黎平-HZH</option>
	<option value="LIA">LP-梁平-LIA</option>
	<option value="LXA">LS-拉萨-LXA</option>
	<option value="LHN">LS-梨山-LHN</option>
	<option value="LUZ">LS-庐山-LUZ</option>
	<option value="LXI">LX-林西-LXI</option>
	<option value="LYG">LYG-连云港-LYG</option>
	<option value="KYD">LY-兰屿-KYD</option>
	<option value="LYI">LY-临沂-LYI</option>
	<option value="LYA">LY-洛阳-LYA</option>
	<option value="LHW">LZ-兰州-LHW</option>
	<option value="LZY">LZ-林芝-LZY</option>
	<option value="LZH">LZ-柳州-LZH</option>
	<option value="LZO">LZ-泸州-LZO</option>
	<option value="MDG">MDJ-牡丹江-MDG</option>
	<option value="MZG">MG-马公-MZG</option>
	<option value="OHE">MH-漠河-OHE</option>
	<option value="LUM">MS-芒市-LUM</option>
	<option value="MIG">MY-绵阳-MIG</option>
	<option value="NZH">MZL-满洲里-NZH</option>
	<option value="LZN">MZ-马祖-LZN</option>
	<option value="MFK">MZ-马祖-MFK</option>
	<option value="MXZ">MZ-梅州-MXZ</option>
	<option value="NGB">NB-宁波-NGB</option>
	<option value="KHN">NC-南昌-KHN</option>
	<option value="NAO">NC-南充-NAO</option>
	<option value="NKG">NJ-南京-NKG</option>
	<option value="NNG">NN-南宁-NNG</option>
	<option value="NTG">NT-南通-NTG</option>
	<option value="NNY">NY-南阳-NNY</option>
	<option value="HCN">PD-屏东-HCN</option>
	<option value="PIF">PD-屏东-PIF</option>
	<option value="CMJ">PH-澎湖-CMJ</option>
	<option value="WOT">PH-澎湖-WOT</option>
	<option value="PZI">PZH-攀枝花-PZI</option>
	<option value="TAO">QD-青岛-TAO</option>
	<option value="SHP">QHD-秦皇岛-SHP</option>
	<option value="YUS">QHSYS-青海省玉树-YUS</option>
	<option value="IQM">QM-且末-IQM</option>
	<option value="NDG">QQHE-齐齐哈尔-NDG</option>
	<option value="IQN">QY-庆阳-IQN</option>
	<option value="HIN">QZ-清州-HIN</option>
	<option value="JUZ">QZ-衢州-JUZ</option>
	<option value="PVG">SH-上海-PVG</option>
	<option value="SHA">SH-上海-SHA</option>
	<option value="SJW">SJZ-石家庄-SJW</option>
	<option value="SYM">SM-思茅-SYM</option>
	<option value="SWA">ST-汕头-SWA</option>
	<option value="SYX">SY-三亚-SYX</option>
	<option value="SHE">SY-沈阳-SHE</option>
	<option value="SZX">SZ-深圳-SZX</option>
	<option value="SZV">SZ-苏州-SZV</option>
	<option value="TSA">TB-台北-TSA</option>
	<option value="TPE">TB-桃园-TPE</option>
	<option value="TCG">TC-塔城-TCG</option>
	<option value="TCZ">TC-腾冲-TCZ</option>
	<option value="GNI">TD-台东-GNI</option>
	<option value="TTT">TD-台东-TTT</option>
	<option value="TNH">TH-通化-TNH</option>
	<option value="TSN">TJ-天津-TSN</option>
	<option value="TGO">TL-通辽-TGO</option>
	<option value="TNN">TN-台南-TNN</option>
	<option value="TEN">TR-铜仁-TEN</option>
	<option value="THQ">TS-天水-THQ</option>
	<option value="TYN">TY-太原-TYN</option>
	<option value="RMQ">TZ-台中-RMQ</option>
	<option value="TXG">TZ-台中-TXG</option>
	<option value="WEF">WF-潍坊-WEF</option>
	<option value="WEH">WH-威海-WEH</option>
	<option value="WUA">WH-乌海-WUA</option>
	<option value="WHU">WH-芜湖-WHU</option>
	<option value="WUH">WH-武汉-WUH</option>
	<option value="HLH">WLHT-乌兰浩特-HLH</option>
	<option value="URC">WLMQ-乌鲁木齐-URC</option>
	<option value="WNH">WS-文山-WNH</option>
	<option value="WUX">WX-无锡-WUX</option>
	<option value="WUS">WYS-武夷山-WUS</option>
	<option value="WXN">WZ-万州-WXN</option>
	<option value="WNZ">WZ-温州-WNZ</option>
	<option value="WUZ">WZ-梧州-WUZ</option>
	<option value="SIA">XA-西安-SIA</option>
	<option value="XIY">XA-西安-XIY</option>
	<option value="XIC">XC-西昌-XIC</option>
	<option value="XEN">XC-兴城-XEN</option>
	<option value="XFN">XF-襄樊-XFN</option>
	<option value="HKG">XG-香港-HKG</option>
	<option value="KJI">XJ-新疆-KJI</option>
	<option value="NLT">XJ-新疆-NLT</option>
	<option value="XIL">XLHT-锡林浩特-XIL</option>
	<option value="XMN">XM-厦门-XMN</option>
	<option value="XNN">XN-西宁-XNN</option>
	<option value="XIN">XN-兴宁-XIN</option>
	<option value="XNT">XT-邢台-XNT</option>
	<option value="ACX">XY-兴义-ACX</option>
	<option value="XUZ">XZ-徐州-XUZ</option>
	<option value="ENY">YA-延安-ENY</option>
	<option value="YBP">YB-宜宾-YBP</option>
	<option value="YNZ">YC-盐城-YNZ</option>
	<option value="LDS">YC-伊春-LDS</option>
	<option value="YIH">YC-宜昌-YIH</option>
	<option value="INC">YC-银川-INC</option>
	<option value="YCU">YC-运城-YCU</option>
	<option value="YNJ">YJ-延吉-YNJ</option>
	<option value="YLN">YL-铱兰-YLN</option>
	<option value="UYN">YL-榆林-UYN</option>
	<option value="YUA">YM-元谋-YUA</option>
	<option value="YIN">YN-伊宁-YIN</option>
	<option value="YNT">YT-烟台-YNT</option>
	<option value="YIW">YW-义乌-YIW</option>
	<option value="LLF">YZ-永州-LLF</option>
	<option value="DIG">ZD-中甸-DIG</option>
	<option value="ZUH">ZH-珠海-ZUH</option>
	<option value="DYG">ZJJ-张家界-DYG</option>
	<option value="ZHA">ZJ-湛江-ZHA</option>
	<option value="HSN">ZS-舟山-HSN</option>
	<option value="ZAT">ZT-昭通-ZAT</option>
	<option value="ZHY">ZW-中卫-ZHY</option>
	<option value="ZYI">ZY-遵义-ZYI</option>
	<option value="CGO">ZZ-郑州-CGO</option>

</select></td>
       
    </tr>
</table>

                    </td>
                    <td align="right">
                        默认到达城市
                    </td>
                    <td>
                        
<table border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td>
<input name="CityArrive$txtCity" type="text" id="CityArrive_txtCity" onkeyup="JavaScript:Select_ToSZM(this,'CityArrive_dropCity');" style="width:32px;" /></td>
        <td>
&nbsp;<select name="CityArrive$dropCity" id="CityArrive_dropCity" onchange="JavaScript:document.all.CityArrive_txtCity.value=this.value" style="width:119px;">
	<option selected="selected" value=""></option>
	<option value="ALA">AEMT-阿尔玛塔-ALA</option>
	<option value="AKU">AKS-阿克苏-SKU</option>
	<option value="AKA">AK-安康-AKA</option>
	<option value="AAT">ALT-阿勒泰-AAT</option>
	<option value="MFM">AM-澳门-MFM</option>
	<option value="AQG">AQ-安庆-AQG</option>
	<option value="AVA">AS-安顺-AVA</option>
	<option value="AOG">AS-鞍山-AOG</option>
	<option value="AYN">AY-安阳-AYN</option>
	<option value="BFU">BB-蚌埠-BFU</option>
	<option value="BHY">BH-北海-BHY</option>
	<option value="NAY">BJ-北京-NAY</option>
	<option value="PEK">BJ-北京-PEK</option>
	<option value="AEB">BSTY-百色田阳-AEB</option>
	<option value="BSD">BS-保山-BSD</option>
	<option value="BAV">BT-包头-BAV</option>
	<option value="NBS">CBS-长白山-NBS</option>
	<option value="CGQ">CC-长春-CGQ</option>
	<option value="BPX">CD-昌都-BPX</option>
	<option value="CGD">CD-常德-CGD</option>
	<option value="CTU">CD-成都-CTU</option>
	<option value="CIF">CF-赤峰-CIF</option>
	<option value="CNI">CH-长海-CNI</option>
	<option value="CKG">CQ-重庆-CKG</option>
	<option value="CSX">CS-长沙-CSX</option>
	<option value="CHG">CY-朝阳-CHG</option>
	<option value="CIH">CZ-长治-CIH</option>
	<option value="CZX">CZ-常州-CZX</option>
	<option value="CCC">CZ-潮州-CCC</option>
	<option value="DDG">DD-丹东-DDG</option>
	<option value="DNH">DH-敦煌-DNH</option>
	<option value="DLU">DL-大理-DLU</option>
	<option value="DLC">DL-大连-DLC</option>
	<option value="DQA">DQ-大庆-DQA</option>
	<option value="DAT">DT-大同-DAT</option>
	<option value="DOY">DY-东营-DOY</option>
	<option value="DAX">DZ-达州-DAX</option>
	<option value="DZU">DZ-大足-DZU</option>
	<option value="DSN">EEDS-鄂尔多斯-DSN</option>
	<option value="ENH">ES-恩施-ENH</option>
	<option value="FUO">FS-佛山-FUO</option>
	<option value="FUG">FY-阜阳-FUG</option>
	<option value="FYN">FY-富蕴-FYN</option>
	<option value="FOC">FZ-福州-FOC</option>
	<option value="GOQ">GEM-格尔木-GOQ</option>
	<option value="GHN">GH-广汉-GHN</option>
	<option value="KWL">GL-桂林-KWL</option>
	<option value="KHH">GX-高雄-KHH</option>
	<option value="GYS">GY-广元-GYS</option>
	<option value="KWE">GY-贵阳-KWE</option>
	<option value="KOW">GZ-赣州-KOW</option>
	<option value="CAN">GZ-广州-CAN</option>
	<option value="HDG">HD-邯郸-HDG</option>
	<option value="HRB">HEB-哈尔滨-HRB</option>
	<option value="HFE">HF-合肥-HFE</option>
	<option value="HET">HHHT-呼和浩特-HET</option>
	<option value="HEK">HH-黑河-HEK</option>
	<option value="HJJ">HH-怀化-HJJ</option>
	<option value="HAK">HK-海口-HAK</option>
	<option value="HLD">HLE-海拉尔-HLD</option>
	<option value="HUN">HL-花莲-HUN</option>
	<option value="HMI">HM-哈密-HMI</option>
	<option value="TXN">HS-黄山-TXN</option>
	<option value="HTN">HT-和田-HTN</option>
	<option value="HNY">HY-衡阳-HNY</option>
	<option value="HYN">HY-黄岩-HYN</option>
	<option value="HZG">HZ-汉中-HZG</option>
	<option value="HGH">HZ-杭州-HGH</option>
	<option value="HUZ">HZ-徽州-HUZ</option>
	<option value="KNC">JA-吉安-KNC</option>
	<option value="JDZ">JDZ-景德镇-JDZ</option>
	<option value="JGS">JGS-井冈山-JGS</option>
	<option value="JHG">JH-景洪-JHG</option>
	<option value="JJN">JJ-晋江-JJN</option>
	<option value="JIU">JJ-九江-JIU</option>
	<option value="JIL">JL-吉林-JIL</option>
	<option value="JMU">JMS-佳木斯-JMU</option>
	<option value="KNH">JM-金门-KNH</option>
	<option value="TNA">JN-济南-TNA</option>
	<option value="JNG">JN-济宁-JNG</option>
	<option value="CHW">JQ-酒泉-CHW</option>
	<option value="JXA">JX-鸡西-JXA</option>
	<option value="JGN">JYG-嘉峪关-JGN</option>
	<option value="CYI">JY-嘉义-CYI</option>
	<option value="JZH">JZG-九寨沟-JZH</option>
	<option value="CJU">JZ-济州-CJU</option>
	<option value="JNZ">JZ-锦州-JNZ</option>
	<option value="SHS">JZ-荆州-SHS</option>
	<option value="KCA">KC-库车-KCA</option>
	<option value="KGT">KD-康定-KGT</option>
	<option value="KRL">KEL-库尔勒-KRL</option>
	<option value="KRY">KLMY-克拉玛依-KRY</option>
	<option value="KMG">KM-昆明-KMG</option>
	<option value="KHG">KS-喀什-KHG</option>
	<option value="LLB">LB-荔波-LLB</option>
	<option value="LCX">LC-连城-LCX</option>
	<option value="LNJ">LC-临沧-LNJ</option>
	<option value="LJG">LJ-丽江-LJG</option>
	<option value="HZH">LP-黎平-HZH</option>
	<option value="LIA">LP-梁平-LIA</option>
	<option value="LXA">LS-拉萨-LXA</option>
	<option value="LHN">LS-梨山-LHN</option>
	<option value="LUZ">LS-庐山-LUZ</option>
	<option value="LXI">LX-林西-LXI</option>
	<option value="LYG">LYG-连云港-LYG</option>
	<option value="KYD">LY-兰屿-KYD</option>
	<option value="LYI">LY-临沂-LYI</option>
	<option value="LYA">LY-洛阳-LYA</option>
	<option value="LHW">LZ-兰州-LHW</option>
	<option value="LZY">LZ-林芝-LZY</option>
	<option value="LZH">LZ-柳州-LZH</option>
	<option value="LZO">LZ-泸州-LZO</option>
	<option value="MDG">MDJ-牡丹江-MDG</option>
	<option value="MZG">MG-马公-MZG</option>
	<option value="OHE">MH-漠河-OHE</option>
	<option value="LUM">MS-芒市-LUM</option>
	<option value="MIG">MY-绵阳-MIG</option>
	<option value="NZH">MZL-满洲里-NZH</option>
	<option value="LZN">MZ-马祖-LZN</option>
	<option value="MFK">MZ-马祖-MFK</option>
	<option value="MXZ">MZ-梅州-MXZ</option>
	<option value="NGB">NB-宁波-NGB</option>
	<option value="KHN">NC-南昌-KHN</option>
	<option value="NAO">NC-南充-NAO</option>
	<option value="NKG">NJ-南京-NKG</option>
	<option value="NNG">NN-南宁-NNG</option>
	<option value="NTG">NT-南通-NTG</option>
	<option value="NNY">NY-南阳-NNY</option>
	<option value="HCN">PD-屏东-HCN</option>
	<option value="PIF">PD-屏东-PIF</option>
	<option value="CMJ">PH-澎湖-CMJ</option>
	<option value="WOT">PH-澎湖-WOT</option>
	<option value="PZI">PZH-攀枝花-PZI</option>
	<option value="TAO">QD-青岛-TAO</option>
	<option value="SHP">QHD-秦皇岛-SHP</option>
	<option value="YUS">QHSYS-青海省玉树-YUS</option>
	<option value="IQM">QM-且末-IQM</option>
	<option value="NDG">QQHE-齐齐哈尔-NDG</option>
	<option value="IQN">QY-庆阳-IQN</option>
	<option value="HIN">QZ-清州-HIN</option>
	<option value="JUZ">QZ-衢州-JUZ</option>
	<option value="PVG">SH-上海-PVG</option>
	<option value="SHA">SH-上海-SHA</option>
	<option value="SJW">SJZ-石家庄-SJW</option>
	<option value="SYM">SM-思茅-SYM</option>
	<option value="SWA">ST-汕头-SWA</option>
	<option value="SYX">SY-三亚-SYX</option>
	<option value="SHE">SY-沈阳-SHE</option>
	<option value="SZX">SZ-深圳-SZX</option>
	<option value="SZV">SZ-苏州-SZV</option>
	<option value="TSA">TB-台北-TSA</option>
	<option value="TPE">TB-桃园-TPE</option>
	<option value="TCG">TC-塔城-TCG</option>
	<option value="TCZ">TC-腾冲-TCZ</option>
	<option value="GNI">TD-台东-GNI</option>
	<option value="TTT">TD-台东-TTT</option>
	<option value="TNH">TH-通化-TNH</option>
	<option value="TSN">TJ-天津-TSN</option>
	<option value="TGO">TL-通辽-TGO</option>
	<option value="TNN">TN-台南-TNN</option>
	<option value="TEN">TR-铜仁-TEN</option>
	<option value="THQ">TS-天水-THQ</option>
	<option value="TYN">TY-太原-TYN</option>
	<option value="RMQ">TZ-台中-RMQ</option>
	<option value="TXG">TZ-台中-TXG</option>
	<option value="WEF">WF-潍坊-WEF</option>
	<option value="WEH">WH-威海-WEH</option>
	<option value="WUA">WH-乌海-WUA</option>
	<option value="WHU">WH-芜湖-WHU</option>
	<option value="WUH">WH-武汉-WUH</option>
	<option value="HLH">WLHT-乌兰浩特-HLH</option>
	<option value="URC">WLMQ-乌鲁木齐-URC</option>
	<option value="WNH">WS-文山-WNH</option>
	<option value="WUX">WX-无锡-WUX</option>
	<option value="WUS">WYS-武夷山-WUS</option>
	<option value="WXN">WZ-万州-WXN</option>
	<option value="WNZ">WZ-温州-WNZ</option>
	<option value="WUZ">WZ-梧州-WUZ</option>
	<option value="SIA">XA-西安-SIA</option>
	<option value="XIY">XA-西安-XIY</option>
	<option value="XIC">XC-西昌-XIC</option>
	<option value="XEN">XC-兴城-XEN</option>
	<option value="XFN">XF-襄樊-XFN</option>
	<option value="HKG">XG-香港-HKG</option>
	<option value="KJI">XJ-新疆-KJI</option>
	<option value="NLT">XJ-新疆-NLT</option>
	<option value="XIL">XLHT-锡林浩特-XIL</option>
	<option value="XMN">XM-厦门-XMN</option>
	<option value="XNN">XN-西宁-XNN</option>
	<option value="XIN">XN-兴宁-XIN</option>
	<option value="XNT">XT-邢台-XNT</option>
	<option value="ACX">XY-兴义-ACX</option>
	<option value="XUZ">XZ-徐州-XUZ</option>
	<option value="ENY">YA-延安-ENY</option>
	<option value="YBP">YB-宜宾-YBP</option>
	<option value="YNZ">YC-盐城-YNZ</option>
	<option value="LDS">YC-伊春-LDS</option>
	<option value="YIH">YC-宜昌-YIH</option>
	<option value="INC">YC-银川-INC</option>
	<option value="YCU">YC-运城-YCU</option>
	<option value="YNJ">YJ-延吉-YNJ</option>
	<option value="YLN">YL-铱兰-YLN</option>
	<option value="UYN">YL-榆林-UYN</option>
	<option value="YUA">YM-元谋-YUA</option>
	<option value="YIN">YN-伊宁-YIN</option>
	<option value="YNT">YT-烟台-YNT</option>
	<option value="YIW">YW-义乌-YIW</option>
	<option value="LLF">YZ-永州-LLF</option>
	<option value="DIG">ZD-中甸-DIG</option>
	<option value="ZUH">ZH-珠海-ZUH</option>
	<option value="DYG">ZJJ-张家界-DYG</option>
	<option value="ZHA">ZJ-湛江-ZHA</option>
	<option value="HSN">ZS-舟山-HSN</option>
	<option value="ZAT">ZT-昭通-ZAT</option>
	<option value="ZHY">ZW-中卫-ZHY</option>
	<option value="ZYI">ZY-遵义-ZYI</option>
	<option value="CGO">ZZ-郑州-CGO</option>

</select></td>
       
    </tr>
</table>

                    </td>
                </tr>
                
                
                <tr>
                    <td width="15%" height="30" align="right">
                        共享业务员
                    </td>
                    <td colspan="3" valign="top">
                        <table  width="100%">
                            <tr>
                                <td>
                                    <table id="tab_ShareSales" width="100%" >
	<tr>
		<td width="390">
              <textarea name="txtDictate" rows="2" cols="20" id="txtDictate" style="height:70px;width:360px;">/fzht/</textarea>
          </td>    
         <td width="100">     <input type="button" class="button_d font-white" value="选择业务员" onclick="searchOne()" />
               
                                            </td>
                                            <Td>&nbsp;</Td>
	</tr>
</table>

                                    <table id="tab_ShareSalesOp" cellspacing="1" cellpadding="0" width="100%" style=" display: none;">
	<tr>
		<td class="ytd2">
                                                <input id="CkBAll" type="checkbox" name="CkBAll" onclick="OnCheckedAll(this);" /><label for="CkBAll">全　部</label>
                                                <table id="DataList1" cellspacing="0" border="0" style="border-collapse:collapse;">
			<tr>
				<td>
                                                        <input id="DataList1_ctl00_CheckBox1" type="checkbox" name="DataList1$ctl00$CheckBox1" checked="checked" onclick="javascript:chkOne(this);" /><label for="DataList1_ctl00_CheckBox1">fzht</label>
                                                    </td><td>
                                                        <input id="DataList1_ctl01_CheckBox1" type="checkbox" name="DataList1$ctl01$CheckBox1" onclick="javascript:chkOne(this);" /><label for="DataList1_ctl01_CheckBox1">huitaojp001</label>
                                                    </td><td></td><td></td><td></td><td></td><td></td><td></td>
			</tr>
		</table>
                                            </td>
	</tr>
	<tr>
		<td>
                                                <input name="btnSaveAccredit" type="button" id="btnSaveAccredit" class="button font-red" value="返　回" onclick="ButtonSaveAccredit();" />
                                            </td>
	</tr>
</table>

                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <div>
        <div class="mnue">
            &nbsp;&nbsp;单位信息</div>
        <div class="mnue_nr">
            <table cellspacing="0" cellpadding="0" width="100%">
                <tbody>
                    <tr>
                        <td width="15%" align="right">
                            <span class="font-red">*</span>单位名称
                        </td>
                        <td width="35%">
                            <input name="txtDepartmentName" type="text" id="txtDepartmentName" size="38" />
                        </td>
                        <td width="15%" align="right">
                            <span class="font-red">*</span>单位简称
                        </td>
                        <td width="35%">
                            <input name="txtDepartmentForShort" type="text" id="txtDepartmentForShort" size="20" />
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            支付宝收款帐号
                        </td>
                        <td>
                            <input name="txtValidate" type="text" id="txtValidate" readonly="readonly" style="width:120px;" />

                             <input type="button" class="button_d font-white" value="验证此账号" onclick="searchOne()" />
               
                        </td>
                        <td align="right">
                            支付宝提成账号
                        </td>
                        <td>
                            <input name="txtPayPwd1" type="text" id="txtPayPwd1" readonly="readonly" style="width:120px;" />
                             <input type="button" class="button_d font-white" value="验证此账号" onclick="searchOne()" />
               
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            快钱收款帐号
                        </td>
                        <td>
                            <input name="PayPwd2" type="text" id="PayPwd2" readonly="readonly" style="width:120px;" />
                            <span id="lblPayPwd2"></span>
                        </td>
                        <td align="right">
                            快钱提成账号
                        </td>
                        <td>
                            <input name="txtPayUserName3" type="text" id="txtPayUserName3" readonly="readonly" style="width:120px;" />
                            <span id="lblUserName3"></span>
                        </td>
                    </tr>
                    <tr >
                        <td align="right">
                            财付通收款账号                            
                        </td>
                        <td>
                            <input name="txtPayPwd3" type="text" id="txtPayPwd3" readonly="readonly" style="width:120px;" />
                             <input name="txtPKName" type="text" id="txtPKName" readonly="readonly" style="width:85px;" />
                            <input type="button" class="button_d font-white" value="验证此账号" onclick="searchOne()" />
               
                        </td>
                        <td align="right">
                            财付通提成账号
                        </td>
                        <td>
                            <input name="txtCorporationID" type="text" id="txtCorporationID" readonly="readonly" style="width:120px;" />
                             <input name="txtTCName" type="text" id="txtTCName" readonly="readonly" style="width:85px;" />
                                <input type="button" class="button_d font-white" value="验证此账号" onclick="searchOne()" />
               
                       
                        </td>
                    </tr>
                    
                    <tr>
                        <td align="right">
                            <span class="font-red">*</span>所在地
                        </td>
                        <td>
                            <select name="dropProvince" id="dropProvince" onchange="ajax();" style="width:90px;">
	<option selected="selected" value="省份">省份</option>
	<option value="台湾省">台湾省</option>
	<option value="内蒙古">内蒙古</option>
	<option value="云南省">云南省</option>
	<option value="河南省">河南省</option>
	<option value="贵州省">贵州省</option>
	<option value="海南省">海南省</option>
	<option value="广西">广西</option>
	<option value="黑龙江省">黑龙江省</option>
	<option value="江西省">江西省</option>
	<option value="西藏">西藏</option>
	<option value="四川省">四川省</option>
	<option value="湖南省">湖南省</option>
	<option value="安徽省">安徽省</option>
	<option value="天津市">天津市</option>
	<option value="陕西省">陕西省</option>
	<option value="北京市">北京市</option>
	<option value="山东省">山东省</option>
	<option value="湖北省">湖北省</option>
	<option value="吉林省">吉林省</option>
	<option value="上海市">上海市</option>
	<option value="江苏省">江苏省</option>
	<option value="辽宁省">辽宁省</option>
	<option value="山西省">山西省</option>
	<option value="新疆">新疆</option>
	<option value="河北省">河北省</option>
	<option value="浙江省">浙江省</option>
	<option value="甘肃省">甘肃省</option>
	<option value="重庆市">重庆市</option>
	<option value="福建省">福建省</option>
	<option value="青海省">青海省</option>
	<option value="广东省">广东省</option>
	<option value="香港">香港</option>
	<option value="宁夏">宁夏</option>

</select>
                            <select name="dropCity" id="dropCity" onchange="HidCity.value=this.value" style="width:90px;">
	<option value="地级市">地级市</option>

</select>
                        </td>
                                                <td align="right">
                            单位电话
                        </td>
                        <td>
                            <input name="txtPhone" type="text" id="txtPhone" size="18" />
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            通信地址
                        </td>
                        <td>
                            <input name="txtCompAddres" type="text" id="txtCompAddres" size="38" />
                        </td>
                                                <td align="right">
                            邮政编码
                        </td>
                        <td>
                            <input name="txtPostCode" type="text" id="txtPostCode" size="38" />
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            联系人
                        </td>
                        <td>
                            <input name="txtLinkMan" type="text" id="txtLinkMan" size="38" />
                        </td>
                                                <td align="right">
                            联系人电话
                        </td>
                        <td>
                            <input name="txtLinkPhone" type="text" id="txtLinkPhone" size="34" />
                        </td>
                    </tr>
                    <tr>

                        <td align="right">
                            联系人邮箱
                        </td>
                        <td>
                            <input name="txtLinkMail" type="text" id="txtLinkMail" size="38" />
                        </td>
                    </tr>
                </tbody>
            </table>
         <div  align="center" style="margin-top: 10px; height:40px;">
        <input type="button" class="button_d font-white" value="确 认" onclick="searchOne()" />
                                                
        
        <input type="button" class="button_d font-white" value="返 回" onclick="searchOne()" />
                                                
        <input name="txtdeptId" type="hidden" id="txtdeptId" />
        <input name="HidCity" type="hidden" id="HidCity" />
    </div>
        </div>
        <div style="height:3px;">&nbsp;</div>
    </div>


    
    
  </td>
   </tr>
   </table>
</div>  
    <div >
        <strong><span class="font-red">注意事项:</span></strong>
        <br />
        <ul style="padding-left:30px;">
            <li>默认为全部选择 即该帐户拥有所有权限</li>
            <li>点击模块选择框 该下属选择框 默认为相同状态</li>
            <li>没有选择的功能 将被视为该帐户禁止使用的功能 </li>
        </ul>
   </div> 
</body>
</html>
