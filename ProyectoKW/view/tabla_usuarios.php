<?php
include "./Clases/Crud_usuarios.php";
function vistaAdmin($inicio){
    global $u;
    $lista = unserialize($_COOKIE['P']);
    $et = []; // Guardar etiquetas para imprimir.
    if(isset($_POST['buscar'])){
      $datos = $u->buscar($_POST['id'],$_POST['fecha_inicio'],$_POST['fecha_fin'],$_POST['estado']);
    }else{
      $datos = $u->viewAdmin($inicio);
    }


    while($fila = $datos->fetch()){
        if(intval($fila['fk_habilitado']) == 1){
            $etiqueta = '<td><button disabled class="habilitado"> <b>Habilitado</b></button></td>';
        }else{ // Validar si esta deshabilitado o habilitado.
            $etiqueta = '<td><button disabled class="deshabilitado"> <b>Deshabilitado</b></button></td>';
        }
        // -------------------------------------------------
        if(intval($fila["fk_perfil"]) == 2){
            $cargo = 'Empleado';
        }else{ // Identificar cargo del usuario.
            $cargo = 'Cliente';
        }
        // ----------------------------------------------------
        if(intval($fila['fk_habilitado']) == 1){
            $icono_boton = '<i class="fa-solid fa-toggle-on" style="color: var(--color-iconos);"></i></button>'; // Icono para validar estado.
            $habilitado = '<div class="modal-header">
            <h1 class="modal-title" id="empleadoModalLabel">Deshabilitar usuario</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
            ¿Esta seguro de realizar la operacion con el usuario/a "'.strtoupper($fila['nombres'])." ".strtoupper($fila['apellidos']).'"?
            </div>
            <form>
            <input style="text-align:center" type="text" value="'.$fila['identificacion'].'" disabled>
            <div class="modal-footer">
                <a href="../Controladores/dh_controller.php?estado=2&documento='.$fila['identificacion'].'"<button class="btn btn-danger">Deshabilitar</button></a>
            </div></form>';
        }else{ // Validar si el usuario esta activo o inactivo en el sistema
            $icono_boton = '<i class="fa-solid fa-toggle-off" style="color: var(--color-iconos);"></i></button>';
            $habilitado = '<div class="modal-header">
            <h1 class="modal-title" id="empleadoModalLabel">Habilitar usuario</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
            ¿Esta seguro de realizar la operacion con el usuario/a "'.strtoupper($fila['nombres'])." ".strtoupper($fila['apellidos']).'"?
            </div>
            <form>
            <input style="text-align:center" type="text" value="'.$fila['identificacion'].'" disabled>
            <div class="modal-footer">
            <a href="../Controladores/dh_controller.php?estado=1&documento='.$fila['identificacion'].'"<button class="btn btn-success">Habilitar</button></a>
            </div></form>';
          }
          // ----------------------------------------------------
          if(intval($lista[0]) == 1){ 
            // Controlar los botones que puede ver el usuario.
            $botones = '<button class="icono-button" type="button" data-bs-toggle="modal" data-bs-target="#'.$fila['email'].'">
            <i class="fa-solid fa-pen-to-square fa-lg" style="color: var(--color-iconos);"></i></button>
  
            <button class="icono-button" type="button" data-bs-toggle="modal" data-bs-target="#'.$fila['email_c'].'">
            '.$icono_boton.' 
            </button>';
          }else{
            $botones = '';
          }

        $et[] =  '<!--Modal1-->
        <div class="modal fade" id="'.$fila['identificacion'].'" tabindex="-1" aria-labelledby="empleadoModalLabel" aria-hidden="true" >
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title" id="empleadoModalLabel">Detalles del usuario</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  Fecha Nacimiento:<input type="text" value="'.$fila['fechaNacimiento'].'" disabled><br>
                  Genero:<input type="text" value="'.$fila['genero'].'" disabled><br>
                  Telefono: <input type="text" value="'.$fila['telefono'].'" disabled><br>
                  Fecha Registro en el sistema: <input type="text" value="'.$fila['fechaRegistro'].'" disabled><br>	
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn" data-bs-dismiss="modal">Cerrar</button>
                </div>
              </div>
            </div>
          </div>

          <!--Modal2-->
          <div class="modal fade" id="'.$fila['email'].'" tabindex="-1" aria-labelledby="empleadoModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title" id="empleadoModalLabel">Editar usuario</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="Controladores/update_usuario_controller.php" method="GET">
                    Nombre(s):<input type="text" value="'.$fila['nombres'].'" name="nombre" required><br>
                    Apellido(s):<input type="text" value="'.$fila['apellidos'].'" name="apellido" required><br>
                    Fecha Nacimiento:<input type="text" value="'.$fila['fechaNacimiento'].'" name="fechan" required><br>
                    Genero:<input type="text" value="'.$fila['genero'].'" name="genero" required><br>
                    Telefono: <input type="text" value="'.$fila['telefono'].'" name="tel" required><br>
                    Correo Electronico: <input type="text" value="'.$fila['email'].'" name="email_c" readonly><br>
                    <button type="submit" class="btn btn-sucess">Guardar Cambios</button>
                    </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn" data-bs-dismiss="modal">Cerrar</button>
                </div>
              </div>
            </div>
          </div>
          

          <!--Modal3-->

          <div class="modal fade" id="'.$fila['email_c'].'" tabindex="-1" aria-labelledby="empleadoModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">'.$habilitado.'


        <tr>
            <th scope="row">'.$fila['identificacion'].'</th>
            <td>
                <img src="images/usuario.jpg" alt="usuario" class="imagenUsuario">
            </td>
            <td>'.$fila['nombres'].'</td>
            <td>'.$fila['apellidos'].'</td>
            <td>'.$fila['email'].'</td>
            <td>'.$cargo.'</td>
            '.$etiqueta.'
            <td>
                <button><button class="icono-button" type="button" data-bs-toggle="modal" data-bs-target="#'.$fila['identificacion'].'">
                    <i class="fa-regular fa-address-book fa-lg" style="color: var(--color-iconos);"></i></button>

                    '.$botones.'
            </td>';
    }
    return $et;
}
function vistaEmpleado($email){
    global $u;
    $datos = $u->viewCard($email);
    while($dato = $datos->fetch()){
        if(intval($dato['fk_idCargo']) == 1){
            $cargo = 'Mesero';
        }else if(intval($dato['fk_idCargo']) == 2){
            $cargo = 'Cajero';
        }else if(intval($dato['fk_idCargo']) == 3){
            $cargo = 'Domiciliario';
        }else{
            $cargo = 'Administrador';
        }
        return '<div class="dropdown">
        <img src="images/usuario.jpg" alt="Foto de perfil" class="profile-image">
        <button class="btn dropdown-toggle" style="background-color: none ;color: #E4E4E4;border: none; font-size: 15px; font-family: Roboto, sans-serif; "  type="button" data-bs-toggle="dropdown" aria-expanded="false">
          '.strtoupper($dato['nombres']).' <br>
          Cargo: '.$cargo.'
        </button>
        <ul class="dropdown-menu">
          <li><a class="dropdown-item" href="#">Perfil</a></li>
          <li><a class="dropdown-item" href="#">Configuración de la cuenta</a></li>
          <li><a class="dropdown-item" href="../Controladores/Cerrar_sesion.php">Cerrar sesión</a></li>
        </ul>
        </div>';
    }
}
function Paginacion(){
  global $u;
  $et = [];
  $usuariox_pagina = 7; // Numero de usuarios por pagina
  $numero_usuarios = $u->numUsuarios();
  $paginas = ceil(intval($numero_usuarios["0"]) / $usuariox_pagina);
  for($i = 0+1;$i < $paginas;$i++){
    $et[] = '<a href="?pagina='.$i+(1).'" class="page">'.$i.'</a>';
  }
  return $et; // Retornar las etiquetas generadas para imprimir en la vista.
}
// Funcion que restringe la funcion de crear empleados.
function Boton_empleado(){
  $lista = unserialize($_COOKIE["P"]);
  if(intval($lista[0]) == 1){
    return '</div>
    <button type="button" class="crear" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"><i class="fa-solid fa-user-plus" 
    style="padding-right: 10px; padding-top: 5px;"></i> Crear Empleado</button>    
    <div>';
  }else{
    return '';
  }
}
// Restringir modulos.
function Modulos_Admin(){
  $lista = unserialize($_COOKIE["P"]);
  if(intval($lista[0]) == 1){
    return '<li style="margin-top: 18px;">
    <a href="">
            <i class="fa-solid fa-users"></i>
            <span class="nav-item"> Usuarios</span>
        </a>
    </li>
    <li style="margin-top: 18px;">
        <a href="">
            <i class="fa-solid fa-list-check"></i>
            <span class="nav-item"> Inventario</span>
        </a>
    </li>
    <li style="margin-top: 18px;">';
  }else{
    return '';
  }
}
?>
