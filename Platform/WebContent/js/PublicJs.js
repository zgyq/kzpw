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

//票号格式是否正确
function IsTicketNumber(ticketnumber)
{
    var ticketnumRe=/[0-9]{3}[-][0-9]{10}$/;
    return ticketnumRe.test(ticketnumber);
}

//手机号是否为正确格式
function IsMobile(MobilValue)
{
	var MobileRe=/^(013|13|8613|015|15|8615|18|15|14)\d{9}$/;
	
	return MobileRe.test(MobilValue);
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
    exp = /^((\d{1,}(,\d{3})*?)|\d+)(\.\d{1,2})?$/;
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
function shenfen(str)
{

        var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"} 

        var iSum=0 
        var info="" 
        if(!/^\d{17}(\d|x)$/i.test(str) && !/^\d{15}/i.test(str))
        {
        
            alert("身份证位数不对！");
            return false; 
        }
        str=str.replace(/x$/i,"a"); 
        if(aCity[parseInt(str.substr(0,2))]==null)
        {
            alert("Error:非法地区");
            return false; 
        }
        var sBirthday;
        if(str.length==18)
        {
            sBirthday=str.substr(6,4)+"-"+Number(str.substr(10,2))+"-"+Number(str.substr(12,2)); 
            var d=new Date(sBirthday.replace(/-/g,"/")) 
            if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))
            {
                alert("Error:非法生日！"); 
                return false;
            }
        }
        else if(str.length==15)
        {
            sBirthday="19"+str.substr(6,2)+"-"+Number(str.substr(8,2))+"-"+Number(str.substr(10,2)); 
            var d=new Date(sBirthday.replace(/-/g,"/")) 
            if(sBirthday!=(d.getFullYear()+"-"+ (d.getMonth()+1) + "-" + d.getDate()))
            {
                alert("Error:非法生日！"); 
                return false;
            }
        }
        else
        {
           alert("身份证位数为15位或者18位!");
           return false;
        } 
        return true;
}
     //根据总票价和返点计算，折扣金额
	 //1130×3×0.01=33.9 -》 30
  function getzhekoujine(amtmoney,fandian)
  {
      var zhekoujine="";
      zhekoujine=Math.round(parseFloat(amtmoney)*fandian*0.01*0.1)*10;
	  return zhekoujine;
  }
  
  //判断当前查询报表的人数
function checkdata()
{
 jQuery.post('airreport!IsTooMuchUser.action','',function(data){
 if(data=="0")
  {
    dispose('数据已经导出,正在生成Excel');
    document.form1.submit();
    expajax();
  }
 else if(data=="1")
 {
    alert("当前导出报表的人数过多，系统正忙.请稍候再试！");
 }

}); 
}


// 计算两个日期的间隔天数  
function Computation(sDate1, sDate2){   //sDate1和sDate2是2008-12-13格式    
   var aDate, oDate1, oDate2, iDays;    
    aDate = sDate1.split("-");    
    oDate1 = new Date(aDate[0],aDate[1]-1,aDate[2]);    
    aDate = sDate2.split("-");    
    oDate2 = new Date(aDate[0],aDate[1]-1,aDate[2]);    
        
    iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 /24);      
    if((oDate1 - oDate2)<0){    
        return -iDays;    
    }    
    return iDays;    
}  

function GetUrlParms()    
{
    var args=new Object();   
    var query=location.search.substring(1);//获取查询串   
    var pairs=query.split("&");//在逗号处断开   
    for(var   i=0;i<pairs.length;i++)   
    {   
        var pos=pairs[i].indexOf('=');//查找name=value   
            if(pos==-1)   continue;//如果没有找到就跳过   
            var argname=pairs[i].substring(0,pos);//提取name   
            var value=pairs[i].substring(pos+1);//提取value   
            args[argname]=unescape(value);//存为属性   
    }
    return args;
}

function loading(context)
	 {
	 
	 
	   //遮罩效果  
        $.blockUI({ message: '<img src="images/loadding.gif" /> <b>'+context+',请稍候...</b>' });
	 }

