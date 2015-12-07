


function filtertrain2(){

	var fliterstr = "";
	var train_count = 0;
	if(jQuery("#chktype_g").is(':checked')) fliterstr += 'g';
	if(jQuery("#chktype_d").is(':checked')) fliterstr += 'd';
	if(jQuery("#chktype_z").is(':checked')) fliterstr += 'z';
	if(jQuery("#chktype_t").is(':checked')) fliterstr += 't';
	if(jQuery("#chktype_k").is(':checked')) fliterstr += 'k';
	if(jQuery("#chktype_0").is(':checked')) fliterstr += '0123456789nyalqcg';


//alert(fliterstr);

	var tt = jQuery("div[id*='_train_code']");
	


	
	jQuery.each(tt,function(){
	
		var tr = jQuery(this);
		var shijian;
		var checked = false;
		var in_time = false;
		if(jQuery('#shangwu-chufa').is(':checked')){ 
			shijian = Number(jQuery('.fashi',tr).text().substring(0,2));
			in_time = (shijian>=6&&shijian<12)?true:false;

			checked = true;
		}
		if(jQuery('#xiawu-chufa').is(':checked')){ 
			shijian = Number(jQuery('.fashi',tr).text().substring(0,2));
			in_time = (shijian>=12&&shijian<18)?true:false;
			checked = true;
		}
		
		if(jQuery('#wanshang-chufa').is(':checked')){
			shijian = Number(jQuery('.fashi',tr).text().substr(0,2));
			in_time = (shijian>=18||shijian<6)?true:false;
			checked = true;
		}
		if(jQuery('#shangwu-daoda').is(':checked')){
			shijian = Number(jQuery('.daoshi',tr).text().substr(0,2));
			in_time = (shijian>=6&&shijian<12)?true:false;

			checked = true;
		}
		if(jQuery('#xiawu-daoda').is(':checked')){
			shijian = Number(jQuery('.daoshi',tr).text().substr(0,2));
			in_time = (shijian>=12&&shijian<18)?true:false;
			checked = true;
		}
		if(jQuery('#wanshang-daoda').is(':checked')){
			shijian = Number(jQuery('.daoshi',tr).text().substr(0,2));
			in_time = (shijian>=18||shijian<6)?true:false;
			checked = true;
		}
		//alert("??");
		
		//alert("tr:"+tr.attr("id"));
		
		
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
		
		
		//if((fliterstr.indexOf(tr.attr("train").substring(0,1).toLowerCase()) > -1 || fliterstr=="")&&(!checked||in_time)){
		//	tr.show();
		//	train_count++;
		//}else{
			
		//	tr.hide()
		//} 
		
		
	});
	//alert("train_count:"+train_count);
	jQuery('#traincount').html(train_count);
	
} 