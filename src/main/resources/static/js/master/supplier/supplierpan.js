
var sachsncomboval = 0;
var gstinstate = null;
 
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
		var nsdlsuppliername = $('#pannsdlsuppliername').val();
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
			
			if(null==nsdlsuppliername || !nsdlsuppliername.trim()){
				errorMessage("info", "Please Enter NSD Supplier Name", "Required Filed..!");
				$('#pannsdlclientname').focus();
				return false;
			}
		
		  if(null!=telephonenumbers && telephonenumbers.trim()!=''  && telephonenumbers.length<10){
				errorMessage("info", "Please Enter Valid Phone No", "Required Filed..!");
				$('#pantelephonenumbers').focus();
				return false;
			}
		  
		  if(null!=faxnumbers && faxnumbers.trim()!='' && faxnumbers.length<10){
				errorMessage("info", "Please Enter Valid Fax-No", "Required Filed..!");
				$('#panfaxnumbers').focus();
				return false;
			}
		
		  
		  if('NA' == panregisteredstate && (null==pancountry || !pancountry.trim())){
	 				errorMessage("info", "Please enter country name..!", "Required Field..!");
	 				$('#panregisteredstate').focus();
	 				return false;
	 	  }else if((null==panregisteredpin || !panregisteredpin.trim()) && ('NA' != panregisteredstate)){
	 				errorMessage("info", "Pincode Must Be 6 Digit in Address Information!", "Required Field..!");
	 				$('#panregisteredpin ').focus();
	 				return false;
	 	  }
	 		
		  if('NA' != panregisteredstate && null!=pangststartpinmask && null!=pangstendpinmask){
			  console.log(parseInt(panregisteredpin.substring(0,startpinmasklength)));
			  
	 			var startpinmasklength = panregisteredpin.toString().length;
	 			
	 			if(!(parseInt(panregisteredpin.substring(0,2)) >= pangststartpinmask  && parseInt(panregisteredpin.substring(0,2)) <= pangstendpinmask)){
	 				errorMessage("info", "Please Enter Correct Pincode for Selected State in Address Information..!!", "Doesn't match ");
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
			errorMessage("error", "Please Enter Valid GSTIN (GSTIN format :- First 2 Digit : State Code, Next 10 Digit: Pan Number, 13th Digit : Business Entity Code, 14th Digit: By Default Z, 15th Digit - Optional (AlphaNumaric) )", "Required Filed..!");
		}
	});

	var gstendpinmask;
	var gststartpinmask;


	$(document).on('change','#gstdetailtatecode',function(){
		var statecode = $(this).val().split('-')[0];
		var pan=$('#panpannumber').val();
		$('#gstdetailgstin').val(statecode+pan);
		tempgstin = statecode+pan;	
		var supplierstate = $(this).val();
		if(null!=supplierstate && supplierstate.trim()){
			$.ajax({
				url:'../clientmaster/getstatepinmaskusingstatecode/'+supplierstate,
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
				    	if(null!=supplierstate && supplierstate.trim() && 'NA' != supplierstate.trim()){
							$('#gstdetailcountry').val('India');
						}else{
							$('#gstdetailcountry').val('');
						}
				    }
				 },
			});
		}
	});


	var pangststartpinmask;
	var pangstendpinmask;

	$(document).on('change','#panregisteredstate',function(){
		var panstate = $(this).val();
		if(null!=panstate && panstate.trim()){
			$.ajax({
				url:'../clientmaster/getstatepinmaskusingstatecode/'+panstate,
				method:'POST',
				dataType:'JSON',
				contentType: 'application/json',
				 success:function(resp){
				    if(null!=resp){
				    	pangststartpinmask = resp.numvalue1; 
				    	pangstendpinmask = resp.numvalue2;
				    	var statecode = resp.charvalue2;
				    	
				    
				    	if(null!=panstate && panstate.trim() && 'NA' != panstate.trim()){
							$('#pancountry').val('India');
						}else{
							//$('#pancountry').val('');
						}
				    }
				 },
			});
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
			errorMessage("info", "Please Enter Valid GSTIN", "Required Filed..!");
			$('#gstdetailgstin').focus();
			return false;
		}
		
		
	
		if(null==gstdetailaddress || !gstdetailaddress.trim()){
			errorMessage("info", "Please Enter Address", "Required Filed..!");
			$('#gstdetailaddress').focus();
			return false;
		}
		
		
		if(null==gstdetailcity || !gstdetailcity.trim()){
			errorMessage("info", "Please Enter City", "Required Filed..!");
			$('#gstdetailcity').focus();
			return false;
		}
		
	
		if(null==gstdetailpincode || !gstdetailpincode.trim()){
			errorMessage("info", "Please Enter Pin Code", "Required Filed..!");
			$('#gstdetailpincode').focus();
			return false;
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
		
		
		if('OUT SIDE INDIA' == gstdetailtatecode && (null==suppliercountry || !suppliercountry.trim())){
				errorMessage("info", "Please enter country name..!", "Required Field..!");
				$('#gstdetailtatecode').focus();
				return false;
				
				
		}else if(null==gstdetailpincode || !gstdetailpincode.trim()){
				errorMessage("info", "Please enter Pincode..!", "Required Field..!");
				$('#gstdetailpincode ').focus();
				return false;
		}
			
		if('OUT SIDE INDIA' != gstdetailtatecode && null!=gststartpinmask && null!=gstendpinmask){
				var startpinmasklength = gststartpinmask.toString().length;
				if(!(parseInt(gstdetailpincode.substring(0,startpinmasklength)) >= gststartpinmask  && parseInt(gstdetailpincode.substring(0,startpinmasklength)) <= gstendpinmask)){
					errorMessage("info", "Pincode doesn't match with your state..!!", "Doesn't match ");
					$('#gstdetailpincode').focus();
					return false;
		}
	}
		
		
	
	
	
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
	
	
	$.ajax({
		url: '../supplierpandetail/savesuppliermastergstin',
		        type: 'post',
		        dataType: 'json',
		        contentType: 'application/json',
		        data: JSON.stringify(clientgstindata),
		        success: function (resp) {
		        	if(resp['SAVE']!=null || resp['SAVE']!= undefined)
		        	{
		        	 errorMessage("info", ""+'DATA SAVE '+resp['SAVE']+"", "Message..!");
		        	}
		        	if(resp['DUPLICATE']!=null || resp['DUPLICATE']!= undefined)
		        	{
		        	 errorMessage("info", ""+''+resp['DUPLICATE']+"", "Message..!");
		        	}
		        	if(resp['ERRORMASSAGE']!=null || resp['ERRORMASSAGE']!= undefined)
		        	{
		        	 errorMessage("info", ""+''+resp['ERRORMASSAGE']+"", "Message..!");
		        	}
		        	getgstDetail();
		        },
		    });
	
	$('#addgstindetails').modal('hide');
		return true;
	}

	var panregisteredstate = $("#panregisteredstate").kendoDropDownList({
	   	autoBind: true,
	       optionLabel: "Select State",
	       dataTextField: "charvalue1",
	       dataValueField: "charvalue2",
	       filter: "contains",
	       dataSource: {
	           serverFiltering: true,
	           transport: {
	           	read: {
	           		url: "../clientmaster/statelist",
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
        filterable: true,
        pageable: {
            input: true,
            numeric: true
        },
        columns: [
        	{ command: [{name: 'edit', text: '', className: "themeIconColor panmodal"}]},
        	/* { command: ["edit"], title: "ACTION", width: "160px", class:'panmodal'}, */
            { field: "pannumber", title: "PanNumber", width: "130px" },
            { field: "gstin", title: "GSTIN", width: "130px" },
            { field: "srno", title: "Sr No", width: "130px" },
            { field: "address", title: "Address", width: "130px" },
            { field: "city", title: "City", width: "130px" },
            { field: "statecode", title: "StateCode", width: "130px" },
            { field: "pincode", title: "Pincode", width: "130px" },
            { field: "country", title: "Country", width: "130px" },
        ],
        dataBound: function(e) {
            $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
        }
};
 

	var gstdetailtatecode= $("#gstdetailtatecode").kendoDropDownList({
		optionLabel: "Select State",
	    dataTextField: "charvalue1",
	    dataValueField: "charvalue2",
	    filter: "contains",
	    dataSource: {
	        serverFiltering: true,
	        transport: {
	           	read: {
	           		url: "../clientmaster/statelist",
	                type: "POST",
	                dataType: "json",
	           	}
	    	}
	    },
	}).data("kendoDropDownList");



	$(document).on('click','#panbasegrid a.k-button-icontext.k-grid-edit',function(){
		    var $this = $(this);
		    var srno = $($this.parents('tr')).find('td:nth-child(4)').text();
		    var pannumber = $($this.parents('tr')).find('td:nth-child(2)').text();
		    var gstin = $($this.parents('tr')).find('td:nth-child(3)').text();
		    var clientid = $('#clientidhd').val();
		    
		    $('.gstdetailisactive').show();
		    
		    $('#srno').val('')
		    if(null!=srno && srno.trim() && null!=pannumber && pannumber.trim()){
		    	$('#gstindetailsrno').val(srno);
		     $.getJSON("../supplierpandetail/getgstiondetail/"+srno+"/"+pannumber+"/"+gstin+"", function(resp) {
		    	
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
	
		    	 gstinstate = resp[0].statecode;
				console.log(gstinstate);
		    	 gstdetailtatecode.select(function(data){
		    	 return data.charvalue2==resp[0].statecode;
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
		$('.gstdetailisactive').hide();
		$('#addgstindetails').find('input').each(function(){
			$('#'+$(this).attr('id')).val('');
			var gstdetailtatecode = $("#gstdetailtatecode").data("kendoDropDownList");
			if(undefined!=gstdetailtatecode){
				gstdetailtatecode.text("");
				gstdetailtatecode.enable(true);
			}
		});
		
		$('#gstdetailgstin').val('').attr('readonly',false);
		
		$('#addgstindetails').modal('show');
	});


var pantypeofsupplier = $("#pantypeofsupplier ").kendoDropDownList({
    optionLabel: "Select GST Supplier Type...",
    dataTextField: "masterdescription",
    dataValueField: "masterdescription",
    dataSource: {
    	serverFiltering: true,
        transport: {
        	read: {
        		url: "../suppliermaster/getgstvendertype",
                type: "POST",
                dataType: "json",
            }
        }
     },
     filter: "contains",
  }).data("kendoDropDownList"); 
 
		   
// GETDATA IN SUPPLIERMASTER


	//SAC DEATIL

 $("#sactype").kendoDropDownList({
	 optionLabel: "Select SacType ",
     dataTextField: "text",
     dataValueField: "value",
     dataSource: [
         { text: "SAC", value: "S" },
         { text: "HSN", value: "H" }
     ],
     filter: "contains",
     suggest: true,
     index: -1
 });

	 $("#sachsncombo").kendoDropDownList({
		  	optionLabel: "Select SAC/HSN ",
		    dataTextField: "typename",
		    dataValueField: "typename",
		    dataSource: {
		    	serverFiltering: true,
		        transport: {
		        	read: {
		        		url: "../supplierpandetail/gethsnsac/",
		                type: "POST",
		                dataType: "json",
		            }
		        }
		     },
		     filter: "contains",
	  }).data("kendoDropDownList"); 				 	   
	 			
	 			  
	 $(document).on('change','#sactype',function(){
			 var sactype = $(this).val();
			 $('#sachsntaxslab').val(0);
			 var sachsncombo = $("#sachsncombo").data("kendoDropDownList");
			 if(null!=sachsncombo && undefined!=sachsncombo){
				 sachsncombo.select(0);
				 sachsncombo.enable(true);
			 }
		 
			 if(null!=sactype && sactype.trim()){
				 getSACHSNList(sactype);
			 }
			 else{
				 sachsncombo.select(0);
				 sachsncombo.enable(false);
			 }
	
	  }); 			   
 			   
 			   
	 var sachsncombo = null;
	 function getSACHSNList(sactype){
			if(null!=sactype && sactype.trim()){
				sachsncombo = $("#sachsncombo").kendoDropDownList({
			 	      optionLabel: "Select SAC HSN...",
			 	      dataTextField: "typename",
			 	      dataValueField: "typecode",
			 	      filter: "contains",
			 	      dataSource: {
			 	          transport: {
			 	              read:{
			 	                 url: function(){
			 	                 	return '../supplierpandetail/gethsnsac/'+sactype ;
			 	                 },
			 	                 type: "POST",
			 	             	   dataType: "json",
			 	             }
			 	          }
			 	      },
			 	     dataBound: function(e) {
			        	 this.select(function(dataItem) {
			         	     return dataItem.typecode == sachsncomboval;
			         	 });
			         }
			 	  }).data("kendoDropDownList");
			   }
			} 		
 			   
 			   
	 $(document).on('change','#sachsncombo',function(){
			var sactype = $('#sactype').val();
			var sachsncombo = $(this).val();
			$.getJSON("../supplierpandetail/getperslab/"+sactype+"/"+sachsncombo+"", function(resp) {
				$('#sachsntaxslab').val(resp[0].tax_slab_per);
				$('#typename').val(resp[0].typename);
	   	    });  
	 }); 	 			   
 					   
// MAIN
	 /*$(document).on('click','#panbased-tab',function(){
			var supplieridhd  = $('#supplierid').val();
			var suppliernamehd  = $('#suppliername').val();
			$('.supplieridtxt').html(supplieridhd);
			$('.suppliernametxt').html(suppliernamehd);
			var supplieridhd =  $('#supplieridhd').val();
			var details = JSON.parse(sessionStorage.getItem('userdetail'));
	       	var uniqueid = details.uniqueid;
	       	var divisionid = details.divisionid;
	       	var companyid = details.companyid;
	       	var loginid = details.loginid;
	       	if(null!=supplieridhd && supplieridhd.trim().length>0){
	       		
	        	$.getJSON("../supplierpandetail/getsupplierdateForpan/"+uniqueid+"/"+supplieridhd+"", function(resp) {
	        		
	        		$('#panpannumber').val(resp[0].pannumber);
	        		$('#pancontactperson').val(resp[0].contactperson);
	        		$('#panregisteredaddress1').val(resp[0].address1);
	        		$('#panregisteredaddress2').val(resp[0].address2);
	        		$('#panregisteredaddress3').val(resp[0].address3)
	        		$('#panregisteredcity').val(resp[0].city)
	        		$('#pancountry').val(resp[0].country)
	        		$('#panemailid').val(resp[0].emailid)
	        		$('#panfaxnumbers').val(resp[0].faxnumbers)
	        		$('#panregisteredpin').val(resp[0].pin);
	        		$('#pantelephonenumbers').val(resp[0].telephonenumbers)
	        		$('#pantypeofsupplier').data("kendoDropDownList").select(function(dataItem) {
	        		   	  	return dataItem.masterdescription == resp[0].gst_vendor_type;
	        		});
	        		
	        		  var supgrp = $("#pantypeofsupplier").data("kendoDropDownList");
				          supgrp.enable(false);
				          
				          if(resp[0].gst_vendor_type==="FOREIGN VENDOR"){
				        	  var aa = $("#panregisteredstate").data("kendoDropDownList");
					          aa.enable(false);
					          $('#panregisteredpin').val("").prop('disabled',true);
				          }
				          else{
				        	  var aa = $("#panregisteredstate").data("kendoDropDownList");
					          aa.enable(true);
				          }
				          
	        		
	        		       	$('#panregisteredstate').data("kendoDropDownList").select(function(dataItem) {
	        		       		return dataItem.charvalue1 == resp[0].state;
	        		       	});
	        		       	$('#panregisteredstate').trigger('change');
	        		       	
	        	});
	        	getgstDetail();
	        	getsachsngrid();
	     	}
		}); 
	 */
	 
	 $(document).on('click','#panbased-tab',function(){
		 
		 	var pannumber = $('#pannumber').val();
			var supplieridhd  = $('#supplierid').val();
			var suppliernamehd  = $('#suppliername').val();
			$('.supplieridtxt').html(supplieridhd);
			$('.suppliernametxt').html(suppliernamehd);
			var supplieridhd =  $('#supplieridhd').val();
			var details = JSON.parse(sessionStorage.getItem('userdetail'));
	       	var uniqueid = details.uniqueid;
	       	var divisionid = details.divisionid;
	       	var companyid = details.companyid;
	       	var loginid = details.loginid;
	       	if(null!=supplieridhd && supplieridhd.trim().length>0){
	       		
	        	$.getJSON("../supplierpandetail/getsupplierdateForpan1/"+pannumber+"", function(resp) {
	        		
	        		$('#panpannumber').val(resp[0].pannumber);
	        		$('#pancontactperson').val(resp[0].contactperson);
	        		$('#panregisteredaddress1').val(resp[0].address1);
	        		$('#panregisteredaddress2').val(resp[0].address2);
	        		$('#panregisteredaddress3').val(resp[0].address3)
	        		$('#panregisteredcity').val(resp[0].city)
	        		$('#pancountry').val(resp[0].country)
	        		$('#panemailid').val(resp[0].emailid)
	        		$('#panfaxnumbers').val(resp[0].faxnumbers)
	        		$('#panregisteredpin').val(resp[0].pin);
	        		$('#pantelephonenumbers').val(resp[0].telephonenumbers)
	        		$('#pannsdlsuppliername').val(resp[0].nsdlsuppliername);
	        		
	        		$('#pantypeofsupplier').data("kendoDropDownList").select(function(dataItem) {
	        		   	  	return dataItem.masterdescription == resp[0].gst_vendor_type;
	        		});
	        		
	        		  var supgrp = $("#pantypeofsupplier").data("kendoDropDownList");
				          supgrp.enable(false);
				          
				          if(resp[0].gst_vendor_type==="FOREIGN VENDOR"){
				        	  var aa = $("#panregisteredstate").data("kendoDropDownList");
					          aa.enable(false);
					          $('#panregisteredpin').val("").prop('disabled',true);
				          }
				          else{
				        	  var aa = $("#panregisteredstate").data("kendoDropDownList");
					          aa.enable(true);
				          }
				          
				          	
	        		       	$('#panregisteredstate').data("kendoDropDownList").select(function(dataItem) {
	        		       		var dd = resp[0].state;
	        		       		if(dd==="NA"){
	        		       			dd='OUT SIDE INDIA';
	        		       		}
	        		       		
	        		       		return dataItem.charvalue1 == dd;
	        		       	});
	        		       	$('#panregisteredstate').trigger('change');
	        		       	
	        	});
	        	getgstDetail();
	        	getsachsngrid();
	     	}
		}); 
	 
	 
	 
	 
 			  
	 function getgstDetail(){
			 var pannumber = $('#pannumber').val();
			if(null!=pannumber && pannumber.trim().length!=''){
				$.getJSON( "../supplierpandetail/getgstdetail/"+pannumber+"", function( resp ) {
					panoption.dataSource.data = resp;
				  $("#panbasegrid").kendoGrid(panoption);
				});
			}  
	  }			
 			  
 			  
	 const sachsngrid = {
        		dataSource: {
                    schema: {
                        model: {
                            fields: {
                            	   attrtypename: { type: "string" },
                            	   srno:{type:"string"},
                                 typename: { type: "string" },
                                 tax_slab_per: { type: "number" }   
                            }
                        }
                    },
                    pageSize: 17
                },
                toolbar: [{name: 'create', text: 'Add', className: "themeColor"}],
                autoBind: true,
                height: 200,
                scrollable: true,
                sortable: true,
                filterable: true,
                pageable: {
                    input: true,
                    numeric: false
                },
                columns: [
             	   //{ command: ["edit"], title: "ACTION", width: "160px", class:'panmodal'},
             	   { command: [{name: 'edit', text: '', className: "themeIconColor"}], title: "", width: "30px"},
                	   { field: "attrtypename", title: "Type", width: "130px" },
                	   { field: "srno", title: "SrNo", width: "130px" },
                    { field: "typename", title: "SAC/HSN", width: "130px" },
                    { field: "tax_slab_per", title: "Tax Slab Percentage", width: "130px" }
                ]
                ,
                dataBound: function(e) {
                    $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
                }
        };			
            
	  
		function getsachsngrid(){
		 var pannumber = $('#pannumber').val();
		 	if(null!=pannumber && pannumber.trim().length!=''){
				$.getJSON( "../supplierpandetail/getsachsngrid/"+pannumber+"", function( resp ) {
				  sachsngrid.dataSource.data = resp;
				  $("#sachsngrid").kendoGrid(sachsngrid);
				});
			  }  
		 } 					
              

 			   
 			  // SAVE SAC HSN
		 function saveSACHSNData(){
			  var sachsn ={};
			  
			 $('#sachsndetailspop').find('input').each(function(){
				sachsn[$(this).attr('name')] = $(this).val();
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
					sachsn[ids] = values;
			});
			 
			 console.log(sachsn);
			 var typename = $('#typename').val();
			 var pannumber = $('#panpannumber').val();
			 
			 sachsn["typename"] = typename;
			 sachsn["pannumber"] = pannumber;
			  

			$.ajax({
			 	 url: '../supplierpandetail/savesachsndata',
			 	         type: 'post',
			 	         dataType: 'json',
			 	         contentType: 'application/json',
			 	         data: JSON.stringify(sachsn),
			 	         success: function (resp) {
			 	         	//if(resp['SAVE']!=null || resp['SAVE']!= undefined){
			 	         		//errorMessage("info", ""+'DATA SAVE '+resp['SAVE']+"", "Message..!");}
			 	         	if(resp['DUPLICATE']!=null || resp['DUPLICATE']!= undefined){
			 	         		errorMessage("info", ""+''+resp['DUPLICATE']+"", "Message..!");}
			 	         	if(resp['ERROR']!=null || resp['ERROR']!= undefined){
			 	         		errorMessage("info", ""+''+resp['ERRORMASSAGE']+"", "Message..!");}
			 	         	getsachsngrid();
			 	         },
			 	     });
				
				$('#sachsndetailspop').modal('hide');			  
		  }
		  
		  
 			 
 			  
		 var typedata =null,typecodedata=null;
 			  
 			 $(document).on('click','#sachsngrid a.k-button-icontext.themeIconColor.k-grid-edit',function(){
 				 	 var $this = $(this);
 			 	     var srno = $($this.parents('tr')).find('td:nth-child(3)').text();
 			 	     var pannumber = $('#panpannumber').val();
 			 	     $('#sachsnsrno').val('')
 			 	     if(null!=srno && srno.trim() && null!=pannumber && pannumber.trim()){
 			 	     	$('#gstindetailsrno').val(srno);
 			 	      $.getJSON("../supplierpandetail/geteditdateforsachsn/"+srno+"/"+pannumber+"", function(resp) {

 			 	      $('#sactype').data("kendoDropDownList").select(function(dataItem) {
 			 	         	return dataItem.value == resp[0].type;
 			 	      });
 			 	     	
 			 	      $('#sachsncombo').data("kendoDropDownList").select(function(dataItem) {
 			 	 	    	return dataItem.typecode == resp[0].typecode;
 			 	 	  });
 			 	     	
 			 	     $('#sactype').val(resp[0].type).trigger('change');
 			 	     sachsncomboval =  resp[0].typecode;
 			 	     $('#sachsncombo').val(resp[0].typecode).trigger('change');
 			 	     if(resp[0].isdefault==='Y')
 			 	    	 $('#is_defaultsachsn').attr('checked', true);
 			 	     else
 			 	     	 $('#is_defaultsachsn').attr('checked', false);
 			 	     	 $('#sachsnsrno').val(resp[0].srno)
 			 	    });
 			 	     	
 			 	     	 $('#sachsndetailspop').modal('show');
 			 	     }
 			 	 });
 			 
 			   
	 $(document).on('click','#sachsngrid a.k-button.k-button-icontext.k-grid-add',function(){
		 $('#sachsnsrno').val('')
		 $('#sactype').val("").trigger('change');
		 $('#sachsncombo').val('').trigger('change');	
		 $('#sachsntaxslab').val(0);
		 sachsncomboval = ""; 			    
	 });			
 			   
 			
 			 
	 