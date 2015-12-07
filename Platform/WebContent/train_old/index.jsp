
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
<SCRIPT type=text/javascript src="js/train/jquery-1.4.2.js"></SCRIPT>

<SCRIPT type=text/javascript src="js/train/yui.utilities.js"></SCRIPT>

<SCRIPT type=text/javascript src="js/train/yui.autocomplete-min.js"></SCRIPT>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT type=text/javascript src="js/train/main.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/train/input.js"></SCRIPT>
<META name=GENERATOR content="MSHTML 8.00.6001.19088"></HEAD>
<BODY><!--headerstar-->

<div >
<div id="main" style="margin-top:20px;"> 
<div>
<div style="border:2px solid #91c8e5">
   <div class="nav" style="margin-top: 10px;" ><img src="images/icon.gif" align="absmiddle" />&nbsp;&nbsp;<font style="color:#f48000; font-size: 20px;">列车时刻查询</font>最全的列车时刻<font style="color:#f48000; font-size: 20px;">查询系统</font>。 </div>
	<div class="f">
	
<div id=search_zz class="chufa">
<FORM id=form1 method='POST' name=form1 action='train!search.action'>
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
	<div class="c"></div>
	<div style="width: 200px; padding-top: 15px; float: left;">
	<P>出发时间：</P>
<input style="WIDTH: 160px;height: 23px" name="starttime" value='<ww:property value="train.starttime"/>'
	onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" />
	</div>
	<div class="f" style="padding-left: 40PX; padding-top: 24px;" >
	<INPUT onclick="gosearch()" class="button" type=button value="立即查询"></div>
    <Div style="clear:both;line-height:50px; color:#06f">最真实的火车票数据系统。</Div> 
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
	         <div><INPUT onclick="gosearch()" class="button" type=button value="立即查询"></div>
	     </FORM>
	</div>
	<!--车站搜索-->
	</div>
	<div class="f">
	  <div style="line-height:32px; margin-top:10px; padding-right: 10px; "> 
	  <font style="font-size:14px;color:#06f">北京到上海共9次列车</font>
	  <ul style="border-top:1px solid #06f ">
	  <li><b>T-空调特快</b>: 共4次 上午1次 下午1次 晚上2次</li>
	  <li><b>K-空调快速</b>: 共1次 上午0次 下午0次 晚上1次</li>
	  <li><b>最快车次</b>:D31 运行时间10小时18分</li>
	  <li><b>最便宜车次</b>:1461票价158元</li>
	  </ul>
	  </div>
	 
	</div>
    <div class="c"></div>
</div>

</div>

</div>
</BODY>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script type="text/javascript">
function gosearch(){
 dispose("系统正在为您查询");
 document.form1.submit();
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
