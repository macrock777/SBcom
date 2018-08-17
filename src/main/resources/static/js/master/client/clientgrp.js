const option = {
	    dataSource: {
	        schema: {
	            model: {
	            	 fields: {
	            		 uniqueid: { type: "string" },
	            		 branchname :{ type: "string" },
	                     clientid: { type: "string" },
	                     clientname: { type: "string" }
	                 }
	            }
	        },
	        pageSize: 17
	    },
	    height: 350,
	    scrollable: true,
	    sortable: true,
	    filterable: false,
	    pageable: {
	        input: true,
	        numeric: false
	    },
	    columns: [
	        { field: "clientid", title: "ClientId", width: "130px" },
	        { field: "clientname", title: "ClientName", width: "130px" }
	    ]
	};


$(document).on('click','#base-tab24',function(){
	
	var glc = $('#glcode').val();
	var glcodename = $('#glcodename').val();
	$('.submitbtnclass').parent('a').addClass('disabled');
	var clientidhd =  $('#clientidhd').val();
	$('#clientidtxt,.clientidtxt').html(clientidhd);
	
	var clientnamehd =  $('#clientnamehd').val();
	$('#clientnametxt,.clientnametxt').html(clientnamehd);
	
	var glcodehd =  $('#glcodehd').val();
	
	$('#glcodetxt,.glcodetxt').empty().html(glc+" - "+glcodename);
	
	var clientgroupid = $('#clientgroupid').val();
	$('#clientidgrptxt').empty().html(clientgroupid);
	
	var details = JSON.parse(sessionStorage.getItem('userdetail'))
	if(null!=details && undefined!=details && null!=clientgroupid && clientgroupid.trim()){
		var uniqueid = details.uniqueid;
		if(null!=uniqueid && undefined!=uniqueid){
			$.getJSON( "../clientgroupmaster/getclientgrouplist/"+uniqueid+"/"+clientgroupid+"", function( resp ) {
				  option.dataSource.data = resp; 
				  $("#clientgrpgrid").kendoGrid(option);
			});
		}
	}
	
});








	


