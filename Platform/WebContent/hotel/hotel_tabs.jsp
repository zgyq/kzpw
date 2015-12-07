<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<%@ page isELIgnored="false" %>

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
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店列表</title>
 <link rel="stylesheet" href="../js/tabs/jquery.tabs.css" type="text/css" />
 <script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" src="../js/util.js"></script>
 <script src="../js/autocomplete/jquery.js" type="text/javascript"></script>
 <script src="../js/tabs/jquery.history_remote.pack.js" type="text/javascript"></script>
 <script src="../js/tabs/jquery.tabs.pack.js" type="text/javascript"></script>
 <link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
 <script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
 <script type="text/javascript" src="../js/ext-all.js"></script>
 <link href="../css/base.css" rel="stylesheet"/>
  <script type="text/javascript" src="../js/ajax.js"></script>
 <script type="text/javascript">
			<%

				String remotetabs = request.getParameter("remotetabs") ; //默认跳转到那个tabs
				String tabtype = request.getParameter("tabtype") ;  
				if(remotetabs == null || remotetabs.trim().length() == 0) {   
					remotetabs = "1" ;
				}
				if("addcontract".equals(tabtype) || "cancelcontract".equals(tabtype) || "editcontract".equals(tabtype) ||"logcontract".equals(tabtype)) {
					remotetabs = "2" ;
				}
				
				if("addroomtype".equals(tabtype) || "cancelroomtype".equals(tabtype) || "editroomtype".equals(tabtype)){
					remotetabs = "3";
					
				}
				if("addroomstate".equals(tabtype) || "cancelroomstate".equals(tabtype) || "editroomstate".equals(tabtype)){
					
					remotetabs = "4";
				}
				if("addhotelspec".equals(tabtype) || "cancelhotelspec".equals(tabtype) || "edithotelspec".equals(tabtype)){
					
					remotetabs = "5";
				}
				if("addhotellandmark".equals(tabtype) || "cancelhotellankmark".equals(tabtype) || "edithotellankmark".equals(tabtype)){
					remotetabs = "6";
				}
				if("addlinkman".equals(tabtype) || "cancellinkman".equals(tabtype) || "editlinkman".equals(tabtype)){
					
					remotetabs = "7";
				}
				if("addhotelimag".equals(tabtype) || "cancelhotelimag".equals(tabtype) || "edithotelimag".equals(tabtype)){
					remotetabs = "8";
				}
			//	if("hotelstate".equals(tabtype) || "cancelhotelstate".equals(tabtype) || "edithotelstate".equals(tabtype) ||"fanhui".equals(tabtype)){
					
			//		remotetabs = "9";
			//	}
			//	if("addhotelprice".equals(tabtype) || "cancelhotelprice".equals(tabtype)){
					
			//		remotetabs = "10";
			//	}
				request.setAttribute("remotetabs", remotetabs) ;
			%>
            $(function() {
            	$('#container-1').tabs(
            		${requestScope.remotetabs}, { remote:true, bookmarkable:false}
            	);
            }) ;
            
  </script>         
		
</head>

<body>

        <div id="container-1" style="width=100%">
            <ul class="asd">
                <li><a href="hotelbasicinfo!toedit.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>基本信息</span></a></li>
                <%
                	
                	if("addcontract".equals(tabtype)) {
				%>
					<li><a href="hotelcontract!toadd.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>合同</span></a></li>
				<%
                	}else if("editcontract".equals(tabtype)){		
                %> 
                	<li><a href="hotelcontract!toedit.action?id=<ww:property value="hotelcontract.id"/>&hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>合同</span></a></li>
                <%
                	}else if("logcontract".equals(tabtype)){
                %>
                <li><a href="hotelcontract!historyLog.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>合同</span></a></li>
                <%
                	}else{
                %>
                	<li><a href="hotelcontract.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>合同</span></a></li>
                <%		
                	}
                %>
                <%
                	if("addroomtype".equals(tabtype)){
                %>
                <li><a href="roomtype!toadd.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房型</span></a></li>
                <%
                	}else if("editroomtype".equals(tabtype)){
                %>
                <li><a href="roomtype!toedit.action?id=<ww:property value="roomtype.id"/>&hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房型</span></a></li>
                <%
                	}else{
                %> 
                <li><a href="roomtype.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房型</span></a></li>
                <%
                	}
                %>
                <%
                	if("addroomstate".equals(tabtype)){
                %>
                <li><a href="roomstate!toadd.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房态</span></a></li>
                <%
                	}else if("editroomstate".equals(tabtype)){
                %>
                <li><a href="roomstate!toedit.action?id=<ww:property value="roomstate.id"/>&hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房态</span></a></li>
                <%
                	}else{
                %>
                <li><a href="roomstate.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>房态</span></a></li>
                <%
                	}
                %>
                <%
                	if("addhotelspec".equals(tabtype)){
                %>
                <li style="width:100"><a href="hotelspec!toadd.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span style="size:5px">注意事项</span></a></li>
                <%
                	}else if("edithotelspec".equals(tabtype)){
                %>
                <li style="width:100"><a href="hotelspec!toedit.action?id=<ww:property value="hotelspec.id"/>&hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span style="size:5px">注意事项</span></a></li>
				<%
                	}else{
				%>  
				<li style="width:100"><a href="hotelspec.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span style="size:5px">注意事项</span></a></li>
				<%
                	}
				%>
				<%
					if("addhotellandmark".equals(tabtype)){
				%>              
                <li><a href="hotellandmark!toadd.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>地标</span></a></li>
                <%
					}else if("edithotellankmark".equals(tabtype)){
                %>
                <li><a href="hotellandmark!toedit.action?id=<ww:property value="hotellandmark.id"/>&hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>地标</span></a></li>
                <%
					}else{
                %>
                <li><a href="hotellandmark.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>地标</span></a></li>
                <%
					}
                %>
                <%
                	if("addlinkman".equals(tabtype)){
                %>
                <li><a href="hotellinkman!toadd.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>联系人</span></a></li>
      			<%
                	}else if("editlinkman".equals(tabtype)){
      			%>
      			<li><a href="hotellinkman!toedit.action?id=<ww:property value="hotellinkman.id"/>&hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>联系人</span></a></li>
      			<%
                	}else{
      			%>
      			<li><a href="hotellinkman.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>联系人</span></a></li>
      			<%
                	}
      			%>
      			<%
      				if("addhotelimag".equals(tabtype)){
      			%>
                <li><a href="hotelimage!toadd.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>图片</span></a></li>
               <%
      				}else if("edithotelimag".equals(tabtype)){
               %>
               <li><a href="hotelimage!toedit.action?id=<ww:property value="hotelimage.id"/>&hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>图片</span></a></li>
               <%
      				}else{
               %>
               <li><a href="hotelimage.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>图片</span></a></li>
               <%
      				}
               %>
               <%
               	//	if("hotelstate".equals(tabtype)){
               %>
               <!--  <li><a href="hotelstate.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>状态</span></a></li>--> 
               <%
            	
              // 	}else if("edithotelstate".equals(tabtype)){
              %>
            <!--  	<li><a href="hotelstate!toedit.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>状态</span></a></li> -->
            	<%
              // 	}else{
            	%>
            <!-- 	<li><a href="hotelstate.action?hotelId=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>状态</span></a></li> -->
            	<%
              // 		}
            	%>
            	
            	<!--  
            	<%
               		if("addhotelprice".equals(tabtype)){
               	%>
                <li><a href="hotelprice!getAllpricebyid.action?hotelprice.hotelid=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>价格</span></a></li>
               <%
            	
               		}else{
               %>
            	<li><a href="hotelprice!getAllpricebyid.action?hotelprice.hotelid=<ww:property value="hotelId"/>&timestamp=<%=new java.util.Date().getTime() %>"><span>价格</span></a></li>
            	<%
               		}
            	%>
            	
            	-->
            </ul>
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
			if(length==undefined){
			
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

//省市
	var cities = new Array(); 
		<ww:iterator value="listCities">
			cities.push({id:<ww:property value="id"/>, name:'<ww:property value="name"/>', provinceId:<ww:property value="provinceid"/>}) ;
		</ww:iterator>
	function hotel_find_cities(provinceId) {
		var ddlCity = document.getElementById('ddlCity');
		for(var op in ddlCity.options) {
			ddlCity.remove(op);
		}
		for(var cityIndex in cities) {
			var city = cities[cityIndex] ;
			if(city.provinceId == provinceId) {
				var oOption = document.createElement("OPTION");
				oOption.innerHTML = city.name;
				oOption.value = city.id ;
				ddlCity.appendChild(oOption) ;
			}
		}
	}

</script>
