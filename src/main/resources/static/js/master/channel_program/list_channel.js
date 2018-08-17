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

function resizeGrid(a,b) {
    var gridElement = $("#grid");
    var dataArea = gridElement.find(".k-grid-content");
    gridElement.height(a);
    dataArea.height(b);
 }

$(document).ready(function() {
        
	$('.collapse').on("hidden.bs.collapse", function(){resizeGrid(400,301.9);});//.fadeIn( "slow" );
    $('.collapse').on("shown.bs.collapse", function(){resizeGrid(200,101.9);});//.fadeIn( "fast" );
    
    $('#channellistgrid div.k-header.k-grid-toolbar a.k-button.k-button-icontext.k-grid-add').on('click',function(){
    	addChannelFn();
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

const channel_grid_options = {
    dataSource: {
        schema: {
            model: {
                fields: {
                    Channelid: { type: "string" },
                    Channelname: { type: "string" },
                    Channeltype: { type: "string" },
                    Language: { type: "string" },
                    Programid: { type: "string" },
                    Programname: { type: "string" },
                    Isactive: { type: "string" }
                }
            }
        },
        pageSize: 17
    },               
    toolbar: [{name: 'create', text: 'Create', className: "themeColor"},{name: 'excel', text: 'Export', className: "themeColor"}],
    height: 350,
    scrollable: true,
    sortable: true,
    filterable: true,
    resizable: true,
    pageable: {
        input: true,
        numeric: false
    },
    columns: [
        { command: [{name: 'edit', text: '', className: "themeIconColor"}]},
        { field: "Channelid", title: "Channel Id", width: "130px" },
        { field: "Channelname", title: "Channel Name", width: "130px" },
        { field: "Channeltype", title: "Channel Type", width: "130px" },
        { field: "Language", title: "Language", width: "130px" },
        { field: "Programid", title: "Program Id", width: "130px" },
        { field: "Programname", title: "Program Name", width: "130px" },
        { field: "Isactive", title: "Is Active", width: "130px" }
    ],
    dataBound: function(e) {
        $( "#channellistgrid div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
    }
};

$("#channellistgrid").kendoGrid(channel_grid_options);

function getSessionValue(){
	var details = JSON.parse(sessionStorage.getItem('userdetail'));
	if(null!=details && undefined!=details){
		serverurl = details.serverurl;
	}
}

function addChannelFn(){
	document.mainForm.method = 'POST';
	document.mainForm.action = '../channelmaster/addchannelmaster';
	document.mainForm.submit();
}