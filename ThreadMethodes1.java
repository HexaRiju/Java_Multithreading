package com.java.multiThreading;

class MyThread2 extends Thread{

    MyThread2(String name){
        super(name);
    }
    @Override
    public void run() {
        for(int i = 0; i <10; i++){
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                System.out.println("interrupt" + e);
            }
            System.out.println(getName() + " -- hi");
            Thread.yield();// it is giving the hit to the JVM that give each thread chance to execute.
        }

    }
}
public class ThreadMethodes1 {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("t1");
        MyThread2 t2 = new MyThread2("t2");
        MyThread2 t3 = new MyThread2("t3");
        t1.start();
        t2.start();
        t3.start();
        // if you remove the comment of the t1.interrupt then the following will happen
        //t1.interrupt();
        // here it will give Interrupt exception,as thread is interrupt
        // it is telling that whatever you are doing sotp there , <like the thread is sleeping , waiting anything stop there>

        System.out.println("main over");
    }
}
