package com.java.annomousclasses;

import java.io.IOException;
import java.util.concurrent.Callable;

@FunctionalInterface
interface TestFuncInterface {
  public String apply(String s);
}

public class test {

  public static void main(String[] args) throws Exception {
    test1();
    test2();
    test3();

  }

  public static void test1() {
    TestFuncInterface test = new TestFuncInterface() {
      @Override
      public String apply(String s) {
        return s + " Hey, test 1";
      }
    };

    System.out.println(test.apply("nick"));

  }

  public static void test2() {
    Runnable runTest = new Runnable() {
      public void run() {
        System.out.println("Test run");
      }
    };
    runTest.run();
  }

  public static void test3() throws Exception {
    Callable<String> callTest = new Callable<String>() {
      public String call() throws IOException {
        return "Hey, this is a callable";
      }
    };

    Callable<String> callTest2 = () -> {
      return "Hey, this is a callable lambda";
    };

    System.out.println(callTest.call());
    System.out.println(callTest2.call());
  }

}
