// Exercise 37: Using javap to Inspect Bytecode
// Objective: Explore compiled .class files.
//
// STEPS TO INSPECT THE BYTECODE:
//   1. Compile this file:
//        javac -d out src/Exercise37_JavapInspect.java
//   2. Disassemble the bytecode:
//        javap -c -p Exercise37_JavapInspect          (from inside the out/ dir)
//      Or with verbose detail (constant pool, stack map, etc.):
//        javap -c -p -v Exercise37_JavapInspect
//
// INTERPRETING THE OUTPUT:
//   - The `add` method below compiles to bytecode such as:
//       iload_0      // push first int argument onto operand stack
//       iload_1      // push second int argument
//       iadd         // pop both, push their sum
//       ireturn      // return the int on top of the stack
//   - `javap -c` shows each method's instructions; `-v` adds the constant pool,
//     access flags, and verification metadata.
public class Exercise37_JavapInspect {

    // A simple method whose bytecode is easy to read with javap -c.
    public int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        Exercise37_JavapInspect demo = new Exercise37_JavapInspect();
        System.out.println("add(3, 4) = " + demo.add(3, 4));
        System.out.println(demo.greet("Java"));
        System.out.println("Now run: javap -c -p Exercise37_JavapInspect");
    }
}
