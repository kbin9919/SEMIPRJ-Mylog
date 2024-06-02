console.log(" search : 연결됨");
let startNo = 1;
let endNo = 4;
let isLoading = false;
let totPage = 100;
$(window).on("scroll", function(){
    let scrollTop = $(window).scrollTop();
    let windowsHeight = $(window).height();
    let documentHeight = $(document).height();
    let isBottom = scrollTop + windowsHeight + 10 >= documentHeight;
    if(isBottom && !isLoading){
        if(startNo >= totPage){
            return false;
        }else{
            isLoading = true;
            startNo += 4;
            endNo += 4;
            getList(startNo, endNo);
        }
    }
});

function getList(startNo, endNo){
    $.ajax({
        type: "get",
        url: "/Mylog/notice/search/receive",
        data: {
            "startNo" : startNo,
            "endNo" : endNo
        },
		success: function (response) {
            let noticeHtml = $(response).filter('#notice-list').html();
            let noticeCount = $(response).filter('#notice-count').text();
			$('.notice-content-sell').append(noticeHtml);
            totPage = noticeCount;
            console.log(totPage);
            isLoading = false;
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
    });
}
const type = 'content';
$('.array-content').on('click', function arrayContent(){
    const urlParams = new URLSearchParams(window.location.search);
    const noticeSearch = urlParams.get('notice-search');
    const categoryNo = urlParams.get('category-no');
    $.ajax({
        type: "get",
        url: "/Mylog/search/notice/list",
        data: {
            "type" : type
            , "notice-search" : noticeSearch
            , "category-no" : categoryNo
        },
		success: function (response) {
			$('body').empty();
            $('body').append(response);
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
    });
});

$('.array-content').on('click', function arrayContent(){
    
});