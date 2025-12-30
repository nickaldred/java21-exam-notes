package com.java.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threads {

  Runnable taskVirtual = () -> {
    System.out.println("Hello from Virtual Thread!");
  };

  Runnable taskPlatform = () -> {
    System.out.println("Hello from Platform Thread!");
  };

  Runnable taskPrintRecords = () -> {
    for (int i = 1; i <= 5; i++) {
      System.out.println("Record " + i + " processed by " + Thread.currentThread().threadId());
    }
  };

  Callable<String> taskCallable = () -> {
    return "Result from Callable executed by " + Thread.currentThread().threadId();
  };

  public void startVirtualThread() throws InterruptedException {
    Thread.Builder virtualThreadBuilder = Thread.ofVirtual();
    Thread virtualThread = virtualThreadBuilder
        .name("Virtual-Thread-1")
        .unstarted(() -> taskVirtual.run());
    virtualThread.start();

    virtualThread.join();
  }

  public void startPlatformThread() throws InterruptedException {
    Thread.Builder platformThreadBuilder = Thread.ofPlatform();
    Thread platformThread = platformThreadBuilder
        .name("Platform-Thread-1")
        .unstarted(() -> taskPlatform.run());
    platformThread.start();

    platformThread.join();
  }

  public void startVirtualThreadWithExecutorService() throws InterruptedException {
    try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
      executorService.execute(taskVirtual);
      executorService.submit(taskVirtual).get();
      executorService.submit(taskPrintRecords).get();
      String result = executorService.submit(taskCallable).get();
      System.out.println("Callable Result: " + result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void startPlatformThreadWithExecutorService() throws InterruptedException {
    try (ExecutorService executorService = Executors.newFixedThreadPool(20, Thread.ofPlatform().factory())) {
      executorService.execute(taskPlatform);
      executorService.submit(taskPlatform).get();
      executorService.submit(taskPrintRecords).get();
      String result = executorService.submit(taskCallable).get();
      System.out.println("Callable Result: " + result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws InterruptedException {

    Threads threads = new Threads();
    threads.startVirtualThread();
    threads.startPlatformThread();

    threads.startVirtualThreadWithExecutorService();

    threads.startPlatformThreadWithExecutorService();
  }

}
