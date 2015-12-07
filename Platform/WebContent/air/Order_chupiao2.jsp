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
<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>机票业务：打印行程单</title>
  <link types="text/css" rel="stylesheet" href="style/base100108.css">
<link href="style/base.css" rel="stylesheet" />
<link href="style/text.css" rel="stylesheet" />
    
    <OBJECT ID="jatoolsPrinter" CLASSID="CLSID:B43D3361-D975-4BE2-87FE-057188254255" codebase="jatoolsP.cab#version=1,2,0,2"></OBJECT> 
     <script language="javascript" type="text/javascript">
     <!--
            function getSystemFonts(){
            var a=dlgHelper.fonts.count;
            var fArray = new Array();
	        var fonts=false;
            for (i = 1;i < dlgHelper.fonts.count;i++)
	        { 
                fArray[i] = dlgHelper.fonts(i);
		        if(fArray[i]=="TEE" || fArray[i]=="TEC" )
		        {
			        fonts=true;
			        break;
		        }
            } 
	        if (fonts==false)
	        {
		        if(confirm("系统中没有打印所需安体，您现在确认下载相关字体吗？\n下载字体请点击确认，否则请取消！" ))
		        {
			        window.open("fonts.rar");
		        }
	        }
        }
        
//        function over()
//        {
//            var SNN = document.getElementById("SerialNum").value;
//            if(SNN=="")
//            {
//                document.getElementById("SerialNum").value="请填写十位序号";
//            }
//        }
//        
        function onit()
        {
            var SNM = document.getElementById("txtZhekou").value;
            if(SNM=="请填写折扣(如0.4)")
            {
                document.getElementById("txtZhekou").value="";
            }
        }
        
        function onit1()
        {
             var SNM1 = document.getElementById("txtZhekou1").value;
            if(SNM1=="请填写折扣(如0.4)")
            {
                document.getElementById("txtZhekou1").value="";
            }
        }
        
        function overw()
        {
            var SNSN = document.getElementById("SerialNumSec").value;
            if(SNSN=="")
            {
                document.getElementById("SerialNumSec").value="请填写一位尾号";
            }
        }
        
        function onitw()
        {
            var SNSM = document.getElementById("SerialNumSec").value;
            if(SNSM=="请填写一位尾号")
            {
                document.getElementById("SerialNumSec").value="";
            }
        }
        function goPrintPage()
        {
         var HfFlag=document.getElementById("HfFlag");
            var txtZhekou=document.getElementById("txtZhekou");
             var txtZhekou1=document.getElementById("txtZhekou1");
            if(HfFlag.value=="1")
            {
               if(txtZhekou.value=="" ||txtZhekou.value=="请填写折扣(如0.4)")
               {
                 alert('请输入折扣信息！');
		        return;
               }
               
            }
            else if(HfFlag.value=="11")
            {
               if(txtZhekou1.value=="" ||txtZhekou1.value=="请填写折扣(如0.4)")
               {
                 alert('请输入折扣信息！');
		        return;
               }
            }
            var pagett="0";
	        var pslist = document.getElementsByName("ticketPerson");
	        var orderid = document.getElementById("orderid").value;
	        var zhekou = document.getElementById("Hfzhekou").value;
	         var zhekou1 = document.getElementById("Hfzhekou1").value;
	        //var sn = document.getElementById("SerialNum").value;
	        //var sns = document.getElementById("SerialNumSec").value;
	        //var sob = sn.length;
	        //var ssob = sns.length;
	        for(var i=0;i<pslist.length;i++)
	        {
	            if(pslist[i].checked)
	            {
	                pagett =  pslist[i].value;
	             }
	        }

	        if (pagett<1)
	        {
		        alert('请选择乘机人！');
		        return;
	        }
	        
//	        if (sob != 10)
//	        {
//	            alert('印刷序号必须为10位数字！')
//	            return;
//	        }
	        
	        //if (ssob !=1)
	        //{
	            //alert('印刷序号尾号必须为1位数字！')
	            //return;
	        //}
	       
	          window.open("PrintTick.aspx?orderid="+orderid+"&zhekou="+zhekou+"&zhekou1="+zhekou1+"&pid="+pagett, 'newwindow', 'height=650, width=900, top=10, left=150, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no');
	 

        }
        function initHiden()
        {
           var txtZhekou=document.getElementById("txtZhekou");
           var HfZhekou=document.getElementById("Hfzhekou");
           HfZhekou.value=txtZhekou.value;
           
           
           var txtZhekou1=document.getElementById("txtZhekou1");
           var HfZhekou1=document.getElementById("Hfzhekou1");
           HfZhekou1.value=txtZhekou1.value;
        }
        
         function goPrintPage1()
        {
         var HfFlag=document.getElementById("HfFlag");
            var txtZhekou=document.getElementById("txtZhekou");
             var txtZhekou1=document.getElementById("txtZhekou1");
            if(HfFlag.value=="1")
            {
               if(txtZhekou.value=="" ||txtZhekou.value=="请填写折扣(如0.4)")
               {
                 alert('请输入折扣信息！');
		        return;
               }
               
            }
            else if(HfFlag.value=="11")
            {
               if(txtZhekou1.value=="" ||txtZhekou1.value=="请填写折扣(如0.4)")
               {
                 alert('请输入折扣信息！');
		        return;
               }
            }
            var pagett="0";
	        var pslist = document.getElementsByName("ticketPerson");
	        var orderid = document.getElementById("orderid").value;
	        var zhekou = document.getElementById("Hfzhekou").value;
	        var zhekou1 = document.getElementById("Hfzhekou1").value;
	        //var sns = document.getElementById("SerialNumSec").value;
	        //var sob = sn.length;
	        //var ssob = sns.length;
	        for(var i=0;i<pslist.length;i++)
	        {
	            if(pslist[i].checked)
	            {
	                pagett =  pslist[i].value;
	             }
	        }


	        if (pagett<1)
	        {
		        alert('请选择乘机人！');
		        return;
	        }
	        
             window.open("passenger!tochupiao.action?orderinfoid="+<ww:property value="orderinfoid" />+'&ppid='+pagett);
            
            

        }
        
        function doPrint(how)
        {
	        var pagett="0";
	        var pslist = document.getElementsByName("ticketPerson");
	        var orderid = document.getElementById("orderid").value;
	        for(var i=0;i<pslist.length;i++)
	        {
	            if(pslist[i].checked)
	            {
	                pagett += ","+pslist[i].value;
	             }
	        }

	        if (pagett<1)
	        {
		        alert('请选择乘机人！');
		        return;
	        }
            if(typeof(jatoolsPrinter.page_div_prefix)=='undefined'){
                alert("请按页顶上的黄色提示下载ActiveX控件.如果没有提示请按以下步骤设置ie.\n 工具-> internet 选项->安全->自定义级别,设置 ‘下载未签名的 ActiveX ’为'启用'状态")
                return ;
            }
	        //打印文档对象
           var myreport ={ 
    				        documents: new Array("PrintTick.aspx?order=orderid&page="+pagett),
    				        copyrights  :    '杰创软件拥有版权 www.jatools.com'         // 版权声明必须
    			          };
            			  
           // 调用打印方法
            if(how == '打印预览...')
    	        jatoolsPrinter.printPreview(myreport );   // 打印预览
                         
   	        else if(how == '打印...')
   		        jatoolsPrinter.print(myreport ,true);   // 打印前弹出打印设置对话框
                        
   	        else 
   		        jatoolsPrinter.print(myreport ,false);       // 不弹出对话框打印

        }
         function checkLeave()
        { 
           form1.btnclosed.click();
    　　   //event.returnValue="确定离开当前页面吗？"; 
　　     } 
        -->
      </script>
</head>
<body onbeforeunload="checkLeave()" onLoad="getSystemFonts()"  ondragstart= "return false" onselectstart= "return false"><OBJECT ID="dlgHelper" CLASSID="clsid:3050f819-98b5-11cf-bb82-00aa00bdce0b" WIDTH="0px" HEIGHT="0px"></OBJECT>

    <form id="form1" runat="server">
    <input type="button" runat="server" id="btnclosed" style="display:none;width:0px;height:0px" />
    <!--行程单列表-->
    <div>
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
                                    </tr>
            <tr>
                
              <td class="main_maintdbg" colspan="4">
                    <table border="0" cellpadding="0" cellspacing="0" class="main_lanpan" width="99%">
                        <tr>
                            <td class="main_lanpanhead" style="width: 963px">行程单样图</td>

                        </tr>
                        <tr>
                          <td style="width: 963px">
                                                       
                        <table border="0" cellpadding="0" cellspacing="0" style="width: 100%">
                                    <tr>
                                        <td colspan="4" align="center"><img src="images/piaobig.jpg" width="783" height="380" align="absmiddle" />&nbsp;
                                        
                                            <asp:TextBox ID="SerialNumSec" runat="server" CssClass="headtextbox" Width="89px" text="请填写一位尾号" style="left: 863px; position: absolute; top: 86px; background-color: transparent" onfocus=onitw() onblur=overw() Visible="False"></asp:TextBox>
                                                    <asp:TextBox ID="txtZhekou" runat="server" Visible="false" text="请填写折扣(如0.4)" onfocus="onit();" onpropertychange="initHiden();" style="left: 553px; position: absolute;width:120px; top: 186px;"></asp:TextBox>
                                                    <asp:TextBox ID="txtZhekou1" runat="server" Visible="false" text="请填写折扣(如0.4)" onfocus="onit1();" onpropertychange="initHiden();" style="left: 553px; position: absolute;width:120px; top: 210px;"></asp:TextBox>
                                            <asp:TextBox ID="ComCode" runat="server" CssClass="headtextbox" Text="BJS887" Width="58px" style="left: 195px; position: absolute; top: 376px; background-color: transparent; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;"></asp:TextBox>
                                            <asp:TextBox ID="AgentCode" runat="server" CssClass="headtextbox" Text="08049086" Width="58px" style="left: 195px; position: absolute; top: 393px; background-color: transparent; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;"></asp:TextBox>
                                            <asp:TextBox ID="Company" runat="server" CssClass="headtextbox" Text="天河联盟" Width="196px" style="left: 384px; position: absolute; top: 380px; background-color: transparent; border-top-style: none; border-right-style: none; border-left-style: none; border-bottom-style: none;"></asp:TextBox></td>
                                    
                                    </tr>
                            <tr>
                                <td align="center" colspan="4">
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                </td>
                            </tr>
                            <tr>
                                <td align="center" colspan="4">
                                </td>
                            </tr>
                            </table>
                          </td>
                        </tr>
                    </table>
                    <table border="0" cellpadding="0" cellspacing="0" class="main_lanpan" width="99%">
                      <tr>
                        <td class="main_lanpanhead">乘机人选择 </td>
                      </tr>
                      <tr>
                        <td align="left"><table border="0" cellpadding="0" cellspacing="0" style="width: 100%">
                            <tr>
                              <td height="35" colspan="4" align="left"> 
                              <ww:iterator value="listPassenger">
                              <td align="left"><input name="ticketPerson" type="radio" value="<ww:property value="id" />" /><ww:property value="name" /></td>
                               </ww:iterator>
                              
                                  
                                  </td>
                            </tr>
                            <tr>
                              <td height="30" colspan="4" align="left">&nbsp;<!-- <input style="dispaly:none" type="button" value="页面预览(STAR专用打印)"  id="PrintGo" onclick="goPrintPage()" /> -->
                                  &nbsp;&nbsp;
                                  <input type="button" value="页面预览(普通打印机)"  id="Button1" onclick="goPrintPage1()" />&nbsp;
                                  <asp:HiddenField ID="orderid" runat="server" />
                                  <asp:HiddenField ID="Hfzhekou" runat="server" />
                                  <asp:HiddenField ID="HfVersion" runat="server" />
                                  <asp:HiddenField ID="Hfzhekou1" runat="server" />
                                  <asp:HiddenField ID="HfFlag" runat="server" />
                              </td>
                            </tr>
                        </table></td>
                      </tr>
                    </table></td>
                
            </tr>
            <tr>
                
                
            </tr>
        </table>
    
    </div>
    </form>
</body>
</html>