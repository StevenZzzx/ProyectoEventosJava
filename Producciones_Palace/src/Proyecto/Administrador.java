/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Steven
 */
public class Administrador extends Users{

    private boolean isAdmin;

    //Constructor para iniciar el administrador
    public Administrador(String name, String lastname, String userName, String password, String mail, boolean isAdmin) {
        super(name, lastname, userName, password, mail);
        this.isAdmin = isAdmin;
        allUsers.add(this);
    }

    public Administrador(){
        super();
    }

    @Override
    public String toString(){
        return  "----- ADMINISTRADOR ----- "+
                "\nNombre: " + super.getName() +
                "\nApellidos: " + super.getLastName() +
                "\nNombre de Usuario: " + super.getUserName() +
                "\nCorreo: " + super.getMail() +
                "\nEstado: " + super.getState();
    }

}
