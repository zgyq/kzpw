<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>龙泰商旅网--预订成功</title>
<link href="carcss/base.css" rel="stylesheet" type="text/css" />
<link href="carcss/car_rental.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container">

<div id="list">

<!--right开始-->
<div class="right">
      <div class="no1">
       <div class="f hui999_14">
       <img src="images/chenggong.gif" width="30" height="28" align="absmiddle" style="margin-right:10px;" />预订成功
       </div>
       <div class="r"><img src="images/noc_5.gif" width="356" height="34" /></div>
       <div class="c"></div>
      </div>
      <div class="list_t fff">预订成功</div>
      <div class="yuding box_qbd">
      <div class="he14">&nbsp;</div>
      <div class="add njuzhong">
          <b>您的订单号为： </b> <font class="huangf60_16" ><ww:property value="carorder.code" /></font> &nbsp;&nbsp; <b> 订单金额: </b> <font class="huangf60_16" ><ww:property value="carorder.price" />元</font>&nbsp; &nbsp; <b>  支付方式: </b> <font class="huangf60_16" >门店支付 </font><br />
       如有问题请拨打电话：0755-61677666，谢谢！<br />
<br />

      </div>
       <!--<table width="96%" border="1" cellspacing="0" cellpadding="0" bordercolor="#DADADA" class="zifei">
          <tbody>
          <th colspan="2" class="texbd "><font class="lan06c"><img src="images/xiaotubiao.gif" width="16" height="18" align="absmiddle" class="m2" />&nbsp;&nbsp;订单管理 </font> </th>
          </tbody>
          <tr>
            <td class="tex"   >&nbsp;&nbsp;&nbsp;&nbsp;您的预约订单已经成功提交！</td>
            <td class="texbd font-f60" width="140" rowspan="2" align="center"><input type="button" class="button_jo" onclick="toorder();" value="管理订单" /> </td>

          </tr>  
          <tr>
            <td class="tex"   >&nbsp;&nbsp;&nbsp;&nbsp;请及时到会员中心订单管理处确认您的订单，以便我们为您提供更好的服务。</td>
          </tr> 
        </table>
        --><Div class="he14"></Div>
        <table width="96%" border="1" cellspacing="0" cellpadding="0" bordercolor="#DADADA" class="zifei">
          <tbody>
          <th colspan="2" class="texbd" ><font class="lan06c"><img src="images/xiaotubiao.gif" width="16" height="18" align="absmiddle" class="m2" />&nbsp;&nbsp;注意事项 </font></th>
          </tbody>
          <tr>
            <td class="tex"   >&nbsp;&nbsp;&nbsp;&nbsp;您所需支付金额：<font class="huang_jia"><ww:property value="carorder.price" /> 元</font></td>
            <td class="texbd font-f60" width="140" rowspan="2" align="center" >
             <input type="button" class="button" value="查看订单" onclick="toorder();" />
            </td>

          </tr>  
          <tr>
            <td class="tex"   >&nbsp;&nbsp;&nbsp;&nbsp;你只需在门店取车时候支付相应费用即可!取车时候请带好身份证,驾照,信用卡等证件.  </td>
          </tr> 
        </table>
        <Div class="he14"></Div>
      </div>

</div>
<!--right结束-->
<div class="c"></div>


</div>

</div>
</body>
</html>
<script>
function toorder(){

window.location.href="carorder.action";
}

</script>

