package java8;

import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        System.out.println(s.length());
        for (int i = 0; i < s.length() && (i+k)<=s.length(); i++) {
            System.out.println("i+k "+(i+k));
            String substring = s.substring(i,i+k);
            if(smallest=="" || smallest.compareTo(substring) > 0){
                smallest = substring;
            }
            if(largest== "" || largest.compareTo(substring)<0){
                largest = substring;
            }

        }
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = 3;

      
        System.out.println(getSmallestAndLargest(s, k));
    }
}