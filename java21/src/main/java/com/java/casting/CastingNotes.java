package com.java.casting;

public class CastingNotes {

  public static void main(String[] args) {
    intTest();
  }

  public static void intTest() {

    int testInt = 5;

    Integer testInteger = testInt;
    System.out.println(testInteger);
    Long testLong = testInteger.longValue();
    Long testLong2 = (long) testInt;
    System.out.println(testLong);
    double testDouble = testInt;
    float testFloat = testInt;
    System.out.println(testDouble);
    System.out.println(testFloat);
  }

  public static void byteTest() {
    byte testByte = 100;
    Byte testByteObject = testByte;
    Short testShortObject = (short) testByte;
    autoBoxTest((short) testByte);
  }

  private static void autoBoxTest(Short testShort) {
    System.out.println(testShort);
  }

  public static void doubleTest() {
    double testDouble = 1.0;
    Double testDoubleObject = testDouble;

    Float testFloatObject = testDoubleObject.floatValue();
    float testFloat = (float) testDouble;

    long testLong = (long) testDouble;
  }

  public static void floatTest() {
    float testFloat = 1.034f;
    Float testFloatObject = testFloat;

    double testDouble = testFloat;
    Double testDoubleObject = (double) testFloat;

    int testInt = (int) testFloat;
  }

  public static void longTest() {
    long longTest = 2L;
    Long longObjectTest = longTest;

    double testDouble = longTest;
    float testFloat = longTest;

  }

  public static void booleanTest() {
    boolean testBoolean = false;
    Boolean testBooleanObject = testBoolean;
    boolean testBoolean2 = testBooleanObject;
  }

}
