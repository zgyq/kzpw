<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-成功提示</title>

<ww:head name="login"/>
<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>
<style>
#overlay{
   background: #303030;
   opacity: 0.50;
   filter:Alpha(opacity=50);
   display: none;
   position: absolute;
   top: 0px;
   left: 0px;
   width: 100%;
   height: 100%;
   z-index: 100;
}
#tishi{
 margin-left:auto;
 margin-right:auto;
 border:2px solid #FFFFFF;
 font-size:12px;
 font-family: "宋体";
 color:#990000;
 padding-top:20px;
 width:400px;
 height:200px;
 position:absolute;
 z-index:110;
 display:none;
 background:#e7e7e7;
 left:35%;
 top:20%;
 opacity:0.85;
 filter:Alpha(opacity=85);
}
</style>
</head>

<script>
$(document).ready(function() {

			$("#form1").validationEngine(
			{
				success : function() {
				//表单提交时把按钮disable
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});
</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>  
<!----------header over---------->
<div id="member">
   <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">会员信息</li>
            <li class="mation_info"><font class="mation_left f f90"><b>普通会员</b></font><span class="f mr25">会员注册时间为：2011年10月11日</span>       <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div>
      
       <div class="mt7 box">
            <div class="tit">
                   <font class="black low2 f mr15">修改密码</font>
                   <font class="f mr25 c999">请完善您的个人资料</font>
                   <div class="c"></div>
            </div>
            <div >
               <div class="order_all" >
               <ul>
                <li><font class="black">恭喜您已经<font class="f00"><ww:property value="fieldErrors.validate"/></font></font></li>
                <li style="display: none" class="mt20">您现在还可以：<a href="ticticket!toTicket.jspx" class="unc09f mlr15" >预订国内机票</a><a href="international!toInterNational.jspx" class="unc09f mlr15">预订国际机票</a><a href="#" class="unc09f mlr15">商旅订制</a> </li>
               </ul>
              </div>
              <!--公用的操作成功页面，哪里需要放哪里。提示的文字要换。-->
            </div>
       </div> 
   </div>
</div>


<ww:include page="../footer.jsp"/>  
</body>
</html>

<script>

</script>

	