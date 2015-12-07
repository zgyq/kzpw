 //查询航班信息
	 function search()
	 {

	  var tickettype= $("input:radio[name='TicketType'][checked=true]").val();
	  //判断城市是否空
	  //gaoliang
	 //2011-11-19
	 if($("#txtDepCity").val()==""){  
	 //验证提示
	 $('#txtDepCity').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#txtDepCity").focus();
	 return false; 
	 }
	 if($("#txtArrCity").val()=="" || $("#txtArrCity").val()=="中文/拼音"){
	 //验证提示
	 $('#txtArrCity').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	 $("#txtArrCity").focus();
	 
	 return false; 
	 }
	 
	 
	 
	
	
	   //判断出发时间空否
	    //gaoliang
	 //2011-11-19
	    if($("#txtstartdate").val()==""){
	     
	    	    $('#txtstartdate').poshytip({
				className: 'tip-yellowsimple',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	    
	    return false; 
	    }
	    //判断到达时间是否空 为空选中单程
	    if($("#txtbackdate").val()==""){
	    
	    $("#rdoRoundWay").attr("checked",false);
	    
	    //选中单程
	    $("#rdoOneWay").attr("checked",true);
	    $("#li_returndate").hide();
	    }
	 //判断起始日期大小
	    if(Computation($("#txtstartdate").val(),$("#txtbackdate").val())>0){
	    
	    $("#txtbackdate").focus();
	    
	     return false; 
	    }
	    //遮罩
	    loading("机票信息");

	    //国内机票
	    if(tickettype==0)
	    { 
	       document.form1.action="ticticket!toTicketList.jspx";
	    }
	    //国际机票
	    else if(tickettype==1)
	    {
	    //出发城市三字码
	    var hideFromCityCode=$("#hidDepCity").val();
	    //到达城市三字码
	    var hideArrCityCode=$("#hidArrCity").val();
	    //出发时间
	    var fromTime=$("#txtstartdate").val();
	     //到达时间
	    var returnTime=$("#txtbackdate").val();
	   
	     document.form1.action="international!toInterNationalList.jspx?hideFromCityCode="+hideFromCityCode+"&hideArrCityCode="+hideArrCityCode+"&fromTime="+fromTime+"&returnTime="+returnTime+"&Lvspace="+"1";
	    }
	     document.form1.method = "POST"; 
         document.form1.submit();
         
	 }
	 
	 function loading(context)
	 {
	   //遮罩效果  
        $.blockUI({ message: '<h1><img src="images/loadding.gif" /> 正在查询'+context+',请稍候...</h1>' });
	 }
	