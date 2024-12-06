package com.proyedatabase.prodatabase.service;

import com.proyedatabase.prodatabase.modelo.Cliente;
import com.proyedatabase.prodatabase.repository.ClienteRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private  final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public Cliente gurdarCliente(Cliente cliente){
        try {
            if (clienteRepository.existsById(cliente.getDocumento())) {
                throw new RuntimeException("Ya existe un cliente con este documento");
            }
            return clienteRepository.save(cliente);
        } catch (DataAccessException e){
            throw new RuntimeException("Error al guardar el cliente");
        }

    }

    public Cliente consultarClientePorId(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }


    public List<Cliente> consultarCliente(){
        try {
            return clienteRepository.findAll();
        }catch (DataAccessException e){
            throw new RuntimeException("Error al consultar los clientes");
        }

    }


    public List<Cliente> consultarPorNombre(String nombre){
        return clienteRepository.findByNombre(nombre);
    }

public List<Cliente> consultardosdatos(String nom, String cor){
        return  clienteRepository.findByNombreAndCorreo(nom, cor);
}

    public Cliente actualizarUsuario(String id, Cliente usuarioActualizado) {
        Optional<Cliente> usuarioExistente = clienteRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Cliente usuario = usuarioExistente.get();
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            return clienteRepository.save(usuario);  // Guardamos la entidad actualizada
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);  // Excepción si el usuario no existe
        }
    }


    public Cliente actualizarClienteParcial(String id, Cliente clienteParcial) {
        // Buscar al cliente en la base de datos
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);

        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();

            // Actualizar solo los campos proporcionados (no null)
            if (clienteParcial.getNombre() != null) {
                cliente.setNombre(clienteParcial.getNombre());
            }

            if (clienteParcial.getCorreo() != null) {
                cliente.setCorreo(clienteParcial.getCorreo());
            }

            // Guardar los cambios
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente no encontrado con ID: " + id);
        }
    }

public Cliente eliminarCliente(String id){
        try {
            clienteRepository.deleteById(id);
            return null;
        } catch (DataAccessException e){
            throw new RuntimeException("Error al eliminar el cliente");
        }

}





}
