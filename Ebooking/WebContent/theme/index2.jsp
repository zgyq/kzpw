<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-首页</title>
<ww:head name="index" jsURL="citycontrol" />
<script type="text/javascript">
    var commonallcity=new Array(); 
    var allcity=new Array(); 
function lodimage(index){
	for(i=1;i<=4;i++){
		document.getElementById("sp"+i).className="f nuber_out";
		 $("#image"+i).hide();
	}
	document.getElementById("sp"+index).className="f nuber_on fff";
 		$("#image"+index).show();
}
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
	    
	    chagecity("PEK");
	    
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
	
  function changetabsearch(index)
  {
     if(index=="0")
     {
        $("#rdoTicketTypelocal").click();
        document.getElementById("div_tickettab").className="sea_topon f fff";
        document.getElementById("div_intertickettab").className="sea_topout f";
     }
     else if(index=="1")
     {
       $("#rdoTicketTypeinter").click();
       document.getElementById("div_intertickettab").className="sea_topon f fff";
       document.getElementById("div_tickettab").className="sea_topout f";
     }
  }
  //查询最低价	
function chagecity(citycode){
var flag=document.getElementById("ul1");
 flag.style.display ="none";
 if(citycode=="SHA"){
 $("#ul2").val("上海");
 }
  if(citycode=="PEK"){
 $("#ul2").val("北京");
 }
 if(citycode=="CEN"){
 $("#ul2").val("广州");
 }
 if(citycode=="SIA"){
 $("#ul2").val("西安");
 }
 if(citycode=="HGH"){
 $("#ul2").val("杭州");
 }
 if(citycode=="DLC"){
 $("#ul2").val("大连");
 }
 if(citycode=="WNZ"){
 $("#ul2").val("温州");
 }
$.ajax({
//meiyouwenti
    url:"ticticket!ajaxgetLowersegment.jspx",
    type:"POST",
    data:{fromcity:citycode},
     beforeSend:function(){$("#segmenttr").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载特价机票信息...");},             
    success:function(data){
       $("#segmenttr").html(data);
    }

});

}
//显示下拉列表
 function showul()
	 {  
	    var show=document.getElementById("ul2");
	    var flag=document.getElementById("ul1"); 
	    if(flag.style.display=='none'){
	    flag.style.display ="";    
	    }else{
	    flag.style.display ="none";
	    }
	   
	 }

</script>
</head>

<body>
<ww:i18n name="'language'">
<div id="container">
<div id="container">
<div class="cen" style=" position:relative;">
<ww:include page="../top.jsp?type=index" />
</div>
 <!--includ top 直接替换掉整个DIV-->
<div id="main">
<div class="f left">
<div class="sea_top">
<div class="sea_topon f fff" id="div_tickettab" style="cursor:hand" onclick="changetabsearch(0);">国内机票</div>
<div class="sea_topout f" id="div_intertickettab" style="cursor:hand;display:none" onclick="changetabsearch(1);">国际机票</div>
<div class="c"></div>
</div>
<form name="form1" id="form1" method="post">
<div id="search">
<ul>
<input style="display:none" name="TicketType" id="rdoTicketTypelocal" name="tickettype"
			type="radio" value="0" checked="checked"/> 
<input name="TicketType" style="display:none" id="rdoTicketTypeinter"
			type="radio" value="1" name="tickettype"/>
	<li class="choose"><input name="s_traveltype" id="rdoOneWay"
		type="radio" value="1" onclick="bindFlightType(1);" /> <span
		class="mr15"> <ww:text name="'OneWay'" /></span> <input
		name="s_traveltype" id="rdoRoundWay" type="radio" value="2"
		checked="checked" onclick="bindFlightType(2);" /> <ww:text
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
	就上${compname}商旅网。</span> <span><input type="button" id="btnsearch" class="button_search" value="立即查询" onclick="search();" /></span></li>
</ul>
</div>
</form>
<!--search over-->
<div class="sea_bom">&nbsp;</div>
</div>
<div class="f center"><img src="images/ad_index.jpg" width="479"
	height="222" /> <font class="f90 lh34">公告：10月10日吉祥航空新开上海-北京
南航空客A380国内首飞 国航南京、常州6个城</font></div>
<div class="r right">
<div class="titlenew"><font class="black">相关信息</font></div>
<div class="box content">
<ul>
<ww:iterator value="Listhelpcenterinfo">
	<li><a  href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>">
	 <ww:if test="name.length()>23">
	<ww:property value="SubString(name,20)"/>...
	</ww:if><ww:else>
	<ww:property value="name"/>
	</ww:else>
	</a></li>
</ww:iterator>	
	
</ul>
</div>
</div>
<div class="c"></div>
</div>
<div id="cemain">
<div class="left f">
<div class="box">
<div class="title"><font class="black low f mr15">国内超低折扣机票</font>
<div class="f city"><input id="ul2" type="text"
		class="text_city c999" onclick="showul()" value="请选择" />
	<ul class="city_ul box" style="display: none" id="ul1">
	<li><a href="javascript:void(0);" onclick="chagecity('PEK');"
			class="c999">北京</a></li>
		<li><a href="javascript:void(0);" onclick="chagecity('SHA');"
			class="c999">上海</a></li>
		<li><a href="javascript:void(0);" onclick="chagecity('CEN');"
			class="c999">广州</a></li>
		<li><a href="javascript:void(0);" onclick="chagecity('SIA');"
			class="c999">西安</a></li>
		<li><a href="javascript:void(0);" onclick="chagecity('HGH');"
			class="c999">杭州</a></li>
		<li><a href="javascript:void(0);" onclick="chagecity('DLC');"
			class="c999">大连</a></li>
		<li><a href="javascript:void(0);" onclick="chagecity('WNZ');"
			class="c999">温州</a></li>
	</ul>
	</div>
<span class="c"></span></div>
<div class="lowlist">
<div class="f lowmain">
<table width="660" border="0" cellspacing="0" cellpadding="0"
		class="centerall">
		<tr id="segmenttr">
			<ww:property value="lowersegmentstr" />
		</tr>
	</table>
</div>

<div class="c"></div>
</div>
</div>
<div class="mt7">
<div class="box f general-ticket">
<div class="title "><font class="black low f mr15 ">乘机常识</font> <span
	class="c"></span></div>
<div class="sense_main">
<ul>
<ww:iterator value="listCJCS">
	<li><span class="ico_lis">&nbsp;</span><ww:if test="name.length()>16">
               <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="SubString(name,14)"/>...</a>
               </ww:if><ww:else>
                <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="name"/></a>
               </ww:else></li>
</ww:iterator>
	
</ul>
</div>
<div class="sense_main_ad"><img src="images/ad_changshi.jpg"
	width="261" height="71" /></div>
</div>
<div class="box r visa">
<div class="title "><font class="black low f mr15 ">益差旅博客</font> <span
	class="c"></span></div>
<div class="sense_main">
<ul>
 	<ww:iterator value="listQZ">
	<li><span class="ico_lis">&nbsp;</span><ww:if test="name.length()>15">
               <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="SubString(name,13)"/>...</a>
               </ww:if><ww:else>
                <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"><ww:property value="name"/></a>
               </ww:else></li>
	</ww:iterator>
	
</ul>
</div>
<div class="sense_main_ad"><img src="images/ad_zhishi.jpg"
	width="261" height="71" /></div>
</div>
</div>
</div>
<div class="right r">
<div class="answer">&nbsp;</div>
<div class="question">
 <ww:iterator value="listCJWT">
<ul>
	<li><span class="ico_ques f">&nbsp;</span><font class="c999"><ww:if test="name.length()>15">
               <a  class="lan418caa"href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="SubString(name,13)"/>...</a>
               </ww:if><ww:else>
               <a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:property value="name"/></a>
               </ww:else></font></li>
	<li><span class="ico_answ f">&nbsp;</span><a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"
		class="unc09fx"><ww:if test="info.length()>23">
               <ww:property value="SubString(info,20)"/>...
               </ww:if>
               <ww:else>
                <ww:property value="info"/>
               </ww:else></a></li>
</ul>
</ww:iterator>
<!--<ul>
	<li><span class="ico_ques f">&nbsp;</span><font class="c999">国际机票是如何区分儿童和婴儿的？</font></li>
	<li><span class="ico_answ f">&nbsp;</span><a href="#"
		class="unc09fx">国际机票在下单之后有一个确认的时间</a></li>
</ul>
<ul>
	<li><span class="ico_ques f">&nbsp;</span><font class="c999">什么是国际机票有效期？</font></li>
	<li><span class="ico_answ f">&nbsp;</span><a href="#"
		class="unc09fx">国际机票在下单之后有一个确认的时间过程。</a></li>
</ul>
<ul>
	<li><span class="ico_ques f">&nbsp;</span><font class="c999">国际机票是如何区分儿童和婴儿的？</font></li>
	<li><span class="ico_answ f">&nbsp;</span><a href="#"
		class="unc09fx">国际机票在下单之后有一个确认的时间</a></li>
</ul>
<ul>
	<li><span class="ico_ques f">&nbsp;</span><font class="c999">什么是国际机票有效期？</font></li>
	<li><span class="ico_answ f">&nbsp;</span><a href="#"
		class="unc09fx">国际机票在下单之后有一个确认的时间过程。</a></li>
</ul>
<ul>
	<li><span class="ico_ques f">&nbsp;</span><font class="c999">国际机票是如何区分儿童和婴儿的？</font></li>
	<li><span class="ico_answ f">&nbsp;</span><a href="#"
		class="unc09fx">国际机票在下单之后有一个确认的时间</a></li>
</ul>
<ul>
	<li><span class="ico_ques f">&nbsp;</span><font class="c999">什么是国际机票有效期？</font></li>
	<li><span class="ico_answ f">&nbsp;</span><a href="#"
		class="unc09fx">国际机票在下单之后有一个确认的时间过程。</a></li>
</ul>
<ul>
	<li><span class="ico_ques f">&nbsp;</span><font class="c999">国际机票是如何区分儿童和婴儿的？</font></li>
	<li><span class="ico_answ f">&nbsp;</span><a href="#"
		class="unc09fx">国际机票在下单之后有一个确认的时间</a></li>
</ul>
-->
</div>
</div>
<div class="c"></div>
<div><img src="images/ad_1004.jpg" width="1004" height="50"
	class="ad1004" /></div>
</div>
<div id="bommain">
<div class="left f">
<div class="left_top black">国际热门线路</div>
<div class="box box_topno international">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90">北京-香港</td>
		<td width="40">往返</td>
		<td width="60" class="ff7f05">￥3700↑</td>
		<td width="45">10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
	<tr>
		<td>北京-东京</td>
		<td>往返</td>
		<td class="ff7f05">￥5700↑</td>
		<td>10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
	<tr>
		<td>北京-香港</td>
		<td>往返</td>
		<td class="ff7f05">￥3700↑</td>
		<td>10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
	<tr>
		<td>北京-东京</td>
		<td>往返</td>
		<td class="ff7f05">￥5700↑</td>
		<td>10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
	<tr>
		<td>北京-香港</td>
		<td>往返</td>
		<td class="ff7f05">￥3700↑</td>
		<td>10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
	<tr>
		<td>北京-东京</td>
		<td>往返</td>
		<td class="ff7f05">￥5700↑</td>
		<td>10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
	<tr>
		<td>北京-香港</td>
		<td>往返</td>
		<td class="ff7f05">￥3700↑</td>
		<td>10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
	<tr>
		<td>北京-东京</td>
		<td>往返</td>
		<td class="ff7f05">￥5700↑</td>
		<td>10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
	<tr>
		<td>北京-东京</td>
		<td>往返</td>
		<td class="ff7f05">￥5700↑</td>
		<td>10-10</td>
		<td><input type="button" class="bntt aa1717" value="预定" /></td>
	</tr>
</table>

</div>
</div>
<div class="center f">
<div class="center_top black">推荐航空公司</div>
<div class="box box_topno airline">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="text_center">
	<tr>
		<td height="76"><img src="images/guohang.jpg" width="70"
			height="70" /></td>
		<td><img src="images/donghang.jpg" width="70" height="70" /></td>
		<td><img src="images/chuanhang.jpg" width="70" height="70" /></td>
	</tr>
	<tr>
		<td>中国国际航空</td>
		<td>东方航空公司</td>
		<td>四川航空公司</td>
	</tr>
	<tr>
		<td height="77"><img src="images/shenmehang.jpg" width="70"
			height="70" /></td>
		<td><img src="images/feihe.jpg" width="70" height="70" /></td>
		<td><img src="images/haihang.jpg" width="70" height="70" /></td>
	</tr>
	<tr>
		<td>北方航空公司</td>
		<td>厦门航空公司</td>
		<td>海南航空公司</td>
	</tr>
</table>

</div>
</div>
<div class="right r"><img src="images/ad_gongneng.jpg" width="325"
	height="290" /></div>
<div class="c"></div>
</div>
<div id="overmain">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	class="box box_topno">
	<tr>
		<th class="text_left pf20" width="143" scope="col"><span
			class="ico_bom ico_bom1">&nbsp;</span>新手入门</th>
		<th class="text_left pf20" width="143" scope="col"><span
			class="ico_bom ico_bom2">&nbsp;</span>加盟代理</th>
		<th class="text_left pf20" width="143" scope="col"><span
			class="ico_bom ico_bom3">&nbsp;</span>支付方式</th>
		<th class="text_left pf20" width="143" scope="col"><span
			class="ico_bom ico_bom4">&nbsp;</span>售后服务</th>
		<th class="text_left pf20" width="143" scope="col"><span
			class="ico_bom ico_bom5">&nbsp;</span>特殊服务</th>
		<th class="text_left pf20" scope="col"><span
			class="ico_bom ico_bom6">&nbsp;</span>帮助信息</th>
	</tr>
	<tr>
		<td class="pf30">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="mt10 mb10">
			<tr>
				<td>·&nbsp;会员注册</td>
			</tr>
			<tr>
				<td>·&nbsp;会员登录</td>
			</tr>
			<tr>
				<td>·&nbsp;机票查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;酒店查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;话费充值</td>
			</tr>
		</table>
		</td>
		<td class="pf30">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="mt10 mb10">
			<tr>
				<td>·&nbsp;会员注册</td>
			</tr>
			<tr>
				<td>·&nbsp;会员登录</td>
			</tr>
			<tr>
				<td>·&nbsp;机票查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;酒店查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;话费充值</td>
			</tr>
		</table>
		</td>
		<td class="pf30">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="mt10 mb10">
			<tr>
				<td>·&nbsp;会员注册</td>
			</tr>
			<tr>
				<td>·&nbsp;会员登录</td>
			</tr>
			<tr>
				<td>·&nbsp;机票查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;酒店查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;话费充值</td>
			</tr>
		</table>
		</td>
		<td class="pf30">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="mt10 mb10">
			<tr>
				<td>·&nbsp;会员注册</td>
			</tr>
			<tr>
				<td>·&nbsp;会员登录</td>
			</tr>
			<tr>
				<td>·&nbsp;机票查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;酒店查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;话费充值</td>
			</tr>
		</table>
		</td>
		<td class="pf30">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="mt10 mb10">
			<tr>
				<td>·&nbsp;会员注册</td>
			</tr>
			<tr>
				<td>·&nbsp;会员登录</td>
			</tr>
			<tr>
				<td>·&nbsp;机票查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;酒店查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;话费充值</td>
			</tr>
		</table>
		</td>
		<td class="pf30">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="mt10 mb10">
			<tr>
				<td>·&nbsp;会员注册</td>
			</tr>
			<tr>
				<td>·&nbsp;会员登录</td>
			</tr>
			<tr>
				<td>·&nbsp;机票查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;酒店查询、预订</td>
			</tr>
			<tr>
				<td>·&nbsp;话费充值</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

</div>
</div>
<ww:include page="../footer.jsp" />
</ww:i18n>
</body>
</html>

