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
<title>订单升舱表列表</title>
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
			class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;差价单</span></b></td>
	</tr>
	<tr>
		<td valign="top">
		<form name="form1" method="post" action="scang.action">

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
							<ww:if test="getLoginsessionagent().agenttype==1">
							<tr>
								<td>
								<table width="99%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="27" align="center">
										<div align="right">
										<a href="#" onclick="updateItem()"><input
											type="button" value="修改" class="button_h font-red"></a>
										&nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input
											type="button" value="删除" class="button_h font-red"></a>
										</div>
										</td>
									</tr>
								</table>
								</td>
							</tr>
							</ww:if>
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
											<!--
											<th class="table_color">关联乘机人表ID</th>
											-->
											<!--
											<th class="table_color">升前舱位</th>
											<th class="table_color">申请到舱位</th>
											-->
											<th class="table_color">订单号</th>
											<!--
											<th class="table_color">订单ID</th>
											-->
											<th class="table_color">航班号</th>
											<th class="table_color">PNR</th>
											<th class="table_color">申请时间</th>
											<!--<th class="table_color">办理时间</th>
											<th class="table_color">升舱效率</th>
											<th class="table_color">升舱状态</th>
											-->
											<th class="table_color">差价</th>
											<th class="table_color">状态</th>
											<!--<th class="table_color">申请人</th>
											<th class="table_color">处理人</th>
											-->
											<th class="table_color">备注</th>
											<th class="table_color">操作</th>

										</tr>

										<ww:iterator value="listScang">
											<tr id="<ww:property value="id"/>" align="center"
												onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';"
												onmouseout="this.className='colortrout',this.style.fontWeight='';">

												<td class="table_color"><input type="checkbox"
													name="selectid" value="<ww:property value="id"/>" /></td>


												<td class="table_color"><ww:property value="id" /></td>
												<!--<td class="table_color"><ww:property
													value="passengerid" /></td>
												-->
												<!--<td class="table_color"><ww:property value="startcode" /></td>
												<td class="table_color"><ww:property value="endcode" /></td>
												--><td class="table_color"><ww:property value="ordercode" /></td>
												<!--<td class="table_color"><ww:property value="orderid" /></td>
												--><td class="table_color"><ww:property value="flight" /></td>
												<td class="table_color"><ww:property value="pnr" /></td>
												<td class="table_color"><ww:property
													value="formatTimestamp(createtime)" /></td>
												<!--
												<td class="table_color"><ww:property
													value="formatTimestamp(transacttime)" /></td>
												<td class="table_color"><ww:property value="xiaolv" /></td>
												<td class="table_color"><ww:property value="states" /></td>
												-->
												<td class="table_color"><ww:property value="price" /></td>
												<td class="table_color">
												<ww:if test="status==1">未支付</ww:if>
												<ww:if test="status==2">已支付</ww:if>
												</td>
												<!--<td class="table_color"><ww:property value="applyid" /></td>
												<td class="table_color"><ww:property value="updateid" /></td>
												--><td class="table_color"><ww:property value="comment" /></td>

												<td class="table_color">
												<ww:if test="status==1">
												<!-- <input type="button" class="button108" id='btnpay<ww:property value="id"/>' value="立即支付" onclick='payorder(<ww:property value="orderid" />,<ww:property value="id" />);' /><br/> -->
												<input type="button" class="button108" id='btnpay<ww:property value="id"/>' value="立即支付" onclick='topayorder(<ww:property value="orderid" />,<ww:property value="id" />);' /><br/>
												
												</ww:if>
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
		<form action="" target="_blank" id="form2" name="form2" method="post">
		  <input type="hidden" name="paymethod" id="paymethod" value="directPay" />
		  <input type="hidden" name="" id="pay_bank" value="ICBCB2C" />
		  </form>
		</td>
	</tr>
</table>



</div>
</body>
</html>


<script language="JavaScript">
function payorder(orderid,id){
		var url='http://127.0.0.1:8080/interface/Alipay_chajia?';
      	//var url='http://www.zyfx888.com.cn:8080/interface/Alipay_chajia?';
      	//var url='http://sy158.net:8080/interface/Alipay_chajia?';
      //var url='http://121.199.35.38/interface/Alipayfen?';
        var info="helpername=Airpayhelper&orderid="+orderid+"&scangid="+id;
        var paymethod="";
        var pay_bank="";
      document.form2.action=url+info+"&paymethod="+paymethod+"&pay_bank="+pay_bank;
      document.form2.submit();
	}
function topayorder(orderid,id){
		window.location.href="scang!topay.action?orderinfoid="+orderid+"&scangid="+id;
	}
		
	function toadd(){
		window.location="scang!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="scang!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="scang!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="scang!batch.action?opt=1";
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
						
						document.form1.action="scang!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="scang!toedit.action?id="+uvalue;
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
						
						document.form1.action="scang!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="scang!tocheck.action?id="+uvalue;
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





