function information(){
    alert("Cập nhật thành công !");
}

function reset() {
    document.getElementById('passwordUser').innerText = "Reset password";
    document.getElementById('passwordUser').value = "Reset password";
}

//Setup display of password
// step 1
const ipnElement = document.querySelector('#ipnPassword')
const currentType = ipnElement.getAttribute('type')
ipnElement.setAttribute(
    'type',
    currentType === 'password' ? 'text' : 'password'
  )

/*
// step 1
const ipnElement = document.querySelector('#ipnPassword')
const btnElement = document.querySelector('#btnPassword')
// step 2
btnElement.addEventListener('click', function() {
  // step 3
  const currentType = ipnElement.getAttribute('type')
  // step 4
  ipnElement.setAttribute(
    'type',
    currentType === 'password' ? 'text' : 'password'
  )
})
*/