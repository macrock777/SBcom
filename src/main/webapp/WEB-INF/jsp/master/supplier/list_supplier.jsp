<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">

<!-- 203.88.135.41 -->
<!-- 192.168.168.27 -->

<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
   <title>Supplier Master </title>
   <script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/mytheme.js"></script>    
   <link rel="shortcut icon" type="image/x-icon" href="assets/images/ico/favicon.png">
   <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="${sessionScope.serverpath}/mudralogin/assets/css/import.css">
   <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700" rel="stylesheet">
   <link rel="stylesheet" href="${sessionScope.serverpath}/mudralogin/assets/css/import.css" /> 	
   <link rel="stylesheet" type="text/css" href="${sessionScope.serverpath}/mudralogin/assets/alert_custom/css/sweetalert.css">
   <link rel="stylesheet" type="text/css" href="${sessionScope.serverpath}/mudralogin/assets/alert_custom/css/alert_custom.css" />
   <script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/vendors.min.js" type="text/javascript"></script>
   <script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/ui/jquery.sticky.js" type="text/javascript" ></script>
   <script src="${sessionScope.serverpath}/mudralogin/assets/kendo/js/kendo.all.min.js"></script>
</head>

<body class="horizontal-layout horizontal-menu horizontal-menu-padding 2-columns   menu-expanded" data-open="hover" data-menu="horizontal-menu"
    data-col="2-columns">
    <div class="animation"><div style="display: none;" id="before_form"></div></div>
    <script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/header.js"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/menufas.js"></script>
    
   <script type="text/javascript">
        document.getElementById('5201').className = "dropdown nav-item active"
        document.getElementById('8020').className = "dropdown dropdown-submenu active";
        document.getElementById('5202').className = "nav-item active";

    </script>

    <!-- Horizontal navigation-->
    <!-- <div class="app-content content"> -->
	<div class="app-content container center-layout mt-0 pt-1">
		<div class="content-wrapper">
			<div class="content-body  ">

				<form name="mainForm" id="mainForm">

					<input type="hidden" name="supplieridhd" id="supplieridhd">
					<input type="hidden" name="suppliereditflag" id="suppliereditflag">
					<div class="card cardShape ">
						<div class="card-header cardShape">
							<h4 class="card-title">Supplier Master</h4>
							<a class="heading-elements-toggle"> <i
								class="fa fa-ellipsis font-medium-3"></i>
							</a>
						</div>
					</div>

					<div class="card ">
						<div class="row mt-1 mb-2">

							<div class="col-lg-2 col-md-2 col-xs-3 col-sm-4 more-padding">
								<div class="form-group">
									<label>Supplier Group</label> <input id="suppliergrp"
										style="width: 100%;" class="form-control" />
								</div>
							</div>
							<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
								<div class="form-group">
									<label>Supplier</label> <input id="supplierid"
										style="width: 100%;" class="form-control" />
								</div>
							</div>
							<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
								<div class="form-group">
									<label>Supplier Type</label> <input id="suppliertype"
										style="width: 100%;" class="form-control" />
								</div>
							</div>
							<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
								<div class="form-group">
									<label>PAN</label> <input id="supplierpan"
										placeholder="Search PAN" style="width: 100%;"
										class="form-control"
										oninput="toUpperCaseFn(this);this.value=this.value.replace(/[^A-Za-z0-9]/g,'');"
										maxlength="10" />
								</div>
							</div>

							<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
								<div class="form-group">
									<label>Status</label> <input id="status" placeholder="Status"
										style="width: 100%;" class="form-control" />
								</div>
							</div>
							<div class="col-lg-1 col-md-1 col-xs-1 col-sm-4 more-padding">
								<div class="form-group mt-2">
									<a href="#" onclick="searchFn()"><span
										class="float-right badgeButton themeColor"><i
											class="fa fa-search"></i> Search</span></a>
								</div>
							</div>
						</div>
						<div class="row mt-0 mb-0">
							<div id="suppliergrid"></div>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>

	<script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/footer.js"></script>  
    <script src="${sessionScope.serverpath}/mudralogin/assets/custom/js/footer.js"></script> 
    <script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.js" type="text/javascript"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.date.js" type="text/javascript"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/picker.time.js" type="text/javascript"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/pickadate/legacy.js" type="text/javascript"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/vendors/js/pickers/dateTime/moment-with-locales.min.js" type="text/javascript"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/js/core/app.js" type="text/javascript"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/customizer.js" type="text/javascript"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/kendo/js/jszip.min.js"></script>
    <script src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/sweetalert.min.js" type="text/javascript"></script>
	<script src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/alert_custom.js" type="text/javascript"></script>
    <script type="text/javascript" src="../js/master/supplier/list_supplier.js" ></script>
   
</body>

</html>