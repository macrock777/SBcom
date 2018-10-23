<!DOCTYPE html>
<html lang="en" data-textdirection="LTR" class="loading">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Usermaster | Demo Spring</title>

     <link rel="stylesheet" href="resources/app-assets/css/bootstrap.css"/>
    <!-- BEGIN VENDOR CSS-->
    <!-- BEGIN Font icons-->
    <link rel="stylesheet" type="text/css" href="resources/app-assets/fonts/icomoon.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/fonts/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/forms/icheck/icheck.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/forms/icheck/custom.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/ui/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/forms/selects/select2.min.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/extensions/toastr.css">
    <!-- END Font icons-->
    <!-- BEGIN Plugins CSS-->
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/sliders/slick/slick.css">
    <!-- END Plugins CSS-->
   <!-- BEGIN Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/tables/datatable/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/tables/extensions/rowReorder.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/tables/extensions/responsive.dataTables.min.css">
    <!-- END Vendor CSS-->
    <!-- BEGIN Vendor CSS-->
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/ui/prism.min.css">
    <!-- END Vendor CSS-->
    <!-- BEGIN ROBUST CSS-->
    <link rel="stylesheet" type="text/css" href="resources/app-assets/css/core/menu/menu-types/horizontal-menu.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/css/core/menu/menu-types/vertical-overlay-menu.css">
    <link rel="stylesheet" type="text/css" href="resources/app-assets/vendors/css/extensions/sweetalert.css">
    <link rel="stylesheet" href="resources/assets/css/app.min.css"/>
    <link rel="stylesheet" type="text/css" href="resources/assets/css/style.css">
    
     
    
    
    
  </head>
   
   
  <body data-open="hover" data-menu="horizontal-menu" data-col="2-columns" class="horizontal-layout horizontal-menu  2-columns  fixed-navbar">
   
   <!-- <div class="animation"><div id="before_form"></div></div> -->
   
			<script language="javascript" type="text/javascript">
	 				//document.getElementById("master").className="dropdown nav-item active";
					//document.getElementById("usermaster").style.backgroundColor="#a7daed85";
			</script> 
			
    <!-- Horizontal navigation-->
    
    <form name ="mainform" id ="mainform">
		<input type ="hidden" name="byid" id="byid">	
		
    
    <div class="robust-content container-fluid center-layout mt-2 mb-2">
      <div class="content-wrapper">
        
        <div class="content-body"><!-- Basic initialization -->
<section id="initialization">
	<div class="row">
		<div class="col-xs-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">User Master</h4>
					<a class="heading-elements-toggle"><i class="icon-ellipsis font-medium-3"></i></a>
					<div class="heading-elements">
						 <div class="content-header-right text-md-right col-md-12 col-xs-12">
            					<a href="newuser"  class="ui-button ui-widget ui-corner-all btn-info borderbtn anchor-button">User <span class="ui-icon icon-android-add"></span></a>
          				</div>
					</div>
				</div>
				<div class="card-body collapse in">
					<div class="card-block card-dashboard">
                    <div class="table-responsive">
                                <table id="myTable" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>User Id</th>
									<th>User Name</th>
									<th>User Type</th>
									<th>Email</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
							</tbody>
							<tfoot>
								<tr>
									<th>User Id</th>
									<th>User Name</th>
									<th>User Type</th>
									<th>Email</th>
									<th>Action</th>
								</tr>
							</tfoot>
                                </table>
                            </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/ Basic initialization -->
        </div>
      </div>
    </div>					
	</form>						

   <!-- BEGIN VENDOR JS-->
    <script src="resources/app-assets/js/core/libraries/jquery.min.js"></script>
   
    <!-- BEGIN VENDOR JS-->
    <script src="resources/app-assets/vendors/js/ui/tether.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/js/core/libraries/bootstrap.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/ui/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/ui/unison.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/ui/blockUI.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/ui/jquery.matchHeight-min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/ui/jquery-sliding-menu.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/sliders/slick/slick.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/ui/screenfull.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/extensions/pace.min.js" type="text/javascript"></script>
    <!-- BEGIN PAGE VENDOR JS-->
    <script type="text/javascript" src="resources/app-assets/vendors/js/ui/jquery.sticky.js"></script>
    <script type="text/javascript" src="resources/app-assets/vendors/js/ui/prism.min.js"></script>
    <!-- END PAGE VENDOR JS-->
    <script src="resources/app-assets/vendors/js/tables/jquery.dataTables.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/tables/datatable/dataTables.bootstrap4.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/tables/datatable/dataTables.responsive.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/tables/datatable/dataTables.rowReorder.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/forms/icheck/icheck.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/js/core/libraries/jquery_ui/jquery-ui.min.js" type="text/javascript"></script>
    <script src="resources/app-assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>
    <script src="resources/app-assets/vendors/js/forms/select/select2.min.js" type="text/javascript"></script>
     <script src="resources/app-assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="resources/app-assets/js/core/app.js" type="text/javascript"></script>
    <script src="resources/app-assets/js/scripts/ui/fullscreenSearch.js" type="text/javascript"></script>
    <script src="resources/app-assets/js/scripts/pages/project-task-list.js" type="text/javascript"></script>
    <script src="resources/app-assets/js/scripts/extensions/toastr.js" type="text/javascript"></script>
    
    <!--<script src="resources/app-assets/js/core/app.min.js"></script>
    <script src="resources/app-assets/js/scripts/tables/datatables-extensions/datatable-rowreorder.js" type="text/javascript"></script>-->
     <script src="resources/app-assets/vendors/js/extensions/sweetalert.min.js" type="text/javascript"></script>
    <script src="resources/assets/js/scripts.js" type="text/javascript"></script> 
      <!--Custom JS  -->
	 
    
     
     <script>
        $(document).ready(function () {
	              $(document).ready(function () {
		            $("#myTable").dataTable( {
				        "bProcessing": false,
				        "bServerSide": false,
				        "sort": "position",
				        "bStateSave": false,
				        "iDisplayStart": 0,
				        "fnDrawCallback": function () {
				        }, 
				        "sAjaxSource": "userdata",
				        "aoColumns":  [
					        		{ "data": "userid","defaultContent": ""},
						           	{ "data": "username","defaultContent": ""},
						           	{ "data": "usertype","defaultContent": ""},					           	
						           	{ "data": "email","defaultContent": ""},					           	
									{ "data": "action","defaultContent": ""}
					        ],
					        columnDefs: [
   								{ orderable: false, targets: [-1,-3] },
   								{"className": "text-md-center", targets:-3}
							]
				    } );
        	});
        	
        	 $('.show-tooltip-animation').hover(function(){
		        	$(".show-tooltip-animation").tooltip();	
				});   

        });
        
        

       			 /* "initComplete": function( settings, json ) {
							$.getScript("app-assets/js/scripts/ui/jquery-ui/dialog-tooltip.js",function(data,textStatus,jqxhr){
								console.log(data);	// Data returned
								console.log(textStatus);	//Success
								console.log(jqxhr.status);	//200
								console.log("Load was Performed");
							});   
					  },      */
        
    </script>


    
  </body>
</html>