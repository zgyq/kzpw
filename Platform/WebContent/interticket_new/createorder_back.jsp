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
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<title>亿票联盟商旅平台国际机票订单提交</title>
		<meta name="keywords" content="亿票联盟商旅系统">
		<meta name="description" content="亿票联盟商旅系统">
		<link href="interticket_new/css/b2b_Order.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="clear">
		</div>
		<div style="width:100%;height:20px;">
					
		</div>
		<div class="b2b_Order">
			<div class="b2b_OrderL">
				<div class="b2b_OrderL-A">
					<h3>
						乘机人
					</h3>
					<div id="#">
						<div class="b2b_OrderL-A01">
							<input type="hidden" cname="InfoId" sname="InfoId">
							<h4>
								第<span class="online_index">1</span>位乘机人
							</h4>
							<ul>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										乘机人
									</label>
									<div class="b2b_OrderL-A02-2">
										<label class="b2b_OrderL-A02-3 ">
											姓名
										</label>
										<input type="text" cname="FirstName" sname="SurName" class="b2b_OrderL-A02-4" mod_notice_tip="姓(拼音或英文)" _cqnotice="姓(拼音或英文)" style="">
										<div class="b2b_OrderL-A02-5">
											请正确填写证件中的拼音或英文姓名，例如姓为奥巴马，应填写ao/bama
										</div>
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										证件信息
									</label>
									<div class="b2b_OrderL-A02-2">
										<select class="b2b_OrderL-A02-7 " sname="CardType" >
											<option value="2">护照</option><option value="10">港澳通行证</option><option value="22">台湾通行证</option><option value="8">台胞证</option><option value="7">回乡证</option>
										</select>
										<input type="text" class="b2b_OrderL-A02-6"  sname="CardId" mod_notice_tip="证件号码" placeholder="证件号码" _cqnotice="证件号码" style="">
										<div class="b2b_OrderL-A02-5">		
											特别提醒：为了您能顺利出行，请确保旅行结束日期至少比证件有效期早6个月。
										</div>
										<input type="hidden" cname="CardLimitTime" sname="CardLimitTime">
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										证件有效期
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										国籍
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
										<input type="hidden" name="uid_14137848290129808556209" cname="NationalityNo" id="uid_14137848290129808556209" sname="Nationality" value="">
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										出生日期
									</label>
									<div class="b2b_OrderL-A02-2">
										<input type="text" cname="Birthday" sname="Birthday" class="b2b_OrderL-A02-8" mod_notice_tip="yyyy-mm-dd" placeholder="yyyy-mm-dd" _cqnotice="yyyy-mm-dd" style="">
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										性别
									</label>
									<div class="b2b_OrderL-A02-2">
										<label class="radio"><input type="radio" cname="Gender" sname="Gender" name="uid_14137848290122545343307" value="M">男</label>
										<label class="radio"><input type="radio" cname="Gender" sname="Gender" name="uid_14137848290122545343307" value="F">女</label>
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										是否留学生
									</label>
									<div class="b2b_OrderL-A02-2">
										<label class="radio"><input type="radio" cname="Gender" sname="Gender" name="uid_14137848290122545343307" value="M">男</label>
										<label class="radio"><input type="radio" cname="Gender" sname="Gender" name="uid_14137848290122545343307" value="F">女</label>
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										乘机人类型
									</label>
									<div class="b2b_OrderL-A02-2">
										<select class="b2b_OrderL-A02-7 " sname="CardType" >
											<option value="2">儿童</option>
											<option value="10">成年</option>
										</select>
									</div>
								</li>

								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										目的地地址
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
										<div class="b2b_OrderL-A02-5">		
											特别提醒！去往美国乘客必填
										</div>
									</div>
									
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										目的地邮编
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
										<div class="b2b_OrderL-A02-5">		
											特别提醒！去往美国乘客必填
										</div>
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										现居住地址
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
										<div class="b2b_OrderL-A02-5">		
											特别提醒！去往美国乘客必填
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="b2b_OrderL-A02-9">
						<a href="javascript:void(0);" class="b2b_OrderL-A02-10 b2b_OrderL-A02-11" id="addButton">
							+添加乘机人
						</a>
						<div class="b2b_OrderL-A02-12 ">
							一张订单最多添加 <span>9</span> 名乘客。
						</div>
					</div>
				</div>
				<div class="b2b_OrderL-A">
					<h3>
						联系信息
					</h3>
					<div id="#">
						<div class="b2b_OrderL-A01">
							<ul>

								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										姓名
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
										<input type="hidden" name="uid_14137848290129808556209" cname="NationalityNo" id="uid_14137848290129808556209" sname="Nationality" value="">
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										手机号码
									</label>
									<div class="b2b_OrderL-A02-2">
										<input type="text" cname="Birthday" sname="Birthday" class="b2b_OrderL-A02-8" mod_notice_tip="yyyy-mm-dd" placeholder="yyyy-mm-dd" _cqnotice="yyyy-mm-dd" style="">
									</div>
								</li>
	
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										电子邮箱
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
									</div>
								</li>
								<li class="b2b_OrderL-A02">
									<label class="b2b_OrderL-A02-1">
										留言
									</label>
									<div class="b2b_OrderL-A02-2">
										<input cname="Nationality" type="text" class="b2b_OrderL-A02-8" placeholder="中文或英文" id="demoGuoji1" mod_notice_tip="中文或英文" mod_address_tpl="nationality" mod_address_source="nationality" mod_address_reference="uid_14137848290129808556209" _cqnotice="中文或英文" autocomplete="on" mod_change_value="|" style="">
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="b2b_OrderL-A02-14">
					<a href="#" class="b2b_OrderL-A02-13">
						&lt; 重新选择航班
					</a>
					<a href="javascript:void(0);" class="b2b_OrderL-A02-15" id="submitButton">
						确定提交订单
					</a>
				</div>
			</div>
			<div class="b2b_OrderR">
				<div class="b2b_OrderR-B">
					<div class="b2b_OrderR-B-1">
						<div class="b2b_OrderR-B-2">
							<b class="b2b_OrderR-B-3">
								去程&nbsp;10月25日 西安 - 香港 &nbsp; <strong>中转</strong>
							</b>
							<p>
								<span class="b2b_OrderR-B-4">
									东方航空 &nbsp;&nbsp;<strong>MU2169</strong> 
									<span>
										&nbsp;&nbsp;320
									</span>
								</span>
								<span>
									经济舱
								</span>
							</p>
							<div class="b2b_OrderR-B-5">
								<div class="b2b_OrderR-B-6">
									<p>2014年10月25日</p>
									<span class="b2b_OrderR-B-6-1">16:00</span>
									<p>咸阳国际机场T3航站楼</p>
								</div>
								<div class="b2b_OrderR-B-8">

								</div>
								<div class="b2b_OrderR-B-7">
									<p>2014年10月25日</p>
									<span class="b2b_OrderR-B-6-1 ">18:05</span>
									<p>浦东国际机场T1航站楼</p>
								</div>
							</div>
							<p>
								<span class="b2b_OrderR-B-4">
									上海航空 &nbsp;&nbsp;<strong>FM811</strong> 
									<span>
										&nbsp;&nbsp;738
									</span> 
								</span>
								<span>
									经济舱
								</span>
							</p>
							<div class="b2b_OrderR-B-5">
								<div class="b2b_OrderR-B-6">
									<p>2014年10月26日</p>
									<span class="b2b_OrderR-B-6-1">10:30</span>
									<p>浦东国际机场T1航站楼</p>
								</div>
								<div class="b2b_OrderR-B-8">

								</div>
								<div class="b2b_OrderR-B-7">
									<p>2014年10月26日</p>
									<span class="b2b_OrderR-B-6-1">12:40</span>
									<p>香港国际机场T1航站楼</p>
								</div>
							</div>
							
						</div>
					</div>
					<div class="b2b_OrderR-B-1">
						<div class="b2b_OrderR-B-2">
							<b class="b2b_OrderR-B-3">
								返程&nbsp;10月25日 西安 - 香港 &nbsp; <strong>中转</strong>
							</b>
							<p>
								<span class="b2b_OrderR-B-4">
									东方航空 &nbsp;&nbsp;<strong>MU2169</strong> 
									<span>
										&nbsp;&nbsp;320
									</span>
								</span>
								<span>
									经济舱
								</span>
							</p>
							<div class="b2b_OrderR-B-5">
								<div class="b2b_OrderR-B-6">
									<p>2014年10月25日</p>
									<span class="b2b_OrderR-B-6-1">16:00</span>
									<p>咸阳国际机场T3航站楼</p>
								</div>
								<div class="b2b_OrderR-B-8">

								</div>
								<div class="b2b_OrderR-B-7">
									<p>2014年10月25日</p>
									<span class="b2b_OrderR-B-6-1 ">18:05</span>
									<p>浦东国际机场T1航站楼</p>
								</div>
							</div>
							<p>
								<span class="b2b_OrderR-B-4">
									上海航空 &nbsp;&nbsp;<strong>FM811</strong> 
									<span>
										&nbsp;&nbsp;738
									</span> 
								</span>
								<span>
									经济舱
								</span>
							</p>
							<div class="b2b_OrderR-B-5">
								<div class="b2b_OrderR-B-6">
									<p>2014年10月26日</p>
									<span class="b2b_OrderR-B-6-1">10:30</span>
									<p>浦东国际机场T1航站楼</p>
								</div>
								<div class="b2b_OrderR-B-8">

								</div>
								<div class="b2b_OrderR-B-7">
									<p>2014年10月26日</p>
									<span class="b2b_OrderR-B-6-1">12:40</span>
									<p>香港国际机场T1航站楼</p>
								</div>
							</div>
							
						</div>
					</div>
					<div class="b2b_OrderR-B-9">
						<a href="#">
							[修改航班]
						</a>
						<span title="退改签信息" class="b2b_OrderR-B-10">
							退改签
						</span>
						<span  class="b2b_OrderR-B-10" title="购票说明">
							购票说明
						</span>
					</div>
				</div>
				<div class="b2b_OrderR-C">
					<div class="b2b_OrderR-C1 " id="#">
						<ul>
							<li class="b2b_OrderR-C1-1">
								<div class="b2b_OrderR-C1-3">
									应付金额：
								</div>
								<div class="b2b_OrderR-C1-2">
									<dfn>￥ </dfn>
									<span class="b2b_OrderR-C1-4" id="totalPrice">4054</span>
								</div>
							</li>
						</ul>
						<div class="b2b_OrderR-C1-0">
						</div>
						<ul>
							<li class="b2b_OrderR-C1-5" style="font-weight: bold;">
								<div class="b2b_OrderR-C1-6">成人</div>
								<div class="b2b_OrderR-C1-7"><dfn>￥</dfn>3934 x 1 人</div>						
							</li>
							<li class="b2b_OrderR-C1-5">
								<div class="b2b_OrderR-C1-6">票价：</div>
								<div class="b2b_OrderR-C1-7"><dfn>￥</dfn>3150 /人</div>	
							</li>
							<li class="b2b_OrderR-C1-5"> 
								<div class="b2b_OrderR-C1-6">参考税费：</div> 
								<div class="b2b_OrderR-C1-7"><dfn>￥</dfn>744 /人</div> 
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="clear">
		</div>
		<div style="width:100%;height:20px;">			
		</div>
		
<form action="interticket!toCreateInterTicketOrder2.action" id="form2" name="form2" method="post">
 <input type="text" id="hidsegmentinfo" name="s_jasonsegmentinfo" value='<ww:property value="s_jasonsegmentinfo" />'  />
 <input type="text" id="hidtraveltype"  name="intTravelType" value='<ww:property value="intTravelType" />' /> 
 
 <input type="text"  value="<ww:property value="StartAirportCode"/>" name="StartAirportCode" />
 <input type="text"  value="<ww:property value="EndAirportCode"/>" name="EndAirportCode" />
 <input type="text"  name="fromDate" value="<ww:property value="fromDate"/>" />

</form>

		
	</body>
</html>

								


