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
<title>租车订单详细信息
		</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>

<body>
<div id="member">
<form action="carorder
		!<ww:if test="carorder
		.id>0">edit.action?id=<ww:property value="carorder
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;租车订单详细信息
		</span></b></td>
	</tr>
		<td align="center">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="font-blue-xi" style=" border-collapse:collapse; ">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
			 
		

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					身份证号码
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.nuber"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					订单属性
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				<ww:if test="carorder.property.equals(\"2\")">前台订单</ww:if>
				<ww:if test="carorder.property.equals(\"1\")">后台订单</ww:if>	
				</td>
		</tr>
		
		<tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					取车门店
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="getcarstorenameByID(carorder.scarstoreid)"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					还车门店
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="getcarstorenameByID(carorder.ecarstoreid)" />
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					汽车名称
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.carname"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					起租日期
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.sdate
						"/>
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					还车日期
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.enddate"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					取车城市
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				<ww:property value="getCityNamebyId(carorder.scityid)"/>
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					还车城市
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="getCityNamebyId(carorder.endcityid)"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					订单总价
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.price
						"/>元
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					预订时间
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="formatTimestamp(carorder.pretime)"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					天数
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.manyday
						"/>天
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					加盟商
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="getAngetNameByUserId(carorder.memberid)"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					会员姓名
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.membername
						"/>
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					会员手机
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.membermobile"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					会员ID
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.memberid
						"/>
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					联系人电邮
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.linkmail"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					订单状态
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="getCarOrderByState(carorder.state)"/>
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					联系人姓名
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
				<ww:property value="carorder.linkname"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					联系人手机
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.linkmobile
						"/>
				</td>
		</tr><!--
	

						 
		 <tr>
				
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					联系人电话
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.linktell
						"/>
				</td>
		</tr>
		--><!--
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					确认方法
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.confirmmethod"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					特殊要求
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.specreq
						"/>
				</td>
		</tr>
		 --><tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					订单编号
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
				<ww:property value="carorder.code"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					订单基本价
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.jprice
						"/>元
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					是否需要GPS
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.gps"/>
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					总保险费
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.insurancefee
						"/>元
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					手续费
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.servicefee"/>元
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					信用卡预授权费用
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.preauthfee
						"/>元
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					GPS费用
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.gpsfee"/>元
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					总里程
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.mile
						"/>公里
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					送车上门费
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.pickupservicefee"/>元
				</td>
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					上门取车费
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.dropoffservicefee
						"/>元
				</td>
		</tr>
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					交通罚单押金
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.ticketfee"/>元
				</td>
		
		<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					外部订单号
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.waicode
						"/>
				</td>
						 
				<!--<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					汽车编号
						:
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
					<ww:property value="carorder.carcode
						"/>
				</td>
		--></tr><!--
	

						 
		 <tr>
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					订单总利润
						:
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					<ww:property value="carorder.orderfee"/>元
				</td>
		<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
					
				</td>
				<td width="10%" height="30" align="left" class="table_color_l">
					
				</td>
		
			
						 
				
		</tr>
		
		--><!--
	

						 
		 <tr>
				
		
	
						 
				<td width="5%" height="30" style="text-align: right;" class="table_color colortrin">
				</td>
				<td width="10%" height="30" class="table_color_l" align="left">
				</td>
		</tr>
	
					

		    
			--><tr>
				<td colspan="4" height="40" bgcolor="ffffff">
				
			
						<ww:if test="carorder.state==1">				
					<input type="button" class="button_d font-bai"
							onclick="checkorder();"
							name="Submit2" value=" 取消 " />	
					<input type="button" class="button_d font-bai"
							onclick="window.location.href='carorder!check.action?orderstate=2&carorder.id=<ww:property value="carorder.id" />';"
							name="Submit2" value=" 已确认 " />		
						</ww:if>	
						
						<ww:if test="carorder.state==2">	
						<input type="button" class="button_d font-bai"
							onclick="window.location.href='carorder!check.action?orderstate=3&carorder.id=<ww:property value="carorder.id" />';"
							name="Submit2" value=" 已取车 " />		
						</ww:if>	
							<ww:if test="carorder.state==3">	
						<input type="button" class="button_d font-bai"
							onclick="window.location.href='carorder!check.action?orderstate=4&carorder.id=<ww:property value="carorder.id" />';"
							name="Submit2" value=" 已还车 " />		
						</ww:if>	
											
				<input type="button" class="button_d font-bai"
							onclick="window.location.href='carorder.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
			</tr>
		</table>
		</td>
		<tr>
		<td>
			&nbsp;
		</td>
		</tr>
</table>
</form>
</div>
</body>
</html>
<script language="JavaScript">
	function checkorder(){
	
						var temp = confirm('确认取消吗？');
						if(temp==true){
						
							window.location="carorder!check.action?orderstate=5&carorder.id=<ww:property value="carorder.id" />";
							
						}
	}
</script>
	