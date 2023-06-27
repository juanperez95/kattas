<?php
include('../Clases/Conexion.php');
try{
    $correo = $con->Validar_email($_REQUEST['email']);
    if($correo['email'] == $_REQUEST['email']){ // Validar si el correo ya esta validado en la base
        header("location:../interfaz2.php?mensaje=¡Este correo ya se encuentra registrado!");
    }else{
        // Datos del registro cliente.
        $usuario =  [intval($_REQUEST['cedula']),3,1,$_REQUEST['contraseña'],$_REQUEST['nombre'],$_REQUEST['apellido'],$_REQUEST['email'],$_REQUEST['fechan'],
        $_REQUEST['genero'],intval($_REQUEST['telefono']),md5($_POST['email'])];
    
        // Datos del registro para la ubicacion.
        $ubicacion = [$_POST['localidad'],$_POST['barrio'],$_POST['direccion']];
        // Ejecutar el registro para  la  base de datos.
        $con->Registro($usuario,$ubicacion);
        header('Location:../login.php');
    }
}catch(PDOException $e){
    echo "-----";
}
?>