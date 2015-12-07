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
<html>
<head>
<title>酒店价格搜索</title>
</head>
<body>
<form name="form1" method="post" action="hotelprice!searchprice.action" >
<table width="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td width="284" height="9"><p>酒店：<ww:property value="hotel.name" />
    </p></td>
    <td width="38" height="9">房型：</td>
    <td width="1070"><select name="roomtype">
              <option>经济型</option>
              <option>豪华型</option>
          
        </select></td>
  </tr>
  <tr>
    <td height="9" colspan="3">&nbsp;</td>
  </tr>
  <tr class="font-blue-xi">
    <td height="21" colspan="3" align="top"><p align="left">年月*
      <select name="datenumber">
              <option value="1">1</option>
              <option value="2">2 </option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option>8</option>
              <option>9</option>
              <option>10</option>
              <option>11</option>
              <option>12</option>
        </select>
                        <input name="submit" type="submit" class="button" value="查询"/></p>
    </td>
  </tr>
</table>
</form>
</body>
</html>
