package com.java.labledstatements;

public class LabledStatements {
  public static void main(String[] args) {
    breakTest();
    continueTest();
  }

  public static void breakTest() {
    // Using labeled statements with nested loops
    outerLoop: for (int i = 1; i <= 3; i++) {
      innerLoop: for (int j = 1; j <= 3; j++) {
        if (i == 2 && j == 2) {
          System.out.println("Breaking out of outer loop when i=2 and j=2");
          break outerLoop; // Breaks out of the outer loop
        }
        System.out.println("i: " + i + ", j: " + j);
      }
    }

    System.out.println("Exited the loops.");
  }

  public static void continueTest() {
    System.out.println();
    int x = 0;
    LOOP1: while (x <= 5) {
      System.out.println("x: " + x);
      ++x;

      LOOP3: for (int i = 0; i <= 5; i++) {
        System.out.println("i: " + i);
        continue LOOP1;
      }
    }
  }

}
