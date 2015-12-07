function OrderInfo(){
    //验证联系人信息
              if(IsEmpty($("#Contact").val()))
              {
                  $('#Contact').poshytip({
	                className: 'tip-yellowsimple',
					content:"请填写联系人姓名！",
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'right',
					alignY: 'center',
					offsetX: 5
				    });
                   $("#Contact").focus();
                   return false;
              }
	
	
}