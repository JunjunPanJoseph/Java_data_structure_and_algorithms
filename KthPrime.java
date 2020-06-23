import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class KthPrime {
    private BigInteger[] evidences;
    private BigInteger[][] evidencesPower;
    private BigInteger one_pos;
    private BigInteger one_neg;
    public KthPrime(){
        this.evidences = new BigInteger[3];
        this.evidences[0] = new BigInteger("2");
        this.evidences[1] = new BigInteger("7");
        this.evidences[2] = new BigInteger("61");
        this.one_pos = new BigInteger("1");
        this.one_neg = new BigInteger("-1");
        /*
        this.evidencesPower = new BigInteger[3][];
        for(int i = 0; i < 3; i++){
            this.evidencesPower[i] = new BigInteger[32];
            BigInteger tmp = new BigInteger("" + evidences[i]);
            for(int j = 0; j < 32; j++){
                this.evidencesPower[i][j] = tmp.pow(j);
            }
        }
         */
    }
    public boolean isPrime(int n){
        if (n == 2 || n == 3){
            return true;
        }
        if (n % 2 == 0){
            return false;
        }
        int s = 0;
        int d = n - 1;
        while ((d & 1) == 0){
            d = d >> 1;
            s++;
        }

        boolean retval = false;
        BigInteger bigN = new BigInteger("" + n);
        BigInteger bigNsub1 = new BigInteger("" + (n-1));
        for (BigInteger a: this.evidences){
            if(a.compareTo(bigN) != -1){
                break;
            }
            if (a.modPow(new BigInteger("" + d), bigN).equals(one_pos)){
                retval = true;
            }
            if (!retval) {
                for (int r = 0; r < s; r++) {
                    if (a.modPow(new BigInteger("" + (d << r)), bigN).equals(bigNsub1)) {
                        retval = true;
                        break;
                    }
                }
            }
            if (!retval){
                return false;
            } else {
                retval = false;
            }
        }
        return true;
    }
    public boolean isPrimeBF(int n){
        if (n == 2 || n == 3){
            return true;
        }
        for (int i = 2; i < (int) Math.sqrt(n)+1; i++){
            if (n % i == 0){
                return false;
            }
        }
        return  true;

    }
    private void test(int maxVal, boolean printkth){
        int k = 1;
        for (int i = 2; i < 2000; i++){
            boolean result = isPrime(i);
            boolean resultBF = isPrimeBF(i);
            if (result != resultBF){
                System.out.println("i = " + i + " BF = " + resultBF + " but result = " + result);
            } else if (result && printkth){
                System.out.println(i + " is " + k++ + " th prime");
            }
        }

    }
    private static class Pair{
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        int key;
        int value;
        public String toString(){
//            return  "key = " + key + " value = " + value;
            return  "" + value;
        }
    }
    public static void main(String[] args) {
        int qq = -1;
        Pair[] intputs = new Pair[10];
        int[] kth = new int[10];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            String currLine = scanner.nextLine();
            if (currLine.charAt(0) == 'q') {
                qq = i;
                currLine = currLine.substring(9);
            }
            intputs[i] = new Pair(i, Integer.parseInt(currLine));
        }
        //System.out.println(Arrays.toString(intputs));
        Arrays.sort(intputs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.value == o2.value){
                    return 0;
                } else if (o1.value < o2.value){
                    return -1;
                } else {
                    return  1;
                }
            }
        });
        //System.out.println(Arrays.toString(intputs));
        int isKthPrime = 0;
        int i = 0;
        int n = 2;
        KthPrime kthPrime = new KthPrime();
        while (isKthPrime < intputs[9].value){
            boolean isPrime = kthPrime.isPrime(n);
            if (isPrime){
                isKthPrime ++;
                if (isKthPrime == intputs[i].value){
                    kth[intputs[i].key] = n;
                    i++;
                }
            }
            n++;
        }
        for (int j = 0; j < 10; j++){
            if (j == qq){
                System.out.println("qq_group:" + kth[j]);
            } else {
                System.out.println(kth[j]);
            }
        }

        return;
    }
}
