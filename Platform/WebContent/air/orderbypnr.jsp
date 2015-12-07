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
<title>无标题文档</title>
<link types="text/css" rel="stylesheet" href="style/base100108.css">
<script type="text/javascript" src="js/jquery1.3.2.js"></script>
<script type="text/javascript" src="js/PublicJs.js"></script>
<script language="javascript">
      var intTableID=-1;
       $(document).ready(function() {
          $("#divTotalInfo").html("<table width='100%' border='0' cellspacing='0' cellpadding='0' id='tbInfo'><tr><td width='65%' align='right'><div id='divNumber'></div></td><td width='45%' align='right'></td></tr></table>");
          showTotalPassInfo();
          BindCustomerInfo();
         });
         
        //添加新乘机人
       function addTable()
       {
         intTableID++; //Table 序号加1
         var strTable="";
         strTable+="<table width='100%' border='0' cellspacing='0' cellpadding='0'id='table_"+intTableID+"'>";
         strTable+="<tr >";
         strTable+="<td colspan='8' align='center'>";
         strTable+="<table width='98%' border='0' cellspacing='0' cellpadding='0'>";
         strTable+=" <tr><td width='40%' align='left'>新登机人<input type='hidden' value='' id='checkboxID_"+intTableID+"' /></td>";
         strTable+="<td width='23%'>";
         strTable+="";
         strTable+="</td>";
         strTable+="<td width='20%'>";
         strTable+="&nbsp;</td>";
         strTable+="<td width='8%' align='center'>";
         strTable+="</td>";
         strTable+="<td width='9%' align='center'>";
         strTable+="<a href='#' onclick='return delTable("+intTableID+");'><img src='images/del.gif' border='0' />删除</a></td>";
         strTable+=" </tr>";
         strTable+=" </table></td></tr>";
         strTable+="<tr class='GridViewRowStyle'>";
         strTable+="<td align='right'>姓名:</td>";
         strTable+="<td><input type='text' id='txtPassName"+intTableID+"' width='150px' onblur='BindPassInfoHiden();'></td>";
         strTable+="<td align='right'>登机人类型:</td>";
         strTable+="<td><select id='ddlPassType"+intTableID+"' width='100px' onchange='BindPassInfoHiden();showTotalPassInfo();'><option value='0'>成人</option><option value='2'>儿童</option><option value='3'>婴儿</option></select></td>";
         strTable+="<td align='right'>证件类型:</td>";
         strTable+="<td><select id='ddlIdType"+intTableID+"' width='100px' onchange='BindPassInfoHiden();'><option value='1'>身份证</option><option value='2'>护照</option><option value='6'>其他</option></select></td>";
         strTable+="<td align='right'>证件号码:</td>";
         strTable+=" <td><input type='text' id='txtIdNumber"+intTableID+"' width='30px' onblur='BindPassInfoHiden();'></td>";
         strTable+="</tr>";
         strTable+="<tr height='10px'><td></td></tr>";
         strTable+="</table>";
          //$("#newtable").html($("#newtable").html()+strTable); 
          //document.getElementById("newtable").innerHTML+=strTable;
          $("#newtable").append(strTable);
           //乘机人数量
          var rowscount = $("table[id*='table_']").length;
          document.getElementById("HfPersonCount").value=rowscount;
       }
       //删除乘机人
       function delTable(index)
       {
          if(index=="")
          {
            index=0;
          }
          var rowscount = $("table[id*='table_']").length;
          if(rowscount==1)
          {
             alert('登机人不能少于1位,此登机人不能删除！');
             return false;
          }
          else
          {
               //取消checkbox选中状态
                 var checkboxID=document.getElementById("checkboxID_"+index);
                 if(checkboxID.value!="")
                 {
                     var checkboxSel=document.getElementById("chbFPass_"+checkboxID.value);
                     checkboxSel.checked=false;
                     //是否选中标示位清零，未选中
                     document.getElementById("HfFlag_"+checkboxID.value).value=0;
                     document.getElementById("HfTbAddedId_"+checkboxID.value).value=0;
                  }
                //删除乘机人
              $("#table_"+index).remove();
              var count = $("table[id*='table_']").length;
              intTableID; //总记录数减1
              //alert("intTableID全局变量时"+intTableID)
              document.getElementById("HfPersonCount").value=count;
              //重新计算乘机人数量
              showTotalPassInfo();
              BindPassInfoHiden();
              return true;
          }
          
       } 
       //点击Checkbox绑定常用旅客
       function BindFPass(index)
       {
          var HfFidType=document.getElementById("HfFIDType_"+index);
          var HfFidNumber=document.getElementById("HfFIDNumber_"+index);
          var HfFName=document.getElementById("HfFPassName_"+index);
          var txtPassName0=document.getElementById("txtPassName0");
          var ddlIdType0=document.getElementById("ddlIdType0");
          var txtIdNumber0=document.getElementById("txtIdNumber0");
          var HfFlag=document.getElementById("HfFlag_"+index);
          var HfTbAddedId=document.getElementById("HfTbAddedId_"+index);
          if(HfFlag.value==0)
          {
              HfFlag.value=1;
              
          }
          else if(HfFlag.value==1)
          {
             HfFlag.value=0;
          }
          var count = $("table[id*='table_']").length;
          var checkSelCount=$("input:checked") .length;
          //乘机人姓名 隐藏控件  乘机人1|乘机人2
          var HfPassNameArr=document.getElementById("HfPassNameArr");//乘机人姓名 隐藏控件  乘机人1|乘机人2
          var HfPassType=document.getElementById("HfPassType");//乘机人类型 隐藏控件  乘机人类型1|乘机人类型2
          var HfIdType=document.getElementById("HfIdType"); //乘机人证件类型 隐藏控件  乘机人证件类型1|乘机人类型2
          var HfIdNumber=document.getElementById("HfIdNumber");//乘机人证件号 隐藏控件  乘机人证件号1|乘机人号2
         
          //CheckBox选中
          if(HfFlag.value==1)
          {
              //如何有空白行就隐藏并添加新行
              var tableid="";
              $("input[id*='txtPassName']").each(function(i)
                {
                      var varName=$(this).val();
                      if(varName=="")
                      {
                         var controlName=$(this).attr('id');
                         tableid=controlName.replace('txtPassName','');
                         //alert("tableid是"+tableid);
                         $("#table_"+tableid).remove();
                      }
                });
              addTable();
              var tbIndex=count; //当前table index
              //alert("intTableID是"+intTableID);
              var tbid=$("table[id*='table_']").length;
              var txtPassNamei=$("#txtPassName"+intTableID);
             
              var ddlIdTypei=document.getElementById("ddlIdType"+intTableID);
              var txtIdNumberi=document.getElementById("txtIdNumber"+intTableID);
              txtPassNamei.val(HfFName.value); 
             //$('#ddlIdTypei')[0].selectedIndex =HfFidType.value-1;
             if(HfFidType.value==1)
             {
                txtIdNumberi.value=HfFidNumber.value;
             }
             //把因为添加常用姓名添加的TableID,保存到HfTbAddedId隐藏控件
             HfTbAddedId.value=intTableID;
             //将CheckboxID保存到每个乘机人表格中的隐藏控件
             document.getElementById("checkboxID_"+intTableID).value=index; 
             //重新计算乘机人数量
             showTotalPassInfo();
          }
          else//CheckBox取消选中
          {
             if(count==1)
              {
                   if(HfTbAddedId.value!="")
                   {
                       var txtpass=document.getElementById("txtPassName"+HfTbAddedId.value);
                       var ddlIdTypenew=document.getElementById("ddlIdType"+HfTbAddedId.value);
                       var txtIdNumberNew=document.getElementById("txtIdNumber"+HfTbAddedId.value);
                       txtpass.value="";
                       //$('#ddlIdTypenew')[0].selectedIndex =0;
                       txtIdNumberNew.value="";
                   }
                   else
                   {
                      var txtpass=document.getElementById("txtPassName0");
                      var ddlIdTypenew=document.getElementById("ddlIdType0");
                      var txtIdNumberNew=document.getElementById("txtIdNumber0");
                      txtpass.value="";
                      //$('#ddlIdTypenew')[0].selectedIndex =0;
                      txtIdNumberNew.value="";
                   }
                   //重新计算乘机人数量
                   showTotalPassInfo();
              }
              else 
              {
                 //删除乘机人
                 delTable(HfTbAddedId.value);
                 //重新计算乘机人数量
                 showTotalPassInfo();
              }
          }
          BindPassInfoHiden(); 
       }
       //
       function BindPassInfoHiden()
       {
          //赋值前先把所有隐藏控件清空
          document.getElementById("HfPassNameArr").value="";
          document.getElementById("HfPassType").value="";
          document.getElementById("HfIdType").value="";
          document.getElementById("HfIdNumber").value="";
          //将所有的乘机人信息对隐藏控件赋值 ddlPassType ddlIdType txtIdNumber
          $("input[id*='txtPassName']").each(function(i)
          {
             document.getElementById("HfPassNameArr").value+=$(this).val()+",";
          });
          //乘机人类型
          $("select[id*='ddlPassType']").each(function(i)
          {
             document.getElementById("HfPassType").value+=$(this).val()+","; 
          });
          //证件类型
          $("select[id*='ddlIdType']").each(function(i)
          {
             document.getElementById("HfIdType").value+=$(this).val()+",";
          });
          //证件号
          $("input[id*='txtIdNumber']").each(function(i)
          {
             document.getElementById("HfIdNumber").value+=$(this).val()+",";
          });
          //创建确认页面乘机人信息
          var strHtml="<br /><ul id='passengerinfo_show' cdm='blk_passengerinfo' class='base_mainbox02 layoutfix'>";
          strHtml+="<li><h3 class='base_miantitle'>乘客信息<span class='base_annotate'>— 请准确填写乘客信息（姓名、证件号码），以免在办理登机手续时发生问题。</span></h3></li>";
          strHtml+="<li class='base_maincontent'><div id='boarderList'><div id='customer1' style='background: none repeat scroll 0% 0% rgb(226, 235, 252);'class='book_pginfo'>";
          //strHtml+="</div>";
          strHtml+="<table class='book_pgcontent' border='0' cellpadding='0' cellspacing='0'>";
          strHtml+="<tbody>";
          //循环出所有乘机人信息
          var varRcount=document.getElementById("HfPassNameArr").value.split(",");
          for(var i=0;i<varRcount.length-1;i++)
          {
              var passName=document.getElementById("HfPassNameArr").value.split(",")[i];
              var passType=document.getElementById("HfPassType").value.split(",")[i];
              if(passType=="0")
              {
                 passType="成人";
              }
              else if(passType=="2")
              {
                 passType="儿童";
              }
              else if(passType=="3")
              {
                 passType="婴儿";
              }
              var passIdType=document.getElementById("HfIdType").value.split(",")[i];
              if(passIdType=="1")
              {
                  passIdType="身份证";
              }
              else if(passIdType=="2")
              {
                  passIdType="护照";
              }
              else if(passIdType=="6")
              {
                 passIdType="其他"
              }
              var passIdNumber=document.getElementById("HfIdNumber").value.split(",")[i];
              strHtml+="<tr height='10px' class='book_pgcontent' border='0' cellpadding='0' cellspacing='0' ><td></td></tr>";
              strHtml+="<tr class='book_pgcontent' border='0' cellpadding='0' cellspacing='0' >";
              strHtml+="<td>&nbsp;&nbsp;</td><td align='right'><img src='images/jiajdd.gif' border='0'> 姓名:</td>";
              strHtml+="<td>"+passName+"</td><td>&nbsp;&nbsp;</td>";
              strHtml+="<td>&nbsp;&nbsp;</td><td align='right'>登机人类型:</td>";
              strHtml+="<td>"+passType+"</td><td>&nbsp;&nbsp;</td>";
              strHtml+="<td>&nbsp;&nbsp;</td><td align='right'>证件类型:</td>";
              strHtml+="<td>"+passIdType+"</td><td>&nbsp;&nbsp;</td>";
              strHtml+="<td>&nbsp;&nbsp;</td><td align='right'>证件号码:</td>";
              strHtml+="<td>"+passIdNumber+"</td><td>&nbsp;&nbsp;</td>";
              strHtml+="</tr>";
              strHtml+="<tr height='10px'><td></td></tr>";
          }
          strHtml+="<tr height='10px'><td></td></tr>";
          strHtml+="</tbody></table>";
          strHtml+="</div></div></li></ul>";
          document.getElementById("divConfirmInfo").innerHTML=strHtml;    
          showTotalPassInfo();    
       }
       
       //弹出窗口
         $(function(){
        //显示
        $("#addPass").click(function(){
          //document.getElementById("ddlSendType").style.display="none";
          //dialog("添加登机人","id:testID","300","auto","id");
          addTable();
        });
        });
        //关闭窗口
        function dialogclose()
        {
            document.getElementById("ddlSendType").style.display="block";
            $("#floatBox").hide("slow");
            $("#floatBoxBg").hide("slow");
        }
            
             //添加乘机人
        function dialogChange()
        {
             dataCheck();
             intTableID++; //Table 序号加1
             var strTable="";
             strTable+="<table width='100%' border='0' cellspacing='0' cellpadding='0'id='table_"+intTableID+"'>";
             strTable+="<tr class='GridViewHeaderStyle'>";
             strTable+="<td colspan='8' align='center'>";
             strTable+="<table width='98%' border='0' cellspacing='0' cellpadding='0'>";
             strTable+=" <tr><td width='40%' align='left'>新登机人<input type='hidden' value='' id='checkboxID_"+intTableID+"' /></td>";
             strTable+="<td width='23%'>";
             strTable+="";
             strTable+="</td>";
             strTable+="<td width='20%'>";
             strTable+="&nbsp;</td>";
             strTable+="<td width='8%' align='center'>";
             strTable+="</td>";
             strTable+="<td width='9%' align='center'>";
             strTable+="<a href='#' onclick='return delTable("+intTableID+");'>删除</a></td>";
             strTable+=" </tr>";
             strTable+=" </table></td></tr>";
             strTable+="<tr >";
             strTable+="<td align='right'>姓名:</td>";
             strTable+="<td><input type='text' id='txtPassName"+intTableID+"' value='"+document.getElementById("HfPassInfo").value+"' width='150px' onblur='BindPassInfoHiden();'></td>";
             strTable+="<td align='right'>登机人类型:</td>";
             var varselect="";
             if(document.getElementById("HfPassTypeInfo").value==1)
             {
                varselect+="<option value='0' selected>成人</option>";
             }
             else
             {
                varselect+="<option value='0' >成人</option>";
             }
             if(document.getElementById("HfPassTypeInfo").value==2)
             {
                varselect+="<option value='2' selected>儿童</option>";
             }
             else
             {
                varselect+="<option value='2' >儿童</option>";
             }
             if(document.getElementById("HfPassTypeInfo").value==3)
             {
                varselect+="<option value='3' selected>婴儿</option>";
             }
             else
             {
                varselect+="<option value='3' >婴儿</option>";
             }
             var varIdTypestr="";
             if(document.getElementById("HfIdTypeInfo").value==1)
             {
                 varIdTypestr+="<option value='1' selected>身份证</option>";
             }
             else if(document.getElementById("HfIdTypeInfo").value==2)
             {
                varIdTypestr+="<option value='2' selected>护照</option>";
             }
             else if(document.getElementById("HfIdTypeInfo").value==6)
             {
                varIdTypestr+="<option value='6' selected>其他</option>";
             }
             else
             {
                 varIdTypestr+="<option value='1'>身份证</option>";
             }
             
             strTable+="<td><select id='ddlPassType"+intTableID+"' width='100px' onchange='BindPassInfoHiden();'>"+varselect+"</select></td>";
             
             strTable+="<td align='right'>证件类型:</td>";
             strTable+="<td><select id='ddlIdType"+intTableID+"' width='100px' onchage='BindPassInfoHiden();'>"+varIdTypestr+"</select></td>";
             strTable+="<td align='right'>证件号码:</td>";
             strTable+=" <td><input type='text' id='txtIdNumber"+intTableID+"' value='"+document.getElementById("HfIdNumberInfo").value+"' onblur='BindPassInfoHiden();' width='30px'></td>";
             strTable+="</tr>";
             strTable+="<tr height='10px'><td></td></tr>";
             strTable+="</table>";
             $("#newtable").html($("#newtable").html()+strTable);
             var count = $("table[id*='table_']").length;
             document.getElementById("HfPersonCount").value=count;
             //计算总的乘机人数
             showTotalPassInfo();
             BindPassInfoHiden();
             dialogclose();
        }
         //添加单个乘机人
        function dialogChangeSin()
        {
             checkdata();
             intTableID++; //Table 序号加1
             var strTable="";
             strTable+="<table width='100%' border='0' cellspacing='0' cellpadding='0'id='table_"+intTableID+"'>";
             strTable+="<tr >";
             strTable+="<td colspan='8' align='center'>";
             strTable+="<table width='98%' border='0' cellspacing='0' cellpadding='0'>";
             strTable+=" <tr><td width='40%' align='left'>新登机人<input type='hidden' value='' id='checkboxID_"+intTableID+"' /></td>";
             strTable+="<td width='23%'>";
             strTable+="";
             strTable+="</td>";
             strTable+="<td width='20%'>";
             strTable+="&nbsp;</td>";
             strTable+="<td width='8%' align='center'>";
             strTable+="</td>";
             strTable+="<td width='9%' align='center'>";
             strTable+="<a href='#' onclick='return delTable("+intTableID+");'>删除</a></td>";
             strTable+=" </tr>";
             strTable+=" </table></td></tr>";
             strTable+="<tr >";
             strTable+="<td align='right'>姓名:</td>";
             strTable+="<td><input type='text' id='txtPassName"+intTableID+"' value='"+document.getElementById("HfPassInfo").value+"' width='150px' onblur='BindPassInfoHiden();'></td>";
             strTable+="<td align='right'>登机人类型:</td>";
             var varselect="";
             if(document.getElementById("HfPassTypeInfo").value==1)
             {
                varselect+="<option value='0' selected>成人</option>";
             }
             else
             {
                varselect+="<option value='0' >成人</option>";
             }
             if(document.getElementById("HfPassTypeInfo").value==2)
             {
                varselect+="<option value='2' selected>儿童</option>";
             }
             else
             {
                varselect+="<option value='2' >儿童</option>";
             }
             if(document.getElementById("HfPassTypeInfo").value==3)
             {
                varselect+="<option value='3' selected>婴儿</option>";
             }
             else
             {
                varselect+="<option value='3' >婴儿</option>";
             }
             var varIdTypestr="";
             if(document.getElementById("HfIdTypeInfo").value==1)
             {
                 varIdTypestr+="<option value='1' selected>身份证</option>";
             }
             else if(document.getElementById("HfIdTypeInfo").value==2)
             {
                varIdTypestr+="<option value='2' selected>护照</option>";
             }
             else if(document.getElementById("HfIdTypeInfo").value==6)
             {
                varIdTypestr+="<option value='6' selected>其他</option>";
             }
             else
             {
                 varIdTypestr+="<option value='1'>身份证</option>";
             }
             
             strTable+="<td><select id='ddlPassType"+intTableID+"' width='100px' onchange='BindPassInfoHiden();showTotalPassInfo();'>"+varselect+"</select></td>";
             strTable+="<td align='right'>证件类型:</td>";
             strTable+="<td><select id='ddlIdType"+intTableID+"' width='100px' onchage='BindPassInfoHiden();'>"+varIdTypestr+"</select></td>";
             strTable+="<td align='right'>证件号码:</td>";
             strTable+=" <td><input type='text' id='txtIdNumber"+intTableID+"' value='"+document.getElementById("HfIdNumberInfo").value+"' onblur='BindPassInfoHiden();' width='30px'></td>";
             strTable+="</tr>";
             strTable+="<tr height='10px'><td></td></tr>";
             strTable+="</table>";
             $("#newtable").html($("#newtable").html()+strTable);
             var count = $("table[id*='table_']").length;
             document.getElementById("HfPersonCount").value=count;
             //计算总的乘机人数
             showTotalPassInfo();
             BindPassInfoHiden();
             dialogclose();
        }
        //计算总乘机人并显示总价格
        function showTotalPassInfo()
        {          
           //成人人数
           var adltNum=0;
           //儿童人数
           var childNum=0;
           //婴儿人数
           var babyNum=0;
           
           //计算成人儿童婴儿各有多少人
           $("select[id*='ddlPassType']").each(function(i)
              {
                 if($(this).val()=="0")
                 {  
                     adltNum++;
                 }
                 else if($(this).val()=="2")
                 {
                    childNum++;
                 }
                 else if($(this).val()=="3")
                 {
                    babyNum++;
                 }
              });
            document.getElementById("HfAdultNum").value=adltNum;
            document.getElementById("HfChildNum").value=childNum;
            document.getElementById("HfBabyNum").value=babyNum;
           var totalPNum= document.getElementById("HfPersonCount").value;
           //计算总金额
           var HfTravelType=document.getElementById("HfTravelType");
           if(HfTravelType.value=="1")  //单程
           {
               var priceSingle=document.getElementById("hidPriceSin").value; //票面价
               var priceAirPortSin=document.getElementById("hidairportFeeSin").value; //机建费
               var priceFuelSin=document.getElementById("hidfuelFeeSin").value; //燃油费
               var priceTotalSin=document.getElementById("hidtotalSin").value; //单张总价
               var ypricesingle=document.getElementById("hidYPriceSin").value; //全价价格
               //儿童票面价
               var childpriceSingle=Math.round(ypricesingle/2*0.1)*10;//儿童票面价
               //儿童燃油费
               var childFuelSingle=Math.round(priceFuelSin/2*0.1)*10;//儿童燃油费
               //婴儿票面价
               var babypriceSingle=Math.round(ypricesingle*0.1*0.1)*10;//婴儿票面价
               var TotalPriceSin=(parseInt(priceSingle)+parseInt(priceAirPortSin)+parseInt(priceFuelSin))*parseInt(adltNum)+(parseInt(childpriceSingle)+parseInt(childFuelSingle))*parseInt(childNum)+parseInt(babypriceSingle)*parseInt(babyNum); //总票价

               
               var TotalFuelSin=(parseInt(priceFuelSin))*parseInt(adltNum)+(parseInt(childFuelSingle))*parseInt(childNum); //总燃油
               var TotalAirportSin=parseInt(priceAirPortSin)*parseInt(adltNum); //总机建
               var TotalPrice=parseInt(priceSingle)*parseInt(adltNum)+parseInt(childpriceSingle)*parseInt(childNum)+parseInt(babypriceSingle)*parseInt(babyNum); //总票面价
               //隐藏控件赋值
               document.getElementById("strTotalPriceOne").value=TotalPrice+","+TotalFuelSin+","+TotalAirportSin;
               document.getElementById("HfTotalPrice").value=TotalPrice;  //总票面价赋值
               document.getElementById("HfTotalFuelFee").value=TotalFuelSin; //总燃油赋值
               document.getElementById("HfTotalAirportFee").value=TotalAirportSin; //总机建费赋值
               document.getElementById("divNumber").innerHTML="<b>共"+totalPNum+"人, 总金额：<font color='red'>"+TotalPriceSin+"RMB</font>(成人价："+priceTotalSin+"&nbsp;儿童价："+(childpriceSingle+childFuelSingle)+"&nbsp;婴儿价："+babypriceSingle+")(含税费)</b>";
           }
           else if(HfTravelType.value=="2")  //往返
           {
               var priceTotalone=document.getElementById("hidtotalSin").value; //去程单张总价
               var priceTotaltwo=document.getElementById("hidtotalTwo").value; //去程单张总价
               var yprictone=document.getElementById("hidYPriceSin").value;
               var ypricetwo=document.getElementById("hidYPriceTwo").value;
               var airportPriceone=document.getElementById("hidairportFeeSin").value;
                //儿童燃油费one
               var childFuelone=Math.round(airportPriceone/2*0.1)*10;//儿童燃油费one
               
               var airportPricetwo=document.getElementById("hidairportFeeTwo").value;
               //儿童燃油费two
               var childFueltwo=Math.round(airportPricetwo/2*0.1)*10;//儿童燃油费two
               
               var TotalairportPrice=(parseInt(airportPriceone)+parseInt(airportPricetwo))*parseInt(adltNum); //总机建费
               var FuelPriceone=document.getElementById("hidfuelFeeSin").value;
               var FuelPricetwo=document.getElementById("hidfuelFeeTwo").value;
               var TotalFuelPrice=(parseInt(FuelPriceone)+parseInt(FuelPricetwo))*parseInt(adltNum)+(parseInt(childFuelone)+parseInt(childFueltwo))*parseInt(childNum); //总燃油
               ////////////去程
               var Priceone=document.getElementById("hidPriceSin").value;
                //儿童票面价one
               var childpriceone=Math.round(yprictone/2*0.1)*10;//儿童票面价
               //婴儿票面价one
               var babypriceone=Math.round(yprictone*0.1*0.1)*10;//婴儿票面价
               
               ///////////返程
               var Pricetwo=document.getElementById("hidPriceTwo").value;
                //儿童票面价two
               var childpricetwo=Math.round(ypricetwo/2*0.1)*10;//儿童票面价
               //婴儿票面价two
               var babypricetwo=Math.round(ypricetwo*0.1);//婴儿票面价
               //一个儿童总价格
               var intOneChildP=childFuelone+childFueltwo+childpriceone+childpricetwo;
               //一个婴儿总价格
               var intOneBabyP=babypriceone+babypricetwo;
               var TotalTicketPrice=(parseInt(Priceone)+parseInt(Pricetwo))*parseInt(adltNum)+(parseInt(childpriceone)+parseInt(childpricetwo))*parseInt(childNum)+(parseInt(babypriceone)+parseInt(babypricetwo))*parseInt(babyNum); //总票面价
               var TotalPriceSin=TotalairportPrice+TotalFuelPrice+TotalTicketPrice; //机票所有价格总票价
               //隐藏控件赋值
               var fuelonefee=parseInt(parseInt(FuelPriceone)*parseInt(adltNum))+ parseInt(parseInt(childFuelone)*parseInt(childNum));
               var fueltwofee=parseInt(parseInt(FuelPricetwo)*parseInt(adltNum))+ parseInt(parseInt(childFueltwo)*parseInt(childNum));
               document.getElementById("strTotalPriceOne").value= (parseInt(Priceone))*parseInt(adltNum)+(parseInt(childpriceone))*parseInt(childNum)+(parseInt(babypriceone))*parseInt(babyNum)+","+fuelonefee+","+(parseInt(airportPriceone))*parseInt(adltNum);
               document.getElementById("strTotalPriceTwo").value= (parseInt(Pricetwo))*parseInt(adltNum)+(parseInt(childpricetwo))*parseInt(childNum)+(parseInt(babypricetwo))*parseInt(babyNum)+","+ fueltwofee +","+(parseInt(airportPricetwo))*parseInt(adltNum);
         
               document.getElementById("HfTotalPrice").value=TotalTicketPrice;  //总票价赋值
               document.getElementById("HfTotalFuelFee").value=TotalFuelPrice; //总燃油赋值
               document.getElementById("HfTotalAirportFee").value=TotalairportPrice; //总机建费赋值
               document.getElementById("divNumber").innerHTML="<b>共"+totalPNum+"人, 总金额：<font color='red'>"+TotalPriceSin+"RMB</font>(含税费)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>";
           }
        }
         function BindCustomerInfo()
        {
           document.getElementById("txtPassName0").value=$("#HfCustomerName").val();
           document.getElementById("txtIdNumber0").value=$("#hfCustomerCardId").val();
        }
        //下一步 显示确认信息页面
        function showConfirm()
        {
           $("#contactInfo").hide();
           $("#passengerinfo").hide();
           $("#divContact").show();
           $("#divConfirmInfo").show();
           $("#btnprev").show();
           $("#btnnext").hide();
           $("#btnsubmit").show();
           var strContactName="";
           if($("#contactname").val()!="")
           {
              strContactName=$("#contactname").val();
           }
           else
           {
               strContactName="无";
           }
           var strMobile="";
           if($("#contactmobile").val()!="")
           {
              strMobile=$("#contactmobile").val();
           }
           else
           {
               strMobile="无";
           }
           var strTel="";
           if($("#contacttel").val()!="")
           {
              strTel=$("#contacttel").val();
           }
           else
           {
               strTel="无";
           }
           var strFax="";
           if($("#contactfax").val()!="")
           {
               strFax=$("#contactfax").val();
           }
           else
           {
              strFax="无";
           }
           var strEmail="";
           if($("#contactemail").val()!="")
           {
              strEmail=$("#contactemail").val();
           }
           else
           {
               strEmail="无";
           }
           var strGetTicket="";
           if(document.form1.receipt1.checked == true)
           {
              strGetTicket="<font color='red'>自取</font>";
           }
           else if(document.form1.receipt2.checked == true)
           {
              strGetTicket="<font color='red'>送票上门</font>";
           }
           
           var strAddress="";
           if($("#addresa").val()!="")
           {
              strAddress=$("#addresa").val();
           }
           else
           {
               strAddress="无";
           }               
           var obj=document.getElementById('notetype');
           var index=obj.selectedIndex;
           var strNoteType =obj.options[index].text;
           
           var strCHtml="";
           strCHtml+="<ul id='contactInfo_show' class='base_mainbox02 layoutfix' cdm='blk_contactinfo'>";
           strCHtml+="<li><h3 class='base_miantitle'>联系人信息<span class='base_annotate'>— 请准确填写联系人信息（手机号码，E-mail），以便我们与您联系。</span></h3></li>";
           strCHtml+="<li class='base_maincontent'>";
           strCHtml+="<table width='100%' border='0' cellpadding='0' cellspacing='0'>";
           strCHtml+="<tbody style='font-weight: normal'>";
           strCHtml+="<tr><th height='23' style='width: 77px;'><dfn>*</dfn>联系人：</th><td style='width: 340px;'>"+strContactName+"</td><td>&nbsp;</td></tr>";
           strCHtml+="<tr><th height='21'><dfn>*</dfn>手机号码：</th><td>"+strMobile+"</td><td id='' rowspan='2' class='base_txtgray'></td></tr>";
           strCHtml+="<tr><th height='22'>联系电话：</th><td>"+strTel+"</tr>";
           strCHtml+="<tr><th height='22'>传真号码：</th><td>"+strFax+"</td><td>&nbsp;</td></tr>";
           strCHtml+="	<tr><th height='22'><dfn>*</dfn>E-mail：</th><td>"+strEmail+"</td><td>&nbsp;</td></tr>";
           strCHtml+="<tr style=''><th height='23'>确认方式：</th><td>"+strNoteType+"</td><td>&nbsp;</td></tr>";
           strCHtml+="<tr><th height='24'>送票方式：</th><td>"+strGetTicket+"</td><td>&nbsp;</td></tr>";
           strCHtml+="<tr><th>送票地址：</th><td colspan='3'>"+strAddress+"</td></tr>";
           strCHtml+="</tbody></table></li></ul>";
           $("#divContact").html(strCHtml);
        }
        //上一步
        function showPrev()
        {
           $("#contactInfo").show();
           $("#passengerinfo").show();
           $("#divContact").hide();
           $("#divConfirmInfo").hide();
           $("#btnprev").hide();
           $("#btnsubmit").hide();
           $("#btnnext").show();
        }
        function fromsubmit()
        {
    	  document.form1.submit();
        }
        //数据验证
        function dataCheck()
        {
           var varretrun=true;
           var varretrun1=true;
           var varretrun2=true;
           var index="";
           var j="";
           //对乘机人信息进行验证
              $("input[id*='txtPassName']").each(function(i)
              {
                 if($(this).val()=="")
                 {
                     varretrun=false;
                     index=i+1;
                     j=i;
                 }
                 else
                 {
                     var regnamecnen=/^[\u4E00-\u9FA5]{1,16}[a-zA-Z]{0,20}[0-9]{0,8}$/; //中文
	                 var regnameen = /^[a-zA-Z]{1,20}[\/]{1}[a-zA-Z]{1,20}[0-9]{0,8}$/;//英文名
	                 if(!regnamecnen.exec($(this).val()) && !regnameen.exec($(this).val()))
	                 {
	                     varretrun2=false;
	                      index=i+1;
                          j=i;
	                 }
                 }
              });
              if(varretrun==false)
              {
                  alert("请填写第"+index+"位登机人姓名！");
                   $("#txtPassName"+j).focus();
                   return false;
              }
              if(varretrun2==false)
              {
                  alert("请检查第"+index+"位登机人姓名格式，英文姓名格式：len/ott！");
                   $("#txtPassName"+j).focus();
                   return false;
              }
              //证件号
              $("input[id*='txtIdNumber']").each(function(i)
              {
                 if($(this).val()=="")
                 {
                     varretrun=false;
                     index=i+1;
                     j=i;
                 }
                   else
                 {
                    //if($("#ddlIdType"+i).val()=="1")
                    //{
                        //if(shenfen($(this).val()))
                        //{
                           // varretrun1=false;
                            //index=i+1;
                            //j=i;
                       // }
                   // }
                 }
              });
              if(varretrun==false)
              {
                  alert("请填写第"+index+"位登机人证件号！");
                   $("#txtIdNumber"+j).focus();
                   return false;
              }
             if($("#contactname").val() == "")
             {
                alert("请输入联系人姓名！");
                $("#contactname").focus();
                 return true;
             }
            if($("#contactmobile").val() != "")
            {
               if(!IsMobile($("#contactmobile").val()))
                {
                   alert("您输入的联系人手机号格式不正确！");
                    $("#contactmobile").focus();
                    return true;
                }
            }
            else
            {
                alert("请输入联系人手机号！");
                $("#contactmobile").focus();
                 return true;
            } 
            if($("#contacttel").val() != "")
            { 
                if(!IsTelephone($("#contacttel").val()))
                {
                    alert("您输入的联系人座机号格式不正确！");
                     $("#txtContactTel").focus();
                     return true;
                }
            }  
             if($("#contactname").val() == "")
             {
                alert("请输入联系人姓名！");
                $("#contactname").focus();
                 return true;
             }
             else
             { 
               if($("#contactemail").val() != "")
                {
                 if(!IsEMail($("#contactemail").val()))
                  {
                    alert("您输入的电子邮件格式不正确！");
                    $("#contactemail").focus();
                    return true;
                  }
               }
             }
              showConfirm();
        }
        
</script>
<script type="text/javascript">
</script>
</head>

<body>
<form action="orderinfo!add.action" method="post" name="form1">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center" class="box">
	<tr>
		<td width="100%" height="29" class="bg"><b class="anse">&nbsp;&nbsp;&nbsp;填写订单信息</b></td>
	</tr>
</table>
<div class="base_b base_bgcolor02"><!--航班和乘客信息-->

<div class="flt_silhouette" cdm="blk_ticketinfo"><span
	class="flt_shadow_t"></span><span class="flt_shadow_m">
<div class="flt_shadow_content">
<div class="flt_info" cdm="blk_flightinfo">
<ul class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">航程信息<span class="base_annotate">
	— 请确认您选择的航程信息</span></h3>
	</li>
	<table id="tbTravel" class="book_pgcontent" width="100%" border="0"
		cellpadding="0" cellspacing="0">
		<tbody>
			<tr>
				<td style="width: 120px;">
				<div class="pubFlights_ca"><img src="images/airComlogo/CA.gif">国航
				CA155</div>
				</td>

				<td style="width: 104px;">所选舱位<br> ( 100.0折)Y舱
				</td>

				<td style="width: 76px; text-align: center;">机型 <span
					cdm="jpi_flighttype" class="base_txtdiv" mod="jmpInfo"
					mod_jmpinfo_page="fltDomestic_planeType.asp?CraftType=738">
				733 </span></td>
				<td style="width: 66px;"><span cdm="jpi_exchangerefund"
					class="base_txtdiv" mod="jmpInfo"
					mod_jmpinfo_page="flight_policy_tab" mod_jmpinfo_content="">退改签</span></td>
				<td>2010-03-24 07:30:00 <img src="images/plane1.gif" />北京首都国际机场
				起飞 <br> 2010-03-24 09:35:00 
				<img src="images/plane2.gif" />上海浦东机场 到达</td>
				<td class="base_txtgray" style="width: 250px;"><span
					class="base_price01"><b><dfn>&#165;</dfn>1,230.00</b></span>/成人<br>
				（含税费）
				<input type='hidden' id='hidPriceSin' value='1130.0' /> <input
					type='hidden' id='hidYPriceSin' value='1130.0' /> <input
					type='hidden' id='hidairportFeeSin' value='50.0' /> <input
					type='hidden' id='hidfuelFeeSin' value='50.0' /> <input
					type='hidden' id='hidtotalSin' value='1,230.00' /></td>
			</tr>

			<tr height='1px'>
				<td colspan='6'>
				<hr class='hr1' />
				</td>
			</tr>
			<tr>
				<td class="base_txtgray" colspan="6"><span class="base_price01"><b>
				<div id="divTotalInfo"></div>
				</b></span></td>
			</tr>
		</tbody>
	</table>
</ul>
</div>
</div>
</span><span class="flt_shadow_f"></span></div>

<!--登机人信息-->

<ul id="passengerinfo" cdm="blk_passengerinfo"
	class="base_mainbox02 layoutfix">
	<li>
	<h3 class="base_miantitle">乘客信息<span class="base_annotate">
	— 请准确填写乘客信息（姓名、证件号码），以免在办理登机手续时发生问题。</span></h3>
	</li>
	<li class="base_maincontent">
	<div id="boarderList">
	<div id="customer1"
		style="background: none repeat scroll 0% 0% rgb(226, 235, 252);"
		class="book_pginfo">
	<table class="book_pgcontent" border="0" cellpadding="0"
		cellspacing="0">
		<tbody>
			<tr>
				<td widht="30px">&nbsp;</td>
				<td><a id='addPass' style="cursor: hand"><img
					src="images/add.gif" border="0"><b>添加1位乘客</b></a></td>
			</tr>
			<tr>
				<td widht="30px">&nbsp;</td>
				<td>
				<div>
				<table width='100%' border='0' cellspacing='0' cellpadding='0'
					id='table_0'>
					<tr>
						<td colspan='8' align='center'>
						<table width='98%' border='0' cellspacing='0' cellpadding='0'>
							<tr>
								<td width='40%' align='left'>新登机人<input type='hidden'
									value='' id='checkboxID_0' /></td>
								<td width='23%'></td>
								<td width='20%'>&nbsp;</td>
								<td width='8%' align='center'></td>
								<td width='9%' align='center'><a href='#'
									onclick='javascript:return delTable(0);'>删除</a></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr class='GridViewRowStyle'>
						<td align='right'>姓名:</td>
						<td><input type='text' runat='server' id='txtPassName0'
							width='150px' onblur='BindPassInfoHiden();'></td>
						<td align='right'>登机人类型:</td>
						<td><select id='ddlPassType0' width='100px'
							onchange='BindPassInfoHiden();showTotalPassInfo();'>
							<option value='0'>成人</option>
							<option value='2'>儿童</option>
							<option value='3'>婴儿</option>
						</select></td>
						<td align='right'>证件类型:</td>
						<td><select id='ddlIdType0' width='100px'
							onchange='BindPassInfoHiden();'>
							<option value='1'>身份证</option>
							<option value='2'>护照</option>
							<option value='6'>其他</option>
						</select></td>
						<td align='right'>证件号码:</td>
						<td><input type='text' id='txtIdNumber0' width='30px'
							onblur='BindPassInfoHiden();'></td>
					</tr>
					
				</table>
				<div id='newtable'></div>
				</div>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
	</div>
	</li>
</ul>


<!--联系人信息-->

<ul id="contactInfo" class="base_mainbox02 layoutfix"
	cdm="blk_contactinfo">
	<li>
	<h3 class="base_miantitle">联系人信息<span class="base_annotate">
	— 请准确填写联系人信息（手机号码，E-mail），以便我们与您联系。</span></h3>
	</li>
	<li class="base_maincontent">
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tbody style="font-weight: normal">
			<tr>
				<th height="23" style="width: 77px;"><dfn>*</dfn>联系人：</th>
				<td style="width: 340px;"><input name="contactname"
					id="contactname" style="width: 165px;" type="text" value=""></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<th height="21"><dfn>*</dfn>手机号码：</th>
				<td><input name="contactmobile" id="contactmobile"
					style="width: 165px;" type="text" value=""></td>
				<td id="" rowspan="2" class="base_txtgray">此处手机号码、联系电话至少选填一项</td>
			</tr>
			<tr>
				<th height="22">联系电话：</th>
				<td><input name="contacttel" id="contacttel"
					style="width: 165px; color: gray;" type="text" value="" />
			</tr>
			<tr>
				<th height="22">传真号码：</th>
				<td><input name="contactfax" id="contactfax"
					style="width: 165px; color: gray;" type="text" value=""></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<th height="22"><dfn>*</dfn>E-mail：</th>
				<td><input value="" name="contactemail" id="contactemail"
					style="width: 165px; color: gray;" type="text"></td>
				<td>&nbsp;</td>
			</tr>
			<tr style="">
				<th height="23">确认方式：</th>
				<td><select id="notetype" name="notetype" style="width: 169px;">
					<option selected="selected" value="0">不用确认</option>
					<option value="1">手机短消息确认</option>
					<option value="2">电话确认</option>
					<option value="3">Email确认</option>
					<option value="4">传真确认</option>
				</select></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<th height="24">送票方式：</th>
				<td><input name="receipt" id="receipt1" type="radio"
					checked="checked" value="1">自取<input name="receipt"
					id="receipt2" type="radio" value="2">送票上门</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<th>送票地址：</th>
				<td colspan="3"><input name="addresa" id="addresa"
					style="width: 355px; color: gray;" type="textarea" value=""></td>
			</tr>
		</tbody>
	</table>
	</li>
</ul>
<div id="divConfirmInfo" style="display: none"></div>
<div id="divContact" style="display: none"></div>

<table width="100%">
	<tr>
		<td align="center"><input value="上一步" id="btnprev"
			style="display: none; background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
			onclick="showPrev();" type="button"><input value="下一步"
			id="btnnext"
			style="background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
			onclick="return dataCheck();" type="button"><input value="提交"
			id="btnsubmit"
			style="display: none; background: url(images/hout3.gif); cursor: hand; width: 98px; height: 31px; border: none; color: #FFF; font-weight: bold;"
			type="button" onclick="fromsubmit()"></td>
	</tr>
</table>
</div>


<input id="HfPersonCount" value="1" type="hidden" /> <input
	id="HfPassNameArr" value="" type="hidden" name="h_name" /> <input
	id="HfPassType" type="hidden" name="h_ptype" /> <input id="HfIdType"
	type="hidden" name="h_idtype" /> <input id="HfIdNumber" type="hidden"
	name="h_idnumber" /> <input id="HfPassInfo" type="hidden" /> <input
	id="HfPassTypeInfo" type="hidden" value="1" /> <input
	id="HfIdTypeInfo" type="hidden" value="1" /> <input
	id="HfIdNumberInfo" type="hidden" /> <input id="HfTravelType"
	type="hidden" value="1" /> <input id="HfTotalPrice" type="hidden" />
<input id="HfTotalAirportFee" type="hidden" /> <input
	id="HfTotalFuelFee" type="hidden" /> <input id="HfCustomerName"
	type="hidden" /> <input id="hfCustomerCardId" type="hidden" /> <input
	id="hfCustomerID" type="hidden" /> <input id="HfAdultNum"
	type="hidden" value="0" /> <input id="HfChildNum" type="hidden"
	value="0" /> <input id="HfBabyNum" type="hidden" value="0" /> <input
	id="hfAllPassName" type="hidden" /> <input id="hfcusGuid"
	type="hidden" /> <input id="hdfAddress" type="hidden" /> <input
	id="strTotalPriceOne" type="hidden" name="strTotalPriceOne"><input
	id="strTotalPriceTwo" type="hidden" name="strTotalPriceTwo"></form>
</body>
</html>
