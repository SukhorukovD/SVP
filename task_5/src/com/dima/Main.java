package com.dima;

import collections.ResourcePool;
import stubClasses.Math;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.lang.String.format;

public class Main {


    private static final int Count = 500;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ResourcePool rp = new ResourcePool(16);

        long beginTime = System.nanoTime();

        List<Future<Double>> tasks = new ArrayList<>();

        for (int i = 0; i < Count; i++) {
            final int j = i;
            tasks.add(
                    CompletableFuture.supplyAsync(() -> Math.getModRow(j), rp));
        }

        double value = 0;
        for (Future<Double> future : tasks) {
            value += future.get();
        }

        System.out.println("Value: " + value + "\n");
        System.out.println("Taken time: " + (System.nanoTime() - beginTime) / (1000_000) + " ms." + "\n");

        rp.stop();
    }
}