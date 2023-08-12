/** Case 1: */

// Name error
function errorName(){
    var valName = document.getElementById('nameUser').value;
    if(valName.length ==0){
        document.getElementById('errorName').style.display = "block";
        document.getElementById('errorName').innerText = "Please enter your name !";
    } else if((valName.length <3 && valName.length >0 ) || valName.length >= 25){
        document.getElementById('errorName').style.display = "block";
        document.getElementById('errorName').innerText = "This's not a name !";
    } else {
        document.getElementById('errorName').style.display = "none";
        document.getElementById('errorName').value = "ok";
    }
}
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
// Address error
function errorAddress(){
    var valAddress = document.getElementById('address').value;
    if(valAddress.length ==0){
        document.getElementById('errorAddress').style.display = "block";
        document.getElementById('errorAddress').innerText = "Please enter your address !";
    } else if((valAddress.length <3 && valAddress.length >0 ) || valAddress.length >= 100){
        document.getElementById('errorAddress').style.display = "block";
        document.getElementById('errorAddress').innerText = "This's not a address !";
    } else {
        document.getElementById('errorAddress').style.display = "none";
        document.getElementById('errorAddress').value = "ok";
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

/**submit data**/

function checkuser() {
    var checkMail = document.getElementById('errorMail').value;
    var checkPwd1 = document.getElementById('errorPwd1').value;
    var checkPwd2 = document.getElementById('errorPwd2').value;
    var checkName = document.getElementById('errorName').value;
    var checkPhone = document.getElementById('errorPhone').value;
    var checkAddress = document.getElementById('errorAddress').value;
    

    if(checkMail=="ok"&&checkPwd1=="ok"&&checkPwd2=="ok"&&checkName=="ok"&&checkPhone=="ok"&&checkAddress=="ok"){
        document.getElementById('btnCreateUser').style.display = "block" ;
        document.getElementById('warning').style.display = "none";

        alert("Data is saved successfully, press Create to create your account !")
    } else {
        alert("Please enter valid data before create account !")
        document.getElementById('warning').style.display = "block";
        document.getElementById('btnCreateUser').style.display = "none";
    }
}




















































/** Case 2: */
// const form  = document.getElementById('form');
// const email = document.getElementById('email');
// const password1 = document.getElementById('password1');
// const password2 = document.getElementById('password2');
// const name = document.getElementById('nameUser');
// const phone = document.getElementById('phone');
// const address = document.getElementById('address');

// const errorEmail = document.getElementById('errorEmail');
// const errorPassword1 = document.getElementById('errorPassword1');
// const errorPassword2 = document.getElementById('errorPassword2');
// const errorName = document.getElementById('errorName');   
// const errorPhone = document.getElementById('errorPhone'); 
// const errorAddress = document.getElementById('errorAddress');  

// form.addEventListener('submit', (e) => {
//     let messagesEmail = [];
//     let messagesPwd1 = [];
//     let messagesPwd2 = [];
//     let messagesName = [];
//     let messagesAddress = [];
//     let messagesPhone = [];
    
//     if(username.value === "" || username.value == null){
//         messagesName.push("Please enter your name again");
//     }
//     if(password1.value === "" || password1.value == null){
//         messagesPwd1.push("Please enter your password again");
//     }
//     if(password2.value === "" || password2.value == null || password2.value != password1.value){
//         messagesPwd2.push("Password not match");
//     }
//     if(address.value === "" || address.value == null){
//         messagesAddress.push("Please enter your address again");
//     }
//     if(phone.value === "" || phone.value == null){
//         messagesPhone.push("Please enter your phone number again");
//     }

//     if(email.value === "" || email.value == null){
//         messagesEmail.push("Please enter your email again");
//     }
//     var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//     if (!re.test(email.value)) {
//         messagesEmail.push("Please enter a valid email");
//         // email.focus();
//     } 

//     if(messagesEmail.length > 0 || messagesPwd1.length > 0 || messagesPwd2.length > 0 || messagesName >0 
//         || messagesPhone >0|| messagesAddress >0){
//         e.preventDefault();
//         errorEmail.innerText = messagesEmail.join(', ');
//         errorPassword1.innerText = messagesPwd1.join(', ');;
//         errorPassword2.innerText = messagesPwd2.join(', ');;
//         errorPhone.innerText = messagesPhone.join(', ');
//         errorName.innerText = messagesName.join(', ');
//         errorAddress.innerText = messagesAddress.join(', ');
//     }

// });

/** Case 3: */

// const usernameEl = document.querySelector('#username');
// const emailEl = document.querySelector('#email');
// const passwordEl = document.querySelector('#password');
// const confirmPasswordEl = document.querySelector('#confirm-password');

// const form = document.querySelector('#signup');


// const checkUsername = () => {

//     let valid = false;

//     const min = 3,
//         max = 25;
//     const username = usernameEl.value.trim();

//     if (!isRequired(username)) {
//         showError(usernameEl, 'Username cannot be blank.');
//     } else if (!isBetween(username.length, min, max)) {
//         showError(usernameEl, `Username must be between ${min} and ${max} characters.`)
//     } else {
//         showSuccess(usernameEl);
//         valid = true;
//     }
//     return valid;
// };


// const checkEmail = () => {
//     let valid = false;
//     const email = emailEl.value.trim();
//     if (!isRequired(email)) {
//         showError(emailEl, 'Email cannot be blank.');
//     } else if (!isEmailValid(email)) {
//         showError(emailEl, 'Email is not valid.')
//     } else {
//         showSuccess(emailEl);
//         valid = true;
//     }
//     return valid;
// };

// const checkPassword = () => {
//     let valid = false;


//     const password = passwordEl.value.trim();

//     if (!isRequired(password)) {
//         showError(passwordEl, 'Password cannot be blank.');
//     } else if (!isPasswordSecure(password)) {
//         showError(passwordEl, 'Password must has at least 8 characters that include at least 1 lowercase character, 1 uppercase characters, 1 number, and 1 special character in (!@#$%^&*)');
//     } else {
//         showSuccess(passwordEl);
//         valid = true;
//     }

//     return valid;
// };

// const checkConfirmPassword = () => {
//     let valid = false;
//     // check confirm password
//     const confirmPassword = confirmPasswordEl.value.trim();
//     const password = passwordEl.value.trim();

//     if (!isRequired(confirmPassword)) {
//         showError(confirmPasswordEl, 'Please enter the password again');
//     } else if (password !== confirmPassword) {
//         showError(confirmPasswordEl, 'The password does not match');
//     } else {
//         showSuccess(confirmPasswordEl);
//         valid = true;
//     }

//     return valid;
// };

// const isEmailValid = (email) => {
//     const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//     return re.test(email);
// };

// const isPasswordSecure = (password) => {
//     const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
//     return re.test(password);
// };

// const isRequired = value => value === '' ? false : true;
// const isBetween = (length, min, max) => length < min || length > max ? false : true;


// const showError = (input, message) => {
//     // get the form-field element
//     const formField = input.parentElement;
//     // add the error class
//     formField.classList.remove('success');
//     formField.classList.add('error');

//     // show the error message
//     const error = formField.querySelector('small');
//     error.textContent = message;
// };

// const showSuccess = (input) => {
//     // get the form-field element
//     const formField = input.parentElement;

//     // remove the error class
//     formField.classList.remove('error');
//     formField.classList.add('success');

//     // hide the error message
//     const error = formField.querySelector('small');
//     error.textContent = '';
// }


// form.addEventListener('submit', function (e) {
//     // prevent the form from submitting
//     e.preventDefault();

//     // validate fields
//     let isUsernameValid = checkUsername(),
//         isEmailValid = checkEmail(),
//         isPasswordValid = checkPassword(),
//         isConfirmPasswordValid = checkConfirmPassword();

//     let isFormValid = isUsernameValid &&
//         isEmailValid &&
//         isPasswordValid &&
//         isConfirmPasswordValid;

//     // submit to the server if the form is valid
//     if (isFormValid) {

//     }
// });


// const debounce = (fn, delay = 500) => {
//     let timeoutId;
//     return (...args) => {
//         // cancel the previous timer
//         if (timeoutId) {
//             clearTimeout(timeoutId);
//         }
//         // setup a new timer
//         timeoutId = setTimeout(() => {
//             fn.apply(null, args)
//         }, delay);
//     };
// };

// form.addEventListener('input', debounce(function (e) {
//     switch (e.target.id) {
//         case 'username':
//             checkUsername();
//             break;
//         case 'email':
//             checkEmail();
//             break;
//         case 'password':
//             checkPassword();
//             break;
//         case 'confirm-password':
//             checkConfirmPassword();
//             break;
//     }
// }));









