package com.shivam.java_2_strings;

// ==========================================================
// JAVA STRINGS, MEMORY & RELATED CLASSES
// ==========================================================
// This code explains:
// - String Pool
// - PermGen / Metaspace
// - Heap memory
// - Ways of creating Strings
// - Interfaces and Classes: String, StringBuffer, StringBuilder, CharSequence, StringTokenizer
// - How Strings are stored in memory
// ==========================================================

import java.util.StringTokenizer;

public class JavaStringConcepts {

    public static void main(String[] args) {

        // ==========================================================
        // 1. JAVA STRING
        // ==========================================================
        // WHAT: Immutable sequence of characters
        // WHY: Why Java Strings are Immutable? - Ans - Efficient memory use, security, thread-safe
        // HOW: Stored in String Pool (for literals) or Heap (for new String())
        // RULES: String objects are immutable; use .equals() to compare content
        // PROS: Immutable, cached in String Pool, efficient
        // CONS: Immutable → every modification creates new object
        // WHEN: Use for constant text, keys, configuration

//        Multi-threaded read-only → String
//        Multi-threaded write → StringBuffer or manual synchronization of StringBuilder

        String s1 = "Hello";          // Stored in String Pool
        String s2 = new String("Hello"); // Stored in Heap
        System.out.println("s1==s2? " + (s1==s2)); // false (different references)
        System.out.println("s1.equals(s2)? " + s1.equals(s2)); // true

        // ==========================================================
        // 2. WAYS TO CREATE STRING
        // ==========================================================
        String literal = "Java";        // String Pool
        String objectStr = new String("Java"); // Heap
        char[] arr = {'J','a','v','a'};
        String fromCharArray = new String(arr); // Heap

        // ==========================================================
        // 3. MEMORY CONCEPTS
        // ==========================================================
        // Heap → All objects (new String(), StringBuffer, StringBuilder)
        // String Pool → Special memory inside Heap for string literals (interned)
        // PermGen / Metaspace → Stores class metadata, method info, string constants
        // JVM memory divided into:
        // - Heap (Young Gen + Old Gen)
        // - Stack (local variables)
        // - PermGen / Metaspace (class info)

        // ==========================================================
        // 4. INTERFACES AND CLASSES
        // ==========================================================
        // a) CharSequence → Interface implemented by String, StringBuilder, StringBuffer
        CharSequence cs = "CharSeq";
        System.out.println("CharSequence: " + cs);

        // b) StringBuffer → Mutable, synchronized (thread-safe)
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World");
        System.out.println("StringBuffer: " + sb);

        // c) StringBuilder → Mutable, NOT synchronized (faster)-----Ex Stock price val need to be sync by multiple thread and need updated valiues always
        StringBuilder sbuilder = new StringBuilder("Hello");
        sbuilder.append(" Builder");
        System.out.println("StringBuilder: " + sbuilder);

        // d) StringTokenizer → Split string into tokens
        StringTokenizer st = new StringTokenizer("Java is fun", " ");
        System.out.print("Tokens: ");
        while(st.hasMoreTokens()) {
            System.out.print(st.nextToken() + " ");
        }
        System.out.println();

        // ==========================================================
        // 5. HOW STRINGS ARE STORED
        // ==========================================================
        // - String literals → Stored in String Pool (interned)
        // - new String() → Stored in Heap, separate object
        // - StringBuffer/StringBuilder → Heap, mutable
        // - Immutable → Modification creates new object in Heap/Pool

        // Example of String Pool vs Heap
        String a = "abc";          // Pool
        String b = "abc";          // Pool (same as 'a')
        String c = new String("abc"); // Heap (different reference)
        System.out.println("a==b? " + (a==b)); // true
        System.out.println("a==c? " + (a==c)); // false

        //String concat
        // String Initialization
        String s = "Shivam";

        // Use concat() method for string concatenation
        s = s.concat("Namdeo");
        System.out.println(s);

        // ==========================================================
        // 6. SUMMARY TABLE
        // ==========================================================
        /*
        Concept                  | WHAT                         | PROS                       | CONS                       | RULES
        -------------------------|------------------------------|----------------------------|----------------------------|---------------------------
        String                   | Immutable char sequence      | Thread-safe, cached        | Immutable, slow concat     | Use equals() for content
        StringBuffer             | Mutable string, synchronized| Thread-safe, mutable       | Slower than StringBuilder  | append(), insert() modify
        StringBuilder            | Mutable string, not sync     | Faster, mutable            | Not thread-safe             | append(), insert() modify
        CharSequence             | Interface                     | Flexible, common type      | Only abstract methods      | Implemented by String classes
        StringTokenizer          | Tokenize strings              | Simple parsing             | Legacy, less flexible      | Uses delimiter
        String Pool              | Pool of literals             | Memory efficient, reuse    | Limited to literals        | Use intern() to force pool
        Heap                     | Memory for objects           | Stores all dynamic objects | GC overhead                | Standard object allocation
        PermGen / Metaspace      | Class metadata, constants    | JVM optimization           | Fixed size in PermGen (old) | JVM managed
        */
    }
}

