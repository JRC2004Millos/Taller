package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // http://localhost:8091/clientes/ver
    @GetMapping("/ver")
    public String ver(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "clientes-index";
    }

    // http://localhost:8091/clientes/ver/{id}
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "clientes-ver";
    }

    // http://localhost:8091/clientes/crear
    @GetMapping("/crear")
    public String crearCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "clientes-crear";
    }

    // http://localhost:8091/clientes/crear
    @PostMapping("/crear")
    public String crearCliente(@ModelAttribute("cliente") Cliente entity) {
        clienteService.add(entity);
        return "redirect:/clientes/ver";
    }

    // http://localhost:8091/clientes/editar/{id}
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.findById(id));
        return "clientes-modificar";
    }

    // http://localhost:8091/clientes/editar/{id}
    @PostMapping("/editar/{id}")
    public String editarCliente(@PathVariable("id") Long id, @ModelAttribute("cliente") Cliente entity) {
        clienteService.update(entity);
        return "redirect:/clientes/ver";
    }

    // http://localhost:8091/clientes/eliminar/{id}
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes/ver";
    }

    // http://localhost:8091/clientes/filtrar
    @GetMapping("/filtrar")
    public String filtrarClientesPorNombre(@RequestParam("nombre") String nombre, Model model) {
        model.addAttribute("clientes", clienteService.findByNombreContainingIgnoreCase(nombre));
        return "clientes-index";
    }
}
