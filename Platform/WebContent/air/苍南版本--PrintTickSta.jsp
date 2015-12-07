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
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
<link types="text/css" rel="stylesheet" href="style/base100108.css">
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
       <title>打印行程单</title>
	     <style type="text/css">
	.textareacls
{
   color: #0356a6;
   font-family: TEC, "宋体";
   font-size: 16pt;
}     
*{
-moz-box-sizing: border-box;
}
input{color: #0356a6;
      font-family: TEC, "宋体";
	  font-size: 16pt;}


.title { 
   font-family : Arial,Vernada,Tahoma, sans-serif;
   font-size: 30px;
   color : #00008B;
   background-color : White; text-decoration:underline;letter-spacing: 1px;
}

.normal{
	font-family : Arial,Vernada, Tahoma, Helvetica, sans-serif;
	font-size: 12px;
	color: #444444;
	text-decoration: none;
	line-height: 21px;letter-spacing: 1px;}


.hide_for_jatools_print{}
.jc{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 86px;
	letter-spacing: 1px;
}
.jc1{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 86px;
	letter-spacing: 1px;
}
.jc2{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 66px;
	letter-spacing: 1px;
}
.jc3{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 30px;
	letter-spacing: 1px;
}
.jc4{
	position:absolute;
	overflow:hidden;
	font-family: TEC, "宋体";
	font-size: 16pt;
	width: 86px;
	letter-spacing: 1px;
}
.jnc{position:absolute;height:380px}
.pb{overflow:hidden;position:relative;margin:5;width:857;background-color:white;height:380px;
border-left:1px solid black;border-top:1px solid black;	border-right:4px solid black;border-bottom:4px solid black;}
.c12{margin-left:2px;margin-bottom:-2px;font-family: 宋体;font-size: 24px;font-weight: bold;color: #FF0000;letter-spacing: 1px;}
.c9, .c8, .c6, .c5, .c4, .c3, .c0{margin-left:2px;margin-bottom:-2px;font-family: 宋体;font-size: 12px;;letter-spacing: 1px;}
.c2{margin-left:2px;margin-bottom:-2px;font-family: 宋体;font-size: 12px;;letter-spacing: 1px;}
.c7{margin-left:2px;margin-bottom:-2px;text-align: right;font-family: 宋体;font-size: 12px;;letter-spacing: 1px;}
.c11, .c10, .c1{margin-left:2px;margin-bottom:-2px;text-align: right;font-family: 宋体;font-size: 12px;;letter-spacing: 1px;}
</style>
<object id="jatoolsPrinter" classid="CLSID:B43D3361-D975-4BE2-87FE-057188254255" codebase="jatoolsP.cab#version=1,2,0,5"></object>
<script language="javascript" type="text/javascript">

<!--
function loadyanzhengma()
  {
	  if($("#xingchengdanhao").val()!="" && $("#xingchengdanhao").val()!="请填写行程单号" && $("#xingchengdanhao").val().length>=4)
	  {
	     $("#yanzhengma").html($("#xingchengdanhao").val().substring($("#xingchengdanhao").val().length-4,$("#xingchengdanhao").val().length));
	  }
  }
function checkdata1()
{
   doPrint('打印预览...');
}
function accountprice()
{
  var totalprice=0;
  var ticketprice=0;
  ticketprice=parseInt($("#txtpiaomianjia").val());
  var airportfee=0;
  airportfee=parseInt($("#airportfee").val());
  var fuelfee=0;
  fuelfee=parseInt($("#fuelfee").val());
  totalprice=ticketprice+airportfee+fuelfee;
  $("#totalprice").val(totalprice);
}
function clearxingchengdan()
{
    if($("#xingchengdanhao").val()=="请填写行程单号")
    {
       $("#xingchengdanhao").val("");
       $("#xingchengdanhao").focus();
    }
}
function doPrint(how)
{
   $("#xingchengdanhao").hide();
  if(typeof(jatoolsPrinter.page_div_prefix)=='undefined'){
        alert("请按页顶上的黄色提示下载ActiveX控件.如果没有提示请按以下步骤设置ie.\n 工具-> internet 选项->安全->自定义级别,设置 ‘下载未签名的 ActiveX ’为'启用'状态")
        return ;
    }
	//打印文档对象
    var myreport ={ 
    				documents: document,    // 打印页面(div)们在本文档中
    				copyrights  :    '杰创软件拥有版权 www.jatools.com'         // 版权声明必须
    			  };
    			  
    // 调用打印方法
    if(how == '打印预览...')
    	jatoolsPrinter.printPreview(myreport );   // 打印预览
                 
   	else if(how == '打印...')
   		jatoolsPrinter.print(myreport ,true);   // 打印前弹出打印设置对话框
                
   	else
   		jatoolsPrinter.print(myreport ,false);       // 不弹出对话框打印
}


-->
  
 
</script> 
</head>
<body ondragstart= "return false" onselectstart= "return false" onload="loadyanzhengma();">
    <form id="form1" runat="server">
    <div>
<div style="margin:0px auto;background-color:#808080;width:810px;height:400px;overflow:scroll;padding:5px;clear:both">
  <div class="pb"  >
    <div id="page1">
      <div class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)"><span class="jnc" style="left:0; top:0;clip:rect(0,783,380,0)">&nbsp;</span></span></span></span></span></span></div>
      <div class="jc" style="left: 72px;top: 73px;width:150px;">
          <ww:property value="passenger.name" /></div>
      <div class="jc4" style="left: 205px;top: 73px;width:195px;FONT-SIZE:16pt;font:TEE; ">
         <ww:property value="passenger.idnumber" /></div>
      <div class="jc" style="left: 475px;top: 74px;width:100%;">
      		<input type="text" id="page1qaindanlan" value='<ww:property value="passenger.ei" />' style="left:476px;border:0px;"/>
          <!--<ww:property value="passenger.ei" />-->
          </div>
          <!-- 印刷序列号 -->
       <div class="jc" style="left: 605px;top:34px;width:100%">
       <input  type="text" id="xingchengdanhao" value="<ww:if test="passengerXingchengdan!=null"><ww:property value="passengerXingchengdan" /></ww:if><ww:else>请填写行程单号</ww:else>" style="border:0;background-color:transparent;font:TEE" onfocus="clearxingchengdan();" onblur="getyanzhengma();"/>
       </div>
      <!-- 印刷序列号 -->
      <div class="jc1" style="left: 72px;	top: 101px;FONT-SIZE:16pt;font:TEE;">
         <ww:property value="orderinfo.pnr" /></div>
      <div class="jc2" style="left: 122px;	top: 138px;">
          <ww:property value="segmentinfo.startairport" /></div>
      <div class="jc2" style="left: 122px;	top: 170px;">
         <ww:property value="segmentinfo.endairport" /></div>
      <div class="jc3" style="left: 61px;top: 139px;FONT-SIZE:16pt;width:70px; font:TEE"> 
          <ww:property value="getname(segmentinfo.startairport)" /></div>
      <div class="jc3" style="left: 61px;top: 171px;FONT-SIZE:16pt;width:70px;font:TEE">
         <ww:property value="getname(segmentinfo.endairport)" /></div>
      <div class="jc3" style="left: 191px;top: 139px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="getAircomapnycodeByEZM(segmentinfo.aircomapnycode)" /></div>
	  <div class="jc3" style="left: 191px;top: 171px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="airway1" runat="server"></asp:Label><!-- 航2 --></div>
      <div class="jc3" style="left: 230px;top: 139px;width:61px;FONT-SIZE:16pt;font:TEE;letter-spacing:0px">
          <ww:property value="segmentinfo.flightnumber" /></div>
      <div class="jc3" style="left: 236px;top: 171px;width:60px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="hangban1" runat="server"></asp:Label><!-- 航班号2 --></div>
      <div class="jc3" style="left: 301px;top: 139px;width:20px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="segmentinfo.cabincode" /></div>
	  <div class="jc3" style="left: 301px;top: 171px;width:20px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="berth1" runat="server" ></asp:Label><!-- 舱位码2 --></div>
      <div class="jc4" style="left: 333px;top: 139px;width:52px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="ChangeDateMode(formatTimestamp2(segmentinfo.departtime))" /></div>
	  <div class="jc4" style="left: 333px;top: 171px;width:52px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="datefly1" runat="server" ></asp:Label><!-- 起飞日期2 --></div>
      <div class="jc4" style="left: 387px;top: 139px;width:52px;FONT-SIZE:16pt;font:TEE">
      	<ww:property value="formatTimestampToHm(segmentinfo.departtime)" /><!-- 起飞时间点 如 8:00 -->
      </div>
      <div class="jc4" style="left:440px;top: 139px;width:142px;FONT-SIZE:16pt;font:TEE">
          <!--<input type="text" id="ticketType" style="width:100%;height:86px;" /> --><!-- 客票类别，客票级别 -->
          <textarea id="ticketType" cols="18" rows="6" style="width:100%;height:102px;overflow:hidden;border:0px;" class="textareacls"></textarea></div>
      <div class="jc4" style="left: 593px;top: 139px;width:52px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="ChangeDateMode(formatTimestamp2(segmentinfo.departtime))" /><!--生效日期1 --></div>
      <div class="jc4" style="left: 593px;top: 171px;width:52px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="sx1" runat="server"></asp:Label><!--生效日期2 --></div>
      <div class="jc4" style="left: 653px;top: 139px;width:52px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="jz0" runat="server"></asp:Label><!-- 截止日期1 --></div>
      <div class="jc4" style="left: 653px;top: 171px;width:52px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="jz1" runat="server"></asp:Label><!-- 截止日期2 --></div>
      <div class="jc4" style="left: 608px;top: 28px;width:174px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="sn" runat="server" Width="108px" Visible="False"></asp:Label>
          <asp:Label ID="sns" runat="server" Width="12px" Visible="False"></asp:Label></div>
      <div class="jc4" style="left: 653px;top: 41px;width:12px;FONT-SIZE:16pt;font:TEE">
          </div>


      <div class="jc3" style="left: 390px;top: 139px;width:40px;FONT-SIZE:16pt;font:TEE">
          <ww:property value="getFdate(formatTimestamp3(segmentinfo.departtime))" /></div>
	  <div class="jc3" style="left: 390px;top: 171px;width:40px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="flytime1" runat="server" ></asp:Label><!-- 起飞时间2 --></div>
      <div class="jc3" style="left: 721px;top: 139px;width:60px;FONT-SIZE:16pt;font:TEE">
          20k<!-- 行李重1 --></div>
	  
	  <div class="jc3" style="left: 721px;top: 171px;width:60px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="xingli1" runat="server" ></asp:Label><!-- 行李重2 --></div>
	  
	  
      <div class="jc" style="left: 451px;top: 139px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="level0" runat="server"ww></asp:Label></div>
	  <div class="jc" style="left: 451px;top: 171px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="level1" runat="server" ></asp:Label></div>
	
      <div class="jc1" style="left: 71px;	top: 200px;FONT-SIZE:16pt;font:TEE">
          <asp:Label ID="shuntair" runat="server"></asp:Label></div>
	 
	  <div class="jc2" style="left: 71px;	top: 200px;"></div>
	  <div class="jc3" style="left: 105px;top: 200px;FONT-SIZE:16pt;width:70px;font:TEE">
          <asp:Label ID="shuntaircode" runat="server"></asp:Label></div>
      <div class="jc3" style="left: 186px;top: 261px;width:135px;FONT-SIZE:16pt;font:TEE;word-spacing:1px; letter-spacing: 1px;"><!-- <ww:property value="passenger.price" /> -->
          CNY<ww:property value="passangerPrice" /><!-- <input type="text" onblur="accountprice();" id="txtpiaomianjia" value='<ww:property value="passangerPrice" />' ReadOnly='readonly' style="border:0;background-color:transparent;width:60px;font:TEE;" /> --><!-- 票面价 -->
          <asp:Label ID="Label18" runat="server" ></asp:Label></div>
      <div class="jc3" style="left: 285px;top: 263px;width:125px;FONT-SIZE:16pt;font:TEE">&nbsp;
      <ww:if test="passenger.airportfee==null">
          CN<input type="text"  value='0.00' onblur="accountprice();" id="airportfee" ReadOnly='readonly' style="border:0;background-color:transparent;width:40px;font:TEE" /><!-- 机建费 -->&nbsp;
          </ww:if>
          <ww:else>
          CN<ww:property value="passangerAirportfee" /><!-- <input type="text" id="airportfee" onblur="accountprice();"  value='<ww:property value="passangerAirportfee" />' ReadOnly='readonly' style="border:0;background-color:transparent;width:40px;font:TEE" /> --><!--基建费YQ-->
          </ww:else>
	</div>
      <div class="jc3" style="left: 395px;top: 263px;width:125px;FONT-SIZE:16pt;font:TEE">
          <ww:if test="passenger.fuelprice==null">
          YQ<input type="text"  id="fuelfee" onblur="accountprice();" value='0.00' ReadOnly='readonly' style="border:0;background-color:transparent;width:40px;font:TEE" /><!-- 燃油费 -->&nbsp;
          </ww:if>
          <ww:else>
          YQ<ww:property value="passangerFuelprice" /><!-- <input type="text" id="fuelfee" onblur="accountprice();" value='<ww:property value="passangerFuelprice" />' ReadOnly='readonly' style="border:0;background-color:transparent;width:60px;font:TEE" /> --><!-- 燃油费 -->&nbsp;
          </ww:else>
          </div>
      <div class="jc3" style="left: 609px;top: 259px;width:151px;FONT-SIZE:16pt;font:TEE">
          CNY<ww:property value="passangerTotalfuelfee" /><!-- <input type="text" id="totalprice" value='<ww:property value="passangerTotalfuelfee" />' ReadOnly='readonly' style="border:0;background-color:transparent;width:80px;font:TEE" /> --><!-- 总价格 --></div>
      <div class="jc4" style="left: 90px;top: 285px;width:175px;FONT-SIZE:16pt;font:TEE">
          <input type="text"  value='<ww:property value="passenger.ticketnum" />' style="border:0;background-color:transparent;width:150px;font:TEE" /><!-- 电子客票号 --></div>
      <div id="yanzhengma" class="jc3" style="left: 277px;top: 285px;width:40px;FONT-SIZE:16pt;font:TEE;letter-spacing:0px">
          <!-- 验证码 --></div>
	  <div class="jc3" style="left: 700px;top:285px; <!-- 281px; --> width:40px;FONT-SIZE:16pt;font:TEE;letter-spacing:0px">XXX</div>
      <div class="jc4" style="left: 89px;top: 315px;width:175px;FONT-SIZE:16pt;font:TEE" id="ComCode" ><input type="text" value="PEK275c"  style="border:0;background-color:transparent;font:TEE" /><asp:Label ID="agent_symble" runat="server" ></asp:Label></div>
      <div class="jc4" style="left: 90px;top: 329px;width:175px;FONT-SIZE:16pt;font:TEE" id="AgentCode"><input type="text" value="08311634"  style="border:0;background-color:transparent;font:TEE" /><asp:Label ID="agent_code" runat="server" ></asp:Label></div>
      <div class="jc4" style="left: 637px;top: 318px;width:175px;FONT-SIZE:16pt;font:TEE">
	    <%
	 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	 	%>
          <%=dateFormat.format(new Timestamp(System.currentTimeMillis()).getTime()) %></div>
      <div class="jc" style="left: 289px;top: 320px;width:235px"><input type="text" value="北京棨德龙航空服务有限公司"  style="border:0;background-color:transparent;font:TEE" /></div>
    </div>
  </div>
</div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="35" align="center"><input name="button" type="button"  id="PrintGo"  onclick="return checkdata1();" value="打印预览..." />&nbsp;
            &nbsp;<input name="button" type="button"  id="Button1"  onclick="history.back(-1);" value="返回上一页..." /></td>
      </tr>
    </table>
    </div>
      <asp:HiddenField ID="HfRRTime" runat="server" />
</form>

<script>
function getyanzhengma()
{
  if($("#xingchengdanhao").val()!="" && $("#xingchengdanhao").val()!="请填写行程单号" && $("#xingchengdanhao").val().length>=4)
  {
     $("#yanzhengma").html($("#xingchengdanhao").val().substring($("#xingchengdanhao").val().length-4,$("#xingchengdanhao").val().length));
  }
}
</script>
</body>
</html>
