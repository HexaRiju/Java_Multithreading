package com.java.multiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount1 {
    private int bank_balance = 1000;

    private final Lock lock = new ReentrantLock();// this ReentrantLock is a class which is implementing the Lock interface

    public  void Withdraw (int amount){
        System.out.println(Thread.currentThread().getName() + " is trying to take the lock");
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                try{
                    if(bank_balance >= amount) {
                        System.out.println(Thread.currentThread().getName() + "the payment is in progress .....");
                        Thread.sleep(3000);
                        System.out.println("payment of " + amount + " Rs " + " is successful");
                        bank_balance -= amount;
                        System.out.println("your current bank balance is  --" + bank_balance);
                        }
                    else {
                        System.out.println(Thread.currentThread().getName() + "insufficient balance");
                    }
                }
                catch (InterruptedException e){
                    System.out.println(e);
                    Thread.currentThread().interrupt();// this is a good practice nothing else
                    // u are just storing that if any interrupt come it will store that state
                    // such that , is any maintanence code is there will run
                }
                finally {
                    lock.unlock();
                }
            }
            else{
                System.out.println(Thread.currentThread().getName() + " not able to get the lock");
            }
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        if(Thread.currentThread().isInterrupted()){// maintanence code
            System.out.println(" ....");
        }
    }

}
