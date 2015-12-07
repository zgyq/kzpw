<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="main_tulue/css/right.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="main_tulue/js/jquery-1.10.2.min.js"></script>
<link rel=stylesheet type=text/css href="main_tulue/js/train_js/css.css" />
<script type="text/javascript" src="main_tulue/js/train_js/city.js"></script>


<!--<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/js/train/header.js"></SCRIPT>
<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/js/train/twocold.js"></SCRIPT>

<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/js/train/yui.utilities.js"></SCRIPT>

<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/js/train/yui.autocomplete-min.js"></SCRIPT>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/js/train/main.js"></SCRIPT>
<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/js/train/input.js"></SCRIPT>


-->

<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/js/train/header.js"></SCRIPT>
<SCRIPT type=text/javascript src="<%=request.getContextPath()%>/js/train/twocold2.js"></SCRIPT>


<script type="text/javascript">
    //页面加载
    $(document).ready(function()
	   {

	    //默认加载当日日期
	  //$("#txtStartDate").val(getDateyyyyMMdd(3));
	  
	
	
	
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

function showInfo(traincode){  
  //jQuery(".tinfo").slideUp(1000);  
  var startdate=jQuery("#txtStartDate").val();
   jQuery("#divinfo_"+traincode).show();
  jQuery.ajax({
            type:"POST",
            url:"train!ajaxGetTrainInfo.action",
            data:{traincode:traincode,startdate:startdate},
            beforeSend:function(){ jQuery("#divinfo_"+traincode).html("<img src='images/loading.gif' />");},                      
            success:function(data){
            //alert(data);
             // var htm= eval(data);
             jQuery("#divinfo_"+traincode).hide();
              jQuery("#divinfo_"+traincode).html(data);
              jQuery("#divinfo_"+traincode).show();
              jQuery("#divinfo_"+traincode).slideDown(1500);
            }            
		 });
  
}

	</script> 
</head>
<body>
<div id="wrap">
<div class="right" id="main">
     <div class="box">
     
                 <!--搜索框 begin-->
 <FORM id=form1 method='POST' name=form1 action='train!search.action'>
                            <div class="search">
                                <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                    
                                    <tr>
                                         <td>
                                             航程类型：
                                              <select name="type">
                                              <option value="" selected="selected">单程</option>
                                              <option value="one" >往返</option>
                                              </select>
                                         </td>
                                         
                                         <td> 出发站：<input type="text"  name="startcity" value="<ww:property value='train.startcity'/>" id="citySelect"  /></td>
                                         <td> 到达站：<input type="text"  name="endcity" value="<ww:property value='train.endcity'/>" id="citySelect2" /></td>
                                         <td> 出发日期：<input type="text" id="txtStartDate" name="startdate" value='<ww:property value="train.startdate"/>'
	onfocus="WdatePicker({skin:'whyGreen'})" class="Wdate" /></td>
                                         <td> <a href="#" onclick="gosearch()" class="btn3"></a></td>
                                    
                                    </tr>
                                    
                                </table>
                                
                             </div>
    </FORM>                         
                 <!--搜索框 end--> 
                 
                 <!--日期 begin-->
                  <div class="date">
                     <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                         <tr>
                         <ww:bean name="'com.opensymphony.webwork.util.Counter'" id="counter">
						<ww:param name="'first'" value="1" />
						<ww:param name="'last'" value="7" />
						</ww:bean> 
						<ww:iterator value="#counter" status="state">
						
						
                        <td <ww:if test="train.startdate==GetDate(train.startdate,#state.index-(Calculate(train.startdate)>3?3:Calculate(train.startdate)))">class="td-now"</ww:if> ><a href="#" onclick="CheckDay('<ww:property value="GetDate(train.startdate,#state.index-(Calculate(train.startdate)>3?3:Calculate(train.startdate)))" />');return false;"><span>
                        <ww:property value="GetDate(train.startdate,#state.index-(Calculate(train.startdate)>3?3:Calculate(train.startdate)))" />
                        </span>
                        <ww:property value="getWeekStr(GetDate(train.startdate,#state.index-(Calculate(train.startdate)>3?3:Calculate(train.startdate))))" />
                        	</a></td>
                         </ww:iterator> 
                           
                         </tr>
                     </table>
                  </div>
                 <!--日期 end-->
                 
                 <!--搜索条件选择 begin-->
                       <div class="ticket-detail" >
                            <div class="train-num"><ww:property value="train.startcity"/>至<ww:property value="train.endcity"/>火车票<font>（共<font style="color: #FF7200" id='traincount'><ww:property value="trainlist.size()"/></font>个车次）</font></div>
                            <div class="train-chose">
                                 <dl>
                                    <dt>车&nbsp;&nbsp;&nbsp;&nbsp;型:</dt>
                                    <dd class="no-limit"><a href="#">不限</a></dd>
                                    <dd><input type="checkbox"  id="chktype_g" name="chktype" onclick="filtertrain2();" value="g">高铁(G)</dd>
                                    <dd><input type="checkbox" id="chktype_d" name="chktype" onclick="filtertrain2();" value="d">动车(D)</dd>
                                    <dd><input type="checkbox" id="chktype_z" name="chktype" onclick="filtertrain2();" value="z">直达(Z)</dd>
                                    <dd><input type="checkbox" id="chktype_t" name="chktype" onclick="filtertrain2();" value="t">特快(T)</dd>
                                    <dd><input type="checkbox" id="chktype_k" name="chktype" onclick="filtertrain2();" value="k">快速(K)</dd>
                                    <dd><input type="checkbox" id="chktype_0" name="chktype" onclick="filtertrain2();" value="0">其他</dd>
                                </dl>
                            </div>
                            
                            <div class="clearit"></div>
                            
                            <div class="train-chose">
                                 <dl>
                                    <dt>出发时段:</dt>
                                    <dd class="no-limit"><a href="#">不限</a></dd>
                                    <dd> <input name="shangwu-chufa" id="shangwu-chufa" type="checkbox" value="" onclick="filtertrain2();"  /> 上午(06-12)</dd>
                                    <dd> <input name="xiawu-chufa" id="xiawu-chufa" type="checkbox" value="" onclick="filtertrain2();"  />下午(12-18)</dd>
                                    <dd><input name="wanshang-chufa" id="wanshang-chufa"  type="checkbox" value="" onclick="filtertrain2();"  />晚上(18-06)</dd>
                                </dl>
                            </div>
                              <div class="clearit"></div>
                             <div class="train-chose">
                                 <dl>
                                    <dt>到达时段:</dt>
                                    <dd class="no-limit"><a href="#">不限</a></dd>
                                    <dd> <input name="shangwu-daoda" id="shangwu-daoda" type="checkbox" value="" onclick="filtertrain2();"  /> 上午(06-12)</dd>
                                    <dd> <input name="xiawu-daoda" id="xiawu-daoda" type="checkbox" value="" onclick="filtertrain2();"  />下午(12-18)</dd>
                                    <dd><input name="wanshang-daoda" id="wanshang-daoda"  type="checkbox" value="" onclick="filtertrain2();"  />晚上(18-06)</dd>
                                </dl>
                            </div>
                            <!--
                            
                            <div class="more">
                                 <a href="###">
                                    <span>更多筛选条件</span>
                                    <b class="icon_show"></b>
                                 </a>
                            </div>
                       
                      	 -->
                       </div>

                 <!--搜索条件选择 end-->
                 
                 <!--搜索结果展示 begin-->
                    <div class="result-show"  id="timetable2" >
                           <div class="show-tit">
                               <table  cellspacing="0" cellpadding="1" align="center" style="width:100%">
                                   <tr>
                                       <td class="trains">车次</td>
                                       <td class="station">发/到站</td>
                                       <td class="station">距离</td>
                                       <td class="start-time">发/到时间</td>
                                       <td class="run-time">运行时间</td>
                                       <td class="prices">参考价格</td>
                                       <td class="station">操作</td>
                                   </tr>
                               </table> 
                           </div>
                           <tbody id="trainvalue">
                           <ww:iterator value="trainlist" status="statu">
                           <div class="show-con" id="<ww:property value="traincode"/>_train_code">
                                <table cellspacing="0" cellpadding="1" align="center" style="width:100%"   >
                                    	<tr>
                                        <td class="trains"><span class="orange"><ww:property value="traincode"/></span><br /><a href="#" onclick="showInfo('<ww:property value="traincode"/>');return false;">经停站<b class="icon_hide"></b></a></td>
                                        <td class="station">
                                        <span class="begin"><ww:property value="sfz"/></span>
                                        <ww:if test="!zdz.equals(endcity)"><span class="pass"><ww:property value="endcity"/></span></ww:if>
                                        <span class="end"><ww:property value="zdz"/></span>
                                        </td>
                                        <td class="station"><ww:property value="distance"/>公里</td>
                                        <td class="start-time"><b class="fashi"><ww:property value="starttime"/></b><br /><b class="daoshi"><ww:property value="endtime"/></b></td>
                                        <td class="run-time"><ww:property value="costtime"/></td>
                                        <td class="prices">
                                        <ww:property value="getTicketPriceHtml_new(trainlist.get(#statu.index))"/>
                                        </td>
                                        <td class="station"><a href="#"><img src="main_tulue/img/yuding.gif"  onclick="goyptrain('<ww:property value="traincode"/>');return false;" href='javascript:void(0)' /></a></td>
	                                    </tr>
                                 </table>
                                         <!--经停站 begin-->
                                        
                               
                               <div class="pass-sation" style="display:none;" id="divinfo_<ww:property value="traincode"/>">
                               
                               </div>
                             
                              <!--经停站 end-->
                             
                          </div>
                           </ww:iterator>
                           </tbody>
                            
                          
                           
                          
                           

                      </div>

                 <!--搜索结果展示 end-->

       </div>
</div>

</div>
<form action="train!yptrain.action" name="form2" id="form2" method="POST">
<input type='hidden' name='startcity' value='<ww:property value="train.startcity"/>'>
<input type='hidden' name='endcity' value='<ww:property value="train.endcity"/>'>
<input type='hidden' name='startdate' value='<ww:property value="train.startdate"/>'>
<input type='hidden' name='traincode' id='traincode' >

</form>

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
function CheckDay(day){
$("#txtStartDate").val(day);
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

function goyptrain(traincode){
dispose("系统正在为您预定");
document.getElementById("traincode").value=traincode;
document.form2.action="train!toordertrain.action";
document.form2.submit();
}



 var test=new Vcity.CitySelector({input:'citySelect'});
 var test2=new Vcity.CitySelector({input:'citySelect2'});
</script>