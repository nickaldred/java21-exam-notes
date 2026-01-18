package com.java.streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamQuestionNotes {

  public static void main(String[] args) {
    question3();
  }

  public static void question3() {
    Predicate<String> predicate = s -> s.length() > 3;
    var stream = Stream.iterate("-",
        s -> !s.isEmpty(), (s) -> s + s);
    var b1 = stream.noneMatch(predicate);
    var b2 = stream.anyMatch(predicate);
    System.out.println(b1 + " " + b2);
  }

  public static void question10() {
    Stream.generate(() -> "1")
        .limit(10)
        .forEach(System.out::println);
  }

}
