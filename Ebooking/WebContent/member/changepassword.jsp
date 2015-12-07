<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-修改密码</title>

<ww:head name="login" jsURL="member" />
<!--<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>
-->
<style>
#overlay{
   background: #303030;
   opacity: 0.50;
   filter:Alpha(opacity=50);
   display: none;
   position: absolute;
   top: 0px;
   left: 0px;
   width: 100%;
   height: 100%;
   z-index: 100;
}
#tishi{
 margin-left:auto;
 margin-right:auto;
 border:2px solid #FFFFFF;
 font-size:12px;
 font-family: "宋体";
 color:#990000;
 padding-top:20px;
 width:400px;
 height:200px;
 position:absolute;
 z-index:110;
 display:none;
 background:#e7e7e7;
 left:35%;
 top:20%;
 opacity:0.85;
 filter:Alpha(opacity=85);
}
</style>
</head>

<script>
//$(document).ready(function() {

//			$("#form1").validationEngine(
//			{
//				success : function() {
//				//表单提交时把按钮disable
///				document.getElementById("submitreg").disabled = true;
//				document.form1.submit();
//				}
//			}
	
//	) 

//});

    $(document).ready(function()
     {
          if(event.keyCode==13)     //判断回车按钮事件
          {   
             $("#btnlogin").click();
          }
          
     });
 document.onkeypress=function(e) 
    {
        var code;  
        if  (!e)  
        {  
            var e=window.event;  
        }  
        if(e.keyCode)  
        {    
            code=e.keyCode;  
        }  
        else if(e.which)  
        {  
            code   =   e.which;  
        }
        if(code==13)
        {
        sub();
        }
    }
    
function sub(){

 if($("#oldpassword").val()==""){
	       	$("#oldpassword").poshytip({
				content: "请输入原密码!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#oldpassword").focus();
			     return false;
	}

 if($("#newpassword").val()==""){
	       	$("#newpassword").poshytip({
				content: "请输入新密码!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#newpassword").focus();
			     return false;
	}
 if($("#newpassword").val().length<6||$("#newpassword").val().length>16){
	       	$("#newpassword").poshytip({
				content: "新密码格式错误.请输入6到16位数字或者字母组合!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#newpassword").focus();
			     return false;
	}
 if($("#Vnewpassword").val()==""){
	       	$("#Vnewpassword").poshytip({
				content: "确认密码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#Vnewpassword").focus();
			     return false;
	}	
 if($("#Vnewpassword").val()!=$("#newpassword").val()){
	       	$("#Vnewpassword").poshytip({
				content: "2次密码输入不一致!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#Vnewpassword").focus();
			     return false;
	}
	
	//  var temp = confirm('确认提交?');
	//if(temp==true){

   document.form1.submit();
  // }		
}



</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>     
<!----------header over---------->
<div id="member">
   <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
   <div class="right mt10 r">
       <!-- <div>
          <ul>
            <li class="mation fff">会员信息</li>
            <li class="mation_info"><font class="mation_left f"><b>普通会员</b></font><span class="f mr25">会员注册时间为：<ww:property value="formatDate(#session.loginuser.createtime)" /></span>       <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div> -->
      
       <div class="box">
            <div class="tit">
                   <font class="black low2 f">修改密码</font>
                   <font class="f c999" style=" color:#f00;">　（请完善您的个人资料）</font>
                   <div class="c"></div>
            </div>
            <form action="<%=request.getContextPath()%>/login!ChangePasswoed.jspx" name="form1" method="post" id="form1">
            <div class="data">
                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="right" width="40%"><font class="fontxing mlr">*</font>原密码：</td>
                    <td><input type="password" desc="原密码" class="text_regsit validate[required]" id="oldpassword" name="oldpassword" /></td>
                  </tr>
                  <tr>
                    <td align="right"><font class="fontxing mlr">*</font>新密码：</td>
                    <td><input type="password"  desc="新密码" class="text_regsit validate[required]" id="newpassword" name="newpassword"  /></td>
                  </tr>
                   <tr>
                     <td align="right"><font class="fontxing mlr">*</font>确认密码：</td>
                     <td><input type="password"  desc="确认密码" class="text_regsit validate[required,confirm[newpassword]]" id="Vnewpassword" name="Vnewpassword" /></td>
                   </tr>
                 
                   <tr>
                   <td colspan="2" class="save" style=" text-align:center; padding:0;"><input type="button" id="submitreg" value="保存信息" onclick="sub();" class="bst"  /><span class="f00"><ww:property value="fieldErrors.validate"/></span> </td>
                   </tr>
                 </table>

            </div>
            </form>
       </div> 
   </div>
</div>

<div id="overlay" style="display: none;">
<div align="center"><input id="gb" type="button" onclick="clo();" value="关闭" /></div>

</div>
<ww:include page="../footer.jsp"/>  
</body>
</html>

<script>
<ww:if test="fieldErrors.validate!=null">
$(document).ready(function (){
 // document.getElementById("overlay").style.display="block";
 });
</ww:if>
function clo(){

document.getElementById("overlay").style.display="none";
}
</script>

	