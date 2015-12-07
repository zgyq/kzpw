<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<LINK rel=stylesheet type=text/css href="style/text.css">  
  
<LINK rel=stylesheet type=text/css href="css/train.css">  

<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>

<style>
.button1{background:url(images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-weight:bold;cursor:pointer;}
.val{color: red;}
</style>
</head>
<body>
<div id="member" style="width: 100%">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;分销商域名logo维护</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post" onsubmit="return valform()" enctype="multipart/form-data"
			action="dnsmaintenance!add.action">
			<input type="hidden" name="is_first" />
			<input type="hidden" name="agentid" value='<ww:property value="s_agentid"/>' />

				<table width="85%" border="1" bordercolor="#86B2D1" cellspacing="0"
					cellpadding="0"
					style="line-height: 28px; padding-top: 10px; text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px;">
					<tr><td colspan="4">说明：此功能用于为加盟商分配独立域名.</td></tr>
					<tr>
					<td align="right" style="background: #daf0fc;width: 150px"><b>域名：</b></td>
						<td>
						http://www.<input size='8' id="dnsname" name="dnsname" />.com
						<font style="color: red">*</font><font id="vdnsname">请填写正确的域名。例：chalv
						<font style="color: red">(若需绑定多个域名，请单独提交分开)</font></td>
					</tr>
			
			
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>logo 1：</b></td>
						<td>
						<input id="file1" type="file" name="files"   />
						<font style="color: red">*</font>
						<font id="vfile1">请选择logo图片(110×97:用于登录页logo)。为使美观，请确保logo背景透明。</font>
						</td>
					</tr>	
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>logo 2：</b></td>
						<td>
						<input id="file2" type="file" name="files"   />
						<font style="color: red">*</font>
						<font id="vfile2">请选择logo图片(236×61：用于进入平台后logo)。为使美观，请确保logo背景透明。</font>
						</td>
					</tr>	
					<tr>
					<td align="right" style="background: #daf0fc"><b>客服电话：</b></td>
						<td><input id="serviceline" name="serviceline"  />
						<font style="color: red">*</font><font id="vserviceline">请填写联系电话。例：0000-12345678</font></td>
					</tr>			
					<tr>
					<td align="right" style="background: #daf0fc"><b>平台名字：</b></td>
						<td><input id="address" name="address"  />
						<font style="color: red">*</font><font id="vaddress">请填写平台名字。例：XX平台</font></td>
					</tr>
					<tr>
					<td align="right" style="background: #daf0fc"><b>ICP备案号：</b></td>
						<td><input id="icpnum" name="icpnum"  />
						<font style="color: red">*</font><font id="icpnums">请填写完整备案号。例：京ICP备1201XXX2-5</font></td>
					</tr>
					<tr>
					<td align="right" style="background: #daf0fc"><b>公司地址：</b></td>
						<td><input id="dizhi" name="dizhi"  />
						<font style="color: red">*</font><font id="dizhis">请填写公司地址。例：北京市XX</font></td>
					</tr>
					<tr>
					<td align="right" style="background: #daf0fc"><b>B2B/B2C：</b></td>
						<td>
						<select name="logologinsrc">
						<option <ww:if test="dnsmaintenance.logologinsrc.equals(\"B2B\")"> selected="selected" </ww:if> value='B2B'>B2B</option>
						<option <ww:if test="dnsmaintenance.logologinsrc.equals(\"B2C\")"> selected="selected" </ww:if> value='B2C'>B2C</option>
						</select>
						
						<font style="color: red">*</font><font id="vaddress">用于分配登录页面</font></td>
					</tr>			
					<tr>
					<tr>
					<td align="right" style="background: #daf0fc"><b>登录绑定：</b></td>
						<td>
						<select name="loginpage">
						<option <ww:if test="dnsmaintenance.loginpage.equals(\"login/zthf/index.jsp\")"> selected="selected" </ww:if> value='login/zthf/index.jsp'>login/zthf/index.jsp</option>
						</select>
						
						<font style="color: red">*</font><font id="vaddress">用于分配登录页面</font></td>
					</tr>			
					<tr>
					<tr>
					<td colspan="2" height="50px;" style="padding-left: 140px;">
					    <input type="submit" class="button1" value="提交" />
					    </td>
					</tr>		
				</table>
		</form>
		

		</td>
	</tr>
	<tr>
	<td>

	<table border='1' width="85%" style="text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px; line-height:28px;" cellpadding="0" cellspacing="0">
	<thead style="background: #f0f0f0">
	<th>公司名称</th>
	<th>域名</th>
	<th>B2B/B2C</th>
	<th>logo</th>
	<th>电话</th>
	<th width="200px">平台名字</th>
	<th>操作</th>
	</thead>
	<tbody>
	<ww:iterator value="listDnsmaintenance">
	<tr>
	<td><ww:property value="companyname"/></td>
	<td><ww:property value="dnsname"/></td>
	<td><ww:property value="logologinsrc"/></td>
	<td><ww:property value="logosrc"/></td>
	<td><ww:property value="serviceline"/></td>
	<td><ww:property value="address"/></td>
	<td valign="middle">
	<a onclick='updRoom(<ww:property value="id"/>)' href="javascript:void(0)"><img src="images/wrench.png" style="cursor: pointer;"   title="修改"  align="absmiddle" />修改</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a onclick='delRoom(<ww:property value="id"/>,"<ww:property value="logosrc"/>")' href="javascript:void(0)"><img src="images/xxh.gif" style="cursor: pointer;"  title="删除"  />删除</a>
	</td>
	</tr>
	</ww:iterator>
	</tbody>
	</table>
	</td>
	</tr>
</table>
</body>
<script>
function updRoom(rid){
 window.location.href='dnsmaintenance!toedit.action?id='+rid;
}
function delRoom(rid,logosrc){
 Ext.MessageBox.confirm("提示","确定删除本条记录？",function(obj){
 if(obj=='yes'){
 window.location.href='dnsmaintenance!delete.action?id='+rid+"&logosrc="+logosrc;
 } 
 });
}



function twoval(id,val,vhtml){
  var idval=$("#"+id).val();
  if(idval==val){
  
   $("#v"+id).addClass("val");
   $("#v"+id).html(vhtml);
    return false;
  }else{
   $("#v"+id).html("");
   return true;
  }
}

function valform(){
var dnsname=twoval('dnsname','','必选填写');
var serviceline=twoval('serviceline','','必选填写');
var logo1=twoval('file1','','必选选择图片');
var logo2=twoval('file2','','必选选择图片');
var address=twoval('address','','必选填写');
if(dnsname&&logo1&&logo2&&address&&serviceline){
  dispose("正在为您上传图片");
  return true;
}else{
return false;
}

}

function dispose(message) {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}
$(document).ready(function(){
<ww:if test="#request.errormessage!=null">
Ext.MessageBox.alert("提示",'<ww:property value="#request.errormessage"/>');
</ww:if>

});
</script>
</html>






