<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="skin/blue/css/left.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/public.css" type="text/css" rel="stylesheet" />
<link href="skin/blue/css/main.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>

<body >
<div  id="right" >
    <div class="lit">
      <ul>
       <li class="offwu"><a href="ddlist.html" target="mainFrame">保险单查询</a></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
      <div class="sea box_hui">
      <form action="insurance!selectInsurance.action" method="post" name="form1">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">所有保险单管理</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>
      <table width="96%" height="126" border="1" cellpadding="0" cellspacing="0"  bordercolor="#8ab4d2" class="font-69f yin" >
          <tr>                                                          
            
            <td width="10%" align="center" class="table_yin">保险单号：</td>
            <td width="40%" class="table_wu"><input type="text" name="inusers.policyno"></td>
            <td width="10%" align="center" class="table_yin" >起保时间：</td>
            <td width="40%" class="table_wu"><input type="text" class="Wdate" onFocus="WdatePicker()" name="begintime" value="<ww:property value="begintime"/>"/>-<input type="text" class="Wdate" onFocus="WdatePicker()" name="begintime1" value="<ww:property value="begintime1"/>"/></td>
          </tr>
          <tr>                                                          
            <td align="center" class="table_yin">被保人姓名：</td>
            <td  class="table_wu"><input type="text" name="inusers.name"/></td>
            <td  align="center" class="table_yin">航班号：</td>
            <td  class="table_wu"><input type="text" name="inusers.flyno"/></td>
          </tr>                                                           
            <td height="40"  colspan="4" align="center"> <input type="submit" class="button_sea mr18" value="查询"/> <input type="reset" class="button_sea mr18" value="重置"/></td>
          </tr>
        </table>
        </form>
        <div class="h8">&nbsp;</div>

      </div>
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_piaopkuan.gif" width="20" height="20" /> </td>
            <td align="left">保险单</td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
          <tbody>
            <th scope="col"><div class="thleft">保险单号</div></th>
            <th scope="col"><div class="thleft">被保人姓名</div></th>
            <th scope="col"><div class="thleft">证件号码</div></th>
            <th scope="col"><div class="thleft">航班号</div></th>
            <th scope="col"><div class="thleft">起保时间</div></th>
            <th scope="col"><div class="thleft">联系方式</div></th>
            <th scope="col"><div class="thleft">电子邮箱</div></th>

            </tbody>
          <ww:iterator value="userslist">
          <tr>
            <td><ww:property value="policyno"/></td>
            <td><ww:property value="name"/></td>
            <td><ww:property value="code"/></td>
            <td><ww:property value="flyno"/></td>
            <td><ww:property value="begintime"/></td>
            <td><ww:property value="mobile"/></td>
            <td><ww:property value="email"/></td>
            
          </tr>
          </ww:iterator>
          <tr><td colspan="8"><ww:property
			value='getPagetwo(pageinfo,"pageinfo","insurance!selectInsurance.action","form1")' /></td></tr>
          </table>
        <div class="h8">&nbsp;</div>

      </div>
    <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_piaopkuan.gif" width="20" height="20" /> </td>
            <td align="left"><font class="font16-f90">保单温馨提示</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
        
         <tr>
            <td align="left">保单验证： <a href="http://www.hzins.com/search/insurance/">http://www.hzins.com/search/insurance/</a></td>                                            
          </tr>
           <tr>
            <td align="left">电子保单下载：<a href="http://www.hzins.com/search/insurance/insdownload.aspx">http://www.hzins.com/search/insurance/insdownload.aspx</a></td>                                            
          </tr>
          </table>
        <div class="h8">&nbsp;</div>
    </div>

</body>
</html>
