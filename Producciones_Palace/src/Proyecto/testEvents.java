package Proyecto;

import java.util.Date;

public class testEvents {

    public static void main(String[] args) {
        Date fecha = new Date(2023, 8, 25);
        Administrador admin = new Administrador("Kenneth", "Fuentes", "Kenfu", "123", "kenfu@mail.com");

//        Event evento = new Event("Barbie", "Monteverde", "Centro Comercial", false, fecha, 100, admin);
//        Event evento2 = new Event("Orgia publica", "Monteverde", "Centro Comercial", true, fecha, 20, admin);

        System.out.println(admin.returnClass());

//        admin.printAllMyEvents();
    }
}
