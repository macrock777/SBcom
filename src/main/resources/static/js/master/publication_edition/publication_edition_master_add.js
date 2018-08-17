var serverurl = null;
var before_form_count = 0;
var uniqueid = null;
var iseditItem = null;
const ajaxUrl = serverurlCommon + '/mudrabizcomps/datafromtable';
var details = JSON.parse(sessionStorage.getItem('userdetail'));
var serverurlCommon = '';
var edituid = null;
var editionid = null;
var maxeditionid = null;
var is_record_edit = false;

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

const editiongriddata = {
	    dataSource: {
	        schema: {
	            model: {
	                fields: {
	                	"editionid" : { type: "string" },
	                	"editionname": { type: "string" },
	                	"editiondisplayname": { type: "string" },
	                	"supplierid": { type: "string" },
	                    "editioncity": { type: "string" },
	                    "editionstate": { type: "string" },
	                    "language": { type: "string" },
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
	        { field: "editionid", title: "editionid", width: "130px" },
	        { field: "editionname", title: "editionname", width: "130px" },
	        { field: "editiondisplayname", title: "editiondisplayname", width: "130px" },
	        { field: "supplierid", title: "publicationid", width: "130px" },
	        { field: "editioncity", title: "editioncity", width: "200px" },
	        { field: "editionstate", title: "editionstate", width: "200px" },
	        { field: "language", title: "language", width: "130px" }
	    ],
	    dataBound: function(e) {
	        $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
	    }
	};

$(document).ready(function() {   
	editiongriddata.dataSource['data'] = []; 
    $("#editiongrid").kendoGrid(editiongriddata);
	$('#editiongrid div.k-header.k-grid-toolbar a.k-button.k-button-icontext.k-grid-add').on('click',function(){
		resetAllField();
		edituid = null;
		editionid = null;
	    $('#addeditionmaster').modal('show');
	});
	//editiongriddata.dataSource['data'] = []; 
	//$("#editiongrid").kendoGrid(editiongriddata);
	getSessionData();
    getUniqueid();
    
    const languagedata = {
			"tablenames" : "mudra.generalmaster",
			"columnnames" : "distinct mastercode,masterdescription",
			"whereclause" : " mastertype like 'LANG%' ORDER BY masterdescription "
	};
	commonComboFunc(ajaxUrl, languagedata, "language","Select Language...", "mastercode", "masterdescription");
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


function getSessionValue(){
	var details = JSON.parse(sessionStorage.getItem('userdetail'));
	if(null!=details && undefined!=details){
		serverurl = details.serverurl;
	}
	
}

function resizeGrid(a,b) {
    var gridElement = $("#editiongrid");
    var dataArea = gridElement.find(".k-grid-content");
    gridElement.height(a);
    dataArea.height(b);
}

function getUniqueid() {
	var details = JSON.parse(sessionStorage.getItem('userdetail'))
	if (null != details && undefined != details) {
		uniqueid = details.uniqueid;
	}
	fillgriddata();
}


function fillgriddata()
{
	var supplieridhd = $("#supplieridhd").val();
	$.ajax({
	    url: "../publication_editionmaster/editionsearchlist",
	    type: 'POST',
	    dataType: 'json',
	    data:{supplieridhd:supplieridhd,uniqueid:uniqueid},
	    success: function (resp) {
	    	$("#editiongrid").data("kendoGrid").destroy();
	    	editiongriddata.dataSource['data'] = resp; 
	    	$("#editiongrid").kendoGrid(editiongriddata);
	    	$( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
	    },
	});
};



function resetAllField()
{
	var supplieridhd = $("#supplieridhd").val().trim()
	var supname = $("#supname").html().trim();
	$("#addeditionmaster").find('input').each(function(){
		$(this).val("");
	});
	$('#isactive').prop('checked',true);
	$('#language').data("kendoDropDownList").select(function(dataItem) {
	    return dataItem.mastercode == 0;
	});
	
	$("#supplierid").val(supplieridhd);
	$("#paytosupplierid").val(supplieridhd);
	$("#paytopubname").val(supname);
	
};


function isValidEditionDetails()
{
	var editionname = $("#editionname").val().trim();
	var editiondisplayname = $("#editiondisplayname").val().trim();
	
	if(checkIfNull(editionname))
	{
		errorMessage("info", "Please Enter Edition Name.", "Required Filed..!");
		$("#editionname").focus();
		return false;
	}
	else if(checkIfNull(editiondisplayname))
	{
		errorMessage("info", "Please Enter Edition Display Name.", "Required Filed..!");
		$("#editiondisplayname").focus();
		return false;
	}
	return true;
}

function saveDatatoGrid()
{
	if(isValidEditionDetails())
	{
		if(maxeditionid == null || maxeditionid =='')
		{
			$.ajax({
	    		url: '../publication_editionmaster/getmaxeditionid',
		        type: 'post',
		        dataType: 'json',
		        data: {uniqueid:uniqueid},
		        success: function (resp) {
		        	maxeditionid =resp['maxnumber'];
		        	addtogrid();
		        	maxeditionid++;
		        },
			});
		}
		else
		{
			maxeditionid++;
			addtogrid();
			
		}
		
		is_record_edit = true;
		$("#addeditionmaster").modal("hide");
	}
};

function addtogrid()
{
	var Editiondata = {};
	
	$("#addeditionmaster").find('input').each(function(){
		var inputtype = $(this).attr('type');
		var ids = 'none';
		var values = 'none';
		ids = $(this).attr('id');
		
		if('checkbox' === inputtype){
			values = ($(this).prop('checked')?'Y':'N');
		}else{
			values = $(this).val();
		}
		Editiondata[ids] = values;
	});

	var editiongrid_data_add = {};
	
	$('#addeditionmaster').find('input').each(function(i,dataa){
		editiongrid_data_add[$(dataa).attr('id')] = $(dataa).val();
	});
	if((editionid== null || editionid == "") && maxeditionid != null){
		editiongrid_data_add['editionid'] = maxeditionid;
	}
	
	var editiongrid_data = $('#editiongrid').data("kendoGrid");

	if(editionid == null && edituid == null)
	{
		editiongrid_data.dataSource.add(editiongrid_data_add);
	}
	else if(edituid != null && editionid==null)
	{
		$(editiongrid_data.dataSource._data).each(function(i,datata){
			if(datata.uid == edituid){
				var dataItem = editiongrid_data._data[i];
				$('#addeditionmaster').find('input').each(function(j,dataa){
					editiongrid_data._data[i][$(dataa).attr('id')] = $(dataa).val();	 
				});					
				editiongrid_data.refresh();
			}
		});
	}
}

$(document).on('click','#editiongrid a.k-button-icontext.themeIconColor.k-grid-edit',function(){
	var row = $(this).closest("tr");
	var grid=$("#editiongrid").data("kendoGrid");
	var dataItem=grid.dataItem(row);
	editionid = dataItem.editionid; 
	edituid = dataItem.uid;
	var languageID = dataItem.language;
	var isActiveStr = dataItem.isactive;
	$('#addeditionmaster').find('input').each(function(i,dataa){
		var id =$(dataa).attr('id');	 
		var val =$(dataa).val(dataItem[''+$(dataa).attr('id')+'']);
	});
	$("#paytopubname").val($("#supname").html().trim());
	$('#addeditionmaster').modal('show');
	$('#language').data("kendoDropDownList").select(function(dataItem) {
	    return dataItem.mastercode == languageID;
	});
	
	if(isActiveStr=='Y')
		$('#isactive').prop('checked',true);
	else if(isActiveStr=='N')
		$('#isactive').prop('checked',false);
	else 
		$('#isactive').prop('checked',false);
});



function backtoGrid()
{
	document.editionform.method="post";
	document.editionform.action="../publication_editionmaster/";
	document.editionform.submit();
}

function decMaxeditionid()
{
	if(maxeditionid != null && is_record_edit==true)
	{
		maxeditionid--;
		is_record_edit = false;
	}
}


function inputtext(obj){
	obj.value=obj.value.replace(/[^a-z A-Z0-9\n,.-]/,'');
}

function inputint(obj){
	obj.value=obj.value.replace(/[^0-9]/g,'');
}

function inputchar(obj){
	obj.value=obj.value.replace(/[^a-z A-Z]/,'');
}

function checkIfNull(value)
{
	if(value == null || value == "" || value == undefined)
		return true;
	return false;
}