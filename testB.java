You are given a string S consisting of N lowercase letters of the English alphabet. Find the length of the longest substring of Sin which the number of occurrences of each letter is equal. 

For example, given S = 'ababbcbc", substrings in which every letter occurs the same number of times are: "a", "b", "c", "ab", "ba", "bb", "bo", "cb", "abab" and "bcbc". The longest among them are "abab" and "bcbc" and their length equals 4. Write a function: int solution(string &S); that, given the string S of length N, returns the length of the longest substring in which the number of occurrences of each letter is equal. Examples: 1. Given S = "ababbcbc", the function should return 4, as explained above. 2. Given S = "aabcde", the function should return 5. The longest substring is "abcde", in which all letters occur once. 3. Given S = "aaaa", the function should return 4.


Write a function that, given the string S of length N, returns the length of the longest substring in which the number of occurrences of each letter is equal. 
Examples: 
1. Given S = "ababbcbc", the function should return 4, as explained above. 
2. Given S = "aabcde", the function should return 5. The longest substring is "abcde", in which all letters occur once. 
3. Given S = "aaaa", the function should return 4. The longest substring is 'aaaa', in which all letters occur four times. 
4. Given S = "daababbd", the function should return 6. The longest substring is 'aababb", in which all letters occur three times. Assume that: N is an integer within the range [1..80); string S consists only of lowercase letters (a-z). In your solution, focus on correctness.

public static int solution(String S){
    // write your code in Java SE 8
    int i = 0;
    int j = 0;
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    while(i < S.length()){
        if(map.containsKey(S.charAt(i))){
            map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
        }
        else{
            map.put(S.charAt(i), 1);
        }
        i++;
        while(j < S.length()){
            if(map.containsKey(S.charAt(j))){
                map.put(S.charAt(j), map.get(S.charAt(j)) - 1);
            }
            else{
                map.put(S.charAt(j), -1);
            }
            j++;
            if(map.values().stream().allMatch(x -> x == 0)){
                max = Math.max(max, j - i);
            }
        }
        j = i;
        map.clear();
    }
    return max;
}