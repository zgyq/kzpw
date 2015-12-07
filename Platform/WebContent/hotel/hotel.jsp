<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%
/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/14 创建
 *
 */
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店列表</title>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>

<form name="form1" method="post" action="hotel.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td width="100%" height="29" background="images/jianbianbj.gif"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店列表</span></td>
  </tr>
  <tr>
    <td height="455" valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>
            
       <!--    
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
        -->     



		</td>
          </tr>
          <tr>
            <td><table width="99%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="27" align="center"><div align="right">
                <a href="hotel!toadd.action?<ww:property value="url"/>"><input type="button" value="新增" class="button_h font-red"></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><input type="button" value="修改" class="button_h font-red"></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><input type="button" value="删除" class="button_h font-red"></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><input type="button" value="审核" class="button_h font-red"></div></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc">
                  
                  <th width="54" height="25"><input type="checkbox" name="all1" value="1" onclick="selectall1()" />全选</th>
               	     
                  <th>
                  	IDasdf</th>
                  <th>
                  	洒店名称</th>
                  <th>
                  	英文名称</th>
                  <th>
                  	星级</th>
                  <th>
                  	推荐级别</th>
                  <th>
                  	装修级别</th>
                  <th>
                  	国家ID</th>
                  <th>
                  	省份ID</th>
                  <th>
                  	城市ID</th>
                  <th>
                  	行政区ID</th>
                  <th>
                  	商业区ID</th>
                  <th>
                  	酒店地址</th>
                  <th>
                  	酒店描述</th>
                  <th>
                  	洒店类型</th>
                  <th>
                  	房间总数</th>
                  <th>
                  	服务设施</th>
                  <th>
                  	餐饮设施</th>
                  <th>
                  	会议设施</th>
                  <th>
                  	娱乐设施</th>
                  <th>
                  	可接受卡类型</th>
                  <th>
                  	装修时间</th>
                  <th>
                  	周边酒店</th>
                  <th>
                  	邮编</th>
                  <th>
                  	状态</th>
                  <th>
                  	全拼</th>
                  <th>
                  	简拼</th>
                  <th>
                  	是否主楼</th>
                  <th>
                  	主楼高度</th>
                  <th>
                  	状态备注</th>
                  <th>
                  	酒店卖点</th>
                  <th>
                  	全称</th>
                  <th>
                  	开户行</th>
                  <th>
                  	开户账号</th>
                  <th>
                  	排序</th>
                  <th>
                  	企业ID</th>
                  
                
        
			</tr>

		<ww:iterator value="listHotel">
	      <tr align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
	
		   <td><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>
		
	
<td><ww:property value="id"/></td><td><ww:property value="name"/></td><td><ww:property value="enname"/></td><td><ww:property value="star"/></td><td><ww:property value="hot"/></td><td><ww:property value="repair"/></td><td><ww:property value="contryid"/></td><td><ww:property value="provinceid"/></td><td><ww:property value="cityid"/></td><td><ww:property value="regionid1"/></td><td><ww:property value="regionid2"/></td><td><ww:property value="address"/></td><td><ww:property value="description"/></td><td><ww:property value="type"/></td><td><ww:property value="rooms"/></td><td><ww:property value="serviceitem"/></td><td><ww:property value="footitem"/></td><td><ww:property value="meetingitem"/></td><td><ww:property value="playitem"/></td><td><ww:property value="carttype"/></td><td><ww:property value="repaildate"/></td><td><ww:property value="nearhotel"/></td><td><ww:property value="postcode"/></td><td><ww:property value="state"/></td><td><ww:property value="pyname"/></td><td><ww:property value="jpname"/></td><td><ww:property value="mainfloor"/></td><td><ww:property value="mainlevel"/></td><td><ww:property value="statedesc"/></td><td><ww:property value="sellpoint"/></td><td><ww:property value="fullname"/></td><td><ww:property value="openbank"/></td><td><ww:property value="bankaccount"/></td><td><ww:property value="sort"/></td><td><ww:property value="companyid"/></td>

		
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
</body>
</html>


<script language="JavaScript">
	
	
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="hotel!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="hotel!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="hotel!batch.action?opt=1";
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
						
						document.form1.action="hotel!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="hotel!toedit.action?id="+uvalue;
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
						
						document.form1.action="hotel!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="hotel!tocheck.action?id="+uvalue;
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





