package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.ContratistaRepository;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.ServicioRepository;
import com.example.demo.repository.TarifaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DataBaseInit implements ApplicationRunner {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    ContratistaRepository contratistaRepository;

    @Autowired
    TarifaRepository tarifaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        clienteRepository.save(new Cliente("Juan Pérez", 5551234L, "juan.perez@gmail.com"));
        clienteRepository.save(new Cliente("María López", 5555678L, "maria.lopez@gmail.com"));
        clienteRepository.save(new Cliente("Carlos García", 5559876L, "carlos.garcia@gmail.com"));
        clienteRepository.save(new Cliente("Ana Rodríguez", 5554321L, "ana.rodriguez@gmail.com"));
        clienteRepository.save(new Cliente("Luis Fernández", 5558765L, "luis.fernandez@gmail.com"));
        clienteRepository.save(new Cliente("Laura Sánchez", 5553456L, "laura.sanchez@gmail.com"));
        clienteRepository.save(new Cliente("Jorge Ramírez", 5556543L, "jorge.ramirez@gmail.com"));
        clienteRepository.save(new Cliente("Sofía Torres", 5557890L, "sofia.torres@gmail.com"));
        clienteRepository.save(new Cliente("David Martínez", 5558901L, "david.martinez@gmail.com"));
        clienteRepository.save(new Cliente("Elena Gómez", 5550123L, "elena.gomez@gmail.com"));

        facturaRepository.save(new Factura(Date.valueOf("2022-01-01"), 1000, 400));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-02"), 2000, 800));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-03"), 3000, 1200));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-04"), 4000, 1600));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-05"), 5000, 2000));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-06"), 6000, 2400));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-07"), 7000, 2800));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-08"), 8000, 3200));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-09"), 9000, 3600));
        facturaRepository.save(new Factura(Date.valueOf("2022-01-10"), 10000, 4000));

        servicioRepository.save(new Servicio("Cambio de aceite"));
        servicioRepository.save(new Servicio("Alineación y balanceo"));
        servicioRepository.save(new Servicio("Revisión y reemplazo de filtros"));
        servicioRepository.save(new Servicio("Cambio de batería"));
        servicioRepository.save(new Servicio("Revisión y reparación del sistema de frenos"));
        servicioRepository.save(new Servicio("Afinación del motor"));
        servicioRepository.save(new Servicio("Reparación y mantenimiento de la suspensión"));
        servicioRepository.save(new Servicio("Cambio de neumáticos"));
        servicioRepository.save(new Servicio("Revisión del sistema eléctrico"));
        servicioRepository.save(new Servicio("Reparación de clutch"));
        servicioRepository.save(new Servicio("Reparación y mantenimiento del sistema de escape"));
        servicioRepository.save(new Servicio("Revisión y carga de aire acondicionado"));
        servicioRepository.save(new Servicio("Reparación y mantenimiento de la transmisión"));
        servicioRepository.save(new Servicio("Diagnóstico computarizado del motor"));
        servicioRepository.save(new Servicio("Inspección y reparación de fugas de líquidos"));
        servicioRepository.save(new Servicio("Cambio de correa de distribución"));
        servicioRepository.save(new Servicio("Cambio de pastillas de freno"));
        servicioRepository.save(new Servicio("Limpieza y reparación de inyectores"));
        servicioRepository.save(new Servicio("Reparación de sistemas de dirección hidráulica"));
        servicioRepository.save(new Servicio("Pintura automotriz"));
        servicioRepository.save(new Servicio("Reparación de golpes y abolladuras (Chapa y pintura)"));
        servicioRepository.save(new Servicio("Mantenimiento preventivo general"));
        servicioRepository.save(new Servicio("Reparación de ventanas y vidrios"));
        servicioRepository.save(new Servicio("Instalación y reemplazo de faros y luces"));
        servicioRepository.save(new Servicio("Servicio de grúa (Remolque)"));

        contratistaRepository.save(new Contratista("Juan Pérez", 5551234567L));
        contratistaRepository.save(new Contratista("María López", 5552345678L));
        contratistaRepository.save(new Contratista("Carlos García", 5553456789L));
        contratistaRepository.save(new Contratista("Ana Rodríguez", 5554567890L));
        contratistaRepository.save(new Contratista("Luis Fernández", 5555678901L));
        contratistaRepository.save(new Contratista("Laura Sánchez", 5556789012L));
        contratistaRepository.save(new Contratista("Jorge Ramírez", 5557890123L));
        contratistaRepository.save(new Contratista("Sofía Torres", 5558901234L));
        contratistaRepository.save(new Contratista("David Martínez", 5559012345L));
        contratistaRepository.save(new Contratista("Elena Gómez", 5550123456L));

        tarifaRepository.save(new Tarifa(100.0));
        tarifaRepository.save(new Tarifa(200.0));
        tarifaRepository.save(new Tarifa(300.0));
        tarifaRepository.save(new Tarifa(400.0));
        tarifaRepository.save(new Tarifa(500.0));
        tarifaRepository.save(new Tarifa(600.0));
        tarifaRepository.save(new Tarifa(700.0));
        tarifaRepository.save(new Tarifa(800.0));
        tarifaRepository.save(new Tarifa(900.0));
        tarifaRepository.save(new Tarifa(1000.0));

        List<Factura> facturas = facturaRepository.findAll();
        List<Cliente> clientes = clienteRepository.findAll();

        int indiceCliente = 0;
        for (Factura factura : facturas) {
            factura.setCliente(clientes.get(indiceCliente));
            facturaRepository.save(factura);

            indiceCliente++;
        }

        int indice = 0;
        for (Tarifa tarifa : tarifaRepository.findAll()) {
            tarifa.setContratista(contratistaRepository.findAll().get(indice));
            tarifa.setServicio(servicioRepository.findAll().get(indice));
            tarifaRepository.save(tarifa);

            indice++;
        }
    }
}
