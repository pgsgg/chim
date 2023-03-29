/**
 * 로그인 체크
 */

function loginCheck() {
    if (document.getElementById('id').value == "") {
        alert("아이디를 입력해주세요");
        document.getElementById('id').focus();
        return false;
    } else if (document.getElementById('pwd').value == "") {
        alert("비밀번호를 입력해주세요");
        document.getElementById('pwd').focus();
        return false;
    } else {
        var form = document.getElementById('loginForm');
        form.action = "login";
        form.submit();
    }
}

function idCheck() {

    var url = "idCheck_form?id=" + document.getElementById('id').value;
    window.open(url, "_blank_", "toolbar=no", "menubar=no", "scrollbar=yes",
        "resizable=yse");
    window.resizeTo(350, 450);
}

function go_save() {
    var regExp = /^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$/;
    if (document.getElementById('id').value == "") {
        alert("아이디를 입력해 주세요");
        document.getElementById('id').focus();
        return false;
    } else if (document.getElementById('reid').value == "") {
        alert("아이디 중복체크를 해 주세요");
        document.getElementById('reid').focus();
        return false;
    } else if (document.getElementById('pwd').value == "") {
        alert("비밀번호를 입력해 주세요");
        document.getElementById('pwd').focus();
        return false;
    } else if (document.getElementById('pwd').value != document.getElementById('pwdCheck').value) {
        alert("서로 다른 비밀번호 입니다.");
        document.getElementById('pwd').focus();
        return false;
    } else if (document.getElementById('name').value == "") {
        alert("이름을 입력해 주세요");
        document.getElementById('name').focus();
        return false;
    } else if (document.getElementById('email').value == "") {
        alert("이메일을 입력해 주세요");
        document.getElementById('email').focus();
        return false;
    } else if (document.getElementById('zipNum').value == "") {
        alert("주소를 입력해 주세요");
        document.getElementById('zipNum').focus();
        return false;
    } else if (document.getElementById('phone').value == "") {
        alert("휴대폰 번호를 입력해 주세요");
        document.getElementById('phone').focus();
        return false;
    } else if (regExp.test(document.getElementById('phone').value) == false) {
        alert("휴대폰번호 형식이 맞지 않습니다");
        document.getElementById('phone').focus();
        return false;
    }
    else {
        document.getElementById('join').action = "join";
        document.getElementById('join').submit();
    }
}

function getAddress() {
    new daum.Postcode({
        oncomplete: function (data) {
            document.getElementById('zipNum').value = data.zonecode;
            document.getElementById('address').value = data.address;
            document.getElementById('addressDetail').focus();
        }
    }).open();
}

function findId() {
    var url = "find_id_form";
    window.open(url, "_blank_", "toolbar=no", "menubar=no", "scrollbar=yes",
        "resizable=yse");
    window.resizeTo(350, 450);
}

function findMemberId() {
    if (document.getElementById('name').value == "") {
        alert("이름을 입력해 주세요");
        document.getElementById('name').focus();
        return false;
    } else if (document.getElementById('phone').value == "") {
        alert("휴대폰 번호를 입력해 주세요");
        document.getElementById('phone').focus();
        return false;
    } else {
        var form = document.getElementById('findId');
        form.action = "find_id";
        form.submit();
    }
}

function findPwd() {
    var url = "find_pwd_form";
    window.open(url, "_blank_", "toolbar=no", "menubar=no", "scrollbar=yes",
        "resizable=yse");
    window.resizeTo(350, 450);
}

function findPassword() {
    if (document.getElementById('id').value == "") {
        alert("아이디를 입력해 주세요");
        document.getElementById('id').focus();
        return false;
    } else if (document.getElementById('name').value == "") {
        alert("이름을 입력해 주세요");
        document.getElementById('name').focus();
        return false;
    } else if (document.getElementById('phone').value == "") {
        alert("휴대폰 번호를 입력해 주세요");
        document.getElementById('phone').focus();
        return false;
    } else {
        var form = document.getElementById('findPwd');
        form.action = "find_pwd";
        form.submit();
    }
}

function changePassword() {
    if (document.getElementById('pwd').value == "") {
        alert("비밀번호를 입력해 주세요");
        document.getElementById('pwd').focus();
        return false;
    } else if (document.getElementById('pwd').value != document.getElementById('pwdCheck').value) {
        alert("서로 다른 비밀번호 입니다.");
        document.getElementById('pwd').focus();
        return false;
    } else {
        var form = document.getElementById('pwd_form');
        form.action = "change_pwd";
        form.submit();
    }
}