package No02_Sort;


import java.util.Arrays;
public class QuickSort implements Sort{
    public void sort(int[] array, int l, int r) {
        if (r - l <= 1){
            return;
        }
        if(r - l <= 16){
            insertSort(array, l, r);
        } else {
            int pivotIndex = l;
            int beg = l + 1;
            int end = r - 1;
            while (end >= beg){
                if (array[end] < array[pivotIndex]){
                    swap(array, end, beg);
                    beg++;
                } else {
                    end--;
                }
            }
            swap(array, beg - 1, l);
            sort(array, l, beg-1);
            sort(array, beg, r);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int [] test = {5, 4, 3, 2, 1};
        quickSort.sort(test, 0, test.length);
        System.out.println(Arrays.toString(test));
    }

}
