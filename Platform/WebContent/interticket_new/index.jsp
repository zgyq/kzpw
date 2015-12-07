<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>国际机票查询</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<style>
td {
	padding-left: 3px;
}
</style>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
	
	
<script src="interjs/interaircity2.js" type=text/javascript></script>
<script src="interjs/popdg_div.js" type=text/javascript></script>
<script src="interjs/popdg_div_gj.js" type=text/javascript></script>
<script src="interjs/city.js" type=text/javascript></script>
<link rel=stylesheet type=text/css href="interjs/city.css" />	
<link rel=stylesheet type=text/css href="interjs/citycontrol.css" />		
<link rel=stylesheet type=text/css href="interjs/base.css" />	
	
	

<script type="text/javascript"> 

	  
//txtStartDate
	  

function getDateyyyyMMdd(num) {

    var d = new Date();
    d.setDate(d.getDate() + num);
    var y = d.getFullYear();
    var m = d.getMonth() + 1;
    if (m < 10) {
        m = '0' + m;
    }
    var d = d.getDate();
    if (d < 10) {
        d = '0' + d;
    }
    var str = y + '-' + m + '-' + d;
    return str;
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
function selectTripType(val){
	switch(val){
		case 0:
			$('#returnDateWrapper,#dc,#tjxc').hide();
			$('#wf').show();
			break;
		case 1:
			$('#returnDateWrapper,#wf').show();
			$('#dc,#tjxc').hide();
			break;
		case 2:
			$('#returnDateWrapper,#wf').hide();
			$('#dc,#tjxc').show();
			break;
	}
}
function CheckData()
    {
    //alert("?");
        //var rdoFrom=document.getElementById("tripTyperound");
       // var rdoOnlone=document.getElementById("tripTypesingle");
        //alert("1");
        if($("#hideFromCityCode").val()=="" || $("#fromCity").val()=="" || $("#fromCity").val()=="中文/拼音")//中文/拼音
        {
            alert("出发城市为必填项,请检查后重新填写！");
            $("#fromCity").focus();
            return ;
        }
        if($("#arrCity").val()=="中文/拼音"||$("#hideArrCityCode").val()=="" || $("#arrCity").val()=="")
        {
            alert("到达城市为必填项,请检查后重新填写！");
            $("#arrCity").focus();
            return ; 
        }
        if($("#txtStartDate").val()=="")
        {
           alert("出发日期为必填项,请检查后重新填写！");
           $("#txtStartDate").focus();
           return ;
        }
        if(rdoFrom.checked==true && $("#txtBackDate").val()=="")
        {
            alert("返程时间不能为空！");
            $("#txtBackDate").focus();
            return ;
        }
        else if(Computation($("#txtStartDate").val(),$("#txtBackDate").val())>0)
        {
             alert("返程日期不能早于出发日期,请检查后重新填写！");
             $("#txtBackDate").focus();
             return ; 
         }
         
         if(!IsNumber($("#adultCount").val()))
         {
             alert("乘客人数只能是数字，请检查后重新填写!");
             $("#adultCount").focus();
             return ; 
         }
         
         dispose("正在查询国际航班");
         document.form1.submit();
        
    }
function  subseach(){
 if($("#txtStartDate").val()=="")
        {
           alert("出发日期为必填项,请检查后重新填写！");
           $("#txtStartDate").focus();
           return ;
        }
        
 dispose("正在查询国际航班");
         document.form1.submit();

}
</script>

</head>

<body id="mainbody">
<form action="interticket!search.action" name="form1" id="form1"
	method="POST">
<div >
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;国际机票查询</b></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left"><input type="hidden" id="maxSegId"
							name="maxSegId" value="0" />

						<div class="main_right">
						<h3><span class="num">1</span>选择航班类型</h3>
						<ul>
							<li class="wfli"><input name="intTravelType" id="tripTypesingle"
								type="radio" value="1" onclick="selectTripType(0)"
								checked="checked" /> 单程</li>
							<li class="wfli"><input name="intTravelType" id="tripTyperound" disabled="disabled"
								type="radio" value="2" onclick="selectTripType(1)" /> 往返</li>
							<!--<li><input name="tripType" type="radio" value="2" onclick="selectTripType(2)" /> 多程（含联程）</li>  -->
						</ul>
						<div class="clear"></div>
						<div class="ff_subline"></div>

						<h3><span class="num">2</span>选择出发到达城市及时间<span class="yiqian"
							id="tjxc" style="display: none;">行程数：<select
							onchange="modifyTripCount(this.value)">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3" selected="selected">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
						</select></span></h3>
						<ul id="wf">
							<li class="wfli">出发城市： <input type="text" 
								name="fromCity" 
								id="fromCity"
								onkeydown="popup_hidegj();suggestgj.display('fromCity','hideFromCityCode',event);"
								onblur="showSearch(id,1);"
								onfocus="popUpgj('fromCity','hideFromCityCode')"
								onclick="popUpgj('fromCity','hideFromCityCode')"
								style="border: 1px solid #999999; height: 20px; line-height: 20px;"
								autocomplete="off" value="北京" />
							<input type="text" id="hideFromCityCode" value="BJS"
								name="StartAirportCode" /></li>
								
							<li class="wfli">到达城市： <input type="text" name="toCity" value="香港"
								id="arrCity"
								onkeydown="popup_hidegj();suggestgj.display('arrCity','hideArrCityCode',event);"
								onblur="showSearch(id,1);"
								onfocus="popUpgj('arrCity','hideArrCityCode')"
								onclick="popUpgj('arrCity','hideArrCityCode')"
								style="border: 1px solid #999999; height: 20px; line-height: 20px;"
								autocomplete="off" />
							<input type="hidden" id="hideArrCityCode" name="EndAirportCode" value="HKG" />

							</li>
							<li class="wfli">出发时间：&nbsp;<input id="txtStartDate"
								name="fromDate"
								onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
								class="Wdate"
								style="border: 1px solid #999999; height: 20px; line-height: 20px;"
								type="text"  /></li>
							<li id="returnDateWrapper" class="wfli" style="display: block">返回时间：&nbsp;
							<input type="text"
								onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
								class="Wdate"
								style="border: 1px solid #999999; height: 20px; line-height: 20px;"
								id="txtBackDate" name="returnDate" value="" /></li>
						</ul>
						<div class="clear"></div>
						<div id="dc" class="duoc" style="display: none"></div>
						<div class="clear"></div>
						<div class="ff_subline"></div>

						<h3><span class="num">3</span>更多条件</h3>
						<ul class="more">
						<li style="width: 240px">中转类型：<select name="TypeFlag"
								style="width: 150px;">
								<option value="0" selected="selected">所有</option>
								<option value="1">直飞</option>
								<option value="2">中转</option>
							</select></li>
							<li style="width: 240px">乘客类型：<select name="passengerType"
								style="width: 150px;">
								<option value="0" selected="selected">成人</option>
								<option value="1">留学生</option>
							</select></li>
							<li style="width: 240px">乘客人数：<input type="text"
								id="adultCount" name="adultCount" value="1" />
							</li>
							<li style="width: 350px">舱位等级： <span><input
								name="seatType" type="radio" value="Y" checked="checked" />经济舱</span>
							<span><input name="seatType" type="radio" value="C" />商务舱</span>
							<span><input name="seatType" type="radio" value="F" />头等舱</span>
							</li>
						</ul>
						<div class="clear"></div>
						<div class="ff_subline"></div>
						</td>
						<td width="200px">&nbsp;</td>
					</tr>
					<tr>
						<td height="20px"></td>
					</tr>
					<tr>
						<td align="center"><input type="button" onclick="subseach();"
							style="background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
							value="查&nbsp;&nbsp;询" /></td>
					</tr>
					
					<tr>
						<td>
						<table>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span
									style="color: Red">注意事项:</span></strong></td>
							</tr>
							<tr>
								<td>
								<ul>
									<li id="li1" style="list-style: none;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span
										id="Label1">此处结算价仅供参考，实际价格以订单支付页面为准！</span></li>
								</ul>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td><br />
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<input type="hidden" name="s_seachtype" id="s_seachtype" value="0" />

</form>
</body>
</html>
<script type="text/javascript">
$('#txtStartDate').val(getDateyyyyMMdd(4));
</script>