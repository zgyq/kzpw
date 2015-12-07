<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>预订成功:酒店预订,宾馆预订,特价酒店，国内酒店，国际酒店---天河联盟旅行网</title>
<link href="hstyle/base.css" type="text/css" rel="stylesheet" />
<link href="hstyle/hotel.css" type="text/css" rel="stylesheet" />
<link href="hstyle/autocomplete.css" type="text/css" rel="stylesheet" />


</head>

<body>

<div >
<div >
  
<!-------------搜索结束------------->



<!--推荐酒店结束-->

<!--最新活动结束--></div>
<!------------left 结束------------->
  <div  style="width: 90%; margin: 0 auto;">
        <div><img src="images/buzhou_3.gif" width="674" height="39"  /></div>
        <div style="line-height:60px; padding-top:10px;"><b class="huang_16">&nbsp;<img src="images/lvjiant.gif" width="17" height="21"  align="absmiddle"/>&nbsp;&nbsp;您的订单已经成功提交，订单号为：<ww:property value="hotelorder.orderid" /></b></div>

        <div class="c"></div>
        <ww:if test="hotelorder.paytype!=2">
        
         <table width="100%" border="0" class="box" cellspacing="0" cellpadding="0" bordercolor="#cccccc" style=" border-bottom:none; line-height:24px; border-top:2px solid #779BCA" >
          <tr>
            <td  class="box_wu" style="padding-left:40px;">
             <ww:if test="gethoteltype(hotelorder.hotelid)==1">
            <b>OK，确认订单!</b>
            </ww:if><ww:else>
              <b>OK，等待确认订单！</b>
            </ww:else>
            </td>
           

          </tr>
          <tr>
           
        
         <td class="box_wu" style="padding-left:40px;">您的订单已经成功提交，待与酒店确认，我们将会半小时内短信通知您（8：00-23：00）。
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
         
         </td>
     
         
          </tr>
        </table>
        </ww:if>
        <table width="100%" cellpadding="0" cellspacing="0" border="0" class="box" bordercolor="#cccccc" style=" border-bottom:none; line-height:24px; border-top:2px solid #779BCA; margin-top:10px;" >
        <tr>
        <td class="box_wu" colspan="6" style="padding-left:40px; font-weight: bold;">您的预定信息：</td>
        </tr>
        <tr>
        <td class="box_yin" width="15%" align="right">酒店名称：</td>
        <td class="box_wu" width="16%" ><b class="lan_14"><ww:property
			value="hotel.name" /></b></td>
        <td class="box_yin" width="15%" align="right">所在地区：</td>
        <td class="box_wu" width="16%"><b class=" lanh"><ww:property
			value="getctname(hotel.cityid)" /></b></td>
        <td class="box_yin" width="15%" align="right">总价：</td>
        <td class="box_wu" ><b class="huang_14">RMB&nbsp;<ww:property value="hotelorder.price" /></b></font></td>
        </tr>
        <tr>
        <td class="box_yin" align="right">入住时间：</td>
        <td class="box_wu"><b><ww:property value="startDate" /></b></td>
        <td class="box_yin" align="right">离店时间：</td>
        <td class="box_wu"><b><ww:property value="endDate" /></b></td>
        <td class="box_yin" align="right">入住天数：</td>
        <td class="box_wu"><ww:property value="s_num" />天</td>
        </tr>
        <ww:iterator value="listGuest">
        <tr>
        <td class="box_yin" align="right">入住人姓名：</td>
        <td class="box_wu"><ww:property value="name" /></td>
        <td class="box_yin" align="right">入住人手机：</td>
        <td class="box_wu"><ww:property value="mobile" /></td>
        <td class="box_yin" align="right">性别：</td>
        <td class="box_wu"><ww:if test="sex==1">男</ww:if><ww:if test="sex==2">女</ww:if></td>
        </tr>
        </ww:iterator>
        <tr>
        <td class="box_yin" align="right">联系人姓名：</td>
        <td class="box_wu"><ww:property value="hotelorder.linkname"/></td>
        <td class="box_yin" align="right">联系人手机：</td>
        <td class="box_wu"><ww:property value="hotelorder.linkmobile"/></td>
        <td class="box_yin" align="right">间数：</td>
        <td class="box_wu"><ww:property value="hotelorder.prerooms"/></td>
        
        </tr>
        </table>
        <div style="width:100%; text-align:right;padding-right:30px; line-height:40px"><font class="hei_14c r">应支付总价：<b class="huang_14">RMB&nbsp;<ww:property value="hotelorder.price" /></b></font></div>
         
        <div style=" padding-left:40px; padding-top:30px; line-height:40px; font-size:14px">
        
        温馨提示：<br/>
1）	订房成功后，本站会以短信或电话方式通知您！<br/>

2）	请记下您的订单号，以备办理其他业务时使用。。

        </div>
  </div>
<!--right结束-->
</div>

</div>
</body>
</html>
