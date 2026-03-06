package com.java.multiThreading;


class Counter {
    private int count;

    public Counter(int count) {
        this.count = count;
    }

    public synchronized void increment () {// if you remove the synchronized keyword , race condition will occur
        // and out put depends on the sequence at which the threads are accessing this critical section of this code.
       count++;
    }

    public int getCount() {
        return count;
    }
}

class MyThread4 extends Thread{
    private Counter counter;
    MyThread4(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 1000 ; i++){
           counter.increment();
        }
    }
}


public class Synchronisation {
    public static void main(String[] args) {
        Counter counter = new Counter(0);
        MyThread4 t1 = new MyThread4(counter);
        MyThread4 t2 = new MyThread4(counter);
        t1.start();
        t2.start();
        // this thing done because we want first the two thread done there job then only the last statement print.
        try{
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(counter.getCount());
    }
}
