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
        adultpassengerprice+=<ww:property value="price" />
        adultpassengerairport+=<ww:property value="airportfee" />
        adultpassengerfuel+=<ww:property value="fuelfee" />
       //成人总价格(含税费)
       adultpricefee+=adultpassengerprice+adultpassengerairport+adultpassengerfuel
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
    
    var passengerJsonString='[{ ID: "1",Name:"",Type:"1",Idcardtype:"1",Idcardnumber:"",Insurancenum:"0",Insurancemoney:"'+insuranceprice+'",Ticketprice:"'+adultpassengerprice+'",Airportprice:"'+adultpassengerairport+'",Fuelprice:"'+adultpassengerfuel+'",Totalprice:"'+adultpricefee+'",Issave:"",Customerpassid:"0" }]';
    var passengers=eval(passengerJsonString); 
    
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
				       jsonstring='[{ ID: "currentindex",Name:"'+usrname+'",Type:"'+type+'",Idcardtype:"'+idcardtype+'",Idcardnumber:"'+idcardnumber+'",Insurancenum:"0",Insurancemoney:"'+insuranceprice+'",Ticketprice:"'+adultpassengerprice+'",Airportprice:"'+adultpassengerairport+'",Fuelprice:"'+adultpassengerfuel+'",Totalprice:"'+adultpricefee+'",Issave:"1",Customerpassid:"'+passid+'"  }]';
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
         var isrightdate=true;
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
            }
                 else
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
                    else if($("#ddlidcardtype_"+id).val()=="8")
                    {
                        if(!IsDate($("#txt_idcardnumber_"+id).val()))
                        {
                           isrightdate=false;
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