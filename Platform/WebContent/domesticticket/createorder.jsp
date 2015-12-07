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
<link href="skin/blue/css/b2blist.css" rel="stylesheet" />
<link href="skin/blue/css/tip.css" rel="stylesheet" type="text/css" />
<link href="style/airco.css" rel="stylesheet" type="text/css" />
<link href="js/city-control/base.css" rel="stylesheet" />
<script type="text/javascript" src="js/city-control/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/city-control/jquery.poshytip.js"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/city-control/list.js"></script>
<script src="js/city-control/jquery.elementsorter.js" type="text/javascript"></script>
<script src="js/jason/json2.js" type="text/javascript"></script>
<link href="skin/blue/css/public.css" rel="stylesheet" />
<style>
.bordernoselect{
width: 100%; border: 2px solid #0066FF; float: left; margin-top: -1px;
}
.borderselected{
width: 100%; border: 2px solid #F48000;
}
</style>
<script language="javascript">
	$(document).ready(function() {
		 getthereate(0,1);
	});
	//加载普通政策信息
	function getthereate(flag,segmentindex)
    {
       $.ajax({
            type:"POST",
            url:"demosticticket!DisplayZrateList.action",
            async:false,
            data:{s_depcitycode:$("#hidsairport_"+segmentindex).val(),s_arrcitycode:$("#hideairport_"+segmentindex).val(),s_startdate:$("#hidfromdate_"+segmentindex).val(),intflag:1,s_aircompanycode:$("#hidaircompany_"+segmentindex).val(),s_flightnumber:$("#hidflightnumber_"+segmentindex).val(),s_cabincode:$("#hidcabin_"+segmentindex).val(),z_price:$("#hidparvalue_"+segmentindex).val(),z_segmentindex:segmentindex},
            beforeSend:function(){$("#divpolicyinfo_"+segmentindex).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
            success:function(data){
             $("#divpolicyinfo_"+segmentindex).html(data);  
             //模拟点击特殊政策第一条数据，更新政策及价格信息
               if(segmentindex=="1")
               {
                 if(document.getElementById("rdo_zrate1_0")!=null)
                 {
                   document.getElementById("rdo_zrate1_0").click(); 
                 }
               }
               else
               {
                 if(document.getElementById("rdo_zrate2_0")!=null)
                 {
                    document.getElementById("rdo_zrate2_0").click();
                 }
               }
            }            
       });
       $("#tabspecial").html("特殊政策信息");
       $("#tabnormal").html("<b>普通政策信息</b>");
       
    }
    //加载特殊政策信息
    function gettheratesep(index,flag,segmentindex)
    {
       $.ajax({
            type:"POST",
            url:"demosticticket!DisplayZrateList.action",
            data:{s_depcitycode:$("#hidsairport_"+segmentindex).val(),s_arrcitycode:$("#hideairport_"+segmentindex).val(),s_startdate:$("#hidfromdate_"+segmentindex).val(),intflag:flag,s_aircompanycode:$("#hidaircompany_"+segmentindex).val(),s_flightnumber:$("#hidflightnumber_"+segmentindex).val(),s_cabincode:$("#hidcabin_"+segmentindex).val(),z_price:$("#hidparvalue_"+segmentindex).val(),z_segmentindex:segmentindex},
            beforeSend:function(){$("#divpolicyinfo_"+segmentindex).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
            success:function(data){
	         if(data!="暂无政策数据")
              {
               $("#divpolicyinfo_"+segmentindex).html(data);   
               if(segmentindex=="1")
               {
                 if(document.getElementById("rdo_zrate1_0")!=null)
                 {
                   document.getElementById("rdo_zrate1_0").click(); 
                 }
               }
               else
               {
                 if(document.getElementById("rdo_zrate2_0")!=null)
                 {
                    document.getElementById("rdo_zrate2_0").click();
                 }
               }            
              }
              else
              {
                 $("#divpolicyinfo_"+segmentindex).html(data); 
              }
            }            
       });   
        $("#divpolicyinfo_"+segmentindex).addClass("borderselected"); 
        $("#tabspecial").html("<b>特殊政策信息</b>");
        $("#tabnormal").html("普通政策信息");
    }
    //改变政策信息
    function changezrate(index,trid,zrateid,policyindex,segmentindex)
    {
       //显示政策描述
       $("tr[id*='"+trid+"']").each(function(i){
		       $("#"+trid+i).hide();
		   });
		$("#"+trid+index).show();
	   //更新政策和价格信息
	   $("#span_zratevalue_"+segmentindex).html($("#zate_1_"+policyindex+"_value").html());
	   $("#span_totalpayprice_"+segmentindex).html($("#zate_1_"+policyindex+"_price").html());
    }
    //展开政策列表
    function showmorezrate(size,index)
    {
	  for(a=1;a<=size;a++){
	   document.getElementById(index+a).style.display="block";
	  }
	   document.getElementById(index+"close").style.display="block";
	   document.getElementById(index+"show").style.display="none";
    }
    //收起政策列表
    function closezrate(size,index)
    {
	if(parseInt(size)>4){
	
		for(a=5;a<=size;a++){
		document.getElementById(index+a).style.display="none";	
		}	
	}	
	document.getElementById(index+"close").style.display="none";
	document.getElementById(index+"show").style.display="block";	
   }
</script
</head>

<body>
<body>

<div id="list">

   <div class="list_box">

   <div class="list_top font-fff">
       <font class="f">填写订单信息</font>
       <span class="r">【<ww:property value="s_depcityname" /> → <ww:property value="s_arrcityname" /> 出发日期：<ww:property value="s_startdate" />】</span>
   </div>
   
   <ww:iterator value="listsegmentinfo" status="index">
   <div class="booking" >
	<div class="go"><span class="ico_go">&nbsp;</span>航程信息：<ww:property
		value="s_depcityname" />→<ww:property value="s_arrcityname" />|出发时间：<ww:property
		value="formatTimestampyyyyMMdd(departtime)" />
	   <input type="hidden" id="hidsairport_<ww:property value="#index.index+1" />" value="<ww:property value="startairport" />" />
	   <input type="hidden" id="hideairport_<ww:property value="#index.index+1" />" value="<ww:property value="endairport" />" />
	   <input type="hidden" id="hidfromdate_<ww:property value="#index.index+1" />" value="<ww:property value="formatTimestampyyyyMMdd(departtime)" />" />
	   <input type="hidden" id="hidaircompany_<ww:property value="#index.index+1" />" value="<ww:property value="aircomapnycode" />" />
	   <input type="hidden" id="hidflightnumber_<ww:property value="#index.index+1" />" value="<ww:property value="flightnumber" />" />
	   <input type="hidden" id="hidcabin_<ww:property value="#index.index+1" />" value="<ww:property value="cabincode" />" />
	   <input type="hidden" id="hidparvalue_<ww:property value="#index.index+1" />" value="<ww:property value="parvalue" />" />
    </div>

	<div class="nav_booking font-fff">

     <ul>

     <li class="f nav_left">&nbsp;</li>

     <li class="f" style="width:12%; text-align:right;">航空公司/舱位</li>

     <li class="f" style="width:20%">出发/到达</li>

     <li class="f" style="width:20px;">&nbsp;</li>

     <li class="f" style="width:14%">票面价(机建/燃油)</li>

     <li class="f" style="width:11%">总票价</li>

     <li class="f" style="width:11%">返点&nbsp;&nbsp;&nbsp;</li>

     <li class="f" style="width:8%">退改签</li>

     <li class="f" style="width:20%">单张结算价</li>

     <li class="r nav_right">&nbsp;</li>

     </ul>

   </div> 

   <div class="nohave5"></div>

   <table width="100%" border="0" cellspacing="0" cellpadding="0" class="list_table">

      <tr>

        <td width="13%" align="right"><span
					class='airco_<ww:property value="aircomapnycode" />'
					></span><font class="font-18"><ww:property value="getAircomapnycodeByEZM(aircomapnycode)" /><ww:property value="flightnumber" /></font></td>

        <td width="20">&nbsp;</td>

        <td width="22%"><ww:property value="formatTimestampHHmm(departtime)" /> <ww:property
					value="getAirportbySZM(startairport)" /></td>

        <td width="13%"><font class="font-bdb0000"><ww:property
					value="formatMoneyToInt(parvalue)" /></font>元</td>

        <td width="10%"><font class="font-bdb0000"><ww:property
					value="formatMoneyToInt(airportfee+fuelfee+parvalue)" /></font>元</td>

        <td width="10%" class="pt19" rowspan="2" ><font class="font-ff893b"><span id="span_zratevalue_<ww:property value="#index.index+1" />"><ww:property value="ratevalue" /></span>%</font></td>

        <td width="12%" rowspan="2" class="pt19"><a
					id="a_rules_<ww:property value="#index.index" />"
					href="javascript:void(0);" class="fontun06c"
					onmouseout="hiderules('<ww:property value="#index.index" />');"
					; onmouseover="showrules('<ww:property value="#index.index" />','<ww:property value="rules" />');"
					class="fontun06c">退改签规则</a></td>

        <td  rowspan="2" class="pt19"><font class="font-db0000 mf20"><span id="span_totalpayprice_<ww:property value="#index.index+1" />"><ww:property
					value="formatMoneyToInt(price)" /></span></font>元</td>

      </tr>

      <tr>

        <td align="right"><ww:if
					test="discount>=150.0">头等舱</ww:if> <ww:elseif
					test="discount>=130.0">商务舱</ww:elseif> <ww:elseif test="isspecial">特价经济舱</ww:elseif>
				<ww:else>经济舱</ww:else>(<ww:property value="cabincode" />舱<ww:property value="discount/10" />折)</td>

        <td width="20">&nbsp;</td>

        <td><ww:property value="formatTimestampHHmm(arrivaltime)" /> <ww:property
					value="getAirportbySZM(endairport)" /> </td>

        <td><ww:property
					value="formatMoneyToInt(airportfee)" />/<ww:property
					value="formatMoneyToInt(fuelfee)" /></td>

        <td>&nbsp;</td>

      </tr>

    </table>

        <div class="nohave5"></div>

        <div class="nohave5 box_top"></div>

         <div>

           <ul>

           <li class="f general"><a id="tabnormal" class="font-fff" href="javascript:void(0);" onclick="getthereate(0,1);">普通政策信息<font class="font-e8fd37">&nbsp;</font></a></li>

           <li class="f special"><a id="tabspecial" class="font-fff" href="javascript:void(0);" onclick="gettheratesep(0,2,1);">特殊政策信息</a></li>

           <li class="c"></li>

           </ul>

         </div>
         <!-- 政策列表 -->
         <div class="general_box" id="divpolicyinfo_<ww:property value="#index.index+1"/>">
         </div>
         <!-- 政策列表 -->

     </div>
     </ww:iterator>
     <!--去程-->
     <div class="nohave"></div>

  </div>   

  <div class="nohave"></div>

<div class="list_box">

<div id="booking">

   <div class="list_top font-fff">

       <font class="f">乘机人信息</font>

       <span class="r">【请准确填写登机人信息（姓名、证件号码），以免在办理登机手续时发生问题。】</span>

   </div>

 <div class="number">

            <ul>

             <li class="f mr18"><span class="add_people">&nbsp;</span>增加乘机人</li>

             <li class="f floatall">

             <span class="f">选择：</span>

             <span class="onepeople"><a href="#" class="font-000" >陈星</a></span>

             <span class="onepeople"><a href="#" class="font-000" >星星</a></span>

             <span class="onepeople"><a href="#" class="font-000" >张三</a></span>

             <span class="onepeople"><a href="#" class="font-000" >陈星星</a></span>

             <span class="onepeople"><a href="#" class="font-000" >李四</a></span>

             <a href="#" class="fontun06c f">更多>></a>

             <div class="c"></div>

             <div class="people msg" style="display:none">

                 <ul class="msgul pf15">

                 <span class="onepeople"><a href="#" class="font-000" >陈星</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >星星</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >张三</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >陈星星</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >李四</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >陈星</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >星星</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >张三</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >陈星星</a></span>

                 <span class="onepeople"><a href="#" class="font-000" >李四</a></span>

                 <div class="c"></div>

                 </ul>

             </div>

             <!--更多联系人-->

             </li>

             <li class="r">查找：<input type="text" class="text_number mt3" value="&nbsp;&nbsp;中文名/英文名" /></li>

             <li class="c"></li>

            </ul>

        </div>

        <div class="information">

        <table width="100%" border="1" cellspacing="0" cellpadding="0" >

          <tr>

            <td class="hadow" align="right" width="11%"><font class="fontxing">*</font> 姓  名：</td>

            <td width="13%"><input type="text" class="text_name" value="" /></td>

            <td class="hadow" align="right" width="11%"><font class="fontxing">*</font> 旅客类型：</td>

            <td width="11%" ><select class="sel_type"><option>成人</option><option>儿童</option><option>婴儿</option></select> </td>

            <td class="hadow" align="right" width="11%"><font class="fontxing">*</font> 证件类型：</td>

            <td width="11%" ><select class="sel_documents"><option>身份证</option><option>护照</option><option>港澳通行证</option></select></td>

            <td width="20%"><input type="text" class="text_number"  /></td>

            <td class="hadow"><span class="del_people">&nbsp;</span><a href="#" class="fontun06c">删除乘客</a></td>

          </tr>

          <tr>

            <td class="hadow" align="right">

            <div class="floatall">

              <a href="#"><span class="insurance">保险</span></a>：

              <div class="msg informations" style="display:none;">

                <ul class="msgul">

                     <li class="informations_title box_over black">太保航空延误取消险</li>

                     <li>1、保险名称：太保航班延误取消险。</li>

                     <li>2、份数限制：每人每航段1份。</li>

                    <li>3、销售限制：航班起飞前24小时截止销售。</li>

                    <li>4、有效期：购买成功后即刻生效。</li>

                    <li>5、保险费：20元/份。</li>

                    <li>6、保额：投保本人必须乘坐投保航班且航班抵达目的地时延误4小时及以上（起飞后未发生返航、备降）赔偿400元，航班被取消或所乘航班起飞后返航、备降赔偿100元。</li>

                    <li class="nohave"></li>

                </ul>

              </div>

            </div>  

            </td>

            <td ><select class="sel_fraction" ><option>1</option><option>2</option><option>2</option></select>￥20/份</td>

            <td colspan="5"><font class="font-db0000 mlr">1000</font>元(含税费)</td>

            <td class="hadow"><input name="" type="checkbox" value="" class="mfr5" /><a href="#" class="fontun06c">保存乘客</a></td>

          </tr>

        </table>

        <div class="nohave"></div>

        </div>

</div>

</div>

<div class="nohave"></div>

<div class="list_box">

    <div>

       <div class="list_top font-fff">

           <font class="f">预订信息</font>

           <span class="r">【请准确填写登机人信息（姓名、证件号码），以免在办理登机手续时发生问题。】</span>

           <div class="c"></div>

       </div>

       <div class="nohave"></div>

       <div class="information">

      <table width="100%" border="1" cellspacing="0" cellpadding="0">

              <tr>

                <td class="hadow" align="right" width="130"><font class="fontxing">*</font>&nbsp;联系人姓名：</td>

                <td><input type="text" class="text_number"  /></td>

                <td class="hadow" align="right" width="130"><font class="fontxing">*</font>&nbsp;联系电话：</td>

                <td><input type="text" class="text_number"  /></td>

              </tr>

              <tr>

                <td class="hadow" align="right"><font class="fontxing">*</font>&nbsp;支付方式：</td>

                <td colspan="3"><input name=""  type="radio" value="" checked="checked" />门市支付 <input name="" type="radio" value="" /><a>票到付款</a>  <font class="font-3797f1 mf20">温馨提示：如果客人已支付，请选择门市付款。</font></td>                

              </tr>

              <tr>

                <td class="hadow" align="right">交 易 费：</td>

                <td colspan="3"><font class="font-db0000 mlr">1</font>元</td>

              </tr>

              <tr>

                <td class="hadow" align="right">计算方式：</td>

                <td colspan="3">结算价×人数+平台交易费+保险份数×20=总支付金额<br/><font class="font-db0000 mlr">888×3+1+3×20=1888</font>元</td>

              </tr>

              <tr>

                <td class="hadow" align="right">订单总金额：</td>

                <td colspan="3"><font class="font-db0000 mlr">1888</font>元</td>

              </tr>

            </table>

            </div>

             <div class="nohave"></div>

    </div>

    <form action="check.html" method="get">  

    <div class="list_bnt"><input type="submit" class=" bnt_refrec mfr20" value="立即预订" /><input type="button" class=" bnt_refrec mfr20" value="重新查询" /></div>
    <input type="text" id="hidsegmentinfo" style="width:1000px"
		value='<ww:property value="s_jasonsegmentinfo" />'
		name="s_jasonsegmentinfo" />
    </form>

</div>

<!--booking over-->

</div>

</body>
</html>


