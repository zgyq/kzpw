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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>燃油费机建费表列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>

</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="airfee.action">

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr >
						<td valign="top" style="color: red">
						操作提示：<br />
						1.出票方每张将加收20元服务费,退票不退回；<br />
						2.婴儿票规定的年龄为：0-2岁。以起飞日期为准；<br />
						3.票面价经济舱以下为Y舱票价的10%，头等或公务为成人票价的10%,不收机建费与燃油税；<br />
						4.成人与婴儿为两个订单，在同一订座记录中，如果成人提交了退改签，婴儿票也需要提交一次。<br />
						5.操作步骤：录入婴儿资料==>支付票款==>等待出票==>出票完成<br />
						
						</td>
					</tr>
					
					<tr>
						<td  valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
											<tr align="center">
												<td class="table_color">婴儿姓名:<input type="text" id="h_name" name="h_name" />  </td>
												<td class="table_color">身份证(出生日期):<input type="text" id="h_birthday" name="h_birthday" />  </td>
												<td class="table_color">保险:<select name="h_insurance" id="h_insurance">
												<option value="0">0</option>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												</select> </td>
												<!--
												<td class="table_color">出生日期:(格式:20100808)<input type="text" id="h_birthday" name="h_birthday" />  </td>
												-->
											</tr>
											<input type="hidden" id="s_orderid"  name="s_orderid" value="<ww:property value='s_orderid' />"/>
									</tbody>
								</table>
								</td>
							</tr>
							<tr>
							<td align="center">
							
							<input type="button" value="添加婴儿票" id="addrt" onclick="createRTorder();"  />
							</td>
							</tr>
							
							
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


<script language="JavaScript">
	function toadd(){
		window.location="airfee!toadd.action?<ww:property value="url"/>";
	}
function createRTorder(){
var h_name=$("#h_name").val();
var h_birthday=$("#h_birthday").val();
if(h_name==''){
alert("婴儿姓名不能为空!");
return;
}
if(h_birthday==''){
alert("婴儿出生日期不能为空!");
return;
}


alert("正在为你创建婴儿订单!!!");
$("#addrt").hide();

       $.ajax({
            type:"POST",
            url:"b2bticketorder!CreateYEOrder.action",
            data:{s_orderid:$("#s_orderid").val(),h_name:h_name,h_birthday:h_birthday},
           // beforeSend:function(){$("#pnrinfo").html("<img src='images/loadpnr.gif' /><font color='00ff00'><b>正在创建儿童票.....</b></font>");},             
            success:function(data){
           if(data=='-1'){
           alert("网络错误!!!");
           $("#addrt").show();
           }else if(data=='-2'){
           alert("PNR创建失败!!!");
           $("#addrt").show();
           }else{
            alert("婴儿订单已经创建!!!请及时支付!!!");
           //window.location.href="b2bticketorder.action";
             window.location.href="b2bticketorder.action?s_orderid="+data;
           }
            
            }            
            });

}

</script>




