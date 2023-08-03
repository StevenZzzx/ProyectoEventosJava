package Proyecto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class ValidateUtil {

    public static boolean checkNoEmpty(String[] toCheck){
        for (String word : toCheck){

            if (Objects.equals(word, "")){
                return false;
            }
        }
        return true;
    }

}
