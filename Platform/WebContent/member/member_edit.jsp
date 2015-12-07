
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员列表</title>
</head>
	<link href="../style/base.css" rel="stylesheet" />
<link href="../style/text.css" rel="stylesheet" />
<style type="text/css">

.lj a{ text-decoration:none; color:#993300;}

.button{background:url(../images/hout3.gif); width:98px; height:31px; border:none; color:#FFF; font-size:14px; font-weight:bold;}
</style>
<body>

<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;会员列表</b></td>
  </tr>
  <tr>
    <td valign="top">



<form name="form1" method="post" action="member.action">

<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
<tr>
    <td  valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top">
        
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td></td>
          </tr>
          <tr>
            <td height="20">&nbsp;
            </td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td valign="top"><table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
          <tr>
            <td width="100%">
            <table width="99%" border="0" cellspacing="0" cellpadding="0" style="line-height:28px;">
  <tr>
    <td width="22%" align="right">真实姓名：</td>
    <td width="24%"><input name="" type="text" style=" width:154px;"  />
      <span style="color:#F00; font-weight:bold;">*</span></td>
    <td colspan="3" style="color:#F00; font-weight:bold;">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">性别：</td>
    <td><input type="radio" name="RadioGroup1" value="单选" />  男
        <input type="radio" name="RadioGroup1" value="单选" />女
    </td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="23" align="right">联系手机：</td>
    <td><input name="input2" type="text" style=" width:154px;"  />
      <span style="color:#F00; font-weight:bold;">&lowast;</span></td>
    <td width="5%">备用：</td>
    <td width="22%"><input name="input" type="text" style=" width:154px;"  /></td>
    <td width="27%">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td><input name="input3" type="text" style=" width:154px;"  />
      <span style="color:#F00; font-weight:bold;">&lowast;</span></td>
    <td>备用：</td>
    <td><input name="input15" type="text" style=" width:154px;"  /></td>
    <td>格式：010-8888888</td>
  </tr>
  <tr>
    <td align="right">性别：</td>
    <td><select name=""><option>男</option> <option>女</option></select></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td><input name="input5" type="text" style=" width:154px;"  /></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td><input name="input6" type="text" style=" width:154px;"  /></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td><input name="input7" type="text" style=" width:154px;"  /></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td><input name="input8" type="text" style=" width:154px;"  /></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td><input name="input9" type="text" style=" width:154px;"  /></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td><input name="input10" type="text" style=" width:154px;"  /></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td><input name="input11" type="text" style=" width:154px;"  /></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td colspan="4"><input name="input12" type="text" style=" width:414px;"  /></td>
    </tr>
  <tr>
    <td align="right">联系电话：</td>
    <td colspan="4"><input name="input13" type="text" style=" width:414px;"  /></td>
    </tr>
  <tr>
    <td height="46" colspan="4" align="center">
      <input type="submit" name="button" class="button_d font-white" style="margin-right:40px;"  value="提&nbsp;交" />      <input type="button" class="button_d font-white"  name="button2" value="返&nbsp;回" onclick="javascript:window.history.go(-1);" /></td>
    <td height="46" align="center">&nbsp;</td>
    </tr>
</table>


            </td>
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
	
	
	function deleteItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="member!delete.action?id="+document.form1.selectid.value;
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
								document.form1.action="member!delete.action?id="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="member!batch.action?opt=1";
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
						
						document.form1.action="member!toedit.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="member!toedit.action?id="+uvalue;
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
  function fenpei(){
			var length=document.form1.selectid.length;
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						document.form1.action="memservitem!toadd.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="memservitem!toadd.action?memberid="+uvalue;
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
  
  
  
  
	function chakanItem(){
			var length=document.form1.selectid.length;
			
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						
						document.form1.action="member!tochakan.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="member!tochakan.action?id="+uvalue;
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
						
						document.form1.action="member!tocheck.action?id="+document.form1.selectid.value;
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
					      		document.form1.action="member!tocheck.action?id="+uvalue;
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
function 	searchOne(){
	
	
	
	
		document.form1.submit();
	
	
	}

</script>





