 
function checkFileUpload(formId, htmlObjId, maxFileSize,extArr){    	//   
	if (window.File && window.FileReader && window.FileList && window.Blob) {
		var fsize=document.forms[formId][htmlObjId].files[0].size;
		var ftype =document.forms[formId][htmlObjId].files[0].type;  	
		var fname= document.forms[formId][htmlObjId].files[0].name; 	 
		document.forms[formId]["filename"].value =fname;						
		if (fsize > (maxFileSize*1000000)) {
				errorMessage("error","File should be less then "+maxFileSize+"MB","File Not Support..!");
				$(htmlObjId).val('');
				return false;
		} else {
			var sFileName = fname;
				var sExt = sFileName.split('.')[sFileName.split('.').length - 1].toLowerCase();
					if(extArr.indexOf(sExt)<0){
						errorMessage("error","Please atteched file should be "+extArr+"","File Not Support..!");
						$(htmlObjId).val('');
						return false;
					}
				}
			}
			return true;
	}


