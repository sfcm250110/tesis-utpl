function mostrarConfirmacion(mensaje) {
	return confirm(mensaje);
}

function mayusculas(obj) {
	obj.value = obj.value.toUpperCase();
}

function abrirURL(url, target, width, height) {
	var left = (screen.width / 2)-(width / 2);
	var top = (screen.height / 2)-(height / 2);
	var opciones = "width=" + width + ",height=" + height + ", top=" + top + ", left=" + left;
	window.open(url, target, opciones);
}

function soloNumeros(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	
	if(charCode < 48 || charCode > 57) {
		return false;
	}
	
    return true;
}

function soloLetras(evt) {
    evt = (evt) ? evt : event;
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode : ((evt.which) ? evt.which : 0));
    
    if ((charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122) || charCode == 32) {
       return true;
    }
    
    return false;
}

function validarInicial(obj, txt) {
	var text = obj.value; 
	if(text.length < txt.length) {
		return;
	}
	if(text.substring(0, txt.length) == txt) {
		return;
	} else {
		obj.value = txt + obj.value;
		return;
	}
}