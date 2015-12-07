function loadingoverlay(message) {
    $.blockUI({
        message: message,
        css: {
            border: 'none',
            padding: '15px',
            width: '700px',
            height: '400',
            top: '100px',
            left:'300px',
            backgroundColor: '#1999c4',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            color: '#000'
        }
    });
}

//usrurl:ajax调用后台页面地址
function ValidateExist(usrurl)
      {
         //定义一个bool型变量
         var chk=true;
         if (chk){
            //获取从验证页面中异步传输过来的值
            var sta=GetResponseText(usrurl);
                if(sta==1){
                   //验证通过
                    chk=true;   
                    //用于显示验证是否通过的详细信息加上刚刚所定义正确时的样式
                    
                }else if(sta==0){
                    //验证未通过
                    chk=false;
                    //用于显示验证是否通过的详细信息加上刚刚所定义错误时的样式
                }
        }else{
            return false;
        }
        return chk;
      }
      function GetResponseText(url)
      {
          //定义一个http_request变量
           var http_request;
            if (window.XMLHttpRequest) {
                    //对于Mozilla、Netscape、Safari等浏览器，创建XMLHttpRequest对象
                    http_request = new XMLHttpRequest();
                    if (http_request.overrideMimeType) {
                            //如果服务器响应的header不是text/xml，可以调用其它方法修改该header
                            http_request.overrideMimeType('text/xml');
                    }
            } else if (window.ActiveXObject) {
                    // 对于Internet Explorer浏览器，创建XMLHttpRequest
                    try {
                            http_request = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                            try {
                                    http_request = new ActiveXObject("Microsoft.XMLHTTP");
                            } catch (e) {}
                    }
            }
            //打开验证页面的地址
           http_request.open('GET', url, false);
           http_request.send(null);
            var  requestdoc="";
               if (http_request.readyState == 4)
        　　     {
            　　　    // 收到完整的服务器响应
                　　　    if (http_request.status == 200) {
                    　　        //HTTP服务器响应的值OK
                        　　　　    requestdoc = http_request.responseText;
                    }
            　　　       else {
        　　　　      requestdoc = "error";
    　　　       }
　　      }
        return requestdoc;
      }

//是否为空
function IsEmpty(txtValue)
{
	var exp = /^\s*$/;
	return (exp.test(txtValue));
}

//是否为整数

function IsInteger(txtValue){
	var exp, op;
	op = txtValue;
    exp = /^\s*[-\+]?\d+\s*$/;
    if (op.match(exp) == null){ 
        return false;
    }else{
		return true;
    }
}

//是否是中文

function IsCharacter(txtValue)
{
   var exp;
   exp=new RegExp("[\u4e00-\u9fa5]");
   if(txtValue.match(exp)==null) return false;
   else return true;
}

function getOs() {
    var OsObject = "";
    if (navigator.userAgent.indexOf("MSIE") > 0) {
        return "MSIE";
    }
    if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
        return "Firefox";
    }
    if (isSafari = navigator.userAgent.indexOf("Safari") > 0) {
        return "Safari";
    }
    if (isCamino = navigator.userAgent.indexOf("Camino") > 0) {
        return "Camino";
    }
    if (isMozilla = navigator.userAgent.indexOf("Gecko/") > 0) {
        return "Gecko";
    }
}


//Checkbox 至少一个选中--gaochao--0821--
function chkCheckBoxChs(objNam)
{ 
    var obj = document.getElementById(objNam); 
    var objYN=false;;
    var rbsl= obj.getElementsByTagName("INPUT");
    for(var i = 0;i<rbsl.length;i++)
    {
        if (rbsl[i].checked==true) 
        {   
            objYN = true;
            break;
        }
    }
    return objYN;
}

//电话号码是否为正确格式

function IsTelephone(TelValue)
{
	var i,j,strTemp,len;
	len=TelValue.length;
	if(len<8 || len>32)	return false;
	strTemp="0123456789-()# ";
	for (i=0;i<len;i++){
		j=strTemp.indexOf(TelValue.charAt(i));
		if (j==-1) return false;
	}
	return true;
}

//手机号是否为正确格式
function IsMobile(MobilValue)
{
    var MobileRe = /^(013|13|8613|015|15|8615|18|15|14)\d{9}$/;
	
	return MobileRe.test(MobilValue);
}


//票号是否为正确格式
function IsTicketNumber(TicketNumber) {
    var exp, op;
    op = TicketNumber;
    exp = new RegExp("^[0-9]{3}[-]{1}[0-9]{10}$");
    if (op.match(exp) == null) return false;
    else return true;
}

//电子邮件验证
function IsEMail(txtEMail)
{
	if (txtEMail.length > 150)
		return false;
	if(txtEMail == "") return true;
	var regu = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*[0-9a-zA-Z]+))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|NET|com|COM|gov|GOV|mil|MIL|org|ORG|edu|EDU|int|INT)$"
	var re = new RegExp(regu);
	if (txtEMail.search(re) != -1)
		return true;
	else
		return false;
}

//是否为数字

function IsNumber(txtValue){
	var exp, op;
	op = txtValue;
    exp = /^((\d{1,3}(,\d{3})*?)|\d+)(\.\d{1,2})?$/;
    if (op.match(exp) == null){ 
        return false;
    }else{
		return true;
    }
}

//检验英文名称
function CheckName(passenernames)
{
    var regnameen = /^[a-zA-Z]{1,20}[\/]{1}[a-zA-Z]{1,20}[0-9]{0,8}$/;//英文名
    if(!regnameen.exec(passenernames))
    {
        alert("英文名称格式不正确！");
        return false;
    }
    return true;
}

//验证邮政编码
 function IsPostalCode(you)
  {  
    var exp, op;
	op = you;
	exp = new RegExp("^[0-9]{6}$");
    if(op.match(exp)==null) return false;
    else return true;
  }
  //验证身份证格式
  function shenfen(str) {

      var aCity = { 11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外" }

      var iSum = 0
      var info = ""
      if (!/^\d{17}(\d|x)$/i.test(str) && !/^\d{15}/i.test(str)) {

          return false;
      }
      str = str.replace(/x$/i, "a");
      if (aCity[parseInt(str.substr(0, 2))] == null) {

          return false;
      }
      var sBirthday;
      if (str.length == 18) {
          sBirthday = str.substr(6, 4) + "-" + Number(str.substr(10, 2)) + "-" + Number(str.substr(12, 2));
          var d = new Date(sBirthday.replace(/-/g, "/"))
          if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate())) {

              return false;
          }
      }
      else if (str.length == 15) {
          sBirthday = "19" + str.substr(6, 2) + "-" + Number(str.substr(8, 2)) + "-" + Number(str.substr(10, 2));
          var d = new Date(sBirthday.replace(/-/g, "/"))
          if (sBirthday != (d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate())) {

              return false;
          }
      }
      else {

          return false;
      }
      return true;
  }


  /**
  * 判断身份证号码为18位时最后的验证位是否正确
  * 
  * @param a_idCard
  *          身份证号码数组
  * @return
  */
  function isTrueValidateCodeBy18IdCard(idCard) {
      var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1]; // 加权因子
      var ValideCode = [1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2]; // 身份证验证位值.10代表X
      var sum = 0; // 声明加权求和变量
      for (var i = 0; i < 17; i++) {
          var tempnum = idCard[i];
          if (tempnum == 'x' || tempnum == 'X') {
              tempnum = 10; // 将最后位为x的验证码替换为10方便后续操作
          }
          sum += Wi[i] * tempnum; // 加权求和
      }
      var valCodePosition = sum % 11; // 得到验证码所位置
      var a_idCard_num = idCard[17];
      if (a_idCard_num == 'x' || a_idCard_num == 'X') {
          a_idCard_num = 10;
      }
      if (a_idCard_num == ValideCode[valCodePosition]) {
          return true;
      } else {
          return false;
      }
  }