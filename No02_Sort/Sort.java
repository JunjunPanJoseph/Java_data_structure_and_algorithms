package No02_Sort;

public interface Sort {
    default public void swap(int[] array, int l, int r){
        if (l == r){
            return;
        }
        int t = array[l];
        array[l] = array[r];
        array[r] = t;
    }
    default public void sort(int[] array){
        sort(array, 0, array.length);
    }
    default public void insertSort(int[] array){
        insertSort(array, 0, array.length);
    }
    default public void insertSort(int[] array, int l, int r){
        if (r - l <= 1){
            return;
        }
        for(int i = l + 1; i < r; i++){
            int j = i;
            while (j > l){
                if (array[j - 1] <= array[j]){
                    break;
                } else {
                    swap(array, j, j - 1);
                    j--;
                }
            }
        }
    }
    abstract public void sort(int[] array, int l, int r);
}
