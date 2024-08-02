import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// The objective of this class is load the data from the .csv file
//and returna an array of a chosen amount and a list of location.

public class readVehiclesData {

    Method<Vehicles> loadData(int stopAt) throws FileNotFoundException {

        //parsing and reading the CSV file data into the object array
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//vehicles.csv";
        //Vehicles[] vehicle;

        // take the methods
        Method <Vehicles> vehicles = new Method<>();

        try (Scanner scanner = new Scanner(new File(name))) {


            // this will just print the header in CSV file
            scanner.nextLine();
            int i = 0;
            String sGetData;
            int iterator = 0;
            while (scanner.hasNextLine()) {
                
                // the if  command stops adding vehicles on my list

                if (iterator== stopAt){
                    break;
                }

                sGetData = scanner.nextLine();
                String[] data = sGetData.split(",");
                vehicles.add(new Vehicles(Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]),
                        Long.parseLong(data[5])));

                iterator++;// iterator
            }
            //closes the scanner
        }
        return vehicles;
    }

    // This method contains a list of String conatining only the fuel column
    Method<String> ColumDataload() throws FileNotFoundException{
        //parsing and reading the CSV file data into the object array
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//vehicles.csv";
        //Vehicles[] vehicle;
        Method<Vehicles> vehicles = new Method<>();

        try (Scanner scanner = new Scanner(new File(name))) {

            // this will just print the header in CSV file
            scanner.nextLine();
            String sGetData;
            while (scanner.hasNextLine()) {

                sGetData = scanner.nextLine();
                String[] data = sGetData.split(",");
                vehicles.add(new Vehicles(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]), Long.parseLong(data[5])));
            }
            //closes the scanner
        }


        // Creates a new object to store the fuel data.
        Method<String> fuel = new Method<>();
        for (Vehicles vehicle : vehicles) {
            fuel.add(vehicle.getsFuel());
        }

        return fuel;
    }

}





