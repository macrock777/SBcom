/*// save the real open
var oldOpen = XMLHttpRequest.prototype.open;

function onStateChange(event) {
	// fires on every readystatechange ever
    // use `this` to determine which XHR object fired the change event
	
	console.log('Open Change...!');
	console.log(event);
}

XMLHttpRequest.prototype.open = function() {
    // when an XHR object is opened, add a listener for its readystatechange events
    this.addEventListener("readystatechange", onStateChange)
    console.log('Open Ajax...!');
    // run the real `open`
    oldOpen.apply(this, arguments);
}*/

var details = JSON.parse(sessionStorage.getItem('userdetail'));
var serverurlCommon = '';
if(null!=details && undefined!=details){
	var serverurl = details.serverurl;
	if(null!=serverurl && serverurl.trim())
		serverurlCommon = serverurl;
}

var clientgroupidshow = null;
var clienttype1show = null;
var gstclienttypeshow = null;
var clientgroupid = null;
var servicetype = null;
var editstatelist = null;
var startpinmask = null;
var endpinmask = null;

var clientedit = 'NO';

function gotoHome(){
	window.location.href = '../clientmaster/';
}

function clientAddressValidation(){
	
	var filter = /^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i ;
	var clientaddress1 = $('#clientaddress1').val();
	var clientaddress2 = $('#clientaddress2').val();
	var clientaddress3 = $('#clientaddress3').val();
	var clientcity = $('#clientcity').val();
	var clientpin = $('#clientpin').val();
	var clientstate = $('#clientstate').val();
	var clientcountry = $('#clientcountry').val();
	var stdcode = $('#clientstdcode').val();
	var telephonenumbers = $('#clienttelephonenumbers').val();
	var clientfaxnumbers = $('#clientfaxnumbers').val();
	var clientemailid  =  $('#clientemailid').val();
	
	if((null==clientaddress1 || !clientaddress1.trim()) && (null==clientaddress2 || !clientaddress2.trim())  && (null==clientaddress3 || !clientaddress3.trim()) ){
		errorMessage("error", "Please enter address", "Required field..!");
		return false;
	}
	
	var addressLen =  clientaddress1+""+clientaddress2+""+clientaddress3;
	if(addressLen.length<20){
		errorMessage("error", "Address must be 20 character", "Required field..!");
		return false;
	}

	if(null==clientcity || !clientcity.trim()){
		errorMessage("error", "Please enter city", "Required field..!");
		$('#clientcity').focus();
		return false;
	}
	

	if(null==clientstate || !clientstate.trim()){
		errorMessage("error", "Please select state..!", "Required field..!");
		return false;
	}
	
	if('OUT SIDE INDIA' == clientstate && (null==clientcountry || !clientcountry.trim())){
		errorMessage("error", "Please enter country name..!", "Required field..!");
		$('#clientcountry').focus();
		return false;
	}else if('OUT SIDE INDIA' != clientstate && (null==clientpin || !clientpin.trim())){
		errorMessage("error", "Please enter pincode..!", "Required field..!");
		$('#clientpin').focus();
		return false;
	}else if(('OUT SIDE INDIA' != clientstate && null!=clientpin && clientpin.trim()) && clientpin.trim().length!=6){
		errorMessage("error", "Please enter valid pincode..!", "Required field..!");
		$('#clientpin').focus();
		return false;
	}
	
	if('OUT SIDE INDIA' != clientstate && null!=startpinmask && null!=endpinmask){
		var startpinmasklength = startpinmask.toString().length;
		if(!(parseInt(clientpin.substring(0,startpinmasklength)) >= startpinmask  && parseInt(clientpin.substring(0,startpinmasklength)) <= endpinmask)){
			errorMessage("error", "Pincode doesn't match with your state..!!", "Doesn't match ");
			$('#clientpin').focus();
			return false;
		}
	}
	
	if(null==clientcountry || !clientcountry.trim()){
		errorMessage("error", "Please enter country...!", "Required field..!");
		$('#clientcountry').focus();
		return false;
	}

	if(null==telephonenumbers || !telephonenumbers.toString().trim()){
		errorMessage("error", "Please enter phone no...!", "Required field..!");
		$('#clienttelephonenumbers').focus();
		return false;
	}else if((stdcode+telephonenumbers).toString().trim().length<10){
		errorMessage("error", "Phone number must be 10 digits...!", "Required field..!");
		$('#clienttelephonenumbers').focus();
		return false;
	}else if(telephonenumbers.toString().trim().length < 10 && (null==stdcode || !stdcode.toString().trim())){
		errorMessage("error", "Please enter std code...!", "Required field..!");
		$('#clientstdcode').focus();
		return false;
	}
	
	if(null!=clientfaxnumbers && clientfaxnumbers.toString().trim() && clientfaxnumbers.toString().trim().length<=10){
		errorMessage("error", "Please enter valid fax no. ...!", "Required field..!");
		$('#clientfaxnumbers').focus();
		return false;
	}
	
	if(null!=clientemailid && clientemailid.trim() && !filter.test(clientemailid)){
		errorMessage("error", "Please enter valid email", "Required field..!");
		$('#clientemailid').focus();
		return false;
	}
	
	$('#clientaddress').modal('hide');
	return true;
}

var clienttype = null;
function setServiceTypeClient(serviceDataList){
	clienttype = $("#clienttype").kendoDropDownList({
	    optionLabel: "Select Service Name...",
	    dataTextField: "masterdescription",
	    dataValueField: "mastercode",
	    filter: "contains",
	    dataSource: serviceDataList,
	    dataBound: function(e) {
	         // handle the event
	         if(null!=servicetype && servicetype.trim()){
	        	 this.select(function(dataItem) {
		         		    return dataItem.mastercode == servicetype;
		         	 });
	         }
	     }
	}).data("kendoDropDownList"); 
}

var clienttype1 = $("#clienttype1").kendoDropDownList({
	optionLabel: "Select Client Name...",
    dataTextField: "masterdescription",
    dataValueField: "mastercode",
    filter: "contains",
    dataSource: {
        //serverFiltering: true,
        transport: {
        	read: {
        		url: "../clientmaster/cliettypelist",
                type: "POST",
                dataType: "json",
                global : true,
            }
        }
     },
     dataBound: function(e) {
         // handle the event
         if(null!=clienttype1show && clienttype1show.trim()){
        	 this.select(function(dataItem) {
	         		    return dataItem.mastercode == clienttype1show;
	         	 });
         }
     }
  }).data("kendoDropDownList");

function clientmastervalidation(){
	
	var clientid = $('#clientid').val();
	var clientname = $('#clientname').val();
	var clientdisplayname = $('#clientdisplayname').val();
	var glcode = $('#glcode').val();
	var glcodename = $('#glcodename').val();
	var clienttype = $('#clienttype').val();
	var clienttype1 = $('#clienttype1').val();
	var gstclienttype = $('#gstclienttype').val();
	var clientgroupname = $('#clientgroupname').val();
	var clientgroupid = $('#clientgroupid').val();
	var bankguaranteedate = $('#bankguaranteedate').val();
	var expirydate = $('#expirydate').val();
	var pannumber = $('#pannumber').val();
	var exposurelimit = $('#exposurelimit').val();
	if(null==clientid || !clientid.trim()){
		errorMessage("error", "Please enter client id", "Required field..!");
		$('#clientid').focus();
		return false;
	}

	if(null==clientname || !clientname.trim()){
		errorMessage("error", "Please enter client name", "Required field..!");
		$('#clientname').focus();
		return false;
	}

	if(null==clientdisplayname || !clientdisplayname.toString().trim()){
		errorMessage("error", "Please enter client short name", "Required field..!");
		$('#clientdisplayname').focus();
		return false;
	}

	if(null==glcode || !glcode.toString().trim()){
		errorMessage("error", "GL code required", "Required field..!");
		return false;
	}
	var creategroup = $('#createclientgroup').prop('checked');
	if(creategroup && (null==clientgroupname || !clientgroupname.trim())){
		errorMessage("error", "Please enter client group name...!", "Required field..!");
		return false;
	}else if(!creategroup && (null==clientgroupid || !clientgroupid.trim())){
		errorMessage("error", "Please select client group id...!", "Required field..!");
		return false;
	}

	if(null==glcodename || !glcodename.toString().trim()){
		errorMessage("error", "Please enter gl code name", "Required field..!");
		$('#country').focus();
		return false;
	}

	if(null==clienttype || !clienttype.toString().trim()){
		errorMessage("error", "Please select service type", "Required field..!");
		$('#stdcode').focus();
		return false;
	}

	if(null==clienttype1 || !clienttype1.toString().trim()){
		errorMessage("error", "Please select client type", "Required field..!");
		$('#telephonenumbers').focus();
		return false;
	}

	if(null==gstclienttype || !gstclienttype.toString().trim()){
		errorMessage("error", "Please select gst client type", "Required field..!");
		$('#clientfaxnumbers').focus();
		return false;
	}
	
	if(null==pannumber || !pannumber.toString().trim()){
		errorMessage("error", "Please enter pan number", "Required field..!");
		$('#clientfaxnumbers').focus();
		return false;
	}
	
	if(gstclienttype.trim().indexOf('FOREIGN')==-1 && !(panreg.test(pannumber))){
		errorMessage("error", "Please enter valid pan number...!", "Required field..!");
		$('#pannumber').focus();
		return false;
	}
	
	if(null!=bankguaranteedate && null!=expirydate && !compareTwoDate(bankguaranteedate, expirydate, '/')){
		errorMessage("error", "Bank expiry date small compare to start date..!", "required field..!");
		$('#expirydate').focus();
		return false;
	}
	
	if(clienttype1.trim() == 'MNC'){
		if(gstclienttype.trim().indexOf('FOREIGN')==-1){
			errorMessage("error", "Please select GST client type any foreign type", "required field..!");
			return false;
		}
	}
	
	if(null==exposurelimit || !exposurelimit.trim()){
		errorMessage("error", "Please enter exposure limit...", "required field..!");
		return false;
	}
	
	if(null!=exposurelimit && parseFloat(exposurelimit.trim())<=0 ){
		errorMessage("error", "Please enter valid exposure limit...", "Invalid Limit..!");
		return false;
	}
	
	var clientstate = $('#clientstate').val();
	
	if(gstclienttype.trim().indexOf('FOREIGN')!=-1 && null!=clientstate && clientstate != 'OUT SIDE INDIA' ){
		errorMessage("error", "for foreign client select state name is OUT SIDE INDIA...!", "Invalid state..!");
		return false;
	}
		
	return true;
}

var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;

$(document).on('change','#pannumber',function(){
	if(!(panreg.test($(this).val()))){
		$(this).focus();
		errorMessage("error", "Please enter valid pan number...!", "Required field..!");
	}
});

var gstclienttype = $("#gstclienttype").kendoDropDownList({
	autoBind: true,
    optionLabel: "Select GST Client Name...",
    dataTextField: "masterdescription",
    dataValueField: "masterdescription",
    filter: "contains",
    dataSource: {
        transport: {
        	read: {
        		url: "../clientmaster/gstclienttypelist",
                type: "POST",
                dataType: "json",
                global : true,
            }
        }
     },
     dataBound: function(e) {
         // handle the event
         if(null!=gstclienttypeshow && gstclienttypeshow.trim()){
        	 this.select(function(dataItem) {
        		 return dataItem.masterdescription == gstclienttypeshow;
	         });
         }
     }
}).data("kendoDropDownList");

$(document).ready(function(){
	
	getStateList();
	getServiceTypeList();
	
	$('.hasDatepicker').datepicker( "option", "dateFormat",'dd/mm/yy');
	
	$(document).on('change','#createclientgroup',function(){
		var dropdownbox = $("#clientgroupid").data("kendoDropDownList");
		if(document.getElementById('createclientgroup').checked){
			$('#clientgroupnameDiv').show();
			dropdownbox.text('');
			dropdownbox.enable(false);
		}else{
			$('#clientgroupnameDiv').hide();
			dropdownbox.text('');
			dropdownbox.enable(true);
		}	
	});
	
		$(document).on('click','.submitbtnclass',function(){
			var tabselected = $($(document).find('.nav-link.active')[0]).attr('aria-controls');
			if('tab21'==tabselected  && clientmastervalidation() && clientAddressValidation()){
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
		                    closeModal: false
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
				    	saveClientDetail();
				    }
				});	
			}else if('tab22'==tabselected){
				var clientid = $('#clientidhd').val()
				if(null!=clientid && clientid.trim()){
					var urlbrand = '../brandmaster/completesavebrand/'+clientid;
					$.ajax({
	       	            url: urlbrand,
	       	            type: 'post',
	       	            dataType: 'json',
	       	            contentType: 'application/json',
	       	            data: sessionStorage.getItem('userdetail'),
	       	            success: function (resp) {
	       	                console.log(resp);
	       	                errorMessage("success","Brand Detail Save Successfully...", "Successfully..!");
	       	             	/*setTimeout(() => {
	       	             		window.location.href = '/clientmaster/';	
							}, 100);*/
	       	            },
	       	        });	
				}
			}else if('tab26'==tabselected){
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
		                    closeModal: false
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
				    	saveOtherDetail();
				    }
				});
			}else if('tab23'==tabselected && panbasedetailvalidation()){
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
		                    closeModal: false
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
				    	saveGstinheader();
				    }
				});
				
			}else if('tab25'==tabselected){
				
				if(contractvalidation()){
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
			                    closeModal: false
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
					    	saveclientcontrac();
					    }
					});
					
				}
			}
		});

	
	$(document).on('change','#clientid',function(){
			  var clientid = $(this).val();
			  if(null!=clientid && clientid.trim()){
				$.ajax({
 	            url: '../clientmaster/duplicateClientId/'+clientid,
 	            type: 'post',
 	            dataType: 'json',
 	         	data:sessionStorage.getItem('userdetail'),
 	            contentType: 'application/json',
 	            success: function (resp) {
 	                console.log(resp);
 	                if(null!=resp){
 	                	if(resp.CLIENTID_AVAILABLE == 'YES'){
 	                		$('#clientid').val('').focus();
 	                		errorMessage("error","Client ID already available...!", "Duplicate Client ID..!");
     	                }	
 	                }	
 	            },
 	        });
		}
	});
	
	$(document).on('change','#clientname',function(){
			var clientname = $(this).val();
			  if(null!=clientname && clientname.trim() && $('#clientnamehd').val()!=clientname){
				$.ajax({
   	            url: '../clientmaster/duplicateClientName/'+clientname,
   	            type: 'post',
   	            dataType: 'json',
   	         	data:sessionStorage.getItem('userdetail'),
   	            contentType: 'application/json',
   	            success: function (resp) {
   	                if(null!=resp){
   	                	if(resp.CLIENTNAME_AVAILABLE == 'YES'){
   	                		$('#clientname').val('').focus();
   	                		errorMessage("error","Client Name already available...!", "Duplicate Client Name..!");
       	                }else if(clientedit == 'NO'){
       	                	$('#glcodename').val(clientname);
       	                	$('#clientdisplayname').val(clientname.substring(0,32));
       	                }	
   	                }
   	            },
   	        });
			  }
	});
	
	var clientgroupid = $("#clientgroupid").kendoDropDownList({
	    autoBind: true,
	    optionLabel: "Select Client Group ID...",
	    dataTextField: "clientgroupname",
	    dataValueField: "clientgroupid",
	    filter: "contains",
	    dataSource: {
	        transport: {
	        	read: {
	        		url: "../clientmaster/clientgrouplist",
	                type: "POST",
	                dataType: "json",
	                contentType: "application/json",
	                global : true,
	            },
	            parameterMap: function(options, operation) {                                 
	            	return sessionStorage.getItem('userdetail');                                 
	            }
	        }
	    },
	    dataBound: function(e) {
	    	var clientgroupidhd = $('#clientgroupidhd').val();
             if(null!=clientgroupidshow && clientgroupidshow.trim()){
            	 this.select(function(dataItem) {
            		 return dataItem.clientgroupid === clientgroupidshow;
		         });
             }
         }
	}).data("kendoDropDownList");
	
	var clientidhd = $('#clientidhd').val();
	if(null!=clientidhd && clientidhd.trim()){
		var urlpath = '../clientmaster/getclientdetail/'+clientidhd;
	   	$.ajax({
        	 url: urlpath,
        	 method:'POST',
        	 dataType:'json',
        	 contentType: "application/json",
        	 data:sessionStorage.getItem('userdetail'),
        	 success:function(resp){
        		 if(null!=resp){
        			 $('#base-tab22,#base-tab23,#base-tab24,#base-tab25,#base-tab26').attr('data-toggle','tab');
        			 $('#base-tab22,#base-tab23,#base-tab24,#base-tab25,#base-tab26').removeClass('disabled');
        			clientDetailSetFn(resp);
        		 }
        	 },
        	 complete:function(){
        		 console.log('Complete Ajax');
        	 }
      });
   }else{
	   	$.ajax({
	         	 url:'../clientmaster/getglcode',
	         	 method:'POST',
	         	 dataType:'json',
	         	 data:sessionStorage.getItem('userdetail'),
	         	 contentType: 'application/json',
	         	 success:function(resp){
	         		 if( null!=resp && null!=resp.glavailable && 'YES'===resp.glavailable && null!=resp.glvalid && 'YES'===resp.glvalid ){
	         			 $('#glcode').val(resp.NUMVALUE1);
	         		 }else{
	         			errorMessage("error", "GLCODE Not Found OR Not Valid...!", "Please Contact IT..!");
	         			setTimeout(() => {
	         				gotoHome();
	         			}, 1000*4);
	         		 }
	         	 },
	         	 complete:function(){
	         		 console.log('Complete Ajax');
	         	 }
	      });
	}
	
});


var clientstate = null;		
function setClientState(stateDataList){
	var clientstate = $("#clientstate").kendoDropDownList({
	    optionLabel: "Select state name...",
	    dataTextField: "statename",
	    dataValueField: "statename",
	    dataSource: stateDataList,
	    filter: "contains",
	    dataBound: function(e) {
	    	if(null!=editstatelist && editstatelist.indexOf('-')!=-1){
	 			var state = editstatelist.split('-')[1];
	 			$('#clientstate').data("kendoDropDownList").select(function(dataItem) {
	 				return dataItem.charvalue1 == state;
	 		    });
	 		}else if(null!=editstatelist){
	 			$('#clientstate').data("kendoDropDownList").select(function(dataItem) {
	 				return dataItem.charvalue1 == editstatelist;
	 		    });
	 		}
		}
	}).data("kendoDropDownList");
}
var branchesopen = null;
function clientDetailSetFn(resp){
		clientedit = 'YES';
		$('#copy_branches_div').show();
		$('#createclientgroup').parent('div').hide();
		
		$('#clientnamehd').val(resp.clientname);
		$('#glcodehd').val(resp.glcode);
		 $('#clientgroupidhd').val(resp.clientgroupid);
		 $('#agencytypehd').val(resp.clienttype);
		 servicetype = resp.clienttype; 
		 clientgroupid = resp.clientgroupid;
		 
		 if(null!=servicetype && servicetype.trim()){
			clienttype.select(function(dataItem) {
		    	return dataItem.mastercode === servicetype;
		 	});	 
		 }
		var clientid = $('#clientidhd').val();
		if(null!=clientid && clientid.trim())
			$('#clientid').val(clientid).prop('disabled',true);
		
		var clientshortname = resp.clientdisplayname;
		if(null!=clientshortname && clientshortname.trim())
			$('#clientdisplayname').val(clientshortname);
		
		$('#clientname').val(resp.clientname).prop('disabled',true);
		$('#glcode').val(resp.glcode).prop('disabled',true);
		$('#clientdisplayname').val();
		
		if(null!=clientgroupid && clientgroupid.toString().trim()){
			clientgroupidshow = clientgroupid; 
		 	$('#clientgroupid').data("kendoDropDownList").select(function(dataItem) {
		 	   	return dataItem.clientgroupid == clientgroupid;
		 	});
		 	$('#clientgroupid').data("kendoDropDownList").enable(false);
		}
		
		var isdbbankactintimatedtoclient = resp.isdbbankactintimatedtoclient;
		if('Y'==isdbbankactintimatedtoclient){
			$('#isdbbankactintimatedtoclient').prop('checked',true);
		}else{
			$('#isdbbankactintimatedtoclient').prop('checked',false);
		}
		
		var clientprintaddressfrombrand = resp.printaddressfrombrand;
		if('Y'==clientprintaddressfrombrand){
			$('#clientprintaddressfrombrand').prop('checked',true);
		}else{
			$('#clientprintaddressfrombrand').prop('checked',false);
		}
		
		var creditdays = resp.creditdays;
		if(null!=creditdays && creditdays.toString().trim())
			$('#creditdays').val(creditdays);
		
		var clientTan = resp.client_tan;
		if(null!=clientTan && clientTan.trim())
			$('#clientTan').val(clientTan);
		
		var ltcpercentage = resp.ltcpercentage;
		if(null!=ltcpercentage && ltcpercentage.toString().trim())
			$('#ltcpercentage').val(ltcpercentage);
		
		var tinnumber = resp.tinnumber;
		if(null!=tinnumber && tinnumber.toString().trim())
			$('#tinnumber').val(tinnumber);
		
		var bankguaranteeamount = resp.bankguaranteeamount;
		if(null!=bankguaranteeamount && bankguaranteeamount.toString().trim())
			$('#bankguaranteeamount').val(bankguaranteeamount);
		
		var bankguaranteedate = resp.bankguaranteedate;
		if(null!=bankguaranteedate && bankguaranteedate.toString().trim())
			$('#bankguaranteedate').val(bankguaranteedate);
		
		var expirydate = resp.expirydate;
		if(null!=expirydate && expirydate.toString().trim())
			$('#expirydate').val(expirydate);
		
		var businesscommitment = resp.businesscommitment;
		if(null!=businesscommitment && businesscommitment.toString().trim())
			$('#businesscommitment').val(businesscommitment);
		
		var exposurelimit = resp.exposurelimit;
		if(null!=exposurelimit && exposurelimit.toString().trim())
			$('#exposurelimit').val(exposurelimit);
		
		var unbookedliability = resp.unbookedliability;
		if(null!=unbookedliability && unbookedliability.toString().trim())
			$('#unbookedliability').val(unbookedliability);
		
		var clienttype1 = resp.clienttype1;
		if(null!=clienttype1 && clienttype1.toString().trim()){
			clienttype1show = clienttype1; 
		 	$('#clienttype1').data("kendoDropDownList").select(function(dataItem) {
		 		return dataItem.mastercode == clienttype1show;
		 	});
		 	$('#clienttype1').data("kendoDropDownList").enable(false);
		}
		
		gstclienttypeshow = resp.client_type;
		if(null!=gstclienttypeshow && gstclienttypeshow.trim()){
			$('#gstclienttype').data("kendoDropDownList").select(function(dataItem) {
        		    return dataItem.masterdescription == gstclienttypeshow;
        	 });
			
			if('UNREGISTERED CLIENT' != gstclienttypeshow){
				$('#gstclienttype').data("kendoDropDownList").enable( false );
			}
			$('#gstclienttype').trigger('change');
		}
		
		var pannumber = resp.pannumber;
		if(null!=pannumber && pannumber.trim()){
			$('#pannumber').val(pannumber).prop('disabled',true);	
		}
		
		var clientaddress1 = resp.address1;
		if(null!=clientaddress1 && clientaddress1.trim()){
			$('#clientaddress1').val(clientaddress1);	
		}
		
		var clientaddress2 = resp.address2;
		if(null!=clientaddress2 && clientaddress2.trim()){
			$('#clientaddress2').val(clientaddress2);	
		}
		
		var clientaddress3 = resp.address3;
		if(null!=clientaddress3 && clientaddress3.trim()){
			$('#clientaddress3').val(clientaddress3);	
		}
		
		var clientcity = resp.city;
		if(null!=clientcity && clientcity.trim()){
			$('#clientcity').val(clientcity);	
		}
		
		var clientpin = resp.pin;
		if(null!=clientpin && clientpin.trim()){
			$('#clientpin').val(clientpin);	
		}
		
		var clientstate = resp.state;
		if(null!=clientstate && clientstate.trim()){
			editstatelist = clientstate;
			var clientstateData = $('#clientstate').data("kendoDropDownList");
			if(null!=clientstateData && undefined!=clientstateData){
				clientstateData.select(function(dataItem) {
					return dataItem.statename == clientstate;
		    	});
			}
		}
		
		var clientcountry = resp.country;
		if(null!=clientcountry && clientcountry.trim()){
			$('#clientcountry').val(clientcountry);	
		}
		
		var clientstdcode = resp.stdcode;
		if(null!=clientstdcode && clientstdcode.trim()){
			$('#clientstdcode').val(clientstdcode);	
		}
		
		var clienttelephonenumbers = resp.telephonenumbers;
		if(null!=clienttelephonenumbers && clienttelephonenumbers.trim()){
			$('#clienttelephonenumbers').val(clienttelephonenumbers);	
		}
		
		var clientfaxnumbers = resp.faxnumbers;
		if(null!=clientfaxnumbers && clientfaxnumbers.trim()){
			$('#clientfaxnumbers').val(clientfaxnumbers);	
		}
		
		var clientemailid = resp.emailid;
		if(null!=clientemailid && clientemailid.trim()){
			$('#clientemailid').val(clientemailid);	
		}
		
		var clientwebsite = resp.website;
		if(null!=clientwebsite && clientwebsite.trim()){
			$('#clientwebsite').val(clientwebsite);	
		}
		
		var glcodename = resp.glname;
		if(null!=glcodename && glcodename.trim()){
			$('#glcodename').prop('disabled',true).val(glcodename);	
		}
		
		var contractdetail = resp.contractdetail;
		if(null!=contractdetail){
			$('#clientcontractDiv').show();
			if(null!=contractdetail.startdate && contractdetail.startdate.trim()){
				$('#client_contract_startdate').val(contractdetail.startdate);
			}
			if(null!=contractdetail.enddate && contractdetail.enddate.trim()){
				$('#client_contract_enddate').val(contractdetail.enddate);
			}
			if(null!=contractdetail.contractfile && contractdetail.contractfile)
				$('#downloadcontractid').attr('href','./contractdownloadfiles?path='+contractdetail.contractfile)
		}
		
		var dbclientcode = resp.dbclientcode
		if(null!=dbclientcode && dbclientcode.toString().trim())
			$('#dbclientcode').val(dbclientcode);
		
		$('#dbclientcode').prop('disabled',false);
		branchesopen = resp.branchesopen;
		
		var pan_file = resp.pan_file;
		var pan_url = resp.pan_url;
		if('yes'==pan_file && null!=pan_url && pan_url.trim()){
			$('#panfilediv').empty().html('<a href="./'+pan_url+'" class="dwnldbtn"><i class="fa fa-download mt-04" title="download file" aria-hidden="true"></i></a>')
		}
		
		var bank_file = resp.bank_file;
		var bank_url = resp.bank_url ;
		if('yes'==bank_file && null!=bank_url && bank_url.trim()){
			$('#bankfilediv').empty().html('<a href="./'+bank_url+'" class="dwnldbtn"><i class="fa fa-download mt-04" title="download file" aria-hidden="true"></i></a>')
		}
		
		var glbalance_data = resp.GLBALANCE_DATA;
		if(null!=glbalance_data && glbalance_data.length>0){
			var openingbalance = glbalance_data[0].openingbalance;
			var closingbalance = glbalance_data[0].closingbalance;
			if(null!=openingbalance && openingbalance.toString().trim() 
					&& null!=closingbalance && closingbalance.toString().trim()){
				$('#openingbalance').val(openingbalance);
				$('#closingbalance').val(closingbalance);
				$('#client_balance_div').show();
			}
		}
		getBranchList();
}

function getBranchList(){
	$("#copyclienttable").kendoDropDownTree({
		placeholder: "Select Branches...",
		tagMode: "single",
		filter: "contains",
		checkboxes: true,
		checkAll: true,
		noDataTemplate: 'No Branches Found!',
		dataTextField: "branchname",
		dataValueField: "uniqueid",
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
	       					var serverurl = details.serverurl;
	           				if(null!=serverurl && serverurl.trim() && null!=uniqueid && undefined!=uniqueid)
	           					return serverurl+"/mudrabizcomps/useraccessbranches/"+loginid+"/5102/"+companyid+"/"+divisionid+"";
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
	    		$("#copyclienttable").data("kendoDropDownTree").value(branchesopen);
	 		}
		}
	}).data("kendoDropDownTree");
}



$(document).on('change', '#panfile', function () {
	var validatefile= checkFileUpload('myform','panfile',"5",['pdf']);
	if(validatefile==false){
		$(this).val('');
	    return false;
	}else{
	    //readURL(this);
	}
});


$(document).on('change', '#bankfile', function () {
	var validatefile= checkFileUpload('myform','bankfile',"5",['pdf']);
	if(validatefile==false){
		$(this).val('');
		return false;
	}else{
	    //readURL(this);
	}
});

$(document).on('change','#clientstate',function(){
	var clientstate = $(this).val();
	if(null!=clientstate && clientstate.trim()){
		$.ajax({
			url:'../clientmaster/getstatepinmask/'+clientstate,
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
		if(null!=clientstate && clientstate.trim() && 'OUT SIDE INDIA' != clientstate.trim()){
			$('#clientcountry').val('India');
		}else{
			$('#clientcountry').val('');
		}
	}
});

$(document).on('change','#gstclienttype',function(){
	var gstclienttype = $(this).val();
	var clientstatelist = $('#clientstate').data("kendoDropDownList");
	if(null!=gstclienttype && gstclienttype.trim().indexOf('FOREIGN')!=-1){
		if(null!=clientstatelist && undefined!=clientstatelist){
			clientstatelist.select(function(dataItem) {
				return dataItem.statename == 'OUT SIDE INDIA';
			});
			clientstatelist.enable(false);
		}
		
		var glcode = $('#glcode').val();
		var companyid = null;
		var foreignpannumber = null;
		if(null!=glcode && glcode.toString().trim()){
			var details = JSON.parse(sessionStorage.getItem('userdetail'));
			if(null!=details && undefined!=details){
				companyid = details.companyid;
				if(null!=companyid && companyid.toString().trim()){
					foreignpannumber = 'F'+companyid+''+pad(glcode,7,0);
					$('#pannumber').val(foreignpannumber).prop('disabled',true);
   				}
			}
			
		}else{
			errorMessage("error", "GLCODE not found...!", "please contact IT ..!");
		}
	}else if(null!=clientstatelist && undefined!=clientstatelist){
		clientstatelist.select(0);
		clientstatelist.enable(true);
		if(clientedit!='YES')
			$('#pannumber').val("").prop('disabled',false);
	}
});

$(document).on('change','#clienttype1',function(){
	var clienttype1 = $(this).val();
	var gstclienttype = $('#gstclienttype').data("kendoDropDownList");
	if(null!=clienttype1 && clienttype1.trim()=='MNC'){
		if(null!=gstclienttype && undefined!=gstclienttype){
			gstclienttype.select(function(dataItem) {
				return dataItem.masterdescription == 'FOREIGN CLIENT';
			});
		}
	}else if(null!=gstclienttype && undefined!=gstclienttype){
		gstclienttype.select(0);
	}
	$('#gstclienttype').trigger('change');
});

function getStateList(){
	var details = JSON.parse(sessionStorage.getItem('userdetail'));
	if(null!=details && undefined!=details){
		var serverurl = details.serverurl;
		if(null!=serverurl && serverurl.trim()){
			$.ajax({
			    url:serverurl+'/mudrabizcomps/gststates',
			    method:'GET',
			    dataType:'JSON',
			    contentType: 'application/json',
			    beforeSend: function(req) {
			    	req.setRequestHeader('userid', "6543210");
			 		req.setRequestHeader('token', '1234abcd-5678efgh-1234abcd-5678efgh');
			    },
			    success:function(resp){
			    	if(null!=resp){
			    		setClientState(resp);
			    		setBstate(resp);
			    		setStatePan(resp);
			    		setStateGstn(resp);
			    	}
			    }
			});
		}
	}
	
}

function getServiceTypeList(){
	$.ajax({
	    url:'../clientmaster/servicetypelist',
	    method:'POST',
	    dataType:'JSON',
	    contentType: 'application/json',
	    success:function(resp){
	    	if(null!=resp){
	    		setServiceTypeBrand(resp);
	    		setServiceTypeClient(resp);
	    	}
	    }
	});
}

function saveClientDetail(){
	var clientdata = {};
	$('#clientaddress').find('input').each(function(){
		clientdata[$(this).attr('id')] = $(this).val();
	});
	$('#tab21').find('input').each(function(){
		var inputtype = $(this).attr('type');
		var ids = 'none';
		var values = 'none';
		ids = $(this).attr('id');
		var classes = $(this).hasClass('datepicker-default');
		if('checkbox' === inputtype){
			values = ($(this).prop('checked')?'Y':'N');
		}else{
			values = $(this).val();
		}
		clientdata[ids] = values;
	});
	clientdata['clientedit'] = clientedit;
	clientdata['userdetail'] = JSON.parse(sessionStorage.getItem('userdetail'));
	var branches = [];
	var copyclienttableList = $("#copyclienttable").data("kendoDropDownTree");
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

		console.log(objectArray);
		console.log(stringArray);

		$.each(stringArray,function(i,data){
			console.log(data);
			$.each(objectArray,function(j,data2){
				if(data2 == data){
					stringArray[j] = "";
		        }
			});
		});
		console.log(stringArray);
		clientdata['branches'] = stringArray;
	}
	console.log(clientdata);
	
	var formData = new FormData();
	
	formData.append('clientdata', new Blob([JSON.stringify(clientdata)], {type: "application/json"}));
	
	var panfileObj = $('#panfile')[0];
	if(null!=panfileObj && undefined!=panfileObj && undefined!=panfileObj.files[0])
		formData.append('panfile',panfileObj.files[0]);
	
	var bankfileObj = $('#bankfile')[0];
	if(null!=bankfileObj && undefined!=bankfileObj && undefined!=bankfileObj.files[0])
		formData.append('bankfile',bankfileObj.files[0]);
	
	$.ajax({
       url: '../clientmaster/saveclient',
       type: 'post',
       dataType: 'json',
       processData: false, 
       contentType: false,
    	data: formData,
       success: function (resp) {
    	   if(null!=resp){
    		   if(null!=resp.SAVE && resp.SAVE == 'SUCCESSFULLY'){
              		errorMessage("success","Client Detail Save Successfully...", "Successfully..!");
              		$('#clientid').prop('disabled',false);
              		setTimeout(() => {
               		document.myform.method = 'POST';
       	            document.myform.action = '../clientmaster/addclientmaster';
       	            document.myform.submit();
              		}, 1000);
              }else if(null!=resp.REQUIRED_FIELD && resp.REQUIRED_FIELD == 'NO'){
           	    errorMessage("error","Required field not available at save time...", "Save Failed..!");
          	   }else if(null!=resp.glcode_already && resp.glcode_already == 'YES'){
           	    errorMessage("error","GLCODE already used please contact administrator...!", "Save Failed..!");
          	   }else if(null!=resp.REASON && undefined!=resp.REASON){
              		//errorMessage("error","REASON "+resp.REASON+"...", "Save Failed..!");
              		errorMessage("error","please contact administrator for more information...", "Save Failed..!");
              }
    	   }else{
    		   //errorMessage("error","REASON "+resp.REASON+"...", "Save Failed..!");
	       		errorMessage("error","please contact administrator for more information...", "Save Failed..!");
	       }
       },
   });
}

function saveOtherDetail(){
	var otherClientDetail ={};
	$('#tab26').find('input').each(function(){
		var inputtype = $(this).attr('type');
       	var ids = 'none';
       	var values = 'none';
       	ids = $(this).attr('name');
       					
       	if('checkbox' === inputtype){
       		values = ($(this).prop('checked')?'Y':'N');
       	}else{
       		values = $(this).val();
       	}
       	otherClientDetail[ids] = values;
    });
		
   var clientidhd = $('#clientidhd').val();
   var clientcountry = $('#clientcountry').val();
   var pannumber = $('#panpannumber').val(); 
		
   otherClientDetail['clientid'] = clientidhd;
   otherClientDetail['clientcountry'] = clientcountry;
   otherClientDetail['pannumber'] = pannumber;
   
   var uniqueid = null;
   var details = JSON.parse(sessionStorage.getItem('userdetail'))
	if(null!=details && undefined!=details ){
		uniqueid = details.uniqueid;
		if(null!=uniqueid && undefined!=uniqueid){
			otherClientDetail['uniqueid'] = uniqueid;
			console.log(otherClientDetail);
			   $.ajax({
		            url: '../clientmaster/saveclientotherdetail',
		            type: 'post',
		            dataType: 'json',
		            contentType: 'application/json',
		         	data: JSON.stringify(otherClientDetail),
		            success: function (resp) {
		            	errorMessage("success", ""+'DATA SAVE '+resp['SAVE']+"", "Message..!");
		            	$('#tab26').find('input').prop('disabled',true);
		            },
		        });
		}
	}
}

function saveGstinheader(){
	var panhederdata = {}
	
		
		$('#tab23').find('input').each(function(){
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

		$.ajax({
			   url: '../clientmaster/saveclientmastergstinheader',
	           type: 'post',
	           dataType: 'json',
	           contentType: 'application/json',
	           data: JSON.stringify(panhederdata),
	           success: function (resp) {
	        	errorMessage("success", ""+'DATA SAVE '+resp['SAVE']+"", "Message..!");
	           },
	    });
}

function saveclientcontrac(){
	var clientcontracdata = {};
	$('#contractfile').find('input').each(function(){
		clientcontracdata[$(this).attr('name')] = $(this).val();
		var inputtype = $(this).attr('type');
			var ids = 'none';
			var values = 'none';
			ids = $(this).attr('id');
			var classes = $(this).hasClass('datepicker-default');
			if('checkbox' === inputtype){
				values = ($(this).prop('checked')?'Y':'N');
			}else{
				values = $(this).val();
			}
			clientcontracdata[ids] = values;
	});
	
	clientcontracdata['clientid'] = $('#clientidhd').val();
	
	var uniqueid = null;
	var details = JSON.parse(sessionStorage.getItem('userdetail'))
	if(null!=details && undefined!=details ){
		uniqueid = details.uniqueid;
		var loginid = details.loginid;
		if(null!=uniqueid && undefined!=uniqueid && null!=loginid && loginid.toString().trim()){
			clientcontracdata['uniqueid'] = uniqueid;
			clientcontracdata['loginid'] = loginid;
			var formData = new FormData();
   				
   			formData.append('clientcontracdata', new Blob([JSON.stringify(clientcontracdata)], {type: "application/json"}));
   			
   			var fileData = $('#contracfile')[0];
   			if(null!=fileData && undefined!=fileData && undefined!=fileData.files[0])
   				formData.append('contracfile',$('#contracfile')[0].files[0]);
   				
   			$.ajax({
   				url: '../clientmaster/saveclientcontrac',
       	        type: 'post',
       	        dataType: 'json',
       	        processData: false, 
       	        contentType: false,
       	        data: formData,
       	        success: function (resp) {
       	        	var displayMessage = resp['SAVE'];
       	        	var displayReason = resp['REASON'];
       	        	if(null!=displayMessage && undefined!=displayMessage 
       	        			&& 'SUCCESSFULLY' == displayMessage ){
       	        		errorMessage("success", "data saved successfully", "Message..!");
       	        	}else if('FAILED' === displayMessage && (null==displayReason || undefined==displayReason)){
       	        		errorMessage("error", "Save process failed please contact IT..!", "Save Process failed..!");
       	        	}/*else if(){
       	        		errorMessage("error", "Data save "+displayMessage+"", "Save Process failed..!");
       	        	}*/
       	        	
       	        	getContractDetail();
       	        },
   			});   
		}
  }
}



var before_form_count = 0;
$( document ).ajaxSend(function() {
	console.log('Send...!');
	$('#before_form').show();
	before_form_count++;
});

$(document).ajaxComplete(function() {
	console.log('Complete...!');
	before_form_count--;
	if(before_form_count < 0){
		before_form_count = 0;
	}
	if(before_form_count === 0){
		$('#before_form').hide();
	}
});


$(document).on('click','#base-tab21',function(){
	$('.submitbtnclass').parent('a').removeClass('disabled');	
});