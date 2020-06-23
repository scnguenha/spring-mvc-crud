function habilita(radio) {
    if (radio == 0) {
        document.getElementById("dataValidade").disabled = true;
        document.getElementById("dataValidade").value = '';
    } else {
        document.getElementById("dataValidade").disabled = false;
    }
}

$("body").tooltip({ selector: '[data-toggle=tooltip]' });