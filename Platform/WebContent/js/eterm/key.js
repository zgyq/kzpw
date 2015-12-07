function keycodeToFX(key){
	if(key==112){
		return "F1";
	}else if(key==113){
		return "F2";
	}else if(key==114){
		return "F3";
	}else if(key==115){
		return "F4";
	}else if(key==116){
		return "F5";
	}else if(key==117){
		return "F6";
	}else if(key==118){
		return "F7";
	}else if(key==119){
		return "F8";
	}else if(key==120){
		return "F9"
	}else if(key==121){
		return "F10";
	}else if(key==122){
		return "F11";
	}else if(key==123){
		return "F12";
	}else{
		return "";
	}
}

function key(o){

	//alert(event.keyCode)
	//ctrl
	if(event.ctrlKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.shiftKey && !event.altKey){
		o.value="CTRL+"+String.fromCharCode(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;

		
	}else if(event.ctrlKey && (event.keyCode>=112 && event.keyCode<=123) && !event.shiftKey && !event.altKey){
		o.value="CTRL+"+keycodeToFX(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}
	//shift
	if(event.shiftKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.ctrlKey && !event.altKey){
		o.value="";
		event.keyCode=0;
		event.returnValue=false;
		return;

		
	}else if(event.shiftKey && (event.keyCode>=112 && event.keyCode<=123) && !event.ctrlKey && !event.altKey){
		o.value="SHIFT+"+keycodeToFX(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}

	//ALT
	if(event.altKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.ctrlKey && !event.shiftKey){
		o.value="ALT+"+String.fromCharCode(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
		
	}else if(event.altKey && (event.keyCode>=112 && event.keyCode<=123) && !event.ctrlKey && !event.shiftKey){
		o.value="ALT+"+keycodeToFX(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}
	//ctrl+shift
	if(event.ctrlKey && event.shiftKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.altKey){
		o.value="CTRL+"+"SHIFT+"+String.fromCharCode(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}else if(event.ctrlKey && event.shiftKey && (event.keyCode>=112 && event.keyCode<=123) && !event.altKey){
		o.value="CTRL+"+"SHIFT+"+keycodeToFX(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}
	
	//ctrl+alt
	if(event.ctrlKey && event.altKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.shiftKey){
		o.value="CTRL+"+"ALT+"+String.fromCharCode(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}else if(event.ctrlKey && event.altKey && (event.keyCode>=112 && event.keyCode<=123) && !event.shiftKey){
		o.value="CTRL+"+"ALT+"+keycodeToFX(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}

	//shift+alt
	if(event.shiftKey && event.altKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.ctrlKey){
		o.value="SHIFT+"+"ALT+"+String.fromCharCode(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}else if(event.shiftKey && event.altKey && (event.keyCode>=112 && event.keyCode<=123) && !event.ctrlKey){
		o.value="SHIFT+"+"ALT+"+keycodeToFX(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}
	//F1-F12
	if(event.keyCode>=112 && event.keyCode<=123){
		o.value=keycodeToFX(event.keyCode);
		event.keyCode=0;
		event.returnValue=false;
		return;
	}else if(!event.shiftKey && !event.altKey && !event.ctrlKey){
		o.value="";
		event.keyCode=0;
		event.returnValue=false;
		return;
	}
	
}

function returnkey(){

	//ctrl
	var value="";
	if(event.ctrlKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.shiftKey && !event.altKey){
		value="CTRL+"+String.fromCharCode(event.keyCode);
		//event.keyCode=0;
		//event.returnValue=false;
		return value;

		
	}else if(event.ctrlKey && (event.keyCode>=112 && event.keyCode<=123) && !event.shiftKey && !event.altKey){
		value="CTRL+"+keycodeToFX(event.keyCode);
		event.returnValue=false;
		return value;
	}
	if(event.ctrlKey && event.keyCode==38 && !event.shiftKey && !event.altKey){
		event.returnValue=false;
		return "UP";
	}
	if(event.ctrlKey && event.keyCode==40 && !event.shiftKey && !event.altKey){
		event.returnValue=false;
		return "DOWN";
	}
	//shift
	//if(event.shiftKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.ctrlKey && !event.altKey){
	//	value="SHIFT+"+String.fromCharCode(event.keyCode);
	//	event.keyCode=0;
	//	event.returnValue=false;
	//	return value;

		
	if(event.shiftKey && (event.keyCode>=112 && event.keyCode<=123) && !event.ctrlKey && !event.altKey){
		value="SHIFT+"+keycodeToFX(event.keyCode);
		event.returnValue=false;
		return value;
	}

	//ALT
	if(event.altKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.ctrlKey && !event.shiftKey){
		value="ALT+"+String.fromCharCode(event.keyCode);
		event.returnValue=false;
		return value;
		
	}else if(event.altKey && (event.keyCode>=112 && event.keyCode<=123) && !event.ctrlKey && !event.shiftKey){
		value="ALT+"+keycodeToFX(event.keyCode);
		event.returnValue=false;
		return value;
	}
	//ctrl+shift
	if(event.ctrlKey && event.shiftKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.altKey){
		value="CTRL+"+"SHIFT+"+String.fromCharCode(event.keyCode);
		event.returnValue=false;
		return value;
	}else if(event.ctrlKey && event.shiftKey && (event.keyCode>=112 && event.keyCode<=123) && !event.altKey){
		value="CTRL+"+"SHIFT+"+keycodeToFX(event.keyCode);
		event.returnValue=false;
		return value;
	}
	
	//ctrl+alt
	if(event.ctrlKey && event.altKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.shiftKey){
		value="CTRL+"+"ALT+"+String.fromCharCode(event.keyCode);
		event.returnValue=false;
		return value;
	}else if(event.ctrlKey && event.altKey && (event.keyCode>=112 && event.keyCode<=123) && !event.shiftKey){
		value="CTRL+"+"ALT+"+keycodeToFX(event.keyCode);
		event.returnValue=false;
		return value;
	}

	//shift+alt
	if(event.shiftKey && event.altKey && ((event.keyCode>=65 && event.keyCode<=90) || (event.keyCode>=48 && event.keyCode<=57)) && !event.ctrlKey){
		value="SHIFT+"+"ALT+"+String.fromCharCode(event.keyCode);
		event.returnValue=false;
		return value;
	}else if(event.shiftKey && event.altKey && (event.keyCode>=112 && event.keyCode<=123) && !event.ctrlKey){
		value="SHIFT+"+"ALT+"+keycodeToFX(event.keyCode);
		event.returnValue=false;
		return value;
	}
	//F1-F12
	if(event.keyCode>=112 && event.keyCode<=123){
		value=keycodeToFX(event.keyCode);
		event.returnValue=false;
		return value;
	}
}
