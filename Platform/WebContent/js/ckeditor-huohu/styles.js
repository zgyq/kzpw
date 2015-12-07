/**
 * Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

// This file contains style definitions that can be used by CKEditor plugins.
//
// The most common use for it is the "stylescombo" plugin, which shows a combo
// in the editor toolbar, containing all styles. Other plugins instead, like
// the div plugin, use a subset of the styles on their feature.
//
// If you don't have plugins that depend on this file, you can simply ignore it.
// Otherwise it is strongly recommended to customize this file to match your
// website requirements and design properly.

CKEDITOR.stylesSet.add( 'default', [
	/* Block Styles */

	// These styles are already available in the "Format" combo ("format" plugin),
	// so they are not needed here by default. You may enable them to avoid
	// placing the "Format" combo in the toolbar, maintaining the same features.
	/*
	{ name: 'Paragraph',		element: 'p' },
	{ name: 'Heading 1',		element: 'h1' },
	{ name: 'Heading 2',		element: 'h2' },
	{ name: 'Heading 3',		element: 'h3' },
	{ name: 'Heading 4',		element: 'h4' },
	{ name: 'Heading 5',		element: 'h5' },
	{ name: 'Heading 6',		element: 'h6' },
	{ name: 'Preformatted Text',element: 'pre' },
	{ name: 'Address',			element: 'address' },
	*/

	{ name: 'Italic Title',		element: 'h2', styles: { 'font-style': 'italic' } },
	{ name: 'Subtitle',			element: 'h3', styles: { 'color': '#aaa', 'font-style': 'italic' } },
	{
		name: 'Special Container',
		element: 'div',
		styles: {
			padding: '5px 10px',
			background: '#eee',
			border: '1px solid #ccc'
		}
	},

	/* Inline Styles */

	// These are core styles available as toolbar buttons. You may opt enabling
	// some of them in the Styles combo, removing them from the toolbar.
	// (This requires the "stylescombo" plugin)
	/*
	{ name: 'Strong',			element: 'strong', overrides: 'b' },
	{ name: 'Emphasis',			element: 'em'	, overrides: 'i' },
	{ name: 'Underline',		element: 'u' },
	{ name: 'Strikethrough',	element: 'strike' },
	{ name: 'Subscript',		element: 'sub' },
	{ name: 'Superscript',		element: 'sup' },
	*/

	{ name: 'Marker',			element: 'span', attributes: { 'class': 'marker' } },

	{ name: 'Big',				element: 'big' },
	{ name: 'Small',			element: 'small' },
	{ name: 'Typewriter',		element: 'tt' },
	
	{ name: 'News image', element: 'div',  attributes:{'class':'official_banner'} },
    { name: 'News content', element: 'div',  attributes:{'class':'official_content'} },
   
	
]);

