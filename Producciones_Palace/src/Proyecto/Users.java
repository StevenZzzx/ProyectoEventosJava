package Proyecto;

// Esta es una clase abstracta que no se permite ser instanciada con ella misma, solo con sus clases hijas
// la cuales son administradores y clientes, contiene los atributos necesarios para estas clases
public abstract class Users {
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String mail;
    private boolean state;

    // Constructor para iniciar cualquier clase hija de Users
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

    // Metodos setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //Metodo para retornar informacion del usuario en String
    public String toString(){
        return "\nNombre: " + this.name + 
        "\nApellidos: " + this.lastName + 
        "\nNombre de Usuario: " + this.userName + 
        "\nCorreo: " + this.mail + 
        "\nEstado: " + this.state;
    }

}
