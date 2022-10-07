package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Summenformel
{
    public static void main(String[] args) {

        System.out.println("zahl eingeben");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<SumThread> sumThreads = new ArrayList<>();
        for (int i = 0; i < (n / 100)+1; i++) {
            if ((1 + i) * 100 > n) {
                SumThread sumThread = new SumThread(1 + (i * 100), n);
                sumThreads.add(sumThread);
            } else {
                SumThread sumThread = new SumThread(1 + (i * 100), 100 + (i * 100));
                sumThreads.add(sumThread);
            }
        }
        int finalSum = 0;
        for (int i = 0; i < sumThreads.size(); i++) {
            int temp = 0;
            try {
                temp = sumThreads.get(i).call();
                finalSum += temp;
                System.out.println(temp);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println(finalSum);
    }
}
