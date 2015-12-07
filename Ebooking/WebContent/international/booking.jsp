<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-订单填写</title>
<ww:head name="inter" jsURL="interorder" />
<script src="/Ebooking/js/jason/json2.js" type="text/javascript"></script>
<script src="/Ebooking/js/jason/jquery.tmpl.js" type="text/javascript"></script>
<script type="text/javascript">
     var passengerJsonString='[{ ID:"1",Name:"",Type:"1",student_type:"1",sex_type:"1",Nationality:"",Docment:"",Country:"",Number:"",BirthDate:"",Period:"",issave:"1" }]';
     var users=eval(passengerJsonString); 
 
 $(document).ready(function()
  {
   $("#fromCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hideFromCityCode',onSelect:function(){$("#arrCity").click();}, attachObject:'#suggest'});
	    $("#arrCity").suggest(citys,{hot_list:commoncitys,dataContainer:'#hideArrCityCode',onSelect:function(){}, attachObject:'#suggest2'});
  
   //加载第一个乘机人    
   //注释：加载在城市插件后边才能显示，在前边回出错
   $('#passengerTemplate').tmpl(users).appendTo('#divpassengers');
   accountprice();
  });
  	
  //添加联系人
  function addPeople(jsonpassenger){
   var currentindex=1;
	   var divid=0;//计算一共有几个table
	   $("table[id*='table_name_']").each(function(i){
             currentindex++;
             var idcur=$(this).attr("id").replace("table_name_","");
             divid=parseInt(idcur)+1;
       });
     if(divid>9){
       alert("联系人最多添加9个");
        return false;
     }
     
       var currentpassenger=JSON.stringify(users);
      if(jsonpassenger=="")
	   {
	   passengerJsonString="[";
	   passengerJsonString+='{ ID:"'+divid+'",Name:"",Type:"1",student_type:"0",sex_type:"1",Nationality:"",Docment:"",Country:"",Number:"",BirthDate:"",Period:"",issave:"1" }';
       passengerJsonString+="]";
            users=eval(passengerJsonString);
	        $('#passengerTemplate').tmpl(users).appendTo('#divpassengers'); 
       
	   }
	   else
	   {
	      passengerJsonString=jsonpassenger.replace("currentindex",divid);
           users=eval(passengerJsonString); 
	       $('#passengerTemplate').tmpl(users).appendTo('#divpassengers'); 
	        //判断已有乘机人中是否有姓名为空的，如果有则删除
		      $("table[id*='table_name_']").each(function(i){
		         var strid=$(this).attr("id");
                 var id=strid.replace("table_name_","");
	             if($("#txt_name_"+id).val()=="")
	             {
	                  delPeople(id);
	             }
	          });
	   }
     
    accountprice();   
       
  }
  
  //删除联系人
  function delPeople(id){
   var currentindex=0;
    $("table[id*='table_name_']").each(function(i){
             currentindex++;
       });
       if(currentindex==1){
       alert("只有一个联系人不能删除!");
       return;
       }else{
        $("#table_name_"+id).remove();
       }
       accountprice();
       
      
  } 
 //点击下一步隐藏添加 显示添加结果
 function hideAddProple(){
  var varretrun=true;
         var varretrun1=true;
         var varretrun2=true;
         var guoji1=true;
         var qianfaguo=true;
         var chusheng=true;
         var youxiaoqi=true;
         var isrightdate=true;
         var ischilddate=true;
         var isbabydate=true;
         var index="";
         var j="";
         var id="";
//验证乘机人
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
         $("input[id*='txt_Number_']").each(function(i)
           {
             var strid=$(this).attr("id");
             id=strid.replace("txt_Number_","");
            if($(this).val()=="")
            {
               varretrun=false;
               index=i+1;
               j=i;
            }
                 else
                 {
                    strEmpty=$(this).val();
                 }
              });
              if(varretrun)
              {
                $("select[id*='txt_Docment_']").each(function(i)
                {
                    if($("#txt_Docment_"+id).val()=="1")
                    {
                        if(!shenfen($("#txt_Number_"+id).val()))
                        {
                            varretrun1=false;
                            index=i+1;
                            j=i;
                        }
                    }
                    else if($("#txt_Docment_"+id).val()=="7")
                    {
                        if(!IsDate($("#txt_Number_"+id).val()))
                        {
                           isrightdate=false;
                           index=i+1;
                           j=i;
                        }
                        else if($("#txt_Docment_"+id).val()=="2" && (DateDiff('2011-12-04',$("#txt_Number_"+id).val())>4380 || DateDiff('2011-12-04',$("#txt_Number_"+id).val())<2*365))
                        {
                           ischilddate=false;
                           index=i+1;
                           j=i;
                        }
                        else if($("#txt_Docment_"+id).val()=="3" && (DateDiff('2011-12-04',$("#txt_Number_"+id).val())>=2*365))
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
                  $('#txt_Number_'+id).poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写乘机人证件号码！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txt_Number_"+id).focus();
                   return false;
              }
              if(varretrun1==false)
              {
                  $('#txt_Number_'+id).poshytip({
	                className: 'tip-yellowsimple',
					content:"请检查乘机人证件号码格式是否正确！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txt_Number_"+id).focus();
                   return false;
              }
       //出生日期验证       
         $("input[id*='txt_BirthDate_']").each(function(i)
           {
           
            var strid=$(this).attr("id");
           id=strid.replace("txt_BirthDate_","");
           if($(this).val()=="")
           {
               chusheng=false;
               index=i+1;
               j=i;
               
           }
           
            });
           if(chusheng==false){
           if(IsEmpty($("#txt_BirthDate_"+id).val()))
              {
                  $('#txt_BirthDate_'+id).poshytip({
	                className: 'tip-yellowsimple',
					content:"请选择出生日期！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txt_BirthDate_"+id).focus();
                   return false;
              }
           } 
       
        //有效期验证       
         $("input[id*='txt_Period_']").each(function(i)
           {
           
            var strid=$(this).attr("id");
           id=strid.replace("txt_Period_","");
           if($(this).val()=="")
           {
               youxiaoqi=false;
               index=i+1;
               j=i;
               
           }
           
            });
           if(youxiaoqi==false){
           if(IsEmpty($("#txt_Period_"+id).val()))
              {
                  $('#txt_Period_'+id).poshytip({
	                className: 'tip-yellowsimple',
					content:"请选择证件有效期！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#txt_Period_"+id).focus();
                   return false;
              }
           } 
           
 
         //验证联系人信息
   if(IsEmpty($("#Contact").val()))
              {
                  $('#Contact').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写联系人姓名！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#Contact").focus();
                   return false;
              }
    //联系人手机号码
              if(IsEmpty($("#MobilPhone").val()))
              {
                  $('#MobilPhone').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写联系人手机号码！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#MobilPhone").focus();
                   return false;
              }
              else
              {
                   if(!IsMobile($("#MobilPhone").val()))
                   {
                       $('#MobilPhone').poshytip({
		                className: 'tip-yellowsimple',
						content:"请检查联系人手机号码是否正确！",
						showOn: 'focus',
						alignTo: 'target',
						alignX: 'right',
						alignY: 'center',
						offsetX: 5
					    });
	                   $("#MobilPhone").focus();
	                   return false;
                   }
              }           
     
     //验证邮箱
              if(IsEmpty($("#Email").val()))
              {
                  $('#Email').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写邮箱！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#Email").focus();
                   return false;
              }
              else
              {
                   if(!IsEMail($("#Email").val()))
                   {
                       $('#Email').poshytip({
		                className: 'tip-yellowsimple',
						content:"请检查邮箱是否正确！",
						showOn: 'focus',
						alignTo: 'target',
						alignX: 'right',
						alignY: 'center',
						offsetX: 5
					    });
	                   $("#Email").focus();
	                   return false;
                   }
              }     
             
//--------------------------------------------       
 var currentindex=0;
 var issave=0;
    $("#titleinfo").hide();
    $("#divpassengers").hide();
    $("#peopleinfo").show();
    $("#hideaddpeople").hide();
    $("#tijiao").show();
 //***********************开始循环table中的内容 *******************************
      $("table[id*='table_name_']").each(function(i){
             currentindex++;
             var idcur=$(this).attr("id").replace("table_name_","");
       //获取乘机人信息开始
        var name=$("#txt_name_"+idcur).val(); //姓名
        var txt_type= $("#passenger_type_"+idcur).val(); //乘客类型
        var student=$("#student_type_"+idcur).val(); //是否留学生
        var sex=$("#sex_type_"+idcur).val();//性别
        var Nationality=$("#txt_Nationality_"+idcur).val();//国籍
        var Docment=$("#txt_Docment_"+idcur).val();//证件类型
        var Country=$("#txt_Country_"+idcur).val();//证件签发国
        var Number =$("#txt_Number_"+idcur).val();//证件号码
        var BirthDate=$("#txt_BirthDate_"+idcur).val();//生日
        var Period=$("#txt_Period_"+idcur).val();//证件有效期  
         if($("#chbissave_"+idcur).attr("checked")==true){
               issave=1;
            }
            else
            {
               issave=0;
            }
       //获取结束
       //开始赋值到 页面
       var peopleJsonString='[{ ID:"'+idcur+'",Name:"'+name+'",Type:"'+txt_type+'",student_type:"'+student+'",sex_type:"'+sex+'",Nationality:"'+Nationality+'",Docment:"'+Docment+'",Country:"'+Country+'",Number:"'+Number+'",BirthDate:"'+BirthDate+'",Period:"'+Period+'",issave:"'+issave+'" }]';         
        var user=eval(peopleJsonString);  
	        $('#overinfo').tmpl(user).appendTo('#peopleinfo');
        $("td[id*='td_Type_']").each(function(i)
        {
            if($(this).html()=="1")
            {
                $(this).html("成人");
            }
            else if($(this).html()=="2")
            {
                $(this).html("儿童");
            }
            else if($(this).html()=="3")
            {
                $(this).html("婴儿");
            }
        });
        
        $("td[id*='td_Docment_']").each(function(i)
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
        
        //性别
         $("td[id*='td_sex_']").each(function(i)
        {
            if($(this).html()=="1")
            {
                $(this).html("男");
            }
            else if($(this).html()=="2")
            {
                $(this).html("女");
            }
        });
        
         //是否是留学生
         $("td[id*='td_stu_']").each(function(i)
        {
            if($(this).html()=="0")
            {
                $(this).html("是");
            }
            else if($(this).html()=="1")
            {
                $(this).html("否");
            }
        });
        
       });
 //***********************循环table中的内容 end*******************************       

 } 
 
 //点击上一步显示添加 隐藏信息显示
 function showAddPeople(){
 var currentindex=0;
    $("#peopleinfo").hide();
    $("#titleinfo").show();
    $("#divpassengers").show();
    $("#hideaddpeople").show();
    $("#tijiao").hide();
 //删除下一步显示页面乘客信息   
    $("tr[id*='tr_name_']").each(function(i){
             currentindex++;
             $("#tr_name_"+currentindex).remove();
       });
      
             
 }
 
// 提交订单
function commitOrder(){
   //验证联系人信息
   if(IsEmpty($("#Contact").val()))
              {
                  $('#Contact').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写联系人姓名！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#Contact").focus();
                   return false;
              }
    //联系人手机号码
              if(IsEmpty($("#MobilPhone").val()))
              {
                  $('#MobilPhone').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写联系人手机号码！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#MobilPhone").focus();
                   return false;
              }
              else
              {
                   if(!IsMobile($("#MobilPhone").val()))
                   {
                       $('#MobilPhone').poshytip({
		                className: 'tip-yellowsimple',
						content:"请检查联系人手机号码是否正确！",
						showOn: 'focus',
						alignTo: 'target',
						alignX: 'right',
						alignY: 'center',
						offsetX: 5
					    });
	                   $("#MobilPhone").focus();
	                   return false;
                   }
              }           
     
     //验证邮箱
              if(IsEmpty($("#Email").val()))
              {
                  $('#Email').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写邮箱！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#Email").focus();
                   return false;
              }
              else
              {
                   if(!IsEMail($("#Email").val()))
                   {
                       $('#Email').poshytip({
		                className: 'tip-yellowsimple',
						content:"请检查邮箱是否正确！",
						showOn: 'focus',
						alignTo: 'target',
						alignX: 'right',
						alignY: 'center',
						offsetX: 5
					    });
	                   $("#Email").focus();
	                   return false;
                   }
              }                 
//******************************下单内容************************              
 var jsonString="[";
 var issave=0;
  //***********************开始循环table中的内容 *******************************
      $("table[id*='table_name_']").each(function(i){
             
             var idcur=$(this).attr("id").replace("table_name_","");
       //获取乘机人信息开始
        var name=$("#txt_name_"+idcur).val(); //姓名
        var txt_type= $("#passenger_type_"+idcur).val(); //乘客类型
        var student=$("#student_type_"+idcur).val(); //是否留学生
        var sex=$("#sex_type_"+idcur).val();//性别
        var Nationality=$("#txt_Nationality_"+idcur).val();//国籍
        var Docment=$("#txt_Docment_"+idcur).val();//证件类型
        var Country=$("#txt_Country_"+idcur).val();//证件签发国
        var Number =$("#txt_Number_"+idcur).val();//证件号码
        var BirthDate=$("#txt_BirthDate_"+idcur).val();//生日
        var Period=$("#txt_Period_"+idcur).val();//证件有效期  
         if($("#chbissave_"+idcur).attr("checked")==true){
               issave=1;
            }
            else
            {
               issave=0;
            }
       //获取结束
       //开始赋值到 页面
       jsonString+='{ ID:"'+idcur+'",Name:"'+name+'",Type:"'+txt_type+'",student_type:"'+student+'",sex_type:"'+sex+'",Nationality:"'+Nationality+'",Docment:"'+Docment+'",Country:"'+Country+'",Number:"'+Number+'",BirthDate:"'+BirthDate+'",Period:"'+Period+'",Issave:"'+issave+'"},';
                  
       });
       jsonString+="]" 
       jsonString=jsonString.replace(",]","]");
 //***********************循环table中的内容 end*******************************  
     $("#commitorder").val(jsonString);
     
      document.formorder.action="international!createOrder.jspx";
	  document.formorder.method = "POST"; 
      document.formorder.submit();
     
     
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
	    var Period="";
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
			        Period="<ww:property value="livingperiod"/>"
		            //判断乘机人是否已经存在
		             if(passnames.indexOf(usrname+",")>=0)
		             {
		                 passexitsid=w;
		                 passexits++;
		             }
	                  jsonstring='[{ ID:"currentindex",Name:"'+usrname+'",Type:"'+type+'",student_type:"'+idcardtype+'",sex_type:"1",Nationality:"",Docment:"'+idcardtype+'",Country:"",Number:"'+idcardnumber+'",BirthDate:"",Period:"'+Period+'",Issave:"1",Customerpassid:"'+passid+'"}]';	        
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
			            Period="<ww:property value="livingperiod"/>"
				        //判断乘机人是否已经存在
			             if(passnames.indexOf(usrname+",")>=0)
			             {
			                 passexitsid=w;
			                 passexits++;
			             }
				     
	 jsonstring='[{ ID:"currentindex",Name:"'+usrname+'",Type:"'+type+'",student_type:"'+type+'",sex_type:"1",Nationality:"",Docment:"'+idcardtype+'",Country:"",Number:"'+idcardnumber+'",BirthDate:"",Period:"'+Period+'",Issave:"1",Customerpassid:"'+passid+'" }]';	        	      
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
           addPeople(jsonstring);
        }
        var divid=0;
		   $("table[id*='table_name_']").each(function(i){
	               var idcur=$(this).attr("id").replace("table_name_","");
                   divid=parseInt(idcur);
	       });
        //下拉框选中，乘机人类型，证件类型
        $("#passenger_type_"+divid).val(type);
        //changepassengertype(divid);
        $("#txt_Docment_"+divid).val(idcardtype);
        $("#txt_Period_"+divid).val(Period);
	    
	}
	
//常用旅客已经存在提示
      function commonpassexist(index,flag)
      {
            if(flag==1)
            {
	            alert("此乘机人已经存在，请重新选择!");
		   }
		   else if(flag==2)
		   {
		      alert("此乘机人已经存在，请重新选择!");
		   }
      }	
      
 	//计算总价格
	function accountprice()
	{
	    var adultnum=0;
	    var childnum=0;
	     //总支付金额
        var totalprice=0;
        var totalpayprice=0;
        var childprice=0;
        var stax=0;
	    $("table[id*='table_name_']").each(function(i){
             var strid=$(this).attr("id");
             id=strid.replace("table_name_","");
             if($("#passenger_type_"+id).val()==1)
             {
                adultnum++;
             }
             else if($("#passenger_type_"+id).val()==2)
             {
                childnum++;
             }
       });
     totalprice=$("#TotalFare").val();
     childprice=$("#childTotalFare").val();
     stax=$("#s_tax").val();
   totalpayprice=(totalprice*adultnum)+(childprice*childnum)+(adultnum+childnum)*stax;
     var sreing=adultnum+"成人×￥"+totalprice+"+"+childnum+"儿童×￥"+childprice+"+"+(adultnum+childnum)+"税费×￥"+stax;
     $("#priceTitle").html("￥"+totalpayprice);
     $("#fontPrice").html(sreing);
     $("#TotalPrice").attr("value",totalpayprice);
	}
    	
</script>
</head>

<body>
<div>
	<div class="cen" style="position: relative;">
	<ww:include page="../top.jsp?index=1&subindex=2" />
	</div>
	</div>

<div class="nohave">&nbsp;</div>
<div id="list">
<div class="f left">
<div>
<div class="f"><span class="f ico_interone">&nbsp;</span><font
	class="big000"><ww:property
	value="getInterAirCityNamebySZM(hideFromCityCode)" />－<ww:property
	value="getInterAirCityNamebySZM(hideArrCityCode)" /> <ww:if
	test="intertype==1">（单程）</ww:if><ww:else>（往返）</ww:else></font></div>
<div class="r">查询&nbsp;预订&nbsp;核对&nbsp;完成</div>
<div class="c"></div>
</div>
<div class="algin mt7" style="display: none">
<form action="international!toInterNationalList.jspx" name="form1"
	method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="30" width="185">航程类型： <input name="intertype"
			id="radioOne" onclick="radioSelect(1);" type="radio" class=""
			value="1" <ww:if test="intertype==1">checked="checked"</ww:if> /> 单程<input
			name="intertype" id="radioTwo" type="radio" value="2"
			onclick="radioSelect(2);"
			<ww:if test="intertype==2">checked="checked"</ww:if> />往返</td>
		<td width="245">出发城市：<input type="text" class="text_intersea"
			id="fromCity" name="fromCity"
			value='<ww:property value="getInterAirCityNamebySZM(hideFromCityCode)"/>' />
		<div id='suggest' class="ac_results"></div>
		<input type="hidden" id="hideFromCityCode" name="hideFromCityCode"
			value='<ww:property value="hideFromCityCode"/>' /></td>
		<td>到达城市： <input type="text" class="text_intersea" id="arrCity"
			name="arrCity"
			value='<ww:property value="getInterAirCityNamebySZM(hideArrCityCode)"/>' />
		<div id='suggest2' class="ac_results"></div>
		<input type="hidden" id="hideArrCityCode" name="hideArrCityCode"
			value='<ww:property value="hideArrCityCode"/>' /></td>
	</tr>
	<tr>
		<td><input type="button" class="bnt-aglin fff mr5" value="重新查询"
			onclick="checkBotton();" /><a href="#" class="f00"></a></td>
		<td>出发时间：<input type="text" id="fromTime" name="fromTime"
			class="text_intersea" onClick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
			value='<ww:property value="fromTime"/>' /></td>
		<td id="lireturnTime"
			<ww:if test="intertype==1">style="display:none"</ww:if>>返回时间： <input
			type="text" id="returnTime" class="text_intersea"
			onClick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})" name="returnTime"
			value='<ww:property value="returnTime"/>' /></td>
	</tr>
</table>
</form>
</div>
<div class="algin-more" style="display: none">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="30" width="185">乘客类型：<select
			class="sel_intersea_algin">
			
			<option>成人</option>
		</select></td>
		<td width="245">乘客人数：<select class="sel_intersea">
			<option>1人</option>
		</select></td>
		<td>舱位等级：<select class="sel_intersea">
			<option>特价舱</option>
		</select></td>
	</tr>
</table>
</div>
<form action="international!createOrder.jspx" method="post" name="formorder">
<div class="algin-botm">&nbsp;</div>
<div class="tips_go mt7"><span class="fff mr25">航&nbsp;线</span><font
	size="2"><ww:property
	value="getInterAirCityNamebySZM(hideFromCityCode)" />--><ww:property
	value="getInterAirCityNamebySZM(hideArrCityCode)" /> 出发日期：<ww:property
	value="fromTime" /> </font>
	</div>

	
<div class="box mt7 bookinglistgo">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="margin: 1px;">
	<tr>
		<th scope="col" align="left" class="pf20">航程</th>
		<th scope="col">航空公司</th>
		<th scope="col">航班号</th>
		<th scope="col">起飞时间</th>
		<th scope="col">到达时间</th>
		<th scope="col">机型</th>
		<th scope="col">价格</th>
	</tr>
	 <!-- 隐藏 订单航班Id 回调使用 -->		
	<input type="hidden" name="RoutesId" value='<ww:property value="RoutesId"/>'/>
	<input type="hidden" name="s_tax" id="s_tax" value='<ww:property value="formatMoneyToInt(s_tax)"/>'/>
	<input type="hidden" id="TotalFare" name="TotalFare" value='<ww:property value="formatMoneyToInt(TotalFare)"/>'/>
    <input type="hidden" id="childTotalFare" name="childTotalFare" value='<ww:property value="formatMoneyToInt(childTotalFare)"/>'/>
	
	<input type="hidden" id="TotalPrice" name="TotalPrice" value=""/>
	<ww:iterator value="routeDetailInfo" status="i">

		<tr>
			<td align="left" class="pf20"><ww:property
				value="getAirPortNamebyCode(FromAirport)" /> <br />
			<ww:property value="getAirPortNamebyCode(ToAirport)" /></td>
			<td align="left"><span class="f mu airco_<ww:property value="AirCompany" /> airico">&nbsp;</span><ww:property
				value="AirCompanyNamebyCode(AirCompany)" />
				</td> 
			<td><ww:property value="FlightNumber" /></td>
			<td><ww:property value="getTimeByDate(FromDate)" />
			
			</td>
			
			<td><ww:property value="getTimeByDate(ToDate)" /></td>
			<td><ww:property value="Plane" /></td>
			<td><font class="f90c"><ww:property
				value="formatMoneyToInt(TotalFare)" /></font>元</td>
		</tr>
	</ww:iterator>
</table>
</div>
<div class="morney"><span class="f ico_morney">&nbsp;</span>订单总价：<font class="f90c" id="priceTitle">￥<ww:property value="formatMoneyToInt(TotalFare)" /></font>
&nbsp;(<font class="dd2626" id="fontPrice">1成人×￥<ww:property value="formatMoneyToInt(TotalFare)" />
   +0儿童×￥<ww:property value="formatMoneyToInt(childTotalFare)"/>
   +0税费×￥<ww:property value="formatMoneyToInt(s_tax)"/>
</font>)</div>
<div class="box">
<div class="title"><font class="black low f mr15">温馨提示</font>
<div class="c"></div>
</div>
<div class="tips_inter">
<ul>
	<li><font class="font12000">乘客身份</font>：<ww:if test='passengerType=="2"'>儿童</ww:if><ww:else>成人</ww:else></li>
	<li><font class="font12000">行李要求</font>：托运行李20KG，长宽高三边之和<158CM；手提行李1件，每件5KG，长宽高三边之和<115CM。行李直挂。</li>
	<li><font class="font12000">检票提示</font>：请您务必提前3小时到达机场，办理行李托运，及登机手续，以免耽误您的行程。</li>
	<li><font class="font12000">其它提示</font>：为了方便您的出行，请您在回程日期前3天向航空公司确认座位；如您行程有任何变动，都必须在距航班起飞前24小时办理。</li>
</ul>
</div>
</div>
<div class="box mt7">
<div class="title"><font class="black low f mr15">乘客信息</font><font
	size="2"> — 请准确填写姓名、证件号等信息，港澳旅客请填证件上的英文名，格式：FirstName/LastName。
</font>
<div class="c"></div>
</div>
<div class="number" id="titleinfo" >
<ul  >
	<li class="f mr15"><a href="javascript:void(0);"  onclick='addPeople("");'
		class="fontun06c f">添加联系人</a>
	</li>
	
	<li class="f floatall"><font class="f">常用乘机人：</font>  <ww:iterator
			value="listcommonpassenger" status="state">
			<span class="mr15"><a class="commonpassenger"
				id="link_common_pass_<ww:property value="#state.index" />"
				href="javascript:void(0)"
				onclick='setpassenger("<ww:property value="#state.index" />",1);'
				class="un000"><ww:property value="username" /></a></span>
		</ww:iterator> <ww:if test="listallcommonpassenger.size()>0">
			<a href="javascript:void(0)" onclick="showcommonpassenger();"
				class="fontun06c">更多>></a></ww:if>
	<div class="c"></div>
	<div class="people msg" style="display: none" id="divcommonpassenger">
	<ul class="msgul pf20">
	<ww:iterator value="listallcommonpassenger" status="state">
				<span class="mlr15"><a
					id="link_allcommon_pass_<ww:property value="#state.index" />"
					href="javascript:void(0)"
					onclick='setpassenger("<ww:property value="#state.index" />",2);'
					class="un000"><ww:property value="username" /></a></span>
			</ww:iterator>
		
		<div class="c"></div>
	</ul>
	</div>
	<!--更多联系人--></li>
	<li class="r save">保存到常用乘机人</li>
	<li class="c"></li>
</ul>
</div>
<div class="information" id="divpassengers"><!-- 模板开始 --> <script
	id="passengerTemplate" type="text/x-jquery-tmpl">
<table width="100%" border="1" cellspacing="0" cellpadding="0" id="table_name_\${ID}">
	<tr>
		<td class="hadow" align="right"><font class="fontxing">*</font> 姓
		名：</td>
		<td colspan="5"><input type="text" class="text_number" id="txt_name_\${ID}" value="\${Name}" />
		<font class="c999">中国籍请按"姓拼音/名拼音"填写，如：LI/MING</font></td>
		<td class="hadow"><input name="" type="checkbox" checked="checked" id="chbissave_\${ID}"/>保存乘客</td>
	</tr>
	<tr>
		<td class="hadow" align="right" width="15%">乘客类型：</td>
		<td width="14%"><select class="sel_type" id="passenger_type_\${ID}" onchange="accountprice();">
			<option value="1">成人</option>
            <option value="2">儿童</option>
		</select></td>
		<td class="hadow" align="right" width="11%"><font
			class="fontxing">*</font>留学生：</td>
		<td width="11%"><select class="sel_type" id="student_type_\${ID}">
			<option value="0">是</option>
			<option value="1">否</option>
		</select></td>
		<td class="hadow" align="right" width="14%"><font
			class="fontxing">*</font>性&nbsp;别：</td>
		<td width="19%"><select class="sel_documents" id="sex_type_\${ID}">
			<option value="1">男</option>
			<option value="2">女</option>
		</select></td>
		<td class="hadow">
<input type="hidden" id="hid_totalprice_\${ID}" value="\${Totalprice}" />
<span class="del_people">&nbsp;</span><a
			href="javascript:void(0)" onclick="delPeople(\${ID});" class="fontun06c">删除乘客</a></td>
	</tr>
	<tr>
		<td class="hadow" align="right"><font class="fontxing">*</font>国籍/地区：
		</td>
		<td colspan="3">
         <select class="sel_documents" id="txt_Nationality_\${ID}"  style="width:120px">
             <option value="CN">中国</option>
            <ww:iterator value="listcountry" status="t">
            <option value="<ww:property value="countrycode" />"><ww:property value="countrycode" /><ww:property value="countryname" /></option>
            </ww:iterator>
</select></td> 
       
		<td class="hadow" align="right"><font class="fontxing">*</font>
		证件类型：</td>
		<td colspan="2">
        <select class="sel_documents" id="txt_Docment_\${ID}" style="width:100px"> 
            <option value="1">身份证</option>
				<option value="2">护照</option>
				<option value="3">港澳通行证</option>
				<option value="4">台湾通行证</option>
				<option value="5">台胞证</option>
				<option value="6">回乡证</option>
                
         </select>
            </td>
	</tr>
	<tr>
		<td class="hadow" align="right"><font class="fontxing">*</font>证件签发国：
		</td>
		<td colspan="3">
 <select class="sel_documents" id="txt_Country_\${ID}"  style="width:120px">
            <option value="CN">中国</option>
            <ww:iterator value="listcountry" status="t">
            <option value="<ww:property value="countrycode" />"><ww:property value="countrycode" /><ww:property value="countryname" /></option>
            </ww:iterator>
</select>

</td>
		<td class="hadow" align="right"><font class="fontxing">*</font>证件号码：
		</td>
		<td colspan="2"><input type="text" class="text_number" value="\${Number}" id="txt_Number_\${ID}" /></td>
	</tr>
	<tr>
		<td class="hadow" align="right"><font class="fontxing">*</font>出生日期：
		</td>
		<td colspan="3"><input type="text" class="text_number" value="\${BirthDate}" id="txt_BirthDate_\${ID}" onclick="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"/></td>
		<td class="hadow" align="right"><font class="fontxing">*</font>证件有效期：
		</td>
		<td colspan="2"><input type="text" class="text_number" value="\${Period}" id="txt_Period_\${ID}" onclick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"/></td>
	</tr>
</table>
</script>
<div class="nohave"></div>
<!-- 模板结束 end--></div>

<!--添加信息下一步 -->
 <div class="box mt7 check"  >
        <table width="100%" border="0" cellspacing="0" cellpadding="0"  style="margin:1px;" style="display: none" id="peopleinfo">
              <tr>                                                                                                  
                <th scope="col" align="left" class="pf20">乘机人姓名</th>
                <th scope="col">乘客类型</th>
                <th scope="col">证件类型</th>
                <th scope="col">证件号码</th>
                <th scope="col">证件有效期</th>
                <th scope="col">证件签发国</th>
                <th scope="col">国籍/地区</th>
                <th scope="col">性别</th>
                <th scope="col">留学生</th>
              </tr> 
             <script id="overinfo" type="text/x-jquery-tmpl">                                       
               <tr id="tr_name_\${ID}">
               <td>\${Name}</td>
               <td id="td_Type_\${ID}">\${Type}</td>
               <td id="td_Docment_\${ID}">\${Docment}</td>
               <td>\${Number}</td>
               <td>\${Period}</td>
               <td>\${Nationality}</td>
               <td>\${Country}</td>
               <td id="td_sex_\${ID}">\${sex_type}</td>
               <td id="td_stu_\${ID}">\${student_type}</td>
              </tr>
             </script> 
            </table>

     </div>


<!--添加信息下一步 end-->

<!--成人信息--></div>
<div class="box mt7">
<div class="title"><font class="black low f mr15">联系人信息 </font><font
	size="2">— 请准确填写联系人信息（手机号码，E-mail），以便我们与您联系。 </font>
<div class="c"></div>
</div>
<div class="nohave"></div>
<div class="information">
<table width="100%" border="1" cellspacing="0" cellpadding="0">
	<tr>
		<td width="14%" class="hadow" align="right"><font
			class="fontxing">*</font>联系人：</td>
		<td width="37%"><input type="text" class="text_number"  name="Contact" id="Contact"/></td>
		<td width="14%" class="hadow" align="right"><font
			class="fontxing">*</font>联系电话：</td>
		<td><input type="text" class="text_number" value="" name="MobilPhone" id="MobilPhone"/></td>
	</tr>
	<tr>
		<td class="hadow" align="right"><font class="fontxing">*</font>邮箱：</td>
		<td><input type="text" class="text_number" value="" name="Email" id="Email"/></td>
		<td class="hadow" align="right">备注：</td>
		<td>	
		<input type="text" class="text_number" value="" name="comfileType" id="comfileType"/>	
		</td>
	</tr>
</table>
</div>
<div class="nohave"></div>
</div>

<div class="bnt"><input type="button"
	class="bnt_previous mr25 cfff" value="上一步" onclick="showAddPeople();"/> <input type="button"
	class="bnt_next mlr15 cfff" value="下一步" onclick="hideAddProple();" id="hideaddpeople"/>
	<input type="button"
	class="bnt_next mlr15 cfff" value="提&nbsp;交" id="tijiao" style="display:none" onclick="commitOrder();"/>
	<!-- 返回乘机人联系人信息到  后台获取-->
	<input type="hidden" name="commitorder" id="commitorder"/>
	</div>
</form>
</div>
<div id="right" class="r">
<div class="titlelogin"><font class="black">国际航线咨询</font></div>
<div class="box_sea">
<ul class="inter-information">
	<li class="nohave">&nbsp;</li>
	<li><span class="ico_inter-information f">&nbsp;</span>海航开通海口直飞新加坡航线</li>
	<li><span class="ico_inter-information f">&nbsp;</span>东航北京始发欧美澳航线特价促销</li>
	<li><span class="ico_inter-information f">&nbsp;</span>南航珀斯航线开航通知</li>
	<li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
	<li><span class="ico_inter-information f">&nbsp;</span>海航开通海口直飞新加坡航线</li>
	<li><span class="ico_inter-information f">&nbsp;</span>东航北京始发欧美澳航线特价促销</li>
	<li><span class="ico_inter-information f">&nbsp;</span>南航珀斯航线开航通知</li>
	<li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
	<li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
	<li><span class="ico_inter-information f">&nbsp;</span>埃及航空全新商务舱－商务人士最</li>
	<li class="nohave">&nbsp;</li>
</ul>
</div>
<div class="loginbot"></div>
<div class="nohave">&nbsp;</div>
<div><img src="images/ad_interright.jpg" width="260" height="88" /></div>
<div class="nohave">&nbsp;</div>
<div><img src="images/ad_interrightto.jpg" width="260" height="88" /></div>
</div>
<div class="c"></div>
</div>
<!--container over-->
<ww:include page="../footer.jsp" />

</body>
</html>
