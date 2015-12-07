<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>天河联盟商旅网</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link href="style/webcss/bass.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/hotel.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/font.css" type="text/css" rel="stylesheet" />
<link href="style/webcss/slider.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script type="text/javascript">
 function nextstep()
 {
     //$("#imgpic").src="images/jd-xiantiao_4.gif";
     $("#imgpic").attr("src","images/webimages/jd-xiantiao_4.gif"); 
     $("#tbconfirm").show();
     $("#btnprev").show();
     $("#btnsubmit").show();
     $("#btnnext").hide();
     $("#tbInfo").hide();
     $("#spandate").show();
     $("#txtdate").hide();
     $("#spandate").html($("#txtdate").val());
     $("#spancontactname").html($("#txtcontactname").val());
     $("#spanmobile").html($("#txtmobile").val());
     $("#spantel").html($("#txttel").val());
     $("#spanemail").html($("#txtemail").val());
     $("#spandesc").html($("#txtdesc").val());
     
 }
 function prevstep()
 {
     $("#tbconfirm").hide();
     $("#btnprev").hide();
     $("#btnsubmit").hide();
     $("#btnnext").show();
     $("#tbInfo").show();
     $("#spandate").hide();
     $("#txtdate").show();
     $("#imgpic").attr("src","images/webimages/jd-xiantiao_3.gif"); 
 }
 function datacheck()
 {
     if($("#txtdate").val()=="")
     {
        alert("出发日期不能为空，请重新填写！");
        $("#txtdate").focus();
        return false;
     }
     if($("#txtcontactname").val()=="")
     {
        alert("联系人姓名不能为空，请重新填写！");
        $("#txtcontactname").focus();
        return false;
     }
     if($("#txtmobile").val()=="")
     {
        alert("手机号码不能为空，请重新填写！");
        $("#txtmobile").focus();
        return false;
     }
     else
     {
        if(!IsMobile($("#txtmobile").val()))
        {
           alert("手机号码格式不正确，请重新填写！");
           $("#txtmobile").focus();
           return false;
        }
     }
     if($("#txttel").val()!="" && !IsTelephone($("#txttel").val()))
     {
        alert("固定电话格式不正确(010-8776654)，请重新填写！");
        $("#txttel").focus();
        return false;
     }
     if($("#txtemail").val()!="" && !IsEMail($("#txtemail").val()))
     {
        alert("电子邮件格式不正确，请重新填写！");
        $("#txtemail").focus();
        return false;
     }
     
     nextstep();
 }
</script>
</head>

<body>
<form name="form1" action="triplinebook!tocreateOrder.action"
	method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" style="border: 1px solid #99CBED; margin-bottom: 4px;">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><span
			class="font-blue-cu">&nbsp;&nbsp;&nbsp;填写旅游订单信息</span></td>
	</tr>
	<tr>
		<td>
		<div>
		
		<div >

		<h3 class="lan14_cu" style="line-height: 34px;">选择线路》登录或注册》完善提交订单》<span
			class="hui_xi">等待客服联系》确认》准备材料》付款签约》出团通知</span></h3>

		<div class="box2" style="padding: 5px;"><span class="red_cu">旅游线路信息</span>：
		<span class="lan14_cu"> </span><span class="lan12">&nbsp;</span>&nbsp;<strong><ww:property
			value="getCityName(tripline.cityid)" />-<ww:property
			value="getCityName(tripline.endcityid)" /></strong>&nbsp;&nbsp;&nbsp;&nbsp;<strong>单价</strong>：<span><ww:property
			value="hidprice" />元/人</span>
			<ww:if test="usertype==2">
	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<font class="red14_cu">	返<ww:property value="gettravefan(hidprice)" />元</font>
</ww:if>
			</div>
		<input name="tripline_id" type="hidden"
			value="<ww:property value="tripline.id" />" />
		<div class="box" style="margin-top: 10px;">
		<ul>
			<li style="padding-left: 20px; padding-top: 3px; background: #DDECF3"><span
				class="lan12_cu">价格详情</span></li>
			<li>
			<table width="96%" border="0" cellspacing="0" cellpadding="0"
				style="margin-top: 10px;">
				<tr>
					<td width="4%">&nbsp;</td>
					<td width="74%" class="lan_xia box_bottom_xu"><ww:property
						value="tripline.name" /></td>
					<td width="22%" class="box_bottom_xu">&nbsp;</td>
				</tr>
				<tr height="10px">
					<td colspan="3"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td class="box_bottom_xu"><b>人数: 共<ww:property
						value="s_personnum" />人</b><input type="hidden" name="tripnum"
						value="<ww:property value="s_personnum" />"></td>
					<td class="box_bottom_xu" align="right"><span
						class="huang14_c">总价格：<ww:property value="totalprice" />元</span><input
						type="hidden" name="triptprice"
						value="<ww:property value="totalprice" />">
<ww:if test="usertype==2">
	&nbsp; &nbsp;<span class="huang14_c">返<ww:property value="gettravefan(totalprice)" />元</span>
	<input type="hidden" name="usertype" value="<ww:property value="usertype" />" />
</ww:if>

						</td>
				</tr>


				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			</li>
			<li style="padding-left: 20px; padding-top: 3px; background: #DDECF3"><span
				class="lan12_cu">确认联系人信息</span></li>
			<li>
			<table id="tbInfo"  border="0" cellspacing="0"
				cellpadding="0" style="margin-top: 10px;">
				<tr>
					<td width="4%">&nbsp;</td>
					<td width="14%" align="right"><span class="red">* </span>联系人姓名：</td>
					<td width="54%"><label> <input type="text"
						name="contactname" id="txtcontactname" value="<ww:property value="getOrderUserLogin().membername"/>" /> </label></td>
					<td width="28%" rowspan="6">
					<p class="red">请准确填写联系人信息，</p>
					<p class="red">以便客服及时与您取得联系</p>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">出发日期： </td>
					<td><input name="s_date" type="text"
						style="width: 150px; height: 20px;" id="txtdate"
						onfocus="WdatePicker({minDate:'%y-%M-%d'})" class="Wdate" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right"><span class="red">*</span> 手机号码：</td>
					<td><input type="text" name="mobile" id="txtmobile" value="<ww:property value="getOrderUserLogin().mobile"/>"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">固定电话：</td>
					<td><input type="text" name="tel" id="txttel" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">邮箱：</td>
					<td><input type="text" name="email" id="txtemail" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right" valign="top">其他需求：</td>
					<td><textarea name="desc" cols="" rows="4"
						style="width: 300px;" id="txtdesc">&nbsp;</textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>

			<table id="tbconfirm" width="700" border="0" cellspacing="0"
				cellpadding="0" style="margin-top: 10px; display: none">
				<tr>
					<td width="4%">&nbsp;</td>
					<td width="14%" align="right">联系人姓名：</td>
					<td width="54%"><label><span id="spancontactname"></span>
					</label></td>
					<td width="28%" rowspan="6">
					<p class="red">请准确填写联系人信息，</p>
					<p class="red">以便客服及时与您取得联系</p>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">出发日期： </td>
					<td><span id="spandate"
						style="display: none"></span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">手机号码：</td>
					<td><span id="spanmobile"></span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">固定电话：</td>
					<td><span id="spantel"></span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">邮箱：</td>
					<td><span id="spanemail"></span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right" valign="top">其他需求：</td>
					<td><span id="spandesc"></span></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>

			</li>

		</ul>
		</div>
		<div style="text-align: center; margin-top: 10px;"><input
			id="btnnext" type="button" onclick="return datacheck();"
			class="button108" value="下一步" /><input type="button" id="btnprev"
			class="button108" style="display: none" value="上一步"
			onclick="prevstep();" />&nbsp;&nbsp;<input id="btnsubmit"
			style="display: none" type="submit" class="button108" value="提交订单" /></div>
		</div>
		<div class="c"></div>

		<!-------------ddddd------------------>

		<div class="c" style="height: 10px"></div>
		<!---------------------main_2 over-------------------->
		<div></div>
		</div>
		</form>
		</td>
	</tr>
</table>
</body>
</html>
