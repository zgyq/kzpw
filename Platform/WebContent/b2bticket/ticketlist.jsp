<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/ticket.css" type="text/css" rel="stylesheet" />

<link href="js/city-control/base.css" rel="stylesheet" />
<link href="js/city-control/citycontrol.css" rel="stylesheet" />

<link href="style/font.css" type="text/css" rel="stylesheet" />
<link href="style/autocomplete.css" type="text/css" rel="stylesheet" />


<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />


<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
     function showDiag(diag,flag)
		{
			document.getElementById(diag).style.display=flag;
		}
</script>

<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/city-control/aircity.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/city-control/jquery.blockUI.js"></script>



<!-- 航班查询用js -->


<script type="text/javascript" src="js/city-control/j.dimensions.js"></script>
<script type="text/javascript" src="js/city-control/j.suggest_old.js"></script>





<script language="javascript">
$(document).ready(function() {

 			//$("#arrcity").val($("#txtsairportname").val());
	        //$("#city_from_hide").val($("#txtsairport").val());
	       // $("#city_from_hide_lc").val($("#txtsairport").val());
	       // $("#arrcity-lc").val($("#txtsairportname").val());
	       // $("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			//$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',onSelect:function(){bindroundfromcity();},attachObject:"#suggest2"});
			//加载联程城市信息
			//$("#arrcity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide_lc',onSelect:function(){$("#tocity-lc").click();}, attachObject:'#suggest-lc'});//
			//$("#tocity-lc").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide_lc',attachObject:"#suggest2-lc"});
	  
	  
	  


     $("img[id*='bookimage_']").each(function(i)
     {
          $("#bookimage_"+i).hide();
     });
      // alert("0");
      var strid="span[id*='lowdiscount_']";
      
       <ww:if test="#session.s_type==1">
       strid="input[id*='lowdiscount_']";
       </ww:if>
       
       
      
     $(strid).each(function(i){
    // alert("1");
    
    var aircode=$("#hidaircompany_"+i).val();
   	if(aircode=='9C'){
  
   	 var cqzrate=$("#hidzratevalue_"+i).val();
   
   	var cqprice=$("#hidz_price_"+i).val();
   	
   	var youhui=parseFloat(cqprice)*parseFloat(cqzrate)/100;
	var jiesuanjia=parseFloat(cqprice)-parseFloat(youhui)+parseFloat($("#hidairportfee_"+i).val())+parseFloat($("#hidfuelfee_"+i).val());
	    jiesuanjia= Math.ceil(jiesuanjia);
   	
   	$("#lowdiscount_"+i).html(cqzrate+"%");//返点
    $("#lowrabate_"+i).html(youhui);//利润
   	$("#lowtotal_price"+i).html(jiesuanjia);//结算价
   	
   	$("#bookimage_"+i).show();
   	
       return;
   	}
     
     
    
    
        $.ajax({
	         type:"POST",
	         url:"b2bairsearch!findcabinlowBY.action",
	         data:{s_fromcity:$("#hidfromcitycode_"+i).val(),s_tocity:$("#hidtocitycode_"+i).val(),s_fromdate:$("#hidfromdate_"+i).val(),s_aircompanycode:$("#hidaircompany_"+i).val(),s_flightnumber:$("#hidflightnumber_"+i).val(),s_cabincode:$("#hidcabincode_"+i).val(),z_price:$("#hidz_price_"+i).val()},
	         beforeSend:function(){$("#lowdiscount_"+i).html("<img src='images/loadding.gif' />")},         
	         success:function(data){
	         //alert(data);
	         	var price=$("#hidz_price_"+i).val();
	         	if(price!='0.0'){
	         	 $("#bookimage_"+i).show();
	         	}else{
	         	//alert("--");
	         	// $("#bookimage_"+i).show();
	         	$("#hidprice_"+i).val("1");
	         	}
	            if(data.split('|').length>0)
	            {
	           // alert(data.split('|')[2]);
	            // alert(<ww:property value="#session.s_type"/>);
	             
	              //$("#lowdiscount_"+i).html("");
	                <ww:if test="#session.s_type==0">
	                 $("#lowdiscount_"+i).html(data.split('|')[0]);
	              	$("#lowrabate_"+i).html(data.split('|')[2]);
	            	 </ww:if>
	             
	             // $("#lowprice_"+i).html(data.split('|')[1]);
	             
	              $("#lowtotal_price"+i).html(parseFloat(data.split('|')[1])+parseFloat($("#hidairportfee_"+i).val())+parseFloat($("#hidfuelfee_"+i).val())+".0");
	              if(data.split('|')[0].indexOf('特殊高')>0)
	              {
	                  $("#lowspdesc_"+i).show();
	              }
	            }
	            else
	            {
	               
	               
	               //$("#lowdiscount_"+i).html("");
	                <ww:if test="#session.s_type==0">
	                $("#lowdiscount_"+i).html("0");
	              	 $("#lowrabate_"+i).html("0");
	                </ww:if>
	              // $("#lowprice_"+i).html("0");
	               
	               $("#lowtotal_price"+i).html("0");
	            }
	         }            
	         });
       });
       
   });
   
   function showzrate()
{
    var selectIndex = document.getElementById("ddlzrate").options.selectedIndex;
    var selectValue = document.getElementById("ddlzrate").options[selectIndex].value;
    if(selectValue=="0")
    {
      $(".zratecss").show();
    }
    else if(selectValue=="1")
    {
       $(".zratecss").hide();
    }
}
   
   
   
   //查询航班序号=index， flag=是否查询特价政策 1=查，0不查
   function getOtherZrate(index,flag)
   {
   //alert(flag);
   
   
       //加载其他舱位政策
       var name="discount_"+index+"_";
       $("span[id*='"+name+"']").each(function(i){
       
       
       var aircode=$("#hidaircompany_"+index+"_"+i).val();
   	if(aircode=='9C'){
  
   	 var cqzrate=$("#hid_zratevalue_"+index+"_"+i).val();
   
   	var cqprice=$("#hid_lowprice_"+index+"_"+i).val();
   	
   	var youhui=parseFloat(cqprice)*parseFloat(cqzrate)/100;
	var jiesuanjia=parseFloat(cqprice)-parseFloat(youhui)+parseFloat($("#hidairportfee_"+i).val())+parseFloat($("#hidfuelfee_"+i).val());
	    jiesuanjia= Math.ceil(jiesuanjia);
   	
   
   	
   	
   	 $("#discount_"+index+"_"+i).html(cqzrate+"%");
     $("#rebate_"+index+"_"+i).html(youhui);
     $("#totalprice_"+index+"_"+i).html(jiesuanjia);
   	
   	
   	$("#bookimage_"+index+"_"+i).show();
   	
       return;
   	}
   	
   	
       
	       if(flag==1)
	       {
	       	$("#bookimagecabin_"+index+"_"+i).hide();
		       if($("#hidz_price_"+index+"_"+i).val()=="0.0")
		       {
		  $.ajax({
         type:"POST",
         url:"b2bairsearch!findcabinlowBY.action",
         data:{s_fromcity:$("#hidfromcitycode_"+index+"_"+i).val(),s_tocity:$("#hidtocitycode_"+index+"_"+i).val(),s_fromdate:$("#hidfromdate_"+index+"_"+i).val(),s_aircompanycode:$("#hidaircompany_"+index+"_"+i).val(),s_flightnumber:$("#hidflightnumber_"+index+"_"+i).val(),s_cabincode:$("#hidcabincode_"+index+"_"+i).val(),z_price:$("#hidz_price_"+index+"_"+i).val()},
         beforeSend:function(){$("#discount_"+index+"_"+i).html("<img src='images/loadding.gif' />")},             
         success:function(data){
            if(data.split('|').length>0)
            {
            $("#bookimagecabin_"+index+"_"+i).show();
            	<ww:if test="#session.s_type==0">
              $("#discount_"+index+"_"+i).html(data.split('|')[0]);
              </ww:if><ww:else>
                $("#discount_"+index+"_"+i).html('');
              </ww:else>
              $("#rebate_"+index+"_"+i).html(data.split('|')[2]);//显示利润
             // $("#price_"+index+"_"+i).html(data.split('|')[1]);//显示动态
               if(data.split('|')[0].indexOf('特殊高')>0)
	              {
	                  $("#spdesc_"+index+"_"+i).show();
	              }
              if(typeof(data.split('|')[1])=='undefined')
              {  
                 $("#totalprice_"+index+"_"+i).html("0");
              }
              else
              {  
                 if(parseFloat(data.split('|')[1])!="0")
                 {
                   $("#totalprice_"+index+"_"+i).html(parseFloat(data.split('|')[1])+parseFloat($("#hidairportfee_"+index).val())+parseFloat($("#hidfuelfee_"+index).val())+".0");
                 }
                 else
                 {
                   $("#totalprice_"+index+"_"+i).html("0.0");
                 }
                 
              }
            }
              else
              {
                 $("#totalprice_"+index+"_"+i).html("0.0");
              }
         }            
         });
		       }
	        }
	        else if(flag==0)
	        {
	        $("#bookimagecabin_"+index+"_"+i).hide();
	        
	        
	           if($("#hidz_price_"+index+"_"+i).val()!="0.0")
		       {
		  $.ajax({
         type:"POST",
         url:"b2bairsearch!findcabinlowBY.action",
         data:{s_fromcity:$("#hidfromcitycode_"+index+"_"+i).val(),s_tocity:$("#hidtocitycode_"+index+"_"+i).val(),s_fromdate:$("#hidfromdate_"+index+"_"+i).val(),s_aircompanycode:$("#hidaircompany_"+index+"_"+i).val(),s_flightnumber:$("#hidflightnumber_"+index+"_"+i).val(),s_cabincode:$("#hidcabincode_"+index+"_"+i).val(),z_price:$("#hidz_price_"+index+"_"+i).val()},
         beforeSend:function(){$("#discount_"+index+"_"+i).html("<img src='images/loadding.gif' />")},             
         success:function(data){
            if(data.split('|').length>0)
            {
            
             $("#bookimagecabin_"+index+"_"+i).show();
            //  $("#discount_"+index+"_"+i).html(data.split('|')[0]);
              
              <ww:if test="#session.s_type==0">
              $("#discount_"+index+"_"+i).html(data.split('|')[0]);
               $("#rebate_"+index+"_"+i).html(data.split('|')[2]);
              //$("#price_"+index+"_"+i).html(data.split('|')[1]);
              </ww:if><ww:else>
                $("#discount_"+index+"_"+i).html('');
              </ww:else>
              
              
             
               if(data.split('|')[0].indexOf('特殊高')>0)
	              {
	                  $("#spdesc_"+index+"_"+i).show();
	              }
              if(typeof(data.split('|')[1])=='undefined')
              {  
                 $("#totalprice_"+index+"_"+i).html("0");
              }
              else
              {  
                 if(parseFloat(data.split('|')[1])!="0")
                 {
                   $("#totalprice_"+index+"_"+i).html(parseFloat(data.split('|')[1])+parseFloat($("#hidairportfee_"+index).val())+parseFloat($("#hidfuelfee_"+index).val())+".0");
                 }
                 else
                 {
                   $("#totalprice_"+index+"_"+i).html("0.0");
                 }
                 
              }
            }
              else
              {
                 $("#totalprice_"+index+"_"+i).html("0.0");
              }
         }            
         });
		       }
	        }
       }); 
       
   }
   //显示其他舱位信息
   function showothercabin(index)
   {
      var cabtr = document.getElementById("air_" + index);
      	if (cabtr.style.display == "block") {
      		cabtr.style.display="none";
      	} else {
      		cabtr.style.display="block";	
      	}
      	getOtherZrate(index,0);
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
function colsedispose(){
 Ext.MessageBox.hide();
}

function showstopinfo(flightnumber,fromdate,stopnum)    
    {   
    
   // return;
     
         $("#divstopinfo").dialog({
	      title:'经停信息',
	      show: null,
	      bgiframe: false,
	      autoOpen: false,
	      draggable: true,                
	      resizable: true,
	      modal: true,
	      width: 250,
	      height: 150
	  });
	  $("#divstopinfo").dialog("open");
	  //读取经停信息
	  
	 
	  $.ajax({
	     type:"POST",
	     url:"b2bticketorder!getFlightStopinfo.action",
	     data:{FF_FlightNumber:flightnumber,FF_date:fromdate,FF_StopNum:stopnum},
	     beforeSend:function(){$("#divstopinfo").html("读取经停信息中...");},             
	     success:function(data){
	     
	  
	     $("#divstopinfo").html(data);           
	     }            
	     }); 
    }    


	   //按票价排序（升序/降序）
function orderbyprice(){

	arr = new Array();
	var rowscount = $("tr[id*='order_']").length;
	for(i=0;i<rowscount;i++){
		var s = $("tr[id*='order_" + i + "']").html();
		var re = $("#lowprice_"+i).html();
		var rs = "" + s.match(re);
		arr[i] = rs;
		
	}
	var orderBy=document.getElementById("hfOrderBy").value;
	if(orderBy=="or1"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 > arr[j] * 2){
				  	var temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    } 
		    }
	    }
	    document.getElementById("hfOrderBy").value="or2";
	    document.getElementById("price_ico").src="images/price_down.gif";
	}else if(orderBy=="or2"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 < arr[j] * 2){
				  	var temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    } 
		    }
	    }
	    document.getElementById("hfOrderBy").value="or1";
	    document.getElementById("price_ico").src="images/price_up.gif";
	}
	pre = 0;
	var isd=0;
	for(i=0;i<rowscount;i++){
		if(arr[i] == pre) continue;
		pre = arr[i];
		for(j=0;j<rowscount;j++){
		 if(arr[i]==$("#lowprice_"+j).html())
		 {
	         aaa = $("#order_"+j);
	         aaa.appendTo($("#ordert"));
         }
        }
		
		
		
	}
}

function orderbydate(){
	arr = new Array();
	var rowscount = $("tr[id*='order_']").length;
	for(i=0;i<rowscount;i++){
		var s = $("tr[id*='order_" + i + "']").html();
		var re = document.getElementById("pricedate_"+i).value;
		var rs = "" + s.match(re);
		arr[i] = rs;
		
	}
	var orderBy=document.getElementById("hfOrderBydate").value;
	if(orderBy=="or1"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 > arr[j] * 2){
				  	var temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    } 
		    }
	    }
	    document.getElementById("hfOrderBydate").value="or2";
	    document.getElementById("price_icodate").src="images/price_down.gif";
	}else if(orderBy=="or2"){
	    for(i=0;i<rowscount;i++){
		    for(j=i+1;j<rowscount;j++){
			    if(arr[i] * 2 < arr[j] * 2){
				  	var temp = arr[j];
				    arr[j] = arr[i];
				    arr[i] = temp;
			    } 
		    }
	    }
	    document.getElementById("hfOrderBydate").value="or1";
	    document.getElementById("price_icodate").src="images/price_up.gif";
	}
	pre = 0;
	var isd=0;
	for(i=0;i<rowscount;i++){
		if(arr[i] == pre) continue;
		pre = arr[i];
		for(j=0;j<rowscount;j++){
		 if(arr[i]==document.getElementById("pricedate_"+j).value)
		 {
	         aaa = $("#order_"+j);
	         aaa.appendTo($("#ordert"));
         }
        }
	}
}

function chageOrder()
{
	//设置排序的关键字--按什么顺序排序
	var orderKey = $("#changeOrderItem").val();
	
	window.location.href="b2bairsearch!tSearch.action?orderKey="+orderKey;
	
	/*
	$.ajax({
           type:"POST",
           url:"b2bairsearch!tSearch.action?orderKey="+orderKey,
           //data:{flightnub:hb,cabincode:cw,citycode:ct,stime:tm},
           //beforeSend:function(){$("#t"+index).html("<img src='images/loadding.gif' />正在获取数据...")},          
           success:function(data){
           }
          }
        );
        */
}

</script>

<script type="text/javascript" language="javascript">
       
		function bindroundfromcity()
		{
	        //绑定联程出发城市
	        $("#arrcity-lc").val($("#tocity").val());
	        $("#city_from_hide_lc").val($("#city_to_hide").val());
		}
		function showBackDate()
        {
            var rdoSingle=document.getElementById("rdoSingle");
            var rdoBack=document.getElementById("rdoBack");
            var rdoLiancheng=document.getElementById("rdoLiancheng");
            var lblBackDate=document.getElementById("lblBackDate");
            var divBackDate=document.getElementById("divBackDate");
            if(rdoSingle.checked==true)
            {
                lblBackDate.style.display="none";
                divBackDate.style.display="none";
                $("#tr_diyicheng").hide();
                $("#tr_diercheng").hide();
                $("#tr_dierchenginfo").hide();
                $("#tr_dierchenginfo_date").hide();
                $("#tr_diercheng_kongbaihang").hide();
            }
            if(rdoBack.checked==true)
            {
                lblBackDate.style.display="block";
                divBackDate.style.display="block";
                $("#tr_diyicheng").hide();
                $("#tr_diercheng").hide();
                $("#tr_dierchenginfo").hide();
                $("#tr_dierchenginfo_date").hide();
                $("#tr_diercheng_kongbaihang").hide();
            }
            if(rdoLiancheng.checked==true)
            {
                $("#tr_diyicheng").show();
                $("#tr_diercheng").show();
                $("#tr_dierchenginfo").show();
                $("#tr_dierchenginfo_date").show();
                $("#tr_diercheng_kongbaihang").show();
                lblBackDate.style.display="none";
                divBackDate.style.display="none";
            }
        }
        function CheckData()
        {
            var rdoFrom=document.getElementById("rdoBack");
            var rdoOnlone=document.getElementById("rdoSingle");
            var rdoLiancheng=document.getElementById("rdoLiancheng");
            if(rdoFrom.checked==true && $("#txtBackDate").val()=="")
            {
                alert("返程时间不能为空！");
                return false;
            }
            else if(Computation($("#txtStartDate").val(),$("#txtBackDate").val())>0)
	        {
	                alert("返程日期不能早于出发日期,请检查后重新填写！");
	                return false; 
	        }
            if(rdoOnlone.checked==true)
            {
	            //if($("#arrcity").val()=="" || $("#tocity").val()=="" || $("#txtStartDate").val()==""||$("#arrcity").val()=="中文/拼音"||$("#tocity").val()=="中文/拼音")//中文/拼音
	            //{
	                //alert("其中 * 号信息为必填信息,请检查后重新填写！");
	                //return false;
	            //}
	            if($("#arrcity").val()=="" || $("#city_from_hide").val=="" ||$("#arrcity").val()=="中文/拼音")
	            {
	                alert("出发城市不能为空，请重新选择！");
	                $("#arrcity").focus();
	                return false;
	            }
	            if($("#tocity").val()=="" || $("#city_to_hide").val=="" || $("#tocity").val()=="中文/拼音")
	            {
	                alert("到达城市不能为空，请重新选择！");
	                $("#tocity").focus();
	                return false;
	            }
	            if($("#txtStartDate").val()=="")
	            {
	               alert("出发日期不能为空，请重新选择！");
	                $("#txtStartDate").focus();
	                return false;
	            }
	            
            }
            
            //联程信息验证
          //  if(rdoLiancheng.checked==true)
           // {
          //      if($("#arrcity-lc").val()=="" || $("#tocity-lc").val()=="" || $("#txtStartDate-lc").val()==""||$("#arrcity-lc").val()=="中文/拼音"||$("#tocity-lc").val()=="中文/拼音")//中文/拼音
	      //      {
	      //          alert("第二程信息，其中 * 号信息为必填信息,请检查后重新填写！");
	      //          return false;
	      //      }
	      //      else if(Computation($("#txtStartDate").val(),$("#txtStartDate-lc").val())>0)
	      //      {
	       //          alert("第二程出发日期不能早于第一程出发日期,请检查后重新填写！");
	      //          return false; 
	      //      }
           // }
            loading('正在为您查询航班信息');
	        return true;
            
        }
        function hideddl()
        {
            $("#ddlAirCom").hide();
        }
        function showddl()
        {
            $("#ddlAirCom").show();
        }
        
        function hidtab(){
        
        	 $("#hidsearch").hide();
        	  $("#hidtd").show();
             $("#showtd").hide();
             
        }
         function showtab(){
        
          $("#hidsearch").show();
           $("#hidtd").hide();
          $("#showtd").show();
        }
	</script>
<style>
.huang14_c {
	font-size: 12px;
	color: #f48000;
	font-weight: 100;
}
</style>
</head>

<body>

<!-- 航班查询 -->
<form action="b2bairsearch!tSearch.action" name="form2" id="form2"
	method="POST" onSubmit="return CheckData()">
<div id="member" style="display: none;">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg" onclick="hidtab();"
			id="showtd"><b class="anse">&nbsp;&nbsp;&nbsp;查询航班<span
			style="color: red">(点击可隐藏)</span></b></td>
		<td width="100%" height="29" class="box bg" onclick="showtab();"
			id="hidtd" style="display: none"><b class="anse">&nbsp;&nbsp;&nbsp;查询航班<span
			style="color: red">(点击可显示)</span></b></td>
	</tr>
	<tr id="hidsearch">
		<td valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						<table width="760" border="1" align="center" cellpadding="0"
							bordercolor="#b3b3b3" cellspacing="0"
							style="font-size: 12px; border-collapse: collapse; margin-top: 20px;">
							<tr class="font-blue-xi" style="display: none" id="tr_diyicheng">
								<td colspan="4"><b>请选择第一程</b></td>
							</tr>
							<tr class="font-blue-xi">
								<td width="120" height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity"> 出发城市：</label></div>
								</td>
								<td width="260" align="left"><input type="text"
									name="StartAirPortName"
									style="border: 1px solid #999999; height: 20px; line-height: 20px;"
									id="arrcity"
									value="<ww:property value="getCitynameByAirport(flightSearch.StartAirportCode)" />"
									onfocus="if(this.value='北京'){this.value='';}hideddl();"
									onblur="if(this.value=='') {this.value='北京';};showddl();" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest' class="ac_results"></div>
								<input type="hidden" id="city_from_hide"
									value="<ww:property value="flightSearch.StartAirportCode" />"
									name="StartAirportCode" /></td>
								<td width="120" height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="city2"> 目的城市：</label></div>
								</td>
								<td align="left"><input
									style="border: 1px solid #999999; height: 20px; line-height: 20px;"
									type="text" name="EndAirPortName" id="tocity"
									value="<ww:property value="getCitynameByAirport(flightSearch.EndAirportCode)" />" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest2' class="ac_results"></div>
								<input type="hidden" id="city_to_hide" name="EndAirportCode"
									value="<ww:property value="flightSearch.EndAirportCode" />" />
								</td>
							</tr>
							<tr class="font-blue-xi">
								<td height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">出发日期：</div>
								</td>
								<td align="left"><input id="txtStartDate"
									style="width: 150px" name="FromDate"
									value="<ww:property value="flightSearch.FromDate" />"
									onfocus="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})"
									class="Wdate" />&nbsp;<span style="color: red">*</span></td>



								<ww:if test="flightSearch.TravelType.equals(\"2\")">
									<td height="28" align="right" style="padding: 0">
									<div
										style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><span
										id="lblBackDate">返程日期：</div>
									</span></td>
									<td align="left">
									<div id="divBackDate"><input id="txtBackDate"
										style="width: 150px" name="BackDate"
										value="<ww:property value="flightSearch.BackDate" />"
										onfocus="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})"
										class="Wdate" />&nbsp;<span style="color: red">*</span></div>
									</td>
								</ww:if>
								<ww:else>

									<td height="28" align="right" style="padding: 0">
									<div
										style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><span
										id="lblBackDate"></div>
									</span></td>
									<td align="left"></td>

								</ww:else>
							</tr>
							<tr class="font-blue-xi" style="display: none" id="tr_diercheng">
								<td colspan="4"><b>请选择第二程</b></td>
							</tr>
							<tr class="font-blue-xi" style="display: none"
								id="tr_dierchenginfo">
								<td width="120" height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="arrcity-lc"> 出发城市：</label></div>
								</td>
								<td width="260" align="left"><input type="text"
									name="StartAirPortName-lc"
									style="border: 1px solid #999999; height: 20px; line-height: 20px;"
									id="arrcity-lc" value="北京"
									onfocus="if(this.value='北京'){this.value='';}"
									onblur="if(this.value=='') {this.value='北京';}" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest-lc' class="ac_results"></div>
								<input type="hidden" id="city_from_hide_lc" value="PEK"
									name="StartAirportCode_lc" /></td>
								<td width="120" height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;"><label
									for="city2-lc"> 目的城市：</label></div>
								</td>
								<td align="left"><input
									style="border: 1px solid #999999; height: 20px; line-height: 20px;"
									type="text" name="EndAirPortName-lc" id="tocity-lc" />&nbsp;<span
									style="color: red">*</span>
								<div id='suggest2-lc' class="ac_results"></div>
								<input type="hidden" id="city_to_hide_lc"
									name="EndAirportCode_lc" /></td>
							</tr>
							<tr class="font-blue-xi" style="display: none"
								id="tr_dierchenginfo_date">
								<td height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">出发日期：</div>
								</td>
								<td align="left"><input id="txtStartDate-lc"
									style="width: 150px" name="FromDate_lc"
									onfocus="WdatePicker({doubleCalendar:true,skin:'whyGreen',minDate:'%y-%M-%d'})"
									class="Wdate" />&nbsp;<span style="color: red">*</span></td>
								<td height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">
								</td>
								<td align="left"></td>

							</tr>
							<tr class="font-blue-xi" style="display: none"
								id="tr_diercheng_kongbaihang">
								<td colspan="4">&nbsp;</td>
							</tr>
							<tr class="font-blue-xi">
								<td height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">航空公司：</div>
								</td>
								<td><select id="ddlAirCom" name="AirCompanyCode"
									style="width: 154px; border: 1px solid #999999">

									<option value="ALL">-------所有航空公司----------</option>

									<ww:iterator value="listAircompany">
										<option value="<ww:property value='aircomcode' />"
											<ww:if test="aircomcode==flightSearch.AirCompanyCode">selected</ww:if>><ww:property
											value="aircomcode" /> <ww:property value="aircomcnname" />
										</option>
									</ww:iterator>
								</select></td>
								<td height="28" align="right" style="padding: 0">
								<div
									style="background: #f0f0f0; height: 28px; margin: 1px 0 0 1px; width: 100%;">航程类型：</div>
								</td>
								<td align="left"><input name="TravelType" id="rdoSingle"
									type="radio" value="1"
									<ww:if test="flightSearch.TravelType.equals(\"1\")">checked</ww:if>
									onclick="showBackDate();" />单程&nbsp;<input name="TravelType"
									<ww:if test="flightSearch.TravelType.equals(\"2\")">checked</ww:if>
									type="radio" value="2" id="rdoBack" onclick="showBackDate();" />往返
								&nbsp; <!--
									联程<input name="TravelType" type="radio"
									type="radio" value="3" id="rdoLiancheng" onclick="showBackDate();" />
									
								
								
								<span style="color: red">柜台版</span><input type="checkbox" name="s_type" value="1" <ww:if test="s_type==1">checked</ww:if> />
								--></td>


							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td align="center"><input type="submit"
							style="background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
							value="查&nbsp;&nbsp;询" /></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</form>

<!-- 航班查询 -->
<form id="form1" name="form1">
<div id="divstopinfo"
	style="text-align: center; display: none; background-color: #fff; left: 0px; width: 200px;">正在加载经停信息...
</div>
<input type="hidden" id="hfOrderBy" value="or1" /> <input type="hidden"
	id="hfOrderBydate" value="or1" />
<div>

<div>


<div>

<div class="box">
<div class="quan" style="display: none"><font class="lan14_cu"><b><ww:property
	value="getCitynameByAirport(flightSearch.StartAirportCode)" />-<ww:property
	value="getCitynameByAirport(flightSearch.EndAirportCode)" />的机票列表</b></font><img
	src="images/i.gif" align='absmiddle'
	style="margin-right: 10px; margin-left: 40px;" /><font color='red'>友情提示：由于航空公司折扣及价格经常变动，预定价格按照PAT数据为准！</font></div>



<div class="xingq" style="height: 50px; margin: 0 auto;"><ww:bean
	name="'com.opensymphony.webwork.util.Counter'" id="counter">
	<ww:param name="'first'" value="1" />
	<ww:param name="'last'" value="7" />
</ww:bean> <ww:iterator value="#counter" status="state">

	<a style="cursor: pointer;" onclick="loading('系统正在为您查询');"
		href="b2bairsearch!
		<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>0">tobookback</ww:if><ww:else>tSearch</ww:else>.action?StartAirportCode=<ww:property value="flightSearch.StartAirportCode"/>&EndAirportCode=<ww:property value="flightSearch.EndAirportCode"/>&FromDate=
			<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>0">
			<ww:property value="flightSearch.FromDate" />
			</ww:if>
			<ww:else>
			<ww:property value="GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate)))"/>
			</ww:else>
		
			<ww:if test="flightSearch.TravelType.equals(\"2\")">&BackDate=
				<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>1">
				<ww:property value="GetDate(flightSearch.BackDate,#state.index-(Calculate(flightSearch.BackDate)>3?3:Calculate(flightSearch.BackDate)))" />
				</ww:if><ww:else>
				<ww:property value="flightSearch.BackDate" />
				</ww:else>
			</ww:if>
			<ww:if test="flightSearch.TravelType.equals(\"3\")">&BackDate=
				<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>1">
				<ww:property value="GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate)))" />
				</ww:if><ww:else>
				<ww:property value="flightSearch.FromDate" />
				</ww:else>
			</ww:if>
			&TravelType=<ww:property value="flightSearch.TravelType" />
		<ww:if test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>0">&HfFligIndex2=<ww:property value="HfFligIndex2" />&issession=-1&HfCabinid=<ww:property value="HfCabinid" />
		</ww:if>&AirCompanyCode=<ww:property value="flightSearch.AirCompanyCode" />">

	<ww:if test="flightSearch.TravelType.equals(\"2\")">

		<ww:if test="isBackOrTo==1">
			<ww:if
				test="(#state.index)==(Calculate(flightSearch.BackDate)>3?3:Calculate(flightSearch.BackDate))">
				<span
					style="height: 38px; line-height: 19px; background: #FFF; border-top: 4px solid #36A1EA; border-left: 1px solid #36A1EA; border-right: 1px solid #36A1EA; font-weight: bold; color: #f48000;">
			</ww:if>
			<ww:else>
				<span
					style="height: 38px; line-height: 19px; margin-left: 15px; font-family: 'Lucida Sans Unicode', 'Lucida Grande', sans-serif">
			</ww:else>
		</ww:if>
		<ww:else>
			<!-- 原来是#state.index+1 -->
			<ww:if
				test="(#state.index)==(Calculate(flightSearch.BackDate)>3?3:Calculate(flightSearch.BackDate))">
				<span
					style="height: 38px; line-height: 19px; background: #FFF; border-top: 4px solid #36A1EA; border-left: 1px solid #36A1EA; border-right: 1px solid #36A1EA; font-weight: bold; color: #f48000;">
			</ww:if>
			<ww:else>
				<span
					style="height: 38px; line-height: 19px; margin-left: 15px; font-family: 'Lucida Sans Unicode', 'Lucida Grande', sans-serif">
			</ww:else>
		</ww:else>
	</ww:if><ww:elseif test="flightSearch.TravelType.equals(\"3\")">
	
	<ww:if test="isBackOrTo==1">
			<ww:if
				test="(#state.index)==(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate))">
				<span
					style="height: 38px; line-height: 19px; background: #FFF; border-top: 4px solid #36A1EA; border-left: 1px solid #36A1EA; border-right: 1px solid #36A1EA; font-weight: bold; color: #f48000;">
			</ww:if>
			<ww:else>
				<span
					style="height: 38px; line-height: 19px; margin-left: 15px; font-family: 'Lucida Sans Unicode', 'Lucida Grande', sans-serif">
			</ww:else>
		</ww:if>
		<ww:else>
			<!-- 原来是#state.index+1 -->
			<ww:if
				test="(#state.index)==(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate))">
				<span
					style="height: 38px; line-height: 19px; background: #FFF; border-top: 4px solid #36A1EA; border-left: 1px solid #36A1EA; border-right: 1px solid #36A1EA; font-weight: bold; color: #f48000;">
			</ww:if>
			<ww:else>
				<span
					style="height: 38px; line-height: 19px; margin-left: 15px; font-family: 'Lucida Sans Unicode', 'Lucida Grande', sans-serif">
			</ww:else>
		</ww:else>
		
	
	</ww:elseif>
	
	<ww:else>
		<ww:if
			test="#state.index==(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate))">
			<span
				style="height: 38px; line-height: 19px; background: #FFF; border-top: 4px solid #36A1EA; border-left: 1px solid #36A1EA; border-right: 1px solid #36A1EA; font-weight: bold; color: #f48000;">
		</ww:if>
		<ww:else>
			<span
				style="height: 38px; line-height: 19px; margin-left: 15px; font-family: 'Lucida Sans Unicode', 'Lucida Grande', sans-serif">
		</ww:else>
	</ww:else>

	<ul>
		<ww:if
			test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>1">
				<ww:if test="flightSearch.TravelType.equals(\"3\")">
					<li><ww:property
					value="GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate)))" /></li>
					<li><ww:property
					value="getWeekStr(GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate))))" /></li>
				</ww:if>
				<ww:else>
					<li><ww:property
					value="GetDate(flightSearch.BackDate,#state.index-(Calculate(flightSearch.BackDate)>3?3:Calculate(flightSearch.BackDate)))" /></li>
				    <li><ww:property
					value="getWeekStr(GetDate(flightSearch.BackDate,#state.index-(Calculate(flightSearch.BackDate)>3?3:Calculate(flightSearch.BackDate))))" /></li>
				</ww:else>
			
		</ww:if>
		<ww:else>
			<li><ww:property
				value="GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate)))" /></li>
			<li><ww:property
				value="getWeekStr(GetDate(flightSearch.FromDate,#state.index-(Calculate(flightSearch.FromDate)>3?3:Calculate(flightSearch.FromDate))))" /></li>
		</ww:else>
	</ul>
	</span> </a>
</ww:iterator></div>

<div style="padding-top: 5px; line-height: 25px;">&nbsp;&nbsp;&nbsp;&nbsp;航程信息：<ww:if
	test="!flightSearch.TravelType.equals(\"3\")">出发：<ww:property
		value="getCitynameByAirport(flightSearch.StartAirportCode)" />&nbsp;到达：<ww:property
		value="getCitynameByAirport(flightSearch.EndAirportCode)" />&nbsp;出发日期：<ww:property
		value="flightSearch.FromDate" />&nbsp;<ww:if
		test="flightSearch.TravelType.equals(\"2\")">返程日期：<ww:property
			value="flightSearch.BackDate" />
	</ww:if>
</ww:if> &nbsp;&nbsp;<ww:if test="flightSearch.TravelType.equals(\"3\")">
	&nbsp;出发城市：<ww:property
		value="getCitynameByAirport(flightSearch.StartAirportCode)" />
	&nbsp;到达城市：<ww:property
		value="getCitynameByAirport(flightSearch.EndAirportCode)" />
	&nbsp;出发日期：<ww:property value="flightSearch.FromDate" />&nbsp;
    </ww:if> &nbsp;&nbsp;(<b>共<ww:property value="listFlightInfoAll.size" />个航班</b>)&nbsp;&nbsp;&nbsp;
<span style="display: none"> <font class="huang12_c"> <a
	href="#" onclick="orderbydate();return false;"> <span> <img
	id="price_icodate" src="images/price_up.gif" />时间排序</span></a>&nbsp;&nbsp; <a
	href="#" onclick="orderbyprice();return false;"> <img
	id="price_ico" src="images/price_up.gif" />价格排序</a> </font> </span> <!-- 排序操作 Begin -->
<select id="changeOrderItem" style="margin-right: 5px"
	onchange="javascript:chageOrder()">
	<ww:iterator value="orderItemMap">
		<option value="<ww:property value='key'/>"
			<ww:if test="orderKey==key">selected='selected'</ww:if>><ww:property
			value="value" /></option>
	</ww:iterator>
</select> <!--  排序操作 End  --> <select onchange="showzrate();"
	name="s_isshowzrate" id="ddlzrate">
	<option value="1">隐藏返点</option>
	<option value="0" selected>显示返点</option>
</select></div>
<ww:if
	test="segmentOne!=null&&segmentOne.flightnumber!=null&&segmentOne.flightnumber.length()>0">
	<div style="margin-top: 0px;"><span style="padding-left: 15px;"><b
		class="lan_xia"><ww:if test="flightSearch.TravelType.equals(\"2\")">去程</ww:if><ww:if
		test="flightSearch.TravelType.equals(\"3\")">第一行程</ww:if>信息是：</b></span></div>
	<div class="hangb "
		style="margin-top: 5px; background: #DDECF3; border: 2px dashed #f48000;">
	<ul class="huang12_c" style="height: 30px; text-align: center;">
		<li style="width: 13%"><b>航班信息</b></li>
		<li style="width: 25%; text-align: left;"><b
			style="margin-left: 25px;">抵达时间／机场 </b></li>
		<li style="width: 5%"><b>机型</b></li>
		<li style="width: 9%"><b>机建/燃油</b></li>
		<li style="width: 10%"><b>所选舱位</b></li>
		<li style="width: 10%"><b>票面价</b></li>
		<ww:if test="#session.s_type==1">

		</ww:if>
		<ww:else>
			<li style="width: 9%"><b>优惠/返点</b></li>
			<li style="width: 9%"><b>结算价</b></li>
		</ww:else>


		<li style="width: 10%"><b>采购价</b></li>
	</ul>
	<ul style="height: 40px; line-height: 20px; text-align: center;">
		<li style="width: 13%">
		<dl
			style="float: left; height: 40px; padding-top: 5px; padding-left: 10px;">
			<img
				src="images/airComlogo/<ww:property value="segmentOne.aircomapnycode" />.gif" />
		</dl>
		<dl>
			<ww:property value="segmentOne.flightnumber" />
		</dl>
		<dl>
			<ww:property value="segmentOne.aircompanyname" />
		</dl>
		</li>
		<input type="hidden"
			id="pricedate_<ww:property value="#state.index"/>"
			value="<ww:property value="formatTimestamporderbydate(DepartTime)" />" />
		<li style="width: 25%; text-align: left; overflow: hidden;"><img
			src="images/plane1.gif" width="25" height="20" /><span><font
			style="margin: 0 5px 0 2px;"><ww:property
			value="formatTimestampHHmm(segmentOne.departtime)" /></font><ww:property
			value="flightOne.StartAirportName" /></span><span style="color: red">(<ww:property
			value="segmentOne.borderpointat" />)</span><br />
		<img src="images/plane2.gif" width="25" height="20" /><span><font
			style="margin: 0 5px 0 2px;"><ww:property
			value="formatTimestampHHmm(segmentOne.arrivaltime)" /></font><ww:property
			value="flightOne.EndAirportName" /></span><span style="color: red">(<ww:property
			value="segmentOne.offpointat" />)</span></li>
		<li style="width: 5%;">
		<div><font style="line-height: 40px;"><ww:property
			value="segmentOne.flightmodelnum" /></font></div>
		</li>
		<li style="width: 9%; line-height: 40px; text-align: center;"><ww:property
			value="segmentOne.airportfee" />/<ww:property
			value="segmentOne.fuelfee" /></li>
		<li style="width: 10%; font-size: 14px; line-height: 40px;"><ww:property
			value="getynamebycode(segmentOne.discount)" /></li>
		<li style="width: 10%; line-height: 40px;"><span><b
			class="huang14_c" style="line-height: 40px;">￥ <ww:property
			value="formatMoney(segmentOne.Parvalue)" /> </b></span></li>
		<li style="width: 9%; font-size: 14px; line-height: 40px;"><ww:if
			test="#session.s_type==1">

		</ww:if><ww:else>
			<ww:if test="segmentOne.ratevalue==null">
		无返点
		</ww:if>
			<ww:else>
				<ww:property value="formatMoney(segmentOne.ratevalue)" />%
		</ww:else>
		</ww:else></li>
		<ww:if test="#session.s_type!=2">
			<li style="width: 9%;"><span><b class="huang14_c"
				style="line-height: 40px;">￥<ww:property
				value="formatMoney(segmentOne.Price)" /></b></span></li>
		</ww:if>

		<li style="width: 10%;"><span><b class="huang14_c"
			style="line-height: 40px;">￥<ww:property
			value="formatMoney(segmentOne.airportfee+segmentOne.fuelfee+segmentOne.Price)" /></b></span></br>
		(含税费)</li>
		<div style="margin-left: 100px;"><input type='hidden'
			id='hidPriceSin' value='<ww:property value="segmentOne.Price" />' />
		<input type='hidden' id='hidYPriceSin'
			value='<ww:property value="segmentOne.yprice"/>' /> <input
			type='hidden' id='hidairportFeeSin'
			value='<ww:property value="segmentOne.airportfee"/>' /> <input
			type='hidden' id='hidfuelFeeSin'
			value='<ww:property value="segmentOne.fuelfee"/>' /> <input
			type='hidden' id='hidtotalSin'
			value='<ww:property
					value="formatMoney(segmentOne.Price+segmentOne.airportfee+segmentOne.fuelfee)" />' /></div>
	</ul>
	</div>
	<div class="c"></div>
	<div><span style="padding-left: 15px;"><b><ww:if
		test="flightSearch.TravelType.equals(\"2\")">返程</ww:if><ww:if
		test="flightSearch.TravelType.equals(\"3\")">第二行程</ww:if>信息：</b></span></div>
</ww:if> <!--复选项结束-->
<div class="hangb">



<table id="ordert" width="100%" border="0" cellpadding="0"
	cellspacing="0">

	<tr class="huang12_c"
		style="background: #DDECF3; line-height: 30px; text-align: center; font-weight: bold">
		<td style="width: 20%" align="left"><span
			style="margin-left: 50px">起飞抵达</span></td>
		<td style="width: 13%; height: 30px;">航班信息</td>
		<td style="width: 5%">机型</td>
		<td style="width: 9%">机建/燃油</td>
		<td style="width: 8%">票面价</td>
		<td style="width: 9%">销售价</td>
		<td class="zratecss" style="width: 9%">佣金/返点</td>
		<td class="zratecss" width="8%">采购价</td>
		<td style="width: 9%">余座/舱位</td>
		<td>操作</td>
	</tr>

	<ww:if test="listFlightInfoAll.size>0">
		<ww:iterator value="listFlightInfoAll" status="state">
		<!-- 隐藏域 -->
		<input type="hidden"
			id='hid_lowprice_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.price" />' />
			
		<input type="hidden"
			id='hid_lowfandian_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.ratevalue" />' />
			
			
		<input type="hidden"
			id='hid_lowdiscount_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.Discount" />' />
		<input type="hidden"
			id='hid_lowyprice_<ww:property value="#state.index" />'
			value='<ww:property value="YPrice" />' />
		<input type="hidden"
			id='hid_lowseatnum_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.SeatNum" />' />
		<input type="hidden"
			id='hid_lowcabincode_<ww:property value="#state.index" />'
			value='<ww:property value="LowCarbin.Cabin" />' />
		<input type="hidden"
			id='hid_lowdeparttime_<ww:property value="#state.index" />'
			value='<ww:property value="formatTimestamp(DepartTime)" />' />
		<input type="hidden"
			id='hid_lowstartairportname_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirportName" />' />
		<input type="hidden"
			id='hid_lowstartairport_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirport" />' />
		<input type="hidden"
			id='hid_lowarrivetime_<ww:property value="#state.index" />'
			value='<ww:property value="formatTimestamp(ArriveTime)" />' />
		<input type="hidden"
			id='hid_lowendairportname_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirportName" />' />
		<input type="hidden"
			id='hid_lowendairport_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirport" />' />
		<input type="hidden"
			id='hid_lowflightnumber_<ww:property value="#state.index" />'
			value='<ww:property value="Airline" />' />
		<input type="hidden"
			id='hid_lowaircompany_<ww:property value="#state.index" />'
			value='<ww:property value="AirCompany" />' />
		<input type="hidden"
			id='hid_lowaircompanyname_<ww:property value="#state.index" />'
			value='<ww:property value="getAirCompanyNameByCode(AirCompanyName)" />' />
		<input type="hidden"
			id='hid_lowflighttype_<ww:property value="#state.index" />'
			value='<ww:property value="AirplaneType" />' />
		<input type="hidden"
			id='hid_lowflightdesc_<ww:property value="#state.index" />'
			value='<ww:property value="AirplaneTypeDesc" />' />
		<input type="hidden"
			id='hid_lowairportfee_<ww:property value="#state.index" />'
			value='<ww:property value="AirportFee" />' />
		<input type="hidden"
			id='hid_lowfuelfee_<ww:property value="#state.index" />'
			value='<ww:property value="FuelFee" />' />
		<input type="hidden"
			id='hid_lowrules_<ww:property value="#state.index" />'
			value='<ww:property value="rules" />' />

		<!-- 新增加航站楼 -->
		<input type="hidden"
			id='hid_borderpointat_<ww:property value="#state.index" />'
			value='<ww:property value="StartAirportHZL"/>' />
		<input type="hidden"
			id='hid_offpointat_<ww:property value="#state.index" />'
			value='<ww:property value="EndAirportHZL"/>' />
		<!-- 新增加政策信息 -->
		<input type="hidden"
			id='hid_zrateid_<ww:property value="#state.index" />' value='0' />
		<input type="hidden"
			id='hid_zratevalue_<ww:property value="#state.index" />' value='<ww:property value="LowCarbin.ratevalue"/>' />

		<!-- 新增加强制保险信息 -->
		<input type="hidden"
				id='hid_qiangzhibaoxian_<ww:property value="#state.index" />'
				value='0' />
				
				
				
			<tr id="order_<ww:property value="#state.index"/>"
				style="line-height: 24px;">

				<input type="hidden"
					id="pricedate_<ww:property value="#state.index"/>"
					value="<ww:property value="formatTimestamporderbydate(DepartTime)" />" />
				<td style="text-align: left; border-top: 1px solid #36a1ea;"><span><font
					style="margin: 0 5px 0 5px;"><ww:property
					value="formatTimestampHHmm(DepartTime)" /></font><ww:property
					value="StartAirportName" /></span><span style="color: red">(<ww:property
					value="StartAirportHZL" />)</span><br />
				<span><font style="margin: 0 5px 0 5px;"><ww:property
					value="formatTimestampHHmm(ArriveTime)" /></font><ww:property
					value="EndAirportName" /></span><span style="color: red">(<ww:property
					value="EndAirportHZL" />)</span></td>
				<td style="border-top: 1px solid #36a1ea;">
				<dl style="float: left; height: 40px; padding-top: 5px;">
					&nbsp;&nbsp;
					<img src="images/airComlogo/<ww:property value="AirCompany" />.gif" />
				</dl>
				<dl>
					&nbsp;&nbsp;
					<ww:property value="Airline" />
				</dl>
				<dl>
					&nbsp;&nbsp;
					<ww:property value="AirCompanyName" />

				</dl>
				</td>
				<td style="text-align: center; border-top: 1px solid #36a1ea;">
				<div style="cursor: pointer;"
					onmouseover="showDiag('diag<ww:property value="#state.index"/>','block')"
					onmouseout="showDiag('diag<ww:property value="#state.index"/>','none')"><font
					style="color: #06F; font-weight: bold; font-size: 14px; border-bottom: 1px dashed #06f; line-height: 40px;"><ww:property
					value="AirplaneType" /></font> <ww:if test="LowCarbin.Discount<40.0">
					<br />
					<img src="images/tejia.gif" />
				</ww:if>

				<div style="position: relative; z-index: 9999999999999;">

				<div id="diag<ww:property value="#state.index"/>"
					style="display: none; position: absolute; z-index: 9999999999999999999; left: 0px; width: 225px; background: #fff; text-align: center; line-height: 20px;"
					class="box">
				<div
					style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>机型信息</b></div>
				<div style="padding: 5px; height: 64px; text-align: left;"><ww:property
					value="subfightimg(AirplaneTypeDesc)" /></div>

				<!--
				<div style="padding: 5px; height: 64px; text-align: left;"><ww:property
					value="LowCarbin.CabinRules" /></div>
				--></div>
				</div>
				</div>
				<input type='hidden'
					id='hidfromcitycode_<ww:property value="#state.index"/>'
					value='<ww:property value="StartAirport" />' /> <input
					type='hidden'
					id='hidtocitycode_<ww:property value="#state.index"/>'
					value='<ww:property value="EndAirport" />' /> <input type='hidden'
					id='hidfromdate_<ww:property value="#state.index"/>'
					value='<ww:property value="formatTimestamp2(DepartTime)" />' /> <input
					type='hidden'
					id='hidaircompany_<ww:property value="#state.index"/>'
					value='<ww:property value="AirCompany" />' /> <input type='hidden'
					id='hidflightnumber_<ww:property value="#state.index"/>'
					value='<ww:property value="getAirLineNumber(Airline)" />' /> <input
					type='hidden' id='hidcabincode_<ww:property value="#state.index"/>'
					value='<ww:property value="LowCarbin.Cabin" />' /> <input
					type='hidden' id='hidz_price_<ww:property value="#state.index"/>'
					value='<ww:property value="LowCarbin.price" />' />
					
					<input
					type="hidden" id='hidzratevalue_<ww:property value="#state.index"/>'
					value='<ww:property value="LowCarbin.ratevalue" />' />
					
					
					</td>
				<td
					style="font-size: 14px; line-height: 40px; text-align: center; border-top: 1px solid #36a1ea;"><ww:property
					value="AirportFee" />/<ww:property value="FuelFee" /> <ww:if
					test='!isStopInfo.equals("0")'>
					<!--
					ChangeDateMode
					-->
					<p
						onclick="showstopinfo('<ww:property value="Airline" />','<ww:property value="(flightSearch.FromDate)" />','<ww:property value="isStopInfo" />');"><font
						style="color: red; border-bottom: 1px dashed #06f; cursor: hand">经停<ww:property
						value="isStopInfo" />次</font></p>
				</ww:if></td>
				<!-- 票面价 -->
				<td style="text-align: center; border-top: 1px solid #36a1ea;"><span>￥<ww:property
					value="LowCarbin.price" /><br />
				(<ww:if test="LowCarbin.Discount>=100.0">
					<ww:if test="LowCarbin.Discount==100.0">全价</ww:if>
					<ww:else>
						<ww:property value="LowCarbin.Discount/10" />折</ww:else>

				</ww:if> <ww:else>
					<ww:property value="LowCarbin.Discount/10" />折</ww:else>)</span><br />
				</td>
				<!-- 销售价 -->
				<td style="text-align: center; border-top: 1px solid #36a1ea;"><span>￥<ww:property
					value="LowCarbin.price+AirportFee+FuelFee" /></span></br>

				</td>



				<td class="zratecss"
					style="padding-top: 0px; text-align: center;; border-top: 1px solid #36a1ea;">


				<span style="color: red"
					id="lowrabate_<ww:property value="#state.index"/>">0</span> <font
					style="font-size: 14px; font-weight: bold;"> <ww:if
					test="getLoginUserAgent().agenttype==1">
					<!-- 返点值隐藏起来，暂不需要 -->
					<br />
					<span style="color: red"
						id="lowdiscount_<ww:property value="#state.index"/>">0</span>
					<!-- 返点值隐藏起来，暂不需要 -->
				</ww:if> <ww:else>
					<!-- 返点值隐藏起来，暂不需要 -->
					<br />
					<span style="color: red"
						id="lowdiscount_<ww:property value="#state.index"/>">0</span>
					<!-- 返点值隐藏起来，暂不需要 -->

				</ww:else> <span id="lowspdesc_<ww:property value="#state.index"/>"
					style="display: none"><font
					style="font-size: 14px; font-weight: bold; color: red">★</br>
				<img src="images/tsg.gif" /></font></span> </font></td>







				<input type="hidden"
					id="hidairportfee_<ww:property value="#state.index"/>"
					value="<ww:property value="AirportFee"/>" />
				<input type="hidden"
					id="hidfuelfee_<ww:property value="#state.index"/>"
					value="<ww:property value="FuelFee"/>" />

				<!-- 采购价 -->
				<td class="zratecss"
					style="text-align: center; border-top: 1px solid #36a1ea;">￥ <span
					id='lowtotal_price<ww:property value="#state.index"/>'><ww:property
					value="AirportFee + FuelFee + LowCarbin.Price" /></span></br>
				(含税费) </br>

				</td>
				<td
					style="padding-top: 10px; text-align: center;; border-top: 1px solid #36a1ea;">
				<a href="#">
				<div style="cursor: pointer;"
					onmouseover="showDiag('tgq<ww:property value="#state.index"/>','block')"
					onmouseout="showDiag('tgq<ww:property value="#state.index"/>','none')">

				<ww:if test="LowCarbin.SeatNum.equals(\"9\")">≥9(<ww:property
						value="LowCarbin.Cabin" />舱)
						<br />
					<ww:if test="LowCarbin.Discount>=150.0">头等舱</ww:if>
					<ww:elseif test="LowCarbin.Discount>=130.0">商务舱</ww:elseif>
					<ww:elseif test="LowCarbin.Special">经济舱</ww:elseif>
					<ww:else>经济舱</ww:else>
				</ww:if><ww:else>
					<ww:property value="LowCarbin.SeatNum" />(<ww:property
						value="LowCarbin.Cabin" />舱)
						<br />
					<ww:if test="Discount>=150.0">头等舱</ww:if>
					<ww:elseif test="Discount>=130.0">商务舱</ww:elseif>
					<ww:elseif test="Special">经济舱</ww:elseif>
					<ww:else>经济舱</ww:else>
				</ww:else>

				<div style="position: relative; z-index: 9999999999999;">
				<div id="tgq<ww:property value="#state.index"/>"
					style="display: none; position: absolute; z-index: 9999999999999999999; left: 0px; width: 225px; background: #fff; text-align: center; line-height: 20px;"
					class="box">
				<div
					style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签信息</b></div>
				<div
					style="padding: 5px; height: 128px; text-align: left; z-index: 99999">
				<ww:property value="LowCarbin.CabinRules" /> <!--<ww:property value="LowCarbin.CabinRules" />
				--></div>
				</div>
				</div>

				</div>
				</a></td>

				<td style="text-align: center; border-top: 1px solid #36a1ea;">
				<!-- 隐藏域判断价格 --> <input type="hidden"
					id="hidprice_<ww:property value="#state.index"/>" value="0" />
					<ww:if test="AirCompany=='9C'">
					<span><a
						href="javascript:tocreatorder9c(<ww:property value="#state.index"/>,1)">
					<img src="images/gouml.gif" border="none"
						id="bookimage_<ww:property value="#state.index"/>"
						<ww:if test="LowCarbin.price==0.0">style='display: none;'</ww:if> />
					</a> </span>
					
					</ww:if><ww:else>
							 <ww:if
					test="isBackOrTo==1">
					<span><a
						href="javascript:gotoBookto(1,<ww:property value="#state.index"/>,-1)">
					<img src="images/gouml.gif" border="none"
						id="bookimage_<ww:property value="#state.index"/>"
						<ww:if test="LowCarbin.price==0.0">style='display: none;'</ww:if> />
					</a> </span>
				</ww:if> <ww:else>
					<span> <a
						href="javascript:gotoBookback(1,<ww:property value="#state.index"/>,-1)">
					<img src="images/gouml.gif" border="none"
						id="bookimage_<ww:property value="#state.index"/>"
						<ww:if test="LowCarbin.price==0.0">style='display: none;'</ww:if> /></a>
					</span>
				</ww:else>
					
					
					</ww:else>
					
					
					&nbsp; <span><img
					style="color: #06F; text-decoration: none; cursor: pointer"
					onclick="showothercabin(<ww:property value="#state.index"/>);return false;"
					src="images/qtcw.gif" /> </span></td>
			</tr>
			<!-- 特价舱位显示开始 -->
			<ww:iterator value="Carbins" status="cabState">
				<ww:if test="#cabState.index==-1">
					<tr style="background-color: #ffffee">

						<td colspan="3"
							style="font-size: 14px; line-height: 40px; text-align: right; border-top: 1px dashed #999;">

						<div style="cursor: pointer;"
							onmouseover="showDiag('tgq<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','block')"
							onmouseout="showDiag('tgq<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','none')">

						<img src="images/tejia.gif" />&nbsp;&nbsp; <ww:if
							test="Discount>=150.0">头等舱</ww:if> <ww:elseif
							test="Discount>=130.0">商务舱</ww:elseif> <ww:elseif test="Special">经济舱</ww:elseif>
						<ww:else>经济舱</ww:else>(<ww:property value="cabin" />舱/<ww:if
							test="Discount>=100.0">
							<ww:if test="Discount==100.0">全价</ww:if>
							<ww:else>
								<ww:property value="Discount/10" />折</ww:else>
						</ww:if> <ww:else>
							<span
								id="zhe_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"><ww:property
								value="Discount/10" /></span>折</ww:else>)

						<div style="position: relative; z-index: 9999999999999;">
						<div
							id="tgq<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
							style="display: none; position: absolute; z-index: 9999999999999999999; left: 0px; width: 225px; background: #fff; text-align: center; line-height: 20px;"
							class="box">
						<div
							style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签信息</b></div>
						<div
							style="padding: 5px; height: 128px; text-align: left; z-index: 99999"><ww:property
							value="CabinRules" /></div>
						</div>
						</div>
						</div>


						</td>
						<td width="5px" style="border-top: 1px dashed #999;"></td>
						<td
							style="font-size: 14px; line-height: 40px; text-align: center; border-top: 1px dashed #999;">
						<ww:if test="Price==0.0">
							<a
								href="javascript:lodprice('<ww:property value="Airline" />','<ww:property value="cabin" />','<ww:property value="StartAirport" />,<ww:property value="EndAirport" />','<ww:property value="flightSearch.FromDate" />','<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>');">
							<div
								id="t<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
								style="color: red;"><img src="images/spbutton.gif" /></div>
							</a>
							<span style="display: none;"
								id="lowprice2_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
						</ww:if> <ww:else>
								￥<ww:property value="Price" />
						</ww:else></td>

						<td
							style="padding-top: 0px; text-align: center;; border-top: 1px dashed #999;">
						<input type='hidden'
							id='hidfromcitycode_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
							value='<ww:property value="StartAirport" />' /> <input
							type='hidden'
							id='hidtocitycode_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
							value='<ww:property value="EndAirport" />' /> <input
							type='hidden'
							id='hidfromdate_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
							value='<ww:property value="formatTimestamp2(DepartTime)" />' />
						<input type='hidden'
							id='hidaircompany_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
							value='<ww:property value="AirCompany" />' /> <input
							type='hidden'
							id='hidflightnumber_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
							value='<ww:property value="getAirLineNumber(Airline)" />' /> <input
							type='hidden'
							id='hidcabincode_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
							value='<ww:property value="cabin" />' /> <input type='hidden'
							id='hidz_price_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
							value='<ww:property value="Price" />' /> <input type="hidden"
							id="hidairportfee_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
							value="<ww:property value="AirportFee"/>" /> <input
							type="hidden"
							id="hidfuelfee_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
							value="<ww:property value="FuelFee"/>" /> <span
							style="color: red; display: block"
							id="rebate_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
						<font style="font-size: 14px; font-weight: bold;"> <ww:if
							test="getLoginUserAgent().agenttype==1">
							<!-- 返点值隐藏起来，暂不需要 -->
							<span style="display: block"
								id="discount_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
							<!-- 返点值隐藏起来，暂不需要 -->
						</ww:if> <ww:else>
							<!-- 返点值隐藏起来，暂不需要 -->
							<span style="display: block"
								id="discount_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
							<!-- 返点值隐藏起来，暂不需要 -->
						</ww:else> </font></td>

						<ww:if test="#session.s_type==0">
							<td style="text-align: center; border-top: 1px dashed #999;">
							<span
								id="price_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>">动态</span>!<br />

							<span
								id="spdesc_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
								style="display: none"><font
								style="font-size: 14px; font-weight: bold; color: red">★<img
								src="images/tsg.gif" /></font></span></td>

						</ww:if>

						<td
							style="text-align: center; border-top: 1px dashed #999; color: red;">
						<span
							id="totalprice_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
						</td>
						<td
							style="padding-top: 10px; text-align: center;; border-top: 1px dashed #999;">
						<ww:if test="SeatNum.equals(\"9\")">≥9</ww:if><ww:else>
							<ww:property value="SeatNum" />
						</ww:else></td>

						<td style="text-align: center; border-top: 1px dashed #999;">
						
						<ww:if test="AirCompany=='9C'">
					<span><a
						href="javascript:tocreatorder9c(<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>,1)">
					<img src="images/gouml.gif" border="none"
						id="bookimage_<ww:property value="#state.index"/>"
						<ww:if test="LowCarbin.price==0.0">style='display: none;'</ww:if> />
					</a> </span>
					
					</ww:if><ww:else>
						<ww:if test="isBackOrTo==1">
							<a
								href="javascript:gotoBookto(2,<ww:property value="#state.index"/>,<ww:property value="#cabState.index"/>)">
							<img src="images/gouml.gif" border="none"
								id="bookimagecabin_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
								<ww:if test="price==0.0">style='display: none;'</ww:if> /> </a>
						</ww:if> <ww:else>
							<a
								href="javascript:gotoBookback(2,<ww:property value="#state.index"/>,<ww:property value="#cabState.index"/>)">
							<img src="images/gouml.gif" border="none"
								id="bookimagecabin_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
								<ww:if test="price==0.0">style='display: none;'</ww:if> /> </a>
						</ww:else>
						</ww:else>
					</tr>
				</ww:if>
			</ww:iterator>
			<!-- 特价舱位显示结束 -->
			<tr>
				<td colspan="9">
				<div id="air_<ww:property value="#state.index"/>"
					style="display: none;">
				<div style="display: none;"><img
					src="images/jipiao_sanjiao1.gif" style="margin-left: 520px;" /></div>
				<div
					style="border: 1px solid #909090; float: right; margin-top: 0px; width: 1126px;">
				<div style="border: 3px solid #F2F2F2; float: right; width: 1120px;">
				<div style="float: right;"><img style="cursor: pointer"
					onclick="showothercabin(<ww:property value="#state.index"/>)"
					src="images/xx.gif" /></div>

				<table width="1100" border="0">
					<thead>
						<tr style="line-height: 12px;">
							<th width="25%" style="text-align: center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>舱位名称</b></th>
							<th width="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>票面价</b></th>
							<th width="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>销售价</b></th>
							<th class="zratecss" width="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>返点</b></th>
							<th class="zratecss" width="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>佣金</b></th>
							<th class="zratecss" width="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>采购价</b></th>
							<th width="10%">&nbsp;&nbsp;&nbsp;<b>余座</b></th>
							<th width="15%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>操作</b></th>
						</tr>
					</thead>
					<tr>
						<td colspan="8">
						<hr
							style="border-bottom: 1px solid #909090; height: 1px; border-top: none; border-left: none; border-right: none" />
						</td>
					</tr>
					<tbody align="center">
						<ww:iterator value="Carbins" status="cabState">
							<tr>
								<td width="25%"><a href="#">
								<div style="cursor: pointer;"
									onmouseover="showDiag('tgq<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','block')"
									onmouseout="showDiag('tgq<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','none')">
								<ww:if test="Discount<40.0">
									<img src="images/tejia.gif" />
									<br />
								</ww:if> <ww:if test="Discount>=150.0">头等舱</ww:if> <ww:elseif
									test="Discount>=130.0">商务舱</ww:elseif> <ww:elseif
									test="Special">经济舱</ww:elseif> <ww:else>经济舱</ww:else>(<ww:property
									value="cabin" />舱/<ww:if test="Discount>=100.0">
									<ww:if test="Discount==100.0">全价</ww:if>
									<ww:else>
										<ww:property value="Discount/10" />折</ww:else>
								</ww:if> <ww:else>
									<span
										id="zhe_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"><ww:property
										value="Discount/10" /></span>折</ww:else>)

								<div style="position: relative; z-index: 9999999999999;">
								<div
									id="tgq<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
									style="display: none; position: absolute; z-index: 9999999999999999999; left: 0px; width: 225px; background: #fff; text-align: center; line-height: 20px;"
									class="box">
								<div
									style="background: #F2F9F3; border-bottom: 1px dashed #bed5e7; text-indent: 20px; height: 24px; line-height: 24px;"><b>退改签信息</b></div>

								<div
									style="padding: 5px; height: 128px; text-align: left; z-index: 99999"><ww:property
									value="CabinRules" /></div>
								</div>
								</div>

								</div>
								</a></td>



								<!-- 票面价 -->
								<td width="10%"><ww:if test="Price==0.0">
									<a
										href="javascript:lodprice('<ww:property value="Airline" />','<ww:property value="cabin" />','<ww:property value="StartAirport" />,<ww:property value="EndAirport" />','<ww:property value="flightSearch.FromDate" />','<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>');">
									<div
										id="t<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
										style="color: red;"><img src="images/spbutton.gif" /></div>
									</a>
									<span style="display: none;"
										id="lowprice2_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
								</ww:if> <ww:else>
									￥
									<ww:property value="Price" />

								</ww:else></td>
								<!-- 销售价 -->
								<td width="10%"><ww:property value="Price+AirportFee+FuelFee" /></td>

								<!-- 返点信息 -->
								<td width="10%" class="zratecss" style="line-height: 10px;"><input
									type='hidden'
									id='hidfromcitycode_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
									value='<ww:property value="StartAirport" />' /> <input
									type='hidden'
									id='hidtocitycode_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
									value='<ww:property value="EndAirport" />' /> <input
									type='hidden'
									id='hidfromdate_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
									value='<ww:property value="formatTimestamp2(DepartTime)" />' />
								<input type='hidden'
									id='hidaircompany_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
									value='<ww:property value="AirCompany" />' /> <input
									type='hidden'
									id='hidflightnumber_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
									value='<ww:property value="getAirLineNumber(Airline)" />' /> <input
									type='hidden'
									id='hidcabincode_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
									value='<ww:property value="cabin" />' /> <input type='hidden'
									id='hidz_price_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>'
									value='<ww:property value="Price" />' /> <input type="hidden"
									id="hidairportfee_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
									value="<ww:property value="AirportFee"/>" /> <input
									type="hidden"
									id="hidfuelfee_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
									value="<ww:property value="FuelFee"/>" />
									
									<font style="font-size: 12px; font-weight: bold;"> 
									<span style="display: block"
										id="discount_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
									</font>
									

									<!--
									<font style="font-size: 14px; font-weight: bold;"> 
									<span style="display: block; color: red"
										id="discount_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
									</font> 
								
									-->
								<!--
									<font style="font-size: 14px; font-weight: bold;color: red">★<img src="images/tsg.gif" /></font>
									--> <span
									id="spdesc_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"
									style="display: none"><font
									style="font-size: 14px; font-weight: bold; color: red"><img
									src="images/tsg.gif" /></font></span>
								</p>

								</td>

									<!-- 佣金 -->
								<td class="zratecss">
								 <span
									style="display: block; color: red"
									id="rebate_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>
								</td>



								<!-- 采购价 -->
								<td class="zratecss"><span
									id="totalprice_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>"></span>

								<!--
									<h6>买保险+￥10</h6>
									--></td>
								<td><ww:if test="SeatNum.equals(\"9\")">≥9</ww:if><ww:else>
									<ww:property value="SeatNum" />
								</ww:else></td>
								<td><!-- 隐藏域判断价格 -->
								
								<ww:if test="AirCompany=='9C'">
							<span><a
								href="javascript:tocreatorder9c('<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>','1')">
							<img src="images/gouml.gif" border="none"
								id="bookimage_<ww:property value="#state.index"/>"
								<ww:if test="LowCarbin.price==0.0">style='display: none;'</ww:if> />
							</a> </span>
							
							</ww:if><ww:else>
								
									 <ww:if test="isBackOrTo==1">
	
										<a
											href="javascript:gotoBookto(2,<ww:property value="#state.index"/>,<ww:property value="#cabState.index"/>)">
										<img src="images/gouml.gif" border="none"
											id="bookimagecabin_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>" />
										</a>
	
									</ww:if> <ww:else>
	
										<a
											href="javascript:gotoBookback(2,<ww:property value="#state.index"/>,<ww:property value="#cabState.index"/>)">
										<img src="images/gouml.gif" border="none"
											id="bookimagecabin_<ww:property value="#state.index"/>_<ww:property value="#cabState.index"/>" />
										</a>
	
									</ww:else>
								</ww:else>
								
								</td>
							</tr>

							<tr>
								<td colspan="8">
								<hr
									style="border-bottom: 1px dashed #909090; border-top: none; border-left: none; border-right: none; height: 1px;" />
								</td>
							</tr>
							<!-- 隐藏域 -->
					<input type="hidden"
					id='hid_lowprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="price" />' /> 
					
					<input type="hidden"
					id='hid_lowfandian_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="ratevalue"/>' /> 
					
					
					<input type="hidden"
					id='hid_lowdiscount_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Discount" />' /> <input type="hidden"
					id='hid_lowyprice_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="YPrice" />' /> <input type="hidden"
					id='hid_lowseatnum_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="SeatNum" />' /> <input type="hidden"
					id='hid_lowcabincode_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="cabin" />' /> <input type="hidden"
					id='hid_lowdeparttime_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="formatTimestamp(DepartTime)" />' /> <input
					type="hidden"
					id='hid_lowstartairportname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="StartAirportName" />' /> <input
					type="hidden"
					id='hid_lowstartairport_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="StartAirport" />' /> <input
					type="hidden"
					id='hid_lowarrivetime_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="formatTimestamp(ArriveTime)" />' /> <input
					type="hidden"
					id='hid_lowendairportname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="EndAirportName" />' /> <input
					type="hidden"
					id='hid_lowendairport_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="EndAirport" />' /> <input type="hidden"
					id='hid_lowflightnumber_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="Airline" />' /> <input type="hidden"
					id='hid_lowaircompany_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirCompany" />' /> <input type="hidden"
					id='hid_lowaircompanyname_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="getAirCompanyNameByCode(AirCompanyName)" />' />
				<input type="hidden"
					id='hid_lowflighttype_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirplaneType" />' /> <input
					type="hidden"
					id='hid_lowflightdesc_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirplaneTypeDesc" />' /> <input
					type="hidden"
					id='hid_lowairportfee_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="AirportFee" />' /> <input type="hidden"
					id='hid_lowfuelfee_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="FuelFee" />' /> <input type="hidden"
					id='hid_lowrules_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
					value='<ww:property value="rules" />' />
					<!-- 新增加航站楼 -->
				<input type="hidden"
				id='hid_borderpointat_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='<ww:property value="StartAirportHZL"/>' />
				<input type="hidden"
				id='hid_offpointat_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='<ww:property value="EndAirportHZL"/>' />
					<!-- 新增加政策信息 -->
				<input type="hidden"
				id='hid_zrateid_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
				<input type="hidden"
				id='hid_zratevalue_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='<ww:property value="ratevalue"/>' />
					<!-- 新增加强制保险信息 -->
				<input type="hidden"
				id='hid_qiangzhibaoxian_<ww:property value="#state.index" />_<ww:property value="#cabState.index"/>'
				value='0' />
				
						</ww:iterator>
					</tbody>
				</table>
				<div style="text-align: right; padding-right: 30px;"><!-- 
				<a
					href="#"
					onclick='showothercabin(<ww:property value="#state.index"/>)'
					style="color: #000">收起&nbsp;↑</a>
					 --> <img
					style="color: #06F; text-decoration: none; cursor: pointer"
					onclick="showothercabin(<ww:property value="#state.index"/>);return false;"
					src="images/yccw.gif" /></div>
				</div>
				</div>
				<div class="c" style="height: 10px; line-height: 10px;">&nbsp;</div>
				</div>
				</td>
			</tr>
		</ww:iterator>
	</ww:if>
	<ww:else>
		<tr>
			<td colspan='9' align='center'><font size='4px' color='orange'><img
				src="images/flight_icon.gif" /><b>对不起，未查询到符合您要求的航班，请您稍后重试!</b></font></td>
		</tr>
	</ww:else>
</table>
<div style="height: 1px;"></div>
</div>
<!--航班信息结束--></div>

</div>
<input type="hidden" id="hidtype" value="1" /><!-- 1,单程  2往返  --></div>
<input type="hidden" id="HfFligIndex" name="s_HfFligIndex"
	value="<ww:property value="s_HfFligIndex"/>" /> <input type="hidden"
	id="HfFligIndex2" name="HfFligIndex2"
	value="<ww:property value="HfFligIndex2"/>" /> <input type="hidden"
	id="HfFligID" value="<ww:property value="HfFligID"/>" /> <input
	type="hidden" id="HfCabinid" name="HfCabinid"
	value="<ww:property value="HfCabinid"/>" /> <input type="hidden"
	id="HfCabinid2" name="HfCabinid2"
	value="<ww:property value="HfCabinid2"/>" /> <input type="hidden"
	id="HfCustomerID" /> <input type="hidden" id="hfOrderBy" /></div>
</form>





<form action="#" name="form_cq" id="form_cq" method="post">
<!-- 隐藏域 --> 
 <input type="hidden" id="hidsegmentinfo" value='<ww:property value="s_jasonsegmentinfo" />' name="s_jasonsegmentinfo" />
  
 <input type="hidden" name="s_traveltype" value="<ww:property value="s_traveltype" />" />
 <input type="hidden" name="s_depcityname" value="<ww:property value="s_depcityname" />" />
 <input type="hidden" name="s_depcitycode" value="<ww:property value="s_depcitycode" />" />
 <input type="hidden" name="s_arrcityname" value="<ww:property value="s_arrcityname" />" />
 <input type="hidden" name="s_arrcitycode" value="<ww:property value="s_arrcitycode" />" />
 <input type="hidden" name="s_startdate" value="<ww:property value="s_startdate" />" /> 
 <input type="hidden" name="s_backdate" value="<ww:property value="s_backdate" />" /> 
 <input type="hidden" name="s_aircompanycode" value="<ww:property value="s_aircompanycode" />" /> 
 <input type="hidden" id="hidtravelflag" name="s_travelflag" value="<ww:property value="s_travelflag"/>" /> 
 <input type="hidden" id="hidtraveltype" value='<ww:property value="s_traveltype" />' /> 
 

  <!-- 隐藏域 -->

</form>


</body>
</html>
<script type="text/javascript">    
//单程预订按钮点击
     //返程预订按钮点击
     function gotoBookback(obj,index,cabinid)
     {
     	if($("#hidprice_"+index).val()=='1'){
      alert("特价舱情况复杂，限制条件较多，请联系客服电话0571-88779666确认后预订！");
     	return;
     	}
     	
     	loading('正在查询返程航班');
     	
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
	      document.form1.action="b2bairsearch!tobookback.action";
     	  document.form1.submit();
     }
     //单程预订按钮点击
     function gotoBookto(obj,index,cabinid)
     { 
     	if($("#hidprice_"+index).val()=='1'){
     	 alert("特价舱情况复杂，限制条件较多，请联系客服电话0571-88779666确认后预订！");
     	return;
     	}
    	 loading('正在执行您的操作');
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
	      
	      document.form1.action="b2bairsearch!tocreateorder.action";
     	  document.form1.submit();
      }
    
 function showCabins(flightid) {
      	var cabtr = document.getElementById("air_" + flightid);
      	if (cabtr.style.display == "block") {
      		cabtr.style.display="none";
      	} else {
      		cabtr.style.display="block";
      		
      	}
    }
    function lodprice(hb,cw,ct,tm,index){
			 var flightindex=index.split("_")[0];
			    //getOtherZrate(flightindex,1);
	 			$.ajax({
		            type:"POST",
		            url:"b2bairsearch!getTJprice.action",
		            data:{flightnub:hb,cabincode:cw,citycode:ct,stime:tm},
		            beforeSend:function(){$("#t"+index).html("<img src='images/loadding.gif' />获取特价...")},          
		            success:function(data){
		       
			          if(data=='-1'){
			            // alert("您选择舱位暂无价格信息,请选择其他舱位!!!");
			            $("#t"+index).html("<b>无运价</b>");
			            $("#discount_"+index).html("<b>无运价</b>");
		                $("#rebate_"+index).html("");
		                $("#price_"+index).html("<b>无运价</b>");
		                $("#totalprice_"+index).html("<b>无运价</b>");
			          	}else{
				            var citys=ct.split(',');
				            var aircode=hb.substring(0,2);
				            var flight=hb.substring(2,hb.length);
				            var pr=data.split('|');
				            $("#zhe_"+index).html(pr[1]);
				            $("#t"+index).html(pr[0]);
				             //更新Session中航程的特价舱位价格
		                    changeSessionForSpPrice(index,pr[0],pr[1]);
				            lodpriceByNfd(citys[0],citys[1],tm,aircode,flight,cw,pr[0],index);
			            }
		            }             
		            });
	
	}
    
	function lodpriceTJBYNFD(hb,cw,ct,tm,index){
	
	 alert("特价舱情况复杂，限制条件较多，请联系客服电话0571-88779666确认后预订！");
	 return;
			//document.getElementById("hidindex").value=index;//把下标值放到隐藏域
			    var flightindex=index.split("_")[0];
			    getOtherZrate(flightindex,1);
	 			$.ajax({
		            type:"POST",
		            url:"b2bairsearch!getTJpriceByNFD.action",
		            data:{flightnub:hb,cabincode:cw,citycode:ct,stime:tm},
		            beforeSend:function(){$("#t"+index).html("<img src='images/loadding.gif' />获取特价...")},          
		            success:function(data){
		       
			          if(data=='-1'){
			            // alert("您选择舱位暂无价格信息,请选择其他舱位!!!");
			            $("#t"+index).html("<b>无运价</b>");
			            $("#discount_"+index).html("<b>无运价</b>");
		                $("#rebate_"+index).html("");
		                $("#price_"+index).html("<b>无运价</b>");
		                $("#totalprice_"+index).html("<b>无运价</b>");
			          	}else{
				            var citys=ct.split(',');
				            var aircode=hb.substring(0,2);
				            var flight=hb.substring(2,hb.length);
				            var pr=data.split('|');
				            $("#zhe_"+index).html(pr[1]);
				            $("#t"+index).html(pr[0]);
				             //更新Session中航程的特价舱位价格
		                    changeSessionForSpPrice(index,pr[0],pr[1]);
				            lodpriceByNfd(citys[0],citys[1],tm,aircode,flight,cw,pr[0],index);
			            }
		            }            
		            });
	
	}
	function lodpriceByNfd(s_fromcity,s_tocity,s_fromdate,s_aircompanycode,s_flightnumber,s_cabincode,z_price,index){
	$.ajax({
	         type:"POST",
	         url:"b2bairsearch!findcabinlowBYGaoFan.action",
	         data:{s_fromcity:s_fromcity,s_tocity:s_tocity,s_fromdate:s_fromdate,s_aircompanycode:s_aircompanycode,s_flightnumber:s_flightnumber,s_cabincode:s_cabincode,z_price:z_price},
	          beforeSend:function(){$("#discount_"+index).html("<img src='images/loadding.gif' />")},            
	         success:function(data){
	        
			        if(data.indexOf("|")!=-1)
		            {
		           
		          	  $("#bookimagecabin_"+index).show();
		              $("#discount_"+index).html(data.split('|')[0]);
		              $("#rebate_"+index).html(data.split('|')[2]);
		              $("#price_"+index).html(data.split('|')[1]);
		              $("#totalprice_"+index).html(parseFloat(data.split('|')[1])+parseFloat($("#hidairportfee_"+index).val())+parseFloat($("#hidfuelfee_"+index).val()));
		              $("#totalprice_"+index).html($("#totalprice_"+index).html()+".0");
		             
		            }
		            else
		            {
			            $("#discount_"+index).html("<b>无政策</b>");
		                $("#rebate_"+index).html("");
		                $("#price_"+index).html("<b>无政策</b>");
		            }
		        
	         }            
	         });
	  }
	  function changeSessionForSpPrice(index,spprice,discount)
	  {
	      $.ajax(
	       {
            type:"POST",
            url:"b2bairsearch!AjaxChangeSPPriceSession.action",
            data:{s_HfFligIndex:index,s_spcabinprice:spprice,s_spdiscount:discount},
            beforeSend:function(){},          
            success:function(data)
	        {
	           
	        }            
            }
           );
	  }
	  
	   //提交表单
	  function postdata(action)
	  {
		 
	     document.form_cq.action=action;
	     document.form_cq.method = "POST"; 
         document.form_cq.submit();
	  }
	 function tocreatorder9c(index,traveltype)
	  {


	   
	   
	     //单程预订，跳转到下单页面
	     if(traveltype==1)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo9c(index);
	        //return;
	        //提交表单
	        postdata("b2b9cairticket!toCreateOrder.action");
	     }
	     //往返或者联程,对选中的第一程航班信息进行赋值，并查询第二程航班
	     else if(traveltype==2 && travelflag==1)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo9c(index);
	        $("#hidtravelflag").val("2");
	        //提交表单
	        postdata("b2b9cairticket!toTicketList.action");
	        
	     }
	     else if(traveltype==2 && travelflag==2)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo9c(index);
	        //提交表单
	        //return;
	        postdata("b2b9cairticket!toCreateOrder.action");
	     }
	  }
	  
	   	 //根据选中的航班信息对segmentinfojason对象进行赋值
	  function bindsegmentinfo9c(index)
	  {
	 // alert(index);
	    var JasonString = {"segmentinfos": [    
            {
              "flightnumber": $("#hid_lowflightnumber_"+index).val(),
              "aircomapnycode": $("#hid_lowaircompany_"+index).val(),
              "airname": $("#hid_lowaircompanyname_"+index).val(),
              "airportfee":$("#hid_lowairportfee_"+index).val(),
              "fuelfee":$("#hid_lowfuelfee_"+index).val(),
              "departtime":$("#hid_lowdeparttime_"+index).val(),
              "arrivaltime":$("#hid_lowarrivetime_"+index).val(),
              "cabincode":$("#hid_lowcabincode_"+index).val(),
              "price":$("#hid_lowprice_"+index).val(),
              "discount":$("#hid_lowdiscount_"+index).val(),
              "yprice":$("#hid_lowyprice_"+index).val(),
              "traveltype":"1",
              "isspecial":"",
              "startairport":$("#hid_lowstartairport_"+index).val(),
              "startairportname":$("#hid_lowstartairportname_"+index).val(),
              "endairport":$("#hid_lowendairport_"+index).val(),
              "endairportname":$("#hid_lowendairportname_"+index).val(),
              "rules":$("#hid_lowrules_"+index).val(),
              "ratevalue":"",
              "borderpointat":$("#hid_borderpointat_"+index).val(),
              "offpointat":$("#hid_offpointat_"+index).val(),
              "parvalue":$("#hid_zratevalue_"+index).val(),
              "agentid":"",
              "zrateid":$("#hid_zrateid_"+index).val(),
              "flightdesc":$("#hid_lowflightdesc_"+index).val(),
              "flightmodel":$("#hid_lowflighttype_"+index).val(),
              "qiangzhibaoxian":$("#hid_qiangzhibaoxian_"+index).val()
              }  
            ]};
            
            
            
            //alert(JasonString);
            if($("#hidsegmentinfo").val()!="" && $("#hidsegmentinfo").val().indexOf('@')<0 && $("#hidtravelflag").val()=="2")
            {
              $("#hidsegmentinfo").val($("#hidsegmentinfo").val()+"@"+JSON.stringify(JasonString));
            }
            else
            {
               $("#hidsegmentinfo").val(JSON.stringify(JasonString));
            }
            

	  }
	    
	  <ww:if test="s_type==0">
	   $(".zratecss").show();
	  </ww:if>
	  <ww:if test="s_type==1">
	  $(".zratecss").hide();
	  </ww:if>
	   
	  
</script>
