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

// Esta es una clase abstracta que no es permitida ser iniciada y contiene unicamente los metodos vacios necesarios
// para usarlos en los almacenamientos de administraodres y clientes
public abstract class Almacenamientos {
    
    public abstract void consultarUsuario(String nombreUsuario);

    public abstract void eliminarUsuario(String nombreUsuario);
    
    public abstract Users autenticarUsuario(String nombreUsuario, String password);

    public abstract boolean verificarUsuarioExistente(String nombreUsuario);
}
