# Test Notes

- In polymorphism, the reference type determines which methods can be called at compile time, but the actual instance type determines which method implementation is executed at runtime.

- While methods in Java are polymorphic and use dynamic linking (based on the instance), instance variables are not polymorphic and use static linking, meaning the reference type alone determines which variable is accessed regardless of the actual object type.

- ```-7Up``` How chars are sorted.

- When a programmer does not define ANY constructor, the compiler inserts one automatically, the access modifier of which is same as that of the class.

- (rangeClosed): IntStream.rangeClosed(1, 3) includes both the start and the end. It contains: [1, 2, 3].

- (boxed): .boxed() converts primitives to objects

- The ExecutorService interface (which is what Executors.newSingleThreadExecutor() returns) has overloaded submit() methods designed specifically to handle both Runnable and Callable tasks.

- In Java, a static nested class (often called a static inner class) is basically a regular class that just happens to be defined inside another class for organisational purposes.

- A pattern variable is not allowed to shadow a local variable.

- A virtual call is a method invocation where the specific implementation to be executed is determined at runtime by the JVM based on the actual object's type, rather than at compile-time based on the reference type.

- In Java, mark() saves the current stream position and reset() returns the cursor to that saved point, allowing the program to re-read the same data multiple times until a new mark is set or the buffer limit is exceeded.

- A Reader can't be converted into a Writer or vice-versa. In other words, there is no way you can chain a Reader and a Writer together.

- A BufferedReader can wrap any Reader.

- Future's get() will block until there is a value to return or there is an exception.

- A synchronized method is similar to any other method except that only one thread can be in it at a given time.

- ConcurrentMap is a Map providing atomic versions of putIfAbsent, remove, and replace methods.

- long, float, double, and boolean can never be used as a switch variable.

- In Java 21, Arrays.compare returns the lexicographical difference between two arrays (negative, zero, or positive), while Arrays.mismatch returns the index of the first differing element (or -1 if they are identical).

- Comparable is compareTo, Comparator is compare.

- Any exception thrown in a static block is wrapped into ExceptionInInitializerError and then that ExceptionInInitializerError is thrown.

- Labeled break or continue statement must always exist inside the loop where the label is declared.

- Java's binarySearch returns the zero-based index if the key is found, or (-(insertion point) - 1) if it is not, where the insertion point is the index of the first element greater than the key (or the array's length).

- You can't apply [ ] to var or the variable being declared using the var declaration.

- static method cannot be overridden by a non-static method and vice versa.

- String is not a sub type of Iterable, and thus, is not covariant with Iterable.

- The return type of the count() method is long.

- Remember that "packages are exported" and "modules are required". A module exports packages to other modules. It cannot export individual classes. On the other hand, a module cannot specify a particular package or a class in the requires clause. It can only specify the name of the module in which the required package exists.

- While an overriding method can only throw narrower exceptions than its parent, a subclass constructor must declare the same or a broader exception than the superclass constructor it calls.

- You may apply public, private, and protected modifiers to a constructor. But not static, final, synchronized, native and abstract. It can also be package private i.e. without any access modifier.

- When you split a Spliterator, the first half goes to the resulting (new) Spliterator while the remaining half remains with the original one.

## Thread states

| State | Description | Transition Trigger |
| :--- | :--- | :--- |
| **New** | Created but not started | `new Thread()` |
| **Runnable** | Ready to run or running | `t.start()` |
| **Blocked** | Waiting for a monitor lock | Attempting to enter `synchronized` code |
| **Waiting** | Waiting indefinitely for another thread | `wait()`, `join()` |
| **Timed Waiting** | Waiting for a specific period | `sleep(n)`, `wait(n)` |
| **Terminated** | Finished execution | Task completion or exception |

## Java C Arguments

| Flag | Argument | Purpose |
| :--- | :--- | :--- |
| `javac` | N/A | The Java compiler tool. |
| `--module-source-path` | `c:\java\a` | Specifies where the source code for your modules is located. |
| `-d` | `c:\java\b` | The destination directory where the compiled `.class` files will be placed. |
| `-p` | `c:\java\c` | The module path; where the compiler looks for compiled library modules or JARs. |
| `-m` | `x.y` | Specifies the specific module name to be compiled (in this case, `x.y`). |

## String vs StringBuilder

| Method Category | String (Returns new String) | StringBuilder (Returns `this`) |
| :--- | :--- | :--- |
| **Searching** | `indexOf()`, `lastIndexOf()` | `indexOf()`, `lastIndexOf()` |
| **Length/Chars** | `length()`, `charAt()` | `length()`, `charAt()`, `setCharAt()` |
| **Sub-sequences** | `substring()` | `substring()` (Note: returns a `String`!) |
| **Addition** | `concat(String)`, `+` operator | `append(anyType)` |
| **Insertion** | N/A | `insert(offset, anyType)` |
| **Removal** | N/A (use `replace` or `substring`) | `delete(start, end)`, `deleteCharAt()` |
| **Modification** | `replace()`, `toLowerCase()`, `trim()` | `replace(start, end, string)`, `reverse()` |
