package com.shivam.java_8_exception_handling;

// ==========================
// JAVA EXCEPTION HANDLING
// ==========================

// 1. WHAT
/*
- Exception Handling is a mechanism to handle runtime errors in Java.
- Ensures normal program flow even when unexpected events occur.
- Uses: try, catch, throw, throws, finally.
*/

// 2. WHY
/*
- Prevents abrupt termination of program.
- Provides robust and fault-tolerant applications.
- Separates normal logic from error-handling logic.
*/

// 3. WHEN
/*
- Invalid input
- File/DB/Network errors
- Divide by zero
- NullPointer issues
- Array out of bounds
*/

// 4. TYPES OF EXCEPTIONS
/*
1. Checked (Compile-time) → Must be handled/declared
   e.g., IOException, SQLException, ClassNotFoundException
2. Unchecked (Runtime) → Handled optionally
   e.g., ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException
3. User-defined → Custom exception classes extending Exception
*/

// ==========================
// 5. EXAMPLES
// ==========================

class ExceptionDemo {

    // Checked Exception Example
    static void checkedExample() throws java.io.FileNotFoundException {
        java.io.FileReader fr = new java.io.FileReader("missing.txt");
    }

    // Unchecked Exception Example
    static void uncheckedExample() {
        int a = 10 / 0; // ArithmeticException
    }

    // User-Defined Exception
    static class MyException extends Exception {
        MyException(String msg) { super(msg); }
    }

    static void throwCustom() throws MyException {
        throw new MyException("This is a custom exception!");
    }

    public static void main(String[] args) {
        // TRY-CATCH Block
        try {
            int res = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Finally always executes!");
        }

        // Multiple Catch
        try {
            int[] arr = new int[2];
            arr[5] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error!");
        } catch (Exception e) {
            System.out.println("General exception caught!");
        }

        // Nested Try-Catch
        try {
            try {
                String s = null;
                System.out.println(s.length()); // NullPointerException
            } catch (NullPointerException e) {
                System.out.println("Inner catch: " + e);
            }
            int a = 5 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: " + e);
        }

        // Throw & Throws (Checked Exception Example)
        try {
            checkedExample();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Checked Exception: File not found!");
        }

        // User-defined Exception
        try {
            throwCustom();
        } catch (MyException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }
}

/*
==========================
EXPECTED OUTPUT (sample)
==========================
Error: / by zero
Finally always executes!
Array index error!
Inner catch: java.lang.NullPointerException
Outer catch: java.lang.ArithmeticException: / by zero
Checked Exception: File not found!
Caught custom exception: This is a custom exception!

==========================
FLOW DESCRIPTION
==========================
1. try → risky code (division by zero).
2. catch → handles ArithmeticException.
3. finally → always runs.
4. Multiple catch → chooses specific ArrayIndexOutOfBoundsException.
5. Nested try → inner catch handles NullPointer, outer catch handles ArithmeticException.
6. checkedExample() → throws FileNotFoundException, handled by catch.
7. throwCustom() → throws user-defined MyException, caught successfully.
*/

// ==========================
// 6. FINAL, FINALLY, FINALIZE
/*
- final → keyword (constant, final class, final method) Prevent modification of variables, inheritance of classes or overriding of methods.
- finally → block (always executes after try/catch)
- finalize() → method of object class called by Garbage Collector before object destruction
*/

// ==========================
// 7. RULES
/*
- More specific catch before general catch.
- finally always runs (except System.exit()).
- throw used to explicitly throw exception.
- throws used in method signature to declare exception.
*/

// ==========================
// 8. PROS
/*
- Robust, fault-tolerant code.
- Separates normal logic from error-handling.
- Cleaner error reporting.
*/

// 9. CONS
/*
- Overuse can reduce readability.
- Performance overhead.
- Too many nested try-catch blocks become messy.
*/

