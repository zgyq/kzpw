/**
 * jQuery.ScrollTo - Easy element scrolling using jQuery.
 * Copyright (c) 2007 Ariel Flesler - aflesler(at)gmail(dot)com
 * Licensed under GPL license (http://www.opensource.org/licenses/gpl-license.php).
 * Date: 10/29/2007
 * @author Ariel Flesler
 * @version 1.2.2
 * Compatible with jQuery 1.2.1, tested on Firefox 2.0.0.7, and IE 6, both on Windows.
 **/
(function($){$.scrollTo=function(a,b){return $('html,body').scrollTo(a,b)};$.fn.scrollTo=function(e,f){f=$.extend({axis:'y',speed:1},f||{});if(f.axis.length!=2)f.queue=false;if(f.queue)f.speed=Math.ceil(f.speed/2);return this.each(function(){var d=$(this),t=e,k,l,u={};switch(typeof t){case'string':if(/^([+-]=)?\d+(px)?$/.test(t))break;t=$(t,this);case'object':k=$(t).offset()}$.each(f.axis.split(''),parse);animate(f.onAfter);function parse(i,a){var b=a=='x'?'Left':'Top',p=b.toLowerCase();var c='scroll'+b;u[c]=k?k[p]+(d.is('html,body')?0:d[0][c]-d.offset()[p]):t;if(f.margin&&typeof t=='object')u[c]-=parseInt($(t).css('margin'+b))||0;if(!i&&f.queue){if(d[0][c]!=u[c])animate(f.onAfterFirst);delete u[c]}};function animate(a){d.animate(u,f.speed,f.easing,a)}})}})(jQuery);