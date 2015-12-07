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
<title>酒店房态表列表</title>
</head>
<link href="../css/base.css" rel="stylesheet" />
<body>

<form name="form1" method="post" action="roomstateback.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td width="100%" height="29" background="../images/jianbianbj.gif"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;酒店房态表列表</span></td>
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
                <a href="roomstateback!toadd.action?<ww:property value="url"/>">新增</a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="updateItem()"><strong class="font-red">修改</strong></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="deleteItem()"><strong class="font-red">删除</strong></a>
                &nbsp;&nbsp;&nbsp;<a href="#" onclick="checkItem()"><strong class="font-red">审核</strong></div></td>
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
                  	ID</th>
                  <th>
                  	月份</th>
                  <th>
                  	酒店ID</th>
                  <th>
                  	房型ID</th>
                  <th>
                  	是否禁用</th>
                  <th>
                  	描述</th>
                  <th>
                  	状态</th>
                  <th>
                  	是否确认</th>
                  <th>
                  	计算类别</th>
                  <th>
                  	单日房态31</th>
                  <th>
                  	单日房态30</th>
                  <th>
                  	单日房态29</th>
                  <th>
                  	单日房态28</th>
                  <th>
                  	单日房态27</th>
                  <th>
                  	单日房态26</th>
                  <th>
                  	单日房态25</th>
                  <th>
                  	单日房态24</th>
                  <th>
                  	单日房态23</th>
                  <th>
                  	单日房态22</th>
                  <th>
                  	单日房态21</th>
                  <th>
                  	单日房态20</th>
                  <th>
                  	单日房态19</th>
                  <th>
                  	单日房态18</th>
                  <th>
                  	单日房态17</th>
                  <th>
                  	单日房态16</th>
                  <th>
                  	单日房态15</th>
                  <th>
                  	单日房态14</th>
                  <th>
                  	单日房态13</th>
                  <th>
                  	单日房态12</th>
                  <th>
                  	单日房态11</th>
                  <th>
                  	单日房态10</th>
                  <th>
                  	单日房态9</th>
                  <th>
                  	单日房态8</th>
                  <th>
                  	单日房态7</th>
                  <th>
                  	单日房态6</th>
                  <th>
                  	单日房态5</th>
                  <th>
                  	单日房态4</th>
                  <th>
                  	单日房态3</th>
                  <th>
                  	单日房态2</th>
                  <th>
                  	单日房态1</th>
                  <th>
                  	单日剩31</th>
                  <th>
                  	单日剩30</th>
                  <th>
                  	单日剩29</th>
                  <th>
                  	单日剩28</th>
                  <th>
                  	单日剩27</th>
                  <th>
                  	单日剩26</th>
                  <th>
                  	单日剩25</th>
                  <th>
                  	单日剩24</th>
                  <th>
                  	单日剩23</th>
                  <th>
                  	单日剩22</th>
                  <th>
                  	单日剩21</th>
                  <th>
                  	单日剩20</th>
                  <th>
                  	单日剩19</th>
                  <th>
                  	单日剩18</th>
                  <th>
                  	单日剩17</th>
                  <th>
                  	单日剩16</th>
                  <th>
                  	单日剩15</th>
                  <th>
                  	单日剩14</th>
                  <th>
                  	单日剩13</th>
                  <th>
                  	单日剩12</th>
                  <th>
                  	单日剩11</th>
                  <th>
                  	单日剩10</th>
                  <th>
                  	单日剩9</th>
                  <th>
                  	单日剩8</th>
                  <th>
                  	单日剩7</th>
                  <th>
                  	单日剩6</th>
                  <th>
                  	单日剩5</th>
                  <th>
                  	单日剩4</th>
                  <th>
                  	单日剩3</th>
                  <th>
                  	单日剩2</th>
                  <th>
                  	单日剩1</th>
                  
                
        
			</tr>

		<ww:iterator value="listRoomstateback">
	      <tr align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
	
		   <td><input type="checkbox" name="selectid" value="<ww:property value="id"/>" /></td>
		
	
<td><ww:property value="id"/></td><td><ww:property value="datenumber"/></td><td><ww:property value="hotelid"/></td><td><ww:property value="roomid"/></td><td><ww:property value="isvalid"/></td><td><ww:property value="description"/></td><td><ww:property value="state"/></td><td><ww:property value="confirm"/></td><td><ww:property value="type"/></td><td><ww:property value="no31"/></td><td><ww:property value="no30"/></td><td><ww:property value="no29"/></td><td><ww:property value="no28"/></td><td><ww:property value="no27"/></td><td><ww:property value="no26"/></td><td><ww:property value="no25"/></td><td><ww:property value="no24"/></td><td><ww:property value="no23"/></td><td><ww:property value="no22"/></td><td><ww:property value="no21"/></td><td><ww:property value="no20"/></td><td><ww:property value="no19"/></td><td><ww:property value="no18"/></td><td><ww:property value="no17"/></td><td><ww:property value="no16"/></td><td><ww:property value="no15"/></td><td><ww:property value="no14"/></td><td><ww:property value="no13"/></td><td><ww:property value="no12"/></td><td><ww:property value="no11"/></td><td><ww:property value="no10"/></td><td><ww:property value="no9"/></td><td><ww:property value="no8"/></td><td><ww:property value="no7"/></td><td><ww:property value="no6"/></td><td><ww:property value="no5"/></td><td><ww:property value="no4"/></td><td><ww:property value="no3"/></td><td><ww:property value="no2"/></td><td><ww:property value="no1"/></td><td><ww:property value="back31"/></td><td><ww:property value="back30"/></td><td><ww:property value="back29"/></td><td><ww:property value="back28"/></td><td><ww:property value="back27"/></td><td><ww:property value="back26"/></td><td><ww:property value="back25"/></td><td><ww:property value="back24"/></td><td><ww:property value="back23"/></td><td><ww:property value="back22"/></td><td><ww:property value="back21"/></td><td><ww:property value="back20"/></td><td><ww:property value="back19"/></td><td><ww:property value="back18"/></td><td><ww:property value="back17"/></td><td><ww:property value="back16"/></td><td><ww:property value="back15"/></td><td><ww:property value="back14"/></td><td><ww:property value="back13"/></td><td><ww:property value="back12"/></td><td><ww:property value="back11"/></td><td><ww:property value="back10"/></td><td><ww:property value="back9"/></td><td><ww:property value="back8"/></td><td><ww:property value="back7"/></td><td><ww:property value="back6"/></td><td><ww:property value="back5"/></td><td><ww:property value="back4"/></td><td><ww:property value="back3"/></td><td><ww:property value="back2"/></td><td><ww:property value="back1"/></td>

		
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
						
							document.form1.action="roomstateback!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="roomstateback!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="roomstateback!batch.action?opt=1";
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
						
						document.form1.action="roomstateback!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="roomstateback!toedit.action?id="+uvalue;
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
						
						document.form1.action="roomstateback!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="roomstateback!tocheck.action?id="+uvalue;
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





