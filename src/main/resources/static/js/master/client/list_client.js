var serverurl = null;
var before_form_count = 0;
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


const options = {
    dataSource: {
        schema: {
            model: {
                fields: {
                	"clientid" : { type: "string" },
                	"clientname": { type: "string" },
                	"brandid": { type: "string" },
                	"brandname": { type: "string" },
                    "servicetype": { type: "string" },
                    "clienttype": { type: "string" },
                    "gsttype": { type: "string" },
                    "pannumber": { type: "string" },
                    "isactive": { type: "string" },
                    "uniqueid" : { type: "numeric" },
                	"branchname" : { type: "string" },
                }
            }
        },
        pageSize: 17
    },
    toolbar: [{name: 'create', text: 'Add', className: "themeColor"},
    	{name: 'excel', text: 'Export',className:'themeColor'}],
    height: 350,
    scrollable: true,
    sortable: true,
    filterable: false,
    pageable: {
        input: true,
        numeric: false
    },
    columns: [
    	{ command: [{name: 'edit', text: '', className: "themeIconColor"}], title: "&nbsp;"},
    	{ field: "clientid", title: "CLIENT ID", width: "120px" },
    	{ field: "clientname", title: "CLIENT NAME", width: "auto" },
    	{ field: "brandid", title: "BRAND ID", width: "120px" },
    	{ field: "brandname", title: "BRAND NAME", width: "auto" },
        { field: "servicetype", title: "SERVICE TYPE", width: "150px" },
        { field: "clienttype", title: "CLIENT TYPE", width: "150px" },
        { field: "gsttype", title: "GST TYPE", width: "180px" },
        { field: "pannumber", title: "PAN", width: "auto" },
        { field: "isactive", title: "IS ACTIVE", width: "100px" },
        { field: "uniqueid", title: "UNIQUEID", width: "150px" },
    	{ field: "branchname", title: "BRANCH NAME", width: "auto" },
    ]
};



$(document).ready(function() {
        
		$('.collapse').on("hidden.bs.collapse", function(){resizeGrid(400,301.9);});
        $('.collapse').on("shown.bs.collapse", function(){resizeGrid(200,101.9);});
        
        $('#grid div.k-header.k-grid-toolbar a.k-button.k-button-icontext.k-grid-add').on('click',function(){
            window.location.href='clientmaster';				
        });
        
        getSessionData();
        //getSessionValue();
});

function getSessionData(){
	$.ajax({
		url:'http://192.168.168.27:8080/mboss/mudrabizcomps/userdetail/10010011/2018/45',
		type: 'POST',
	    dataType: 'json',
	    contentType: 'application/json',
	    beforeSend: function(req) {
			req.setRequestHeader('userid', "6543210");
			req.setRequestHeader('token', '1234abcd-5678efgh-1234abcd-5678efgh');
        },success: function(resp){
	    	sessionStorage.setItem('userdetail',JSON.stringify(resp));
	    	getSessionValue();
	    },
	});
}
$("#grid").kendoGrid(options);
function getSessionValue(){
	var details = JSON.parse(sessionStorage.getItem('userdetail'));
	if(null!=details && undefined!=details){
		serverurl = details.serverurl;
	}
}

function searchFn(){
	var searchData = {};
	var userdetail = JSON.parse(sessionStorage.getItem('userdetail'));
	var searchclientid = $("#searchclientid").val();
	var clientgroupid = $('#clientgroupid').val();
	var status = $('#status').val();
	var pannumber = $('#pannumber').val();
	
	if(null!=searchclientid && searchclientid.trim()){
		searchData['clientid'] = searchclientid;
	}
	if(null!=clientgroupid && clientgroupid.trim()){
		searchData['clientgroupid'] = clientgroupid;
	}
	if(null!=status && status.trim()){
		searchData['status'] = status;
	}
	
	if(null!=pannumber && pannumber.trim()){
		searchData['pannumber'] = pannumber;
	}
	
	if(null!=userdetail && undefined!=userdetail){
		var uniqueid = userdetail.uniqueid;
		searchData['uniqueid'] = uniqueid;
	}
	
	$.ajax({
	    url: "../clientmaster/clientsearchlist",
	    type: 'POST',
	    dataType: 'json',
	    data:JSON.stringify(searchData),
	    contentType: 'application/json',
	    success: function (resp) {
	    	options.dataSource['data'] = resp; 
	    	$("#grid").kendoGrid(options);
	    	$( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
	    },
	});
}

function resizeGrid(a,b) {
	var gridElement = $("#grid");
    var dataArea = gridElement.find(".k-grid-content");
     
    gridElement.height(a);
    dataArea.height(b);        
}

function addClientFn(){
	document.mainForm.method = 'POST';
	document.mainForm.action = '../clientmaster/addclientmaster';
	document.mainForm.submit();
}


var searchclientid = $("#searchclientid").kendoDropDownList({
	optionLabel: "Select client name...",
    dataTextField: "clientname",
    dataValueField: "clientid",
    filter: "contains",
    dataSource: {
        //serverFiltering: true,
        transport: {
        	read: {
        		url:function(){
       				var details = JSON.parse(sessionStorage.getItem('userdetail'));
       				if(null!=details && undefined!=details){
       					var uniqueid = details.uniqueid;
       					var divisionid = details.divisionid;
       					var companyid = details.companyid;
       					var loginid = details.loginid;
           				if(null!=uniqueid && undefined!=uniqueid && null!=loginid && loginid.trim())
           					return "../clientmaster/clientlist/"+loginid+"/"+uniqueid;
       				}
       				return null;
       			},
                type: "POST",
                dataType: "json",
            }
        }
     },
}).data("kendoDropDownList");

var clientgroupid = $("#clientgroupid").kendoDropDownList({
    autoBind: true,
    optionLabel: "Select client group name...",
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
            },
            parameterMap: function(options, operation) {                                 
            	return sessionStorage.getItem('userdetail');                                 
            }
        }
    },
}).data("kendoDropDownList");

var status = $("#status").kendoDropDownList({
	optionLabel: "Status...",
    dataTextField: "text",
    dataValueField: "value",
    filter: "contains",
    dataSource: [
        { text: "Yes", value: "Y" },
        { text: "No", value: "N" },
    ],
});

$(document).on('click','#grid a.k-button.k-button-icontext.themeColor.k-grid-add',function(){
	addClientFn();
});

$(document).on('click','a.k-button-icontext.k-grid-edit',function(){
	var $this = $(this);
    var clientid = $($this.parents('tr')).find('td:nth-child(2)').text();
    if(null!=clientid && clientid.trim()){
    	$('#clientid').val(clientid);
    	addClientFn();
    }
});