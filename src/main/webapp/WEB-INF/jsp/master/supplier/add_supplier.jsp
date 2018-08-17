<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">


	<!-- 203.88.135.41 -->
	
	<!-- 192.168.168.27 -->
    <title>Supplier Master</title>
     <script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/mytheme.js"></script>    
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/ico/favicon.png">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${sessionScope.serverpath}/mudralogin/assets/css/import.css">
    
    <style type="text/css">
    .nav.nav-tabs.nav-topline .nav-item a.nav-link.disabled:hover {
            color: #000 !important;
            background-color: rgba(40, 44, 42, 0.12) !important;
            border-top-color: #d9d9d9 !important;
            cursor: not-allowed;
}
    </style>

<!-- ADDDDDDD -->

	<script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/mytheme.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700" rel="stylesheet">
 	<link rel="stylesheet" href="${sessionScope.serverpath}/mudralogin/assets/css/import.css" /> 	
    <link rel="stylesheet" type="text/css" href="${sessionScope.serverpath}/mudralogin/assets/alert_custom/css/sweetalert.css">
	
    <link rel="stylesheet" type="text/css" href="${sessionScope.serverpath}/mudralogin/assets/alert_custom/css/alert_custom.css" />



</head>

<body class="horizontal-layout horizontal-menu horizontal-menu-padding 2-columns   menu-expanded"
data-open="hover" data-menu="horizontal-menu" data-col="2-columns">

<div class="animation"><div style="display: none;" id="before_form"></div></div>
<input type="hidden" name="glcodehd" id="glcodehd" value="">

<!-- Horizontal navigation-->
<!-- <div class="app-content content"> -->
	<div class="app-content container center-layout mt-0 pt-1">
		<div class="content-wrapper">
			<div class="content-body">
				<form class="form-horizontal" name="myform" id="myform" novalidate>
					<input type="hidden" name="supplieridhd" id="supplieridhd"
						value="${supplieridhd}"> <input type="hidden"
						name="suppliernamehd" id="suppliernamehd" value=""> <input
						type="hidden" name="suppliereditflag" id="suppliereditflag"
						value="${suppliereditflag}"> <input type="hidden"
						name="systemdate" id="systemdate" value="${systemdate}">
					<div class="card cardShape">
						<div class="card-header cardShape">
							<h4 class="card-title">Supplier Master</h4>
							<a class="heading-elements-toggle"><i
								class="ft-ellipsis-h font-medium-3"></i></a>
							<div class="heading-elements">
								<ul class="list-inline mb-0">
									<li><a data-action="collapse" id="showdtail"><i
											class="ft-minus text-white"></i></a></li>
									<li><a href="#" onclick="gotohome();"><i
											class="fa fa-chevron-left text-white"></i></a></li>
								</ul>
							</div>
						</div>

						<div class="card-content collapse show">
							<div class=" mt-07">

								<ul class="nav nav-tabs nav-topline mt-07">
									<li class="nav-item"><a class="nav-link active"
										id="supplier-tab" data-toggle="tab"
										aria-controls="suppliertab" href="#suppliertab"
										aria-expanded="true">Supplier Details</a></li>
										
									<li class="nav-item"><a class="nav-link "
										data-toggle="tab"
										id="tds-tab" aria-controls="tdstab" href="#tdstab"
										aria-expanded="false">TDS Details</a></li>
										
									<li class="nav-item"><a class="nav-link "
										id="bank-tab" aria-controls="banktab" href="#banktab"
										data-toggle="tab"
										aria-expanded="false">Bank Details</a></li>
										
									<li class="nav-item"><a class="nav-link disabled"
										id="panbased-tab" aria-controls="panbasedtab"
										href="#panbasedtab" aria-expanded="false">PAN Based
											Details</a></li>
											
									
								</ul>

								<div
									class="tab-content px-0 pt-1 border-tab border-lighten-2 border-0-top">
									<div role="tabpanel" class="tab-pane active pr-1"
										id="suppliertab" aria-expanded="true"
										aria-labelledby="supplier-tab">

										<div class="row mb-0">
											<div class="col-md-6">

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-4">
																<label class="col-form-label">Supplier<span
																	class="required danger"> *</span></label>
															</div>
															<div class="col-sm-3 controls">
																<input type="text"
																	oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^A-Za-z0-9]/g,'');"
																	class="form-control" maxlength="10" name="supplierid"
																	id="supplierid">
															</div>
															<div class="col-sm-5 controls">
																<input type="text" class="form-control"
																	name="suppliername" id="suppliername"
																	oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
																	maxlength="64">
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-4">
																<label class="col-form-label">Short Name</label>
															</div>
															<div class="col-sm-8">
																<input type="text" class="form-control"
																	name="displayname" id="displayname"
																	oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
																	maxlength="20">
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-4">
																<fieldset>
																	<div class="custom-control custom-radio">
																		<input type="radio" class="custom-control-input"
																			name="groupradio" id="existingrdbtn" checked
																			value="exist"> <label
																			class="custom-control-label" for="existingrdbtn">Add
																			To Existing Group <span class="required danger">
																				*</span>
																		</label>
																	</div>
																</fieldset>
															</div>
															<div class="col-sm-8">
																<fieldset>
																	<div class="custom-control custom-radio">
																		<input type="radio" class="custom-control-input"
																			name="groupradio" id="newgrouprdbtn" value="new">
																		<label class="custom-control-label"
																			for="newgrouprdbtn">Create A New Group <span
																			class="required danger"> *</span></label>
																	</div>
																</fieldset>
															</div>
														</div>
													</div>
												</div>

												<div class="row mt-07" id="exitinggroup">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-4">
																<label class="col-form-label">Existing Group</label>
															</div>
															<div class="col-sm-8">
																<input id="suppliergroupid" name="suppliergroupid"
																	placeholder="Select" style="width: 100%;" />
															</div>
														</div>
													</div>
												</div>

												<div class="row mt-07" id="shownewgroup"
													style="display: none">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-4">
																<label class="col-form-label">New Group</label>
															</div>
															<div class="col-sm-3">
																<input type="text" class="form-control" id='newgroupid'
																	name="newgroupid" maxlength="10"
																	oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^A-Za-z0-9]/g,'');">
															</div>
															<div class="col-sm-5">
																<input type="text" class="form-control"
																	name="newgroupname" id="newgroupname"
																	oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
																	maxlength="32">
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-4">
																<label class="col-form-label">Job Type</label>
															</div>
															<div class="col-sm-8">
																<input id="supplierjobtype" name="supplierjobtype"
																	placeholder="Select" style="width: 100%;" />
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-4">
																<label class="col-form-label">Pay To Name</label>
															</div>
															<div class="col-sm-8">
																<input type="text" class="form-control" name="paytoname"
																	id="paytoname"
																	oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
																	maxlength="64">
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-3">
																<div class="custom-control custom-checkbox">
																	<input type="checkbox" class="custom-control-input"
																		name="ismsmedvendor" id="ismsmedvendor"> <label
																		class="custom-control-label mtop-2"
																		for="ismsmedvendor">MSMED Vendor</label>
																</div>
															</div>
															<div class="col-sm-3">
																<div class="custom-control custom-checkbox">
																	<input type="checkbox" class="custom-control-input"
																		name="issquarecentimeter" id="issquarecentimeter"
																		disabled> <label
																		class="custom-control-label mtop-2"
																		for="issquarecentimeter">Square Centimetre</label>
																</div>
															</div>
															<div class="col-sm-3">
																<div class="custom-control custom-checkbox">
																	<input type="checkbox"
																		class="custom-control-input isblacklisted"
																		name="isblacklisted" id="isblacklisted" disabled>
																	<label class="custom-control-label mtop-2"
																		for="isblacklisted">BlackListed</label>
																</div>
															</div>
															<div class="col-sm-3">
																<div class="custom-control custom-checkbox isactive"
																	style="display: none">
																	<input type="checkbox" class="custom-control-input"
																		name="isactive" id="isactive"> <label
																		class="custom-control-label mtop-2" for="isactive">Active</label>
																</div>
															</div>
														</div>
													</div>
												</div>

												<div class="row mt-07">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-3">
																<div class="custom-control custom-checkbox">
																	<input type="checkbox" class="custom-control-input"
																		name="isforeignvendor" id="isforeignvendor"> <label
																		class="custom-control-label mtop-2"
																		for="isforeignvendor">Foreign Vendor</label>
																</div>
															</div>
															<div class="col-sm-3">
																<div class="custom-control custom-checkbox">
																	<input type="checkbox" class="custom-control-input"
																		name="isonlineservice" id="isonlineservice"> <label
																		class="custom-control-label mtop-2"
																		for="isonlineservice">Onlineservice</label>
																</div>
															</div>
															<div class="col-sm-3">
																<div class="custom-control custom-checkbox">
																	<input type="checkbox" class="custom-control-input"
																		name="isacknowledgement" id="isacknowledgement">
																	<label class="custom-control-label mtop-2"
																		for="isacknowledgement">Acknowledge</label>
																</div>
															</div>
														</div>
													</div>
												</div>
												
												<div class="row mt-07" style="display:none" id="downloadfile11">
													<div class="col-md-12">
														<div class="form-group row">
															<label class="col-sm-4 col-form-label">Download ZIP / RAR File</label>															
															<div class="col-sm-2">
                                    							 <a href="#" class="dwnldbtn" id="downloadzip"><i class="fa fa-download mt-04" title="download file" aria-hidden="true"></i></a>
                                							</div>
                                							<label class="col-sm-3 col-form-label">Download PAN File</label>															
															<div class="col-sm-3">
                                    							 <a href="./contractdownloadfiles?path=/attachment/suppliermaster/pan/10010011_EMERGINGF1_PAN.pdf" class="dwnldbtn" id="downloadpan"><i class="fa fa-download mt-04" title="download file" aria-hidden="true"></i></a>
                                							</div>															
														</div>
													</div>
												</div>

											</div>

											<div class="col-md-6">
												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<label style="display: none;"
																class="col-sm-3 col-form-label hideexcle">Open
																By Excel Data</label>
															<div style="display: none;" class="hideexcle">
																<div class="col-sm-6">
																	<label id="openbyexceldata" class="file center-block">
																		<input type="file" id="uploadopenexceldata"> <span
																		class="file-custom"></span>
																	</label>
																</div>
															</div>
															<div class="col-sm-3" style="margin-bottom: 3px;">
																<a href="#" data-toggle="modal" style='display: none'
																	class="changesupplier themeColor"
																	data-target="#changesupplier"><span
																	class="float-left badgeButton themeColor">Change
																		Name</span></a>
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-3">
																<label class="col-form-label">GL Code <span
																	class="required danger">*</span></label>
															</div>
															<div class="col-sm-3">
																<input
																	oninput="this.value=this.value.replace(/[^0-9]/g,'');"
																	type="text" class="form-control text-right"
																	name="glcode" id="glcode" maxlength="5"
																	readonly="readonly">
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-3">
																<label class="col-form-label">Copy Branches</label>
															</div>
															<div class="col-sm-9">
																<input id="supplierbranches" style="width: 100%;" />
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-3">
																<label class="col-form-label">Category <span
																	class="required danger">*</span></label>
															</div>
															<div class="col-sm-3">
																<input type="text" class="form-control"
																	name="suppliercategory" id="suppliercategory"
																	oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
																	maxlength="10">
															</div>
															<div class="col-sm-3">
																<label class="col-form-label">Credit Days</label>
															</div>
															<div class="col-sm-3">
																<input type="text" class="form-control text-right"
																	name="creditdays" id="creditdays"
																	oninput="this.value=this.value.replace(/[^0-9]/g,'');"
																	maxlength="3" value='30'>
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-3">
																<label class="col-form-label">Comm %</label>
															</div>
															<div class="col-sm-3">
																<input type="text" maxlength="5" value="0.00"
																	class="form-control text-right"
																	onchange="checkPerData(this)" id="commissionpercentage"
																	name="commissionpercentage"
																	oninput="this.value = this.value.replace(/[^0-9.]/g, '');this.value = this.value.replace(/(\..*)\./g, '$1');">
															</div>
															<div class="col-sm-6"></div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<label class="col-sm-3 col-form-label">Upload ZIP
																/ RAR File</label>
															<div class="col-sm-9 ">
																<label id="uploadzipfile" class="file center-block">
																	<input type="file" id="uploadziprarfile"> <span
																	class="file-custom"></span>
																</label>
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-3">
																<label class="col-form-label">Supplier Type</label>
															</div>
															<div class="col-sm-3">
																<input id="suppliertype" name="suppliertype"
																	placeholder="Select" style="width: 100%;" />
															</div>
															<div class="col-sm-3">
																<label class="col-form-label">GST Vendor Type</label>
															</div>
															<div class="col-sm-3">
																<input id="gst_vendor_type" name="gst_vendor_type"
																	style="width: 100%;" />
															</div>
														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<label class="col-sm-3 col-form-label">Upload PAN
																<span class="required danger"> *</span>
															</label>
															<div class="col-sm-3">
																<input type="text"
																	oninput="toUpperCaseFn(this); this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
																	class="form-control" aria-invalid="false"
																	name="pannumber" id="pannumber" maxlength="10">
															</div>
															<div class="col-sm-6 ">
																<label id="uploadpan" class="file center-block">
																	<input type="file" id="uploadpanfile"
																	name="uploadpanfile"> <span class="file-custom"></span>
																</label>
															</div>

														</div>
													</div>
												</div>

												<div class="row">
													<div class="col-md-12">
														<div class="form-group row">
															<div class="col-sm-3">
																<label class="col-form-label">PAN Name (NSDL) <span
																	class="required danger"> *</span></label>
															</div>
															<div class="col-sm-5">
																<input type="text" class="form-control"
																	name="pan_suppliername" id="pan_suppliername"
																	oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^A-Z a-z0-9]/g,'');">
															</div>
															<div class="col-sm-4">
																<a href="#" data-toggle="modal" style="display: none"
																	onclick="openChange()" class="float-right changepan"><span
																	class="float-left badgeButton themeColor">Change
																		<span class="text-uppercase">PAN</span>
																</span></a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="row pt-1" style="width: 100%;">
											<div class="col-md-12">
												<h5 class="border-bottom mb-0">Contact Details</h5>
											</div>
										</div>
										<div class="row mt-07 mb-1">

											<div class="col-md-5">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Contact
														Person <span class="required danger"> *</span>
													</label>
													<div class="col-sm-9">
														<input type="text" class="form-control"
															name="suppliercontactperson" id="suppliercontactperson"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="64">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Address <span
														class="required danger"> *</span></label>
													<div class="col-sm-9">
														<input type="text" class="form-control"
															name="supplieraddress1" id="supplieraddress1"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="128">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-3 col-form-label"></label>
													<div class="col-sm-9">
														<input type="text" class="form-control"
															name="supplieraddress2" id="supplieraddress2"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="128">
													</div>
												</div>
												<div class="form-group row mt-07">
													<label class="col-sm-3 col-form-label"></label>
													<div class="col-sm-9">
														<input type="text" class="form-control"
															name="supplieraddress3" id="supplieraddress3"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="128">
													</div>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">City <span
														class="required danger"> *</span></label>
													<div class="col-sm-4">
														<input type="text" class="form-control"
															name="suppliercity" id="suppliercity">
													</div>
													<label class="col-sm-2 col-form-label">Pin Code <span
														class="required danger"> *</span></label>
													<div class="col-sm-4">
														<input type="text" class="form-control text-right"
															name="supplierpincode" id="supplierpincode"
															oninput="this.value=this.value.replace(/[^0-9]/g,'');"
															maxlength="6">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">State <span
														class="required danger"> *</span></label>
													<div class="col-sm-4">
														<input id="state" name="state" placeholder="Select State"
															style="width: 100%;" />
													</div>
													<label class="col-sm-2 col-form-label">Country</label>
													<div class="col-sm-4">
														<input type="text" class="form-control"
															name="suppliercountry" id="suppliercountry">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Phone No.</label>
													<div class="col-sm-4">
														<input type="text"
															class="form-control text-right text-right"
															name="supplierphoneno" id="supplierphoneno"
															oninput="this.value=this.value.replace(/[^0-9]/g,'');"
															maxlength="10">
													</div>
													<label class="col-sm-2 col-form-label">Mobile No.</label>
													<div class="col-sm-4">
														<input type="text" class="form-control text-right"
															name="suppliermobileno" id="suppliermobileno"
															oninput="this.value=this.value.replace(/[^0-9]/g,'');"
															maxlength="10">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-2 col-form-label">Fax</label>
													<div class="col-sm-4">
														<input type="text" class="form-control text-right"
															name="supplierfax" id="supplierfax"
															oninput="this.value=this.value.replace(/[^0-9]/g,'');"
															maxlength="10">
													</div>
													<label class="col-sm-2 col-form-label">Email</label>
													<div class="col-sm-4">
														<input type="text" class="form-control"
															name="supplieremail" id="supplieremail">
													</div>
												</div>
											</div>


											<div class="col-md-1"></div>

										</div>
									</div>

									<!-- TDS  -->

									<div class="tab-pane" id="tdstab" aria-labelledby="tds-tab">
										<input type="hidden" id="tdssrno" name="tdssrno" value="">

										<div class="row">
											<div class="col-md-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Supplier ID</label>
													<label class="col-sm-8 col-form-label supplieridtxt"></label>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Supplier
														Name</label> <label
														class="col-sm-8 col-form-label suppliernametxt"></label>
												</div>
											</div>

											<div class="col-md-4"></div>
										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="col-form-label">Services</label>
													</div>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="tdsservices"
															id="tdsservices"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="32">
													</div>
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="col-form-label">TDS Company Type</label>
													</div>
													<div class="col-sm-8">
														<input id="tdscompanytype"
															placeholder="Select Company Type" style="width: 100%;" />
													</div>
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group row">
													<div class="col-sm-5">
														<label class="col-form-label">TDS Certificate
															Require</label>
													</div>
													<div class="col-sm-7">
														<input id="tdscertificaterequirement" style="width: 100%;" />
													</div>
												</div>
											</div>

										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="col-form-label">Effective From / To</label>
													</div>
													<div class="col-sm-8">
														<div class='position-relative input-group'>
															<input type='text' class="form-control daterange"
																name="tdseffdate" id="tdseffdate" />
															<div class="input-group-append">
																<span class="input-group-text"> <span
																	class="fa fa-calendar"></span>
																</span>
															</div>
														</div>
													</div>
												</div>
											</div>

											<div class="col-md-4">
												<div class="form-group row">
													<div class="col-sm-4">
														<label class="col-form-label">TDS Section</label>
													</div>
													<div class="col-sm-8">
														<input id="tdssection" style="width: 100%;" />
													</div>
												</div>
											</div>

											<div class="col-md-4"></div>
										</div>

										<div class=" mt-1 mb-1" align="center">
											<div style="text-align: center">
												<a href="#" onclick="addTDSdetail()"><span
													class=" badgeButton themeColor"><i
														class="fa fa-plus"></i> Add</span></a>
												<!-- <a href="#"><span class=" badgeButton themeColor"><i class="fa fa-trash"></i> Delete</span></a> -->
											</div>
										</div>

										<div class="row mt-1">
											<div id="tdsbasegrid"></div>
										</div>

									</div>


									<div class="tab-pane" id="panbasedtab"
										aria-labelledby="panbased-tab">

										<div class="row">
											<div class="col-md-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Supplierid
														ID</label> <label class="col-sm-8 col-form-label supplieridtxt"
														id="supplieridtxt"></label>
												</div>

												<div class="form-group row">
													<label class="col-sm-4 col-form-label">PAN<span
														class="required danger"> *</span></label>
													<div class="col-sm-4 controls">
														<input type="text" class="form-control" placeholder=""
															id="panpannumber" name="panpannumber"
															oninput="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');"
															maxlength="10" readonly="readonly">
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-4 controls pr-0">
														<label class="col-form-label">Supplier Name (NSDL)<span
															class="required danger"> *</span></label>
													</div>
													<div class="col-sm-8 controls">
														<input type="text" class="form-control"
															name="pannsdlsuppliername" id="pannsdlsuppliername"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="70">
													</div>
												</div>

												<div class="form-group row">
													<label class="col-sm-4 col-form-label">GST Supplier
														Type</label>
													<div class="col-sm-8 ">
														<input id="pantypeofsupplier" name="pantypeofsupplier"
															placeholder="Select GST Supplier Type"
															style="width: 100%;" class="dropdown-height" />
													</div>
												</div>

												<div class="form-group row">
													<div class="col-sm-4"></div>
													<div class="col-sm-8">
														<div class="custom-control custom-checkbox">
															<input type="checkbox" class="custom-control-input"
																name="is_currently_active" id="is_currently_active">
															<label class="custom-control-label mtop-2"
																for="is_currently_active">Currently Active </label>
														</div>
													</div>
												</div>
											</div>

											<div class="col-md-5">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Supplier
														Name</label> <label
														class="col-sm-9 col-form-label suppliernametxt"
														id="suppliernametxt"></label>
												</div>
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Contact
														Person</label>
													<div class="col-sm-9">
														<input type="text" class="form-control"
															id="pancontactperson" name="pancontactperson"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="32">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Address</label>
													<div class="col-sm-9">
														<input type="text" class="form-control"
															name="panregisteredaddress1" id="panregisteredaddress1"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="128">
													</div>
												</div>
												<div class="form-group row">
													<label class="col-sm-3 col-form-label"></label>
													<div class="col-sm-9">
														<input type="text" class="form-control"
															name="panregisteredaddress2" id="panregisteredaddress2"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="128">
													</div>
												</div>
												<div class="form-group row mt-07">
													<label class="col-sm-3 col-form-label"></label>
													<div class="col-sm-9">
														<input type="text" class="form-control"
															name="panregisteredaddress3" id="panregisteredaddress3"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="128">
													</div>
												</div>
												<div class="form-group row mt-07">
													<label class="col-sm-3 col-form-label">City</label>
													<div class="col-sm-4">
														<input type="text" class="form-control"
															id="panregisteredcity" name="panregisteredcity"
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="64">
													</div>
													<label class="col-sm-2 col-form-label">Pin Code</label>
													<div class="col-sm-3">
														<input type="text" class="form-control"
															id="panregisteredpin" name="panregisteredpin"
															oninput="this.value=this.value.replace(/[^0-9]/g,'');"
															maxlength="6">
													</div>
												</div>
											</div>

											<div class="col-md-3">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">State</label>
													<div class="col-sm-8 ">
														<input id="panregisteredstate" name="panregisteredstate"
															placeholder="Select State" style="width: 100%;"
															class="dropdown-height" />
													</div>
												</div>

												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Country</label>
													<div class="col-sm-8 ">
														<input type="text" class="form-control" id="pancountry"
															name='pancountry'
															oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
															maxlength="32">
													</div>
												</div>

												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Phone No.</label>
													<div class="col-sm-8 ">
														<input type="text" class="form-control"
															name='pantelephonenumbers' id="pantelephonenumbers"
															oninput="this.value=this.value.replace(/[^0-9]/g,'');"
															maxlength="10">
													</div>
												</div>

												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Mobile No.</label>
													<div class="col-sm-8">
														<input type="text" class="form-control"
															oninput="this.value=this.value.replace(/[^0-9]/g,'');"
															maxlength="10">
													</div>
												</div>

												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Fax</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" id="panfaxnumbers"
															name="panfaxnumbers"
															oninput="this.value=this.value.replace(/[^0-9]/g,'');"
															maxlength="10">
													</div>
												</div>

												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Email</label>
													<div class="col-sm-8 ">
														<input type="text" class="form-control" id="panemailid"
															name="panemailid" maxlength="128">
													</div>
												</div>
											</div>

										</div>

										<div class=" mt-07 mb-2" align="center">
											<div style="text-align: center">
												<a href="#" data-toggle="modal" id="panmodal"><span
													class=" badgeButton themeColor"><i
														class="fa fa-plus"></i> Add</span></a>
											</div>
										</div>

										<div class="row mt-1">
											<div id="panbasegrid" style="width: 100%;"></div>
										</div>


										<div class="row" style="width: 100%; margin: 0.2rem 0rem;">
											<div class="col-md-12">
												<h6 class="mb-0">SAC/HSN Details</h6>
											</div>
										</div>

										<div class="row mt-0">
											<div id="sachsngrid" style="width: 100%;"></div>
										</div>

									</div>










									<div class="tab-pane" id="banktab" aria-labelledby="bank-tab">
										<div class="row">
											<div class="col-md-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Supplier ID</label>
													<label class="col-sm-8 col-form-label supplieridtxt"></label>

												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group row">
													<label class="col-sm-5 col-form-label">Supplier
														Name</label> <label
														class="col-sm-7 col-form-label suppliernametxt"></label>
												</div>
											</div>
											<div class="col-md-4"></div>
										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Beneficiary
														Name<span class="required danger"> *</span>
													</label>
													<div class="col-sm-8">
														<input type="text" class="form-control"
															name="beneficiaryname" id="beneficiaryname"
															oninput="inputchar(this)" maxlength="64">
													</div>
												</div>
											</div>

											<div class="col-md-5">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Account
														Number<span class="required danger"> *</span>
													</label>
													<div class="col-sm-8">
														<input type="text" class="form-control text-right"
															name="accountnumber" id="accountnumber"
															oninput="inputint(this)" maxlength="17">
													</div>
												</div>
											</div>

											<div class="col-md-3"></div>
										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">IFSC Code<span
														class="required danger"> *</span></label>
													<div class="col-sm-4">
														<input type="text" class="form-control" name="ifsccode"
															id="ifsccode" oninput="inputtext(this)" maxlength="11">
													</div>
												</div>
											</div>

											<div class="col-md-5">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Beneficiary
														Bank Name</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="bankname"
															id="bankname" oninput="inputchar(this)" maxlength="64">
													</div>
												</div>
											</div>

											<div class="col-md-3"></div>
										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Bank Branch
														Name</label>
													<div class="col-sm-8">
														<input type="text" class="form-control" name="branchname"
															id="branchname" oninput="inputchar(this)" maxlength="32">
													</div>
												</div>
											</div>

											<div class="col-md-5">
												<div class="form-group row">
													<label class="col-sm-4 col-form-label">Beneficiary
														Description</label>
													<div class="col-sm-8">
														<input type="text" class="form-control"
															name="benedescription" id="benedescription">
													</div>
												</div>
											</div>

											<div class="col-md-3"></div>
										</div>

										<div class="row mt-1">
											<div id="bankgrid" style="width: 100%;"></div>
										</div>
									</div>

								</div>

							</div>
						</div>
					</div>

					<div class=" mt-2 fixedBottom">
						<div style="text-align: center">
							<a class="submitbtnclass"><span
								class=" badgeButton themeColor"><i class="fa fa-save"></i>
									Save</span></a> <a href="#" class="disabled"><span
								class=" badgeButton themeColor"><i class="fa fa-refresh"></i>
									ROUTE</span></a> <a href="#" class="disabled"><span
								class=" badgeButton themeColor"><i class="fa fa-undo"></i>
									UNDO</span></a> <a href="#"><span class=" badgeButton themeColor"><i
									class="fa fa-envelope"></i> Call4<span class="text-uppercase">IT</span></span></a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div class="modal fade" id="addgstindetails" tabindex="-1"
		role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content cardShape">
				<form class="form-horizontal" novalidate>
					<div class="modal-header cardShape">
						<h5 class="modal-title" id="cgstin-label">GSTIN Details</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

					</div>
					<div class="modal-body">

						<input type='hidden' id="gstindetailsrno" name="gstindetailsrno">
						<div class="form-group row mb-1">
							<label class="col-sm-2 col-form-label"></label>
							<div class="col-sm-1 ">
								<fieldset>
									<div class="custom-control custom-radio">
										<input type="radio" value="gstin" class="custom-control-input"
											name="gstdetailgstin_uidn_type" id="gstin" checked> <label
											class="custom-control-label" for="gstin">GSTIN</label>
									</div>
								</fieldset>
							</div>
							<div class="col-sm-1 ">
								<fieldset>
									<div class="custom-control custom-radio">
										<input value="uidn" type="radio" class="custom-control-input"
											name="gstdetailgstin_uidn_type" id="uidn"> <label
											class="custom-control-label" for="uidn">UIDN</label>
									</div>
								</fieldset>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">State<span
								class="required danger"> *</span></label>
							<div class="col-sm-5 controls">
								<input id="gstdetailtatecode" name="gstdetailtatecode"
									placeholder="Select State" style="width: 100%;"
									class="dropdown-height" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">GSTIN/UIDN<span
								class="required danger"> *</span></label>
							<div class="col-sm-5 controls">
								<input type="text" class="form-control" placeholder=""
									name='gstdetailgstin' id="gstdetailgstin"
									oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');"
									maxlength="16">
							</div>
							<div class="col-sm-5">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input"
										name="gstdetailisdefault" id="gstdetailisdefault"> <label
										class="custom-control-label mtop-2" for="gstdetailisdefault">Is
										Default GSTIN / UIDN ?</label>
								</div>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Address<span
								class="required danger"> *</span></label>
							<div class="col-sm-10 controls">
								<input type="text" class="form-control" placeholder="" required
									name="gstdetailaddress" id="gstdetailaddress"
									oninput="this.value=this.value.replace(/[^a-zA-Z 0-9]/g,'');"
									maxlength="1024">
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">City<span
								class="required danger"> *</span></label>
							<div class="col-sm-5 controls">
								<input type="text" class="form-control" placeholder=""
									id="gstdetailcity" name="gstdetailcity"
									oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
									maxlength="64">
							</div>
							<label class="col-sm-2 col-form-label">Pin Code<span
								class="required danger"> *</span></label>
							<div class="col-sm-3 controls">
								<input type="text" class="form-control" required maxlength="6"
									id="gstdetailpincode" name="gstdetailpincode"
									oninput="this.value=this.value.replace(/[^0-9]/g,'');">
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Country<span
								class="required danger"> *</span></label>
							<div class="col-sm-5 controls">
								<input type="text" class="form-control" placeholder=""
									id="gstdetailcountry" name="gstdetailcountry"
									oninput="this.value=this.value.replace(/[^a-zA-Z ]/g,'');"
									maxlength="64">
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Cont.Person(Finance)</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" placeholder=""
									id="gstdetailauthorizedperson" name="gstdetailauthorizedperson"
									oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
									maxlength="64">
							</div>
							<label class="col-sm-2 col-form-label">Phone No.</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" placeholder=""
									id="gstdetailtelephonenumber" name='gstdetailtelephonenumber'
									oninput="this.value=this.value.replace(/[^0-9]/g,'');"
									onchange="checkNumberData(this)" maxlength="10">
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Email</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" placeholder=""
									id='gstdetailemailid' name="gstdetailemailid" maxlength="128">
							</div>
							<div class="col-sm-5">
								<div class="custom-control custom-checkbox gstdetailisactive"
									style="display: none">
									<input style="display: none" type="checkbox"
										class="custom-control-input " name="gstdetailisactive"
										id="gstdetailisactive"> <label
										class="custom-control-label mtop-2" for="gstdetailisactive">Is
										Active</label>
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer" style="width: 100%;">
						<a href="javaScript:panbasegstindetail();"
							class="badgeButton themeColor"><i class="fa fa-save"></i>
							Save</a> <a href="#" data-dismiss="modal"><span
							class=" badgeButton themeColor"><i class="fa fa-remove"></i>
								cancel</span></a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="changepan" tabindex="-1" role="dialog"
		aria-labelledby="cgstin-label" aria-hidden="true">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content cardShape">
				<form class="form-horizontal" novalidate name="panform" id="panform">
					<div class="modal-header cardShape">
						<h5 class="modal-title" id="cgstin-label">Change PAN of
							Supplier</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

					</div>
					<div class="modal-body">

						<div class="row">
							<div class="col-md-6">
								<div class="form-group row">
									<label class="col-sm-5 col-form-label">Old PAN</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" placeholder=""
											name="oldpannumber" id="oldpannumber"
											oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^A-Za-z0-9]/g,'');"
											maxlength="10">
									</div>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group row">
									<label class="col-sm-5 col-form-label">New PAN</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" placeholder=""
											name="newpannumber" id="newpannumber"
											oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^A-Za-z0-9]/g,'');"
											maxlength="10">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group row">
									<label class="col-sm-5 col-form-label">Effective From
										Date</label>
									<div class="col-sm-7">
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="ft-calendar"></i>
												</span>
											</div>
											<input type="text" class="form-control dp-month-year"
												name="effactivefromdate" id="effactivefromdate" />
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group row">
									<label class="col-sm-5 col-form-label">Effective To
										Date</label>
									<div class="col-sm-7">
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="ft-calendar"></i>
												</span>
											</div>
											<input type="text" class="form-control dp-month-year"
												name="effactivetodate" id="effactivetodate" />
										</div>

									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group row">
									<label class="col-sm-5 col-form-label">Upload PAN</label>
									<div class="col-sm-7 ">
										<label id="changeuploadpan" class="file center-block">
											<input type="file" id="newuploadpan" name="newuploadpan"
											placeholder="PAN Number"> <span class="file-custom"></span>
										</label>
									</div>

								</div>
							</div>
						</div>

						<div class="row mt-1">
							<div id="changepanbased" style="width: 100%;"></div>
						</div>
					</div>
					<div class="modal-footer" style="width: 100%;">
						<a href="#" onclick="savechangepan()"><span
							class=" badgeButton themeColor"><i class="fa fa-save"></i>
								Save</span></a> <a href="#" data-dismiss="modal"><span
							class=" badgeButton themeColor"><i class="fa fa-remove"></i>
								cancel</span></a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="changesupplier" tabindex="-1" role="dialog"
		aria-labelledby="cgstin-label" aria-hidden="true">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content cardShape">
				<form class="form-horizontal" novalidate>
					<div class="modal-header cardShape">
						<h5 class="modal-title" id="cgstin-label">Change Supplier
							Name</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

					</div>
					<div class="modal-body">

						<div class="row">
							<div class="col-md-8">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Old Name</label>
									<div class="col-sm-9">
										<input type="text" class="form-control"
											placeholder="ALAMARA FILMS" readonly name="oldsuppliername"
											id="oldsuppliername">
									</div>
								</div>
							</div>
							<div class="col-md-4"></div>
						</div>

						<div class="row">
							<div class="col-md-8">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">New Name</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" placeholder=""
											name="newsuppliername" id="newsuppliername"
											oninput="this.value=this.value.replace(/[^a-z A-Z0-9]/g,'');"
											maxlength="64">
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-3 col-form-label">Date</label>
									<div class="col-sm-9">
										<input type="text" class="form-control"
											placeholder="09/07/2018" readonly name="newsupplierdate"
											id="newsupplierdate">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer" style="width: 100%;">
						<a href="#" onclick="changsuppliername();"><span
							class=" badgeButton themeColor"><i class="fa fa-save"></i>
								Save</span></a> <a href="#" data-dismiss="modal"><span
							class=" badgeButton themeColor"><i class="fa fa-remove"></i>
								cancel</span></a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="sachsndetailspop" tabindex="-1"
		role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content cardShape">
				<form class="form-horizontal" novalidate>
					<div class="modal-header cardShape">
						<h5 class="modal-title" id="cgstin-label">SAC/HSN Details</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

					</div>
					<div class="modal-body">

						<input type="hidden" id="typename" name="typename" value="">
						<input type="hidden" id="sachsnsrno" name="sachsnsrno" value="">
						<div class="row">
							<div class="col-md-5">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Type</label>
									<div class="col-sm-8">
										<input id="sactype" placeholder="Select Type"
											style="width: 100%;" />
									</div>
								</div>
							</div>

							<div class="col-md-7">

								<div class="form-group row">
									<label class="col-sm-2 col-form-label"></label>
									<div class="col-sm-10">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												name="sachsn" id="is_defaultsachsn"> <label
												class="custom-control-label mtop-2" for="is_defaultsachsn">Is
												Default SAC/HSN ? </label>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-5">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Tax Slab %</label>
									<div class="col-sm-8">
										<input type="text" class="form-control text-right"
											placeholder="" readonly name="sachsntaxslab"
											id="sachsntaxslab">
									</div>
								</div>
							</div>

							<div class="col-md-7">
								<div class="form-group row">
									<label class="col-sm-2 col-form-label">SAC/HSN</label>
									<div class="col-sm-10">
										<input id="sachsncombo" placeholder="Select SAC/HSN"
											style="width: 100%;" />
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer" style="width: 100%;">
						<a href="javaScript:saveSACHSNData()"><span
							class=" badgeButton themeColor"><i class="fa fa-save"></i>Save</span></a>
						<a href="#" data-dismiss="modal"><span
							class=" badgeButton themeColor"><i class="fa fa-remove"></i>
								cancel</span></a>
					</div>
				</form>
				<form name="urlredirect" id='"urlredirect"'></form>
			</div>
		</div>
	</div>
	<script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/footer.js"></script>  
	<script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/vendors.min.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/ui/jquery.sticky.js"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/js/core/libraries/jquery_ui/jquery-ui.min.js" type="text/javascript"></script>			
	<script src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.date.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.time.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/legacy.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/dateTime/moment-with-locales.min.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/daterange/daterangepicker.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/js/core/app-menu.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/js/core/app.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/customizer.js" type="text/javascript"></script>		
	<script src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/pickers/dateTime/pick-a-datetime.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/kendo/js/kendo.all.min.js"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/kendo/js/jszip.min.js"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/sweetalert.min.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/alert_custom.js" type="text/javascript"></script> 
	<script type="text/javascript" src="../js/master/supplier/add_supplier.js"></script>
	<script type="text/javascript" src="../js/master/supplier/supplierbank.js"></script>
	<script type="text/javascript" src="../js/master/supplier/supplierpan.js"></script>
	<script type="text/javascript" src="../js/master/supplier/suppliertds.js"></script>
	<script type="text/javascript" src="../js/master/supplier/supplier_fileupload.js"></script>
	
</body>
</html>
