<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">

    <title>Channel Program Master </title>
    <script src="${serverurl}/mudralogin/assets/custom/js/mytheme.js"></script>    
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/ico/favicon.png">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <!-- <link rel="stylesheet" type="text/css" href="assets/css/import.css"> -->
    <link rel="stylesheet" type="text/css" href="${serverurl}/mudralogin/assets/css/import.css">

</head>

<body class="horizontal-layout horizontal-menu horizontal-menu-padding 2-columns   menu-expanded" data-open="hover" data-menu="horizontal-menu"
    data-col="2-columns">
    <!--div class="preloader"></div-->

    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <script src="../assets/custom/js/header.js"></script>

    <script src="../assets/custom/js/menu.js"></script>
    <script language="javascript" type="text/javascript">
        document.getElementById('dm').className = "dropdown nav-item active";
        document.getElementById('dm-estimate').className = "nav-item active";
    </script>

    <!-- Horizontal navigation-->
    <!-- <div class="app-content content"> -->
    <div class="app-content container center-layout mt-0 pt-1">
        <div class="content-wrapper">
            <div class="content-body  ">
                <div class="card cardShape ">
                    <div class="card-header cardShape">
                        <h4 class="card-title">Channel Program Master View</h4>
                        <a class="heading-elements-toggle">
                            <i class="fa fa-ellipsis font-medium-3"></i>
                        </a>                        
                    </div>
                </div>

                <div class="card ">
                        <div class="row mt-1 mb-2">
                                <div class="col-lg-2 col-md-2 col-xs-3 col-sm-4 more-padding">
                                    <div class="form-group">
                                        <label>Job Type</label>
                                        <input id="jobtypecombo" placeholder="Select Job Type" style="width: 100%;" class="form-control"/>
                                    </div>
                                </div>
								<div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
                                    <div class="form-group">
                                        <label>Select Channel</label>
                                        <input id="channelcombo" placeholder="Select Channel" style="width: 100%;" class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
                                    <div class="form-group">
                                            <label>Program Name</label>
                                        <input id="programnamecombo" placeholder="Select Program Name" style="width: 100%;" class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
                                  <div class="form-group">
                                            <label>Language</label>
                                        <input id="languagecombo" placeholder="Select Language" style="width: 100%;" class="form-control"/>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-xs-2 col-sm-4 more-padding">
                                        <div class="form-group">
                                            <label>Status</label>
                                            <input id="channelstatus" placeholder="Select Status" style="width: 100%;" class="form-control"/>
                                        </div>
                                    </div>
                                <div class="col-lg-1 col-md-1 col-xs-1 col-sm-4 more-padding">
                                    <div class="form-group mt-2">
                                        <a  href="#" ><span class="float-right badgeButton themeColor" ><i class="fa fa-search"></i> Search</span></a>
                                    </div>
                                </div>
                        </div>
                        <div class="row mt-0 mb-0">
                                <div id="channellistgrid" style="width: 100%;"></div>                            
                        </div>
                </div>
        </div>
    </div>    
    </div>

    <script src="../assets/custom/js/footer.js"></script>

    <script src="${serverurl}/mudralogin/assets/vendors/js/vendors.min.js" type="text/javascript"></script>

    <script src="${serverurl}/mudralogin/assets/vendors/js/ui/jquery.sticky.js"></script>    

    <script src="${serverurl}/mudralogin/assets/js/core/app-menu.js" type="text/javascript"></script>
    <script src="${serverurl}/mudralogin/assets/js/core/app.js" type="text/javascript"></script>
    <script src="${serverurl}/mudralogin/assets/js/scripts/customizer.js" type="text/javascript"></script>    

    <script src="${serverurl}/mudralogin/assets/kendo/js/kendo.all.min.js"></script>
    <script src="${serverurl}/mudralogin/assets/kendo/js/jszip.min.js"></script>
    
    <script src="../js/master/channel_program/list_channel.js" ></script>
</body>

</html>