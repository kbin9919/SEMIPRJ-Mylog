const settingChange = document.querySelectorAll('.setting-Change');
console.log(settingChange);
settingChange[0].addEventListener('click', function settingChange() {
    console.log("넘어옴");
    $.ajax({
		url: '/Mylog/settingChange',
		method: 'GET',
		dataType: "html",
		success: function (response) {
            $('.setting-Change').children().remove();
			$('.setting-Change').html(response);
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
	});
})
