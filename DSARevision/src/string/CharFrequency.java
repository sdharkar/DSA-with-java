package string;

import java.util.HashMap;
import java.util.Map;

// Problem: Count the frequency of each character in a string

// Approach: Use a hashmap to store the frequency of each character

// Edge cases:
// 1. Empty string
// 2. String with only one character
// 3. String with only one character repeated

// Time complexity: O(n)
// Space complexity: O(n)

public class CharFrequency {

    public static Map<Character, Integer> countFrequency(String str){
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char c : str.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
        }
        return frequencyMap;
    }

    public static void main(String[] args){
        String str = "Hello world";
        Map<Character, Integer> frequencyMap = countFrequency(str);
        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }

}
