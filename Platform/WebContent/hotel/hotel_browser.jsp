<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>B2B2C电子商务</title>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validate/jquery.js"></script>
<script language="JavaScript">
	function hotel_return_book() {
		window.history.back();
	}
</script>
</head>
<body>
<form action="hotelbook!dobook.action" method="post" name="check_order_form">
<input type="hidden" name="hotelid" value="<ww:property value="hotelorder.hotelid"/>" />
<input type="hidden" name="roomid" value="<ww:property value="hotelorder.roomid"/>" />
<input type="hidden" name="prerooms" value="<ww:property value="hotelorder.prerooms"/>" />
<input type="hidden" name="price" value="<ww:property value="h_perprices"/>" />
<input type="hidden" name="startDate" value="<ww:property value="startDate"/>" />
<input type="hidden" name="endDate" value="<ww:property value="endDate"/>" />
<input type="hidden" name="h_savestarttime" value="<ww:property value="h_savestarttime"/>" />
<input type="hidden" name="h_saveendtime" value="<ww:property value="h_saveendtime"/>" />
<ww:iterator value="h_guest" status="h_guestStatus">
<input type="hidden" name="h_guest" value="<ww:property />" />
</ww:iterator>
<input type="hidden" name="linkname" value="<ww:property value="hotelorder.linkname"/>" />
<input type="hidden" name="memberid" value="<ww:property value="hotelorder.memberid"/>" />
<input type="hidden" name="linkmobile" value="<ww:property value="hotelorder.linkmobile"/>" />
<input type="hidden" name="linkmail" value="<ww:property value="hotelorder.linkmail"/>" />
<input type="hidden" name="linktell" value="<ww:property value="hotelorder.linktell"/>" />
<input type="hidden" name="confirmmethod" value="<ww:property value="hotelorder.confirmmethod"/>" />
<input type="hidden" name="specreq" value="<ww:property value="hotelorder.specreq"/>" />
<input type="hidden" name="predesc" value="<ww:property value="hotelorder.predesc"/>" />
<input type="hidden" name="h_perprices" value="<ww:property value="h_perprices"/>" />

<table width="99%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="99%" height="29" class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;核对预订单信息</span></td>
  </tr>
  <tr>
  	<td>
  		<table  width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="169" valign="top">
            	<table width="99%" class="border-grey" border="0" cellspacing="0" cellpadding="0">
              		<tr>
		                <td height="88">
		                	<table  border="1" width="99%" align="center" cellpadding="0" cellspacing="0" bordercolor="#a0cfee" style="border-collapse:collapse" >
			                  <tr bgcolor="#d7e9fc" align="center">
			                    <th width="161" height="28">酒店名称</th>
			                    <th width="204">住店日期</th>
			                    <th width="127">预订间数</th>
			                    <th width="87">房型</th>
			                    <th width="175">付款方式</th>
			                    <th width="175">每日均价</th>
			                  </tr>
                  			  <tr align="center" class="font-huise">
                    			<td height="28"><ww:property value="hotel.name" /></td>
                    			<td><ww:property value="startDate" />&nbsp;至&nbsp;<ww:property value="endDate" /></td>
                    			<td><ww:property value="hotelorder.prerooms"/>间</td>
                    			<td><ww:property value="roomtype.name" /></td>
                    			<td>前台现付</td>
                    			<td>RBM&nbsp;<ww:property value="getAveragePrice(h_perprices)"/>/间</td>
                  			  </tr>
                			</table>
                		</td>
                	</tr>
                	<tr>
                		<td>
                			<table width="99%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#a0cfee" style="border-collapse:collapse" >
			                  <tr bgcolor="#d7e9fc" align="center">
			                    <th width="155" height="28">入住人</th>
			                    <th width="191">联系人</th>
			                    <th width="207">确认方式</th>
			                    <th width="164">联系电话</th>
			                    <th width="171">总金额</th>
			                  </tr>
			                  <tr align="center">
			                    <td height="28"><ww:iterator value="h_guest" status="h_guestStatus"><ww:if test="#h_guestStatus.index != 0">,</ww:if><ww:property /></ww:iterator></td>
			                    <td><ww:property value="hotelorder.linkname" /></td>
			                    <td class="font-huise"><ww:if test="hotelorder.confirmmethod == 1">短信确认</ww:if><ww:elseif test="hotelorder.confirmmethod == 2">Email确认</ww:elseif><ww:elseif test="hotelorder.confirmmethod == 3">短信和Email确认</ww:elseif></td>
			                    <td><ww:property value="hotelorder.linkmobile" /></td>
			                    <td><span class="font-chense-cu">&nbsp;&nbsp;RMB <ww:property value="getAllPrice(h_perprices,hotelorder.prerooms)"/></span><span class="font-huise">&nbsp;</span></td>
			                  </tr>
		                	</table>
		                </td>
                	</tr>
                	<tr>
				        <td height="58" colspan="3" align="center"><table width="300" border="0" align="center" cellpadding="0" cellspacing="0">
				              <tr>
				                <td width="150" align="center">
				                  <label>
				                  <input name="button" type="button" class="button_d font-white" onclick="hotel_return_book()" id="button" value="上一步" />
				                  </label></td>
				                <td width="150" align="center"><input name="button2" type="submit" class="button_d font-white" id="button2" value="提交订单" /></td>
				              </tr>
				          </table></td>
				    </tr>
                </table>
              </td>
          </tr>
       </table>
  	</td>
  </tr>
 </table>
</form>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
