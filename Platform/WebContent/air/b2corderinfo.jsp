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
<%@page import="java.util.UUID"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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


<style>
fieldset {
    padding:10px;
    margin:5px;
    width:96%;
    color:#333; 
    border:#ccc dashed 1px;
} 
legend {
    color:#114F82;
    font-weight:800; 
    background:#fff;
} 
ul {
    list-style-type: none;
    margin:8px 0 4px 0;
} 
li {
    margin-top:4px;
}
</style>
<script language=”javascript”>
    function killErrors() {
    return true;
}
window.onerror = killErrors;



}
</script>
<script>

function accountprice(){
  $("td[id*='pprice']").each(function(i){
       var tickeprice=$("#price"+i).val();
       var fuelprice=$("#fuel"+i).val();
       var airprice=$("#air"+i).val();
       var anjian=0;
       var other=0;
       if(document.getElementById("anjian"+i)!=null){
       anjian=$("#anjian"+i).val();
        other=$("#other"+i).val();
       }
         var allprice=parseInt(converSpace(tickeprice))+parseInt(converSpace(fuelprice))+parseInt(converSpace(airprice))+parseInt(converSpace(anjian))+parseInt(converSpace(other));
       $("#pprice"+i).html(allprice);
       });
      }
       
   function converSpace(v){
    if(v==""||v==0){
    return 0;
    }else{
    return v;
    }
    }

Ext.onReady(function(){ 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,         
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:170,
	   tpl: "<tpl for='.'><div style='height:240px ; width:170px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  
	<ww:property value="deptstr"/>	
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue("<ww:property value="companyname"/>");
       tree.on('click',function(node){   
           
             comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            Ext.get('agentnameid').set({value:node.text});
            comboxWithTree.collapse();              
       });     	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().collapseChildNodes();//是否展开子菜单			
		});
	
    comboxWithTree.render('comboxWithTree'); 
});
</script>

<!-- 打印脚本 -->
<script language="javascript" type="text/javascript">    
function printChange(id){
jQuery.post("orderinfo!printChange.action",{orderid:id},function(){});
}
	function prn1_preview() {
	    $("#tbprint").show();
		CreateOneFormPage();
		LODOP.PREVIEW();	
		$("#tbprint").hide();
	};
	function prn1_print() {
	    $("#tbprint").show();			
		CreateOneFormPage();
		LODOP.PRINT();	
		$("#tbprint").hide();	
	};
	function prn1_printA() {		
		CreateOneFormPage();
		LODOP.PRINTA(); 	
	};	
	function CreateOneFormPage(){
		LODOP.PRINT_INIT("送票单打印");
        LODOP.SET_PRINT_PAGESIZE(1,2150,935,"");
		LODOP.ADD_PRINT_TABLE(2,10,750,830,document.getElementById("tbpreivew").innerHTML);
	};	
	//批量打印
	function prn1_all_print(cont) {			
		CreateOneFormPageAll(cont);
		LODOP.PRINT();	
	};
	function CreateOneFormPageAll(content){
		LODOP.PRINT_INIT("送票单批量打印");
        LODOP.SET_PRINT_PAGESIZE(1,2150,935,"");
		LODOP.ADD_PRINT_TABLE(2,10,750,830,content);
	};	
	//批量打印
	function printallitem(idvalues)
	{
	   var arr=idvalues.split(','); 
	   for(var i=0;i<arr.length-1;i++)
	   {
	   
	       //读取打印内容
	       $.ajax({
	         type:"POST",
	         url:"orderinfo!piliangdayin.action?rndmath="+Math.floor(Math.random()*100),
	         data:{strTuiOrderID:arr[i]},
	         beforeSend:function(){dispose('正在批量打印送票单...');},             
	         success:function(data){
	         prn1_all_print(data);
	         
	         }            
	         });
	   }
	   colsedispose();
	}
	//分离打印送票单
	function fenlidayin(orderid,pidvalues)
	{
	   var arr=pidvalues.split('|'); 
	   var index=0;
	   for(var i=0;i<arr.length-1;i++)
	   {
	      index++;
	      //读取打印内容
	       $.ajax({
	         type:"POST",
	         url:"orderinfo!piliangdayin.action?rndmath="+Math.floor(Math.random()*100),
	         data:{strTuiOrderID:orderid,s_songpaiodanpid:arr[i],s_Paindex:index},
	         beforeSend:function(){dispose('正在批量打印送票单...');},             
	         success:function(data){
	         prn1_all_print(data);
	         }            
	         });
	   }
	   colsedispose();
	}
	
	//打印退票单
	function printtuipiaodan(orderid,state)
	{
	//读取打印内容 state：1,废，2,退
	       $.ajax({
	         type:"POST",
	         url:"orderinfo!gettuipiaodan.action?rndmath="+Math.floor(Math.random()*100),
	         data:{strTuiOrderID:orderid,orderstate:state},
	         beforeSend:function(){dispose('正在打印...');},             
	         success:function(data){
	         prn1_all_print(data);
	         colsedispose();
	         }            
	         });
	}
	//批量打印退票单
	function piliangdayintuipiao(idvalues,state)
	{
	   //读取打印内容 state：1,废，2,退
	   var arr=idvalues.split(','); 
	   for(var i=0;i<arr.length-1;i++)
	   {
	       //读取打印内容
	       $.ajax({
	         type:"POST",
	         url:"orderinfo!gettuipiaodan.action?rndmath="+Math.floor(Math.random()*100),
	         data:{strTuiOrderID:arr[i],orderstate:state},
	         beforeSend:function(){dispose('正在批量打印送票单...');},             
	         success:function(data){
	         prn1_all_print(data);
	         colsedispose();
	         }            
	         });
	   }
	}
	
</script>
<!-- 打印脚本 --> 


<script>
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
	    var ddlreasonid=document.getElementById("ddlreason").value;
	       var iscabinsite=-1;
	       var rdoyes=document.getElementById("rdoyes").checked;
	       if(rdoyes==true)
	       {
	       		iscabinsite=0;
	       }else
	       {
	       		iscabinsite=1;
	       }
	       var tuifeidesc=encodeURI($("#tuifeidesc").val());
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=4&no=2&pr=2&passid='+passengerids+'&tui='+$("#txttuifee").val()+'&tui_state='+ddlreasonid+'&tui_iscabinsite='+iscabinsite+'&tui_tuifeidesc='+tuifeidesc;
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
	       var ddlreasonid=document.getElementById("ddlreason").value;
	       var iscabinsite=-1;
	       var rdoyes=document.getElementById("rdoyes").checked;
	       if(rdoyes==true)
	       {
	       		iscabinsite=0;
	       }else
	       {
	       		iscabinsite=1;
	       }
	       var tuifeidesc=encodeURI(document.getElementById("tuifeidesc").value);
	       var tuifee=document.getElementById("txttuifee").value;
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=5&no=2&pr=1&passid='+passengerids+'&tui_state='+ddlreasonid+'&tui_iscabinsite='+iscabinsite+'&tui_tuifeidesc='+tuifeidesc+'&tui='+tuifee;
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
       //判断手续费是否为空
       if($("#txttuifee").val()=="")
       {
          alert("请填写改签手续费用，请重新填写。如果没有手续费用请填写'0'！");
          return false;
       }
	    if(confirm('您确定要对选中的乘机人进行申请改签操作吗？'))
	    {
	       var ddlreasonid=document.getElementById("ddlreason").value;
	       var iscabinsite=-1;
	       var rdoyes=document.getElementById("rdoyes").checked;
	       if(rdoyes==true)
	       {
	       		iscabinsite=0;
	       }else
	       {
	       		iscabinsite=1;
	       }
	       var tuifeidesc=encodeURI(document.getElementById("tuifeidesc").value);
	       var changedate=encodeURI(document.getElementById("txtchangedate").value);
	       var changeflight=encodeURI(document.getElementById("txtchangeflight").value);
	       var changecabin=encodeURI(document.getElementById("txtchangecabin").value);
	       var changepnr=encodeURI(document.getElementById("txtchangepnr").value);
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=13&no=2&pr=1&passid='+passengerids+'&tui_state='+ddlreasonid+'&tui_iscabinsite='+iscabinsite+'&tui_tuifeidesc='+tuifeidesc+'&tui='+$("#txttuifee").val()+'&changedate='+changedate+'&changeflight='+changeflight+'&changecabin='+changecabin+'&changepnr='+changepnr;
	    }
     }
    
}

//点击申请升舱换开
function shengcangticket(id)
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
        alert("请至少选中一个要申请升舱换开的乘机人！");
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
       //判断手续费是否为空
       if($("#txttuifee").val()=="")
       {
          alert("请填写升舱换开手续费用，请重新填写。如果没有手续费用请填写'0'！");
          return false;
       }
       if($("#txtnewticnum").val()=="" && $("#txtorderpnr").val()=="")
       {
          alert("新PNR和新票号请至少填写一项！");
          return false;
       }
       var ordernumber=$("#txtordernumber").val();
       var newpnr=$("#txtorderpnr").val();
       var newticketnumber=$("#txtnewticnum").val();
       
       jQuery.post("orderinfo!ajaxValidateSCHK.action",{oldorderid:id,ordernum:ordernumber,orderpnr:newpnr,orderticket:newticketnumber},function(data){

       if(data==true||data=="true"){
	    if(confirm('您确定要对选中的乘机人进行申请升舱换开操作吗？'))
	    {
	       var tuifeidesc=encodeURI(document.getElementById("tuifeidesc").value);
	       var newordernum=encodeURI(document.getElementById("txtordernumber").value);
	       var newpnr=encodeURI(document.getElementById("txtorderpnr").value);
	       var newticnum=encodeURI(document.getElementById("txtnewticnum").value);
	       var url='orderinfo!editorderstatus.action?id='+id+'&orderstatus=30&no=2&pr=1&passid='+passengerids+'&strNewOrderID='+newordernum+'&tui_tuifeidesc='+tuifeidesc+'&tui='+$("#txttuifee").val()+'&strSepPNR='+newpnr+'&strNewTicNum='+newticnum;
	  
	       window.location.href=url;
	     }
	    }else{
	    alert(data);
	    }
       });
     }
    
}

function alltuifeiticket(id,index)
{
    if(index==1)
    {
      shenhefeiticket(id,1);
    }
    else if(index==2)
    {
       shenhetuiticket(id,1);
    }
    else if(index==3)
    {
       shenhegaiticket(id,1);
    }
}
//点击退票通过
function shenhetuiticket(id,passcount)
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
	    
	       if(parseInt(passcount)>1)
	       {
	            gopnrsep(id,4,2,passengerids);
	       }
	       else if(parseInt(passcount)==1)
	       {
	          window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=12&pr=2&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2';
	       }
	       
	    }
     }
    
}
//点击废票通过
function shenhefeiticket(id,passcount)
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
	       if(parseInt(passcount)>1)
	       {
	            //goEdit2('orderinfo!editorderstatus.action?id='+id+'&orderstatus=16&pr=4',id);
	            gopnrsep(id,4,1,passengerids);
	       }
	       else if(parseInt(passcount)==1)
	       {
	          window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=11&pr=1&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2';
	       }
	    }
     }
    
}
//点击改签通过
function shenhegaiticket(id,passcount)
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
	      if(parseInt(passcount)>1)
	       {
	            //goEdit2('orderinfo!editorderstatus.action?id='+id+'&orderstatus=16&pr=4',id);
	            gopnrsep(id,4,3,passengerids);
	       }
	       else if(parseInt(passcount)==1)
	       {
	         window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=14&pr=3&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2';
	       }
	    }
     }
    
}

//点击升舱换开通过
function shenheshengcangticket(id,passcount)
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
         alert("请至少选中一个要升舱换开的乘机人！");
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
	    if(confirm('您确定要对选中的乘机人进行升舱换开操作吗？'))
	    {
	      if(parseInt(passcount)>1)
	       {
	            //goEdit2('orderinfo!editorderstatus.action?id='+id+'&orderstatus=16&pr=4',id);
	            gopnrsep(id,4,14,passengerids);
	       }
	       else if(parseInt(passcount)==1)
	       {
	     
	         window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=25&pr=3&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+',<font color="red"><b>升舱换开订单，原机票申请全退</b></font>'+'&no=2';
	       }
	    }
     }
    
}

//点击升舱换开不通过
function noshenheshengcang(id)
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
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=26&pr=3&passid='+passengerids+'&no=2'+'&beizhu='+encodeURI($("#beizhu").val());
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
	  	   var tui_nodesc="";
	  	   var flag =document.getElementById("rdoyes").checked;
	  	   if(flag)
	  	   {
	  	   	tui_nodesc="废票时间已过";
	  	   }else
	  	   {
	  	   	tui_nodesc="其他原因";
	  	   }
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=17&pr=2&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2&tui_nodesc'+encodeURI(tui_nodesc);
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
	  	   var tui_nodesc="";
	  	   var flag =document.getElementById("rdoyes").checked;
	  	   if(flag)
	  	   {
	  	   	tui_nodesc="废票时间已过";
	  	   }else
	  	   {
	  	   	tui_nodesc="其他原因";
	  	   }
	       window.location.href='orderinfo!editorderstatus.action?id='+id+'&orderstatus=7&pr=1&passid='+passengerids+'&no=2'+'&beizhu='+encodeURI($("#beizhu").val())+'&tui_nodesc'+encodeURI(tui_nodesc);
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
var u =document.getElementById("hur").value;
window.location.href=u+'&tui='+da;       
           }
function goEdit2(ur,id)
{
	var h = ur.split("pr=");
	var h1 =h[1];
         if(h1==1){
 			$("#divpassenger").dialog({
		                title:'机票订单废票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 800,
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
		                width: 800,
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
		                width: 800,
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
		                width: 780,
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
		   
		   if(h1==5){
				
 			$("#divpassenger").dialog({
		                title:'审核机票改签订单',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 800,
		                height: 490
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
		   if(h1==14){
 			$("#divpassenger").dialog({
		                title:'审核机票升舱换开订单',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 490
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengersqList.action",
		            data:{strTuiOrderID:id,typ:14},
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
				ss = data.substr(0, 2); 
				if(ss == 'su'){
				var dealname=document.getElementById("hidname_"+id).value;
				alert("该订单已经正在被[["+dealname+"]]处理，您不能再处理了！");
				}
				
				if(ss == 'my'){
				if(h1==3){//改签
				//点击执行锁定订单操作
		        $("#divpassenger").dialog({
		                title:'机票订单改签处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
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
				if(h1==14){//升舱换开
				//点击执行锁定订单操作
		        $("#divpassenger").dialog({
		                title:'机票订单升舱换开处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:4},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
					
					return;
			
				}
				
				if(h1==2){
				

				//document.getElementById("d1").style.display="block";
				//document.getElementById("xie").style.display = "";
                //document.getElementById("content1").style.display = "";
			    //document.getElementById("xie").style.filter = "Alpha(Opacity=50)";//透明度
			    //document.getElementById("content1").innerHTML = "退票手续费:<input type='text' id='da' value='' /> <br /><input onclick='hi()' type='button' value='确定'/> <input onclick='hide()' type='button' value='取消'/>";
				//点击执行锁定订单操作
		        $("#divpassenger").dialog({
		                title:'机票订单退票处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 800,
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
		                width: 780,
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
		                width: 800,
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
				if(h1==4){
				 $("#divpassenger").dialog({
		                title:'机票订单退款处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getViewTuifei.action",
		            data:{strTuiOrderID:id,typ:4},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
				 return;
				}
				if(h1==6){
				 $("#divpassenger").dialog({
		                title:'机票订单废票退款处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getViewTuifei.action",
		            async:false,
		            data:{strTuiOrderID:id,typ:6},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
				 return;
				}
				if(h1==7){
				 $("#divpassenger").dialog({
		                title:'机票订单退票退款处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getViewTuifei.action",
		            async:false,
		            data:{strTuiOrderID:id,typ:7},
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
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            async:false,
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
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            async:false,
		            data:{strTuiOrderID:id,typ:3},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
					
					return;
				}
				if(h1==14){//升舱换开
				//点击执行锁定订单操作
		        $("#divpassenger").dialog({
		                title:'机票订单升舱换开处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:14},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
					
					return;
			
				}
				
				if(h1==5){//审核改签
		        $("#divpassenger").dialog({
		                title:'机票订单改签处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 800,
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
					
					return;
				}
				
				window.location.href=document.getElementById("hur").value;
				}
				
			}
		});
		
		

  // 
}
</script>

<script language="javascript"> 

function copyToClipboard(theField,isalert,id)
{
  var obj=document.getElementById(theField);
  if(obj!=null)
  {
    var clipBoardContent=obj.value;
    obj.select();
    window.clipboardData.setData("Text",clipBoardContent); 
    if(isalert!=false)
      alert("复制成功。现在您可以粘贴（Ctrl+v）到其他地方了。");
  }
  else
  {
     alert("Error!");
  }
}
  function rTPnr()
    {
       $.ajax({
            type:"POST",
            url:"orderinfo!rtPNRinfo.action",
            data:{strPNR:$("#txtpnrcode").val()},
            beforeSend:function(){$("#pnrinfo").html("<img src='images/loadpnr.gif' /><font color='00ff00'><b>正在加载PNR信息.....</b></font>");},             
            success:function(data){
            $("#pnrinfo").html(data);           
            }            
            });
       
    }
 function shownewpnr()
 {
    $("#span_newpnrinfo").show();
 }
 function sepratePnr(index)
 {
      if($("#txtxuhao").val()=="")
      {
          alert("乘机人在黑屏中的序号不能为空，请重新填写！");
          return false;
      }
      var fenlitype="1";
      if(document.getElementById("rdoheipingfenli").checked==true)
      {
         fenlitype="1";
      }
      else if(document.getElementById("rdobaipingfenli").checked==true)
      {
         fenlitype="2";
      }
      if(fenlitype=="2")
      {
          if($("#txtnewpnr").val()=="")
          {
              alert("请输入分离新PNR(小)!");
              $("#txtnewpnr").focus();
              return;
          }
          if($("#txtnewbigpnr").val()=="")
          {
              alert("请输入分离新PNR(大)!");
              $("#txtnewbigpnr").focus();
              return;
          }
      }

      $.ajax({
            type:"POST",
            url:"orderinfo!sepratePNR.action",
            async:false,
            data:{strSepPNR:$("#txtpnrcode").val(),strXuNumber:$("#txtxuhao").val(),s_newpassid:$("#hidpassengerid").val(),strTuiOrderID:$("#hidseporderid").val(),tuigaiindex:index,strfenliType:fenlitype,strNewPnr:$("#txtnewpnr").val(),strNewBigPnr:$("#txtnewbigpnr").val()},
            beforeSend:function(){$("#pnrinfo").html("<img src='images/loadpnr.gif' /><font color='00ff00'><b>正在分离PNR信息.....</b></font>");},             
            success:function(data){
            if(data!="")
            {
               alert("PNR分离成功，分离出来的新PNR为："+data);
            }  
            $("#pnrinfo").html(data);           
            }        
            });
      closedialog($("#hidseporderid").val());
      document.getElementById("btnsearch").click();
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
 
 //配送信息显示
 function shenqinghuankai(id)
 {
    $("#divpassenger").dialog({
		                title:'机票订单换开处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getHuanKai.action",
		            data:{strTuiOrderID:id,typ:1},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
 }
 function dohuankai(oldid)
 {
      var id=$("#txtordernumber").val();
      var pnr=$("#txtorderpnr").val();
      
      var newticnum=$("#txtnewticnum").val();
      $.ajax({
            type:"POST",
            url:"orderinfo!doHuanKai.action",
            async:false,
            data:{strTuiOrderID:oldid,strNewOrderID:id,strSepPNR:pnr,strNewTicNum:newticnum},
            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
            success:function(data){
            $("#divpassenger").html(data);
            }            
            });
          
      goEdit('orderinfo!editorderstatus.action?id='+oldid+'&orderstatus=30',oldid);
     
 }
 //开始收银
 function doshoukuan(id)
 {
     var fkmetho=$("#sid").val();
    var dvalue=$("#ddlemployeeid").val();
    if(fkmetho==7){
     goEdit("orderinfo!editorderstatus.action?id="+id+"&fkmethod="+fkmetho+"&guazhangrenid="+dvalue+"&orderstatus=10&s_employeeid="+$("#ddlemployeeid").val(),id);
    }else{
     goEdit("orderinfo!editorderstatus.action?id="+id+"&fkmethod="+fkmetho+"&orderstatus=10&s_employeeid="+$("#ddlemployeeid").val(),id);
    }
   
 }
 
 //收银操作
 function shouyin(id)
 {
 
     $("#divpassenger").dialog({
         title:'机票订单收银',
         show: null,
         bgiframe: false,
         autoOpen: false,
         draggable: true,                
         resizable: true,
         modal: true,
         width: 800,
         height: 480
     });
      $("#divpassenger").dialog("open");
      $.ajax({
         type:"POST",
         url:"orderinfo!doShoukuan.action",
         data:{strTuiOrderID:id},
         beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
         success:function(data){
         $("#divpassenger").html(data);  
            instance();         
         }            
         });
      
 }
 
 //配送信息显示
 function showpeisong(id)
 {
    $("#divpassenger").dialog({
		                title:'机票订单配送',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
		         $.ajax({
		            type:"POST",
		            url:"orderinfo!getPeisong.action",
		            anysc:false,
		            data:{strTuiOrderID:id},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
 }
 //打印送票单
 //弹出窗口
 function showprint()
 {
     $("#tbpeisonginfo").hide();
     $("#span_peisong").hide();
     
     $("#shouyininfo").hide();
     $("#tbprint").show();
     $("#tbbutton1").show();
     $("#tbbutton").show();
 }
 function showsend(id)
 {
    window.location.href='orderinfo!sendticketinfo.action?strTuiOrderID='+id;
 }
function showprint1()
 {
     $("#tbpeisonginfo").hide();
     $("#tbpassenger").hide();
     $("#tbpayinfo").hide();
     $("#tbcompanyinfo").hide();
     $("#tbprint").show();
 }
 function cancelprint1()
 {
    $("#tbpeisonginfo").show();
     $("#tbpassenger").show();
     $("#tbpayinfo").show();
     $("#tbcompanyinfo").show();
     $("#tbprint").hide();
     $("#tbbutton1").hide();
     $("#tbbutton").hide();
 }
 function cancelprint()
 {
    $("#tbpeisonginfo").show();
     $("#span_peisong").show();
     $("#tb").hide();
     $("#tbprint").hide();
     $("#tbbutton1").hide();
     $("#tbbutton").hide();
 }
 //配送
 function sendticket(id)
 {
      var sender=document.getElementById("ddlsender");
      var senderid=sender.options[sender.selectedIndex].value;
      $.ajax({
           type:"POST",
           url:"orderinfo!dealsendticket.action",
           async:false,
           data:{strTuiOrderID:id,strSenderID:senderid,strSenderDate:$("#txtsendtime").val()},        
           success:function(data){
            alert(data);      
           }            
      });
      //更新订单状态为在途订单
      goEdit('orderinfo!editorderstatus.action?id='+id+'&orderstatus=28',id); 
      closedialog(id);
      document.getElementById("btnsearch").click();
 }
 //换开审核
 function huankaishenhe(id)
 {
      $("#divpassenger").dialog({
		                title:'机票换开审核',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 800,
		                height: 480
		            });
		         $("#divpassenger").dialog("open");
     $.ajax({
           type:"POST",
           url:"orderinfo!getHuanKai.action",
           data:{strTuiOrderID:id,typ:2},
           beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
           success:function(data){
           $("#divpassenger").html(data);           
           }            
           });
 }
 
 function shenhehuankaitongguo(id)
 {
   goEdit('orderinfo!editorderstatus.action?id='+id+'&orderstatus=24',id);
 }
 //显示查看订单按钮
 function showbtnview()
 {
    $("#btnview").show();
 }
 //查看订单详细信息
 function showorderinfo()
 {
    //var ordertempid=$("#txtordernumber").val().substring(1,$("#txtordernumber").val().length);
    //ordertempid=parseInt(ordertempid)-10000;
    //window.location.href='orderinfo!toshowb2c.action?id='+ordertempid;
    if($("#txtordernumber").val()=="")
    {
        alert("如果要提取订单信息，新订单号不能为空，请重新输入!");
        $("#txtordernumber").focus();
        return;
    }
 }
 //打印
function preview() 
{
 var bodyhtml=window.document.body.innerHTML;
 window.document.body.innerHTML=$("#tbpreivew").html();
 $("#trbutton").hide();
 window.print();
 window.document.body.innerHTML=bodyhtml;
 $("#trbutton").show();
 window.location.href= window.location.href;
}
//取消订单
function cancelorder(id)
{
$.ajax({
     type:"POST",
     url:"orderinfo!lockorder.action",
     data:{strTuiOrderID:id}, 
     async:false,   
     success:function(data){
       if(data!="")
       {
         alert("此订单正在被"+data+"处理,您现在不能对订单进行处理！");
       }
       else
       {
          if(confirm('您确定要执行取消订单操作吗？'))
		   {
		     goEdit('orderinfo!editorderstatus.action?id='+id+'&orderstatus=6',id);
		   }
       }      
       }          
     });
  
}
//暂不能出票
function zanbunengchupiao(id)
{
   if(isOperateing(id)){
  
  if(confirm('您确定要执行暂不能出票操作吗？'))
  {
    goEdit('orderinfo!editorderstatus.action?id='+id+'&orderstatus=16',id);
  }
  }
}
//废票退款
function feipiaotuikuan(id,desc,iswebtui)
{
  if(iswebtui==1)
  {
    document.formpay.action="../lthk_interface/Billpayordertui";
    document.formpay.submit();
  }
  else
  {
	 if(confirm('您确定要执行废票退款成功操作吗？'))
	 {
	 
	   goEdit('orderinfo!editorderstatus.action?id='+id+'&orderstatus=9&strTuikuanDesc='+encodeURI(desc),id);
	 } 
  }
}
//退票退款
function tuipiaotuikuan(id,desc,iswebtui)
{  
  
  if(confirm('您确定要执行退票退款成功操作吗？'))
  {    
    goEdit('orderinfo!editorderstatus.action?id='+id+'&orderstatus=18&strTuikuanDesc='+encodeURI(desc),id);
  } 
}

//PNR分离按钮
function gopnrsep(id,type,tuigaiindex,passid)
{
  $("#divpassenger").dialog({
      title:'机票订单PNR分离',
      show: null,
      bgiframe: false,
      autoOpen: false,
      draggable: true,                
      resizable: true,
      modal: true,
      width: 780,
      height: 450
  });
  $("#divpassenger").dialog("open");
  //读取订单乘机人信息
  $.ajax({
     type:"POST",
     url:"orderinfo!getPassengersqListsep.action",
     data:{strTuiOrderID:id,typ:4,tuigaiindex:tuigaiindex,passids:passid},
     beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
     success:function(data){
     $("#divpassenger").html(data);           
     }            
     });
}

function isOperateing(id){
var ret=false;
 $.ajax({
     type:"POST",
     url:"orderinfo!isLocked.action",
     data:{strTuiOrderID:id}, 
     async:false,     
     success:function(data){
      if(data!="")
      {
          alert("此订单正在被"+data+"处理,您现在不能对订单进行处理！");
          closedialog(0);
        //  window.location.reload();
       
          ret=false;
      }else{
    
      ret=true;
       }
     }
    });
   
    return ret;
}
function rrticket(id)
{ //点击执行锁定订单操作  
 $.ajax({
     type:"POST",
     url:"orderinfo!lockorder.action",
     data:{strTuiOrderID:id}, 
     anysc:false,      
     success:function(data){
      if(data!="")
      {
          alert("此订单正在被"+data+"处理,您现在不能对订单进行处理！");
          closedialog(0);
      }else{
   
  $("#divpassenger").dialog({
      title:'立即出票操作-填写票号',
      show: null,
      bgiframe: false,
      autoOpen: false,
      draggable: true,                
      resizable: true,
      modal: true,
      width:900,
      height: 450
  });
  $(".ui-dialog-titlebar-close").hide();
  $("#divpassenger").dialog("open");
  $.ajax({
     type:"POST",
     url:"orderinfo!lockorder.action",
     data:{strTuiOrderID:id}, 
     async:false,   
     success:function(data){
       if(data!="")
       {
         alert("此订单正在被"+data+"处理,您现在不能对订单进行处理！");
       }
       else
       {
          $("#divpassenger").dialog({
	      title:'立即出票操作-填写票号',
	      show: null,
	      bgiframe: false,
	      autoOpen: false,
	      draggable: true,                
	      resizable: true,
	      modal: true,
	      width:900,
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
       }            
     });
      }
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
	      
	       window.location.href='http://www.google.com';
	    }          
    });
   
}
function gaiqi()
{
   $("#trchangecangwei").hide();
   $("#trchangehangban").hide();
   $("#trchangedate").show();
}
function shengcai()
{
   $("#trchangecangwei").show();
   $("#trchangehangban").show();
   $("#trchangedate").hide();
}
function showmoresearch(index)
{
    if(index==1)
    {
	    $("tr[id*='trmoresearch_']").each(function(i)
	    {
	       $(this).show();
	    }
	    );
    }
    else
    {
       $("tr[id*='trmoresearch_']").each(function(i)
	    {
	       $(this).hide();
	    }
	    );
    }
}
$(document).ready(function() {
  var LODOP=document.getElementById("LODOP");//这行语句是为了符合DTD规范
  <ww:if test="s_send==1 || s_orderstatus==28 || s_money==1 || s_orderstatus==18 || s_orderstatus==9">
	  CheckLodop();
  </ww:if>
  $('#searchmore').toggle(function() {
  showmoresearch(1);
  $('#searchmore').html("-点击查看更多查询条件");
}, function() {
  showmoresearch(0);
  $('#searchmore').html("+点击查看更多查询条件");
});
});

</script>
</head>
<body>

<form name="form1" method="post" action="orderinfo!tob2c.action">
<div id="divpassenger" style="text-align:center;display:none; background-color:#fff;left:0px;">正在加载订单信息...
</div>
<div id="member">
<input type="hidden" name="s_cashier" value="<ww:property value="s_cashier"/>" />

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;机票订单查询</span></b></td>
	</tr>
	<tr>
		<td valign="top" >

        
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="100%" border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td>
                                <input type="text" id="divallprint" value="" style="display:none" />
								<table class="table2" width="100%" border="0">
									<tr>
										<td width="100%" height="29" colspan="8"
											background="images/jb.gif"
											style="border-bottom: 1px solid #99CBED"><span
											class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;订单管理-订单查询</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="searchmore" onclick="showmoresearch();" style="cursor:pointer">+点击查看更多查询条件</span></td>
									</tr>
									
									<tr id="trmoresearch_1" style="display:none">
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">联系人姓名</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_contactname" type="text" id="s_contactname" style="width: 138px;"
											value="<ww:property value="s_contactname"/>" /></td>
									    <td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">预订人姓名</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_bookername" type="text" id="s_bookername" style="width: 138px;"
											value="<ww:property value="s_bookername"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">出票人姓名</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_chupiaoname" type="text" id="s_chupiaoname" style="width: 138px;"
											value="<ww:property value="s_chupiaoname"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">废票申请人员</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_feipiaoshenqingren" type="text" id="s_feipiaoshenqingren" style="width: 138px;"
											value="<ww:property value="s_feipiaoshenqingren"/>" /></td>
										
									</tr>
									<tr id="trmoresearch_2" style="display:none">
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">废票申请时间</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_feipiaoshenqingsdate" type="text" id="s_feipiaoshenqingsdate" style="width: 138px;"
											value="<ww:property value="s_feipiaoshenqingsdate"/>" /></td>
									    <td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_feipiaoshenqingedate" type="text" id="s_feipiaoshenqingedate" style="width: 138px;"
											value="<ww:property value="s_feipiaoshenqingedate"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">废票审核时间</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_feipiaoshenhesdate" type="text" id="s_feipiaoshenhesdate" style="width: 138px;"
											value="<ww:property value="s_feipiaoshenhesdate"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_feipiaoshenheedate" type="text" id="s_feipiaoshenheedate" style="width: 138px;"
											value="<ww:property value="s_feipiaoshenheedate"/>" /></td>
										
									</tr>
									<tr id="trmoresearch_3" style="display:none">
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">废票审核人员</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_feipiaoshenheren" type="text" id="s_feipiaoshenheren" style="width: 138px;"
											value="<ww:property value="s_feipiaoshenheren"/>" /></td>
									    <td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">退票申请人员</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_tuipiaoshenqingren" type="text" id="s_tuipiaoshenqingren" style="width: 138px;"
											value="<ww:property value="s_tuipiaoshenqingren"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">改签申请时间</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_gaiqianshenqingsdate" type="text" id="s_gaiqianshenqingsdate" style="width: 138px;"
											value="<ww:property value="s_gaiqianshenqingsdate"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_gaiqianshenqingedate" type="text" id="s_gaiqianshenqingedate" style="width: 138px;"
											value="<ww:property value="s_gaiqianshenqingedate"/>" /></td>
										
									</tr>
								
									<tr id="trmoresearch_5" style="display:none">
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">退票审核人员</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_tuipiaoshenheren" type="text" id="s_tuipiaoshenheren" style="width: 138px;"
											value="<ww:property value="s_tuipiaoshenheren"/>" /></td>
									    <td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">退票审核时间</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_tuipiaoshenhesdate" type="text" id="s_tuipiaoshenhesdate" style="width: 138px;"
											value="<ww:property value="s_tuipiaoshenhesdate"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_tuipiaoshenheedate" type="text" id="s_tuipiaoshenheedate" style="width: 138px;"
											value="<ww:property value="s_tuipiaoshenheedate"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">改签申请人员</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_gaiqianshenqingren" type="text" id="s_gaiqianshenqingren" style="width: 138px;"
											value="<ww:property value="s_gaiqianshenqingren"/>" /></td>
										
									</tr>
									<tr id="trmoresearch_6" style="display:none">
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">改签审核人员</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_gaiqianshenheren" type="text" id="s_gaiqianshenheren" style="width: 138px;"
											value="<ww:property value="s_gaiqianshenheren"/>" /></td>
									    <td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">改签审核时间</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_gaiqianshehesdate" type="text" id="s_gaiqianshehesdate" style="width: 138px;"
											value="<ww:property value="s_gaiqianshehesdate"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_gaiqiansheheedate" type="text" id="s_gaiqiansheheedate" style="width: 138px;"
											value="<ww:property value="s_gaiqiansheheedate"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">升舱申请人员</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_shengcangshenqingren" type="text" id="s_shengcangshenqingren" style="width: 138px;"
											value="<ww:property value="s_shengcangshenqingren"/>" /></td>
										
									</tr>
									<tr id="trmoresearch_7" style="display:none">
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">升舱申请时间</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_shengcangshenqingsdate" type="text" id="s_shengcangshenqingsdate" style="width: 138px;"
											value="<ww:property value="s_shengcangshenqingsdate"/>" /></td>
									    <td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_shengcangshenqingedate" type="text" id="s_shengcangshenqingedate" style="width: 138px;"
											value="<ww:property value="s_shengcangshenqingedate"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">升舱审核人员</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_shengcangshenheren" type="text" id="s_shengcangshenheren" style="width: 138px;"
											value="<ww:property value="s_shengcangshenheren"/>" /></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap"></td>
										<td align="right" style="width: 15%; height: 26px;"></td>
										
									</tr>
									<tr id="trmoresearch_8" style="display:none">
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">升舱审核时间</td>
										<td align="right" style="width: 15%; height: 26px;"><input onfocus="WdatePicker()"
											name="s_shengcangshenhesdate" type="text" id="s_shengcangshenhesdate" style="width: 138px;"
											value="<ww:property value="s_shengcangshenhesdate"/>" /></td>
									    <td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap">至</td>
										<td align="left" colspan="4" style="width: 15%; height: 26px;">&nbsp;&nbsp;&nbsp;&nbsp;<input onfocus="WdatePicker()"
											name="s_shengcangshenheedate" type="text" id="s_shengcangshenheedate" style="width: 138px;"
											value="<ww:property value="s_shengcangshenheedate"/>" /></td>
									</tr>
									
									<!-- 更多查询条件结束 -->
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

										<td align="right" style="width: 9%; height: 26px;"
											nowrap="nowrap">订单状态</td>
										<td align="right" style="width: 16%; height: 26px;"><select
											name="s_orderstatus" id="s_orderstatus" style="width: 142px;">
											<option
												<ww:if test="s_orderstatus==null">selected="selected"</ww:if>>所有状态</option>
											
											<option value="1"
												<ww:if test="s_orderstatus==1">selected="selected"</ww:if>>等待支付</option>
											<option value="2"
												<ww:if test="s_orderstatus==2">selected="selected"</ww:if>>支付成功</option>
											<option value="3"
												<ww:if test="s_orderstatus==3">selected="selected"</ww:if>>出票完成</option>
											<option value="4"
												<ww:if test="s_orderstatus==4">selected="selected"</ww:if>>申请退票</option>
											
											<option value="5"
												<ww:if test="s_orderstatus==5">selected="selected"</ww:if>>申请废票</option>
											<option value="6"
												<ww:if test="s_orderstatus==6">selected="selected"</ww:if>>取消订单</option>
											<option value="7"
												<ww:if test="s_orderstatus==7">selected="selected"</ww:if>>废票不成功</option>
											<option value="8"
												<ww:if test="s_orderstatus==8">selected="selected"</ww:if>>审核失败</option>
											<option value="9"
												<ww:if test="s_orderstatus==9">selected="selected"</ww:if>>废票退款成功</option>
											<option value="10"
												<ww:if test="s_orderstatus==10">selected="selected"</ww:if>>订单关闭</option>
											<option value="11"
												<ww:if test="s_orderstatus==11">selected="selected"</ww:if>>已经废票</option>
											<option value="12"
												<ww:if test="s_orderstatus==12">selected="selected"</ww:if>>已经退票</option>
											<option value="13"
												<ww:if test="s_orderstatus==13">selected="selected"</ww:if>>申请改签</option>
											<option value="14"
												<ww:if test="s_orderstatus==14">selected="selected"</ww:if>>已经改签</option>
											<option value="15"
												<ww:if test="s_orderstatus==15">selected="selected"</ww:if>>改签失败</option>
											<option value="16"
												<ww:if test="s_orderstatus==16">selected="selected"</ww:if>>暂不能出票</option>
											<option value="17"
												<ww:if test="s_orderstatus==17">selected="selected"</ww:if>>退票不成功</option>
											<option value="18"
												<ww:if test="s_orderstatus==18">selected="selected"</ww:if>>退票退款成功</option>
											<option value="28"
											<ww:if test="orderinfo.orderstatus==28||s_orderstatus==28">selected="selected"</ww:if>>在途订单</option>
											<option value="29"
												<ww:if test="orderinfo.orderstatus==29||s_orderstatus==29">selected="selected"</ww:if>>待收银</option>
											<option value="23"
												<ww:if test="orderinfo.orderstatus==23">selected="selected"</ww:if>>申请升舱换开</option>
											<option value="25"
												<ww:if test="orderinfo.orderstatus==25">selected="selected"</ww:if>>升舱换开成功</option>
											<option value="26"
												<ww:if test="orderinfo.orderstatus==26">selected="selected"</ww:if>>升舱换开失败</option>
										</select></td>




										<ww:if test="s_send==1">
										<td align="right" style="width: 9%; height: 26px;">配送人：</td>
										<td align="right" style="width: 9%; height: 26px;">
										
											<select name="s_peisongren" style="width: 142px;">
											       <option value="-1">--请选择配送人--</option>
											    <ww:iterator value="listSender">
											       <option value="<ww:property value="id"/>"><ww:property value="name"/></option>
											    </ww:iterator>
											</select>
										</td>
										</ww:if>
										<td align="right" style="width: 9%; height: 26px;"></td>
										<td align="right" style="width: 9%; height: 26px;">
										
										</td>
									</tr>
									<ww:if test="s_send==1">
									<tr>
										<td align="right" style="width: 9%; height: 26px;"
											nowrap="nowrap">配送时间&nbsp;</td>
										<td align="right" style="width: 16%; height: 26px;"><input
											name="s_peisongsdate" type="text"
											value="<ww:property value="s_peisongsdate"/>"
											id="s_peisongsdate" onfocus="WdatePicker()"
											style="width: 138px;" /></td>
										<td align="right" style="width: 10%; height: 26px;">至</td>
										<td align="right" style="width: 15%; height: 26px;"><input
											name="s_peisongedate" type="text"
											value="<ww:property value="s_peisongedate"/>"
											id="s_peisongedate" onfocus="WdatePicker()"
											style="width: 138px;" /></td>
											<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap"></td>
										<td align="right" style="width: 15%; height: 26px;"></td>
										<td align="right" style="width: 6%; height: 26px;"
											nowrap="nowrap"></td>
										<td align="right" style="width: 15%; height: 26px;"></td>
									</tr>
									</ww:if>
									<tr>
									
				<td align="right" style="width: 6%; height: 26px;" >支付方式</td>
					<td align="right" style="width: 15%; height: 26px;">
					<select name="s_paymethods" style="width: 140px">
						    <option value="0"></option>
							<ww:iterator value="getPaymethodMap()" >
							<option value="<ww:property value="key"/>" <ww:if test="s_paymethods==key">selected="selected"</ww:if> ><ww:property value="value"/></option>
							</ww:iterator>
					</select>
					
					</td>
				<td align="right">客户名称</td>
				<td colspan="2" style="padding-left: 10px">			
				     <span style="HEIGHT: 71px"> 
						 <table border="0" cellspacing="0" cellpadding="0">
						 <tr>
						 <td><div id='comboxWithTree' style=""></div>
						</td>
						<td> 
						<input type="hidden" id="agentnameid" name="companyname" value="<ww:property value="companyname"/>" />
						<input type="text"  style="width:0px;border: 0px" id="parentid" name="s_customeragentid" value="<ww:property value="s_customeragentid"/>"  />
						</td>
						<td><span class="font-red">&nbsp;&nbsp;&nbsp;</span>
						</td>						
						</tr></table>			
				    </td>
					
									</tr>
									<tr>

										<td colspan="10" align="center"><input type="submit"
											class="button_d font-white" id="btnsearch"
											value="查询订单" />
											</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td align="right">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="40" align="center">
										<div align="right">
										  <ww:if test="checkright('b2corderedit')">
										<a href="#" onclick='updateOrder("orderinfo!toeditb2c.action?id=")'><input
											type="button" value="修改" class="button_h font-red" /></a>
										</ww:if>											
										&nbsp;&nbsp;										
										<a href="#" onclick="showItem()">
										<input type="button" value="查看" class="button_h font-red" /></a>
										&nbsp;&nbsp;
										<ww:if test="checkright('recinsure')">
										<a href="#" onclick='updateItem("insuranceinfo!toaddinsurance.action?orderId=")'>
										<input type="button" value="录入保险" class="button_h font-red" /></a>
										</ww:if>
										&nbsp;&nbsp;
										<ww:if test="s_send==1 ||s_orderstatus==29||s_orderstatus==28 || s_cashier==1" >
										<a href="#" onclick='printItem()'><input
											type="button" value="批量打印" class="button_h font-red" /></a>
										</ww:if>
										<ww:if test="s_orderstatus==12" >
										<a href="#" onclick='printItemtuipiao(2);'><input
											type="button" value="批量退票单" class="button_h font-red" /></a>
										</ww:if>
										<ww:elseif test="s_orderstatus==11" >
										<a href="#" onclick='printItemtuipiao(1);'><input
											type="button" value="批量废票单" class="button_h font-red" /></a>
										</ww:elseif>

										</div>
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
												type="checkbox" name="all1" value="1" onclick="selectall1()" /><b>全选</b></th>
											<th class="table_color"><b>订单编号</b></th>
											<ww:if test="s_orderstatus==3 || s_orderstatus==16 || s_orderstatus==11 || s_orderstatus==12 || s_orderstatus==14 ||s_busystatus==1">
											</ww:if>
											<ww:else>
											<th class="table_color"><b>紧急状态</b></th>
											</ww:else>
											<th class="table_color"><b>乘机人</b></th>
											<th class="table_color"><b>行程</b></th>
											<th class="table_color"><b>航班号</b></th>
											<th class="table_color"><b>PNR</b></th>
											<th class="table_color"><b>起飞时间/预订时间</b></th>
											<!--
											<th class="table_color">联系人姓名</th>
											<th class="table_color">PNR</th>
											
											
										
											<th class="table_color">总价</th>
											
											<th class="table_color">票号</th>
											
											<th class="table_color">订单类型</th>-->
											
											<th class="table_color"><b>支付方式</b></th>
											<th class="table_color"><b>订单状态</b></th>
											<ww:if test="s_orderstatus==11||s_orderstatus==12||s_orderstatus==9||s_orderstatus==18">
											<th class="table_color"><b>票号</b></th>											
											<th class="table_color"><b>废/退票费</b></th>
											</ww:if>
											<ww:else>
											<th class="table_color"><b>支付状态</b></th>											
											<th class="table_color"><b>处理人</b></th>
											</ww:else>
											
											<ww:if test="s_orderstatus==28">
											<th class="table_color"><b>配送员</b></th>
											</ww:if>
											<ww:if test="s_send==1||s_orderstatus==28||s_orderstatus==29||s_cashier==1">
											<th class="table_color"><b>集团名称</b></th>
											</ww:if>
											<th class="table_color"><b>操作</b></th>
											
										</tr>
										<ww:iterator value="listOrderinfo">
											<ww:set name="segmentinfoss" scope="webwork"
												value="getSegmentinfo(id)" />
											<tr   id="<ww:property value="id"/>" align="center" cashier="<ww:property value="cashier"/>"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color color_b3" ><input type="checkbox" 
													name="selectid" value="<ww:property value="id"/>" /></td>
												<td class="table_color color_b3">
												
												<ww:if test="#session.ListAgid.indexOf('10042')>=0">
												<a href="orderinfo!toshowb2c.action?id=<ww:property value="id"/>" <ww:if test="isprint==1">style="color:#cccccc"</ww:if> >
																				
												<ww:property value="ordernumber" />
													
													</a>
													<br /><ww:if test="shengcangorderid!=null && totalairportfee==0.0 && totalfuelfee==0.0"><font color='red'>(升舱补差)</font></ww:if>
													<br /><ww:if test="shengcangorderid!=null"><font color='red'>(<ww:property value="getOrdernumberbyid(shengcangorderid)" />)</font></ww:if>
													      <ww:else><font color='red'>(关联订单)<br />(<ww:property value="getexcorderid(id)" />)</font></ww:else>
												</ww:if>
												<ww:else>
												<a <ww:if test="isprint==1">style='color:#cccccc'</ww:if> href="javascript: goEdit('orderinfo!toshowb2c.action?id=<ww:property value="id"/>','<ww:property value="id"/>');">
												<ww:property
													value="ordernumber" /></a>
													<br /><ww:if test="shengcangorderid!=null && totalairportfee==0.0 && totalfuelfee==0.0"><font color='red'>(升舱补差)</font></ww:if>
													<br /><ww:if test="shengcangorderid!=null"><font color='red'>(<ww:property value="getOrdernumberbyid(shengcangorderid)" />)</font></ww:if>
													      <ww:else><ww:if test='getexcorderid(id).equlas("")'><font color='red'>(关联订单)<br />(<ww:property value="getexcorderid(id)" />)</font></ww:if></ww:else>
												</ww:else>
												<ww:property value="getSendImage(orderstatus,converNull(receipt,0))"/>
												</td>
												<ww:if test="s_orderstatus==3 || s_orderstatus==16 || s_orderstatus==11 || s_orderstatus==12 || s_orderstatus==14 ||s_busystatus==1">
												</ww:if>
												<ww:else>
												<td class="table_color color_b3" style="color:red">
												<ww:if test="busystatus==1"><img src="images/xingxing.gif" alt="紧急" /><b>紧急</b></ww:if>
												<ww:elseif test="busystatus==2"><img src="images/kongxing.gif" alt="一般" /><b>一般</b></ww:elseif>
												<ww:elseif test="busystatus==3"><img src="images/leaf.gif" alt="待定" /><b>待定</b></ww:elseif>
												</td>
												</ww:else>
													
													<!-- 乘机人姓名 -->
												<td class="table_color color_b3"><ww:property
													value="getPassengerName(id)" /></td>
													
												<td class="table_color color_b3"><ww:property
													value="getCitynameByAirport(getSegmentinfo(id).startairport)" />
												- <ww:property
													value="getCitynameByAirport(getSegmentinfo(id).endairport)" />
												</td>
												
												<td class="table_color color_b3"><ww:property value="#segmentinfoss.flightnumber"/></td>
												<td class="table_color color_b3">
												<ww:if test="pnr!=null">
												<a href="#" onclick="copyToClipboard('txtpnr_<ww:property value="id"/>',true,'<ww:property value="id"/>');return false;"><ww:property value="pnr"/></a><input id='txtpnr_<ww:property value="id"/>' style="display:none" type="text" value="<ww:property value="pnr"/>" />(小)<br />
												</ww:if>
												<ww:if test="bigpnr!=null">
												<a href="#" onclick="copyToClipboard('txtbigpnr_<ww:property value="id"/>',true,'<ww:property value="id"/>');return false;"><ww:property value="bigpnr"/></a><input id='txtbigpnr_<ww:property value="id"/>' style="display:none" type="text" value="<ww:property value="bigpnr"/>" />(大)
												</ww:if></td>
												<td class="table_color color_b3">
												<ww:property value="formatTimestamptoMinute(#segmentinfoss.departtime)"/><br /><ww:property
													value="formatTimestamptoMinute(createtime)" /></td>
												<!--<td class="table_color color_b3"><ww:property
													value="contactname" /></td>
												<td class="table_color color_b3"><ww:property value="pnr" /></td>
												
												
												
											<td class="table_color color_b3"><ww:property value="formatMoney(totalticketprice)"/></td>
												<td class="table_color color_b3"><ww:property value="formatMoney(getorderpricesum(id))"/></td>
												
												
												
												<td class="table_color color_b3"><ww:property
													value="getPassengerFEThtml(id)" /></td>
												<td class="table_color color_b3">
												<ww:if test="ordertype==1">网站预订</ww:if>
												<ww:if test="ordertype==2">后台预订</ww:if>
												<ww:if test="ordertype==3">同行预订</ww:if>
												<ww:if test="ordertype==4">团队订单</ww:if>
												<ww:if test="ordertype==5">K位订单</ww:if>
												<ww:if test="ordertype==6">呼叫中心</ww:if>
												</td>-->
												<td class="table_color color_b3">
												<ww:property value="getPayMethodStr(paymethod)"/>
												</td>
												<td class="table_color color_b3"><ww:property
													value="getStateToString(orderstatus)" /></td>
										<ww:if test="s_orderstatus==11||s_orderstatus==12||s_orderstatus==9||s_orderstatus==18">
										<td class="table_color color_b3"><ww:property
													value="getTicketnumByOrderid(id)" /></td>
										<td class="table_color color_b3"><ww:property
													value="getTuifeeByOrderid(id)" /></td>
										</ww:if>
										<ww:else>
										<!-- 支付状态 -->
										 <td class="table_color color_b3"><ww:property value="getPayMethod(paystatus)" /></td>
												<!-- 处理人 -->
											<td class="table_color color_b3">												
												<ww:if test="operatingstate>0">
														<ww:if test="seachfxs(id)==1">
															<img src="images/Unlocked.png" border="0" />
														</ww:if>
														<ww:elseif test="seachfxs(id)==2">
														<img src="images/Lock.png" border="0" /><br /><ww:property value="getusername(userid)"/><input type="hidden" id='hidname_<ww:property value="id" />' value='<ww:property value="getusername(userid)"/>' />
														</ww:elseif>
														<ww:else>
														<img src="images/Lock.png" border="0" /><br /><ww:property value="getusername(userid)"/><input type="hidden" id='hidname_<ww:property value="id" />' value='<ww:property value="getusername(userid)"/>' />
														</ww:else>
												</ww:if>
												<ww:else>
												<img src="images/Unlocked.png" border="0" />
												</ww:else>
											</td>
											</ww:else>
											<!-- !处理人结束 -->
											  <ww:if test="s_orderstatus==28"><!-- 配送begin -->
											    <td class="table_color color_b3">
											     <ww:if test="peisongrenid!=null">
											    <ww:property value="getusername(peisongrenid)" />
											    </ww:if>
											    </td>
											   </ww:if><!-- 配送那个end -->
											    
											    <ww:if test="s_send==1||s_orderstatus==28||s_orderstatus==29||s_cashier==1"><!-- 集团客户 -->
											    <td class="table_color color_b3">
											    <ww:property value="getcususeragentsname(customeruserid)" />
											    </td>
											     </ww:if>
											    
											    
											   
												
												<td class="table_color color_b3">
												<!-- 订单操作开始 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭11.已经废票12.已经退票13.申请改签14.已经改签 -->
												
											   <ww:if test="orderstatus==27">
											    <ww:if test="checkright('b2cdingdanqueren')">
												<input type="button" class="button108" id="btnCancel" value="订单确认"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=2','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:if test="checkright('b2cquxiaodingdan')">
												<input type="button" class="button108" id="btnCancel" value="取消订单"  onclick="cancelorder(<ww:property value="id" />);" /><br/>
												</ww:if>
												</ww:if>
												<!-- 包含票到付款 -->
											    <ww:if test="orderstatus==2||(orderstatus==1&&paymethod==3)">
											    <ww:if test="checkright('b2cchupiao')">
												<input type="button" class="button108" id="btnCancel" value="立即出票"  onclick="rrticket(<ww:property value="id" />);" /><br/>
												</ww:if>
												<ww:if test="checkright('b2czanbunengchupiao')">
												<input type="button" class="button108" id="btnCancel" value="暂不能出票"  onclick="zanbunengchupiao(<ww:property value="id" />);" /><br/>
												</ww:if>
												</ww:if>
												<!--<ww:if test="getPassengerNum(id)>1">
												<ww:if test="checkright('b2cpnrfenli')">
												<input type="button" class="button108" id="btnSpearate" value="PNR分离"  onclick="goEdit2('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=16&pr=4','<ww:property value="id" />')" /><br/>
												</ww:if>
												</ww:if>-->
												
												<ww:if test="orderstatus==28">
											    <ww:if test="checkright('b2cyipeisong')">
												<input type="button" class="button108" id="btnCancel" value="转到收银"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=29','<ww:property value="id" />')" /><br/>
												</ww:if>
												</ww:if>
												
												<!-- 
												
												//乘机人票状态 0=未出票 1=已出票 2=已废票 3=已退票4=申请退票5=申请废票6=申请改签7=退票失败8=

	                                         //废票失败9=改签成功10=改签失败11=已取消12=已分离13=申请升舱换开14=升舱换开成功15=升舱换开失败
	                                         
	                                         
	                                        //订单状态 1:等待支付;2 等待出票;3 出票完成";4申请退票";5申请废票";6取消订单";7废票不成功";8审核失败";9废票退款成功";10 订单完成";11已经废票";
                                            //12已经退票";13申请改签";14已经改签";15改签失败";16暂不能出票";17退票不成功";18退票退款成功";19问题订单";23申请升舱";24已换开";
		                                    //25升舱换开成功";
                                            //26升舱失败";27待确认";28在途订单";29待收银";30申请换开";
												
												
												 -->
												
												<!-- 订单已关闭 -->
												<!-- (老朱要求，hanmh改)在途订单 订单“废票不成功”、“退票不成功”、“改签不成功”、“升舱换开不成功”状态下应仍然可以“申请废票”（当日内）、“申请退票”、“申请改签”、“申请升舱换开” -->
												<ww:if test="orderstatus==10||orderstatus==7||orderstatus==17||orderstatus==15||orderstatus==26||orderstatus==28">
												<ww:if test="checkright('b2cshenqingfeipiao')">
												<ww:if test="checkFeiPiaoValite(printtime)">
												<input type="button" class="button108" id="btnRRTicket" value="申请废票"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=5&pr=1','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:else>
												 <span style="color:red">废票时间已过<br /></span>
												</ww:else>
												</ww:if>
												<ww:if test="checkright('b2cshenqingtuipiao')">
												<input type="button" class="button108" id="btnRRTicket" value="申请退票"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=4&pr=2','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:if test="checkright('b2cshenqinggaiqian')">
												<input  type="button" class="button108" id="btnRRTicket" value="申请改签"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=13&pr=3','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:if test="checkright('b2cshenqinghuankai')">
												<input  type="button" class="button108" id="btnRRTicket" value="升舱换开"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=23&pr=14','<ww:property value="id" />')" /><br/>
												</ww:if>
												
												</ww:if>

                                                  
												<ww:if test="orderstatus==3 || orderstatus==14 || orderstatus==29">
												<ww:if test="orderstatus==3 ||orderstatus==29">
												<ww:if test="checkright('b2cshenqingfeipiao')">
												<!-- 如果超过当日24点不能进行废票操作 -->
												<ww:if test="checkFeiPiaoValite(printtime)">
												<ww:if test=""></ww:if>
												<input type="button" class="button108" id="btnRRTicket" value="申请废票"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=5&pr=1','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:else>
												 <span style="color:red">废票时间已过<br /></span>
												</ww:else>
												<!-- 如果超过当日24点不能进行废票操作 -->
												</ww:if>
												</ww:if>
												<ww:if test="orderstatus==3  || orderstatus==14||orderstatus==29">
												<ww:if test="checkright('b2cshenqingtuipiao')">
												<input type="button" class="button108" id="btnRRTicket" value="申请退票"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=4&pr=2','<ww:property value="id" />')" /><br/>
												</ww:if>
												</ww:if>
												<ww:if test="orderstatus==3 || orderstatus==14||orderstatus==29">
												<ww:if test="orderstatus==3||orderstatus==29">
												<ww:if test="checkright('b2cshenqinggaiqian')">
												<input  type="button" class="button108" id="btnRRTicket" value="申请改签"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=13&pr=3','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:if test="checkright('b2cshenqinghuankai')">
												<input  type="button" class="button108" id="btnRRTicket" value="升舱换开"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=23&pr=14','<ww:property value="id" />')" /><br/>
												</ww:if>
												</ww:if>
												<ww:if test="orderstatus==3 || orderstatus==14">
												<ww:if test="checkright('b2cdingdanpeisong')">
												<ww:if test="(paymethod==3 || paymethod==5) && s_send==1">
												<input  type="button" class="button108" id="btnRRTicket1" value="配送订单"  onclick="showpeisong(<ww:property value="id" />);" /><br/>
												</ww:if>
												</ww:if>
												<ww:if test="checkright('b2cshouyin') && s_send!=1">
												 <input  type="button" class="button108" id="btnRRTicket1" value="收银"  onclick="shouyin(<ww:property value="id" />);" /><br/>
												</ww:if>
												</ww:if>
												</ww:if>
												</ww:if>
												
												<ww:if test="orderstatus==29">
												<ww:if test="checkright('b2cshouyin')">
												<input  type="button" class="button108" id="btnRRTicket1" value="收银"  onclick="shouyin(<ww:property value="id" />);" /><br/>
												</ww:if>
												</ww:if>
												
												
												
												
												<ww:if test="orderstatus==5">
												<ww:if test="checkright('b2cfeipiaoshenhe')">
												<input type="button" class="button108" id="btnRRTicket" value="废票审核"   onclick="goEdit2('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=11&pr=1','<ww:property value="id" />')" /><br/>
												</ww:if>
												</ww:if>
												<!-- 升舱换开审核成功 -->
												<ww:if test="orderstatus==25">
												<ww:if test="checkright('b2cshenqingtuipiao')">
												<input type="button" class="button108" id="btnRRTicket" value="申请退票"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=4&pr=2','<ww:property value="id" />')" /><br/>
												</ww:if>
												</ww:if>
												
												<ww:if test="orderstatus==4">
													<ww:if test="checkright('b2ctuipiaoshenhe')">
													<input type="button" class="button108" id="btnRRTicket" value="退票审核"   onclick="goEdit2('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=12&pr=2','<ww:property value="id" />')" /><br/>
													</ww:if>
												
												</ww:if>
												<ww:if test="orderstatus==30">
													<ww:if test="checkright('b2chuankaishenhe')">
													<input type="button" class="button108" id="btnRRTicket" value="换开审核"   onclick="goEdit2('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=25&pr=14','<ww:property value="id" />')" /><br/>
													</ww:if>
												
												</ww:if>
												<ww:if test="orderstatus==11">
													<ww:if test="checkright('b2cfeipiaotuikuan')">
													<input type="button" class="button108" id="btnRRTicket" value="废票退款"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=9&pr=6','<ww:property value="id" />')" /><br/>
													<input type="button" class="button108" id="btnRRTicket1" value="打印废票单"   onclick='printtuipiaodan(<ww:property value="id" />,1)' />
													</ww:if>
												</ww:if>
												<ww:if test="orderstatus==12">
												<ww:if test="checkright('b2ctuipiaotuikuan')">
												<input type="button" class="button108" id="btnRRTicket" value="退票退款"   onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=18&pr=7','<ww:property value="id" />')" /><br/>
												
												<input type="button" class="button108" id="btnRRTicket1" value="打印退票单"   onclick='printtuipiaodan(<ww:property value="id" />,2)' />
												
												</ww:if>
												</ww:if>
												<ww:if test="orderstatus==13">
												<ww:if test="checkright('b2cgaiqianshenhe')">
												<input type="button" class="button108" id="btnRRTicket" value="改签审核"   onclick="goEdit2('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=14&pr=5','<ww:property value="id" />')" /><br/>
												</ww:if>
												</ww:if>
												
												<ww:if test="orderstatus<3">
												<ww:if test="checkright('b2cquxiaodingdan')">
												<input type="button" class="button108" id="btnCancel" value="取消订单"  onclick="cancelorder(<ww:property value="id" />);" /><br/>
												</ww:if>
												</ww:if>
												
												<!-- 暂不能出票转成待出票订单-->
												<ww:if test="orderstatus==16">
												<ww:if test="checkright('b2czhuanhuandaichupiao')">
												<input type="button" class="button108" id="btnCancel" value="转成待出票"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=2','<ww:property value="id" />');" /><br/>
												</ww:if>
												</ww:if>
												<!-- 订单操作结束 -->
												
												<!-- 个人挂账成待出票订单-->
												<ww:if test="orderstatus==1&&paymethod!=3">
												
												<input type="button" class="button108" id="btnCancel" value="转成已支付"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=2','<ww:property value="id" />');" /><br/>
												
												</ww:if>
												<!-- 个人挂账 -->

												</td>
												
											</tr>
											
										</ww:iterator>
									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center">
								  <ww:if test="s_send==1">
								    <ww:property value="getPagination('\"orderinfo!tob2c.action?s_orderstatus=3&s_send=1&pageinfo.pagenum=\"+pageno')"/>
								  </ww:if>
								  <ww:elseif test="s_money==1 && s_send==1">
								    <ww:property value="getPagination('\"orderinfo!tob2c.action?s_send=1&s_money=1&pageinfo.pagenum=\"+pageno')"/>
								  </ww:elseif>
								  <ww:else>
								    <ww:property value="getPagination('\"orderinfo!tob2c.action?pageinfo.pagenum=\"+pageno')"/>
								  </ww:else>
							      
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
<table>
	<tr>
		<td><strong><span style="color: Red">注意事项:</span></strong></td>
	</tr>
	<tr>
		<td>
		<ul>

            <li style="color: Red;">提示信息：点击PNR编码即可复制PNR编码到剪贴板</li>
			<li style="color: Red;">票号和EI项可以在订单详情页面添加</li>
			<li id="li1"><span id="Label1">解锁功能只有本单位的管理员才具有</span></li>
			<li>点击"订单号"即可查看订单详细</li>
		</ul>
		</td>
	</tr>
	 <tr><td><table border="1" width="73%" style="display:none">
  <tr>
    <td width="34%">
      <p style="line-height: 150%"><font color="#000000">
1：<input type="checkbox" id="C1" checked>位置移动和宽高调整<br>
2：<input type="checkbox" id="C2" checked>颜色选择<br>
3：<input type="checkbox" id="C3" checked>字体名选择<br>
4：<input type="checkbox" id="C4" checked>字大小选择<br>
5：<input type="checkbox" id="C5" checked>旋角调整<br>
6：<input type="checkbox" id="C6" checked>粗斜体功能条<br>
7：<input type="checkbox" id="C7" checked>线型功能条</font></td>
    <td width="66%">
      <p style="line-height: 150%"><font color="#000000">
&nbsp;8：<input type="checkbox" id="C8" checked>对齐功能条<br>
&nbsp;9：<input type="checkbox" id="C9" >删除功能<br>
10：<input type="checkbox" id="C10" >页眉设置<br>
11：<input type="checkbox" id="C11" >页脚设置<br>
12：<input type="checkbox" id="C12" >位置锁定功能<br>
13：<input type="checkbox" id="C13" >属性设置<br>
14：<input type="checkbox" id="C14" checked>显示关闭钮(界面内嵌时)</font></td>
  </tr>
</table></td></tr>
</table>
</form>
<div style="width: 100%; background-color:Gray; display:none; height: 100%; position:absolute; left: 0; top: 0;" id="xie">
<div style="width: 260px; background-color:Gray; display:none; height: 113px; position:absolute; left: 244px; top: 137px;" id="content1"></div>

</div>
</body>
</html>

<script language="JavaScript">
Ext.onReady(function(){
	 var selectId ="";
	 var cash="";
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
					document.form1.action="orderinfo!toshowb2c.action?id="+selectId;
					document.form1.submit();
					
				}
            }
            <ww:if test="checkright('b2corderedit')">
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="orderinfo!toeditb2c.action?id="+selectId;
						document.form1.submit();
				}
            }
           </ww:if>
           <ww:if test="checkright('recinsure')">
			,{  
				id:"recinsurce",
				text:"录入保险",
				icon:"images/menu/edit.gif",
				handler : function(item){
				        
				         if(cash!=1){
						document.form1.action="insuranceinfo!toaddinsurance.action?orderId="+selectId;
						document.form1.submit();
						}else{
						alert("当前订单已收银，不可录入保险！");
						}
						
				}
            }
            </ww:if>
			
			
		]

		});
		
		Ext.get('menutable').on('contextmenu',function(e){
		
		if(e.target.parentNode.id)
		{
			e.preventDefault();
			selectId = e.target.parentNode.id;
			cash = e.target.parentNode.cashier;
			menu.showAt(e.getPoint());
		}
	});
	

});
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
  
   function updateOrder(action){
			var length=document.form1.selectid.length;			
			//唯一项
			if(length== undefined){			
				if(document.form1.selectid.checked ==true)
				{	var uvalue=document.form1.selectid.value;
					
						document.form1.action=action+uvalue;
						haveUpdateLimit(uvalue,function(){
						document.form1.submit();						
						});
									
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
				              
					      		document.form1.action=action+uvalue;
					      		haveUpdateLimit(uvalue,function(){
						         document.form1.submit();						
						        });
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;					      
					      }					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
	  }

 function updateItem(action){
			var length=document.form1.selectid.length;			
			//唯一项
			if(length== undefined){			
				if(document.form1.selectid.checked ==true)
				{	var uvalue=document.form1.selectid.value;
					var cash=cash=$("#"+uvalue).attr("cashier");
				       if(cash!=1){
						document.form1.action=action+document.form1.selectid.value;
						document.form1.submit();
						}else{						
						alert("当前订单已收银，不可录入保险！");
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
					   	 var cash=0;
					     for (var i = 0; i < length; i++)
					      {					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								cash=$("#"+uvalue).attr("cashier");
								len++;					         
					         }						      
					      }     
					      if(len==1){
				                if(cash!=1){
					      		document.form1.action=action+uvalue;
								document.form1.submit();
								}else{
								alert("当前订单已收银，不可录入保险！");
								}
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;					      
					      }					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
	  }
//批量打印 
function printItem(){
			var length=document.form1.selectid.length;
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认批量打印吗？');
						if(temp==true)
						{
						  //document.form1.action="orderinfo!delete.action?id="+document.form1.selectid.value;
						  //document.form1.submit();
						  printallitem(document.form1.selectid.value+",");
						}
						return;
				}
			}
			if ( length == null || length==0 ){
					  	 
		  	  	 alert("你未选择任何内容");
		         return;
			}else{
			   	 var len=0;
			   	 var uvalue="";
			     for (var i = 0; i < length; i++)
			      {
			         
			         if( document.form1.selectid[i].checked ==true){
						uvalue+=document.form1.selectid[i].value+",";
						len++;					         
			         }
				      
			      }
			      
			     
			      if(len==1){
			      	var temp = confirm('确认批量打印吗？');
					if(temp==true){
						//document.form1.action="orderinfo!delete.action?id="+uvalue;
						//document.form1.submit();
						printallitem(uvalue);
					}
					return;
			      }else if (len>1){
			      	var temp = confirm('确认批量打印吗？');
			      	if(temp==true){
			      		//document.form1.action="orderinfo!batch.action?opt=1";
						//document.form1.submit();
						printallitem(uvalue);
					}
					return;
			      
			      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
  
  //批量打印退票单 
function printItemtuipiao(state){
			var length=document.form1.selectid.length;
			var confstr="";
				        if(state=="1")
				        {
				          confstr="确认批量打印废票单吗？";
				        }
				        else if(state=="2")
				        {
				          confstr="确认批量打印退票单吗？";
				        }
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{   
				        
						var temp = confirm(confstr);
						if(temp==true)
						{
						  //document.form1.action="orderinfo!delete.action?id="+document.form1.selectid.value;
						  //document.form1.submit();
						  
						  piliangdayintuipiao(document.form1.selectid.value+",",state);
						}
						return;
				}
			}
			if ( length == null || length==0 ){
					  	 
		  	  	 alert("你未选择任何内容");
		         return;
			}else{
			   	 var len=0;
			   	 var uvalue="";
			     for (var i = 0; i < length; i++)
			      {
			         
			         if( document.form1.selectid[i].checked ==true){
						uvalue+=document.form1.selectid[i].value+",";
						len++;					         
			         }
				      
			      }
			      
			     
			      if(len==1){
			      	var temp = confirm(confstr);
					if(temp==true){
						//document.form1.action="orderinfo!delete.action?id="+uvalue;
						//document.form1.submit();
						piliangdayintuipiao(uvalue,state);
					}
					return;
			      }else if (len>1){
			      	var temp = confirm(confstr);
			      	if(temp==true){
			      		//document.form1.action="orderinfo!batch.action?opt=1";
						//document.form1.submit();
						piliangdayintuipiao(uvalue,state);
					}
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
						
						document.form1.action="orderinfo!toshowb2c.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="orderinfo!toshowb2c.action?id="+uvalue;
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


function change(){
var valu=$("#sid").val();
if(valu==7){
$(".divgrgz").show();  
}else{ 
 $(".divgrgz").hide();
 }
}
function isSelectPeople(){ 
var valu=$("#sid").val();
if(valu==7){
var gzr=$("#ddlemployeeid").val();
if(gzr==0){
alert("请您选择挂账人！");
return false;
 }
}
return true;
}
function instance(){
$(".divgrgz").hide();
change();
var paycode=$("#paycode").val();
if(paycode==1||paycode==4||paycode==9){
$("#wszf").attr("selected","selected");
}else if(paycode==5){ 
$("#yjgz").attr("selected","selected"); 
	}else if(paycode==8){
	$("#nbjs").attr("selected","selected");
	}
};
</script>








