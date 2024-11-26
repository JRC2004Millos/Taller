package com.example.demo.controller;

import com.example.demo.model.Contratista;
import com.example.demo.service.ContratistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contratistas")
public class ContratistaController {

    @Autowired
    private ContratistaService contratistaService;

    // Obtener la lista de todos los contratistas
    // GET http://localhost:8091/contratistas/ver
    @GetMapping("/ver")
    public String verContratistas(Model model) {
        List<Contratista> contratistas = contratistaService.findAll();
        model.addAttribute("contratistas", contratistas);
        return "contratistas-index"; // Vista para listar contratistas
    }

    // Ver un contratista específico
    // GET http://localhost:8091/contratistas/ver/{id}
    @GetMapping("/ver/{id}")
    public String verContratista(@PathVariable("id") Long id, Model model) {
        Contratista contratista = contratistaService.findById(id);
        model.addAttribute("contratista", contratista);
        return "contratistas-ver"; // Vista para mostrar detalles de un contratista
    }

    // Formulario para crear un contratista
    // GET http://localhost:8091/contratistas/crear
    @GetMapping("/crear")
    public String crearContratistaForm(Model model) {
        model.addAttribute("contratista", new Contratista());
        return "contratistas-crear"; // Vista para crear un contratista
    }

    // Crear un contratista
    // POST http://localhost:8091/contratistas/crear
    @PostMapping("/crear")
    @ResponseBody
    public Contratista crearContratista(@RequestBody Contratista contratista) {
        contratistaService.save(contratista);
        return contratista; // Retorna el contratista creado como JSON
    }

    // Formulario para editar un contratista
    // GET http://localhost:8091/contratistas/editar/{id}
    @GetMapping("/editar/{id}")
    public String editarContratistaForm(@PathVariable("id") Long id, Model model) {
        Contratista contratista = contratistaService.findById(id);
        model.addAttribute("contratista", contratista);
        return "contratistas-editar"; // Vista para editar un contratista
    }

    // Editar un contratista
    // POST http://localhost:8091/contratistas/editar/{id}
    @PostMapping("/editar/{id}")
    public String editarContratista(@PathVariable("id") Long id, @ModelAttribute Contratista contratista) {
        contratista.setId(id);
        contratistaService.update(contratista);
        return "redirect:/contratistas/ver"; // Redirige a la lista de contratistas
    }

    // Eliminar un contratista
    // GET http://localhost:8091/contratistas/eliminar/{id}
    @GetMapping("/eliminar/{id}")
    public String eliminarContratista(@PathVariable("id") Long id) {
        contratistaService.deleteById(id);
        return "redirect:/contratistas/ver"; // Redirige a la lista de contratistas
    }

    // Filtrar contratistas por nombre
    // GET http://localhost:8091/contratistas/filtrar
    @GetMapping("/filtrar")
    public String filtrarContratistas(@RequestParam("nombre") String nombre, Model model) {
        List<Contratista> contratistas = contratistaService.findByNombreContainingIgnoreCase(nombre);
        model.addAttribute("contratistas", contratistas);
        return "contratistas-index"; // Vista con los resultados del filtro
    }
}
