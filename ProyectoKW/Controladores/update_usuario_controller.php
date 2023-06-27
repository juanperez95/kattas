<?php
include "../Clases/Crud_usuarios.php";

$u->Update_datosAdmin($_GET['email_c'],$_GET['nombre'],$_GET['apellido'],$_GET['fechan'],
$_GET['genero'],$_GET['tel']);
header("location:../dashboardUsuarios.php?");
?>