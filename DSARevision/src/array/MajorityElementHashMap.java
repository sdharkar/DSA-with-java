package array;

//Problem: Find the majority element in an array using hashmap.

//Logic & Algorithm: 
//1. Create a HashMap to store the frequency of each element in the array.
//2. Iterate through the array and update the frequency of each element in the HashMap.
//3. Iterate through the HashMap and find the element with the highest frequency.

//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.HashMap;
import java.util.Map;

public class MajorityElementHashMap {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority element is: "+majorityElement(nums));

    }

    public static int majorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+ 1); //getOrDefault method returns the value of the key if it is present in the map, otherwise it returns the default value 0
        }

        int n = nums.length;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){//entrySet method returns a Set view of the entries contained in this map
            if(entry.getValue() > n/2){ //if the value of the entry is greater than the number of elements in the array divided by 2
                return entry.getKey();
            }
        }
        return -1;
    }

}
