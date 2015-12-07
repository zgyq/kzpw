
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
  <script type="text/javascript">

jQuery().ready(function(){
ajaxsearchyp();

});

function ajaxsearchyp(){
 var dstartcity=jQuery("#twostartcity").val();
 var dendcity=jQuery("#twoendcity").val();
 var dtraincode=jQuery("#twotraincode").val();
 var dstarttime=jQuery("#twostarttime").val();
 setDate(dstarttime);
 var bfhtml='<tr><td width="100%" colspan="10" height="100px" style="text-align: center;"><img src="images/loading.gif" /></td></tr>';
  jQuery.ajax({
            type:"POST",
            url:"train!ajaxYPList.action",
            data:{startcity:dstartcity,endcity:dendcity,traincode:dtraincode,starttime:dstarttime},
              beforeSend:function(){ jQuery("#trainvalue").html(bfhtml);}, 
            success:function(data){
             
              jQuery("#trainvalue").html(data);
            }            
		 });

}

function serchyp(){
document.forms.from_search_zz.submit();
}
function checkTrain(value){
   var childrens=document.getElementById("trainvalue").childNodes;
   for(var i=0;i<childrens.length;i++){
     var v=childrens[i];
     v.style.display='none';
   }
   if(value=="O"){
    for(var i=0;i<childrens.length;i++){
     var v=childrens[i];
     v.style.display='block';
    }
   }else{
    for(var i=0;i<childrens.length;i++){
     var v=childrens[i];
     if(v.className==value){
     v.style.display='block';
     }
    }
   
   }
}

function toordertrain(train){
  setValue('traincode',train.traincode);
  setValue('startcity',train.startcity);
  setValue('endcity',train.endcity);
  setValue('starttime',train.starttime);
  setValue('endtime',train.endtime);
  setValue('wzyp',train.wzyp);
  setValue('yzyp',train.yzyp);
  setValue('yzprice',train.yzprice);
  setValue('ywyp',train.ywyp);
  setValue('ywsprice',train.ywsprice);
  setValue('ywzprice',train.ywzprice);
  setValue('ywxprice',train.ywxprice);
  setValue('rz2yp',train.rz2yp);
  setValue('rz2price',train.rz2price);
  setValue('rz1yp',train.rz1yp);
  setValue('rz1price',train.rz1price);
  setValue('rzyp',train.rzyp);
  setValue('rzprice',train.rzprice);
  setValue('rwyp',train.rwyp);
  setValue('rwsprice',train.rwsprice);
  setValue('rwxprice',train.rwxprice);
  setValue('gwyp',train.gwyp);
  setValue('gwsprice',train.gwsprice);
  setValue('gwxprice',train.gwxprice);
  document.orderform.submit();
}

function datesearch(l){
  var time=jQuery(l).attr("date");
if(time==''||time==null||time==undefined){
  time='<ww:property value="train.starttime"/>';
}
jQuery("#twostarttime").val(time);
ajaxsearchyp();
}

</script>
<META name=GENERATOR content="MSHTML 8.00.6001.19088"></HEAD>
<BODY><!--headerstar-->
<div >
<div id="main" style="margin-top: 5px;">
<div>
<div style="border:2px solid #91c8e5; width: 95%; margin: 0 auto">
   <div class="nav" style="margin-top: 20px" ><img src="images/icon.gif" align="absmiddle" />&nbsp;&nbsp;<font style="color:#f48000; font-size: 20px;">列车时刻查询</font>最全的列车时刻<font style="color:#f48000; font-size: 20px;">查询系统</font>。 </div>
	<div class="f">
	
<div id=search_zz class="chufa" style="height: 90px;">
<FORM id='trainform' method='POST' name=trainform action='train!yptrain.action'>
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
	<INPUT  class="button" type=submit value="立即查询"></div>
    
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

<div  style="width: 95%; margin: 0 auto">

  <div class="xiqi" style="height: 24px; overflow: hidden;">
    <ul id='uldate'>
     <li class="xiqiout" style="cursor: pointer;" onclick=datesearch(this)>&nbsp;</li>
     <li class="xiqiout" style="cursor: pointer;" onclick=datesearch(this)>&nbsp;</li>
     <li class="xiqiout" style="cursor: pointer;" onclick=datesearch(this)>&nbsp;</li>
     <li class="xiqion"  style="cursor: pointer;" onclick="datesearch(this)">&nbsp;</li>
     <li class="xiqiout" style="cursor: pointer;" onclick="datesearch(this)">&nbsp;</li>
     <li class="xiqiout" style="cursor: pointer;" onclick="datesearch(this)">&nbsp;</li>
     <li class="xiqiout" style="cursor: pointer; margin-right: 0" onclick="datesearch(this)" >&nbsp;</li>
    </ul>
  </div>
   <div >
	<TABLE cellSpacing=0 cellPadding=0 border=0 width="100%" class="lbox listtb" >
			<THEAD style="background:url(images/th.jpg); height: 30px; line-height:30px;" class="box">
				<TR  id='ta'>
					<TH align="left" style="height: 30px">
					<select id='aaaa' onchange="checkTrain(this.value)">
					<option value='O'>车次</option>
					<option value='G'>高铁</option>
					<option value='D'>动车</option>
					<option value='T'>特快</option>
					<option value='K'>快速</option>
					</select>
					</TH>
					<TH align="left"><font style="font-weight:100; color:#fff">出发-到站</font></TH>
					<TH align="left"><font style="font-weight:100; color:#fff" color="#FFFF00">运行时间</font></TH>
					<TH align="left"><font style="font-weight:100; color:#fff" color="#FFFFFF">硬座</font></TH>
					<TH align="left"><font style="font-weight:100; color:#fff" color="#FFFFFF">软座</font></TH>
					<TH align="left"><font style="font-weight:100; color:#fff" color="#FFFFFF">硬卧 上/中/下</font></TH>
					<TH align="left"><font style="font-weight:100; color:#fff" color="#FFFFFF">软卧 上/下</font></TH>
					<TH align="left"><font style="font-weight:100; color:#fff" color="#FFFFFF">订票</font></TH>
				</TR>
			</THEAD>
			<TBODY id="trainvalue">		
			<!-- <ww:iterator value="trainlist" status="statu" id="id">
					<TR <ww:if test="#statu.index==0">style='background: #d1e6f8'</ww:if>  class='<ww:property value="traincode.substring(0,1)"/>'>
						<TD height="50px"><b class="lan14"><ww:property
							value="traincode" /></b><br />
						<ww:property value="traintype" /></TD>
						<TD><ww:property value="startcity" /><ww:property
							value="starttime" /> <br />
						<ww:property value="endcity" /><ww:property value="endtime" /></TD>
						<TD><ww:property value="distance" />公里<br />
						<ww:property value="costtime" /></TD>
						 硬座 
						<TD>						
						<ww:property value='getTrainpriceByYP(yzyp,yzprice,"￥")' />
						</TD>
						<TD>
						<ww:if test="existSeat(rz2yp)">
							<ww:property value='getTrainpriceByYP(rz2yp,rz2price,"二等￥")' />
							<br />
							<ww:property value='getTrainpriceByYP(rz1yp,rz1price,"一等￥")' />
							<br />
							<ww:property value='getTrainpriceByYP(rzyp,rzprice,"特等￥")' />
						</ww:if> <ww:else>
							<font style="color: #ccc">--</font>
						</ww:else></TD>
						<TD><ww:if test="existSeat(ywyp)">
							<ww:property value='getTrainpriceByYP(ywyp,ywsprice,"上￥")' />
							<br />
							<ww:property value='getTrainpriceByYP(ywyp,ywzprice,"中￥")' />
							<br />
							<ww:property value='getTrainpriceByYP(ywyp,ywxprice,"下￥")' />
						</ww:if> <ww:else>
							<font style="color: #ccc">--</font>
						</ww:else></TD>
						<TD><ww:if test="existSeat(rwyp)">
							<ww:property value='getTrainpriceByYP(rwyp,rwsprice,"上￥")' />
							<br />
							<ww:property value='getTrainpriceByYP(rwyp,rwxprice,"下￥")' />
							<br />
						</ww:if> <ww:else>
							<font style="color: #ccc">--</font>
						</ww:else></TD>
						<TD>
						<ww:if test="hasYP(trainlist.get(#statu.index))">
						 <img src="images/buyico.jpg" style="margin-top: 10px;cursor: pointer;" 
						 onclick=toordertrain(<ww:property value="json"/>); />
						</ww:if> <ww:else>
							<font color='#cccccc'>已售完</font>
						</ww:else>
						<br/>
						<span style="cursor: pointer;" onclick=showInfo('<ww:property value="traincode"/>',<ww:property value="#statu.index"/>)>&nbsp;&nbsp;详情</span>
						</TD>
					</TR>
					<tr>
					<td colspan="8" style="padding: 0">
					<div class="tinfo lbox"  id='divinfo<ww:property value="#statu.index"/>' style="display:none; text-align: center; width:670px;  margin: 8px">
					</div>
					
					</td>
					</tr>
					<tr>
					 <td colspan="8" style="height: 1px; line-height: 1px; overflow:hidden; padding: 0 ">
					 <div style="height: 1px; background:#91c8e5; line-height: 1px; overflow: ">&nbsp;</div>
					 </td>
					</tr>
				</ww:iterator>-->
			</TBODY>
		</TABLE>
		</div>
</div>
</div>
  
</div>
<DIV style="display: none">
<form id='datesform' action="train!yptrain.action" method="post">
<input id='twostartcity' name="startcity" value='<ww:property value="train.startcity"/>' >
<input name="endcity" id='twoendcity' value='<ww:property value="train.endcity"/>' >
<input id='twostarttime' name="starttime" value='<ww:property value="train.starttime"/>' >
<input id='twotraincode' name="traincode" value='<ww:property value="train.traincode"/>'  >
</form>
<form id='orderform' method="post" name='orderform' action="train!toordertrain.action">
<input id='startdate' name="startdate" value='<ww:property value="train.starttime"/>'>
<input id=traincode name="traincode">
<input id=startcity name="startcity">
<input id=endcity name="endcity">
<input id=starttime name="starttime">
<input id=endtime name="endtime">
<input id=yzyp name="yzyp">
<input id=yzprice name="yzprice">
<input id=rz2yp name="rz2yp">
<input id=rz2price name="rz2price">
<input id=rz1yp name="rz1yp">
<input id=rz1price name="rz1price">
<input id=rzyp name="rzyp">
<input id=rzprice name="rzprice">
<input id=ywyp name="ywyp">
<input id=ywsprice name="ywsprice">
<input id=ywzprice name="ywzprice">
<input id=ywxprice name="ywxprice">
<input id=rwyp name="rwyp">
<input id=rwsprice name="rwsprice">
<input id=rwxprice name="rwxprice">
<input id=gwyp name="gwyp">
<input id=gwsprice name="gwsprice">
<input id=gwxprice name="gwxprice">
</form>
</DIV>
</BODY>
