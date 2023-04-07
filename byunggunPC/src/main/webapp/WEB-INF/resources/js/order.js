/**
 * 
 */
function go_order() {
   if (document.getElementById('name').value == "") {
      alert("이름을 입력해주세요.");
      document.getElementById('name').focus();
      return false;
   } else if (document.getElementById('zipNum').value == "") {
      alert("우편번호를 입력해주세요.");
      document.getElementById('zipNum').focus();
      return false;
   } else if (document.getElementById('address').value == "") {
      alert("주소를 입력해주세요.");
      document.getElementById('address').focus();
      return false;
   } else if (regExp.test(document.getElementById('phone').value) == false) {
      alert("휴대폰번호 형식이 맞지 않습니다");
      document.getElementById('phone').focus();
      return false;
   } else {
      var form = document.getElementById('orderForm');
      form.action = "insert_order";
      form.submit();
   }
}


function go_order_sheet() {
   var form = document.getElementById('theform');
   form.action = "order_sheet";
   form.submit();
}