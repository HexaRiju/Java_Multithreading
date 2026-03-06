package com.java.multiThreading;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for(;;){
            System.out.println("Thread 1");
        }
    }
}
