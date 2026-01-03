package com.java.streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamNotes2 {

  public static void main(String[] args) {
    final StreamNotes2 test = new StreamNotes2();
    test.iterateTest();
  }

  public void iterateTest() {

    Stream<String> testStream = Stream.iterate("", x -> x + "Hi, ");
    testStream.peek(p -> System.out.print("peeking: %s -- ".formatted(p))).limit(6)
        .forEach(s -> System.out.println("For each: -- %s.".formatted(s)));

    System.out.println("\n-----------\n");

    Predicate<String> stopWhenLengthIs20 = s -> s.length() <= 100;
    Stream<String> testStream2 = Stream.iterate(" Starting String ", stopWhenLengthIs20,
        s -> s + " -- Adding length -- ");

    testStream2.forEach(System.out::println);
  }

}
