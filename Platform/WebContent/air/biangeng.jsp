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
<link type="text/css" rel="stylesheet" href="style/base100108.css" />

<script src="js/jquery1.3.2.js"></script>


<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />

<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />


<!--<link rel="stylesheet" type="text/css"
	href="js2/resources/css/ext-all.css" />
<script type="text/javascript"
	src="js2/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="js2/ext-all.js"></script>


-->
<style>
fieldset {
	padding: 10px;
	margin: 5px;
	width: 96%;
	color: #333;
	border: #ccc dashed 1px;
}

legend {
	color: #114F82;
	font-weight: 800;
	background: #fff;
}

ul {
	list-style-type: none;
	margin: 8px 0 4px 0;
}

li {
	margin-top: 4px;
}

* {
	margin: 0;
	padding: 0;
	font-size: 12px;
	font-family: "瀹嬩綋"
}

img {
	border: 0;
	display: block
}

.ul {
	height: 32px;
	width: 990px;
	background: #efefef;
	border-bottom: 2px solid #4f7dbb
}

.ul li {
	float: left;
	width: auto;
	height: 32px;
	line-height: 32px;
	text-align: center;
	padding: 0 10px
}

.ul li a {
	text-decoration: none;
	color: #333;
	font-weight: bold;
	font-size: 14px
}


.xuanzhong {
	width: auto;
	height: 30px;
	background: url(images/anniu.jpg) no-repeat;
	posotion: relative;
	top: -20px
}

.ul .li a {
	color: #fff
}

.content {
	width: 925px;
	height: auto;
	border: 1px solid #ddd;
	border-top: 0;
	margin-top: -10px
}

.dis {
	display: none
}

.dis table td {
	text-align: center;
	line-height: 18px
}

fieldset {
	padding: 10px;
	margin: 5px;
	width: 96%;
	color: #333;
	border: #ccc dashed 1px
}

legend {
	color: #114f82;
	font-weight: 800;
	background: #fff
}

ul {
	list-style-type: none;
	margin: 8px 0 4px 0
}

li {
	margin-top: 4px
}

.lj a {
	text-decoration: none;
	color: #930
}

.daoh {
	width: 99%;
	margin-left: 5px;
	height: 30px
}

.daoh ul {
	list-style-type: none;
	margin: 0;
	padding: 0
}

.daoh ul li {
	float: left;
	background: url(images/dda.gif) repeat-x;
	margin-right: 5px;
	width: 80px;
	line-height: 27px;
	text-align: center;
	margin-top: 3px
}

.daoh ul li a {
	text-decoration: none;
	color: #069
}

.daoh ul li a:hover {
	text-decoration: none;
	color: #fff;
	background: url(images/dd.gif) repeat-x;
	width: 80px;
	float: left
}

.style165 {
	display: none;
	position: absolute;
	width: 200px;
	left: -10px;
	background: #fefefe;
	padding-left: 20px;
	border: 2px solid #f48000;
	z-index: 999
}

</style>
<script language=”javascript”>
    function killErrors() {
    return true;
}
window.onerror = killErrors;

</script>
 
<ww:if test="getLoginsessionagent().agenttype==13||getLoginsessionagent().agenttype==11">
<script>
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
	<ww:property value="#request.agentroot"/>
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue("<ww:property value='companyname'/>");
       tree.on('click',function(node){   
           
             comboxWithTree.setValue(node.text); 
             Ext.get('companyname').set({value:node.text});
             Ext.get('parentid').set({value:node.id});
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
</ww:if>

<script>


function isOperating(orderid,state){
var ret;
   $.ajax({
    type:"POST",
    url:"b2bticketorder!ajaxIsoperateing.action",
    data:{orderid:orderid,orderstate:state},
    async:false,         
    success:function(data){
     ret=data;
    }            
    });

return ret;
}


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


function converNullAndEpt(obj,ret){
      if(obj==null||obj=='undefined'||obj==""){
       return ret;
      }
      return obj;
    }
</script>

<!-- 打印脚本 -->
<script language="javascript" type="text/javascript">    
function printChange(id){
jQuery.post("b2bticketorder!printChange.action",{orderid:id},function(){});
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
	    $.ajax({   
         url: 'b2bticketorder!piliangdayin.action',   //接收页面   
           type: 'post',      //POST方式发送数据   
           async: false,      //ajax同步   
           data: {strTuiOrderID:arr[i]},   
           success: function(msg) {   
               prn1_all_print(msg);	  
           }   
      });   
	       
	 }	   
	   colsedispose();
}


	function fenliprint(){
			var length=document.form1.selectid.length;			
			//唯一项
			if(length== undefined){			
				if(document.form1.selectid.checked ==true)
				{						
						getpassengerid(document.form1.selectid.value);					
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
					      		getpassengerid(uvalue);
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }				
			alert("无效操作,你未选择任何内容!");
			return;
		
	}

function popup(url)
{
  window.open(url, 'newwindow', 'height=600, width=800, top=10, left=200, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=no'); 
}

function getpassengerid(orderid){
	$.ajax({
	   url:"b2bticketorder!ajaxgetpassengerid.action",
	   type:"POST",
	   async:false,
	   data:{strTuiOrderID:orderid},
	   success:function (data){
	    if(confirm('您确定分离打印吗？')){
	      fenlidayin(orderid,data);
	   }	   
	  }	
  });
	
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
	         url:"b2bticketorder!piliangdayin.action?rndmath="+Math.floor(Math.random()*100),
	         type:"POST",
	         async: false, 
	         data:{strTuiOrderID:orderid,s_songpaiodanpid:arr[i],s_Paindex:i+1,pagecount:arr.length-1},
	         beforeSend:function(){dispose('正在分离打印送票单...');},             
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
	         url:"b2bticketorder!gettuipiaodan.action?rndmath="+Math.floor(Math.random()*100),
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
	         async:false,
	         url:"b2bticketorder!gettuipiaodan.action?rndmath="+Math.floor(Math.random()*100),
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
    var msgtypes="";//用于短信发送选择
    var checkfalg="false";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true){
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
              if(document.getElementById("s_msgtype"+i).checked){
              msgtypes+="4,";
              }else{
                msgtypes+="0,";
              }
          }
       }
       );
        
	    if(confirm('您确定要对选中的乘机人进行申请退票操作吗？'))
	    {
	   	//  var re = /^[0-9]+.?[0-9]*$/;
	    	//if(!re.test($("#txttuifee").val())){
	    	// alert("请输入数字(例:88.02)");
	    	// return;   
	    	//}else{
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
	        var linkmsgtype=$("input[@type=radio][name=s_linkmsgtype][checked]").val();
	       var tuifeidesc=encodeURI($("#tuifeidesc").val());
	
	
	
	 var staus="0";   
	  var newordernum="";
	 //  $.ajax({
	 //        type:"POST",
	 //       async:false,
	 //        url:"b2bticketorder!ajaxTuiFei.action?rndmath="+Math.floor(Math.random()*100),
	 //        data:{strTuiOrderID:id,tui_state:ddlreasonid,TuiFeiType:4,tui_tuifeidesc:tuifeidesc,passid:passengerids},
	 //        success:function(data){
	 //        	if(data){
	 //        		if(data=='-1'){//失败
	 //        		alert("申请失败!");
	 //         		}else{
	 //        		staus="1";
	 //        		newordernum=data.split("@")[1];
	 //       		alert("成功");
	 //       		}
	 //      	}
     //   }            
     //   });
	   
	   
	     
	     staus="1";
	     	if(staus=='1'){
	     	
	       window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=4&no=2&pr=2&passid='+passengerids+'&tui_state='+ddlreasonid+'&tui_iscabinsite='+iscabinsite+'&tui_tuifeidesc='+tuifeidesc+'&msgtypes='+msgtypes+'&linkmsgtype='+linkmsgtype+'&newordernum='+newordernum;
	  	  	}
	  

	    }
     }
    
}

function ajaxTuiFei(type,orderid,why,whydesc){

 	$.ajax({
	         type:"POST",
	         async:false,
	         url:"b2bticketorder!ajaxTuiFei.action?rndmath="+Math.floor(Math.random()*100),
	         data:{strTuiOrderID:orderid,tui_state:why,TuiFeiType:type,tui_tuifeidesc:whydesc},
	         success:function(data){
	         	if(data){
	         	
	         	return data;
	         	}else{
	         	return "-1";
	         	}
	        
	         }            
	         });


}

//点击申请废票
function feiticket(id)
{
    var passengerids="";
    var checkfalg="false";
    var msgtypes="";//用于短信发送选择
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
                if(document.getElementById("s_msgtype"+i).checked){
              msgtypes+="4,";
              }else{
                msgtypes+="0,";
              }
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
	        var linkmsgtype=$("input[@type=radio][name=s_linkmsgtype][checked]").val();
	    //   var tuifee=document.getElementById("txttuifee").value;
	    //    var tkprice=$("#ordertfprice").val();
	    //+'&returnprice='+tkprice+'&tui='+tuifee
	    
	    //外部调用开始
	    
	   var staus="0";   
	  var newordernum="";
	  	 //$.ajax({
	     //    type:"POST",
	     //   async:false,
	     //    url:"b2bticketorder!ajaxTuiFei.action?rndmath="+Math.floor(Math.random()*100),
	     //    data:{strTuiOrderID:id,tui_state:ddlreasonid,TuiFeiType:5,tui_tuifeidesc:tuifeidesc,passid:passengerids},
	     //    success:function(data){
	    //     	if(data){
	         	
	         		//data="S@121212";
	    //     		if(data=='-1'){//失败
	    //     		alert("申请失败!");
	    //     		}else{
	    //     		staus="1";
	     //    		newordernum=data.split("@")[1];
	         		
	     //    		alert("成功,新订单号:"+newordernum);
	     //    		}
	         	
	      //  	}
	        
        // }            
       //  });
	    
	    
	    
	    //结束
	    
	    
	    staus="1";
	    
	    if(staus=='1'){
	       window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=5&no=2&pr=1&passid='+passengerids+'&tui_state='+ddlreasonid+'&tui_iscabinsite='+iscabinsite+'&tui_tuifeidesc='+tuifeidesc+'&msgtypes='+msgtypes+'&linkmsgtype='+linkmsgtype+'&newordernum='+newordernum;
	   }
	   
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
	       window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=13&no=2&pr=1&passid='+passengerids+'&tui_state='+ddlreasonid+'&tui_iscabinsite='+iscabinsite+'&tui_tuifeidesc='+tuifeidesc+'&tui='+$("#txttuifee").val()+'&changedate='+changedate+'&changeflight='+changeflight+'&changecabin='+changecabin+'&changepnr='+changepnr;
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
       
       jQuery.post("b2bticketorder!ajaxValidateSCHK.action",{oldorderid:id,ordernum:ordernumber,orderpnr:newpnr,orderticket:newticketnumber},function(data){

       if(data==true||data=="true"){
	    if(confirm('您确定要对选中的乘机人进行申请升舱换开操作吗？'))
	    {
	       var tuifeidesc=encodeURI(document.getElementById("tuifeidesc").value);
	       var newordernum=encodeURI(document.getElementById("txtordernumber").value);
	       var newpnr=encodeURI(document.getElementById("txtorderpnr").value);
	       var newticnum=encodeURI(document.getElementById("txtnewticnum").value);
	       var url='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=30&no=2&pr=1&passid='+passengerids+'&strNewOrderID='+newordernum+'&tui_tuifeidesc='+tuifeidesc+'&tui='+$("#txttuifee").val()+'&strSepPNR='+newpnr+'&strNewTicNum='+newticnum;
	  
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
function shenhetuiticket(id,passcount){
   
    var passengerids="";
    var checkfalg="false";
    var msgtypes="";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true){
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
            if(document.getElementById("s_msgtype"+i).checked){
              msgtypes+="4,";
              }else{
                msgtypes+="0,";
              }
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行退票操作吗？'))
	    {
	      var linkmsgtype=$("input[@type=radio][name=s_linkmsgtype][checked]").val();
	      var isbackinsur=$("input[@type=radio][name=isbackinsur][checked]").val();
	      if(typeof(isbackinsur)=='undefined'){
	      isbackinsur=0;
	      }
	       if(passcount>number)
	       {
	           ajaxSendTFmsg(passengerids,msgtypes,linkmsgtype);
	            gopnrsep(id,4,2,passengerids,isbackinsur);
	       }
	       else if(number==passcount)
	       { 
	           var tkprice=$("#ordertfprice").val();
	         window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&isbackinsur='+isbackinsur+'&orderstatus=12&pr=2&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2&msgtypes='+msgtypes+'&linkmsgtype='+linkmsgtype+'&tui='+$("#txttuifee").val()+'&returnprice='+tkprice;
	       }
	       
	    }
     }
    
}

function ajaxSendTFmsg(pids,mtyps,ltype){

  $.ajax({
     type:"POST",
     url:"b2bticketorder!ajaxSendTFMsg.action",
     data:{passengerids:pids,msgtypes:mtyps,linkmsgtype:ltype},
     success:function(){     
     }
  });

}
//点击废票通过
function shenhefeiticket(id,passcount)
{
    var passengerids="";
    var checkfalg="false";
     var msgtypes="";
    var number=0;
    $("input[id*='chkpassenger_']").each(function(i)
       {
          if(document.getElementById("chkpassenger_"+i).checked==true)
          {
             number++;
          }
       }
       );
      
     if(number>0){
	    checkfalg="true";
     }else{
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
               if(document.getElementById("s_msgtype"+i).checked){
              msgtypes+="4,";
              }else{
                msgtypes+="0,";
              }
          }
       }
       );
	    if(confirm('您确定要对选中的乘机人进行废票操作吗？')){
	    var linkmsgtype=$("input[@type=radio][name=s_linkmsgtype][checked]").val();
	     var isbackinsur=$("input[@type=radio][name=isbackinsur][checked]").val();
	      if(typeof(isbackinsur)=='undefined'){
	      isbackinsur=0;
	      }
	       if(passcount>number){
	           ajaxSendTFmsg(passengerids,msgtypes,linkmsgtype);
	            gopnrsep(id,4,1,passengerids,isbackinsur);
	       }else if(number==passcount){
	       var tkprice=$("#ordertfprice").val();	          
	          window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&isbackinsur='+isbackinsur+'&orderstatus=11&pr=1&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2&msgtypes='+msgtypes+'&linkmsgtype='+linkmsgtype+'&tui='+$("#txttuifee").val()+'&returnprice='+tkprice;
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
    $("input[id*='chkpassenger_']").each(function(i) {
          if(document.getElementById("chkpassenger_"+i).checked==true){
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
	            //goEdit2('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=16&pr=4',id);
	            gopnrsep(id,4,3,passengerids);
	       }
	       else if(parseInt(passcount)==1)
	       {
	         window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=14&pr=3&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2';
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
	            //goEdit2('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=16&pr=4',id);
	            gopnrsep(id,4,14,passengerids);
	       }
	       else if(parseInt(passcount)==1)
	       {
	     
	         window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=25&pr=3&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+',<font color="red"><b>升舱换开订单，原机票申请全退</b></font>'+'&no=2';
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
	       window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=26&pr=3&passid='+passengerids+'&no=2'+'&beizhu='+encodeURI($("#beizhu").val());
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
	       window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=17&pr=2&passid='+passengerids+'&beizhu='+encodeURI($("#beizhu").val())+'&no=2&tui_nodesc'+encodeURI(tui_nodesc);
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
	       window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=7&pr=1&passid='+passengerids+'&no=2'+'&beizhu='+encodeURI($("#beizhu").val())+'&tui_nodesc'+encodeURI(tui_nodesc);
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
	  
	       window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=15&pr=3&passid='+passengerids+'&no=2'+'&beizhu='+encodeURI($("#beizhu").val());
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
function goEdit2(ur,id){
  var states=ur.split("orderstatus=");
     var orderstate=states[1];
    if(orderstate.indexOf("&")!=-1){
      orderstate=orderstate.substring(0,orderstate.indexOf("&"));
    }
     var thestate=$("#orderstate"+id).val();
    var retvalue=isOperating(id,thestate);
    if(retvalue.length==0){
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
		          $(".ui-dialog-titlebar-close").hide();
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengersqList.action",
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
		          $(".ui-dialog-titlebar-close").hide();
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengersqList.action",
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
		          $(".ui-dialog-titlebar-close").hide();
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengersqList.action",
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
		          $(".ui-dialog-titlebar-close").hide();
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengersqListsep.action",
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
		          $(".ui-dialog-titlebar-close").hide();
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengersqList.action",
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
		          $(".ui-dialog-titlebar-close").hide();
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengersqList.action",
		            data:{strTuiOrderID:id,typ:14},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);            
		            }            
		            });
		   }
		  }else{
		    alert(retvalue);
		  
		  }

}

function increaseTicketnumber(){
var ticketone=$("#titnum0").val();
if(ticketone!=""){
 var reg=/^[0-9]{3}[-][0-9]{10}$/;
 if(reg.exec(ticketone)){
 var tickhead=ticketone.substr(0,4)
  var ticketnum=parseInt(ticketone.substr(4));
   $("input[id*='titnum']").each(function(i){
   ticketnum=ticketnum+1;
      $("#titnum"+(i+1)).val(tickhead+""+(ticketnum));
       });
 }else{
 alert("你输入的票号格式不正确，请重新输入！");
 }

}else{
alert("请先输入票号！");
}

}

function checkPnr(pnr){
 if(pnr.length!=6){
   alert("PNR格式输入不正确，请重新输入！");
   return false;
 }
 return true;
}

function ajaxPickupTicketnumber(pcount,lpnr){
var pnr=$("#orderlpnr").val();
 if(checkPnr(pnr)){
  lpnr=pnr;
 $.ajax({
    type:"POST",
    url:"b2bticketorder!ajaxPickupTicktnumber.action",
    data:{count:pcount,lpnr:lpnr},
    success:function(data){
    if(data==""){
    alert("提取票号为空，请重试或手动输入！");
    }else{
    var array=data.split("|");
    for(var i=0;i<pcount;i++){
    $("#titnum"+i).val(array[i]);
      
      }
     }
     colsedispose();
    }
 
 });
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
function colsedispose(){
 Ext.MessageBox.hide();
}

function goEdit(ur,id){
     var retvalue="";
     var states=ur.split("orderstatus=");
     if(states.length>1){
     var orderstate=states[1];
     if(orderstate.indexOf("&")!=-1){
      orderstate=orderstate.substring(0,orderstate.indexOf("&"));
     }
   var thestate=$("#orderstate"+id).val();
     retvalue=isOperating(id,thestate);
    }
    if(retvalue.length==0){
			    var h = ur.split("pr=");
				var h1 =h[1];   
		
		//alert("orderstate="+orderstate);		
		if(h1=='-1'){//申请退废票至平台	
		  $("#divpassenger").dialog({
		                title:'机票退费处理',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		         $(".ui-dialog-titlebar-close").hide();
		         $("#divpassenger").dialog("open");
		$.ajax({
		            type:"POST",
		            url:"b2bticketorder!ToTuiFeiOrder.action",
		            data:{strTuiOrderID:id,typ:orderstate},
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
		         $(".ui-dialog-titlebar-close").hide();
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		        $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:1},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });			 
				 return;				
				}else if(h1==2){
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
		         $(".ui-dialog-titlebar-close").hide();
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:2},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
				 return;
				
				}else  if(h1==3){//改签
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
		         $(".ui-dialog-titlebar-close").hide();
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:3},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });					
					return;			
				}else if(h1==4){
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
		         $(".ui-dialog-titlebar-close").hide();
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getViewTuifei.action",
		            data:{strTuiOrderID:id,typ:4},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });
				 return;
				}else if(h1==5){//审核改签
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
		         $(".ui-dialog-titlebar-close").hide();
		         $("#divpassenger").dialog("open");
		         //读取订单乘机人信息
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengersqList.action",
		            data:{strTuiOrderID:id,typ:3},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });					
					return;
				}else if(h1==14){//升舱换开
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
		        $(".ui-dialog-titlebar-close").hide();
		        $("#divpassenger").dialog("open");
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:14},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });					
					return;			
				}else if(h1==15){//订单支付
		        $("#divpassenger").dialog({
		                title:'订单支付',
		                show: null,
		                bgiframe: false,
		                autoOpen: false,
		                draggable: true,                
		                resizable: true,
		                modal: true,
		                width: 780,
		                height: 480
		            });
		        $(".ui-dialog-titlebar-close").hide();
		        $("#divpassenger").dialog("open");
		         $.ajax({
		            type:"POST",
		            url:"b2bticketorder!getPassengerList.action",
		            data:{strTuiOrderID:id,typ:14},
		            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
		            success:function(data){
		            $("#divpassenger").html(data);           
		            }            
		            });					
					return;			
				}else{
				if(confirm("是否确定执行当前操作?"))
				window.location.href=ur;
				}		
			}else{			
			  alert(retvalue);
			}
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
            url:"b2bticketorder!rtPNRinfo.action",
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
      var tkprice=$("#ordertfprice").val();	
	  var tui=$("#txttuifee").val();    
      $.ajax({
            type:"POST",
            url:"b2bticketorder!sepratePNR.action",
            async:false,
            data:{strSepPNR:$("#txtpnrcode").val(),strXuNumber:$("#txtxuhao").val(),s_newpassid:$("#hidpassengerid").val(),strTuiOrderID:$("#hidseporderid").val(),tuigaiindex:index,strfenliType:fenlitype,strNewPnr:$("#txtnewpnr").val(),strNewBigPnr:$("#txtnewbigpnr").val(),tui:tui,returnprice:tkprice,isbackinsur:$("#backinsur").val()},
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
        url:"b2bticketorder!ajaxunlockorder.action",
        data:{id:id},          
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
		            url:"b2bticketorder!getHuanKai.action",
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
            url:"b2bticketorder!doHuanKai.action",
            async:false,
            data:{strTuiOrderID:oldid,strNewOrderID:id,strSepPNR:pnr,strNewTicNum:newticnum},
            beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
            success:function(data){
            $("#divpassenger").html(data);
            }            
            });
          
      goEdit('b2bticketorder!editorderstatus.action?id='+oldid+'&orderstatus=30',oldid);
     
 }
 //开始收银
 function doshoukuan(id)
 {
     var fkmetho=$("#sid").val();
    var dvalue=$("#ddlemployeeid").val();
    if(fkmetho==7){
     goEdit("b2bticketorder!editorderstatus.action?id="+id+"&fkmethod="+fkmetho+"&guazhangrenid="+dvalue+"&orderstatus=10&s_employeeid="+$("#ddlemployeeid").val(),id);
    }else{
     goEdit("b2bticketorder!editorderstatus.action?id="+id+"&fkmethod="+fkmetho+"&orderstatus=10&s_employeeid="+$("#ddlemployeeid").val(),id);
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
         url:"b2bticketorder!doShoukuan.action",
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
		            url:"b2bticketorder!getPeisong.action",
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
    window.location.href='b2bticketorder!sendticketinfo.action?strTuiOrderID='+id;
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
           url:"b2bticketorder!dealsendticket.action",
           async:false,
           data:{strTuiOrderID:id,strSenderID:senderid,strSenderDate:$("#txtsendtime").val()},        
           success:function(data){
            alert(data);      
           }            
      });
      //更新订单状态为在途订单
      goEdit('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=28',id); 
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
           url:"b2bticketorder!getHuanKai.action",
           data:{strTuiOrderID:id,typ:2},
           beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
           success:function(data){
           $("#divpassenger").html(data);           
           }            
           });
 }
 
 function shenhehuankaitongguo(id)
 {
   goEdit('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=24',id);
 }

 //查看订单详细信息
 function showorderinfo()
 {
    //var ordertempid=$("#txtordernumber").val().substring(1,$("#txtordernumber").val().length);
    //ordertempid=parseInt(ordertempid)-10000;
    //window.location.href='b2bticketorder!showOrderdetail.action?id='+ordertempid;
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
function cancel51bookorder(buyln,id){
  var message="您是否确定取消当前订单？";
 if(buyln!=1){
  message="此订单为其它加盟商所预定。\r\n"+message;
  }
  if(confirm(message)){
   
    //取消PNR
    $.ajax({
           type:"POST",
           url:"b2bticketorder!can51bookorder.action",
           data:{s_orderid:id},
           beforeSend:function(){},             
           success:function(data){
	           if(data=="1")
	           {
	             	alert("订单取消成功！"); 
	             // goEdit('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=6',id); 
	              window.location.href='b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=6';
	           }else{
	           	alert("订单取消失败！");  
	           }     
           }            
           });
    
  }  
}
//取消订单
function cancelorder(buyln,id){
  var message="您是否确定取消当前订单？";
  if(buyln!=1){
  message="此订单为其它加盟商所预定。\r\n"+message;
  }
  if(confirm(message)){
    goEdit('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=6',id);
    //黑屏中取消PNR
    $.ajax({
           type:"POST",
           url:"b2bticketorder!XEPNRinfo.action",
           data:{s_orderid:id},
           beforeSend:function(){},             
           success:function(data){
	           if(data!="")
	           {
	             alert("订单取消成功！");  
	           }     
           }            
           });
    
  }  
}
//再次下单
function nextOrderticket(id){
    //黑屏中取消PNR
    if(confirm("此操作将向政策供应商重新下单，是否确定当前操作？")){
    $.ajax({
           type:"POST",
           url:"b2bticketorder!nextOrderticket.action",
           data:{orderid:id},
           beforeSend:function(){},             
           success:function(data){
	           if(data==""){
	             alert("重新下单成功！"); 
	             $("#nextorder"+id).hide();
	           }else{
	             alert("重新下单失败，请确定PNR是否可用！");
	           }     
           }            
           });
         }
}
//暂不能出票
function zanbunengchupiao(id)
{
  
  if(confirm('您确定要执行暂不能出票操作吗？'))
  {
    goEdit('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=16',id);
  }
}
//废票退款
function feipiaotuikuan(id,desc,iswebtui)
{
  //http://localhost:8080/dfhk_interface/Billpaytui
  //if(iswebtui==1)
  //{
    //document.formpay.action="../dfhk_interface/Billpayordertui";
    //document.formpay.action="../dfhk_interface/Billpayordertui";
    //document.formpay.submit();
  //}
  //else
  //{
	 if(confirm('您确定要执行废票退款成功操作吗？'))
	 {
	 
	   goEdit('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=9&strTuikuanDesc='+encodeURI(desc),id);
	 } 
  //}
}
//退票退款
function tuipiaotuikuan(id,desc,iswebtui)
{  
  
  if(confirm('您确定要执行退票退款成功操作吗？'))
  {    
    goEdit('b2bticketorder!editorderstatus.action?id='+id+'&orderstatus=18&strTuikuanDesc='+encodeURI(desc),id);
  } 
}

//PNR分离按钮
function gopnrsep(id,type,tuigaiindex,passid,backinsur)
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
    var tkprice=$("#ordertfprice").val();	
	 var tui=$("#txttuifee").val();        
  $.ajax({
     type:"POST",
     url:"b2bticketorder!getPassengersqListsep.action",
     data:{strTuiOrderID:id,typ:4,tuigaiindex:tuigaiindex,passid:passid,returnprice:tkprice,tui:tui,isbackinsur:backinsur},
     beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
     success:function(data){
     $("#divpassenger").html(data);           
     }            
     });
}


function rrticket(id){ //点击执行锁定订单操作  
   var thestate=$("#orderstate"+id).val();
   var retvalue= isOperating(id,thestate);
   if(retvalue.length==0){       
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
	     url:"b2bticketorder!rrticket.action",
	     data:{id:id},  
	     beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},         
	     success:function(data){
	     $("#divpassenger").html(data); 
       }      
       });
     }else{
        alert(retvalue);
     }
     
 }
 
//国际机票订单确认
function interorderconfirm(id){ //点击执行锁定订单操作  
   var thestate=$("#orderstate"+id).val();
   var retvalue= isOperating(id,thestate);
   if(retvalue.length==0){       
          $("#divpassenger").dialog({
	      title:'国际订单确认操作-填写票价，PNR',
	      show: null,
	      bgiframe: false,
	      autoOpen: false,
	      draggable: true,                
	      resizable: true,
	      modal: true,
	      width:500,
	      height: 230
	      });
		  $(".ui-dialog-titlebar-close").hide();
		  $("#divpassenger").dialog("open");
		  $.ajax({
	     type:"POST",
	     url:"b2bticketorder!interOrderConfirmHtml.action",
	     data:{strTuiOrderID:id},  
	     beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},         
	     success:function(data){
	     $("#divpassenger").html(data); 
       }      
       });
     }else{
        alert(retvalue);
     }  
 }
 //国际订单确认，更新订单信息
 function saveinterorder(id)
 {
     if($("#txt_pnr_inter").val()=="")
     {
        alert("PNR信息为必填项，请重新填写！");
        $("#txt_pnr_inter").focus();
        return false;
     }
     if($("#txt_tax_inter").val()=="")
     {
        alert("税费信息为必填项，请重新填写！");
        $("#txt_tax_inter").focus();
        return false;
     }
     if($("#txt_adultprice_inter").val()=="")
     {
        alert("成人票面价为必填项，请重新填写！");
        $("#txt_adultprice_inter").focus();
        return false;
     }
     if($("#txt_childprice_inter").val()=="")
     {
         alert("儿童票面价为必填项，请重新填写！");
         $("#txt_childprice_inter").focus();
         return false;
     }
     //更新订单信息
      $.ajax({
	     type:"POST",
	     url:"b2bticketorder!saveInterOrder.action",
	     data:{strTuiOrderID:id,s_pnr_inter:$("#txt_pnr_inter").val(),s_tax_inter:$("#txt_tax_inter").val(),s_adultprice_inter:$("#txt_adultprice_inter").val(),s_childprice_inter:$("#txt_childprice_inter").val()},  
	     beforeSend:function(){$("#divpassenger").html("正在更新订单信息...");},         
	     success:function(data){
	     closedialog(id);
	     window.location.reload();
       }      
       });
      
 }
 
 //立即支付
function payorder(id){ //点击执行锁定订单操作
var thestate=$("#orderstate"+id).val();
var departime=$("#departtime"+id).html();
var canpay=true;
departime=departime.replace(/-/g, '/ '); 
var cdate=new Date();
var flighttime=new Date(departime);
if(flighttime.getFullYear()==cdate.getFullYear()){
    if(cdate.getMonth()==flighttime.getMonth()){
         if(cdate.getDate()==flighttime.getDate()){
            if(flighttime.getHours()-cdate.getHours()<=2){
            canpay=false;
            }

        }else if(cdate.getDate()>flighttime.getDate()){
         canpay=false;
        }    
     }else if(cdate.getMonth()>flighttime.getMonth()){
        canpay=false;
     }
  }else if(cdate.getFullYear()>flighttime.getFullYear()){
    canpay=false;
  }
  if(true){
     var retvalue= isOperating(id,thestate);
       if(retvalue.length==0){       
         window.location.href="b2bticketorder!topayorder.action?id="+id;
     }else{
        alert(retvalue);
     }
  }else{
    alert("航班起飞前2小时内不可支付！");
  }
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
	    url:"b2bticketorder!saveticketnumber.action",
	    data:{strTuiOrderID:id,ticketnumberarr:ticketnumberarr,rpnumberarr:rpnumberarr,eiarr:eiarr}, 
	    async:false, 
	    beforeSend:function(){$("#divpassenger").html("正在保存票号等信息...");},         
	    success:function(data){
	      
	       window.location.href='http://www.google.com';
	    }          
    });
   
}

$(document).ready(function() {
  var LODOP=document.getElementById("LODOP");//这行语句是为了符合DTD规范
  <ww:if test="s_send==1 || s_orderstatus==28 || s_money==1 || s_orderstatus==18 || s_orderstatus==9">
	  CheckLodop();
  </ww:if>

});

</script>
</head>
<body>
<form name="form1" method="post" action="b2bticketorder!AllChang.action">
<input type="hidden" name="s_biangengstate" value="<ww:property value="s_biangengstate"/>" />
<div id="divpassenger"
	style="text-align: center; display: none; background-color: #fff; left: 0px;">正在加载订单信息...
</div>
<div id="member">
<input type="hidden" name="s_cashier" value="<ww:property value="s_cashier"/>" />
<input type="hidden" name="s_orderstatus" value='<ww:property value="s_orderstatus"/>' />
<input type="hidden" name="ty" value='<ww:property value="ty"/>' />
<input type="hidden"  name="operate" value="<ww:property value="operate"/>" /> 
<input type="hidden" name="guazhang" value="<ww:property value="guazhang"/>" />
<input type="hidden" name="s_receipt" value="<ww:property value="s_receipt"/>" />
<input type="hidden" name="lockorder" value="<ww:property value="lockorder"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;机票变更订单查询</span></b></td>
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
						<table width="100%" border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td><input type="text" id="divallprint" value=""
									style="display: none" />
								<table class="table2" width="100%" border="0">
									<tr>
										<td width="100%" height="29" colspan="22"
											background="images/jb.gif"
											style="border-bottom: 1px solid #99CBED"><span
											class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;订单管理-变更订单查询</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>
									</tr>
								<tr>
									<td align="right" >订单号</td>
									<td align="left" style=" height: 26px;">
									<input name="s_ordernumber" type="text"  style="width: 69px;"
											value='<ww:property value="s_ordernumber"/>' />
									</td>
									<td align="right" >PNR</td>
									<td align="left" style=" height: 26px;">
									<input name="s_pnr" type="text"  style="width: 69px;"
											value='<ww:property value="s_pnr"/>' />
									</td>
									
									 <td align="right" style=" height: 26px;"
											nowrap="nowrap">出票人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_chupiaoname" type="text" id="s_chupiaoname" style="width: 69px;"
											value='<ww:property value="s_chupiaoname"/>'/></td>
									 <td align="right" style=" height: 26px;"
											nowrap="nowrap">预定日期</td>
										<td align="left" style=" height: 26px;">
										<input onclick="WdatePicker()"
											name="s_feipiaoshenqingsdate" type="text" id="s_tfshenqingsdate" style="width: 79px;"
											value="<ww:property value="s_feipiaoshenqingsdate"/>" />&nbsp;-&nbsp;<input onclick="WdatePicker()"
											name="s_feipiaoshenqingedate" type="text" id="s_tfshenqingedate" style="width: 79px;"
											value="<ww:property value="s_feipiaoshenqingedate"/>" />
											</td>
											
								   <!--
								   <ww:if test="getLoginsessionagent().agenttype==3">
									<td align="right"
											nowrap="nowrap">退废申请人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_tuipiaoshenqingren" type="text" id="s_tfshenqingren" style="width: 69px;"
											value="<ww:property value="s_tuipiaoshenqingren"/>" /></td>
										<td align="right" style="height: 26px;"
											nowrap="nowrap">退废申请时间</td>
										<td  align="left" style=" height: 26px;">
										<input onclick="WdatePicker()"
											name="s_feipiaoshenqingsdate" type="text" id="s_tfshenqingsdate" style="width: 79px;"
											value="<ww:property value="s_feipiaoshenqingsdate"/>" />&nbsp;-&nbsp;<input onclick="WdatePicker()"
											name="s_feipiaoshenqingedate" type="text" id="s_tfshenqingedate" style="width: 79px;"
											value="<ww:property value="s_feipiaoshenqingedate"/>" /></td>
								  </ww:if>
								  <ww:else>
								   <td align="right" style=" height: 26px;"
											nowrap="nowrap">退废审核人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_tfshenheren" type="text" id="s_tfshenheren" style="width: 69px;"
											value="<ww:property value="s_tfshenheren"/>" /></td>
								   <td align="right" style=" height: 26px;"
											nowrap="nowrap">退废审核时间</td>
										<td  align="left" style="height: 26px;">
										<input onclick="WdatePicker()"
											name="s_tfshenhesdate" type="text" id="s_tfshenhesdate" style="width: 79px;"
											value="<ww:property value="s_tfshenhesdate"/>" />&nbsp;-&nbsp;<input onclick="WdatePicker()"
											name="s_tfshenheedate" type="text" id="s_tfshenheedate" style="width: 79px;"
											value="<ww:property value="s_tfshenheedate"/>" /></td>
								  </ww:else>									
								-->
								</tr>
								
								<!--
								
								<tr style="display: none">
									<td align="right" style=" height: 26px;">乘机人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_passengername" type="text" id="s_passengername"
											style="width: 69px;"
											value="<ww:property value="s_passengername"/>" /></td>
								   <ww:if test="getLoginsessionagent().agenttype==3">
								    <td align="right" style=" height: 26px;"
											nowrap="nowrap">预订人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_bookername" type="text" id="s_bookername" style="width: 69px;"
											value="<ww:property value="s_bookername"/>" /></td>
									   <td align="right" style=" height: 26px;"
											nowrap="nowrap">改签申请人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_gaiqianshenqingren" type="text" id="s_gaiqianshenqingren" style="width: 69px;"
											value="<ww:property value="s_gaiqianshenqingren"/>" /></td>
											<td align="right" style=" height: 26px;"
											nowrap="nowrap">改签申请时间</td>
									<td  align="left" style=" height: 26px;">
										<input onclick="WdatePicker()"
											name="s_gaiqianshenqingsdate" type="text" id="s_gaiqianshenqingsdate" style="width: 79px;"
											value="<ww:property value="s_gaiqianshenqingsdate"/>" />
											&nbsp;-&nbsp;
											<input onclick="WdatePicker()"
											name="s_gaiqianshenqingedate" type="text" id="s_gaiqianshenqingedate" style="width: 79px;"
											value="<ww:property value="s_gaiqianshenqingedate"/>" /></td>
								  </ww:if>
								  <ww:else>
								   <td align="right" style=" height: 26px;"
											nowrap="nowrap">出票人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_chupiaoname" type="text" id="s_chupiaoname" style="width: 69px;"
											value='<ww:property value="s_chupiaoname"/>'/></td>
								    <td align="right" style=" height: 26px;"
											nowrap="nowrap">改签审核人</td>
										<td align="left" style="height: 26px;"><input
											name="s_gaiqianshenheren" type="text" id="s_gaiqianshenheren" style="width: 69px;"
											value="<ww:property value="s_gaiqianshenheren"/>" /></td>
								  	<td align="right" style=" height: 26px;"
											nowrap="nowrap">改签审核时间</td>
									<td  align="left" style=" height: 26px;">
										<input onclick="WdatePicker()"
											name="s_gaiqianshenhesdate" type="text" id="s_gaiqianshenhesdate" style="width: 79px;"
											value="<ww:property value="s_gaiqianshenhesdate"/>" />-
											<input onclick="WdatePicker()"
											name="s_gaiqianshenheedate" type="text" id="s_gaiqianshenheedate" style="width: 79px;"
											value="<ww:property value="s_gaiqianshenheedate"/>" /></td>
								  </ww:else>
								  </tr>								
								-->
								<tr>
									<td align="right" style="height: 26px;">票号</td>
										<td align="left" style="height: 26px;"><input
											name="s_passengerfet" type="text" id="s_passengerfet"
											style="width: 69px;"
											value="<ww:property value="s_passengerfet"/>" /></td>
											<td align="right" style=" height: 26px;">乘机人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_passengername" type="text" id="s_passengername"
											style="width: 69px;"
											value="<ww:property value="s_passengername"/>" /></td>
											<!--
									<td align="right" >仓位</td>
									<td align="left" style=" height: 26px;">
									<input name="orderinfo.pnr" type="text"  style="width: 69px;"
											value='<ww:property value="orderinfo.pnr"/>' />
									</td>
									 -->
									 <ww:if test="getLoginsessionagent().agenttype==1">
									
									<td align="right" >采购商</td>
									<td align="left" style=" height: 26px;">
									<input name="agentname" type="text"  style="width: 69px;"
											value='<ww:property value="agentname"/>' />
									</td>
										
									<td align="right" style=" height: 26px;">订单类型</td>
										<td align="left" style=" height: 26px;">
										<select name="s_ordertype">
										<option value="0" <ww:if test="s_ordertype==0">selected</ww:if> >所有方式</option>
										<option value="2" <ww:if test="s_ordertype==2">selected</ww:if>>后台订单</option>
										<option value="1" <ww:if test="s_ordertype==1">selected</ww:if>>网站订单</option>
										</select>
										</td>
										
									</ww:if>
									
								   <!--
								   <ww:if test="getLoginsessionagent().agenttype==3">
									<td align="right" style=" height: 26px;"
											nowrap="nowrap">升舱换开申请人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_shengcangshenqingren" type="text" id="s_shengcangshenqingren" style="width: 69px;"
											value="<ww:property value="s_shengcangshenqingren"/>" /></td>
									<td align="right" style=" height: 26px;"
											nowrap="nowrap">升舱换开申请时间</td>
										<td  align="left" style=" height: 26px;">
										<input onclick="WdatePicker()"
											name="s_shengcangshenqingsdate" type="text" id="s_shengcangshenqingsdate" style="width: 79px;"
											value="<ww:property value="s_shengcangshenqingsdate"/>" />&nbsp;-&nbsp;
										<input onclick="WdatePicker()"
											name="s_shengcangshenqingedate" type="text" id="s_shengcangshenqingedate" style="width: 79px;"
											value="<ww:property value="s_shengcangshenqingedate"/>" /></td>
								  </ww:if>
								  <ww:else>
								  <td align="right" style=" height: 26px;"
											nowrap="nowrap">升舱换开审核人</td>
										<td align="left" style=" height: 26px;"><input
											name="s_shengcangshenheren" type="text" id="s_shengcangshenheren" style="width: 69px;"
											value="<ww:property value="s_shengcangshenheren"/>" /></td>
								 <td align="right" style=" height: 26px;"
											nowrap="nowrap">升舱换开审核时间</td>
										<td  align="left" style=" height: 26px;">
										<input onclick="WdatePicker()"
											name="s_shengcangshenhesdate" type="text" id="s_shengcangshenhesdate" style="width: 79px;"
											value="<ww:property value="s_shengcangshenhesdate"/>" />&nbsp;-&nbsp;
										<input onclick="WdatePicker()"
											name="s_shengcangshenheedate" type="text" id="s_shengcangshenheedate" style="width: 79px;"
											value="<ww:property value="s_shengcangshenheedate"/>" /></td>
								  </ww:else>									
								-->
								</tr>
								<tr>
								<tr>
								
								<ww:if test="getLoginsessionagent().agenttype==3||getLoginsessionagent().agenttype==1">
								<!--<td align="right">加盟商</td>
									<td align="left"  >
									    <div id='comboxWithTree'></div>
									    <input type='hidden' id="companyname" name="companyname" value='<ww:property value="companyname"/>' />
						                <input type="hidden" id="parentid" name="agentid" value='<ww:property value="agentid"/>' style="width: 350px" />
					   
									</td>
								-->
								<td align="right" style=" height: 26px;">国内/国际</td>
										<td align="left" style=" height: 26px;">
										<select name="s_guoneiguoji">
										<option value="0" <ww:if test="s_guoneiguoji==0">selected</ww:if> >所有订单</option>
										<option value="2" <ww:if test="s_guoneiguoji==2">selected</ww:if>>国内订单</option>
										<option value="1" <ww:if test="s_guoneiguoji==1">selected</ww:if>>国际订单</option>
										</select>
										</td>
								</ww:if>
								
								<ww:else>
								<td align="right" nowrap="nowrap">出票时间</td>
								     	<td align="left" colspan="3"><input
											name="s_beginprinttime" type="text"
											onclick="WdatePicker()" style="width: 79px;"
											value="<ww:property value="s_beginprinttime"/>" />&nbsp;-&nbsp;<input
											name="s_endprinttime" type="text"
											onclick="WdatePicker()" style="width: 79px;"
											value="<ww:property value="s_endprinttime"/>" /></td>
								</ww:else>
									<td align="right" style=" height: 26px;">支付方式</td>
										<td align="left" style=" height: 26px;">
										<select name="paytype">
										<option value="0" <ww:if test="paytype==0">selected</ww:if> >所有方式</option>
										<option value="1" <ww:if test="paytype==1">selected</ww:if>>网上支付</option>
										<option value="4" <ww:if test="paytype==4">selected</ww:if>>虚拟支付</option>
										</select>
										</td>
									<td align="right" style=" height: 26px;">航班号</td>
										<td align="left" style=" height: 26px;"><input
											name="s_flightnumber" type="text" id="s_flightnumber"
											style="width: 69px;"
											value="<ww:property value="s_flightnumber"/>" /></td>
								     	<td align="right" nowrap="nowrap">航班日期</td>
								     	<td align="left" colspan="6"><input
											name="s_beginchengji" type="text" id="s_beginchengji"
											onclick="WdatePicker()" style="width: 79px;"
											value="<ww:property value="s_beginchengji"/>" />&nbsp;-&nbsp;<input
											name="s_endchengji" type="text" id="s_endchengji"
											onclick="WdatePicker()" style="width: 79px;"
											value="<ww:property value="s_endchengji"/>" /></td>
											
										
								  		
								</tr>
								<tr>

									  <td colspan="10" align="center"><input type="submit"
											class="button_d font-white" id="btnsearch" value="查询订单" />
									  </td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td align="right" >
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
									   <ww:if test="getLoginsessionagent().agenttype==1">
										<td height="40" align="left"  style="padding-left: 30px;">
										提示：订单状态栏 中<font style="color: red">红色</font>部分为供应商订单状态.&nbsp;&nbsp;PNR栏中<font style="color: red">红色</font>PNR表示供应换PNR出票
										</td>
								     	</ww:if>
										<td>
										<div align="right">
										<ww:if test="getLoginsessionagent().agenttype==1">
											<a href="#"
												onclick='updateOrder("b2bticketorder!toeditorderinfo.action?id=")'><input
												type="button" value="修改" class="button_h font-red" /></a>&nbsp;&nbsp;
											<a href="#"
												onclick='deleteItem();'><input
												type="button" value="删除" class="button_h font-red" /></a>
												
										</ww:if>		
												
										&nbsp;&nbsp; <a href="#" onclick="showItem()"> <input
											type="button" value="查看" class="button_h font-red" /></a>
										&nbsp;&nbsp; <ww:if test="checkright('recinsure')">
											<a href="#"
												onclick='updateItem("insurance!buyInsurance.action?orderId=")'>
											<input type="button" value="采购保险" class="button_h font-red" /></a>
										</ww:if> &nbsp;&nbsp; <ww:if
											test="s_send==1 ||s_orderstatus==29||s_orderstatus==28 || s_cashier==1">
											<a href="#" onclick='printItem()'><input type="button"
												value="批量打印" class="button_h font-red" /></a>
											<ww:if test="s_orderstatus==29|| s_cashier==1">
												<a href="#" onclick='fenliprint()'><input type="button"
													value="分离打印" class="button_h font-red" /></a>
											</ww:if>
										</ww:if> <ww:if test="s_orderstatus==12">
											<a href="#" onclick='printItemtuipiao(2);'><input
												type="button" value="批量退票单" class="button_h font-red" /></a>
										</ww:if> <ww:elseif test="s_orderstatus==11">
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" style="border: 0px solid #99CBED">

													<tbody><tr>
														<td></td>
														<td align="left">
															<ul class="ul" style="width: 99%; position: relative; left: 1px;">
																
																<li id="li1"  <ww:if test="s_biangengstate==-1">class="xuanzhong"</ww:if>><a style="cursor: pointer"   href="b2bticketorder!AllChang.action" target="member">所有变更单</a></li>
																<li id="li2"  <ww:if test="s_biangengstate==3">class="xuanzhong"</ww:if>><a style="cursor: pointer"  href="b2bticketorder!AllChang.action?s_biangengstate=3" target="member">新申请待处理</a></li>
																<li id="li3" <ww:if test="s_biangengstate==4">class="xuanzhong"</ww:if> ><a style="cursor: pointer"  href="b2bticketorder!AllChang.action?s_biangengstate=4" target="member">审核通过,待付款</a></li>
																<li id="li19" <ww:if test="s_biangengstate==5">class="xuanzhong"</ww:if> ><a style="cursor: pointer"  href="b2bticketorder!AllChang.action?s_biangengstate=5" target="member"">变更完成</a></li>
																
																
															</ul>

															
														</td>
													</tr>
												</tbody></table>

						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">

											<th class="table_color" width="40" height="25">
											
											<input
												type="checkbox"  name="all1" value="1" onclick="selectall1()" />
											
												</th>
											<th class="table_color"><b>订单编号</b></th>
					
											<th class="table_color"><b>乘机人</b></th>
											<th class="table_color"><b>行程</b></th>
											<th class="table_color"><b>航班号</b></th>
											<th class="table_color"><b>PNR</b></th>
											<th class="table_color"><b>起飞时间/预订时间</b></th>	
											
											<th class="table_color"><b>总结算价</b></th>
											<th class="table_color"><b>出票速度</b></th>
											
											
											<!--
											<ww:if test="getLoginsessionagent().agenttype==1">
											<th class="table_color"><b>支付供应</b></th>
											</ww:if>
											 -->
											 <th class="table_color"><b>政策类型</b></th>
											 <th class="table_color"><b>返佣</b></th>
											
											
											<th class="table_color"><b>订单类型</b></th>
											<th class="table_color"><b>订单状态</b></th>
											<ww:if
												test="s_orderstatus==11||s_orderstatus==12||s_orderstatus==9||s_orderstatus==18">
												<th class="table_color"><b>票号</b></th>
												<th class="table_color"><b>废/退票费</b></th>
											</ww:if>
											<ww:else>
												<th class="table_color"><b>支付状态</b></th>
 											<ww:if test="getLoginUserAgent().agenttype==1">
											<th class="table_color"><b>供应状态</b></th>
											</ww:if>

												<!-- <th class="table_color"><b>处理人</b></th>-->
											</ww:else>
											<th class="table_color"><b>国内/国际</b></th>
											<th class="table_color"><b>操作</b></th>
										</tr>
										<ww:set name="agenttype" value="getLoginUserAgent().agenttype"/>
										<ww:iterator value="listOrderinfo">
											<ww:if test="internal==1">
											<ww:set name="segmentinfoss" scope="webwork"
												value="getInterSegmenentByOrderid(id)" />
											</ww:if><ww:else>
											<ww:set name="segmentinfoss" scope="webwork"
												value="getSegmenentByOrderid(id)" />
											</ww:else>
											
											<tr id="<ww:property value="id"/>" align="center"
												cashier="<ww:property value="cashier"/>"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color color_b3"><input
													type="checkbox" name="selectid"
													value="<ww:property value="id"/>" /></td>
												<td class="table_color color_b3" valign="middle" width="8%" style="word-break:normal">
												<div style="position: relative;">
													<a href="#" 
													onclick="window.open('b2bticketorder!showOrderdetail.action?id=<ww:property value='id'/>', 'newwindow<ww:property value='id'/>', 'height=800, width=1200, top=50, left=100, toolbar=no, menubar=no, scrollbars=yes,resizable=no,location=no, status=no');return false;"
													<ww:if test="isprint==1">style="color:#cccccc"</ww:if>>
													<ww:property value="ordernumber" />
													</a>
													<ww:if test="getLoginsessionagent().agenttype==1">
												 	<br />
												 	<a href="javascript:void(0);"
														onclick="shows(<ww:property value="id"/>,<ww:property value="converNull(policyagentid,0)"/>);">
												 	<font color='red'><b><ww:property value="getFamousAgentName(policyagentid)"/></b></font>
												 	</a>
													<br/>
													<a href="javascript:void(0);"
															onclick="shows(<ww:property value='id' />,<ww:property value='buyagentid' />);">
													<ww:property value='getagentname_b2bback(buyagentid)' />
													</a>
													</ww:if>
													
													<div style="display: none; position: absolute; width: 200px; left: -10px; background: #fefefe; padding-left: 20px; border: 2px solid #f48000; z-index: 999999"
													id="detail<ww:property value="id"/>"></div>
														</div>											
												</td>
												<!-- 乘机人姓名 -->
												<ww:set name="infos" value="getPassengerNamehtml(id,backpointinfo)"/>
												<td class="table_color color_b3">
												<ww:property value="#infos.get(0)" />												
												</td>
												
												<td class="table_color color_b3"><ww:property
													value="#segmentinfoss[1]" />
												</td>
												<td class="table_color color_b3"><ww:property
													value="#segmentinfoss[0]" /></td>
												<td class="table_color color_b3">
												<ww:if test="paystatus==0&&getLoginsessionagent().agenttype!=1">
												支付后可见
												</ww:if><ww:else>
												<ww:if test='pnr!=null&&!pnr.equals("无")'>
													<a href="#"
														onclick="copyToClipboard('txtpnr_<ww:property value="id"/>',true,'<ww:property value="id"/>');return false;"><ww:property
														value="pnr" /></a>
													<input id='txtpnr_<ww:property value="id"/>'
														style="display: none" type="text"
														value="<ww:property value="pnr"/>" />[小]
												</ww:if> 
												<ww:if test='bigpnr!=null&&!bigpnr.equals("无")'>
													<br/><a href="#"
														onclick="copyToClipboard('txtbigpnr_<ww:property value="id"/>',true,'<ww:property value="id"/>');return false;"><ww:property
														value="bigpnr" /></a>
													<input id='txtbigpnr_<ww:property value="id"/>'
														style="display: none" type="text"
														value="<ww:property value="bigpnr"/>" />[大]
												</ww:if>
												<ww:if test='newpnr!=null&&!newpnr.equals("")'>
													<br/><a href="#"
														onclick="copyToClipboard('txtnewpnr_<ww:property value="id"/>',true,'<ww:property value="id"/>');return false;">
														<font style="color: red"><ww:property value="newpnr" /></font></a>
													<input id='txtnewpnr_<ww:property value="id"/>'
														style="display: none" type="text"
														value="<ww:property value="newpnr"/>" />[换]
												</ww:if>
												</ww:else>
												</td>
												<td class="table_color color_b3"  <ww:property value="valadataTime(formatTimestamp2(dateToTimestamp(#segmentinfoss[2])))"/> >
												<span id='departtime<ww:property value="id"/>'><ww:property
													value="formatStringTime(#segmentinfoss[2])" /></span>
													<br />
												<ww:property value="formatTimestamptoMinute(createtime)" /></td>
												
												
												
												
												
												<td class="table_color color_b3">
												<!-- 结算价 -->
												￥<ww:property
														value="formatMoneyShort(converNull(currplatfee,0)+converNull(postmoney,0)+converNull(totalticketprice,0)+converNull(totalairportfee,0)+converNull(totalfuelfee,0)+converNull(getIssurByOrderid(id),0))" />
														</br>
														<ww:if test="getIssurByOrderid(id)>0"><span style="color: red">(含保险)</span></ww:if>
														<ww:if test="converNull(postmoney,0)>0"></br><span style="color: red">(含行程单)</span></ww:if>
														<ww:if test="getXCDByOrderid(id)>0"></br><span style="color: red">(含配送)</span></ww:if>
													</td>
													
													<!-- 销售价 -->
													<td class="table_color color_b3">
													<ww:if test="extordercreatetime==null||printtime==null">
													0分钟
													</ww:if><ww:else>





													<ww:property value="GetchupiaoTime(formatTimestampHHmm2(extordercreatetime),formatTimestampHHmm2(printtime))" />
										
													</ww:else>

													</td>

												
												
												
												
												
												
												
												
												<!--
												<ww:if test="getLoginsessionagent().agenttype==1">
												<td class="table_color color_b3">
												￥<ww:property value="converNull(extorderprice,'无记录')"/>
												</td>
												</ww:if>
												-->
												<td class="table_color color_b3">
												<ww:if test="receipt==1">普通</ww:if>
												<ww:if test="receipt==2"><img src="images/tsg.gif" /></ww:if>
												</td>
												<td class="table_color color_b3">￥
												<ww:if test="ticketinter==1">
												<ww:property value="getAgentRebatevalue_info(getLoginUserAgent().id,converNull(rebatemoney,0),1,getangtjibie(buyagentid))" />
												
												</ww:if>
												<ww:else>
												<ww:property value="#infos.get(1)" />
												</ww:else>
												</td>
												
												

												<td class="table_color color_b3">
												<ww:property value="ordertypestr"/>
												</td>
												<td class="table_color color_b3"  >
												 <ww:property value="getStateToString(orderstatus)" />
												 <ww:if test="orderstatus==4||orderstatus==5||orderstatus==13">
												 </br>
												 <span style="color: red">处理中</span>
												 </ww:if>
												 <br/>
												  <ww:if test="orderstatus==19"><a href="#" style="color: red" onclick="loddesc(<ww:property value="id" />);">查看原因</a></ww:if>
												  <input type="hidden" id="orderid_<ww:property value="id" />" value="<ww:property value="addresa" />" />
												    
												    <ww:if test="getLoginsessionagent().agenttype==1&&(extorderstatus==19||extorderstatus==20)">
												    </br>
													<font style="color: red"><ww:property value="getExtStateToString(extorderstatus)" /></font>
													 </ww:if>
												 
												 

												
												</td>
												<ww:if
													test="s_orderstatus==11||s_orderstatus==12||s_orderstatus==9||s_orderstatus==18">
													<td class="table_color color_b3"><ww:property
														value="getTicketnumByOrderid(id)" /></td>
													<td class="table_color color_b3"><ww:property
														value="returnprice" /></td>
												</ww:if>
												<ww:else>
													<!-- 支付状态 -->
													<td class="table_color color_b3" ><ww:property
														value="getPayStatus(paystatus)" /></td>
												</ww:else>
												
												 <ww:if test="getLoginsessionagent().agenttype==1">
												   <td class="table_color color_b3" >
													<font style="color: red"><ww:property value="getExtStateToString(extorderstatus)" /></font>
													</td>
													</ww:if>


												<!--  -->
												<td class="table_color color_b3">
												<!--
												<ww:property value="pickonephone"/>&nbsp;//出票速度
												-->
												<ww:if test="internal==1">国际</ww:if><ww:else>
												国内
												</ww:else>
												<!-- 国内/国际 -->
												</td>
												
												<!-- !处理人结束 -->
												
												<td class="table_color color_b3">
												<input type="hidden" id='orderstate<ww:property value="id"/>' value='<ww:property value="orderstatus"/>' />
												<!-- 订单操作开始 订单状态:1.等待支付2.支付成功3.出票完成4.申请废票5.申请退票6.取消订单7.等待审核8.审核失败9.退款成功10.订单关闭11.已经废票12.已经退票13.申请改签14.已经改签 -->
												<ww:set name="buypolicy" value='-1'/><!--buyagentid===login.agentid?  -->
											     <ww:if test="buyagentid==policyagentid">
											     <ww:set name="buypolicy" value='1'/><!--buyagentid===login.agentid?  -->
											    </ww:if>											    
											    <ww:set name="policyln" value='-1'/><!--buyagentid===login.agentid?  -->
										     	<ww:if test="policyagentid==getLoginsessionagent().id">
										        	<ww:set name="policyln" value='1'/><!--buyagentid===login.agentid?  -->
											    </ww:if>											    
											    <ww:set name="buyln" value='-1'/><!--buyagentid===login.agentid?  -->
											    <ww:if test="buyagentid==getLoginsessionagent().id">
										        	<ww:set name="buyln" value='1'/><!--buyagentid===login.agentid? 登录者所售加盟商订单  -->
											    </ww:if>
											<!-- 
												包含票到付款 
												此操作仅限于机票供应（已ty>0为标识）
												buyln==1 此订单为登陆着的订单
												agenttype==1 平台
												agenttype==2 供应
												buypolicy==1 自己的政策
												-->
<!-- 测试用 --><!--
												<input type="button" class="button108" id='cnbtnpay<ww:property value="id"/>' value="支付供应" onclick='topay(<ww:property value="id" />);' /><br/>
											 	
												<input type="button" class="button108" id='baoxian' value="添加儿童票" onclick="ToOnyUrl('b2bticketorder!toaddRTticket.action?s_orderid=<ww:property value="id" />');" /><br/>
												<input type="button" class="button108" id='baoxian' value="添加婴儿票" onclick="ToOnyUrl('b2bticketorder!toaddYEticket.action?s_orderid=<ww:property value="id" />');" /><br/>
												
												<input type="button" class="button108" id='baoxian' value="选择下单" onclick="ToOnyUrl('b2bticketorder!changagent.action?id=<ww:property value="id" />');" /><br/>
												
												<input type="button" class="button108" id='baoxian' value="购买保险" onclick="ToOnyUrl('insurance!toservicepass.action?orderId=<ww:property value="id" />');" /><br/>
												<input type="button" class="button108" id='baoxian' value="一键购买保险" onclick="ToOnyUrl('insurance!toservicepass.action?orderId=<ww:property value="id" />');" /><br/>
												

												
												<input type="button" class="button108" id="btnCancel" value="收差价/改期费"  onclick="ToOnyUrl('scang!toadd.action?orderinfoid=<ww:property value='id' />');" /> <br />
												<input type="button" class="button108" id="btnCancel" value="差价/改期支付"  onclick="ToOnyUrl('scang.action?orderinfoid=<ww:property value='id' />');" /> <br />
												<input type="button" class="button108" id="btnRRTicket" value="申请废票"   onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=5&pr=1','<ww:property value="id" />')" /><br/>
												<input type="button" class="button108" id="btnCancel" value="立即出票"  onclick='rrticket(<ww:property value="id" />);' /><br/>
												<input type="button" class="button108" id='btnpay<ww:property value="id"/>' value="立即支付" onclick='payorder(<ww:property value="id" />);' /><br/>	
												<input type="button" class="button108" id="btnRRTicket1" value="打印行程单"   onclick="popup('passenger!orderchupiao.action?orderinfoid=<ww:property value='id' />');" /> <br />
												<input type="button" class="button108" id="btnRRTicket1" value="打印信息单"   onclick="popup('passenger!orderchupiao2.action?orderinfoid=<ww:property value='id' />');" /> <br />
												<input type="button"  class="button108" id="btnRRTicket" value="申请退票"  onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=4&pr=2','<ww:property value="id" />')" /><br/>
												<input type="button"  class="button108" id="btnRRTicket" value="提交供应"  onclick="SubitToGys(<ww:property value="id" />)" /><br/>
												-->
												<!--
												<input type="button" class="button108" id="btnRRTicket1" value="打印行程单"   onclick="popup('passenger!orderchupiao.action?orderinfoid=<ww:property value='id' />');" /> <br />
												<input type="button" class="button108" id="btnCancel" value="立即出票"  onclick='rrticket(<ww:property value="id" />);' /><br/>
												 <input type="button" class="button108" id='btnpay<ww:property value="id"/>' value="立即支付" onclick='payorder(<ww:property value="id" />);' /><br/>						
											     <input type="button" class="button108" id='cnbtnpay<ww:property value="id"/>' value="支付供应" onclick='topay(<ww:property value="id" />);' /><br/>
												 <input type="button" class="button108" id="btnCancel" value="拒   单"  onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=19','<ww:property value="id" />')" /><br/>
												
												<input type="button" class="button108" id="btnCancel" value="拒  单"  onclick="jujue(<ww:property value="id" />);" /><br/>
												-->
												<!-- 测试用 -->
												<ww:if test='lockorder!=null&&lockorder.equals("true")'>
												    <input type="button" class="button108" id="btnCancel" value="订单解锁"  onclick='unlockorder(<ww:property value="id" />);' /> 
												</ww:if>
												<ww:else>
												<ww:if test="getLoginsessionagent().agenttype==1&&paystatus==1">
												 <input type="button" class="button108" id="btnCancel" value="收差价/改期费"  onclick="ToOnyUrl('scang!toadd.action?orderinfoid=<ww:property value='id' />');" /> <br />
												</ww:if>
												<ww:if test="ratevalue>0">
												<input type="button" class="button108" id='baoxian' value="添加儿童票" onclick="ToOnyUrl('b2bticketorder!toaddRTticket.action?s_orderid=<ww:property value="id" />');" /><br/>
												<input type="button" class="button108" id='baoxian' value="添加婴儿票" onclick="ToOnyUrl('b2bticketorder!toaddYEticket.action?s_orderid=<ww:property value="id" />');" /><br/>
												

												</ww:if>
												
												

														
												<ww:if test="ordervalue>0">
												
												</ww:if>
																			
											   <ww:if test="(orderstatus==19||orderstatus==27||orderstatus<3||(orderstatus==1&&paymethod!=3))&&(#buyln==1||#agenttype==1)">
												
<ww:if test="#agenttype==1">
<input type="button" class="button108" id='baoxian' value="选择下单" onclick="ToOnyUrl('b2bticketorder!changagent.action?id=<ww:property value="id" />');" /><br/>
</ww:if>
												

											    <ww:if test="orderstatus==27&&#agenttype==1||orderstatus==2">
											      <!-- 订单确认 国际和国内分别处理 -->
											     

												  
												  <!-- 订单确认 国际和国内分别处理 -->
												</ww:if>
												<ww:if test="#agenttype==1&&#buyln!=1&orderstatus!=19">
												  <!--
												  <input type="button" class="button108" id="btnCancel" value="拒   单"  onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=19','<ww:property value="id" />')" /><br/>
												  -->
												  <input type="button" class="button108" id="btnCancel" value="拒   单"  onclick="jujue(<ww:property value="id" />);" /><br/>
												
												</ww:if>


											
												<!--paystatus==1||#agenttype==1)&&#buyln==1&&policyagentid<10-->
												<!--
												<ww:if test="(paystatus==1||#agenttype==1)&&policyagentid<10">									
												  <input type="button" class="button108" id="btnCancel" value="取消外部订单"  onclick='cancel51bookorder(<ww:property value="#buyln"/>,<ww:property value="id" />);' /><br/>
											    </ww:if><ww:else>
											     <input type="button" class="button108" id="btnCancel" value="取消订单"  onclick='cancelorder(<ww:property value="#buyln"/>,<ww:property value="id" />);' /><br/>
											    </ww:else>
												-->
												<ww:if test="#agenttype!=1&&orderstatus==1&&paystatus!=1">
												  <input type="button" class="button108" id='btnpay<ww:property value="id"/>' value="立即支付" onclick='payorder(<ww:property value="id" />);' /><br/>						
												</ww:if>
												
											  </ww:if>
											  
												<ww:if test="(paystatus==0||orderstatus==1)&&orderstatus!=6">									
											     <input type="button" class="button108" id="btnCancel" value="取消订单"  onclick='cancelorder(<ww:property value="#buyln"/>,<ww:property value="id" />);' /><br/>
											    </ww:if>
											    <ww:if test="extorderid!=null&&paystatus==1&&#agenttype==1&&orderstatus<3">

											     <input type="button" class="button108" id='cnbtnpay<ww:property value="id"/>' value="支付供应" onclick='topay(<ww:property value="id" />);' /><br/>
											 	 </ww:if>
											
											  <!--
											  
											  -->
											  
											  <!--  -->
											 
											 

											  <ww:if test="ty>0&&(orderstatus==2||(orderstatus==1&&paymethod==3)||orderstatus==16)&&(#agenttype==1||#agenttype==2||(#agenttype==1&&#buypolicy==1))">
											  <!-- 暂不能出票转成待出票订单-->
											  
											    <ww:if test="orderstatus==16">								
												 <input type="button" class="button108" id="btnCancel" value="转成待出票"  onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=2','<ww:property value="id" />');" /><br/>												  
												</ww:if>
												<ww:else>
												<!-- extorderid==null||extorderstatus==1||extorderstatus==28||(extorderstatus==3&&orderstatus<3) -->
												<ww:if test="orderstatus==2">
												 <input type="button" class="button108" id="btnCancel" value="立即出票"  onclick='rrticket(<ww:property value="id" />);' /><br/>
												
												</ww:if>
												 <input type="button" class="button108" id="btnCancel" value="暂不能出票"  onclick="zanbunengchupiao(<ww:property value="id" />);" /><br/>
												</ww:else>												
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
											
												
												<ww:if test="arrayexist(orderstatus,new int[]{3,14,7,10,17,15,25,26,28,29})&&#buyln==1">
												<ww:if test="checkFeiPiaoValite(createtime)">
												<ww:set name="ftime" value="1"/>
												<input type="button" class="button108" id="btnRRTicket" value="申请废票"   onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=5&pr=1','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:else>
												<!--
												 <span style="color:red">废票时间已过<br /></span>
												-->
												</ww:else>
												
												<input type="button"  class="button108" id="btnRRTicket" value="申请退票"  onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=4&pr=2','<ww:property value="id" />')" /><br/>
												
												<input  type="button" class="button108" id="btnRRTicket" value="申请改签"  onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=13&pr=3','<ww:property value="id" />')" /><br/>
												
												<ww:if test="orderstatus!=3"><!-- 已经出票了就不要显示该按钮 -->
												<input  type="button" class="button108" id="btnRRTicket" value="升舱换开"  onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=23&pr=14','<ww:property value="id" />')" /><br/>
												
												</ww:if>
												
												
												<ww:if test="orderstatus==3&&ordertype==1">
												<input  type="button" class="button108" id="btnRRTicket1" value="配送订单"  onclick="showpeisong(<ww:property value="id" />);" />
												</ww:if>
												<ww:if test="orderstatus==28">
												<input type="button" class="button108" id="btnCancel" value="转到收银"  onclick="goEdit('orderinfo!editorderstatus.action?id=<ww:property value="id" />&orderstatus=29','<ww:property value="id" />')" /><br/>
												</ww:if>
												</ww:if>
												<ww:set name="chajia" value="GetIsChaJia(id)"/>
												<ww:if test="#chajia.status==1">

												<input type="button" class="button108" id="btnCancel" value="差价/改期支付"  onclick="ToOnyUrl('scang.action?orderinfoid=<ww:property value='id' />');" /> <br />
												</ww:if>	
												<ww:if test="#chajia.status==2">
												<span style="color: red">已补差价</span><br />
												</ww:if>
												<ww:if test="arrayexist(orderstatus,new int[]{29})&&#agenttype==1">
											       <input  type="button" class="button108" id="btnRRTicket1" value="收银"  onclick="shouyin(<ww:property value="id" />);" />											
												</ww:if>
							
											
											<ww:if test="ty>0&&arrayexist(orderstatus,new int[]{4,5,11,12,13,30})&&(#agenttype==1||#agenttype==2||(#agenttype==1&&#buypolicy==1))">
											   <input type="button"  class="button108" id="btnRRTicket" value="申请退分润"  onclick="alipaytui(<ww:property value="id" />)" /><br/>
												<br/>
												
												<ww:if test="orderstatus==5&&(#agenttype==1||#agenttype==2)&&#ftime==1">
												  <input type="button"  class="button108" id="btnRRTicket" value="提交供应"  onclick="SubitToGys(<ww:property value="id" />)" /><br/>
												<br/>
												</ww:if>												
											    <ww:if test="(#agenttype==1||#agenttype==2)&&orderstatus==5">
												    <input type="button" class="button108" id="btnRRTicket" value="废票审核"   onclick="goEdit2('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=11&pr=1','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:if test="orderstatus==4&&(#agenttype==1||#agenttype==2)">
													<input type="button"  class="button108" id="btnRRTicket" value="提交供应"  onclick="SubitToGys(<ww:property value="id" />)" /><br/>
												<br/>
												</ww:if>
										        <ww:if test="(#agenttype==1||#agenttype==2)&&orderstatus==4">						
												   <input type="button" class="button108" id="btnRRTicket" value="退票审核"   onclick="goEdit2('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=12&pr=2','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:if test="orderstatus==30">
													<input type="button" class="button108" id="btnRRTicket" value="换开审核"   onclick="goEdit2('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=25&pr=14','<ww:property value="id" />')" /><br/>
												</ww:if>
												<ww:if test="orderstatus==13&&(#agenttype==1||#agenttype==2)">
												  <input type="button" class="button108" id="btnRRTicket" value="改签审核"   onclick="goEdit2('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=14&pr=5','<ww:property value="id" />')" /><br/>
												</ww:if>
												
												<ww:if test="orderstatus==11">
													<input type="button" class="button108" id="btnRRTicket" value="废票退款"   onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=9&pr=6','<ww:property value="id" />')" /><br/>
													<input type="button" class="button108" id="btnRRTicket1" value="打印废票单"   onclick='printtuipiaodan(<ww:property value="id" />,1)' />
												</ww:if>
												<ww:if test="orderstatus==12">
												  <input type="button" class="button108" id="btnRRTicket" value="退票退款"   onclick="goEdit('b2bticketorder!editorderstatus.action?id=<ww:property value="id" />&orderstatus=18&pr=7','<ww:property value="id" />')" /><br/>												
												  <input type="button" class="button108" id="btnRRTicket1" value="打印退票单"   onclick='printtuipiaodan(<ww:property value="id" />,2)' />												
												</ww:if>	
											</ww:if>	
												
											</ww:else>		
													<!-- 订单操作结束 -->
												</td>												
											</tr>											
										</ww:iterator>
									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center">
								
								    <ww:property value="getPagination('\"b2bticketorder!AllChang.action?pageinfo.pagenum=\"+pageno')"/>
							      
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
			<li style="color: Red;">票号和EI项可以在订单修改页面添加</li>
			<li>点击"订单号"即可查看订单详细</li>
		</ul>
		</td>
	</tr>
	<tr>
		<td>
		<table border="1" width="73%" style="display: none">
			<tr>
				<td width="34%">
				<p style="line-height: 150%"><font color="#000000"> 1：<input
					type="checkbox" id="C1" checked>位置移动和宽高调整<br>
				2：<input type="checkbox" id="C2" checked>颜色选择<br>
				3：<input type="checkbox" id="C3" checked>字体名选择<br>
				4：<input type="checkbox" id="C4" checked>字大小选择<br>
				5：<input type="checkbox" id="C5" checked>旋角调整<br>
				6：<input type="checkbox" id="C6" checked>粗斜体功能条<br>
				7：<input type="checkbox" id="C7" checked>线型功能条</font>
				</td>
				<td width="66%">
				<p style="line-height: 150%"><font color="#000000">
				&nbsp;8：<input type="checkbox" id="C8" checked>对齐功能条<br>
				&nbsp;9：
				<input type="checkbox" id="C9">删除功能<br>
				10：<input type="checkbox" id="C10">页眉设置<br>
				11：<input type="checkbox" id="C11">页脚设置<br>
				12：<input type="checkbox" id="C12">位置锁定功能<br>
				13：<input type="checkbox" id="C13">属性设置<br>
				14：<input type="checkbox" id="C14" checked>显示关闭钮(界面内嵌时)</font>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
<div
	style="width: 100%; background-color: Gray; display: none; height: 100%; position: absolute; left: 0; top: 0;"
	id="xie">
<div
	style="width: 260px; background-color: Gray; display: none; height: 113px; position: absolute; left: 244px; top: 137px;"
	id="content1"></div>

</div>


<form action="" target="_blank" id="form4" name="form4">
  <input type="hidden" name="paymethod" id="paymethod" value="directPay" />
	 <input type="hidden" name="Billpaymethod" id="Billpaymethod" value="12" /> 
	 <input type="hidden" name="orderid" id="orderid" value="" />

</form>
 <input type="hidden" name="hidjudanorderid" id="hidjudanorderid" value="0" />
</body>
</html>

<script language="JavaScript">


function topay(id){
document.getElementById("orderid").value=id;
 document.form4.action="../ticket_inter/Jinripay";
 document.form4.submit();
}

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
					document.form1.action="b2bticketorder!showOrderdetail.action?id="+selectId;
					document.form1.submit();
					
				}
            }
            <ww:if test="getLoginsessionagent().agenttype==1">
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="b2bticketorder!toeditorderinfo.action?id="+selectId;
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
	  
	  
	  
	  
	  
	  function updateOrder(action){
			var length=document.form1.selectid.length;			
			//唯一项
			
			
						
			
			if(length== undefined){			
				if(document.form1.selectid.checked ==true)
				{	var uvalue=document.form1.selectid.value;
					
						document.form1.action=action+uvalue;
						
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
				              
					      		document.form1.action=action+uvalue;
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
						  //document.form1.action="b2bticketorder!delete.action?id="+document.form1.selectid.value;
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
						//document.form1.action="b2bticketorder!delete.action?id="+uvalue;
						//document.form1.submit();
						printallitem(uvalue);
					}
					return;
			      }else if (len>1){
			      	var temp = confirm('确认批量打印吗？');
			      	if(temp==true){
			      		//document.form1.action="b2bticketorder!batch.action?opt=1";
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
						  //document.form1.action="b2bticketorder!delete.action?id="+document.form1.selectid.value;
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
						//document.form1.action="b2bticketorder!delete.action?id="+uvalue;
						//document.form1.submit();
						piliangdayintuipiao(uvalue,state);
					}
					return;
			      }else if (len>1){
			      	var temp = confirm(confstr);
			      	if(temp==true){
			      		//document.form1.action="b2bticketorder!batch.action?opt=1";
						//document.form1.submit();
						piliangdayintuipiao(uvalue,state);
					}
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
						
						document.form1.action="b2bticketorder!showOrderdetail.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="b2bticketorder!showOrderdetail.action?id="+uvalue;
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
   // 上传
  function uplod(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="air/uplod.jsp";
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
					      		document.form1.action="air/uplod.jsp";
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

function unlockorder(id){
     $.ajax({
            type:"POST",
            url:"b2bticketorder!unlockorder.action",
            data:{strTuiOrderID:id},           
            success:function(data){
            alert(data);         
            }            
            });
     window.location.href=window.location.href;
  }
  
  //个人挂账还款
 function guazhanghuankuan(orderid,employeeid)
 {
    $("#divpassenger").dialog({
            title:'个人挂账还款',
            show: null,
            bgiframe: false,
            autoOpen: false,
            draggable: true,                
            resizable: true,
            modal: true,
            width: 800,
            height: 400
	});
   $("#divpassenger").dialog("open");
   $.ajax({
      type:"POST",
      url:"b2bticketorder!showguazhang.action",
      data:{strTuiOrderID:orderid},
      beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
      success:function(data){
      $("#divpassenger").html(data);           
      }            
      });
 }
//还款操作
function dohuankuan(orderid,employeeid,allmoney)
{
   $.ajax({
      type:"POST",
      url:"b2bticketorder!dohuankuan.action",
      data:{strTuiOrderID:orderid,s_employeeid:employeeid,hkprice:allmoney},
      beforeSend:function(){$("#divpassenger").html("正在加载订单信息...");},             
      success:function(data){
      alert(data);
      closedialog2(); 
      window.location.reload();

      }            
      });
}
function closedialog2()
 {
        $("#divpassenger").dialog("close");

 }
 
 
 
 function subform(orderid){
 		
         if(confirm("是否确定提交?")){
             document.payform.submit();   
             }
}


function unlockorder(orderid){
   if(confirm("是否确定对当前订单解锁？")){
    window.location.href='b2bticketorder!unlockorder.action?id='+orderid+"&lockorder=true";
    }
}


function checkTuiFei(orderid){
 var TuiFeiID=document.getElementById("TuiFeiId").value;
 var hidTuoOrFei=document.getElementById("hidTuoOrFei").value;
 
 //alert("orderid="+orderid);
 //alert("TuiFeiID="+TuiFeiID);
 	if(confirm("是否确定对当前订单退/废操作？")){
    //window.location.href='b2bticketorder!TuiFeiOrder.action?id='+orderid+"&whyid="+TuiFeiID+"&hidTuoOrFei="+hidTuoOrFei;
      $.ajax({
      type:"POST",
      url:"b2bticketorder!TuiFeiOrder.action",
      data:{strTuiOrderID:orderid,whyid:TuiFeiID,hidTuoOrFei:hidTuoOrFei},
      success:function(data){
      	if(data=='ok'){
      	alert("提交申请成功!");
      	window.location.href="b2bticketorder.action?s_orderid="+orderid;
      	}else{
      	
      	alert("提交申请失败!"+data);
      	window.location.href="b2bticketorder.action?s_orderid="+orderid;
      	}
      }            
      });
 }
 
}


var gwin;
	function grefresh(){
	
	  if(gwin){
	 	
	  
			gwin.close();
			 window.location.reload();
		}
	}
	function grefreshClose(){
	
	  if(gwin){
	 	
	  
			gwin.close();
			 
		}
	}

  //申请变更
function applyPolicyOrderChange(id){
alert("如需变更乘机人姓名,证件号码请致电我公司客服或与航空公司联系!谢谢合作!");				
			  		
}
 //申请变更
function applyPolicyOrderChange2(id){
				var	title="申请变更";
				var url="changpass!tochang.action?s_orderid="+id;
				if(gwin){gwin.close();}
				gwin= Ext.create('Ext.Window', {
				   title: title,
			        maximizable: true,
			        width: 810,
			        height: 450,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src='+url+' width="100%" height="100%" s frameborder="0"  ></iframe>'
		
			        }
			        ]
			        
			  		});
			  		gwin.show();	
			  		
}


function loddesc(id){
var descinfo=document.getElementById("orderid_"+id).value;
alert(descinfo);
}
 
 
 function jujue(id){

 //hidjudanorderid
 document.getElementById("hidjudanorderid").value=id;
 
  //$("#divpassenger").val(id);
  Ext.MessageBox.show({
           title: '拒单原因',
           msg: '请填写您的拒单原因(200字以内):',
           width:350,
           buttons: Ext.MessageBox.OKCANCEL,
           multiline: true,
           fn: showResultText
       });


 }
  function showResultText(btn, text){
  var orderid= document.getElementById("hidjudanorderid").value;
	// alert("btn:"+btn+",text:"+text+",orderid:"+orderid);
	 if(btn=='ok'){
	 
	 
	 window.location.href="b2bticketorder!editorderstatus.action?id="+orderid+"&orderstatus=19&beizhu="+text;
	 //alert("ok");
	 }else{
	 //alert("CANCEL");
	 }
	 
	 
  }
  
 function SubitToGys(orderid){
 		$.ajax({
	         type:"POST",
	         async:false,
	         url:"b2bticketorder!ajaxTuiFeiToGys.action?rndmath="+Math.floor(Math.random()*100),
	         data:{strTuiOrderID:orderid},
	         success:function(data){
	         	if(data){
	         	
	         	if(data=='-1'){
	         	alert("提交失败!");
	         	}else if(data=='-2'){
	         	alert("提交失败!没有对应的乘机人");
	         	}else{
	         	alert("申请成功,退废订单号:"+data);
	         	}
	         	
	         	}else{
	         	alert("提交失败!");
	         	}
	        
	         }            
	         });
 
  
  
  }
 
 
 function shows(id,agentid){
		 
		$("#detail"+id).show();
		
		$.ajax({
			type:'post',
			url:'customeragent!ajaxtoCustomeragent.action?customeragent.id='+agentid,
			async:false,
			success:function(data){
				var json = eval("("+data+")");
				data=json;
				//alert(data);
				//alert(data.agentphone);
				//data.agenttype=3;
				if(data == null){
					$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>对不起，无详细信息！</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr></table>");
					
				}else{
				if(data.agenttype == 3){
					$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>业务联系人:</td><td style='color:#f48000;'>"+data.agentcontactname+"</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr><tr><td style='color:#000;'>业务人电话:</td><td colspan='2' style='color:#f48000;'>"+data.agentphone+"</td></tr><tr><td style='color:#000;'>业务人QQ:</td><td  colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.msnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.msnqq + ":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr></table>");
				}else{
					if(data.agenttype == 2){  
					$("#detail"+id).html("<table style=' text-align:left' width='100%'><tr><td style='color:#000;'>业务联系人:</td><td style='color:#f48000;'>"+data.agentcontactname+"</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr><tr><td style='color:#000;'>业务人电话:</td><td  colspan='2' style='color:#f48000;'>"+data.agentphone+
						"</td></tr><tr><td style='color:#000;'>业务人QQ:</td><td colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.msnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.msnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr><tr><td style='color:#000;'>出票人电话:</td><td>"+data.outticketmantel+
						"</td></tr><tr><td style='color:#000;'>出票人QQ:</td><td colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.outticketmanmsnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.outticketmanmsnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr><tr><td style='color:#000;'>退票人电话:</td><td  colspan='2' style='color:#f48000;'>"+data.backticketmantel+"</td></tr><tr><td style='color:#000;'>退票人QQ:</td><td  colspan='2' style='color:#f48000;'><a target='_blank' href='http://wpa.qq.com/msgrd?v=3&uin="+data.backticketmanmsnqq+"&site=msnqq&menu=yes'><img border='0' src='http://wpa.qq.com/pa?p=2:"+data.backticketmanmsnqq+":41' alt='点击这里给我发消息' title='点击这里给我发消息'></a></td></tr></table>");
					}
					if(data.agenttype == 1){
						$("#detail"+id).html("<table style='color:#f48000;text-align:left' width='100%'><tr><td style='color:#000;'>对不起，不能查看运营商的信息！</td><td align='right' style='font-size:12px; color:#000;text-align:right;'><input type='button' value='关闭X' onclick='hides("+id+")'/></td></tr></table>");
					}
				}
				}
			} 
		});
		
	}
	function hides(id){
		$("#detail"+id).hide();
	}
	function ToOnyUrl(url){
	//$("#divpassenger").show();
	$("#divpassenger").dialog({
            title:'正在为你加载中!!!',
            show: null,
            bgiframe: false,
            autoOpen: false,
            draggable: true,                
            resizable: true,
            modal: true,
            width: 800,
            height: 400
	});
   $("#divpassenger").dialog("open");
   
		window.location.href=url;
	}
	
	function tobaoxian(id){
	alert(id);
		window.location.href="insurance!toservicepass.action?orderId="+id;
	}
	
	
function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="b2bticketorder!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="b2bticketorder!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="b2bticketorder!batch.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  	}
	
	
	 function alipaytui(orderid){
		 
		$.ajax({
	         type:"POST",
	         async:false,
	         url:"b2bticketorder!alipay_tuifenrun.action?rndmath="+Math.floor(Math.random()*100),
	         data:{strTuiOrderID:orderid},
	         success:function(data){
	         	if(data){
		         	if(data=='-1'){
		         	alert("申请失败!");
		         	}else if(data=='1'){
		         	alert("申请成功!");
		         	}else{
		         	alert("申请失败!");
		         	}
	         	}else{
	         	alert("申请失败!");
	         	}
	        
	         }            
	         });
 
  
		
	}
	
</script>








