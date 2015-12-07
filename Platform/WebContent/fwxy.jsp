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
<title>温州苍南遨旅票务商旅系统-服务协议</title>
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
  <div class="top" ><img src="newimages/newtop.gif" width="1002" height="99" border="0" usemap="#Map" />
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
           <h1 class="h1">邀旅航空平台服务协议</h1>
           <div>
             <div style="height:600px; overflow:auto; line-height:24px;">
               <div >
                 <p >1、服务条款的确认和接纳 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;本站会员服务条款的所有权和解释权归本站所有。所提供的服务都是按照公司发布的服务条款和操作规则严格执行。用户通过完成注册程序并点击一下&quot;提交&quot;的按钮，这表示用户与本站达成协议并接受所有的服务条款。 </p>
                 <p >2、出票须知 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;旅客在做完预定后请尽快出票(航空公司正常出票规定:航班起飞前7天以前预定,预定后3天内航班起飞7天前出票.航班起飞前7天内3天前,提前3天出票.航班起飞前3天内,随订随售不做保留.座位紧张及节假日除外),以免造成成功预定后因出票不及时而被航空公司自动清仓取消座位带来不必要的损失和麻烦.因旅客支付提交出票不及时而造成的损失有旅客自行负着与本站无关. </p>
                 <p >另出票责任:旅客虽已提交有效预定记录并成功付款,在付款后12分钟内如被航空公司清仓取消的本站不予负责(3天内的航班随时可能清仓取消,处理和出票需要一定时间,所以请旅客尽量提前预定及时支付出票),只能尽量协助旅客减少损失或安排新的航班时间和行程,12分钟以外未出票而造成旅客在票价上的损失由金飞翔天下负责赔偿或安排其它航班直到旅客顺利出行. </p>
                 <p >3、服务条款的说明 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;这些交易条件的条款适用于由本站为您提供的产品销售服务。这些条款将有可能不时的被修正。任何修正条款的发生都会在本站网站即时公布。 </p>
                 <p >4、会员注册须知 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;会员需为18岁以上的自然人，且需持有合法有效的证件。会员注册时应提供完整详实且正确的个人资料，如果需要变更，请随时在本站网上进行。从2003年9月开始，民航局规定购买飞机票时必须提供个人信息（身份证号码、联系电话和住址等），因此，如果您在我们网上注册之后，以后购买飞机票只要输入你的注册号和密码就可以了，省去了你每次购买飞机票时候都必须填写详细信息。 </p>
                 <p >5、错误填写资料纠纷解决问题 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们要求会员必须提供真实乘机人的信息以方便会员搭乘飞机，如果由于会员填写资料发生错误而发生的任何纠纷，会员不得要求本站任何形式的赔偿或补偿。 </p>
                 <p >6、有发生下列情形，本站保留终止会员资格及使用各项服务条款的权利：&nbsp; </p>
                 <p >&nbsp;&nbsp;&nbsp;&nbsp;提供不真实的个人资料或资料有任何误导的嫌疑。&nbsp; </p>
                 <p >&nbsp;&nbsp;&nbsp;&nbsp;使用伪冒或非法取得的信用卡号进行交易。&nbsp; </p>
                 <p >&nbsp;&nbsp;&nbsp;&nbsp;公布或传送任何不实、不雅、不法、诽谤、威胁、猥褻或侵害他人智慧财产的文字、图片。&nbsp; </p>
                 <p >&nbsp;&nbsp;&nbsp;&nbsp;从事违法广告或贩卖不良产品的行为。&nbsp; </p>
                 <p >&nbsp;&nbsp;&nbsp;&nbsp;意图入侵或破坏金飞翔天下网站以及各项服务系统。&nbsp; </p>
                 <p >&nbsp;&nbsp;&nbsp;&nbsp;违反金飞翔天下网站规定、消费者保护法等其他中华人民共和国法律规定。&nbsp; </p>
                 <p >&nbsp;&nbsp;&nbsp;会员如果有不法行为，除会员本身自负法律责任外，我们也会主动配合管机关调查处理，若因此本站受有损害或支出费用，会员要自行负担损失赔偿责任。 </p>
                 <p >7、本站和您之间的契约 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;在向本站打电话或发mail确认收到并接受了您的订单之前，您和本站之间不存在任何契约关系。我们有权在发现了，随意网站上显现的产品及订单的明显错误或缺货的情况下，单方面撤回任何契约，但我们会以您提交的联系方式通知您。同时，金飞翔天下保留对产品订购的数量的限制权。&nbsp;在下订单的同时，您也同时承认了您已经达到购买这些产品的法定年龄，并将对您在订单中提供的所有信息的真实性负责。 </p>
                 <p >8、定价和可获性 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;本站查询数据是直接和中国民航信息网络有限公司系统对接，我们的做法是将所有的机票产品按照原价格完全放在本站网上，因此，我们的机票价格就是最新和最全面的价格。您可以随意从网上查询订购或电话直接订购。我们免费为您送票或您通过网上支付后到机场的对应窗口取票。 </p>
                 <p >9、服务担保条款 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;我们的产品仅仅是分销现成的产品，我们保证我们产品的真实性和合法性，但是我们不会为客户在使用产品过程中所产生的问题（如飞机误点、取消、机场服务质量差以及安全事故等等）提供担保。如您在使用机票或其他产品过程中有任何问题，您可以直接投诉或采取其他法律手段针对生产该产品的生产商，但本站不会承担任何形式的法律责任。 </p>
                 <p >10、关于权利终止问题 </p>
                 <p >　&nbsp;&nbsp;&nbsp;&nbsp;本网站会员申请加入属免费性质，&nbsp;本站保留随时更改或停止所提供各项服务内容，或终止任一会员账户服务的权利，且无需事先告知会员，会员不得因此要求任何补偿或赔偿。 </p>
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
