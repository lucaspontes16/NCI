import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class secondPart {
    public static void main(String[] args) throws FileNotFoundException, exceptionFuel {

        int id = 0;
        String sName = "";
        String sFuel = "";
        String sLocation = "";
        int iPostcode = 0;
        long lValue = (long) 0;
        boolean idNotNum = true;

        Set<Integer> ids = new HashSet<>();

        //instatiate the readVehiclesData class
        readVehiclesData loader = new readVehiclesData();

        //stores the vehicle in an array
        ArrayList<Vehicles> vehicles = loader.loadData(10000);

        for (Vehicles vehicle : vehicles) {
            ids.add(vehicle.getiId());
        }
while (idNotNum) {
    try {
            id = Integer.parseInt(JOptionPane.showInputDialog("insert your ID:"));
            if (ids.contains(id)){
            throw exceptionFuel.duplicatedId();
        }
        ids.add(id);
        sName = JOptionPane.showInputDialog("Insert your name:");

        sFuel = JOptionPane.showInputDialog("Insert the fuel");
        if (sFuel.matches("\\d+") == true) {
            throw exceptionFuel.onlyFuel();

        } else if (sFuel.isBlank()) {
            throw exceptionFuel.fieldEmpty();
        }

        sLocation = JOptionPane.showInputDialog("Insert locaton: ");
        iPostcode = Integer.parseInt(JOptionPane.showInputDialog("Insert the post code: "));
        lValue = Long.parseLong(JOptionPane.showInputDialog("Insert the value"));

        idNotNum = false;// if the inputs are valid, exit the loop.

    } catch (exceptionFuel e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    } catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
    }
}
    }


    }

