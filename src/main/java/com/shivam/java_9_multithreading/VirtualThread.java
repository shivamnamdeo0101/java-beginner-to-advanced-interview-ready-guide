package com.shivam.java_9_multithreading;

public class VirtualThread {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            final int j = i;
            Thread.ofVirtual().start(() -> {
                // Optional: print only for every 1000th thread
                System.out.println("Thread: " + j);
                try {
                    Thread.sleep(5000); // simulate work
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}

