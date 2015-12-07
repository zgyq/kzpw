<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.DateFormat;"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="Stylesheet" href="Common.css" />
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>


<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jquery.suggest.css">
 <script type="text/javascript" src="<%=request.getContextPath() %>/js/nation-js/j.dimensions.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath() %>/js/nation-js/aircity.js"></script>
 <script type="text/javascript" src="<%=request.getContextPath() %>/js/nation-js/j.suggest.js"></script>
  <script type="text/javascript">
 $(function(){
 $("#arrcity").suggest(citys,{hot_list:commoncitys,dataContainer:'#arrcity_3word',onSelect:function(){$("#city2").click();}, attachObject:'#suggest'});
$("#city2").suggest(citys,{hot_list:commoncitys,attachObject:"#suggest2"});
});
</script>







<script>
Ext.onReady(function(){ 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,         
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:170,
	   tpl: "<tpl for='.'><div style='height:240px ; width:170px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  
	<ww:property value="deptstr"/>	
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue("<ww:property value="companyname"/>");
       tree.on('click',function(node){   
           
             comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            comboxWithTree.collapse();              
       });     	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().collapseChildNodes();//是否展开子菜单			
		});
	
    comboxWithTree.render('comboxWithTree'); 
});
</script>

</head>

<script type="text/javascript">
var array1=new Array();
<%
Map<Integer,String> ccmp=(Map<Integer,String>)request.getAttribute("ccmap");
if(ccmp!=null&&ccmp.size()>0){
	Iterator iterator=ccmp.keySet().iterator();
	while(iterator.hasNext()){
		int key=(Integer)iterator.next();
		String value=ccmp.get(key);
		%>		
		array1[<%=key%>]='<%=value%>';
		<%		
	}	
}

%>
function cardChange(){
var cardtype=$("#cardtype").val();
var cardnono=array1[cardtype];
if(typeof(cardnono)=='undefined'){
$("#cardno").val("");
}else{
$("#cardno").val(cardnono);
}
}
</script>
<script type="text/javascript">

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

function form_validate() {

		var validate = true ;
		
	
		
	loginname = document.getElementById('loginname');
		if(loginname.value=="") {
			document.getElementById("loginname2").innerHTML="*登录名不能为空";
			loginname.focus();
			validate = false ;
		} else {
			document.getElementById("loginname2").innerHTML="*";
		}
	logpassword = document.getElementById('logpassword');
		if(logpassword.value=="") {
			document.getElementById("logpassword2").innerHTML="*登录密码不能为空";
			logpassword.focus();
		
			validate = false ;
		} else {
			document.getElementById("logpassword2").innerHTML="*";
		}
	membername = document.getElementById('membername');
		if(membername.value=="") {
			document.getElementById("membername2").innerHTML="*姓名不能为空";
			membername.focus();
			validate = false ;
		} else {
			document.getElementById("membername2").innerHTML="*";
		}
		
		
		
	memberemail = document.getElementById('memberemail');
		if(memberemail.value=="") {
			document.getElementById("memberemail2").innerHTML="*电子邮箱不能为空";
			memberemail.focus();
			validate = false ;
		} else {
			document.getElementById("memberemail2").innerHTML="*";
		}
		
		
		
		membermobile = document.getElementById('membermobile');
		if(membermobile.value=="") {
			document.getElementById("membermobile2").innerHTML="*移动电话不能为空";
			membermobile.focus();
			validate = false ;
		} else {
			document.getElementById("membermobile2").innerHTML="*";
		}	
		
		
		mobile = document.getElementById('mobile');
		if(mobile.value=="") {
			document.getElementById("mobile2").innerHTML="*手机不能为空";
			mobile.focus();
			validate = false ;
		} else {
			document.getElementById("mobile2").innerHTML="*";
		}				
		return validate;
}

function changeNation(){
 var cnation=$("#arrcity").val();
 if(cnation!=""&&cnation!="中文/拼音"&&cnation!="中国"){

 $("nation").show();
 }else{

 $("nation").hide();
 }
}
</script>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;<ww:if test="customeruser.id>0">修改</ww:if><ww:else>添加</ww:else>大客户员工</b></td>
  </tr>
  <tr>
    <td  valign="top">
  <form name="form1" id="form1" method="post" action="customeruser!<ww:if test="customeruser.id>0">editbiguser.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>addbiguser.action?<ww:property value="url"/></ww:else>" >
  	<input type="hidden" value="<ww:property value="forward" />" name="forward"/>
   <table width="99%" border="0" cellpadding="0" cellspacing="0"  style=" border-collapse:collapse; margin: 0 auto;">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr height="20">
						<td height="28" width="10%" align="right"></td>
						<td height="28" align="right"></td>
						<td height="28" width="10%" align="right"></td>
						<td height="28" align="right">
						
						<input type="hidden" name="customeragentid" value="<ww:property value="customeragentid"/>"/>
						<input type="hidden" name="customerdeptid" value="<ww:property value="customerdeptid"/>"/>

						
						</td>

					</tr>

					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>所属大客户：</span></td>
						<td class="table_color_l" >
						 <span style="HEIGHT: 71px"> 
						 <table border="0" cellspacing="0" cellpadding="0">
						 <tr>
						 <td><div id='comboxWithTree' style=""></div>
						</td>
						<td> 
						<input type="text"  style="width:0px;border: 0px" id="parentid"  desc="所属大客户"<ww:if test="customeruser.id==null||customeruser.id==0">class="validate[required]"</ww:if>  name="cusagentname" value='<ww:property value="cusagentname"/>' />
						</td>
						<td><span class="font-red">*</span></td>						
						</tr></table>						
					    </span>
							</td>
						<td height="28" align="right" class="table_color colortrin"><span>手机号：</span></td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="text" name="mobile" id="membermobile"
							value='<ww:property value="customeruser.mobile"/>'  
							style="width: 150px"  />
						</ww:if>
						<ww:else>
						<input type="text" name="mobile" id="membermobile"
							value='<ww:property value="customeruser.mobile"/>' 
							style="width: 150px"  />
						</ww:else>
						<!--<input type="text" name="mobile" id="membermobile"
							value='<ww:property value="customeruser.mobile"/>' desc="手机号码" class="validate[required,custom[mobile],ajax[ajaxuserMobile]]"
							style="width: 150px"  />
							-->
							<!-- <span id="mobile2" class="font-red">*</span>--></td>
					</tr>



					<tr>


						<td height="28" align="right" class="table_color colortrin"><span>登录名：</span></td>
						<td class="table_color_l">
						<ww:if test="customeruser.id>0">
						<input type="text" name="loginname" id="loginname"  mId="<ww:property value="customeruser.loginname"/>" desc="登录名" class="validate[length[6,15],ajax[ajaxUsername]]"
							value='<ww:property value="customeruser.loginname"/>' 
							style="width: 150px" />
						</ww:if><ww:else>
						<input type="text" name="loginname" id="loginname" desc="登录名" class="validate[length[6,15],ajax[ajaxUsername]]"
							value='<ww:property value="customeruser.loginname"/>' 
							style="width: 150px" />
						</ww:else>
						<!--
						<input type="text" name="loginname" id="loginname" desc="登录名" class="validate[length[6,15],ajax[ajaxUsername]]"
							value='<ww:property value="customeruser.loginname"/>' 
							style="width: 150px" />
							-->
							<span id="loginname2" class="font-red">*</span></td>
						<td height="28" align="right" class="table_color colortrin"><span>登陆密码：</span></td>
						<td class="table_color_l">
						<!--<input type="text"
							name="logpassword" id="logpassword" desc="密码" class="validate[length[6,15]"
							value='<ww:property value="customeruser.logpassword"/>'
							style="width: 150px" />
							-->
						<ww:if test="customeruser.id>0">
						<input type="password" require="true" dataType="Require" mId="<ww:property value="customeruser.logpassword"/>"
							msg="登陆密码不能为空" name="logpassword" id="logpassword" desc="密码"  
							value="" style="width: 150px" />
						</ww:if><ww:else>
						<input type="password" name="logpassword" id="logpassword" desc="密码" class="validate[length[6,15]]"
							value='<ww:property value="customeruser.logpassword"/>'
							" style="width: 150px" />
						</ww:else>
						
						
						
						
							
							<span id="logpassword2" class="font-red">*</span></td>
					</tr>



					<tr>


						<td height="28" align="right" class="table_color colortrin"><span>姓名：</span></td>
						<td class="table_color_l"><input type="text"
							name="membername" id="membername" desc="姓名" class="validate[required]" 
							value='<ww:property value="customeruser.membername"/>'
							style="width: 150px" /><span id="membername2" class="font-red"></span></td>
						<td height="28" align="right" class="table_color colortrin"><span>性别：</span></td>
						<td class="table_color_l">
						<select name="membersex">
							<option value="男" <ww:if test='customeruser.membersex.trim().equals("男")'>selected="selected"</ww:if>>男</option>
							<option value="女"  <ww:if test='customeruser.membersex.trim().equals("女")'>selected="selected"</ww:if>>女</option>
						</select><!--
	 <input type="text" require="true" dataType="Require"   msg="性别不能为空" name="membersex" value='<ww:property value="customeruser.membersex"/>'" style="width:150px" />
	 --></td>
					</tr>



					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>电子邮箱：</span></td>
						<td class="table_color_l">
						<!--
						<input type="text" name="memberemail" id="memberemail" 
							value='<ww:property value="customeruser.memberemail"/>' desc="电子邮箱" class="validate[required,custom[email],ajax[ajaxEmail]]"
							style="width: 150px" />
							-->
						<ww:if test="customeruser.id>0">
						<input type="text" name="memberemail" id="memberemail"   mId="<ww:property value="customeruser.memberemail"/>"
							value='<ww:property value="customeruser.memberemail"/>'  
							style="width: 150px" />
						</ww:if><ww:else>
						<input type="text" name="memberemail" id="memberemail" 
							value='<ww:property value="customeruser.memberemail"/>' 
							style="width: 150px" />
						</ww:else>	
							<!-- <span id="memberemail2" class="font-red">*</span>--></td>
						<td height="28" align="right" class="table_color colortrin"><span>是否启用：</span></td>
						<td class="table_color_l"><select name="isenable">
							<option value="1"
								<ww:if test="customeruser.isenable==1">selected</ww:if>>启用</option>
							<option value="2"
								<ww:if test="customeruser.isenable==0">selected</ww:if>>禁用</option>
						</select>
					</tr>
					
					
					<tr>					
				     <td class="table_color colortrin">国籍：</td>
				     <td class="table_color_l" style="height: 30px">
				     <div id="box" onclick="changeNation()">
                       <input type="hidden" onchange="changeNation()" id="arrcity_3word" value="<ww:property value="customeruser.nationality"/>" />
                       <input type="text" onchange="changeNation()"  name="nationality" id="arrcity" value="<ww:property value="customeruser.nationality"/>" />
                       <div id='suggest' class="ac_results"></div>
				     </td>    
				     
				     <td class="table_color colortrin" ><font style=" display: none" class="nation">在华地址：</font></td>
				     <td class="table_color_l nation" style=" display: none"><input name="chinaaddress" value="<ww:property value="customeruser.chinaaddress"/>"/></td>
				   
				    </tr>
				    <!--  -->
				    <tr style=" display: none" class="nation">
					  <td class="table_color colortrin">用户卡号：</td>
					  <td class="table_color_l"><input name="cardnumber" value="<ww:property value="customeruser.cardnumber"/>" /></td>
					  <td class="table_color colortrin">生日：</td>
					  <td class="table_color_l"><input type="text" name="birthday"
							value='<ww:property value="formatDate(customeruser.birthday)"/>'
							style="width: 150px"  onfocus="WdatePicker({skin:'whyGreen',maxDate:'<%=DateFormat.getDateInstance().format(new Date()) %>'})" class="Wdate"/></td>
				    </tr>
				   
					<tr style=" display: none" class="nation">
					 <td class="table_color colortrin">英文名：</td>
					 <td class="table_color_l"><input name="enname" value='<ww:property value="customeruser.enname"/>'></input></td>
					 <td class="table_color colortrin">入境时间：</td>
					  <td class="table_color_l"><input type="text" name="entrytime"
							value='<ww:property value="formatDate(customeruser.entrytime)"/>'
							style="width: 150px"  onfocus="WdatePicker({skin:'whyGreen',maxDate:'<%=DateFormat.getDateInstance().format(new Date()) %>'})" class="Wdate"/></td>
					 </tr>
					
					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>证件类型：</span></td>
						<td class="table_color_l">
							<input type="hidden" name="strCusID" value="<ww:property value="customeruser.id"/>"/>
						<select id="cardtype" name="cardType" <ww:if test="#request.edit!=null">onchange="cardChange()"</ww:if> >
							<option  value="1"
								<ww:if test="customercredit.credittypeid==1">selected</ww:if>>身份证</option>
							<option value="2"
								<ww:if test="customercredit.credittypeid==2">selected</ww:if>>驾驶证</option>
							<option value="3"
								<ww:if test="customercredit.credittypeid==3">selected</ww:if>>护照</option>
							<option value="4"
								<ww:if test="customercredit.credittypeid==4">selected</ww:if>>港澳通行证</option>
							<option value="5"
								<ww:if test="customercredit.credittypeid==4">selected</ww:if>>台湾通行证</option>
							<option value="6"
								<ww:if test="customercredit.credittypeid==4">selected</ww:if>>台胞证</option>
							<option value="7"
								<ww:if test="customercredit.credittypeid==4">selected</ww:if>>回乡证</option>
							<option value="8"
								<ww:if test="customercredit.credittypeid==4">selected</ww:if>>其他</option>
						</select></td>

						<td height="28" align="right" class="table_color colortrin"><span>证件号码：</span></td>
						<td class="table_color_l">
						<input id="cardno" type="text" desc="证件号码" class="validate[required]" name="s_cardnunber" id="creditnumber"
							value='<ww:property value="customercredit.creditnumber"/>'
							" style="width: 150px" /><span id="creditnumber2" class="font-red">*</span></td>
					</tr>
					<!--<tr>
					 <td class="table_color colortrin">居留证件种类：</td><td class="table_color_l"><input /></td>
					 <td class="table_color colortrin">居留证件号码：</td><td class="table_color_l"><input /></td>
					</tr>
					--><tr style=" display: none" class="nation">
					  <td class="table_color colortrin">证件有效期：</td>
					  <td class="table_color_l"><input type="text" name="customercredit.passportvalidity"
							value='<ww:property value="formatDate(customercredit.passportvalidity)"/>'
							style="width: 150px"  onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate"/></td>
					  
					  <td class="table_color colortrin">签发机关：</td>
					  <td class="table_color_l"><input name="customercredit.issuingauthority" value='<ww:property value="customercredit.issuingauthority"/>'></input></td>
					</tr>
					<tr style=" display: none" class="nation">
					 <td class="table_color colortrin">就业证号码：</td>
					 <td class="table_color_l"><input name="worknumber" value='<ww:property value="customeruser.worknumber"/>'/></td>
					 <td class="table_color colortrin">就业证有效期：</td>
					  <td class="table_color_l"><input type="text" name="workperiod"
							value='<ww:property value="formatDate(customeruser.workperiod)"/>'
							style="width: 150px"  onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate"/></td>
					 
					 
					</tr>
					<!-- 
					
					 用户卡号、生日、所在城市、传真、备忘录、是否领导、客户英文名、入境时间、国籍、入境时间、居留证件种类、
					 居留证件号码、居留证件有效期、签发机关、就业证号码、就业证有效期、在华地址
					-->
					<tr style=" display: none" class="nation">
					   <td class="table_color colortrin">所在城市：</td> 
					    <td class="table_color_l"><input name="localcity"  value='<ww:property value="customeruser.localcity"/>' /></td>
					   <td class="table_color colortrin">传真：</td> 
					    <td class="table_color_l"><input name="memberfax" value='<ww:property value="customeruser.memberfax"/>'/></td>
					</tr>
					
					
					
					
										
					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>工作电话：</span></td>
						<td class="table_color_l">
						<input type="text" name="workphone" id="workphone" 
							value='<ww:property value="customeruser.workphone"/>' style="width: 150px" /></td>
						<td height="28" align="right" class="table_color colortrin"><span>其他联系方式：</span></td>
						<td class="table_color_l">
						<input type="text" name="linkother" id="linkother" 
							value='<ww:property value="customeruser.linkother"/>' style="width: 150px" />
					</tr>

					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>是否是管理员：</span></td>
						<td class="table_color_l"><select name="isadmin">
						<option value="2"
								<ww:if test="customeruser.isadmin==2">selected</ww:if>>否</option>
							<option value="1"
								<ww:if test="customeruser.isadmin==1">selected</ww:if>>是</option>
							
						</select>
						</td>
						<td height="28" align="right" class="table_color colortrin"><span>备注：</span></td>
						<td class="table_color_l">
						<input type="text" name="description" id="description" 
							value='<ww:property value="customeruser.description"/>' style="width: 150px" />
						



				</tr>



				


				
		<tr class="font-blue-xi">
						<td height="46" colspan="4" align="center"><input type="submit" id="submitreg"
							class="button_d font-bai" value="提交" /> <input type="button"
							class="button_d font-bai"
							onclick="history.back()"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

   <table>
	<tr>
		<td><strong><span class="font-red">注意事项:</span></strong></td>
	</tr>
	<tr>
		<td>
		<ul style="padding-left: 30px;">
			<li>联系电话可为办公电话 也可为移动电话</li>
			<li>启用/禁用选择:</li>
			<li style="list-style: none; padding-left: 30px;">启用 该帐户可以登录系统</li>
			<li style="list-style: none; padding-left: 30px;">禁用 该帐户不可以登录系统</li>
			<li><span class="font-red-xi">授权选择:可进入权限选择页面</span></li>
		</ul>
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
