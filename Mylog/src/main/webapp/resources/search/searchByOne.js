
function loadReplyList(boardNo) {
	$.ajax({
		url: "http://127.0.0.1:8888/Mylog/board/comment/list",
		method: "GET",
		data: { "boardNo": boardNo },
		success: function(data) {
			const CVoList = JSON.parse(data);
			console.log(CVoList);

			let str = "";
			for (let i = 0; i < CVoList.length; ++i) {
				str += "<div class='comment-user'>";
				str += "<div class='comment-user-img'></div>";
				str += "<div>";
				str += "<div>" + CVoList[i].writerNick + "</div>";
				str += "<div>" + CVoList[i].enrollDate + "</div>";
				if (CVoList[i].writerNo == sessionScope.loginAdminVo.no) {
					str += "<button onclick=\"location.href='/Mylog/comment/edit?no=" + CVoList[i].no + "'\">수정</button>";
					str += "<button onclick=\"location.href='/Mylog/comment/delete?no=" + CVoList[i].no + "'\">삭제</button>";
				}
				str += "</div>";
				str += "</div>";
				str += "<div class='comment-content'>" + CVoList[i].content + "</div>";
				str += "<div class='comment-comment'>";
				str += "</div>";
			}

			const commentContainer = document.getElementById("commentContainer");
			commentContainer.innerHTML = str;
		},
		fail: function(error) {
			console.log(error);
		},
	});
}

function writeReply(boardNo) {
	const replyValue = document.querySelector("textarea[name=reply-content]").value;
	document.querySelector("textarea[name=reply-content]").value = "";

	$.ajax({
		url: "http://127.0.0.1:8888/Mylog/comment/write",
		type: "post",
		data: {
			"boardNo": boardNo,
			"content": replyValue,
		},
		success: function(x) {
			console.log(x);
			loadReplyList(boardNo);
		},
		fail: function(x) {
			console.log(x);
		},
	});
}