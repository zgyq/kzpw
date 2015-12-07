//导航与首页函数
$(document).ready(function(){

	
	
	
	//$("#jsHeaderNotice").html("您好，欢迎访问旅行网！");

	//快速切换
	$("#MenuCon .newSubMenu").hover(function(){
		$(this).find(".newSubCon").show();
		$(this).find(".newMenuBlock").addClass("newMenuBlockhover");
	},function(){
		$(this).find(".newSubCon").hide();
		$(this).find(".newMenuBlock").removeClass("newMenuBlockhover");
	});


	//----------返回顶部-------------------
	(function() {
		$backToTopEle = $('#jsBackTop');
		var $backToTopTxt = $('#jsBackTop').click(function() { $("html, body").animate({ scrollTop: 0 }, 164);
		}), $backToTopFun = function() {
			var st = $(document).scrollTop(), winh = $(window).height();
			(st > 0)? $backToTopEle.show(): $backToTopEle.hide(); 
		};
		$(window).bind("scroll", $backToTopFun);
		$(function() { $backToTopFun(); });

	
	})();
	


});

//选择项切换
function jsSoCheck(num){
	$("#sobox .sobt").removeClass("sobtnow");
	$("#sobox .solist").hide();
	$("#sobox .sobt").eq(num).addClass("sobtnow");
	$("#sobox .solist").eq(num).show();
}
//城市切换
function jsSoType(numType){
	if (numType==0){
		$("#jsEndTime").hide();
	
		
	}
	else
	{
		$("#jsEndTime").show();
	}
}

//城市切换
function jsSoCityChang(){
	var thisCity=$("#BeCity").val();
	
	//alert(thisCity);
	$("#BeCity").val( $("#EndCity").val() );
	$("#EndCity").val( thisCity );
}



function jsMbox(intNum,intNow){
	for (i=1; i<=intNum;i++){
		$("#jsMboxTit"+i).removeClass("btclick");
		$("#jsMboxList"+i).hide();
	}
	$("#jsMboxTit"+intNow).addClass("btclick");
	$("#jsMboxList"+intNow).show();
	
}

//------------------线路预定
function jsTourLineBookForm(TourLineID){
	$.post("/active/TourBookForm.asp",{
	TourLineID:TourLineID
		} ,function(data,status){
		$("#jsTourBookbox").html(data);
		jscalendarprice_hover();
		});	
}

function jsTourbook(){

var PersonCR = $("#PersonCR").val();
var PersonXH = $("#PersonXH").val();
var BeTime = $("#BeTime").val();
var TourLineID = $("#TourLineID").val();

if ( BeTime==""){ alert("请选择出发时间");$("#BeTime").focus();return false;  }

	alert(TourLineID);	

}

//日历表
function TourBookIsValid(){
	if ($("#tourbookform #Yourname").val()=="")
	{
		alert("联系人姓名不能为空!!!");
		$("#tourbookform #Yourname").focus();
		return false;
	}	
	if ($("#tourbookform #Tel").val()=="")
	{ alert("联系电话不能为空!!!"); $("#tourbookform #Tel").focus();return false; }	
	
}


function jsReLoadCalendar(MonthCMID,TourPricePlanStr,TourLineID,CalendarActive){
	$.post("/active/ReLoadCalendar.asp",{
		MonthCMID:MonthCMID,
		TourPricePlanStr:TourPricePlanStr,
		TourLineID:TourLineID,
		CalendarActive:CalendarActive
		} ,function(data,status){
		$("#jsCalendar_pricebox").html(data);
		//jscalendarprice_hover();
		});	
	
}

function jscalendarprice_open(CalendarID,CR,XH){
	 
	 var jsBookLeft = (document.body.clientWidth-600)/2;
	 var jsBookTop = (document.body.clientHeight-350)/2;
	 $("#jsBookbox").show();
	 
	 //$("#jsTourBookbox #tourbookbox").html(jsBookLeft);
	 $("#jsBookbox #bookbox").css("left",jsBookLeft+"px");
	 $("#jsBookbox #bookbox").css("top",jsBookTop+"px");
	
	
	 TourBookValue = $("#calendarpriceDay"+CalendarID).val();
	 TourBookTourLineID = $("#calendarpriceTourLineID").val();

		$.post("/active/QuickBookFrom.asp",{
		TourBookValue:TourBookValue,
		TourBookTourLineID:TourBookTourLineID,
		PersonCountCR:CR,
		PersonCountXH:XH
		} ,function(data,status){
		$("#jsBookFormBox").html(data);
		});		
	
	 //$("#jsBookFormBox").html(  );
	 //var HomeFocusWidth = window.screen.width-20;
	 //var priceMenu_BaseTop=$("#pricebox_menu").offset().top-50;  //存储原来的距离顶部的距离 
	 //photoST = Math.max(document.body.scrollTop || document.documentElement.scrollTop );
	
	//PersonCR=$('#tourbookform #PersonCR').val();
	//PersonXH=$('#tourbookform #PersonXH').val();
	//if (PersonCR=="") { alert("请输入人数字");document.tourbookform.PersonCR.focus();return false;}
}

function jscalendarprice_close(){
$("#jsBookbox").hide();
$("#jsBookFormBox").html('');
}

function openQQUrl(){


//var qqbtn = ""


//$("#footer-link").append(qqbtn);


//document.getElementByIdx_x('formqq').submit();

	
//window.open("http://wpa.qq.com/msgrd?v=3&uin=1078476212&site=qq&menu=yes");
}


 



