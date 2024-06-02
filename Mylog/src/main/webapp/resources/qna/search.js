console.log("faq-search-js호출");
let startNo = 1;
let endNo = 4;
let isLoading = false;
let totPage = 100;
$(window).on("scroll", function () {
    let scrollTop = $(window).scrollTop();
    let windowsHeight = $(window).height();
    let documentHeight = $(document).height();
    let isBottom = scrollTop + windowsHeight + 10 >= documentHeight;
    if (isBottoisBottom && !isLoading) {
        if (startNo >= totPage) {
            return false;
        } else {
            isLoading = true;
            startNo += 4;
            endNo += 4;
            getList(startNo, endNo);
        }
    }
});

function getList(startNo, endNo) {
    $.ajax({
        type: "get",
        url: "/Mylog/qna/search/receive",
        data: {
            "startNo": startNo,
            "endNo": endNo
        },
        success: function (response) {
            let noticeHtml = $(response).filter('#qna-list').html();
            let noticeCount = $(response).filter('#qna-count').text();

            $('.notice-content-sell').append(noticeHtml);
            totPage = noticeCount;
            console.log(totPage);
        },
        error: function (error) {
            console.error('AJAX error:', error);
        }
    });
}
