package Proyecto;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class TestUsuarios {
    public static void main(String[] args) {
        Administrador usuario = new Administrador("steven", "rodriguez", "steven12", "steven1213", "hol@ho", 2000);
        Cliente usuario2 = new Cliente("yo", "yo", "yo", "yo", "yo");
        AlmacenamientoAdministradores Admins = new AlmacenamientoAdministradores();
        AlmacenamientoClientes clientes = new AlmacenamientoClientes();
        
        Admins.registrarAdministrador(usuario);
        clientes.registrarCliente(usuario2);
        Admins.consultarUsuario("steven1213");
        Admins.autenticarUsuario("steven12", "steven1213");
        Admins.verificarUsuarioExistente("steven12");

        clientes.consultarUsuario("yo");
        Admins.consultarUsuario("steven12");
    }  
}
