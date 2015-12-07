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
<title>返佣规则列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript">
   function setrebaterule()
   {
       var varvalues="";
       var flag="0";
       var flag1="0";
       $("input[id*='txtrebate_']").each(function(i)
       {
          if($(this).val()=="")
          {
             flag="1";
          }
          if(!IsNumber($(this).val()))
          {
            flag="2";
          }
          varvalues+=$(this).attr("id")+"@"+$(this).val()+"#";
       }
       );
       
       
       //alert(varvalues);
       
       
      //机票业务
      if(parseFloat($("#txtrebate_0_1").val())+parseFloat($("#txtrebate_1_1").val())+parseFloat($("#txtrebate_2_1").val())+parseFloat($("#txtrebate_4_1").val())+parseFloat($("#txtrebate_5_1").val())!=1)
      {
         // alert("机票业务的返佣比例总和不等于1(即不等于100%)，请重新填写！");
        //   return false;
      }
      
      //酒店业务
      //var hoteltotal=parseFloat($("#txtrebate_0_2").val())+parseFloat($("#txtrebate_1_2").val())+parseFloat($("#txtrebate_2_2").val())+parseFloat($("#txtrebate_4_2").val())+parseFloat($("#txtrebate_5_2").val());
      //if(hoteltotal!=1)
      //{
      //     alert("国内酒店业务的返佣比例总和不等于1(即不等于100%)，请重新填写！");
      //     return false;
      //}
      //旅游业务
      //if(parseFloat($("#txtrebate_0_3").val())+parseFloat($("#txtrebate_1_3").val())+parseFloat($("#txtrebate_2_3").val())+parseFloat($("#txtrebate_4_3").val())+parseFloat($("#txtrebate_5_3").val())!=1)
      //{
      //     alert("国际酒店业务的返佣比例总和不等于1(即不等于100%)，请重新填写！");
      //     return false;
      //}
      //租车业务
      //if(parseFloat($("#txtrebate_0_4").val())+parseFloat($("#txtrebate_1_4").val())+parseFloat($("#txtrebate_2_4").val())+parseFloat($("#txtrebate_4_4").val())+parseFloat($("#txtrebate_5_4").val())!=1)
      //{
       //    alert("租车业务的返佣比例总和不等于1(即不等于100%)，请重新填写！");
      //     return false;
      //}
       //充值业务
     // if(parseFloat($("#txtrebate_0_5").val())+parseFloat($("#txtrebate_1_5").val())+parseFloat($("#txtrebate_2_5").val())+parseFloat($("#txtrebate_4_5").val())+parseFloat($("#txtrebate_5_5").val())!=1)
     // {
     //      alert("充值业务的返佣比例总和不等于1(即不等于100%)，请重新填写！");
     //      return false;
     // }
      //if(parseFloat($("#txtrebate_0_6").val())+parseFloat($("#txtrebate_1_6").val())+parseFloat($("#txtrebate_2_6").val())+parseFloat($("#txtrebate_4_6").val())+parseFloat($("#txtrebate_5_6").val())!=1)
      //{
       //    alert("火车票业务的返佣比例总和不等于1(即不等于100%)，请重新填写！");
      //     return false;
      //}
       if(flag=="1")
       {
          alert("返佣比例不能为空，请重新填写!");
          return false;
       }
       else if(flag=="2")
       {
          alert("返佣比例必须为小数，请重新填写!");
          return false;
       }
       else
       {
         $.ajax({
         type:"POST",
         url:"rebaterule!updaterule.action",
         data:{s_value:varvalues},//,s_jjrenrebate:$("#txtjjrenrebate").val()
         beforeSend:function(){},             
         success:function(data){
            alert("更新成功!");
         }            
         });
        }
       
   }
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;返佣规则列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="rebaterule.action">

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td align="center">
								<table width="95%" cellspacing="0" cellpadding="0" border="1" style="border-right: 1px solid #fff;border-left: 1px solid #fff;border-top: 1px solid #fff; border-collapse:collapse " >
									<tr>
										<!--<td width="3%">&nbsp;</td>-->
										<td colspan="2" align="left"><span style="color:red"></span></td>
										
										
									</tr>
									<tr>
										<td  width="10%" align="center">&nbsp;</td>
										<td  width="10%" align="center"><b>加盟费返佣规则</b></td>
										<!-- <td  width="10%" align="center"><b>国内酒店业务</b></td> -->
										<!-- <td  width="10%" align="center"><b>国际酒店业务</b></td> -->
										<!-- <td  width="10%" align="center"><b>租车业务</b></td> -->
										<!--  <td  width="10%" align="center"><b>充值业务</b></td>-->
									    <!--  <td  width="10%" align="center"><b>火车票业务</b></td> -->
									</tr>
									
									<tr id="tr_agenttypeid_0">
										<td  align="center"><b>一级代理返佣</b></td>
										<td  align="center"><input type="text" style="width:40px" id="txtrebate_0_1" value='<ww:property value="getrebatevalue(0,1,listRebaterule)" />' /></td>
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_0_2" value='<ww:property value="getrebatevalue(0,2,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_0_3" value='<ww:property value="getrebatevalue(0,3,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_0_4" value='<ww:property value="getrebatevalue(0,4,listRebaterule)" />' /></td>-->
										<!--  <td  align="center"><input type="text" style="width:40px" id="txtrebate_0_5" value='<ww:property value="getrebatevalue(0,5,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_0_6" value='<ww:property value="getrebatevalue(0,6,listRebaterule)" />' /></td>-->
									</tr>
									<tr id="tr_agenttypeid_1">
										<td  align="center"><b>二级代理返佣</b></td>
										<td  align="center"><input type="text" style="width:40px" id="txtrebate_1_1" value='<ww:property value="getrebatevalue(1,1,listRebaterule)" />' /></td>
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_1_2" value='<ww:property value="getrebatevalue(1,2,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_1_3" value='<ww:property value="getrebatevalue(1,3,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_1_4" value='<ww:property value="getrebatevalue(1,4,listRebaterule)" />' /></td>-->
										<!-- <td  align="center"><input type="text" style="width:40px" id="txtrebate_1_5" value='<ww:property value="getrebatevalue(1,5,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_1_6" value='<ww:property value="getrebatevalue(1,6,listRebaterule)" />' /></td>-->
									</tr>
									<tr id="tr_agenttypeid_2">
										<td  align="center"><b>三级代理返佣</b></td>
										<td  align="center"><input type="text" style="width:40px" id="txtrebate_2_1" value='<ww:property value="getrebatevalue(2,1,listRebaterule)" />' /></td>
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_2_2" value='<ww:property value="getrebatevalue(2,2,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_2_3" value='<ww:property value="getrebatevalue(2,3,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_2_4" value='<ww:property value="getrebatevalue(2,4,listRebaterule)" />' /></td>-->
										<!--  <td  align="center"><input type="text" style="width:40px" id="txtrebate_2_5" value='<ww:property value="getrebatevalue(2,5,listRebaterule)" />' /></td>-->
										<!--<td  align="center"><input type="text" style="width:40px" id="txtrebate_2_6" value='<ww:property value="getrebatevalue(2,6,listRebaterule)" />' /></td>-->
									</tr>
									
									
									
									<tr id="tr_agenttypeid_3">
										<td  align="center"><b>服务费</b></td>
										<td  align="center"><input type="text" style="width:40px" id="txtrebate_3_1" value='<ww:property value="getrebatevalue(3,1,listRebaterule)" />' /></td>
									</tr>
									
								</table>
								</td>
							</tr>
							<tr>
								<td align="center" height="20px"></td>
							</tr>
							<tr>
								<td align="center"><input type="button" id="submitreg"
									class="button_d font-bai" value="修改" onclick="return setrebaterule();" /></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%"> </td>
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


