# Chapter 5 - Methods

## Need to go over

- Package access

## Default methods

In Java, default methods (introduced in Java 8) allow you to add new methods to interfaces with a full method body, without breaking the classes that already implement those interfaces.

```Java
interface Vehicle {
    void drive(); // Standard abstract method

    // Default method
    default void blowHorn() {
        System.out.println("Beep beep!");
    }
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("Car is driving");
    }
    // blowHorn() is automatically available here!
}
```
