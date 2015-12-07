<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>航班列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
   <style type="text/css"><!--
tr.alt td {
        background:#ffffff;  /*这行将给所有的tr加上背景色*/
}
 
tr.over td {
        background:#f6fafd;  /*这个将是鼠标高亮行的背景色*/
        cursor:pointer;
}

.selectedClass
{
    background:#fdfdde;  /*选中航班高亮行的背景色*/
}


.hr1{height:1px;border:none;border-top:1px dashed #cccccc;}
.bordertable{border-collapse:collapse;border-top:1px dotted #cccccc;border-bottom:1px dotted #cccccc;}

--></style>
   <script type="text/javascript" language="javascript">
   $(document).ready(function() {
     $("span[id*='span_lowrateinfo_']").each(function(i){
        $.ajax({
	         type:"POST",
	         url:"airsearch!GetZrateByFlight.action",
	         data:{s_fromcity:$("#hidfromcitycode_"+i).val(),s_tocity:$("#hidtocitycode_"+i).val(),s_fromdate:$("#hidfromdate_"+i).val(),s_aircompanycode:$("#hidaircompany_"+i).val(),s_flightnumber:$("#hidflightnumber_"+i).val(),s_cabincode:$("#hidcabincode_"+i).val()},
	         beforeSend:function(){$("#span_lowrateinfo_"+i).html("<img src='images/loadding.gif' />")},             
	         success:function(data){
	            $("#span_lowrateinfo_"+i).html(data);
	         }            
	         });
       });
       
   });
   
   function getOtherZrate(index)
   {
       //加载其他舱位政策
       var name="span_rateinfo_"+index+"_";
       $("span[id*='"+name+"']").each(function(i){
       $.ajax({
         type:"POST",
         url:"airsearch!GetZrateByFlight.action",
         data:{s_fromcity:$("#hidfromcitycode_"+index+"_"+i).val(),s_tocity:$("#hidtocitycode_"+index+"_"+i).val(),s_fromdate:$("#hidfromdate_"+index+"_"+i).val(),s_aircompanycode:$("#hidaircompany_"+index+"_"+i).val(),s_flightnumber:$("#hidflightnumber_"+index+"_"+i).val(),s_cabincode:$("#hidcabincode_"+index+"_"+i).val()},
         beforeSend:function(){$("#span_rateinfo_"+index+"_"+i).html("<img src='images/loadding.gif' />")},             
         success:function(data){
            $("#span_rateinfo_"+index+"_"+i).html(data);
         }            
         });
       }); 
   }
         
   function showAllberth(showid){
    $("#cabin_" + showid).slideToggle("fast");
    $("#cabin_" + showid).toggleClass("selectedClass");
    $("#order_" + showid).toggleClass("selectedClass");
    //加载其他舱位返点
    getOtherZrate(showid);
    };
     function showtg(e,tbname)
        {
        var nn6=document.getElementById&&!document.all; 
        var ent= nn6 ? e.target : event.srcElement;
        
		var height = findPosY(ent)+ent.clientHeight;
		var hheiht = document.body.clientHeight;
		if(hheiht-height<100)
		{
		    height=(height-1);
		}
		var width = findPosX(ent);
		var hwidth = document.body.clientWidth;
		if(hwidth-width>250)
		{
		    width=width+ent.offsetWidth;
		}else{
		    width=width-1;
		}
		CreateDiv("tginfoview");
		setAttribs("tginfoview","border","1   solid   #99CCCC");
		setAttribs("tginfoview","width","250px");
		setAttribs("tginfoview","align","center");
		setAttribs("tginfoview","background","#f4ffff");
		setAttribs("tginfoview","padding","5px");
		setAttribs("tginfoview","font","12px");
		setAttribs("tginfoview","margin","10px auto");
		
		setAttribs("tginfoview","top",height+"px");
		setAttribs("tginfoview","left",width+"px");
		setAttribs("tginfoview","position","absolute");
		setAttribs("tginfoview","color","#ff6600");
		var lids = document.getElementById("tginfoview");
		//var tgtd = document.getElementById(tbname);
		lids.innerHTML=tbname;
    }
    function HiddenTg()
    {
         removeobject("tginfoview");
    }
      function findPosY(obj)
    {
        var curtop = 0;
        if (obj.offsetParent)
        {
            while (obj.offsetParent)
            {
                curtop += obj.offsetTop
                obj = obj.offsetParent;
            }
        }
        else if (obj.y)
            curtop += obj.y;
        return curtop;
    }
    function findPosX(obj)
    {
        var curleft = 0;
        if (obj.offsetParent)
        {
            while (obj.offsetParent)
            {
                curleft += obj.offsetLeft
                obj = obj.offsetParent;
            }
        }
        else if (obj.x)
            curleft += obj.x;
        return curleft;
    }
    function CreateDiv(ids)
    {
	    var str = document.createElement("div");
	    str.id=ids;
	    document.body.appendChild(str);
    }
    function setAttribs(ids,attribs,value)
    {
	    var sid = document.getElementById(ids);
	    if(document.all)
	    {
		    sid.style.setAttribute(attribs,value); 
	    }else{
		    sid.setAttribute(attribs,value);
	    }
    }
    function removeobject(ids)
    {
       try{
	    var sid = document.getElementById(ids);
	    document.body.removeChild(sid);
	   }
	   catch(e)
	   {
	   }
    }
    
    function onnext(url_go,obj,index,cabinid){
    $("#divFlighInfo").html("");
	var HfFligIndex=document.getElementById("HfFligIndex");
	var HfCabinid=document.getElementById("HfCabinid");
	var HfFligID=document.getElementById("HfFligID");
	if(obj=="1")
	{
	    HfFligIndex.value="order_"+index;

	}
	else if(obj=="2")
	{
	    HfFligIndex.value="cabin_"+index;
	    HfCabinid.value=cabinid;
	}
	document.form1.action="airsearch!tobookback.action";
    document.form1.submit();
    
	$("#divFlighInfo").html("<div align='center' class='font_green_14'><br />正在查询返程航班,请稍等...&nbsp;&nbsp;<img src='images//loading.gif' width='70px' height='10px' /><br /><br /><br /></div>");
    
}


    //按票价排序（升序/降序）
function orderbyprice(){
	arr = new Array();
	var rowscount = $("tr[id*='order_']").length;
	for(i=0;i<rowscount;i++){
		var s = $("tr[id*='order_" + i + "']").html();
		var re = /￥\d{1,5}/i;
		var rs = "" + s.match(re);
		arr[i] = rs.substr(1);
	}
	var temp = arr[0];
	var orderBy=document.getElementById("hfOrderBy").value;
	if(orderBy=="or1"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 > arr[j] * 2){
				    temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    }
		    }
	    }
	    document.getElementById("hfOrderBy").value="or2";
	}else if(orderBy=="or2"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 < arr[j] * 2){
				    temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    }
		    }
	    }
	    document.getElementById("hfOrderBy").value="or1";
	}
	pre = 0;
	for(i=0;i<rowscount;i++){
		if(arr[i] == pre) continue;
		pre = arr[i];
		$("tr[id*='order_']:contains('￥" + arr[i] + "')").each(function(){
            aaa = $(this);
            bbb = aaa.next();
            ccc = bbb.next();
            aaa.appendTo($("#ordert"));
            bbb.appendTo($("#ordert"));
            ccc.appendTo($("#ordert"));
		});
	}
}
     //返程预订按钮点击
     function gotoBookback(obj,index,cabinid)
     {   
         var HfFligIndex=document.getElementById("HfFligIndex2");
	     var HfCabinid=document.getElementById("HfCabinid2");
	     var HfFligID=document.getElementById("HfFligID");
	     
	     if(obj=="1")
	      {
	         HfFligIndex.value="order_"+index;

	      }
	      else if(obj=="2")
	      {
	        HfFligIndex.value="cabin_"+index;
	        HfCabinid.value=cabinid;
	      }
	      
	      document.form1.action="airsearch!tocreateorder.action";
     	  document.form1.submit();
     }
     //单程预订按钮点击
     function gotoBookto(obj,index,cabinid)
     {   
         var HfFligIndex=document.getElementById("HfFligIndex");
	     var HfCabinid=document.getElementById("HfCabinid");
	     var HfFligID=document.getElementById("HfFligID");
	     
	     if(obj=="1")
	      {
	         HfFligIndex.value="order_"+index;

	      }
	      else if(obj=="2")
	      {
	        HfFligIndex.value="cabin_"+index;
	        HfCabinid.value=cabinid;
	      }
	      document.form1.action="airsearch!tocreateorder.action";
     	  document.form1.submit();
      }
    
    </script>
</head>

<body>
<form action="" name="form1" method="post">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;航班列表</b></td>
  </tr>
  <tr>
    <td>
      <ww:property value="strHeaderHtml"/>
     </td>
  </tr>
  <tr>
  <td>
        <div id="divFlighInfo"><ww:property value="listStrHtml"/></div>
  </td>
  </tr>
   <tr>
   <td>
   <input type="hidden" id="HfFligIndex" name="s_HfFligIndex" value="<ww:property value="s_HfFligIndex"/>" />
   <input type="hidden" id="HfFligIndex2" name="HfFligIndex2" value="<ww:property value="HfFligIndex2"/>" />
   <input type="hidden" id="HfFligID"  value="<ww:property value="HfFligID"/>"/>
   <input type="hidden" id="HfCabinid" name="HfCabinid"  value="<ww:property value="HfCabinid"/>"/>
   <input type="hidden" id="HfCabinid2" name="HfCabinid2"  value="<ww:property value="HfCabinid2"/>"/>
   <input type="hidden" id="HfCustomerID" />
   <input type="hidden" id="hfOrderBy" />
   
   <input type="hidden" id="AirCompanyName" name="flightInfo.AirCompanyName" value="东方航空" calss="航空公司" />
   <input type="hidden" id="Airline" name="flightInfo.Airline" value="CM1002" class="航班号" />
   <input type="hidden" id="AirplaneType" name="flightInfo.AirplaneType" value="747" class="机型" />
   <input type="hidden" id="StartAirportName" name="flightInfo.StartAirportName" value="首都国际机场" class="起飞起场名称" />
   <input type="hidden" id="EndAirportName" name="flightInfo.EndAirportName" value="上海浦东机场" class="到达机场名称" />
   <input type="hidden" id="AirportFee" name="flightInfo.AirportFee" value="50" class="机场建设费" />
   <input type="hidden" id="FuelFee" name="flightInfo.FuelFee" value="50" class="燃油费" />
   <input type="hidden" id="s_DepartTime" name="s_DepartTime" value="2010-03-12 12:10:12" class="起飞时间" />
   <input type="hidden" id="s_ArriveTime" name="s_ArriveTime" value="2010-03-13 12:12:12" class="到达时间" />
   
   <input type="hidden" id="Price" name="carbinInfo.Price" value="1500" class="全价价格"/>
   <input type="hidden" id="Discount" name="carbinInfo.Discount" value="0.5" class="折扣"/>
   </td>
 </tr>
    </table>
    </div>
    </form>
</body>
</html>


