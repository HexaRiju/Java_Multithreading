package com.java.multiThreading;


class MyThread3 extends Thread{

    MyThread3(String name){
        super(name);
    }
    // the concept of User and the DAEMON threads.
    // user threads -- the work we are assigned and that work is we done using user threads
    // Daemon thread -- jvm do not care about this thread.This thread work in background
    // when ever all user thread done there job , jvm terminate the code , weather the Daemon thread is running or not running.
    @Override
    public void run() {
        //for(;;){
            try{
                Thread.sleep(1000);
                System.out.println("hiiiiii");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        //}
    }
}

public class ThreadMethodes2  {
    public static void main(String[] args) throws InterruptedException{
        MyThread3 t1 = new MyThread3("t1");
        t1.setDaemon(true);
        t1.start();
        //t1.join();
        System.out.println("Main is over");// when ever the main thread reach this statement and over jvm terminates
        //it's not wait for the Daemon thread to finish its job.
    }
}
