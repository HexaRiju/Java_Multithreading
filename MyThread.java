package com.java.multiThreading;
// thread lifecycle code example
public class MyThread extends Thread {

    @Override
    public void run() {
       try{
           System.out.println("RUNNING");
           Thread.sleep(1000);
       }
       catch (Exception e){
           System.out.println(e);
       }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());// out put is NEW

        t1.start();
        System.out.println(t1.getState());// Runnable state
        try {
            Thread.sleep(100);
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(t1.getState());//TIMED_WAITING
        try{
            t1.join();
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(t1.getState());//TERMINATED

    }
}
