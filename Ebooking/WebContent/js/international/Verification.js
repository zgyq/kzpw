
 //单选按钮控制日期显隐
 function radioSelect(id){
   if(id==1){
     $("#lireturnTime").hide();
   }else{
     $("#lireturnTime").show();
   }
 }

function checkBotton(){

	
   //判断出发城市为空
    if($("#fromCity").val()=="" || $("#fromCity").val()=="中文/拼音"){  
	 //验证提示
	 alert("??");
	 $('#fromCity').poshytip({
				content: "请选择出发城市",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#fromCity").focus();
	 return false; 
	 }
	//判断到达城市为空
    if($("#arrCity").val()=="" ||$("#arrCity").val()=="中文/拼音"){  
	 //验证提示
	 $('#arrCity').poshytip({
				content: "请选择到达城市",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#arrCity").focus();
	 return false; 
	 }
	 //判断出发时间空否

	    if($("#fromTime").val()==""){
	     
	    	    $('#fromTime').poshytip({
				content: '请选择出发时间',
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	     $("#fromTime").focus();
	    $("#fromTime").select();
	    return false; 
	    }
	 //判断起始日期大小
	    if(Computation($("#fromTime").val(),$("#returnTime").val())>0){
	    $('#returnTime').poshytip({
				content: "日期选择错误,请重新选择!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	    $("#returnTime").focus();
	    $("#returnTime").select();
	     return false; 
	    } 
 //判断返程日期是否为空 为空选中单程
    if($("#returnTime").val()==null || $("#returnTime").val()==""){
         $("#radioTwo").attr("checked",false); 
         $("#radioOne").attr("checked",true);
	    $("#lireturnTime").hide();
    }
      //遮罩
	 loading("国际机票信息");
     document.form1.action="international!toInterNationalList.jspx";
     document.form1.method = "POST"; 
     document.form1.submit(); 
 }
   function loading(context)
	 {
	   //遮罩效果  
        $.blockUI({ message: '<h1><img src="images/loadding.gif" /> 正在为你查询'+context+',请稍候...</h1>' });
	 }