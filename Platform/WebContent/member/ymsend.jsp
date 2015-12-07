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
<title>短信发送表列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js" type="text/javascript"></script>
<script type="text/javascript">
function checkall(obj){
  $(".check").attr("checked",obj.checked);
}
function copy(value){
 window.clipboardData.setData("Text",value); 
  alert("复制成功。现在您可以粘贴（Ctrl+v）到其他地方了。");
}

function sendMsg(){
var checkbox=document.getElementById("quanxuan");
var len=$("input[name='phonenum']:checked").length;
if(len==0){
 alert("无效操作，请选择您要重新发送短信的号码！");
}else if(checkbox.checked==true){
var temp = confirm('确认重新发送所有短信吗？');
if(temp==true){
Ext.Ajax.request({
form:'form1',
params:{ajax:'true'},
success:function(resp,opts){
//Ext.util.JSON.decode
  var respText = resp.responseText;
if(respText=="true"||respText==true){
  alert("短信已重新发送！");
  }else{
  alert("手机号："+respText+"发送失败！");
  }
},
falider:Ext.emptyFn
});
}
}else{
	Ext.Ajax.request({
form:'form1',
params:{ajax:'true'},
success:function(resp,opts){
//Ext.util.JSON.decode
  var respText = resp.responseText;
if(respText=="true"||respText==true){
  alert("短信已重新发送！");
  }else{
  alert("手机号："+respText+"发送失败！");
  }
},	
falider:Ext.emptyFn
});
}
}
</script>

</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;短信发送表列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" id="form1" method="post" action="ymsend.action">

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>
								<table width="60%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td align="right" height="20" align="right">接收人手机号：</td>
										<td align="left">
										<input id="startnum2" style="WIDTH: 160px" name="s_phone" value="<ww:property value="s_phone"/>" /> </td>
										<!--  <td align="right">发送人姓名：</td>
										<td align="left">
										<select style="WIDTH: 160px" name="s_employeeid">
										    <option value="0">---请选择发送人---</option>
										    <ww:iterator value="listemployee">
										    
											<option value="<ww:property value="id"/>"><ww:property value="id"/>---<ww:property value="membername"/></option>
											</ww:iterator>
										</select></td>-->
										<td align="right">订单号：</td><td><input style="WIDTH: 160px"  name="ymsend.ordercode" value="<ww:property value="ordercode"/>"/></td>
									</tr>
									<tr>
										<td align="right">起始时间：</td>
										<td align="left">
										<input id="startnum2" style="WIDTH: 160px" name="s_stratedate" value="<ww:property value="s_stratedate"/>" onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})"
									class="Wdate" /> 
										</td>
										
										<td align="right">结束时间：</td>
										<td align="left">
										<input id="startnum2" style="WIDTH: 165px" name="s_endedate" value="<ww:property value="s_endedate"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /> 
										</td>

									</tr>
									<tr><!--  <td align="right">订单号：</td><td><input style="WIDTH: 160px"  name="ymsend.ordercode" value="<ww:property value="ordercode"/>"/></td>-->
									<td align="right">发送状态：</td>
									<td>
								
									<select style="width: 160px" name="ymsend.state">
									<option value="">------全部------</option>
									<option value="0" <ww:if test="state!=null&&state!=1">selected="selected"</ww:if> >发送成功</option>
									<option value="6"  <ww:if test="state==1">selected="selected"</ww:if> >发送失败</option>
									</select>
									</td>
									</tr>
									<tr>
									<td colspan="4" height="10px"></td>
									</tr>
									<tr>
										<td colspan="4" align="center">
										<input type="submit"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="查询" />
										<input style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold; margin-left:40px;"
										 type="button" value="重新发送" onclick="sendMsg()"/><font style="color:#f90">(请选择列表内短信进行重新发送。)</font>
											</td>
									</tr>
									<td colspan="4" height="10px"></td>
								</table>
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th class="table_color"><input type="checkbox" name="checkbox" id="quanxuan" onclick="checkall(this)" />全选</th>
											<th class="table_color">手机号码</th>
											<th class="table_color">短信内容</th>
											<th class="table_color">状态</th>
											<th class="table_color">发送时间</th>
											<th class="table_color">订单号</th>
											<th class="table_color">发送人</th>


										</tr>

										<ww:iterator value="listYmsend">
									
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
												
												<td class="table_color"><input type="checkbox" class="check" name="phonenum" value="<ww:property value="id" />"/></td>												
												
												<td class="table_color"><ww:property value="phone" /></td>
												<td class="table_color" style="text-align: left;padding-left: 10px"
													title="<ww:property value="content" />" onclick="copy('<ww:property value="content" />')"><ww:property
													value="SubString(content,45)" /></td>
												
												<td class="table_color">
												<ww:if test="state==1">发送成功</ww:if><ww:else>发送失败</ww:else></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<td class="table_color"><ww:property value="ordercode" /></td>
                                                <td class="table_color">
                                                <ww:if test="description!=null">
                                                       <ww:property value="getLoginUser().getLoginname()"/>
                                                </ww:if>
                                                <ww:else>
                                                            系统发送
                                                </ww:else>
                                                </td>

											</tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center"><ww:property
									value="pagination" /></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
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


<script language="JavaScript">
	function toadd(){
		window.location="ymsend!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="ymsend!delete.action?id="+document.form1.selectid.value;
							document.form1.submit();
						}
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      	var temp = confirm('确认删除吗？');
							if(temp==true){
								document.form1.action="ymsend!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="ymsend!batch.action?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }

 function updateItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="ymsend!toedit.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="ymsend!toedit.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
	
 function checkItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="ymsend!tocheck.action?id="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}
			}
			
			  	 if ( length == null || length==0 ){
					  	 
					  	  	 alert("你未选择任何内容");
					          return;
				  }else{
					   	 var len=0;
					   	 var uvalue=0;
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					      		document.form1.action="ymsend!tocheck.action?id="+uvalue;
								document.form1.submit();
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
 
			
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





