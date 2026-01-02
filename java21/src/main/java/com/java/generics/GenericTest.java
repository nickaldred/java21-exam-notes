package com.java.generics;

public class GenericTest<T, R> {
  private T test1;
  private R test2;

  public GenericTest(T test1, R test2) {
    this.test1 = test1;
    this.test2 = test2;
  }

  public T getTest1() {
    return test1;
  }

  public R getTest2() {
    return test2;
  }

  public void printTest2(T test1, R test2) {
    System.out.println("Test1:  %s --- Test2: %s".formatted(test1.toString(), test2.toString()));
  }

  public static <T> T testSameType(T test3) {
    System.out.println("Test3: %s".formatted(test3.toString()));
    return test3;
  }

  public <T> void testSameTypeInstance(T test4) {
    System.out.println("Test4: %s".formatted(test4.toString()));
  }

  public static void main(String[] args) {
    GenericTest<String, Integer> genericTest = new GenericTest<>("Hello", 123);

    genericTest.printTest2(genericTest.getTest1(), genericTest.getTest2());

    String test3Result = GenericTest.testSameType("Generic Method Test");
    System.out.println("Returned from testSameType: %s".formatted(test3Result));

    genericTest.testSameTypeInstance("nick");
  }

}
