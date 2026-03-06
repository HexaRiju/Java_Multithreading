package com.java.multiThreading;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessExample {


    private final Lock unfarelock = new ReentrantLock(true);

    public void Resource(){
        unfarelock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired lock");
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.println(e);
            Thread.currentThread().interrupt();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " release the lock");
            unfarelock.unlock();
        }
    }


    public static void main(String[] args) {
        FairnessExample fairnessExample = new FairnessExample();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 10 ; i++){
                    fairnessExample.Resource();
                }
            }
        };
        Thread t1 = new Thread(runnable ,"Thread1");
        Thread t2 = new Thread(runnable ,"Thread2");
        Thread t3 = new Thread(runnable ,"Thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
