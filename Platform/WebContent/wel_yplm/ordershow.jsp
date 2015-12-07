<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
		<title>亿票联盟商旅系统-订单监视独立页面</title>
		<meta name="keywords" content="亿票联盟商旅系统">
		<meta name="description" content="亿票联盟商旅系统">
		<link href="wel_yplm/css/b2b_dingdanjianshi.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	
		<div class="b2b_dingdanjianshi_logo">
			<div style="height:69px; width:350px;float:left;margin-left:55px;margin-top:6px;">
				<img width="350" height="69" src="wel_yplm/css/images/dingdanjianshi_logo.png">
			</div>
			<div class="b2b_dingdanjianshi_2 ">
				<div class="b2b_dingdanjianshi_2_2 ">
					<a href="#">
						<input type="button" onclick="logout();" class="b2b_dingdanjianshi_2_tuichu " value="退出">
					</a>
				</div>
				<div style="width:20px;height:24px;float:right;">
					
				</div>
				<div class="b2b_dingdanjianshi_2_1 ">
					您好:admin&nbsp;&nbsp;<span>请实时注意最新订单动向</span>&nbsp;&nbsp;单位:中航在线	
				</div>
			</div>
		</div>
		<div class="clear">
		</div>
		<div style="width:100%;height:10px;">
					
		</div>
		<div class="b2b_dingdanjianshi_hengxian">
		</div>
		<div style="width:100%;height:20px;">
					
		</div>
		<div class="clear">
		</div>
		<div class="b2b_dingdanjianshi_dingdan">
			<h2>
				<li>
				
				<a href='b2bticketorder.action?s_orderstatus=2&ty=1' style='text-decoration:none;' target='member' >待出票订单(<ww:property value="daichupiaoticket"/>)</a>
				</li>
				<li>
					<a href='b2bticketorder.action?s_orderstatus=4&ty=12&' style='text-decoration:none;' target='member' >申请退票订单(<ww:property value="tuiticket"/>)</a>
				</li>
				<li>
					<a href='b2bticketorder.action?s_orderstatus=5&ty=3&' style='text-decoration:none;' target='member' >申请废票订单(<ww:property value="feiticket"/>)</a>
				</li>
				<li>
					<a href='b2bticketorder.action?s_orderstatus=13&ty=9&' style='text-decoration:none;' target='member' >申请改签订单(<ww:property value="gaiqianticket"/>)</a>
				</li>
				<li>
					<a href='ofcard!toRechargeOrder.action?s_psystatus=1' style='text-decoration:none;' target='member' >手机充值订单(<ww:property value="telnum"/>)</a>
				</li>
				<li>
					<a href='ofcard!toQmoneyRechargeOrder.action?s_psystatus=1' style='text-decoration:none;' target='member' >QB充值订单(<ww:property value="qbnum"/>)</a>
				</li>
				<li>
					<a href='b2bticketorder.action?s_orderstatus=27&ty=1' style='text-decoration:none;' target='member' >待确认订单(<ww:property value="daiquerenticket"/>)</a>
				</li>
				
				
			</h2>
			<div style="width:100%;height:5px;">			
			</div>
			<div class="b2b_dingdanjianshi_dingdan_div">
				<ul>
		
					表格由我来美化， 待处理订单弹出页面在这个页面弹出 作为单独的页面避免JS兼容问题
					
				</ul>
			</div>
		</div>
	</body>
</html>

<script>
window.parent.document.getElementById('mainFrame').cols=  "0,6,*";

</script>
