<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
 <script type="text/javascript" src="js/aircity/js/jquery-1.4.2.min.js"></script>
    <meta charset="UTF-8">
    <title></title>
    <link type="text/css" href="zuche/css/style.css" rel="stylesheet">
    <script>
    function book_car(){
    if($("#car_name").val()==""){
	 alert("车品牌不能为空!!!");
	 $("#car_name").focus();
	 return;
	 }
    if($("#linkname").val()==""){
	 alert("联系人不能为空!!!");
	 $("#linkname").focus();
	 return;
	 }
	 if($("#linktel").val()==""){
	 alert("联系电话不能为空!!!");
	 $("#linktel").focus();
	 return;
	 } 
	  if($("#s_dizhi").val()==""){
	 alert("用车地址不能为空!!!");
	 $("#s_dizhi").focus();
	 return;
	 }
	  if($("#s_day").val()==""){
	 alert("用车时间不能为空!!!");
	 $("#s_day").focus();
	 return;
	 }
	
	
	 
    
    alert("订单已经提交!客服会第一时间与你您联系!!!");
    document.form1.submit();
    }
    
    </script>
    
</head>
<body>
    <div class="top"></div>
    <form action="cars!book_car.action" method="post" name="form1" id="form1">
    <div class="mid" style="width: 70%">
        <div class="mtop">
            <span class="we">在线提交</span><span class="vip">温馨提示:租车前提是有合法驾照.驾龄超过1年!需带身份证,驾驶证,信用卡等! </span>
        </div>
        <div class="line"></div>
        <div class="neirong">
           <p class="pc" style="text-align: left;">
                <span class="xing">*</span>车 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp型
                <select name="cartype">
                <option value="家庭型">家庭型</option>
                <option value="中档型">中档型</option>
                <option value="豪华型">豪华型</option>
                </select>
            </p>
             <p class="pc" style="text-align: left;">
                <span class="xing">*</span>大 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp小
                <select name="car_num">
                <option value="5">5座</option>
                <option value="7">7座</option>
                <option value="7座以上">7座以上</option>
                </select>
            </p>
             <p class="pc" style="text-align: left;">
                <span class="xing">*</span>取车类型
                <select name="qu_typw">
                <option value="自取">自&nbsp;&nbsp;&nbsp;&nbsp;取</option>
                <option value="送车上门">送车上门</option>
               
                </select>
            </p>
            <p class="pc" style="text-align: left;">
                <span class="xing">*</span>车&nbsp;品&nbsp;牌 <input name="car_name" id="car_name" type="text" value="" style="width: 280px;height: 25px;" class="">(例如:奔驰,宝马)
            </p>
            
            <p class="pc" style="text-align: left;">
                <span class="xing">*</span>联&nbsp;系&nbsp;人 <input name="linkname" id="linkname" type="text" value="" style="width: 280px;height: 25px;" size="8" class="">(例如:张三)
            </p>
            <p class="pc" style="text-align: left;">
                <span class="xing">*</span>联系号码 <input name="linktel" id="linktel" type="text" value="" style="width: 280px;height: 25px;" size="13" class="">(例如:138********)
            </p>
            <p class="pc" style="text-align: left;">
                <span class="xing">*</span>用车地址 <input name="s_dizhi" id="s_dizhi" type="text" value="" style="width: 280px;height: 25px;" class="">(例如:北京市,朝阳区,*******)
            </p>
             <p class="pc" style="text-align: left;">
                <span class="xing">*</span>用车时间 <input name="s_day" id="s_day" type="text" value="" style="width: 280px;height: 25px;" size="13" class="">(例如:2015-08-08)
            </p>
            <p class="pc" style="text-align: left;">
                <span class="xing">*</span>用车周期<select name="s_num">
                <option value="1">1天</option>
                <option value="2">2天</option>
                <option value="3">3天</option>
                <option value="4">4天</option>
                <option value="5">5天</option>
                <option value="6">6天</option>
                <option value="7">7天</option>
                <option value="8">8天</option>
                <option value="9">9天</option>
                <option value="10">10天</option>
                <option value="15">15天</option>
                <option value="20">20天</option>
                <option value="30">30天</option>
                </select> &nbsp;
            </p>
            
           
          
          
          

            <p class="pc" style="text-align: left;display: none;">
                <span class="xing">*</span> 验&nbsp证&nbsp码 <input type="text" value="" style="width: 280px;height: 25px;" size="4" class="">
            </p>
             <p class="pc" style="text-align: left;">
                <span class="xing">*</span> 备注  <textarea name="s_desc" class="wenben"></textarea>
            </p>
            
            <div class="pc4"><!--
                <input type="checkbox"><span class="read">我已阅读并同意</span><br/>
                --><button class="btn" onclick="book_car();">提交</button>

            </div>

        </div>
    </div>
    </form>
</body>
</html>