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
<title>万里行申请表列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<!--  
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
					window.location.href="wanlixing!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="wanlixing!toedit.action?id="+selectId;
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
						document.form1.action="wanlixing!delete.action?id="+selectId;
						document.form1.submit();
					
						}
					}});
					
				}
            },
			'-',
			{
                id:"check",
				text:"审核",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="wanlixing!tocheck.action?id="+selectId;
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
-->
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;万里行申请表列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="wanlixing.action">

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
								<!--<table width="99%" border="0" cellspacing="0" cellpadding="0">
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
								--></td>
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

											
											<th class="table_color">性别</th>
											<th class="table_color">称谓</th>
											<th class="table_color">中文姓</th>
											<th class="table_color">中文名</th>
											<!--<th class="table_color">英文姓</th>
											<th class="table_color">英文名</th>
											-->
											<!--<th class="table_color">身份证号码</th>
											<th class="table_color">护照号码</th>
											<th class="table_color">军官证</th>
											<th class="table_color">回乡证</th>
											<th class="table_color">其他证件号码</th>
											--><th class="table_color">国籍</th>
											<!--<th class="table_color">出生日期</th>
											<th class="table_color">联络语言</th>
											<th class="table_color">密码</th>
											<th class="table_color">提示问题</th>
											<th class="table_color">问题答案</th>
											<th class="table_color">邮箱</th>
											<th class="table_color">邮寄类型</th>
											<th class="table_color">邮寄到国家</th>
											<th class="table_color">邮寄到省</th>
											<th class="table_color">邮政编码</th>
											<th class="table_color">市/县/自治州</th>
											<th class="table_color">邮寄地址</th>
											--><!--<th class="table_color">联系电话</th>
											<th class="table_color">传真</th>
											<th class="table_color">账单邮寄类型</th>
											-->
											<th class="table_color">联系手机</th>
											<th class="table_color">单位名称</th>
											<th class="table_color">阁下级别</th>
											<th class="table_color">行业性质</th>
											<!--<th class="table_color">创建时间</th>


										--></tr>

										<ww:iterator value="listWanlixing">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												
												<td class="table_color">
												<ww:if test="sex==1">男</ww:if><ww:if test="sex==2">女</ww:if>
												</td>
												<td class="table_color"><ww:property value="getchenghu(chenghu)" /></td>
												<td class="table_color"><ww:property value="zxing" /></td>
												<td class="table_color"><ww:property value="zming" /></td>
												<!--<td class="table_color"><ww:property value="yxing" /></td>
												<td class="table_color"><ww:property value="yming" /></td>
												-->
												<!--<td class="table_color"><ww:property value="number" /></td>
												<td class="table_color"><ww:property value="huzhao" /></td>
												<td class="table_color"><ww:property value="jun" /></td>
												<td class="table_color"><ww:property value="hui" /></td>
												<td class="table_color"><ww:property value="qita" /></td>
												-->
												<td class="table_color"><ww:property value="getguojianame(guoji)" /></td>
												<!--<td class="table_color"><ww:property value="chusheng" /></td>
												<td class="table_color">
												<ww:if test="yuyan==1">简体中文</ww:if><ww:if test="yuyan==2">英语</ww:if>
												</td>
												<td class="table_color"><ww:property value="password" /></td>
												<td class="table_color"><ww:property value="wenti" /></td>
												<td class="table_color"><ww:property value="daan" /></td>
												<td class="table_color"><ww:property value="postbox" /></td>
												<td class="table_color">
												<ww:if test="youtype==1">国内</ww:if><ww:if test="youtype==2">国际</ww:if>
												</td>
												<td class="table_color"><ww:property value="youjiguo" /></td>
												<td class="table_color"><ww:property value="youjisheng" /></td>
												<td class="table_color"><ww:property value="youbian" /></td>
												<td class="table_color"><ww:property value="shi" /></td>
												<td class="table_color"><ww:property value="address" /></td>-->
												<!--<td class="table_color"><ww:property value="dianhua" /></td>
												<td class="table_color"><ww:property value="fax" /></td>
												--><!--<td class="table_color">
												<ww:if test="duizhangtype==1">电子邮件</ww:if><ww:if test="duizhangtype==2">邮寄信件</ww:if>
												<ww:if test="duizhangtype==3">在线查询</ww:if>
											
													</td>
												-->
												<td class="table_color"><ww:property value="mobile" /></td>
												<td class="table_color"><ww:property value="copname" /></td>
												<td class="table_color"><ww:property value="getjibie(jibie)" /></td>
												<td class="table_color"><ww:property value="getxingzhi(xingzhi)" /></td>
												<!--<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>


											--></tr>
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
		window.location="wanlixing!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="wanlixing!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="wanlixing!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="wanlixing!batch.action?opt=1";
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
						
						document.form1.action="wanlixing!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="wanlixing!toedit.action?id="+uvalue;
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
						
						document.form1.action="wanlixing!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="wanlixing!tocheck.action?id="+uvalue;
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





