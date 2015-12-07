<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	 /**
	 * 版权所有, 允风文化
	 * Author: B2B2C 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>行程单号码列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>

</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;行程单号码列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="xcdnoinfo.action">
		<input name="s_xcdid" value="<ww:property value="s_xcdid" />" type="hidden" />
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
           <table width="990" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
              
                <td width="120" height="20" align="right">编号：</td>    
                <td><span style="HEIGHT: 71px">
                  <input id="startnum2"   style="WIDTH: 91px" name="s_agentcode" value="<ww:property value="s_agentcode"/>" />
                </span></td>
                <td width="120" height="20" align="right">状态：</td>    
                <td>
                <select name="s_state">
                <option value="-1" <ww:if test="s_state==-1">selected</ww:if>>全部</option>
                <option value="1" <ww:if test="s_state==1">selected</ww:if>>未使用</option>
                <option value="2" <ww:if test="s_state==2">selected</ww:if>>已使用</option>
                </select>
                </td>
                <td width="120" height="20" align="right">填开单位：</td>    
                <td><span style="HEIGHT: 71px">
                  <input id="startnum2"   style="WIDTH: 111px" name="s_tiankai" value="<ww:property value="s_tiankai"/>" />
                </span></td>
                <td width="120" height="20" align="right">领单单位：</td>    
                <td><span style="HEIGHT: 71px">
                  <input id="startnum2"   style="WIDTH: 111px" name="s_lingdan" value="<ww:property value="s_lingdan"/>" />
                </span></td>
                <td width="30%" rowspan="3"><div align="left">
                  <input type="submit" class="button_d font-bai" value="查询"/>
                </div></td>
              </tr>
              
             </table>
        </td>
							</tr>
							<tr style="display: none">
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="27" align="center">
										<div align="right"><a href="#" onclick="toadd()"><input
											type="button" value="新增" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input
											type="button" value="审核" class="button_h font-red"></a></div>
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

											<th class="table_color">ID</th>
											<th class="table_color">开始号码</th>
											<th class="table_color">结束号码</th>
											<th class="table_color">行程单规则</th>
											<th class="table_color">号码</th>
											<th class="table_color">OFFICE</th>
											<th class="table_color">填开单位</th>
											<th class="table_color">领单单位</th>
											<th class="table_color">创建人</th>
											<!--<th class="table_color">备用字段1</th>
											<th class="table_color">备用字段2</th>
											<th class="table_color">备用字段3</th>
											--><th class="table_color">创建时间</th>
											<th class="table_color">状态</th>


										</tr>

										<ww:iterator value="listXcdnoinfo">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<td class="table_color"><ww:property value="id" /></td>
												<td class="table_color"><ww:property value="sno" /></td>
												<td class="table_color"><ww:property value="endno" /></td>
												<td class="table_color"><ww:property value="sno" />--<ww:property value="endno" /></td>
												<td class="table_color"><ww:property value="xcdinfo" /></td>
												<td class="table_color"><ww:property value="officecode" /></td>
												<td class="table_color"><ww:property
													value="companyname" /></td>
												<td class="table_color"><ww:property value="getangname(agentid)" /></td>
												<td class="table_color"><ww:property value="getloginnamebyid(userid)" /></td>
												<!--<td class="table_color"><ww:property value="param1" /></td>
												<td class="table_color"><ww:property value="param2" /></td>
												<td class="table_color"><ww:property value="param3" /></td>
												--><td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<td class="table_color" <ww:if test="state==2">style="color: red"</ww:if>  >
												<ww:if test="state==1">未使用</ww:if>
												<ww:if test="state==2">已使用</ww:if>
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
		window.location="xcdnoinfo!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="xcdnoinfo!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="xcdnoinfo!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="xcdnoinfo!batch.action?opt=1";
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
						
						document.form1.action="xcdnoinfo!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="xcdnoinfo!toedit.action?id="+uvalue;
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
						
						document.form1.action="xcdnoinfo!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="xcdnoinfo!tocheck.action?id="+uvalue;
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





