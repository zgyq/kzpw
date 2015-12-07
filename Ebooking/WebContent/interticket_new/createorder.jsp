<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<title>亿票联盟商旅平台国际机票订单提交</title>
		<meta name="keywords" content="亿票联盟商旅系统">
		<meta name="description" content="亿票联盟商旅系统">
		<link href="interticket_new/css/b2b_Order.css" rel="stylesheet" type="text/css" />
		
<script type="text/javascript" src="main_cx/js/jquery-1.4.1.min.js"></script>		
<script src="main_cx/js/jquery.tmpl.js" type="text/javascript"></script>
<script src="main_cx/js/jquery.bgiframe.min.js" type="text/javascript"></script>
<script src="main_cx/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="main_cx/js/jquery.poshytip.js" type="text/javascript"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
        //成人含税费总票价
        var adultpricefee = 0;
        var adultpassengerprice = 0;
        var adultpassengerairport = 0;
        var adultpassengerfuel = 0;
        var Aircomapnycode = "";
        var cabincode = "";
        //总乘机人数
        var passengercount = 0;
        //全价价格
        var yprice = 0;
        //一份保险的价格
        var insuranceprice = 20;
        var passengerJsonString = '[{ ID: "1",Name:"",Type:"1",Idcardtype:"1",Idcardnumber:"",Birthday:"",Insurancenum:"0",Insurancemoney:"' + insuranceprice + '",Ticketprice:"' + adultpassengerprice + '",Airportprice:"' + adultpassengerairport + '",Fuelprice:"' + adultpassengerfuel + '",Totalprice:"' + adultpricefee + '",Issave:"",Customerpassid:"0" }]';
        var passengers = eval(passengerJsonString);
        $(document).ready(function () {
            //加载第一个乘机人 
            $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers');
             accountprice();
        });
		
		
		
		
		
		
		var piaomianjia=0; //票面价
		var jijian=0; //基建
		var ranyou=0; //燃油
		var baoxianprice=20;//保险价格
		var pvalue=0;//航司票面价
 
     <ww:iterator value="listsegmentinfo" status="index">
	piaomianjia=<ww:property value="price" />;//airportfee+fuelfee
	jijian=<ww:property value="airportfee" />;
	ranyou=<ww:property value="fuelfee" />;
	pvalue=<ww:property value="yprice" />;
    </ww:iterator>	
		
		
		
		
		function suborder(){
		
	  var  isok="ok";
		
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
	   var shengri="";
	   var guoji="";
	   var sex="";
	   var yprice=0;
	 	    var jsonstring="[";
	        $("div[id*='divinformation_']").each(function(i){
	        var strid=$(this).attr("id");
            id=strid.replace("divinformation_","");
            name=$("#txt_name_"+id).val();
            type=$("#txt_PassType_"+id).val();
            idcardtype=$("#txt_CardType_"+id).val();
            idcardnumber=$("#txt_CardId_"+id).val();
            insurancenum=$("#txt_baoxian_"+id).val();
            shengri=$("#txt_Birthday_"+id).val();
            guoji=$("#txt_demoGuoji_"+id).val();
            sex=$("#txt_sex_"+id).val();
            ticketprice=piaomianjia;//结算价
            airportprice=jijian;//税费
            fuelprice=ranyou;
            yprice=pvalue;//航司票面价
            
            if(name==''){
    		alert("姓名不能为空!");
    		$("#txt_name_"+id).focus();
    		isok="err";
    		return;
    		}
    		if(idcardnumber==''){
    		alert("证件号码不能为空!");
    		$("#txt_CardId_"+id).focus();
    		isok="err";
    		return;
    		}
    		if(guoji==''){
    		alert("国籍不能为空!");
    		$("#txt_demoGuoji_"+id).focus();
    		isok="err";
    		return;
    		}
    		if(shengri==''){
    		alert("生日不能为空!");
    		$("#txt_Birthday_"+id).focus();
    		isok="err";
    		return;
    		}
            
            insurancetotalprice=insurancenum*baoxianprice;
            
            totalprice=ticketprice+insurancetotalprice+airportprice;
            jsonstring+='{ ID: "currentindex",Name:"'+name+'",Type:"'+type+'",Idcardtype:"'+idcardtype+'",Idcardnumber:"'+idcardnumber+'",Insurancenum:"'+insurancenum+'",Insurancemoney:"'+insurancetotalprice+'",Ticketprice:"'+ticketprice+'",Airportprice:"'+airportprice+'",Fuelprice:"'+fuelprice+'",Totalprice:"'+totalprice+'",Issave:"'+issave+'",shengri:"'+shengri+'",guoji:"'+guoji+'",sex:"'+sex+'",yprice:"'+yprice+'" },';
            
            $("#hidallpassengers").val("");
            
       });
       jsonstring+="]";
       jsonstring=jsonstring.replace(",]","]");
       
       $("#hidallpassengers").val(jsonstring);
		
		
		  if($("#c_linkname2").val()==''){
    		alert("联系人姓名不能为空!");
    		$("#c_linkname2").focus();
    		isok="err";
    		return;
    		}else{
    		$("#c_linkname").val($("#c_linkname2").val());
    		}
		
		 if($("#c_linktel2").val()==''){
    		alert("联系人电话不能为空!");
    		$("#c_linktel2").focus();
    		isok="err";
    		return;
    		}else{
    		$("#c_linktel").val($("#c_linktel2").val());
    		}
    	if($("#c_linkemail2").val()==''){
    		alert("联系人邮箱不能为空!");
    		$("#c_linkemail2").focus();
    		isok="err";
    		return;
    		}else{
    		$("#c_linkemail").val($("#c_linkemail2").val());
    		}
		$("#c_linkdesc").val($("#c_linkdesc2").val());
		
		
		if(isok=='ok'){
		document.form2.submit();
		}
		
		
		
		
		}
		
		function accountprice(){
		var toallprice=0;//总票面价
		var toallranyou=0;//总税费
		var renshu=0;
		var bxnum=0;
		 $("div[id*='divinformation_']").each(function(i){
	         var strid=$(this).attr("id");
            id=strid.replace("divinformation_","");
            
            
          toallprice+=parseInt(piaomianjia);
          toallranyou+=parseInt(jijian);
          renshu++;
          
          bxnum+=parseInt($("#txt_baoxian_"+id).val());
            
       });
		
		//alert(bxnum);
		$("#pmj1").html(piaomianjia);
		$("#pmj2").html(piaomianjia);
		$("#renshu").html(renshu);
		$("#shuifei").html(jijian);
		$("#baoxian").html(parseInt(bxnum)*parseInt(baoxianprice));
		
		
		$("#totalPrice").html((parseInt(piaomianjia)+parseInt(jijian))*parseInt(renshu)+parseInt(bxnum)*parseInt(baoxianprice));
		
		
		
		}
		
		
		//添加乘机人
function addpassenger(jsonpassenger) {
    var currentindex = 1;
    var divid = 0;
    $("div[id*='divinformation_']").each(function (i) {
        currentindex++;
        var idcur = $(this).attr("id").replace("divinformation_", "");
        divid = parseInt(idcur) + 1;

    });
   	 if(currentindex>1){
    		var name=$("#txt_name_"+(currentindex-1)).val();
            var idcardnumber=$("#txt_CardId_"+(currentindex-1)).val();
            var shengri=$("#txt_Birthday_"+(currentindex-1)).val();
            var guoji=$("#txt_demoGuoji_"+(currentindex-1)).val();
    		
    		if(name==''){
    		alert("姓名不能为空!");
    		$("#txt_name_"+(currentindex-1)).focus();
    		return;
    		}
    		if(idcardnumber==''){
    		alert("证件号码不能为空!");
    		$("#txt_CardId_"+(currentindex-1)).focus();
    		return;
    		}
    		if(guoji==''){
    		alert("国籍不能为空!");
    		$("#txt_demoGuoji_"+(currentindex-1)).focus();
    		return;
    		}
    		if(shengri==''){
    		alert("生日不能为空!");
    		$("#txt_Birthday_"+(currentindex-1)).focus();
    		return;
    		}
    }
    
    
    if (currentindex > 9) {
    
	alert("最多预订9人!");
        //$('#linkadd').poshytip('enable');
       // $('#linkadd').poshytip('show');
        return;
    }
    var currentpassenger = JSON.stringify(passengers);

    if (jsonpassenger == "") {
        passengerJsonString = "[";
        passengerJsonString += '{ID: "' + divid + '", Name:"",Type:"1",Idcardtype:"1",Idcardnumber:"",Insurancenum:"0",Insurancemoney:"' + insuranceprice + '",Ticketprice:"' + adultpassengerprice + '",Airportprice:"' + adultpassengerairport + '",Fuelprice:"' + adultpassengerfuel + '",Totalprice:"' + adultpricefee + '" }';
        passengerJsonString += "]";

        passengers = eval(passengerJsonString);
        $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers');
    }
    else {
        passengerJsonString = jsonpassenger.replace("currentindex", divid);
        passengers = eval(passengerJsonString);
        $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers');
        //判断已有乘机人中是否有姓名为空的，如果有则删除
        $("div[id*='divinformation_']").each(function (i) {
            var strid = $(this).attr("id");
            var id = strid.replace("divinformation_", "");
            if ($("#txt_name_" + id).val() == "") {
                delpassenger(id);
            }
        });
    }
    accountprice();
}

//删除乘机人
function delpassenger(id) {

    var currentindex = 0;
    $("div[id*='divinformation_']").each(function (i) {
        currentindex++;
    });
    if (currentindex == 1) {
        $('#linkdel').poshytip('enable');
        $('#linkdel').poshytip('show');
        return;
    }
    else {
        $("#divinformation_" + id).remove();
    }
    accountprice();
}


	
	 
		
    </script>
    
	</head>
	<body id="mainbody">
		<div class="clear">
		</div>
		<div style="width:100%;height:20px;">
					
		</div>
		<div class="b2b_Order">
			<div class="b2b_OrderL">
				<div class="b2b_OrderL-A">
					<h3>
						乘机人
					</h3>
					
					<div id="divpassengers"><script id="passengerTemplate" type="text/x-jquery-tmpl"> 
						<div class="b2b_OrderL-A01" id="divinformation_\${ID}">
							<input type="hidden" cname="InfoId" sname="InfoId">
							<h4>
								第<span class="online_index">\${ID}</span>位乘机人
							</h4>
							<ul>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										乘机人
									</label>
									<div class="b2b_OrderL-A02-2">
										<label class="b2b_OrderL-A02-3 ">
											姓名
										</label>
										<input type="text" id="txt_name_\${ID}" value="${Name}" cname="FirstName" sname="SurName" class="b2b_OrderL-A02-4" mod_notice_tip="姓(拼音或英文)" _cqnotice="姓(拼音或英文)" style="">
										<div class="b2b_OrderL-A02-5">
											请正确填写证件中的拼音或英文姓名，例如姓为奥巴马，应填写ao/bama
										</div>
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										证件信息
									</label>
									<div class="b2b_OrderL-A02-2">
										<select class="b2b_OrderL-A02-7 " sname="CardType" id="txt_CardType_\${ID}" >
											<option value="3">护照</option>
											<option value="4">港澳通行证</option>
											<option value="5">台湾通行证</option>
											<option value="6">台胞证</option>
											<option value="7">回乡证</option>
										</select>
										<input type="text" class="b2b_OrderL-A02-6" id="txt_CardId_\${ID}"  sname="CardId" mod_notice_tip="证件号码" placeholder="证件号码" _cqnotice="证件号码" style="">
										<div class="b2b_OrderL-A02-5">		
											特别提醒：为了您能顺利出行，请确保旅行结束日期至少比证件有效期早6个月。
										</div>
										<input type="hidden" cname="CardLimitTime" sname="CardLimitTime">
									</div>
								</li>
								<!--<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										证件有效期
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
									</div>
								</li>-->
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										国籍
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="txt_demoGuoji_\${ID}" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										出生日期
									</label>
									<div class="b2b_OrderL-A02-2">
										<input type="text" id="txt_Birthday_\${ID}" cname="Birthday" sname="Birthday" onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" class="Wdate" class="b2b_OrderL-A02-8" mod_notice_tip="yyyy-mm-dd" placeholder="yyyy-mm-dd" _cqnotice="yyyy-mm-dd" style="">
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										性别
									</label>
									<div class="b2b_OrderL-A02-2">
										<select class="b2b_OrderL-A02-7 " sname="CardType" id="txt_sex_\${ID}"  >
											<option value="男">男</option>
											<option value="女">女</option>
										</select>
										
									</div>
								</li>
								
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										乘机人类型
									</label>
									<div class="b2b_OrderL-A02-2">
										<select class="b2b_OrderL-A02-7 " sname="PassType" id="txt_PassType_\${ID}" >
											<option value="1">成年</option>
											<option value="2">儿童</option>
										</select>
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										购买保险
									</label>
									<div class="b2b_OrderL-A02-2">
										<select class="b2b_OrderL-A02-7 " sname="PassType" id="txt_baoxian_\${ID}" onchange="accountprice();" >
											<option value="0">0份</option>
											<option value="1">1份</option>
											<option value="2">2份</option>
										</select>&nbsp;20元/份
									</div>
								</li>
								<!--  
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										目的地地址
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
										<div class="b2b_OrderL-A02-5">		
											特别提醒！去往美国乘客必填
										</div>
									</div>
									
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										目的地邮编
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
										<div class="b2b_OrderL-A02-5">		
											特别提醒！去往美国乘客必填
										</div>
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										现居住地址
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
										<div class="b2b_OrderL-A02-5">		
											特别提醒！去往美国乘客必填
										</div>
									</div>
								</li>
								-->
								
							</ul>
						</div>
						</script>
					</div>
					<div class="b2b_OrderL-A02-9">
						<a href="javascript:void(0);" id="linkadd" onclick="addpassenger('');" class="b2b_OrderL-A02-10 b2b_OrderL-A02-11" id="addButton">
							+添加乘机人
						</a>
						<div class="b2b_OrderL-A02-12 ">
							一张订单最多添加 <span>9</span> 名乘客。
						</div>
					</div>
				</div>
				<div class="b2b_OrderL-A">
					<h3>
						联系信息
					</h3>
					<div id="#">
						<div class="b2b_OrderL-A01">
							<ul>

								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										姓名
									</label>
									<div class="b2b_OrderL-A02-2">
										<input  type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="c_linkname2" name="c_linkname" value="陈星"  >
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										手机号码
									</label>
									<div class="b2b_OrderL-A02-2">
										<input type="text" name="c_linktel" id="c_linktel2" class="b2b_OrderL-A02-8" value="15011401852"  style="">
									</div>
								</li>
	
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										电子邮箱
									</label>
									<div class="b2b_OrderL-A02-2">
										<input name="c_linkemail" type="text" class="b2b_OrderL-A02-8" value="1193367@qq.com"  id="c_linkemail2" >
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										留言
									</label>
									<div class="b2b_OrderL-A02-2">
										<input name="c_linkdesc" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="c_linkdesc2" style="">
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="b2b_OrderL-A02-14">
					<a href="#" class="b2b_OrderL-A02-13">
						&lt; 重新选择航班
					</a>
					<a href="javascript:void(0);" onclick="suborder();return false;" class="b2b_OrderL-A02-15" id="submitButton">
						确定提交订单
					</a>
				</div>
			</div>
			<div class="b2b_OrderR">
				<div class="b2b_OrderR-B">
					<div class="b2b_OrderR-B-1">
						<div class="b2b_OrderR-B-2">
							<b class="b2b_OrderR-B-3">
								去程&nbsp;<ww:property value="fromDate" /> <ww:property value="fromCity"/> - <ww:property value="toCity"/> &nbsp; <strong><ww:if test="listsegmentinfo.size>1">中转</ww:if><ww:else>直飞</ww:else></strong>
							</b>
							<ww:iterator value="listsegmentinfo" status="index">
							<p>
								<span class="b2b_OrderR-B-4">
									<ww:property value="airname" />  &nbsp;&nbsp;<strong><ww:property value="flightnumber" /></strong> 
									<span>
										&nbsp;&nbsp;<ww:property value="flightmodel" />
									</span>
								</span>
								<span>
									  <ww:if test="cabincode.equals(\"Y\")">经济舱</ww:if> <ww:if test="cabincode.equals(\"C\")">商务舱</ww:if> <ww:if test="cabincode.equals(\"F\")">头等舱</ww:if>
                                     
								</span>
							</p>
							<div class="b2b_OrderR-B-5">
								<div class="b2b_OrderR-B-6">
									<p><ww:property value="formatTimestampyyyyMMdd(departtime)" /></p>
									<span class="b2b_OrderR-B-6-1"><ww:property value="formatTimestampHHmm(departtime)" /></span>
									<p><ww:property value="startairportname" /><ww:property value="borderpointat" /></p>
								</div>
								<div class="b2b_OrderR-B-8">

								</div>
								<div class="b2b_OrderR-B-7">
									<p><ww:property value="formatTimestampyyyyMMdd(arrivaltime)" /></p>
									<span class="b2b_OrderR-B-6-1 "><ww:property value="formatTimestampHHmm(arrivaltime)" /></span>
									<p><ww:property value="endairportname" /><ww:property value="offpointat" /></p>
								</div>
							</div>
							</ww:iterator>
							
							
							
						</div>
					</div>
					<div class="b2b_OrderR-B-1" style="display: none;">
						<div class="b2b_OrderR-B-2">
							<b class="b2b_OrderR-B-3">
								返程&nbsp;10月25日 西安 - 香港 &nbsp; <strong>中转</strong>
							</b>
							<p>
								<span class="b2b_OrderR-B-4">
									东方航空 &nbsp;&nbsp;<strong>MU2169</strong> 
									<span>
										&nbsp;&nbsp;320
									</span>
								</span>
								<span>
									经济舱
								</span>
							</p>
							<div class="b2b_OrderR-B-5">
								<div class="b2b_OrderR-B-6">
									<p>2014年10月25日</p>
									<span class="b2b_OrderR-B-6-1">16:00</span>
									<p>咸阳国际机场T3航站楼</p>
								</div>
								<div class="b2b_OrderR-B-8">

								</div>
								<div class="b2b_OrderR-B-7">
									<p>2014年10月25日</p>
									<span class="b2b_OrderR-B-6-1 ">18:05</span>
									<p>浦东国际机场T1航站楼</p>
								</div>
							</div>
							<p>
								<span class="b2b_OrderR-B-4">
									上海航空 &nbsp;&nbsp;<strong>FM811</strong> 
									<span>
										&nbsp;&nbsp;738
									</span> 
								</span>
								<span>
									经济舱
								</span>
							</p>
							<div class="b2b_OrderR-B-5">
								<div class="b2b_OrderR-B-6">
									<p>2014年10月26日</p>
									<span class="b2b_OrderR-B-6-1">10:30</span>
									<p>浦东国际机场T1航站楼</p>
								</div>
								<div class="b2b_OrderR-B-8">

								</div>
								<div class="b2b_OrderR-B-7">
									<p>2014年10月26日</p>
									<span class="b2b_OrderR-B-6-1">12:40</span>
									<p>香港国际机场T1航站楼</p>
								</div>
							</div>
							
						</div>
					</div>
					<div class="b2b_OrderR-B-9">
						<a href="#">
							[修改航班]
						</a>
						<span title="退改签信息" class="b2b_OrderR-B-10">
							退改签
						</span>
						<span  class="b2b_OrderR-B-10" title="购票说明">
							购票说明
						</span>
					</div>
				</div>
				<div class="b2b_OrderR-C">
					<div class="b2b_OrderR-C1 " id="#">
						<ul>
							<li class="b2b_OrderR-C1-1">
								<div class="b2b_OrderR-C1-3">
									应付金额：
								</div>
								<div class="b2b_OrderR-C1-2">
									<dfn>￥ </dfn>
									<span class="b2b_OrderR-C1-4" id="totalPrice"></span>
								</div>
							</li>
						</ul>
						<div class="b2b_OrderR-C1-0">
						</div>
						<ul>
							<li class="b2b_OrderR-C1-5" style="font-weight: bold;">
								<div class="b2b_OrderR-C1-6">成人</div>
								<div class="b2b_OrderR-C1-7"><dfn>￥</dfn><span id="pmj1"></span> x <span id="renshu"></span> 人</div>						
							</li>
							<li class="b2b_OrderR-C1-5">
								<div class="b2b_OrderR-C1-6">票价：</div>
								<div class="b2b_OrderR-C1-7"><dfn>￥</dfn><span id="pmj2"></span> /人</div>	
							</li>
							<li class="b2b_OrderR-C1-5"> 
								<div class="b2b_OrderR-C1-6">参考税费：</div> 
								<div class="b2b_OrderR-C1-7"><dfn>￥</dfn><span id="shuifei"></span> /人</div> 
							</li>
							<li class="b2b_OrderR-C1-5"> 
								<div class="b2b_OrderR-C1-6">保险总价：</div> 
								<div class="b2b_OrderR-C1-7"><dfn>￥</dfn><span id="baoxian"></span></div> 
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="clear">
		</div>
		<div style="width:100%;height:20px;">			
		</div>
		
<form action="interticket!CreateOrder.action" id="form2" name="form2" method="post">
 <input type="hidden" id="hidsegmentinfo" name="s_jasonsegmentinfo" value='<ww:property value="s_jasonsegmentinfo" />'  />
 <input type="hidden" id="hidtraveltype"  name="intTravelType" value='<ww:property value="intTravelType" />' /> 
 <input type="hidden"  value="<ww:property value="StartAirportCode"/>" name="StartAirportCode" />
 <input type="hidden"  value="<ww:property value="EndAirportCode"/>" name="EndAirportCode" />
 <input type="hidden"  name="fromDate" value="<ww:property value="fromDate"/>" />
 <input type="hidden" id="hidallpassengers" name="s_jsonpassengers" value='<ww:property value="hidallpassengers" />'  />
 
 
  <input type="hidden"  name="s_contactname" id="c_linkname" value="" />
  <input type="hidden"  name="s_contactmobile" id="c_linktel" value="" />
  <input type="hidden"  name="s_contactemail" id="c_linkemail" value="" />
  <input type="hidden"  name="s_memo" id="c_linkdesc" value="" />
 
 
</form>

		
	</body>
</html>

<script>
//addpassenger("");							

 </script>
