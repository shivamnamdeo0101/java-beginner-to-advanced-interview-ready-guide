package com.shivam.java_9_multithreading;

import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i <= 100000; i++) {
                final int j = i;
                executor.submit(() -> {
                    System.out.println("thread:" + j);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }
    }
}
