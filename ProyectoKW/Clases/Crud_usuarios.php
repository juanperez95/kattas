<?php
require "Conexion.php";

// clase crud usuarios.
class Usuario_crud extends Conexion{

    private $conexion;
    // Constructor
    public function __construct(){
        $conexion = parent::conectar();
        $this->conexion = $conexion;
    }
    // Agregar empleado.
    public function agregarEmpleado($array,$ubicaciones){
        try{
            // Insertar datos en las tablas usuario y ubicacion.
            $this->conectar->query("INSERT INTO usuario VALUES('$array[0]',$array[1],$array[2],'$array[3]','$array[4]','$array[5]','$array[6]','$array[7]','$array[8]',$array[9],CURRENT_DATE(),'$array[10]',$array[11])");
            $this->conectar->query("INSERT INTO ubicacion VALUES('$array[0]','$ubicaciones[0]','$ubicaciones[1]','$ubicaciones[2]')");
        }catch(PDOException $error){
            echo "<br>¡!Ha ocurrido un error  ----- ".$error->getMessage();
        }
    }
    // Ver empleados y clientes desde administrador.
    public function viewAdmin($inicio){
        $resultado = $this->conectar->query("SELECT * FROM usuario WHERE fk_perfil NOT IN(1) LIMIT $inicio,7"); // Que no se vea el cargo del administrador
        return $resultado;   
    }
    // Cambiar estado de usuario.
    public function Update_estado($estado,$documento){
        $this->conectar->query("update usuario set fk_habilitado = $estado where identificacion = $documento;"); // Que no se vea el cargo del administrador 
    }
    // Ver parte de el perfil en zona de empleados.
    public function viewCard($email_c){
        $resultado = $this->conectar->query("SELECT * FROM usuario WHERE email_c = '$email_c'"); 
        return $resultado;   
    }
    // Metodo para actualizar los datos desde la vista de administrador.
    public function Update_datosAdmin($email_c, $nombre, $apellido, $fecha, $genero, $telefono){
        $this->conectar->query("UPDATE usuario SET nombres = '$nombre',apellidos = '$apellido'
        ,fechaNacimiento = '$fecha',genero = '$genero',telefono = '$telefono' WHERE email = '$email_c'"); 
    }
    // Contar usuarios
    public function numUsuarios(){
        $resultado = $this->conectar->query("SELECT COUNT(*)-1 FROM usuario"); // No se cuenta al administrador.
        return $resultado = $resultado->fetch();
    }
    // Consultar busqueda multicriterio.
    public function buscar($documento, $fecha_i, $fecha_f, $estado){
        $resultado = $this->conectar->query("SELECT * from usuario where fechaRegistro in('$fecha_i','$fecha_f') and fk_habilitado = $estado and identificacion like '%$documento%'");
        return $resultado;
    }
}   
$u = new Usuario_crud();
?>