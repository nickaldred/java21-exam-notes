# Java 21 Exam: Checked vs. Unchecked Exceptions

## 1. Core Distinction Summary

| Feature | Checked Exceptions | Unchecked Exceptions |
| :--- | :--- | :--- |
| **Compiler Check** | **Mandatory** at compile-time. | **Ignored** at compile-time. |
| **Requirement** | "Handle or Declare" (try/catch or throws). | No handling required. |
| **Typical Cause** | External factors (I/O, network, SQL). | Programming errors (logic, nulls). |
| **Inheritance** | Inherits from `Exception`. | Inherits from `RuntimeException`. |

---

## 2. The Relationship & Hierarchy

All exception classes relate to each other through a single inheritance tree starting at `Throwable`.

* **Throwable**: The root of the tree.
  * **Error** (Unchecked): System-level failures (e.g., `StackOverflowError`).
  * **Exception**: The parent of all checked exceptions.
    * **RuntimeException** (Unchecked): The critical branch. Any subclass of this is **Unchecked**.

---

## 3. Common Checked Exceptions (Must Handle)

| Exception | Context |
| :--- | :--- |
| **`IOException`** | Basic I/O failures (parent of `FileNotFoundException`). |
| **`FileNotFoundException`** | Attempting to open a file that does not exist. |
| **`SQLException`** | Database access errors (JDBC). |
| **`ClassNotFoundException`** | Loading a class via `Class.forName()`. |
| **`InterruptedException`** | A thread is interrupted while in `sleep()` or `wait()`. |

---

## 4. Common Unchecked (Runtime) Exceptions

| Exception | Context |
| :--- | :--- |
| **`NullPointerException`** | Attempting to use a reference that is `null`. |
| **`ArithmeticException`** | Math errors like dividing an integer by zero. |
| **`ClassCastException`** | Casting an object to an incompatible subclass. |
| **`ArrayIndexOutOfBoundsException`** | Using an index `< 0` or `>= array.length`. |
| **`IllegalArgumentException`** | Passing an invalid argument to a method. |
| **`NumberFormatException`** | `Integer.parseInt()` called on a non-numeric string. |
| **`DateTimeException`** | Invalid Date/Time operations (Java 8+ API). |

---

## 5. Critical Exam Rules for Java 21

### A. The "Unreachable Catch" Trick

You cannot catch a **Checked Exception** if the code in the `try` block is not capable of throwing it.

* **Will NOT compile**: `try { System.out.println("Hi"); } catch (IOException e) {}`
* **Will compile**: `try { System.out.println("Hi"); } catch (RuntimeException e) {}` (Unchecked exceptions are exempt from this rule).

### B. Method Overriding Rules

When a child class overrides a method that throws a checked exception:

1. **Narrower is OK**: The child can throw a subclass of the parent's exception or no exception at all.
2. **Broader is NOT OK**: The child cannot throw the parent of the exception (e.g., if parent throws `FileNotFoundException`, child cannot throw `IOException`).
3. **New Checked is NOT OK**: The child cannot throw a new checked exception not declared by the parent.
4. **Runtime is ALWAYS OK**: The child can throw any `RuntimeException` regardless of what the parent declares.
