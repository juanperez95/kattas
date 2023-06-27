<?php require "view/tabla_usuarios.php";error_reporting(-E_ALL & ~E_WARNING); require "view/alerta_registro.php";?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/nav.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <script async src="https://basicons.xyz/embed.js"> </script>
    <script src="https://kit.fontawesome.com/b06d3acf28.js" crossorigin="anonymous"></script>  
    <link rel="stylesheet" href="boton.css">
    <title>Dashboard</title>
</head>

<body>
    <header>
        <nav class="navbar">
            <div class="container-fluid">
                <a class="logo" href="index.php"><img src="images/Logokatta´s_sin fondo.png" class="img" width="300px"></a>
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search" required>
                </form>
                <!-- Vista perfil -->
                <?php echo vistaEmpleado($_COOKIE['IS'])?>
        </nav>

                
    </header>
    <aside>
        <section class="opciones">
            <div class="card" style="width: 20rem">
                <section>
                    <ul class="iconomenu" style="margin: 15px;">
                        <li style="margin-top: 18px;">
                            <a href="#">
                                <i class="fa-solid fa-house"></i>
                                <span class="nav-item"> Inicio</span>
                            </a>
                        </li>
                        <li style="margin-top: 18px;">
                            <a href="">
                                <i class="fa-solid fa-user"></i>
                                <span class="nav-item"> Perfil</span>
                            </a>
                        </li>
                        <!-- Modulos -->
                        <?php  echo Modulos_Admin()?>
                        <li style="margin-top: 18px;">
                            <a href="dashboard_venta.php">
                                <i class="fa-sharp fa-solid fa-cart-shopping"></i>
                                <span class="nav-item"> Ventas</span>
                            </a>
                        </li>
                        <li style="margin-top: 18px;">
                            <a href="dashboard_domicilio.php">
                                <i class="fa-solid fa-truck"></i>
                                <span class="nav-item"> Domicilios</span>
                            </a>
                        </li>
                            <a href="dashboard_pqrs.php">
                                <i class="fa-sharp fa-solid fa-clipboard-check"></i>
                                <span class="nav-item"> PQRS</span>
                            </a>
                        </li>
                        <li style="margin-top: 18px;">
                            <a href="Controladores/Cerrar_sesion.php" class="logout">
                                <i class='icon bx bx-log-out'></i>
                                <span class="nav-item"> Cerrar Sesión</span>
                            </a>
                        </li>
                    </ul>
            </div>
        </section>
    </aside>
    <main>
        <div class="main">
        <div class="titulo" style=" display: flex; justify-content: space-between; padding-top: 20px; padding-right: 30px; align-items: center;">
            <h2>Usuarios</h2>
        </div>
        <div class="titulo_arriba">
        <div class="titulo_usuarios">
            <!-- <h1>Usuarios</h1> -->
        
        <!-- Modal empleado -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <h1 id="exampleModalLabel">Crear Empleado</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body" >
            <form class="formularioEmpleado" action="Controladores/C_Registro_emp.php" method="GET">
            <div class="form-row">
                
                <div class="etiqueta">
                <label for="nombre">Nombre(s)</label> 
                <input type="text" id="nombre" class="nombre" name="nombre" required>
                </div>
                <div class="etiqueta">
                <label for="apellido">Apellido(s)</label>
                <input type="text" id="apellido" class="apellido" name="apellido" required>
                </div>
                <div class="etiqueta">
                <label for="documento">Documento</label>
                <input type="number" id="contraseña" class="contraseña" name="documento" required>
                </div>
                <div class="etiqueta">
                <label for="correo">Correo electrónico</label>
                <input type="email" id="email" class="email" name="email" required>
                </div>
                <div class="etiqueta">
                <label for="telefono">Teléfono</label>
                <input type="number" maxlength="10" id="telefono" class="telefono" name="telefono" required>
                </div>
                <div class="etiqueta">
                <label for="nacimiento">Fecha de nacimiento</label>
                <input type="date" id="nacimiento" class="nacimiento" name="nacimiento" required>
                </div>
                <div class="etiqueta">
                <label for="genero" class="form-label">Género</label>
                <select class="form-select" name="genero" required>
                <option value="">Escoje un género</option>
                <option value="Femenino">Femenino</option>
                <option value="Masculino">Masculino</option>
                <option value="Otro">Otro</option>
                </select>
                </div>
                <div class="etiqueta">
                <label for="localidad" class="form-label">Localidad</label>
                <select class="form-select" name="localidad" required>
                <option value="">Escoje una localidad</option>
                <option value="Usaquen">01. Usaquén</option>
                <option value="Chapinero">02. Chapinero</option>
                <option value="Santa Fe">03. Santa Fe</option>
                <option value="San Cristobal">04. San Cristobal</option>
                <option value="Usme">05. Usme</option>
                <option value="Tunjuelito">06. Tunjuelito</option>
                <option value="Bosa">07. Bosa</option>
                <option value="Kennedy">08. Kennedy</option>
                <option value="Fontibón">09. Fontibón</option>
                <option value="Engativá">10. Engativá</option>
                <option value="Suba">11. Suba</option>
                <option value="Barrios Unidos">12. Barrios Unidos</option>
                <option value="Teusaquillo">13. Teusaquillo</option>
                <option value="Los Mártires">14. Los Mártires</option>
                <option value="Antonio Nariño">15. Antonio Nariño</option>
                <option value="Puente Aranda">16. Puente Aranda</option>
                <option value="Candelaria">17. Candelaria</option>
                <option value="Rafael Uribe Uribe">18. Rafael Uribe Uribe</option>
                <option value="Ciudad Bolivar">19. Ciudad Bolivar</option>
                <option value="Sumapaz">20. Sumapaz</option>
                </select>
                </div>
                <div class="etiqueta">
                <label for="barrio" class="form-label">Barrio</label>
                <input type="text"  aria-describedby="inputGroupPrepend" name="barrio" required>
                </div>

                <div class="etiqueta">
                <label for="direccion" class="form-label">Dirección</label>
                <input type="text" name="direccion" required>
                </div>
                <div class="etiqueta">
                <label for="cargo" class="form-label">Cargo</label>
                <select class="form-select" name="cargo" required>
                <option value="">Selecciona cargo:</option>
                <option value="1">01. Mesero</option>
                <option value="2">02. Cajero</option>
                <option value="3">03. Domiciliario</option>
                </select>
                </div>
                <div class="etiqueta">
                <label for="contraseña">Crea una contraseña</label>
                <input type="password" id="contraseña1" name="contraseña1" placeholder="Mínimo 8 caracteres" minlength="8" required>
                </div>
                <div class="etiqueta">
                <label for="contraseña">Confirma tu contraseña</label>
                <input type="password" id="contraseña2" name="contraseña2" placeholder="Mínimo 8 caracteres" minlength="8" required>
                </div><br>

                <button class="buton" type="submit" style="font-size: 15px">Crear empleado</button><br><br><br>
        
            </form>
        </div>
        </div>
    </div>
    </div>
</div>

        <?php echo Boton_empleado()?>
        <!-- </div>
            <button type="button" class="crear" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"><i class="fa-solid fa-user-plus" 
            style="padding-right: 10px; padding-top: 5px;"></i> Crear Empleado</button>
            
        <div> -->
        <form action="dashboardUsuarios.php" method="POST">
            <input type="number" id="search-input" name="id" placeholder="Digite un documento">
            <input type="date" id="search-input" name="fecha_inicio">
            <input type="date" id="search-input" name="fecha_fin">
            <select name="estado" id="">
                <option value="1">Habilitado</option>
                <option value="2">Deshabilitado</option>
            </select>
            <input type="submit" value="Filtrar" name="buscar">
        </form>
        </div>
        </div>

        <div class="tabla">
            <table class="table" style="text-align: center;">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Foto</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Correo Electrónico</th>
                        <th scope="col">Cargo</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody class="table-group-divider">
                    <!-- vista tabla usuarios -->
                    <?php 
                    $inicio = (intval($_GET['pagina'])-1)*7;if($inicio < 0){$inicio= 0; $etiqueta = "dashboardUsuarios.php?pagina=".$_GET['pagina']-1;}
                    foreach(vistaAdmin($inicio) as $d){echo $d;}?>
                </tbody>
            </table>
        </div>
        <div class="pagination">
            <!-- Numeros de paginacion -->
           
            <!-- Paginacion -->
                <?php foreach(Paginacion() as $datos){echo $datos;}?>
          </div>
          <!-- Imprimir alerta de correo existente -->
          <?php echo alertaRegistro()?>
          </div>
    </main>

    
</body>

</html>