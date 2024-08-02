import javax.swing.*;
import java.awt.*;

public class exceptionFuel extends Exception{
    String msg;

    //Constructor

    public exceptionFuel(String msg) {
        super();
        this.msg = msg;
    }

    //Exception if the fuel name is empty
    public static exceptionFuel fieldEmpty (){
        JOptionPane.showMessageDialog(null,"The Field can not be empty");
        return null;
    }

    public static exceptionFuel onlyFuel(){
        JOptionPane.showMessageDialog(null,"this field only accept caracters");
        return null;
    }

    public static exceptionFuel duplicatedId(){
        JOptionPane.showMessageDialog(null,"ID already exists.");
        return null;
    }
}
