<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
	/**
	 * 版权所有, 允风文化
	 * Author: 允风文化 项目开发组
	 * copyright: 2012
	 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看会员</title>

<style type="text/css">
<!--
.STYLE2 {
	font-size: 12
}
-->
</style>
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
</head>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;查看会员</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form
			action="customeruser!<ww:if test="customeruser.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>"
			name="form1" method="POST"
			onSubmit="return Validator.Validate(this,3)">
			<input type="hidden" value="<ww:property value="customercredit.refid" />" name="refid" />
		<table width="99%" border="0" cellpadding="0" cellspacing="0"  style=" border-collapse:collapse; margin: 0 auto;">
			<tr>
				<td height="100%">
				<table width="100%" cellpadding="0" cellspacing="0">
					<tr height="20">
						<td height="28" style=" width: 15%"  align="right"></td>
						<td height="28" align="right" style="width:35%"></td>
						<td height="28"  align="right" style=" width: 15%"></td>
						<td height="28" align="right" style="width:35%"></td>

					</tr>

					<!--<tr>
						<td height="28" align="right" class="table_color colortrin"><span>用户卡号：</span></td>
						<td class="table_color_l"><ww:property value="customeruser.cardnumber"/>
							</td>
						<td height="28" align="right" class="table_color colortrin"><span>用户卡密码：</span></td>
						<td class="table_color_l"><ww:property value="customeruser.cardpassword"/></td>
					</tr>



					--><tr>


						<td height="28" align="right" class="table_color colortrin"><span>登录名：</span></td>
						<td class="table_color_l"><ww:property value="customeruser.loginname"/></td>
						<td height="28" align="right" class="table_color colortrin"><span>所属单位/加盟商：</span></td>
						<td class="table_color_l"><ww:property value="getAgentNameById(customeruser.agentid)" /></td>
					</tr>



					<tr>


						<td height="28" align="right" class="table_color colortrin"><span>姓名：</span></td>
						<td class="table_color_l"><ww:property value="customeruser.membername"/></td>
						<td height="28" align="right" class="table_color colortrin"><span>性别：</span></td>
						<td class="table_color_l"><ww:property value="customeruser.membersex"/>
						
				</td>
					</tr>



					<tr>


						<td height="28" align="right" class="table_color colortrin"><span>电子邮箱：</span></td>
						<td class="table_color_l"><ww:property value="customeruser.memberemail"/></td>
						<td height="28" align="right" class="table_color colortrin"><span>座机号码：</span></td>
						<td class="table_color_l"><ww:property value="customeruser.membermobile"/></td>

					</tr>

				

					<tr>
						<td height="28" align="right" class="table_color colortrin"><span>手机号：</span></td>
						<td class="table_color_l"><ww:property value="customeruser.mobile"/></td>

						<td height="28" align="right" class="table_color colortrin"><span>状态：</span></td>
						<td class="table_color_l"><ww:if test="customeruser.state==1">正常</ww:if><ww:else>禁用</ww:else></td>

					<!--<ww:if test="customeruser.membertype==1">B2C会员</ww:if>
					<ww:if test="customeruser.membertype==2">员工</ww:if>
					<ww:if test="customeruser.membertype==3">同行会员</ww:if>							
				</td>
					-->
					</tr>
					
					
					
					
					<tr>
						<td colspan="5" >
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="50" align="right" valign="bottom">
										<div align="right"><a href="#" onclick="toadd()"><input
											type="button" value="新增" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red" /></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red" /></a>
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

											<th class="table_color">证件编号</th>
											<th class="table_color">证件类型</th>
											<th class="table_color">证件号</th>
											<th class="table_color">类别</th>
										</tr>

										<ww:iterator value="listCustomercredit">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<td class="table_color"><ww:property value="id" /></td>
												<td class="table_color">
												<ww:if test="credittypeid==1">身份证</ww:if>
												<ww:if test="credittypeid==2">驾驶证</ww:if>
												<ww:if test="credittypeid==3">护照</ww:if> 
												<ww:if test="credittypeid==4">港澳通行证</ww:if> 
												<ww:if test="credittypeid==5">台湾通行证</ww:if>
												<ww:if test="credittypeid==6">台胞证</ww:if>
												<ww:if test="credittypeid==7">回乡证</ww:if> 
												<ww:if test="credittypeid==8">其它</ww:if> 
												
													</td>
												<td class="table_color"><ww:property
													value="creditnumber" /></td>
												<td class="table_color"><ww:if test="type==1">常用旅客</ww:if>
												<ww:if test="type==0">会员</ww:if></td>
											</tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
							</tr>
					
					
		
					<tr class="font-blue-xi">
						<td height="46" scrolling="no" colspan="4" align="center">
						
						
							
							
							<input type="button"
							class="button_d font-bai"
							onclick="window.location.href='customeruser.action?<ww:property value="url"/>';"
							name="Submit2" value=" 返回 " /></td>
					</tr>
					<tr>
						<td height="17">&nbsp;</td>
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

<script language="JavaScript">
	function toadd(){
		window.location="customercredit!toadd.action?refid=<ww:property value="customercredit.refid"/>&<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="customercredit!delete.action?refid=<ww:property value="customercredit.refid"/>&id="+document.form1.selectid.value;
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
								document.form1.action="customercredit!delete.action?refid=<ww:property value="customercredit.refid"/>&id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="customercredit!batch.action?opt=1";
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
						
						document.form1.action="customercredit!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customercredit!toedit.action?id="+uvalue;
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
						
						document.form1.action="customercredit!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="customercredit!tocheck.action?id="+uvalue;
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
					window.location.href="customercredit!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="customercredit!toedit.action?id="+selectId;
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
						document.form1.action="customercredit!delete.action?id="+selectId;
						document.form1.submit();					
						}
					}});					
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

</html>


