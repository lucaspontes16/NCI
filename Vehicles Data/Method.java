import java.util.ArrayList;

public class Method<ElementType> extends ArrayList<ElementType> {
    public void quickSort(int iStart, int iEnd) {
        int iPivotIndex;
        if (iStart < iEnd) {
            /*
                select pivot and re-arrange elements in two partitions such as
                all array[start … p-1] are less than pivot = array [p] and
                all array[p+1 … end] are >= pivot
             */
            iPivotIndex = partition(iStart, iEnd);

            // sort first partition of the array (from start to pivot_index-1)
            quickSort(iStart, iPivotIndex - 1);

            //sort second partition of the array
            quickSort(iPivotIndex + 1, iEnd);
        } else // do nothing, the array has one element, so it is sorted
        {
            return;
        }
    }

    public int partition(int iStart, int iEnd) {
        int iUp, iDown;
        ElementType pivot;

        // select the first element as pivot
        pivot = get(iStart);

        // set the UP and DOWN indexes
        iUp = iStart;
        iDown = iEnd;

        // as long as UP and DOWN indexes did not pass each other
        while (iUp < iDown) {
            // increment UP index until found first element higher than pivot
            while (iUp < iEnd && ((Comparable) get(iUp)).compareTo((Comparable) pivot) <= 0) {
                iUp = iUp + 1;
            }

            // decrement DOWN until found first element smaller than  pivot
            while (iDown > iStart && (((Comparable) get(iDown)).compareTo((Comparable) pivot) > 0)) {
                iDown = iDown - 1;
            }

            // if UP and DOWN indexes did not pass each other
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
    public void simpleBubbleSort() {
        // write the simpleBubbleSort() method
        //it simply compares neighbours repeatedly until there are no more swaps
        boolean bMoreSwaps = true;

        while (bMoreSwaps == true) {
            int iCount;
            bMoreSwaps = false;
            for (iCount = 0; iCount < size() - 1; iCount++) {
                Comparable elementAtiCount = (Comparable) get(iCount);
                Comparable elementAtiCountPlus = (Comparable) get(iCount + 1);

                if (elementAtiCount.compareTo(elementAtiCountPlus) > 0) {
                    swap(iCount, iCount + 1);
                    bMoreSwaps = true;
                }
            }
        }
    }

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

}

