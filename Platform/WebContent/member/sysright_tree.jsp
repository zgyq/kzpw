<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>权限树</title>
</head>
<script type="text/javascript" src="js/dtree/dtree.js"></script>
<link href="js/dtree/dtree.css" rel="stylesheet" type="text/css">
	<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />


	


<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;权限树展示</b></td>
  </tr>
  <tr>
    <td  valign="top">
    <p> 
| <a href="javascript: d.openAll();"> 展开 </a> 
| <a href="javascript:d.closeAll();"> 缩起 </a> </p> (<span style="color:red;">红色选项为按钮级别权限</span>)
     <script language="JavaScript">

	
	var d = new dTree('d');
	
	d.add(-1,0,"权限树","javascript:show(parameter+1);");
	
		<ww:iterator value="listsysright">
        	d.add(<ww:property value="id"/>,
        	<ww:property value="parentid"/>
        	,'<span <ww:if test="checkcode(id)">style="color:red;"</ww:if>><ww:property value="name"/></span>');
		</ww:iterator>
		

	
		document.write(d); 
	
	function checkStatus(no,chkBox){

		
    checkPar(chkBox);//当子目录选中时,父目录也选中
    var chks = document.getElementsByTagName('input');//得到所有input
    for(var i=0;i <chks.length;i++){
        if(chks[i].name.toLowerCase() == 'check'){//得到所名为check的input
            if(chks[i].className == no){//ID等于传进父目录ID时
          
            
        
            
                chks[i].checked = chkBox.checked;//保持选中状态和父目录一致
               
                checkStatus(chks[i].value,chks[i]);//递归保持所有的子目录选中
            }
        }
    }
}

function checkPar(chkBox) {
    if(chkBox.name.toLowerCase() == 'check' && chkBox.checked && chkBox.className != -1) {//判断本单击为选中,并且不是根目录,则选中父目录
        var chkObject = document.getElementById("ch"+chkBox.className);//得到父目录对象
       
        chkObject.checked="checked";
       
        checkPar(chkObject);
    }
}
	
	
		</script>


</td>
   </tr>
   </table>
</div>
</body>
</html>





