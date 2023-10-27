// Funcion qye valida los campos de las contraseñas, retorna el valor para redirigir!
function registro(){
    if(document.getElementById("contraseña1").value == "" && document.getElementById("contraseña2").value == ""){
        return false;
    }
    else if(document.getElementById("contraseña1").value != document.getElementById("contraseña2").value){
        mensajes(1);
        return false;
    }
    else{
        mensajes(2);
        return true;
    }
}
// Funcion para lanzar los mensajes adecuados segun la condicion cumplida.
function mensajes(valor){
    if(valor == 1){
        Swal.fire('¡Oops!',"No coinciden las contraseñas",'error');
    }
    else if(valor == 2){
        Swal.fire('¡Registro Exitoso!',"Espere...",'success');
    }
}
