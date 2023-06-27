<?php
include('../Clases/Conexion.php');
echo '<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>';
// Condicion para validar si existe el usuario.
$lista = $con->Validar($_GET['email'],md5($_GET['pass']));
if($lista[2]){
    // se valida retorno con datos del usuario y su perfil.
    if(intval($lista[0]) == 3 && intval($lista[1]) == 1){
        $_SESSION['user'] = md5($_GET['email']);
        setcookie('IS',$_SESSION['user'],time()+84600,'/');
        setcookie('Error','',time()-1,'/');
        header("Location:../index.php");
    }else if(intval($lista[0]) == 2 && intval($lista[1]) == 1 || intval($lista[0]) == 1 && intval($lista[1]) == 1){
        $_SESSION['user'] = md5($_GET['email']);
        setcookie('IS',$_SESSION['user'],time()+84600,'/');
        $valores = serialize($con->historial($_GET['email']));
        setcookie('H',$valores,time()+84600,"/"); // Llamar sentencia para historial de registro.
        setcookie("P",serialize([$lista[0],$lista[3]]),time()+84600,"/");
        setcookie('Error','',time()-1,'/');
        header("Location:../dashboardUsuarios.php?");
    }else{
        header("location:../login.php?D=¡Cuenta deshabilitada!");
    }
}else{     
    header("Location:../login.php");
    setcookie('Error','1',time()+10,'/');
}
?>
