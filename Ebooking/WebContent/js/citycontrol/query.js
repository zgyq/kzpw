function query(){

	 //2011-11-19
	 //判断城市是否空
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
	    if($("#txtstartdate").val()=="" || $("#txtstartdate").val()=="往"){
	    
	    $("#txtstartdate").focus(); 
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
	    if($("#txtbackdate").val()=="" || $("#txtbackdate").val()=="返"){
	    
	    $("#rdoRoundWay").attr("checked",false);
	    //选中单程
	    $("#rdoOneWay").attr("checked",true);
	    $("#li_returndate").hide();
	    } 
	 //判断起始日期大小
	  //gaoliang
	 //2011-11-19
	    if(Computation($("#txtstartdate").val(),$("#txtbackdate").val())>0){
	    
	    $("#txtbackdate").focus();
	    
	    $("#txtbackdate").select();
	     return false; 
	    }
	    
	   
	     document.form1.action="ticticket!toTicketList.jspx";
	     document.form1.method = "POST"; 
         document.form1.submit();
	
}
