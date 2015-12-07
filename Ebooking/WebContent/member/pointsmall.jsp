<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${compname}-积分商城</title>

<ww:head name="point" jsURL="memberpoint" />

</head>
<script>
Ext.onReady(function(){
 
 
  var comboxWithTree = new Ext.form.ComboBox({  
       store:new Ext.data.SimpleStore({fields:[],data:[[]]}),  
       editable:false,  
       
       mode: 'local',  
       triggerAction:'all',  
       maxHeight: 240, 
       width:250,
	   tpl: "<tpl for='.'><div style='height:240px ; width:250px'><div id='tree'></div></div></tpl>",  
       selectedClass:'',  
       onSelect:Ext.emptyFn  
    });  


	var root = new Ext.tree.TreeNode({text:"B2b2C Web 站点",id:'-1'})  ;
	<ww:property value="treestr"/>
	
	var tree = new Ext.tree.TreePanel({  
         
          root:root,
           rootVisible:false
       });  

	
		comboxWithTree.setValue("<ww:property value="getContentitemName(giftcatalog.parentid)"/>");

       tree.on('click',function(node){  
            comboxWithTree.setValue(node.text);  
            Ext.get('parentid').set({value:node.id});
            comboxWithTree.collapse();  
            
       });  
    
	  
	  comboxWithTree.on('expand',function(){  
			tree.render('tree');
			tree.getRootNode().expand();  
			tree.getRootNode().expandChildNodes();
			
		});

	
    comboxWithTree.render('comboxWithTree');  
	


});
</script>
<body>
<div>
	<div class="cen" style=" position:relative;">
		<ww:include page="../top.jsp?index=-1" />
	</div>    
<!----------header over---------->
<div id="member">
   <jsp:include flush="true"
	page="../member/left.jsp?ty=member"></jsp:include>
   <div class="right mt10 r">
       <div class="box">
        <div class="tit">
               <font class="black low2 f mr15">积分商城</font>
               <font class="r mr25">欢迎加入${compname}，我们将为您提供最优质的服务，服务咨询热线：${tel}。</font>
               <div class="c"></div>
        </div>
        <div class="information">
         <div>&nbsp;</div>
         <form action="point!searchGiftcatalog.jspx" method="post">
         <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
              <tr>
                <td  class="hadow hl24" align="right" width="20%">按积分查询：</td>
                <td>
                <select name="c_selectValue">
                <option value="-1" <ww:if test="c_selectValue.equals(\"-1\")">selected</ww:if> >不限积分</option>
                <option value="1" <ww:if test="c_selectValue.equals(\"1\")">selected</ww:if>>0至1000</option>
                <option value="2" <ww:if test="c_selectValue.equals(\"2\")">selected</ww:if>>1000-5000</option>
                <option value="3" <ww:if test="c_selectValue.equals(\"3\")">selected</ww:if>>5000-10000</option>
                <option value="4" <ww:if test="c_selectValue.equals(\"4\")">selected</ww:if>>10000以上</option>
                </select>
                <!--
                 <input type="textg"  class="text_number"  name="point"/>
                -->
                </td>
                <td class="hadow" align="right" width="20%">按类别查询：</td>
                <td><input type="textg"  class="text_number" name="items" /></td>
              </tr>
            </table>
            <div class="search"> <input type="submit" value="立即查询" class="button_searchmeb f"  /><font class="f00 f">查找更多礼品，开始搜索！</font></div>
            <!--listsearch over-->
            </form>
            <form action="point!toPointOrder.jspx" >
            <table width="94%" border="1" cellspacing="0" cellpadding="0"  class="centerall" >
            <ww:iterator value="listGiftcatalog" status="index">
              <tr>
              <td colspan="4" class="guilder">
              <span class="f pf20 font-f60-16"><ww:property value="name"/></span>
              <span class="r mr25"><a href="#" class="l06c">>>更多礼品</a></span></td>
              </tr>
              <tr>
              
              
             <ww:iterator value="getGiftInfoById(id,c_selectValue)" status="index1">
              <td width="25%" align="center">
                <a href="point!toPointProInfo.jspx?Giftid=<ww:property value="id"/>"><img src="<ww:property value="picsrc"/>" width="140" height="140" class="mt10 ad_box" /></a>
                <div style="line-height:20px;"><ww:property value="name"/><br/><ww:property value="useintegral"/>积分</div>
                <div><input type="button" class="button_cancel fff" value="立即兑换" onclick="toPointOrder(<ww:property value="id"/>);" /> </div>
                <div class="nohave"></div>
              </td>
              </ww:iterator>
              </tr>
              </ww:iterator>
            </table>
            </form>
            <div>&nbsp;</div>
        </div>
       </div> 
       
   </div>
</div>

<ww:include page="../footer.jsp" />  
</body>
</html>
<script>
function toPointOrder(id){
window.location.href="point!toPointOrder.jspx?Giftid="+id;
}

</script>