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

    //Constructor para iniciar el administrador
    public Administrador(String name, String lastname, String userName, String password, String mail) {
        super(name, lastname, userName, password, mail);
        allUsers.add(this);
    }

    @Override
    public String toString(){
        return  "----- ADMINISTRADOR ----- "+
                "\nNombre: " + super.getName() +
                "\nApellidos: " + super.getLastName() +
                "\nNombre de Usuario: " + super.getUsername() +
                "\nCorreo: " + super.getMail() +
                "\nEstado: " + super.getState();
    }

    public void editEvent(int index){
        Event event2Edit = super.getMyEvents().get(index);

    }

}
