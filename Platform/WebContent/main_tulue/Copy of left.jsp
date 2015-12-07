<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="css/left.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
<div id="wrap">
<div class="left">
  <ul>
     <li>
          <a href="#" class="btn"><span class="s-icon"></span>采购火车票 <span class="opens"></span></a>
          <ul>
              <li><a href="login!towelcome.action" target="member">火车票预订</a></li> 
          </ul>

     </li>
      <li>
         <a href="#" class="btn"><span class="s-icon"></span>火车票订单管理<span class="opens"></span></a>
          <ul>
              <li><a href="../train!trainorder.action" target="member">所有订单查询</a></li>
               <li><a href="../train!trainorder.action?s_orderstatus=1" target="member">待支付订单</a></li>
                <li><a href="../train!trainorder.action?s_orderstatus=2" target="member">待出票订单</a></li>
              <li><a href="../train!trainorder.action?s_orderstatus=3" target="member">已出单完成订单</a></li>
              <li><a href="../train!trainorder.action?s_orderstatus=-1" target="member">以取消订单</a></li>       
          </ul>

     </li>
     
     
     <li>
          <a href="#" class="btn"><span class="s-icon"></span>采购机票 <span class="opens"></span></a>
          <ul>
              <li><a href="../b2bair!toTicket.action" target="member">机票预订</a></li> 
              <li><a href="../b2bair!tolisttest.action" target="member">机票列表</a></li> 
          </ul>

     </li>
      <li>
         <a href="#" class="btn"><span class="s-icon"></span>机票订单管理<span class="opens"></span></a>
          <ul>
              <li><a href="../b2bticketorder.action" target="member">所有订单查询</a></li>
          </ul>

     </li>
     
     
     <li>
         <a href="#" class="btn"><span class="s-icon"></span>退票订单管理 <span class="opens"></span></a>
          <ul>
              <li><a href="../train!trainorder.action?s_orderstatus=4" target="member">申请退票订单</a></li>
              <li><a href="../train!trainorder.action?s_orderstatus=7" target="member">申请改签订单</a></li>
              <li><a href="../train!trainorder.action?s_orderstatus=5" target="member">已退票订单</a></li> 
              <li><a href="../train!trainorder.action?s_orderstatus=6" target="member">退票失败订单</a></li> 
                
          </ul>

     </li>
     
     
      <li>
         <a href="#" class="btn"><span class="s-icon"></span>配送收银订单管理 <span class="closes"></span></a>
          <ul class="close">
              <li><a href="../train!trainorder.action" target="member">代配送订单</a></li>
              <li><a href="../train!trainorder.action" target="member">待收银订单</a></li>
              <li><a href="../train!trainorder.action" target="member">在途订单</a></li>       
          </ul>

     </li>
     
     
  
  </ul>

  
</div>

</div>

</body>
</html>
