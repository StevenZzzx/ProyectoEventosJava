/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.util.LinkedList;

/**
 *
 * @author Steven
 */
public class AlmacenamientoClientes extends Almacenamientos {
    //Atributo LinkedList de tipo Cliente 
    private LinkedList<Cliente> clientes;

    //Constructor para iniciar la clase con el almacenamiento LinkedList para los clientes
    public AlmacenamientoClientes(){
        clientes = new LinkedList<>();
    }

    //Metodos para registrar, iniciar sesion, consultar, eliminar y verificar si un usuario ya existe
    public void registrarCliente(Cliente nombreUsuario) {
        clientes.add(nombreUsuario);
    }
    
    @Override
    public void consultarUsuario(String nombreUsuario) {
        for (Cliente cliente : clientes) {
            if (cliente.getUserName().equals(nombreUsuario)) {
                System.out.println(cliente.toString());
            }
        }
    }

    @Override
    public void eliminarUsuario(String nombreUsuario) {
        for (Cliente cliente : clientes) {
            if (cliente.getUserName().equals(nombreUsuario)) {
                clientes.remove(cliente);
            }
        }
    }
    
    @Override
    public Cliente autenticarUsuario(String nombreUsuario, String password) {
        for (Cliente cliente : clientes) {
            if (cliente.getUserName().equals(nombreUsuario) && cliente.getPassword().equals(password)) {                
                cliente.setState(true);
                return cliente;
            }
        }
        return null; 
        
    }

    @Override
    public boolean verificarUsuarioExistente(String nombreUsuario) {
        for (Cliente cliente : clientes) {
            if (cliente.getUserName().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }
}
