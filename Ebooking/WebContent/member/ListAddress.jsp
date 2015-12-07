<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-常用配送地址</title>

<ww:head name="login" jsURL="citycontrol" />
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
            <li class="mation_info"><font class="mation_left f"><b>注册时间</b></font><span class="f mr25">会员注册时间为：<ww:property value="formatDate(#session.loginuser.createtime)" /></span>      <font class="f90 f">普通会员</font> <span class="r mation_right">&nbsp;</span>    </li>
          </ul>
       </div> -->
       <div class="box">
        <div class="tit">
               <font class="black low2 f mr15">常用配送地址</font>
              <font class="" style="margin-left: 20px;" >欢迎来到${compname}，我们将竭诚为你服务，24小时服务热线：${tel}。</font>
              
               <div class="c"></div>
        </div>
         <form action="<%=request.getContextPath()%>/login!toAddAddress.jspx" name="form1" method="post" id="form1">
        <div class="information">
         <div>&nbsp;</div>
         <table width="86%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
           <tr>
                <td  class="hadow hl24" align="right" width="20"><input name="all1" type="checkbox" value="1" onclick="selectall1()" /></td>
                <td width="80">姓名</td>
                <td>地址</td>
                <td width="70">操作</td>
              </tr>
         <ww:iterator value="listUseraddress">
              <tr>
                <td  class="hadow hl24" align="right" width="20"><input  name="selectid" type="checkbox" value="<ww:property value="id"/>" /></td>
                <td width="80"><ww:property value="name"/></td>
                <td><ww:property value="address"/></td>
                <td><a href="login!toEdituseraddress.jspx?AddressID=<ww:property value="id"/>">修改</a>&nbsp;
                <!--   <a href="login!deleteUseraddress.jspx?AddressID=<ww:property value="id"/>">删除</a>  -->
              
                
                </td>
              </tr>
              </ww:iterator>
            </table>
            <div class="bntt">
            <input type="button" class="button_cancel fff mlr" value="添加地址" onclick="addaddress();" />
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
function addaddress(){
window.location.href="login!toAddAddress.jspx";
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
function deleteItem(){
			var length=document.form1.selectid.length;
			//alert(document.form1.selectid.value);
			//唯一项
			if(length== undefined){
			
				if(document.form1.selectid.checked ==true)
				{
						var temp = confirm('确认删除吗？');
						if(temp==true){
						
							document.form1.action="login!DeleteAddress.jspx?AddressID="+document.form1.selectid.value;
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
								document.form1.action="login!DeleteAddress.jspx?AddressID="+uvalue;
								document.form1.submit();
							}
							return;
					      }else if (len>1){
					      	var temp = confirm('确认删除吗？');
					      	if(temp==true){
					      		document.form1.action="login!DeleteAddressbatch.jspx?opt=1";
								document.form1.submit();
							}
							return;
					      
					      }
					      
				 }	
				
			alert("无效操作,你未选择任何内容!");
			return;
  }
</script>