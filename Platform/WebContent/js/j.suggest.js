	(function($) {

		$.suggest = function(input, options) {
	
			var $input = $(input).attr("autocomplete", "off");
			var $results;

			var timeout = false;		// hold timeout ID for suggestion results to appear	
			var prevLength = 0;			// last recorded length of $input.val()
			var cache = [];				// cache MRU list
			var cacheSize = 0;			// size of cache in chars (bytes?)
			
			if($.trim($input.val())=='' || $.trim($input.val())=='中文/拼音') $input.val('中文/拼音').css('color','#aaa');
			if( ! options.attachObject )
				options.attachObject = $(document.createElement("ul")).appendTo('body');

			$results = $(options.attachObject);
			$results.addClass(options.resultsClass);
			
			resetPosition();
			$(window)
				.load(resetPosition)		// just in case user is changing size of page while loading
				.resize(resetPosition);

			$input.blur(function() {
				setTimeout(function() { $results.hide() }, 200);
			});
			
			$input.focus(function(){
				if($.trim($(this).val())=='中文/拼音'){
					$(this).val('').css('color','#000');
				}
				if($.trim($(this).val())==''){
					displayItems('');//鏄剧ず鐑棬鍩庡競鍒楄〃
				}
			});
			$input.click(function(){
				var q=$.trim($(this).val());
				displayItems(q);
				$(this).select();
			});
						
			// help IE users if possible
			try {
				$results.bgiframe();
			} catch(e) { }

			$input.keyup(processKey);//
			
			function resetPosition() {
				// requires jquery.dimension plugin
				var offset = $input.offset();
				$results.css({
					top: (offset.top + input.offsetHeight) + 'px',
					left: offset.left + 'px'
				});
			}
			
			
			function processKey(e) {
				
				// handling up/down/escape requires results to be visible
				// handling enter/tab requires that AND a result to be selected
				if ((/27$|38$|40$/.test(e.keyCode) && $results.is(':visible')) ||
					(/^13$|^9$/.test(e.keyCode) && getCurrentResult())) {
		            
		            if (e.preventDefault)
		                e.preventDefault();
					if (e.stopPropagation)
		                e.stopPropagation();

	                e.cancelBubble = true;
	                e.returnValue = false;
				
					switch(e.keyCode) {
	
						case 38: // up
							prevResult();
							break;
				
						case 40: // down
							nextResult();
							break;
						case 13: // return
							selectCurrentResult();
							break;
							
						case 27: //	escape
							$results.hide();
							break;
	
					}
					
				} else if ($input.val().length != prevLength) {

					if (timeout) 
						clearTimeout(timeout);
					timeout = setTimeout(suggest, options.delay);
					prevLength = $input.val().length;
					
				}			
					
				
			}
			
			function suggest() {
			
				var q = $.trim($input.val());
				displayItems(q);
			}		
			function displayItems(items) {
				var html = '';
				var html1='';
				if (items=='') {//热门选项
				    var inde=0;
					for(h in options.hot_list){
					    inde++;
					    if(inde<13 && typeof(options.hot_list[h][2])!='undefined')
					    {
					    html+='<li rel="'+options.hot_list[h][0]+'"><a href="#'+h+'"><span>'+options.hot_list[h][2]+'</span>'+options.hot_list[h][1]+'</a></li>';
					    html1+='<li>&nbsp;<br/></li>';
					    }
					}
					html='<iframe style="position: absolute; z-index: -1;  width: 170px; height:315px; top: 0; scrolling: no;" frameborder="0"></iframe><div style="z-index: 10;width:165px;" class="gray ac_result_tip">请输入中文/拼音或者↑↓选择</div><ul style="height:320px;width:165px;">'+html+'</ul>';
					//<iframe style="position: absolute; z-index: -1; background-color:Red; width: 160px; height:700px top: 10;left:-6px; scrolling: no;" frameborder="0"><ul>'+html1+'</ul></iframe>
					// 
				}
				else {
					/*if (!items)
					return;
					if (!items.length) {
						$results.hide();
						return;
					}*/
				var o=0;
					for (var i = 0; i < options.source.length; i++) {//国内城市匹配
					    var reg = new RegExp('^.*' + items + '.*$', 'im');//匹配正则表达式
					    if(o<13)
					    {
					        if (reg.test(options.source[i][0]) || reg.test(options.source[i][1]) || reg.test(options.source[i][2]) || reg.test(options.source[i][3])) {
						        html += '<li rel="' + options.source[i][0] + '"><a href="#' + i + '"><span>' + options.source[i][2] + '</span>' + options.source[i][1] + '</a></li>';
						         html1+='<li>&nbsp;<br/></li>';
						        o++;
					        }
					    }
					}
					if (html == '') {
						suggest_tip = '<iframe style="position: absolute; z-index: -1;  width: 170px; height:315px;top: 10;scrolling: no;" frameborder="0"></iframe><div class="gray ac_result_tip" style="height:10px;width:165px;">对不起，找不到:' + items + '</div>';
						//<iframe style="position: absolute; z-index: -1; background-color:Red; width: 162px; top: 10;left:-6px; scrolling: no;" frameborder="0" ></iframe>
					}
					else {
						suggest_tip = '<iframe style="position: absolute; z-index: -1; width: 170px;height:315px;top: 10; scrolling: no;" frameborder="0"></iframe><div style="z-index: 10;height:15px;width:165px;" class="gray ac_result_tip">' + items + ',按拼音排序</div>';
						//<iframe style="position: absolute; z-index: -1; background-color:Red; width: 160px; top: 10;left:-6px; scrolling: no;" frameborder="0" ><ul>'+html1+'</ul></iframe>
					}
					html = suggest_tip + '<iframe style="position: absolute; z-index: -1;  width: 165px;height:315px; top: 10; scrolling: no;" frameborder="0"></iframe><ul style="height:325px;width:165px;">' + html + '</ul>';
					//'<iframe style="position: absolute; z-index: -1; background-color:Red; width: 160px; height:400px;top: 10;left:-6px; scrolling: no;" frameborder="0" ></iframe>'+
				}
				$results.html(html).show();
				$results.children('ul').children('li:first-child').addClass(options.selectClass);
				
				$results.children('ul')
					.children('li')
					.mouseover(function() {
						$results.children('ul').children('li').removeClass(options.selectClass);
						$(this).addClass(options.selectClass);
					})
					.click(function(e) {
						e.preventDefault(); 
						e.stopPropagation();
						selectCurrentResult();
					});
			}
						
			function getCurrentResult() {
			
				if (!$results.is(':visible'))
					return false;
			
				var $currentResult = $results.children('ul').children('li.' + options.selectClass);
				if (!$currentResult.length)
					$currentResult = false;
					
				return $currentResult;

			}
			
			function selectCurrentResult() {
			
				$currentResult = getCurrentResult();
			
				if ($currentResult) {
					$input.val($currentResult.children('a').html().replace(/<span>.+?<\/span>/i,''));
					$results.hide();

					if( $(options.dataContainer) ) {
						$(options.dataContainer).val($currentResult.attr('rel'));
					}
	
					if (options.onSelect) {
						options.onSelect.apply($input[0]);
					}
				}
			
			}
			
			function nextResult() {
			
				$currentResult = getCurrentResult();
			
				if ($currentResult)
					$currentResult
						.removeClass(options.selectClass)
						.next()
							.addClass(options.selectClass);
				else
					$results.children('ul').children('li:first-child').addClass(options.selectClass);
			
			}
			
			function prevResult() {
			
				$currentResult = getCurrentResult();
			
				if ($currentResult)
					$currentResult
						.removeClass(options.selectClass)
						.prev()
							.addClass(options.selectClass);
				else
					$results.children('ul').children('li:last-child').addClass(options.selectClass);
			
			}
	
		}
		
		$.fn.suggest = function(source, options) {
		
			if (!source)
				return;
		
			options = options || {};
			options.source = source;
			options.hot_list=options.hot_list || [];
			options.delay = options.delay || 0;
			options.resultsClass = options.resultsClass || 'ac_results';
			options.selectClass = options.selectClass || 'ac_over';
			options.matchClass = options.matchClass || 'ac_match';
			options.minchars = options.minchars || 1;
			options.delimiter = options.delimiter || '\n';
			options.onSelect = options.onSelect || false;
			options.dataDelimiter = options.dataDelimiter || '\t';
			options.dataContainer = options.dataContainer || '#SuggestResult';
			options.attachObject = options.attachObject || null;
	
			this.each(function() {
				new $.suggest(this, options);
			});
	
			return this;
			
		};
		
	})(jQuery);