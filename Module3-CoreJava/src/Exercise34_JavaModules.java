// Exercise 34: Create and Use Java Modules
// Objective: Understand Java's module system.
//
// The Java Platform Module System (JPMS) requires each module to live in its
// own directory with a module-info.java. This CONFLICTS with the "everything
// in the default package in one folder" rule used for the other exercises, so
// the real, runnable module project lives in a separate folder:
//
//     Module3-CoreJava/modules-demo/
//         com.utils/
//             module-info.java          (exports com.utils)
//             com/utils/StringUtils.java
//         com.greetings/
//             module-info.java          (requires com.utils)
//             com/greetings/Main.java
//
// See Module3-CoreJava/modules-demo/README.md for full compile/run commands.
//
// QUICK REFERENCE (run from inside modules-demo/):
//   javac -d mods/com.utils com.utils/module-info.java com.utils/com/utils/StringUtils.java
//   javac --module-path mods -d mods/com.greetings com.greetings/module-info.java com.greetings/com/greetings/Main.java
//   java --module-path mods --module com.greetings/com.greetings.Main
//
// This stub class exists only so the exercise appears in the src/ folder and
// compiles with the rest. The actual demonstration is in modules-demo/.
public class Exercise34_JavaModules {
    public static void main(String[] args) {
        System.out.println("Java Modules demo lives in Module3-CoreJava/modules-demo/");
        System.out.println("See modules-demo/README.md for compile and run instructions.");
    }
}
