<?php
function alertaRegistro(){
    if(isset($_GET['mensaje'])){
        return '<div class="alert alert-danger" role="alert" >
        '.$_GET['mensaje'].'
        </div>';
    }else{
        return "";
    }
}



?>