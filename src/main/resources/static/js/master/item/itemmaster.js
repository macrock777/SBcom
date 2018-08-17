var serverurl = null;
var before_form_count = 0;
var uniqueid = null;
var iseditItem = null;
var details = JSON.parse(sessionStorage.getItem('userdetail'));
var serverurlCommon = '';
const ajaxUrl = serverurlCommon + '/mudrabizcomps/datafromtable';

if(null!=details && undefined!=details){
	var serverurl = details.serverurl;
	if(null!=serverurl && serverurl.trim())
	serverurlCommon = serverurl;
}

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

$(document).ready(function() {
	$('.collapse').on("hidden.bs.collapse", function(){resizeGrid(400,301.9);});// .fadeIn("slow");
    $('.collapse').on("shown.bs.collapse", function(){resizeGrid(200,101.9);});// .fadeIn("fast");
    itemGriddata.dataSource['data'] = []; 
	$("#itemlistgrid").kendoGrid(itemGriddata);
	
    getUniqueid();
    
    $('#itemlistgrid a.k-button-icontext.themeColor.k-grid-add').on('click', function() {
    	resetAllFields();
    	iseditItem = 'NO';
    	$("#itemcode").prop('disabled',false);
    	$("#groupitemcode").data("kendoDropDownList").enable(true);
    	$('#itemmasteradd').modal('show');
    });
    
});

function resizeGrid(a,b) {
    var gridElement = $("#grid");
    var dataArea = gridElement.find(".k-grid-content");
    gridElement.height(a);
    dataArea.height(b);
}

function getUniqueid()
{
	 var details = JSON.parse(sessionStorage.getItem('userdetail'))
	 if(null!=details && undefined!=details){
		 uniqueid = details.uniqueid;
	 }
	 fillallcombo();
}


function getSessionValue(){
	var details = JSON.parse(sessionStorage.getItem('userdetail'));
	if(null!=details && undefined!=details){
		serverurl = details.serverurl;
	}
}



function fillallcombo(){
	var itemstatus = $("#itemstatus").kendoDropDownList({
		optionLabel: "Select Status",
        dataTextField: "text",
        dataValueField: "value",
        dataSource: [
            { text: "Active", value: "Y" },
            { text: "In-Active", value: "N" }
        ],
        filter: "contains",
        suggest: true,
        index: 0
    }).data("kendoDropDownList");
	
	var groupitemcodeid = $("#groupitemcodeid").kendoDropDownList({
		optionLabel: "Select Group Item Code",
	    dataTextField: "masterdescription",
	    dataValueField: "mastercode",
	    dataSource: {
	        transport: {
	        	read: {
	        		url: "../itemmaster/groupitemcodelist",
	                type: "GET",
	                dataType: "json",
	                global : true,
	            }
	        }
	     },
	    filter: "contains",
	    suggest: true,
	    index: 0
	}).data("kendoDropDownList");

	var itemtypeid = $("#itemtypeid").kendoDropDownList({
		optionLabel: 'Select Item Type',
	    dataTextField: "text",
	    dataValueField: "value",
	    dataSource: [
	        { text: "Stock ", value: "Sto" },
	        { text: "Service", value: "Ser" }
	    ],
	    filter: "contains",
	    suggest: true,
	    index: 0
	}).data("kendoDropDownList");

	var groupitemcode = $("#groupitemcode").kendoDropDownList({
		optionLabel:"Select Group Item Code",
	    dataTextField: "masterdescription",
	    dataValueField: "mastercode",
	    dataSource: {
	        transport: {
	        	read: {
	        		url: "../itemmaster/groupitemcodelist",
	                type: "GET",
	                dataType: "json",
	                global : true,
	            }
	        }
	     },
	    filter: "contains",
	    suggest: true,
	    index: 0
	}).data("kendoDropDownList");

	var stockoreservice =  $("#stockoreservice").kendoDropDownList({
		optionLabel: "Select Item Type",
	    dataTextField: "text",
	    dataValueField: "value",
	    dataSource: [
	        { text: "Stock ", value: "Sto" },
	        { text: "Service", value: "Ser" }
	    ],
	    filter: "contains",
	    suggest: true,
	    index: 0
	}).data("kendoDropDownList");

	var defaultunit = $("#defaultunit").kendoDropDownList({
		optionLabel: "Select Unit Type",
	    dataTextField: "mastercode",
	    dataValueField: "mastercode",
	    dataSource: {
	        transport: {
	        	read: {
	        		url: "../itemmaster/unitlist",
	                type: "GET",
	                dataType: "json",
	                global : true,
	            }
	        }
	     },
	    filter: "contains",
	    suggest: true,
	    index: 0
	}).data("kendoDropDownList");

	var incomeglcode = $("#incomeglcode").kendoDropDownList({
		optionLabel: "Select Income GLcode",
	    dataTextField: "glname",
	    dataValueField: "glcode",
	    dataSource: {
	        transport: {
	        	read: {
	        		url: "../itemmaster/incomeglcodelist/"+uniqueid+"",
	                type: "GET",
	                dataType: "json",
	                global : true,
	            }
	        }
	     },
	    filter: "contains",
	    suggest: true,
	    index: 0
	}).data("kendoDropDownList");

	var expenseglcode = $("#expenseglcode").kendoDropDownList({
		optionLabel: "Select Expense GLcode",
	    dataTextField: "glname",
	    dataValueField: "glcode",
	    dataSource: {
	        transport: {
	        	read: {
	        		url: "../itemmaster/expenseglcodelist/"+uniqueid+"",
	                type: "GET",
	                dataType: "json",
	                global : true,
	            }
	        }
	     },
	    filter: "contains",
	    suggest: true,
	    index: 0
	}).data("kendoDropDownList");
}

function searchData(){
	var groupitemcodeid = $("#groupitemcodeid").val();
	var itemtypeid = $("#itemtypeid").val();
	var itemstatus = $("#itemstatus").val();
	
	var Itemsearchbean = {};
	
	Itemsearchbean['groupitemcodeid'] = groupitemcodeid;
	Itemsearchbean['itemtypeid'] = itemtypeid;
	Itemsearchbean['itemstatus'] = itemstatus;
	Itemsearchbean['itemcode'] = "";
	
	$.ajax({
	    url: "../itemmaster/itemsearchlist",
	    type: 'POST',
	    dataType: 'json',
	    data:JSON.stringify(Itemsearchbean),
	    contentType: 'application/json',
	    success: function (resp) {
	    	$("#itemlistgrid").data("kendoGrid").destroy();
	    	itemGriddata.dataSource['data'] = resp; 
	    	$("#itemlistgrid").kendoGrid(itemGriddata);
	    	$( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
	    },
	});
}

$(document).on('click','#itemlistgrid a.k-button-icontext.themeIconColor.k-grid-edit',function(){
	
	var row = $(this).closest("tr");
	var grid = $("#itemlistgrid").data("kendoGrid");
	var dataItem = grid.dataItem(row);
	var groupitemcode = dataItem.groupitemcode;
	var itemcode = dataItem.itemcode;
	
    if(null!=groupitemcode && groupitemcode.trim() && null!=itemcode && itemcode.trim()){
    	var Itemsearchbean = {};
    	Itemsearchbean['groupitemcodeid'] = groupitemcode;
    	Itemsearchbean['itemtypeid'] = "";
    	Itemsearchbean['itemstatus'] = "";
    	Itemsearchbean['itemcode'] = itemcode;
    	
    	$.ajax({
    	    url: "../itemmaster/itemsearchlist",
    	    type: 'POST',
    	    dataType: 'json',
    	    data:JSON.stringify(Itemsearchbean),
    	    contentType: 'application/json',
    	    success: function (resp) {
    	    	if(null!=resp)
    	    	{
    	    		var data = resp[0];
    	    		resetAllFields();
    	    		if(null!=data && data.groupitemcode != null)
    	    			$("#groupitemcode").data("kendoDropDownList").select(function(dataItem) {
		         		    return dataItem.mastercode == data.groupitemcode;
    	    			});
    	    		if(null!=data && null != data.itemcode != null)
    	    			$("#itemcode").val(data.itemcode);
    	    		if(null!=data && data.stockorserviceedit != null)
	    	    		$('#stockoreservice').data("kendoDropDownList").select(function(dataItem) {
		 				    return dataItem.value == data.stockorserviceedit;
		 				});
    	    		if(null!=data && null != data.incomeglcodeedit)
	    	    		$('#incomeglcode').data("kendoDropDownList").select(function(dataItem) {
		 				    return dataItem.glcode == data.incomeglcodeedit;
		 				});
    	    		if(null!=data && null != data.defaultunit)
	    	    		$('#defaultunit').data("kendoDropDownList").select(function(dataItem) {
		 				    return dataItem.mastercode == data.defaultunit;
		 				});
    	    		if(null!=data && null != data.expenseglcodeedit)
	    	    		$('#expenseglcode').data("kendoDropDownList").select(function(dataItem) {
		 				    return dataItem.glcode == data.expenseglcodeedit;
		 				});
    	    		if(null!=data && null != data.itemdescription)
    	    			$("#itemdescription").val(data.itemdescription);

    	    		iseditItem = 'YES';
    	    		$("#itemcode").prop('disabled',true);
    	    		$("#groupitemcode").data("kendoDropDownList").enable(false);
    	    		$('#itemmasteradd').modal('show');
    	    	}
    	    },
    	});
    }
});

const itemGriddata = {
    dataSource: {
        schema: {
            model: {
                fields: {
                	"groupitemcode" : { type: "string" },
                	"itemcode": { type: "string" },
                	"stockorservice": { type: "string" },
                	"defaultunit": { type: "string" },
                    "incomeglcode": { type: "string" },
                    "expenseglcode": { type: "string" },
                    "isactive": { type: "string" },
                }
            }
        },
        serverPaging :false,
        pageSize: 20,
    },
    excel:{
        allPages:true
    },
    toolbar: [{name: 'create', text: 'Create', className: "themeColor"},{name: 'excel', text: 'Export', className: "themeColor"}],
    height: 350,
    scrollable: true,
    sortable: true,
    filterable: false,
    pageable: {
        input: true,
        pageSizes: [20, 50, 100],
        numeric: false
    },
    columns: [
    	{ command: [{name: 'edit', text: '', className: "themeIconColor"}]},
        { field: "groupitemcode", title: "Group Item Code", width: "130px" },
        { field: "itemcode", title: "Item Code", width: "130px" },
        { field: "stockorservice", title: "Item Type", width: "130px" },
        { field: "defaultunit", title: "Unit", width: "130px" },
        { field: "incomeglcode", title: "Income GLcode", width: "200px" },
        { field: "expenseglcode", title: "Expense GLcode", width: "200px" },
        { field: "isactive", title: "Is Active", width: "130px" }
    ],
    dataBound: function(e) {
        $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
    }
};


function isValidItemdetails(){
	var groupitemcode = $("#groupitemcode").val().trim();
	var itemcode = $("#itemcode").val().trim();
	var incomeglcode = $("#incomeglcode").val().trim();
	var expenseglcode = $("#expenseglcode").val().trim();
	
	if(null == groupitemcode || groupitemcode == undefined || groupitemcode == ""){
		errorMessage("info", "Please Select Group Item Code.", "Required Filed..!");
		$('#groupitemcode').focus();
		return false;
	}else if(null == itemcode || itemcode == undefined || itemcode == ""){
		errorMessage("info", "Please Enter Item Code.", "Required Filed..!");
		$('#itemcode').focus();
		return false;
	}else if(null == incomeglcode || incomeglcode == undefined || incomeglcode == ""){
		errorMessage("info", "Please Select Income GLcode.", "Required Filed..!");
		$('#incomeglcode').focus();
		return false;
	}else if(null == expenseglcode || expenseglcode == undefined || expenseglcode == ""){
		errorMessage("info", "Please Select Expense GLcode.", "Required Filed..!");
		$('#expenseglcode').focus();
		return false;
	}
	return true;
}

function saveItemData(){
	if(isValidItemdetails()){
		var groupitemcode = $("#groupitemcode").val().trim();
		var itemcode = $("#itemcode").val().trim();
		var stockoreservice = $("#stockoreservice").val().trim();
		var incomeglcode = $("#incomeglcode").val().trim();
		var defaultunit = $("#defaultunit").val().trim();
		var expenseglcode = $("#expenseglcode").val().trim();
		var itemdescription = $("#itemdescription").val().trim();
		
		var itemDetails={};
		
		$('#itemmasteradd').find('input').each(function(){
			itemDetails[$(this).attr('name')] = $(this).val();
		});
		
		itemDetails['iseditItem'] = iseditItem;
		
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
		    		url: '../itemmaster/saveitemmasterdata',
			        type: 'post',
			        dataType: 'json',
			        contentType: 'application/json',
			        data: JSON.stringify(itemDetails),
			        success: function (resp) {
			        	if(resp['SAVE'] != null || resp['SAVE'] != undefined){
			        		errorMessage("success", ""+'DATA SAVE '+resp['SAVE']+"", "Message..!");
			        		searchData();
			        		$('#itemmasteradd').modal('hide');
			        	}else if(resp['DUPLICATE'] != null || resp['DUPLICATE'] != undefined){
			        		errorMessage("info", ""+''+resp['DUPLICATE']+"", "Message..!");
			        	}else if(resp['ERRORMASSAGE'] != null || resp['ERRORMASSAGE'] != undefined){
			        		errorMessage("info", ""+''+resp['ERRORMASSAGE']+"", "Message..!");
			        	}else if(resp['REQUIRED_FIELD'] != null || resp['REQUIRED_FIELD'] != undefined){
			        		errorMessage("info", resp['REQUIRED_FIELD'], "Message..!");
			        	}
			        },
			    }); 
		    }
		});
	}
}

function resetAllFields(){
	$("#groupitemcode").data("kendoDropDownList").select(function(dataItem) {
	    return dataItem.mastercode == "";
	});
	$("#itemcode").val("");
	$('#stockoreservice').data("kendoDropDownList").select(function(dataItem) {
	    return dataItem.value == "";
	});
	$('#incomeglcode').data("kendoDropDownList").select(function(dataItem) {
	    return dataItem.glcode == "";
	});
	$('#defaultunit').data("kendoDropDownList").select(function(dataItem) {
	    return dataItem.mastercode == "";
	});
	$('#expenseglcode').data("kendoDropDownList").select(function(dataItem) {
	    return dataItem.glcode == "";
	});
	$("#itemdescription").val("");
}


