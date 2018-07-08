package com.damianck.pl.lambda.example_2;

public class RunnableLambda {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread => " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread firstThread = new Thread(runnable);
        Thread secondThread = new Thread(runnable);

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
