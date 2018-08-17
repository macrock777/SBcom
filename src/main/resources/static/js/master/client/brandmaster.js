var brandedit = 'NO';
var bstartpinmask = null;
var bendpinmask = null;
var productcodeedittime = null;

$(document).on('change','#bstate',function(){
	var statename = $(this).val();
	if(null!=statename && statename.trim() && 'OUT SIDE INDIA' != statename.trim()){
		$('#bcountry').val('India');
	}else{
		$('#bcountry').val('');
	}
});

var printuniqueid = $("#printuniqueid").kendoDropDownList({
    optionLabel: "Select Print Id...",
    dataTextField: "branchname",
    dataValueField: "uniqueid",
    filter: "contains",
    dataSource: {
        transport: {
        	read: {
        		url:function(){
       				var details = JSON.parse(sessionStorage.getItem('userdetail'));
       				if(null!=details && undefined!=details){
       					var uniqueid = details.uniqueid;
       					var divisionid = details.divisionid;
       					var companyid = details.companyid;
       					var serverurl = details.serverurl;
           				if(null!=serverurl && serverurl.trim() && null!=uniqueid && undefined!=uniqueid)
           					return serverurl+"/mudrabizcomps/useraccessbranches/45/5102/"+companyid+"/"+divisionid+"";
       				}
       				return null;
       			},
                type: "GET",
                dataType: "json",
                contentType: "application/json",
                beforeSend: function(req) {
					req.setRequestHeader('userid', "6543210");
				 	req.setRequestHeader('token', '1234abcd-5678efgh-1234abcd-5678efgh');
                }
            },
        }
    },
}).data("kendoDropDownList");

function brandAddressValidation(){
	
	var filter =	/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i ;
	var baddress1 = $('#baddress1').val();
	var baddress2 = $('#baddress2').val();
	var baddress3 = $('#baddress3').val();
	var bcity = $('#bcity').val();
	var bpin = $('#bpin').val();
	var bstate = $('#bstate').val();
	var bcountry = $('#bcountry').val();
	var bstdcode = $('#bstdcode').val();
	var btelephonenumbers = $('#btelephonenumbers').val();
	var bfaxnumbers = $('#bfaxnumbers').val();
	var bemailid  =  $('#bemailid').val();
	
	if((null==baddress1 || !baddress1.trim()) && (null==baddress2 || !baddress2.trim())  && (null==baddress3 || !baddress3.trim()) ){
		errorMessage("info", "Please Enter Address", "Required Field..!");
		return false;
	}
	
	var addressLen =  baddress1+""+baddress2+""+baddress3;
	if(addressLen.length<20){
		errorMessage("info", "Address must be 20 character", "Required Field..!");
		return false;
	}

	if(null==bcity || !bcity.trim()){
		errorMessage("info", "Please Enter City", "Required Field..!");
		$('#bcity').focus();
		return false;
	}
	
	if(null==bstate || !bstate.trim()){
		errorMessage("info", "Please Select State", "Required Field..!");
		return false;
	}
	
	if(null==bcountry || !bcountry.trim()){
		errorMessage("info", "Please Enter Country", "Required Field..!");
		$('#bcountry').focus();
		return false;
	}
	
	if('OUT SIDE INDIA' == bstate && (null==bcountry || !bcountry.trim())){
		errorMessage("info", "Please enter country name..!", "Required Field..!");
		$('#bstate').focus();
		return false;
	}else if('OUT SIDE INDIA' != bstate && (null==bpin || !bpin.trim())){
		errorMessage("info", "Please enter Pincode..!", "Required Field..!");
		$('#bpin ').focus();
		return false;
	}else if(('OUT SIDE INDIA' != bstate && null!=bpin && bpin.trim()) && bpin.trim().length!=6){
		errorMessage("info", "Please enter valid pincode..!", "Required field..!");
		$('#bpin').focus();
		return false;
	}
	
	if('OUT SIDE INDIA' != bstate && null!=bstartpinmask && null!=bendpinmask){
		var startpinmasklength = bstartpinmask.toString().length;
		if(!(parseInt(bpin.substring(0,startpinmasklength)) >= bstartpinmask  
				&& parseInt(bpin.substring(0,startpinmasklength)) <= bendpinmask)){
			errorMessage("info", "Pincode doesn't match with your State..!!", "Doesn't Match ");
			$('#bpin').focus();
			return false;
		}
	}

	if(null==bstdcode || !bstdcode.toString().trim()){
		errorMessage("info", "Please Enter STD Code", "Required Field..!");
		$('#bstdcode').focus();
		return false;
	}
	
	if(null==btelephonenumbers || !btelephonenumbers.toString().trim()){
		errorMessage("info", "Please Enter Phone No", "Required Field..!");
		$('#btelephonenumbers').focus();
		return false;
	}else if((bstdcode+btelephonenumbers).toString().trim().length<10){
		errorMessage("info", "Phone number must be 10 digits...!", "Required Field..!");
		$('#btelephonenumbers').focus();
		return false;
	}
	
	if(null!=bfaxnumbers && bfaxnumbers.toString().trim() && bfaxnumbers.toString().trim().length<=10){
		errorMessage("info", "Please Enter Fax No", "Required Field..!");
		$('#bfaxnumbers').focus();
		return false;
	}
	
	if(null!=bemailid && bemailid.trim() && !filter.test(bemailid)){
		errorMessage("info", "Invalid Email", "Required Field..!");
		$('#bemailid').focus();
		return false;
	}
	
	$('#brandaddressreq').modal('hide');
	return true;
}

function brandvalidation(){

	var brandid = $('#brandid').val();
	var brandname = $('#brandname').val();
	var agencytype = $('#agencytype').val();
	var sectorcode = $('#sectorcode').val();
	var productcode = $('#productcode').val();

	var agencycommissionNet = $('#agencycommissionNet').val();
	var cacommission = $('#cacommission').val();
	var clientcommission = $('#clientcommission').val();
	var agencycommission = $('#agencycommission').val();
	var clientfirstsignon = $('#clientfirstsignon').val();

	if(null==brandid || !brandid.trim()){
		errorMessage("info", "Please enter brand id", "Required filed..!");
		$('#brandid').focus();
		return false;
	}

	if(null==brandname || !brandname.trim()){
		errorMessage("info", "Please enter brand name", "Required filed..!");
		$('#brandname').focus();
		return false;
	}

	if(null==agencytype || !agencytype.trim()){
		errorMessage("info", "Please select agecytype", "Required filed..!");
		$('#agencytype').focus();
		return false;
	}

	if(null==sectorcode || !sectorcode.trim()){
		errorMessage("info", "Please select sector", "Required filed..!");
		$('#sectorcode').focus();
		return false;
	}

	if(null==productcode || !productcode.trim()){
		errorMessage("info", "Please select product", "Required filed..!");
		$('#productcode').focus();
		return false;
	}
	
	if($('#exclusivity').prop('checked')){
		var region = $('#region').val();
		if(null==region || !region.trim()){
			errorMessage("info", "Please select region type...!", "Required filed..!");
			$('#region').focus();
			return false;
		}else if(region == 'region'){
			var radioValue = $("input[name='exle']:checked").val();
			if(null==radioValue || !radioValue.trim()){
				errorMessage("info", "Please select region...!", "Required filed..!");
				return false;
			}
		}else if(region != 'region'){
			var other_region_text = $("#other_region_text").val();
			if(null==other_region_text || !other_region_text.trim()){
				errorMessage("info", "Please enter region text...!", "Required filed..!");
				$('#other_region_text').focus();
				return false;
			}
		}
		
	}
	
	if(null==agencycommission || !agencycommission.toString().trim() || isNaN(agencycommission)){
		errorMessage("info", "Please enter agency commission", "Required filed..!");
		$('#agencycommission').focus();
		return false;
	}

	if(null==cacommission || !cacommission.toString().trim() || isNaN(cacommission)){
		errorMessage("info", "Please enter ca commission", "Required filed..!");
		$('#cacommission').focus();
		return false;
	}

	if(null==clientcommission || !clientcommission.toString().trim() || isNaN(clientcommission)){
		errorMessage("info", "Please enter client commission", "Required filed..!");
		$('#clientcommission').focus();
		return false;
	}

	if((parseFloat(agencycommission)+parseFloat(cacommission)+parseFloat(clientcommission))!=parseFloat(15)){
		errorMessage("info", "Agencycomm,ca comm and client comm is 15 % ", "Required filed..!");
		return false;
	}

	if($('#hasBarterDeal').prop('checked')){
		var barterDealAgencyPer = $('#barterDealAgencyPer').val();
		if(null==barterDealAgencyPer || !barterDealAgencyPer.toString().trim() || isNaN(barterDealAgencyPer)){
			errorMessage("info", "Please enter agency % ", "Required filed..!");
			$('#barterDealAgencyPer').focus();
			return false;
		}
		
		
		if(null!=barterDealAgencyPer && barterDealAgencyPer.toString().trim() && parseFloat(barterDealAgencyPer)<=0){
			errorMessage("info", "Please enter agency % ", "Required filed..!");
			$('#barterDealAgencyPer').focus();
			return false;
		}
	}

	if(null==clientfirstsignon || !clientfirstsignon.trim()){
		errorMessage("info", "Please select client first sign on date", "Required filed..!");
		return false;
	}
	
	return true;
}

var brandgridoption = {
                dataSource: {
                    schema: {
                        model: {
                            fields: {
                            	brandid: { type: "string" },
                            	brandname: { type: "string" },
                            	ismediarequired: { type: "string" },
                                agencycommission: { type: "number" },
                                cacommission: { type: "number" },
                                clientcommission: { type: "number" },
                                isactive: { type: "string" },
                            }
                        }
                    },
                    pageSize: 17
                },
                height: 150,
                scrollable: true,
                sortable: true,
                filterable: false,
                pageable: {
                    input: true,
                    numeric: false
                },
                columns: [
                	{ command: [{name: 'edit', text: '', className: "themeIconColor"}],title: "&nbsp;"},
                    { field: "brandid", title: "Brand ID", width: "130px" },
                    { field: "brandname", title: "Brand Name", width: "130px" },
                    { field: "ismediarequired", title: "Is Mediarequired", width: "130px" },
                    { field: "agencycommission", title: "Agency Commission", attributes:{style:"text-align:right;"}, width: "130px"},
                    { field: "cacommission", title: "Ca Commission", attributes:{style:"text-align:right;"}, width: "130px" },
                    { field: "clientcommission", title: "Client Commission", attributes:{'class':"text-right"}, width: "130px" },
                    { field: "isactive", title: "IS Active", attributes:{'class':"text-right"}, width: "130px" },
                ]
};

$("#brandbranches").kendoDropDownTree({
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
			read:{
		        url:function(){
       				var clientidhd = $('#clientidhd').val();
       				if(null!=clientidhd && undefined!=clientidhd && clientidhd.trim()){
       					return "../brandmaster/branches/"+clientidhd+"";
       				}
       				return null;
       			},
                type: "POST",
                dataType: "json",
                contentType: "application/json",
			},
		}
	},
});

var agencytype = null;
function setServiceTypeBrand(serviceDataList){
	agencytype = $("#agencytype").kendoDropDownList({
		optionLabel: "Select Agency Name...",
	    dataTextField: "masterdescription",
	    dataValueField: "mastercode",
	    dataSource:serviceDataList,
	    filter: "contains",
	    dataBound: function(e) {
	        if(null!=servicetype && servicetype.trim()){
	        	this.select(function(dataItem) {
		         		    return dataItem.mastercode === servicetype;
		        });
	        }
	    }
	}).data("kendoDropDownList"); 
}

var sectorcode = $("#sectorcode").kendoDropDownList({
   	autoBind: true,
       optionLabel: "Select Sector Code...",
       dataTextField: "charvalue1",
       dataValueField: "id",
       filter: "contains",
       dataSource: {
           transport: {
           	read: {
           		url: "../brandmaster/sectorlist",
                   dataType: "json",   
               }
           }
        },
}).data("kendoDropDownList"); 

$(document).on('change','#sectorcode',function(){
	var sectorcode = $(this).val();
	var productcodelocal = $("#productcode").data("kendoDropDownList");
	if(null!=productcodelocal && undefined!=productcodelocal){
		productcodelocal.select(0);
		productcodelocal.enable(false);
	}
	if(null!=sectorcode && sectorcode.trim()){
		getProductCodeList(sectorcode);
	}
	
})

var productcode = null;
function getProductCodeList(sectorcode){
	if(null!=sectorcode && sectorcode.trim()){
		productcode = $("#productcode").kendoDropDownList({
		    optionLabel: "Select product code...",
		    dataTextField: "charvalue2",
		    dataValueField: "id",
		    filter: "contains",
		    dataSource: {
		        transport: {
		            read:{
		               url: function(){
		               	return "../brandmaster/productlist/"+sectorcode
		               },
		               type: "POST",
		           	   dataType: "json",
		           }
		        }
		    },
		    dataBound: function(e) {
		    	var productcodelocal = $("#productcode").data("kendoDropDownList");
		    	if(null!=productcodelocal && undefined!=productcodelocal){
		    		productcodelocal.enable(true);
		    	}	
		    	
		    	if(null!=productcodeedittime && productcodeedittime.trim()){
		    		$("#productcode").data("kendoDropDownList").select(function(dataItem) {
		     		 	   return dataItem.id == productcodeedittime;
		         	});	
		    	}
			}
		}).data("kendoDropDownList");
	}
}

$("#region").kendoDropDownList({
    dataTextField: "text",
    dataValueField: "value",
    dataSource: [
        { text: "Region", value: "region" },
        { text: "National", value: "national" },
        { text: "Global", value: "global" },
        { text: "Local", value: "local" }
    ],
    filter: "contains",
    suggest: true,
    index: -1
});

$(document).on('change','#exclusivity',function(){
	var combobox = $("#region").data("kendoDropDownList");
	combobox.text('');
	if($(this).prop('checked')==false){
		combobox.enable(false);
		$('.regionRadio').hide();
		$('.regionText').hide();
	}else{
		combobox.enable(true);
	}
});
	
$(document).on('change','#region',function(){
	var regionVal = $(this).val()
	if(regionVal!='region'){
		$('.regionRadio').hide();
		$('.regionText').show();
	}else{
		$('.regionRadio').show();
		$('.regionText').hide();
	}
});	

$(document).on('change','#hasBarterDeal',function(){
	if($(this).prop('checked')==true){
		$('#barterDealAgencyPer').prop('disabled',false).val('');
	}else{
		$('#barterDealAgencyPer').prop('disabled',true).val('');
	}
});

function getBrandListFn(){
	var clientidhd = $('#clientidhd').val();
	
	if(null!=clientidhd && clientidhd.trim().length>0){
		var brandurl = "../brandmaster/brandlist/"+clientidhd 
		$.ajax({
	            url: brandurl,
	            type: 'POST',
	            dataType: 'json',
	            data:sessionStorage.getItem('userdetail'),
	            contentType: 'application/json',
	            success: function (resp) {
	            	brandgridoption.dataSource['data'] = resp;
   	    	 		$("#grid").kendoGrid(brandgridoption);
   	    	 		$( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
	            },
	        });	
	}	
}

$(document).on('click','#base-tab22',function(){
	
	getBrandListFn();
	cleanBrandMasterFn();
	$('.submitbtnclass').parent('a').addClass('disabled');
	var glc = $('#glcode').val();
	var glcodename = $('#glcodename').val();
	$('#glcodehd').val(glc+""+glcodename);
	var clientidhd =  $('#clientidhd').val();
	$('#clientidtxt,.clientidtxt').html(clientidhd);
	var clientnamehd =  $('#clientnamehd').val();
	$('#clientnametxt,.clientnametxt').html(clientnamehd);
	var glcodehd =  $('#glcodehd').val();
	$('#glcodetxt,.glcodetxt').html(glc+""+glcodename);
	
    var clientidhd =  $('#clientidhd').val();
    $('#clientidtxt,.clientidtxt').html(clientidhd);

    var clientnamehd =  $('#clientnamehd').val();
    $('#clientnametxt,.clientnametxt').html(clientnamehd);

    var glcodehd =  $('#glcodehd').val();
    $('#glcodetxt,.glcodetxt').html(glcodehd);
    setBrandAddress();
    
    var clientprintaddressfrombrand = $('#clientprintaddressfrombrand').prop('checked');
    $('#printadd').prop('checked',clientprintaddressfrombrand);
    
    var servicetype = $('#agencytypehd').val();
    var agencytypedata = $("#agencytype").data("kendoDropDownList");
    if(null!=agencytypedata && undefined!=agencytypedata){
    	agencytypedata.select(0);
    	agencytypedata.select(function(dataItem) {
     	    return dataItem.mastercode === servicetype;
     	});
    }
         
   	  $(document).on('change','#brandid',function(){
			  var brandid = $(this).val();
			  var clientid = $('#clientidhd').val();
			  if(null!=brandid && brandid.trim(),null!=clientid && clientid.trim()){
				$.ajax({
   	            url: '../brandmaster/duplicateBrandId/'+clientid+'/'+brandid,
   	            type: 'post',
   	            dataType: 'json',
   	         	data:sessionStorage.getItem('userdetail'),
   	            contentType: 'application/json',
   	            success: function (resp) {
   	                console.log(resp);
   	             	if(null!=resp && resp.BRANDID_AVAILABLE=='YES'){
   	             		errorMessage("info", "Brand Id Already Available...!", "Duplicate Brand Id..!");
   	             		$('#brandid').val('').focus();
   	             	}
   	            },
   	        });
			  }
		  });

   	
   	
   	var getValidationId = 'base-tab21';
	$(document).on('click','.nav-link',function(){
		if($(this).hasClass('active'))
			getValidationId  =$(this).attr('id');
	});
	
		
});

var bstate = null;

function setBstate(stateDataList){
	bstate = $("#bstate").kendoDropDownList({
		autoBind: true,
	    optionLabel: "Select State Name...",
	    dataTextField: "statename",
	    dataValueField: "statename",
	    filter: "contains",
	    dataSource: stateDataList,
	}).data("kendoDropDownList");
}

$(document).on('click','.addbrandclass',function(){
		if( brandvalidation() && brandAddressValidation()){
			
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
			    	saveBrandRecord();
			    }else{
			    	return null;
			    }
			});
			
		}
});

function saveBrandRecord(){
	var branddata = {};
	$('#brandaddressreq').find('input').each(function(){
		branddata[$(this).attr('id')] = $(this).val();
	});
	
	$('#tab22').find('input:not(#region,#exle,#exln,#exls,#exlw,#other_region_text)').each(function(){
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
	    branddata[ids] = values;
	 });	
	
	 if($('#exclusivity').prop('checked')==true){
		var region = $('#region').val();
		if(region==='region'){
			var radioValue = $("input[name='exle']:checked").val();
			branddata['exclusivityparameter'] = region+'-'+radioValue;
		}else{
			var other_region_text = $('#other_region_text').val();
			branddata['exclusivityparameter'] = region+'-'+other_region_text;
		}
	 }
	
	branddata['clientid'] = $('#clientidhd').val();
	var brandbranchesList = $("#brandbranches").data("kendoDropDownTree");
	if(null!=brandbranchesList && undefined!=brandbranchesList){
		var branches = brandbranchesList.value();
		var objectArray = [];
		var stringArray = [];
		$.each(branches,function(i,data){
			if(typeof data == "string"){
				stringArray.push(data);
			}
			if(typeof data == "object"){
				objectArray.push(data.uniqueid);
			}
		});

		$.each(stringArray,function(i,data){
			$.each(objectArray,function(j,data2){
				if(data2 == data){
					stringArray[j] = "";
		        }
			});
		});
		
		branddata['branches'] = stringArray.toString();
	}
	
	branddata['userdetail'] = JSON.parse(sessionStorage.getItem('userdetail'));
	branddata['edittime'] = brandedit;
	
	$.ajax({
       url: '../brandmaster/saveBrand',
       type: 'post',
       dataType: 'json',
       contentType: 'application/json',
    	data: JSON.stringify(branddata),
       success: function (resp) {
           	console.log(resp);
           	if(resp.BRAND_SAVE == 'SUCCESSFULLY'){
           		errorMessage("success","Brand saved successfully...", "successfully..!");
           		getBrandListFn();
            	cleanBrandMasterFn();
           	}else{
           		errorMessage("error","Reason :- "+resp.REASON+" ...", "Save Failed..!");
           	}
       },
   });
}

function cleanBrandMasterFn(){
	brandedit = 'NO';
	$('#brandaddressreq').find('input').each(function(){
		$('#'+$(this).attr('id')).val('');
	});
	
	$('#brandid').prop('disabled',false);
	
	$('#tab22').find('input:not(#region,#exle,#exln,#exls,#exlw,#other_region_text)').each(function(){
		var inputtype = $(this).attr('type');
		if('checkbox' === inputtype){
			$(this).prop('checked',false).trigger('change');
		}else{
			$(this).val('');
	    }
		
	});
	
	var sectorcode = $("#sectorcode").data("kendoDropDownList");
	if(undefined!=sectorcode)
		sectorcode.text("");
	
	$("#sectorcode").trigger('change');
	
	var printuniqueid = $("#printuniqueid").data("kendoDropDownList");
	if(undefined!=printuniqueid)
		printuniqueid.text("");
	
	var bstate = $("#bstate").data("kendoDropDownList");
	if(undefined!=bstate)
		bstate.select("");
	
	$("#brandbranches").data("kendoDropDownTree").value("");
	
	var servicetype = $('#agencytypehd').val();
    var agencytypedata = $("#agencytype").data("kendoDropDownList");
    if(null!=agencytypedata && undefined!=agencytypedata){
    	agencytypedata.select(0);
    	agencytypedata.select(function(dataItem) {
     	    return dataItem.mastercode === servicetype;
     	});
    }
    
    $('#brand_active_div').hide();
	
}

$(document).on('click','#grid a.k-button-icontext.k-grid-edit',function(){
	var $this = $(this);
    var brandid = $($this.parents('tr')).find('td:nth-child(2)').text();
    var clientid = $('#clientidhd').val();
    if(null!=brandid && brandid.trim() && null!=clientid && clientid.trim()){
    	var brandurlid = '../brandmaster/showbranddetail/'+clientid+'/'+brandid+'';
    	$.ajax({
	            url: brandurlid,
	            type: 'post',
	            dataType: 'json',
	            contentType: 'application/json',
	         	data: sessionStorage.getItem('userdetail'),
	            success: function (resp) {
	            	cleanBrandMasterFn();
	                brandMasterSetVulues(resp);
	             	$('#brand_active_div').show();
	            },
	        });
    }
});


function brandMasterSetVulues(branddetail){
	brandedit = 'YES';
	var address1 = branddetail.address1;
	if(null!=address1 && address1.trim())
		$('#baddress1').val(address1);
		
	var address2 = branddetail.address2;
	if(null!=address2 && address2.trim())
		$('#baddress2').val(address2);
		
	var address3 = branddetail.address3;
	if(null!=address3 && address3.trim())
		$('#baddress3').val(address3);
		
	var bcity = branddetail.city;	
	if(null!=bcity && bcity.trim())
		$('#bcity').val(bcity);
		
	var bfaxnumbers = branddetail.clientfaxnumbers;
	if(null!=bfaxnumbers && bfaxnumbers.trim())
		$('#bfaxnumbers').val(bfaxnumbers);
	
	var pin = branddetail.pin;
	if(null!=pin && pin.trim())
		$('#bpin').val(pin);
	
	var bstate = branddetail.state;
	if(null!=bstate && bstate.trim()){
		$('#bstate').data("kendoDropDownList").select(function(dataItem) {
 		 	   return dataItem.statename == bstate;
     	});
		$('#bstate').trigger('change');
	}
	
	var ismediarequired = branddetail.ismediarequired;
	if(null!=ismediarequired && ismediarequired=='Y'){
		$('#ismediarequired').prop('checked',true);
	}else{
		$('#ismediarequired').prop('checked',false);
	}
	
	var bcountry = branddetail.country;
	if(null!=bcountry && bcountry.trim())
		$('#bcountry').val(bcountry);
		
	var bstdcode = branddetail.clientstdcode;
	if(null!=bstdcode && bstdcode.trim())
		$('#bstdcode').val(bstdcode);
		
	var btelephonenumbers = branddetail.telephonenumbers;
	if(null!=btelephonenumbers && btelephonenumbers.trim())
		$('#btelephonenumbers').val(btelephonenumbers);
	
	var bemailid = branddetail.emailid;
	if(null!=bemailid && bemailid.trim())
		$('#bemailid').val(bemailid);
		
	var agencycommission = branddetail.agencycommission;
	if(null!=agencycommission){
		$('#agencycommission').val(agencycommission);
	}
	
	var agencycommissionNet = branddetail.agencycommission_net;
	if(null!=agencycommission){
		$('#agencycommissionNet').val(agencycommissionNet);
	}
	
	var billingperc = branddetail.billingperc;
	if(null!=billingperc){
		$('#billingperc').val(billingperc);
	}
	
	var brandid = branddetail.brandid;
	if(null!=brandid){
		$('#brandid').val(brandid).prop('disabled',true);
	}
	
	var brandname = branddetail.brandname;
	if(null!=brandname){
		$('#brandname').val(brandname);
	}
	
	var cacommission = branddetail.cacommission;
	if(null!=cacommission){
		$('#cacommission').val(cacommission);
	}
	
	var clientcommission = branddetail.clientcommission;
	if(null!=clientcommission){
		$('#clientcommission').val(clientcommission);
	}
	
	var sectorcode = branddetail.sectorcode;
	if(null!=sectorcode && sectorcode.trim()){
		$("#sectorcode").data("kendoDropDownList").select(function(dataItem) {
 		 	   return dataItem.id == sectorcode;
     	});
		$("#sectorcode").trigger('change');
	}
	
	productcodeedittime = branddetail.productcode;
	if(null!=productcodeedittime && productcodeedittime.trim()){
		$("#productcode").data("kendoDropDownList").select(function(dataItem) {
 		 	   return dataItem.id == productcodeedittime;
     	});	
	}
	
	var printprefix = branddetail.printprefix;
	if(null!=printprefix && printprefix.trim()){
		$('#printprefix').val(printprefix);
	}
	
	var timesheetdisplay = branddetail.timesheetdisplay;
	if(null!=timesheetdisplay && timesheetdisplay=='Y'){
		$('#timesheetdisplay').prop('checked',true);
	}else{
		$('#timesheetdisplay').prop('checked',false);
	}
	
	var clientfirstsignon = branddetail.clientfirstsignon;
	if(null!=clientfirstsignon && clientfirstsignon.trim()){
		$('#clientfirstsignon').val(clientfirstsignon);
	}
	
	var prnbrandnmclientnm = branddetail.prnbrandnmclientnm;
	if(null!=prnbrandnmclientnm && prnbrandnmclientnm=='Y'){
		$('#prnbrandnmclientnm').prop('checked',true);
	}else{
		$('#prnbrandnmclientnm').prop('checked',false);
	}
	
	var omscommissionpercent = branddetail.omscommissionpercent;
	if(null!=omscommissionpercent && omscommissionpercent.toString().trim())
		$('#omscommissionpercent').val(omscommissionpercent);
	
	var printprefix = branddetail.printprefix;
	if(null!=printprefix && printprefix.toString().trim())
		$('#printprefix').val(printprefix);
	
	var remuneration = branddetail.remuneration;
	if(null!=remuneration && remuneration.toString().trim())
		$('#remuneration').val(remuneration);
	
	var interestonunpaidbills = branddetail.interestonunpaidbills;
	if(null!=interestonunpaidbills && interestonunpaidbills.toString().trim())
		$('#interestonunpaidbills').val(interestonunpaidbills);
	
	var isactive = branddetail.isactive;
	if(null!=isactive && isactive == 'Y')
		$('#isactive').prop('checked',true);
	else
		$('#isactive').prop('checked',false);
	
	var exclusivity = branddetail.exclusivity;
	if(null!=exclusivity && exclusivity == 'Y'){
		$('#exclusivity').prop('checked',true).trigger('change');
		var exclusivityparameter = branddetail.exclusivityparameter;
		if(null!=exclusivityparameter && exclusivityparameter.indexOf('-')!=-1){
			var regions = exclusivityparameter.split('-');
			
			if(null!=regions && regions.length>1){
				var region = regions[0];
				var regionValue = regions[1];
				if(null!=region){
					$('#region').data("kendoDropDownList").select(function(dataItem) {
		         		 	   return dataItem.value == region;
		         		});
					$('#region').trigger('change');	
					if(region == 'region'){
						$('#exl'+regionValue.toLowerCase()).prop('checked',true);
					}else{
						$('#other_region_text').val(regionValue);
					}
				}	
			}
		}
	}else if(null!=exclusivity && exclusivity == 'N'){
		$('#exclusivity').prop('checked',false).trigger('change');
	}
	
	var has_barter_deal = branddetail.has_barter_deal;
	if(has_barter_deal == 'Y'){
		$('#hasBarterDeal').prop('checked',true).trigger('change');
		
		var barter_deal_agency_per = branddetail.barter_deal_agency_per;
		if(null!=barter_deal_agency_per){
			$('#barterDealAgencyPer').val(barter_deal_agency_per);
		}
		
	}else if(has_barter_deal == 'N'){
		$('#hasBarterDeal').prop('checked',false).trigger('change');
	}
	
	var servicetype = $('#agencytypehd').val();
    var agencytypedata = $("#agencytype").data("kendoDropDownList");
    if(null!=agencytypedata && undefined!=agencytypedata){
    	agencytypedata.select(0);
    	agencytypedata.select(function(dataItem) {
     	    return dataItem.mastercode === servicetype;
     	});
    }
    
    var printuniqueid = branddetail.printuniqueid;
    var printuniqueidList = $("#printuniqueid").data("kendoDropDownList");
    if(null!=printuniqueidList && undefined!=printuniqueidList){
    	printuniqueidList.select(0);
    	printuniqueidList.select(function(dataItem) {
     	    return dataItem.uniqueid == printuniqueid;
     	});
    }
    
    var branchesopen = branddetail.branchesopen;
    if(null!=branchesopen)
    	$("#brandbranches").data("kendoDropDownTree").value(branchesopen);
    
}

function setBrandAddress(){
	$('#baddress1').val($('#clientaddress1').val());
	$('#baddress2').val($('#clientaddress2').val());
	$('#baddress3').val($('#clientaddress3').val());
	$('#bcity').val($('#clientcity').val());
	$('#bpin').val($('#clientpin').val());
	var stateid = $('#clientstate').val();
	if(null!=stateid && stateid.trim()){
		$('#bstate').data("kendoDropDownList").select(function(dataItem) {
 		 	   return dataItem.statename == stateid;
     	});
    }
	$('#bcountry').val($('#clientcountry').val());
	$('#bstdcode').val($('#clientstdcode').val());
	$('#btelephonenumbers').val($('#clienttelephonenumbers').val());
	$('#bemailid').val($('#clientemailid').val());
	$('#bfaxnumbers').val($('#clientfaxnumbers').val());
}

$('#brandaddressreq').on('shown.bs.modal', function (e) {
	
	if('NO' == brandedit){
		setBrandAddress();
	}
   
});
/*
function clientcommperFn(){
	var agencycommission = $('#agencycommission').val();
	var cacommission = $('#cacommission').val();
	if(null!=cacommission && !isNaN(cacommission) 
			&& null!=agencycommission && !isNaN(agencycommission)){
		var caAndAgencyCommission = parseFloat(cacommission) + parseFloat(agencycommission);
		if(parseFloat(caAndAgencyCommission)<15){
			var clientcommissiondata =  parseFloat(15) - parseFloat(caAndAgencyCommission);
			$('#clientcommission').val(clientcommissiondata).prop('disabled',false);
		}else if(parseFloat(caAndAgencyCommission)>=parseFloat(15)){
			$('#clientcommission').val(0).prop('disabled',false);
		}
		if(null==cacommission || !cacommission.toString().trim()){
			$('#cacommission').val(0);
		}
		var clientcommission = $('#clientcommission').val();
		if(null==clientcommission || !clientcommission.toString().trim()){
			$('#clientcommission').val(0);
		}
	}
	
	
}

$(document).on('change','#agencycommission,#cacommission',function(){
	clientcommperFn();
});*/


$(document).on('change','#bstate',function(){
	var bstate = $(this).val();
	if(null!=bstate && bstate.trim()){
		$.ajax({
			 url:'../clientmaster/getstatepinmask/'+bstate,
			 method:'POST',
			 dataType:'JSON',
			 contentType: 'application/json',
			 success:function(resp){
				if(null!=resp){
					 bstartpinmask = resp.numvalue1; 
			    	 bendpinmask = resp.numvalue2; 
			 	}
			 },
		});
	}
})