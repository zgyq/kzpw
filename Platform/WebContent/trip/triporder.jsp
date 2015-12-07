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
<title>线路订单列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
	
<script src="js/jquery1.3.2.js" type="text/javascript"></script>
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
				id:"edit",
				text:"查看",
				icon:"images/menu/edit.gif",
				handler : function(item){
				window.location.href="triporder!toedit.action?id="+selectId;
				return;
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;线路订单列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="triporder.action">

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
								<table width="760" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="120" height="20" align="right">订单号：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 181px" name="s_ordernum" value="<ww:property value="s_ordernum"/>" /> </span></td>
										<td>联系人姓名：</td>
										<td><input id="startnum2" style="WIDTH: 181px"
											name="s_contactmingzi" value="<ww:property value="s_contactmingzi"/>" /></td>
									</tr>
									<tr>
										<td width="120" height="20" align="right">出发日期：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="startnum2" style="WIDTH: 85px" onfocus="WdatePicker()"
											name="s_startdate" value="<ww:property value="s_startdate"/>" />
											-<input
											id="startnum2" style="WIDTH: 85px" onfocus="WdatePicker()"
											name="s_enddate" value="<ww:property value="s_enddate"/>" />
										</span></td>
										<td>预订日期：</td>
										<td><input id="startnum2" onfocus="WdatePicker()"
											style="WIDTH: 85px" name="s_bookdate"
											value="<ww:property value="s_bookdate"/>" />-
											<input id="startnum2" onfocus="WdatePicker()"
											style="WIDTH: 85px" name="s_bookenddate"
											value="<ww:property value="s_bookenddate"/>" /></td>
									</tr>
									<tr height="10px"><td></td></tr>
									<tr>
										<td ></td>
											<td></td>
											<td align="left"><input type="submit"
											class="button_d font-white" value="查询" /></td>
											<td></td>
									</tr>

								</table>
								</td>
							</tr>
							<tr>
								<td>
							
								</td>
							</tr>
							<tr height="10px"><td></td></tr>
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
												type="checkbox" name="all1" value="1" onclick="selectall1()" /><b>全选</b></th>
											<th class="table_color"><b>订单号</b></th>
											<th class="table_color"><b>订单类型</b></th>
											<th class="table_color"><b>线路名称</b></th>
											<th class="table_color"><b>人数</b></th>
											<th class="table_color"><b>总价</b></th>
											<th class="table_color"><b>联系人姓名</b></th>
											<th class="table_color"><b>联系人手机</b></th>
											<th class="table_color"><b>出发日期</b></th>
											<th class="table_color"><b>订单状态</b></th>
										</tr>
										<ww:iterator value="listTriporder">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>
												<td class="table_color"><a href="triporder!toedit.action?id=<ww:property value="id" />"><ww:property value="code" /></a></td>
												<td class="table_color"><ww:if test="language==1 || language==0">后台订单</ww:if><ww:if test="language==2">网站订单</ww:if></td>
												<td class="table_color"><ww:property value="SubString(getTriplineName(triplineid),5)" /></td>
												<td class="table_color"><ww:property value="pnum" /></td>
												<td class="table_color"><ww:property value="sump" /></td>
												<td class="table_color"><ww:property value="linkname" /></td>
												<td class="table_color"><ww:property value="linkmobile" /></td>
												
												<td class="table_color"><ww:property
													value="formatTimestampyyyyMMdd(statetime)" /></td>
												<td class="table_color"><ww:if test="state==2">完成</ww:if><ww:elseif test="state==3">取消</ww:elseif><ww:else>待确认</ww:else></td>
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
		window.location="triporder!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="triporder!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="triporder!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="triporder!batch.action?opt=1";
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
						window.location.href="triporder!toedit.action?id="+document.form1.selectid;
						
				}
			}
			
			if ( length == null || length==0 )
			{
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
								window.location.href="triporder!toedit.action?id="+selectId;
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
						
						document.form1.action="triporder!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="triporder!tocheck.action?id="+uvalue;
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

