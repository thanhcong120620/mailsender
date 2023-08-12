function errorMail(){
    var valMail = document.getElementById('email').value;
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(valMail.length ==0){
        document.getElementById('errorMail').style.display = "block";
        document.getElementById('errorMail').innerText = "Please enter your email !";
    } else if(!re.test(email.value)){
        document.getElementById('errorMail').style.display = "block";
        document.getElementById('errorMail').innerText = "This's not a email !";
    }
    else {
        document.getElementById('errorMail').style.display = "none";
        document.getElementById('errorMail').value = "ok";
    }
  }