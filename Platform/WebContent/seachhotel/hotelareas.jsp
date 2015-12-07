<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ taglib uri="b2b2c" prefix="bb"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>目的地精选:酒店预订, 机票预订, 旅游度假, 商旅管理---天河联盟商旅网</title>
<link href="hstyle/base.css" type="text/css" rel="stylesheet" />
<link href="hstyle/hotel.css" type="text/css" rel="stylesheet" />
<link href="hstyle/autocomplete.css" type="text/css" rel="stylesheet" />

<script src="js/jquery1.3.2.js" type=text/javascript></script>
<script language="javascript" type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/j.suggest.js"></script>
<script type="text/javascript" src="js/region.suggest.js"></script>
<script src="js/index.js" type=text/javascript></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/city_data_pp.js"></script>
<script language="javascript" type="text/javascript" src="js/citycontrol/city_date2.js"></script>

<script type="text/javascript">
$(document).ready(function(){
        loadCityData();
      loadregiondata($("#city_hotel_hide").val());
      //$("#txthotelcity").suggest(citysh,{hot_list:commoncitysh,dataContainer:'#city_hotel_hide',attachObject:'#suggest'});
      $("#txtregionid").suggestregion(regions,{hot_list:commonregion,dataContainer:'#hotel_region_id',attachObject:'#suggestregion'});
});

 //查询
function seach(){
 if(datacheckh())
    {
      document.form1.submit();
    }
 }
 //点击行政区名称进行查询
function gotosearch(regionid)
{
   $("#hotel_region_id").val(regionid);
   document.form1.submit();
}
</script>

</head>

<body>
<body>
<jsp:include page="../top.jsp"></jsp:include>
<div id="container">

<div id="content">
  <div class="left">
      <div class="topx">&nbsp;</div>
      <div class="search">
          <div style="background:url(images/ksdf.gif); height:38px; margin:3px 0 0 3px; width:235px;"> 
             &nbsp;
          </div>
           <form action="hotelsubscribe!sousuo.jspx" method="post" name="form1" id="form1">
               <table width="238" border="0" cellspacing="0" cellpadding="0" height="236" background="#fff"   >
                  <tr>
                    <td width="1" height="183" align="left" valign="top">
                    <img src="images/shu.gif" width="1"  height="183" style="margin-left:-2px;" />
                    </td>
                    <td >
                        <table cellpadding="0" cellspacing="0"  border="0"  class="searchh">
                        <tr>
                        <td align="right"><strong><span style="color: red;">*</span>选择城市</strong></td>
                        <td>
                          <input type="text" class="input198" id="txthotelcity" name="hotelcity" value="<ww:property value="s_hotelcity" />" onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); " /> 
                          <div id="suggest" class="ac_results"></div>
                         <input type="hidden" id="city_hotel_hide" name="cityId" value="<ww:property value="s_cityid" />" 
                          onpropertychange="loadregiondata($('#city_hotel_hide').val());" />
                      </td>
                        </tr>
                        <tr>
                        <td align="right"><strong><span style="color: red;">*</span>入住时间</strong></td>
                        <td align="right"><input type="text" class="Wdate input198" id="txtcheckindate"
					      name="startDate" value="<ww:property value="startDate"/>"
					      onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', 
					      onpicked:function(){txtcheckoutdate.focus();}})" />
				       </td>
                        </tr>
                        <tr>
                        <td align="right"><strong><span style="color: red;">*</span>离店时间</strong></td>
                        <td><input type="text" class="Wdate input198" id="txtcheckoutdate"
					       name="endDate" value="<ww:property value="endDate"/>"
					       onfocus="this.value=getDateDiff($('#txtcheckindate').val(),1);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})" />
				       </td>
                        </tr>
                        <tr>
                        <td align="right"><strong>关键字</strong></td>
                        <td><input type="text"  maxlength="10" class="input198" name="hotelName" value="<ww:property value="hotelName" />" /> </td>
                        </tr>
                        <tr>
                        <td align="right"><strong>区域搜索</strong></td>
                        <td>
                        <script>
                        function changregion()
                        {
                        	if(!document.getElementById("txtregionid").value.length>0)
                        	{
                        		document.getElementById("hotel_region_id").value="";
                        		document.getElementById("txtregionid").value="--请选择行政区--";
                        	}
                        }
                        </script>
                        <input type="text" class="input198" id="txtregionid" onchange="changregion()" value="<ww:property value="getRegionNameByStr(regionid)" />" /> 
                        
                        <div id="suggestregion" class="ac_results"></div>
		                <input type="hidden" id="hotel_region_id" name="regionid" value="<ww:property value="regionid"/>" /></td>
                        </td>
                        </tr>
                        <tr>
                        <td align="right"><strong>价格范围</strong></td>
                         <td>
                        <select id="ddlprice" name="s_price" style="width:126px">
                          <option vlaue="0">不限</option>
                          <option vlaue="1">RMB 250以下</option>
                          <option vlaue="2">RMB 250-400</option>
                          <option vlaue="3">RMB 400-600</option>
                          <option vlaue="4">RMB 600-800</option>
                          <option vlaue="5">RMB 800以上</option>
                        </select>
                        </td>
                        </tr>
                        </table>
                    </td>
                    <td align="left" valign="top" > <img src="images/shu.gif" width="1" height="183" /></td>
                  </tr>
                  <tr><td colspan="3" class="he3">&nbsp;</td></tr>
                  <tr>
                  <td colspan="3" background="images/bj_tj.gif" width="100%" height="40" style="padding:0"  >
                  <div class="tijiao" ><input type="button" value="立即搜索" onclick="seach();" class="button_tj"  /></div>
                   
                  </td>
                  </tr>
                 
                </table>
       </form>
      </div>
      <div class="r"><img src="images/bj_sear.gif" width="9" height="277" /></div>
      <div class="c"></div>
      <div><img src="images/bj_bott.gif" width="260" height="16" /></div>
 <!-------------搜索结束------------->
     
       <div class="liansuo">
         <div class="duan hei_14c">最新活动</div>
         <div class="box_nt p6">
            <!--<div class="ad"><img src="images/ad_4.gif" width="250"
	height="110" /></div>
<div class="ad"><img src="images/ad_8.gif" width="250"
	height="110" /></div>

-->
<ww:iterator value="listCampaign">
<div class="ad">
<img src="<ww:property value="getimgPath()+picsrc"/>" width="250" height="110" />
</div>
</ww:iterator>
         </div>
      </div>
       <!--最新活动结束--> 
  </div>
<!------------left 结束------------->
  <div class="right">
    <div class="seachhh" style="width:660px; line-height:24px; background:#D8EAF4; padding:0 10px 0 10px; float:left" >
     <font class="f" style="color:#0E548A">&nbsp;</font>
     <b class="r">&nbsp;</b>
     <span class="c"></span>
    </div>
    <div class="c"></div>
    <div class="jiudian">
    <div class="chang_list"><b class="lan_14 f">●<ww:property value="getCityNameByStr(strHotelCity)" />行政区</b></div>
        <div style="padding-top:10px;padding-left:20px">
        <table width="95%" border="0" cellspacing="0" cellpadding="0" >
          <tr> 
             <ww:if test="listregion.size>0">
             <ww:iterator value="listregion" status="regionStatus">
             <ww:if test="#regionStatus.index % 3 == 0">
             </tr>
              <tr>
             </ww:if>
             <td><a href="#" onclick="gotosearch(<ww:property value="id" />);"><ww:property value="name" /></a></td>
             </ww:iterator>
             </ww:if>
             <ww:else>
             <td>暂无数据</td>
             </ww:else>
          </tr>
        </table>
        </div>
     </div> 
     
     <div class="chang_list"><b class="lan_14 f">●<ww:property value="getCityNameByStr(strHotelCity)" />商业区</b></div>
        <div style="padding-top:10px;padding-left:20px">
        <table width="95%" border="0" cellspacing="0" cellpadding="0" >
          <tr> 
             <ww:iterator value="listshangyeregion" status="regionStatus">
             <ww:if test="#regionStatus.index % 3 == 0">
             </tr>
              <tr>
             </ww:if>
             <td><a href="#" onclick="gotosearch(<ww:property value="id" />);"><ww:property value="name" /></a></td>
             </ww:iterator>
          </tr>
        </table>
        </div>
     </div>     
       
    </div>
  </div>
<!--right结束-->

<jsp:include page="../bottom.jsp"></jsp:include>
</div>
</div>
</body>
</html>
