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
<title>温州苍南遨旅票务商旅系统-供应商管理</title>
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
  <div class="top" ><img src="newimages/gg_top.gif" width="1002" height="99" border="0" usemap="#Map" />
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
           <h1 class="h1">供应商管理条例</h1>
           <div>
             <div style="height:600px; overflow:auto; line-height:24px;">
               <p >供应商管理条例<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(征求意见稿)<br />
                 第一章----总&nbsp;则<br />
                 第一条&nbsp;为了加强对供应商的管理，保障客户的消费权益，促进双方合作的健康发展，制定本条例。<br />
                 第二条&nbsp;本条例适用于为上海古大旅游服务有限公司(以下简称&#8220;遨旅航空直销平台&#8221;)提供全国各地机票优惠政策，通过遨旅航空直销平台电子客票交易平台从事机票销售的机票代理人（以下简称&#8220;供应商&#8221;）。<br />
                 第三条&nbsp;本条例所称机票代理人，是指有营利目的，合法从事机票代理销售的企业。<br />
                 第四条&nbsp;遨旅航空直销平台供应商管理部负责本条例制定、修改、废止起草工作。&nbsp;总经理负责本条例制定、修改、废止之核准。 </p>
               <p >第二章----供应商选择<br />
                 第四条&nbsp;申请供应商，应当具备下列条件：<br />
                 （一）具备合法经营资质的企业。<br />
                 &nbsp;&nbsp;&nbsp;（二）具备中国民航总局或其下属管理局颁发的《航空销售代理业务经营批准证书》&nbsp;。<br />
                 &nbsp;（三）具备国际航协（IATA）颁发的《认可证书》&nbsp;。<br />
                 &nbsp;（四）&nbsp;有符合本条例第五条、第六条规定的注册资本和质量保证金。<br />
                 第五条&nbsp;供应商的注册资本，应当符合下列要求：<br />
                 （一）&nbsp;申请供应商，注册资本不得少于50万元人民币；<br />
                 （二）&nbsp;申请成为地区独家供应商，注册资本不得少于150万元人民币；<br />
                 第六条&nbsp;申请成为供应商，首先向遨旅航空直销平台供应商管理部提出申请；由供应商管理部审核后，报营销中心副总裁审核批准；申请地区独家供应商，上报总经理审核批准。<br />
                 第七条&nbsp;申请成为供应商，应当提交下列资料：<br />
                 &nbsp;（一）&nbsp;遨旅航空直销平台供应商申请表；<br />
                 &nbsp;（二）&nbsp;企业营业执照副本复印件；<br />
                 &nbsp;（三）&nbsp;&lt;航空销售代理业务经营批准证书&gt;复印件；<br />
                 &nbsp;&nbsp;（四）&nbsp;&nbsp;IATA&lt;认可证书&gt;复印件；<br />
                 &nbsp;（五）&nbsp;中航鑫港BSP中心担保文件复印件。<br />
                 第八条&nbsp;供应商管理部门收到申请书后，根据下列原则进行审核：<br />
                 &nbsp;（一）&nbsp;符合遨旅航空直销平台业务发展规划；<br />
                 &nbsp;（二）&nbsp;符合遨旅航空直销平台市场发展需要；<br />
                 &nbsp;（三）&nbsp;具备本条例第四、五、六条规定的条件。供应商管理部门应当自收到申请书之日起5个工作日内，作出批准或者不批准的决定，并通知申请人。<br />
                 第十条&nbsp;供应商申请批准后，签署遨旅航空直销平台、供应商、支付网关《支付宝供应商电子协议》。签署协议后遨旅航空直销平台为供应商开通供应商后台管理系统帐户并建立供应商档案。<br />
                 &nbsp;<br />
                 第三章----供应商管理<br />
                 第九条&nbsp;供应商在合作期间中应当遵循自愿、平等、公平、诚实信用的原则，遵守商业道德。<br />
                 第十条&nbsp;供应商不得采用下列不正当手段从事销售业务，损害遨旅航空直销平台的利益：<br />
                 &nbsp;（一）&nbsp;不可从事与遨旅航空直销平台存在利益冲突的其他产品或服务。<br />
                 （二）&nbsp;未经遨旅航空直销平台书面授权，遨旅航空直销平台供应商不得在任何场合擅自使用遨旅航空直销平台的名称和商标。<br />
                 &nbsp;（三）&nbsp;不得以遨旅航空直销平台名称或其注册商标作为其它任何机构或产品的名称。<br />
                 &nbsp;（四）&nbsp;委托非其他的单位和个人经营遨旅航空直销平台平台业务；<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（五）&nbsp;不得利用遨旅航空直销平台平台的资源从事不通过遨旅航空直销平台平台交易的销售业务；<br />
                 &nbsp;（六）&nbsp;扰乱机票市场秩序的其他行为。<br />
                 第十一条&nbsp;成为遨旅航空直销平台供应商，须遵从以下遨旅航空直销平台供应商服务质量标准：<br />
                 (一)人员配备<br />
                 1.1&nbsp;供应商配备一人及以上专职人员，处理今日&#8226;天下能平台业务。<br />
                 1.2&nbsp;供应商提供有应急联系方式，能处理非正常工作时间的业务。<br />
                 （二）运价维护<br />
                 2.1供应商保证政策的真实有效性。如供应商政策维护出错，客人付款成功后，供应商必须出票。<br />
                 2.2&nbsp;供应商公布在遨旅航空直销平台平台的特殊价格运价，客人一旦付款成功，供应商保障正常出票。如出现差错，由供应商负责解决。<br />
                 2.3供应商负责区域内通航航线的特殊舱位运价(低于4.5折舱位)，若只有3%优惠政策，供应商预留支付成本后发布在遨旅航空直销平台平台。<br />
                 （三）订单处理<br />
                 3.1&nbsp;供应商在____点到____点内正常处理遨旅航空直销平台平台出票、退票、废票、维护政策以及其他相关业务。如服务时间需要延长，供应商应积极配合调整。<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.2处理支付成功的订单时，处理时间在5分钟之内，超过规定时限未出票，导致座位NO状态，由供应商负责解决。<br />
                 （四）废、退票处理<br />
                 4.1在处理退票时，严格按照各航空公司客规处理退款。<br />
                 4.2&nbsp;处理废票订单，当天处理、当天退款。<br />
                 4.3&nbsp;处理退票订单，如是旅客自愿退票，当天处理、当天退款。<br />
                 4.4&nbsp;处理退票订单时，如PNR不能提取，供应商主动恢复PNR或及时与<br />
                 遨旅航空直销平台退票部联系，按恢复记录处理退票。<br />
                 4.5&nbsp;处理退票订单时，如是非自愿退票，记录编码中有UN状态，供应商应直接提交航空公司全退。记录编码中没有UN状态时，供应商主动联系航空公司取得延误或取消证明，为客人保障全退。<br />
                 （五）日常操作<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.1&nbsp;正常工作时间内，保持良好的沟通，碰到一些临时性问题，应及时解决，如不能处理，应向上级反应，以最快速度解决问题。<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;（六）应急问题处理<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.1&nbsp;供应商应最大限度保障票号充足。<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.2&nbsp;供应商如票号断缺，联系遨旅航空直销平台关闭全部政策或部分政策。<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.3&nbsp;供应商如出现断电、断网等情况，应及时通知遨旅航空直销平台，关闭政策。<br />
                 第十二条&nbsp;支付宝、财付通，供应商应提供最少一种支付方式。<br />
                 第十三条&nbsp;供应商变更支付方式必须向遨旅航空直销平台提供变更申请，收到变更原件1个工作日内遨旅航空直销平台作出变更操作。<br />
                 第十四条&nbsp;供应商在以下情形下将终止与遨旅航空直销平台的合作：<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;（一）《遨旅航空直销平台供应商协议》到期；<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;（二）供应商主动提交《供应商退出申请表》；<br />
                 &nbsp;&nbsp;&nbsp;&nbsp;（三）供应商违反《遨旅航空直销平台供应商协议》、《供应商管理条例》等相关协议；<br />
                 第十五条&nbsp;供应商《遨旅航空直销平台供应商协议》到期后120天内遨旅航空直销平台清算支付机票交易尾款和服务质量保证金；协议到期前30天供应商可向遨旅航空直销平台提交《供应商续约申请》，由遨旅航空直销平台供应商管理部报营销副总审核批准，5个工作日内给出批准与不批准，并告知申请人。<br />
                 第十六条&nbsp;供应商提交《供应商退出申请表》，遨旅航空直销平台于半年内清算支付机票交易尾款和服务质量保证金；<br />
                 第十七条&nbsp;因供应商违反相关协议而终止合作，遨旅航空直销平台保留法律起诉的权利；对于供应商违反协议而造成的各种经济损失由供应商一方承担，遨旅航空直销平台有权直接从机票交易款和服务质量保证金中扣除，并在一年内支付剩余尾款；<br />
                 第十八条&nbsp;因供应商违反相关协议而终止合作，供应商可在一个月内向遨旅航空直销平台申请复查和审核，并主动提供相关材料证明。<br />
                 第十九条&nbsp;供应商与遨旅航空直销平台合作终止后，应主动配合遨旅航空直销平台清算工作，对退票、废票、差错补偿等业务及时处理，不得拖延。 </p>
               <p ><br />
                 第四章----供应商评估<br />
                 第二十条&nbsp;遨旅航空直销平台有义务在供应商合作期间对其监督管理，维护平台交易秩序。<br />
                 第二十一条&nbsp;供应商应当按受遨旅航空直销平台对其服务质量、交易安全、机票产品等监督检查。遨旅航空直销平台执行监督职责时，应当形成文字记录并及时联系供应商告知结果。<br />
                 第二十二条&nbsp;遨旅航空直销平台根据以下条件对供应商进行评估：<br />
                 &nbsp;&nbsp;&nbsp;（一）供应商的服务质量（40分）；<br />
                 &nbsp;&nbsp;&nbsp;（二）供应商的企业实力、公司团队状态、公司发展状态（15分）；<br />
                 &nbsp;&nbsp;&nbsp;（三）供应商企业领导对遨旅航空直销平台前景是否看好和支持度（15分）；<br />
                 &nbsp;&nbsp;&nbsp;（四）供应商在遨旅航空直销平台平台的交易量（20分）；<br />
                 &nbsp;&nbsp;&nbsp;（五）供应商所处当地市场的前景（10分）；<br />
                 第二十三条&nbsp;根据供应商评估结果遨旅航空直销平台将供应商分为以下四个等级：<br />
                 （一）&nbsp;首选长期合作的（95分以上）；<br />
                 （二）&nbsp;可接受的（85分-94分）；<br />
                 （三）&nbsp;受限制的（75分-84分）；<br />
                 （四）&nbsp;剔除的；（低于75分）<br />
                 第二十四条&nbsp;遨旅航空直销平台每季度进行一次供应商评估，供应商服务质量由遨旅航空直销平台客服部总结；其他评分由遨旅航空直销平台营销中心报营销副总；供应商剔除报总经理批准。 </p>
               <p >第五章----供应商发展<br />
                 第二十五条&nbsp;对首选长期合作供应商，遨旅航空直销平台对提供更多支持，包括降低交易成本、名誉嘉奖、物质经济奖励、政策倾斜等。<br />
                 第二十六条&nbsp;对可接受的、受限制的供应商，遨旅航空直销平台应加强联络沟通，为供应商培训工作人员，主动为双方合作提供更多机会。<br />
                 第二十七条&nbsp;遨旅航空直销平台违反本条例规定下列情形之一的，对负有直接责任的主管人员和其他直接责任人员依法给予行政处分：<br />
                 &nbsp;（一）&nbsp;对符合条件的供应商申请人而不给予批准的。<br />
                 &nbsp;（二）&nbsp;对不符合条件的申请人擅自给予批准成为供应商的。<br />
                 第二十八条&nbsp;遨旅航空直销平台工作人员玩忽职守、滥用职权、徇私舞弊，造成经济损失的，依法追究刑事责任；尚不构成犯罪的，依法给予行政处分。 </p>
               <p >第六章----附则<br />
                 第二十九条&nbsp;本条例自发布之日起施行。遨旅航空直销平台对本条例拥有修改权利和最终解释权利。 </p>
               <p > </p>
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
