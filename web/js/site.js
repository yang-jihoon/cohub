
function clearModal(modal) {	
	alertClear();
	$('#modalName').val('');
//	$('#modalStageUrl').val('http://');
	$('#modalRealUrl').val('http://');
}

function setSiteUpdateValue(id) {
	alertClear();
	$('#myModalLabel').text('관리 사이트 수정');
	$('#modalSaveBtn').attr('onclick','siteUpdateAjax()');

	$('#modalTeam').val($('#team'+id).val());
	$('#modalPart').val($('#part'+id).text());	
	$('#modalId').val(id);
	$('#modalName').val($('#name'+id).attr('title'));
//	$('#modalStageUrl').val($('#stageUrl'+id).find('a').attr('title'));
	$('#modalRealUrl').val($('#realUrl'+id).find('a').attr('title'));	
	$('#modalDescription').val($('#description'+id).text());	
}

function setSiteInsertValue(modal) {
	alertClear();
	$('#myModalLabel').text('관리 사이트 추가');
	$('#modalSaveBtn').attr('onclick','siteInsertAjax()');
	
	clearModal(modal);
}

function siteUpdateAjax() {
	alertClear();

	var modalId = new validation('modalId','alertBlock','blockMsg');
	var modalTeam = new validation('modalTeam','alertBlock','blockMsg');
	var modalPart = new validation('modalPart','alertBlock','blockMsg');
	var modalName = new validation('modalName','alertBlock','blockMsg');
//	var modalStageUrl = new validation('modalStageUrl','alertBlock','blockMsg');
	var modalRealUrl = new validation('modalRealUrl','alertBlock','blockMsg');
	var modalDescription = new validation('modalDescription','alertBlock','blockMsg');
		
	if ( 	modalId.isEmpty() || !modalId.isNumber()
			|| modalTeam.isEmpty()
			|| modalPart.isEmpty()
			|| modalName.isEmpty() 
//			|| modalStageUrl.isEmpty() 
			|| modalRealUrl.isEmpty() 
			) {
		return;
	}
	
	var url = 'siteUpdateAjax.do?format=json&jsoncallback='
		+'&modalId='+modalId.getValue()
		+'&modalTeam='+encodeURI(encodeURIComponent(modalTeam.getValue()))
		+'&modalPart='+encodeURI(encodeURIComponent(modalPart.getValue()))
		+'&modalName='+encodeURI(encodeURIComponent(modalName.getValue()))
//		+'&modalStageUrl='+encodeURI(encodeURIComponent(modalStageUrl.getValue()))
		+'&modalRealUrl='+encodeURI(encodeURIComponent(modalRealUrl.getValue()))
		+'&modalDescription='+encodeURI(encodeURIComponent(modalDescription.getValue()))
		;
					
	$.getJSON(url,
		function(json){	
			if (json.result) {
				//$('#alertSuccess').show();		
				location.reload();
			} else {
				$('#errorMsg').text(json.msg);
				$('#alertError').show();
			}
		});
}

function siteInsertAjax() {
	alertClear();
	
	var modalTeam = new validation('modalTeam','alertBlock','blockMsg');
	var modalPart = new validation('modalPart','alertBlock','blockMsg');
	var modalName = new validation('modalName','alertBlock','blockMsg');
//	var modalStageUrl = new validation('modalStageUrl','alertBlock','blockMsg');
	var modalRealUrl = new validation('modalRealUrl','alertBlock','blockMsg');
	var modalDescription = new validation('modalDescription','alertBlock','blockMsg');
	
	if ( 	modalTeam.isEmpty()
			|| modalPart.isEmpty()
			|| modalName.isEmpty() 
//			|| (modalStageUrl.isEmpty() && 
			|| modalRealUrl.isEmpty() 
			) {
		return;
	}
	
	var url = 'siteInsertAjax.do?format=json&jsoncallback='
		+'&modalTeam='+encodeURI(encodeURIComponent(modalTeam.getValue()))
		+'&modalPart='+encodeURI(encodeURIComponent(modalPart.getValue()))
		+'&modalName='+encodeURI(encodeURIComponent(modalName.getValue()))
//		+'&modalStageUrl='+encodeURI(encodeURIComponent(modalStageUrl.getValue()))
		+'&modalRealUrl='+encodeURI(encodeURIComponent(modalRealUrl.getValue()))
		+'&modalDescription='+encodeURI(encodeURIComponent(modalDescription.getValue()))
		;
					
	$.getJSON(url,
		function(json){	
			if (json.result) {
				//$('#alertSuccess').show();
				location.reload();
			} else {
				$('#errorMsg').text(json.msg);
				$('#alertError').show();
			}
		});
}

function siteDeleteAjax(id) {		
	
	if (confirm($('#name'+id).attr('title')+'을(를) 정말삭제하시겠습니까?') == false) {
		return;
	} 
	
	var url = 'siteDeleteAjax.do?format=json&jsoncallback='
		+'&id='+id
		;
					
	$.getJSON(url,
		function(json){	
			if (json.result) {
				//$('#alertSuccess').show();
				location.reload();
			} else {
				$('#errorMsg').text(json.msg);
				$('#alertError').show();
			}
		});
}
