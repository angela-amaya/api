package co.edu.unab.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        cliente.setNombre(cliente.getNombre().toLowerCase()); //Opcional, convertir la cadena a minúscula para facilitar buscar por nombre , esto normalmente se hace desde el frontend 
        return clienteRepository.save(cliente);
    }

    public boolean eliminarCliente(String id){

        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }      
                             
    }      
    public Optional<ClienteModel> obtenerClientePorId(String id){
        
        return clienteRepository.findById(id);
    }  
    
    public ArrayList<ClienteModel> obtenerPorNombre (String nombre){
        return  clienteRepository.findByNombre(nombre);
    }

    public  ArrayList<ClienteModel> obtenerCiudadCliente(String ciudad){
        return clienteRepository.clientesporciudad(ciudad);
    }
   public ArrayList<ClienteModel> obtenerClienteCompleto(String nombre,String apellido){
       return clienteRepository.clientescompletos(nombre, apellido);
   }
   public ArrayList<ClienteModel> PuntosMayorIgual(Long puntos){
       return clienteRepository.findByPuntosGreaterThanEqual(puntos);
   }
   public ArrayList<ClienteModel> PuntosMenorIgual(Long puntos){
    return clienteRepository.findByPuntosLessThanEqual(puntos);}

    public ArrayList<ClienteModel> obtenerPorTelefono(String telefono){
        return  clienteRepository.findByTelefono(telefono);
    }

   
}

