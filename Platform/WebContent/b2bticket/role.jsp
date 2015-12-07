<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="ww" uri="/struts-tags" %>
<%
/**
 * 版权所有，允风文化投资有限公司
 * Author: yunfeng
 * copyright: 2012
 */
%>
<html>
<head>
  <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
 	<link href="../css/default.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../js/ext-all.js"></script>


    
    <script type="text/javascript">
   	
   	Ext.Loader.setConfig({enabled: true});

	Ext.Loader.setPath('Ext.ux', '../js/ux/');
	Ext.require([
	    'Ext.grid.*',
	    'Ext.data.*',
	    'Ext.util.*',
	    'Ext.toolbar.Paging',
	    'Ext.ux.PreviewPlugin',
	    'Ext.ModelManager',
	    'Ext.tip.QuickTipManager'
	]);

	var gwin;
	var store;

	function grefresh(){
	
	  if(gwin){
			gwin.close();
			store.load();
		}
	}

Ext.onReady(function(){
    Ext.tip.QuickTipManager.init();

    Ext.define('liststore', {
        extend: 'Ext.data.Model',
        fields: [
 	
'id','name','description','createtime','createuser','modifytime','modifyuser'

           
        ],
        idProperty: 'id'
    });

    // create the Data Store
    store = Ext.create('Ext.data.Store', {
        pageSize: 10,
        model: 'liststore',
        remoteSort: true,
        proxy: {        
            type: 'jsonp',
            url: 'role!jsonlist.jspx',
                   
            reader: {
                root: 'listroot',
                totalProperty: 'totalCount'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        sorters: [{
            property: 'id',
            direction: 'DESC'
        }]
    });


    var pluginExpanded = true;
    var sm = Ext.create('Ext.selection.CheckboxModel');
    var grid = Ext.create('Ext.grid.Panel', {
    	id:'grid',
        layout: 'fit',
        store: store,
        disableSelection: false,
        selModel:sm,
        loadMask: true,
        viewConfig: {
            id: 'gv',
            trackOver: false,
            stripeRows: false,
            plugins: [{
                ptype: 'preview',
                bodyField: 'excerpt',
                expanded: true,
                pluginId: 'preview'
            }]
        },
        // grid columns
        columns:[
        
        	

				 	
				 	{            
		            text: "id",
				 	
 		            dataIndex: 'id',
		            sortable: true
       			 	},
				 	
				 	
				 
				 
				 	
				 	{            
		            text: "名称",
				 	
 		            dataIndex: 'name',
		            sortable: true
       			 	},
				 	
				 	
				 
				 
				 	
				 	{            
		            text: "介绍",
				 	
 		            dataIndex: 'description',
		            sortable: true
       			 	},
				 	
				 	
				 
				 
				 	
			 	{            
		            text: "创建时间",
				 	width:200,
            		renderer: renderTime,
 		            dataIndex: 'createtime',
		            sortable: true
       			 },
				
		  		  
				
				 	
				 	{            
		            text: "创建用户",
				 	
 		            dataIndex: 'createuser',
		            sortable: true
       			 	},
				 	
				 	
				 
				 
				 	
			 	{            
		            text: "修改时间",
				 	width:200,
            		renderer: renderTime,
 		            dataIndex: 'modifytime',
		            sortable: true
       			 },
				
		  		  
				
				 
				 	{            
		            text: "修改用户",
				 	
 		            dataIndex: 'modifyuser',
		            sortable: true
       			 	}
		  		  
				

        
       
        
        ],
        // paging bar on the bottom
        bbar: Ext.create('Ext.PagingToolbar', {
            store: store,
            beforePageText:'第',
            afterPageText:'页/共{0}页',
            displayInfo: true,
            displayMsg: '显示行数从 {0} 到 {1} 共 {2} 行',
            emptyMsg: "没有结果。"
            /*,
            
            items:[
                '-', {
                text: '显示最前',
                pressed: pluginExpanded,
                enableToggle: true,
                toggleHandler: function(btn, pressed) {
                    var preview = Ext.getCmp('gv').getPlugin('preview');
                    preview.toggleExpanded(pressed);
                }
            }]*/
        }),
        renderTo: 'topic-grid'
    });
	
	function renderTime(value, p, r) {
	  if(value){
	    var date = new Date(value.time);
	    
        return Ext.String.format('{0}',Ext.Date.dateFormat(date, 'Y-m-d H:i:s'));
        }
       return "";
    }
	
	store.loadPage(1);
	
	
	
	new Ext.Button( 
 	         { 
	         	icon:'../images/menu/new16.gif',
	         	text: '新建',
		        handler: function(){
		           //window.location.href='role!toadd.action';
		        if(gwin){gwin.close();}
		        gwin = Ext.create('Ext.Window', {
			        
			        title: '新建',
			        maximizable: true,
			        width: 800,
			        height: 400,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src="role!toadd.action?<ww:property value="url"/>" width="100%" height="100%" frameborder="0" ></iframe>'
		
			        }
			        ]
			        
			  		});
			  		gwin.show();
		        }
		        
       		 }).render(document.body, 'b_new');
  
 	new Ext.Button( 
 	         { 
	         	icon:'../images/menu/delete16.gif',
	         	text: '批量删除',
		        handler: function(){
		        
		        	Ext.Msg.show({title:'删除',width:300, msg:'确认批量删除吗？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						 var selectStr =""; 
				            if(sm.selected.items.length>0){
				            	var i=0;
				            	for(i=0;i<sm.selected.items.length; i++){
				            		//selectid.push(sm.selected.items[i].get('author'));	
				            		if(i>0 &&( i+1 ==sm.selected.items.length)){
				            			selectStr+= "selectid="+sm.selected.items[i].get('id');
				            		}else{
				            			selectStr+= "selectid="+sm.selected.items[i].get('id')+"&";
				            		}
				            	}
				            	
				            	//window.location.href="role!batch.action?opt=1&"+selectStr;
				            	Ext.Ajax.request({
							       url: "role!batch.action?opt=1&"+selectStr,
							       success: function(response){
							        //var text = response.responseText;
							           store.load();
							        // process server response here
							      }
							   });
				            
				            }else{
				          	  Ext.Msg.alert('status','请选取一项进行操作！');
				            }
					
						}
					}});
					
		           
		           
		        }
		        
       		 }).render(document.body, 'b_delete');
  
  
       
         var selectId ;


	 var menu = new Ext.menu.Menu({
        id: 'mainMenu',
		width:'160px',
        style: {
            overflow: 'visible'     // For the Combo popup
        },
        items: [
		     
		    {
                id:"new",
				text: '新建',
				icon:"../images/menu/new.gif",
				handler : function(item){
					//window.location.href="role!toadd.action?<ww:property value="url"/>";
					 if(gwin){gwin.close();}
		        gwin= Ext.create('Ext.Window', {
			        
			        title: '新建',
			        maximizable: true,
			        width: 800,
			        height: 400,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src="role!toadd.action?<ww:property value="url"/>" width="100%" height="100%" frameborder="0" ></iframe>'
		
			        }
			        ]
			        
			  		});
			  		gwin.show();
					
				}
            },
            
              {
                id:"edit",
				text: '修改',
				icon:"../images/menu/edit.gif",
				handler : function(item){
					//window.location.href="role!toedit.action?id="+selectId+"&<ww:property value="url"/>";
					//alert(selectId);
					 if(gwin){gwin.close();}
		        gwin= Ext.create('Ext.Window', {
			        
			        title: '修改',
			        maximizable: true,
			        width: 800,
			        height: 400,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src="role!toedit.action?id='+selectId+'&<ww:property value="url"/>" width="100%" height="100%" frameborder="0" ></iframe>'
		
			        }
			        ]
			        
			  		});
			  		gwin.show();
					
				}
            },
                      {
                id:"delete",
				text: '删除',
				icon:"../images/menu/delete.gif",
				handler : function(item){
					Ext.MessageBox.show({title:'删除',width:300, msg:'确认删除吗？',buttons: Ext.MessageBox.YESNO,fn:function(btn){
						
						if(btn=='yes')
						{
						//	window.location.href="role!delete.action?id="+selectId;
							Ext.Ajax.request({
							       url: "role!delete.action?id="+selectId,
							       success: function(response){
							        //var text = response.responseText;
							           store.load();
							        // process server response here
							      }
							   });
					
					
						}
					}});
					
				}
            },'-',
            {
                id:"allocright",
				text: '分配权限',
				icon:"../images/menu/check.gif",
				handler : function(item){
					
					Ext.create('Ext.Window', {
			        
			        title: '分配权限',
			        maximizable: true,
			        width: 800,
			        height: 400,
			        plain: true,
			        layout: 'fit',
			     
			        items: [{
			            border: false,
			            html:'<iframe   src="role!toallocright.action?id='+selectId+'&<ww:property value="url"/>" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>'
		
			        }
			        ]
			        
			  		}).show();
				}
			}
		]

		});


	   grid.on("itemcontextmenu",function(a,b,c,d,e) {
			e.preventDefault();
			//var record =(grid.getStore().getAt(rowIndex));
			selectId = b.get('id');
			//alert(b.get('title'));
		//	alert(record.data.company);
			//menu.showAt(e.getPoint());
			menu.setPosition(e.getPoint().x,e.getPoint().y); 
			menu.show();
	
	   });
       var viewport = Ext.create('Ext.Viewport', {
                layout:'border',
                items:[
                    {
                    region:'north',
                    bodyStyle:'background:#f1f1f1',
                    margins: '0 0 0 0',
                    border:0,
                    contentEl:'mainform'
                   
                   // html:'<br/><br/>&lt;empty center panel&gt;'
                },{
                	region:'center',
                	autoScroll: true,
                	margins: '0 0 0 0',
                	border:0,
                	layout: 'fit',
                	items:[
                		grid
                	]
                }
                ]
            });
 
});
    
    
    </script>
</head>
<body>


<div id = "mainform">

<form action="role.action">
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td valign="top" background="../images/titleL3_bg.gif"> <table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="../images/titleL3_point.gif" width="33" height="19"><span class="txt_title3">角色列表</span>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td valign="bottom">
					<table border="0" cellpadding="0" cellspacing="0">
                    <tr>    <td width=42 nowrap>&nbsp;</td>
							<td  nowrap class="txt_search">
                        
							
                                     名称: <input type="text" id="s_name" name="s_name" value="<ww:property value="s_name"/>" class="Form_date"/> 
									<input type="submit" value="搜索" class="Form_date"> 

							</td>
                      </tr>
                  </table>
                
				</td>
              </tr>
              
              <tr>
              	<td>
              	</td>
              	
              	<td align="center"  width="80">
              		<div id="b_new" ></div>
              	</td>
              	
              	<td align="center"  width="80">
              			<div id="b_delete"></div>
              	</td>
              	
              </tr>
              <tr><td height="5"></td></tr>
          </table></td></tr>
          
    </table></td>
  </tr>
</table>
</form>
</div>

<div id="topic-grid"></div>

</body>
</html>



