<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>创建订单-填写乘机人</title>
<link type="text/css" rel="stylesheet" href="b2bairticket/css/public(2).css">
<link type="text/css" rel="stylesheet" href="b2bairticket/css/public.css">
<link type="text/css" rel="stylesheet" href="b2bairticket/css/air.css">
<link href="b2bairticket/css/base.css?v=100" rel="stylesheet">
<link href="b2bairticket/css/tip-yellowsimple.css?v=100" rel="stylesheet">
<link href="b2bairticket/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="b2bairticket/css/WdatePicker.css" type="text/css">


<script src="main_cx/js/jquery-1.4.2.min.js" type=text/javascript></script>

<script type="text/javascript" src="main_cx/js/Validform_v5.3.2_min.js"></script>
<script type="text/javascript" src="main_cx/js/lhgdialog.js"></script>
<script type="text/javascript" src="main_cx/js/layout.js"></script>
<script type="text/javascript" language="javascript" src="main_cx/js/jquery.blockUI.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js2/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js2/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js2/ext-all.js"></script>


<style type="text/css">
.tx_sel_1 {
	height: 24px;
}

.none_ {
	display: none;
}

.tx_text_card {
	width: 138px;
}

.tx_text_idtype {
	width: 65px;
}

.tx_text_name {
	width: 100px;
}

.birthday {
	width: 75px;
	display: none;
}



/*政策返点*/

.policy{ height:100%; /* overflow:auto */}
.policy ul{ width:100%; overflow:hidden}
.policy li{ float:left; width:10%; height:30px; text-align:center; line-height:30px; background:#006aff; font-weight:bold; margin-right:5px;}
.policy li a{ color:#fff}
.policy .li-now{ background:#fd492a}
.policy-con tr{ height:35px; }
.policy-con td{ border-bottom:1px dashed #dfdfdf;}
.policy-con .general{border:2px solid #005ad9; padding:10px;}
.policy-con .special{border:2px solid #fd492a;}
.policy-con{ margin-bottom:20px;}
.policy .prompt2{ margin-bottom:20px; color:#fd492a}



</style>
<link href="b2bairticket/css/WdatePicker(1).css" rel="stylesheet" type="text/css">
<style id="poshytip-css-tip-yellowsimple" type="text/css">
div.tip-yellowsimple {
	visibility: hidden;
	position: absolute;
	top: 0;
	left: 0;
}

div.tip-yellowsimple table.tip-table,div.tip-yellowsimple table.tip-table td
	{
	margin: 0;
	font-family: inherit;
	font-size: inherit;
	font-weight: inherit;
	font-style: inherit;
	font-variant: inherit;
	vertical-align: middle;
}

div.tip-yellowsimple td.tip-bg-image span {
	display: block;
	font: 1px/ 1px sans-serif;
	height: 10px;
	width: 10px;
	overflow: hidden;
}

div.tip-yellowsimple td.tip-right {
	background-position: 100% 0;
}

div.tip-yellowsimple td.tip-bottom {
	background-position: 100% 100%;
}

div.tip-yellowsimple td.tip-left {
	background-position: 0 100%;
}

div.tip-yellowsimple div.tip-inner {
	background-position: -10px -10px;
}

div.tip-yellowsimple div.tip-arrow {
	visibility: hidden;
	position: absolute;
	overflow: hidden;
	font: 1px/ 1px sans-serif;
}
</style>

</head>
<body>
<form id="form2" name="form2" method="post" action="">
<div id="air">
<div class="right"><!--航班信息开始-->
<div class="main_top">
<div class="lh34">
<div class="f">
<ul>
	<li class="font-f60-b14"><ww:property value="getAirCityNamebySZM(listsegmentinfo.get(0).startairport)" />→<ww:property value="getAirCityNamebySZM(listsegmentinfo.get(0).endairport)" />(<ww:if test="listsegmentinfo.size==1">单程</ww:if><ww:else>往返</ww:else>)</li>
	
</ul>
</div>
<div class="r"><a href="javascript:history.go(-1);">重新选择航班</a>
</div>
<div class="c"></div>
</div>
<div>
<div class="book_top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr>
			<th scope="col">类型</th>
			<th scope="col">航班日期</th>
			<th scope="col">出发/到达</th>
			<th scope="col">航空公司/机型</th>
			<th scope="col">舱位/折扣</th>
			<th scope="col">票面价</th>
			<th scope="col">基建/燃油</th>
			<th scope="col">飞行时间</th>
		</tr>

<ww:iterator value="listsegmentinfo" status="index">
		<tr>
			<td rowspan="2">单程</td>
			<td><ww:property value="formatTimestampyyyyMMdd(departtime)" /></td>
			<td><ww:property value="formatTimestampHHmm(departtime)" />&nbsp;<ww:property value="getAirCityNamebySZM(startairport)" /> <ww:property value="borderpointat" /></td>
			<td><img width="18" height="18" class="mt5" src="images/airComlogo/<ww:property value="aircomapnycode" />.gif">
			<ww:property value="airname" /> <ww:property value="flightnumber" /></td>
			<td><ww:property value="GetCabinType(discount,true,cabincode)" />【<ww:property value="cabincode" /><input id="cabincode1" type="hidden" value="<ww:property value="cabincode" />">/<ww:property value="discount/10" />折】</td>
			<td rowspan="2"><font class=" font-f60-b16"><ww:property value="formatMoneyToInt(parvalue)" /></font></td>
			<td rowspan="2"><ww:property value="formatMoneyToInt(airportfee)" />+<ww:property value="formatMoneyToInt(fuelfee)" />=<ww:property value="formatMoneyToInt(airportfee+fuelfee)" /></td>
			<td rowspan="2"><ww:property value="GetFeiXingTime(formatTimestampyyyyMMddHHmm(departtime),formatTimestampyyyyMMddHHmm(arrivaltime))" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td><!-- (周三) -->
			<td><ww:property value="formatTimestampHHmm(arrivaltime)" /> <ww:property value="getAirCityNamebySZM(endairport)" /> <ww:property value="offpointat" /></td>
			<td>机型:<ww:property value="flightmodel" />&nbsp;<a
				href="#"
				class="font-0053aa none_">[经停]</a></td>
			<td><a
				href="#"
				class="font-0053aa">退改签</a></td>
		</tr>
		
		   <!-- 隐藏域 -->
            <input type="hidden" id="hidsairport_<ww:property value="#index.index" />" value="<ww:property value="startairport" />" />
			<input type="hidden" id="hideairport_<ww:property value="#index.index" />" value="<ww:property value="endairport" />" />
			<input type="hidden" id="hidfromdate_<ww:property value="#index.index" />" value="<ww:property value="formatTimestampyyyyMMdd(departtime)" />" />
			<input type="hidden" id="hidaircompany_<ww:property value="#index.index" />" value="<ww:property value="aircomapnycode" />" />
			<input type="hidden" id="hidflightnumber_<ww:property value="#index.index" />" value="<ww:property value="flightnumber" />" />
			<input type="hidden" id="hidcabin_<ww:property value="#index.index" />" value="<ww:property value="cabincode" />" />
			<input type="hidden" id="hidparvalue_<ww:property value="#index.index" />" value="<ww:property value="parvalue" />" />
			
            <input type="hidden" id="hidStime_<ww:property value="#index.index" />" value="<ww:property value="formatTimestampyyyyMMddHHmm(departtime)" />" />
          
          <tr>
          <td colspan="8">
          
          
          
<!--政策返点 begin-->     
              
                   
           <!--政策返点 end-->
           
          
          </td>
          </tr>
          
          
</ww:iterator>


	</tbody>
</table>
</div>
<!--航班详情结束--></div>
</div>
<!--航班信息结束-->






 <!--填写信息-->
<div class="mt10 tianxiebox">
<div class="tianxie"><font class="f font-fff-14b">填写乘客信息</font><font
	class="r font-fff">请准确填写乘机人信息（姓名、证件号码），以免在办理登机手续时发生问题。出生日期(格式:2014-08-08)</font>
<div class="c"></div>
</div>
<div class="tianxiemain">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr>
			<td align="right" colspan="8" class=" h8">&nbsp;</td>
		</tr>
		<tr>
			<td width="20%">乘客姓名</td>
			<td width="10%">乘客类型</td>
			<td width="20%">证件类型</td>
			<td width="20%">证件号</td>
			<td width="20%" class="document_back">保险</td>
			<!--
			<td class="" id="tr_td_bitthday_text">出生日期</td>
			<td class="">手机号</td>
			-->
			<td></td>
		</tr>
		
              
            <ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
			<ww:param name="'first'" value="1" />
			<ww:param name="'last'" value="10" />
			</ww:bean>
			<ww:iterator value="#counter" status="state">                
		
			<tr id="passenger_<ww:property value="#state.index"/>" style="display: none;">
			<td><input type="text" class="tx_text tx_text_name" width="420px;" value=""
				name="passengerLists[0].name" id="s_txtPassengerName_<ww:property value="#state.index"/>" title="请填写乘机人姓名">&nbsp;
				
					<a href="javascript:opendg(<ww:property value="#state.index"/>);"><b><font color="red" style="font-size: 18px">*常用旅客</font></b></a>
				</td>
			<td><select name="passengerLists[0].ptype" id="customertype_<ww:property value="#state.index"/>">
				<option value="1">成人</option>
			
			</select></td>
			<td><select name="passengerLists[0].idtype"
				class="tx_text_idtype" id="cardittypeid_<ww:property value="#state.index"/>">
				<option value="1">身份证</option>
				<option value="3">护照</option>
				<option value="4">港澳通行证</option>
				<option value="5">台湾通行证</option>
				<option value="6">台胞证</option>
				<option value="7">回乡证</option>
				<option value="8">军官证</option>
				<option value="9">其他</option>
			</select></td>
			<td><input type="text" class="tx_text tx_text_card" width="320px;"
				name="passengerLists[0].idnumber" id="customercard_<ww:property value="#state.index"/>"></td>
			<td class="document_back"><select onchange="changbaoxian();"
				name="passengerLists[0].insurance" id="ddlinsurance_<ww:property value="#state.index"/>">
				<option value="0">0份</option>
				<option value="1">1份</option>
			</select>10元/份</td>
			
			
			<td><input type="text" class="tx_text birthday"
				name="passengerLists[0].birthday" id="birthday_<ww:property value="#state.index"/>"
				onfocus="WdatePicker({isShowClear:false,readOnly:true,maxDate:&#39;%y-%M-%d&#39;,dateFmt:&#39;yyyy-MM-dd&#39;})"></td>
			<td><input type="text" class="tx_text birthday"
				id="insur_mobile_<ww:property value="#state.index"/>"></td>
			<td><input name="" type="checkbox" value="" id="chbissave_<ww:property value="#state.index"/>"
				checked="checked">保存常旅客<a href="javascript:void(0)"
				onclick="del(<ww:property value="#state.index"/>);return false;" class="font-1f5da6">删除</a></td>
		</tr>
		</ww:iterator>
		
		
		<tr>
			<td align="right" colspan="8" class="xuxian">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" colspan="8" class=" h8">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" colspan="8" class="xuxian">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">&nbsp;</td>
			<td height="50" colspan="7"><input type="button" onclick="add('0');return false;"
				id="addpass_btn" class="bnt_app mr18">
				<!--<a href="javascript:void(0)" onclick="showcommonpassenger();"
				class="font-1f5da6">选择常旅客</a>&nbsp; <a target="_blank"
				class="font-1f5da6" href="http://pan.baidu.com/s/1bns0LUB">身份证扫描插件下载</a>
				--></td>
		</tr>
	</tbody>
</table>
</div>
</div>
<div class="baoxian mt10">
<div><a href="javascript:ShowBxInfo('insuranceinfo')" class=" font-0453c8"
	id="showinsuranceinfo">保险详情说明：<img src="b2bairticket/img/jt_up.png" width="28"
	height="28"></a></div>
<ul style="display: none;" id="insuranceinfo">
	<li class="pf20">保险名称：都邦保险</li>
	<li class="pf20">承保期限：保3天</li>
	<li class="pf20">保险额度：飞机保50万火车轮船各10万</li>
	<li class="pf20">注意事项：1、本保险未成年人的每位被保险人限投1份；成年人的每位被保险人限投1份,多投无效.</br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2、受益人为法定.</br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3、本保险购买后，不办理撤保、退保、加保及被保险人更换.</br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、 特别提醒：请务必填写被保险人的真实手机号码，以保证短信准确及时发送及验证.</li>
	<li class="pf20">保险有效期:当次航班，被保险人以乘客身份乘坐合法商业运营的客运飞机，并遵守承运人关于安全乘坐的规定，自持有效机票检票并进入所乘客运飞机客舱时起至抵达所持机票载明的终点离开所乘客运飞机客舱的期间内。<br>
	&nbsp;</li>
</ul>
</div>

<div class="mt10 tianxiebox">
<div class="tianxie"><font class="f font-fff-14b">联系人信息</font> <font
	class="r font-fff">请准确填写乘机人信息（姓名、证件号码），以免在办理登机手续时发生问题。</font>
<div class="c"></div>
</div>
<div class="lianximain">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr id="adlut_pnr_tr" style="display: none">
			<td align="right" width="100">成人pnr:</td>
			<td width="200"><input type="text" class="tx_text"
				name="s_adultpnr" id="txtadultpnr"></td>
			<td align="right" width="100"></td>
			<td></td>
		</tr>
		<tr>
			<td align="right">联系人姓名:</td>
			<td><input type="text" class="tx_text" title=""
				name="s_contactname" id="txtagentcontactname" value="<ww:property value="getLoginUser().membername"/>"></td>
			<td align="right">联系人电话:</td>
			<td><input type="text" class="tx_text"
				name="s_contactmobile" id="s_agentcontactmobile" value="<ww:property value="getLoginAgent().agentphone"/>"><font
				class="font-f60">(*此号码接收出票短信,必填项)</font></td>
		</tr>
		<tr>
			<td align="right" width="100">采购商姓名:</td>
			<td width="200"><input type="text" class="tx_text"
				name="s_contactname111" id="s_contactname" value="<ww:property value="getlianxiren()"/>"></td>
			<td align="right" width="100">采购商电话:</td>
			<td><input type="text" class="tx_text" name="s_txtcaigoumobile"
				id="s_txtcaigoumobile" value="<ww:property value="getLoginAgent().agentphone"/>"><font class="font-f60">(*此号码为平台联系采购商号码,必填项)</font></td>
		</tr>
	</tbody>
</table>
</div>
</div>
<!--填写信息结束-->
<div class="jiage mt10">总票价：<font class=" font-f60-b20"
	id="all_totalprice">000</font>元</div><!-- （人数×票面+人数×税+保险份数× <ww:property value="baoxianprice" />+平台交易费<ww:property value="formatMoneyToInt(orderPlat)" />元 =总票价） -->
<div class="tijiao"><input type="button" class="bnt_zhanzuo" onclick="suborder();"
	id="next_zhanzuo"></div>
<div class="xuzhi">
<ul>
	<li class=" font-f70">订座说明：<input name="agressMessage"
		id="agressMessage" type="checkbox" value="" checked="checked">
	<span id="agressMessage_span" title="需要同意订座说明">同意说明</span></li>
	<li class="pf20">1.航班起飞前30分钟未支付的记录,与生成PNR未生成订单的记录,系统有权自动取消;</li>
	<li class="pf20">2.通过我平台订座但未出票的订单，我平台有权取消该座位并且不承担任何责任;</li>
	<li class="pf20">3.对于恶意占座的代理商，我平台将关闭其账户，由此导致的损失与罚款，由该用户自己承担;</li>
	<li class="pf20">4.由于航空公司出现了一舱多价的问题，所以查询价格仅供参考，请用户以实际预订的PAT价格为准。</li>
	<li class="pf20">5.如预订儿童票,请务必正确填写成人pnr,如果填写错误导致的一切后果由订票人承担</li>
</ul>
</div>
</div>
<!--右侧内容结束-->
<div class="c"></div>
</div>


<input type="hidden" id="pstemp_index" value="1" />
<input type="hidden" id="hidallpassengers" name="s_jsonpassengers" value=''  style="width: 500px;"/>
<input type="hidden" id="hidsegmentinfo" value='<ww:property value="s_jasonsegmentinfo" />' name="s_jasonsegmentinfo"  style="width: 500px;"/>
<input type="hidden" id="hidorderPlat" value="<ww:property value="orderPlat" />" />

         <input type="hidden" id="hid_onezrateid" name="onezrateid" value="0" />
         <input type="hidden" id="hid_twozrateid" name="twozrateid" value="0" />
         <input type="hidden" id="hid_onezratevalue" value="0" />
         <input type="hidden" id="hid_twozratevalue" value="0" />
         
  <input type="hidden"  name="s_iscreatepnr" value='0'  style="width: 5px;"/>       
  <input type="hidden"  name="s_createcode" value='nozrate'  style="width: 5px;"/>       
<!--
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="jquery.blockUI.js"></script>
<script type="text/javascript" src="jquery-ui.min.js"></script>
<script type="text/javascript" src="WdatePicker.js"></script>
<script type="text/javascript" src="PublicJs.js"></script>
<script type="text/javascript" src="jquery.poshytip.js"></script>
<script type="text/javascript" src="CVR_IDCard.js"></script>
<script type="text/javascript" src="createorder_2014.js"></script>
<script type="text/javascript" src="public_domestic_ticket.js"></script>
-->
</form>

</body>
</html>
<script type="text/javascript">
function gettheratesep(index,flag,segmentindex)
    {
   
       $.ajax({
            type:"POST",
            async: false,
            url:"b2bairticket!GetZrateList.action",
            data:{stime:$("#hidStime_"+segmentindex).val(),s_traveltype:segmentindex,z_startcity:$("#hidsairport_"+segmentindex).val(),z_endcity:$("#hideairport_"+segmentindex).val(),z_fromdate:$("#hidfromdate_"+segmentindex).val(),intflag:flag,z_aircode:$("#hidaircompany_"+segmentindex).val(),z_airline:$("#hidflightnumber_"+segmentindex).val(),z_cabincode:$("#hidcabin_"+segmentindex).val(),z_price:$("#hidparvalue_"+segmentindex).val(),z_segmentindex:segmentindex},
            beforeSend:function(){$("#zrate_div_"+segmentindex).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
            success:function(data){
	         if(data!="暂无政策数据")
              {
              $("#zrate_div_"+segmentindex).html(data);
             // accountprice();
             //110  120
               document.getElementById("rdo_zrate"+flag+"_0").click();  
            }   
            }         
       });
     
        
        
         
    }
  function showtable(size,index)
{
	for(a=1;a<=size;a++){
	document.getElementById(index+a).style.display="block";
	}
	
	document.getElementById(index+"close").style.display="block";
	
	document.getElementById(index+"show").style.display="none";
	
	
	//$("#"+index+"check").html('<a href="javascript:closetable(2,onezrate_)">-缩起</a>');
	
}
function closetable(size,index)
{
	if(parseInt(size)>4){
	
		for(a=5;a<=size;a++){
		document.getElementById(index+a).style.display="none";	
		}	
		
	}	
	document.getElementById(index+"close").style.display="none";
	document.getElementById(index+"show").style.display="block";	
	//$("#"+index+"check").html('<a href="javascript:showtable(2,onezrate_)">-缩起</a>');
	
}				 


function showRmak_(id){

 $("tr[id*='Remark_']").each(function(i){
  $("#Remark_"+i).hide();

 });
   $("#"+id).show();
   
   subprice();
   
  }
function accountprice(){

//alert("???");

}
    
          
//$("#passenger_0").show();
var jdnum=0;
var oneaircompcode="CA";
var twoaircompcode="CA";

var piaomianjia=0; //票面价
var jijian=0; //基建
var ranyou=0; //燃油
var baoxianprice=0;//保险价格
 
     <ww:iterator value="listsegmentinfo" status="index">
     <ww:if test="#index.index==0">
	oneaircompcode='<ww:property value="aircomapnycode" />';
	</ww:if>
	  <ww:if test="#index.index==1">
	twoaircompcode='<ww:property value="aircomapnycode" />';
	</ww:if>
	
	piaomianjia+=<ww:property value="parvalue" />;//airportfee+fuelfee
	jijian+=<ww:property value="airportfee" />;
	ranyou+=<ww:property value="fuelfee" />;
	baoxianprice+=10;
     </ww:iterator>	
     
		
	var passindex=1;


 //添加
 function add(id){
 	if((oneaircompcode=='JD'||twoaircompcode=='JD')&&passindex>=1){
	 alert("航空公司最新规定:JD航空公司一次只能一个人订座,如有多人可选择其他同等航空公司,或者单个分开预订!!");
	 return;
	 } 
	 if(passindex>=9){
	  alert("最多预订9人!!");
	 return;
	}
	
	for(i=0;i<=8;i++){
		var te=$("#passenger_"+i).is(":hidden");
		//alert(i+"-"+te);
		if(te==true){
		
		if($("#s_txtPassengerName_"+(i-1)).val()==""&&i>0){
		 alert("乘机人姓名不能为空!");
		 $("#s_txtPassengerName_"+(i-1)).focus();
		 return;
		}
		if($("#customercard_"+(i-1)).val()==""&&i>0){
		 alert("证件号码不能为空!");
		 $("#customercard_"+(i-1)).focus();
		 return;
		}
		
		
		
		$("#passenger_"+i).show();
		passindex++;
		subprice();
		return;
		}
	}
	
	 // $("#passenger_"+passindex).show();
	//	passindex++;
	//	$("#pstemp_index").val(passindex);

 	subprice();
 	
 }					 
   //删除
function del(state){
 	if(state==0){
		alert("当前元素不能删除,请选择其他旅客删除,或者修改旅客信息!!!");
		return;
		}
		
	  $("#s_txtPassengerName_"+state).val("");
	   $("#passenger_"+state).hide();
	 	passindex--;
	 	$("#pstemp_index").val(passindex);
	 	subprice();	
 
 }	
 
 
 var  allprice=0;
 var  alljijian=0;
 var  allranyou=0;

   //计算价格
function subprice(){

  var zrateoneid="0-0-0-0";
  
	 
   //alert("zrateoneid:"+zrateoneid);

 	 var onezrateid=0;//第一程ID
     var onezratevalue=0;//第一城返点
     var onejiesuanjia=0;//第一城结算价
     var oneyouhui=0;//第一城优惠
     
     if(zrateoneid!=null){
     onezrateid=zrateoneid.split('-')[0];
     onezratevalue=zrateoneid.split('-')[1];
     onejiesuanjia= $("#hidparvalue_0").val();//
     oneyouhui=zrateoneid.split('-')[3];
     
     $("#hid_onezrateid").val(onezrateid);
    $("#hid_onezratevalue").val(onezratevalue);
     
     }
     
     //alert("onezrateid:"+onezrateid+",onezratevalue:"+onezratevalue+",onejiesuanjia:"+onejiesuanjia+",oneyouhui:"+oneyouhui);


 var  renshu=0;//总人数
 var  allbaoxianprice=0;//总保险价格
 var  allbaoxianrenshu=0;//保险总份数
 
 	for(i=0;i<=8;i++){
		var te=$("#passenger_"+i).is(":visible");
		if(te==true){
			var bxnum=$("#ddlinsurance_"+i).val();
			//alert(bxnum);
			allbaoxianrenshu+=parseInt(bxnum);
			renshu++;
		}
	}
	
 	//alert("保险分数:"+allbaoxianrenshu);
 	
 	
 	//all_totalprice
 	
 	var  ptfei=<ww:property value="orderPlat" />;
 	
 	var all_totalprice=((parseInt(onejiesuanjia)+parseInt(jijian)+parseInt(ranyou))*renshu)+parseInt(allbaoxianrenshu)*parseInt(baoxianprice)+parseInt(ptfei);
 	$("#all_totalprice").html(all_totalprice);
 }
 
  //用来获取radio值 RValue=GetRadioValue("myradio");
function GetRadioValue(RadioName){
    var obj;    
    obj=document.getElementsByName(RadioName);
    if(obj!=null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i].value;            
            }
        }
    }
    return null;
}
 
 
 function changbaoxian(){
 
 subprice();
 }
 
 
 	subprice();	
 	
 	
 	
function suborder(){
 	var zrateoneid="0-0-0-0";
 	 var onezrateid=0;//第一程ID
     var onezratevalue=0;//第一城返点
     var onejiesuanjia=0;//第一城结算价
     var oneyouhui=0;//第一城优惠
     
     if(zrateoneid!=null){
     onezrateid=zrateoneid.split('-')[0];
     onezratevalue=zrateoneid.split('-')[1];
     onejiesuanjia=zrateoneid.split('-')[2];
     oneyouhui=zrateoneid.split('-')[3];
     
    // $("#hid_onezrateid").val(onezrateid);
    // $("#hid_onezratevalue").val(onezratevalue);
     
     }
     
   //  alert("onezrateid:"+onezrateid+",onezratevalue:"+onezratevalue+",onejiesuanjia:"+onejiesuanjia+",oneyouhui:"+oneyouhui);



	
	 
	   var name="";
	   var type="";
	   var idcardtype="";
	   var idcardnumber="";
	   var insurancenum=0;
	   var insurancetotalprice=0;
	   var ticketprice=0;
	   var airportprice=0;
	   var fuelprice=0;
	   var totalprice=0;
	   var issave=1;
	   
	 	    var jsonstring="[";
	        $("tr[id*='passenger_']").each(function(i){
	        var strid=$(this).attr("id");
	       
	        if(document.getElementById(strid).style.display!="none"){
            id=strid.replace("passenger_","");
            
            name=$("#s_txtPassengerName_"+id).val();
             
            type="1";
            idcardtype=$("#cardittypeid_"+id).val();
            
            idcardnumber=$("#customercard_"+id).val();
           
            insurancenum=$("#ddlinsurance_"+id).val();
            
             
             
            insurancetotalprice=parseInt(insurancenum)*10;
            
            if($("#chbissave_"+id).attr("checked")==true){
               issave=1;
            }
            else
            {
               issave=0;
            }
            var shengri="";
           // shengri=$("#s_txtBirthday_"+id).val();
            
            jsonstring+='{ ID: "currentindex",Name:"'+name+'",Type:"'+type+'",Idcardtype:"'+idcardtype+'",Idcardnumber:"'+idcardnumber+'",Insurancenum:"'+insurancenum+'",Insurancemoney:"'+insurancetotalprice+'",Ticketprice:"'+ticketprice+'",Airportprice:"'+airportprice+'",Fuelprice:"'+fuelprice+'",Totalprice:"'+totalprice+'",Issave:"'+issave+'",shengri:"'+shengri+'" },';
            
            //alert(jsonstring);
            $("#hidallpassengers").val("");
            }
       });
       jsonstring+="]";
       jsonstring=jsonstring.replace(",]","]");
       
       $("#hidallpassengers").val(jsonstring);
       
      // form_validate(this);
       
       
       
       
       
       
       
       // dispose("系统正在为您预定"); 
       
     // return;
     
     for(i=0;i<=8;i++){
		var te=$("#passenger_"+i).is(":hidden");
		//alert(i+"-"+te);
		if(te==false){
		
		if($("#s_txtPassengerName_"+i).val()==""){
		 alert("乘机人姓名不能为空!");
		 $("#s_txtPassengerName_"+i).focus();
		 return;
		}
		if($("#customercard_"+i).val()==""){
		 alert("证件号码不能为空!");
		 $("#customercard_"+i).focus();
		 return;
		}
		
		
		
		}
	}
	
     
       
       if(1==1){
       		//dispose("系统正在为您办理");
       		 loadingoverlay("<img src='main_cx/img/loading2.gif' />");
       		// return;
       		 
			document.form2.action="b2bairticket!createorder_no.action";
	        document.form2.method = "POST"; 
            document.form2.submit();
		}
}
 	add();
 	
 	
 	
 	
    </script>
    <script>

	
	var gwin;
	function grefresh(index,username,idtype,idnumber){
	
	  if(gwin){
			gwin.close();
			//alert(index+","+username+","+idtype+","+idnumber);
			//selectadd(username,type,idtype,idnumber,id)
			//selectadd(username,usertype,idtype,idnum,index,mobile);
			
			document.getElementById("s_txtPassengerName_"+index).value=username;
		    document.getElementById("cardittypeid_"+index).value=idtype;
		    document.getElementById("customercard_"+index).value=idnumber;
			
			
			
			
		}
	}
	

	
	function opendg(index){
   		
		if(gwin){gwin.close();}
		gwin= Ext.create('Ext.Window', {
			        
			        title: '常用旅客',
			        maximizable: true,
			        width: 610,
			        height: 350,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src="b2bairsearch!seachpass.action?<ww:property value="url"/>&c_index='+index+'" width="100%" height="100%" s frameborder="0" scrolling="no" ></iframe>'
		
			        }
			        ]
			        
			  		});
			  		gwin.show();
				

}

function ShowBxInfo(id){
 $("#"+id).show();

}
function loadingoverlay(message) {
    $.blockUI({
        message: message,
        css: {
            border: 'none',
            padding: '15px',
            width: '700px',
            height: '400',
            top: '100px',
            left:'300px',
            backgroundColor: '#a6a5a5',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            color: '#000'
        }
    });
}

</script>