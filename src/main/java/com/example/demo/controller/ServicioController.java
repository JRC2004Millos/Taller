package com.example.demo.controller;

import com.example.demo.model.Servicio;
import com.example.demo.service.ServicioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // http://localhost:8091/servicios/ver
    @GetMapping("/ver")
    public String ver(Model model) {
        model.addAttribute("servicios", servicioService.findAll());
        return "servicios-index";
    }

    // http://localhost:8091/servicios/ver/{id}
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable("id") Long id, Model model) {
        model.addAttribute("servicio", servicioService.findById(id));
        return "servicios-ver";
    }

    // http://localhost:8091/servicios/crear
    @GetMapping("/crear")
    public String crearServicio(Model model) {
        Servicio servicio = new Servicio();
        model.addAttribute("servicio", servicio);
        return "servicios-crear";
    }

    // http://localhost:8091/servicios/crear
    @PostMapping("/crear")
    @ResponseBody
    public Servicio crearServicio(@RequestBody Servicio nuevoServicio) {
        // Asegúrate de que el servicio se guarda correctamente en la base de datos
        servicioService.save(nuevoServicio);

        // Devuelve el servicio recién creado como JSON
        return nuevoServicio;
    }

    // http://localhost:8091/servicios/editar/{id}
    @GetMapping("/editar/{id}")
    public String editarServicio(@PathVariable("id") Long id, Model model) {
        model.addAttribute("servicio", servicioService.findById(id));
        return "servicios-modificar";
    }

    // http://localhost:8091/servicios/editar/{id}
    @PostMapping("/editar/{id}")
    @ResponseBody
    public String editarServicio(
            @PathVariable("id") Long id,
            @RequestBody Servicio servicioActualizado) {
        Servicio servicio = servicioService.findById(id);
        if (servicio != null) {
            servicio.setNombre(servicioActualizado.getNombre());
            servicioService.update(servicio);
            return "OK";
        }
        return "ERROR";
    }

    // http://localhost:8091/servicios/eliminar/{id}
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        servicioService.deleteById(id);
        return "redirect:/servicios/ver";
    }

    // http://localhost:8091/servicios/filtrar
    @GetMapping("/filtrar")
    public String filtrarServiciosPorNombre(@RequestParam("nombre") String nombre, Model model) {
        model.addAttribute("servicios", servicioService.findByNombreContainingIgnoreCase(nombre));
        return "servicios-index";
    }
}
