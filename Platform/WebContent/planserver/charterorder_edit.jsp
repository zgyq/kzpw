
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
<title><ww:if test="charterorder
		.id>0">编辑</ww:if><ww:else>新增</ww:else>包机订单
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />



<!-- 城市控件用 -->
<link rel="stylesheet" type="text/css" href="js/aircity/css/jquery.suggest.css">

 <script type="text/javascript" src="js/aircity/js/jquery-1.4.2.min.js"></script>
 <script type="text/javascript" src="js/aircity/js/j.dimensions.js"></script>
 <script type="text/javascript" src="js/aircity/js/aircity.js"></script>
 <script type="text/javascript" src="js/aircity/js/j.suggest.js"></script>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>

<script src="js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>

<link rel="stylesheet" href="style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script type="text/javascript">


$(document).ready(function() {
 			$("#arrcity").val($("#txtsairportname").val());
	        $("#city_from_hide").val($("#txtsairport").val());
	        $("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_from_hide',onSelect:function(){$("#tocity").click();}, attachObject:'#suggest'});//
			$("#tocity").suggest(citys,{hot_list:commoncitys,dataContainer:'#city_to_hide',onSelect:function(){bindroundfromcity();},attachObject:"#suggest2"});
			$("#form1").validationEngine(
			{
				
	       		success : function() {
				//表单提交时把按钮disable
				
				document.getElementById("submitreg").disabled = true;
				document.form1.submit();
				}
			}
	
	) 

});

var idnumber=0;

function addrecord()
{

	
	
	   var strhtml="";
	   idnumber++;
	   strhtml+="<tr id='hidid_"+idnumber+"'>";
	   //strhtml+="<td width='20%'>"+idnumber+"<input type='hidden' name='tempid' value='0'   /></td>";
	   //strhtml+="<td width='20%'><input type='text' name='fandianstart' desc='大于' id='fandianstart"+idnumber+"' onchange='ValiDatValueFast("+idnumber+");'  style='width:100px' value=''  /><span name='ty'>%</span></td>";
	   //strhtml+="<td width='20%'><input type='text' name='fandianend' desc='小于' id='fandianend"+idnumber+"' style='width:100px' value=''  /><span name='ty'>%</span></td>";
	   //strhtml+="<td width='20%'><input type='text' name='liudian' desc='暗扣' id='liudian"+idnumber+"' style='width:100px' value=''  /><span name='ty'>%</span></td>";
	   //strhtml+="<td width='20%'><a href='#' onclick='addrecord();'><img src='images/add.gif' />添加</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#' onclick='delrecord("+idnumber+");'><img src='images/del.gif' />删除</a></td>";
		strhtml+="<td style='width: 20%'>姓名:<input type='text' name='p_username' id='p_username_"+idnumber+"' style='width: 90px' /></td>";
		strhtml+="<td>类型:<select name='p_usertype' id='p_usertype_"+idnumber+"'><option value='1'>成人</option><option value='2'>儿童</option><option value='3'>婴儿</option></select></td>";
		strhtml+="<td>证件类型:<select name='p_idtype' id='p_idtype_"+idnumber+"'><option value='1'>身份证</option><option value='3'>护照</option><option value='4'>港澳通行证</option><option value='5'>台湾通行证</option><option value='6'>台胞证</option><option value='7'>回乡证</option><option value='8'>军官证</option></select></td>";
		strhtml+="<td>证件号码:<input type='text' name='p_idno' id='p_idno_"+idnumber+"' style='width: 140px' /></td>";
		strhtml+="<td>出生日期:<input type='text' name='p_shengri' id='p_shengri_"+idnumber+"' style='width: 120px'  />(格式:2008-08-08)</td>";
		strhtml+="<td><a href='#' onclick='delrecord("+idnumber+");'><img src='images/del.gif' />删除</a>&nbsp;<a href='#' onclick='addrecord();'><img src='images/add.gif' />添加</a></td>";
	   strhtml+="</tr>";
	   
	   
	   //alert(strhtml);
	   $("#tbrecord").html($("#tbrecord").html()+strhtml);
	  // var ty=GetRadioValue("liudiantype");
	  // checktype(ty);
   
}

function delrecord(id)
{
	
	if(id==0){
	alert("必须最少输入一个人!!!");
	return;
	}
   idnumber--;
   $("#hidid_"+id).remove();
}
addrecord();

//提交JS
function sub()
{
var c_FromDate=document.getElementById("txtStartDate").value;
if(c_FromDate==''){
alert("出发日期不能为空!!!");
return;
}
var c_airno=document.getElementById("c_airno").value;
if(c_airno==''){
alert("航班号不能为空!!!");
return;
}
var c_cabincode=document.getElementById("c_cabincode").value;
if(c_cabincode==''){
alert("舱位不能为空!!!");
return;
}
var c_linkname=document.getElementById("c_linkname").value;
if(c_linkname==''){
alert("联系人不能为空!!!");
return;
}

var c_linktel=document.getElementById("c_linktel").value;
if(c_linktel==''){
alert("联系人手机号不能为空!!!");
return;
}

var c_linkemail=document.getElementById("c_linkemail").value;
if(c_linkemail==''){
alert("联系人邮箱不能为空!!!");
return;
}


//开始验证乘机人

  //验证姓名
  var p_username=document.getElementsByName("p_username");
  //验证证件号码
  var p_idno=document.getElementsByName("p_idno");
  //验证出生日期
  var p_shengri=document.getElementsByName("p_shengri");
  
   for(var i=0;i<p_username.length;i++)
  {
     if(p_username[i].value=="")
     {
        alert("乘机人姓名不能为空!!");
        return ;
     }
   
  }
   for(var i=0;i<p_idno.length;i++)
  {
     if(p_idno[i].value=="")
     {
        alert("证件号码不能为空!!");
        return ;
     }
   
  }
   for(var i=0;i<p_shengri.length;i++)
  {
     if(p_shengri[i].value=="")
     {
        alert("生日不能为空!!");
        return ;
     }
   
   var pattern=/\d{4}-\d{2}-\d{2}/;//日期格式
   	if(!pattern.exec(p_shengri[i].value))
		{
        alert("生日格式错误!!!");
        return;
		}
   
  }
  
alert("你的申请正在提交中!!!请耐心等待我们的回复,保持手机畅通!!!");
//验证乘机人结束
document.form1.submit();
}


</script>
</head>

<body>
<div id="member">
<form action="charterorder
		!<ww:if test="charterorder
		.id>0">edit.action?id=<ww:property value="charterorder
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" id="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr align="left">
		<td align="left" width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="charterorder
		.id>0">编辑</ww:if><ww:else>申请</ww:else>团队/包机申请 </span></b></td>
	</tr>




	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td width="100%" height="29" class="box-bottom bg" colspan="4"><b
						class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;行程信息
						
					</span></b></td>
				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">出发城市 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" name="num" style="width: 300px" id="arrcity" value="北京"  onclick="if(this.value='北京'){this.value='';}" onblur="if(this.value=='') {this.value='北京';};" />
						
						<div id='suggest' class="ac_results"></div>
					<input type="hidden" id="city_from_hide" value="PEK" name="StartAirportCode" />
						
						</td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">到达城市 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" id="tocity" name="maxnum" style="width: 300px" value="上海虹桥" onclick="if(this.value='上海虹桥'){this.value='';}" onblur="if(this.value=='') {this.value='上海虹桥';};" />
					<div id='suggest2' class="ac_results"></div>
					<input type="hidden" id="city_to_hide" name="EndAirportCode" value="SHA" />
					</td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">出发时间 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" style="width: 300px" id="txtStartDate"  name="FromDate" onclick="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})"  class="Wdate" /></td>




				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">航空公司 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<select id="ddlAirCom" name="AirCompanyCode" style="width:140px;">
					<ww:iterator value="listAircompany">
					<option value="<ww:property value='aircomcode' />"><ww:property
					value="aircomcode" /> <ww:property value="aircomcnname" /></option>
					</ww:iterator>
					</select>
					</td>



					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">航班号 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" id="c_airno" name="c_airno" style="width: 300px" /></td>
				</tr>



				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">舱位 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<input type="text" id="c_cabincode" name="c_cabincode" maxlength="2"
						value='<ww:property value="charterorder.zipcode"/>'
						" style="width: 30px" />(请直接输入舱位码,比如F,C,Y)</td>
				</tr>
				<tr>
					<td width="100%" height="29" class="box-bottom bg" colspan="4"><b
						class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;联系人信息
						
					</span></b></td>
				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">联系人姓名 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l">
					<input type="text" id="c_linkname" name="c_linkname" style="width: 300px" /></td>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">手机号 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" class="table_color_l" align="left">
					<input type="text" name="c_linktel" id="c_linktel"  style="width: 300px" /></td>
				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">联系邮箱 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<input type="text" name="c_linkemail" id="c_linkemail" style="width: 300px" /></td>
					
				</tr>
				<tr>
					<td width="5%" height="30" style="text-align: right;"
						class="table_color colortrin">备注 :<span style="color: red;">*</span>
					</td>
					<td width="10%" height="30" align="left" class="table_color_l" colspan="3">
					<textarea rows="3" cols="120" name="c_memo"></textarea>
					</td>
					
				</tr>
				<tr>
					<td width="100%" height="29" class="box-bottom bg" colspan="4"><b
						class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;乘机人信息
					</span></b></td>
				</tr>
				<tr>
					<td width="100%" colspan="4">
					<table width="100%" id="tbrecord">
					<tr>
					<td style="width: 20%">
					姓名:<input type="text" name="p_username" id="p_username_0" style="width: 90px" />
					</td>
					<td>
					类型:<select name="p_usertype" id="p_usertype_0">
					<option value="1">成人</option>
					<option value="2">儿童</option>
					<option value="3">婴儿</option>
					</select>
					</td>
					<td>
					证件类型:
					<select name="p_idtype" id="p_idtype_0">
					<option value="1">身份证</option>
					<option value="3">护照</option>
					<option value="4">港澳通行证</option>
					<option value="5">台湾通行证</option>
					<option value="6">台胞证</option>
					<option value="7">回乡证</option>
					<option value="8">军官证</option>
					</select>
					</td>
					<td>
					证件号码:<input type="text" name="p_idno" id="p_idno_0" style="width: 140px" />
					</td>
					<td>
					出生日期:<input type="text" name="p_shengri" id="p_shengri_0" style="width: 120px"  />(格式:2008-08-08)
					</td>
					<td>
					<a href='#' onclick="delrecord('至少输入一个乘机人信息!!!');"><img src='images/del.gif' />删除</a>
					<a href="#" onclick="addrecord();"><img src="images/add.gif" />添加</a>
					</td>
					</tr>
					
					</table>
					
					</td>

				</tr>


				<tr align="center">
					<td colspan="4" height="40" bgcolor="ffffff"><input
						type="button" class="button_d font-bai" onclick="sub();" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='charterorder.action?<ww:property value="url"/>';"
						name="Submit2" value=" 返回 " /></td>
				</tr>
			</table>
			</td>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</table>

</form>
</div>
</body>
</html>


