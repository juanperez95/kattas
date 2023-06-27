<?php error_reporting(-E_ALL & ~E_WARNING)?>
<!DOCTYPE html>
<html lang="en">
<?php include "view/vista_iniciosesion.php";?>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Se enlaza archivo css encargado de los colores y animaciones -->
    <link rel="stylesheet" href="css/index.css">
    <link href="https://fonts.googleapis.com/css2?family=Lilita+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Alkatra:wght@600&display=swap" rel="stylesheet">
    <title>Katta´s pizza</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <script src="index.js"></script>
    
    


    <!-- Importar css <link rel="stylesheet" href="css/bootstrap.min.css-->
</head>

<body>

  <!--color de fondo de toda la página-->
  <style> 
    body {
      background-color: var(--color-fondo); 
    }
  </style>
  <div class="loading">  
    <div class="loading-overlay">
        <img src="images/pizza_loading.gif" alt="loading">
    </div>
  </div>

    <div class="content">
      <div class=""></div>
          <nav class="navbar fixed-top" style="background-color: var(--color-fondo); height: 12%;">
              <div class="navega flex-colum flex-md-row">
                <a class="navbar-brand mr-auto" style="top: 0;" href="#">
                  <img src="images/Logokatta´s_sin fondo.webp" style="top: 0; max-height: 110px;" alt="logo" ></a>
                <!-- Validar si inicio sesion el usuario -->
                <?php echo vista_nombre_usuario();?>
                
                <button class ="menu_desplegable navbar-toggler mx-auto" style="color: var(--color-fondo2); font-size: 150%;" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" style="background-color: var(--color-fondo2);border-radius: 100px; ">
                  <span><i class="fa-solid fa-bars fa-lg"></i></span>
                </button>
              </div>
                <div class="offcanvas offcanvas-start text-bg-dark justify-content-start w-20" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
                  <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Menú</h5>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                  </div>
                  <div class="offcanvas-body">
                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                      <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#" style="color: var(--color-texto)">Página principal</a><br>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#" style="color: var(--color-texto)">Carta</a><br>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="#" style="color: var(--color-texto)">Domicilios: Pide en línea</a><br>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#" style="color: var(--color-texto)">Nuestro trabajo</a><br>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#" style="color: var(--color-texto)">¿Quiénes somos?</a><br>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="contacto.php" style="color: var(--color-texto)">Contáctanos: Comunícate aquí</a>
                        </li>
                      <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: var(--color-texto) ">
                          Ver más
                        </a>
                        <ul class="dropdown-menu dropdown-menu" style="background-color: var(--color-fondo)">
                          <li><a class="dropdown-item" href="#"></a></li>
                          <li><a class="dropdown-item" href="#" style="color: var(--color-texto);font-family: 'Quicksand', sans-serif; font-size: 100%;">Información legal</a></li>
                          <li>
                          <li><a class="dropdown-item" href="#"></a></li>
                          <li><a class="dropdown-item" href="#" style="color: var(--color-texto);font-family: 'Quicksand', sans-serif; font-size: 100%;">Política de privacidad</a></li>
                          <li>
                              <li><a class="dropdown-item" href="#"></a></li>
                          <li><a class="dropdown-item" href="#" style="color: var(--color-texto);font-family: 'Quicksand', sans-serif; font-size: 100%;">Términos y condiciones</a></li>
                          <li>
                          <hr class="dropdown-divider">
                          </li>
                          <li><a class="dropdown-item" href="#"></a></li>
                        </ul>
                      </li>
                    </ul>
                    <form class="d-flex mt-3" role="search">
                      <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search" >
                      <button class="btn" type="submit" style= "background-color: #C0252A; color: var(--color-texto)">Buscar</button>
                    </form>
                  </div>
                </div>
            </nav>
          
            <br><br><br><br>

            <div id="carouselExampleCaptions" class="carousel carousel-fade slide" data-bs-ride= "carousel"> 
              <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
              </div>

              <div class="carousel-inner">
                <div class="carousel-item active">
                  <video class="d-block w-100 fondo_video" style="object-fit: cover; object-position: center; opacity: 0.5" alt="fondo_video" autoplay loop>
                    <source src="images/Pizza_video.mp4" type="video/mp4">
                  </video>
                  <div class="carousel-caption d-none d-md-block">
                    <h1 style="font-size: 650%; font-family: 'Source Sans Pro', sans-serif;">Bienvenidos a Katta´s Pizza</h1>
                    <button type="button" class="boton1" data-toggle="collapse" data-target="#texto-oculto" 
                    aria-controls="texto-oculto" style="color: var(--color-texto)" class="btn-lg">
                    Ver más
                    </button>
                    <p style="font-family: 'Quicksand', sans-serif;">¡Creamos arte con pizzas artesanales!</p>
                  </div>
                </div>
            
                <div class="carousel-item">
                  <img src="images/fondopizza4.jpg" class="d-block img-fluid imagen3 " alt="imagen3">
                  <div class="carousel-caption d-none d-md-block">
                      <h1 style="font-size: 650%; font-family: 'Source Sans Pro', sans-serif;">Nuestra esencia</h1>
                      <button type="button" class="boton1" data-toggle="collapse" data-target="#texto-oculto" 
                      aria-controls="texto-oculto" style="color: var(--color-texto)" class="btn-lg">
                      Ver más
                    </button>
                    <p  style="font-family: 'Quicksand', sans-serif;" >Presentes en el mercado hace más de 5 años</p>
                  </div>
                </div>
                <div class="carousel-item">
                  <video class="d-block w-100 horno_video" style="object-fit: cover; object-position: center; opacity: 0.5" alt="horno_video" autoplay loop>
                    <source src="images/horno_pizza.mp4" type="video/mp4">
                  </video>
                  <div class="carousel-caption d-none d-md-block">
                    <h1 style="font-size: 650%; font-family: 'Source Sans Pro', sans-serif;">Domicilios: Pide en línea</h1>
                    <button type="button" class="boton1" data-toggle="collapse" data-target="#texto-oculto" 
                    aria-controls="texto-oculto" style="color: var(--color-texto)" class="btn-lg">
                    Ver más
                    </button>
                    <div id="texto-oculto" class="collapse">
                    <p style="color: var(--color-texto2)" ></p>
                    </div>
                    <p style="font-family: 'Quicksand', sans-serif;">Conoce nuestra gran variedad de pizzas
                    </p>
                  </div>
                
                </div>
              
                <div class="carousel-item">
                  <img src="images/fondopizza2.webp" class="d-block img-fluid imagen2 w-100" alt="imagen2">
                  <div class="carousel-caption d-none d-md-block">
                    <h1 style="font-size: 650%; font-family: 'Source Sans Pro', sans-serif;">Nuestra carta</h1>
                    <button type="button" class="boton1" data-toggle="collapse" data-target="#texto-oculto" 
                    aria-controls="texto-oculto" style="color: var(--color-texto)" class="btn-lg">
                    Ver más
                    </button>
                    <p style="font-family: 'Quicksand', sans-serif;">innovación en el arte de la cocina</p>
                  </div>
                </div>

              </div>

              <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div><br><br>

            <div class="container-fluid" style="background-color: var(--color-fondo);border-style: none">
              <div class="row" >
                <div class="col-md-4" >
                  <h2 class="text-center" style="color: var(--color-texto); font-family: 'Source Sans Pro', sans-serif;"> Un mundo de sabores en cada bocado</h2>
                  <p class="text-center" style="color: var(--color-texto); font-family: 'Quicksand', sans-serif;">Nuestra especialidad, la pizza, es realizada mediante diversos procesos puramente artesanales. Adéntrate en el mundo de la pizza, sea tradicional o artesanal.</p>
                </div>
                <div class="col-md-4"  >
                  <h2 style="color: var(--color-texto); font-family: 'Source Sans Pro', sans-serif;">Haz de la pizza tu nuevo amor </h2>
                  <p class="text-center" style="color: var(--color-texto); font-family: 'Quicksand', sans-serif;">Somos un universo de sabores, un mundo exclusivo de pizzas.</p>
                </div>
                <div class="col-md-4" >
                  <h2 style="color: var(--color-texto); font-family: 'Source Sans Pro', sans-serif;">Conoce nuestros servicios</h2>
                  <p class="text-center" style="color: var(--color-texto); font-family: 'Quicksand', sans-serif;">Nuestra pizza es amor a primera rebanada</p>
                </div>
              </div>
            </div>

            
          <div class="container-fluid" style="background-color: var(--color-fondo);">
            <div class="row" style="max-width: 100%;">
              <div class="col-md-4" >
                <div class="card mb-4 shadow-sm" style="background-color: var(--color-fondo);" > 
                  <img src="images/pizza2.webp" alt="Imagen 2" class="card-img-top" style="max-width: 100%; height: auto;"><br><br>
                  <div class="card-body" style="max-width: 100%; background-color: var(--color-fondo);">
                    <div class="d-flex justify-content-between align-items-center">
                      <div id="texto-oculto" class="collapse">
                        <p></p>
                      </div>
                      <div class="btn-group mx-auto">
                        <a href="error500.php"><button type="button" class="boton2" data-toggle="collapse" data-target="texto-oculto" 
                      aria-controls="texto-oculto" style="color: var(--color-texto)" class="btn-lg">
                      Antójate de nuestros productos</button></a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="col-md-4">
                <div class="card mb-4 shadow-sm" style="background-color: var(--color-fondo);" >
                  <img src="images/pizza3.webp" alt="Imagen 2" class="card-img-top" style="max-width: 100%; height: auto;"><br><br>
                  <div class="card-body" style="max-width: 100%; background-color: var(--color-fondo);">
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group mx-auto">
                        <button type="button" class="boton2" data-toggle="collapse" data-target="texto-oculto" 
                      aria-controls="texto-oculto" style="color: var(--color-texto)" class="btn-lg">
                      Haz tu pedido</button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
                <div class="card mb-4 shadow-sm" style="background-color: var(--color-fondo);" >
                  <img src="images/pizza4.webp" alt="Imagen 3" class="card-img-top" style="max-width: 100%; height: auto;"><br><br>
                  <div class="card-body" style="max-width: 100%; background-color: var(--color-fondo);">
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group mx-auto">
                      <a href="error404.php"> <button type="button" class="boton2" data-toggle="collapse" data-target="texto-oculto" 
                        aria-controls="texto-oculto" style="color: var(--color-texto)" class="btn-lg">
                        Comunícate con nosotros</button></a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        
            <h1 style="margin-top:50px; margin-bottom:20px; font-size: 300%; color: var(--color-texto); text-align: center; font-family: 'Source Sans Pro', sans-serif;">Preguntas Frecuentes</h1>
            <div class="container text-center " >
              <div class="row align-items-start">
                <div class="col accordion accordion-vertical" id="accordionPizza" >
                  <div class="accordion-item " style="border: 0; border-radius: 10px; background-color: rgb(22, 22, 22);">
                    <h2 style="color: var(--color-texto); background-color: rgb(22, 22, 22); border-radius: 10px;" class="accordion-header" id="headingOne">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed" 
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseOne"
                        aria-expanded="false"
                        aria-controls="collapseOne"
                        
                      >
                      ¿Cuáles son los métodos de pago que aceptan?
                      </button>
                    </h2>
                    <div
                      id="collapseOne"
                      class="col accordion-collapse collapse" 
                      aria-labelledby="headingOne"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body" > 
                        Aceptamos pagos en efectivo, tarjeta de crédito y débito, y pagos en linea.
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item" style="border: 0;background-color: rgb(22, 22, 22); border-radius: 10px;">
                    <h2 class="accordion-header" id="headingTwo" style="background-color: rgb(22, 22, 22); border-radius: 10px;">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseTwo"
                        aria-expanded="false"
                        aria-controls="collapseTwo"
                      >
                      ¿Ofrecen entrega a domicilio?
                      </button>
                    </h2>
                    <div
                      id="collapseTwo"
                      class="col accordion-collapse collapse"
                      aria-labelledby="headingTwo"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body">
                        Sí, ofrecemos entrega a domicilio en nuestra área de entrega. Puedes verificar si tu ubicación está dentro de nuestra área de 
                        entrega en nuestra página web.
                      </div>
                    </div>
                  </div>
                
                  <div class="accordion-item" style="background-color: rgb(22, 22, 22);border-radius: 10px; border-color: rgb(22, 22, 22);">
                    <h2 class="accordion-header" id="headingThree" style="background-color: rgb(22, 22, 22);border-radius: 10px;">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseThree"
                        aria-expanded="false"
                        aria-controls="collapseThree"
                      >
                      ¿Tienen opciones de pizza vegetarianas o veganas?
                      </button>
                    </h2>
                    <div
                      id="collapseThree"
                      class="accordion-collapse collapse"
                      aria-labelledby="headingThree"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body">
                        Sí, tenemos opciones vegetarianas y veganas en nuestro menú. Por favor, consulta nuestro menú en línea para ver nuestras opciones 
                        de pizzas vegetarianas y veganas.
                      </div>
                    </div>
                  </div>

                  <div class="accordion-item" style="background-color: rgb(22, 22, 22);border-radius: 10px; border-color: rgb(22, 22, 22);">
                    <h2 class="accordion-header" id="headingThree" style="background-color: rgb(22, 22, 22);border-radius: 10px;">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseFour"
                        aria-expanded="false"
                        aria-controls="collapseFour"
                      >
                      ¿Cuánto tiempo tardan en preparar las pizzas?
                      </button>
                    </h2>
                    <div
                      id="collapseFour"
                      class="accordion-collapse collapse"
                      aria-labelledby="headingFour"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body">
                        El tiempo de preparación varía dependiendo de la cantidad de pedidos que estemos manejando en ese momento, generalmente 
                        toma entre 10 y 25 minutos para preparar una pizza.
                      </div>
                    </div>
                  </div>

                  <div class="accordion-item" style="background-color: rgb(22, 22, 22);border-radius: 10px; border-color: rgb(22, 22, 22);">
                    <h2 class="accordion-header" id="headingThree" style="background-color: rgb(22, 22, 22);border-radius: 10px; ">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseFive"
                        aria-expanded="false"
                        aria-controls="collapseFive"
                      >
                      ¿Tienen promociones o descuentos especiales?
                      </button>
                    </h2>
                    <div
                      id="collapseFive"
                      class="accordion-collapse collapse"
                      aria-labelledby="headingFive"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body">
                        Sí, ofrecemos promociones y descuentos especiales en ocasiones especiales como días festivos o eventos especiales. 
                        Síguenos en nuestras redes sociales para conocer nuestras promociones y descuentos actuales, no te lo pierdas. 
                      </div>
                    </div>
                  </div>

                  <div class="accordion-item" style="background-color: rgb(22, 22, 22);border-radius: 10px; border-color: rgb(22, 22, 22);">
                    <h2 class="accordion-header" id="headingThree" style="background-color: rgb(22, 22, 22);border-radius: 10px;">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseSix"
                        aria-expanded="false"
                        aria-controls="collapseSix"
                      >
                      ¿Cuál es su horario de atención?
                      </button>
                    </h2>
                    <div
                      id="collapseSix"
                      class="accordion-collapse collapse"
                      aria-labelledby="headingSix"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body">
                        Horario de atención de 11:00 a.m a 10:00 p.m. 
                      </div>
                    </div>
                  </div>

                  <div class="accordion-item" style="background-color: rgb(22, 22, 22);border-radius: 10px; border-color: rgb(22, 22, 22);">
                    <h2 class="accordion-header" id="headingThree" style="background-color: rgb(22, 22, 22);border-radius: 10px;">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseSeven"
                        aria-expanded="false"
                        aria-controls="collapseSeven"
                      >
                      ¿Que puedo hacer si he tenido un problema con mi pedido?
                      </button>
                    </h2>
                    <div
                      id="collapseSeven"
                      class="accordion-collapse collapse"
                      aria-labelledby="headingSeven"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body">
                        Si no  te encuentras satisfecho con tu pedido, por favor, comunícate con nosotros de inmediato para que podamos solucionar tu inconveniente. 
                        En katta´s Pizza trabajamos para brindarte un servicio exclusivo y de calidad. 
                      </div>
                    </div>
                  </div>

                  <div class="accordion-item" style="background-color: rgb(22, 22, 22);border-radius: 10px; border-color: rgb(22, 22, 22);">
                    <h2 class="accordion-header" id="headingThree" style="background-color: rgb(22, 22, 22);border-radius: 10px;">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseEight"
                        aria-expanded="false"
                        aria-controls="collapseEight"
                      >
                      ¿Puedo recoger mi pedido en tienda?
                      </button>
                    </h2>
                    <div
                      id="collapseEight"
                      class="accordion-collapse collapse"
                      aria-labelledby="headingEight"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body">
                        Sí, ofrecemos la opción de recoger en tienda.
                      </div>
                    </div>
                  </div>

                  <div class="accordion-item" style="background-color: rgb(22, 22, 22);border-radius: 10px; border-color: rgb(22, 22, 22);">
                    <h2 class="accordion-header" id="headingThree" style="background-color: rgb(22, 22, 22);border-radius: 10px;">
                      <button style="background-color: rgb(22, 22, 22); color: var(--color-texto);border-radius: 10px; font-family: 'Quicksand', sans-serif;"
                        class="accordion-button collapsed"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseNine"
                        aria-expanded="false"
                        aria-controls="collapseNine"
                      >
                      ¿Puedo hacer un pedido en línea y pagar en la tienda?
                      </button>
                    </h2>
                    <div
                      id="collapseNine"
                      class="accordion-collapse collapse"
                      aria-labelledby="headingNine"
                      data-bs-parent="#accordionPizza"
                    >
                      <div style="background-color: var(--color-fondo); color: var(--color-texto); font-family: 'Quicksand', sans-serif;" class="accordion-body">
                        Sí, puedes pagar en la tienda al recoger tu pedido. 
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <footer class="fi">
              <div class="pie_pagina">
                <div class="pie_pagina2" style=" display: flex; align-items: center; flex-direction: column;">
                  <div class="derechos_reservados" style="margin-top: 25%;">
                    <img src="images/Logokatta´s_sin fondo.webp" alt="logo" class= "mx-auto d-block" style="width: 80%;">
                    <h2 style="font-family: 'Source Sans Pro', sans-serif; font-size: 120%;">Katta´s Pizza <i class="fa-regular fa-copyright" style="font-size: 18px;"></i> 2023</h2>
                    <h2 style="font-family: 'Source Sans Pro', sans-serif; font-size: 120%;">Todos los derechos reservados</h2>
                  </div>
                </div>
                  <div class="lista">
                    <h2 style="font-family: 'Source Sans Pro', sans-serif;">Acerca de Katta's Pizza</h2> <br>
                    <ul class="contenido" style="font-family: 'Quicksand', sans-serif;">
                      <li><a href="#"> <i class='bx bxs-car'></i> Domicilios</a></li>  <br>
                      <li><a href="contacto.php"> <i class='bx bxs-phone-call' ></i> Contáctanos</a></li> <br>
                      <li><a href="#"> <i class='bx bxs-food-menu' ></i> Carta</a></li> <br>
                      <li><a href="#"> <i class='bx bxs-location-plus'></i>Encuéntranos</a></li><br><br>
                    </ul>
                  </div>
                <div class="siguenos" >
                  <h2 style="font-family: 'Source Sans Pro', sans-serif;">Síguenos</h2><br>
                  <div class="iconos" style="text-align: center;" >
                    <div style="font-size: 50px; ">
                      <a href="#" style="margin-right: 50px;"><i class="bx bxl-tiktok"></i></a>
                      <a href="#"><i class="bx bxl-facebook-circle"></i></a><br>
                    </div>
                    <div style="font-size: 50px;">
                      <a href="#" style="margin-right: 50px;"><i class="bx bxl-instagram"></i></a>
                      <a href="#"><i class="bx bxl-twitter" ></i></a><br>
                    </div>
                    <div style="font-size: 50px; ">
                      <a href="#"style="margin-right: 50px;"><i class="fa-brands fa-whatsapp" ></i></a>
                      <a href="#"><i class="bx bxl-linkedin"></i></a><br>
                    </div>
                  </div>
                </div>
              </div>
            </footer>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" rel="stylesheet"></script>
    <script src="https://kit.fontawesome.com/b06d3acf28.js" crossorigin="anonymous"></script>
</body>

</html>