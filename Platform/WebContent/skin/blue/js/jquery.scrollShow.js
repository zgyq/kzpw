/**
 * jQuery.ScrollShow - Scrolling Slideshow.
 * Copyright (c) 2007 Ariel Flesler - aflesler(at)gmail(dot)com
 * Licensed under GPL license (http://www.opensource.org/licenses/gpl-license.php).
 * Date: 10/30/2007
 * @author Ariel Flesler
 * @version 0.7
 *
 * @id jQuery.fn.scrollShow
 * @param {Object} settings Hash of settings (detailed below).
 * @return {jQuery} Returns the same jQuery object, for chaining.
 **/
(function( $ ){	
	var defaults = {
		elements:'span',//elements selector (relative to view)
		itemSize:{
			height:300,
			width:280
		},
		view:null,//container of the elements, the one to fix the width.
		navigators:null,//selector to the elements to navigate the slideshow.
		navigationMode:'s',//sequential, random, localscroll
		speed:400,//speed of transition, 1 for no-animation
		wrappers:'simple',//simple,resize,crop,link
		circular:true,//should the slideshow rewind/advance on the extremes ?.
		easing:'linear',//easing equation
		axis:'x',//axis to displace the slideshow
		margin:true,//take margin in account?
		start:null, //force the scroll to start at some position element.
		setWidth:true//whether to calculate and set, the overall width of the slideshow.
	};
	
	function wrap( $els, type, size ){//wrap the photos with several different wrappers.
		switch( type ){
			case 'crop': $els = $els.wrap('<div class="jq-ss-crop">').parent().css('overflow','hidden');					
			case 'resize': return $els.css( size );
			case 'simple': return $els.wrap('<div class="jq-ss-simple">').parent();
			case 'link': 
				if( $els.is('img') )
					return $els.wrap('<a target="_blank" class="jq-ss-link">').parent().each(function(){
						this.href = this.firstChild.src;
					});
			default: return $els;					
		}
	};
	
	$.fn.scrollShow = function( settings ){
		settings = $.extend( {}, defaults, settings );
		
		return this.each(function(){
			var 
				widget	  = this,
				$view	  = settings.view ? $(settings.view, this) : this,
				$elements = $(settings.elements, $view),
				limit	  = $elements.length,
				active	  = 0;
			
			$.each( settings.wrappers.split(/\s*,\s*/), function( i, wrapper ){
				$elements = wrap( $elements, wrapper, settings.itemSize );													 
			});			
			$elements.css( settings.itemSize );//ensure the outer elements have fixed size.
			
			if( !settings.navigators ){//this shouldn't get to happen
				settings.navigators = '';
				settings.navigationMode = 'r';
			}
			
			if( settings.navigators.constructor != Array )
				settings.navigators = [settings.navigators];
			
			$.each( settings.navigationMode.split(''), function( i, type ){
				switch( type.charAt(0) ){
					case 's'://sequential navigation
						$(settings.navigators[i],widget)
							.eq(0).bind('click', { dir: -1 }, sequential ).end()
							.eq(1).bind('click', { dir: +1 }, sequential );
					break;
					case 'r'://random navigation
						var $nav = $(settings.navigators[i] || $elements, widget),
							ratio = $elements.length / $nav.length;
						if( ratio === Infinity ) return;//no navigator found
						$nav.each(function( pos ){
							$(this).bind( 'click', { pos: Math.floor(ratio*pos) }, random );												  
						});
					break;
				}
			});				

			(function( $e, w ){					  
				var imgw = ($e.width() + attrs('margin') + attrs('padding') + attr('border'));
				
				do w -= imgw;
				while( w > 0 && limit-- );//find the last element we can scroll To.
				
				if( !settings.setWidth ) return;
				
				do{
					$e = $e.parent();
					if( $e[0] == $view[0] )
						return;
				}while( $e.length > 1 );
				$e.width( imgw * $elements.length  );//if there's a container for the elements, calculate it's width.
				
			})( $elements, $view.width() );

			if( settings.start != null )
				random( settings.start );
			
			function attrs( name ){
				return attr(name+'Left') + attr(name+'Right');
			};
			function attr( name ){
				return parseInt($elements.css(name)) || 0;	
			};
			
			function sequential( event ){
				event.data.pos = active + event.data.dir;
				return random( event );
			};
			
			function random( event ){
				var pos = typeof event == 'number' ? event : event.data.pos;
				if( pos < 0 )
					pos = active == 0 && settings.circular ? limit : 0;
				else if( pos > limit )
					pos = active == limit && settings.circular ? 0 : limit;
	
				$view.stop().scrollTo( $elements[pos], settings );
				active = pos;
				return false;
			};				
		});
	};
		  
})( jQuery );