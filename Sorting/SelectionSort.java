package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static <T extends Comparable> void sortSS(T[] table) {
        int len = table.length;
        for(int currPos = 0; currPos < len - 1; currPos++){
            int localMin = currPos;
            for (int i = currPos + 1; i < len; i++) {
                if(table[localMin].compareTo(table[i]) > 0){
                    localMin = i;
                }
            }
            T temp = table[localMin];
            table[localMin] = table[currPos];
            table[currPos] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] I = {1, 2, 3, 4, 5, -1};
        sortSS(I);
        System.out.println(Arrays.asList(I));
    }
}