<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-常用乘机人</title>


<ww:head name="login"/>
<ww:head name="airlines"/>
</head>

<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>     
<!----------header over---------->
<div id="member">
   <jsp:include flush="true" page="../member/left.jsp?ty=member" ></jsp:include>
   <div class="right mt10 r">
       <!-- <div>
          <ul>
            <li class="mation fff">会员信息</li>
            <li class="mation_info"><font class="mation_left f f90"><b>普通会员</b></font><span class="f mr25">会员注册时间为：<ww:property value="formatDate(customeruser.createtime)" /></span>       <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div> -->
       <div class="box">
        <div class="tit">
               <font class="black low2 f mr15">常用乘机人</font>
              <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
               <div class="c"></div>
        </div>
         <form action="<%=request.getContextPath()%>/login!toPassenger.jspx" name="form1" method="post" id="form1">
        <div class="information">
          <div>&nbsp;</div>
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td  class="hadow hl24" align="center" width="20%">查询常用乘机人</td>
                <td>关键字：<input type="textg"  name="c_name" value="<ww:property value="c_name" />" class="text_number"  /><input type="submit" value="立即查询" class="button_searchmeb mlr15"  />(模糊查询,可输入姓名或者手机号查询) </td>
            </table>
            <div>&nbsp;</div>
        <!--listsearch over-->
          
            <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td class="hadow hl24" width="30"><input name="all1" type="checkbox" value="1" onclick="selectall1()" /></td>
                <td class="hadow" width="15%">姓名</td>
                <td class="hadow" width="15%">乘客类型</td>
                <!--
                <td class="hadow" width="10%">证件类型</td>
                <td class="hadow" >证件号</td>
                -->
                <td class="hadow" width="10%">性别</td>
                <td class="hadow" width="20%">手机号</td>
                <td class="hadow" width="20%">创建时间</td>
               
                <td class="hadow">操作</td>
              </tr>       
              <ww:iterator value="ListCustomerpassenger">
              <tr>
                <td><input name="selectid" type="checkbox" value="<ww:property value="id"/>" /></td>
                <td><ww:property value="username" /></td>
                <td>
                <ww:if test="type==1">成人</ww:if>
                <ww:if test="type==2">儿童</ww:if>
                <ww:if test="type==3">婴儿</ww:if>
                </td>
                 <td><ww:property value="sex" /></td>
                <!--
                <td><ww:property value="GetCustomerCredittype(id)" /></td>
                <td><font class="f90"><ww:property value="GetCustomerCreditNumber(id)" /></font></td> 
                -->
                <td><ww:property value="mobile" /></td>
                <td><ww:property value="formatDate(createtime)" /></td>
               
                <td><a href="login!toEditPassenger.jspx?passengerid=<ww:property value="id" />"><font class="l06c" >编辑 &nbsp;&nbsp;</font></a>
                |&nbsp;&nbsp;<a href="login!DeletePassenger.jspx?passengerid=<ww:property value="id" />"><font class="l06c" >删除</font></a></td>
				
              </tr>
              
              </ww:iterator>
              
             
            </table>
            
    <div align="center">
 
  <span >&nbsp;<ww:property value="getPagination('\"login!toPassenger.jspx?pageinfo.pagenum=\"+pageno+\"\"')"/>&nbsp;</span>
  
    </div>
    
            <div class="bntt">
            <input type="button" class="button_cancel fff mlr" value="新增乘客" onclick="toAddPass();"  />
            <input type="button" class="button_cancel fff mlr" value="删除所选" onclick="deleteItem()"  />
            </div>
            
        </div>
        </form>
       </div> 
       
   </div>
</div>

<ww:include page="../footer.jsp"/> 
</body>
</html>
<script>
function toAddPass(){
window.location.href="login!toAddPassenger.jspx";
}
function deleteItem(){
			var length=document.form1.selectid.length;
			//alert(document.form1.selectid.value);
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="login!DeletePassenger.jspx?passengerid="+document.form1.selectid.value;
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
								document.form1.action="login!DeletePassenger.jspx?passengerid="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="login!batch.jspx?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
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