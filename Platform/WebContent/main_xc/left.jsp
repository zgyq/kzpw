<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—商旅平台</title>


		<link rel="stylesheet" type="text/css" href="css/screen.css" />
		<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="js/jquery.cycle.all.min.js"></script>
		<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
		<script type="text/javascript" src="js/jcarousellite_1.0.1.min.js"></script>
		<script type="text/javascript" src="js/jquery.tools.min.js"></script>
</head>
<script type="text/javascript">
			$(document).ready( function(){
				$('.tel_in').mouseover(function(){
					$('.tel_more').css('display','block');
				});
								
				$('.tel_more').mouseover(function(){
					$('.tel_more').css('display','block');
					
				});
				
				$('.tel_more').mouseout(function(){
					$('.tel_more').css('display','none');
				});
				
				$(".nav_list_in").jCarouselLite({
					btnPrev: "#prev",
					btnNext: "#next",
					easing: "easeInOutExpo",
					speed: 1000,
					visible: 4.8,
					scroll: 2,
					circular: false
				});
				
				$('.side_list>li').find('a:first').toggle(function(){
					$(this).next('ul').slideDown();
				}, function(){
					$(this).next('ul').slideUp();
				});
				
				$('.side_btn').click(function(){
					$('.sidebar').toggle();
				});
				
				$(".tab_title").tabs(".tab_cont");
				
			});
			
			function tobase(ba){
//alert(ba);
//var nobsae=atob(ba);
//alert(nobsae);
 parent.member.location.href=ba;
}
		</script>
<body>


<div class="sidebar">
<ul class="side_list">
		<ww:iterator value="listRoot" status="kk">
				<li>
					<a href="#" class="a<ww:property   value="#kk.index+1"/>">><ww:property   value="name"/></a>
					<ul>
					<ww:iterator value="getListSub(id)" id="listServiceItems">
						<li>
						<ww:if test="code.indexOf('http:')!=-1">
									<a href="<ww:property value="code.trim()"/>" target="member" >
									<ww:property value="name" /></a>
									</ww:if><ww:else>
									<a href="#"  onclick="tobase('../<ww:property value="code.trim()"/>');">
									<ww:property value="name" /></a>
									</ww:else>
						</li>
						</ww:iterator>
						
					</ul>
				</li>
		</ww:iterator>		
				</ul>
				
			<!--<ul class="side_list">
				<li>
					<a href="#" class="a1">机票采购</a>
					<ul>
						<li><a href="#">机票采购1</a></li>
						<li><a href="#">机票采购2</a></li>
						<li><a href="#">机票采购3</a></li>
					</ul>
				</li>
				<li>
					<a href="#" class="a2">机票采购管理</a>
					<ul style="display:block;">
						<li><a href="#">国内机票查询</a></li>
						<li><a href="#">国际机票查询</a></li>
						<li><a href="#">团队/包机申请</a></li>
					</ul>
				</li>
				<li>
					<a href="#" class="a3">机票订单管理</a>
					<ul>
						<li><a href="#">机票订单管理1</a></li>
						<li><a href="#">机票订单管理2</a></li>
						<li><a href="#">机票订单管理3</a></li>
					</ul>
				</li>
				<li>
					<a href="#" class="a4">退废票管理</a>
					<ul>
						<li><a href="#">退废票管理1</a></li>
						<li><a href="#">退废票管理2</a></li>
						<li><a href="#">退废票管理3</a></li>
					</ul>
				</li>
				<li>
					<a href="#" class="a5">配送收银订单</a>
					<ul>
						<li><a href="#">配送收银订单1</a></li>
						<li><a href="#">配送收银订单2</a></li>
						<li><a href="#">配送收银订单3</a></li>
					</ul>
				</li>
				
				<li>
					<a href="#" class="a7">帮助中心</a>
					<ul>
						<li><a href="#">帮助中心1</a></li>
						<li><a href="#">帮助中心2</a></li>
						<li><a href="#">帮助中心3</a></li>
					</ul>
				</li>
				<li>
					<a href="#" class="a8">投诉与建议</a>
					<ul>
						<li><a href="#">投诉与建议1</a></li>
						<li><a href="#">投诉与建议2</a></li>
						<li><a href="#">投诉与建议3</a></li>
					</ul>
				</li>		
				</ul>
			
			
			--><div class="side_bank">
				<div class="bank_title">支付宝信息</div>
				<ul>
					<li><a href="https://www.99bill.com/" target="_blank" ><img src="images/bank1.gif" alt=""></a></li>
					<li><a href="https://lab.alipay.com/user/reg/index.htm" target="_blank"  ><img src="images/bank2.gif" alt=""></a></li>
					<li><a href="http://www.chinapnr.com/" target="_blank"  ><img src="images/bank3.gif" alt=""></a></li>
				</ul>
			</div>			
			
		</div>
		
</body>
</html>
