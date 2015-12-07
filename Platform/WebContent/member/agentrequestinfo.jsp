<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
  
<link href="css/css.css" type="text/css" rel="stylesheet" />

<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>

<style>
.button1{background:url(images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-weight:bold;cursor:pointer;}
.val{color: red;}
</style>
</head>
<body style="background: none">
<div id="other" style="width: 100%">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;加盟商详细信息</b></td>
	</tr>
	<td>
     <div class=" right_n" style="background: none;">
     
           <div class="biaoti">账号信息</div>
           <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
              <tr>
                <td align="right"   width="85">申请类型：</td>
                <td width="200">
                <ww:property value="customeragent.agenttype==2?'供应商':'采购商'"/>
                </td>
              </tr>
              <tr>
                <td align="right">公司名称：</td>
                <td><ww:property value="customeragent.agentcompanyname"/></td>
              </tr>
              <tr>
                <td align="right">公司位置：</td>
                <td><ww:property value="customeragent.agentaddress"/></td>
              </tr>
              <tr>
                <td align="right">公司电话：</td>
                <td><ww:property value="customeragent.agenttel"/></td>
      
              </tr>
              <tr>
                <td align="right">公司网址：</td>
                <td><ww:property value="customeragent.website"/></td>
              
              </tr>
              <tr>
                <td align="right">邮编：</td>
                <td><ww:property value="customeragent.agentpostcode"/></td>
              </tr>
            </table>
            <div class="biaoti">联系人信息</div>
           <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table">
              <tr>
                <td align="right"   width="85">业务联系人：</td>
                <td width="200">
               <ww:property value="customeragent.agentcontactname"/></td>
              </tr>
              <tr>
                <td align="right">工作电话：</td>
                <td><ww:property value="customeragent.agentphone" /></td>
              </tr>
              <tr>
                <td align="right">个人移动电话：</td>
                <td><ww:property value="customeragent.agentmobile" /></td>
              </tr>
              <tr>
                <td align="right">传真：</td>
                <td><ww:property value="customeragent.agenrfax"/></td>
              </tr>
              <tr>
                <td align="right">电子邮件：</td>
                <td><ww:property value="customeragent.agentemail"  /></td>
              </tr>
              <tr>
                <td align="right">MSN或QQ：</td>
                <td><ww:property value="customeragent.msnqq"  /></td>
              </tr>
	</td>
	</tr>
</table>
</body>
</html>






