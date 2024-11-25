function actualizarServicios() {
    // Obtener los contratistas seleccionados
    let contratistaIds = Array.from(document.querySelectorAll('input[name="contratistaIds"]:checked'))
                              .map(checkbox => checkbox.value);

    if (contratistaIds.length === 0) {
      document.getElementById('servicios-list').innerHTML = ''; // Si no hay seleccionados, vaciar la lista de servicios
      return;
    }

    // Hacer la solicitud AJAX para obtener los servicios según los contratistas seleccionados
    fetch(`/factura/serviciosPorContratista?contratistaIds=${contratistaIds.join(',')}`)
      .then(response => response.json())
      .then(servicios => {
        let serviciosList = document.getElementById('servicios-list');
        serviciosList.innerHTML = ''; // Limpiar lista actual

        // Agregar cada servicio como checkbox
        servicios.forEach(servicio => {
          let checkboxHtml = `
            <div class="col-md-4">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" id="${servicio.id}" name="servicioIds" value="${servicio.id}">
                <label class="form-check-label" for="${servicio.id}">${servicio.descripcion}</label>
              </div>
            </div>`;
          serviciosList.insertAdjacentHTML('beforeend', checkboxHtml);
        });
      });
  }