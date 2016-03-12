if (window.console) {
    console.log("Welcome to your Play application's JavaScript!");
}

// ativar e desativar campos de texto
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

// mostrar e esconder o main
function esconderMain() {
    document.getElementById("mainDiv").setAttribute("class", "container hidden");
}

function mostrarMain() {
    document.getElementById("mainDiv").setAttribute("class", "container visible");
}

// aceitar, recusar, ignorar e solicitar caronas
function aceitarSolicitacao() {
    alert("Carona aceita. Telefone do passageiro: (83) 9 9876-5432.");
}

function recusarSolicitacao() {
    alert("Carona ignorada.");
}

function solicitarCarona() {
    alert("Carona solicitada.")
}

function ignorarCarona() {
    alert("Carona ignorada.")
}


// mostrar imagem no cadastro
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            document.getElementById("preview").setAttribute("src", String(e.target.result));
        }

        reader.readAsDataURL(input.files[0]);
    }
}


// brincar com cookies
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
    var visibility = getCookie("visibility");
    if (username == "") {
        location.href = "/login";
        setCookie("username", "deslogado", 365);
        setCookie("visibility", "false", 365);
    }
    if (visibility == "false") {
        esconderMain();
    } else if (visibility == "true") {
        mostrarMain();
    }
}

//logar e deslogar do sistema
function logar() {
    setCookie("username", document.getElementById("nome").value, 365);
    setCookie("visibility", "true", 365);
    location.href = "/";
}

function deslogar() {
    deleteCookie("username");
    deleteCookie("visibility");
}