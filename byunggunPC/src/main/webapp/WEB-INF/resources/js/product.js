/**
 * 
 */
 function updateTotal(){
    var quantity = document.getElementById('quantity').value;
    var price = parseInt("${productVO.price2}");
    var total = quantity * price;
    document.getElementById('total').innerHTML = total;
}

window.onload = function() {
    updateTotal();
  };