package com.java.multiThreading;

import java.util.concurrent.*;
// when ever i want to wait multipal thread use  CountDownLatch.
class DepandentServer1 implements Callable<String>{

    private final CountDownLatch latch;

    DepandentServer1(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }
        finally {
            latch.countDown();
        }
        return "ok";
    }
}

public class ExecuteExample1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        ExecutorService executeFramework = Executors.newFixedThreadPool(numberOfServices);
        Future<String> future1 = executeFramework.submit(new DepandentServer1(latch));
        Future<String> future2 = executeFramework.submit(new DepandentServer1(latch));
        Future<String> future3 = executeFramework.submit(new DepandentServer1(latch));

//==============================================================================
        // now we do not do this too mach things
        // here them main thread is waiting for the threads to complete it's service ,
        // but we can do it very smart and easy way using countDownLatch
//        future1.get();
//        future2.get();
//        future3.get();
//==============================================================================
        latch.await();
        System.out.println("All the depandent services are finished and now main service is starting");
        executeFramework.shutdown();
    }
}
//=============================================
//lecture no 17 some extra point
//=============================================


