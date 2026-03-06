package com.java.multiThreading;

import java.util.Scanner;

// concept of lock , <two class included BankAccount1 and BankAccountMain >
public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount1 bankAccount1 = new BankAccount1();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the amount = ");
        int amount = sc.nextInt();
        // we are using AnonimasClass here , we do a sortcut rather than implementing an another class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bankAccount1.Withdraw(amount);
            }
        };
        Thread t1 = new Thread(runnable,"Person1");
        Thread t2 = new Thread(runnable,"Person2");
        t1.start();
        t2.start();
    }
}
