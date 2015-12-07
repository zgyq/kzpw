<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-国内机票首页</title>
<link type="text/css" rel="stylesheet" href="ticket/css/styleAir.css">
    
<!-- airjs -->
<script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>  


<script type="text/javascript" src="main_cx/js/city.js"></script>
<script type="text/javascript" src="main_cx/js/popdg_div.js"></script>
<link href="main_cx/css/autocomplete.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>


<script src="js/jquery/jquery.poshytip.js" type="text/javascript"></script>
<script src="js/citycontrol/jquery.blockUI.js" type="text/javascript"></script>
<script src="js/citycontrol/PublicJs.js" type="text/javascript"></script>



<script>
    //页面加载
    $(document).ready(function()
	   {
	    //默认加载当日日期
	  $("#txtstartdate").val(getDateyyyyMMdd(3));
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
	 
function huhuanguonei(){

var txtStartCity=$("#txtStartCity").val();
var hidStarCityCode=$("#hidStarCityCode").val();
var txtEndCity=$("#txtEndCity").val();
var hidEndCityCode=$("#hidEndCityCode").val();

$("#txtStartCity").val(txtEndCity);
$("#hidStarCityCode").val(hidEndCityCode);
$("#txtEndCity").val(txtStartCity);
$("#hidEndCityCode").val(hidStarCityCode);


}
 function clearText(text)
	 {
	     if($("#"+text).val()=="往" || $("#"+text).val()=="返")
	     {
	         $("#"+text).val("");
	     }
	 }
	 
	 
	 
	  //查询航班信息
	 function search_sub()
	 {  
	 	 		
	 //判断城市是否空
	 if($("#txtStartCity").val()==""){
	  //验证提示
	 alert("出发城市不能为空!");
	 $("#txtStartCity").focus();
	 
	 return false; 
	 }
	 if($("#txtEndCity").val()=="" || $("#txtEndCity").val()=="中文/拼音"){
	  alert("到达城市不能为空!");
	 $("#txtEndCity").focus();
	 
	 return false; 
	 }
	  //判断出发时间空否
	    if($("#txtstartdate").val()=="" || $("#txtstartdate").val()=="往"){
	    
	    alert("出发日期不能为空!");
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
	 
</script>
</head>
<body id="mainbody">
<div class="cen" style="position: relative;">
		<ww:include page="../top.jsp?index=1&subindex=1" />
	</div>
	
<form name="form1" id="form1" method="post">	
<div class="navAir">
    <div class="searchBox2">
        <div class="airTab">
            
            <span><input name="s_traveltype" id="rdoRoundWay" checked="checked" onclick="bindFlightType(1);"
							type="radio" value="1" />单程</span>
							
		<span><input  name="s_traveltype" id="rdoOneWay" onclick="bindFlightType(2);"
							type="radio" value="1"/>往返</span>
							
        </div>
        <div class="goto">
            <div class="gotoBox">
                <p>出发</p>
                <input type="text" id="txtStartCity" value="北京"  onfocus="popUp('txtStartCity','hidStarCityCode')"
	onclick="popUp('txtStartCity','hidStarCityCode')"
	onblur="showSearch('txtStartCity',1)" autocomplete="off"
	onkeyup="popup_hide();suggest.display('txtStartCity','hidStarCityCode',event);" />
	<div id='suggest_form' class="ac_results_air" style="position:fixed"></div>
	    <input type="hidden" id="hidStarCityCode" value="PEK" name="s_depcitycode" />
	    
	    
            </div>
            <div class="changeBox" onclick="huhuanguonei();return false;"></div>
            <div class="gotoBox">
                <p>到达</p>
                <input type="text" id="txtEndCity" name="ArvPort" class="input02" onfocus="popUp('txtEndCity','hidEndCityCode')"
	onclick="popUp('txtEndCity','hidEndCityCode')"
	onblur="showSearch('txtEndCity',1)" autocomplete="off" value="上海"
	onkeyup="popup_hide();suggest.display('txtEndCity','hidEndCityCode',event);"
		nulltips="请输入到达城市名称" holder="城市名" value="上海" />
		
		<div id='suggest_to' class="ac_results_air" ></div>
		<input type="hidden" id="hidEndCityCode" name="s_arrcitycode" value="SHA" />
		
            </div>
        </div>
        <div class="gotoDate">
            <div class="date">
                <p>去程日期</p>
                
                <input type="text" class="Wdate" name="s_startdate" id="txtstartdate" onfocus="clearText('txtstartdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})" />
            </div>
            <div class="space"></div>
            <div class="date1" >
                <p>返程日期</p>
                
                <input type="text" class="Wdate" disabled="disabled" name="s_backdate" id="txtbackdate" onfocus="clearText('txtbackdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})" />
                
                
            </div>

        </div>
        <a href="#" class="btnSearch" id="btnsearch" onclick="search_sub();"></a>
    </div>
</div>
</form>
<div class="airMid">
    <div class="hotLine">
    
        <ul>
            <li>
                <img src="ticket/img/air/ca.jpg" width="220" height="146"/>
                <div class="txt" style="display: none;">
                    <p>中国</p>
                    <p>国际航空</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li>
                <img src="ticket/img/air/mu.jpg" width="220" height="146"/>
                <div class="txt" style="display: none;">
                    <p>中国</p>
                    <p>东方航空</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li>
                <img src="ticket/img/air/cz.jpg" width="220" height="146"/>
                <div class="txt" style="display: none;">
                    <p>中国</p>
                    <p>南方航空</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li class="last">
                <img src="ticket/img/air/hu.jpg" width="220" height="146"/>
                <div class="txt" style="display: none;">
                    <p>中国</p>
                    <p>海南航空</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
        </ul>
    </div>
    <div class="hotLine" style="display: none;">
        <ul>
            <li>
                <img src="ticket/img/hotCity.png"/>
                <div class="txt">
                    <p>中国</p>
                    <p>联合航空</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li>
                <img src="ticket/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li>
                <img src="ticket/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
            <li class="last">
                <img src="ticket/img/hotCity.png"/>
                <div class="txt">
                    <p>韩亚航空</p>
                    <p>亚/美/大洋洲</p>
                    <span><i>￥</i>2099</span>
                </div>
            </li>
        </ul>
    </div>
    <div class="supTxt">
        <ul>
            <li class="td1">
                <h2>即时价格查询</h2>
                <p>
                    我们与航信合作，为你提供机票即时在线价格查询。由于机票价格和航线变动频繁，不同时间搜索票价和航班都会有变化，
                    这一刻搜索到的机票，也许下一秒就已全部售出。所以，该出手时就出手吧！
                </p>
            </li>
            <li class="td2">
                <h2>没有中间商</h2>
                <p>
                    我们帮你大海捞针找到你最想要的航班，之后你可以点击链接直接到航空公司或授权的代理机构进行预订并完成交易。
                    整个预订过程中没有中间商，你不是通过穷游进行预订，穷游也不收取任何费用。
                </p>
            </li>
            <li class="td3">
                <h2>安全有保证</h2>
                <p>
                    我们与第三方支付支付宝,财付通紧密合作!保证你的资金安全,是我们的首要责任!!!
                </p>
            </li>
        </ul>
    </div>
</div>
<ww:include page="../footer.jsp" />
</body>
</html>