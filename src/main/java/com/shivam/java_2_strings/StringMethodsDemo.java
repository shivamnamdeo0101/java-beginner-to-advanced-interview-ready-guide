package com.shivam.java_2_strings;

// ==========================================================
// JAVA STRING METHODS
// ==========================================================
// WHAT:
// Methods provided by String class to perform operations like
// access, comparison, manipulation, conversion, searching, etc.
//
// WHY:
// Java Strings are immutable, so methods return new strings
// or values without modifying the original string.
//
// PROS:
// - Built-in, convenient, readable
// - Thread-safe (immutable String)
// - Works with Unicode and supports chaining
//
// CONS:
// - Immutable → many modifications create new objects (use StringBuilder/StringBuffer for heavy changes)
// ==========================================================

public class StringMethodsDemo {
    public static void main(String[] args) {
        String str = "Hello World";
        String str2 = "HELLO World";

        // 1. length() → number of characters
        System.out.println("Length: " + str.length()); // 15 (includes spaces)

        // 2. charAt(i) → character at index i
        System.out.println("charAt(6): " + str.charAt(6)); // 'W'

        // 3. substring(i) → substring from index i to end
        System.out.println("substring(6): " + str.substring(6)); // "World"

        // 4. substring(i,j) → substring from index i to j-1
        System.out.println("substring(2,7): " + str.substring(2,7)); // "llo W"

        // 5. concat(str) → concatenates another string
        System.out.println("concat: " + str.concat(" Java")); // " Hello World Java"

        // 6. indexOf(str) → first occurrence of substring
        System.out.println("indexOf(\"o\"): " + str.indexOf("o")); // 4

        // 7. indexOf(str, i) → first occurrence from index i
        System.out.println("indexOf(\"o\",5): " + str.indexOf("o",5)); // 7

        // 8. lastIndexOf(str) → last occurrence
        System.out.println("lastIndexOf(\"o\"): " + str.lastIndexOf("o")); // 7

        // 9. equals(obj) → compare content
        System.out.println("equals: " + str.equals(str2)); // false

        // 10. equalsIgnoreCase(str) → compare ignoring case
        System.out.println("equalsIgnoreCase: " + str.equalsIgnoreCase(str2)); // true

        // 11. compareTo(str) → lexicographical comparison
        System.out.println("compareTo: " + str.compareTo(str2)); // positive value (based on Unicode)

        // 12. compareToIgnoreCase(str) → lexicographical ignoring case
        System.out.println("compareToIgnoreCase: " + str.compareToIgnoreCase(str2)); // 0

        // 13. toLowerCase() → convert to lowercase
        System.out.println("toLowerCase: " + str.toLowerCase()); // "  hello world  "

        // 14. toUpperCase() → convert to uppercase
        System.out.println("toUpperCase: " + str.toUpperCase()); // "  HELLO WORLD  "

        // 15. trim() → remove leading/trailing spaces
        System.out.println("trim: '" + str.trim() + "'"); // "Hello World"

        // 16. replace(oldChar, newChar) → replace characters
        System.out.println("replace: " + str.replace('l','x')); // "  Hexxo Worxd  "

        // 17. contains(CharSequence) → check if contains substring
        System.out.println("contains(\"World\"): " + str.contains("World")); // true

        // 18. toCharArray() → convert string to char array
        char[] chars = str.toCharArray();
        System.out.print("toCharArray: ");
        for(char c : chars) System.out.print(c + " ");
        System.out.println();

        // 19. startsWith(prefix) → check start
        System.out.println("startsWith(\"  He\"): " + str.startsWith("He")); // true
    }
}

/*
✅ Notes:
- Strings are immutable → all methods that modify return new String.
- Use StringBuilder/StringBuffer for heavy modifications to improve performance.
- Most search/compare methods are case-sensitive unless ignoreCase variant is used.
- trim() only removes leading/trailing whitespaces.
*/

