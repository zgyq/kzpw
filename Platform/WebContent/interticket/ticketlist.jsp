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
<title>国际机票查询</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/autocomplete.css" rel="stylesheet" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<link href="style/airco.css" rel="stylesheet" type="text/css" />
    
<style type="text/css"><!--
tr.alt td {
        background:#ffffff;  /*这行将给所有的tr加上背景色*/
}
 
tr.over td {
        background:#fdfdde;  /*这个将是鼠标高亮行的背景色*/
        cursor:pointer;
}

.selectedClass
{
    background:#fdfdde;  /*选中航班高亮行的背景色*/
}

td {
	padding-left: 3px;
}
#waiting {
	Z-INDEX: 90; BORDER-BOTTOM: black 1px solid; POSITION: absolute; BORDER-LEFT: black 1px solid; PADDING-BOTTOM: 5px; BACKGROUND-COLOR: #effbff; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; DISPLAY: none; BORDER-TOP: black 1px solid; BORDER-RIGHT: black 1px solid; PADDING-TOP: 5px
}
.csstab
{
BACKGROUND: #fff no-repeat right bottom; HEIGHT: 100%; COLOR: #373737; CLEAR: both; FONT-SIZE: 12px; OVERFLOW: hidden; margin-top:10px; BORDER-TOP: #cccccc 1px solid; BORDER-RIGHT: #cccccc 1px solid;BORDER-BOTTOM: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid;voice-family: inherit
}
.hr1{height:1px;border:none;border-top:1px dashed #cccccc;}
.hr2{height:1px;border:none;border-top:1px solid #cccccc;}
.bordertable{border-collapse:collapse;border-top:1px dotted #cccccc;border-bottom:1px dotted #cccccc;}

--></style>

<script type="text/javascript" src="js/interticket/jquery.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>  
<script src="js/jquery.dimensions.js" type="text/javascript"></script> 
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<script src="js/interticket/app.v2.js" type="text/javascript"></script>
<script src="js/interticket/lib.js" type="text/javascript"></script>

  

<script type="text/javascript" language="javascript">
 $(document).ready(function() {
     $("tr[id*='route_']").each(function(i)
     {
        if(i!=0)
        {
           $(this).hide();
        }
        
     });
     $("tr[id*='routeb_']").each(function(i){
        if(i!=0)
        {
           $(this).hide();
        }
     });
  });
   function showrouteInfo(showid){
        if($("#routeflag_"+ showid).val()=="0")
        {
           $("#route_" + showid).slideDown('fast');
           $("#routeb_" + showid).slideDown('fast');
           $("#routeflag_"+ showid).val("1");
        }
        else
        {
           $("#route_" + showid).slideUp('fast');
           $("#routeb_" + showid).slideUp('fast');
           $("#routeflag_"+ showid).val("0");
        }
        
        var objimg= $("#img" + showid);
        var objspan=$("#span_" + showid);
		if(objimg.attr('src') == "images/plus.gif"){
			objimg.attr('src','images/nofollow.gif');
			objspan.html("<b>收起</b>");
		}else{
			objimg.attr('src','images/plus.gif');
			objspan.html("<b>详细</b>");
		}
    };
    //预订按钮点击
     function gotoBook(routeid,flightid)
     {
       //alert("国际机票价格波动过大,为确保你的利益,请致电"+<ww:property value='#session.dns.serviceline' />+"预订!");
     
       //return;
     
        var flightstr="";
        document.getElementById("HfSelectRoutID").value=$("#routeID_"+routeid).val();
        $("#route_"+routeid).find("input[id*='HidFlightNo_']").each(function(i) {
           flightstr+=$(this).val()+"|";
        });
        document.getElementById("HfSelectFligID").value=flightstr;
        document.getElementById("HfFlightID").value=flightid;
        document.form1.submit();
     }
   //显示其他航班信息
   function showOtherFlight(objid,rowcount,routeid,spanname)
   {  
        $("#"+spanname).click(function(event)
        {
           $("#divIframe").dialog("open");
        });
        $("#divIframe").dialog({
                title:'其他航班信息',
                show: null,
                bgiframe: false,
                autoOpen: false,
                draggable: true,                
                resizable: true,
                modal: true,
                width: 680,
                height: 400
            });
            
        //拼出其他航班信息
        var divFlightInfo=document.getElementById("divIframe");
        divFlightInfo.innerHTML="<table width='100%' border='0' cellspacing='0' cellpadding='0'>"+document.getElementById("tbHidFlight_"+routeid+"_"+objid).innerHTML+"</table>";     
   }
   function BindOtherFlight(totalNum)
   {
       if(checksel())
       {
       //将选中的其他航班替换掉默认航班       
        var HfrdoValue=$('#HfRdoValue').val(); 
        var HfSELIndex=$("#HfSELIndex").val();
        var HFNO=$("#HfNO").val();
        var HfRouteID=$("#HfRoutID").val();
        var HfFID=$("#HFFID").val();
        var strHtml="";
         strHtml+="<td align='center' width='20%'>"+document.getElementById("txthidFN_"+HfRouteID+"_"+HfFID+"_"+HFNO).value+"<input id='HidFlightNo_"+HFNO+"' type='hidden' value='"+HFNO+"' /></td>";
         strHtml+="<td align='center' width='30%'>起飞:"+document.getElementById("txthidFD_"+HfRouteID+"_"+HfFID+"_"+HFNO).value+" "+document.getElementById("txthidFT_"+HfRouteID+"_"+HfFID+"_"+HFNO).value+"<br />到达:"+document.getElementById("txthidTD_"+HfRouteID+"_"+HfFID+"_"+HFNO).value+" "+document.getElementById("txthidTT_"+HfRouteID+"_"+HfFID+"_"+HFNO).value+"</td>";
         strHtml+="<td align='center' width='30%'>"+document.getElementById("txthidFA_"+HfRouteID+"_"+HfFID+"_"+HFNO).value+"<br />"+document.getElementById("txthidEA_"+HfRouteID+"_"+HfFID+"_"+HFNO).value+"</td>";
         strHtml+="<td align='center' width='20%'><span style='cursor:pointer' id='divOther_"+HfRouteID+"_"+HfFID+"'><a onclick=\"javascript:showOtherFlight("+HfFID+","+totalNum+"," + HfRouteID + ",'divOther_"+HfRouteID+"_"+HfFID+"');\">选择其他"+totalNum+"个航班</a></spn></td>";
        //document.getElementById("trrouteDetail_"+HfSELIndex).innerHTML=strHtml;
        $("#trrouteDetail_"+HfSELIndex).html(strHtml);
        $("#divIframe").dialog("close");
        }
   }
   function checksel()
   {
       var HfrdoValue=$('#HfRdoValue').val(); 
       if(HfrdoValue=="")
       {
           alert("请选择航班信息！");
           return false;
       }
       return true;
   }
   function closeOtherFlight()
   {
      $("#divIframe").dialog("close");
   }
   function BindRdoValue(obj,routindex,index,no)
   {
       document.getElementById("HfRdoValue").value=obj.value;
       document.getElementById("HfSELIndex").value=routindex+"_"+index;
       document.getElementById("HfNO").value=no;
       document.getElementById("HfRoutID").value=routindex;
       document.getElementById("HFFID").value=index;
   }
   //订票规则
   function showLimit(routeId,policy)
   {
    //3_I201106071554147813_299980_0
    var arrpolicy=policy.split('_');
    var offset = $('#limit_'+routeId).offset();
    showWaiting('<table><tr><td>注意事项</td></tr><tr><td>改期: 免费。</td></tr><tr><td>退票: 全部未使用500人民币，部分使用不允许退票。</td></tr><tr><td>旅行有效期: 2011.07.01-2011.10.29</td></tr><tr><td>最短/长停留期: 0-2M  文件销售时限: 2011.06.29-2011.08.31</td></tr></table>', offset.left, offset.top);
    hideWaiting();
    }
    
    
   
 </script>

</head>

<body>
<form action="interticket!toCreateInterTicketOrder.action" name="form1" id="form1"
	method="POST">
 <!-- 遮罩类弹出层 -->
    <div id="divIframe" title="其他航班信息" style="text-align:center; display:none; background-color:#ffffff;left:0px;top:-100px;">
    </div>
    <div id="waiting"></div>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;国际机票查询结果</b></td>
	</tr>
	<tr>
		<td valign="top">
		 <div><ww:property value="s_listpagehtml" /></div>
		</td>
	</tr>
	<tr style="height:20px">
		<td valign="top">
		 <input type="hidden" id="HfRdoValue" value="" />
		 <input type="hidden" id="HfSELIndex" value="" />
		 <input type="hidden" id="HfNO" value="" />
		 <input type="hidden" id="HfRoutID" value="" />
		 <input type="hidden" id="HFFID" value="" />
		 <input type="hidden" id="HfSelectFligID" name="s_HfSelectFligID" value="" />
		 <input type="hidden" id="HfFlightID" name="s_HfFlightID" value="" />
		 <input type="hidden" id="HfSelectRoutID" name="s_HfSelectRoutID" value="" />
		 <input type="hidden" id="HfFromCity" name="StartAirportCode" value="<ww:property value="StartAirportCode" />" />
		 <input type="hidden" id="HfToCity" name="EndAirportCode" value="<ww:property value="EndAirportCode" />" />
		 <input type="hidden" id="HfFromDate" name="fromDate" value="<ww:property value="fromDate" />" />
		 <input type="hidden" id="HfReturnDate" name="returnDate" value="<ww:property value="returnDate" />" />
		 <input type="hidden" id="HfadultCount" name="adultCount" value="<ww:property value="adultCount" />" />
		</td>
	</tr>
</table>
<div id="bubble_tooltip" style="z-index:29">
	<div class="bubble_top"><span></span></div>
	<div class="bubble_middle"><span id="bubble_tooltip_content"></span></div>
	<div class="bubble_bottom"></div>
</div>
</form>
</body>
</html>


