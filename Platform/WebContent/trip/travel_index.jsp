<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/webcss/bass.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/hotel.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/font.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/citycontrol/city_date_com.js"></script>
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    //加载酒店旅游城市数据
    loadCityData_Common("1");
});
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
</script>
</head>

<body>
<form action="triplinebook!toTriplineList.action" method="post"
	onsubmit="dispose('系统正在查询');">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box bg"><b class="anse">&nbsp;&nbsp;&nbsp;旅游线路查询</b></td>

	</tr>
	<tr>
		<td>


		<table width="760" border="1" align="center" cellpadding="0"
			bordercolor="#b3b3b3" cellspacing="0"
			style="font-size: 12px; border-collapse: collapse; margin-top: 20px;">
			<tr class="font-blue-xi">
				<td style="background: #f0f0f0; align: right">出发城市：
				</div>
				</td>
				<td><input id="txttravelfromcity" name="travelfromcity"
					type="text" class="input" value="西安"
					onclick="this.value='';GetCityList(this,1,'txttravelfromcity','s_startcityid'); "
					onkeyup="GetCityList(this,1,'txttravelfromcity','s_startcityid'); " />
				<input type="hidden" name="s_startcityid" id="s_startcityid"
					value="317" /></td>
				<td style="background: #f0f0f0; align: right">到达城市：</td>
				<td><input id="txttraveltocity" name="traveltocity" type="text"
					class="input" value=""
					onclick="this.value='';GetCityList(this,1,'txttraveltocity','s_endcityid'); "
					onkeyup="GetCityList(this,1,'txttraveltocity','s_endcityid'); " />
				<input type="hidden" name="s_endcityid" value="" id="s_endcityid" />
				</td>

			</tr>
			<tr>
				<td style="background: #f0f0f0; align: right">出发时间:</td>
				<td><input name="s_t_startdate" id="s_t_startdate" type="text"
					value="<ww:property value="s_t_startdate" />" class="input"
					onfocus="WdatePicker({skin:'whyGreen',doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-#{%M+1}-%d', onpicked:function(){}})" /></td>
				<td style="background: #f0f0f0; align: right">线路类型:</td>
				<td><select name="s_linetype"
					style="width: 158px; border: 1px solid #CDCDCD">
					<option value="-1">请选择线路类型</option>
					<ww:iterator value="listtriplinetype">
						<option value="<ww:property value="id" />"><ww:property
							value="name" /></option>
					</ww:iterator>
				</select></td>

			</tr>
			<tr>
				<td style="background: #f0f0f0; align: right">关键字:</td>
				<td><input name="s_endcityname" type="text"
					style="width: 150px;" value="<ww:property value="s_endcityname" />" /></td>
				<td style="background: #f0f0f0;"></td>
				<td></td>
			</tr>
		</table>



		</td>

	</tr>
	<tr>
		<td colspan="2" style="height: 10px"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><ww:if test="usertype==2">
			<input type="hidden" name="usertype" value="2" />
		</ww:if> <input type="submit" class="button" value="立即搜索" /></td>
	</tr>
	<tr>
		<td colspan="2" style="height: 10px"></td>
	</tr>
</table>
</form>
</body>
</html>
