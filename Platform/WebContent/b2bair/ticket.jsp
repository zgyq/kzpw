<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="b2bair/css/right.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>

<link href="b2bair/js/city-control/citycontrol.css" rel="stylesheet" />
<link href="b2bair/js/city-control/base.css" rel="stylesheet" />
<link rel=stylesheet type=text/css href="b2bair/js/city-control/city.css" />

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type=text/javascript src="b2bair/js/city-control/popdg_div.js?v=0"></script>
<script type=text/javascript src="b2bair/js/city-control/city.js"></script>
<script type="text/javascript" src="b2bair/js/city-control/ticket.js?v=3_1_7_1"></script>
<script src="js/jquery-1.4.2.min.js" type=text/javascript></script>

<script type="text/javascript">
    //页面加载
    $(document).ready(function()
	   {
	    //默认加载当日日期
	  $("#txtStartDate").val(getDateyyyyMMdd(3));
	
	 });
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

function sub(){
 dispose("系统正在为您查询");
 document.form1.submit();
}

function dispose(message) {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
</script>

 

</head>
<body id="mainbody">


<div id="wrap">
<div class="right" style="height:600px;background:url(b2bair/img/right-bg.jpg) repeat;">
  <div class="searchs">
           <div class="searchs-bg">
           
                <!--搜做框 begin-->
                <form action="b2bair!toTicketList.action" name="form1" id="form1" method="POST" >
                  <div class="search-box">
                         <h1><span></span>国内机票查询</h1>
                         <div class="types">
                                    航程类型: <label><input type="radio" name="s_traveltype"
	value="1" onclick="bindFlightType(1);" id="rdoOneWay" checked="checked" />单程</label>
                                    <label><input type="radio" name="s_traveltype" value="2"
	onclick="bindFlightType(2);" id="rdoRoundWay" />往返</label>
                                    <label><input type="radio" name="s_traveltype" value="3"
	onclick="bindFlightType(3);" id="rdolcWay" />联程</label>
                                   
                              </div>
                              
                              <div class="types">
                                   出发城市: <input type="text" title="出发城市" id="arrcity" value='北京'
	onkeydown="popup_hide();suggest.display('arrcity','city_from_hide',event);"
	onblur="showSearch('arrcity','city_from_hide');"
	onfocus="popUp('arrcity','city_from_hide')"
	onclick="popUp('arrcity','city_from_hide')"
	name="s_depcityname" />
	
	<input type="hidden" id="city_from_hide" name="s_depcitycode" value="PEK" />
                             </div>
                             
                             <div class="types">
                                   到达城市: <input type="text" name="s_arrcityname" id="tocity" value="上海"
							onkeydown="popup_hide();suggest.display('tocity','city_to_hide',event);"
							autocomplete="off" onblur="showSearch('tocity','city_to_hide');"
							onfocus="popUp('tocity','city_to_hide')"
							onclick="popUp('tocity','city_to_hide')" />
	<input type="hidden" id="city_to_hide" name="s_arrcitycode" value="SHA" />
                             </div>
                             
                             <div class="types">
                                  出发日期: <input type="text" class="Wdate" title="出发时间" name="s_startdate" id="txtStartDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d', onpicked:function(){dtBackDate.focus();}})" />
                             </div>
                             <div class="types">
                                  返程日期: <input type="text" class="Wdate" title="出发时间" name="s_backdate" id="s_backdate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d', onpicked:function(){dtBackDate.focus();}})" />
                             </div>
                            
                             
                             <div class="search-btn"><a href="#" onclick="sub();"><img src="b2bair/img/search-btn.gif" width="127" height="41" /></a><span>                                <input type="checkbox" name=""/>柜台查询</span>
                             </div>
                  </div>
                  </form>
                  <!--搜做框 end-->
                  
                 <!-- 新闻通知 begin-->
                  <div class="news-box">
                  
                      <h1><span></span>最新动态</h1>   
                      <ul>
                          <li><a href="#">1.海南东环高铁21日12时开通 美兰站不办理客运业务...</a></li>
                          <li class="gray-bg"><a href="#">2.海南东环高铁21日12时开通 美兰站不办理客运业务...</a></li>
                          <li><a href="#">3.海南东环高铁21日12时开通 美兰站不办理客运业务...</a></li>
                          <li class="gray-bg"><a href="#">4.海南东环高铁21日12时开...</a></li>
                          <li><a href="#">5.海南东环高铁21日12时开通 美兰站不办理客运业务高铁21日12时开...</a></li>
                          <li class="gray-bg"><a href="#">4.海南东环高铁21日12时开通 美兰站不办理客运业务</a></li>
                          <li><a href="#">5.海南东环高铁21日12时开通 美兰站不办理客运业务高铁21日12时开...</a></li>
                          <li><a href="#">5.海南东环高铁21日12时开通 美兰站不办理客运业务</a></li>
                          <li class="gray-bg"><a href="#">4.海南东环高铁21日12时开通 美兰站不办理客运业务</a></li>
                          <li><a href="#">5.海南东环高铁21日12时开通 美兰站不办理客运业务高铁21日12时开...</a></li>
                      
                      </ul>
                  
                  </div>
                  <!-- 新闻通知 end-->
              
              
         </div>     
  
  
  </div>
  
  
</div>

</div>

</body>
</html>
