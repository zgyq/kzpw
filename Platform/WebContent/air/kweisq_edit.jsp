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
<title><ww:if test="kweisq.id>0">编辑</ww:if><ww:else>新增</ww:else>K位特价申请表</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<script>
$(document).ready(function() {
	 add();
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

 function ltrim(s){  return s.replace(/[\s\r\n　]*/g, '');  }  
 function rtrim(s){  return s.replace(/[\s\r\n　]*/g, '');  }  
 function trim2(s){ 
 alert(s);
 alert(ltrim(s));
  return ltrim(s); 
  
   }  
 function trim(str){ //删除左右两端的空格 
return str.replace(/(^\s*)|(\s*$)/g, ""); 
} 
 



	function add() {
	var chengren = "0"
	var ertong = "0";
	var yinger = "0";
	
	var chengren2 = document.getElementById("chengren").value;

	
	var ertong2 = document.getElementById("ertong").value;
	var yinger2 = document.getElementById("yinger").value;
	
	 
          chengren=parseInt(chengren);
          if(trim(chengren2)!="")
          {
            chengren+=parseInt(chengren2); 
          }
	 	ertong=parseInt(ertong);
          if(trim(ertong2)!="")
          {
            ertong+=parseInt(ertong2); 
          }
           yinger=parseInt(yinger);
          if(trim(yinger2)!="")
          {
            yinger+=parseInt(yinger2); 
          }
	
	
	
	
	document.getElementById("peoplenumber").value = parseInt(chengren)+parseInt(ertong)+parseInt(yinger);
	
	document.getElementById("peoplenumber2").value = parseInt(chengren)+parseInt(ertong)+parseInt(yinger);			
				}

</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="kweisq.id>0">编辑</ww:if><ww:else>新增</ww:else>K位特价申请表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="kweisq!<ww:if test="kweisq.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST" id="form1"
			>



		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="96%" cellpadding="0" cellspacing="0" border="1" bordercolor="#a0cfee" style="border-collapse: collapse; margin: 0 auto; margin-top: 20px;">
					
					<!--
	 <tr><td height="28" align="right"><span>供应商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="供应商ID不能为空" name="angenid" value='<ww:property value="kweisq.angenid"/>'" style="width:350px" /></td>  </tr>
	 <tr><td height="28" align="right"><span>分销商ID：</span></td><td><input type="text" require="true" dataType="Require"   msg="分销商ID不能为空" name="distributorid" value='<ww:property value="kweisq.distributorid"/>'" style="width:350px" /></td>  </tr>
	 -->

					<tr>
						<td height="28" class="tbody_color" align="right"><span>成人人数：</span></td>
						<td width="30%">&nbsp;&nbsp;<input type="text" require="true" dataType="Require"
							msg="乘机人数不能为空" name="chengren" id="chengren"  desc="成人人数" class="validate[required],custom[onlyNumber]"
							value='<ww:property value="kweisq.chengren"/>' onblur="add()"
							" style="width: 130px" />&nbsp;&nbsp;如果没有.填写0</td>
					
						<td height="28" align="right" class="tbody_color"><span>儿童人数：</span></td>
						<td>&nbsp;&nbsp;<input type="text" require="true" dataType="Require"  desc="儿童人数" class="validate[required],custom[onlyNumber]"
							msg="乘机人数不能为空" name="ertong" id="ertong" onblur="add()"
							value='<ww:property value="kweisq.ertong"/>'
							" style="width: 130px" />&nbsp;&nbsp;如果没有.填写0</td>
					</tr>
					<tr>
						<td height="28" align="right" class="tbody_color"><span>婴儿人数：</span></td>
						<td>&nbsp;&nbsp;<input type="text" require="true" dataType="Require"  desc="婴儿人数" class="validate[required],custom[onlyNumber]"
							msg="乘机人数不能为空" name="yinger" id="yinger" onblur="add()"
							value='<ww:property value="kweisq.yinger"/>'
							" style="width: 130px" />&nbsp;&nbsp;如果没有.填写0</td>
					
						<td height="28" align="right" class="tbody_color"><span>乘机人数：</span></td>
						<td>&nbsp;&nbsp;<input type="text" require="true" dataType="Require"  
							msg="乘机人数不能为空" name="" id="peoplenumber" disabled="disabled"
							value='<ww:property value="kweisq.peoplenumber"/>'
							" style="width: 130px" /></td>
					</tr>
			<input type="hidden" require="true" dataType="Require"  
							msg="乘机人数不能为空" name="peoplenumber" id="peoplenumber2" 
							 style="width: 130px" />

					<tr>
						<td height="28" align="right" class="tbody_color"><span>联系人姓名：</span></td>
						<td>&nbsp;&nbsp;<input type="text" require="true" dataType="Require"  desc="联系人姓名" class="validate[required]"
							msg="联系人姓名不能为空" name="username" id="username"
							value='<ww:property value="kweisq.username"/>'
							" style="width: 130px" /></td>
				
						<td height="28" align="right" class="tbody_color"><span>联系人手机：</span></td>
						<td>&nbsp;&nbsp;<input type="text" require="true" dataType="Require"  desc="手机号码" class="validate[required,custom[mobile]]"
							msg="联系人手机不能为空" name="mobile" id="mobile"
							value='<ww:property value="kweisq.mobile"/>'
							" style="width: 130px" /></td>
					</tr>



					<tr>
						<td height="28" align="right" class="tbody_color"><span>联系人邮箱：</span></td>
						<td>&nbsp;&nbsp;<input type="text" require="true" dataType="Require"   desc="电子邮箱" class="validate[required,custom[email]]"
							msg="联系人邮箱不能为空" name="postbox"  id="postbox" 
							value='<ww:property value="kweisq.postbox"/>'
							" style="width: 130px" /></td>
					
						<td height="28" align="right" class="tbody_color"><span>备注：</span></td>
						<td>&nbsp;&nbsp;<input type="text" require="true" dataType="Require"  desc="备注" class="validate[required]"
							msg="备注不能为空" name="comment" id="comment"
							value='<ww:property value="kweisq.comment"/>'
							" style="width: 130px" /></td>
					</tr>
					<!--
	 <tr><td height="28" align="right"><span>状态：</span></td><td><input type="text" require="true" dataType="Require"   msg="状态不能为空" name="status" value='<ww:property value="kweisq.status"/>'" style="width:130px" /></td>  </tr>
	 -->

					<input type="hidden" require="true" dataType="Require"
						msg="K位信息ID不能为空" name="kid" value='<ww:property value="kid"/>'
						" style="width: 130px" />


					<!--<tr><td height="28" align="right"><span>修改时间：</span></td><td><input type="text" require="true" dataType="Require"   msg="修改时间不能为空" name="updatetime" value='<ww:property value="kweisq.updatetime"/>'" style="width:350px" /></td>  </tr>
	 <tr><td height="28" align="right"><span>修改者：</span></td><td><input type="text" require="true" dataType="Require"   msg="修改者不能为空" name="updateuser" value='<ww:property value="kweisq.updateuser"/>'" style="width:350px" /></td>  </tr>
      -->
					<tr class="font-blue-xi">
						
						<td height="46" colspan="4" align="center"><input type="submit" id="submitreg"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="javascript:history.go(-1);"
							name="Submit2" value=" 返回 " /></td>
					</tr>

				</table>
				</td>
			</tr>
		</table>

   <div style="padding-left: 30px;"><b style="color:#ff0000">K位特价申请</b>  <br/>
   需K位的特价票采购前要提交申请，供票审核通过后可进行支付，所以预定需K位的特价票，<br/>请耐心等待1-5分钟等待供票商回复，感谢您的支持！特价票客服专线4001-968-968 
<br/>
<b style="color:#ff0000">特价申请管理 </b> <br/>
   特价申请管理可查看已申请的特价订单最新情况，需审核的特价如审核通过，请及时支付，以便供票商出票。  

</div>



		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


