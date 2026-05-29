// Exercise 38: Decompile a Class File
// Objective: Reverse engineer compiled Java bytecode.
//
// STEPS:
//   1. Compile this program:
//        javac -d out src/Exercise38_DecompileDemo.java
//   2. Decompile the resulting Exercise38_DecompileDemo.class using a tool:
//        - CFR (command line):   java -jar cfr.jar out/Exercise38_DecompileDemo.class
//        - JD-GUI (GUI):         open the .class file in the JD-GUI window
//        - Fernflower / Procyon: similar command-line usage
//   3. Compare the decompiled source with this original file.
//
// WHAT YOU WILL OBSERVE:
//   - Local variable names may be lost / renamed (e.g., to var1, var2)
//     unless compiled with `javac -g` (debug info).
//   - String concatenation may appear as StringBuilder / invokedynamic calls.
//   - The enhanced for-loop may be rewritten as an index-based / iterator loop.
//   - Comments are gone (they are not stored in .class files).
public class Exercise38_DecompileDemo {

    private final String secret = "decompile-me";

    public int sumArray(int[] numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    public String reveal() {
        return "The secret is: " + secret;
    }

    public static void main(String[] args) {
        Exercise38_DecompileDemo demo = new Exercise38_DecompileDemo();
        int[] data = {10, 20, 30};
        System.out.println("Sum = " + demo.sumArray(data));
        System.out.println(demo.reveal());
        System.out.println("Now decompile Exercise38_DecompileDemo.class with CFR or JD-GUI.");
    }
}
