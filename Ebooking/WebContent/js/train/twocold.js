


function filtertrain2(){


	var fliterstr = "";
	var train_count = 0;
	if(jQuery("#chktype_g").attr('checked')) fliterstr += 'g';
	if(jQuery("#chktype_d").attr('checked')) fliterstr += 'd';
	if(jQuery("#chktype_z").attr('checked')) fliterstr += 'z';
	if(jQuery("#chktype_t").attr('checked')) fliterstr += 't';
	if(jQuery("#chktype_k").attr('checked')) fliterstr += 'k';
	//if(jQuery("#chktype_0").attr('checked')) fliterstr += '0123456789nyalqcg';

	var tt = jQuery("#timetable2 tbody tr");
	
	jQuery.each(tt,function(){
		var tr = jQuery(this);
		
		
		
		var shijian;
		var checked = false;
		var in_time = false;
		if(jQuery('#shangwu-chufa').attr('checked')){ 
			shijian = Number(jQuery('.fashi',tr).text().substring(0,2));
			
			
			in_time = (shijian>=6&&shijian<12)?true:false;
			//alert(in_time);
			checked = true;
		}
		if(jQuery('#xiawu-chufa').attr('checked')){ 
			shijian = Number(jQuery('.fashi',tr).text().substring(0,2));
			in_time = (shijian>=12&&shijian<18)?true:false;
			checked = true;
		}
		
		if(jQuery('#wanshang-chufa').attr('checked')){
			shijian = Number(jQuery('.fashi',tr).text().substr(0,2));
			in_time = (shijian>=18||shijian<6)?true:false;
			checked = true;
		}
		if(jQuery('#shangwu-daoda').attr('checked')){
			shijian = Number(jQuery('.daoshi',tr).text().substr(0,2));
			in_time = (shijian>=6&&shijian<12)?true:false;

			checked = true;
		}
		if(jQuery('#xiawu-daoda').attr('checked')){
			shijian = Number(jQuery('.daoshi',tr).text().substr(0,2));
			in_time = (shijian>=12&&shijian<18)?true:false;
			checked = true;
		}
		if(jQuery('#wanshang-daoda').attr('checked')){
			shijian = Number(jQuery('.daoshi',tr).text().substr(0,2));
			in_time = (shijian>=18||shijian<6)?true:false;
			checked = true;
		}
		
		//alert("!!!"+tr.attr("id"));
		if(tr.attr("id")==null||tr.attr("id")=='table_tr_hid'){
		//alert("????");
		
		}else{
		
			if((fliterstr.indexOf(tr.attr("id").substring(0,1).toLowerCase()) > -1 || fliterstr=="")&&(!checked||in_time)){
				//alert("show");
				tr.show();
				//$("#"+idvastr).show();
				
				train_count++;
			}else{
			   //$("#"+idvastr).hide();
				//alert("hide");
				tr.hide()
				
			} 
		}
		
	});
	
	//alert(train_count);
	
	jQuery('#traincount').html(train_count);
	
} 