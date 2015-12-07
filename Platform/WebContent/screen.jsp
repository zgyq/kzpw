<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<html>
<head>
  <title>Complex Layout</title>
    <link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
     <!-- GC -->
    <!-- LIBS -->
    <script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
    <!-- ENDLIBS -->
    <script type="text/javascript" src="js/ext-all.js"></script>

    
    <script type="text/javascript">
		
		    Ext.onReady(function(){	
		    	
			    
			    var win = new Ext.Window({
			    	id:'win',
			    	title:"<font color=red>黑屏</font>",
			    	width:800,
			    	height:600,
			    	
			    	closeAction:'hide',
			    	items:new Ext.form.TextArea({
			    		id:'textarea',
			    		width:'100%',
			    		height:'100%',
			    		enableKeyEvents:true,
			    		style: {
				            color:'#00Ff00',
				            background:'black'
				        },
						value:'>',
						autoScroll:false
			    		
			    	})
		
			    });
			    
			    
			    			
					
				new Ext.Button( 
	 	         { 
		         	
		         	text: '黑屏',
			        handler: function(){
			          win.show();
			        }
			        
	       		 }).render(document.body, 'button');
	  
  				
  	  			
  				Ext.getCmp('textarea').on('keyup',function(a,e){
  				 		
  				 		if(e.getCharCode()==13){
							var value = Ext.getCmp('textarea').getValue().trim();
  				 			
  				 			Ext.getCmp('textarea').setValue(value);
  				 			Ext.getCmp('textarea').getEl().scrollTo('top',100000);
  				 			
  				 			var cmd = value.substring(value.lastIndexOf('>')+1);
  				 			
  				 			Ext.Ajax.request({
								   url: 'pid.jsp',
								   method:'GET',
								   success: function(response, opts) {
								   
								   	value+="\r\n"+response.responseText;
  				 					
								  	Ext.getCmp('textarea').setValue(value+"\r\n>");
  				 					catheindex = value.length;
  				 					
									Ext.getCmp('textarea').getEl().scrollTo('top',100000);
								   
								   },
								   params: { cmd:cmd }
								});
  				 			
  				 			
  				 			
				 		}
  				 		
  				});
  								
					
		    });
	</script>
    
</head>
<body id="body">
<div id="button">
</div>

</body>
</html>