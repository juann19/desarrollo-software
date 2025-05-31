// productos.js

fetch("http://localhost:8086/api/productos")
  .then(response => {
    if (!response.ok) {
      throw new Error("Error al obtener productos");
    }
    return response.json();
  })
  .then(productos => {
    const contenedor = document.getElementById("productos");

    productos.forEach(p => {
      const card = document.createElement("div");
      card.className = "col-md-4";

      card.innerHTML = `
        <div class="card h-100">
          <img src="${p.imagenUrl}" class="card-img-top" alt="${p.nombre}" style="height: 200px; object-fit: cover;">
          <div class="card-body">
            <h5 class="card-title">${p.nombre}</h5>
            <p class="card-text">${p.descripcion}</p>
            <p class="card-text"><strong>$${p.precio}</strong></p>
            <span class="badge bg-primary">${p.categoria}</span>
          </div>
        </div>
      `;

      contenedor.appendChild(card);
    });
  })
  .catch(error => {
    console.error("Error:", error);
    document.getElementById("productos").innerHTML = `<p class="text-danger">No se pudieron cargar los productos.</p>`;
  });
