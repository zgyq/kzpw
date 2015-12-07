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
<title><ww:if test="ymsend.id>0">编辑</ww:if><ww:else>新增</ww:else>短信发送表</title>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
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
<script src="js/PublicJs.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script>
  function datacheck()
  {
     if(document.getElementById("txtphone").value=="")
     {
         alert("手机号不能为空，请重新填写！");
         document.getElementById("txtphone").focus();
         return ;
     }
     else
     {
     var txtphone=document.getElementById("txtphone").value;
     var txtphones=txtphone.split(",");
     for(i=0;i<txtphones.length;i++){
      if(!IsMobile(txtphones[i]))
        {
           alert("手机号码格式不正确！");
           return ;
        }
     }
     
       
     }
     if(document.getElementById("txtcontent").value=="")
     {
         alert("短信内容不能为空，请重新填写！");
         document.getElementById("txtcontent").focus();
         return ;
     }
   
   document.form1.submit();
   parent.grefresh();
  }
  //显示短信字数信息
  function showcountinfo()
  {
     var varinfo="";
     if($("#txtcontent").val().length>70 && $("#txtcontent").val().length<140)
     { 
        varinfo="<b>系统提示：短信字数已经超过70字,超过一条短信.</b><br />";
     } 
     else if($("#txtcontent").val().length>140 && $("#txtcontent").val().length<210)
     {
        varinfo="<b>系统提示：短信字数已经超过140字,超过两条短信.</b><br />";
     }
     else if($("#txtcontent").val().length>300)
     {
        varinfo="<b>系统提示：短信字数已经超过300字.</b><br />";
     }
     if($("#txtcontent").val().length>300)
     { 
        alert("短信字数输入已满！") 
        $("#txtcontent").val($("#txtcontent").val().substring(0,300));
     } 
     $("#divcountinfo").html(varinfo+"<b>当前短信字数：<font style='color:red'>"+$("#txtcontent").val().length+"</font>字，一共可输入<font style='color:red'>300字</font>(约三条短信)</b>");
  }
</script>
<script type="text/javascript">
	function getMessage(){
		var templte=document.getElementById("selects").value;
		$.ajax({
	    type:"POST",
	    url:"ymsend!getMessage.action",
	    data:{templtes:templte},
	    async:false,         
	    success:function(data){
	     $("#txtcontent").val(data);
	    }            
	    });
	}
	function ClearTextArea()
  {
            document.getElementById("txtphone").value="";
  } 
  function getTextFromTxt(){
  	var filepath=document.getElementById("file").value;
  	if(filepath==""){
			alert("请选择文件路径");
			return　false;
		}
  	$.ajax({
	    type:"POST",
	    url:"ymsend!getTextFromTxt.action",
	    data:{filepath:filepath},
	    async:false,         
	    success:function(data){
	     $("#txtphone").val(data);
	    }            
	    });
  }
	function showAndno(){
		$("#div1").hide();
		$("#div2").show();
	}
	function showH(){
		$("#div1").show();
		$("#div2").hide();
	}
	function getTxt(src){
		var ForReading=1; 
		var fso=new ActiveXObject("Scripting.FileSystemObject"); 
		var f=fso.OpenTextFile(src,ForReading);
		return(f.ReadAll()); 
	}
	function get(){
		var src=document.getElementById("file").value;
		if(src==""){
			alert("请选择文件路径");
			return　false;
		}
		var arr=getTxt(src).split(","); 
		document.getElementById("txtphone").value=arr;
	}
	function getCustomerpassenger(){
	 var temp=document.getElementById("select").value;
		$.ajax({
	    type:"POST",
	    url:"ymsend!getmessgroup.action",
	    data:{temp:temp},
	    async:false,         
	    success:function(data){
	     $("#txtphone").val(data);
	    }            
	    });
	} 
	function chongzhi(){
		$("#divmoney").show();
	}
	function quxiao(){
		$("#divmoney").hide();
	}
	function smsMoney(){
		var sms=document.getElementById("money").value;
		if(sms==""){
			alert("请输入充值的金额");
			return false;
		}
		window.location.href="ymssendaction!smspay.action";
	}
</script>
<body >
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;短信发送</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form action="ymsend!sendSms.action" name="form1" method="POST"
			>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td width="156" height="18">&nbsp;</td>
						<td >&nbsp;</td>
					</tr>
					
					
					<tr>
						<td height="28" align="right"><span>手机号码：</span></td>
						<td colspan="2"><textarea maxlength="200" name="txtphone"
							id="txtphone"  rows="3" cols="56"><ww:property value="ymsend.phone"/></textarea><span style="color: red">*多个电话号码用","隔开;
							</span></td>
					</tr>

					<tr>
						<td height="28" align="right" rowspan="3"><span>短信内容：</span></td>
					</tr>
					<input name="orderid"  type="hidden" value="<ww:property value="ymsend.ordercode"/>" />
					<tr>
						<td colspan="2"><textarea maxlength="200" name="txtmessage"
							id="txtcontent" rows="8" cols="56"
							onpropertychange="showcountinfo()"><ww:property
							value="ymsend.content" /></textarea><span style="color: red">*
						请输入短信内容</span><br />
						<font class="font-red-xi"><div id="divcountinfo"></div></font>
						</td>
					</tr>
					</tr>
					
					<tr class="font-blue-xi">
						<td height="54" rowspan="2"></td>
						<td height="46" scrolling="no"><input type="button" onclick="datacheck();"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="parent.grefresh();"
							name="Submit2" value=" 关闭 " /></td>
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

