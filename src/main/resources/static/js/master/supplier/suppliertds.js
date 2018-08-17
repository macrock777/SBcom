		

	$(document).on('click','#tds-tab',function(){
		$('.supplieridtxt').html($('#supplierid').val());
		$('.suppliernametxt').html($('#suppliername').val());
		
		$('input[name=isdefaulttds]:checked').each(function(i,val){
			$(this).trigger('change');
		});
		
	});
	 
	 
	var tdscompanytype = $("#tdscompanytype").kendoDropDownList({
		optionLabel: "Select TDS Company Type...",
		filter: "contains",
	    dataTextField: "text",
	    dataValueField: "value",
	    dataSource: [
	        { text: "Others ", value: "Others" },
	        { text: "Company ", value: "Company" },
	        { text: "Individual ", value: "Individual" },
	    ],
	   
	    suggest: true,
	    index: -1,
	}).data("kendoDropDownList");
	
	
	
	
	
	var tdscertificaterequirement   = $("#tdscertificaterequirement").kendoDropDownList({
		placeholder: "Select TDS Certificate...",
	    dataTextField: "text",
	    dataValueField: "value",
	    dataSource: [
	        { text: "Annually ", value: "Annually" },
	        { text: "Monthly ", value: "Monthly" },
	        { text: "Yearly ", value: "Yearly" },
	    ],
	    filter: "contains",
	    suggest: true,
	    index: -1
	}).data("kendoDropDownList");;
	
	//GRID

const tdsgrid = {
	    dataSource: {
	        schema: {
	            model: {
	            	fields: { 
	            		serialno: { type: "string" },
	            		isdefaulttds: { type: "string" },
	            		tdssectionid: { type: "string" },
	            		services: { type: "string" },
	            		effectivetoedit: { type: "string" },
	            		effectivefromedit: { type: "string" },
	            		tdscomptype: { type: "string" },
	            		tdscertireq: { type: "string" },
	            		
                    }
	            }
	        },
	        pageSize: 17
	    },
	    height: 200,
	    scrollable: true,
	    sortable: true,
	    filterable: false,
	    pageable:false,
	    columns: [
	    	{ command: [{name: 'edit', text: '', className: "themeIconColor"}], title: "", width: "30px"},
	    	/*{ command: [{name: 'destroy', text: '', className: "themeIconColor"}], title: "", width: "30px"},*/

	    	{ field: "serialno", title: "SRNO", width: "130px",hidden: true,
	    		
		    	template:function(dataItem){
		    		return "<input type='hidden' name='serialno' value="+kendo.htmlEncode(dataItem.serialno)+">";
		    	}
	    	},
            { field: "isdefaulttds", title: "ISDEFAULTTDS", width: "130px",
			    template:function(dataItem){
			    	
			    	if(dataItem.isdefaulttds=='Y'){
			    		return "<input type='checkbox' class='checkradio' onchange='checkboxFN(this)' checked name='isdefaulttds' id='isdefaulttds'>";
			    	}
			    	else{
			    		return "<input type='checkbox' class='checkradio' onchange='checkboxFN(this)'  name='isdefaulttds' id='isdefaulttds'>";
			    	}
			    }
	    	},
            { field: "tdssectionid", title: "TDSSECTIONID", width: "130px",
	    		 template:function(dataItem){
				    	return "<input type='hidden' name='tdssectionidtxt' value="+kendo.htmlEncode(dataItem.tdssectionid)+">"+dataItem.tdssectionid+"";
	    		 }
	    	},   
            { field: "services", title: "SERVICES", width: "130px",
	    		 template:function(dataItem){
				    	return "<input type='hidden' name='servicestxt' value="+kendo.htmlEncode(dataItem.services)+">"+dataItem.services+"";
	    		 }
	    	},
            { field: "effectivetoedit", title: "EFFECTIVETO", width: "130px",
	    		 template:function(dataItem){
				    	return "<input type='hidden' name='effectivetotxt' value="+kendo.htmlEncode(dataItem.effectivetoedit)+">"+dataItem.effectivetoedit+"";
	    		 }
	    	},
            { field: "effectivefromedit", title: "EFFECTIVEFROM", width: "130px",
            	 template:function(dataItem){
				    	return "<input type='hidden' name='effectivefromtxt' value="+kendo.htmlEncode(dataItem.effectivefromedit)+">"+dataItem.effectivefromedit+"";
	    		 }
	    	},
	    	
	    	 { field: "tdscomptype", title: "TDSCOMPTYPE", width: "130px",
           	 template:function(dataItem){
				    	return "<input type='hidden' name='tdscomptypetxt' value="+kendo.htmlEncode(dataItem.tdscomptype)+">"+dataItem.tdscomptype+"";
	    		 }
	    	},
	    	
	    	 { field: "tdscertireq", title: "TDSCERTI-REQ", width: "130px",
           	 template:function(dataItem){
				    	return "<input type='hidden' name='tdscertireqtxt' value="+kendo.htmlEncode(dataItem.tdscertireq)+">"+dataItem.tdscertireq+"";
	    		 }
	    	},
	    	
        ],
        dataBound: function(e) {
            $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
        }
	};


	

	



	function checkboxFN(thiss){
		
		if($(thiss).prop('checked')){
			$('#tdsbasegrid input[type=checkbox').not(thiss).prop('checked',false);
			var $this = $(thiss);
			rownum =  $($this.closest('tr')).index()+1;
		    var srno = $($this.parents('tr')).find('td:eq(1) input').val();
		    //var tdssecid = $($this.parents('tr')).find('td:eq(2) input').val();
		    var tdssecid = $($this.parents('tr')).find('td:eq(3) input').val();
		    var services = $($this.parents('tr')).find('td:eq(4) input').val();
		    var effectiveto = $($this.parents('tr')).find('td:eq(5) input').val();
		    var effectivefrom = $($this.parents('tr')).find('td:eq(6) input').val();
		    var tdscmptype= $($this.parents('tr')).find('td:eq(7) input').val();
		    var tdscertireq = $($this.parents('tr')).find('td:eq(8) input').val();
		   
		   // $('#tdssrno').val(resp[0].serialno);
			$('#tdsservices').val(services);
			$('#tdscompanytype').data("kendoDropDownList").select(function(dataItem) {
	 		 	   return dataItem.value ==tdscmptype
	     	});
			$('#tdscertificaterequirement').data("kendoDropDownList").select(function(dataItem) {
	 		 	   return dataItem.value == tdscertireq;
	     	});
			
			tdssectionidedit = tdssecid;
				if(null!=effectiveto && null!=effectivefrom && effectiveto!="" && effectivefrom!="" ){
					$('#tdseffdate').val(effectivefrom+" - "+effectiveto).trigger('change');
				} 
			
			
			
		}
	}

function getjsondata(){
	var jsondata={},serialno =[],isdefaulttdstxt = [],
	tdssectionidtxt=[],servicestxt=[],effectivetotxt=[],effectivefromtxt=[],
	tdscomptypetxt=[],tdscertireqtxt=[];
	$('#tdsbasegrid').find('input').each(function(){
		var inputtype =$(this).attr('type');
		if('checkbox' === inputtype){
				values = ($(this).prop('checked')?'Y':'N');
				isdefaulttdstxt.push(values);
		}
		if($(this).attr('name')==='serialno'){
				if($(this).val()==='' || $(this).val()==='undefined' ||  $(this).val()===undefined)
					serialno.push('');
				else
					serialno.push($(this).val());
	    }
		if($(this).attr('name')==='tdssectionidtxt'){
			if($(this).val()==='' || $(this).val()==='undefined' ||  $(this).val()===undefined)
				tdssectionidtxt.push('');
			else
				tdssectionidtxt.push($(this).val());
		}
		if($(this).attr('name')==='servicestxt'){
			if($(this).val()==='' || $(this).val()==='undefined' ||  $(this).val()===undefined)
				servicestxt.push('');
			else
				servicestxt.push($(this).val());
		}
		if($(this).attr('name')==='effectivetotxt'){
			if($(this).val()==='' || $(this).val()==='undefined' ||  $(this).val()===undefined)
				effectivetotxt.push('');
			else
				effectivetotxt.push($(this).val());
		}
		
		if($(this).attr('name')==='effectivefromtxt'){
			if($(this).val()==='' || $(this).val()==='undefined' ||  $(this).val()===undefined)
				effectivefromtxt.push('');
			else
				effectivefromtxt.push($(this).val());
		}
		
		if($(this).attr('name')==='tdscomptypetxt'){
			if($(this).val()==='' || $(this).val()==='undefined' ||  $(this).val()===undefined)
				tdscomptypetxt.push('');
			else{
					if($(this).val()=="Others")
						tdscomptypetxt.push('O');
					else if($(this).val()=="Company")
						tdscomptypetxt.push('C');
					else if($(this).val()=="Individual")
						tdscomptypetxt.push('I');
					else
						tdscomptypetxt.push('');
			}
				
		}
		if($(this).attr('name')==='tdscertireqtxt'){
			if($(this).val()==='' || $(this).val()==='undefined' ||  $(this).val()===undefined)
				tdscertireqtxt.push('');
			else{
					if($(this).val()=="Yearly")
						tdscertireqtxt.push('Y');
					else if($(this).val()=="Monthly")
						tdscertireqtxt.push('M');
					else if($(this).val()=="Annually")
						tdscertireqtxt.push('A');
					else
						tdscertireqtxt.push('');
				}
		}
	});
	
	jsondata['serialno']=serialno;
	jsondata['isdefaulttds']=isdefaulttdstxt;
	jsondata['services']=servicestxt;
	jsondata['tdssectionid']=tdssectionidtxt;
	//jsondata['tdssectionid']=tdssectionidtxt;
	jsondata['effectiveto']=effectivetotxt;
	jsondata['effectivefrom']=effectivefromtxt;
	jsondata['tdscomptype']=tdscomptypetxt;
	jsondata['tdscertireq']=tdscertireqtxt;
	return jsondata;
}

tdsgrid.dataSource.data =[];
$("#tdsbasegrid").kendoGrid(tdsgrid);

$(document).ready(function(){
	setTimeout(() => {
		settdsgrid();
	}, 1000);
});
		
function settdsgrid(){
	

	var supplieridhd  = $('#supplierid').val();
	var suppliernamehd  = $('#suppliername').val();
	
	$('#supplieridhd').val(supplieridhd);
	$('#suppliernamehd').val(suppliernamehd);
 	$('.supplieridtxt').html(supplieridhd);
	$('.suppliernametxt').html(suppliernamehd);
	
	var suppliereditfla =$('#suppliereditflag').val();

	$('#tdseffdate').trigger('change');
	if(null!=supplieridhd && supplieridhd.trim().length>0 && suppliereditfla=="YES"){
		
		 $.ajax({
	         url: "../supplierTDSDetail/gettdsdetail/"+supplieridhd+"",
	         type: 'post',
	         dataType: 'json',
	         contentType: 'application/json',
	      	 data:sessionStorage.getItem('userdetail'),
	         success: function (resp) {
	        	 tdsgrid.dataSource.data = resp; 
	       	     $("#tdsbasegrid").kendoGrid(tdsgrid);
	         },
	     });
		}
	else{
		
	}
}

	/*function getdate(){
		var startDate = $('#tdseffdate').data('daterangepicker').startDate._d;
		var datearray = startDate.toString().split("/");
		var newdate = datearray[1] + '/' + datearray[0] + '/' + datearray[2];
		console.log(newdate);
	}*/
	
		
	function getFormateddate(startDate){
		var datearray = startDate.toString().split("/");
		var newdate = datearray[2].toString().trim()+'-'+datearray[0].toString().trim()+'-'+datearray[1].toString().trim();
		return newdate;
	}
	  
	  
	$('#tdseffdate').on('change',function(){
		var startdate =  $(this).val().split('-')[0];
		var enddate = $(this).val().split('-')[1];
		startdate = getFormateddate(startdate);
		enddate = getFormateddate(enddate);
		
		
		console.log("--->"+startdate);
		console.log("--->"+enddate);
		
		
	 var tdssection = $("#tdssection").kendoDropDownList({
		        optionLabel: "Select TDS Section...",
		        dataTextField: "tdssection",
		        dataValueField: "tdssection",
		        dataSource: {
		        	serverFiltering: true,
		            transport: {
		            	read: {
		            		url: "../supplierTDSDetail/gettdssectiondate/"+startdate+"/"+enddate+"",
		                    type: "POST",
		                    dataType: "json",
		                }
		            }
		         },
		         dataBound: function(e) {
		        	 this.select(function(dataItem) {
		        		 console.log()
		         	     return dataItem.tdssection == tdssectionidedit;
		         	 });
		         },
		         filter: "contains",
		      }).data("kendoDropDownList"); 
});

	
	
	
	
	
	
	
	
	function finalsave(){

		var supplieridhd  = $('#supplieridhd').val();
		var tdsData = getjsondata();
		
	
		tdsData["userdetail"] = JSON.parse(sessionStorage.getItem('userdetail'));
		
		
		swal({
		    title: "Confirm ?",
		    text: "Do you want to save record ?",
		    icon: "http://203.88.135.41:8080/mboss/mudralogin/assets/alert_custom/alert_icon/t-confirm.png",
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
	   	            url: "../supplierTDSDetail/saveTDSdetail/"+supplieridhd+"",
	   	       		type: 'post',
	         		dataType: 'json',
	         		contentType: 'application/json',
	   	         	data: JSON.stringify(tdsData),
	   	            success: function (resp) {
	   	            	
	   	            	if(resp.save=="save"){
	   	            		errorMessage("success","Save Data Successfully...!", "Saved Data");
	   	            	}
	   	            	
	   	            	if(resp['DUPLICATE']!=null || resp['DUPLICATE']!= undefined){
	   	            		errorMessage("success",resp['DUPLICATE'], "Duplicated ..!");	
	   	            	}
	   	           		getgrid();          
	   	            },
	   	        });	  
		    	
		    }
		});
		
		}
	

//SAVE TDS DETAIL	
	
	
	
	var editflag=false
	function addTDSdetail(){
		
		

		var tdsservices = $('#tdsservices').val();
		var tdssection = $('#tdssection').val();
		var tdscomswpanytype = $('#tdscompanytype').val();
		var tdseffdate =$('#tdseffdate').val();
		var tdscertireq = $('#tdscertificaterequirement').val();
		
		if(null==tdsservices || !tdsservices.trim()){
			errorMessage("info"," Please Enter Service...!", "Required Field!");
			return false;
		}
		if(null==tdssection || !tdssection.trim()){
			errorMessage("info"," Please Select TDS Section...!", "Required Field!");
			return false;
		}
		var fromdate = tdseffdate.split('-')[0];
		var todate = tdseffdate.split('-')[1];
		



	
	
	
	if(checkDuplicateData(tdssection)){
		
		 if(null==tdssection || tdssection==='undefined' || tdssection===undefined)
			 tdssection='';
		 if(null==tdsservices || tdsservices==='undefined' || tdsservices===undefined)
			 tdsservices='';
		 if(null==fromdate || fromdate==='undefined' || fromdate===undefined)
			 fromdate='';
		 if(null==todate || todate==='undefined' || todate===undefined)
			 todate='';
		 if(null==tdscomswpanytype || tdscomswpanytype==='undefined' || tdscomswpanytype===undefined)
			 tdscomswpanytype='';
		 if(null==tdscertireq || tdscertireq==='undefined' || tdscertireq===undefined)
			 tdscertireq='';
		 
		 if(rownum==0 && editflag==false){
			var tdsbasegrid = $('#tdsbasegrid').data("kendoGrid");
			tdsbasegrid.dataSource.add({
				 tdssectionid:tdssection,
				 services:tdsservices,
				 effectivefromedit:fromdate,
				 effectivetoedit:todate,
				 tdscomptype:tdscomswpanytype,
				 tdscertireq:tdscertireq,
			});
		 }
		 else{
			 $("#tdsbasegrid tr:eq("+rownum+") td:eq(3)").html("<input type='hidden' name='tdssectionidtxt' value="+tdssection+">"+tdssection);
			 $("#tdsbasegrid tr:eq("+rownum+") td:eq(4)").html("<input type='hidden' name='servicestxt' value='"+tdsservices+"'>"+tdsservices);
			 $("#tdsbasegrid tr:eq("+rownum+") td:eq(5)").html("<input type='hidden' name='effectivetotxt' value='"+todate+"'>"+todate);
			 $("#tdsbasegrid tr:eq("+rownum+") td:eq(6)").html("<input type='hidden' name='effectivefromtxt' value='"+fromdate+"'>"+fromdate);
			 $("#tdsbasegrid tr:eq("+rownum+") td:eq(7)").html("<input type='hidden' name='tdscomptypetxt' value='"+tdscomswpanytype+"'>"+tdscomswpanytype);
			 $("#tdsbasegrid tr:eq("+rownum+") td:eq(8)").html("<input type='hidden' name='tdscertireqtxt' value='"+tdscertireq+"'>"+tdscertireq);
		 }
		 editflag=false;
		 rownum=0;
	}
}	
	 
	
	function checkDuplicateData(tdssection){
		var flag =true;
	$('input[name=tdssectionidtxt]').each(function(i,val){
			console.log(i);
			if($(val).val()===tdssection &&  editflag==false){
				errorMessage("error","TDS Section Already Exist...!", "Duplicate..!");
				flag=false;
				return false;
			}
			
			if($(val).val()===tdssection &&  editflag==true && (i+1)!=rownum){
					errorMessage("error","TDS Section Already Exist...!", "Duplicate..!");
					flag=false;
				return false;
			}
			
		 });
		return flag;
	}
		
		
		

		
	function getgrid(){
		var supplieridhd  = $('#supplieridhd').val();
			$.ajax({
   	            url: "../supplierTDSDetail/gettdsdetail/"+supplieridhd+"",
   	       		type: 'post',
         		dataType: 'json',
         		contentType: 'application/json',
   	         	data: sessionStorage.getItem('userdetail'),
   	            success: function (resp) {
   	           tdsgrid.dataSource.data = resp; 
	   	     	  $("#tdsbasegrid").kendoGrid(tdsgrid);
   	            },
   	        });	  
	 }
		
	var rownum=0;
		
	  $(document).on('click','#tdsbasegrid a.k-button-icontext.themeIconColor.k-grid-edit',function(){	
		  
			var $this = $(this);
			rownum =  $($this.closest('tr')).index()+1;
		    var srno = $($this.parents('tr')).find('td:eq(1) input').val();
		    //var tdssecid = $($this.parents('tr')).find('td:eq(2) input').val();
		    var tdssecid = $($this.parents('tr')).find('td:eq(3) input').val();
		    var services = $($this.parents('tr')).find('td:eq(4) input').val();
		    var effectiveto = $($this.parents('tr')).find('td:eq(5) input').val();
		    var effectivefrom = $($this.parents('tr')).find('td:eq(6) input').val();
		    var tdscmptype= $($this.parents('tr')).find('td:eq(7) input').val();
		    var tdscertireq = $($this.parents('tr')).find('td:eq(8) input').val();
		   
		   
		    
		   // $('#tdssrno').val(resp[0].serialno);
			$('#tdsservices').val(services);
			$('#tdscompanytype').data("kendoDropDownList").select(function(dataItem) {
	 		 	   return dataItem.value ==tdscmptype
	     	});
			$('#tdscertificaterequirement').data("kendoDropDownList").select(function(dataItem) {
	 		 	   return dataItem.value == tdscertireq;
	     	});
			
			tdssectionidedit = tdssecid;
				if(null!=effectiveto && null!=effectivefrom && effectiveto!="" && effectivefrom!="" ){
					$('#tdseffdate').val(effectivefrom+" - "+effectiveto).trigger('change');
				} 
				editflag=true;
		});
	  var tdssectionidedit;
	   function settdsdata1(resp){
			$('#tdssrno').val(resp[0].serialno);
			$('#tdsservices').val(resp[0].services);
			$('#tdscompanytype').data("kendoDropDownList").select(function(dataItem) {
	 		 	   return dataItem.value == resp[0].tdscompanytype;
	     	});
			$('#tdscertificaterequirement').data("kendoDropDownList").select(function(dataItem) {
	 		 	   return dataItem.value == resp[0].tdscertificaterequirement;
	     	});
			
			tdssectionidedit = resp[0].tdssectionid
				if(null!=resp[0].effectivetoedit && null!=resp[0].effectivefromedit && resp[0].effectivetoedit!="" && resp[0].effectivefromedit!="" ){
					$('#tdseffdate').val(resp[0].effectivetoedit+" - "+resp[0].effectivefromedit).trigger('change');
				}
			}
	   
	   
	   
	   function settdsdata(resp){
			$('#tdssrno').val(resp[0].serialno);
			$('#tdsservices').val(resp[0].services);
			$('#tdscompanytype').data("kendoDropDownList").select(function(dataItem) {
	 		 	   return dataItem.value == resp[0].tdscompanytype;
	     	});
			$('#tdscertificaterequirement').data("kendoDropDownList").select(function(dataItem) {
	 		 	   return dataItem.value == resp[0].tdscertificaterequirement;
	     	});
			
			tdssectionidedit = resp[0].tdssectionid
				if(null!=resp[0].effectivetoedit && null!=resp[0].effectivefromedit && resp[0].effectivetoedit!="" && resp[0].effectivefromedit!="" ){
					$('#tdseffdate').val(resp[0].effectivetoedit+" - "+resp[0].effectivefromedit).trigger('change');
				}
			}
	   
	   
	   $(document).on('click','#tdsbasegrid a.k-button-icontext.themeIconColor.k-grid-delete',function(){	
			var $this = $(this);
			$this.closest('tr').remove();
	   });

	   
	   