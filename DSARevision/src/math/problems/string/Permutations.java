package math.problems.string;

import java.util.ArrayList;
import java.util.List;

//Problem: Find all possible permutations of a string using recursion.

//Logic: 
//Base case: If the string is empty, return an empty list.
//Recursive case: For each character in the string, add it to the beginning of every permutation and add the permutation without the current character.

//Algorithm:
//1. Define a function getPermutations(str).
//2. If the string is empty, return an empty list.
//3. Otherwise, for each character in the string, add it to the beginning of every permutation and add the permutation without the current character.

public class Permutations {

    public static void main(String[] args) {    

        String str = "abc";
        List<String> result = getPermutations(str);
        System.out.println(result);

    }

    public static List<String> getPermutations(String str) {
        //base case
        if(str.isEmpty()){
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        List<String> permutations = new ArrayList<>();
        for(int i=0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            String remainingChars = str.substring(0, i) + str.substring(i+1);
            List<String> remainingPermutations = getPermutations(remainingChars);
            for(String perm : remainingPermutations){
                permutations.add(currentChar + perm);
            }
        }
        return permutations;
    }

}
