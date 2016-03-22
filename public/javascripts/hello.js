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
