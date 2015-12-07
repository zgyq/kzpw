/*!
 * Ext.ux.tree.EditTreeGrid v1.5
 */
Ext.ns('Ext.ux.tree');

var operate=0;

/**
 * @class Ext.ux.tree.TreeGridSorter
 * @extends Ext.tree.TreeSorter
 * Provides sorting of nodes in a {@link Ext.ux.tree.TreeGrid}.  The TreeGridSorter automatically monitors events on the
 * associated TreeGrid that might affect the tree's sort order (beforechildrenrendered, append, insert and textchange).
 * Example usage:<br />
 * <pre><code>
 new Ext.ux.tree.TreeGridSorter(myTreeGrid, {
     folderSort: true,
     dir: "desc",
     sortType: function(node) {
         // sort by a custom, typed attribute:
         return parseInt(node.id, 10);
     }
 });
 </code></pre>
 * @constructor
 * @param {TreeGrid} tree
 * @param {Object} config
 */
Ext.ux.tree.TreeGridSorter = Ext.extend(Ext.tree.TreeSorter, {
    /**
     * @cfg {Array} sortClasses The CSS classes applied to a header when it is sorted. (defaults to <tt>['sort-asc', 'sort-desc']</tt>)
     */
    sortClasses : ['sort-asc', 'sort-desc'],
    /**
     * @cfg {String} sortAscText The text displayed in the 'Sort Ascending' menu item (defaults to <tt>'Sort Ascending'</tt>)
     */
    sortAscText : 'Sort Ascending',
    /**
     * @cfg {String} sortDescText The text displayed in the 'Sort Descending' menu item (defaults to <tt>'Sort Descending'</tt>)
     */
    sortDescText : 'Sort Descending',

    constructor : function(tree, config) {
        if(!Ext.isObject(config)) {
            config = {
                property: tree.columns[0].dataIndex || 'text',
                folderSort: true
            }
        }

        Ext.ux.tree.TreeGridSorter.superclass.constructor.apply(this, arguments);

        this.tree = tree;
        tree.on('headerclick', this.onHeaderClick, this);
        tree.ddAppendOnly = true;

        me = this;
        this.defaultSortFn = function(n1, n2){

            var dsc = me.dir && me.dir.toLowerCase() == 'desc';
            var p = me.property || 'text';
            var sortType = me.sortType;
            var fs = me.folderSort;
            var cs = me.caseSensitive === true;
            var leafAttr = me.leafAttr || 'leaf';

            if(fs){
                if(n1.attributes[leafAttr] && !n2.attributes[leafAttr]){
                    return 1;
                }
                if(!n1.attributes[leafAttr] && n2.attributes[leafAttr]){
                    return -1;
                }
            }
            var v1 = sortType ? sortType(n1) : (cs ? n1.attributes[p] : n1.attributes[p].toUpperCase());
            var v2 = sortType ? sortType(n2) : (cs ? n2.attributes[p] : n2.attributes[p].toUpperCase());
            if(v1 < v2){
                return dsc ? +1 : -1;
            }else if(v1 > v2){
                return dsc ? -1 : +1;
            }else{
                return 0;
            }
        };

        tree.on('afterrender', this.onAfterTreeRender, this, {single: true});
        tree.on('headermenuclick', this.onHeaderMenuClick, this);
    },

    onAfterTreeRender : function() {
        if(this.tree.hmenu){
            this.tree.hmenu.insert(0,
                {itemId:'asc', text: this.sortAscText, cls: 'xg-hmenu-sort-asc'},
                {itemId:'desc', text: this.sortDescText, cls: 'xg-hmenu-sort-desc'}
            );
        }
        this.updateSortIcon(0, 'asc');
    },

    onHeaderMenuClick : function(c, id, index) {
        if(id === 'asc' || id === 'desc') {
            this.onHeaderClick(c, null, index);
            return false;
        }
    },

    onHeaderClick : function(c, el, i) {
        if(c && !this.tree.headersDisabled){
            var me = this;

            me.property = c.dataIndex;
            me.dir = c.dir = (c.dir === 'desc' ? 'asc' : 'desc');
            me.sortType = c.sortType;
            me.caseSensitive === Ext.isBoolean(c.caseSensitive) ? c.caseSensitive : this.caseSensitive;
            me.sortFn = c.sortFn || this.defaultSortFn;

            this.tree.root.cascade(function(n) {
                if(!n.isLeaf()) {
                    me.updateSort(me.tree, n);
                }
            });

            this.updateSortIcon(i, c.dir);
        }
    },

    // private
    updateSortIcon : function(col, dir){
        var sc = this.sortClasses;
        var hds = this.tree.innerHd.select('td').removeClass(sc);
        hds.item(col).addClass(sc[dir == 'desc' ? 1 : 0]);
    }
});
/**
 * @class Ext.tree.ColumnResizer
 * @extends Ext.util.Observable
 */
Ext.tree.ColumnResizer = Ext.extend(Ext.util.Observable, {
    /**
     * @cfg {Number} minWidth The minimum width the column can be dragged to.
     * Defaults to <tt>14</tt>.
     */
    minWidth: 14,

    constructor: function(config){
        Ext.apply(this, config);
        Ext.tree.ColumnResizer.superclass.constructor.call(this);
    },

    init : function(tree){
        this.tree = tree;
        tree.on('render', this.initEvents, this);
    },

    initEvents : function(tree){
        tree.mon(tree.innerHd, 'mousemove', this.handleHdMove, this);
        this.tracker = new Ext.dd.DragTracker({
            onBeforeStart: this.onBeforeStart.createDelegate(this),
            onStart: this.onStart.createDelegate(this),
            onDrag: this.onDrag.createDelegate(this),
            onEnd: this.onEnd.createDelegate(this),
            tolerance: 3,
            autoStart: 300
        });
        this.tracker.initEl(tree.innerHd);
        tree.on('beforedestroy', this.tracker.destroy, this.tracker);
    },

    handleHdMove : function(e, t){
        var hw = 5,
            x = e.getPageX(),
            hd = e.getTarget('.x-treegrid-hd', 3, true);
        
        if(hd){                                 
            var r = hd.getRegion(),
                ss = hd.dom.style,
                pn = hd.dom.parentNode;
            
            if(x - r.left <= hw && hd.dom !== pn.firstChild) {
                var ps = hd.dom.previousSibling;
                while(ps && Ext.fly(ps).hasClass('x-treegrid-hd-hidden')) {
                    ps = ps.previousSibling;
                }
                if(ps) {                    
                    this.activeHd = Ext.get(ps);
    				ss.cursor = Ext.isWebKit ? 'e-resize' : 'col-resize';
                }
            } else if(r.right - x <= hw) {
                var ns = hd.dom;
                while(ns && Ext.fly(ns).hasClass('x-treegrid-hd-hidden')) {
                    ns = ns.previousSibling;
                }
                if(ns) {
                    this.activeHd = Ext.get(ns);
    				ss.cursor = Ext.isWebKit ? 'w-resize' : 'col-resize';                    
                }
            } else{
                delete this.activeHd;
                ss.cursor = '';
            }
        }
    },

    onBeforeStart : function(e){
        this.dragHd = this.activeHd;
        return !!this.dragHd;
    },

    onStart : function(e){
        this.tree.headersDisabled = true;
        this.proxy = this.tree.body.createChild({cls:'x-treegrid-resizer'});
        this.proxy.setHeight(this.tree.body.getHeight());

        var x = this.tracker.getXY()[0];

        this.hdX = this.dragHd.getX();
        this.hdIndex = this.tree.findHeaderIndex(this.dragHd);

        this.proxy.setX(this.hdX);
        this.proxy.setWidth(x-this.hdX);

        this.maxWidth = this.tree.outerCt.getWidth() - this.tree.innerBody.translatePoints(this.hdX).left;
    },

    onDrag : function(e){
        var cursorX = this.tracker.getXY()[0];
        this.proxy.setWidth((cursorX-this.hdX).constrain(this.minWidth, this.maxWidth));
    },

    onEnd : function(e){
        var nw = this.proxy.getWidth(),
            tree = this.tree;
        
        this.proxy.remove();
        delete this.dragHd;
        
        tree.columns[this.hdIndex].width = nw;
        tree.updateColumnWidths();
        
        setTimeout(function(){
            tree.headersDisabled = false;
        }, 100);
    }
});
/**
 * @class Ext.ux.tree.TreeGridNodeUI
 * @extends Ext.tree.TreeNodeUI
 */
Ext.ux.tree.TreeGridNodeUI = Ext.extend(Ext.tree.TreeNodeUI, {
    isTreeGridNodeUI: true,

    renderElements : function(n, a, targetNode, bulkRender){
        var t = n.getOwnerTree(),
            cols = t.columns,
            c = cols[0],
            i, buf, len;

        this.indentMarkup = n.parentNode ? n.parentNode.ui.getChildIndent() : '';

        buf = [
             '<tbody class="x-tree-node" align="center">',
                '<tr ext:tree-node-id="', n.id ,'" class="x-tree-node-el x-tree-node-leaf ', a.cls, '">',
                    '<td class="x-treegrid-col">',
                        '<span class="x-tree-node-indent">', this.indentMarkup, "</span>",
                        '<img src="', this.emptyIcon, '" class="x-tree-ec-icon x-tree-elbow">',
                        '<img src="', a.icon || this.emptyIcon, '" class="x-tree-node-icon', (a.icon ? " x-tree-node-inline-icon" : ""), (a.iconCls ? " "+a.iconCls : ""), '" unselectable="on">',
                        '<a hidefocus="on" class="x-tree-node-anchor" href="', a.href ? a.href : '#', '" tabIndex="1" ',
                            a.hrefTarget ? ' target="'+a.hrefTarget+'"' : '', '>',
                        '<span unselectable="on">', (c.tpl ? c.tpl.apply(a) : a[c.dataIndex] || c.text), '</span></a>',
                    '</td>'
        ];

        for(i = 1, len = cols.length; i < len; i++){
            c = cols[i];
            buf.push(
                    '<td class="x-treegrid-col ', (c.cls ? c.cls : ''), '">',
                        '<div unselectable="on" class="x-treegrid-text"', (c.align ? ' style="text-align: ' + c.align + ';"' : ''), '>',
                            (c.tpl ? c.tpl.apply(a) : a[c.dataIndex]),
                        '</div>',
                    '</td>'
            );
        }

        buf.push(
            '</tr><tr class="x-tree-node-ct"><td colspan="', cols.length, '">',
            '<table class="x-treegrid-node-ct-table" cellpadding="0" cellspacing="0" style="table-layout: fixed; display: none; width: ', t.innerCt.getWidth() ,'px;"><colgroup>'
        );
        for(i = 0, len = cols.length; i<len; i++) {
            buf.push('<col style="width: ', (cols[i].hidden ? 0 : cols[i].width) ,'px;" />');
        }
        buf.push('</colgroup></table></td></tr></tbody>');

        if(bulkRender !== true && n.nextSibling && n.nextSibling.ui.getEl()){
            this.wrap = Ext.DomHelper.insertHtml("beforeBegin", n.nextSibling.ui.getEl(), buf.join(''));
        }else{
            this.wrap = Ext.DomHelper.insertHtml("beforeEnd", targetNode, buf.join(''));
        }

        this.elNode = this.wrap.childNodes[0];
        this.ctNode = this.wrap.childNodes[1].firstChild.firstChild;
        var cs = this.elNode.firstChild.childNodes;
        this.indentNode = cs[0];
        this.ecNode = cs[1];
        this.iconNode = cs[2];
        this.anchor = cs[3];
        this.textNode = cs[3].firstChild;
    },

    // private
    animExpand : function(cb){
        this.ctNode.style.display = "";
        Ext.ux.tree.TreeGridNodeUI.superclass.animExpand.call(this, cb);
    }
});

Ext.ux.tree.TreeGridRootNodeUI = Ext.extend(Ext.tree.TreeNodeUI, {
    isTreeGridNodeUI: true,

    // private
    render : function(){
        if(!this.rendered){
            this.wrap = this.ctNode = this.node.ownerTree.innerCt.dom;
            this.node.expanded = true;
        }

        if(Ext.isWebKit) {
            // weird table-layout: fixed issue in webkit
            var ct = this.ctNode;
            ct.style.tableLayout = null;
            (function() {
                ct.style.tableLayout = 'fixed';
            }).defer(1);
        }
    },

    destroy : function(){
        if(this.elNode){
            Ext.dd.Registry.unregister(this.elNode.id);
        }
        delete this.node;
    },

    collapse : Ext.emptyFn,
    expand : Ext.emptyFn
});
/**
 * @class Ext.ux.tree.TreeGridLoader
 * @extends Ext.tree.TreeLoader
 */
Ext.ux.tree.TreeGridLoader = Ext.extend(Ext.tree.TreeLoader, {
    createNode : function(attr) {
        if (!attr.uiProvider) {
            attr.uiProvider = Ext.ux.tree.TreeGridNodeUI;
        }
        return Ext.tree.TreeLoader.prototype.createNode.call(this, attr);
    }
});
(function() {
    Ext.override(Ext.list.Column, {
        init : function() {    
            var types = Ext.data.Types,
                st = this.sortType;
                    
            if(this.type){
                if(Ext.isString(this.type)){
                    this.type = Ext.data.Types[this.type.toUpperCase()] || types.AUTO;
                }
            }else{
                this.type = types.AUTO;
            }

            // named sortTypes are supported, here we look them up
            if(Ext.isString(st)){
                this.sortType = Ext.data.SortTypes[st];
            }else if(Ext.isEmpty(st)){
                this.sortType = this.type.sortType;
            }
        }
    });

    Ext.tree.Column = Ext.extend(Ext.list.Column, {});
    Ext.tree.NumberColumn = Ext.extend(Ext.list.NumberColumn, {});
    Ext.tree.DateColumn = Ext.extend(Ext.list.DateColumn, {});
    Ext.tree.BooleanColumn = Ext.extend(Ext.list.BooleanColumn, {});

    Ext.reg('tgcolumn', Ext.tree.Column);
    Ext.reg('tgnumbercolumn', Ext.tree.NumberColumn);
    Ext.reg('tgdatecolumn', Ext.tree.DateColumn);
    Ext.reg('tgbooleancolumn', Ext.tree.BooleanColumn);
})();
/**
 * @class Ext.ux.tree.TreeGrid
 * @extends Ext.tree.TreePanel
 * 
 * @xtype treegrid
 */
Ext.ux.tree.TreeGrid = Ext.extend(Ext.tree.TreePanel, {
    rootVisible : false,
    useArrows : true,
    lines : false,
    borderWidth : Ext.isBorderBox ? 0 : 2, // the combined left/right border for each cell
    cls : 'x-treegrid',

    columnResize : true,
    enableSort : true,
    reserveScrollOffset : true,
    enableHdMenu : true,
    
    columnsText : 'Columns',

    initComponent : function() {
    
        if(!this.root) {
            this.root = new Ext.tree.AsyncTreeNode({text: 'Root'});
        }
        
        // initialize the loader
        var l = this.loader;
        if(!l){
            l = new Ext.ux.tree.TreeGridLoader({
                dataUrl: this.dataUrl,
                requestMethod: this.requestMethod,
                store: this.store
            });
        }else if(Ext.isObject(l) && !l.load){
            l = new Ext.ux.tree.TreeGridLoader(l);
        }
        else if(l) {
            l.createNode = function(attr) {
                if (!attr.uiProvider) {
                    attr.uiProvider = Ext.ux.tree.TreeGridNodeUI;
                }
                return Ext.tree.TreeLoader.prototype.createNode.call(this, attr);
            }
        }
        this.loader = l;
                            
        Ext.ux.tree.TreeGrid.superclass.initComponent.call(this);                    
        
        this.initColumns();
        
        if(this.enableSort) {
            this.treeGridSorter = new Ext.ux.tree.TreeGridSorter(this, this.enableSort);
        }
        
        if(this.columnResize){
            this.colResizer = new Ext.tree.ColumnResizer(this.columnResize);
            this.colResizer.init(this);
        }
        
        var c = this.columns;
        if(!this.internalTpl){                                
            this.internalTpl = new Ext.XTemplate(
                '<div class="x-grid3-header">',
                    '<div class="x-treegrid-header-inner">',
                        '<div class="x-grid3-header-offset">',
                            '<table cellspacing="0" cellpadding="0" border="0"><colgroup><tpl for="columns"><col /></tpl></colgroup>',
                            '<thead><tr class="x-grid3-hd-row">',
                            '<tpl for="columns">',
                            '<td class="x-grid3-hd x-grid3-cell x-treegrid-hd" style="text-align: {align};" id="', this.id, '-xlhd-{#}">',
                                '<div class="x-grid3-hd-inner x-treegrid-hd-inner" unselectable="on">',
                                     this.enableHdMenu ? '<a class="x-grid3-hd-btn" href="#"></a>' : '',
                                     '{header}<img class="x-grid3-sort-icon" src="', Ext.BLANK_IMAGE_URL, '" />',
                                 '</div>',
                            '</td></tpl>',
                            '</tr></thead>',
                        '</div></table>',
                    '</div></div>',
                '</div>',
                '<div class="x-treegrid-root-node">',
                    '<table class="x-treegrid-root-table" cellpadding="0" cellspacing="0" style="table-layout: fixed;"></table>',
                '</div>'
            );
           
        }
        
        if(!this.colgroupTpl) {
            this.colgroupTpl = new Ext.XTemplate(
                '<colgroup><tpl for="columns"><col style="width: {width}px"/></tpl></colgroup>'
            );
            
        }
        
    },

    initColumns : function() {
        var cs = this.columns,
            len = cs.length, 
            columns = [],
            i, c;

        for(i = 0; i < len; i++){
            c = cs[i];
            if(!c.isColumn) {
                c.xtype = c.xtype ? (/^tg/.test(c.xtype) ? c.xtype : 'tg' + c.xtype) : 'tgcolumn';
                c = Ext.create(c);
            }
            c.init(this);
            columns.push(c);
            
            if(this.enableSort !== false && c.sortable !== false) {
                c.sortable = true;
                this.enableSort = true;
            }
        }

        this.columns = columns;
    },

    onRender : function(){
        Ext.tree.TreePanel.superclass.onRender.apply(this, arguments);

        this.el.addClass('x-treegrid');
        
        this.outerCt = this.body.createChild({
            cls:'x-tree-root-ct x-treegrid-ct ' + (this.useArrows ? 'x-tree-arrows' : this.lines ? 'x-tree-lines' : 'x-tree-no-lines')
        });
        
        this.internalTpl.overwrite(this.outerCt, {columns: this.columns});
        
        this.mainHd = Ext.get(this.outerCt.dom.firstChild);
        this.innerHd = Ext.get(this.mainHd.dom.firstChild);
        this.innerBody = Ext.get(this.outerCt.dom.lastChild);
        this.innerCt = Ext.get(this.innerBody.dom.firstChild);
        
        this.colgroupTpl.insertFirst(this.innerCt, {columns: this.columns});
        
        if(this.hideHeaders){
            this.header.dom.style.display = 'none';
        }
        else if(this.enableHdMenu !== false){
            this.hmenu = new Ext.menu.Menu({id: this.id + '-hctx'});
            if(this.enableColumnHide !== false){
                this.colMenu = new Ext.menu.Menu({id: this.id + '-hcols-menu'});
                this.colMenu.on({
                    scope: this,
                    beforeshow: this.beforeColMenuShow,
                    itemclick: this.handleHdMenuClick
                });
                this.hmenu.add({
                    itemId:'columns',
                    hideOnClick: false,
                    text: this.columnsText,
                    menu: this.colMenu,
                    iconCls: 'x-cols-icon'
                });
            }
            this.hmenu.on('itemclick', this.handleHdMenuClick, this);
        }
    },

    setRootNode : function(node){
        node.attributes.uiProvider = Ext.ux.tree.TreeGridRootNodeUI;        
        node = Ext.ux.tree.TreeGrid.superclass.setRootNode.call(this, node);
        if(this.innerCt) {
            this.colgroupTpl.insertFirst(this.innerCt, {columns: this.columns});
        }
        return node;
    },
    
    clearInnerCt : function(){
        if(Ext.isIE){
            var dom = this.innerCt.dom;
            while(dom.firstChild){
                dom.removeChild(dom.firstChild);
            }
        }else{
            Ext.ux.tree.TreeGrid.superclass.clearInnerCt.call(this);
        }
    },
    
    initEvents : function() {
        Ext.ux.tree.TreeGrid.superclass.initEvents.apply(this, arguments);

        this.mon(this.innerBody, 'scroll', this.syncScroll, this);
        this.mon(this.innerHd, 'click', this.handleHdDown, this);
        this.mon(this.mainHd, {
            scope: this,
            mouseover: this.handleHdOver,
            mouseout: this.handleHdOut
        });
    },
    
    onResize : function(w, h) {
        Ext.ux.tree.TreeGrid.superclass.onResize.apply(this, arguments);
        
        var bd = this.innerBody.dom;
        var hd = this.innerHd.dom;

        if(!bd){
            return;
        }

        if(Ext.isNumber(h)){
            bd.style.height = this.body.getHeight(true) - hd.offsetHeight + 'px';
        }

        if(Ext.isNumber(w)){                        
            var sw = Ext.num(this.scrollOffset, Ext.getScrollBarWidth());
            if(this.reserveScrollOffset || ((bd.offsetWidth - bd.clientWidth) > 10)){
                this.setScrollOffset(sw);
            }else{
                var me = this;
                setTimeout(function(){
                    me.setScrollOffset(bd.offsetWidth - bd.clientWidth > 10 ? sw : 0);
                }, 10);
            }
        }
    },

    updateColumnWidths : function() {
        var cols = this.columns,
            colCount = cols.length,
            groups = this.outerCt.query('colgroup'),
            groupCount = groups.length,
            c, g, i, j;

        for(i = 0; i<colCount; i++) {
            c = cols[i];
            for(j = 0; j<groupCount; j++) {
                g = groups[j];
                g.childNodes[i].style.width = (c.hidden ? 0 : c.width) + 'px';
            }
        }
        
        for(i = 0, groups = this.innerHd.query('td'), len = groups.length; i<len; i++) {
            c = Ext.fly(groups[i]);
            if(cols[i] && cols[i].hidden) {
                c.addClass('x-treegrid-hd-hidden');
            }
            else {
                c.removeClass('x-treegrid-hd-hidden');
            }
        }

        var tcw = this.getTotalColumnWidth();                        
        Ext.fly(this.innerHd.dom.firstChild).setWidth(tcw + (this.scrollOffset || 0));
        this.outerCt.select('table').setWidth(tcw);
        this.syncHeaderScroll();    
    },
                    
    getVisibleColumns : function() {
        var columns = [],
            cs = this.columns,
            len = cs.length,
            i;
            
        for(i = 0; i<len; i++) {
            if(!cs[i].hidden) {
                columns.push(cs[i]);
            }
        }        
        return columns;
    },

    getTotalColumnWidth : function() {
        var total = 0;
        for(var i = 0, cs = this.getVisibleColumns(), len = cs.length; i<len; i++) {
            total += cs[i].width;
        }
        return total;
    },

    setScrollOffset : function(scrollOffset) {
        this.scrollOffset = scrollOffset;                        
        this.updateColumnWidths();
    },

    // private
    handleHdDown : function(e, t){
        var hd = e.getTarget('.x-treegrid-hd');

        if(hd && Ext.fly(t).hasClass('x-grid3-hd-btn')){
            var ms = this.hmenu.items,
                cs = this.columns,
                index = this.findHeaderIndex(hd),
                c = cs[index],
                sort = c.sortable;
                
            e.stopEvent();
            Ext.fly(hd).addClass('x-grid3-hd-menu-open');
            this.hdCtxIndex = index;
            
            this.fireEvent('headerbuttonclick', ms, c, hd, index);
            
            this.hmenu.on('hide', function(){
                Ext.fly(hd).removeClass('x-grid3-hd-menu-open');
            }, this, {single:true});
            
            this.hmenu.show(t, 'tl-bl?');
        }
        else if(hd) {
            var index = this.findHeaderIndex(hd);
            this.fireEvent('headerclick', this.columns[index], hd, index);
        }
    },

    // private
    handleHdOver : function(e, t){                    
        var hd = e.getTarget('.x-treegrid-hd');                        
        if(hd && !this.headersDisabled){
            index = this.findHeaderIndex(hd);
            this.activeHdRef = t;
            this.activeHdIndex = index;
            var el = Ext.get(hd);
            this.activeHdRegion = el.getRegion();
            el.addClass('x-grid3-hd-over');
            this.activeHdBtn = el.child('.x-grid3-hd-btn');
            if(this.activeHdBtn){
                this.activeHdBtn.dom.style.height = (hd.firstChild.offsetHeight-1)+'px';
            }
        }
    },
    
    // private
    handleHdOut : function(e, t){
        var hd = e.getTarget('.x-treegrid-hd');
        if(hd && (!Ext.isIE || !e.within(hd, true))){
            this.activeHdRef = null;
            Ext.fly(hd).removeClass('x-grid3-hd-over');
            hd.style.cursor = '';
        }
    },
                    
    findHeaderIndex : function(hd){
        hd = hd.dom || hd;
        var cs = hd.parentNode.childNodes;
        for(var i = 0, c; c = cs[i]; i++){
            if(c == hd){
                return i;
            }
        }
        return -1;
    },
    
    // private
    beforeColMenuShow : function(){
        var cols = this.columns,  
            colCount = cols.length,
            i, c;                        
        this.colMenu.removeAll();                    
        for(i = 1; i < colCount; i++){
            c = cols[i];
            if(c.hideable !== false){
                this.colMenu.add(new Ext.menu.CheckItem({
                    itemId: 'col-' + i,
                    text: c.header,
                    checked: !c.hidden,
                    hideOnClick:false,
                    disabled: c.hideable === false
                }));
            }
        }
    },
                    
    // private
    handleHdMenuClick : function(item){
        var index = this.hdCtxIndex,
            id = item.getItemId();
        
        if(this.fireEvent('headermenuclick', this.columns[index], id, index) !== false) {
            index = id.substr(4);
            if(index > 0 && this.columns[index]) {
                this.setColumnVisible(index, !item.checked);
            }     
        }
        
        return true;
    },
    
    setColumnVisible : function(index, visible) {
        this.columns[index].hidden = !visible;        
        this.updateColumnWidths();
    },

    /**
     * Scrolls the grid to the top
     */
    scrollToTop : function(){
        this.innerBody.dom.scrollTop = 0;
        this.innerBody.dom.scrollLeft = 0;
    },

    // private
    syncScroll : function(){
        this.syncHeaderScroll();
        var mb = this.innerBody.dom;
        this.fireEvent('bodyscroll', mb.scrollLeft, mb.scrollTop);
    },

    // private
    syncHeaderScroll : function(){
        var mb = this.innerBody.dom;
        this.innerHd.dom.scrollLeft = mb.scrollLeft;
        this.innerHd.dom.scrollLeft = mb.scrollLeft; // second time for IE (1/2 time first fails, other browsers ignore)
    },
    
    registerNode : function(n) {
        Ext.ux.tree.TreeGrid.superclass.registerNode.call(this, n);
        if(!n.uiProvider && !n.isRoot && !n.ui.isTreeGridNodeUI) {
            n.ui = new Ext.ux.tree.TreeGridNodeUI(n);
        }
    }
});

Ext.reg('treegrid', Ext.ux.tree.TreeGrid);
/**
 * @class Ext.ux.tree.TreeRowEditor
 * @extends Ext.Panel
 * Plugin (ptype = 'roweditor') that adds the ability to rapidly edit full rows in a grid.
 * A validation mode may be enabled which uses AnchorTips to notify the user of all
 * validation errors at once.
 *
 * @ptype ptreeroweditor
 */
Ext.ux.tree.TreeRowEditor = Ext.extend(Ext.Panel, {
    hidden: true,
    floating: true,
    shadow: false,
    layout: 'hbox',
    cls: 'x-small-editor',
    buttonAlign: 'center',
    baseCls: 'x-row-editor',
    elements: 'header,footer,body',
    frameWidth: 5,
    buttonPad: 3,
    monitorValid: true,
    focusDelay: 250,

    saveText: 'Save',
    cancelText: 'Cancel',

    adjustHeight: 35,
    adjustButtonHeight: 7,
    columnButton: true,

    defaults: {
        normalWidth: true
    },

    initComponent: function() {
        if (this.columnButton) {
            this.adjustHeight = this.adjustButtonHeight;
            this.buttonWidth = this.buttonWidth || 50;
        } else {
            this.buttonWidth = this.buttonWidth || this.minButtonWidth;
        }

        Ext.ux.tree.TreeRowEditor.superclass.initComponent.call(this);
        this.addEvents(
        /**
         * @event beforeedit
         * Fired before the row editor is activated.
         * If the listener returns <tt>false</tt> the editor will not be activated.
         * @param {Ext.tree.Node} 被编辑的树节点
         */
        'beforeedit',
        /**
         * @event canceledit
         * Fired when the editor is cancelled.
         * @param {Ext.tree.Node} 被编辑的树节点
         */
        'canceledit',
        /**
         * @event validateedit
         * Fired after a row is edited and passes validation.
         * If the listener returns <tt>false</tt> changes to the record will not be set.
         * @param {Ext.tree.Node} 被编辑的树节点，树节点属性为旧属性
         * @param {Object} changes Object with changes made to the record.
         */
        'validateedit',
        /**
         * @event afteredit
         * Fired after a row is edited and passes validation.  This event is fired
         * after the store's update event is fired with this edit.
         * @param {Ext.tree.Node} 被编辑的树节点，树节点属性为修改完之后的属性
         * @param {Object} changes Object with changes made to the record.
         */
        'afteredit');
    },

    init: function(tree) {
        this.tree = tree;
       
        this.ownerCt = tree;

        Ext.applyIf(tree, {
            editNode: this.editNode.createDelegate(this)
        });

        tree.on({
            scope: this,
            beforedestroy: this.beforeDestroy,
            destroy: this.destroy,
            bodyscroll: {
                buffer: 250,
                fn: this.positionButtons
            }
        });
    },

    beforeDestroy: function() {
        this.stopEditing(false);
        this.node = null;
        Ext.destroy(this.saveBtn, this.cancelBtn);
        if (this.btns) {
            Ext.destroy(this.btns);
        }
    },

    refreshFields: function() {
        this.initFields();
        this.verifyLayout();
    },

    isDirty: function() {
        var dirty;
        this.items.each(function(f) {
            if (String(this.values[f.id]) !== String(f.getValue())) {
                dirty = true;
                return false;
            }
        }, this);
        return dirty;
    },

    startEditing: function(node, doFocus) {
        if (this.fireEvent('beforeedit', node) !== false) {
            this.node = node;
           
            var id=node.id;
           // var opennext=this.preEditValue(node, 'opennext');
           // var check=this.preEditValue(node, 'checked');
            var enable=this.preEditValue(node, 'enable');
            
             if(enable!="启用"&&operate!=3&&operate!=4){
              Ext.MessageBox.alert("提示","当前加盟商未启用，无法对其进行操作！");
                return;
             }
             
           //  if(check!="审核通过"&&operate!=4){
            //     Ext.MessageBox.alert("提示","当前加盟商未通过审核，无法对其进行操作");
            //    return;
            // }
             //开下级
           if(operate==1){
              var agenttype=Ext.getDom("agenttype").value;
             var lrf="customeragent!toadd.action?agenttype="+agenttype+"&parentid="+id;
             canOpnenext(id,lrf);         
           }
           //员工信息
           if(operate==2){
            document.agentform.action="customeruser!toEmployeelist.action?agentid="+id;
	        document.agentform.submit();             
           }
           //编辑
           if(operate==3){
            document.agentform.action="customeragent!toeditgent.action?compnayid="+id;
		    document.agentform.submit();         
           }
           //删除
           if(operate==4){
           candelt(id);
         
           }
           if(operate==5){
             Ext.MessageBox.confirm("确认","是否确定充值？",function(btn){
             if(btn=='yes'){
             if(loginagent.id==id){
             id=0;
             }
           document.agentform.action="rebaterecord.action?rebaterecord.rebateagentid="+id;
		   document.agentform.submit();  
		   } 
             
             });
           }
           //留点设置
           if(operate==6){	//alert(id);
           
          	document.agentform.action="liudianinfo!toadd.action?lagentid="+id;
          // document.agentform.action="liudianinfo!getbussiness.action?lagentid="+id;
		   document.agentform.submit();   
           }
           //域名绑定
           if(operate==7){
           window.location.href="dnsmaintenance.action?agentid="+id;
           }
           
        } 
    },

    stopEditing: function(saveChanges) {
        this.editing = false;
        if (!this.isVisible()) {
            return;
        }
        if (saveChanges === false || !this.isValid()) {
            this.hide();
            this.fireEvent('canceledit', this.node);
            return;
        }
        var changes = {}, n = this.node, hasChange = false, cm = this.tree.columns, c, fields = this.items.items;
        for (var i = 0, len = cm.length; i < len; i++) {
            c = cm[i];
            if (!c.hidden && !c.buttons) {
                var dindex = c.dataIndex;
                var oldValue = n.attributes[dindex], value = this.postEditValue(fields[i].getValue(), oldValue, n, dindex);
                if (String(oldValue) !== String(value)) {
                    changes[dindex] = value;
                    hasChange = true;
                }
            }
        }
        if (hasChange && this.fireEvent('validateedit', n, changes) !== false) {
            Ext.apply(n.attributes, changes);
            Ext.iterate(changes, function(name, value) {
                var index = 0, c;
                for (var i = 0, len = cm.length; i < len; i++) {
                    c = cm[i];
                    if (c.dataIndex == name) {
                        index = i;
                        break;
                    }
                }
                if (index == 0) {
                    n.ui.textNode.innerHTML = c.tpl ? c.tpl.apply(n.attributes) : value;
                } else {
                    n.ui.elNode.childNodes[index].firstChild.innerHTML = c.tpl ? c.tpl.apply(n.attributes) : value;
                }
            });
            this.fireEvent('afteredit', n, changes);
        }
        this.hide();
    },

    verifyLayout: function(node, force) {
        if (this.el && (this.isVisible() || force === true)) {
            var elNode = node.ui.elNode;
            this.setSize(Ext.fly(elNode).getWidth(), Ext.isIE ? Ext.fly(elNode).getHeight() + 9 : undefined);
            var cm = this.tree.columns, fields = this.items.items, f;
            for (var i = 0, len = cm.length; i < len; i++) {
                f = fields[i];
                if (f && this.isField(f)) {
                    var adjust = 0;
                    if (i === (len - 1)) {
                        adjust += 3; // outer padding
                    } else {
                        adjust += 1;
                    }
                    f.setWidth(cm[i].width - adjust);
                }
            }
            this.doLayout();
            this.positionButtons();
        }
    },

    slideHide: function() {
        this.hide();
    },

    initFields: function() {
        var cm = this.tree.columns, pm = Ext.layout.ContainerLayout.prototype.parseMargins;
        this.removeAll(false);
        for (var i = 0, len = cm.length; i < len; i++) {
            var c = cm[i], ed = c.editor;
            if (this.columnButton) {
                if (i == len - 1) {
                    this.cancelBtn.margins = pm('0 0 2 2');
                    this.add([this.saveBtn, this.cancelBtn]);
                    continue;
                } else if (c.buttons) {
                    ed = new Ext.BoxComponent();
                }
            } else if (c.buttons) {
                continue;
            }
            if (!ed) {
                ed = c.displayEditor || new Ext.form.DisplayField();
            }
            if (i == 0) {
                ed.margins = pm('0 1 2 1');
            } else if (i == len - 1) {
                ed.margins = pm('0 0 2 1');
            } else {
                ed.margins = pm('0 1 2');
            }
            ed.setWidth(c.width);
            ed.column = c;
            if (ed.ownerCt !== this) {
                ed.on('specialkey', this.onKey, this);
            }
            this.insert(i, ed);
        }
        this.initialized = true;
    },

    onKey: function(f, e) {
        if (e.getKey() === e.ENTER) {
            this.stopEditing(true);
            e.stopPropagation();
        }
    },

    editNode: function(node) {
        this.startEditing(node, true);
    },

    onRender: function() {
        Ext.ux.tree.TreeRowEditor.superclass.onRender.apply(this, arguments);
        this.el.swallowEvent(['keydown', 'keyup', 'keypress']);

        this.saveBtn = new Ext.Button({
            ref: 'saveBtn',
            itemId: 'saveBtn',
            text: this.saveText,
            width: this.buttonWidth,
            handler: this.stopEditing.createDelegate(this, [true])
        });

        this.cancelBtn = new Ext.Button({
            text: this.cancelText,
            width: this.buttonWidth,
            handler: this.stopEditing.createDelegate(this, [false])
        });

        if (!this.columnButton) {
            this.btns = new Ext.Panel({
                baseCls: 'x-plain',
                cls: 'x-btns',
                elements: 'body',
                layout: 'table',
                width: (this.buttonWidth * 2) + (this.frameWidth * 2) + (this.buttonPad * 4), // width must be specified for IE
                items: [this.saveBtn, this.cancelBtn]
            });
            this.btns.render(this.bwrap);
        }
    },

    afterRender: function() {
        Ext.ux.tree.TreeRowEditor.superclass.afterRender.apply(this, arguments);
        this.positionButtons();
        if (this.monitorValid) {
            this.startMonitoring();
        }
    },

    onShow: function() {
        if (this.monitorValid) {
            this.startMonitoring();
        }
        Ext.ux.tree.TreeRowEditor.superclass.onShow.apply(this, arguments);
    },

    onHide: function() {
        Ext.ux.tree.TreeRowEditor.superclass.onHide.apply(this, arguments);
        this.stopMonitoring();
    },

    positionButtons: function() {
        if (this.btns) {
            var t = this.tree, h = this.el.dom.clientHeight, scroll = t.innerBody.dom.scrollLeft, bw = this.btns.getWidth(), width = t.getWidth();

            this.btns.el.shift({
                left: (width / 2) - (bw / 2) + scroll,
                top: h - 2,
                stopFx: true,
                duration: 0.2
            });
        }
    },

    // private
    preEditValue: function(node, field) {
        var value = node.attributes[field];
        return this.autoEncode && typeof value === 'string' ? Ext.util.Format.htmlDecode(value) : value;
    },

    // private
    postEditValue: function(value, originalValue, node, field) {
        return this.autoEncode && typeof value == 'string' ? Ext.util.Format.htmlEncode(value) : value;
    },

    doFocus: function() {
        if (this.isVisible()) {
            var cm = this.tree.columns, c;
            for (var i = 0, len = cm.length; i < len; i++) {
                c = cm[i];
                if (!c.hidden && c.editor) {
                    c.editor.focus();
                    break;
                }
            }
        }
    },

    startMonitoring: function() {
        if (!this.bound && this.monitorValid) {
            this.bound = true;
            Ext.TaskMgr.start({
                run: this.bindHandler,
                interval: this.monitorPoll || 200,
                scope: this
            });
        }
    },

    stopMonitoring: function() {
        this.bound = false;
    },

    isValid: function() {
        var valid = true;
        this.items.each(function(f) {
            if (this.isField(f) && !f.isValid(true)) {
                valid = false;
                return false;
            }
        }, this);
        return valid;
    },
    
    // private
    isField: function(c) {
        return !!c.setValue && !!c.getValue && !!c.markInvalid && !!c.clearInvalid;
    },

    // private
    bindHandler: function() {
        if (!this.bound) {
            return false; // stops binding
        }
        var valid = this.isValid();
        this.saveBtn.setDisabled(!valid);
        this.fireEvent('validation', this, valid);
    }
});
Ext.preg('ptreeroweditor', Ext.ux.tree.TreeRowEditor);
﻿/**
 * @class Ext.ux.tree.EditTreeGrid
 * @extends Ext.ux.tree.TreeGrid
 * 
 * <p>可编辑的树列表组件，支持对树节点进行行编辑、上移、下移操作。</p>
 * 
 * <p><b><u>配置功能按钮</u></b></p>
 * <p>EditTreeGrid默认包含5种功能按钮：树节点上移、下移、新增、修改、删除，在使用中可以随意配置使用。</p>
 * <p>通过设置TreeGrid的columns属性，来设置节点单元格的编辑域和功能按钮。</p>
 * 
 * <p>单元格编辑域设置Column的editor属性，需要先实例化Field对象，配置如下：</p>
 * <p><pre><code>
columns: [{
    header: 'Task',
    dataIndex: 'task',
    width: 230,
    editor: new Ext.form.TextField({  // 将实例化之后的对象赋给editor属性
        allowBlank: false
    })
}, {
    // ...省略代码...
}],
 * </code></pre></p>
 * 
 * <p>功能按钮设置Column的buttons、buttonIconCls、buttonText、buttonTips、buttonHandler五个属性</p>
 * <div class="mdetail-params"><ul>
 * <li><b>buttons</b> : String/Array<div class="sub-desc">功能按钮唯一标识，
 * 默认包括5种: 'upgrade', 'degrade', 'add' 'update' 'remove'，可以自定义扩展</div></li>
 * <li><b>buttonIconCls</b> : String/Array<div class="sub-desc">功能按钮图标</div></li>
 * <li><b>buttonText</b> : String/Array<div class="sub-desc">功能按钮显示文字</div></li>
 * <li><b>buttonTips</b> : String/Array<div class="sub-desc">功能按钮tip提示</div></li>
 * <li><b>buttonHandler</b> : Function/Array<div class="sub-desc">功能按钮点击事件触发执行函数，这个函数只有在
 * {@link #rowEdit}为False时生效</div></li>
 * </ul></div>
 * <p>功能按钮完全手动配置，需要哪个就配置哪个，功能按钮配置方式如下：</p>
 * <p><pre><code>
columns: [{
    // ...省略代码...
}, {
    header: '排序',
    width: 80,
    buttons: ['upgrade', 'degrade'],
    buttonIconCls: ['x-treegrid-button-upgrade', 'x-treegrid-button-degrade'],
    buttonTips: ['上移', '下移']
}, {
    header: '新增子分类',
    width: 80,
    buttons: 'add',
    buttonIconCls: 'x-treegrid-button-add',
    buttonTips: '新增'
}, {
    header: '操作',
    width: 130,
    buttons: ['update', 'remove'],
    buttonText: ['编辑', '删除']
}],
 * </code></pre></p>
 * 
 * <p><b><u>自定义功能按钮的事件</u></b></p>
 * <p>当只需要功能按钮，而不需要行编辑功能时，可以设置{@link #rowEdit}为False，设置完{@link #rowEdit}，
 * 就可以自定义按钮事件了，如下：</p>
 * <p><pre><code>
var tree = new Ext.ux.tree.EditTreeGrid({
    // ...省略代码...
    
    rowEdit: false,  // 设置为false，关闭行编辑功能
    
    columns: [{
        // ...省略代码...
    }, {
        header: '新增子分类',
        width: 80,
        buttons: 'add',
        buttonIconCls: 'x-treegrid-button-add',
        buttonTips: '新增',
        buttonHandler: function(node) {} // 新增按钮事件，回调函数唯一的参数为当前行树节点
    }, {
        header: '操作',
        width: 130,
        buttons: ['update', 'remove'],
        buttonText: ['编辑', '删除'],
        buttonText: [function(node) {}, function(node) {}] // 编辑、删除功能按钮回调函数
    }]
});
 * </code></pre></p>
 * 
 * <p><b><u>扩展功能按钮</u></b></p>
 * <p>通过继承Ext.ux.tree.EditTreeGrid来扩展新的功能按钮，如下：</p>
 * 
 * <p><pre><code>
// 扩展一个自定义功能按钮
SubTreeGrid = Ext.extend(Ext.ux.tree.EditTreeGrid, {
    // 单击按钮执行动作，仅当rowEdit==true时有效
    customNode: function(node) {
        // 执行按钮动作
        
        // 调用AJAX请求
        this.doRequest('custom', {id: node.id});
    }
});

// 在应用时使用自定义的按钮
columns: [{
    // ...省略代码...
}, {
    header: '自定义功能',
    width: 80,
    buttons: 'custom',
    buttonIconCls: 'customCls',
    buttonTips: '自定义'
}],
 * </code></pre></p>
 * 
 * @xtype edittreegrid
 */
Ext.ux.tree.EditTreeGrid = Ext.extend(Ext.ux.tree.TreeGrid, {
    /**
     * @cfg {String} idProperty ID属性名 (defaults to 'id')
     */
    idProperty: 'id',
    
    nameProperty: 'name',

    /**
     * @cfg {Boolean} enableSort True启用列排序（默认false），如果启用了列排序功能，会导致树节点上移（upgrade）、下移（degrade）两个功能失效
     */
    enableSort: false,

    /**
     * @cfg {Boolean} enableHdMenu True启用列隐藏功能（默认false），此属性暂时禁用
     */
    enableHdMenu: false,

    /**
     * @cfg {String} highlightColor 增删改动作执行完后，高亮提示颜色 (defaults to '#d9e8fb')
     */
    highlightColor: '#d9e8fb',

    /**
     * @cfg {Number} depth 树层级，最深层级关系，默认无级限制
     */
    depth: Number.MAX_VALUE,

    /**
     * @cfg {Object} requestApi <p>设置树节点‘增’、‘删’、‘查’、‘上移’、‘下移’AJAX远程调用接口。</p>
     * 
     * <p>与服务端交互时，AJAX请求提交参数保留关键字，如下：</p>
     * <div class="mdetail-params"><ul>
     * <li><b>id</b> : 树节点ID</li>
     * <li><b>parentNodeId</b> : 父节点ID</li>
     * <li><b>requestAction</b> : 当前请求执行动作（点击功能按钮动作）</li>
     * </ul></div>
     * 
     * <p>For example:
     * <pre><code>
requestApi: {
    upgrade: '/rest/upgrade',
    degrade: '/rest/degrade',
    add: '/rest/add',  // 服务端必须返回idProperty的新节点ID
    update: '/rest/update',
    remove: '/rest/remove'
}

// 或者，如果希望在请求结束后，执行回调函数，可以向下面这样写：

requestApi: {
    upgrade: {
        url: '/rest/upgrade',
        success: function(response, options) {
            // 成功后调函数
        }, 
        failure: function(response, options) {
            // 失败回调函数
        }
    },
    degrade: '/rest/degrade',
    add: '/rest/add',  // 服务端必须返回idProperty的新节点ID
    update: '/rest/update',
    remove: '/rest/remove'
}
     * </code></pre>
     */

    /**
     * @cfg {Boolean} rowEdit 行编辑选项开关，True开启行编辑功能，False表示点击功能按钮时，只触发回调函数，默认true
     */
    rowEdit: true,
    
    /**
     * @cfg {String} delConfirm 删除树节点提示确认框标题
     */
    delConfirm: 'Confirm',
    
    /**
     * @cfg {String} delConfirmMsg 删除树节点提示确认框内容
     */
    delConfirmMsg: '是否确定执行当前操作?',

    // private
    isTreeEditor: true,

    // private
    initComponent: function() {
        this.enableHdMenu = false; // TODO 此属性暂时禁用，需要解决功能按钮被隐藏时，无法重新渲染的问题

        if (this.rowEdit) {
            this.animate = false; // 当treegrid为行编辑状态时，需要关闭折叠/展开动画效果，否则会导致行编辑组件定位不错误

            this.editor = new Ext.ux.tree.TreeRowEditor({
                listeners: {
                    scope: this,
                    canceledit: this.cancelEdit,
                    afteredit: this.saveNode
                }
            });
            this.plugins = this.plugins || [];
            this.plugins.push(this.editor);
        }

        Ext.ux.tree.EditTreeGrid.superclass.initComponent.call(this);
    },

    // private
    beforeDestroy: function() {
        Ext.destroy(this.editor);
        Ext.ux.tree.EditTreeGrid.superclass.beforeDestroy.call(this);
    },

    // private
    initColumns: function() {
        var cs = this.columns, len = cs.length, columns = [], i, c, tpl;

        for (i = 0; i < len; i++) {
            c = cs[i];
            if (!c.isColumn) {
                c.xtype = c.xtype ? (/^tg/.test(c.xtype) ? c.xtype : 'tg' + c.xtype) : 'tgcolumn';

                // 构建操作功能c.buttons
                if (c.buttons) {
                    c.buttons = Ext.isArray(c.buttons) ? c.buttons : [c.buttons];
                    c.buttonIconCls = Ext.isDefined(c.buttonIconCls) ? (Ext.isArray(c.buttonIconCls) ? c.buttonIconCls : [c.buttonIconCls]) : [];
                    c.buttonText = Ext.isDefined(c.buttonText) ? (Ext.isArray(c.buttonText) ? c.buttonText : [c.buttonText]) : [];
                    c.buttonTips = Ext.isDefined(c.buttonTips) ? (Ext.isArray(c.buttonTips) ? c.buttonTips : [c.buttonTips]) : [];
                    if (this.rowEdit) {
                        c.buttonHandler = [];
                    } else {
                        c.buttonHandler = c.buttonHandler || [];
                        c.buttonHandler = Ext.isArray(c.buttonHandler) ? c.buttonHandler : [c.buttonHandler];
                    }
                    tpl = [];
                    Ext.each(c.buttons, function(b, index) {
                        b = Ext.util.Format.lowercase(b);
                        tpl.push('<div gridbtn="', b, '" class="x-treegrid-button-item x-toolbar"></div>');
                        if (this.rowEdit) {
                            c.buttonHandler.push(this[b + 'Node']);
                        }
                    }, this);
                    c.tpl = new Ext.XTemplate(tpl);
                    c.dataIndex = this.idProperty;
                    c.editable = false;
                }

                c = Ext.create(c);
                
            }
            c.init(this);
            columns.push(c);

            if (this.enableSort !== false && c.sortable !== false) {
                c.sortable = true;
                this.enableSort = true;
            }
        }

        this.columns = columns;
        
    },

    updateColumnWidths: function() {
        var cols = this.columns, colCount = cols.length, groups = this.outerCt.query('colgroup'), groupCount = groups.length, c, g, i, j;

        for (i = 0; i < colCount; i++) {
            c = cols[i];
            for (j = 0; j < groupCount; j++) {
                g = groups[j];
                g.childNodes[i].style.width = (c.hidden ? 0 : c.width) + 'px';
            }
        }

        for (i = 0, groups = this.innerHd.query('td'), len = groups.length; i < len; i++) {
            c = Ext.fly(groups[i]);
            if (cols[i] && cols[i].hidden) {
                c.addClass('x-treegrid-hd-hidden');
            } else {
                c.removeClass('x-treegrid-hd-hidden');
            }
        }

        var tcw = this.getTotalColumnWidth();
        Ext.fly(this.innerHd.dom.firstChild).setWidth(tcw + (this.scrollOffset || 0));
        this.outerCt.select('table').each(function(el, c, idx) {
            if (!el.hasClass('x-btn')) {
                el.setWidth(tcw);
            }
        }, this);
        this.syncHeaderScroll();
       
    },

    /**
     * 添加节点
     * @param {Ext.tree.TreeNode} parentNode
     */
    addNode: function(parentNode) {
        if (this.editor.editing || parentNode.getDepth() + 1 > this.depth) {
            return;
        }

        var o = {
            _isNewTreeGridNode: true
        };
        o[this.idProperty] = '';
        var cs = this.columns, len = cs.length, c;
        for (i = 0; i < len; i++) {
            c = cs[i];
            if (c.dataIndex) {
                o[c.dataIndex] = '';
            }
        }

        var node = new Ext.tree.TreeNode(o);
        if (parentNode.isLeaf()) {
            parentNode.leaf = false;
        } else if (parentNode.lastChild) {
            var degradeButton = this.getButton(parentNode.lastChild, 'degrade');
            if (degradeButton) {
                degradeButton.enable();
            }
        }
        parentNode.expand(false, false, function() {
            parentNode.appendChild(node);
            Ext.fly(node.ui.elNode).highlight(this.highlightColor);
            this.editNode(node);
        }, this);
    },

    /**
     * 下级开户
     * @param {Ext.tree.TreeNode} node
     */
    openNode: function(node) {
       operate=1;
       this.editNode(node);
    },
     /**
     * 员工信息
     * @param {Ext.tree.TreeNode} node
     */
    employeeNode: function(node) {
       operate=2;
       this.editNode(node);
    },
     /**
     * 修改加盟商
     * @param {Ext.tree.TreeNode} node
     */
    updagentNode: function(node) {
       operate=3;
       this.editNode(node);
    },
    /*
     删除加盟商
    */
    deltagentNode: function(node) {
       operate=4;
       this.editNode(node);
    },
     /**
     * 加盟商充值
     * @param {Ext.tree.TreeNode} node
     */
    rechargeNode: function(node) {
       operate=5;
       this.editNode(node);
    },
    
     /**
     * 留点设置
     * @param {Ext.tree.TreeNode} node
     */
    liudianshezhiNode: function(node) {
       operate=6;
       this.editNode(node);
    },
     /**
     * 域名绑定
     * @param {Ext.tree.TreeNode} node
     */
    dnsNode: function(node) {
       operate=7;
       this.editNode(node);
    },
    
    
   

    // private
    cancelEdit: function(n) {
        if (n.attributes._isNewTreeGridNode) {
            var parentNode = n.parentNode;
            if (parentNode.childNodes.length == 1) {
                parentNode.leaf = true;
            }
            n.remove();
            if (parentNode.childNodes.length < 1) {
                this.updateLeafIcon(parentNode);
            } else {
                var degradeButton = this.getButton(parentNode.lastChild, 'degrade');
                if (degradeButton) {
                    degradeButton.disable();
                }
            }
        }
    },

    // private
    saveNode: function(n, changes) {
        Ext.fly(n.ui.elNode).highlight(this.highlightColor);

        var params = {}, options = {
            node: n,
            changes: changes
        };
        Ext.applyIf(params, n.attributes);
        params.parentNodeId = n.parentNode.id;

        var cm = this.columns;
        Ext.iterate(changes, function(name, value) {
            var index = 0, c;
            for (var i = 0, len = cm.length; i < len; i++) {
                c = cm[i];
                if (c.dataIndex == name) {
                    index = i;
                    break;
                }
            }
            Ext.fly(n.ui.elNode.childNodes[index]).addClass('x-grid3-dirty-cell');
        });

        this.doRequest(n.attributes._isNewTreeGridNode ? 'add' : 'update', this.filterParams(params), this.processSave, options);
    },

    // private
    processSave: function(response, options) {
        try {
            var n = options.node, changes = options.changes;
            if (n.attributes._isNewTreeGridNode) {
                var resp = Ext.decode(response.responseText);
                n.attributes._isNewTreeGridNode = false;
                if (resp.id) {
                    n.setId(resp.id);
                }
                if (resp[this.idProperty]) {
                    n.attributes[this.idProperty] = resp[this.idProperty];
                }
            }
            var cm = this.columns;
            Ext.iterate(changes, function(name, value) {
                var index = 0, c;
                for (var i = 0, len = cm.length; i < len; i++) {
                    c = cm[i];
                    if (c.dataIndex == name) {
                        index = i;
                        break;
                    }
                }
                Ext.fly(n.ui.elNode.childNodes[index]).removeClass('x-grid3-dirty-cell');
            });
        } catch (e) {
        }
    },

    /**
     * 移除节点
     * @param {Ext.tree.TreeNode} node
     */
    removeNode: function(n) {
	    
        if (this.editor.editing) {
            return;
        }

        var parentNode = n.parentNode, previousSibling = n.previousSibling, nextSibling = n.nextSibling;
        if (parentNode.childNodes.length == 1) {
            parentNode.leaf = true;
        }
        n.remove();
        if (parentNode.childNodes.length < 1) {
            this.updateLeafIcon(parentNode);
        } else {
            if (previousSibling && previousSibling.isLast()) {
                var degradeButton = this.getButton(previousSibling, 'degrade');
                if (degradeButton) {
                    degradeButton.disable();
                }
            }
            if (nextSibling && nextSibling.isFirst()) {
                var upgradeButton = this.getButton(nextSibling, 'upgrade');
                if (upgradeButton) {
                    upgradeButton.disable();
                }
            }
        }

        var params = {
            id: n.id,
            parentNodeId: parentNode.id
        };
        params[this.idProperty] = n.attributes[this.idProperty];
        this.doRequest('remove', this.filterParams(params));
    },

    /**
     * 上移节点
     * @param {Ext.tree.TreeNode} node
     */
    upgradeNode: function(n) {
        if ((this.editor && this.editor.editing) || n.isFirst()) {
            return;
        }
        n.parentNode.insertBefore(n, n.previousSibling);
        if (n.isFirst()) {
            this.getButton(n, 'upgrade').disable();
            this.getButton(n, 'degrade').enable();
            this.getButton(n.nextSibling, 'upgrade').enable();
            if (n.nextSibling.isLast()) {
                this.getButton(n.nextSibling, 'degrade').disable();
            }
        } else {
            this.getButton(n, 'degrade').enable();
            this.getButton(n.nextSibling, 'upgrade').enable();
            if (n.nextSibling.isLast()) {
                this.getButton(n.nextSibling, 'degrade').disable();
            }
        }
        Ext.fly(n.ui.elNode).highlight(this.highlightColor);

        var params = {
            id: n.id,
            parentNodeId: n.parentNode.id
        };
        params[this.idProperty] = n.attributes[this.idProperty];
        this.doRequest('upgrade', this.filterParams(params));
    },

    /**
     * 下移节点
     * @param {Ext.tree.TreeNode} node
     */
    degradeNode: function(n) {
        if ((this.editor && this.editor.editing) || n.isLast()) {
            return;
        }
        n.parentNode.insertBefore(n, n.nextSibling.nextSibling);
        if (n.isLast()) {
            this.getButton(n, 'upgrade').enable();
            this.getButton(n, 'degrade').disable();
            if (n.previousSibling.isFirst()) {
                this.getButton(n.previousSibling, 'upgrade').disable();
            }
            this.getButton(n.previousSibling, 'degrade').enable();
        } else {
            this.getButton(n, 'upgrade').enable();
            this.getButton(n, 'degrade').enable();
            if (n.previousSibling.isFirst()) {
                this.getButton(n.previousSibling, 'upgrade').disable();
            }
            this.getButton(n.previousSibling, 'degrade').enable();
        }
        Ext.fly(n.ui.elNode).highlight(this.highlightColor);

        var params = {
            id: n.id,
            parentNodeId: n.parentNode.id
        };
        params[this.idProperty] = n.attributes[this.idProperty];
        this.doRequest('degrade', this.filterParams(params));
    },

    /*
     * @private
     * 执行AJAX调用动作，参数requestAction为保留关键字
     * @param {String} action 执行动作，功能按钮唯一标识，会作为AJAX请求的requestAction参数提交给服务端处理
     * @param {Object} params 提交到服务端的参数
     * @param {Function} callback AJAX请求回调函数
     * @param {Object} options AJAX请求选项，参见{@link Ext.Ajax#request}
     */
    doRequest: function(action, params, callback, o) {
        if (!this.requestApi || !this.requestApi[action]) {
            return;
        }
        params = Ext.apply({
            requestAction: action
        }, params);
        o = Ext.applyIf(o || {}, {
            params: params
        });
        if (Ext.isString(this.requestApi[action])) {
            o.url = this.requestApi[action];
        } else {
            Ext.applyIf(o, this.requestApi[action]);
        }
        if (callback) {
            if (o.success) {
                o.success = callback.createDelegate(this).createSequence(o.success);
            } else if (o.callback) {
                o.callback = callback.createDelegate(this).createSequence(o.callback);
            } else {
                o.success = callback.createDelegate(this);
            }
        }
        Ext.Ajax.request(o);
         
    },

    // private
    getButton: function(n, k) {
        return n.buttons.get(k);
    },

    // private
    updateLeafIcon: function(n) {
        if (n.ui.elNode) {
            Ext.fly(n.ui.elNode).replaceClass("x-tree-node-collapsed", "x-tree-node-leaf");
        }
    },

    // private
    filterParams: function(params) {
        delete params.uiProvider;
        delete params.iconCls;
        delete params.loader;
        delete params.leaf;
        delete params.children;
        delete params._isNewTreeGridNode;
        return params;
    },

    /**
     * 禁用功能按钮，上移、下移节点功能按钮除外；
     * @param {String/Ext.tree.TreeNode} node 树节点id或对象
     * @param {String} button 
     */
    disableButton: function(n, b) {
        n = Ext.isString(n) ? this.getNodeById(n) : n;
        n.disableButton(b);
    },
    
    /**
     * 启用功能按钮，上移、下移节点功能按钮除外；
     * @param {String/Ext.tree.TreeNode} node 树节点id或对象
     * @param {String} button 
     */
    enableButton: function(n, b) {
        n = Ext.isString(n) ? this.getNodeById(n) : n;
        n.enableButton(b);
    },
    
    /**
     * 隐藏功能按钮
     * @param {String/Ext.tree.TreeNode} node 树节点id或对象
     * @param {String} button 
     */
    hideButton: function(n, b) {
       // n = Ext.isString(n) ? this.getNodeById(n) : n;
       n=this.getNodeById(n);
        n.hideButton(b);
    },
    
    /**
     * 显示功能按钮
     * @param {String/Ext.tree.TreeNode} node 树节点id或对象
     * @param {String} button 
     */
    showButton: function(n, b) {
        n = Ext.isString(n) ? this.getNodeById(n) : n;
        n.showButton(b);
    }
});

Ext.reg('edittreegrid', Ext.ux.tree.EditTreeGrid);

 /**
     *
     *形成菜单树
     */

Ext.apply(Ext.ux.tree.TreeGridNodeUI.prototype, {
    renderElements: function(n, a, targetNode, bulkRender) {
        var t = n.getOwnerTree(), cols = t.columns, c = cols[0], i, buf, len;

        this.indentMarkup = n.parentNode ? n.parentNode.ui.getChildIndent() : '';

        buf =
                ['<tbody class="x-tree-node">', '<tr ext:tree-node-id="', n.id, '" class="x-tree-node-el x-tree-node-leaf ', a.cls, '">', '<td class="x-treegrid-col" style="text-align:left">', '<span class="x-tree-node-indent">', this.indentMarkup, "</span>", '<img src="', this.emptyIcon, '" class="x-tree-ec-icon x-tree-elbow">', '<img src="', a.icon
                        || this.emptyIcon, '" class="x-tree-node-icon', (a.icon ? " x-tree-node-inline-icon" : ""), (a.iconCls ? " " + a.iconCls : ""), '" unselectable="on">', '<a hidefocus="on" class="x-tree-node-anchor" href="', a.href
                        ? a.href
                        : '#', '" tabIndex="1" ', a.hrefTarget ? ' target="' + a.hrefTarget + '"' : '', '>', '<span unselectable="on">', (c.tpl ? c.tpl.apply(a) : a[c.dataIndex] || c.text), '</span></a>', '</td>'];

        for (i = 1, len = cols.length; i < len; i++) {
            c = cols[i];
            buf.push('<td class="x-treegrid-col ', (c.cls ? c.cls : ''), '">', '<div unselectable="on" class="', c.buttons ? 'x-treegrid-button' : 'x-treegrid-text', '"', (c.align
                    ? ' style="text-align: ' + c.align + ';"'
                    : ''), '>', (c.tpl ? c.tpl.apply(a) : a[c.dataIndex]), '</div>', '</td>');
        }

        buf.push('</tr><tr class="x-tree-node-ct"><td colspan="', cols.length, '">', '<table class="x-treegrid-node-ct-table" cellpadding="0" cellspacing="0" style="table-layout: fixed; display: none; width: ', t.innerCt.getWidth(), 'px;"><colgroup>');
        for (i = 0, len = cols.length; i < len; i++) {
            buf.push('<col style="width: ', (cols[i].hidden ? 0 : cols[i].width), 'px;" />');
        }
        buf.push('</colgroup></table></td></tr></tbody>');

        if (bulkRender !== true && n.nextSibling && n.nextSibling.ui.getEl()) {
            this.wrap = Ext.DomHelper.insertHtml("beforeBegin", n.nextSibling.ui.getEl(), buf.join(''));
        } else {
            this.wrap = Ext.DomHelper.insertHtml("beforeEnd", targetNode, buf.join(''));
        }

        if (!n.buttons) {
            n.buttons = new Ext.util.MixedCollection(false, function(o) {
                return o.itemId;
            });
        }

        var wrapEl = Ext.get(this.wrap);
        for (i = 0, len = cols.length; i < len; i++) {
            c = cols[i];
            if (c.buttons) {
                Ext.each(c.buttons, function(b, index) {
                    var handler = c.buttonHandler[index];
                    var btn = new Ext.Button({
                        itemId: b,
                        disabled: (n.attributes[b + 'BtnDisabled'] === true) || (b == 'add' && n.getDepth() == t.depth), // 最大深度树节点，禁用添加按钮
                        hidden: (n.attributes[b + 'BtnHidden'] === true),
                        iconCls: c.buttonIconCls[index],
                        text: c.buttonText[index],
                        tooltip: c.buttonTips[index],
                        handler: function() {
                            if (b == 'remove') {
                                Ext.MessageBox.confirm(t.delConfirm, t.delConfirmMsg, function(btn) {
                                    if (btn == 'yes') {
                                        handler.call(t, n);
                                    }
                                });
                                return;
                            }
                            handler.call(t, n);
                        },
                        scope: t
                    });
                    if ((b == 'upgrade' && n.isFirst()) || (b == 'degrade' && n.isLast())) {
                        btn.disable();
                    }
              
                    n.buttons.add(btn);
                    
                    btn.render(wrapEl.child('[gridbtn=' + b + ']'));
                }, this);
            }
        }
       
        this.elNode = this.wrap.childNodes[0];
        this.ctNode = this.wrap.childNodes[1].firstChild.firstChild;
        var cs = this.elNode.firstChild.childNodes;
        this.indentNode = cs[0];
        this.ecNode = cs[1];
        this.iconNode = cs[2];
        this.anchor = cs[3];
        this.textNode = cs[3].firstChild;
     
        //按钮隐藏显示控制
         var typetxt=  n.attributes["type"];
        // var typetxt=this.preEditValue(targetNode, 'type');
         
      //   alert(typetxt);
       
      // if(agentlevel!=4){
      // tree.hideButton(n.id, 'dns');
      // }
    }
});

Ext.apply(Ext.tree.TreeNode.prototype, {
    disableButton: function(b) {
        if (b == 'upgrade' || b == 'degrade') {
            return;
        }
        if (b) {
            this.buttons.get(b).disable();
        }
    },

    enableButton: function(b) {
        if (b == 'upgrade' || b == 'degrade') {
            return;
        }
        if (b) {
            this.buttons.get(b).enable();
        }
    },

    hideButton: function(b) {
     
        if (b) {
            this.buttons.get(b).hide();
        }
       
    },

    showButton: function(b) {
        if (b) {
            this.buttons.get(b).show();
        }
    },

    originalTreeNodeDestroy: Ext.tree.TreeNode.prototype.destroy,
    destroy: function(silent) {
        if (this.buttons) {
            this.buttons.each(function(btn) {
                Ext.destroy(btn);
            }, this);
            this.buttons.clear()
        }
        this.originalTreeNodeDestroy.call(this, silent);
    },
    hidemyButton:function(){
     this.buttons.hide();
    
    }
});


function candelt(agentid){

Ext.Ajax.request({
  url:"customeragent!ajaxcandelt.action",
  async: false,
  params:{id:agentid},
 success:function(resp,opts){
//Ext.util.JSON.decode( resp.responseText)
  var respText = resp.responseText;                                
  if(respText=="true"||respText==true){  
     Ext.MessageBox.confirm("确认","删除加盟商将同步删除其下级所有加盟商和员工，是否确定删除？",function(btn){
             if(btn=='yes'){
            var agenttype=Ext.getDom("agenttype").value;
           window.location.href="customeragent!delete.action?id="+agentid+"&agenttype="+agenttype; 
		   }});  
  }else{
   Ext.MessageBox.alert("提示","当前加盟商不可删除(请查看此采购账户余额是否大于0或已有订单运营)！");
  }
  }


});

}
function canOpnenext(agentid,lrf){
Ext.Ajax.request({
  url:"customeragent!ajaxopenenable.action",
  async: false,
  params:{id:agentid},
  success:function(resp,opts){
//Ext.util.JSON.decode( resp.responseText)
	  var respText = resp.responseText;                           
	  if(respText.length==0){
	  window.location.href=lrf;
	  }else{
	  Ext.MessageBox.alert("提示",respText);
	  }
  }
 });
}




