import java.util.ArrayList;


/*
*Method.java
* @author Lucas
* 25/07/2024
 */

//This class contains all the sorting methods
public class Method<ElementType> extends ArrayList<ElementType> {

    //-----QUICK SORT METHOD--------
    public void quickSort(int iStart, int iEnd) {
        int PivotIndex;
        //local variable declared to store the index of the pivot element.

        if (iStart < iEnd) {
            //checks if the start index is less than the end index.
            PivotIndex = partition(iStart, iEnd);
            // This verifies if the sub-array has more than one element
            quickSort(iStart, PivotIndex - 1);
            // Calls Recursively the 'quickSort' method on the left partition of the array.
            //sorts the elements less than the pivot.

            //sort second partition of the array
            quickSort(PivotIndex + 1, iEnd);
            // Calls Recursively the 'quickSort' method on the right partition of the array.
            //sorts the elements greater than the pivot

        } else // returns anything if the start index is not less than the end index.
        {
            return;
        }
    }

    //-------The partition list method----
    public int partition(int iStart, int iEnd) {
        //The start and end indices of the sub-array to be partitioned
        int iUp, iDown;
        //variables declared to be used as indices to traverse the sub-array

        ElementType pivot;
        // local variable declared to store the pivot element
        pivot = get(iStart);
        // select the first element as pivot

        // set the UP and DOWN indexes
        iUp = iStart;
        //initializes to the start index
        iDown = iEnd;
        //initializes to the end index

        while (iUp < iDown) {
            // as long as UP and DOWN indexes did not pass each other
            while (iUp < iEnd && ((Comparable) get(iUp)).compareTo((Comparable) pivot) <= 0) {
                // increment UP index until finds an element that is greater than the pivot.
                iUp = iUp + 1;
            }

            // decrement DOWN until finds the element that is less than or equal to the pivot.
            while (iDown > iStart && (((Comparable) get(iDown)).compareTo((Comparable) pivot) > 0)) {
                iDown = iDown - 1;
            }

            // if UP and DOWN indexes have not crossed each other, it means we have found a pair of elements
            // that needs to be swapped.
            if (iUp < iDown) {
                ElementType elementUp = get(iUp);
                //swap the two elements found
                set(iUp, get(iDown));
                set(iDown, elementUp);
            }
        }

        // UP and DOWN indexes have passed each other, so swap pivot with the element on DOWN position
        set(iStart, get(iDown));
        set(iDown, pivot);
        return iDown;
    }

    //------Bubble sort Method------
    public void simpleBubbleSort() {

        boolean bMoreSwaps = true;
        //declares a boolean variable to track whether any swaps were made in the current iteration.

        while (bMoreSwaps == true) {
            //loop that continues until no more swaps are needed, indicating that the list is sorted
            int iCount;
            //declare a variable to iterate over the list
            bMoreSwaps = false;
            //resets the 'bMoreSwaps' flag to 'false' at the beginning of each iteration.
            for (iCount = 0; iCount < size() - 1; iCount++) {
                //Iterates over the list, comparing each element with its adjacent element.
                Comparable elementAtiCount = (Comparable) get(iCount);
                Comparable elementAtiCountPlus = (Comparable) get(iCount + 1);
                //Retrieves the elements at indices and casts them to 'comparable' objects.

                if (elementAtiCount.compareTo(elementAtiCountPlus) > 0) {
                    //compares the two elements using the compare method. if the element at 'iCount' is grater than
                    // the element at 'iCount +1', a swap is needed.
                    swap(iCount, iCount + 1);
                    //call the swap method to swap the two elements
                    bMoreSwaps = true;
                    // Sets the 'bMoreSwaps' flag to 'true' to indicate that a swap was made
                }
            }
        }
    }

    //--- Swap method-----
    public void swap(int inPos1, int inPos2) {
        //Create two objects that will store the info from the two positions
        ElementType objPos1 = get(inPos1);
        ElementType objPos2 = get(inPos2);

        //Remove element from position 1
        remove(inPos1);

        //Insert objPos2 into position 1
        add(inPos1, objPos2);

        //Remove element from position 2
        remove(inPos2);

        // Insert objPos1 into position 2
        add(inPos2, objPos1);
    }

    //--- Binary Search Method----
    public int binarySearch(ArrayList<String> arr,String value) {
        //Initializes the left
        int left = 0;
        //Initializes the right
        int right = arr.size() -1;//is the index of the 'value' in the 'arr' if found, or '-1' if not found.
        //
        while (left <= right){
            //The loop continues until 'left' is geater than 'right'
            int middle = (left + right) / 2;
            //Calculates the middle index of the current search range using the average of left and right
            String midValue = arr.get(middle);
            //Get the String value at the mipoint index from the 'ArrayList'


                //compares the midpoint value to the target value
                int comp = midValue.compareTo(value);

            if (comp == 0){
                // if midpoint value is equal to the target value
                return middle;
                //return the midpoint index.
            } else if (comp < 0){
                //if the midpoint value is less than the target value.
                left = middle + 1;
                //Update left index to 'middle+1 to search the right part of the array
            }else {
            right = middle - 1;
            //update the 'right' index to 'mid - 1' to search in the left half of the array.
        }
    }
    return -1;
        // returns -1 to indicate that the value is not present.
}

}






