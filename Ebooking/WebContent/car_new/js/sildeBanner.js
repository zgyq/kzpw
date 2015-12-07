

// <!-- slideBanner js-->

$(function(){
	// 定义全局的游标参数
	var cur=0;
	//效果显示函数
	function show(){
		
		//注意要将显示层层级放到最上面z-index=1	
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).stop();
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).animate({opacity:1},400).css("z-index","1");
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).find(".hiddenAd").stop();
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).find(".hiddenAd").animate({top:"-10px",opacity:1});  
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).siblings(".slideCon").stop();
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).siblings(".slideCon").animate({opacity:0},400).css("z-index","0");;
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).siblings(".slideCon").find(".hiddenAd").stop()
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).siblings(".slideCon").find(".hiddenAd").animate({top:"-40px",opacity:0})

		

		//rigntAd加焦点效果
		$("#mfpSlide #mfpSlide_con .slideCon").eq(cur).find(".rightAd").children().hover(function(){
			// alert($(this).index())
			// $(this).animate({opacity:1},400).siblings("li").animate({opacity:0.7},400)
			$(this).css({opacity:1}).siblings("li").css({opacity:0.7})
			
		},function(){
			// alert(2)
			$(this).parent().children().css("opacity",1)
		})
		// navlist显示
		$("#mfpSlide #mfpSlide_nav li").eq(cur).addClass("hover").siblings("li").removeClass("hover")
	}
	//定义一个自动播放函数
	function autoPlay(){
		// alert(cur)
		cur++;
		cur=cur==5?0:cur;
		show()	
	}
	//定时器执行前的处理

	$("#mfpSlide #mfpSlide_con .slideCon").first().css({opacity:1,zInde:1});
	$("#mfpSlide #mfpSlide_con .slideCon").first().siblings(".slideCon").css({opacity:0,zInde:0});
	$("#mfpSlide #mfpSlide_con .slideCon").first().find(".hiddenAd").css({top:"-10px",opacity:1})

	$("#mfpSlide #mfpSlide_con .slideCon .slideCenter .rightAd li").hover(function(){
			$(this).css({opacity:1}).siblings("li").css({opacity:0.7})
			
		},function(){
			$(this).parent().children().css("opacity",1)
		})

	var timer=setInterval(autoPlay,4000);

	//鼠标导航
	$("#mfpSlide #mfpSlide_nav li").hover(function(){
		clearInterval(timer);
		cur=$(this).index();
		show();
	},function(){
		timer=setInterval(autoPlay,4000);
	})
	// //鼠标悬停在图片上时停止
	// $("#mfpSlide #mfpSlide_con .slideCon").hover(function(){
	// 	clearInterval(timer);
	// },function(){
	// 	timer=setInterval(autoPlay,4000);
	// })
	
})