/** Script left */
function errorMail(){
    var valMail = document.getElementById('email').value;
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(valMail.length ==0){
        document.getElementById('errorMail').style.display = "block";
        document.getElementById('errorMail').innerText = "Gmail không được để trống !";
    } else if(!re.test(email.value)){
        document.getElementById('errorMail').style.display = "block";
        document.getElementById('errorMail').innerText = "Đây không phải là Gmail !";
    }
    else {
        document.getElementById('errorMail').style.display = "none";
        document.getElementById('errorMail').value = "ok";
    }
  }
  // Password 1 error
  function errorPassword(){
  
    var valPwd1 = document.getElementById('password1').value;
    if(valPwd1.length ==0){
        document.getElementById('errorPwd1').style.display = "block";
        document.getElementById('errorPwd1').innerText = "Mật khẩu không được trống !";
    }
    else {
        document.getElementById('errorPwd1').style.display = "none";
        document.getElementById('errorPwd1').value = "ok";
    }
  }

//eye
const ipnElement1 = document.querySelector('#password1')
const btnElement1 = document.querySelector('#btnPassword1')

btnElement1.addEventListener('click', function() {
  const currentType1 = ipnElement1.getAttribute('type')
  ipnElement1.setAttribute(
    'type',
    currentType1 === 'text' ? 'password' : 'text'
  )
})



/** Script mid */
//Xóa hàng loạt
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

function FN2(){
    var deleteSt = document.getElementById('deleteTotal').value;

    if(deleteSt==""){
      document.getElementById('error2').style.display = "block";
      document.getElementById('error2').innerText = "Nhập dữ liệu để xóa";
    } else {
      document.getElementById('error2').style.display = "none";
    } 
  }




//Xóa 1 hàng
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




/** Script right */
function errorCodeDraw(){
  
    var valCodeDraw = document.getElementById('codeDraw').value;
    var num = valCodeDraw/2;

    if(valCodeDraw.length ==0){
        document.getElementById('errorcodeDraw').style.display = "block";
        document.getElementById('errorcodeDraw').innerText = "Mã vé không được trống !";
    } else if(!Number.isFinite(num) || valCodeDraw.length <6){
        document.getElementById('errorcodeDraw').style.display = "block";
        document.getElementById('errorcodeDraw').innerText = "Mã vé không tồn tại !";
    }
    else {
        document.getElementById('errorcodeDraw').style.display = "none";
        document.getElementById('errorcodeDraw').value = "ok";
    }
  }







