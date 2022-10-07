package com.company;

import java.util.ArrayList;
import java.util.List;

public class Divisible implements Runnable
{
    int min, max, div;
    List<Integer> numberList;

    public Divisible(int min, int max, int div, List<Integer> numberList) {
        this.min = min;
        this.max = max;
        this.div = div;
        this.numberList = numberList;
    }

    @Override
    public void run() {
        if(max >= numberList.size())
        {
            max = numberList.size()-1;
        }
        for (int i = min; i < max; i++) {
            if(numberList.get(i)%div == 0&& max < numberList.size())
            {
                System.out.println(numberList.get(i));
            }
        }
    }
}
