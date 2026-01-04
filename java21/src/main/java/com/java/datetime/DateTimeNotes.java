package com.java.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class DateTimeNotes {

  public static void main(String[] args) {
    dateTest();
    timeTest();
    dateTimeTest();
    combineDateTime();
    zonedDateTimeTest();

  }

  public static void dateTest() {
    LocalDate date = LocalDate.now();
    System.out.println("Current Date: " + date);

    LocalDate specificDate = LocalDate.of(2024, 12, 25);
    System.out.println("Specific Date: " + specificDate);

    LocalDate parsedDate = LocalDate.parse("2024-07-04");
    System.out.println("Parsed Date: " + parsedDate);

    LocalDate nextWeek = date.plusWeeks(1);
    System.out.println("Date after one week: " + nextWeek);

    LocalDate previousMonth = date.minusMonths(1);
    System.out.println("Date one month ago: " + previousMonth);
  }

  public static void timeTest() {
    LocalTime time = LocalTime.now();
    System.out.println("Current Time: " + time);

    LocalTime specificTime = LocalTime.of(14, 30, 0);
    System.out.println("Specific Time: " + specificTime);

    LocalTime parsedTime = LocalTime.parse("09:15:00");
    System.out.println("Parsed Time: " + parsedTime);

    LocalTime plusHours = time.plusHours(2);
    System.out.println("Time after two hours: " + plusHours);

    LocalTime minusMinutes = time.minusMinutes(30);
    System.out.println("Time thirty minutes ago: " + minusMinutes);
  }

  public static void dateTimeTest() {
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println("Current DateTime: " + dateTime);

    LocalDateTime specificDateTime = LocalDateTime.of(2024, 12, 31, 23, 59);
    System.out.println("Specific DateTime: " + specificDateTime);

    LocalDateTime parsedDateTime = LocalDateTime.parse("2024-08-15T10:20:30");
    System.out.println("Parsed DateTime: " + parsedDateTime);

    LocalDateTime plusDays = dateTime.plusDays(10);
    System.out.println("DateTime after ten days: " + plusDays);

    LocalDateTime minusHours = dateTime.minusHours(5);
    System.out.println("DateTime five hours ago: " + minusHours);
  }

  public static void combineDateTime() {
    LocalDate date = LocalDate.of(2024, 11, 5);
    LocalTime time = LocalTime.of(16, 45);
    LocalDateTime combinedDateTime = LocalDateTime.of(date, time);
    System.out.println("Combined DateTime: " + combinedDateTime);
  }

  public static void zonedDateTimeTest() {
    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    System.out.println("Current ZonedDateTime: " + zonedDateTime);

    ZonedDateTime specificZonedDateTime = ZonedDateTime.parse("2024-09-01T12:00:00+02:00[Europe/Berlin]");
    System.out.println("Specific ZonedDateTime: " + specificZonedDateTime);

    LocalDateTime localDateTime = LocalDateTime.now();
    ZonedDateTime fromLocal = localDateTime.atZone(zonedDateTime.getZone());
    System.out.println("ZonedDateTime from LocalDateTime: " + fromLocal);

    ZonedDateTime newYorkZonedDateTime = localDateTime.atZone(java.time.ZoneId.of("America/New_York"));
    System.out.println("ZonedDateTime in New York: " + newYorkZonedDateTime);

  }
}
