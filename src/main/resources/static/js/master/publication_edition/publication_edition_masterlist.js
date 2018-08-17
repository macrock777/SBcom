var serverurl = null;
var before_form_count = 0;
var uniqueid = null;
var iseditItem = null;
const ajaxUrl = serverurlCommon + '/mudrabizcomps/datafromtable';
var details = JSON.parse(sessionStorage.getItem('userdetail'));
var serverurlCommon = '';

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

const publicationgriddata = {
    dataSource: {
        schema: {
            model: {
                fields: {
                	publicationgroupid : { type: "string" },
                	publicationgroupname : { type: "string" },
                	publicationid : { type: "string" },
                	publicationname : { type: "string" },
                	editionname: { type: "string" },
                	isactive: { type: "string" },
                }
            }
        },
        pageSize: 20
    },               
    toolbar: [{name: 'excel', text: 'Export', className: "themeColor"}],               
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
        { field: "publicationgroupid", title: "Publicationgroup ID", width: "130px" },
        { field: "publicationgroupname", title: "Publication Group Name", width: "130px" },
        { field: "publicationid", title: "Publication Id", width: "130px" },
        { field: "publicationname", title: "Publicationn Name", width: "130px" },
        { field: "editionname", title: "Edition Name", width: "130px" },
        { field: "isactive", title: "Is Active", attributes:{class:"text-right"}, width: "130px" },
    ],
    dataBound: function(e) {
        $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
    }
}; 


const suppliergroupdata = {
	"tablenames" : "MUDRA.suppliergroupmaster",
	"columnnames" : "suppliergroupid,suppliergroupname",
	"whereclause" : " 1 = 1 and jobtypeid = 101000 and uniqueid =" + uniqueid
			+ " ORDER BY suppliergroupname "
};


$(document).ready(function() {
	$('.collapse').on("hidden.bs.collapse", function(){resizeGrid(400,301.9);});// .fadeIn("slow");
    $('.collapse').on("shown.bs.collapse", function(){resizeGrid(200,101.9);});// .fadeIn("fast");
	
    getSessionData();
    // getSessionValue();
    getUniqueid();
    publicationgriddata.dataSource['data'] = []; 
	$("#publicationgrid").kendoGrid(publicationgriddata);
    
});


function resizeGrid(a,b) {
    var gridElement = $("#grid");
    var dataArea = gridElement.find(".k-grid-content");
    gridElement.height(a);
    dataArea.height(b);
}

function getUniqueid() {
	var details = JSON.parse(sessionStorage.getItem('userdetail'))
	if (null != details && undefined != details) {
		uniqueid = details.uniqueid;
	}
	fillcombo();
}

function fillcombo() {
	
	$("#isactive").kendoComboBox({
        dataTextField: "text",
        dataValueField: "value",
        dataSource: [
            { text: "Active", value: "Y" },
            { text: "In-Active", value: "N" }
            
        ],
        filter: "contains",
        suggest: true,
        index: -1
    });
	
	const suppliergroupdata = {
		"tablenames" : "MUDRA.suppliergroupmaster",
		"columnnames" : "suppliergroupid,suppliergroupname",
		"whereclause" : " jobtypeid = 101000 and uniqueid =" + uniqueid
				+ " ORDER BY suppliergroupname "
	};
	if(uniqueid != null || uniqueid !="" || uniqueid != undefined){
		commonComboFunc(ajaxUrl, suppliergroupdata, "suppliergroup","Select Supplier Group...", "suppliergroupid", "suppliergroupname");
	}
	
	const publicationdata = {
		"tablenames" : "mudra.suppliermaster",
		"columnnames" : "SUPPLIERID,SUPPLIERNAME",
		"whereclause" : " jobtypeid=101000 and suppliertype = 'PUBLICATION' and uniqueid="+uniqueid+"  ORDER BY SUPPLIERNAME "
	};
	if(uniqueid != null || uniqueid !="" || uniqueid != undefined){
		commonComboFunc(ajaxUrl, publicationdata, "publication","Select Publication...", "supplierid", "suppliername");
	}
	
	const editiondata = {
			"tablenames" : "mudra.editionmaster",
			"columnnames" : "editionid,editionname",
			"whereclause" : " uniqueid = "+uniqueid +" ORDER BY editionname "
	};
	if(uniqueid != null || uniqueid !="" || uniqueid != undefined){
		commonComboFunc(ajaxUrl, editiondata, "edition","Select Edition...", "editionid", "editionname");
	}
	
	const languagedata = {
			"tablenames" : "mudra.generalmaster",
			"columnnames" : "distinct mastercode,masterdescription",
			"whereclause" : " mastertype like 'LANG%' ORDER BY masterdescription "
	};
	commonComboFunc(ajaxUrl, languagedata, "language","Select Language...", "mastercode", "masterdescription");
}

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



function searchFn() {
	var publicationSearchBean = {};
	var suppliergroup = $("#suppliergroup").val();
	var publication = $("#publication").val();
	var edition = $("#edition").val();
	var language = $("#language").val();
	var isactive = $("#isactive").val();
	
	
	publicationSearchBean['uniqueid'] = uniqueid;
	publicationSearchBean['suppliergroup'] = suppliergroup;
	publicationSearchBean['publication'] = publication;
	publicationSearchBean['edition'] = edition;
	publicationSearchBean['language'] = language;
	publicationSearchBean['isactive'] = isactive;
	
	$.ajax({
	    url: "../publication_editionmaster/publicationsearchlist",
	    type: 'POST',
	    dataType: 'json',
	    data:JSON.stringify(publicationSearchBean),
	    contentType: 'application/json',
	    success: function (resp) {
	    	
	    	$("#publicationgrid").data("kendoGrid").destroy();
	    	publicationgriddata.dataSource['data'] = resp; 
	    	$("#publicationgrid").kendoGrid(publicationgriddata);
	    	$( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
	    },
	});
}


$(document).on('click','#publicationgrid a.k-button-icontext.themeIconColor.k-grid-edit',function(){
	var row = $(this).closest("tr");
	var grid = $("#publicationgrid").data("kendoGrid");
	var dataItem = grid.dataItem(row);
	var supplierid = dataItem.publicationid;
	var suppliername = dataItem.publicationname;
	if((uniqueid != null || uniqueid != '' || uniqueid !=undefined ) && (supplierid != null || supplierid != '' || supplierid !=undefined ))
	{
		$('#supplierid').val(supplierid);
		$('#suppliername').val(suppliername);
		document.publicationeditionform.method="post";
		document.publicationeditionform.action="addpublicationEdition";
		document.publicationeditionform.submit();
	}
});

/*$("#suppliergroup").kendoComboBox({
	dataTextField : "text",
	dataValueField : "value",
	dataSource : [ {
		text : "Sandesh - Ahm",
		value : "1"
	}, {
		text : "Sandesh - Baroda",
		value : "2"
	} ],
	filter : "contains",
	suggest : true,
	index : -1
});*/