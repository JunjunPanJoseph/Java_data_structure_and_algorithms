package No03_kth_Smallest;

import java.util.Arrays;

public class KthSmallest {
    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public int kthSmallest(int[] array, int k){
           return kthSmallest(array, k, 0, array.length);
    }
    public int kthSmallest(int[] array, int k, int l, int r){
        //Assume l <= k < r
        if (r - l <= 1){
            return array[l + k - 1];
        }
        swap(array, l, l + k - 1);
        int i = l + 1;
        int j = r - 1;
        while (j >= i){
            if (array[j] < array[l]){
                swap(array, j, i);
                i++;
            } else {
                j--;
            }
        }
        swap(array, l, i - 1);
        //System.out.println("i - 1 = " + (i-1) +" l = "+ l + " r = " + r + " k = " + k);
        //System.out.println(Arrays.toString(array));
        if (i - 1 == k + l - 1){
            return array[k + l - 1];
        } else if (i - 1 > k + l - 1){
            return kthSmallest(array, k, l, i - 1);
        } else {
            return kthSmallest(array, k + l - i, i, r);
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 1, 5 };
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(array, 4));

    }
}
