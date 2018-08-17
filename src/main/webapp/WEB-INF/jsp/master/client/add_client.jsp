<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">

    <title>Client Master - Add</title>
    <script src="${serverurl}/mudralogin/assets/custom/js/mytheme.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700" rel="stylesheet">
 	<link rel="stylesheet" href="${serverurl}/mudralogin/assets/css/import.css" /> 	
    <link rel="stylesheet" type="text/css" href="${serverurl}/mudralogin/assets/alert_custom/css/sweetalert.css">
	
    <link rel="stylesheet" type="text/css" href="${serverurl}/mudralogin/assets/alert_custom/css/alert_custom.css" />
</head>

<body class="horizontal-layout horizontal-menu horizontal-menu-padding 2-columns   menu-expanded"
data-open="hover" data-menu="horizontal-menu" data-col="2-columns">
	<div class="animation"><div style="display: none;" id="before_form"></div></div>
	  	<input type="hidden" name="clientidhd" id="clientidhd" value="${clientidhd}" >
		<input type="hidden" name="clientnamehd" id="clientnamehd" value="" >
		<input type="hidden" name="glcodehd" id="glcodehd" value="" >
		<input type="hidden" name="clientgroupidhd" id="clientgroupidhd" value="" >
		<input type="hidden"  name="agencytypehd" id="agencytypehd" value="" >
  	  <!-- ////////////////////////////////////////////////////////////////////////////-->
  	  <!-- Horizontal navigation-->
  	  <!-- <div class="app-content content"> -->
	  <div class="app-content container center-layout mt-1">
	    <div class="content-wrapper">
	        <div class="content-body">
	            <form class="form-horizontal" name="myform" id="myform" novalidate>
	            <div class="card cardShape">
				<div class="card-header cardShape">
	                  <h4 class="card-title">Client Master</h4>
	                  <a class="heading-elements-toggle"><i class="ft-ellipsis-h font-medium-3"></i></a>
	                  <div class="heading-elements">
	                    <ul class="list-inline mb-0">
	                      <li><a data-action="collapse" id="showdtail"><i class="ft-minus text-white"></i></a></li>
						  <li><a href="../clientmaster/"><i class="fa fa-chevron-left text-white"></i></a></li>                      
	                    </ul>
	                  </div>
	                </div>           
	
	                <div class="card-content collapse show">
	                    <div class=" mt-07">
	                
	            <ul class="nav nav-tabs nav-topline">
	                      <li class="nav-item">
	                        <a class="nav-link active" id="base-tab21" data-toggle="tab" aria-controls="tab21" href="#tab21" aria-expanded="true">Client Master</a>
	                      </li>
	                      <li class="nav-item">
	                        <a class="nav-link disabled" id="base-tab22"  data-toggle="tab-disabled" aria-controls="tab22" href="#tab22" aria-expanded="false">Brand Details</a>
	                      </li>
	                      <li class="nav-item">
	                        <a class="nav-link disabled" id="base-tab23" data-toggle="tab-disabled" aria-controls="tab23" href="#tab23" aria-expanded="false">PAN Based Details</a>
	                      </li>
	                      <li class="nav-item">
	                        <a class="nav-link disabled" id="base-tab24" data-toggle="tab-disabled" aria-controls="tab24" href="#tab24" aria-expanded="false">Client Group Details</a>
	                      </li>
	                      <li class="nav-item">
	                        <a class="nav-link disabled" id="base-tab25" data-toggle="tab-disabled" aria-controls="tab25" href="#tab25" aria-expanded="false">Contract Details</a>
	                      </li>
	                      
	                      <li class="nav-item">
	                        <a class="nav-link disabled" id="base-tab26" data-toggle="tab-disabled" aria-controls="tab26" href="#tab26" aria-expanded="false">Other Details</a>
	                      </li>
	                    </ul>
	                 
	            <div class="tab-content px-0 pt-1 border-tab border-lighten-2 border-0-top">
	                <div role="tabpanel" class="tab-pane active pr-1" id="tab21" aria-expanded="true" aria-labelledby="base-tab21">
	                   	
	                   	<div class="row">
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <label class="col-sm-4 col-form-label">Client ID<span class="required danger"> *</span></label>
	                                <div class="col-sm-8 controls">
	                                      <input type="text" name="clientid" id="clientid" oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^A-Za-z0-9]/g,'');" class="form-control"  maxlength="10">
	                                </div>
	                            </div>
	                        </div>                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <div class="col-sm-3 ">
	                                    <label class="col-form-label">Client Name<span class="required danger"> *</span></label>
	                                </div>
	                                <div class="col-sm-9 controls">
	                                     <input type="text" id="clientname" name="clientname" class="form-control" maxlength="64">
	                                </div>                            
	                        </div>
	                        </div>
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                            <label class="col-sm-4 col-form-label">GL Code<span class="required danger"> *</span></label>
	                                <div class="col-sm-3 controls" style="padding-right: 0px;">
	                                      <input type="text" name="glcode" id="glcode" disabled="disabled" class="form-control" >
	                                </div>
	                                <div class="col-sm-5 controls">
	                                      <input type="text" name="glcodename" id="glcodename" maxlength="70" class="form-control" >
	                                </div>
	                        </div>
	                        </div>
	                        <!-- Show Only Edit Time Copy Button -->
	                        
	                    </div>
	                    
	                    <div class="row">
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <div class="col-sm-6 ">
	                                  <div class="custom-control custom-checkbox">
	                                    <input type="checkbox" class="custom-control-input" name="createclientgroup" id="createclientgroup">
	                                    <label class="custom-control-label mtop-2" for="createclientgroup">Create Client Group</label>
	                                  </div>
	                                </div> 
	                                <div class="col-sm-6 controls" style="display: none;" id="clientgroupnameDiv">
									 	<input type="text" name="clientgroupname" id="clientgroupname" class="form-control" maxlength="64" >
		                            </div>                               
	                            </div>                            
	                        </div>
	                       
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <label class="col-sm-3 col-form-label">Short Name<span class="required danger"> *</span></label>
	                            <div class="col-sm-9 controls">
									  <input type="text" name="clientdisplayname" id="clientdisplayname" class="form-control" maxlength="32" >
	                            </div>                                
	                            </div>
	                        </div>    
	                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <label class="col-sm-4 col-form-label">Client Group ID<span class="required danger"> *</span></label>                                
	                                <div class="col-sm-8 controls">
	                                      <input type="text" id="clientgroupid" name="clientgroupid" placeholder="Select" style="width: 100%;" class="dropdown-height" />
	                                </div>
	                            </div>
	                        </div>
	                        
	                        <div class="col-sm-1">                           
								<a href="#" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#clientaddress"><span class="float-right badgeButton themeColor">address</span></a>
	                          </div>   
	                        
	                    </div>
	                        
	                    <div class="row">
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <div class="col-sm-4 pr-0">
	                                    <label class="col-form-label">Service Type<span class="required danger"> *</span></label>
	                                </div>
	                                <div class="col-sm-8 controls">
	                                     <input type="text" id="clienttype" name="clienttype" placeholder="Select Service Type..." style="width: 100%;" class="dropdown-height" maxlength="24"/>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                            <label class="col-sm-3 col-form-label">Client Type<span class="required danger"> *</span></label>
	                            <div class="col-sm-9 ">
									  <input type="text" id="clienttype1" name="clienttype1" placeholder="Select Client Type..." style="width: 100%;" class="dropdown-height" maxlength="24"/>
	                            </div>
	                        </div>
	                        </div>
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                            <label class="col-sm-4 col-form-label">GST Client Type<span class="required danger"> *</span></label>
	                            <div class="col-sm-8 controls">
									  <input type="text" id="gstclienttype" name="gstclienttype" placeholder="Select GST Client Type..." style="width: 100%;" class="dropdown-height" maxlength="24"/>
	                            </div>
	                        </div>
	                        </div>
	                                        
	                    </div>
	                    
	                    <div class="row">
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <div class="col-sm-12 ">
	                                  <div class="custom-control custom-checkbox">
	                                    <input type="checkbox" class="custom-control-input" name="clientprintaddressfrombrand" id="clientprintaddressfrombrand">
	                                    <label class="custom-control-label mtop-2" for="clientprintaddressfrombrand">Print Address From Brand</label>
	                                  </div>
	                                </div>                                
	                            </div>                            
	                        </div>                       
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <div class="col-sm-3 ">
	                                    <label class="col-form-label">Credit days</label>
	                                </div>
	                                <div class="col-sm-2">
	                                     <input type="text" value="30" name="creditdays" id="creditdays" onchange="this.value = ((null==this.value || !this.value.trim())?'0':this.value)" 
	                                     oninput="this.value = this.value.replace(/[^0-9]/g, '');" class="form-control text-right" maxlength="2">
	                                </div>                                
	                                    <label class="col-form-label">DB Client Code</label>                                
	                                <div class="col-sm-4" style="padding-right: 3px;">
	                                     <input type="text" name="dbclientcode" id="dbclientcode" disabled="disabled" maxlength="13" class="form-control text-right">
	                                </div>
	                            </div>
	                        </div>
	                        <div class="col-md-3">
	                            <div class="form-group row">                            
	                                
	                            <div class="col-sm-12 ">
									  <div class="custom-control custom-checkbox">
	                                    <input type="checkbox" class="custom-control-input" name="isdbbankactintimatedtoclient" id="isdbbankactintimatedtoclient">
	                                    <label class="custom-control-label mtop-2" for="isdbbankactintimatedtoclient">Is DBBank A/C Intimated to Client</label>
	                                  </div>
	                            </div>
	                        </div>
	                        </div>
	                        <div class="col-sm-2" style="display: none;">
  								<a href="#" data-toggle="modal" class="float-right" data-keyboard="false" data-backdrop="static" data-target="#changeclient">
  									<span class="float-left badgeButton themeColor">Change Name</span>
  								</a>
                            </div>                
	                    </div>
	                    <div class="row" id="copy_branches_div" style="display: none;">
	                    	<div class="col-md-3"></div>
	                    	<div class="col-md-4"></div>
	                    	<div class="col-md-4">
	                    		<div class="form-group row">
	                        		<label class="col-sm-5 col-form-label pr-0">Copy client to branches</label>                                
		                            <div class="col-sm-7">
		                            	<input id="copyclienttable" style="width: 100%;" />
		                            </div>
	                            </div>
	                    	</div>
	                   	</div>
	                                                                
	                    <hr>
	                        
	                    <div class="row">
	                        <div class="col-md-3">
	                            <div class="form-group row">                                 
	                                <label class="col-sm-5 col-form-label">PAN<span class="required danger"> *</span></label>
	                                <div class="col-sm-7 " id="panfilediv">
	                                    <label id="projectinput7" class="file center-block">
	                            			<input type="file" id="panfile" name="panfile">
	                            			<span class="file-custom"></span>
	                          			</label>
	                                </div>                                 
	                                
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <div class="col-sm-5 ">
	                                      <input type="text" name="pannumber" id="pannumber" oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');" maxlength="10" class="form-control">
	                                </div> 
	                                <label class="col-sm-2 col-form-label">TAN</label>
	                                <div class="col-sm-5 ">
	                                      <input type="text" name="clientTan" id="clientTan" maxlength="12" class="form-control">
	                                </div>
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <label class="col-sm-4 col-form-label">LTC (%)</label>
	                                <div class="col-sm-6 ">
	                                      <input type="text" name="ltcpercentage" id="ltcpercentage" onchange="checkPerData(this)" maxlength="5" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" class="form-control text-right">
	                                </div>                                
	                                <!--<label class="col-sm-5"><span class="fonts-small">(Low TDS certificate %)</span></label>-->
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-3">
	                            <div class="form-group row">                                
	                                <label class="col-sm-3 col-form-label">TIN</label>
	                                <div class="col-sm-6 ">
	                                      <input type="text" name="tinnumber" id="tinnumber" maxlength="32" class="form-control">
	                                </div>
	                            </div>
	                        </div>
	                        
	                       
	                    </div>                                            
	                    
	                    <hr>
	                    
	                    <div class="row">
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <label class="col-sm-5 col-form-label">Bank Guarantee</label>
	                                <div class="col-sm-7 " id="bankfilediv">
	                                    <label id="projectinput8" class="file center-block">
			                            	<input type="file" id="bankfile" name="bankfile">
			                            <span class="file-custom"></span>
			                          </label>
	                                </div>                                
	                            </div>
	                        </div>
	                        <div class="col-md-3">
	                            <div class="form-group row">                                                               
	                                <div class="col-sm-4 ">
	                                    <label class="col-form-label">Amount</label>
	                                </div>
	                                <div class="col-sm-6">
	                                     <input type="text" name="bankguaranteeamount" id="bankguaranteeamount" maxlength="14" onchange="checkNumberData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" class="form-control text-right"> 
	                                </div>                                
	                            </div>
	                        </div>
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <div class="col-sm-4 ">
	                                    <label class="col-form-label">Start Date</label>
	                                </div>                                
	                                <div class="col-sm-6">
	                                      <fieldset class="form-group">
								 
										  <div class="input-group">
											<div class="input-group-prepend">
											  <span class="input-group-text"><i class="ft-calendar"></i></span>
											</div>
											<input type="text" name="bankguaranteedate" id="bankguaranteedate" class="form-control datepicker-default" />
										  </div>
								 
								</fieldset>
	                                </div>  
	                            </div>
	                        </div>
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                                              
	                                <div class="col-sm-3 ">
	                                    <label class="col-form-label">Exp Date</label>
	                                </div>
	                                <div class="col-sm-6">
	                                     <fieldset class="form-group">
								 
										  <div class="input-group">
											<div class="input-group-prepend">
											  <span class="input-group-text"><i class="ft-calendar"></i></span>
											</div>
											<input type="text" name="expirydate" id="expirydate" class="form-control datepicker-default" />
										  </div>
								 
										</fieldset>
	                                </div>
	                            </div>
	                        </div>                        
	                    </div>
	                        
	                    <hr>
	                    <div style="display: none;" id="clientcontractDiv">    
	                    <div class="row" >
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <label class="col-sm-5 col-form-label">Client Contract</label>
	                                <div class="col-sm-7">
	                                    <a href="#" id="downloadcontractid" class="dwnldbtn"><i class="fa fa-download mt-04" title="download file" aria-hidden="true"></i></a>
	                                    <!-- label id="projectinput8" class="file center-block">
			                            	<input type="file" id="clientcontractfile" name="clientcontractfile">
			                            <span class="file-custom"></span>
			                            </label-->
	                                </div>                                
	                            </div>
	                        </div>
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                  <!-- label class="col-sm-4 col-form-label">Start Date</label-->
	                                  <!-- label class="col-sm-8 col-form-label">05/07/2018</label-->
		                                <div class="col-sm-4 ">
		                                	<label class="col-form-label">Start Date</label>
		                                </div>
		                                <div class="col-sm-6">
		                                    <fieldset class="form-group">
									 			<div class="input-group">
													<div class="input-group-prepend">
													  <span class="input-group-text"><i class="ft-calendar"></i></span>
													</div>
													<input type="text" name="client_contract_startdate" id="client_contract_startdate" class="form-control datepicker-default" />
											  	</div>
									 		</fieldset>
		                                </div>
	                            </div>
	                        </div>                        
	                      
	                      <div class="col-md-3">
	                            <div class="form-group row">                                                             
	                                <div class="col-sm-4 ">
		                            	<label class="col-form-label">End Date</label>
		                            </div>
		                            <div class="col-sm-6">
		                                <fieldset class="form-group">
									 		<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"><i class="ft-calendar"></i></span>
												</div>
												<input type="text" name="client_contract_enddate" id="client_contract_enddate" class="form-control datepicker-default" />
											</div>
										</fieldset>
		                            </div>
	                            </div>
	                        </div>
	                        
	                         
	                    </div>                                          
	                        
	                    <hr> 
	                    </div>
	                        
	                    <div class="row">
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <label class="col-sm-5 col-form-label">Bus. Commit.</label>
	                                <div class="col-sm-6">
	                                      <input type="text" name="businesscommitment" id="businesscommitment" onchange="checkNumberData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="14" class="form-control text-right">
	                                </div>                                
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-3">
	                            <div class="form-group row">                                                              
	                                <div class="col-sm-4 ">
	                                    <label class="col-form-label">Exp. Limit<span class="required danger"> *</span></label>
	                                </div>
	                                <div class="col-sm-6">
	                                     <input type="text" name="exposurelimit" id="exposurelimit" onchange="checkNumberData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="14" class="form-control text-right">
	                                </div>                                
	                            </div>
	                        </div> 
	                        
	                        <div class="col-md-3">
	                            <div class="form-group row">                                                              
	                                <div class="col-sm-4 ">
	                                    <label class="col-form-label">Unbooked</label>
	                                </div>
	                                <div class="col-sm-6">
	                                     <input type="text" name="unbookedliability" disabled="disabled" id="unbookedliability" onchange="checkNumberData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="14" class="form-control text-right">
	                                </div>                                
	                            </div>
	                        </div> 
	                                              
	                    </div>
	                        
	                    <div class="row mb-1" style="display: none;" id="client_balance_div">
	                        <div class="col-md-3">
	                            <div class="form-group row">
	                                <label class="col-sm-5 col-form-label">Op. Balance</label>
	                                <div class="col-sm-6">
	                                      <input type="text" id="openingbalance" name="openingbalance" maxlength="14" onchange="checkNumberData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" class="form-control text-right" disabled="disabled" placeholder="0">
	                                </div>                                                                
	                            </div>
	                        </div>                        
	                        <div class="col-md-3">
	                            <div class="form-group row">                                                             
	                                <div class="col-sm-4 ">
	                                    <label class="col-form-label">Cl. Balance</label>
	                                </div>
	                                <div class="col-sm-6">
	                                     <input type="text" id="closingbalance" name="closingbalance" maxlength="14" onchange="checkNumberData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" class="form-control text-right" disabled="disabled" placeholder="0">
	                                </div>                                
	                            </div>
	                        </div>                                              
	                        <div class="col-md-3">
	                            <div class="form-group row">                                                             
	                                <div class="col-sm-4 ">
	                                    <label class="col-form-label">Balance</label>
	                                </div>
	                                <div class="col-sm-6">
	                                     <input type="text" id="clientbalance" name="clientbalance" maxlength="14" onchange="checkNumberData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" class="form-control text-right" disabled="disabled" placeholder="0">
	                                </div>                                
	                            </div>
	                        </div>     
	                    </div>
	                    
	                </div>
	                
	                      <!-- BRAND MASTER START HEAR.................................... -->
                
                
	                <div class="tab-pane" id="tab22" aria-labelledby="base-tab22">
	                    <div class="row">
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <label class="col-sm-3 col-form-label lbllineheight">Client Name</label>                                
	                                <label class="col-sm-9 col-form-label clientnametxt lbllineheight" id="clientnametxt"></label>
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <label class="col-sm-3 col-form-label">Brand ID<span class="required danger"> *</span></label>
	                                <div class="col-sm-4 controls">
	                                      <input type="text" name="brandid" id='brandid' class="form-control" oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^A-Za-z0-9]/g,'');" maxlength="10" >
	                                </div>                                
	                            </div>
	                        </div>                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <div class="col-sm-3 ">
	                                    <label class="col-form-label">Brand Name<span class="required danger"> *</span></label>
	                                </div>
	                                <div class="col-sm-9 controls">
	                                     <input type="text" class="form-control" name="brandname" id='brandname' oninput="this.value=this.value.replace(/[^A-Z a-z0-9]/g,'');" maxlength="40">
	                                </div>                            
	                        </div>
	                        </div>
	                        
	                    </div>
	                    
	                    <div class="row">                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                            <label class="col-sm-3 col-form-label pr-0">Agency Type<span class="required danger"> *</span></label>                                
	                                <div class="col-sm-9 controls">
	                                      <input id="agencytype" name="agencytype" placeholder="Select Agency Type" style="width: 100%;" class="dropdown-height" required/>
	                                </div>
	                        </div>
	                        </div>                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                            <label class="col-sm-3 col-form-label pr-0">Copy Branches</label>                                
	                            <div class="col-sm-9">
	                            	<input id="brandbranches" style="width: 100%;" />
	                            </div>                                
	                        </div>
	                        </div>
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                            <label class="col-sm-3 col-form-label"></label>                                
	                                <div class="col-sm-2">                           
								<a href="#" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#brandaddressreq"><span class="float-left badgeButton themeColor">address</span></a>
	                          </div> 
	                        </div>
	                        </div> 
	                    </div>
	                    
	                    <div class="row">
	                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <label class="col-sm-3 col-form-label">Sector<span class="required danger"> *</span></label>
	                                <div class="col-sm-9 controls">
	                                      <input id="sectorcode" name="sectorcode"  placeholder="Select sector" style="width: 100%" class="dropdown-height" />
	                                </div>                                
	                            </div>
	                        </div>
	                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <div class="col-sm-3 ">
	                                    <label class="col-form-label">Product<span class="required danger"> *</span></label>
	                                </div>
	                                <div class="col-sm-9 controls">
	                                     <input id="productcode" name="productcode" placeholder="Select Product" style="width: 100%;" class="dropdown-height" />
	                                </div>                            
	                        </div>
	                        </div>                                               
	                    </div>
	                    
	                    <div class="row mb-1">
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                
	                                <div class="col-sm-6">
	                                  <div class="custom-control custom-checkbox">
	                                    <input type="checkbox" class="custom-control-input" name="ismediarequired" id="ismediarequired">
	                                    <label class="custom-control-label mtop-2" for="ismediarequired">IS Media Required</label>
	                                  </div>
	                                </div>
	                                <div class="col-sm-6">
	                                  <div class="custom-control custom-checkbox float-right">
	                                    <input type="checkbox" class="custom-control-input" name="exclusivity" id="exclusivity">
	                                    <label class="custom-control-label mtop-2" for="exclusivity">Exclusive</label>
	                                  </div>
	                                </div>
	                                                                
	                            </div>                            
	                        </div>
	                        
	                        <div class="col-md-4">
	                            <div class="form-group row">
	                                <div class="col-sm-3 ">
	                                  <label class="col-form-label">Region</label>
	                                </div>
	                                <div class="col-sm-4 ">
	                                    <input id="region" disabled="disabled" name="region" placeholder="Select" style="width: 100%;" class="dropdown-height" />
	                                </div>
	                                
	                               
	                                
		                                <div class="col-sm-1 pl-0 regionRadio" style="display:none;" >
		                                  <div class="custom-control custom-radio">
		                                    <input type="radio" class="custom-control-input" name="exle" id="exle" value='E'>
		                                    <label class="custom-control-label mtop-2" for="exle">E</label>
		                                  </div>
		                                </div>
		                                <div class="col-sm-1 regionRadio" style="display:none;" >
		                                  <div class="custom-control custom-radio">
		                                    <input type="radio" class="custom-control-input" name="exle" id="exlw" value='W'>
		                                    <label class="custom-control-label mtop-2" for="exlw">W</label>
		                                  </div>
		                                </div>
		                                <div class="col-sm-1 ml-1 regionRadio" style="display:none;" >
		                                  <div class="custom-control custom-radio">
		                                    <input type="radio" class="custom-control-input" name="exle" id="exln" value='N'>
		                                    <label class="custom-control-label mtop-2" for="exln">N</label>
		                                  </div>
		                                </div>
		                                <div class="col-sm-1 ml-1 regionRadio"  style="display:none;">
		                                  <div class="custom-control custom-radio">
		                                    <input type="radio" class="custom-control-input" name="exle" id="exls" value='S'>
		                                    <label class="custom-control-label mtop-2" for="exls">S</label>
		                                  </div>
		                            	</div>
		                                <div class="col-sm-5 pl-0 regionText" style="display: none;">
		                                  <input type="text" name="other_region_text" id="other_region_text" class="form-control" maxlength="52">
		                                </div>
	                            </div>                            
	                        </div>                                                
	                        
	                    </div>
	                    
	                    <div class="row mb-0">
	                        <div class="col-md-3">
	                                <div class="form-group row">
	                                    <div class="col-sm-12">
	                                      <div class="custom-control custom-checkbox">
	                                        <input type="checkbox" class="custom-control-input" name="prnbrandnmclientnm" id="prnbrandnmclientnm">
	                                        <label class="custom-control-label mtop-2" for="prnbrandnmclientnm">Print Brand As Client Name </label>
	                                      </div>
	                                    </div>
	                                    </div>
	                            
	                                <div class="form-group row mt-1">
	                                    <div class="col-sm-12">
	                                      <div class="custom-control custom-checkbox">
	                                        <input type="checkbox" class="custom-control-input" name="printadd" id="printadd">
	                                        <label class="custom-control-label mtop-2" for="printadd">Print Address from Brand </label>
	                                      </div>
	                                    </div>
	                                    </div>
	                            
	                                <div class="form-group row mt-1">
	                                    <div class="col-sm-12">
	                                      <div class="custom-control custom-checkbox">
	                                        <input type="checkbox" class="custom-control-input" name="timesheetdisplay" id="timesheetdisplay">
	                                        <label class="custom-control-label mtop-2" for="timesheetdisplay">Display in Time Sheet </label>
	                                      </div>
	                                    </div>
	                                    </div>
	                            
	                                <div class="form-group row mt-1 mb-1" id="brand_active_div" style="display: none;">
	                                    <div class="col-sm-12">
	                                      <div class="custom-control custom-checkbox">
	                                        <input type="checkbox" class="custom-control-input" name="isactive" id="isactive">
	                                        <label class="custom-control-label mtop-2" for="isactive">Is Active </label>
	                                      </div>
	                                    </div>
	                                    </div>
	                            
	                                <div class="form-group row mt-1 mb-0">
	                                    <div class="col-sm-6">
	                                      <div class="custom-control custom-checkbox">
	                                        <input type="checkbox" class="custom-control-input" name="hasBarterDeal" id="hasBarterDeal">
	                                        <label class="custom-control-label mtop-2" for="hasBarterDeal">Has Barter Deal </label>
	                                      </div>
	                                    </div>
	                                    <div class="col-sm-3">
	                                         <input type="text" class="form-control text-right" name="barterDealAgencyPer" id="barterDealAgencyPer" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" disabled="disabled"> 
	                                    </div>
	                                    <label class="col-sm-3 col-form-label pl-0">Agency %</label>
	                                    </div>
	                               
	                        </div>
	                        
	                        <div class="col-md-9">
	                            <div class="row">
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7">
	                                        <label class="col-form-label">Agency Comm % (Gross)</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" name="agencycommission" id="agencycommission" class="form-control text-right" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="5">
	                                    </div>
	                                    </div>
	                                </div>                                                                                                        
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">CA Comm %</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" class="form-control text-right" id='cacommission' name="cacommission" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="5"> 
	                                    </div>
	                                    </div>
	                                </div>
	                                    
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">Client Comm %</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" class="form-control text-right" name="clientcommission" id="clientcommission" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="5"> 
	                                    </div>
	                                    </div>
	                                </div>
	                                    
	                            </div>
	                            
	                            <div class="row">
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">Agency Comm % (Net)</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" class="form-control text-right" name="agencycommissionNet" id="agencycommissionNet" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="5">
	                                    </div>
	                                    </div>
	                                </div>
	                                
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">OMS Comm %</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" id="omscommissionpercent" name="omscommissionpercent" class="form-control text-right" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="4"> 
	                                    </div>
	                                    </div>
	                                </div>
	                                
	                                 <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">Print Prefix</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" class="form-control" id="printprefix" name='printprefix'> 
	                                    </div>
	                                    </div>
	                                </div>                                                                        
	                            </div>
	                            
	                            <div class="row">
	                                
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">Bill. Tax. Service %</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" class="form-control text-right" name="billingperc" id="billingperc" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="4">  
	                                    </div>
	                                    </div>
	                                </div>
	                                    
	                               <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">Est. Tax. Service %</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" class="form-control text-right" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="4"> 
	                                    </div>
	                                    </div>
	                                </div> 
	                                    
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">Remuneration</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" id='remuneration' name="remuneration" class="form-control text-right"> 
	                                    </div>
	                                    </div>
	                                </div>
	                                                                    
	                            </div>
	                            
	                            <div class="row">
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-7 ">
	                                        <label class="col-form-label">Int. on Unpaid Bills %</label>
	                                    </div>
	                                    <div class="col-sm-5">
	                                         <input type="text" class="form-control text-right" id="interestonunpaidbills" name="interestonunpaidbills" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="4"> 
	                                    </div>
	                                    </div>
	                                </div>
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-12 ">
	                                        <label class="col-form-label float-right">Print ID</label>
	                                    </div>                                    
	                                    </div>
	                                </div>    
	                                <div class="col-md-4">
	                                    <div class="form-group row">                                    
	                                    <div class="col-sm-12">
	                                         <input id="printuniqueid" name="printuniqueid" placeholder="Select Print ID" style="width: 100%;" class="dropdown-height" />
	                                    </div>
	                                    </div>
	                                </div>  
	                            </div>
	                            
	                            <div class="row">
	                                <div class="col-md-4">
	                                    <div class="form-group row">
	                                    <div class="col-sm-6 ">
	                                        <label class="col-form-label">Client Sign On</label>
	                                    </div>
	                                    <div class="col-sm-6">
	                                         <fieldset class="form-group">							 
	                                          <div class="input-group">
	                                            <div class="input-group-prepend">
	                                              <span class="input-group-text"><i class="ft-calendar"></i></span>
	                                            </div>
	                                            <input type="text" id="clientfirstsignon" name="clientfirstsignon" class="form-control datepicker-default" />
	                                          </div>
								             </fieldset>
	                                    </div>
	                                    </div>
	                                </div>                                                            
	                            </div>                           
	                        </div>
	                    </div>
	                    
	                    <div class="mb-1 mt-1" align="center">
								<div style="text-align:center">
									<a href="#"><span class="badgeButton addbrandclass themeColor"><i class="fa fa-save"></i> Add</span></a>
									<!--a href="#"><span class="badgeButton "><i class="fa fa-trash"></i> Delete</span></a-->
		                            <a href="#" onclick="cleanBrandMasterFn()" ><span class=" badgeButton themeColor"><i class="fa fa-eraser"></i> Reset</span></a>
								</div>                    
	                    </div>
	                    
	                    <div class="row mt-1">					
						   <div id="grid" ></div>
	                    </div>
	                    
	                </div>
                
                
              <!-- END BRAND NUMBER -->  
	                
	                   <!-- PAN -->
                
                
                <div class="tab-pane" id="tab23" aria-labelledby="base-tab23">                                        
                    <div class="row">
                    	<div class="col-md-2">
                    		<div class="form-group row">
                                <label class="col-sm-5 col-form-label">Client ID :</label>
                                <label class="col-sm-7 col-form-label clientidtxt"  id="clientidtxt"></label>                
                            </div>
                    	</div>
                    	
                    	<div class="col-md-5">
                    		<div class="form-group row">
                                <label class="col-sm-3 col-form-label lbllineheight">Client Name :</label>
                                <label class="col-sm-9 col-form-label clientnametxt lbllineheight" id="clientnametxt"></label>                
                            </div>
                    	</div>
                    	<div class="col-md-5">
                    		<div class="form-group row">
                            <label class="col-sm-2 col-form-label text-right lbllineheight">GL Code :</label>
                                <label class="col-sm-10 col-form-label glcodetxt lbllineheight" id="glcodetxt"></label>
                            </div>
                    	</div>
                   	</div> 
                    <div class="row">
                        <div class="col-md-4">                            
                            
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">PAN<span class="required danger"> *</span></label>
                                <div class="col-sm-4 controls">
                                      <input type="text" class="form-control" placeholder="" id="panpannumber" name="panpannumber" oninput="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');" maxlength="10" readonly="readonly">
                                </div>                                
                            </div>
                            
                            <div class="form-group row">
                                <div class="col-sm-4 controls pr-0">
                                    <label class="col-form-label">Client Name (NSDL)<span class="required danger"> *</span></label>
                                </div>
                                <div class="col-sm-8 controls">
                                     <input type="text" class="form-control" name="pannsdlclientname" id="pannsdlclientname" oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="70">
                                </div>                            
                            </div>
                            
                            <div class="form-group row">
                            <label class="col-sm-4 col-form-label">GST Client Type</label>                                
                                <div class="col-sm-8 ">
                                      <input id="pantypeofclient" name="pantypeofclient" placeholder="Select GST Client Type" style="width: 100%;" class="dropdown-height"  />
                                </div>
                            </div>
                            
                            <div class="form-group row" style="display: none;">
                                <div class="col-sm-4"></div>
                                <div class="col-sm-8">
                                  <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" name="is_currently_active" id="is_currently_active">
                                        <label class="custom-control-label mtop-2" for="is_currently_active">Currently Active </label>
                                      </div>
                                </div>                                
                            </div>
                        </div>
                        
                        <div class="col-md-5">
                            
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Contact Person</label>
                                <div class="col-sm-9">
                                      <input type="text" class="form-control" id="pancontactperson" name="pancontactperson" oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="32">
                                </div>                                
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label">Address</label>
                                <div class="col-sm-9">
                                      <input type="text" class="form-control" name="panregisteredaddress1" id="panregisteredaddress1" oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="128">
                                </div>                                
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label"></label>
                                <div class="col-sm-9">
                                      <input type="text" class="form-control" name="panregisteredaddress2" id="panregisteredaddress2" oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="128">
                                </div>                                
                            </div>
                            <div class="form-group row mt-07">
                                <label class="col-sm-3 col-form-label"></label>
                                <div class="col-sm-9">
                                      <input type="text" class="form-control" name="panregisteredaddress3" id="panregisteredaddress3" oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="128">
                                </div>                                
                            </div>  
                            <div class="form-group row mt-07">
                                <label class="col-sm-3 col-form-label">City</label>
                                <div class="col-sm-4">
                                      <input type="text" class="form-control" id="panregisteredcity" name="panregisteredcity" oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="64"> 
                                </div>
                                <label class="col-sm-2 col-form-label">Pin Code</label>
                                <div class="col-sm-3">
                                      <input type="text" class="form-control" id="panregisteredpin" name="panregisteredpin" oninput="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="6">
                                </div> 
                            </div>                        
                        </div>
                        
                        <div class="col-md-3">
                            
                            <div class="form-group row">
                            <label class="col-sm-4 col-form-label">State</label>                                
                                <div class="col-sm-8 ">
                                      <input id="panregisteredstate" name="panregisteredstate" placeholder="Select State" style="width: 100%;" class="dropdown-height" />
                                </div>
                            </div>
                            
                            <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Country</label>                                
                                <div class="col-sm-8 ">
                                      <input type="text" class="form-control" id="pancountry" name='pancountry'  oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="32">
                                </div>
                            </div>
                            
                            <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Phone No.</label>                                
                                <div class="col-sm-8 ">
                                      <input type="text" class="form-control" name='pantelephonenumbers' id="pantelephonenumbers" oninput="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="10">
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Mobile No.</label>
                                <div class="col-sm-8">
                                      <input type="text" class="form-control" oninput="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="10">
                                </div>                                
                            </div>
                            
                            <div class="form-group row">                                
                                <label class="col-sm-4 col-form-label">Fax</label>
                                <div class="col-sm-8">
                                      <input type="text" class="form-control" id="panfaxnumbers" name="panfaxnumbers"  oninput="this.value=this.value.replace(/[^0-9]/g,'');" maxlength="10">
                                </div>
                            </div>
                            
                            <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Email</label>
                                <div class="col-sm-8 ">
                                      <input type="text" class="form-control"  id="panemailid" name="panemailid" oninput="toLowerCaseFn(this)" maxlength="128">
                                </div>
                            </div>
                        </div>
                                                
                    </div>
                    
                    <div class=" mt-07 mb-2" align="center">
							<div style="text-align:center">
							<a href="#"  data-toggle="modal" id ="panmodal"><span class=" badgeButton themeColor"><i class="fa fa-plus"></i> Add</span></a>
							</div>                    
                    </div>
                    
                    <div class="row mt-1">					
					   <div id="panbasegrid" style="width: 100%;" ></div>
                    </div>
                    
                </div>
                
                <!-- PAN END -->
	                
	                <!-- CLIENT GRP -->
                
                <div class="tab-pane" id="tab24" aria-labelledby="base-tab24">
                     <div class="row">
                        
                        <div class="col-md-12">
                            <div class="form-group row">
                                <label class="col-sm-1 col-form-label">Client Group :</label>                                
                                <label class="col-sm-11 col-form-label clientidgrptxt" id="clientidgrptxt"></label>
                            </div>
                        </div>
                                                
                    </div>
                       <div class="row mt-1">					
					   <div id="clientgrpgrid" style="width: 100%;" ></div>
                    </div> 
                </div>
                
                
                <!-- CLIENT GRP  -->
	                
	                <!-- CONTRCT  -->
                
                <div class="tab-pane" id="tab25" aria-labelledby="base-tab25">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="form-group row">
                                <label class="col-sm-5 col-form-label">Client ID :</label>                                
                                <label class="col-sm-7 col-form-label clientidtxt" id="clientidtxt"></label>
                            </div>
                        </div>
                        
                        <div class="col-md-5">
                            <div class="form-group row">
                                <label class="col-sm-3 col-form-label lbllineheight">Client Name :</label>                                
                                <label class="col-sm-9 col-form-label clientnametxt lbllineheight" id="clientnametxt"></label>
                            </div>
                        </div>
                        
                        <div class="col-md-5">
                            <div class="form-group row">
                                <label class="col-sm-2 col-form-label text-right lbllineheight">GL Code :</label>                                
                                <label class="col-sm-10 col-form-label glcodetxt lbllineheight" id="glcodetxt"></label>
                            </div>
                        </div>
                                                
                    </div>
                      <div class="row mt-1">
					   <div id="contractgrid" style="width: 100%;" ></div>
                      </div>
                </div>
                
                <!-- CONTRAC END -->
	                
	                <!-- OTHER -->
                
                <div class="tab-pane" id="tab26" aria-labelledby="base-tab26">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group row">
                                <label class="col-sm-1 col-form-label">Client ID</label>                                
                                <label class="col-sm-11 col-form-label clientidtxt" id="clientidtxt"></label>
                            </div>
                        </div>                       
                                                
                    </div>
                    <div class="row">                        
                        <div class="col-md-12">
                            <div class="form-group row">
                                <label class="col-sm-1 col-form-label">Client Name</label>                                
                                <label class="col-sm-11 col-form-label clientnametxt"  id="clientnametxt"></label>
                            </div>
                        </div>                                                             
                    </div>
                    <div class="row">                                                                     
                        <div class="col-md-12">
                            <div class="form-group row">
                                <label class="col-sm-1 col-form-label">GL Code</label>                                
                                <label class="col-sm-11 col-form-label glcodetxt" id="glcodetxt"></label>
                            </div>
                        </div>
						<div class="col-md-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group row">
                                <label class="col-sm-1 col-form-label">Supplier Code</label>
                                <div class="col-sm-4">
                                      <input id="supplierid" name="supplierid" placeholder="Select Supp. Code" style="width: 100%;" class="dropdown-height" />
                                </div>                                
                            </div>
                        </div>                                                                  
                    </div>
                    
                    <div class="row">                                            
                        <div class="col-md-12">
                            <div class="form-group row">
                                <label class="col-sm-1 col-form-label">Cheque Bank</label>                                
                                <div class="col-sm-4">
                                     <input id="chequebank" name="chequebank" type="text" class="form-control" oninput="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');" maxlength="40">
                                </div>                            
                        </div>
                        </div>                               
                    </div>
                    
                    <div class="row">                        
                        <div class="col-md-12">
                            <div class="form-group row">
                            <label class="col-sm-1 col-form-label">Bank Branch</label>                                
                                <div class="col-sm-4">
                                     <input id="chequebranch" name="chequebranch" type="text" class="form-control" oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="20">
                                </div>
                        </div>
                        </div>                     
                    </div>
                    
                    <div class="row mb-1">
                        <div class="col-md-5">
                            <div class="form-group row">
                                <div class="col-sm-4">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" name="timesheetdisplay" id="timesheetdisplay1" value="Y">
                                        <label class="custom-control-label mtop-2" for="timesheetdisplay1">Display in Timesheet </label>
                                      </div>
                                </div>
                                <div class="col-sm-8">
                                      <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" name="isapprovalinsertiondate" id="isapprovalinsertiondate" value='Y'>
                                        <label class="custom-control-label mtop-2" for="isapprovalinsertiondate">Is Approval Insertion Date </label>
                                      </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-7"></div>
                    </div>
                    
                    <div class="row mb-1">
                        <div class="col-md-5">
                            <div class="form-group row">
                                <div class="col-sm-8">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" name="stampdutyapplicable" id="stampdutyapplicable" value="Y">
                                        <label class="custom-control-label mtop-2" for="stampdutyapplicable">Is Stamp Duty Applicable</label>
                                      </div>
                                </div>                                
                            </div>
                        </div>    
                        <div class="col-md-7"></div>                                       
                    </div>
                    
                    <div class="row mb-1">
                        <div class="col-md-5">
                            <div class="form-group row">
                                <label class="col-sm-4 col-form-label">Stamp Duty Charge (%)</label>
                                <div class="col-sm-2">
                                     <input type="text" id="stampcharg" name="stampcharg" class="form-control text-right" onchange="checkPerData(this)" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');" maxlength="4">
                                </div>                            
                        </div>
                        </div>
                        <div class="col-md-7"></div>                                         
                    </div>
                </div>
                
                <!-- OTHER END -->
	                
	            </div>
	                  
	                    </div>
	                </div>
	            </div>
				
				 <div class=" mt-2 fixedBottom">				
								<div style="text-align:center">							
	                            <a href="#"><span class=" badgeButton submitbtnclass themeColor"><i class="fa fa-save"></i> SAVE</span></a>
								<a href="#" class="disabled"><span class=" badgeButton themeColor "><i class="fa fa-refresh"></i> ROUTE</span></a>
								<a href="#" class="disabled"><span class=" badgeButton themeColor"><i class="fa fa-undo"></i> UNDO</span></a>
								<a href="#" class="disabled"><span class=" badgeButton themeColor"><i class="fa fa-envelope"></i> Call4<span class="text-uppercase">IT</span></span></a>
								</div>                                               
	                    </div>
	            </form>		
	        </div>
	    </div>
	</div>

	       
		
	<div class="modal fade" id="copyclient" role="dialog" aria-labelledby="gstin-label" aria-hidden="true">
         <div class="modal-dialog modal-sm" role="document">
         	<div class="modal-content cardShape">
            	<div class="modal-header cardShape">
                	<h5 class="modal-title" id="gstin-label">Copy Client</h5>
                    <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                    	<span aria-hidden="true">&times;</span>
                    </a>
				</div>
                        <div class="modal-body">
                            <div class="tbl-scroll">
                          		<div class="form-group row">
	                        		<label class="col-sm-3 col-form-label pr-0">Copy Clients</label>                                
		                            <div class="col-sm-9">
		                            	<input id="copyclienttable" style="width: 100%;" />
		                            </div>
	                            </div>
                            </div>
                        </div>
                        <div class="modal-footer">
							<a  href="#" data-dismiss="modal"><span class=" badgeButton themeColor"><i class="fa fa-check"></i>SELECT</span></a>							
                        </div>
        	</div>
    	</div>
	</div>

	<div class="modal fade" id="clientaddress" role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
                    <div class="modal-dialog modal-md" role="document">
                      <div class="modal-content cardShape">
                        <div class="modal-header cardShape">
                          <h5 class="modal-title" id="cgstin-label">Client Address</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
						  
                        </div>
                        <div class="modal-body">                          							
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">Address 1<span class="required danger"> *</span></label>
										  <div class="col-sm-10 controls">
								            <input type="text" name="clientaddress1" id="clientaddress1" class="form-control" placeholder="" maxlength="128" >
										  </div>
									</div>
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">Address 2<span class="required danger"> *</span></label>
										  <div class="col-sm-10 controls">
								            <input type="text" name="clientaddress2" id="clientaddress2" class="form-control" placeholder="" maxlength="128">
										  </div>
									</div>									
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">Address 3</label>
										  <div class="col-sm-10 ">
								            <input type="text" name="clientaddress3" id="clientaddress3" class="form-control" placeholder="" maxlength="128">
										  </div>
									</div>                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">City<span class="required danger"> *</span></label>
										  <div class="col-sm-5 controls">
								            <input type="text" name="clientcity" id="clientcity" oninput="this.value = this.value.replace(/[^a-zA-Z ]/g,'');" class="form-control" placeholder="" maxlength="64" >
										  </div>
                                          <label class="col-sm-2 col-form-label">PIN<span class="required danger"> *</span></label>
										  <div class="col-sm-3 controls">
								            <input type="text" name="clientpin" id="clientpin" oninput="this.value = this.value.replace(/[^0-9]/g,'');" class="form-control" placeholder="" maxlength="6" >
										  </div>
									</div>
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">State<span class="required danger"> *</span></label>
										  <div class="col-sm-5 controls">
								            <input id="clientstate" name="clientstate" placeholder="Select State" style="width: 100%;" class="dropdown-height" maxlength="64"/>
										  </div>
                                          <label class="col-sm-2 col-form-label pr-0">Country<span class="required danger"> *</span></label>
										  <div class="col-sm-3 controls">
								            <input type="text" name="clientcountry" id="clientcountry" oninput="this.value = this.value.replace(/[^a-zA-Z ]/g,'');" class="form-control" placeholder="" maxlength="64">
										  </div>
									</div>
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Phone No.<span class="required danger"> *</span></label>
										  <div class="col-sm-2 controls">
								            <input type="text" name="clientstdcode" id="clientstdcode" class="form-control" oninput="this.value = this.value.replace(/[^0-9]/g,'');" placeholder="STD Code" maxlength="8">
										  </div>
                                          <div class="col-sm-3 controls">
								            <input type="text" name="clienttelephonenumbers" id="clienttelephonenumbers" oninput="this.value = this.value.replace(/[^0-9]/g,'');" class="form-control" maxlength="12">
										  </div>
                                          <label class="col-sm-2 col-form-label">Fax No.</label>
										  <div class="col-sm-3 ">
								            <input type="text" name="clientfaxnumbers" id="clientfaxnumbers" class="form-control" oninput="this.value = this.value.replace(/[^0-9]/g,'');" placeholder="" maxlength="64">
										  </div>
									</div>
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Email ID</label>
										  <div class="col-sm-5 ">
								            <input type="text" name="clientemailid" id="clientemailid" oninput="toLowerCaseFn(this)" class="form-control" placeholder="" maxlength="64">
										  </div>
                                        <label class="col-sm-2 col-form-label">Website</label>
										  <div class="col-sm-3 ">
								            <input type="text" name="clientwebsite" id="clientwebsite" class="form-control" placeholder="" maxlength="64">
										  </div>
									</div>						  
                        </div>
                        <div class="modal-footer" style="width: 100%;">
                            <a href="#" onclick="clientAddressValidation()"><span class=" badgeButton themeColor"> <i class="fa fa-thumbs-up" aria-hidden="true"></i> OK</span></a>
							<!--a href="#" data-dismiss="modal"><span class=" badgeButton themeColor"><i class="fa fa-remove"></i> cancel</span></a -->					
                        </div>
                      </div>
                    </div>
                  </div>    
    
    <div class="modal fade" id="brandaddressreq" role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
                    <div class="modal-dialog modal-md" role="document">
                      <div class="modal-content cardShape">
                        <form class="form-horizontal" novalidate>
                        <div class="modal-header cardShape">
                          <h5 class="modal-title" id="cgstin-label">Address</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
						  
                        </div>
                        <div class="modal-body">                          							
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">Address 1<span class="required danger"> *</span></label>
										  <div class="col-sm-10 controls">
								            <input type="text" name="baddress1" id="baddress1" class="form-control" placeholder="" maxlength="128" >
										  </div>
									</div>
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">Address 2<span class="required danger"> *</span></label>
										  <div class="col-sm-10 controls">
								            <input type="text" name="baddress2" id="baddress2" class="form-control" placeholder="" maxlength="128">
										  </div>
									</div>									
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">Address 3</label>
										  <div class="col-sm-10 ">
								            <input type="text" name="baddress3" id="baddress3" class="form-control" placeholder="" maxlength="128">
										  </div>
									</div>                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">City<span class="required danger"> *</span></label>
										  <div class="col-sm-5 controls">
								            <input type="text" name="bcity" id="bcity" class="form-control" oninput="this.value = this.value.replace(/[^a-zA-Z ]/g,'');" placeholder="" maxlength="64" >
										  </div>
                                          <label class="col-sm-2 col-form-label">PIN<span class="required danger"> *</span></label>
										  <div class="col-sm-3 controls">
								            <input type="text" name="bpin" id="bpin" class="form-control" oninput="this.value = this.value.replace(/[^0-9]/g,'');" placeholder="" maxlength="6" >
										  </div>
									</div>
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">State<span class="required danger"> *</span></label>
										  <div class="col-sm-5 controls">
								            <input id="bstate" name="bstate" placeholder="Select State" style="width: 100%;" class="dropdown-height" maxlength="64"/>
										  </div>
                                          <label class="col-sm-2 col-form-label pr-0">Country<span class="required danger"> *</span></label>
										  <div class="col-sm-3 controls">
								            <input type="text" name="bcountry" id="bcountry" class="form-control" oninput="this.value = this.value.replace(/[^a-zA-Z ]/g,'');" placeholder="" maxlength="64">
										  </div>
									</div>
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Phone No.<span class="required danger"> *</span></label>
										  <div class="col-sm-2 controls">
								            <input type="text" name="bstdcode" id="bstdcode" class="form-control" oninput="this.value = this.value.replace(/[^0-9]/g,'');" placeholder="STD Code" maxlength="8">
										  </div>
                                          <div class="col-sm-3 controls">
								            <input type="text" name="btelephonenumbers" id="btelephonenumbers" oninput="this.value = this.value.replace(/[^0-9]/g,'');" class="form-control" maxlength="12">
										  </div>
                                          <label class="col-sm-2 col-form-label">Fax No.</label>
										  <div class="col-sm-3 ">
								            <input type="text" name="bfaxnumbers" id="bfaxnumbers" class="form-control" oninput="this.value = this.value.replace(/[^0-9]/g,'');"  placeholder="" maxlength="20">
										  </div>
									</div>
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Email ID</label>
										  <div class="col-sm-5 ">
								            <input type="text" name="bemailid" id="bemailid" oninput="toLowerCaseFn(this)" class="form-control" placeholder="" maxlength="64">
										  </div>
									</div>						  
                        </div>
                        <div class="modal-footer" style="width: 100%;">
                            <a href="#" onclick="brandAddressValidation()" ><span class="badgeButton addresssaveb themeColor"><i class="fa fa-save"></i> Save</span></a>
							<a  href="#" data-dismiss="modal"><span class=" badgeButton themeColor"><i class="fa fa-remove"></i> cancel</span></a>					
                        </div>
                        </form>
                      </div>
                    </div>
                  </div>
    
	<div class="modal fade" id="addgstindetails" role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
                    <div class="modal-dialog modal-md" role="document">
                      <div class="modal-content cardShape">
                          <form class="form-horizontal" novalidate>
                        <div class="modal-header cardShape">
                          <h5 class="modal-title" id="cgstin-label">GSTIN Details</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
						  
                        </div>
                        <div class="modal-body">
                        <input type='hidden' id="gstindetailsrno" name="gstindetailsrno" >                            
                                    <div class="form-group row mb-1">
										  <label class="col-sm-2 col-form-label"></label>
										  <div class="col-sm-1 ">
								            <fieldset>
                                              <div class="custom-control custom-radio">
                                                <input type="radio" value="gstin" class="custom-control-input" name="gstdetailgstin_uidn_type" id="gstin" checked>
                                                <label class="custom-control-label" for="gstin">GSTIN</label>
                                              </div>
                                            </fieldset>
										  </div>
                                          <div class="col-sm-1 ">
								            <fieldset>
                                              <div class="custom-control custom-radio">
                                                <input value="uidn" type="radio" class="custom-control-input" name="gstdetailgstin_uidn_type" id="uidn">
                                                <label class="custom-control-label" for="uidn">UIDN</label>
                                              </div>
                                            </fieldset>
										  </div>
									</div>                          			                                                                        
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">State<span class="required danger"> *</span></label>
										  <div class="col-sm-5 controls">
								            <input id="gstdetailtatecode" name="gstdetailtatecode" placeholder="Select State" style="width: 100%;" class="dropdown-height" />
										  </div>
									</div>
									
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">GSTIN/UIDN<span class="required danger"> *</span></label>
										  <div class="col-sm-5 controls">
								            <input type="text" class="form-control" placeholder="" name='gstdetailgstin' id="gstdetailgstin" oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');" maxlength="16" >
										  </div>
                                          <div class="col-sm-5">
                                          <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" name="gstdetailisdefault" id="gstdetailisdefault">
                                            <label class="custom-control-label mtop-2" for="gstdetailisdefault">Is Default GSTIN / UIDN ?</label>
                                          </div>
                                          </div>
									</div>
                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Address<span class="required danger"> *</span></label>
										  <div class="col-sm-10 controls">
								            <input type="text" class="form-control" placeholder="" required name="gstdetailaddress" id="gstdetailaddress" oninput="this.value=this.value.replace(/[^a-zA-Z 0-9]/g,'');" maxlength="1024">
										  </div>                                          
									</div>  
                                    
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">City<span class="required danger"> *</span></label>
										  <div class="col-sm-5 controls">
								            <input type="text" class="form-control" placeholder="" id="gstdetailcity" name="gstdetailcity" 
								            oninput="this.value=this.value.replace(/[^a-z A-Z]/g,'');" maxlength="64">
										  </div>
                                          <label class="col-sm-2 col-form-label">Pin Code<span class="required danger"> *</span></label>
										  <div class="col-sm-3 controls">
								            <input type="text"  class="form-control" required maxlength="6" id="gstdetailpincode" name="gstdetailpincode" oninput="this.value=this.value.replace(/[^0-9]/g,'');">
										  </div>
									</div>
                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Country<span class="required danger"> *</span></label>
										  <div class="col-sm-5 controls">
								            <input type="text" class="form-control" placeholder="" id="gstdetailcountry" name="gstdetailcountry" oninput="this.value=this.value.replace(/[^a-zA-Z ]/g,'');" maxlength="64">
										  </div>                                          
									</div>
                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Cont.Person(Finance)</label>
										  <div class="col-sm-5">
								            <input type="text" class="form-control" placeholder="" id="gstdetailauthorizedperson" name="gstdetailauthorizedperson" oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="64">
										  </div>
                                          <label class="col-sm-2 col-form-label">Phone No.</label>
										  <div class="col-sm-3">
								            <input type="text" class="form-control" placeholder="" 
								            id="gstdetailtelephonenumber" name='gstdetailtelephonenumber' 
								            oninput="this.value=this.value.replace(/[^0-9]/g,'');" onchange="checkNumberData(this)" maxlength="10">
										  </div>
									</div>
                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Email</label>
										  <div class="col-sm-5">
								            <input type="text" class="form-control" placeholder="" oninput="toLowerCaseFn(this)" id='gstdetailemailid' name="gstdetailemailid"  maxlength="128">
										  </div>
                                          <div class="col-sm-5" id="pan_is_active" style="display: none;">
                                          <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" name="gstdetailisactive" id="gstdetailisactive">
                                            <label class="custom-control-label mtop-2" for="gstdetailisactive">Is Active</label>
                                          </div>
                                          </div>
									</div>
                            						  
                        </div>
                        <div class="modal-footer" style="width: 100%;">
						  <a href="javaScript:panbasegstindetail();" class="badgeButton themeColor"><i class="fa fa-save"></i> Save</a>
						  <a  href="#" data-dismiss="modal"><span class=" badgeButton themeColor"><i class="fa fa-remove"></i> cancel</span></a>					
                        </div>
                        </form>
                      </div>
                    </div>
                  </div>
    
	<div class="modal fade" id="contractdetails" role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
                    <div class="modal-dialog modal-md" role="document">
                      <div class="modal-content cardShape">
                        <form class="form-horizontal" novalidate id="contractfile" name="contractfile">
                        <input type="hidden" name="srno" id="srno" value="">
                        <div class="modal-header cardShape">
                          <h5 class="modal-title" id="cgstin-label">Contract Details</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
						  
                        </div>
                        <div class="modal-body">
                          			
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Contract Type<span class="required danger">*</span></label>
                                                  <div class="col-sm-8 controls">
                                                    <input id="contractype" name="contractype" placeholder="Select Type" style="width: 100%;" class="dropdown-height"/>
                                                  </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Brand Name<span class="required danger">*</span></label>
                                                  <div class="col-sm-8">
                                                    <input id="brandidcontrac" name="brandidcontrac" placeholder="Select Brand Name" style="width: 100%;" class="dropdown-height" />
                                                  </div>
                                            </div>
                                        </div>                                        
                                    </div>
                            
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group row">
                                                  <label class="col-sm-2 col-form-label">Contract Desc.</label>
                                                  <div class="col-sm-10">
                                                    <input type="text" id="contracdesc" name="contracdesc" class="form-control"  oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="128">
                                                  </div>
                                            </div>
                                        </div>                                      
                                    </div>
                            
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Contract File</label>
                                                  <div class="col-sm-8" id="contractfilediv">
                                                    <label id="projectinput9" class="file center-block">
                                                        <input type="file" id="contracfile" name="contracfile">
                                                        <span class="file-custom"></span>
                                                    </label>
                                                  </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Start / End Date<span class="required danger"> *</span></label>
                                                  <div class="col-sm-8 controls">
                                                    <div class='position-relative input-group'>
                                                        <input type='text' class="form-control daterange" id="startenddate" name="startenddate" />
                                                        <div class="input-group-append">
                                                            <span class="input-group-text">
                                                              <span class="fa fa-calendar"></span>
                                                            </span>
                                                        </div>
                                                    </div>
                                                  </div>
                                            </div>
                                        </div>                                        
                                    </div>
                            
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Termina. Clause</label>
                                                  <div class="col-sm-8">
                                                    <input type="text" class="form-control"  id="terminationclause" name='terminationclause' oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');" maxlength="64">
                                                  </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Revenue Fees</label>
                                                  <div class="col-sm-8">
                                                    <input type="text" class="form-control text-right"  id="revenuefees" name="revenuefees" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');"  maxlength="10">
                                                  </div>
                                            </div>
                                        </div>
                                    </div>
                            
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Revenue Super.</label>
                                                  <div class="col-sm-8">
                                                    <input type="text" class="form-control text-right"  id="revenuesupervision" name="revenuesupervision" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');"  maxlength="10">
                                                  </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Revenue Others</label>
                                                  <div class="col-sm-8">
                                                    <input type="text" class="form-control text-right"  id="revenueothers" name="revenueothers" oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');"  maxlength="10" >
                                                  </div>
                                            </div>
                                        </div>
                                    </div>
                            
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Is Alert Required</label>
                                                  <div class="col-sm-8">
                                                    <input id="isalertrequired" name="isalertrequired"  style="width: 100%;" class="dropdown-height" />
                                                  </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Alert Interval</label>
                                                  <div class="col-sm-8">
                                                    <input type="text" class="form-control"  id="alertinterval" name="alertinterval" oninput="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');" maxlength="32">
                                                  </div>
                                            </div>
                                        </div>                                        
                                    </div>
                            
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label">Alert End Date</label>
                                                  <div class="col-sm-8">
                                                    <fieldset class="form-group">							 
                                                              <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                  <span class="input-group-text"><i class="ft-calendar"></i></span>
                                                                </div>
                                                                <input type="text" name='alertenddate' id="alertenddate" class="form-control datepicker-default" />
                                                              </div>
                                                    </fieldset>
                                                  </div>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-6" id="contract_is_active" style="display: none;">
                                            <div class="form-group row">
                                                  <label class="col-sm-4 col-form-label"></label>
                                                  <div class="col-sm-8">
                                                    <div class="custom-control custom-checkbox">
                                                        <input type="checkbox" class="custom-control-input" name="contracisactive" id="contracisactive">
                                                        <label class="custom-control-label mtop-2" for="contracisactive">Is Active</label>
                                                      </div>
                                                  </div>
                                            </div>
                                        </div>                                        
                                    </div>						  
                        </div>
                        <div class="modal-footer" style="width: 100%;">
						  <a href="javaScript:saveContract()" class="badgeButton themeColor"><i class="fa fa-save"></i> Save</a>
				          <a  href="#" data-dismiss="modal"><span class=" badgeButton themeColor"><i class="fa fa-remove"></i> cancel</span></a>					
                        </div>
                        </form>
                      </div>
                    </div>
                  </div>
  
  	<div class="modal fade" id="changeclient" role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
                    <div class="modal-dialog modal-md" role="document">
                      <div class="modal-content cardShape">
                        <form class="form-horizontal" novalidate>
                        <div class="modal-header cardShape">
                          <h5 class="modal-title" id="cgstin-label">Change Client Name</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
  
                        </div>
                        <div class="modal-body">
                          	
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group row">
                                                  <label class="col-sm-3 col-form-label">Old Name</label>
                                                  <div class="col-sm-9">
                                                    <input type="text" class="form-control" placeholder="INTAS PHARMASUTICAL LIMITED" readonly>
                                                  </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                        </div>
                                    </div>
                            
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group row">
                                                  <label class="col-sm-3 col-form-label">New Name</label>
                                                  <div class="col-sm-9">
                                                    <input type="text" class="form-control" placeholder="">
                                                  </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group row">
                                                  <label class="col-sm-3 col-form-label">Date</label>
                                                  <div class="col-sm-9">
                                                    <input type="text" class="form-control" placeholder="09/07/2018" readonly>
                                                  </div>
                                            </div>
                                        </div>
                                    </div>                            
                        </div>
                        <div class="modal-footer" style="width: 100%;">
                          <a  href="#" data-dismiss="modal"><span class=" badgeButton themeColor"><i class="fa fa-save"></i> Save</span></a>	   
          <a  href="#" data-dismiss="modal"><span class=" badgeButton themeColor"><i class="fa fa-remove"></i> cancel</span></a>	
                        </div>
                        </form>
                      </div>
                    </div>
                  </div>
  	<script src="../assets/custom/js/footer.js"></script> 
  	
	<script src="${serverurl}/mudralogin/assets/vendors/js/vendors.min.js" type="text/javascript"></script>
	
	<script src="${serverurl}/mudralogin/assets/vendors/js/ui/jquery.sticky.js"></script>
	<script src="${serverurl}/mudralogin/assets/js/core/libraries/jquery_ui/jquery-ui.min.js" type="text/javascript"></script>			
	    
	<script src="${serverurl}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/vendors/js/pickers/pickadate/picker.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/vendors/js/pickers/pickadate/picker.date.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/vendors/js/pickers/pickadate/picker.time.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/vendors/js/pickers/pickadate/legacy.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/vendors/js/pickers/dateTime/moment-with-locales.min.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/vendors/js/pickers/daterange/daterangepicker.js" type="text/javascript"></script>
	
	<script src="${serverurl}/mudralogin/assets/js/core/app-menu.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/js/core/app.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/js/scripts/customizer.js" type="text/javascript"></script>		
	    
	<script src="${serverurl}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
	<script src="${serverurl}/mudralogin/assets/js/scripts/pickers/dateTime/pick-a-datetime.js" type="text/javascript"></script>
	
	<script src="${serverurl}/mudralogin/assets/kendo/js/kendo.all.min.js"></script>
	<script src="${serverurl}/mudralogin/assets/kendo/js/jszip.min.js"></script>
	
	<script src="${serverurl}/mudralogin/assets/alert_custom/js/sweetalert.min.js" type="text/javascript"></script>
	
	<script src="${serverurl}/mudralogin/assets/alert_custom/js/alert_custom.js" type="text/javascript"></script> 
	
	<script src="../js/master/client/common.js" ></script>
	<script src="../js/master/client/clientmaster.js" ></script>
	<script src="../js/master/client/brandmaster.js" ></script>
	<script src="../js/master/client/clientgrp.js"></script>
	<script src="../js/master/client/contractdetail.js"></script>
	<script src="../js/master/client/panbasedetail.js"></script>
	
	<script src="../js/master/client/otherdetailvalidation.js"></script>

</body>
</html>