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
<script language="javascript">
   function checkdata()
    {
         if($("#txtpnrcode").val()=="")
         {
               alert("PNR编码不能为空，请重新填写！");
               return false;
         }
         else if($("#txtpnrcode").val().length!=5 && $("#txtpnrcode").val().length!=6)
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
       $("#pnrinfo").show();
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
      document.form1.action="orderinfo!createPNR.action";
      document.form1.method = "POST"; 
      document.form1.submit();
            
    }
    //数据验证
    function checkorderdata()
    {
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
        $("#hidflag").val(index);
    }
    
</script>
</head>

<body onload="accountPrice();">
<form name="form1" id="form1" method="post"
	action="orderinfo!toCreatePnr.action"
	>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;PNR创建订单</b></td>
	</tr>
	<tr height="5px">
		<td></td>
	</tr>
	
	<tr>
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
								colspan=2 align=middle>成人PNR记录编号创建订单<span
								style=" ">(成人)</span></td>
						</tr>
						<tr>
							<td style="background-color: #d7e9fc; width: 30%; height: 38px"
								align="right" class=" tbody_color">请输入PNR编号：</td>
							<td style="text-align: left; width: 70%">&nbsp;&nbsp;
							<ww:if test="scang.id>0">
					<input id="txtpnrcode" name="strPNR" maxlength=10 type=text value="<ww:property value="scang.newpnr"/>" name="txtpnrcode">
							</ww:if><ww:else>
					<input id="txtpnrcode" name="strPNR" maxlength=10 type=text value="<ww:property value="strPNR"/>" name="txtpnrcode">
								</ww:else>
							<span style="display: none;  "
								id=requiredfieldvalidator1></span></td>
						</tr>
						<tr>
							<td style="text-align: center; height: 44px" colspan=2><input
								class="button_d font-bai" id="btnImport" value="提取PNR信息"
								type="button" name="btnImport" onclick="return checkdata();">
						    
						    &nbsp;&nbsp;
						    <input
								class="button_d font-bai" id="btnOrder" value="导入PNR信息"
								type="submit" name="btnOrder" id="btnOrder1" onclick="setflag(1)">
						    </td>
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
								class=maintitle02>&nbsp;<strong><span
								style=" ">注意事项：</span></strong></td>
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
		<td align="left" colspan="9">
		<div id="pnrinfo"
			style="display: none; background-color: Black; color: #00ff00; height: 121px; width: 88%; margin: 0 auto; overflow: auto;">
		</div>
		</td>
	</tr>
	<tr height="5px">
		<td></td>
	</tr>
	<tr>
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
								colspan=2 align=middle>使用PNR信息创建订单<span
								style=" ">(成人)</span></td>
						</tr>
						<tr>
							<td style="background-color: #d7e9fc; width: 30%; height: 38px"
								align="right" class=" tbody_color">PNR信息：</td>
							<td style="text-align: left; width: 70%">&nbsp;&nbsp;
							<textarea rows="5" cols="35" id="pnrinfo" name="s_pnrdetails" value="<ww:property value="s_pnrdetails"/>"></textarea>
							</td>
						</tr>
						<tr>
							<td style="text-align: center; height: 44px" colspan=2>
						    <input
								class="button_d font-bai" value="导入PNR信息"
								type="submit" name="btnOrder2"  id="btnOrder2" onclick="setflag(2)">
								<input type="hidden" id="hidflag" name="s_hidflag"></input>
						    </td>
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
								class=maintitle02>&nbsp;<strong><span
								style=" ">注意事项：</span></strong></td>
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
						class=maintitle02>&nbsp;<strong><span
						style=" ">航程信息: <ww:property value="strFlightString" /></span></strong></td>
				</tr>
				<tr>
					<td  align="center">
					<table id="tbTravel" class="book_pgcontent" width="95%" border=1 cellspacing=0 bordercolorlight=#a0cfee
			bordercolordark=white cellpadding=0>
						<tbody>
							<tr class='GridViewHeaderStyle' align="center" valign="middle">
								<td>承运人</td>
								<td>航班号</td>
								<td>起飞城市</td>
								<td>到达城市</td>
								<td>起飞时间</td>
								<td>到达时间</td>
								<td>舱位</td>
								<td>折扣</td>
							</tr>
							<ww:iterator value="listSegment">
							<tr class='postbg1' align="center" valign="middle">
								<td><img src="images/airComlogo/<ww:property value="aircomapnycode"/>.gif" border="0" /><ww:property value="getaircomnamebycode(aircomapnycode)"/></td>
								<td><ww:property value="flightnumber"/></td>
								<td><ww:property value="getCitynameByAirport(startairport)"/></td>
								<td><ww:property value="getCitynameByAirport(endairport)"/></td>
								<td><ww:property value="formatTimestampHHmm2(departtime)"/></td>
								<td><ww:property value="formatTimestampHHmm2(arrivaltime)"/></td>
								<td><ww:property value="cabincode"/></td>
								<td><ww:property value="discount"/></td>
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
						class=maintitle02>&nbsp;<strong><span
						style=" ">乘机人信息：</span></strong></td>
				</tr>
				<tr>
					<td style="line-height: 15px;" align="center">
					<table class="book_pgcontent" width="95%" border=1 cellspacing=0 bordercolorlight=#a0cfee
			bordercolordark=white cellpadding=0>
						<tbody>
							<tr class='GridViewHeaderStyle'>
								<td width="10%">乘客类型</td>
								<td width="10%">乘客姓名</td>
								<td width="10%">证件类型</td>
								<td width="10%">证件号码</td>
								<td width="10%">票价</td>
								<td width="10%">机建费</td>
								<td width="10%">燃油费</td>
							</tr>
                           <ww:iterator value="listPassenger" status="state">
							<tr>
								<td>成人</td>
								<td><ww:property value="name" /></td>
								<td>身份证</td>
								<td><input type="text" name="idnumber" id="idnumber_<ww:property value="#state.index"/>" style="width:100px" /></td>
								<td><input type="text" name="ticketprice" value="<ww:property value="strTicketPrice" />" id="ticketprice_<ww:property value="#state.index"/>" style="width:50px" /></td>
								<td><input type="text" name="taxprice" value="<ww:property value="strTAXPrice" />" id="taxprice_<ww:property value="#state.index"/>" style="width:50px" /></td>
								<td><input type="text" name="yqprice" value="<ww:property value="strYQPrice" />" id="yqprice_<ww:property value="#state.index"/>" style="width:50px" /></td>
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
			height=130>
			<tbody>
				<tr>
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span
						style=" ">票价信息：</span></strong></td>
				</tr>
				<tr>
					<td style="line-height: 15px;" align="center">
					<table class="book_pgcontent" width="95%" border=1 cellspacing=0 bordercolorlight=#a0cfee 
			bordercolordark=white cellpadding=0>
						<tbody>
							<tr class='GridViewHeaderStyle'>
								<td>总票价</td>
								<td>总机建费</td>
								<td>总燃油费</td>
							</tr>

							<tr>
								<td><input type="text" name="totalPrice" id="totalPrice" style="width:50px" />元</td>
								<td><input type="text" name="totaltaxPrice" id="totaltaxprice" style="width:50px" />元</td>
								<td><input type="text" name="totalyqPrice" id="totalyqprice" style="width:50px" />元</td>
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
					<td
						style="text-align: left; background-color: #d7e9fc; height: 25px"
						class=maintitle02>&nbsp;<strong><span
						style=" ">导入订单状态：</span></strong></td>
				</tr>
				<tr> 
				<td>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="s_orderstatuspnr"><option value="1">等待支付</option><option value="3">出票完成</option></select>&nbsp;&nbsp;<span style="color:red">*请按照机票是否出票来选择订单状态！</span>
         </td>
         </tr>
         </table>
	  </td>
	</tr>
	<tr>
	  <td>
         <table border=0 cellspacing=0 cellpadding=0 width="88%" align=center>
			<tr>
			<td align="center" height="40">
         <input class="button_d font-bai" id="btnOrder" value="创建订单" type="button" name="btnOrder" onclick="return checkorderdata();">
         </td>
         </tr>
         </table>
	  </td>
	</tr>
<input type="hidden" name="orderinfoid" id="" value="<ww:property value="scang.orderid"/>" style="width:50px" />
<input type="hidden" name="angenid" id="" value="<ww:property value="getangenid(scang.orderid)"/>" style="width:50px" />
<input type="hidden" name="userid" id="" value="<ww:property value="getuserid(scang.orderid)"/>" style="width:50px" />
<input type="hidden" name="scangid" id="" value="<ww:property value="scang.id"/>" style="width:50px" />


</table>
</div>
</form>
</body>
</html>


