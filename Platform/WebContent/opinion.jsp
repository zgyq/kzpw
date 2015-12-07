<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${dns.companyname}—中国最大的电子客票采购平台 政策好、返点高、城市覆盖面广、政策齐全</title>
<link rel="stylesheet" type="text/css" href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script type="text/javascript">
Ext.onReady(function(){
        Ext.MessageBox.show({
           title: '意见与建议',
           msg: '请填写您对平台的意见或建议(200字以内):',
           width:350,
           buttons: Ext.MessageBox.OKCANCEL,
           multiline: true,
            fn: showResultText
       });
  



});

 function showResultText(btn, text){    

   if(text.length>0){
    Ext.Ajax.request({
        url:'tousu!getreturnmessage.action',
		params:{content:text.substr(0,200)},
		success:function(resp,opts){
		//Ext.util.JSON.decode( resp.responseText)
		// var respText = resp.responseText;                                          
		   Ext.MessageBox.alert("提示","您的信息已成功提交，感谢您对平台的支持！",function(){
        window.opener=null;window.close();
        parent.closetab();
          })},
		falider:function(){
		  Ext.MessageBox.alert("提示","由于网络原因导致信息提交失败，请联系平台人员，感谢您对平台的支持！",function(){
		   window.opener=null;window.close();
		   parent.closetab();
		});
		}
		});
    }else{
    if(btn=='ok'){
         Ext.MessageBox.alert("提示","请输入信息内容！",function(){
         window.location.reload();
          });
          }else{
          window.opener=null;window.close();
          }
    }
    };


</script>
</head>
<body>

</body>
</html>