var details = JSON.parse(sessionStorage.getItem('userdetail'));
var serverurlCommon = '';
if(null!=details && undefined!=details){
	var serverurl = details.serverurl;
	if(null!=serverurl && serverurl.trim())
		serverurlCommon = serverurl;
}

function checkPerData(val){
	var getVal = $(val).val()
	if(null!=getVal && getVal!=undefined && getVal && getVal!=''){
		if(parseFloat(getVal)>100)
			$(val).val('0.00').focus();
		if(getVal==='.')
			$(val).val('0.00').focus();
	} 
}


function checkNumberData(val){
	var getVal = $(val).val()
	if(null!=getVal && getVal!=undefined && getVal && getVal!=''){
		if(getVal==='.')
			$(val).val('0.00').focus();
	}
}

function compareTwoDate(minDate, maxdate, sepratorChar){				// for compare date,  date should be  in  " mm/dd/yyyy "  Format
	var datepart = minDate.split(sepratorChar);
	var minDate = new Date(datepart[1]+"/"+datepart[0]+"/"+datepart[2]);
	datepart = maxdate.split(sepratorChar);
	var maxdate = new Date(datepart[1]+"/"+datepart[0]+"/"+datepart[2]);

	if(maxdate < minDate)   {
		return false;
	}else{
		return true;
	}
}

function checkFileUpload(formId, htmlObjId, maxFileSize,extArr){    	//   
	if (window.File && window.FileReader && window.FileList && window.Blob) {
		var fsize=document.forms[formId][htmlObjId].files[0].size;
		var ftype =document.forms[formId][htmlObjId].files[0].type;  	
		var fname= document.forms[formId][htmlObjId].files[0].name; 	 
		//document.forms[formId]["filename"].value =fname;	
		if (fsize > (maxFileSize*1000000)) {
			errorMessage("error","File should be less then "+maxFileSize+"MB","File Not Support..!");
			return false;
		} else {
			var sFileName = fname;
			var sExt = sFileName.split('.')[sFileName.split('.').length - 1].toLowerCase();
			if(extArr.indexOf(sExt)<0){
				errorMessage("error","Please atteched file should be "+extArr+"","File Not Support..!");
				return false;
			}
		}
	}
	return true;
}

function errorMessage(toastrType,message,title){	
	switch(toastrType.toLowerCase()){
		case "info":
			//toastr.info(message, title);
			swal({ title: title,   text: message, icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-warning.png", buttons: {   confirm: { className: "themeColor"}} });
		break;
		case "success":
			//toastr.success(message, title);
			swal({   title: title,   text: message,   icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-success.png", buttons: {   confirm: { className: "themeColor"}} });
		break;
		case "error":
			//toastr.error(message, title);
			swal({ title: title,   text: message,  icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-remove.png", buttons: {   confirm: { className: "themeColor"}} });
		break;
		case "warning":
			//toastr.warning(message, title);
			swal({ title: title,   text: message, icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-warning.png", buttons: {   confirm: { className: "themeColor"}} });
		break;
	}
}	
		
var checkNullAndEmpty = function(){
	var argument = null;
	for(var i = 0; i < arguments.length; i++) {
		argument = arguments[i];
		if(null==argument || !argument.toString().trim()){
			return false;
		}
	}
	return true;
};	


function datetoNumberFormat(dateSimple){
	
	var dateArray = dateSimple.split('/');
	var date = dateArray[0];
	var month = (parseInt(dateArray[1]) - 1);
	var year = dateArray[2];
	
	var datess = new Date();
	datess.setDate(date);
	datess.setMonth(month);
	datess.setYear(year);
	
	return (datess.getYear()+1900)+'-'+('0' + (datess.getMonth()+1)).slice(-2)+'-'+('0' + datess.getDate()).slice(-2);
	
}

function toUpperCaseFn(thiss){
	thiss.value = ((null!=thiss.value&&thiss.value.trim())?thiss.value.toUpperCase():'');	  
}

function toLowerCaseFn(thiss){
	thiss.value = ((null!=thiss.value&&thiss.value.trim())?thiss.value.toLowerCase():'');	  
}

function pad(n, width, z) {
  z = z || '0';
  n = n + '';
  return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
}

const ajaxFunc = function(type , url, data, successFun){
    $.ajax({
    	url: url,
    	type: type,
    	dataType: 'json',
    	data:JSON.stringify(data),
    	contentType: 'application/json',
        headers: {
           'token': '1234abcd-5678efgh-1234abcd-5678efgh',
           'userid': '6543210'
        },
        success: successFun,
        error: function (error) {
            console.log(error);
        }
   });
}

const commonComboFunc = function(url,data,comboId,comboPlaceholder,comboValueField,comboTextField){
	ajaxFunc('POST',url,data,function(resp){
		if(null!=resp && null!=resp.data && undefined!=resp.data){
			$("#"+comboId).kendoDropDownList({
				optionLabel: comboPlaceholder,
				dataTextField: comboTextField,
				dataValueField: comboValueField,
				filter: "contains",
				dataSource: resp.data,
			}).data("kendoDropDownList");
		}
	});
}