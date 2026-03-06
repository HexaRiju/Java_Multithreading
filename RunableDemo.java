package com.java.multiThreading;

public class RunableDemo implements Runnable{
    @Override
    public void run() {
        for(;;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
