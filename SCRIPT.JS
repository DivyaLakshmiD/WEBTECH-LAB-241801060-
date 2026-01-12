function validateForm() {
  let valid = true;

  document.querySelectorAll(".error").forEach(e => e.innerHTML = "");

  let fname = document.getElementById("fname").value;
  if (!/^[A-Za-z]{6,}$/.test(fname)) {
    document.getElementById("fnameErr").innerHTML =
      "First name must be alphabets & min 6 chars";
    valid = false;
  }

  let pass = document.getElementById("pass").value;
  if (pass.length < 6) {
    document.getElementById("passErr").innerHTML =
      "Password must be at least 6 characters";
    valid = false;
  }

  let email = document.getElementById("email").value;
  if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
    document.getElementById("emailErr").innerHTML =
      "Invalid email format";
    valid = false;
  }

  let mobile = document.getElementById("mobile").value;
  if (!/^\d{10}$/.test(mobile)) {
    document.getElementById("mobileErr").innerHTML =
      "Mobile must be 10 digits";
    valid = false;
  }

  if (document.getElementById("lname").value === "") {
    document.getElementById("lnameErr").innerHTML =
      "Last name required";
    valid = false;
  }

  if (document.getElementById("address").value === "") {
    document.getElementById("addrErr").innerHTML =
      "Address required";
    valid = false;
  }

  return valid;
}
