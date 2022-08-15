Given an integer N, you asked to divide N into a sum of maximal number of positive even integers. All the numbers should also be different.

For example, for N = 12, the following splits are valid :(2 + 10), (2 + 4 + 6) and (4 + 8)/ Among them (2 + 4 + 6) contains the maximal number of integers. Note that N cannot be split into (2 + 2 + 4 + 4) as all the numbers should be different.

Write a function which given a positive number N, returns an array containing the numbers from any maximal possible answer (any valid combination may be returned). If N cannot be divided in such a way, return an empty array.

Result array should be returned as an array of integers.

Examples:
1. Given N = 6, your function should return [2,4] or [4,2].
2. Given N = 7, your function should return [] (an empty array) as there is no valid split.
3. Given N = 22, your function should return [2,4,6,10] in any order.
4. Given N = 4, your function should return [4].



public static List<integer> solution(int N) {
    
}