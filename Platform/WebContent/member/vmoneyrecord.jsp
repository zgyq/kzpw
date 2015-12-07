<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>消费记录</title>
<link href="css/left_n.css" type="text/css" rel="stylesheet" />
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript"
	src="js/My97DatePicker/WdatePicker.js"></script>
	
<ww:if test="getLoginsessionagent().agenttype==1">
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script>
Ext.onReady(function(){ 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,         
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:200,
	   tpl: "<tpl for='.'><div style='height:240px ; width:200px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  
	<ww:property value="#request.agentroot"/>
	var tree = new Ext.tree.TreePanel({           
          root:root,
          rootVisible:false
       }); 	
		comboxWithTree.setValue('<ww:property value="customeragent.agentcompanyname"/>');
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
</ww:if>
<style>
html{height:100%;}
body{height:100%;}
</style>	
</head>

<body>
<div  id="right"  style="background: #fff; height:100%;">
    <div class="lit">
      <ul>
      <!--
       <li  class="offwu" ><a href='rebaterecord.action?rebaterecord.rebateagentid=<ww:property value="rebaterecord.rebateagentid"/>'>账号充值</a></li>
       -->
       
        <li class="on"><a href="javascript:void(0)">&nbsp;</a></li>
        
        
       <li class="on"><a href="javascript:void(0)" >消费记录</a></li>
      <!--  <li class="off"><a href="modify.html" target="mainFrame">现金提取</a></li>-->
      </ul>
    </div>

   <form  id="form1" name="form1" action='rebaterecord!torebaterecord.action' method="post">
    <div id="main" lang="ca" class="kuang box">
      <div class="sea box_hui">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" style="background:url(images/bj_taitou.gif) repeat-x; height:30px; line-height:30px;" >
          <tr>
            <td width="20" ><img src="images/ico_detail.gif" width="16" height="19" /> </td>
            <td align="left"><font class="font16-f90">消费记录查询</font>&nbsp;&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="font-69f" >
          <tr><td colspan="16" class="h8">
          <input type="hidden" name="rebaterecord.rebateagentid" value='<ww:property value="rebaterecord.rebateagentid"/>' />
          </td></tr>
          <tr>
          <ww:if test="getLoginsessionagent().agenttype==1">
            <td width="5%" align="right">加盟商</td>
            <td width="16%">  
           <div id='comboxWithTree'></div>
		    <input type='hidden' id="companyname" name="customeragent.agentcompanyname" value='<ww:property value="customeragent.agentcompanyname"/>' />
           <input type="hidden" id="parentid" name="customeragent.id" value='<ww:property value="customeragent.id"/>'
			 style="width: 350px" />
            </td>
            <td style="text-align: left;" >为空表示平台</td>
          </ww:if>                                               
            <td width="5%" align="right">经手人</td>
            <td width="14%">
            <input size="10" name="rebaterecord.customername" value='<ww:property value="rebaterecord.customername"/>' />
            </td>
            <td width="5%" align="right">类型</td>
            <td width="14%">
           <select name="rebaterecord.rebatetype" style="width: 100px">
            <option value="0"></option>
            <option  <ww:if test="rebaterecord.rebatetype==3">selected="selected"</ww:if> value="3">账户充值</option>
            <option <ww:if test="rebaterecord.rebatetype==2">selected="selected"</ww:if> value="2">订单返佣</option>
            </select>
            </td>
            <td width="5%" align="right">时间</td>
            <td width="20%">
              	<input type="text" id='vone'
								name="recharestime"
								value='<ww:property value="formatDate(recharestime)"/>'
								style="width: 75px" onfocus="WdatePicker()" id="txtagentvsdate"
								class="Wdate two" />- 
			<input type="text" name="rechareetime"
								id="txtagentvedate"
								value='<ww:property value="formatDate(rechareetime)"/>'
								style="width: 75px" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'vone\',{d:+1});}'})" class="Wdate two" />
			
            </td>
          </tr>
         
        </table>
      </div>
      <div class="list">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" id="table2" >
          <tr>
            <td width="34"><img src="images/no1.gif" width="34" height="28" /> </td>
            <td align="left"><font class="font16-f90">消费记录</font><br/></td>
            <td align="left"></td>
            <td></td>
            <td width="16%" align="right"><input type="button" class="button_sea"  value=" 立即查询 " onclick="document.form1.action='rebaterecord!torebaterecord.action';document.form1.submit();"/>&nbsp;&nbsp;</td>
            <td width="8%">
         <input type="button" class="button_sea"  value="导出记录" onclick="document.form1.action='rebaterecord!expXMoneyExcel.action';document.form1.submit();"/>
            </td>
          </tr>
        </table>
        
        <table width="100%" border="1" bordercolor="#86b2d1" cellspacing="0" cellpadding="0"  class="biao" id="table1">
          <tbody>
            <th scope="col"><div class="thleft">序号</div></th>
            <ww:if test="getLoginsessionagent().agenttype==1">
            <th scope="col"><div class="thleft">采购商</div></th>
            </ww:if>
            <th scope="col"><div class="thleft">经手人</div></th>
            <th scope="col"><div class="thleft">金额</div></th>
            <th scope="col"><div class="thleft">类型</div></th>
            <th scope="col"><div class="thleft">关联订单</div></th>
            <th scope="col"><div class="thleft">时间</div></th>
            <th scope="col" width="40%"><div class="thleft">详细</div></th>                                       
          </tbody>
          <ww:iterator value="listRebaterecord" status="statu">
          <tr>
          	<td  class="table_color"><ww:property value="#statu.count+((pageinfo.pagenum-1)*pageinfo.pagerow)"/></td>
          	<ww:if test="getLoginsessionagent().agenttype==1">
			<td  class="table_color"><ww:property value="agentname"/></td>
			</ww:if>
			<td  class="table_color"><ww:property value="customername"/></td>
			<td  class="table_color"><font class="font16-f90"><ww:property value="rebatemoney"/>元</font></td>
			<td  class="table_color"><ww:property value="getyewuleixing(yewutype)"/></td>
			<td  class="table_color">
			<a target="_blank" href='b2bticketorder!showOrderdetail.action?orderinfo.ordernumber=<ww:property value="ordernumber"/>'>
			  <ww:property value="ordernumber"/>
			</a>	
			
			</td>
			<td  class="table_color"><ww:property value="formatTimestamp(rebatetime)"/></td>
			<td  class="table_color" style="text-align: left;padding-left: 5px"><ww:property value="rebatememo"/></td>
          </tr>
          </ww:iterator>
          
          <tr>
            <td class="tdpadd00" colspan="11" align="left">
            <div class="fenye">
              <ww:property
			value='getPagetwo(pageinfo,"pageinfo","rebaterecord!torebaterecord.action","form1")' />
             </div>
             </td>
          </tr>
         </table>
         <div class="h8" >&nbsp;</div>
      </div>
    </div>
    </form>
</div>
</body>
</html>
