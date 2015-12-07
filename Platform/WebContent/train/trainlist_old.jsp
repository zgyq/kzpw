
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0055)http://lieche.huoche.com/zhanzhan.php -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>${dns.companyname} 火车票查询</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<META name=description content="">
<META name=keywords content="">

<LINK rel=stylesheet type=text/css href="js/train/style.css">
<LINK rel=stylesheet type=text/css href="css/style.css"> 
<LINK rel=stylesheet type=text/css href="css/train.css">  
  

<SCRIPT type=text/javascript src="js/train/header.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/train/twocold.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/train/jquery-1.4.2.js"></SCRIPT>

<SCRIPT type=text/javascript src="js/train/yui.utilities.js"></SCRIPT>

<SCRIPT type=text/javascript src="js/train/yui.autocomplete-min.js"></SCRIPT>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT type=text/javascript src="js/train/main.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/train/input.js"></SCRIPT>
<META name=GENERATOR content="MSHTML 8.00.6001.19088"></HEAD>
<BODY><!--headerstar-->

<div>

<div id="main" style="margin-top: 5px;">
<div >
<div style="border:2px solid #91c8e5; width: 95%; margin: 0 auto">
   <div class="nav" style="margin-top: 20px" ><img src="images/icon.gif" align="absmiddle" />&nbsp;&nbsp;<font style="color:#f48000; font-size: 20px;">列车时刻查询</font>最全的列车时刻<font style="color:#f48000; font-size: 20px;">查询系统</font>。 </div>
	<div class="f">
	
<div id=search_zz class="chufa" style="height: 90px;">
<FORM id='trainform' method='POST' name=trainform action='train!search.action'>
   <div style="float: left;width: 200px;">
    <P>出发站：</P>
	<div class="minitext_bj">
	   <INPUT id=k1 type=text name='startcity'  style="width: 120px; float: left" value="<ww:property value='train.startcity'/>" autocomplete="off"> 
	   <SPAN id=k1input class=plain_btn title=选择热门城市 onclick="tanchu('k1input','k1','tanchuzz')"></SPAN>
	   <div style="Z-INDEX: 9999; MARGIN-TOP: 2px; WIDTH: 150px; COLOR: #666; MARGIN-LEFT: 5px; FONT-SIZE: 14px" id=container1></div>
	</div>
	</div>
	<div style="float: left; width: 200px;">
   <P>到达站：</P>
	<div class="minitext_bj">
	    <INPUT id=k2 type=text name='endcity' style="width: 120px; float: left" value="<ww:property value='train.endcity'/>" autocomplete="off"> 
	    <SPAN id=k2input class=plain_btn title=选择热门城市 onclick="tanchu('k2input','k2','tanchuzz')"></SPAN>
	    <div style="Z-INDEX: 9999; MARGIN-TOP: 2px; WIDTH: 150px; COLOR: #666; MARGIN-LEFT: 5px; FONT-SIZE: 14px" id=container2></div>
	</div>
	</div>

	<div style="width: 200px;  float: left;">
	<P>出发时间：</P>
<input style="WIDTH: 160px;height: 23px" name="starttime" value='<ww:property value="train.starttime"/>'
	onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" />
	</div>
	<div class="f" style="padding-left: 20PX; margin-top: 10px; " >
	<INPUT  class="button" type=button onclick="gosearch()"  value="立即查询"></div>
    
<div>
  
</div>
  
</FORM>
</div>
<div  style="display: none">
<INPUT id=zhan type=text name=zhan autocomplete="off"> 
<SPAN id=zhaninput  title=选择热门车站 ></SPAN>
<div style='display: none' id=container3></div>
</div>
	  

<!--车次搜索-->
	<div style="DISPLAY: none" id=search_checi>
	    <FORM   method=get name=form_search_checi action=>
	    <P >请输入车次：</P>
	         <div class=minitext_bj><INPUT id=checi style="width: 120px; float: left" type=text name=checi autocomplete="off"> 
	             <SPAN id=checiinput class=plain_btn title=选择热门车次 onclick="tanchu('checiinput','checi','tanchucheci')"></SPAN>
	         </div>
	         <Div>&nbsp;</Div>
	         <div><INPUT onclick="" class="button" type=button value="立即查询"></div>
	     </FORM>
	</div>
	<!--车站搜索-->
	</div>
	
    <div class="c"></div>
</div>


<div class="list" style="margin-top: 10px;">
  <div class="lbox" style="width: 95%; margin: 0 auto">
    <div style="border:2px solid #beedff">
    <ul style="padding: 20px 0 20px 40px;line-height:30px">
    
   <li><strong>车型选择：</strong>
        <input type="checkbox" id="chktype_g" name="chktype" onclick="filtertrain2();" value="g">高铁(G)	
		<input type="checkbox" id="chktype_d" name="chktype" onclick="filtertrain2();" value="d">动车(D)
		<input type="checkbox" id="chktype_z" name="chktype" onclick="filtertrain2();" value="z">直达(Z)
		<input type="checkbox" id="chktype_t" name="chktype" onclick="filtertrain2();" value="t">特快(T)
		<input type="checkbox" id="chktype_k" name="chktype" onclick="filtertrain2();" value="k">快速(K)
		<input type="checkbox" id="chktype_0" name="chktype" onclick="filtertrain2();" value="0">其他

	</li>
   <li><strong>发车时间：</strong>
            <input name="shangwu-chufa" id="shangwu-chufa" type="checkbox" value="" onclick="filtertrain2();"  />
          上午(06:00-12:00)
          <input name="xiawu-chufa" id="xiawu-chufa" type="checkbox" value="" onclick="filtertrain2();"  />
          下午(12:00-18:00)
          <input name="wanshang-chufa" id="wanshang-chufa"  type="checkbox" value="" onclick="filtertrain2();"  />
          晚上(18:00-06:00)
	</li>
   <li><strong>到站时间：</strong>
           <input  name="shangwu-daoda" id="shangwu-daoda"  type="checkbox" value="" onclick="filtertrain2();"  />
          上午(06:00-12:00)
          <input  name="xiawu-daoda" id="xiawu-daoda"  type="checkbox" value="" onclick="filtertrain2();"  />
          下午(12:00-18:00)
          <input  name="wanshang-daoda" id="wanshang-daoda"  type="checkbox" value="" onclick="filtertrain2();" />
          晚上(18:00-06:00)</li>
    </ul>
    </div>
  </div>
<div style="line-height: 30px; padding-left: 30px;">共筛选出<font style="color: #FF7200" id='traincount'>
<ww:property value="trainlist.size"/></font>
次列车</div>
<table border="0" cellpadding="0" cellspacing="0" id='timetable2'  width="95%" style="margin: 0 auto" class="lbox listtb">

<thead style="background:url(images/th.jpg); height: 30px; line-height:30px;" class="box">
<th align="left" style="font-weight:100; color:#fff">车次 - 车型</th>
<th align="left" style="font-weight:100; color:#fff">始发 - 目的地</th>
<th align="left" style="font-weight:100; color:#fff">发时</th>
<th align="left" style="font-weight:100; color:#fff">到时</th>
<th align="left" style="font-weight:100; color:#fff">用时</th>
<th align="left" style="font-weight:100; color:#fff">票价</th>
<th align="left" style="font-weight:100; color:#fff">详情</th>
</thead>
<tbody id="trainvalue">
<ww:iterator value="trainlist" status="statu">
<tr train='<ww:property value="traincode"/>'>
<td valign="top" style="line-height:24px;" <ww:if test="#statu.index>0">class="lbox_top"</ww:if>> 
<div style="margin: 5px 0 5px 0"><font class="lan14"><ww:property value="traincode"/>
</font>(<ww:property value="traintype"/>)<br/> <ww:property value="sfz"/>-<ww:property value="zdz"/> </div></td>
  <td valign="top" <ww:if test="#statu.index>0">class="lbox_top"</ww:if>  style="font-size: 14px;line-height:24px;">
 <div style="margin: 5px 0 5px 0"><img style="vertical-align: middle;"  
    src='images/<ww:if test="sfz.equals(startcity)">shifa</ww:if><ww:else>guoche</ww:else>.jpg'>
    <ww:property value="startcity"/><br/>
 <img style="vertical-align: middle;" 
    src='images/<ww:if test="zdz.equals(endcity)">zhongdao</ww:if><ww:else>guoche</ww:else>.jpg'>
    <ww:property value="endcity"/></div></td>
<td valign="top" class='hui14 fashi <ww:if test="#statu.index>0">lbox_top</ww:if>' ><ww:property value="starttime"/></td>
<td valign="top" class='hui14 daoshi <ww:if test="#statu.index>0">lbox_top</ww:if>' ><ww:property value="endtime"/></td>
<td valign="top" class='l24 <ww:if test="#statu.index>0">lbox_top</ww:if>' ><ww:property value="costtime"/><br/><ww:property value="distance"/>公里</td>
<td valign="top" <ww:if test="#statu.index>0">class="lbox_top"</ww:if>>
<div style="margin: 5px 0 5px 0"><ww:property value="getTicketPriceHtml(trainlist.get(#statu.index))"/></div>
</td>
<td valign="top" <ww:if test="#statu.index>0">class='lbox_top'</ww:if>>
<a onclick=goyptrain('<ww:property value="traincode"/>') href='javascript:void(0)'>
    <img src="images/buyico.jpg" style="margin-top: 10px;border: 0px"/></a>
</td>
</tr>
</ww:iterator>
</tbody>
</table>
<form action="train!yptrain.action" name="form1" id="form1" method="POST">
<input type='hidden' name='startcity' value='<ww:property value="train.startcity"/>'>
<input type='hidden' name='endcity' value='<ww:property value="train.endcity"/>'>
<input type='hidden' name='starttime' value='<ww:property value="train.starttime"/>'>
<input type='hidden' name='traincode' id='traincode' >
</form>
</div>
</div>

</div>
</BODY>
<script type="text/javascript">
function goyptrain(traincode){
document.getElementById("traincode").value=traincode;
document.form1.submit();
}
</script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script type="text/javascript">
function gosearch(){
 dispose("系统正在为您查询");
 document.trainform.submit();
}

function dispose(message) {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
</script>
</HTML>
