<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>B2B2C电子商务</title>
<link href="../css/base.css" rel="stylesheet" />
<link href="../style/bass.css" type="text/css" rel="stylesheet" />
<link href="../style/hotel.css" type="text/css" rel="stylesheet" />
<link href="../style/font.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/validate/jquery.js"></script>
</head>
<body>
<table width="99%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="99%" height="29" class="box-bottom bg"><span class="font-blue-cu">&nbsp;提交预订单</span></td>
  </tr>
  <tr>
  	<td>
  		<table  width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
  			<tr>
  				<td>
  					<table width="100%" border="0" class="border-grey" align="center" cellpadding="0" cellspacing="0">
          				<tr>
            				<td height="48" class="font-grey4" align="center">
            					您的预订已经成功！  
            				</td>
         				</tr>
        			</table>
  				</td>
  			</tr>
       </table>
  	</td>
  </tr>
  <tr>
     <td height="26" background="images/daohang-zhong.gif"><span class="font-grey4">&nbsp;预订信息</span><span class="font-huise">—订单号：<ww:property value="hotelorder.orderid"/></span></td>
  </tr>
  <tr>
  	<td>
  		<table  width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
  			<tr>
  				<td>
					<table width="100%" class="border-grey" border="0" cellspacing="0" cellpadding="0">
	              		<tr>
			                <td width="100%" height="88">
			                	<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#a0cfee" style="border-collapse:collapse" >
			                  		<tr align="center" bgcolor="#d9e7ea" class="font-grey4">
					                    <th width="161" height="28">酒店名称</th>
					                    <th width="204">住店日期</th>
					                    <th width="127">预订间数</th>
					                    <th width="87">房型</th>
					                    <th width="175">付款方式</th>
					                    <th width="175">每日均价</th>
			                  		</tr>
				                  	<tr align="center" class="font-huise">
					                    <td height="28"><ww:property value="hotelorder.name"/></td>
					                    <td><ww:property value="formatDate(hotelorder.comedate)"/>&nbsp;至&nbsp;<ww:property value="formatDate(hotelorder.leavedate)"/></td>
					                    <td><ww:property value="hotelorder.prerooms"/>间</td>
					                    <td><ww:property value="hotelorder.roomtypename"/></td>
					                    <td>前台现付</td>
					                    <td>RBM&nbsp; <ww:property value="formatMoney(getAveragePrice(hotelorder.price))"/>/间</td>
				                  	</tr>
			                	</table>
			              </td>
	              	  </tr>
              		  <tr>
                		<td height="52" class="font-huise2">
                			<table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#a0cfee" style="border-collapse:collapse" >
			                  <tr class="font-grey4"  bgcolor="#d9e7ea" align="center">
			                    <th width="155" height="28">入住人</th>
			                    <th width="191">联系人</th>
			                    <th width="207">确认方式</th>
			                    <th width="164">联系电话</th>
			                    <th width="171">总金额</th>
			                  </tr>
                  			 <tr align="center">
			                    <td height="28"><ww:iterator value="guests" status="guessStatus"><ww:property value="name"/><ww:if test="!#guessStatus.last">，</ww:if></ww:iterator></td>
			                    <td><ww:property value="hotelorder.linkname" /></td>
			                    <td class="font-huise"><ww:if test="hotelorder.confirmmethod == 1">短信确认</ww:if><ww:elseif test="hotelorder.confirmmethod == 2">Email确认</ww:elseif><ww:elseif test="hotelorder.confirmmethod == 3">短信和Email确认</ww:elseif></td>
			                    <td><ww:property value="hotelorder.linkmobile" /></td>
			                    <td><span class="font-chense-cu">&nbsp;&nbsp;RMB <ww:property value="getAllPrice(hotelorder.price, hotelorder.prerooms)" /></span><span class="font-huise">&nbsp;(共<ww:property value="hotelorder.prerooms"/>间)</span></td>
                  			</tr>
                		  </table>
                	   </td>
              		</tr>
              	</table>
  			  </td>
  			</tr>
  			<tr>
  				<td><div style="margin: 0 auto; margin-top: 15px; text-align: center;">
    <input	name="" type="button" class="button108" value="预订机票" style="margin-right: 40px;" onclick="golink('../login!setorderuserlogin.action?orderuserid=<ww:property value="temporderuserid"/>&forword=1');" />
    <input	name="" type="button" class="button108" value="旅游预订" style="margin-right: 40px;" onclick="golink('../login!setorderuserlogin.action?orderuserid=<ww:property value="temporderuserid"/>&forword=3');" />
	</div>
	<div style="height: 10px;line-height: 10px;"></div></td>
  			</tr>
       </table>
  	</td>
  </tr>
 </table>
</body>

</html>
<script>
function golink(i)
{
	window.location=i;
}
</script>



