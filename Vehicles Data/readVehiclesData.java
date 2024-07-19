import java.io.File;
import java.util.*;

public class readVehiclesData {

    public static void main(String[] args) throws Exception {
        //parsing and reading the CSV file data into the object array
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//vehicles.csv";
        Vehicles[] vehicle;

        Method<Vehicles> vehicles = new Method<>();// create a new array to

        try (Scanner scanner = new Scanner(new File(name))) {
            vehicle = new Vehicles[10000];

            // this will just print the header in CSV file
            scanner.nextLine();
            int i = 0;
            String sGetData;
            while (scanner.hasNextLine()) {
                sGetData = scanner.nextLine();
                String[] data = sGetData.split(",");
                vehicle[i++] = new Vehicles(Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]),
                        Long.parseLong(data[5]));

                vehicles.add(new Vehicles(Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]),
                        Long.parseLong(data[5])));
            }
            //closes the scanner
        }

        // we can print details due to overridden toString method in the class below
        System.out.println(vehicle[0]);
        System.out.println(vehicle[1]);

        // we can compare objects based on their ID due to overridden CompareTo method in the class below
        System.out.println(vehicle[0] == vehicle[0]);
        System.out.println(vehicle[0] == vehicle[1]);
        System.out.println(vehicles.size());
        vehicles.quickSort(0, vehicles.size()-1);
    for (int i = 0; i<100; i++){
        System.out.println(vehicles.get(i));
    }
    }

}



