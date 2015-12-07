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
<title>东航销售明细导入列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="box-bottom bg"><b
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;东航销售比对</span></b></td>
	</tr>
	<tr>
		<td valign="top">


		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td>
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
					<td>
					<form name="form2" method="post" action="importmureport!compdate.action">
								<table width="760" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="100" height="20" align="right">比对时间 从：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="s_begindate" style="WIDTH: 150px" name="s_begindate"
											value="<ww:property value="s_begindate"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" /> </span></td>
										<td width="10" height="20" align="right">到：</td>
										<td><span style="HEIGHT: 71px"> <input
											id="s_enddate" style="WIDTH: 150px" name="s_enddate"
											value="<ww:property value="s_enddate"/>" onfocus="WdatePicker({skin:'whyGreen'})"
									class="Wdate" />  </span></td>

										<td width="30%" rowspan="3">
										<div align="left"><input type="submit"
											class="button_d font-bai" value="查询" />
											<input type="submit"
											class="button_d font-bai" value="查询" />
											<input type="submit"
											class="button_d font-bai" value="查询" />
											</div>
										</td>
									</tr>

								</table>
								</form>
					</td>
					</tr>
					<tr>
						<td height="306" valign="top">
						<form name="form1" method="post" action="importmureport.action">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="50%" valign="top">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th colspan="6" style="font-size: 14px;">东航Excel数据</th>
										</tr>
										<tr class="tbody_color">
											<th class="table_color">票号</th>
											<th class="table_color">PNR</th>
											<th class="table_color">航程</th>
											<th class="table_color">舱位</th>
											<th class="table_color">出票时间</th>
											<th class="table_color">比对状态</th>
										</tr>
										<ww:iterator value="listmus">
											<tr style="background-color: yellow;" id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
												
												<td class="table_color"><ww:property
													value="ticketnumber" /></td>
												<td class="table_color"><ww:property value="pnr" /></td>
												<td class="table_color"><ww:property value="voyage" /></td>
												<td class="table_color"><ww:property value="cabin" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(time)" /></td>
												<td class="table_color">对比完成</td>
											</tr>
										</ww:iterator>
										<ww:iterator value="listmue">
											<tr style="color: red;" id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
												
												<td class="table_color"><ww:property
													value="ticketnumber" /></td>
												<td class="table_color"><ww:property value="pnr" /></td>
												<td class="table_color"><ww:property value="voyage" /></td>
												<td class="table_color"><ww:property value="cabin" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(time)" /></td>
												<td class="table_color">问题数据</td>
											</tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
								<td width="50%" valign="top">
								<table id="menutable" width="99%" border="1" align="center"
									class="table_color">
									<tbody>
										<tr class="tbody_color">
											<th colspan="6" style="font-size: 14px;">业务系统报表数据</th>
										</tr>
										<tr class="tbody_color">
											<th class="table_color">票号</th>
											<th class="table_color">订单号</th>
											<th class="table_color">出票时间</th>
											<th class="table_color">比对状态</th>
										</tr>
										<ww:iterator value="listpasss">
											<tr style="background-color: yellow;" id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
												
												<td class="table_color"><ww:property
													value="ticketnum" /></td>
												<td class="table_color"><ww:property value="orderid" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(rttime)" /></td>
												<td class="table_color">对比完成</td>
											</tr>
										</ww:iterator>
										<ww:iterator value="listpasse">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">
												
												<td class="table_color"><ww:property
													value="ticketnum" /></td>
												<td class="table_color"><ww:property value="orderid" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(rttime)" /></td>
												<td class="table_color">问题数据</td>
											</tr>
										</ww:iterator>

									</tbody>
								</table>
								</td>
							</tr>
						</table>
						</form>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>


<script language="JavaScript">
	function toadd(){
		window.location="importmureport!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="importmureport!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="importmureport!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="importmureport!batch.action?opt=1";
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
						
						document.form1.action="importmureport!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="importmureport!toedit.action?id="+uvalue;
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
						
						document.form1.action="importmureport!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="importmureport!tocheck.action?id="+uvalue;
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





