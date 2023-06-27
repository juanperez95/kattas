<?php
include "../Clases/Crud_usuarios.php";
// include "./Clases/Crud_usuarios.php";
$validar = intval($_REQUEST['estado']);

if($validar == 2){
    $u->Update_estado(2,$_REQUEST['documento']);
}else{
    $u->Update_estado(1,$_REQUEST['documento']);
}
header("location:../dashboardUsuarios.php?");


?>  