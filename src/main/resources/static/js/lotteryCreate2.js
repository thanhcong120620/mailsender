function createRegionCode(){

    var regionName = document.getElementById('regionId').value;
    var regionCity = document.getElementById('regionCity').value;
    // console.log(regionName);
    if(regionName == "Miền Bắc"){
        var x2 ="";
        if(regionCity == "Hà Nội"){
            x2 = "-HN"
        } else if(regionCity == "Hải Phòng"){
            x2 = "-HP"
        }else {
            x2="-không khớp miền/vùng"
        }
        /* 
        else if(regionCity == ""){
            x2 = "-";
        }
        */
        let x1 = "MB";
        let x = x1 + x2;
        document.getElementById('btnCreateLottery').value = x;
        document.getElementById('regionCode').innerText = x;
        document.getElementById('step2').innerText = x;
    } else if(regionName == "Miền Trung"){
        var y2 ="";
        if(regionCity == "Đà Nẵng"){
            y2 = "-DN";
        } else if(regionCity == "Đăk Lăk"){
            y2 = "-DL";
        } else {
            y2="-không khớp miền/vùng"
        }
        /* 
        else if(regionCity == ""){
            y2 = "-";
        }
        */

        let y1 = "MT";
        let y = y1 + y2;
        document.getElementById('btnCreateLottery').value = y;
        document.getElementById('regionCode').innerText = y;
        document.getElementById('step2').innerText = y;
    } else if(regionName == "Miền Nam"){
        var z2 ="";
        if(regionCity == "Thành phố Hồ Chí Minh"){
            z2 = "-SG";
        } else if(regionCity == "Cần Thơ"){
            z2 = "-CT";
        }else {
            z2="-không khớp miền/vùng"
        }
        /* 
        else if(regionCity == ""){
            z2 = "-";
        }
        */

        let z1 = "MN";
        let z = z1 + z2;
        document.getElementById('btnCreateLottery').value = z;
        document.getElementById('regionCode').innerText = z;
        document.getElementById('step2').innerText = z;
    } else {
        document.getElementById('createLotteryCode').value = null;
        document.getElementById('regionCode').innerText = "Vui lòng chọn miền/vùng để lấy mã vé";
    }
}

function btnCreate() {
    var regionId = document.getElementById('regionId').value;
    if(regionId == "null") {
        alert("Tạo vé thất bại, vui lòng hoàn thành thông tin");
    } else {
    var createLotteryCode = document.getElementById('createLotteryCode').value;
    document.getElementById("demo").innerHTML = createLotteryCode;
    alert("Đã lấy mã vé " + createLotteryCode + ", tiếp tục bước 2 để tạo vé");
    }
}


// Các hàm xử lý lỗi nhập dữ liệu vé
function checkLottery() {
    var checkG8 = document.getElementById('error-g8').value;
    var checkG7 = document.getElementById('error-g7').value;
    var checkG61 = document.getElementById('error-g61').value;
    var checkG62 = document.getElementById('error-g62').value;
    var checkG63 = document.getElementById('error-g63').value;
    var checkG5 = document.getElementById('error-g5').value;
    var checkG41 = document.getElementById('error-g41').value;
    var checkG42 = document.getElementById('error-g42').value;
    var checkG43 = document.getElementById('error-g43').value;
    var checkG44 = document.getElementById('error-g44').value;
    var checkG45 = document.getElementById('error-g45').value;
    var checkG46 = document.getElementById('error-g46').value;
    var checkG47 = document.getElementById('error-g47').value;
    var checkG31 = document.getElementById('error-g31').value;
    var checkG32 = document.getElementById('error-g32').value;
    var checkG2 = document.getElementById('error-g2').value;
    var checkG1 = document.getElementById('error-g1').value;
    var checkGDB = document.getElementById('error-gDB').value;

    if(checkG8=="ok"&&checkG7=="ok"&&checkG61=="ok"&&checkG62=="ok"&&checkG63=="ok"&&checkG5=="ok"
    &&checkG41=="ok"&&checkG42=="ok"&&checkG43=="ok"&&checkG44=="ok"&&checkG45=="ok"&&checkG46=="ok"&&checkG47=="ok"
    &&checkG31=="ok"&&checkG32=="ok"&&checkG2=="ok"&&checkG1=="ok"&&checkGDB=="ok"){
        document.getElementById('btnCreateLottery').style.display = "block";
        document.getElementById('warning').style.display = "none";
		alert("Tạo vé thành công, nhấn Submit lưu dữ liệu !")
    } else {
        alert("Vui lòng nhập đúng dữ liệu trước khi tạo vé !!!")
        document.getElementById('warning').style.display = "block";
        document.getElementById('btnCreateLottery').style.display = "none";
    }
        
}




// Hàm xử lý lỗi giải 8 
function errorG8(){
    var valG8 = document.getElementById('g8').value;
    if(valG8.length !=2){
        document.getElementById('error-g8').style.display = "block";
        document.getElementById('error-g8').innerText = "Vui lòng nhập 2 chữ số";
    } else {
        document.getElementById('error-g8').style.display = "none";
        document.getElementById('error-g8').value = "ok";
    }

}
// Hàm xử lý lỗi giải 7
function errorG7(){
    var valG7 = document.getElementById('g7').value;
    if(valG7.length !=3){
        document.getElementById('error-g7').style.display = "block";
        document.getElementById('error-g7').innerText = "Vui lòng nhập 3 chữ số";
    } else {
        document.getElementById('error-g7').style.display = "none";
        document.getElementById('error-g7').value = "ok";
    }

}
// Hàm xử lý lỗi giải 6
function errorG6(){
    var valG61 = document.getElementById('g61').value;
    var valG62 = document.getElementById('g62').value;
    var valG63 = document.getElementById('g63').value;

    if(valG61.length !=4){
        document.getElementById('error-g61').style.display = "block";
        document.getElementById('error-g61').innerText = "Vui lòng nhập 4 chữ số";
    } else {
        document.getElementById('error-g61').style.display = "none";
        document.getElementById('error-g61').value = "ok";
    }
        
    if(valG62.length !=4){
        document.getElementById('error-g62').style.display = "block";
        document.getElementById('error-g62').innerText = "Vui lòng nhập 4 chữ số";
    } else {
        document.getElementById('error-g62').style.display = "none";
        document.getElementById('error-g62').value = "ok";
    }
        
    if(valG63.length !=4){
        document.getElementById('error-g63').style.display = "block";
        document.getElementById('error-g63').innerText = "Vui lòng nhập 4 chữ số";
    } else {
        document.getElementById('error-g63').style.display = "none";
        document.getElementById('error-g63').value = "ok";
    }

}
// Hàm xử lý lỗi giải 5
function errorG5(){
    var valG5 = document.getElementById('g5').value;
    if(valG5.length !=4){
        document.getElementById('error-g5').style.display = "block";
        document.getElementById('error-g5').innerText = "Vui lòng nhập 4 chữ số";
    } else {
        document.getElementById('error-g5').style.display = "none";
        document.getElementById('error-g5').value = "ok";
    }

}
// Hàm xử lý lỗi giải 4
function errorG4(){
    var valG41 = document.getElementById('g41').value;
    var valG42 = document.getElementById('g42').value;
    var valG43 = document.getElementById('g43').value;
    var valG44 = document.getElementById('g44').value;
    var valG45 = document.getElementById('g45').value;
    var valG46 = document.getElementById('g46').value;
    var valG47 = document.getElementById('g47').value;

    if(valG41.length !=5){
        document.getElementById('error-g41').style.display = "block";
        document.getElementById('error-g41').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g41').style.display = "none";
        document.getElementById('error-g41').value = "ok";
    }
    if(valG42.length !=5){
        document.getElementById('error-g42').style.display = "block";
        document.getElementById('error-g42').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g42').style.display = "none";
        document.getElementById('error-g42').value = "ok";
    }

    if(valG43.length !=5){
        document.getElementById('error-g43').style.display = "block";
        document.getElementById('error-g43').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g43').style.display = "none";
        document.getElementById('error-g43').value = "ok";
    }

    if(valG44.length !=5){
        document.getElementById('error-g44').style.display = "block";
        document.getElementById('error-g44').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g44').style.display = "none";
        document.getElementById('error-g44').value = "ok";
    }
   
    if(valG45.length !=5){
        document.getElementById('error-g45').style.display = "block";
        document.getElementById('error-g45').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g45').style.display = "none";
        document.getElementById('error-g45').value = "ok";
    }
    
    if(valG46.length !=5){
        document.getElementById('error-g46').style.display = "block";
        document.getElementById('error-g46').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g46').style.display = "none";
        document.getElementById('error-g46').value = "ok";
    }
    
    if(valG47.length !=5){
        document.getElementById('error-g47').style.display = "block";
        document.getElementById('error-g47').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g47').style.display = "none";
        document.getElementById('error-g47').value = "ok";
    }

}
// Hàm xử lý lỗi giải 3
function errorG3(){
    var valG31 = document.getElementById('g31').value;
    var valG32 = document.getElementById('g32').value;
    if(valG31.length !=5){
        document.getElementById('error-g31').style.display = "block";
        document.getElementById('error-g31').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g31').style.display = "none";
        document.getElementById('error-g31').value = "ok";
    }
    if(valG32.length !=5){
        document.getElementById('error-g32').style.display = "block";
        document.getElementById('error-g32').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g32').style.display = "none";
        document.getElementById('error-g32').value = "ok";
    }

}
// Hàm xử lý lỗi giải 2
function errorG2(){
    var valG2 = document.getElementById('g2').value;
    if(valG2.length !=5){
        document.getElementById('error-g2').style.display = "block";
        document.getElementById('error-g2').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g2').style.display = "none";
        document.getElementById('error-g2').value = "ok";
    }

}
// Hàm xử lý lỗi giải 1
function errorG1(){
    var valG1 = document.getElementById('g1').value;
    if(valG1.length !=5){
        document.getElementById('error-g1').style.display = "block";
        document.getElementById('error-g1').innerText = "Vui lòng nhập 5 chữ số";
    } else {
        document.getElementById('error-g1').style.display = "none";
        document.getElementById('error-g1').value = "ok";
    }

}
// Hàm xử lý lỗi giải ĐB
function errorGDB(){
    var valGDB = document.getElementById('gDB').value;
    if(valGDB.length !=6){
        document.getElementById('error-gDB').style.display = "block";
        document.getElementById('error-gDB').innerText = "Vui lòng nhập 6 chữ số";
    } else {
        document.getElementById('error-gDB').style.display = "none";
        document.getElementById('error-gDB').value = "ok";
    }

}


