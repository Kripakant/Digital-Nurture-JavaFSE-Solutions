# Module 3 – Core Java

Core Java programs for **Module 3** of the Digital Nurture Java FSE program.
Each topic lives in its own package under `src/` and has a runnable `main()`.

## 📂 Structure

```
src/
├── basics/      BasicsDemo.java        # data types, operators, control flow, loops
├── oop/         OOPDemo.java           # encapsulation, inheritance, polymorphism, abstraction
│                InterfaceDemo.java     # interfaces & default methods
├── collections/ CollectionsDemo.java   # List, Set, Map, Queue, sorting
├── exceptions/  ExceptionDemo.java     # try/catch/finally, custom exceptions
├── strings/     StringDemo.java        # String methods, immutability, StringBuilder
├── generics/    GenericsDemo.java      # generic class/method, bounded types
└── functional/  StreamLambdaDemo.java  # lambdas, functional interfaces, Stream API
```

## 📝 Topics Covered

| Package | Concepts |
|---------|----------|
| `basics` | Primitives, operators, `if/else`, `switch`, `for/while` loops |
| `oop` | 4 pillars of OOP, abstract classes, interfaces, default methods |
| `collections` | `ArrayList`, `HashSet`/`TreeSet`, `HashMap`, `Queue`, `Comparator` |
| `exceptions` | Checked/unchecked exceptions, multi-catch, custom exception, `finally` |
| `strings` | Common methods, immutability, `StringBuilder`, palindrome, word count |
| `generics` | Generic class, generic method, bounded type parameters |
| `functional` | Lambdas, `Predicate`/`Function`/`Consumer`, method references, Streams, Collectors |

## ▶️ How to Compile & Run

```bash
# from Module3-CoreJava/
javac -d out $(find src -name "*.java")     # compile all
java -cp out oop.OOPDemo                     # run a specific demo
java -cp out functional.StreamLambdaDemo
```

> Verified with **JDK 17+** (developed on JDK 26). Uses switch expressions and the Stream API.

---
*Module 3 completed as part of Digital Nurture Java FSE upskilling.*
