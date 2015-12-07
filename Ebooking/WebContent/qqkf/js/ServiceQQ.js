/*Tang cxx 整理 */
/*1193367@qq.com */

document.writeln("<div id=\"divSerWin\" class=\"service\">");
document.writeln("<div id=\"divMySer\" class=\"service-close\">");
document.writeln("<div class=\"service-button\" onclick='ClickSer();'></div>");
document.writeln("<div class=\"service-inside\">");
document.writeln("<dl>");
document.writeln("<dt>出票</dt>");
document.writeln("<dd><a href=\"tencent://message/?uin=254131787\">在线客服①</a></dd>");
document.writeln("<dd><a href=\"tencent://message/?uin=2483091841\">在线客服②</a></dd>");
document.writeln("<dd><a href=\"tencent://message/?uin=2090640438\">在线客服③</a></dd>");
document.writeln("<dd><a href=\"tencent://message/?uin=2992936715\">在线客服④</a></dd>");
document.writeln("<li >021-64967822</li>");
document.writeln("<dt>改签</dt>");
document.writeln("<dd><a href=\"tencent://message/?uin=2022306188\">在线客服①</a></dd>");
document.writeln("<dd><a href=\"tencent://message/?uin=57839356\">在线客服②</a></dd>");
document.writeln("<li >021-64968621</li>");
document.writeln("<dt>退票</dt>");
document.writeln("<dd><a href=\"tencent://message/?uin=301433981\">在线客服①</a></dd>");
document.writeln("<dd><a href=\"tencent://message/?uin=2415065899\">在线客服②</a></dd>");
document.writeln("<li >021-54722315</li>");
//document.writeln("<dt>投诉</dt>");
//document.writeln("<dd class=\"esp_1\"><a href=\"tencent://message/?uin=1624872501\">投诉建议</a></dd>");
//document.writeln("<li >021-54718703</li>");
document.writeln("<dt>夜间</dt>");
document.writeln("<li >18221186820</li>");
document.writeln("<li >13391271888</li>");
document.writeln("</dl>");
document.writeln("</div>");
document.writeln("<div style=\"clear:both;\"></div>");
document.writeln("</div>");
document.writeln("</div>");


function ClickSer(){
    var obj=$("#divMySer")
    if( obj.attr("class") == "service-open" )
        $("#divMySer").removeClass("service-open").addClass("service-close");
    else
        $("#divMySer").removeClass("service-close").addClass("service-open");
}

function qqmove()
{
	var t,wh,qqh,st;
	wh=$(window).height();
	qqh=$("#divSerWin").height();
	st=$(window).scrollTop();
	t=(wh-qqh)/4+st;
	$("#divSerWin").css("top",t);
	$("#divSerWin").animate({"top":t},50).dequeue;
}
$(function(){
$(window).scroll(function(){qqmove();});
});