<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<LINK rel=stylesheet type=text/css href="style/text.css">
<LINK rel=stylesheet type=text/css href="css/train.css">


<style>
.button1 {
	background: url(images/hout3.gif);
	width: 98px;
	height: 31px;
	border: none;
	color: #FFF;
	font-weight: bold;
	cursor: pointer;
}
.val{color: red;}

</style>

<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>



</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;分销商域名logo维护</b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			enctype="multipart/form-data" action="dnsmaintenance!edit.action"
			onsubmit="return valform()">
		<div>
		<input type='hidden' name='id'
			value='<ww:property value="dnsmaintenance.id"/>' /> 
			<table width="85%" border="1" bordercolor="#86B2D1" cellspacing="0"
					cellpadding="0"
					style="line-height: 28px; padding-top: 10px; text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px;">
					<tr>
					<td align="right" style="background: #daf0fc;width: 150px"><b>域名：</b></td>
						<td>
						http://www.<input size='8' id="dnsname" name="dnsname" value='<ww:property value="dnsmaintenance.dnsname"/>' />.com
						<font style="color: red">*</font><font id="vdnsname">请填写正确的域名。例：chalv
						<font style="color: red">(不包含www和com)</font></td>
						
					</tr>
			
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>logo 1：</b></td>
						<td>
						<input id="file1" type="file" name="files"   />
						<font style="color: red">*</font>
						<font id="vfile1">若需更换请重新选择图片</font>
						</td>
					</tr>	
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>logo 2：</b></td>
						<td>
						<input id="file2" type="file" name="files"   />
						<font style="color: red">*</font>
						<font id="vfile2">若需更换请重新选择图片</font>
						</td>
					</tr>	
					<tr>
					<td align="right" style="background: #daf0fc"><b>客服电话：</b></td>
						<td><input id="serviceline" name="serviceline" value='<ww:property value="dnsmaintenance.serviceline"/>'  />
						<font style="color: red">*</font><font id="vserviceline">请填写联系电话。例：0000-12345678</font></td>
					</tr>			
					<tr>
					<td align="right" style="background: #daf0fc"><b>平台名字：</b></td>
					
						<td><input id="address" name="address"  value='<ww:property value="dnsmaintenance.address"/>'  />
						<font style="color: red">*</font><font id="vaddress">请填写平台名字。例：XX平台</font></td>
					</tr>	
					<tr>
					<td align="right" style="background: #daf0fc"><b>ICP备案号：</b></td>
						<td><input id="icpnum" name="icpnum" value="<ww:property value="dnsmaintenance.icpnum"/>"  />
						<font style="color: red">*</font><font id="icpnums">请填写完整备案号。例：京ICP备1201XXX2-5</font></td>
					</tr>
					<tr>
					<td align="right" style="background: #daf0fc"><b>公司地址：</b></td>
						<td><input id="dizhi" name="dizhi" value="<ww:property value="dnsmaintenance.dizhi"/>" />
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
					<td align="right" style="background: #daf0fc"><b>登录绑定：</b></td>
						<td>
						<select name="loginpage">
						<option <ww:if test="dnsmaintenance.loginpage.equals(\"login/zthf/index.jsp\")"> selected="selected" </ww:if> value='login/zthf/index.jsp'>login/zthf/index.jsp</option>
						</select>
						
						<font style="color: red">*</font><font id="vaddress">用于分配登录页面</font></td>
					</tr>		
					<tr>
					<td colspan="2" height="50px;" style="padding-left: 140px;">
					    <input type="submit" class="button1" value="提交" />
					    </td>
					</tr>		
				</table>
		</form>


		</td>
	</tr>
</table>
</body>
<script>
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
var address=twoval('address','','必选填写');
if(companyname&&shortname&&dnsname&&address&&serviceline){
if($("#file1").val()!=""||$("#file2").val()!=""){
dispose("正在为您上传图片");
 }
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
</script>
</html>






