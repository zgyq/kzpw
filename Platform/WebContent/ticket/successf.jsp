<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>江苏东方航空旅行社</title>
<link href="style/bass.css" type="text/css" rel="stylesheet" />
<link href="style/base.css" type="text/css" rel="stylesheet" />
<link href="style/hotel.css" type="text/css" rel="stylesheet" />
<link href="style/font.css" type="text/css" rel="stylesheet" />
<script language="javascript"> 
function copyToClipboard(theField,isalert)
{
  if(theField!="")
  {
    var clipBoardContent=theField;
    //obj.select();
    window.clipboardData.setData("Text",clipBoardContent); 
    if(isalert!=false)
      alert("复制成功。现在您可以粘贴（Ctrl+v）到其他地方了。");
  }
  else
  {
     alert("Error!");
  }
}
</script>
</head>

<body>
<div>


<div>

<div>

<div class="box" style="text-align: center; line-height: 22px;">
<ul>
	<li><img src="images/dui.gif" width="51" height="43" /><b>国际票PNR导入成功!</b><br /></li>
</ul>
<br />
<br />
<br />
<br />
<br />
</div>
</div>
</div>
</body>
</html>
<script>
function golink(i)
{
	window.location=i;
}
</script>
