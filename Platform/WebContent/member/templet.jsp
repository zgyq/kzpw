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
<title>模板列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script src="<%=request.getContextPath() %>/js/jquery1.3.2.js"
	type="text/javascript"></script>
<script>

</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;模板列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="templet.action">

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


								<table width="900" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="100" height="20" align="right">名称：</td>
										<td><span style="HEIGHT: 71px"> <input id="s_name"
											style="WIDTH: 181px" name="s_name"
											value="<ww:property value="s_name"/>" /> </span></td>
										<td width="100" height="20" align="right">模板类型：</td>
										<td><span style="HEIGHT: 71px"> <select
											name="ttype">
											<option value="">---请选择模板---</option>
											<option value="标准模板">标准模板</option>
											<option value="自定义模板">自定义模板</option>
										</select> </span></td>
										  <td width="100" height="20" align="right">模板所属业务：</td>
										<td align="left"><span style="HEIGHT: 71px"> <select
											name="yewu" >
											<option value="">--请选择所属业务--</option>
											<ww:iterator value="listbussiness">
											<option value="<ww:property value="name"/>"><ww:property value="name"/></option>
											</ww:iterator>
										</select> </span></td>
										<td width="20%" rowspan="3">
										<div align="center"><input type="submit"
											class="button_d font-bai" value="查询" /></div>
										</td>
									</tr>

								</table>

								</td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="38" align="center">
										<div align="right"><a href="#" onclick="toadd()"><input
											type="button" value="新增" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red"></a></div>
										</td>
									</tr>
								</table>
								</td>
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

											<th class="table_color">模板名称</th>
											<th class="table_color">模板内容</th>
											<th class="table_color">模板类型</th>
											<th class="table_color">模板所属业务</th>
											<th class="table_color">创建日期</th>

										</tr>

										<ww:iterator value="listTemplet">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox" 
													name="selectid" value="<ww:property value="id"/>" />
													<input type="test" style="display: none;"
													name="selecttype" value="<ww:property value="templettype"/>" />
													</td>
												</td>
												<td class="table_color"><ww:property
													value="templetname" /></td>
												<td class="table_color"
													title="<ww:property value="templetmess" />"><ww:if
													test="templetmess.length()>10">
													<ww:property value="SubString(templetmess,10)" />....</ww:if> <ww:else>
													<ww:property value="templetmess" />
												</ww:else></td>
												<td class="table_color" title="标准模板为系统模板不能删除,您还可以自行添加自定义模板"><ww:property
													value="templettype" /><input type="hidden" id="hidtemplettype_<ww:property value="id"/>" 
													value="<ww:property value="templettype" />"></td>
												<td class="table_color"><ww:property value="templetyewu"/></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>


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
		window.location="templet!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
				if(document.form1.selectid.checked ==true)
				{	
						var temp = confirm('确认删除吗？');
						if(temp==true){
						    if($("#hidtemplettype_"+document.form1.selectid.value).val()!="标准模板")
						    {
							 document.form1.action="templet!delete.action?id="+document.form1.selectid.value;
							 document.form1.submit();
							}
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
					   	  var deleflag=0;
					   	  var templtypestr="";
					     for (var i = 0; i < length; i++)
					      {
					         
					         if( document.form1.selectid[i].checked ==true){
								uvalue=document.form1.selectid[i].value;
								templtypestr+=$("#hidtemplettype_"+document.form1.selectid[i].value).val()+",";
								len++;					         
					         }
						      
					      }
					      
					     
					      if(len==1){
					       if($("#hidtemplettype_"+uvalue).val()=="标准模板")
					       {
					           alert("标准模板不能删除，请重新选择！");
					           return;
					       }
					      	var temp = confirm('确认删除吗？');
							if(temp==true){

								  document.form1.action="templet!delete.action?id="+uvalue;
								  document.form1.submit();
							}
							return;
					      }else if (len>1){
				            if(templtypestr.indexOf("标准模板")>=0)
				            {
				               deleflag=1;
				            }
					       if(deleflag==1)
					       {
					           alert("您所选择的模板中包含标准模板，标准模板不能删除，请重新选择!");
					           return;
					       }
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="templet!batch.action?opt=1";
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
						
						document.form1.action="templet!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="templet!toedit.action?id="+uvalue;
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
						
						document.form1.action="templet!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="templet!tocheck.action?id="+uvalue;
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





