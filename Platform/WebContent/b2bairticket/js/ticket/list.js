   
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
	    loading("航班信息");
	 }
	 //显示、隐藏所有舱位
	 //
	 //2011-11-19
	 function showallcabin(index)
	 {  
	 
	    var show=document.getElementById("linkshowcabin_"+index);
	    var flag=document.getElementById("divallcabininfo_"+index); 
	    
	   // alert(flag.style.display);
	     
	     
	     
	     
	    if(flag.style.display=='none'){
	    flag.style.display ="";
	    show.innerHTML = "隐藏舱位▲";
	    getOtherZrate(index);
	    }else{
	    flag.style.display ="none";
	  // $("#divallcabininfo_"+index).hide();
	    show.innerHTML = "所有舱位▼";
	    }
	   
	   
	 }
	 //时间，价格排序
	 function sort(classname,direction,datatype)
	  {
	      var sortParams =  
			{ 
			  sortOn: classname,
			  direction: direction,
			  sortType: datatype
			}
			$('#div_flightlist').sort(sortParams);
	  }
	  //根据排序条件进行排序
	  function sortflightlist()
	  {
	     var value=$("#ddlsort").val();
	      switch(value)
		   {
		     case "timeasc":
		       sort('.timeOfColnum','asc','string');
		       break;
		     case "timedesc":
		       sort('.timeOfColnum','desc','string');
		       break;
	         case "priceasc":
		       sort('.priceOfColnum','asc','number');
		       break;
		     case "pricedesc":
		       sort('.priceOfColnum','desc','number');
		       break;
			 default:
			     sort('.timeOfColnum','asc','string');
		   }
	  }
	  
	  
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
			    context='<table width="200px" border="0"><tr>';
			    context+='<td><img src="images/NoImage.gif" width="65px" height="65px"  /></td>';
			    context+='<td>'+desc.replace('载客','<br />载客').replace("。","。<br />")+'</td>';
			    context+="</tr></table>";
		    }
		    else
		    {
		        var cont=arrflightdesc[0];
		        context='<table width="200px" border="0"><tr>';
			    context+='<td><img src="images/flighttype/'+arrflightdesc[1]+'" width="65px" height="65px"  /></td>';
			    cont=cont.replace('载客','<br />载客').replace("。","。<br />");
			    context+='<td>'+cont+'</td>';
			    context+="</tr></table>";
		    }
		   
		 }
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
	  //隐藏机型信息说明
	  function hideflightdesc(index)
	  {
	      $('#a_flightdesc_'+index).poshytip('hide');
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
			showOn: 'none',
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

	  
	  //跳转到下单页面或者查询第二程航班信息
	  function tocreatorder(index,traveltype)
	  {






	     
	     //dispose("系统正在为您预定"); 
	     
	     //loadingoverlay("<img src='main_cx/img/loading2.gif' /><br/><span style=''>正在为您查询航班信息，请等待...</span>");
	   
	     var travelflag=$("#hidtravelflag").val();
	       //alert(index+","+traveltype+","+travelflag);
	       
	     //单程预订，跳转到下单页面
	     if(traveltype==1)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo(index);
	        //return;
	        //提交表单
	        postdata("b2bairticket!toCreateOrder.action");
	     }
	     //往返或者联程,对选中的第一程航班信息进行赋值，并查询第二程航班
	     else if(traveltype==2 && travelflag==1)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo(index);
	        $("#hidtravelflag").val("2");
	        //提交表单
	        postdata("b2bairticket!toTicketList.action");
	        
	     }
	     else if(traveltype==2 && travelflag==2)
	     {
	        //对选中的第一程航班信息进行赋值
	        bindsegmentinfo(index);
	        //提交表单
	        //return;
	        postdata("b2bairticket!toCreateOrder.action");
	     }
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
	  
	  //提交表单
	  function postdata(action)
	  {
		 
		 
		 
		 // alert(action);
	  
	 	// return;
	 	 // lodair();
	     //loading("信息");
	     
	     document.form2.action=action;
	     document.form2.method = "POST"; 
         document.form2.submit();
         //<br/><span style=''>正在为您查询航班信息，请等待...</span>
         loadingoverlay("<img src='main_cx/img/loading2.gif' />");
	  }
	  
	  
	  
	  //查询前一天，后一天航班信息
	  function searchotherday(datestr)
	  {
	     $("#txtstartdate").val(datestr);
	     $("#hidotherday").val(datestr);
	     document.form3.action="ticticket!toTicketList.jspx";
	     document.form3.method = "POST"; 
         document.form3.submit();
	  }
	  //根据选中的航班信息对segmentinfojason对象进行赋值
	  function bindsegmentinfo(index)
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
              "traveltype":$("#hidtraveltype").val(),
              "isspecial":$("#hid_laiyuan_"+index).val(),
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
	  //显示查询时间
	  //createtor:
	  //2011-11-18
	  function ajaxsearchyp(){
		 var dstarttime=jQuery("#txtstartdate").val();
		 setDate(dstarttime);
		 
	  } 
	  //获取查询时间
	  //createtor:gaoliang
	  //2011-11-18
	  function datesearch(l){
		  var time=jQuery(l).attr("date");
		  alert(time);
		if(time==''||time==null||time==undefined){
		  time='<ww:property value="txtstartdate"/>';
		}
		jQuery("#txtstartdate").val(time);
		ajaxsearchyp();
	  } 
	  function loading(context)
	 {
	   //遮罩效果  
         $.blockUI({ message: '<h1><img src="images/loadding.gif" /> 正在为你查询'+context+',请稍候...</h1>' });
	 }