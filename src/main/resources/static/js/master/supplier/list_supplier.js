
var details = JSON.parse(sessionStorage.getItem('userdetail'));
var serverurlCommon = '';
if(null!=details && undefined!=details){
	var serverurl = details.serverurl;
	if(null!=serverurl && serverurl.trim())
		serverurlCommon = serverurl;
}


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
	
	
	function addSupplierFn(){
		document.mainForm.method = 'POST';
		document.mainForm.action = '../suppliermaster/addsuppliermaster';
		document.mainForm.submit();
	}
	
	$(document).bind("DOMSubtreeModified", function(){
		$('.k-select').addClass('themeColor');
	});
	
	

	$(document).ready(function() {        	
	 function resizeGrid(a,b) {
	    var gridElement = $("#grid");
	    var dataArea = gridElement.find(".k-grid-content");
	  
	    gridElement.height(a);
	    dataArea.height(b);
	 }

	 $('.collapse').on("hidden.bs.collapse", function(){resizeGrid(400,301.9);});//.fadeIn( "slow" );
	 $('.collapse').on("shown.bs.collapse", function(){resizeGrid(200,101.9);});//.fadeIn( "fast" );                

	});


//JS

	function addSupplierFn(){
		document.mainForm.method = 'POST';
		document.mainForm.action = '../suppliermaster/addsuppliermaster';
		document.mainForm.submit();
	}

	$(document).ready(function(){
		setcombo();
		options.dataSource['data'] = []; 
    	$("#suppliergrid").kendoGrid(options);
	});


	function setcombo(){
		var details = JSON.parse(sessionStorage.getItem('userdetail'));
		var uniqueid = details.uniqueid;
		var divisionid = details.divisionid;
		var companyid = details.companyid;
		var loginid = details.loginid;
		
		var status = $("#status").kendoDropDownList({
			optionLabel: "Status...",
		    dataTextField: "text",
		    dataValueField: "value",
		    filter: "contains",
		    dataSource: [
		        { text: "Active", value: "Y" },
		        { text: "In-Active", value: "N" },
		    ],
		});


	   var suppliertype = $("#suppliertype").kendoDropDownList({
	       optionLabel: "Select Supplier Type...",
	       dataTextField: "mastercode",
	       dataValueField: "mastercode",
	       filter: "contains",
	       dataSource: {
	           transport: {
	           	read: {
	           		url: "../suppliermaster/getsuppliertype",
	                   type: "POST",
	                   dataType: "json",
	               }
	           }
	        },
	        
	     }).data("kendoDropDownList").list.width(400);

	   
		  var suppliergrp = $("#suppliergrp").kendoDropDownList({
			       optionLabel: "Select Supplier Group...",
			       dataTextField: "suppliergroupname",
			       dataValueField: "suppliergroupid",
			       filter: "contains",
			       dataSource: {
			           transport: {
			           	read: {
			           		url: serverurlCommon+"/mudrabizcomps/suppliergroups/"+uniqueid+"",
			                   dataType: "json",
			                	beforeSend: function(req) {
								 req.setRequestHeader('userid', "6543210");
								req.setRequestHeader('token', '1234abcd-5678efgh-1234abcd-5678efgh');
			                 }   
			               }
			           }
			        },
			     }).data("kendoDropDownList").list.width(400);;
		  var str ="NA";
		  	$("#supplierid").kendoDropDownList({
				optionLabel: "Select Supplier Name...",
			    dataTextField: "suppliername",
			    dataValueField: "supplierid",
			    filter: "contains",
			    dataSource: {
		            transport: {
		            	read: {
		            		url: "../suppliermaster/getsupplierlist/"+uniqueid+"/"+str+"",
		                    type: "POST",
		                    dataType: "json",
		                }
		            }
		         },
		  	 }).data("kendoDropDownList").list.width(400);;
		  	
		  	$('#suppliergrp').on('change',function(){
		  		var supplier = $("#supplierid").kendoDropDownList({
			        optionLabel: "Select Supplier Name...",
			        dataTextField: "suppliername",
			        dataValueField: "supplierid",
			        filter: "contains",
			        dataSource: {
			            transport: {
			            	read: {
			            		url: "../suppliermaster/getsupplierlist/"+uniqueid+"/"+$("#suppliergrp").val()+"",
			                    type: "POST",
			                    dataType: "json",
			                }
			            }
			         },
			      }).data("kendoDropDownList").list.width(400);;;
		  	});

		
	
  }



	/*$(document).on('change','#supplierpan',function(){
		var panreg = /^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
			if(!(panreg.test($(this).val()))){
				$(this).val('').focus();
					errorMessage("Info", "Please Enter Valid PAN No", "Required Filed..!");
			}
	});*/

	function toUpperCaseFn(thiss){
		thiss.value = ((null!=thiss.value&&thiss.value.trim())?thiss.value.toUpperCase():'');	  
	}

	function searchFn(){
		var searchData = {};
		var userdetail = JSON.parse(sessionStorage.getItem('userdetail'));
		var uniqueid = userdetail.uniqueid;	
		var supplierid = $("#supplierid").val();
		var suppliergrp = $('#suppliergrp').val();
		var branchid = $('#branchid').val();
		var suppliertype = $('#suppliertype').val();
		var status = $('#status').val();
		var pannumber = $('#supplierpan').val();
		if(null!=supplierid && supplierid.trim().length>0){
			searchData['supplierid'] = supplierid;
		}
		if(null!=suppliergrp && suppliergrp.trim().length>0){
			searchData['suppliergrp'] = suppliergrp;
		}
		
		if(null!=branchid && branchid.trim()){
			searchData['branchid'] = branchid;
		}
		
		if(null!=suppliertype && suppliertype.trim().length>0){
			searchData['suppliertype'] = suppliertype;
		}
		
		
		if(null!=status && status.trim().length>0){
			searchData['status'] = status;
		}
		
		if(null!=pannumber && pannumber.trim().length>0){
			searchData['pannumber'] = pannumber;
		}
		
		if(null!=userdetail && undefined!=userdetail){
			var uniqueid = userdetail.uniqueid;
			searchData['uniqueid'] = uniqueid;
		}
		/*
		if((null==supplierid || supplierid=="") && (null==suppliergrp || suppliergrp=="") && (null==suppliertype || suppliertype=="") && ( null==pannumber || pannumber == "")){
			errorMessage("warning", "Please Select At Least One Searching Combo", "Required Field..!");
			return false;
		}*/
	
		$.ajax({
		    url: "../suppliermaster/getsupplierlist",
		    type: 'POST',
		    dataType: 'json',
		    data:JSON.stringify(searchData),
		    contentType: 'application/json',
		    success: function (resp) {
		    	$("#suppliergrid").data("kendoGrid").destroy();
		    	options.dataSource['data'] = resp; 
		    	$("#suppliergrid").kendoGrid(options);
		    	$( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
		    },
		});
	}

	const options = {
		    dataSource: {
		        schema: {
		            model: {
		                fields: {
		                	"suppliergroupid" : { type: "string" },
		                	"supplierid": { type: "string" },
		                	"suppliername": { type: "string" },
		                	"pannumber": { type: "string" },
		                    "gvt": { type: "string" },
		                    "glcode": { type: "string" },
		                    "suppliertype": { type: "string" },
		                    "isactive": { type: "string" },
		                   /* "uniqueid" : { type: "string" },*/
		                	"branchname" : { type: "string" },
		                }
		            }
		        },
		        pageSize: 17
		    },
		    toolbar: [{name: 'create', text: 'Create', className: "themeColor"},
		    	{name: 'excel', text: 'Export',className:'themeColor'}],
		    height: 350,
		    scrollable: true,
		    sortable: true,
		    filterable: false,
		    pageable: {
		        input: true,
		        numeric: true
		    },
		    columns: [
		    	{ command: [{name: 'edit', text: '', className: "themeIconColor"}], title: "&nbsp;"},
		    	{ field: "suppliergroupid", title: "Suppliergrp ID", width: "120px" },
		    	{ field: "supplierid", title: "SupplierId", width: "auto" },
		    	{ field: "suppliername", title: "Supplier Name", width: "120px" },
		    	{ field: "pannumber", title: "Pannumber", width: "auto" },
		        { field: "gvt", title: "Gst Vender Type", width: "150px" },
		        { field: "glcode", title: "GLCode", width: "180px" },
		        { field: "suppliertype", title: "Supplier Type", width: "auto" },
		        { field: "isactive", title: "Active", width: "100px" },
		       /* { field: "uniqueid", title: "Uniqueid", width: "150px" },*/
		    	{ field: "branchname", title: "Branch Name", width: "auto" },
		    ],
        dataBound: function(e) {
            $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
        }
		};

	
	$(document).on('click','#suppliergrid a.k-button.k-button-icontext.themeColor.k-grid-add',function(){
		addClientFn();
	});

	$(document).on('click','a.k-button-icontext.k-grid-edit',function(){
		var $this = $(this);
	    var supplieridhd = $($this.parents('tr')).find('td:nth-child(3)').text();
	    if(null!=supplieridhd && supplieridhd.trim()){
	    	$('#supplieridhd').val(supplieridhd);
	    	$('#suppliereditflag').val('YES');
	    	addClientFn();
	    }
	});
	
	function addClientFn(){
		document.mainForm.method = 'POST';
		document.mainForm.action = '../suppliermaster/addsuppliermaster';
		document.mainForm.submit();
	}

	
	 function errorMessage(toastrType,message,title){	
		 switch(toastrType.toLowerCase()){
		 case "info":
				//toastr.info(message, title);
				swal({ title: title,   text: message, icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-warning.png", buttons: {   confirm: { className: "themeColor"}} });
			break;
			case "success":
				//toastr.success(message, title);
				swal({   title: title,   text: message,   icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-success.png", buttons: {   confirm: { className: "themeColor"}} });
			break;
			case "error":
				//toastr.error(message, title);
				swal({ title: title,   text: message,  icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-remove.png", buttons: {   confirm: { className: "themeColor"}} });
			break;
			case "warning":
				//toastr.warning(message, title);
				swal({ title: title,   text: message, icon: serverurlCommon+"/mudralogin/assets/alert_custom/alert_icon/t-warning.png", buttons: {   confirm: { className: "themeColor"}} });
			break;               				
		 }
	 }	  	    	                			
	   	                		

	