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
			class="anse">&nbsp;&nbsp;&nbsp;B2G网站图片维护<span style="color: red">(请谨慎操作,提交后将直接覆盖原图片,如不确定请先保存原图片)</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id='form1' method="post"
			enctype="multipart/form-data" action="dnsmaintenance!uplode.action"
			>
		<div>
		<input type='hidden' name='id'
			value='<ww:property value="dnsmaintenance.id"/>' /> 
			<table width="85%" border="1" bordercolor="#86B2D1" cellspacing="0"
					cellpadding="0"
					style="line-height: 28px; padding-top: 10px; text-indent: 20px; border-collapse: collapse; margin: 0 auto; margin: 15px;">
					
			
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>logo：</b></td>
						<td>
						<input id="file1" type="file" name="files1"   />
						<input id="images1" type="hidden" name="images"  value="logo.png"   />
						<font style="color: red">*</font>
						<font id="vfile1">若需更换请重新选择图片(260*90 格式为.png)</font>
						</td>
					</tr>	
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>logo右边图片：</b></td>
						<td>
						<input id="file2" type="file" name="files2"   />
						<input id="images2" type="hidden" name="images"  value="ad.jpg"   />
						<font style="color: red">*</font>
						<font id="vfile2">若需更换请重新选择图片(468*60 格式为.jpg)</font>
						</td>
					</tr>
					
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>登录页面大图：</b></td>
						<td>
						<input id="file3" type="file" name="files3"   />
						<input id="images3" type="hidden" name="images"  value="ad_700.jpg"   />
						<font style="color: red">*</font>
						<font id="vfile2">若需更换请重新选择图片(732*272 格式为.jpg)</font>
						</td>
					</tr>	
					
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>登录页面小图1：</b></td>
						<td>
						<input id="file4" type="file" name="files4"   />
						<input id="images4" type="hidden" name="images"  value="ad_sea.jpg"   />
						<font style="color: red">*</font>
						<font id="vfile2">若需更换请重新选择图片(260*100 格式为.jpg)</font>
						</td>
					</tr>	
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>登录页面小图2：</b></td>
						<td>
						<input id="file5" type="file" name="files5"   />
						<input id="images5" type="hidden" name="images"  value="ad_login.jpg"   />
						<font style="color: red">*</font>
						<font id="vfile2">若需更换请重新选择图片(260*100 格式为.jpg)</font>
						</td>
					</tr>	
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>机票列表页面图片：</b></td>
						<td>
						<input id="file6" type="file" name="files6"   />
						<input id="images6" type="hidden" name="images"  value="ad_list.jpg"   />
						<font style="color: red">*</font>
						<font id="vfile2">若需更换请重新选择图片(260*100 格式为.jpg)</font>
						</td>
					</tr>		
					<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>机票首页大图片：</b></td>
						<td>
						<input id="file7" type="file" name="files7"   />
						<input id="images7" type="hidden" name="images"  value="ad_ticket.jpg"   />
						<font style="color: red">*</font>
						<font id="vfile2">若需更换请重新选择图片(499*220 格式为.jpg)</font>
						</td>
					</tr>	
						<tr>
					<td align="right" height="50" style="background: #daf0fc"><b>机票首页小图片：</b></td>
						<td>
						<input id="file8" type="file" name="files8"   />
						<input id="images8" type="hidden" name="images"  value="ad_ticket_01.jpg"   />
						<font style="color: red">*</font>
						<font id="vfile2">若需更换请重新选择图片(260*100 格式为.jpg)</font>
						</td>
					</tr>	
					<tr>
					<td colspan="2" height="50px;" style="padding-left: 140px;">
					    <input type="button" class="button1" value="提交" onclick="valform();" />
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
for(i=1;i<6;i++){
 var idval=$("#file"+i).val();
	 if(idval==''){
	 	document.getElementById("images"+i).value="";
	 }
}
//return false;

document.form1.submit();
  //return true;

 //  return false;


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






