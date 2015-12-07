<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />

<title>${compname}-首页</title>
<ww:head name="index" jsURL="citycontrol" />
<script type="text/javascript">
    var commonallcity=new Array(); 
    var allcity=new Array(); 
function lodimage(index){

	for(i=1;i<=4;i++){
	
		 //$("#sp"+i).removeClass('nuber_on fff');
		 //$("#sp"+i).removeClass('nuber_out');
		document.getElementById("sp"+i).className="f nuber_out";
		 $("#image"+i).hide();
	}
	document.getElementById("sp"+index).className="f nuber_on fff";
	 //	$("#sp"+index).addClass('f nuber_on fff');
 		$("#image"+index).show();
}

<!--
    //页面加载
    $(document).ready(function()
	   {
	    commonallcity=commoncitys;
	    allcity= citys;
	    $("#rdoTicketTypeinter").click(function(){
	        commonallcity=intercommoncitys;
	        allcity=intercitys;
	        $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	        $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    });
	    
	     $("#rdoTicketTypelocal").click(function(){
	        commonallcity=commoncitys;
	        allcity=citys;
	        $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	        $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    });
	    
	    //加载城市控件数据
	    $("#txtDepCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(allcity,{hot_list:commonallcity,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    $("#txtDepCity").val("北京");
	    $("#hidDepCity").val("PEK");
	    
	    
	    
       //默认加载当日日期
      var d=new Date();
	  var str = d.format('yyyy-MM-dd');  
	  $("#txtstartdate").val(str);
	 });
	 //返程显示隐藏
	 function bindFlightType(index)
	 {
	    if(index==1)
	    {
	       $("#li_returndate").hide();
	    }
	    else if(index==2)
	    {
	       $("#li_returndate").show();
	    }
	 }
	
-->


</script>
</head>
<body>
<ww:i18n name="'language'">
	<div id="container"><ww:include page="top.jsp?type=index" /> <!--includ top 直接替换掉整个DIV-->
	<div id="main">
	<form name="form1" id="form1" method="post">
	<div id="search" class="f">
	<ul>
		<li class="searchtop"><input name="TicketType" id="rdoTicketTypelocal" name="tickettype"
			type="radio" value="0" checked="checked"/><span class="mr15"><ww:text
			name="'localair'" /></span> <input name="TicketType" id="rdoTicketTypeinter"
			type="radio" value="1" name="tickettype"/><ww:text name="'InterTickt'" /></li>
		<li class="choose"><input name="s_traveltype" id="rdoOneWay"
			type="radio" value="1" onclick="bindFlightType(1);" /> <span
			class="mr15"> <ww:text name="'OneWay'" /></span> <input
			name="s_traveltype" id="rdoRoundWay" type="radio" value="2"
			checked="checked" onclick="bindFlightType(2);"/> <ww:text
			name="'Return'" /></li>
			
			
		<li class="ulli" id="city1"><ww:text name="'DepartureCity'" />：<input
			type="text" id="txtDepCity" name="s_depcityname" class="text_search"
			value="" title="请选择出发城市" />
		<div id='suggest' class="ac_results"></div>
		<input type="hidden" id="hidDepCity" name="s_depcitycode" value="" />
		</li>
		
		<li class="ulli" id="city3"><ww:text name="'ArrivalCity'" />：<input
			type="text" id="txtArrCity" name="s_arrcityname" class="text_search"
			value="" title="请选择到达城市" />
			<div id='suggest2' class="ac_results"></div>
		<input type="hidden" id="hidArrCity" name="s_arrcitycode" value="" />
		</li>
		<li class="ulli"><ww:text name="'DepartureTime'" />：<input
			type="text" id="txtstartdate" name="s_startdate"
			onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="Wdate" value="" title="请选择出发时间" /></li>
		<li class="ulli" id="li_returndate"><ww:text name="'ArrivalTime'" />：<input
			type="text" id="txtbackdate" name="s_backdate"
			onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="Wdate" value="" /></li>
		

	
			
		<li class="but"><span class="guild f">搜索最优的机票，<br />
		就上${compname}。</span> <span><input type="button" id="btnsearch" class="button_search"
			value="立即查询" onclick="search();" /></span></li>
	</ul>
	</div>
	<!--search over-->
	<div id="ad" class="f">
	<h2 class="new fff">最新资讯</h2>
	
	<div class="hot">
	
	<ww:iterator value="listZX">
	<h5 ><span class="ico">&nbsp;</span><a class="fff" href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>">
	 <ww:if test="name.length()>23">
	<ww:property value="SubString(name,20)"/>...
	</ww:if><ww:else>
	<ww:property value="name"/>
	</ww:else>
	</a></h5>
	
	<a class="fff" href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>">
	<p class="dcff58 f"> <ww:if test="info.length()>43">
	<ww:property value="SubString(info,40)"/>...
	</ww:if><ww:else>
	<ww:property value="info"/>
	</ww:else></p></a>
	
	<span class="more r">&nbsp;</span>
	</ww:iterator>
	</div>
	
	<!--
	<div class="hot">
	<h5 class="fff"><span class="ico">&nbsp;</span>商旅订制业务全新上线！</h5>
	<p class="dcff58 f">中小企业想对公司差旅活动进行差旅管理， 试试 ${compname}·中小企业商旅通，${compname}商旅网
	为您订制最适合您的方案</p>
	<span class="more r">&nbsp;</span>
	<h5 class="fff"><span class="ico">&nbsp;</span>商旅订制业务全新上线！</h5>
	<p class="dcff58 f">中小企业想对公司差旅活动进行差旅管理， 试试 ${compname}·中小企业商旅通，${compname}商旅网
	为您订制最适合您的方案</p>
	<span class="more r">&nbsp;</span>
	</div>
	-->
	</div>
	<div class="c nohave"></div>
	</form>
	</div>
	<div id="center" class=" mt10">

      <div class="left f">
        <div class="font24000" style="line-height:32px;">国内机票预订</div>
        <div class="line"></div>
        
          <ul class="mt20">
        <ww:iterator value="listJPYD" status="ind">
         <ww:if test="#ind.index<2">
          <li class="lv678b06"><a href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="name"/></a></li>
	           <ww:if test="#ind.index==1">
	            </ul>
	       		 <ul class="mt20">
	           </ww:if>
         </ww:if><ww:else>
	          <ww:if test="#ind.index==5||#ind.index==8">
	            </ul>
	       		 <ul class="mt20">
	           </ww:if>
          <li><a href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="name"/></a></li>
         </ww:else>
        </ww:iterator>
        </ul>
        <!--
        <ul class="mt20">
        <li class="lv678b06">国航南京、成都始发往返优惠5%-10%国航往返 12月31日截止 申请</li>
        <li class="lv678b06">东航青年票预售33折起东航单程+往返 12月31日 申请 </li>
        </ul>
        <ul class="mt20">
        <li>国航南京、成都始发往返优惠5%-10%国航往返 12月31日截止 申请</li>
        <li>东航青年票预售33折起东航单程+往返 12月31日 申请 </li>
        <li>东航青年票预售33折起东航单程+往返 12月31日 申请 </li>
        </ul>
        <ul class="mt20">
        <li>国航南京、成都始发往返优惠5%-10%国航往返 12月31日截止 申请</li>
        <li>东航青年票预售33折起东航单程+往返 12月31日 申请 </li>
        <li>东航青年票预售33折起东航单程+往返 12月31日 申请 </li>
        </ul>
         -->
           <div class="mt20 sense f" >
              <div class="sense_box" >
                 <font class="font18000 sense_mar" >乘机常识</font>
                 <div class="sense_main" >
                  <ul>
                  <ww:iterator value="listCJCS">
                  <li><span class="ico_lis">&nbsp;</span>
                   <ww:if test="name.length()>16">
               <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="SubString(name,14)"/>...</a>
               </ww:if><ww:else>
                <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="name"/></a>
               </ww:else></li>    
                  </ww:iterator>
                  <!--            
                  <li><span class="ico_lis">&nbsp;</span>留学荷兰：国际特价机票常识</li>
                  <li><span class="ico_lis">&nbsp;</span>出国留学机票小常识</li>
                  <li><span class="ico_lis">&nbsp;</span>孕妇安全带有特别系法</li>
                  -->
                  </ul>
                 </div>
              </div>
            </div>
            <div class="mt20 sensetwo r" >
              <div class="sense_box" >
                 <font class="font18000 sense_mar" >预订须知</font>
                 <div class="sense_main" >
                  <ul>
                  <ww:iterator value="listYDXZ">
                  <li><span class="ico_lis">&nbsp;</span>
                   <ww:if test="name.length()>16">
                <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="SubString(name,14)"/>...</a>
               </ww:if><ww:else>
               <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="name"/></a>
               </ww:else></li>    
                  </ww:iterator>
                  <!--
                  <li><span class="ico_lis">&nbsp;</span>春运携子乘机 购买机票有窍门</li>                
                  <li><span class="ico_lis">&nbsp;</span>留学荷兰：国际特价机票常识</li>
                  <li><span class="ico_lis">&nbsp;</span>出国留学机票小常识</li>
                  <li><span class="ico_lis">&nbsp;</span>孕妇安全带有特别系法</li>
                  -->
                  </ul>
                 </div>
              </div>
            </div>
            <div class="c"> </div>
      </div>
      <div class="right f">
          <div>
           <div class="f mr5">
                <ul>
                <li class="font12000">Charter services</li>
                <li class="charter"></li>
                </ul>
           </div>
           <div class="f font24000" style="line-height:39px;">包机服务</div>
           <div class="c"></div>
          </div> 
          <div>
          <ww:iterator value="listBJ">
          		<ul class="mt10">
               <li>
               <ww:if test="info.length()>60">
                <a href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="SubString(info,55)"/>...</a>
               </ww:if><ww:else>
                <a href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="info"/></a>
               </ww:else>
              
               </li>
               </ul>
          </ww:iterator>
               <!--
               <ul class="mt20">
               <li>国航南京、成都始发往返优惠5%-10%国航往返 12月31日截止 申请惠5%-10%国航往返 12月31日截止</li>
               </ul>
               <ul class="mt10">
               <li>国航南京、成都始发往返优惠5%-10%国航往返 12月31国航南京、成都始发往返优惠5%-10%国航往返 12月31</li>
               </ul>
              -->
           </div>
           <div class="mt20 black" style="line-height:18px;">热门推荐</div>
           <div class="line"></div>
           <div class="mt10">
                <ul>
                <ww:iterator value="listRMTJ">
                  <a href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <li class="unc09f"><span  class="ico_lst">&nbsp;</span>
                  <ww:if test="name.length()>18">
                     <ww:property value="SubString(name,15)"/>...
                   </ww:if><ww:else>
                     <ww:property value="name"/>
                   </ww:else>
                  </li>   </a>
                </ww:iterator>
              
               
                </ul>
           </div>
            <div class="mt20 sensethree" >
              <div class="sense_boxone" >
                 <font class="font18000 sense_mar" >常用工具</font>
                 <div class="help">
                   <ul>
                   <li class="f"><a target="_blank" href="http://www.worldweather.cn/">天气预报</li>
                   <li class="f"><a target="_blank" href="http://www.veryzhun.com/order.asp">航班跟踪</li>
                   <li class="f"><a target="_blank" href="http://www.variflight.com/search/index.htm">航班动态</li>
                   <li class="f"><a target="_blank" href="http://www.baoku.com/frontplatform/airline_list.jsp">网上值机</li>
                   <li class="f"><a target="_blank" href="http://www.fmprc.gov.cn/chn/pds/wjb/zwjg/">据外使馆</a></li>
                   <li class="f"><a target="_blank" href="map1.jsp">电子地图</a></li>
                   </ul>
                 </div>
              </div>
            </div>
      </div>
      <div class="c"></div>
    </div>
    <div id="bot" >
       <div>
         <ul class="fff">
         <li class="f one">国内机票预订</li>
         <li class="f two">国际机票预订</li>
         <li class="f three">${compname}商旅服务</li>
         <li class="f four">酒店预订服务</li>
         <li class="f five">团队/包机申请</li>
         </ul>
       </div>
       <div>
           <div class="f bot_left">
              <div class="question fff">常见问题</div>
               <ww:iterator value="listCJWT">
               <ul>
               <li ><span  class="ico_ques">&nbsp;</span>
               <ww:if test="name.length()>15">
               <a  class="lan418caa"href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="SubString(name,13)"/>...</a>
               </ww:if><ww:else>
               <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="name"/></a>
               </ww:else> </li>
                <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>">
               <li class="ico_no un8b">
               <ww:if test="info.length()>30">
               <ww:property value="SubString(info,27)"/>...
               </ww:if>
               <ww:else>
                <ww:property value="info"/>
               </ww:else>
               </li></a>
               </ul>
               </ww:iterator><!--
               <ul>
               <li class="lan418caa"><span  class="ico_ques">&nbsp;</span>什么是国际机票有效期？  </li>
               <li class="ico_no un8b">国际机票在下单之后有一个确认 的时间。国际机票是如何区。</li>
               </ul>
               <ul>
               <li class="lan418caa"><span  class="ico_ques">&nbsp;</span>什么是国际机票有效期？  </li>
               <li class="ico_no un8b">国际机票在下单之后有一个确认 的时间。国际机票是如何区。</li>
               </ul>
               <ul>
               <li class="lan418caa"><span  class="ico_ques">&nbsp;</span>什么是国际机票有效期？  </li>
               <li class="ico_no un8b">国际机票在下单之后有一个确认 的时间。国际机票是如何区。</li>
               </ul>
               <ul>
               <li class="lan418caa"><span  class="ico_ques">&nbsp;</span>什么是国际机票有效期？  </li>
               <li class="ico_no un8b">国际机票在下单之后有一个确认 的时间。国际机票是如何区。</li>
               </ul>
               <div class="notes fff mt10">乘客须知</div>
                <ul>
               <li class="lan418caa"><span  class="ico_ques">&nbsp;</span>什么是国际机票有效期？  </li>
               <li class="ico_no un8b">国际机票在下单之后有一个确认 的时间。国际机票是如何区。</li>
               </ul>
                <ul>
               <li class="lan418caa"><span  class="ico_ques">&nbsp;</span>什么是国际机票有效期？  </li>
               <li class="ico_no un8b">国际机票在下单之后有一个确认 的时间。国际机票是如何区。</li>
               </ul>
           --></div>
           <div class="r bot_right">
             <div><img src="images/ad_index.jpg" width="657" height="126" /></div>
             <div class="well">
                  <ul>
                  <li class="f font24000 good"><span class="ico_good f"></span>商旅订制4大优势</li>
                  <li class="r nuber">
                      <span class="f nuber_on fff" id="sp1" onmouseover="(1);" >1</span>
                      <span class="f nuber_out" id="sp2"  onmouseover="lodimage(2);" >2</span>
                      <span class="f nuber_out" id="sp3"  onmouseover="lodimage(3);" >3</span>
                      <span class="f nuber_out" id="sp4"  onmouseover="lodimage(4);" >4</span>
                      </li>
                  <li class="c nohave">&nbsp;</li>
                  <li id="image1"><img src="images/testgood/good1.jpg" width="652" height="149" /></li>
                  <li style="display: none;" id="image2"><img src="images/testgood/good2.jpg" width="652" height="149" /></li>
                  <li style="display: none;" id="image3"><img src="images/testgood/good3.jpg" width="652" height="149" /></li>
                  <li style="display: none;" id="image4"><img src="images/testgood/good4.jpg" width="652" height="149" /></li>
                  </ul>
             </div>
             <div class="mt10">
                <div class="f visa_left">
                  <ul>
                  <li class="visa font18000" >签证知识</li>
                  <ww:iterator value="listQZ">
                  <li class="dd0c94 visa_title"><ww:if test="name.length()>15">
               <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="SubString(name,13)"/>...</a>
               </ww:if><ww:else>
                <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="name"/></a>
               </ww:else></li>
                  <li class="visa_main">
                 <ww:if test="info.length()>70">
               <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="SubString(info,70)"/>...</a>
                  </ww:if><ww:else>
            <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="info"/></a>
                 </ww:else>
                   
                  </li>
                  </ww:iterator>
               
                  </ul> 
                </div>
                <div class="r visa_right">
                <ul>
                  <li class="visa font18000" >机票常识</li>
                  <ww:iterator value="listCXBZ">
                    <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><li class="dd0c94 visa_title"> <ww:property value="name"/></li></a>
                    <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><li class="visa_main"><ww:property value="info"/></li></a>
                  </ww:iterator>
                 
                  </ul> 
                </div>
                <div class="c"></div>
             </div>
           
           </div>
           <div class="c"></div>
       </div>
    </div>
</div>
	<ww:include page="footer.jsp" />
	
</ww:i18n>
</body>

</html>
