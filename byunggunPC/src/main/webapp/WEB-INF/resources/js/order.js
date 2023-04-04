/**
 * 
 */
 function go_order(){
    var form = document.getElementById('theform');
    form.action = "insert_order";
    form.submit();
 }