<?php
include "../Clases/Crud_usuarios.php";
include "./Clases/Crud_usuarios.php";
include "./Clases/Conexion.php";
try{
    $correo = $con->Validar_email($_GET['email']);
    if($correo['email'] == $_GET['email']){
        header('Location:../dashboardUsuarios.php?mensaje=¡Este correo ya se encuentra registrado!');
    }else{
        // Datos del registro cliente.
        $usuario =  [intval($_GET['documento']),2,1,md5($_GET['contraseña1']),$_GET['nombre'],$_GET['apellido'],$_GET['email'],$_GET['nacimiento'],
        $_GET['genero'],intval($_GET['telefono']),md5($_GET['email']),intval($_GET['cargo'])];
    
        // Datos del registro para la ubicacion.
        $ubicacion = [$_GET['localidad'],$_GET['barrio'],$_GET['direccion']];
        // Ejecutar el registro para  la  base de datos.
        $u->agregarEmpleado($usuario,$ubicacion);
        header('Location:../dashboardUsuarios.php');
    }
}catch(PDOException $e){
    echo "-----";
}

?>