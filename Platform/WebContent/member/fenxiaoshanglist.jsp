<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>航空公司列表</title>
</head>

<link href="../style/base.css" rel="stylesheet" />
<link href="../style/text.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
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
				icon:"../images/menu/new.gif",
				handler : function(item){
					Ext.MessageBox.show({title:""+selectId,width:300, msg:'Changes saved successfully.',buttons: Ext.MessageBox.OK,fn:showResult});
					
				}
            }
			,{  
				id:"edit",
				text:"修改",
				icon:"../images/menu/edit.gif",
				handler : function(item){
					window.location.href="main.html";
					
				}
            },
			{
                id:"delete",
				text:"删除",
				icon:"../images/menu/delete.gif",
				handler : function(item){
					window.location.href="http://www.sina.com.cn";
					
				}
            },
			{
                id:"view",
				text:"查看详细信息",
				icon:"../images/menu/view.gif",
				handler : function(item){
					window.location.href="http://www.sina.com.cn";
					
				}
            },
			
			
			'-'
			
			,{
                  id:"up",
				text:"上移",
				icon:"../images/menu/up.gif",
				handler : function(item){
					window.location.href="http://www.sina.com.cn";
					
				}
            }
			,{
                 id:"down",
				text:"下移",
				icon:"../images/menu/down.gif",
				handler : function(item){
					window.location.href="http://www.sina.com.cn";
					
				}
            }
		]

		});




});
</script>

<body>
<div id="member">
<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" class="box">
  <tr>
    <td width="100%" height="29" class="box-bottom bg"><b class="anse">&nbsp;&nbsp;&nbsp;加盟商列表</b></td>
  </tr>
  <tr>
    <td  valign="top">


    <form name="form1" method="post" action="member.action">
        <table width="100%" border="0" cellpadding="0" cellspacing="0" align="center" ><!--
            <tr>
                <td width="100%" height="29" background="../images/jb.gif" style="border-bottom: 1px solid #99CBED">
                    <span class="font-blue-cu" style="color: #194B66">&nbsp;&nbsp;&nbsp;加盟商列表</span></td>
            </tr>
            --><tr>
                <td valign="top">
                    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td valign="top">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td>
                                            <table width="760" border="0" align="center" cellpadding="0" cellspacing="0" style="font-size: 12px;">
                                                <tr>
                                                    <td width="184" height="30" align="right">
                                                        用户名：</td>
                                                    <td width="198">
                                                        <span style="height: 71px">
                                                            <input id="Text2" style="width: 160px" name="s_company1" value="" /></span></td>
                                                    <td width="129" height="40" align="right">
                                                        公司名称：</td>
                                                    <td width="181">
                                                        <span style="height: 71px">
                                                            <input id="Text3" style="width: 160px" name="s_company" value="" /></span></td>
                                                    <td width="134" rowspan="2" align="center">
                                                        <input type="button"  class="button_d font-white" value="查&nbsp;&nbsp;询" onclick="searchOne()" /></td>
                                                </tr>
                                                <tr class="font-blue-xi">
                                                    <td height="28" align="right">
                                                        <span class="STYLE2">状态：</span></td>
                                                    <td>
                                                        <select><option>待审核</option><option>已审核</option><option>拒绝审核</option></select>                                                    </td>
                                                    <td height="28" align="right">
                                                        <span class="STYLE2">所在地区：</span></td>
                                                    <td width="181">
                                                        <select><option>北京</option><option>上海</option><option>广州</option></select>                                                    </td>
                                                </tr>
                                                <tr class="font-blue-xi">
                                                  <td height="28" align="right">联系人：</td>
                                                  <td><input id="Text2" style="width: 160px" name="s_company1" value="" /></td>
                                                  <td height="28" align="right">联系电话：</td>
                                                  <td><input id="Text2" style="width: 160px" name="s_company1" value="" /></td>
                                                  <td align="center">&nbsp;</td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="10px">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td align="center">
                                            <input type="button"  class="button_d font-white" value="查&nbsp;&nbsp;询" onclick="searchOne()" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="10px">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <table width="100%" height="40" border="0" cellspacing="0" cellpadding="0" class="lj"
                                                >
                                                <tr>
                                                    <td width="51%" align="center">
                                                    </td>
                                                    <td width="9%">
                                                    </td>
                                                    <td width="7%">
                                                        <a href="addcompany.html">
                                                            <div class="button_h font-red" >新增</div>
                                                        </a>
                                                    </td>
                                                    <td width="7%">
                                                        <a href="#" onclick="chakanItem()">
                                                            <div class="button_h font-red">
                                                                详细信息</div>
                                                        </a>
                                                    </td>
                                                    <td width="7%">
                                                        <a href="addcompany.html">
                                                            <div class="button_h font-red">
                                                                修改</div>
                                                        </a>
                                                    </td>
                                                    <td width="7%">
                                                        <a href="#" onclick="deleteItem()">
                                                            <div class="button_h font-red">
                                                                删除</div>
                                                        </a>
                                                    </td>
                                                    <td width="8%">
                                                     <a href="#" onclick="deleteItem()">
                                                            <div class="button_h font-red">
                                                                冻结</div>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">
                                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td width="100%">
                                            <table width="99%" id="Table1" border="1" align="center" class="table_color">
                                                <tbody>
                                                    <tr class="tbody_color">
                                                        <th width="54" height="25" class="table_color">
                                                            <input type="checkbox" name="all1" style="vertical-align: middle;" value="1" onclick="selectall1()" />全选</th>
                                                        <th class="table_color">
                                                            公司名称</th>
                                                        <th class="table_color">
                                                            联系人</th>
                                                        <th class="table_color">
                                                            地区</th>
                                                        <th class="table_color">
                                                            注册时间</th>
                                                             <th class="table_color">
                                                            类型</th>
                                                            
                                                    </tr>
                                                    <tr id="Tr1" align="center" onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
                                                        onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
                                                        <td class="table_color">
                                                            <input type="checkbox" name="selectid" value="362" /></td>
                                                        <td class="table_color">测试公司名称</td>
                                                        <td>
                                                            王大鹏</td>
                                                        <td class="table_color">华北</td>
                                                          <td class="table_color">
                                                            供应商</td>
                                                        <td class="table_color">
                                                            2010-01-01 12：00</td>
                                                    </tr>
                                                     <tr id="Tr1" align="center" onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
                                                        onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
                                                        <td class="table_color">
                                                            <input type="checkbox" name="selectid" value="362" /></td>
                                                        <td class="table_color">测试公司名称</td>
                                                        <td class="table_color">
                                                            王大鹏</td>
                                                        <td class="table_color">华北</td>
                                                          <td class="table_color">
                                                            分销商</td>
                                                        <td class="table_color">
                                                            2010-01-01 12：00</td>
                                                    </tr>
                                                     <tr id="Tr1" align="center" onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
                                                        onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
                                                        <td>
                                                            <input type="checkbox" name="selectid" value="362" /></td>
                                                        <td>测试公司名称</td>
                                                        <td>
                                                            王大鹏</td>
                                                        <td>华北</td>
                                                          <td>
                                                            供应商</td>
                                                        <td>
                                                            2010-01-01 12：00</td>
                                                    </tr>
                                                     <tr id="Tr1" align="center" onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
                                                        onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
                                                        <td>
                                                            <input type="checkbox" name="selectid" value="362" /></td>
                                                        <td>测试公司名称</td>
                                                        <td>
                                                            王大鹏</td>
                                                        <td>华北</td>
                                                          <td>
                                                            供应商</td>
                                                        <td>
                                                            2010-01-01 12：00</td>
                                                    </tr>
                                                     <tr id="Tr1" align="center" onmouseover="currentcolor=this.style.backgroundColor;this.style.backgroundColor='#e2f4fe',this.style.fontWeight='';"
                                                        onmouseout="this.style.backgroundColor=currentcolor,this.style.fontWeight='';">
                                                        <td>
                                                            <input type="checkbox" name="selectid" value="362" /></td>
                                                        <td>测试公司名称</td>
                                                        <td>
                                                            王大鹏</td>
                                                        <td>华北</td>
                                                          <td>
                                                            供应商</td>
                                                        <td>
                                                            2010-01-01 12：00</td>
                                                    </tr>
                                                     <tr id="Tr1" align="center" onmouseover="currentcolor=this.style.backgroundColor;this.className='colortrin',this.style.fontWeight='';" 
                      onmouseout="this.className='colortrout',this.style.fontWeight='';">
                                                        <td>
                                                            <input type="checkbox" name="selectid" value="362" /></td>
                                                        <td>测试公司名称</td>
                                                        <td>
                                                            王大鹏</td>
                                                        <td>华北</td>
                                                          <td>
                                                            供应商</td>
                                                        <td>
                                                            2010-01-01 12：00</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="43" align="center">
                                            共&nbsp;19&nbsp;条记录&nbsp;当前1/1页&nbsp; <a href="#" class="font_grey_001" onclick='javascript:go(1);'>
                                                首页</a>&nbsp;<span class="font_grey_001"> <strong>1</strong> <a href="#" class="font_grey_001"
                                                    onclick='javascript:go(1);'>尾页</a></span><script>function go(pageno){document.form1.action="member.action?pageinfo.pagenum="+pageno;document.form1.submit();}</script>

                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
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

