<?php require "view/alerta_registro.php";?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/interfaz2.css">
    <link href="https://fonts.googleapis.com/css2?family=Lilita+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Alkatra:wght@600&display=swap" rel="stylesheet">
    <title>Menú</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous"> 
</head>

<body class="bg-custom">
  
  <div class="logo_imagen" style=" display: flex; align-items: center; justify-content: center; margin-top: 8px; ">
    <a class="mr-auto" href="index.php" ><img src="images/Logokatta´s_sin fondo.webp" style="max-height: 100px;" alt="logo"></a>
</div>
  </nav>
  <!-- vista alerta -->
  <?php echo alertaRegistro()?>
    <form class="row g-3 needs-validation bg-custom" style="margin: 40px auto" action="Controladores/C_Registro.php" method="post" onsubmit="return registro();">
        <h1 style="font-size: 30px;">Registro de usuarios</h1>
        <div class="col-md-4">
            <label for="validationCustom01" class="form-label" id="nombre">N° Documento<span class="obligatorio">*</span></label>
            <input type="number" class="form-control rounded-xl" name="cedula" required>
          </div>
        <div class="col-md-4">
          <label for="validationCustom01" class="form-label">Nombres <span class="obligatorio">*</span></label>
          <input type="text" class="form-control" name="nombre" required>
        </div>
        <div class="col-md-4">
            <label for="validationCustom01" class="form-label" id="nombre">Apellidos<span class="obligatorio">*</span></label>
            <input type="text" class="form-control rounded-xl" name="apellido" required>
          </div>
          <div class="col-md-4">
            <label for="validationCustom02" class="form-label">Fecha de nacimiento <span class="obligatorio">*</span></label>
            <input type="date" class="form-control" name="fechan" required>
          </div>
          <div class="col-md-4">
            <label for="validationCustom02" class="form-label">Genero <span class="obligatorio">*</span></label>
            <select class="form-select" name="genero" required>
              <option value="">Escoja un genero</option>
              <option value="Femenino">Femenino</option>
              <option value="Masculino">Masculino</option>
              <option value="Otro">Otro</option>
            </select>
          </div>
        
          <br>
          
          <div class="col-md-4">
            <label for="validationCustomUsername" class="form-label">Barrio <span class="obligatorio">*</span></label>
            <div>
              
              <input type="text" class="form-control all"  aria-describedby="inputGroupPrepend" name="barrio" required>
            </div>
          </div>
          
          
          <div class="col-md-4">
            <label for="validationCustom04" class="form-label">Localidad <span class="obligatorio">*</span></label>
            <select class="form-select" name="localidad" required>
              <option value="">Escoja una localidad</option>
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
            <div class="invalid-feedback">
              Por favor, selecciona un estado valido.
            </div>
          </div>

        <div class="col-md-4">
          <label for="validationCustom03" class="form-label">Dirección <span class="obligatorio">*</span></label>
          <input type="text" class="form-control all" name="direccion" required>
        </div>
        <div class="col-md-4">
            <label for="validationCustom02" class="telefono">Teléfono <span class="obligatorio">*</span></label>
            <input type="number" class="form-control all"  maxlength="10" name="telefono" required>
        </div>
        <div class="col-md-4">
            <label for="validationCustom02" class="telefono" >Correo Electrónico <span class="obligatorio">*</span></label>
            <input type="email" class="form-control all" id="correo" name="email" required>
        </div>
        <div class="col-md-4">
            <label for="validationCustom02" class="telefono">Cree una contraseña <span class="obligatorio">*</span></label>
            <input type="password" class="form-control all" id="contraseña1" placeholder="Mínimo 8 caracteres" minlength="8" name="contraseña" required>
        </div>
        <div class="col-md-4">
          <label for="validationCustom02" class="telefono all" >Confirma tu contraseña <span class="obligatorio">*</span></label>
          <input type="password" class="form-control" id="contraseña2" placeholder="Mínimo 8 caracteres" minlength="8" required>
      </div>
        <div class="col-md-4">
        </div>
        <div class="col-12">
          <input class="btn-custom" type="submit" value="¡Registrarse!"></input>
        </div>
      </form>     
    </div>
  <script src="registro.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>