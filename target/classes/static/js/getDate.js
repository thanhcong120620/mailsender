$(function () {
    $("#datepicker").datepicker();
  });

function result() {
    var valPwd1 = document.getElementById('datepicker').value;
    document.getElementById('demo').innerText = valPwd1;
}  