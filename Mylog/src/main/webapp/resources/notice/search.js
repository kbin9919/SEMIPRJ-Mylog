let type = 'title';

let startNo = 1;
let endNo = 4;
let isLoading = false;
let totPage = 100;

$(window).on("scroll", function () {
    let scrollTop = $(window).scrollTop();
    let windowsHeight = $(window).height();
    let documentHeight = $(document).height();
    let isBottom = scrollTop + windowsHeight + 10 >= documentHeight;
    if (isBottom && !isLoading) {
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

function getList(startNo, endNo, type) {
    $.ajax({
        type: "get",
        url: "/Mylog/notice/search/receive",
        data: {
            "type" : type,
            "startNo": startNo,
            "endNo": endNo
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

$('.array-content').on('click', function arrayContent() {
    type = "content";
    getArrayList(type);
});

$('.array-title').on('click', function arrayContent() {
    type = "title";
    getArrayList(type);
});

function getArrayList(type){
    const urlParams = new URLSearchParams(window.location.search);
    const noticeSearch = urlParams.get('notice-search');
    const categoryNo = urlParams.get('category-no');
    $.ajax({
        type: "get",
        url: "/Mylog/search/notice/list",
        data: {
            "type": type
            , "notice-search": noticeSearch
            , "category-no": categoryNo
        },
        success: function (response) {
            let $response = $(response);
            // 응답에서 .notice-content-sell 요소를 가져와서 각각의 내부 HTML을 처리합니다.
            $response.find('.notice-content-sell').each(function () {
                let noticeContentHTML = $(this).html();
                // 가져온 HTML을 삽입하거나 처리합니다.
                $('.notice-content-sell').empty();
                $('.notice-content-sell').html(noticeContentHTML);
                startNo = 1;
                endNo = 4;
                // 이 곳에서 필요한 작업을 수행하세요.
            });
        },
        error: function (error) {
            console.error('AJAX error:', error);
        }
    });
}