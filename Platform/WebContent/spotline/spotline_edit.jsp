
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
<title><ww:if test="spotline
		.id>0">编辑</ww:if><ww:else>新增</ww:else>景区线路信息
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="js/ckeditor/content.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>


<script type="text/javascript" src="<%=request.getContextPath()%>/js/jtbceditor/jtbceditor.js"></script>


<!--
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ckeditor/ckeditor.js"></script>
-->
<script language="javascript" type="text/javascript" src="js/hotel/functions.js"></script>
<script language="javascript" type="text/javascript" src="js/hotel/city_date2.js"></script>
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
</script>
<body>
<div id="member">
<form
	action="spotline
		!<ww:if test="spotline
		.id>0">edit.action?id=<ww:property value="spotline
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="spotline
		.id>0">编辑</ww:if><ww:else>新增</ww:else>景区线路信息 </span></b></td>
	</tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">


			<tr>
		<td width="100%" height="29" class="box-bottom bg" colspan="4">
		<table>
		<tr>
		<td colspan="4">
		<b class="anse"><span style="color: red" class="font-blue-cu">&nbsp;&nbsp;&nbsp;基本信息</span></b>
		</td></tr>	
		</table>
		</td>
	</tr>

				<!--<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">外部id :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="outid
						"
						value='<ww:property value="spotline.outid"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">景区ID :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="sid
						"
						value='<ww:property value="spotline.sid
						"/>'
						" style="width: 300px" /></td>
				</tr>
				-->
				<tr>
					<td colspan="4">
					<table>
						<tr>
						<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">所属地区 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" id="txthotelcity" name="hotelcity" value="<ww:property value="GetSpotCityNmaeByID(spotline.cityid)" />"  onclick="this.value='';GetCityList(this); " onkeyup="GetCityList(this); "  />
					<div id="suggest" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide" name="cityid" value="<ww:property value="spotline.cityid" />"  />
					
					</td>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">出发城市 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" id="txthotelcity2" name="hotelcity" value="<ww:property value="GetSpotCityNmaeByID(spotline.provineid)" />"  onclick="this.value='';GetCityList2(this); " onkeyup="GetCityList2(this); "  />
					<div id="suggest2" class="ac_results"></div>
             	   <input type="hidden" id="city_hotel_hide2" name="provineid" value="<ww:property value="spotline.provineid" />"  />
					</td>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">线路名称 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="name
						"
						value='<ww:property value="spotline.name
						"/>'
						" style="width: 300px" /></td>
						
						</tr>
					</table>
					</td>
					
				</tr>



				<!--<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">省份ID :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="provineid
						"
						value='<ww:property value="spotline.provineid"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">城市ID :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="cityid
						"
						value='<ww:property value="spotline.cityid
						"/>'
						" style="width: 300px" /></td>
				</tr>
				-->
				
				<!--<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">区域ID :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="areaid
						"
						value='<ww:property value="spotline.areaid"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">景区地址 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="address
						"
						value='<ww:property value="spotline.address
						"/>'
						" style="width: 300px" /></td>
				</tr>
				-->
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">景点信息 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<textarea rows="5" cols="130" id="info" name="info"><ww:property value="spotline.info"/></textarea>
					
					</td>



					
				</tr>
	<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">行程介绍 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<textarea rows="15" cols="130" id="pics" name="pics"><ww:property value="spotline.pics"/></textarea>
					
					
					</td>
					</tr>


				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">注意事项 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<textarea rows="7" cols="130" id="notice" name="notice"><ww:property value="spotline.notice"/></textarea>
					</td>

					<!--<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">景点图片 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="pics
						"
						value='<ww:property value="spotline.pics
						"/>'
						" style="width: 300px" /></td>
				-->
				</tr>



				<!--<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">景区图片路径 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="minipics
						"
						value='<ww:property value="spotline.minipics"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">票类说明 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="ticketnotic
						"
						value='<ww:property value="spotline.ticketnotic
						"/>'
						" style="width: 300px" /></td>
				</tr>
				-->
				<tr>
					<!--<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">温馨提示 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="guidelines
						"
						value='<ww:property value="spotline.guidelines"/>'
						" style="width: 300px" /></td>

					-->
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">出发日期 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="stime" value='<ww:property value="spotline.stime"/>' style="width: 300px" onclick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"
									class="Wdate" />
									<span style="color: red">(如果为天天发团线路,日期不用填写,填写后就是指定日期发团)</span>
									</td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">行程天数 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<input type="text" id="days" name="days" value='<ww:property value="spotline.days"/>' style="width: 300px" onchange="changNum(this.value);" /></td>
				</tr>
				<tr>
				<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">计划人数 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="snums
						"
						value='<ww:property value="spotline.snums
						"/>'
						" style="width: 300px" /></td>
				</tr>
				
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">状态 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<select name="state">
					<option value="1" <ww:if test="spotline.state==1">selected</ww:if>>正常销售</option>
					<option value="0" <ww:if test="spotline.state==0">selected</ww:if>>暂停销售</option>
					</select>
					</td>
				</tr>
				<tr>
				<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">交通工具 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="traffic
						"
						value='<ww:property value="spotline.traffic
						"/>'
						" style="width: 300px" /></td>
				
				</tr>
				

	<tr>
		<td width="100%" height="29" class="box-bottom bg" colspan="4">
		<table>
		<tr>
		<td colspan="4">
		<b class="anse"><span style="color: red" class="font-blue-cu">&nbsp;&nbsp;&nbsp;行程安排</span></b>
		</td></tr>	
		</table>
		</td>
	</tr>
	
	<ww:if test="spotline.id>0">
	<tr>
		<td width="100%" colspan="4">
			<div id="xcdiv">
	<ww:iterator value="listSpotlineinfo" status="index">
	<tr><td colspan='4'><table><tr>
	<td width='5%' height='30' style='text-align: center;' class='table_color colortrin'><span style='color: red;'>第<ww:property value='#index.index+1'/>天</span></td>
	<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>区间 :<span style='color: red;'>*</span></td>
	<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>
	<input type='text' name='scityname' value='<ww:property value='qujian'/>' style='width: 100px' /></td>
	<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>住宿 :<span style='color: red;'>*</span></td>
	<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>
	<input type='text' name='szhusu' value='<ww:property value='zhusu'/>' style='width: 100px' /></td>
	<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>用餐 :<span style='color: red;'>*</span></td>
	<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>
	<input type='text' name='scanyin' value='<ww:property value='canyin'/>' style='width: 140px' /></td>
	</tr></table></td></tr>
	<tr><td colspan='4'><table><tr>
	<td width='10%' height='30' align='left' class='table_color_l' colspan='3'>
	<textarea rows='3' cols='130' name='sbeizhu'><ww:property value='beizhu'/></textarea>(详细描述)
	</td>
	</tr></table></td></tr>
	</ww:iterator>
	</div></td></tr>
	
	</ww:if><ww:else>
	<tr>
		<td width="100%" colspan="4">
			<div id="xcdiv"></div>
		</td>
	</tr>
	</ww:else>
	
	
	
	
	
	<tr>
		<td width="100%" height="29" class="box-bottom bg" colspan="4">
		<table>
		<tr>
		<td colspan="4">
		<b class="anse"><span style="color: red" class="font-blue-cu">&nbsp;&nbsp;&nbsp;价格信息(如无儿童报价,无需填写) </span></b>
		</td></tr>	
		</table>
		</td>
	</tr>
	
	<tr>
		<td colspan="4">
		<table>
		<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">价格类型 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="sptype" value='成人' readonly="readonly" style="width: 100px" /></td>
					
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">销售价格 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="sprice" value='<ww:property value="listSpotlineprice.get(0).price"/>' style="width: 100px" /></td>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">市场价格 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="slsprice" value='<ww:property value="listSpotlineprice.get(0).lsprice"/>' style="width: 100px" /></td>
		</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td colspan="4">
		<table>
		<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">价格类型 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="sptype" value='儿童' readonly="readonly" style="width: 100px" /></td>
					
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">结算价格 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="sprice" value='<ww:property value="listSpotlineprice.get(1).price"/>' style="width: 100px" /></td>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">参考零售 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan="3">
					<input type="text" name="slsprice" value='<ww:property value="listSpotlineprice.get(1).lsprice"/>' style="width: 100px" /></td>
		</tr>
		</table>
		</td>
	</tr>
	
	
	<tr>
		<td width="100%" height="29" class="box-bottom bg" colspan="4">
		<table>
		<tr>
		<td colspan="4">
		<b class="anse"><span style="color: red" class="font-blue-cu">&nbsp;&nbsp;&nbsp;地接社信息 </span></b>
		</td></tr>	
		</table>
		</td>
	</tr>
	
	

				<!--<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段1 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="param1
						"
						value='<ww:property value="spotline.param1"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段2 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="param2
						"
						value='<ww:property value="spotline.param2
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备用字段3 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="param3
						"
						value='<ww:property value="spotline.param3"/>'
						" style="width: 300px" /></td>
			</tr>
				-->
				
				
				
				
				
				
				
				
				
				
				<tr>
					<!--<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">会员ID :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="memberid
						"
						value='<ww:property value="spotline.memberid"/>'
						" style="width: 300px" /></td>
					-->
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">线路类型 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<select name="stype">
					<option value="3" <ww:if test="spotline.stype==3">selected</ww:if>>周边线路</option>
					<option value="4" <ww:if test="spotline.stype==4">selected</ww:if>>国内长线</option>
					<option value="5" <ww:if test="spotline.stype==5">selected</ww:if>>出境长线</option>
					<option value="6" <ww:if test="spotline.stype==6">selected</ww:if>>自由行</option>
					<option value="1" <ww:if test="spotline.stype==1">selected</ww:if>>普通线路</option>
					<option value="2" <ww:if test="spotline.stype==2">selected</ww:if>>电商线路</option>
					</select>
					</td>
					
					
					
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">旅游类型 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<select name="areaid">
					<option value="1" <ww:if test="spotline.areaid==1">selected</ww:if>>跟团游</option>
					<option value="2" <ww:if test="spotline.areaid==2">selected</ww:if>>自助游</option>
					
					</select>
					</td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">地接社名称 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="djsname
						"
						value='<ww:property value="spotline.djsname"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">地接社电话 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="djstel
						"
						value='<ww:property value="spotline.djstel
						"/>'
						" style="width: 300px" /></td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">联系人 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="djslinkname
						"
						value='<ww:property value="spotline.djslinkname"/>'
						" style="width: 300px" /></td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">地接社地址 :<span
						style="color: red;">*</span></td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="djsaddress
						"
						value='<ww:property value="spotline.djsaddress
						"/>'
						" style="width: 300px" /></td>
				</tr>


				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">服务标准 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<textarea rows="15" cols="130" id="fwbz" name="fwbz"><ww:property value="spotline.fwbz"/></textarea>
					</td>
				</tr>


				<tr>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">费用包含 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan=3">
					<textarea rows="7" cols="130"  id="baohan" name="baohan"><ww:property value="spotline.baohan"/></textarea>
					</td>
						
					
				</tr>

				<tr>

					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">费用不包含 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan=3">
					<textarea rows="7" cols="130"  id="bubaohan" name="bubaohan"><ww:property value="spotline.bubaohan"/></textarea>
					</td>
						
					
				</tr>

				<tr>
					



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">门市备注 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left" colspan=3">
					<textarea rows="5" cols="130"  id="menshibeizhu" name="menshibeizhu"><ww:property value="spotline.menshibeizhu"/></textarea>
					</td>
				</tr>



				




				<tr>
					<td colspan="4" height="40" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='spotline.action?<ww:property value="url"/>';"
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
<script>
function changNum(val){
	var shtml="";
	for(s=0;s<val;s++){
	shtml+="<span>";
	shtml+="<tr><td colspan='4'><table><tr>";
	shtml+="<td width='5%' height='30' style='text-align: center;' class='table_color colortrin'><span style='color: red;'>第"+(s+1)+"天</span></td>";
	shtml+="<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>区间 :<span style='color: red;'>*</span></td>";
	shtml+="<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>";
	shtml+="<input type='text' name='scityname' value='' style='width: 100px' /></td>";
	shtml+="<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>住宿 :<span style='color: red;'>*</span></td>";
	shtml+="<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>";
	shtml+="<input type='text' name='szhusu' value='' style='width: 100px' /></td>";
	shtml+="<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>用餐 :<span style='color: red;'>*</span></td>";
	shtml+="<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>";
	shtml+="<input type='text' name='scanyin' value='' style='width: 140px' /></td>";
	shtml+="</tr></table></td></tr>";
	shtml+="<tr><td colspan='4'><table><tr>";
	shtml+="<td width='10%' height='30' align='left' class='table_color_l' colspan='3'>";
	shtml+="<textarea rows='3' cols='130' name='sbeizhu'></textarea>(详细描述)";
	shtml+="</td>";
	shtml+="</tr></table></td></tr>";
	shtml+="</span>";
	}

$("#xcdiv").html(shtml);
$("#days").val(val);
}
function changNum2(val){

	var shtml="";
	var s=0;
	<ww:iterator value="listSpotlineinfo">
	shtml+="<span>";
	shtml+="<tr><td colspan='4'><table><tr>";
	shtml+="<td width='5%' height='30' style='text-align: center;' class='table_color colortrin'><span style='color: red;'>第"+(s+1)+"天</span></td>";
	shtml+="<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>区间 :<span style='color: red;'>*</span></td>";
	shtml+="<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>";
	shtml+="<input type='text' name='scityname' value='' style='width: 100px' /></td>";
	shtml+="<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>住宿 :<span style='color: red;'>*</span></td>";
	shtml+="<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>";
	shtml+="<input type='text' name='szhusu' value='' style='width: 100px' /></td>";
	shtml+="<td width='5%' height='30' style='text-align: right;' class='table_color colortrin'>用餐 :<span style='color: red;'>*</span></td>";
	shtml+="<td width='10%' height='30' class='table_color_l' align='left' colspan='3'>";
	shtml+="<input type='text' name='scanyin' value='' style='width: 140px' /></td>";
	shtml+="</tr></table></td></tr>";
	shtml+="<tr><td colspan='4'><table><tr>";
	shtml+="<td width='10%' height='30' align='left' class='table_color_l' colspan='3'>";
	shtml+="<textarea rows='3' cols='130' name='sbeizhu'></textarea>(详细描述)";
	shtml+="</td>";
	shtml+="</tr></table></td></tr>";
	shtml+="</span>";
	s++;
	</ww:iterator>

$("#xcdiv").html(shtml);
$("#days").val(val);
}
<ww:if test="spotline.id>0">
//changNum2(<ww:property value='listSpotlineinfo.size'/>);
</ww:if><ww:else>
changNum(1);
</ww:else>

// 初始化文本编辑器



	var nEditor = new jtbcEditor('jt_info');
	nEditor.tEditUBBMode = 0;
	nEditor.tInit('nEditor', 'js/jtbceditor/');

	var nEditor2 = new jtbcEditor('notice');
	nEditor2.tEditUBBMode = 0;
	nEditor2.tInit('nEditor2', 'js/jtbceditor/');
	
	var nEditor3 = new jtbcEditor('menshibeizhu');
	nEditor3.tEditUBBMode = 0;
	nEditor3.tInit('nEditor3', 'js/jtbceditor/');
	
	var nEditor4 = new jtbcEditor('fwbz');
	nEditor4.tEditUBBMode = 0;
	nEditor4.tInit('nEditor4', 'js/jtbceditor/');
	
	var nEditor5 = new jtbcEditor('baohan');
	nEditor5.tEditUBBMode = 0;
	nEditor5.tInit('nEditor5', 'js/jtbceditor/');
	
	var nEditor6 = new jtbcEditor('bubaohan');
	nEditor6.tEditUBBMode = 0;
	nEditor6.tInit('nEditor6', 'js/jtbceditor/');
	
	var nEditor7 = new jtbcEditor('pics');
	nEditor7.tEditUBBMode = 0;
	nEditor7.tInit('nEditor7', 'js/jtbceditor/');
	

       // CKEDITOR.replace( 'info' );



</script>

