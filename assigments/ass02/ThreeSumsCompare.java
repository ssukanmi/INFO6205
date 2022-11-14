package edu.neu.coe.info6205.threesum;

import java.util.Arrays;
import java.util.Random;
import edu.neu.coe.info6205.util.Stopwatch;

public class ThreeSumsCompare {
    public static int[] generateArr(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] myArr1 = generateArr(500);
        int[] myArr2 = generateArr(1000);
        int[] myArr3 = generateArr(2000);
        int[] myArr4 = generateArr(4000);
        int[] myArr5 = generateArr(8000);

        int[][] myArrays = new int[][] {myArr1, myArr2, myArr3, myArr4, myArr5};
        int n = 500;
        System.out.println("Testing for Cubic!!!");
        for (int[] myArray: myArrays) {
            try (Stopwatch watch = new Stopwatch()) {
                Arrays.sort(myArray);
                ThreeSumCubic target = new ThreeSumCubic(myArray);
                target.getTriples();
                long time = watch.lap();
                System.out.print("N: " + n + "\t");
                System.out.println("Time taken:"+time+"ms");
            }
            n *= 2;
        }
        System.out.println();

        n = 500;
        System.out.println("Testing for Quadratic!!!");
        for (int[] myArray: myArrays) {
            try (Stopwatch watch = new Stopwatch()) {
                Arrays.sort(myArray);
                ThreeSumQuadratic target = new ThreeSumQuadratic(myArray);
                target.getTriples();
                long time = watch.lap();
                System.out.print("N: " + n + "\t");
                System.out.println("Time taken:"+time+"ms");
            }
            n *= 2;
        }
        System.out.println();

        n = 500;
        System.out.println("Testing for QuadraticWithCalipers!!!");
        for (int[] myArray: myArrays) {
            try (Stopwatch watch = new Stopwatch()) {
                Arrays.sort(myArray);
                ThreeSumQuadraticWithCalipers target = new ThreeSumQuadraticWithCalipers(myArray);
                target.getTriples();
                long time = watch.lap();
                System.out.print("N: " + n + "\t");
                System.out.println("Time taken:"+time+"ms");
            }
            n *= 2;
        }
        System.out.println();

        n = 500;
        System.out.println("Testing for Quadrithmic!!!");
        for (int[] myArray: myArrays) {
            try (Stopwatch watch = new Stopwatch()) {
                Arrays.sort(myArray);
                ThreeSumQuadrithmic target = new ThreeSumQuadrithmic(myArray);
                Triple[] triples = target.getTriples();
                long time = watch.lap();
                System.out.print("N: " + n + "\t");
                System.out.println("Time taken:"+time+"ms");
            }
            n *= 2;
        }

        System.out.println("done!!!");
    }
}
