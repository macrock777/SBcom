//$(document).ready(function () {
	var color_code_light = sessionStorage.getItem('--color-code-light');
	var color_code_hover = sessionStorage.getItem('--color-code-hover');
	var color_code = sessionStorage.getItem('--color-code');
	var color_code_font = sessionStorage.getItem('--color-code-font');
	var color_code_card = sessionStorage.getItem('--color-code-card');
	var color_code_card_hover = sessionStorage.getItem('--color-code-card-hover');

	if (null == color_code) {
		color_code = 'rgba(250,201,0,1)';
	}
	if (null == color_code_card) {
		color_code_card = 'rgba(250,201,0,1)';
	}
	if (null == color_code_card_hover) {
		color_code_card_hover = 'rgba(250,201,0,05)';
	}

	if (null == color_code_hover) {
		color_code_hover = 'rgba(250,201,0,0.5)';
	}

	if (null == color_code_light) {
		color_code_light = 'rgba(250,201,0,0.05)';
	}

	if (null == color_code_font) {
		color_code_font = 'rgba(0,0,0,1)';
	}
	document.documentElement.style.setProperty('--color-code-light', color_code_light);
	document.documentElement.style.setProperty('--color-code-hover', color_code_hover);
	document.documentElement.style.setProperty('--color-code', color_code);
	document.documentElement.style.setProperty('--color-code-card', color_code_card);
	document.documentElement.style.setProperty('--color-code-card-hover', color_code_card_hover);
	document.documentElement.style.setProperty('--color-code-font', color_code_font);
	
	document.addEventListener("DOMSubtreeModified", function () {
		// your code
		var list = document.querySelectorAll(".k-select,button.k-button.k-primary");
		for (var i = 0; i < list.length; ++i) {
			list[i].classList.add('themeColor');
		}
	}, false);
//});
window.onload = function(){
	var themecolorNameDoc = document.getElementById("themeColorName");
	if(null!=themecolorNameDoc && undefined!=themecolorNameDoc){
		var x = themecolorNameDoc.querySelectorAll("li");  
		for (var i = 0; i < x.length; i++) {
			x[i].addEventListener('click', function(event,thiss) {
				var ID = event.currentTarget.id;
				for (var i = 0; i < x.length; i++) {
					x[i].classList.remove("active");
				}
				event.currentTarget.classList.add('active');
				switch (ID) {
					case "purplelable":				
							changeThemeColorFn('rgba(133,37,130,0.05)','rgba(133,37,130,0.5)','rgba(133,37,130,1)',
							'rgba(255,255,255,1)','rgba(133,37,130,1)','rgba(133,37,130,0.5)','assets/images/efive/logo_purple.png');
							break;
						case "dbluelable":
							changeThemeColorFn('rgba(12,169,167,0.05)','rgba(12,169,167,0.5)','rgba(12,169,167,1)',
							'rgba(255,255,255,1)','rgba(12,169,167,1)','rgba(12,169,167,0.5)','assets/images/efive/logo_dblue.png');
							break;
						case "yellowlable":
							changeThemeColorFn('rgba(250,201,0,0.05)','rgba(250,201,0,0.5)','rgba(250,201,0,1)',
							'rgba(0,0,0,1)','rgba(250,201,0,1)','rgba(250,201,0,0.5)','assets/images/efive/logo_yellow.png');
							break;
						case "redlable":
							changeThemeColorFn('rgba(224,72,16,0.05)','rgba(224,72,16,0.5)','rgba(224,72,16,1)',
							'rgba(255,255,255,1)','rgba(224,72,16,1)','rgba(224,72,16,0.5)','assets/images/efive/logo_red.png');
							break;
						case "bluelable":
							changeThemeColorFn('rgba(4,163,206,0.05)','rgba(4,163,206,0.5)','rgba(4,163,206,1)',
							'rgba(255,255,255,1)','rgba(4,163,206,1)','rgba(4,163,206,0.5)','assets/images/efive/logo_blue.png');	
							break;
						default:
							changeThemeColorFn('rgba(250,201,0,0.05)','rgba(250,201,0,0.5)','rgba(250,201,0,1)',
							'rgba(0,0,0,1)','rgba(250,201,0,1)','rgba(250,201,0,0.5)','assets/images/efive/logo_yellow.png');
				}
			});
		}
	}
};

		function resetFn() {

			changeThemeColorFn('rgba(250,201,0,0.05)','rgba(250,201,0,0.5)','rgba(250,201,0,1)',
				'rgba(255,255,255,1)','rgba(0,0,0,0.8)','rgba(0,0,0,0.5)','assets/images/efive/logo_yellow.png');
		}

		function changeThemeColorFn(...args){
			if(null!=args && args.length>6){
				var color_code_light = args[0];
				var color_code_hover = args[1];
				var color_code = args[2];
				var color_code_font = args[3];
				var color_code_card = args[4];
				var color_code_card_hover = args[5];
				var png_path = args[6];

				document.documentElement.style.setProperty('--color-code-light', color_code_light);
				document.documentElement.style.setProperty('--color-code-hover', color_code_hover);
				document.documentElement.style.setProperty('--color-code', color_code);
				document.documentElement.style.setProperty('--color-code-font', color_code_font);
				document.documentElement.style.setProperty('--color-code-card', color_code_card);
				document.documentElement.style.setProperty('--color-code-card-hover', color_code_card_hover);

				sessionStorage.setItem('--color-code-light', color_code_light);
				sessionStorage.setItem('--color-code-hover', color_code_hover);
				sessionStorage.setItem('--color-code', color_code);
				sessionStorage.setItem('--color-code-card', color_code_card);
				sessionStorage.setItem('--color-code-card-hover', color_code_card_hover);
				sessionStorage.setItem('--color-code-font', color_code_font);
				$('.brand-logo').attr('src', png_path);
			
			}
		}			
			

		//$('.brand-logo').attr('src', 'assets/images/efive/logo_yellow.png');