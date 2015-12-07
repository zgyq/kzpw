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
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单信息表列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/bass.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="style/base100108.css" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<script>
//退票时，选中所有的乘机人
function checkallbox()
{
    if($('#checkboxflag').val()=="0")
    {
       $("input[id*='chkpassenger_']").each(function(i)
       {
          $(this).attr("checked",true);
       }
       );
       $('#checkboxflag').val("1");
    }
    else
    {
        $("input[id*='chkpassenger_']").each(function(i)
       {
          $(this).attr("checked",false);
       }
       ); 
       $('#checkboxflag').val("0");
    }
}

//点击申请退票
function tuiticket(id)
{

    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个要申请退票的乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行申请退票操作吗？'))
	    {
	   	  var re = /^[0-9]+.?[0-9]*$/;
	    	if(!re.test($("#txttuifee").val())){
	    	 alert("请输入数字(例:88.02)");
	    	 return;   
	    	}else{
	    	 
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=4&pr=2&passid='+passengerids+'&tui='+$("#txttuifee").val();
	   }
	    }
     }
    
}
//点击申请废票
function feiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个要申请废票的乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行申请废票操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=5&pr=1&passid='+passengerids;
	    }
     }
    
}
//点击申请改签
function gaiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个要申请改签的乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行申请改签操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=13&pr=3&passid='+passengerids;
	    }
     }
    
}
//点击退票通过
function shenhetuiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个要退票的乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行退票操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=12&pr=2&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2';
	    }
     }
    
}
//点击废票通过
function shenhefeiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个要废票的乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行废票操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=11&pr=1&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2';
	    }
     }
    
}
//点击改签通过
function shenhegaiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个要改签的乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行改签操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=14&pr=3&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2';
	    }
     }
    
}
//点击退票不通过
function noshenhetuiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行退票不通过操作吗？'))
	    {
	  //  alert($("#beizhu").val());
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=17&pr=2&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2';
	    }
     }
    
}
//点击废票不通过
function noshenhefeiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行废票不通过操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=7&pr=1&passid='+passengerids+'&no=2'+'&beizhu='+encodeURI($("#beizhu").val());
	    }
     }
    
}
//点击改签不通过
function noshenhegaiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0)
     {
	    checkfalg="true";
     }
     else
     {
         alert("请至少选中一个乘机人！");
         checkfalg="false";
         return false;
     } 
     
     if(checkfalg=="true")
     {
       $("input[id*='txtpassid_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
              passengerids+=$(this).val()+",";
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行改签不通过操作吗？'))
	    {
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=15&pr=3&passid='+passengerids+'&no=2'+'&beizhu='+encodeURI($("#beizhu").val());
	    }
     }
    
}
 function hide() {
               document.getElementById("xie").style.display = "none";
               document.getElementById("content1").style.display = "none";
           }
  function hi() {
var da =  document.getElementById("da").value;
//alert("da="+da) 
var u =document.getElementById("hur").value;
//alert(u+'&tui='+da);
	window.location.href=u+'&tui='+da;       
           }
 function goEdit2(ur,id)
{

	var h = ur.split("pr=");
	var h1 =h[1];

	if(h1==1){
				
 			$("#divpassenger").dialog({
		                title:'机票订单费票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengersqList.action",
		            data:{strTuiOrderID:id,typ:1},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
		   }
if(h1==2){
		
 			$("#divpassenger").dialog({
		                title:'机票订单退票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengersqList.action",
		            data:{strTuiOrderID:id,typ:2},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
		   }
            if(h1==3){
				
 			$("#divpassenger").dialog({
		                title:'机票订单退票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengersqList.action",
		            data:{strTuiOrderID:id,typ:3},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
		   }
		    if(h1==4){
				
 			$("#divpassenger").dialog({
		                title:'机票订单PNR分离',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 450
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengersqListsep.action",
		            data:{strTuiOrderID:id,typ:4},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
		   }

}
function goEdit(ur,id)
{
        document.getElementById("hur").value=ur;
		var url="orderinfo!seachstate.action?oid="+id;
		var params = {s_status:2};
		jQuery.post(url,params, function(data) {
		
			if (data != '') {
				
				var s, ss;
				//弹出层填写价格
				var hu=document.getElementById("hur").value;
				
				var h = hu.split("pr=");
				var h1 =h[1];
				//
				
				
				ss = data.substr(0, 2); 	
				//alert(ss);
				if(ss == 'su'){
				var dealname=document.getElementById("hidname_"+id).value;
				alert("该订单已经正在被[["+dealname+"]]处理，您不能再处理了！");
				}
				if(ss == 'my'){
				if(h1==3){//改签
				
		        $("#divpassenger").dialog({
		                title:'机票订单改签处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:3},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
					
					return;
			
				}
				
				if(h1==2){
				
		        $("#divpassenger").dialog({
		                title:'机票订单退票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:2},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
					
					return;
			
				}
				if(h1==1){//申请废票
				
				
			 $("#divpassenger").dialog({
		                title:'机票废票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:1},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
				 
				 
				 return;
				
				}
				//alert("这订单我的"+ur);
			
				
				window.location.href=document.getElementById("hur").value;
				}
				if(ss == 'sh'){
				var sheid = data.split(",");	
				
				
				var uid = sheid[1];
				//alert(uid);
				alert("该订单已经正在被其他人处理，您不能再处理了！");
				
				
				}
				if(ss == 'ko'){
				//	alert("这订单没人处理");
				
				if(h1==2){
				 $("#divpassenger").dialog({
		                title:'机票订单退票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:2},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
				 
				 
				 return;
				
				}
				if(h1==1){//申请废票
				
				
			 $("#divpassenger").dialog({
		                title:'机票废票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:1},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
				 
				 
				 return;
				
				}
				if(h1==3){//改签
		        $("#divpassenger").dialog({
		                title:'机票订单改签处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 710,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:3},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
					
					return;
			
				}
				window.location.href=document.getElementById("hur").value;
				}
				
			}
		});
		
		

  // 
}
 //选中的乘机人id取值
 function setpassid(id)
 {
     if(document.getElementById("chkpassenger_"+id).checked)
     {
       $("#hidpassengerid").val($("#txtpassid_"+id).val());
     }
     else
     {
       $("#hidpassengerid").val(""); 
     }
 }

Ext.onReady(function(){

	 var selectId ="";

	 var menu = new Ext.menu.Menu({
        id: 'mainMenu',
		width:'160px',
        style: {
            overflow: 'visible'     // For the Combo popup
        },
        items: [
		     
		    {
                id:"new",
				text: '查看',
				icon:"images/menu/view.gif",
				handler : function(item){
					document.form1.action="orderinfo!toshowgys.action?id="+selectId;
					document.form1.submit();
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="orderinfo!toedit.action?id="+selectId;
						document.form1.submit();
				}
            }
			
			
		]

		});



	Ext.get('menutable').on('contextmenu',function(e){
		
		if(e.target.parentNode.id)
		{
			e.preventDefault();
			selectId = e.target.parentNode.id;
			menu.showAt(e.getPoint());
		}
	});

});

function rrticket(id)
{
 //点击执行锁定订单操作
  
 $.ajax({
     type:"POST",
     url:"orderinfo!lockorder.action",
     data:{strTuiOrderID:id},       
     success:function(data){
       if(data!="")
       {
          alert("此订单正在被"+data+"处理,您现在不能对订单进行处理！");
          closedialog(0);
       }
     }            
     });
 
$("#divpassenger").dialog({
      title:'立即出票操作-填写票号行程单号',
      show: null,
      bgiframe: false,
      autoOpen: false,
      draggable: true,                
      resizable: true,
      modal: true,
      width: 710,
      height: 450
  });
  $(".ui-dialog-titlebar-close").hide();
  $("#divpassenger").dialog("open");
  $.ajax({
     type:"POST",
     url:"orderinfo!rrticket.action",
     data:{strTuiOrderID:id},  
     beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},         
     success:function(data){
     $("#divpassenger").html(data); 
      
     }            
     });
}
//保存票号行程单号
function saveticketnumber(id)
{
   //票号验证
   var ticketnumberflag=true;
   var ticketnumbermsg;
   $("input[id*='txtticketnumber_']").each(function(i)
    {
     var va=$(this).val();
       if(va=="")
       {
          ticketnumberflag=false;
          ticketnumbermsg="请填写所有乘机人的票号！";
          
       }else{
        var reg=/^[0-9]{3}[-][0-9]{10}$/;
         if(!reg.test(va)){
           ticketnumberflag=false;
          ticketnumbermsg="您填写的票号格式不正确(第"+(i+1)+"列)，请重新填写(例:123-0123456789)！";
         
         }

       }
    }
    );
    //行程单号验证
    var rpnumberflag=true;
    var rpmessage;
    $("input[id*='txtrpnumber_']").each(function(i)
    {
     var rpval=$(this).val();
       if(rpval=="")
       {
          rpnumberflag=false;
          rpmessage="请填写所有乘机人的行程单号！";
       }else{
          var reg=/^[0-9]{10}$/;
         if(!reg.test(rpval)){
           rpnumberflag=false;
            rpmessage="您填写的行程单号格式不正确(第"+(i+1)+"列),请重新填写(例:0123456789)！";
         
         }
       
       }
    }
    );
    //EI验证
    var eiflag=true;
    $("select[id*='ei_']").each(function(i)
    {
       if($(this).val()=="")
       {
          
          eiflag=false;
       }
    }
    );
    
    if(ticketnumberflag==false)
    {
       alert(ticketnumbermsg);
       return false;
    }
    //if(rpnumberflag==false)
    //{
       //alert(rpmessage);
       //return false;
    //}
   
    var ticketnumberarr="";
    $("input[id*='txtticketnumber_']").each(function(i)
    {
       ticketnumberarr+=$(this).val()+",";
    }
    );
    
    var rpnumberarr="";
    $("input[id*='txtrpnumber_']").each(function(i)
    {
       rpnumberarr+=$(this).val()+",";
    }
    );
    
    var eiarr="";
    $("select[id*='ei_']").each(function(i)
    {
       eiarr+=$(this).val()+",";
    }
    );
    //ajax保存票号
    $.ajax({
	    type:"POST",
	    url:"orderinfo!saveticketnumber.action",
	    data:{strTuiOrderID:id,ticketnumberarr:ticketnumberarr,rpnumberarr:rpnumberarr,eiarr:eiarr}, 
	    async:false, 
	    beforeSend:function(){$("#divpassenger").html("正在保存票号等信息...");},         
	    success:function(data){
	     goEdit('orderinfo!editorderstatus.action?id='+id+'&orderstatus=3',id);  
	    }            
    });
   
}
 function closedialog(id)
 {
   if(id!=0)
   {
     $.ajax({
        type:"POST",
        url:"orderinfo!unlockorderinfo.action",
        data:{strTuiOrderID:id},          
        success:function(data){          
        }            
        });
   }
   $("#divpassenger").dialog("close");
 }
</script>
</head>
<body>

<form name="form1" method="post" action="orderinfo!toPaid.action">
<div id="divpassenger" style="text-align:center;display:none; background-color:#fff;left:0px;">正在加载订单信息...
</div>
<input type="hidden" name="s_orderstatus" value="<ww:property value="s_orderstatus"/>" />
<input type="hidden" name="ty" value="<ww:property value="ty"/>"/>

<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;
			<ww:if test="ty==1">已经支付等待出票</ww:if>
			<ww:if test="ty==2">暂不能出票</ww:if>
			<ww:if test="ty==3">所有申请废票</ww:if>
			<ww:if test="ty==4">审核不通过废票</ww:if>
			<ww:if test="ty==5">审核通过废票</ww:if>
			<ww:if test="ty==6">所有已退款的废票</ww:if>
			<ww:if test="ty==7">当日废票</ww:if>
			<ww:if test="ty==8">当日已审核废票</ww:if>
			<ww:if test="ty==9">所有申请改签订单</ww:if>
			<ww:if test="ty==10">所有成功改签订单</ww:if>
			<ww:if test="ty==11">所有改签失败订单</ww:if>
			<ww:if test="ty==12">所有申请退票订单</ww:if>
			<ww:if test="ty==13">退票成功订单</ww:if>
			<ww:if test="ty==14">退票不成功订单</ww:if>
			<ww:if test="ty==15">所有已退款的退票</ww:if>
			
			订单列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">


		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">

					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>

								<table class="table2" width="100%">
									<tr>
										<td width="100%" height="29" colspan="8"
											background="images/jb.gif"
											style="border-bottom: 1px solid #99CBED"><span
											class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;订单管理-订单查询</span></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">PNR编号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_pnr" type="text" id="s_pnr" style="width: 138px;"
											value="<ww:property value="s_pnr"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">订单编号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_ordernumber" type="text" id="s_ordernumber"
											value="<ww:property value="s_ordernumber"/>"
											style="width: 138px;" /></td>
										<td align="right" style="width: 9%; height: 26px;"
											nowrap="nowrap">预订时间&nbsp;</td>
										<td align="right" style="width: 16%; height: 26px;"><input
											name="s_bengincreatetime" type="text"
											value="<ww:property value="s_bengincreatetime"/>"
											id="s_bengincreatetime" onfocus="WdatePicker()"
											style="width: 138px;" /></td>
										<td align="right" style="width: 10%; height: 26px;">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_endcreatetime" type="text"
											value="<ww:property value="s_endcreatetime"/>"
											id="s_endcreatetime" onfocus="WdatePicker()"
											style="width: 138px;" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%" nowrap="nowrap">乘机日期
										</td>
										<td align="right" style="width: 15%"><input
											name="s_beginchengji" type="text" id="s_beginchengji"
											onfocus="WdatePicker()" style="width: 138px;"
											value="<ww:property value="s_beginchengji"/>" /></td>
										<td style="width: 6%" align="center">至</td>
										<td align="right" style="width: 15%"><input
											name="s_endchengji" type="text" id="s_endchengji"
											onfocus="WdatePicker()" style="width: 138px;"
											value="<ww:property value="s_endchengji"/>" /></td>
										<td align="right" style="width: 9%" nowrap="nowrap">
										出票时间&nbsp;</td>
										<td align="right" style="width: 16%"><input
											name="s_beginprinttime" type="text" id="s_beginprinttime"
											onfocus="WdatePicker()" style="width: 138px;"
											value="<ww:property value="s_beginprinttime"/>" /></td>
										<td align="right" style="width: 10%">至</td>
										<td align="right" style="width: 15%"><input
											name="s_endprinttime" type="text" id="s_endprinttime"
											value="<ww:property value="s_endprinttime"/>"
											onfocus="WdatePicker()" style="width: 138px;" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%" nowrap="nowrap">出发城市
										</td>
										<td align="right" style="width: 15%"><select
											name="s_begincity" style="width: 142px;">
											<option value=""
												<ww:if test="s_begincity==null">selected="selected"</ww:if>>所有城市</option>
											<ww:iterator value="listCityairport">
												<option value="<ww:property value="airportcode"/>"
													<ww:if test="s_begincity==airportcode">selected="selected"</ww:if>><ww:property
													value="cityname" />(<ww:property value="airportcode" />)</option>
											</ww:iterator>
										</select></td>
										<td align="right" style="width: 6%" nowrap="nowrap">到达城市
										</td>
										<td align="right" style="width: 15%"><select
											name="s_endcity" style="width: 142px;">
												<option value=""
												<ww:if test="s_endcity==null">selected="selected"</ww:if>>所有城市</option>
											<ww:iterator value="listCityairport">
												<option value="<ww:property value="airportcode"/>"
													<ww:if test="s_endcity==airportcode">selected="selected"</ww:if>><ww:property
													value="cityname" />(<ww:property value="airportcode" />)</option>
											</ww:iterator>
										</select></td>
										<td align="right" style="width: 10%; height: 26px;">乘机人</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_passengername" type="text" id="s_passengername"
											style="width: 138px;"
											value="<ww:property value="s_passengername"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;">票号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_passengerfet" type="text" id="s_passengerfet"
											style="width: 138px;"
											value="<ww:property value="s_passengerfet"/>" /></td>
									</tr>
									<tr>
										<td align="right" style="width: 6%; height: 26px;">航班号</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_flightnumber" type="text" id="s_flightnumber"
											style="width: 138px;"
											value="<ww:property value="s_flightnumber"/>" /></td>

										




										<td align="right" style="width: 9%; height: 26px;" nowrap="nowrap">订单来源</td>
										<td align="right">
										<!-- <select name="s_ordertype" style="width: 142px;">
										<option <ww:if test="s_ordertype==0">selected="selected"</ww:if> value="0">所有订单</option>
										<option <ww:if test="s_ordertype==1">selected="selected"</ww:if> value="1">网站预订</option>
										<option <ww:if test="s_ordertype==2">selected="selected"</ww:if> value="2">b2b订单</option>
										<option <ww:if test="s_ordertype==3">selected="selected"</ww:if> value="3">同行订单</option>
										<option <ww:if test="s_ordertype==4">selected="selected"</ww:if> value="4">团队订单</option>
										<option <ww:if test="s_ordertype==5">selected="selected"</ww:if> value="5">K位订单</option>
										<option <ww:if test="s_ordertype==6">selected="selected"</ww:if> value="6">b2c后台订单</option>
										</select> -->
										</td>
										<td align="right" style="width: 9%; height: 26px;"></td>
										<td align="right" style="width: 9%; height: 26px;"></td>
									</tr>
									<tr>

										<td colspan="10" align="center"><input type="submit"
											class="button_d font-white"
											value="查询订单" />
											</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="40" align="center">
										<div align="right">
										<a href="#" onclick="updateItem()">
										<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="showItem()"><input
											type="button" value="查看" class="button_h font-red" /></a></div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">

											<th class="table_color" width="54" height="25"><input
												type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>

									<th class="table_color">订单编号</th>
									        <ww:if test="#session.loginuser.agentid==46">
									        <th class="table_color">所属供应商</th>
									        </ww:if>
											<th class="table_color">乘机人</th>
											<th class="table_color">行程</th>
											<th class="table_color">航班号</th>
											<th class="table_color">PNR</th>
											<th class="table_color">起飞时间/预订时间</th>
											<th class="table_color">总价</th>
											<th class="table_color">支付方式</th>
											<th class="table_color">订单状态</th>
											<th class="table_color">支付状态</th>
											<th class="table_color" style="display:none">锁单人</th>
											<th class="table_color">预订人</th>
											<th class="table_color">操作</th>
											
										</tr>
										<ww:iterator value="listOrderinfo">
											<ww:set name="segmentinfoss" scope="webwork"
												value="getSegmentinfo(id)" />
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color color_b3"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>
												<td class="table_color color_b3">
												<a href="javascript: goEdit('orderinfo!toshowgys.action?id=<ww:property value="id"/>','<ww:property value="id"/>');"><ww:property
													value="ordernumber" /></a></td>
												<ww:if test="#session.loginuser.agentid==46">
											     <td class="table_color color_b3" style="color:red;font-weight:bold">
											       <ww:property value="getFamousAgentName(policyagentid)" />
											     </td>
											     </ww:if>
												<td class="table_color color_b3"><ww:property
													value="getPassengerNamehtml(id)" /></td>
													
												<td class="table_color color_b3"><ww:property
													value="getCitynameByAirport(getSegmentinfo(id).startairport)" />
												- <ww:property
													value="getCitynameByAirport(getSegmentinfo(id).endairport)" />
												</td>
												
												<td class="table_color color_b3"><ww:property value="#segmentinfoss.flightnumber"/></td>
												<td class="table_color color_b3"><ww:property value="pnr"/></td>
												<td class="table_color color_b3">
												<ww:property value="formatTimestamp(#segmentinfoss.departtime)"/>
												<br />
												<ww:property
													value="formatTimestamp(createtime)" /></td>
                                                <td class="table_color color_b3"><ww:property value="formatMoney(totalticketprice+totalairportfee+totalfuelfee)"/></td>
												<td class="table_color color_b3">
												<ww:if test="paymethod==1">网上付款</ww:if>
												<ww:if test="paymethod==2">门市付款</ww:if>
												<ww:if test="paymethod==3">票到付款</ww:if>
												</td>
												<td class="table_color color_b3"><ww:property
													value="getStateToString(orderstatus)" /></td>
												<td class="table_color color_b3"><ww:property value="getPayMethod(paystatus)" /></td>
												<td class="table_color color_b3" style="display:none">
												
												<ww:if test="operatingstate==1">
														<ww:if test="seachgys(id)==1">
															<img src="images/Unlocked.png" border="0" />
														</ww:if><ww:else>
														<img src="images/Lock.png" border="0" /><br /><ww:property value="getusername(userid)"/><input type="hidden" id='hidname_<ww:property value="id" />' value='<ww:property value="getusername(userid)"/>' />
														</ww:else>
												</ww:if><ww:else>
												<img src="images/Unlocked.png" border="0" />
												</ww:else>	
													</td>
												<td class="table_color color_b3"><ww:property value="getusername(customeruserid)"/></td>
												<td class="table_color color_b3">
												<!-- 订单操作开始 订单状态:1.等待支付2.支付成功3.出票完成5.申请废退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭11.已经废退票13.申请改签14.已经改签15.暂不能出票 -->
												<ww:if test="orderstatus==2">
												<input type="button" class="button108" id="btnCancel" value="立即出票"  onclick="isrrticket(<ww:property value="policyagentid" />,<ww:property value="id" />,'<ww:property value="getFamousAgentName(policyagentid)" />');" /><br/>
												<input type="button" class="button108" id="btnCancel" value="暂不能出票"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=16','<ww:property value="id" />')" />
												</ww:if>
												<ww:elseif test="orderstatus==5">
												<input type="button" class="button108" id="btnRRTicket" value="废票审核"   onclick="goEdit2('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=11&pr=1','<ww:property value="id" />')" /><br/>
											
												<!--<input type="button" class="button108" id="btnRRTicket" value="废票审核通过"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=11','<ww:property value="id" />')" /><br/>
												<input type="button" class="button108" id="btnRRTicket" value="废票审核不通过"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=7','<ww:property value="id" />')" /><br/>
												-->
												</ww:elseif>
												<ww:elseif test="orderstatus==4">
												
												<!--<input type="button" class="button108" id="btnRRTicket" value="退票审核通过"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=12','<ww:property value="id" />')" /><br/>
												<input type="button" class="button108" id="btnRRTicket" value="退票审核不通过"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=17','<ww:property value="id" />')" /><br/>
												
												-->
												<input type="button" class="button108" id="btnRRTicket" value="退票审核"   onclick="goEdit2('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=12&pr=2','<ww:property value="id" />')" /><br/>
											
												</ww:elseif>
												<ww:elseif test="orderstatus==11">
												<input type="button" class="button108" id="btnRRTicket" value="废票退款"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=9','<ww:property value="id" />')" /><br/>
												
												</ww:elseif>
												<ww:elseif test="orderstatus==12">
												<input type="button" class="button108" id="btnRRTicket" value="退票退款"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=18','<ww:property value="id" />')" /><br/>
												
												</ww:elseif>
												<ww:elseif test="orderstatus==13">
												<input type="button" class="button108" id="btnRRTicket" value="改签审核"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=14&pr=3','<ww:property value="id" />')" /><br/>
												
												<!--<input type="button" class="button108" id="btnRRTicket" value="改签通过"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=14','<ww:property value="id" />')" /><br/>
												<input type="button" class="button108" id="btnRRTicket" value="改签不通过"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=15','<ww:property value="id" />')" /><br/>
												-->
												</ww:elseif>
												<ww:else>
												<span style="color: red">不能对订单进行操作</span>
												</ww:else><!--<br/>
												<ww:if test="operatingstate==1">
												<a href="orderinfo!jiesuo.action?id=<ww:property value="id" />"> 解锁订单</a> 
												</ww:if>
												--><!-- 订单操作结束 -->
												</td>
												
											</tr>
										</ww:iterator>
									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center">
							
								<ww:property value="getPagination('\"orderinfo!toPaid.action?pageinfo.pagenum=\"+pageno')"/>
								<input type="hidden" name="" id="hur"  style="width: 150px" />	
									</td>
							</tr>

						</table>
						</td>
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
</body>
</html>


<script language="JavaScript">
	function toadd(){
		window.location="orderinfo!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="orderinfo!delete.action?id="+document.form1.selectid.value;
							document.form1.submit();
						}
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.form1.action="orderinfo!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="orderinfo!batch.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="orderinfo!toedit.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="orderinfo!toedit.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
	
 function checkItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="orderinfo!tocheck.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="orderinfo!tocheck.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  // 详细信息展示
  function showItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="orderinfo!toshowgys.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="orderinfo!toshowgys.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
			
function unselectall()
{
    if(document.form1.all.checked){
	document.form1.all.checked = document.form1.all.checked&0;
    }
}

function selectall1()
{
    var length=document.form1.selectid.length;
    document.form1.all1.checked = document.form1.all1.checked|0;
  

   if ( length ==undefined &&  document.form1.selectid!=null ){
    	  document.form1.selectid.checked=document.form1.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.form1.selectid[i].checked = document.form1.all1.checked;
	      document.form1.getElementsByTagName("*").checked=document.form1.all1.checked;
       }
    }
}
//判断是否是外部订单，如果是外部订单则不能进行出票操作，如果是内部订单则进行自动出票
function isrrticket(policyid,orderid,agentname)
{
   if(policyid==3 || policyid==4 || policyid==5 || policyid==6)
   {
      alert("此订单政策供应商为--"+agentname+"\r\n\r\n正在等待票盟出票!");
   }
   else
   {
      if(confirm("您确定要执行出票操作吗？"))
      {
         rrticket(orderid);
      }
   }
}

</script>





