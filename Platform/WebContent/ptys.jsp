<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page import="java.util.*;"%>
<%
	String abspath="http://"+request.getServerName() +":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>温州苍南遨旅票务商旅系统-平台优势</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script language="javascript">
    var openerIsIndex=false;
	try{
		openerIsIndex=opener.isIndex();
	}catch(e){}
	if(opener!=null && !openerIsIndex){
		opener.top.location="<%=abspath+"index.jsp"%>";
		window.close();
	}else if(top!=self){
		top.location="<%=abspath+"index.jsp"%>";
	}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validator.js"></script>

</head>

<body>
<div id="other">
  <div class="top" ><img src="newimages/ys_top.gif" width="1002" height="99" border="0" usemap="#Map" />
    <map name="Map" id="Map">
      <area shape="rect" coords="276,36,370,63" href="index.jsp" />
      <area shape="rect" coords="661,43,729,58" href="jiamengshang.jsp" />
      <area shape="rect" coords="773,43,843,57" href="gygl.jsp" />
      <area shape="rect" coords="882,42,940,57" href="ptys.jsp" />
      <area shape="rect" coords="824,11,880,26" href="#" />
      <area shape="rect" coords="914,12,972,26" href="fwxy.jsp" />
    </map>
    <div class="logo"><img src="images/${dns.logologinsrc}" width="110" height="97" /> </div> 
  </div>
  <div>
     <div class="left f">
       <ww:include page="login.jsp"></ww:include>
     </div>
      <div class="r right_n">
           <h1 class="h1">遨旅航空机票直销平台优势</h1>
           <div>
             <div style="height:600px; overflow:auto; line-height:24px;">
               <div >
                 <p >（1）交易成本业内最低<br />
                   &nbsp;&nbsp;&nbsp;遨旅航空直销平台是与中国领先的支付公司支付宝合作，我们充分考虑到B2B交易成本的重要性及供应商及时回收资金的迫切性，我们创新设计了&#8220;帐户交易&#8221;的商业模式，减少不必要的网关支付的交易成本，使交易成本降到最低，&nbsp;我们还将不断致力于创造更新的商业模式及技术解决方案，使交易资金安全的前提下，不断降低交易成本。 </p>
                 <p >（2）技术最领先<br />
                   &nbsp;&nbsp;&nbsp;遨旅航空直销平台作为国内技术最领先的btob&nbsp;电子客票平台，拥有一支专业的的技术团队，全力打造让用户交易方便、快捷、安全的平台。 </p>
                 <p >（3）实现效益最大化 </p>
                 <p >&nbsp;&nbsp;&nbsp;&nbsp;遨旅航空直销平台实现了实时航班查询、网上实时订位，在线付款，在线自动出票、同行管理等等功能。交易全程无需人工干预，为您节省人员成本和交易。<br />
                   （4）客户利益保障 </p>
                 <p >为供应商、分销商提供专业的在线交易平台，绝对保证客户信息不被泄露；本身不直接面向终端客户，不销售机票，保证不抢供应商与分销商的客户资源。 </p>
                 <p >（5）交易费定价合理 </p>
                 <p >交易成功后才收取少量的系统交易费，不成功则不产生任何费用，保证供应商的基本利益。 </p>
                 <p >（6）专业客户服务团队 </p>
                 <p >平台所有分销商、供应商都有客服专员提供服务，真正实现一对一专人服务。 </p>
                 <p >成为遨旅航空商旅平台核心合作伙伴的好处<br />
                  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;1.拥有全国性各地合作伙伴本地始发的优惠政策及特价机票资源；<br />
                   &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;2.通过平台让核心合作伙伴拥有全国性的渠道分销网络；<br />
                   &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;3.今日.天下通平台合作伙伴可以获得免费或低价建置在线机票分销系统的机会，利用&nbsp;&nbsp;&nbsp;&nbsp;遨旅航空平台航旅分销引擎有效的管理自己的销售渠道&nbsp;，灵活制定返点政策并及时回收资金；<br />
                  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;4.通过&nbsp;遨旅航空商旅平台在电子商务分销上与携程、ELONG同样强大在线分销商站在同一起跑线上，获得竞争力；<br />
                  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 5.降低运营成本，减少一次投入电子商务风险；<br />
                  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 6.更多的航旅产品分销资源。<br />
                 </p>
                 <p > </p>
               </div>
             </div>
           </div>
     </div>
     <div class="c"></div>
  </div>  
 <div class="botm">
  <ww:include page="loginbottom.jsp"/>
  </div>
</div>
</body>
</html>
