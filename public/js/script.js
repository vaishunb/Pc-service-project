var main = function () {
	
	if(login !== ''){
    	$('.login').hide();
    	$('.user-profile').show();
	}
	
	if(success === 'no'){
		$('#wrong-password').show();
	}
	
    $('.navbar-right').click(function () {
        $('.dropdown-menu').toggle();
    });

}

function showPassword() {
    
    var key_attr = $('#key').attr('type');
    
    if(key_attr != 'text') {
        
        $('.checkbox').addClass('show');
        $('#key').attr('type', 'text');
        
    } else {
        
        $('.checkbox').removeClass('show');
        $('#key').attr('type', 'password');
        
    }
    
}

$(document).ready(main);