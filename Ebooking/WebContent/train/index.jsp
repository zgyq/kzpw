<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>

#zong{
MARGIN-LEFT:360px;
 }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-火车票首页</title>
<link href="ticket_el/css/001.css" rel="stylesheet" type="text/css" media="all" />
<link href="ticket_el/css/hcsy.css" rel="stylesheet" type="text/css" media="all" />
<link href="ticket_el/css/index.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="ticket_el/js/jquery.js"></script>
<script type="text/javascript" src="ticket_el/js/tab.js"></script>

<link href='ticket_el/css/shike.css' rel="stylesheet" type="text/css" />

<!-- 酒店用 -->
<link rel=stylesheet type=text/css href="js/train_js/css.css" />
<script type="text/javascript" src="js/train_js/city.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
<!--图片无缝滚动 -->
$(function(){
	
	   
	   
	   
	   
	  //加载火车票时间
	   $("#txtStartDate_train").val(getDateyyyyMMdd(3));  
	   
	  
		   })
		   
		   
		   
		   
 function getDateyyyyMMdd(num) {
    var d = new Date();
    d.setDate(d.getDate() + num);
    var y = d.getFullYear();
    var m = d.getMonth() + 1;
    if (m < 10) {
        m = '0' + m;
    }
    var d = d.getDate();
    if (d < 10) {
        d = '0' + d;
    }
    var str = y + '-' + m + '-' + d;
    return str;
}
function  seach_hotel(){
document.hotel_seach.submit();

}
		   
 //查询航班信息
function search_air(){ 

var rdoFrom=document.getElementById("rdoRoundWay");
	if(rdoFrom.checked==true && $("#txtbackdate").val()==""){//flightType
	   alert("返回日期不能为空!!!");
		return;
	}
	
			   
	 	document.form_air.action="ticticket!toTicketList.jspx";
	     document.form_air.method = "POST"; 
         document.form_air.submit();
 }
 
 
 function huhuan(id1,id2){
 
 var id1va=$("#"+id1).val();
 var id2va=$("#"+id2).val();
 
  
  $("#"+id1).val(id2va);
  $("#"+id2).val(id1va);
 }
 
</script>

</head>

<body id="mainbody">
<!-- ===================== header start ===================== -->
<ww:include page="../top.jsp?index=4&subindex=1" />
<!-- ===================== header end ===================== -->
<!--end header -->
<div id="main" style="margin-top: 0px;" align="left">

<form name="form_train" id="form_train" method="post" action="train!search.jspx">
<div class="huochebanner">
	<div class="wrap">
		<div class="mainbox">
			<div class="hotel_home_warp">  
                               <div id="zong">
				<div class="block-content trainIndex_box_shadow trainIndex_shadow">
					<div id="changeTrainSearchCity" class="changeIcon" onclick="huhuan('scityname','ecityname');" style="display: block;"></div>
					<div class="search-title"><h1 class="fl"><span class="titimg fl"></span><span class="sp1">国内火车票</span></h1></div>
					<div id="search_info" class="search_info clearfix">
						<ul>
							<li>
								<label for="trainRadio1">
									<span style="display: block; float: left; margin-right: 8px;">车票类型</span>
									<input type="radio" class="input04" checked="checked" id="trainRadio1" />
									<span class="sp_input04">单程</span>
								</label>
							</li>
						</ul>
						<dl class="list" id="leaveCity">
							<dt class="list_tit"><span class="tips1">出发城市</span></dt>
							<dd>
								<input type="text" maxlength="20" name="startcity" id="scityname" class="input06"   value="北京" autocomplete="off"/>
							</dd>
						</dl>
						<dl class="list" id="arriveCity">
							<dt class="list_tit">到达城市</dt>
							<dd>
								<input type="text" maxlength="20"  name="endcity" id="ecityname" class="input06"   value="上海" autocomplete="off"/>
							</dd>
						</dl>
						<dl class="list" id="leaveDate">
							<dt class="list_tit">出发日期</dt>
							<dd>
								<input type="text" style="ime-mode: disabled; color:#333333;"  class="input06" name="startdate" id="txtStartDate_train" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d', onpicked:function(){dtBackDate.focus();}})" autocomplete="off"/>
							</dd>
						</dl>
						<dl class="list" id="onlyGCD">
							<dd class="dtd">
								<label><input id="checkGcd" class="chk fl" type="checkbox" /><span class="fl fsize14" style="padding-left: 4px;">只要GC高铁/D动车</span></label>
							</dd>
						</dl>
						<dl class="list">
							<dd class="dtd">
								<input id="trainSearchSubmit" class="submitSearch" type="submit" value="搜 索" style="display: inline-block;">
							</dd>
						</dl>
					</div>
				</div>
                          </div>
		     </div>
		     
		</div>
	</div>
</div>
</form>
<!--end banner -->
<div id="zong">
<div class="contmain wrap mt20">
	<div class="huoche_l">
		<link href="ticket_el/css/huochetool.css" rel="stylesheet" type="text/css" media="all" />
		<div class="traintoolbox">
			<div class="borderGray fl">
				<div class="borderBlue">
					<span class="titimg fl"></span>
					<h2 class="fl">
						火车票工具箱</h2>
				</div>
			</div>
			<div class="traintool">
				<div class="padlr45">
					<a><span class="myorder"></span>
						<p>
							我的订单</p>
					</a><a target="_blank" href="#"><span class="weather"></span>
						<p>
							天气预报</p>
					</a><a target="_blank" href="#" style="margin-right: 0;">
						<span class="outlets"></span>
						<p>
							代售点查询</p>
					</a>
				</div>
				<div class="trainsearch">
					<p class="tbtit mt10 fl">
						时刻表查询</p>
					<ul class="mt10 fl">
						<li class="mr20 fl">
							<label for="trainsearch1">
								<input id="trainsearch1" type="radio" name="SearchType" checked="checked" />站站时刻表</label></li><li
									class="mr20 fl">
									<label for="trainsearch2">
										<input id="trainsearch2" type="radio" name="SearchType" />车站时刻表</label></li><li class="fl">
											<label for="trainsearch3">
												<input id="trainsearch3" type="radio" name="SearchType" />车次时刻表</label></li></ul>
					<div class="trainsearchdiv">
						<span id="fromcitySpan" class="searchspan">
							<input id="fromcityInt" type="text" class="inputcity" maxlength="20" holder="城市名"
								nulltips="请输入出发城市名称" value="城市名" /></span><span class="swap"></span><span id="tocitySpan"
									class="searchspan">
									<input id="tocityInt" class="inputcity" type="text" maxlength="20" holder="城市名" nulltips="请输入到达城市名称"
										value="城市名" /></span><input id="cityBtn" class="searchbtn" type="button" value="搜索" /></div>
					
					
				</div>
			</div>
		</div>
		<div class="ad"><a href="#"><img src="ticket_el/images/huoche_ad_1.jpg" width="390" height="200" /></a></div>
	</div>
	<div class="huoche_r">		
		
		<div class="toptarinline box-shadow">
          <div class="top"> <span class="topimg fl"></span>
            <h2 class="fl"> 热门火车线路</h2>
            <ul class="SwapTab">
              <li class="on">北京</li>
              <li class="">上海</li>
              <li class="">广州</li>
              <li class="">杭州</li>
              <li class="">南京</li>
            </ul>
            <a class="fr" target="_blank" href="#" style="line-height: 22px;"> 更多<font style="font-family: \5B8B\4F53;">&gt;&gt;</font></a> </div>
          <div class="tab-content">
		  <div class="beijing">
            <div class="type01 mtop">
              <ul>
                <li><a href="#" target="_blank" title="北京 → 广州火车时刻表">北京 → 广州</a><span><font>¥251</font>起</span></li>
                <li><a href="#" target="_blank" title="北京 → 沈阳火车时刻表">北京 → 沈阳</a><span><font>¥86</font>起</span></li>
                <li><a href="#" target="_blank" title="北京 → 天津火车时刻表">北京 → 天津</a><span><font>¥8.5</font>起</span></li>
                <li><a href="#" target="_blank" title="北京 → 武汉火车时刻表">北京 → 武汉</a><span><font>¥148.5</font>起</span></li>
                <li><a href="#" target="_blank" title="北京 → 石家庄火车时刻表">北京 → 石家庄</a><span><font>¥41.5</font>起</span></li>
                <li><a href="#" target="_blank" title="北京 → 郑州火车时刻表">北京 → 郑州</a><span><font>¥93</font>起</span></li>
                <li><a href="#" target="_blank" title="北京 → 合肥火车时刻表">北京 → 合肥</a><span><font>¥138.5</font>起</span></li>
                <li><a href="#" target="_blank" title="北京 → 长春火车时刻表">北京 → 长春</a><span><font>¥128.5</font>起</span></li>
                <li><a href="#" target="_blank" title="北京 → 兰州火车时刻表">北京 → 兰州</a><span><font>¥189.5</font>起</span></li>
              </ul>
            </div>
          </div>
          <div class="shanghai hidden">
            <div class="type01 mtop">
              <ul>
                <li><a href="#" target="_blank" title="上海 → 杭州火车时刻表">上海 → 杭州</a><span><font>¥24.5</font>起</span></li>
                <li><a href="#" target="_blank" title="上海 → 成都火车时刻表">上海 → 成都</a><span><font>¥254.5</font>起</span></li>
                <li><a href="#" target="_blank" title="上海 → 西安火车时刻表">上海 → 西安</a><span><font>¥180.5</font>起</span></li>
                <li><a href="#" target="_blank" title="上海 → 郑州火车时刻表">上海 → 郑州</a><span><font>¥128.5</font>起</span></li>
                <li><a href="#" target="_blank" title="上海 → 广州火车时刻表">上海 → 广州</a><span><font>¥201</font>起</span></li>
                <li><a href="#" target="_blank" title="上海 → 长沙火车时刻表">上海 → 长沙</a><span><font>¥148.5</font>起</span></li>
                <li><a href="#" target="_blank" title="上海 → 徐州火车时刻表">上海 → 徐州</a><span><font>¥80</font>起</span></li>
                <li><a href="#" target="_blank" title="上海 → 合肥火车时刻表">上海 → 合肥</a><span><font>¥44.5</font>起</span></li>
                <li><a href="#" target="_blank" title="上海 → 哈尔滨火车时刻表">上海 → 哈尔滨</a><span><font>¥273.5</font>起</span></li>
              </ul>
            </div>
          </div>
          <div class="guangzhou hidden">
            <div class="type01 mtop">
              <ul>
                <li><a href="#" target="_blank" title="广州 → 长沙火车时刻表">广州 → 长沙</a><span><font>¥56</font>起</span></li>
                <li><a href="#" target="_blank" title="广州 → 昆明火车时刻表">广州 → 昆明</a><span><font>¥192</font>起</span></li>
                <li><a href="#" target="_blank" title="广州 → 郑州火车时刻表">广州 → 郑州</a><span><font>¥192</font>起</span></li>
                <li><a href="#" target="_blank" title="广州 → 厦门火车时刻表">广州 → 厦门</a><span><font>¥102</font>起</span></li>
                <li><a href="#" target="_blank" title="广州 → 成都火车时刻表">广州 → 成都</a><span><font>¥224</font>起</span></li>
                <li><a href="#" target="_blank" title="广州 → 海口火车时刻表">广州 → 海口</a><span><font>¥139</font>起</span></li>
                <li><a href="#" target="_blank" title="广州 → 南昌火车时刻表">广州 → 南昌</a><span><font>¥124</font>起</span></li>
                <li><a href="#" target="_blank" title="广州 → 西安火车时刻表">广州 → 西安</a><span><font>¥236</font>起</span></li>
                <li><a href="#" target="_blank" title="广州 → 上海火车时刻表">广州 → 上海</a><span><font>¥201</font>起</span></li>
              </ul>
            </div>
          </div>
          <div class="hangzhou hidden">
            <div class="type01 mtop">
              <ul>
                <li><a href="#" target="_blank" title="杭州 → 厦门火车时刻表">杭州 → 厦门</a><span><font>¥148.5</font>起</span></li>
                <li><a href="#" target="_blank" title="杭州 → 福州火车时刻表">杭州 → 福州</a><span><font>¥105</font>起</span></li>
                <li><a href="#" target="_blank" title="杭州 → 济南火车时刻表">杭州 → 济南</a><span><font>¥124.5</font>起</span></li>
                <li><a href="#" target="_blank" title="杭州 → 天津火车时刻表">杭州 → 天津</a><span><font>¥156.5</font>起</span></li>
                <li><a href="#" target="_blank" title="杭州 → 嘉兴火车时刻表">杭州 → 嘉兴</a><span><font>¥13.5</font>起</span></li>
                <li><a href="#" target="_blank" title="杭州 → 徐州火车时刻表">杭州 → 徐州</a><span><font>¥90</font>起</span></li>
                <li><a href="#" target="_blank" title="杭州 → 曲阜火车时刻表">杭州 → 曲阜</a><span><font>¥330.5</font>起</span></li>
                <li><a href="#" target="_blank" title="杭州 → 温州火车时刻表">杭州 → 温州</a><span><font>¥31.5</font>起</span></li>
                <li><a href="#" target="_blank" title="杭州 → 天津火车时刻表">杭州 → 天津</a><span><font>¥156.5</font>起</span></li>
              </ul>
            </div>
          </div>
          <div class="nanjing hidden">
            <div class="type01 mtop">
              <ul>
                <li><a href="#" target="_blank" title="南京 → 上海火车时刻表">南京 → 上海</a><span><font>¥23.5</font>起</span></li>
                <li><a href="#" target="_blank" title="南京 → 郑州火车时刻表">南京 → 郑州</a><span><font>¥82</font>起</span></li>
                <li><a href="#" target="_blank" title="南京 → 徐州火车时刻表">南京 → 徐州</a><span><font>¥45.5</font>起</span></li>
                <li><a href="#" target="_blank" title="南京 → 武汉火车时刻表">南京 → 武汉</a><span><font>¥83</font>起</span></li>
                <li><a href="#" target="_blank" title="南京 → 合肥火车时刻表">南京 → 合肥</a><span><font>¥20.5</font>起</span></li>
                <li><a href="#" target="_blank" title="南京 → 济南火车时刻表">南京 → 济南</a><span><font>¥80</font>起</span></li>
                <li><a href="#" target="_blank" title="南京 → 杭州火车时刻表">南京 → 杭州</a><span><font>¥54.5</font>起</span></li>
                <li><a href="#" target="_blank" title="南京 → 苏州火车时刻表">南京 → 苏州</a><span><font>¥16.5</font>起</span></li>
                <li><a href="#" target="_blank" title="南京 → 宁波火车时刻表">南京 → 宁波</a><span><font>¥91</font>起</span></li>
              </ul>
            </div>
          </div>
		  </div>
        </div>
		<script type="text/javascript"> 
		//TAB切换
		function SwapTab(name,title,content,Sub,cur){
		  $(name+' '+title).click(function(){
			  $(this).addClass(cur).siblings().removeClass(cur);
			  $(content+" > "+Sub).eq($(name+' '+title).index(this)).show().siblings().hide();
		  });
		}
		$(function(){
			new SwapTab(".SwapTab","li",".tab-content","div","on");//排行TAB
		})
		</script>
		
		<!-- 特价机票 start -->
			<div class="templateBox special_air f_m_top" id="tab">
			  <div class="templateTitle templateBorbot">
				<h1 class="templateTitleH f_size16">近期特价机票</h1>
				<ul id="tab_top">
				  <li cityId="53" class="btnSee cur" id="tab_top01"><span>北京</span></li>
				  <li cityId="321" class="btnNone" id="tab_top02"><span>上海</span></li>
				  <li cityId="80" class="btnNone" id="tab_top03"><span>广州</span></li>
				  <li cityId="91" class="btnNone" id="tab_top04"><span>深圳</span></li>
				  <li cityId="394" class="btnNone" id="tab_top05"><span>重庆</span></li>
				  <li cityId="324" class="btnNone" id="tab_top06"><span>成都</span></li>
				  <li cityId="383" class="btnNone" id="tab_top07"><span>杭州</span></li>
				  <li cityId="224" class="btnNone" id="tab_top08"><span>南京</span></li>
				</ul>
			  </div>
			  <div class="templateMain f_p_a tabCon" style="height:210px;">
				  <div class="cur">
					<table width="100%" border="0" cellspacing="0"  cellpadding="0">
					  <tr>
						<td width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
						  
						<td align="right" width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">北京<em class="arrows">→</em>上海</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
					  </tr>
					</table>
				  </div>
				  <div>
				  	<table width="100%" border="0" cellspacing="0"  cellpadding="0">
					  <tr>
						<td width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">上海<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">上海<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">上海<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">上海<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
						  
						<td align="right" width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">上海<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">上海<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">上海<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到上海特价机票">上海<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
					  </tr>
					</table>
				  </div>
				  <div>
				  	<table width="100%" border="0" cellspacing="0"  cellpadding="0">
					  <tr>
						<td width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到广州特价机票">广州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到广州特价机票">广州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到广州特价机票">广州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到广州特价机票">广州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
						  
						<td align="right" width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到广州特价机票">广州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到广州特价机票">广州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到广州特价机票">广州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到广州特价机票">广州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
					  </tr>
					</table>
				  </div>
				  <div>
				  	<table width="100%" border="0" cellspacing="0"  cellpadding="0">
					  <tr>
						<td width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到深圳特价机票">深圳<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到深圳特价机票">深圳<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到深圳特价机票">深圳<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到深圳特价机票">深圳<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
						  
						<td align="right" width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到深圳特价机票">深圳<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到深圳特价机票">深圳<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到深圳特价机票">深圳<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到深圳特价机票">深圳<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
					  </tr>
					</table>
				  </div>
				  <div>
				  	<table width="100%" border="0" cellspacing="0"  cellpadding="0">
					  <tr>
						<td width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到重庆特价机票">重庆<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到重庆特价机票">重庆<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到重庆特价机票">重庆<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到重庆特价机票">重庆<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
						  
						<td align="right" width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到重庆特价机票">重庆<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到重庆特价机票">重庆<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到重庆特价机票">重庆<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到重庆特价机票">重庆<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
					  </tr>
					</table>
				  </div>
				  <div>
				  	<table width="100%" border="0" cellspacing="0"  cellpadding="0">
					  <tr>
						<td width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到成都特价机票">成都<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到成都特价机票">成都<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到成都特价机票">成都<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到成都特价机票">成都<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
						  
						<td align="right" width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到成都特价机票">成都<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到成都特价机票">成都<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到成都特价机票">成都<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到成都特价机票">成都<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
					  </tr>
					</table>
				  </div>
				  <div>
				  	<table width="100%" border="0" cellspacing="0"  cellpadding="0">
					  <tr>
						<td width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到杭州特价机票">杭州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到杭州特价机票">杭州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到杭州特价机票">杭州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到杭州特价机票">杭州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
						  
						<td align="right" width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到杭州特价机票">杭州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到杭州特价机票">杭州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到杭州特价机票">杭州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到杭州特价机票">杭州<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
					  </tr>
					</table>
				  </div>
				  <div>
				  	<table width="100%" border="0" cellspacing="0"  cellpadding="0">
					  <tr>
						<td width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到南京特价机票">南京<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到南京特价机票">南京<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到南京特价机票">南京<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到南京特价机票">南京<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
						  
						<td align="right" width="400">
						<table width="100%" border="0" cellspacing="0"  cellpadding="0">
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到南京特价机票">南京<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到南京特价机票">南京<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到南京特价机票">南京<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							<tr>
							  <td class="ts_tips" width="110"><a  href="#" title="北京到南京特价机票">南京<em class="arrows">→</em>北京</a></td>
							  <td><a class="tips"  href="#">&yen;<strong>270</strong> <em class="gray">06.30</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.25</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.27</em></a></td>
							  <td><a class="tips"  href="#">&yen;<strong>320</strong> <em class="gray">06.28</em></a></td>
							</tr>
							
						  </table>						  
						  </td>
					  </tr>
					</table>
				  </div>				
			  </div>
			</div>
			<!-- 特价机票 end -->
	</div>
	<div class="clear"></div>
	<div class="ad mt20"><a href="#"><img src="ticket_el/images/huoche_ad_2.png" width="1200" height="84" /></a></div>
</div>
</div>

<!--cont -->
<ww:include page="../footer.jsp" />
</body>
</html>
<script>

 var test1=new Vcity.CitySelector({input:'scityname'});
 var test2=new Vcity.CitySelector({input:'ecityname'});
 

</script>
