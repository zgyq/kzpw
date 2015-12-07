<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天河联盟商旅网</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/webcss/bass.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/hotel.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/font.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/slider.css" type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="js/jquery1.3.2.js"></script>
<script type="text/javascript"
	src="style/webcss/slider_extras.js"></script>
	
</head>

<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border:1px solid #99CBED; margin-bottom:4px;">
<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu" style="float: left; display:block;">&nbsp;&nbsp;&nbsp;旅游线路列表</span>
</td>
</tr>
<tr>
<td>
<ww:if test="usertype!=2">
<jsp:include page="../orderuserinfo.jsp"></jsp:include>
</ww:if>
</td>
</tr>
<tr>
<td>
<div id="container">
<div id="header">
</div>
<div style="display:none">
<div class="quan lan14_cu">快速搜索</div>
  <ul style="text-align:right; padding-right:20px; padding-top:10px; color:#999999">
     <li>出发城市：<select style="width: 150px" name="cityid">
			    		<option value="<ww:property value="getCityid('北京')"/>" <ww:if test="tripline.cityid==getCityid('北京')">selected="selected"</ww:if>>北京</option>
			    		<option value="<ww:property value="getCityid('上海')" />" 
			    			<ww:if test="tripline.cityid==getCityid('上海')">selected="selected"</ww:if>>上海</option>
			    		<option value="<ww:property value="getCityid('广州')" />"
			    			<ww:if test="tripline.cityid==getCityid('广州')">selected="selected"</ww:if>>广州</option>
						<option value="<ww:property value="getCityid('南京')" />"
							<ww:if test="tripline.cityid==getCityid('南京')">selected="selected"</ww:if>>南京</option>
			    	</select></li>
	 <li>目的地：<input name="s_endcityname" type="text" 
						style="width:150px; height:18px;" 
							value="<ww:property value="s_endcityname" />"/></li>
	 <li style="text-align:center; height:30px; padding-top:10px; padding-left:20px;"><input name="" class="button108" value="搜索" type="submit" /></li>
	 <li style="height:10px;"></li>
  </ul>
  </div>
  </div>
 <div class="f left">
 <div>

<div class="suoxiao box " style="width:99%">
<div class="suoxiao_1"><span class="hui12_c souxiao_1_1">通过下列条件缩小搜索范围>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span>
<input value="40" id="jumpValue" style="display:none">
        <input type="button"  style="display:none"
        onclick="var a=getElementById('jumpValue').value;sliderImage1.setValue(a);sliderImage2.setValue(a);winSlider.setValue(a)" 
        value="MoveToValue"/>
        <div class="suoxiao_2">
        <div id="sliderDetail" style="font-weight:bolder;"></div>
 <div id="sliderDemo1" style="height:40px;display:none"></div>
 <div id="sliderDemo2" style="height:40px;"></div>
 <table style="margin-top:-20px" border="0" cellpadding="0" cellspacing="0"><tr><td>200</td><td width="542px">&nbsp;</td><td>5000</td></tr></table>
          <div id="sliderDemo3" style="height:40px;display:none"></div>
          </div>
           <script type="text/javascript">
        //<![CDATA[
          var sliderImage1 = new neverModules.modules.slider(
          {targetId: "sliderDemo1",
          sliderCss: "images/webimageslider1",
          barCss: "imageBar1",
          min: 0,
          max: 20,
          hints: "move the slider"
          });
          sliderImage1.onstart  = function () {
            getElementById("sliderDetail").innerHTML = "开始: 当前价格是" +sliderImage1.getValue();
          }
          sliderImage1.onchange = function () {
            getElementById("sliderDetail").innerHTML = "onchange: sliderImage1 Current value is " +sliderImage1.getValue();
          };
          sliderImage1.onend = function () {
            getElementById("sliderDetail").innerHTML += ", onend: The end the sliderImage1 value is " +sliderImage1.getValue();
          }
          sliderImage1.create();
          sliderImage1.setValue(sliderImage1.max/2);
          //--------------------------------------------------------------------------------
          var sliderImage2 = new neverModules.modules.slider(
          {targetId: "sliderDemo2",
          sliderCss: "imageSlider2",
          barCss: "imageBar2",
          min: 200,
          max: 5000,
					ckValue:20,
          hints: "move the slider"
          });
          sliderImage2.onstart  = function () {
            getElementById("sliderDetail").innerHTML = "当前的价格范围是:￥200-￥5000" ;
          }
          sliderImage2.onchange = function () {
            getElementById("sliderDetail").innerHTML = "当前您选择的价格是:￥" +sliderImage2.getValue();
           
            
          };
          sliderImage2.onend = function () {
            getElementById("sliderDetail").innerHTML += "";
             var strHtml="";
            strHtml="<tr>";
			strHtml+="<td style='padding:10px 0 10px 0'>";
			strHtml+="<table width='735' border='0' cellspacing='0' cellpadding='0'>";
			strHtml+="<tr>";
			strHtml+="<td class='box_bottom_xu' style='padding:10px 0 10px 0'>";
			strHtml+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
			strHtml+="<tr>";
			strHtml+="<td width='90' rowspan='2' align='center'></td>";
			strHtml+="<td width='85' rowspan='2' align='center' valign='middle'></td>";
			strHtml+="<td></td>";
			strHtml+="<td width='118' rowspan='2' valign='top' style='padding-left:10px;'></td>";
			strHtml+="</tr>";
			strHtml+="<tr>";
			strHtml+="<td align='left' style='padding:5px; color:#999999;'><img src='images/webimages/loadding.gif'>&nbsp;Loading...</td>";
			strHtml+="</tr>";
			strHtml+="</table>";
			strHtml+="</td>";
			strHtml+="</tr>";
			strHtml+="</table>";
			strHtml+="</td>";
			strHtml+="</tr>";
            $.ajax({
            type:"POST",
            url:"triplinebook!toTriplineListAjax.action?usertype=<ww:property value='usertype'/>",
            data:{s_price:sliderImage2.getValue()},
            beforeSend:function(){$("#tblist").html(strHtml);},             
            success:function(data){
            $("#tblist").html(data);           
            }            
         });
          }
          sliderImage2.create();
          //--------------------------------------------------------------------------------
          var winSlider = new neverModules.modules.slider(
          {targetId: "sliderDemo3",
          sliderCss: "winSlider",
          barCss: "winBar",
          min: 0,
          max: 10000,
          hints: "move the slider"
          });
          winSlider.onstart  = function () {
            getElementById("sliderDetail").innerHTML = "当前的价格范围是:￥200-￥5000";
          }
          winSlider.onchange = function () {
            getElementById("sliderDetail").innerHTML = "当前的价格范围是:￥200-￥5000";
          };
          winSlider.onend = function () {
            getElementById("sliderDetail").innerHTML += "";
          }
          winSlider.create();
          winSlider.setValue(5000);
        //]]>
        </script>
</div>
<div class="c"></div>

<!-------------ddddd------------------>
     <div class=" box" style="margin-top: 10px;">
	 <form name="form1" method="post">
		<table id="tblist" width="98%" border="0" cellspacing="0" cellpadding="0" style="margin:0 auto; line-height:24px; padding:10px 0 10px;">
	 	  <tr>
			<td  style=" padding:10px 0 10px 0" align="center">
			<ww:property value="getPagination('\"triplinebook!toTriplineList.action?pageinfo.pagenum=\"+pageno')" />
				<table width="735" border="0" cellspacing="0" cellpadding="0">
				<ww:iterator value="listTripline">
					<tr>
						<td class="box_bottom_xu" style=" padding:10px 0 10px 0">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
							    <tr>
								    <td width="90" rowspan="2" align="center"><img onclick="window.location.href='triplinebook!toTravelDetail.action?lineid=<ww:property value="id"/>'" src="<ww:property value="getimgPath()+image"/>" width="79" height="79" style="cursor:hand" /></td>
								    <td width="85" rowspan="2" align="center" valign="middle"><ww:property value="startdate"/><br /><ww:property value="getAgentTName(customeragentid)"/></td>
								    <td><a href="javascript:void(0)" onclick="window.location.href='triplinebook!toTravelDetail.action?lineid=<ww:property value="id"/>'" style="font-size:14px; font-weight:bold"><ww:property value="name" /></a></td>
								    <td width="118" rowspan="2" valign="top" style="padding-left:10px;"> 
								    	参考价<font class="red_cu"><ww:property value="price" />元</font>起<br />
								    	<!-- 满意度 <font class="red_cu">98%</font>--> <br />
								    	<input class="button61" type="button" value="预订" onclick="window.location.href='triplinebook!toTravelDetail.action?lineid=<ww:property value="id"/>'" />
									</td>
								  </tr>
								  <tr>
								    <td align="left" style="padding:5px; color:#999999;"><ww:property value="substringDescription(description, 55)"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</ww:iterator>
				<tr>
				<td align="center"><ww:property value="getPagination('\"triplinebook!toTriplineList.action?pageinfo.pagenum=\"+pageno')" /></td>
				</tr>
				</table>
			  </td>
			</tr>
		</table>
		</form>
	</div>  
<div class="c" style="height: 10px"></div>
<!---------------------main_2 over-------------------->
<div >
</div>
</div>
</div>
</td>
</tr>
</table>

</body>
</html>
