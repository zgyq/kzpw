<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-国际机票订单确认</title>
<ww:head name="inter" jsURL="international" />
</head>

<body>
<div id="container">
 <div class="center"><ww:include page="../top.jsp?index=1&subindex=2" /></div>
 <!--includ top 直接替换掉整个DIV-->
</div>  

<!--top over-->
<div class="nohave" style="margin-top: 51px;">&nbsp;</div>
<div id="list">
  <div class="f left">
     <div>
     <div class="f"><span class="f ico_interone">&nbsp;</span><font class="big000">北京－温哥华(加拿大)（单程）</font></div>
     <div class="r">查询&nbsp;预订&nbsp;核对&nbsp;完成</div>
     <div class="c"></div>
     </div>
     <div class="algin mt7">
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="30" width="185">航程类型：<input name="" type="radio" class="" value="" />单程<input name="" type="radio" value="" />往返</td>
            <td width="245">出发城市：<input type="text" class="text_intersea" /> </td>
            <td>到达城市：<input type="text" class="text_intersea" /> </td>
          </tr>
          <tr>
            <td ><input type="button" class="bnt-aglin fff mr5" value="重新查询"  /><a href="#" class="f00">+更多条件</a></td>
            <td>出发时间：<input type="text" class="text_intersea" /> </td>
            <td>到达时间：<input type="text" class="text_intersea" /> </td>
          </tr>
        </table>
     </div> 
        <div class="algin-more" style="display:none">
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="30" width="185">乘客类型：<select class="sel_intersea_algin"><option>成人</option></select></td>
            <td width="245">乘客人数：<select class="sel_intersea"><option>1人</option></select></td>
            <td>舱位等级：<select class="sel_intersea"><option>特价舱</option></select></td>
          </tr>
        </table>
        </div>
     <div class="algin-botm">&nbsp;</div>
     <div class="tips_go mt7"><span class="fff mr25">第一程</span><font>北京-->温哥华(加拿大) 出发日期：2011年11月26日      </font></div>
          <div class="box mt7 bookinglistgo">
        <table width="100%" border="0" cellspacing="0" cellpadding="0"  style="margin:1px;">
              <tr>                                                                                                  
                <th scope="col" align="left" class="pf20">航程</th>
                <th scope="col">航空公司</th>
                <th scope="col">航班号</th>
                <th scope="col">起飞时间</th>
                <th scope="col">到达时间</th>
                <th scope="col">机型</th>
                <th scope="col">价格</th>
              </tr>
               <tr>
               <td align="left" class="pf20">首都国际机场<br/>白云机场 </td>
               <td align="left"><span class="f mr5 mu" >&nbsp;</span>东方航空</td>
               <td>MU1999</td>
               <td>2011-09-09&nbsp;09:30</td>
               <td>2011-09-09&nbsp;09:30</td>
               <td>737</td>
               <td><font class="f90c">1999</font>元</td>
              </tr>
              <tr>
               <td align="left" class="pf20">首都国际机场<br/>白云机场 </td>
               <td align="left"><span class="f mr5 mu" >&nbsp;</span>东方航空</td>
               <td>MU1999</td>
               <td>2011-09-09&nbsp;09:30</td>
               <td>2011-09-09&nbsp;09:30</td>
               <td>737</td>
               <td><font class="f90c">1999</font>元</td>
              </tr>
            </table>
     </div>
     <div class="tips_back mt7"><span class="fff mr25">第二程</span><font>北京-->温哥华(加拿大) 出发日期：2011年11月26日      </font></div>
     <div class="box mt7 bookinglist">
       <table width="100%" border="0" cellspacing="0" cellpadding="0"  style="margin:1px;">
              <tr>                                                                                                  
                <th scope="col" align="left" class="pf20">航程</th>
                <th scope="col">航空公司</th>
                <th scope="col">航班号</th>
                <th scope="col">起飞时间</th>
                <th scope="col">到达时间</th>
                <th scope="col">机型</th>
                <th scope="col">价格</th>
              </tr>
              <tr>
               <td align="left" class="pf20">首都国际机场<br/>白云机场 </td>
               <td align="left"><span class="f mr5 mu" >&nbsp;</span>东方航空</td>
               <td>MU1999</td>
               <td>2011-09-09&nbsp;09:30</td>
               <td>2011-09-09&nbsp;09:30</td>
               <td>737</td>
               <td><font class="f90c">1999</font>元</td>
              </tr>
              <tr>
               <td align="left" class="pf20">首都国际机场<br/>白云机场 </td>
               <td align="left"><span class="f mr5 mu" >&nbsp;</span>东方航空</td>
               <td>MU1999</td>
               <td>2011-09-09&nbsp;09:30</td>
               <td>2011-09-09&nbsp;09:30</td>
               <td>737</td>
               <td><font class="f90c">1999</font>元</td>
              </tr>
            </table>
     </div>
      <div class="box mt7">
         <div class="title">
            <font class="black low f mr15">温馨提示</font>
            <div class="c"></div>
         </div>
         <div class="tips_inter">
           <ul>
            <li><font class="font12000">乘客身份</font>：成人 </li>
            <li><font class="font12000">行李要求</font>：托运行李20KG，长宽高三边之和</li>
            <li><font class="font12000">行李要求</font>：托运行李20KG，长宽高三边之和</li>
            <li><font class="font12000">行李要求</font>：托运行李20KG，长宽高三边之和</li>
           </ul>
         </div>
       </div>  
    <div class="box mt7 check">
        <table width="100%" border="0" cellspacing="0" cellpadding="0"  style="margin:1px;">
              <tr>                                                                                                  
                <th scope="col" align="left" class="pf20">乘机人姓名</th>
                <th scope="col">乘客类型</th>
                <th scope="col">证件类型</th>
                <th scope="col">证件号码</th>
                <th scope="col">证件有效期</th>
                <th scope="col">证件签发国</th>
                <th scope="col">国籍/地区</th>
                <th scope="col">性别</th>
                <th scope="col">留学生</th>
              </tr>                                       
               <tr>
               <td>zeng/qingquan</td>
               <td>成人</td>
               <td>身份证</td>
               <td>210381198401124515</td>
               <td>2011-11-11</td>
               <td>中国</td>
               <td>中国</td>
               <td>男</td>
               <td>否</td>
              </tr>
              <tr>
               <td>zeng/qingquan</td>
               <td>成人</td>
               <td>身份证</td>
               <td>210381198401124515</td>
               <td>2011-11-11</td>
               <td>中国</td>
               <td>中国</td>
               <td>男</td>
               <td>否</td>
              </tr>
            </table>
     </div>
     <div class="box mt7 check">
        <table width="100%" border="0" cellspacing="0" cellpadding="0"  style="margin:1px;">
              <tr>                                                                                                  
                <th scope="col" align="left" class="pf20">联系人姓名</th>
                <th scope="col">乘客类型</th>
                <th scope="col">证件类型</th>
                <th scope="col">证件号码</th>
                <th scope="col">证件有效期</th>
                <th scope="col">证件签发国</th>
                <th scope="col">国籍/地区</th>
                <th scope="col">性别</th>
                <th scope="col">留学生</th>
              </tr>                                       
               <tr>
               <td>zeng/qingquan</td>
               <td>成人</td>
               <td>身份证</td>
               <td>210381198401124515</td>
               <td>2011-11-11</td>
               <td>中国</td>
               <td>中国</td>
               <td>男</td>
               <td>否</td>
              </tr>
              <tr>
               <td>zeng/qingquan</td>
               <td>成人</td>
               <td>身份证</td>
               <td>210381198401124515</td>
               <td>2011-11-11</td>
               <td>中国</td>
               <td>中国</td>
               <td>男</td>
               <td>否</td>
              </tr>
            </table>
     </div>
      <form action="order.html" method="get">  
      <div class="bnt">
          <input type="button" class="bnt_previous mr25 cfff" value="上一步"  />
          <input type="submit" class="bnt_next mlr15 cfff" value="下一步"  />
      </div>
      </form>    
  </div>
  <div id="right" class="r">
    <div class="titlelogin"><font class="black">国际航线咨询</font></div>
        <div class="box_sea">
           <ul class="inter-information">
           <li class="nohave">&nbsp;</li>
           <li><span class="ico_inter-information f">&nbsp;</span>海航开通海口直飞新加坡航线</li> 
           <li><span class="ico_inter-information f">&nbsp;</span>东航北京始发欧美澳航线特价促销</li> 
           <li><span class="ico_inter-information f">&nbsp;</span>南航珀斯航线开航通知</li> 
           <li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
           <li><span class="ico_inter-information f">&nbsp;</span>海航开通海口直飞新加坡航线</li> 
           <li><span class="ico_inter-information f">&nbsp;</span>东航北京始发欧美澳航线特价促销</li> 
           <li><span class="ico_inter-information f">&nbsp;</span>南航珀斯航线开航通知</li> 
           <li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
            <li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
             <li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
           <li class="nohave">&nbsp;</li>
           </ul>
        </div>
     <div class="loginbot"></div>   
     <div class="nohave">&nbsp;</div>
     <div><img src="images/ad_interright.jpg" width="260" height="88" /></div>
     <div class="nohave">&nbsp;</div>
     <div><img src="images/ad_interrightto.jpg" width="260" height="88" /></div>
  </div>
  <div class="c"></div>
</div> 
<!--container over-->
 <ww:include page="../footer.jsp" />
</body>
</html>
