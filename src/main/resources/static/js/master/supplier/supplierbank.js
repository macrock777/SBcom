var isEditabelBankDetail =false;
var isNewSupplierBankDetails = true;
/**/



$(document).ready(function(){
		 var details = JSON.parse(sessionStorage.getItem('userdetail'));
	     var uniqueid = details.uniqueid;
	     var loginid = details.loginid;
	$.getJSON( "../getifsupplierbankdetailiseditable/"+loginid+"", function(resp) {
   		if(resp!=null){
   			if(resp['editable']=='Yes'){
   				bankaddflag = true;
   			}
   			
   		 if(bankaddflag==true){
			  	$("#beneficiaryname").val("").prop("disabled",false);
					$("#accountnumber").val("").prop("disabled",false);
					$("#ifsccode").val("").prop("disabled",false);
					$("#bankname").val("").prop("disabled",false);
					$("#branchname").val("").prop("disabled",false);
					$("#benedescription").val("").prop("disabled",false);
		  }
		  
   		}
   	});
});

	



 
 			 // BANK INFO
 			 
 			 	var details = JSON.parse(sessionStorage.getItem('userdetail'));
 			    var uniqueid = details.uniqueid;
 			    var supplierid = $('#supplieridhd').val()
 			 
             const bankdata = {
        			 dataSource: {
        			             schema: {
        			                 model: {
        			                     fields: {
        			                    	 beneficiaryname: { type: "string" },
        			                    	 accountnumber: { type: "string" },
        			                    	 ifsccode: { type: "string" },
        			                    	 bankname: { type: "string" },
        			                    	 branchname: { type: "string" },
        			                    	 benedescription: { type: "string" },
        			                     }
        			                 }
        			             },
        			             pageSize: 17
        			         },
        			         
        			         autoBind: true,
        			         scrollable: true,
        			         sortable: true,
        			         filterable: false,
        			         pageable: false,
        			         columns: [
        			        	/* { command: [{name: 'edit', text: '', className: "themeIconColor"}], title: "&nbsp;"},*/
        			        	 { field: "beneficiaryname", title: "Beneficiary Name", width: "130px" },
                                 { field: "accountnumber", title: "Account Number", attributes:{style:"text-align:left;"}, width: "130px" },
                                 { field: "ifsccode", title: "IFSC Code", width: "130px" },
                                 { field: "bankname", title: "Beneficiary Bank Name", attributes:{style:"text-align:left;"}, width: "130px"},
                                 { field: "branchname", title: "Bank Branch Name", attributes:{style:"text-align:left;"}, width: "130px" },
                                 { field: "benedescription", title: "Beneficiary Description", attributes:{style:"text-align:left;"}, width: "130px" },
        			         ] ,
                             dataBound: function(e) {
                                 $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
                             }
        			 };
		 
             
 			  
 			    var bankaddflag =false;
             
    	         function getSupplierBackDetail(){
	
						$.getJSON( "../getifsupplierbankdetailiseditable/"+loginid+"", function(resp) {
						   		if(resp!=null){
						   			if(resp['editable']=='Yes'){
						   				bankaddflag = true;
						   			}
						   		}
						   	});
						
    	        	 if(null!=supplierid && supplierid.trim().length>0){
    	        		 var details = JSON.parse(sessionStorage.getItem('userdetail'));
    	 			     var uniqueid = details.uniqueid;
    	 			     var loginid = details.loginid;

    	            	 	$.getJSON( "../getsupplierbankdetails/"+supplierid+"/"+uniqueid+"", function(resp) {
    	            		  bankdata.dataSource.data = resp;
    	             		  $("#bankgrid").kendoGrid(bankdata);
    	             		 
    	             		  
    	             		  if(null!=resp && resp.length>0){
	    	             		  if(bankaddflag==true){
	    	             			  	$("#beneficiaryname").val(resp[0].beneficiaryname).prop("disabled",false);
			   	     					$("#accountnumber").val(resp[0].accountnumber).prop("disabled",false);
			   	     					$("#ifsccode").val(resp[0].ifsccode).prop("disabled",false);
			   	     					$("#bankname").val(resp[0].bankname).prop("disabled",false);
			   	     					$("#branchname").val(resp[0].branchname).prop("disabled",false);
			   	     					$("#benedescription").val(resp[0].benedescription).prop("disabled",false);
	    	             		  }
	    	             		  else{
	    	             			  	$("#beneficiaryname").val(resp[0].beneficiaryname).prop("disabled",true);
	 		   	     					$("#accountnumber").val(resp[0].accountnumber).prop("disabled",true);
	 		   	     					$("#ifsccode").val(resp[0].ifsccode).prop("disabled",true);
	 		   	     					$("#bankname").val(resp[0].bankname).prop("disabled",true);
	 		   	     					$("#branchname").val(resp[0].branchname).prop("disabled",true);
	 		   	     					$("#benedescription").val(resp[0].benedescription).prop("disabled",true);
	    	             		  }
    	             		  }
    	             		  else{
    	             			 if(bankaddflag==true){
	    	             			  	$("#beneficiaryname").val("").prop("disabled",false);
			   	     					$("#accountnumber").val("").prop("disabled",false);
			   	     					$("#ifsccode").val("").prop("disabled",false);
			   	     					$("#bankname").val("").prop("disabled",false);
			   	     					$("#branchname").val("").prop("disabled",false);
			   	     					$("#benedescription").val("").prop("disabled",false);
	    	             		  }
	    	             		  else{
	    	             			  	$("#beneficiaryname").val("").prop("disabled",true);
	 		   	     					$("#accountnumber").val("").prop("disabled",true);
	 		   	     					$("#ifsccode").val("").prop("disabled",true);
	 		   	     					$("#bankname").val("").prop("disabled",true);
	 		   	     					$("#branchname").val("").prop("disabled",true);
	 		   	     					$("#benedescription").val("").prop("disabled",true);
	    	             		  }
    	             			  
    	             		  }
    	             		});
    	 			    }
    	        	 }
	            	
             
    	         
    	       $(document).ready(function(){
    	    	   bankdata.dataSource.data = [];
          		   $("#bankgrid").kendoGrid(bankdata);
    	    	   setTimeout(() => {
    	    		   getSupplierBackDetail();
				},1000);
    	    	   
    	       })
                
 			 function isValidBankDetails(){
				var beneficiaryname = $("#beneficiaryname").val();
				var accountnumber = $("#accountnumber").val();
				var ifsccode = $("#ifsccode").val();
				var bankname = $("#bankname").val();
				var branchname = $("#branchname").val();
				var benedescription = $("#benedescription").val();
				var ifscregex = /^[A-Za-z]{4}\d{7}$/;
				
				if(null==beneficiaryname || !beneficiaryname.trim())
				{
					errorMessage("info", "Please Enter Beneficiary Name", "Required Filed..!");
					$('#beneiciaryname').focus();
					return false;
				}
				else if(null==accountnumber || !accountnumber.trim())
				{
					errorMessage("info", "Please Enter Account Number", "Required Filed..!");
					$('#accountnumber').focus();
					return false;
				}
				else if(null!=accountnumber && accountnumber.trim().length<9)
				{
					errorMessage("info", "Please Enter Correct Account Number<br>Account Number Must have  minimum length of 9 digits.", "Invalid Filed..!");
					$('#accountnumber').focus();
					return false;
				}
				else if(null==ifsccode || !ifsccode.trim())
				{
					errorMessage("info", "Please Enter IFSC Code", "Required Filed..!");
					$('#ifsccode').focus();
					return false;
				}
				else if(!ifscregex.test(ifsccode))
				{
					errorMessage("info", "Please Enter Correct IFSC Code", "Invalid Filed..!");
					$('#ifsccode').focus();
					return false;
				}
				else if(null==bankname || !bankname.trim())
				{
					errorMessage("info", "Please Enter Bank Name", "Required Filed..!");
					$('#bankname').focus();
					return false;
				} 
				else if(null==branchname || !branchname.trim())
				{
					errorMessage("info", "Please Enter Branch Name", "Required Filed..!");
					$('#branchname').focus();
					return false;
				} 
				return true;
		}







function inputtext(obj)
{
	obj.value=obj.value.replace(/[^a-z A-Z0-9]/,'');
}

function inputint(obj)
{
	obj.value=obj.value.replace(/[^0-9]/g,'');
}

function inputchar(obj)
{
	obj.value=obj.value.replace(/[^a-z A-Z]/,'');
}
