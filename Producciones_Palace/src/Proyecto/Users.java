package Proyecto;

import java.util.LinkedList;
import java.util.Objects;

// Esta es una clase abstracta que no se permite ser instanciada con ella misma, solo con sus clases hijas
// la cuales son administradores y clientes, contiene los atributos necesarios para estas clases
public abstract class Users {

    public static LinkedList<Users> allUsers = new LinkedList<Users>();

    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String mail;
    private boolean state;

    // Constructor para iniciar cualquier clase hija de Users
    public Users(){
    }
    public Users(String name, String lastname, String userName, String password, String mail) {
        this.name = name;
        this.lastName = lastname;
        this.userName = userName;
        this.password = password;
        this.mail = mail;
    }

    // Metodos getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public boolean getState() {
        return state;
    }

    //Metodo para retornar informacion del usuario en String
    public String toString(){
        return "\nNombre: " + this.name + 
        "\nApellidos: " + this.lastName + 
        "\nNombre de Usuario: " + this.userName + 
        "\nCorreo: " + this.mail + 
        "\nEstado: " + this.state;
    }

    public static boolean userCheck(String username) {
        for (Users user : allUsers){
            if (Objects.equals(user.getUserName(), username)){
                return true;
            }
        }
        return false;
    }

    public void eliminarUsuario(String username) {

    }

    public static boolean userLogin(String username, String password) {
        for (Users user : allUsers){
            if (Objects.equals(user.getUserName(), username)){
                return Objects.equals(user.getPassword(), password);
            }
        }
        return false;
    }

    public boolean verificarUsuarioExistente(String username) {
        return false;
    }

    public static void printAllUsers(){
        allUsers.forEach(user -> {
            System.out.println(user.toString());
        });
    }

    public static LinkedList<Users> getAllUsers(){
        return allUsers;
    };

}
