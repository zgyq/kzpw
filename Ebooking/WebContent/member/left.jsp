<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>



<%
String ty = request.getParameter("ty");
%>

<div class="left box_member mt10 f">
      <ul>
        <li class="basic"><span class="ico_basic f">&nbsp;</span><font class="black f">基本信息</font>&nbsp;</li>
        <li class="left_list"><a href="login!toMyCenter.jspx">个人信息</a></li>
        <li class="left_list"><a href="login!toChangePassword.jspx">修改密码</a></li>
        <!--
		<li class="left_list"><a href="login!toPassenger.jspx">常用乘机人</a></li>
		 -->
        
        <li class="left_list"><a href="login!toAddress.jspx">常用配送地址</a></li>
        <li class="left_list"><a href="login!toAddAddress.jspx">添加配送地址</a></li>
        <!--
        <li class="left_list" style="color: red"><b><a href="login!ToRegsitOK.jspx">我要抽奖</a></b></li>
        -->
        <li class="order"><span class="ico_order f">&nbsp;</span><font class="black f">订单中心</font>&nbsp;</li>
         <li class="left_list"><a href="login!toHotelOrder.jspx">国内酒店订单</a></li>
         <li class="left_list"><a href="login!toTicktOrder.jspx">国内机票订单</a></li>
         <li class="left_list"><a href="login!toSpotTicketOrder.jspx">旅游门票订单</a></li>
         <li class="left_list"><a href="login!toSpotLineOrder.jspx">旅游线路订单</a></li>
         <li class="left_list"><a href="login!toTrainOrder.jspx">火车票订单</a></li>
        <!--
        <li class="left_list"><a href="login!tobuyingOrder.jspx">我的团购订单</a></li>
        <li class="order"><span class="ico_help f">&nbsp;</span><font class="black f">积分管理</font>&nbsp;</li>
        <li class="left_list"><a href="point!toPointRecord.jspx">我的积分</a></li>
        <li class="left_list"><a href="point!toPointsmall.jspx">积分兑换</a></li>
        <li class="left_list"><a href="point!toIntegral.jspx">兑换记录</a></li>
      -->
      </ul>
   </div>