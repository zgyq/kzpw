<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="UTF-8">
    <title>${compname}-酒店在线预订</title>
    <link type="text/css" rel="stylesheet" href="hotel/css/style2.css">
    <script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
    <script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">

$(document).ready(function(){
  loadCityData();
});
//一下2个位日期控件用
function getDateDiff(date, num){
	var d1 = new Date(eval(date.substring(0, 4)), eval(date.substring(5, 7)) - 1, eval(date.substring(8, 10)));
	num = (typeof(num)=='undefined')?0:num;
	var d2 = new Date(d1.valueOf() + (num*86400000));
    var yy = d2.getFullYear(); 
    var mm = d2.getMonth() + 1; 
    var dd = d2.getDate(); 
    return yy + "-" + getmyselfDate(mm) + "-" + getmyselfDate(dd);
}
function getmyselfDate(a){
    if (a < 10) {
        return "0" + a;
    }
    return a;
}

function sub_form(){
if($('#s_cityandhotelname').val()==''||$('#s_cityandhotelname').val()=='请输入城市名或酒店名'){
alert("请输入城市名或酒店名!!!");
return;
}
document.form_hotel.submit();

}
function setname(cityname){
$('#s_cityandhotelname').val(cityname);
document.form_hotel.submit();

}


</script>
</head>
<body>
<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=2&subindex=1" />
	</div>
	
<form action="hotel!Seach.jspx" method="post" id="form_hotel" name="form_hotel">	
<div class="nav_hotel">
    <div class="searchBox_hotel">
        <ul>
            <li class="td1">
                <input type="text" value="请输入城市名或酒店名" value="请输入城市名或酒店名" onfocus="if (value =='请输入城市名或酒店名'){value =''}"
                       onblur="if (value ==''){value='请输入城市名或酒店名'}" id="s_cityandhotelname" name="s_cityandhotelname" />
            </li>
            <li class="td2">
                <input type="text" value="<ww:property value="startDate" />"
                       id="txtcheckindate"  name="startDate" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})" 
                       >
            </li>
            
            <li class="td3">
                <input type="text" value="<ww:property value="endDate" />"
                       id="txtcheckoutdate" name="endDate" value="<ww:property value="endDate" />" onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})"
                       >
            </li>
            <li class="td4">
                <a href="#" type="button" onclick="sub_form();">搜索酒店</a>
            </li>
        </ul>
    </div>
</div>
</form>

<div class="goodness">
    <div class="td td1">
        <p class="p1">安心预订</p>
        <p class="p2">不收预订费，到达酒店后前台支付，预订更安心，安全和便捷。</p>
    </div>
    <div class="td td2">
        <p class="p1">免费取消</p>
        <p class="p2">不用担心行程变化和临时变卦，规定时间内可以随时免费取消，预订无担忧。</p>
    </div>
    <div class="td td3">
        <p class="p1">真是点评</p>
        <p class="p2">24,080,000条来自真实用户的酒店点评，酒店选择更全面和透明。</p>
    </div>
</div>
<div class="mid">
    <div class="tittle">
        <p class="font_yahei">热门城市酒店</p>
    </div>
    <div class="hotList">
        <ul>
            <li><a href="#">
                <img src="hotel/cityimg/bj.jpg" width="200" height="133" onclick="setname('北京');return false;">
                <span class="font_yahei">北京</span></a>
            </li>
            <li><a href="#">
                <img src="hotel/cityimg/sh.jpg" width="200" height="133" onclick="setname('上海');return false;">
                <span class="font_yahei">上海</span></a>
            </li>
            <li><a href="#">
                <img src="hotel/cityimg/sz.jpg" width="200" height="133" onclick="setname('深圳');return false;">
                <span class="font_yahei">深圳</span></a>
            </li>
            <li class="last"><a href="#">
                <img src="hotel/cityimg/gz.jpg" width="200" height="133" onclick="setname('广州');return false;">
                <span class="font_yahei">广州</span></a>
            </li>
        </ul>
        <ul>
            <li><a href="#">
                <img src="hotel/cityimg/hz.jpg" width="200" height="133" onclick="setname('杭州');return false;">
                <span class="font_yahei">杭州</span></a>
            </li>
            <li><a href="#">
                <img src="hotel/cityimg/sy.jpg" width="200" height="133" onclick="setname('三亚');return false;">
                <span class="font_yahei">三亚</span></a>
            </li>
            <li><a href="#">
                <img src="hotel/cityimg/xm.jpg" width="200" height="133" onclick="setname('厦门');return false;">
                <span class="font_yahei">厦门</span></a>
            </li>
            <li class="last"><a href="#">
                <img src="hotel/cityimg/wh.jpg" width="200" height="133" onclick="setname('武汉');return false;">
                <span class="font_yahei">武汉</span></a>
            </li>
            
        </ul>
    </div>
</div>

<div class="saleList" style="display: none;">
    <p class="font_yahei">热门城市特价酒店</p>
    <div class="cityTab">
        <a href="#" class="active font_yahei">墨尔本</a>
        <a href="#" class="font_yahei">台北</a>
        <a href="#" class="font_yahei">台北</a>
        <a href="#" class="font_yahei">台北</a>
        <a href="#" class="font_yahei">台北</a>
    </div>
    <div class="listContent">
        <ul>
            <li class="font_yahei">Hilton Melbourne South Wharf<span class="newPrice">3000</span> <span class="oldPrice">4000</span> <span>CNY</span></li>
            <li class="font_yahei">Hilton Melbourne South Wharf<span class="newPrice">3000</span> <span class="oldPrice">4000</span> <span>CNY</span></li>
            <li class="font_yahei">Hilton Melbourne South Wharf<span class="newPrice">3000</span> <span class="oldPrice">4000</span> <span>CNY</span></li>
            <li class="font_yahei">Hilton Melbourne South Wharf<span class="newPrice">3000</span> <span class="oldPrice">4000</span> <span>CNY</span></li>
        </ul>
        <div class="line"></div>
        <ul>
            <li class="font_yahei">Hilton Melbourne South Wharf<span class="newPrice">3000</span> <span class="oldPrice">4000</span> <span>CNY</span></li>
            <li class="font_yahei">Hilton Melbourne South Wharf<span class="newPrice">3000</span> <span class="oldPrice">4000</span> <span>CNY</span></li>
            <li class="font_yahei">Hilton Melbourne South Wharf<span class="newPrice">3000</span> <span class="oldPrice">4000</span> <span>CNY</span></li>
            <li class="font_yahei">Hilton Melbourne South Wharf<span class="newPrice">3000</span> <span class="oldPrice">4000</span> <span>CNY</span></li>
        </ul>
    </div>
</div>
<div class="popularBox" style="display: none;">
    <p class="font_yahei">最受欢迎的酒店</p>
    <ul>
        <li>
            <img src="hotel/img/popularHotel.jpg">
            <a href="#" class="font_yahei">Holiday Inn Express - Delafield</a>
            <p>马来西亚</p>
            <p class="rank"><span>评分 8.6</span></p>
            <a class="btn_xq" type="button">查看详情</a>
            <span class="price"><em>CNY</em><i class="oldPrice">2000</i> <i class="newPrice">3000</i></span>
        </li>
        <li>
            <img src="hotel/img/popularHotel.jpg">
            <a href="#" class="font_yahei">Holiday Inn Express - Delafield</a>
            <p>马来西亚</p>
            <p class="rank"><span>评分 8.6</span></p>
            <a class="btn_xq" type="button">查看详情</a>
            <span class="price"><em>CNY</em><i class="oldPrice">2000</i> <i class="newPrice">3000</i></span>
        </li>
        <li>
            <img src="hotel/img/popularHotel.jpg">
            <a href="#" class="font_yahei">Holiday Inn Express - Delafield</a>
            <p>马来西亚</p>
            <p class="rank"><span>评分 8.6</span></p>
            <a class="btn_xq" type="button">查看详情</a>
            <span class="price"><em>CNY</em><i class="oldPrice">2000</i> <i class="newPrice">3000</i></span>
        </li>
        <li class="last">
            <img src="hotel/img/popularHotel.jpg">
            <a href="#" class="font_yahei">Holiday Inn Express - Delafield</a>
            <p>马来西亚</p>
            <p class="rank"><span>评分 8.6</span></p>
            <a class="btn_xq" type="button">查看详情</a>
            <span class="price"><em>CNY</em><i class="oldPrice">2000</i> <i class="newPrice">3000</i></span>
        </li>
    </ul>
    <ul>
        <li>
            <img src="hotel/img/popularHotel.jpg">
            <a href="#" class="font_yahei">Holiday Inn Express - Delafield</a>
            <p>马来西亚</p>
            <p class="rank"><span>评分 8.6</span></p>
            <a class="btn_xq" type="button">查看详情</a>
            <span class="price"><em>CNY</em><i class="oldPrice">2000</i> <i class="newPrice">3000</i></span>
        </li>
        <li>
            <img src="hotel/img/popularHotel.jpg">
            <a href="#" class="font_yahei">Holiday Inn Express - Delafield</a>
            <p>马来西亚</p>
            <p class="rank"><span>评分 8.6</span></p>
            <a class="btn_xq" type="button">查看详情</a>
            <span class="price"><em>CNY</em><i class="oldPrice">2000</i> <i class="newPrice">3000</i></span>
        </li>
        
        <li>
            <img src="hotel/img/popularHotel.jpg">
            <a href="#" class="font_yahei">Holiday Inn Express - Delafield</a>
            <p>马来西亚</p>
            <p class="rank"><span>评分 8.6</span></p>
            <a class="btn_xq" type="button">查看详情</a>
            <span class="price"><em>CNY</em><i class="oldPrice">2000</i> <i class="newPrice">3000</i></span>
        </li>
        <li class="last">
            <img src="hotel/img/popularHotel.jpg">
            <a href="#" class="font_yahei">Holiday Inn Express - Delafield</a>
            <p>马来西亚</p>
            <p class="rank"><span>评分 8.6</span></p>
            <a class="btn_xq" type="button">查看详情</a>
            <span class="price"><em>CNY</em><i class="oldPrice">2000</i> <i class="newPrice">3000</i></span>
        </li>
    </ul>
</div>
 <ww:include page="../footer.jsp"/> 
</body>
</html>