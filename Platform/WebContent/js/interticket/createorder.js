function GetRadioCheck(radioBtn,divName)
       {
            var allPayDiv = document.getElementById("divPayTypeInfo").getElementsByTagName("div");
            for(var i=0;i<allPayDiv.length;i++)
            {
                allPayDiv[i].style.display="none";
            }
            if(radioBtn.checked)
                document.getElementById(divName).style.display="block";
       }
       var divIndex=0;
       function AddPeople()
       {
            divIndex++;
            var strPassHtml="<div  id='divPassPeople"+divIndex+"'>";
            strPassHtml+="<input type='hidden' id='hidCheck"+divIndex+"'/>"
            strPassHtml+="<div id='' style='width:90%; border:1px dashed #ff9900;padding:10px; background: #ffffee; margin-top: 10px;margin-bottom: 10px; color:#006699;'>";
            strPassHtml+="<ul><font color='red'><strong>乘机人"+divIndex+"</strong></font><br/><li style='list-style-type:none;'>英文姓名<span style='color: crimson'>* </span>：&nbsp;&nbsp;&nbsp;<input type='text' id='txtPassName"+divIndex+"' maxlength='50'  class='box'  width='150px'/>&nbsp;";
            strPassHtml+="<span style='color: silver'>输入格式：Last Name/First Name, 或者汉语拼音输入格式为：Zhang/xiaoming</span></li>";
            strPassHtml+="<li style='list-style-type:none;'>是否为留学生<span style='color: crimson'>* </span>：<span style='color:Black;'><input type='radio' id='radIsAbroad"+divIndex+"' name='radAbroad"+divIndex+"' value='1' />";
            strPassHtml+="<label>是</label><input type='radio' name='radAbroad"+divIndex+"' value='0' checked='checked' id='radNotAbroad"+divIndex+"' /> ";
            strPassHtml+="<label>否</label></span>&nbsp;&nbsp;";
            strPassHtml+="<select id='selGuestType"+divIndex+"' onchange='countpriceinfo();'><option value='1'>成人</option><option value='2'>儿童</option></select></li>";
            strPassHtml+="证件类型<span style='color: crimson'>* </span>： &nbsp;<select id='selCardType"+divIndex+"'><option selected='selected' value='3'>护照</option><option value='4'>港澳通行证</option><option value='5'>台湾通行证</option><option value='6'>军人证</option><option value='7'>回乡证</option><option value='8'>其他</option></select>";
            strPassHtml+="<li style='list-style-type:none;'>证件号码<span style='color: crimson'>* </span>：&nbsp;&nbsp;&nbsp;<input type='text' maxlength='50' class='box' id='txtCardNumber"+divIndex+"' style='width:150px' />";
            strPassHtml+="&nbsp; &nbsp; </li><li style='list-style-type:none;'>证件有效期<span style='color: crimson'>* </span>：<input type='text' onfocus=\"WdatePicker({skin:'whyGreen',minDate:'%y-%M-#{%d+1}'})\" class='date' id='txtCardValidity"+divIndex+"' style='width:150px' />";
            strPassHtml+="&nbsp;<span style='color: silver'>输入格式：2010-07-25</span> </li><li style='list-style-type:none;'>国籍/地区<span style='color: crimson'>* </span>：";
            strPassHtml+="&nbsp; <select id='selCountry"+divIndex+"' style='width:155px;'>";
            strPassHtml+=$("#hidAllFtCountry").val();
            strPassHtml+="</select>";
            strPassHtml+="&nbsp; &nbsp; 性别<span style='color: crimson'>* </span>：<select id='selGender"+divIndex+"'>&nbsp;&nbsp;<option selected='selected' value='1'>男</option><option value='2'>女</option>";
            strPassHtml+="</select>&nbsp; &nbsp; </li><li style='list-style-type:none;'>出生日期<span style='color: crimson'>* </span>：&nbsp;&nbsp; <input type='text' onFocus=\"WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-#{%d-1}'})\" class='date' id='txtBirthday"+divIndex+"' style='width:150px' />";
            strPassHtml+="<span style='color: silver'>&nbsp;输入格式：1970-01-01</span></li>";
            strPassHtml+="<li style='list-style-type:none;'>目的地邮编：&nbsp;&nbsp; <input type='text' id='txtPassPost"+divIndex+"'/>&nbsp;<span style='color: silver'>去往美国乘客必填</span></li>";
            strPassHtml+="<li style='list-style-type:none;'>目的地地址：&nbsp;&nbsp; <input type='text' style='width:400px' id='txtPassAddress"+divIndex+"'/>&nbsp;<span style='color: silver'>去往美国乘客必填</span></li>";
            strPassHtml+="<li style='list-style-type:none;'>现居住地址：&nbsp;&nbsp; <input type='text' style='width:400px' id='txtPassLiveAdd"+divIndex+"'/>&nbsp;<span style='color: silver'>去往美国乘客必填</span></li>";
            strPassHtml+="</ul></div>";
            //$("#divtotalprice").show();
            //document.getElementById("lblCountPrice").value = parseFloat(document.getElementById("hidPriceCount").value)*divIndex;
            //document.getElementById("hidPrice").value=parseFloat(document.getElementById("hidPrice").value)*divIndex;
            //document.getElementById("hidTax").value=parseFloat(document.getElementById("hidTax").value)*divIndex;
            //计算价格信息
            //countpriceinfo();
            return strPassHtml;
       }
       
       //计算价格信息
       function countpriceinfo()
       {
           //成人价格
           var adultprice=$("#hidPrice").val();
           //儿童价格
           var chlidprice=$("#hidChlidPrice").val();
           //税费
           var taxprice=$("#hidTax").val();
           //成人数量
           var adultnum=0;
           //儿童数量
           var chlidnum=0;
           $("select[id*='selGuestType']").each(function(i){
             //成人数量
             if($(this).val()=="1")
             {
                adultnum++;
             }
             else if($(this).val()=="2")
             {
                chlidnum++;
             }
            });
	       //显示总票价
	       var alladultprice=parseFloat(adultprice)*parseFloat(adultnum);
	       var allchildprice=parseFloat(chlidprice)*parseFloat(chlidnum);
	       var alltax=parseFloat(taxprice)*(parseFloat(adultnum)+parseFloat(chlidnum));
	       
	       $("#lblCountPrice").html(parseFloat(alladultprice)+parseFloat(allchildprice)+parseFloat(alltax));
		   $("#divtotalprice").show();  
		  }
		     
       
       
       
       var selectIndex=0;
       function AddOrDelPeople()
       {
            var peopleCount=$("#selPassCount").val();
            var divPassInfo=document.getElementById("divPassInfo");
            var strHtml="";
            if(selectIndex<peopleCount)
            {
                for(var i=parseInt(selectIndex)+1;i<=peopleCount;i++)
                {
                    strHtml+=AddPeople();
                }
                divPassInfo.innerHTML += strHtml;
            }
            else
            {
                for(var i=parseInt(peopleCount)+1;i<=selectIndex;i++)
                {
                    var divCheck=document.getElementById("divPassPeople"+i);
                    var cheIndex = document.getElementById("hidCheck"+i).value;
                    if(cheIndex!="")
                    {
                        var ckeck=document.getElementById(cheIndex);
                        ckeck.checked=false;
                    }
                }
                for(var i=parseInt(peopleCount)+1;i<=selectIndex;i++)
                {
                    $("#divPassPeople"+i).remove();
                }
                divIndex=peopleCount;
            }
            selectIndex=peopleCount;
            //$("#divtotalprice").show();
            countpriceinfo();
            //document.getElementById("lblCountPrice").innerHTML=parseInt($("#selPassCount").val())*parseFloat(document.getElementById("hidPriceCount").value);
       }
       function BindFPass(listIndex)
       {
            var chbFPass=document.getElementById("chbFPass_"+listIndex);
            var selPassCount=document.getElementById("selPassCount");
            if(chbFPass.checked)
            {
                if(selPassCount.selectedIndex<8)
                {
                    selPassCount.selectedIndex+=1;
                    selectIndex = parseInt(selectIndex)+1;
                    divPassInfo.innerHTML += AddPeople();
                    var divCheck = document.getElementById("divPassPeople"+divIndex);
                    //绑定常用信息
                    document.getElementById("hidCheck"+divIndex).value="chbFPass_"+listIndex;
                    document.getElementById("txtPassName"+divIndex).value=document.getElementById("hidIntelPassName"+listIndex).value;
                    var isAbroad = document.getElementById("radIsAbroad"+divIndex);
                    var notAbroad = document.getElementById("radNotAbroad"+divIndex);
                    if(document.getElementById("hidIsStudent"+listIndex).value==0)
                        isAbroad.checked=true;
                    else
                        notAbroad.checked=true;
                    var selCardType=document.getElementById("selCardType"+divIndex);
                    var cardType=document.getElementById("hidIDCardType"+listIndex).value;
//                    for(var i=0;i< selCardType.options.length;i++)
//                    {
//                        if(selCardType.options[i].value==cardType)
//                        {
//                            selCardType.options[i].selected=true;
//                        }
//                    }
                    document.getElementById("txtCardNumber"+divIndex).value=document.getElementById("hidIDNumber"+listIndex).value;
                    document.getElementById("txtCardValidity"+divIndex).value=document.getElementById("hidIDCardValideDate"+listIndex).value;
                    document.getElementById("txtBirthday"+divIndex).value=document.getElementById("hidPassBirthday"+listIndex).value;
                    var selCountry=document.getElementById("selCountry"+divIndex);
                    var passCountryID=document.getElementById("hidPassCountryID"+listIndex).value;
                    for(var i=0;i<selCountry.options.length;i++)
                    {
                        if(selCountry.options[i].value==passCountryID)
                        {
                            selCountry.options[i].selected=true;
                        }
                    }
                    var selGender=document.getElementById("selGender"+divIndex);
                    var gender=document.getElementById("hidPassSex"+listIndex).value;
                    for(var i=0;i<selGender.options.length;i++)
                    {
                        if(selGender.options[i].value==gender)
                        {
                            selGender.options[i].selected=true;
                        }
                    }
                    document.getElementById("txtPassPost"+divIndex).value=document.getElementById("hidZipCode"+listIndex).value;
                    document.getElementById("txtPassAddress"+divIndex).value=document.getElementById("hidDestinationAddress"+listIndex).value;
                    document.getElementById("txtPassLiveAdd"+divIndex).value=document.getElementById("hidResidenceAddress"+listIndex).value;
                    var selGuestType=document.getElementById("selGuestType"+divIndex);
                    for(var i=0;i<selGuestType.options.length;i++)
                    {
                        if(selGuestType.options[i].value==$("#hidGuest_Type"+listIndex).val())
                        {
                            selGuestType.options[i].selected=true;
                        }
                    }
                }
                else
                {
                    chbFPass.checked=false;
                    alert('国际机票最多只能订9张票，请重新选择！');
                    return;
                }
            }
            else
            {
                $("#divPassPeople"+$("#selPassCount").val()).remove();
                selPassCount.selectedIndex-=1;
                selectIndex=parseInt(selectIndex)-1;
                divIndex=$("#selPassCount").val();
            }
            //$("#divtotalprice").show();
            countpriceinfo();
            //document.getElementById("lblCountPrice").innerHTML=parseInt($("#selPassCount").val())*parseFloat(document.getElementById("hidPriceCount").value);
       }
       function SelectPayType()
       {
            var radCardPay=document.getElementById("radCardPay");
            var radTicketPay=document.getElementById("radTicketPay");
            var radNoTicket=document.getElementById("radNoTicket");
            var rdaMailSend=document.getElementById("rdaMailSend");
            var radCitySend=document.getElementById("radCitySend");
            if(radTicketPay.checked)
            {
                radNoTicket.disabled=true;
                rdaMailSend.disabled=true;
                radCitySend.checked=true;
                document.getElementById("divCardInfo").style.display="none";
            }
            if(radCardPay.checked)
            {
                radNoTicket.disabled=false;
                rdaMailSend.disabled=false;
                radCitySend.checked=true;
                document.getElementById("divCitySend").style.display="block";
                document.getElementById("divCardInfo").style.display="block";
            }
       }
       function cusdatacheck()
        {
            var txtCustomerName=document.getElementById("txtCustomerName");
            var txtCustomerMobile=document.getElementById("txtCustomerMobile");
            if(txtCustomerName.value=="")
            {
                 alert("会员姓名不能为空！");
                   return false;
            }
            if(txtCustomerMobile.value=="")
            {
                alert("会员手机号不能为空！");
                   return false;
            }
            else
            {
                if(!IsMobile(txtCustomerMobile.value))
                {
                   alert("您输入的会员手机号格式不正确！");
                    $("#txtCustomerMobile").focus();
                    return false;
                }
            }
        }
       //点击下一步，核对填写信息
       function NextStep()
       {
            var allPassDiv=$("div[id*='divPassPeople']").length;
            
            var strName="";
            var strStudent="";
            var strCardType="";
            var strCardNumber="";
            var strCardValDate="";
            var strCountry="";
            var strGender="";
            var strBirthday="";
            var strZipCode="";
            var strTargetAdd="";
            var strLiveAdd="";
            var strCountryName="";
            var strGuestType="";
            var hfCustomerID=document.getElementById("hfCustomerID");
          
            if($("#selPassCount").val()=="0")
            {
                alert("您还没有选择乘机人！");
                $("#selPassCount").focus();
                return false;
            }
            for(var i=1;i<=allPassDiv;i++)
            {
                if($("#txtPassName"+i).val()=="")
                {
                    alert("您在第"+i+"个乘机人姓名未填写！");
                    $("#txtPassName"+i).focus();
                    return false;
                }
                if(document.getElementById("txtPassName"+i).value.indexOf('/')<=0)
                {
                    alert("您在第"+i+"个乘机人姓名输入有误！");
                    $("#txtPassName"+i).focus();
                    return false;
                }
                if($("#txtCardNumber"+i).val()=="")
                {
                    alert("您在第"+i+"个乘机人证件号未填写！");
                    $("#txtCardNumber"+i).focus();
                    return false;
                }
//                if(!shenfen($("#txtCardNumber"+i).val()))
//                {
//                  $("#txtCardNumber"+i).focus();
//                  return false;
//                }
                if($("#txtBirthday"+i).val()=="")
                {
                    alert("您在第"+i+"个乘机人出生年月未填写！");
                    $("#txtBirthday"+i).focus();
                    return false;
                }
                if($("#txtCardValidity"+i).val()=="")
                {
                    alert("您在第"+i+"个乘机人证件有效日期未填写！");
                    $("#txtCardValidity"+i).focus();
                    return false;
                }
                if($("#hidCountryCode").val()=="US")
                {
                    if($("#txtPassPost"+i).val()=="")
                    {
                        alert("由于您是去往美国，请在第"+i+"个乘机人填写邮政编码！");
                        $("#txtPassPost"+i).focus();
                        return false;
                    }
                    if(!IsInteger($("#txtPassPost"+i).val()))
                    {
                        alert("您在第"+i+"个乘机人邮政编码填写不正确，请重新填写");
                        $("#txtPassPost"+i).focus();
                        return false;
                    }
                    if($("#txtPassAddress"+i).val()=="")
                    {
                        alert("由于您是去往美国，请在第"+i+"个乘机人填写目的地地址！");
                        $("#txtPassAddress"+i).focus();
                        return false;
                    }
                    if($("#txtPassLiveAdd"+i).val()=="")
                    {
                        alert("由于您是去往美国，请在第"+i+"个乘机人填写现居住地址！");
                        $("#txtPassLiveAdd"+i).focus();
                        return false;
                    }
                }
                strName+=document.getElementById("txtPassName"+i).value+",";
                strCardNumber+=document.getElementById("txtCardNumber"+i).value+",";
                strCardValDate+=document.getElementById("txtCardValidity"+i).value+",";
                strBirthday+=document.getElementById("txtBirthday"+i).value+",";
                var isAbroad=document.getElementById("radIsAbroad"+i);
                var noAbroad=document.getElementById("radNotAbroad"+i);
                if(isAbroad.checked)
                    strStudent+="0"+",";
                else
                    strStudent+="1"+",";
                strCardType+=$("#selCardType"+i).val()+",";
                strCountry+=$("#selCountry"+i).val()+",";
                strGender+=$("#selGender"+i).val()+",";
                strZipCode+=$("#txtPassPost"+i).val()+",";
                strTargetAdd+=$("#txtPassAddress"+i).val()+",";
                strLiveAdd+=$("#txtPassLiveAdd"+i).val()+",";
                strCountryName+=document.getElementById("selCountry"+i).options[document.getElementById("selCountry"+i).selectedIndex].text+",";
                strGuestType+=$("#selGuestType"+i).val()+",";
            }
                if($("#txtContactName").val()=="")
                {
                    alert("请输入联系人姓名！");
                    $("#txtContactName"+i).focus();
                    return false;
                }
                if($("#txtContactMobile").val()=="" && $("#txtContactPhone").val()=="")
                {
                    alert("联系手机、电话必填一项，联系电话按区号-电话号码-分机号填写！");
                    $("#txtContactMobile").focus();
                    return false;
                }
                else if($("#txtContactPhone").val()!="")
                {
                    if(!IsTelephone($("#txtContactPhone").val()))
                    {
                        alert("联系电话格式不正确，请重新填写！");
                        $("#txtContactPhone").focus();
                        return false;
                    }
                }
                else if($("#txtContactMobile").val() != "")
                {
                     if(!IsMobile($("#txtContactMobile").val()))
                    {
                        alert("联系人手机格式不正确！请重新填写！");
                        $("#txtContactMobile").focus();
                        return false;
                    }
                }
                if($("#txtContactEmail").val()!="" && !IsEMail($("#txtContactEmail").val()))
                {
                    alert("联系人邮箱填写不正确，请重新填写！");
                    $("#txtContactEmail").focus();
                    return false;
                }
               
                
            
            document.getElementById("hidName").value=strName;
            document.getElementById("hidStudent").value=strStudent;
            document.getElementById("hidCardType").value=strCardType;
            document.getElementById("hidCardNumber").value=strCardNumber;
            document.getElementById("hidCardValDate").value=strCardValDate;
            document.getElementById("hidCountry").value=strCountry;
            document.getElementById("hidGender").value=strGender;
            document.getElementById("hidBirthday").value=strBirthday;
            document.getElementById("hidZipCode").value=strZipCode;
            document.getElementById("hidTarget_Address").value=strTargetAdd;
            document.getElementById("hidLive_Address").value=strLiveAdd;
            document.getElementById("hidCountryName").value=strCountryName;
            document.getElementById("hidAllGuestType").value=strGuestType;
            
            var divWriteGuestInfo=document.getElementById("divWriteGuestInfo");
            var divReadGuestInfo=document.getElementById("divReadGuestInfo");
            var divWriteContactInfo=document.getElementById("divWriteContactInfo");
            var divReadContactInfo=document.getElementById("divReadContactInfo");
            var divWritePayInfo=document.getElementById("divWritePayInfo");
            var divReadPayInfo=document.getElementById("divReadPayInfo");
            //乘机人信息
            var strGuestInfo="";
            var hidName=document.getElementById("hidName").value.split(',');
            var hidStudent=document.getElementById("hidStudent").value.split(',');
            var hidCardType=document.getElementById("hidCardType").value.split(',');
            var hidCardNumber=document.getElementById("hidCardNumber").value.split(',');
            var hidCardValDate=document.getElementById("hidCardValDate").value.split(',');
            var hidCountry=document.getElementById("hidCountry").value.split(',');
            var hidGender=document.getElementById("hidGender").value.split(',');
            var hidBirthday=document.getElementById("hidBirthday").value.split(',');
            var hidZipCode=document.getElementById("hidZipCode").value.split(',');
            var hidTarget_Address=document.getElementById("hidTarget_Address").value.split(',');
            var hidLive_Address=document.getElementById("hidLive_Address").value.split(',');
            var hidCountryName=document.getElementById("hidCountryName").value.split(',');
            var hidAllGuestType=document.getElementById("hidAllGuestType").value.split(',');
            for(var i=0;i<hidName.length-1;i++)
            {
                strGuestInfo+="<div id='divReadPassPeople"+(i+1)+"'>";
                strGuestInfo+="<div id='' style='margin-left:30px;width:80%; border:1px dashed #ff9900;padding:10px; background: #ffffee; margin-top: 10px;margin-bottom: 10px; color:#006699;'>";
                strGuestInfo+="<ul><font color='red'><strong>乘机人"+(i+1)+"</strong></font><br/><li style='list-style-type:none;'>英文姓名：<b>"+hidName[i]+"</b> &nbsp;&nbsp;";
                strGuestInfo+="</li><li style='list-style-type:none;'>是否为留学生：";
                if(hidStudent[i]=="0")
                {
                    strGuestInfo+="是";
                    strGuestInfo+="&nbsp;&nbsp乘客类型:"+document.getElementById("selGuestType"+(i+1)).options[document.getElementById("selGuestType"+(i+1)).selectedIndex].text;
                }
                else
                {
                    strGuestInfo+="否";
                    strGuestInfo+="&nbsp;&nbsp乘客类型:"+document.getElementById("selGuestType"+(i+1)).options[document.getElementById("selGuestType"+(i+1)).selectedIndex].text;
                    //strGuestInfo+="</li>";
                    //strGuestInfo+=document.getElementById("selCardType"+(i+1)).options[document.getElementById("selCardType"+(i+1)).selectedIndex].text;
                    //strGuestInfo+="<select id='selCardType"+i+"'><option selected='selected' value='0'>护照</option><option value='1'>军官证</option><option value='2'>士兵证</option><option value='3'>回乡证</option><option value='4'>台胞证</option></select>";
                }
                strGuestInfo+="<li style='list-style-type:none;'>证件类型：";
                if(hidCardType[i]=="3")
                {
                   strGuestInfo+="护照";
                }
                else if(hidCardType[i]=="6")
                {
                   strGuestInfo+="军人证";
                }
                else if(hidCardType[i]=="7")
                {
                   strGuestInfo+="回乡证";
                }
                else if(hidCardType[i]=="5")
                {
                   strGuestInfo+="台湾通行证";
                }
                else if(hidCardType[i]=="4")
                {
                   strGuestInfo+="港澳通行证";
                }
                else if(hidCardType[i]=="8")
                {
                   strGuestInfo+="其他";
                }
                
                strGuestInfo+="</li>";
                strGuestInfo+="<li style='list-style-type:none;'>证件号码："+hidCardNumber[i];
                strGuestInfo+="&nbsp; &nbsp; </li><li style='list-style-type:none;'>证件有效期："+hidCardValDate[i];
                strGuestInfo+="</li><li style='list-style-type:none;'>国籍/地区： ";
                strGuestInfo+=hidCountryName[i];
                strGuestInfo+="&nbsp; &nbsp; 性别</span>：";
                //<select id='selGender"+i+"'><option selected='selected' value='1'>男</option><option value='2'>女</option>
                if(hidGender[i]=="1")
                    strGuestInfo+="男";
                else
                    strGuestInfo+="女";
                strGuestInfo+="</select>&nbsp; &nbsp; </li><li style='list-style-type:none;'>出生日期："+hidBirthday[i];
                strGuestInfo+="</li>";
                strGuestInfo+="<li style='list-style-type:none;'>目的地邮编："+hidZipCode[i]+"</li>";
                strGuestInfo+="<li style='list-style-type:none;'>目的地地址："+hidTarget_Address[i]+"</li>";
                strGuestInfo+="<li style='list-style-type:none;'>现居住地址："+hidLive_Address[i]+"</li>";
                strGuestInfo+="</ul></div>";
            }
            divReadGuestInfo.innerHTML=strGuestInfo;
            divWriteGuestInfo.style.display="none";
            divReadGuestInfo.style.display="block";
            //联系人信息
            document.getElementById("lblContactName").innerHTML=$("#txtContactName").val();
            document.getElementById("lblConMobile").innerHTML=$("#txtContactMobile").val();
            document.getElementById("lblConPhone").innerHTML=$("#txtContactPhone").val();
            document.getElementById("lblConEmail").innerHTML=$("#txtContactEmail").val();
            document.getElementById("lblConRemark").innerHTML=$("#txtContactRemrk").val();
            divWriteContactInfo.style.display="none";
            divReadContactInfo.style.display="block";
           
            document.getElementById("btnList").style.display="none";
            //document.getElementById("lblSendInfo").innerHTML=strSendInfo;
            //divWritePayInfo.style.display="none";
            //divReadPayInfo.style.display="block";
            document.getElementById("btnSubmitOrder").style.display="block";
            document.getElementById("btnNextStep").style.display="none";
            document.getElementById("btnPreStep").style.display="block";
       }
       function PreStep()
       {
            var divWriteGuestInfo=document.getElementById("divWriteGuestInfo");
            var divReadGuestInfo=document.getElementById("divReadGuestInfo");
            var divWriteContactInfo=document.getElementById("divWriteContactInfo");
            var divReadContactInfo=document.getElementById("divReadContactInfo");
            var divWritePayInfo=document.getElementById("divWritePayInfo");
            var divReadPayInfo=document.getElementById("divReadPayInfo");
            divWriteGuestInfo.style.display="block";
            divReadGuestInfo.style.display="none";
            divWriteContactInfo.style.display="block";
            divReadContactInfo.style.display="none";
            divWritePayInfo.style.display="block";
            divReadPayInfo.style.display="none";
            document.getElementById("btnSubmitOrder").style.display="none";
            document.getElementById("btnNextStep").style.display="block";
            document.getElementById("btnList").style.display="block";
            document.getElementById("btnPreStep").style.display="none";
       }
       function dispose(message) {
		   Ext.MessageBox.show({
		           msg: message+', 请稍后......',
		           progressText: 'Saving...',
		           width:300,
		           wait:true,
		           waitConfig: {interval:200},
		           icon:'ext-mb-download',
		           animEl: 'mb7'
		       });
		}
		function colsedispose(){
		 Ext.MessageBox.hide();
		}
       
        //返回到列表页
        function BackList()
        {
            window.history.go(-1);
        }
        
        function CreateOrder()
        {
            dispose("正在创建订单");
            document.form1.submit();
        }
        
        function GetAddress()
        {
           document.getElementById("txtRecipientAddress2").value= document.getElementById("ddlSendCity").options[document.getElementById("ddlSendCity").selectedIndex].text;
        }