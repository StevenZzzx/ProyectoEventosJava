package Proyecto;

import java.util.LinkedList;
import java.util.Objects;

// Esta es una clase abstracta que no se permite ser instanciada con ella misma, solo con sus clases hijas
// la cuales son administradores y clientes, contiene los atributos necesarios para estas clases
public abstract class Users {

    protected static final LinkedList<Users> allUsers = new LinkedList<Users>();
    private final LinkedList<Event> myEvents = new LinkedList<Event>();

    private final String name, lastname, username, password, mail;
    private boolean state;

    // Constructor para iniciar cualquier clase hija de Users
    public Users(String name, String lastname, String username, String password, String mail) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    // Metodos getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public String getUsername() {
        return username;
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
        "\nApellidos: " + this.lastname +
        "\nNombre de Usuario: " + this.username +
        "\nCorreo: " + this.mail + 
        "\nEstado: " + this.state;
    }

    public static int userCheck(String username) {
        for (int i= 0; i < allUsers.size(); i++){
            if (Objects.equals(allUsers.get(i).getUsername(), username)){
                return i;
            }
        }
        return -1;
    }

    public static boolean userLogin(int index, String username, String password) {
        Users user = allUsers.get(index);
        if (Objects.equals(user.getUsername(), username)){
            return Objects.equals(user.getPassword(), password);
        }
        return false;
    }

    public static Users returnUser(int index){
        return allUsers.get(index);
    }

    public static void printAllUsers(){
        allUsers.forEach(user -> {
            System.out.println(user.toString());
        });
    }

    public void printAllMyEvents(){
        myEvents.forEach(event -> {
            System.out.println(event.toString());
        });
    }

    public static LinkedList<Users> getAllUsers(){
        return allUsers;
    }

    public void addEvent(Event event){
        myEvents.add(event);
    }

    public LinkedList<Event> getMyEvents(){
        return myEvents;
    }

    public String returnClass(){
        if (this.getClass() == Administrador.class){
            return "admin";
        } else {
            return "cliente";
        }
    }

}
