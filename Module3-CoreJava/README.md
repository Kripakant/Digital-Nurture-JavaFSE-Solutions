# Module 3 — Core Java

Solutions for the 41 Core Java exercises of the Cognizant Digital Nurture Java FSE program.

All programs live in [`src/`](src/) in the **default package** (no `package` declaration) so they
can be compiled and run together easily. Each file has a `public` class matching its filename
with a `main` method. Built and tested with **JDK 21+** (developed on JDK 26).

## Exercises

| #  | Title                              | File |
|----|------------------------------------|------|
| 1  | Hello World Program                | `Exercise01_HelloWorld.java` |
| 2  | Simple Calculator                  | `Exercise02_SimpleCalculator.java` |
| 3  | Even or Odd Checker                | `Exercise03_EvenOrOddChecker.java` |
| 4  | Leap Year Checker                  | `Exercise04_LeapYearChecker.java` |
| 5  | Multiplication Table               | `Exercise05_MultiplicationTable.java` |
| 6  | Data Type Demonstration            | `Exercise06_DataTypeDemonstration.java` |
| 7  | Type Casting Example               | `Exercise07_TypeCastingExample.java` |
| 8  | Operator Precedence                | `Exercise08_OperatorPrecedence.java` |
| 9  | Grade Calculator                   | `Exercise09_GradeCalculator.java` |
| 10 | Number Guessing Game               | `Exercise10_NumberGuessingGame.java` |
| 11 | Factorial Calculator               | `Exercise11_FactorialCalculator.java` |
| 12 | Method Overloading                 | `Exercise12_MethodOverloading.java` |
| 13 | Recursive Fibonacci                | `Exercise13_RecursiveFibonacci.java` |
| 14 | Array Sum and Average              | `Exercise14_ArraySumAndAverage.java` |
| 15 | String Reversal                    | `Exercise15_StringReversal.java` |
| 16 | Palindrome Checker                 | `Exercise16_PalindromeChecker.java` |
| 17 | Class and Object Creation          | `Exercise17_ClassAndObjectCreation.java` |
| 18 | Inheritance Example                | `Exercise18_InheritanceExample.java` |
| 19 | Interface Implementation           | `Exercise19_InterfaceImplementation.java` |
| 20 | Try-Catch Example                  | `Exercise20_TryCatchExample.java` |
| 21 | Custom Exception                   | `Exercise21_CustomException.java` |
| 22 | File Writing                       | `Exercise22_FileWriting.java` |
| 23 | File Reading                       | `Exercise23_FileReading.java` |
| 24 | ArrayList Example                  | `Exercise24_ArrayListExample.java` |
| 25 | HashMap Example                    | `Exercise25_HashMapExample.java` |
| 26 | Thread Creation                    | `Exercise26_ThreadCreation.java` |
| 27 | Lambda Expressions                 | `Exercise27_LambdaExpressions.java` |
| 28 | Stream API                         | `Exercise28_StreamAPI.java` |
| 29 | Records                            | `Exercise29_Records.java` |
| 30 | Pattern Matching for switch (Java 21) | `Exercise30_PatternMatchingForSwitch.java` |
| 31 | Basic JDBC Connection              | `Exercise31_BasicJDBCConnection.java` |
| 32 | Insert and Update Operations in JDBC | `Exercise32_InsertAndUpdateJDBC.java` |
| 33 | Transaction Handling in JDBC       | `Exercise33_TransactionHandlingJDBC.java` |
| 34 | Create and Use Java Modules        | `Exercise34_JavaModules.java` (+ [`modules-demo/`](modules-demo/)) |
| 35 | TCP Client-Server Chat             | `Exercise35_TCPChat.java` |
| 36 | HTTP Client API (Java 11+)         | `Exercise36_HTTPClientAPI.java` |
| 37 | Using javap to Inspect Bytecode    | `Exercise37_JavapInspect.java` |
| 38 | Decompile a Class File             | `Exercise38_DecompileDemo.java` |
| 39 | Reflection in Java                 | `Exercise39_Reflection.java` |
| 40 | Virtual Threads (Java 21)          | `Exercise40_VirtualThreads.java` |
| 41 | Executor Service and Callable      | `Exercise41_ExecutorServiceCallable.java` |

## Compile

Compile every exercise into an `out/` directory:

```bash
javac -d out src/*.java
```

## Run

Run any exercise by its class name:

```bash
java -cp out Exercise01_HelloWorld
java -cp out Exercise28_StreamAPI
java -cp out Exercise41_ExecutorServiceCallable
```

Exercises that read input use `Scanner` over `System.in`, so run them interactively.

## Exercises with special setup

| Exercise | Notes |
|----------|-------|
| **31–33 (JDBC)** | Compile against `java.sql.*` only (no vendor driver imported, the driver is loaded via `Class.forName(...)`). To **run**, set up a MySQL database (DDL is in the file headers) and add the MySQL Connector/J JAR to the classpath: `java -cp "out:mysql-connector-j.jar" Exercise31_BasicJDBCConnection`. |
| **34 (Modules)** | Because JPMS conflicts with the single default-package folder, the real two-module project lives in [`modules-demo/`](modules-demo/) (`com.utils` exports `StringUtils`; `com.greetings` requires it). See [`modules-demo/README.md`](modules-demo/README.md) for module-path compile/run commands. `Exercise34_JavaModules.java` in `src/` is a pointer/stub. |
| **35 (TCP Chat)** | Run two terminals: `java -cp out Exercise35_TCPChat server` and `java -cp out Exercise35_TCPChat client`. |
| **36 (HTTP Client)** | Requires network access; calls the public GitHub API. |
| **37 (javap)** | After compiling, inspect bytecode: `javap -c -p Exercise37_JavapInspect` (from inside `out/`). The file header explains the output. |
| **38 (Decompile)** | After compiling, open `out/Exercise38_DecompileDemo.class` in a decompiler (CFR / JD-GUI / Fernflower). The file header explains what to look for. |
| **40 (Virtual Threads)** | Launches 100,000 virtual threads; requires JDK 21+. |
