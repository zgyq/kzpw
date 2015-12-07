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
//正整数
function isPInt(str) {
    var g = /^[1-9]*[1-9][0-9]*$/;
    return g.test(str);
}
//整数
function isInt(str)
{
    var g=/^-?\d+$/;
    return g.test(str);
}

   function setrebaterule()
   {
       var agentid=$("#agentid").val();
       var flag="0";
       var flag1="0";

       var benji=$("#benji").val();
       var xiaji=$("#xiaji").val();
       
       
       var benji2=$("#benji2").val();
       var xiaji2=$("#xiaji2").val();
       
       //alert(varvalues);
       if(!isPInt(benji)){
      // alert("请输入正整数!!");
      // return;
       }
        if(!isPInt(xiaji)){
       alert("请输入正整数!!");
       return ;
       }
       if(!isPInt(xiaji2)){
       alert("请输入正整数!!");
       return ;
       }
       if(parseFloat(xiaji)>30){
        alert("不可大于30元!");
        return ;
       }
        if(parseFloat(xiaji2)>20){
        alert("不可大于20元!");
        return ;
       }
       
      //机票业务
      if(parseFloat(benji)>parseFloat(xiaji)||parseFloat(benji2)>parseFloat(xiaji2))
      {
          alert("下级保险不可低于成本价格，请重新填写！");
          return ;
      }
       else
       {
      
         $.ajax({
         type:"POST",
         url:"login!updatebaoxian.action",
         data:{c_agentid:agentid,xiajibaoxian:xiaji,xiajibaoxian2:xiaji2},
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;保险设置</span></b></td>
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
										<td  width="10%" align="center"><b>30保险设置</b></td>
										<td  width="10%" align="center"><b>20保险设置</b></td>
									</tr>
									
									<tr id="tr_agenttypeid_0">
										<td  align="center"><b>本级保险价格</b></td>
										<td  align="center"><input type="text" disabled="disabled" style="width:40px" id="benji" value='<ww:property value="benjibaoxian" />' /></td>
										<td  align="center"><input type="text" disabled="disabled" style="width:40px" id="benji2" value='<ww:property value="benjibaoxian2" />' /></td>
										
										</tr>
									<tr id="tr_agenttypeid_1">
									
										<td  align="center"><b>设置当前保险价格</b></td>
										<td  align="center"><input type="text" style="width:40px" id="xiaji" value='<ww:property value="xiajibaoxian" />' /></td>
										<td  align="center"><input type="text" style="width:40px" id="xiaji2" value='<ww:property value="xiajibaoxian2" />' /></td>
										
										</tr>
									
										<input type="hidden" style="width:40px" id="agentid" value='<ww:property value="c_agentid" />' />
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


