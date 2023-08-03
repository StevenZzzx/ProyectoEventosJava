/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.util.Date;

/**
 *
 * @author Steven
 */
public class Event {
    private String name, city, address;
    private final Date date;
    private int totalCap, availCap;
    private final boolean plus18;
    private final Administrador creator;

    public Event(String name, String city, String address, boolean plus18, Date date, int totalCap, Administrador creator){
        this.name = name;
        this.city = city;
        this.address = address;
        this.plus18 = plus18;
        this.date = date;
        this.totalCap = totalCap;
        this.availCap = totalCap;
        this.creator = creator;
        this.creator.addEvent(this);
    }

    public String toString(){
        return this.name +
                "\nEn " + this.city + "," +
                "\n" + this.address +
                "\nEl " + convertDate(this.date) +
                "\n\n" + "Categoria: " + isPlus18(this.plus18) +
                "\nEspacios disponibles: " + this.availCap + "\n\n";
    }

    private String isPlus18(boolean plus18){
        String isPlus18;
        return isPlus18 = (plus18) ? "Mayores de edad" : "Apto para todo publico";
    }

    public static String convertDate(Date date){
        String stringDate = date.getDay() + " de " + date.getMonth() + " del " + date.getYear();
        return stringDate;
    }
}
