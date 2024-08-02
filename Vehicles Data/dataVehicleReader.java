import javax.swing.plaf.metal.MetalSliderUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class dataVehicleReader {
    public static void main(String[] args) throws Exception {

        //Instanciating readVehicles class
        readVehiclesData dataloader = new readVehiclesData();
        int dataSize = 10;


        //Loading the data into the arrays
        Method<Vehicles> vehiclesBubbleS = (Method<Vehicles>) dataloader.loadData(dataSize);
        Method<Vehicles> vehiclesQuickS = (Method<Vehicles>) dataloader.loadData(dataSize);
        Method<String> toSearch = dataloader.ColumDataload();

        // Checking if the data was loaded
        System.out.println("vehiclesBubble sort size: "+ vehiclesBubbleS.size());
        System.out.println("vehiclesQuick sort size: " + vehiclesQuickS.size());
        System.out.println("Search the  size: " + toSearch.size());

//        System.out.println("Before sorting");
//        for(int i=0;i<vehiclesBubbleS.size();i++){
//            System.out.println(vehiclesBubbleS.get(i));
//        }

        //variables to save start time, end time and execution time
        long startTime;
        long endTime;
        long executionTime;

        //-- Code that runs the QuickSort method
         System.out.println("\nQuick Sort:");
         // save miliseconds into the start time
         startTime = System.currentTimeMillis();
         //running the sorting method
         vehiclesQuickS.quickSort(0, vehiclesQuickS.size() -1);
         //after the quicksort running, the milisaconds is stored into the endTime
         endTime = System.currentTimeMillis();
         //The endTime and startTime is used to get the execution time
         executionTime = endTime - startTime;
         // printing the values
         System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
         System.out.println();


         // ---code that runs the bubble sort Method
        System.out.println("\b Bubble Sort:");
        startTime = System.currentTimeMillis();
        //running the sorting method
        vehiclesBubbleS.simpleBubbleSort();
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        //printing the values
        System.out.println("Execution time: " + executionTime + "ms - " + (executionTime/1000) +"s");
        System.out.println();

       // This method shows the content of the .csv file after the soritng method
        System.out.println("After sorting");
        for(int i=0;i<vehiclesBubbleS.size();i++){
            System.out.println(vehiclesBubbleS.get(i));
        }

        ///-- Code that runs the Binary Search method

        //Value I want to search
        toSearch.sort(null);

        String toSearchElement = "Diesel";
    if (toSearch.binarySearch(toSearch, toSearchElement)==-1) {
        //print if the item was not found in the list
        System.out.println(toSearchElement + " was not FOUND in vehicle list!");
    }else {
        //print if the item was found in the list
        System.out.println(toSearchElement + " was FOUND on the list in vehicle list!");
    }

    }
}
