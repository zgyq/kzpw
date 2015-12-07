
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: B2B2C 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><ww:if test="buying
		.id>0">编辑</ww:if><ww:else>新增</ww:else>团购信息
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jtbceditor/jtbceditor.js"></script>
<script language="javascript" type="text/javascript"
	src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript"
	src="js/hotel/city_date2.js"></script>
</head>
<script type="text/javascript">
var varAddress="";
$(document).ready(function(){
  loadCityData();


});
function loadCityData()
{

 $.ajax({
       type:"POST",
       url:"spotticket!GetSpotCity.action",
       async:false,     
       success:function(data)
       {    
         varAddress=data;
       }            
  });
 // alert(varAddress);
}

function getDateDiff(date, num){
	var d1 = new Date(eval(date.substring(0, 4)), eval(date.substring(5, 7)) - 1, eval(date.substring(8, 10)));
	num = (typeof(num)=='undefined')?0:num;
	var d2 = new Date(d1.valueOf() + (num*86400000));
    var yy = d2.getFullYear(); 
    var mm = d2.getMonth() + 1; 
    var dd = d2.getDate(); 
    return yy + "-" + getmyselfDate(mm) + "-" + getmyselfDate(dd);
}
function getmyselfDate(a){
    if (a < 10) {
        return "0" + a;
    }
    return a;
}
</script>
<body>
<div id="member">
<form
	action="buying
		!<ww:if test="buying
		.id>0">edit.action?id=<ww:property value="buying
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="buying
		.id>0">编辑</ww:if><ww:else>新增</ww:else>团购信息 </span></b></td>
	</tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">




				<tr style="display: none">
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">外部id :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="outid
						"
						value='<ww:property value="buying.outid"/>' " style="width: 300px" />
					</td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">供应商ID :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="agentid
						"
						value='<ww:property value="buying.agentid
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<tr style="display: none">
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">省ID :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="pid
						"
						value='<ww:property value="buying.pid"/>' " style="width: 300px" />
					</td>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">区ID :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="regionid
						"
						value='<ww:property value="buying.regionid"/>'
						" style="width: 300px" /></td>



				</tr>



				<tr>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">城市 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					
					<input type="text" id="txthotelcity" name="hotelcity" value="<ww:property value="getSpotCityNameByStr(buying.cityid)" />"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); "  />
					<div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="cityid" value="<ww:property value="buying.cityid" />" 
						</td>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">名称 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="name
						"
						value='<ww:property value="buying.name
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">门市价格 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="marketprice
						"
						value='<ww:property value="buying.marketprice"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">团购价格 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="shopprice
						"
						value='<ww:property value="buying.shopprice
						"/>'
						" style="width: 300px" /></td>
				</tr>



				
				


				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">预约天数 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="tiqiandays
						"
						value='<ww:property value="buying.tiqiandays"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">地址 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="address
						"
						value='<ww:property value="buying.address
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">开始日期 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" id="txtcheckindate" name="stime
						"
						value='<ww:property value="buying.stime"/>' " class="Wdate"
						style="width: 300px"
						onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){txtcheckoutdate.focus();}})" />
					</td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">结束日期 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" id="txtcheckoutdate" class="Wdate"
						name="endtime
						"
						value='<ww:property value="buying.endtime
						"/>'
						" style="width: 300px"
						onfocus="this.value=getDateDiff($('#txtcheckindate').val(),4);WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'txtcheckindate\',{d:1}) || \'%y-%M-#{%d+1 }\'}'})" />
					</td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">时间范围 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l"
						colspan="3"><input type="text" name="stimeetime
						"
						value='<ww:property value="buying.stimeetime"/>'
						" style="width: 300px" /> (例如:08:00-24:00;)</td>




				</tr>
				

				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">起订数 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="minnumber
						"
						value='<ww:property value="buying.minnumber"/>'
						" style="width: 300px" /> (最少预订数,默认为1)</td>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">类型 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<select name="type">
						<option value="1" <ww:if test="buying.type==1">selected</ww:if>>餐饮</option>
						<option value="2" <ww:if test="buying.type==2">selected</ww:if>>购物</option>
					</select> <!--<input type="text"  name="type
						" value='<ww:property value="buying.type
						"/>'" style="width: 300px" />
				--></td>


				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">详细信息 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l"
						colspan="3"><textarea rows="5" cols="130" id="descinfo"
						name="descinfo"><ww:property value="buying.descinfo" /></textarea>
					</td>




				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">使用规则 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left"
						colspan="3"><textarea rows="5" cols="130" id="guize"
						name="guize"><ww:property value="buying.guize" /></textarea></td>
				</tr>
				
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">温馨提示 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l"
						colspan="3"><textarea rows="5" cols="130" id="text2"
						name="text2"><ww:property value="buying.text2" /></textarea></td>




				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">预订说明 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left"
						colspan="3"><textarea rows="5" cols="130" id="text3"
						name="text3"><ww:property value="buying.text3" /></textarea></td>

				</tr>


				<!--
				<tr style="display: none">
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">特价(0无,1有) :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="tejia
						"
						value='<ww:property value="buying.tejia
						"/>'
						" style="width: 300px" /></td>

				</tr>


				<tr style="display: none">
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">特价产品信息 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="title1
						"
						value='<ww:property value="buying.title1"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">特价产品图片 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="pic1
						"
						value='<ww:property value="buying.pic1
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<tr style="display: none">
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">特价产品图片 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="pic2
						"
						value='<ww:property value="buying.pic2"/>' " style="width: 300px" />
					</td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">产品介绍 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="text1
						"
						value='<ww:property value="buying.text1
						"/>'
						" style="width: 300px" /></td>
				</tr>






				<tr style="display: none">
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段1 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="param1
						"
						value='<ww:property value="buying.param1"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段2 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="param2
						"
						value='<ww:property value="buying.param2
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<tr style="display: none">
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段3 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="param3
						"
						value='<ww:property value="buying.param3"/>'
						" style="width: 300px" /></td>


				</tr>

				<tr style="display: none">
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">会员ID :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="memberid
						"
						value='<ww:property value="buying.memberid"/>'
						" style="width: 300px" /></td>




				</tr>



				-->
				
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备注 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left"
						colspan="3"><textarea rows="5" cols="130" id="beizhu"
						name="beizhu"><ww:property value="buying.beizhu" /></textarea></td>
				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">状态 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<select name="state">
					<option value="1" <ww:if test="buying.state==1">selected</ww:if>>正常销售</option>
					<option value="0" <ww:if test="buying.state==0">selected</ww:if>>暂停销售</option>
					</select>
					</td>
				</tr>




				<tr>
					<td colspan="4" height="40" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='buying.action?<ww:property value="url"/>';"
						name="Submit2" value=" 返回 " /></td>
				</tr>
			</table>
			</td>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>
<!--  
<script>
	var nEditor = new jtbcEditor('descinfo');
	nEditor.tEditUBBMode = 0;
	nEditor.tInit('nEditor', 'js/jtbceditor/');

	
	
	var nEditor4 = new jtbcEditor('guize');
	nEditor4.tEditUBBMode = 0;
	nEditor4.tInit('nEditor4', 'js/jtbceditor/');
	
	var nEditor5 = new jtbcEditor('text2');
	nEditor5.tEditUBBMode = 0;
	nEditor5.tInit('nEditor5', 'js/jtbceditor/');
	
	var nEditor6 = new jtbcEditor('text3');
	nEditor6.tEditUBBMode = 0;
	nEditor6.tInit('nEditor6', 'js/jtbceditor/');
	
	var nEditor7 = new jtbcEditor('beizhu');
	nEditor7.tEditUBBMode = 0;
	nEditor7.tInit('nEditor7', 'js/jtbceditor/');
	

</script>
-->