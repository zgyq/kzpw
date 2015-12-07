<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/left_n.css" type="text/css" rel="stylesheet" />
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script>

function valform(){
var vone=$("#vmoneyone").val();
var vtwo=$("#vmoneytwo").val();
<ww:if test="getLoginsessionagent().agenttype!=1">
if(vone<0||vtwo<0){
Ext.MessageBox.alert("提示","充值金额不能小于0");
return false;
}
</ww:if>
if(vone==""){
Ext.MessageBox.alert("提示","请输入充值金额！");
return false;
}
if(vtwo==""){
Ext.MessageBox.alert("提示","请再次输入充值金额！");
return false;
}
if(isNaN(vone)||isNaN(vtwo)){
Ext.MessageBox.alert("提示","只能输入数字");
return false;
}
if(vone!=vtwo){
Ext.MessageBox.alert("提示","两次输入不一致");
return false;
}
$("#submitreg").val("请稍候..");
$("#submitreg").attr("disabled","disabled");
Ext.MessageBox.confirm("提示","是否确定本次账户充值？",
     function(btn){
				 if (btn == 'yes') {			 	
				   $("#vmoneyform").submit();
				}else{
				return false;
				}
				});
}


</script>
<ww:if test="#request.message!=null">
<script>
Ext.onReady(function(){
 Ext.MessageBox.alert("提示",'<ww:property value="#request.message"/>');

});

</script>
</ww:if>
</head>

<body >
<div  id="right"  >
    <div class="lit">
      <ul>
      <!--
       <li class="on"><a href="javascript:void(0)">账号充值</a></li>
       -->
        <li class="on"><a href="javascript:void(0)">&nbsp;</a></li>
       <li class="off"><a href='rebaterecord!torebaterecord.action?rebaterecord.rebateagentid=<ww:property value="rebaterecord.rebateagentid"/>' >消费记录</a></li>
       <!-- <li class="offwu"><a href="modify.html" target="mainFrame">现金提取</a></li>-->
    </ul>
    </div>
    <div id="main" lang="ca" class="kuang box"> 
     
      <div class="sea box_hui"><form id="vmoneyform" name="vmoneyform" 
         action="rebaterecord!addVmoneyPage.action"
          method="post">
         <input type="hidden" name="rebaterecord.rebateagentid" value='<ww:property value="#request.agent.id"/>' />
         <input type="hidden" name="customeragent.agentcompanyname" value="<ww:property value='#request.agent.agentcompanyname'/>"/>
         <input type="hidden" name="customeragent.id" value="<ww:property value='#request.agent.id'/>"/>
           <table width="500"  cellpadding="0" cellspacing="0" border="1"
					bordercolor="#a0cfee"
					style="border-collapse: collapse;">
              <tr>
                <td height="25" style="width:20%" align="right" ><div class="td_color">代理商名称：</div></td>   
                 <td class="table_color_l" style="text-align: left;" >&nbsp;<b><ww:property value="#request.agent.agentcompanyname"/></b></td>
              </tr>
              <tr>
                <td  height="25" style="width:20%" align="right"><div class="td_color">账户余额：</div></td>   
                 <td class="table_color_l" style="text-align: left">&nbsp;
                 <b><ww:property value="#request.agent.vmoney"/></b>元
                </td>
              </tr>
              <tr>
                <td  height="25" style="width:20%" align="right"><div class="td_color">充值金额：</div></td>   
                 <td class="table_color_l" style="text-align: left">&nbsp;
                  <input name='rebaterecord.rebatemoney' size='15' id='vmoneyone' desc='充值金额'  />&nbsp;元 <span style="color:red">*</span>
                 </td>
              </tr>
              <tr>
                <td  height="25" style="width:20%" align="right"><div class="td_color">确认充值金额：</div></td>   
                 <td class="table_color_l" style="text-align: left">&nbsp;
                 <input id='vmoneytwo' desc='充值金额'   size='15' />&nbsp;元 <span style="color:red">*</span>
                 </td>
              </tr>
              <tr>
                <td  height="25" style="width:20%" align="right"><div class="td_color">业务类型：</div></td>   
                 <td class="table_color_l" style="text-align: left">&nbsp;
                 <select name="rebaterecord.yewutype" onchange="rechargeTypechage(this.value)">
                 	 <option value="0">虚拟账户充值</option>
                 	 <!--
                    <option value='1'>国内机票</option>
                 
                    -->
                    <!--<option value="0">虚拟账户充值</option>
                    <ww:if test="getLoginsessionagent().agenttype==1">
                    <ww:iterator value="#request.agent.bussinesslist">
                    <option value='<ww:property value="id"/>'><ww:property value="name"/></option>
                    </ww:iterator>
                    </ww:if>
                 	-->
                 </select>
                 </td>
              </tr>
              <tr id="ordernumbertr" style="display: none;">
                <td  height="25" style="width:20%" align="right"><div class="td_color">订单号：</div></td>   
                 <td class="table_color_l" style="text-align: left">&nbsp;
                 <input type="text" id="ordernumber" name="rebaterecord.ordernumber" size='15' disabled" value="" />
                 </td>
              </tr>
              <tr>
                <td  height="51" style="width:20%" align="right" >
                <div class="td_color">备注信息：</div></td>   
                 <td class="table_color_l" style="text-align: left">&nbsp;
                 <textarea rows="3" name="rebaterecord.rebatememo" cols="30"></textarea>
                 </td>
              </tr>
              <tr>
                <td class="table_color_l" height="40px" colspan="2">
                <table width="100%">
                <tr>
                <td>  <font style="font-size: 12">
                提示：点击 "账户充值" 后若记录列表未变化，点此<a href='vmoneyrecord.action?s_agentid=<ww:property value="s_agentid"/>'>刷新查看</a>
                </font></td>
                <td style="text-align: right;">
              
               <input type="button" onclick="valform();" id="submitreg"   class="button_h"
						 value=" 账户充值 " />&nbsp;&nbsp;
							</td></tr>
			    </table>
                </td>   
              </tr>
              
             </table>
         </form>
       
    </div>
</div>
</body>
</html>
