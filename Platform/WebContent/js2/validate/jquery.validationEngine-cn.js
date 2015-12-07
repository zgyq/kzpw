(function($) {
	$.fn.validationEngineLanguage = function() {};
	$.validationEngineLanguage = {
		newLang: function() {
			$.validationEngineLanguage.allRules = 	{
					
					"required":{    			// Add your regex rules here, you can take telephone as an example
						"regex":"none",
						"alertText":"不能为空",
						"alertTextCheckboxMultiple":"请至少选择一项",
						"alertTextCheckboxe":"必填"},
					"length":{
						"regex":"none",
						"alertText":"从",
						"alertText2":" 到 ",
						"alertText3": " 个字符"},
					"maxCheckbox":{
						"regex":"none",
						"alertText":"必选项"},	
					"minCheckbox":{
						"regex":"none",
						"alertText":"请选择",
						"alertText2":" options"},	
					"confirm":{
						"regex":"none",
						"alertText":"两次输入不同"},	
					"cardnumber":{
						"regex":"none",
						"alertText":"no"},
					"ticketdate":{
						"regex":"none",
						"alertText":"no"},
					"ticketdate2":{
						"regex":"none",
						"alertText":"no"},
					"vcity":{
						"regex":"none",
						"alertText":"不能为空"},		
					"telephoneandmobile":{
						"regex":"(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$",
						"alertText":"电话号码或手机号输入错误"},	
					"telephone":{
						"regex":"/^[0-9\-\(\)\ ]+$/",
						"alertText":"电话号码输入错误"},	
					"mobile":{
						"regex":"/^1[3,5,6,7,8,9,4]{1}[0-9]{1}[0-9]{8}$/",
						"alertText":"手机号码输入错误"},	
					"email":{
						"regex":"/^[a-zA-Z0-9_\.\-]+\@([a-zA-Z0-9\-]+\.)+[a-zA-Z0-9]{2,4}$/",
						"alertText":"邮箱格式错误"},	
					"date":{
                         "regex":"/^[0-9]{4}\-\[0-9]{1,2}\-\[0-9]{1,2}$/",
                         "alertText":"日期格式错误"},
					"onlyNumber":{
						"regex":"/^[0-9\ ]+$/",
						"alertText":"只能输入数字"},
					"onlyDouble":{
						"regex":"/^[0-9\.]+$/",
						"alertText":"只输入数值"},
					"noSpecialCaracters":{
						"regex":"/^[0-9a-zA-Z]+$/",
						"alertText":"包含非法字符"},	
					"ticketENName":{ //机票英文姓名
						"regex":"/^[a-zA-Z]{1,20}[\/]{1}[a-zA-Z]{1,20}[0-9]{0,8}$/",
						"alertText":"机票英文姓名格式不正确"},
					"ticketCNName":{ //机票中文名称
						"regex":"/^[\u4E00-\u9FA5]{1,16}[a-zA-Z]{0,20}[0-9]{0,8}$|^[a-zA-Z]{1,20}[\/]{1}[a-zA-Z]{1,20}[0-9]{0,8}$/",
						"alertText":"机票中文/英文姓名格式不正确"},
					"ticketAirport":{ //是否是"中文/拼音"的字符
						"regex":"/[^中^文^/^拼^音]/",
						"alertText":"请选择城市"},
					"ajaxUser":{
						"file":"validateUser.php",
						"extraData":"name=eric",
						"alertTextOk":"* This user is available",	
						"alertTextLoad":"* Loading, please wait",
						"alertText":"* This user is already taken"},	
					"ajaxMobile":{
						"file":"vaidate!validatemobile.action",
						"extraData":"name=eric",
						"alertTextOk":"* 该手机号码可以使用！",	
						"alertTextLoad":"* 正在验证，请稍等！",
						"alertText":"* 手机号码已经存在！"},
					"ajaxCode":{
						"file":"vaidate!validatecode.action",
						"extraData":"name=eric",
						"alertTextOk":"* 该代码可以使用！",	
						"alertTextLoad":"* 正在验证，请稍等！",
						"alertText":"* 该代码已经存在！"},
					"ajaxMobileById":{
						"file":"vaidate!validatemobileById.action",
						"extraData":"name=eric",
						"alertTextOk":"* 该手机号码可以使用！",	
						"alertTextLoad":"* 正在验证，请稍等！",
						"alertText":"* 手机号码已经存在！"},
					"ajaxuserMobile":{
						"file":"vaidate!validateusermobile.action",
						"extraData":"name=eric",
						"alertTextOk":"* 该手机号码可以使用！",	
						"alertTextLoad":"* 正在验证，请稍等！",
						"alertText":"* 手机号码已经存在！"},
					"ajaxuserIDnumber":{
						"file":"vaidate!validateidnumber.action",
						"extraData":"name=eric",
						"alertTextOk":"* 该证件号码可以使用！",	
						"alertTextLoad":"* 正在验证，请稍等！",
						"alertText":"* 证件号码已经存在！"},
					"ajaxEmail":{
						"file":"vaidate!validateemail.action",
						"extraData":"name=eric",
						"alertTextOk":"* 该邮箱可以使用！",	
						"alertTextLoad":"* 正在验证，请稍等！",
						"alertText":"* 邮箱已经存在！"},
					"ajaxUsername":{
						"file":"vaidate!validateusername.action",
						"extraData":"name=eric",
						"alertTextOk":"* 该登录名可以使用！",	
						"alertTextLoad":"* 正在验证，请稍等！",
						"alertText":"* 该登录名已经存在！"},	
					"ajaxName":{
						"file":"validateUser.php",
						"alertText":"* This name is already taken",
						"alertTextOk":"* This name is available",	
						"alertTextLoad":"* Loading, please wait"},
					"ajaxticketnumber":{
						"file":"vaidate!validateticketnumber.action",
						"extraData":"name=eric",
						"alertTextOk":"* 该票号可以使用！",	
						"alertTextLoad":"* 正在验证，请稍等！",
						"alertText":"* 该票号已经存在票号段内！"},
					"onlyLetter":{
						"regex":"/^[a-zA-Z\ \']+$/",
						"alertText":"必须以字母开头"}
					}	
		}
	}
})(jQuery);

$(document).ready(function() {	
	$.validationEngineLanguage.newLang()
});