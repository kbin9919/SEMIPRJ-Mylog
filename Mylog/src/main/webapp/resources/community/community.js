const page = document.querySelector("#page");
const pageTow = document.querySelector(".page-tow");
let pageNum = 1;
pageTow.addEventListener('click', function newPage() {
    if (pageNum == 1) {
        let XPage = document.createElement('div');
        XPage.className = 'newPage'
        pageTow.append(XPage);
        for (let i = 1; i <= 10; i++) {
            let newPage = document.createElement('a');
            newPage.className = 'aPage';
            newPage.textContent = i;
            XPage.appendChild(newPage);
        }
        page.remove();
        pageTow.removeEventListener('click', newPage);
    }
})

$(document).ready(function () {
    let page = 1;
    let loading = false;

    // 초기 데이터 로드
    loadData();

    // 스크롤 이벤트 리스너
    $(window).scroll(function () {
        if ($(window).scrollTop() + $(window).height() >= $(document).height() - 100 && !loading) {
            loadData();
        }
    });

    // AJAX를 통해 데이터 로드
    function loadData() {
        loading = true;
        $('#content').append('<div class="loading">Loading...</div>');

        $.ajax({
            url: '/Mylog/notice', // 데이터를 로드할 경로 또는 파일명
            type: 'post',
            data: { page: page }, // 필요한 경우 페이지 번호 등의 데이터를 전달할 수 있습니다.
            dataType: 'html',
            success: function (response) {
                if (response.trim() != '') {
                    $('#content .loading').remove();
                    $('#content').append(response);
                    page++;
                    loading = false;
                } else {
                    $('#content .loading').remove();
                    $('#content').append('<div class="no-data">No more data!</div>');
                }
            },
            error: function () {
                $('#content .loading').remove();
                $('#content').append('<div class="error">Error loading data!</div>');
                loading = false;
            }
        });
    }
});