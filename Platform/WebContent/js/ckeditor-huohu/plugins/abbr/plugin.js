/**
 * Basic sample plugin inserting abbreviation elements into CKEditor editing area.
 *
 * Created out of the CKEditor Plugin SDK:
 * http://docs.ckeditor.com/#!/guide/plugin_sdk_sample_1
 */

// Register the plugin within the editor.
CKEDITOR.plugins.add( 'abbr', {

	// Register the icons.
	icons: 'abbr',

	// The plugin initialization logic goes inside this method.
	init: function( editor ) {

		// Define an editor command that opens our dialog.
		editor.addCommand( 'abbr', //new CKEDITOR.dialogCommand( 'abbrDialog' ) );

		new CKEDITOR.command( editor, {
    	exec: function( editor ) {
        	
        	
        	        if(gwin){gwin.close();}
		        		gwin = Ext.create('Ext.Window', {
			        
				        title: '图库',
				        maximizable: true,
				        width: 800,
				        height: 400,
				        plain: true,
				        layout: 'fit',
				        
				        items: [{
				            border: false,
				            html:'<iframe  width="100%" height="100%"  src="imgstore!select.action?url=ck" frameborder="0" ></iframe>'
			
				        }
				        ]
				        
				  		});
				  		gwin.show();
		        	
    		}
		} ));

		// Create a toolbar button that executes the above command.
		editor.ui.addButton( 'Abbr', {

			// The text part of the button (if available) and tooptip.
			label: '选择图库',

			// The command to execute on click.
			command: 'abbr',

			// The button placement in the toolbar (toolbar group name).
			toolbar: 'insert'
		});

		// Register our dialog file. this.path is the plugin folder path.
		CKEDITOR.dialog.add( 'abbrDialog', this.path + 'dialogs/abbr.js' );
	}
});

