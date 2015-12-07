/*
 * 	Easy Slider 1.5 - jQuery plugin
 *	written by Alen Grakalic	
 *	http://cssglobe.com/post/4004/easy-slider-15-the-easiest-jquery-plugin-for-sliding
 *  Download by http://www.codefans.net
 *	Copyright (c) 2009 Alen Grakalic (http://cssglobe.com)
 *	Dual licensed under the MIT (MIT-LICENSE.txt)
 *	and GPL (GPL-LICENSE.txt) licenses.
 *
 *	Built for jQuery library
 *	http://jquery.com
 *
 */
 
/*
 *	markup example for $("#slider").easySlider();
 *	
 * 	<div id="slider">
 *		<ul>
 *			<li><img src="images/01.jpg" alt="" /></li>
 *			<li><img src="images/02.jpg" alt="" /></li>
 *			<li><img src="images/03.jpg" alt="" /></li>
 *			<li><img src="images/04.jpg" alt="" /></li>
 *			<li><img src="images/05.jpg" alt="" /></li>
 *		</ul>
 *	</div>
 *
 */

(function($) {

	$.fn.easySlider = function(options){
	  
		// default configuration properties
		var defaults = {			
			prevId: 		'prevBtn',
			prevText: 		'Previous',
			nextId: 		'nextBtn',	
			nextText: 		'Next',
			/*controlsShow:	true,
			controlsBefore:	'',
			controlsAfter:	'',	*/
			controlsFade:	true,
			firstId: 		'firstBtn',
			firstText: 		'First',
			firstShow:		false,
			lastId: 		'lastBtn',	
			lastText: 		'Last',
			lastShow:		false,				
			vertical:		false,
			speed: 			800,
			auto:			false,
			pause:			500000000000,
			continuous:		false,
			quantity: 		1//显示的数量			
		}; 
		var options = $.extend(defaults, options);  
				
		this.each(function() {  
			var obj = $(this); 				
			var s = $("li", obj).length;
			var w = $("li", obj).width(); 
			var h = $("li", obj).height(); 
			
			var suitcount=(options.quantity>=s)?s:options.quantity;
			//如果显示的图片数量总宽度比容器大(或者小于或等于0)的话就会设置为以1张来显示
			var suitwidth = suitcount*w;
			if((suitcount*w) > $("ul", obj).width() || suitcount<=0)
			{
				suitcount=1;
				suitwidth = suitcount*w;
			}
			obj.width(suitwidth); 
			obj.height(h); 
/*			obj.width( $("ul", obj).width());
			obj.height($("ul", obj).height());*/
						//alert("width:"+obj.width()+"\nheight:"+obj.height());
			obj.css("overflow","hidden");
			
			var ts = options.vertical? (parseInt(s/suitcount)-((s%suitcount>0)?0:1)):(s-suitcount);
			var t = 0;
		
			//alert("LIwidth:"+$("li", obj).width()+"\nLIheight:"+$("li", obj).height()+"ULwidth:"+$("ul", obj).width()+"\nULheight:"+$("ul", obj).height());

			if(!options.vertical) 
			{
				$("ul", obj).css('width',s*w);	//s个li的宽度相加＝ul的宽度，高度一样
				$("li", obj).css('float','left');
			}
			else
			{
				$("ul", obj).css('width',suitcount*w)	
			}
			
		/*	if(options.controlsShow){
				var html = options.controlsBefore;
				if(options.firstShow) html += '<a id="'+ options.firstId +'" href=\"javascript:void(0);\">'+ options.firstText +'</a>';
				html += ' <a id="'+ options.prevId +'" href=\"javascript:void(0);\">'+ options.prevText +'</a>';
				html += ' <a id="'+ options.nextId +'" href=\"javascript:void(0);\">'+ options.nextText +'</a>';
				if(options.lastShow) html += ' <a id="'+ options.lastId +'" href=\"javascript:void(0);\">'+ options.lastText +'</a>';
				html += options.controlsAfter;	
				$(obj).after(html);										
			};*/
	
			$("#"+options.nextId).click(function(){
													 //alert("nextId:"+options.nextId);
				animate("next",true);
			});
			$("#"+options.prevId).click(function(){
													 //alert("prevId:"+options.prevId);
				animate("prev",true);				
			});	
			$("#"+options.firstId).click(function(){		
				animate("first",true);
			});				
			$("#"+options.lastId).click(function(){		
				animate("last",true);				
			});		
			
			function animate(dir,clicked){
				var ot = t;				
				switch(dir){
					case "next":
						t = (ot>=ts) ? (options.continuous ? 0 : ts) : t+1;						
						//alert("ts:"+ts+"\n"+"t:"+t+"\n"+"ot:"+ot);
						break; 
					case "prev":
						t = (t<=0) ? (options.continuous ? ts : 0) : t-1;
						break; 
					case "first":
						t = 0;
						break; 
					case "last":
						t = ts;
						break; 
					default:
						break; 
				};	
				
				var diff = Math.abs(ot-t);
				var speed = diff*options.speed;						
				if(!options.vertical) {
					p = (t*w*-1);
					//p = -1434;
					//alert("p:"+p);
					$("ul",obj).animate(
						{ marginLeft: p }, 
						speed
					);				
				} else {
					p = (t*h*-1);
					$("ul",obj).animate(
						{ marginTop: p }, 
						speed
					);					
				};
				
				if(!options.continuous && options.controlsFade){					
					if(t==ts){
						$("#"+options.nextId).hide();
						$("#"+options.lastId).hide();
					} else {
						$("#"+options.nextId).show();
						$("#"+options.lastId).show();					
					};
					if(t==0){
						$("#"+options.prevId).hide();
						$("#"+options.firstId).hide();
					} else {
						$("#"+options.prevId).show();
						$("#"+options.firstId).show();
					};					
				};				
				
				if(clicked) clearTimeout(timeout);
				if(options.auto && dir=="next" && !clicked){;
					timeout = setTimeout(function(){
						animate("next",false);
					},diff*options.speed+options.pause);
				};
				
			};
			// init
			var timeout;
			if(options.auto){;
				timeout = setTimeout(function(){
					animate("next",false);
				},options.pause);
			};		
		
			if(!options.continuous && options.controlsFade){					
				$("#"+options.prevId).hide();
				$("#"+options.firstId).hide();				
			};				
			
		});
	  
	};

})(jQuery);



