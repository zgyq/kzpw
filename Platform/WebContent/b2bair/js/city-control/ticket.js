function bindroundfromcity() {
	//绑定联程出发城市
	$("#arrcity-lc").val($("#tocity").val());
	$("#city_from_hide_lc").val($("#city_to_hide").val());
}
function showBackDate() {
	if ($("#rdoSingle").attr("checked")) {
		$("#tr_diyicheng").hide();
		$("#tr_diercheng").hide();
		$("#tr_dierchenginfo").hide();
		$("#tr_dierchenginfo_date").hide();
		$("#tr_diercheng_kongbaihang").hide();
		$("#lblBackDate").hide();
		$("#divBackDate").hide();
	}
	if ($("#rdoBack").attr("checked")) {
		$("#lblBackDate").show();
		$("#divBackDate").show();
		$("#tr_diyicheng").hide();
		$("#tr_diercheng").hide();
		$("#tr_dierchenginfo").hide();
		$("#tr_dierchenginfo_date").hide();
		$("#tr_diercheng_kongbaihang").hide();
	}
	if ($("#rdoLiancheng").attr("checked")) {
		$("#tr_diyicheng").show();
		$("#tr_diercheng").show();
		$("#tr_dierchenginfo").show();
		$("#tr_dierchenginfo_date").show();
		$("#tr_diercheng_kongbaihang").show();
		$("#lblBackDate").hide();
		$("#divBackDate").hide();
	}
}
function showposhytip(controlid) {
	$("#" + controlid).poshytip({
		className : 'tip-yellowsimple',
		showOn : 'focus',
		alignTo : 'target',
		alignX : 'right',
		alignY : 'center',
		offsetX : 5
	});
}
function CheckData() {
	if ($("#city_from_hide").val() == "") {
		showSearch('arrcity', 'city_from_hide');
	}
	if ($("#city_to_hide").val() == "") {
		showSearch('tocity', 'city_to_hide');
	}

	if ($("#txthid_isallowsearch").val() == "1") {
		alert("您所属的代理商已经有五个订单未支付,请支付或者取消订单后再进行航班查询！");
		return false;
	}
	if (eval($("#allowsearchnum").val()) != 0
			&& eval($("#allowsearchnum").val()) < eval($("#searchnum")
					.val())) {
		alert("您的查询次数已经到了,请联系客服!");
		return false;
	}
	var rdoFrom = document.getElementById("rdoBack");
	var rdoOnlone = document.getElementById("rdoSingle");
	var rdoLiancheng = document.getElementById("rdoLiancheng");
	if ($("#arrcity").val() == "" || $("#city_from_hide").val == ""
			|| $("#arrcity").val() == "中文/拼音") {
		showposhytip("arrcity");
		$("#arrcity").focus();
		return false;
	}
	if ($("#tocity").val() == "" || $("#city_to_hide").val == ""
			|| $("#tocity").val() == "中文/拼音") {
		$("#tocity").attr("title","请输入目的城市");
		showposhytip("tocity");
		$("#tocity").focus();
		return false;
	}

	if ($("#city_from_hide").val() == $("#city_to_hide").val()) {
		$("#tocity").attr("title","目的城市和出发城市一样,请重新选择");
		showposhytip("tocity");
		$("#tocity").focus();
		return false;
	}
	
	if ($("#txtStartDate").val() == "") {
		showposhytip("txtStartDate");
		$("#txtStartDate").focus();
		return false;
	}

	if (rdoFrom.checked == true) {
		if ($("#txtStartDate").val() == "") {
			showposhytip("txtStartDate");
			$("#txtStartDate").focus();
			return false;
		}
		if ($("#txtBackDate").val() == "") {
			showposhytip("txtBackDate");
			$("#txtBackDate").focus();
			return false;
		} else if (Computation($("#txtStartDate").val(), $("#txtBackDate")
				.val()) > 0) {
			$("#txtBackDate").attr("title", "返程日期不能早于出发日期,请检查后重新填写");
			showposhytip("txtBackDate");
			$("#txtBackDate").focus();
			return false;
		}
	}

	//联程信息验证
	if (rdoLiancheng.checked == true) {
		if ($("#arrcity-lc").val() == ""
				|| $("#city_from_hide_lc").val == ""
				|| $("#arrcity-lc").val() == "中文/拼音") {
			$("#tocity-lc").attr("title", "请输入第二程出发城市");
			showposhytip("arrcity-lc");
			$("#arrcity-lc").focus();
			return false;
		}
		if ($("#tocity-lc").val() == "" || $("#city_to_hide_lc").val == ""
				|| $("#tocity-lc").val() == "中文/拼音") {
			$("#tocity-lc").attr("title", "请输入第二程目的城市");
			showposhytip("tocity-lc");
			$("#tocity-lc").focus();
			return false;
		}
		if ($("#txtStartDate-lc").val() == ""){//中文/拼音
			$("#txtStartDate-lc").attr("title", "请输入第二程出发日期");
			showposhytip("txtStartDate-lc");
			$("#txtStartDate-lc").focus();
			return false;
		} else if (Computation($("#txtStartDate").val(), $(
				"#txtStartDate-lc").val()) > 0) {
			$("#txtStartDate-lc").attr("title", "目的城市和出发城市一样,请重新选择");
			showposhytip("txtStartDate-lc");
			$("#txtStartDate-lc").focus();
			return false;
		} else if ($("#city_from_hide_lc").val()!=$("#city_to_hide").val()) {
			$("#arrcity-lc").attr("title", "第二程出发城市必须和第一程的目的城市一样,请重新选择！");
			showposhytip("arrcity-lc");
			$("#arrcity-lc").focus();
			return false;
		} else if ($("#city_from_hide_lc").val()==$("#city_to_hide_lc").val()) {
			$("#tocity-lc").attr("title", "第二程出发城市不能和第二程的目的城市一样,请重新选择！");
			showposhytip("tocity-lc");
			$("#tocity-lc").focus();
			return false;
		}
	}
	loading('系统正在为您查询');
	return true;
}
function hideddl() {
	$("#ddlAirCom").hide();
}
function showddl() {
	$("#ddlAirCom").show();
}
function showzrate() {
	if ($("#chbhidezrate").val() == "0") {
		$("#txtHideZrate").val("1");
		$("#chbhidezrate").val("1");
	} else {
		$("#txtHideZrate").val("0");
		$("#chbhidezrate").val("0");
	}

}