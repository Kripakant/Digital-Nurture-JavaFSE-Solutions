package strings;

/**
 * Demonstrates String handling, immutability, common methods,
 * StringBuilder, and String formatting.
 */
public class StringDemo {

    public static void main(String[] args) {
        commonMethods();
        immutabilityDemo();
        stringBuilderDemo();
        palindromeCheck("madam");
        palindromeCheck("hello");
        wordCount("the quick brown fox the");
    }

    static void commonMethods() {
        System.out.println("=== Common String methods ===");
        String s = "  Digital Nurture  ";
        System.out.println("Original    : '" + s + "'");
        System.out.println("trim()      : '" + s.trim() + "'");
        System.out.println("toUpperCase : " + s.trim().toUpperCase());
        System.out.println("length()    : " + s.trim().length());
        System.out.println("substring() : " + s.trim().substring(0, 7));
        System.out.println("replace()   : " + s.trim().replace("Nurture", "FSE"));
        System.out.println("split()     :");
        for (String part : s.trim().split(" ")) {
            System.out.println("   " + part);
        }
        System.out.println("contains    : " + s.contains("Nurture"));
        System.out.println();
    }

    static void immutabilityDemo() {
        System.out.println("=== Immutability ===");
        String a = "Java";
        String b = a.concat(" FSE");   // creates a NEW string
        System.out.println("a (unchanged): " + a);
        System.out.println("b (new)      : " + b);
        System.out.println("a == \"Java\" (pool): " + (a == "Java"));
        System.out.println();
    }

    static void stringBuilderDemo() {
        System.out.println("=== StringBuilder (mutable) ===");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(0, ">> ");
        sb.reverse();
        System.out.println("Reversed: " + sb);
        System.out.println();
    }

    static void palindromeCheck(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        System.out.println("'" + word + "' palindrome? " + isPalindrome);
    }

    static void wordCount(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        System.out.println("\nWord count of \"" + sentence + "\" = " + words.length);
    }
}
