
let checkWarning = 0;
const warning = document.querySelector(".warning-member");
const warningText = document.querySelector(".warning-text");

warning.addEventListener('click', function hidden() {
    if (checkWarning % 2 == 0) {
        warningText.classList.remove('hidden');
    } else {
        warningText.classList.add('hidden');
    }
    checkWarning++;
});

const warningOk = document.querySelector("#warning-ok");
const warningBack = document.querySelector("#warning-back");

warningBack.addEventListener('click', function () {
    warningText.classList.add('hidden');
    checkWarning++;
});

warningOk.addEventListener('click', function () {
    let memberNo = document.querySelector('.member-no').textContent;
    let warningNo = document.getElementById('select').value;
    $.ajax({
        type: "post",
        url: "/Mylog/admin/warning",
        data: {
            "memberNo": memberNo,
            "warningNo": warningNo
        },
        success: function (response) {
            console.log(response);
            if (response === "1") {
                alert("회원 경고 성공!");
            } else {
                alert("회원 경고 실패!");
            }
            warningText.classList.add('hidden');
        },
        error: function (error) {
            console.error('AJAX error:', error);
        }
    });
});

let checkDel = 0;
const delText = document.querySelector(".del-text");
document.querySelector(".del-member").addEventListener('click', function(){
    if (checkDel % 2 == 0) {
        delText.classList.remove('hidden');
    } else {
        delText.classList.add('hidden');
    }
    checkDel++;
});

const delOk = document.querySelector("#del-ok");
const delBack = document.querySelector("#del-back");

delBack.addEventListener('click', function () {
    delText.classList.add('hidden');
    checkDel++;
});

delOk.addEventListener('click', function () {
    let memberNo = document.querySelector('.member-no').textContent;
    $.ajax({
        type: "post",
        url: "/Mylog/admin/delete/member",
        data: {
            "memberNo": memberNo
        },
        success: function (response) {
            console.log(response);
            if (response === "1") {
                alert("회원 경고 성공!");
            } else {
                alert("회원 경고 실패!");
            }
            delText.classList.add('hidden');
        },
        error: function (error) {
            console.error('AJAX error:', error);
        }
    });
});