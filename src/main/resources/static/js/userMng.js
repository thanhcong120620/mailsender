var deleteLinks = document.querySelectorAll('.delete');
 
for (var i = 0; i < deleteLinks.length; i++) {
  deleteLinks[i].addEventListener('click', function(event) {
      event.preventDefault();
 
      var choice = confirm(this.getAttribute('data-confirm'));
 
      if (choice) {
        alert("Xóa thành công")
        window.location.href = this.getAttribute('href');
      } else{
        alert("Xóa thất bại")
      }
  });
}

var editLinks = document.querySelectorAll('.edit');
 
for (var i = 0; i < editLinks.length; i++) {
  editLinks[i].addEventListener('click', function(event) {
      event.preventDefault();
 
      var choice = confirm(this.getAttribute('data-confirm'));
 
      if (choice) {
        window.location.href = this.getAttribute('href');
      }
  });
}

function Delete(){
    let choice = confirm("Bạn đồng ý xóa dữ liệu không")
    if(choice==true){
      alert("Xóa thành công");
    } else {
      alert("Xóa thất bại");
    }
}

function FN(){
  var deleteSt = document.getElementById('deleteTotal').value;
  var res = deleteSt.split("-"); 


  var count=0;
  for(let i =0; i< res.length; i++){
    if(!isNaN(res[i]) && !isNaN('')){
      count+=1;
    } 

  }
  if(count!=res.length){
    document.getElementById('error').style.display = "block";
    document.getElementById('btnDelete').style.display = "none";
    document.getElementById('error').innerText = "Lỗi, mời nhập lại";
  } else {
    document.getElementById('error').style.display = "none";
    document.getElementById('btnDelete').style.display = "inline";
  } 
  

}