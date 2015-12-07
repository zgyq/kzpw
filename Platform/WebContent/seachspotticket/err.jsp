<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}酒店预定系统</title>
<link href="skin/blue/css/base.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/font.css" rel="stylesheet" type="text/css" />
<link href="skin/blue/css/hotel.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=2&subindex=1" />
	</div>  
<!--top over-->
<div id="hotel" style="margin-top: 51px;">
     
 <div id="list" style="width:80%; margin:0 auto;">

    <div>
       <span class="f ico_hotel">&nbsp;</span><font class="f biger000">订单提交失败</font>
       <span class="r status_five">&nbsp;</span>
       <div class="c"></div>
    </div>
    <div class="c"></div>
    <div class="mt7 box" style=" display:inline-block; width:100%;">
     <div class="tit"><span class="low2 black f">信息：</span></div>
     <div class="tsico"></div>
     <div class="order">
           <ul>
                
                <li class="c999">预订失败,该酒店已经满房,你可以从新选择预订或者致电客服协助!!!</li>
           </ul>
     </div>
    </div>
      
      <div class="order_bnt">
        <input type="button" class="mr25 booking_bntton fff" value="从新预订" onclick="GoWhy('hotel!toindex.jspx');" />
        <input type="button" class="mr25 booking_bntton fff" value="返回首页" onclick="GoWhy('index!toindex.jspx');" />
        <input type="button" class="mr25 booking_bntton fff" value="预定机票" onclick="GoWhy('ticticket!toTicket.jspx');" />
       </div> 
 </div>
 <!--list over-->
 <div class="c"></div>
</div>
 <ww:include page="../footer.jsp"/> 
 </body>
</html>
<script type="text/javascript">
function GoWhy(url){
window.location.href=url;

}

</script>
