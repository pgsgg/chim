/**
 * 
 */
//  function updateTotal(){
//     var quantity = document.getElementById('quantity').value;
//     var price = parseInt("${productVO.price2}");
//     var total = quantity * price;
//     document.getElementById('total').value = total.toLocaleString + "원";
// }

// window.onload = function() {
//     updateTotal();
//   };

function go_search(){
  var form = document.getElementById('searchform');
  form.action = "search";
  form.submit();
}