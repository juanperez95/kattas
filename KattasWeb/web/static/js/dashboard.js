
    document.addEventListener("DOMContentLoaded", function () {
        const contadorElement = document.getElementById("contador");
        const aumentarButton = document.getElementById("aumentar");
        const disminuirButton = document.getElementById("disminuir");
        
        let contador = 0;
        
        // Función para aumentar el contador en 1
        aumentarButton.addEventListener("click", function () {
            contador++;
            actualizarContador();
        });
        
        // Función para disminuir el contador en 1 (con validación para no ir por debajo de 0)
        disminuirButton.addEventListener("click", function () {
            if (contador > 0) {
                contador--;
                actualizarContador();
            }
        });
        
        // Función para actualizar el valor del contador en el HTML
        function actualizarContador() {
            contadorElement.textContent = contador;
        }
    });

