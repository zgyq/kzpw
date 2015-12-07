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
<title><ww:if test="customeragent.id>0">编辑</ww:if><ww:else>新增</ww:else>加盟商信息表</title>
<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
</head>
<script>
$(document).ready(function() {

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

function check(){

var obj=document.getElementById("se");
var va=obj.options[obj.selectedIndex].value;
if(va==1){
document.getElementById("sp").innerHTML="‰";
document.getElementById("runvalue").className="validate[custom[onlyNumber]]";
}
if(va==2){
document.getElementById("sp").innerHTML="元";
document.getElementById("runvalue").className="validate[custom[onlyNumber]]";
}
if(va==3){
document.getElementById("sp").innerHTML="";
document.getElementById("runvalue").className="";
}

}
function disablerdo()
{

    if(document.getElementById("rdoagentisenable").checked)
    {
        document.getElementById("rdologinyes").disabled=true;
        document.getElementById("rdologinno").disabled=true;
    }else{
   	    document.getElementById("rdologinyes").disabled=false;
        document.getElementById("rdologinno").disabled=false;
    }
}
$(document).ready(function(){
   if(document.getElementById("rdoagentisenable").checked)
    {
        document.getElementById("rdologinyes").disabled=true;
        document.getElementById("rdologinno").disabled=true;
    }

});
</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="customeragent.id>0">编辑</ww:if><ww:else>新增</ww:else>代理商信息表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customeragent!<ww:if test="customeragent.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST" id="form1"
			>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="88%" style="padding-top: 10px;">
				<table width="88%" cellpadding="0" cellspacing="0" border="1" bordercolor="#a0cfee" style="margin: 0 auto; border-collapse: collapse;">

					<tr><td colspan="4">
					<div style="padding-left: 20px;"><img src="images/fenge.gif" align="absmiddle">基本信息</div>
					</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>客户类型：</span></div></td>
						<td>
						&nbsp;<select name="agentcityid" style="width:150px">
						<option value=""></option>
						<option value="1" <ww:if test="customeragent.agentcityid==1">selected</ww:if> >A类</option>
						<option value="2" <ww:if test="customeragent.agentcityid==2">selected</ww:if> >B类</option>
						<option value="3" <ww:if test="customeragent.agentcityid==3">selected</ww:if> >C类</option>
						</select>
						</td>
						<td class="table_color colortrin" style="text-align: right;"><div class="td_color"><span>经纪人：</span></div></td>
						<td>
						&nbsp;<select name="userid" style="width:150px">
						<option value="0"></option>
						<ww:iterator value="listCustomeruser">
						<option value="<ww:property value="id"/>" <ww:if test="id==customeragent.userid">selected</ww:if>><ww:property value="membername"/></option>
						</ww:iterator>
						
						</select></td>
					</tr>
					<tr>
						<td height="28" align="right"><div class="td_color">代码：</div></td>
						<td class="table_color_l"><input type="text" name="code" id="code" desc="代码" class="validate[required,ajax[ajaxCode]]"
							value='<ww:property value="customeragent.code"/>'
							style="width: 150px" />*</td>
							<td height="28" style="text-align: right;"  ><div class="td_color"><span>状态：</span></div></td>
						<td >&nbsp;&nbsp;
							<ww:if test="customeragent.id>0">
								<input type="radio" name="agentisenable" value="1"  onclick="disablerdo();" <ww:if test="customeragent.agentisenable==1">checked</ww:if>  />启用&nbsp;
								<input type="radio" name="agentisenable" id="rdoagentisenable" onclick="disablerdo();" value="0" <ww:if test="customeragent.agentisenable==0">checked</ww:if> />禁用
							</ww:if> 
							<ww:else>
								<input type="radio" name="agentisenable" value="1" onclick="disablerdo();"/>启用&nbsp;
								<input type="radio" name="agentisenable" id="rdoagentisenable" onclick="disablerdo();" value="0"/>禁用
							</ww:else>
						</td>
							
							<!--
						<td height="28" align="right" style="text-align: right;"  class="table_color colortrin"><span>加盟商类型：</span></td>
						<td class="table_color_l">
						<ww:if test="type==0">
							<select name="agenttype">
								<option value="1"
									<ww:if test="customeragent.agenttype==1">selected</ww:if> >运营商</option>
								<option value="2"
									<ww:if test="customeragent.agenttype==2">selected</ww:if>>供应商</option>
								<option value="3"
									<ww:if test="customeragent.agenttype==3">selected</ww:if>>分销商</option>
							</select>
						</ww:if>
						<ww:if test="type==2">
								<ww:if test="customeragent.agenttype==1">运营商</ww:if>
								<ww:if test="customeragent.agenttype==2">供应商</ww:if>
								<ww:if test="customeragent.agenttype==3">分销商</ww:if>
							
						</ww:if>
								
	 					-->
					</tr>
					
					<tr>
						<td height="28" align="right" style="text-align: right;" width="130"   ><div class="td_color"><span>有效期开始时间：</span></div></td>
						<td class="table_color_l"><input type="text" name="c_agentvsdate"
							value='<ww:property value="formatDate(customeragent.agentvsdate)"/>'
							style="width: 150px"  onfocus="WdatePicker()" class="Wdate"/></td>
							
					<td height="28" align="right" style="text-align: right;" width="130" ><div class="td_color"><span>有效期结束时间：</span></div></td>
						<td class="table_color_l"><input type="text" name="c_agentvedate"
							value='<ww:property value="formatDate(customeragent.agentvedate)"/>'
							style="width: 150px" onfocus="WdatePicker()" class="Wdate"/></td>
					</tr>
					
					<tr>
						<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>单位名称：</span></div></td>
						<td class="table_color_l"><input type="text" name="agentcompanyname" id="agentcompanyname" desc="单位名称" class="validate[required]"
							value='<ww:property value="customeragent.agentcompanyname"/>'
							style="width: 150px" />*<span id="agentcompanyname2"></span></td>
					<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>单位简称：</span></div></td>
						<td class="table_color_l"><input type="text" name="agentshortname"
							value='<ww:property value="customeragent.agentshortname"/>'
							style="width: 150px" /></td>
					</tr>
					
					<tr>
							<td height="28" style="text-align: right;"  ><div class="td_color"><span>公司网址：</span></div></td>
						<td class="table_color_l"><input type="text"  name="website"
							value='<ww:property value="customeragent.website"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;" ><div class="td_color"><span>单位电话：</span></div></td>
						<td class="table_color_l"><input type="text" name="agenttel" id="agenttel" 
							value='<ww:property value="customeragent.agenttel"/>'
							style="width: 150px" /><span id="agenttel2"></span></td>
					</tr>
				
					<tr>
						<td height="28" style="text-align: right;"  ><div class="td_color"><span>通信地址：</span></div></td>
						<td class="table_color_l"><input type="text" name="agentaddress" id="agentaddress" 
							value='<ww:property value="customeragent.agentaddress"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>邮政编码：</span></div></td>
						<td class="table_color_l"><input type="text" name="agentpostcode" id="agentpostcode" 
							value='<ww:property value="customeragent.agentpostcode"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;"  ><div class="td_color"><span>所属行业：</span></div></td>
						<td class="table_color_l"><input type="text" name="industry" id="industry"
							value='<ww:property value="customeragent.industry"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;"  class="table_color colortrin">是否允许登录</td>
						<td class="table_color_l">
						&nbsp;&nbsp;
						<input type="radio" name="isallowlogin" id="rdologinyes" value="1"
						 <ww:if test="customeragent.isallowlogin==1">checked="checked"</ww:if> />是&nbsp;
						<input type="radio" id="rdologinno" 
						 <ww:if test="customeragent.isallowlogin==0||customeragent.isallowlogin==null">checked="checked"</ww:if> name="isallowlogin" value="0" />否
						</td>
					</tr>
					<tr><td colspan="4" style="padding-left: 20px;">
					<div><img src="images/fenge.gif" align="absmiddle">联系人信息</div>
					</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;" ><div class="td_color"><span>业务联系人：</span></div></td>
						<td class="table_color_l"><input type="text"  name="agentcontactname" id="agentcontactname" desc="业务联系人" class="validate[required]"
							value='<ww:property value="customeragent.agentcontactname"/>'
							style="width: 150px" />*</td>
					<td height="28" style="text-align: right;"  ><div class="td_color"><span>业务联系人邮箱：</span></div></td>
						<td class="table_color_l"><input type="text" name="agentemail" id="agentemail" 
							value='<ww:property value="customeragent.agentemail"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;" ><div class="td_color"><span>业务联系人工作电话：</span></div></td>
						<td class="table_color_l"><input type="text"  name="agentphone" id="agentphone" desc="业务联系人工作电话" class="validate[required,custom[onlyNumber]]"
							value='<ww:property value="customeragent.agentphone"/>'
							style="width: 150px" />*</td>
					<td height="28" style="text-align: right;"  ><div class="td_color"><span>业务联系人传真：</span></div></td>
						<td class="table_color_l"><input type="text" name="agenrfax" id="agenrfax"
							value='<ww:property value="customeragent.agenrfax"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;" ><div class="td_color"><span>业务联系人移动电话：</span></div></td>
						<td class="table_color_l"><input type="text"  name="agentmobile" id="agentmobile"
							value='<ww:property value="customeragent.agentmobile"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;"  ><div class="td_color"><span>MSN或QQ：</span></div></td>
						<td class="table_color_l"><input type="text"  name="msnqq"
							value='<ww:property value="customeragent.msnqq"/>'
							style="width: 150px" /></td>
							
					</tr>
					<tr><td colspan="4" style="padding-left: 20px;">
					<div><img src="images/fenge.gif" align="absmiddle">财务人员信息</div>
					</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;" ><div class="td_color"><span>财务联系人：</span></div></td>
						<td class="table_color_l"><input type="text"  name="financename" id="financename"
							value='<ww:property value="customeragent.financename"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;"  ><div class="td_color"><span>财务工作电话：</span></div></td>
						<td class="table_color_l"><input type="text" name="financephone" id="financephone"
							value='<ww:property value="customeragent.financephone"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;" ><div class="td_color"><span>财务传真号码：</span></div></td>
						<td class="table_color_l"><input type="text"  name="financefax" id="financefax"
							value='<ww:property value="customeragent.financefax"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;"  ><div class="td_color"><span>财务移动电话：</span></div></td>
						<td class="table_color_l"><input type="text" name="financemobile" id="financemobile"
							value='<ww:property value="customeragent.financemobile"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;" ><div class="td_color"><span>财务电子邮件：</span></div></td>
						<td class="table_color_l"><input type="text"  name="financeemail" id="financeemail"
							value='<ww:property value="customeragent.financeemail"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;"  ><div class="td_color"><span>其他方式(QQ、MSN)：</span></div></td>
						<td class="table_color_l"><input type="text" name="financeother" id="financeother"
							value='<ww:property value="customeragent.financeother"/>'
							style="width: 150px" /></td>
					</tr>
					<tr><td colspan="4" style="padding-left: 20px;">
					<div><img src="images/fenge.gif" align="absmiddle">账号信息</div>
					</td>
					</tr>				
					<tr>
						<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>支付宝账号：</span></div></td>
						<td class="table_color_l"><input type="text"  name="alipayaccount"
							value='<ww:property value="customeragent.alipayaccount"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>财付通账号：</span></div></td>
						<td class="table_color_l"><input type="text"  name="tenpayaccount"
							value='<ww:property value="customeragent.tenpayaccount"/>'
							style="width: 150px" /></td>
					</tr>
				
					<tr>
						<td height="28" style="text-align: right;"  ><div class="td_color"><span>快钱账号：</span></div></td>
						<td class="table_color_l"><input type="text"  name="kuaibillaccount"
							value='<ww:property value="customeragent.kuaibillaccount"/>'
							style="width: 150px" /></td>
					
					</tr>
					<tr><td colspan="4" style="padding-left: 20px;">
					<div><img src="images/fenge.gif" align="absmiddle">编码信息</div>
					</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>分润类型：</span></div></td>
						<td class="table_color_l">
						<select name="runtype" id="se" onchange="check();">
						<option value="3" <ww:if test="customeragent.runtype==3">selected</ww:if> >不分润</option>
						<option value="1" <ww:if test="customeragent.runtype==1">selected</ww:if> >按千分比</option>
						<option value="2" <ww:if test="customeragent.runtype==2">selected</ww:if> >按票数</option>
						
						</select>
					
						</td>
					<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>分润值：</span></div></td>
						<td class="table_color_l"><input type="text"  name="runvalue" id="runvalue" desc="分润值" 
							value='<ww:property value="customeragent.runvalue"/>'
							style="width: 150px" />
							<span id="sp"></span>
							</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>东航编码：</span></div></td>
						<td class="table_color_l"><input type="text"  name="mucode"
							value='<ww:property value="customeragent.mucode"/>'
							style="width: 150px" /></td>
					<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>南航编码：</span></div></td>
						<td class="table_color_l"><input type="text"  name="czcode"
							value='<ww:property value="customeragent.czcode"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"><span>国航编码：</span></div></td>
						<td class="table_color_l"><input type="text"  name="cacode"
							value='<ww:property value="customeragent.cacode"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;"  class="table_color colortrin"><div class="td_color"></div></td>
						<td class="table_color_l">
						
						</td>
					</tr>
					
					<input type="hidden" name="bigtype" value="1"/>
					<input type="hidden" name="agenttype" value="3"/>		
					<!--<tr>
						<td height="28" style="text-align: right;" ><span>审核状态：</span></td>
						<td><input type="text" name="agentcheckstatus"
							value='<ww:property value="customeragent.agentcheckstatus"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;" ><span>父ID：</span></td>
						<td><input type="text" name="parentid"
							value='<ww:property value="customeragent.parentid"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;" ><span>父ID串：</span></td>
						<td><input type="text" name="parentstr"
							value='<ww:property value="customeragent.parentstr"/>'
							style="width: 150px" /></td>
					-->
					<tr class="font-blue-xi" >
						<td height="54"colspan="4" align="center">
						<input type="submit" id="submitreg"
							class="button_d font-bai" value="提交" /> 
							&nbsp;&nbsp;&nbsp;
					<input type="button"
							class="button_d font-bai"
							onclick="window.location.href='customeragent!tobiguser.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " />
						
						</td>
						
					</tr>
					
				</table>
				</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
		</table>
		</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>


