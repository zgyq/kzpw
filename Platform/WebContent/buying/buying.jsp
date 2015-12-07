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
<title>团购信息列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
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
					window.location.href="buying!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="buying!toedit.action?id="+selectId;
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
						document.form1.action="buying!delete.action?id="+selectId;
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
						document.form1.action="buying!tocheck.action?id="+selectId;
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
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;团购信息列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="buying.action">

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
                  <input type="submit" class="button_d font-bai" value="查询"/>
                </div></td>
              </tr>
              
             </table>
        --></td>
							</tr>
							<tr>
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

											<!--<th class="table_color">ID</th>
											<th class="table_color">外部id</th>
											<th class="table_color">供应商ID</th>
											<th class="table_color">省ID</th>
											<th class="table_color">区ID</th>
											-->
											<th class="table_color">城市</th>
											<th class="table_color">供应商</th>
											<th class="table_color">名称</th>
											<th class="table_color">门市价</th>
											<th class="table_color">团购价</th>
											<!--<th class="table_color">详细信息</th>
											<th class="table_color">备注</th>
											--><th class="table_color">预约天数</th>
											<th class="table_color">地址</th>
											<th class="table_color">开始日期</th>
											<th class="table_color">结束日期</th>
											<th class="table_color">时间范围</th>
											<!--
											<th class="table_color">使用规则</th>
											-->
											<th class="table_color">起订数</th>
											<!--
											<th class="table_color">特价(0无,1有)</th>
											<th class="table_color">特价产品信息</th>
											<th class="table_color">特价产品图片</th>
											<th class="table_color">特价产品图片</th>
											<th class="table_color">产品介绍</th>
											<th class="table_color">温馨提示</th>
											<th class="table_color">预订说明</th>
											<th class="table_color">备用字段1</th>
											<th class="table_color">备用字段2</th>
											<th class="table_color">备用字段3</th>
											-->
											<th class="table_color">创建时间</th>
											<!--
											<th class="table_color">会员</th>
											-->
											<th class="table_color">类型</th>
											<th class="table_color">状态</th>
											<th class="table_color">操作</th>

										</tr>

										<ww:iterator value="listBuying">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<!--<td class="table_color"><ww:property value="id" /></td>
												<td class="table_color"><ww:property value="outid" /></td>
												<td class="table_color"><ww:property value="agentid" /></td>
												<td class="table_color"><ww:property value="pid" /></td>
												<td class="table_color"><ww:property value="regionid" /></td>
												-->
												<td class="table_color"><ww:property value="getSpotCityNameByStr(cityid)" /></td>
												<td class="table_color"><ww:property value="getangname(agentid)" /></td>
												<td class="table_color"><ww:property value="name" /></td>
												<td class="table_color"><ww:property
													value="marketprice" /></td>
												<td class="table_color"><ww:property value="shopprice" /></td>
												
												<!--
												<td class="table_color"><ww:property value="descinfo" /></td>
												<td class="table_color"><ww:property value="beizhu" /></td>
												--><td class="table_color"><ww:property value="tiqiandays" /></td>
												<td class="table_color"><ww:property value="address" /></td>
												<td class="table_color"><ww:property value="stime" /></td>
												<td class="table_color"><ww:property value="endtime" /></td>
												<td class="table_color"><ww:property value="stimeetime" /></td>
												<!--<td class="table_color"><ww:property value="guize" /></td>
												--><td class="table_color"><ww:property value="minnumber" /></td>
												<!--<td class="table_color"><ww:property value="tejia" /></td>
												<td class="table_color"><ww:property value="title1" /></td>
												<td class="table_color"><ww:property value="pic1" /></td>
												<td class="table_color"><ww:property value="pic2" /></td>
												<td class="table_color"><ww:property value="text1" /></td>
												<td class="table_color"><ww:property value="text2" /></td>
												<td class="table_color"><ww:property value="text3" /></td>
												<td class="table_color"><ww:property value="param1" /></td>
												<td class="table_color"><ww:property value="param2" /></td>
												<td class="table_color"><ww:property value="param3" /></td>
												--><td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<!--<td class="table_color"><ww:property value="memberid" /></td>
												--><td class="table_color">
												<ww:if test="type==1">餐饮</ww:if>
												<ww:if test="type==2">购物</ww:if>
												</td>
												<td class="table_color"><ww:if test="state==0">暂停销售</ww:if>
												<ww:if test="state==1">正常销售</ww:if></td>

											<td class="table_color">
												<ww:if test="state==0"><a href="buying!tocheck.action?id=<ww:property value="id" />">启动销售</a></ww:if>
												<ww:if test="state==1"><a href="buying!tocheck.action?id=<ww:property value="id" />">暂停销售</a></ww:if>|
												<a href="buyingimg.action?s_buyingid=<ww:property value="id" />">上传照片</a>
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
		window.location="buying!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="buying!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="buying!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="buying!batch.action?opt=1";
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
						
						document.form1.action="buying!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="buying!toedit.action?id="+uvalue;
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
						
						document.form1.action="buying!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="buying!tocheck.action?id="+uvalue;
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





