// Obtén el botón para abrir el modal y el botón para cerrar el modal
const openModalBtn = document.getElementById("openModalBtn");
const closeModalBtn = document.getElementById("closeModalBtn");
const modal = document.getElementById("myModal");

// Cuando el usuario haga clic en el botón para abrir el modal, muestra el modal
openModalBtn.addEventListener("click", () => {
  modal.style.display = "block";
});

// Cuando el usuario haga clic en el botón para cerrar el modal, oculta el modal
closeModalBtn.addEventListener("click", () => {
  modal.style.display = "none";
});

// Cuando el usuario haga clic en cualquier lugar fuera del modal, cierra el modal
window.addEventListener("click", (event) => {
  if (event.target === modal) {
    modal.style.display = "none";
  }
});



function editar() {
    // Variables iniciales
      let days = 0; // Cantidad de días
    
    
      Swal.fire({
        title: 'Agregar o restar días al alquiler',
        customClass: {
          title: 'titulo', // Clase CSS personalizada para el título
        },
        html: `
          <div class="informacion-control">
            <div class="image-control">
            <img src="images/hp1.jpg" alt="Descripción de la imagen">
            </div>
            <p>Detalles del alquiler:</p><br>
            <p>Sistema operativo: Windows 11 Home Single Language</p><br>
            <p>Procesador: Intel® Core™ i3-1215U (hasta 4,4 GHz con tecnología Intel® Turbo Boost, 10 MB de caché L3, 6 núcleos y 8 subprocesos)</p><br>
            <p>Equipo: Equipo HP</p><br>
            <p>Descripción: Ram 8GB</p><br>
            <p>Usuario: 110237 - Juan</p><br><br>
          </div>
    
          <div class='days-question'>
            <p>¿Cuantos días deseas adicionar a tu alquiler?<p>
          </div>
    
          <div class="days-control">
            <button id="restar" class="swal-btn"><i class="fa-solid fa-minus"></i></button>
            <span id="days-count">${days}</span>
            <button id="agregar" class="swal-btn"><i class="fa-solid fa-plus"></i></button>
          </div>
        `,
    
        customClass: {
          confirmButton: 'swal-btn boton-confirmacion',
          cancelButton: 'swal-btn boton-cancelar',
        },
    
        buttonsStyling: true,
        showCancelButton: true,
        confirmButtonText: 'Agregar días',
        cancelButtonText: 'Cancelar',
        
        preConfirm: () => {
          // Mostrar un mensaje de confirmación personalizado
          return Swal.fire({
            title: '¿Estás seguro de que deseas realizar estos cambios?',
            html: 'El valor total del alquiler quedará en: 150.000',
            customClass: {
              confirmButton: 'swal-btn boton-confirmacion',
              cancelButton: 'swal-btn boton-cancelar',
            },
            showCancelButton: true,
            confirmButtonText: 'Sí',
            cancelButtonText: 'Cancelar'
          }).then((result) => {
            if (result.isConfirmed) {
              return days; // Devolver los días para continuar con la operación
            } else {
              return null; // Si el usuario cancela, se detiene la acción
            }
          });
        },
        allowOutsideClick: () => !Swal.isLoading(),
        didOpen: () => {
          // Agregar evento al botón de restar
          const subtractButton = Swal.getPopup().querySelector('#restar');
          subtractButton.addEventListener('click', () => {
            if (days > 0) {
              days--;
              updateDaysCount();
            }
          });
    
          // Agregar evento al botón de sumar
          const addButton = Swal.getPopup().querySelector('#agregar');
          addButton.addEventListener('click', () => {
            days++;
            updateDaysCount();
          });
    
          // Función para actualizar el contador de días
          function updateDaysCount() {
            const daysCountElement = Swal.getPopup().querySelector('#days-count');
            daysCountElement.textContent = days;
          }
          
        },
      }).then((result) => {
        if (result.isConfirmed && result.value !== null) {
          // Aquí se agrega la lógica para sumar o restar días al alquiler
          Swal.fire({
            text: `Días modificados: ${days}`,
            icon: 'success',
            iconColor: '#01C38E',
            
            customClass: {
              confirmButton: 'swal-btn boton-confirmacion',
            },
            buttonsStyling: true,
          });
          
        }
      });
    }
    
    
    function informacion() {
      // Variables iniciales
        let days = 0; // Cantidad de días
      
      
        Swal.fire({
          title: 'Información del alquiler',
          customClass: {
            title: 'titulo', // Clase CSS personalizada para el título
          },
          html: `
            <div class="Minformacion-control">
              <div class="image-control">
              <img src="images/hp1.jpg" alt="Descripción de la imagen">
              </div>
              <p>Detalles del alquiler:</p><br>
              <p>Sistema operativo: Windows 11 Home Single Language</p><br>
              <p>Procesador: Intel® Core™ i3-1215U (hasta 4,4 GHz con tecnología Intel® Turbo Boost, 10 MB de caché L3, 6 núcleos y 8 subprocesos)</p><br>
              <p>Equipo: Equipo HP</p><br>
              <p>Descripción: Ram 8GB</p><br>
              <p>Usuario: 110237 - Juan</p><br><br>
            </div>
          `,
      
          customClass: {
            confirmButton: 'swal-btn boton-confirmacionInfo',
            cancelButton: 'swal-btn boton-cancelar',
          },
      
          buttonsStyling: true,
        
          confirmButtonText: 'OK',
          
          
    
          allowOutsideClick: true,
    
        })
      }
      
      
      
      
    