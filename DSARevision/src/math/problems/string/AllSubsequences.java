package math.problems.string;

import java.util.ArrayList;
import java.util.List;

//problem: Find all possible subsequences of a string using recursion.

//logic: 
//Base case: If the string is empty, return an empty list.
//Recursive case: For each character in the string, add it to the beginning of every subsequence and add the subsequence without the current character.

//algorithm:
//1. Define a function allSubsequences(str).
//2. If the string is empty, return an empty list.
//3. Otherwise, for each character in the string, add it to the beginning of every subsequence and add the subsequence without the current character.

public class AllSubsequences {

    public static void main(String[] args) {

        String str = "abc";
        List<String> result = allSubsequences(str);
        System.out.println(result);


    }

    public static List<String> allSubsequences(String str) {
        if(str.isEmpty()){
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        char firstChar = str.charAt(0);
        List<String> result = allSubsequences(str.substring(1));
        List<String> myResult = new ArrayList<>();
        for(String s : result){
            myResult.add(s);
            myResult.add(firstChar + s);
        }
        return myResult;
    }

}
