<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-兑换成功</title>

<ww:head name="point" jsURL="memberpoint" />
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="member">
   <jsp:include flush="true"
	page="../member/left.jsp?ty=member"></jsp:include>
   <div class="right mt10 r">
       
       <div class="box mt7">
        <div class="tit">
               <font class="black low2 f mr15">积分商城</font>
               <font class="r mr25">欢迎加入${compname}，我们将为您提供最优质的服务，服务咨询热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div >
               <div class="order_all" >
               <ul>
                <li><font class="black">恭喜您已经<font class="f00">成功兑换<ww:property value="gift.name"/></font>。</font></li>
                <li class="mt20">您现在还可以：<a href="ticticket!toTicket.jspx" class="unc09f mlr15" >预订国内机票</a><a href="international!toInterNational.jspx" class="unc09f mlr15">预订国际机票</a><a href="#" class="unc09f mlr15">商旅订制</a> </li>
               </ul>
              </div>
              <!--公用的操作成功页面，哪里需要放哪里。提示的文字要换。-->
            </div>
        <div class="information">
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
               <td align="right" width="20%"><img src="../images/jifenduihuan.jpg" width="140" height="140" class="m10 ad_box" /></td>              
               <td class="hl24">
               <div class="mf31">
                 <ul>
                 <li></li>
                 <li>物品编号：<ww:property value="gift.giftcode"/></li>
                 <li>所需积分：<font class="f90c"><ww:property value="gift.useintegral"/>分</font></li>
                 <li>剩余数量：21个</li>
                 <li><input type="submit" class="button_first fff mr25" value="再换一个" />已有<font class="f90c">5 位</font>${compname}用户兑换该物品</li>
                 </ul>
               </div>  
               
              </td>
              </tr>
            </table>
            <!--listsearch over-->
           
            <div class="nohave">&nbsp;</div>
        </div>
       </div> 
   </div>
</div>

<ww:include page="../footer.jsp" />    
</body>
</html>
