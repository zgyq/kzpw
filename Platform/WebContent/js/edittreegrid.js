/*!
 * Ext.ux.tree.EditTreeGrid v1.5
 */
 var tree=null;
Ext.onReady(function() {
    Ext.QuickTips.init();
    var name=Ext.getDom('agentname').value;
    var agenttype=Ext.getDom("agenttype").value;
    var enablestate=Ext.getDom("enablestate").value;
   	var page=document.getElementById("page").value;
   	var username=document.getElementById("username").value;
	var linkname=document.getElementById("linkname").value;

    tree = new Ext.ux.tree.EditTreeGrid({
        title: '加盟商列表',
        width: 1050,
        height: 500,
        renderTo: Ext.getBody(),
        enableDD: true,

        depth: 10, // 最大节点深度

        columns: [{
            header: '名称',
            dataIndex: 'name',
            align: 'left',
            width: 170
        }, {
            header: '编码',
            width: 70,
            dataIndex: 'code'
        },{
            header: '联系人',
            width: 90,
            dataIndex: 'contactname'
        },{
            header: '联系电话',
            width: 130,
            dataIndex: 'contactmobile'
        },{
            header: '允许代理级别',
            width: 70,
            dataIndex: 'allowlevelcount'
        },{
            header: '允许代理数量',
            width: 70,
            dataIndex: 'allowproxycount'
        }, 
        {
            //header: '预存款',
           // width: 70,
           // dataIndex: 'vmoney'
           header: '用户名',
            width: 70,
            dataIndex: 'username'
        }, {
            header: '启用状态',
            width: 60,
            dataIndex: 'enable'
        }, {
            header: '操作',
            width: 230,
            buttons:menukey,
            buttonText: menuval
        }],

                dataUrl: 'customeragent!getAgentJson.action?agenttype='+agenttype+'&agentcompanyname='+name+"&enablestate="+enablestate+"&page="+page+"&agentusernamename="+username+"&agentlinkname="+linkname,

        requestApi: {
            upgrade: 'treegrid-data.json',
            degrade: 'treegrid-data.json',
            add: 'treegrid-data.json',
            update: 'treegrid-data.json',
            remove: 'treegrid-data.json'
        }
    });

});
