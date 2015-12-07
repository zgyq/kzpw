<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>图游商旅网</title>
<link href="main_cx/css/news2.css" rel="stylesheet" type="text/css" />
</head>
<body style="background:#eee">
<div id="wrap">
      <div class="right" style="margin-top:20px;">
             <div class="news">
                 <h1 style="color: red;"><ww:property value="sysmessage.title" /></h1>
                 <b><ww:property value="formatTimestampyyyyMMdd(sysmessage.modifytime)" /></b>
                 <div class="news-N">
                         <p><ww:property escape="false" value="sysmessage.content" />
                         </p>
                        
                         <font>特此敬告</font>
                         <span>
                             <b>${dns.address}</b>
                            
                         </span>
                 </div> 
             </div>
    
      </div>
</div>

</body>
</html>
