const formulario = document.getElementById('miFormulario');

formulario.addEventListener('submit', function(e){
    e.preventDefault();
})




document.getElementById("openModalButton3").addEventListener("click", function() {
    document.getElementById("myModal3").style.display = "block";
});

// Función para cerrar el modal
document.getElementById("closeModalButton3").addEventListener("click", function() {
    document.getElementById("myModal3").style.display = "none";
});

document.getElementById("openModalButton").addEventListener("click", function() {
    document.getElementById("myModal").style.display = "block";
});

document.getElementById("openModalButton4").addEventListener("click", function() {
  document.getElementById("myModal4").style.display = "block";
});

// Función para cerrar el modal
document.getElementById("closeModalButton4").addEventListener("click", function() {
  document.getElementById("myModal4").style.display = "none";
});
// Función para cerrar el modal
document.getElementById("closeModalButton").addEventListener("click", function() {
    document.getElementById("myModal").style.display = "none";
});





function editar() {
    Swal.fire({
      title: '¿Estás seguro de que deseas realizar estos cambios?',
      html: '',
      customClass: {
        confirmButton: 'swal-btn boton-confirmacion',
        cancelButton: 'swal-btn boton-cancelar',
      },
      showCancelButton: true,
      confirmButtonText: 'Sí',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        formulario.submit()

        Swal.fire({
          text: `Insumo agregado`,
          icon: 'success',
          iconColor: '#01C38E',
          customClass: {
            confirmButton: 'swal-btn boton-confirmacion',
          },
          buttonsStyling: true,
        });
      } else {
        Swal.fire({
          text: 'Operación cancelada',
          icon: 'error',
          iconColor: '#FF0000',
          customClass: {
            confirmButton: 'swal-btn boton-confirmacion',
          },
          buttonsStyling: true,
        });
      }
    });
  }
  