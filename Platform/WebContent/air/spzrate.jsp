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
<title>特价政策表列表</title>
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
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
                id:"new",
				text: '新建',
				icon:"images/menu/new.gif",
				handler : function(item){
					window.location.href="spzrate!toadd.action?<ww:property value="url"/>";
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"images/menu/edit.gif",
				handler : function(item){
						document.form1.action="spzrate!toedit.action?id="+selectId;
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
						document.form1.action="spzrate!delete.action?id="+selectId;
						document.form1.submit();
					
						}
					}});
					
				}
            },
			'-',
			{
                id:"check",
				text:"禁用/启用",
				disabled:false,
				icon:"images/menu/check.gif",
				handler :function(item){
						document.form1.action="spzrate!tocheck.action?id="+selectId;
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
function showdiag(id,state)
{
	document.getElementById(id).style.display=state;
}
</script>
</head>
<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;普通政策表列表</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
    
<form name="form1" method="post" action="spzrate.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">

           <tr>
            <td>    
            <table width="760" border="0" align="center" cellpadding="0" cellspacing="0" style="font-size: 12px;">
                                                <tr>
                                                    <td width="184" height="30" align="right">
                                                        起始城市：</td>
                                                    <td width="198">
                                                        <span style="height: 71px">
                                                        	<select name="se_departureport" style="width: 165px;">
                                                        	<option value="" <ww:if test="se_departureport==null||se_departureport=\"\"">selected="selected"</ww:if>>所有城市</option>
                                                         	
													<ww:iterator value="listCityairport">
														<option value="<ww:property value="airportcode"/>"
															<ww:if test="se_departureport==airportcode">selected="selected"</ww:if>><ww:property
															value="cityname" />(<ww:property value="airportcode" />)</option>
													</ww:iterator>
												</select>
												</span></td>
                                                    <td width="129" height="40" align="right">
                                                        到达城市：</td>
                                                    <td width="181">
                                                        <span style="height: 71px">
                                                        	<select name="se_arrivalport" style="width: 165px;">
                                                        	<option value="" <ww:if test="se_arrivalport==null||se_arrivalport=\"\"">selected="selected"</ww:if>>所有城市</option>
													<ww:iterator value="listCityairport">
														<option value="<ww:property value="airportcode"/>"
															<ww:if test="se_arrivalport==airportcode">selected="selected"</ww:if>><ww:property
															value="cityname" />(<ww:property value="airportcode" />)</option>
													</ww:iterator>
												</select>   
														</span></td>
                                                    <td width="134" rowspan="3" align="center">
                                                        </td>
                                                </tr>
                                                <tr class="font-blue-xi">
                                                  <td height="28" align="right">出票开始日期：</td>
                                                  <td><input id="Text2" style="width: 160px" name="se_issuedstartdate" value="<ww:property value="se_issuedstartdate"/>" onClick="WdatePicker()" /></td>
                                                  <td height="28" align="right">出票结束日期：</td>
                                                  <td><input id="Text2" style="width: 160px" name="se_issuedendate" value="<ww:property value="se_issuedendate"/>" onClick="WdatePicker()" /></td>
                                                </tr>
                                                <tr class="font-blue-xi">
                                                  <td height="28" align="right">发布人：</td>
                                                  <td><input id="Text2" style="width: 160px" name="se_agentid" value="<ww:property value="se_agentid"/>" /></td>
                                                  <td height="28" align="right">航班号：</td>
                                                  <td><input id="Text2" style="width: 160px" name="se_flightnumber" value="<ww:property value="se_flightnumber"/>" /></td>
                                                  <td align="center">&nbsp;</td>
                                                </tr>
                                                <tr class="font-blue-xi">
                                                    <td height="28" align="right">
                                                        <span class="STYLE2">航空公司：</span></td>
                                                    <td>
                                                       <select id="se_aircompanycode"
													style="width: 165px;" name="se_aircompanycode">
													<option value="" <ww:if test="se_aircompanycode==null||se_aircompanycode==\"\"">selected="selected"</ww:if>>所有航空公司</option>
													<ww:iterator value="listAircompany">
														<option value="<ww:property value="aircomcode"/>"
															<ww:if test="se_aircompanycode==aircomcode">selected="selected"</ww:if>><ww:property
															value="aircomcnname" />/<ww:property value="aircomcode" /></option>
													</ww:iterator>
												</select>                                                   </td>
                                                    <td height="28" align="right">
                                                        政策类型：</td>
                                                    <td width="181">
                                                        <select name="se_tickettype"  style="width: 165px;">
                                                        <option value="-1" <ww:if test="se_tickettype==null||se_tickettype==-1">selected="selected"</ww:if>>所有政策</option>
                                                        <option value="1" <ww:if test="se_tickettype==1">selected="selected"</ww:if>>BSP政策</option>
                                                        <option value="2" <ww:if test="se_tickettype==2">selected="selected"</ww:if>>B2B政策</option>
                                                        </select>                                                    </td>
                                                </tr>
                                                <tr>
                                                	<td colspan="5" align="center">
													<input type="submit" class="button_d font-white" value="查&nbsp;&nbsp;询" />
													</td>
                                                </tr>
                                                
                                            </table>   
		</td>
          </tr>
          <tr>
            <td height="40"><table width="99%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="27" align="center"><div align="right">
                <a href="#" onclick="toadd()"><input type="button" value="新增" class="button_h font-red" /></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input type="button" value="修改" class="button_h font-red" /></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input type="button" value="删除" class="button_h font-red" /></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input type="button" value="禁用/启用" class="button_h font-red" /></a></div></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td  valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table id="menutable" width="99%" border="1" align="center" class="table_color">
              <tbody>
                <tr class="tbody_color">
                  
                  <th class="table_color" width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
               	     
                  <!--<th class="table_color">政策编号</th>
                  -->
                  <th class="table_color">航空公司</th>
                  <th class="table_color">出发</th>
                  <th class="table_color">抵达</th>
                  <th class="table_color">航班</th>
                  <th class="table_color">舱位限制</th>
                  <th class="table_color">政策</th>
                  <th class="table_color">政策类型</th><!-- (1=BSP,2=B2B) -->
                  <th class="table_color">行程类型</th>
                  <th class="table_color">有效期</th>
			</tr>

		<ww:iterator value="listspzrate" status="index">
	      <tr id="<ww:property value="id"/>" align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';" 
                      onmouseout="this.className='colortrout',this.style.fontWeight='';">
	
		   <td  class="table_color"><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>
		
	
<!--<td  class="table_color"><ww:property value="id"/></td>
-->
<td  class="table_color"><ww:property value="aircompanycode"/></td>
<td  class="table_color"><ww:property value="departureport"/></td>
<td  class="table_color"><ww:property value="arrivalport"/></td>
<td  class="table_color"><ww:property value="flightnumber"/></td>
<td  class="table_color"><ww:property value="cabincode"/></td>
<td  class="table_color"><ww:property value="ratevalue"/></td>
<td  class="table_color"><ww:if test="tickettype==1">BSP</ww:if><ww:elseif test="tickettype==2">B2B</ww:elseif><ww:else>未知类型</ww:else></td>
<td  class="table_color"><ww:if test="traveltype==1">单程</ww:if><ww:elseif test="traveltype==2">往返</ww:elseif><ww:elseif test="traveltype==3">单程/往返</ww:elseif><ww:elseif test="traveltype==4">连程</ww:elseif><ww:else>未知类型</ww:else></td>
<td  class="table_color"><ww:property value="formatDate(issuedstartdate)"/>到<ww:property value="formatDate(issuedendate)"/></td>		
	</tr>
	<tr>
	<td colspan="10">
	<div id="spzrate_list_div<ww:property value="#index.index"/>"	>
		<div style="width:670px;float:left;overflow:hidden;">
	              <div style="padding-left:5px;float:left;width:220px;float:left;">
	                  出票日期：<ww:property value="getpolicyperioddate(id)"/></div>
	              <div style="float:left;width:220px;float:left;">
	                  出票效率：28分钟15秒 
				  </div>
				  <div style="float:left;width:220px;float:left;">
	                  退票效率：
				  </div>
			  </div>
		<div style="float:left;padding-left:5px;line-height:24px;">
	          	   发布方备注：<ww:property value="remark"/>
	    </div>
    </div>
	</td>
	</tr>
	</ww:iterator>

           </tbody>
            </table></td>
          </tr>
          <tr>
            <td height="43" align="center"> <ww:property value="pagination" /> </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
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
		window.location="spzrate!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="spzrate!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="spzrate!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="spzrate!batch.action?opt=1";
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
						
						document.form1.action="spzrate!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="spzrate!toedit.action?id="+uvalue;
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
						
						document.form1.action="spzrate!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="spzrate!tocheck.action?id="+uvalue;
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





