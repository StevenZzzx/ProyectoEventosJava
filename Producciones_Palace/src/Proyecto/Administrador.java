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
    private double salario;

    //Constructor para iniciar el administrador
    public Administrador(String name, String lastname, String userName, String password, String mail, double salario) {
        super(name, lastname, userName, password, mail);
        this.salario = salario;
    }
    
    //Metodos getter y setter para el salario
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Edite de nuevo el metodo String para poder devolver el salario
    @Override
    public String toString(){
        return "\nNombre: " + super.getName() + 
        "\nApellidos: " + super.getLastName() + 
        "\nNombre de Usuario: " + super.getUserName() + 
        "\nCorreo: " + super.getMail() + 
        "\nEstado: " + super.getState() + 
        "\nSalario: " + this.salario;
    }
}
