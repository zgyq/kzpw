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

<body>
<div id="member">
<form name="form1" method="post" action="jinribaobiao!daoru.action" enctype="multipart/form-data">
<table width="100%" border="1" cellpadding="0" cellspacing="0"
	align="center"  bordercolor="#86B2D1" style="border-collapse: collapse;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;今日报表导入</span></b></td>
	</tr>
	<tr>

    <td>

    <div class="level2_info">
        <div style="border: #CCCCCC 1px solid; background-color: #F6F6F6; text-align: center;
            width: 80%; margin: 0px auto; padding: 10px">
          
            <br />
            <input type="file" name="batchfile" id="batchfile" class="upfilecss" style="background-color:White;" />&nbsp;
            <input type="submit" name="btnUpLoadExcel" value="上传Excel" id="btnUpLoadExcel" class="btn_blue_w100" />
        </div>
    </div>
   
  
        </td></tr></table>
    </form>
    </div>
</body>
</html>

