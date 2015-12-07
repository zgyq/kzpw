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
<title>Q信箱列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script>
  function showpnrinfo(index)
  {
    $("input[id*='txtrpnumber_']").each(function(i)
    {
      $("#pnrinfo_"+index).hide();
    }
    );
     $("#pnrinfo_"+index).show();
  }
 
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;Q信箱列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="qmessage.action">

		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr style="height:5px">
								<td></td>
							</tr>
							<tr>
								<td>
									<table width="90%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td align="right" align="right">处理人姓名：</td>
										<td align="left">
										<input id="startnum2" style="WIDTH: 160px" name="s_createuser" value="<ww:property value="s_createuser"/>" /> </td>
										<td align="right">状态：</td>
										<td align="left">
										<select style="WIDTH: 160px" name="s_ststus">
										    <option value="0" <ww:if test="s_ststus==0">selected</ww:if>>未处理</option>
										    <option value="1" <ww:if test="s_ststus==1">selected</ww:if>>已处理</option>
										    <option value="-1" <ww:if test="s_ststus==-1">selected</ww:if>>---所有---</option>
										    
										</select></td>
									</tr>
									<tr>
										<td align="right">信息起始时间：</td>
										<td align="left">
										<input id="startnum2" style="WIDTH: 160px" name="s_createstarttime" value="<ww:property value="s_createstarttime"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /> 
										</td>
										
										<td align="right">信息结束时间：</td>
										<td align="left">
										<input id="startnum2" style="WIDTH: 165px" name="s_createendtime" value="<ww:property value="s_createendtime"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /> 
										</td>

									</tr>
									<tr>
										<td align="right">处理起始时间：</td>
										<td align="left">
										<input id="startnum2" style="WIDTH: 160px" name="s_stratedate" value="<ww:property value="s_stratedate"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /> 
										</td>
										
										<td align="right">处理结束时间：</td>
										<td align="left">
										<input id="startnum2" style="WIDTH: 165px" name="s_endedate" value="<ww:property value="s_endedate"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /> 
										</td>

									</tr>
									<tr>
										<td colspan="4" align="center">
										<input type="submit"
											style="background: url(images/hout3.gif); width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
											value="查询" />
											</td>
									</tr>
									<td colspan="4" height="10px"></td>
								</table>
								</td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="27" align="center">
										<div align="right">&nbsp;&nbsp;&nbsp;<a href="#"
											onclick="updateItem()"><input type="button" value="修改"
											class="button_h font-red"></a></div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							<tr style="height:5px">
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

											<th class="table_color" width="54" height="25"><input
												type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>

											<th class="table_color">消息内容</th>
											<th class="table_color">时间</th>
											<th class="table_color">状态</th>
											<th class="table_color">处理人</th>
											<th class="table_color">处理时间</th>


										</tr>

										<ww:iterator value="listQmessage" status="state">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<td class="table_color"><a href="#"
													onclick="showpnrinfo(<ww:property value="#state.index" />)"><ww:property
													value="SubString(message,20)" />...</a></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<td class="table_color"><ww:if test="status==0">未处理</ww:if><ww:else>已处理</ww:else></td>
												<td class="table_color"><ww:property
													value="createuser" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(dealtime)" /></td>


											</tr>
											<tr>
												<td colspan="6">
												<div id="pnrinfo_<ww:property value="#state.index" />"
													style="text-align: left;display: none; background-color: Black; color: #00ff00; height: 123px; width: 100%; margin: 0 auto; overflow: auto;">
												<ww:property value="message" /></div>
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
		window.location="qmessage!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="qmessage!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="qmessage!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="qmessage!batch.action?opt=1";
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
						
						document.form1.action="qmessage!edit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="qmessage!edit.action?id="+uvalue;
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
						
						document.form1.action="qmessage!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="qmessage!tocheck.action?id="+uvalue;
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





