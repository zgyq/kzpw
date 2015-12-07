//æå¾ææçåå¸
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
function LoadCityData()
{
    var method="Get";
    var HttpUrl='cityairport!getInterAirPortData.action?rndmath='+Math.floor(Math.random()*100);;
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
    if(XMLhttp.readystate==4)
    {
        var returnData=XMLhttp.responseText;
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

