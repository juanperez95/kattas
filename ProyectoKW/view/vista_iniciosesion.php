<?php
include "Clases/Conexion.php";
function vista_nombre_usuario(){
    global $con; // Uso global de la variable desde la clase conexion.
    if(isset($_COOKIE["P"])){
        $datos = $con->nombres_usuarios($_COOKIE['IS']);
        $nombres = $datos['nombres']." ".$datos['apellidos'];
        $fecha = $con->inicio($_COOKIE['IS']);
        return '<a href="login.php"><button type="button" class="botonx" align="left" style="display:inline-block;">
        <i class="fa-solid fa-user" style="margin-right: 4px;"></i><b style="font-size: 12px;">'.$nombres.'</b></button></a>'; 
    }else{ 
        return '<a href="login.php"><button type="button" class="botonx" align="left" style="display:inline-block;">
        <i class="fa-solid fa-user" style="margin-right: 4px;"></i><b style="font-size: 12px;">Iniciar sesión</b></button></a>
        <a href="registro.php"><button type="button" class="botonx" style="right: 150px;">
        <i class="fa-solid fa-user-plus" style="margin-right: 4px;"></i><b style="font-size: 12px;"> Crear Cuenta </b></button></a>';
    }
}

?>