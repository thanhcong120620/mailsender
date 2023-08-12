// Phone error
function errorPhone(){
  var valPhone = document.getElementById('phone').value;
  var num = valPhone/2;
  if(valPhone.length ==0){
      document.getElementById('errorPhone').style.display = "block";
      document.getElementById('errorPhone').innerText = "Please enter your phone !";
  } else if((valPhone.length <7 && valPhone.length >0 ) || valPhone.length >= 12 || !Number.isFinite(num)){
      document.getElementById('errorPhone').style.display = "block";
      document.getElementById('errorPhone').innerText = "This's not a phone !";
  } else {
      document.getElementById('errorPhone').style.display = "none";
      document.getElementById('errorPhone').value = "ok";
  }
}
// Email error
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
// Password 1 error
function errorPwd1(){
  const isPasswordSecure = (password) => {
  const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
  return re.test(password);
  };

  var valPwd1 = document.getElementById('password1').value;
  if(valPwd1.length ==0){
      document.getElementById('errorPwd1').style.display = "block";
      document.getElementById('errorPwd1').innerText = "Please enter your password !";
  } else if(!isPasswordSecure(valPwd1)){
      document.getElementById('errorPwd1').style.display = "block";
      document.getElementById('errorPwd1').innerText = "Not is a strong password";
      alert("Password must has at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)")
  } 
  else {
      document.getElementById('errorPwd1').style.display = "none";
      document.getElementById('errorPwd1').value = "ok";
  }
}
// Password 2 error
function errorPwd2(){
  var valPwd1 = document.getElementById('password1').value;
  var valPwd2 = document.getElementById('password2').value;
  if(valPwd2.length ==0){
      document.getElementById('errorPwd2').style.display = "block";
      document.getElementById('errorPwd2').innerText = "Please enter your password !";
  } else if(valPwd2 != valPwd1){
      document.getElementById('errorPwd2').style.display = "block";
      document.getElementById('errorPwd2').innerText = "Password not match !";
  } 
  else {
      document.getElementById('errorPwd2').style.display = "none";
      document.getElementById('errorPwd2').value = "ok";
  }
}

































// var pwd1 = document.getElementById('pwd1');
// var eye1 = document.getElementById('eye1');
// var pwd2 = document.getElementById('pwd2');
// var eye2 = document.getElementById('eye2');

// eye1.addEventListener('click',togglePass);
// eye2.addEventListener('click',togglePass);

// function togglePass(){

//    eye1.classList.toggle('active');
//    (pwd1.type == 'password') ? pwd1.type = 'text' : pwd1.type = 'password';

//    eye2.classList.toggle('active');
//    (pwd2.type == 'password') ? pwd2.type = 'text' : pwd2.type = 'password';
// }

// // Form Validation

// function checkStuff() {
//   var email = document.form2.email;
//   var phone = document.form2.phone;
//   var password1 = document.form2.password1;
//   var password2 = document.form2.password2;
//   var msg = document.getElementById('msg');
  
//   if (email.value == "") {
//     msg.style.display = 'block';
//     msg.innerHTML = "Please enter your email";
//     email.focus();
//     return false;
//   } else {
//     msg.innerHTML = "";
//   }

//   var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//   if (!re.test(email.value)) {
//     msg.innerHTML = "Please enter a valid email";
//     email.focus();
//     return false;
//   } else {
//     msg.innerHTML = "";
//   }

//   //check phone
//   if (phone.value == "") {
//     msg.style.display = 'block';
//     msg.innerHTML = "Please enter your phone number";
//     phone.focus();
//     return false;
//   }
//   else {
//     msg.innerHTML = "";
//   }
  
//  //check password1
//   if (password1.value == "") {
//    msg.style.display = 'block';
//    msg.innerHTML = "Please enter your password";
//    password1.focus();
//    return false;
//  } else if (password1.value.length < 5){
//    msg.innerHTML = "Password must be at least 5 characters";
//    password1.focus();
//    return false;
//  }
//  else {
//    msg.innerHTML = "";
//  }
//  //check password2
//  if (password2.value == "") {
//    msg.style.display = 'block';
//    msg.innerHTML = "Please enter your password again";
//    password2.focus();
//    return false;
//  } else if (password2.value != password1.value){
//    msg.innerHTML = "Password not matches";
//    password2.focus();
//    return false;
//  }
//  else {
//    msg.innerHTML = "";
//    alert("Get new password successfully !");
//  }


// }

// // ParticlesJS

// // ParticlesJS Config.
// particlesJS("particles-js", {
//   "particles": {
//     "number": {
//       "value": 60,
//       "density": {
//         "enable": true,
//         "value_area": 800
//       }
//     },
//     "color": {
//       "value": "#ffffff"
//     },
//     "shape": {
//       "type": "circle",
//       "stroke": {
//         "width": 0,
//         "color": "#000000"
//       },
//       "polygon": {
//         "nb_sides": 5
//       },
//       "image": {
//         "src": "img/github.svg",
//         "width": 100,
//         "height": 100
//       }
//     },
//     "opacity": {
//       "value": 0.1,
//       "random": false,
//       "anim": {
//         "enable": false,
//         "speed": 1,
//         "opacity_min": 0.1,
//         "sync": false
//       }
//     },
//     "size": {
//       "value": 6,
//       "random": false,
//       "anim": {
//         "enable": false,
//         "speed": 40,
//         "size_min": 0.1,
//         "sync": false
//       }
//     },
//     "line_linked": {
//       "enable": true,
//       "distance": 150,
//       "color": "#ffffff",
//       "opacity": 0.1,
//       "width": 2
//     },
//     "move": {
//       "enable": true,
//       "speed": 1.5,
//       "direction": "top",
//       "random": false,
//       "straight": false,
//       "out_mode": "out",
//       "bounce": false,
//       "attract": {
//         "enable": false,
//         "rotateX": 600,
//         "rotateY": 1200
//       }
//     }
//   },
//   "interactivity": {
//     "detect_on": "canvas",
//     "events": {
//       "onhover": {
//         "enable": false,
//         "mode": "repulse"
//       },
//       "onclick": {
//         "enable": false,
//         "mode": "push"
//       },
//       "resize": true
//     },
//     "modes": {
//       "grab": {
//         "distance": 400,
//         "line_linked": {
//           "opacity": 1
//         }
//       },
//       "bubble": {
//         "distance": 400,
//         "size": 40,
//         "duration": 2,
//         "opacity": 8,
//         "speed": 3
//       },
//       "repulse": {
//         "distance": 200,
//         "duration": 0.4
//       },
//       "push": {
//         "particles_nb": 4
//       },
//       "remove": {
//         "particles_nb": 2
//       }
//     }
//   },
//   "retina_detect": true
// });