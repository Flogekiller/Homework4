package com.company;

import java.util.concurrent.Callable;

public class SumThread  implements Callable<Integer>
{
    int min, max, sum;

    public SumThread(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer call() throws Exception {

        sum = 0;
        for (int i = min; i < max+1; i++) {
            sum+= i;
        }
        return sum;
    }

    public int getSum() {
        return sum;
    }
}
