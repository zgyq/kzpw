<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2009
	 *
	 *
	 *  HISTORY
	 *  
	 *  2009/08/14 创建
	 *
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店订单详细页面</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}

.STYLE3 {
	color: #000000
}
-->
</style>


<style type="text/css">
.container {
	width: 400px;
	padding-top: 5px;
	margin: 3px 0 0px 0;
	border: 1px solid #ccc;
	background: #fff;
}

/* square */
#navSquare {
	margin: 0;
	padding: 0 0 20px 10px;
	border-bottom: 1px solid #9FB1BC;
}

#navSquare li {
	margin: 0;
	padding: 0;
	display: inline;
	list-style-type: none;
}

#navSquare a:link,#navSquare a:visited {
	float: left;
	font-size: 10px;
	line-height: 14px;
	font-weight: bold;
	padding: 0 12px 6px 12px;
	text-decoration: none;
	color: #708491;
}

#navSquare a:link .active,#navSquare a:visited .active,#navSquare a:hover
	{
	background: url(../images/Square.gif) no-repeat bottom center;
	color: #000;
}
</style>
</head>
<link href="../css/base.css" rel="stylesheet" />
<link href="../style/CommonX.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/validator.js"></script>

<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/util.js"></script>

<script>
  function showsms()
  {
      document.getElementById("framemsg").style.display="block";
      document.getElementById("framefax").style.display="none";
      document.getElementById("container").style.display="none";
       $("#litab2").addClass("active");
     $("#litab1").removeClass("active");
     $("#litab3").removeClass("active");
  }
  function showfax()
  {
      document.getElementById("framefax").style.display="block";
      document.getElementById("container").style.display="none";
      document.getElementById("framemsg").style.display="none";
       $("#litab3").addClass("active");
     $("#litab2").removeClass("active");
     $("#litab1").removeClass("active");
  }
  function showinfo(index)
  {
     var url='hotelwholeorder!todetails.action?ordid='+index;
     window.location.href=url;
     $("#litab1").addClass("active");
     $("#litab2").removeClass("active");
     $("#litab3").removeClass("active");
  }
</script>
<body>
<div>
<form action="hotelwholeorder!editguest.action"	name="form1" id="form1" method="POST" >


<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店订单详细信息--夜审</span></td>
	</tr>

	<tr height="20px">
		<td></td>
	</tr>
	<tr>
		<td height="100%" align="center">
		<table width="200" border="0" cellpadding="0" cellspacing="0"
			style="border: 0px solid #99CBED;">

			<tr>
				<td>
				<div class="container">
				<ul id="navSquare">
					<!-- CSS Tabs -->
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					
					<!--<li><a href="#" id="litab2" onclick="showsms();">相关短信</a></li>
					<ww:if test="hotelorder.state==3">
						<li><a href="#" id="litab3" onclick="showfax();">相关传真</a></li>
					</ww:if>

				--></ul>
				</div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr id="container">
		<td height="100%" align="center">
		<table width="90%" cellpadding="0" cellspacing="0" border="1"
			bordercolor="#a0cfee" style="border-collapse: collapse">

			<tr class="font-blue-xi">
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>订单号</strong>：</span></td>
				<td width="35%" align="left" style="font-weight: bold"><ww:property
					value="hotelorder.orderid" /></td>

				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>订单状态</strong>：</span></td>
				<td width="35%" align="left" style="color: red; font-weight: bold">
				<ww:if test="hotelorder.state==1">待确认</ww:if> <ww:if
					test="hotelorder.state==2">已处理</ww:if> <ww:if
					test="hotelorder.state==3">已发传真</ww:if> <ww:if
					test="hotelorder.state==4">已回传确认</ww:if> <ww:if
					test="hotelorder.state==5">预订完成</ww:if> <ww:if
					test="hotelorder.state==6">已取消订单</ww:if> <ww:if
					test="hotelorder.state==7">满房</ww:if> <ww:if
					test="hotelorder.state==8">变更</ww:if> <ww:if
					test="hotelorder.state==9">入住</ww:if> <ww:if
					test="hotelorder.state==10">NS</ww:if> <ww:if
					test="hotelorder.state==11"></ww:if> <ww:if
					test="hotelorder.state==12">已付款</ww:if> <ww:if
					test="hotelorder.state==13">已支付给酒店</ww:if> <ww:if
					test="hotelorder.state==14">交易完成</ww:if> <ww:if
					test="hotelorder.state==18">预订完成,等待付款</ww:if>
					<ww:if test="hotelorder.state==88">问题订单</ww:if>
					
					</td>
			</tr>
			<tr>
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>创建时间</strong>：</span></td>
				<td width="35%" align="left"><ww:property
					value="formatTimestamp(hotelorder.pretime)" /></td>
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>审核类型</strong>：</span></td>
				<td width="35%" align="left"><ww:if
					test="hotelorder.checktype==1">日审</ww:if><ww:if
					test="hotelorder.checktype==2">夜审</ww:if></td>
			</tr>
			<tr>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>联系人姓名</strong>：</span></td>
				<td align="left"><ww:property value="hotelorder.linkname" /></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>联系人手机</strong>：</span></td>
				<td align="left"><ww:property value="hotelorder.linkmobile" /></td>
			</tr>

			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>联系人Email</strong>：</span></td>
				<td align="left"><ww:if test="hotelorder.linkmail!=null">
					<ww:property value="hotelorder.linkmail" />
				</ww:if><ww:else>无</ww:else></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>联系人电话</strong>：</span></td>
				<td align="left"><ww:if test="hotelorder.linktell!=null">
					<ww:property value="hotelorder.linktell" />
				</ww:if><ww:else>无</ww:else></td>
			</tr>
			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>特殊要求</strong>：</span></td>
				<td colspan="3" align="left"><ww:if test="hotelorder.specreq">
					<ww:property value="hotelorder.specreq" />
				</ww:if><ww:else>无特殊要求</ww:else></td>
			</tr>

			<tr class="font-blue-xi">
				<td width="15%" height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店名称</strong>：</span></td>
				<td width="35%" align="left"><ww:property
					value="hotelorder.name" /></td>

				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店地址</strong>：</span></td>
				<td align="left"><ww:property value="hotel.address" /></td>

			</tr>
			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店电话</strong>：</span></td>
				<td align="left"><ww:if test="hotel.tortell!=null">
					<ww:property value="hotel.tortell" />
				</ww:if><ww:else>暂无信息</ww:else></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>酒店传真</strong>：</span></td>
				<td align="left"><ww:if test="hotel.faxdesc!=null">
					<ww:property value="hotel.faxdesc" />
				</ww:if><ww:else>暂无信息</ww:else></td>
			</tr>


			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>预订间数</strong>：</span></td>
				<td align="left"><ww:property value="hotelorder.prerooms" /></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>入住人</strong>：</span></td>
				<td align="left"><ww:iterator
					value="getGuestByOrderId(hotelorder.id)" status="guessStatus">
					<ww:property value="name" />
					<ww:if test="!#guessStatus.last">，</ww:if>
				</ww:iterator></td>
			</tr>

			<tr class="font-blue-xi">
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>入住日期</strong>：</span></td>
				<td align="left"><ww:property
					value="formatDate(hotelorder.comedate)" /></td>
				<td height="28" align="right" class="level3_textright"><span
					class="STYLE2"><strong>离店日期</strong>：</span></td>
				<td align="left"><ww:property
					value="formatDate(hotelorder.leavedate)" /></td>
			</tr>
			

			<tr>
				<td colspan="4">
				<table width="100%" border="1" cellpadding="0" cellspacing="0"
					bordercolor="#a0cfee" style="border-collapse: collapse">
					<tr>
						<th width="20%" align="center">房型</th>
						<th width="60%" align="center">每日价</th>
						<th width="20%" align="center">床型</th>
					</tr>
					<tr>
						<td align="center"><ww:property
							value="hotelorder.roomtypename" /></td>
						<td align="center">
						<table width="100%">
							<tr>
								<ww:property value="hotelorder.dayprice" />
							</tr>
						</table>
						</td>
						<td align="center"><ww:if
							test="getRoomtypeById(hotelorder.roomid).bed == 1">单人床</ww:if> <ww:elseif
							test="getRoomtypeById(hotelorder.roomid).bed == 2">大床</ww:elseif>
						<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 3">双床</ww:elseif>
						<ww:elseif test="getRoomtypeById(hotelorder.roomid).bed == 4">大或双</ww:elseif>
						<ww:else>其他</ww:else></td>
					</tr>
				</table>
				</td>
			</tr>


			<tr class="font-blue-xi">
				<td align="right" height="28" class="level3_textright"><strong>总计金额</strong>：</td>
				<td align="left"><span style="color: red; font-weight: bold"><ww:property
					value="hotelorder.price" /></span></td>
				<td align="right" class="level3_textright"><strong>付款方式</strong>：</td>
				<td align="left"><ww:if test="hotelorder.paytype==1">前台现付</ww:if><ww:else>预付</ww:else></td>
			</tr>

			</table>
		</td>
	</tr>

</table>
<div>&nbsp;</div>

<table width="95%" border="1" align="center" bordercolor="#a0cfee"
	style="border-collapse: collapse ; margin: 0 auto;">
	<tbody>
		<tr bgcolor="#d7e9fc">

			<th width="54" height="25"><input type="checkbox" name="all1"
				value="1" onclick="selectall1()" />全选</th>

			<th>ID</th>
			<th>客人名称</th>
			<th>入住日期</th>
			<th>离店日期</th>
			<th>实际离店日期</th>
			<!--<th>每日价格</th>
			--><th>状态</th>


		</tr>

		<ww:iterator value="listGuest">
			<tr align="center"
				onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
				onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

				<td><input type="checkbox" name="guestid"
					value="<ww:property value="id"/>" /></td>


				<td><ww:property value="id" /></td>
				<td><ww:property value="name" /></td>
				<td><ww:property value="ruzhutime" /></td>
				<td><ww:property value="likaitime" /></td>
				<td><ww:property value="shijitime" /></td>
				<!--
				<td><ww:property value="price" /></td>
				-->
				<td>
				<ww:if test="state==1">正常</ww:if>
				<ww:if test="state==2">提前离店</ww:if>
				<ww:if test="state==3">延住</ww:if>
				<ww:if test="state==4">取消</ww:if>
				</td>


			</tr>
		</ww:iterator>

	</tbody>
</table>
<div style="height: 50px;line-height:40px; text-align: center;">
<input type="radio"  name="ty" value="1" checked="checked" onclick="chec(1)" />
<span class="STYLE2"><strong>正常离店</strong></span>

<input type="radio" id="ty3"  name="ty" value="3" onclick="chec(3)" /><span class="STYLE2"><strong>延住</strong></span>
<input type="radio" id="ty2"  name="ty" value="2" onclick="chec(2)" /><span class="STYLE2"><strong>提前离店</strong></span>
<input type="radio"  name="ty" value="4" onclick="chec(4)" /><span class="STYLE2"><strong>取消</strong></span>
<input type="hidden" id="hi"  name="" value="0"  />
</div>	
<div id="hidtime" style="display: none;"> <span class="STYLE2"><strong>实际离店日期:</strong></span><input id="h_prestarttime"  style="WIDTH: 181px" name="h_prestarttime" value="<ww:property value="h_prestarttime"/>" onfocus="WdatePicker({skin:'whyGreen'})"/></div>						
<div style="height: 100px;line-height:40px; text-align: center;"> 
<input type="button" onclick="sub();" class="button_d font-white" id="btnCancel" value="提  交"  /> </div>		
</form>
<iframe id="framemsg" name="framemsg" style="display: none"
	frameborder="0" width="100%" height="800px" scrolling="auto"
	src="../ymsend.action?s_name=<ww:property
					value="hotelorder.orderid" />"></iframe>

<iframe id="framefax" name="framefax" style="display: none"
	frameborder="0" width="100%" height="800px" scrolling="auto"
	src="hotelfax/hotelfax<ww:property
					value="hotelorder.orderid" />.html"></iframe>
</div>

</body>

<script type="text/javascript">
	function hotel_show_noauditingreason() {
		document.getElementById('cancelreasonTr').style.display='';
	}
	function hotel_hide_noauditingreason() {
		document.getElementById('cancelreasonTr').style.display='none';
	}
	function chuanzhen(sta,hid) {
		//alert("sta=="+sta+"....hid="+hid);
		document.forms.form1.action="hotelwholeorder!tochuanzhen.action?sta="+sta+"&ordid="+<ww:property value="hotelorder.id"/>;
		document.forms.form1.submit() ;
	}
	function hotel_cannel_info(st) {
		document.forms.form1.action="hotelwholeorder!check.action?sta="+st+"&ordid="+<ww:property value="hotelorder.id"/>;
		document.forms.form1.submit() ;
	}
	function checkyufu(st) {
		document.forms.form1.action="hotelwholeorder!checkyufu.action?typ="+st+"&ordid="+<ww:property value="hotelorder.id"/>;
		document.forms.form1.submit() ;
	}
	
	function hotel_hui(st) {
		document.forms.form1.action="hotelwholeorder!checkhui.action?hui="+st+"&ordid="+<ww:property value="hotelorder.id"/>;
		document.forms.form1.submit() ;
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
function chec(id)
{
	if(id==2||id==3){
	document.getElementById("hidtime").style.display="block";
	document.getElementById("hi").value=1;
	
	}else{
	document.getElementById("h_prestarttime").value="";
	document.getElementById("hidtime").style.display="none";
	document.getElementById("hi").value=0;
	}
	
	}
	
	function sub(){

	var flag=0;
        for(i=0;i<$(":checkbox:checked").length;i++)
        if($(":checkbox:checked").get(0).checked=true){
            flag=1;
            break;
        }
        if(!flag){
             alert("你还没选择入住人!");    
            return false
        }else{
        
	        	
	    
	        	if(document.getElementById("hi").value==1){
	        	
	        	
	        		if(document.getElementById("h_prestarttime").value==''){
	        		alert("时间不能为空!");
	        		  return false
	        		}else{
	        		 document.form1.submit();
	        		}
	        	}else{
	        	 	document.form1.submit();
	        	}
	      
      
        }


}
</script>
</html>


