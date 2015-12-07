<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>B2B2C电子商务</title>
 <link href="../css/base.css" rel="stylesheet" />
<link href="../js/autocomplete/jquery.autocomplete.css" rel="stylesheet" />
<script type="text/javascript" src="../js/util.js"></script>
<script type="text/javascript" src="../js/autocomplete/jquery.js"></script>
<script type="text/javascript" src="../js/autocomplete/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="../js/validate/check.js"></script>
<script language="JavaScript">

	var liver = parseInt('<ww:property value="hotelorder.prerooms"/>') ;
	$(document).ready(function() {
		$('#bookroomnum').keyup(function() {
			if(parseInt($('#bookroomnum').val()) > 30) {
				$('#bookroomnumtip').remove() ;
				$('#bookroomnum').parent().append('<span id="bookroomnumtip" style="color:red">预订的房间数量不能超过30</span>') ;
				return ;
			}
			$('#bookroomnumtip').remove() ;
			if($('#bookroomnum').val() - liver > 0) {
				for(var i=0; i<$('#bookroomnum').val() - liver; i++) {
					$('#livertable').append('<tr class="livertr">' +
	                    '<td height="28" class="font-huise" align="right"><font style="color:red">*</font>入住人姓名： </td>' +
	                    '<td><input name="h_guest" type="text" id="textfield6" style="WIDTH: 115px" value="" /><input type="button" onclick="hotel_common_liver_toggle(this)"  class="liveaddbutton' + (liver + i + 1) + '" abbr="' + (liver + i + 1) + '" value="常用入住人"/></td>' +
	                  '</tr>' +
	                 ' <tr style="display:none" class="commonlivertr' + (liver + i + 1) + '">' +
                    '<td width="150" height="28" align="right" class="font-huise">我的常用入住人中查找 </td>' +
                   ' <td width="567" align="right"><span class="font-huise">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>' +
                 ' </tr>' +
                  '<tr style="display:none" class="commonlivertr' + (liver + i + 1) + '">' +
                    '<td height="28" colspan="2"  bgcolor="#feeeaa" class="font-huise" align="center">' +
                    	'<table width="90%">' +
                    		'<tr>' +
                      '<ww:iterator value="genusers" status="genusersStatus">' +
                      		'<ww:if test="#genusersStatus.index % 7 == 0">' + 
                      			'</tr>' +
                      			'<tr>' + 
                      		'</ww:if>' +
                      	  '<td><input type="radio"  onclick="hotel_commonliverradio(this)" class="comradio' + (liver + i + 1) + '"  abbr="' + (liver + i + 1) + '" name="h_guestradio" id="checkbox7" value="<ww:property value="name"/>"/><span class="font-huise">&nbsp;&nbsp;<ww:property value="name"/></span></td> ' +
                      '</ww:iterator>' +
                      '</tr>' +
                    '</td>' +
                  '</tr>') ;
	            }
	           
			} else if($('#bookroomnum').val() - liver < 0) {
				$('.livertr:gt(' + (parseInt($('#bookroomnum').val()))+ ')',$('#livertable')).remove();
			}
			liver = $('#bookroomnum').val() ;
		}) ;
	}) ;
	
	function hotel_common_liver_toggle(com) {
		if('none' == $('.commonlivertr' + $(com).attr('abbr')).css('display')) {
			$('.commonlivertr' + $(com).attr('abbr')).css('display','') ;
		} else  {
			$('.commonlivertr' + $(com).attr('abbr')).css('display','none') ;
		}
	}
	
	function hotel_commonliverradio(comradio) {
		$('input:first',$('.liveaddbutton' + $(comradio).attr('abbr')).parent()).val($(comradio).val()) ;
		$('.commonlivertr' + $(comradio).attr('abbr')).toggle() ;
	}
	
	function hotel_validate_form() {
		var validate = true ;
		$('span',$('#linkname').parent()).remove() ;
		if($.trim($('#linkname').val()) == '') {
			$('#linkname').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;联系人姓名不许为空</span>') ;
			$('#linkname').focus();
			validate = false ;
		}
		$('span',$('#linkmobile').parent()).remove() ;
		if($.trim($('#linkmobile').val()) == '') {
			$('#linkmobile').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;联系人手机不许为空</span>') ;
			$('#linkmobile').focus();
			validate = false ;
		} else {
			if(!/^(((13[0-9]{1})|150|151|152|153|156|158|159)+\d{8})$/.test($.trim($('#linkmobile').val()))) {
				$('#linkmobile').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;联系人手机的格式错误</span>') ;
				$('#linkmobile').focus();
				validate = false ;
			}
		}
		$('span',$('#linkmail').parent()).remove() ;
		if($.trim($('#linkmail').val()) != '' && !/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i.test($.trim($('#linkmail').val()))) {
			$('#linkmail').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;Email的格式错误</span>') ;
			$('#linkmail').focus();
			validate = false ;
		}
		$('span',$('#linktell').parent()).remove() ;
		if($.trim($('#linktell').val()) != '' && !/^((\(\d{3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-|0\d{2,3})[1-9]\d{6,7}$/.test($.trim($('#linktell').val()))) {
			$('#linktell').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;联系人固定电话的格式错误</span>') ;
			$('#linktell').focus();
			validate = false ;
		}
		$('span',$('#confirm').parent()).remove() ;
		if($.trim($('#confirm').val()) == '') {
			$('#confirm').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;确认方式不许为空</span>') ;
			$('#confirm').focus();
			validate = false ;
		} else {
			if($.trim($('#linkmail').val()) == '' && parseInt($.trim($('#confirm').val())) > 1) {
				$('#confirm').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;联系人邮箱为空只能选择短信确认</span>') ;
				$('#confirm').focus();
				validate = false ;
			}
		}
		$('span',$('#bookroomnum').parent()).remove() ;
		if($.trim($('#bookroomnum').val()) == '') {
			$('#bookroomnum').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;房间数不能为空</span>') ;
			$('#bookroomnum').focus();
			validate = false ;
		}
		$('span',$('#bookroomnum').parent()).remove() ;
		if($.trim($('#bookroomnum').val()) == '0') {
			$('#bookroomnum').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;房间数必须大于0</span>') ;
			$('#bookroomnum').focus();
			validate = false ;
		}
		$('span',$('#h_saveendtime').parent()).remove() ;
		var op2 = $('#h_savestarttime').val() ;
		var op1 = $('#h_saveendtime').val() ;
		var h_reservstart1 = parseFloat(op2.substring(0,2)) + (parseFloat(op2.substring(3,5)) == 30 ? 0.5 : 0);
		var h_reservend1 = parseFloat(op1.substring(0,2)) + (parseFloat(op1.substring(3,5)) == 30 ? 0.5 : 0);
		if(h_reservend1 - h_reservstart1 > 4 || h_reservend1 - h_reservstart1 < 0) {
			$('#h_saveendtime').parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;最晚抵达时间不能大于最早抵达时间4个小时</span>') 
			validate = false ;
		}
		$("input[name='h_guest']").each(function() {
			$('span',$(this).parent()).remove() ;
			if($.trim($(this).val()) == '' ){ 
				$(this).parent().append('<span  class="font-huise" style="color:red">&nbsp;&nbsp;入住人姓名不许为空</span>') 
				validate = false ;
			}
		}) ;
		return validate ;
	}
	
	function hotel_savetime_change(save) {
		$('span',$('#h_saveendtime').parent()).remove() ;
		var op2 = $('#h_savestarttime').val() ;
		var op1 = $('#h_saveendtime').val() ;
		var h_reservstart1 = parseFloat(op2.substring(0,2)) + (parseFloat(op2.substring(3,5)) == 30 ? 0.5 : 0);
		var h_reservend1 = parseFloat(op1.substring(0,2)) + (parseFloat(op1.substring(3,5)) == 30 ? 0.5 : 0);
		if(h_reservend1 - h_reservstart1 > 4 || h_reservend1 - h_reservstart1 < 0) {
			$('#h_saveendtime').parent().append('<span  class="font-huise" style="color:red">最晚抵达时间不能大于最早抵达时间4个小时</span>') 
			if($(save).attr('name') == 'h_saveendtime') {
				var op1bak = parseFloat(op1.substring(0,2)) - 4 ;
				if(op1bak < 0) {
					$('#h_savestarttime').val("00:00") ;
				} else {
					if(op1bak < 10){
						op1bak = "0" + op1bak + ":" + op1.substring(3,5) ;
					}else{
						op1bak = "" + op1bak + ":" + op1.substring(3,5) ;
					}
					$('#h_savestarttime').val(op1bak) ;
				}
			} else if($(save).attr('name') == 'h_savestarttime'){
				var op2bak = parseFloat(op2.substring(0,2)) + 4 ;
				if(op2bak > 23) {
					$('#h_saveendtime').val("23:30") ;
				} else {
					if(op2bak < 10){
						op2bak = "0" + op2bak + ":" + op2.substring(3,5) ;
					}else{
						op2bak = "" + op2bak + ":" + op2.substring(3,5) ;
					}
					$('#h_saveendtime').val(op2bak) ;
				}
			}
		}
	}
</script>
</head>
<body>
<table width="99%" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td>
       <table class="border-grey" cellspacing="0" style="border:0px solid #9e9e9e;"  cellpadding="0">
         <tr>
	        <td>
		        <form action="hotelbook!tobrowse.action" method="post" name="method" onSubmit="return hotel_validate_form()">
				    <input type="hidden" name="h_hotelid" value="<ww:property value="hotel.id"/>" />
				    <input type="hidden" name="roomtype.id" value="<ww:property value="roomtype.id"/>" />
				    <input type="hidden" name="h_perprices" value="<ww:property value="h_perprices"/>" />
				    <input type="hidden" name="startDate" value="<ww:property value="startDate"/>" />
				    <input type="hidden" name="endDate" value="<ww:property value="endDate"/>" />
				    <input type="hidden" name="memberid" value="<ww:property value="member.id" />" />
					<table width="99%" border="0" cellpadding="0" cellspacing="0" align="center"  style="border:1px solid #99CBED; margin-bottom:4px;">
						<tr>
					   		<td height="29" class="box-bottom bg"><span class="font-blue-cu">填写&nbsp;&nbsp;&nbsp;<ww:property value="hotel.name"/>&nbsp;&nbsp;&nbsp;预订单</span></td>
					  	</tr>
				        <tr>
				        	<td>
				            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
					              <tr>
					                <td width="100%" height="29" background="../images/jb.gif">&nbsp;&nbsp;&nbsp;&nbsp;<span class="font-grey4">&nbsp;您的预订信息</span></td>
					              </tr>
				            	</table>
				        	</td>
				        </tr>
				          <tr>
				            <td valign="top">
				            	<table width="100%" class="border-grey"cellspacing="0" style="border:1px solid #a0cfee;" cellpadding="0">
					              <tr>
					              	<td width="64"></td>
					                <td height="104">
					                <table width="592" border="0" align="center" cellpadding="0" cellspacing="0">
					                  <tr>
					                    <td width="308" height="28">
					                    	<span class="font-huise">住店时间：</span>
					                    	<span class="font-huangse-cu"><ww:property value="startDate"/></span>  
					                    	<span class="font-huise">至</span> 
					                    	<span class="font-huangse-cu"><ww:property value="endDate"/></span>
					                    	<span class="font-huise">（共<ww:property value="getBookDay(startDate,endDate)"/>晚）</span>
					                    </td>
					                    <td width="284">
					                    	<span class="font-huise">酒店名称：</span>
					                    	<span class="font-huangse-cu"><ww:property value="hotel.name"/></span>
					                    </td>
					                  </tr>
					                  <tr>
					                    <td height="28" class="font-huise">
					                    	<span class="font-huise">客房类型：</span>
					                    	<span class="font-huangse-cu"><ww:property value="roomtype.name"/></span>
					                    </td>
					                    <td>
					                    	<span class="font-huise">付款方式：</span>
					                    	<span class="font-huangse-cu">前台现付</span>
					                    </td>
					                  </tr>
					                </table>                 
					              </td>
					            </tr>
				              </table>
		                  </td>
		               </tr>
		          	   <tr>
            			<td>
	            			<table width="100%" border="0" cellspacing="0" border="1" cellpadding="0" style="margin-top: 12px;">
				              <tr>
				                <td width="99%" height="29" background="../images/jb.gif">
				                	&nbsp;&nbsp;&nbsp;&nbsp;
				                	<span class="font-grey4">&nbsp;预订联系人信息</span>
				                </td>
				              </tr>
	            			</table>
            		    </td>
          	  		  </tr>
	          		  <tr>
		            	<td>
		            	<table width="721" class="border-grey"cellspacing="0" style="border:1px solid #a0cfee;"  cellpadding="0">
			              <tr>
			              	<td width="64"></td>
			                <td height="200">
			                	<table width="592" border="0" align="center" cellpadding="0" cellspacing="0">
				                  <tr>
				                    <td width="130" height="28" align="right">
				                    	<span class="font-huise"><font style="color:red">*</font>联系人姓名： </span>
				                    </td>
				                    <td width="512">
				                    	<input name="linkname" type="text" id="linkname" style="WIDTH: 115px" 
				                    	value="<ww:property value="getOrderUserLogin().membername"/>" />
				                    </td>
				                  </tr>
				                  <tr>
				                    <td height="28" class="font-huise" align="right"><font style="color:red">*</font>联系人手机：</td>
				                    <td>
				                    	<input name="linkmobile" type="text" id="linkmobile" style="WIDTH: 115px" 
				                    	value="<ww:property value="getOrderUserLogin().mobile"/>" />
				                    </td>
				                  </tr>
				                  <tr>
				                    <td height="28" class="font-huise" align="right">联系人邮箱：</td>
				                    <td>
				                    	<input name="linkmail" type="text" id="linkmail" style="WIDTH: 115px" 
				                    	value="<ww:property value="hotelorder.linkmail" />" />
				                    </td>
				                  </tr>
				                  <tr>
				                    <td height="28" class="font-huise" align="right">联系人固定电话：</td>
				                    <td  class="font-huise">
				                    	<input name="linktell" type="text" id="linktell" style="WIDTH: 115px" 
				                    	value="<ww:property value="hotelorder.linktell" />" />(例如:010-85855555)
				                    </td>
				                  </tr>
				                  <tr>
				                    <td height="28" align="right">
				                    	<span class="font-huise"><font style="color:red">*</font>确认方式：</span>
				                    	<span class="font-chense-cu"></span>
				                    </td>
				                    <td>
					                    <select id="confirm" name="confirmmethod" style="WIDTH: 120px">
				                    	 	<option value="1" selected="selected">短信确认</option>
				                    	 	<option value="2">Email确认</option>
				                    	 	<option value="3">短信和Email确认</option>
					                    </select>
					                </td>
				                  </tr>
				                  <tr>
				                    <td height="28" class="font-huise" align="right">预订备注：</td>
				                    <td>
				                    	<textarea name="predesc"><ww:property value="predesc"/></textarea>
				                    </td>
				                  </tr>
			                	</table>                  
			                </td>
			                <td width="64"></td>
			              </tr>
		           	    </table>
		            </td>
	          	</tr>
	          	<tr>
		            <td>
		            	<table width="721" border="0" cellspacing="0" cellpadding="0" style="margin-top: 12px;">
			              <tr>
			                <td width="99%" height="29" background="../images/jb.gif">
			                	&nbsp;&nbsp;&nbsp;&nbsp;
			                	<span class="font-grey4">&nbsp;入住人联系信息</span>
			                </td>
			              </tr>
		            	</table>
		            </td>
	          	</tr>
         	 	<tr>
		            <td>
		            	<table width="721" class="border-grey" cellspacing="0" cellpadding="0">
			              <tr>
			                <td width="719">
				                <table id="livertable" width="717" border="0" align="left"  cellpadding="0" cellspacing="0">
				                  <tr class="livertr">
				                    <td width="150" height="28" align="right" class="font-huise"><font style="color:red">*</font>预订的间数： </td>
				                    <td width="567"><span class="font-chense">
				                      <input type="text" id="bookroomnum" name="prerooms" style="WIDTH: 35px" 
				                      value="<ww:property value="hotelorder.prerooms" />" />&nbsp;间</span>
				                     </td>
				                  </tr>
				                 <ww:iterator value="h_guest" status="h_guestStatus">
					                  <tr class="livertr">
					                    <td height="28" class="font-huise" align="right"><font style="color:red">*</font>入住人姓名： </td>
					                    <td><input name="h_guest" type="text" id="textfield6" style="WIDTH: 115px" value="<ww:property />" />
					                    	<input type="button" abbr="<ww:property value="#h_guestStatus.index + 1"/>" 
					                    		onclick="hotel_common_liver_toggle(this)" class="liveaddbutton<ww:property value="#h_guestStatus.index + 1"/>" value="常用入住人"/>
					                    </td>
					                  </tr>
					                  <tr style="display:none" class="commonlivertr<ww:property value="#h_guestStatus.index + 1"/>">
					                    <td width="150" height="28" align="right" class="font-huise">我的常用入住人中查找 </td>
					                    <td width="567" align="right"><span class="font-huise">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></td>
					                  </tr>
					                  <tr style="display:none" class="commonlivertr<ww:property value="#h_guestStatus.index + 1"/>">
					                    <td height="28" colspan="2"  bgcolor="#feeeaa" class="font-huise" align="center">
					                    	<table width="90%">
					                    	<tr>
					                      		<ww:iterator value="listcustomerpassenger" status="genusersStatus">
					                      			<ww:if test="#genusersStatus.index % 7 == 0">
					                      				</tr>
					                      				<tr>
					                      			</ww:if>
					                      	  	<td>
					                      	  		<input type="radio" class="comradio<ww:property value="#h_guestStatus.index + 1"/>" 
					                      	  			abbr="<ww:property value="#h_guestStatus.index + 1"/>" onclick="hotel_commonliverradio(this)" 
					                      	  				name="h_guestradio" id="checkbox7" value="<ww:property value="username"/>"/>
					                      	  		<span class="font-huise">&nbsp;&nbsp;<ww:property value="username"/></span>
					                      	  	</td>
					                      	  
					                      </ww:iterator>
					                      </tr>
					                      </table>
					                    </td>
					                  </tr>
				                  </ww:iterator>
				              </table>                  
			               </td>
			              </tr>
		            	</table>
		            </td>
	          	</tr>
	          	<tr>
		            <td>
		            	<table width="100%" border="0" cellspacing="0"  cellpadding="0" style="margin-top: 12px;">
			              <tr>
			                <td width="100%" height="29" background="../images/jb.gif">&nbsp;&nbsp;&nbsp;&nbsp;<span class="font-grey4">&nbsp;抵店时间和保留时间</span></td>
			              </tr>
		            	</table>
		            </td>
	          	</tr>
	          	<tr>
            	  <td>
            		<table width="100%" class="border-grey"cellspacing="0" style="border:1px solid #a0cfee;"  cellpadding="0">
              			<tr>
              				<td width="64"></td>
                			<td height="75"><table width="592" border="0" align="center" cellpadding="0" cellspacing="0">
                  		<tr>
                    		<td height="28" colspan="2" class="font-huise">请认真填写以下信息，酒店将根据您填写的信息提前安排时间</td>
                    	</tr>
                  		<tr>
                    		<td width="108" height="28"><span class="font-huise"><font style="color:red">*</font>预订抵店时间：</span><span class="font-chense-cu"></span></td>
                    		<td width="484">
		                    	<select id="h_savestarttime" name="h_savestarttime" style="WIDTH: 120px" onchange="hotel_savetime_change(this)">
					 	 			<option value="00:00">00:00</option>
					 	 			<option value="00:30">00:30</option>
					 	 			<option value="01:00">01:00</option>
					 	 			<option value="01:30">01:30</option>
					 	 			<option value="02:00">02:00</option>
					 	 			<option value="02:30">02:30</option>
					 	 			<option value="03:00">03:00</option>
					 	 			<option value="03:30">03:30</option>
					 	 			<option value="04:00">04:00</option>
					 	 			<option value="04:30">04:30</option>
					 	 			<option value="05:00">05:00</option>
					 	 			<option value="05:30">05:30</option>
					 	 			<option value="06:00">06:00</option>
					 	 			<option value="06:30">06:30</option>
					 	 			<option value="07:00">07:00</option>
					 	 			<option value="07:30">07:30</option>
					 	 			<option value="08:00">08:00</option>
					 	 			<option value="08:30">08:30</option>
					 	 			<option value="09:00">09:00</option>
					 	 			<option value="09:30">09:30</option>
					 	 			<option value="10:00">10:00</option>
					 	 			<option value="10:30">10:30</option>
					 	 			<option value="11:00">11:00</option>
					 	 			<option value="11:30">11:30</option>
					 	 			<option value="12:00" selected="selected">12:00</option>
					 	 			<option value="12:30">12:30</option>
					 	 			<option value="13:00">13:00</option>
					 	 			<option value="13:30">13:30</option>
					 	 			<option value="14:00">14:00</option>
					 	 			<option value="14:30">14:30</option>
					 	 			<option value="15:00">15:00</option>
					 	 			<option value="15:30">15:30</option>
					 	 			<option value="16:00">16:00</option>
					 	 			<option value="16:30">16:30</option>
					 	 			<option value="17:00">17:00</option>
					 	 			<option value="17:30">17:30</option>
					 	 			<option value="18:00">18:00</option>
					 	 			<option value="18:30">18:30</option>
					 	 			<option value="19:00">19:00</option>
					 	 			<option value="19:30">19:30</option>
					 	 			<option value="20:00">20:00</option>
					 	 			<option value="20:30">20:30</option>
					 	 			<option value="21:00">21:00</option>
					 	 			<option value="21:30">21:30</option>
					 	 			<option value="22:00">22:00</option>
					 	 			<option value="22:30">22:30</option>
					 	 			<option value="23:00">23:00</option>
					 	 			<option value="23:30">23:30</option>
								</select>
                      			<span class="font-huise">
                      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      				<font style="color:red">*</font>最晚抵店时间：
		                      		<select id="h_saveendtime" name="h_saveendtime" style="WIDTH: 120px" onchange="hotel_savetime_change(this)">
			                      		<option value="00:00">00:00</option>
						 	 			<option value="00:30">00:30</option>
						 	 			<option value="01:00">01:00</option>
						 	 			<option value="01:30">01:30</option>
						 	 			<option value="02:00">02:00</option>
						 	 			<option value="02:30">02:30</option>
						 	 			<option value="03:00">03:00</option>
						 	 			<option value="03:30">03:30</option>
						 	 			<option value="04:00">04:00</option>
						 	 			<option value="04:30">04:30</option>
						 	 			<option value="05:00">05:00</option>
						 	 			<option value="05:30">05:30</option>
						 	 			<option value="06:00">06:00</option>
						 	 			<option value="06:30">06:30</option>
						 	 			<option value="07:00">07:00</option>
						 	 			<option value="07:30">07:30</option>
						 	 			<option value="08:00">08:00</option>
						 	 			<option value="08:30">08:30</option>
						 	 			<option value="09:00">09:00</option>
						 	 			<option value="09:30">09:30</option>
						 	 			<option value="10:00">10:00</option>
						 	 			<option value="10:30">10:30</option>
						 	 			<option value="11:00">11:00</option>
						 	 			<option value="11:30">11:30</option>
						 	 			<option value="12:00">12:00</option>
						 	 			<option value="12:30">12:30</option>
						 	 			<option value="13:00">13:00</option>
						 	 			<option value="13:30">13:30</option>
						 	 			<option value="14:00">14:00</option>
						 	 			<option value="14:30">14:30</option>
						 	 			<option value="15:00">15:00</option>
						 	 			<option value="15:30">15:30</option>
						 	 			<option value="16:00" selected="selected">16:00</option>
						 	 			<option value="16:30">16:30</option>
						 	 			<option value="17:00">17:00</option>
						 	 			<option value="17:30">17:30</option>
						 	 			<option value="18:00">18:00</option>
						 	 			<option value="18:30">18:30</option>
						 	 			<option value="19:00">19:00</option>
						 	 			<option value="19:30">19:30</option>
						 	 			<option value="20:00">20:00</option>
						 	 			<option value="20:30">20:30</option>
						 	 			<option value="21:00">21:00</option>
						 	 			<option value="21:30">21:30</option>
						 	 			<option value="22:00">22:00</option>
						 	 			<option value="22:30">22:30</option>
						 	 			<option value="23:00">23:00</option>
						 	 			<option value="23:30">23:30</option>
									</select>
                      			</span>
                     		</td>
                  		  </tr>
                	  </table>                  
                	 </td>
                	<td width="64"></td>
              	  </tr>
               </table>
             </td>
           </tr>
           <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top: 12px;">
              <tr>
                <td width="100%" height="29" background="../images/jb.gif">&nbsp;&nbsp;&nbsp;&nbsp;<span class="font-grey4">&nbsp;备注（我有特殊要求）</span></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td>
            	<table width="100%" class="border-grey" style="border:1px solid #a0cfee;"  cellspacing="0" cellpadding="0">
              		<tr>
                		<td width="719" height="90" align="center">
                  			<label>
                    			<textarea name="specreq" id="specreq" cols="85" rows="3" style="border:1px solid #a0cfee;"><ww:property value="specreq"/></textarea>
                    		</label>
           				</td>
              		</tr>
            	</table>
            </td>
          </tr>
          <tr>
            <td height="48" align="center">
	            <table width="100%" border="0" align="center"  cellpadding="0" cellspacing="0">
	              <tr>
	                <td width="150" align="center">
	                  <label>
	                  <input name="button" type="button"  class="button_d font-white" id="button" value="上一步" />
	                  </label></td>
	                <td width="150" align="center"><input name="button2" type="submit" class="button_d font-white" id="button2" value="下一步" /></td>
	              </tr>
	            </table>
	        </td>
          </tr>
         </table>
      </form>
    </td>
  </tr>
  </table>
    </td>
  </tr>
</table>
</body>
</html>
