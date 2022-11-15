package edu.neu.coe.info6205.util;

import java.util.Random;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

public class BenchmarkCompare {
    public static void main(String[] args) {
        for(int n = 2000; n <= 32000; n *= 2) {
            System.out.println("__________________________________");
            System.out.println("n: " + n);

            InsertionSort is = new InsertionSort();
            Random r = new Random();

            // Generating the arrays
            // Random
            Integer[] ranArr = new Integer[n];
            for (int i = 0; i < ranArr.length; i++) {
                ranArr[i] = r.nextInt();
            }

            // Arranged
            Integer[] arrArr = new Integer[n];
            for (int i = 0; i < arrArr.length; i++) {
                arrArr[i] = i + 1;
            }

            // Reverse
            Integer[] revArr = new Integer[n];
            for (int i = 0; i < revArr.length; i++) {
                revArr[i] = i * -1;
            }

            // Partial
            Integer[] parArr = new Integer[n];
            for (int i = 0; i < n; i++) {
                if (i < n/2) {
                    parArr[i] = i + 1;
                } else {
                    parArr[i] = r.nextInt();
                }
            }

            // Benchmarking
            // Random
            Benchmark<Boolean> bRan = new Benchmark_Timer<>(
                    "random sort", b -> {
                is.sort(ranArr.clone(), 0, ranArr.length);

            });
            double xRan = bRan.run(true, 10);

            //arranged
            Benchmark<Boolean> bArr = new Benchmark_Timer<>(
                    "arranged sort", b -> {
                is.sort(arrArr.clone(), 0, arrArr.length); ;

            });
            double xArr = bArr.run(true,  10);

            //reverse
            Benchmark<Boolean> bRev = new Benchmark_Timer<>(
                    "reverse sort", b -> {
                is.sort(revArr.clone(), 0, revArr.length);

            });
            double xRev = bRev.run(true, 10);

            //partial
            Benchmark<Boolean> bPar = new Benchmark_Timer<>(
                    "partial sort", b -> {
                is.sort(parArr.clone(), 0, parArr.length);

            });
            double xPar = bPar.run(true, 10);

            System.out.println("Random: " + xRan);
            System.out.println("Arranged: " + xArr);
            System.out.println("Reverse: " + xRev);
            System.out.println("Partial: " + xPar);
        }
    }
}
