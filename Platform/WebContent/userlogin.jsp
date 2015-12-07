<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@page import="com.opensymphony.xwork.ActionContext"%>
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全-V2.0</title>
<style type="text/css">
.twshow{
border-left:0px;
border-right:0px ;
border-top:0px;
border-bottom:1px solid  #cccccc;
}
.twhide{
border:0px;
}
.passtable{
border-collapse:collapse;
border:none;
}
.passtd{
border:solid #99CCFF 1px;
}
</style>

<link href="<%=request.getContextPath() %>/style/base.css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/text.css" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/Layout.css"rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/font1.css"rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/yunwei.css"rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/style/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine-cn.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/js/jquery.validationEngine.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/style/mapcss.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="<%=request.getContextPath() %>/js/dialog.js" type="text/javascript"></script>
<link href="<%=request.getContextPath() %>/style/dialog.css" rel="stylesheet" type="text/css" />
<script charset="UTF-8" src="<%=request.getContextPath() %>/js/PublicJs.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>

<script type="text/javascript">
 function updateCard(id){
  if($("#card"+id).attr("readonly")==false){
       $("#divCard").dialog(
        {title:'修改证件号',
                show: null,
                bgiframe: false,
                autoOpen: false,
                draggable: true,                
                resizable: true,
                modal: true,
                width: 350,
                height: 210      
       });
       $("#divCard").dialog("open");
       var thiscartype=$("#cardType"+id).val();
       var carvalue=$("#card"+id).val();
     
       var strHtml='<table class="passtable" width="100%" cellpadding="0" cellspacing="0">';
           strHtml+='<tr><td colspan="2" height="20px">&nbsp;</td></tr>';
           strHtml+='<tr><td class="passtd" width="125px" align="right" style="padding-right:10px">证件类型：</td>';
           strHtml+='<td class="passtd" align="left">&nbsp;'
           strHtml+='<select style="width:120px" id="cardType">';
           strHtml+='<option value="1"';if(thiscartype==1)strHtml+='selected';strHtml+='>身份证</option>';
           strHtml+='<option value="2"';if(thiscartype==2)strHtml+='selected';strHtml+='>驾驶证</option>';
           strHtml+='<option value="3"';if(thiscartype==3)strHtml+='selected';strHtml+='>护照</option>';
           strHtml+='<option value="4"';if(thiscartype==4)strHtml+='selected';strHtml+='>港澳通行证</option>';
           strHtml+='<option value="5"';if(thiscartype==5)strHtml+='selected';strHtml+='>台湾通行证</option>';
           strHtml+='<option value="6"';if(thiscartype==6)strHtml+='selected';strHtml+='>台胞证</option>';
           strHtml+='<option value="7"';if(thiscartype==7)strHtml+='selected';strHtml+='>回乡证</option>';
           strHtml+='<option value="8"';if(thiscartype==8)strHtml+='selected';strHtml+='>其他</option>';
           strHtml+='</select></td></tr>';
           strHtml+='<tr><td class="passtd" width="120px" align="right" style="padding-right:10px">证件号：</td>';
           strHtml+='<td class="passtd" align="left">&nbsp;<input id="cardno" name="" value="'+carvalue+'" ></input></td></tr>';
           strHtml+='<tr><td colspan=2 class="passtd" height="40px"><input class="button108" type="button" onclick="javascript:vCard('+id+')" value="  提   交  ">&nbsp;&nbsp';
           strHtml+='<input onclick="cardClose()" class="button108" type="button" value=" 取 消 "></td></tr>';
        $("#divCard").html(strHtml);
     }
   }
   function vCard(id){
   var carno=$("#cardno").val();
   var cardType=$("#cardType").val();
   if(carno==""){
   alert("证件号不能为空");
   return false;
   }
     if(cardType==1&&carno!=""){
       if(shenfen(carno)){
       $("#card"+id).val(carno);
       $("#divCard").dialog("close");
       }else{
       return false;
       }
     }
     $("#card"+id).val(carno);
     $("#cardType"+id).val(cardType);
     $("#divCard").dialog("close");    
   }
function cardClose(){
$("#divCard").dialog("close");
}
</script>
<script>
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
function colsedispose(){
 Ext.MessageBox.hide();
}
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
	<ww:property value="#request.agentroot"/>
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue("<ww:property value="companyname"/>");
       tree.on('click',function(node){   
           
             comboxWithTree.setValue(node.text); 
             Ext.get('companyname').set({value:node.text});
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

<script>
$(document).ready(function() {
$("#form2").validationEngine({
	success : function() {
	//表单提交时把按钮disable
	document.getElementById("submitreg").disabled = true;
	document.form2.submit();
	}}
 ) 
});
</script>
<script type="text/javascript">
    var cname;
    var cmobile;
    var cardno;
    var upid=0;
 function updateMember(num,mid){
 $("#updateForm"+mid).validationEngine({
	 success:function() {
	 $("#mebmobile"+mid).blur();
	 $("#updateForm"+mid).removeAttr("onsubmit");
	 $("#updateForm"+mid).attr("onsubmit","javascript:return true;");
	 $("#updateForm"+mid).submit();
	  }
   })
   if(upid!=0&&upid!=mid){
    var up=$(".tw"+upid);
    up.removeClass("twshow");
     up.addClass("twhide");
     up.attr("readonly","readonly");
     $("#mebname"+upid).val(cname);
     $("#mebmobile"+upid).val(cmobile);
     $("#card"+upid).val(cardno);
     var uphtml='<a style="color:#06F;" href="" onclick="updateMember(1,'+upid+');return false" class="lan_xia">修改信息</a>';
     $("#operate"+upid).html(uphtml);
   }
    var membername=$("#mebname"+mid);
    var membermobile=$("#mebmobile"+mid);
    var membercard=$("#card"+mid);
    if(num==1){
      
      cname=membername.val();
      cmobile=membermobile.val();
      cardno=membercard.val();
    }
    var handle=$("#operate"+mid);
    var tw=$(".tw"+mid);
    var oldhtml='<a style="color:#06F;" href="" onclick="updateMember(1,'+mid+');return false" class="lan_xia">修改信息</a>';
    var savehtml='<a style="color:#06F;" href="" onclick="updateMember(2,'+mid+');return false" class="lan_xia">保存</a>&nbsp;';
    var cancelhtml='<a style="color:#06F;" href="" onclick="updateMember(3,'+mid+');return false" class="lan_xia">取消</a>';
   if(num==1){
   handle.html(savehtml+" "+cancelhtml); 
   tw.removeClass("twhide");
   tw.addClass("twshow");
   tw.removeAttr("readonly");
   }else if(num==3){
     handle.html(oldhtml);
     membername.val(cname);
     membermobile.val(cmobile);
     membercard.val(cardno);
     tw.removeClass("twshow");
     tw.addClass("twhide");
     tw.attr("readonly","readonly");
   }else{
   var reg=/^1[3,5,6,7,8,9,4]{1}[0-9]{1}[0-9]{8}$/
   var lodstmobile=$("#mebmobile"+mid).val();
   if(reg.test(lodstmobile)){
   var valid="mebmobile"+mid
    jQuery.post("vaidate!validatemobileById.action",{validateValue:lodstmobile,validateId:valid,validateError:"ajaxMobileById"},function(data){
   var t=data.indexOf("true");
   var mname=membername.val();
   if(t>0&&mname!=""){
	 $("#updateForm"+mid).submit();
   }
   }); }  
   }
   upid=mid;
  } 
 function sub(){
var reg=/^1[3,5,6,7,8,9,4]{1}[0-9]{1}[0-9]{8}$/
 var cname=$("#namejj").val();
 document.getElementById("namejj").focus();
 document.getElementById("namejj").blur();
 document.getElementById("mobile1").focus();
 document.getElementById("mobile1").blur();
 var v=$("#mobile1").val();
   if(reg.test(v)){
 jQuery.post("vaidate!validatemobile.action",{validateValue:v},function(data){
   var t=data.indexOf("true");
   if(t>0&&cname.length>0){
   dispose("正在注册会员信息");
   document.form2.submit();
   }
 });}
 } 
</script>
</head>
<body style="height:100%; margin: 0; padding: 0;"> 

<div class="box" style="position:absolute;float:left; width: 99%;">
<table width="100%" cellpadding="0" cellspacing="0"
	align="center" >
	<tr>
		<td width="100%" colspan="2" height="29" class="box-bottom " style="background:url(images/top-bg.png) 0px -120px;"><b
			class="anse">&nbsp;&nbsp;会员查询</b></td>
	</tr>	
	<tr><td colspan="2" style="height: 5px; line-height: 5px;">&nbsp;</td></tr>
	<tr>
	<td width="40%">
	<table border="0" class="box" cellpadding="0" cellspacing="0" width="98%" style="line-height: 22px; margin: 0 auto">
	<tr>
	<td bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>添加此客户为会员</b></div></td></tr>
	<tr>
	 <td>	 
	<form name="form2" id="form2" method="post" action="login!createuserbyorder.action">
	<input type="hidden" name="ywtype" value='<ww:property value="ywtype"/>' />
	<input type="hidden" name="rechtype" value='<ww:property value="rechtype"/>' /><!-- 充值类型 -->
	
    <table width="100%" border="0" cellpadding="0" cellspacing="0"  style="border-collapse:collapse; margin: 0 auto;height:105px" bordercolor="#a0cfee">
    <tr>
    <td style="padding: 0" width="100" height="35" valign="middle"  align="right">姓名：</td>
    <td style="padding: 0">
    <input type="text" id="namejj" desc="姓名" style="width:120px;" class="validate[required]" name="customeruser.membername"/></td>
    </tr>
    <tr>
    <td style="padding: 0" align="right">手机号码：</td>
    <ww:if test="getorderusermobile()!=null &&!getorderusermobile().equals('')">

	<td style="padding: 0" height="35"><input style="width:120px;" type="text" id="mobile1" name="customeruser.mobile"  desc="手机号码" class="validate[required,ajax[ajaxMobile]]"/></td>

	</ww:if>
	<ww:else>
	<td style="padding: 0" height="35"><input style="width:120px;" type="text" id="mobile1" name="customeruser.mobile" desc="手机号码" class="validate[required,custom[mobile],ajax[ajaxMobile]]"/></td>
	</ww:else>    
    <td>
    <input type="hidden" name="customeruser.isweb" value="2" />
    <input id="submitreg" onclick="sub()"  type="button" name="button" id="button" class="button108"  value="注册" /></td>
    </tr>
    <tr>
    <td style="padding: 0;color:red" height="35" valign="middle"  align="center" colspan="3" >&nbsp;&nbsp;&nbsp;提示：如果此客户不是会员，请注册改客户为会员!</td>
    </tr>
    </table>
    </form>    
     </td>
     </tr>
     </table>
     </td>
     <td>
     <table border="0" class="box" cellpadding="0" cellspacing="0" width="98%" style="line-height: 22px; margin: 0 auto">
      <tr><td bgcolor="#d7e9fc" style="padding: 0"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>会员查询</b></div></td></tr>
	 <tr>
	 <td>
	 <form name="form1" method="post" action="login!getMemberByOrder.action?importtype=<ww:property value='importtype' />&s_orderstatuspnr=<ww:property value='s_orderstatuspnr' />">
	 <input type="hidden" name="ywtype" value='<ww:property value="ywtype"/>'/>
	 <input type="hidden" name="rechtype" value='<ww:property value="rechtype"/>' /><!-- 充值类型 -->
    <table width="100%" border="0" cellpadding="0" cellspacing="0"  style="border-collapse:collapse; margin: 0 auto; " bordercolor="#a0cfee">
	
	<tr>
    <td style="padding: 0" height="35" width="120" valign="middle"  align="right">会员类型：</td>
    <td colspan="4">
         <input type="radio" style="display:none" id="rdomembertype"  value="1" name="s_membertype">
          
          <input type="radio" style="display:none" id="rdomembertype" value="0"  name="s_membertype">
          
          <input type="radio" id="rdomembertype" value="3" checked="checked" name="s_membertype">全部会员
    </td>
    
    </tr>
	<tr>
    <td style="padding: 0" height="35" width="80" valign="middle"  align="right">姓名：</td>
    <td ><input style="width:120px;" type="text" name="customeruser.membername" value="<ww:property value="customeruser.membername"/>"/></td>
    <td style="padding: 0" align="right" width="120" >手机号码：</td>
    <td><input style="width:120px;" type="text" name="customeruser.mobile" value="<ww:property value="customeruser.mobile"/>" /></td>
    <td></td>
    </tr>
    <tr >
    <td style="padding: 0" height="35"  valign="middle"  align="right">所属加盟商</td>
    <td colspan="3"><div  id='comboxWithTree'></div>
    <input type='hidden' id="companyname" name="companyname" value='<ww:property value="companyname"/>' />
    <input type="hidden" id="parentid" name="agentidstr" value='<ww:property value="agentidstr"/>'/>
    </td>
    <td><input type="submit" name="button" id="button" class="button108" value="查询" /></td>
    </tr>
    
    </table>
    </form>    
    </td>
    </tr>
   </table>
  </td>  
 </tr>    
     <tr>
   <td colspan="2" style="padding-top: 10px;">
   <table width="99%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse; text-align:center; line-height:24px;">
    <tr bgcolor="#d7e9fc">

	<td  bgcolor="#d7e9fc" style="padding: 0" width="120px"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b >姓名</b></div></td>
	<td  bgcolor="#d7e9fc" style="padding: 0" width="120"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>登录名</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0" width="150"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>手机号</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0" width="200"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>证件号</b> </div></td>

    <td  bgcolor="#d7e9fc" style="padding: 0" width="120"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>备注</b> </div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0" width="150"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>所属代理商</b></div></td>
    <td  bgcolor="#d7e9fc" style="padding: 0" width="100px"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%; padding-left: 10px;" ><b>部门</b></div></td>

    <td  bgcolor="#d7e9fc" style="padding: 0" width="220px"><div style="border-top: 1px solid #fff; border-left: 1px solid #fff; width: 100%;  text-align: center;" ><b>操作</b></div></td>

	</tr> 
	<ww:iterator value="listCustomeruser"> 
     <form action="<%=request.getContextPath()%>/customeruser!ajaxedituser.action"  id="updateForm<ww:property value="id"/>" method="post">
	<tr>
	<td style="text-align: left; padding-left: 10px">
	<input type="hidden" style="width: 70px; text-align:" value="<ww:property value="getCustomercredit(id).credittypeid"/>" name="cardType" id="cardType<ww:property value="id"/>"/>	
	<input type="hidden" style="width: 70px;" name="s_membertype" value="<ww:property value="s_membertype"/>"/>
	<input type="hidden" style="width: 70px; text-align: center;" name="strCusID" value="<ww:property value="id"/>" />
	<input size="10px" style="width: 130px;" readonly="readonly" id="mebname<ww:property value="id"/>" desc="姓名" class="tw<ww:property value="id"/> twhide validate[required]" name="strCustName"   value="<ww:property value="membername"/>"/>
	</td>
	<td style=" text-align: left; padding-left: 10px"><ww:property value="loginname"/></td>
	<td><input style="width: 100%; text-align: center;" readonly="readonly" id="mebmobile<ww:property value="id"/>" desc="手机号"  class="tw<ww:property value="id"/> twhide validate[required,custom[mobile],ajax[ajaxMobileById]]" name="strMobile"  value="<ww:property value="mobile"/>"/></td>
	<td style="text-align: left; padding-left: 10px"><input  style="width: 100%;" onfocus="updateCard(<ww:property value="id"/>)" id="card<ww:property value="id"/>" readonly="readonly"  class="tw<ww:property value="id"/> twhide" name="s_cardnunber"   value="<ww:property value="getcardnumberstr(id)"/>"/></td>
	<td style="text-align: left; padding-left: 5px"><span title="<ww:property value="SubString(description,10)"/>" style="cursor: pointer;"><ww:if test="description==null">无</ww:if><ww:else><ww:property value="SubString(description,10)"/></ww:else></span></td>
	<td style="text-align: left; padding-left: 10px"><ww:if test="agentid==46">平台<input type="hidden" name="strIsWeb" value="1"></input></ww:if>
    <ww:else><input type="hidden" name="strIsWeb" value="1"><ww:property value="getorderusercompanybyid(agentid)"/></ww:else></td>
	<td style="text-align: left; padding-left: 10px"><ww:if test="agentid==46">无</ww:if><ww:else><ww:property value="getorderuserdepartmentbyid(deptid)"/></ww:else></td>
	<%
    String orderurl=(String)ActionContext.getContext().getSession().get("orderUrl");
    if(orderurl!=null&&orderurl.trim().length()>0)
    {
    	%>
    	<ww:if test="agentAble(agentid,id)">
    	
    	 <td style="text-align: center;">
    	 <a style="color:#06F;" href='login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=0'>立即预订</a>
    	 </td>
    	 </ww:if>
    	 <ww:else>
    	 <td style="text-align: center;"><font style=" color: #CCCCCC">立即预订</font></td>
    	 </ww:else>
    	<%
    }else
    {%>
    	 <td style="text-align: left;padding: 10px"> 
    	<ww:if test="agentAble(agentid,id)">   	 
    	 <span id="operate<ww:property value="id"/>">
    	  &nbsp;&nbsp;
    	  <a style="color:#06F;display:none;" <ww:if test="puserflag==1">disabled</ww:if> href="" onclick="updateMember(1,<ww:property value="id"/>);return false" class="lan_xia">修改信息</a>
    	  </span>&nbsp;&nbsp;&nbsp;
    	  <a class="lan_xia" <ww:if test="ywtype==3">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else> href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=3">国内酒店预订</a>
    	  <a class="lan_xia" <ww:if test="ywtype==4">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else> href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=4">国际酒店预订</a>  
    	 	     
    	  <a <ww:if test="ywtype==1">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else> href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=1" class="lan_xia">国内机票</a>&nbsp;&nbsp;
    	  
    	  <a <ww:if test="ywtype==2">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else> href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=2" class="lan_xia">国际机票</a>&nbsp;&nbsp;
    	   <a <ww:if test="importtype!=0&& ywtype==11">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else> style="color:#06F;" class="lan_xia" href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=pnr&s_orderstatuspnr=<ww:property value="s_orderstatuspnr"/>&importtype=<ww:property value="importtype"/>">PNR创建订单</a>&nbsp;
    	  <a class="lan_xia" <ww:if test="ywtype==8">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else>  href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=8">旅游预订</a>
    	  &nbsp;&nbsp;<a  <ww:if test="ywtype==7">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else>class="lan_xia" href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=7">租车预订</a>
    	  
    	  <a class="lan_xia" <ww:if test="ywtype==5">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else>  href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=5&rechtype=<ww:property value="rechtype"/>">充值业务</a>
    	  &nbsp;&nbsp;<a style="color:#06F;display:none;" class="lan_xia" href="login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=6">加油卡充值</a>
    	  <a class="lan_xia" <ww:if test="ywtype==6">style="color:#06F;"</ww:if><ww:else>style="display:none;"</ww:else>  href='login!setorderuserlogin.action?orderuserid=<ww:property value="id"/>&forword=6'>火车票预定</a>
    	 </ww:if>
    	 <ww:else>
    	    <!-- <font color="#cccccc">修改信息</font>-->
    		<font color="#cccccc">机票预订</font><br>
    		<font color="#cccccc">PNR导入</font>
    		<font color="#cccccc">酒店预订</font>
    	 </ww:else>
    	 </td>
    	<%}%>
	</tr>
</form>
</ww:iterator>
<tr>
    <% String strvalue=request.getParameter("importtype"); 
       System.out.println(strvalue);
    %>
	<td colspan="8" height="43" align="center"><ww:property value="getPagination('\"login!getMemberByOrder.action?importtype=1&pageinfo.pagenum=\"+pageno')" /></td>
</tr>
</table>     
     </td>
     </tr>   
     <tr><td style="height: 5px; line-height: 5px;">&nbsp;</td></tr>  
     </table>
</div>
<div id="divCard"  style="text-align:center;display:none; background-color:#fff;left:0px;"></div>
</body>
</html>
</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
 var message="<%=request.getAttribute("updateMessage")%>";
 if(message!=null&&message!="null"){
 <%request.removeAttribute("updateMessage");%>
alert(message);
 }
});
</script>
