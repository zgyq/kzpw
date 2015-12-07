<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html>
<head>
<title>中国我们一起飞预订无忧航旅平台</title>

<link rel="stylesheet" type="text/css"
	href="js2/resources/css/ext-all.css" />
	<link href="css/dao.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js2/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js2/ext-all.js"></script>
<link href="css/default.css" rel="stylesheet" type="text/css">
<script src="js/base64.min.js" type="text/javascript"></script>
<script src="js/jquery1.3.2.js"></script>
<script src="js/jquery-ui-all-min-lastest.js" type="text/javascript"></script>
<style type="text/css">
.passtable {
	border-collapse: collapse;
	border: none;
	
}

.passtd {
	border: solid #99CCFF 1px;
}
.shengqing{ position:absolute; z-index:99999; bottom:20px; left:920px;}
.shengqing a{ color:#Fff; font-size:14px; margin:0 5px; text-decoration:none;}
.shengqing a:hover{ text-decoration:underline; color:#FF0}
</style>
<script type="text/javascript">
    Ext.require(['*']);
    Ext.Loader.setConfig({enabled: true});
	Ext.Loader.setPath('Ext.ux', 'js2/ux/');
	
	Ext.require([
	    'Ext.tab.*',
	    'Ext.ux.TabCloseMenu'
	]);

    Ext.onReady(function() {
	
    Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));
	    var currentItem;   
	  
    
	     Ext.define('liststore', {
	        extend: 'Ext.data.Model',
	        fields: [
	 	
			'id','text','code','name'
	           
	        ],
	        idProperty: 'id'
	    });
   	
     /*
      var store = Ext.create('Ext.data.TreeStore', {
      	    model: 'liststore',
	        proxy: {
	            type: 'ajax',
	            url: 'login!jsonlist.action'
	        },
	        root: {
	            text: '所有分类',
	            id: '-1',
	            expanded: true
	        },
	        folderSort: true,
	        sorters: [{
	            property: 'text',
	            direction: 'ASC'
	        }]
   	  });
	    */ 
     
    		

        var viewport = Ext.create('Ext.Viewport', {
            id: 'border-example',
            layout: 'border',
           
           
            items: [
            // create instance immediately
            Ext.create('Ext.Component', {
                region: 'north',
              
               contentEl: 'north'
            }),
            	  {
                	region: 'south',
                	height: 20,
                	contentEl: 'south'
                 }
            	,
             {
                region: 'west',
                id: 'west-panel', // see Ext.getCmp() below
                title: '功能列表',
                split: true,
                width: 200,
                minWidth: 175,
                maxWidth: 400,
                collapsible: true,
                animCollapse: true,
                margins: '0 0 0 5',
                
                
                layout: 'accordion',
               
		                items: [
		                
		                <ww:iterator value="menulist" status="state">
		               Ext.create('Ext.tree.Panel', {
							    title: '<ww:property value="name"/>',
							   
							    store: Ext.create('Ext.data.TreeStore', {
							      	    model: 'liststore',
								        
								        proxy: {
								            type: 'ajax',
								            url: 'login!jsonlist.action?id=<ww:property value="id"/>'
								        },
								        root: {
								            text: '所有分类',
								            id: '-1',
								            expanded: true
								        },
								        folderSort: true
								        /*,
								        sorters: [{
								            property: 'text',
								            direction: 'ASC'
								        }]*/
							   	 	 }),
							    rootVisible: false,
							    listeners: {
        							itemclick: function(a,b){
	        							//Ext.Msg.alert('Status',this.getWidth());
							        	if(b.get('leaf')){
							        	 	//Ext.get('mainf').set({src:b.get('hrefTarget')});
							        	 	//Ext.getCmp('maintitle').setTitle(b.get('text'));
							        	 	
							        	 	
							        	 	//
											var tab = Ext.getCmp('maintab').getTabBar().child('*[text='+b.get('name')+']');
								        	 	if(tab){
								        	 		Ext.getCmp('maintab').getTabBar().remove(tab);
								        	 	}
							        	 	
							        	 	//
							        	  tab =Ext.getCmp('maintab').add({
							        	 		title:b.get('text'),
							        	 		closable: true,
							        	 		//html:'<iframe name="key111"  src="'+atob(b.get('code'))+'" width="100%" height="100%" frameborder="0"  ></iframe>'
							        	 		html:'<iframe name="key111"  src="'+b.get('code')+'" width="100%" height="100%" frameborder="0"  ></iframe>'
							        	 	});
							        	 	Ext.getCmp('maintab').setActiveTab(tab);
											
							        	 }
						       		},
						       		resize: function(){
						       			
						       			//this.view.width=200;
						       			//Ext.Msg.alert('Status',this.view.hide());
						       		
						       		}
        						}
							   
							    
							    //renderTo: 'tree'
							})
						<ww:if test='#state.last'>
		                
		               </ww:if><ww:else>
		               ,
		               </ww:else>
						</ww:iterator>
						//{
						//	title:'常用工具',
						//	contentEl:'alipay'
						
						//}
						]

                	
            },
            // in this instance the TabPanel is not wrapped by another panel
            // since no title is needed, this Panel is added directly
            // as a Container
            Ext.create('Ext.tab.Panel', {
                region: 'center', // a center region is ALWAYS required for border layout
                deferredRender: false,
                margins: '0 1 0 0',
                activeTab: 0,     // first tab initially active
                id:'maintab',
                items: [
              {
                   // contentEl: 'center2',
                    
                    title: '航班查询',
                  // url:'b2bairsearch.action',
                   
                   html:'<iframe name="key111"  src="b2bairsearch.action" width="100%" height="100%" frameborder="0"  ></iframe>',
			
                    closable: true,
                   autoScroll: true
                   
                   

       		 
                 
                }
                
                ],
                
        plugins: Ext.create('Ext.ux.TabCloseMenu', {
            extraItemsTail: [
                '-',
                {
                    text: 'Closable',
                    checked: true,
                    hideOnClick: true,
                    handler: function (item) {
                        currentItem.tab.setClosable(item.checked);
                    }
                }
            ],
            listeners: {
                aftermenu: function () {
                    currentItem = null;
                },
                beforemenu: function (menu, item) {
                    var menuitem = menu.child('*[text="Closable"]');
                    currentItem = item;
                    menuitem.setChecked(item.closable);
                }
            }
        })
                
                
                
            })]
        });
       document.getElementById("but").style.display="block";
       /**
         <td width="10%"><a href="#" onclick="test('航班查询','b2bairsearch.action')" style="color: white">航班查询</a></td>
        <td width="10%"><a href="#" onclick="test('公告信息','login!tosysmessage.action')" style="color: white" >公告信息</a></td>
        <td width="10%"><a href="opinion.jsp"  target="_blank" style="color: white">投诉与建议</a> </td>
        <td width="10%"><a href="#" onclick="test('修改密码','login!toeditpassword.action')" style="color: white">修改密码</a></td>
        <td width="10%"><a href='#'  onclick="test('查看预存款','rebaterecord.action')"  style="color: white">查看预存款</a></td> 
        <td width="10%"><a href='#'  onclick="showqq();"  style="color: white">在线客服</a></td> 
     */  
       
        new Ext.Button( 
 	         { 
	         //	icon:'images/menu/favicon.png',
	         	text: '航班查询',
	         	margin:"0 10 0 10",
		        handler: function(){
		         	
			  		test('航班查询','b2bairsearch.action');
			  		
		        }
		        
       		 }).render(document.body, 'b_b'); 
        
        new Ext.Button( 
 	         { 
	         //	icon:'images/menu/favicon.png',
	         	text: '公告信息',
	         	margin:"0 10 0 0",
		        handler: function(){
		         	
			  		test('公告信息','login!tosysmessage.action')
			  		
		        }
		        
       		 }).render(document.body, 'b_b'); 
       		 
       	new Ext.Button( 
 	         { 
	         //	icon:'images/menu/favicon.png',
	         	text: '修改密码',
	         	margin:"0 10 0 0",
		        handler: function(){
		         	
			  		test('修改密码','login!toeditpassword.action')
			  		
		        }
		        
       		 }).render(document.body, 'b_b'); 
       		 
       		 <ww:if test="getLoginAgent().id==46">
       	   	new Ext.Button( 
 	         { 
	         //	icon:'images/menu/favicon.png',
	         	text: '消费记录',
	         	margin:"0 10 0 0",
		        handler: function(){
		         	
			  		test('消费记录','rebaterecord.action')
			  		
		        }
		        
       		 }).render(document.body, 'b_b'); 
       		 </ww:if><ww:else>
       			new Ext.Button( 
 	         { 
	         //	icon:'images/menu/favicon.png',
	         	text: '消费记录',
	         	margin:"0 10 0 0",
		        handler: function(){
		         	
			  		test('消费记录','rebaterecord!torebaterecord.action?rebaterecord.rebateagentid=<ww:property value="#session.loginuser.agentid" />')
			  		
		        }
		        
       		 }).render(document.body, 'b_b'); 
       		 </ww:else>
       		new Ext.Button( 
 	         { 
	         //	icon:'images/menu/favicon.png',
	         	text: '在线客服',
	         	margin:"0 10 0 0",
		        handler: function(){
		         	
			  		test('在线客服','login!towelcome.action')
			  		
		        }
		        
       		 }).render(document.body, 'b_b'); 
        
        /*
	        Ext.getCmp('htree').on('itemclick',function(a,b){
	        	//Ext.Msg.alert('Status',b.getId()+b.get('user')+b.get('leaf'));
	        	if(b.get('leaf')){
	        	 	//Ext.get('mainf').set({src:b.get('hrefTarget')});
	        	 	//Ext.getCmp('maintitle').setTitle(b.get('text'));
	        	 	var tab =Ext.getCmp('maintab').add({
	        	 		title:b.get('name'),
	        	 		closable: true,
	        	 		html:'<iframe name="key111"  src="'+b.get('code')+'" width="100%" height="100%" frameborder="0"  ></iframe>'
	        	 	});
	        	 	Ext.getCmp('maintab').setActiveTab(tab);
	
	        	 }
	        });
        */
        // get a reference to the HTML element with id "hideit" and add a click listener to it
       /*
        Ext.get("hideit").on('click', function(){
            // get a reference to the Panel that was created with id = 'west-panel'
            var w = Ext.getCmp('west-panel');
            // expand or collapse that Panel based on its collapsed property state
            w.collapsed ? w.expand() : w.collapse();
        });
       
        
         Ext.getCmp('west-panel').expand();
         
       /*  
   setInterval(function(){
			   var d = new Date(); 
			   var month = ((d.getMonth()+1)<10 )? '0'+(d.getMonth()+1) :(d.getMonth()+1);
			   var date  = (d.getDate()<10 )? '0'+d.getDate() :d.getDate();
			   var hour  = (d.getHours()<10 )? '0'+d.getHours() :d.getHours();
			   var minute = (d.getMinutes()<10 )? '0'+d.getMinutes() :d.getMinutes();
			   var second = (d.getSeconds()<10 )? '0'+d.getSeconds() :d.getSeconds();
		       var week = new Array("日","一","二","三","四","五","六");
	document.getElementById('showtime').innerHTML=
	d.getFullYear()+'-'+ month +'-'+ date+' '
		+hour+':'+minute+':'+second+' 星期'+
	week[d.getDay()];}, 1000);
  */
   
    });
    
    function test(title,url){
  										 var tab = Ext.getCmp('maintab').getTabBar().child('*[text='+title+']');
								        	 	if(tab){
								        	 		Ext.getCmp('maintab').getTabBar().remove(tab);
								        	 	}
								        	 	
								        	 	
								        	 	
     	tab =Ext.getCmp('maintab').add({
			title:title,
			closable: true,
			//html:'<iframe name="key111"  src="'+atob(b.get('code'))+'" width="100%" height="100%" frameborder="0"  ></iframe>'
			html:'<iframe name="key111"  src="'+url+'" width="100%" height="100%" frameborder="0"  ></iframe>'
			});
			Ext.getCmp('maintab').setActiveTab(tab);
    }
      function test22(title){
    alert(title);
     	
    }
    
    
    function closetab(){
       // alert(Ext.getCmp('maintab'));
    	Ext.getCmp('maintab').getActiveTab().close();
    
    }
  
    </script>
</head>
<body onload="onlod();">


<div id="north"
	style="background-image: url(images/top_bg01.jpg); width: 100%; height: 48px">
	
	
	<div id="dao">
<div style="width:1440px; height:0; visibility:hidden;clear:both;"></div>
  <div id="menu">
  	<ul>
    	<li style="display: none"><a id="m-1"  href="#">首页</a></li>
        <li><a id="m-2" class="select" href="#" onclick="test('航班查询','b2bairsearch.action');checkTab(2);">航班查询</a></li>
        <li><a id="m-3" href="#" onclick="test('公告信息','login!tosysmessage.action');checkTab(3);">公告信息</a></li>
         <ww:if test="getLoginAgent().id==46">
          <li><a id="m-4" href="#" onclick="test('消费记录','rebaterecord.action');checkTab(4);">消费记录</a></li>
         </ww:if><ww:else>
          <li><a id="m-4" href="#" onclick="test('消费记录','rebaterecord!torebaterecord.action?rebaterecord.rebateagentid=<ww:property value="#session.loginuser.agentid" />');checkTab(4);">消费记录</a></li>
         </ww:else>
        <li><a id="m-5" href="#" onclick="test('修改密码','login!toeditpassword.action');checkTab(5);">修改密码</a></li>
        <li><a id="m-6" href="#" onclick="test('在线客服','login!towelcome.action');checkTab(6);">在线客服</a></li>
     
        
    </ul>
  </div>
  <ww:if test="getLoginsessionagent().agenttype==1">
  <div id="shengqing">
  <a href="#"  onclick="test('申请退票','b2bticketorder.action?s_orderstatus=4&ty=12&');">申请退票(<span id="tp"></span>)</a>
  <a href="#"  onclick="test('申请废票','b2bticketorder.action?s_orderstatus=5&ty=3&');">申请废票(<span id="fp"></span>)</a>
  <a href="#"  onclick="test('申请改签','b2bticketorder.action?s_orderstatus=13&ty=9&');">申请改签(<span id="gq"></span>)</a></div>
  </ww:if>
  
  <div id="daoinfo">
  &nbsp;用户：<ww:property value="#session.loginuser.loginname" />  公司：<ww:property value="getangname(#session.loginuser.agentid)" />
  <a href="login!logout.action">退出</a>

  </div>
</div>

<!--

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td height="48">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
			
			images/logo_login_hz.gif
				
				<td width="23%"><img src="" width="229"
					height="46"></td>
				<td>
				<table border="0" align="right" cellpadding="0" cellspacing="0">
					<tr>
				
				<td>
				<div id="b_b"></div>
				</td>
					
						<td nowrap class="txt_login"><img
							src="images/top_member_info.gif" width="28" height="38"
							align="absmiddle">用户：<ww:property
							value="#session.loginuser.loginname" />&nbsp;公司：
							<ww:property value="getangname(#session.loginuser.agentid)" />
						</td>
						<td>
						<div align="right"><a href="login!logout.action"><img
							src="images/top_btn_logout.gif" width="56" height="24" border="0"></a></div>
						</td>
						
				 
				
					</tr>
				</table>
				</td>
			</tr>
	</table>
	-->
	
	</td>
	</tr>
	
	<!--
	<tr style="display: none">
		<td height="48">
	<table>
			<tr>
				<td>
				<div id="b_b"></div>
				</td>
				<td width="400px;">&nbsp;</td>
				<td align="right"><span id="tiptitle" style="display: none; color: white;">订单提醒：</span>
				<span id="or1"></span> <span id="or2"></span>
				<span  id="or3"></span> <span id="or4"></span>
				<span  id="or5"></span></td>
			</tr>
		</table>
		</td>
	</tr>
-->
</table>
</div>

<div id="center2" class="x-hide-display"></div>

<!--
<div id="alipay" class="x-hide-display">
	<ul>
		
		<li style="text-align: left;margin-left: 10px;"><a href="#"  onclick="test('全国机场分布','login!toairport.action')"
			><b>(1):&nbsp;全国机场分布</b></a></li>
			</br>
		<li style="text-align: left;margin-left: 10px;margin-top: 4px;"><a href="#" onclick="test('天气预报','login!toweather.action')"
			><b>(2):&nbsp;天气预报</b></a></li>
	
	</ul>
</div>

-->
<div id="tree" class="x-hide-display"></div>



<div id="south" style="background-image: url(images/top_bg01.jpg); width: 100%; height: 25px">
	<p align="center" style="margin-top: 0px; font-size: 12px;"><font color="#FFFFFF" id="but" style="display: none"> 版权所有：2012</font></p>
</div>


</body>
</html>


<SCRIPT language=javascript> 


		 
       		 
function gogo(){ 
$("#divqqmenu").hide();
} 
function showqq()
{
 $("#divqqmenu").show();
}


//document.getElementById("iframe1").innerHTML="";

//其他也是差不多这样.....

//加载订单信息

function onlod(){

<ww:if test="getLoginsessionagent().agenttype==1">
	showMessage();
</ww:if>
}
function showMessage() {
		var url="orderinfo!getOrderCount.action?rndmath="+Math.floor(Math.random()*100);
		var params = {s_status:2};
		jQuery.post(url,params, function(data) {
			if (data != '') {
			var message=eval("analytic("+data+")");
			
		
			}
		});
	}
//解析提示数据
function analytic(ticket){
var dingling=false;
//var img="<img src='imagess/gif-0242.gif'>";
var img="&nbsp;";
<ww:if test="getLoginsessionagent().agenttype==1">
var tuiticket=ticket.tuiticket;//申请退票
var feiticket=ticket.feiticket//申请废票
var gaiqianticket=ticket.gaiqianticket;//申请改签
//alert("tuiticket:"+tuiticket+",feiticket:"+feiticket+",gaiqianticket:"+gaiqianticket);

$("#tp").html(tuiticket);
$("#fp").html(feiticket);
$("#gq").html(gaiqianticket);

</ww:if>
}


//window.setInterval(onlod,'60000');



function checkTab(index){

for(a=2;a<=6;a++){

document.getElementById("m-"+a).className=""; 

}


document.getElementById("m-"+index).className="select"; 

}

</SCRIPT>
