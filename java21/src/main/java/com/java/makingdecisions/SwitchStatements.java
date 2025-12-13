package com.java.makingdecisions;

public class SwitchStatements {

    public static void main(String[] args) {
        String day = "MONDAY";

        switch (day) {
            case "MONDAY" -> System.out.println("Start of the work week.");
            case "FRIDAY" -> System.out.println("End of the work week.");
            case "SATURDAY", "SUNDAY" -> System.out.println("It's the weekend!");
            default -> System.out.println("Midweek days are so-so.");
        }

        String dayOfWeek = switch (day) {
            case null -> "day is null";
            case String s when s.equals("MONDAY") -> "Today is Monday";
            default -> "Every other day";
        };
        System.out.println(dayOfWeek);
    }

}
