let startNo = 1;
let endNo = 4;
let isLoading = false;
let totPage = 100;
const data = [];
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
        url: "/Mylog/notice/receive",
        data: {
            "startNo" : startNo,
            "endNo" : endNo
        },
		success: function (response) {
			console.log(response);
            let noticeHtml = $(response).filter('#notice-list').html();
            let noticeCount = $(response).filter('#notice-count').text();
			$('.notice-content-sell').append(noticeHtml);
            totPage = noticeCount;
            date = noticeHtml.val;
            console.log(totPage);
            isLoading = false;
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
    });
}

