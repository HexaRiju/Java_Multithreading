package com.java.multiThreading;

public class Main {
    public static void main(String[] args) {
//        ThreadDemo t1 = new ThreadDemo();
//        t1.start();
        RunableDemo run = new RunableDemo();
        Thread t1 = new Thread(run);
        t1.start();
        for(;;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
