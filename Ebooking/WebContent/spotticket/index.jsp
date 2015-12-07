<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link type="text/css" rel="stylesheet" href="spotticket/css/style1.css">
    <script src="js/jquery/jquery1.3.2.js" type=text/javascript></script>   
</head>
<script>
$(document).ready(function(){
  selectSpot(1,53);
});



function submit_form(){
$('#form_spot').submit()
}
function  selectSpot(index,cityid){
  $.ajax({
      type:"GET",
       url:"spotticket!GetSpotByCity_new.jspx",
      data:{CityID:cityid,para:Math.floor(Math.random()*10000)},
      beforeSend:function(){$("#divHotelHtml").html("&nbsp;&nbsp;&nbsp;&nbsp;<img src='images/loadding.gif' border='0' />正在加载推荐景区信息...");},             
      success:function(data){
      seletecity(index);
      $("#divHotelHtml").html(data);           
      }            
      }); 
}
function seletecity(index){

for(i=1;i<=4;i++){
	 document.getElementById("class_"+i).className=""; 
	 
}
  document.getElementById("class_"+index).className="active"; 
}
</script>
<body>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=3&subindex=1" />
	</div>
<form action="spotticket!SeachSpot.jspx" method="post" id="form_spot" name="form_spot">	
<div class="nav_spot">
    <div class="search_spot">
        <input type="text" value="搜索" value="搜索" onfocus="if (value =='搜索'){value =''}"
               onblur="if (value ==''){value='搜索'}else{submit_form()}" id="S_SeachName" name="SeachName"  >
               
        <ul>
            <li>热门城市：</li>
            <li> <a href="spotticket!SeachSpot.jspx?CityID=53">北京</a></li>
            <li> <a href="spotticket!SeachSpot.jspx?CityID=321">上海</a></li>
            <li> <a href="spotticket!SeachSpot.jspx?CityID=80">广州</a></li>
            <li> <a href="spotticket!SeachSpot.jspx?CityID=383">杭州</a></li>
            <li> <a href="spotticket!SeachSpot.jspx?CityID=224">南京</a></li>
        </ul><!--
        <a href="#">查看全部国家列表>></a>
    --></div>
</div>
</form>
<div class="mid">
    <div class="listTab">
        <h3>国内游</h3>
        <ul>
            <li id="class_1" class="active" onclick="selectSpot(1,53);return false;">北京</li>
            <li id="class_2" onclick="selectSpot(2,321);return false;">上海</li>
            <li id="class_3" onclick="selectSpot(3,383);return false;">杭州</li>
            <li id="class_4" onclick="selectSpot(4,224);return false;">南京</li>
        </ul>
    </div>
    <div id="divHotelHtml">
    
    </div>
    <div class="listContent" style="display: none;">
        <ul>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
        
        
        
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            
        </ul>
    </div>
    
    
    
    <!--
    <div class="listTab">
        <h3>出国游</h3>
        <ul>
            <li class="active">厦门口</li>
            <li>厦门</li>
            <li>厦门</li>
            <li>厦门</li>
        </ul>
    </div>
    <div class="listContent">
        <ul>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
            <li>
                <img src="spotticket/img/ab4xPY_430x270_00.jpg">
                <dl>
                    <dt>[自由行]曼谷+芭堤雅5晚7/6日自由行</dt>
                    <dd><span><em>￥</em>3999</span> &nbsp起</dd>
                </dl>
            </li>
        </ul>
    </div>
-->
</div>


 <ww:include page="../footer.jsp"/> 
</body>
</html>