package com.java.multiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLookExample {
    final Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        ReentrantLookExample reentrantLookExample = new ReentrantLookExample();
        reentrantLookExample.OuterLock();
    }

    void OuterLock(){
        lock.lock();
        try{
            System.out.println("OuterLock");
            InnerLock();
        }
        finally {
            lock.unlock();
        }
    }
    void InnerLock(){
        lock.lock();
        try{
            System.out.println("InnerLock");
        }
        finally {
            lock.unlock();
        }
    }
}
// here basically you think that deadlock will occure , and you are right
// but to handle this in jvm , it maintains a counter of lock , mean each pair of lock have their unlock methode
// what is happening here, same thread (here the main thread) holding both the lock so the inner methode can take the lock
// there are two lock so the counter will also be 2
// when unlock happen the counter will dicrement to 0.
//<for total colncept watch lec no.8>