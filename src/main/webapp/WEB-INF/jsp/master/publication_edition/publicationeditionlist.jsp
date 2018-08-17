<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">

    <title>Publication-Edition Master </title>
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
	<!--div class="preloader"></div-->

	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<script src="../assets/custom/js/header.js"></script>

	<script src="../assets/custom/js/menu.js"></script>
	<script language="javascript" type="text/javascript">
		document.getElementById('dm').className = "dropdown nav-item active";
		document.getElementById('dm-ro').className = "dropdown dropdown-submenu active";
		document.getElementById('dm-ro-bulk').className = "active";
	</script>

	<!-- Horizontal navigation-->
	<!-- <div class="app-content content"> -->
	<div class="app-content container center-layout mt-0 pt-1">
		<div class="content-wrapper">
			<div class="content-body  ">
				<div class="card cardShape ">
					<div class="card-header cardShape">
						<h4 class="card-title">Publication-Edition Master View</h4>
						<a class="heading-elements-toggle"> <i
							class="fa fa-ellipsis font-medium-3"></i>
						</a>
					</div>
				</div>

				<div class="card ">
					<div class="row mt-1 mb-2" id="normal">
						<div class="col-lg-2 col-md-2 col-xs-3 col-sm-4 more-padding">
							<div class="form-group">
								<label for="projectinput1">Supplier Group</label> <input
									name="suppliergroup" id="suppliergroup"
									placeholder="Select Supplier Group" style="width: 100%;"
									class="form-control" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-xs-3 col-sm-4 more-padding">
							<div class="form-group">
								<label for="projectinput1">Publication</label> <input
									name="suppliergroup" id="publication"
									placeholder="Select Publication" style="width: 100%;"
									class="form-control" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
							<div class="form-group">
								<label for="projectinput1">Edition</label> <input name="edition"
									id="edition" placeholder="Select Edition" style="width: 100%;"
									class="form-control" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
							<div class="form-group">
								<label for="projectinput1">Language</label> <input
									name="language" id="language" placeholder="Select Language"
									style="width: 100%;" class="form-control" />
							</div>
						</div>
						<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
							<div class="form-group">
								<label for="projectinput1">Status</label> <input name="isactive"
									id="isactive" placeholder="Select Status" style="width: 100%;"
									class="form-control" />
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
						<div id="publicationgrid" style="width: 100%;"></div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<form name="publicationeditionform" id="publicationeditionform" method="post">
		<input type="hidden" name="supplierid" id="supplierid">
		<input type="hidden" name="suppliername" id="suppliername">
	</form>
	<%-- <script	src="${sessionScope.serverpath}/mudralogin/assets/custom/js/footer.js"></script> --%>
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
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/customizer.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/js/scripts/pickers/dateTime/pick-a-datetime.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/kendo/js/jszip.min.js"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/sweetalert.min.js" type="text/javascript"></script>
	<script	src="${sessionScope.serverpath}/mudralogin/assets/alert_custom/js/alert_custom.js" type="text/javascript"></script>
	<script src="../js/master/common.js" type="text/javascript"></script>
	<script	src="../js/master/publication_edition/publication_edition_masterlist.js" type="text/javascript"></script>
	<script>
        $(document).bind("DOMSubtreeModified", function(){
						$('.k-select').addClass('themeColor');
					});
        
        
        
        $(document).ready(function() {
            
            
        $("#cord").kendoComboBox({
                dataTextField: "text",
                dataValueField: "value",
                dataSource: [
                    { text: "Harshad Chauhan", value: "1" },
                    { text: "Vishal Prajapati", value: "2" },
                    { text: "Shailesh Trivedi", value: "3" },
                    { text: "Sunil Solanki", value: "4" }
                ],
                filter: "contains",
                suggest: true,
                index: -1
            });
            
        $("#campaign").kendoComboBox({
                dataTextField: "text",
                dataValueField: "value",
                dataSource: [
                    { text: "Adani Foundation", value: "1" },
                    { text: "BARC India", value: "2" },
                    { text: "Cirrus Media", value: "3" },
                    { text: "DDB Mudra Group", value: "4" }
                ],
                filter: "contains",
                suggest: true,
                index: -1
            });                        
            
        var optional = $("#campaigndata").kendoMultiSelect({
                    autoClose: false,tagMode: "single"
                }).data("kendoMultiSelect");
        
        $("#jobno").kendoComboBox({
                dataTextField: "text",
                dataValueField: "value",
                dataSource: [
                    { text: "Printing / J0001", value: "1" },
                    { text: "Publishing / J0002", value: "2" },
                    { text: "Media / J0003", value: "3" }
                ],
                filter: "contains",
                suggest: true,
                index: -1
            });
            
        $("#supest").kendoComboBox({
                dataTextField: "text",
                dataValueField: "value",
                dataSource: [
                    { text: "Yes", value: "1" },
                    { text: "No", value: "2" }
                ],
                filter: "contains",
                suggest: true,
                index: -1
            });
            
        $("#jobcat").kendoComboBox({
                dataTextField: "text",
                dataValueField: "value",
                dataSource: [
                    { text: "Printing", value: "1" },
                    { text: "Publishing", value: "2" }
                ],
                filter: "contains",
                suggest: true,
                index: -1
            });
                
        $("#stmduty").kendoComboBox({
                dataTextField: "text",
                dataValueField: "value",
                dataSource: [
                    { text: "Y", value: "1" },
                    { text: "N", value: "2" }
                ],
                filter: "contains",
                suggest: true,
                index: -1
            });
        
        function resizeGrid(a,b) {
                var gridElement = $("#grid");
                var dataArea = gridElement.find(".k-grid-content");
                //alert("Yes");
                /*var newHeight = gridElement.parent().innerHeight() - 2;
                var diff = gridElement.innerHeight() - dataArea.innerHeight();
                gridElement.height(newHeight);
                dataArea.height(newHeight - diff);*/
                
                gridElement.height(a);
                dataArea.height(b);
                
                //dataArea.height(500);
                }
            
        $('.collapse').on("hidden.bs.collapse", function(){resizeGrid(400,301.9);});//.fadeIn( "slow" );
        $('.collapse').on("shown.bs.collapse", function(){resizeGrid(200,101.9);});//.fadeIn( "fast" );                
                        
                                   
            
        $('#publicationgrid > div.k-grid-content.k-auto-scrollable > table > tbody > tr:nth-child(1) > td.k-command-cell > a').on('click',function(){
              window.location.href='publication_master_add.html';
        });
            
        });
      
    </script>

</body>

</html>