<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="webwork" prefix="ww"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/public.css" type="text/css" rel="stylesheet" />
<link href="../css/left_n.css" type="text/css" rel="stylesheet" />
<script>
	var show=true;
	
	function showhide()
	{

		if(show)
		{
			document.getElementById('sh').src=	"img/middle.gif";
			window.parent.document.getElementById('mainFrame').cols=  "0,6,*";

		}else{

			document.getElementById('sh').src=	"img/middle.gif";
			window.parent.document.getElementById('mainFrame').cols= "220,6,*";

		}
		show = !show;
	}

	
		

</script>

	
	
</head>


<div id="middle" style="width:6px; overflow: hidden; background: ">
<div class="middle" >&nbsp;</div>
<div class="middle_x"><a href="javascript:" onClick="showhide()"><img src="img/middle.gif" id="sh" width="6" class="hand"  height="45"></a></div>
</div>


</html>
