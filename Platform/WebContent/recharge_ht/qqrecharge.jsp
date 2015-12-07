<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出票报表</title>

<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script src="js/jquery1.3.2.js"></script>
<script src="js/PublicJs.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
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
function refreshRechstate(onumber){

   $.ajax({
      url:"ofcard!ajaxGetQmoneyRechState.action",
      type:"POST",
      data:{orderid:onumber},
      beforeSend:function(){$("#state"+onumber).html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=request.getContextPath()%>/images/loadding.gif' border='0' />");},             
      success:function(data){
      $("#state"+onumber).html(data);
    }    
    });

}

function ajaxnextqmoneyRecharge(id,onumber){

window.location.href="ofcard!vmoneyqmoneyRecharge.action?orderid="+id;


}
</script>
</head>
<body>
<div id="member">
<form name="form1" id='form1' method="post"
			action="ofcard!toQmoneyRechargeOrder.action">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;手机充值订单列表</b></td>
	</tr>
	<tr>
		<td valign="top">
			<input type="hidden" name="is_first" />
			
			<table width="100%" border="0" cellspacing="0" cellpadding="0"  class="table2">
                      <tr>
                       <td style="display:none" align="right" width="85">加盟商：</td>
					    <td style="display:none">
					    <div id='comboxWithTree'></div>
					    <input type='hidden' id="companyname" name="companyname" value='<ww:property value="companyname"/>' />
		                <input type="hidden" id="parentid" name="agentid" value='<ww:property value="agentid"/>'
						 style="width: 350px" />
					    </td>
                        <td nowrap="nowrap" align="right" width="85" >充值号码：</td>
                        <td class="texb" >
                        <label>
                         <input type="text" class="input_dd" style="width:120px;" name="rechnumber" value="<ww:property value="rechnumber"/>" />
                       </label>
                       </td>
                        <td nowrap="nowrap" align="right" width="85" > 充值时间：</td>
                        <td class="texb texr" >
                        <input 
								id="cptime" style="WIDTH: 85px" name="rechstime"
								value="<ww:property value="rechstime"/>"
								onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" class="Wdate" />- <input
								id="cpendtime" style="WIDTH: 85px" name="rechetime"
								value="<ww:property value="rechetime"/>"
								onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" class="Wdate" />
                        </td>
                        
                        <td nowrap="nowrap" align="right" width="85" > 状态：</td>
                        <td class="texb texr" colspan="3" >
                        <select name="rechstate" style="width: 125px">
                        <option value='-1'></option>
                        <ww:iterator value="qmoneyrecharge.mobileStateMap">
                        <option <ww:if test="rechstate==key">selected="selected"</ww:if>  value='<ww:property value="key"/>'><ww:property value="value"/></option>
                        </ww:iterator> 
                       </select>
                          </td>
                        
                      </tr>
                      
                      <tr class="font-blue-xi">
					<td height="58" colspan="10" align="center">
					<input name="" type="submit" class="button_d font-white" value="查询订单"  align="absmiddle" />
					</td>
					</tr>                   
                    </table>    
      
         <table width="100%" border="1" cellspacing="0" cellpadding="0"  class="table_color">
          <tr class="tbody_color">
            <td  class="table_color" >订单号</td>
            <td  class="table_color" >充值号码</td>
            <td  class="table_color" >充值金额(元)</td>
            <td  class="table_color" >支付方式</td>
            <td  class="table_color" >充值用户</td>
            <td  class="table_color" >充值时间</td>
            <td  class="table_color" >充值状态</td>
            <td  class="table_color" >操作</td>
          </tr> 
        
          <ww:iterator value="#request.qmoneyrechargelist" status="t">    
         
          <tr>
            <td  class="table_color" >
            <ww:property value="ordernumber"/>
           
             </td>
            <td  class="table_color" ><ww:property value="qqnumber"/> </td>
            <td  class="table_color"  ><ww:property value="rechmoney"/></td>
            <td  class="table_color"  ><ww:property value="paymethodtype"/></td>
            <td  class="table_color"  > <ww:property value="rechuname"/></td>
            <td  class="table_color" ><ww:property value="formatTimestamp(rechtime)"/> </td>
            <td  class="table_color" >
            <span id='state<ww:property value="id"/>'>
            <ww:property value="statestr"/></span> 
            <ww:if test="rechstate==0"> <a onclick="refreshRechstate('<ww:property value="id"/>')" href="#" style="size: 3"> 刷新</a></ww:if>
            </td>
           	<td class="table_color" >
           	<span id='nextrech<ww:property value="id"/>'>&nbsp;&nbsp;&nbsp;&nbsp;</span>
           	<ww:if test="rechstate==9">
		    <input type="button" onclick="ajaxnextqmoneyRecharge(<ww:property value="id"/>,'<ww:property value="ordernumber"/>')" class="button108" id='nextrechbtn<ww:property value="id"/>' type="button" value="充值"/>
		    </ww:if>
		    <ww:if test="rechstate==11">
		    <input class="button108" type="button" onclick="window.location.href='ofcard!nextQmoneyRechargePay.action?rechid=<ww:property value="id"/>'"  id='nextpaybtn<ww:property value="id"/>' type="button" value="立即支付"/>
		    </ww:if>
		   </td>
          </tr>  
          </ww:iterator>
        
          </table>  
			
			
		</td>
	</tr>

</table>
<div style="text-align: center; width: 100%; padding-top: 10px;">
<ww:property
	value='getPagetwo(pageinfo,"pageinfo","ofcard!toQmoneyRechargeOrder.action","form1")' />
</div>
</form>


</td>
</tr>
</table>
</body>
</html>


<script language="JavaScript">


			
function unselectall()
{
    if(document.form1.all.checked){
	document.form1.all.checked = document.form1.all.checked&0;
    }
}

function selectall1()
{
    var length=document.form1.selectid.length;
    document.form1.all1.checked = document.form1.all1.checked|0;
  

   if ( length ==undefined &&  document.form1.selectid!=null ){
    	  document.form1.selectid.checked=document.form1.all1.checked ;
          return;
    }


    if (length>1)
    {
      for (var i = 0; i < length; i++)
       {
          document.form1.selectid[i].checked = document.form1.all1.checked;
	      document.form1.getElementsByTagName("*").checked=document.form1.all1.checked;
       }
    }
}


</script>






