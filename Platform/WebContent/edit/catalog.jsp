<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="ww" uri="/struts-tags" %>
<%
/**
 * 版权所有，thunder
 * Author: thunder
 * copyright: 2011
 */
%>
<html>
<head>
  <title>分类列表</title>
    <link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
    
 	<link href="../css/default.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
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



Ext.onReady(function(){
    Ext.tip.QuickTipManager.init();

    Ext.define('liststore', {
        extend: 'Ext.data.Model',
        fields: [
 	
'id','name','parentname','parentid','description','price','createtime','createuser','modifytime','modifyuser','parentidstr'

           
        ],
        idProperty: 'id'
    });

     var store = Ext.create('Ext.data.TreeStore', {
	  		model: 'liststore',
	        proxy: {
	            type: 'ajax',
	            url: 'catalog!jsonlist.jspx'
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


    var tree = Ext.create('Ext.tree.Panel', {
       // title: 'Core Team Projects',
        width: '100%',
        height: '100%',
        //layout:'fix',
        renderTo: 'treegrid',
       // collapsible: true,
        useArrows: true,
        rootVisible: false,
        store: store,
       // multiSelect: true,
        singleExpand: true,
        //checkable:true,
        // grid columns
        columns:[
        
        	

				 	
				 	{            
		            text: "id",
				 	hidden:true,
 		            dataIndex: 'id',
		            sortable: true
       			 	},
				 	
				 	
				 
				 
				 	
				 	{            
		            text: "名称",
				 	xtype: 'treecolumn',    
 		            dataIndex: 'name',
		            sortable: true
       			 	},
				 	
				 	
				 
				 
				 	
				 	{            
		            text: "父分类",
				 	
 		            dataIndex: 'parentname',
		            sortable: true
       			 	},
				 	
				 	
				 
				 
				 	
				 	{            
		            text: "介绍",
				 	
 		            dataIndex: 'description',
		            sortable: true
       			 	},
				 	
				 	
				 
				 
				 	
				 	{            
		            text: "价格",
				 	hidden:true,
 		            dataIndex: 'price',
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
       			 	},
				 	
				 	
				 
				 
				 
				 	{            
		            text: "父id串",
				 	hidden:true,
 		            dataIndex: 'parentidstr',
		            sortable: true
       			 	}
	
       
        
        ]
 
    });
	
	function renderTime(value, p, r) {
	  if(value){
	    var date = new Date(value.time);
	    
        return Ext.String.format('{0}',Ext.Date.dateFormat(date, 'Y-m-d H:i:s'));
        }
       return "";
    }
	
	
	
	
	
	new Ext.Button( 
 	         { 
	         	icon:'../images/menu/new16.gif',
	         	text: '新建',
		        handler: function(){
		           //window.location.href='catalog!toadd.action';
		        	
		        	Ext.create('Ext.Window', {
			        
			        title: '新建',
			        maximizable: true,
			        width: 800,
			        height: 400,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src="catalog!toadd.action?<ww:property value="url"/>" width="100%" height="100%" frameborder="0" ></iframe>'
		
			        }
			        ]
			        
			  		}).show();
		        }
		        
       		 }).render(document.body, 'b_new');
  
 	
  
       
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
					//window.location.href="catalog!toadd.action?<ww:property value="url"/>";
					Ext.create('Ext.Window', {
			        
			        title: '新建',
			        maximizable: true,
			        width: 800,
			        height: 400,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src="catalog!toadd.action?<ww:property value="url"/>" width="100%" height="100%" frameborder="0" ></iframe>'
		
			        }
			        ]
			        
			  		}).show();
					
				}
            },
            
              {
                id:"edit",
				text: '修改',
				icon:"../images/menu/edit.gif",
				handler : function(item){
					//window.location.href="catalog!toedit.action?id="+selectId+"&<ww:property value="url"/>";
					//alert(selectId);
					
					Ext.create('Ext.Window', {
			        
			        title: '修改',
			        maximizable: true,
			        width: 800,
			        height: 400,
			        plain: true,
			        layout: 'fit',
			        
			        items: [{
			            border: false,
			            html:'<iframe   src="catalog!toedit.action?id='+selectId+'&<ww:property value="url"/>" width="100%" height="100%" frameborder="0" ></iframe>'
		
			        }
			        ]
			        
			  		}).show();
					
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
							window.location.href="catalog!delete.action?id="+selectId;
							
					
						}
					}});
					
				}
            }
		]

		});


	   tree.on("itemcontextmenu",function(a,b,c,d,e) {
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
                		tree
                	]
                }
                ]
            });
 
 
});
    
    
    </script>
</head>
<body>


<div id="mainform">

<form action="catalog.action">
<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td valign="top" background="../images/titleL3_bg.gif"> <table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="../images/titleL3_point.gif" width="33" height="19"><span class="txt_title3">分类列表</span>
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
              	
             
              </tr>
              <tr><td height="5"></td></tr>
          </table></td></tr>
          
    </table></td>
  </tr>
</table>
</form>
</div>

<div id="topic-grid"></div>
<div id="treegrid"></div>
</body>
</html>



