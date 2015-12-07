<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-国际机票首页</title>
<ww:head name="inter" jsURL="international" />
<script src="interjs/interaircity.js" type=text/javascript></script>
<script src="interjs/popdg_div.js" type=text/javascript></script>
<script src="interjs/city.js" type=text/javascript></script>
<link rel=stylesheet type=text/css href="interjs/city.css" />
<script type="text/javascript">
  $(document).ready(function()
  {
   	//$("#fromCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hideFromCityCode',onSelect:function(){$("#arrCity").click();}, attachObject:'#suggest'});
	 //   $("#arrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hideArrCityCode',onSelect:function(){}, attachObject:'#suggest2'});
     //默认加载当日日期
      var d=new Date();
	  var str = d.format('yyyy-MM-dd');  
	  $("#fromTime").val(str);
  });
</script>




</head>

<body id="mainbody">

<ww:i18n name="'language'">
	<div>
	<div class="cen" style="position: relative;">
	<ww:include page="../top.jsp?index=1&subindex=2" />
</div>
	</div>
	<div id="main">
	<div id="left" class="f">
	<div align="center"><font
		class="font-f60-24">${compname}为您提供准确的国际航班信息查询！</font></div>
	<div class="searh-box">
	<form name="form1" id="form1" method="post">
	<div class="searh f">
	
	
	<ul>
		<li><span class="f  mr15">&nbsp;</span><font class="black">航班类型</font></li>
		<li class="lh30 mf31"><input name="intertype" id="radioOne"
			onclick="radioSelect(1);" type="radio" class="" value="1" checked="checked"
			 /><ww:text
			name="'OneWay'" /> <input name="intertype" id="radioTwo"
			type="radio" value="2" onclick="radioSelect(2);" 
			/><ww:text
			name="'Return'" /></li>
		<li class="nohave"></li>
		<li class="nohave box_top">&nbsp;</li>
		
		<li><span class="f  mr15">&nbsp;</span><font class="black">航程信息</font></li>
		<li class="lh30 mf36"><ww:text name="'DepartureCity'" />：<input
			onkeydown="popup_hide();suggest.display('fromCity','hideFromCityCode',event);"
			onblur="showSearch(id,1);"
			onfocus="popUp('fromCity','hideFromCityCode')"
			onclick="popUp('fromCity','hideFromCityCode')"   style="COLOR: #c1c1c1"
			type="text" class="text_intersea" id="fromCity" name="fromCity" />
		<div id='suggest' class="ac_results"></div>
		<input type="hidden" id="hideFromCityCode" value="BJS"
			name="hideFromCityCode" /></li>

		<li class="lh30 mf36"><ww:text name="'ArrivalCity'" />：<input
			onkeydown="popup_hide();suggest.display('arrCity','hideArrCityCode',event);"
			onblur="showSearch(id,1);"
			onfocus="popUp('arrCity','hideArrCityCode')"
			onclick="popUp('arrCity','hideArrCityCode')" style="COLOR: #c1c1c1"
			type="text" class="text_intersea" id="arrCity" name="arrCity" />
		<div id='suggest2' class="ac_results"></div>
		<input type="hidden" id="hideArrCityCode" name="hideArrCityCode" /></li>


		<li class="lh30 mf36"><ww:text name="'DepartureTime'" />：<input
			type="text" id="fromTime" name="fromTime" class="text_intersea"
			onClick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})" /></li>
		<li id="lireturnTime" class="lh30 mf36">返回时间：<input type="text"
			id="returnTime" class="text_intersea"
			onClick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			name="returnTime" /></li>
		<li class="nohave"></li>
		<li class="nohave box_top">&nbsp;</li>
		<li><span class="f  mr15">&nbsp;</span><font class="black">乘机信息</font></li>
		<li class="lh30 mf36">乘客类型：<select class="sel_intersea"
			name="passengerType">
			<option value="1">成人</option>
			<option value="2">儿童</option>
		</select></li>
		<li class="lh30 mf36">乘客数量：<select class="sel_intersea"
			name="passengerNum">
			<option value="1">1人</option>
			<option value="2">2人</option>
			<option value="3">3人</option>
			<option value="4">4人</option>
			<option value="5">5人</option>
			<option value="6">6人</option>
			<option value="7">7人</option>
			<option value="8">8人</option>
			<option value="9">9人</option>
		</select></li>
		<li class="lh30 mf36">舱位等级：<select class="sel_intersea"
			name="Lvspace">
			<option value="Y">特价舱</option>
			<option value="C">商务舱</option>
			<option value="F">头等舱</option>
		</select></li>
		<li class="nohave"></li>
		<li class="nohave box_top">&nbsp;</li>
		<li class=" mf75"><input type="button" class="bnt_intersea fff"
			value="查询航班" onclick="checkBotton();"  /></li>
	</ul>
	</div>
	<div class="ad r" style="display: none"><img src="images/ad_inter.jpg" width="223"
		height="344" /></div>
		
	<div class="c"></div>
	</form>
	</div>
	</div>
	<!--left over-->
	<div id="right" class="r">
	<div class="titlelogin"><font class="black">国际机票帮助信息</font></div>
	<div class="box_sea">
	<ul class="inter-information">
		<li class="nohave">&nbsp;</li>
		 <ww:iterator value="listZX">
                   <li><span class="ico_inter-information f">&nbsp;</span>
	                   	<a href="index!tohelp.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>"> <ww:if test="name.length()>23">
						<ww:property value="SubString(name,20)"/>...
						</ww:if><ww:else>
						<ww:property value="name"/>
						</ww:else>
						</a>
					</li>
                   </ww:iterator>
		
		
		<li class="nohave">&nbsp;</li>
	</ul>
	</div>
	<div class="loginbot"></div>
	<div class="nohave">&nbsp;</div>
	<div><img src="images/ad_interright.jpg" width="260" height="88" /></div>
	<div class="nohave">&nbsp;</div>
	<div><img src="images/ad_interrightto.jpg" width="260"
		height="88" /></div>
	</div>
	<!--right over--></div>
	<!--container over--> <ww:include page="../footer.jsp" />
</ww:i18n>
</body>
</html>
