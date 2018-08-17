<!DOCTYPE html>
<html class="loading" lang="en" data-textdirection="ltr">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">

    <title>Channel Program Master | ADD</title>
    <script src="${serverurl}/mudralogin/assets/custom/js/mytheme.js"></script>    
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/ico/favicon.png">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Muli:300,400,500,700" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="${serverurl}/mudralogin/assets/css/import.css">
    
</head>

<body class="horizontal-layout horizontal-menu horizontal-menu-padding 2-columns   menu-expanded"
data-open="hover" data-menu="horizontal-menu" data-col="2-columns">

<!-- Horizontal navigation-->
<!-- <div class="app-content content"> -->
  <div class="app-content container center-layout mt-0 pt-1">
    <div class="content-wrapper">
        <div class="content-body">
            <form class="form-horizontal">
            <div class="card cardShape">
			<div class="card-header cardShape">
                  <h4 class="card-title">Channel Program Master</h4>
                  <a class="heading-elements-toggle"><i class="ft-ellipsis-h font-medium-3"></i></a>
                  <div class="heading-elements">
                    <ul class="list-inline mb-0">
                      <li><a data-action="collapse" id="showdtail"><i class="ft-minus text-white"></i></a></li>
					  <li><a href="channellist.html"><i class="fa fa-chevron-left text-white"></i></a></li>     
                    </ul>
                  </div>
                </div>           

                <div class="card-content collapse show">
                    <div class=" mt-07">                            
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group row">
										  <label class="col-sm-4 col-form-label">Channel</label>
										  <div class="col-sm-3">
								            <input type="text" class="form-control" placeholder="" name="addchannelid" id="addchannelid">
										  </div>
                                          <div class="col-sm-5">
								            <input type="text" class="form-control" placeholder="" name="addchannelname" id="addchannelname">
										  </div>
									</div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group row">
										  <label class="col-sm-4 col-form-label">Channel Group</label>
										  <div class="col-sm-8">
								            <input id="addchannelgroup" placeholder="Select Channel Group" style="width: 100%;"/>
										  </div>
                                          
									</div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Contract Supplier</label>
										  <div class="col-sm-8">
								            <input id="addcontractgroup" placeholder="Select Contract Supplier" style="width: 100%;"/>
										  </div>
                                    </div>
                                </div>                                
                            </div>
                            	
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group row">
										  <label class="col-sm-4 col-form-label">Channel Type</label>
										  <div class="col-sm-8">
								            <input id="addchanneltype" placeholder="Select Channel Type" style="width: 100%;" />
										  </div>										  
									</div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group row">
                                        <div class="col-sm-6">
								            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input" name="newradiockbox" id="newradiockbox">
                                                <label class="custom-control-label mtop-2" for="newradiockbox">New Radio Module Channel</label>
                                            </div>
										  </div>										  
									</div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Language</label>
										  <div class="col-sm-8">
								            <input id="addlanguage" placeholder="Select Language" style="width: 100%;"/>
										  </div>	  
                                </div>
                                </div>
                            </div>
                        
                            <div class="row">                                                                
                                <div class="col-md-4">
                                    <div class="form-group row">
										  <label class="col-sm-4 col-form-label">Prime Time 1</label>
										  <div class="col-sm-3">
								            <input type="text" class="form-control text-right" placeholder="" name="addprimetime1" id="addprimetime1">
										  </div>
                                          <label class="col-sm-2 col-form-label text-center">To</label>
                                          <div class="col-sm-3">
								            <input type="text" class="form-control text-right" name="addprimetime1to" id="addprimetime1to">
										  </div>                                          
									</div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group row">
										  <label class="col-sm-4 col-form-label">Prime Time 2</label>
										  <div class="col-sm-3">
								            <input type="text" class="form-control text-right" placeholder=""name="addprimetime2" id="addprimetime2">
										  </div>
                                          <label class="col-sm-2 col-form-label text-center">To</label>
                                          <div class="col-sm-3">
								            <input type="text" class="form-control text-right" name="addprimetime2to" id="addprimetime2to">
										  </div>                                          
									</div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group row">
										  <label class="col-sm-4 col-form-label">Lead Time</label>
										  <div class="col-sm-4">
								            <input type="text" class="form-control text-right" placeholder="" name="addleadtime" id="addleadtime">
										  </div>
                                          <label class="col-sm-4 col-form-label text-left">(Days for material)</label>
                                </div>
                                </div>
                            </div>
                                    
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group row">
										  <label class="col-sm-4 col-form-label">TAM Code</label>
										  <div class="col-sm-8">
								            <input type="text" class="form-control" placeholder="" name="addtamchnabr" id="addtamchnabr">
										  </div>                                          
									</div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group row">										 
                                          <label class="col-sm-4 col-form-label">Exp GL Code</label>
										  <div class="col-sm-8">
								            <input id="addexpglcode" placeholder="Select Exp GL Code" style="width: 100%;"/>
										  </div>
									</div>
                                </div>
                                
                                <div class="col-md-4">
                                    <div class="form-group row">										 
                                          <label class="col-sm-4 col-form-label">Income GL Code</label>
										  <div class="col-sm-8">
								            <input id="addincomeglcode" placeholder="Select Income GL Code" style="width: 100%;"/>
										  </div>
									</div>
                                </div>
                            </div>
                                                        
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group row">										  
                                          <label class="col-sm-4 col-form-label">TDS GL Code</label>
										  <div class="col-sm-8">
								            <input id="addtdsglcode" placeholder="Select TDS GL Code" style="width: 100%;"/>
										  </div> 
									</div> 
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group row">										  
                                          <label class="col-sm-4 col-form-label">Channel Logo</label>
										  <div class="col-sm-7">
                                              <label id="projectinput7" class="file center-block">
                                                    <input type="file" id="file">
                                                    <span class="file-custom"></span>
                                              </label>
										  </div>
                                          <div class="col-sm-1" style="margin-top: 3px;">
                                          <a href="#" rel="popover" data-img="${serverurl}/mudralogin/assets/images/efive/logo_blue.png">
                                            <span class="themeIconColor"><i class="fa fa-eye"></i></span>
                                          </a>
                                          </div>
									</div> 
                                </div>                                
                            </div>
                        
                            <div class="row mt-2" style="width: 100%; margin: 0.5rem 0rem;">
                            <div class="col-md-12">    
                                <h5 class="mb-0">Program Details</h5>
                            </div>
                            </div>
                            
                            <div class="row mt-0">					
                           <div id="programbasegrid" style="width: 100%;" ></div>
                        </div>                    
                    </div>
                </div>
            </div>
			
			     <div class=" mt-2 fixedBottom">				
							<div style="text-align:center">                            
                            <a  href="#"><span class=" badgeButton themeColor"><i class="fa fa-save"></i> Save</span></a>
							<a  href="#"><span class=" badgeButton themeColor"><i class="fa fa-refresh"></i> ROUTE</span></a>
							<a  href="#"><span class=" badgeButton themeColor"><i class="fa fa-undo"></i> UNDO</span></a>
							<a  href="#"><span class=" badgeButton themeColor"><i class="fa fa-envelope"></i> Call4<span class="text-uppercase">IT</span></span></a>
							</div>                                               
                    </div>
            </form>		
        </div>
    </div>
</div>

<script src="../assets/custom/js/footer.js"></script>    
    
<div class="modal fade" id="programadd" tabindex="-1" role="dialog" aria-labelledby="cgstin-label" aria-hidden="true">
                    <div class="modal-dialog modal-md" role="document">
                      <div class="modal-content cardShape">
                        <form class="form-horizontal">
                        <div class="modal-header cardShape">
                          <h5 class="modal-title" id="cgstin-label">Program Master</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
						  
                        </div>
                        <div class="modal-body">                          							
									<div class="form-group row">
										  <label class="col-sm-2 col-form-label">Channel ID</label>
										  <div class="col-sm-4">
								            <input type="text" class="form-control" placeholder="FUN" name="progchannelid" id="progchannelid" readonly>
										  </div>
                                          <label class="col-sm-2 col-form-label">Channel Name</label>
                                          <div class="col-sm-4">
								            <input type="text" class="form-control" placeholder="FUN KIDS" name="progchannelname" id="progchannelname" readonly>
										  </div>
									</div>
                                    
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Program Code</label>
										  <div class="col-sm-4">
								            <input type="text" class="form-control" placeholder="" name="progcode" id="progcode">
										  </div>
                                          <label class="col-sm-2 col-form-label">Program Name</label>
                                          <div class="col-sm-4">
								            <input type="text" class="form-control" placeholder="" name="progname" id="progchannelname">
										  </div>
									</div>
                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Days of Program</label>
										  <div class="col-sm-4">
								            <input type="text" class="form-control" placeholder="" name="daysofpro" id="daysofpro">
										  </div>
                                          <label class="col-sm-2 col-form-label">Category</label>
                                          <div class="col-sm-4">
								            <input id="addprogcat" placeholder="Select Category" style="width: 100%;"/>
										  </div>
									</div>
                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">From Date</label>
										  <div class="col-sm-4">
								            <fieldset class="form-group">							 
                                              <div class="input-group">
                                                <div class="input-group-prepend">
                                                  <span class="input-group-text"><i class="ft-calendar"></i></span>
                                                </div>
                                                <input type="text" class="form-control datepicker-default" name="progfromdate" id="progfromdate" />
                                              </div>
                                            </fieldset>
										  </div>
                                          <label class="col-sm-2 col-form-label">To Date</label>
                                          <div class="col-sm-4">
								            <fieldset class="form-group">							 
                                              <div class="input-group">
                                                <div class="input-group-prepend">
                                                  <span class="input-group-text"><i class="ft-calendar"></i></span>
                                                </div>
                                                <input type="text" class="form-control datepicker-default" name="progtodate" id="progtodate" />
                                              </div>
                                            </fieldset>
										  </div>
									</div>
                            
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">Telecast Time</label>
										  <div class="col-sm-2">
								            <input type="text" class="form-control text-right" placeholder="" name="progteletime" id="progteletime">                                            
										  </div>
                                          <label class="col-sm-2 col-form-label text-right">Duration</label>
                                          <div class="col-sm-2">
								            <input type="text" class="form-control text-right" placeholder="" name="progduration" id="progduration">
										  </div>
                                          <label class="col-sm-2 col-form-label text-right">Episodes</label>
                                          <div class="col-sm-2">
								            <input type="text" class="form-control text-right" placeholder="" name="progepisode" id="progepisode">
										  </div>
									</div>
                                
                                    <div class="form-group row">
										  <label class="col-sm-2 col-form-label">TAM Code</label>
										  <div class="col-sm-4">
								            <input type="text" class="form-control" placeholder="" name="progdesc" id="progdesc">
										  </div>
                                          <label class="col-sm-2 col-form-label">Is Main Supplier</label>
										  <div class="col-sm-4">
								            <input id="addismainsupplier" placeholder="Select is Main Supplier" style="width: 100%;"/>
										  </div>
									</div>
                                
                                    <div class="form-group row">						  
                                          <div class="col-sm-2"></div>
                                          <div class="col-sm-4">
                                                <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input" name="progisactive" id="progisactive">
                                                <label class="custom-control-label mtop-2" for="progisactive">Is Active</label>
                                            </div>
                                          </div>
                                          <div class="col-sm-6"></div>
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
  
<script src="${serverurl}/mudralogin/assets/vendors/js/vendors.min.js" type="text/javascript"></script>

<script type="text/javascript" src="${serverurl}/mudralogin/assets/vendors/js/ui/jquery.sticky.js"></script>
<script src="${serverurl}/mudralogin/assets/js/core/libraries/jquery_ui/jquery-ui.min.js" type="text/javascript"></script>    

<script src="${serverurl}/mudralogin/assets/js/core/app-menu.js" type="text/javascript"></script>
<script src="${serverurl}/mudralogin/assets/js/core/app.js" type="text/javascript"></script>
<script src="${serverurl}/mudralogin/assets/js/scripts/customizer.js" type="text/javascript"></script>
    
<script src="${serverurl}/mudralogin/assets/js/scripts/ui/jquery-ui/date-pickers.js" type="text/javascript"></script>

<script src="${serverurl}/mudralogin/assets/kendo/js/kendo.all.min.js"></script>
<script src="${serverurl}/mudralogin/assets/kendo/js/jszip.min.js"></script>
  
<script src="${serverurl}/mudralogin/assets/kendo/js/programgrid.js"></script>

<script>
                $(document).bind("DOMSubtreeModified", function(){
						$('.k-select').addClass('themeColor');                        
					});
    
                $(document).ready(function() {                
                    
                $("#addchannelgroup").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "AASTHA - AASTHA NETWORK", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addcontractgroup").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "9X - 9X MEDIA PVT LTD", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addchanneltype").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "CHD", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addlanguage").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "HINDI", value: "1" },
                            { text: "GUJARATI", value: "2" },
                            { text: "ENGLISH", value: "3" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addexpglcode").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "2120104 - TV Time Purchase", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addincomeglcode").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "2120104 - TV Time Income", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addcommglcode").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "2110714 - Commission realized-TV", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addsertaxglcode").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "2135451 - Service Tax-(2135451)", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addrecglcode").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "2135299 - Service Tax Recovery", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addtdsglcode").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "2135023 - Tax Deducted at Source", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addprogcat").kendoComboBox({
                        dataTextField: "text",
                        dataValueField: "value",
                        dataSource: [
                            { text: "Sports", value: "1" }
                        ],
                        filter: "contains",
                        suggest: true,
                        index: -1
                });
                    
                $("#addismainsupplier").kendoComboBox({
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
                    
                $('a[rel=popover]').popover({
                  html: true,
                  trigger: 'hover',
                  placement: 'right',
                  content: function(){return '<img src="'+$(this).data('img') + '" />';}
                });

            /*	$(window).resize(function(){
                    resizeGrid();
                });*/
        
            //$(".collapse").collapse('hide');
            $('.collapse').on("hidden.bs.collapse", function(){resizeGrid(400,301.9);});//.fadeIn( "slow" );
            $('.collapse').on("shown.bs.collapse", function(){resizeGrid(200,101.9);});//.fadeIn( "fast" );
                    
                $("#programbasegrid").kendoGrid({
                        dataSource: {

                            data: programdetailGrid,
                            schema: {
                                model: {
                                    fields: {
                                        channelid: { type: "string" },
                                        programid: { type: "string" },
                                        programname: { type: "string" },
                                        daysofpro: { type: "number" },
                                        fromdate: { type: "string" },
                                        todate: { type: "string" },
                                        teletime: { type: "number" },
                                        teledur: { type: "number" },
                                        isactive: { type: "string" }
                                    }
                                }
                            },
                            pageSize: 17
                        },
                        toolbar: [{name: 'create', text: 'Add', className: "themeColor"},{name: 'excel', text: 'Export', className: "themeColor"}],                        
                        autoBind: true,
                        height: 320,
                        scrollable: true,
                        sortable: true,
                        filterable: true,
                        resizable: true,
                        pageable: {
                            input: true,
                            numeric: false
                        },
                        columns: [
                            { command: [{name: 'edit', text: '', className: "themeIconColor"}]},
                            { field: "channelid", title: "Channel Id", width: "130px" },
                            { field: "programid", title: "Program Id", width: "130px" },
                            { field: "programname", title: "Program Name", width: "130px" },
                            { field: "daysofpro", title: "Days of Program", width: "130px" },
                            { field: "fromdate", title: "From Date", width: "130px" },
                            { field: "todate", title: "To Date", width: "130px" },
                            { field: "teletime", title: "Telecast Time", width: "130px" },
                            { field: "teledur", title: "Telecast Duration", width: "130px" },
                            { field: "isactive", title: "Is Active", width: "130px" }
                        ],
                        dataBound: function(e) {
                        $( "div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a" ).removeClass( "k-button" );
                }
                    });                                    
						
                });                                     
    
                $(document).on('click','#channelbasegrid div.k-header.k-grid-toolbar a.k-button.k-button-icontext.k-grid-add',function(){
                    $('#channeladd').modal('show');
                })
    
                $(document).on('click','#channelbasegrid > div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a',function(){
                    $('#channeladd').modal('show');
                })
    
                $(document).on('click','#programbasegrid div.k-header.k-grid-toolbar a.k-button.k-button-icontext.k-grid-add',function(){
                    $('#programadd').modal('show');
                })
    
                $(document).on('click','#programbasegrid > div.k-grid-content.k-auto-scrollable > table > tbody > tr > td.k-command-cell > a',function(){
                    $('#programadd').modal('show');
                })
        
            </script>

</body>
</html>