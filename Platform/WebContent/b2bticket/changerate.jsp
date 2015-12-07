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
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>pnr创建订单</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/ext-all.css" /> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext-base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script language="javascript">
   //页面加载完毕后，读取政策信息
   $(document).ready(function () {
      getthereate(0);
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
		            data:{z_startcity:$("#hidsairport_"+n).val(),z_endcity:$("#hideairport_"+n).val(),z_fromdate:$("#hidfromdate_"+n).val(),intflag:0,strAirCompany:$("#hidaircompany_"+n).val(),strAirline:$("#hidflightnumber_"+n).val(),strCabin:$("#hidcabin_"+n).val(),strratePrice:$("#ticketprice_0").val()},
		            beforeSend:function(){$("#divpolicyinfo_"+n).html("<img src='images/loadding.gif' /> 正在加载政策信息...");},             
		            success:function(data){
		            $("#divpolicyinfo_"+n).html(data);   
		            }            
		       });
	       }
       }
    }
    function gettheratesep(index,flag)
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
   //显示所有的政策信息
   function showallreate()
   {
       $("tr[id*='tr_rateinfo_']").each(function(i)
       {
          $(this).show();
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
   }
   function showdiag(diag,flag)
	{
		document.getElementById(diag).style.display=flag;
	}
   function checkdata()
    {
         if($("#txtpnrcode").val()=="")
         {
               alert("PNR编码不能为空，请重新填写！");
               return false;
         }
         
         else if($.trim($("#txtpnrcode").val()).length!=5 && $.trim($("#txtpnrcode").val()).length!=6)
         {
               alert("PNR编码格式不正确，请重新填写！");
               return false;
         }
         else
         {
            rTPnr();
         }
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
    function accountPrice()
    {
       var totalprice="0";
       var totaltaxprice="0";
       var totalyqprice="0";
       //票面价
       $("input[id*='ticketprice_']").each(function(i)
       {
          var price1=$(this).val();
          totalprice=parseInt(totalprice);
          if($(this).val()!="")
          {
            totalprice+=parseInt($(this).val()); 
          }
       }
       );
       $("#totalPrice").val(totalprice);
       //机建费
       $("input[id*='taxprice_']").each(function(i)
       {
          var price2=$(this).val();
          totaltaxprice=parseInt(totaltaxprice);
          if($(this).val()!="")
          {
          totaltaxprice+=parseInt($(this).val()); 
          }
       });
       $("#totaltaxprice").val(totaltaxprice);
       
       //燃油费
       $("input[id*='yqprice_']").each(function(i)
       {
          var price3=$(this).val();
          totalyqprice=parseInt(totalyqprice);
          if($(this).val()!="")
          {
          totalyqprice+=parseInt($(this).val()); 
          }
          
       });
       $("#totalyqprice").val(totalyqprice);
      
    }
    //创建订单
    function createorder()
    {     
      document.form1.action="orderinfo!createPNROrder.action";
      document.form1.method = "POST"; 
       dispose('系统正在创建订单');
      document.form1.submit();
            
    }
    //数据验证
    function checkorderdata()
    {
       if($("#txtpnrcode").val()=="")
         {
               alert("PNR编码不能为空，请重新填写！");
               return false;
         }
         
         else if($.trim($("#txtpnrcode").val()).length!=5 && $.trim($("#txtpnrcode").val()).length!=6)
         {
               alert("PNR编码格式不正确，请重新填写！");
               return false;
         }
       //判断PNR是否重复
       var etermtype;
       var pnrflag=false;
       if(document.getElementById("rdoetermtype1").checked)
       {
           etermtype=$("#rdoetermtype1").val();
       }
       if(document.getElementById("rdoetermtype2").checked)
       {
           etermtype=$("#rdoetermtype2").val();
       }
       //乘机人姓名逗号分隔
       var passengernames="";
       $("span[id*='span_passname_']").each(function(i)
       {
          passengernames+=$(this).html()+",";
       }
       );
       //pnrflag=validPnr($("#txtpnrcode").val(),etermtype,passengernames);
       //if(pnrflag!="0")
       //{
          //alert("此PNR已经存在，请重新填写PNR!");
          //return false;
       //}
       
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
           alert("乘机人证件号不能为空，请确认没有导入身份证号的字段不为空!");
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
           alert("燃油费费不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
       else if(yqprice=="2")
       {
           alert("燃油费费只能输入数字，请重新填写!");
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
          alert("总燃油费不能为空，请确认没有导入与价格的字段不为空!");
          return false;
       }
       else
       {
          if(!IsNumber(document.getElementById("totalyqprice").value))
           {
              alert("总燃油费只能输入整数!");
              return false;
           }
       }
       
       createorder();
    }
    function setflag(index)
    {
        dispose("PNR信息正在导入");
        $("#hidflag").val(index);
    }
    
    function validPnr(pnr,etermtype,passengernames)
    {
       var varret="";
       $.ajax({
        type:"POST",
        url:"orderinfo!IsExistPNR.action",
        async:false,
        data:{strPNR:pnr,etermtype:etermtype,strPassengers:passengernames},
        beforeSend:function(){$("#requiredfieldvalidator1").html("<img src='images/loadpnr.gif' />正在验证PNR...");},             
        success:function(data){
        $("#requiredfieldvalidator1").html("");
        varret=data;     
        }            
        });
        
        return varret;
    }
    
    
</script>

<script type="text/javascript">
function changeraddisable(rd1,typ1,rd2,typ2,rd3,typ3,rdchecked){
      document.getElementById(rd1).disabled=typ1;
      document.getElementById(rd2).disabled=typ2;
      document.getElementById(rd3).disabled=typ3;
      document.getElementById(rdchecked).disabled="";
      document.getElementById(rdchecked).checked="checked";
        showdiag('addtesstable_my','none');
        showdiag('addtesstable','none');
      if(rdchecked=="postmoney3"||rdchecked=="postmoney4"){
        showdiag('addtesstable_my','none');
        showdiag('addtesstable','block');
      }
      if(rdchecked=="postmoney2"){
        showdiag('addtesstable_my','block');
        showdiag('addtesstable','none');
      }
}
function showpeisong()
{
    document.getElementById("postmoney1").checked="";
    document.getElementById("postmoney0").checked="checked";
}
//计算保险金额
function accountbaoxian()
{
    var jine=parseInt($("#txtbaoxianfenshu").val())*20;
    $("#txtbaoxianjine").val(jine);
}
</script>

</head>

<body onload="accountPrice();">
<SCRIPT LANGUAGE="JavaScript">
<!--
function stopError() {
  return true;
}
window.onerror = stopError;
// -->

</SCRIPT>


<form name="form1" id="form1" method="post"
	action="orderinfo!toCreateOrderByPnr.action">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	


	<tr>
		<td>
		<table border=1 cellspacing=0 bordercolorlight=#a0cfee
			bordercolordark=white cellpadding=0 width="88%" align=center
			height=110>
			<tbody>
				<tr>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span style="">航程信息:<input type="hidden" id="txthidrate" name="hidrateid" value="" />
					<ww:property value="strFlightString" /></span></strong></td>
				</tr>
				<tr>
					<td align="center">
					<table id="tbTravel" class="book_pgcontent" width="95%" border=1
						cellspacing=0 bordercolorlight=#a0cfee bordercolordark=white
						cellpadding=0>
						<tbody>
						    <ww:iterator value="listSegment" status="state">
							<tr class='GridViewHeaderStyle' style=" background-color: #d7e9fc" align="center" valign="middle">
								<td>承运人</td>
								<td>航班号</td>
								<td>起飞城市</td>
								<td>到达城市</td>
								<td>起飞时间</td>
								<td>到达时间</td>
								<td>舱位</td>
								<td>折扣</td>
								<td>票面价</td><input type="hidden" id="hidsegint_size" value="<ww:property value="listSegment.size()" />" />
							</tr>
							
								<tr class='postbg1' align="center" valign="middle">
									<td><img
										src="images/airComlogo/<ww:property value="aircomapnycode"/>.gif"
										border="0" /><ww:property
										value="getaircomnamebycode(aircomapnycode)" /></td>
									<td><ww:property value="flightnumber" /></td>
									<td><ww:property
										value="getCitynameByAirport(startairport)" /></td>
									<td><ww:property value="getCitynameByAirport(endairport)" /></td>
									<td><ww:property value="formatTimestampHHmm2(departtime)" /></td>
									<td><ww:property value="formatTimestampHHmm2(arrivaltime)" /></td>
									<td><ww:property value="cabincode" /></td>
									<td><ww:property value="discount" /></td>
									<td><ww:property value="yprice" />
									<input type="hidden" id="hidsairport_<ww:property value="#state.index" />" value="<ww:property value="startairport" />" />
									<input type="hidden" id="hideairport_<ww:property value="#state.index" />" value="<ww:property value="endairport" />" />
									<input type="hidden" id="hidfromdate_<ww:property value="#state.index" />" value="<ww:property value="formatTimestampyyyyMMdd(departtime)" />" />
									<input type="hidden" id="hidaircompany_<ww:property value="#state.index" />" value="<ww:property value="aircomapnycode" />" />
									<input type="hidden" id="hidflightnumber_<ww:property value="#state.index" />" value="<ww:property value="flightnumber" />" />
									<input type="hidden" id="hidcabin_<ww:property value="#state.index" />" value="<ww:property value="cabincode" />" />
									</td>
								</tr>
								<tr>
								 <td colspan="9">
								    <table width="100%" id="zrate4_2">
									<tr>
										<td align="left"><input type="button"
											value="普通政策信息" style="cursor:pointer; background: url(images/ddda.gif); width:151px; height:31px; line-height:31px; border:none; color:#fff" onclick="gettheratesep(<ww:property value="#state.index" />,0);"/>&nbsp;<input
								type="button" value="特殊政策信息" style="cursor:pointer; background: url(images/addd.gif); width:200px;height:31px; line-height:31px; border:none;" onclick="gettheratesep(<ww:property value="#state.index" />,1);" />
								</td>
								</tr>
								<tr>
									<td>
								
									<div style="width: 100%; border: 2px solid #FF9900; float: left;margin-top: -1px;">
									<table border="0" cellpadding="0" cellspacing="0" width="100%">
									  <tr >
										<td style="width: 20%;background:#DDECF3">适用政策条数</td>
										<td style="width: 25%;background:#DDECF3">普通返点</td>
										<td style="width: 25%;background:#DDECF3">单张代理费</td>
										<td style="width: 20%;background:#DDECF3">单张结算价</td>
										<!-- 
										<td style="width: 15%;background:#DDECF3">出票或废票时间</td>
										<td style="width: 15%;background:#DDECF3">出票速度</td>
										 -->
										<td style="background:#DDECF3">选择</td>
									</tr>
									<tr>
									    <td colspan="7">
									      <div id="divpolicyinfo_<ww:property value="#state.index" />">此处显示政策信息</div>
									    </td>
									</tr>
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

		

</table>
</div>
</form>
</body>
</html>


