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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script language="javascript">
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
            url:"orderinfof!rtPNRinfo.action",
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
       //出发站机建费
       $("input[id*='txtsairportfee_']").each(function(i)
       {
          var price2=$(this).val();
          totaltaxprice=parseInt(totaltaxprice);
          if($(this).val()!="")
          {
             totaltaxprice+=parseInt($(this).val()); 
          }
       });
       //到达站机建费
       $("input[id*='txteairportfee_']").each(function(i)
       {
          if($(this).val()!="")
          {
            totaltaxprice+=parseInt($(this).val()); 
          }
       });
       //燃油费
       $("input[id*='txtfuelfee_']").each(function(i)
       {
          if($(this).val()!="")
          {
            totaltaxprice+=parseInt($(this).val()); 
          }
       });
       //安检费用
       $("input[id*='txtanjianfee_']").each(function(i)
       {
          if($(this).val()!="")
          {
            totaltaxprice+=parseInt($(this).val()); 
          }
       });
       
       $("#totaltaxprice").val(totaltaxprice);
       
       $("#totalallprice").val(parseInt($("#totaltaxprice").val())+parseInt($("#totalPrice").val()));
      
    }
    //创建订单
    function createorder()
    {     
      document.form1.action="orderinfof!createPNROrder.action";
      document.form1.method = "POST"; 
      document.form1.submit();
            
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
             window.location.href='orderinfo!tob2c.action?s_orderid='+tnumberflag;
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
       document.form1.action="orderinfof!toCreateOrderBytnumber.action";
       document.form1.method = "POST"; 
       dispose("机票信息正在导入");
       document.form1.submit();
       
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
    //数据验证
    function checkorderdata()
    {
       if($("#txtpnrcode").val()=="" && $("#txtticketnumber").val()=="")
         {
               alert("PNR编码和票号请至少填写一项，请重新填写！");
               return false;
         }
         if($("#txtpnrcode").val()!="" &&　$.trim($("#txtpnrcode").val()).length!=5 && $.trim($("#txtpnrcode").val()).length!=6)
         {
               alert("PNR编码格式不正确，请重新填写！");
               return false;
         }
         //验证票号格式
         if($.trim($("#txtticketnumber").val())!="" && $.trim($("#txtticketnumber").val()).length!=14 && IsTicketNumber($.trim($("#txtticketnumber").val())))
         {
             alert("您输入的票号格式不正确，请重新填写！票号格式如：784-1771188239");
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
       pnrflag=validPnr($("#txtpnrcode").val(),etermtype,passengernames);
       if(pnrflag!="0")
       {
          alert("此PNR已经存在，请重新填写PNR!");
          return false;
       }
       
       //乘机人证件号是否为空
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
       //手机号不能为空
       var mobile="0";
       $("input[id*='txtmobile_']").each(function(i)
       {
          if($(this).val()=="")
          {
             mobile="1";
          }
       }
       );
       if(mobile=="1")
       {
           alert("乘机人手机号不能为空，请确认没有导入身份证号的字段不为空!");
           return false;
       }
       //证件有效期
       var idvaliddate="0";
       $("input[id*='txtidvaliddate_']").each(function(i)
       {
          if($(this).val()=="")
          {
             idvaliddate="1";
          }
       }
       );
       if(idvaliddate=="1")
       {
           alert("乘机人证件有效期不能为空，请确认没有导入有效期不为空!");
           return false;
       }
       //出生日期
        var birthday="0";
       $("input[id*='txtbirthday_']").each(function(i)
       {
          if($(this).val()=="")
          {
             birthday="1";
          }
       }
       );
       if(birthday=="1")
       {
           alert("乘机人出生日期不能为空，请确认没有导入出生日期不为空!");
           return false;
       }
       //票价信息
       var ticketprice="0";
       $("input[id*='txtticketprice_']").each(function(i)
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
       //出发站机建费
       var sairportfee="0";
       $("input[id*='txtsairportfee_']").each(function(i)
       {
          if($(this).val()=="")
          {
             sairportfee="1";
          }
          else
          {
             if(!IsNumber($(this).val()))
             {
                 sairportfee="2";
             }
          }
       });
       if(sairportfee=="1")
       {
           alert("出发站机建费不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
       else if(sairportfee=="2")
       {
           alert("出发站机建费只能输入数字，请重新填写!");
           return false;
       }
       //到达站机建费
       var eairportfee="0";
       $("input[id*='txteairportfee_']").each(function(i)
       {
           if($(this).val()=="")
          {
             eairportfee="1";
          }
           else
          {
             if(!IsNumber($(this).val()))
             {
                 eairportfee="2";
             }
          }
       });
       if(eairportfee=="1")
       {
           alert("到达站机建费不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
       else if(eairportfee=="2")
       {
           alert("到达站机建费只能输入数字，请重新填写!");
           return false;
       }
       //燃油费
        var fuelfee="0";
       $("input[id*='txtfuelfee_']").each(function(i)
       {
           if($(this).val()=="")
          {
             fuelfee="1";
          }
           else
          {
             if(!IsNumber($(this).val()))
             {
                 fuelfee="2";
             }
          }
       });
       if(fuelfee=="1")
       {
           alert("燃油费不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
       else if(fuelfee=="2")
       {
           alert("燃油费只能输入数字，请重新填写!");
           return false;
       }
       //海关安检费
       var anjianfee="0";
       $("input[id*='txtanjianfee_']").each(function(i)
       {
           if($(this).val()=="")
          {
             anjianfee="1";
          }
           else
          {
             if(!IsNumber($(this).val()))
             {
                 anjianfee="2";
             }
          }
       });
       if(anjianfee=="1")
       {
           alert("海关安检费不能为空，请确认没有导入价格的字段不为空!");
           return false;
       }
       else if(anjianfee=="2")
       {
           alert("海关安检费只能输入数字，请重新填写!");
           return false;
       }
       //总票价
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
          alert("总税金不能为空，请确认没有导入与价格的字段不为空!");
          return false;
       }
       else
       {
          if(!IsNumber(document.getElementById("totaltaxprice").value))
           {
              alert("总税金只能输入整数!");
              return false;
           }
       }
       if($("#totalallprice").val()=="")
       {
          alert("总金额不能为空，请确认没有导入与价格的字段不为空!");
          return false;
       }
       else
       {
          if(!IsNumber(document.getElementById("totalallprice").value))
           {
              alert("总金额只能输入整数!");
              return false;
           }
       }
       //代理人报价（票价）
       if($("#txtdailirenpiaojia").val()=="")
       {
          alert("代理人报价(票价)不能为空，请确认没有导入与价格的字段不为空!");
          return false;
       }
       else
       {
           if(!IsNumber(document.getElementById("txtdailirenpiaojia").value))
           {
              alert("代理人报价(票价)只能输入整数!");
              return false;
           }
       }
       //代理人报价(税金)
        if($("#txtdailirenshuijin").val()=="")
       {
          alert("代理人报价(税金)不能为空，请确认没有导入与价格的字段不为空!");
          return false;
       }
       else
       {
           if(!IsNumber(document.getElementById("txtdailirenshuijin").value))
           {
              alert("代理人报价(税金)只能输入整数!");
              return false;
           }
       }
       
       createorder();
    }
    function setflag(index)
    {
        $("#hidflag").val(index);
    }
    
    function validPnr(pnr,etermtype,passengernames)
    {
       var varret="";
       $.ajax({
        type:"POST",
        url:"orderinfof!IsExistPNR.action",
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
//更改航程中的值信息
function changesegsession(index,value)
{
     $.ajax({
        type:"POST",
        url:"orderinfof!changeSessionSegByAjax.action",
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
        url:"orderinfof!changeSessionPassByAjax.action",
        async:false,
        data:{s_cindex:index,s_cvalue:$("#"+value+index).val(),s_cname:value},
        beforeSend:function(){},             
        success:function(data){
        }            
        });
}
</script>

</head>

<body onload="accountPrice();">
<form name="form1" id="form1" method="post"
	action="orderinfof!toCreateOrderByPnr.action">
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;国际PNR创建订单</b></td>
	</tr>
	<tr height="5px">
		<td></td>
	</tr>
	<tr>
		<td>
		<div><jsp:include page="../orderuserinfo.jsp"></jsp:include></div>
		</td>
	</tr>
	<tr height="10px">
		<td></td>
	</tr>
	<tr <ww:if test='importtype.equals("3") || importtype.equals("4")'>style='display:none'</ww:if>>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;配置类型：
		<input type="radio" id="rdoetermtype1" name="etermtype"
			<ww:if test="etermtype==1">checked="checked"</ww:if>
			value="1" />一般代理人配置PNR&nbsp;&nbsp; <input type="radio"
			id="rdoetermtype2" name="etermtype" value="2"
			<ww:if test="etermtype==2 || etermtype==0 || etermtype==null">checked="checked"</ww:if> />航空公司配置PNR&nbsp;&nbsp;<span
			style="color: red">*请选择PNR导入类型</span></td>
	</tr>
	<tr>
		<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr id=adultstable>
				<td>
				<input type="hidden" name="importtype" value="<ww:property value="importtype"/>" />
				<ww:if test='importtype.equals("1") || importtype.equals("2")'>
				<table border=1 cellspacing=0 bordercolorlight=#a0cfee
					bordercolordark=white cellpadding=0 width=400 align=center
					height=110>
					<tbody>
						<tr>
							<td style="height: 36px; font-weight: bold" class=maintitle02
								colspan=2 align=middle>PNR记录编号创建订单<span style="">(成人/儿童/婴儿)</span></td>
						</tr>
						<tr>
							<td style="background-color: #d7e9fc; width: 30%; height: 38px"
								align="right" class=" tbody_color">请输入PNR编号：</td>
							<td style="text-align: left; width: 70%">&nbsp;&nbsp;<input
								id="txtpnrcode" name="strPNR" maxlength=10 type=text
								value="<ww:property value="strPNR"/>" name="txtpnrcode">
							<span style="display: none;" id=requiredfieldvalidator1></span></td>
						</tr>
						<tr>
							<td style="text-align: center; height: 44px" colspan=2><input
								class="button_d font-bai" id="btnImport" value="提取PNR信息"
								type="button" name="btnImport" onclick="return checkdata();">

							&nbsp;&nbsp; <input class="button_d font-bai" id="btnOrder"
								value="导入PNR信息" type="submit" name="btnOrder" id="btnOrder1"
								onclick="setflag(1)"></td>
						</tr>
					</tbody>
				</table>
				</ww:if>
				<ww:else>
				<table border=1 cellspacing=0 bordercolorlight=#a0cfee
					bordercolordark=white cellpadding=0 width=400 align=center
					height=110>
					<tbody>
						<tr>
							<td style="height: 36px; font-weight: bold" class=maintitle02
								colspan=2 align=middle>根据票号导入订单信息</span></td>
						</tr>
						<tr>
							<td style="background-color: #d7e9fc; width: 30%; height: 38px"
								align="right" class=" tbody_color">请输入票号：</td>
							<td style="text-align: left; width: 70%">&nbsp;&nbsp;<input
								id="txtticketnumber" name="strticketnumber" maxlength=14
								type=text value="<ww:property value="strticketnumber"/>"><span
								style="color: red">*</span> <span style="display: none;"
								id=requiredfieldvalidator1></span></td>
						</tr>
						<tr>
							<td style="text-align: center; height: 44px" colspan=2>
							&nbsp;&nbsp; <input class="button_d font-bai" id="btnOrder"
								value="导入机票信息" type="submit" name="btnOrder" id="btnOrder1"
								onclick="return checkticketnumber();"></td>
						</tr>
					</tbody>
				</table>
				</ww:else>
				</td>
				<td valign=top>
				<ww:if test='importtype.equals("3") || importtype.equals("4")'>
						<table border=1 cellspacing=0 bordercolorlight="#a0cfee"
					bordercolordark=white cellpadding=0 width=400 align=center
					height=110>
					<tbody>
						<tr>
							<td
								style="text-align: left; background-color: #d7e9fc; height: 25px"
								class=maintitle02>&nbsp;<strong><span style="">注意事项：
								<input
								id="txtpnrcode" style="display:none" name="strPNR" maxlength=10 type=text
								value="<ww:property value="strPNR"/>" name="txtpnrcode">
								</span></strong></td>
						</tr>
						<tr>
							<td style="text-align: left; line-height: 15px; height: 100px">
							<span>&nbsp;1、支持一年以内票号导入.</span><br>
							&nbsp;2、请确定该票号格式是否正确,如：781-2344532168.<br>
							&nbsp;3、请确定导入机票信息是否正确.<br>
							&nbsp;4、请确定机票的状态是否正确.<br>
							&nbsp;5、请确定机票的出票或退废票的时间是否正确.</td>
						</tr>
					</tbody>
				</table>
				</ww:if>
				<ww:else>
				<table border=1 cellspacing=0 bordercolorlight="#a0cfee"
					bordercolordark=white cellpadding=0 width=400 align=center
					height=110>
					<tbody>
						<tr>
							<td
								style="text-align: left; background-color: #d7e9fc; height: 25px"
								class=maintitle02>&nbsp;<strong><span style="">注意事项：
								<input
								id="txtticketnumber" style="display:none" name="strticketnumber" maxlength=14
								type=text value="<ww:property value="strticketnumber"/>">
								</span></strong></td>
						</tr>
						<tr>
							<td style="text-align: left; line-height: 15px; height: 100px">
							<span>&nbsp;1、支持成人单程、往返程及团队pnr编码导入.</span><br>
							&nbsp;2、请确定该pnr姓名组正确.<br>
							&nbsp;3、请确定航段组正确、舱位状况正确.<br>
							&nbsp;4、请确定每个乘客均有真实的ssr foid 项输入.<br>
							&nbsp;5、请确定票价是否正确.</td>
						</tr>
					</tbody>
				</table>
				</ww:else>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr height="5px">
		<td></td>
	</tr>
	<tr>
		<td align="left" colspan="9">
		<div id="pnrinfo"
			style="display: none; background-color: Black; color: #00ff00; height: 121px; width: 88%; margin: 0 auto; overflow: auto;">
		</div>
		</td>
	</tr>
	<tr height="5px">
		<td></td>
	</tr>
	<tr <ww:if test='importtype.equals("3") || importtype.equals("4")'>style='display:none'</ww:if>>
		<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr id=adultstable>
				<td>
				<table border=1 cellspacing=0 bordercolorlight=#a0cfee
					bordercolordark=white cellpadding=0 width=400 align=center
					height=110>
					<tbody>
						<tr>
							<td style="height: 36px; font-weight: bold" class=maintitle02
								colspan=2 align=middle>使用PNR信息创建订单<span style="">(成人/儿童/婴儿)</span></td>
						</tr>
						<tr>
							<td style="background-color: #d7e9fc; width: 30%; height: 38px"
								align="right" class=" tbody_color">PNR信息：</td>
							<td style="text-align: left; width: 70%">&nbsp;&nbsp; <textarea
								rows="5" cols="35" id="pnrinfo" name="s_pnrdetails"
								value="<ww:property value="s_pnrdetails"/>"></textarea></td>
						</tr>
						<tr>
							<td style="text-align: center; height: 44px" colspan=2><input
								class="button_d font-bai" value="导入PNR信息" type="submit"
								name="btnOrder2" id="btnOrder2" onclick="setflag(2)"> <input
								type="hidden" id="hidflag" name="s_hidflag"></input></td>
						</tr>
					</tbody>
				</table>
				</td>
				<td valign=top>
				<table border=1 cellspacing=0 bordercolorlight=#a0cfee
					bordercolordark=white cellpadding=0 width=400 align=center
					height=110>
					<tbody>
						<tr>
							<td
								style="text-align: left; background-color: #d7e9fc; height: 25px"
								class=maintitle02>&nbsp;<strong><span style="">注意事项：</span></strong></td>
						</tr>
						<tr>
							<td style="text-align: left; line-height: 15px; height: 100px">
							<span>&nbsp;1、支持成人单程、往返程及团队pnr编码导入.</span><br>
							&nbsp;2、请确定该pnr姓名组正确.<br>
							&nbsp;3、请确定航段组正确、舱位状况正确.<br>
							&nbsp;4、请确定每个乘客均有真实的ssr foid 项输入.<br>
							&nbsp;5、请确定票价是否正确.</td>
						</tr>
					</tbody>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr height="5px">
		<td></td>
	</tr>
	<tr>
		<td>
		<table border=1 cellspacing=0 bordercolorlight=#a0cfee
			bordercolordark=white cellpadding=0 width="88%" align=center
			height=110>
			<tbody>
				<tr>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span style="">航程信息:
					<ww:property value="strFlightString" /></span></strong></td>
				</tr>
				<tr>
					<td align="center">
					<table id="tbTravel" class="book_pgcontent" width="95%" border=1
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
								<!--  <td>折扣</td>-->
								<td>票面价</td>
							</tr>
							<ww:iterator value="listSegment" status="state">
								<tr class='postbg1' align="center" valign="middle">
									<td><img
										src="images/airComlogo/<ww:property value="aircomapnycode"/>.gif"
										border="0" /><ww:property
										value="getaircomnamebycode(aircomapnycode)" /></td>
									<td><ww:property value="flightnumber" /></td>
									<td><ww:property
										value="getCitynameByAirport(startairport)" /></td>
									<td><ww:property value="getCitynameByAirport(endairport)" /></td>
									<td><input type="text" name="departtime" id="fromdate_<ww:property value="#state.index" />" style="width:100px" onblur="changesegsession(<ww:property value="#state.index" />,'fromdate')" value="<ww:property value="formatTimestampHHmm2(departtime)" />"></td>
									<td><input type="text" name="arrivaltime" id="todate_<ww:property value="#state.index" />" style="width:100px" onblur="changesegsession(<ww:property value="#state.index" />,'todate')" value="<ww:property value="formatTimestampHHmm2(arrivaltime)" />"></td>
									<td><input type="text" name="cabincode" id="cw_<ww:property value="#state.index" />" onblur="changesegsession(<ww:property value="#state.index" />,'cw')" style="width:40px" value="<ww:property value="cabincode" />" /></td>
									<td><input type="text"
										id='txtdiscount_<ww:property value="#state.index" />'
										name="discount" style="width: 50px" onblur="changesegsession(<ww:property value="#state.index" />,'txtdiscount')"
										value='<ww:property value="discount" />'></td>
									<td><input type="text" name="yprice" id="totalfare_<ww:property value="#state.index" />" onblur="changesegsession(<ww:property value="#state.index" />,'totalfare')" style="width:100px"></td>
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
			bordercolordark=white cellpadding=0 width="88%" align=center
			height=110>
			<tbody>
				<tr>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span style="">乘机人信息：</span></strong></td>
				</tr>
				<tr>
					<td style="line-height: 15px;" align="center">
					 <ww:iterator value="listPassenger" status="state">
				     <table width="98%" class="book_pgcontent" border="1" cellspacing="0" bordercolorlight="#a0cfee" bordercolordark="white" cellpadding="0">
					  <tr>
					    <td colspan="10" align="left" style="color:#FF0000"><b>乘机人<ww:property value="#state.index+1"/></b></td>
                      </tr>
					  <tr>
					    <td width="12%" align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">英文姓名：</td>
					    <td width="11%" align="left"><input type="text" id="span_passname_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'span_passname_')" style="width:100px" name="guestname" value="<ww:property value="guestname"/>"></td>
					    <td width="12%" align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">是否留学生：</td>
					    <td colspan="7" align="left">
					    <select name="isstudent">
								<option value="0">否</option>
								<option value="1">是</option>
							</select>
					    </td>
					  </tr>
					  <tr>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">证件类型：</td>
					    <td align="left">护照</td>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">证件号码：</td>
					    <td width="12%" align="left"><input type="text" id="idnumber_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'idnumber_')" style="width:100px" name="guestidno" value="<ww:property value="guestidno"/>"></td>
					    <td width="10%" align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">证件有效期：</td>
					    <td colspan="5" align="left"><input type="text" id="txtidvaliddate_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtidvaliddate_')" style="width:100px" name="targetaddress" value="<ww:property value="targetaddress"/>" /></td>
					  </tr>
					  <tr>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">国籍/地区：</td>
					    <td align="left">
						    <select name="countrycode" style="width:100px">
						      <ww:iterator value="listcountry">
						      <option value="<ww:property value="countrycode"/>" <ww:if test='countrycode.equals(listguest.get(#state.index).countrycode)'>selected="selected"</ww:if>><ww:property value="countrycode"/><ww:property value="countryname"/></option>
						      </ww:iterator>
						    </select>
					    </td>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">性别：</td>
					    <td align="left">
					    <select name="gender">
								<option value="1">男</option>
								<option value="2">女</option>
							</select>
					    </td>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">出生日期：</td>
					    <td colspan="5" align="left">
                        <input type="text" id="txtbirthday_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtbirthday_')" style="width:100px" name="birthday" value="<ww:property value="formatTimestamp2(birthday)"/>">
                        </td>
					  </tr>
					  <tr>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">票价：</td>
					    <td align="left"><input type="text" id="txtticketprice_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtticketprice_')"  style="width:100px" name="ticketprice" value="<ww:property value="ticketprice"/>"></td>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">机建费：</td>
					    <td align="left"><input type="text" id="txtsairportfee_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtsairportfee_')" style="width:50px" name="sairportfee" value="<ww:property value="sairportfee"/>"></td>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">燃油费：</td>
					    <td width="10%" align="left">
					    <input type="text" id="txtfuelfee_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtfuelfee_')" style="width:50px" name="fuelfee" value="<ww:property value="fuelfee"/>">
					    </td>
					    <td width="6%" align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">安检费：</td>
					    <td width="8%" align="left">
					    <input type="text" id="txtanjianfee_<ww:property value="#state.index"/>" style="width:50px" onblur="changepasssession(<ww:property value="#state.index" />,'txtanjianfee_')" name="anjianfee" value="<ww:property value="anjianfee"/>">
					    </td>
					    <td width="9%" align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">其他费用：</td>
					    <td width="10%" align="left"><input type="text" id="txteairportfee_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txteairportfee_')" style="width:50px" name="eairportfee" value="<ww:property value="eairportfee"/>"></td>
                      </tr>
                       <tr>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">手机号：</td>
					    <td align="left"><input type="text" id="txtmobile_<ww:property value="#state.index"/>" style="width:100px" onblur="changepasssession(<ww:property value="#state.index" />,'txtmobile_')" name="mobile" value="<ww:property value="mobile"/>" /></td>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">票号：</td>
					    <td align="left"><input type="text" id="txtticketnumber_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtticketnumber_')" style="width:100px" name="ticketnumber" value="<ww:property value="ticketnumber"/>" /></td>
					    <td align="right" style="text-align: right; background-color: #d7e9fc; height: 25px">行程单号：</td>
					    <td colspan="5" align="left"><input type="text" id="txtfetnumber_<ww:property value="#state.index"/>" onblur="changepasssession(<ww:property value="#state.index" />,'txtfetnumber_')" style="width:100px" name="fetnumber" value="<ww:property value="fetnumber"/>" /></td>
                        </tr>
					</table>
					</ww:iterator>
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
			bordercolordark=white cellpadding=0 width="88%" align=center
			height=130>
			<tbody>
				<tr>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span style="">票价信息：</span></strong></td>
				</tr>
				<tr>
					<td style="line-height: 15px;" align="center">
					<table class="book_pgcontent" width="95%" border=1 cellspacing=0
						bordercolorlight=#a0cfee bordercolordark=white cellpadding=0>
						<tbody>
							<tr class='GridViewHeaderStyle'>
								<td>总票价</td>
								<td>总税金</td>
								<td>总金额</td>
								<td>代理人报价（票价）</td>
								<td>代理人报价（税金）</td>
								<td>折扣比例</td>
								<td>折扣金额</td>
							</tr>

							<tr>

								<td><input type="text" name="totalticketfare" id="totalPrice"
									style="width: 50px" />元</td>
								<td><input type="text" name="totalfax"
									id="totaltaxprice" style="width: 50px" />元</td>
								<td><input type="text"
									id="totalallprice" style="width: 50px" />元</td>
								<td><input type="text" name="dailirenpiaojia"
									id="txtdailirenpiaojia" style="width: 50px" value="0" />元</td>
									<td><input type="text" name="dailirenshuijin"
									id="txtdailirenshuijin" style="width: 50px" value="0" />元</td>
								<td><input type="text" name="zhekoubili" id="txtzhekoubili"
									style="width: 50px" /></td>
								<td><input type="text" name="zhekoujine" id="txtzhekoujine"
									style="width: 50px" />元</td>
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
			bordercolordark=white cellpadding=0 width="88%" align=center
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
						class=maintitle02>订单出票状态：</td>
					<td align="left"><select name="s_orderstatuspnr">
						<option value="1"
							<ww:if test='s_orderstatuspnr.equals("1")'>selected="selected"</ww:if>>未出票</option>
						<option value="2"
							<ww:if test='getbiguser(getOrderUserLogin().id) && !s_orderstatuspnr.equals("3")'>selected="selected"</ww:if>>支付成功，等待出票</option>
						<option value="3"
							<ww:if test='s_orderstatuspnr.equals("3")'>selected="selected"</ww:if>>出票完成</option>
						<option value="6"
							<ww:if test='s_orderstatuspnr.equals("6")'>selected="selected"</ww:if>>已取消
						</option>
					</select>&nbsp;&nbsp;</td>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02 align="right">订单紧急状态：</td>
					<td align="left"><select name="s_busystatus">
						<option value="2">一般</option>
						<option value="1">紧急</option>
						<option value="3">待定</option>
					</select></td>
				</tr>

				<tr>
					<td
						style="text-align: right; background-color: #d7e9fc; height: 25px"
						class=maintitle02>支付状态：</td>
					<td><select name="s_paystatus">
						<option value="0">未支付</option>
						<option value="1"
							<ww:if test='getbiguser(getOrderUserLogin().id)'>selected="selected"</ww:if>>已支付</option>
					</select>&nbsp;&nbsp;</td>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>支付方式：</td>
					<td><ww:if test="getbiguser(getOrderUserLogin().id)">
						<input type="radio" name="s_paymethods" value="5"
							checked="checked" id="rdopaymethod"
							onclick="changeraddisable('postmoney2','','postmoney3','','postmoney4','','postmoney1');showpeisong();" />客户挂账（大客户后付款）&nbsp;&nbsp; 
		            <input type="radio" name="s_paymethods" value="4"
							id="rdopaymethod"
							onclick="changeraddisable('postmoney2','','postmoney3','','postmoney4','','postmoney1')" />无卡支付&nbsp;&nbsp; 
					<input type="radio" name="s_paymethods" value="2"
							id="rdopaymethod2"
							onclick="changeraddisable('postmoney1','disabled','postmoney3','disabled','postmoney4','disabled','postmoney2')" />门市付款&nbsp;&nbsp; 
					<input type="radio" name="s_paymethods" value="3"
							id="rdopaymethod3"
							onclick="changeraddisable('postmoney1','disabled','postmoney2','disabled','postmoney4','','postmoney3')" />票到付款
					&nbsp;&nbsp; 
					<input type="radio" name="s_paymethods" value="6"
							id="rdopaymethod3"
							onclick="changeraddisable('postmoney1','disabled','postmoney3','disabled','postmoney4','disabled','postmoney2')" />柜台现付
		            </ww:if><ww:else>
						<input type="radio" name="s_paymethods" value="4"
							checked="checked" id="rdopaymethod"
							onclick="changeraddisable('postmoney2','','postmoney3','','postmoney4','','postmoney1')" />无卡支付&nbsp;&nbsp; 
					<input type="radio" name="s_paymethods" value="2"
							id="rdopaymethod2"
							onclick="changeraddisable('postmoney1','disabled','postmoney3','disabled','postmoney4','disabled','postmoney2')" />门市付款&nbsp;&nbsp; 
					<input type="radio" name="s_paymethods" value="3"
							id="rdopaymethod3"
							onclick="changeraddisable('postmoney1','disabled','postmoney2','disabled','postmoney4','','postmoney3')" />票到付款
					&nbsp;&nbsp; 
					<input type="radio" name="s_paymethods" value="6"
							id="rdopaymethod3"
							onclick="changeraddisable('postmoney1','disabled','postmoney3','disabled','postmoney4','disabled','postmoney2')" />柜台现付
		</ww:else></td>
				</tr>
				<!-- 保险信息 -->
				<tr style="display:none">
					<td
						style="text-align: right; background-color: #d7e9fc; height: 25px"
						class=maintitle02>保险种类：</td>
					<td><select>
						<option value="1">中保人寿</option>
						<option value="2">太平洋保险</option>
					</select></td>
					<td
						style="text-align: right; background-color: #d7e9fc; height: 25px"
						class=maintitle02>保险份数：</td>
					<td><select id="txtbaoxianfenshu" name="s_insurance" style="width: 50px"
						onchange="accountbaoxian();">
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
				<tr style="display:none">
					<td
						style="text-align: right; background-color: #d7e9fc; height: 25px"
						class=maintitle02>保险金额：</td>
					<td><input id="txtbaoxianjine" name="baoxianjine" value="0" /></td>
					<td
						style="text-align: right; background-color: #d7e9fc; height: 25px"
						class=maintitle02>保险单号：</td>
					<td><input id="txtbaodanhao" name="baodanhao" /></td>
				</tr>
				<!-- 保险信息结束 -->



				<tr>
					<td
						style="text-align: right; background-color: #d7e9fc; height: 25px"
						class="maintitle02">配送方式：</td>
					<td colspan="3" align="left">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						style="line-height: 30px; margin: 0 auto; margin-bottom: 10px;">

						<tr>
							<td colspan="2"><input type="radio" id="postmoney1"
								name="receipt" value="1"
								<ww:if test="!getbiguser(getOrderUserLogin().id)">checked="checked"</ww:if> />&nbsp;&nbsp;我不需要配送</td>
						</tr>
						<tr>
							<td colspan="2"><input type="radio" id="postmoney2"
								value="2" name="receipt" />&nbsp;&nbsp;市内自取</td>
						</tr>

						<tr>
							<td colspan="2"><input id="postmoney3" type="radio"
								onclick="showdiag('addtesstable_my','none');showdiag('addtesstable','block');"
								name="receipt" value="3" />&nbsp;&nbsp;快递行程单发票(费用20元；航班起飞后快递，约3-5个工作日到)</td>
						</tr>
						<tr>
							<td colspan="2"><input id="postmoney4" type="radio"
								name="receipt"
								onclick="showdiag('addtesstable_my','none');showdiag('addtesstable','block');"
								value="4" />&nbsp;&nbsp;市内配送</td>
						</tr>
						<tr>
							<td colspan="2">
							<table border="0" cellspacing="0" cellpadding="0"
								id="addtesstable" style="display: none;">
								<tr>
									<td align="right" width="140">收件人姓名：</td>
									<td><input maxlength="10" id="postname" name="postname"
										style="width: 120px;"></input>&nbsp;<font class="red">*</font></td>
								</tr>
								<tr>
									<td align="right">联系电话：</td>
									<td><input maxlength="15" id="postmobile"
										name="postmobile" style="width: 120px;"></input>&nbsp;<font
										class="red">*</font></td>
								</tr>
								<tr>
									<td align="right">邮编：</td>
									<td><input maxlength="7" id="postcode" name="postcode"
										style="width: 120px;"></input></td>
								</tr>
								<tr>
									<td align="right">地址：</td>
									<td><textarea maxlength="50" id="addresa" name="addresa"
										id="dizhi1" style="width: 400px;" rows="2"></textarea> &nbsp;<font
										class="red">*</font></td>
								</tr>
								<tr>
									<td align="right">备注：</td>
									<td><textarea maxlength="50" id="memo" name="memo"
										desc="备注" style="width: 400px;" rows="2"></textarea> &nbsp;</td>
								</tr>
								<tr>
									<td></td>
									<td>备注:请选择您所邮寄的省份、城市、街道地址不祥将影响邮寄. <br />
									地址格式:XXX省XX市XX区XX小区2-12-502,如:北京市顺义区馨港庄园2-5-601</td>
								</tr>
								<tr>
									<td></td>
								</tr>
							</table>
							<table border="0" cellspacing="0" cellpadding="0"
								id="addtesstable_my" style="display: none;">
								<tr>
									<td></td>
									<td><ww:property value="ziquaddress()" /></td>
								</tr>
								<tr>
									<td></td>
								</tr>
							</table>
							</td>
						</tr>
						<ww:if test='getbiguser(getOrderUserLogin().id)'>
							<tr>
								<td colspan="2"><input type="radio" id="postmoney0"
									name="receipt" value="5"
									<ww:if test="getbiguser(getOrderUserLogin().id)">checked="checked"</ww:if> />&nbsp;&nbsp;按大客户协议配送</td>
							</tr>
						</ww:if>
						<tr>
							<td></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td
						style="text-align: right; background-color: #d7e9fc; height: 25px"
						class="maintitle02">订单备注：</td>
					<td colspan="3" align="left"><textarea rows="7" cols="45"
						name="s_memo"></textarea></td>
				</tr>
		</table>
		</td>
	</tr>

	<tr>
		<td>
		<table border=0 cellspacing=0 cellpadding=0 width="88%" align=center>
			<tr>
				<td align="center" height="40"><input class="button_d font-bai"
					id="btnOrder" value="创建订单" type="button" name="btnOrder" onclick="return checkorderdata();">  </td>
			</tr>
		</table>
		</td>
	</tr>

</table>
</div>
</form>
</body>
</html>


