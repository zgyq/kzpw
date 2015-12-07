<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
    <link href="../css/base.css" rel="stylesheet" />
<style>
td{ padding-left:5px; padding-right:5px;}
</style>
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29"  class="box-bottom bg" ><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;传真</span></td>
  </tr>
  <tr>
    <td height="445" valign="top">

<form action="hotelwholeorder!chuanzhen.action" name="form1" method="POST" >
<table border="1" cellpadding="0" cellspacing="0"  bordercolor="#a0cfee" style="line-height:24px; font-size:12px; width: 98%; border-collapse: collapse; margin: 0 auto; margin-top: 10px;">

  <tr>
    <td align="right" bgcolor="#DDECF3"> 收件人<br /></td>
    <td><input type="text" name="rname" value="<ww:property value="hotel.name"/>" /></td>
        <td align="right"  bgcolor="#DDECF3">发件人</td>
    <td><input type="text" name="sname"  value="${dns.companyname}" /></td>
  </tr>
  <tr>
    <td align="right"  bgcolor="#DDECF3">收件人电话</td>
    <td><input type="text" name="rphone" value="<ww:property value="hotel.tortell"/>" /> </td>
            <td align="right"  bgcolor="#DDECF3">发件人电话</td>
    <td><input type="text" name="sphone"  value="" /></td>
  </tr>
  <tr>
    <td align="right"  bgcolor="#DDECF3">收件人传真</td>
    <td><input type="text" name="rfax"  value="<ww:property value="hotel.fax1"/>" /></td>
        <td align="right"  bgcolor="#DDECF3">发件人传真</td>
    <td><input type="text" name="sfax"  value="" /></td>
  </tr>




  <tr>
    <td align="right"  bgcolor="#DDECF3">日期</td>
    <td><input type="text" name="senddate"  value="<ww:property value="getDatestr(0)"/>" /></td>
        <td align="right"  bgcolor="#DDECF3">入住酒店名称</td>
    <td><input type="text" name="hotelname"  value="<ww:property value="hotel.name"/>" /></td>
  </tr>

  <tr>
    <td align="right"  bgcolor="#DDECF3">客人国籍</td>
    <td><input type="text" name="countty"  value="中国" /></td>
        <td align="right"  bgcolor="#DDECF3">人数</td>
    <td><input type="text" name="peoplenum"  value="<ww:property value="hotelorder.orderpeaple"/>" /></td>
  </tr>

  <tr>
    <td align="right"  bgcolor="#DDECF3">单号</td>
    <td><input type="text"  name="order" value="<ww:property value="hotelorder.orderid"/>" /></td>
        <td align="right"  bgcolor="#DDECF3">客人姓名/团号</td>
    <td><input type="text" name="name"  value="<ww:property value="guestname"/>" /></td>
  </tr>

  <tr>
    <td align="right"  bgcolor="#DDECF3">入住日期</td>
    <td><input type="text" name="begindate"  value="<ww:property value="formatDate(hotelorder.comedate)"/>" /></td>
        <td align="right"  bgcolor="#DDECF3">离店日期</td>
    <td><input type="text" name="enddate"  value="<ww:property value="hotelorder.leavedate"/>" /></td>
  </tr>

  <tr>
    <td align="right"  bgcolor="#DDECF3">房型房数</td>
    <td><input type="text" name="roommun"  value="<ww:property value="hotelorder.prerooms"/>间<ww:property value="hotelorder.roomtypename"/>" /></td>
     <td align="right"  bgcolor="#DDECF3">房价单价</td>
    <td><input type="text" name="dateprice"  value="<ww:property value="hotelorder.dayprice"/>" /></td>
  </tr>
  <tr>
    <td align="right"  bgcolor="#DDECF3">早餐</td>
    <td><input type="text" name="breakfast"  value="" /></td>
        <td align="right"  bgcolor="#DDECF3">特殊要求</td>
    <td><input type="text" name="content"  value="<ww:property value="hotelorder.specreq"/>" /></td>
  </tr>

  <tr>
    <td align="right"  bgcolor="#DDECF3">付款方式</td>
    <td><input type="text" name="paymoney"  value="现付" /></td>
        <td align="right"  bgcolor="#DDECF3">制单人</td>
    <td><input type="text" name="makename"  value="" /></td>
    <input type="hidden" name="ordid"  value="<ww:property value="ordid"/>" />
    <input type="hidden" name="sta"  value="<ww:property value="sta"/>" />
  </tr>
<tr><td colspan="4" height="50" align="center"><input type="submit" class="button_d font-white" style="margin-right: 40px;"  name="Sub" value="确认" /> <input type="button" class="button_d font-white" onclick="window.history.back()"  name="Submit2" value=" 返回上一级 " /> </td></tr>
</table>


 
   
</form>
</td></tr></table>
</body>
</html>
