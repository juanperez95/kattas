// Obtén el modal y el botón para cerrarlo
const modal = document.getElementById('myModal');
const closeBtn = document.getElementsByClassName('close')[0];

// Event listener para mostrar el modal cuando se haga clic en "Agregar al carrito"
document.querySelectorAll('.agregar').forEach((boton) => {
    boton.addEventListener('click', () => {
        modal.style.display = 'block';
    });
});

// Event listener para cerrar el modal cuando se haga clic en la "X"
closeBtn.addEventListener('click', () => {
    modal.style.display = 'none';
});

// Cierra el modal si se hace clic fuera de él
window.addEventListener('click', (event) => {
    if (event.target == modal) {
        modal.style.display = 'none';
    }
});
