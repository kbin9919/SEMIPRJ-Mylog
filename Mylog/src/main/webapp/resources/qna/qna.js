let type = 'all';
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

function getList(startNo, endNo, type){
    $.ajax({
        type: "get",
        url: "/Mylog/qna/receive",
        data: {
            "type" : type,
            "startNo" : startNo,
            "endNo" : endNo
        },
		success: function (response) {
            let noticeHtml = $(response).filter('#qna-list').html();
            let noticeCount = $(response).filter('#qna-count').text();
            isLoading = false;
			$('.notice-content-sell').append(noticeHtml);
            totPage = noticeCount;
            console.log(totPage);
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
    });
}

$('.array-all').on('click', function arrayContent() {
    type = "all";
    getArrayList(type);
});

$('.array-my').on('click', function arrayContent() {
    type = "my";
    getArrayList(type);
});

function getArrayList(type){
    $.ajax({
        type: "get",
        url: "/Mylog/qna",
        data: {
            "type": type
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

$(document).on('click', '#secretQna', function () {
    const secretQna = this;
    secretQna.classList.add('secretQna-shake');
    secretQna.classList.remove('notice-content');
    secretQna.classList.add('notice-content-click');

    secretQna.addEventListener('animationend', () => {
        secretQna.classList.remove('secretQna-shake');
        secretQna.classList.add('notice-content');
        secretQna.classList.add('notice-content');
    }, { once: true });
});

