<?php
session_destroy();
setcookie('IS',"",time()-1,'/'); // Destrozar cookies y sesiones.
setcookie('P',"","/");
header("location:../login.php");
?>