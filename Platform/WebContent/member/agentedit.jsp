<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公司信息</title>
<link href="public/css/left.css" type="text/css" rel="stylesheet" />
<link href="public/css/public.css" type="text/css" rel="stylesheet" />
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="public/css/main.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.val {
	color: red;
}
</style>
<script type="text/javascript">
function saveEdit(){
  if(valform()){
    document.form1.submit();
  }
}
//提交验证
function valform(){
var cname=valCompany();
var shortname=valAgengtshortname();
 var linkname=valLinkname(); 
 var linkm=valLinkmobile(); 
 if(cname&&shortname&&linkname&&linkm){
   return true;
 }else{
  return false;
 }
}

//验证公司名称
function valCompany(){
var cname=true;
var cid=$(".cname").attr("id"); 
 cname=twoval(cid,new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9()\_\u4e00-\u9fa5]'),'公司名称不可包含非法字符',false]},{'data':['ajax','vaidate!validateAgentName.action','此公司名字已存在']}));
return cname;
}
//验证简称
function valAgengtshortname(){
var cname=true;
 cname=twoval('shortname',new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9()\_\u4e00-\u9fa5]'),'公司简称不可包含非法字符',false]}));
return cname;
}

//验证联系人
function valLinkname(){
var link=true;
 link= twoval("contactname",new Array({'data':['required','','不可为空']}));
 return link;
}
//验证联系电话
function valLinkmobile(){
var linkmobile=true;
 var reg=new RegExp(/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0-9]|18[0-9])\d{8}$)/);
  var linkmobile=twoval("agentphone",new Array({'data':['required','','不可为空']},{'data':['regexp',reg,'号码有误（固话加区号或移动电话）',true]}));
 return linkmobile;
}

</script>
<script type="text/javascript">
$(document).ready(function(){
<ww:iterator value="#request.payinfo" status="index">
	$("#pay<ww:property value="id"/>").show();
</ww:iterator>
});
</script>
</head>
<body>
<div id="divpay"></div>
<div id="right">
<div class="lit">
<ul>
	<li class="offwu">公司信息</li>
</ul>
</div>
<div id="main" lang="ca" class="kuang box">
<form id="form1" name="form1"
	action="customeragent!editagentinfo.action" method="post">
<div>
<h2>公司信息</h2>
<div class="biaoti">公司基本信息</div>
<table border="0" cellspacing="0" cellpadding="0" width="100%"
	style="margin-top: 15px;">
	<tr>
		<td width="20%" align="right" class="hei_cu" height="30">公司编码：</td>
		<td width="20%" style="color: black"><ww:property
			value="customeragent.code" /></td>
		<td class="hui_xi"></td>
		<td></td>
	</tr>
	<tr>
		<td width="20%" align="right" class="hei_cu" height="30">公司名称：</td>
		<td width="20%"><input name="customeragent.agentcompanyname"
			value='<ww:property value="customeragent.agentcompanyname"/>'
			type="text" class="cname text_150er text_360"
			id='comname<ww:property value="customeragent.id"/>' /></td>
		<td colspan="2"><font
			id='vcomname<ww:property value="customeragent.id"/>'
			style="color: red"></font></td>
	</tr>

	<tr>
		<td align="right" class="hei_cu" height="30">公司简称：</td>
		<td><input name="customeragent.agentshortname"
			value='<ww:property value="customeragent.agentshortname"/>'
			type="text" class="text_150er text_360" id="shortname" /></td>
		<td colspan="2"><font id='vshortname' style="color: red"></font></td>
	</tr>
	<tr>
		<td align="right" class="hei_cu" height="30">公司电话：</td>
		<td><input name="customeragent.agenttel"
			value='<ww:property value="customeragent.agenttel"/>' type="text"
			class="text_150er text_360" /></td>
		<td colspan="2" class="hui_xi"></td>
	</tr>

	<tr>
		<td align="right" class="hei_cu" height="30">通讯地址：</td>
		<td><input name="customeragent.agentaddress"
			value='<ww:property value="customeragent.agentaddress"/>' type="text"
			class="text_150er text_360" /></td>
		<td colspan="2" class="hui_xi">&nbsp;</td>
	</tr>
</table>


<div class="biaoti">机构信息</div>
<table border="0" cellspacing="0" cellpadding="0" width="100%"
	style="margin-top: 15px;">
	<tr>
		<td align="right" class="hei_cu" height="30">所属地域：</td>
		<td><select class="text" style="width: 300px" name="customeragent.airportcode"
			id="airportcode">
			<ww:iterator value="listcityairport">
				<ww:property value="airportcode" />
				<option value='<ww:property value="airportcode" />'
					<ww:if test="customeragent.airportcode==airportcode">selected="selected"</ww:if>
					>
				<ww:property
					value="shortpinyin" />&nbsp;&nbsp;<ww:property value="cityname" /></option>
			</ww:iterator>
		</select></td>
		<td colspan="2" class="hui_xi">&nbsp;</td>
	</tr>
	<tr>
		<td align="right" width="20%" height="30" class="hei_cu">合同期限：</td>
		<td class="table_color_l" colspan="3"><ww:property
			value="formatDate(customeragent.agentvsdate)" />- <ww:property
			value="formatDate(customeragent.agentvedate)" /></td>
	</tr>
</table>


<div class="biaoti">联系人信息</div>
<table border="0" cellspacing="0" cellpadding="0" width="100%"
	style="margin-top: 15px;">
	<tr>
		<td width="20%" align="right" class="hei_cu" height="30">联系人：</td>
		<td width="30%"><input name="customeragent.agentcontactname"
			value='<ww:property value="customeragent.agentcontactname"/>'
			type="text" class="text_150er text_360" id="contactname" /></td>
		<td><font id="vcontactname" style="color: red"></font></td>
	</tr>
	<tr>
		<td align="right" class="hei_cu" height="30">联系人电话：</td>
		<td><input name="customeragent.agentphone"
			value='<ww:property value="customeragent.agentphone"/>' type="text"
			class="text_150er text_360" id="agentphone" /></td>
		<td><font id="vagentphone" style="color: red"></font></td>
	</tr>
	<tr>
		<td align="right" class="hei_cu" height="30">联系邮箱：</td>
		<td><input name="customeragent.agentemail"
			value='<ww:property value="customeragent.agentemail"/>' type="text"
			class="text_150er text_360" /></td>
		<td class="hui_xi"></td>
	</tr>
	<tr>
		<td align="right" class="hei_cu" height="30">MSN/QQ：</td>
		<td><input name="customeragent.msnqq"
			value='<ww:property value="customeragent.msnqq"/>' type="text"
			class="text_150er text_360" /></td>
		<td class="hui_xi"></td>
	</tr>

</table>
<div class="biaoti">账户信息</div>
<table border="0" cellspacing="0" cellpadding="0" width="100%"
	style="margin-top: 15px;">
	<tr style="display: none;" id="pay1">
		<td width="20%" align="right" class="hei_cu" height="30">支付宝账号：</td>
		<td width="30%" style="color: black"><input
			name="customeragent.alipayaccount"
			value='<ww:property value="customeragent.alipayaccount"/>'
			type="text" class="text_150er text_360" id='paycount0' /> <font
			id="vpaycount0" style="color: red;"></font></td>
		<td class="hui_xi"></td>
	</tr>
	<tr style="display: none;" id="pay3">
		<td align="right" class="hei_cu" height="30">汇付天下账号：</td>
		<td><input id='paycount1' name="customeragent.chinapnrcount"
			value='<ww:property value="customeragent.chinapnrcount"/>'
			type="text" class="text_150er text_360" /> <font id="vpaycount1"
			style="color: red;"></font></td>
		<td class="hui_xi"></td>
	</tr>
	<tr style="display: none;" id="pay2">
		<td align="right" class="hei_cu" height="30">快钱帐号：</td>
		<td><input id='paycount2' name="customeragent.kuaibillaccount"
			value='<ww:property value="customeragent.kuaibillaccount"/>'
			type="text" class="text_150er text_360" /> <font id="vpaycount2"
			style="color: red;"></font></td>
		<td class="hui_xi"></td>
	</tr>

	<tr>
		<td colspan="3" align="center" height="50px"><input
			type="button" class="but" onclick="saveEdit();" value="保存" /></td>
	</tr>

</table>



</div>
</form>
</div>
</div>
<div id="dialogdiv"></div>
<script type="text/javascript">
function twoval(id,varray){
 $("#v"+id).addClass("val");
  var ret=true;
  var idval=$("#"+id).val();  
  for(i=0;i<varray.length;i++){
   var obj=varray[i];
   var name=obj.data[0];
   var url=obj.data[1];
   var mesg=obj.data[2];
   if(name=="required"){
    if(idval==""){
    $("#v"+id).html(mesg);
    ret= false;
    return false;
  }else{
   $("#v"+id).html("");
   ret= true;
  }
  }
  if(name=='regexp'){
    var regyn=obj.data[3];
    if(regyn){
     if(!url.test(idval)){ 
      $("#v"+id).html(mesg);
      ret= false;
       return false;
     }else{
      ret= true;
     }   
    }else{
   if(url.test(idval)){ 
      $("#v"+id).html(mesg);
      ret= false;
       return false;
     }else{
      ret= true;
     }   
  }  
 }  
  if(name=="length"){
    var len=idval.length;
    if(len>=6&&len<=16){
    $("#v"+id).html("");
      ret=true;
    }else{
    $("#v"+id).html(mesg);
      ret=false;      
      return false;
    }
  }
  if(name=="ajax"){
     $.ajax({
       type:"post",
       url:url,
       async:false,
       data:{validateId:id,validateValue:idval},
       success:function(dat){
        dat = eval( "("+dat+")");
	    var ajaxisError = dat.jsonValidateReturn[2]; 
	    if(ajaxisError=="false"){
	      $("#v"+id).html(mesg);
	       ret=false;
	       return false;
	    }else{
	     $("#v"+id).html("");
	      ret=true;
	    }
       }
     
     });  
   }   
 }
 if(ret){
 $("#v"+id).html("<img src='images/valok.gif'/>");
 }
  return ret;
}

</script>
</body>
</html>
