// Setup ngày tháng
var date = document.getElementById('date');
var month = document.getElementById('month');
var year = document.getElementById('year');
var dateValue = '';
var monthValue = '';
var yearValue = '';
for(let i = 1; i <= 31; i++) {
    dateValue += "<option>"+i+"</option>";
}
for(let i = 1; i <= 12; i++) {
    monthValue += "<option>"+i+"</option>";
}
for(let i = 2020; i >= 1905; i--) {
    yearValue += "<option>"+i+"</option>";
}
date.innerHTML = dateValue;
month.innerHTML = monthValue;
year.innerHTML = yearValue;
// Event kiểm tra khi input rỗng
var surname = document.getElementById('surname');
var _name = document.getElementById('name');
var phone = document.getElementById('phone');
var email = document.getElementById('email');
var user = document.getElementById('user');
var pass = document.getElementById('pass');
document.getElementById('alert_id').style.display = "none";
surname.addEventListener("focusout", focus);
_name.addEventListener("focusout", focus);
phone.addEventListener("focusout", focus);
phone.addEventListener("focusout", validatePhone);
email.addEventListener("focusout", focus);
email.addEventListener("focusout", validateEmail);
user.addEventListener("focusout", focus);
pass.addEventListener("focusout", focus);
// Hàm onfocusout 
function focus() {
    if(surname.value === ''||
        _name.value === ''||
        phone.value === ''||
        email.value === ''||
        user.value === ''||
        pass.value === ''
        ) {
        document.getElementById('alert_id').style.display = "block";
    }else {
        document.getElementById('alert_id').style.display = "none";
    }
}

// điều kiện số điện thoại
// chuỗi số đt Việt nam với 10 số và đầu 09, 03, 07, 05, 03
var phoneRegex = /((09|03|07|08|05)([0-9]{8})\b)/g;
// chuỗi email
var mailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
var checkPhone = document.getElementById('check_phone');
var checkEmail = document.getElementById('check_mail');
var checkDate = document.getElementById('checkDate');
checkPhone.style.display = "none";
checkEmail.style.display = "none";
// Hàm kiểm tra số điẹn thoại
function validatePhone() {
    if(!phoneRegex.test(phone.value)) {
        checkPhone.style.display = "block";
        checkPhone.innerHTML = "<img src=\"./image/error.png\"><span id=\"error\">Sai dạng số điện thoại</span>";
    } else {
        checkPhone.style.display = "none";
    }
}
// Hàm kiểm tra email
function validateEmail() {
    if(!mailRegex.test(email.value)) {
        checkEmail.style.display = "block";
        checkEmail.innerHTML = "<img src=\"./image/error.png\"><span id=\"error\">Sai dạng email</span>";
    } else {
        checkEmail.style.display = "none";
    }
}

// check Date
var checkDate = document.getElementById('checkDate');
checkDate.style.display = "none";
// kiểm tra ngày tháng
function validate() {
    let d = parseInt(date.value);
    let m = parseInt(month.value);
    let y = parseInt(year.value);
    if( (y % 100 == 0 && y % 4 != 0) ||y % 4 != 0) {
        switch(m) {
            case 4:
            case 6:
            case 9:
            case 11:
                if(d > 30) {
                    checkDate.style.display = "block";
                } else {
                    checkDate.style.display = "none";
                }
                break;
            case 2:
                if(d > 28) {
                    checkDate.style.display = "block";
                } else {
                    checkDate.style.display = "none";
                }
                break;
        }
    } else {
        switch(m) {
            case 4:
            case 6:
            case 9:
            case 11:
                if(d > 30) {
                    checkDate.style.display = "block";
                } else {
                    checkDate.style.display = "none";
                }
                break;
            case 2:
                if(d > 29) {
                    checkDate.style.display = "block";
                } else {
                    checkDate.style.display = "none";
                }
                break;
        }
    }
}

function _click() {
    alert("Thành công");
}