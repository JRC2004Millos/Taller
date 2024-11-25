package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Factura;
import com.example.demo.service.ContratistaService;
import com.example.demo.service.FacturaService;
import com.example.demo.service.ServicioService;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private ContratistaService contratistaService;

    // http://localhost:8091/facturas/ver
    @GetMapping("/ver")
    public String index(Model model) {
        model.addAttribute("facturas", facturaService.findAll());
        return "facturas-index";
    }

    // http://localhost:8091/facturas/crear
    @GetMapping("/crear")
    public String crear(Model model) {
        Factura factura = new Factura();

        model.addAttribute("contratistas", contratistaService.findAll());
        model.addAttribute("servicios", servicioService.findAll());
        model.addAttribute("factura", factura);
        return "facturas-crear";
    }

    // http://localhost:8091/facturas/crear
    @PostMapping("/crear")
    public String crear(@ModelAttribute("factura") Factura factura) {
        facturaService.save(factura);
        return "redirect:/facturas/ver";
    }

    // http://localhost:8091/facturas/ver/{id}
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable("id") Long id, Model model) {
        Factura factura = facturaService.findById(id);
        model.addAttribute("servicios", servicioService.findAll());
        model.addAttribute("factura", factura);
        return "facturas-ver";
    }

    // http://localhost:8091/facturas/editar/{id}
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Factura factura = facturaService.findById(id);
        model.addAttribute("servicios", servicioService.findAll());
        model.addAttribute("factura", factura);
        return "facturas-modificar";
    }

    // http://localhost:8091/facturas/editar/{id}
    @PostMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, @ModelAttribute("factura") Factura factura) {
        facturaService.save(factura);
        return "redirect:/facturas/ver";
    }

    // http://localhost:8091/facturas/eliminar/{id}
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        facturaService.deleteById(id);
        return "redirect:/facturas/ver";
    }

    // http://localhost:8091/facturas/filtrar
    @GetMapping("/filtrar")
    public String filtrarFacturasPorFecha(
            @RequestParam("fecha") Date fecha,
            Model model) {
        // Buscar facturas con la fecha proporcionada
        List<Factura> facturasFiltradas = facturaService.findByFecha(fecha);

        // Pasar las facturas filtradas a la vista
        model.addAttribute("facturas", facturasFiltradas);
        return "facturas-index"; // Nombre de la plantilla Thymeleaf para mostrar las facturas
    }
}
