<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>龙泰商旅网--预订失败</title>
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
       <img src="images/chenggong.gif" width="30" height="28" align="absmiddle" style="margin-right:10px;" />预订失败
       </div>
       <div class="r"><img src="images/noc_6.gif"   /></div>
       <div class="c"></div>
      </div>
      <div class="list_t fff">预订失败</div>
      <div class="yuding box_qbd">
      <div class="he14">&nbsp;</div>
      <div class="add njuzhong">
          <div class="m7">

           <div class="dui"> 
             <img src="images/png-0495.png"  align="left" /><font size="+2" style="font-weight:bold; ">预订失败</font><br/> 您本次预订失败了，如遇到问题请拨打服务热线：<font class="huang_jia">400-715-5555</font>
           </br> 失败原因: <ww:property value="messsge" />
             <div>
             <input type="button" class="button_jox" value="重新填写" onclick="javascript:history.go(-1)"  />
             <input type="button" class="button_jox" value="返回列表" onclick="golist();"  />
             <input type="button" class="button_jox" value="返回首页" onclick="goindex();"  />
             </div>
           </div>
          </div> 
      </div>
       

</div>
<!--right结束-->
<form action="bookcar!seach.action" method="post" name="form1" id="form1">
 <input type="hidden"  name="Scity" value="<ww:property value="Scity" />"  />
 <input type="hidden"  name="Endcity" value="<ww:property value="Endcity" />"  />
 <input type="hidden"  name="Scarstore_s" value="<ww:property value="Scarstore_s" />"  />
 <input type="hidden"  name="Scarstore_e" value="<ww:property value="Scarstore_e" />"  /> 
 
 <input type="hidden"  name="startDate" value="<ww:property value="startDate" />"  /> 
 <input type="hidden"  name="startDate_HH" value="<ww:property value="startDate_HH" />"  /> 
 <input type="hidden"  name="endDate" value="<ww:property value="endDate" />"  /> 
 <input type="hidden"  name="endDate_HH" value="<ww:property value="endDate_HH" />"  /> 
 </form>

<div class="c"></div>


</div>

</div>
</body>
</html>
<script>
function goindex(){

window.location.href="bookcar.action";
}
function golist(){

document.form1.submit();
}

</script>
