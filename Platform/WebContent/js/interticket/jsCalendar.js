function jsCalendar(canvas, hint, opt){
	this.canvas = $(canvas);
	this.hint = hint;
	this.opt = opt || {selectPrevDate: false};
	this.currDate = null;

	this.init();
}
jsCalendar.prototype.addInput = function(input){
	input = $(input);
	emptyHint(input, this.hint);

	var provider = this;
	input.click(function(evt){
		evt.stopPropagation();
	});
	input.focus(function(){
		provider.input = $(this);
		provider.show(input);
	});
}
jsCalendar.prototype.show = function(input){
	if(input == undefined) return;
	this.input = input;
	this.setDateStr(input.val());
	showCanvas(this.canvas, input);
}
jsCalendar.prototype.hide = function(){
	hideWithMask(this.canvas);
}

jsCalendar.prototype.init = function(){
	var now = new Date();
	this.year = now.getFullYear();
	this.month = now.getMonth();
	this.draw();
	var provider = this;
	this.canvas.click(function(evt){
		evt.stopPropagation();
	});
	$(document).click(function(){
		provider.hide();
	});
}
jsCalendar.prototype.setDateStr = function(s){
	if(s.match(/\d+-\d+-\d+/)){
		var items = s.split('-');
		this.setDate(atoi(items[0]), atoi(items[1])-1, atoi(items[2]));
	}
	else{
		var now = new Date();
		this.setMonth(now.getFullYear(), now.getMonth());
	}
}
jsCalendar.prototype.setMonth = function(year, month){
	var d = this.formatDate(year, month);
	this.year = d.year;
	this.month = d.month;
	this.draw();
}
jsCalendar.prototype.setDate = function(year, month, day){
	var d = this.formatDate(year, month, day);
	this.year = d.year;
	this.month = d.month;
	this.currDate = {year: d.year, month: d.month, date: d.date};
	this.draw();
}
jsCalendar.prototype.formatDate = function(year, month, day){
	if(day == undefined) day = 1;
	var d = new Date(year, month, day);
	var ret = {year: d.getFullYear(), month: d.getMonth(), date: day};
	return ret;
}
jsCalendar.prototype.draw = function(){
	var leftCalendar = this.drawMonth(this.year, this.month, 'left');
	var rightCalendar = this.drawMonth(this.year, this.month+1, 'right');
	var leftCell = $('<td width="49%"></td>').append(leftCalendar);
	var rightCell = $('<td width="49%"></td>').append(rightCalendar);
	var row = $('<tr></tr>').append(leftCell).append(rightCell);
	var tbl = $('<table class="calendar"></table>').append(row);
	this.canvas.empty().append(tbl);
}
jsCalendar.prototype.getToday = function(){
	var d = new Date();
	return {year: d.getFullYear(), month: d.getMonth(), date: d.getDate()};
}
jsCalendar.prototype.dateDiff = function(day1, day2){
	var items = day1.split('-');
	var date1 = new Date(items[0], items[1], items[2]);
	items = day2.split('-');
	var date2 = new Date(items[0], items[1], items[2]);
	return date1 - date2;
}
jsCalendar.prototype.drawMonth = function(year, month, side){
	var today = this.getToday();
	var ym = this.formatDate(year, month);
	year = ym.year;
	month = ym.month;
	var dates = this.getDatesByMonth(year, month);
	var weekDays = ['日', '一', '二', '三', '四', '五', '六'];
	var provider = this;
	var tbl = $('<table class="calendar_subtable" cellpadding="0" cellspacing="0"></table>');
	if(side == 'left'){
		var cell = $('<td colspan="7" class="calendar_left_title"></td>').append('<span>'+year+'年'+(month+1)+'月</span>');
		if(year > today.year || (year == today.year && month > today.month || this.opt.selectPrevDate)){
			var prev = $('<a>&lt;--</a>').data('year', year).data('month', month).click(function(){
				provider.setMonth($(this).data('year'), $(this).data('month')-2);
			});
			cell.prepend(prev);
		}
	}
	else{
		var cell = $('<td colspan="7" class="calendar_right_title"></td>').append('<span>'+year+'年'+(month+1)+'月</span>');
		var next = $('<a>--&gt;</a>');
		next.data('year', year).data('month', month);
		next.click(function(evt){
			provider.setMonth($(this).data('year'), $(this).data('month')+1);
		});
		cell.append(next);
	}
	var row = $('<tr></tr>').append(cell);
	tbl.append(row);
	row = $('<tr class="calendar_week"></tr>');
	$.each(weekDays, function(){
		var cls = (this == '六' || this == '日') ? 'calendar_week_holiday' : 'calendar_week_day';
		cell = $('<td class="' + cls + '">'+this+'</td>');
		row.append(cell);
	});
	tbl.append(row);

	var today = this.getToday();
	var currDate = this.currDate;
	var provider = this;
	for(var i = 0; i < dates.length; i++){
		row = $('<tr></tr>');
		for(var j = 0; j < 7; j++){
			var d = dates[i][j];
			if(d == ''){
				cell = $('<td>&nbsp;</td>');
			}
			else{
				cell = $('<td>' + d.date + '</td>');
				var canSelect = true;
				if(d.year == today.year && d.month == today.month){
					// 当月
					if(d.date == today.date){
						cell.addClass('calendar_today');
					}
					if(d.date < today.date){
						if(this.opt.selectPrevDate){
						}
						else{
							cell.addClass('calendar_prev_day');
						}
					}
				}
				else if( d.year < today.year || (d.year == today.year && d.month < today.month) ){
					// 以前的日子
					if(this.opt.selectPrevDate){
					}
					else{
						canSelect = false;
						cell.addClass('calendar_prev_day');
					}
				}
				if(currDate != null && d.date == currDate.date && d.month == currDate.month && d.year == currDate.year){
					cell.addClass('calendar_dayover');
				}
				if(canSelect){
					cell.data('o', d);
					cell.mouseover(function(){
						$(this).addClass('calendar_dayover');
					}).mouseout(function(){
						$(this).removeClass('calendar_dayover');
					}).click(function(){
						provider.selectDate($(this).data('o'));
					});
				}
			}
			row.append(cell);
		}
		tbl.append(row);
	}
	
	return tbl;
}
// 按月份生成6x7日期数组
jsCalendar.prototype.getDatesByMonth = function(year, month){
	var result = [];
	for(var i = 0; i < 6; i++){
		result.push(['','','','','','','']);
	}
	var firstDate = new Date(year, month, 1);
	var lastDate = new Date(year, month+1, 0);
	var lastOfMonth = lastDate.getDate();
	// 修正year和month
	year = firstDate.getFullYear();
	month = firstDate.getMonth();
	// 第一行
	var curr = 1;
	for(var i = firstDate.getDay(); i < 7; i++){
		result[0][i] = {year: year, month: month, date: curr++};
	}
	// 后续行
	var line = 1;
	while(curr <= lastOfMonth){
		for(var i = 0; i < 7; i++){
			if(curr > lastOfMonth) break;
			result[line][i] = {year: year, month: month, date: curr++};
		}
		line++;
	}
	return result;
}
jsCalendar.prototype.selectDate = function(d){
	if(this.input == null) return;
	var m = atoi(d.month)+1; // convert
	this.input.removeClass('gray');
	this.input.val(d.year+'-'+str_pad(m,2)+'-'+str_pad(d.date,2));
	this.hide();
}
