
function e(event){	 var e = window.event || event ; return  e['target'] || e['srcElement'];}

function maopao(event){var ev = window.event || event ;if(ev.stopPropagation){ev.stopPropagation();}else{ev.cancelBubble=true;}}

$(function () {

    //头部 标题
    var url = window.location.href;
    var aurl = url.split("?");
    var r = aurl[0];
    var t = document.getElementById("f-nav").getElementsByTagName("a");
    var li = document.getElementById("f-nav").getElementsByTagName("li");
    var sytle = ""; //"background:#fff;color:#2597d7;border-top:2px solid #f57403";
    var sytle2 = ""; //"color:#2597d7;border-top:2px solid #f57403";
    for (var i = 0; i < t.length; i++) {
        t[i].className = "";
        if (t[i].href == r) {
            var n = t[i].parentNode.firstChild.nodeName.toLocaleLowerCase();
            if (n == "i") {
                //t[i].style.cssText = sytle2;
                //t[i].parentNode.style.cssText = "background:#fff";
                //t[i].parentNode.firstChild.className = "f-down";
            } else {
                //t[i].style.cssText = sytle;
            }
        }

    }
    $("#f-nav").mouseover(function (event) {
        var aa = $(this).find('a');
        var li = $(this).find('li');
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        if (c == "a") {
            var n = tag.parentNode.firstChild.nodeName.toLocaleLowerCase();
            for (var i = 0; i < aa.length; i++) { aa[i].className = ""; }
            if (n == "i") {
                var h = tag.getAttribute('alt');
                tag.parentNode.className = "f-up";
                tag.parentNode.firstChild.className = "";
                tag.parentNode.style.cssText = "";
                $("#dropmenu_" + h).slideDown(function () {
                    $(this).mouseover(function () {
                        $(this).show();
                        tag.parentNode.className = "f-up";
                        tag.parentNode.style.cssText = "";
                        tag.parentNode.firstChild.className = "";
                    }).stop(true);
                    $(this).mouseout(function () {
                        $(this).hide();
                        tag.parentNode.className = "";
                        tag.parentNode.firstChild.className = "f-a";
                        if (tag == r) {
                            tag.style.cssText = sytle2;
                            //tag.parentNode.style.cssText = "background:#fff";
                            tag.parentNode.firstChild.className = "f-down";
                        }
                    }).stop(true);
                });
                tag.onmouseout = function () {
                    $("#dropmenu_" + h).hide();
                    tag.parentNode.className = "";
                    tag.parentNode.firstChild.className = "f-a";
                    if (tag == r) {
                        //tag.parentNode.style.cssText = "background:#fff";
                        tag.parentNode.firstChild.className = "f-down";
                    }
                }
            } else {
                tag.className = "checked";
            }
        }
    })
    $("#f-nav").mouseout(function () {
        var aa = $(this).find('a');
        for (var i = 0; i < aa.length; i++) {
            aa[i].className = "";
        }
    })
    // 左侧 标题
    $(".m-sd").find('h3').click(function () {
        var c = $(this).hasClass('bg');
        if (c) {
            $(this).removeClass('bg').next('ul').find('li').slideUp(200);
            $(this).find('span').addClass("f-side").removeClass("side-d");
        } else {
            $(".m-sd").find('h3').not($(this)).removeClass("bg").next('ul').find('li').slideUp(200);
            $(".m-sd").find('h3').not($(this)).find('span').addClass("f-side").removeClass("side-d");
            $(this).addClass("bg");
            $(this).next("ul").find('li').addClass("open").slideDown(200);
            $(this).find('span').addClass("side-d").removeClass("f-side");
        }
    })
    $(".m-sd").click(function (event) {
        var tag = e(event);
        var n = tag.nodeName; //.toLocaleLowerCase();
        if (n) {
            n = n.toLocaleLowerCase();
        }
        if (n == "a") {
            var span = document.createElement("span");
            var a = $(this).find(n);
            var s = $(this).find(n).find('span');
            s.remove();
            for (var i = 0; i < a.length; i++) { a[i].className = ""; }
            tag.appendChild(span);
            tag.className = "checkin";
        }
    })
    //机票查询			 
    $("#ticket").mouseover(function (event) {
        var tag = e(event);
        if (tag.className == "buy") {
            $(".buy").unbind('click');
            $(".buy").bind('click', function () {
                if ($(this).next("div").is(":hidden")) {
                    $(".buy").next("div").hide();
                    $(".buybg").css({ display: "" });
                    $(".bm").css({ display: "none" });
                    $(this).find('span').first().css({ display: "none" });
                    $(this).find('span').last().css({ display: "block" });
                    $(this).next("div").show();
                } else {
                    $(this).find('span').first().css({ display: "inline-block" });
                    $(this).find('span').last().css({ display: " " });
                    $(".bm").css({ display: "none" });
                    $(this).next("div").hide();
                }
                $(this).parent().addClass("bg").siblings().removeClass("bg");
            })
        }
    })
    $("#arr-d").mouseover(function (event) {
        var ali = $("#arr-d").find('li');
        var a = $("#arr-d").find('a');
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        if (c == "a") {
            for (var i = 0; i < a.length; i++) { a[i].className = "" }
            tag.onclick = function () {
                for (var i = 0; i < ali.length; i++) { ali[i].className = "" }
                tag.parentNode.className = "checked";
                tag.className = "";
            }
            if (tag.parentNode.className == "") {
                tag.className = "hover";
            }
        }
    })
    $("#arr").mouseover(function (event) {
        var ali = $("#arr").find('li');
        var a = $("#arr").find('a');
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        if (c == "span") {
            for (var i = 0; i < a.length; i++) { a[i].className = "" }
            tag.onclick = function () {
                for (var i = 0; i < ali.length; i++) { ali[i].className = "" }
                tag.parentNode.parentNode.className = "checked";
                tag.parentNode.className = "";
            }
            if (tag.parentNode.parentNode.className != "checked") {
                tag.parentNode.className = "hover";
            }
        }
    })
    $('.box').mouseout(function () {
        var a = $(this).find('a');
        for (var i = 0; i < a.length; i++) { a[i].className = "" }
    })
    $(".arr-right").mouseover(function (event) {
        var lilengt = $("#arr").find('li');
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        if (c == "a") {
            tag.onclick = function () {
                for (var j = 0; j < lilengt.length; j++) {
                    var r = lilengt[j].offsetLeft;
                    if (r == "1" || r == "0") {
                        if (lilengt.length - j > 7) {
                            $("#arr").find('li').animate({ left: ((j / 7) + 1) * (-7 * 91) + "px" }, 1000);
                        }
                        if (lilengt.length - j < 15) {
                            $(this).addClass("arrow_right_disable").removeClass("arrow_right");
                        }
                        $(".arr-left").find('a').addClass("arrow_left").removeClass("arrow_left_disable");
                    }
                }
            }
        }
    })
    $(".arr-left").mouseover(function (event) {
        var lilengt = $("#arr").find('li');
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        if (c == "a") {
            tag.onclick = function () {
                for (var j = 0; j < lilengt.length; j++) {
                    var r = lilengt[j].offsetLeft;
                    if (r == "1" || r == "0") {
                        if (j) {
                            $("#arr").find('li').animate({ left: ((j / 7) - 1) * (-7 * 91) + "px" }, 1000);
                            if (j == 7) {
                                $(this).addClass("arrow_left_disable").removeClass("arrow_left");
                            }
                            if (j > 7) {
                                $(".arr-right").find('a').addClass("arrow_right").removeClass("arrow_right_disable");
                            }
                        }
                    }
                }
            }
        }
    })
    $(".btn-sch").find('span').toggle(
  function () {
      $(this).addClass("unshow").removeClass("show");
      $(".search").show();
  },
  function () {
      $(this).addClass("show").removeClass("unshow");
      $(".search").hide();
      $(".comp").show();
      $("#check-city").hide();
  }
);
    $(".xc-cz").mouseover(function (event) {
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        var a = $(this).find('a');
        if (c == "a") {
            tag.onclick = function () {
                for (var i = 0; i < a.length; i++) { a[i].className = ''; }
                tag.className = "bg";
            }
        }
    })

    //提现 转账 充值	
    $(".btn").mouseover(function (event) {
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        var a = $(this).find('a');
        if (c == "a") {
            tag.onclick = function () {
                for (var i = 0; i < a.length; i++) { a[i].className = ''; }
                tag.className = "pay";
            }
        }
    })


    //酒店选择

    $(".m-jd").mouseover(function (event) {
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        if (c == "a") {
            tag.onclick = function () {
                if (tag.className == "down") {
                    $("#hote-address").show();
                    tag.className = "up";
                } else {
                    tag.className = "down";
                    $("#hote-address").hide();
                }
            }
        }
    })

    check("#price_style");
    check("#hotel-style");
    check("#brand");
    var num = $("#hote-address").find("input:checked");
    for (var i = 0; i < num.length; i++) { if (num[i].checked) num[i].parentNode.style.cssText = "background:#06c;color:#fff"; }
    $(".jd-snav").mouseover(function (event) {
        var tag = e(event);
        var c = tag.nodeName.toLocaleLowerCase();
        if (c == 'a') {
            tag.onclick = function () {
                var num = $("#hote-address").find("input:checked");
                for (var i = 0; i < num.length; i++) {
                    num[i].checked = false;
                    num[i].parentNode.style.cssText = "";
                }
            }
        }
    })
    //城市选择
    //高级搜索
    getcity("#city", "tick", ".xuan");
    getcity("#indexcity", "indextick", ".xuan");
    // 出发城市	
    getcity("#gocity", "gocity", "");
    getcity("#j-1", "j", "");
    // 到达城市
    getcity("#reach", "reach", "");
})				
function getcity(inputid,cityclass,xuan){
$(inputid).val('')
$(inputid).focus(function(){
	    $(xuan).hide();
	   
	   $("#check-city").css({display:"inline-block",paddingBottom:"10px"});
	    $("#check-city").removeClass().addClass(cityclass);
	   $("#check-city").load("city.html",function(){		  	
         var w = $("#check-city").height();						 
				if($.browser.msie && ($.browser.version == "6.0")){
				$("iframe").css({height:w}) 				
				}   
	   });
	//头部选项
$("#check-city").mouseover(function(){
	   $(inputid).unbind("blur");
	   $(".city-nav").bind("mouseover",function(event){
		   	     var tag = e(event);
				var c = tag.nodeName.toLocaleLowerCase();
				var mun = $(this).find('li');
	   	  if(c=='a'){						 
			 tag.onclick = function(){
				  tag.hideFocus="true";
				  for(var i=0;i<mun.length;i++){	 mun[i].className=""; }				  				
				  tag.parentNode.className="check";
				 
				 for(var i=0;i<mun.length;i++){					 
				 	$(".address_"+(i+1)).hide();		 
				  if(mun[i].className=="check"){						
					   $(".address_"+(i+1)).css({display:"inline-block"});				   
					  };
					  var w = $("#check-city").height();						 
				         $("iframe").css({height:w})  					  
				   }   
				 } 
		  	  }		   
		   })
	//内部标签	   
	 $(".c-content").bind("mouseover",function(event){		 
		  var tag = e(event);
		 var c = tag.nodeName.toLocaleLowerCase();		
	       if(c=='a'){
		      tag.onclick = function(){			
				var con = tag.innerHTML;
				$(inputid).val(con);
				$("#check-city").hide();			
				}
		     }
		 })
	  //关闭按钮		 
   $(".close").bind("click",function(){
	 	$("#check-city").hide();
	   if($(inputid).val()==""){$(xuan).show()};
	      })	   
	   })
$("#check-city").mouseout(function(){ 
 $(inputid).bind("blur",function(){$("#check-city").hide(); 
  if($(inputid).val()==""){$(xuan).show()};
   });  
 })	 
$(inputid).blur(function(){ $("#check-city").hide(); if($(inputid).val()==""){$(xuan).show()};})		   
	})
}



// 酒店选择

function check(id){	  
$(id).mouseover(function(event){	   		
		 var   tag = e(event);
		  var c = tag.nodeName.toLocaleLowerCase();
		  var p =$(this).find('input');	
	tag.onclick =function(event){ 				
		      if(c=="label"){							
				 $(id).find("li:first").removeAttr('style');	 		
				 if(tag.firstChild.getAttribute("checked")){					  
						  if($.browser.msie && ($.browser.version < "8.0")){
							   if($.browser.msie && ($.browser.version == "6.0")){
								 if($(id).find('input').attr("type")=="checkbox"){ tag.firstChild.checked=false;}  
								   }
								tag.style.cssText="background:#06c;color:#fff" ; 																	   
							  }else{
							 tag.style.cssText="background:#fff"  ;
							 }
					    }else{												 
					  if($.browser.msie && ($.browser.version == "6.0")){tag.firstChild.checked=true;}								
						if(tag.firstChild.checked){ tag.style.cssText="background:#06c;color:#fff" ; }
					   }
					maopao(event);									  						     							  
		    	   }				 
		    if(c=="input"){
			        $(id).find("li:first").removeAttr('style');										
						if(tag.parentNode.nodeName.toLocaleLowerCase()=="label"){
						   tag.parentNode.style.cssText="background:#06c;color:#fff";
							}							 
					     maopao(event);				 								 					
					  }
          if(c=="li"){						 
				  for(var i=0;i<p.length;i++){p[i].checked="";} 
				   if(tag.firstChild.nodeName.toLocaleLowerCase()!="label")tag.style.cssText="color:#06c;font-weight:900";
				 }
    for(var i=0;i<p.length;i++){if(p[i].checked==false){p[i].parentNode.style.cssText="";}} 	
	 }
	})
}
  
function iFrameHeight() {
    var ifm = document.getElementById("mainframe");

var subWeb = document.frames ? document.frames["mainframe"].document : ifm.contentDocument;   
if(ifm != null && subWeb != null) {
    ifm.height = subWeb.body.scrollHeight;
}   
}   


















