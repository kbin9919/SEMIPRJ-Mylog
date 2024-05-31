let startNo = 1;
let endNo = 4;
let isLoading = false;
let totPage = 100;
$(window).on("scroll", function(){
    let scrollTop = $(window).scrollTop();
    let windowsHeight = $(window).height();
    let documentHeight = $(document).height();
    let isBottom = scrollTop + windowsHeight + 10 >= documentHeight;
    if(isBottom){
        if(startNo >= totPage){
            return false;
        }else{
            isLoading = true;
            $(".message").show();
            startNo += 4;
            endNo += 4;
            getList(startNo, endNo);
        }
    }
});

function getList(startNo, endNo){
    $.ajax({
        type: "get",
        url: "/Mylog/qna/receive",
        data: {
            "startNo" : startNo,
            "endNo" : endNo
        },
		dataType: "html",
		success: function (response) {
			let qnaHtml = $(response).filter('#qna-list').html();
            let qnaCount = $(response).filter('#qna-count').text();
			$('.notice-content-sell').append(qnaHtml);
            totPage = qnaCount;
            $(".message").hide();
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
    });
}
