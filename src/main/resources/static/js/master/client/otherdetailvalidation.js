
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

function toUpperCaseFn(thiss){
	thiss.value = ((null!=thiss.value&&thiss.value.trim())?thiss.value.toUpperCase():'');	  
}


$("#supplierid").kendoDropDownList({
   	autoBind: true,
       optionLabel: "Select Supplier Code...",
       dataTextField: "suppliername",
       dataValueField: "supplierid",
       dataSource: {
           serverFiltering: true,
           transport: {
           	read: {
           			url: function(){
           				var details = JSON.parse(sessionStorage.getItem('userdetail'))
           				if(null!=details && undefined!=details){
           					var uniqueid = details.uniqueid;
           					var serverurl = details.serverurl;
               				if(null!=serverurl && serverurl.trim() && null!=uniqueid && undefined!=uniqueid)
               					return serverurl+"/mudrabizcomps/othersuppliers/"+uniqueid;
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






$(document).on('click','#base-tab26',function(){
	
	var glc = $('#glcode').val();
	var glcodename = $('#glcodename').val();
	
	var clientidhd =  $('#clientidhd').val();
	$('#clientidtxt,.clientidtxt').html(clientidhd);
	
	var clientnamehd =  $('#clientnamehd').val();
	$('#clientnametxt,.clientnametxt').html(clientnamehd);
	
	var glcodehd =  $('#glcodehd').val();
	
	$('#glcodetxt,.glcodetxt').empty().html(glc+" - "+glcodename);
	
	var clientid = $('#clientidhd').val();
	
	var details = JSON.parse(sessionStorage.getItem('userdetail'))
	if(null!=details && undefined!=details && null!=clientid && clientid.trim()){
		var uniqueid = details.uniqueid;
		if(null!=uniqueid && undefined!=uniqueid){
			$.getJSON( "../clientmaster/getclientotherdetail/"+uniqueid+"/"+clientid+"", function( resp ) {
				  otherDetailSetFn(resp);
			});
		}
	}
	
});





function otherDetailSetFn(resp){
		
		var timesheetdisplay = resp.timesheetdisplay;
		if('Y'==timesheetdisplay){
			$('#timesheetdisplay1').prop('checked',true);
		}else{
			$('#timesheetdisplay1').prop('checked',false);
		}
		
		var stampdutyapplicable = resp.stampdutyapplicable;
		if('Y'==stampdutyapplicable){
			$('#stampdutyapplicable').prop('checked',true);
		}else{
			$('#stampdutyapplicable').prop('checked',false);
		}
		
		var isapprovalinsertiondate = resp.isapprovalinsertiondate;
		if('Y'==isapprovalinsertiondate){
			$('#isapprovalinsertiondate').prop('checked',true);
		}else{
			$('#isapprovalinsertiondate').prop('checked',false);
		}
		
		var supplierid = resp.supplierid;
		if(null!=supplierid && supplierid.trim()){
			$('#supplierid').data("kendoDropDownList").select(function(dataItem) {
        		    return dataItem.supplierid == supplierid;
        	 });
			
			//$('#tab26').find('input').prop('disabled',true);
			$('.submitbtnclass').parent('a').addClass('disabled');
		}
		
		var chequebank = resp.chequebank;
		if(null!=chequebank && chequebank.trim()){
			$('#chequebank').val(chequebank);	
		}
		
		var chequebranch = resp.chequebranch;
		if(null!=chequebranch && chequebranch.trim()){
			$('#chequebranch').val(chequebranch);	
		}
		
		var stampcharg = resp.stampcharg;
		if(null!=stampcharg && stampcharg.toString().trim()){
			$('#stampcharg').val(stampcharg);	
		}
		
		
}






