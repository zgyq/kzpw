<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>加盟商列表</title>
<style>
.table20{ border-collapse:collapse; border:1px solid #a0cfee; }
.table20 td{ border-color:#a0cfee; line-height:24px; height:24px; border-top:1px solid #ccc}
.pf20{ padding-left:20px;}
.pf40{ padding-left:40px;}
.pf60{ padding-left:60px;}
.pf80{ padding-left:80px;}
.pf100{ padding-left:100px;}
</style>
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
<link href="public/css/left.css" type="text/css" rel="stylesheet" />
<link href="public/css/public.css" type="text/css" rel="stylesheet" />
<link href="public/css/main.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/extjs/3.2.1/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/extjs/3.2.1/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/extjs/3.2.1/ext-all.js"></script>
<link href="style/mapcss.css" rel="stylesheet" type="text/css" />
<link href="style/dialog.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<script charset="UTF-8" src="js/dialog.js" type="text/javascript"></script>
<script type="text/javascript">
function candelt(agentid){

Ext.Ajax.request({
  url:"customeragent!ajaxcandelt.action",
  async: false,
  params:{id:agentid},
 success:function(resp,opts){
//Ext.util.JSON.decode( resp.responseText)
  var respText = resp.responseText;                                
  if(respText=="true"||respText==true){  
     Ext.MessageBox.confirm("确认","删除加盟商将同步删除其下级所有加盟商和员工，是否确定删除？",function(btn){
             if(btn=='yes'){
           window.location.href="customeragent!delete.action?id="+agentid+"&agenttype=<ww:property value="customeragent.agenttype"/>"; 
		   }});  
  }else{
   Ext.MessageBox.alert("提示","当前加盟商不可删除(请查看此采购账户余额是否大于0或已有订单运营)！");
  }
  }
});
}

$(document).ready(function(){

<ww:if test="#request.message!=null">
alert('<ww:property value="#request.message"/>');
</ww:if>
});
function searcnnext(agentid){
 var d=nextagents(agentid);
 $("#agentspan"+agentid).replaceWith(d);
}
function nextagents(agentid){
var da="";
$.ajax({
    type:"POST",
    url:"customeragent!ajaxagentlist.action?id="+agentid,
    dataType : 'text', 
    data : $(document.comform).serialize(),
    async:false,         
    success:function(data){

     da=data;
    }            
    });
    
    return da;
  }
function canOpnenext(id){

window.location.href='customeragent!toadd.action?agenttype=<ww:property value="agenttype"/>&parentid='+id;
}


function nexttoggle(c){
if($("#agentspan"+c).html()==null){
   if( $("."+c).is(":visible")){
   $("."+c).hide();
   }else{
   $("."+c).show();
   }
}else{
searcnnext(c);
}

}


function showqemailbox(id,opt)
{

    $("#divIframe").dialog({
            title:'通知地址',
            show: null,
            bgiframe: false,
            autoOpen: false,
            draggable: true,                
            resizable: true,
            modal: true,
            width: 480,
            height: 180
        });
    $("#divIframe").dialog("open");
    document.getElementById("hiddenid").value=id;
    document.getElementById("agentother").value=document.getElementById("agentother_"+id).value;
}
function editURLjs(){
	var val=document.getElementById("agentother").value;
    var temp = confirm('确认修改地址吗？');
	if(temp==true){
		document.form1.action="customeragent!editURLvalue.action";
		document.form1.submit();
	}
	return;
}
function showqemailbox_ip(id,opt)
{

    $("#divIframe_ip").dialog({
            title:'绑定IP',
            show: null,
            bgiframe: false,
            autoOpen: false,
            draggable: true,                
            resizable: true,
            modal: true,
            width: 480,
            height: 180
        });
    $("#divIframe_ip").dialog("open");
    document.getElementById("hiddenid_ip").value=id;
    document.getElementById("website_ip").value=document.getElementById("website_"+id).value;
}
//设置国际加价
function showqemailbox_interticket(id,opt)
{

    $("#divIframe_interticket").dialog({
            title:'设置国际加价',
            show: null,
            bgiframe: false,
            autoOpen: false,
            draggable: true,                
            resizable: true,
            modal: true,
            width: 480,
            height: 180
        });
    $("#divIframe_interticket").dialog("open");
    document.getElementById("hiddenid_interticket").value=id;
    document.getElementById("runtype_interticket").value=document.getElementById("runtype_"+id).value;
}


function editURLjs_ip(){
	var val=document.getElementById("website_ip").value;
    var temp = confirm('确认修改IP吗？');
	if(temp==true){
		document.form_ip.action="customeragent!editIPvalue.action";
		document.form_ip.submit();
	}
	return;
}
</script>

</head>
<body >

<div  id="right" >

    <div class="lit">
      <ul>
       <li class="offwu">加盟商列表</li>
     
       <li style="float:right" class="mr11">
       <input type=button value="" class="button_shuaxin" onclick="window.location.reload()"></li>
      </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
   
      <div>

<div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" style="background:url(imagess/bj_taitou.gif) repeat-x; height:30px; line-height:30px;" >
          <tr>
            <td width="20" ><img src="images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">加盟商查询</font></td>
           
          </tr>
        </table>
     <form action="customeragent!tofenxiao.action" method="post" id='comform' name='comform' >
     <input type="hidden" name="agenttype"  value='<ww:property value="customeragent.agenttype"/>'/>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="font-69f" >
          <tr><td colspan="8" class="h8"></td></tr>
          <tr>                                                  
            <td width="10%" align="right">代理名称</td>
            <td width="14%"><input name="customeragent.agentcompanyname" value='<ww:property value="customeragent.agentcompanyname"/>' type="text" class="text" /></td>
            <td width="10%" align="right">代码</td>
            <td width="14%"><input name="customeragent.code" value='<ww:property value="customeragent.code"/>' type="text" class="text" /></td>
            <td width="10%" align="right">联系人</td>
            <td width="14%"><input name="customeragent.agentcontactname" value='<ww:property value="customeragent.agentcontactname"/>' type="text" class="text" /></td>
            <td width="10%" align="right">联系电话</td>
            <td width="14%"><input name="customeragent.agentphone" value='<ww:property value="customeragent.agentphone"/>' type="text" class="text" /></td>
          </tr>
          <tr><td colspan="8" class="h8"></td></tr>
          <tr>
          <td class="butt font-666" colspan="8"><input type="submit" class="button_sea mr18" value="查询代理"  />根据您输入的内容进行查询！ </td>
          </tr>
        </table>
        </form>
      </div>
      <ww:set name="addmoney" value='checkright("addmoney")' />
      <div class="list">

        <table width="100%" border="0"  cellspacing="0" cellpadding="0"  class="biao box table20">

          <thead>

            <th scope="col" width="15%" ><div class="thleft">代码</div></th>

            <th scope="col" width="20%"><div class="thleft">代理名称</div></th>
            <!--
            <th scope="col" width="8%"><div class="thleft">剩余短信</div></th>
            -->
            <th scope="col" width="8%"><div class="thleft">状态</div></th>
            <ww:if test="vmenable">
            <th scope="col" width="8%"><div class="thleft">预存款</div></th>
            </ww:if>

            <th scope="col" width="8%"><div class="thleft">联系人</div></th>

            <th scope="col" width="10%"><div class="thleft">联系电话</div></th>

           

            <th scope="col"><div class="thleft">操作</div></th>                                         

          </thead>
          <tbody>
          <ww:iterator value="listCustomeragent">
            <tr>
            <td align="left">
            <font class="font-000 mr8">
            <a href="javascript:void(0)" onclick='nexttoggle(<ww:property value="id"/>);'>            
            <img   src="skin/blue/images/1.png"  height="16" align="absmiddle" />
                <ww:property value="code"/>
            </a>
                </font></td>
            <td><font class="font-666"><ww:property value="agentcompanyname"/></font></td>
            <!--<td><font class="font-666"><ww:property value="smscount"/></font></td>
            --><td><font class="font-666">
		         <ww:property value="agentisenable==0?'禁用':'正常'"/> </font></td>
             <ww:if test="vmenable">
            <td><font class="font-666"><ww:property value="vmoney"/></font></td>
            </ww:if>
            <td><font class="font-bdb0000"><ww:property value="agentcontactname"/></font></td>
            <td><font class="font-666"><ww:property value="agentphone"/></font></td>
            
            
            
            <td class="line-h18">
          
            <ww:if test="(getLoginsessionagent().agenttype==1 || getLoginsessionagent().openable == 1)&&agenttype == 3">
             <font class="x_line mfr5"><a onclick="canOpnenext(<ww:property value="id"/>);" href='javascript:void(0)'>下级开户</a></font>|
            </ww:if>
            <ww:if test="getLoginsessionagent().agenttype==1||parentid==getLoginsessionagent().id||getLoginsessionagent().openable == 1">
             <a href='customeragent!toeditgent.action?compnayid=<ww:property value="id"/>'>修改</a>|
             
             
             <ww:if test="getLoginsessionagent().agenttype==1"><a href="javascript:void(0)" onclick='candelt(<ww:property value="id"/>);'>删除</a>|</ww:if>
            </ww:if>
            
            <ww:if test="(parentid==getLoginsessionagent().id || getLoginsessionagent().openable == 1)&& agenttype == 3">
            <font class="x_line mfr5"><a href='liudianinfo!toadd.action?lagentid=<ww:property value="id"/>&s_agentid=<ww:property value="id"/>'>机票留点设置</a></font>|
            </ww:if>
             <ww:if test="(parentid==getLoginsessionagent().id || getLoginsessionagent().openable == 1)&& agenttype == 3&&checkright('xianfu')==true">
            <font class="x_line mfr5"><a href='liudianinfo!tohoteladd.action?lagentid=<ww:property value="id"/>'>酒店留点设置</a></font>|
            </ww:if>
            <ww:if test="vmenable&&getLoginsessionagent().agenttype==1">
            
            
            <ww:if test="#addmoney">
            <font class="x_line mfr5"><a href='rebaterecord.action?rebaterecord.rebateagentid=<ww:property value="id"/>'>充值</a></font>|
            </ww:if>
            </ww:if>
            <ww:if test="getLoginsessionagent().agenttype==1">
            <font class="x_line mfr5"><a href='customeruser!toEmployeelist.action?agentid=<ww:property value="id"/>'>员工信息</a></font>
            
            |<font class="x_line mfr5"><a href='dnsmaintenance.action?s_agentid=<ww:property value="id"/>'>域名绑定</a></font>|
            </ww:if>

            <ww:if test="getLoginsessionagent().b2copenable==1&&getLoginsessionagent().id==46">
            	<font class="x_line mfr5"><a href='b2cagent!b2cskip.action?b2cAgent.agentid=<ww:property value="id"/>'>B2C开户</a></font>|
            </ww:if>
            
            <font class="x_line mfr5"><a href='liudianinfo!toadd.action?lagentid=<ww:property value="id"/>&s_agentid=<ww:property value="id"/>'>B2C留点</a></font>|
            
            
            <!--	
             <ww:if test="(parentid==getLoginsessionagent().id || getLoginsessionagent().agenttype == 1)">
            	<font class="x_line mfr5"><a href='customeragent!b2btoedit.action?customeragent.id=<ww:property value="id"/>'>权限设置</a></font>|
            </ww:if>
            -->
            <%--
             <ww:if test="getLoginsessionagent().id==46">
            	<font class="x_line mfr5">
            	<input type="hidden" value="<ww:property value="agentother" />" name="agentother_<ww:property value="id"/>" id="agentother_<ww:property value="id"/>" />
            	<a href="javascript:void(0)" onclick="showqemailbox(<ww:property value="id"/>);return false;">通知地址</a></font>
             </ww:if>
             --%>
              <ww:if test="getLoginsessionagent().id==46">
            	<font class="x_line mfr5">
            	<input type="hidden" value="<ww:property value="agentother" />" name="agentother_<ww:property value="id"/>" id="agentother_<ww:property value="id"/>" />
            	<a href="javascript:void(0)" onclick="showqemailbox(<ww:property value="id"/>);return false;">通知地址</a></font>
            	|
            	<font class="x_line mfr5">
            	<input type="hidden" value="<ww:property value="website" />" name="website_<ww:property value="id"/>" id="website_<ww:property value="id"/>" />
            	<a href="javascript:void(0)" onclick="showqemailbox_ip(<ww:property value="id"/>);return false;">绑定IP</a></font>
            	|
            	<font class="x_line mfr5">
            	<input type="hidden" value="<ww:property value="childbrokenum" />" name="childbrokenum_<ww:property value="id"/>" id="childbrokenum_<ww:property value="id"/>" />
            	<a href='login!tobaoxian.action?c_agentid=<ww:property value="id"/>'>设置保险</a></font>|
             </ww:if>
             <font class="x_line mfr5">
            	<input type="hidden" value="<ww:property value="runtype" />" name="runtype_<ww:property value="id"/>" id="runtype_<ww:property value="id"/>" />
            	<a href="javascript:void(0)" onclick="showqemailbox_interticket(<ww:property value="id"/>);return false;">国际加价</a></font>
            	|
            </td>
          </tr>
          <tr id='agentspan<ww:property value="id"/>'></tr>
          </ww:iterator>
          </tbody>

       
          <tr>

            <td class="tdpadd00" colspan="11" align="left">

            <div class="fenye">
            	<ww:property
			value='getPagetwo(pageinfo,"pageinfo","customeragent!tofenxiao.action","comform")' />

             </div>

             </td>

          </tr>

         </table>

         <div class="h8" >&nbsp;</div>

      </div>

    </div>

</div>

<div id="divIframe" title=""
	style="text-align: center; display: none; background-color: #fff; left: 0px;">
<form name="form1" method="post" action="">
<table width="100%">
	<tr>
		<td colspan="2" height="30px;">地址：</td>
	</tr>
	<tr>
		<td colspan="2" align="left" width="450">
		<textarea rows="3" cols="80" id="agentother" name="agentusernamename"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="hidden" name="hiddenid"
			id="hiddenid" /> <input type="button" onclick="editURLjs()"
			class="button_d font-white" value="确认修改" name="button" /></td>
	</tr>
</table>
</form>
</div>
<div id="divIframe_ip" title=""
	style="text-align: center; display: none; background-color: #fff; left: 0px;">
<form name="form_ip" method="post" action="">
<table width="100%">
	<tr>
		<td colspan="2" height="30px;">IP：</td>
	</tr>
	<tr>
		<td colspan="2" align="left" width="450">
		<textarea rows="3" cols="80" id="website_ip" name="agentusernamename_ip"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="hidden" name="hiddenid_ip"
			id="hiddenid_ip" /> <input type="button" onclick="editURLjs_ip()"
			class="button_d font-white" value="确认修改" name="button" /></td>
	</tr>
</table>
</form>
</div>
<div id="divIframe_interticket" title=""
	style="text-align: center; display: none; background-color: #fff; left: 0px;">
<form name="form_interticket" method="post" action="">
<table width="100%">
	<tr>
		<td colspan="2" height="30px;">加价：</td>
	</tr>
	<tr>
		<td colspan="2" align="left" width="450">
		<textarea rows="3" cols="80" id="runtype_interticket" name="agentusernamename_ip"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="hidden" name="hiddenid_interticket"
			id="hiddenid_interticket" /> <input type="button" onclick="editURLjs_interticket()"
			class="button_d font-white" value="确认修改" name="button" /></td>
	</tr>
</table>
</form>
</div>
</body>
</html>
