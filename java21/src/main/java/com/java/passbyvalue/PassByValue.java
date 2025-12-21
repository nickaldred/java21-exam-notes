package com.java.passbyvalue;

public class PassByValue {

  public class testObject {
    int data;

    testObject(int data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    int num = 10;
    System.out.println("Before method call: " + num);
    modifyValue(num);
    System.out.println("After method call: " + num);

    System.out.println();

    String text = "Hello";
    System.out.println("Before method call: " + text);
    modifyValue(text);
    System.out.println("After method call: " + text);

    System.out.println();

    testObject obj = new PassByValue().new testObject(30);
    System.out.println("Before method call: " + obj.data);
    modifyValue(obj);
    System.out.println("After method call: " + obj.data);

    System.out.println();

  }

  public static void modifyValue(int value) {
    value = 20;
    System.out.println("Inside method: " + value);
  }

  public static void modifyValue(String str) {
    str = "World";
    System.out.println("Inside method: " + str);
  }

  public static void modifyValue(testObject to) {
    to.data = 40;
    System.out.println("Inside method: " + to.data);
  }

}
