<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店订单列表</title>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/validator.js"></script>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>
<body>

<form name="form1" method="post" action="hotelordersearch.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店订单列表</span></td>
  </tr>
  
      <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc"  height="25">
                  <th>订单号</th>
                  <th>酒店名称</th>
                  <th>房型名称</th>
                  <th>预订间数</th>
                  <th>入住日期</th>
                  <th>离店日期</th>
                  <th>联系人姓名</th>
                  <th>入住人</th>
                  <th>间夜</th>
                  <th>订单状态</th>
                  <th>订单总价</th>
			  </tr>

		<ww:iterator value="listHotelorder">
	      <tr align="center"  height="20"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
           <td><ww:property value="orderid"/>	</td>
           <td><ww:property value="name"/></td>
           <td><ww:property value="roomtypename"/></td>
           <td><ww:property value="prerooms"/></td>
           <td><ww:property value="formatDate(comedate)"/></td>
           <td><ww:property value="formatDate(leavedate)"/></td>
           <td><ww:property value="linkname"/></td>
           <td><ww:property value="getruzhu(id)"/></td>
           <td><ww:property value="manyday"/></td>
           <td><ww:property value="getHotelorderState(state)"/></td>
           <td><ww:property value="price"/></td>	
	</tr>
	</ww:iterator>
		   <td> <ww:property value="r_sum" /></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td></td>
           <td><ww:property value="jianye"/></td>
           <td></td>
           <td><!--
           <ww:property value="zongjia"/>
           -->
         <ww:property value="r_hotelprice" />
           </td>	
           </tbody>
            </table></td>
          </tr>
          <tr>
          
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>





