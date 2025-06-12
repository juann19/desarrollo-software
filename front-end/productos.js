// productos.js

fetch("http://localhost:8086/api/productos")
  .then(response => {
    if (!response.ok) throw new Error("Error al obtener productos");
    return response.json();
  })
  .then(productos => {
    const contenedor = document.getElementById("productos");
    if (!Array.isArray(productos) || productos.length === 0) {
      contenedor.innerHTML = `<div class="alert alert-info">No hay productos disponibles.</div>`;
      return;
    }

    // Renderizado eficiente usando un solo innerHTML
    const cards = productos.map(p => `
      <div class="col-md-4">
        <div class="card h-100">
          <img src="${p.imagenUrl}" class="card-img-top" alt="${p.nombre}" style="height: 200px; object-fit: cover;" loading="lazy">
          <div class="card-body">
            <h5 class="card-title">${p.nombre}</h5>
            <p class="card-text">${p.descripcion}</p>
            <p class="card-text"><strong>$${p.precio}</strong></p>
            <span class="badge bg-primary">${p.categoria}</span>
          </div>
        </div>
      </div>
    `).join("");
    contenedor.innerHTML = cards;
  })
  .catch(error => {
    console.error("Error:", error);
    document.getElementById("productos").innerHTML = `<div class="alert alert-danger">No se pudieron cargar los productos.</div>`;
  });
