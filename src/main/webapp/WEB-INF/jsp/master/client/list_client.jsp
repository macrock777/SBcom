<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">

    <title>Client Master</title>
    <script src="../assets/custom/js/mytheme.js"></script>
    <link rel="shortcut icon" type="image/x-icon" href="${serverurl}/mudralogin/assets/images/ico/favicon.png">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700" rel="stylesheet">
    
    <link rel="stylesheet" href="${serverurl}/mudralogin/assets/css/import.css" />
    
    	
    <script src="${serverurl}/mudralogin/assets/vendors/js/vendors.min.js" type="text/javascript"></script>
    
    <script src="${serverurl}/mudralogin/assets/vendors/js/ui/jquery.sticky.js" type="text/javascript" ></script>
    <script src="${serverurl}/mudralogin/assets/kendo/js/kendo.all.min.js"></script>
</head>

<body class="horizontal-layout horizontal-menu horizontal-menu-padding 2-columns   menu-expanded" data-open="hover" data-menu="horizontal-menu"
    data-col="2-columns">
    <!--div class="preloader"></div-->

	<div class="animation"><div style="display: none;" id="before_form"></div></div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <script src="../assets/custom/js/header.js"></script>

    <script src="../assets/custom/js/menu.js"></script>
    <script type="text/javascript">
        document.getElementById('5101').className = "dropdown nav-item active";
        document.getElementById('5853').className = "dropdown dropdown-submenu active";
        document.getElementById('5102').className = "nav-item active";
    </script>



    <!-- Horizontal navigation-->
    <div class="app-content container center-layout mt-1">
        <div class="content-wrapper">
            <div class="content-body  ">
            	<form name="mainForm" id="mainForm">
            		<input type="hidden" id="clientid" name="clientid" >
	                <div class="card cardShape ">
	                    <div class="card-header cardShape">
	                        <h4 class="card-title">Client Master</h4>
	                        <a class="heading-elements-toggle">
	                            <i class="fa fa-ellipsis font-medium-3"></i>
	                        </a>
	                    </div>
	
	
	                </div>
	
	                <div class="card ">
	                        <div class="row mt-1 mb-2" id="normal">
	                                <div class="col-lg-3 col-md-3 col-xs-3 col-sm-4 more-padding">
	                                    <div class="form-group">
	                                        <label for="projectinput1">Client Group</label>
	                                        <input id="clientgroupid" placeholder="Select client group name..." style="width: 100%;" class="form-control"/>
	                                    </div>
	                                </div>
									  <div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
	                                    <div class="form-group">
	                                        <label for="projectinput1">Client </label>
	                                        <input id="searchclientid" placeholder="Select client name" style="width: 100%;" class="form-control"/>
	                                    </div>
	                                </div>
	                                <div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
	                                    <div class="form-group">
	                                        <label for="projectinput1">PAN</label>
	                                        <input id="pannumber" maxlength="20" placeholder="Enter pan number..." style="width: 100%;" class="form-control"/>
	                                    </div>
	                                </div>
	                                
	                                <div class="col-lg-1 col-md-1 col-xs-1 col-sm-4 more-padding">
	                                        <div class="form-group">
	                                            <label for="projectinput1">Status</label>
	                                            <input id="status" placeholder="Status..." style="width: 100%;" class="form-control"/>
	                                        </div>
	                                </div>
	
	
	                                <div class="col-lg-1 col-md-1 col-xs-1 col-sm-4 more-padding">
	                                    <div class="form-group mt-2">
	                                        <a  href="#" ><span class="float-right badgeButton themeColor" onclick="searchFn()" ><i class="fa fa-search"></i> Search</span></a>
	                                    </div>
	                                </div>
	                                 
	                            </div>
	                    
	                </div>
	
	                <div class="row mt-0 mb-2">
	                    <div id="example " style="width: 100%;">
	                        <div id="grid"></div>	
	                    </div>
	                </div>
                </form>
            </div>
        </div>
    </div>

    <script src="../assets/custom/js/footer.js"></script>

    <script src="${serverurl}/mudralogin/assets/vendors/js/pickers/pickadate/picker.js" type="text/javascript"></script>
    <script src="${serverurl}/mudralogin/assets/vendors/js/pickers/pickadate/picker.date.js" type="text/javascript"></script>
    <script src="${serverurl}/mudralogin/assets/vendors/js/pickers/pickadate/picker.time.js" type="text/javascript"></script>
    <script src="${serverurl}/mudralogin/assets/vendors/js/pickers/pickadate/legacy.js" type="text/javascript"></script>
    <script src="${serverurl}/mudralogin/assets/vendors/js/pickers/dateTime/moment-with-locales.min.js" type="text/javascript"></script>

    <script src="${serverurl}/mudralogin/assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${serverurl}/mudralogin/assets/js/core/app.js" type="text/javascript"></script>
    <script src="${serverurl}/mudralogin/assets/js/scripts/customizer.js" type="text/javascript"></script>
 
    <script src="${serverurl}/mudralogin/assets/kendo/js/jszip.min.js"></script>
    
    <script src="../js/master/client/list_client.js" ></script>

</body>

</html>