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
<title>团队申请表列表</title>
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
				id:"edit",
				text:"查看",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="teamapply!tokan.action?id="+selectId;
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;团队申请单列表</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="teamapply.action">

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
                <td width="120" height="20" align="right">名称：</td>    <td><span style="HEIGHT: 71px">
                  <input id="startnum2"   style="WIDTH: 181px" name="startnum2" />
                </span></td>
                
                <td width="30%" rowspan="3"><div align="left">
                  <input type="button" class="button_d font-bai" value="查询"/>
                </div></td>
              </tr>
              
             </table>
        </td>
							</tr>
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="47" align="center">
										<div align="right">&nbsp;&nbsp;&nbsp;<a href="#"
											onclick="updateItem()"><input type="button" value="查看"
											class="button_h font-red"></a></div>
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
											-->
											<th class="table_color">所属加盟商</th>
											<th class="table_color">航班类型</th>
											<!--<th class="table_color">乘客类型</th>
											--><th class="table_color">出发城市</th>
											<th class="table_color">到达城市</th>
											<!--<th class="table_color">乘机人数</th>
											--><th class="table_color">成人/儿童/婴儿</th>
											<th class="table_color">航空公司</th>
											<th class="table_color">航班号</th>
											<th class="table_color">出发时间</th>
											<!--<th class="table_color">创建者</th>
											<th class="table_color">创建时间</th>
											<th class="table_color">状态</th>
											<th class="table_color">状态</th>
											<th class="table_color">备注</th>-->
											<th class="table_color">报价</th>
											<th class="table_color">操作</th>

										</tr>

										<ww:iterator value="listTeamapply" status="aa">
											
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color color_b3"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<!--<td class="table_color color_b3"><ww:property value="id" /></td>-->
												<td class="table_color color_b3"><ww:property
													value="getAgentname22(typeid)" /></td>
												<td class="table_color color_b3">
												<ww:if test="flighttype==1">单程</ww:if>
												<ww:if test="flighttype==2">往返</ww:if>
												</td>
												<!--<td class="table_color color_b3">
												<ww:if test="usertype==1">内宾</ww:if>
												<ww:if test="usertype==2">外宾</ww:if>
												</td>
												--><td class="table_color color_b3"><ww:property
													value="getAirnamebySZM(startcity)" /></td>
												<td class="table_color color_b3"><ww:property
													value="getAirnamebySZM(endcity)" /></td>
												<!--<td class="table_color color_b3"><ww:property
													value="numberpeople" /></td>
												--><td class="table_color color_b3">
												<ww:if test="chengren==null">0</ww:if><ww:else><ww:property value="chengren" /></ww:else>/
												<ww:if test="ertong==null">0</ww:if><ww:else><ww:property value="ertong" /></ww:else>/
												<ww:if test="yinger==null">0</ww:if><ww:else><ww:property value="yinger" /></ww:else>
											</td>
												<td class="table_color color_b3"><ww:property
													value="getAircomapnycodeByEZM(ca)" /></td>
												<td class="table_color color_b3"><ww:property
													value="flightnumber" /></td>
												<td class="table_color color_b3"><ww:property
													value="formatTimestamp2(starttime)" /></td>
												<!--<td class="table_color color_b3"><ww:property value="createuser" /></td>
												<td class="table_color color_b3"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<td class="table_color color_b3"><ww:property value="status" /></td>
												<td class="table_color color_b3"><ww:property value="getteamapplystatus(status)" /></td>
												<td class="table_color color_b3"><ww:property value="comment" /></td>-->

												<td class="table_color color_b3"><input type="text" name="" value="<ww:property value="getbaojia(id)" />"
													id="v<ww:property value="#aa.index" />" size="8" /></td>
												<td class="table_color color_b3"><input type="button" name=""
													id="t<ww:property value="#aa.index" />" size="8" value="提交" class="button108"
													onclick="baojia('<ww:property value="id" />','<ww:property value="typeid" />','<ww:property value="#aa.index" />');" /></td>

											</tr>
											
										</ww:iterator>

									</tbody>
								</table>
								</td>
							</tr>
							<tr>
								<td height="43" align="center">
								<ww:property value="getPagination('\"teamapply!toall.action?pageinfo.pagenum=\"+pageno')"/>
								
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
<form name="form2" method="post" id="form2" action="supteam!addsup.action">
<table>
<tr>
<td>
<input type="hidden" name="teamid" id="teamid" value="" />
<input type="hidden" name="distributorid" id="distributorid" value="" />
<input type="hidden" name="offer" id="offer" value="" />
</td>
</tr>
</table>
</form>
</div>
</body>
</html>


<script language="JavaScript">
function baojia(id,typeid,index){
var offer = document.getElementById("v"+index).value;
//alert("ID=="+id+"==typrid=="+typeid+"===index=="+index+"==baojia=="+offer);
document.getElementById("teamid").value=id;
document.getElementById("distributorid").value=typeid;
document.getElementById("offer").value=offer;
document.form2.submit();
	
	}

	function toadd(){
		window.location="teamapply!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="teamapply!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="teamapply!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="teamapply!batch.action?opt=1";
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
						
						document.form1.action="teamapply!tokan.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="teamapply!tokan.action?id="+uvalue;
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
						
						document.form1.action="teamapply!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="teamapply!tocheck.action?id="+uvalue;
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





