<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="ww" uri="/struts-tags" %>
<%
/**
 * 版权所有，thunder
 * Author: thunder
 * copyright: 2011
 */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><ww:if test="catalog.id>0">编辑</ww:if><ww:else>新增</ww:else>分类</title>

		<link rel="stylesheet" type="text/css" href="../js/resources/css/ext-all.css" />
		 <script type="text/javascript" src="../js/adapter/ext/ext-base.js"></script>
    	 <script type="text/javascript" src="../js/ext-all.js"></script>
    	 
		<link href="../css/default.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="../css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
		<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
		<script src="../js/validate/jquery-1.4.min.js" type="text/javascript"></script>
		<script src="../js/validate/jquery.validationEngine-cn.js" type="text/javascript"></script>
		<script src="../js/validate/jquery.validationEngine.js" type="text/javascript"></script>
	
		
		<script>	
		$(document).ready(function() {
			
			$("#form1").validationEngine()
		
		});
	</script>	

<script>		


	Ext.require(['*']);

 	Ext.onReady(function() {
	 
	 
	 Ext.define('liststore', {
        extend: 'Ext.data.Model',
        fields: [
 	
'id','name','text','parentname','parentid','description','price','createtime','createuser','modifytime','modifyuser','parentidstr'

           
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

	     
   
    var tree= Ext.create('Ext.tree.Panel', {
					   // title: 'Simple Tree',
					   /*
					   viewConfig: {
           				 	plugins: {
         	      				 ptype: 'treeviewdragdrop'
          				 	 }
        				},
        				*/
					    width: 200,
					    id:'htree',
					    //height: 150,
					    store: store,
					    rootVisible: true
					    //renderTo: 'tree'
					});
   
    var comboxWithPanel = new Ext.form.ComboBox({

        store:new Ext.data.SimpleStore({fields:[],data:[[]]}),

        editable:false,

        queryMode : 'local',

        triggerAction:'all',

        maxHeight: 200,

        selectedClass:'',
        

      // onSelect : Ext.emptyFn,
 
            
	    listConfig:{
	    	getInnerTpl: function(displayField) {
	        return '<div id="treediv"></div>' ;
	    	}
	    },
   	   
	    onExpand:function(){ 
         	tree.render('treediv');
         	tree.expandAll();  
			
    	}
    });
	
	tree.on('itemclick',function(a,b,c,d,e){
		 comboxWithPanel.setRawValue(b.get('text'));
		 Ext.get('parentid').set({value:b.get('id')});
       
	});

    comboxWithPanel.render('comboxWithTree');

	comboxWithPanel.setRawValue(Ext.htmlDecode('<ww:property value="getCatalogName(catalog.parentid)"/>'));
	
	Ext.get('parentid').set({value:'<ww:property value="catalog.parentid"/>'});


});

		
	</script>

</head>


<body>

<form action="catalog!<ww:if test="catalog.id>0">edit.action?id=<ww:property value="id"/>&<ww:property value="url"/></ww:if><ww:else>add.action?<ww:property value="url"/></ww:else>" name="form1" id="form1" method="POST" >

<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td valign="top" background="../images/titleL3_bg.gif"> <table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="../images/titleL3_point.gif" width="33" height="19"><span class="txt_title3">
        
       <ww:if test="catalog.id>0">编辑</ww:if><ww:else>新增</ww:else>分类</span>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td valign="bottom">
					<table border="0" cellpadding="0" cellspacing="0">
                    <tr>    <td width=42 nowrap>&nbsp;</td>
							<td  nowrap>
                               &nbsp;
							</td>
                      </tr>
                  </table>
                
				</td>
              </tr>
          </table></td></tr>
    </table></td>
  </tr>
</table>

<table border="0" width="100%"  align="center">


 
	

 
	<tr class="tr2"><td align="right">名称：</td><td><input type="text"    id="name" class="validate[required]" name="name" value='<ww:property value="catalog.name"/>' /> </td></tr>
	
				 
 
	
	<tr class="tr1"><td align="right">父分类：</td><td>
	
	<div id='comboxWithTree'></div>
	<input type="hidden"    id="parentid"  name="parentid" value='<ww:property value="catalog.parentid"/>' /> </td></tr>
	
				
				 

			
   
	 <tr class="tr2"><td align="right">介绍：</td><td><textarea name="description"  id="description" class="validate[required]"  cols="50" rows="5"><ww:property value="catalog.description"/></textarea> </td>  </tr>
	
			
			
			 
 	
				 
      
   	    
      



<tr class="tr0" ><td height="30" colspan="2" align="center"><input class="a" type="submit" value=" 提 交 "/> <input type="button" onclick="reset();"  name="Submit2" value=" 重 置 " /> </td></tr> 

</table> 



</form>
</body>
</html>



