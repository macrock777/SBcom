var gstinstate = null;
var panstartpinmask = null;
var panendpinmask = null;
var gststartpinmask = null;
var gstendpinmask = null;

 
$(document).on('change','#panpannumber',function(){
	var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
	if(!(panreg.test($(this).val()))){
		$(this).val('').focus();
		errorMessage("Info", "Please Enter Valid PAN No", "Required Filed..!");
	}
});


function checkPanNumber(thiss){
	var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
	var val = $(thiss).val();
	
	if(!(panreg.test(val))){
		$(thiss).val('').focus();
		errorMessage("Info", "Please Enter Valid PAN No", "Required Filed..!");
	}
}

function panbasedetailvalidation(){
	var filter =	/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i ;
	var pannumber = $('#panpannumber').val();
	var nsdlclientname = $('#pannsdlclientname').val();
	
	var telephonenumbers = $('#pantelephonenumbers').val();
	var faxnumbers = $('#panfaxnumbers').val();
	var emailid = $('#panemailid').val();
	var panregisteredstate = $('#panregisteredstate').val();
	var pancountry = $('#pancountry').val();
	var panregisteredpin = $('#panregisteredpin').val();
	
		if(null==pannumber || !pannumber.trim()){
			errorMessage("info", "Please Enter Pan No", "Required Filed..!");
			$('#pannumber').focus();
			return false;
		}
		
		if(null==nsdlclientname || !nsdlclientname.trim()){
			errorMessage("info", "Please Enter Client Name (NSDL) ", "Required Filed..!");
			$('#pannsdlclientname').focus();
			return false;
		}
	
	  if(null!=telephonenumbers && telephonenumbers.trim()!=''  && telephonenumbers.length<10){
			errorMessage("info", "Please Enter Valid Phone No", "Required Filed..!");
			$('#pantelephonenumbers').focus();
			return false;
		}
	  
	  if(null==panregisteredstate || !panregisteredstate.trim()){
		  errorMessage("info", "Please select state..!", "Required Filed..!");
		  $('#panregisteredstate').focus();
		  return false;
	  }
	  
	  if(null!=faxnumbers && faxnumbers.trim()!='' && faxnumbers.length<10){
			errorMessage("info", "Please Enter Valid Fax-No", "Required Filed..!");
			$('#panfaxnumbers').focus();
			return false;
		}
	  
	  if('OUT SIDE INDIA' == panregisteredstate && (null==pancountry || !pancountry.trim())){
			errorMessage("info", "Please enter country name..!", "Required Field..!");
			$('#pancountry').focus();
			return false;
	  }else if('OUT SIDE INDIA' != panregisteredstate && (null==panregisteredpin || !panregisteredpin.trim() || panregisteredpin.trim().length!=6)){
			errorMessage("info", "Please enter Pincode..!", "Required Field..!");
			$('#panregisteredpin').focus();
			return false;
	  }
	  
	  if('OUT SIDE INDIA' != panregisteredstate && null!=panstartpinmask && null!=panendpinmask){
			var startpinmasklength = panstartpinmask.toString().length;
			if(!(parseInt(panregisteredpin.substring(0,startpinmasklength)) >= panstartpinmask  
					&& parseInt(panregisteredpin.substring(0,startpinmasklength)) <= panendpinmask)){
				errorMessage("info", "Pincode doesn't match with your State..!!", "Doesn't Match ");
				$('#panregisteredpin').focus();
				return false;
			}
		}
	  
	  if(null!=emailid && emailid.trim()!=''&& !filter.test(emailid)){
			errorMessage("info", "Invalid Email", "Required Filed..!");
			$('#panemailid').focus();
			return false;
	  }
	

    return true;
}

var tempgstin;

$(document).on('change','#gstdetailgstin',function(){
	var gstinreg = /^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$/;
	if(!(gstinreg.test($(this).val()))){
		$(this).val(tempgstin).focus();
		errorMessage("Info", "Please Enter Valid GSTIN (GSTIN format :- 02 QWERY1234Y 4Z3)", "Required Filed..!");
	}
});




function panbasegstindetail(){
	var filter =	/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i ;
	var gstinfilter =	/^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$/;
	
	
	var gstdetailtatecode = $('#gstdetailtatecode').val();
	var gstdetailgstin = $('#gstdetailgstin').val();
	var gstdetailcity = $('#gstdetailcity').val();
	var gstdetailaddress = $('#gstdetailaddress').val();
	var gstdetailpincode = $('#gstdetailpincode').val();
	var gstdetailcountry = $('#gstdetailcountry').val();
	var gstdetailauthorizedperson = $('#gstdetailauthorizedperson').val();
	var gstdetailtelephonenumber = $('#gstdetailtelephonenumber').val();
	var gstdetailemailid = $('#gstdetailemailid').val();
	
	if(null==gstdetailtatecode || !gstdetailtatecode.trim()){
		errorMessage("info", "Please Select State", "Required Filed..!");
		$('#gstdetailtatecode').focus();
		return false;
	}

	if(null==gstdetailgstin || !gstdetailgstin.trim()){
		errorMessage("info", "Please Enter GSTIN", "Required Filed..!");
		$('#gstdetailgstin').focus();
		return false;
	}
	
	if(null!=gstdetailgstin && gstdetailgstin!='' &&!(gstinfilter.test(gstdetailgstin))){
		errorMessage("info", "Please Enter Valid GSTIN (GSTIN format :- First 2 Digit : State Code, Next 10 Digit: Pan Number, 13th Digit : Business Entity Code, 14th Digit: By Default Z, 15th Digit - Optional (AlphaNumaric) )", "Required Filed..!");
		$('#gstdetailgstin').focus();
		return false;
	}

	if(null==gstdetailaddress || !gstdetailaddress.trim()){
		errorMessage("info", "Please Enter Address", "Required Filed..!");
		$('#gstdetailaddress').focus();
		return false;
	}
	
	if(null!=gstdetailaddress && gstdetailaddress.trim().length<20){
		errorMessage("info", "Address should be 20 character", "Required Filed..!");
		$('#gstdetailaddress').focus();
		return false;
	}
	
	if(null==gstdetailcity || !gstdetailcity.trim()){
		errorMessage("info", "Please Enter City", "Required Filed..!");
		$('#gstdetailcity').focus();
		return false;
	}

	if('NA' == gstdetailtatecode && (null==gstdetailcountry|| !gstdetailcountry.trim())){
		errorMessage("info", "Please enter country name..!", "Required Field..!");
		$('#gstdetailcountry').focus();
		return false;
	}else if('NA' != gstdetailtatecode && (null==gstdetailpincode || !gstdetailpincode.trim())){
		errorMessage("info", "Please enter Pincode..!", "Required Field..!");
		$('#gstdetailpincode').focus();
		return false;
	}else if(('NA' != gstdetailtatecode && null!=gstdetailpincode && gstdetailpincode.trim()) && gstdetailpincode.toString().trim().length!=6){
		errorMessage("info", "Please enter valid pincode..!", "Required field..!");
		$('#gstdetailpincode').focus();
		return false;
	}
  
	if('NA' != gstdetailtatecode && null!=gststartpinmask && null!=gstendpinmask){
		var startpinmasklength = gststartpinmask.toString().length;
		if(!(parseInt(gstdetailpincode.substring(0,startpinmasklength)) >= gststartpinmask  
				&& parseInt(gstdetailpincode.substring(0,startpinmasklength)) <= gstendpinmask)){
			errorMessage("info", "Pincode doesn't match with your State..!!", "Doesn't Match ");
			$('#gstdetailpincode').focus();
			return false;
		}
	}
	
	if(null==gstdetailcountry || !gstdetailcountry.trim()){
		errorMessage("info", "Please Enter Country", "Required Filed..!");
		$('#gstdetailcountry').focus();
		return false;
	}


	if(null!=gstdetailtelephonenumber && gstdetailtelephonenumber!='' &&  gstdetailtelephonenumber < 10){
		errorMessage("info", "Please Enter Valid Phone No", "Required Filed..!");
		$('#gstdetailtelephonenumber').focus();
		return false;
	}
	
	if(null!=gstdetailemailid && gstdetailemailid!='' &&!(filter.test(gstdetailemailid))){
		errorMessage("info", "Invalid Email", "Required Filed..!");
		$('#gstdetailemailid').focus();
		return false;
	}
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
                value: null,
                visible: true,
                className: "themeColor",
                closeModal: true,
            }                
	    }
	}).then(isConfirm => {
	    if (isConfirm) {
	    	var clientgstindata ={};
	    	
	    	
	    	$('#addgstindetails').find('input').each(function(){
	    		clientgstindata[$(this).attr('name')] = $(this).val();
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
	    			clientgstindata[ids] = values;
	    	});
	    	
	    	$('#tab23').find('input').each(function(){
	    		clientgstindata[$(this).attr('name')] = $(this).val();
	    		var inputtype = $(this).attr('type');
	    			var ids = 'none';
	    			var values = 'none';
	    			ids = $(this).attr('id');
	    			if('checkbox' === inputtype){
	    				values = ($(this).prop('checked')?'Y':'N');
	    			}else{
	    				values = $(this).val();
	    			}
	    			clientgstindata[ids] = values;
	    	});
	    	var details = JSON.parse(sessionStorage.getItem('userdetail'));
	    	if(null!=details && undefined!=details){
	    		var loginid = details.loginid;
	    		var uniqueid = details.uniqueid;
	    		if(null!=uniqueid && uniqueid.trim()){
	    			clientgstindata['uniqueid'] = uniqueid;
	    			clientgstindata['loginid'] = loginid;
	    			$.ajax({
	    	    		url: '../clientmaster/saveclientmastergstin',
	    	            type: 'post',
	    	            dataType: 'json',
	    	            contentType: 'application/json',
	    	            data: JSON.stringify(clientgstindata),
	    	            success: function (resp) {
	    	            	errorMessage("info", ""+'DATA SAVE '+resp['SAVE']+"", "Message..!");
	    	            	var panpannumber = $('#panpannumber').val();
	    	            	$.getJSON( "../clientmaster/clientmastergstindetailList/"+panpannumber+"", function( resp ) {
	    	            		panoption.dataSource.data = resp;
	    	            		$("#panbasegrid").kendoGrid(panoption);
	    	            		$("#panbasegrid div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a")
	    	    			  	.removeClass( "k-button" );
	    	            	});
	    	            	$('#addgstindetails').modal('hide');
	    	            	return true;
	    	            },
	    	        });
	    		}
	    			
	    	}
	    	
	    }
	});
	
	
}

var panregisteredstate = null;	
function setStatePan(stateDataList){

	panregisteredstate = $("#panregisteredstate").kendoDropDownList({
	    optionLabel: "Select State Name...",
	    dataTextField: "statename",
	    dataValueField: "statename",
	    filter: "contains",
	    dataSource:stateDataList,
	}).data("kendoDropDownList");
	
}

$("#pantypeofclient").kendoDropDownList({
	autoBind: true,
    optionLabel: "Select GST Client Name...",
    dataTextField: "masterdescription",
    dataValueField: "masterdescription",
    filter: "contains",
    dataSource: {
        serverFiltering: true,
        transport: {
        	read: {
        		url: "../clientmaster/gstclienttypelist",
                type: "POST",
                dataType: "json",
            }
        }
     },
  }).data("kendoDropDownList");



const panoption = {
		dataSource: {
            schema: {
                model: {
                    fields: {
                        pannumber: { type: "string" },
                        gstin: { type: "string" },
                        srno: { type: "number" },
                        address: { type: "string" },
                        city: { type: "string" },
                        statecode: { type: "string" },
                        pincode: { type: "string" },
                        country: { type: "string" }
                    }
                }
            },
            pageSize: 17
        },
        
        autoBind: true,
        height: 200,
        scrollable: true,
        sortable: true,
        filterable: false,
        pageable: {
            input: true,
            numeric: false
        },
        columns: [
        	{ command: [{name: 'edit', text: '', className: "themeIconColor"}], 
        		title: "ACTION", class:'panmodal'},
            { field: "pannumber", title: "PanNumber", width: "130px" },
            { field: "gstin", title: "GSTIN", width: "130px" },
            { field: "srno", title: "Sr No", width: "130px" },
            { field: "address", title: "Address", width: "130px" },
            { field: "city", title: "City", width: "130px" },
            { field: "statecode", title: "StateCode", width: "130px" },
            { field: "pincode", title: "Pincode", width: "130px" },
            { field: "country", title: "Country", width: "130px" },
        ]
};





$(document).on('click','#base-tab23',function(){
	
	var pannumber  = $('#pannumber').val();
	if(null!=pannumber && pannumber.trim()){
		$.ajax({
	    	 url:'../clientmaster/getmainpanbaseddetail/'+pannumber,
	    	 method:'POST',
	    	 dataType:'json',
	    	 contentType: 'application/json',
	    	 success:function(resp){
	    		
	    		if(null!=resp){
	    			
	    			var contactperson = resp.contactperson;
	    			if(null!=contactperson && contactperson.toString().trim())
	    				$('#pancontactperson').val(contactperson);
	    			
	    			var nsdlclientname = resp.nsdlclientname;
	    			if(null!=nsdlclientname && nsdlclientname.toString().trim())
	    				$('#pannsdlclientname').val(nsdlclientname);
	    			
	    			var pannumber = resp.pannumber;
	    			if(null!=pannumber && pannumber.toString().trim())
	    				$('#panpannumber').val(pannumber);
	    			
	    			var registeredaddress1 = resp.registeredaddress1;
	    			if(null!=registeredaddress1 && registeredaddress1.toString().trim())
	    				$('#panregisteredaddress1').val(registeredaddress1);
	    			
	    			var registeredaddress2 = resp.registeredaddress2;
	    			if(null!=registeredaddress2 && registeredaddress2.toString().trim())
	    				$('#panregisteredaddress2').val(registeredaddress2);
	    			
	    			var registeredaddress3 = resp.registeredaddress3;
	    			if(null!=registeredaddress3 && registeredaddress3.toString().trim())
	    				$('#panregisteredaddress3').val(registeredaddress2);
	    			
	    			var registeredcity = resp.registeredcity;
	    			if(null!=registeredcity && registeredcity.toString().trim())
	    				$('#panregisteredcity').val(registeredcity);
	    			
	    			var country = resp.country;
	    			if(null!=country && country.toString().trim())
	    				$('#pancountry').val(country);
	    			
	    			var telephonenumbers = resp.telephonenumbers;
	    			if(null!=telephonenumbers && telephonenumbers.toString().trim())
	    				$('#pantelephonenumbers').val(telephonenumbers);
		    		
		    		var gstintype = resp.typeofclient;
	    			if(null!=gstintype && gstintype.toString().trim()){
	    				$('#pantypeofclient').data("kendoDropDownList").select(function(dataItem) {
			    			  return dataItem.masterdescription == gstintype;
			    		});
	    				var pantypeofclient = $('#pantypeofclient').data( "kendoDropDownList" );
	    				pantypeofclient.enable( false );
	    			}
		    		
	    			var faxnumbers = resp.faxnumbers;
	    			if(null!=faxnumbers && faxnumbers.toString().trim())
	    				$('#panfaxnumbers').val(faxnumbers);
	    			
	    			var emailid = resp.emailid;
	    			if(null!=emailid && emailid.toString().trim())
	    				$('#panemailid').val(emailid);
	    			
	    			var registeredpin = resp.registeredpin;
	    			if(null!=registeredpin && registeredpin.toString().trim())
	    				$('#panregisteredpin').val(registeredpin);
	    			
	    			var panregisteredstate = $("#panregisteredstate").data( "kendoDropDownList" );
	    			var registeredstate = resp.registeredstate;
		    		if(null!=registeredstate && undefined!=registeredstate){
		    			panregisteredstate.select(function(data){
		    				return data.statename==registeredstate;
		    			});
		    		}
		    		
		    		
	    		}
	    		
	    	 },
	    	 complete:function(){
	    		 console.log('Complete Ajax');
	    	 }
		});
	}
	
});

var gstdetailtatecode = null;
function setStateGstn(stateDataList){
	gstdetailtatecode = $("#gstdetailtatecode").kendoDropDownList({
		optionLabel: "Select State",
	    dataTextField: "statename",
	    dataValueField: "statecode",
	    filter: "contains",
	    dataSource: stateDataList,
	}).data("kendoDropDownList");
}

$(document).on('click','#base-tab23',function(){
	
	var glc = $('#glcode').val();
	var glcodename = $('#glcodename').val();
	$('#glcodehd').val(glc+""+glcodename);
	var clientidhd =  $('#clientidhd').val();
	$('#clientidtxt,.clientidtxt').html(clientidhd);
	var clientnamehd =  $('#clientnamehd').val();
	$('#clientnametxt,.clientnametxt').html(clientnamehd);
	var glcodehd =  $('#glcodehd').val();
	$('#glcodetxt,.glcodetxt').empty().html(glc+" - "+glcodename);
	$('.submitbtnclass').parent('a').removeClass('disabled');
	
	var panpannumber = $('#panpannumber').val();
	if(null!=panpannumber && panpannumber.trim().length!=''){
		$.getJSON( "../clientmaster/clientmastergstindetailList/"+panpannumber+"", function( resp ) {
			  panoption.dataSource.data = resp;
			  
			  $("#panbasegrid").kendoGrid(panoption);
			  
			  var pantypeofclient = $('#pantypeofclient').val();
			  if(null!=pantypeofclient && pantypeofclient.trim() && pantypeofclient.indexOf('FOREIGN')!=-1){
				  $('#panmodal').parent('div').parent('div').hide();
			  }
			  
			  if(pantypeofclient == 'GOVERNMENT CLIENT'){
				  $('#uidn').prop('checked',true).prop('disabled',true);
				  $('#gstin').prop('disabled',true);
			  }else{
				  $('#gstin').prop('checked',true).prop('disabled',true);
				  $('#uidn').prop('disabled',true);
			  }
			
			  $("#panbasegrid div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a")
			  	.removeClass( "k-button" );
		});
	}
	
}); 

$(document).on('click','#panbasegrid a.k-button-icontext.k-grid-edit',function(){

	
	var $this = $(this);
    var srno = $($this.parents('tr')).find('td:nth-child(4)').text();
    var pannumber = $($this.parents('tr')).find('td:nth-child(2)').text();
    var gstin = $($this.parents('tr')).find('td:nth-child(3)').text();
    var clientid = $('#clientidhd').val();
    
    $('#srno').val('')
    
    if(null!=srno && srno.trim() && null!=pannumber && pannumber.trim()){
    	$('#gstindetailsrno').val(srno);
    	
    	$.getJSON("../clientmaster/getgstiondetail/"+srno+"/"+pannumber+"/"+gstin+"", function(resp) {
    		
    		$('#gstindetailsrno').val(resp[0].srno);
    		$('#gstdetailgstin').val(resp[0].gstin).attr('readonly',true);
    		$('#gstdetailaddress').val(resp[0].address);
    		$('#gstdetailcity').val(resp[0].city);
    		$('#gstdetailcountry').val(resp[0].country);
    		$('#gstdetailauthorizedperson').val(resp[0].authorizedperson);
    		$('#gstdetailemailid').val(resp[0].emailid);
    		$('#gstdetailpincode').val(resp[0].pincode);
    		$('#gstdetailtelephonenumber').val(resp[0].telephonenumber);
    		
    		$('#gstdetailtatecode').attr('readonly',true);
    		$('#pan_is_active').show();
    		gstinstate = resp[0].statecode;
    		
    		gstdetailtatecode.select(function(data){
    			return data.statecode==resp[0].statecode;
    		});
    		
    		
    		var gstdetailgstin = $('#gstdetailtatecode'). data( "kendoDropDownList" );
    		gstdetailgstin.enable( false );
    		
    		$('#gstdetailtatecode').prop('readonly',true);
    		
    		if(resp[0].isactive==='Y')
    			$('#gstdetailisactive').attr('checked', true);
    		else
    			$('#gstdetailisactive').attr('checked', false);

    		if(resp[0].isdefault==='Y')
    			$('#gstdetailisdefault').attr('checked', true);
    		else
    			$('#gstdetailisdefault').attr('checked', false);
    	});
    	
    	$('#addgstindetails').modal('show');
     }
});


$(document).on("click","#panmodal",function(){
	$('#addgstindetails').find('input').each(function(){
		$('#'+$(this).attr('id')).val('');
		var gstdetailtatecode = $("#gstdetailtatecode").data("kendoDropDownList");
		if(undefined!=gstdetailtatecode){
			gstdetailtatecode.text("");
			gstdetailtatecode.enable(true);
			gstdetailtatecode.value("");
		}
	});
	$('#pan_is_active').hide();
	$('#gstdetailgstin').val('').attr('readonly',false);
	
	$('#addgstindetails').modal({backdrop: 'static',
	    keyboard: false},'show');
});



$(document).on('change','#panregisteredstate',function(){
	var clientstate = $(this).val();
	if(null!=clientstate && clientstate.trim()){
		$.ajax({
			url:'../clientmaster/getstatepinmask/'+clientstate,
			method:'POST',
			dataType:'JSON',
			contentType: 'application/json',
			success:function(resp){
				if(null!=resp){
					panstartpinmask = resp.numvalue1; 
					panendpinmask = resp.numvalue2; 
			    }
			},
		});
	}
});


$(document).on('change','#gstdetailtatecode',function(){
	var clientstate = $(this).val();
	if(null!=clientstate && clientstate.trim()){
		$.ajax({
			url:'../clientmaster/getstatepinmaskusingstatecode/'+clientstate,
			method:'POST',
			dataType:'JSON',
			contentType: 'application/json',
			 success:function(resp){
			    if(null!=resp){
			    	gststartpinmask = resp.numvalue1; 
			    	gstendpinmask = resp.numvalue2;
			    	var statecode = resp.charvalue2;
			    	if(null!=statecode && statecode.trim()){
			    		var pan=$('#panpannumber').val();
				    	$('#gstdetailgstin').val(statecode+pan);
				    	tempgstin = statecode+pan;
			    	}
			    	if(null!=clientstate && clientstate.trim() && 'NA' != clientstate.trim()){
						$('#gstdetailcountry').val('India');
					}else{
						$('#gstdetailcountry').val('');
					}
			    }
			 },
		});
	}
});