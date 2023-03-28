/**
 * 로그인 체크
 */

function loginCheck(){
    if(document.getElementById('id').value == ""){
        alert("아이디를 입력해주세요");
        document.getElementById('id').focus();
        return false;
    } else if(document.getElementById('pwd').value == ""){
        alert("비밀번호를 입력해주세요");
        document.getElementById('pwd').focus();
        return false;
    } else {
        var form = document.getElementById('loginForm');
        form.action = "login";
        form.submit();
    }
}
 