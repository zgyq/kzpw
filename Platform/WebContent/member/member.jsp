<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script>
Ext.onReady(function(){

	 var selectId ="";

	 var menu = new Ext.menu.Menu({
        id: 'mainMenu',
		width:'160px',
        style: {
            overflow: 'visible'     // For the Combo popup
        },
        items: [		     
		    {
                id:"new",
				text: '新建',
				icon:"images/menu/new.gif",
				handler : function(item){
					window.location.href="customeruser!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="customeruser!toedit.action?id="+selectId;
						document.form1.submit();
				}
            },
			{
                id:"delete",
				text:"删除",
				icon:"images/menu/delete.gif",
				handler : function(item){
					Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						document.form1.action="customeruser!delete.action?id="+selectId;
						document.form1.submit();
					
						}
					}});
					
				}
            },
			{
                id:"chakan",
				text:"详细信息",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="customeruser!tochakan.action?id="+selectId;
						document.form1.submit();
					
				}
            },
			{
                id:"lvke",
				text:"查看常用旅客",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="customerpassenger!toCustomerpassbaseId.action?c_id="+selectId;
						document.form1.submit();
					
				}
            }
           
			
			
		]

		});



	Ext.get('menutable').on('contextmenu',function(e){
		
		if(e.target.parentNode.id)
		{
			e.preventDefault();
			selectId = e.target.parentNode.id;
			menu.showAt(e.getPoint());
		}
	});

});
</script>
<script>
function checkpassenger(){
			var length=document.form1.selectid.length;			
			//唯一项
			if(length== undefined){			
				if(document.form1.selectid.checked ==true)
				{						
						document.form1.action="customerpassenger!toCustomerpassbaseId.action?c_id="+document.form1.selectid.value;
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
					      		document.form1.action="customerpassenger!toCustomerpassbaseId.action?c_id="+uvalue;
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

</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse">&nbsp;&nbsp;&nbsp;会员列表</b></td>
	</tr>
	<tr>
		<td valign="top">




		<form name="form1" method="post" action="customeruser.action">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center"margin-bottom:4px;">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top">

						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td>
           
								<table width="750" border="0" align="center" cellpadding="0"
									cellspacing="0" style="font-size: 12px;">

									<tr>
										<td  align="right">会员账号：</td>
										<td><input type="text" name="customeruser.loginname"
											value="<ww:property value="loginname"/>" /></td>
										<td  height="30" align="right">会员姓名：</td>
										<td width=""><span style="HEIGHT: 71px"> <input
											id="startnum2"  name="s_name"
											value="<ww:property value="s_name"/>" /></span></td>
										<td height="40" align="right">手机号：</td>
										<td width=""><span style="HEIGHT: 71px"><input
											id="startnum2"  name="s_shenfz"
											value="<ww:property value="s_shenfz"/>" /></span></td></tr>
										<tr>	<td  align="right">创建人：</td>
									
										<td><input type="text" name="customeruser.createuser"
											value="<ww:property value="createuser"/>" /></td>
										
										<td style="text-align: right">创建时间:</td>
										<td><input type="text" name="s_begintime"
											onfocus="WdatePicker(WdatePicker({skin:'whyGreen'}))"
											style="width: 70px"
											value="<ww:property value="s_begintime"/>" />- <input
											type="text" name="s_endtime"
											onfocus="WdatePicker(WdatePicker({skin:'whyGreen'}))"
											style="width: 70px" value="<ww:property value="s_endtime"/>" />
										</td>

											<td></td>
										<!--
    <td width="134" rowspan="2" align="center"><input type="button" style="background:url(images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-weight:bold;"  value="查&nbsp;&nbsp;询" onclick="searchOne()"/></td>
  -->
									</tr>

									<tr class="font-blue-xi">
										<td height="10" colspan="8" align="right"></td>
									</tr>
									<tr class="font-blue-xi">
										<td height="28" colspan="5" align="center"><input
											type="submit" class="button_d font-white"
											value="查&nbsp;&nbsp;询"/></td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td>
								<table width="100%" height="40" border="0" cellspacing="0"
									cellpadding="0" class="lj"
									style="font-size: 12px; font-weight: bold; line-height: 25px;">
									<tr>
										<td width="100%" align="center">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td height="27" align="center">
												<div align="right"><a href="#" onclick="toadd()"><input
													type="button" value="新增" class="button_h font-red" /></a>
												&nbsp;&nbsp;&nbsp; <a href="#" onclick="chakanItem()"> <input
													type="button" value="详细信息" class="button_h font-red" /> </a>
												&nbsp;&nbsp;&nbsp; <!-- <a href="#" onclick="chakanCredit()">
												<input type="button" value="查看证件" class="button_h font-red" />
												</a> &nbsp;&nbsp;&nbsp; -->
												 <a href="#" onclick="checkpassenger()">
												  <input type="button" value="常用旅客" class="button_h font-red" />
												 </a>
												&nbsp;&nbsp;&nbsp; <!--<a href="#" onclick="chakanAirCard()">
												<input type="button" value="查看里程卡" class="button_h font-red" />
												</a> &nbsp;&nbsp;&nbsp;   <a href="#" onclick="chakanTel()"> <input
													type="button" value="联系电话" class="button_h font-red" />
												</a> &nbsp;&nbsp;&nbsp; --><a href="#"
													onclick="updateItem()"> <input type="button" value="修改"
													class="button_h font-red" /> </a> &nbsp;&nbsp;&nbsp; <input
													type="button" onclick="deleteItem()" value="删除"
													class="button_h font-red" /> <!--  <a href="#" onclick="deleteItem()">
												<input type="button" value="删除" class="button_h font-red" />
												</a> &nbsp;&nbsp;&nbsp;--> <!--<a href="#" onclick="checkItem()"> <input
													type="button" value="禁用" class="button_h font-red" /> </a>
												&nbsp;&nbsp;&nbsp; --><!--<a href="#" onclick="fenpei()"> <input
													type="button" value="分配角色" class="button_h font-red" /> </a>
													
													--></div>
												</td>
											</tr>
										</table>
										</td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td valign="top">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="100%">


								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">

											<th width="54" height="25" class="table_color"><input
												type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
											<!--
               	     
                  <th class="table_color">
                  	会员来源</th>
                  <th class="table_color">
                  	所属代理商</th>
                  -->
											<!--<th class="table_color">
                  	会员ID</th>
                  -->
											<th class="table_color">登录名</th>
											<th class="table_color">手机</th>
											<th class="table_color">姓名</th>
											<th class="table_color">电子邮箱</th>
											<th class="table_color">所属单位/加盟商</th>
											<th class="table_color" style="width: 80px;">积分</th>
											<th class="table_color">创建人</th>
											<th class="table_color">创建时间</th>
											
											<!--<th class="table_color">会员性别</th>
											-->

											<!--<th class="table_color">类型</th>
											-->
											<!--<th class="table_color">身份证号码</th>
											-->
											<!--<th class="table_color">所在城市</th>
											-->
											<th class="table_color">状态</th>
										</tr>

										<ww:iterator value="listCustomeruser">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
												onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>
												<!--<td class="table_color"><ww:property value="id"/></td>		
				<td class="table_color"><ww:property value="id"/></td>
				-->
												<!--<td class="table_color"><ww:property value="id"/></td>
				-->
												<!--<td class="table_color"><ww:property value="membersex" />

												</td>
												-->
												<td class="table_color"><ww:property value="loginname" /></td>
												<td class="table_color"><ww:property value="mobile" /></td>
												<td class="table_color"><ww:property value="membername" /></td>
												<td class="table_color"
													style="width: 190px; text-align: left; padding-left: 8px"><ww:property
													value="memberemail" /></td>
												<td class="table_color"
													style="width: 210px; text-align: left; padding-left: 8px"><ww:property
													value="getAgentNameById(agentid)" /></td>
												<!--<td class="table_color"><ww:if test="type==1">运营商</ww:if>
												<ww:if test="type==2">供应商</ww:if> <ww:if test="type==3">分销商</ww:if>

												</td>
												-->
												<!--<td class="table_color"><ww:property value="id" /></td>
												-->
												<!--<td class="table_color"><ww:property value="localcity" /></td>
												-->
												<td class="table_color">
												<ww:property value="converNull(totalscore,0)"/>&nbsp;
												<a href='<%=request.getContextPath() %>/customerintegralrecord.action?refuid=<ww:property value="id"/>'>查看</a>
												</td>
												<td class="table_color"><ww:property value="createuser"/></td>
												<td class="table_color"><ww:property value="formatTimestamptoMinute(createtime)"/></td>
												
												<td class="table_color"><ww:if test="state==1">正常</ww:if><ww:else>禁用</ww:else>

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
								<!--
            <td height="43" align="center"> 共&nbsp;19&nbsp;条记录&nbsp;当前1/1页&nbsp; <a href="#" class="font_grey_001" onclick='javascript:go(1);'>首页</a>&nbsp;<span class="font_grey_001"> <strong>1</strong>  <a href="#" class="font_grey_001" onclick='javascript:go(1);'>尾页</a></span><script>function go(pageno){document.form1.action="member.action?pageinfo.pagenum="+pageno;document.form1.submit();}</script> </td>
          -->
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
	
		window.location="customeruser!toadd.action";
	} 
  
  function deleteItem(){
			var length=document.form1.selectid.length;			
			//唯一项
			if(length== undefined){
				if(document.form1.selectid.checked ==true)
				{
					Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗ddd？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						document.form1.action="customeruser!delete.action?id="+document.form1.selectid.value;
						document.form1.submit();					
						}
					}});
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
					   Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗ddd？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						document.form1.action="customeruser!delete.action?id="+uvalue;
						document.form1.submit();
					
						}
					}});
					return;
					      }else if (len>1){
					      Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗ddd？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						if(btn=='yes')
						{
						document.form1.action="customeruser!batch.action?opt=1";
								document.form1.submit();					
						}
					}});					      	
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
						
						document.form1.action="customeruser!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customeruser!toedit.action?id="+uvalue;
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
  function chakanCredit(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!toCustomercreditList.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customeruser!toCustomercreditList.action?id="+uvalue;
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
  
  function chakanAirCard(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!toCustomeraircardList.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customeruser!toCustomeraircardList.action?id="+uvalue;
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
  
  function chakanTel(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!toTelephoneList.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customeruser!toTelephoneList.action?id="+uvalue;
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
  
  function chakanItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!tochakan.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customeruser!tochakan.action?id="+uvalue;
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
						
						document.form1.action="customeruser!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customeruser!tocheck.action?id="+uvalue;
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
 function fenpei(){

			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="customeruser!tofenpei.action?memberid="+document.form1.selectid.value;
						document.form1.submit();
						
						return;
				}else{
				 	alert("你未选择任何内容");
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
					      
					      		document.form1.action="customeruser!tofenpei.action?memberid="+uvalue;
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





