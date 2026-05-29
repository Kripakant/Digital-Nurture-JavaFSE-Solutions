# Exercise 34 — Java Modules Demo

Two modules demonstrating the Java Platform Module System (JPMS):

- **com.utils** — exports a `StringUtils` utility class.
- **com.greetings** — `requires com.utils` and uses `StringUtils` from `Main`.

## Directory structure

```
modules-demo/
├── com.utils/
│   ├── module-info.java            (exports com.utils)
│   └── com/utils/StringUtils.java
└── com.greetings/
    ├── module-info.java            (requires com.utils)
    └── com/greetings/Main.java
```

## Compile

Run these from inside the `modules-demo/` folder.

```bash
# 1. Compile the com.utils module into mods/com.utils
javac -d mods/com.utils com.utils/module-info.java com.utils/com/utils/StringUtils.java

# 2. Compile com.greetings against com.utils (using the module path)
javac --module-path mods -d mods/com.greetings com.greetings/module-info.java com.greetings/com/greetings/Main.java
```

## Run

```bash
java --module-path mods --module com.greetings/com.greetings.Main
```

### Expected output

```
HELLO FROM MODULES
====================
com.greetings successfully used com.utils!
```

> Note: This module project is kept separate from the `src/` exercises because
> JPMS requires package directories and `module-info.java` files, which is
> incompatible with the single default-package folder used by the other exercises.
