
var contractype =  $("#contractype").kendoDropDownList({
	   	autoBind: true,
	       optionLabel: "Select Type ...",
	       dataTextField: "text",
	       dataValueField: "value",
	       filter: "contains",
	       dataSource: [
	           { text: "Appointment ", value: "Appointment" },
	           { text: "Empanelement ", value: "Empanelement" },
	           { text: "Agreement", value: "Agreement" }
	           ],
	     }).data("kendoDropDownList");

 
var brandidcontrac = null; 
function getBrandForContact(){
	brandidcontrac = $("#brandidcontrac").kendoDropDownList({
	       optionLabel: "Select Brand ...",
	       dataTextField: "brandname",
	       dataValueField: "brandid",
	       filter: "contains",
	       dataSource: {
	           serverFiltering: true,
	           transport: {
	           	read: {
	           		url:function(){
	       				var details = JSON.parse(sessionStorage.getItem('userdetail'));
	       				var clientidhd = $('#clientidhd').val();
	       				if(null!=details && undefined!=details 
	       						&& null!=clientidhd && clientidhd.trim()){
	       					var uniqueid = details.uniqueid;
	       					var serverurl = details.serverurl;
	           				if(null!=serverurl && serverurl.trim() && null!=uniqueid && undefined!=uniqueid)
	           					return serverurl+"/mudrabizcomps/brands/"+uniqueid+"/"+clientidhd;
	       				}
	       				return null;
	       			},
	           		dataType: "json",
	                	beforeSend: function(req) {
						 req.setRequestHeader('userid', "6543210");
						req.setRequestHeader('token', '1234abcd-5678efgh-1234abcd-5678efgh');
	                 }   
	               }
	           }
	        },
	     }).data("kendoDropDownList");
}
 
var isalertrequired = $("#isalertrequired").kendoDropDownList({
		optionLabel: "Select Alert ...",
    	dataTextField: "text",
    	dataValueField: "value",
    	dataSource: [
        { text: "Yes ", value: "1" },
        { text: "No ", value: "2" }
    ],
}).data("kendoDropDownList");



function contractvalidation(){
	
	var contractype = $('#contractype').val();
	var brandidcontrac = $('#brandidcontrac').val();
	var contracdesc = $('#contracdesc').val();
	var contracfile = $('#contracfile').val();
	var startenddate = $('#startenddate').val();
	var terminationclause = $('#terminationclause').val();
	var revenuefees = $('#revenuefees').val();
	var revenuesupervision = $('#revenuesupervision').val();
	var revenueothers = $('#revenueothers').val();
	var isalertrequired = $('#isalertrequired').val();
	
	if(null==contractype || !contractype.trim()){
		errorMessage("Info", "Please Select Contract Type", "Required Filed..!");
		$('#contractype').focus();
		return false;
	}
	
	if(null==brandidcontrac || !brandidcontrac.trim()){
		errorMessage("Info", "Please Select Brand Name", "Required Filed..!");
		$('#brandidcontrac').focus();
		return false;
	}
	
	if(null==startenddate || !startenddate.trim()){
		errorMessage("Info", "Please select contract start/end date...!", "Required Filed..!");
		$('#startenddate').focus();
		return false;
	}
	
	
	return true;
	
}

function saveContract(){
	if(contractvalidation()){
		$('#contractdetails').modal('hide')
	}
}


$(document).on('change', '#contracfile', function () {
	var validatefile=checkFileUpload('contractfile','contracfile',"5",['pdf']);
		if(validatefile==false){
			$(this).val('');
			return false;
	    }else{
	    	//readURL(this);
	    }
});


const contracoption = {
	    dataSource: {
	        schema: {
	            model: {
	            	fields: {
                        srno: { type: "string" },
                        type: { type: "string" },
                        brandid: { type: "string" },
                        contractfile: { type: "string" },
                        startdate: { type: "string" },
                        enddate: { type: "string" },
                        terminationclause: { type: "string" },
                        revenuefees: { type: "number" },
                        revenuesupervision: { type: "number" },
                        revenueothers: { type: "string" },
                        isalertrequired: { type: "string" },
                        alertinterval: { type: "number" },
                        alertenddate: { type: "string" },
                        isactive: { type: "string" }
                        
                    }
	            }
	        },
	        pageSize: 17
	    },
	    toolbar: [{name: 'create', text: 'Add', className: "themeColor"},],
	    height: 350,
	    scrollable: true,
	    sortable: true,
	    filterable: false,
	    pageable: {
	        input: true,
	        numeric: false
	    },
	    columns: [
	    	{ command: [{name: 'edit', text: '', className: "themeIconColor"}], 
	    		title: "ACTION"},
            { field: "srno", title: "Sr No", width: "130px" },
            { field: "type", title: "Type", width: "130px" },
            { field: "brandid", title: "BrandID", width: "130px" },
            { field: "contractdesc", title: "ContractDesc", width: "130px" },
            { field: "startdate", title: "StartDate", width: "130px" },
            { field: "enddate", title: "EndDate", width: "130px" },
            { field: "terminationclause", title: "Termination Clause", width: "130px" },
            { field: "revenuefees", title: "Revenue Fees", width: "130px" },
            { field: "revenuesupervision", title: "Revenue Supervision", width: "130px" },
            { field: "revenueothers", title: "Revenue Other", width: "130px" },
            { field: "alertinterval", title: "Alert Interval", width: "130px" },
            { field: "alertenddate", title: "Alert End Date", width: "130px" },
            { field: "isactive", title: "Is Active", width: "130px" },
           
          
        ]
	};

$(document).on('click','#base-tab25',function(){
	getContractDetail();
	getBrandForContact();
	var glc = $('#glcode').val();
	var glcodename = $('#glcodename').val();
	$('.submitbtnclass').parent('a').removeClass('disabled');
	var clientidhd =  $('#clientidhd').val();
	$('#clientidtxt,.clientidtxt').html(clientidhd);
	
	var clientnamehd =  $('#clientnamehd').val();
	$('#clientnametxt,.clientnametxt').html(clientnamehd);
	
	var glcodehd =  $('#glcodehd').val();
	
	$('#glcodetxt,.glcodetxt').empty().html(glc+" - "+glcodename);
}); 

function getContractDetail(){
	var clientidhd  = $('#clientidhd').val();
	var details = JSON.parse(sessionStorage.getItem('userdetail'));
	var uniqueid = null;
	if(null!=details && undefined!=details){
		uniqueid = details.uniqueid;
	}
	if(null!=clientidhd && clientidhd.trim() && null!=uniqueid && undefined!=uniqueid ){
		
		$.getJSON( "../clientmaster/getclientcontraclist/"+clientidhd+"/"+uniqueid+"", function( resp ) {
			  contracoption.dataSource.data = resp; 
			  $("#contractgrid").kendoGrid(contracoption);
			  $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
		});
		
	}
}



$(document).on('click','k-button k-button-icontext k-grid-add',function(){
	$('#srno').val('');
	$('#contracdesc').val('');
	$('#startenddate').val('');
	$('#terminationclause').val('');
	$('#revenuefees').val('');
	$('#revenuesupervision').val('');
	$('#revenueothers').val('');
	$('#alertenddate').val('');
	$('#alertinterval').val('');
	
	var html = '<label id="projectinput9" class="file center-block"><input type="file" id="contracfile" name="contracfile"><span class="file-custom"></span></label>';
	$('#contractfilediv').empty().html(html);
	
    $('#contractdetails').modal({backdrop: 'static',
	    keyboard: false},'show');
});



$(document).on('click','#contractgrid a.k-button-icontext.k-grid-edit',function(){
	var $this = $(this);
    var srno = $($this.parents('tr')).find('td:nth-child(2)').text();
    var clientid = $('#clientidhd').val();
    $('#srno').val('');
    var details = JSON.parse(sessionStorage.getItem('userdetail'));
    var uniqueid = null;
	if(null!=details && undefined!=details){
		uniqueid = details.uniqueid;
	}
    if(null!=srno && srno.trim() && null!=uniqueid && uniqueid.trim()){
    	$('#srno').val(srno);
    	$.getJSON("../clientmaster/getEditClientContracList/"+uniqueid+"/"+clientid+"/"+srno+"", function(resp) {
    		
    		brandidcontrac.select(function(data){
    			return data.brandid==resp[0].brandid;
    		});
    		
    		contractype.select(function(data){
    			return data.value==resp[0].type;
    		});
    		
    		isalertrequired.select(function(data){
    			return data.value=resp[0].isalertrequired;
    		});
    		
    		$('#srno').val(resp[0].srno);
    		$('#contracdesc').val(resp[0].contractdesc);
    		$('#startenddate').val(resp[0].startdate+" - "+resp[0].enddate);
    		$('#terminationclause').val(resp[0].terminationclause);
    		$('#revenuefees').val(resp[0].revenuefees);
    		$('#revenuesupervision').val(resp[0].revenuesupervision);
    		$('#revenueothers').val(resp[0].revenueothers);
    		$('#alertenddate').val(resp[0].alertenddate);
    		$('#alertinterval').val(resp[0].alertinterval);
    		$('#contract_is_active').show();
    		if(resp[0].isactive==='Y')
    			$('#contracisactive').attr('checked', true);
    		else
    			$('#contracisactive').attr('checked', false);
    		
    		var contractfile = resp[0].contractfile;
    		if(null!=contractfile && undefined!=contractfile && contractfile.trim()){
    			var html = '<a href="./contractdownloadfiles?path='+contractfile+'" class="dwnldbtn"><i class="fa fa-download mt-04" title="download file" aria-hidden="true"></i></a>';
    			$('#contractfilediv').empty().html(html);
    		}else{
    			var html = '<label id="projectinput9" class="file center-block"><input type="file" id="contracfile" name="contracfile"><span class="file-custom"></span></label>';
    			$('#contractfilediv').empty().html(html);
    		} 
    			
    		
    	});
    	
    	$('#contractdetails').modal({backdrop: 'static',
    	    keyboard: false},'show');
    }
});


$(document).on('click','#contractgrid a.k-button-icontext.k-grid-add',function(){

	$('#contractdetails').find('input').each(function(){
		$('#'+$(this).attr('id')).val('').attr('readyonly',false);
		var contractype = $("#contractype").data("kendoDropDownList");
		if(undefined!=contractype)
			contractype.text("");
		
		var brandidcontrac = $("#brandidcontrac").data("kendoDropDownList");
		if(undefined!=brandidcontrac)
			brandidcontrac.text("");
		
		var isalertrequired = $("#isalertrequired").data("kendoDropDownList");
		if(undefined!=isalertrequired)
			isalertrequired.text("");
		
		$('#contract_is_active').hide();
	});
	
	var html = '<label id="projectinput9" class="file center-block"><input type="file" id="contracfile" name="contracfile"><span class="file-custom"></span></label>';
	$('#contractfilediv').empty().html(html);

	$('#contractdetails').modal({backdrop: 'static',
	    keyboard: false},'show');
});










