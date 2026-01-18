# Useful Material

## Links

- [Helpful Study Cards](https://javaocpquiz.com/)

## Operators

```bash

### PUMA (Highest Precedence)

* P - Primary      (parentheses (), array access [], method invocation .)
* U - Unary        (expr++, expr--, ++expr, --expr, +expr, -expr, ~, !)
* M - Multiplicative (*, /, %)
* A - Additive       (+, -)

### IS
* I - Nothing completes the sentence
* S - Shift operators '<< and >>'

### REBL (Lower Precedence)
* R - Relational     (<, >, <=, >=, instanceof)
* E - Equality       (==, !=)
* B - Bitwise/Binary (&, ^, |)
* L - Logical        (&&, ||)

### TAC

* T - Ternary operator (?:)
* A - Assignment operators (=, +=, -=, *=, etc.)
* C - Comma operator (rare in standard Java, more common in C for loop control)

```

## Core Modules

| Module         | Type        | What it provides / key idea                                    | Exam‑level notes                                                                 |
|----------------|-------------|----------------------------------------------------------------|----------------------------------------------------------------------------------|
| java.base      | Core (java) | Core language & utilities: java.lang, java.util, I/O, time…    | Always present; implicitly required by all modules; never need `requires` it.    |
| java.desktop   | Core (java) | GUI APIs: Swing, AWT, 2D graphics                              | Desktop UI; large, often unused in server apps.                                  |
| java.sql       | Core (java) | JDBC APIs: database access (java.sql, javax.sql)               | Require this for relational DB access.                                           |
| java.xml       | Core (java) | XML processing: DOM, SAX, StAX, XSLT                           | Require this when working with XML.                                              |
| java.logging   | Core (java) | java.util.logging framework                                    | Basic logging API; name matches feature.                                         |
| java.net.http  | Core (java) | Modern HTTP Client API                                         | Network HTTP client; added after Java 8, standard in 21.                         |
| java.management| Core (java) | JMX, management & monitoring                                   | Management/monitoring of JVM/app.                                                |
| java.naming    | Core (java) | JNDI: naming & directory services                              | Naming/directory lookups.                                                        |
| java.instrument| Core (java) | Instrumentation API (bytecode‑modifying agents)                | Used by profilers, coverage tools, etc.                                          |
| java.scripting | Core (java) | Scripting API (javax.script)                                   | Running scripts from Java.                                                       |
| jdk.compiler   | JDK tool    | Compiler APIs (javac)                                          | JDK tool module; not `java.*`.                                                   |
| jdk.javadoc    | JDK tool    | Javadoc tool APIs                                              | JDK tool for documentation generation.                                           |
| jdk.jlink      | JDK tool    | Tool for building custom runtime images from modules           | Important in modularization context.                                             |
| jdk.jfr        | JDK tool    | Java Flight Recorder (profiling & diagnostics)                 | Runtime diagnostics/profiling.                                                   |
