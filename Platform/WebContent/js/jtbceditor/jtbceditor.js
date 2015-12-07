function jtbcEditor(_id)
{
  this.tid = _id;
  this.tName = '';
  this.tValue = '';
  this.tbaseURL = '';
  this.tPanelHeight = 22;
  this.tEditState = 1;
  this.tEditUBBMode = 1;
  this.tInstance = null;
  this.tSelection = null;
  this.tRange = null;
  this.tRangeText = null;
  this.tInputObject = null;
  this.tLang = 'zh-cn';
  this.tTheme = 'default';
  this.tToolbar = 'default';
  this.tToolbarSets = Array;
  this.tToolbarSets['default'] = ['Source','separator','Bold','Italic','Underline','RemoveFormat','separator','Link','Unlink','Image','Smiley','separator','JustifyLeft','JustifyCenter','JustifyRight','JustifyFull','separator','OrderedList','UnorderedList','TextColor','BGColor'];
  this.tVersion = '1.0.0.0';
  this.tAuthor = 'jetiben';
  this.tEI = function(_id)
  {
    return document.getElementById(_id);
  };
  this.tEH = function(_strers, _strtagname)
  {
    var tObject = null;
    var tstrers = _strers;
    var tstrtagname = _strtagname;
    if (tstrers && tstrtagname)
    {
      var tObj1 = this.tEI(this.tid + '-divFactory');
      tObj1.innerHTML = tstrers;
      tObject = tObj1.getElementsByTagName(tstrtagname).item(0);
    };
    return tObject;
  };
  this.tFW = function(_id)
  {
    var tid = _id;
    var tobj = null;
    try
    {
      tobj = document.frames[tid];
    } catch(e){};
    if (tobj == null)
    {
      try
      {
        tobj = this.tEI(tid).contentWindow;
      } catch(e){};
    };
    return tobj;
  };
  this.tAttachEvent = function(_obj, _eventName, _handler, _object)
  {
    var tobj = _obj;
    var teventName = _eventName;
    var thandler = _handler;
    var teventHandler = _handler;
    var tobject = _object;
    if (tobj)
    {
      if (tobject)
      {
        teventHandler = function(e)
        {
          thandler.call(tobject, e);
        };
      };
      try {tobj.addEventListener(teventName, teventHandler, false);}
      catch(e)
      {
        if (teventName == 'keypress') tobj = tobj.document;
        tobj.attachEvent('on' + teventName, teventHandler);
      };
    };
  };
  this.tIsIE = function()
  {
    return (navigator.userAgent.toLowerCase().indexOf('msie')!= -1 && document.all);
  };
  this.tReplace = function(_strers, _reary, _ign)
  {
    var tstrers = _strers;
    var treary = _reary;
    var tign = _ign;
    var tstate1 = true;
    for (var ti = 0; ti < treary.length; ti ++)
    {
      if (!treary[ti][2]) tstrers = tstrers.replace(treary[ti][0], (tign ? '' : treary[ti][1]));
    };
    while(tstate1)
    {
      tstate1 = false;
      for (var ti = 0; ti < treary.length; ti ++)
      {
        if (treary[ti][2] && tstrers.search(treary[ti][0]) != -1)
        {
          tstate1 = true;
          tstrers = tstrers.replace(treary[ti][0], (tign ? '' : treary[ti][1]));
        };
      };
    };
    return tstrers;
  };
  this.tHTMLEncode = function(_strers)
  {
    var tstrers = _strers;
    if (tstrers)
    {
      tstrers = tstrers.replace(/&/igm, '&amp;');
      tstrers = tstrers.replace(/</igm, '&lt;');
      tstrers = tstrers.replace(/>/igm, '&gt;');
      tstrers = tstrers.replace(/\"/igm, '&quot;');
    };
    return tstrers;
  };
  this.tHTMLDecode = function(_strers)
  {
    var tstrers = _strers;
    if (tstrers)
    {
      tstrers = tstrers.replace(/&lt;/igm, '<');
      tstrers = tstrers.replace(/&gt;/igm, '>');
      tstrers = tstrers.replace(/&quot;/igm, '"');
      tstrers = tstrers.replace(/&nbsp;/igm, ' ');
      tstrers = tstrers.replace(/&amp;/igm, '&');
    };
    return tstrers;
  };
  this.tHTMLClear = function(_strers)
  {
    var tstrers = _strers;
    if (tstrers)
    {
	    tstrers = tstrers.replace(/<script[^>]*>[\s\S]*?<\/script[^>]*>/gim, '');
	    tstrers = tstrers.replace(/<(\/?)(script|i?frame|style|html|head|body|title|link|meta|object|\?|\%)([^>]*?)>/gi, '');
	    tstrers = tstrers.replace(/<([a-z]+)+\s*(?:onerror|onload|onunload|onresize|onblur|onchange|onclick|ondblclick|onfocus|onkeydown|onkeypress|onkeyup|onmousemove|onmousedown|onmouseout|onmouseover|onmouseup|onselect)[^>]*>/gi, '<$1>');
    };
    return tstrers;
  };
  this.tHTML2XHTML = function(_strers)
  {
    var tstrers = _strers;
    if (tstrers)
    {
	    tstrers = tstrers.replace(/<br.*?>/gi, '<br />');
	    tstrers = tstrers.replace(/(<hr\s+[^>]*[^\/])(>)/gi, '$1 />');
	    tstrers = tstrers.replace(/(<img\s+[^>]*[^\/])(>)/gi, '$1 />');
    };
    return tstrers;
  };
  this.tXHTML2UBB = function(_strers)
  {
    var tstrers = _strers;
    if (tstrers)
    {
      var tthis = this;
      var tReplaceAry = [
        [/<br \/>/ig, '[br]', false],
        [/<p>([^<]*?)<\/p>/igm, '[p]$1[/p]', true],
        [/<b>([^<]*?)<\/b>/igm, '[b]$1[/b]', true],
        [/<strong>([^<]*?)<\/strong>/igm, '[b]$1[/b]', true],
        [/<i>([^<]*?)<\/i>/igm, '[i]$1[/i]', true],
        [/<em>([^<]*?)<\/em>/igm, '[i]$1[/i]', true],
        [/<u>([^<]*?)<\/u>/igm, '[u]$1[/u]', true],
        [/<ol>([^<]*?)<\/ol>/igm, '[ol]$1[/ol]', true],
        [/<ul>([^<]*?)<\/ul>/igm, '[ul]$1[/ul]', true],
        [/<li>([^<]*?)<\/li>/igm, '[li]$1[/li]', true],
        [/<span\s[^>]*?>([^<]*?)<\/span>/igm, function($0, $1) {
          var tString = $1;
          var tObj1 = tthis.tEH($0, 'span');
          if (tObj1.style.fontWeight.toLowerCase() == 'bold') tString = '[b]' + tString + '[/b]';
          if (tObj1.style.fontStyle.toLowerCase() == 'italic') tString = '[i]' + tString + '[/i]';
          if (tObj1.style.textDecoration.toLowerCase() == 'underline') tString = '[u]' + tString + '[/u]';
          if (tObj1.style.color) tString = '[color=' + tObj1.style.color + ']' + tString + '[/color]';
          if (tObj1.style.backgroundColor) tString = '[hilitecolor=' + tObj1.style.backgroundColor + ']' + tString + '[/hilitecolor]';
          return tString;
        }, true],
        [/<font\s[^>]*?>([^<]*?)<\/font>/igm, function($0, $1) {
          var tString = $1;
          var tObj1 = tthis.tEH($0, 'font');
          if (tObj1.getAttribute('color')) tString = '[color=' + tObj1.getAttribute('color') + ']' + tString + '[/color]';
          if (tObj1.style.color) tString = '[color=' + tObj1.style.color + ']' + tString + '[/color]';
          if (tObj1.style.backgroundColor) tString = '[hilitecolor=' + tObj1.style.backgroundColor + ']' + tString + '[/hilitecolor]';
          return tString;
        }, true],
        [/<p\s[^>]*?>([^<]*?)<\/p>/igm, function($0, $1) {
          var tString = $1;
          var tObj1 = tthis.tEH($0, 'p');
          if (tObj1.getAttribute('align')) tString = '[align=' + tObj1.getAttribute('align') + ']' + tString + '[/align]';
          if (tObj1.style.textAlign) tString = '[align=' + tObj1.style.textAlign + ']' + tString + '[/align]';
          tString = '[p]' + tString + '[/p]';
          return tString;
        }, true],
        [/<div\s[^>]*?>([^<]*?)<\/div>/igm, function($0, $1) {
          var tString = $1;
          var tObj1 = tthis.tEH($0, 'div');
          if (tObj1.className == 'ubb_code') tString = '[code]' + tString + '[/code]';
          if (tObj1.className == 'ubb_quote') tString = '[quote]' + tString + '[/quote]';
          if (tObj1.getAttribute('align')) tString = '[align=' + tObj1.getAttribute('align') + ']' + tString + '[/align]';
          if (tObj1.style.textAlign) tString = '[align=' + tObj1.style.textAlign + ']' + tString + '[/align]';
          return tString;
        }, true],
        [/<a\s[^>]*?>([^<]*?)<\/a>/igm, function($0, $1) {
          var tString = $1;
          var tObj1 = tthis.tEH($0, 'a');
          if (tObj1.getAttribute('href')) tString = '[url=' + tObj1.getAttribute('href') + ']' + tString + '[/url]';
          return tString;
        }, true],
        [/<img\s[^>]*?>/igm, function($0) {
          var tObj1 = tthis.tEH($0, 'img');
          if (tObj1.getAttribute('src')) tString = '[img]' + tObj1.getAttribute('src') + '[/img]';
          return tString;
        }, true]
      ];
      tstrers = this.tReplace(tstrers, tReplaceAry);
      tstrers = tstrers.replace(/<[^>]*>/igm, '');
      tstrers = this.tHTMLDecode(tstrers);
    };
    return tstrers;
  };
  this.tUBB2XHTML = function(_strers)
  {
    var tstrers = _strers;
    if (tstrers)
    {
      var tthis = this;
      var tReplaceAry = [
        [/\[br\]/ig, '<br />', false],
        [/\[p\]([^\[]*?)\[\/p\]/igm, '<p>$1</p>', true],
        [/\[b\]([^\[]*?)\[\/b\]/igm, '<b>$1</b>', true],
        [/\[i\]([^\[]*?)\[\/i\]/igm, '<i>$1</i>', true],
        [/\[u\]([^\[]*?)\[\/u\]/igm, '<u>$1</u>', true],
        [/\[ol\]([^\[]*?)\[\/ol\]/igm, '<ol>$1</ol>', true],
        [/\[ul\]([^\[]*?)\[\/ul\]/igm, '<ul>$1</ul>', true],
        [/\[li\]([^\[]*?)\[\/li\]/igm, '<li>$1</li>', true],
        [/\[code\]([^\[]*?)\[\/code\]/igm, '<div class="ubb_code" style="BORDER: #dcdcdc 1px dotted; PADDING: 5px; LINE-HEIGHT: 150%; FONT-STYLE: italic">$1</div>', true],
        [/\[quote\]([^\[]*?)\[\/quote\]/igm, '<div class="ubb_quote" style="BORDER: #dcdcdc 1px dotted; PADDING: 5px; LINE-HEIGHT: 150%">$1</div>', true],
        [/\[color=([^\]]*)\]([^\[]*?)\[\/color\]/igm, '<font style="color: $1">$2</font>', true],
        [/\[hilitecolor=([^\]]*)\]([^\[]*?)\[\/hilitecolor\]/igm, '<font style="background-color: $1">$2</font>', true],
        [/\[align=([^\]]*)\]([^\[]*?)\[\/align\]/igm, '<div style="text-align: $1">$2</div>', true],
        [/\[url=([^\]]*)\]([^\[]*?)\[\/url\]/igm, '<a href="$1">$2</a>', true],
        [/\[img\]([^\[]*?)\[\/img\]/igm, '<img src="$1" />', true]
      ];
      tstrers = this.tHTMLEncode(tstrers);
      tstrers = this.tReplace(tstrers, tReplaceAry);
    };
    return tstrers;
  };
  this.tcreateStyleSheet = function()
  {
    var tObj1 = document.getElementsByTagName('head').item(0);
    if (!tObj1) tObj1 = document.getElementsByTagName('body').item(0);
    if (tObj1)
    {
      var tLink1 = document.createElement('link');
      tLink1.setAttribute('rel', 'stylesheet');
      tLink1.setAttribute('type', 'text/css');
      tLink1.setAttribute('href', this.tbaseURL + 'common/theme/' + this.tTheme + '/css/editor.css');
      tObj1.appendChild(tLink1);
    };
  };
  this.tinsertUBB = function(_Value)
  {
    var tValue = _Value;
    tValue = this.tUBB2XHTML(tValue);
    this.tinsertHTML(tValue);
  };
  this.tinsertHTML = function(_Value)
  {
    var tValue = _Value;
    if (tValue)
    {
      this.tInstance.focus();
      try
      {
        this.tGetSelection();
        this.tRange.pasteHTML(tValue);
      }
      catch(e)
      {
        this.texecCommand('insertHTML', tValue);
      };
    };
  };
  this.tsetCommand = function(_Command, _Value)
  {
    var tCommand = _Command;
    var tValue = _Value;
    if (this.tEditState == 1)
    {
	    switch (tCommand)
	    {
        case 'Source':
          this.tShowSource();
          break;
        case 'RemoveFormat':
          this.texecCommand('removeformat');
          break;
        case 'Bold':
          this.texecCommand('bold');
          break;
        case 'Italic':
          this.texecCommand('italic');
          break;
        case 'Underline':
          this.texecCommand('underline');
          break;
        case 'OrderedList':
          this.texecCommand('insertorderedlist');
          break;
        case 'UnorderedList':
          this.texecCommand('insertunorderedlist');
          break;
        case 'JustifyLeft':
          this.texecCommand('justifyleft');
          break;
        case 'JustifyCenter':
          this.texecCommand('justifycenter');
          break;
        case 'JustifyRight':
          this.texecCommand('justifyright');
          break;
        case 'JustifyFull':
          this.texecCommand('justifyfull');
          break;
        case 'TextColor':
          this.tLoadForeColorTable();
          break;
        case 'TextColorS':
          this.tLoadMaskClose();
          this.texecCommand('forecolor', tValue);
          break;
        case 'BGColor':
          this.tLoadBackColorTable();
          break;
        case 'BGColorS':
          this.tLoadMaskClose();
          try {this.texecCommand('hilitecolor', tValue);}
          catch(e) {this.texecCommand('backcolor', tValue);};
          break;
        case 'Link':
          this.tLoadLinkTable();
          this.tGetSelection();
          break;
        case 'LinkS':
          this.tLoadMaskClose();
          this.tRangeReselect();
          this.texecCommand('createlink', tValue);
          break;
        case 'Unlink':
          this.texecCommand('unlink');
          break;
        case 'Image':
          this.tLoadImageTable();
          this.tGetSelection();
          break;
        case 'ImageS':
          this.tLoadMaskClose();
          this.tRangeReselect();
          this.texecCommand('insertimage', tValue);
          break;
        case 'Smiley':
          this.tLoadSmileyTable();
          break;
        case 'SmileyS':
          this.tLoadMaskClose();
          this.texecCommand('insertimage', tValue);
          break;
      };
    }
    else
    {
      if (tCommand == 'Source') this.tShowNormal();
      else this.tLoadMessage(jtbcEditorLang.tError1);
    };
  };
  this.texecCommand = function(_Command, _Value)
  {
    var tCommand = _Command;
    var tValue = _Value;
    this.tInstance.focus();
    this.tInstance.document.execCommand(tCommand, false, tValue);
  };
  this.tGetHTML = function()
  {
  	// 鍘熸潵灏嗗ぇ鍐欏瓧姣嶅彉涓哄皬鍐?
    //var tHTML = this.tInstance.document.body.innerHTML.toLowerCase();
    var tHTML = this.tInstance.document.body.innerHTML;
    return tHTML;
  };
  this.tGetUBB = function()
  {
    var tHTML = this.tGetHTML();
    tHTML = this.tHTML2XHTML(tHTML);
    tHTML = this.tHTMLClear(tHTML);
    tHTML = this.tXHTML2UBB(tHTML);
    return tHTML;
  };
  this.tGetSelection = function()
  {
    try
    {
      this.tSelection = this.tInstance.document.selection;
      this.tRange = this.tSelection.createRange();
      this.tRangeText = this.tRange.text;
    }
    catch(e)
    {
      this.tSelection = this.tInstance.getSelection();
      this.tRange = this.tSelection.getRangeAt(0);
      this.tRangeText = this.tRange.toString();
    };
  };
  this.tRangeReselect = function()
  {
    try
    {
      if (this.tRangeText) this.tRange.select();
      else  this.tRange.focus();
    }
    catch(e) {};
  };
  this.tSetInputValue = function()
  {
    var tHTML = this.tGetHTML();
    tHTML = this.tHTML2XHTML(tHTML);
    tHTML = this.tHTMLClear(tHTML);
    if (this.tEditUBBMode == 1) tHTML = this.tXHTML2UBB(tHTML);
    this.tInputObject.value = tHTML;
  };
  this.tShowSource = function()
  {
    if (this.tEditState == 1)
    {
      var tSourceImageObj;
      var tHTML = this.tGetHTML();
      this.tEditState = 0;
      tHTML = this.tHTML2XHTML(tHTML);
      tHTML = this.tHTMLClear(tHTML);
      if (this.tEditUBBMode == 1) tHTML = this.tXHTML2UBB(tHTML);
      tSourceImageObj = this.tEI(this.tid + '-jtbcEditorToolbar-Source');
      tSourceImageObj.onmouseover = function() {};
      tSourceImageObj.onmouseout = function() {};
      tSourceImageObj.className = 'jtbcEditorSelected';
      this.tEI(this.tid + '-textarea').style.display = '';
      this.tEI(this.tid + '-iframe').style.display = 'none';
      this.tEI(this.tid + '-textarea').value = tHTML;
    };
  };
  this.tShowNormal = function()
  {
    if (this.tEditState == 0)
    {
      var tSourceImageObj;
      var tnValue = this.tEI(this.tid + '-textarea').value;
      this.tEditState = 1;
      if (this.tEditUBBMode == 1) tnValue = this.tUBB2XHTML(tnValue);
      else tnValue = this.tHTMLClear(tnValue);
      tSourceImageObj = this.tEI(this.tid + '-jtbcEditorToolbar-Source');
      tSourceImageObj.onmouseover = function() {this.className = 'jtbcEditorSelected'};
      tSourceImageObj.onmouseout = function() {this.className = ''};
      tSourceImageObj.className = '';
      this.tEI(this.tid + '-textarea').style.display = 'none';
      this.tEI(this.tid + '-iframe').style.display = '';
      this.tInstance.document.body.innerHTML = tnValue;
    };
  };
  this.tLoadToolbar = function(_obj)
  {
    var tObj1 = _obj;
    if (tObj1)
    {
      var tHTMLString1 = '';
      var tArray1 = this.tToolbarSets[this.tToolbar];
      if (!tArray1) tArray1 = this.tToolbarSets['default'];
      for (var tKey1 in tArray1)
      {
        var tnKey = tArray1[tKey1];
        if (tnKey == '-' || tnKey == 'separator') tHTMLString1 += '<img src="' + this.tbaseURL + 'common/theme/' + this.tTheme + '/images/icon/toolbar.' + tnKey + '.gif" />';
        else tHTMLString1 += '<img id="' + this.tid + '-jtbcEditorToolbar-' + tnKey + '" src="' + this.tbaseURL + 'common/theme/' + this.tTheme + '/images/icon/' + tnKey + '.gif" onmouseover="this.className = \'jtbcEditorSelected\';" onmouseout="this.className = \'\';" onclick="' + this.tName + '.tsetCommand(\'' + tnKey + '\');" />';
      };
      tObj1.innerHTML = tHTMLString1;
    };
  };
  this.tLoadMask = function()
  {
    var tObj1 = this.tEI(this.tid + '-div');
    if (tObj1)
    {
      var tDiv1 = document.createElement('div');
      tDiv1.setAttribute('id', this.tid + '-jtbcEditorMask');
      tDiv1.style.position = 'absolute';
      tDiv1.style.top = '0';
      tDiv1.style.left = '0';
      tDiv1.style.background = '#FFFFFF';
      tDiv1.style.filter = 'Alpha(Opacity=50)';
      tDiv1.style.opacity = '0.5';
      tDiv1.style.width = tObj1.offsetWidth + 'px';
      tDiv1.style.height = tObj1.offsetHeight + 'px';
      tDiv1.style.zIndex = '100';
      tObj1.appendChild(tDiv1);
      var tDiv2 = document.createElement('div');
      tDiv2.setAttribute('id', this.tid + '-jtbcEditorMaskDIV');
      tDiv2.style.position = 'absolute';
      tDiv2.style.top = '50%';
      tDiv2.style.left = '50%';
      tDiv2.style.zIndex = '101';
      tObj1.appendChild(tDiv2);
    };
  };
  this.tLoadMaskShow = function(_strHTML)
  {
    var tstrHTML = _strHTML;
    if (tstrHTML)
    {
      var tObj1 = this.tEI(this.tid + '-jtbcEditorMaskDIV');
      if (!tObj1)
      {
        this.tLoadMask();
        tObj1 = this.tEI(this.tid + '-jtbcEditorMaskDIV');
      };
      if (tObj1)
      {
        tObj1.style.display = 'none';
        tObj1.innerHTML = tstrHTML;
        tObj1.style.display = 'block';
        tObj1.style.marginLeft = (0 - Math.floor(tObj1.offsetWidth / 2)) + 'px';
        tObj1.style.marginTop = (0 - Math.floor(tObj1.offsetHeight / 2)) + 'px';
      };
    };
  };
  this.tLoadMaskClose = function()
  {
    var tObj1 = this.tEI(this.tid + '-div');
    if (tObj1)
    {
      var tobj21 = this.tEI(this.tid + '-jtbcEditorMask');
      var tobj22 = this.tEI(this.tid + '-jtbcEditorMaskDIV');
      if (tobj21 && tobj22)
      {
        tObj1.removeChild(tobj21);
        tObj1.removeChild(tobj22);
      };
    };
  };
  this.tLoadMessage = function(_strers)
  {
    var tstrers = _strers;
    var tMessageTableHTML = '<table cellpadding="0" cellspacing="5" class="jtbcEditorMessageTable">';
    tMessageTableHTML += '  <tr>';
    tMessageTableHTML += '    <td>' + jtbcEditorLang.tHint + '</td>';
    tMessageTableHTML += '  </tr>';
    tMessageTableHTML += '  <tr>';
    tMessageTableHTML += '    <td height="20"></td>';
    tMessageTableHTML += '  </tr>';
    tMessageTableHTML += '  <tr>';
    tMessageTableHTML += '    <td><span>' + tstrers + '</span></td>';
    tMessageTableHTML += '  </tr>';
    tMessageTableHTML += '  <tr>';
    tMessageTableHTML += '    <td height="20"></td>';
    tMessageTableHTML += '  </tr>';
    tMessageTableHTML += '  <tr>';
    tMessageTableHTML += '    <td class="jtbcEditorTD1"><input type="button" value="' + jtbcEditorLang.tOK + '" class="jtbcEditorMessageButton" onclick="' + this.tName + '.tLoadMaskClose();" /></td>';
    tMessageTableHTML += '  </tr>';
    tMessageTableHTML += '</table>';
    this.tLoadMaskShow(tMessageTableHTML);
  };
  this.tLoadLinkTable = function()
  {
    var tLinkTableHTML = '<table cellpadding="0" cellspacing="5" class="jtbcEditorLinkTable">';
    tLinkTableHTML += '  <tr>';
    tLinkTableHTML += '    <td>' + jtbcEditorLang.tLinkURL + '</td>';
    tLinkTableHTML += '  </tr>';
    tLinkTableHTML += '  <tr>';
    tLinkTableHTML += '    <td><input id="' + this.tid + '-jtbcEditorLinkText" type="text" value="http://" class="jtbcEditorLinkText" ondblclick="this.select();" /></td>';
    tLinkTableHTML += '  </tr>';
    tLinkTableHTML += '  <tr>';
    tLinkTableHTML += '    <td class="jtbcEditorTD1"><input type="button" value="' + jtbcEditorLang.tOK + '" class="jtbcEditorLinkButton" onclick="' + this.tName + '.tsetCommand(\'LinkS\', ' + this.tName + '.tEI(\'' + this.tid + '-jtbcEditorLinkText\').value);" />&nbsp;<input type="button" value="' + jtbcEditorLang.tCancel + '" class="jtbcEditorLinkButton" onclick="' + this.tName + '.tLoadMaskClose();" /></td>';
    tLinkTableHTML += '  </tr>';
    tLinkTableHTML += '</table>';
    this.tLoadMaskShow(tLinkTableHTML);
  },
  this.tLoadImageTable = function()
  {
    var tLinkTableHTML = '<table cellpadding="0" cellspacing="5" class="jtbcEditorImageTable">';
    tLinkTableHTML += '  <tr>';
    tLinkTableHTML += '    <td>' + jtbcEditorLang.tImageURL + '</td>';
    tLinkTableHTML += '  </tr>';
    tLinkTableHTML += '  <tr>';
    tLinkTableHTML += '    <td><input id="' + this.tid + '-jtbcEditorImageText" type="text" value="http://" class="jtbcEditorImageText" ondblclick="this.select();" /></td>';
    tLinkTableHTML += '  </tr>';
    tLinkTableHTML += '  <tr>';
    tLinkTableHTML += '    <td class="jtbcEditorTD1"><input type="button" value="' + jtbcEditorLang.tOK + '" class="jtbcEditorImageButton" onclick="' + this.tName + '.tsetCommand(\'ImageS\', ' + this.tName + '.tEI(\'' + this.tid + '-jtbcEditorImageText\').value);" />&nbsp;<input type="button" value="' + jtbcEditorLang.tCancel + '" class="jtbcEditorImageButton" onclick="' + this.tName + '.tLoadMaskClose();" /></td>';
    tLinkTableHTML += '  </tr>';
    tLinkTableHTML += '</table>';
    this.tLoadMaskShow(tLinkTableHTML);
  },
  this.tLoadSmileyTable = function()
  {
    var tni = 0;
    var tRowNum = 6;
    var tSmileyTableHTML = '<table cellpadding="0" cellspacing="5" class="jtbcEditorSmileyTable">';
    tSmileyTableHTML += '  <tr>';
    tSmileyTableHTML += '    <td colspan="' + tRowNum + '">' + jtbcEditorLang.tSmileyImage + '</td>';
    tSmileyTableHTML += '  </tr>';
    tSmileyTableHTML += '  <tr>';
    for (var ti = 0; ti < 24; ti ++)
    {
      tni += 1;
      tSmileyTableHTML +='    <td><img src="' + this.tbaseURL + 'common/theme/' + this.tTheme + '/images/smiley/' + tni + '.gif" onclick="' + this.tName + '.tsetCommand(\'SmileyS\', this.src);" /></td>';
      if (tni % tRowNum == 0 && tni != 25)
      {
        tSmileyTableHTML += '  </tr>';
        tSmileyTableHTML += '  <tr>';
      };
    };
    tSmileyTableHTML += '  </tr>';
    tSmileyTableHTML += '</table>';
    this.tLoadMaskShow(tSmileyTableHTML);
  };
  this.tLoadForeColorTable = function()
  {
    var tni = 0;
    var tRowNum = 8;
    var tColorHexAry = new Array('00','88','CC','FF');
    var tColorHexAryLength = tColorHexAry.length;
    var tColorTableHTML = '<table cellpadding="0" cellspacing="5" class="jtbcEditorColorTable">';
    tColorTableHTML += '  <tr>';
    tColorTableHTML += '    <td colspan="' + tRowNum + '">' + jtbcEditorLang.tColorPicker + '</td>';
    tColorTableHTML += '  </tr>';
    tColorTableHTML += '  <tr>';
    for (var ti = 0; ti < tColorHexAryLength; ti ++)
    {
      for (var tj = 0; tj < tColorHexAryLength; tj ++)
      {
        for (var tk = 0; tk < tColorHexAryLength; tk ++)
        {
          tni += 1;
          tColorTableHTML +='    <td bgcolor="#' + tColorHexAry[ti] + tColorHexAry[tj] + tColorHexAry[tk] + '"><img src="' + this.tbaseURL + 'common/theme/' + this.tTheme + '/images/space.gif" onclick="' + this.tName + '.tsetCommand(\'TextColorS\', \'#' + tColorHexAry[ti] + tColorHexAry[tj] + tColorHexAry[tk] + '\');" width="11" height="11" /></td>';
          if (tni % tRowNum == 0 && tni != (tColorHexAryLength*tColorHexAryLength*tColorHexAryLength))
          {
            tColorTableHTML += '  </tr>';
            tColorTableHTML += '  <tr>';
          };
        };
      };
    };
    tColorTableHTML += '  </tr>';
    tColorTableHTML += '</table>';
    this.tLoadMaskShow(tColorTableHTML);
  };
  this.tLoadBackColorTable = function()
  {
    var tni = 0;
    var tRowNum = 8;
    var tColorHexAry = new Array('00','88','CC','FF');
    var tColorHexAryLength = tColorHexAry.length;
    var tColorTableHTML = '<table cellpadding="0" cellspacing="5" class="jtbcEditorColorTable">';
    tColorTableHTML += '  <tr>';
    tColorTableHTML += '    <td colspan="' + tRowNum + '">' + jtbcEditorLang.tColorPicker + '</td>';
    tColorTableHTML += '  </tr>';
    tColorTableHTML += '  <tr>';
    for (var ti = 0; ti < tColorHexAryLength; ti ++)
    {
      for (var tj = 0; tj < tColorHexAryLength; tj ++)
      {
        for (var tk = 0; tk < tColorHexAryLength; tk ++)
        {
          tni += 1;
          tColorTableHTML +='    <td bgcolor="#' + tColorHexAry[ti] + tColorHexAry[tj] + tColorHexAry[tk] + '"><img src="' + this.tbaseURL + 'common/theme/' + this.tTheme + '/images/space.gif" onclick="' + this.tName + '.tsetCommand(\'BGColorS\', \'#' + tColorHexAry[ti] + tColorHexAry[tj] + tColorHexAry[tk] + '\');" width="11" height="11" /></td>';
          if (tni % tRowNum == 0 && tni != (tColorHexAryLength*tColorHexAryLength*tColorHexAryLength))
          {
            tColorTableHTML += '  </tr>';
            tColorTableHTML += '  <tr>';
          };
        };
      };
    };
    tColorTableHTML += '  </tr>';
    tColorTableHTML += '</table>';
    this.tLoadMaskShow(tColorTableHTML);
  };
  this.tInit = function(_name, _baseURL)
  {
    this.tName = _name;
    this.tbaseURL = _baseURL;
    var tObj1 = this.tEI(this.tid);
    if (tObj1)
    {
      this.tcreateStyleSheet();
      this.tValue = tObj1.value;
      var tObj1Name = tObj1.name;
      var tObj1Width = tObj1.offsetWidth;
      var tObj1Height = tObj1.offsetHeight;
      var tObj2 = tObj1.parentNode;
      var tDiv1 = document.createElement('div');
      tDiv1.setAttribute('id', this.tid + '-div');
      tDiv1.style.width = tObj1Width + 'px';
      tDiv1.style.height = tObj1Height + 'px';
      tDiv1.className = 'jtbcEditorDiv';
      tObj2.appendChild(tDiv1);
      tObj2.replaceChild(tDiv1, tObj1);
      var tScript1 = document.createElement('script');
      tScript1.type = 'text/javascript';
      tScript1.src = '' + this.tbaseURL + 'common/lang/' + this.tLang + '.js';
      tDiv1.appendChild(tScript1);
      var tInput1 = document.createElement('input');
      tInput1.type = 'hidden';
      tInput1.name = tObj1Name;
      tDiv1.appendChild(tInput1);
      this.tInputObject = tInput1;
      var tDiv2 = document.createElement('div');
      tDiv2.setAttribute('id', this.tid + '-divPanel');
      tDiv2.style.height = this.tPanelHeight + 'px';
      tDiv2.className = 'jtbcEditorDivPanel';
      tDiv1.appendChild(tDiv2);
      this.tLoadToolbar(tDiv2);
      var tDiv3 = document.createElement('div');
      tDiv3.setAttribute('id', this.tid + '-divFactory');
      tDiv3.style.display = 'none';
      tDiv1.appendChild(tDiv3);
      var tTextarea1 = document.createElement('textarea');
      tTextarea1.setAttribute('id', this.tid + '-textarea');
      tTextarea1.style.width = tObj1Width + 'px';
      tTextarea1.style.maxWidth = tObj1Width + 'px';
      tTextarea1.style.height = (tObj1Height - this.tPanelHeight - 5) + 'px';
      tTextarea1.style.maxHeight = (tObj1Height - this.tPanelHeight - 5) + 'px';
      tTextarea1.style.display = 'none';
      tTextarea1.className = 'jtbcEditorTextarea';
      tDiv1.appendChild(tTextarea1);
      var tIframe1 = document.createElement('iframe');
      tIframe1.setAttribute('id', this.tid + '-iframe');
      tIframe1.setAttribute('frameBorder', '0');
      tIframe1.setAttribute('marginWidth', '3');
      tIframe1.setAttribute('marginHeight', '3');
      tIframe1.setAttribute('allowTransparency', 'true');
      tIframe1.style.width = '100%';
      tIframe1.style.height = (tObj1Height - this.tPanelHeight - 5) + 'px';
      tIframe1.className = 'jtbcEditorIframe';
      tDiv1.appendChild(tIframe1);
      var tObj3 = this.tFW(this.tid + '-iframe');
      if (this.tEditUBBMode == 1) this.tValue = this.tUBB2XHTML(this.tValue);
      var tObj3HTML = '<html><head><link href="' + this.tbaseURL + 'common/theme/' + this.tTheme + '/css/iframe.css" rel="stylesheet" type="text/css" /></head><body>' + this.tValue + '</body></html>';
      tObj3.document.designMode = 'On';
      tObj3.document.open();
      tObj3.document.writeln(tObj3HTML);
      tObj3.document.close();
      this.tInstance = tObj3;
      var tObj3Object = new Object();
      tObj3Object.tObject = this;
      tObj3Object.tInstance = this.tInstance;
      this.tAttachEvent(tObj3, 'blur', this.tOnblur, tObj3Object);
      this.tAttachEvent(tObj3, 'keypress', this.tOnkeypress, tObj3Object);
      this.tSetInputValue();
    };
  };
  this.tOnblur = function()
  {
    this.tObject.tSetInputValue();
  };
  this.tOnkeypress = function()
  {
    if (this.tObject.tEditState == 1)
    {
      var tObjP = this.tInstance.document.getElementsByTagName('p');
      if (!tObjP[0]) this.tObject.texecCommand('formatblock', '<p>');
    };
  };
};