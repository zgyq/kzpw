<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-机票首页</title>
<link href="ticket_el/css/cn_index.css" rel="stylesheet" type="text/css" media="all" />
<link href="ticket_el/css/001.css" rel="stylesheet" type="text/css" media="all" />
<link href="ticket_el/css/index.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="ticket_el/js/kxbdMarquee.js"></script>
<script type="text/javascript" src="ticket_el/js/tab.js"></script>
<script type="text/javascript" src="ticket_el/js/jquery.js"></script>





<script type=text/javascript src="js/city-control/popdg_div.js?v=0" ></script>
<script type=text/javascript src="js/city-control/city.js"></script>
<script type="text/javascript" src="js/city-control/ticket.js?v=3_1_7_1"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link href="js/city-control/citycontrol.css" rel="stylesheet" />
<link href="js/city-control/base.css" rel="stylesheet" />
<link rel=stylesheet type=text/css href="js/city-control/city.css" />


<script type="text/javascript" src="js/ticket/list.js"></script>
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jason/json2.js" type="text/javascript"></script>




<script type="text/javascript">
<!--图片无缝滚动 -->

	
	//页面加载
    $(document).ready(function()
	   {

	//$("#txtStartDate").val(getDateyyyyMMdd(3));

	    //默认加载当日日期
    
	  
	  
	  $("#txtStartDate").val(getDateyyyyMMdd(3));
	  
	  
	  
	 });	   
	 
	function getDateyyyyMMdd(num) {
	//alert(num);
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
		   
 //查询航班信息
	 function search_air()
	 { 		   
	 
var rdoFrom=document.getElementById("rdoRoundWay");
	if(rdoFrom.checked==true && $("#txtbackdate").val()==""){//flightType
	   alert("返回日期不能为空!!!");
		return;
	}
	
	 	document.form_air.action="ticticket!toTicketList.jspx";
	     document.form_air.method = "POST"; 
         document.form_air.submit();
         }
</script>
</head>

<body id="mainbody">
<!-- ===================== header start ===================== -->
<ww:include page="../top.jsp?index=1&subindex=1" />
<!-- ===================== header end ===================== -->


<!--end header -->
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
<form name="form_air" id="form_air" method="post" action="ticticket!toTicketList.jspx">
<div class="ban_jipiao">
	<div class="jipaiobox wrap">
		<div class="searchbox" id="index">
			<div id="mainsearch" class="mainsearch">
			  <div class="search_bg">
				<h1>
				  <ul class="title cxl SwapTab">
					<li class="a on">国内机票</li>
					<li class="b">国际及港澳台机票</li>
				  </ul>
				</h1>
				<div class="tab-content">
				<div id="domesticBox">
				  <div class="flight_type">
					<label class="type">
					<input type="radio" class="radio" name="s_traveltype" value="1" method="oneway" checked="checked"/>
					单程</label>
					<label class="ml10 type">
					<input type="radio" class="radio" name="s_traveltype" id="rdoRoundWay" value="2" method="round"/>
					往返</label>
				  </div>
				  <div class="guonei" method="Round"> <span id="changecity" method="changecity" class="change_city" title="互换出发到达城市"></span>
					<ul style="display: block">
					  <li><span class="text">出发城市</span>
						<input maxlength="20" type="text" class="intxt" 
						id="Round_DepartCity" type="text"
 							onkeydown="popup_hide();suggest.display('Round_DepartCity','city_from_hide',event);"
							onblur="showSearch('Round_DepartCity','city_from_hide');"
							onfocus="popUp('Round_DepartCity','city_from_hide')"
							onclick="popUp('Round_DepartCity','city_from_hide')"
							name="s_depcityname"
						    value="北京" x-webkit-speech="x-webkit-speech" citynameen="Beijing"/>
			<input type="hidden" id="city_from_hide" name="s_depcitycode" value="PEK" />
					  </li>
					  <li><span class="text">到达城市</span>
						<input maxlength="20" type="text" class="intxt" id="Round_ArriveCity" name="s_arrcityname" type="text"
							onkeydown="popup_hide();suggest.display('Round_ArriveCity','city_to_hide',event);"
							autocomplete="off" onblur="showSearch('Round_ArriveCity','city_to_hide');"
							onfocus="popUp('Round_ArriveCity','city_to_hide')"
							onclick="popUp('Round_ArriveCity','city_to_hide')"
										value="上海" x-webkit-speech="x-webkit-speech" citynameen="Shanghai"/>
						<input type="hidden" id="city_to_hide" name="s_arrcitycode"
		value="SHA" />
		
					  </li>
					  <li class="pos"><span class="text">出发日期</span>
						<input name="s_startdate" id="txtStartDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d', onpicked:function(){dtBackDate.focus();}})" maxlength="20" type="text" class="intxt depart"     />
						</li>
					  <li class="pos" method="Round"><span class="text">返程日期</span>
						<input id="txtbackdate" name="s_backdate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+2}-%d', onpicked:function(){dtBackDate.focus();}})" maxlength="20" type="text" class="intxt return"  method="Date"/>
						</li>
					  <li style="display: none;"><span class="text">舱位等级</span>
					  <script type="text/javascript">
						  function switchSysBar(){
								if (switchPoint.innerText==3){
									switchPoint.innerText=4;
									document.getElementById("frmTitle").className="box";
								}
								else{
									switchPoint.innerText=3;
									document.getElementById("frmTitle").className="box2";
								}
							}
							
						  </script>
						<div id="ClassType" class="droplist" onclick="switchSysBar();"> 
						<SPAN id="switchPoint" style="display:none;">4</SPAN>
						<span class="value" id="changname">经济舱</span>
						  <ul class="box" id="frmTitle">
							<li code="Y">经济舱</li>
							<li code="S">超级/高端经济舱</li>
							<li code="M">商务舱/头等舱</li>
						  </ul>						  
						</div>
						<input type="hidden" id="ClassType" name="ClassType" value="Y"/>
					  </li>
					</ul>
				  </div>
				</div>
				<div id="interBox" style="display:none;">
				  <div class="flight_type">
					<label class="type">
					<input type="radio" class="radio" name="iFlightType" value="0" method="ioneway"/>
					单程</label>
					<label class="ml10 type">
					<input type="radio" class="radio" name="iFlightType" value="1" method="iround" checked="checked"/>
					往返</label>
					<label
								class="ml10 type">
					<input type="radio" class="radio" name="iFlightType" value="2" method="imulti"/>
					联程</label>
				  </div>
				  <div class="liancheng" style="display: none;" method="iMultiDest">
					<input type="hidden" value="2" id="FlightLength" />
					<ul>
					  <li class="pos"><span class="num"><em>1</em>程</span><span class="text">出发城市</span>
						<input type="text" class="intxt" id="Multi1_Dept_CityName" name="Multi1_Dept_CityName" citytype="Domestic" value="北京" citythreesign="BJS"/>
						<span class="text">到达城市</span>
						<input type="text" class="intxt" id="Multi1_Arrive_CityName" name="Multi1_Arrive_CityName" citytype="International"/>
						<span class="text">出发日期</span>
						<input type="text" class="intxt depart" name="Multi1_Dept_Date" method="Date" maxlength="10" value="2014-07-05"/>
						<span class="dateinfo" method="dateinfo">星期六</span></li>
					  <li class="pos"><span class="num"><em>2</em>程</span><span class="text">出发城市</span>
						<input type="text" class="intxt" id="Multi2_Dept_CityName" name="Multi2_Dept_CityName" citytype="Domestic"/>
						<span class="text">到达城市</span>
						<input type="text" class="intxt" id="Multi2_Arrive_CityName" name="Multi2_Arrive_CityName" citytype="International"/>
						<span class="text">出发日期</span>
						<input type="text" class="intxt depart" name="Multi2_Dept_Date" value="2014-07-08" method="Date" maxlength="10"/>
						<span class="dateinfo" method="dateinfo">星期二</span></li>
					  <li class="pos" id="ThirdTrip" style="display:none;"><span class="num"><em>3</em>程</span><span class="text">出发城市</span>
						<input type="text" class="intxt" id="Multi3_Dept_CityName" name="Multi3_Dept_CityName" citytype="Domestic"/>
						<span class="text">到达城市</span>
						<input type="text" class="intxt" id="Multi3_Arrive_CityName" name="Multi3_Arrive_CityName" citytype="International"/>
						<span class="text">出发日期</span>
						<input type="text" class="intxt depart" name="Multi3_Dept_Date" value="2014-07-11" method="Date" maxlength="10"/>
						<span class="dateinfo" method="dateinfo">星期五</span><span class="del" title="删除" method="DelThird" id="btnDel3"></span></li>
					  <li class="pos" id="FourthTrip" style="display:none;"><span class="num"><em>4</em>程</span><span class="text">出发城市</span>
						<input type="text" class="intxt" id="Multi4_Dept_CityName" name="Multi4_Dept_CityName" citytype="Domestic"/>
						<span class="text">到达城市</span>
						<input type="text" class="intxt" id="Multi4_Arrive_CityName" name="Multi4_Arrive_CityName" citytype="International"/>
						<span class="text">出发日期</span>
						<input type="text" class="intxt depart" name="Multi4_Dept_Date" value="2014-07-14" method="Date" maxlength="10"/>
						<span class="dateinfo" method="dateinfo">星期一</span><span class="del" title="删除" method="DelFourth" id="btnDel4"></span></li>
					</ul>
					<p class="tr"> <span class="add" id="AddTrip" method="AddTrip" title="最多可以选择四段航程">增加航程</span></p>
					<ul class="other other2">
					  <li><span class="text">舱位等级</span>
						<div idtag="multiClassType" class="droplist"> <span class="value">经济舱</span>
						  <ul class="box">
							<li code="Y">经济舱</li>
							<li code="C">商务舱</li>
							<li code="F">头等舱</li>
						  </ul>
						</div>
						<input type="hidden" id="multiClassType" name="ClassType" value="Y"/>
						<span class="text">乘客类型</span>
						<div idtag="multiAdultType" class="droplist"> <span class="value">成人</span>
						  <ul class="box">
							<li code="0">成人</li>
							<li code="1">学生</li>
						  </ul>
						</div>
						<input type="hidden" id="multiAdultType" name="SearchInfo_AdultType" value="0"/>
						<span class="text">乘客人数</span><span class="mr5">成人</span>
						<div idtag="multiPCount" class="droplist persons"> <span class="value">1</span>
						  <ul class="box">
							<li code="1">1</li>
							<li code="2">2</li>
							<li code="3">3</li>
							<li code="4">4</li>
							<li code="5">5</li>
							<li code="6">6</li>
							<li code="7">7</li>
							<li code="8">8</li>
							<li code="9">9</li>
						  </ul>
						</div>
						<input type="hidden" id="multiPCount" name="PassengerCount" value="1"/>
						<span class="mr5 ml10">儿童</span>
						<div idtag="multiCCount" class="droplist persons"> <span class="value">0</span>
						  <ul class="box">
							<li code="0">0</li>
							<li code="1">1</li>
							<li code="2">2</li>
						  </ul>
						</div>
						<input type="hidden" id="multiCCount" name="ChildCount" value="0"/>
					  </li>
					</ul>
				  </div>
				  <div class="guoji" method="iRound">
					<ul>
					  <li><span class="text">出发城市</span>
						<input type="text" x-webkit-speech="x-webkit-speech" class="intxt" id="Dept_CityName" name="Dept_CityName" citytype="Domestic" value="北京" citynameen="Beijing" citythreesign="BJS"/>
					  </li>
					  <li><span class="text">到达城市</span>
						<input type="text" x-webkit-speech="x-webkit-speech" class="intxt" id="Arrive_CityName" name="Arrive_CityName" citytype="International"/>
					  </li>
					  <li class="pos"><span class="text">出发日期</span>
						<input id="hdnStartDate" name="Dept_Date" value="2014-07-05"
											method="Date" type="text" maxlength="10" class="intxt depart" />
						<span class="dateinfo" method="dateinfo">星期六</span></li>
					  <li class="pos" method="iRound"><span class="text">返程日期</span>
						<input id="hdnEndDate" name="Back_Date" value="2014-07-08"
											method="Date" type="text" maxlength="10" class="intxt return" />
						<span class="dateinfo" method="dateinfo">星期二</span></li>
					  <li><span class="text">舱位等级</span>
						<div idtag="RoundClassType" class="droplist"> <span class="value">经济舱</span>
						  <ul class="box">
							<li code="Y">经济舱</li>
							<li code="C">商务舱</li>
							<li code="F">头等舱</li>
						  </ul>
						</div>
						<input type="hidden" id="RoundClassType" name="ClassType" value="Y"/>
					  </li>
					  <li><span class="text">乘客类型</span>
						<div idtag="RoundAdultType" class="droplist"> <span class="value">成人</span>
						  <ul class="box">
							<li code="0">成人</li>
							<li code="1">学生</li>
						  </ul>
						</div>
						<input type="hidden" id="RoundAdultType" name="SearchInfo_AdultType" value="0"/>
					  </li>
					  <li><span class="text">乘客人数</span><span class="mr5">成人</span>
						<div idtag="RoundPCount" class="droplist persons"> <span class="value">1</span>
						  <ul class="box">
							<li code="1">1</li>
							<li code="2">2</li>
							<li code="3">3</li>
							<li code="4">4</li>
							<li code="5">5</li>
							<li code="6">6</li>
							<li code="7">7</li>
							<li code="8">8</li>
							<li code="9">9</li>
						  </ul>
						</div>
						<input type="hidden" id="RoundPCount" name="PassengerCount" value="1"/>
						<span class="mr5 ml10">儿童</span>
						<div idtag="RoundCCount" class="droplist persons"> <span class="value">0</span>
						  <ul class="box">
							<li code="0">0</li>
							<li code="1">1</li>
							<li code="2">2</li>
						  </ul>
						</div>
						<input type="hidden" id="RoundCCount" name="ChildCount" value="0"/>
					  </li>
					</ul>
				  </div>
				</div>
				</div>
				<div class="searchbtnbox">
				  <input type="button" class="searchbtn" id="btnSearch" onclick="search_air();" />
				  <div id="searchboxwait" style="display:none;">
					<input type="button" class="searchbtn_no" value="正在搜索" />
					<span class="loading"></span> </div>
				</div>
			  </div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
</form>

<!--end banner -->
<div class="contmain wrap mt20">
	<div class="jp_left">
		<div class="ad">
		<!--
		<a href="#"><img src="ticket_el/images/ad_jp1.jpg" width="340" height="95" /></a>
		-->
		<img src="ticket_el/images/ad_jp2.jpg" width="340" height="140" />
		<img src="ticket_el/images/ad_jp3.jpg" width="340" height="300" />
		</div>
		<div class="templateBox f_m_top">
			<div class="templateTitle">
				<h3 class="templateTitleH f_size16">机票工具箱</h3>
				<a href="#" class="templateLink" rel="nofollow">更多&gt;&gt;</a>
			</div>
			<div class="templateMain f_p_a toolbox_main">
				<div style="padding: 10px 0px 10px 0px;">
					<a href="index!yanzheng.jspx" class="toolbox_link" ><span class="toolbox_bg toolbox_bg01"></span>
						<p>机票验真</p>
					</a>
					<a href="index!dongtai.jspx" class="toolbox_link" ><span class="toolbox_bg toolbox_bg02"></span>
						<p>航班时刻</p>
					</a>
					<a href="index!tianqiyubao.jspx" class="toolbox_link" ><span class="toolbox_bg toolbox_bg03"></span>
						<p>天气预报</p>
					</a>	
					 <a href="#" class="toolbox_link" ><span class="toolbox_bg toolbox_bg04"></span>
						<p>在线选座</p>
					</a>
					<a href="#" class="toolbox_link" ><span class="toolbox_bg toolbox_bg05"></span>
						<p>机场指南</p>
					</a>				
					<a id="flightStrategy" href="#" class="toolbox_link">
						<span class="toolbox_bg toolbox_bg06"></span>
						<p>飞行攻略</p>
						<span class="toolbox_bg tips_new"></span>
					</a>
				</div>
				
			</div>				
		</div>
	</div>
	<div class="jp_right">
		<div class="box1">
			<!-- 航空公司官网 start airlines_logo -->
			<div class="airlines_box">
    		<div id="portal-block-358532204231" class="udiyblock"  type="AdModel">                     
			<span class="airlines_title">官网<br />专区</span>
                	<!-- 上一个 -->
                    <a href="javascript:;" rel="nofollow" class="group_btnL">
                        <span class="btn_01"></span>
                    </a>
                    <div class="airlines_over">
                        <ul class="airlines_ul">
                            <li>
                                <a href="#" title="南方航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_CZ"></span>
                                    <p>南方航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="东方航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_MU"></span>
                                    <p>东方航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="海南航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_HU"></span>
                                    <p>海南航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="深圳航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_ZH"></span>
                                    <p>深圳航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="四川航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_3U"></span>
                                    <p>四川航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="春秋航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_9C"></span>
                                    <p>春秋航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="吉祥航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_HO"></span>
                                    <p>吉祥航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="天津航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_GS"></span>
                                    <p>天津航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="西部航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_PN"></span>
                                    <p>西部航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="祥鹏航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_8L"></span>
                                    <p>祥鹏航空</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" title="首都航空" class="airlines_link" target="_blank" rel="nofollow">
                                    <span class="flightLB_32 flightLBP_JD"></span>
                                    <p>首都航空</p>
                                </a>
                            </li> 
                        </ul>
                    </div>
                	<!-- 下一个 -->
                    <a href="javascript:;" rel="nofollow" class="group_btnR">
                        <span class="btn_02"></span>
                    </a></div>
			</div>
			<script type="text/javascript"  src="js/hkgs.js" ></script>
<!-- 航空公司官网 end -->

		</div>
		<div class="box2">
			<!-- 特价机票 start -->
			<div>
      <div id="Layer1"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000">
        <param name="movie" value="banner3.swf" />
        <param name="quality" value="high" />
        <embed src="http://www.dhidcw.com/dhidcw/TopMenu1/banner3.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="832" height="245"></embed>
      </object></div>
    </div>
			
			<!-- 特价机票 end -->

		</div>
		<div class="box3 mt10">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  <tr>
				<td class="title">未来30天内最低票价</td>
				<td align="right"><input name="" type="text" value="北京" /></td>
				<td align="center" width="50"><em class="arrows">→</em></td>
				<td><input name="" type="text" value="上海" /></td>
				<td width="200"><input name="" type="button" value="查询" class="btn" /></td>
			  </tr>
			</table>
		</div>
		<div class="box4 mt20">
			<a href="#"><img src="ticket_el/images/ad_jp4.jpg" width="840" height="270" /></a>
		</div>
	</div>
	<div class="clear"></div>	
</div>
<!--cont -->
<ww:include page="../footer.jsp" />

</body>
</html>
