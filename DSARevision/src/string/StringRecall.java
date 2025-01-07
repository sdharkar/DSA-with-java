package string;

//String is a sequence of characters.
//String is immutable, meaning that once a String object is created, its value cannot be changed.
//String is a final class, meaning that it cannot be extended.


public class StringRecall {

    public static void main(String[] args) {

        String str = "  Hello, World!  ";
        String str2 = "java";
        String str3 = "Hello, World!"; //Same as str, but no spaces

        String str4 = "Hello, java";


        System.out.println("Original String: \"" + str + "\"");

        // 1. Length
        System.out.println("\n--- Length ---");
        System.out.println("Length: " + str.length());

        // 2. Trimming whitespace
        System.out.println("\n--- Trimming ---");
        System.out.println("Trimmed: \"" + str.trim() + "\"");

        // 3. Case conversion
        System.out.println("\n--- Case Conversion ---");
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());


        // 4. Character access
        System.out.println("\n--- Character Access ---");
        System.out.println("Character at index 0: " + str.charAt(0));
        try{
            System.out.println("Character at index 100: " + str.charAt(100));
        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("Error: Index out of bounds!");
        }
        //5. Substring
        System.out.println("\n--- Substring ---");
        System.out.println("Substring from index 7: " + str.substring(7));
        System.out.println("Substring from index 2 to 5: " + str.substring(2, 6)); //End index exclusive

        //6. Index of
        System.out.println("\n--- Index Of ---");
        System.out.println("Index of 'o': " + str.indexOf('o')); //First occurence
        System.out.println("Index of 'o' from index 5: " + str.indexOf('o', 5)); //Search from given index
        System.out.println("Last index of 'o': " + str.lastIndexOf('o'));

        //7. String Comparison
        System.out.println("\n--- String Comparison ---");
        System.out.println("str == str3: " + (str.equals(str3))); // Compare content
        System.out.println("str == str3 (Ignoring Case): " + str.equalsIgnoreCase(str3)); // Compare content ignoring case
        System.out.println("str == str4: " + str.equals(str4)); //Compare content
        System.out.println("str == str3: " + (str == str3)); //Compare references (usually false unless String pooling is involved)
        System.out.println("str.compareTo(str2) : " + str.compareTo(str2)); //Lexicographical Comparison


        // 8. String replacement
        System.out.println("\n--- String Replacement ---");
        System.out.println("Replace 'World' with 'Universe': " + str.replace("World", "Universe"));
        System.out.println("Replace all 'o' with '0': " + str.replace('o','0'));

        //9. String Concatenation
        System.out.println("\n--- String Concatenation ---");
        System.out.println("Concatenation of str and str2: " + str.concat(str2));
        System.out.println("Concatenation with + : " + str + " " + str2);

        // 10. Splitting String
        System.out.println("\n--- String Splitting ---");
        String[] parts = str.trim().split(","); //Splits around the comma
        for (String part : parts) {
            System.out.println("Part: " + part);
        }

        // 11. Starts with, Ends with
        System.out.println("\n--- Starts and Ends with ---");
        System.out.println("Starts with ' H' ? " + str.startsWith(" H"));
        System.out.println("Ends with '!' ? " + str.endsWith("!"));

        //12. Contains
        System.out.println("\n--- Contains ---");
        System.out.println("Contains 'World' ? " + str.contains("World"));
        System.out.println("Contains 'java' ? " + str.contains("java"));

        //13. String Empty/Blank Check
        String emptyStr = "";
        String blankStr = "  ";
        System.out.println("\n--- Empty/Blank Check ---");
        System.out.println("Empty string: " + emptyStr.isEmpty()); // True for ""
        System.out.println("Blank string is empty? " + blankStr.isEmpty()); //False for "  "
        System.out.println("Blank string is blank? " + blankStr.isBlank()); //True for "   "


    }
}