<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-常用乘机人</title>

<ww:head name="login" jsURL="member" />
</head>

<body>

<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>   
<!----------header over---------->
<div id="member">
    <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
 <form action="<%=request.getContextPath()%>/login!AddPassenger.jspx" name="form1" method="post" id="form1">
   <div class="right mt10 r">
       <!-- <div>
          <ul>
            <li class="mation fff">会员信息</li>
            <li class="mation_info"><font class="mation_left f"><b>注册时间</b></font><span class="f mr25">会员注册时间为：<ww:property value="formatDate(customeruser.createtime)" /></span>      <font class="f90 f">普通会员</font> <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div> -->
       <div class="box">
            <div class="tit">
                   <font class="black low2 f mr15">基本信息</font>
                   <font class="f mr25 c999">&nbsp;</font>
                   <div class="c"></div>
            </div>
            <div class="data">
                 
                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr> 
                    <td align="right" width="120">姓名：</td>
                    <td><input type="text" class="text_regsit" id="c_passname" name="c_passname" value="<ww:property value="customerpassenger.username" />" /></td>
                     <td align="right">手机号：</td>
                     <td><input type="text" class="text_regsit" id="c_mobile"  name="c_mobile" value="<ww:property value="customerpassenger.mobile" />" /></td>
                   </tr>
                  <tr>
                    <td align="right">性别：</td>
                    <td> 
                    <ww:if test="customerpassenger.id>0">
                    <input type="radio" name="s_sex" id="radio1" value="男" <ww:if test="customerpassenger.sex==\"男\"">checked</ww:if>  />男
                    <input type="radio" name="s_sex" id="radio2" value="女" <ww:if test="customerpassenger.sex==\"女\"">checked</ww:if> />女
                    </ww:if><ww:else>
                    <input type="radio" name="s_sex" id="radio1" value="男" checked="checked" />男
                    <input type="radio" name="s_sex" id="radio2" value="女" />女
                    </ww:else>
                  
                    </td>
                    
                    <td align="right">乘客类型：</td>
                     <td>
                     <select class="text_regsitd" name="c_passtype">
                    <option value="1" <ww:if test="customerpassenger.type==1">selected</ww:if> >成人</option>
                    <option value="2" <ww:if test="customerpassenger.type==2">selected</ww:if>>儿童</option>
                    <option value="3" <ww:if test="customerpassenger.type==3">selected</ww:if>>婴儿</option>
                    </select></td>
                  
                  </tr>
                   <tr style="display: none">
                     <td align="right"> 出生日期：</td>
                     <td><input type="text" class="text_regsit"  value="yyyy-mm-dd" /></td>
                     <td align="right">出生地：</td>
                     <td><input type="text" class="text_regsit" /></td>
                    </tr> 
                 </table>   
            </div>
            <!-- 乘机人ID -->
            <input type="hidden" name="passengerid" value="<ww:property value="customerpassenger.id" />" />
            
            
            <div class="tit">
                   <font class="black low2 f mr15">证件信息 </font>
                    <ww:if test="ListCustomercredit==null">(你还没添加任何证件类型,请选择下面的证件类型进行添加!)</ww:if>
                   <font class="f mr25 c999">&nbsp;</font>
                   <div class="c"></div>
            </div>
            <div class="nohave">&nbsp;</div>
            <div>
            <ww:if test="ListCustomercredit==null">
            <div id="sfz">
            	<table  border="0" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="information">
                  <tr >
                   <td class="hadow" width="15%" align="right">身份证：</td>
                   <td><input type="text" class="text_number" id="sfz_num" name="s_idnumber" value="<ww:property value="sfz.creditnumber" />" /></td>
                   <td rowspan="2">
                   
                   <a href="javascript:deleteType('sfz');"><span class="ico_del">&nbsp;</span>删除</a> 
                   
                   </td>
                   
                  </tr> 
                  <tr >
                   <td class="hadow" width="15%" align="right">有效期：</td>
                   <td><input type="text" class="text_number" id="sfz_time" value="<ww:property value="sfz.passportvalidity" />" name="c_stime" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})" /></td>
                  </tr> 
                  </table>
                 <div class="nohave">&nbsp;</div>
             <input type="hidden"  name="s_idtype" value="1" id="sfz_type" />
             
            </div>
            
            </ww:if><ww:else>
            <div id="sfz" <ww:if test="sfz.id==0">style="display: none"</ww:if>>
            	<table  border="0" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="information">
                  <tr >
                   <td class="hadow" width="15%" align="right">身份证：</td>
                   <td><input type="text" class="text_number" id="sfz_num" name="s_idnumber" value="<ww:property value="sfz.creditnumber" />" /></td>
                   <td rowspan="2">
                   
                   <a href="javascript:deleteType('sfz');"><span class="ico_del">&nbsp;</span>删除</a> 
                   
                   </td>
                   
                  </tr> 
                  <tr >
                   <td class="hadow" width="15%" align="right">有效期：</td>
                   <td><input type="text" class="text_number" id="sfz_time" value="<ww:property value="sfz.passportvalidity" />" name="c_stime" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})" /></td>
                  </tr> 
                  </table>
                 <div class="nohave">&nbsp;</div>
             <input type="hidden"  name="s_idtype" value="<ww:property value="sfz.credittypeid" />" id="sfz_type" />
             
            </div>
            </ww:else>
            
             <div id="hz" <ww:if test="hz.id==0">style="display: none"</ww:if> >	 
                  
                  <table  border="0" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="information">
                  <tr >
                   <td class="hadow" width="15%" align="right">护照：</td>
                   <td><input type="text" class="text_number" id="hz_num" name="s_idnumber" value="<ww:property value="hz.creditnumber" />" /></td>
                   <td rowspan="2"><a href="javascript:deleteType('hz');"><span class="ico_del">&nbsp;</span>删除</a></td>
                  </tr> 
                  
                  <tr >
                   <td class="hadow" width="15%" align="right">有效期：</td>
                   <td><input type="text" id="hz_time"  name="c_stime" class="text_number" value="<ww:property value="hz.passportvalidity" />" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})" /></td>
                  </tr> 
                  </table>
                  <div class="nohave">&nbsp;</div>
                 <input type="hidden" id="hz_type"  name="s_idtype" value="<ww:property value="hz.credittypeid" />" />
             </div>   
              <div id="gatxz" <ww:if test="gatxz.id==0">style="display: none"</ww:if>  >
             
                  <table  border="0" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="information">
                  <tr >
                   <td class="hadow" width="15%" align="right">港澳通行证：</td>
                   <td><input type="text" class="text_number" id="gatxz_num" name="s_idnumber" value="<ww:property value="gatxz.creditnumber" />" /></td>
                   <td rowspan="2"><a href="javascript:deleteType('gatxz');"><span class="ico_del">&nbsp;</span>删除</a></td>
                  </tr> 
                  
                  <tr >
                   <td class="hadow" width="15%" align="right">有效期：</td>
                   <td><input type="text" class="text_number" id="gatxz_time" value="<ww:property value="gatxz.passportvalidity" />" name="c_stime" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})" /></td>
                  </tr> 
                  </table>
                  <div class="nohave">&nbsp;</div>
                   <input type="hidden"  name="s_idtype"  value="<ww:property value="gatxz.credittypeid" />" id="gatxz_type" />
             </div>
             
              <div id="twtxz" <ww:if test="twtxz.id==0">style="display: none"</ww:if>>
             
                  <table  border="0" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="information">
                  <tr >
                   <td class="hadow" width="15%" align="right">台湾通行证：</td>
                   <td><input type="text" class="text_number" id="twtxz_num" name="s_idnumber" value="<ww:property value="twtxz.creditnumber" />" /></td>
                   <td rowspan="2"><a href="javascript:deleteType('twtxz');"><span class="ico_del">&nbsp;</span>删除</a></td>
                  </tr> 
                  
                  <tr >
                   <td class="hadow" width="15%" align="right">有效期：</td>
                   <td><input type="text" class="text_number" id="twtxz_time" value="<ww:property value="twtxz.passportvalidity" />" name="c_stime" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})" /></td>
                  </tr> 
                  </table>
                  <div class="nohave">&nbsp;</div>
                   <input type="hidden"  name="s_idtype" value="<ww:property value="twtxz.credittypeid" />" id="twtxz_type" />
             </div>
             <div id="hxz" <ww:if test="hxz.id==0">style="display: none"</ww:if>>
             
                  <table  border="0" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="information">
                  <tr >
                   <td class="hadow" width="15%" align="right">回乡证：</td>
                   <td><input type="text" class="text_number" id="hxz_num" name="s_idnumber" value="<ww:property value="hxz.creditnumber" />" /></td>
                   <td rowspan="2"><a href="javascript:deleteType('hxz');"><span class="ico_del">&nbsp;</span>删除</a></td>
                  </tr> 
                  
                  <tr >
                   <td class="hadow" width="15%" align="right">有效期：</td>
                   <td><input type="text" class="text_number" id="hxz_time"  value="<ww:property value="hxz.passportvalidity" />" name="c_stime"  onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})"/></td>
                  </tr> 
                  </table>
                  <div class="nohave">&nbsp;</div> 
                  <input type="hidden"  name="s_idtype" value="<ww:property value="hxz.credittypeid" />" id="hxz_type" />
             </div>
             <div id="tbz" <ww:if test="tbz.id==0">style="display: none"</ww:if>>
             
                  <table  border="0" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="information">
                  <tr >
                   <td class="hadow" width="15%" align="right">台胞证：</td>
                   <td><input type="text" class="text_number" id="tbz_num" name="s_idnumber" value="<ww:property value="tbz.creditnumber" />" /></td>
                   <td rowspan="2"><a href="javascript:deleteType('tbz');"><span class="ico_del">&nbsp;</span>删除</a></td>
                  </tr> 
                  
                  <tr >
                   <td class="hadow" width="15%" align="right">有效期：</td>
                   <td><input type="text" class="text_number" id="tbz_time" name="c_stime" value="<ww:property value="tbz.passportvalidity" />"  onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})"/></td>
                  </tr> 
                  </table>
                  <div class="nohave">&nbsp;</div>
                   <input type="hidden"  name="s_idtype" value="<ww:property value="tbz.credittypeid" />" id="tbz_type" />
             </div>
             
             <div id="qt" <ww:if test="qt.id==0">style="display: none"</ww:if>>
             
                  <table  border="0" cellpadding="0" cellspacing="0" style="border-collapse:collapse" class="information">
                  <tr >
                   <td class="hadow" width="15%" align="right">其他：</td>
                   <td><input type="text" class="text_number" id="qt_num" name="s_idnumber" value="<ww:property value="qt.creditnumber" />" /></td>
                   <td rowspan="2"><a href="javascript:deleteType('qt');"><span class="ico_del">&nbsp;</span>删除</a></td>
                  </tr> 
                  
                  <tr >
                   <td class="hadow" width="15%" align="right">有效期：</td>
                   <td><input type="text" class="text_number" id="qt_time" value="<ww:property value="qt.passportvalidity" />" name="c_stime" onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'%y-#{%M}-%d'})" /></td>
                  </tr> 
                  </table>
                  <div class="nohave">&nbsp;</div>
                  <input type="hidden"  name="s_idtype" value="<ww:property value="qt.credittypeid" />" id="qt_type"/>
             </div>
             
             
                  <table width="90%" border="0" cellspacing="0" cellpadding="0" class="centerall">
                  <tr> 
                   <ww:if test="ListCustomercredit==null">
                    <td width="14%"><span id="type_sfz"class="ico_on">&nbsp;</span><a href="javascript:changtype('sfz','1');">身份证</a></td>
                   
                   </ww:if><ww:else>
                    <td width="14%"><span id="type_sfz" <ww:if test="sfz.id==0">class="ico_add"</ww:if><ww:else>class="ico_on"</ww:else>>&nbsp;</span><a href="javascript:changtype('sfz','1');">身份证</a></td>
                   
                   </ww:else>
                    
                    <td width="12%"><span id="type_hz" <ww:if test="hz.id==0">class="ico_add"</ww:if><ww:else>class="ico_on"</ww:else> >&nbsp;</span><a href="javascript:changtype('hz','2');">护照</a></td>
                    <td width="16%"><span id="type_gatxz" <ww:if test="gatxz.id==0">class="ico_add"</ww:if><ww:else>class="ico_on"</ww:else>>&nbsp;</span><a href="javascript:changtype('gatxz','3');">港澳通行证</a></td>
                    <td width="16%"><span id="type_twtxz" <ww:if test="twtxz.id==0">class="ico_add"</ww:if><ww:else>class="ico_on"</ww:else>>&nbsp;</span><a href="javascript:changtype('twtxz','4');">台湾通行证</a></td>
                    <td width="16%"><span id="type_hxz" <ww:if test="hxz.id==0">class="ico_add"</ww:if><ww:else>class="ico_on"</ww:else>>&nbsp;</span><a href="javascript:changtype('hxz','5');">回乡证</a></td>
                    <td width="16%"><span id="type_tbz" <ww:if test="tbz.id==0">class="ico_add"</ww:if><ww:else>class="ico_on"</ww:else>>&nbsp;</span><a href="javascript:changtype('tbz','6');">台胞证</a></td>
                    <td><span id="type_qt" <ww:if test="qt.id==0">class="ico_add"</ww:if><ww:else>class="ico_on"</ww:else>>&nbsp;</span><a href="javascript:changtype('qt','7');">其他</a></td>
                   </tr>
                   <!--
                   <tr> 
                    <td><span class="ico_add">&nbsp;</span>港澳通行证</td>
                    <td><span class="ico_add">&nbsp;</span>台湾通行证</td>
                    <td><span class="ico_add">&nbsp;</span>国际海员证</td>
                    <td><span class="ico_add">&nbsp;</span>台胞证</td>
                    <td><span class="ico_add">&nbsp;</span>其他</td>
                    <td></td>
                  </tr>
                 -->
                 </table> 
            </div>
            
       </div> <input type="button" value="保存信息" onclick="sub();" class="bst mt20 mf50"  />
       <div class="nohave"></div>
   </div>
 </form>
</div>
<ww:include page="../footer.jsp"/>  
</body>
</html>
<script>
function changtype(id,va){
//alert(document.getElementById("type_"+id).ClassName());

//alert($("#type_"+id).attr('class'));

var classname=$("#type_"+id).attr('class');
if(classname=='ico_add'){
$('#'+id).show();

$('#'+id+"_type").val(va);//显示证件类型值

$("#type_"+id).removeClass('ico_add');
$("#type_"+id).addClass('ico_on');
//$("#help"+i).removeClass('open');
}else{

//$('#'+id).hide();

//$("#type_"+id).removeClass('ico_on');
//$("#type_"+id).addClass('ico_add');

}
}

function  deleteType(id){
$('#'+id).hide();
$("#type_"+id).removeClass('ico_on');
$("#type_"+id).addClass('ico_add');

$('#'+id+"_num").val("");
$('#'+id+"_time").val("");
$('#'+id+"_type").val("");
}
function sub(){
//验证姓名
if($("#c_passname").val()==''){

	$("#c_passname").poshytip({
				content: "姓名不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#c_passname").focus();
				return false;

}

//
//验证手机号
 if($("#c_mobile").val()==""){  
	 //验证提示
	 $('#c_mobile').poshytip({
				//className: 'tip-yellowsimple',
				content: "手机号不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			});
	$("#c_mobile").focus();
	 return false; 
	 }
var mobile= $("#c_mobile").val(); 
	if(!IsMobile(mobile)){
	 		 $("#c_mobile").poshytip({
				content: "手机号格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#c_mobile").focus();
 		return false;
}
//

//验证性别

var s_sex1 = document.getElementById("radio1").checked;
var s_sex2 = document.getElementById("radio2").checked;

if(s_sex1==false&&s_sex2==false){
 				$("#radio2").poshytip({
				content: "性别不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#radio2").focus();
				return false;
 
}




//


//验证身份证--sfz_type
if($("#sfz_type").val()!=''){
		if($("#sfz_num").val()==''){
		 		$("#sfz_num").poshytip({
				content: "身份证号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#sfz_num").focus();
				return false;
	}else if(!shenfen($("#sfz_num").val())){
	
			$("#sfz_num").poshytip({
				content: "身份证号码格式错误!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#sfz_num").focus();
				return false;
	}
	if($("#sfz_time").val()==''){
		 		$("#sfz_num").poshytip({
				content: "身份证有效期不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#sfz_time").focus();
				return false;
	}
}
//
//验证护照--hz_type
if($("#hz_type").val()!=''){
		if($("#hz_num").val()==''){
		 		$("#hz_num").poshytip({
				content: "护照号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#hz_num").focus();
				return false;
	}else if(!IsNumber($("#hz_num").val())){
	
			$("#hz_num").poshytip({
				content: "护照号码格式错误!只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#hz_num").focus();
				return false;
	}
		if($("#hz_time").val()==''){
		 		$("#hz_time").poshytip({
				content: "护照有效期不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    //$("#hz_time").focus();
				return false;
	}
}
//
//验证港澳通行证--gatxz_type
if($("#gatxz_type").val()!=''){
		if($("#gatxz_num").val()==''){
		 		$("#gatxz_num").poshytip({
				content: "港澳通行证号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#gatxz_num").focus();
				return false;
	}else if(!IsNumber($("#gatxz_num").val())){
	
			$("#gatxz_num").poshytip({
				content: "港澳通行证号码格式错误!只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#gatxz_num").focus();
				return false;
	}
		if($("#gatxz_time").val()==''){
		 		$("#gatxz_time").poshytip({
				content: "港澳通行证有效期不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    //$("#gatxz_time").focus();
				return false;
	}
}
//
//验证台湾通行证--twtxz_type
if($("#twtxz_type").val()!=''){
		if($("#twtxz_num").val()==''){
		 		$("#twtxz_num").poshytip({
				content: "台湾通行证号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#twtxz_num").focus();
				return false;
	}else if(!IsNumber($("#twtxz_num").val())){
	
			$("#twtxz_num").poshytip({
				content: "台湾通行证号码格式错误!只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#twtxz_num").focus();
				return false;
	}
		if($("#twtxz_time").val()==''){
		 		$("#twtxz_time").poshytip({
				content: "台湾通行证有效期不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    //$("#twtxz_time").focus();
				return false;
	}
}
//
//验证回乡证--hxz_type
if($("#hxz_type").val()!=''){
		if($("#hxz_num").val()==''){
		 		$("#hxz_num").poshytip({
				content: "回乡证号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#hxz_num").focus();
				return false;
	}else if(!IsNumber($("#hxz_num").val())){
	
			$("#hxz_num").poshytip({
				content: "回乡证号码格式错误!只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#hxz_num").focus();
				return false;
	}
		if($("#hxz_time").val()==''){
		 		$("#hxz_time").poshytip({
				content: "回乡证有效期不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    //$("#hxz_time").focus();
				return false;
	}
}
//
//验证台胞证--tbz_type
if($("#tbz_type").val()!=''){
		if($("#tbz_num").val()==''){
		 		$("#tbz_num").poshytip({
				content: "台胞证号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#tbz_num").focus();
				return false;
	}else if(!IsNumber($("#tbz_num").val())){
	
			$("#tbz_num").poshytip({
				content: "台胞证号码格式错误!只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#tbz_num").focus();
				return false;
	}
		if($("#tbz_time").val()==''){
		 		$("#tbz_time").poshytip({
				content: "台胞证有效期不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    //$("#tbz_time").focus();
				return false;
	}
}
//
//验证其他--qt_type
if($("#qt_type").val()!=''){
		if($("#qt_num").val()==''){
		 		$("#qt_num").poshytip({
				content: "其他证件号码不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#qt_num").focus();
				return false;
	}else if(!IsNumber($("#qt_num").val())){
	
			$("#qt_num").poshytip({
				content: "其他证件号码格式错误!只能为数字!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'right',
				alignY: 'center',
				offsetX: 5
			    });
			    $("#qt_num").focus();
				return false;
	}
		if($("#qt_time").val()==''){
		 		$("#qt_time").poshytip({
				content: "其他证件有效期不能为空!",
				showOn: 'focus',
				alignTo: 'target',
				alignX: 'left',
				alignY: 'center',
				offsetX: 5
			    });
			    //$("#qt_time").focus();
				return false;
	}
}
//

 document.form1.submit();
}



</script>