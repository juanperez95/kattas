<?php
// Clase para conectar.
class Conexion{

    public $conectar;

    public function conectar(){
        try{
            $this->conectar = new PDO("mysql:host=localhost;dbname=kattasweb","root","");
            return $this->conectar;
        }catch(PDOException $error){
            echo "<br>¡Problema en la conexion!";
        }
    }

    // Metodo para registro de cliente.
    public function Registro($array, $ubicaciones){
        try{
            // Insertar datos en las tablas usuario y ubicacion.
            $this->conectar->query("INSERT INTO usuario VALUES($array[0],$array[1],$array[2],md5('$array[3]'),'$array[4]','$array[5]','$array[6]','$array[7]','$array[8]',$array[9],CURRENT_DATE(),'$array[10]',NULL)");
            $this->conectar->query("INSERT INTO ubicacion VALUES($array[0],'$ubicaciones[0]','$ubicaciones[1]','$ubicaciones[2]')");
        }catch(PDOException $error){
            echo "<br>¡!Ha ocurrido un error  ----- ".$error->getMessage();
        }
    }
    // Metodo para validar el inicio de sesion.
    public function Validar($email, $contraseña){
        $resultado = $this->conectar->query("SELECT email, contrasena, fk_perfil, fk_habilitado, nombres, apellidos  FROM usuario WHERE email = '$email'");
        $resultado = $resultado->fetch();
        // Retornar lista con datos de perfil y si esta habilitado.
        if($email == $resultado['email'] && $contraseña == $resultado['contrasena']){
            return [$resultado['fk_perfil'],$resultado['fk_habilitado'],true,$resultado['fk_idCargo'],$resultado['nombres'],$resultado['apellidos']];
        }else{
            return [0,0,false];
        }
    }
    // Funcion para validar si el correo a registrar esta en la base de datos.
    public function Validar_email($email){
        $resultado = $this->conectar->query("SELECT email FROM usuario WHERE email = '$email'");
        $resultado = $resultado->fetch();
        return $resultado;
    }
    // Historial para almacenar las sesiones.
    public function historial($email_c){
        $this->conectar->query("UPDATE usuario set fk_habilitado = 2 where email_c = '$email_c'");
        $this->conectar->query("UPDATE usuario set fk_habilitado = 1 where email_c = '$email_c'");
    }
    // Metodo para saber nombre usuario
    public function nombres_usuarios($email_c){
        $resultado = $this->conectar->query("SELECT nombres, apellidos FROM usuario WHERE email_c = '$email_c'");
        return $resultado = $resultado->fetch();
    }
    // Metodo para saber el ultimo inicio de sesion
    public function inicio($email_c){
        $resultado = $this->conectar->query("SELECT * from inicio where usuario_numero = '$email_c' ORDER by fecha desc limit 1,1;");
        $resultado = $resultado->fetch();
        return $resultado['fecha'];
    }
}
$con = new Conexion();
$con->conectar();
?>
