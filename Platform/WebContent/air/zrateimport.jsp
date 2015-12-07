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
<title>无标题文档</title>
</head>
<link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>

<script type="text/javascript" src="../js/ext-all.js"></script>

<link href="../css/base.css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<body>
<div id="member">
<form name="form1" method="post" action="zrate!importzrate.action" enctype="multipart/form-data">
<table width="100%" border="1" cellpadding="0" cellspacing="0"
	align="center"  bordercolor="#86B2D1" style="border-collapse: collapse;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;政策管理 - 政策批量导入</span></b></td>
	</tr>
	<tr>

    <td>

    <div class="level2_info">
        <div style="width: 70%; margin: 40px auto 20px auto; line-height: 20px">
            <span style="font-size: 14px; font-weight: bold">Excel表格模板下载：</span>
            <a id="lbtnUpLoad" href="air/CoreSupplierPolicyImportTemplate.xls">普通政策</a>
            &nbsp;<br />
            <span style="color: #999999">为保证政策数据的准确性，请先下载Excel表格模板，按模板内容编辑政策数据，并仔细检查政策是否有误.</span></div>
    </div>
    <div class="level2_info">
        <div style="border: #CCCCCC 1px solid; background-color: #F6F6F6; text-align: center;
            width: 80%; margin: 0px auto; padding: 10px">
            <span style="font-size: 14px; font-weight: bold">请上传已编辑好的政策EXCEL表格</span><br />
            <br />
            <input type="file" name="batchfile" id="batchfile" class="upfilecss" style="background-color:White;" />&nbsp;
            <input type="submit" name="btnUpLoadExcel" value="上传Excel" id="btnUpLoadExcel" class="btn_blue_w100" />
        </div>
    </div>
    <div id="leaveDataDIV" style="width:80%;margin:0px auto;padding:10px;line-height:15px;display:none;">
        <table cellpadding="0" cellspacing="0" style="border: #CCCCCC 1px solid; margin: 0px auto;
            padding: 10px" width="100%">
            <tr>
                <td style="color: #FF3300; font-weight: bold">
                    无法导入的数据如下：
                </td>
            </tr>
            <tr>
                <td>
                    
                    
                </td>
            </tr>
        </table>
    </div>
    <div style="width: 80%; margin: 20px auto 0px auto; line-height: 18px">
        <span style="color: #FF3300; font-weight: bold">政策批量导入注意事项：</span><br />
        1.一次导入的数据不能超过500条。<br />
        2.Excel中输入的字母不分大小写,返点数值必须在0-99.9之间,超出的请到录入页面录入 。<br />
        3.下载模板的每个列名里都有备注，提示当前列怎么填写，鼠标放在上面可以查看到，其中的红色为必填，黑色可选填。<br />
        4.导入后，可以在审核页面下批量审核，在已发布的普通政策页面下批量删除。<br />
        5.目前可支持单程散客普通舱位的导入，各航可导入的舱位段：<br />
        &nbsp;&nbsp;&nbsp;&nbsp;CZ:F-X FM:F-W HU:F-E MF:F-R MU:F-W SC:F-Z 3U:F-I ZH:F-B
        BK:F-T EU:F-I KN:F-I 8L:F-E 8C:F-X
        <br />
        &nbsp;&nbsp;&nbsp;&nbsp;HO:F-W G5:F-V CA:F-U PN:F-E GS:F-E 9C:Y-E NS:F-I CN:F-E
        VD:F-B OQ:F-E JD:F-E KY:F-B JR:Y-T
    </div>
        </td></tr></table>
    </form>
    </div>
</body>
</html>
<script>
<ww:if test="#request.message!=null">
$(document).ready(function(){
 alert('<ww:property value="#request.message"/>');
 window.location.href="zrate!toimp.action";
 
});
</ww:if>
</script>