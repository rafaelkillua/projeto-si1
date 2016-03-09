if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

function ativarQtde() {
  document.getElementById("qtde").removeAttribute("disabled");
}

function desativarQtde() {
  document.getElementById("qtde").setAttribute("disabled", "disabled");
}