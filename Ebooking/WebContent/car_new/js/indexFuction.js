// JavaScript Document


// <!-- slideBanner js-->

$(function(){
	// 定义全局的游标参数
	var cur=0;
	//效果显示函数
	function show(){
		
		//注意要将显示层层级放到最上面z-index=1	
		$(".floatDiv .indexLi").eq(cur).stop();
		$(".floatDiv .indexLi").eq(cur).animate({opacity:1},400).css("z-index","1");
		$(".floatDiv .indexLi").eq(cur).find(".hiddenAd").stop();
		$(".floatDiv .indexLi").eq(cur).find(".hiddenAd").animate({top:"-10px",opacity:1});  
		$(".floatDiv .indexLi").eq(cur).siblings(".indexLi").stop();
		$(".floatDiv .indexLi").eq(cur).siblings(".indexLi").animate({opacity:1},400).css("z-index","0");;
		$(".floatDiv .indexLi").eq(cur).siblings(".indexLi").find(".hiddenAd").stop()
		$(".floatDiv .indexLi").eq(cur).siblings(".indexLi").find(".hiddenAd").animate({top:"-40px",opacity:0})

		

		//rigntAd加焦点效果
		$(".indexShowList .indexLi").eq(cur).find(".rightAd").children().hover(function(){
			// alert($(this).index())
			// $(this).animate({opacity:1},400).siblings("li").animate({opacity:0.7},400)
			$(this).css({opacity:1}).siblings("li").css({opacity:0.7})
			
		},function(){
			// alert(2)
			$(this).parent().children().css("opacity",1)
		})
		// navlist显示
		$(".indexShowList li").eq(cur).addClass("indexShowFocus").siblings("li").removeClass("indexShowFocus")
	}
	//定义一个自动播放函数
	function autoPlay(){
		// alert(cur)
		cur++;
		cur=cur==5?0:cur;
		show()	
	}
	//定时器执行前的处理

	$(".floatDiv .indexLi").first().css({opacity:1,zInde:1});
	$(".floatDiv .indexLi").first().siblings(".indexLi").css({opacity:1,zInde:0});
	$(".floatDiv .indexLi").first().find(".hiddenAd").css({top:"-10px",opacity:1})

	$("#mfpSlide #mfpSlide_con .slideCon .slideCenter .rightAd li").hover(function(){
			$(this).css({opacity:1}).siblings("li").css({opacity:0.7})
			
		},function(){
			$(this).parent().children().css("opacity",1)
		})

	var timer=setInterval(autoPlay,5000);

	//鼠标导航
	$(".indexShowList li").hover(function(){
		clearInterval(timer);
		cur=$(this).index();
		show();
	},function(){
		timer=setInterval(autoPlay,5000);
	})
	// //鼠标悬停在图片上时停止
	// $("#mfpSlide #mfpSlide_con .slideCon").hover(function(){
	// 	clearInterval(timer);
	// },function(){
	// 	timer=setInterval(autoPlay,4000);
	// })
	
})