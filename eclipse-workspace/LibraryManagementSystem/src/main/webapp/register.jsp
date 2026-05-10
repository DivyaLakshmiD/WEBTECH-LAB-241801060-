<!DOCTYPE html>
<html>
<head>
<title>Library Registration</title>

<script>
function validateForm() {

let fname = document.forms["regForm"]["fname"].value;
let lname = document.forms["regForm"]["lname"].value;
let email = document.forms["regForm"]["email"].value;
let password = document.forms["regForm"]["password"].value;
let mobile = document.forms["regForm"]["mobile"].value;
let address = document.forms["regForm"]["address"].value;

let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
let namePattern = /^[A-Za-z]+$/;

if(!namePattern.test(fname) || fname.length < 6){
alert("First name must be alphabets and minimum 6 characters");
return false;
}

if(lname==""){
alert("Last name cannot be empty");
return false;
}

if(password.length < 6){
alert("Password must be at least 6 characters");
return false;
}

if(!email.match(emailPattern)){
alert("Enter valid email");
return false;
}

if(mobile.length != 10 || isNaN(mobile)){
alert("Mobile must be 10 digits");
return false;
}

if(address==""){
alert("Address cannot be empty");
return false;
}

alert("Form Submitted");
return true;
}
</script>
</head>

<body>

<h2>Library Registration Form</h2>

<form name="regForm" action="RegisterServlet" method="post" onsubmit="return validateForm()">

First Name:
<input type="text" name="fname"><br><br>

Last Name:
<input type="text" name="lname"><br><br>

Email:
<input type="text" name="email"><br><br>

Password:
<input type="password" name="password"><br><br>

Mobile:
<input type="text" name="mobile"><br><br>

Address:
<textarea name="address"></textarea><br><br>

<input type="submit" value="Register">

</form>

</body>
</html>