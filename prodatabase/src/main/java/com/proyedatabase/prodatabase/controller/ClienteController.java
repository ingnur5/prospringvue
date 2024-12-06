package com.proyedatabase.prodatabase.controller;

import com.proyedatabase.prodatabase.modelo.Cliente;
import com.proyedatabase.prodatabase.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/datos")
public class ClienteController {
    private  final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente){

        try {
            return clienteService.gurdarCliente(cliente);
        }catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar el cliente");
        }

    }

    @GetMapping
    public List<Cliente> consultarCliente(){
        return  clienteService.consultarCliente();

    }

    @GetMapping("/{cliente}")

    public List<Cliente> consultarClientePorNombre(@PathVariable String cliente){
         return  clienteService.consultarPorNombre(cliente);
    }

    @GetMapping("/{varios}/{correo}")
    public List<Cliente> consultarDosDatos(@PathVariable String varios,@PathVariable String correo){

        return  clienteService.consultardosdatos(varios, correo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarUsuario(@PathVariable String id, @RequestBody Cliente usuario) {
        try {
            Cliente usuarioActualizado = clienteService.actualizarUsuario(id, usuario);
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Retorna 404 si el usuario no existe
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> actualizarClienteParcial(@PathVariable String id, @RequestBody Cliente clienteParcial) {
        try {
            Cliente cliente = clienteService.actualizarClienteParcial(id, clienteParcial);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Cliente> eliminarcliente(@PathVariable String id){
        try {
            Cliente clienteEliminado = clienteService.eliminarCliente(id);
            return new ResponseEntity<>(clienteEliminado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }




}
