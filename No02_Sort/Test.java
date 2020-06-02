package No02_Sort;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
public class Test {
    private static void testSorting(Sort sort){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            int[] array1 = random.ints(i).toArray();
            int[] array2 = Arrays.copyOf(array1, i);
            Arrays.sort(array1);
            sort.sort(array2);
            boolean result = Arrays.equals(array1, array2);
            if (!result){
                System.out.println("Output: " + Arrays.toString(array2));
                System.out.println("Expected: " + Arrays.toString(array1));
            }

        }
    }
    public static void main(String[] args) {
        //Test: quick sort
        testSorting(new QuickSort());
        //Test: merge sort
        testSorting(new MergeSort());

        System.out.println("Congratulation! you pass the test!");
    }
}
