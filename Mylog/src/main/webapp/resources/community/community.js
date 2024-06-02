
$(document).ready(function () {
    const searchText = $('#searchInput').val().trim() // input의 기본값을 검색어로 설정
    function applyHighlighting() {
        $('.highlightable').each(function () {
            const divText = $(this).text().toLowerCase(); // 각 div 요소의 텍스트를 가져와서 소문자로 변환하여 저장
            const regex = new RegExp('(' + searchText + ')', 'gi'); // 검색어와 일치하는 부분을 찾을 정규식 생성
            const highlightedText = divText.replace(regex, '<span class="highlight">$1</span>'); // 검색어와 일치하는 부분을 감싸고 있는 span 태그 생성
            $(this).html(highlightedText); // div 요소의 내용을 변경
        });
    }
    applyHighlighting();

    // Ajax 요청이 완료되면 다시 함수 호출하여 적용
    $(document).ajaxComplete(function() {
        applyHighlighting();
    });
});

$(document).ready(function () {
    const movable = $('.tag');
    let isDragging = false;
    let offsetX, offsetY;

    movable.on('mousedown', function (event) {
        isDragging = true;
        offsetX = event.offsetX;
        offsetY = event.offsetY;

        // 클릭한 요소의 드래그 시작
        $(document).on('mousemove.drag', function (e) {
            if (isDragging) {
                const x = e.pageX - offsetX;
                const y = e.pageY - offsetY;
                movable.css({
                    left: x + 'px',
                    top: y + 'px'
                });
                
                // 위치 정보를 쿠키에 업데이트
                updatePositionCookie(x, y);
            }
        });

        // 드래그 종료
        $(document).on('mouseup.drag', function () {
            isDragging = false;
            $(document).off('mousemove.drag mouseup.drag');
        });

        // 클릭 이벤트가 다른 요소로 전파되지 않도록 중지
        event.stopPropagation();
        event.preventDefault(); // 드래그 중 텍스트 선택 방지
    });
});

// 사용자의 초기 위치 설정 (예시로 임의의 위치 사용)
const initialX = 100;
const initialY = 100;

// 사용자의 위치 정보를 쿠키에 저장하는 함수
function updatePositionCookie(x, y) {
    // 쿠키에 위치 정보를 저장
    document.cookie = `userPosition=${x},${y}; path=/`;
}

// 페이지 로드 시 호출되는 함수
function loadPositionFromCookie() {
    // 쿠키에서 사용자의 위치 정보를 가져와서 적용
    const cookies = document.cookie.split(';');
    for (const cookie of cookies) {
        const [name, value] = cookie.trim().split('=');
        if (name === 'userPosition') {
            const [x, y] = value.split(',');
            // 위치 정보를 적용
            $('.tag').css({ left: x + 'px', top: y + 'px' });
            break;
        }
    }
}

// 페이지 로드 시 사용자의 위치 정보를 가져와서 적용
loadPositionFromCookie();