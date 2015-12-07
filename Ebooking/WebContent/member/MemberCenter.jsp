<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-个人信息</title>

<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<!--
<script src="js/jquery/jquery1.3.2.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="js/jquery/jquery.validationEngine.js" type="text/javascript"></script>
-->
<ww:head name="login" jsURL="member" />

<script language="javascript" type="text/javascript" src="js/provinceandcity/provinceandcity.js"></script>
<!--  
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
</script>
-->

<script>

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
        if(code==13&&$("#isfalse").val()=='1')
        {
       		 sub();
        }
    }
function sub(){

 if($("#membername").val()==""){
	       	$("#membername").poshytip({
				content: "姓名不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#membername").focus();
			     return false;
	}
 if($("#areacode").val()==""){
	       	$("#areacode").poshytip({
				content: "区号不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}else{
 if(!IsNumber($("#areacode").val())){
	       	$("#areacode").poshytip({
				content: "区号只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}
 if($("#areacode").val().length!=3&&$("#areacode").val().length!=4){
	       	$("#areacode").poshytip({
				content: "区号格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#areacode").focus();
			     return false;
}

}

 if($("#telephone").val()==""){
	       	$("#telephone").poshytip({
				content: "号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#telephone").focus();
			     return false;
}else{
 if(!IsNumber($("#telephone").val())){
	       	$("#telephone").poshytip({
				content: "号码只能为数字",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#telephone").focus();
			     return false;
}
 if($("#telephone").val().length<6||$("#telephone").val().length>10){
	       	$("#telephone").poshytip({
				content: "区号格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#telephone").focus();
			     return false;
}

}
<ww:if test="customeruser.memberemail==null || customeruser.memberemail==''">
var isfalse="1";
 if($("#memberemail").val()==""){
	       	$("#memberemail").poshytip({
				content: "电子邮件不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#memberemail").focus();
			     isfalse="0";
			     return false;
			    
}
 if(!IsEMail($("#memberemail").val())){
	       	$("#memberemail").poshytip({
				content: "电子邮件格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#memberemail").focus();
			     isfalse="0";
			     return false;
			    
}

 $.ajax({
       type:"POST",
      url:"vaidate!validateloginemail.jspx?validateValue="+$("#memberemail").val(),
       async:false,     
       success:function(data)
       {    
       //alert(data);
        if(data=='false'){
        		$("#memberemail").poshytip({
				content: "该电子邮件已被注册!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#memberemail").focus();
			     isfalse="0";
			     return false;
			    
        }else{
        
        	$("#memberemail").poshytip({
				content: "该电子邮件可以注册!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			 isfalse="1"; 
        }
          
       }   
            
  });

</ww:if>
//if($("#postalcode").val()!=''){
 //if(!IsPostalCode($("#postalcode").val())){
	       //	$("#postalcode").poshytip({
			//	content: "邮编格式错误",
			//	showOn: 'focus',
			//	alignTo: 'target',
			//	alignX: 'right',
			//	alignY: 'center',
			//	offsetX: 5
			//    });
			//    $("#postalcode").focus();
			//     return false;
//}
//}



 //if($("#selProvince").val()==""){
//	       	$("#selProvince").poshytip({
//				content: "省份不能为空!",
//				showOn: 'focus',
///				alignTo: 'target',
//				alignX: 'top',
//				alignY: 'center',
//				offsetX: 5
//			    });
//			    //$("#selProvince").focus();
//			     return false;
//}
 ///if($("#selCity").val()==""){
//	       	$("#selCity").poshytip({
//				content: "所在市不能为空!",
//				showOn: 'focus',
//				alignTo: 'target',
//				alignX: 'right',
//				alignY: 'center',
//				offsetX: 5
//			    });
//			    $("#selCity").focus();
//			     return false;
//}
 //if($("#address").val()==""){
//	       	$("#address").poshytip({
//				content: "地址不能为空!",
//				showOn: 'focus',
//				alignTo: 'target',
//				alignX: 'right',
//				alignY: 'center',
//				offsetX: 5
//			    });
//			    $("#address").focus();
//			     return false;
//}


 
<ww:if test="customeruser.memberemail==null || customeruser.memberemail==''">

  if(isfalse=='1'){
  
  document.form1.submit();
  
  }
</ww:if><ww:else>

 document.form1.submit();

</ww:else>
  
  
}
function valadataMembereMail(){
if($("#memberemail").val()==""){
	       	$("#memberemail").poshytip({
				content: "电子邮件不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#memberemail").focus();
			     return false;
}
 if(!IsEMail($("#memberemail").val())){
	       	$("#memberemail").poshytip({
				content: "电子邮件格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#memberemail").focus();
			     return false;
}

 $.ajax({
       type:"POST",
      url:"vaidate!validateloginemail.jspx?validateValue="+$("#memberemail").val(),
       async:false,     
       success:function(data)
       {    
        if(data=='false'){
        		$("#memberemail").poshytip({
				content: "该电子邮件已经被注册!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#memberemail").focus();
			     return "1";
        }else{
        
        	$("#memberemail").poshytip({
				content: "用户名可以注册!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			   return "0";
        }
       }            
  });


}

</script>
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>    
<!----------header over---------->
<div id="member">
   <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
   <!-- left -->
   
   <div class="right mt10 r">
       <div>
          <ul>
            <li class="mation fff">会员信息</li>
            <li class="mation_info"><font class="mation_left f"><b>注册时间</b></font><span class="f mr25">会员注册时间为：<ww:property value="formatDate(customeruser.createtime)" /></span>      <font class="f90 f">普通会员</font> <span class="r mation_right">&nbsp;</span><a class="r" href="login!loginout.jspx">退出登录</a></li>
          </ul>
       </div>
       <div class="mt7 box" id="updatebut">
        <div class="tit">
               <font class="black low2 f mr15">会员基本信息</font>
                <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div>&nbsp;</div>
         <table width="86%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
              <!--
                <td  class="hadow hl24" align="right" width="20%">用户ID：</td>
                <td>A2341234</td>
                -->
                 <td class="hadow" align="right" width="20%">姓名：</td>
                <td><ww:property value="customeruser.membername" /></td>
                <td class="hadow" align="right" width="20%">注册日期：</td>
                <td><ww:property value="formatDate(customeruser.createtime)" /></td>
              </tr>
               <tr>
                <td class="hadow" align="right" width="20%">登录名：</td>
                <td><ww:property value="customeruser.loginname" /></td>
                <td class="hadow" align="right" width="20%">密码：</td>
                <td>******************</td>
              </tr>
               <tr>
                <td class="hadow" align="right" width="20%">手机号：</td>
                <td><ww:property value="customeruser.mobile" /></td>
                <td class="hadow" align="right" width="20%">电子邮件：</td>
                <td><ww:property value="customeruser.memberemail" /></td>
              </tr>
              <tr>
                <td class="hadow" align="right" width="20%">证件类型：</td>
                <td>
                <ww:if test="customeruser.cardtype==1">身份证</ww:if>
                 <ww:if test="customeruser.cardtype==2">护照</ww:if>
                  <ww:if test="customeruser.cardtype==3">港澳通行证</ww:if>
                   <ww:if test="customeruser.cardtype==4">台湾通行证</ww:if>
                    <ww:if test="customeruser.cardtype==5">台胞证</ww:if>
                     <ww:if test="customeruser.cardtype==6">回乡证</ww:if>
                      <ww:if test="customeruser.cardtype==9">其他</ww:if>
               </td>
                <td class="hadow" align="right" width="20%">证件号码：</td>
                <td><ww:property value="customeruser.cardnunber" /></td>
              </tr>
               <tr>
                <td class="hadow" align="right" width="20%">生日：</td>
                <td>&nbsp;<ww:property value="formatDate(customeruser.birthday)" /></td>
                <td class="hadow" align="right" width="20%">性别：</td>
                <td>&nbsp;<ww:property value="customeruser.membersex" /></td>
              </tr>
              <tr>
                <td class="hadow" align="right" width="20%">联系电话：</td>
                <td>&nbsp;<ww:if test="areacode!=null&&areacode!=''&&telephone!=null&&telephone!=''"><ww:property value="areacode" />-<ww:property value="telephone" />
                </ww:if>
                </td>
                <td class="hadow" align="right" width="20%">邮政编码：</td>
                <td>&nbsp;<ww:property value="customeruser.postalcode" /></td>
              </tr>
              <!--  
               <tr>
                <td class="hadow" align="right" width="20%"  >联系地址：</td>
                <td colspan="4">&nbsp;
                <ww:if test="address!=null&&address!=''"><ww:property value="sheng" />,<ww:property value="shi" />市,<ww:property value="address" />
                </ww:if>
                </td>
                
              </tr>
              -->
            </table>
            <div class="update" > <input type="button"  value="修改资料" class="bst" onclick="updateUserinfo();"  />
          
            </div>
            <div>&nbsp;</div>
        </div>
       </div> 
       <!--会员基本信息over-->
       <div class="mt7 box" style="display: none" id="userinfo">
            <div class="tit">
                   <font class="black low2 f mr15">个人资料</font>
                   <font class="f mr25 c999">请完善您的个人资料</font>
                   <div class="c"></div>
            </div>
            <form action="<%=request.getContextPath()%>/login!EditUser.jspx" name="form1" method="post" id="form1">
            <div class="data">
                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td align="right" width="23%"><font class="fontxing mlr">*</font>姓名：</td>
                    <td><input type="text" id="membername"  title="姓名不能为空!" desc="姓名" class="text_regsit validate[required]" name="c_membername" value="<ww:property value="customeruser.membername" />" /></td>
                  </tr>
                  <tr>
                    <td align="right"><font class="fontxing mlr">*</font>性别：</td>
                    <td> 
                    <ww:if test="customeruser.membersex!=null">
                    <label class="hand">
                       <input type="radio" name="c_membersex" value="男" id="RadioGroup1_0" <ww:if test="customeruser.membersex==\"男\"">checked</ww:if> />
                       先生</label>
                     <label class="hand">
                       <input type="radio" name="c_membersex" value="女" id="RadioGroup1_1" <ww:if test="customeruser.membersex==\"女\"">checked</ww:if> />
                       女士</label>
                    </ww:if><ww:else>
                    <label class="hand">
                       <input type="radio" name="c_membersex" value="男" id="RadioGroup1_0" checked="checked"  />
                       先生</label>
                     <label class="hand">
                       <input type="radio" name="c_membersex" value="女" id="RadioGroup1_1"  />
                       女士</label>
                    </ww:else>
                    </td>
                  </tr>
                   <tr>
                     <td align="right"> 生日：</td>
                     <td><input type="text" class="text_regsit Wdate" name="c_birthday" value="<ww:property value="formatDate(customeruser.birthday)" />" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',maxDate:'%y-#{%M}-%d'})" /></td>
                   </tr>
                   <tr>
                     <td align="right"> <font class="fontxing mlr">*</font>联系电话：</td>
                     <td><input type="text" title="区号不能为空!" class="text_regsitd validate[custom[onlyMoney]]" id="areacode" name="areacode" value="<ww:property value="areacode" />" />—&nbsp;<input type="text" id="telephone" title="号码不能为空!" name="telephone" value="<ww:property value="telephone" />" class="text_regsitlatter validate[custom[onlyMoney]]" />例：010-00000000</td>
                   </tr>
                   <tr>
                     <td align="right"><font class="fontxing mlr">*</font>手机号：</td>
                     <td><ww:property value="customeruser.mobile" /></td>
                   </tr>
                   <tr>
                     <td align="right"><font class="fontxing mlr">*</font>电子邮件：</td>
                     <td><ww:if test="customeruser.memberemail==null || customeruser.memberemail==''">
                    <input type="text" id="memberemail"  title="电子邮件不能为空!"  class="text_regsit" name="c_memberemail" value="<ww:property value="customeruser.memberemail" />" />
                     </ww:if><ww:else>
		                <ww:property value="customeruser.memberemail" />
		                </ww:else>
                     
                     </td>
                   </tr>
               <!--  
                   <tr>
                     <td align="right"><font class="fontxing mlr">*</font>详细地址：</td>
                     <td valign="bottom"><select name="sheng" style="vertical-align: middle;" id="selProvince" onchange="getCity(this.options[this.selectedIndex].value)"> 
                     <option value="<ww:property value="sheng" />"><ww:property value="sheng" /></option> 
						<ww:if test="sheng!=null&&sheng!=''">
        				<option value="<ww:property value="sheng" />"><ww:property value="sheng" /></option> 
						</ww:if>
   						</select> 
                     	<select id="selCity" name="shi" style="vertical-align: middle;"> 
					<ww:if test="shi!=null&&shi!=''">
        				<option><ww:property value="shi" /></option> 
					</ww:if>
    					</select> 
     				<input class="text_regsit" id="address" name="address" style="width: 280px;" type="text"  value="<ww:property value="address" />" /> </td>
                   </tr>
                  
                   <tr>
                     <td align="right">邮政编码：</td>
                     <td><input type="text" id="postalcode" desc="邮政编码" class="text_regsit validate[custom[onlyMoney]]" name="c_postalcode" value="<ww:property value="customeruser.postalcode" />" /></td>
                   </tr>
                   -->
                   <tr>
                   <td colspan="2" class="save"><input type="button" id="submitreg" value="保存信息" class="bst" onclick="return sub();"  /> </td>
                   </tr>
                 </table>
	
            </div>
            </form>
            <input id="isfalse" value="0" type="hidden" />
       </div> 
   </div>
</div>

<ww:include page="../footer.jsp"/> 
</body>
</html>
<script>
//getSheng();
function choujiang(){
window.location.href="login!ToRegsitOK.jspx";
}
function toChangePassword(){
window.location.href="login!toChangePassword.jspx";
}
<ww:if test="sheng==null||sheng==''">


//getCity();
</ww:if>
function updateUserinfo(){
document.getElementById("isfalse").value="1";
$("#updatebut").hide();
$("#userinfo").show();
}
</script>