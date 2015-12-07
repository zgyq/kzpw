<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />

<title>${compname}-机票列表页面</title>
<ww:head name="air" jsURL="citycontrol" />
<script>
$(document).ready(function(){
	$(".goDown").anchorGoWhere({target:1});
});
 //显示机型信息说明
	  function showflightdesc(index)
	  {
	     var context=$("#hid_lowflightdesc_"+index).val();
		 if(context=="")
		 {
		    context="暂无机型信息说明！";
		 }
		 else if(context.indexOf('#')>0)
		 {
		    context=context.replace(",","，").replace("'","，").replace(":","：");
		    var arrflightdesc=context.split('#');
		    
		    if(arrflightdesc[1]=="")
		    {
			    var desc=context;
			    context='<table border="0"><tr>';
			    context+='<td><img src="images/NoImage.gif" width="65px" height="65px"  /></td>';
			    context+='<td>'+desc.replace('载客','<br />载客').replace("。","。<br />")+'</td>';
			    context+="</tr></table>";
		    }
		    else
		    {
		        context='<table border="0"><tr>';
			    context+='<td><img src="images/flighttype/'+arrflightdesc[1]+'" width="65px" height="65px"  /></td>';
			    context+='<td>'+arrflightdesc[0].replace('载客','<br />载客').replace("。","。<br />")+'</td>';
			    context+="</tr></table>";
		    }
		   
		 }
		 
		 //显示机型信息
		 $('#a_flightdesc_'+index).poshytip({
			content: context,
			showOn: 'none',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'bottom',
			offsetX: 0,
			offsetY: 5
		 });
		 $('#a_flightdesc_'+index).poshytip('show');
	  }
	  //显示退改签信息说明
	  function showrules(index,context)
	  {
		 if(context=="")
		 {
		    context="更改规则：暂无信息<br />退票规则：暂无信息<br />签转规则：暂无信息<br />";
		 }
		 $('#a_rules_'+index).poshytip({
			content: context,
			showOn: 'hover',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'bottom',
			offsetX: 0,
			offsetY: 5
		 });
		 
		 $('#a_rules_'+index).poshytip('show');
	  }
	  //隐藏退改签信息说明
	  function hiderules(index)
	  {
	      $('#a_rules_'+index).poshytip('hide');
	  }
	  //隐藏机型信息说明
	  function hideflightdesc(index)
	  {
	      $('#a_flightdesc_'+index).poshytip('hide');
	  }
</script>
</head>
<body>
<ww:i18n name="'language'">
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=1&subindex=1" />
	</div>  
	<!--top over-->
	<div id="main">
  <div id="left" class="f">
      <div class="tit" style="border:1px solid #e3d3d3; border-bottom:none;">
      	<font class="black" style=" padding-left:10px;">相关信息</font>
      </div>
      <div class="box content" style=" border-top:none;">
         <ul>
         <li><a href="#">携程用户习惯调研问卷缤纷特价季、</a></li>
         <li><a href="#">华夏中转有约吉祥航空</a></li>
         <li><a href="#">开通上海虹桥至海口航班海南航空新</a></li>
         <li><a href="#">开通上海-乌鲁木齐-库尔勒定期航班</a></li>
         <li><a href="#">携程用户习惯调研问卷缤纷特价季、</a></li>
         <li><a href="#">华夏中转有约吉祥航空</a></li>
         <li><a href="#">开通上海虹桥至海口航班海南航空新</a></li>
         <li><a href="#">开通上海-乌鲁木齐-库尔勒定期航班</a></li>
         <li><a href="#">携程用户习惯调研问卷缤纷特价季、</a></li>
         </ul>      
      </div>
      <div class="ad mt7"><img src="images/ad_ticket_01.jpg" width="260" height="100" /></div>
  </div>
  <!--left over-->
  <div id="order" class="r">
       <div class="guild">
           <ul>
           <li class="current f"></li>
           <li class="f font20">订单预订失败</li>
           <li class="r statusorder">&nbsp;</li>
           <li class="c"></li>
           </ul>
       </div>
       
        <div class="mt7 box">
            <div class="tit">
                   <font class="black low2 f mr15">订单信息</font>
            </div>
            <div class="order">
               <ul>
                <li><font class="black">对不起,您提交的订单未能成功.请从新预定,或者致电${tel}</li>
               <li></li>
               </ul>
            </div>
        </div>

       
     
      
      <!----------联系人信息------------>  
   </div>
  <!--right over-->
</div> 
	<!--container over-->

	<ww:include page="../footer.jsp" />

</ww:i18n>
</body>

</html>
