package com.java.threads;

public class LockTest {

  private static int lockVar = 0;

  public static void main(String[] args) {
    LockTest lockTest = new LockTest();
    lockTest.executorServiceLock();

    System.out.println("---------------------");

    lockTest.testSynchronizedMethod();

    System.out.println("---------------------");

    lockTest.testLockOnObject();

    System.out.println("---------------------");
    lockTest.tryLockExample();
  }

  public void executorServiceLock() {
    try (var executorService = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
      var lock = new java.util.concurrent.locks.ReentrantLock();

      Runnable taskWithLock = () -> {
        lock.lock();
        try {
          System.out.println("Task with Lock executed by " + Thread.currentThread().threadId());
        } finally {
          lock.unlock();
        }
      };

      for (int i = 0; i < 5; i++) {
        executorService.submit(taskWithLock);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public synchronized void synchronizedMethod() {
    lockVar++;
    System.out
        .println("Synchronized Method executed by " + Thread.currentThread().threadId() + ", lockVar: " + lockVar);
  }

  public void testSynchronizedMethod() {
    try (var executorService = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {

      for (int i = 0; i < 5; i++) {
        executorService.submit(this::synchronizedMethod);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void testLockOnObject() {
    Object lockObject = new Object();

    Runnable taskWithObjectLock = () -> {
      synchronized (lockObject) {
        lockVar++;
        System.out.println(
            "Task with Object Lock executed by " + Thread.currentThread().threadId() + ", lockVar: " + lockVar);
      }
    };

    try (var executorService = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {

      for (int i = 0; i < 5; i++) {
        executorService.submit(taskWithObjectLock);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void tryLockExample() {
    java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();

    Runnable taskWithTryLock = () -> {
      if (lock.tryLock()) {
        try {
          System.out.println("Task with TryLock executed by " + Thread.currentThread().threadId());
        } finally {
          lock.unlock();
        }
      } else {
        System.out.println("Task could not acquire lock: " + Thread.currentThread().threadId());
      }
    };

    try (var executorService = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {

      for (int i = 0; i < 5; i++) {
        executorService.submit(taskWithTryLock);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
