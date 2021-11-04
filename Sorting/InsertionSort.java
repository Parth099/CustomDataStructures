package Sorting;

import java.util.Arrays;

public class InsertionSort {
    private static <T> void swap(T[] Table, int i, int j){
        T temp = Table[i];
        Table[i] = Table[j];
        Table[j] = temp;
    }

    public static <T extends Comparable> void InsertionSort(T[] table){
        for(int pos = 1; pos < table.length; pos++){
            //invariant :: table[0:pos] is sorted with respect to its elements index 0 to pos at iteration point POS
            int BKcounter = pos;
            while(BKcounter > 0){ //avoids table[-1] call
                //LIVEFEED, sees new number and brings it to the right spot using a localized bubble sort
                if(table[BKcounter - 1].compareTo(table[BKcounter]) > 0){
                    swap(table, BKcounter-1, BKcounter);
                }
                BKcounter--;
            }
        }
    }
    /*
        Analysis:
            runtime: T(n) = 1 + 2 + .... + n - 2 + n - 1 --> T(n) in O(n^2)
            Regardless of sorted degree; IS will run at nearly the same speed
     */
    public static void main(String[] args) {
        Integer[] I = {1, 2, 3, 4, 5, -1, -2, -3};
        InsertionSort(I);
        System.out.println(Arrays.asList(I));
    }
}
