
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


//加载酒店城市数据
var commoncitysh=new Array();
var citysh=new Array();
function loadCityDataH()
{
    var method="Get";
    var HttpUrl="hotelsubscribe!getCityAirPortData.jspx?rndmath="+Math.floor(Math.random()*100);

    if(navigator.userAgent.indexOf("MSIE")>0) //IE
    {
       XMLhttp.onreadystatechange = ProcessCityH;
       XMLhttp.open(method,HttpUrl,false);
       XMLhttp.onreadystatechange = ProcessCityH;
    }
    else if(isFirefox=navigator.userAgent.indexOf("Firefox")>0)  //firefox
    {
       XMLhttp.open(method,HttpUrl,false);
       //XMLhttp.onreadystatechange = ProcessCityH();
    }
    var https=null;
    if(method=="Post")
    {
	    XMLhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	    https = HttpUrl;
	}
    XMLhttp.send(https);
    if(isFirefox=navigator.userAgent.indexOf("Firefox")>0)  //firefox
    {
       setTimeout("getfirefoxdata();",1000);  
    }
}
function getfirefoxdata()
{
     var returnData1=XMLhttp.responseText;
     var cityInfost=returnData1.split(',');
        if(cityInfost.length>0)
        {
	        for(var i=0;i<cityInfost.length-1;i++)
	        {
	            if(i<15)
	            {
	                commoncitysh[i]=new Array(cityInfost[i].split('#')[1].split('%')[1].split('&')[1],cityInfost[i].split('#')[0],cityInfost[i].split('#')[1].split('%')[1].split('&')[0],cityInfost[i].split('#')[1].split('%')[0]);
	                citysh[i]=new Array(cityInfost[i].split('#')[1].split('%')[1].split('&')[1],cityInfost[i].split('#')[0],cityInfost[i].split('#')[1].split('%')[1].split('&')[0],cityInfost[i].split('#')[1].split('%')[0]);
	            }
	            else
	                citysh[i]=new Array(cityInfost[i].split('#')[1].split('%')[1].split('&')[1],cityInfost[i].split('#')[0],cityInfost[i].split('#')[1].split('%')[1].split('&')[0],cityInfost[i].split('#')[1].split('%')[0]);
	        }
        }
}

function ProcessCityH()
{
    if(XMLhttp.readyState==4)
    {
        var returnData1=XMLhttp.responseText;
        var cityInfost=returnData1.split(',');
        if(cityInfost.length>0)
        {
	        for(var i=0;i<cityInfost.length-1;i++)
	        {
	            if(i<15)
	            {
	                commoncitysh[i]=new Array(cityInfost[i].split('#')[1].split('%')[1].split('&')[1],cityInfost[i].split('#')[0],cityInfost[i].split('#')[1].split('%')[1].split('&')[0],cityInfost[i].split('#')[1].split('%')[0]);
	                citysh[i]=new Array(cityInfost[i].split('#')[1].split('%')[1].split('&')[1],cityInfost[i].split('#')[0],cityInfost[i].split('#')[1].split('%')[1].split('&')[0],cityInfost[i].split('#')[1].split('%')[0]);
	            }
	            else
	                citysh[i]=new Array(cityInfost[i].split('#')[1].split('%')[1].split('&')[1],cityInfost[i].split('#')[0],cityInfost[i].split('#')[1].split('%')[1].split('&')[0],cityInfost[i].split('#')[1].split('%')[0]);
	        }
        }
    }
}

//加载机票城市数据
var commoncitys=new Array();
var citys=new Array();
function loadCityDataT()
{

    var method="Get";
    var HttpUrl="ticticket!getCityAirPortData.jspx?rndmath="+Math.floor(Math.random()*100);
    XMLhttp.open(method,HttpUrl);
    XMLhttp.onreadystatechange = ProcessCityT;
    var https=null;
    if(method=="Post")
    {
	    XMLhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	    https = HttpUrl;
	    }
    XMLhttp.send(https);
}
function ProcessCityT()
{
   
    if(XMLhttp.readyState==4)
    {
        var returnData=XMLhttp.responseText;
        var cityInfos=returnData.split(',');
        if(cityInfos.length>0)
        {
	        for(var i=0;i<cityInfos.length-1;i++)
	        {
	            if(i<15)
	            {
	                commoncitys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
	                citys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
	            }
	            else
	                citys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
	        }
        }
    }
}
//加载国际城市
var fcommoncitys=new Array();
var fcitys=new Array();
function loadFCityData()
{
    var method="Get";
    var HttpUrl="interticket!getInterAirPortData.jspx?rndmath="+Math.floor(Math.random()*100);
    XMLhttp.open(method,HttpUrl);
    XMLhttp.onreadystatechange = ProcessFCity;
    var https=null;
    if(method=="Post")
    {
	    XMLhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	    https = HttpUrl;
	    }
    XMLhttp.send(https);
}
function ProcessFCity()
{
    if(XMLhttp.readyState==4)
    {
        var returnData=XMLhttp.responseText;
        var cityInfos=returnData.split(',');
        for(var i=0;i<cityInfos.length-1;i++)
        {
            if(i<15)
            {
                fcommoncitys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
                fcitys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
            }
            else
                fcitys[i]=new Array(cityInfos[i].split('#')[1].split('%')[1].split('&')[1],cityInfos[i].split('#')[0],cityInfos[i].split('#')[1].split('%')[0],cityInfos[i].split('#')[1].split('%')[1].split('&')[0]);
        }
    }
}

 function showtab(tabname)
   {
	  $("#tb_hotel").hide();
	  $("#tb_ticket").hide();
	  $("#tb_trip").hide();
      $("li[id*='li_tab_']").each(function(i)
      {
         $(this).css("background","");
      });
      $("a[id*='a_tab_']").each(function(i)
      {
         $(this).css("color","#479AF0");
      });
      $.validationEngine.closePrompt(".formError",true); 
      $("#tb_"+tabname).show();
      $("#li_tab_"+tabname).css("background","url(images/bj_nav_quan.gif)");
      $("#a_tab_"+tabname).css("color","#fff");
   }
  //机票选项卡
   function showticket(tbname)
   {
      $("li[id*='li_tuijian_ticket_']").each(function(i)
      {
         $(this).css("background","url(images/nav_city_b.gif)");
      });
      $("a[id*='a_tuijian_ticket_']").each(function(i)
      {
         $(this).css("color","#fff");
      });
      $("#li_tuijian_ticket_"+tbname).css("background","url(images/nav_city_l.gif)");
      $("#a_tuijian_ticket_"+tbname).css("color","#000");
      var cityname;
      if(tbname=="0")
      {
         cityname="PEK";
      }
      else if(tbname=="1")
      {
         cityname="SHA";
      }
      else if(tbname=="2")
      {
         cityname="CAN";
      }
      else if(tbname=="DLC")
      {
         cityname="SHA";
      }
      else if(tbname=="4")
      {
         cityname="HGH";
      }
      $("#box1").load("index!getTicketData.jspx?rndmath="+Math.floor(Math.random()*10)+"&strName="+cityname);
   }
   //酒店tab切换
   function huan(a)
   {
	 for(var i=0;i<4;i++)
	 {
	 	document.getElementById("tui"+i).style.background="url(images/nav_city_b.gif)";
	 	document.getElementById("tuia"+i).style.color="";
	 }
	 document.getElementById("tui"+a).style.background="url(images/nav_city_l.gif)";
	 document.getElementById("tuia"+a).style.color="#000";
	 var cityname;
      if(a=="0")
      {
         cityname="607";
      }
      else if(a=="1")
      {
         cityname="718";
      }
      else if(a=="2")
      {
         cityname="744";
      }
      else if(a=="3")
      {
         cityname="704";
      }
	 $("#tuijian1").load("index!getHotelData.jspx?rndmath="+Math.floor(Math.random()*10)+"&strHotelCity="+cityname);
   }
   //旅游tab切换
   function triptab(a)
   {
	 for(var i=0;i<6;i++)
	 {
	    if(i!=2)
	    {
		 	document.getElementById("trip_tui"+i).style.background="url(images/nav_city_b.gif)";
		 	document.getElementById("trip_tuia"+i).style.color="";
	 	}
	 }
	 document.getElementById("trip_tui"+a).style.background="url(images/nav_city_l.gif)";
	 document.getElementById("trip_tuia"+a).style.color="#000";
	 var cityname;
      if(a=="0")
      {
         cityname="607";
      }
      else if(a=="1")
      {
         cityname="718";
      }
      else if(a=="2")
      {
         cityname="744";
      }
      else if(a=="3")
      {
         cityname="704";
      }
      else if(a=="4")
      {
         cityname="11238";
      }
       else if(a=="5")
      {
         cityname="11239";
      }
	 $("#div_trip").load("index!getTravelInfo.jspx?rndmath="+Math.floor(Math.random()*10)+"&t_from_cityname="+cityname);
   }
   //酒店数据验证
   function datacheckh()
   {
      if($("#city_hotel_hide").val()=="")
      {
         alert("酒店所在城市是必填项，请重新选择！");
         $("#hotelcity").focus();
         return false;
      }
      else if($("#s_startdate").val()=="")
      {
         alert("入住日期是必填项，请重新选择！");
         $("#s_startdate").focus();
         return false;
      }
      else if($("#s_enddate").val()=="")
      {
         alert("离店日期是必填项，请重新选择！");
         $("#s_enddate").focus();
         return false;
      }
     else
     {
        $("#container").hide();
        $("#tbloading").show();
        $("#span_loadtext").html("请稍候，<br />正在为你您查询酒店信息...");
        return true;
     }
   }
   function showBackDate()
      {
          var rdoSingle=document.getElementById("rdoSingle");
          var rdoBack=document.getElementById("rdoBack");
          var rdoCon=document.getElementById("rdoCon");
          var lblBackDate=document.getElementById("span_backdate");
          var lblspancong=document.getElementById("span_cong");
          var lblspandao=document.getElementById("span_dao");
          var divBackDate=document.getElementById("txtBackDate");
          if(rdoSingle.checked==true)
          {
              lblBackDate.style.display="none";
              divBackDate.style.display="none";
              lblspancong.style.display="none";
              lblspandao.style.display="none";
              
          }
          if(rdoBack.checked==true)
          {
              lblBackDate.style.display="block";
               divBackDate.style.display="block";
              lblspancong.style.display="block";
              lblspandao.style.display="block";
          }
      }
   //机票数据验证
   function checkdatat()
   {
            var rdoFrom=document.getElementById("rdoBack");
            var rdoOnlone=document.getElementById("rdoSingle");
          
            if($("#arrcity").val()=="" || $("#arrcity").val()=="中文/拼音")//中文/拼音
            {
                alert("出发城市不能为空,请检查后重新填写！");
                $("#arrcity").focus();
                return false;
            }
            else if($("#tocity").val()=="" || $("#tocity").val()=="中文/拼音")
            {
               alert("到达城市不能为空，请检查后重新填写!");
               $("#tocity").focus();
               return false;
            }
            else if($("#txtStartDate").val()==""||$("#txtStartDate").val()=="往")
            {
               alert("起飞日期不能为空，请检查后重新填写！");
               $("#txtStartDate").focus();
               return false;
            }
            else if(rdoFrom.checked==true && ($("#txtBackDate").val()==""||$("#txtBackDate").val()=="返"))
            {
                alert("返程日期不能为空，请检查后重新填写！");
                $("#txtBackDate").focus();
                return false;
            }
            else if(rdoFrom.checked==true&&CompareDate($("#txtStartDate").val(),$("#txtBackDate").val()))
            {
                alert("返程日期不能早于出发日期，请重新选择！");
			    $("#txtBackDate").focus();
			    return false;
            }
            else
            {
			        $("#container").hide();
                    $("#tbloading").show();
                    $("#span_loadtext").html("请稍候，<br />您查询的航班正在搜索中...");
                    return true;
             }
            
   }
   function datacheckfliht()
   {
      $("#container").hide();
      $("#tbloading").show();
      $("#span_loadtext").html("请稍候，<br />您查询的航班正在搜索中...");
   }
   function datachecktrip()
   {
      $("#container").hide();
      $("#tbloading").show();
      $("#span_loadtext").html("请稍候，<br />您查询的旅游线路正在搜索中...");
   }
   
   function CompareDate(d1,d2)
{
   return ((new Date(d1.replace(/-/g,"\/"))) > (new Date(d2.replace(/-/g,"\/"))));
}
function citycontrdis(state)
{
	document.getElementById("citytospan").style.display="none";
	document.getElementById("cityconspan").style.display="none";
	document.getElementById("citycontr").style.display=state;
	if("block"==state)
	{
		document.getElementById("ticketsearchtable").style.lineHeight="30px";
		document.getElementById("cityconspan").style.display="block";
	}else
	{
		document.getElementById("ticketsearchtable").style.lineHeight="40px";
		document.getElementById("citytospan").style.display="block";
	}
}
 function changecheckrad(id)
 {
 	if(id==1)
 	{
 		document.getElementById("txtBackDate").value="返";
 		document.getElementById("txtBackDate").disabled="disabled";
 	}else
 	{
 		document.getElementById("txtBackDate").disabled="";
	}
 }
 
 
 
 function CheckDataF()
    {
        var rdoFrom=document.getElementById("tripTyperound");
        var rdoOnlone=document.getElementById("tripTypesingle");
        
        if($("#city_from_hide_gj").val()=="")//中文/拼音
        {
            alert("出发城市为必填项,请检查后重新填写！");
            $("#arrcitygj").focus();
            return false;
        }
        if($("#city_to_hide_gj").val()=="")
        {
            alert("到达城市为必填项,请检查后重新填写！");
            $("#tocitygj").focus();
            return false; 
        }
        if($("#txtStartDategj").val()=="")
        {
           alert("出发日期为必填项,请检查后重新填写！");
           $("#txtStartDategj").focus();
           return false;
        }
        if(rdoFrom.checked==true && $("#txtBackDategj").val()=="")
        {
            alert("返程时间不能为空！");
            $("#txtBackDategj").focus();
            return false;
        }
        else if($("#txtBackDategj").val()!="" && Computation($("#txtStartDategj").val(),$("#txtBackDategj").val())>0)
        {
             alert("返程日期不能早于出发日期,请检查后重新填写！");
             $("#txtBackDategj").focus();
             return false; 
         }
         
         dispose("正在为你查询国际航班");
        
    }
    
    // 计算两个日期的间隔天数  
function Computation(sDate1, sDate2){   //sDate1和sDate2是2008-12-13格式    
   var aDate, oDate1, oDate2, iDays;    
    aDate = sDate1.split("-");    
    oDate1 = new Date(aDate[0],aDate[1]-1,aDate[2]);    
    aDate = sDate2.split("-");    
    oDate2 = new Date(aDate[0],aDate[1]-1,aDate[2]);    
        
    iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 /24);      
    if((oDate1 - oDate2)<0){    
        return -iDays;    
    }    
    return iDays;    
}  
 

