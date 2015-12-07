<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8" />

<title>${compname}-机票订单页面</title>
<ww:head name="air" jsURL="createorder" />
<link href="js/zipcode/css/Tool.css" rel="stylesheet" type="text/css" />
<script src="js/zipcode/js/Tool.js" type="text/javascript"></script>
<script src="js/zipcode/js/airportaddress.js" type="text/javascript"></script>
<script src="js/citycontrol/header.js" type="text/javascript"></script>
<script src="js/popupplayer/popup_layer.js" type="text/javascript"></script>
<link href="js/popupplayer/css/core.css" rel="stylesheet"
	type="text/css" />

<script type="text/javascript"><!--
    //成人含税费总票价
    var adultpricefee=0;
    var adultpassengerprice=0;
    var adultpassengerairport=0;
    var adultpassengerfuel=0;
    //儿童含税费总票价
    var chilidpricefee=0;
    //婴儿含税费总票价
    var babypricefee=0;
    //儿童票面价
    var childticketprice=0;
    var chlidfuelfee=0;
    //婴儿票面价
    var babyticketprice=0;
    //总乘机人数
    var passengercount=0;
    //全价价格
    var yprice=0;
    //一份保险的价格
    var insuranceprice=20;
    <ww:iterator value="listsegmentinfo">
        adultpassengerprice+=<ww:property value="price" />;
        adultpassengerairport+=<ww:property value="airportfee" />;
        adultpassengerfuel+=<ww:property value="fuelfee" />;
        
        // alert("price:"+<ww:property value="price" />);
        // alert("airportfee:"+<ww:property value="airportfee" />);
        // alert("fuelfee:"+<ww:property value="fuelfee" />);
         
        // alert("adultpassengerprice:"+adultpassengerprice);
       //  alert("adultpassengerairport:"+adultpassengerairport);
       //  alert("adultpassengerfuel:"+adultpassengerfuel);
       //成人总价格(含税费)
      
       //全价价格
       yprice=<ww:property value="yprice" />
       //儿童票面价
       childticketprice=Math.round(yprice/2*0.1)*10
       //儿童燃油费
       chlidfuelfee=parseInt(adultpassengerfuel/2*0.1)*10
       //婴儿票面价
       babyticketprice=Math.round(yprice*0.1*0.1)*10
       //计算儿童价格(含燃油)
       chilidpricefee+=childticketprice+chlidfuelfee
       //计算婴儿价格
       babypricefee+=babyticketprice
       
          
    </ww:iterator>
   
  adultpricefee+=adultpassengerprice+adultpassengerairport+adultpassengerfuel;
   //alert("adultpricefee:"+adultpricefee);
   
    var passengerJsonString='[{ ID: "1",Name:"",Type:"1",Idcardtype:"1",Idcardnumber:"",Insurancenum:"0",Insurancemoney:"'+insuranceprice+'",Ticketprice:"'+adultpassengerprice+'",Airportprice:"'+adultpassengerairport+'",Fuelprice:"'+adultpassengerfuel+'",Totalprice:"'+adultpricefee+'",Issave:"",Customerpassid:"0" }]';
    var passengers=eval(passengerJsonString); 
    //页面加载
    $(document).ready(function()
	   {
	    //返程日期隐藏
	    <ww:if test="s_traveltype==1">
	    $("#txtbackdate").attr("disabled","disabled");
	    </ww:if>
	    <ww:else>
	    $("#txtbackdate").removeAttr("disabled");
	    </ww:else>
	    //默认加载当日日期
	      var d=new Date();
		  var str = d.format('yyyy-MM-dd');  
		  $("#txtsenddate").val(str);
	    //加载城市控件数据
	    $("#txtDepCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidDepCity',onSelect:function(){$("#txtArrCity").click();}, attachObject:'#suggest'});
	    $("#txtArrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidArrCity',onSelect:function(){}, attachObject:'#suggest2'});
	    $("#ticDepCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidDepCity_tic',onSelect:function(){$("#ticArrCity").click();}, attachObject:'#suggest4'});
	    $("#ticArrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hidArrCity_tic',onSelect:function(){}, attachObject:'#suggest5'});
	    $("#txtDepCity").val("北京");
	    $("#hidDepCity").val("PEK");
	    //加载第一个乘机人 
        $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
        accountprice();
        $('#linkadd').poshytip({
			content: "对不起！最多只能添加9个乘机人！",
			showOn: 'none',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'top',
			offsetX: 0,
			offsetY: 5
		  });
		 $('#linkdel').poshytip({
			content: "对不起！此乘机人不能删除！",
			showOn: 'none',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'top',
			offsetX: 0,
			offsetY: 5
		  });
		 //弹出常用地址  //遮罩useOverlay:true
		 new PopupLayer({trigger:"#alink_address",popupBlk:"#blk2",closeBtn:"#close2",
				offsets:{
					x:-500,
					y:-210
				}
			});
	     //弹出常用地址  //遮罩useOverlay:true
		 new PopupLayer({trigger:"#a_address",popupBlk:"#divaddressshow",closeBtn:"#closebtn",
				offsets:{
					x:-185,
					y:-230
				}
			});
	   });
	  //显示机型信息说明
	  function showflightdesc(index)
	  {
	     var context=$("#hid_lowflightdesc_"+index).val();
		 if(context=="")
		 {
		    context="暂无机型信息说明！";
		 }
		 else if(context.indexOf('#')>0)
		 {
		    context=context.replace(",","，").replace("'","，").replace(":","：");
		    var arrflightdesc=context.split('#');
		    
		    if(arrflightdesc[1]=="")
		    {
			    var desc=context;
			    context='<table border="0"><tr>';
			    context+='<td><img src="images/NoImage.gif" width="65px" height="65px"  /></td>';
			    context+='<td>'+desc.replace('载客','<br />载客').replace("。","。<br />")+'</td>';
			    context+="</tr></table>";
		    }
		    else
		    {
		        context='<table border="0"><tr>';
			    context+='<td><img src="images/flighttype/'+arrflightdesc[1]+'" width="65px" height="65px"  /></td>';
			    context+='<td>'+arrflightdesc[0].replace('载客','<br />载客').replace("。","。<br />")+'</td>';
			    context+="</tr></table>";
		    }
		   
		 }
		 
		 //显示机型信息
		 $('#a_flightdesc_'+index).poshytip({
			content: context,
			showOn: 'none',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'bottom',
			offsetX: 0,
			offsetY: 5
		 });
		 $('#a_flightdesc_'+index).poshytip('show');
	  }
	  //常用旅客已经存在提示
      function commonpassexist(index,flag)
      {
            if(flag==1)
            {
	            $('#link_common_pass_'+index).poshytip({
				content: "此乘机人已经存在，请重新选择!",
				showOn: 'none',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			   $('#link_common_pass_'+index).poshytip('show');
		   }
		   else if(flag==2)
		   {
		      $('#link_allcommon_pass_'+index).poshytip({
				content: "此乘机人已经存在，请重新选择!",
				showOn: 'none',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			   $('#link_allcommon_pass_'+index).poshytip('show');
		   }
      }
	  //隐藏机型信息说明
	  function hideflightdesc(index)
	  {
	      $('#a_flightdesc_'+index).poshytip('hide');
	  }
	  function showdetail(id)
	  {
	      var detail_ticketprice=$("#hid_ticketprice_"+id).val();
	      var detail_airportfee=$("#hid_airportprice_"+id).val();
	      var detail_fuelfee=$("#hid_fuelprice_"+id).val();
	      var detail_totalprice=$("#hid_totalprice_"+id).val();
	      var detail_insurnum=$("#ddlinsurance_"+id).val();
	      var detail_insurprice=parseInt($("#ddlinsurance_"+id).val())*parseInt(insuranceprice);
	      var content="<ul><li>票面价："+detail_ticketprice+"元</li><li>燃油费："+detail_fuelfee+"元</li><li>机建费:&nbsp;&nbsp;"+detail_airportfee+"元</li><li>保险费:&nbsp;&nbsp;"+detail_insurprice+"元</li><li><hr size='1px' color='#ccc' /></li><li>总价格："+detail_totalprice+"元</li></ul>";
	      $('#link_detail_'+id).poshytip({
			content: content,
			showOn: 'hover',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'bottom',
			offsetX: 0,
			offsetY: 5
		 });
		 
		 $('#link_detail_'+id).poshytip('show');
	  }
	  function hidedetail(id)
	  {
	    $('#link_detail_'+id).poshytip('hide');
	  }
	  //显示退改签信息说明
	  function showrules(index,context)
	  {
		 if(context=="")
		 {
		    context="更改规则：暂无信息<br />退票规则：暂无信息<br />签转规则：暂无信息<br />";
		 }
		 $('#a_rules_'+index).poshytip({
			content: context,
			showOn: 'hover',
			alignTo: 'target',
			alignX: 'inner-left',
			alignY: 'bottom',
			offsetX: 0,
			offsetY: 5
		 });
		 
		 $('#a_rules_'+index).poshytip('show');
	  }
	  //隐藏退改签信息说明
	  function hiderules(index)
	  {
	      $('#a_rules_'+index).poshytip('hide');
	  }
	  //单程往返类型
	 function bindFlightType(index)
	 {
	    if(index==1)
	    {
	       $("#txtbackdate").attr("disabled","disabled");
	       $("#txtbackdate").val("返");
	    }
	    else if(index==2)
	    {
	       $("#txtbackdate").removeAttr("disabled");
	    }
	 }
	 function clearText(text)
	 {
	     if($("#"+text).val()=="往" || $("#"+text).val()=="返")
	     {
	         $("#"+text).val("");
	     }
	 }
	 //查询航班信息
	 function search()
	 {  
	   query();
	   loading("查询航班信息");
	 }
	 function loading(context)
	 {
	   //遮罩效果  
        $.blockUI({ message: '<h1><img src="images/loadding.gif" /> 正在'+context+',请稍候...</h1>' });
	 }
	 //添加乘机人
	function addpassenger(jsonpassenger)
	{
	   var currentindex=1;
	   var divid=0;
	   $("div[id*='divinformation_']").each(function(i){
             currentindex++;
             var idcur=$(this).attr("id").replace("divinformation_","");
             divid=parseInt(idcur)+1;
             
       });
       if(currentindex>9)
       {
            
		 $('#linkadd').poshytip('enable');
		 $('#linkadd').poshytip('show');
		 return;
       }
	   var currentpassenger=JSON.stringify(passengers);
	   
	   if(jsonpassenger=="")
	   {
		   passengerJsonString="[";
		   passengerJsonString+='{ID: "'+divid+'", Name:"",Type:"1",Idcardtype:"1",Idcardnumber:"",Insurancenum:"0",Insurancemoney:"'+insuranceprice+'",Ticketprice:"'+adultpassengerprice+'",Airportprice:"'+adultpassengerairport+'",Fuelprice:"'+adultpassengerfuel+'",Totalprice:"'+adultpricefee+'" }';
		   passengerJsonString+="]";
		   
		   passengers=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	   }
	   else
	   {
	      passengerJsonString=jsonpassenger.replace("currentindex",divid);
           passengers=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers'); 
	        //判断已有乘机人中是否有姓名为空的，如果有则删除
		      $("div[id*='divinformation_']").each(function(i){
		         var strid=$(this).attr("id");
                 var id=strid.replace("divinformation_","");
	             if($("#txt_name_"+id).val()=="")
	             {
	                  delpassenger(id);
	             }
	          });
	   }
	   
	   accountprice();
	   
	}
	//删除乘机人
	function delpassenger(id)
	{
	   var currentindex=0;
	   $("div[id*='divinformation_']").each(function(i){
             currentindex++;
       });
       if(currentindex==1)
       {
           $('#linkdel').poshytip('enable');
		   $('#linkdel').poshytip('show');
		   return;
       }
       else
       {
	     $("#divinformation_"+id).remove();
	   }
	   accountprice();
	}
	//更改乘机人类型
	function changepassengertype(index)
	{ 
	   var baoxianprice=0;
	   //选择购买保险
       if($("#ddlinsurance_"+index).val()!="0")
        {
           baoxianprice=parseInt($("#ddlinsurance_"+index).val())*insuranceprice;
        }
	   if($("#ddlpassengertype_"+index).val()=="1")
	   {
	      var tprice=parseInt(adultpricefee)+parseInt(baoxianprice);
	      $("#td_priceshow_"+index).html('<font class="font18f60 mlr">&yen;'+tprice+'</font>(<a id=link_detail_'+index+' onmouseout="hidedetail('+index+');" onmouseover="showdetail('+index+');" class="fontun06c" href="javascript:void(0)">含税费</a>) ');
	      $("#hid_ticketprice_"+index).val(adultpassengerprice);
	      $("#hid_airportprice_"+index).val(adultpassengerairport);
	      $("#hid_fuelprice_"+index).val(adultpassengerfuel);
	      $("#hid_totalprice_"+index).val(tprice);
	      
	   }
	   else if($("#ddlpassengertype_"+index).val()=="2")
	   {
	      var tprice=parseInt(chilidpricefee)+parseInt(baoxianprice);
	      $("#td_priceshow_"+index).html('<font class="font18f60 mlr">&yen;'+tprice+'</font>(<a id=link_detail_'+index+' onmouseout="hidedetail('+index+');" onmouseover="showdetail('+index+');" class="fontun06c" href="javascript:void(0)">含税费</a>)');
	      $("#hid_ticketprice_"+index).val(childticketprice);
	      $("#hid_airportprice_"+index).val(0);
	      $("#hid_fuelprice_"+index).val(chlidfuelfee);
	      $("#hid_totalprice_"+index).val(tprice);
	   }
	   else if($("#ddlpassengertype_"+index).val()=="3")
	   {
	     var tprice=parseInt(babypricefee)+parseInt(baoxianprice);
	     $("#td_priceshow_"+index).html('<font class="font18f60 mlr">&yen;'+tprice+'</font>(<a id=link_detail_'+index+' onmouseout="hidedetail('+index+');" onmouseover="showdetail('+index+');" class="fontun06c" href="javascript:void(0)">含税费</a>)');
	     $("#hid_ticketprice_"+index).val(babyticketprice);
	      $("#hid_airportprice_"+index).val(0);
	      $("#hid_fuelprice_"+index).val(0);
	      $("#hid_totalprice_"+index).val(tprice);
	   }
	   accountprice();
	   
	}
	//更改证件类型
	function changeidcardtype(id,passid)
	{
	    $("#txt_idcardnumber_"+id).val("");
	    //取得证件号码
	    $.ajax({
	    type:"GET",
	    url:"ticticket!getPassCredit.jspx",
	    data:{id:passid,idcardtype:$("#ddlidcardtype_"+id).val()},
	    async:false,         
	    success:function(data){
	     $("#txt_idcardnumber_"+id).val(data);
	    }            
	    });
	    //如果是出生日期，则显示日期控件
	    if($("#ddlidcardtype_"+id).val()=="7")
	    {
	       $("#txt_idcardnumber_"+id).bind("focus",function(){
			  WdatePicker({skin:'whyGreen',maxDate:'%y-#{%M}-%d'});
			});
	    }
	    else
	    {
	       $("#txt_idcardnumber_"+id).unbind("focus");
	    }
	    
	}
	//更改保险份数
	function changeinsurance(id)
	{
	   $("#hid_insurance_"+id).val($("#ddlinsurance_"+id).val());
	   $("#hid_insurancenum_"+id).val($("#ddlinsurance_"+id).val());
	   accountprice();
	}
	//显示常用旅客
	function showcommonpassenger()
	{
	   $("#divcommonpassenger").toggle('slow');
	}
	//选中常用旅客
	function setpassenger(index,flag)
	{
	    var jsonstring="";
	    var passexits=0;
	    var passexitsid=0;
	    var existflag=0;
	    var passnames="";
	    var usrname="";
	    var type="";
	    var idcardtype="";
	    var idcardnumber="";
	    $("input[id*='txt_name_']").each(function(i){
             if($(this).val()!="")
             { 
                passnames+=$(this).val()+",";
             }
			             
		});
	    if(flag==1)
	    {
	        var w=0;
		    <ww:iterator value="listcommonpassenger" status="index">
		        var indexselected=<ww:property value="#index.index" />
		        if(indexselected==index)
		        {
		            usrname="<ww:property value="username"/>"
			        type="<ww:property value="type"/>"
			        var passid="<ww:property value="id"/>"
			        idcardtype="<ww:property value="livingcardtype"/>"
			        idcardnumber="<ww:property value="livingcardnum"/>"
		            //判断乘机人是否已经存在
		             if(passnames.indexOf(usrname+",")>=0)
		             {
		                 passexitsid=w;
		                 passexits++;
		             }
			         jsonstring='[{ ID: "currentindex",Name:"'+usrname+'",Type:"'+type+'",Idcardtype:"'+idcardtype+'",Idcardnumber:"'+idcardnumber+'",Insurancenum:"0",Insurancemoney:"'+insuranceprice+'",Ticketprice:"'+adultpassengerprice+'",Airportprice:"'+adultpassengerairport+'",Fuelprice:"'+adultpassengerfuel+'",Totalprice:"'+adultpricefee+'",Issave:"1",Customerpassid:"'+passid+'" }]';
		         }
		         w++
		    </ww:iterator>
	    }
	    else if(flag==2)
	    {
	       var w=0;
	       <ww:iterator value="listallcommonpassenger" status="index">
		        var indexselected=<ww:property value="#index.index" />
		        if(indexselected==index)
		        {
		               //判断乘机人是否已经存在
				        usrname="<ww:property value="username"/>"
				        type="<ww:property value="type"/>"
				        var passid="<ww:property value="id"/>"
				        idcardtype="<ww:property value="livingcardtype"/>"
			            idcardnumber="<ww:property value="livingcardnum"/>"
				        //判断乘机人是否已经存在
			             if(passnames.indexOf(usrname+",")>=0)
			             {
			                 passexitsid=w;
			                 passexits++;
			             }
				       jsonstring='[{ ID: "currentindex",Name:"'+usrname+'",Type:"'+type+'",student_type:"'+idcardtype+'",Idcardnumber:"'+idcardnumber+'",Insurancenum:"0",Insurancemoney:"'+insuranceprice+'",Ticketprice:"'+adultpassengerprice+'",Airportprice:"'+adultpassengerairport+'",Fuelprice:"'+adultpassengerfuel+'",Totalprice:"'+adultpricefee+'",Issave:"1",Customerpassid:"'+passid+'"  }]';
		        }
		        w++;
		    </ww:iterator>
	    }
	    //添加常用旅客
	    if(passexits>0)
        {
            commonpassexist(passexitsid,flag);
            return;
        }
        else
        {
           addpassenger(jsonstring);
        }
        var divid=0;
		   $("div[id*='divinformation_']").each(function(i){
	               var idcur=$(this).attr("id").replace("divinformation_","");
                   divid=parseInt(idcur);
	       });
        //下拉框选中，乘机人类型，证件类型
        $("#ddlpassengertype_"+divid).val(type);
        changepassengertype(divid);
        $("#ddlidcardtype_"+divid).val(idcardtype);
	    
	}
	//计算总价格
	function accountprice()
	{
	    var adultnum=0;
	    var childnum=0;
	    var babynum=0;
	     //总支付金额
        var totalpayprice=0;
	    $("div[id*='divinformation_']").each(function(i){
             passengercount++;
             var strid=$(this).attr("id");
             id=strid.replace("divinformation_","");
             if($("#ddlpassengertype_"+id).val()==1)
             {
                adultnum++;
             }
             else if($("#ddlpassengertype_"+id).val()==2)
             {
                childnum++;
             }
             else if($("#ddlpassengertype_"+id).val()==3)
             {
                babynum++;
             }
             totalpayprice+=parseInt($("#hid_totalprice_"+id).val());
       });
       
       showpriceinfo(adultnum,childnum,babynum,totalpayprice);
	}
	//显示价格信息
	function showpriceinfo(adultnum,childnum,babynum,totalpayprice)
	{
	    $("#span_totalprice").html(totalpayprice);
	    $("#span_passengercount").html(adultnum+childnum+babynum);
	    var detail="";
	    detail+=adultnum+"成人+"+childnum+"儿童+"+babynum+"婴儿";
	    $("#span_passengerdetail").html(detail);
	}
	//验证乘机人信息
	function checkdata(stepindex)
	{
	     var varretrun=true;
         var varretrun1=true;
         var varretrun2=true;
         var varretrun3=true;
         var isrightdate=true;
         var ischilddate=true;
         var isbabydate=true;
         var index="";
         var j="";
         var id="";
	    //对乘机人信息进行验证
        $("input[id*='txt_name_']").each(function(i)
        {
           var strid=$(this).attr("id");
           id=strid.replace("txt_name_","");
           if($(this).val()=="")
           {
               varretrun=false;
               index=i+1;
               j=i;
               
           }
          else
           {
            var regnamecnen=/^[\u4E00-\u9FA5]{1,16}[a-zA-Z]{0,20}[0-9]{0,8}$/; //中文
            var regnameen = /^[a-zA-Z]{1,20}[\/]{1}[a-zA-Z]{1,20}[0-9]{0,8}$/;//英文名
            if(!regnamecnen.exec($(this).val()) && !regnameen.exec($(this).val()))
            {
                varretrun2=false;
                index=i+1;
                    j=i;
            }
           }
        });
        if(varretrun==false)
        {
           $('#txt_name_'+id).poshytip({
                className: 'tip-yellowsimple',
				content:'请填写乘机人姓名！',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
		   $('#txt_name_'+id).poshytip('show');
           $("#txt_name_"+id).focus();
           return false;
        }
        if(varretrun2==false)
        {
            $('#txt_name_'+id).poshytip({
                className: 'tip-yellowsimple',
				content:"请检查英文乘机人姓名格式！<br/>姓名间必须用'/'符号分隔<br/>姓在前名在后,如'Bill/Gates'请重新输入！",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
           $("#txt_name_"+id).focus();
             return false;
        }
         //证件号
         var strEmpty="";
         $("input[id*='txt_idcardnumber_']").each(function(i)
           {
             var strid=$(this).attr("id");
             id=strid.replace("txt_idcardnumber_","");
            if($(this).val()=="")
            {
               varretrun=false;
               index=i+1;
               j=i;
            }else if($(this).val().length>20){
            	varretrun3=false;
               index=i+1;
               j=i;
            }else
                 {
                    strEmpty=$(this).val();
                 }
              });
              if(varretrun)
              {
                $("select[id*='ddlidcardtype_']").each(function(i)
                {
                    if($("#ddlidcardtype_"+id).val()=="1")
                    {
                        if(!shenfen($("#txt_idcardnumber_"+id).val()))
                        {
                            varretrun1=false;
                            index=i+1;
                            j=i;
                        }
                    }
                    else if($("#ddlidcardtype_"+id).val()=="7")
                    {
                        if(!IsDate($("#txt_idcardnumber_"+id).val()))
                        {
                           isrightdate=false;
                           index=i+1;
                           j=i;
                        }
                        else if($("#ddlpassengertype_"+id).val()=="2" && (DateDiff('2011-12-04',$("#txt_idcardnumber_"+id).val())>4380 || DateDiff('2011-12-04',$("#txt_idcardnumber_"+id).val())<2*365))
                        {
                           ischilddate=false;
                           index=i+1;
                           j=i;
                        }
                        else if($("#ddlpassengertype_"+id).val()=="3" && (DateDiff('2011-12-04',$("#txt_idcardnumber_"+id).val())>=2*365))
                        {
                           isbabydate=false;
                           index=i+1;
                           j=i;
                        }
                    }
                });
              }
              if(varretrun==false)
              {
                  $('#txt_idcardnumber_'+id).poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写乘机人证件号码！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txt_idcardnumber_"+id).focus();
                   return false;
              }
              if(varretrun3==false){
              	 $('#txt_idcardnumber_'+id).poshytip({
	                className: 'tip-yellowsimple',
					content:"乘机人证件号不能大于20！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txt_idcardnumber_"+id).focus();
                   return false;
              }
              if(varretrun1==false)
              {
                  $('#txt_idcardnumber_'+id).poshytip({
	                className: 'tip-yellowsimple',
					content:"请检查乘机人证件号码格式是否正确！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txt_idcardnumber_"+id).focus();
                   return false;
              }
              else if(isrightdate==false)
              {
                 $('#txt_idcardnumber_'+id).poshytip({
	                className: 'tip-yellowsimple',
					content:"请输入乘机人正确的出生日期！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txt_idcardnumber_"+id).focus();
                   return false;
              }
              else if(ischilddate==false)
              {
                   alert("儿童年龄应该是2-12岁！");
                   $("#txt_idcardnumber_"+id).focus();
                   return false;
              }
              else if(isbabydate==false)
              {
                    alert("婴儿年龄应该是0-2岁！");
                   $("#txt_idcardnumber_"+id).focus();
                   return false;
              }
              //验证联系人信息
              if(IsEmpty($("#txtcontactname").val()))
              {
                  $('#txtcontactname').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写联系人姓名！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txtcontactname").focus();
                   return false;
              }
              //联系人手机号码
              if(IsEmpty($("#txtcontactmobile").val()))
              {
                  $('#txtcontactmobile').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写联系人手机号码！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txtcontactmobile").focus();
                   return false;
              }
              else
              {
                   if(!IsMobile($("#txtcontactmobile").val()))
                   {
                       $('#txtcontactmobile').poshytip({
		                className: 'tip-yellowsimple',
						content:"请检查联系人手机号码是否正确！",
						showOn: 'focus',
						alignTo: 'target',
						alignX: 'right',
						alignY: 'center',
						offsetX: 5
					    });
	                   $("#txtcontactmobile").focus();
	                   return false;
                   }
              }
        if(stepindex=="1")
        {
          nextstep();
        }
        else if(stepindex=="2")
        {
           //验证配送方式
           //邮寄行程单
           var item =$("input[name='s_sendtickettype']:checked").val();
           if(item=="2")
           {
           if(IsEmpty($("#txtpostname").val()))
              {
                  $('#txtpostname').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写收件人姓名！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txtpostname").focus();
                   return false;
              }
              //收件人手机号码
              if(IsEmpty($("#txtpostmobile").val()))
              {
                  $('#txtpostmobile').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写收件人手机号码！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txtpostmobile").focus();
                   return false;
              }
              else
              {
                   if(!IsMobile($("#txtpostmobile").val()))
                   {
                       $('#txtpostmobile').poshytip({
		                className: 'tip-yellowsimple',
						content:"请检查收件人手机号码是否正确！",
						showOn: 'focus',
						alignTo: 'target',
						alignX: 'right',
						alignY: 'center',
						offsetX: 5
					    });
	                   $("#txtpostmobile").focus();
	                   return false;
                   }
              }
              //邮寄省市
              if(IsEmpty($("#txtZip").val()))
              {
                  $('#txtZip').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写邮寄省市！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txtZip").focus();
                   return false;
              }
              //邮政编码
              if(IsEmpty($("#Zipresult").val()))
              {
                  $('#Zipresult').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写邮政编码！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#Zipresult").focus();
                   return false;
              }
              else
              {
                   if(!IsPostalCode($("#Zipresult").val()))
                   {
                       $('#Zipresult').poshytip({
		                className: 'tip-yellowsimple',
						content:"请检查邮政编码是否正确！",
						showOn: 'focus',
						alignTo: 'target',
						alignX: 'right',
						alignY: 'center',
						offsetX: 5
					    });
	                   $("#Zipresult").focus();
	                   return false;
                   }
              }
              //邮寄地址
              if(IsEmpty($("#txtpostaddress").val()))
              {
                  $('#txtpostaddress').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写邮寄地址！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txtpostaddress").focus();
                   return false;
              }
            }
            //市内配送
           else if(item=="4")
           {
              //配送地址
              if(IsEmpty($("#txtsendaddress").val()))
              {
                  $('#txtsendaddress').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写配送地址！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txtsendaddress").focus();
                   return false;
              }
              //配送日期
              if(IsEmpty($("#txtsenddate").val()))
              {
                  $('#txtsenddate').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写配送日期！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txtsenddate").focus();
                   return false;
              }
           }
           loading("创建订单信息");
           document.form2.action="ticticket!createorder.jspx";
	       document.form2.method = "POST"; 
           document.form2.submit();
        }
	    
	}
	//下一步操作
	function nextstep()
	{
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
	   $("div[id*='divinformation_']").each(function(i){
	        var strid=$(this).attr("id");
            id=strid.replace("divinformation_","");
            name=$("#txt_name_"+id).val();
            type=$("#ddlpassengertype_"+id).val();
            idcardtype=$("#ddlidcardtype_"+id).val();
            idcardnumber=$("#txt_idcardnumber_"+id).val();
            insurancenum=$("#ddlinsurance_"+id).val();
            insurancetotalprice=parseInt(insurancenum)*insuranceprice;
            ticketprice=$("#hid_ticketprice_"+id).val();
            airportprice=$("#hid_airportprice_"+id).val();
            fuelprice=$("#hid_fuelprice_"+id).val();
            totalprice=$("#hid_totalprice_"+id).val();
            if($("#chbissave_"+id).attr("checked")==true){
               issave=1;
            }
            else
            {
               issave=0;
            }
            jsonstring+='{ ID: "currentindex",Name:"'+name+'",Type:"'+type+'",Idcardtype:"'+idcardtype+'",Idcardnumber:"'+idcardnumber+'",Insurancenum:"'+insurancenum+'",Insurancemoney:"'+insurancetotalprice+'",Ticketprice:"'+ticketprice+'",Airportprice:"'+airportprice+'",Fuelprice:"'+fuelprice+'",Totalprice:"'+totalprice+'",Issave:"'+issave+'" },';
            
            $("#hidallpassengers").val("");
       });
       jsonstring+="]";
       jsonstring=jsonstring.replace(",]","]");
       $("#hidallpassengers").val(jsonstring);
       
       //预览页面
       $("#statusimage").addClass("r statuscheck");
       $("#divpassenger_title").hide();
       $("#showpaymethodflag").val("1");
       if($("#rdolijichupiao").attr("checked"))
       {
	       $("#tr_songpiaomethod").show();
           $("#tr_paymethod").show();
       }
       
       $("#divpassengers").hide();
       $("#divpassengersshow").show();
       $("#divpassengersshow").html($("#divpassengersshow_temp").html().replace("passengershowTemplate_temp","passengershowTemplate"));
       var passengersshow=eval(jsonstring); 
       $('#passengershowTemplate').tmpl(passengersshow).appendTo('#divpassengersshow');
       $("#btnnextstep").hide();
       $("#btnprevstep").show();
       $("#btnsubmit").show();
       $("li[id*='li_ptypeshow_']").each(function(i)
        {
            if($(this).html()=="旅客类型：1")
            {
                $(this).html("旅客类型：成人");
            }
            else if($(this).html()=="旅客类型：2")
            {
                $(this).html("旅客类型：儿童");
            }
            else if($(this).html()=="旅客类型：3")
            {
                $(this).html("旅客类型：婴儿");
            }
        });
        
        $("span[id*='li_pidtypeshow_']").each(function(i)
        {
            if($(this).html()=="1")
            {
                $(this).html("身份证");
            }
            else if($(this).html()=="2")
            {
                $(this).html("护照");
            }
            else if($(this).html()=="3")
            {
                $(this).html("港澳通行证");
            }
            else if($(this).html()=="4")
            {
                $(this).html("台湾通行证");
            }
            else if($(this).html()=="5")
            {
                $(this).html("台胞证");
            }
            else if($(this).html()=="6")
            {
                $(this).html("回乡证");
            }
            else if($(this).html()=="7")
            {
                $(this).html("出生日期");
            }
        });
       
       
	}	 
	function prevstep()
	{
	   $("#btnnextstep").show();
       $("#btnprevstep").hide();
       $("#btnsubmit").hide();
       $("#divpassenger_title").show();
       $("#divpassengers").show();
       $("#tr_songpiaomethod").hide();
       $("#tr_paymethod").hide();
       $("#divpassengersshow").hide();
       $("#statusimage").removeClass("r statuscheck");
       $("#statusimage").addClass("r status");
       $("#showpaymethodflag").val("0");
	}
	function showpaymethod()
	{
	    if($("#showpaymethodflag").val()=="1")
	    {
	        $("#tr_songpiaomethod").show();
	        $("#tr_paymethod").show();
	    }
	}
	function hidepaymethod()
	{
	    if($("#showpaymethodflag").val()=="1")
	    {
	        $("#tr_songpiaomethod").hide();
	        $("#tr_paymethod").hide();
	    }
	}
	function showaddress(id)
	{
	   //隐藏所有地址
	   $("tr[id*='tr_addressinfo_']").each(function(i)
        {
          $(this).hide();
        });
	   if(id!="")
	   {
	     $("#"+id).show();
	   }
	   //加载机场自取信息
	   if(id=="tr_addressinfo_airport")
	   {
	       var address="";
	       var index=0;
	       for(var i=0;i<airportaddress.length;i++)
	       {
	          
	          var addressinfo=airportaddress[i];
	          <ww:iterator value="listsegmentinfo">
	           var startairport='<ww:property value="startairport" />'
	           var endairport='<ww:property value="endairport" />'
		          if(addressinfo.code==startairport || addressinfo.code==endairport)
		          {
		              index++;
		              address+="<p><b>"+index+"."+addressinfo.name+"</b></p>";
		              address+="<p>"+addressinfo.address+"("+addressinfo.time+")</p>";
		          }
	          </ww:iterator>
	       }
	       $("#td_ziquaddress").html(address);
	   }
	}
	//绑定邮寄地址
	function bindaddress(id)
	{ 
	    $("#txtpostname").val($("#hidaddress_name_"+id).val());
	    $("#txtpostmobile").val($("#hidaddress_mobile_"+id).val());
	    $("#txtZip").val($("#hidaddress_province_"+id).val());
	    $("#Zipresult").val($("#hidaddress_zipcode_"+id).val());
	    $("#txtpostaddress").val($("#hidaddress_address_"+id).val());
	    $("#close2").click();
	}
	//绑定配送地址
	function bindpsaddress(id)
	{ 
	    $("#txtsendaddress").val($("#hidpsaddress_address_"+id).val());
	    $("#closebtn").click();
	}
--></script>
</head>
<body>
<ww:i18n name="'language'">
<div>
	
		<ww:include page="../top.jsp?index=1&subindex=1" />
	
	<!--top over-->
	<div id="main">
	<div id="left" class="f">
	<form name="form1" id="form1" method="post">
	<div class="search"><font class="black">国内机票搜索</font></div>
	<div class="box_sea searchlist">
	<ul>
		<li class="choose"><input name="s_traveltype" id="rdoOneWay"
			type="radio" value="1"
			<ww:if test="s_traveltype==1">checked="checked"</ww:if>
			onclick="bindFlightType(1);" /> <span class="mr15"> <ww:text
			name="'OneWay'" /></span> <input name="s_traveltype" id="rdoRoundWay"
			type="radio" value="2"
			<ww:if test="s_traveltype==2">checked="checked"</ww:if>
			onclick="bindFlightType(2);" /> <ww:text name="'Return'" /></li>
		<li class="searchall"><ww:text name="'DepartureCity'" />：<input
			type="text" id="txtDepCity" name="s_depcityname" class="text_search"
			value="<ww:property value='s_depcityname' />" title="请输入出发城市" />
		<div id='suggest' class="ac_results"></div>
		<input type="hidden" id="hidDepCity" name="s_depcitycode"
			value="<ww:property value='s_depcitycode'/>" /></li>
		<li class="searchall"><ww:text name="'ArrivalCity'" />：<input
			type="text" id="txtArrCity" name="s_arrcityname" class="text_search"
			value="<ww:property value='s_arrcityname' />" title="请输入到达城市" />
		<div id='suggest2' class="ac_results"></div>
		<input type="hidden" id="hidArrCity" name="s_arrcitycode"
			value="<ww:property value='s_arrcitycode' />" /></li>
		<li class="searchall"><ww:text name="'DepartureTime'" />：<input
			type="text" id="txtstartdate" name="s_startdate"
			onfocus="clearText('txtstartdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="text_searchwf"
			value='<ww:if test='s_startdate!=null && !s_startdate.equals("")'><ww:property value="s_startdate" /></ww:if><ww:else>往</ww:else>'
			title="请输入出发时间" /> <input type="text" name="s_backdate"
			id="txtbackdate"
			onfocus="clearText('txtbackdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			class="text_searchwf"
			value='<ww:if test='s_backdate!=null && !s_backdate.equals("")'><ww:property value="s_backdate" /></ww:if><ww:else>返</ww:else>' />
		</li>
		<li class="searchall">航空公司：<select name="" class="sel_search">
			<option value="">---所有航空公司---</option>
			<ww:iterator value="listAirCompany">
				<option value="<ww:property value='aircomcode' />"><ww:property
					value="aircomcode" /><ww:property value="aircomcnname" /></option>
			</ww:iterator>
		</select></li>
		<li class="but" style=" height:40px; padding:5px 0; text-align:center;">
			<!-- <span class="f">搜索最优的机票，<br />就上${compname}。</span> -->
			<span><input type="button" class="bst" value="立即搜索" id="btnsearch" onclick="search();" /></span>
			<div class="c"></div>
		</li>
	</ul>
	</div>
	</form>
	<!-- <div class="searchbot"></div> -->
	<div class="tit mt7" style=" border:1px solid #E3E3E3; border-bottom:none;">
		<font class="black" style=" padding-left:10px;"><ww:property value="GetInfoTypeNameById(typeid)" /></font>
	</div>
	<div class="box content" style=" border-top:none;">
	<ul>
		<ww:iterator value="Listhelpcenterinfo">
			<li title="<ww:property value="name" />"><a
				href="index!toHelpInfo.jspx?HelpcenterID=<ww:property value="typeid"/>&HelpcenterinfoID=<ww:property value="id"/>">
			<ww:if test="name.length()>16">
				<ww:property value="SubString(name,14)" />...
			</ww:if><ww:else>
				<ww:property value="name" />
			</ww:else> </a></li>
		</ww:iterator>
	</ul>
	</div>
	<!--
	<div class="ad mt7"><img src="images/ad_ticket_01.jpg" width="260" height="100" /></div>
	--></div>
	<!--left over-->
	<form id="form2" name="form2">
	<div id="order" class="r">
	<div class="guild">
	<ul>
		<li class="current f"></li>
		<li class="f font20">填写机票预订单</li>
		<li class="r status" id="statusimage">&nbsp;</li>
		<li class="c"></li>
	</ul>
	</div>

	<div class="msg mt7"><ww:iterator value="listsegmentinfo"
		status="index">
		<ul class="msgul">
			<li class="over box_over"><b>已选择的<ww:if
				test="s_traveltype==2 && #index.index==0">去程</ww:if><ww:elseif
				test="s_traveltype==2 && #index.index==1">返程</ww:elseif><ww:elseif
				test="s_traveltype==3 && #index.index==0">第一程</ww:elseif><ww:elseif
				test="s_traveltype==3 && #index.index==1">第二程</ww:elseif>航班</b><span
				class="mlr15"><ww:property value="s_depcityname" />→ <ww:property
				value="s_arrcityname" /></span>出发日期：<ww:property
				value="formatTimestampyyyyMMdd(departtime)" /></li>
			<li>
			<ul class="range">
				<li class="overmorny f"><font class="font18f60">&yen;<ww:property
					value="formatMoneyToInt(price)" /></font><span class="mlr"><ww:if
					test="discount>=150.0">头等舱</ww:if> <ww:elseif
					test="discount>=130.0">商务舱</ww:elseif> <ww:elseif test="isspecial">特价经济舱</ww:elseif>
				<ww:else>经济舱</ww:else><ww:property value="cabincode" />
				<!-- <ww:property value="ratevalue" /><ww:property value="zrateid" /> -->
				
				</span></li>
				<li class="f airport">
				<dt><ww:property value="formatTimestampHHmm(departtime)" /> <ww:property
					value="getAirportbySZM(startairport)" /><span style="color: red">(<ww:property value="borderpointat"/>)</span></dt>
				<dt><ww:property value="formatTimestampHHmm(arrivaltime)" /> <ww:property
					value="getAirportbySZM(endairport)" /><span style="color: red">(<ww:property value="offpointat"/>)</span></dt>
				</li>
				<li class="f airlines airlines_mu"></li>
				<li class="f model">
				<dt><ww:property value="airname" /><ww:property
					value="flightnumber" /></dt>
				<dt>空客<a id="a_flightdesc_<ww:property value="#index.index" />"
					href="javascript:void(0);" class="fontun06c"
					onmouseout="hideflightdesc('<ww:property value="#index.index" />');"
					; onmouseover="showflightdesc('<ww:property value="#index.index" />','<ww:property value="flightdesc" />');"
					class="fontun06c"><ww:property value="flightmodel" /></a><ww:property
					value="getFlightModel(flightmodel)" /> <input type="hidden"
					id="hid_lowflightdesc_<ww:property value="#index.index" />"
					value="<ww:property value="flightdesc" />" /></dt>
				</li>
				<li class="f fuel"><ww:property
					value="formatMoneyToInt(airportfee)" />/<ww:property
					value="formatMoneyToInt(fuelfee)" /></li>
				<li class="f meal"><a
					id="a_rules_<ww:property value="#index.index" />"
					href="javascript:void(0);" class="fontun06c"
					onmouseout="hiderules('<ww:property value="#index.index" />');"
					; onmouseover="showrules('<ww:property value="#index.index" />','<ww:property value="rules" />');"
					class="fontun06c">退改签规则</a>
				<div class="float msg_l" style="display: none">
				<ul class="msgul_l">
					<li class="over box_over_l">退改签规则</li>
					<li class="pf5"><b>更改条件：</b>起飞前2小时以外同等舱位更改需收取票面价20%</li>
					<li class="pf5"><b>退票条件：</b></li>
					<li class="pf5"><b>签转条件：</b></li>
				</ul>
				</div>
				</li>
				<li class="f btn"><input type="button" class="bnt_modify fff"
					value="修&nbsp;改" /></li>
			</ul>
			</li>
		</ul>
	</ww:iterator></div>
	<!--往返订单第一程信息--> <!--往返订单第二程信息-->
	<div class="mt7 box">
	<div class="tit"><font class="black low2 f mr15">乘客信息</font> <font
		class="c999">乘客信息 —
	请准确填写姓名、证件号等信息，港澳旅客请填证件上的英文名，格式：FirstName/LastName。</font></div>
	<div class="number" id="divpassenger_title">
	<ul>
		<li class="f mr15"><a id="linkadd" href="javascript:void(0)"
			onclick='addpassenger("");' class="fontun06c">添加1位乘客</a></li>
		<li class="f floatall">常用乘机人： <ww:iterator
			value="listcommonpassenger" status="state">
			<span class="mr15"><a class="commonpassenger"
				id="link_common_pass_<ww:property value="#state.index" />"
				href="javascript:void(0)"
				onclick='setpassenger("<ww:property value="#state.index" />",1);'
				class="un000"><ww:property value="username" /></a></span>
		</ww:iterator> <ww:if test="listallcommonpassenger.size()>0">
			<a href="javascript:void(0)" onclick="showcommonpassenger();"
				class="fontun06c">更多>></a>
		</ww:if>

		<div class="people msg" style="display: none" id="divcommonpassenger">
		<ul class="msgul">
			<ww:iterator value="listallcommonpassenger" status="state">
				<span class="mlr15"><a
					id="link_allcommon_pass_<ww:property value="#state.index" />"
					href="javascript:void(0)"
					onclick='setpassenger("<ww:property value="#state.index" />",2);'
					class="un000"><ww:property value="username" /></a></span>
			</ww:iterator>

		</ul>
		</div>
		<!--更多联系人--></li>
		<li class="r save">保存到常用乘机人</li>
		<li class="c"></li>
	</ul>
	</div>
	<!-- 填写乘机人信息 start -->
	<div id="divpassengers"><script id="passengerTemplate" type="text/x-jquery-tmpl"> 
	<div class="information" id="divinformation_\${ID}">
	<table width="100%" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td class="hadow" align="right" width="11%"><font
				class="fontxing">*</font> 姓 名：</td>
			<td width="13%" ><input type="text"
				class="text_name" id="txt_name_\${ID}" value="\${Name}" /></td>
			<td class="hadow" align="right" width="11%"><font
				class="fontxing">*</font> 旅客类型：</td>
			<td width="11%"><select class="sel_type" id="ddlpassengertype_\${ID}" onchange="changepassengertype(\${ID})">
				<option value="1">成人</option>
			</select></td>
			<td class="hadow" align="right" width="11%"><font
				class="fontxing">*</font> 证件类型：</td>
			<td width="11%" ><select class="sel_documents" style="width:70px" onchange="changeidcardtype(\${ID},\${Customerpassid})" id="ddlidcardtype_\${ID}">
				<option value="1">身份证</option>
				<option value="2">护照</option>
				<option value="3">港澳通行证</option>
				<option value="4">台湾通行证</option>
				<option value="5">台胞证</option>
				<option value="6">回乡证</option>
                <option value="7">出生日期</option>
			</select></td>
			<td width="20%" ><input type="text" id="txt_idcardnumber_\${ID}"
				class="text_number" value="\${Idcardnumber}" /></td>
			<td class="hadow" ><input type="checkbox" id="chbissave_\${ID}" checked="checked" /><span class="fontun06c">保存乘客</span></td>
		</tr>
		<tr>
			<td class="hadow" align="right">
			<div class="floatall"><a href="#"><span class="insurance">保险</span></a>：
			<div class="msg informations" style="display: none;">
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
			<td><select class="sel_fraction" id="ddlinsurance_\${ID}" onchange="changepassengertype(\${ID});changeinsurance(\${ID});">
                <option value="0">0</option>				
                <option value="1">1</option>
				<option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
			</select>￥20/份</td>
			<td colspan="2" id="td_priceshow_\${ID}"><font class="font18f60 mlr">&yen;\${Totalprice}</font>(<a id="link_detail_\${ID}" onmouseout="hidedetail('\${ID}');" onmouseover="showdetail('\${ID}');" class="fontun06c" href="#">含税费</a>)&nbsp;&nbsp;</td>
			<td colspan="3">&nbsp;
             <input type="hidden" id="hid_ticketprice_\${ID}" value="\${Ticketprice}" />
             <input type="hidden" id="hid_airportprice_\${ID}" value="\${Airportprice}" />
             <input type="hidden" id="hid_fuelprice_\${ID}" value="\${Fuelprice}" />
             <input type="hidden" id="hid_totalprice_\${ID}" value="\${Totalprice}" />
             <input type="hidden" id="hid_insurance_\${ID}" value="\${Insurancemoney}" />
             <input type="hidden" id="hid_insurancenum_\${ID}" value="\${Insurancenum}" />
            </td>
			<td class="hadow"><span class="del_people">&nbsp;</span><a id="linkdel" href="javascript:void(0)" onclick="delpassenger(\${ID});" class="fontun06c">删除乘客</a></td>
		</tr>
	</table>
	<div class="nohave"></div>
	</div>
     </script></div>
	<div id="divpassengersshow"><script id="passengershowTemplate"
		type="text/x-jquery-tmpl"> 
	 <ul class="msgul lh34">
           <li class="f mlr15">姓  名：\${Name}</li>
           <li class="f mlr15" id="li_ptypeshow_\${ID}">旅客类型：\${Type}</li>
           <li class="f mlr15">证件类型：<span class="mlr15" id="li_pidtypeshow_\${ID}">\${Idcardtype}</span>\${Idcardnumber}</li>
           <li class="f mlr15">保险份数：\${Insurancenum}份</li>
           <li class="c"></li>
     </ul>
    </script></div>
	<div id="divpassengersshow_temp" style="display: none"><script
		id="passengershowTemplate_temp" type="text/x-jquery-tmpl"> 
	 <ul class="msgul lh34">
           <li class="f mlr15">姓  名：\${Name}</li>
           <li class="f mlr15" id="li_ptypeshow_\${ID}">旅客类型：\${Type}</li>
           <li class="f mlr15">证件类型：<span class="mlr15" id="li_pidtypeshow_\${ID}">\${Idcardtype}</span>\${Idcardnumber}</li>
           <li class="f mlr15">保险份数：\${Insurancenum}份</li>
           <li class="c"></li>
     </ul>
    </script></div>
	</div>
	<!-- 填写乘机人信息 start --> <!--------乘客信息over--------->
	<div class="mt7 box">
	<div class="tit"><font class="black low2 f mr15">联系人信息</font> <font
		class="c999"> — 请准确填写联系人信息（姓名，手机号码），以便我们与您联系。 </font></div>
	<div class="information_order">
	<div class="nohave"></div>
	<div class="f contact">
	<table width="100%" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<td class="hadow" align="right" width="20%"><font
				class="fontxing">*</font>&nbsp;联系人姓名：</td>
			<td><input type="text" id="txtcontactname" name="s_contactname"
				value="<ww:property value="s_contactname" />" class="text_number" /><font
				class="c999 mlr15">请正确填写您的姓名，以便确认您的预订服务。</font></td>
		</tr>
		<tr>
			<td class="hadow" align="right"><font class="fontxing">*</font>&nbsp;手
			机：</td>
			<td><input type="text" class="text_number" id="txtcontactmobile"
				value="<ww:property value="s_contactmobile" />"
				name="s_contactmobile" /><font class="c999 mlr15">请正确填写您的手机号，以便确认您的预订服务。</font></td>
		</tr>
		<tr style="display: none">
			<td class="hadow" align="right">邮 箱：</td>
			<td><input type="text" class="text_number" id="txtcontactemail"
				value="<ww:property value="s_contactemail" />" name="s_contactemail" /><font
				class="c999 mlr15">请正确填写您的邮箱，以便确认您。</font></td>
		</tr>
		<tr>
			<td class="hadow" align="right">确认方式：</td>
			<td><select id="ddlcontacttype" class="sel_typed"
				name="s_contacttype">
				<option value="1">不用确认</option>
				<option value="2">手机短消息确认</option>
				<option value="3">电话确认</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="2" class="nohave"
				style="height: 10px; line-height: 10px">&nbsp;</td>
		</tr>
		<tr>
			<td class="hadow" align="right">出票方式：</td>
			<td><input name="s_rrtickettype" id="rdolijichupiao"
				type="radio" onclick="showpaymethod();" value="1" checked="checked" />直接出票
			<input name="s_rrtickettype" id="rdozanhuanchupiao" type="radio"
				onclick="hidepaymethod();" value="2" />先不出票（航空公司可能随时取消机位或涨价） <input
				type="hidden" id="showpaymethodflag" value="0" /></td>
		</tr>
		<tr style="display: none" id="tr_paymethod">
			<td class="hadow" align="right">支付方式：</td>
			<td><input name="s_paymethod" id="rdoonlinepay" type="radio"
				value="1" checked="checked" />在线支付<!--
				 <input name="s_paymethod" id="rdocashpay" type="radio" value="3" />现金
				--></td>
		</tr>
		<tr style="display: none" id="tr_songpiaomethod">
			<td class="hadow" align="right">送票方式：</td>
			<td><input name="s_sendtickettype" id="rdobuxuyao" type="radio"
				onclick="showaddress('');" value="1" checked="checked" />不需要行程单<!--
				 <input
				name="s_sendtickettype" id="rdoyouji" type="radio"
				onclick="showaddress('tr_addressinfo_post');" value="2" />邮寄行程单 <input
				name="s_sendtickettype" id="rdojichangziqu" type="radio"
				onclick="showaddress('tr_addressinfo_airport');" value="3" />机场自取 <input
				name="s_sendtickettype" id="rdoshineipeisong" type="radio"
				onclick="showaddress('tr_addressinfo_city');" value="4" />市内配送 <input
				name="s_sendtickettype" id="rdomenshiziqu" type="radio"
				onclick="showaddress('tr_addressinfo_dept');" value="5" />门市自取
				--></td>
		</tr>
		<!-- 邮寄行程单 -->
		<tr style="display: none" id="tr_addressinfo_post">
			<td colspan="2">
			<div class="noticket msg">
			<ul class="msgul">
				<table border="0" width="100%">
					<tr>
						<td width="19%" align="right"><font class="fontxing">*</font>&nbsp;收件人姓名：</td>
						<td><input class="text_number" type="text" id="txtpostname"
							name="s_postname" value="" /></td>
						<td width="20%" align="right"><font class="fontxing">*</font>&nbsp;收件人手机号：</td>
						<td><input class="text_number" id="txtpostmobile"
							name="s_postmobile" type="text" value="" />&nbsp; <a
							href="javascript:void(0)" class="fontun06c" id="alink_address">常用地址</a></td>
					</tr>
					<tr>
						<td width="19%" align="right"><font class="fontxing">*</font>&nbsp;邮寄省市：
						</td>
						<td><input type="text" class="text_number
							name="
							s_postprovince" id="txtZip" />
						<div id="show"></div>
						</td>
						<td align="right"><font class="fontxing">*</font>&nbsp;邮政编码：</td>
						<td colspan="3"><input class="text_number" type="text"
							value="" name="s_postzipcode" id="Zipresult" />&nbsp; <a
							href="javascript:void(0)" class="fontun06c" id="btnZip">查询邮编</a>
						</td>
					</tr>
					<tr>
						<td align="right"><font class="fontxing">*</font>&nbsp;邮寄地址：</td>
						<td colspan="3"><input class="text_number"
							id="txtpostaddress" name="s_postaddress" style="width: 400px"
							type="text" value="" /></td>
					</tr>


				</table>
			</ul>
			<div id="blk2" class="blk" style="display: none;">

			<div class="head">
			<div class="head-right"></div>
			</div>

			<div class="main">
			<h2>请选择您的常用邮寄地址.</h2>
			<a href="javascript:void(0)" id="close2" class="closeBtn">关闭</a>
			<ul>
				<ww:iterator value="listaddress" status="index">
					<li><a href="javascript:void(0)"
						onclick="bindaddress(<ww:property value="#index.index" />);">
					<ww:property value="#index.index+1" />.<ww:property
						value="address" /> &nbsp;&nbsp;&nbsp;<ww:property value="name" />
					</a> <input type="hidden"
						id="hidaddress_name_<ww:property value="#index.index" />"
						value="<ww:property value="name" />" /> <input type="hidden"
						id="hidaddress_address_<ww:property value="#index.index" />"
						value="<ww:property value="address" />" /> <input type="hidden"
						id="hidaddress_mobile_<ww:property value="#index.index" />"
						value="<ww:property value="mobile" />" /> <input type="hidden"
						id="hidaddress_zipcode_<ww:property value="#index.index" />"
						value="<ww:property value="postalcode" />" /> <input
						type="hidden"
						id="hidaddress_province_<ww:property value="#index.index" />"
						value="<ww:property value="province" />" /></li>
					<li></li>
					<li></li>
				</ww:iterator>
			</ul>
			</div>

			<div class="foot">
			<div class="foot-right"></div>
			</div>

			</div>

			</div>

			</td>
		</tr>
		<!-- 邮寄行程单 -->
		<!-- 机场自取 -->
		<tr style="display: none" id="tr_addressinfo_airport">
			<td colspan="2">
			<div class="noticket msg">
			<ul class="msgul">
				<table border="0" width="100%">
					<tr>
						<td align="right" width="20%">自取地址：</td>
						<td colspan="3" id="td_ziquaddress" style="padding: 5px">
						暂无机场地址信息，请咨询客服热线：010-68176515!</td>
					</tr>

				</table>
			</ul>
			</div>

			</td>
		</tr>
		<!-- 机场自取 -->
		<!-- 市内配送 -->
		<tr style="display: none" id="tr_addressinfo_city">
			<td colspan="2">
			<div class="noticket msg">
			<ul class="msgul">
				<table border="0" width="100%">
					<tr>
						<td align="right" width="20%">配送城市：</td>
						<td>本市配送 &nbsp;&nbsp;&nbsp;<a href="javascript:void(0);"
							class="fontun06c" id="a_address">选择常用送票地址</a></td>
					</tr>
					<tr>
						<td align="right" width="20%"><font class="fontxing">*</font>&nbsp;配送地址：</td>
						<td><input type="text" class="text_name" id="txtsendaddress"
							name="s_sendaddress" style="width: 300px" value="" /></td>
					</tr>
					<tr>
						<td align="right" width="20%"><font class="fontxing">*</font>&nbsp;配送时间：</td>
						<td><input type="text" class="text_number"
							onfocus="clearText('txtstartdate');WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
							id="txtsenddate" name="s_senddate" value="" /> <select
							id="txtsendtime" class="sel_documents" name="s_sendtime">
							<option value="16:30">16:30</option>
							<option value="17:30">17:30</option>
							<option value="18:30">18:30</option>
							<option value="19:30">19:30</option>
							<option value="20:30">20:30</option>
						</select> 以后 <select id="txtsendhour" class="sel_documents"
							name="s_sendhour">
							<option value="1">1小时</option>
							<option value="2">2小时</option>
							<option value="3">3小时</option>
							<option value="4">4小时</option>
						</select> 内送达</td>
					</tr>

				</table>
			</ul>
			<div id="divaddressshow" class="blk" style="display: none;">

			<div class="head">
			<div class="head-right"></div>
			</div>

			<div class="main">
			<h2>请选择您的常用配送地址.</h2>
			<a href="javascript:void(0)" id="closebtn" class="closeBtn">关闭</a>
			<ul>
				<ww:iterator value="listaddress" status="index">
					<li><a href="javascript:void(0)"
						onclick="bindpsaddress(<ww:property value="#index.index" />);">
					<ww:property value="#index.index+1" />.<ww:property
						value="address" /> &nbsp;&nbsp;&nbsp;<ww:property value="name" />
					</a> <input type="hidden"
						id="hidpsaddress_address_<ww:property value="#index.index" />"
						value="<ww:property value="address" />" /></li>
					<li></li>
					<li></li>
				</ww:iterator>
			</ul>
			</div>

			<div class="foot">
			<div class="foot-right"></div>
			</div>

			</div>
			</div>

			</td>
		</tr>
		<!-- 市内配送 -->
		<!-- 门市自取 -->
		<tr style="display: none" id="tr_addressinfo_dept">
			<td colspan="2">
			<div class="noticket msg">
			<ul class="msgul">
				<table border="0" width="100%">
					<tr>
						<td align="right" width="20%">自取城市：</td>
						<td>本市自取</td>
					</tr>
					<tr>
						<td align="right" width="20%"><font class="fontxing">*</font>&nbsp;自取地址：</td>
						<td><input type="radio" name="s_ziquaddress"
							checked="checked" value="北京市东城区东中街40号元嘉国际中心A座3层303室" />
						北京市东城区东中街40号元嘉国际中心A座3层303室<br />
						<input type="radio" name="s_ziquaddress"
							value="海淀区花园北路44号贯通大厦B501室（北医三院南门对面）" />海淀区花园北路44号贯通大厦B501室（北医三院南门对面）
						</td>
					</tr>

				</table>
			</ul>
			</div>

			</td>
		</tr>
		<!-- 门市自取 -->
	</table>
	</div>
	<div class="r total">
	<ul>
		<li class="mlr15">人数/价格（含税费）</li>
		<li class="nohave"></li>
		<li class="mlr15 lh27">总价：<font class="font18f60 mlr">&yen;<span
			id="span_totalprice"></span></font></li>
		<li class="mlr15 lh27">人数：<font class="font18f60 mlr"><span
			id="span_passengercount"></span>人</font></li>
		<li class="mlr15 lh27"><span id="span_passengerdetail"></span></li>
	</ul>
	</div>
	<div class="c"></div>
	<div class="nohave"></div>
	</div>
	</div>
	<!----------联系人信息------------>
	<div class="bnt">
		<input type="button" class="bnt_previous2 mr25 cfff" value="上一步" id="btnprevstep" style="display: none" onclick="prevstep();" />
		<input type="button" class="bnt_next2 mlr15 cfff" id="btnnextstep" value="下一步" onclick="checkdata(1);" />
		<input type="button" class="bnt_next2 mlr15 cfff" id="btnsubmit" style="display: none" value="提交订单" onclick="checkdata(2);" /></div>
	<input type="hidden" id="hidallpassengers" name="s_jsonpassengers"
		value="" /> <input type="hidden" id="hidsegmentinfo"
		value='<ww:property value="s_jasonsegmentinfo" />'
		name="s_jasonsegmentinfo" /></div>
	</form>
	</div>

	<!-- 地图 -->
	<form action="index!ToMap.jspx" name="form4" id="form4" method="post"
		target="_blank"><input name="s_remarks" value=""
		id="hidaddress" type="hidden" /></form>

	<!--right over-->
	<!--container over-->
	<ww:include page="../footer.jsp" />
</ww:i18n>
</body>

</html>
<script>
document.onclick = hideTip;
function hideTip(e){
	var src = e?e.target:event.srcElement;
	do{
		if(src.id =="linkadd" || src.id =="linkdel" || $(src).attr("class")=="commonpassenger" || $(src).attr("class")=="text_name"  ) return;
		src = src.parentNode;
	}while(src.parentNode)
	$('#linkadd').poshytip('hide');
	$('#linkdel').poshytip('hide');
	$("a[id*='link_common_pass_']").each(function(i){
             $(this).poshytip('hide');
       });
    $("a[id*='link_allcommon_pass_']").each(function(i){
             $(this).poshytip('hide');
       });
    
	

}

</script>
<script>
	function lodMap(address){
	return;
	document.getElementById("hidaddress").value=address;
	document.form4.submit();
	}
</script>