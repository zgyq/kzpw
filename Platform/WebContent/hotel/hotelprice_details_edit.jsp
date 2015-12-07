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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>批量锁定酒店价格</title>

<style type="text/css">
<!--
.STYLE2 {font-size: 12}
-->
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<script type="text/javascript" src="../js/validator.js"></script>
<body>


<form action="" method="get">
  <p>酒店名称： <ww:property value='hotel.name' /> 房型：<input type="hidden" name="hotelprice.roomid" vlaue="<ww:property value='roomtype.id'/>" /> <ww:property value='roomtype.name' /></p>
  <p>年月： <ww:property value='hotelprice.datenumber' /></p>
  <p>酒店价格 <input type="hidden" name="hotelprice.id" vlaue="<ww:property value='hotelprice.id'/>" /></p>
  <table width="100%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td>no1;</td>
    <td>no2;</td>
    <td>no3;</td>
    <td>no4;</td>
    <td>no5</td>
    <td>no6</td>
    <td>no7</td>
    <td>no8</td>
    <td>no9</td>
    <td>no10</td>
    <td>no11</td>
    <td>no12</td>
    <td>no13</td>
    <td>no14</td>
    <td>no15</td>
    <td>no16</td>
    <td>no17</td>
    <td>no18</td>
    <td>no19</td>
    <td>no20</td>
    <td>no21</td>
    <td>no22</td>
    <td>no23</td>
    <td>no24</td>
    <td>no25</td>
    <td>no26</td>
    <td>no27</td>
    <td>no28</td>
    <td>no29</td>
    <td>no30</td>
  </tr>
  <tr>
    <td><ww:property value="hotelprice.no1" /></td>
    <td><ww:property value="hotelprice.no2" /></td>
    <td><ww:property value="hotelprice.no3" /></td>
    <td><ww:property value="hotelprice.no4" /></td>
    <td><ww:property value="hotelprice.no5" /></td>
    <td><ww:property value="hotelprice.no6" /></td>
    <td><ww:property value="hotelprice.no7" /></td>
    <td><ww:property value="hotelprice.no8" /></td>
    <td><ww:property value="hotelprice.no9" /></td>
    <td><ww:property value="hotelprice.no10" /></td>
    <td><ww:property value="hotelprice.no11" /></td>
    <td><ww:property value="hotelprice.no12" /></td>
    <td><ww:property value="hotelprice.no13" /></td>
    <td><ww:property value="hotelprice.no14" /></td>
    <td><ww:property value="hotelprice.no15" /></td>
    <td><ww:property value="hotelprice.no16" /></td>
    <td><ww:property value="hotelprice.no17" /></td>
    <td><ww:property value="hotelprice.no18" /></td>
    <td><ww:property value="hotelprice.no19" /></td>
    <td><ww:property value="hotelprice.no20" /></td>
    <td><ww:property value="hotelprice.no21" /></td>
    <td><ww:property value="hotelprice.no22" /></td>
    <td><ww:property value="hotelprice.no23" /></td>
    <td><ww:property value="hotelprice.no24" /></td>
    <td><ww:property value="hotelprice.no25" /></td>
    <td><ww:property value="hotelprice.no26" /></td>
    <td><ww:property value="hotelprice.no27" /></td>
    <td><ww:property value="hotelprice.no28" /></td>
    <td><ww:property value="hotelprice.no29" /></td>
    <td><ww:property value="hotelprice.no30" /></td>
  </tr>
</table>

  <div align="center"><a href="hotelprice!tobatchlock.action?hotel.id=<ww:property value='hotel.id'/>&hotelprice.roomid=<ww:property value='hotelprice.roomid'/>&hotelprice.id=<ww:property value='hotelprice.id'/>">批量禁用价格</a> <a href="hotelprice!toqiyong.action?hotel.id=<ww:property value='hotel.id'/>&hotelprice.roomid=<ww:property value='hotelprice.roomid'/>">批量启用价格</a> <a href="hotelprice!toyanqi.action?hotel.id=<ww:property value='hotel.id'/>&hotelprice.roomid=<ww:property value='hotelprice.roomid'/>"> 价格延期 </a>   </div>
</form>
</body>
</html>