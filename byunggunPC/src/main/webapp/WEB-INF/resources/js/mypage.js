/**
 *  cartList.jsp에서 삭제여부 체크박스에서 체크한 값들을 배열에 저장해서 넘기기
 */

function go_cart_delete() {
    const query = "input[name=cseq]:checked";
    var len = document.querySelectorAll(query).length;
    console.log("pseq = " + pseq);
    console.log("len =" + len);
    if (len == 0) {
        alert("삭제할 항목을 선택해 주세요")
    } else {
        var form = document.getElementById('theform');
        form.action = "cart_delete";
        form.submit();
    }
}

function go_cart() {
    $.ajax({
        type: 'post',
        url: 'check_quantity',
        datatype: 'json',
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        data: {
            quantity: $("#quantity").val(),
            pseq: $("#pseq").val()
        },
        success: function (qty) {
            console.log(qty)
            if (qty < $("#quantity").val()) {
                alert("상품 재고가 부족합니다 현재 재고량 : " + qty);
                $("#quantity").focus();
                return false;
            } else {
                var form = document.getElementById('theform');
                form.action = "cart_insert";
                form.submit();
            }

        },
        error: function () {
            alert("재고량을 조회하지 못했습니다.")
        }
    })
}

function go_order() {
    var form = document.getElementById('theform');
    form.action = "insert_order";
    form.submit();
}

function deleteOrder() {
    const query = "input[name=oseq]:checked"
    var len = document.querySelectorAll(query).length;
    console.log("oseq.length = " + len);

    if (len == 0) {
        alert("삭제할 항목을 선택해 주세요")
    } else {
        var form = document.getElementById('formm');
        form.action = "order_delete";
        form.submit();
    }
}

$(document).ready(function () {
    getCartCounting();
})

function getCartCounting() {
    $.ajax({
        type: 'post',
        url: 'cart_counting',
        data: $("#cartCounting").serialize(),
        success: function (data) {
            $('#cartCounting').text(data);
        }
    })
}

