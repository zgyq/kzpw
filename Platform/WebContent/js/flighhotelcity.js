//或得所有的城市
var commoncitys=new Array();
var citys=new Array();
var XMLhttp = Init();
function Init()
{
    var xmlhttp;
    try
    {
	    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
    }
    catch (e)
    {
	    try
	    {
		    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	    catch (e)
	    {
		    xmlhttp = false;
	    }
    }
    if (!xmlhttp && typeof XMLHttpRequest!='undefined')
    {
	    try
	    {
		    xmlhttp = new XMLHttpRequest();
	    }
	    catch (e)
	    {
		    xmlhttp=false;
	    }
    }
    if (!xmlhttp && window.createRequest)
    {
	    try
	    {
		    xmlhttp = window.createRequest();
	    }
	    catch (e)
	    {
		    xmlhttp=false;
	    }
    }
    return xmlhttp;
}
function LoadCityData(w)
{
	
	
	//alert("w="+w);
    var method="Get";
    if(w==1){
   	 document.getElementById("guojia").value=1;
     var HttpUrl="subscribehotel!getCityAirPortData.action?rndmath="+Math.floor(Math.random()*100);
    }
    if(w==2){
     document.getElementById("guojia").value=2;
   	 var HttpUrl="subscribehotel!geta.action?rndmath="+Math.floor(Math.random()*100);
    }
    XMLhttp.open(method,HttpUrl);
    XMLhttp.onreadystatechange = ProcessCity;
    var https=null;
    if(method=="Post")
    {
	    XMLhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	    https = HttpUrl;
	    }
    XMLhttp.send(https);
}
function LoadCityData2(w)
{

	
	//alert("w="+w);
    var method="Get";
    if(w==1){
  //  showhotel('box_hotel1','none');
	
//	$("#sp00").html("<a href=\"#\" onclick=\"showhotel('box_hotel0','block');return false;\"><img src=\"images/sd.gif\" style=\"cursor: pointer;\" width=\"16\" height=\"13\" class=\"img12\" id=\"imag\"   /></a>");
	
   // alert("w=1");
   	 document.getElementById("guojia").value=1;
     var HttpUrl="subscribehotel!getCityAirPortData.action?rndmath="+Math.floor(Math.random()*100);
    }
    if(w==2){
   
   // alert("w=2");
     document.getElementById("guojia").value=2;
    var HttpUrl="subscribehotel!geta.action?rndmath="+Math.floor(Math.random()*100);
    }
    XMLhttp.open(method,HttpUrl);
    XMLhttp.onreadystatechange = ProcessCity;
    var https=null;
    if(method=="Post")
    {
	    XMLhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	    https = HttpUrl;
	    }
    XMLhttp.send(https);
}
function ProcessCity()
{
    if(XMLhttp.readyState==4)
    {
        var returnData=XMLhttp.responseText;
    //   alert(returnData);
        var cityInfos=returnData.split(',');
        for(var i=0;i<cityInfos.length-1;i++)
        {
            if(i<15)
            {
                commoncitys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
               
//                alert(cityInfos[i].split('#')[1].split('%')[1].split('&')[1]+','+cityInfos[i].split('#')[0]+','+cityInfos[i].split('#')[1].split('%')[0]+','+cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
                citys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
            }
            else
                citys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
        }
    }
}