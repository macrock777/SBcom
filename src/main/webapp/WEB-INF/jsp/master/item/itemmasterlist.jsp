<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
	<title>Item Master</title>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/custom/js/mytheme.js"></script>
	<link rel="shortcut icon" type="image/x-icon" href="assets/images/ico/favicon.png">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700"	rel="stylesheet">
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
	<script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/header.js"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/custom/js/menufas.js"></script>
	<script language="javascript" type="text/javascript">
        document.getElementById('dm').className = "dropdown nav-item active";
        document.getElementById('dm-estimate').className = "nav-item active";
    </script>
	<div class="app-content container center-layout mt-0 pt-05">
		<div class="content-wrapper">
			<div class="content-body  ">
				<div class="card cardShape ">
					<div class="card-header cardShape">
						<h4 class="card-title">Item Master View</h4>
						<a class="heading-elements-toggle"> <i
							class="fa fa-ellipsis font-medium-3"></i>
						</a>
					</div>
				</div>
				<div class="card ">
					<div class="row mt-1 mb-2">
						<div class="col-lg-2 col-md-2 col-xs-3 col-sm-4 more-padding">
							<div class="form-group">
								<label>Group Item Code</label> <input id="groupitemcodeid"
									style="width: 100%;" class="form-control" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
							<div class="form-group">
								<label>Item Type</label> <input id="itemtypeid"
									style="width: 100%;" class="form-control" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
							<div class="form-group">
								<label>Status</label> <input id="itemstatus"
									placeholder="Select Status" style="width: 100%;"
									class="form-control" />
							</div>
						</div>
						<div class="col-lg-1 col-md-1 col-xs-1 col-sm-4 more-padding">
							<div class="form-group mt-2">
								<a href="#" onclick="searchData()"><span
									class="float-right badgeButton themeColor"><i
										class="fa fa-search"></i> Search</span></a>
							</div>
						</div>
					</div>
					<div class="row mt-0 mb-0">
						<div id="itemlistgrid" style="width: 100%;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="itemmasteradd" tabindex="-1" role="dialog" data-keyboard="false" data-backdrop="static"
		aria-labelledby="cgstin-label" aria-hidden="true">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content cardShape">
				<form class="form-horizontal">
					<div class="modal-header cardShape">
						<h5 class="modal-title" id="cgstin-label">Item Master</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Group Item Code <span
								class="required danger"> *</span></label>
							<div class="col-sm-4">
								<input id="groupitemcode" name="groupitemcode"
									style="width: 100%;" />
							</div>
							<label class="col-sm-2 col-form-label">Item Code <span
								class="required danger"> *</span></label>
							<div class="col-sm-4">
								<input type="text" class="form-control text-right text-uppercase"
									name="itemcode" id="itemcode" maxlength="32">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Item Type</label>
							<div class="col-sm-4">
								<input id="stockoreservice" name="stockoreservice"
									placeholder="Select Item Type" style="width: 100%;" />
							</div>
							<label class="col-sm-2 col-form-label">Income GLcode <span
								class="required danger"> *</span></label>
							<div class="col-sm-4">
								<input id="incomeglcode" name="incomeglcode"
									style="width: 100%;" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Unit</label>
							<div class="col-sm-4">
								<input id="defaultunit" name="defaultunit"
									placeholder="Select Unit" style="width: 100%;" />
							</div>
							<label class="col-sm-2 col-form-label">Expense GLcode <span
								class="required danger"> *</span></label>
							<div class="col-sm-4">
								<input id="expenseglcode" name="expenseglcode"
									style="width: 100%;" />
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Item Description</label>
							<div class="col-sm-6">
								<input type="text" class="form-control text-uppercase" name="itemdescription"
									id="itemdescription" maxlength="64">
							</div>
							<div class="col-sm-4"></div>
						</div>
					</div>
					<div class="modal-footer" style="width: 100%;">
						<a href="#" onclick="saveItemData()"><span
							class=" badgeButton themeColor"><i class="fa fa-save"></i>
								Save</span></a> <a href="#" class="disabled"><span
							class=" badgeButton themeColor"><i class="fa fa-refresh"></i>
								ROUTE</span></a> <a href="#" class="disabled"><span
							class=" badgeButton themeColor"><i class="fa fa-undo"></i>
								UNDO</span></a> <a href="#" data-dismiss="modal"><span
							class=" badgeButton themeColor"><i class="fa fa-remove"></i>
								cancel</span></a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/custom/js/footer.js"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/core/libraries/jquery_ui/jquery-ui.min.js"	type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.date.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.time.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/legacy.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/dateTime/moment-with-locales.min.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/daterange/daterangepicker.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/core/app-menu.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/core/app.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/customizer.js"	type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/pickers/dateTime/pick-a-datetime.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/kendo/js/jszip.min.js"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/sweetalert.min.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/alert_custom.js" type="text/javascript"></script>
	<script src="../js/master/common.js" type="text/javascript"></script>
	<script src="../js/master/item/itemmaster.js" type="text/javascript"></script>
	<script>
        $(document).bind("DOMSubtreeModified", function(){
			$('.k-select').addClass('themeColor');
        });
    </script>
</body>
</html>