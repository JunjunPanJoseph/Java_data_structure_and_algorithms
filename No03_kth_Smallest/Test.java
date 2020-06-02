package No03_kth_Smallest;



import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        Random random = new Random();
        for(int i = 2; i < 100; i++){
            int[] array1 = random.ints(i).toArray();
            int[] array2 = Arrays.copyOf(array1, i);
            Arrays.sort(array1);
            int k = random.nextInt(i - 1) + 1;
            int out = kthSmallest.kthSmallest(array2, k);
            boolean result = array1[k-1] == out;
            if (!result){
                System.out.println("Output: " + out);
                System.out.println("Expected: " + array1[k]);
            }
        }
    }
}
