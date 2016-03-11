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