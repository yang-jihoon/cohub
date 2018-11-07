function alertClear() {
	$('.alert').hide();
}

var validation = function (v_id, v_alert, v_msg) {
	var id = v_id;
	var alert = v_alert;
	var msg = v_msg;
	var value = $.trim($('#'+v_id).val());
	return {
		isEmpty : function () {
			if (value == null || value == '') {				
				if ($('label[for='+id+']').text() != '') {
					$('#'+alert).show();
					$('#'+msg).text($('label[for='+id+']').text()+' is Empty');	
				}
				return true;
			} else {
				return false;
			};
		},
		isNumber : function () {
			var regExpr = new RegExp('^\\d*$');
			if (regExpr.test(value)) {
				return true;
			} else {
				if ($('label[for='+id+']').text() != '') {
					$('#'+alert).show();
					$('#'+msg).text($('label[for='+id+']').text()+' is Not Number');
				}				
				return false;
			};
		},
		getValue : function getValue() {
			return value;
		}};		
};