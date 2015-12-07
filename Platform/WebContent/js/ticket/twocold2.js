


function filter_air(va){
alert(fliterstr);
	var fliterstr = va;
	var train_count = 0;
	
	


//alert(fliterstr);

	var tt = jQuery("div[id*='div_flightlist']");
	


	
	jQuery.each(tt,function(){
	
		var tr = jQuery(this);
		var shijian;
		var checked = false;
		var in_time = false;
		
		alert(tr);
		if(tr.attr("id")==null||tr.attr("id")=='undefined'){
		//alert("undefined");
		}else{
			//alert("jin");
			if((fliterstr.indexOf(tr.attr("id").substring(0,1).toLowerCase()) > -1 || fliterstr=="")&&(!checked||in_time)){
				tr.show();
				train_count++;
			}else{
				tr.hide()
			} 
	}
		
	
		
	});
	//alert("train_count:"+train_count);
	//jQuery('#div_flightlist').html(train_count);
	
} 