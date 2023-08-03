/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import jdk.jfr.Event;

import java.util.LinkedList;

/**
 *
 * @author Steven
 */
public class Cliente extends Users{


    //Constructor para iniciar el Cliente
    public Cliente(String name, String lastname, String userName, String password, String mail) {
        super(name, lastname, userName, password, mail);
        allUsers.add(this);
    }


}
