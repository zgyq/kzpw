<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-国内机票首页</title>
<ww:head name="air" jsURL="ticketindex" />
<script type="text/javascript">
    //页面加载
    $(document).ready(function()
	   {
	    //返程日期隐藏
	    <ww:if test="s_traveltype==1">
	    $("#txtbackdate").attr("disabled","disabled");
	    </ww:if>
	    <ww:else>
	    $("#txtbackdate").removeAttr("disabled");
	    </ww:else>
	    //加载城市控件数据
	    $("#txtDepCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    $("#ticDepCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidDepCity_tic',onSelect:function(){$("#ticArrCity").click();}, attachObject:'#suggest4'});
	    $("#ticArrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidArrCity_tic',onSelect:function(){}, attachObject:'#suggest5'});

	    $("#txtDepCity").val("北京");
	    $("#hidDepCity").val("PEK");
	    //默认加载当日日期
      var d=new Date();
	  var str = d.format('yyyy-MM-dd');  
	  $("#txtstartdate").val(getDateyyyyMMdd(3));
	    
	
	
      showFlash();
      chagecity("PEK");
	 });
	  //单程往返类型
	 function bindFlightType(index)
	 {
	    if(index==1)
	    {
	       $("#txtbackdate").attr("disabled","disabled");
	       $("#txtbackdate").val("返");
	    }
	    else if(index==2)
	    {
	       $("#txtbackdate").removeAttr("disabled");
	    }
	 }
	 function clearText(text)
	 {
	     if($("#"+text).val()=="往" || $("#"+text).val()=="返")
	     {
	         $("#"+text).val("");
	     }
	 }
	 
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
	 
	 //查询航班信息
	 function search()
	 {  
	 	 	
	 	 		
	 //判断城市是否空
	 if($("#txtDepCity").val()==""){
	  //验证提示
	 $('#txtDepCity').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	 $("#txtDepCity").focus();
	 
	 return false; 
	 }
	 if($("#txtArrCity").val()=="" || $("#txtArrCity").val()=="中文/拼音"){
	  $('#txtArrCity').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	 $("#txtArrCity").focus();
	 
	 return false; 
	 }
	  //判断出发时间空否
	    if($("#txtstartdate").val()=="" || $("#txtstartdate").val()=="往"){
	    
	    $("#txtstartdate").focus(); 
	      $('#txtstartdate').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	    return false; 
	    }
	    //判断到达时间是否空 为空选中单程
	    if($("#txtbackdate").val()=="" || $("#txtbackdate").val()=="返"){
	    
	    $("#rdoRoundWay").attr("checked",false);
	    //选中单程
	    $("#rdoOneWay").attr("checked",true);
	    $("#li_returndate").hide();
	    } 
	 //判断起始日期大小
	  //gaoliang
	 //2011-11-19
	    if(Computation($("#txtstartdate").val(),$("#txtbackdate").val())>0){
	    
	    $("#txtbackdate").focus();
	    
	    $("#txtbackdate").select();
	     return false; 
	    }
	    
	   loading("航班信息");
	     document.form1.action="ticticket!toTicketList.jspx";
	     document.form1.method = "POST"; 
         document.form1.submit();
         
	 	
	 		
	    
	 }
	 function loading(context)
	 {
	   //遮罩 
        $.blockUI({ message: '<h1><img src="images/loadding.gif" /> 正在为你查询'+context+',请稍候...</h1>' });
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

<body >
<ww:i18n name="'language'">

	<div>
	<div class="cen" style="position: relative;">
		<ww:include page="../top.jsp?index=1&subindex=1" />
	</div>
	</div>	
	
	<!--includ top 直接替换掉整个DIV-->
	<!--top over-->
	
<div id="main" style="margin-top: 0px;">
	<div id="left" class="f" style=" width:770px;">
		<div class="f" style=" width:260px;">
			<form name="form1" id="form1" method="post">
				<div class="search"><font class="black">国内机票搜索</font></div>
				<div class="box_sea searchlist">
					<ul>
						<li class="choose"><input name="s_traveltype" id="rdoOneWay"
							type="radio" value="1"
							<ww:if test="s_traveltype==1">checked="checked"</ww:if>
							onclick="bindFlightType(1);" /> <span class="mr15"> <ww:text
							name="'OneWay'" /></span> <input name="s_traveltype" id="rdoRoundWay"
							type="radio" value="2"
							<ww:if test="s_traveltype==2">checked="checked"</ww:if>
							onclick="bindFlightType(2);" /> <ww:text name="'Return'" /></li>
						<li class="searchall"><ww:text name="'DepartureCity'" />：<input
							type="text" id="txtDepCity" name="s_depcityname" class="text_search"
							value="<ww:property value='s_depcityname' />" title="请输入出发城市" />
						<div id='suggest' class="ac_results"></div>
						<input type="hidden" id="hidDepCity" name="s_depcitycode"
							value="<ww:property value='s_depcitycode'/>" /></li>
						<li class="searchall"><ww:text name="'ArrivalCity'" />：<input
							type="text" id="txtArrCity" name="s_arrcityname" class="text_search"
							value="<ww:property value='s_arrcityname' />" title="请输入到达城市" />
						<div id='suggest2' class="ac_results"></div>
						<input type="hidden" id="hidArrCity" name="s_arrcitycode"
							value="<ww:property value='s_arrcitycode' />" /></li>
						<li class="searchall"><ww:text name="'DepartureTime'" />：<input
							type="text" id="txtstartdate" name="s_startdate"
							onfocus="clearText('txtstartdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
							class="text_searchwf"
							value='<ww:if test='s_startdate!=null && !s_startdate.equals("")'><ww:property value="s_startdate" /></ww:if><ww:else>往</ww:else>'
							title="请输入出发时间" /> <input type="text" name="s_backdate"
							id="txtbackdate"
							onfocus="clearText('txtbackdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
							class="text_searchwf"
							value='<ww:if test='s_backdate!=null && !s_backdate.equals("")'><ww:property value="s_backdate" /></ww:if><ww:else>返</ww:else>' />
						</li>
						<li class="searchall">航空公司：<select name="s_aircompanycode" class="sel_search">
							<option value="">---所有航空公司---</option>
							<ww:iterator value="listAirCompany">
								<option value="<ww:property value='aircomcode' />"><ww:property
									value="aircomcode" /><ww:property value="aircomcnname" /></option>
							</ww:iterator>
						</select></li>
						<li class="but" style=" height:40px; padding:5px 0; text-align:center;">
							
							<span><input type="button" class="bst" value="立即搜索" id="btnsearch" onclick="search();" /></span>
						</li>
					</ul>
				</div>
			</form>
		</div>
		<!-- <div class="searchbot"></div> -->
		<div class="r" style="height: 260px; width:499px; overflow:hidden;">
			 <ww:include page="air5tu.htm"></ww:include>
			<!--<img src="images/hotelindex/ad-01.jpg" width="499" height="260" />
			-->
		</div>
		
		<div class="c"></div>
		
		<div class="f">
			<div class="mt7 box">
				<div class="tit">
					<font class="black low2 f mr15">未来30天内最低票价</font>
					<input type="text" class="text_low2 f" name="ticDepCity" id="ticDepCity" value="北京" onfocus="if(this.value='北京'){this.value='';}" onblur="if(this.value=='') {this.value='北京';}" />
					<div id='suggest4' class="ac_results"></div>
					<input type="hidden" id="hidDepCity_tic" name="StartAirportCode" value="PEK" />
					<font class="f">→</font>
					<input type="text" class="text_low2 f" id="ticArrCity" value="上海" name="ticArrCity" onfocus="if(this.value='上海'){this.value='';}" onblur="if(this.value=='') {this.value='上海';}" />
					<div id='suggest5' class="ac_results"></div>
					<input type="hidden" id="hidArrCity_tic" name="EndAirportCode" value="SHA" />
					<input type="button"  value="查询" onclick="showFlash();" />
					<span class="c"></span>
				</div>
				<div class="flash">
					<div id="flash_chart"></div>
				</div>
			</div>
			<!--flash低价over-->
		
			<div class="mt7 box" style="display: none">
				<div class="tit">
					<font class="black low2 f mr15">国内超低折扣机票</font>
					<div class="f city">
						<input id="ul2" type="text" class="text_city2 c999" onclick="showul()" value="请选择" />
						<ul class="city_ul box" style="display: none" id="ul1">
							<li><a href="javascript:void(0);" onclick="chagecity('PEK');" class="c999">北京</a></li>
							<li><a href="javascript:void(0);" onclick="chagecity('SHA');" class="c999">上海</a></li>
							<li><a href="javascript:void(0);" onclick="chagecity('CEN');" class="c999">广州</a></li>
							<li><a href="javascript:void(0);" onclick="chagecity('SIA');" class="c999">西安</a></li>
							<li><a href="javascript:void(0);" onclick="chagecity('HGH');" class="c999">杭州</a></li>
							<li><a href="javascript:void(0);" onclick="chagecity('DLC');" class="c999">大连</a></li>
							<li><a href="javascript:void(0);" onclick="chagecity('WNZ');" class="c999">温州</a></li>
						</ul>
					</div>
					<span class="c"></span>
				</div>
				<!--titel over-->
				<div class="tips">航线小贴士： 日本放宽飞机乘客使用手机 | 原油价格高涨澳洲航空上调机票价格5% | 航班延误超4小时可获现</div>
				<div class="lowlist">
					<div style=" width:868px;">
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
		</div>
	</div>
	<!--search over-->
	
	<div id="right" class="r" style=" width:223px;">
		<div class="adbox">
			<div class="r">
				<div class="titleinfo"><font class="black">最新资讯</font></div>
				<div class="box_tell" style="border-top:none;">
					<ul>
						<ww:iterator value="ListInformationinfo">
							<li title="<ww:property value="name" />">
								<a href="index!toInformationinfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>">
								<ww:if test="name.length()>16">
								<ww:property value="SubString(name,14)"/>...
								</ww:if><ww:else>
								<ww:property value="name" />
								</ww:else>
								</a>
							</li>
						</ww:iterator>
					</ul>
				</div>
			</div>
		</div>
		<div style="width:223px;">
			<div class="ad mt7">
			&nbsp;
			<!--
			<img src="images/ad_ticket_01.jpg" width="223" height="100" />
			-->
			</div>
			<div class="tit mt7" style=" border:1px solid #E3E3E3; border-bottom:none;">
				<font class="black" style=" padding-left:10px;"><ww:property value="GetInfoTypeNameById(typeid)" /></font>
			</div>
			<div class="box content" style=" border-top:none;">
				<ul>
					<ww:iterator value="Listhelpcenterinfo">
						<li title="<ww:property value="name" />"><a href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>">
						<ww:if test="name.length()>16">
						<ww:property value="SubString(name,14)"/>...
						</ww:if><ww:else>
						<ww:property value="name" />
						</ww:else>
						</a></li>
					</ww:iterator>
				</ul>
			</div>
		</div>
	</div>
	<!--图片AD 资讯-->

</div>
<!--container over-->
<ww:include page="../footer.jsp" />
</ww:i18n>
</body>
</html>
