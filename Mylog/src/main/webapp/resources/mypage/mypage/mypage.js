const categoryFocus = $(".midle-category");
const categoryFocusList = $(".midle-category>a");
let categoryFocusNum = 0;

categoryFocus.on('click', function categoryFocus(event) {
	let clickCategory = event.target;
	for (let i = 0; i < categoryFocusList.length; i++) {
		if (categoryFocusNum !== i) {
			if (clickCategory == categoryFocusList[i]) {
				categoryFocusList[i].classList.add("category-focus");
				categoryFocusList[categoryFocusNum].classList.remove("category-focus");
				categoryFocusNum = i;
			}
		}
	}
})

const tagFocus = $(".tag");
const tagFocusList = $("td>a");
let tagFocusNum = 0;
tagFocus.on('click', function tagFocus(event) {
	let clickTag = event.target;
	for (let i = 0; i < tagFocusList.length; i++) {
		if(tagFocusNum !== i){
			if (clickTag == tagFocusList[i]) {
				tagFocusList[i].classList.add("tag-focus");
				tagFocusList[tagFocusNum].classList.remove("tag-focus");
				tagFocusNum = i;
			}
		}
	}
})

categoryFocusList[1].addEventListener('click', function ajax() {
	$.ajax({
		url: '/Mylog/series',
		method: 'GET',
		dataType: "html",
		success: function (response) {
			console.log(response);
			$('.content').children().remove();
			$('.tag').children().remove();
			$('.content').html(response);
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
	});
})

categoryFocusList[0].addEventListener('click', function ajax() {
	$.ajax({
		url: '/Mylog/mypage',
		method: 'GET',
		dataType: "html",
		success: function (response) {
			location.reload("/Mylog/mypage");
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
	});
})



