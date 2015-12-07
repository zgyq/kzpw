
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
<title><ww:if test="messgroup
		.id>0">编辑</ww:if><ww:else>新增</ww:else>短信用户组
</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script src="js/PublicJs.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
</head>
<script type="text/javascript">
	 var staus="-1";
  function btnSubmit() {
        var userGroupName = $("#messname").val();
        var userGroupContent = $("#messnums").val();
        userGroupName = $.trim(userGroupName);
        userGroupContent = $.trim(userGroupContent);
 
        if (userGroupName.length<1) {
            alert("请输入用户组的名称!");
            return false;
        } else if (userGroupName.length > 20) {
            alert("用户组名称输入长度不能大于20");
            return false;
        }else{
        ajax_messname();
        <ww:if test="messgroup.id==0">
        	if(staus=='-1'){
       	 		alert("组名已经存在");
        		return false;
       		 }
       	</ww:if>
        } 
 
        if (userGroupContent.length<1) {
            alert("请输入用户组的内容!");
            return false;
        } else {
            var tels = new Array();
            var usergroupCon=userGroupContent.replace("，",",");
            tels = usergroupCon.split(",");
 			 for(i=0;i<tels.length;i++){
     			 if(!IsMobile(tels[i]))
        			{
           alert("手机号码格式不正确！");
           return false;
      	 			 }
      	 			 for(j=i+1;j<tels.length;j++){
      	 			 	if(tels[i]==tels[j]){
      	 			 	alert("用户组中存在相同号码");
      	 			 		return false;
      	 			 	}
      	 			 }
    		 }
            if (tels.length > 100) {
                alert("对不起,一次最多为100个电话号码!");
                return false;
            } 
        }
        
 
    } 
   function ajax_messname(){
  var messname=$("#messname").val();
 	$.ajax({
       type:"POST",
       url:"messgroup!validatemessname.action?validateValue="+messname,
       async:false,     
       success:function(data)
       { 
        if(data=='false'){
      		 staus="-1";
			     //return "-1";
        }else{
      		 staus="1";
        	//return "1";
        }
        	
       }          
 		 }
 		  
 		 )
      
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
		document.getElementById("messnums").value=arr;
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
	     $("#messnums").val(data);
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
	function ClearTextArea()
  {
            document.getElementById("messnums").value="";
  } 
</script>
<body>
<div id="member">
<form
	action="messgroup
		!<ww:if test="messgroup
		.id>0">edit.action?id=<ww:property value="messgroup
		.id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
	name="form1" method="POST" onsubmit="return btnSubmit()">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;<ww:if
			test="messgroup
		.id>0">编辑</ww:if><ww:else>新增</ww:else>短信用户组 </span></b></td>
	</tr>
	<tr>
	<td align="center">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		class="font-blue-xi" style="border-collapse: collapse;">
		<tr>
			<td height="100%">
			<div>&nbsp;</div>
			<table width="98%" cellpadding="0" cellspacing="0" style=" margin: 0 auto;">

				<tr>
					<td height="30" style="text-align: right;"
						class="table_color colortrin">组名 :<span style="color: red;">*</span>
					</td>
					<td height="30" align="left" class="table_color_l">
					<input type="text" name="messname 
						" id="messname"
						value='<ww:property value="messgroup.messname"/>'
						" style="width: 300px" /></td>
					<td height="30" style="text-align: left;"
						class="table_color colortrin"><span style="color: red;">*组名长度不能超过20个字</span>
					</td>

				</tr>
				<tr>
					<td height="240" style="text-align: right;"
						class="table_color colortrin">用户组号码 :<span
						style="color: red;">*</span></td>

					<!--  <td width="10%" height="30" class="table_color_l" align="left">
					<input type="button" value="批量导入号码" onclick="showAndno()" /> <input
							type="button" value="清空号码" onclick="ClearTextArea()" /></div>
						<div id="div2" style="display: none;">文件路径:<input
							type="file" name="file" id="file" /><input type="button"
							value="导入号码" onclick="getTextFromTxt()" /><input type="button" value="返回"
							onclick="showH()" /><br>
						导入文件必须为*.txt文件,导入最大号码数为100</div>-->
					<td  class="table_color_l" align="left" valign="top">
					<div style="height: 34px; padding-top: 5px;">
					<input type="button" value="批量导入" class="button_h" style="margin-left: 20px;" onclick="showAndno()" /> 
					<input type="button" value="清空号码" class="button_h" style="margin-left: 20px;" onclick="ClearTextArea()" />
					</div>
					<div id="div2" style="display: none; height:50px;">文件路径:
						<input	type="file" name="file" id="file" />
						<input type="button" value="导入号码" class="button_h" style="margin-left: 20px;" onclick="getTextFromTxt	()" />
						<input type="button" class="button_h" value="返回" style="margin-left: 20px;" 	onclick="showH()" /><br>
							导入文件必须为*.txt文件,导入最大号码数为100;
					</div>
					<!--  <input type="text"  name="messnums
						" value='<ww:property value="messgroup.messnums
						"/>'" style="width: 300px" />--> <textarea maxlength="200"
						name="messnumbers" id="messnums" rows="8" cols="50"><ww:property
						value="messgroup.messnums" /></textarea></td>
					<td  style="text-align: left;"
						valign="bottom" class="table_color colortrin"><span
						style="color: red;">*多个号码请用","隔开;最多为100个号码！<br>如果导入失败请根据下面方式进行设置<br>Internet选项->安全->自定义级别-><br>将本地文件上载至服务器时包含本地目录路径 ->选“启动”->确定</span></td>
				</tr>

				<tr>
					<td colspan="3" height="50" bgcolor="ffffff"><input
						type="submit" class="button_d font-bai" value="提交"
						/ style="margin-right: 55px;"> <input type="button"
						class="button_d font-bai"
						onclick="window.location.href='messgroup.action?<ww:property value="url"/>';"
						name="Submit2" value=" 返回 " /></td>
				</tr>
			</table>
			</td>
			</tr>
	</table>
	</td>
	</tr>
	</table>
	</form>
	<div>&nbsp;</div>
	</div>
</body>
</html>


