package com.java.multiThreading;


class Mythread1 extends Thread{
    public Mythread1 (String name){
        super(name);// giving name to the thread
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 5 ; i++){
            try{
                Thread.sleep(1000);// sleep methode
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println(getName()+" Priority "+ getPriority() + " - " +i);
        }
    }
}




public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        Mythread1 t1 = new Mythread1("HIGH");
        Mythread1 t2 = new Mythread1("NORM");
        Mythread1 t3 = new Mythread1("MIN");
        // set the priority
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t1.join();// this methode told that after the thread t1 done only then the main thread will run;
        t2.join();
        t3.join();
        // mean the next instruction will run

        System.out.println("main done");
    }
}
