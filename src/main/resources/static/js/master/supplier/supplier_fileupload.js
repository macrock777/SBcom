
function checkFileUpload(formId, htmlObjId, maxFileSize,extArr){    	//   
	if (window.File && window.FileReader && window.FileList && window.Blob) {
		var fsize=document.forms[formId][htmlObjId].files[0].size;
		var ftype =document.forms[formId][htmlObjId].files[0].type;  	
		var fname= document.forms[formId][htmlObjId].files[0].name; 	 
		//document.forms[formId][htmlObjId].value = fname;						
		if (fsize > (maxFileSize*1000000)) {
			errorMessage("error","File should be less then "+maxFileSize+"MB","File Not Support..!");
			$('#'+htmlObjId).val('');
			return false;
		}else{
			var sFileName = fname;
			var sExt = sFileName.split('.')[sFileName.split('.').length - 1].toLowerCase();
			if(extArr.indexOf(sExt)<0){
				errorMessage("error","Please Upload Only "+extArr+" File","File Not Support..!");
				$('#'+htmlObjId).val('');
				return false;
			}
		}
	}
	return true;
}

$(document).on('change','#uploadopenexceldata',function(){
	
	if(checkFileUpload("myform", "uploadopenexceldata", "5",['xltm'])){
		var formData = new FormData();
		
		if(undefined!=$('#uploadopenexceldata')[0].files[0])
			formData.append('uploadopenexceldata',$('#uploadopenexceldata')[0].files[0]);
		
		$.ajax({
				url: '../suppliermaster/uploadsupplierexcel',
				type: 'post',
				dataType: 'json',
				processData: false, 
				contentType: false,
				data: formData,
				success: function (resp) {
		    	if(null!=resp){
						 $('#suppliername').val(resp.suppliername).trigger('change');
						
						 if(null!=resp.paytoname && resp.paytoname.toString().trim().length>0 &&  resp.paytoname!= undefined)
							 $('#paytoname').val(resp.paytoname);	 
						
						 if(null!=resp.suppliercountry && resp.suppliercountry.toString().trim().length>0 &&  resp.suppliercountry!= undefined)
						 	$('#suppliercountry').val(resp.suppliercountry);
						 
						 if(null!=resp.suppliercontactperson && resp.suppliercontactperson.toString().trim().length>0 &&  resp.suppliercontactperson!= undefined)
						 	$('#suppliercontactperson').val(resp.suppliercontactperson);
						 
						 if(null!=resp.supplieraddress1 && resp.supplieraddress1.toString().trim().length>0 &&  resp.supplieraddress1!= undefined)
						 	$('#supplieraddress1').val(resp.supplieraddress1);
						 
						 if(null!=resp.supplieraddress2 && resp.supplieraddress2.toString().trim().length>0 &&  resp.supplieraddress2!= undefined)
			     		 	$('#supplieraddress2').val(resp.supplieraddress2)
			     		 
			     		 if(null!=resp.supplieraddress3 && resp.supplieraddress3.toString().trim().length>0 &&  resp.supplieraddress3!= undefined)
			     		 	$('#supplieraddress3').val(resp.supplieraddress3);
						 
						 if(null!=resp.suppliercity && resp.suppliercity.toString().trim().length>0 &&  resp.suppliercity!= undefined)
			     		 	$('#suppliercity').val(resp.suppliercity);
						 
						 if(null!=resp.supplieremail && resp.supplieremail.toString().trim().length>0 &&  resp.supplieremail!= undefined)
			     		 	$('#supplieremail').val(resp.supplieremail);
						 
						 if(null!=resp.faxnumbers && resp.faxnumbers.toString().trim().length>0 &&  resp.faxnumbers!= undefined)
				     		 $('#supplierfax').val(resp.supplieremail);
						 
						 if(null!=resp.supplierpincode && resp.supplierpincode.toString().trim().length>0 &&  resp.supplierpincode!= undefined)
			     		 	$('#supplierpincode').val(resp.supplierpincode);
						 
						 if(null!=resp.contactperson && resp.contactperson.toString().trim().length>0 &&  resp.contactperson!= undefined)
			     		 	$('#suppliercontactperson').val(resp.contactperson);
						 
						 if(null!=resp.supplierphoneno && resp.supplierphoneno.toString().trim().length>0 &&  resp.supplierphoneno!= undefined)
							 $('#supplierphoneno').val(resp.supplierphoneno);
		        	}
		       
		      },
		});
	}
	
});



function capitalizeFirstLetter(string) {
	var str = string.toLowerCase();
    return str.charAt(0).toUpperCase() + str.slice(1);
}