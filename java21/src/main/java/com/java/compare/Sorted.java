package com.java.compare;

import java.util.Comparator;
import java.util.SequencedSet;
import java.util.TreeSet;

public record Sorted(int num, String text) implements Comparable<Sorted>, Comparator<Sorted> {

  @Override
  public String toString() {
    return "" + num;
  }

  @Override
  public int compareTo(Sorted s) {
    return text.compareTo(s.text);
  }

  @Override
  public int compare(Sorted s1, Sorted s2) {
    return s1.num - s2.num;
  }

  public static void main(String[] args) {
    var s1 = new Sorted(88, "a");
    var s2 = new Sorted(55, "b");

    SequencedSet<Sorted> t1 = new TreeSet<Sorted>();
    t1.add(s1);
    t1.add(s2);

    var t2 = new TreeSet<Sorted>(s1);
    t2.add(s1);
    t2.add(s2);

    System.out.println(t1 + " - " + t2);
  }
}
