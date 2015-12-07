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
<title>租车订单列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
	<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery1.3.2.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/util.js"></script>
<script type="text/javascript" src="../js/validator.js"></script>
<!--<script>
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
					window.location.href="carorder!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="carorder!toedit.action?id="+selectId;
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
						document.form1.action="carorder!delete.action?id="+selectId;
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
						document.form1.action="carorder!tocheck.action?id="+selectId;
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
--></head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;租车订单列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="cars!car_new.action">

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
           <table width="760" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
                <td width="120" height="20" align="right">取车城市：</td>    <td><span style="HEIGHT: 71px">
                					 <select id="C_ScityId" name="C_ScityId" style="WIDTH: 187px">
									<option value="0" <ww:if test="C_ScityId==0">selected</ww:if> >所有的城市</option>
									<ww:iterator value="listCities">
										<option value="<ww:property value="id"/>" <ww:if test="C_ScityId==id">selected</ww:if> ><ww:property value="name" /></option>
									</ww:iterator>
								</select>
                </span></td>
                <td width="120" height="20" align="right">还车城市：</td>    <td><span style="HEIGHT: 71px">
                  	 <select id="C_EcityId" name="C_EcityId" style="WIDTH: 187px">
									<option value="0" <ww:if test="C_EcityId==0">selected</ww:if> >所有的城市</option>
									<ww:iterator value="listCities">
										<option value="<ww:property value="id"/>" <ww:if test="C_EcityId==id">selected</ww:if> ><ww:property value="name" /></option>
									</ww:iterator>
								</select>
                </span></td>
               
              </tr>
              
              <tr>
                <td width="120" height="20" align="right">汽车名称：</td>    <td><span style="HEIGHT: 71px">
                  <input id="startnum2"   style="WIDTH: 181px" name="s_name" value="<ww:property value="s_name"/>" />
                </span></td>
                <td width="120" height="20" align="right">订单编号：</td>    <td><span style="HEIGHT: 71px">
                  <input    style="WIDTH: 181px" name="ordercode" value="<ww:property value="ordercode"/>" />
                </span></td>
               
              </tr>
              <tr>
                <td width="120" height="20" align="right">订单属性：</td>    <td><span style="HEIGHT: 71px">
                <select name="s_type">
               		 <option value="0" <ww:if test="s_type==0">selected</ww:if>  >全部订单</option>
               		 <option value="1" <ww:if test="s_type==1">selected</ww:if> >后台订单</option>
                	 <option value="2" <ww:if test="s_type==2">selected</ww:if> >前台订单</option>
                     
                </select>
                </span></td>
                <td width="120" height="20" align="right">预订人姓名：</td>    <td><span style="HEIGHT: 71px">
                  <input    style="WIDTH: 181px" name="c_username" value="<ww:property value="c_username"/>" />
                </span></td>
               
              </tr>
              <tr>
                <td width="120" height="20" align="right">预订起始时间：</td>    <td><span style="HEIGHT: 71px">
                 <input id="h_prestarttime" style="WIDTH: 181px" name="h_prestarttime"
									value="<ww:property value="h_prestarttime"/>"
									onfocus="WdatePicker({skin:'whyGreen', onpicked:function(){h_preendtime.focus();}})" />
                </span></td>
                <td width="120" height="20" align="right">预订结束时间：</td>    <td><span style="HEIGHT: 71px">
                  <input id="h_preendtime" dataType="Compare" operator="LessThanDate" msg="离店日期不能小于入住日期" style="WIDTH: 181px" name="h_preendtime"
									value="<ww:property value="h_preendtime"/>"
									onfocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'h_prestarttime\',{d:1}) || \'%y-%M-#{%d+1 }\'}',maxDate:'%y-#{%M+1}-%d'})" />
                </span></td>
               
              </tr>
              
              <ww:if test="longtype==0">
							<tr>
								
								<td width="120" height="20" align="right">加盟商：</td>
								<td><select id="h_ho" name="h_angent">
								
									<option value="0" <ww:if test="h_angent==0">selected</ww:if>>所有加盟商</option>
									
									<ww:iterator value="listCustomeragent">
									<option value="<ww:property value="id" />" <ww:if test="h_angent==id">selected</ww:if> ><ww:property value="agentcompanyname" /></option>
									 </ww:iterator>

								</select></td>


							</tr>
							</ww:if>
							
             </table>
              <td width="30%" rowspan="3"><div align="left">
                  <input type="submit" class="button_d font-bai" value="查询"/>
                </div></td>
        </td>
							</tr>
							<!--<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="27" align="center">
										<div align="right">
										<a href="#" onclick="toinfo()"><input
											type="button" value="查看详情" class="button_h font-red"></a>
											
											
											<a href="#" onclick="toadd()"><input
											type="button" value="新增" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input
											type="button" value="审核" class="button_h font-red"></a>
											
											</div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
						--></table>
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

											
											
											<th class="table_color">加盟商</th>
											<th class="table_color">车型</th>
											<th class="table_color">大小</th>
											<th class="table_color">取车类型</th>
											<th class="table_color">品牌</th>
											<th class="table_color">用车天数</th>
											<th class="table_color">联系人</th>
											<th class="table_color">联系手机</th>
											<th class="table_color">用车地址</th>
											<th class="table_color">用车时间</th>
											<th class="table_color">备注</th>
											
										</tr>

										<ww:iterator value="listCarorder">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>
												<td class="table_color"><ww:property value="getAngetNameByUserId(memberid)" /></td>
												<td class="table_color"><ww:property value="code" /></td>
												<td class="table_color"><ww:property value="carcode" /></td>
												<td class="table_color"><ww:property value="property" /></td>
												<td class="table_color"><ww:property value="carname" /></td>
												<td class="table_color"><ww:property value="manyday" /></td>
												
												<td class="table_color"><ww:property value="linkname" /></td>
												<td class="table_color"><ww:property value="linktell" /></td>
												<td class="table_color"><ww:property value="linkmail" /></td>
												<td class="table_color"><ww:property value="sdate" /></td>
												<td class="table_color"><ww:property value="specreq" /></td>
												
												
											<!--<td class="table_color">
											<ww:if test="state==1"><a href="javascript:checkorder('<ww:property value="id" />');">取消</a>&nbsp;|&nbsp;<a href="carorder!check.action?orderstate=2&carorder.id=<ww:property value="id" />">已确认</a></ww:if>
											<ww:if test="state==2"><a href="carorder!check.action?orderstate=3&carorder.id=<ww:property value="id" />">已取车</a></ww:if>
											<ww:if test="state==3"><a href="carorder!check.action?orderstate=4&carorder.id=<ww:property value="id" />">已还车</a></ww:if>
											
											</td>
											--></tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center"><ww:property value="getPagination('\"cars!car_new.action?pageinfo.pagenum=\"+pageno+\"\"')"/></td>
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
	function checkorder(id){
	
						var temp = confirm('确认取消吗？');
						if(temp==true){
						
							window.location="carorder!check.action?orderstate=5&carorder.id="+id;
							
						}
	}
	
	
	
	function toadd(){
		window.location="carorder!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="carorder!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="carorder!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="carorder!batch.action?opt=1";
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
						
						document.form1.action="carorder!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="carorder!toedit.action?id="+uvalue;
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
						
						document.form1.action="carorder!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="carorder!tocheck.action?id="+uvalue;
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





