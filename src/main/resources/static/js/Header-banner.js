function showTime() {
    var d = new Date();
    document.getElementById("time").innerHTML = d.toLocaleTimeString();
}

var intervalID = setInterval(showTime, 1000);

//get day and time
var today = new Date();
var date = ' Ngày '+today.getDate()+' tháng '+(today.getMonth()+1)+' năm '+today.getFullYear();
// var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
// var dateTime = date+' '+time;

// document.getElementById("hvn").innerHTML = dateTime;
document.getElementById("hvn").innerHTML = date;