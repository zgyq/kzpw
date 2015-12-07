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
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
	
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
</head>
<script>
	 $(document).ready(function(){
		//如果是查看页面，将所有的文本框禁用
		if(getParameter()=="true")
		 {
		     $("#form1 input[type='text']").each(function(i){
			    $(this).attr("disabled","disabled");
			 });
             $("#tr_button").hide();
             $("#ddlagentcityid").attr("disabled","disabled");
             $("#ddltempciyid").attr("disabled","disabled");
             $("#airportcode").attr("disabled","disabled");
             $("#rdoischildcomyes").attr("disabled","disabled");
		  }
	     });
    function getParameter()
        {
             var args=new Object();   
             var query=location.search.substring(1);//获取查询串   
             var pairs=query.split("&");//在逗号处断开   
             for(var    i=0;i<pairs.length;i++)   
             {   
                 var pos=pairs[i].indexOf('=');//查找name=value   
                    if(pos==-1)   continue;//如果没有找到就跳过   
                     var argname=pairs[i].substring(0,pos);//提取name   
                    var value=pairs[i].substring(pos+1);//提取value   
                    args[argname]=unescape(value);//存为属性   
            }
             return args["s_isview"];

        }

		
		//function check(){
//		
//		var obj=document.getElementById("se");
//		var va=obj.options[obj.selectedIndex].value;
//		if(va==1){
//		document.getElementById("sp").innerHTML="‰";
//		document.getElementById("runvalue").className="validate[custom[onlyNumber]]";
//		}
//		if(va==2){
//		document.getElementById("sp").innerHTML="元";
//		document.getElementById("runvalue").className="validate[custom[onlyNumber]]";
//		}
//		if(va==3){
//		document.getElementById("sp").innerHTML="";
//		document.getElementById("runvalue").className="";
//		}
//		
//		}
//加载市级信息
function loadcitylist()
{
    $("#ddltempciyid").hide();
    $("#divcitylist").show(); 
    $.ajax({
      type:"GET",
      url:"customeragent!loadcitylist.action",
      data:{s_provinceid:$("#ddlagentcityid").val()},
      beforeSend:function(){$("#divcitylist").html("正在加载市级信息...");},             
      success:function(data){
      $("#divcitylist").html(data);           
      }            
      });
}
//对市级信息赋值
function bindcityid()
{
   $("#txtcityid").val($("#ddlciyid").val());
}

//选择 自有 隐藏信息

function comself(obj){
  hideInfo(obj.checked);
}
var show=1;
function hideInfo(ret){
   if(ret){
    $(".otherinfo").hide();
    show=0;
  }else{
  $(".otherinfo").show();
  show=1;
  }
}
//初始化信息
$(document).ready(function(){
	//初始化省份
	loadcitylist();
	// 初始化编辑信息
	editenable();
	<ww:if test="customeragent.selfcode==1">
	hideInfo(true);
	</ww:if>
	} );

//编辑时 disable 信息
function editenable(){
  <ww:if test="customeragent.id>0&&customeragent.id==getLoginUser().agentid">
    $(".two").attr("disabled","disabled");
  </ww:if>
  <ww:if test="customeragent.agenttype==2">
  $(".ngy").hide();
  </ww:if>
}

//验证编码
function valCode(){
var code=true;
if(show==1){
 var id=$(".code").attr("id"); 
 code=twoval(id,new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'编码不可包含非法字符',false]},{'data':['ajax','vaidate!validateAgentCode.action','此编码已存在']}));
 }
 return code;
}


//验证员工数

function checkNUM(){

 var usernum=$("#industry2").val();
 
 if(usernum!=''){
 
 
 
 	 	if(!/^[1-9]\d*$/.test(usernum)){

                alert('员工数输入错误');

               $("#industry2").val("");

        }else{

               

       }


         
         
         
 	

 	
 	
 
 }
 

 
}

function IsNum(txtValue){
	var exp, op;
	op = txtValue;
    exp = /^((\d{1,}(,\d{3})*?)|\d+)(\.\d{1,2})?$/;
    if (op.match(exp) == null){ 
        return false;
    }else{
		return true;
    }
}

//验证用户名
function valUname(){
var uname=true;
var lid=$(".lname").attr("id");
uname=twoval(lid,new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'用户名不可包含非法字符',false]},{'data':['length','','长度必须在5-16位之间']},{'data':['ajax','vaidate!validateusername.action','此用户名已存在']}));
return uname;
}



//验证密码
function valPwd(){
var pwd=true;
<ww:if test="customeragent.id==0">
pwd=twoval("password",new Array({'data':['required','','不可为空']}));
</ww:if>
return pwd;
}
//验证公司名称
function valCompany(){
var cname=true;
if(show==1){
var cid=$(".cname").attr("id"); 
 cname=twoval(cid,new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'公司名称不可包含非法字符',false]},{'data':['ajax','vaidate!validateAgentName.action','此公司名字已存在']}));
 }
return cname;
}

function valAgengtshortname(){
var cname=true;
if(show==1){
 cname=twoval('shortname',new Array({'data':['required','','不可为空']},{'data':['regexp',new RegExp('[^a-zA-Z0-9\_\u4e00-\u9fa5]'),'公司简称不可包含非法字符',false]}));
 }
return cname;
}
//验证联系人呢
function valLinkname(){
var link=true;
if(show==1){
 link= twoval("contactname",new Array({'data':['required','','不可为空']}));
 }
 
 return link;
}
//验证支付宝
function valalipay(){

var alipay=true; 
 return alipay;
}

//验证联系电话
function valLinkmobile(){
var linkmobile=true;
if(show==1){
 var reg=new RegExp(/^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|14[0-9]|15[0-9]|16[0-9]|17[0-9]|18[0-9])\d{8}$)/);
  var linkmobile=twoval("agentphone",new Array({'data':['required','','不可为空']},{'data':['regexp',reg,'号码有误（固话加区号或移动电话）',true]}));
 }
 return linkmobile;
}
//验证业务类型
function valBusiness(){
<ww:if test="(customeragent.id>0&&customeragent.id!=getLoginsessionagent().id)||customeragent.id==0">
var len=$("input[name='businesstype']:checked").length;
if(len==0){

 $("#vbusinesstype").html("请至少选择一种业务类型");
 return false;
}else{
$("#vbusinesstype").html("");
  return true;
}
</ww:if>
<ww:else>
return  true;
</ww:else>
}
//验证网址
function valweb(str_url){
if(str_url!=""){
         var strRegex = "^((https|http|ftp|rtsp|mms)?://)" 
         + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@ 
         + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184 
         + "|" // 允许IP和DOMAIN（域名）
         + "([0-9a-z_!~*'()-]+\.)*" // 域名- www. 
         + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名 
         + "[a-z]{2,6})" // first level domain- .com or .museum 
         + "(:[0-9]{1,4})?" // 端口- :80 
         + "((/?)|" // a slash isn't required if there is no file name 
         + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$"; 
         var re=new RegExp(strRegex); 
   //re.test()
         if (re.test(str_url)){
             $("#vwebsite").html("");
             return (true); 
         }else{ 
         $("#vwebsite").html("您输入的网址不正确");
             return false; 
         }
         }else{
         return true;
         }

}
//验证姓名名
function valUsername(){
   return  twoval("username",new Array({'data':['required','','不可为空']}));
}

function vallevel(){
  var levelval=$("#levelid").val();
  if(levelval!="不限")
  if(isNaN(levelval)){
  $("#levelid").val("");
    $("#vlevelid").html("只可输入数字");
    return false;
  }else{
  $("#vlevelid").html("");
  return true;
  }
}
function valproxy(){
  var levelval=$("#proxyid").val();
  if(levelval!="不限")
  if(isNaN(levelval)){
  $("#proxyid").val("");
    $("#vproxyid").html("只可输入数字");
    return false;
  }else{
  $("#vproxyid").html("");
  return true;
  }
}



//提交验证
function valform(){
var uname=true;
var pwd=true;
//var code=valCode();
var cname=valCompany();
var shortname=valAgengtshortname();
var web=true;
uname=valUname();
pwd=valPwd();
	//var alipay=valalipay();
 var linkname=valLinkname();
 
 var linkm=valLinkmobile();
 if($("#website").val!=""){
    web=valweb($("#website").val());
 }
 var bus=valBusiness();
 var username=valUsername();
 
 if(cname&&shortname&&uname&&linkname&&linkm&&pwd&&web&&bus&&username){
   return true;
 }else{
  return false;
 }
}

function addAgent(){
 var usernum=$("#industry2").val();
 if(usernum!=''){
 	 	if(!/^[1-9]\d*$/.test(usernum)){
                alert('员工数输入错误');

               $("#industry2").val("");
               return;
        }else{
       }
 }	

var valresult=valform();
<ww:if test="1==2">
$("#form1").attr("action","customeragent!agentnextrequest.action");
if(valresult){
	Ext.Ajax.request({
	form:'form1',
	success:function(resp,opts){
	 var respText = resp.responseText;
	if(respText=="true"||respText==true){
	  Ext.MessageBox.alert("提示", "您的开户请求已成功提交至平台审核...", function(){
            window.history.go(-1);
            });

				
	  }else{
	 Ext.MessageBox.alert("提示","抱歉，由于网络原因导致添加失败，请重试或联系平台人员！");
	  }
	},
	falider:function(){
	 Ext.MessageBox.alert("提示","抱歉，由于网络原因导致添加失败，请重试或联系管理人员！");
	}
	});

 }
</ww:if>
<ww:else>
if(valresult){
$("#form1").submit();
}
</ww:else>
}
function checkAgent(id){
var valresult=valform();
if(valresult){
$("#form1").attr("action","customeragent!edit.action?id="+id+"&customeragent.agentcheckstatus=1");
$("#form1").submit();
}
}
</script>
<body>
<div id="member">

<form
	action='customeragent!<ww:if test="customeragent.id>0">edit.action?id=<ww:property value="customeragent.id"/></ww:if><ww:else>add.action</ww:else>'
	name="form1" method="post" id="form1" onsubmit="return valform();"  >


<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;
		<ww:if test="customeragent.id>0">编辑 <span style="color: red">
			<ww:property value="customeragent.agentcompanyname" /></span>
		</ww:if> <ww:else>
			新增
			<!--<ww:property value="getAgentTypeName(customeragent.agentjibie)" />-->
			<ww:if test="customeragent.agentjibie>0">
				<span style="color: red"> (<span style="color: red">所属<ww:property value="#request.typestr"/>:<ww:property
					value="getagentname_b2bback(customeragent.parentid)" /> </span>)</span>
			</ww:if>

		</ww:else><ww:property value="#request.typestr"/>信息表</b></td>
	</tr>
	<input type="hidden" name="agentjibie"
		value='<ww:property value="customeragent.agentjibie"/>'>
	<input type="hidden" name="parentid"
		value="<ww:property value="customeragent.parentid" />" />
	<input type="hidden" name="agenttype"
		value="<ww:property value="customeragent.agenttype" />" />
    <ww:if test="customeragent.id==0">
    <ww:if test="getLoginsessionagent().agenttype==1">
	<input type="hidden" name="agentcheckstatus"
		value="1" />
    </ww:if>
    <ww:else>
	<input type="hidden" name="agentcheckstatus"
		value="1" />
    </ww:else>
    </ww:if>
	<tr>
		<td valign="top">

		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="88%" style="padding-top: 10px;">
				<table width="88%" cellpadding="0" cellspacing="0" border="1"
					bordercolor="#a0cfee"
					style="margin: 0 auto; border-collapse: collapse;">

					<tr>
						<td colspan="4">
						<div style="padding-left: 20px;"><img src="images/fenge.gif"
							align="absmiddle">基本信息 &nbsp;&nbsp;&nbsp; 
							 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <ww:if
							test="customeragent.id>0">
							<span style="color: red"> <b>所属<ww:property value="#request.typestr"/><!-- 级别：<ww:property
								value="getAgentTypeName(customeragent.agentjibie)" /> --></b> </span>
						</ww:if></div>
						</td>
					</tr>
					<tr class="otherinfo" id='fid'>
						<td height="28" align="right" style="width: 100px">
						<div class="td_color">编码：</div>
						</td>
						<td class="table_color_l">
						<ww:if test="customeragent.id>0">
						<ww:property value="customeragent.code"/>
						</ww:if>
						<ww:else>
						 系统生成
						</ww:else>
						</td>
						<td height="28" style="text-align: right;width: 100px">
						<div class="td_color"><span>状态：</span></div>
						</td>
						<td>&nbsp;&nbsp; <span> <input type="radio"
							name="agentisenable" value="1" class='two'
							<ww:if test="customeragent.agentisenable==1||customeragent.agentisenable==null">checked</ww:if> />启用&nbsp;
						<input type="radio" name="agentisenable" value="0" class='two'
							<ww:if test="customeragent.agentisenable==0">checked</ww:if> />禁用

						</span></td>
					</tr>
					<tr>
						<td height="28" align="right">
						<input type="hidden" name='loginuid' value='${user.id }'>
						<div class="td_color">登录名：</div>
						</td>
						<td class="table_color_l" style="width: 340px"><input
							type="text" name="loginname" maxlength="50" id='loginname${user.id }'
							value='${user.loginname }' class="two lname" onblur="valUname()"
							style="width: 150px" /> <font style="color: red">*&nbsp;</font><font
							style="color: red" id='vloginname'>5-16位英文字母与数字</font></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>密码：</span></div>
						</td>
						<td class="table_color_l"><span> <input type="password" onblur="valPwd()"
							name="password" id="password" class='two' />
							<font style="color: red">*</font> 
							<font style="color: red" id='vpassword'></font> </span></td>
					</tr>
					<tr>
						<td height="28" align="right">
						<div class="td_color">姓名：</div>
						</td>
						<td class="table_color_l" style="width: 340px"><input
							type="text" name="username" value='${user.membername }' maxlength="50" id='username'
							 class="two" onblur="valUsername()"
							style="width: 150px" /> <font style="color: red">*&nbsp;</font>
							<font style="color: red" id='vusername'></font></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>电话：</span></div>
						</td>
						<td class="table_color_l"><span> 
						<input type="text"
							name="usermobile" value='${user.membermobile }' class='two' />
					    <font style="color: red"></font> 
						 </span></td>
					</tr>

					<tr class="otherinfo">

						<td height="28" align="right" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>允许代理级别：</span></div>
						</td>
						<td class="table_color_l">
						<!--<div style="position: relative; float: left;"><span
							style="margin-left: 100px; width: 18px; overflow: hidden;">
						<select  style="width: 150px; margin-left: -100px;" class="two"
							onchange='javascript:$("#levelid").val(this.value);changeProxy(this.value);'>
							<ww:iterator value="#request.levelarray" status="stu">
								<option
									value='<ww:property value="#request.levelarray[#stu.index]"/>'>
								<ww:property value="#request.levelarray[#stu.index]" /></option>
							</ww:iterator>
						</select></span>
						<input name="levelcount" id='levelid' class="two"  onblur="changeProxy(this.value);vallevel()"
							style='<ww:if test="#request.allowlevel!=null">display: none;</ww:if> width: 128px; position: absolute; left: 0px; top: 2px;'>
						</div>
						-->
						<select  style="width: 150px;" class="two" name="levelcount">
								<option value='0' <ww:if test="customeragent.allowlevelcount==0">selected</ww:if>>0</option>
								<option value='1' <ww:if test="customeragent.allowlevelcount==1">selected</ww:if>>1</option>
								<option value='2' <ww:if test="customeragent.allowlevelcount==2">selected</ww:if>>2</option>
								<option value='3' <ww:if test="customeragent.allowlevelcount==3">selected</ww:if>>3</option>
								<option value='-1' <ww:if test="customeragent.allowlevelcount==-1">selected</ww:if>>不限</option>
						</select>&nbsp;&nbsp;级
						
						
						<span
							style="clear: both"></span>
							<font style="color: red" id='vlevelid'>根据实际需求填写</font>
							</td>
						<td height="28" align="right" style="text-align: right;"
							class="table_color colortrin">

						<div class="td_color"><span >允许代理数量：</span></div>						
						</td>
						<td class="table_color_l" >
						<!--		
					       <div style="position:relative; float: left;">
							<span style="margin-left:100px;width:18px;overflow:hidden;">
							<select id='levelselect' class="two" style="width:150px;margin-left:-100px" onchange='javascript:$("#proxyid").val(this.value)'>
							<ww:iterator value="#request.proxyarray" status="stu">
						<option   value='<ww:property value="#request.proxyarray[#stu.index]"/>'>
						<ww:property value="#request.proxyarray[#stu.index]"/></option>
						</ww:iterator>
						</select></span>
						<input name="proxycount" id="proxyid" class="two"  onblur="valproxy()" style='<ww:if test="#request.allowproxy!=null">display: none;</ww:if> width:128px;position:absolute;left:0px; top:2px;'>
						</div>
					-->
					<select  style="width: 150px;" class="two" name="proxycount">
								<option value='0' <ww:if test="customeragent.allowproxycount==0">selected</ww:if>>0</option>
								<option value='1' <ww:if test="customeragent.allowproxycount==1">selected</ww:if>>1</option>
								<option value='5' <ww:if test="customeragent.allowproxycount==5">selected</ww:if>>5</option>
								<option value='10' <ww:if test="customeragent.allowproxycount==10">selected</ww:if>>10</option>
								<option value='30' <ww:if test="customeragent.allowproxycount==30">selected</ww:if>>30</option>
								<option value='-1' <ww:if test="customeragent.allowproxycount==-1">selected</ww:if>>不限</option>
					</select>			
					 &nbsp;&nbsp;个<span style="clear:both"></span>
						<font style="color: red" id='vproxyid'>根据实际需求填写</font>					
						</td></tr>					
						<tr class="otherinfo ngy">
						<td height="28" align="right" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>默认出发城市：</span></div>
						</td>
						<td class="table_color_l"><select style="width: 150px"
							name="airportcode" id="airportcode">
							<ww:iterator value="listcityairport">
								<ww:property value="airportcode" />
								<option value="<ww:property value="airportcode" />"
									<ww:if test="customeragent.airportcode==airportcode">selected</ww:if>><ww:property
									value="shortpinyin" />&nbsp;&nbsp;<ww:property
									value="cityname" /></option>
							</ww:iterator>
						</select> &nbsp; </td>
						<td height="28" align="right" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>所在省份：</span></div>
						</td>
						<td class="table_color_l">
						<table border="0" width="0">
							<tr>
								<td><select style="width: 100px" name="agentcityid"
									id="ddlagentcityid" onchange='loadcitylist()'>
									<ww:iterator value="listprovince">
										<option value="<ww:property value="id" />"
											<ww:if test="customeragent.agentcityid==id">selected</ww:if>><ww:property
											value="code" />&nbsp;&nbsp;<ww:property value="name" /></option>
									</ww:iterator>
								</select></td>
								<td>&nbsp;&nbsp;</td>
								<td>
								<div id="divcitylist"
									<ww:if test="customeragent.cityid!=null">style='display:none'</ww:if>></div>

								<select id="ddltempciyid"
									<ww:if test="customeragent.cityid==null || customeragent.cityid==0">style='display:none'</ww:if>>
									<option value="<ww:property value="customeragent.cityid" />"><ww:property
										value="getCityNamebyId(customeragent.cityid)" /></option>
								</select> <input type="hidden" name="s_cityid" id="txtcityid"
									value='<ww:property value="customeragent.cityid" />' /></td>
							</tr>
						</table>
						</td>
					</tr>
						
						
					
						<tr class="otherinfo ngy">
							<td height="28" align="right" style="text-align: right;"
								class="table_color colortrin">
							<div class="td_color">是否允许月结</div>
							</td>
							<td class="table_color_l">
							<input type="radio"
								id="rdomonthpayno" name="isallowmonthpay"
								<ww:if test="customeragent.isallowmonthpay==0  || customeragent.isallowmonthpay==null">checked="checked"</ww:if>
								value="0" />否&nbsp; <input type="radio" name="isallowmonthpay"
								id="rdomonthpayyes" value="1"
								<ww:if test="customeragent.isallowmonthpay==1">checked="checked"</ww:if> />是
							</td>

							<td height="28" align="right" style="text-align: right;">
							<div class="td_color"><span>有效期：</span></div>
							</td>
							<td class="table_color_l">
							<input type="text" id='vone'
								name="c_agentvsdate"
								value='<ww:property value="formatDate(customeragent.agentvsdate)"/>'
								style="width: 85px" onfocus="WdatePicker()" id="txtagentvsdate"
								class="Wdate two" />- 
								<input type="text" name="c_agentvedate"
								id="txtagentvedate"
								value='<ww:property value="formatDate(customeragent.agentvedate)"/>'
								style="width: 85px" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'vone\',{d:+1});}'})" class="Wdate two" />
							</td>
						</tr>
					
				<ww:if test="getLoginsessionagent().agenttype==1">
					<tr>
					
						<td height="28" align="right">
						<div class="td_color">类型：</div>
						</td>
						<td class="table_color_l" style="width: 340px">
						
						
						<input type="radio"  onclick="checkType(1);"
								id="atype0" name="bigtype"
								<ww:if test="customeragent.bigtype==null  || customeragent.bigtype==0">checked="checked"</ww:if>
								value="0" />分销商
						
						<input type="radio" onclick="checkType(2);"
								id="atype1" name="bigtype"
								<ww:if test="customeragent.bigtype==1">checked="checked"</ww:if>
								value="1" />经销商
								
						<input type="radio"  onclick="checkType(3);"
								id="atype2" name="bigtype"
								<ww:if test="customeragent.bigtype==2">checked="checked"</ww:if>
								value="2" />旅行社			
						
							<font style="color: red" ></font></td>
					
						
						<td height="28" style="text-align: right;display: none" id="angettype1">
						<div class="td_color"><span>返点：</span></div>
						</td>
						<td class="table_color_l" style="display: none" id="angettype2"><span> 
						<input type="text" id="agentvalue"
							name="fixedvalue" value="<ww:property value="customeragent.fixedvalue"/>" class='two' />
					    <font style="color: red">%</font> 
						 </span></td>
						 
						 <!-- 允许员工数 -->
						 
						
						
					</tr>
					</ww:if>
					<ww:elseif test="getLoginsessionagent().bigtype==0">
					<tr>
					
						<td height="28" align="right">
						<div class="td_color">类型：</div>
						</td>
						<td class="table_color_l" style="width: 340px">
						
						
						<input type="radio"  onclick="checkType(1);"
								id="atype0" name="bigtype"
								checked="checked"
								value="0" />分销商
						</td>
					
					</tr>


					</ww:elseif>
					
					
					<tr>
						<td height="28" align="right">
						<div class="td_color"></div>
						</td>
						<td class="table_color_l" style="width: 340px">
					
						
						
								
												
						
							<font style="color: red" ></font></td>
					
						
						
						 <td height="28" style="text-align: right;" id="industry">
						<div class="td_color"><span>允许员工数：</span></div>
						</td>
						<td class="table_color_l" id="industry1"><span> 
						<input type="text" id="industry2" onblur="checkNUM();" class=""
							name="industry" value="<ww:property value="customeragent.industry"/>"  />
					     <font style="color: red">*(默认为空为不限制!)</font> 
						 </span></td>
						
						 
						
						
					</tr>
					<tr>
					<td height="28" align="right">
						<div class="td_color">行程单数：</div>
						</td>
						<td class="table_color_l" style="width: 340px"><input
							type="text" name="ismodifyret" value="<ww:property value="customeragent.ismodifyret"/>" maxlength="50" id='ismodifyret'
							 class="two" 
							style="width: 150px" /> <font style="color: red">*(只能输入整数数字)</font>
							</td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>押金：</span></div>
						</td>
						<td class="table_color_l"><span> 
						<input type="text"
							name="smsmoney" value="<ww:property value="customeragent.smsmoney"/>" class='two' />
							<font style="color: red">*(只能输入整数数字)</font>
					   
						 </span></td>
					</tr>
					<tr>
					   <td height="28" align="right">
						<div class="td_color">限制查询次数：</div>
						</td>
						
						<td class="table_color_l" style="width: 340px"><input
							type="text" name="searchtoall" value="<ww:property value="customeragent.searchtoall"/>" maxlength="50" id='searchtoall'
							 class="two" 
							style="width: 150px" /> <font style="color: red">*(只能输入整数数字)</font>
							</td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>已用查询次数：</span></div>
						</td>
						<td class="table_color_l"><span> 
						<input type="text"
							name="searchnum" value="<ww:property value="customeragent.searchnum"/>" class='two' />
							<font style="color: red">*(只能输入整数数字)</font>
					   
						 </span></td>
					</tr>
					<tr>
					<td height="28" align="right">
						<div class="td_color">系统账号备注：</div>
						</td>
						<td class="table_color_l" colspan="3"><input 
							type="text" name="beizhu" value="<ww:property value="customeragent.beizhu"/>"  id='beizhu'
							 class="two" 
							style="width: 350px" /> 
							</td>
						
					</tr>
					<ww:if test="getLoginsessionagent().agenttype==1&&agenttype==2">
					<tr>
					<td height="28" align="right">
						<div class="td_color">供应商费率：</div>
						</td>
						<td class="table_color_l" colspan="3">千分之<input 
							type="text" name="brokenum" value="<ww:property value="customeragent.brokenum"/>"  id='brokenum'
							 class="two" 
							style="width: 150px" /><span style="color: red;">(默认不填写就是无费率,如果千4的费率 就直接输入4就可以)</span> 
							</td>
						
					</tr>
					</ww:if>
					<ww:if test="getLoginsessionagent().agenttype==1">
					<tr>
					<td height="28" align="right">
						<div class="td_color">是否可用APP：</div>
						</td>
						<td class="table_color_l" colspan="3">
						<select name="runtype">
							<option value="0"
								<ww:if test="customeragent.runtype==0">selected</ww:if>>不可用</option>
							<option value="1"
								<ww:if test="customeragent.runtype==1">selected</ww:if>>可用</option>
						</select>
							</td>
						
					</tr>
					</ww:if>
					<!-- 非自有隐藏以下信息 -->
					<span class="otherinfo">
					<tr>
						<td colspan="4" style="padding-left: 20px;">
						<div><img src="images/fenge.gif" align="absmiddle">公司信息</div>
						</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>公司名称：</span></div>
						</td>
						<td class="table_color_l"><input type="text" onblur="valCompany()"
							id='comname<ww:property value="customeragent.id"/>'
							name="agentcompanyname" id="agentcompanyname" desc="单位名称"
							class="cname"
							value='<ww:property value="customeragent.agentcompanyname"/>'
							style="width: 150px" /><font style="color: red">*</font>
							<font id='vcomname<ww:property value="customeragent.id"/>' style="color: red"></font>
							</td>
						
						<td height="28" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>
						<ww:if test="customeragent.agenttype==2">
						  上班时间：
						</ww:if>
						<ww:else>
						公司简称：
						</ww:else>
						</span></div>
						</td>
						<td class="table_color_l">
						<ww:if test="customeragent.agenttype==2">
					   <input size='7' name="worktimebegin" value='<ww:property value="customeragent.worktimebegin==null?'08:00':customeragent.worktimebegin"/>'  onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm'})" />
						-
						<input size='7' name="worktimeend" value='<ww:property value="customeragent.worktimeend==null?'18:00':customeragent.worktimeend"/>' onfocus="WdatePicker({skin:'whyGreen',dateFmt:'HH:mm'})" />
					   </ww:if>
					   <ww:else>
						<input type="text"
							name="agentshortname" id="shortname" onblur='valAgengtshortname()'
							value='<ww:property value="customeragent.agentshortname"/>'
							style="width: 150px" /><font style="color: red">*</font>
						<font id='vshortname' style="color: red"></font>
					   </ww:else>
					   </td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>绑定IP：</span></div>
						</td>
						<td class="table_color_l"><input type="text" name="website" id="website" onblur="valweb(this.value)"
							class='two' value='<ww:property value="customeragent.website"/>'
							style="width: 150px" />
							<font id="vwebsite" style="color: red"></font>
							</td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>单位电话：</span></div>
						</td>
						<td class="table_color_l"><input type="text" name="agenttel"
							class='two' id="agenttel"
							value='<ww:property value="customeragent.agenttel"/>'
							style="width: 150px" /> <span id="agenttel2"></span></td>
					</tr>

					<tr>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>通信地址：</span></div>
						</td>
						<td class="table_color_l"><input type="text" class='two'
							name="agentaddress" id="agentaddress"
							value='<ww:property value="customeragent.agentaddress"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>邮政编码：</span></div>
						</td>
						<td class="table_color_l"><input type="text" class='two'
							name="agentpostcode" id="agentpostcode"
							value='<ww:property value="customeragent.agentpostcode"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td colspan="4" style="padding-left: 20px;">
						<div><img src="images/fenge.gif" align="absmiddle">联系人信息</div>
						</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>业务联系人：</span></div>
						</td>
						<td class="table_color_l"><input type="text" onblur="valLinkname();"
							name="agentcontactname" id="contactname" desc="业务联系人"
							class="validate[required]"
							value='<ww:property value="customeragent.agentcontactname"/>'
							style="width: 150px" /><font style="color: red">*</font>
							<font id="vcontactname" style="color: red"></font>
							</td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>业务联系电话：</span></div>
						</td>
						<td class="table_color_l"><input type="text" onblur="valLinkmobile()"
							name="agentphone" id="agentphone" desc="业务联系人工作电话"
							class="validate[required,custom[onlyNumber]]"
							value='<ww:property value="customeragent.agentphone"/>'
							style="width: 150px" /><font style="color: red">*</font>
							<font id="vagentphone" style="color: red"></font>
							</td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>业务联系邮箱：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="agentemail" id="agentemail"
							value='<ww:property value="customeragent.agentemail"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>业务联系传真：</span></div>
						</td>
						<td class="table_color_l"><input type="text" name="agenrfax"
							id="agenrfax"
							value='<ww:property value="customeragent.agenrfax"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>联系移动电话：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="agentmobile" id="agentmobile"
							value='<ww:property value="customeragent.agentmobile"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>MSN或QQ：</span></div>
						</td>
						<td class="table_color_l"><input type="text" name="msnqq"
							value='<ww:property value="customeragent.msnqq"/>'
							style="width: 150px" /></td>

					</tr>
					<ww:if test="customeragent.agenttype==2">
					<tr>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>出票人电话：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="outticketmantel" id="agentmobile"
							value='<ww:property value="customeragent.outticketmantel"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>出票MSN或QQ：</span></div>
						</td>
						<td class="table_color_l"><input type="text" name="outticketmanmsnqq"
							value='<ww:property value="customeragent.outticketmanmsnqq"/>'
							style="width: 150px" /></td>

					</tr>
					<tr>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>退票人电话：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="backticketmantel" id="agentmobile"
							value='<ww:property value="customeragent.backticketmantel"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>退票MSN或QQ：</span></div>
						</td>
						<td class="table_color_l"><input type="text" name="backticketmanmsnqq"
							value='<ww:property value="customeragent.backticketmanmsnqq"/>'
							style="width: 150px" /></td>

					</tr>
					</ww:if>
					<tr  class="ngy">
						<td colspan="4" style="padding-left: 20px;">
						<div><img src="images/fenge.gif" align="absmiddle">财务人员信息</div>
						</td>
					</tr>
					<tr class="ngy">
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>财务联系人：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="financename" id="financename"
							value='<ww:property value="customeragent.financename"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>财务工作电话：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="financephone" id="financephone"
							value='<ww:property value="customeragent.financephone"/>'
							style="width: 150px" /></td>
					</tr>
					<tr  class="ngy">
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>财务传真号码：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="financefax" id="financefax"
							value='<ww:property value="customeragent.financefax"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>财务移动电话：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="financemobile" id="financemobile"
							value='<ww:property value="customeragent.financemobile"/>'
							style="width: 150px" /></td>
					</tr>
					<tr  class="ngy">
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>财务电子邮件：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="financeemail" id="financeemail"
							value='<ww:property value="customeragent.financeemail"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>QQ或MSN：</span></div>
						</td>
						<td class="table_color_l"><input type="text"
							name="financeother" id="financeother"
							value='<ww:property value="customeragent.financeother"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td colspan="4" style="padding-left: 20px;">
						<div><img src="images/fenge.gif" align="absmiddle">账号信息</div>
						</td>
					</tr>
					<!-- 
					<tr style="display:none">
						<td height="28" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>分润类型：</span></div>
						</td>
						<td class="table_color_l"><select name="runtype" id="se"
							onchange="check();">
							<option value="3"
								<ww:if test="customeragent.runtype==3">selected</ww:if>>不分润</option>
							<option value="1"
								<ww:if test="customeragent.runtype==1">selected</ww:if>>按千分比</option>
							<option value="2"
								<ww:if test="customeragent.runtype==2">selected</ww:if>>按票数</option>

						</select></td>
						<td height="28" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>分润值：</span></div>
						</td>
						<td class="table_color_l"><input type="text" name="runvalue"
							id="runvalue" desc="分润值"
							value='<ww:property value="customeragent.runvalue"/>'
							style="width: 150px" /> <span id="sp"></span></td>
					</tr>-->
					<tr>
						<td height="28" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>支付宝账号：</span></div>
						</td>
						<!-- onblur="valalipay()" -->
						<td class="table_color_l"><input type="text" class="two" id="alipayaccount" 
							name="alipayaccount"
							value='<ww:property value="customeragent.alipayaccount"/>'
							style="width: 150px" /><font style="color: red"></font><font id="valipayaccount" style="color: red"></font></td>
						<td height="28" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>财付通账号：</span></div>
						</td>
						<td class="table_color_l"><input type="text" 
							name="tenpayaccount" class="two"
							value='<ww:property value="customeragent.tenpayaccount"/>'
							style="width: 150px" /></td>
					</tr>
					<tr>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span>快钱账号：</span></div>
						</td>
						<td class="table_color_l"><input type="text" 
							name="kuaibillaccount" class="two"
							value='<ww:property value="customeragent.kuaibillaccount"/>'
							style="width: 150px" /></td>
						<td height="28" style="text-align: right;">
						<div class="td_color"><span style="display: none">虚拟账户余额：</span></div>
						</td>
						<td class="table_color_l" style="color: red;"><span
							style="display: none"><ww:property
							value="converNull(customeragent.vmoney,0)" />元</span></td>

					</tr>
					<tr>
						<td colspan="4" style="padding-left: 20px;">
						<div><img src="images/fenge.gif" align="absmiddle">业务信息</div>
						</td>
					</tr>
					<ww:if test="customeragent.id==0||(customeragent.id>0&&customeragent.id!=getLoginsessionagent().id)">
					<tr>
						<td height="28" style="text-align: right;"
							class="table_color colortrin">
						<div class="td_color"><span>业务类型：</span></div>
						</td>
						<td class="table_color_l" colspan="3">
						<ww:iterator value="getLoginsessionagent().bussinesslist" id="login">
						<ww:set name="lbid" value="id"/>
						<input  type="checkbox"
						<ww:iterator value="customeragent.bussinesslist" id='agent'>
						 <ww:if test="#lbid==id"> checked="checked"</ww:if>
						 </ww:iterator>
							name="businesstype" value='<ww:property value="id"/>'/> 
							<ww:property value="name"/>&nbsp;&nbsp;
						</ww:iterator>
						<font id="vbusinesstype" style="color: red"></font>
						</td>
					</tr>
					</ww:if>
					<tr class="font-blue-xi" id="tr_button">
						<td height="54" colspan="4" align="center">
						<ww:if test="customeragent.id>0&&customeragent.agentcheckstatus==0">
						<input
							type="button" onclick='checkAgent(<ww:property value="customeragent.id"/>);' id="submitreg" class="button_d font-bai" value="审核通过" />
						</ww:if>
						<ww:else>
						<input
							type="button" onclick="addAgent();" id="submitreg" class="button_d font-bai" value="提交" />
						</ww:else>
						&nbsp;&nbsp;&nbsp; <input type="button" class="button_d font-bai"
							onclick="window.history.go(-1);" name="Submit2" value=" 返回 " />
							</td>

					</tr>

				</table>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</div>
</body>
<script type="text/javascript">

//var data =	new Array(); 


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
    if(len>=5&&len<=16){
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

function changeProxy(v){
 if(v=="不限"){
   $("#proxyid").val("不限");
   $("#proxyid").attr("readonly","readonly");
   return;
   
 }else if(v==0){
   $("#proxyid").val(0);
   $("#proxyid").attr("readonly","readonly");
   return;
   
 }else{
 $("#proxyid").removeAttr("readonly");
 }
 if(v>0){
   $("#proxyid").val(v);
   
 }
}
<ww:if test="customeragent.id==0">
<ww:if test="#request.allowlevel==null">
  $(document).ready(function(){
    $("#levelid").val("不限");
  changeProxy("不限");
  });
</ww:if>
<ww:else>
$(document).ready(function(){
    $("#levelid").val("0");
    $("#proxyid").val("0");
  });
</ww:else>
</ww:if>
<ww:else>
 var level=<ww:property value="customeragent.allowlevelcount"/>;
 var proxy=<ww:property value="customeragent.allowproxycount"/>;
 if(level==-1){level='不限';proxy="不限"}
  $("#levelid").val(level);
    $("#proxyid").val(proxy);
</ww:else>

function checkType(id){
if(id=='3'){
$("#angettype1").show();
$("#angettype2").show();
}else{
$("#angettype1").hide();
$("#angettype2").hide();
$("#agentvalue").val("");

}
}
<ww:if test="customeragent.bigtype==2">

checkType(3);
</ww:if>

</script>

</html>


