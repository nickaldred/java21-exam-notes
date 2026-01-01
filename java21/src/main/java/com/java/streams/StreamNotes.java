package com.java.streams;

import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamNotes {

  public static void main(String[] args) {
    // concatTest();
    // findTest();
    // forEachTest();
    // anyMatchTest();
    // filterTest();
    // reduceTest();
    // parallelReduceTest();
    // intStreamTest();
    // spliteratorTest();
    // collectTest();
    // partitionByTest();
    flatMapTest();

  }

  public static void reduceTest() {
    final List<Integer> testList1 = List.of(1, 2, 3, 4, 5);
    final Stream<Integer> testStream1 = testList1.stream();

    int result = testStream1.reduce(0, (s, e) -> s + e);

    System.out.println("reduce test 1, result is: " + result);
  }

  public static void parallelReduceTest() {
    final List<Integer> testList1 = List.of(1, 2, 3, 4, 5);
    final Stream<Integer> testStream1 = testList1.parallelStream();

    int result = testStream1.reduce(0, (s, e) -> s + e, (s, e) -> s + e);
    System.out.println("parallel reduce test 2, result is: " + result);

    final List<String> testList2 = List.of("a", "b", "c", "d", "e", "f", "g");
    final Stream<String> testStream2 = testList2.parallelStream();

    String result2 = testStream2.reduce("", (s, e) -> s + e);
    System.out.println("parallel reduce test 3, result is: " + result2);

  }

  public static void concatTest() {
    final List<Integer> testList1 = List.of(1, 2, 3, 4, 5);
    final Stream<Integer> testStream1 = testList1.stream();
    final List<Integer> testList2 = List.of(1, 2, 3, 4, 5);
    final Stream<Integer> testStream2 = testList2.stream();

    final Stream<Integer> concattedStream = Stream.concat(testStream1, testStream2);

    concattedStream.forEach(s -> System.out.print(s));
    System.out.println();
  }

  public static void findTest() {
    final List<Integer> testList = List.of(1, 2, 3, 4, 5);
    final Stream<Integer> testStream = testList.stream();

    // System.out.println(testStream.findFirst());
    System.out.print(testStream.findAny());
    System.out.println();

  }

  public static void forEachTest() {

    final List<Integer> testList = List.of(1, 2, 3, 4, 5);
    final Stream<Integer> testStream = testList.stream();

    testStream.forEach(s -> System.out.print(s));
    System.out.println();
  }

  public static void anyMatchTest() {
    final List<Integer> testList = List.of(1, 2, 3, 4, 5);
    final Stream<Integer> testStream = testList.stream();

    boolean anyMatch = testStream.anyMatch(s -> {
      return s == 1;
    });

    System.out.println("Any match = " + anyMatch);
  }

  public static void filterTest() {
    final List<Integer> testList = List.of(1, 1, 3, 4, 5);
    final Stream<Integer> testStream = testList.stream();

    testStream.filter(s -> s == 1).forEach(s -> System.out.print(s));
    System.out.println();
  }

  public static void intStreamTest() {
    IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
    Stream<Integer> integerStream = intStream.boxed();
    IntStream intStream2 = integerStream.mapToInt(Integer::intValue);
    Stream<String> stringStream = intStream2.mapToObj(i -> "num: " + i);

    System.out.println(stringStream.reduce("", String::concat));
  }

  public static void spliteratorTest() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    Spliterator<Integer> spliterator1 = numbers.spliterator();
    Spliterator<Integer> spliterator2 = spliterator1.trySplit();

    System.out.println("First part:");
    if (spliterator2 != null) {
      spliterator2.forEachRemaining(System.out::println);
    }

    System.out.println("Second part:");
    spliterator1.forEachRemaining(System.out::println);
  }

  public static void collectTest() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6);
    final Stream<Integer> testStream = numbers.stream();

    testStream.collect(Collectors.toSet()).stream().forEach(s -> System.out.println(s));
  }

  public static void partitionByTest() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    Map<Boolean, List<Integer>> partitioned = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
    System.out.println("Even: " + partitioned.get(true));
    System.out.println("Odd: " + partitioned.get(false));
  }

  public static void flatMapTest() {
    List<Integer> numbers1 = List.of(1, 2, 3);
    List<Integer> numbers2 = List.of(4, 5, 6);
    List<Integer> numbers3 = List.of(7, 8, 9);

    Stream.of(numbers1, numbers2, numbers3).flatMap(s -> s.stream()).forEach(y -> {
      System.out.println("flat map test is: %d".formatted(y));
    });

  }
}
