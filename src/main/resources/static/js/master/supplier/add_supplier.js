
var details = JSON.parse(sessionStorage.getItem('userdetail'));
var serverurlCommon = '';
if(null!=details && undefined!=details){
	var serverurl = details.serverurl;
	if(null!=serverurl && serverurl.trim())
		serverurlCommon = serverurl;
}



var before_form_count = 0;
var stateedite=null;
var gst_vendor_type =null;
var branchesopen = null;

	$( document ).ajaxSend(function() {
		$('#before_form').show();
		before_form_count++;
	});
	
	$(document).ajaxComplete(function() {
		before_form_count--;
		if(before_form_count === 0){
			$('#before_form').hide();
		}
	});
	
	$(document).bind("DOMSubtreeModified", function(){
		$('.k-select').addClass('themeColor');                        
	});

                
	$(document).ready(function() {                                   
		var supplierjobtype = $("#supplierjobtype").kendoDropDownList({
			optionLabel: "Select Supplier Job Type...",
			dataTextField: "jobdescription",
			dataValueField: "jobtypeid",
			filter: "contains",
			dataSource: {	
				transport: {
					read: {
						url: serverurlCommon+"/mudrabizcomps/principaljobtypes",
						dataType: "json",
						beforeSend: function(req) {
							req.setRequestHeader('userid', "6543210");
							req.setRequestHeader('token', '1234abcd-5678efgh-1234abcd-5678efgh');
						}   
					  }
				    }
       			  },
       			  dataBound: function(e) {
       			  if(null!=jobtype && jobtype.toString().trim()){
       				  $('#supplierjobtype').data("kendoDropDownList").select(function(dataItem) {
       					  return dataItem.jobtypeid == jobtype;
       			 	  });
       			   }
       			}
			}).data("kendoDropDownList");
      });
                
                
	  $(document).on('click','#contractgrid div.k-header.k-grid-toolbar a.k-button.k-button-icontext.k-grid-add',function(){
          $('#contractdetails').modal('show');
      })

      $(document).on('click','#panbasegrid div.k-header.k-grid-toolbar a.k-button.k-button-icontext.k-grid-add',function(){
          $('#addgstindetails').modal('show');
      })

      $(document).on('click','#sachsngrid div.k-header.k-grid-toolbar a.k-button.k-button-icontext.k-grid-add',function(){
          $('#sachsndetailspop').modal('show');
      })  
      
                    
      var details = JSON.parse(sessionStorage.getItem('userdetail'));
      var uniqueid = details.uniqueid;
      var suppliergroupid1111 = $("#suppliergroupid").kendoDropDownList({
	       optionLabel: "Select Supplier Group...",
	       dataTextField: "suppliergroupname",
	       dataValueField: "suppliergroupid",
	       filter: "contains",
	       dataSource: {
	           transport: {
	           	read: {
	           		url: serverurlCommon+"/mudrabizcomps/suppliergroups/"+uniqueid+"",
	                   dataType: "json",
	                	beforeSend: function(req) {
						 req.setRequestHeader('userid', "6543210");
						req.setRequestHeader('token', '1234abcd-5678efgh-1234abcd-5678efgh');
	                 }   
	               }
	           }
	        },
	        dataBound: function(e) {
			         if(null!=suppliergroupid && suppliergroupid.toString().trim()){
			        	 this.select(function(dataItem) {
				         		    return dataItem.suppliergroupid === suppliergroupid;
				         	 });
			         }
	        }
	     }).data("kendoDropDownList");
			
      
	    var suppliertype = $("#suppliertype").kendoDropDownList({
	    	   optionLabel: "Select Supplier Type...",
	    	   dataTextField: "mastercode",
	    	   dataValueField: "mastercode",
	    	   filter: "contains",
	    	   dataSource: {
	    		   transport: {
	    			   read: {
	    				   url: "../suppliermaster/getsuppliertype",
	    				   type: "POST",
	    				   dataType: "json",
	    			   }
	    		   }
	    	   },
	        
	         dataBound: function(e) {
			         // handle the event
			         if(null!=suppliertypeedit && suppliertypeedit.toString().trim()){
			        	 this.select(function(dataItem) {
				         		    return dataItem.mastercode == suppliertypeedit;
				         	 });
			         }
	        }
	         
	      }).data("kendoDropDownList");
 	       
	    
	    var state = $("#state").kendoDropDownList({
	        optionLabel: "Select State...",
	        dataTextField: "charvalue1",
	        dataValueField: "charvalue1",
	        filter: "contains",
	        dataSource: {
	            transport: {
	            	read: {
	            		url: "../suppliermaster/getstatelist",
	                    type: "POST",
	                    dataType: "json",
	                }
	            },
	           
	         },
	        
	         dataBound: function(e) {
		        
		        	 this.select(function(dataItem) {
			         		return dataItem.charvalue1 == stateedit;
			         });
        	 }, 
	         
	      }).data("kendoDropDownList"); 	      
	    
	    
	    var gst_vendor_type = $("#gst_vendor_type ").kendoDropDownList({
	        optionLabel: "Select Gst  Vender Type...",
	        dataTextField: "masterdescription",
	        dataValueField: "masterdescription",
	        filter: "contains",
	        dataSource: {
	            transport: {
	            	read: {
	            		url: "../suppliermaster/getgstvendertype",
	                    type: "POST",
	                    dataType: "json",
	                }
	            }
	         },
	        
	         dataBound: function(e) {
			      if(null!=gst_vendor_type && undefined!=gst_vendor_type){
			    	  this.select(function(dataItem) {
			         		return dataItem.masterdescription == gst_vendor_type;
			          }); 
			      }  
        	 }, 
	      }).data("kendoDropDownList").list.width(400); 	     
		    
	    $("#supplierbranches").kendoDropDownTree({
	 		placeholder: "Select Branches...",
	 		tagMode: "single",
	 		filter: "contains",
	 		checkboxes: true,
	 		checkAll: true,
	 		noDataTemplate: 'No Branches Found!',
	 		dataTextField: "branchname",
	 		dataValueField: "uniqueid",
	 		autoClose: false,
	 		dataSource: {
	 	        transport: {
	 	        	read: {
	 	        		url:function(){
	 	       				var details = JSON.parse(sessionStorage.getItem('userdetail'));
	 	       				if(null!=details && undefined!=details){
	 	       					var uniqueid = details.uniqueid;
	 	       					var divisionid = details.divisionid;
	 	       					var companyid = details.companyid;
	 	       					var loginid = details.loginid;
	 	           				if(null!=uniqueid && undefined!=uniqueid )
	 	           					return serverurlCommon+"/mudrabizcomps/useraccessbranches/"+loginid+"/5202/"+companyid+"/"+divisionid+"";
	 	       				}
	 	       				return null;
	 	       			},
	 	                type: "GET",
	 	                dataType: "json",
	 	                contentType: "application/json",
	 	                beforeSend: function(req) {
	 						req.setRequestHeader('userid', "6543210");
	 					 	req.setRequestHeader('token', '1234abcd-5678efgh-1234abcd-5678efgh');
	 	                },
	 	            },
	 	        }
	 	    },
	 	    dataBound: function(e) {
	 	    	if(null!=branchesopen){
	 	    		$("#supplierbranches").data("kendoDropDownTree").value(branchesopen);
	 	 		}
	 		}
	 	}).data("kendoDropDownTree");	    
			   
		     
	    function saveSupplierData(){
			var  formData = new FormData();
			var supplierdetaildate={};
     			$('#suppliertab').find('input').each(function(){
     					var inputtype = $(this).attr('type');
     					var ids = 'none';
     					var values = 'none';
     					ids = $(this).attr('id');
     					var classes = $(this).hasClass('datepicker-default');
     					if('checkbox' === inputtype){
     						values = ($(this).prop('checked')?'Y':'N');
     					}else if(classes && null!=(values = $(this).val()) && values.trim()){
     						values = datetoNumberFormat(values);
     					}else{
     						values = $(this).val();
     					}
     					supplierdetaildate[ids] = values;
     			 });
     			
     			if(undefined!=$('#uploadpanfile')[0].files[0])
   					formData.append('uploadpanfile',$('#uploadpanfile')[0].files[0]);
     			
     			if(undefined!=$('#uploadziprarfile')[0].files[0])
   					formData.append('uploadziprarfile',$('#uploadziprarfile')[0].files[0]);
     			
     			formData.append('supplierdetaildate', new Blob([JSON.stringify(supplierdetaildate)], {type: "application/json"}));
     			console.log(formData);
     	}	     
	    
	    
	    $(document).on('click','.submitbtnclass',function(){
	    	var suppliereditflag = $('#suppliereditflag').val();
	    	var bankDetails={};
				var tabselected = $($(document).find('.nav-link.active')[0]).attr('aria-controls'); 	
				if('suppliertab'==tabselected || 'tdstab'==tabselected || 'banktab'==tabselected ){
					if(validation()){
						
						var supplierdetaildate = {};
						$('#suppliertab').find('input').each(function(){
  						supplierdetaildate[$(this).attr('id')] = $(this).val();
						});
					
					$('#suppliertab').find('input').each(function(){
						var inputtype = $(this).attr('type');
						var ids = 'none';
						var values = 'none';
						ids = $(this).attr('id');
						var classes = $(this).hasClass('datepicker-default');
						if('checkbox' === inputtype){
							values = ($(this).prop('checked')?'Y':'N');
						}
						else if('radio' === inputtype){
							values = ($(this).prop('checked')?'Y':'N');
						}
						
						else if(classes && null!=(values = $(this).val()) && values.trim()){
							values = datetoNumberFormat(values);
						}else{
							values = $(this).val();
						}
						supplierdetaildate[ids] = values;
					});	     
					
					$('#banktab').find('input').each(function(){
						bankDetails[$(this).attr('name')] = $(this).val();
					});
  					supplierdetaildate['suppliereditflag'] = suppliereditflag;
  					supplierdetaildate['userdetailbean'] = JSON.parse(sessionStorage.getItem('userdetail'));
  					supplierdetaildate['tdsdetailbean'] = getjsondata();
  					supplierdetaildate['bankDetails'] = bankDetails;
  					
  					var branches = [];
  					var copyclienttableList = $("#supplierbranches").data("kendoDropDownTree");
  					if(null!=copyclienttableList && undefined!=copyclienttableList){
  						var branches = copyclienttableList.value();
  						var objectArray = [];
  						var stringArray = [];
  						$.each(branches,function(i,data){
  							if(typeof data == "string"){
  								console.log(data);
  								stringArray.push(data);
  							}
  							if(typeof data == "object"){
  								console.log(data.uniqueid);
  								objectArray.push(data.uniqueid);
  							}
  						});

  						

  						$.each(stringArray,function(i,data){
  							console.log(data);
  							$.each(objectArray,function(j,data2){
  								if(data2 == data){
  									stringArray[j] = "";
  						        }
  							});
  						});
  						console.log(stringArray);
  						supplierdetaildate['branches'] = stringArray;
  					}
  					
  					var formData = new FormData();
  					
  					if(undefined!=$('#uploadpanfile')[0].files[0])
 	   					formData.append('uploadpanfile',$('#uploadpanfile')[0].files[0]);
 	     			
 	     			if(undefined!=$('#uploadziprarfile')[0].files[0])
 	   					formData.append('uploadziprarfile',$('#uploadziprarfile')[0].files[0]);
 	     				formData.append('supplierdetaildate', new Blob([JSON.stringify(supplierdetaildate)], {type: "application/json"}));


 	     				swal({
 	     				    title: "Confirm ?",
 	     				    text: "Do you want to save record ?",
 	     				    icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-confirm.png",
 	     				    showCancelButton: true,
 	     				    buttons: {
 	     				                confirm: {
 	     				                    text: "Yes",
 	     				                    value: true,
 	     				                    visible: true,
 	     				                    className: "themeColor",
 	     				                    closeModal: true
 	     				                },
 	     				                cancel: {
 	     				                    text: "No",
 	     				                    value: false,
 	     				                    visible: true,
 	     				                    className: "themeColor",
 	     				                    closeModal: true,
 	     				                }                
 	     				    }
 	     				}).then(isConfirm => {
 	     				    if (isConfirm) {
 	     				    	
	 	     				    	 $.ajax({
	 	     	  	   	            	url: '../suppliermaster/saveSupplierDatail',
	 	     	  	   	            	type: 'post',
	 	     	  	   	            	dataType: 'json',
	 	     	  	   	            	processData: false, 
	 	     	  	   	            	contentType: false,
	 	     	  	   	         		data: formData,
	 	     	  	   	            	success: function (resp) {
	 	     	  	   	            		$('#suppliereditflag').val('YES');
	 	     	  	   	            		var supplierid=$('#supplierid').val();
	 	     	  	   	            		$('#supplieridhd').val(supplierid)
	 	     	  	   	            		if(resp.SAVE=="YES"){
	 	     	   	                			errorMessage("success","Supplier Saved Successfully", "Saved Data");
		 	     	   	                		 setTimeout(() => {
		  	     	  	   	            			document.myform.method = 'POST';
		 	     	  	   	            			document.myform.action = '../suppliermaster/addsuppliermaster';
		 	     	  	   	            			document.myform.submit();
		  	     	  	   	 					 }, 3000);
	 	     	  	   	            		}
	 	     	  	   	            		
		     	  	   	            		if(resp['GLEXIST']!=null && resp['GLEXIST']!=""){
		     	  	   	            			errorMessage("error",resp['GLEXIST'], "Gl Code Exist");
			     	  	   	            		 setTimeout(() => {
			     	  	   	            			 window.location.href="../suppliermaster/";
			 	     	  	   	 				  }, 3000);
		     	  	   	            		 } 	    
	 	     	  	   	            		
	 	     	  	   	            		
	 	     	  	   	            		if(resp.UPDATE=="YES"){
	 	     	  	   	            				errorMessage("success","Supplier Update Successfully", "Update Data");
	 	     	  	   	            			
		 	     	  	   	            		 setTimeout(() => {
		 	     	  	   	            			document.myform.method = 'POST';
			     	  	   	            			document.myform.action = '../suppliermaster/addsuppliermaster';
			     	  	   	            			document.myform.submit();
		 	     	  	   	 					 }, 3000);
	
	 	     	  	   	            		}
	 	     	  	   	            	}, 	     	  	   	            
	 	     				    	 });	   
 	     				    	
 	     				    	}
 	     					});
 	     			
  				  		}
  					}
  				
  				else if("banktab"==tabselected){
  					saveBankDetails();
  				}
  				
  				else if("panbasedtab"==tabselected){
  					var panhederdata = {}
  					if(panbasedetailvalidation()){
  						$('#panbasedtab').find('input').each(function(){
  							panhederdata[$(this).attr('name')] = $(this).val();
  							var inputtype = $(this).attr('type');
  								var ids = 'none';
  								var values = 'none';
  								ids = $(this).attr('id');
  								if('checkbox' === inputtype){
  									values = ($(this).prop('checked')?'Y':'N');
  								}else{
  									values = $(this).val();
  								}
  								panhederdata[ids] = values;
  						});
  						
  						swal({
 	     				    title: "Confirm ?",
 	     				    text: "Do you want to save record ?",
 	     				    icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-confirm.png",
 	     				    showCancelButton: true,
 	     				    buttons: {
 	     				                confirm: {
 	     				                    text: "Yes",
 	     				                    value: true,
 	     				                    visible: true,
 	     				                    className: "themeColor",
 	     				                    closeModal: true
 	     				                },
 	     				                cancel: {
 	     				                    text: "No",
 	     				                    value: false,
 	     				                    visible: true,
 	     				                    className: "themeColor",
 	     				                    closeModal: true,
 	     				                }                
 	     				    }
 	     				}).then(isConfirm => {
 	     				    if (isConfirm) {
 	     				    	
 	     				   	$.ajax({
   							   url: '../supplierpandetail/savesuppliermastergstinheader',
   					           type: 'post',
   					           dataType: 'json',
   					           contentType: 'application/json',
   					           data: JSON.stringify(panhederdata),
   					           success: function (resp) {
   					        	errorMessage("success", "Data Saved Successfully", "Saved ..!");
   					        	getSupplierBackDetail();
   					           },
   					       });
 	     				 }
 	     				});
  					 }
  				  }
			 });
		     
		     
		     $(document).on('click','#existingrdbtn',function(){
		    	 if($(this).val()=="exist"){
		    		 $('#exitinggroup').show();
		    		 $('#shownewgroup').hide();
		    	 }
		    	 
		     });
		     
		     
		     $(document).on('click','#newgrouprdbtn',function(){
		    	 if($(this).val()=="new"){
		    		 $('#shownewgroup').show();
		    		 $('#exitinggroup').hide();
		    	 }
		    	 
		     });
		     
		     $(document).on('change','#supplierid',function(){
				  var supplierid = $(this).val();
				  if(null!=supplierid && supplierid.trim()){
					$.ajax({
						url: '../suppliermaster/duplicateSupplierId/'+supplierid,
						type: 'post',
						dataType: 'json',
						data:sessionStorage.getItem('userdetail'),
						contentType: 'application/json',
						success: function (resp) {
							console.log(resp);
							if(null!=resp){
								if(resp.SUPPLIERID_AVAILABLE == 'YES'){
									$('#supplierid').val('').focus();
									errorMessage("error","Duplicate Supplier Id should be restricted....!", "Duplicate..!");
								}	
							}	
						},
					});
				  }
		     });
		
		$(document).on('change','#suppliername',function(){
				var suppliername = $(this).val();
				  if(null!=suppliername && suppliername.trim()){
					$.ajax({
						url: '../suppliermaster/duplicateSupplierName/'+suppliername,
						type: 'post',
						dataType: 'json',
	   	         		data:sessionStorage.getItem('userdetail'),
	   	         		contentType: 'application/json',
	   	         		success: function (resp) {
	   	         			if(null!=resp){
	   	         				if(resp.SUPPLIERNAME_AVAILABLE == 'YES'){
	   	         					$('#suppliername').val('').focus();
	   	         					errorMessage("error","Duplicate Supplier name should be restricted....!", "Duplicate..!");
	   	         				}
	   	         					$('#displayname,#paytoname').val(suppliername).trigger('change');
	   	         			  }
	   	         			},
						});
				  	}
		});
		
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
	   	                		
	 function toUpperCaseFn(thiss){
		 thiss.value = ((null!=thiss.value&&thiss.value.trim())?thiss.value.toUpperCase():'');	  
  	 }   	                		
	   	                		
	 $(document).on('change','#pannumber',function(){
    		var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
    		if(!(panreg.test($(this).val()))){
    			$(this).val("").focus();
    			errorMessage("Info", "Please Enter Valid PAN No", "Required Filed..!");
    		}
      });	   	                			
	   	                	 
	   	                	 
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


	 $(document).on('change','#state',function(){
    		var statename = $(this).val();
    		if(null!=statename && statename.trim() && 'OUT SIDE INDIA' != statename.trim()){
    			$('#suppliercountry').val('India');
    		}else{
    			$('#suppliercountry').val('');
    		}
    });
	   	                	
	   	                	
		   			 
		     			
	   	                	function validation(){
	   	                		
	   	                		var filter =	/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i ;
	   	                		var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
	   	                		var supplierid=$('#supplierid').val();
	   	                		var suppliername=$('#suppliername').val();
	   	                		var displayname=$('#displayname').val();
	   	                		var pannumber = $('#pannumber').val();
	   	                		var suppliergroupidtxt=$('#suppliergroupid').val();
	   	                		var glcode=$('#glcode').val();
	   	                		var suppliercategory=$('#suppliercategory').val();	   	                		
	   	                		var suppliercountry = $('#suppliercountry').val();
	   	                		var suppliercontactperson = $('#suppliercontactperson').val();
	   	                		var supplieraddress1 = $('#supplieraddress1').val();
	   	                		var supplieraddress2 = $('#supplieraddress2').val();
	   	                		var supplieraddress3 = $('#supplieraddress3').val();
	   	                		var suppliercity = $('#suppliercity').val();
	   	                		var state = $('#state').val();
	   	                		var supplierphoneno = $('#supplierphoneno').val();
	   	                		var supplieremail = $('#supplieremail').val();  
	   	                		var supplierpincode = $('#supplierpincode').val(); 
	   	                		var supplierfax = $('#supplierfax').val(); 
	   	                		var newgroupid = $('#newgroupid').val(); 
	   	                		var newgroupname = $('#newgroupname').val();
	   	                		var newgrouprdbtn = $('#newgrouprdbtn').prop('checked');
	   	                		var existingrdbtn = $('#existingrdbtn').prop('checked');
	   	                		var gst_vt  = $('#gst_vendor_type').val()	   	                		
	   	                		var fv = $('#isforeignvendor').prop('checked');
	   	                		
	   	                		var suppliereditflag = $('#suppliereditflag').val();
	   	                		
	   	                		var pan_suppliername = $('#pan_suppliername').val();
	   	                		var  checkdata = $('#tdsbasegrid input:checked').length > 0;
	   	                		
	   	                		
	   	                		// BANK
	   	                		
	   	                		var beneficiaryname = $("#beneficiaryname").val();
		   	     				var accountnumber = $("#accountnumber").val();
		   	     				var ifsccode = $("#ifsccode").val();
		   	     				var bankname = $("#bankname").val();
		   	     				var branchname = $("#branchname").val();
		   	     				var benedescription = $("#benedescription").val();
		   	     				var ifscregex = /^[A-Za-z]{4}\d{7}$/;
		   	     			
	   	                		
	   	                		if(null==supplierid || !supplierid.trim()){
	   	                			errorMessage("info", "Please Enter Supplier Id", "Required Field..!");
	   	                			$('#supplierid').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if(null==suppliername || !suppliername.trim()){
	   	                			errorMessage("info", "Please Enter Supplier Name", "Required Field..!");
	   	                			$('#suppliername').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if(null==suppliername || !suppliername.trim()){
	   	                			errorMessage("info", "Please Enter Supplier Name", "Required Field..!");
	   	                			$('#suppliername').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if(null==suppliergroupidtxt || !suppliergroupidtxt.trim() && newgrouprdbtn==false){
	   	                			errorMessage("info", "Please Select Supplier Group Id", "Required Field..!");
	   	                			$('#suppliergroupid').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		
	   	                		if(null==newgroupid || !newgroupid.trim() && newgrouprdbtn==true){
	   	                			errorMessage("info", "Please Enter New Supplier Group Id", "Required Field..!");
	   	                			$('#newgroupid').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		
	   	                		if(null==newgroupname || !newgroupname.trim() && newgrouprdbtn==true){
	   	                			errorMessage("info", "Please Enter New Supplier Group Name", "Required Field..!");
	   	                			$('#newgroupname').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		
	   	                		if(null==glcode || !glcode.trim()){
	   	                			errorMessage("info", "Please Enter GL-Code", "Required Field..!");
	   	                			$('#suppliername').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if(null==suppliercategory || !suppliercategory.trim()){
	   	                			errorMessage("info", "Please Enter Supplier Category", "Required Field..!");
	   	                			$('#suppliercategory').focus();
	   	                			return false;
	   	                		}

	   	                		if(null==gst_vt || !gst_vt.trim()){
	   	                			errorMessage("info", "Please Select GST Vendor Type", "Required Field..!");
	   	                			$('#suppliercategory').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		
	   	                		if(null==pannumber || !pannumber.trim()){
	   	                			errorMessage("info", "Please Enter PAN Number", "Required Field..!");
	   	                			$('#pannumber').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if(null==pan_suppliername || !pan_suppliername.trim()){
	   	                			errorMessage("info", "Please Enter Pan Name (NSDL)", "Required Field..!");
	   	                			$('#pan_suppliername').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if( fv==true && gst_vt!="FOREIGN VENDOR" ){
	   	                			errorMessage("error", "Please Select GST Type FOREIGN VENDOR it Must be Required ", "Required Field..!");
	   	                			return false;
	   	                		}
	   	                		
	   	                		if(null==suppliercontactperson || !suppliercontactperson.trim()){
	   	                			errorMessage("info", "Please Enter Contact Person Name", "Required Field..!");
	   	                			$('#suppliercontactperson').focus();
	   	                			return false;
	   	                		}
								
	   	                		if((null==supplieraddress1 || !supplieraddress1.trim()) && (null==supplieraddress2 || !supplieraddress2.trim())  && (null==supplieraddress3 || !supplieraddress3.trim()) ){
	   	                			errorMessage("info", "Please Enter Address", "Required Field..!");
	   	                			return false;
	   	                		}
	   	                		
	   	                		var addressLen =  supplieraddress1+""+supplieraddress3+""+supplieraddress3;
	   	                		if(addressLen.length<20){
	   	                			errorMessage("info", "Address must be 20 character", "Required Field..!");
	   	                			return false;
	   	                		}
	   	                		
	   	                		
	   	                		if(null==suppliercity || !suppliercity.trim()){
	   	                			errorMessage("info", "Please Enter City", "Required Field..!");
	   	                			$('#suppliercity').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if(null==state || !state.trim()){
	   	                			errorMessage("info", "Please Enter State", "Required Field..!");
	   	                			$('#state').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		
	   	                		if(null!=supplierphoneno && supplierphoneno.toString().trim() && supplierphoneno.toString().trim().length<10){
	   	                			errorMessage("info", "Please Enter Fax No", "Required Field..!");
	   	                			$('#supplierphoneno').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		
	   	                		
	   	                		if(null!=supplierfax && supplierfax.toString().trim() && supplierfax.toString().trim().length<10){
	   	                			errorMessage("info", "Please Enter Phone", "Required Field..!");
	   	                			$('#supplierfax').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if('OUT SIDE INDIA' === state && !(gst_vt==="FOREIGN VENDOR" || gst_vt==="UNITED NATIONS ORGANISATIONS IN FOREIGN" || gst_vt==="RELATED PARTY FOREIGN" )){
	   	                			errorMessage("info", "Please Select GST Vendor Type FOREIGN..!", "Required Field..!");
	   	                			return false;
	   	                		}
	   	                		
	   	                		if('OUT SIDE INDIA' == state && (null==suppliercountry || !suppliercountry.trim())){
	   	                			errorMessage("info", "Please enter country name..!", "Required Field..!");
	   	                			$('#state').focus();
	   	                			return false;
	   	                		}else if((null==supplierpincode || !supplierpincode.trim()) && ('OUT SIDE INDIA' != state)){
	   	                			errorMessage("info", "Pincode Must Be 6 Digit in Address Information!", "Required Field..!");
	   	                			$('#supplierpincode ').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		if('OUT SIDE INDIA' != state && null!=startpinmask && null!=endpinmask){
	   	                			var startpinmasklength = startpinmask.toString().length;
	   	                			if(!(parseInt(supplierpincode.substring(0,startpinmasklength)) >= startpinmask  && parseInt(supplierpincode.substring(0,startpinmasklength)) <= endpinmask)){
	   	                				errorMessage("info", "Please Enter Correct Pincode for Selected State in Address Information..!!", "Doesn't match ");
	   	                				$('#supplierpincode').focus();
	   	                				return false;
	   	                			}
	   	                		}
								
	   	                		if(null!=supplieremail && supplieremail.trim() && !filter.test(supplieremail)){
	   	                			errorMessage("info", "Invalid Email", "Required Field..!");
	   	                			$('#supplieremail').focus();
	   	                			return false;
	   	                		}
	   	                		
	   	                		// TDS VALIDATION  
	   	                		
	   	                		if(checkdata==false){
	   	                			errorMessage("error", "Please Select Default Tds Detail", "Required Field..!");
	   	                			return false;
	   	                		}
	   	                	

	   	                //if(bankaddflag==true){
	   	                	
	   	     				if(null==beneficiaryname || !beneficiaryname.trim())
	   	     				{
	   	     					errorMessage("info", "Please Enter Beneficiary Name", "Required Filed..!");
	   	     					$('#beneiciaryname').focus();
	   	     					return false;
	   	     				}
	   	     				else if(null==accountnumber || !accountnumber.trim())
	   	     				{
	   	     					errorMessage("info", "Please Enter Account Number", "Required Filed..!");
	   	     					$('#accountnumber').focus();
	   	     					return false;
	   	     				}
	   	     				else if(null!=accountnumber && accountnumber.trim().length<9)
	   	     				{
	   	     					errorMessage("info", "Please Enter Correct Account Number<br>Account Number Must have  minimum length of 9 digits.", "Invalid Filed..!");
	   	     					$('#accountnumber').focus();
	   	     					return false;
	   	     				}
	   	     				else if(null==ifsccode || !ifsccode.trim())
	   	     				{
	   	     					errorMessage("info", "Please Enter IFSC Code", "Required Filed..!");
	   	     					$('#ifsccode').focus();
	   	     					return false;
	   	     				}
	   	     				else if(!ifscregex.test(ifsccode))
	   	     				{
	   	     					errorMessage("info", "Please Enter Correct IFSC Code", "Invalid Filed..!");
	   	     					$('#ifsccode').focus();
	   	     					return false;
	   	     				}
	   	     				else if(null==bankname || !bankname.trim())
	   	     				{
	   	     					errorMessage("info", "Please Enter Bank Name", "Required Filed..!");
	   	     					$('#bankname').focus();
	   	     					return false;
	   	     				} 
	   	     				else if(null==branchname || !branchname.trim())
	   	     				{
	   	     					errorMessage("info", "Please Enter Branch Name", "Required Filed..!");
	   	     					$('#branchname').focus();
	   	     					return false;
	   	     					} 
	   	                	//}
	   	                return true;
	   	                }
	   	                		
	   	                		
	   	                		
	   	                		
	   	                		
					
					
					
			// GL CODE
				
				var supplieridhd=$('#supplieridhd').val();
				
				if(null!=supplieridhd && supplieridhd.trim()){
					var urlpath = '../clientmaster/getclientdetail/'+supplieridhd;
				   	$.ajax({
			        	 url: urlpath,
			        	 method:'POST',
			        	 dataType:'json',
			        	 contentType: "application/json",
			        	 data:sessionStorage.getItem('userdetail'),
			        	 success:function(resp){
			        		 if(null!=resp){
			        			 $('#base-tab22,#base-tab23,#base-tab24,#base-tab25,#base-tab26').attr('data-toggle','tab'); 

			        		 }
			        	 },
			        	 complete:function(){
			        		 console.log('Complete Ajax');
			        	 }
			      });
			   }else{
				   	$.ajax({
				         	 url:'../suppliermaster/getglcode',
				         	 method:'POST',
				         	 dataType:'json',
				         	 data:sessionStorage.getItem('userdetail'),
				         	 contentType: 'application/json',
				         	 success:function(resp){
				         		 if( null!=resp && null!=resp.glavailable && 'YES'===resp.glavailable && null!=resp.glvalid && 'YES'===resp.glvalid ){
				         			 $('#glcode').val(resp.NUMVALUE1);
				         		 }else{
				         			errorMessage("info", "GLCODE Not Found OR Not Valid...!", "Please Contact IT..!");
				         			setTimeout(() => {
				         				window.location.href="../suppliermaster/"
								}, 1000*4); 
				         			 
				         		 }
				         	 },
				         	 complete:function(){
				         		 console.log('Complete Ajax');
				         	 }
				      });
				}
				
					


		   $(document).on('change','#newgroupid',function(){
					  var newgroupid = $(this).val();
					  if(null!=newgroupid && newgroupid.trim()){
						$.ajax({
		 	            url: '../suppliermaster/duplicateSupplierGrpId/'+newgroupid,
		 	            type: 'post',
		 	            dataType: 'json',
		 	         	data:sessionStorage.getItem('userdetail'),
		 	            contentType: 'application/json',
		 	            success: function (resp) {
		 	                console.log(resp);
		 	                if(null!=resp){
		 	                	if(resp.SUPPLIERGRPID_AVAILABLE == 'YES'){
		 	                		$('#newgroupid').val('').focus();
		 	                		errorMessage("error","Duplicate Supplier Group ID should be restricted....!", "Duplicate..!");
		     	                }	
		 	                }	
		 	            },
		 	        });
				}
			});
		
		$(document).on('change','#newgroupname',function(){
				var newgroupname = $(this).val();
				  if(null!=newgroupname && newgroupname.trim()){
					$.ajax({
	   	            url: '../suppliermaster/duplicateSupplierGrpName/'+newgroupname,
	   	            type: 'post',
	   	            dataType: 'json',
	   	         	data:sessionStorage.getItem('userdetail'),
	   	            contentType: 'application/json',
	   	            success: function (resp) {
	   	                if(null!=resp){
	   	                	if(resp.SUPPLIERGRPNAME_AVAILABLE == 'YES'){
	   	                		$('#newgroupname').val('').focus();
	   	                		errorMessage("error","Duplicate Supplier Group Name should be restricted....!", "Duplicate..!");
	       	                }	
	   	                }
	   	            },
	   	        });
			}
		});
					
		function kendoFastReDrawRow(grid, row) {
		    var dataItem = grid.dataItem(row);
		    var rowChildren = $(row).children('td[role="gridcell"]');
		    for (var i = 0; i < grid.columns.length; i++) {
		        var column = grid.columns[i];
		        var template = column.template;
		        var cell = rowChildren.eq(i);
		        if (template !== undefined) {
		            var kendoTemplate = kendo.template(template);
		            cell.html(kendoTemplate(dataItem));
		        } else {
		            var fieldValue = dataItem[column.field];
		            var format = column.format;
		            var values = column.values;
		            if (values !== undefined && values != null) {
		                // use the text value mappings (for enums)
		                for (var j = 0; j < values.length; j++) {
		                    var value = values[j];
		                    if (value.value == fieldValue) {
		                        cell.html(value.text);
		                        break;
		                    }
		                }
		            } else if (format !== undefined) {
		                cell.html(kendo.format(format, fieldValue));
		            } else {
		                cell.html(fieldValue);
		            }
		        }
		    }
		}
	
		// Supplier Edit
		var startpinmask = null;
		var endpinmask = null;
		var jobtype ;
		var suppliergroupid ;
		var suppliertypeedit;
		var gst_vendor_type;
		var stateedit;
		var pincodeglobal ;


		function setsupplierdata(){
			var supplieridhd = $('#supplieridhd').val();
			if(null!=supplieridhd && supplieridhd.trim().length>0){
				var details = JSON.parse(sessionStorage.getItem('userdetail'));
			    var uniqueid = details.uniqueid;
			    if(null!=uniqueid && undefined!==uniqueid && uniqueid!=""){
				 $.getJSON( "../suppliermaster/getsupplieredit/"+supplieridhd+"/"+uniqueid, function(resp) {
					 
					 $('#supplierid').val(resp[0].supplierid).prop('readonly',true);
					 $('#suppliername').val(resp[0].suppliername).prop('readonly',true);
					 $('#pannumber,#glcode,#pan_suppliername').prop('disabled',true);
					 
					 if(null!=resp[0].displayname && resp[0].displayname.toString().trim().length>0 &&  resp[0].displayname!= undefined)
						$('#displayname').val(resp[0].displayname);	 
				
					 if(null!=resp[0].paytoname && resp[0].paytoname.toString().trim().length>0 &&  resp[0].paytoname!= undefined)
						 $('#paytoname').val(resp[0].paytoname);	 
				
					 if(null!=resp[0].pannumber && resp[0].pannumber.toString().trim().length>0 &&  resp[0].pannumber!= undefined)
					 	$('#pannumber').val(resp[0].pannumber).prop('readonly',true).trigger('change');
					 
					 if(null!=resp[0].glcode && resp[0].glcode.toString().trim().length>0 &&  resp[0].glcode!= undefined)
					 	$('#glcode').val(resp[0].glcode);
					 
					 if(null!=resp[0].suppliercategory && resp[0].suppliercategory.toString().trim().length>0 &&  resp[0].suppliercategory!= undefined)
					 	$('#suppliercategory').val(resp[0].suppliercategory);
					 
					 if(null!=resp[0].country && resp[0].country.toString().trim().length>0 &&  resp[0].country!= undefined)
					 	$('#suppliercountry').val(resp[0].country);
					 
					 if(null!=resp[0].contactperson && resp[0].contactperson.toString().trim().length>0 &&  resp[0].contactperson!= undefined)
					 	$('#suppliercontactperson').val(resp[0].contactperson);
					 
					 if(null!=resp[0].address1 && resp[0].address1.toString().trim().length>0 &&  resp[0].address1!= undefined)
					 	$('#supplieraddress1').val(resp[0].address1);
					 
					 if(null!=resp[0].address2 && resp[0].address2.toString().trim().length>0 &&  resp[0].address2!= undefined)
		     		 	$('#supplieraddress2').val(resp[0].address2)
		     		 
		     		 if(null!=resp[0].address3 && resp[0].address3.toString().trim().length>0 &&  resp[0].address3!= undefined)
		     		 	$('#supplieraddress3').val(resp[0].address3);
					 
					 if(null!=resp[0].city && resp[0].city.toString().trim().length>0 &&  resp[0].city!= undefined)
		     		 	$('#suppliercity').val(resp[0].city);
					 
					 if(null!=resp[0].emailid && resp[0].emailid.toString().trim().length>0 &&  resp[0].emailid!= undefined)
		     		 	$('#supplieremail').val(resp[0].emailid);
					 
					 if(null!=resp[0].faxnumbers && resp[0].faxnumbers.toString().trim().length>0 &&  resp[0].faxnumbers!= undefined)
			     		 $('#supplierfax').val(resp[0].faxnumbers);
					 
					
					 if(null!=resp[0].pin && resp[0].pin.toString().trim().length>0 &&  resp[0].pin!= undefined){
		     		 	$('#supplierpincode').val(resp[0].pin);
		     		 	
					 }
					 
					 // FILE DOWNLOAD---
					 
					 $('#downloadfile11').show();
					 
					 if(null!=resp[1].pan_url && resp[1].pan_url!=undefined && resp[1].pan_file==='yes')
						 $('#downloadpan').prop('href',"."+resp[1].pan_url);
					 else
						 $('#downloadpan').prop('href',"#")
					 
					 if(null!=resp[1].zip_url && resp[1].zip_url!=undefined && resp[1].zip_file==='yes')
						 $('#downloadzip').prop('href',"."+resp[1].zip_url);
					 else
						 $('#downloadzip').prop('href',"#")
					 
					 
					 
					 
					 if(null!=resp[0].contactperson && resp[0].contactperson.toString().trim().length>0 &&  resp[0].contactperson!= undefined)
		     		 	$('#suppliercontactperson').val(resp[0].contactperson);
					 
					 if(null!=resp[0].creditdays && resp[0].creditdays.toString().trim().length>0 &&  resp[0].creditdays!= undefined)
		     		 	$('#creditdays').val(resp[0].creditdays);
					 
					 if(null!=resp[0].creditdays && resp[0].creditdays.toString().trim().length>0 &&  resp[0].creditdays!= undefined)
			     		 $('#creditdays').val(resp[0].creditdays);
					 
					 if(null!=resp[0].commissionpercentage && resp[0].commissionpercentage.toString().trim().length>0 &&  resp[0].commissionpercentage!= undefined)
			     		 $('#commissionpercentage').val(resp[0].commissionpercentage);
					 
					 if(null!=resp[0].telephonenumbers && resp[0].telephonenumbers.toString().trim().length>0 &&  resp[0].telephonenumbers!= undefined)
						 $('#supplierphoneno').val(resp[0].telephonenumbers);
					 
					 if(null!=resp[0].pan_suppliername && resp[0].pan_suppliername.toString().trim().length>0 &&  resp[0].pan_suppliername!= undefined)
						 $('#pan_suppliername').val(resp[0].pan_suppliername);
					 
					 suppliergroupid = resp[0].suppliergroupid;
					 
					 jobtype  = resp[0].jobtypeid;
					 suppliertypeedit  = resp[0].suppliertype;
			         if(null!=suppliertypeedit && suppliertypeedit.toString().trim()){
			        	 $("#suppliertype").data("kendoDropDownList").select(function(dataItem) {
				         		    return dataItem.mastercode == suppliertypeedit;
				         });
			         }
			         
			         var supgrp = $("#suppliergroupid").data("kendoDropDownList");
			         supgrp.enable(false);
			         
			       
			         
			        
			         
			         
			         
			         $('#existingrdbtn,#newgrouprdbtn').prop('disabled',true);
			        
					 gst_vendor_type  = resp[0].gst_vendor_type;
					 if(null!=gst_vendor_type && gst_vendor_type.toString().trim()){
						 $("#gst_vendor_type ").data("kendoDropDownList").select(function(dataItem) {
				         		    return dataItem.masterdescription == gst_vendor_type;
				         	 });
			         }
					 
					  var gstv = $("#gst_vendor_type").data("kendoDropDownList");
				         gstv.enable(false);
				         
				         $('#gst_vendor_type').trigger('change');
					 stateedit = resp[0].state;
					 
					$('.isactive,.changepan,.changesupplier').show();
					if(resp[0].isactive==='Y')
		    			$('#isactive').attr('checked', true)
		    		else
		    			$('#isactive').attr('checked', false)
					
					if(resp[0].ismsmedvendor==='Y')
		    			$('#ismsmedvendor').attr('checked', true)
		    		else
		    			$('#ismsmedvendor').attr('checked', false)
					
					if(resp[0].isforeignvendor==='Y')
		    			$('#isforeignvendor').attr('checked', true).trigger('change').prop('disabled',true);
		    		else
		    			$('#isforeignvendor').prop('disabled',true);
					
					if(resp[0].isacknowledgement==='Y')
		    			$('#isacknowledgement').attr('checked', true);
		    		else
		    			$('#isacknowledgement').attr('checked', false);
					 
					if(resp[0].isonlineservice==='Y')
		    			$('#isonlineservice').attr('checked', true);
		    		else
		    			$('#isonlineservice').attr('checked', false);
					
					if(resp[0].issquarecentimeter==='Y')
		    			$('#issquarecentimeter').attr('checked', true).prop('disabled',false);
		    		else
		    			$('#issquarecentimeter').attr('checked', false).prop('disabled',false);
					
					if(resp[0].isblacklisted==='Y')
		    			$('#isblacklisted').attr('checked', true).prop('disabled',false);
		    		else
		    			$('#isblacklisted').attr('checked', false).prop('disabled',false);
					
					branchesopen = resp[1].branchesopen;
					if(null!=branchesopen && undefined!=branchesopen)
						$("#supplierbranches").data("kendoDropDownTree").value(branchesopen);
					
					// CHANGE SUPPLIER INFO FOR INFO
					
					if(null!=resp[0].suppliername && resp[0].suppliername.toString().trim().length>0 &&  resp[0].suppliername!= undefined)
						 $('#oldsuppliername').val(resp[0].suppliername);
		 				 $('#newsupplierdate').val(resp[0].createdon);

					
		 				var stateedit = resp[0].state;
		 				$('#state').data("kendoDropDownList").select(function(dataItem) {
		 				    return dataItem.charvalue1 == stateedit;
		 				});
		 				
		 				jobtype = resp[0].jobtypeid;
		 				$('#supplierjobtype').data("kendoDropDownList").select(function(dataItem) {
		 				    return dataItem.jobtypeid == jobtype;
		 				});
		 				$('#supplier-tab,#tds-tab,#panbased-tab,#bank-tab').attr('data-toggle','tab').removeClass('disabled'); 
		     	});
				
			  }	
			}
			else{
				$('.hideexcle').show();
			}
		}

		

		$(document).ready(function(){
			setsupplierdata();
		});


		 function changsuppliername(){
			var newsuppliername = $('#newsuppliername').val();
				if(null!=newsuppliername && newsuppliername.toString().trim().length>0){
					var suppliername = $('#newsuppliername').val();
					$('#suppliername').val(suppliername);
					$('#changesupplier').modal('hide');
				}
				else{
					errorMessage("info","Please Enter New  Supplier Name", "Message..!");
				}
			}
			

		 
		 //CHANGE SUPPUPPLIER INFO
		 
		 $(document).on('change','#newsuppliername',function(){
						var suppliername = $(this).val();
						  if(null!=suppliername && suppliername.trim()){
							$.ajax({
			   	            url: '../suppliermaster/duplicateSupplierName/'+suppliername,
			   	            type: 'post',
			   	            dataType: 'json',
			   	         	data:sessionStorage.getItem('userdetail'),
			   	            contentType: 'application/json',
			   	            success: function (resp) {
			   	                if(null!=resp){
			   	                	if(resp.SUPPLIERNAME_AVAILABLE == 'YES'){
			   	                		$('#newsuppliername').val('').focus();
			   	                		errorMessage("error","Duplicate Supplier name should be restricted....!", "Duplicate Supplier Name..!");
			       	                }	
			   	                }
			   	            },
			   	        });
				    }
				});
		 
		 $("#changepan").on('shown.bs.modal' ,function(){
			 var  pannumber = $('#pannumber').val();
			 $('#oldpannumber').val(pannumber).prop('readonly',true);
		 })     
		
		 function openChange(){
			 var details = JSON.parse(sessionStorage.getItem('userdetail'));
			 var loginid = details.loginid;
				 if(null!=loginid && loginid!=undefined && loginid!=""){
					 $.getJSON( "../suppliermaster/getsupplierchange/"+loginid+"", function(resp) {
						 if(null!=resp){
		   	                	if(resp['ACCESS']!=""){
		   	                		errorMessage("error",resp['ACCESS'], "Access Denied..!");
		   	                		return false;
		       	                }
		   	                	else{
		   	                		 $('#changepan').modal('show');
		   	                	}
							 	$('#newpannumber,#effactivefromdate,#effactivetodate,#newuploadpan').val('');
							 	$('#changepan').modal('show');
		   	                }
					 });
				 }
		  }
		 
		 
		 
		 function savechangepan(){
			var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
			var  oldpannumber = $('#oldpannumber').val();
			var  supplierid = $('#supplierid').val();
			var  newpannumber = $('#newpannumber').val();
			var  effactivefromdate = $('#effactivefromdate').val();
			var  effactivetodate = $('#effactivetodate').val();
			if(null==newpannumber || newpannumber.trim().length==0){
				errorMessage("info","Pannumber Must  be Contain 10 Characters", "Message");
				return false;
			}
		
       		if(null!=newpannumber && newpannumber.trim() && !panreg.test(newpannumber)){
       			errorMessage("info", "Please Enter Valid Pannumber", "Invalid Pan..!");
       			$('#newpannumber').focus();
       			return false;
       		}
			
			var changepandata={};
			var details = JSON.parse(sessionStorage.getItem('userdetail'));
			var uniqueid = details.uniqueid;
				changepandata['supplierid']=supplierid;
				changepandata['newpannumber']=newpannumber;
				changepandata['oldpannumber']=oldpannumber;
				changepandata['uniqueid']=uniqueid;
			if(null!=effactivefromdate && effactivefromdate.trim().length>0){
				changepandata['effactivefromdate']=effactivefromdate;
			}
			if(null!=effactivetodate && effactivetodate.trim().length>0){
				changepandata['effactivetodate']=effactivetodate;
			}
		
			var formData = new FormData();
				
				if(undefined!=$('#newuploadpan')[0].files[0])
					formData.append('newuploadpan',$('#newuploadpan')[0].files[0]);
				
					formData.append('changepandata', new Blob([JSON.stringify(changepandata)], {type: "application/json"}));
					
					
					$.ajax({
		         	url: '../suppliermaster/savechangpandata',
		         	type: 'post',
		         	dataType: 'json',
		         	processData: false, 
		         	contentType: false,
		      		data: formData,
		         	success: function (resp) {
		         		console.log(resp);
		         			if(resp['NEWPANNUMBER']=='YES'){
		         				errorMessage("error",'This PAN Already Change', "New Pan");
		         				return false;
			         		}
		         			
		         			if(resp['SUCCESS']!=null){
		         				errorMessage("success",resp['SUCCESS'], "Update Pan");
			         		}

		         			if(resp['NEWSUPPLIEREXIST']=="YES"){
		         				errorMessage("warning","New PAN  Already Exist ", "New PAN");
		         				return false;
			         		}
		         			
		         			if(resp['ERRORMASSAGE']!=null){
			         			errorMessage("error",resp['ERRORMASSAGE'], "Error");
			         			return false;
			         		}
		         			
		         			$('#changepan').modal('hide');
		         			
		         		setTimeout(() => {
		         			setsupplierdata();
						}, 3000);
		         		
		         		
		         },
		     });	  
		 }
		 
		 
		 
		 

		 $(document).on('change','#state',function(){
		 	var state = $(this).val();
		 	if(null!=state && state.trim()){
		 		$.ajax({
		 			url:'../suppliermaster/getstatepinmask/'+state,
		 			method:'POST',
		 			dataType:'JSON',
		 			contentType: 'application/json',
		 			success:function(resp){
		 			    if(null!=resp){
		 			    	startpinmask = resp.numvalue1; 
		 			    	endpinmask = resp.numvalue2; 
		 			    }
		 			},
		 		});
		 		if(null!=state && state.trim() && 'OUT SIDE INDIA' != state.trim()){
		 			$('#suppliercountry').val('India');
		 		}else{
		 			$('#suppliercountry').val('');
		 		}
		 		
		 		
		 	}
		 }); 


		 
		 
		 // SUPPLIER VALIDTION
		 
		 
		$(document).on('change', '#uploadziprarfile', function () {
			var validatefile= checkFileUpload('myform','uploadziprarfile',"5",['zip','rar']);
			if(validatefile==false){
				$(this).val('');
			    return false;
			}else{
			    //readURL(this);
			}
		});
		 
		$(document).on('change', '#uploadpanfile', function () {
			var validatefile= checkFileUpload('myform','uploadpanfile',"5",['pdf']);
			if(validatefile==false){
				$(this).val('');
			    return false;
			}else{
			}
		});
		 

		function checkFileUpload(formId, htmlObjId, maxFileSize,extArr){    	//   
			if (window.File && window.FileReader && window.FileList && window.Blob) {
				var fsize=document.forms[formId][htmlObjId].files[0].size;
				var ftype =document.forms[formId][htmlObjId].files[0].type;  	
				var fname= document.forms[formId][htmlObjId].files[0].name; 	 
				if (fsize > (maxFileSize*1000000)) {
					errorMessage("error","File should be less then "+maxFileSize+"MB","File Not Support..!");
					return false;
				} else {
					var sFileName = fname;
					var sExt = sFileName.split('.')[sFileName.split('.').length - 1].toLowerCase();
					if(extArr.indexOf(sExt)<0){
						errorMessage("error","Please Upload Only "+extArr+" File","File Not Support..!");
						return false;
					}
				}
			}
			return true;
		}
		 
		
		
		
		$('#gst_vendor_type').on('change',function(){
			var gst ;
			var suppliereditflag = $('#suppliereditflag').val();
			var gsttype = $("#gst_vendor_type").data("kendoDropDownList");
			var statecobo = $("#state").data("kendoDropDownList");
			
			if($(this).val()==="FOREIGN VENDOR" || $(this).val()==="UNITED NATIONS ORGANISATIONS IN FOREIGN" || $(this).val()==="RELATED PARTY FOREIGN" ){
				
				/*$("#gst_vendor_type ").data("kendoDropDownList").select(function(dataItem) {
				  	return dataItem.masterdescription == "FOREIGN VENDOR";
				});
				*/
				
				if(suppliereditflag=='YES'){
					gsttype.enable(false);
				}
				
				statecobo.enable(false);
				
				$('#state').data("kendoDropDownList").select(function(dataItem) {
 				    return dataItem.charvalue1 == "OUT SIDE INDIA";
 				});
				
				if($(this).val()==="FOREIGN VENDOR"){
					$('#isforeignvendor').prop('checked',true).trigger('change');
				}
				
				
				
				
				
				$('#supplierpincode').val("").prop('disabled',true);
				
			 }else{
				 
			/*	$("#gst_vendor_type ").data("kendoDropDownList").select(function(dataItem) {
				  	return dataItem.masterdescription == gst_vendor_type;
				});*/ 
				 	gsttype.enable(true);
					statecobo.enable(true);
				$('#state').data("kendoDropDownList").select(function(dataItem) {
 				    return dataItem.charvalue1 == "";
 				});
				$('#supplierpincode').prop('disabled',false);
			 }
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//isforeignvendor
		 
		
		$('#isforeignvendor').on('change',function(){
			var gst ;
			var gsttype = $("#gst_vendor_type").data("kendoDropDownList");
			var statecobo = $("#state").data("kendoDropDownList");
			
			if($(this).prop('checked')){
				
				$("#gst_vendor_type ").data("kendoDropDownList").select(function(dataItem) {
				  	return dataItem.masterdescription == "FOREIGN VENDOR";
				});
				
				gsttype.enable(false);
				statecobo.enable(false);
				
				$('#state').data("kendoDropDownList").select(function(dataItem) {
 				    return dataItem.charvalue1 == "OUT SIDE INDIA";
 				});
				
				$('#supplierpincode').val("").prop('disabled',true);
				
			 }else{
				 
				$("#gst_vendor_type ").data("kendoDropDownList").select(function(dataItem) {
				  	return dataItem.masterdescription == gst_vendor_type;
				}); 
					gsttype.enable(true);
					statecobo.enable(true);
				$('#state').data("kendoDropDownList").select(function(dataItem) {
 				    return dataItem.charvalue1 == "";
 				});
				$('#supplierpincode').prop('disabled',false);
			 }
		});
		
		$(document).on('change','#newpannumber',function(){
       		var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
       		if(!(panreg.test($(this).val()))){
       			$(this).val("").focus();
       			errorMessage("Info", "Please Enter Valid PAN No", "Required Filed..!");
       		}
       	});

		$(document).on('change','#oldpannumber',function(){
       		var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
       		if(!(panreg.test($(this).val()))){
       			$(this).focus();
       			errorMessage("Info", "Please Enter Valid PAN No", "Required Filed..!");
       		}
       	});
		
		function compareTwoDates(mmddyyyyMin,mmddyyyyMax, sepratorChar){ // here Date Foremate : dd-mm-yyyy    &  sepratorChar :  '-'
			var datepart = mmddyyyyMin.split(sepratorChar);
			var mmddyyyyMin = new Date(datepart[0]+"/"+datepart[1]+"/"+datepart[2]);
			datepart = mmddyyyyMax.split(sepratorChar);
			var mmddyyyyMax = new Date(datepart[0]+"/"+datepart[1]+"/"+datepart[2]);
			 if(mmddyyyyMax <= mmddyyyyMin)   {
			    return false;
			  }
			 return true;
			}
	
		//SYSTEMDATE
		//EFFACTIVEFROMDATE
	
		$('#effactivefromdate').on('change',function(){
			var inputdate = $(this).val();
			var systemdate = $('#systemdate').val();
		if(null!=systemdate && systemdate.toString().trim().length>0 && null!=inputdate && inputdate.toString().trim().length>0){
			if(compareTwoDates(systemdate,inputdate,"/")==false){
				errorMessage("error", "From Date Should Be Greater To Current Date", "INVALID DATE..!");
				$(this).val('');
				return false;
				}
			}
		});
		
		
		$('#effactivetodate').on('change',function(){
			var inputdate = $(this).val();
			var effactivefromdate = $('#effactivefromdate').val();
			if(null==effactivefromdate || effactivefromdate==undefined ||  effactivefromdate.toString().trim().length==0){
				errorMessage("error", "Please Select From Date", "Date Required..!");
				$(this).val('');
				return false
			}
			
			
		if(null!=effactivefromdate && effactivefromdate.toString().trim().length>0 && null!=inputdate && inputdate.toString().trim().length>0){
			if(compareTwoDates(effactivefromdate,inputdate,"/")==false){
				errorMessage("error", "To Date Should Be Greater To From Date", "INVALID DATE..!");
				$(this).val('');
				return false;
				}
			}
		});
		
		
		$(document).on('change', '#newuploadpan', function () {
			var validatefile= checkFileUpload('panform','newuploadpan',"5",['pdf']);
			if(validatefile==false){
				$(this).val('');
			    return false;
			}else{
			}
		});
		
		function gotohome(){
			document.urlredirect.method='POST';
			document.urlredirect.action='../suppliermaster/';
			document.urlredirect.submit();
		}
		
		
		
		
		
		