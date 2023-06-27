<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/contacto.css">
    <link href="https://fonts.googleapis.com/css2?family=Lilita+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300&display=swap" rel="stylesheet">
    
    <title>Katta´s pizza</title>
    

    <style>
    @import url('https://fonts.googleapis.com/css2?family=Lato:ital,wght@1,700&display=swap');
    </style>
</head>


<body>
    <div class="logo_imagen" style=" display: flex; align-items: center; justify-content: center;">
        <a class="mr-auto" href="index.php" ><img src="images/Logokatta´s_sin fondo.webp" style="max-height: 100px;" alt="logo"></a>
    </div>
    <div class="formulario">
    <header><h1 style="font-size: 25px">Formulario de contacto</h1></header>
    <main>
    <form style= "font-family: 'Quicksand', sans-serif;"> 
        <label for="nombre">Nombre <span class="obligatorio">*</span></label>
        <br>
        <input type="text" name="Nombre" id="name" required>
        <br>
        <label for="apellido">Apellido <span class="obligatorio">*</span></label>
        <br>
        <input type="text" name="apellido" id="apellido" required>
        <br>
        <label for="email">Email <span class="obligatorio">*</span></label>
        <br>
        <input type="email" required>
        <br>
        <label for="telefono">Teléfono <span class="obligatorio">*</span></label>
        <br>
        <input type="number" maxlength="10" required>
        <br>
        <label for="asunto">Asunto <span class="obligatorio">*</span></label>
        <br>
        <input type="text" required>
        <br>
        <input type="submit" value="Enviar">
    </form>
    </main>
    </div>

</body>
</html>