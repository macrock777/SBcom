<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">

<title>Publication-Edition Master</title>
	<script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/mytheme.js"></script>    
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/ico/favicon.png">
    <link rel="stylesheet" type="text/css" href="${sessionScope.serverpath}/mudralogin/assets/css/import.css">
    <script	src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/vendors.min.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/ui/jquery.sticky.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/kendo/js/kendo.all.min.js"></script>

</head>

<body
	class="horizontal-layout horizontal-menu horizontal-menu-padding 2-columns   menu-expanded"
	data-open="hover" data-menu="horizontal-menu" data-col="2-columns">
	<div class="animation">
		<div style="display: none;" id="before_form"></div>
	</div>
	<!-- Horizontal navigation-->
	<!-- <div class="app-content content"> -->
	<div class="app-content container center-layout mt-0 pt-1">
		<form name="editionform" id="editionform" method="post">
			<input type="hidden" name="supplieridhd" id="supplieridhd" value="${supplierid}">
		</form>
		<div class="content-wrapper">
			<div class="content-body">
				<form class="form-horizontal" novalidate>
					<div class="card cardShape">
						<div class="card-header cardShape">
							<h4 class="card-title">Publication-Edition Master</h4>
							<a class="heading-elements-toggle"><i
								class="ft-ellipsis-h font-medium-3"></i></a>
							<div class="heading-elements">
								<ul class="list-inline mb-0">
									<li><a data-action="collapse" id="showdtail"><i
											class="ft-minus text-white"></i></a></li>
									<li><a href="#" onclick="backtoGrid()"><i
											class="fa fa-chevron-left text-white"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="card-content collapse show">
							<div class=" mt-07">

								<div class="row">
									<div class="col-md-8">
										<div class="form-group row">
											<label class="col-sm-2 col-form-label">Publication
												ID: </label> <label class="col-sm-10 col-form-label" id="supid">${supplierid}</label>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>

								<div class="row mb-1">
									<div class="col-md-8">
										<div class="form-group row">
											<label class="col-sm-2 col-form-label">Publication
												Name: </label> <label class="col-sm-10 col-form-label" id="supname">${suppliername}</label>
										</div>
									</div>
									<div class="col-md-4"></div>
								</div>

								<div class="row mt-0">
									<div id="editiongrid" style="width: 100%;"></div>
								</div>
							</div>
						</div>
					</div>

					<div class=" mt-2 fixedBottom">
						<div style="text-align: center">
							<a href="#"><span class=" badgeButton themeColor"><i
									class="fa fa-save"></i> Save</span></a> <a href="#"><span
								class=" badgeButton themeColor"><i class="fa fa-refresh"></i>
									ROUTE</span></a> <a href="#"><span class=" badgeButton themeColor"><i
									class="fa fa-undo"></i> UNDO</span></a> <a href="#"><span
								class=" badgeButton themeColor"><i class="fa fa-envelope"></i>
									Call4<span class="text-uppercase">IT</span></span></a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="../assets/custom/js/footer.js"></script>

	<div class="modal fade" id="addeditionmaster" tabindex="-1" data-keyboard="false" data-backdrop="static"
		role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content cardShape">
				<form class="form-horizontal" novalidate>

					<div class="modal-header cardShape">
						<h5 class="modal-title" id="cgstin-label">Edition</h5>
						<button type="button" class="close" data-dismiss="modal" onclick="decMaxeditionid()"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>

					</div>

					<div class="modal-body">
						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Name <span class="required danger"> *</span></label>
									<div class="col-sm-8">
										<input type="text" class="form-control" placeholder="Enter Edition Name..." name="editionname" id="editionname" oninput="inputtext(this)" maxlength="64">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Disp. Name <span class="required danger"> *</span></label>
									<div class="col-sm-8">
										<input type="text" class="form-control"  placeholder="Enter Edition Display Name..." name="editiondisplayname" id="editiondisplayname" oninput="inputtext(this)" maxlength="32">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">State Qualifier</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" placeholder="Enter State Qualifier Name..."	name="statequalifier" id="statequalifier" oninput="inputtext(this)" maxlength="256">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
								<label class="col-sm-4 col-form-label" for="projectinput1">Language</label> 
								<div class="col-sm-8">
									<input name="language" id="language" placeholder="Select Language..." style="width: 100%;"/>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Edt. Frg</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionfrequency" id="editionfrequency" oninput="inputtext(this)" maxlength="16">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label pr-0">Edt. Reg.</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionregion" id="editionregion" oninput="inputtext(this)" maxlength="16">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">MRV No.</label>
									<div class="col-sm-8">
										<input type="text" class="form-control text-right" name="mrvnumber" id="mrvnumber" oninput="inputtext(this)" maxlength="16">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Pub. Type</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="publicationtype" id="publicationtype" oninput="inputtext(this)" maxlength="16">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label pr-0">Supplier ID</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" readonly name="supplierid" id="supplierid">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Old Pub. Code</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" readonly name="oldPubCode" id="oldPubCode">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Pay to Pub. Name</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" readonly name="paytopubname" id="paytopubname">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label pr-0">Pay to Pub.
										ID</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" readonly name="paytosupplierid" id="paytosupplierid">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Address 1</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionaddress1" id="editionaddress1" oninput="inputtext(this)" maxlength="50">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Address 2</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionaddress2" id="editionaddress2" oninput="inputtext(this)" maxlength="50">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Address 3</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionaddress3" id="editionaddress3" oninput="inputtext(this)" maxlength="50">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">City</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editioncity" id="editioncity" oninput="inputtext(this)" maxlength="20">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">State</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionstate" id="editionstate" oninput="inputtext(this)" maxlength="20">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">STD Code</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionstdcode" id="editionstdcode" oninput="inputint(this)"  maxlength="8">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Pin Code</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionpin" id="editionpin" oninput="inputint(this)" maxlength="8">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Phone</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionphone" id="editionphone" oninput="inputint(this)" maxlength="11">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Phone Ext.</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionextension" id="editionextension" oninput="inputint(this)" maxlength="5">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">FAX</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionfax" id="editionfax" oninput="inputint(this)" maxlength="13">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Email</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionemail" id="editionemail" maxlength="32">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Brn. Cnt. Person</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="branchcontactperson" id="branchcontactperson" oninput="inputtext(this)" maxlength="50">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Brn. Cnt. Email</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="branchcontactemail" id="branchcontactemail" maxlength="32">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Edt. Format</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="editionformat" id="editionformat" oninput="inputtext(this)" maxlength="10">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Lensmem. No.</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="iensmembershipnumber" id="iensmembershipnumber" oninput="inputtext(this)" maxlength="16">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Abcmem. No.</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="abcmembershipnnumber" id="abcmembershipnnumber" oninput="inputtext(this)" maxlength="16">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Region</label>
									<div class="col-sm-8">
										<input type="text" class="form-control" name="region" id="region" oninput="inputtext(this)" maxlength="5">
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4"> </label>
									<div class="col-sm-8">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" class="custom-control-input"
												name="isactive" id="isactive"> <label
												class="custom-control-label mtop-2" for="isactive">Active</label>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Edt. Short Name</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" name="editionshortname" id="editionshortname"  oninput="inputtext(this)" maxlength="3">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label pr-0">State Short	Name</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" name="editionstateshortname" id="editionstateshortname" oninput="inputtext(this)" maxlength="3">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Pub. Cir.</label>
									<div class="col-sm-5">
										<input type="text" class="form-control text-right" name="pubcirculation" id="pubcirculation" oninput="inputint(this)" maxlength="10">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">ABC Cir.</label>
									<div class="col-sm-5">
										<input type="text" class="form-control text-right" name="abccirculation" id="abccirculation" oninput="inputint(this)" maxlength="10">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label pr-0">NRS Cir.</label>
									<div class="col-sm-5">
										<input type="text" class="form-control text-right" name="nrscirculation" id="nrscirculation" oninput="inputint(this)" maxlength="10">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Edt. No. Pages</label>
									<div class="col-sm-5">
										<input type="text" class="form-control text-right" name="editionnoofpages" id="editionnoofpages" oninput="inputint(this)" maxlength="3">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Established In</label>
									<div class="col-sm-5">
										<input type="text" class="form-control text-right" name="establishedin" id="establishedin" oninput="inputint(this)" maxlength="4">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">News Stand Dt.</label>
									<div class="col-sm-5">
										<input type="text" class="form-control text-right" name="newsstanddate" id="newsstanddate" oninput="inputint(this)" maxlength="2">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="form-group row">
									<label class="col-sm-4 col-form-label">Cover Dt.</label>
									<div class="col-sm-5">
										<input type="text" class="form-control text-right" name="coverdate" id="coverdate" oninput="inputint(this)" maxlength="2">
									</div>
									<div class="col-sm-3"></div>
								</div>
							</div>
						</div>
					</div>

					<div class="modal-footer" style="width: 100%;">
						<a href="#" onclick="saveDatatoGrid()"><span class=" badgeButton themeColor"><i class="fa fa-save"></i>Ok</span></a> 
						<a href="#" onclick="decMaxeditionid()" data-dismiss="modal"><span class=" badgeButton themeColor"><i class="fa fa-remove"></i>cancel</span></a>
					</div>

				</form>
			</div>
		</div>
	</div>

	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/core/libraries/jquery_ui/jquery-ui.min.js"	type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/core/app-menu.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/core/app.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/customizer.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/kendo/js/jszip.min.js"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/sweetalert.min.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/alert_custom.js" type="text/javascript"></script>
	<script src="../js/master/common.js" type="text/javascript"></script>
	<script src="../js/master/publication_edition/publication_edition_master_add.js" type="text/javascript"></script>

</body>
</html>