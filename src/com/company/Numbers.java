package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.IntPredicate;

public class Numbers
{
    public List<Integer> zahlenList;

    public Numbers() {
        this.zahlenList = new ArrayList<>();
    }


    public List<Integer> csvInList(String file)
    {

        List<String> tempList = new ArrayList<>();
        List<Integer> intTempList = new ArrayList<>();
        try {
            Files.lines(Path.of(file)).forEach(tempList::add);
            for (int i = 0; i < tempList.size(); i++) {
                String[] splitt = tempList.get(i).split(":");
                for (int j = 0; j < splitt.length; j++) {
                    if(!splitt[j].equals("") && splitt[j].matches("[+-]?\\d*(\\.\\d+)?"))
                    {
                        intTempList.add(Integer.parseInt(splitt[j]));
                    }
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        zahlenList = intTempList;
        return intTempList;
    }
    public void div()
    {
        List<Divisible> divisible = new ArrayList<>();
        System.out.println("Bitte Zahl eingeben");
        Scanner scanner = new Scanner(System.in);
        int teiler = scanner.nextInt();
        System.out.println("Chunk eingeben");
        int chunk = scanner.nextInt();

        for (int i = 0; i < (zahlenList.size()/chunk)+1; i++) {
            divisible.add(new Divisible(chunk *i, chunk +(chunk*i) , teiler, zahlenList));
        }

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 0; i < (zahlenList.size()/100); i++) {
           executor.execute(divisible.get(i));
        }
        executor.shutdown();

    }

}
