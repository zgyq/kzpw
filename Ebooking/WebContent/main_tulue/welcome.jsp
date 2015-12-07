<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<link rel=stylesheet type=text/css href="js/train_js/css.css" />
<script type="text/javascript" src="js/train_js/city2.js"></script>

<script type="text/javascript">
    //页面加载
    $(document).ready(function()
	   {

	    //默认加载当日日期
	  $("#txtStartDate").val(getDateyyyyMMdd(3));
	  
	
	
	 });
	  function getDateyyyyMMdd(num) {
    var d = new Date();
    d.setDate(d.getDate() + num);
    var y = d.getFullYear();
    var m = d.getMonth() + 1;
    if (m < 10) {
        m = '0' + m;
    }
    var d = d.getDate();
    if (d < 10) {
        d = '0' + d;
    }
    var str = y + '-' + m + '-' + d;
    return str;
}
	</script> 
</head>
<body>
<div id="wrap">
<div class="right" style="height:600px;background:url(img/right-bg.jpg) repeat;">
  <div class="searchs">
           <div class="searchs-bg">
           
                <!--搜做框 begin-->
                <FORM id=form1 method='POST' name=form1 action='../train!search.action'>
                  <div class="search-box">
                         <h1><span></span>国内火车票查询</h1>
                         <div class="types">
                                    航程类型: <label><input type="radio" name="traintype" value="" checked="checked" />单程</label>
                                    <label style="width:105px; display:inline-block;"><input type="radio" name="traintype" value="" />往返</label>
                                   
                              </div>
                              
                              <div class="types">
                                   出发城市: <input type="text"  name="startcity" value="北京" id="citySelect"  />
                             </div>
                             
                             <div class="types">
                                   到达城市: <input type="text"  name="endcity" value="上海" id="citySelect2" />
                             </div>
                             
                             <div class="types">
                                  出发日期: <input type="text" id="txtStartDate" name="startdate" value='<ww:property value="train.startdate"/>'
	onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" />
                             </div>
                             
                             <div class="search-btn"><a href="#" onclick="gosearch()"><img src="img/search-btn.gif" width="127" height="41" /></a></div>
                  </div>
                  </FORM>
                  <!--搜做框 end-->
                  
                 <!-- 新闻通知 begin-->
                  <div class="news-box">
                  
                      <h1><span></span>国内火车票查询</h1>   
                      <ul>
                          <li><a href="#">1.海南东环高铁21日12时开通 美兰站不办理客运业务...</a></li>
                          <li class="gray-bg"><a href="#">2.海南东环高铁21日12时开通 美兰站不办理客运业务...</a></li>
                          <li><a href="#">3.海南东环高铁21日12时开通 美兰站不办理客运业务...</a></li>
                          <li class="gray-bg"><a href="#">4.海南东环高铁21日12时开...</a></li>
                          <li><a href="#">5.海南东环高铁21日12时开通 美兰站不办理客运业务高铁21日12时开...</a></li>
                          <li class="gray-bg"><a href="#">4.海南东环高铁21日12时开通 美兰站不办理客运业务</a></li>
                          <li><a href="#">5.海南东环高铁21日12时开通 美兰站不办理客运业务高铁21日12时开...</a></li>
                          <li><a href="#">5.海南东环高铁21日12时开通 美兰站不办理客运业务</a></li>
                          <li class="gray-bg"><a href="#">4.海南东环高铁21日12时开通 美兰站不办理客运业务</a></li>
                          <li><a href="#">5.海南东环高铁21日12时开通 美兰站不办理客运业务高铁21日12时开...</a></li>
                      
                      </ul>
                  
                  </div>
                  <!-- 新闻通知 end-->
              
              
         </div>     
  
  
  </div>
  
  
</div>

</div>

</body>
</html>
 <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/resources/css/ext-all.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/adapter/ext/ext-base.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ext-all.js"></script>
<script type="text/javascript">
function gosearch(){

var startcity= $("#citySelect").val();
 		if(startcity=="" || startcity=="城市名")
	     {
	         alert("出发城市不能为空!");
	         return;
	     }
var endcity= $("#citySelect2").val();
 		if(endcity=="" || endcity=="城市名")
	     {
	         alert("出发城市不能为空!");
	         return;
	     }	     

 dispose("系统正在为您查询");
 document.form1.submit();
}

function dispose(message) {
   Ext.MessageBox.show({
           msg: message+', 请稍后......',
           progressText: 'Saving...',
           width:300,
           wait:true,
           waitConfig: {interval:200},
           icon:'ext-mb-download',
           animEl: 'mb7'
       });
}

 var test=new Vcity.CitySelector({input:'citySelect'});
 var test2=new Vcity.CitySelector({input:'citySelect2'});
</script>