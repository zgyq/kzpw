<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>浙江海峡</title>


<link href="huodong/style_.css" rel="stylesheet" type="text/css" />
<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>

<style type="text/css">

.STYLE6 {font-size: 24px}
.STYLE7 {color: #FF0000}
.STYLE8 {font-size: 16px}
.STYLE9 {color: #FFFFFF}

</style>
</head>

<body onload="MM_preloadImages('旅游系统新/机票系统/images/yudian_2.jpg');setup()">
<ww:include page="../top.jsp?type=ticket" />
		<div style=" position:absolute; top:73px; left:150px;">当前位置 ： 首页 > 我的个人中心</div>
<table width="978" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="761" valign="top"><table width="747" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="30"><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
      <table width="747" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="883" valign="top" bgcolor="#ECF5FF"><br />
            <br /><form id="form1" name="form1" method="post" action="旅游系统新/机票系统/reg_check.asp" onsubmit="return regcheck()">
		  <table width="653" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="38" align="center"  valign="middle" bgcolor="#FFFFFF"><table width="100%" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="40" colspan="3" align="center" valign="top" nowrap="nowrap" class="fontlogin STYLE6 STYLE7">参与成功！！活动倒计时</td>
                  </tr>
                  <tr>
                  
                   <div id="CountMsg" style="color:red">
                  	 还有<span id="RemainD"></span>天<span id="RemainH"></span>小时<span id="RemainM"></span>分<span id="RemainS"></span>秒结束
                  	 </div>  
                  </tr>
                <tr>
                  <td height="40" align="center" nowrap="nowrap" style="font-size:14px"  bgcolor="#006699" class="fontlogin STYLE91" >基本信息</td>
                  <td align="left" bgcolor="#ffffff" valign="top"><p align="center" style="font-size:18px" class="fontlogin STYLE6">&nbsp;</p>
                    <p align="center"  style="font-size:18px" class="fontlogin STYLE6">活动规则</p>
                    <ul>
                      <li>抽奖时间为<strong>1月日晚上11:00-1月日晚上11:00。</strong> </li>
                      <li>旅客进入活动专区，查看机票信息（具体投放航线由我司随机投放），登录后方可参加活动（若非会员，请注册）。 </li>
                      <li>活动开始后点击相应机票的<strong>参加</strong>按钮，填写个人信息并提交，等抽奖时间结束后，我司会在参与活动的客户中随机抽取一位幸运客户。 </li>
                      <li>抽奖结果于<strong>1月</strong> <strong>日</strong>公布，中奖客户我司会与其取得联系。 </li>
                    </ul>                    </td>
                  <td width="20%" rowspan="12" align="left" bgcolor="#ffffff"  background="images/qwqw.jpg"></td>
                </tr>
                <tr>
                  <td width="24%" height="30" rowspan="2" align="center" nowrap="nowrap"></td>
                  <td width="56%" align="center" bgcolor="#ffffff" class="fontlogin STYLE7 STYLE8"> 温馨提示：</td>
                  </tr>
                <tr>
                  <td align="left" bgcolor="#ffffff">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1、该活动机票价格不包含机场建设费及燃油费。</td>
                </tr>
                <tr>
                  <td height="40" align="center" nowrap="nowrap" >
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td  background="images/bottom.jpg" height="30" class="fontlogin STYLE91" align="center">个人信息</td>
                      </tr>
                    </table></td>
                  <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、注册用户必须清楚填写个人信息及联系方式，否则我司有权&nbsp;&nbsp; 取消其参加活动的资格。</td>
                  </tr>
                <tr>
                  <td height="40" align="center" nowrap="nowrap" >&nbsp;</td>
                  <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、该活动机票不得变更，不得签转，不得退票，不正常航班按照首都航空不正常航班保障流程执行，赔偿金额不高于票价。</td>
                  </tr>
                <tr>
                  <td height="40" align="center" nowrap="nowrap">&nbsp;</td>
                  <td align="left"><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、活动期间一元特价商品只限一款，抢完即止。 </p></td>
                  </tr>
                <tr height="22">
                  <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td height="30" align="center" nowrap="nowrap" background="images/bottom.jpg" class="fontlogin STYLE91">常用登机人</td>
                    </tr>
                  </table>
                    </td>
                  <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5、秒杀时间以北京时间为准，如因网络系统原因，而造成抽奖失败，本公司不作任何赔偿。                                      </td>
                  </tr>
                <tr>
                  <td height="40" align="right" nowrap="nowrap">&nbsp;</td>
                  <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6、网站暂时不提供儿童、婴儿的订票服务。                    </td>
                  </tr>
                <tr>
                  <td height="40" align="right" nowrap="nowrap">&nbsp;</td>
                  <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7、网站暂时只提供持中国大陆身份证且姓名全部为中文的乘客秒杀订票服务。                  </td>
                  </tr>
                <tr>
                  <td height="30" align="center" nowrap="nowrap" background="images/bottom.jpg" class="fontlogin STYLE91">常用配送地址</td>
                  <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8、该活动机票不与其他优惠同时享用。                   </td>
                  </tr>
                <tr>
                  <td height="30" align="center" nowrap="nowrap"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td   height="30" align="center"></td>
                      </tr>
                    </table></td>
                  <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;9、此&quot;抽奖&quot;产品系我司对广大新老客户的回馈行为，严禁一切代理商以散客身份订购倒卖，一经发现，坚决封禁订票账号并对账号下所有已订&quot;抽奖&quot;机票进行作废处理；同时若某账户在1次抽奖活动期间参加次数超过3次，系统将自动禁用此账户。                 </td>
                  </tr>
                <tr>
                  <td height="30" background="images/bottom.jpg" class="fontlogin STYLE91" align="center">登录</td>
                  <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10、${compname}对本活动拥有最终解释权。</td>
                  </tr>
              </table>              </td>
            </tr>
          </table></form>
          </td>
        </tr>
      </table></td>
    <td valign="top">&nbsp;</td>
  </tr>
</table>
<ww:include page="../footer.jsp"/>
</body>
</html>

<script type ="text/javascript" >
<!-- //
function GetRTime(){
var EndTime= new Date(2013,00,29,12,45); //截止时间:2006年6月10日0时0分
var NowTime = new Date();
var nMS =EndTime.getTime() - NowTime.getTime();
var nD =Math.floor(nMS/(1000 * 60 * 60 * 24));
var nH=Math.floor(nMS/(1000*60*60)) % 24;
var nM=Math.floor(nMS/(1000*60)) % 60;
var nS=Math.floor(nMS/1000) % 60;

//alert(nD+nH+nM+nS);
if(nD>= 0){
 document.getElementById("RemainD").innerHTML=nD;
 document.getElementById("RemainH").innerHTML=nH;
 document.getElementById("RemainM").innerHTML=nM;
 document.getElementById("RemainS").innerHTML=nS;
}
else {
 document.getElementById("CountMsg").innerHTML="活动已经圆满结束！";
}
setTimeout("GetRTime()",1000);
}
window.onload=GetRTime;
// -->
</script> 


