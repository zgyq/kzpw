/*!
 * Ext.ux.tree.EditTreeGrid v1.5
 */
Ext.onReady(function() {
    Ext.QuickTips.init();

    var tree = new Ext.ux.tree.EditTreeGrid({
        title: 'Core Team Projects',
        width: 760,
        height: 300,
        renderTo: Ext.getBody(),
        enableDD: true,

        depth: 5, // 最大节点深度

        columns: [{
            header: '代码',
            dataIndex: 'task',
            width: 230,
            editor: new Ext.form.TextField({
                allowBlank: false
            })
        }, {
            header: '类型',
            width: 100,
            dataIndex: 'duration',
            align: 'center',
            sortType: 'asFloat',
            tpl: new Ext.XTemplate('{duration:this.formatHours}', {
                formatHours: function(v) {
                    if (v < 1) {
                        return Math.round(v * 60) + ' mins';
                    } else if (Math.floor(v) !== v) {
                        var min = v - Math.floor(v);
                        return Math.floor(v) + 'h ' + Math.round(min * 60) + 'm';
                    } else {
                        return v + ' hour' + (v === 1 ? '' : 's');
                    }
                }
            }),
            editor: new Ext.form.NumberField({
                allowBlank: false,
                allowDecimals: true
            })
        }, {
            header: '名称',
            width: 120,
            dataIndex: 'user',
            editor: new Ext.form.TextField({
                allowBlank: false
            })
        }, {
            header: '预存款账户',
            width: 80,
            buttons: ['upgrade', 'degrade'],
            buttonIconCls: ['x-treegrid-button-upgrade', 'x-treegrid-button-degrade'],
            buttonTips: ['上移', '下移']
        }, {
            header: '所属省份',
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

        dataUrl: 'treegrid-data.json',

        requestApi: {
            upgrade: 'treegrid-data.json',
            degrade: 'treegrid-data.json',
            add: 'treegrid-data.json',
            update: 'treegrid-data.json',
            remove: 'treegrid-data.json'
        },
        
        tbar: [{
            text: '新增一级节点',
            handler: function() {
                tree.addNode(tree.getRootNode());
            }
        }] 
    });

   
});
