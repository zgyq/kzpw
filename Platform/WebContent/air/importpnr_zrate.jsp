<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!doctype html public "-//w3c//dtd html 4.01 transitional//en"
"http://www.w3.org/tr/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.List"%>
<%@page import="com.yf.system.base.customeruser.Customeruser"%>
<%@page import="com.yf.system.atom.server.Server"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>pnr创建订单</title>
<style type="text/css">
.hide {
	display: none;
}
</style>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script type="text/javascript"> 
 $(document).ready(function () {

     //  getthereate(1);
       
       //第一条政策点击
       $("#txtzhekoubili").val(<ww:property value="ListZrate1.get(0).ratevalue" />);
       
       $("#hidoffice").val('<ww:property value="ListZrate1.get(0).workstatus" />');
       
       //alert($("#txt_hidefirstrate").val());
      showremark($("#txt_hidefirstrate").val());
       
       if(document.getElementById("rdozrate_0")!=null)
       {
           document.getElementById("rdozrate_0").click();
       }
       var passcount=0;
       $("span[id*='span_passname_']").each(function(i)
       {
          passcount++;
       }
       );
       
      
     
       

    });
    function getthereate(flag)
    {
       if($("#hidsegint_size").val()>0)
       {
           for(var n=0;n<$("#hidsegint_size").val();n++)
           {
		       $.ajax({
		            type:"POST",
		            url:"orderinfo!Findallzrate.action",
		            async:false,
		            data:{z_startcity:$("#hidsairport_"+n).val(),z_endcity:$("#hideairport_"+n).val(),z_fromdate:$("#hidfromdate_"+n).val(),intflag:1,strAirCompany:$("#hidaircompany_"+n).val(),strAirline:$("#hidflightnumber_"+n).val(),strCabin:$("#hidcabin_"+n).val(),strratePrice:$("#ticketprice_0").val()},
		            beforeSend:function(){$("#divpolicyinfo_"+n).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
		            success:function(data){
		            $("#divpolicyinfo_"+n).html(data);   
		            }            
		       });
	       }
       }
    }
    function showallreate()
    {   
        $("#button_more").hide();
        $("#button_less").show();
        $("tr[id*='tr_rateinfo_']").each(function(i)
	      {
	         $("#tr_rateinfo_"+i).show();
	      });
    }
    function hideallreate()
    {
        $("#button_more").show();
        $("#button_less").hide();
        $("tr[id*='tr_rateinfo_']").each(function(i)
	      {
	         if(i>=4)
	         {
	            $("#tr_rateinfo_"+i).hide();
	         }
	         else
	         {
	            $("#tr_rateinfo_"+i).show();
	         }
	         
	      });
    }
    function gettheratesep2(index,flag)
    {
       if($("#hidsegint_size").val()>0)
       {
           for(var n=0;n<$("#hidsegint_size").val();n++)
           {
		       $.ajax({
		            type:"POST",
		            url:"orderinfo!Findallzrate.action?intflag="+flag,
		            data:{z_startcity:$("#hidsairport_"+n).val(),z_endcity:$("#hideairport_"+n).val(),z_fromdate:$("#hidfromdate_"+n).val(),intflag:flag,strAirCompany:$("#hidaircompany_"+n).val(),strAirline:$("#hidflightnumber_"+n).val(),strCabin:$("#hidcabin_"+n).val(),strratePrice:$("#ticketprice_0").val()},
		            beforeSend:function(){$("#divpolicyinfo_"+index).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
		            success:function(data){
		            $("#divpolicyinfo_"+index).html(data);   
		            }            
		       });
	       }
       }
    }
function showcredit(state){
if(state==1){

$("#syscodetab").show();
$("#cc").show();
}else{
$("#cc").hide();
$("#syscodetab").hide();
}

}
function  showPeisong(v){
if(v==1){
 showdiag('addtesstable','none');
}
}
function showneedIssuetime(type,fk){
if(type==1||type==2){
 if(fk==2||fk==3){
 $("#needissuetime").show(); $(".ctime").hide();
 }else{
 $("#needissuetime").hide();
   }
 }
}
function showtickettype(){
var type=$("#pnrorderstatu").val();
 $("#needissuetime").hide();
if(type!=1){
 $(".tickt").show();
 $(".ctime").show();
 $("#printmsg").show();
$("#printmsg1").show();
}else{
$(".tickt").hide();
 document.getElementById("s_paystatus").options[0].selected=true; 
 $(".ctime").hide();
$("#printmsg").hide();
$("#printmsg1").hide();
 }
 
 if(type==2){
 $(".tickt").hide();
$(".ctime").hide();
 $("#rdopaymethod2").trigger("click");
 document.getElementById("s_paystatus").options[1].selected=true; 
 }
var fk =getrdovalue("s_paymethods");
 showneedIssuetime(type,fk);
 }
$(document).ready(function(){
showtickettype();
 <ww:if test="#session.orderuserlogin.agentid==46l">
 showaddress();
 </ww:if>
 <ww:if test="#session.orderuserlogin.agentid==46l">
showaddress();
 </ww:if>
 <ww:else>
$("#rdopaymethod2").trigger("click");
 </ww:else>
});

function showaddress()
{
  $("#rdopaymethod3").trigger("click");
}

function selectzhifu(index){
 if(index==1)
 {
   document.getElementById("s_paystatus").options[1].selected=true; 
 }
 else if(index==0)
 {
   document.getElementById("s_paystatus").options[0].selected=true; 
 }
}


function showremarkAndvalue(id,va,officecode){
$("#txtzhekoubili").val(va);
$("#hidoffice").val(officecode);
	showremark(id);

 		
       if(document.getElementById("rdozrate_0")!=null)
       {
           document.getElementById("rdozrate_0").click();
       }
       var passcount=0;
       $("span[id*='span_passname_']").each(function(i)
       {
          passcount++;
       }
       );
       
       

}


 function showremark(id)
   {
   
  
       $("tr[id*='remark_']").each(function(i)
	      {
	         $(this).hide();
	      });
       $("#remark_"+id).show();
       $("#txthidrate").val(id);
       $("#hid_zrateid").val(id);
       $("#txtzhekoubili").val($("#liudianvalue_"+id).val());
       
       var passcount=0;
       $("span[id*='span_passname_']").each(function(i)
       {
          //$("#ticketprice_"+i).val($("#danzhangjiesuanjia_"+id).html());
          passcount++;
       }
       );
       //总返点
        $("#hid_zongfandian").val($("#hidzongfandian_"+id).val());
        //计算总利润
       accountPrice("1");
       
   }


function showluru(state,id){
if(state==1){
$("#ss").show();
$("#sstable").val(1);
}else{
$("#ss").hide();
$("#sstable").val("");
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



</script>
<script language="javascript">
   function showdiag(diag,flag)
	{
		document.getElementById(diag).style.display=flag;
	}

   function rTPnr()
    {
       var etermtype=1;
       if(document.getElementById("rdoetermtype1").checked)
       {
          etermtype=1;
       }
       else if(document.getElementById("rdoetermtype2").checked)
       { 
         etermtype=2;
       }
       $("#pnrinfo").show();
       $.ajax({
            type:"POST",
            url:"orderinfo!rtPNRinfo.action",
            data:{strPNR:$("#txtpnrcode").val(),etermtype:etermtype},
            beforeSend:function(){$("#pnrinfo").html("<img src='images/loadpnr.gif' /><font color='00ff00'><b>正在加载PNR信息.....</b></font>");},             
            success:function(data){
            $("#pnrinfo").html(data);           
            }            
            });
    }
    function accountPrice(value)
    {
       var totalprice="0";
       var totaltaxprice="0";
       var totalyqprice="0";
       var totalanjianfee="0";
       var totalotherfee="0";
       var zonglirun=parseFloat((formatFloat($("#ticketquanprice_0").val(),2)*formatFloat($("#txtzhekoubili").val(),1)));
       
	   $("#hid_zonglirun").val(Math.round(zonglirun)/100);
	   $("#hid_zonglirun").val(parseInt($("#hid_zonglirun").val(),0));
	   //票面价
	   $("#hid_piaomianjia").val($("#ticketquanprice_0").val());
       $("#txtzhekoujine").val(formatFloat($("#totalPrice").val(),2));
       $("#txttotalzhekoujine").val(formatFloat($("#totalPrice").val(),2)+formatFloat($("#totaltaxprice").val(),2)+formatFloat($("#totalyqprice").val(),2));
       $("#txtzongjiage").val($("#txttotalzhekoujine").val());
       $("#txthidzongjiage").val($("#txttotalzhekoujine").val());
       $("#txthidtotalzhekoujine").val(formatFloat($("#txttotalzhekoujine").val(),0));
       $("#txttotalzhekoujine").val(formatFloat($("#txttotalzhekoujine").val(),0));
       //票面价
       
       $("input[id*='ticketprice_']").each(function(i)
       {
          var price1=$(this).val();
          totalprice=parseFloat(totalprice);
          if((value==1 && (parseFloat($("#ticketquanprice_"+i).val())-parseInt(parseFloat($("#hid_zonglirun").val()),0)>0)) && ($("#txt_passtype_"+i).val()=="1" || $("#txt_passtype_"+i).val()=="2" ))
          {
             if($("#txt_passtype_"+i).val()=="1")
             {
               $("#ticketprice_"+i).val(parseFloat($("#ticketquanprice_"+i).val())-parseInt(parseFloat($("#hid_zonglirun").val()),0));
             }
             else if($("#txt_passtype_"+i).val()=="2")
             {
                //zonglirun=parseFloat((formatFloat($("#ticketquanprice_0").val(),2)*0.025));
                //$("#txtzhekoubili").val("2.5")
                //$("#ticketprice_"+i).val(parseFloat($("#ticketquanprice_"+i).val())-parseInt(zonglirun));
                
                $("#ticketprice_"+i).val(parseFloat($("#ticketquanprice_"+i).val())-parseInt(parseFloat($("#hid_zonglirun").val()),0));
                 var varindex=parseInt($("#zratelength").val())-1;
                 
	           // document.getElementById("rdozrate_"+varindex).click();
	           //其他按钮禁用
	          //  $("input[id*='rdozrate_']").each(function(i){
		       //      $(this).attr("disabled",true);
		        //});
		        showallreate();
             }
          }
          changepasssession(i,"ticketprice");
          //$("#ticketprice_"+i).val(formatFloat($("#ticketprice_"+i).val()));
          if($(this).val()!="")
          {
            totalprice+=parseFloat($(this).val()); 
          }
       }
       );
       $("#totalPrice").val(totalprice);
       //机建费
       $("input[id*='taxprice_']").each(function(i)
       {
          var price2=$(this).val();
          totaltaxprice=parseFloat(totaltaxprice);
          if($(this).val()!="")
          {
          totaltaxprice+=parseFloat($(this).val()); 
          }
       });
       $("#totaltaxprice").val(totaltaxprice);
       
       //CHG
       $("input[id*='yqprice_']").each(function(i)
       {
          var price3=$(this).val();
          totalyqprice=parseFloat(totalyqprice);
          if($(this).val()!="")
          {
          totalyqprice+=parseFloat($(this).val()); 
          }
          
       });
       $("#totalyqprice").val(totalyqprice);
       
       
       //anjian
       $("input[id*='anjianfee_']").each(function(i)
       {
          var price3=$(this).val();
          totalanjianfee=parseFloat(totalanjianfee);
          if($(this).val()!="")
          {
          totalanjianfee+=parseFloat($(this).val()); 
          }
          
       });
       $("#totalanjian").val(totalanjianfee);
       
       
       //other
       $("input[id*='otherfee_']").each(function(i)
       {
          var price3=$(this).val();
          totalotherfee=parseFloat(totalotherfee);
          if($(this).val()!="")
          {
          totalotherfee+=parseFloat($(this).val()); 
          }
          
       });
       
       $("#totalotherfee").val(totalotherfee);
       //计算小计
       $("td[id*='pprice']").each(function(i){
       var tickeprice=$("#ticketprice_"+i).val();
       var fuelprice=$("#yqprice_"+i).val();
       var airprice=$("#taxprice_"+i).val();
       var anjian=0;
       var other=0;
       if(document.getElementById("otherfee_"+i)!=null){
     //  anjian=$("#anjianfee_"+i).val();
        other=$("#otherfee_"+i).val();
       }
       var allprice=parseInt(converSpace(tickeprice))+parseInt(converSpace(fuelprice))+parseInt(converSpace(airprice))+parseInt(converSpace(other));
       $("#iprice"+i).val(allprice);
       });
       
        $("#txtzhekoujine").val(formatFloat($("#totalPrice").val(),2));
       $("#txttotalzhekoujine").val(formatFloat($("#totalPrice").val(),2)+formatFloat($("#totaltaxprice").val(),2)+formatFloat($("#totalyqprice").val(),2));
       $("#txtzongjiage").val($("#txttotalzhekoujine").val());
       $("#txthidzongjiage").val($("#txttotalzhekoujine").val());
       $("#txthidtotalzhekoujine").val(formatFloat($("#txttotalzhekoujine").val(),0));
       $("#txttotalzhekoujine").val(formatFloat($("#txttotalzhekoujine").val(),0));
     
      acounttkprice();
      
    }
    function converSpace(v){
    if(v==""||v==0){
    return 0;
    }else{
    return v;
    }
    }
    //创建订单
    function createorder()
    { 
          var orderstatu=$("#s_paystatus").val();
	      $("#corderstatus").val(orderstatu);
	      //alert(orderstatu);
	      //return;
	      
	      document.form1.action="orderinfo!toaddorder2.action";
	      document.form1.method = "POST"; 
	      dispose('系统正在创建订单');
	      document.form1.submit();
     
            
    }
   function formatFloat(src, pos)
   {
    return Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);
   }
    //数据验证
    function checkorderdata()
    {
    var zid='<ww:property value="ListZrate1.size" />';
    
    //alert(zid);
    	if(zid==''||zid=="0"){
    		alert("没有匹配上政策,请从新刷新匹配,或者联系管理员!");
    		return;
    	}
    
    				var office=$("#hidoffice").val();
    				
    				
    				//alert(office);
    				var temp = confirm("确认是否已经对 "+office+" OFFICE号授权,否则将不能出票!!!确定后可以快捷复制授权指令!");
    				var sub="RMK TJ AUTH "+office+"";
    				window.clipboardData.setData('text',sub); 
						if(temp==false){
						
							return;
						}
    
         //判断航程信息
         //出发城市
         var arrivecityflag="0";
         $("input[id*='arrcity_']").each(function(i)
          {
	          if($(this).val()=="")
	          {
	              arrivecityflag=1;
	          }
         }
         );
         if(arrivecityflag=="1")
         {
             alert("出发城市为必填项，请重新填写机场三字码!");
             return false;
         }
         //到达城市
          var tocityflag="0";
         $("input[id*='tocity_']").each(function(i)
          {
	          if($(this).val()=="")
	          {
	              tocityflag=1;
	          }
         }
         );
         if(tocityflag=="1")
         {
             alert("到达城市为必填项，请重新填写机场三字码!");
             return false;
         }
         //出发时间
         var departtimeflag="0";
         $("input[id*='departtime_']").each(function(i)
          {
	          if($(this).val()=="")
	          {
	              departtimeflag=1;
	          }
         }
         );
         if(departtimeflag=="1")
         {
             alert("出发时间为必填项，请重新填写!");
             return false;
         }
         //到达时间
         var arrivetimeflag="0";
         $("input[id*='arrivaltime']").each(function(i)
          {
	          if($(this).val()=="")
	          {
	              arrivetimeflag=1;
	          }
         }
         );
         if(arrivetimeflag=="1")
         {
             alert("到达时间为必填项，请重新填写!");
             return false;
         }
         //舱位代码
         var cabincodeflag="0";
         $("input[id*='cabincode_']").each(function(i)
             {
                if($(this).val()=="")
                {
                   cabincodeflag=1;
                }
             }
         );
         if(cabincodeflag=="1")
         {
              alert("舱位代码为必填项，请重新填写!");
             return false;
         }
         
         
       
      
       //判断折扣，全价价格
       var discountflag=0;
       var ypriceflag=0;
       $("input[id*='txtdiscount_']").each(function(i)
       {
          if($(this).val()=="")
          {
              discountflag=1;
          }
       }
       );
       $("input[id*='txtyprice_']").each(function(i)
       {
          if($(this).val()=="" || $(this).val()=="0.0")
          {
              ypriceflag=1;
          }
       }
       );
       if(discountflag==1)
       {
          alert("请输入折扣信息!");
          return false;
       }
       if(ypriceflag==1)
       {
          alert("请输入Y仓位票面价信息!");
          return false;
       }
       if($("#txttotalzhekoujine").val()=="0")
       {
           alert("此PNR未能识别出票价，不能导入!");
          return false;
       }
       var parepriceflag=0;
       var realpriceflag=0;
       <ww:if test="listSegment.size()>1">
       //多程判断是否填写了舱位价和实际结算价
       //舱位价
       $("input[id*='txtpareprice_']").each(function(i)
       {
          if($(this).val()=="")
          {
              parepriceflag=1;
          }
       }
       );
       if(parepriceflag==1)
       {
          alert("此PNR含有多个航程信息，请填写每段航程的舱位价格!");
          return false;
       }
       //实际结算价
       $("input[id*='txtrealprice_']").each(function(i)
       {
          if($(this).val()=="")
          {
              realpriceflag=1;
          }
       }
       );
       if(realpriceflag==1)
       {
          alert("此PNR含有多个航程信息，请填写每段航程的实际结算价格!");
          return false;
       }
       </ww:if>
       
       //乘机人姓名逗号分隔
      // pnrflag=validPnr($("#txtpnrcode").val(),"1");
      // if(pnrflag!="0")
     //  {
      //    alert("您已经导入过相同的订单，请检查订单的价格信息，以免重复支付！！");
          //跳转到订单查询页面，显示已存在的订单信息
     //     window.location.href='b2bticketorder.action?s_pnr='+$("#txtpnrcode").val();
    //      return false;
          
          
    //   }
       
        //判断票号是否存在
       var tnumberflag1=0;
       $("input[id*='txtticnumber_']").each(function(i)
          {
              
	          if($(this).val()!="")
	          {
	              tnumberflag1=validTicketNumber($(this).val());
	          }
         }
         );
       if(tnumberflag1!="0")
       {
          if(confirm("此票号已经存在，是否要查看已经存在的订单信息？"))
          {
             //跳转到订单查询页面，显示已存在的订单信息
             window.location.href='b2bticketorder.action?s_orderid='+tnumberflag1;
             return false;
          }
          else
          {
            return false;
          }
       }
       
       var pas=$("#passengertr").val();
       if(pas!='true'){
       alert("导入的乘机人 信息为空，请重新导入！");
       return false;
       }
       
       //判断PNR是否重复
       var idnumber="0";
       $("input[id*='idnumber_']").each(function(i)
       {
          if($(this).val()=="")
          {
             idnumber="1";
          }
       }
       );
       if(idnumber=="1")
       {
          // alert("乘机人证件号不能为空，请确认没有导入身份证号的字段不为空!");
          // return false;
       }
       
       var ticketquanprice="0";
       $("input[id*='ticketquanprice_']").each(function(i)
       {
          if($(this).val()=="")
          {
             ticketquanprice="1";
          }
          else
          {
             if(!IsNumber($(this).val()))
             {
                 ticketquanprice="2";
             }
          }
       }
       );
       if(ticketquanprice=="1")
       {
           alert("票面价不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
        else if(ticketquanprice=="2")
       {
           alert("票面价只能输入数字，请重新填写!");
           return false;
       }
       
       var ticketprice="0";
       $("input[id*='ticketprice_']").each(function(i)
       {
          if($(this).val()=="")
          {
             ticketprice="1";
          }
          else
          {
             if(!IsNumber($(this).val()))
             {
                 ticketprice="2";
             }
          }
       }
       );
       if(ticketprice=="1")
       {
           alert("票价不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
        else if(ticketprice=="2")
       {
           alert("票价只能输入数字，请重新填写!");
           return false;
       }
       var taxprice="0";
       $("input[id*='taxprice_']").each(function(i)
       {
          if($(this).val()=="")
          {
             taxprice="1";
          }
          else
          {
             if(!IsNumber($(this).val()))
             {
                 taxprice="2";
             }
          }
       });
       if(taxprice=="1")
       {
           alert("机建费不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
       else if(taxprice=="2")
       {
           alert("机建费只能输入数字，请重新填写!");
           return false;
       }
       var yqprice="0";
       $("input[id*='yqprice_']").each(function(i)
       {
           if($(this).val()=="")
          {
             yqprice="1";
          }
           else
          {
             if(!IsNumber($(this).val()))
             {
                 yqprice="2";
             }
          }
       });
       if(yqprice=="1")
       {
           alert("燃油及其它费不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
       else if(yqprice=="2")
       {
           alert("燃油及其它费只能输入数字，请重新填写!");
           return false;
       }
       
       //判断乘机人票价，燃油，机建费是否同时为0，如果是，不允许通过
       var ticketpriall="0";
       $("input[id*='ticketprice_']").each(function(i)
       {
          if($(this).val()=="0.0" && $("#taxprice_"+i).val()=="0.0" && $("#yqprice_"+i).val()=="0.0")
          {
             ticketpriall="1";
          }
       }
       );
       if(ticketpriall=="1")
       {
             alert("乘机人票价，燃油及其它，机建费至少填写一项，请重新填写!");
             return false;
       }
       
       if($("#totalPrice").val()=="")
       {
          alert("总票价不能为空，请确认没有导入与价格的字段不为空!");
          return false;
       }
       else
       {
           if(!IsNumber(document.getElementById("totalPrice").value))
           {
              alert("总票价只能输入整数!");
              return false;
           }
       }
       
       if($("#totaltaxprice").val()=="")
       {
          alert("总机建费不能为空，请确认没有导入与价格的字段不为空!");
          return false;
       }
       else
       {
          if(!IsNumber(document.getElementById("totaltaxprice").value))
           {
              alert("总机建费只能输入整数!");
              return false;
           }
       }
       if($("#totalyqprice").val()=="")
       {
          alert("总燃油及其它不能为空，请确认没有导入与价格的字段不为空!");
          return false;
       }
       else
       {
          if(!IsNumber(document.getElementById("totalyqprice").value))
           {
              alert("总燃油及其它只能输入整数!");
              return false;
           }
       }
     if($("#poundage").val()!=undefined){
       if($("#poundage").val()==""){
         alert("退/废手续费不能为空！");
         $("#poundage").focus();
         return false;
       }else{
          if(!IsNumber($("#poundage").val()))
           {
              alert("退/废手续费只能输入整数!");
              $("#poundage").focus();
              return false;
           }
       }
      }
     
      if($("#txtzhekoubili").val()!="")
      {
          if(!IsNumber($("#txtzhekoubili").val()))
          {
             alert("折扣比例只能输入整数,请重新输入!");
             $("#txtzhekoubili").focus();
             return false;
          }
      }
       if($("#pnrorderstatu").val()==-1){
         alert("请选择订单状态！");
         $("#pnrorderstatu").focus();
         return false;
       }
       if($(".ctime").css("display")!="none"){
       if($("#pnrorderstatu").val()!="-1" && $("#pnrorderstatu").val()!="1")
       {
	       if($("#txtprinttime").val()=="")
	       {
	          alert("请填写机票的出票时间！");
	          $("#txtprinttime").focus();
	          return false;
	       }
        }
       }
       
       
       if($("#pnrorderstatu").val()=="11" || $("#pnrorderstatu").val()=="12")
       {
	       if($("#txttuifeitime").val()=="")
	       {
	          alert("请填写机票的退废票时间！");
	          $("#txttuifeitime").focus();
	          return false;
	       }
       }
      if($("#sstable").val()==1){
       if($("#creditbank").val()==""){
         alert("信用卡银行不能为空！");
          $("#creditbank").focus();
         return false;
        }
       if($("#creditnumber").val()==""){
         alert("信用卡卡号不能为空！");
          $("#creditnumber").focus();
         return false;
        }
       if($("#creditexpiry").val()==""){
         alert("信用卡有效日期不能为空！");
          $("#creditexpiry").focus();
         return false;
        }
       if($("#creditcheckcode").val()==""){
         alert("信用卡校验码不能为空！");
          $("#creditcheckcode").focus();
         return false;
        }
       }
        if(document.getElementById("rdopaymethod1")!=null&&document.getElementById("rdopaymethod1").checked){
          if($("#syscode").val()==""){
             alert("请输入系统参考号");
             $("#syscode").focus();
             return false;
          }
        
        }
       
       //如果是票到付款，则姓名电话地址为必填项
       
       
       if($("#addtesstable_my").css("display")=="block"&&!isTF()){
          var cl= $("input:radio[name='saleroom'][checked=true]").length;
          if(cl==0){
          alert("请选择自取部门！");
          return false;
          }
         
       }
       if(getrdovalue("s_paymethods")=="3"&&!isTF())
       {
          if($("#postname").val()=="")
          {
             alert("选择票到付款，联系人姓名为必填项，请重新填写!");
             $("#postname").focus();
             return false;
          }
          if($("#postmobile").val()=="")
          {
             alert("选择票到付款，联系人手机为必填项，请重新填写!");
             $("#postmobile").focus();
             return false;
          }
          if($("#addresa").val()=="")
          {
             alert("选择票到付款，送票地址为必填项，请重新填写!");
             $("#addresa").focus();
             return false;
          }
       }
       //如果机票状态为已出票，则机票类型为必填项
       if($("#pnrorderstatu").val()=="3" && $("#s_tickettypeid").val()=="0")
       {
            alert("请选择机票类型!");
            return false;
       }
       if($("#pnrorderstatu").val()=="6")
       {
            if(!confirm("此订单已经取消，您确定要导入订单吗？"))
            {
              return false;
            }
       }
       if($("#txtpostmobile").val=="")
       {
             alert("联系手机号不能为空，请重新填写！");
             $("#txtpostmobile").focus();
             return false;
       }
       else
       {
            if(!IsMobile($("#txtpostmobile").val()))
            {
                alert("联系手机号格式不正确，请重新填写！");
                $("#txtpostmobile").focus();
                return false;
            }
       }
       createorder();
    }
    function converNullAndEpt(obj,ret){
      if(obj==null||obj=='undefined'||obj==""){
       return ret;
      }
      return obj;
    }
    function getrdovalue(name) 
	{ 
		l=document.getElementsByName(name) 
		for(i=0;i<l.length;i++) 
		{ 
			if(l[i].checked)
			{
			   return l[i].value;
			}
		} 
	} 
    
    
    function setflag(index)
    {
        dispose("PNR信息正在导入");
        $("#hidflag").val(index);
    }
    
    function checkticketnumber()
    {
       if($.trim($("#txtticketnumber").val())=="")
        {
            alert("票号不能为空，请重新输入！");
            return false;
        }
        else
        {
           //验证票号格式
	        if(!IsTicketNumber($.trim($("#txtticketnumber").val())))
	        {
	            alert("您输入的票号格式不正确，请重新填写！票号格式如：784-1771188239");
	            return false;
	        }
        }
        //判断票号是否存在
       var tnumberflag=validTicketNumber($("#txtticketnumber").val());
       if(tnumberflag!="0")
       {
          if(confirm("此票号已经存在，是否要查看已经存在的订单信息？"))
          {
            //跳转到订单查询页面，显示已存在的订单信息
             window.location.href='b2bticketorder.action?s_orderid='+tnumberflag;
             return false;
          }
          else
          {
            return false;
          }
       }
        
        setticketnumberflag(1);
        
    }
    function setticketnumberflag(index)
    {
       $("#hidflag").val(index);
       //按照票号提取票号信息
       document.form1.action="orderinfo!toCreateOrderBytnumber.action";
       document.form1.method = "POST"; 
       dispose("机票信息正在导入");
       document.form1.submit();
       
    }
    
    function validPnr(pnr,etermtype)
    {
       var varret="";
       $.ajax({
        type:"POST",
        url:"orderinfo!IsExistPNR.action",
        async:false,
        data:{strPNR:pnr,etermtype:etermtype},
        beforeSend:function(){$("#requiredfieldvalidator1").html("<img src='images/loadpnr.gif' />正在验证PNR...");},             
        success:function(data){
        $("#requiredfieldvalidator1").html("");
        varret=data;     
        }            
        });
        
        return varret;
    }
    function validTicketNumber(ticketnumber)
    {
       var varret="";
       $.ajax({
        type:"POST",
        url:"orderinfo!IsExistTicketNumber.action",
        async:false,
        data:{ticketnumberarr:ticketnumber},
        beforeSend:function(){$("#requiredfieldvalidator1").html("<img src='images/loadpnr.gif' />正在验证票号...");},             
        success:function(data){
        $("#requiredfieldvalidator1").html("");
        varret=data;     
        }            
        });
        
        return varret;
    }
//计算客服总额
function acountTotalcustmerpay(){
var tpay=0;
  $("input[id*='customerpay_']").each(function(i){
  var pay=$("#customerpay_"+i).val();
  if(pay==""){pay=0;}
     tpay+=parseInt(pay);
  });
  
  $("#totalcustomerpay").val(tpay);

}

//递增票号
function increaseTicketnumber(){
var ticketone=$("#txtticnumber_0").val();
if(ticketone!=""){
 var reg=/^[0-9]{3}[-][0-9]{10}$/;
 if(reg.exec(ticketone)){
 var tickhead=ticketone.substr(0,4)
  var ticketnum=parseInt(ticketone.substr(4));
   $("input[id*='txtticnumber_']").each(function(i){
   ticketnum=ticketnum+1;
      $("#txtticnumber_"+(i+1)).val(tickhead+""+(ticketnum));
       });
 }else{
 alert("你输入的票号格式不正确，请重新输入！");
 }
 }
}

</script>

<script type="text/javascript">
function changeraddisable(rd1,typ1,rd2,typ2,rd3,typ3,rdchecked){

     if(document.getElementById("rdopaymethod1").checked){
     $("#syscodetab").show();
     }else{
     $("#syscodetab").hide();
     
     }

    //  $("#s_paystatus").attr("disabled",false);
    //  if(getrdovalue("s_paymethods")=="5")
	//  {
	    //$("#s_paystatus").attr("disabled",true);
	  //}
      document.getElementById(rd1).disabled=typ1;
      document.getElementById(rd2).disabled=typ2;
      document.getElementById(rd3).disabled=typ3;
      document.getElementById(rdchecked).disabled="";
      
     // document.getElementById(rdchecked).checked="checked";
      showdiag('addtesstable_my','none');
       $("#"+rdchecked).trigger("click");
      
        showdiag('addtesstable','none');//点击付款方式时隐藏
         $(".saleroom").removeAttr("checked"); //取消选中
      if(rdchecked=="postmoney3"||rdchecked=="postmoney4"){
      //  showdiag('addtesstable_my','none');
        showdiag('addtesstable','block');
      }
      if(rdchecked=="postmoney2"){
       // showdiag('addtesstable_my','block');
        showdiag('addtesstable','none');
      }
      var type=$("#pnrorderstatu").val();
      var fk =getrdovalue("s_paymethods");
      showneedIssuetime(type,fk);
}
function showpeisong()
{
    document.getElementById("postmoney1").checked="";
    document.getElementById("postmoney0").checked="checked";
}
//计算保险金额
function accountbaoxian(id)
{
   var jine=0;
   var baoxiancount=0;
    $("select[id*='txtbaoxianfenshu_']").each(function(i){
       baoxiancount+=parseInt($(this).val());
     });
    jine=parseFloat(baoxiancount)*20;
    
    $("#txtbaoxianjine").val(jine);
    $("#txtzongjiage").val(formatFloat($("#txthidzongjiage").val(),0)+jine);
    $("#txttotalzhekoujine").val(formatFloat($("#txthidtotalzhekoujine").val(),0)+jine);
}
var gzhtml="";
function change(){
var valu=$("#sid").val();
if(valu==7){   
   if(gzhtml.length==0){
    $.ajax({
      url:"orderinfo!ajaxgetGZPeopleHtml.action",
      type:"POST",
      async:false,
      success:function(data){     
      gzhtml=data;
       $("#grgzinfo").html(data);
        $("#grgzinfo").show();
      }    
    
    });
   }else{
   $("#grgzinfo").show()
   }
  
  }else{  
     $("#grgzinfo").hide();
 }
}


function showtuitime()
{
    $("#divtuitime").show();
}
//更改航程中的值信息
function changesegsession(index,value)
{
     $.ajax({
        type:"POST",
        url:"orderinfo!changeSessionSegByAjax.action",
        async:false,
        data:{s_cindex:index,s_cvalue:$("#"+value+"_"+index).val(),s_cname:value},
        beforeSend:function(){},             
        success:function(data){
        }            
        });
}
function changepasssession(index,value)
{

   $.ajax({
        type:"POST",
        url:"orderinfo!changeSessionPassByAjax.action",
        async:false,
        data:{s_cindex:index,s_cvalue:$("#"+value+"_"+index).val(),s_cname:value},
        beforeSend:function(){},             
        success:function(data){
        }            
        });
}


function formatCurrency(num) {
num = num.toString().replace(/\|\,/g,'');
if(isNaN(num))
num = "0";
sign = (num == (num = Math.abs(num)));
num = Math.floor(num*100+0.50000000001);
cents = num%100;
num = Math.floor(num/100).toString();
if(cents<10)
cents = "0" + cents;
for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
num = num.substring(0,num.length-(4*i+3))+','+
num.substring(num.length-(4*i+3));
return (((sign)?'':'-') + '' + num + '.' + cents);
}

function acountzhekoujine(){
    
    var totalpricc=0;   
    var zongjingjia=0;
     var totalpricc=0;
      var zkb=$('#txtzhekoubili').val();
      if(zkb==""){
      zkb=0;
      }      
    $("#tbpassengerinfo").find("input[id*='ticketquanprice_']").each(function(i){	    
	    totalpricc=parseFloat($("#ticketquanprice_"+i).val());
	     
	     var fandianjie=getReturnPrice(totalpricc,zkb);
	      var jingjia=0;
	     if(totalpricc-fandianjie>0){	  
	      jingjia=totalpricc-fandianjie;
	     }
	     zongjingjia+=jingjia;
	   }); 
     //$("#totalPrice").val(formatCurrency(zongjingjia)); 
      totalpricc=parseFloat($("#ticketquanprice_"+0).val());
      var zhekoujine= getReturnPrice(totalpricc,zkb);
     
     $("#txtzhekoujine").val(zhekoujine);
}
// 根据票面价，返点 获得返点金额/
function getReturnPrice(allprice,sale){
var fj=0;
var salepriceint=allprice*sale/100;
//alert(salepriceint);
//var saleprice=String(salepriceint);
 // alert(saleprice);
//var l=saleprice.length;
 //if(l>=2){
 // var gewei=saleprice.substring(l-1,l);
 // fj=salepriceint-parseInt(gewei);
  //}
 //return  fj;
 return salepriceint;
}
//退费票  计算退款金额
function acounttkprice(){
  var sxf=$("#poundage").val();
  var tkprice=0;
  $("#tbpassengerinfo").find("input[id*='ticketprice_']").each(function(i){  
   var  netprice=parseFloat(converNullAndEpt($("#ticketprice_"+i).val(),0));
    var  jijian=parseFloat(converNullAndEpt($("#taxprice_"+i).val(),0));
    var ranyou=parseFloat(converNullAndEpt($("#yqprice_"+i).val(),0));
    var anjian=parseFloat(converNullAndEpt($("#anjianfee_"+i).val(),0));
    var other=parseFloat(converNullAndEpt($("#otherfee_"+i).val(),0));
    tkprice+=netprice+jijian+ranyou+anjian+other;
  
  });
    $("#orderreturnprice").val(tkprice-sxf);
 }
 
function isTF(){
  var tf=$("#istf").val();
  if(tf=="true"){
  return true;
  }
  return false;
}


function addpass(index){
   //将新插入的乘机人插入到乘机人Session中
    $.ajax({
        type:"POST",
        url:"orderinfo!addSessionPassByAjax.action",
        async:false,
        data:{s_cindex:index},
        beforeSend:function(){},             
        success:function(data){
          $("#tbpassengerinfo").html($("#tbpassengerinfo").html()+data);
        }            
        });
        accountPrice(0);
}

   function removepass(index){
   //从ession中删除乘机人
    $.ajax({
        type:"POST",
        url:"orderinfo!removeSessionPassByAjax.action",
        async:false,
        data:{s_cindex:index},
        beforeSend:function(){},             
        success:function(data){
        if(data=="true"){
          $("#tr_passenger_"+index).remove();
          accountPrice(0);
          }else{
          alert("移除失败，请重新再试！");
          }
        }            
        });
}


//更改折扣金额
function changezhekjine()
{
   
}
function accountjingjia()
{
    $("input[id*='ticketquanprice_']").each(function(i)
	   {
	      $("#ticketprice_"+i).val($("#ticketquanprice_"+i).val());
	   });
	   acountzhekoujine();
}
$(document).ready(function(){

    <ww:if test="#session.orderuserlogin.msgtype==1">
    if(!isSameLinkPassenger()){
     $("#msg1").attr("checked","checked");
     }
    </ww:if>
    <ww:if test="#session.orderuserlogin.msgtype==2">
    if(!isSameLinkPassenger()){
     $("#msg2").attr("checked","checked");
     }
    </ww:if>
    <ww:if test="(#session.orderuserlogin.msgtype==3||#session.orderuserlogin.msgtype==null)&&#session.orderuserlogin.id!=90148l">
    if(!isSameLinkPassenger()){
     $("#msg1").attr("checked","checked");
       $("#msg2").attr("checked","checked");
       }
    </ww:if>
    //$("#txtzhekoubili").attr("disabled","disabled");
    //$("#txtzhekoujine").attr("disabled","disabled");
    //$("#txttotalzhekoujine").attr("disabled","disabled");
    
    
  
});

function isSameLinkPassenger(){
  //var linkname=$("#linkname").val();
  //var linkmobile=$("#linkmobile").val();
  var linknumber=$("#linkcardnumber").val();
  var falg="0";
  $("span[id*='span_passname_']").each(function(i){
    //  var pname=$(this).html();
      //var pmobiel=$("#txtmobile_"+i).val();
      var pcard=$("#idnumber_"+i).val();
      if($.trim(pcard)==$.trim(linknumber)){
        falg="1";
       }
     });
     if(falg=="1"){
        return true;
     }else{
        return false;
     }
}
function checkLinkmsg(cbox){
 if(cbox.checked){
    if(isSameLinkPassenger()){
       alert("联系人与乘机人有重合，选择此项会导致短信重复发送！");   
    }
 }
}

function checkMsgYN(){  
   if(isSameLinkPassenger()){
   document.getElementById("msg1").checked=false;
   document.getElementById("msg2").checked=false;
   }
}
$(document).ready(function(){
 checkMsgYN();
});
function priceCopy(){
//ticketquanprice_,taxprice_,yqprice_,anjianfee_,otherfee_,
   var len=parseInt(<ww:property value="listPassenger.size"/>);
   if(len>1){
   var faceprice=$("#ticketquanprice_0").val();
   var jijian=$("#taxprice_0").val();
   var ranyou=$("#yqprice_0").val();
   var cpay=$("#customerpay_0").val();
  <ww:if test='isinter==1'>
   var anjian=$("#anjianfee_0").val();
   var kaipiao=$("#otherfee_0").val();
   </ww:if>
   for(var i=1;i<len;i++){
     $("#ticketquanprice_"+i).val(faceprice);
     changepasssession(i,'ticketquanprice')
     $("#taxprice_"+i).val(jijian);
     changepasssession(i,'taxprice')
     $("#yqprice_"+i).val(ranyou);
     changepasssession(i,'yqprice')
     $("#customerpay_"+i).val(cpay);
    <ww:if test='isinter==1'>
     $("#anjianfee_"+i).val(anjian);
     changepasssession(i,'anjianfee');
     $("#otherfee_"+i).val(kaipiao);
     changepasssession(i,'otherfee');
    </ww:if>
       
   }
 
 accountjingjia();
 accountPrice(0);
 increaseTicketnumber();
  }
}
</script>
</head>
<body onload="accountPrice(0);">
<form name="form1" id="form1" method="post"
	action="orderinfo!toCreateOrderByPnr.action">
<div id="member"><input type="hidden" name="s_paystatus"
	id="corderstatus">
	
	<input type="hidden" id='linkcardnumber' name="linkcardnumber" value='<ww:property value="linkcardnumber!=null?linkcardnumber:getcardnumberstr(linkid)"/>'>
	<input type="hidden" name="linkid" value="<ww:property value="linkid"/>" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	


	<tr height="5px">
		<td></td>
	</tr>
	<tr>
		<td>
		<table border=1 cellspacing=0 bordercolorlight="#a0cfee"
			bordercolordark=white cellpadding=0 width="90%" align=center
			height=110>
			<tbody>
				<tr>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span style="">航程信息:
					<ww:property value="strFlightString" /></span></strong>&nbsp;&nbsp;&nbsp;&nbsp;<span
						style="color: red">提示:如果导入时没有提取出出发城市，到达城市信息，请人工输入<b>机场三字码</b>！</span></td>
				</tr>
				<tr>
					<td align="center">
					<table id="tbTravel" class="book_pgcontent" width="99%" border=1
						cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
						cellpadding=0>
						<tbody>
							<tr class='GridViewHeaderStyle' align="center" valign="middle">
								<td>承运人</td>
								<td>航班号</td>
								<td>起飞城市</td>
								<td>到达城市</td>
								<td>起飞时间</td>
								<td>到达时间</td>
								<td>舱位</td>
								<td>折扣率</td>
								<td>Y舱全价<br></td>
								<td <ww:if test="listSegment.size()>1">style="display:block"</ww:if><ww:else>style="display:none"</ww:else>>舱位价</td>
								<td <ww:if test="listSegment.size()>1">style="display:block"</ww:if><ww:else>style="display:none"</ww:else>>实际结算价</td>
							</tr>
							
							<ww:iterator value="listSegment" status="state">
								<tr class='postbg1' align="center" valign="middle">
									<td><img
										src="images/airComlogo/<ww:property value="aircomapnycode"/>.gif"
										border="0" /><ww:property
										value="getaircomnamebycode(aircomapnycode)" /></td>
									<td><ww:property value="flightnumber" /></td>

									<td><!-- 出发城市 --> <input
										style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 80px;"
										type="text" name="StartAirPortName"
										id="arrcity_<ww:property value="#state.index" />"
										value="<ww:property
										value="getCitynameByAirport(startairport)" />"
										onPropertyChange="changesegsession(<ww:property value="#state.index" />,'arrcity')" />
									<!-- 出发城市 --></td>
									<td><!-- 到达城市 --> 
									<input style="border: 1px solid #999999; height: 20px; line-height: 20px; width: 80px;"
										type="text" name="EndAirPortName"
										id="tocity_<ww:property value="#state.index" />"
										value="<ww:property value="getCitynameByAirport(endairport)" />"
										onPropertyChange="changesegsession(<ww:property value="#state.index" />,'tocity')" />

									<!-- 到达城市 --></td>
									<td>
							
									<input type="text" name="departtime"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"
										class="Wdate"
										id="departtime_<ww:property value="#state.index" />"
										onPropertyChange="changesegsession(<ww:property value="#state.index" />,'departtime')"
										style="width: 130px"
										value="<ww:property value='formatTimestampHHmm2(departtime)' />" />
							
									</td>
									<td>
						
									<input type="text" name="arrivaltime"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"
										class="Wdate"
										id="arrivaltime_<ww:property value="#state.index" />"
										onPropertyChange="changesegsession(<ww:property value="#state.index" />,'arrivaltime')"
										style="width: 130px"
										value="<ww:property value='formatTimestampHHmm2(arrivaltime)' />" />
	
									</td>
									<td><input type="text" name="cabincode"
										id="cabincode_<ww:property value="#state.index" />"
										onblur="changesegsession(<ww:property value="#state.index" />,'cabincode')"
										style="width: 40px" value="<ww:property value='cabincode' />" /></td>
									<td><input type="text"
										id='txtdiscount_<ww:property value="#state.index" />'
										name="discount" style="width: 50px"
										onblur="changesegsession(<ww:property value="#state.index" />,'txtdiscount')"
										value='<ww:property value="discount" />'></td>
									<td><input type="text"
										id='txtyprice_<ww:property value="#state.index" />'
										name="yprice" style="width: 50px"
										onblur="changesegsession(<ww:property value="#state.index" />,'txtyprice')"
										value='<ww:property value="yprice" />'></td>
										
									<!-- 航站楼 -->
									<td <ww:if test="listSegment.size()>1">style="display:block"</ww:if><ww:else>style="display:none"</ww:else>><input type="hidden"
										id='txthangzhanlou1_<ww:property value="#state.index" />'
										name="borderpointat" style="width: 50px"
										onblur="changesegsession(<ww:property value="#state.index" />,'txthangzhanlou1')"
										value='<ww:property value="borderpointat" />'>
									    <!-- 舱位价 -->
										<input type="text" style="width: 50px" id="txtpareprice_<ww:property value="#state.index" />" value="" />
										<!-- 舱位价 -->
									</td>
									<td <ww:if test="listSegment.size()>1">style="display:block"</ww:if><ww:else>style="display:none"</ww:else>>
									    <input type="hidden"
										id='txthangzhanlou2_<ww:property value="#state.index" />'
										name="offpointat" style="width: 50px"
										onblur="changesegsession(<ww:property value="#state.index" />,'txthangzhanlou2')"
										value='<ww:property value="offpointat" />'>
										<!-- 实际结算价 -->
										<input type="text" style="width: 50px" id="txtrealprice_<ww:property value="#state.index" />" value="" />
										<!-- 实际结算价 -->
									<input type="hidden" id="hidsairport_<ww:property value="#state.index" />" value="<ww:property value="startairport" />" />
									<input type="hidden" id="hideairport_<ww:property value="#state.index" />" value="<ww:property value="endairport" />" />
									<input type="hidden" id="hidfromdate_<ww:property value="#state.index" />" value="<ww:property value="formatTimestampyyyyMMdd(departtime)" />" />
									<input type="hidden" id="hidaircompany_<ww:property value="#state.index" />" value="<ww:property value="aircomapnycode" />" />
									<input type="hidden" id="hidflightnumber_<ww:property value="#state.index" />" value="<ww:property value="flightnumber" />" />
									<input type="hidden" id="hidcabin_<ww:property value="#state.index" />" value="<ww:property value="cabincode" />" />
										</td>
								</tr>
								
								<tr>
								 <td colspan="11">
								    <table width="100%" id="zrate4_2">
									<tr>
										<td align="left"><input type="button" onclick="ShowZrate('listzrate1','listzrate2','1');"
											value="普通政策信息" style="cursor:pointer; background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff" />&nbsp;
											<input type="button" onclick="ShowZrate('listzrate2','listzrate1','2')"
											value="特殊政策信息" style="cursor:pointer; background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff" />&nbsp;
										
										<span style="color: red"><b>温馨提示:在你成功下单后,请立即对供应商的OFFICE号进行授权,否则将不能出票!!!</b></span>	
								</td>
								</tr>
								<tr>
									<td>
								
									<div style="width: 100%; border: 2px solid #FF9900; float: left;margin-top: -1px;">
									<table border="0" cellpadding="0" cellspacing="0" width="100%">
									  <tr >
										<td style="width: 15%;background:#DDECF3">条数</td>
										<td style="width: 15%;background:#DDECF3">返点/佣金</td>
										<td style="width: 15%;background:#DDECF3">单张结算价</td>
										
										<td style="width: 15%;background:#DDECF3">出票时间</td>
										
										<td style="width: 15%;background:#DDECF3">废票时间</td>
										
										<td style="width: 15%;background:#DDECF3">出票速度</td>
										
										<td style="width: 15%;background:#DDECF3">票证类型</td>
										
										<td style="width: 15%;background:#DDECF3;color: red">OFFICE</td>
									</tr>
									
									<tbody id="listzrate1">
									<ww:iterator value="ListZrate1" status="ind">
									<tr>
										
										<input type="hidden" name="txt_hidefirstrate" id="txt_hidefirstrate" value="<ww:property value="outid" />" />
									    <td>
									    <ww:property value="#ind.index+1" /><input id="listzrate1_<ww:property value="#ind.index" />" type="radio" name="s_zrateid" value="<ww:property value="outid" />@<ww:property value="agentid" />"   <ww:if test="#ind.index==0">checked</ww:if>  onclick="showremarkAndvalue('<ww:property value="outid" />',<ww:property value="ratevalue" />,'<ww:property value="workstatus" />');showhidremark(<ww:property value="#ind.index" />);" />
									    <ww:if test="getLoginUserAgent().id==46">
									    <ww:property value="getZrateAgentName(agentid)" />
									    </ww:if>(普)
									    </td>
									    <td><ww:property value="ratevalue" />/(<ww:property value="formatflotMoneyB2B(ratevalue*segmentparvprice/100)" />)</td>
									    <td><ww:property value="segmentparvprice-formatflotMoneyB2B(ratevalue*segmentparvprice/100)" /></td>
									    <td><ww:if test="worktime!=null"><ww:property value="worktime" />-<ww:property value="afterworktime" /></ww:if><ww:else>暂无数据</ww:else></td>
									    <td><ww:if test="onetofivewastetime!=null"><ww:property value="onetofivewastetime" /></ww:if><ww:else>暂无数据</ww:else></td>
									    <td><ww:if test="speed!=null"><ww:property value="speed" /></ww:if><ww:else>暂无数据</ww:else></td>
									    <td><ww:if test="tickettype==2">B2B</ww:if><ww:else>BSP</ww:else></td>
									    <td style="color: red"><ww:property value="workstatus" /></td>
									          
									</tr>
									<tr id="hid_rek_<ww:property value="#ind.index" />"   >
										<td colspan='8' style='width: 100%; color: red; '>
											<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<ww:if test="remark==null||remark==''">
											暂无数据
											</ww:if><ww:else>
											<ww:property value="remark" />
											</ww:else>
											</span>
										</td>
									</tr>
									</ww:iterator>
									</tbody>
									<tbody id="listzrate2" style="display: none;">
									<ww:iterator value="ListZrate2" status="ind2">
									<tr>
										
										<input type="hidden" name="txt_hidefirstrate" id="txt_hidefirstrate" value="<ww:property value="outid" />" />
									    <td>
									    <ww:property value="#ind2.index+1" /><input id="listzrate2_<ww:property value="#ind2.index" />"  type="radio" name="s_zrateid" value="<ww:property value="outid" />@<ww:property value="agentid" />"    onclick="showremarkAndvalue('<ww:property value="outid" />',<ww:property value="ratevalue" />,'<ww:property value="workstatus" />');showhidremark2(<ww:property value="#ind2.index" />);" />
									    <ww:if test="getLoginUserAgent().id==46">
									    <ww:property value="getZrateAgentName(agentid)" />
									    </ww:if>(特)
									    </td>
									    <td><ww:property value="ratevalue" />/(<ww:property value="formatflotMoneyB2B(ratevalue*segmentparvprice/100)" />)</td>
									    <td><ww:property value="segmentparvprice-formatflotMoneyB2B(ratevalue*segmentparvprice/100)" /></td>
									    <td><ww:if test="worktime!=null"><ww:property value="worktime" />-<ww:property value="afterworktime" /></ww:if><ww:else>暂无数据</ww:else></td>
									    <td><ww:if test="onetofivewastetime!=null"><ww:property value="onetofivewastetime" /></ww:if><ww:else>暂无数据</ww:else></td>
									    <td><ww:if test="speed!=null"><ww:property value="speed" /></ww:if><ww:else>暂无数据</ww:else></td>
									    <td><ww:if test="tickettype==2">B2B</ww:if><ww:else>BSP</ww:else></td>
									    <td style="color: red"><ww:property value="workstatus" /></td>
									          
									</tr>
									<tr id="hid_rek2_<ww:property value="#ind2.index" />"  style="display: none;"  >
										<td colspan='8' style='width: 100%; color: red; '>
											<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<ww:if test="remark==null||remark==''">
											暂无数据
											</ww:if><ww:else>
											<ww:property value="remark" />
											</ww:else>
											</span>
										</td>
									</tr>
									</ww:iterator>
									</tbody>
									
									</table>
									</div>
									</td>
								</tr>
							</table>
								 </td>
								</tr>
								
							</ww:iterator>
							
						</tbody>
					</table>
					</td>
				</tr>

			</tbody>
		</table>
		</td>
	</tr>
	<tr height="5px">
		<td></td>
	</tr>
	<tr>
		<td>

		<table border=1 cellspacing=0 bordercolorlight=#a0cfee
			bordercolordark=white cellpadding=0 width="90%" align=center
			height=110>
			<tbody>
				<tr>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span style="">乘机人信息：&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>儿童只匹配基本政策！</font></span></strong></td>
				</tr>
				<tr>
					<td style="line-height: 15px;" align="center">
					<table id="tbpassengerinfo" class="book_pgcontent" width="99%"
						border=1 cellspacing=0 bordercolorlight=#a0cfee
						bordercolordark=white cellpadding=0>
						<tbody>
						
							<tr class='GridViewHeaderStyle'>
								<td width="8%">乘客类型</td>
								<td width="12%">乘客姓名</td>
								<td width="10%">短信</td>
								<td>手机号</td>
								<td width="8%">证件类型</td>
								<td width="14%">证件号码</td>
								
								<td width="6%">
							
								<span style="cursor: pointer;">
								票面价<input type="hidden" id="hidsegint_size" value="<ww:property value="listSegment.size()" />" />
								</span>
								
								<td width="13%">票面结算价价</td>
								<td width="6%">机建费</td>
								<td width="8%">
								燃油费						
								</td>
								<!-- 票面价 、 NIL 、机建、 燃油及其它 、客付金额 、小计-->


                             
								<td>小计</td>
								<td width="5%" style="display:none">里程卡</td>
								<ww:if
									test='s_orderstatuspnr.equals("3") || s_orderstatuspnr.equals("11") || s_orderstatuspnr.equals("12")'>
									<td width="10%">票号</td>
									<!--<td width="8%">行程单号</td>-->
								</ww:if>

							</tr>
							<ww:if test="listPassenger.size>0">
								<input type="hidden" id='passengertr' value='true' />
							</ww:if>
							<ww:iterator value="listPassenger" status="state">
								<tr id="tr_passenger_<ww:property value="#state.index"/>">
									<td><ww:if test="ptype==1">成人</ww:if><ww:if
										test="ptype==2">儿童</ww:if><ww:if test="ptype==3">婴儿</ww:if></td>
                                     <input type="hidden" id="txt_passtype_<ww:property value="#state.index"/>" value="<ww:property value="ptype" />" />
									<td>
									<span id="span_passname_<ww:property value="#state.index"/>"><ww:property
										value="name" /></span> <ww:if test='s_orderstatuspnr.equals("3")'>
									</ww:if></td>
									<td>
									<ww:if test='importtype.equals("2")||importtype.equals("4")'>
									<input type="checkbox"  checked="checked"
										name="s_pmsgtype<ww:property value="#state.index"/>" value="4" />退废提醒
									</ww:if>
									<ww:else>
									<input type="checkbox"  style="display:none"
										name="s_pmsgtype<ww:property value="#state.index"/>" value="1" />
									<br />
									<input type="checkbox"  checked="checked"
										name="s_pmsgtype<ww:property value="#state.index"/>"
										value="2" />出票短信
									</ww:else>
										</td>
									<td width="6%"><input type="text" name="mobile"
										style="width: 70px"
										id="txtmobile_<ww:property value="#state.index"/>"
										style="width: 115px" value="<ww:property value="mobile"/>" /></td>
									<td>
									
									<ww:if test="idtype==1">身份证</ww:if>
									<ww:if test="idtype==0">出生日期</ww:if>
									<ww:if test="idtype==3">护照</ww:if>
									<ww:if test="idtype==8">其他证件</ww:if></td>
									
									<td><input type="text" name="idnumber" maxlength='100'
										id="idnumber_<ww:property value="#state.index"/>"
										style="width: 130px" value="<ww:property value="Idnumber" />"
										onblur='changepasssession(<ww:property value="#state.index" />,"idnumber");checkMsgYN()' /></td>
									<!-- 票面价 -->
									<td><input type="text"
										class='price' value="<ww:property value="price" />" name='yuanprice<ww:property value="#state.index"/>'
										id="ticketquanprice_<ww:property value="#state.index"/>"
									<ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if> style="width: 50px; color: #000;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>"
										/></td>
                                     <!-- 票面结算价 -->
									<td>
									<input type="text" name="ticketprice"
										<ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if> style="width: 50px; color: #000;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>"
										value="<ww:property value="price" />"
										id="ticketprice_<ww:property value="#state.index"/>"
										style="width: 50px"
										onchange="changepasssession(<ww:property value="#state.index" />,'ticketprice');accountPrice(0);" /></td>

									
									<td><input type="text" name="taxprice" class='price'
										value="<ww:property value="airportfee" />"
										id="taxprice_<ww:property value="#state.index"/>"
										<ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if> style="width: 50px; color: #000;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>"
										onblur="changepasssession(<ww:property value="#state.index" />,'taxprice');accountPrice(0);" /></td>
									<td><input type="text" name="yqprice" class='price'
										value="<ww:property value="fuelprice" />"
										id="yqprice_<ww:property value="#state.index"/>"
										<ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if> style="width: 50px; color: #000;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>"
										onblur="changepasssession(<ww:property value="#state.index" />,'yqprice');accountPrice(0);" /></td>
									
								
									<td id="pprice<ww:property value="#state.index"/>"><input
										<ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if> style="width: 50px; color: #000;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>"
										id='iprice<ww:property value="#state.index"/>'
										 /></td>
								
									<!-- 万里行卡号 -->
									<td style="display:none"><input type="text" name="mucardnum"
										value="<ww:property value="mucardnum" />"
										id="mucardnum_<ww:property value="#state.index"/>"
										style="width: 30px"
										onblur="changepasssession(<ww:property value="#state.index" />,'mucardnum');" /></td>
										
									<ww:if
										test='ticketnum!=null'>
										<td width="10%"><input type="text" name="ticketnumber<ww:property value="#state.index"/>"
											id="txtticnumber_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtticnumber');"
											style="width: 100px"
									
											value="<ww:property value="ticketnum" />" /></td>
										<!-- <td width="10%"><input type="text" name="rpnumber"
											id="txtrpnumber_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtrpnumber')"
											style="width: 100px" value="<ww:property value="fet" />" /></td>-->
									</ww:if>

								</tr>
								<tr style="display: none">
									<td >保险：</td>
									<td><select name="insurancetype">
										<option value="阳光财产保险股份有限公司">阳光保险</option>
									</select></td>
									<td>保险份数：</td>
									<td colspan="9" align="left"><select id="txtbaoxianfenshu_<ww:property value="#state.index" />"
										name="s_insurancevalues" style="width: 80px"
										onchange="accountbaoxian(<ww:property value="#state.index" />);">
										<option value="0">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
									</select></td>
								</tr>
							</ww:iterator>
							
						</tbody>
					</table>
					</td>
				</tr>

			</tbody>
		</table>

		</td>
	</tr>

	<tr height="5px">
		<td></td>
	</tr>

	<tr>
		<td>
		<table border=1 cellspacing=0 bordercolorlight=#a0cfee
			bordercolordark=white cellpadding=0 width="90%" align=center
			height=130>
			<tbody>
				<tr>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span style="">票价信息：</span></strong></td>
				</tr>
				<tr>
					<td style="line-height: 15px;" align="center">
					<table class="book_pgcontent" width="90%" border=1 cellspacing=0
						bordercolorlight=#a0cfee bordercolordark=white cellpadding=0>
						<tbody>
					<!--  	总票面价 、 总NIL 、总机建 、总燃油及其它 、客付总额 -->
							<tr class='GridViewHeaderStyle'>
								<td>总票面结算价</td>
								
								<td>总机建费</td>
								<td>总燃油</td>
								
								<!--<td>总保险费</td>
								--><td style="display:none">机票总价格</td>
								<td>返点</td>
								
								<td>应付款</td>

								
							</tr>

							<tr>

								<td><input type="text" name="totalPrice" id="totalPrice" <ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if>
									style="width: 50px; color:#000;font-weight:bold;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>" />元</td>
								
								<td><input type="text" name="totalairportfee"
									id="totaltaxprice" <ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if>
									style="width: 50px;color: #000;font-weight:bold;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>" />元</td>
								<td><input type="text" name="totalfuelfee"
									id="totalyqprice" style="width: 50px;color:#000;font-weight:bold;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>"
									<ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if> />元</td>
								<!--  -->
								
								
								<!--
								<td><input style="width:50px;color:#000;font-weight:bold;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>" <ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if> id="txtbaoxianjine" name="baoxianjine" value="0" /></td>
							    -->
							    <td style="display:none">
							       <input type="text"  id="txtzongjiage" <ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if>
									style="width: 50px;color:#000;font-weight:bold;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>" value="0" />
								   <input type="hidden"  id="txthidzongjiage" readonly="readonly"
									style="width: 50px;color:#000;font-weight:bold;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>" value="0" />
								</td>
								<td>
								<input type="text" name="s_zhekoubili" id="txtzhekoubili" <ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if>
									style="width: 50px;color: red;font-weight:bold;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>" onpropertychange="acountzhekoujine();" />%</td>

								
								
								<td>
								 
								 <input type="hidden" id="hid_segmentparvprice" name="segmentparvprice" value='<ww:property value="segmentparvprice" />'>
								 <input type="hidden" id="hid_zonglirun" name="s_zonglirun" value='0'>
								 <input type="hidden" id="hid_zongfandian" name="s_zongfandian" value='0'>
								 <input type="hidden" id="hid_piaomianjia" name="s_piaomianjia" value='0'>
								 <input type="text"  id="txttotalzhekoujine" name="totalzhekoujine" <ww:if test="getLoginsessionagent().agenttype!=1">readonly="readonly"</ww:if>
									style="width: 50px;color: red;font-weight:bold;<ww:if test="getLoginsessionagent().agenttype!=1">border:0</ww:if>" value="0" />元
								 <input type="hidden"  id="txthidtotalzhekoujine"
									style="width: 50px;color: red;font-weight:bold" value="0" />
								</td>
							</tr>
						</tbody>
					</table>
					</td>
				</tr>
			</tbody>
		</table>

		</td>
	</tr>
	<tr height="5px">
		<td></td>
	</tr>
		<tr>
			<td>
			<table border=1 cellspacing=0 bordercolorlight=#a0cfee
				bordercolordark=white cellpadding=0 width="90%" align=center
				height=50>
				<tbody>
					<tr>
						<td colspan="4"
							style="text-align: left; background-color: #d7e9fc; height: 25px"
							class=maintitle02>&nbsp;<strong><span style="">导入订单状态：</span></strong></td>
					</tr>
					
					<tr>
						<td align="right"
							style="text-align: right; background-color: #d7e9fc; height: 25px"
							class=maintitle02>订单状态：</td>

						<td align="left"><span style="font-weight:bold">等待支付</span></td>
						
						

					</tr>
                    
					<tr style="display:none">

						<td
							style="text-align: right; background-color: #d7e9fc; height: 25px"
							class=maintitle02>支付状态：</td>
						<td><select id="s_paystatus">
							<option value="0">未支付</option>
						</select>&nbsp;&nbsp;</td>
						<td
							style="text-align: left; background-color: #d7e9fc; height: 25px"
							class=maintitle02 align="right">订单紧急状态：</td>
						<td align="left"><select name="s_busystatus">
							<option value="2">一般</option>
							<option value="1">紧急</option>
							<option value="3">待定</option>
						</select> </td>
					</tr>
					<tr>
						<td colspan="4">

						
						<table id='syscodetab' style="display: none" width="100%" border=1 cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white cellpadding=0
							align=center>
						<tr>
								<td
									style="text-align: right; background-color: #d7e9fc; height: 25px"
									class=maintitle02 width="100px">系统参考号：</td>
								<td><span style="HEIGHT: 71px"> <input
									style="WIDTH: 145px" id="syscode" name="syscode" /><font color="red">*</font></span></td>
								<td style="padding-left: 50px" width="530px">请填系统参考号</td>
							</tr>
						</table>
						</td>
					</tr>
					
					
					<tr>联系手机号：<input type="text" value="<ww:property value="getLoginUser().mobile" />" name="s_contactmobile" id="txtpostmobile" /></tr>
					
					<tr>
						<td
							style="text-align: right; background-color: #d7e9fc; height: 25px"
							class="maintitle02">订单备注：</td>
						<td colspan="3" align="left"><textarea rows="6" cols="55"
							name="s_memo"></textarea></td>
					</tr>
					 
			</table>
			</td>
		</tr>

<input id="txtpnrcode" name="strPNR" maxlength=10 type="hidden" value="<ww:property value="strPNR"/>" />
<input id="strPATTXT" name="strPATTXT" maxlength=10 type="hidden" value="<ww:property value="strPATTXT"/>" />
<input id="strPNRTXT" name="strPNRTXT" maxlength=10 type="hidden" value="<ww:property value="strPNRTXT"/>" />
<input id="BigPNR" name="BigPNR" maxlength=10 type="hidden" value="<ww:property value="BigPNR"/>" />

<input id="hidoffice" name="hidoffice" type="hidden" value="" />
<input id="s_agentid" name="s_agentid" type="hidden" value="<ww:property value="s_agentid"/>" />
<input id="s_userid" name="s_userid" type="hidden" value="<ww:property value="s_userid"/>" />

		<tr>
			<td>
			<table border=0 cellspacing=0 cellpadding=0 width="90%" align=center>
				<tr>
					<td align="center" height="40"><input
						class="button_d font-bai" id="btnOrder" value="创建订单" type="button"
						name="btnOrder" onclick="return checkorderdata();"></td>
				</tr>
			</table>

			</td>
		</tr>

</table>
</div>
</form>
</body>
</html>
<script type="text/javascript"> 
function showhidremark(inde){
	//alert(inde);
	//hid_remark_
 	$("tr[id*='hid_rek_']").each(function(i)
       {
          $("#hid_rek_"+i).hide();
          
       });
       
 	$("#hid_rek_"+inde).show();
 	//$("#listzrate1_0").click();  
 	//document.getElementById("listzrate1_0").click();
}
showhidremark(0);
function showhidremark2(inde){
	//alert(inde);
	//hid_remark_
 	$("tr[id*='hid_rek2_']").each(function(i)
       {
          $("#hid_rek2_"+i).hide();
          
       });
       
 	$("#hid_rek2_"+inde).show();
 	
 	
 	//$("#listzrate2_0").click();  
 	 //document.getElementById("listzrate2_0").click();
}


function ShowZrate(id1,id2,ty){
 $("#"+id2).hide();
 $("#"+id1).show();
 
  document.getElementById("listzrate"+ty+"_0").click();
  
 //showhidremark(0);
}

</script> 
