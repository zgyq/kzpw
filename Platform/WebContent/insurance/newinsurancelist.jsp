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
       <li class="offwu"><a href="ddlist.html" target="mainFrame">订单管理</a></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">订单管理</font>&nbsp;&nbsp;<font class="font-666"></font></td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div class="h8">&nbsp;</div>
        <form action="insurance!selectOrder.action" method="post">
      <table width="96%" height="126" border="1" cellpadding="0" cellspacing="0"  bordercolor="#8ab4d2" class="font-69f yin" >
          <tr>                                                          
            <td width="10%" align="center" class="table_yin" >订单创建日期：</td>
            <td width="40%" class="table_wu"><input type="text"  class="Wdate" onfocus="WdatePicker()" name="begintime" value="<ww:property value="begintime"/>"/>-<input type="text"  class="Wdate" onfocus="WdatePicker()" name="begintime1" value="<ww:property value="begintime1"/>"/></td>
            <td  align="center" class="table_yin">订单状态：</td>
            <td  class="table_wu"><select name="inorder.status"><option value="">全部</option><option value="1">待支付</option><option value="2">已支付</option><option value="3">创建失败</option></select></td>
          </tr>
          <tr>                                                          
            <td  align="center" class="table_yin">订单号：</td>
            <td  class="table_wu" colspan="3"><input type="text" name="inorder.orderno"/></td>
           
          </tr>
		   <tr>                                                          
            <td width="23%" height="40"  colspan="4" align="center"> <input type="submit" class="button_sea mr18" value="查询"/> <input type="reset" class="button_sea mr18" value="重置"/></td>
          </tr>
        </table>
        </form>
        <div class="h8">&nbsp;</div>

      </div>
      <div class="sea box_hui">
      <form action="" name="form1" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="taitou" >
          <tr>
            <td width="20" ><img src="skin/blue/images/ico_piaopkuan.gif" width="20" height="20" /> </td>
            <td align="left">常规订单</td>
            <td>&nbsp;</td>
          </tr>
        </table>

        <table width="96%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao center">
          <tbody>
            <th scope="col"><div class="thleft">订单号</div></th>
            <th scope="col"><div class="thleft">保险份数</div></th>
            <th scope="col"><div class="thleft">总金额</div></th>
            <th scope="col"><div class="thleft">订单状态</div></th>
            <th scope="col"><div class="thleft">操作</div></th>
            </tbody>
          <ww:iterator value="orderlist">
          <tr>
            <td><ww:property value="liushuno"/></td>
            <td><ww:property value="insurantcount"/></td>
            <td><ww:property value="totalmoney"/></td>
            <td><ww:if test="status==1">未支付</ww:if><ww:if test="status==2">已支付</ww:if><ww:if test="status==3">创建失败</ww:if></td>
            <td>
            <input type="button" class="button_sea mr18" value="立即支付" onclick="window.location.href='insurance!payInsurOrder.action?oid=<ww:property value="id"/>'"/><br/>
            <input type="button" class="button_sea mr18" value="查看详情" onclick="window.location.href='insurance!getInsuranceByid.action?oid=<ww:property value="id"/>'"/>
            </td>
          </tr>
          </ww:iterator>
          <tr><td colspan="7"><ww:property
			value='getPagetwo(pageinfo,"pageinfo","insurance!selectOrder.action","form1")' /></td></tr>
          </table>
          </form>
        <div class="h8">&nbsp;</div>

      </div>
        <div class="h8">&nbsp;</div>

      
    </div>
</div>
</body>
</html>
