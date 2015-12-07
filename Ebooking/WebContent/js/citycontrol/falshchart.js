// JScript 文件
function CreateFlash(idad, swfurl, wad, had, vs){

  	var str = "<object classid=\"clsid:d27cdb6e-ae6d-11cf-96b8-444553540000\" codebase=\"http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0\" width=\"" + wad + "\" height=\"" + had + "\" id=\"" + idad + "\" align=\"middle\">";
     str += "<param name=\"allowScriptAccess\" value=\"always\">";
	 str += "<param name=\"wmode\" value=\"transparent\">";
	 str += "<param name=\"quality\" value=\"high\">";
	 str += "<param name=\"movie\" 	value=\"" + swfurl + "\">";
	 str += "<param name=\"flashvars\" value=\"" + vs + "\">";
	 str += "<embed src=\"" + swfurl + "\" flashvars=\"" + vs + "\" wmode=\"transparent\" quality=\"high\" width=\"" + wad + "\" height=\"" + had + "\" name=\"" + idad + "\" align=\"middle\" allowScriptAccess=\"always\" type=\"application/x-shockwave-flash\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\">";
	 str += "</object>";
	
	 return (str);
}


function initnewhq(name,src, width, height, type,from,to,id){

    hqwidth = width;
    hqheight = height;
	hqdata="ticticket!getflashdata.jspx?s_depcitycode=" + from + "&s_arrcitycode=" + to + "&randno=" + Math.random();
	flashvars = "data-file="+encodeURIComponent(hqdata);
	str = CreateFlash(name,src,hqwidth,hqheight,flashvars);	
	document.getElementById(id).innerHTML = str;	
}


function initFlash(from,to) {
	 
    initnewhq("bitonline","images/open-flash-chart.swf?r="+ Math.random() * 100000,660, 200,'airindex_v2',from,to,"flash_chart");
}

function showFlash() {
  
	var src = document.getElementById("hidDepCity_tic").value;
	var dst = document.getElementById("hidArrCity_tic").value;
 
	initFlash(src,dst);
}
