package com.java.multiThreading;

@FunctionalInterface
interface Hello{
    String Name(String name);
}

@FunctionalInterface
interface Action{
    int done(int n);
}

public class LambdaExpression {
    public static void main(String[] args) {
        String n = "Debojyoti";
        Hello hello = (name) -> name + " Engineering Student";
        LambdaExpression lambdaExpression = new LambdaExpression();

        lambdaExpression.Number(3);
        lambdaExpression.Info(12,hello.Name(n));

        //=====================================================
        // not using lambda function
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("go");
            }
        };
        Thread t1 = new Thread(runnable);
        // using lambda function
        Runnable runnable1 = () -> System.out.println("hello");// for single statement no need of brackets
        Thread t2 = new Thread(runnable1);
        // more easy and sort way
        Thread t3 = new Thread(() -> System.out.println("hi"));
        //() -> System.out.println("hi") Lambda function
     //=============================================================

    }

    //====================================================================
    public void Info(int roll_no , String info){
        System.out.println("student info is " + info + " his/her roll no is " + roll_no);
    }// multipal statement


    public void Number(int n){
        Action action = (num) ->{
            int fac = 1;
            for(int i = 1 ; i <= num ; i++){
                fac *=i;
            }
            return fac;
        };
        System.out.println("the factorial of the number " + n +" -- " + action.done(n));
    }
}
