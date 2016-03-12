if (window.console) {
    console.log("Welcome to your Play application's JavaScript!");
}

function ativarQtde() {
    document.getElementById("qtde").removeAttribute("disabled");
}

function desativarQtde() {
    document.getElementById("qtde").setAttribute("disabled", "disabled");
}

function ativarEndereco() {
    document.getElementById("endretorno").removeAttribute("disabled");
}

function desativarEndereco() {
    document.getElementById("endretorno").setAttribute("disabled", "disabled");
}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            document.getElementById("preview").setAttribute("src", String(e.target.result));
        }

        reader.readAsDataURL(input.files[0]);
    }
}

function toggleVisMain() {
    var e = document.getElementById("mainDiv");
    e.style.display = (e.style.display == "block") ? "none" : "block";
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function deleteCookie(cname) {
    var d = new Date();
    d.setTime(d.getTime() - (365 * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

function checkCookie() {
    var username = getCookie("username");
    if (username == "") {
        location.href = "/login";
        setCookie("username", "deslogado", 365);
    }
}

function logar() {
    setCookie("username", document.getElementById("nome").value, 365);
    location.href = "/";
}