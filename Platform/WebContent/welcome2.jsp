<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<style type="text/css">
<!--
.STYLE1 {
	font-weight: bold
}

-->
.bor {
	background: #FFE;
	border: #F90 1px dotted;
	margin: 5px;
	padding: 5px;
	overflow: hidden;
}

.alertmsg {
	color: #FF7117;
}
</style>
<link href="<%=request.getContextPath() %>/style/Layout.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/base.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/font1.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath() %>/style/yunwei.css"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" media="all"
	href="css/globalframe.css">
<link href="css/left_n.css" type="text/css" rel="stylesheet" />
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="js/resources/css/ext-all.css" />
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<script>
   //子页面操作父页面的菜单按钮，并切换导航
   function getParent()
    {            
     var oDoc = top.document; 
     //document.write(oDoc.body.innerHTML);  
     oDoc.documentElement.innerHTML;
     //获得父业面的菜单按钮
     var oTxt = oDoc.getElementById("txtParent");  
     }
     
     function chang(url,id){
     window.parent.topFrame.aaa(""+id+"");//头部导航选择
     //window.parent.frames.location.href="customeruser!foo.action?rightid="+id;//
     parent.left.location.href='customeruser!leftmenu.action?rightid='+id+'&forward=left.jsp';
     parent.member.location.href=url;
     //window.location.href=url;
     //window.parent.member=url;
     //
     
     }
</script>
<style type="text/css">
.left {
	text-align: left;
}
</style>
</head>
<body>
<div id="right" style="height: 99.7%;">
<div class="lit">
<ul>
<li class="offwu"><a href="login!towelcome.action?first=true">公告信息</a></li>
	<li class="offwu"><a href="login!towelcome2.action?first=true">客服中心</a></li>
	

	<li><img src="imagess/jiao.gif" width="8" height="28" /></li>
	<li style="float: right;display: none" class="mr11"><img
		src="images/ptxz.png" onclick="showMsg()" width="59" height="23"
		class="mr8" /></li>

</ul>
</div>
<div id="main" lang="ca" class="kuang box" style="margin-right: 7px;">
<div class="sea box_hui">
<div id="member">
<table width="99%" border="0" cellpadding="0" cellspacing="0"
	align="center" height="100%">

	<tr>
		<td width="100%" height="10"></td>
	</tr>
	<tr>
		<td valign="top">
		<table width="80%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
				<table width="80%" class="listing" border="0" cellspacing="0"
					cellpadding="2">
					<tbody>


						
							<tr>
								<td class="tableheader" align="left">24小时免费服务热线:</td>
								<td class="tableheader">888888 &nbsp; &nbsp;按1国内机票 &nbsp;&nbsp; 按2国际机票</td>
							</tr>
							<tr>
								<td class="tableheader" align="left">团队票:</td>
								<td class="tableheader">罗总：010-8888888 手机：15888888888
								</td>
							</tr>
							<tr>
								<td class="tableheader" align="left"></td>
								<td class="tableheader">罗总：010-8888888 手机：15888888888
								</td>
							</tr>
							<tr>
								<td class="tableheader" align="left">散客:</td>
								<td class="tableheader">
								</td>
							</tr>
							<tr>
								<td class="tableheader" align="left">国际:</td>
								<td class="tableheader">罗总：010-8888888 手机：15888888888
								</td>
							</tr>
							<tr>
								<td class="tableheader" align="left">国内:</td>
								<td class="tableheader">罗总：010-8888888 手机：15888888888
								</td>
							</tr>
							<tr>
								<td class="tableheader" align="left"></td>
								<td class="tableheader">罗总：010-8888888 手机：15888888888
								</td>
							</tr>
							<tr>
								<td class="tableheader" align="left"></td>
								<td class="tableheader">罗总：010-8888888 手机：15888888888
								</td>
							</tr>
							<tr>
								<td class="tableheader" align="left"></td>
								<td class="tableheader">罗总：010-8888888 手机：15888888888
								</td>
							</tr>
					</tbody>
				</table>
				</td>
			</tr>
			<tr>
				<td><ww:if test="getLoginsessionagent().id!=47">
					<table class="tblist mt10" width="80%" border="0" cellspacing="0"
						cellpadding="2">
						<tbody>
							<tr>
								<td class='tableheader2'><b>分销咨询(周一至周六工作时间: 08:00 -
								22:30 咨询电话：010—88888888)</b></td>
							</tr>
							<tr onmouseout='this.className=&#39;listresult&#39;;'
								onmouseover='this.className=&#39;listresultMouseOver&#39;'
								class='listresult'>
								<td>
								&nbsp;&nbsp;<a href='#'><a target='_blank'
									href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes'><img
									border='0' src='http://wpa.qq.com/pa?p=2:2355862568:41'
									alt='点击这里给我发消息' title='点击这里给我发消息'></a>&nbsp;&nbsp;<a href='#'><a
									target='_blank'
									href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes'><img
									border='0' src='http://wpa.qq.com/pa?p=2:2355862568:41'
									alt='点击这里给我发消息' title='点击这里给我发消息'></a>&nbsp;&nbsp;
									
									</td>
									
							</tr>
							<tr>
								<td class='tableheader2'><b>加盟咨询(周一至周六工作时间: 08:00 -
								22:30 咨询电话：010—88888888)</b></td>
							</tr>
							<tr onmouseout='this.className=&#39;listresult&#39;;'
								onmouseover='this.className=&#39;listresultMouseOver&#39;'
								class='listresult'>
								<td>
								&nbsp;&nbsp;<a href='#'><a target='_blank'
									href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes'><img
									border='0' src='http://wpa.qq.com/pa?p=2:2355862568:41'
									alt='点击这里给我发消息' title='点击这里给我发消息'></a>&nbsp;&nbsp;<a href='#'><a
									target='_blank'
									href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes'><img
									border='0' src='http://wpa.qq.com/pa?p=2:2355862568:41'
									alt='点击这里给我发消息' title='点击这里给我发消息'></a>&nbsp;&nbsp;
									
									</td>
									
							</tr>
							
							
							
							
							<tr>
								<td class='tableheader2'><b>机票业务(周一至周六工作时间: 08:00 -
								22:30 客服电话：010—88888888)</b></td>
							</tr>
							<tr onmouseout='this.className=&#39;listresult&#39;;'
								onmouseover='this.className=&#39;listresultMouseOver&#39;'
								class='listresult'>
								<td>
								&nbsp;&nbsp;<a href='#'><a target='_blank'
									href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes'><img
									border='0' src='http://wpa.qq.com/pa?p=2:2355862568:41'
									alt='点击这里给我发消息' title='点击这里给我发消息'></a>&nbsp;&nbsp;<a href='#'><a
									target='_blank'
									href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes'><img
									border='0' src='http://wpa.qq.com/pa?p=2:2355862568:41'
									alt='点击这里给我发消息' title='点击这里给我发消息'></a>&nbsp;&nbsp;
									
									</td>
									
							</tr>
							
							
							
							
							<tr>
								<td class='tableheader2'><b>其他业务办理 (工作时间:周一至周六 08:00 -
								17:30 使用指导 电话：010—88888888))</b></td>
							</tr>
							<tr onmouseout='this.className=&#39;listresult&#39;;'
								onmouseover='this.className=&#39;listresultMouseOver&#39;'
								class='listresult'>
								<td>
								&nbsp;&nbsp;<a href='#'><a target='_blank'
									href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes'><img
									border='0' src='http://wpa.qq.com/pa?p=2:2355862568:41'
									alt='点击这里给我发消息' title='点击这里给我发消息'></a>&nbsp;&nbsp;<a href='#'><a
									target='_blank'
									href='http://wpa.qq.com/msgrd?v=3&uin=2355862568&site=qq&menu=yes'><img
									border='0' src='http://wpa.qq.com/pa?p=2:2355862568:41'
									alt='点击这里给我发消息' title='点击这里给我发消息'></a>&nbsp;&nbsp;
									
									</td>
									
							</tr>
							<tr>
								<td class='tableheader2'><b> (投诉建议 工作时间:周一至周六 08:00
								- 17:30电话：18358197978)</b></td>
							</tr>
							
							

						</tbody>
					</table>
				</ww:if></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<div style="height: 15px; line-height: 15px;"></div>
</div>
</form>
<div style="height: 10px; line-height: 10px;"></div>
</div>
</div>


<script type="text/javascript">
/**
 * Extjs消息提示框
 * MsgTip.msg('消息标题', '消息内容');//不自动隐藏
 * MsgTip.msg('消息标题', '消息内容',true);//默认5秒后自动隐藏
 * MsgTip.msg('消息标题', '消息内容',true,10);//10秒后自动隐藏
 */
MsgTip = function(){
    var msgCt;
    function createBox(t, s){
        return ['<div>', 
               
                '<div><div><div style="font-size=12px;"><h3>', t, '</h3>', s, '</div></div></div>',
                
                '</div>'].join('');
    }
    return {
        msg : function(title, message,autoHide,pauseTime){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div22',style:'position:absolute;top:10px;width:513px;margin:0 auto;z-index:20000;'}, true);
            }
            msgCt.alignTo(document, 't-t');
            //给消息框右下角增加一个关闭按钮
            message+='<br><span style="text-align:right;font-size:12px; width:100%;">' +
              '<font color="blank"><u style="cursor:hand;" onclick="MsgTip.hide(this);">关闭</u></font></span>'
            var m = Ext.DomHelper.append(msgCt, {html:createBox(title, message)}, true);
            m.slideIn('t');
            if(!Ext.isEmpty(autoHide)&&autoHide==true){
             if(Ext.isEmpty(pauseTime)){
              pauseTime=5;
             }
             m.pause(pauseTime).ghost("tr", {remove:true});
            }
        },
        hide:function(v){
         var msg=Ext.get(v.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement);
         msg.ghost("tr", {remove:true});
        }
    };
}();
<ww:if test="#request.first!=null">
Ext.onReady(function(){

 //showMsg();
  
});   
</ww:if>
function showMsg(){
Ext.BLANK_IMAGE_URL = 'extjs/resources/image/default/s.gif';
 Ext.QuickTips.init();
 var cnmessages='<img src="images/linshi.png"/>';
    MsgTip.msg('', cnmessages);
}


</script>
</body>
</html>
