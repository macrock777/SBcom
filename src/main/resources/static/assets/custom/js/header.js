document.write("<nav class='header-navbar navbar-expand-md navbar navbar-with-menu navbar-static-top navbar-light navbar-border navbar-brand-center'>");
document.write("<div class='navbar-wrapper'>");
document.write("<div class='navbar-header'>");
document.write("<ul class='nav navbar-nav flex-row'>");
document.write("<li class='nav-item mobile-menu d-md-none mr-auto'><a class='nav-link nav-menu-main menu-toggle hidden-xs' href='#'><i class='ft-menu font-large-1'></i></a></li>");
document.write("<li class='nav-item'>");
document.write("<a class='navbar-brand' href='landing.html'>");
document.write("<img class='brand-logo' alt='' src='assets/images/efive/logo_small.png'>");
document.write("<h3 class='brand-text'>mBoss</h3>");
document.write("</a>");
document.write("</li>");
document.write("<li class='nav-item d-md-none'>");
document.write("<a class='nav-link open-navbar-container' data-toggle='collapse' data-target='#navbar-mobile'><i class='fa fa-ellipsis-v'></i></a>");
document.write("</li>");
document.write("</ul>");
document.write("</div>");
document.write("<div class='navbar-container container center-layout'>");
document.write("<div class='collapse navbar-collapse' id='navbar-mobile'>");
document.write("<ul class='nav navbar-nav mr-auto float-left'>");
document.write("<li class='nav-item d-none d-md-block'><a class='nav-link nav-menu-main menu-toggle hidden-xs' href='#'><i class='ft-menu'>         </i></a></li>");
document.write("</ul>");
document.write("<ul class='nav navbar-nav float-right'>");

document.write("<li class='dropdown dropdown-language nav-item' style='margin-top: 12px;padding-right:3px;'>");
document.write("<i class='fa fa-exchange'></i>");
document.write("</li>");

document.write("<li class='dropdown dropdown-language nav-item' style='margin-top: 5px;padding-right:3px;'>");
document.write("<select class='select2 form-control block disabled-search' id='responsive_single' data-placeholder='CSA'> ");  
document.write("<option value='CSA'>CSA</option>");
document.write("<option value='FAS'>FAS</option>");
document.write("</select>");
document.write("</li>");

document.write("<li class='dropdown dropdown-language nav-item' style='margin-top: 5px;'>");
document.write("<select class='select2 form-control block disabled-search' id='responsive_single'  data-placeholder='MUMBAI'> ");  
document.write("<option value='Mumbai'>MUMBAI</option>");
document.write("<option value='Ahmedabad'>AHMEDABAD</option>");
document.write("</select>");
document.write("</li>");

/*
document.write("<li class='dropdown dropdown-notification nav-item'>");
document.write("<a class='nav-link nav-link-label' href='#' data-toggle='dropdown'><i class='ficon ft-bell'></i>");
document.write("<span class='badge badge-pill badge-default badge-danger badge-default badge-up'>5</span>");
document.write("</a>");
document.write("<ul class='dropdown-menu dropdown-menu-media dropdown-menu-right'>");
document.write("<li class='dropdown-menu-header'>");
document.write("<h6 class='dropdown-header m-0'>");
document.write("<span class='grey darken-2'>Notifications</span>");
document.write("</h6>");
document.write("<span class='notification-tag badge badge-default badge-danger float-right m-0'>5 New</span>");
document.write("</li>");
document.write("<li class='scrollable-container media-list w-100'>");
document.write("<a href='javascript:void(0)'>");
document.write("<div class='media'>");
document.write("<div class='media-left align-self-center'><i class='ft-plus-square icon-bg-circle bg-cyan'></i></div>");
document.write("<div class='media-body'>");
document.write("<h6 class='media-heading'>You have new order!</h6>");
document.write("<p class='notification-text font-small-3 text-muted'>Lorem ipsum dolor sit amet, consectetuer elit.</p>");
document.write("<small>");
document.write("<time class='media-meta text-muted' datetime='2015-06-11T18:29:20+08:00'>30 minutes ago</time>");
document.write("</small>");
document.write("</div>");
document.write("</div>");
document.write("</a>");
document.write("<a href='javascript:void(0)'>");
document.write("<div class='media'>");
document.write("<div class='media-left align-self-center'><i class='ft-download-cloud icon-bg-circle bg-red bg-darken-1'></i></div>");
document.write("<div class='media-body'>");
document.write("<h6 class='media-heading red darken-1'>99% Server load</h6>");
document.write("<p class='notification-text font-small-3 text-muted'>Aliquam tincidunt mauris eu risus.</p>");
document.write("<small>");
document.write("<time class='media-meta text-muted' datetime='2015-06-11T18:29:20+08:00'>Five hour ago</time>");
document.write("</small>");
document.write("</div>");
document.write("</div>");
document.write("</a>");
document.write("</li>");
document.write("<li class='dropdown-menu-footer'><a class='dropdown-item text-muted text-center' href='javascript:void(0)'>Read all notifications</a></li>");
document.write("</ul>");
document.write("</li>");*/
document.write("<li class='dropdown dropdown-user nav-item'>");
document.write("<a class='dropdown-toggle nav-link dropdown-user-link' href='#' data-toggle='dropdown'>");
document.write("<span class='avatar avatar-online'>");

document.write("<img src='assets/images/face1.jpg' alt='avatar'><i></i></span>");
document.write("<span class='user-name'>Harshad Chauhan <span class='usertype'>Admin</span></span></a>");
document.write("<div class='dropdown-menu dropdown-menu-right'><a class='dropdown-item' href='#'><i class='ft-user'></i> Edit Profile</a>");
/*document.write("<a class='dropdown-item' href='#'><i class='ft-mail'></i> My Inbox</a>");
document.write("<a class='dropdown-item' href='#'><i class='ft-check-square'></i> Task</a><a class='dropdown-item' href='#'><i class='ft-message-square'></i> Chats</a>");*/
document.write("<a class='dropdown-item' href='#' data-toggle='modal' data-target='#themeSettings'><i class='ft-settings'></i> Settings</a>");
document.write("<div class='dropdown-divider'></div><a class='dropdown-item' href='login.html'><i class='ft-power'></i> Logout</a>");
document.write("</div>");
document.write("</li>");
document.write("</ul>");
document.write("</div>");
document.write("</div>");
document.write("</div>");
document.write("</nav>");


document.write("<div class='modal fade' id='themeSettings' tabindex='-1' role='dialog' aria-labelledby='themeSettings-label' aria-hidden='true'>");
document.write("<div class='modal-dialog' role='document'>");
document.write("<div class='modal-content cardShape'>");
document.write("<div class='modal-header cardShape'>");
document.write("<h5 class='modal-title' id='themeSettings-label'>Theme Settings</h5>");
document.write("<button type='button' class='close' data-dismiss='modal' aria-label='Close'>");
document.write("<span aria-hidden='true'>&times;</span>");
document.write("</button>");
document.write("</div>");
document.write("<div class='modal-body'>");
document.write("<div class='row'>");
document.write("<div class='col-lg-12 col-md-12 col-xs-12 col-sm-12 more-padding'>");
document.write("<div class='form-group row'>");
document.write("<label class='col-sm-4 form-control-label' for='inputName1'>DDB Color Code</label>");
document.write("<div class='col-sm-8'>");
document.write("<div class='skin skin-minimal'>");
document.write("<div class='skin-section'>");
document.write("<div class='colors clearfix'>");
document.write("<ul style='margin-left: -38px;' id='themeColorName'>");
document.write("<li id='purplelable' class='purplelable' title='Purple'>");
document.write("<a></a>");
document.write("</li>");
document.write("<li id='dbluelable' class='dbluelable' title='Dark Blue'></li>");
document.write("<li id='yellowlable' class='yellowlable' title='Yellow'></li>");
document.write("<li id='redlable' class='redlable' title='Red'></li>");
document.write("<li id='bluelable' class='bluelable' title='Blue'></li>");
document.write("</ul>");
document.write("</div>");
document.write("</div>");
document.write("</div>");
document.write("</div>");
document.write("</div>");
document.write("</div>");
document.write("</div>");
document.write("</div>");
document.write("<div class='modal-footer'>");
document.write("<a href='#' data-dismiss='modal'>");
document.write("<span class=' badgeButton themeColor '>");
document.write("<i class='fa fa-check'></i> Select</span>");
document.write("</a>");
document.write("<a href='javascript:resetFn();' title='Reset to default Theme'>");
document.write("<span class=' badgeButton themeColor'>");
document.write("<i class='fa fa-refresh'></i> reset</span>");
document.write("</a>");
// document.write("<a href='#' data-dismiss='modal'>");
// document.write("<span class=' badgeButton themeColor'>");
// document.write("<i class='fa fa-remove'></i> cancel</span>");
// document.write("</a>");

document.write("</div>");
document.write("</div>");
document.write("</div>");
document.write("</div>");



/*

<nav class='header-navbar navbar-expand-md navbar navbar-with-menu navbar-static-top navbar-light navbar-border navbar-brand-center'>
    <div class='navbar-wrapper'>
      <div class='navbar-header'>
        <ul class='nav navbar-nav flex-row'>
          <li class='nav-item mobile-menu d-md-none mr-auto'><a class='nav-link nav-menu-main menu-toggle hidden-xs' href='#'><i class='ft-menu font-large-1'></i></a></li>
          <li class='nav-item'>
            <a class='navbar-brand' href='#'>
              <img class='brand-logo' alt='' src='assets/images/efive/logo_small.png'>
              <h3 class='brand-text'>mBoss Application</h3>
            </a>
          </li>
          <li class='nav-item d-md-none'>
            <a class='nav-link open-navbar-container' data-toggle='collapse' data-target='#navbar-mobile'><i class='fa fa-ellipsis-v'></i></a>
          </li>
        </ul>
      </div>
      <div class='navbar-container container center-layout'>
        <div class='collapse navbar-collapse' id='navbar-mobile'>
          <ul class='nav navbar-nav mr-auto float-left'>
            <li class='nav-item d-none d-md-block'><a class='nav-link nav-menu-main menu-toggle hidden-xs' href='#'><i class='ft-menu'>         </i></a></li>
            
      
          </ul>
          <ul class='nav navbar-nav float-right'>
           
            <li class='dropdown dropdown-notification nav-item'>
              <a class='nav-link nav-link-label' href='#' data-toggle='dropdown'><i class='ficon ft-bell'></i>
                <span class='badge badge-pill badge-default badge-danger badge-default badge-up'>5</span>
              </a>
              <ul class='dropdown-menu dropdown-menu-media dropdown-menu-right'>
                <li class='dropdown-menu-header'>
                  <h6 class='dropdown-header m-0'>
                    <span class='grey darken-2'>Notifications</span>
                  </h6>
                  <span class='notification-tag badge badge-default badge-danger float-right m-0'>5 New</span>
                </li>
                <li class='scrollable-container media-list w-100'>
                  <a href='javascript:void(0)'>
                    <div class='media'>
                      <div class='media-left align-self-center'><i class='ft-plus-square icon-bg-circle bg-cyan'></i></div>
                      <div class='media-body'>
                        <h6 class='media-heading'>You have new order!</h6>
                        <p class='notification-text font-small-3 text-muted'>Lorem ipsum dolor sit amet, consectetuer elit.</p>
                        <small>
                          <time class='media-meta text-muted' datetime='2015-06-11T18:29:20+08:00'>30 minutes ago</time>
                        </small>
                      </div>
                    </div>
                  </a>
                  <a href='javascript:void(0)'>
                    <div class='media'>
                      <div class='media-left align-self-center'><i class='ft-download-cloud icon-bg-circle bg-red bg-darken-1'></i></div>
                      <div class='media-body'>
                        <h6 class='media-heading red darken-1'>99% Server load</h6>
                        <p class='notification-text font-small-3 text-muted'>Aliquam tincidunt mauris eu risus.</p>
                        <small>
                          <time class='media-meta text-muted' datetime='2015-06-11T18:29:20+08:00'>Five hour ago</time>
                        </small>
                      </div>
                    </div>
                  </a>
                
                </li>
                <li class='dropdown-menu-footer'><a class='dropdown-item text-muted text-center' href='javascript:void(0)'>Read all notifications</a></li>
              </ul>
            </li>
           
            <li class='dropdown dropdown-user nav-item'>
              <a class='dropdown-toggle nav-link dropdown-user-link' href='#' data-toggle='dropdown'>
                <span class='avatar avatar-online'>
                  <img src='assets/images/portrait/small/avatar-s-1.png'
                  alt='avatar'><i></i></span>
                <span class='user-name'>John Doe</span>
              </a>
              <div class='dropdown-menu dropdown-menu-right'><a class='dropdown-item' href='#'><i class='ft-user'></i> Edit Profile</a>
                <a
                class='dropdown-item' href='#'><i class='ft-mail'></i> My Inbox</a>
                  <a class='dropdown-item' href='#'><i class='ft-check-square'></i> Task</a><a class='dropdown-item'
                  href='#'><i class='ft-message-square'></i> Chats</a>
                  <div class='dropdown-divider'></div><a class='dropdown-item' href='#'><i class='ft-power'></i> Logout</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
  
  */



/*
document.write('<nav class='header-navbar navbar-expand-md navbar navbar-with-menu fixed-top navbar-semi-dark '>');
document.write('<div class='navbar-wrapper'>');
document.write('<div class='navbar-header'>');
document.write('<ul class='nav navbar-nav flex-row'>');
document.write('<li class='nav-item mobile-menu d-md-none mr-auto'><a class='nav-link nav-menu-main menu-toggle hidden-xs' href='#'><i class='ft-menu font-large-1'></i></a></li>');
document.write('<li class='nav-item'>');
document.write('<a class='navbar-brand' href='#'>');
document.write('<img class='brand-logo' alt='BARC INDIA' src='assets/images/efive/barc-logo_small.png'>');
document.write('<h3 class='brand-text hidden-xs'><span style='color:#FFF'>&nbsp;&nbsp;BARC INDIA</span></h3>');
document.write('</a>');
document.write('</li>');
document.write('<li class='nav-item d-md-none'>');
document.write('<a class='nav-link open-navbar-container' data-toggle='collapse' data-target='#navbar-mobile'><i class='fa fa-ellipsis-v'></i></a>');
document.write('</li></ul></div>');
document.write('<div class='navbar-container content'>');
document.write('<div class='collapse navbar-collapse' id='navbar-mobile'>');
document.write('<ul class='nav navbar-nav mr-auto float-left'>');
document.write('<li class='nav-item d-none d-md-block'><a class='nav-link nav-menu-main menu-toggle hidden-xs' href='#'><i class='ft-menu'> </i></a></li>');
document.write('<li class='nav-item d-none d-md-block'>');
document.write('<a class='navbar-brand' >');
document.write('<h3 class='brand-text'>Booking System</h3></a>');
document.write('</li>');
document.write('</ul>');
document.write('<ul class='nav navbar-nav float-right'>');
document.write('<li class='dropdown dropdown-user nav-item'>');
document.write('<a class='dropdown-toggle nav-link dropdown-user-link' href='#' data-toggle='dropdown'>');
document.write('<span class='avatar avatar-online'>');
document.write('<img src='assets/images/efive/avatar-s-1.png'  alt='avatar'><i></i></span>');
document.write('<span class='user-name'>Admin User </span></a>');
document.write('<div class='dropdown-menu dropdown-menu-right'>');
document.write('<a class='dropdown-item' href='index.html'><i class='ft-power'></i> Logout</a>');
document.write('</div></li></ul></div></div></div></nav>');


*/
/*
 <nav class='header-navbar navbar-expand-md navbar navbar-with-menu fixed-top navbar-semi-dark navbar-shadow'>
    <div class='navbar-wrapper'>
      <div class='navbar-header'>
        <ul class='nav navbar-nav flex-row'>
          <li class='nav-item mobile-menu d-md-none mr-auto'><a class='nav-link nav-menu-main menu-toggle hidden-xs' href='#'><i class='ft-menu font-large-1'></i></a></li>
          <li class='nav-item'>
            <a class='navbar-brand' href='index.html'>
            
<img class='brand-logo' alt='BARC INDIA' src='assets/images/efive/barc-logo_small.png'>
              <h3 class='brand-text hidden-xs'>&nbsp;BARC INDIA</h3>

            </a>
          </li>
          <li class='nav-item d-md-none'>
            <a class='nav-link open-navbar-container' data-toggle='collapse' data-target='#navbar-mobile'><i class='fa fa-ellipsis-v'></i></a>
          </li>
        </ul>
      </div>
      <div class='navbar-container content'>
        <div class='collapse navbar-collapse' id='navbar-mobile'>
          <ul class='nav navbar-nav mr-auto float-left'>
            <li class='nav-item d-none d-md-block'><a class='nav-link nav-menu-main menu-toggle hidden-xs' href='#'><i class='ft-menu'>         </i></a></li>
           
            <li class='nav-item d-none d-md-block'>
				<a class='navbar-brand' >
                    
                        <h3 class='brand-text'>Panel Health <span class='text-danger font-small-2'>KPI Report as on : 01/04/2018</span></h3>
                    </a>
				</li>
          
          </ul>
          <ul class='nav navbar-nav float-right'>
         
            <li class='dropdown dropdown-user nav-item'>
              <a class='dropdown-toggle nav-link dropdown-user-link' href='#' data-toggle='dropdown'>
                <span class='avatar avatar-online'>
                  <img src='assets/images/efive/avatar-s-1.png'
                  alt='avatar'><i></i></span>
                <span class='user-name'>Swapnil Sinde</span>
              </a>
              <div class='dropdown-menu dropdown-menu-right'>
                <a class='dropdown-item' href='#'><i class='ft-power'></i> Logout</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
*/