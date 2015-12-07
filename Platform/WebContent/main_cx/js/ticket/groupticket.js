//选中当前政策信息
function bindcurrentpolicy(policyid) {
    var segstrtemp = "";
    adultpricefee = 0;
    $("#segment_povalue_0").html($("#policypoint_" + policyid).val() + "%");
    $("#segment_segprice_0").html("¥" + $("#policyjiesuanjia_" + policyid).val());
    var segarr = segstr.split('$');
    for (s = 0; s < segarr.length; s++) {
        var jsonList = JSON.parse(segarr[s]);
        for (var i = 0; i < jsonList.segmentinfos.length; i++) {
            jsonList.segmentinfos[i]["ratevalue"] = $("#policypoint_" + policyid).val();
            jsonList.segmentinfos[i]["agentid"] = $("#policyagentid_" + policyid).val();
            jsonList.segmentinfos[i]["zrateid"] = $("#policyguid_" + policyid).val();
            jsonList.segmentinfos[i]["price"] = $("#policyjiesuanjia_" + policyid).val();
            jsonList.segmentinfos[i]["isspecial"] = $("#policyissepcial_" + policyid).val();
            adultpassengerprice = parseInt(jsonList.segmentinfos[i]["price"])
            //成人总价格(含税费)
            adultpricefee += adultpassengerprice + adultpassengerairport + adultpassengerfuel;
        }
        segstrtemp += JSON.stringify(jsonList);
        if (s == 1) {
            segstrtemp += "$";
        }
    }
    segstr = segstrtemp;
    $("#hidsegmentinfo").val(segstr);
    $("div[id*='divinformation_']").each(function (i) {
        passengercount++;
        var strid = $(this).attr("id");
        id = strid.replace("divinformation_", "");
        $("#hid_totalprice_" + id).val(adultpricefee);
        $("#hid_ticketprice_" + id).val(adultpassengerprice);
    });
    accountprice();
    //展开政策备注
    $("tr[id*='trpolicydesc_']").each(function (i) {
        $(this).hide();
    });
    $("#trpolicydesc_" + policyid).show();
    $("tr[id*='trpolicy_']").each(function (i) {
        $(this).removeClass("bgcor");
        $(this).addClass("btm");
    });
    $("#trpolicy_" + policyid).addClass("bgcor");
}
//获取政策信息
function getpolicydata(type) {
    var flightnumber = $("#segment_flightnumber_0").val();
    var cabincode = $("#segment_cabincode_0").val();
    var aircompanycode = $("#segment_aircompanycode_0").val();
    var ticketprice = $("#segment_ticketprice_0").val();
    var startcitycode = $("#segment_startairportcode_0").val();
    var endcitycode = $("#segment_arriveairportcode_0").val();
    var fromdate = $("#segment_fromdate_0").val();
    $.ajax({
        type: "GET",
        url: '../httphandler/dashboard.ashx?action=getmulitpolicyinfo&t=' + new Date().getTime(),
        data: {
            issepcial: type,
            startcitycode: startcitycode,
            endcitycode: endcitycode,
            fromdate: fromdate,
            aircompanycode: aircompanycode,
            flightnumber: flightnumber,
            cabincode: cabincode,
            z_price: ticketprice
        },
        dataType: "text",
        beforeSend: function () {
            $("#tbpolicyinfo").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='../images/loading.gif' />正在加载政策信息");
        },
        success: function (data) {
            $("#tbpolicyinfo").html(data);
            var checkboxindex = 0;
            $("input[id*='rdopolicyselect_']").each(function (i) {
                if (i == 0) {
                    checkboxindex = $(this).attr("id").split('_')[1];
                }
            });
            $("#rdopolicyselect_" + checkboxindex).click();
        }
    });
}
//切换选项卡
function switchTab(tabname) {
    if (tabname == "tab1") {
        getpolicydata(0);
        $("#tab1").removeClass();
        $("#tab1").addClass("on");
        $("#tab2").addClass("th_zc");
    }
    else if (tabname == "tab2") {
        getpolicydata(1);
        $("#tab2").removeClass();
        $("#tab2").addClass("on");
        $("#tab1").addClass("zc");
    }
}
//显示退改签信息说明
function showrules(index) {
    $('#a_rules_' + index).poshytip({
        className: 'tip-violet',
        bgImageFrameSize: 9,
        alignTo: 'target',
        alignX: 'right',
        alignY: 'center',
        offsetX: 0,
        offsetY: 5
    });
    //$('#a_rules_' + index).poshytip('show');
}
//隐藏退改签信息说明
function hiderules(index) {
    $('#a_rules_' + index).poshytip('hide');
}

//添加乘机人
function addpassenger(jsonpassenger) {
    var currentindex = 1;
    var divid = 0;
    $("div[id*='divinformation_']").each(function (i) {
        currentindex++;
        var idcur = $(this).attr("id").replace("divinformation_", "");
        divid = parseInt(idcur) + 1;

    });
    if (currentindex > 9) {
    
alert("最多预订9人!");
        //$('#linkadd').poshytip('enable');
       // $('#linkadd').poshytip('show');
        return;
    }
    var currentpassenger = JSON.stringify(passengers);

    if (jsonpassenger == "") {
        passengerJsonString = "[";
        passengerJsonString += '{ID: "' + divid + '", Name:"",Type:"1",Idcardtype:"1",Idcardnumber:"",Insurancenum:"0",Insurancemoney:"' + insuranceprice + '",Ticketprice:"' + adultpassengerprice + '",Airportprice:"' + adultpassengerairport + '",Fuelprice:"' + adultpassengerfuel + '",Totalprice:"' + adultpricefee + '" }';
        passengerJsonString += "]";

        passengers = eval(passengerJsonString);
        $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers');
    }
    else {
        passengerJsonString = jsonpassenger.replace("currentindex", divid);
        passengers = eval(passengerJsonString);
        $('#passengerTemplate').tmpl(passengers).appendTo('#divpassengers');
        //判断已有乘机人中是否有姓名为空的，如果有则删除
        $("div[id*='divinformation_']").each(function (i) {
            var strid = $(this).attr("id");
            var id = strid.replace("divinformation_", "");
            if ($("#txt_name_" + id).val() == "") {
                delpassenger(id);
            }
        });
    }
    accountprice();
}

//删除乘机人
function delpassenger(id) {

    var currentindex = 0;
    $("div[id*='divinformation_']").each(function (i) {
        currentindex++;
    });
    if (currentindex == 1) {
        $('#linkdel').poshytip('enable');
        $('#linkdel').poshytip('show');
        return;
    }
    else {
        $("#divinformation_" + id).remove();
    }
    accountprice();
}

//计算总价格
function accountprice() {
    var adultnum = 0;
    var childnum = 0;
    var babynum = 0;
    //总支付金额
    var totalpayprice = 0;
    $("div[id*='divinformation_']").each(function (i) {
        passengercount++;
        var strid = $(this).attr("id");
        id = strid.replace("divinformation_", "");
        if ($("#ddlpassengertype_" + id).val() == 1) {
            adultnum++;
        }
        else if ($("#ddlpassengertype_" + id).val() == 2) {
            childnum++;
        }
        else if ($("#ddlpassengertype_" + id).val() == 3) {
            babynum++;
        }
        totalpayprice += parseInt($("#hid_totalprice_" + id).val());


    });
    totalpayprice += parseInt($("#hidplatprice").val());
    showpriceinfo(adultnum, childnum, babynum, totalpayprice);
}
//显示价格信息
function showpriceinfo(adultnum, childnum, babynum, totalpayprice) {
    $("#hidadultpasscount").val(adultnum);
    $("#hidchildpasscount").val(childnum);
    $("#hidbabypasscount").val(babynum);
    $("#span_totalprice").html(totalpayprice);
    var passengercount = adultnum + childnum + babynum;
    var singalprice = adultpricefee;
    if (adultnum > 0) {
        singalprice = adultpricefee;
    }
    else if (childnum > 0) {
        singalprice = chilidpricefee;
    }
    var insurancecount = 0;
    //保险份数
    $("select[id*='ddlinsurance_']").each(function (i) {
        insurancecount = parseInt(insurancecount) + parseInt($(this).val());
    });
    var detail = "";
    detail += totalpayprice;
    $("#pass_count_num").html(adultnum + "成人+" + childnum + "儿童+" + babynum + "婴儿");
    $("#adult_count_num").html(adultnum);
    $("#children_count_num").html(childnum);
    $("#baby_count_num").html(babynum);
    $("#count_adult_fare").html(adultpassengerprice);
    $("#count_children_fare").html(childticketprice);
    $("#count_baby_fare").html(babyticketprice);
    $("#count_adult_airport_fee").html(adultpassengerairport);
    $("#count_children_airport_fee").html("0");
    $("#count_baby_airport_fee").html("0");
    $("#count_adult_fuel_costs").html(adultpassengerfuel);
    $("#count_children_fuel_costs").html(chlidfuelfee);
    $("#count_baby_fuel_costs").html("0");
    $("#span_priceinfo").html(detail);
}
function showdetail() {
    $("#DetailedPrice").toggle('fast');
}

//更改乘机人类型
function changepassengertype(index) {
    var baoxianprice = 0;
    //选择购买保险
    if ($("#ddlinsurance_" + index).val() != "0") {
        baoxianprice = parseInt($("#ddlinsurance_" + index).val()) * insuranceprice;
    }
    if ($("#ddlpassengertype_" + index).val() == "1") {
        var tprice = parseInt(adultpricefee) + parseInt(baoxianprice);
        $("#hid_ticketprice_" + index).val(adultpassengerprice);
        $("#hid_airportprice_" + index).val(adultpassengerairport);
        $("#hid_fuelprice_" + index).val(adultpassengerfuel);
        $("#hid_totalprice_" + index).val(tprice);
        $("#txt_idcardnumber_" + id).unbind("focus");

    }
    else if ($("#ddlpassengertype_" + index).val() == "2") {

        var tprice = parseInt(chilidpricefee) + parseInt(baoxianprice);
        $("#hid_ticketprice_" + index).val(childticketprice);
        $("#hid_airportprice_" + index).val(0);
        $("#hid_fuelprice_" + index).val(chlidfuelfee);
        $("#hid_totalprice_" + index).val(tprice);
        $("#txt_idcardnumber_" + id).unbind("focus");
    }
    else if ($("#ddlpassengertype_" + index).val() == "3") {
        var tprice = parseInt(babypricefee) + parseInt(baoxianprice);
        $("#hid_ticketprice_" + index).val(babyticketprice);
        $("#hid_airportprice_" + index).val(0);
        $("#hid_fuelprice_" + index).val(0);
        $("#hid_totalprice_" + index).val(tprice);
        $("#txt_idcardnumber_" + index).bind("focus", function () {
            WdatePicker({ skin: 'whyGreen', maxDate: '%y-#{%M}-%d' });
        });
    }
    //accountprice();

}
//更改保险份数
function changeinsurance(id) {
    $("#hid_insurance_" + id).val($("#ddlinsurance_" + id).val());
    $("#hid_insurancenum_" + id).val($("#ddlinsurance_" + id).val());
    //accountprice();
}
//更改证件类型
function changeidcardtype(id, passid) {
    $("#txt_idcardnumber_" + id).val("");
    //取得证件号码
    //$.ajax({
    //type:"GET",
    //url:"domesticticket!getPassCredit.jspx",
    //data:{id:passid,idcardtype:$("#ddlidcardtype_"+id).val()},
    //async:false,         
    //success:function(data){
    //$("#txt_idcardnumber_"+id).val(data);
    //}            
    //});
    //如果是出生日期，则显示日期控件
    if ($("#ddlpassengertype_" + id).val() == "3") {
        $("#txt_idcardnumber_" + id).bind("focus", function () {
            WdatePicker({ skin: 'whyGreen', maxDate: '%y-#{%M}-%d' });
        });
    }
    else {
        $("#txt_idcardnumber_" + id).unbind("focus");
    }

}
//验证乘机人信息
function checkdata(stepindex) {
    var varretrun = true;
    var varretrun1 = true;
    var varretrun2 = true;
    var varretrun3 = true;
    var isrightdate = true;
    var ischilddate = true;
    var isbabydate = true;
    var isemptymobile = true;
    var isrightmobile = true;
    var index = "";
    var j = "";
    var id = "";
    //对乘机人信息进行验证
    $("input[id*='txt_name_']").each(function (i) {
        var strid = $(this).attr("id");
        id = strid.replace("txt_name_", "");
        if ($(this).val() == "") {
            varretrun = false;
            index = i + 1;
            j = i;

        }
        else {
            var regnamecnen = /^[\u4E00-\u9FA5]{1,16}[a-zA-Z]{0,20}[0-9]{0,8}$/; //中文
            var regnameen = /^[a-zA-Z]{1,20}[\/]{1}[a-zA-Z]{1,20}[0-9]{0,8}$/; //英文名
            if (!regnamecnen.exec($(this).val()) && !regnameen.exec($(this).val())) {
                varretrun2 = false;
                index = i + 1;
                j = i;
            }
        }
    });
    if (varretrun == false) {
        $('#txt_name_' + id).poshytip({
            className: 'tip-violet',
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5
        });
        $('#txt_name_' + id).poshytip('show');
        $("#txt_name_" + id).focus();
        return false;
    }
    if (varretrun2 == false) {
        $('#txt_name_' + id).poshytip({
            className: 'tip-violet',
            content: "持护照外宾姓名格式例如“Smith/Black”！",
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5
        });
        $("#txt_name_" + id).focus();
        return false;
    }
    //证件号
    var strEmpty = "";
    $("input[id*='txt_idcardnumber_']").each(function (i) {
        var strid = $(this).attr("id");
        id = strid.replace("txt_idcardnumber_", "");
        if ($(this).val() == "") {
            varretrun = false;
            index = i + 1;
            j = i;
        } else if ($(this).val().length > 20) {
            varretrun3 = false;
            index = i + 1;
            j = i;
        } else {
            strEmpty = $(this).val();
        }
    });
    if (varretrun) {
        $("select[id*='ddlidcardtype_']").each(function (i) {
            if ($("#ddlidcardtype_" + id).val() == "1") {
                if (!shenfen($("#txt_idcardnumber_" + id).val())) {
                    varretrun1 = false;
                    index = i + 1;
                    j = i;
                }
            }
            else if ($("#ddlidcardtype_" + id).val() == "7") {
                if (!IsDate($("#txt_idcardnumber_" + id).val())) {
                    isrightdate = false;
                    index = i + 1;
                    j = i;
                }
                else if ($("#ddlpassengertype_" + id).val() == "2" && (DateDiff('2011-12-04', $("#txt_idcardnumber_" + id).val()) > 4380 || DateDiff('2011-12-04', $("#txt_idcardnumber_" + id).val()) < 2 * 365)) {
                    ischilddate = false;
                    index = i + 1;
                    j = i;
                }
                else if ($("#ddlpassengertype_" + id).val() == "3" && (DateDiff('2011-12-04', $("#txt_idcardnumber_" + id).val()) >= 2 * 365)) {
                    isbabydate = false;
                    index = i + 1;
                    j = i;
                }
            }
        });
    }
    if (varretrun == false) {
        $('#txt_idcardnumber_' + id).poshytip({
            className: 'tip-violet',
            content: "请填写乘机人证件号码！",
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5
        });
        $("#txt_idcardnumber_" + id).focus();
        return false;
    }
    if (varretrun3 == false) {
        $('#txt_idcardnumber_' + id).poshytip({
            className: 'tip-violet',
            content: "乘机人证件号不能大于20！",
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5
        });
        $("#txt_idcardnumber_" + id).focus();
        return false;
    }
    if (varretrun1 == false) {
        $('#txt_idcardnumber_' + id).poshytip({
            className: 'tip-violet',
            content: "请检查乘机人证件号码格式是否正确！",
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5
        });
        $("#txt_idcardnumber_" + id).focus();
        return false;
    }
    else if (isrightdate == false) {
        $('#txt_idcardnumber_' + id).poshytip({
            className: 'tip-violet',
            content: "请输入乘机人正确的出生日期！",
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5
        });
        $("#txt_idcardnumber_" + id).focus();
        return false;
    }
    else if (ischilddate == false) {
        alert("儿童年龄应该是2-12岁！");
        $("#txt_idcardnumber_" + id).focus();
        return false;
    }
    else if (isbabydate == false) {
        alert("婴儿年龄应该是0-2岁！");
        $("#txt_idcardnumber_" + id).focus();
        return false;
    }
    //对乘机人手机号码进行验证
    $("input[id*='txtmobile_']").each(function (i) {
        var strid = $(this).attr("id");
        id = strid.replace("txtmobile_", "");
        if ($(this).val() == "") {
            isemptymobile = false;
            index = i + 1;
            j = i;

        }
        else {
            if (!IsMobile($(this).val())) {
                isrightmobile = false;
                index = i + 1;
                j = i;
            }
        }
    });

    //验证联系人信息
    if (IsEmpty($("#txtcontactname").val())) {
        $('#txtcontactname').poshytip({
            className: 'tip-violet',
            content: "请填写联系人姓名！",
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5
        });
        $("#txtcontactname").focus();
        return false;
    }

    //联系人手机号码
    if (IsEmpty($("#txtcontactmobile").val())) {
        $('#txtcontactmobile').poshytip({
            className: 'tip-violet',
            content: "请填写联系人手机号码！",
            showOn: 'focus',
            alignTo: 'target',
            alignX: 'right',
            alignY: 'center',
            offsetX: 5
        });
        $("#txtcontactmobile").focus();
        return false;
    }
    else {
        if (!IsMobile($("#txtcontactmobile").val())) {
            $('#txtcontactmobile').poshytip({
                className: 'tip-violet',
                content: "请检查联系人手机号码是否正确！",
                showOn: 'focus',
                alignTo: 'target',
                alignX: 'right',
                alignY: 'center',
                offsetX: 5
            });
            $("#txtcontactmobile").focus();
            return false;
        }
    }
    bindSegmentinfo();
    bindpassengerinfo();
}
function bindSegmentinfo() {
    var jsonsegment = "";
    var aircompany = $("#txtflightnumber_1").val().substring(0, 2); 
    if ($("#rdoOneWay").attr("checked")) {
        jsonsegment += '{"segmentinfos":[{"flightnumber":"' + $("#txtflightnumber_1").val() + '","aircomapnycode":"' + aircompany + '","airname":"","airportfee":"0","fuelfee":"0","departtime":"' + $("#txtfromdate_1").val() + '","arrivaltime":"' + $("#txtarrivedate_1").val() + '","departshorttime":"","arrivalshorttime":"","cabincode":"' + $("#txtcabincode_1").val() + '","price":"0","discount":"0","yprice":"0","traveltype":"1","isspecial":"0","startcityname":"' + $("#txtfromcity_1").val() + '","endcityname":"' + $("#txttocity_1").val() + '","startairport":"' + $("#hidfromcitycode_1").val() + '","startairportname":"","endairport":"' + $("#hidtocitycode_1").val() + '","endairportname":"","refundrules":"","changecabinrules":"","changeflightrules":";","ratevalue":"0","borderpointat":"","offpointat":"","parvalue":"0","agentid":"00000000-0000-0000-0000-000000000000","zrateid":"00000000-0000-0000-0000-000000000000","flightdesc":"","flightmodel":""}]}';
    }
    else if ($("#rdoRoundWay").attr("checked") == true) {
        jsonsegment += '{"segmentinfos":[{"flightnumber":"' + $("#txtflightnumber_1").val() + '","aircomapnycode":"' + aircompany + '","airname":"","airportfee":"0","fuelfee":"0","departtime":"' + $("#txtfromdate_1").val() + '","arrivaltime":"' + $("#txtarrivedate_1").val() + '","departshorttime":"","arrivalshorttime":"","cabincode":"' + $("#txtcabincode_1").val() + '","price":"0","discount":"0","yprice":"0","traveltype":"1","isspecial":"0","startcityname":"' + $("#txtfromcity_1").val() + '","endcityname":"' + $("#txttocity_1").val() + '","startairport":"' + $("#hidfromcitycode_1").val() + '","startairportname":"","endairport":"' + $("#hidtocitycode_1").val() + '","endairportname":"","refundrules":"","changecabinrules":"","changeflightrules":";","ratevalue":"0","borderpointat":"","offpointat":"","parvalue":"0","agentid":"00000000-0000-0000-0000-000000000000","zrateid":"00000000-0000-0000-0000-000000000000","flightdesc":"","flightmodel":""}]}';
        jsonsegment += '${"segmentinfos":[{"flightnumber":"' + $("#txtflightnumber_2").val() + '","aircomapnycode":"' + aircompany + '","airname":"","airportfee":"0","fuelfee":"0","departtime":"' + $("#txtfromdate_2").val() + '","arrivaltime":"' + $("#txtarrivedate_2").val() + '","departshorttime":"","arrivalshorttime":"","cabincode":"' + $("#txtcabincode_2").val() + '","price":"0","discount":"0","yprice":"0","traveltype":"1","isspecial":"0","startcityname":"' + $("#txtfromcity_2").val() + '","endcityname":"' + $("#txttocity_2").val() + '","startairport":"' + $("#hidfromcitycode_2").val() + '","startairportname":"","endairport":"' + $("#hidtocitycode_2").val() + '","endairportname":"","refundrules":"","changecabinrules":"","changeflightrules":";","ratevalue":"0","borderpointat":"","offpointat":"","parvalue":"0","agentid":"00000000-0000-0000-0000-000000000000","zrateid":"00000000-0000-0000-0000-000000000000","flightdesc":"","flightmodel":""}]}';
    }
    $("#hidsegmentinfo").val(jsonsegment);
}
function bindpassengerinfo() {

    var name = "";
    var type = "";
    var idcardtype = "";
    var idcardnumber = "";
    var insurancenum = 0;
    var insurancetotalprice = 0;
    var ticketprice = 0;
    var airportprice = 0;
    var fuelprice = 0;
    var totalprice = 0;
    var issave = 1;
    var jsonstring = "[";
    $("div[id*='divinformation_']").each(function (i) {
        var strid = $(this).attr("id");
        id = strid.replace("divinformation_", "");
        name = $("#txt_name_" + id).val();
        type = $("#ddlpassengertype_" + id).val();
        idcardtype = $("#ddlidcardtype_" + id).val();
        idcardnumber = $("#txt_idcardnumber_" + id).val();
        insurancenum = $("#ddlinsurance_" + id).val();
        insurancetotalprice = parseInt(insurancenum) * insuranceprice;
        ticketprice = $("#hid_ticketprice_" + id).val();
        airportprice = $("#hid_airportprice_" + id).val();
        fuelprice = $("#hid_fuelprice_" + id).val();
        totalprice = $("#hid_totalprice_" + id).val();
        if ($("#chbissave_" + id).attr("checked") == true) {
            issave = 1;
        }
        else {
            issave = 0;
        }
        jsonstring += '{ ID: "currentindex",Name:"' + name + '",Type:"' + type + '",Idcardtype:"' + idcardtype + '",Idcardnumber:"' + idcardnumber + '",Insurancenum:"' + insurancenum + '",Insurancemoney:"' + insurancetotalprice + '",Ticketprice:"' + ticketprice + '",Airportprice:"' + airportprice + '",Fuelprice:"' + fuelprice + '",Totalprice:"' + totalprice + '",Issave:"' + issave + '" },';

        $("#hidallpassengers").val("");
    });
    jsonstring += "]";
    jsonstring = jsonstring.replace(",]", "]");
    $("#hidallpassengers").val(jsonstring);
}

function changesendtype(divname) {
    $("div[id*='divsend_']").each(function (i) {
        $(this).hide();
    });
    $("#" + divname).show();

    if (divname == "divsend_getbymyself") {
        var address = "";
        var index = 0;
        var segstr1 = '<%=getSegmentlist()%>';
        var jsonList1 = JSON.parse(segstr1);
        for (var i = 0; i < airportaddress.length; i++) {
            var addressinfo = airportaddress[i];
            for (var j = 0; j < jsonList1.segmentinfos.length; j++) {
                var startairport = jsonList1.segmentinfos[j]["startairport"]
                var endairport = jsonList1.segmentinfos[j]["endairport"]

                if (addressinfo.code == startairport || addressinfo.code == endairport) {
                    index++;
                    address += "<p>" + index + "." + addressinfo.name + "</p>";
                    address += "<p>" + addressinfo.address + "(" + addressinfo.time + ")</p>";
                }
            }

        }
        $("#ligetbymyself").html(address);
    }

}


//显示常用旅客
function showcommonpassenger() {
    $.ajax({
        url: "",
        type: "POST",
        data: { Name: $("#txtsearchname").val(), IdCardNumber: $("#txtsearchcard").val(), Mobile: $("#txtsearchmobile").val() },
        success: function (data) {
            $("#divpassengercontainer").html(data);
            $dialog.dialog('open');
        }

    });
}
function setpassenger(name, idcardtype, idcardnumber) {
    var jsonstring = '[{ ID: "currentindex",Name:"' + name + '",Type:"1",Idcardtype:"' + idcardtype + '",Idcardnumber:"' + idcardnumber + '",Birthday:"",Insurancenum:"0",Insurancemoney:"' + insuranceprice + '",Ticketprice:"' + adultpassengerprice + '",Airportprice:"' + adultpassengerairport + '",Fuelprice:"' + adultpassengerfuel + '",Totalprice:"' + adultpricefee + '",Issave:"1",Customerpassid:""  }]';
    addpassenger(jsonstring);
    var divid = 0;
    $("div[id*='divinformation_']").each(function (i) {
        var idcur = $(this).attr("id").replace("divinformation_", "");
        divid = parseInt(idcur);
    });
    $("#ddlidcardtype_" + divid).val(idcardtype);
}