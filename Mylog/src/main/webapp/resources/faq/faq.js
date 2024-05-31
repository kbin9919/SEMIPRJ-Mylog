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
        url: "/Mylog/faq/receive",
        data: {
            "startNo" : startNo,
            "endNo" : endNo
        },
		success: function (response) {
            let faqHtml = $(response).filter('#faq-list').html();
            let faqCount = $(response).filter('#faq-count').text();
			$('.notice-content-sell').append(faqHtml);
            totPage = faqCount;
            $(".message").hide();
		},
		error: function (error) {
			console.error('AJAX error:', error);
		}
    });
}
