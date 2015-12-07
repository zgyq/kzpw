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
<title>留点设置类型列表</title>
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;留点设置类型列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="settlementtype.action">

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
								<td><!--    
           <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="120" height="20" align="right">名称：</td>    <td><span style="HEIGHT: 71px">
                  <input id="startnum2"   style="WIDTH: 181px" name="startnum2" />
                </span></td>
                
                <td width="30%" rowspan="3"><div align="left">
                  <input type="button" class="button" value="查询"/>
                </div></td>
              </tr>
              
             </table>
        --></td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="37" align="center">
										<div align="right">
										
										<a href="#" onclick="toadd()"><input
											type="button" value="新增" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red"></a>
											&nbsp;&nbsp;&nbsp;
									
										
											</div>
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
												type="checkbox" name="all1" value="1" onclick="selectall1()" disabled="disabled" />全选</th>

											<th class="table_color">ID</th>
											<th class="table_color">类型名称</th>
											<th class="table_color">类型</th>
											<!--<th class="table_color">创建人</th>
											
											<th class="table_color">创建时间</th>-->
											<th class="table_color">明细</th>

										</tr>

										<ww:iterator value="listSettlementtype">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<td class="table_color"><ww:property value="id" /></td>
												<td class="table_color"><ww:property value="typename" /></td>
												<td class="table_color"><ww:if test="liudianid==1">按返点</ww:if><ww:if test="liudianid==2">按利润</ww:if></td>
												<!--<td class="table_color"><ww:property value="getusername(createuser)" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>-->

												<td class="table_color">
												<table width="80%" cellspacing="0" cellpadding="0" border="1"
														class="table_color">
														<tr class="tbody_color" style="font-weight: bold">
															<td width="20%" align="center">序号</td>
															<td width="20%" align="center">大于</td>
															<td width="20%" align="center">小于</td>
															<td width="20%" align="center">暗扣</td>
															
														</tr>
														<ww:iterator value="GetListRecordbyID(id)" status="recstatus">
													<tr>	
														<td width="20%"><ww:property
															value="#recstatus.index+1" />
														<input type="hidden"
															name="tempid" style="width: 100px"
															value="<ww:property value="id" />" />
														</td>
														
														<td width="20%"><ww:property value="formatMoney(fandianstart)" /><ww:if test="liudianid==1">%</ww:if><ww:if test="liudianid==2">元</ww:if></td>
														<td width="20%"><ww:property value="formatMoney(fandianend)" /><ww:if test="liudianid==1">%</ww:if><ww:if test="liudianid==2">元</ww:if></td>
														<td width="20%"><ww:property value="formatMoney(liudian)" /><ww:if test="liudianid==1">%</ww:if><ww:if test="liudianid==2">元</ww:if></td>
														
													</tr>
												</ww:iterator>
												</table>
												
												
												</td>
											</tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center"><ww:property
									value="pagination" />
								<input type="hidden" name="s_agentid" value="<ww:property value="s_agentid" />"  /> 
								</td>
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
		window.location="settlementtype!toadd.action?<ww:property value="url"/>"+"&s_agentid=<ww:property value="s_agentid" />";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？请谨慎操作,该留点类型可能已经匹配了其他加盟商,删除后将无法恢复!!!');
						if(temp==true){
						
							document.form1.action="settlementtype!delete.action?id="+document.form1.selectid.value;
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
					      	var temp = confirm('确认删除吗？请谨慎操作,该留点类型可能已经匹配了其他加盟商,删除后将无法恢复!!!');
							if(temp==true){
								document.form1.action="settlementtype!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？请谨慎操作,该留点类型可能已经匹配了其他加盟商,删除后将无法恢复!!!');
					      	if(temp==true){
					      		document.form1.action="settlementtype!batch.action?opt=1";
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
						var temp = confirm('确认修改吗？请谨慎操作,该留点类型可能已经匹配了其他加盟商,修改后将无法恢复!!!');
						if(temp==true){
						
						document.form1.action="settlementtype!toedit.action?id="+document.form1.selectid.value+"&s_agentid=<ww:property value="s_agentid" />";
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
					      var temp = confirm('确认修改吗？请谨慎操作,该留点类型可能已经匹配了其他加盟商,修改后将无法恢复!!!');
							if(temp==true){
					      		document.form1.action="settlementtype!toedit.action?id="+uvalue+"&s_agentid=<ww:property value="s_agentid" />";
								document.form1.submit();
								}
								return;
					      }else if (len>1){
					      	var temp = confirm('只能选择一项进行操作？');
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
	
 function viewItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="settlementtype!toview.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="settlementtype!toview.action?id="+uvalue;
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





