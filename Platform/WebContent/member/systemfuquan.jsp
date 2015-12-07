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
<title>系统角色列表</title>
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/dtree/dtree.js"></script>
<link href="js/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />

</head>
<body>

<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse"><span class="font-blue-cu">&nbsp;&nbsp;&nbsp;给:&nbsp;<strong><ww:property value="getRolername(rd)"/></strong>&nbsp;&nbsp;&nbsp;赋权</span></b></td>
  </tr>
  <tr>
    <td  valign="top">
    <p> 
| <a href="javascript: d.openAll();"> 展开 </a>
| <a href="javascript:d.closeAll();"> 缩起 </a> </p> (<span style="color:red;">红色选项为按钮级别权限,选中即为已经保存!!</span>)
<input type="button" value="返回角色列表"  class="button_d font-bai" style="margin-left:200px;" onclick="window.location.href='systemrole.action?<ww:property value="url"/>';" />

  <script language="JavaScript">

	//var id = <ww:property value="giftcatalog.id>0"/>
	var d = new dTree('d');
	
	d.add(-1,0,"权限树","javascript:show(parameter+1);");
	
		<ww:iterator value="listsysright">
        	d.add(<ww:property value="id"/>,
        	<ww:property value="parentid"/>
        	,'<input type="checkbox" name="check" value="<ww:property value="id"/>" <ww:if test="hasRight(rd,id)"> checked </ww:if>  class="<ww:property value="parentid" />" id="ch<ww:property value="id"/>" onClick="checkStatus(<ww:property value="id"/>,this)"><span <ww:if test="checkcode(id)">style="color:red;"</ww:if>><ww:property value="name"/></span>');
		</ww:iterator>
		

	
		document.write(d); 
	
	function checkStatus(no,chkBox){
//	alert(no+"=="+chkBox);
	var checkb = document.getElementById("ch"+no).checked;//点击的时候判断点击前是否已经选中,
 //   alert(checkb);
if(checkb == true){		
//	alert("add"+no);
		addrolright(<ww:property value="rd"/>,no);//插入所有子目录
   }else{
 //  alert("delet"+no);
    deletrolright(<ww:property value="rd"/>,no);
   }
    
    checkPar(chkBox);//当子目录选中时,父目录也选中
    var chks = document.getElementsByTagName('input');//得到所有input
    for(var i=0;i <chks.length;i++){
   
           
        if(chks[i].name.toLowerCase() == 'check'){//得到所名为check的input
            if(chks[i].className == no){//ID等于传进父目录ID时
      //      	alert("chks[i].className="+chks[i].className);
       //    	alert("no="+no);
            	
            	var rightid = no;
            	//alert("rightid="+rightid);
            	
            	//var checkb = document.getElementById("ch"+chkBox.className).checked;
            	//alert(checkb);
            	var checkb = document.getElementById("ch"+rightid).checked;//点击的时候判断点击前是否已经选中,
    //		 alert(checkb);
    			// chks[i].checked = chkBox.checked;//保持选中状态和父目录一致
    			  
    			  if(checkb == true){
	    			   chks[i].checked = chkBox.checked;//保持选中状态和父目录一致
	    			   
	    			   
	    			 }else{
	    			  chks[i].checked = chkBox.checked;//保持选中状态和父目录一致
	    			 
	    			  // deletrolright(<ww:property value="rd"/>,no);
	    			 // deletrolright(<ww:property value="rd"/>,chks[i].value);
	    			 }
              
    			 
                
   //              alert(chks[i].value+"..."+chks[i]);
              
                checkStatus(chks[i].value,chks[i]);//递归保持所有的子目录选中
            }
           
        }
    }
}

function checkPar(chkBox) {
    if(chkBox.name.toLowerCase() == 'check' && chkBox.checked && chkBox.className != -1) {//判断本单击为选中,并且不是根目录,则选中父目录
   
        var chkObject = document.getElementById("ch"+chkBox.className);//得到父目录对象
        var chkid =chkBox.className;
        //alert("888"+chkid);
       addrolright(<ww:property value="rd"/>,chkid);//插入所有父目录
       // alert(chkObject+"chkObject");
        chkObject.checked="checked";
       
        checkPar(chkObject);
    }
}
function deletrolright(rold,rigd){

//alert("执行删除"+"rold="+rold+"rigd="+rigd);

	$.post(
				"systemright!deletsysrolerright.action",{'rold':rold,'rigd':rigd},
				 
				
				function(str1)
				{
					
				}
				);

} 
function addrolright(rold,rigd){
//alert("rold="+rold+"rigd="+rigd);

	$.post(
				"systemright!addsysrolerright.action",{'rold':rold,'rigd':rigd},
				 
				
				function(str1)
				{
					
				}
				);

} 
	
		</script>
     <!--<div id='comboxWithTree2' ></div>	 
    
    --><!--
    <table>
     <tr>
        <td height="306" valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td width="100%"><table width="100%" border="1" align="center" bordercolor="#a0cfee" style="border-collapse:collapse">
              <tbody>
                <tr bgcolor="#d7e9fc">
                  
                  <th width="54" height="25">赋权</th>
               	     
           		 <th width="54">
                  	ID</th>
                  <th width="400">
                  	权限名称</th>
                  <th width="400">
                  	操作代码</th>
                  
                  
                
        
			</tr>
	<ww:iterator value="listSysright" id="listSysright">
	      <tr align="center"
                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
		   <td>
		   <input type="checkbox" id="selectid" onclick="allocat(this,<ww:property value="sysroleright.roleid"/>);" name="selectid" value="<ww:property value="id"/>" 
		   <ww:if test="hasRight(sysroleright.roleid,id)">checked</ww:if>/>
		   </td>
				<td><ww:property value="id"/></td>
				<td align="left"><strong><ww:property value="name"/></strong></td>
				<td><ww:property value="code"/></td>
			</tr>
			
					<ww:iterator value="getsysright(id)" id="listServiceItems">	
							 <tr align="center"
				                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
				                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
						   <td>
						   <input type="checkbox" id="selectid" onclick="allocat(this,<ww:property value="sysroleright.roleid"/>);" name="selectid" value="<ww:property value="id"/>" 
						   <ww:if test="hasRight(sysroleright.roleid,id)">checked</ww:if>/>
						   </td>
								<td><ww:property value="id"/></td>
								<td align="left">---<strong><ww:property value="name"/></strong></td>
								<td><ww:property value="code"/></td>
							</tr>
											<ww:iterator value="getsysright(id)" id="listServiceItems">	
											 <tr align="center"
								                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
								                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
										   <td>
										   <input type="checkbox" id="selectid" onclick="allocat(this,<ww:property value="sysroleright.roleid"/>);" name="selectid" value="<ww:property value="id"/>" 
										   <ww:if test="hasRight(sysroleright.roleid,id)">checked</ww:if>/>
										   </td>
												<td><ww:property value="id"/></td>
												<td align="left">------<strong><ww:property value="name"/></strong></td>
												<td><ww:property value="code"/></td>
											</tr>      
												
												
													<ww:iterator value="getsysright(id)" id="listServiceItems">	
														 <tr align="center"
											                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
											                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
													   <td>
													   <input type="checkbox" id="selectid" onclick="allocat(this,<ww:property value="sysroleright.roleid"/>);" name="selectid" value="<ww:property value="id"/>" 
													   <ww:if test="hasRight(sysroleright.roleid,id)">checked</ww:if>/>
													   </td>
															<td><ww:property value="id"/></td>
															<td align="left">---------<strong><ww:property value="name"/></strong></td>
															<td><ww:property value="code"/></td>
														</tr>
																	<ww:iterator value="getsysright(id)" id="listServiceItems">	
																			 <tr align="center"
																                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
																                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
																		   <td>
																		   <input type="checkbox" id="selectid" onclick="allocat(this,<ww:property value="sysroleright.roleid"/>);" name="selectid" value="<ww:property value="id"/>" 
																		   <ww:if test="hasRight(sysroleright.roleid,id)">checked</ww:if>/>
																		   </td>
																				<td><ww:property value="id"/></td>
																				<td align="left">------------<strong><ww:property value="name"/></strong></td>
																				<td><ww:property value="code"/></td>
																			</tr>
																					
																					<ww:iterator value="getsysright(id)" id="listServiceItems">	
																							 <tr align="center"
																				                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
																				                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
																						   <td>
																						   <input type="checkbox" id="selectid" onclick="allocat(this,<ww:property value="sysroleright.roleid"/>);" name="selectid" value="<ww:property value="id"/>" 
																						   <ww:if test="hasRight(sysroleright.roleid,id)">checked</ww:if>/>
																						   </td>
																								<td><ww:property value="id"/></td>
																								<td align="left">---------------<strong><ww:property value="name"/></strong></td>
																								<td><ww:property value="code"/></td>
																							</tr>
																							
																										<ww:iterator value="getsysright(id)" id="listServiceItems">	
																												 <tr align="center"
																									                      onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';" 
																									                      onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
																											   <td>
																											   <input type="checkbox" id="selectid" onclick="allocat(this,<ww:property value="sysroleright.roleid"/>);" name="selectid" value="<ww:property value="id"/>" 
																											   <ww:if test="hasRight(sysroleright.roleid,id)">checked</ww:if>/>
																											   </td>
																													<td><ww:property value="id"/></td>
																													<td align="left">------------------<strong><ww:property value="name"/></strong></td>
																													<td><ww:property value="code"/></td>
								 	
																								</ww:iterator>
									
																				</ww:iterator>
																					
																					
																</ww:iterator>
																	
												</ww:iterator>
									
									</ww:iterator>
					
					</ww:iterator>
	</ww:iterator>
			

           </tbody>
            </table></td>
          </tr>
          
        </table>
    

-->
<input type="button" value="返回角色列表"  class="button_d font-bai" style="margin-left:200px;" onclick="window.location.href='systemrole.action?<ww:property value="url"/>';" />
 
</td>
   </tr>
  
   </table>
</div>


</body>
</html>


<script language="JavaScript">

function allocat(select,roleid)
	{	

	//alert(roleid);
	//alert(select.value);
	
	
		if(select.checked==true)
		{
			window.location.href='sysroleright!enable.action?sysroleright.id='+select.value+'&sysroleright.roleid='+roleid;
		
		}else{
		
			window.location.href='sysroleright!unable.action?sysroleright.id='+select.value+'&sysroleright.roleid='+roleid;
		
		}
	
	}

	function toadd(){
		window.location="systemrole!toadd.action?<ww:property value="url"/>";
	}
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="systemrole!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="systemrole!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="systemrole!batch.action?opt=1";
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
						
						document.form1.action="systemrole!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="systemrole!toedit.action?id="+uvalue;
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
						
						document.form1.action="systemrole!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="systemrole!tocheck.action?id="+uvalue;
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





