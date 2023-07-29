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
public class AlmacenamientoAdministradores extends Almacenamientos {
    //Atributo LinkedList de tipo Administrador 
    private LinkedList<Administrador> administradores;

    //Constructor para iniciar la clase con el almacenamiento LinkedList para los administradores
    public AlmacenamientoAdministradores(){
        administradores = new LinkedList<>();
    }

    //Metodos para registrar, iniciar sesion, consultar, eliminar y verificar si un usuario ya existe
    public void registrarAdministrador(Administrador nombreUsuario) {
        administradores.add(nombreUsuario);
    }

    @Override
    public void consultarUsuario(String nombreUsuario) {
        for (Administrador admin : administradores) {
            if (admin.getUserName().equals(nombreUsuario)) {
                System.out.println(admin.toString());
            }
        }
    }

    @Override
    public void eliminarUsuario(String nombreUsuario) {
        for (Administrador admin : administradores) {
            if (admin.getUserName().equals(nombreUsuario)) {
                administradores.remove(admin);
            }
        }
    }
    
    @Override
    public Administrador autenticarUsuario(String nombreUsuario, String password) {
        for (Administrador admin : administradores) {
            if (admin.getUserName().equals(nombreUsuario) && admin.getPassword().equals(password)) {                
                admin.setState(true);
                return admin;
            }
        }
        return null; 
        
    }

    @Override
    public boolean verificarUsuarioExistente(String nombreUsuario) {
        for (Administrador admin : administradores) {
            if (admin.getUserName().equals(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

}
