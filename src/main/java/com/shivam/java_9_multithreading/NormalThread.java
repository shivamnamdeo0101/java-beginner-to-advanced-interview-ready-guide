package com.shivam.java_9_multithreading;

public class NormalThread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            final int j = i;
            var t = new Thread(()-> {
                System.out.println("thread:" + j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
    }
}
