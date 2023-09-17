<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lilita+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Alkatra:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>Login</title>

    <link rel="stylesheet" href="css/login.css">
</head>

<body>

    <div class="division">
        <div class="izquierda">
            <img src="images/fondo_login2.jpg" class="img-fluid imagen">
            <div class="texto">
                <h1>¡Bienvenidos a Katta's Pizza!</h1>
                <br>
            </div>
            <div class="texto2">
                <h2>Únete hoy mismo y descubre por qué somos el destino preferido de los verdaderos amantes de la pizza,
                    regístrate o inicia sesión y comienza a disfrutar de una experiencia única. <br>
                    ¡Te esperamos con una deliciosa pizza recién salida del horno!</h2>
            </div>
        </div>

        <div class="derecha">
            <div class="login-box">
                <div style="top: 0;">
                    <div class="texto_login">
                        <h1>Katta´s Pizza</h1>
                    </div>
                    <div class="texto_login2">
                        <h2>Inicia sesión o regístrate para ingresar</h2>
                    </div>
                    <form action="Controladores/C_Login.php" class="form" method="GET">
                        <label for="correo">Correo electrónico</label>
                        <input type="email" id="email" class="email" name="email" required>

                        <label for="contraseña">Contraseña</label>
                        <input type="password" id="con" name="pass" required>

                        <button class="buton" type="submit" style="font-size: 15px">Iniciar sesión</button><br><br><br>

                        <a href="#" class="pie">¿Olvidaste tu contraseña?</a><br>

                        <a href="interfaz2.php" class="pie2">Crear cuenta nueva</a>
                    </form>
                    <!-- Verificar cookie si no coinciden las contraseñas -->
                </div>
            </div>
        </div>
    </div>
    <script src="login.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>

</html>