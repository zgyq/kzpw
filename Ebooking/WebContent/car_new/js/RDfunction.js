// JavaScript Document
$(function(){
	//设置下拉的JS
		$(".RDnav li").hover(function(){
			$(this).children(".RDnavXiala").css("display","block")
		},function(){
			$(this).children(".RDnavXiala").css("display","none")
		})
			
			
	
	//导航部分品牌中心的js
	
        $(".erjiTitle").hover(function(){
			$(this).children("ul").css("display","block")
			$(".erjiTitle").css("height","165px")
		},function(){
			$(".erjiTitle ul").css("display","none")
			$(".erjiTitle").css("height","auto")
		})
	//设置导航头部的切换城市的JS
	$(".RDheaderLeft div").hover(function(){
		$(".RDheaderLeft div ul").addClass("RDheaderLeftFocus")
	},function(){
		$(".RDheaderLeft div ul").removeClass("RDheaderLeftFocus")
	})
	
	//当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否
		$(".rightFloat").css("height","100%")
		$(window).scroll(function(){
			if ($(window).scrollTop()>0){
				$(".rightFloat").css("top","0px")
			}
			else
			{
				$(".rightFloat").css("top","106px")
				$(".rightFloat").css("height","100%")
			}
		});
		 //当点击跳转链接后，回到页面顶部位置
			$(".gotoTop").click(function(){
				$('body,html').animate({scrollTop:0},1000);
				return false;
			});
		//设置右边公共部分鼠标移动上去img的透明度
		//$(".rightFloat ul li").addClass("opacityImg")
		$(".rightFloat ul li").hover(function(){
			$(this).addClass("opacityImg")
		},function(){
			$(".rightFloat ul li").removeClass("opacityImg")
		})
	//表单focus
		$(":input").focus(function(){
			  $(this).addClass("focus");
			  if($(this).val() ==this.defaultValue){  
                  $(this).val("");           
			  } 
		}).blur(function(){
			 $(this).removeClass("focus");
			 if ($(this).val() == '') {
                $(this).val(this.defaultValue);
             }
		});
		
		//设置理念和品牌之间的切换
		$(".pinpaiBtn span:last").click(function(){
			//$(".pinpaiTips span").removeClass("pinpaiFocus")
			//$(".pinpaiTips span:last").addClass("pinpaiFocus")
			$(".pinpailinian ul li").removeClass("pinpailinianFocus")
			$(".pinpailinian ul li:last").addClass("pinpailinianFocus")
		})
		$(".pinpaiBtn span:first").click(function(){
			//$(".pinpaiTips span").removeClass("pinpaiFocus")
			//$(".pinpaiTips span:first").addClass("pinpaiFocus")
			$(".pinpailinian ul li").removeClass("pinpailinianFocus")
			$(".pinpailinian ul li:first").addClass("pinpailinianFocus")
		})
		
	//设置语言选择部分鼠标经过显示
		$(".RDheaderRight .yuyanChange").hover(function(){
			$(this).children("div").css("display","block")
			
		},function(){
			$(this).children("div").css("display","none")
		})
		//设置点击yincangBtn隐藏dl下面的一些dd
		$(".yincangBtn").click(function(){
			if($(".RDfooterFuWu").height()>0){
				$(".RDfooter1 dl dd").css("display","none")
				$(".RDfooterFuWu").css("height","0")
				$(".RDfooterFuWu").css("display","none")
				$(".RDfooter1").css("padding-bottom","10px")
				$(this).children("img").attr("src","images/jia.png")
			}else if($(".RDfooterFuWu").height()==0){
				$(".RDfooter1 dl dd").css("display","block")
				$(".RDfooterFuWu").css("height","auto")
				$(".RDfooterFuWu").css("display","block")
				$(".RDfooter1").css("padding-bottom","50px")
				$(this).children("img").attr("src","images/jian.png")
			}
		})
		//设置fenleiMore的下面的ul的宽
		var heWidth=6;
		for(i=0;i<$(".fenleiMore ul li").length;i++){
			var heWidth=heWidth+$(".fenleiMore ul li").eq(i).width()
			//alert($(".fenleiMore ul li").eq(i).width())
			$(".fenleiMore ul").css("width",heWidth)
		}
		
		//给浮动层添加播放按钮
		var fucengImg=$("<img src='product-images/fuceng.png' class='fucengImg' />")
		$(".fuceng a").append(fucengImg)
		
		//设置分页的最后一个a的右边框
		$(".RDpage a:first").css("margin-left","487px")
		$(".RDpage a:last").css("border-right","1px solid #e5e5e5")
		
		
		//$("#floor1 p.brandWordListTips span").each(function(index) {
//            $(this).hover(function(){
//				//alert("aaaa")
//				$("#floor1 p.brandWordListTips span a").removeClass("brandWordListTipsFocus")
//				$(this).children('a').addClass("brandWordListTipsFocus")
//				$("#floor1 .tabqiehuan").removeClass("tabqiehuanFocus")
//				$("#floor1 .tabqiehuan").eq(index).addClass("tabqiehuanFocus")
//			})
//        });
		
		
		
		
})


