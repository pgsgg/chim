/**
 *  cartList.jsp에서 삭제여부 체크박스에서 체크한 값들을 배열에 저장해서 넘기기
 */

function go_cart_delete(){
   const query = "input[name=cseq]:checked";

   var len = document.querySelectorAll(query).length;
    console.log("len =" + len);
    if (len == 0) {
        alert("삭제할 항목을 선택해 주세요")
    } else {
        var form = document.getElementById('theform');
        form.action = "cart_delete";
        form.submit();
    }
}

function go_cart(){
    var form = document.getElementById('theform');
    form.action = "cart_insert";
    form.submit();
}

function go_order(){
    var form = document.getElementById('theform');
    form.action = "insert_order";
    form.submit();
}

function deleteOrder(){
    const query = "input[name=oseq]:checked"

    var len = document.querySelectorAll(query).length;
    console.log("oseq.length = "+ len);

    if(len == 0){
        alert("삭제할 항목을 선택해 주세요")
    } else {
        var form = document.getElementById('formm');
        form.action = "order_delete";
        form.submit();
    }
}
