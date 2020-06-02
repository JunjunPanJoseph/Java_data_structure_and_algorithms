package No02_Sort;


import java.util.Arrays;

import static java.lang.Math.min;

public class MergeSort implements Sort{
    private void merge(int[] array, int[] output, int beg, int mid, int end){
        int i = beg;
        int beg1 = beg;
        int beg2 = mid;
        while (i < end){
            if (beg1 < mid && beg2 < end){
                output[i++] = (array[beg1] < array[beg2])? array[beg1++]: array[beg2++];
            } else if (beg1 < mid){
                output[i++] = array[beg1++];
            } else {
                output[i++] = array[beg2++];
            }
        }
    }

    @Override
    public void sort(int[] array, int l, int r) {
        if (r - l < 16){
           insertSort(array, l, r);
            return;
        }
        int beg, end;
        beg = 0;
        int mergeSize = 16;
        while (beg + mergeSize < array.length){
            end = min(beg + mergeSize, array.length);
            insertSort(array, beg, end);
            beg = end;
        }
        int[] cache = new int[array.length];
        int[] currArray = array;
        int[] currOutput = cache;

        while (mergeSize < array.length){
            beg = 0;
            while (beg + mergeSize < array.length){
                end = min(beg + (mergeSize << 1), array.length);
                merge(currArray, currOutput, beg, beg+mergeSize, end);
                beg = end;
            }
            while (beg < array.length){
                currOutput[beg] = currArray[beg];
                beg++;
            }
            int [] temp = currArray;
            currArray = currOutput;
            currOutput = temp;
            // Ignore overflow case
            mergeSize = mergeSize << 1;
        }

        if (currArray != array){
            for (int i = l; i < r; i++){
                array[i] = currArray[i];
            }
        }
    }
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int [] test = {1,2,3};
        mergeSort.sort(test, 0, test.length);
        System.out.println(Arrays.toString(test));
    }
}
