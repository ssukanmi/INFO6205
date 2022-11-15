package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_Client {

    public static int count(int n) {
        UF_HWQUPC uf = new UF_HWQUPC(n);
        Random r = new Random();
        int connections = 0;

        while(uf.components() != 1) {
            int n1 = r.nextInt(n);
            int n2 = r.nextInt(n);
            connections++;
            if (!uf.connected(n1, n2)) {
                uf.union(n1, n2);
            }
        }

        return connections;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print("Enter n: ");
            n = sc.nextInt();
            if(n == -1)
                break;
            int totalCons = 0;
            for (int i = 0; i < 10000; i++) {
                totalCons += count(n);
            }
            System.out.println("Number of connections for " + n + " is " + totalCons/10000);
        }
    }
}
